package com.meakaandre.quicksilver.mixin.flywheel;

import com.meakaandre.quicksilver.compat.flywheel.FlywheelCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 5, only with Create Fly: where Flywheel draws its solid geometry into the main target before the terrain
 * (Create Fly's hook in vanilla's main pass calls this), Quicksilver notes the frame (see
 * {@link FlywheelCompat#depthStamp}). At the method's end: Flywheel has waited for its frame's work by then, so its
 * visual storage is no longer being written by its worker threads. Count only; what Flywheel draws is unchanged.
 */
@Pseudo
@Mixin(targets = "com.zurrtum.create.client.flywheel.impl.event.RenderContextImpl", remap = false)
public abstract class FlwRenderContextMixin {
    @Inject(method = "beforeSolid", at = @At("RETURN"), remap = false, require = 0)
    private void quicksilver$beforeSolid(CallbackInfo ci) {
        FlywheelCompat.beforeSolid(this);
    }
}
