package com.meakaandre.quicksilver.mixin.entity;

import com.meakaandre.quicksilver.entity.EntityLod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Far entity LOD: a cube under half a pixel of a far mob's model is not written. */
@Mixin(ModelPart.Cube.class)
abstract class ModelCubeLodMixin {
    @Inject(method = "compile", at = @At("HEAD"), cancellable = true)
    private void quicksilver$lodCube(PoseStack.Pose pose, VertexConsumer consumer, int light, int overlay, int color, CallbackInfo ci) {
        if (EntityLod.skipCube((ModelPart.Cube) (Object) this, pose)) ci.cancel();
    }
}
