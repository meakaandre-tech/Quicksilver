package com.meakaandre.ciserver.mixin;

import com.meakaandre.ciserver.CiChunks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.chunk.storage.SerializableChunkData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * CI only (P2-4): every chunk tag the game serialises for saving, in order per chunk, so the chunk scenes compare each
 * save's content with vanilla's (not only the files left at the end, which the last save rewrites). On the thread that
 * serialises (the background executor, one thread in CI). Records only; optional (require 0): the chunk scenes fail
 * without it (CiChunks logs whether it ran).
 */
@Mixin(SerializableChunkData.class)
public abstract class ChunkWriteMixin {
    @Inject(method = "write", at = @At("RETURN"), require = 0)
    private void ciServer$written(CallbackInfoReturnable<CompoundTag> cir) {
        CiChunks.written(((SerializableChunkData) (Object) this).chunkPos(), cir.getReturnValue());
    }
}
