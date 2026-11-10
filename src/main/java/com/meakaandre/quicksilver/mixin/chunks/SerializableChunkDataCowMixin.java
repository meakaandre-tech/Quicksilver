package com.meakaandre.quicksilver.mixin.chunks;

import com.meakaandre.quicksilver.chunks.Chunks;
import com.meakaandre.quicksilver.chunks.CowSections;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.storage.SerializableChunkData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * P2-4, chunks.cow-sections ({@link CowSections}): a full chunk's section copies in a save snapshot share their
 * containers' data; in verify mode, each shared container is checked against its real copy once the snapshot has been
 * serialised (on the worker thread that serialises it).
 */
@Mixin(SerializableChunkData.class)
public abstract class SerializableChunkDataCowMixin {
    @Shadow
    public abstract List<SerializableChunkData.SectionData> sectionData();

    @Shadow
    public abstract ChunkPos chunkPos();

    /**
     * The snapshot of a full chunk shares its sections' containers (from here to {@link #quicksilver$copied}: the only
     * container copies in it are its sections'). An {@code @Inject} pair, not a {@code @WrapOperation} on the section copy:
     * MixinExtras applies those after the config plugin's check, so the hook check can't see them. If the copy throws,
     * the next snapshot's start resets the flag (and sharing is copy on write wherever it happens).
     */
    @Inject(method = "copyOf", at = @At("HEAD"))
    private static void quicksilver$copySection(ServerLevel level, ChunkAccess chunk, CallbackInfoReturnable<SerializableChunkData> cir) {
        if (CowSections.SWITCH.on && chunk instanceof LevelChunk) CowSections.begin();
        else CowSections.end();
    }

    @Inject(method = "copyOf", at = @At("RETURN"))
    private static void quicksilver$copied(ServerLevel level, ChunkAccess chunk, CallbackInfoReturnable<SerializableChunkData> cir) {
        CowSections.end();
    }

    @Inject(method = "write", at = @At("RETURN"))
    private void quicksilver$written(CallbackInfoReturnable<CompoundTag> cir) {
        if (!Chunks.VERIFY) return;
        for (SerializableChunkData.SectionData s : sectionData()) {
            LevelChunkSection section = s.chunkSection();
            if (section == null) continue;
            String where = "chunk " + chunkPos() + " section " + s.y();
            CowSections.check(section.getStates(), where);
            CowSections.check(section.getBiomes(), where + " (biomes)");
        }
    }
}
