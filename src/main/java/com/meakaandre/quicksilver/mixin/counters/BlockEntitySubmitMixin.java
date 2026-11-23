package com.meakaandre.quicksilver.mixin.counters;

import com.meakaandre.quicksilver.entity.FeatureStats;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Package 6 measurement ({@link FeatureStats}): block entities submitted per frame, by render-state class. Count only. */
@Mixin(BlockEntityRenderDispatcher.class)
public abstract class BlockEntitySubmitMixin {
    @Inject(method = "submit", at = @At("HEAD"))
    private void quicksilver$blockEntitySubmit(BlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector collector,
                                               CameraRenderState camera, CallbackInfo ci) {
        FeatureStats.blockEntity(state);
    }
}
