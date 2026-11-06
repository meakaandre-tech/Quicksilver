package com.meakaandre.quicksilver.mixin.logic;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.meakaandre.quicksilver.logic.HopperCache;
import net.fabricmc.fabric.api.lookup.v1.block.BlockApiLookup;
import net.fabricmc.fabric.impl.lookup.block.BlockApiLookupImpl;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * P2-3b, logic.hopper-cache ({@link HopperCache}, "Fabric's transfer lookup after a none"): Fabric API's block lookup,
 * answered "none" for the hopper lookup just marked when its entry remembers Fabric's "none", else run as it is and its
 * "none" remembered. Every other find passes through untouched (one reference check at its head).
 */
@Mixin(value = BlockApiLookupImpl.class, remap = false)
public abstract class HopperCacheFabricMixin {
    private static final String FIND = "find(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/entity/BlockEntity;Ljava/lang/Object;)Ljava/lang/Object;";

    @Inject(method = FIND, at = @At("HEAD"), cancellable = true)
    private void quicksilver$fabricFind(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity, Object context,
                                        CallbackInfoReturnable<Object> cir) {
        try {
            if (HopperCache.fabricAnswers(this, level, pos, state, blockEntity)) cir.setReturnValue(null);
        } catch (Throwable t) {
            HopperCache.SWITCH.fail(t);
        }
    }

    @Redirect(method = FIND, at = @At(value = "INVOKE",
        target = "Lnet/fabricmc/fabric/impl/lookup/block/BlockApiLookupImpl;getProvider(Lnet/minecraft/world/level/block/Block;)Lnet/fabricmc/fabric/api/lookup/v1/block/BlockApiLookup$BlockApiProvider;"))
    private BlockApiLookup.BlockApiProvider<?, ?> quicksilver$fabricProvider(BlockApiLookupImpl<?, ?> self, Block block) {
        BlockApiLookup.BlockApiProvider<?, ?> p = self.getProvider(block);
        HopperCache.fabricProvider(p);
        return p;
    }

    @ModifyReturnValue(method = FIND, at = @At("RETURN"))
    private Object quicksilver$fabricResult(Object result, Level level, BlockPos pos) {
        try {
            return HopperCache.fabricResult(level, pos, result);
        } catch (Throwable t) {
            HopperCache.SWITCH.fail(t);
            return result;
        }
    }
}
