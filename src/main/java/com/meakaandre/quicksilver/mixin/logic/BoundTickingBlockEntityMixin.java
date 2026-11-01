package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.BlockEntityChecks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * P2-3, logic.block-entity-checks ({@link BlockEntityChecks}): a block entity's tick wrapper keeps the last state it asked
 * BlockEntityType#isValid about, with the type and the answer, and gives the same answer for the same state and type
 * (compared by reference, nothing hashed).
 */
@Mixin(targets = "net.minecraft.world.level.chunk.LevelChunk$BoundTickingBlockEntity")
public abstract class BoundTickingBlockEntityMixin {
    @Unique
    private BlockState quicksilver$lastState;

    @Unique
    private BlockEntityType<?> quicksilver$lastType;

    @Unique
    private boolean quicksilver$lastValid;

    @Redirect(method = "tick", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/block/entity/BlockEntityType;isValid(Lnet/minecraft/world/level/block/state/BlockState;)Z"))
    private boolean quicksilver$valid(BlockEntityType<?> type, BlockState state) {
        if (!BlockEntityChecks.SWITCH.on) return type.isValid(state);
        if (state == this.quicksilver$lastState && type == this.quicksilver$lastType && state != null) {
            if (BlockEntityChecks.VERIFY && type.isValid(state) != this.quicksilver$lastValid) {
                BlockEntityChecks.mismatch("BlockEntityType.isValid for " + state);
                return type.isValid(state);
            }
            return this.quicksilver$lastValid;
        }
        boolean valid = type.isValid(state);
        this.quicksilver$lastState = state;
        this.quicksilver$lastType = type;
        this.quicksilver$lastValid = valid;
        return valid;
    }
}
