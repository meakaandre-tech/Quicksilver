package com.meakaandre.quicksilver.mixin.counters;

import com.meakaandre.quicksilver.entity.FeatureStats;
import net.minecraft.client.renderer.feature.FeatureRendererType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 6 measurement ({@link FeatureStats}): which feature type's group is executing, and whether vanilla marked it
 * strictly ordered. Count only.
 */
@Mixin(targets = "net.minecraft.client.renderer.feature.FeatureRenderDispatcher$PreparedGroup")
public abstract class FeatureGroupMixin {
    @Shadow
    @Final
    private FeatureRendererType<?> featureType;

    @Shadow
    @Final
    private boolean strictlyOrdered;

    @Inject(method = "execute", at = @At("HEAD"))
    private void quicksilver$featureGroup(CallbackInfo ci) {
        FeatureStats.group(featureType == null ? null : featureType.name(), strictlyOrdered);
    }
}
