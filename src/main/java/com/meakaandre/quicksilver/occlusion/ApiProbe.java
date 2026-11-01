package com.meakaandre.quicksilver.occlusion;

// Package 2b, temporary: deliberately wrong calls so the compiler lists the exact renderpearl and vanilla signatures
// this package needs (no class dump reaches the agent workspace). Removed before the package's first real build.
@SuppressWarnings("all")
final class ApiProbe {
    void f1(com.mojang.renderpearl.api.commands.CommandEncoder e) { var f = e.createFence(); f.awaitCompletion(); }
    void f2(com.mojang.renderpearl.api.commands.CommandEncoder e) { var f = e.createFence(); Void v = f.close(); }
    void f3(com.mojang.renderpearl.api.commands.CommandEncoder e) { var f = e.createFence(); Void v = f.isCompleted(); }
    void f4(com.mojang.renderpearl.api.commands.CommandEncoder e) { Void v = e.createFence(); }

    void d1() { new com.mojang.renderpearl.api.commands.RenderPassDescriptor(); }
    void d2() { new com.mojang.renderpearl.api.commands.RenderArea(); }
    void d3(com.mojang.renderpearl.api.commands.RenderPassDescriptor d) { Void v = d.label(); }
    void d4(com.mojang.renderpearl.api.commands.RenderPassDescriptor d) { Void v = d.colorAttachment(); }
    void d5(com.mojang.renderpearl.api.commands.RenderPassDescriptor d) { Void v = d.depthAttachment(); }

    void b1(com.mojang.renderpearl.api.buffers.GpuBuffer b) { Void v = b.usage(); }
    void b2() { int u = com.mojang.renderpearl.api.buffers.GpuBuffer.USAGE_INDIRECT_BUFFER; }
    void b3() { int u = com.mojang.renderpearl.api.buffers.GpuBuffer.USAGE_DRAW_INDIRECT; }
    void b4(com.mojang.renderpearl.api.buffers.GpuBuffer b) { Void v = b.size(); }
    void b5(com.mojang.renderpearl.api.buffers.GpuBuffer b) { Void v = b.isClosed(); }

    void s1() { com.mojang.blaze3d.systems.RenderSystem.getSamplerCache().getClampToEdge(); }
    void s2() { Void v = com.mojang.renderpearl.api.textures.FilterMode.NEAREST; }
    void s3() { Void v = com.mojang.renderpearl.api.textures.AddressMode.CLAMP_TO_EDGE; }
    void s4() { Void v = com.mojang.renderpearl.api.pipeline.DepthStencilState.DEFAULT.depthTest(); }
    void s5() { Void v = com.mojang.renderpearl.api.pipeline.DepthStencilState.DEFAULT.compareOp(); }
    void s6() { Void v = com.mojang.renderpearl.api.pipeline.DepthStencilState.DEFAULT.writeDepth(); }
    void s7() { Void v = com.mojang.renderpearl.api.pipeline.DepthStencilState.DEFAULT.depthWrite(); }
    void s8() { Void v = com.mojang.renderpearl.api.pipeline.ColorTargetState.DEFAULT.format(); }
    void s9() { Void v = com.mojang.renderpearl.api.pipeline.ColorTargetState.DEFAULT.writeMask(); }
    void s10() { Void v = com.mojang.renderpearl.api.pipeline.DepthStencilState.DEFAULT; }
    void s11() { Void v = com.mojang.renderpearl.api.GpuFormat.RGBA8_UNORM; }
    void s12() { Void v = com.mojang.renderpearl.api.pipeline.UniformType.SAMPLED_TEXTURE; }
    void s13() { Void v = com.mojang.renderpearl.api.pipeline.UniformType.TEXTURE; }
    void s14() { Void v = com.mojang.renderpearl.api.pipeline.UniformType.SAMPLER2D; }

    void c1(net.minecraft.client.renderer.state.CameraRenderState s) { Void v = s.projectionMatrix; }
    void c2(net.minecraft.client.renderer.state.CameraRenderState s) { Void v = s.viewRotationMatrix; }
    void c3(net.minecraft.client.renderer.state.CameraRenderState s) { Void v = s.pos; }
    void c4(net.minecraft.client.renderer.state.CameraRenderState s) { Void v = s.cullFrustum; }
    void c5(net.minecraft.client.renderer.Projection p) { Void v = p.getMatrix(); }
    void c6(net.minecraft.client.renderer.ProjectionMatrixBuffer p) { Void v = p.getBuffer((org.joml.Matrix4f) null); }
    void c7() { Void v = com.mojang.blaze3d.systems.RenderSystem.getProjectionType(); }
    void c8(net.minecraft.client.Minecraft mc) { Void v = mc.gameRenderer; }
    void c9(net.minecraft.client.renderer.GameRenderer g) { Void v = g.getMainRenderTarget(); }
    void c10(net.minecraft.client.Minecraft mc) { Void v = mc.getWindow(); }
    void c11() { Void v = com.mojang.renderpearl.api.ProjectionType.PERSPECTIVE; }
}
