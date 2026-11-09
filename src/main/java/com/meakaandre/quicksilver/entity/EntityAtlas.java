package com.meakaandre.quicksilver.entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.textures.AddressMode;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTexture;
import com.mojang.renderpearl.frontend.FrontendCommandEncoder;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.TextureTransform;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.client.renderer.texture.UvMapping;
import net.minecraft.resources.Identifier;

/**
 * Package 6: entity and block-entity draws merged across textures (decided by Andre, 2026-11-06: "shared texture
 * atlas"). 26.3 already merges every model submit of one render type into one draw, so what still splits the feature
 * pass is the texture: each mob, sign wood and the like has its own. This puts those textures into shared atlas pages,
 * lazily (a texture enters a page the first time something submits a model with it), and moves the submit to the same
 * render type bound to the page, with the slot as the model's {@link UvMapping}: the same path vanilla's own chest,
 * shulker and banner sheets take.
 *
 * <p>Exact against vanilla by construction where it can be: only nearest-filtered, single-level, RGBA8 textures loaded
 * plainly from resources ({@link SimpleTexture}), pixels decoded from the same resource vanilla uploaded; a one-texel
 * ring around each slot repeats the texture's own edge (clamp) or opposite edge (repeat), so a coordinate that lands on
 * the texture's border samples what vanilla's sampler would; pages are powers of two. Only render types on the
 * allow-list, with no texture transform (no scrolling or glint), a single texture and no outline colour; a submit that
 * already has a mapping (an atlas sprite) is left alone. A texture that is not ready, or a submit while a render pass is
 * open, takes vanilla's path for that submit. Anything unexpected turns the module off for good (vanilla from then on).
 *
 * <p>Clean room: the idea of an entity texture atlas is common (ImmediatelyFast and others batch by atlas); nothing is
 * copied. Draws only through renderpearl and vanilla's own render types. Render thread only.
 */
public final class EntityAtlas {
    public enum State { STARTING, ON, OFF }

    /** Page size: a power of two, small so the atlas coordinate keeps the precision of the texture's own. */
    static final int PAGE = 512;
    /** Larger textures stay on their own (a page must hold several). */
    static final int MAX = 256;

    /**
     * Vanilla's entity and block-entity render types that sample one plain texture through the model's UVs and do not
     * blend (plus entity_eyes, whose additive blend gives the same result in any order). Merging textures into one draw
     * interleaves their submits; a blended type would then blend in a different order than vanilla's per-texture groups,
     * so the translucent ones stay as they are.
     */
    static final Set<String> ALLOWED = Set.of(
        "entity_solid", "entity_solid_z_offset_forward", "entity_cutout", "entity_cutout_cull", "entity_cutout_z_offset",
        "entity_cutout_no_cull", "entity_cutout_no_cull_z_offset", "entity_smooth_cutout", "entity_no_outline",
        "armor_cutout_no_cull", "entity_eyes");

    private static State state = State.STARTING;
    private static String reason = "not started";
    private static int fallbacks;

    /** The replacement the last {@link #redirect} chose. */
    public static RenderType outType;
    public static UvMapping outUv;

    private static final Map<RenderType, Template> BY_TYPE = new IdentityHashMap<>();
    private static final Map<KindKey, Kind> KINDS = new HashMap<>();
    private static final Map<SlotKey, Slot> SLOTS = new HashMap<>();
    private static final List<Page> PAGES = new ArrayList<>();
    private static final Template NONE = new Template(null, null);

    // bench window (frames come from the bench)
    private static long redirected, submits;
    private static final Map<String, long[]> SKIPPED = new HashMap<>();
    private static final Map<String, long[]> NOT_ALLOWED = new HashMap<>();
    private static final Map<String, long[]> SPLITS = new java.util.TreeMap<>();
    private static long uploads, uploadBytes;

    private EntityAtlas() {
    }

    // ---- the submit hook

