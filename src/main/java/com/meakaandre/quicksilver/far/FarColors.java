package com.meakaandre.quicksilver.far;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;

/**
 * Package 12: far terrain's colours (design doc: "colour it from that block's own texture plus the biome's grass,
 * foliage and water tint"). A block's colour is the average of the texture on its model's top face (the particle
 * texture if it has none), read from the resource pack's own image (as the entity atlas reads textures), once per block
 * state; a tinted face takes the game's own tint for that block in that biome (vanilla's tint sources, asked through a
 * getter that answers the biome's colours). Any thread; the cache empties on a resource reload.
 */
final class FarColors {
    private record Base(int rgb, int tintIndex) {
    }

    private static final ConcurrentHashMap<BlockState, Base> BASE = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Identifier, Integer> TEXTURES = new ConcurrentHashMap<>();
    /** Grey for a block whose texture can't be read. */
    private static final int FALLBACK = 0x808080;

    private FarColors() {
    }

    static void clear() {
        BASE.clear();
        TEXTURES.clear();
    }

    /** The block's colour (0xRRGGBB) at (x, z) in that biome, tint included. */
    static int color(BlockState state, Holder<Biome> biome, int x, int y, int z) {
        Base b = BASE.computeIfAbsent(state, FarColors::base);
        // package 12c: water takes its biome's water colour (12b drew it untinted, a pale grey: water has no block tint
        // source; the game tints it through its fluid model)
        if (state.getBlock() instanceof net.minecraft.world.level.block.LiquidBlock && state.getFluidState().is(net.minecraft.tags.FluidTags.WATER)
            && !com.meakaandre.quicksilver.speed.Speed.CI_FAR_OLD_LOOK.on()) {
            int w = 0x3F76E4;
            try {
                if (biome != null) w = biome.value().getWaterColor() & 0xFFFFFF;
            } catch (Throwable t) {
                // the default ocean's colour
            }
            return multiply(b.rgb, w);
        }
        if (b.tintIndex < 0) return b.rgb;
        int tint = tint(state, b.tintIndex, biome, x, y, z);
        if (tint == -1) return b.rgb;
        return multiply(b.rgb, tint);
    }

    static int multiply(int a, int b) {
        int r = ((a >> 16) & 255) * ((b >> 16) & 255) / 255;
        int g = ((a >> 8) & 255) * ((b >> 8) & 255) / 255;
        int bl = (a & 255) * (b & 255) / 255;
        return r << 16 | g << 8 | bl;
    }

    private static Base base(BlockState state) {
        try {
            BlockStateModel model = Minecraft.getInstance().getModelManager().getBlockStateModelSet().get(state);
            List<BlockStateModelPart> parts = new ArrayList<>();
            model.collectParts(RandomSource.create(42L), parts);
            BakedQuad best = null;
            for (BlockStateModelPart p : parts) {
                for (BakedQuad q : p.getQuads(Direction.UP)) {
                    best = q;
                    break;
                }
                if (best != null) break;
                for (BakedQuad q : p.getQuads(null)) {
                    if (q.direction() == Direction.UP) {
                        best = q;
                        break;
                    }
                }
                if (best != null) break;
            }
            TextureAtlasSprite sprite = best != null ? best.materialInfo().sprite() : model.particleMaterial().sprite();
            int rgb = average(sprite);
            int tint = best != null && best.materialInfo().isTinted() ? best.materialInfo().tintIndex() : -1;
            // a block drawn tinted but read from its particle (no top face): tinted as its first tint index
            if (best == null && !Minecraft.getInstance().getBlockColors().getTintSources(state).isEmpty()) tint = 0;
            return new Base(rgb, tint);
        } catch (Throwable t) {
            return new Base(FALLBACK, -1);
        }
    }

    /** A sprite's average colour over its opaque texels (its whole image: every frame of an animated one). */
    private static int average(TextureAtlasSprite sprite) {
        Identifier name = sprite.contents().name();
        return TEXTURES.computeIfAbsent(name, n -> {
            Identifier file = Identifier.fromNamespaceAndPath(n.getNamespace(), "textures/" + n.getPath() + ".png");
            try (TextureContents c = TextureContents.load(Minecraft.getInstance().getResourceManager(), file)) {
                NativeImage img = c.image();
                long r = 0, g = 0, b = 0, count = 0;
                int[] px = img.getPixelsABGR();
                for (int i = 0; i < px.length; i++) {
                    {
                        int abgr = px[i];
                        int a = (abgr >>> 24) & 255;
                        if (a < 128) continue;
                        r += abgr & 255;
                        g += (abgr >> 8) & 255;
                        b += (abgr >> 16) & 255;
                        count++;
                    }
                }
                if (count == 0) return FALLBACK;
                return (int) (r / count) << 16 | (int) (g / count) << 8 | (int) (b / count);
            } catch (Throwable e) {
                return FALLBACK;
            }
        });
    }

    private static int tint(BlockState state, int index, Holder<Biome> biome, int x, int y, int z) {
        try {
            BlockTintSource src = Minecraft.getInstance().getBlockColors().getTintSource(state, index);
            if (src == null) return -1;
            return src.colorInWorld(state, new Tints(biome.value()), new BlockPos(x, y, z)) & 0xFFFFFF;
        } catch (Throwable t) {
            return -1;
        }
    }

    /** Answers a tint source's biome colour question for one biome; nothing else in it is ever read. */
    private record Tints(Biome biome) implements BlockAndTintGetter {
        @Override
        public int getBlockTint(BlockPos pos, ColorResolver resolver) {
            return resolver.getColor(biome, pos.getX(), pos.getZ());
        }

        @Override
        public CardinalLighting cardinalLighting() {
            return CardinalLighting.DEFAULT;
        }

        @Override
        public LevelLightEngine getLightEngine() {
            return BlockAndTintGetter.EMPTY.getLightEngine();
        }

        @Override
        public BlockEntity getBlockEntity(BlockPos pos) {
            return null;
        }

        @Override
        public BlockState getBlockState(BlockPos pos) {
            return BlockAndTintGetter.EMPTY.getBlockState(pos);
        }

        @Override
        public FluidState getFluidState(BlockPos pos) {
            return BlockAndTintGetter.EMPTY.getFluidState(pos);
        }

        @Override
        public int getHeight() {
            return BlockAndTintGetter.EMPTY.getHeight();
        }

        @Override
        public int getMinY() {
            return BlockAndTintGetter.EMPTY.getMinY();
        }
    }
}
