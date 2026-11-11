package com.meakaandre.quicksilver.chunks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Phase 2, P2-4: the Chunks module (chunk saving and loading). Each optimisation has its own switch in
 * {@code config/quicksilver.properties} ({@code chunks=on|off} for the whole module, {@code chunks.<name>=on|off} for one;
 * read once at start-up, before any mixin applies); a switched-off optimisation's mixins are not applied
 * ({@link ChunksMixins}). With C2ME installed the whole module stays off (it does the same jobs).
 *
 * <p>Every optimisation here saves exactly what vanilla saves, from the same tick, in the same order; none asks for an
 * identity hash, reflects, or starts a thread (P2-1's and P2-4's rules).
 *
 * <p>Crash safety (the phase 2 design's rule): an optimisation that can't be used (a hook that didn't apply, an exception
 * inside it, a difference its verify mode finds) turns itself off with one line starting {@value #FALLBACK}, and
 * vanilla's code runs from then on. CI fails on any such line.
 */
public final class Chunks {
    public static final Logger LOG = LoggerFactory.getLogger("quicksilver");
    public static final String FALLBACK = "Quicksilver chunks fallback:";
    /** CI's verify mode (full runs): each shortcut checked against vanilla's own result; a difference falls back. */
    public static final boolean VERIFY = Boolean.getBoolean("quicksilver.debug.verifyChunks");

    /** One optimisation: id, what it does, its mixins (simple names), and its hooks (target class, handler name). */
    record Opt(String id, String what, List<String> mixins, List<String[]> hooks) {
    }

    static final List<Opt> ALL = List.of(
        new Opt(CowSections.ID, "a chunk's sections are shared with its save snapshot instead of copied; a section is copied only if"
            + " it is written before the save is done (copy on write)",
            List.of("PalettedContainerCowMixin", "PalettedContainerInvoker", "SerializableChunkDataCowMixin"),
            List.<String[]>of(new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$share"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$cowGetAndSet"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$cowGetAndSetUnchecked"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$cowSet"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$cowRead"},
                new String[] {"net.minecraft.world.level.chunk.storage.SerializableChunkData", "call:quicksilver$copySection"},
                new String[] {"net.minecraft.world.level.chunk.storage.SerializableChunkData", "call:quicksilver$copied"},
                new String[] {"net.minecraft.world.level.chunk.storage.SerializableChunkData", "call:quicksilver$written"})));

    private enum State { ON, OFF, FALLBACK }

    private static final Map<String, String> OPTIMISATIONS = new LinkedHashMap<>();
    private static final Map<String, State> STATE = new LinkedHashMap<>();
    private static final Map<String, String> WHY = new LinkedHashMap<>();
    private static volatile boolean loaded = false;
    private static String moduleOff = null;

    private Chunks() {
    }

    /** Reads the switches (once; the mixin plugin calls this before any of the module's mixins apply). */
    static synchronized void load() {
        if (loaded) return;
        loaded = true;
        for (Opt o : ALL) OPTIMISATIONS.put(o.id(), o.what());
        Properties p = read();
        if (Boolean.getBoolean("quicksilver.ci.measureOnly")) {
            moduleOff = "quicksilver.ci.measureOnly is set";
        } else if (c2me()) {
            moduleOff = "C2ME is installed (it does the same; remove it whenever you like)";
        } else if (!"on".equalsIgnoreCase(p.getProperty("chunks", "on").trim())) {
            moduleOff = "chunks=off in config/quicksilver.properties";
        }
        for (String id : OPTIMISATIONS.keySet()) {
            boolean on = moduleOff == null && "on".equalsIgnoreCase(p.getProperty("chunks." + id, "on").trim());
            STATE.put(id, on ? State.ON : State.OFF);
            if (!on) WHY.put(id, moduleOff != null ? moduleOff : "chunks." + id + "=off");
        }
        if (moduleOff != null) LOG.info("Quicksilver chunks: off, {}", moduleOff);
        // cow-sections: off with a mod known to write sections' storage directly (before its mixins would apply)
        if (STATE.get(CowSections.ID) == State.ON) {
            String writer = knownWriter();
            if (writer != null) {
                STATE.put(CowSections.ID, State.OFF);
                WHY.put(CowSections.ID, writer + " is installed");
                LOG.info("Quicksilver {}: off for the session ({} is installed: it can write sections' storage directly); vanilla's code runs instead",
                    CowSections.ID, writer);
            }
        }
    }

    /**
     * Turns an optimisation off for the session because something it can't account for is installed (not a failure: one
     * info line; the status line says why too). Only at start-up, before any server thread.
     */
    static void off(Switch s, String reason) {
        synchronized (Chunks.class) {
            load();
            if (STATE.get(s.id) != State.ON) return;
            STATE.put(s.id, State.OFF);
            WHY.put(s.id, reason);
        }
        s.on = false;
        // (not "Quicksilver chunks:", which CI reads as the status line; that line says it too)
        LOG.info("Quicksilver {}: off for the session ({}); vanilla's code runs instead", s.id, reason);
    }

    // (here, not in CowSections: load() runs in the mixin plugin, before the game's classes may be touched)
    /** Mods known to write sections' storage directly (mod id, name): cow-sections is off with any of them. */
    static final String[][] WRITERS = {
        {"worldedit", "WorldEdit"},
        {"fastasyncworldedit", "FastAsyncWorldEdit"},
        {"fawe", "FastAsyncWorldEdit"},
        {"axiom", "Axiom"},
    };

    /** The first known writer installed ("Name (id)"), or null. */
    static String knownWriter() {
        for (String[] w : WRITERS) {
            if (FabricLoader.getInstance().isModLoaded(w[0])) return w[1] + " (" + w[0] + ")";
        }
        return null;
    }

    private static boolean c2me() {
        for (var m : FabricLoader.getInstance().getAllMods()) {
            String id = m.getMetadata().getId();
            if (id.equals("c2me") || id.startsWith("c2me-")) return true;
        }
        return false;
    }

    /** Whether an optimisation is switched on and hasn't fallen back. */
    public static synchronized boolean on(String id) {
        load();
        return STATE.getOrDefault(id, State.OFF) == State.ON;
    }

    /** Turns an optimisation off for the rest of the session: one log line (CI fails on it), vanilla's code from now on. */
    public static void fallback(Switch s, String reason, Throwable t) {
        synchronized (Chunks.class) {
            load();
            if (STATE.get(s.id) != State.ON) return;
            STATE.put(s.id, State.FALLBACK);
            WHY.put(s.id, reason);
        }
        s.on = false;
        if (t != null) LOG.warn("{} {} off ({}); vanilla's code runs instead", FALLBACK, s.id, reason, t);
        else LOG.warn("{} {} off ({}); vanilla's code runs instead", FALLBACK, s.id, reason);
    }

    /** One optimisation's switch as a plain field, read on hot paths: on at start-up if the optimisation is, cleared for good by {@link #fallback}. */
    public static final class Switch {
        public final String id;
        public volatile boolean on;

        public Switch(String id) {
            this.id = id;
            this.on = Chunks.on(id);
        }

        public void fail(Throwable t) {
            fallback(this, "exception: " + t, t);
        }
    }

    /** Main entrypoint: the status line at start-up and once a server has started (CI reads it). */
    public static void init() {
        load();
        // cow-sections reads which mixins are applied to sections' containers here, on the main thread, before any server thread
        CowSections.init();
        LOG.info("Quicksilver chunks: {}", moduleOff != null ? "off, " + moduleOff : status());
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STARTED.register(server -> report());
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.END_SERVER_TICK.register(server -> {
            CowSections.end();  // a snapshot that threw before its end hook shares nothing past its tick
            if (!hooksDone && server.getTickCount() % 100 == 0) {
                checkHooks();
                hooksDone = allChecked();
            }
        });
    }

    private static volatile boolean hooksDone = false;

    public static void report() {
        checkHooks();
        LOG.info("Quicksilver chunks: {}", moduleOff != null ? "off, " + moduleOff : status());
    }

    public static synchronized String status() {
        load();
        StringJoiner j = new StringJoiner(", ");
        for (var e : STATE.entrySet()) {
            String s = e.getValue().name().toLowerCase(java.util.Locale.ROOT);
            j.add(e.getKey() + "=" + s + (e.getValue() == State.ON ? "" : " (" + WHY.get(e.getKey()) + ")"));
        }
        if (VERIFY) j.add("verify=on");
        return j.toString();
    }

    private static final java.util.Set<String> CHECKED = java.util.concurrent.ConcurrentHashMap.newKeySet();

    /** An optimisation that is on but whose hooks didn't land falls back. Only classes already loaded are checked (no lookups). */
    static void checkHooks() {
        for (Opt o : ALL) {
            Switch s = switchOf(o.id());
            if (s == null || !s.on) continue;
            for (String[] h : o.hooks()) {
                String key = o.id() + "#" + h[0] + "#" + h[1];
                if (CHECKED.contains(key) || !ChunksMixins.transformed(h[0])) continue;
                boolean ok = h[1].startsWith("call:") ? ChunksMixins.called(h[0], h[1].substring(5)) : ChunksMixins.member(h[0], h[1]);
                CHECKED.add(key);
                if (!ok) fallback(s, "hook " + h[1] + " did not land in " + h[0], null);
            }
        }
    }

    /** Whether every hook of one optimisation has been checked (and it is still on: a failed check falls it back). */
    static boolean allChecked(String id) {
        for (Opt o : ALL) {
            if (!o.id().equals(id)) continue;
            for (String[] h : o.hooks()) if (!CHECKED.contains(o.id() + "#" + h[0] + "#" + h[1])) return false;
        }
        return true;
    }

    static boolean allChecked() {
        for (Opt o : ALL) {
            Switch s = switchOf(o.id());
            if (s == null || !s.on) continue;
            for (String[] h : o.hooks()) if (!CHECKED.contains(o.id() + "#" + h[0] + "#" + h[1])) return false;
        }
        return true;
    }

    private static Switch switchOf(String id) {
        if (id.equals(CowSections.ID)) return CowSections.SWITCH;
        return null;
    }

    static List<String> owners(String mixinSimpleName) {
        List<String> ids = new java.util.ArrayList<>();
        for (Opt o : ALL) if (o.mixins().contains(mixinSimpleName)) ids.add(o.id());
        return ids;
    }

    private static Properties read() {
        Path file = FabricLoader.getInstance().getConfigDir().resolve("quicksilver.properties");
        Properties p = new Properties();
        try {
            if (Files.exists(file)) {
                try (InputStream in = Files.newInputStream(file)) {
                    p.load(in);
                }
            }
            boolean changed = false;
            if (!p.containsKey("chunks")) {
                p.setProperty("chunks", "on");
                changed = true;
            }
            for (String id : OPTIMISATIONS.keySet()) {
                if (!p.containsKey("chunks." + id)) {
                    p.setProperty("chunks." + id, "on");
                    changed = true;
                }
            }
            if (changed) {
                Files.createDirectories(file.getParent());
                try (OutputStream out = Files.newOutputStream(file)) {
                    p.store(out, COMMENT);
                }
            }
        } catch (IOException e) {
            LOG.warn("Quicksilver chunks: could not read or write {}; every chunks optimisation stays on", file, e);
        }
        return p;
    }

    /** The config file's comment (the modules that write it share it). */
    public static final String COMMENT = "Quicksilver. block-renderer: on (Quicksilver's Fabric Renderer API renderer) or off (every block and item drawn"
        + " by vanilla's own code). memory: on or off (the Memory module); memory.<name>: on or off (one of its optimisations)."
        + " logic: on or off (the Logic module); logic.<name>: on or off (one of its optimisations)."
        + " chunks: on or off (the Chunks module); chunks.<name>: on or off (one of its optimisations). Each needs a restart.";
}
