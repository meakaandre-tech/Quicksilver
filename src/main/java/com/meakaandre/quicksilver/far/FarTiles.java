package com.meakaandre.quicksilver.far;

import com.meakaandre.quicksilver.terrain.FarLayer;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import org.lwjgl.system.MemoryUtil;

/**
 * Package 12: one dimension's far terrain, worked out on one background thread ("Quicksilver far terrain", the
 * lowest priority): tiles of 128 x 128 blocks around the camera out to the far distance, each sampled on a grid whose
 * spacing grows with distance (4 blocks within 16 chunks, 8 to 32, 16 to 64, 32 to 128, 64 beyond: design doc and package 12c), from real chunk data
 * where the client has had the chunk ("real chunks win") and from the dimension's own generator elsewhere ({@link
 * FarSource}); with no generator (superflat, void, custom) from real chunks only, at a capped rate, and nothing where
 * none was seen. Each tile becomes one mesh of 8-byte vertices ({@link FarLayer}): the ground as a height field, water
 * flat at its level, skirts at the tile's edges (no cracks between tiles of different spacing) and, near enough, simple
 * tree shapes from the biomes' placed features.
 */
final class FarTiles implements Runnable {
    static final int TILE = 128;
    /** Real-only tiles (no generator) and tiles re-made because a real chunk arrived: at most this many a second. */
    static final int CAPPED_PER_SECOND = 4;
    /** Real chunks kept per dimension (about 300 bytes each). */
    static final int REAL_MAX = 200_000;

    /** A real chunk's columns at 4-block steps (16 of them, x and z at 0, 4, 8, 12), as the client had it. */
    record RealChunk(int cx, int cz, int[] solidTop, int[] fluidTop, int[] color, int[] fluidColor, BlockState[] block, BlockState[] fluidBlock,
                     Holder<Biome>[] biome) {
    }

    private static final class Tile {
        final int tx, tz;
        int spacing, n;
        int[] solidTop, fluidTop, color, fluidColor;
        byte[] flags;  // 1: data, 2: real
        @SuppressWarnings("unchecked")
        Holder<Biome>[] biome;
        boolean dirty, staged;
        int realChunks;
        /** Package 12c: the edges staged with a skirt (bit e: edge e of {@link #stage}), and the generator's heights (reused at another spacing). */
        int skirtMask;
        FarSource.Heights[] hs;
        /** Package 12c: per column, bit 1 a snowy top, bit 2 a biome with trees, bit 4 water (CI's find). */
        byte[] kind;
        /** Package 12c: the big structures starting in this tile (from the seed), drawn as silhouettes. */
        java.util.List<FarStructures.Site> sites = java.util.List.of();
        boolean sitesKnown;

        Tile(int tx, int tz) {
            this.tx = tx;
            this.tz = tz;
        }
    }

    final ResourceKey<Level> dimension;
    final FarSource source;
    final FarTrees trees;
    final int floorY;
    final int anchorX, anchorZ;
    private final Thread thread;
    private volatile boolean stop;

    // set every frame by the render thread
    volatile double camX, camZ;
    volatile int radius, handEnd;
    /** Package 12b: tiles wholly inside the hand-over circle are made too (far terrain fills holes there), not under a ceiling. */
    volatile boolean inside;

    final ConcurrentLinkedQueue<RealChunk> realIn = new ConcurrentLinkedQueue<>();
    /** Real chunks by chunk key (the sampling thread writes, a probe may read). */
    final ConcurrentHashMap<Long, RealChunk> real = new ConcurrentHashMap<>();
    private final Long2ObjectOpenHashMap<Tile> tiles = new Long2ObjectOpenHashMap<>();
    /**
     * Package 12c: the tiles whose staged mesh is current (with quads; a tile waiting for its remake after a real chunk came in keeps its place while its last mesh is drawn):
     * real sections past the hand-over band are left out only over these ({@code FarLayer.covers}). Any thread reads.
     */
    final java.util.Set<Long> current = ConcurrentHashMap.newKeySet();

    // numbers for the bench and the log (any thread reads)
    final AtomicLong columnsSampled = new AtomicLong(), columnsReal = new AtomicLong(), tilesMade = new AtomicLong(), quadsMade = new AtomicLong(),
        sampleNanos = new AtomicLong(), meshNanos = new AtomicLong(), tilesFromReal = new AtomicLong(), realChunksIn = new AtomicLong(),
        heightsReused = new AtomicLong(), quadsMerged = new AtomicLong(), skirtsLeftOut = new AtomicLong(), columnsCached = new AtomicLong(),
        seenLoaded = new AtomicLong(), sitesCount = new AtomicLong(), cliffQuads = new AtomicLong();
    volatile int tilesWanted, tilesDone;
    /** Package 12c: the nearest wanted tile (blocks from the camera to its nearest point) not made at all yet; -1 for none. */
    volatile int nearestMissing = -1;
    /** Package 12c: the bytes the tiles' samples hold on the heap (estimated from their arrays; the sampling thread writes). */
    final AtomicLong tileHeapBytes = new AtomicLong();
    /** From real chunks only: the radius within which every chunk is known (see {@link #coveredRadius}). */
    volatile int covered;
    private long coveredState = Long.MIN_VALUE;
    volatile long firstPassNanos = -1;
    private final long started = System.nanoTime();
    volatile String problem;

    /** This session's id (FarLayer drops tiles of any other). */
    final int id;

    /** Package 12c: the disk cache (sampled tiles, seen chunks), or null. */
    final FarCache cache;

    FarTiles(ResourceKey<Level> dimension, FarSource source, int floorY, double camX, double camZ, int id, FarCache cache) {
        this.id = id;
        this.cache = cache;
        this.dimension = dimension;
        this.source = source;
        this.trees = source == null ? null : new FarTrees(source.generator);
        this.floorY = floorY;
        // the vertices' anchor: a multiple of 1024 near the camera; the far distance (4096 at most) stays inside 16 bits
        this.anchorX = Math.floorDiv((int) Math.floor(camX), 1024) * 1024;
        this.anchorZ = Math.floorDiv((int) Math.floor(camZ), 1024) * 1024;
        this.camX = camX;
        this.camZ = camZ;
        this.thread = new Thread(this, "Quicksilver far terrain");
        thread.setDaemon(true);
        thread.setPriority(Thread.MIN_PRIORITY);
    }

    void start() {
        thread.start();
    }

    void stop() {
        stop = true;
        thread.interrupt();
    }

