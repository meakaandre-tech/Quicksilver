package com.meakaandre.quicksilver.mixin.counters;

import com.meakaandre.quicksilver.entity.FeatureStats;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import net.minecraft.client.renderer.StagedVertexBuffer;
import net.minecraft.client.renderer.rendertype.PreparedRenderType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 6 measurement ({@link FeatureStats}): every feature draw goes through here (plain and Improved
 * Transparency alike), just before the render pass call. Count only.
 */
@Mixin(PreparedRenderType.class)
public abstract class PreparedRenderTypeMixin {
    @Inject(method = "draw", at = @At("HEAD"))
    private void quicksilver$featureDraw(StagedVertexBuffer.ExecuteInfo info, RenderPass pass, RenderPipeline pipeline, CallbackInfo ci) {
        FeatureStats.draw((PreparedRenderType) (Object) this, info, pipeline);
    }
}
