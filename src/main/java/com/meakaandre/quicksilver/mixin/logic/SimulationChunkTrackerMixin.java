package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.BlockEntityChecks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** P2-3, logic.block-entity-checks: every write of a chunk's simulation level counts as a change. */
@Mixin(targets = "net.minecraft.server.level.SimulationChunkTracker")
public abstract class SimulationChunkTrackerMixin {
    @Inject(method = "setLevel(JI)V", at = @At("HEAD"))
    private void quicksilver$levelChanged(long node, int level, CallbackInfo ci) {
        BlockEntityChecks.changed();
    }
}
