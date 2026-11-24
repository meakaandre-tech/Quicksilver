package com.meakaandre.quicksilver.mixin.speed;

import com.meakaandre.quicksilver.bench.StageProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.lighting.LevelLightEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Package A, step 1: the client's light updates as a stage of the speed bench's profile. Measures only. */
@Mixin(LevelLightEngine.class)
public abstract class LightUpdatesProfileMixin {
    @Inject(method = "runLightUpdates()I", at = @At("HEAD"))
    private void quicksilver$lightStart(CallbackInfoReturnable<Integer> cir) {
        if (StageProfile.active() && Minecraft.getInstance().isSameThread()) StageProfile.push("light.updates");
    }

    @Inject(method = "runLightUpdates()I", at = @At("RETURN"))
    private void quicksilver$lightEnd(CallbackInfoReturnable<Integer> cir) {
        if (StageProfile.active() && Minecraft.getInstance().isSameThread()) StageProfile.pop();
    }
}
