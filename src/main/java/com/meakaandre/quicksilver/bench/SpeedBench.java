package com.meakaandre.quicksilver.bench;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.speed.Speed;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;

/**
 * Package A: the speed bench, run before a scene's main measuring window in CI's speed runs
 * ({@code -Dquicksilver.ci.speed=true}) for scenes with a {@code speedAb} list. With the frame limit and vsync off it
 * measures:
 * <ol>
 * <li>a <b>profile</b> window: where the frame's time goes by stage ({@link StageProfile}), every switch at its
 * default;</li>
 * <li>for each listed switch, <b>A/B windows</b>: rounds of the switch off and on, in the order off-on, on-off,
 * off-on, ... (so a slow drift in the runner's speed cancels out), each window after the camera's path restarts and (for a
 * switch that changes meshes) after the world has meshed again. Three rounds for an option, five for an approximation
 * or a CI switch (the ones CI gates). Frame times, draws, upload bytes, terrain triangles and what the switch itself left
 * out are recorded per window; the summary gives each side's median over the rounds and, as on/off, from the rounds'
 * own ratios: with five or more rounds their geometric mean with the highest and lowest left out (one noisy round on a
 * shared runner moved the median of three past its gate: spawn's fog-sections frame time 1.009 in run 45511522980,
 * 0.92-0.94 in every other run), with fewer their median.</li>
 * </ol>
 * Everything runs in the same session on the same machine, so on and off are compared like for like. The results go to
 * {@code quicksilver/bench/speed/<time>-<scene>.json}; {@code ci/speed-compare.py} reads and gates them. Afterwards every
 * switch, the frame limit and vsync are put back and the main window measures as in every other run.
 */
final class SpeedBench {
    static final boolean ENABLED = Boolean.getBoolean("quicksilver.ci.speed");
    static final double PROFILE_SECONDS = 8, AB_SECONDS = 5, WARM_SECONDS = 2;
    static final int ROUNDS = 3, GATED_ROUNDS = 5;

    /** Rounds for a switch: five for the ones CI gates (approximations, CI switches, dynamic lights' cost), three for other options. */
    static int rounds(Speed.Setting s) {
        return s.approximation || s.key.startsWith("ci.") || s == Speed.DYNAMIC_LIGHTS ? GATED_ROUNDS : ROUNDS;
    }

    private static final class Window {
        final String label;
        final Speed.Setting setting;
        final int value;
        final boolean profile;
        JsonObject result;
        /** Package B: which list entry this window measures (a switch may be listed twice, with two values). */
        int entry = -1;

        Window of(int entry) {
            this.entry = entry;
            return this;
        }

        Window(String label, Speed.Setting setting, int value, boolean profile) {
            this.label = label;
            this.setting = setting;
            this.value = value;
            this.profile = profile;
        }
    }

    private enum Phase { SETTLE, APPLY, WAIT_MESH, WARM, RECORD, DONE }

    private final BenchRun run;
    private final String sceneId;
    private final List<String> emit;
    private int ticks;
    private final Deque<Window> queue = new ArrayDeque<>();
    private final List<Window> done = new ArrayList<>();
    private final List<Object[]> tested = new ArrayList<>(); // {setting, onValue, original}
    private final List<String> problems = new ArrayList<>();
    private Window current;
    private Phase phase = Phase.SETTLE;
    private Object previousInactivity;
    private boolean settleStarted;
    private long until, meshStableSince, meshWaitEnd, lastMeshed;
    private int previousLimit = -1;
    private Boolean previousVsync;

    static boolean wanted(Scenes.Scene scene) {
        return ENABLED && scene != null && scene.speedAb != null && !scene.speedAb.isEmpty() && BenchModules.jar.equals("quicksilver");
    }

