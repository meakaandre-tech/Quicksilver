package com.meakaandre.quicksilver.mixin.terrain;

import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 12: the camera's far plane covers far terrain while it draws. Vanilla sets it to the larger of the render
 * distance x 4 and the cloud distance; with clouds set nearer than the far distance, far terrain past the plane would
 * be clipped. Vanilla's own value otherwise (far terrain off or not drawing). Optional: without it far terrain ends
 * at vanilla's plane.
 */
@Mixin(Camera.class)
public abstract class CameraDepthFarMixin {
    @Shadow
    private float depthFar;

    @Inject(method = "update", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Camera;depthFar:F", opcode = org.objectweb.asm.Opcodes.PUTFIELD, shift = At.Shift.AFTER))
    private void quicksilver$farTerrainDepth(DeltaTracker deltaTracker, CallbackInfo ci) {
        float far = com.meakaandre.quicksilver.far.FarTerrain.depthFarNeeded();
        if (far > depthFar) depthFar = far;
    }
}
