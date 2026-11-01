package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.HopperEntities;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.level.entity.EntitySection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** P2-3, logic.hopper-entities: each section counts the item entities and the container entities it holds. */
@Mixin(EntitySection.class)
public abstract class EntitySectionHopperMixin<T extends EntityAccess> implements HopperEntities.SectionCounts {
    @Unique
    private int quicksilver$itemCount;

    @Unique
    private int quicksilver$containerCount;

    @Override
    public int quicksilver$items() {
        return quicksilver$itemCount;
    }

    @Override
    public int quicksilver$containers() {
        return quicksilver$containerCount;
    }

    @Inject(method = "add", at = @At("RETURN"))
    private void quicksilver$hopperAdded(T entity, CallbackInfo ci) {
        if (HopperEntities.isItem(entity)) quicksilver$itemCount++;
        if (HopperEntities.isContainer(entity)) quicksilver$containerCount++;
    }

    @Inject(method = "remove", at = @At("RETURN"))
    private void quicksilver$hopperRemoved(T entity, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValueZ()) return;
        if (HopperEntities.isItem(entity)) quicksilver$itemCount--;
        if (HopperEntities.isContainer(entity)) quicksilver$containerCount--;
    }
}
