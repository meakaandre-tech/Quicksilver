package com.meakaandre.quicksilver.settings;

import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.settings.Settings.ModuleSwitch;
import com.meakaandre.quicksilver.settings.Settings.Preset;
import com.meakaandre.quicksilver.speed.Speed;
import com.mojang.brigadier.CommandDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;

/**
 * Package 9, CI only ({@code -Dquicksilver.ci.screenTest=true}; {@code /qs screentest}, typed by ci/client-run.sh in the
 * preset-balanced run after its scenes): the options screen's checks, one log line each
 * ({@code QUICKSILVER SCREEN TEST <name>: PASS|FAIL|SKIP <detail>}), then the screen at GUI scale 2 for the run's
 * screenshot ({@code ... SHOT}) and {@code QUICKSILVER SCREEN TEST END passed=N failed=M} (ci/preset-compare.py).
 *
 * <p>Before it, the run types {@code /qs speed far-detail 6}: the first check is that the command saved the file and the
 * screen shows Custom. Then: the Video Settings button opens the screen; Mod Menu's factory does (if Mod Menu is
 * loaded); each preset sets every switch to its values, the buttons and the file show them and the file reads back to the
 * same values; a change shows Custom and opaque leaves and simple water re-mesh at once; a module switch is saved and the
 * screen says a restart is needed; every row has a tooltip that says whether it changes the look; at GUI scales 1 to 4 every widget is inside
 * the window side to side and no two of a row overlap. Ends on Balanced at GUI scale 2, as the run started.
 */
public final class ScreenTest {
    private ScreenTest() {
    }

    private static final String P = "QUICKSILVER SCREEN TEST ";
    private static int step = -1, wait = 0, passed = 0, failed = 0, scale = 0;
    private static int startScale = 2;
    private static SettingsScreen screen;
    private static long remeshes;

    public static void register(CommandDispatcher<FabricClientCommandSource> d) {
        for (String name : new String[] {"quicksilver", "qs"}) {
            d.register(ClientCommands.literal(name).then(ClientCommands.literal("screentest").executes(c -> {
                if (step < 0) {
                    step = 0;
                    wait = 20;
                    QuicksilverClient.LOG.info(P + "START");
                }
                return 1;
            })));
        }
    }

    private static void check(String name, boolean ok, String detail) {
        if (ok) passed++;
        else failed++;
        QuicksilverClient.LOG.info(P + "{}: {} {}", name, ok ? "PASS" : "FAIL", detail);
    }

    private static void skip(String name, String why) {
        QuicksilverClient.LOG.info(P + "{}: SKIP {}", name, why);
    }

    public static void tick(Minecraft mc) {
        if (step < 0) return;
        if (wait > 0) {
            wait--;
            return;
        }
        try {
            run(mc);
        } catch (Throwable t) {
            check("step-" + step, false, "threw " + t);
            QuicksilverClient.LOG.error(P + "error", t);
            finish(mc);
        }
    }

