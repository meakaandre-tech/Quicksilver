package com.meakaandre.quicksilver.mixin.counters;

import com.meakaandre.quicksilver.entity.FeatureStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 6 measurement ({@link FeatureStats}): where each of the feature pass's phases starts and ends. Count only.
 */
@Mixin(targets = "net.minecraft.client.renderer.feature.FeatureRenderDispatcher$PreparedFrame")
public abstract class FeatureFrameMixin {
    @Inject(method = "executeSolid", at = @At("HEAD"))
    private void quicksilver$featureSolid(CallbackInfo ci) {
        FeatureStats.phaseStart("solid");
    }

    @Inject(method = "executeSolid", at = @At("RETURN"))
    private void quicksilver$featureSolidEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeTranslucent", at = @At("HEAD"))
    private void quicksilver$featureTranslucent(CallbackInfo ci) {
        FeatureStats.phaseStart("translucent");
    }

    @Inject(method = "executeTranslucent", at = @At("RETURN"))
    private void quicksilver$featureTranslucentEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeWaterMask", at = @At("HEAD"))
    private void quicksilver$featureWaterMask(CallbackInfo ci) {
        FeatureStats.phaseStart("waterMask");
    }

    @Inject(method = "executeWaterMask", at = @At("RETURN"))
    private void quicksilver$featureWaterMaskEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeOit", at = @At("HEAD"))
    private void quicksilver$featureOit(CallbackInfo ci) {
        FeatureStats.phaseStart("oit");
    }

    @Inject(method = "executeOit", at = @At("RETURN"))
    private void quicksilver$featureOitEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeOutline", at = @At("HEAD"))
    private void quicksilver$featureOutline(CallbackInfo ci) {
        FeatureStats.phaseStart("outline");
    }

    @Inject(method = "executeOutline", at = @At("RETURN"))
    private void quicksilver$featureOutlineEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeTranslucentAfterTerrain", at = @At("HEAD"))
    private void quicksilver$featureTranslucentAfterTerrain(CallbackInfo ci) {
        FeatureStats.phaseStart("translucentAfterTerrain");
    }

    @Inject(method = "executeTranslucentAfterTerrain", at = @At("RETURN"))
    private void quicksilver$featureTranslucentAfterTerrainEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeSeeThrough", at = @At("HEAD"))
    private void quicksilver$featureSeeThrough(CallbackInfo ci) {
        FeatureStats.phaseStart("seeThrough");
    }

    @Inject(method = "executeSeeThrough", at = @At("RETURN"))
    private void quicksilver$featureSeeThroughEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }

    @Inject(method = "executeAlwaysOnTop", at = @At("HEAD"))
    private void quicksilver$featureAlwaysOnTop(CallbackInfo ci) {
        FeatureStats.phaseStart("alwaysOnTop");
    }

    @Inject(method = "executeAlwaysOnTop", at = @At("RETURN"))
    private void quicksilver$featureAlwaysOnTopEnd(CallbackInfo ci) {
        FeatureStats.phaseEnd();
    }
}