    SpeedBench(BenchRun run, Scenes.Scene scene) {
        this.run = run;
        this.sceneId = scene.id;
        this.emit = scene.speedEmit == null ? List.of() : scene.speedEmit;
        queue.add(new Window("profile", null, 0, true));
        for (String entry : scene.speedAb) {
            // package B: "profile" alone in the list asks for the stage profile only (no switch measured)
            if (entry.equals("profile")) continue;
            String key = entry, val = null;
            int eq = entry.indexOf('=');
            if (eq > 0) {
                key = entry.substring(0, eq);
                val = entry.substring(eq + 1);
            }
            Speed.Setting s = Speed.byKey(key);
            if (s == null) {
                problems.add("unknown switch " + key);
                continue;
            }
            int on;
            try {
                on = val == null ? 1 : Integer.parseInt(val.trim());
            } catch (NumberFormatException ex) {
                problems.add("bad value in " + entry);
                continue;
            }
            int off = s.key.equals(Speed.PARTICLE_DENSITY.key) ? 100 : 0;
            tested.add(new Object[] {s, on, s.value(), tested.size()});
            for (int r = 0, n = rounds(s); r < n; r++) {
                boolean onFirst = r % 2 == 1;
                queue.add(new Window(onFirst ? "on" : "off", s, onFirst ? on : off, false).of(tested.size() - 1));
                queue.add(new Window(onFirst ? "off" : "on", s, onFirst ? off : on, false).of(tested.size() - 1));
            }
            // back to its configured value before the next switch, so each switch is measured against the defaults
            queue.add(new Window("reset", s, s.value(), false));
        }
        Minecraft mc = Minecraft.getInstance();
        previousLimit = mc.options.framerateLimit().get();
        previousVsync = mc.options.enableVsync().get();
        mc.options.framerateLimit().set(260); // the game's "unlimited"
        mc.options.enableVsync().set(false);
        previousInactivity = BenchRun.setInactivityLimit("MINIMIZED");
        QuicksilverClient.LOG.info("QUICKSILVER SPEED START scene={} windows={} (frame limit and vsync off until it ends)", sceneId, queue.size());
    }

    /** One client tick; true when every window is done (the switches, frame limit and vsync are back). */
    boolean step(long now) {
        // while waiting for meshing, the camera stays at the scene's starting pose (a moving scene would fly off)
        if (phase == Phase.SETTLE || phase == Phase.APPLY || phase == Phase.WAIT_MESH) run.restartPath(now);
        if ((phase == Phase.WARM || phase == Phase.RECORD) && !emit.isEmpty() && ticks++ % 10 == 0) {
            var player = Minecraft.getInstance().player;
            if (player != null) for (String c : emit) player.connection.sendCommand(c);
        }
        switch (phase) {
            case SETTLE -> {
                // the world finishes meshing before anything is measured (a scene's settle time may not be enough)
                if (!settleStarted) {
                    settleStarted = true;
                    lastMeshed = com.meakaandre.quicksilver.mesher.MesherStats.meshedCount();
                    meshStableSince = now;
                    until = now + 5_000_000_000L;
                    meshWaitEnd = now + 90_000_000_000L;
                }
                boolean settled = now >= until && quiet(now);
                if (settled || now >= meshWaitEnd) {
                    if (!settled) problems.add("meshing still busy 90 s after the scene settled");
                    phase = Phase.APPLY;
                }
            }
            case APPLY -> {
                current = queue.poll();
                if (current == null) {
                    finish();
                    phase = Phase.DONE;
                    return true;
                }
                boolean remesh = false;
                if (current.setting != null && current.setting.value() != current.value) {
                    String why = Speed.set(current.setting, current.value);
                    if (why != null) problems.add(current.setting.key + ": " + why);
                    remesh = current.setting.remesh;
                }
                if (remesh) {
                    lastMeshed = com.meakaandre.quicksilver.mesher.MesherStats.meshedCount();
                    meshStableSince = now;
                    until = now + 3_000_000_000L;
                    meshWaitEnd = now + 90_000_000_000L;
                    phase = Phase.WAIT_MESH;
                } else {
                    startWarm(now);
                }
            }
            case WAIT_MESH -> {
                boolean settled = now >= until && quiet(now);
                if (settled || now >= meshWaitEnd) {
                    if (!settled) problems.add(current.label + " " + current.setting.key + ": meshing still busy after 90 s");
                    startWarm(now);
                }
            }
            case WARM -> {
                if (now < until) return false;
                Speed.SECTIONS_IN_FOG.reset();
                Speed.SECTIONS_SEEN.reset();
                Speed.CUTOUT_SKIPPED.reset();
                Speed.ENTITIES_HIDDEN.reset();
                Speed.BLOCK_ENTITIES_HIDDEN.reset();
                Speed.PARTICLES_DROPPED.reset();
                Speed.TERRAIN_TRIANGLES.reset();
                com.meakaandre.quicksilver.occlusion.OcclusionStats.speedReset();
                Speed.counting = true;
                if (current.profile) {
                    var caps = QuicksilverClient.capabilities();
                    StageProfile.start(caps != null && caps.isOpenGl());
                } else {
                    SpeedWindow.start();
                }
                until = now + (long) ((current.profile ? PROFILE_SECONDS : AB_SECONDS) * 1e9);
                phase = Phase.RECORD;
            }
            case RECORD -> {
                if (now < until) return false;
                Speed.counting = false;
                if (current.profile) {
                    StageProfile.stop();
                    current.result = StageProfile.json();
                } else {
                    SpeedWindow.stop();
                    current.result = windowJson(now);
                }
                done.add(current);
                phase = Phase.APPLY;
            }
            case DONE -> {
                return true;
            }
        }
        return false;
    }

