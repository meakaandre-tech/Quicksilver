package com.meakaandre.quicksilver.far;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeResolver;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.PalettedContainerFactory;
import net.minecraft.world.level.chunk.ProtoChunk;
import net.minecraft.world.level.chunk.UpgradeData;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.densityfunction.DensitySamplerSet;
import net.minecraft.world.level.levelgen.densityfunction.SamplerContext;
import net.minecraft.world.level.levelgen.material.MaterialSystem;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;

/**
 * Package 12: one dimension's own generator, sampled column by column (design doc, "Far terrain"): the noise router's
 * column ({@link ChunkGenerator#getBaseHeight}, {@link ChunkGenerator#getBaseColumn}: vanilla's own column sampling,
 * which structures use, so no chunk is made), the biome source at the column's top, and the material (surface) rules for
 * the top block ({@link MaterialSystem#topMaterial}, vanilla's single-position query that carvers use). Only for
 * noise-based generators; anything else has no source and far terrain is built from real chunks only.
 *
 * <p>One sampling thread owns an instance (its density samplers, biome resolver and scratch chunk are not shared); the
 * generator and random state may be the server's own (single player), which vanilla's world-gen threads share too.
 */
final class FarSource {
    /** One sampled column: the top surface's height (the y above the top block), the fluid's top (or {@link #NONE}), the top block, the biome there. */
    record Column(int top, int fluidTop, BlockState block, BlockState fluid, Holder<Biome> biome) {
    }

    /**
     * Package 12c: the dimension's sea level (the generator's own), and whether its cold places get snow and ice the way
     * vanilla's freeze step puts them (no ceiling, a sky): vanilla puts snow on the ground and ice on still water after
     * the surface rules, wherever the biome is cold enough at that height; the sampled column does the same.
     */
    final int seaLevel;
    private final boolean freezes;
    private static final BlockState SNOW = Blocks.SNOW_BLOCK.defaultBlockState(), ICE = Blocks.ICE.defaultBlockState();
    /** Package 12c: the biomes of this generator's world (the disk cache names them). */
    private final net.minecraft.core.HolderGetter<Biome> biomeLookup;

    /** Package 12c: the generator's default block (stone in the overworld): far cliffs are drawn in it. */
    BlockState rock() {
        return defaultBlock;
    }

    net.minecraft.core.HolderGetter<Biome> biomeLookup() {
        return biomeLookup;
    }

    static final int NONE = Integer.MIN_VALUE;

    final ChunkGenerator generator;
    final NoiseBasedChunkGenerator noise;
    final RandomState random;
    final LevelHeightAccessor height;
    final boolean ceiling;
    final int minY, maxY;
    /** Under a ceiling: the scan starts here (the dimension's logical height: the nether's roof is below it, air above). */
    final int scanTop;
    private final BiomeResolver biomes;
    private final MaterialSystem material;
    private final MaterialRule rule;
    private final WorldGenerationContext context;
    private final DensitySamplerSet samplers;
    private final BlockState defaultBlock, defaultFluid;
    private final Scratch scratch;

    /**
     * The scratch chunk {@link MaterialSystem#topMaterial} reads the surface's slope from (two heightmap reads either
     * side of the column): it answers from the sampled heights around the column, as a plane, never from blocks. It is
     * never filled, generated or added to any world.
     */
    private static final class Scratch extends ProtoChunk {
        int originX, originZ, h0, x0, z0;
        float gx, gz;

        Scratch(LevelHeightAccessor height, PalettedContainerFactory containers) {
            super(ChunkPos.ZERO, UpgradeData.EMPTY, height, containers, null);
        }

        @Override
        public int getHeight(Heightmap.Types type, int x, int z) {
            return Math.round(h0 + gx * (x - x0) + gz * (z - z0));
        }
    }

    /** The source for a noise-based generator, or null for any other. */
    static FarSource of(ChunkGenerator generator, RandomState random, LevelHeightAccessor height, boolean ceiling, int logicalHeight, RegistryAccess access, long seed) {
        // NoiseBasedChunkGenerator is final: no mod's generator can pass as it
        if (!(generator instanceof NoiseBasedChunkGenerator n)) return null;
        return new FarSource(n, random, height, ceiling, logicalHeight, access, seed);
    }

    /** Package 12c: the world's big structures from the seed (villages, mansions, ocean monuments), or null under a ceiling. */
    final FarStructures structures;

