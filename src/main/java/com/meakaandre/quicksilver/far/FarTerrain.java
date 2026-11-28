package com.meakaandre.quicksilver.far;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.speed.Speed;
import com.meakaandre.quicksilver.terrain.FarLayer;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientChunkEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.levelgen.Heightmap;

/**
 * Package 12: far terrain (design doc, "Far terrain (like Ecstatic)"; Ecstatic's idea of sampling the world's noise
 * instead of generating chunks, none of its code). With {@code option.far-terrain} at 32, 64, 96 or 128 chunks, the land
 * from the render distance out to that distance is worked out on one background thread ({@link FarTiles}) from the
 * dimension's own generator ({@link FarSource}: its noise router, biome source and material rules; single player: the
 * world's seed; a server: only if it runs Quicksilver and answers the handshake, {@link FarNet}; never a guessed seed)
 * and from the real chunks the client has had (which replace the samples), and drawn in Quicksilver's terrain arenas
 * after the solid layer ({@link FarLayer}). The render-distance fog's end moves out to the far distance while it draws.
 * A dimension without a noise-based generator gets far terrain from real chunks only, and so does every dimension of a
 * Quicksilver server that doesn't share its seed (the default; one line in the chat). On a server that doesn't answer,
 * far terrain stays off with one line in the chat.
 *
 * <p>Off (the default): no thread, no event does any work, the fog is vanilla's, nothing is drawn or held.
 */
public final class FarTerrain {
    private FarTerrain() {
    }

    private static FarWorld world;
    /** The connection the world belongs to: a new one starts over. */
    private static Object worldFor;
    private static boolean asked, noted;
    private static String unavailable;
    private static volatile FarTiles session;
    private static String sessionNote;
    private static double camX, camY, camZ;
    private static boolean drawing;
    private static float fogEnd;
    private static long cpuAtStart = -1, wallAtStart;
    /** Sessions are numbered; the far layer takes tiles of the current one only. */
    private static int nextId = 1;
    /** Quicksilver's terrain stopped drawing while far terrain was on: its tiles went, and are made again when it draws. */
    private static boolean terrainWasOff;

