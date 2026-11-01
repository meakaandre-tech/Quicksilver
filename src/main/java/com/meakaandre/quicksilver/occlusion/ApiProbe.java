package com.meakaandre.quicksilver.occlusion;

// Package 2b, temporary: deliberately wrong calls so the compiler lists the exact renderpearl and vanilla signatures
// this package needs (no class dump reaches the agent workspace). Removed before the package's first real build.
@SuppressWarnings("all")
final class ApiProbe {
    void e1(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.createRenderPass(); }
    void e2(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.copyTextureToBuffer(); }
    void e3(com.mojang.renderpearl.api.commands.CommandEncoder e) { Void v = e.createFence(); }
    void e4(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.writeToBuffer(); }
    void e5(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.copyTextureToTexture(); }
    void e6(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.clearColorTexture(); }
    void e7(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.submit(); }
    void e8(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.copyToBuffer(); }
    void e9(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.copyBufferToTexture(); }
    void e10(com.mojang.renderpearl.api.commands.CommandEncoder e) { e.flush(); }

    void d1(com.mojang.renderpearl.api.device.GpuDevice d) { d.createTexture(); }
    void d2(com.mojang.renderpearl.api.device.GpuDevice d) { d.createTextureView(); }
    void d3(com.mojang.renderpearl.api.device.GpuDevice d) { d.createBuffer(); }
    void d4(com.mojang.renderpearl.api.device.GpuDevice d) { d.createSampler(); }
    void d5(com.mojang.renderpearl.api.device.GpuDevice d) { Void v = d.isZZeroToOne(); }
    void d6(com.mojang.renderpearl.api.device.DeviceInfo i) { Void v = i.isZZeroToOne(); }
    void d7(com.mojang.renderpearl.api.device.DeviceFeatures f) { Void v = f.zZeroToOne(); }
    void d8(com.mojang.renderpearl.api.device.DeviceInfo i) { Void v = i.limits(); }
    void d9(com.mojang.renderpearl.api.device.GpuDevice d) { Void v = d.createCommandEncoder(); }

    void u1() { int u = com.mojang.renderpearl.api.buffers.GpuBuffer.USAGE_MAP_READ; }
    void u2() { int u = com.mojang.renderpearl.api.buffers.GpuBuffer.USAGE_INDIRECT; }
    void u3() { int u = com.mojang.renderpearl.api.buffers.GpuBuffer.USAGE_COPY_DST; }
    void u4() { int u = com.mojang.renderpearl.api.textures.GpuTexture.USAGE_TEXTURE_BINDING; }
    void u5() { int u = com.mojang.renderpearl.api.textures.GpuTexture.USAGE_RENDER_ATTACHMENT; }
    void u6() { int u = com.mojang.renderpearl.api.textures.GpuTexture.USAGE_COPY_SRC; }
    void u7() { int u = com.mojang.renderpearl.api.textures.GpuTexture.USAGE_COPY_DST; }

    void t1(com.mojang.renderpearl.api.textures.GpuTexture t) { Void v = t.getFormat(); }
    void t2(com.mojang.renderpearl.api.textures.GpuTexture t) { Void v = t.getWidth(0); }
    void t3(com.mojang.renderpearl.api.textures.GpuTextureView v) { Void x = v.texture(); }
    void t4(com.mojang.renderpearl.api.textures.GpuTexture t) { Void v = t.usage(); }
    void t5(com.mojang.renderpearl.api.textures.GpuTexture t) { Void v = t.getHeight(0); }
    void t6(com.mojang.renderpearl.api.textures.GpuTexture t) { Void v = t.getLabel(); }

    void m1(net.minecraft.client.Minecraft mc) { Void v = mc.getMainRenderTarget(); }
    void m2(com.mojang.blaze3d.pipeline.RenderTarget rt) { Void v = rt.getDepthTexture(); }
    void m3(com.mojang.blaze3d.pipeline.RenderTarget rt) { Void v = rt.getDepthTextureView(); }
    void m4(com.mojang.blaze3d.pipeline.RenderTarget rt) { Void v = rt.getColorTexture(); }
    void m5(com.mojang.blaze3d.pipeline.RenderTarget rt) { Void v = rt.width; }