    private FarSource(NoiseBasedChunkGenerator generator, RandomState random, LevelHeightAccessor height, boolean ceiling, int logicalHeight, RegistryAccess access,
                      long seed) {
        this.generator = generator;
        this.noise = generator;
        this.random = random;
        this.height = height;
        this.ceiling = ceiling;
        this.minY = height.getMinY();
        this.maxY = height.getMinY() + height.getHeight();
        this.scanTop = Math.min(maxY, height.getMinY() + logicalHeight) - 1;
        NoiseGeneratorSettings s = generator.generatorSettings().value();
        this.defaultBlock = s.defaultBlock();
        this.defaultFluid = s.defaultFluid();
        this.biomes = generator.getBiomeSource().createUncachedResolver(random);
        this.material = random.surfaceSystem();
        this.rule = s.materialRule().value();
        this.context = new WorldGenerationContext(generator, height);
        this.samplers = random.samplersWithContext(SamplerContext.EMPTY_UNCACHED);
        this.scratch = new Scratch(height, PalettedContainerFactory.create(access));
        this.seaLevel = generator.getSeaLevel();
        this.biomeLookup = access.lookupOrThrow(net.minecraft.core.registries.Registries.BIOME);
        this.structures = ceiling ? null : new FarStructures(access, seed, this);
        this.freezes = !ceiling;
    }

    Holder<Biome> biome(int x, int y, int z) {
        return biomes.getNoiseBiome(x >> 2, y >> 2, z >> 2);
    }

    /** Package 12c: whether vanilla's freeze step would put snow at (x, y, z) in that biome (tree crowns in cold places). */
    boolean snowAt(Holder<Biome> b, int x, int y, int z) {
        if (!freezes || com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_LOOK.on()) return false;
        try {
            return b.value().coldEnoughToSnow(new BlockPos(x, y, z), seaLevel);
        } catch (RuntimeException e) {
            return false;
        }
    }

    /** A column's heights: the solid top (the y above the top solid block), the fluid's top or {@link #NONE}, the fluid. */
    record Heights(int solidTop, int fluidTop, BlockState fluid) {
    }

    /** The column's heights at (x, z), or null where it holds nothing (the end's void). */
    Heights heights(int x, int z) {
        if (ceiling) {
            // under a ceiling (the nether): the first floor below the roof, through the column's blocks
            NoiseColumn col = generator.getBaseColumn(x, z, height, random);
            int y = scanTop;
            while (y > minY && col.getBlock(y).isAir()) y--;       // any air above the roof
            while (y > minY && !col.getBlock(y).isAir()) y--;      // out of the roof
            while (y > minY && col.getBlock(y).isAir()) y--;       // down through the open space
            if (y <= minY) return null;
            BlockState at = col.getBlock(y);
            if (!at.getFluidState().isEmpty()) {
                int fluidTop = y + 1;
                while (y > minY && !col.getBlock(y).getFluidState().isEmpty()) y--;
                return new Heights(y + 1, fluidTop, at);
            }
            return new Heights(y + 1, NONE, Blocks.AIR.defaultBlockState());
        }
        int solidTop = generator.getBaseHeight(x, z, Heightmap.Types.OCEAN_FLOOR_WG, height, random);
        int surface = generator.getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, height, random);
        if (solidTop <= minY && surface <= minY) return null;
        return surface > solidTop ? new Heights(solidTop, surface, defaultFluid) : new Heights(solidTop, NONE, Blocks.AIR.defaultBlockState());
    }

    /**
     * The column at (x, z) with its heights. {@code gx}, {@code gz}: the surface's slope there in blocks per block
     * (from the neighbouring samples), which the material rules' steepness test reads.
     */
    Column column(int x, int z, Heights h, float gx, float gz) {
        int solidTop = h.solidTop();
        int y = solidTop - 1;
        Holder<Biome> b = biome(x, solidTop, z);
        scratch.h0 = solidTop;
        scratch.x0 = x & 15;
        scratch.z0 = z & 15;
        scratch.gx = gx;
        scratch.gz = gz;
        BlockState top = defaultBlock;
        try {
            Optional<BlockState> m = material.topMaterial(rule, random, context, p -> biome(p.getX(), p.getY(), p.getZ()), scratch, samplers,
                new BlockPos(x, y, z), h.fluidTop() != NONE);
            if (m.isPresent()) top = m.get();
        } catch (RuntimeException e) {
            // a rule this query can't run (a mod's) leaves the generator's default block
            top = defaultBlock;
        }
        if (top.isAir()) top = defaultBlock;
        BlockState fluid = h.fluid();
        // package 12c: vanilla's freeze step: ice on still water and snow on the ground where the biome is cold enough
        // there (its temperature falls with height, so high mountains get snow caps in temperate biomes too)
        if (freezes && !com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_LOOK.on()) {
            try {
                if (h.fluidTop() != NONE) {
                    if (fluid.getFluidState().is(net.minecraft.tags.FluidTags.WATER) && b.value().coldEnoughToSnow(new BlockPos(x, h.fluidTop() - 1, z), seaLevel)) fluid = ICE;
                } else if (top.getFluidState().isEmpty() && b.value().coldEnoughToSnow(new BlockPos(x, solidTop, z), seaLevel)) {
                    top = SNOW;
                }
            } catch (RuntimeException e) {
                // a biome that can't answer keeps its blocks
            }
        }
        return new Column(solidTop, h.fluidTop(), top, fluid, b);
    }
}
