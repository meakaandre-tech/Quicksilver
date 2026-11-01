package com.meakaandre.quicksilver.mixin.occlusion;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.meakaandre.quicksilver.occlusion.GpuOcclusion;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayerGroup;
import net.minecraft.client.renderer.chunk.ChunkSectionsToRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 2b: vanilla's main pass (created in a lambda of {@code addMainPass}) is wrapped so Quicksilver can close and
 * re-open it after the opaque terrain group, and Quicksilver's occlusion work runs right after that group.
 */
@Mixin(LevelRenderer.class)
public abstract class MainPassMixin {
    @Inject(method = {"lambda$addMainPass$0", "lambda$addMainPass$1", "lambda$addMainPass$2"},
        at = @At(value = "INVOKE", target = "Lcom/mojang/renderpearl/api/commands/CommandEncoder;createRenderPass"))
    private void quicksilver$beforeMainPass(CallbackInfo ci) {
        GpuOcclusion.beforeMainPass();
    }

    @ModifyExpressionValue(method = {"lambda$addMainPass$0", "lambda$addMainPass$1", "lambda$addMainPass$2"},
        at = @At(value = "INVOKE", target = "Lcom/mojang/renderpearl/api/commands/CommandEncoder;createRenderPass"))
    private RenderPass quicksilver$mainPass(RenderPass original) {
        return GpuOcclusion.mainPass(original);
    }

    @WrapOperation(method = "executeSolid", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/renderer/chunk/ChunkSectionsToRender;renderGroup(Lnet/minecraft/client/renderer/chunk/ChunkSectionLayerGroup;Lcom/mojang/renderpearl/api/commands/RenderPass;Lcom/mojang/renderpearl/api/textures/GpuSampler;Lcom/mojang/renderpearl/api/textures/GpuTextureView;Z)V"))
    private void quicksilver$afterOpaque(ChunkSectionsToRender self, ChunkSectionLayerGroup group, RenderPass pass, GpuSampler sampler,
                                         GpuTextureView atlas, boolean wireframe, Operation<Void> original) {
        original.call(self, group, pass, sampler, atlas, wireframe);
        if (group == ChunkSectionLayerGroup.OPAQUE) GpuOcclusion.afterOpaque(pass, wireframe);
    }
}
