package com.meakaandre.quicksilver.look;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.speed.Speed;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.CompiledRenderPipeline;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTexture;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Optional;
import java.util.OptionalDouble;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.resources.Identifier;
import org.lwjgl.system.MemoryUtil;

/**
 * Package 11: the pixel art look (design doc, "Pixel art city mode", natural palette only). Off by default ("Look":
 * Normal / Pixel art, {@code option.look}); in no preset.
 *
 * <p>How: while the level renderer draws the world, the game's main render target is swapped for a small one
 * ({@link #mainTargetOverride}: the window's size divided by the pixel size), so every world pass (terrain, entities,
 * sky, fog, clouds, water and glass, Improved Transparency's targets, which follow the main target's size) draws at
 * that size. Then two full-screen draws: the first, at the small size, maps each pixel to the nearest colour of a fixed
 * palette made of vanilla's own colours (the map colours, each in its four map shades) with ordered 4x4 Bayer
 * dithering, and darkens the pixels on the near side of an exposed edge (an outline, from the depth image: see
 * {@code qs_pixel_art.fsh}); the second scales that up to the window with sharp nearest-neighbour pixels. The hand,
 * the HUD, menus, chat and text are drawn afterwards on the full-size target, as normal.
 *
 * <p>Off: nothing here runs, the main target is never swapped, and the level renderer keeps the window's size. Render
 * thread only.
 */
public final class PixelArt {
    private PixelArt() {
    }

    /** {@code option.pixel-size}: art pixels this many lines tall for the whole window, at any window size. */
    static final int[] LINES = {0, 360, 240, 144};
    static final String[] SIZE_NAMES = Speed.PIXEL_SIZE_NAMES;

    private static final Identifier FULLSCREEN = Identifier.fromNamespaceAndPath("quicksilver", "core/qs_fullscreen");
    /** [dither][outlines]. */
    private static final RenderPipeline[][] ART = new RenderPipeline[2][2];
    private static RenderPipeline up;

    /**
     * The palette pass's uniform block: std140, vec4 depth (projection m22, m32, 1 if depth is normalized z, m00), vec4
     * fog (start, end, 1 if on, projection m11).
     */
    static final BindGroupLayout PARAMS = BindGroupLayout.builder().withUniform("QsPixelArt", UniformType.UNIFORM_BUFFER).build();
    /** Package 12c: two vec4s (projection, fog) and two more: the fog's colour (w: the fog tones on) and the sky's. */
    static final int PARAMS_BYTES = 64;
    private static GpuBuffer params;
    private static ByteBuffer paramsScratch;
    /** The world's projection this frame (its m22 and m32), from the projection buffer hook; NaN before. */
    private static float projM22 = Float.NaN, projM32 = Float.NaN, projM00 = Float.NaN, projM11 = Float.NaN;
    private static boolean zeroToOne;

    /** Whether the projection hook should make a matrix (only while the look is on). */
    public static boolean wantsProjection() {
        return wasOn;
    }

    /**
     * Mixin (the projection buffer): a perspective projection, the latest kept. The world's is written again before each
     * level render, so the passes after it use the world's; another perspective one (the hand's) only shares its near and
     * far planes, which is all the depth-to-distance mapping needs.
     */
    public static void projection(org.joml.Matrix4fc m) {
        if (!wasOn || m == null || m.m23() == 0.0f) return;
        if (!Float.isFinite(projM32)) QuicksilverClient.LOG.info("Quicksilver pixel art: distances from the projection known (outlines fade in the fog)");
        projM22 = m.m22();
        projM32 = m.m32();
        projM00 = m.m00();
        projM11 = m.m11();
    }

    /** While true, {@code GameRenderer.mainRenderTarget()} returns the small target (the level renderer is drawing). */
    private static boolean redirect;
    private static RenderTarget low;
    private static GpuTexture art, lut;
    private static GpuTextureView artView, lutView;
    private static int lowW, lowH, artW, artH, factor, windowW, windowH;
    /** The size the level renderer was last resized to (its own resize hook), -1 before the first. */
    static int levelW = -1, levelH = -1;
    private static boolean broken, wasOn, reversed, conventionKnown;
    private static String lastLog = "";

