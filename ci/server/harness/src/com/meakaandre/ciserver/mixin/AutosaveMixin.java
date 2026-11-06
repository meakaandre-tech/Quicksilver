package com.meakaandre.ciserver.mixin;

import com.meakaandre.ciserver.Harness;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * CI only (P2-4, measurement): which run tick the game's own autosave happens in, so the chunk scenes can
 * name their spikes. Optional (require 0): a game without these methods only loses the label. Records only; the same
 * in every run.
 */
@Mixin(MinecraftServer.class)
public abstract class AutosaveMixin {
    @Inject(method = "autoSave", at = @At("HEAD"), require = 0)
    private void ciServer$autosave(CallbackInfo ci) {
        Harness.autosave("autoSave");
    }
}
