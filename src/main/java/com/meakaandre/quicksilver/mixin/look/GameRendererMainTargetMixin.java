package com.meakaandre.quicksilver.mixin.look;

import com.meakaandre.quicksilver.look.PixelArt;
import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Package 11: while the world draws with the pixel art look on, the game's main target is the small one. */
@Mixin(GameRenderer.class)
public abstract class GameRendererMainTargetMixin {
    @Inject(method = "mainRenderTarget", at = @At("HEAD"), cancellable = true)
    private void quicksilver$pixelArtTarget(CallbackInfoReturnable<RenderTarget> cir) {
        RenderTarget t = PixelArt.mainTargetOverride();
        if (t != null) cir.setReturnValue(t);
    }
}
