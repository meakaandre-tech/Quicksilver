package com.meakaandre.quicksilver.mixin.entity;

import com.meakaandre.quicksilver.entity.EntityLod;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Far entity LOD: which model submit is being written, so its tiny cubes can be left out. */
@Mixin(ModelFeatureRenderer.class)
abstract class ModelFeatureRendererLodMixin {
    @Inject(method = "prepareModel", at = @At("HEAD"))
    private void quicksilver$lodBegin(ModelFeatureRenderer.Submit<?> submit, CallbackInfo ci) {
        EntityLod.beginModel(submit.state());
    }

    @Inject(method = "prepareModel", at = @At("RETURN"))
    private void quicksilver$lodEnd(ModelFeatureRenderer.Submit<?> submit, CallbackInfo ci) {
        EntityLod.endModel();
    }
}
