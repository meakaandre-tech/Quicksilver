package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.HopperCache;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** P2-3b, logic.hopper-cache: the server chunk cache's last four chunks, read without changing them ({@link HopperCache#peek}). */
@Mixin(ServerChunkCache.class)
public interface ServerChunkCacheRecentAccessor extends HopperCache.Recent {
    @Override
    @Accessor("lastChunkPos")
    long[] quicksilver$lastPos();

    @Override
    @Accessor("lastChunkStatus")
    ChunkStatus[] quicksilver$lastStatus();

    @Override
    @Accessor("lastChunk")
    ChunkAccess[] quicksilver$lastChunk();

    @Override
    @Accessor("mainThread")
    Thread quicksilver$mainThread();
}
