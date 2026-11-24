package com.meakaandre.quicksilver.mixin.speed;

import com.meakaandre.quicksilver.speed.SpeedTerrain;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package B: the fog values vanilla writes into the shaders' fog uniform block each frame (after its fog environments
 * and any mod that changes the fog data have run), so {@code approx.fog-sections} culls only at a fog end it has seen
 * the shaders get. Without this hook (not applied, or a mod that writes the fog its own way) fog-sections switches
 * itself off ({@link SpeedTerrain}).
 */
@Mixin(FogRenderer.class)
public abstract class FogRendererMixin {
    @Shadow
    private static boolean fogEnabled;

    @Inject(method = "updateBuffer(Lnet/minecraft/client/renderer/fog/FogData;)V", at = @At("TAIL"))
    private void quicksilver$fog(FogData data, CallbackInfo ci) {
        SpeedTerrain.fogWritten(fogEnabled, data.renderDistanceStart, data.renderDistanceEnd, data.environmentalStart, data.environmentalEnd,
            data.color == null ? Float.NaN : data.color.w());
    }
}
