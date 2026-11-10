package com.meakaandre.quicksilver.mixin.chunks;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.meakaandre.quicksilver.chunks.Chunks;
import com.meakaandre.quicksilver.chunks.CowSections;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
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

    @WrapOperation(method = "copyOf", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/chunk/LevelChunkSection;copy()Lnet/minecraft/world/level/chunk/LevelChunkSection;"))
    private static LevelChunkSection quicksilver$copySection(LevelChunkSection section, Operation<LevelChunkSection> copy,
                                                             @Local(argsOnly = true) ChunkAccess chunk) {
        if (!CowSections.SWITCH.on || !(chunk instanceof LevelChunk)) return copy.call(section);
        CowSections.begin();
        try {
            return copy.call(section);
        } finally {
            CowSections.end();
        }
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
