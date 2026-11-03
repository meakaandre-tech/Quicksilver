package com.meakaandre.quicksilver.mixin.flywheel;

import com.meakaandre.quicksilver.compat.flywheel.FlywheelCompat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 5, only with Create Fly: after Flywheel chooses its backend (on resource reload and level renderer reload),
 * Quicksilver logs and reports which one it chose. Count only; Flywheel's choice is unchanged.
 */
@Pseudo
@Mixin(targets = "com.zurrtum.create.client.flywheel.impl.BackendManagerImpl", remap = false)
public abstract class FlwBackendManagerMixin {
    @Inject(method = "chooseBackend", at = @At("RETURN"), remap = false, require = 0)
    private static void quicksilver$backendChosen(CallbackInfo ci) {
        FlywheelCompat.backendChosen();
    }
}
