package com.meakaandre.quicksilver.mixin.look;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.renderpearl.api.GpuFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Package 11: a render target's formats (the pixel art look's small target takes the main target's). */
@Mixin(RenderTarget.class)
public interface RenderTargetAccessor {
    @Accessor("colorFormat")
    GpuFormat quicksilver$colorFormat();

    @Accessor("depthFormat")
    GpuFormat quicksilver$depthFormat();
}
