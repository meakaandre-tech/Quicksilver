package com.meakaandre.quicksilver.mixin.chunks;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.meakaandre.quicksilver.chunks.Chunks;
import com.meakaandre.quicksilver.chunks.CowSections;
import net.minecraft.world.level.chunk.PalettedContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * P2-4, chunks.cow-sections ({@link CowSections}): a container's copy shares its data while a save snapshot is taken,
 * and a shared container copies its data before its first write. The unshare runs whether or not the optimisation is
 * still on (a container shared before a fallback must still take its copy).
 */
@Mixin(PalettedContainer.class)
public abstract class PalettedContainerCowMixin<T> implements CowSections.Shared {
    @Shadow
    private PalettedContainer.Data<T> data;

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

    // the copy constructor: share the other container's data instead of copying it, while a snapshot is taken
    @WrapOperation(method = "<init>(Lnet/minecraft/world/level/chunk/PalettedContainer;)V",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/chunk/PalettedContainer$Data;copy()Lnet/minecraft/world/level/chunk/PalettedContainer$Data;"))
    private PalettedContainer.Data<T> quicksilver$share(PalettedContainer.Data<T> d, Operation<PalettedContainer.Data<T>> copy,
                                                       @Local(argsOnly = true) PalettedContainer<T> other) {
        if (!CowSections.sharing()) return copy.call(d);
        try {
            if (Chunks.VERIFY) quicksilver$verify = copy.call(d);
            ((PalettedContainerCowMixin<?>) (Object) other).quicksilver$isShared = true;
            quicksilver$isShared = true;
            return d;
        } catch (Throwable t) {
            CowSections.SWITCH.fail(t);
            quicksilver$verify = null;
            return copy.call(d);
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
