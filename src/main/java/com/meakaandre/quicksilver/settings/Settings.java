package com.meakaandre.quicksilver.settings;

import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.speed.Speed;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Package 9: the settings behind Quicksilver's options screen, presets and the config file.
 *
 * <p>Everything lives in {@code config/quicksilver.properties}, as before: package A's speed switches ({@link Speed}, one
 * line each, applied at once) and the modules' switches (block renderer, occlusion, Memory, Logic and Chunks and each of
 * their optimisations; read once at start-up, so they need a restart). The screen, {@code /qs speed} and the file show the
 * same values: the screen and the command save the file when they change something, and the file is read at start-up.
 * The file's {@code preset=} line decides at start-up: a named preset sets every speed switch, {@code custom} keeps the
 * file's own speed lines (so a hand edit of a speed line needs {@code preset=custom}).
 *
 * <p>Presets set every speed switch at once: {@link Preset#LOW_END} the visible speed options, {@link Preset#BALANCED}
 * (the default) only the invisible approximations, {@link Preset#QUALITY} nothing (vanilla's exact order and every
 * section drawn). The preset shown is the one whose values the switches hold now, {@link Preset#CUSTOM} if none: so a
 * change made anywhere (the screen, the command) shows "Custom" and is saved as {@code preset=custom}.
 */
public final class Settings {
    private Settings() {
    }

    /** A preset: every speed switch's value. */
    public enum Preset {
        LOW_END("low-end"), BALANCED("balanced"), QUALITY("quality"), CUSTOM("custom");

        public final String id;

        Preset(String id) {
            this.id = id;
        }

        public static Preset byId(String id) {
            for (Preset p : values()) if (p.id.equalsIgnoreCase(id.trim())) return p;
            return null;
        }

        /** The value of each speed switch (key to value; every switch of {@link Speed#all()} is listed); empty for CUSTOM. */
        public Map<String, Integer> switches() {
            return PRESETS.getOrDefault(this, Map.of());
        }
    }

    private static final Map<Preset, Map<String, Integer>> PRESETS = new LinkedHashMap<>();

    static {
        // Low-end (docs/progress.md, package 9, "Decisions for Andre"): the approximations, and every visible speed option
        // on; R2's low-end instance (opaque leaves, far detail 4) plus simple water and the distance and density options at
        // the values package A measured or a little further out
        Map<String, Integer> low = new LinkedHashMap<>();
        low.put(Speed.FOG_SECTIONS.key, 1);
        low.put(Speed.TRANSLUCENT_REGIONS.key, 1);
        low.put(Speed.OPAQUE_LEAVES.key, 1);
        low.put(Speed.SIMPLE_WATER.key, 1);
        low.put(Speed.FAR_CUTOUT.key, 4);
        low.put(Speed.ENTITY_DISTANCE.key, 48);
        low.put(Speed.BLOCK_ENTITY_DISTANCE.key, 32);
        low.put(Speed.PARTICLE_DISTANCE.key, 24);
        low.put(Speed.PARTICLE_DENSITY.key, 50);
        // package 13: dynamic lights are off in every preset (Balanced and Quality take the default, off)
        low.put(Speed.DYNAMIC_LIGHTS.key, 0);
        PRESETS.put(Preset.LOW_END, low);
        // Balanced (the default): the invisible approximations only, every visible option off (Quicksilver's defaults)
        Map<String, Integer> balanced = new LinkedHashMap<>();
        for (Speed.Setting s : Speed.all().values()) balanced.put(s.key, s.defaultValue);
        PRESETS.put(Preset.BALANCED, balanced);
        // Quality: the approximations off too (every terrain section inside the fog drawn, translucent terrain in vanilla's
        // exact order)
        Map<String, Integer> quality = new LinkedHashMap<>();
        for (Speed.Setting s : Speed.all().values()) quality.put(s.key, s.key.equals(Speed.PARTICLE_DENSITY.key) ? 100 : 0);
        PRESETS.put(Preset.QUALITY, quality);
        for (Map<String, Integer> m : PRESETS.values()) {
            if (!m.keySet().equals(Speed.all().keySet())) throw new IllegalStateException("a preset misses a speed switch: " + m.keySet());
        }
    }

    /** The preset whose values every speed switch holds now, or CUSTOM. */
    public static Preset current() {
        for (Preset p : new Preset[] {Preset.BALANCED, Preset.LOW_END, Preset.QUALITY}) {
            boolean all = true;
            for (Map.Entry<String, Integer> e : p.switches().entrySet()) {
                Speed.Setting s = Speed.all().get(e.getKey());
                if (s == null || s.value() != e.getValue()) {
                    all = false;
                    break;
                }
            }
            if (all) return p;
        }
        return Preset.CUSTOM;
    }

    /** Sets every speed switch to the preset's value (re-meshing once if any needs it) and saves the file. */
    public static String apply(Preset p) {
        if (p == Preset.CUSTOM) return null;
        String why = Speed.setAll(p.switches());
        if (why == null) save();
        return why;
    }

    // ---- the modules' switches (start-up only)

    /** One of the modules' config lines: its key, the values it takes (the first is the default), what it does. */
    public record ModuleSwitch(String key, List<String> choices, String module, String what) {
        public String defaultValue() {
            return choices.get(0);
        }
    }

    /** Every module switch, in the screen's order: the whole modules first, then each optimisation of each. */
    public static List<ModuleSwitch> moduleSwitches() {
        List<ModuleSwitch> out = new ArrayList<>();
        out.add(new ModuleSwitch("block-renderer", List.of("on", "off"), "renderer",
            "Quicksilver's block and item renderer (Fabric Renderer API); off: vanilla's"));
        out.add(new ModuleSwitch("occlusion", List.of("auto", "two-phase", "still-camera", "off"), "occlusion",
            "hides terrain sections proven hidden behind other terrain"));
        out.add(new ModuleSwitch("memory", List.of("on", "off"), "memory", "the Memory module: less memory for block states and shapes"));
        out.add(new ModuleSwitch("logic", List.of("on", "off"), "logic", "the Logic module: faster entity, hopper and mob AI ticks"));
        out.add(new ModuleSwitch("chunks", List.of("on", "off"), "chunks", "the Chunks module: cheaper chunk saving"));
        for (Map.Entry<String, String> e : com.meakaandre.quicksilver.memory.Memory.optimisations().entrySet()) {
            if (e.getKey().equals("bench-buffers")) continue;  // the bench's own buffers: not a player's switch (file only)
            out.add(new ModuleSwitch("memory." + e.getKey(), List.of("on", "off"), "memory", e.getValue()));
        }
        for (Map.Entry<String, String> e : com.meakaandre.quicksilver.logic.Logic.optimisations().entrySet()) {
            out.add(new ModuleSwitch("logic." + e.getKey(), List.of("on", "off"), "logic", e.getValue()));
        }
        for (Map.Entry<String, String> e : com.meakaandre.quicksilver.chunks.Chunks.optimisations().entrySet()) {
            out.add(new ModuleSwitch("chunks." + e.getKey(), List.of("on", "off"), "chunks", e.getValue()));
        }
        return out;
    }

    /** The module switches' values as the file held them at start-up (what the modules run with). */
    private static final Map<String, String> AT_STARTUP = new LinkedHashMap<>();
    /** The module switches' values chosen since (saved to the file, used after a restart). */
    private static final Map<String, String> CHOSEN = new LinkedHashMap<>();

    /** Reads the file once at start-up (after {@link Speed#load()}): a preset named there, and the module switches. */
    public static synchronized void load() {
        Properties p = read();
        // what the modules run with: the file as it is now, at start-up (review: filled later, a file edited during the
        // session showed as the running value)
        for (ModuleSwitch m : moduleSwitches()) startupValue(m);
        if (Boolean.getBoolean("quicksilver.ci.measureOnly")) return;
        String preset = p.getProperty("preset");
        if (preset != null) {
            Preset pr = Preset.byId(preset);
            if (pr == null) {
                QuicksilverClient.LOG.warn("Quicksilver settings: preset={} in config/quicksilver.properties is not a preset (low-end, balanced, quality, custom)", preset);
            } else if (pr != Preset.CUSTOM) {
                // a named preset sets every speed switch, whatever the file's own lines say (review: otherwise an edit of
                // preset= by hand did nothing once the screen had written every line); preset=custom keeps the lines
                Speed.setAll(pr.switches());
            }
        }
        QuicksilverClient.LOG.info("Quicksilver settings: preset {} ({})", current().id, preset == null ? "no preset line in the file" : "file: preset=" + preset);
    }

    /** A module switch's value as it is in the file now (or as chosen in the screen since), or its default. */
    public static synchronized String moduleValue(ModuleSwitch m) {
        String v = CHOSEN.get(m.key());
        if (v == null) v = startupValue(m);
        return v;
    }

    /** What the module runs with now (the file at start-up). */
    public static synchronized String startupValue(ModuleSwitch m) {
        String v = AT_STARTUP.get(m.key());
        if (v == null) {
            String f = read().getProperty(m.key());
            v = f == null ? m.defaultValue() : f.trim().toLowerCase(Locale.ROOT);
            if (!m.choices().contains(v)) v = m.defaultValue();
            AT_STARTUP.put(m.key(), v);
        }
        return v;
    }

    /** Chooses a module switch's value (saved to the file at once; the module uses it after a restart). */
    public static synchronized void setModule(ModuleSwitch m, String value) {
        if (!m.choices().contains(value)) return;
        CHOSEN.put(m.key(), value);
        save();
    }

    /** True if a module switch was changed since start-up (the screen then says a restart is needed). */
    public static synchronized boolean restartNeeded() {
        for (ModuleSwitch m : moduleSwitches()) if (!moduleValue(m).equals(startupValue(m))) return true;
        return false;
    }

    // ---- the file

    static Path file() {
        return FabricLoader.getInstance().getConfigDir().resolve("quicksilver.properties");
    }

    static Properties read() {
        Properties p = new Properties();
        Path f = file();
        if (Files.exists(f)) {
            try (InputStream in = Files.newInputStream(f)) {
                p.load(in);
            } catch (IOException e) {
                QuicksilverClient.LOG.warn("Quicksilver settings: could not read {}", f, e);
            }
        }
        return p;
    }

    /**
     * Writes every speed switch, the preset and the module switches chosen in the screen to the file, keeping every other
     * line in it (written to a temporary file and moved into place, so a crash can't leave half a file). In a measure run
     * (CI's vanilla stand-in) nothing is written.
     */
    public static synchronized boolean save() {
        if (Boolean.getBoolean("quicksilver.ci.measureOnly")) return false;
        Path f = file();
        Properties p = read();
        for (Speed.Setting s : Speed.all().values()) p.setProperty(s.key, Speed.fileValue(s));
        p.setProperty("preset", current().id);
        for (Map.Entry<String, String> e : CHOSEN.entrySet()) p.setProperty(e.getKey(), e.getValue());
        try {
            Files.createDirectories(f.getParent());
            Path tmp = f.resolveSibling(f.getFileName() + ".tmp");
            try (OutputStream out = Files.newOutputStream(tmp)) {
                p.store(out, COMMENT);
            }
            try {
                Files.move(tmp, f, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (java.nio.file.AtomicMoveNotSupportedException e) {
                Files.move(tmp, f, StandardCopyOption.REPLACE_EXISTING);
            }
            return true;
        } catch (IOException e) {
            QuicksilverClient.LOG.warn("Quicksilver settings: could not write {}", f, e);
            return false;
        }
    }

    static final String COMMENT = com.meakaandre.quicksilver.chunks.Chunks.COMMENT
        + " preset: low-end, balanced (default), quality or custom (the options screen, Video Settings > Quicksilver);"
        + " a named preset sets every approx.* and option.* line at start-up, custom keeps them."
        + " approx.* and option.*: the speed switches (/qs speed lists them), applied at once.";
}
