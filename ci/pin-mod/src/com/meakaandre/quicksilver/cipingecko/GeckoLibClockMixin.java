package com.meakaandre.quicksilver.cipingecko;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.meakaandre.quicksilver.cipinstate.CreatePins;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;

/**
 * CI only (the test pack, 2026-11-13): GeckoLib's animation clock held in the geckolib scene's area
 * ({@link CreatePins#geckoPinned}), vanilla's runs and Quicksilver's alike. GeckoLib works out each animation's point
 * from the animatable's age and the partial tick (AnimationProcessor.extractControllerStates), counted from the frame
 * it was first drawn, so Untitled Duck Mod's geese were caught in another phase of their idle animation in every run
 * (vanilla's against vanilla's: 800-1,200 strict pixels, run 43162079500). While the player is in the area both read
 * {@link CreatePins#TICKS} and {@link CreatePins#PARTIAL}. Outside it nothing changes.
 */
@Pseudo
@Mixin(targets = "com.geckolib.animation.AnimationProcessor", remap = false)
public abstract class GeckoLibClockMixin {
    @ModifyExpressionValue(method = "extractControllerStates", remap = false,
        at = @At(value = "INVOKE", target = "Lcom/geckolib/renderer/base/GeoRenderState;getAnimatableAge()D", remap = false))
    private static double quicksilverCi$age(double age) {
        if (!CreatePins.geckoPinned) return age;
        CreatePins.used("GeckoLib AnimationProcessor");
        return CreatePins.TICKS;
    }

    @ModifyExpressionValue(method = "extractControllerStates", remap = false,
        at = @At(value = "INVOKE", target = "Lcom/geckolib/renderer/base/GeoRenderState;getPartialTick()F", remap = false))
    private static float quicksilverCi$partial(float partial) {
        return CreatePins.geckoPinned ? CreatePins.PARTIAL : partial;
    }
}
