package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.BlockEntityChecks;
import net.minecraft.server.level.ServerChunkCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** P2-3, logic.block-entity-checks: every run of the distance manager's updates counts as a change. */
@Mixin(ServerChunkCache.class)
public abstract class ServerChunkCacheChangesMixin {
    @Inject(method = "runDistanceManagerUpdates", at = @At("HEAD"))
    private void quicksilver$distanceUpdates(CallbackInfoReturnable<Boolean> cir) {
        BlockEntityChecks.changed();
    }
}
