package com.meakaandre.quicksilver.mixin.occlusion;

import com.meakaandre.quicksilver.occlusion.GpuOcclusion;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import net.minecraft.client.renderer.Projection;
import net.minecraft.client.renderer.ProjectionMatrixBuffer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Package 2b: the projection matrix behind each projection uniform slice, so the depth test is made with exactly the
 * projection terrain is drawn with (view bobbing and the damage tilt included).
 */
@Mixin(ProjectionMatrixBuffer.class)
public abstract class ProjectionMatrixBufferMixin {
    @Inject(method = "getBuffer(Lorg/joml/Matrix4f;)Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;", at = @At("RETURN"))
    private void quicksilver$matrix(Matrix4f matrix, CallbackInfoReturnable<GpuBufferSlice> cir) {
        GpuOcclusion.projection(cir.getReturnValue(), matrix);
    }

    @Inject(method = "getBuffer(Lnet/minecraft/client/renderer/Projection;)Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;", at = @At("RETURN"))
    private void quicksilver$projection(Projection projection, CallbackInfoReturnable<GpuBufferSlice> cir) {
        Matrix4f m = new Matrix4f();
        projection.getMatrix(m);
        GpuOcclusion.projection(cir.getReturnValue(), m);
    }
}