    public static void init() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, mc) -> joined(handler));
        ClientPlayConnectionEvents.DISCONNECT.register((handler, mc) -> left());
        ClientChunkEvents.CHUNK_LOAD.register(FarTerrain::realChunk);
        ClientChunkEvents.CHUNK_UNLOAD.register(FarTerrain::realChunk);
        ClientTickEvents.END_CLIENT_TICK.register(mc -> tick());
        try {
            ClientPlayNetworking.registerGlobalReceiver(FarNet.WorldData.TYPE, (payload, context) -> received(payload));
        } catch (Throwable t) {
            QuicksilverClient.LOG.warn("Quicksilver far terrain: its handshake receiver could not be registered (servers stay off)", t);
        }
    }

    /**
     * CI's preset runs (their shots are compared with vanilla's): the Quality preset's far terrain is set (96) but not
     * drawn there; far terrain has its own shots ({@code ciFarSteps}).
     */
    private static final boolean CI_OFF = Boolean.getBoolean("quicksilver.ci.farTerrainOff");

    private static boolean on() {
        return Speed.FAR_TERRAIN.value() > 0 && !CI_OFF;
    }

    private static void joined(Object handler) {
        stopSession();
        world = null;
        worldFor = handler;
        asked = false;
        noted = false;
        unavailable = null;
    }

    private static void left() {
        stopSession();
        world = null;
        worldFor = null;
        asked = false;
        unavailable = null;
    }

    private static void received(FarNet.WorldData payload) {
        Object forWhom = worldFor;
        if (payload.data().length == 0) {
            // package 12b: a server that doesn't share its seed (the default): far terrain from real chunks only, never a guessed seed
            if (worldFor != forWhom || world != null) return;
            world = FarWorld.realOnly(payload.note());
            QuicksilverClient.LOG.info("Quicksilver far terrain: the server didn't share its world generator ({}); real chunks only", payload.note());
            note("far terrain shows only land you have seen here: " + payload.note());
            return;
        }
        byte[] data = payload.data();
        net.minecraft.util.Util.backgroundExecutor().execute(() -> {
            try {
                long t0 = System.nanoTime();
                FarWorld w = FarWorld.decode(data);
                Minecraft.getInstance().execute(() -> {
                    if (worldFor != forWhom) return;
                    world = w;
                    QuicksilverClient.LOG.info("Quicksilver far terrain: the server's handshake read in {} ms: {}", (System.nanoTime() - t0) / 1_000_000, w.describe());
                });
            } catch (Throwable t) {
                QuicksilverClient.LOG.warn("Quicksilver far terrain: the server's world generator could not be read; far terrain stays off here", t);
                Minecraft.getInstance().execute(() -> {
                    unavailable = "the server's world generator could not be read (" + t + ")";
                    note("far terrain is off: the server's world generator could not be read");
                });
            }
        });
    }

    private static void note(String text) {
        Minecraft mc = Minecraft.getInstance();
        if (noted || mc.gui == null || mc.player == null) return;
        noted = true;
        mc.gui.hud.getChat().addClientSystemMessage(Component.literal("[Quicksilver] " + text));
    }

    private static long waitUntil = -1, waitStarted;

    /** {@code /quicksilver far wait}: logs "settled" once every wanted tile is made and copied in (at most 240 s). */
    public static void waitSettled() {
        waitStarted = System.nanoTime();
        waitUntil = waitStarted + 240_000_000_000L;
    }

    private static void checkWait() {
        if (waitUntil < 0) return;
        long now = System.nanoTime();
        FarTiles s = session;
        boolean done = settled() && FarLayer.pending() == 0 && (s == null || s.realIn.isEmpty());
        if (done || now > waitUntil) {
            QuicksilverClient.LOG.info("Quicksilver far terrain: {} after {} ms ({})", done ? "settled" : "not settled", (now - waitStarted) / 1_000_000, status());
            waitUntil = -1;
        }
    }

    /** Client thread, every tick: the session follows the setting, the connection and the dimension. */
    private static void tick() {
        checkWait();
        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;
        if (level == null || Speed.locked()) {
            if (session != null) stopSession();
            return;
        }
        if (!on()) {
            // switched off: nothing drawn or held on the GPU; the samples stay, so switching it on again is quick
            FarTiles s = session;
            if (s != null && !s.paused) {
                s.paused = true;
                FarLayer.removeAll(s.id);
                drawing = false;
                QuicksilverClient.LOG.info("Quicksilver far terrain: off (paused in {})", s.dimension.identifier());
            }
            return;
        }
        FarTiles paused = session;
        if (paused != null && paused.paused) {
            paused.paused = false;
            paused.remeshAll();
            QuicksilverClient.LOG.info("Quicksilver far terrain: on again in {}, {} chunks", paused.dimension.identifier(), Speed.FAR_TERRAIN.value());
        }
        if (world == null) {
            var server = mc.getSingleplayerServer();
            if (server != null && mc.isLocalServer()) {
                world = FarWorld.of(server);
                QuicksilverClient.LOG.info("Quicksilver far terrain: single player, {}", world.describe());
            } else if (!asked && unavailable == null) {
                asked = true;
                if (ClientPlayNetworking.canSend(FarNet.Hello.TYPE)) {
                    ClientPlayNetworking.send(new FarNet.Hello(FarNet.VERSION));
                    QuicksilverClient.LOG.info("Quicksilver far terrain: asked the server for its world generator");
                } else {
                    unavailable = "the server doesn't run Quicksilver";
                    QuicksilverClient.LOG.info("Quicksilver far terrain: off on this server (it doesn't run Quicksilver, so it can't share its world seed)");
                    note("far terrain is off on this server (it needs Quicksilver on the server too)");
                }
            }
            if (world == null) return;
        }
        ResourceKey<Level> dim = level.dimension();
        FarTiles s = session;
        if (s != null && (s.dimension != dim || s.anchorTooFar(camX, camZ))) {
            stopSession();
            s = null;
        }
        // the terrain store dropped everything (F3+A, a render distance change): the tiles are made again from their samples
        if (s != null && FarLayer.takeLost()) s.remeshAll();
        if (s == null) {
            FarSource source = world.source(dim);
            boolean known = world.knows(dim);
            // anchored at the player (the camera of the last frame may still be the previous dimension's)
            if (mc.player != null) {
                camX = mc.player.getX();
                camZ = mc.player.getZ();
            }
            int id = nextId++;
            FarLayer.removeAll(id);
            s = new FarTiles(dim, source, level.getMinY(), camX, camZ, id);
            sessionNote = source != null ? "the dimension's own generator" : !world.shares() ? world.describe()
                : known ? "real chunks only (the generator isn't noise-based)" : "real chunks only (the dimension's generator isn't known here)";
            session = s;
            s.radius = Speed.FAR_TERRAIN.value() * 16;
            s.start();
            ThreadMXBean mx = ManagementFactory.getThreadMXBean();
            cpuAtStart = mx.isThreadCpuTimeSupported() ? 0 : -1;
            wallAtStart = System.nanoTime();
            QuicksilverClient.LOG.info("Quicksilver far terrain: on in {}, {} chunks, from {}", dim.identifier(), Speed.FAR_TERRAIN.value(), sessionNote);
            // the chunks the client already has count as real at once
            for (LevelChunk c : loadedChunks(level)) realChunk(level, c);
            rereadList = null;
        }
        rereadChunks(level);
    }

    private static java.util.List<LevelChunk> rereadList;
    private static int rereadAt, rereadAge;

    /**
     * The client's loaded chunks are read again in turn, a few each tick (all of them in about two seconds at render
     * distance 8), so blocks changed since a chunk arrived (built, mined) reach far terrain without waiting for the chunk
     * to go; the sampler re-makes a tile only when a chunk's columns changed.
     */
    private static void rereadChunks(ClientLevel level) {
        if (rereadList == null || rereadAt >= rereadList.size() || ++rereadAge > 200) {
            rereadList = loadedChunks(level);
            rereadAt = 0;
            rereadAge = 0;
        }
        for (int i = 0; i < 8 && rereadAt < rereadList.size(); i++) realChunk(level, rereadList.get(rereadAt++));
    }

    private static java.util.List<LevelChunk> loadedChunks(ClientLevel level) {
        java.util.List<LevelChunk> out = new java.util.ArrayList<>();
        Minecraft mc = Minecraft.getInstance();
        int rd = mc.options.getEffectiveRenderDistance() + 1;
        int cx = Mth.floor(camX) >> 4, cz = Mth.floor(camZ) >> 4;
        for (int dz = -rd; dz <= rd; dz++) {
            for (int dx = -rd; dx <= rd; dx++) {
                LevelChunk c = level.getChunkSource().getChunk(cx + dx, cz + dz, false);
                if (c != null) out.add(c);
            }
        }
        return out;
    }

    private static void stopSession() {
        FarTiles s = session;
        session = null;
        if (s != null) {
            s.stop();
            QuicksilverClient.LOG.info("Quicksilver far terrain: off in {} ({} tiles made, {} columns sampled, {} real chunks)", s.dimension.identifier(),
                s.tilesMade.get(), s.columnsSampled.get(), s.real.size());
        }
        FarLayer.removeAll(0);
        drawing = false;
    }

    /** Client thread: a chunk the client has (as it arrives, and again as it goes): its columns at 4-block steps. */
    private static void realChunk(ClientLevel level, LevelChunk chunk) {
        FarTiles s = session;
        if (s == null || s.paused || level.dimension() != s.dimension) return;
        try {
            int ox = chunk.getPos().getMinBlockX(), oz = chunk.getPos().getMinBlockZ();
            int[] solid = new int[16], fluid = new int[16], color = new int[16], fcolor = new int[16];
            BlockState[] block = new BlockState[16];
            boolean ceiling = level.dimensionType().hasCeiling();
            int minY = level.getMinY(), maxY = level.getMinY() + level.getHeight();
            int scanTop = Math.min(maxY, minY + level.dimensionType().logicalHeight()) - 1;
            BlockPos.MutableBlockPos p = new BlockPos.MutableBlockPos();
            boolean any = false;
            for (int k = 0; k < 16; k++) {
                int lx = (k & 3) * 4, lz = (k >> 2) * 4, x = ox + lx, z = oz + lz;
                int y;
                if (ceiling) {
                    // under a ceiling (the nether): the first floor below the roof, as the samples
                    y = scanTop;
                    while (y > minY && chunk.getBlockState(p.set(x, y, z)).isAir()) y--;
                    while (y > minY && !chunk.getBlockState(p.set(x, y, z)).isAir()) y--;
                    while (y > minY && chunk.getBlockState(p.set(x, y, z)).isAir()) y--;
                } else {
                    // the top block's y (ChunkAccess.getHeight is the heightmap's first free y less one)
                    y = chunk.getHeight(Heightmap.Types.WORLD_SURFACE, lx, lz);
                }
                if (y <= minY) {
                    solid[k] = FarSource.NONE;
                    fluid[k] = FarSource.NONE;
                    continue;
                }
                BlockState top = chunk.getBlockState(p.set(x, y, z));
                Holder<Biome> biome = level.getBiome(p);
                fluid[k] = FarSource.NONE;
                if (!top.getFluidState().isEmpty() && top.getFluidState().isSource() || top.getBlock() instanceof net.minecraft.world.level.block.LiquidBlock) {
                    fluid[k] = y + 1;
                    fcolor[k] = FarColors.color(top, biome, x, y, z);
                    int floor = y;
                    while (floor > minY && !chunk.getBlockState(p.set(x, floor, z)).getFluidState().isEmpty() && fluid[k] - floor < 128) floor--;
                    top = chunk.getBlockState(p.set(x, floor, z));
                    y = floor;
                }
                solid[k] = y + 1;
                color[k] = FarColors.color(top, biome, x, y, z);
                block[k] = top;
                any = true;
            }
            if (any) s.realIn.add(new FarTiles.RealChunk(chunk.getPos().x(), chunk.getPos().z(), solid, fluid, color, fcolor, block));
        } catch (Throwable t) {
            // a chunk that can't be read keeps its samples
        }
    }

    /** Render thread, the camera of the frame being prepared. */
    public static void camera(double x, double y, double z) {
        camX = x;
        camY = y;
        camZ = z;
    }

    /**
     * Render thread, as terrain preparation starts: this frame's parameters for the far layer. {@code terrainDrawing}:
     * whether Quicksilver's terrain draws this frame (far terrain draws only with it; while it doesn't, the tiles go and
     * the fog stays vanilla's).
     */
    public static void frame(boolean terrainDrawing) {
        FarTiles s = session;
        Minecraft mc = Minecraft.getInstance();
        if (s == null || s.paused || !FarLayer.usable() || !terrainDrawing) {
            drawing = false;
            FarLayer.frame(false, camX, camY, camZ, 0, 0, 0, 0, 0);
            if (s != null && !s.paused && !terrainDrawing && !terrainWasOff) {
                terrainWasOff = true;
                FarLayer.removeAll(s.id);
            }
            return;
        }
        if (terrainWasOff) {
            terrainWasOff = false;
            s.remeshAll();
        }
        // the band: from 32 blocks inside the render distance's edge to the edge, where real terrain ends
        int rd = mc.options.getEffectiveRenderDistance();
        float end = Math.max(32, rd * 16), start = Math.max(16, end - 32);
        // package 12b: under a ceiling whether or not there is a generator (a server that doesn't share its seed: real
        // chunks only, whose columns are also the first floor below the roof)
        boolean ceilingHere = (s.source != null && s.source.ceiling) || (mc.level != null && mc.level.dimensionType().hasCeiling());
        if (ceilingHere) {
            // under a ceiling (the nether) far terrain's surface, even from real chunks, is the first floor below the
            // roof, not the caverns: inside real terrain it would stand as walls in open space. No band there: far terrain
            // starts past every real section (vanilla draws up to about a chunk and a half past the render distance)
            end = rd * 16 + 32;
            start = end;
        }
        s.camX = camX;
        s.camZ = camZ;
        s.radius = Speed.FAR_TERRAIN.value() * 16;
        s.handEnd = (int) end;
        drawing = true;
        // the fog moves out as far as far terrain covers the land: from a generator, the far distance; from real chunks
        // only, the radius within which every chunk was seen (beyond the band's end; else vanilla's fog)
        fogEnd = s.source != null ? s.radius : (s.covered > end + 16 ? s.covered : 0);
        FarLayer.behindOnly(ceilingHere);
        // package 12b: holes inside the hand-over circle filled, but not under a ceiling (far terrain's surface there is
        // the first floor below the roof, not the caverns real terrain shows)
        // and not while the camera is below the ground at its own column (in a cave nearly every column has nothing drawn,
        // and far terrain there would only cost: the surface can't show except through openings real terrain draws)
        boolean belowGround = false;
        if (mc.level != null) {
            int top = mc.level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.WORLD_SURFACE, Mth.floor(camX), Mth.floor(camZ));
            belowGround = camY < top - 4;
        }
        FarLayer.fill(!ceilingHere && !belowGround, (Mth.floor(camY) >> 4) - rd);
        s.inside = !ceilingHere;
        FarLayer.frame(true, camX, camY, camZ, s.anchorX, s.anchorZ, s.floorY, start, end);
    }

    /** Render thread: the fog values vanilla is about to write; the render-distance fog ends at the far distance while far terrain draws. */
    public static void fog(FogData data) {
        if (!drawing || fogEnd <= 0) return;
        if (data.renderDistanceEnd >= fogEnd) return;
        data.renderDistanceEnd = fogEnd;
        data.renderDistanceStart = fogEnd - Mth.clamp(fogEnd / 10.0f, 4.0f, 64.0f);
        data.skyEnd = Math.max(data.skyEnd, fogEnd);
    }

    /** The fog end far terrain moves the render-distance fog to this frame (blocks), or 0 (fog-sections reads it). */
    public static float fogEndNow() {
        return drawing && fogEnd > 0 ? fogEnd : 0;
    }

    /**
     * The camera's far plane far terrain needs (blocks), or 0 while it doesn't draw: its far distance's corner, drawn
     * 1.5% further, with room for height.
     */
    public static float depthFarNeeded() {
        FarTiles s = session;
        if (!drawing || s == null) return 0;
        return (float) (s.radius * 1.42 * 1.015 + 512);
    }

    /** Package 12c: the heap far terrain's session holds (samples and real chunks, estimated), or 0. */
    public static long heapBytes() {
        FarTiles s = session;
        return s == null ? 0 : s.heapBytes();
    }

    /** Whether far terrain draws this frame (the fog hook and the bench). */
    public static boolean drawing() {
        return drawing;
    }

    // ---- bench, probe

    private static long cpuMs() {
        FarTiles s = session;
        if (s == null) return -1;
        try {
            ThreadMXBean mx = ManagementFactory.getThreadMXBean();
            long ns = mx.getThreadCpuTime(s.threadId());
            return ns < 0 ? -1 : ns / 1_000_000;
        } catch (Throwable t) {
            return -1;
        }
    }

    private static long windowCpu = -1, windowWall;

    /** The sampling thread's CPU since {@link #startWindow}, in ms per second of wall time (0 with far terrain off). */
    public static double windowCpuMsPerSecond() {
        long cpu = cpuMs();
        double wall = (System.nanoTime() - windowWall) / 1e9;
        if (cpu < 0 || windowCpu < 0 || wall <= 0) return 0;
        return (cpu - windowCpu) / wall;
    }

    public static void startWindow() {
        windowCpu = cpuMs();
        windowWall = System.nanoTime();
    }

    public static JsonObject json() {
        JsonObject o = new JsonObject();
        FarTiles s = session;
        if (s != null && s.paused) s = null;
        o.addProperty("state", s == null ? (on() ? "on, not drawing (" + (unavailable != null ? unavailable : world == null ? "no world generator yet" : "starting") + ")" : "off") : "on");
        o.addProperty("chunks", Speed.FAR_TERRAIN.value());
        if (s != null) {
            o.addProperty("dimension", s.dimension.identifier().toString());
            o.addProperty("source", sessionNote);
            o.addProperty("tilesWanted", s.tilesWanted);
            o.addProperty("tilesDone", s.tilesDone);
            o.addProperty("tilesMade", s.tilesMade.get());
            o.addProperty("tilesWithRealChunks", s.tilesFromReal.get());
            o.addProperty("columnsSampled", s.columnsSampled.get());
            o.addProperty("columnsFromRealChunks", s.columnsReal.get());
            o.addProperty("realChunks", s.real.size());
            o.addProperty("quadsMade", s.quadsMade.get());
            o.addProperty("sampleMs", s.sampleNanos.get() / 1_000_000);
            o.addProperty("meshMs", s.meshNanos.get() / 1_000_000);
            o.addProperty("firstPassMs", s.firstPassNanos < 0 ? -1 : s.firstPassNanos / 1_000_000);
            long cpu = cpuMs();
            o.addProperty("threadCpuMs", cpu);
            double wall = (System.nanoTime() - windowWall) / 1e9;
            // the sampling thread's CPU in the measured window, per second of it (1000: one core all the time)
            o.addProperty("threadCpuMsPerSecond", cpu < 0 || windowCpu < 0 || wall <= 0 ? -1 : Math.round((cpu - windowCpu) / wall * 10) / 10.0);
            if (s.problem != null) o.addProperty("problem", s.problem);
        }
        o.addProperty("tilesHeld", FarLayer.tilesHeld());
        o.addProperty("gpuKB", FarLayer.bytesHeld() / 1024);
        o.addProperty("heapKB", heapBytes() / 1024);
        o.addProperty("vramKB", com.meakaandre.quicksilver.terrain.TerrainStore.farArenaBytes() / 1024);
        o.addProperty("tilesDrawnLastFrame", FarLayer.lastTiles());
        o.addProperty("tilesOffScreenLastFrame", FarLayer.lastOffScreen());
        o.addProperty("tilesBeyondBandLastFrame", FarLayer.lastBeyond());
        o.addProperty("viewTested", FarLayer.viewTested());
        o.addProperty("quadsDrawnLastFrame", FarLayer.lastQuads());
        o.addProperty("drawsLastFrame", FarLayer.lastDraws());
        o.addProperty("fogEnd", drawing ? fogEnd : -1);
        // package 12b: holes inside the hand-over circle filled by far terrain
        o.addProperty("holeColumnsLastFrame", FarLayer.lastHoles());
        o.addProperty("partialColumnsLastFrame", FarLayer.lastPartial());
        o.addProperty("cutColumnsLastFrame", FarLayer.lastCut());
        o.addProperty("underCeiling", drawing && FarLayer.isBehindOnly());
        o.addProperty("tilesInsideForHolesLastFrame", FarLayer.lastInsideTiles());
        if (FarLayer.failure() != null) o.addProperty("failure", FarLayer.failure());
        return o;
    }

    public static String line(JsonObject o) {
        String st = o.get("state").getAsString();
        if (!st.equals("on")) return st;
        return "on, " + o.get("chunks") + " chunks, " + o.get("source").getAsString() + "; tiles " + o.get("tilesDone") + " of " + o.get("tilesWanted")
            + ", columns sampled " + o.get("columnsSampled") + ", from real chunks " + o.get("columnsFromRealChunks") + "; drawn last frame "
            + o.get("tilesDrawnLastFrame") + " tiles, " + o.get("quadsDrawnLastFrame") + " quads in " + o.get("drawsLastFrame") + " draws; sampling thread "
            + o.get("threadCpuMsPerSecond") + " ms CPU a second";
    }

    /** {@code /quicksilver far probe x z}: what far terrain holds at a column (CI's real-chunk check reads the line). */
    public static String probe(int x, int z) {
        FarTiles s = session;
        if (s == null) return "far terrain is off";
        String real = s.describeAt(x, z);
        if (real != null) return "real chunk data: " + real;
        if (s.source == null) return "nothing (no real chunk there, and no generator)";
        // the column's heights (one column of the generator's noise; heights() keeps no shared state)
        FarSource.Heights h = s.source.heights(x, z);
        return "sampled from the generator, top " + (h == null ? "none" : String.valueOf(h.solidTop() - 1));
    }

    /** {@code /quicksilver far status}: one line. */
    public static String status() {
        return line(json()) + "; " + com.meakaandre.quicksilver.terrain.TerrainRenderer.sectionCounts() + ", fog end "
            + fogEndNow() + "; " + holes();
    }

    /**
     * Package 12b, the cost of the two ways to close the holes (CI's report): the hole columns far terrain fills, the
     * tiles it draws inside the circle for them, and how many sections with blocks the client holds in those columns
     * (what drawing vanilla's dropped sections instead would mesh and draw: the other way, not built).
     */
    private static String holes() {
        int sections = 0;
        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;
        if (level != null) {
            int rd = mc.options.getEffectiveRenderDistance() + 1;
            int ccx = Mth.floor(camX) >> 4, ccz = Mth.floor(camZ) >> 4;
            for (int dz = -rd; dz <= rd; dz++) {
                for (int dx = -rd; dx <= rd; dx++) {
                    int low = FarLayer.lowestDrawn(ccx + dx, ccz + dz);
                    if (low == Integer.MIN_VALUE) continue;
                    LevelChunk c = level.getChunkSource().getChunk(ccx + dx, ccz + dz, false);
                    if (c == null) continue;
                    var secs = c.getSections();
                    for (int i = 0; i < secs.length; i++) {
                        int sy = level.getSectionYFromSectionIndex(i);
                        if (sy < low && secs[i] != null && !secs[i].hasOnlyAir()) sections++;
                    }
                }
            }
        }
        // sections: the client's sections with blocks below the lowest drawn section of each column inside the circle,
        // what drawing vanilla's dropped sections instead (the other way, not built) would have to mesh and draw
        return "holes: " + FarLayer.lastHoles() + " columns with nothing drawn, " + FarLayer.lastPartial() + " with real sections drawn (filled below them), "
            + FarLayer.lastCut() + " of them cut by vanilla's vertical reach, " + FarLayer.lastInsideTiles()
            + " tiles drawn wholly inside the circle for them; sections with blocks under them " + sections
            + (drawing && FarLayer.isBehindOnly() ? "; under a ceiling: behind real terrain, no band, no holes filled" : "");
    }

    /** Whether every wanted tile is made (CI waits for it before a far shot). */
    public static boolean settled() {
        FarTiles s = session;
        return s != null && !s.paused && s.tilesWanted > 0 && s.tilesDone >= s.tilesWanted && !s.remeshPending();
    }

    /** A resource reload: colours from the new textures, every tile made again. */
    public static void resourcesReloaded() {
        FarColors.clear();
        FarTiles s = session;
        if (s != null) s.restageAll();
    }
}
