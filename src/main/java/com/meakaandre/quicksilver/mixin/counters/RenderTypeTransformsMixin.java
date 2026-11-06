package com.meakaandre.quicksilver.mixin.counters;

import com.meakaandre.quicksilver.entity.FeatureStats;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import net.minecraft.client.renderer.rendertype.RenderType;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Package 6 measurement ({@link FeatureStats}): the matrix each render type's dynamic transforms slice holds, so the
 * draws can be compared by the transforms' value rather than by which slice they sit in. Count only.
 */
@Mixin(RenderType.class)
public abstract class RenderTypeTransformsMixin {
    @Inject(method = "writeDynamicTransforms", at = @At("RETURN"))
    private void quicksilver$featureTransforms(Matrix4f matrix, CallbackInfoReturnable<GpuBufferSlice> cir) {
        FeatureStats.transforms(cir.getReturnValue(), matrix);
    }
}
