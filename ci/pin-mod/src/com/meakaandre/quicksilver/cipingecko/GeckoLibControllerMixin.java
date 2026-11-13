package com.meakaandre.quicksilver.cipingecko;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.meakaandre.quicksilver.cipinstate.CreatePins;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * CI only (the test pack, 2026-11-13): GeckoLib's animation controllers held at one point of their timeline in the
 * geckolib scene's area ({@link CreatePins#geckoPinned}), vanilla's runs and Quicksilver's alike. Pinning the clock
 * AnimationProcessor reads ({@link GeckoLibClockMixin}) was not enough: each controller reads the animatable's age
 * itself (checkControllerState) and adds up its own timeline time frame by frame from the first frame it was drawn,
 * before the player had reached the area, so the geese still stood in another phase of their idle animation in every
 * run (vanilla's against vanilla's: 199-787 strict pixels, runs of 1eb2be5 and 9db78fc). While the player is in the
 * area each started controller is put back to {@link #TIMELINE} ticks before it steps, by a fixed step from a fixed
 * age, so every run draws the same pose. Outside it nothing changes.
 */
@Pseudo
@Mixin(targets = "com.geckolib.animation.AnimationController", remap = false)
public abstract class GeckoLibControllerMixin {
    /** Where on its timeline each started controller is held: past the transition into the first animation. */
    private static final double TIMELINE = 30.0;
    private static final double STEP = 0.05;

    @Shadow(remap = false)
    protected double timelineTime;
    @Shadow(remap = false)
    protected double lastAnimatableAge;

    @Inject(method = "checkControllerState", at = @At("HEAD"), remap = false)
    private void quicksilverCi$hold(CallbackInfoReturnable<Boolean> cir) {
        if (!CreatePins.geckoPinned || timelineTime < 0) return;
        CreatePins.used("GeckoLib AnimationController timeline");
        timelineTime = TIMELINE - STEP;
        lastAnimatableAge = CreatePins.TICKS + CreatePins.PARTIAL - STEP;
    }

    @ModifyExpressionValue(method = "checkControllerState", remap = false,
        at = @At(value = "INVOKE", target = "Lcom/geckolib/renderer/base/GeoRenderState;getAnimatableAge()D", remap = false))
    private double quicksilverCi$age(double age) {
        return CreatePins.geckoPinned ? CreatePins.TICKS : age;
    }

    @ModifyExpressionValue(method = "checkControllerState", remap = false,
        at = @At(value = "INVOKE", target = "Lcom/geckolib/renderer/base/GeoRenderState;getPartialTick()F", remap = false))
    private float quicksilverCi$partial(float partial) {
        return CreatePins.geckoPinned ? CreatePins.PARTIAL : partial;
    }
}
