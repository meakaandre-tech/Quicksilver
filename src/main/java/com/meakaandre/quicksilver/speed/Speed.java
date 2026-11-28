package com.meakaandre.quicksilver.speed;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.LongAdder;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

/**
 * Package A: approximations and speed options, one switch each.
 *
 * <p>Two kinds (design doc, look rule, 2026-11-23): an <b>approximation</b> ({@code approx.*}) changes nothing you can
 * notice in play and may be on by default where it was measured to buy speed; an <b>option</b> ({@code option.*})
 * visibly simplifies the picture and is always off by default. Each is a line in {@code config/quicksilver.properties}
 * (read at start-up) and can be switched in game with {@code /quicksilver speed <name> on|off|<number>} (also
 * {@code /qs}); {@code /qs speed} lists them. Package 9: the options screen ({@code settings/SettingsScreen}) shows the same
 * switches with presets; the screen and the command both save the file ({@code settings/Settings#save}).
 *
 * <p>In CI's measure runs (Quicksilver loaded as a vanilla stand-in) every one stays off and can't be switched on.
 */
public final class Speed {
    /** One switch. {@code value} 0 is off; booleans are 0 or 1, numbers are a distance or a share. */
    public static final class Setting {
        public final String key, what, unit;
        public final boolean approximation, remesh;
        public final int defaultValue, min, max;
        volatile int value;

        Setting(String key, boolean approximation, boolean remesh, int defaultValue, int min, int max, String unit, String what) {
            this.key = key;
            this.approximation = approximation;
            this.remesh = remesh;
            this.defaultValue = defaultValue;
            this.min = min;
            this.max = max;
            this.unit = unit;
            this.what = what;
            this.value = defaultValue;
        }

        public boolean on() {
            return value != 0;
        }

        public int value() {
            return value;
        }

        boolean bool() {
            return max == 1;
        }
    }

    private static final Map<String, Setting> ALL = new LinkedHashMap<>();

    // ---- approximations (invisible; on by default only where measured to help, see docs/progress.md, package A)

    /** Terrain sections wholly inside the render-distance fog (drawn in the fog's colour) are not drawn. */
    public static final Setting FOG_SECTIONS = add(new Setting("approx.fog-sections", true, false, 1, 0, 1, "",
        "terrain sections wholly inside the render-distance fog are not drawn"));

    /**
     * Package B: on the plain draw path (one multi-draw per region and layer: Intel and old GPUs), translucent section
     * layers are drawn region by region (regions in the order vanilla's back-to-front list first reaches them, each
     * region's sections in vanilla's order) instead of breaking a draw at every region change; Sodium draws
     * translucent terrain this way. Only where translucent faces of two regions overlap on screen can the blend order
     * differ. The indirect path (one draw per arena) is unchanged.
     */
    public static final Setting TRANSLUCENT_REGIONS = add(new Setting("approx.translucent-regions", true, false, 1, 0, 1, "",
        "on the plain draw path, translucent terrain is drawn region by region (fewer draw calls)"));

    // ---- options (visible simplifications; always off by default)

    public static final Setting OPAQUE_LEAVES = add(new Setting("option.opaque-leaves", false, true, 0, 0, 1, "",
        "leaves drawn opaque (no see-through gaps), and leaf faces against other leaves left out"));
    public static final Setting SIMPLE_WATER = add(new Setting("option.simple-water", false, true, 0, 0, 1, "",
        "water drawn opaque, in the solid layer (no blending, no sorting; you can't see into it)"));
    public static final Setting FAR_CUTOUT = add(new Setting("option.far-detail", false, false, 0, 0, 64, "chunks",
        "beyond this many chunks, the cutout layer (grass, flowers, crops, and leaves unless opaque-leaves is on) is not drawn"));
    public static final Setting ENTITY_DISTANCE = add(new Setting("option.entity-distance", false, false, 0, 0, 512, "blocks",
        "entities (not players) beyond this many blocks are not drawn"));
    public static final Setting BLOCK_ENTITY_DISTANCE = add(new Setting("option.block-entity-distance", false, false, 0, 0, 512, "blocks",
        "block entities (chests, signs, banners, heads...) beyond this many blocks are not drawn"));
    public static final Setting PARTICLE_DISTANCE = add(new Setting("option.particle-distance", false, false, 0, 0, 512, "blocks",
        "particles that start beyond this many blocks from the camera are not made"));
    public static final Setting PARTICLE_DENSITY = add(new Setting("option.particle-density", false, false, 100, 1, 100, "%",
        "only this share of new particles is made (100: all)"));
    /**
     * Package 13: dynamic lights (design doc, "Dynamic lights"): 0 off, 1 Fast (the nearest 8 lights, terrain only), 2
     * Fancy (the nearest 32, terrain plus entities and block entities). Off by default and in every preset; it adds light,
     * so it is listed with the options (it changes the picture). {@code lights/DynamicLights}.
     */
    public static final Setting DYNAMIC_LIGHTS = add(new Setting("option.dynamic-lights", false, false, 0, 0, 2, "",
        "held and dropped light sources, burning and glowing mobs and lit projectiles light the world around them (fast: nearest 8, terrain; fancy: nearest 32, terrain, entities and block entities)"));