    /** Package 12c: waits (at most {@code ms}) for the thread's last disk cache write. */
    void waitFlushed(long ms) {
        try {
            thread.join(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /** Package 12c: stops, and waits a moment for the disk cache's last write (leaving a server, closing the game). */
    void stopAndWait() {
        stop();
        if (cache != null) {
            try {
                thread.join(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    long threadId() {
        return thread.threadId();
    }

    /** Whether the camera moved so far from the anchor that the vertices' 16 bits no longer reach (then a new session). */
    boolean anchorTooFar(double x, double z) {
        // package 12c: as far as the 16 bits reach with the far distance and a tile of slack around the camera (12b: 12000,
        // which a 10-minute flight crossed: the session started over and the tiles near it were holes for a while)
        int limit = 30000 - (radius + 2 * TILE);
        return Math.abs(x - anchorX) > limit || Math.abs(z - anchorZ) > limit;
    }

    static long key(int tx, int tz) {
        return (long) tx << 32 | (tz & 0xFFFFFFFFL);
    }

    static long chunkKey(int cx, int cz) {
        return (long) cx << 32 | (cz & 0xFFFFFFFFL);
    }

    private static int spacingFor(double chunks) {
        if (chunks < 16) return 4;
        if (chunks < 32) return 8;
        if (chunks < 64) return 16;
        // package 12c: 64 blocks past 128 chunks (192 and 256 chunks reach there; at that distance a 64-block step is a
        // pixel or two)
        if (chunks < 128 || com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_MESH.on()) return 32;
        return 64;
    }

    /** Package 12c: the mesh mode the tiles were staged with (CI's A/B re-stages them all when it changes). */
    private boolean stagedOldMesh, sampledOldLook;
    private int stagedLook;

    @Override
    public void run() {
        long cappedSince = System.nanoTime();
        int cappedCount = 0;
        try {
            while (!stop) {
                if (paused) {
                    realIn.clear();
                    Thread.sleep(250);
                    continue;
                }
                boolean oldMesh = com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_MESH.on();
                int look = (com.meakaandre.quicksilver.speed.Speed.CI_FAR_BOX_TREES.on() ? 1 : 0) | (com.meakaandre.quicksilver.speed.Speed.CI_FAR_NO_STRUCTURES.on() ? 2 : 0)
                    | (com.meakaandre.quicksilver.speed.Speed.CI_FAR_FULL_TREES.on() ? 4 : 0);
                if (oldMesh != stagedOldMesh || look != stagedLook) {
                    stagedOldMesh = oldMesh;
                    stagedLook = look;
                    remeshRequested = true;
                }
                // the old look changes the sampled colours (snow, ice): every tile sampled again
                boolean oldLook = com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_LOOK.on();
                if (oldLook != sampledOldLook) {
                    sampledOldLook = oldLook;
                    clearRequested = true;
                }
                if (remeshRequested) {
                    remeshRequested = false;
                    for (Tile t : tiles.values()) {
                        if (t.spacing == 0) continue;
                        t.staged = false;
                        stage(t);
                    }
                }
                if (clearRequested) {
                    clearRequested = false;
                    current.clear();
                    for (Tile t : tiles.values()) {
                        t.spacing = 0;
                        t.staged = false;
                    }
                }
                // real chunks that arrived: kept, and their tiles marked to be made again
                RealChunk rc;
                while ((rc = realIn.poll()) != null) {
                    // package 12c: a chunk the client has now always goes in (review: once the disk's seen chunks filled the
                    // map, new ones were dropped); the cap holds the disk's back (loadSeen) and eviction keeps it bounded
                    RealChunk was = real.get(chunkKey(rc.cx, rc.cz));
                    // read again unchanged (the client re-reads its chunks in turn): nothing to make again
                    if (was != null && java.util.Arrays.equals(was.solidTop, rc.solidTop) && java.util.Arrays.equals(was.fluidTop, rc.fluidTop)
                        && java.util.Arrays.equals(was.color, rc.color) && java.util.Arrays.equals(was.fluidColor, rc.fluidColor)) continue;
                    real.put(chunkKey(rc.cx, rc.cz), rc);
                    realChunksIn.incrementAndGet();
                    if (cache != null && rc.block() != null) cache.putSeen(new FarCache.SeenChunk(rc.cx, rc.cz, rc.solidTop, rc.fluidTop, rc.block, rc.fluidBlock, rc.biome));
                    int rtx = Math.floorDiv(rc.cx * 16, TILE), rtz = Math.floorDiv(rc.cz * 16, TILE);
                    markDirty(rtx, rtz);
                    // package 12c: a chunk at a tile's low edge also holds the edge samples of the tiles before it (their
                    // last row and column), which must match (skirts are only where spacings differ now)
                    boolean lowX = Math.floorMod(rc.cx * 16, TILE) == 0, lowZ = Math.floorMod(rc.cz * 16, TILE) == 0;
                    if (lowX) markDirty(rtx - 1, rtz);
                    if (lowZ) markDirty(rtx, rtz - 1);
                    if (lowX && lowZ) markDirty(rtx - 1, rtz - 1);
                }
                if (cache != null) cache.flush(false);
                answerFind();
                double cx = camX, cz = camZ;
                int r = radius;
                // package 12c: real chunks (and the disk cache's regions) far behind the far distance leave memory every
                // few seconds, so a long flight doesn't grow it (the seen-chunks cache keeps them on disk and reads them
                // again when the camera comes back)
                if (System.nanoTime() - lastEvict > 5_000_000_000L) {
                    lastEvict = System.nanoTime();
                    evictFar(cx, cz, r + 512);
                }
                int ctx = Math.floorDiv((int) Math.floor(cx), TILE), ctz = Math.floorDiv((int) Math.floor(cz), TILE);
                int reach = r / TILE + 1;
                // tiles beyond the far distance go
                LongArrayList gone = new LongArrayList();
                for (Tile t : tiles.values()) {
                    if (Math.max(Math.abs(t.tx - ctx), Math.abs(t.tz - ctz)) > reach + 1) gone.add(key(t.tx, t.tz));
                }
                for (long k : gone) {
                    current.remove(k);
                    Tile t = tiles.remove(k);
                    if (t != null) tileHeapBytes.addAndGet(-heapOf(t));
                    if (t != null && t.staged) FarLayer.remove(k, id);
                }
                if (source == null) {
                    // again only when something it reads changed (the camera's chunk, real chunks in, tiles made)
                    long ck = chunkKey(Math.floorDiv((int) Math.floor(cx), 16), Math.floorDiv((int) Math.floor(cz), 16));
                    long state = ck * 31 + realChunksIn.get() * 17 + tilesMade.get() + r;
                    if (state != coveredState) {
                        coveredState = state;
                        covered = coveredRadius(cx, cz, r);
                    }
                }
                // the nearest tile that needs work: new, at another spacing now, or with new real chunks (capped)
                Tile best = null;
                boolean bestHole = false;
                double bestNear = 0;
                int bestSpacing = 0;
                double bestDist = Double.MAX_VALUE;
                boolean bestCapped = false;
                int wanted = 0, done = 0;
                double missing = Double.MAX_VALUE;
                long now = System.nanoTime();
                if (now - cappedSince > 1_000_000_000L) {
                    cappedSince = now;
                    cappedCount = 0;
                }
                for (int dz = -reach; dz <= reach; dz++) {
                    for (int dx = -reach; dx <= reach; dx++) {
                        int tx = ctx + dx, tz = ctz + dz;
                        // package 12c: the seen chunks the disk cache holds around this tile, once per region
                        if (cache != null && !cache.seenRead(tx * (TILE / 16), tz * (TILE / 16))) loadSeen(tx * (TILE / 16), tz * (TILE / 16));
                        double mx = tx * TILE + TILE / 2.0 - cx, mz = tz * TILE + TILE / 2.0 - cz;
                        double dist = Math.sqrt(mx * mx + mz * mz);
                        // the tile's nearest point inside the far distance, and the tile not wholly inside the hand-over circle
                        double near = Math.max(0, dist - TILE * 0.7072);
                        double farthest = dist + TILE * 0.7072;
                        if (near > r || (!inside && farthest < handEnd - 32)) continue;
                        wanted++;
                        Tile t = tiles.get(key(tx, tz));
                        int sp = spacingFor(near / 16.0);
                        boolean need = t == null || t.spacing != sp;
                        if ((t == null || t.solidTop == null) && near < missing) missing = near;
                        boolean capped = false;
                        if (!need && t.dirty) {
                            need = true;
                            capped = true;
                        }
                        // from real chunks only: a tile with no real chunk in it is made at once (it holds nothing), the others capped
                        if (source == null && need && hasReal(tx, tz)) capped = true;
                        if (!need) {
                            done++;
                            continue;
                        }
                        if (capped && cappedCount >= CAPPED_PER_SECOND) continue;
                        // package 12b: tiles wholly inside the circle (for holes only) after every other tile
                        // (with a generator only: real-only sessions keep the nearest first, which also sets their fog radius)
                        double order = source != null && farthest < handEnd - 32 ? dist + 1e7 : dist;
                        // package 12c: with a generator, a tile not made at all (a hole) before one made at another spacing
                        // (only blurrier), so moving fast fills ahead first (CI's flight found holes at 200 blocks)
                        boolean hole = t == null || t.solidTop == null;
                        if (source != null && !hole && !com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_MESH.on()) order += 5e5;
                        if (order < bestDist) {
                            bestHole = hole;
                            bestNear = near;
                            bestDist = order;
                            best = t == null ? new Tile(tx, tz) : t;
                            bestSpacing = sp;
                            bestCapped = capped;
                        }
                    }
                }
                tilesWanted = wanted;
                tilesDone = done;
                nearestMissing = missing == Double.MAX_VALUE ? -1 : (int) missing;
                if (best == null) {
                    if (firstPassNanos < 0 && wanted > 0 && done == wanted) firstPassNanos = System.nanoTime() - started;
                    Thread.sleep(50);
                    continue;
                }
                if (bestCapped) cappedCount++;
                tiles.put(key(best.tx, best.tz), best);
                long w0 = System.nanoTime();
                make(best, bestSpacing);
                // at most about half a core: rest as long as the tile took (up to 100 ms), so moving fast on a weak CPU
                // doesn't take a whole core from the game
                long worked = System.nanoTime() - w0;
                // package 12c: no rest while a hole lies within 512 blocks of the band (catching up while moving fast)
                if (bestHole && bestNear < handEnd + 512) Thread.sleep(1);
                else Thread.sleep(Math.min(100, Math.max(1, worked / 1_000_000L)));
            }
        } catch (InterruptedException e) {
            // stopped
        } catch (Throwable t) {
            problem = t.toString();
            FarNet.LOG.error("Quicksilver far terrain: its sampling thread stopped; far terrain shows what it had", t);
        } finally {
            // package 12c: what the disk cache doesn't have yet is written now (the interrupt that stopped the thread is
            // cleared first: file channels close on an interrupted thread)
            if (cache != null) {
                Thread.interrupted();
                try {
                    cache.flush(true);
                } catch (Throwable t) {
                    FarNet.LOG.warn("Quicksilver far terrain: its disk cache could not be written ({})", t.toString());
                }
                flushed = true;
            }
        }
    }

    /** Package 12c: a CI find request ({@link FarTerrain#find}), answered on the sampling thread. */
    volatile String findRequest;

    private void answerFind() {
        String kind = findRequest;
        if (kind == null) return;
        findRequest = null;
        double cx = camX, cz = camZ;
        int sea = source != null ? source.seaLevel : 63;
        double best = -1;
        int bx = 0, by = 0, bz = 0;
        java.util.List<Long> keys = new java.util.ArrayList<>(tiles.keySet());
        java.util.Collections.sort(keys);
        for (long key : keys) {
            Tile t = tiles.get(key);
            if (t.kind == null || t.spacing > 16) continue;
            int n = t.n, s = t.spacing;
            for (int j = 2; j < n - 2; j++) {
                for (int i = 2; i < n - 2; i++) {
                    int k = j * n + i;
                    if ((t.flags[k] & 1) == 0) continue;
                    int x = t.tx * TILE + i * s, z = t.tz * TILE + j * s;
                    double d = Math.hypot(x - cx, z - cz);
                    if (d < 300 || d > 900) continue;
                    double score;
                    switch (kind) {
                        case "snow" -> score = (t.kind[k] & 1) != 0 && t.solidTop[k] > sea + 50 ? t.solidTop[k] : -1;
                        case "forest" -> {
                            boolean edge = (t.kind[k] & 6) == 2 && ((t.kind[k + 2] & 6) == 0 || (t.kind[k - 2] & 6) == 0 || (t.kind[k + 2 * n] & 6) == 0 || (t.kind[k - 2 * n] & 6) == 0);
                            score = edge ? 1000 - Math.abs(d - 500) : -1;
                        }
                        case "shore" -> {
                            boolean shore = (t.kind[k] & 4) != 0 && ((t.kind[k + 2] & 4) == 0 || (t.kind[k - 2] & 4) == 0 || (t.kind[k + 2 * n] & 4) == 0 || (t.kind[k - 2 * n] & 4) == 0);
                            score = shore ? 1000 - Math.abs(d - 500) : -1;
                        }
                        default -> score = -1;
                    }
                    if (score > best) {
                        best = score;
                        bx = x;
                        by = Math.max(t.solidTop[k], t.fluidTop[k] == FarSource.NONE ? 0 : t.fluidTop[k]);
                        bz = z;
                    }
                }
            }
        }
        if (best < 0) {
            FarNet.LOG.info("Quicksilver far terrain find {}: none", kind);
            return;
        }
        // the viewpoint: 220 blocks from the target, toward the camera, 90 above it, looking at it (past the band at
        // render distance 8, so far terrain draws the target)
        double dx = cx - bx, dz = cz - bz, len = Math.max(1, Math.hypot(dx, dz));
        double vx = bx + dx / len * 220, vz = bz + dz / len * 220, vy = by + 90;
        float yaw = (float) Math.toDegrees(Math.atan2(-(bx - vx), bz - vz));
        float pitch = (float) Math.toDegrees(Math.atan2(vy - by, 220));
        FarNet.LOG.info("Quicksilver far terrain find {}: {} {} {} {} {} (target {} {} {})", kind, String.format(java.util.Locale.ROOT, "%.1f", vx),
            String.format(java.util.Locale.ROOT, "%.1f", vy), String.format(java.util.Locale.ROOT, "%.1f", vz), String.format(java.util.Locale.ROOT, "%.1f", yaw),
            String.format(java.util.Locale.ROOT, "%.1f", pitch), bx, by, bz);
    }

    /** Package 12c: set once the thread wrote the disk cache at its end (stop waits a moment for it). */
    volatile boolean flushed;

    /**
     * From real chunks only: how far from the camera (blocks) every chunk is known (rings of chunks around the camera's
     * chunk, out to the far distance, until the first ring with a chunk the client never had). The fog moves out to it,
     * so land seen before shows and land never seen stays in the fog.
     */
    private int coveredRadius(double cx, double cz, int r) {
        int ccx = Math.floorDiv((int) Math.floor(cx), 16), ccz = Math.floorDiv((int) Math.floor(cz), 16);
        int maxRing = r / 16;
        int handChunks = Math.max(0, handEnd / 16 - 1);
        for (int d = 0; d <= maxRing; d++) {
            for (int i = -d; i <= d; i++) {
                if (!known(ccx + i, ccz - d, d, handChunks) || !known(ccx + i, ccz + d, d, handChunks)
                    || !known(ccx - d, ccz + i, d, handChunks) || !known(ccx + d, ccz + i, d, handChunks)) {
                    // ring d has a gap: the nearest point of ring d is (d - 1) * 16 blocks away at least, roughly; less
                    // two sample steps there (a quad needs all four of its corners)
                    return Math.max(0, (d - 1) * 16 - 2 * spacingFor(d));
                }
            }
        }
        return maxRing * 16 - 2 * spacingFor(maxRing);
    }

    /** A chunk known to the fog radius: the client had it and, outside real terrain, its tile is made as it is now. */
    private boolean known(int cx, int cz, int ring, int handChunks) {
        if (!real.containsKey(chunkKey(cx, cz))) return false;
        if (ring < handChunks) return true;
        Tile t = tiles.get(key(Math.floorDiv(cx * 16, TILE), Math.floorDiv(cz * 16, TILE)));
        return t != null && t.staged && !t.dirty;
    }

    /** Package 12c: a region of seen chunks from the disk cache into the real chunks (chunks the client has now win). */
    private void loadSeen(int cx, int cz) {
        for (FarCache.SeenChunk c : cache.seenAround(cx, cz)) {
            long k = chunkKey(c.cx(), c.cz());
            if (real.containsKey(k) || real.size() >= REAL_MAX * 3 / 4) continue;
            int[] color = new int[16], fcolor = new int[16];
            for (int i = 0; i < 16; i++) {
                if (c.solid()[i] == FarSource.NONE) continue;
                int x = c.cx() * 16 + (i & 3) * 4, z = c.cz() * 16 + (i >> 2) * 4;
                if (c.block()[i] != null) color[i] = FarColors.color(c.block()[i], c.biome()[i], x, c.solid()[i] - 1, z);
                if (c.fluid()[i] != FarSource.NONE && c.fluidBlock()[i] != null) fcolor[i] = FarColors.color(c.fluidBlock()[i], c.biome()[i], x, c.fluid()[i] - 1, z);
            }
            real.put(k, new RealChunk(c.cx(), c.cz(), c.solid(), c.fluid(), color, fcolor, c.block(), c.fluidBlock(), c.biome()));
            realChunksIn.incrementAndGet();
            seenLoaded.incrementAndGet();
            int rtx = Math.floorDiv(c.cx() * 16, TILE), rtz = Math.floorDiv(c.cz() * 16, TILE);
            markDirty(rtx, rtz);
        }
    }

    private static boolean sitesDone(Tile t) {
        return t.sitesKnown;
    }

    private long lastEvict = System.nanoTime();

    private void evictFar(double cx, double cz, double keep) {
        double k2 = keep * keep;
        // by the disk cache's regions (64 x 64 chunks): a region's chunks go together, as the cache reads them back
        int span = FarCache.REGION_TILES * TILE;
        real.keySet().removeIf(key -> {
            int rx = Math.floorDiv((int) (key >> 32) * 16, span), rz = Math.floorDiv((int) (long) key * 16, span);
            double nx = Math.max(Math.max(rx * span - cx, cx - (rx + 1) * span), 0), nz = Math.max(Math.max(rz * span - cz, cz - (rz + 1) * span), 0);
            return nx * nx + nz * nz > k2;
        });
        if (cache != null) cache.evict(cx, cz, keep);
    }

    private void markDirty(int tx, int tz) {
        Tile t = tiles.get(key(tx, tz));
        if (t == null) return;
        boolean was = t.dirty;
        t.dirty = true;
        // a staged tile keeps covering while it waits for its remake (its last mesh is still drawn): real sections past
        // the band under it no longer pop in for the few frames each real chunk's arrival takes (CI: far_land's real
        // edge drawn or not by when a chunk last came in)
        if (!t.staged) current.remove(key(tx, tz));
        // (review) its edges get skirts at once while it waits for its capped remake, and its neighbours' toward it
        if (!was && t.staged) {
            stage(t);
            restageNeighbours(t);
        }
    }

    private boolean hasReal(int tx, int tz) {
        int cx0 = tx * (TILE / 16), cz0 = tz * (TILE / 16);
        for (int dz = 0; dz < TILE / 16; dz++) for (int dx = 0; dx < TILE / 16; dx++) if (real.containsKey(chunkKey(cx0 + dx, cz0 + dz))) return true;
        return false;
    }

    /** Samples a tile at a spacing and stages its mesh. */
    private void make(Tile t, int spacing) {
        long t0 = System.nanoTime();
        int n = TILE / spacing + 1;
        int ox = t.tx * TILE, oz = t.tz * TILE;
        int[] solid = new int[n * n], fluid = new int[n * n], color = new int[n * n], fcolor = new int[n * n];
        byte[] flags = new byte[n * n];
        @SuppressWarnings("unchecked")
        Holder<Biome>[] biome = new Holder[n * n];
        FarSource.Heights[] hs = source == null ? null : new FarSource.Heights[n * n];
        // package 12c: the generator's heights from the tile's earlier spacing are reused where the grids share a column
        // (spacings are powers of two on the same 128-block tile, so every other or every fourth column, both ways)
        FarSource.Heights[] old = t.hs;
        byte[] oldFlags = t.flags;
        int s0 = t.spacing, n0 = t.n;
        boolean reuse = old != null && oldFlags != null && s0 > 0;
        // package 12c: the disk cache's columns for this tile (any spacing; used where its grid shares a column)
        // (not while CI's old look is on: the cache holds the new look's blocks, and mustn't get the old look's)
        boolean useCache = cache != null && source != null && !com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_LOOK.on();
        FarCache.GenTile cached = useCache ? cache.genTile(t.tx, t.tz) : null;
        BlockState[] blockOf = new BlockState[n * n], fluidOf = new BlockState[n * n];
        boolean[] fromCache = cached != null ? new boolean[n * n] : null;
        int realChunks = 0;
        // real columns first, then the generator's heights for the rest
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                int x = ox + i * spacing, z = oz + j * spacing, k = j * n + i;
                RealChunk rc = real.get(chunkKey(x >> 4, z >> 4));
                if (rc != null) {
                    int s = ((z & 15) >> 2) * 4 + ((x & 15) >> 2);
                    if (rc.solidTop[s] != FarSource.NONE) {
                        solid[k] = rc.solidTop[s];
                        fluid[k] = rc.fluidTop[s];
                        color[k] = rc.color[s];
                        fcolor[k] = rc.fluidColor[s];
                        flags[k] = 3;
                        columnsReal.incrementAndGet();
                        realChunks++;
                    }
                    continue;
                }
                if (hs != null) {
                    int ox0 = i * spacing, oz0 = j * spacing;
                    if (cached != null && ox0 % cached.spacing() == 0 && oz0 % cached.spacing() == 0) {
                        int kc = (oz0 / cached.spacing()) * cached.n() + ox0 / cached.spacing();
                        if (kc < cached.known().length && (cached.known()[kc] & 1) != 0) {
                            fromCache[k] = true;
                            columnsCached.incrementAndGet();
                            flags[k] = 4;
                            if ((cached.known()[kc] & 2) != 0) {
                                solid[k] = cached.solid()[kc];
                                fluid[k] = cached.fluid()[kc];
                                blockOf[k] = cached.block()[kc];
                                fluidOf[k] = cached.fluidBlock()[kc];
                                biome[k] = cached.biome()[kc];
                                hs[k] = new FarSource.Heights(solid[k], fluid[k], fluidOf[k] != null ? fluidOf[k] : net.minecraft.world.level.block.Blocks.AIR.defaultBlockState());
                                flags[k] = 5;
                            }
                            continue;
                        }
                    }
                    FarSource.Heights h;
                    if (reuse && ox0 % s0 == 0 && oz0 % s0 == 0 && (oldFlags[(oz0 / s0) * n0 + ox0 / s0] & 4) != 0) {
                        h = old[(oz0 / s0) * n0 + ox0 / s0];
                        heightsReused.incrementAndGet();
                    } else {
                        h = source.heights(x, z);
                    }
                    hs[k] = h;
                    // bit 4: the generator's heights are known for this column (null: nothing there, the End's void)
                    flags[k] = 4;
                    if (h != null) {
                        solid[k] = h.solidTop();
                        fluid[k] = h.fluidTop();
                        flags[k] = 5;
                    }
                }
            }
        }
        if (hs != null) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    int k = j * n + i;
                    if (hs[k] == null || (flags[k] & 2) != 0) continue;
                    int x = ox + i * spacing, z = oz + j * spacing;
                    if (fromCache != null && fromCache[k]) {
                        // from the disk cache: its blocks and biome; only the colours are worked out (they follow the resource pack)
                        color[k] = FarColors.color(blockOf[k], biome[k], x, solid[k] - 1, z);
                        if (fluid[k] != FarSource.NONE && fluidOf[k] != null) fcolor[k] = FarColors.color(fluidOf[k], biome[k], x, fluid[k] - 1, z);
                        continue;
                    }
                    float gx = (solid[j * n + Math.min(i + 1, n - 1)] - solid[j * n + Math.max(i - 1, 0)]) / (float) (2 * spacing);
                    float gz = (solid[Math.min(j + 1, n - 1) * n + i] - solid[Math.max(j - 1, 0) * n + i]) / (float) (2 * spacing);
                    FarSource.Column c = source.column(x, z, hs[k], gx, gz);
                    biome[k] = c.biome();
                    blockOf[k] = c.block();
                    fluidOf[k] = c.fluidTop() != FarSource.NONE ? c.fluid() : null;
                    color[k] = FarColors.color(c.block(), c.biome(), x, c.top() - 1, z);
                    if (c.fluidTop() != FarSource.NONE) fcolor[k] = FarColors.color(c.fluid(), c.biome(), x, c.fluidTop() - 1, z);
                    columnsSampled.incrementAndGet();
                }
            }
        }
        // package 12c: this tile's generator columns into the disk cache (kept there if finer than what it has)
        if (useCache) {
            byte[] known = new byte[n * n];
            boolean any = false;
            for (int k = 0; k < n * n; k++) {
                if ((flags[k] & 4) == 0) continue;
                known[k] = (byte) ((flags[k] & 1) != 0 && blockOf[k] != null ? 3 : 1);
                any = true;
            }
            if (any) cache.putGen(t.tx, t.tz, new FarCache.GenTile(spacing, n, solid.clone(), fluid.clone(), blockOf, fluidOf, biome.clone(), known));
        }
        long t1 = System.nanoTime();
        sampleNanos.addAndGet(t1 - t0);
        tileHeapBytes.addAndGet(-heapOf(t));
        t.spacing = spacing;
        t.n = n;
        t.solidTop = solid;
        t.fluidTop = fluid;
        t.color = color;
        t.fluidColor = fcolor;
        t.flags = flags;
        t.biome = biome;
        t.hs = hs;
        byte[] kinds = new byte[n * n];
        for (int k = 0; k < n * n; k++) {
            BlockState b = blockOf[k];
            if (b != null && (b.is(net.minecraft.world.level.block.Blocks.SNOW_BLOCK) || b.is(net.minecraft.world.level.block.Blocks.SNOW)
                || b.is(net.minecraft.world.level.block.Blocks.POWDER_SNOW))) kinds[k] |= 1;
            if (trees != null && biome[k] != null && !trees.of(biome[k]).trees().isEmpty()) kinds[k] |= 2;
            if (fluid[k] != FarSource.NONE) kinds[k] |= 4;
        }
        t.kind = kinds;
        // package 12c: the structures starting here (from the seed; cheap: one grid cell or two per set)
        if (source != null && source.structures != null && t.sites.isEmpty() && !sitesDone(t)) {
            t.sites = source.structures.in(t.tx, t.tz);
            sitesCount.addAndGet(t.sites.size());
        }
        t.sitesKnown = true;
        t.dirty = false;
        t.realChunks = realChunks;
        tileHeapBytes.addAndGet(heapOf(t));
        if (realChunks > 0) tilesFromReal.incrementAndGet();
        stage(t);
        // package 12c: the neighbours' skirts toward this tile follow its spacing (a skirt only where spacings differ)
        restageNeighbours(t);
        meshNanos.addAndGet(System.nanoTime() - t1);
        tilesMade.incrementAndGet();
    }

    /** Package 12c: neighbours staged with a skirt toward {@code t} that it no longer needs (or the other way) are staged again. */
    private void restageNeighbours(Tile t) {
        for (int e = 0; e < 4; e++) {
            int[] d = EDGE[e];
            Tile nb = tiles.get(key(t.tx + d[0], t.tz + d[1]));
            if (nb == null || nb.spacing == 0 || !nb.staged && nb.solidTop == null) continue;
            int back = e ^ 1;
            boolean had = (nb.skirtMask & (1 << back)) != 0;
            if (had != skirtWanted(nb, back)) stage(nb);
        }
    }

    /** Edge e's neighbour offset (0: z low, 1: z high, 2: x low, 3: x high; e ^ 1 is the opposite edge). */
    private static final int[][] EDGE = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    /** Package 12c: whether edge e of a tile needs a skirt: its neighbour there isn't made, or at another spacing. */
    private boolean skirtWanted(Tile t, int e) {
        if (com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_MESH.on()) return true;
        int[] d = EDGE[e];
        Tile nb = tiles.get(key(t.tx + d[0], t.tz + d[1]));
        // a tile waiting to be made again (a real chunk at the shared edge) may not match its neighbour's edge yet
        return nb == null || nb.spacing != t.spacing || nb.solidTop == null || nb.dirty || t.dirty;
    }

    /** A tile's samples on the heap, estimated: four int arrays, the flags, the biome references (4 bytes each) and headers. */
    private static long heapOf(Tile t) {
        if (t.solidTop == null) return 0;
        long cells = (long) t.n * t.n;
        // with a generator also its heights: a reference and a small record per column
        return cells * (4 * 4 + 1 + 4 + (t.hs != null ? 4 + 24 : 0)) + 7 * 16 + 64;
    }

    /** Package 12c: the samples and the real chunks this session holds on the heap (estimated; any thread). */
    long heapBytes() {
        // a real chunk: five arrays of 16 (four of ints, one of references) with their headers, the record and its map entry
        return tileHeapBytes.get() + (long) real.size() * (4 * 16 * 4 + 16 * 4 + 5 * 16 + 32 + 48);
    }

    // ---- the mesh

    private static final class Mesh {
        ByteBuffer buf = MemoryUtil.memAlloc(64 * 1024);
        int quads;
        /** Its buffer was handed to the far layer or freed. */
        boolean handed;
        final int ax, az, floor;

        Mesh(int ax, int az, int floor) {
            this.ax = ax;
            this.az = az;
            this.floor = floor;
        }

        float minX = Float.MAX_VALUE, maxX = -Float.MAX_VALUE, minY = Float.MAX_VALUE, maxY = -Float.MAX_VALUE,
            minZ = Float.MAX_VALUE, maxZ = -Float.MAX_VALUE;

        void vertex(float x, float y, float z, int rgb) {
            // the mesh's box (tree crowns reach past the tile's edge): the off-screen test uses it
            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
            if (z < minZ) minZ = z;
            if (z > maxZ) maxZ = z;
            if (buf.remaining() < FarLayer.BYTES) {
                ByteBuffer b = MemoryUtil.memAlloc(buf.capacity() * 2);
                buf.flip();
                b.put(buf);
                MemoryUtil.memFree(buf);
                buf = b;
            }
            int vx = clamp(Math.round(x) - ax + 32768), vz = clamp(Math.round(z) - az + 32768);
            int vy = clamp(Math.round((y - floor) * 16f));
            int r = (rgb >> 16) & 255, g = (rgb >> 8) & 255, b = rgb & 255;
            int c565 = ((r * 31 + 127) / 255) << 11 | ((g * 63 + 127) / 255) << 5 | ((b * 31 + 127) / 255);
            buf.putShort((short) vx).putShort((short) vy).putShort((short) vz).putShort((short) c565);
        }

        void quad(float[] p, int c0, int c1, int c2, int c3) {
            vertex(p[0], p[1], p[2], c0);
            vertex(p[3], p[4], p[5], c1);
            vertex(p[6], p[7], p[8], c2);
            vertex(p[9], p[10], p[11], c3);
            quads++;
        }

        private static int clamp(int v) {
            return Math.max(0, Math.min(65535, v));
        }
    }

    static int shade(int rgb, float f) {
        int r = Math.min(255, Math.round(((rgb >> 16) & 255) * f)), g = Math.min(255, Math.round(((rgb >> 8) & 255) * f)), b = Math.min(255, Math.round((rgb & 255) * f));
        return r << 16 | g << 8 | b;
    }

    /** The game's directional shade for a surface normal: 1 up, 0.8 north and south, 0.6 east and west (blended by the normal's parts). */
    static float facing(float nx, float ny, float nz) {
        float l2 = nx * nx + ny * ny + nz * nz;
        if (l2 <= 0) return 1;
        return (ny * ny * (ny >= 0 ? 1f : 0.5f) + nz * nz * 0.8f + nx * nx * 0.6f) / l2;
    }

    private void stage(Tile t) {
        Mesh m = new Mesh(anchorX, anchorZ, floorY);
        try {
            stageMesh(t, m);
        } catch (Throwable e) {
            // (review) the mesh's native buffer isn't left behind
            if (!m.handed) MemoryUtil.memFree(m.buf);
            throw e;
        }
    }

    private void stageMesh(Tile t, Mesh m) {
        int n = t.n, s = t.spacing, ox = t.tx * TILE, oz = t.tz * TILE;
        float[] q = new float[12];
        boolean oldMesh = com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_MESH.on();
        boolean oldLook = com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_LOOK.on();
        // package 12c: water at vanilla's surface (a source block's top is 8/9 of a block up: 1/8 below the block's top in
        // the vertex's 1/16 steps), not at the block's top
        float wl = oldLook ? 0 : 0.125f;
        // each sample's ground colour with its facing's shade (the normal from the neighbouring heights)
        int[] lit = new int[n * n];
        for (int j = 0; j < n; j++) for (int i = 0; i < n; i++) lit[j * n + i] = oldLook ? lit(t, i, j) : relief(t, i, j, source != null ? source.seaLevel : 63, t.color[j * n + i]);
        // package 12c: cliffs (cells far steeper than a slope can be in blocks) in the generator's stone below their top
        // edge, as real cliffs show their stone, not their top blocks smeared down the face
        int[] rock = null;
        if (!oldLook) {
            int rockRgb = FarColors.color(source != null ? source.rock() : net.minecraft.world.level.block.Blocks.STONE.defaultBlockState(), null, ox, 0, oz);
            rock = new int[n * n];
            for (int j = 0; j < n; j++) for (int i = 0; i < n; i++) rock[j * n + i] = relief(t, i, j, source != null ? source.seaLevel : 63, rockRgb);
        }
        // the ground and the water. Package 12c: a cell whose four corners share one height and one colour (flat water,
        // flat ground of one block) joins its neighbours of the same height and colour in one quad (rows, then whole rows
        // down): the same picture with fewer quads
        int cells = n - 1;
        long[] keyOf = new long[cells * cells];
        boolean[] used = new boolean[cells * cells];
        final long NO = Long.MIN_VALUE;
        for (int j = 0; j < cells; j++) {
            for (int i = 0; i < cells; i++) {
                int a = j * n + i, b = j * n + i + 1, c = (j + 1) * n + i + 1, d = (j + 1) * n + i;
                int ci = j * cells + i;
                keyOf[ci] = NO;
                if ((t.flags[a] & t.flags[b] & t.flags[c] & t.flags[d] & 1) == 0) {
                    used[ci] = true;
                    continue;
                }
                boolean water = t.fluidTop[a] != FarSource.NONE && t.fluidTop[b] != FarSource.NONE && t.fluidTop[c] != FarSource.NONE && t.fluidTop[d] != FarSource.NONE;
                if (oldMesh) continue;
                if (water) {
                    int h = t.fluidTop[a], col = t.fluidColor[a];
                    if (t.fluidTop[b] == h && t.fluidTop[c] == h && t.fluidTop[d] == h && t.fluidColor[b] == col && t.fluidColor[c] == col && t.fluidColor[d] == col)
                        keyOf[ci] = 1L << 62 | (long) (h & 0xFFFF) << 32 | (col & 0xFFFFFFFFL);
                } else if (t.fluidTop[a] == FarSource.NONE && t.fluidTop[b] == FarSource.NONE && t.fluidTop[c] == FarSource.NONE && t.fluidTop[d] == FarSource.NONE) {
                    // (review: a shore cell with level ground under its water corners must keep the shore path)
                    int h = t.solidTop[a], col = lit[a];
                    if (t.solidTop[b] == h && t.solidTop[c] == h && t.solidTop[d] == h && lit[b] == col && lit[c] == col && lit[d] == col)
                        keyOf[ci] = (long) (h & 0xFFFF) << 32 | (col & 0xFFFFFFFFL);
                }
            }
        }
        for (int j = 0; j < cells; j++) {
            for (int i = 0; i < cells; i++) {
                int ci = j * cells + i;
                if (used[ci]) continue;
                int a = j * n + i, b = j * n + i + 1, c = (j + 1) * n + i + 1, d = (j + 1) * n + i;
                long key = keyOf[ci];
                if (key != NO) {
                    // the run: as wide as the row allows, then as many rows down as are wholly the same
                    int w = 1;
                    while (i + w < cells && !used[ci + w] && keyOf[ci + w] == key) w++;
                    int h = 1;
                    grow:
                    while (j + h < cells) {
                        for (int k = 0; k < w; k++) {
                            int cj = (j + h) * cells + i + k;
                            if (used[cj] || keyOf[cj] != key) break grow;
                        }
                        h++;
                    }
                    for (int dj = 0; dj < h; dj++) for (int di = 0; di < w; di++) used[(j + dj) * cells + i + di] = true;
                    float x0 = ox + i * s, x1 = ox + (i + w) * s, z0 = oz + j * s, z1 = oz + (j + h) * s;
                    float y = (short) (key >>> 32);
                    if ((key >>> 62 & 1) != 0) y -= wl;
                    int col = (int) key;
                    set(q, x0, y, z0, x0, y, z1, x1, y, z1, x1, y, z0);
                    m.quad(q, col, col, col, col);
                    if (w * h > 1) quadsMerged.addAndGet(w * h - 1);
                    continue;
                }
                used[ci] = true;
                float x0 = ox + i * s, x1 = x0 + s, z0 = oz + j * s, z1 = z0 + s;
                boolean water = t.fluidTop[a] != FarSource.NONE && t.fluidTop[b] != FarSource.NONE && t.fluidTop[c] != FarSource.NONE && t.fluidTop[d] != FarSource.NONE;
                if (water) {
                    // vanilla's up-face corner order: (x0, z0), (x0, z1), (x1, z1), (x1, z0)
                    set(q, x0, t.fluidTop[a] - wl, z0, x0, t.fluidTop[d] - wl, z1, x1, t.fluidTop[c] - wl, z1, x1, t.fluidTop[b] - wl, z0);
                    m.quad(q, t.fluidColor[a], t.fluidColor[d], t.fluidColor[c], t.fluidColor[b]);
                    continue;
                }
                if (!oldLook && (t.fluidTop[a] != FarSource.NONE || t.fluidTop[b] != FarSource.NONE || t.fluidTop[c] != FarSource.NONE || t.fluidTop[d] != FarSource.NONE)) {
                    // package 12c: a shore: the water corners at the water's surface in the water's colour, the others the
                    // ground, so the coast blends from land to sea in one quad (12b dropped such quads to the sea floor)
                    float ya = shoreY(t, a, wl), yb = shoreY(t, b, wl), yc = shoreY(t, c, wl), yd = shoreY(t, d, wl);
                    set(q, x0, ya, z0, x0, yd, z1, x1, yc, z1, x1, yb, z0);
                    float smax = Math.max(Math.max(ya, yb), Math.max(yc, yd)), smin = Math.min(Math.min(ya, yb), Math.min(yc, yd));
                    if (rock != null && smax - smin > 2 * s) {
                        // a cliff meeting the water: stone from below its top edge down to the water (no land-to-water
                        // gradient a hundred blocks tall)
                        m.quad(q, shoreCliff(t, a, ya, smax, lit, rock), shoreCliff(t, d, yd, smax, lit, rock), shoreCliff(t, c, yc, smax, lit, rock),
                            shoreCliff(t, b, yb, smax, lit, rock));
                        cliffQuads.incrementAndGet();
                    } else {
                        m.quad(q, shoreC(t, a, lit), shoreC(t, d, lit), shoreC(t, c, lit), shoreC(t, b, lit));
                    }
                    continue;
                }
                set(q, x0, t.solidTop[a], z0, x0, t.solidTop[d], z1, x1, t.solidTop[c], z1, x1, t.solidTop[b], z0);
                int hmax = Math.max(Math.max(t.solidTop[a], t.solidTop[b]), Math.max(t.solidTop[c], t.solidTop[d]));
                int hmin = Math.min(Math.min(t.solidTop[a], t.solidTop[b]), Math.min(t.solidTop[c], t.solidTop[d]));
                if (rock != null && hmax - hmin > 2 * s) {
                    // a cliff: its top corners keep their ground's colour, the rest are rock
                    m.quad(q, cliff(t, a, hmax, lit, rock), cliff(t, d, hmax, lit, rock), cliff(t, c, hmax, lit, rock), cliff(t, b, hmax, lit, rock));
                    cliffQuads.incrementAndGet();
                } else {
                    m.quad(q, lit[a], lit[d], lit[c], lit[b]);
                }
            }
        }
        // skirts down from the edges, so tiles of other spacings beside it show no gaps. Package 12c: only on an edge
        // whose neighbour is at another spacing or not made (tiles of one spacing share their edge samples exactly)
        int mask = 0;
        for (int e = 0; e < 4; e++) {
            if (!skirtWanted(t, e)) {
                skirtsLeftOut.incrementAndGet();
                continue;
            }
            mask |= 1 << e;
            for (int k = 0; k < n - 1; k++) {
                int i0, j0, i1, j1;
                switch (e) {
                    case 0 -> { i0 = k; j0 = 0; i1 = k + 1; j1 = 0; }
                    case 1 -> { i0 = k; j0 = n - 1; i1 = k + 1; j1 = n - 1; }
                    case 2 -> { i0 = 0; j0 = k; i1 = 0; j1 = k + 1; }
                    default -> { i0 = n - 1; j0 = k; i1 = n - 1; j1 = k + 1; }
                }
                int a = j0 * n + i0, b = j1 * n + i1;
                if ((t.flags[a] & t.flags[b] & 1) == 0) continue;
                float ya = top(t, a), yb = top(t, b);
                float bottom = Math.min(ya, yb) - Math.max(8, s * 2);
                float xa = ox + i0 * s, za = oz + j0 * s, xb = ox + i1 * s, zb = oz + j1 * s;
                set(q, xa, ya, za, xa, bottom, za, xb, bottom, zb, xb, yb, zb);
                int ca = shade(rock != null && t.fluidTop[a] == FarSource.NONE ? rock[a] : surface(t, a), 0.7f), cb = shade(rock != null && t.fluidTop[b] == FarSource.NONE ? rock[b] : surface(t, b), 0.7f);
                m.quad(q, ca, ca, cb, cb);
            }
        }
        t.skirtMask = mask;
        // trees on generated (not real) ground, near enough to see their shape
        if (trees != null && s <= 8) {
            for (int j = 0; j < n - 1; j++) {
                for (int i = 0; i < n - 1; i++) {
                    int a = j * n + i;
                    if ((t.flags[a] & 3) != 1 || t.fluidTop[a] != FarSource.NONE || t.biome[a] == null) continue;
                    FarTrees.Info info = trees.of(t.biome[a]);
                    if (info.trees().isEmpty()) continue;
                    int x = ox + i * s, z = oz + j * s;
                    float expected = info.perChunk() * (s * s) / 256f;
                    long h = hash(x, z);
                    // package 12c: past 16 chunks (8-block cells) at most one tree in two cells, each a quarter bigger: about
                    // half the quads of a forest there, its canopy as dense from afar
                    boolean sparse = s >= 8 && !com.meakaandre.quicksilver.speed.Speed.CI_FAR_FULL_TREES.on();
                    if ((h & 0xFFFF) / 65536f >= Math.min(sparse ? 0.5f : 1f, expected)) continue;
                    FarTrees.Tree tree = info.trees().get((int) ((h >>> 16) & 0x7FFFFFFF) % info.trees().size());
                    float cx = x + s / 2f + (((h >>> 40) & 255) / 255f - 0.5f) * (s - 2), cz = z + s / 2f + (((h >>> 48) & 255) / 255f - 0.5f) * (s - 2);
                    float ground = t.solidTop[a];
                    float crownTop = ground + tree.height() + 1, crownBottom = Math.max(ground + 1, crownTop - tree.crown() - 1);
                    float r = (tree.radius() + 0.5f) * (sparse ? 1.25f : 1f);
                    int leaves = FarColors.color(tree.leaves(), t.biome[a], x, (int) crownTop, z);
                    // package 12c: snow on the crowns where vanilla's freeze step would put it (half the leaves' colour)
                    if (source != null && source.snowAt(t.biome[a], x, (int) crownTop + 1, z)) leaves = mix(leaves, SNOW_RGB);
                    int log = FarColors.color(tree.log(), t.biome[a], x, (int) ground, z);
                    boolean boxes = com.meakaandre.quicksilver.speed.Speed.CI_FAR_BOX_TREES.on();
                    treeShape(m, q, boxes ? FarTrees.BOX : tree.shape(), cx, cz, ground, crownBottom, crownTop, r, leaves, log, s == 4);
                }
            }
        }
        // package 12c: the big structures as silhouettes, on generated ground (on real ground the real blocks show them)
        if (!com.meakaandre.quicksilver.speed.Speed.CI_FAR_NO_STRUCTURES.on()) {
            for (FarStructures.Site site : t.sites) structure(m, q, t, site);
        }
        if (m.quads == 0) {
            m.handed = true;
            MemoryUtil.memFree(m.buf);
            if (t.staged) FarLayer.remove(key(t.tx, t.tz), id);
            t.staged = false;
            current.remove(key(t.tx, t.tz));
            return;
        }
        quadsMade.addAndGet(m.quads);
        m.buf.flip();
        m.handed = true;
        FarLayer.stage(key(t.tx, t.tz), m.buf, m.quads, id, (int) Math.floor(m.minX), (int) Math.floor(m.minZ), (int) Math.ceil(m.maxX),
            (int) Math.ceil(m.maxZ), (int) Math.floor(m.minY), (int) Math.ceil(m.maxY));
        t.staged = true;
        if (!t.dirty) current.add(key(t.tx, t.tz));
    }


    private static int shoreCliff(Tile t, int k, float y, float top, int[] lit, int[] rock) {
        return y >= top - 2 ? (t.fluidTop[k] != FarSource.NONE ? t.fluidColor[k] : lit[k]) : rock[k];
    }

    private static int cliff(Tile t, int k, int hmax, int[] lit, int[] rock) {
        return t.solidTop[k] >= hmax - 2 ? lit[k] : rock[k];
    }

    private static float shoreY(Tile t, int k, float wl) {
        return t.fluidTop[k] != FarSource.NONE ? Math.max(t.solidTop[k], t.fluidTop[k] - wl) : t.solidTop[k];
    }

    private static int shoreC(Tile t, int k, int[] lit) {
        return t.fluidTop[k] != FarSource.NONE ? t.fluidColor[k] : lit[k];
    }

    /**
     * Package 12c: a ground corner's colour shaded so hills and mountains read as 3D from afar: the game's facing shade,
     * a little darker in hollows and lighter on ridges (the heights around it against its own), and a touch lighter
     * with height above the sea (as distant peaks look).
     */
    private static int relief(Tile t, int i, int j, int seaLevel, int base) {
        int n = t.n, s = t.spacing;
        int k = j * n + i;
        int h = t.solidTop[k];
        int l = t.solidTop[j * n + Math.max(i - 1, 0)], r = t.solidTop[j * n + Math.min(i + 1, n - 1)];
        int u = t.solidTop[Math.max(j - 1, 0) * n + i], d = t.solidTop[Math.min(j + 1, n - 1) * n + i];
        float span = 2f * s;
        float f = facing(-(r - l) / span, 1f, -(d - u) / span);
        // hollow (neighbours higher) darker, ridge lighter: up to 12% either way
        float lap = ((l + r + u + d) * 0.25f - h) / Math.max(2f, s);
        f *= 1f - Math.max(-0.06f, Math.min(0.12f, lap * 0.12f));
        // height: up to 6% lighter 200 blocks above the sea
        f *= 1f + 0.06f * Math.max(0f, Math.min(1f, (h - seaLevel) / 200f));
        return shade(base, f);
    }

    private static float top(Tile t, int k) {
        return t.fluidTop[k] != FarSource.NONE ? t.fluidTop[k] : t.solidTop[k];
    }

    private static int surface(Tile t, int k) {
        return t.fluidTop[k] != FarSource.NONE ? t.fluidColor[k] : t.color[k];
    }

    /** A ground corner's colour with its facing's shade (the normal from the neighbouring heights). */
    private static int lit(Tile t, int i, int j) {
        int n = t.n, s = t.spacing;
        int k = j * n + i;
        float hx = t.solidTop[j * n + Math.min(i + 1, n - 1)] - t.solidTop[j * n + Math.max(i - 1, 0)];
        float hz = t.solidTop[Math.min(j + 1, n - 1) * n + i] - t.solidTop[Math.max(j - 1, 0) * n + i];
        float span = 2f * s;
        return shade(t.color[k], facing(-hx / span, 1f, -hz / span));
    }

    private static final int SNOW_RGB = 0xF0F4F8;

    /**
     * Package 12c: a structure's silhouette: a village as a cluster of small houses in its kind's wood or sandstone with
     * darker roofs, a woodland mansion as one big dark-oak block with a cobblestone top, an ocean monument as a dark
     * prismarine square just at the water's surface (it lies under water; far terrain's water is opaque).
     */
    private void structure(Mesh m, float[] q, Tile t, FarStructures.Site site) {
        int n = t.n, s = t.spacing, ox = t.tx * TILE, oz = t.tz * TILE;
        int i = Math.max(0, Math.min(n - 1, Math.round((site.x() - ox) / (float) s))), j = Math.max(0, Math.min(n - 1, Math.round((site.z() - oz) / (float) s)));
        int k = j * n + i;
        if ((t.flags[k] & 1) == 0 || (t.flags[k] & 2) != 0) return;
        Holder<Biome> b = t.biome[k];
        float ground = t.solidTop[k];
        long h = hash(site.x(), site.z());
        switch (site.kind()) {
            case FarStructures.VILLAGE -> {
                if (t.fluidTop[k] != FarSource.NONE) return;
                BlockState wall, roof;
                String v = site.variant();
                if (v.contains("desert")) {
                    wall = net.minecraft.world.level.block.Blocks.SMOOTH_SANDSTONE.defaultBlockState();
                    roof = net.minecraft.world.level.block.Blocks.CUT_SANDSTONE.defaultBlockState();
                } else if (v.contains("savanna")) {
                    wall = net.minecraft.world.level.block.Blocks.ACACIA_PLANKS.defaultBlockState();
                    roof = net.minecraft.world.level.block.Blocks.ACACIA_LOG.defaultBlockState();
                } else if (v.contains("snowy")) {
                    wall = net.minecraft.world.level.block.Blocks.SPRUCE_PLANKS.defaultBlockState();
                    roof = net.minecraft.world.level.block.Blocks.SNOW_BLOCK.defaultBlockState();
                } else if (v.contains("taiga")) {
                    wall = net.minecraft.world.level.block.Blocks.SPRUCE_PLANKS.defaultBlockState();
                    roof = net.minecraft.world.level.block.Blocks.SPRUCE_LOG.defaultBlockState();
                } else {
                    wall = net.minecraft.world.level.block.Blocks.OAK_PLANKS.defaultBlockState();
                    roof = net.minecraft.world.level.block.Blocks.OAK_LOG.defaultBlockState();
                }
                int wc = FarColors.color(wall, b, site.x(), (int) ground, site.z()), rc = shade(FarColors.color(roof, b, site.x(), (int) ground, site.z()), 0.85f);
                for (int u = 0; u < 9; u++) {
                    long hu = hash(site.x() + u * 31, site.z() - u * 17);
                    float dx = ((hu & 255) / 255f - 0.5f) * 80, dz = (((hu >>> 8) & 255) / 255f - 0.5f) * 80;
                    float half = 2.5f + ((hu >>> 16) & 3), tall = 4 + ((hu >>> 20) & 3);
                    float hx = site.x() + dx, hz = site.z() + dz;
                    float g = groundAt(t, hx, hz, ground);
                    box(m, q, hx - half, g, hz - half, hx + half, g + tall, hz + half, wc, false);
                    set(q, hx - half, g + tall, hz - half, hx - half, g + tall, hz + half, hx + half, g + tall, hz + half, hx + half, g + tall, hz - half);
                    m.quad(q, rc, rc, rc, rc);
                }
            }
            case FarStructures.MANSION -> {
                if (t.fluidTop[k] != FarSource.NONE) return;
                int wc = FarColors.color(net.minecraft.world.level.block.Blocks.DARK_OAK_PLANKS.defaultBlockState(), b, site.x(), (int) ground, site.z());
                int rc = FarColors.color(net.minecraft.world.level.block.Blocks.COBBLESTONE.defaultBlockState(), b, site.x(), (int) ground, site.z());
                float x0 = site.x() - 22, x1 = site.x() + 22, z0 = site.z() - 25, z1 = site.z() + 25, top = ground + 24;
                box(m, q, x0, ground - 2, z0, x1, top, z1, wc, false);
                set(q, x0, top, z0, x0, top, z1, x1, top, z1, x1, top, z0);
                m.quad(q, rc, rc, rc, rc);
            }
            case FarStructures.MONUMENT -> {
                if (t.fluidTop[k] == FarSource.NONE) return;
                int pc = FarColors.color(net.minecraft.world.level.block.Blocks.DARK_PRISMARINE.defaultBlockState(), b, site.x(), (int) ground, site.z());
                int c = mix(pc, t.fluidColor[k]);
                float y = t.fluidTop[k] - 0.0625f, x0 = site.x() - 29, x1 = site.x() + 29, z0 = site.z() - 29, z1 = site.z() + 29;
                set(q, x0, y, z0, x0, y, z1, x1, y, z1, x1, y, z0);
                m.quad(q, c, c, c, c);
            }
            default -> {
            }
        }
    }

    /** The tile's ground at (x, z) (the nearest sample; generated ground only), or {@code fallback}. */
    private static float groundAt(Tile t, float x, float z, float fallback) {
        int n = t.n, s = t.spacing;
        int i = Math.round((x - t.tx * TILE) / s), j = Math.round((z - t.tz * TILE) / s);
        if (i < 0 || j < 0 || i >= n || j >= n) return fallback;
        int k = j * n + i;
        return (t.flags[k] & 1) != 0 && t.fluidTop[k] == FarSource.NONE ? t.solidTop[k] : fallback;
    }

    private static int mix(int a, int b) {
        return (((a >> 16) & 255) + ((b >> 16) & 255)) / 2 << 16 | (((a >> 8) & 255) + ((b >> 8) & 255)) / 2 << 8 | ((a & 255) + (b & 255)) / 2;
    }

    /**
     * Package 12c: a far tree by its kind's shape (FarTrees): a spruce's two-tier cone, an oak's rounded blob (a wide box
     * with a narrower, taller one through it), a birch's thinner one, a jungle tree's tall trunk under a blob, an acacia's
     * flat wide crown, a dark oak's or cherry's wide blob; anything else a box. The trunk shows only within 16 chunks
     * ({@code trunk}).
     */
    private static void treeShape(Mesh m, float[] q, int shape, float cx, float cz, float ground, float bottom, float top, float r, int leaves, int log,
                                  boolean trunk) {
        float hgt = top - bottom;
        // package 12c: each shape no more quads than a box (a box cost 2% more frame time on the old-GPU profile when the
        // shapes had two parts each): a cone's four sides, a blob's four tapered sides and its top
        switch (shape) {
            case FarTrees.CONE -> frustum(m, q, cx, cz, bottom, r, top + 0.5f, 0f, leaves);
            case FarTrees.BLOB, FarTrees.THIN, FarTrees.WIDE -> {
                float rr = shape == FarTrees.THIN ? Math.max(1f, r * 0.7f) : shape == FarTrees.WIDE ? r * 1.25f : r;
                blob(m, q, cx, cz, bottom, top, rr, leaves);
            }
            case FarTrees.TALL -> {
                // a tall trunk (wider for the big ones) and a blob on top
                float cb = Math.max(bottom, top - Math.max(3f, hgt * 0.6f));
                blob(m, q, cx, cz, cb, top, r, leaves);
                bottom = cb;
                if (trunk || r > 2.5f) {
                    float w = r > 3 ? 1f : 0.5f;
                    if (bottom > ground + 0.5f) box(m, q, cx - w, ground, cz - w, cx + w, bottom, cz + w, log, false);
                    return;
                }
            }
            case FarTrees.FLAT -> {
                // a flat crown, wider than tall, on a bare trunk
                float rr = r * 1.3f, cb = Math.max(bottom, top - 2f);
                box(m, q, cx - rr, cb, cz - rr, cx + rr, top, cz + rr, leaves, true);
                bottom = cb;
            }
            default -> box(m, q, cx - r, bottom, cz - r, cx + r, top, cz + r, leaves, true);
        }
        if (trunk && bottom > ground + 0.5f) box(m, q, cx - 0.5f, ground, cz - 0.5f, cx + 0.5f, bottom, cz + 0.5f, log, false);
    }

    /** A rounded crown: four sides tapering from r at the bottom to 0.6 r at the top, and the top. */
    private static void blob(Mesh m, float[] q, float cx, float cz, float y0, float y1, float r, int rgb) {
        frustum(m, q, cx, cz, y0, r, y1, r * 0.6f, rgb);
        float t = r * 0.6f;
        set(q, cx - t, y1, cz - t, cx - t, y1, cz + t, cx + t, y1, cz + t, cx + t, y1, cz - t);
        m.quad(q, rgb, rgb, rgb, rgb);
    }

    /** Four sloped sides from a square of half-width r0 at y0 to one of r1 at y1 (r1 0: a point), shaded by their facing. */
    private static void frustum(Mesh m, float[] q, float cx, float cz, float y0, float r0, float y1, float r1, int rgb) {
        int ns = shade(rgb, 0.8f), ew = shade(rgb, 0.6f), up = shade(rgb, 0.92f);
        // the sides lean toward the sky: between their facing's shade and the top's
        int sn = mixShade(ns, up), se = mixShade(ew, up);
        float a0 = cx - r0, b0 = cx + r0, c0 = cz - r0, d0 = cz + r0;
        float a1 = cx - r1, b1 = cx + r1, c1 = cz - r1, d1 = cz + r1;
        set(q, b1, y1, c1, b0, y0, c0, a0, y0, c0, a1, y1, c1);
        m.quad(q, sn, sn, sn, sn);
        set(q, a1, y1, d1, a0, y0, d0, b0, y0, d0, b1, y1, d1);
        m.quad(q, sn, sn, sn, sn);
        set(q, a1, y1, c1, a0, y0, c0, a0, y0, d0, a1, y1, d1);
        m.quad(q, se, se, se, se);
        set(q, b1, y1, d1, b0, y0, d0, b0, y0, c0, b1, y1, c1);
        m.quad(q, se, se, se, se);
    }

    private static int mixShade(int a, int b) {
        return mix(a, b);
    }

    private static void box(Mesh m, float[] q, float x0, float y0, float z0, float x1, float y1, float z1, int rgb, boolean topFace) {
        int up = rgb, ns = shade(rgb, 0.8f), ew = shade(rgb, 0.6f);
        if (topFace) {
            set(q, x0, y1, z0, x0, y1, z1, x1, y1, z1, x1, y1, z0);
            m.quad(q, up, up, up, up);
        }
        set(q, x1, y1, z0, x1, y0, z0, x0, y0, z0, x0, y1, z0);
        m.quad(q, ns, ns, ns, ns);
        set(q, x0, y1, z1, x0, y0, z1, x1, y0, z1, x1, y1, z1);
        m.quad(q, ns, ns, ns, ns);
        set(q, x0, y1, z0, x0, y0, z0, x0, y0, z1, x0, y1, z1);
        m.quad(q, ew, ew, ew, ew);
        set(q, x1, y1, z1, x1, y0, z1, x1, y0, z0, x1, y1, z0);
        m.quad(q, ew, ew, ew, ew);
    }

    private static void set(float[] q, float... v) {
        System.arraycopy(v, 0, q, 0, 12);
    }

    private static long hash(int x, int z) {
        long h = x * 0x9E3779B97F4A7C15L ^ z * 0xC2B2AE3D27D4EB4FL;
        h ^= h >>> 31;
        h *= 0xBF58476D1CE4E5B9L;
        h ^= h >>> 29;
        return h;
    }

    /** Every staged tile is made again (the GPU's copies were lost, or the colours changed). Any thread. */
    void restageAll() {
        // the sampling thread sees the tiles as new on its next pass
        clearRequested = true;
    }

    private volatile boolean clearRequested, remeshRequested;
    /** Paused (far terrain switched off): the thread waits, the samples stay; resuming only re-makes the meshes. */
    volatile boolean paused;

    boolean remeshPending() {
        return remeshRequested;
    }

    /** Every tile's mesh is made again from its samples (after a pause: the GPU copies went). Any thread. */
    void remeshAll() {
        remeshRequested = true;
    }

    /** For the probe: whether real data covers (x, z), and the tile's state there. */
    String describeAt(int x, int z) {
        RealChunk rc = real.get(chunkKey(x >> 4, z >> 4));
        if (rc != null) {
            int s = ((z & 15) >> 2) * 4 + ((x & 15) >> 2);
            return "real, top " + rc.solidTop[s] + (rc.fluidTop[s] != FarSource.NONE ? ", fluid to " + rc.fluidTop[s] : "") + ", block " + rc.block[s];
        }
        return null;
    }
}
