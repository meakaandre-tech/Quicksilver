package com.meakaandre.quicksilver.mixin.occlusion;

import com.meakaandre.quicksilver.occlusion.GpuOcclusion;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.commands.RenderPassDescriptor;
import com.mojang.renderpearl.frontend.FrontendCommandEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** Package 2b: the descriptor of each render pass created, so vanilla's main pass can be re-opened on its attachments. */
@Mixin(FrontendCommandEncoder.class)
public abstract class RenderPassDescriptorMixin {
    @Inject(method = "createRenderPass(Lcom/mojang/renderpearl/api/commands/RenderPassDescriptor;)Lcom/mojang/renderpearl/api/commands/RenderPass;",
        at = @At("HEAD"))
    private void quicksilver$descriptor(RenderPassDescriptor descriptor, CallbackInfoReturnable<RenderPass> cir) {
        GpuOcclusion.descriptor(descriptor);
    }
}
