package com.meakaandre.quicksilver.mixin.chunks;

import com.meakaandre.quicksilver.chunks.Chunks;
import com.meakaandre.quicksilver.chunks.CowSections;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.chunk.Strategy;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * P2-4, chunks.cow-sections ({@link CowSections}): a container's copy shares its data while a save snapshot is taken,
 * and a shared container copies its data before its first write. The unshare runs whether or not the optimisation is
 * still on (a container shared before a fallback must still take its copy).
 */
@Mixin(PalettedContainer.class)
public abstract class PalettedContainerCowMixin<T> implements CowSections.Shared {
    @Shadow
    private PalettedContainer.Data<T> data;
    @Shadow
    @Final
    private Strategy strategy;

    @Unique
    private boolean quicksilver$isShared;
    @Unique
    private Object quicksilver$verify;

    @Override
    public boolean quicksilver$shared() {
        return quicksilver$isShared;
    }

    @Override
    public Object quicksilver$verifyCopy() {
        return quicksilver$verify;
    }

    @Override
    public void quicksilver$verifyCopy(Object d) {
        quicksilver$verify = d;
    }

    @Override
    public Object quicksilver$data() {
        return data;
    }

    // a copy made while a save snapshot is taken: a new container over the same storage and palette (no copy), both
    // marked shared (the new container is built as the game builds an unpacked one: strategy, configuration, storage, palette)
    @Inject(method = "copy", at = @At("HEAD"), cancellable = true)
    private void quicksilver$share(CallbackInfoReturnable<PalettedContainer<T>> cir) {
        if (!CowSections.sharing()) return;
        try {
            PalettedContainer.Data<T> d = data;
            PalettedContainer<T> copy = PalettedContainerInvoker.quicksilver$create(strategy, d.configuration(), d.storage(), d.palette());
            PalettedContainerCowMixin<?> c = (PalettedContainerCowMixin<?>) (Object) copy;
            if (Chunks.VERIFY) c.quicksilver$verify = d.copy();
            c.quicksilver$isShared = true;
            quicksilver$isShared = true;
            cir.setReturnValue(copy);
        } catch (Throwable t) {
            CowSections.SWITCH.fail(t);
        }
    }

    /** Before a write: a shared container takes its own copy of its data first (the data stays the other's). */
    @Unique
    private void quicksilver$unshare() {
        if (quicksilver$isShared) {
            data = data.copy();
            quicksilver$isShared = false;
        }
    }

    // each setter's first int argument passed through unchanged: no callback object per write
    @ModifyVariable(method = "getAndSet", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private int quicksilver$getAndSet(int first) {
        quicksilver$unshare();
        return first;
    }

    @ModifyVariable(method = "getAndSetUnchecked", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private int quicksilver$getAndSetUnchecked(int first) {
        quicksilver$unshare();
        return first;
    }

    @ModifyVariable(method = "set", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private int quicksilver$set(int first) {
        quicksilver$unshare();
        return first;
    }

    @Inject(method = "read", at = @At("HEAD"))
    private void quicksilver$read(CallbackInfo ci) {
        quicksilver$unshare();
    }
}
