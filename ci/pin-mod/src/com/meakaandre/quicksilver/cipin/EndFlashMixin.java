package com.meakaandre.quicksilver.cipin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * CI only. In the End the game flashes the sky now and then, which relights the whole picture (terrain too) for a few
 * seconds, so two identical runs' End shots differ by chance on a quarter of their pixels (package 12's End shots,
 * far terrain off as well). Held at rest (no flash) in every CI client run, vanilla and Quicksilver alike.
 */
@Mixin(targets = "net.minecraft.client.renderer.EndFlashState")
public abstract class EndFlashMixin {
    @Shadow
    private float intensity;
    @Shadow
    private float oldIntensity;

    @Inject(method = "tick", at = @At("TAIL"))
    private void quicksilverCi$holdFlash(long gameTime, CallbackInfo ci) {
        intensity = 0.0F;
        oldIntensity = 0.0F;
    }
}
