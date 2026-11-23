package com.meakaandre.quicksilver.mixin.counters;

import com.meakaandre.quicksilver.entity.FeatureStats;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Package 6 measurement ({@link FeatureStats}): entities submitted per frame, by render-state class. Count only. */
@Mixin(EntityRenderDispatcher.class)
public abstract class EntitySubmitMixin {
    @Inject(method = "submit", at = @At("HEAD"))
    private void quicksilver$entitySubmit(EntityRenderState state, CameraRenderState camera, double x, double y, double z,
                                          PoseStack poseStack, SubmitNodeCollector collector, CallbackInfo ci) {
        FeatureStats.entity(state);
    }
}