    /**
     * Meshing has settled: at most {@link #QUIET_SECTIONS} sections meshed in the last two seconds, and no mesh waiting
     * for upload. The world keeps
     * re-meshing a trickle of sections (random ticks: grass, leaves, water), so "none at all" may never come.
     */
    private boolean quiet(long now) {
        long m = com.meakaandre.quicksilver.mesher.MesherStats.meshedCount();
        if (now - meshStableSince >= 2_000_000_000L) {
            boolean q = m - lastMeshed <= QUIET_SECTIONS && com.meakaandre.quicksilver.terrain.UploadBudget.lastWaiting == 0;
            lastMeshed = m;
            meshStableSince = now;
            return q;
        }
        return false;
    }

    static final int QUIET_SECTIONS = 4;

    private void startWarm(long now) {
        if (current != null && current.label.equals("reset")) {
            phase = Phase.APPLY; // nothing measured: the switch is back at its configured value
            return;
        }
        run.restartPath(now);
        until = now + (long) (WARM_SECONDS * 1e9);
        phase = Phase.WARM;
    }

    private JsonObject windowJson(long now) {
        long[] f = SpeedWindow.FRAMES.toLongArray();
        int n = f.length;
        JsonObject o = new JsonObject();
        o.addProperty("frames", n);
        double sum = 0;
        for (long v : f) sum += v;
        double avgMs = n == 0 ? 0 : sum / n / 1e6;
        long[] sorted = f.clone();
        Arrays.sort(sorted);
        int worst = Math.max(1, n / 100);
        double worstSum = 0;
        for (int i = n - worst; i < n; i++) if (i >= 0) worstSum += sorted[i];
        o.addProperty("frameMsAvg", r2(avgMs));
        o.addProperty("frameMsP50", n == 0 ? 0 : r2(sorted[n / 2] / 1e6));
        o.addProperty("fps", avgMs == 0 ? 0 : r2(1000 / avgMs));
        o.addProperty("low1pctFps", worstSum == 0 ? 0 : r2(1e9 * worst / worstSum));
        double fr = Math.max(1, n);
        o.addProperty("drawCallsPerFrame", r2(SpeedWindow.draws / fr));
        o.addProperty("uploadBytesPerFrame", Math.round(SpeedWindow.bytes / fr));
        o.addProperty("terrainTrianglesPerFrame", Math.round(Speed.TERRAIN_TRIANGLES.sum() / fr));
        o.addProperty("sectionsSeenPerFrame", r2(Speed.SECTIONS_SEEN.sum() / fr));
        o.addProperty("sectionsInFogPerFrame", r2(Speed.SECTIONS_IN_FOG.sum() / fr));
        o.addProperty("cutoutLayersSkippedPerFrame", r2(Speed.CUTOUT_SKIPPED.sum() / fr));
        o.addProperty("entitiesHiddenPerFrame", r2(Speed.ENTITIES_HIDDEN.sum() / fr));
        o.addProperty("blockEntitiesHiddenPerFrame", r2(Speed.BLOCK_ENTITIES_HIDDEN.sum() / fr));
        o.addProperty("particlesDropped", Speed.PARTICLES_DROPPED.sum());
        // package B: occlusion culling in the window
        long[] oc = com.meakaandre.quicksilver.occlusion.OcclusionStats.speedCounts();
        double of = Math.max(1, oc[0]);
        o.addProperty("occlusionDrawnPerFrame", r2(oc[1] / of));
        o.addProperty("occlusionCulledPerFrame", r2(oc[2] / of));
        o.addProperty("occlusionCulledPct", oc[1] + oc[2] == 0 ? 0 : r2(100.0 * oc[2] / (oc[1] + oc[2])));
        o.addProperty("stillFramesDrawnInFull", oc[3]);
        o.addProperty("fogSections", com.meakaandre.quicksilver.speed.SpeedTerrain.fogState());
        return o;
    }

