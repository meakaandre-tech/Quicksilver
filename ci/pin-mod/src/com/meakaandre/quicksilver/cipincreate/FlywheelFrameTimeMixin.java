package com.meakaandre.quicksilver.cipincreate;

import com.meakaandre.quicksilver.cipinstate.CreatePins;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/** CI only (package 5): Flywheel's frame time (its GPU animation clock) held in the Create pin areas ({@link CreatePins}). */
@Pseudo
@Mixin(targets = "com.zurrtum.create.client.flywheel.backend.engine.uniform.FrameUniforms", remap = false)
public abstract class FlywheelFrameTimeMixin {
    @ModifyVariable(method = "writeTime", at = @At("HEAD"), argsOnly = true, ordinal = 0, remap = false)
    private static int quicksilverCi$ticks(int ticks) {
        if (!CreatePins.pinned) return ticks;
        CreatePins.used("Flywheel's frame time");
        return CreatePins.TICKS;
    }

    @ModifyVariable(method = "writeTime", at = @At("HEAD"), argsOnly = true, ordinal = 0, remap = false)
    private static float quicksilverCi$partial(float partialTick) {
        return CreatePins.pinned ? CreatePins.PARTIAL : partialTick;
    }
}
