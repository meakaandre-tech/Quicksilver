package com.meakaandre.quicksilver.settings;

import com.meakaandre.quicksilver.settings.Settings.ModuleSwitch;
import com.meakaandre.quicksilver.settings.Settings.Preset;
import com.meakaandre.quicksilver.speed.Speed;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;

/**
 * Package 9: Quicksilver's options screen, in vanilla's options-screen style (an {@link OptionsSubScreen}: a title, a
 * scrolling two-column list of buttons, Done). Opens from Video Settings (a "Quicksilver..." button at the end of its
 * list, {@link VideoSettingsButton}), from Mod Menu if it is installed ({@link ModMenuEntry}) and with {@code /qs settings}.
 *
 * <p>Rows: the preset; the speed options that change the look; the invisible approximations; the modules' switches (need
 * a restart). Every button has a one-line tooltip saying what it does and whether it changes the look. A speed switch
 * applies at once (opaque leaves and simple water re-mesh the world) and saves the file; a preset sets them all.
 */
public final class SettingsScreen extends OptionsSubScreen {
    /** Every row's caption and tooltip, by config key ({@code preset} for the preset); the test reads this. */
    static final Map<String, String[]> TEXT = new LinkedHashMap<>();

    static {
        TEXT.put("preset", new String[] {"Preset", "Low-end: every speed option on (changes the look). Balanced: only shortcuts you can't see. Quality: none, vanilla's exact picture."});
        TEXT.put(Speed.OPAQUE_LEAVES.key, new String[] {"Opaque leaves", "Draws leaves solid, without see-through gaps. Changes the look."});
        TEXT.put(Speed.SIMPLE_WATER.key, new String[] {"Simple water", "Draws water solid: faster, but you can't see into it. Changes the look."});
        TEXT.put(Speed.FAR_CUTOUT.key, new String[] {"Far detail", "Beyond this distance, grass, flowers, crops and see-through leaves aren't drawn. Changes the look."});
        TEXT.put(Speed.ENTITY_DISTANCE.key, new String[] {"Entities", "Mobs and other entities beyond this distance aren't drawn (players always are). Changes the look."});
        TEXT.put(Speed.BLOCK_ENTITY_DISTANCE.key, new String[] {"Block entities", "Chests, signs, banners and heads beyond this distance aren't drawn. Changes the look."});
        TEXT.put(Speed.PARTICLE_DISTANCE.key, new String[] {"Particles", "Particles that start beyond this distance aren't made. Changes the look."});
        TEXT.put(Speed.PARTICLE_DENSITY.key, new String[] {"Particle density", "Makes only this share of new particles. Changes the look."});
        TEXT.put(Speed.DYNAMIC_LIGHTS.key, new String[] {"Dynamic lights", "Torches and lanterns you hold or drop, burning mobs and lit arrows light up what's around them. Fast: the 8 nearest, on blocks. Fancy: the 32 nearest, on mobs and chests too. Changes the look."});
        TEXT.put(Speed.LOOK.key, new String[] {"Look", "Normal, or Pixel art: the world drawn small in a limited palette of vanilla's own colours, dithered, with dark outlines on exposed block edges, and scaled up with sharp pixels. The HUD, menus and text stay sharp. Draws fewer pixels, so it is usually faster. Changes the look."});
        TEXT.put(Speed.PIXEL_SIZE.key, new String[] {"Pixel size", "How big pixel art's pixels are: Small, Medium or Large (the same at any window size). Changes the look."});
        TEXT.put(Speed.PIXEL_DITHER.key, new String[] {"Dithering", "Pixel art: in-between shades drawn as a fixed pattern of two palette colours. Changes the look."});
        TEXT.put(Speed.PIXEL_OUTLINES.key, new String[] {"Outlines", "Pixel art: a dark one-pixel line on exposed block edges (none between blocks that join). Changes the look."});
        TEXT.put(Speed.FOG_SECTIONS.key, new String[] {"Fog culling", "Skips terrain that is wholly hidden in the distance fog. Doesn't change the look."});
        TEXT.put(Speed.TRANSLUCENT_REGIONS.key, new String[] {"Fewer glass draws", "Draws water, glass and ice in fewer batches on Intel and older GPUs. Doesn't change the look."});
        TEXT.put("block-renderer", new String[] {"Block renderer", "Quicksilver's block and item renderer; off uses vanilla's. Doesn't change the look. Needs a restart."});
        TEXT.put("occlusion", new String[] {"Occlusion", "Skips terrain hidden behind other terrain; auto picks the way for your GPU. Doesn't change the look. Needs a restart."});
        TEXT.put("memory", new String[] {"Memory module", "Uses less memory for block states and shapes. Doesn't change the look. Needs a restart."});
        TEXT.put("logic", new String[] {"Logic module", "Faster entity, hopper and mob ticks, with vanilla's exact results. Doesn't change the look. Needs a restart."});
        TEXT.put("chunks", new String[] {"Chunks module", "Cheaper chunk saving, with vanilla's exact files. Doesn't change the look. Needs a restart."});
        // each optimisation of the modules, in plain words (review: the modules' own descriptions are for developers)
        TEXT.put("memory.state-neighbours", new String[] {"State neighbours", "Memory module: block states share one lookup table. Doesn't change the look. Needs a restart."});
        TEXT.put("memory.shape-dedup", new String[] {"Shape sharing", "Memory module: identical block shapes are stored once. Doesn't change the look. Needs a restart."});
        TEXT.put("memory.datafixer-caches", new String[] {"Datafixer caches", "Memory module: frees world-upgrade caches after start-up. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.block-collisions", new String[] {"Block collisions", "Logic module: faster mob and item collisions with blocks. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.entity-sections", new String[] {"Entity lookups", "Logic module: faster searches for nearby entities. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.entity-collisions", new String[] {"Entity collisions", "Logic module: faster collisions between entities. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.brain-behaviours", new String[] {"Mob brains", "Logic module: villagers' and mobs' AI does less repeated work. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.gate-behaviours", new String[] {"Mob AI checks", "Logic module: skips AI steps that can't run yet. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.hopper-entities", new String[] {"Hopper item checks", "Logic module: hoppers look for items less wastefully. Doesn't change the look. Needs a restart."});
        TEXT.put("logic.block-entity-checks", new String[] {"Block entity checks", "Logic module: block entities skip a repeated check. Doesn't change the look. Needs a restart."});
        TEXT.put("chunks.cow-sections", new String[] {"Copy on save", "Chunks module: saving copies only the parts that change. Doesn't change the look. Needs a restart."});
    }

    /** The choices a number switch offers (0 = off); the switch's own value is added if it isn't one of them. */
    private static final Map<String, int[]> CHOICES = Map.of(
        Speed.FAR_CUTOUT.key, new int[] {0, 2, 3, 4, 6, 8, 12, 16},
        Speed.ENTITY_DISTANCE.key, new int[] {0, 16, 24, 32, 48, 64, 96, 128},
        Speed.BLOCK_ENTITY_DISTANCE.key, new int[] {0, 12, 16, 24, 32, 48, 64},
        Speed.PARTICLE_DISTANCE.key, new int[] {0, 8, 12, 16, 24, 32},
        Speed.PARTICLE_DENSITY.key, new int[] {100, 75, 50, 25, 10},
        Speed.DYNAMIC_LIGHTS.key, new int[] {0, 1, 2},
        Speed.PIXEL_SIZE.key, new int[] {1, 2, 3});

    /** Package 11: the Look section's buttons. */
    static final List<Speed.Setting> LOOK_ROW = List.of(Speed.LOOK, Speed.PIXEL_SIZE, Speed.PIXEL_DITHER, Speed.PIXEL_OUTLINES);

    private CycleButton<Preset> presetButton;
    private final Map<String, CycleButton<Integer>> speedButtons = new LinkedHashMap<>();
    private final Map<String, CycleButton<String>> moduleButtons = new LinkedHashMap<>();
    /** Every button this screen made, for the CI test's layout check. */
    final List<AbstractWidget> made = new ArrayList<>();

    public SettingsScreen(Screen lastScreen) {
        super(lastScreen, Minecraft.getInstance().options, Component.literal("Quicksilver"));
    }

    static Tooltip tip(String key) {
        String[] t = TEXT.get(key);
        return Tooltip.create(Component.literal(t == null ? "" : t[1]));
    }

    static String caption(String key) {
        String[] t = TEXT.get(key);
        return t == null ? key : t[0];
    }

    @Override
    protected void addOptions() {
        speedButtons.clear();
        moduleButtons.clear();
        made.clear();
        boolean locked = Speed.locked();
        presetButton = CycleButton.<Preset>builder(p -> Component.literal(name(p)), Settings.current())
            .withValues(Preset.LOW_END, Preset.BALANCED, Preset.QUALITY)
            .withTooltip(p -> tip("preset"))
            .create(0, 0, 310, 20, Component.literal(caption("preset")), (b, p) -> choosePreset(p));
        presetButton.active = !locked;
        made.add(presetButton);
        this.list.addBig(presetButton);

        // package 11: the look (Normal or Pixel art; Normal in every preset) and pixel art's own choices (in no preset)
        this.list.addHeader(Component.literal("Look"));
        List<AbstractWidget> look = new ArrayList<>();
        for (Speed.Setting s : LOOK_ROW) look.add(speedButton(s, locked));
        addRows(look);

        // package 13: lighting (dynamic lights; off in every preset)
        this.list.addHeader(Component.literal("Lighting"));
        List<AbstractWidget> row = new ArrayList<>();
        row.add(speedButton(Speed.DYNAMIC_LIGHTS, locked));
        addRows(row);

        this.list.addHeader(Component.literal("Speed options (change the look)"));
        row = new ArrayList<>();
        for (Speed.Setting s : Speed.all().values()) if (!s.approximation && s != Speed.DYNAMIC_LIGHTS && !LOOK_ROW.contains(s)) row.add(speedButton(s, locked));
        addRows(row);

        this.list.addHeader(Component.literal("Shortcuts you can't see"));
        row = new ArrayList<>();
        for (Speed.Setting s : Speed.all().values()) if (s.approximation) row.add(speedButton(s, locked));
        addRows(row);

        this.list.addHeader(Component.literal(Settings.restartNeeded() ? "Modules: restart Minecraft to apply your changes" : "Modules (need a restart)"));
        row = new ArrayList<>();
        for (ModuleSwitch m : Settings.moduleSwitches()) row.add(moduleButton(m, locked));
        addRows(row);
    }

    private void addRows(List<AbstractWidget> widgets) {
        for (int i = 0; i < widgets.size(); i += 2) {
            if (i + 1 < widgets.size()) this.list.addSmall(widgets.get(i), widgets.get(i + 1));
            else this.list.addSmall(List.of(widgets.get(i)));
        }
    }

    static String name(Preset p) {
        return switch (p) {
            case LOW_END -> "Low-end";
            case BALANCED -> "Balanced";
            case QUALITY -> "Quality";
            case CUSTOM -> "Custom";
        };
    }

    static String show(Speed.Setting s, int v) {
        if (s == Speed.DYNAMIC_LIGHTS) return v == 1 ? "Fast" : v == 2 ? "Fancy" : "Off";
        if (s == Speed.LOOK) return v == 1 ? "Pixel art" : "Normal";
        if (s == Speed.PIXEL_SIZE) return v == 1 ? "Small" : v == 3 ? "Large" : "Medium";
        if (s.max == 1) return v != 0 ? "On" : "Off";
        if (s.key.equals(Speed.PARTICLE_DENSITY.key)) return v >= 100 ? "All" : v + "%";
        if (v == 0) return "Off";
        return v + " " + s.unit;
    }

    private CycleButton<Integer> speedButton(Speed.Setting s, boolean locked) {
        List<Integer> values = new ArrayList<>();
        if (s.max == 1) {
            values.add(0);
            values.add(1);
        } else {
            TreeSet<Integer> set = new TreeSet<>();
            for (int c : CHOICES.getOrDefault(s.key, new int[] {0})) set.add(c);
            set.add(s.value());
            values.addAll(s.key.equals(Speed.PARTICLE_DENSITY.key) ? set.descendingSet() : set);
        }
        CycleButton<Integer> b = CycleButton.<Integer>builder(v -> Component.literal(show(s, v)), s.value())
            .withValues(values)
            .withTooltip(v -> tip(s.key))
            .create(0, 0, 150, 20, Component.literal(caption(s.key)), (btn, v) -> choose(s.key, v));
        b.active = !locked;
        speedButtons.put(s.key, b);
        made.add(b);
        return b;
    }

    private CycleButton<String> moduleButton(ModuleSwitch m, boolean locked) {
        String key = TEXT.containsKey(m.key()) ? m.key() : null;
        String cap = key != null ? caption(key) : prettyOptimisation(m);
        String text = (key != null ? TEXT.get(key)[1] : optimisationTip(m)) + offBy(m);
        Tooltip t = Tooltip.create(Component.literal(text));
        CycleButton<String> b = CycleButton.<String>builder(v -> Component.literal(v.substring(0, 1).toUpperCase() + v.substring(1)), Settings.moduleValue(m))
            .withValues(m.choices())
            .withTooltip(v -> t)
            .create(0, 0, 150, 20, Component.literal(cap), (btn, v) -> {
                boolean before = Settings.restartNeeded();
                Settings.setModule(m, v);
                // the section's header says when a restart is needed
                if (before != Settings.restartNeeded()) this.rebuildWidgets();
            });
        b.active = !locked;
        moduleButtons.put(m.key(), b);
        made.add(b);
        return b;
    }

    /** A note when another mod keeps the module off whatever this switch says (the modules' own rule). */
    static String offBy(ModuleSwitch m) {
        String other = switch (m.module()) {
            case "memory" -> "ferritecore";
            case "logic" -> "lithium";
            case "chunks" -> "c2me";
            default -> null;
        };
        if (other != null && net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded(other)) return " Off while " + other + " is installed (it does the same).";
        if (m.key().equals("occlusion") && System.getProperty("quicksilver.occlusion") != null) return " Set by -Dquicksilver.occlusion for this launch.";
        return "";
    }

    /** An optimisation's caption: its name only (the tooltip names its module), so it fits a half-width button. */
    static String prettyOptimisation(ModuleSwitch m) {
        String id = m.key().substring(m.key().indexOf('.') + 1).replace('-', ' ');
        return Character.toUpperCase(id.charAt(0)) + id.substring(1);
    }

    /** One line: the start of the module's own description of the optimisation, then the look and the restart. */
    static String optimisationTip(ModuleSwitch m) {
        String what = m.what();
        int cut = what.length();
        for (String stop : new String[] {";", " (", ": "}) {
            int i = what.indexOf(stop);
            if (i > 20 && i < cut) cut = i;
        }
        what = what.substring(0, cut).trim();
        if (!what.isEmpty()) what = Character.toUpperCase(what.charAt(0)) + what.substring(1);
        String module = m.module().substring(0, 1).toUpperCase() + m.module().substring(1);
        return module + " module: " + what + ". Doesn't change the look. Needs a restart.";
    }

    // ---- what the buttons do (the CI test calls these as the buttons would)

    /** A speed switch's button was set: applies the value (re-meshing if needed), saves, and shows the preset now. */
    void choose(String key, int value) {
        Speed.Setting s = Speed.all().get(key);
        if (s == null) return;
        if (Speed.set(s, value) == null) Settings.save();
        refresh();
    }

    /** The preset button was set: every speed switch to the preset's values, saved; every button shows its new value. */
    void choosePreset(Preset p) {
        Settings.apply(p);
        refresh();
    }

    /** Every button shows the switches' values now (after a preset, or a change elsewhere: the command, the file). */
    void refresh() {
        if (presetButton != null) presetButton.setValue(Settings.current());
        for (Map.Entry<String, CycleButton<Integer>> e : speedButtons.entrySet()) {
            Speed.Setting s = Speed.all().get(e.getKey());
            if (s != null && e.getValue().getValue() != s.value()) e.getValue().setValue(s.value());
        }
    }

    Preset shownPreset() {
        return presetButton == null ? null : presetButton.getValue();
    }

    Integer shown(String key) {
        CycleButton<Integer> b = speedButtons.get(key);
        return b == null ? null : b.getValue();
    }

    CycleButton<String> moduleButton(String key) {
        return moduleButtons.get(key);
    }

    int listRowWidth() {
        return this.list.getRowWidth();
    }

    Screen lastScreen() {
        return this.lastScreen;
    }

    @Override
    public void tick() {
        super.tick();
        // a change made elsewhere while the screen is open (the command can't be typed then, but a mod or the test can)
        refresh();
    }
}