    // counters (bench, CI)
    private static long frames, redirects, framesRedirected, windowFrames, windowNanos;
    private static long created, closed;
    private static int paletteColours;
    /** Frames drawn since start-up (CI's check that the look drew). */
    public static volatile long drawnFrames;

    /** The setting: 0 Normal, 1 Pixel art. */
    public static boolean enabled() {
        return !broken && Speed.LOOK.value() == 1;
    }

    /** CI's resize test (/quicksilver pixelart resizetest): window sizes the look's targets are made for in turn. */
    static final int[][] TEST_SIZES = {{960, 540}, {1100, 620}, {800, 600}, {1920, 1080}, {640, 360}};
    static final int TEST_FRAMES = 20;
    private static int testFrames;

    /** Starts CI's resize test (the look must be on): each of {@link #TEST_SIZES} for {@link #TEST_FRAMES} frames. */
    public static void resizeTest() {
        testFrames = TEST_FRAMES * TEST_SIZES.length;
        QuicksilverClient.LOG.info("Quicksilver pixel art: resize test, {} sizes, live GPU objects {}", TEST_SIZES.length, live());
    }

    /** Mixin (GameRenderer.mainRenderTarget): the small target while the world draws, else null (the game's own). */
    public static RenderTarget mainTargetOverride() {
        if (!redirect) return null;
        redirects++;
        return low;
    }

    /** Mixin: the level renderer was resized (by the game on a window resize, or by this class). */
    public static void levelResized(int w, int h) {
        levelW = w;
        levelH = h;
    }

    /**
     * Window pixels per art pixel: the window's height over the size's lines, at least 2 (review: at 1 the world would
     * draw at full size and the look's passes would only add cost).
     */
    static int factorFor(int height, int size) {
        int lines = LINES[size >= 1 && size <= 3 ? size : 2];
        return Math.max(2, Math.round(height / (float) lines));
    }

    /** Mixin, the level renderer's render, before: swaps in the small target when the look is on. */
    public static void beforeLevel() {
        redirect = false;
        Minecraft mc = Minecraft.getInstance();
        RenderTarget main = mc.gameRenderer.mainRenderTarget();
        if (!enabled()) {
            if (wasOn) turnOff(mc, main);
            return;
        }
        try {
            int w = main.width, h = main.height;
            if (testFrames > 0) {
                // CI's resize test: the look's targets as for each of these window sizes in turn (the picture is still
                // scaled to the real window)
                int i = Math.min(TEST_SIZES.length - 1, (TEST_FRAMES * TEST_SIZES.length - testFrames) / TEST_FRAMES);
                w = TEST_SIZES[i][0];
                h = TEST_SIZES[i][1];
                if (--testFrames == 0) QuicksilverClient.LOG.info("Quicksilver pixel art: resize test done, live GPU objects {}", live() );
            }
            int f = factorFor(h, Speed.PIXEL_SIZE.value());
            int lw = Math.max(1, (w + f - 1) / f), lh = Math.max(1, (h + f - 1) / f);
            if (!conventionKnown) {
                reversed = String.valueOf(DepthStencilState.DEFAULT.depthTest()).toUpperCase(Locale.ROOT).contains("GREATER");
                zeroToOne = RenderSystem.getDevice().getDeviceInfo().isZZeroToOne();
                conventionKnown = true;
            }
            String problem = compileAll();
            if (problem != null) throw new IllegalStateException(problem);
            if (lut == null) makePalette();
            if (low == null) {
                // the same formats as the game's main target, so every pipeline drawn on it draws on this one
                com.meakaandre.quicksilver.mixin.look.RenderTargetAccessor a = (com.meakaandre.quicksilver.mixin.look.RenderTargetAccessor) main;
                low = new TextureTarget("Quicksilver pixel art", lw, lh, a.quicksilver$colorFormat(), a.quicksilver$depthFormat());
                created++;
            } else if (low.width != lw || low.height != lh) {
                low.resize(lw, lh);
            }
            ensureArt(lw, lh);
            lowW = lw;
            lowH = lh;
            factor = f;
            windowW = w;
            windowH = h;
            if (levelW != lw || levelH != lh) mc.levelRenderer.resize(lw, lh);
            wasOn = true;
            redirect = true;
            String log = lw + "x" + lh + " from " + w + "x" + h + " (" + f + " px, " + SIZE_NAMES[Math.max(0, Math.min(3, Speed.PIXEL_SIZE.value()))]
                + "), dithering " + (Speed.PIXEL_DITHER.on() ? "on" : "off") + ", outlines " + (Speed.PIXEL_OUTLINES.on() ? "on" : "off");
            if (!log.equals(lastLog)) {
                lastLog = log;
                QuicksilverClient.LOG.info("Quicksilver pixel art: on, {}, palette {} colours, live GPU objects {}", log, paletteColours, live());
            }
        } catch (Throwable t) {
            fail("setting up", t);
            turnOff(mc, main);
        }
    }

