package com.meakaandre.quicksilver.mixin.logic;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/** P2-3b, logic.hopper-cache: vanilla's own lookups, called from the hooks that wrap them ({@code HopperCacheMixin}). */
@Mixin(HopperBlockEntity.class)
public interface HopperCacheInvoker {
    @Invoker("getAttachedContainer")
    static Container quicksilver$vanillaAttached(Level level, BlockPos pos, HopperBlockEntity hopper) {
        throw new AssertionError();
    }

    @Invoker("getSourceContainer")
    static Container quicksilver$vanillaSource(Level level, Hopper hopper, BlockPos pos, BlockState state) {
        throw new AssertionError();
    }

    @Invoker("getBlockContainer")
    static Container quicksilver$vanillaBlockContainer(Level level, BlockPos pos, BlockState state) {
        throw new AssertionError();
    }
}
