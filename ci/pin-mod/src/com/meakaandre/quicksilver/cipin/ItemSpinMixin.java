package com.meakaandre.quicksilver.cipin;

import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * CI only (package 13). A dropped item spins and bobs with its age, which runs with the client's ticks, and from a
 * random phase: the lights scene's dropped lantern would show at another angle in every run. Held at rest (no spin, no
 * bob) in the lights scene's hall, in every CI client run, vanilla and Quicksilver alike.
 */
@Mixin(ItemEntityRenderer.class)
public abstract class ItemSpinMixin {
    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/item/ItemEntity;Lnet/minecraft/client/renderer/entity/state/ItemEntityRenderState;F)V",
            at = @At("TAIL"))
    private void quicksilverCi$holdSpin(ItemEntity item, ItemEntityRenderState state, float partialTick, CallbackInfo ci) {
        double x = item.getX(), z = item.getZ();
        if (x >= 3090 && x <= 3121 && z >= -2025 && z <= -1989) {
            state.ageInTicks = 0.0F;
            state.bobOffset = 0.0F;
        }
    }
}
