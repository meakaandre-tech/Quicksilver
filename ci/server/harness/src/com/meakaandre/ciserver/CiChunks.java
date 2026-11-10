package com.meakaandre.ciserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;

/**
 * CI only (phase 2, P2-4): the chunk scenes' moving window, in every run alike (vanilla's and Quicksilver's).
 * Script lines (ci/server/chunks-*.txt):
 * <ul>
 * <li>{@code window DIM CX CZ R}: the chunks within R of (CX, CZ) kept loaded with one ticket at the centre, the
 * game's own player-loading ticket with that radius where the game has one (loaded, not ticking: a player's view
 * distance outside the simulation distance), otherwise force-loaded chunk by chunk (logged which). The run starts once
 * every chunk of the window is a full chunk.</li>
 * <li>{@code fly TICKS SEG...}: from tick 0, the centre moves one chunk every TICKS ticks along the segments (each
 * {@code +xN}, {@code -xN}, {@code +zN} or {@code -zN}), looping until the run ends: a player flying over saved terrain.
 * The new ticket is added before the old one is removed, as the game moves a player's.</li>
 * <li>{@code dirty-on-leave}: a chunk leaving the window is marked changed first, so it is saved when it unloads (as a
 * chunk a player has been near is: its inhabited time changes).</li>
 * <li>{@code dirty-at T}: every chunk of the window marked changed at the start of tick T (before that tick's
 * commands, so {@code at T save-all} saves all of them).</li>
 * <li>{@code churn N}: every tick from 1, N blocks of the window set (flag 2: no neighbour updates, no drops), at fixed
 * positions spread over the window's chunks and three sections of each (y 8, 24, 40: underground), alternating andesite
 * 18 opaque full blocks in turn (andesite, diorite, granite, ... and ten terracottas: more than a 16-entry palette holds,
 * so sections' palettes grow), and only where the block is stone, deepslate or one of those (opaque blocks that give no
 * light, replaced by opaque blocks that give none: no light changes at all, so the saved light doesn't follow the light engine's
 * timing; a cave's air, water or lava is left alone): sections written while their chunks' saves are being serialised (P2-4's copy-on-write
 * sections).</li>
 * <li>{@code save-every K}: {@code save-all} every K ticks from K, after that tick's churn.</li>
 * </ul>
 * Nothing here draws on any random; the only blocks it changes are churn's (fixed positions and states); the same calls in
 * the same order in every run.
 */
final class CiChunks {
    private CiChunks() {
    }

    private static ResourceKey<Level> dim;
    private static int cx, cz, radius = -1, ticksPerChunk = 0, step = 0;
    private static final List<int[]> segments = new ArrayList<>();  // {dx, dz, n}
    private static boolean dirtyOnLeave = false;
    private static int churn = 0, saveEvery = 0;
    private static long churned = 0, skipped = 0;
    private static final List<Integer> dirtyAt = new ArrayList<>();
    private static String ticketMode = "none";
    private static java.lang.reflect.Method addTicket, removeTicket;
    private static Object ticketType;
    private static long moves = 0, dirtied = 0, notLoadedOnLeave = 0;

    /** Every chunk tag serialised for saving during the run (ChunkWriteMixin): per chunk, its tags' hashes in order. */
    private static final java.util.Map<String, List<Integer>> writes = new java.util.concurrent.ConcurrentHashMap<>();
    private static volatile boolean recording = false;

    /** From the serialising thread: one chunk tag written for saving (recorded from the run's tick 0 to its end). */
    public static void written(ChunkPos pos, net.minecraft.nbt.CompoundTag tag) {
        if (!recording || tag == null) return;
        long l = pos.toLong();
        writes.computeIfAbsent((int) l + "," + (int) (l >>> 32), k -> java.util.Collections.synchronizedList(new ArrayList<>())).add(tag.hashCode());
    }

    private static List<net.minecraft.world.level.block.state.BlockState> churnStates;

    /** Churn's blocks: 18 opaque full blocks that give no light (more than a 16-entry palette holds, so sections' palettes grow). */
    private static List<net.minecraft.world.level.block.state.BlockState> churnBlocks() {
        if (churnStates == null) {
            List<net.minecraft.world.level.block.state.BlockState> l = new ArrayList<>();
            for (net.minecraft.world.level.block.Block b : new net.minecraft.world.level.block.Block[] {
                net.minecraft.world.level.block.Blocks.ANDESITE, net.minecraft.world.level.block.Blocks.DIORITE,
                net.minecraft.world.level.block.Blocks.GRANITE, net.minecraft.world.level.block.Blocks.COBBLESTONE,
                net.minecraft.world.level.block.Blocks.STONE_BRICKS, net.minecraft.world.level.block.Blocks.BRICKS,
                net.minecraft.world.level.block.Blocks.TUFF, net.minecraft.world.level.block.Blocks.CALCITE,
                net.minecraft.world.level.block.Blocks.WHITE_TERRACOTTA, net.minecraft.world.level.block.Blocks.ORANGE_TERRACOTTA,
                net.minecraft.world.level.block.Blocks.MAGENTA_TERRACOTTA, net.minecraft.world.level.block.Blocks.LIGHT_BLUE_TERRACOTTA,
                net.minecraft.world.level.block.Blocks.YELLOW_TERRACOTTA, net.minecraft.world.level.block.Blocks.LIME_TERRACOTTA,
                net.minecraft.world.level.block.Blocks.PINK_TERRACOTTA, net.minecraft.world.level.block.Blocks.GRAY_TERRACOTTA,
                net.minecraft.world.level.block.Blocks.LIGHT_GRAY_TERRACOTTA, net.minecraft.world.level.block.Blocks.CYAN_TERRACOTTA}) {
                l.add(b.defaultBlockState());
            }
            churnStates = l;
        }
        return churnStates;
    }

