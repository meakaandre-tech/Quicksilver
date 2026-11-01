package com.meakaandre.quicksilver.mixin.logic;

import java.util.List;
import net.minecraft.world.entity.ai.behavior.ShufflingList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** P2-3, logic.gate-behaviours: a shuffled list's entries, in the order its stream walks them. */
@Mixin(ShufflingList.class)
public interface ShufflingListAccessor<U> {
    @Accessor("entries")
    List<ShufflingList.WeightedEntry<? extends U>> quicksilver$entries();
}
