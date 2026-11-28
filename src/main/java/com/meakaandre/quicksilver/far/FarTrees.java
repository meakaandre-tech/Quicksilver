package com.meakaandre.quicksilver.far;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;

/**
 * Package 12: far terrain's trees (design doc: "read each biome's placed features; a biome with trees gets simple tree
 * shapes coloured by that tree's own log and leaf blocks, at that biome's density"). For each biome, once: every placed
 * feature that is a tree or chooses among trees (random selectors, read through {@link Feature#getSubFeatures}), how
 * many it places per chunk on average (its count placements and rarity filters, averaged over draws), and each tree's
 * log, leaves, height and crown radius (its own providers and placers). Sampling thread only.
 */
final class FarTrees {
    /** One kind of tree; package 12c: its shape ({@link #BOX}...), from its own foliage and trunk placers and its log. */
    record Tree(BlockState log, BlockState leaves, int height, int radius, int crown, int shape) {
    }

    /** Package 12c: far tree shapes. A box (unknown kinds), a spruce's cone, an oak's round blob, a birch's thin blob, a jungle's tall one, an acacia's flat crown, a dark oak's (and cherry's) wide blob. */
    static final int BOX = 0, CONE = 1, BLOB = 2, THIN = 3, TALL = 4, FLAT = 5, WIDE = 6;

    /** A biome's trees: the kinds (equal shares) and how many a chunk holds on average. */
    record Info(List<Tree> trees, float perChunk) {
        static final Info NONE = new Info(List.of(), 0);
    }

    private final ChunkGenerator generator;
    private final Map<Holder<Biome>, Info> cache = new IdentityHashMap<>();

    FarTrees(ChunkGenerator generator) {
        this.generator = generator;
    }

    Info of(Holder<Biome> biome) {
        return cache.computeIfAbsent(biome, this::read);
    }

    private Info read(Holder<Biome> biome) {
        try {
            List<Tree> trees = new ArrayList<>();
            float perChunk = 0;
            RandomSource r = RandomSource.create(1234L);
            for (HolderSet<PlacedFeature> step : generator.getBiomeGenerationSettings(biome).features()) {
                for (Holder<PlacedFeature> pf : step) {
                    List<Tree> found = new ArrayList<>();
                    collect(pf.value().feature(), found, java.util.Collections.newSetFromMap(new IdentityHashMap<>()), r, 0);
                    if (found.isEmpty()) continue;
                    float count = count(pf.value().placement(), r);
                    if (count <= 0) continue;
                    perChunk += count;
                    trees.addAll(found);
                }
            }
            if (trees.isEmpty() || perChunk <= 0) return Info.NONE;
            return new Info(List.copyOf(trees), Math.min(perChunk, 64));
        } catch (Throwable t) {
            return Info.NONE;
        }
    }

    private static void collect(Holder<Feature> f, List<Tree> out, Set<Object> seen, RandomSource r, int depth) {
        if (depth > 6 || !seen.add(f)) return;
        Feature v = f.value();
        if (v instanceof TreeFeature t) {
            out.add(tree(t, r));
            return;
        }
        v.getSubFeatures().forEach(s -> collect(s, out, seen, r, depth + 1));
    }

    private static Tree tree(TreeFeature t, RandomSource r) {
        BlockState log = state(t.trunkProvider().value(), r, Blocks.OAK_LOG.defaultBlockState());
        BlockState leaves = state(t.foliageProvider().value(), r, Blocks.OAK_LEAVES.defaultBlockState());
        int height = 6, radius = 2, crown = 3;
        try {
            int sum = 0;
            for (int i = 0; i < 8; i++) sum += t.trunkPlacer().getTreeHeight(r);
            height = Math.max(1, Math.round(sum / 8f));
            int rs = 0, cs = 0;
            for (int i = 0; i < 8; i++) {
                rs += t.foliagePlacer().foliageRadius(r, height);
                cs += t.foliagePlacer().foliageHeight(r, height, t);
            }
            radius = Math.max(1, Math.min(6, Math.round(rs / 8f)));
            crown = Math.max(1, Math.min(12, Math.round(cs / 8f)));
        } catch (Throwable e) {
            // the defaults: a small oak's shape
        }
        return new Tree(log, leaves, Math.min(height, 32), radius, crown, shape(t, log));
    }

    /** Package 12c: the shape a tree reads as from afar, by its placers' kinds (the game's own classes) and its log. */
    private static int shape(TreeFeature t, BlockState log) {
        try {
            String foliage = t.foliagePlacer().getClass().getSimpleName(), trunk = t.trunkPlacer().getClass().getSimpleName();
            String wood = net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(log.getBlock()).getPath();
            if (foliage.contains("Spruce") || foliage.contains("Pine")) return CONE;
            if (foliage.contains("Acacia") || trunk.contains("Forking")) return FLAT;
            if (foliage.contains("Jungle") || trunk.contains("Jungle")) return TALL;
            if (foliage.contains("DarkOak") || trunk.contains("DarkOak") || foliage.contains("Cherry")) return WIDE;
            if (wood.contains("birch")) return THIN;
            if (foliage.contains("Blob") || foliage.contains("Fancy") || foliage.contains("Bush")) return BLOB;
        } catch (Throwable e) {
            // a mod's tree: a box
        }
        return BOX;
    }

    private static BlockState state(BlockStateProvider p, RandomSource r, BlockState fallback) {
        try {
            BlockState s = p.getState(null, r, BlockPos.ZERO);
            return s == null || s.isAir() ? fallback : s;
        } catch (Throwable e) {
            return fallback;
        }
    }

    /** How many the placement puts in a chunk on average: its repeating counts multiplied, times its rarity filters. */
    private static float count(List<PlacementModifier> placement, RandomSource r) {
        float n = 1;
        for (PlacementModifier m : placement) {
            if (m instanceof RepeatingPlacement rp) {
                float sum = 0;
                try {
                    for (int i = 0; i < 32; i++) sum += rp.count(r, BlockPos.ZERO);
                } catch (Throwable e) {
                    sum = 32;
                }
                n *= sum / 32f;
            } else if (m instanceof RarityFilter rf && rf.chance() > 0) {
                n /= rf.chance();
            }
        }
        return n;
    }
}