    /**
     * Package 11: the look (design doc, "Pixel art city mode", natural palette only): 0 Normal, 1 Pixel art. Off by
     * default and in every preset. {@code look/PixelArt}.
     */
    public static final Setting LOOK = add(new Setting("option.look", false, false, 0, 0, 1, "",
        "normal, or pixel-art: the world drawn small in vanilla's own colours (a limited palette, dithered, with dark outlines on exposed edges) and scaled up with sharp pixels; the HUD, menus and text stay sharp"));
    /** Package 11: pixel art's pixel size: 1 small, 2 medium (default: 240 art lines, 3 window pixels at 720p), 3 large. Not in presets. */
    public static final Setting PIXEL_SIZE = add(new Setting("option.pixel-size", false, false, 2, 1, 3, "",
        "pixel art's pixel size: small (360 lines), medium (240) or large (144), at any window size"));
    /** Package 11: pixel art's ordered dithering (on by default). Not in presets. */
    public static final Setting PIXEL_DITHER = add(new Setting("option.pixel-dither", false, false, 1, 0, 1, "",
        "pixel art: ordered (Bayer) dithering between the palette's colours"));
    /** Package 11: pixel art's outlines on exposed edges (on by default). Not in presets. */
    public static final Setting PIXEL_OUTLINES = add(new Setting("option.pixel-outlines", false, false, 1, 0, 1, "",
        "pixel art: a dark one-pixel outline on exposed block edges"));

    /**
     * Package 12: far terrain (design doc, "Far terrain (like Ecstatic)"): 0 off, else how far it reaches, in chunks
     * ({@link #FAR_TERRAIN_CHOICES}). Sampled from the dimension's own noise, biomes and surface rules on background
     * threads, never generating or loading chunks; real chunks replace the samples once they exist. Off by default, in
     * Low-end and Balanced; 96 in Quality. {@code far/FarTerrain}.
     */
    public static final Setting FAR_TERRAIN = add(new Setting("option.far-terrain", false, false, 0, 32, 256, "chunks",
        "terrain beyond the render distance out to this many chunks (32, 64, 96, 128, 192 or 256), sampled from the world's own generator and drawn simply (no structures); real chunks replace it once they exist"));
    /**
     * Package 12c: far terrain's disk cache of sampled tiles (on by default), in the world's folder in single player and
     * per server address otherwise, so a second visit shows far terrain at once. Not in presets.
     */
    public static final Setting FAR_CACHE = add(new Setting("option.far-cache", false, false, 1, 0, 1, "",
        "far terrain: keep sampled tiles on disk per world (capped), so a second visit shows them at once"));
    /**
     * Package 12c: far terrain's seen-chunks cache (on by default): the real chunks the client has had on a server (or in
     * a world) kept on disk, so a server that doesn't share its seed still gets far terrain from land seen before. Local
     * only: nothing is sent. Not in presets.
     */
    public static final Setting FAR_SEEN = add(new Setting("option.far-seen", false, false, 1, 0, 1, "",
        "far terrain: keep the chunks you have seen on disk per server and world, and draw far terrain from them (local only)"));
    /** Package 12: the far terrain distances (chunks); 0 is off. */
    public static final int[] FAR_TERRAIN_CHOICES = {0, 32, 64, 96, 128, 192, 256};

    /** Package 11: the pixel art look's own choices, which no preset sets (a preset's look is Normal). */
    public static boolean presetFree(Setting s) {
        return s == PIXEL_SIZE || s == PIXEL_DITHER || s == PIXEL_OUTLINES || s == FAR_CACHE || s == FAR_SEEN;
    }

    // ---- CI only (not listed, not in the config file): checks the speed bench can switch like the others