    private static void run(Minecraft mc) throws Exception {
        switch (step) {
            case 0 -> {
                // the command typed before the test: saved, and Custom shown
                Properties p = Settings.read();
                check("command-sync", Speed.FAR_CUTOUT.value() == 6 && "6".equals(p.getProperty(Speed.FAR_CUTOUT.key))
                    && Settings.current() == Preset.CUSTOM && "custom".equals(p.getProperty("preset")),
                    "far-detail=" + Speed.FAR_CUTOUT.value() + " file=" + p.getProperty(Speed.FAR_CUTOUT.key) + " preset=" + Settings.current().id
                        + " file preset=" + p.getProperty("preset"));
                startScale = mc.options.guiScale().get();
                mc.gui.setScreen(new VideoSettingsScreen(null, mc, mc.options));
                next(5);
            }
            case 1 -> {
                Screen video = mc.gui.screen();
                boolean found = VideoSettingsButton.last != null && VideoSettingsButton.lastScreen == video && video instanceof VideoSettingsScreen;
                if (found) VideoSettingsButton.open(video);
                Screen now = mc.gui.screen();
                check("opens-from-video-settings", found && now instanceof SettingsScreen s && s.lastScreen() == video,
                    "button " + (found ? "found" : "missing") + ", screen now " + (now == null ? "none" : now.getClass().getSimpleName()));
                next(3);
            }
            case 2 -> {
                if (!FabricLoader.getInstance().isModLoaded("modmenu")) {
                    skip("opens-from-mod-menu", "Mod Menu not loaded");
                } else {
                    Screen made = null;
                    String why = "no modmenu entrypoint of quicksilver";
                    for (EntrypointContainer<Object> c : FabricLoader.getInstance().getEntrypointContainers("modmenu", Object.class)) {
                        if (!c.getProvider().getMetadata().getId().equals("quicksilver")) continue;
                        Object api = c.getEntrypoint();
                        Object factory = api.getClass().getMethod("getModConfigScreenFactory").invoke(api);
                        java.lang.reflect.Method create = null;
                        for (java.lang.reflect.Method m : factory.getClass().getMethods()) {
                            if (m.getName().equals("create") && m.getParameterCount() == 1) create = m;
                        }
                        create.setAccessible(true);
                        made = (Screen) create.invoke(factory, mc.gui.screen());
                        why = made == null ? "the factory made nothing" : made.getClass().getSimpleName();
                    }
                    check("opens-from-mod-menu", made instanceof SettingsScreen, why);
                    if (made != null) mc.gui.setScreen(made);
                }
                if (!(mc.gui.screen() instanceof SettingsScreen)) mc.gui.setScreen(new SettingsScreen(null));
                next(3);
            }
            case 3 -> {
                screen = (SettingsScreen) mc.gui.screen();
                check("custom-after-command", screen.shownPreset() == Preset.CUSTOM && screen.shown(Speed.FAR_CUTOUT.key) == 6,
                    "shown " + screen.shownPreset() + ", far detail button " + screen.shown(Speed.FAR_CUTOUT.key));
                for (Preset p : new Preset[] {Preset.LOW_END, Preset.QUALITY, Preset.BALANCED}) presetCheck(p);
                next(3);
            }
            case 4 -> {
                // a change shows Custom, re-meshes at once where it changes meshes, and is saved
                for (Speed.Setting s : new Speed.Setting[] {Speed.OPAQUE_LEAVES, Speed.SIMPLE_WATER}) {
                    long before = Speed.REMESHES.sum();
                    screen.choose(s.key, 1);
                    Properties p = Settings.read();
                    check("custom-after-change " + s.key, s.value() == 1 && Settings.current() == Preset.CUSTOM && screen.shownPreset() == Preset.CUSTOM
                        && "on".equals(p.getProperty(s.key)) && "custom".equals(p.getProperty("preset")),
                        s.key + "=" + Speed.show(s) + " shown " + screen.shownPreset() + " file " + p.getProperty(s.key) + "/" + p.getProperty("preset"));
                    check("remesh-without-restart " + s.key, Speed.REMESHES.sum() == before + 1, "re-meshes " + before + " -> " + Speed.REMESHES.sum());
                    screen.choose(s.key, 0);
                }
                check("back-to-balanced", Settings.current() == Preset.BALANCED && screen.shownPreset() == Preset.BALANCED, "shown " + screen.shownPreset());
                // a module switch: saved at once, used after a restart
                ModuleSwitch m = null;
                for (ModuleSwitch x : Settings.moduleSwitches()) if (x.key().equals("chunks.cow-sections")) m = x;
                if (m == null) m = Settings.moduleSwitches().get(Settings.moduleSwitches().size() - 1);
                String was = Settings.moduleValue(m);
                String other = m.choices().get(m.choices().indexOf(was) == 0 ? 1 : 0);
                Settings.setModule(m, other);
                boolean saved = other.equals(Settings.read().getProperty(m.key())) && Settings.restartNeeded();
                Settings.setModule(m, was);
                boolean back = was.equals(Settings.read().getProperty(m.key())) && !Settings.restartNeeded();
                check("module-switch-saved", saved && back, m.key() + " " + was + " -> " + other + " (saved, restart asked: " + saved + ") -> " + was + " (" + back + ")");
                // tooltips: every row has one, and it says whether it changes the look
                List<String> bad = new ArrayList<>();
                for (Map.Entry<String, String[]> e : SettingsScreen.TEXT.entrySet()) if (!e.getKey().equals("preset") && !e.getValue()[1].contains("the look")) bad.add(e.getKey());
                for (Speed.Setting s : Speed.all().values()) if (!SettingsScreen.TEXT.containsKey(s.key)) bad.add(s.key);
                for (ModuleSwitch x : Settings.moduleSwitches()) {
                    String t = SettingsScreen.TEXT.containsKey(x.key()) ? SettingsScreen.TEXT.get(x.key())[1] : SettingsScreen.optimisationTip(x);
                    if (!t.contains("the look") || !t.contains("restart")) bad.add(x.key());
                }
                check("tooltips", bad.isEmpty(), bad.isEmpty() ? (SettingsScreen.TEXT.size() + " rows and " + Settings.moduleSwitches().size() + " module switches") : "missing or unclear: " + bad);
                scale = 1;
                setScale(mc, scale);
                next(5);
            }
            case 5 -> {
                layoutCheck(mc, scale);
                if (scale < 4) {
                    setScale(mc, ++scale);
                    wait = 5;
                    return;
                }
                setScale(mc, startScale);
                next(5);
            }
            case 6 -> {
                screen = mc.gui.screen() instanceof SettingsScreen s ? s : screen;
                QuicksilverClient.LOG.info(P + "SHOT gui scale {} window {}x{} screen {}x{}", mc.options.guiScale().get(),
                    screen.width * Math.max(1, mc.options.guiScale().get()), screen.height * Math.max(1, mc.options.guiScale().get()), screen.width, screen.height);
                next(200);
            }
            default -> finish(mc);
        }
    }

