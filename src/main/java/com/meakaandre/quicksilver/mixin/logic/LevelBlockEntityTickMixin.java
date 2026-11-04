/*
 * Quicksilver: P2-3, logic.block-entity-checks. The idea and structure (a redirect of shouldTickBlocksAt inside
 * tickBlockEntities that answers again for the chunk asked last) are from Lithium (https://github.com/CaffeineMC/lithium,
 * branch develop at 383d299, common/src/main/java/net/caffeinemc/mods/lithium/mixin/world/block_entity_ticking/
 * chunk_tickable/LevelMixin.java), Copyright (C) CaffeineMC and Lithium's contributors, licensed under the GNU Lesser
 * General Public License v3.0 only (LICENSE, COPYING). Changed for Quicksilver: its own switch and CI check; a kept answer
 * is used only while no simulation level can have changed (Lithium keeps it for the whole call); server levels only.
 */
package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.BlockEntityChecks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * P2-3, logic.block-entity-checks ({@link BlockEntityChecks}): within one tickBlockEntities call, a "yes" from
 * shouldTickBlocksAt for the chunk asked last is given again while no simulation level can have changed. Kept on the
 * level itself (the client and the integrated server tick their own levels on their own threads); server levels only.
 */
@Mixin(Level.class)
public abstract class LevelBlockEntityTickMixin {
    @Unique
    private static final long QUICKSILVER$NONE = Long.MIN_VALUE;

    @Unique
    private long quicksilver$tickChunk = QUICKSILVER$NONE;

    @Unique
    private long quicksilver$tickChanges;

    @Inject(method = "tickBlockEntities", at = @At("HEAD"))
    private void quicksilver$beBegin(CallbackInfo ci) {
        this.quicksilver$tickChunk = QUICKSILVER$NONE;
    }

    @Redirect(method = "tickBlockEntities", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/Level;shouldTickBlocksAt(Lnet/minecraft/core/BlockPos;)Z"))
    private boolean quicksilver$shouldTick(Level level, BlockPos pos) {
        if (!BlockEntityChecks.SWITCH.on || pos == null || !(level instanceof ServerLevel)) return level.shouldTickBlocksAt(pos);
        // a key for the chunk (only compared, never hashed)
        long key = ((long) (pos.getX() >> 4) & 0xFFFFFFFFL) | (((long) (pos.getZ() >> 4) & 0xFFFFFFFFL) << 32);
        long changes = BlockEntityChecks.changes();
        if (key == this.quicksilver$tickChunk && changes == this.quicksilver$tickChanges) {
            if (BlockEntityChecks.VERIFY && !level.shouldTickBlocksAt(pos)) {
                BlockEntityChecks.mismatch("shouldTickBlocksAt at " + pos);
                return false;
            }
            return true;
        }
        boolean yes = level.shouldTickBlocksAt(pos);
        if (yes && BlockEntityChecks.counting()) {
            this.quicksilver$tickChunk = key;
            this.quicksilver$tickChanges = changes;
        } else {
            this.quicksilver$tickChunk = QUICKSILVER$NONE;
        }
        return yes;
    }
}
