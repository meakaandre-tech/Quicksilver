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
 * spacing grows with distance (4 blocks within 16 chunks, 8 to 32, 16 to 64, 32 beyond: design doc), from real chunk data
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
    record RealChunk(int cx, int cz, int[] solidTop, int[] fluidTop, int[] color, int[] fluidColor, BlockState[] block) {
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

    // numbers for the bench and the log (any thread reads)
    final AtomicLong columnsSampled = new AtomicLong(), columnsReal = new AtomicLong(), tilesMade = new AtomicLong(), quadsMade = new AtomicLong(),
        sampleNanos = new AtomicLong(), meshNanos = new AtomicLong(), tilesFromReal = new AtomicLong(), realChunksIn = new AtomicLong();
    volatile int tilesWanted, tilesDone;
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

    FarTiles(ResourceKey<Level> dimension, FarSource source, int floorY, double camX, double camZ, int id) {
        this.id = id;
        this.dimension = dimension;
        this.source = source;
        this.trees = source == null ? null : new FarTrees(source.generator);
        this.floorY = floorY;
        // the vertices' anchor: a multiple of 1024 near the camera; the far distance (2048 at most) stays well inside 16 bits
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

    long threadId() {
        return thread.threadId();
    }

    /** Whether the camera moved so far from the anchor that the vertices' 16 bits no longer reach (then a new session). */
    boolean anchorTooFar(double x, double z) {
        return Math.abs(x - anchorX) > 12000 || Math.abs(z - anchorZ) > 12000;
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
        return 32;
    }

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
                    for (Tile t : tiles.values()) {
                        t.spacing = 0;
                        t.staged = false;
                    }
                }
                // real chunks that arrived: kept, and their tiles marked to be made again
                RealChunk rc;
                while ((rc = realIn.poll()) != null) {
                    if (real.size() >= REAL_MAX && !real.containsKey(chunkKey(rc.cx, rc.cz))) continue;
                    RealChunk was = real.get(chunkKey(rc.cx, rc.cz));
                    // read again unchanged (the client re-reads its chunks in turn): nothing to make again
                    if (was != null && java.util.Arrays.equals(was.solidTop, rc.solidTop) && java.util.Arrays.equals(was.fluidTop, rc.fluidTop)
                        && java.util.Arrays.equals(was.color, rc.color) && java.util.Arrays.equals(was.fluidColor, rc.fluidColor)) continue;
                    real.put(chunkKey(rc.cx, rc.cz), rc);
                    realChunksIn.incrementAndGet();
                    Tile t = tiles.get(key(Math.floorDiv(rc.cx * 16, TILE), Math.floorDiv(rc.cz * 16, TILE)));
                    if (t != null) t.dirty = true;
                }
                double cx = camX, cz = camZ;
                int r = radius;
                int ctx = Math.floorDiv((int) Math.floor(cx), TILE), ctz = Math.floorDiv((int) Math.floor(cz), TILE);
                int reach = r / TILE + 1;
                // tiles beyond the far distance go
                LongArrayList gone = new LongArrayList();
                for (Tile t : tiles.values()) {
                    if (Math.max(Math.abs(t.tx - ctx), Math.abs(t.tz - ctz)) > reach + 1) gone.add(key(t.tx, t.tz));
                }
                for (long k : gone) {
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
                int bestSpacing = 0;
                double bestDist = Double.MAX_VALUE;
                boolean bestCapped = false;
                int wanted = 0, done = 0;
                long now = System.nanoTime();
                if (now - cappedSince > 1_000_000_000L) {
                    cappedSince = now;
                    cappedCount = 0;
                }
                for (int dz = -reach; dz <= reach; dz++) {
                    for (int dx = -reach; dx <= reach; dx++) {
                        int tx = ctx + dx, tz = ctz + dz;
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
                        if (order < bestDist) {
                            bestDist = order;
                            best = t == null ? new Tile(tx, tz) : t;
                            bestSpacing = sp;
                            bestCapped = capped;
                        }
                    }
                }
                tilesWanted = wanted;
                tilesDone = done;
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
                Thread.sleep(Math.min(100, Math.max(1, worked / 1_000_000L)));
            }
        } catch (InterruptedException e) {
            // stopped
        } catch (Throwable t) {
            problem = t.toString();
            FarNet.LOG.error("Quicksilver far terrain: its sampling thread stopped; far terrain shows what it had", t);
        }
    }

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
                    FarSource.Heights h = source.heights(x, z);
                    hs[k] = h;
                    if (h != null) {
                        solid[k] = h.solidTop();
                        fluid[k] = h.fluidTop();
                        flags[k] = 1;
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
                    float gx = (solid[j * n + Math.min(i + 1, n - 1)] - solid[j * n + Math.max(i - 1, 0)]) / (float) (2 * spacing);
                    float gz = (solid[Math.min(j + 1, n - 1) * n + i] - solid[Math.max(j - 1, 0) * n + i]) / (float) (2 * spacing);
                    FarSource.Column c = source.column(x, z, hs[k], gx, gz);
                    biome[k] = c.biome();
                    color[k] = FarColors.color(c.block(), c.biome(), x, c.top() - 1, z);
                    if (c.fluidTop() != FarSource.NONE) fcolor[k] = FarColors.color(c.fluid(), c.biome(), x, c.fluidTop() - 1, z);
                    columnsSampled.incrementAndGet();
                }
            }
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
        t.dirty = false;
        t.realChunks = realChunks;
        tileHeapBytes.addAndGet(heapOf(t));
        if (realChunks > 0) tilesFromReal.incrementAndGet();
        stage(t);
        meshNanos.addAndGet(System.nanoTime() - t1);
        tilesMade.incrementAndGet();
    }

    /** A tile's samples on the heap, estimated: four int arrays, the flags, the biome references (4 bytes each) and headers. */
    private static long heapOf(Tile t) {
        if (t.solidTop == null) return 0;
        long cells = (long) t.n * t.n;
        return cells * (4 * 4 + 1 + 4) + 6 * 16 + 64;
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
        int n = t.n, s = t.spacing, ox = t.tx * TILE, oz = t.tz * TILE;
        float[] q = new float[12];
        // the ground and the water
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - 1; i++) {
                int a = j * n + i, b = j * n + i + 1, c = (j + 1) * n + i + 1, d = (j + 1) * n + i;
                if ((t.flags[a] & t.flags[b] & t.flags[c] & t.flags[d] & 1) == 0) continue;
                float x0 = ox + i * s, x1 = x0 + s, z0 = oz + j * s, z1 = z0 + s;
                boolean water = t.fluidTop[a] != FarSource.NONE && t.fluidTop[b] != FarSource.NONE && t.fluidTop[c] != FarSource.NONE && t.fluidTop[d] != FarSource.NONE;
                if (water) {
                    // vanilla's up-face corner order: (x0, z0), (x0, z1), (x1, z1), (x1, z0)
                    set(q, x0, t.fluidTop[a], z0, x0, t.fluidTop[d], z1, x1, t.fluidTop[c], z1, x1, t.fluidTop[b], z0);
                    m.quad(q, t.fluidColor[a], t.fluidColor[d], t.fluidColor[c], t.fluidColor[b]);
                    continue;
                }
                set(q, x0, t.solidTop[a], z0, x0, t.solidTop[d], z1, x1, t.solidTop[c], z1, x1, t.solidTop[b], z0);
                m.quad(q, lit(t, i, j), lit(t, i, j + 1), lit(t, i + 1, j + 1), lit(t, i + 1, j));
            }
        }
        // skirts down from each edge, so tiles of other spacings beside it show no gaps
        for (int e = 0; e < 4; e++) {
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
                int ca = shade(surface(t, a), 0.7f), cb = shade(surface(t, b), 0.7f);
                m.quad(q, ca, ca, cb, cb);
            }
        }
        // trees on generated (not real) ground, near enough to see their shape
        if (trees != null && s <= 8) {
            for (int j = 0; j < n - 1; j++) {
                for (int i = 0; i < n - 1; i++) {
                    int a = j * n + i;
                    if (t.flags[a] != 1 || t.fluidTop[a] != FarSource.NONE || t.biome[a] == null) continue;
                    FarTrees.Info info = trees.of(t.biome[a]);
                    if (info.trees().isEmpty()) continue;
                    int x = ox + i * s, z = oz + j * s;
                    float expected = info.perChunk() * (s * s) / 256f;
                    long h = hash(x, z);
                    if ((h & 0xFFFF) / 65536f >= Math.min(1f, expected)) continue;
                    FarTrees.Tree tree = info.trees().get((int) ((h >>> 16) & 0x7FFFFFFF) % info.trees().size());
                    float cx = x + s / 2f + (((h >>> 40) & 255) / 255f - 0.5f) * (s - 2), cz = z + s / 2f + (((h >>> 48) & 255) / 255f - 0.5f) * (s - 2);
                    float ground = t.solidTop[a];
                    float crownTop = ground + tree.height() + 1, crownBottom = Math.max(ground + 1, crownTop - tree.crown() - 1);
                    float r = tree.radius() + 0.5f;
                    int leaves = FarColors.color(tree.leaves(), t.biome[a], x, (int) crownTop, z);
                    box(m, q, cx - r, crownBottom, cz - r, cx + r, crownTop, cz + r, leaves, true);
                    if (s == 4 && crownBottom > ground + 0.5f) {
                        int log = FarColors.color(tree.log(), t.biome[a], x, (int) ground, z);
                        box(m, q, cx - 0.5f, ground, cz - 0.5f, cx + 0.5f, crownBottom, cz + 0.5f, log, false);
                    }
                }
            }
        }
        if (m.quads == 0) {
            MemoryUtil.memFree(m.buf);
            if (t.staged) FarLayer.remove(key(t.tx, t.tz), id);
            t.staged = false;
            return;
        }
        m.buf.flip();
        quadsMade.addAndGet(m.quads);
        FarLayer.stage(key(t.tx, t.tz), m.buf, m.quads, id, (int) Math.floor(m.minX), (int) Math.floor(m.minZ), (int) Math.ceil(m.maxX),
            (int) Math.ceil(m.maxZ), (int) Math.floor(m.minY), (int) Math.ceil(m.maxY));
        t.staged = true;
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
