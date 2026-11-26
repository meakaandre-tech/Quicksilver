package com.meakaandre.quicksilver.mixin.look;

import com.meakaandre.quicksilver.look.PixelArt;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 11: the level renderer draws the world on the small target while the pixel art look is on (before), then the
 * look's two full-screen draws put it on the window's target (after). Its resize is followed, so the look knows which
 * size the level renderer's own targets have.
 */
@Mixin(LevelRenderer.class)
public abstract class LevelRendererLookMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void quicksilver$pixelArtBefore(CallbackInfo ci) {
        PixelArt.beforeLevel();
    }

    @Inject(method = "render", at = @At("RETURN"))
    private void quicksilver$pixelArtAfter(CallbackInfo ci) {
        PixelArt.afterLevel();
    }

    @Inject(method = "resize", at = @At("HEAD"))
    private void quicksilver$resized(int width, int height, CallbackInfo ci) {
        PixelArt.levelResized(width, height);
    }
}
