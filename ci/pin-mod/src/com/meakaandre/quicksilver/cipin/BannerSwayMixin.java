package com.meakaandre.quicksilver.cipin;

import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.blockentity.state.BannerRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.world.level.block.entity.BannerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * CI only (package 8). A banner's flag sways with the world's game time, which keeps running while the time of day is
 * pinned; the moment a screenshot is taken decides where the flag is (core/occlusion_move.x2309 shows the occlusion
 * scene's banner edge-on through its window: 0 to 330 strict pixels between Quicksilver's run and vanilla's in five
 * runs, whose game times differ by the benches Quicksilver runs before it). The sway is held at its resting phase in
 * every CI client run, vanilla and Quicksilver alike.
 *
 * <p>Package 6: in the core block entities scene's area the banners sway instead, so the scene checks banners away from
 * rest: each at a phase fixed by its position (different per banner, the same in every run) for the screenshots, and
 * running with the game time while the marker block under the floor is a redstone block (set by the scene's bench step).
 */
@Mixin(BannerRenderer.class)
public abstract class BannerSwayMixin {
    @Inject(method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BannerBlockEntity;Lnet/minecraft/client/renderer/blockentity/state/BannerRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V",
        at = @At("RETURN"))
    private void quicksilverCi$holdSway(BannerBlockEntity banner, BannerRenderState state, float partialTick, Vec3 camera,
                                      ModelFeatureRenderer.CrumblingOverlay overlay, CallbackInfo ci) {
        BlockPos p = banner.getBlockPos();
        if (p.getX() >= 2936 && p.getX() <= 2964 && p.getZ() >= -2004 && p.getZ() <= -1980 && p.getY() >= 190 && p.getY() <= 212) {
            Level level = banner.getLevel();
            if (level != null && level.getBlockState(SWAY_MARKER).is(Blocks.REDSTONE_BLOCK)) return;
            state.phase = Math.floorMod(p.getX() * 7 + p.getY() * 9 + p.getZ() * 13, 100) / 100.0F;
            return;
        }
        state.phase = 0.0F;
    }

    private static final BlockPos SWAY_MARKER = new BlockPos(2950, 194, -1990);
}
