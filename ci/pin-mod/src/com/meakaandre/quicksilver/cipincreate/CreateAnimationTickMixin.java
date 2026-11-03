package com.meakaandre.quicksilver.cipincreate;

import com.meakaandre.quicksilver.cipinstate.CreatePins;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** CI only (package 5): Create's CPU animation clock held in the Create pin areas ({@link CreatePins}). */
@Pseudo
@Mixin(targets = "com.zurrtum.create.client.catnip.animation.AnimationTickHolder", remap = false)
public abstract class CreateAnimationTickMixin {
    @Inject(method = "getTicks(Z)I", at = @At("HEAD"), cancellable = true, remap = false)
    private static void quicksilverCi$ticks(boolean includePaused, CallbackInfoReturnable<Integer> cir) {
        if (!CreatePins.pinned) return;
        CreatePins.used("AnimationTickHolder");
        cir.setReturnValue(CreatePins.TICKS);
    }

    @Inject(method = "getPartialTicks()F", at = @At("HEAD"), cancellable = true, remap = false)
    private static void quicksilverCi$partial(CallbackInfoReturnable<Float> cir) {
        if (CreatePins.pinned) cir.setReturnValue(CreatePins.PARTIAL);
    }
}