    private static final Map<String, Setting> CI = new LinkedHashMap<>();
    /**
     * Package B: CI's check of fog-sections' automatic switch-off: while on, the fog hook's value is treated as never
     * having arrived (as with a mod that replaces vanilla's fog code), so fog-sections must switch itself off.
     */
    public static final Setting CI_FOG_UNCONFIRMED = ci(new Setting("ci.fog-unconfirmed", false, false, 0, 0, 1, "",
        "CI only: fog-sections acts as if vanilla's fog set-up had not run"));

    /**
     * Package 12c: CI's A/B of far terrain's cost cuts (measured with far terrain on): real sections past the hand-over
     * band left out under far terrain; far tiles drawn nearest first; the lighter mesh (skirts only where a neighbour's
     * spacing differs, flat runs merged, 64-block spacing past 128 chunks).
     */
    public static final Setting CI_FAR_NO_COVER = ci(new Setting("ci.far-no-cover", false, false, 0, 0, 1, "",
        "CI only: real sections past far terrain's hand-over band are drawn (12b)"));
    public static final Setting CI_FAR_NO_SORT = ci(new Setting("ci.far-no-sort", false, false, 0, 0, 1, "",
        "CI only: far tiles drawn in the map's order (12b)"));
    public static final Setting CI_FAR_NO_SPLIT = ci(new Setting("ci.far-no-split", false, false, 0, 0, 1, "",
        "CI only: far tiles near the band drawn in one part with the band's stage (12b)"));
    public static final Setting CI_FAR_NO_INSIDE = ci(new Setting("ci.far-no-inside", false, false, 0, 0, 1, "",
        "CI only: a split far tile's quads inside the hand-over circle stay in its band part"));
    public static final Setting CI_FAR_OLD_MESH = ci(new Setting("ci.far-old-mesh", false, false, 0, 0, 1, "",
        "CI only: far tiles with skirts on every edge, no merged runs, 32-block spacing at most (12b)"));

    /**
     * Package 12c: CI's switches for far terrain's new look (on: 12b's): snow and ice, the water's level and shores, the
     * relief shading and the haze ({@code ci.far-old-look}); per-type tree shapes ({@code ci.far-box-trees}); structure
     * silhouettes ({@code ci.far-no-structures}).
     */
    public static final Setting CI_FAR_OLD_LOOK = ci(new Setting("ci.far-old-look", false, false, 0, 0, 1, "",
        "CI only: far terrain's 12b look (no snow or ice, water at the block top, all-water quads, facing shade only, no haze)"));
    public static final Setting CI_FAR_BOX_TREES = ci(new Setting("ci.far-box-trees", false, false, 0, 0, 1, "",
        "CI only: far trees as boxes (12b)"));
    public static final Setting CI_FAR_NO_STRUCTURES = ci(new Setting("ci.far-no-structures", false, false, 0, 0, 1, "",
        "CI only: no structure silhouettes in far terrain (12b)"));

    /** Package 12c: CI's A/B of far terrain standing down underground (on: drawn underground too, as in 12b). */
    public static final Setting CI_FAR_NO_UNDERGROUND = ci(new Setting("ci.far-no-underground", false, false, 0, 0, 1, "",
        "CI only: far terrain drawn underground too (12b)"));

    private static Setting ci(Setting s) {
        CI.put(s.key, s);
        return s;
    }

    /** A switch by name, the CI-only ones included (the speed bench's lookup). */
    public static Setting byKey(String key) {
        Setting s = ALL.get(key);
        return s != null ? s : Boolean.getBoolean("quicksilver.ci.speed") ? CI.get(key) : null;
    }

    /** Counted while a speed bench window measures (bench only). */
    public static final LongAdder SECTIONS_IN_FOG = new LongAdder(), SECTIONS_SEEN = new LongAdder(), CUTOUT_SKIPPED = new LongAdder(),
        ENTITIES_HIDDEN = new LongAdder(), BLOCK_ENTITIES_HIDDEN = new LongAdder(), PARTICLES_DROPPED = new LongAdder(),
        TERRAIN_TRIANGLES = new LongAdder(), SECTIONS_UNDER_FAR = new LongAdder();
    public static volatile boolean counting;

    private static boolean loaded, locked;

    private Speed() {
    }

    private static Setting add(Setting s) {
        ALL.put(s.key, s);
        return s;
    }

    public static Map<String, Setting> all() {
        return ALL;
    }

