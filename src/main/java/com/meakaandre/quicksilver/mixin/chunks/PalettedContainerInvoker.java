package com.meakaandre.quicksilver.mixin.chunks;

import net.minecraft.util.BitStorage;
import net.minecraft.world.level.chunk.Configuration;
import net.minecraft.world.level.chunk.Palette;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.chunk.Strategy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

/** P2-4, chunks.cow-sections: the container constructor the game unpacks containers with (strategy, configuration, storage, palette). */
@Mixin(PalettedContainer.class)
public interface PalettedContainerInvoker {
    @Invoker("<init>")
    static <T> PalettedContainer<T> quicksilver$create(Strategy<T> strategy, Configuration configuration, BitStorage storage, Palette<T> palette) {
        throw new AssertionError();
    }
}
