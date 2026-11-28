package com.meakaandre.quicksilver.far;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Package 12c: far terrain's disk cache, one per dimension of a world (single player: in the world's own folder,
 * {@code quicksilver/far-cache/<dimension>}; a server: {@code <game dir>/quicksilver/far-cache/<address>/<dimension>}),
 * so a second visit shows far terrain at once. Two kinds of data, each in region files of 1024 x 1024 blocks (8 x 8
 * tiles, 64 x 64 chunks), gzipped:
 * <ul>
 * <li><b>Sampled tiles</b> ({@code g.<rx>.<rz>.bin}): each tile's generator columns at the finest spacing sampled so far
 * (heights, the top block, the fluid, the biome), valid only for the identity they were sampled under ({@code
 * identity-gen.txt}: the seed, the dimensions' generators and the data packs in single player, or the server's whole
 * handshake; and the mod's version). Any other identity empties them.</li>
 * <li><b>Seen chunks</b> ({@code s.<rx>.<rz>.bin}): the real chunks the client has had (their columns at 4-block steps),
 * kept for servers that don't share their seed (and in single player alongside the samples). Local only: nothing is
 * sent to the server. Valid across seeds (they are what the client saw), emptied when the mod's version changes ({@code
 * identity-seen.txt}).</li>
 * </ul>
 * Colours are never stored (a resource pack change would make them wrong): blocks and biomes are, and the colours are
 * worked out again on loading. The cache's folder is capped ({@link #capBytes}): past it the least recently written
 * region files go. Sampling thread only, except {@link #of}.
 */
final class FarCache {
    /** The file format (part of both identities). */
    static final int FORMAT = 1;
    static final int REGION_TILES = 8;
    /** The most a world's (or server's) cache folder holds, all dimensions together. */
    static final long DEFAULT_CAP = 256L << 20;

    /** A tile's generator columns as cached: {@code known[k]} bit 1 sampled, bit 2 something there (not the End's void). */
    record GenTile(int spacing, int n, int[] solid, int[] fluid, BlockState[] block, BlockState[] fluidBlock, Holder<Biome>[] biome, byte[] known) {
    }

    /** A seen chunk's 16 columns (4-block steps) as cached; biome holders from the client's registry. */
    record SeenChunk(int cx, int cz, int[] solid, int[] fluid, BlockState[] block, BlockState[] fluidBlock, Holder<Biome>[] biome) {
    }

    private static final class Region {
        final Long2ObjectOpenHashMap<GenTile> gen = new Long2ObjectOpenHashMap<>();
        final Long2ObjectOpenHashMap<SeenChunk> seen = new Long2ObjectOpenHashMap<>();
        boolean genLoaded, seenLoaded, genDirty, seenDirty;
        /** Whether its seen chunks went to the session's real chunks (loading them for a write doesn't hand them over). */
        boolean seenHanded;
    }

    private final Path dir, root;
    private final boolean gen, seen;
    private final HolderGetter<Biome> genBiomes, seenBiomes;
    private final long capBytes;
    private final Long2ObjectOpenHashMap<Region> regions = new Long2ObjectOpenHashMap<>();
    private long lastFlush = System.nanoTime();
    // bench numbers
    long tilesRead, tilesWritten, chunksRead, chunksWritten, bytesWritten, filesRemoved;
    volatile String problem;

    private FarCache(Path root, Path dir, boolean gen, boolean seen, HolderGetter<Biome> genBiomes, HolderGetter<Biome> seenBiomes, long capBytes) {
        this.root = root;
        this.dir = dir;
        this.gen = gen;
        this.seen = seen;
        this.genBiomes = genBiomes;
        this.seenBiomes = seenBiomes;
        this.capBytes = capBytes;
    }

    /**
     * The cache for a dimension, or null if neither kind is wanted or the folder can't be used. {@code genIdentity}: null
     * for no sampled tiles (a session from real chunks only). Checks both identities (a stale kind is emptied). Any thread.
     */
    static FarCache of(Path root, String dimension, String genIdentity, boolean seenWanted, HolderGetter<Biome> genBiomes, HolderGetter<Biome> seenBiomes) {
        boolean genWanted = genIdentity != null && genBiomes != null;
        if (root == null || (!genWanted && !(seenWanted && seenBiomes != null))) return null;
        try {
            Path dir = root.resolve(safe(dimension));
            Files.createDirectories(dir);
            String version = FarNet.modVersion() + "/" + FORMAT;
            // a write a killed game left half done
            try (Stream<Path> files = Files.list(dir)) {
                for (Path p : (Iterable<Path>) files::iterator) if (p.getFileName().toString().endsWith(".tmp")) Files.deleteIfExists(p);
            }
            if (genWanted) check(dir, "identity-gen.txt", version + "\n" + genIdentity, "g.");
            if (seenWanted) check(dir, "identity-seen.txt", version, "s.");
            return new FarCache(root, dir, genWanted, seenWanted && seenBiomes != null, genBiomes, seenBiomes, DEFAULT_CAP);
        } catch (Throwable t) {
            FarNet.LOG.warn("Quicksilver far terrain: its disk cache can't be used here ({}); far terrain samples as usual", t.toString());
            return null;
        }
    }

    /** An identity file: if it says something else, that kind's region files go and it is written anew. */
    private static void check(Path dir, String file, String identity, String prefix) throws IOException {
        Path f = dir.resolve(file);
        String was = Files.exists(f) ? Files.readString(f, StandardCharsets.UTF_8) : null;
        if (identity.equals(was)) return;
        int removed = 0;
        try (Stream<Path> files = Files.list(dir)) {
            for (Path p : (Iterable<Path>) files::iterator) {
                String n = p.getFileName().toString();
                if (n.startsWith(prefix) && n.endsWith(".bin")) {
                    Files.deleteIfExists(p);
                    removed++;
                }
            }
        }
        if (was != null) FarNet.LOG.info("Quicksilver far terrain: its disk cache in {} was for another {} ({} files removed)", dir,
            prefix.equals("g.") ? "world generator or version" : "version", removed);
        Files.writeString(f, identity, StandardCharsets.UTF_8);
    }

    static String safe(String s) {
        StringBuilder b = new StringBuilder();
        for (char c : s.toCharArray()) b.append(Character.isLetterOrDigit(c) || c == '-' || c == '.' ? c : '_');
        String out = b.toString();
        return out.length() > 80 ? out.substring(0, 80) : out;
    }

    private static long regionKey(int rx, int rz) {
        return (long) rx << 32 | (rz & 0xFFFFFFFFL);
    }

    private Region region(int rx, int rz) {
        return regions.computeIfAbsent(regionKey(rx, rz), k -> new Region());
    }

    // ---- sampled tiles

    /** The cached generator columns of tile (tx, tz), or null. */
    GenTile genTile(int tx, int tz) {
        if (!gen) return null;
        int rx = Math.floorDiv(tx, REGION_TILES), rz = Math.floorDiv(tz, REGION_TILES);
        Region r = region(rx, rz);
        if (!r.genLoaded) {
            r.genLoaded = true;
            readGen(r, rx, rz);
        }
        GenTile g = r.gen.get(FarTiles.key(tx, tz));
        if (g != null) tilesRead++;
        return g;
    }

    /** A tile's generator columns, kept if finer than (or as fine as and more complete than) what the cache has. */
    void putGen(int tx, int tz, GenTile g) {
        if (!gen) return;
        int rx = Math.floorDiv(tx, REGION_TILES), rz = Math.floorDiv(tz, REGION_TILES);
        Region r = region(rx, rz);
        if (!r.genLoaded) {
            r.genLoaded = true;
            readGen(r, rx, rz);
        }
        long k = FarTiles.key(tx, tz);
        GenTile was = r.gen.get(k);
        if (was != null && was.spacing() < g.spacing()) return;
        if (was != null && was.spacing() == g.spacing() && count(was.known()) >= count(g.known())) return;
        r.gen.put(k, g);
        r.genDirty = true;
        tilesWritten++;
    }

    private static int count(byte[] known) {
        int c = 0;
        for (byte b : known) if ((b & 1) != 0) c++;
        return c;
    }

    // ---- seen chunks

    /** Every seen chunk cached in the region holding chunk (cx, cz) (loaded once). */
    List<SeenChunk> seenAround(int cx, int cz) {
        if (!seen) return List.of();
        int rx = Math.floorDiv(cx, REGION_TILES * 8), rz = Math.floorDiv(cz, REGION_TILES * 8);
        Region r = region(rx, rz);
        if (r.seenHanded) return List.of();
        r.seenHanded = true;
        // (review: a region a real chunk's write loaded first was marked read and its chunks never handed over)
        if (!r.seenLoaded) {
            r.seenLoaded = true;
            readSeen(r, rx, rz);
        }
        chunksRead += r.seen.size();
        return new ArrayList<>(r.seen.values());
    }

    /** Whether the seen-chunk region holding chunk (cx, cz) was read already. */
    boolean seenRead(int cx, int cz) {
        if (!seen) return true;
        Region r = regions.get(regionKey(Math.floorDiv(cx, REGION_TILES * 8), Math.floorDiv(cz, REGION_TILES * 8)));
        return r != null && r.seenHanded;
    }

    void putSeen(SeenChunk c) {
        if (!seen) return;
        int rx = Math.floorDiv(c.cx(), REGION_TILES * 8), rz = Math.floorDiv(c.cz(), REGION_TILES * 8);
        Region r = region(rx, rz);
        if (!r.seenLoaded) {
            r.seenLoaded = true;
            readSeen(r, rx, rz);
        }
        r.seen.put(FarTiles.chunkKey(c.cx(), c.cz()), c);
        r.seenDirty = true;
        chunksWritten++;
    }

    /** Regions wholly farther than {@code keep} blocks from (cx, cz) leave memory (written first if changed). */
    void evict(double cx, double cz, double keep) {
        int span = REGION_TILES * FarTiles.TILE;
        it.unimi.dsi.fastutil.longs.LongArrayList gone = new it.unimi.dsi.fastutil.longs.LongArrayList();
        for (Long2ObjectOpenHashMap.Entry<Region> e : regions.long2ObjectEntrySet()) {
            int rx = (int) (e.getLongKey() >> 32), rz = (int) e.getLongKey();
            double nx = Math.max(Math.max(rx * span - cx, cx - (rx + 1) * span), 0), nz = Math.max(Math.max(rz * span - cz, cz - (rz + 1) * span), 0);
            if (nx * nx + nz * nz <= keep * keep) continue;
            Region r = e.getValue();
            try {
                if (r.genDirty) writeGen(r, rx, rz);
                if (r.seenDirty) writeSeen(r, rx, rz);
            } catch (Throwable ex) {
                // kept in memory and written again at the next flush (review: it was dropped with its changes)
                problem = "writing " + dir + ": " + ex;
                continue;
            }
            gone.add(e.getLongKey());
        }
        for (long k : gone) regions.remove(k);
    }

    /** Regions held in memory (bench). */
    int regionsHeld() {
        return regions.size();
    }

    // ---- writing

    /** Writes what changed every 30 s (or at once with {@code now}); then keeps the folder under its cap. */
    void flush(boolean now) {
        long t = System.nanoTime();
        if (!now && t - lastFlush < 30_000_000_000L) return;
        lastFlush = t;
        boolean wrote = false;
        for (Long2ObjectOpenHashMap.Entry<Region> e : regions.long2ObjectEntrySet()) {
            Region r = e.getValue();
            int rx = (int) (e.getLongKey() >> 32), rz = (int) e.getLongKey();
            try {
                if (r.genDirty) {
                    writeGen(r, rx, rz);
                    r.genDirty = false;
                    wrote = true;
                }
                if (r.seenDirty) {
                    writeSeen(r, rx, rz);
                    r.seenDirty = false;
                    wrote = true;
                }
            } catch (Throwable ex) {
                problem = "writing " + dir + ": " + ex;
            }
        }
        if (wrote) cap();
    }

    /** The cache folder (every dimension of this world or server) back under its cap: oldest region files first. */
    private void cap() {
        capFolder(root, 2, capBytes);
        // a server's cache: every server's together under 1 GB too (review: the cap was per server only)
        if (serversRoot != null) capFolder(serversRoot, 3, 4 * DEFAULT_CAP);
    }

    /** Package 12c: the folder holding every server's cache (null in single player, whose cache is in the world's folder). */
    Path serversRoot;

    private void capFolder(Path root, int depth, long capBytes) {
        try {
            List<Path> files = new ArrayList<>();
            try (Stream<Path> all = Files.walk(root, depth)) {
                all.filter(p -> p.getFileName().toString().endsWith(".bin")).forEach(files::add);
            }
            long total = 0;
            Map<Path, Long> size = new HashMap<>(), time = new HashMap<>();
            for (Path p : files) {
                long s = Files.size(p);
                size.put(p, s);
                time.put(p, Files.getLastModifiedTime(p).toMillis());
                total += s;
            }
            if (total <= capBytes) return;
            files.sort((a, b) -> Long.compare(time.get(a), time.get(b)));
            for (Path p : files) {
                if (total <= capBytes * 9 / 10) break;
                Files.deleteIfExists(p);
                total -= size.get(p);
                filesRemoved++;
            }
        } catch (Throwable t) {
            problem = "capping " + root + ": " + t;
        }
    }

    /** The folder's size now (bench). */
    long folderBytes() {
        try (Stream<Path> all = Files.walk(root, 2)) {
            return all.filter(p -> p.getFileName().toString().endsWith(".bin")).mapToLong(p -> {
                try {
                    return Files.size(p);
                } catch (IOException e) {
                    return 0;
                }
            }).sum();
        } catch (Throwable t) {
            return -1;
        }
    }

    // ---- the files: a palette of blocks and of biomes, then the entries

    private Path file(String prefix, int rx, int rz) {
        return dir.resolve(prefix + rx + "." + rz + ".bin");
    }

    private static final class Palette {
        final Map<Object, Integer> ids = new HashMap<>();
        final List<String> names = new ArrayList<>();

        int id(String name) {
            return ids.computeIfAbsent(name, k -> {
                names.add(name);
                return names.size() - 1;
            });
        }
    }

    private static String blockName(BlockState s) {
        return s == null ? "" : BuiltInRegistries.BLOCK.getKey(s.getBlock()).toString();
    }

    private static BlockState block(String name) {
        if (name.isEmpty()) return null;
        Identifier id = Identifier.tryParse(name);
        if (id == null || !BuiltInRegistries.BLOCK.containsKey(id)) return Blocks.STONE.defaultBlockState();
        Block b = BuiltInRegistries.BLOCK.getValue(id);
        return b.defaultBlockState();
    }

    private static String biomeName(Holder<Biome> b) {
        return b == null ? "" : b.unwrapKey().map(k -> k.identifier().toString()).orElse("");
    }

    @SuppressWarnings("unchecked")
    private static Holder<Biome> biome(HolderGetter<Biome> lookup, String name) {
        if (name.isEmpty() || lookup == null) return null;
        Identifier id = Identifier.tryParse(name);
        if (id == null) return null;
        return lookup.get(ResourceKey.create(Registries.BIOME, id)).map(h -> (Holder<Biome>) h).orElse(null);
    }

    private void writeGen(Region r, int rx, int rz) throws IOException {
        Palette blocks = new Palette(), biomes = new Palette();
        // two passes: the palettes first (they lead the file)
        for (Long2ObjectOpenHashMap.Entry<GenTile> e : r.gen.long2ObjectEntrySet()) {
            GenTile g = e.getValue();
            for (int k = 0; k < g.n() * g.n(); k++) {
                blocks.id(blockName(g.block()[k]));
                blocks.id(blockName(g.fluidBlock()[k]));
                biomes.id(biomeName(g.biome()[k]));
            }
        }
        write(file("g.", rx, rz), out -> {
            out.writeInt(FORMAT);
            writePalette(out, blocks);
            writePalette(out, biomes);
            out.writeInt(r.gen.size());
            for (Long2ObjectOpenHashMap.Entry<GenTile> e : r.gen.long2ObjectEntrySet()) {
                GenTile g = e.getValue();
                out.writeLong(e.getLongKey());
                out.writeByte(g.spacing());
                out.writeShort(g.n());
                for (int k = 0; k < g.n() * g.n(); k++) {
                    out.writeByte(g.known()[k]);
                    if ((g.known()[k] & 2) == 0) continue;
                    out.writeShort(g.solid()[k]);
                    out.writeShort(g.fluid()[k] == FarSource.NONE ? Short.MIN_VALUE : g.fluid()[k]);
                    out.writeShort(blocks.id(blockName(g.block()[k])));
                    out.writeShort(blocks.id(blockName(g.fluidBlock()[k])));
                    out.writeShort(biomes.id(biomeName(g.biome()[k])));
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void readGen(Region r, int rx, int rz) {
        Path f = file("g.", rx, rz);
        if (!Files.exists(f)) return;
        try (DataInputStream in = open(f)) {
            if (in.readInt() != FORMAT) return;
            List<String> blockNames = readPalette(in), biomeNames = readPalette(in);
            BlockState[] blocks = new BlockState[blockNames.size()];
            for (int i = 0; i < blocks.length; i++) blocks[i] = block(blockNames.get(i));
            Holder<Biome>[] biomes = new Holder[biomeNames.size()];
            for (int i = 0; i < biomes.length; i++) biomes[i] = biome(genBiomes, biomeNames.get(i));
            int tiles = in.readInt();
            for (int t = 0; t < tiles; t++) {
                long key = in.readLong();
                int spacing = in.readUnsignedByte(), n = in.readUnsignedShort();
                int cells = n * n;
                int[] solid = new int[cells], fluid = new int[cells];
                BlockState[] block = new BlockState[cells], fblock = new BlockState[cells];
                Holder<Biome>[] biome = new Holder[cells];
                byte[] known = new byte[cells];
                for (int k = 0; k < cells; k++) {
                    known[k] = in.readByte();
                    if ((known[k] & 2) == 0) continue;
                    solid[k] = in.readShort();
                    short fl = in.readShort();
                    fluid[k] = fl == Short.MIN_VALUE ? FarSource.NONE : fl;
                    block[k] = blocks[in.readUnsignedShort()];
                    fblock[k] = blocks[in.readUnsignedShort()];
                    biome[k] = biomes[in.readUnsignedShort()];
                    // a biome this world no longer has: the column is sampled again
                    if (biome[k] == null || block[k] == null) known[k] = 0;
                }
                r.gen.put(key, new GenTile(spacing, n, solid, fluid, block, fblock, biome, known));
            }
        } catch (Throwable t) {
            // a damaged file: sampled again (and written anew)
            r.gen.clear();
            problem = "reading " + f.getFileName() + ": " + t;
        }
    }

    private void writeSeen(Region r, int rx, int rz) throws IOException {
        Palette blocks = new Palette(), biomes = new Palette();
        for (SeenChunk c : r.seen.values()) {
            for (int k = 0; k < 16; k++) {
                blocks.id(blockName(c.block()[k]));
                blocks.id(blockName(c.fluidBlock()[k]));
                biomes.id(biomeName(c.biome()[k]));
            }
        }
        write(file("s.", rx, rz), out -> {
            out.writeInt(FORMAT);
            writePalette(out, blocks);
            writePalette(out, biomes);
            out.writeInt(r.seen.size());
            for (SeenChunk c : r.seen.values()) {
                out.writeInt(c.cx());
                out.writeInt(c.cz());
                for (int k = 0; k < 16; k++) {
                    out.writeInt(c.solid()[k]);
                    out.writeInt(c.fluid()[k]);
                    out.writeShort(blocks.id(blockName(c.block()[k])));
                    out.writeShort(blocks.id(blockName(c.fluidBlock()[k])));
                    out.writeShort(biomes.id(biomeName(c.biome()[k])));
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void readSeen(Region r, int rx, int rz) {
        Path f = file("s.", rx, rz);
        if (!Files.exists(f)) return;
        try (DataInputStream in = open(f)) {
            if (in.readInt() != FORMAT) return;
            List<String> blockNames = readPalette(in), biomeNames = readPalette(in);
            BlockState[] blocks = new BlockState[blockNames.size()];
            for (int i = 0; i < blocks.length; i++) blocks[i] = block(blockNames.get(i));
            Holder<Biome>[] biomes = new Holder[biomeNames.size()];
            for (int i = 0; i < biomes.length; i++) biomes[i] = biome(seenBiomes, biomeNames.get(i));
            int count = in.readInt();
            for (int c = 0; c < count; c++) {
                int cx = in.readInt(), cz = in.readInt();
                int[] solid = new int[16], fluid = new int[16];
                BlockState[] block = new BlockState[16], fblock = new BlockState[16];
                Holder<Biome>[] biome = new Holder[16];
                for (int k = 0; k < 16; k++) {
                    solid[k] = in.readInt();
                    fluid[k] = in.readInt();
                    block[k] = blocks[in.readUnsignedShort()];
                    fblock[k] = blocks[in.readUnsignedShort()];
                    biome[k] = biomes[in.readUnsignedShort()];
                }
                r.seen.put(FarTiles.chunkKey(cx, cz), new SeenChunk(cx, cz, solid, fluid, block, fblock, biome));
            }
        } catch (Throwable t) {
            r.seen.clear();
            problem = "reading " + f.getFileName() + ": " + t;
        }
    }

    private static void writePalette(DataOutputStream out, Palette p) throws IOException {
        out.writeInt(p.names.size());
        for (String s : p.names) out.writeUTF(s);
    }

    private static List<String> readPalette(DataInputStream in) throws IOException {
        int n = in.readInt();
        if (n < 0 || n > 65535) throw new IOException("palette of " + n);
        List<String> out = new ArrayList<>(n);
        for (int i = 0; i < n; i++) out.add(in.readUTF());
        return out;
    }

    private interface Writer {
        void write(DataOutputStream out) throws IOException;
    }

    /** One lock per cache folder: a session's last write and the next session's never interleave (review). */
    private static final java.util.concurrent.ConcurrentHashMap<Path, Object> LOCKS = new java.util.concurrent.ConcurrentHashMap<>();

    /**
     * Written to a temporary file of its own first, then moved over the old one (a crash mid-write leaves the old file),
     * under the folder's lock; once more if an interrupt closed the file (a session stopping while it writes).
     */
    private void write(Path f, Writer w) throws IOException {
        synchronized (LOCKS.computeIfAbsent(dir.toAbsolutePath().normalize(), k -> new Object())) {
            try {
                writeOnce(f, w);
            } catch (java.nio.channels.ClosedByInterruptException e) {
                Thread.interrupted();
                writeOnce(f, w);
            }
        }
    }

    private void writeOnce(Path f, Writer w) throws IOException {
        Path tmp = f.resolveSibling(f.getFileName() + "." + Thread.currentThread().threadId() + "-" + System.nanoTime() + ".tmp");
        try (OutputStream os = Files.newOutputStream(tmp);
             DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(os, 65536), 65536))) {
            w.write(out);
        }
        bytesWritten += Files.size(tmp);
        try {
            Files.move(tmp, f, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (java.nio.file.AtomicMoveNotSupportedException e) {
            Files.move(tmp, f, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static DataInputStream open(Path f) throws IOException {
        InputStream is = Files.newInputStream(f);
        return new DataInputStream(new BufferedInputStream(new GZIPInputStream(is, 65536), 65536));
    }

    String describe() {
        return "disk cache " + dir + ": tiles read " + tilesRead + ", written " + tilesWritten + "; seen chunks read " + chunksRead + ", written "
            + chunksWritten + "; " + bytesWritten / 1024 + " KB written, " + filesRemoved + " files removed for the cap" + (problem != null ? "; " + problem : "");
    }
}