    void p1(com.mojang.renderpearl.api.commands.RenderPass p) { p.setUniform(); }
    void p2(com.mojang.renderpearl.api.commands.RenderPass p) { p.draw(); }
    void p3(com.mojang.renderpearl.api.commands.RenderPass p) { p.bindTexture(); }
    void p4(com.mojang.renderpearl.api.commands.RenderPass p) { p.enableScissor(); }
    void p5(com.mojang.renderpearl.api.commands.RenderPass p) { p.setPipeline(); }
    void p6(com.mojang.renderpearl.api.commands.RenderPass p) { p.setVertexBuffer(); }
    void p7(com.mojang.renderpearl.api.commands.RenderPass p) { p.pushDebugGroup(); }
    void p8(com.mojang.renderpearl.api.commands.RenderPass p) { p.setPushConstants(); }

    void b1() { com.mojang.renderpearl.api.pipeline.BindGroupLayout.builder().withSampler(); }
    void b2() { com.mojang.renderpearl.api.pipeline.BindGroupLayout.builder().withTexture(); }
    void b3() { com.mojang.renderpearl.api.pipeline.BindGroupLayout.builder().withUniform(); }
    void b4() { Void v = com.mojang.renderpearl.api.pipeline.UniformType.SAMPLER; }
    void b5() { Void v = com.mojang.renderpearl.api.pipeline.UniformType.TEXEL_BUFFER; }
    void b6() { Void v = net.minecraft.client.renderer.BindGroupLayouts.SAMPLER0; }

    void s1() { new com.mojang.renderpearl.api.pipeline.DepthStencilState(); }
    void s2() { new com.mojang.renderpearl.api.pipeline.ColorTargetState(); }
    void s3() { Void v = net.minecraft.client.renderer.SamplerCache.getClampToEdge(); }
    void s4() { Void v = com.mojang.blaze3d.systems.RenderSystem.getSamplerCache(); }
    void s5(net.minecraft.client.renderer.SamplerCache c) { c.getClampToEdge(); }
    void s6() { com.mojang.renderpearl.api.pipeline.RenderPipeline.builder().withDepthStencilState(); }
    void s7() { com.mojang.renderpearl.api.pipeline.RenderPipeline.builder().withColorTargetState(); }
    void s8() { com.mojang.renderpearl.api.pipeline.RenderPipeline.builder().withVertexBinding(); }

    void f1(com.mojang.renderpearl.api.buffers.GpuBuffer b) { b.map(); }
    void f2(com.mojang.renderpearl.api.buffers.GpuBufferSlice.MappedView m) { Void v = m.data(); }

    void g1(net.minecraft.client.renderer.GameRenderer g) { g.renderLevel(); }
    void g2(net.minecraft.client.renderer.CachedPerspectiveProjectionMatrixBuffer c) { c.getBuffer(); }
    void g3(net.minecraft.client.renderer.PerspectiveProjectionMatrixBuffer c) { c.getBuffer(); }
    void g4(net.minecraft.client.renderer.ProjectionMatrixBuffer c) { c.getBuffer(); }
    void g5() { Void v = com.mojang.blaze3d.systems.RenderSystem.getModelViewMatrix(); }
    void g6() { Void v = com.mojang.blaze3d.systems.RenderSystem.getProjectionMatrixBuffer(); }
    void g7() { com.mojang.blaze3d.systems.RenderSystem.setProjectionMatrix(); }

    void l1(net.minecraft.client.renderer.LevelRenderer l) { l.render(); }
    void l2(net.minecraft.client.renderer.LevelRenderer l) { l.executeSolid(); }
    void l3(net.minecraft.client.renderer.LevelRenderer l) { l.addMainPass(); }
    void l4(net.minecraft.client.renderer.chunk.ChunkSectionsToRender c) { c.renderGroup(); }
    void l5() { Void v = net.minecraft.client.renderer.chunk.ChunkSectionLayerGroup.OPAQUE; }
    void l6(net.minecraft.client.renderer.LevelRenderer l) { l.executeClassicTransparency(); }
    void l7() { com.mojang.blaze3d.systems.RenderSystem.bindDefaultUniforms(); }
}