    /** Puts every tested switch, the frame limit and vsync back (also when the bench is aborted). */
    void restore() {
        Speed.counting = false;
        StageProfile.stop();
        SpeedWindow.stop();
        for (Object[] t : tested) {
            Speed.Setting s = (Speed.Setting) t[0];
            if (s.value() != (int) t[2]) Speed.set(s, (int) t[2]);
        }
        Minecraft mc = Minecraft.getInstance();
        if (previousLimit > 0) mc.options.framerateLimit().set(previousLimit);
        if (previousVsync != null) mc.options.enableVsync().set(previousVsync);
        previousLimit = -1;
        previousVsync = null;
        if (previousInactivity != null) BenchRun.setInactivityLimit(previousInactivity);
        previousInactivity = null;
    }

    private void finish() {
        restore();
        Minecraft mc = Minecraft.getInstance();
        JsonObject out = new JsonObject();
        out.addProperty("scene", sceneId);
        out.addProperty("time", LocalDateTime.now().toString());
        out.addProperty("rounds", ROUNDS);
        out.addProperty("gatedRounds", GATED_ROUNDS);
        out.addProperty("abSeconds", AB_SECONDS);
        var caps = QuicksilverClient.capabilities();
        out.addProperty("capabilities", caps == null ? "not probed" : caps.describe());
        out.add("settings", Speed.json());
        JsonObject hooks = new JsonObject();
        com.meakaandre.quicksilver.mixin.speed.SpeedMixins.RESULT.forEach(hooks::addProperty);
        out.add("hooks", hooks);
        for (Window w : done) if (w.profile) out.add("profile", w.result);
        JsonArray ab = new JsonArray();
        for (Object[] t : tested) {
            Speed.Setting s = (Speed.Setting) t[0];
            JsonObject e = new JsonObject();
            e.addProperty("setting", s.key);
            e.addProperty("approximation", s.approximation);
            e.addProperty("onValue", (int) t[1]);
            e.addProperty("rounds", rounds(s));
            JsonArray windows = new JsonArray();
            List<JsonObject> on = new ArrayList<>(), off = new ArrayList<>();
            for (Window w : done) {
                if (w.setting != s || w.entry != (int) t[3]) continue;
                JsonObject wj = w.result.deepCopy();
                wj.addProperty("state", w.label);
                windows.add(wj);
                (w.label.equals("on") ? on : off).add(w.result);
            }
            // round r's two windows are on.get(r) and off.get(r) (each round holds one of each)
            e.add("windows", windows);
            JsonObject sum = new JsonObject();
            for (String k : List.of("frameMsAvg", "frameMsP50", "fps", "low1pctFps", "drawCallsPerFrame", "uploadBytesPerFrame",
                "terrainTrianglesPerFrame", "sectionsInFogPerFrame", "cutoutLayersSkippedPerFrame", "entitiesHiddenPerFrame",
                "blockEntitiesHiddenPerFrame", "particlesDropped", "occlusionDrawnPerFrame", "occlusionCulledPerFrame", "occlusionCulledPct",
                "stillFramesDrawnInFull")) {
                double a = median(off, k), b = median(on, k);
                JsonObject m = new JsonObject();
                m.addProperty("off", r2(a));
                m.addProperty("on", r2(b));
                // on/off: the median of each round's own ratio (the two windows of a round are next to each other, so a
                // slow drift in the runner's speed cancels within the round)
                double[] ratios = new double[Math.min(on.size(), off.size())];
                for (int r = 0; r < ratios.length; r++) {
                    double x = off.get(r).get(k).getAsDouble(), y = on.get(r).get(k).getAsDouble();
                    ratios[r] = x == 0 ? (y == 0 ? 1.0 : 0.0) : y / x;
                }
                Arrays.sort(ratios);
                double ratio = onOverOff(ratios);
                m.addProperty("onOverOff", Math.round(ratio * 10000) / 10000.0);
                JsonArray per = new JsonArray();
                for (double v : ratios) per.add(Math.round(v * 10000) / 10000.0);
                m.add("roundRatios", per);
                sum.add(k, m);
            }
            e.add("medians", sum);
            ab.add(e);
        }
        out.add("ab", ab);
        JsonArray pr = new JsonArray();
        for (String p : problems) pr.add(p);
        out.add("problems", pr);
        try {
            Path dir = FabricLoader.getInstance().getGameDir().resolve("quicksilver").resolve("bench").resolve("speed");
            Files.createDirectories(dir);
            String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            Path file = dir.resolve(stamp + "-" + sceneId + ".json");
            Files.writeString(file, new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(out), StandardCharsets.UTF_8);
            QuicksilverClient.LOG.info("QUICKSILVER SPEED END scene={} json={} problems={}", sceneId, file, problems);
        } catch (Exception ex) {
            QuicksilverClient.LOG.error("Quicksilver speed bench could not write its report", ex);
        }
    }

    /**
     * on/off from the rounds' own ratios (sorted): from five rounds on, the geometric mean without the highest and the
     * lowest (the chunk gates' rule, package 9); with fewer, the median. A zero ratio (the switch removed all of it)
     * makes that mean zero, as it should.
     */
    static double onOverOff(double[] ratios) {
        int n = ratios.length;
        if (n == 0) return 1.0;
        if (n >= 5) {
            double logSum = 0;
            for (int i = 1; i < n - 1; i++) {
                if (ratios[i] <= 0) return 0;
                logSum += Math.log(ratios[i]);
            }
            return Math.exp(logSum / (n - 2));
        }
        return n % 2 == 1 ? ratios[n / 2] : (ratios[n / 2 - 1] + ratios[n / 2]) / 2;
    }

    private static double median(List<JsonObject> l, String k) {
        if (l.isEmpty()) return 0;
        double[] v = new double[l.size()];
        for (int i = 0; i < v.length; i++) v[i] = l.get(i).get(k).getAsDouble();
        Arrays.sort(v);
        return v.length % 2 == 1 ? v[v.length / 2] : (v[v.length / 2 - 1] + v[v.length / 2]) / 2;
    }

    private static double r2(double v) {
        return Math.round(v * 100) / 100.0;
    }
}
