package com.meakaandre.quicksilver.mixin.look;

import com.meakaandre.quicksilver.look.PixelArt;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import net.minecraft.client.renderer.Projection;
import net.minecraft.client.renderer.ProjectionMatrixBuffer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Package 11: the world's projection while it draws for the pixel art look (each pixel's distance, for the outlines' fog fade). */
@Mixin(ProjectionMatrixBuffer.class)
public abstract class ProjectionLookMixin {
    @Inject(method = "getBuffer(Lorg/joml/Matrix4f;)Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;", at = @At("RETURN"))
    private void quicksilver$lookMatrix(Matrix4f matrix, CallbackInfoReturnable<GpuBufferSlice> cir) {
        PixelArt.projection(matrix);
    }

    @Inject(method = "getBuffer(Lnet/minecraft/client/renderer/Projection;)Lcom/mojang/renderpearl/api/buffers/GpuBufferSlice;", at = @At("RETURN"))
    private void quicksilver$lookProjection(Projection projection, CallbackInfoReturnable<GpuBufferSlice> cir) {
        if (!PixelArt.wantsProjection()) return;
        Matrix4f m = new Matrix4f();
        projection.getMatrix(m);
        PixelArt.projection(m);
    }
}