    /** Mixin, the level renderer's render, after (the world is drawn on the small target): the two full-screen draws. */
    public static void afterLevel() {
        if (!redirect) return;
        redirect = false;
        frames++;
        if (redirects == 0) {
            // the main-target hook did not apply (another mod, or a changed game): the world went to the window's target
            // as normal, and the small one holds nothing; leave the picture alone
            fail("drawing", new IllegalStateException("the world was not drawn on the small target (GameRenderer.mainRenderTarget's hook did not run)"));
            return;
        }
        long t0 = System.nanoTime();
        try {
            Minecraft mc = Minecraft.getInstance();
            RenderTarget main = mc.gameRenderer.mainRenderTarget();
            GpuDevice device = RenderSystem.getDevice();
            CommandEncoder enc = device.createCommandEncoder();
            var nearest = RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST);
            writeParams(device, enc);
            try (RenderPass pass = enc.createRenderPass(() -> "Quicksilver pixel art: palette", artView, Optional.empty(), null, OptionalDouble.empty())) {
                pass.setPipeline(compiled(ART[Speed.PIXEL_DITHER.on() ? 1 : 0][Speed.PIXEL_OUTLINES.on() ? 1 : 0]));
                pass.setUniform("Sampler0", low.getColorTextureView(), nearest);
                pass.setUniform("Sampler1", low.getDepthTextureView(), nearest);
                pass.setUniform("Sampler2", lutView, nearest);
                pass.setUniform("QsPixelArt", params);
                pass.draw(6, 1, 0, 0);
            }
            // the full-size depth is cleared (nothing of the world is in it; the hand and the HUD draw on it next)
            try (RenderPass clear = enc.createRenderPass(() -> "Quicksilver pixel art: clear depth", main.getColorTextureView(), Optional.empty(),
                main.getDepthTextureView(), OptionalDouble.of(reversed ? 0.0 : 1.0))) {
                // clears only
            }
            try (RenderPass pass = enc.createRenderPass(() -> "Quicksilver pixel art: scale up", main.getColorTextureView(), Optional.empty(), null, OptionalDouble.empty())) {
                pass.setPipeline(compiled(up));
                pass.setUniform("Sampler0", artView, nearest);
                pass.draw(6, 1, 0, 0);
            }
            if (redirects > 0) framesRedirected++;
            redirects = 0;
            drawnFrames++;
            windowFrames++;
            windowNanos += System.nanoTime() - t0;
        } catch (Throwable t) {
            fail("drawing", t);
        }
    }

    /** The palette pass's block: the frame's projection (for each pixel's distance) and the fog (outlines fade in it). */
    private static void writeParams(GpuDevice device, CommandEncoder enc) {
        if (params == null) params = device.createBuffer(() -> "Quicksilver pixel art", GpuBuffer.USAGE_UNIFORM | GpuBuffer.USAGE_COPY_DST, PARAMS_BYTES);
        if (paramsScratch == null) paramsScratch = MemoryUtil.memAlloc(PARAMS_BYTES);
        ByteBuffer b = paramsScratch;
        boolean proj = Float.isFinite(projM22) && Float.isFinite(projM32) && projM00 != 0f && projM11 != 0f && Float.isFinite(projM00) && Float.isFinite(projM11);
        b.putFloat(0, proj ? projM22 : 0f).putFloat(4, proj ? projM32 : 0f).putFloat(8, zeroToOne ? 1f : 0f).putFloat(12, proj ? projM00 : 1f);
        float[] fog = com.meakaandre.quicksilver.speed.SpeedTerrain.fogForLook();
        boolean fogOn = fog != null && proj;
        b.putFloat(16, fogOn ? fog[0] : 0f).putFloat(20, fogOn ? fog[1] : 0f).putFloat(24, fogOn ? 1f : 0f).putFloat(28, proj ? projM11 : 1f);
        // package 12c: the fog's and the sky's colours now, as extra tones beside the palette (pale fog, haze and sky had
        // only far-apart palette colours, so the dithering made a heavy checkerboard of them: far terrain with pixel art)
        // only while far terrain draws: with it off, pixel art is package 11's exactly (every existing shot unchanged)
        boolean tones = com.meakaandre.quicksilver.far.FarTerrain.drawing() && !com.meakaandre.quicksilver.speed.Speed.CI_PIXEL_OLD_FOG.on();
        float[] fc = tones ? com.meakaandre.quicksilver.speed.SpeedTerrain.fogColour() : null;
        tones &= fc != null;
        float[] sky = tones ? skyColour(fc) : new float[] {0, 0, 0};
        if (tones != tonesLogged) {
            tonesLogged = tones;
            com.meakaandre.quicksilver.QuicksilverClient.LOG.info("Quicksilver pixel art: fog tones {} (fog colour {}, sky colour {})", tones ? "on" : "off",
                fc == null ? "none" : java.util.Arrays.toString(fc), java.util.Arrays.toString(sky));
        }
        b.putFloat(32, fc != null ? fc[0] : 0f).putFloat(36, fc != null ? fc[1] : 0f).putFloat(40, fc != null ? fc[2] : 0f).putFloat(44, tones ? 1f : 0f);
        b.putFloat(48, sky[0]).putFloat(52, sky[1]).putFloat(56, sky[2]).putFloat(60, tones ? 1f : 0f);
        // written only when a value changed (review of run 45749687305: no upload a frame that isn't needed)
        boolean same = lastParams != null;
        for (int i = 0; same && i < PARAMS_BYTES / 4; i++) if (Float.floatToRawIntBits(b.getFloat(i * 4)) != lastParams[i]) same = false;
        if (same) return;
        if (lastParams == null) lastParams = new int[PARAMS_BYTES / 4];
        for (int i = 0; i < PARAMS_BYTES / 4; i++) lastParams[i] = Float.floatToRawIntBits(b.getFloat(i * 4));
        enc.writeToBuffer(params.slice(), b.position(0).limit(PARAMS_BYTES));
    }

    private static int[] lastParams;
    private static boolean tonesLogged;
    private static java.lang.reflect.Method skyMethod;
    private static boolean skyLooked;

    /**
     * Package 12c: the sky's colour at the camera now (the level's own, looked up once by name; a game without it: the fog's
     * colour stands in), 0..1 each.
     */
    private static float[] skyColour(float[] fog) {
        float[] out = fog != null ? fog.clone() : new float[] {0, 0, 0};
        try {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level == null || mc.player == null) return out;
            if (!skyLooked) {
                skyLooked = true;
                for (java.lang.reflect.Method m : mc.level.getClass().getMethods()) {
                    if (m.getName().equals("getSkyColor") && m.getParameterCount() == 2 && m.getReturnType() == int.class) skyMethod = m;
                }
            }
            if (skyMethod == null) return out;
            int c = (int) skyMethod.invoke(mc.level, mc.player.position(), mc.getDeltaTracker().getGameTimeDeltaPartialTick(false));
            return new float[] {((c >> 16) & 255) / 255f, ((c >> 8) & 255) / 255f, (c & 255) / 255f};
        } catch (Throwable t) {
            skyMethod = null;
            return out;
        }
    }

    private static void turnOff(Minecraft mc, RenderTarget main) {
        redirect = false;
        wasOn = false;
        lastLog = "";
        try {
            if (main != null && (levelW != main.width || levelH != main.height)) mc.levelRenderer.resize(main.width, main.height);
        } catch (Throwable t) {
            QuicksilverClient.LOG.error("Quicksilver pixel art: could not give the level renderer the window's size back", t);
        }
        // the small targets are freed (memory); the palette stays
        if (low != null) {
            low.destroyBuffers();
            low = null;
            closed++;
        }
        closeArt();
        QuicksilverClient.LOG.info("Quicksilver pixel art: off, live GPU objects {}", live());
    }

    private static void fail(String where, Throwable t) {
        broken = true;
        redirect = false;
        QuicksilverClient.LOG.error("Quicksilver pixel art failed ({}); the look stays Normal for this session", where, t);
    }

    private static long tickDrawn = -1;
    private static int ticksUndrawn;
    private static boolean warnedUndrawn;

    /**
     * Client tick: with the look on in a world and no frame drawn for 10 seconds, its level renderer hook did not apply
     * (its mixins are optional, so another mod can't stop the game from starting): one warning, and the setting stays
     * as chosen.
     */
    public static void tick(Minecraft mc) {
        if (!enabled() || mc.level == null || warnedUndrawn) {
            ticksUndrawn = 0;
            return;
        }
        if (drawnFrames != tickDrawn) {
            tickDrawn = drawnFrames;
            ticksUndrawn = 0;
        } else if (++ticksUndrawn == 200) {
            warnedUndrawn = true;
            QuicksilverClient.LOG.warn("Quicksilver pixel art: on, but nothing drawn for 10 seconds (the level renderer's hook did not apply); the world stays Normal");
        }
    }

    /** GPU objects this class made and has not closed (CI's leak check across window resizes). */
    static long live() {
        return created - closed;
    }

    private static void ensureArt(int w, int h) {
        if (art != null && artW == w && artH == h) return;
        closeArt();
        GpuDevice device = RenderSystem.getDevice();
        art = device.createTexture(() -> "Quicksilver pixel art", GpuTexture.USAGE_RENDER_ATTACHMENT | GpuTexture.USAGE_TEXTURE_BINDING,
            GpuFormat.RGBA8_UNORM, w, h, 1, 1);
        artView = device.createTextureView(art);
        created += 2;
        artW = w;
        artH = h;
    }

    private static void closeArt() {
        if (artView != null) {
            artView.close();
            closed++;
        }
        if (art != null) {
            art.close();
            closed++;
        }
        art = null;
        artView = null;
        artW = artH = -1;
    }

    // ---- the palette: vanilla's map colours, each in its four map shades, as a 32x32x32 lookup table

    /** Lookup table: 32 levels a channel; texel (r + 32 * b, g) holds the nearest palette colour. */
    static final int LUT_LEVELS = 32;

    private static void makePalette() {
        int[] palette = Palette.natural();
        paletteColours = palette.length;
        int n = LUT_LEVELS;
        ByteBuffer data = MemoryUtil.memAlloc(n * n * n * 4);
        try {
            for (int g = 0; g < n; g++) {
                for (int b = 0; b < n; b++) {
                    for (int r = 0; r < n; r++) {
                        int c = Palette.nearest(palette, r * 255 / (n - 1), g * 255 / (n - 1), b * 255 / (n - 1));
                        int o = ((g * n * n) + (b * n) + r) * 4;
                        data.put(o, (byte) (c >> 16));
                        data.put(o + 1, (byte) (c >> 8));
                        data.put(o + 2, (byte) c);
                        data.put(o + 3, (byte) 255);
                    }
                }
            }
            GpuDevice device = RenderSystem.getDevice();
            lut = device.createTexture(() -> "Quicksilver pixel art palette", GpuTexture.USAGE_COPY_DST | GpuTexture.USAGE_TEXTURE_BINDING,
                GpuFormat.RGBA8_UNORM, n * n, n, 1, 1);
            lutView = device.createTextureView(lut);
            device.createCommandEncoder().writeToTexture(lut, data, 0, 0, 0, 0, n * n, n);
        } finally {
            MemoryUtil.memFree(data);
        }
    }

    // ---- pipelines

    static synchronized void buildPipelines() {
        if (up != null) return;
        for (int d = 0; d < 2; d++) {
            for (int o = 0; o < 2; o++) {
                RenderPipeline.Builder b = RenderPipeline.builder()
                    .withLocation(Identifier.fromNamespaceAndPath("quicksilver", "pipeline/qs_pixel_art" + (d == 1 ? "_dither" : "") + (o == 1 ? "_outlines" : "")))
                    .withVertexShader(FULLSCREEN)
                    .withFragmentShader(Identifier.fromNamespaceAndPath("quicksilver", "core/qs_pixel_art"))
                    .withBindGroupLayout(BindGroupLayouts.SAMPLER0)
                    .withBindGroupLayout(BindGroupLayouts.SAMPLER1)
                    .withBindGroupLayout(BindGroupLayouts.SAMPLER2)
                    .withBindGroupLayout(PARAMS)
                    .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
                    .withDepthStencilState(Optional.empty())
                    .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, ColorTargetState.DEFAULT.writeMask()));
                if (d == 1) b.withShaderDefine("QS_DITHER");
                if (o == 1) b.withShaderDefine("QS_OUTLINES");
                if (reversed) b.withShaderDefine("QS_REVERSED_DEPTH");
                ART[d][o] = b.build();
            }
        }
        up = RenderPipeline.builder()
            .withLocation(Identifier.fromNamespaceAndPath("quicksilver", "pipeline/qs_pixel_up"))
            .withVertexShader(FULLSCREEN)
            .withFragmentShader(Identifier.fromNamespaceAndPath("quicksilver", "core/qs_pixel_up"))
            .withBindGroupLayout(BindGroupLayouts.SAMPLER0)
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .withDepthStencilState(Optional.empty())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, ColorTargetState.DEFAULT.writeMask()))
            .build();
    }

    /** Null if every pipeline compiles (no render pass may be open), else what failed. */
    static String compileAll() {
        buildPipelines();
        for (RenderPipeline[] row : ART) {
            for (RenderPipeline p : row) {
                String why = compileOne(p);
                if (why != null) return why;
            }
        }
        return compileOne(up);
    }

    private static String compileOne(RenderPipeline p) {
        try {
            if (RenderSystem.getCompiledPipelineNullable(p) == null) return "pipeline " + p.getLocation() + " did not compile";
        } catch (Throwable t) {
            return "pipeline " + p.getLocation() + " did not compile: " + t;
        }
        return null;
    }

    private static CompiledRenderPipeline compiled(RenderPipeline p) {
        CompiledRenderPipeline c = RenderSystem.getCompiledPipelineNullable(p);
        if (c == null) throw new IllegalStateException("pipeline " + p.getLocation() + " did not compile");
        return c;
    }

    // ---- bench

    public static void startWindow() {
        windowFrames = windowNanos = 0;
    }

    public static JsonObject json() {
        JsonObject o = new JsonObject();
        o.addProperty("state", broken ? "failed (Normal for the session)" : enabled() ? "pixel art" : "normal");
        o.addProperty("pixelSize", SIZE_NAMES[Math.max(0, Math.min(3, Speed.PIXEL_SIZE.value()))]);
        o.addProperty("factor", factor);
        o.addProperty("art", lowW + "x" + lowH);
        o.addProperty("window", windowW + "x" + windowH);
        o.addProperty("dithering", Speed.PIXEL_DITHER.on());
        o.addProperty("outlines", Speed.PIXEL_OUTLINES.on());
        o.addProperty("paletteColours", paletteColours);
        o.addProperty("frames", windowFrames);
        o.addProperty("passesMsAvg", Math.round(windowNanos / 1e4 / Math.max(1, windowFrames)) / 100.0);
        o.addProperty("framesDrawn", drawnFrames);
        o.addProperty("framesRedirected", framesRedirected);
        o.addProperty("liveGpuObjects", live());
        o.addProperty("projectionM22", projM22);
        o.addProperty("projectionM32", projM32);
        float[] fog = com.meakaandre.quicksilver.speed.SpeedTerrain.fogForLook();
        o.addProperty("fog", fog == null ? "none" : fog[0] + "-" + fog[1]);
        return o;
    }

    public static String line(JsonObject o) {
        return o.get("state").getAsString() + ", " + o.get("art").getAsString() + " from " + o.get("window").getAsString() + " (" + o.get("factor")
            + " px), palette " + o.get("paletteColours") + ", frames " + o.get("frames") + ", CPU ms in its passes avg " + o.get("passesMsAvg")
            + ", live GPU objects " + o.get("liveGpuObjects");
    }
}