    /** Reads every switch from {@code config/quicksilver.properties} (missing lines keep their defaults). */
    public static synchronized void load() {
        if (loaded) return;
        loaded = true;
        if (Boolean.getBoolean("quicksilver.ci.measureOnly")) {
            locked = true;
            for (Setting s : ALL.values()) s.value = s.key.equals(PARTICLE_DENSITY.key) ? 100 : s == PIXEL_SIZE ? 2 : 0;
            QuicksilverClient.LOG.info("Quicksilver speed: every approximation and option off (measure run)");
            return;
        }
        Path file = FabricLoader.getInstance().getConfigDir().resolve("quicksilver.properties");
        Properties p = new Properties();
        if (Files.exists(file)) {
            try (InputStream in = Files.newInputStream(file)) {
                p.load(in);
            } catch (IOException e) {
                QuicksilverClient.LOG.warn("Quicksilver speed: could not read {}; every switch keeps its default", file, e);
            }
        }
        StringBuilder log = new StringBuilder();
        for (Setting s : ALL.values()) {
            String v = p.getProperty(s.key);
            if (v != null) {
                Integer parsed = parse(s, v.trim());
                if (parsed == null) {
                    QuicksilverClient.LOG.warn("Quicksilver speed: {}={} in {} is not valid; it stays at its default", s.key, v, file);
                } else {
                    s.value = parsed;
                }
            }
            if (log.length() > 0) log.append(", ");
            log.append(s.key).append('=').append(show(s));
        }
        QuicksilverClient.LOG.info("Quicksilver speed: {}", log);
    }