    private static void presetCheck(Preset p) {
        screen.choosePreset(p);
        List<String> wrong = new ArrayList<>();
        for (Map.Entry<String, Integer> e : p.switches().entrySet()) {
            Speed.Setting s = Speed.all().get(e.getKey());
            if (s.value() != e.getValue()) wrong.add(s.key + "=" + s.value() + " not " + e.getValue());
            Integer shown = screen.shown(s.key);
            if (shown == null || shown != s.value()) wrong.add(s.key + " button shows " + shown);
        }
        check("preset " + p.id, wrong.isEmpty() && Settings.current() == p && screen.shownPreset() == p,
            wrong.isEmpty() ? "current " + Settings.current().id + ", shown " + screen.shownPreset() : String.join("; ", wrong));
        // saved, and the file reads back to the same values (as at start-up)
        Properties f = Settings.read();
        List<String> diff = new ArrayList<>();
        for (Speed.Setting s : Speed.all().values()) {
            String v = f.getProperty(s.key);
            Integer back = v == null ? null : Speed.parseValue(s, v.trim());
            if (back == null || back != s.value()) diff.add(s.key + "=" + v);
        }
        if (!p.id.equals(f.getProperty("preset"))) diff.add("preset=" + f.getProperty("preset"));
        check("save-load " + p.id, diff.isEmpty(), diff.isEmpty() ? Speed.all().size() + " switches and the preset read back" : String.join(", ", diff));
    }

    private static void setScale(Minecraft mc, int s) {
        mc.options.guiScale().set(s);
        mc.resizeGui();
        // the list places only the rows it draws: every button back to 0, 0, so a row not drawn at this scale can't keep
        // its place from the last one (the check below skips buttons still at 0, 0)
        if (mc.gui.screen() instanceof SettingsScreen ss) for (AbstractWidget w : ss.made) {
            w.setX(0);
            w.setY(0);
        }
    }

    /**
     * Every widget inside the window from side to side, none of the screen's own buttons overlapping in a row, every
     * button's label inside its button. A scale the window doesn't offer (vanilla caps the GUI scale so the screen is at
     * least 320 by 240 GUI pixels: at 1280x720, scale 3) is checked by size: the list's row and the title must fit the
     * width that scale would give (1280 / 4 = 320).
     */
    private static void layoutCheck(Minecraft mc, int s) {
        Screen sc = mc.gui.screen();
        if (!(sc instanceof SettingsScreen ss)) {
            check("gui-scale-" + s, false, "the screen closed");
            return;
        }
        List<String> bad = new ArrayList<>();
        for (AbstractWidget w : ss.made) {
            int label = sc.getFont().width(w.getMessage());
            if (label > w.getWidth() - 8) bad.add("label '" + w.getMessage().getString() + "' " + label + " px in a " + w.getWidth() + " px button");
        }
        int got = mc.options.guiScale().get();
        if (got != s) {
            int width = 1280 / s;
            int row = ss.listRowWidth();
            if (row + 10 > width) bad.add("the list's rows (" + row + " px) don't fit " + width + " px");
            if (sc.getFont().width(sc.getTitle()) > width) bad.add("title wider than " + width + " px");
            check("gui-scale-" + s, bad.isEmpty(), "the window offers scale " + got + " at most; checked by size: " + width + " px wide, rows " + row + " px"
                + (bad.isEmpty() ? "" : ": " + String.join("; ", bad.subList(0, Math.min(6, bad.size())))));
            return;
        }
        for (AbstractWidget w : Screens.getWidgets(sc)) {
            if (w.getX() < 0 || w.getRight() > sc.width) bad.add(w.getClass().getSimpleName() + " x " + w.getX() + "-" + w.getRight());
        }
        // only the rows drawn this frame have their places (the list lays out the rows it shows; the others stay at 0, 0)
        List<AbstractWidget> placed = new ArrayList<>();
        for (AbstractWidget w : ss.made) if (w.getX() != 0 || w.getY() != 0) placed.add(w);
        if (placed.size() < 3) bad.add("only " + placed.size() + " buttons shown");
        for (AbstractWidget w : placed) {
            if (w.getX() < 0 || w.getRight() > sc.width) bad.add("'" + w.getMessage().getString() + "' x " + w.getX() + "-" + w.getRight());
            for (AbstractWidget o : placed) {
                if (o != w && o.getY() == w.getY() && o.getX() < w.getRight() && w.getX() < o.getRight()) bad.add("'" + w.getMessage().getString() + "' overlaps '" + o.getMessage().getString() + "'");
            }
        }
        if (sc.getFont().width(sc.getTitle()) > sc.width) bad.add("title wider than the screen");
        check("gui-scale-" + s, bad.isEmpty(), "screen " + sc.width + "x" + sc.height + (bad.isEmpty() ? ", " + placed.size() + " buttons shown, all inside" : ": " + String.join("; ", bad.subList(0, Math.min(6, bad.size())))));
    }

    private static void next(int ticks) {
        step++;
        wait = ticks;
    }

    private static void finish(Minecraft mc) {
        Settings.apply(Preset.BALANCED);
        mc.gui.setScreen(null);
        QuicksilverClient.LOG.info(P + "END passed={} failed={}", passed, failed);
        step = -1;
    }
}
