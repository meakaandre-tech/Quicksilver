package com.meakaandre.quicksilver.mixin.entity;

import com.meakaandre.quicksilver.entity.EntityLod;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Far entity LOD: the finished render state of every entity (after each renderer's own extraction). */
@Mixin(EntityRenderer.class)
abstract class EntityRendererLodMixin {
    @Inject(method = "createRenderState(Lnet/minecraft/world/entity/Entity;F)Lnet/minecraft/client/renderer/entity/state/EntityRenderState;", at = @At("RETURN"))
    private void quicksilver$lodExtracted(Entity entity, float partialTick, CallbackInfoReturnable<EntityRenderState> cir) {
        EntityLod.extracted(entity, cir.getReturnValue());
    }
}