    static Integer parse(Setting s, String v) {
        if (s.key.equals("option.dynamic-lights")) {
            if (v.equalsIgnoreCase("fast") || v.equalsIgnoreCase("on")) return 1;
            if (v.equalsIgnoreCase("fancy")) return 2;
        }
        if (s.key.equals("option.look")) {
            if (v.equalsIgnoreCase("normal") || v.equalsIgnoreCase("off")) return 0;
            if (v.equalsIgnoreCase("pixel-art") || v.equalsIgnoreCase("pixel") || v.equalsIgnoreCase("on") || v.equals("1") || v.equalsIgnoreCase("true")) return 1;
            if (v.equals("0") || v.equalsIgnoreCase("false")) return 0;
            return null;
        }
        if (s.key.equals("option.far-terrain")) {
            if (v.equalsIgnoreCase("off") || v.equalsIgnoreCase("false")) return 0;
            try {
                int n = Integer.parseInt(v);
                for (int c : FAR_TERRAIN_CHOICES) if (c == n) return n;
                return null;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (s.key.equals("option.pixel-size")) {
            for (int i = 1; i <= 3; i++) if (v.equalsIgnoreCase(PIXEL_SIZE_NAMES[i])) return i;
            try {
                int n = Integer.parseInt(v);
                return n >= 1 && n <= 3 ? n : null;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        if (v.equalsIgnoreCase("on") || v.equalsIgnoreCase("true")) return s.bool() ? 1 : null;
        if (v.equalsIgnoreCase("off") || v.equalsIgnoreCase("false")) return s.key.equals(PARTICLE_DENSITY.key) ? 100 : 0;
        try {
            int n = Integer.parseInt(v);
            if (n == 0 && !s.key.equals(PARTICLE_DENSITY.key)) return 0;
            if (n < s.min || n > s.max) return null;
            return n;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /** Package 11: the pixel sizes' names (1-3). */
    public static final String[] PIXEL_SIZE_NAMES = {"medium", "small", "medium", "large"};

    public static String show(Setting s) {
        if (s.key.equals("option.dynamic-lights")) return s.value == 1 ? "fast" : s.value == 2 ? "fancy" : "off";
        if (s.key.equals("option.look")) return s.value == 1 ? "pixel-art" : "normal";
        if (s.key.equals("option.pixel-size")) return PIXEL_SIZE_NAMES[s.value >= 1 && s.value <= 3 ? s.value : 2];
        if (s.bool()) return s.on() ? "on" : "off";
        if (s.key.equals(PARTICLE_DENSITY.key)) return s.value + "%";
        return s.on() ? s.value + " " + s.unit : "off";
    }

    /**
     * Sets a switch (the command, or the speed bench). Re-meshes the world if the switch changes meshes. Returns why not,
     * or null.
     */
    public static String set(Setting s, int value) {
        if (locked) return "switches stay off in a measure run";
        boolean offValue = (value == 0 && s != PIXEL_SIZE) || (s.key.equals(PARTICLE_DENSITY.key) && value == 100);
        if (!offValue && (value < s.min || value > s.max)) return "takes " + s.min + "-" + s.max + (s.unit.isEmpty() ? "" : " " + s.unit);
        if (s == FAR_TERRAIN && parse(s, String.valueOf(value)) == null) return "takes off, 32, 64, 96, 128, 192 or 256 chunks";
        if (s.value == value) return null;
        s.value = value;
        QuicksilverClient.LOG.info("Quicksilver speed: {} = {}", s.key, show(s));
        if (s.remesh) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.levelExtractor != null) {
                mc.levelExtractor.allChanged();
                REMESHES.increment();
            }
        }
        return null;
    }

    /** Package 9: how many times a switch re-meshed the world (the settings screen's CI test checks it). */
    public static final LongAdder REMESHES = new LongAdder();

    /**
     * Package 9: sets several switches at once (a preset), re-meshing the world once if any changed switch needs it.
     * Returns why not, or null; nothing changes if any value is out of range.
     */
    public static String setAll(Map<String, Integer> values) {
        if (locked) return "switches stay off in a measure run";
        for (Map.Entry<String, Integer> e : values.entrySet()) {
            Setting s = ALL.get(e.getKey());
            if (s == null) return "no switch called " + e.getKey();
            int value = e.getValue();
            if (value == 0 && s.key.equals(PARTICLE_DENSITY.key)) return "particle density takes 1-100";
            boolean offValue = value == 0 || (s.key.equals(PARTICLE_DENSITY.key) && value == 100);
            if (!offValue && (value < s.min || value > s.max)) return s.key + " takes " + s.min + "-" + s.max;
            if (s == FAR_TERRAIN && parse(s, String.valueOf(value)) == null) return s.key + " takes off, 32, 64, 96, 128, 192 or 256";
        }
        boolean remesh = false;
        StringBuilder log = new StringBuilder();
        for (Map.Entry<String, Integer> e : values.entrySet()) {
            Setting s = ALL.get(e.getKey());
            if (s.value == e.getValue()) continue;
            s.value = e.getValue();
            remesh |= s.remesh;
            if (log.length() > 0) log.append(", ");
            log.append(s.key).append('=').append(show(s));
        }
        if (log.length() > 0) QuicksilverClient.LOG.info("Quicksilver speed: {}", log);
        if (remesh) {
            Minecraft mc = Minecraft.getInstance();
            if (mc != null && mc.levelExtractor != null) {
                mc.levelExtractor.allChanged();
                REMESHES.increment();
            }
        }
        return null;
    }

    /** Package 9: a switch's value as written in the config file (on/off, or the number; parse reads it back). */
    public static String fileValue(Setting s) {
        if (s.key.equals("option.dynamic-lights") || s.key.equals("option.look") || s.key.equals("option.pixel-size")) return show(s);
        if (s.bool()) return s.on() ? "on" : "off";
        if (s.key.equals(PARTICLE_DENSITY.key)) return String.valueOf(s.value);
        return s.on() ? String.valueOf(s.value) : "off";
    }

    /** Package 9: the value a switch would take from this text (the screen's and the command's parser), or null. */
    public static Integer parseValue(Setting s, String v) {
        return parse(s, v);
    }

    /** Package 9: whether the switches can be changed (false in CI's measure runs). */
    public static boolean locked() {
        return locked;
    }

    // ---- checks used by the modules (cheap: called per section, entity or particle)

    /** The camera of the frame being extracted (render thread; from the terrain module's camera hook). */
    public static volatile double camX, camY, camZ;
    private static volatile boolean cameraKnown;

    /** Whether the terrain module's camera hook has run (the distance tests need it). */
    public static boolean cameraKnown() {
        return cameraKnown;
    }

    public static void camera(double x, double y, double z) {
        camX = x;
        camY = y;
        camZ = z;
        cameraKnown = true;
    }

    /** Particle density: of every 100 new particles, keeps {@code density}, spread evenly (an error accumulator). */
    private static int densityAcc;

    /** True if a new particle at this position is not to be made (particle density or distance). */
    public static boolean dropNewParticle(double x, double y, double z) {
        int d = PARTICLE_DENSITY.value;
        if (d < 100) {
            densityAcc += d;
            if (densityAcc < 100) {
                if (counting) PARTICLES_DROPPED.increment();
                return true;
            }
            densityAcc -= 100;
        }
        int far = PARTICLE_DISTANCE.value;
        if (far > 0 && cameraKnown) {
            double dx = x - camX, dy = y - camY, dz = z - camZ;
            if (dx * dx + dy * dy + dz * dz > (double) far * far) {
                if (counting) PARTICLES_DROPPED.increment();
                return true;
            }
        }
        return false;
    }

    /** True if an entity at this distance (squared, blocks) from the camera is not to be drawn (entity distance). */
    public static boolean entityTooFar(double distSq) {
        int far = ENTITY_DISTANCE.value;
        if (far > 0 && distSq > (double) far * far) {
            if (counting) ENTITIES_HIDDEN.increment();
            return true;
        }
        return false;
    }

    /** As {@link #entityTooFar}, for block entities. */
    public static boolean blockEntityTooFar(double distSq) {
        int far = BLOCK_ENTITY_DISTANCE.value;
        if (far > 0 && cameraKnown && distSq > (double) far * far) {
            if (counting) BLOCK_ENTITIES_HIDDEN.increment();
            return true;
        }
        return false;
    }

    // ---- command

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        for (String name : new String[] {"quicksilver", "qs"}) {
            LiteralArgumentBuilder<FabricClientCommandSource> speed = ClientCommands.literal("speed").executes(c -> list(c.getSource()));
            speed.then(ClientCommands.argument("name", StringArgumentType.word())
                .suggests((c, b) -> {
                    for (Setting s : ALL.values()) b.suggest(s.key);
                    return b.buildFuture();
                })
                .executes(c -> show(c.getSource(), StringArgumentType.getString(c, "name")))
                .then(ClientCommands.argument("value", StringArgumentType.word())
                    .suggests((c, b) -> {
                        b.suggest("on");
                        b.suggest("off");
                        b.suggest("fast");
                        b.suggest("fancy");
                        b.suggest("normal");
                        b.suggest("pixel-art");
                        b.suggest("small");
                        b.suggest("medium");
                        b.suggest("large");
                        return b.buildFuture();
                    })
                    .executes(c -> setCommand(c.getSource(), StringArgumentType.getString(c, "name"), StringArgumentType.getString(c, "value")))));
            dispatcher.register(ClientCommands.literal(name).then(speed));
        }
    }

    private static Setting find(String name) {
        Setting s = ALL.get(name);
        if (s != null) return s;
        for (Setting t : ALL.values()) if (t.key.endsWith("." + name)) return t;
        return null;
    }

    private static int list(FabricClientCommandSource src) {
        src.sendFeedback(Component.literal("[Quicksilver] Speed switches (approx.* are invisible, option.* change the picture):"));
        for (Setting s : ALL.values()) src.sendFeedback(Component.literal("  " + s.key + " = " + show(s) + ": " + s.what));
        return 1;
    }

    private static int show(FabricClientCommandSource src, String name) {
        Setting s = find(name);
        if (s == null) {
            src.sendError(Component.literal("[Quicksilver] No speed switch called " + name + " (/qs speed lists them)."));
            return 0;
        }
        src.sendFeedback(Component.literal("[Quicksilver] " + s.key + " = " + show(s) + ": " + s.what));
        return 1;
    }

    private static int setCommand(FabricClientCommandSource src, String name, String value) {
        Setting s = find(name);
        if (s == null) {
            src.sendError(Component.literal("[Quicksilver] No speed switch called " + name + " (/qs speed lists them)."));
            return 0;
        }
        Integer v = parse(s, value);
        if (v == null) {
            String takes = s == LOOK ? "normal or pixel-art" : s == PIXEL_SIZE ? "small, medium or large" : s.bool() ? "on or off" : "off or " + s.min + "-" + s.max + " " + s.unit;
            src.sendError(Component.literal("[Quicksilver] " + s.key + " takes " + takes + "."));
            return 0;
        }
        String why = set(s, v);
        if (why != null) {
            src.sendError(Component.literal("[Quicksilver] " + s.key + ": " + why + "."));
            return 0;
        }
        // package 9: saved, so the file and the options screen show the same as the command
        boolean saved = com.meakaandre.quicksilver.settings.Settings.save();
        src.sendFeedback(Component.literal("[Quicksilver] " + s.key + " = " + show(s) + (saved ? " (saved; preset: "
            + com.meakaandre.quicksilver.settings.Settings.current().id + ")." : " (not saved: see the log).")));
        return 1;
    }

    /** The bench's block: every switch's value. */
    public static JsonObject json() {
        JsonObject o = new JsonObject();
        for (Setting s : ALL.values()) o.addProperty(s.key, show(s));
        // package B: whether fog-sections works or switched itself off, and why
        o.addProperty("fogSectionsState", SpeedTerrain.fogState());
        return o;
    }
}