    /**
     * A model submit: true (and {@link #outType}, {@link #outUv} set) when it should go to the atlas instead. Never
     * throws: a failure turns the module off.
     */
    public static boolean redirect(RenderType type, UvMapping uv, int outline) {
        if (state != State.ON) {
            if (state == State.STARTING) start();
            if (state != State.ON) return false;
        }
        try {
            if (uv instanceof Slot) return false; // the atlas's own submit, made by the hook
            submits++;
            if (type == null) return skip("no render type");
            if (uv != null) return skip("already mapped");
            if (outline != 0) return skip("outline colour");
            Template t = BY_TYPE.get(type);
            if (t == null) {
                t = template(type);
                BY_TYPE.put(type, t);
            }
            if (t == NONE) return skip("render type not eligible");
            if (t.location() == null) return skip("no texture");
            if (!RenderSystem.isOnRenderThread()) return skip("not render thread");
            AbstractTexture src = Minecraft.getInstance().getTextureManager().getTexture(t.location());
            Slot s = slot(t, src);
            if (s == null) return false;
            outType = t.forPage(s.page);
            outUv = s;
            redirected++;
            return true;
        } catch (Throwable e) {
            fail("redirect", e);
            return false;
        }
    }

    private static boolean skip(String why) {
        SKIPPED.computeIfAbsent(why, k -> new long[1])[0]++;
        return false;
    }

    // ---- render types

    /** One render type kind (name, every setup field but the texture, sampler): its atlas render type per page. */
    private record KindKey(String name, Map<String, Object> others, String sampler, Object supplier) {
    }

    private static final class Kind {
        final String name;
        final RenderSetup setup;
        final String samplerName;
        final Object supplier;
        final Map<Integer, RenderType> pages = new HashMap<>();

        Kind(String name, RenderSetup setup, String samplerName, Object supplier) {
            this.name = name;
            this.setup = setup;
            this.samplerName = samplerName;
            this.supplier = supplier;
        }

        /** This kind bound to atlas page {@code page} instead of its own texture: one instance per page. */
        RenderType forPage(int page) throws ReflectiveOperationException {
            RenderType r = pages.get(page);
            if (r == null) {
                r = withTexture(this, PAGES.get(page).id);
                pages.put(page, r);
            }
            return r;
        }
    }

    /** A vanilla render type the atlas can take: its kind and its own texture. */
    private record Template(Kind kind, Identifier location) {
        RenderType forPage(int page) throws ReflectiveOperationException {
            return kind.forPage(page);
        }

        Object supplier() {
            return kind.supplier;
        }
    }

    private static Field fState, fName, fTextures;
    private static Method mCreate, mLocation, mSamplerOf;
    private static Constructor<?> cBinding;
    private static List<Field> setupFields;

    private static void reflect() throws ReflectiveOperationException {
        fState = RenderType.class.getDeclaredField("state");
        fState.setAccessible(true);
        fName = RenderType.class.getDeclaredField("name");
        fName.setAccessible(true);
        mCreate = RenderType.class.getDeclaredMethod("create", String.class, RenderSetup.class);
        mCreate.setAccessible(true);
        fTextures = RenderSetup.class.getDeclaredField("textures");
        fTextures.setAccessible(true);
        Class<?> binding = Class.forName("net.minecraft.client.renderer.rendertype.RenderSetup$TextureBinding");
        mLocation = binding.getDeclaredMethod("location");
        mLocation.setAccessible(true);
        mSamplerOf = binding.getDeclaredMethod("sampler");
        mSamplerOf.setAccessible(true);
        cBinding = binding.getDeclaredConstructor(Identifier.class, Supplier.class);
        cBinding.setAccessible(true);
        setupFields = new ArrayList<>();
        for (Field f : RenderSetup.class.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            f.setAccessible(true);
            setupFields.add(f);
        }
    }

