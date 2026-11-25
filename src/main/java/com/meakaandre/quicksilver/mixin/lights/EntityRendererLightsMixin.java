package com.meakaandre.quicksilver.mixin.lights;

import com.meakaandre.quicksilver.lights.ObjectLights;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Package 13, Fancy: an entity's light value raised by the dynamic lights at its middle, once its state is extracted. */
@Mixin(EntityRenderer.class)
abstract class EntityRendererLightsMixin {
    @Inject(method = "createRenderState(Lnet/minecraft/world/entity/Entity;F)Lnet/minecraft/client/renderer/entity/state/EntityRenderState;", at = @At("RETURN"))
    private void quicksilver$dynamicLight(Entity entity, float partialTick, CallbackInfoReturnable<EntityRenderState> cir) {
        EntityRenderState s = cir.getReturnValue();
        if (s != null) s.lightCoords = ObjectLights.entity(s.lightCoords, s.x, s.y + entity.getBbHeight() * 0.5, s.z);
    }
}