    static boolean active() {
        return radius >= 0;
    }

    /** One script line; false if it isn't one of this class's. */
    static boolean line(String line) {
        String[] a = line.split("\\s+");
        switch (a[0]) {
            case "window" -> {
                dim = ResourceKey.create(Registries.DIMENSION, Identifier.parse(a[1]));
                cx = Integer.parseInt(a[2]);
                cz = Integer.parseInt(a[3]);
                radius = Integer.parseInt(a[4]);
                return true;
            }
            case "fly" -> {
                ticksPerChunk = Integer.parseInt(a[1]);
                for (int i = 2; i < a.length; i++) {
                    String s = a[i];
                    int sign = s.charAt(0) == '-' ? -1 : 1;
                    int n = Integer.parseInt(s.substring(2));
                    segments.add(s.charAt(1) == 'x' ? new int[] {sign, 0, n} : new int[] {0, sign, n});
                }
                return true;
            }
            case "churn" -> {
                churn = Integer.parseInt(a[1]);
                return true;
            }
            case "save-every" -> {
                saveEvery = Integer.parseInt(a[1]);
                return true;
            }
            case "dirty-on-leave" -> {
                dirtyOnLeave = true;
                return true;
            }
            case "dirty-at" -> {
                dirtyAt.add(Integer.parseInt(a[1]));
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    /** Before the run: the window's ticket (frozen game; the harness waits for {@link #loaded}). */
    static void prepare(MinecraftServer server) {
        if (!active()) return;
        ServerLevel level = server.getLevel(dim);
        if (level == null) throw new IllegalArgumentException("no dimension " + dim);
        findTicket(level);
        add(level, cx, cz);
        Harness.LOG.info("CI CHUNKS window {} {} {} radius {} ({})", dim.identifier(), cx, cz, radius, ticketMode);
    }

    /**
     * The game's player-loading ticket and its add/remove-with-radius methods, by reflection (the harness is compiled
     * without knowing which this game has; CI only, the same lookups in every run). Falls back to forced chunks.
     */
    private static void findTicket(ServerLevel level) {
        try {
            Class<?> tt = Class.forName("net.minecraft.server.level.TicketType");
            java.lang.reflect.Field f = null;
            for (String name : new String[] {"PLAYER_LOADING", "PLAYER"}) {
                try {
                    f = tt.getField(name);
                    break;
                } catch (NoSuchFieldException ignored) {
                    // next
                }
            }
            if (f == null) throw new NoSuchFieldException("TicketType.PLAYER_LOADING");
            ticketType = f.get(null);
            for (java.lang.reflect.Method m : level.getChunkSource().getClass().getMethods()) {
                Class<?>[] p = m.getParameterTypes();
                if (p.length == 3 && p[0] == tt && p[1] == ChunkPos.class && p[2] == int.class) {
                    if (m.getName().equals("addTicketWithRadius")) addTicket = m;
                    if (m.getName().equals("removeTicketWithRadius")) removeTicket = m;
                }
            }
            if (addTicket == null || removeTicket == null) throw new NoSuchMethodException("ServerChunkCache.add/removeTicketWithRadius");
            ticketMode = "ticket " + f.getName();
        } catch (ReflectiveOperationException e) {
            ticketMode = "forced (" + e + ")";
            addTicket = removeTicket = null;
        }
    }

    private static void add(ServerLevel level, int x, int z) {
        if (addTicket != null) {
            try {
                addTicket.invoke(level.getChunkSource(), ticketType, new ChunkPos(x, z), radius);
                return;
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException("adding the window's ticket", e);
            }
        }
        for (int z2 = z - radius; z2 <= z + radius; z2++) {
            for (int x2 = x - radius; x2 <= x + radius; x2++) level.setChunkForced(x2, z2, true);
        }
    }

    private static void remove(ServerLevel level, int x, int z, int nx, int nz) {
        if (removeTicket != null) {
            try {
                removeTicket.invoke(level.getChunkSource(), ticketType, new ChunkPos(x, z), radius);
                return;
            } catch (ReflectiveOperationException e) {
                throw new IllegalStateException("removing the window's ticket", e);
            }
        }
        for (int z2 = z - radius; z2 <= z + radius; z2++) {
            for (int x2 = x - radius; x2 <= x + radius; x2++) {
                if (Math.abs(x2 - nx) > radius || Math.abs(z2 - nz) > radius) level.setChunkForced(x2, z2, false);
            }
        }
    }

    /** Every chunk of the window loaded as a full chunk. */
    static boolean loaded(MinecraftServer server) {
        if (!active()) return true;
        ServerLevel level = server.getLevel(dim);
        for (int z = cz - radius; z <= cz + radius; z++) {
            for (int x = cx - radius; x <= cx + radius; x++) if (level.getChunkSource().getChunkNow(x, z) == null) return false;
        }
        return true;
    }

    /** At the start of run tick {@code tick}, before its commands. */
    static void startTick(MinecraftServer server, int tick) {
        if (!active()) return;
        if (tick == 0) recording = true;
        ServerLevel level = server.getLevel(dim);
        if (dirtyAt.contains(tick)) {
            int n = 0;
            for (int z = cz - radius; z <= cz + radius; z++) {
                for (int x = cx - radius; x <= cx + radius; x++) {
                    LevelChunk c = level.getChunkSource().getChunkNow(x, z);
                    if (c != null) {
                        c.markUnsaved();
                        n++;
                    }
                }
            }
            dirtied += n;
            Harness.LOG.info("CI CHUNKS t={} {} chunks marked changed", tick, n);
        }
        if (churn > 0 && tick > 0) {
            int side = 2 * radius + 1;
            for (int i = 0; i < churn; i++) {
                int k = (i * 7 + tick) % (side * side);
                int x = (cx - radius + k % side) * 16 + (i * 3) % 16;
                int z = (cz - radius + k / side) * 16 + (i * 5) % 16;
                int y = 8 + (i % 3) * 16;
                net.minecraft.core.BlockPos pos = new net.minecraft.core.BlockPos(x, y, z);
                net.minecraft.world.level.block.state.BlockState now = level.getBlockState(pos);
                if (!(now.is(net.minecraft.world.level.block.Blocks.STONE) || now.is(net.minecraft.world.level.block.Blocks.DEEPSLATE)
                    || churnBlocks().contains(now))) {
                    skipped++;
                    continue;
                }
                level.setBlock(pos, churnBlocks().get((tick + i) % churnBlocks().size()), 2);
                churned++;
            }
        }
        if (saveEvery > 0 && tick > 0 && tick % saveEvery == 0) Harness.command(server, "save-all");
        if (ticksPerChunk <= 0 || segments.isEmpty() || tick == 0 || tick % ticksPerChunk != 0) return;
        int[] seg = segment(step++);
        int nx = cx + seg[0], nz = cz + seg[1];
        add(level, nx, nz);
        if (dirtyOnLeave) {
            for (int z = cz - radius; z <= cz + radius; z++) {
                for (int x = cx - radius; x <= cx + radius; x++) {
                    if (Math.abs(x - nx) <= radius && Math.abs(z - nz) <= radius) continue;
                    LevelChunk c = level.getChunkSource().getChunkNow(x, z);
                    if (c == null) {
                        notLoadedOnLeave++;
                        continue;
                    }
                    c.markUnsaved();
                    dirtied++;
                }
            }
        }
        remove(level, cx, cz, nx, nz);
        cx = nx;
        cz = nz;
        moves++;
    }

    /** The direction of move number {@code i} along the looping path. */
    private static int[] segment(int i) {
        int total = 0;
        for (int[] s : segments) total += s[2];
        int k = i % total;
        for (int[] s : segments) {
            if (k < s[2]) return s;
            k -= s[2];
        }
        throw new IllegalStateException();
    }

    /** After the run's last tick: how many window chunks are not loaded as full chunks (logged, for the record). */
    static void result(MinecraftServer server, JsonObject result) {
        if (!active()) return;
        int missing = 0;
        ServerLevel level = server.getLevel(dim);
        for (int z = cz - radius; z <= cz + radius; z++) {
            for (int x = cx - radius; x <= cx + radius; x++) if (level.getChunkSource().getChunkNow(x, z) == null) missing++;
        }
        JsonObject o = new JsonObject();
        o.addProperty("ticket", ticketMode);
        o.addProperty("radius", radius);
        o.addProperty("moves", moves);
        o.addProperty("dirtied", dirtied);
        o.addProperty("churned", churned);
        o.addProperty("churnSkipped", skipped);
        o.addProperty("notLoadedOnLeave", notLoadedOnLeave);
        o.addProperty("windowNotFullAtEnd", missing);
        o.addProperty("endCentre", cx + "," + cz);
        recording = false;
        JsonObject w = new JsonObject();
        int n = 0;
        for (var e : new java.util.TreeMap<>(writes).entrySet()) {
            JsonArray a = new JsonArray();
            synchronized (e.getValue()) {
                for (int h : e.getValue()) a.add(h);
            }
            n += a.size();
            w.add(e.getKey(), a);
        }
        o.addProperty("writesRecorded", n);
        result.add("chunkWrites", w);
        result.add("chunks", o);
        Harness.LOG.info("CI CHUNKS result={}", o);
    }
}