    /** What {@code type} would become in the atlas, or {@link #NONE}. */
    private static Template template(RenderType type) throws ReflectiveOperationException {
        String name = (String) fName.get(type);
        RenderSetup setup = (RenderSetup) fState.get(type);
        if (!ALLOWED.contains(name)) {
            NOT_ALLOWED.computeIfAbsent(name, k -> new long[1])[0]++;
            return NONE;
        }
        Map<?, ?> textures = (Map<?, ?>) fTextures.get(setup);
        if (textures == null || textures.size() != 1) return NONE;
        Map<String, Object> others = new LinkedHashMap<>();
        for (Field f : setupFields) {
            if (f.equals(fTextures)) continue; // equals: getDeclaredFields gives copies, never fTextures itself
            Object v = f.get(setup);
            if (v instanceof TextureTransform tt && tt != TextureTransform.DEFAULT_TEXTURING) return NONE;
            others.put(f.getName(), v);
        }
        var e = textures.entrySet().iterator().next();
        String sampler = (String) e.getKey();
        Identifier location = (Identifier) mLocation.invoke(e.getValue());
        Object supplier = mSamplerOf.invoke(e.getValue());
        // keyed by the sampler the supplier gives, not the supplier: each texture's binding has its own supplier object
        // (run 42162330832: one atlas render type per texture, no draws merged), but they give the same cached sampler
        Object resolved = supplier instanceof Supplier<?> sp ? sp.get() : null;
        KindKey key = new KindKey(name, others, sampler, resolved == null ? supplier : resolved);
        if (!KINDS.containsKey(key)) noteSplit(key);
        Kind kind = KINDS.computeIfAbsent(key, k -> new Kind(name, setup, sampler, supplier));
        return new Template(kind, location);
    }

    /** Why a new kind did not join one of the same name already there (which part of the key differs): bench only. */
    private static void noteSplit(KindKey key) {
        for (KindKey k : KINDS.keySet()) {
            if (!k.name().equals(key.name())) continue;
            List<String> diff = new ArrayList<>();
            for (var e : key.others().entrySet()) {
                if (!java.util.Objects.equals(e.getValue(), k.others().get(e.getKey()))) diff.add(e.getKey() + "=" + describe(e.getValue()) + "/" + describe(k.others().get(e.getKey())));
            }
            if (!key.sampler().equals(k.sampler())) diff.add("samplerName");
            if (!java.util.Objects.equals(key.supplier(), k.supplier())) diff.add("sampler=" + describe(key.supplier()) + "/" + describe(k.supplier()));
            SPLITS.computeIfAbsent(key.name() + ": " + String.join(", ", diff), x -> new long[1])[0]++;
            return;
        }
    }

    private static String describe(Object o) {
        return o == null ? "null" : o.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(o));
    }

    /** A copy of {@code t}'s render type with its one texture replaced by {@code atlas}; every other field is the same. */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static RenderType withTexture(Kind t, Identifier atlas) throws ReflectiveOperationException {
        RenderSetup copy = (RenderSetup) unsafe().allocateInstance(RenderSetup.class);
        for (Field f : setupFields) f.set(copy, f.get(t.setup));
        Map textures = new LinkedHashMap((Map<?, ?>) fTextures.get(t.setup));
        textures.put(t.samplerName, cBinding.newInstance(atlas, t.supplier));
        fTextures.set(copy, java.util.Collections.unmodifiableMap(textures));
        return (RenderType) mCreate.invoke(null, t.name, copy);
    }

    private static sun.misc.Unsafe unsafe;

    private static sun.misc.Unsafe unsafe() throws ReflectiveOperationException {
        if (unsafe == null) {
            Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (sun.misc.Unsafe) f.get(null);
        }
        return unsafe;
    }

    // ---- slots and pages

    private record SlotKey(Identifier location, AddressMode u, AddressMode v) {
    }

    /** Where one texture sits in a page: the model's UVs (0..1 over the texture) map into it. */
    static final class Slot implements UvMapping {
        final int page;
        final GpuTexture source;
        final double x, y, w, h;

        Slot(int page, GpuTexture source, int x, int y, int w, int h) {
            this.page = page;
            this.source = source;
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        @Override
        public float getU(float u) {
            return (float) ((x + u * w) / PAGE);
        }

        @Override
        public float getV(float v) {
            return (float) ((y + v * h) / PAGE);
        }
    }

    private static final class Page extends AbstractTexture {
        final int index;
        final Identifier id;
        int cx, cy, rowH;

        Page(int index) {
            this.index = index;
            this.id = Identifier.fromNamespaceAndPath("quicksilver", "entity_atlas/" + index);
            var device = RenderSystem.getDevice();
            texture = device.createTexture(() -> "Quicksilver entity atlas " + index, GpuTexture.USAGE_COPY_DST | GpuTexture.USAGE_TEXTURE_BINDING,
                GpuFormat.RGBA8_UNORM, PAGE, PAGE, 1, 1);
            textureView = device.createTextureView(texture);
            sampler = RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST);
        }

        /** Top-left of a free {@code w} x {@code h} area, or null when the page is full (simple shelves). */
        int[] place(int w, int h) {
            if (cx + w > PAGE) {
                cy += rowH;
                cx = 0;
                rowH = 0;
            }
            if (cy + h > PAGE) return null;
            int[] at = {cx, cy};
            cx += w;
            rowH = Math.max(rowH, h);
            return at;
        }
    }

    /** The slot of {@code t}'s texture, made and filled now if it can be; null: vanilla's path for this submit. */
    private static Slot slot(Template t, AbstractTexture src) throws Exception {
        if (src == null || src.getClass() != SimpleTexture.class) return skipSlot("texture not a plain resource texture");
        GpuTexture g = src.getTexture();
        if (g == null || g.isClosed()) return skipSlot("texture not loaded");
        Object sup = t.supplier();
        GpuSampler smp = sup instanceof Supplier<?> s ? (GpuSampler) s.get() : null;
        if (smp == null) smp = src.getSampler();
        if (smp == null) return skipSlot("no sampler");
        SlotKey key = new SlotKey(t.location(), smp.getAddressModeU(), smp.getAddressModeV());
        Slot slot = SLOTS.get(key);
        if (slot != null) {
            if (slot.source != g) {
                // the texture was reloaded: its slot is stale until the atlas is rebuilt (next client tick)
                rebuildPending = true;
                return skipSlot("texture reloaded");
            }
            return slot;
        }
        if (smp.getMinFilter() != FilterMode.NEAREST || smp.getMagFilter() != FilterMode.NEAREST || smp.getMaxAnisotropy() > 1) {
            return skipSlot("sampler not nearest");
        }
        if (g.getMipLevels() != 1 || g.getDepthOrLayers() != 1 || g.getFormat() != GpuFormat.RGBA8_UNORM) return skipSlot("texture not single-level RGBA8");
        int w = g.getWidth(0), h = g.getHeight(0);
        if (w > MAX || h > MAX) return skipSlot("texture larger than " + MAX);
        CommandEncoder enc = RenderSystem.getDevice().createCommandEncoder();
        if (!(enc instanceof FrontendCommandEncoder f) || f.isInRenderPass()) return skipSlot("render pass open");
        int[] pixels;
        try (TextureContents c = TextureContents.load(Minecraft.getInstance().getResourceManager(), ((SimpleTexture) src).resourceId())) {
            NativeImage img = c.image();
            if (img.getWidth() != w || img.getHeight() != h || img.format() != NativeImage.Format.RGBA) return skipSlot("resource differs from the texture");
            pixels = img.getPixelsABGR();
        } catch (java.io.IOException io) {
            return skipSlot("resource not readable");
        }
        int sw = w + 2, sh = h + 2;
        Page page = PAGES.isEmpty() ? null : PAGES.get(PAGES.size() - 1);
        int[] at = page == null ? null : page.place(sw, sh);
        if (at == null) {
            page = new Page(PAGES.size());
            Minecraft.getInstance().getTextureManager().register(page.id, page);
            PAGES.add(page);
            at = page.place(sw, sh);
        }
        boolean repU = key.u() == AddressMode.REPEAT, repV = key.v() == AddressMode.REPEAT;
        try (NativeImage padded = new NativeImage(NativeImage.Format.RGBA, sw, sh, false)) {
            for (int py = 0; py < sh; py++) {
                int sy = edge(py - 1, h, repV);
                for (int px = 0; px < sw; px++) padded.setPixelABGR(px, py, pixels[sy * w + edge(px - 1, w, repU)]);
            }
            enc.writeToTexture(page.getTexture(), padded, 0, 0, at[0], at[1]);
        }
        uploads++;
        uploadBytes += (long) sw * sh * 4;
        slot = new Slot(page.index, g, at[0] + 1, at[1] + 1, w, h);
        SLOTS.put(key, slot);
        return slot;
    }

    /** The texel a coordinate one outside the texture samples: the opposite edge (repeat) or the same edge (clamp). */
    private static int edge(int i, int n, boolean repeat) {
        if (i < 0) return repeat ? n - 1 : 0;
        if (i >= n) return repeat ? 0 : n - 1;
        return i;
    }

    private static Slot skipSlot(String why) {
        skip(why);
        return null;
    }

    private static boolean rebuildPending;

    /** Client tick (between frames): a reloaded texture empties the atlas; it refills as textures are used again. */
    public static void tick() {
        if (!rebuildPending || state != State.ON) return;
        rebuildPending = false;
        SLOTS.clear();
        for (Page p : PAGES) {
            p.cx = p.cy = p.rowH = 0;
        }
        QuicksilverClient.LOG.info("Quicksilver entity atlas: a texture was reloaded, the atlas refills from empty");
    }

    // ---- state

    private static void start() {
        if (Boolean.getBoolean("quicksilver.ci.measureOnly")) {
            off("measure only (CI)");
            return;
        }
        if ("false".equals(System.getProperty("quicksilver.entityAtlas"))) {
            off("quicksilver.entityAtlas=false");
            return;
        }
        if (!EntityMixins.applied()) {
            off("hook did not apply: SubmitNodeCollection#quicksilver$entityAtlas");
            fallbacks++;
            return;
        }
        try {
            reflect();
        } catch (Throwable t) {
            off("render type fields not found: " + t);
            fallbacks++;
            return;
        }
        state = State.ON;
        reason = "on";
        QuicksilverClient.LOG.info("Quicksilver entity atlas: on ({}x{} pages, textures up to {} px, filled as they are used)", PAGE, PAGE, MAX);
    }

    private static void off(String why) {
        state = State.OFF;
        reason = why;
        QuicksilverClient.LOG.warn("Quicksilver entity atlas: off, {} (vanilla draws every entity texture on its own)", why);
    }

    static void fail(String where, Throwable t) {
        if (state == State.OFF) return;
        state = State.OFF;
        reason = where + ": " + t;
        fallbacks++;
        QuicksilverClient.LOG.error("Quicksilver entity atlas: turned off, vanilla draws every entity texture on its own (fallback in {})", where, t);
    }

    public static State state() {
        return state;
    }

    // ---- bench

    public static void startWindow() {
        redirected = submits = 0;
        SKIPPED.clear();
        NOT_ALLOWED.clear();
    }

    public static JsonObject json(int frames) {
        JsonObject o = new JsonObject();
        o.addProperty("state", state.name().toLowerCase(java.util.Locale.ROOT));
        o.addProperty("reason", reason);
        o.addProperty("fallbacks", fallbacks);
        o.addProperty("pages", PAGES.size());
        o.addProperty("textures", SLOTS.size());
        o.addProperty("renderTypeKinds", KINDS.size());
        JsonArray splits = new JsonArray();
        for (var e : SPLITS.entrySet()) splits.add(e.getKey() + " (" + e.getValue()[0] + ")");
        o.add("kindSplits", splits);
        o.addProperty("vanillaRenderTypesSeen", BY_TYPE.size());
        o.addProperty("uploads", uploads);
        o.addProperty("uploadBytes", uploadBytes);
        o.addProperty("modelSubmitsPerFrame", per(submits, frames));
        o.addProperty("redirectedPerFrame", per(redirected, frames));
        o.add("skippedPerFrame", top(SKIPPED, frames));
        o.add("renderTypesNotAllowed", top(NOT_ALLOWED, frames));
        return o;
    }

    public static String line(JsonObject o) {
        return o.get("state").getAsString() + " (" + o.get("reason").getAsString() + "), " + o.get("textures") + " textures in " + o.get("pages")
            + " pages, model submits/frame " + o.get("modelSubmitsPerFrame") + ", to the atlas " + o.get("redirectedPerFrame")
            + "; skipped " + o.get("skippedPerFrame") + "; not allowed " + o.get("renderTypesNotAllowed");
    }

    private static JsonArray top(Map<String, long[]> m, int frames) {
        JsonArray a = new JsonArray();
        m.entrySet().stream().sorted((x, y) -> Long.compare(y.getValue()[0], x.getValue()[0])).limit(20).forEach(e -> {
            JsonObject r = new JsonObject();
            r.addProperty("name", e.getKey());
            r.addProperty("perFrame", per(e.getValue()[0], frames));
            a.add(r);
        });
        return a;
    }

    private static double per(long v, int frames) {
        return frames == 0 ? 0 : Math.round(100.0 * v / frames) / 100.0;
    }
}
