package com.meakaandre.quicksilver.occlusion;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.CompiledRenderPipeline;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTexture;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.OptionalDouble;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.resources.Identifier;
import org.joml.Vector4f;

/**
 * The GPU half of package 2b's depth pyramid, through renderpearl only (both backends): one draw renders level 0 (the
 * farthest depth of each 16x16 tile of the frame's depth image, as raw float bits in an RGBA8 texture, so no float
 * render target is needed), and one copy brings it into a buffer the CPU maps. The levels above are built on the CPU
 * ({@link DepthPyramid}), a few hundred texels.
 *
 * <p>Also a one-off calibration: which direction of normalized y the backend puts in the first row of a texture it
 * renders (OpenGL and Vulkan differ), from a 2x2 render of known halves. And, for CI's occlusion check only, a
 * full-size RGBA8 target to draw culled sections into.
 */
final class PyramidGpu {
    private static final Identifier FULLSCREEN = Identifier.fromNamespaceAndPath("quicksilver", "core/qs_fullscreen");
    private static RenderPipeline maxPipeline, minPipeline, calibratePipeline;

    private GpuTexture target;
    private GpuTextureView targetView;
    private int tw, th;
    /** Readback buffers: one waited on in the frame (two-phase), one read when the GPU is done (still camera). */
    private GpuBuffer waited, async;
    private boolean asyncPending;
    /** Level 0 texels read back, and how many pyramids have been read since start-up. */
    long readBytes;

    static synchronized void buildPipelines() {
        if (maxPipeline != null) return;
        maxPipeline = depthPipeline("qs_depth_max", false);
        minPipeline = depthPipeline("qs_depth_min", true);
        calibratePipeline = RenderPipeline.builder()
            .withLocation(Identifier.fromNamespaceAndPath("quicksilver", "pipeline/qs_calibrate"))
            .withVertexShader(FULLSCREEN)
            .withFragmentShader(Identifier.fromNamespaceAndPath("quicksilver", "core/qs_calibrate"))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .withDepthStencilState(Optional.empty())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, ColorTargetState.DEFAULT.writeMask()))
            .build();
    }

    private static RenderPipeline depthPipeline(String name, boolean nearest) {
        RenderPipeline.Builder b = RenderPipeline.builder()
            .withLocation(Identifier.fromNamespaceAndPath("quicksilver", "pipeline/" + name))
            .withVertexShader(FULLSCREEN)
            .withFragmentShader(Identifier.fromNamespaceAndPath("quicksilver", "core/qs_depth_tile"))
            .withBindGroupLayout(BindGroupLayouts.SAMPLER0)
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .withDepthStencilState(Optional.empty())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, ColorTargetState.DEFAULT.writeMask()));
        if (nearest) b.withShaderDefine("QS_NEAREST");
        return b.build();
    }

    /** Null if every pipeline compiles (no render pass may be open), else what failed. */
    static String compileAll() {
        buildPipelines();
        for (RenderPipeline p : new RenderPipeline[] {maxPipeline, minPipeline, calibratePipeline}) {
            try {
                if (RenderSystem.getCompiledPipelineNullable(p) == null) return "pipeline " + p.getLocation() + " did not compile";
            } catch (Throwable t) {
                return "pipeline " + p.getLocation() + " did not compile: " + t;
            }
        }
        return null;
    }

    private static CompiledRenderPipeline compiled(RenderPipeline p) {
        CompiledRenderPipeline c = RenderSystem.getCompiledPipelineNullable(p);
        if (c == null) throw new IllegalStateException("pipeline " + p.getLocation() + " did not compile");
        return c;
    }

    private void ensure(GpuDevice device, int width, int height) {
        int w = DepthPyramid.tiles(width), h = DepthPyramid.tiles(height);
        if (target != null && w == tw && h == th) return;
        // a readback still on its way is dropped (its callback sees the buffer was replaced)
        asyncPending = false;
        retire(targetView, target, waited, async);
        targetView = null;
        target = null;
        waited = null;
        async = null;
        tw = w;
        th = h;
        target = device.createTexture(() -> "Quicksilver depth pyramid", GpuTexture.USAGE_RENDER_ATTACHMENT | GpuTexture.USAGE_COPY_SRC,
            GpuFormat.RGBA8_UNORM, w, h, 1, 1);
        targetView = device.createTextureView(target);
        long bytes = (long) w * h * 4;
        waited = device.createBuffer(() -> "Quicksilver depth pyramid readback", GpuBuffer.USAGE_MAP_READ | GpuBuffer.USAGE_COPY_DST, bytes);
        async = device.createBuffer(() -> "Quicksilver depth pyramid readback (later)", GpuBuffer.USAGE_MAP_READ | GpuBuffer.USAGE_COPY_DST, bytes);
    }

    boolean asyncPending() {
        return asyncPending;
    }

    /** Renders level 0 from {@code depth} (no pass may be open). The one draw call this adds per pyramid. */
    void render(CommandEncoder encoder, GpuTextureView depth, boolean nearest) {
        GpuDevice device = RenderSystem.getDevice();
        GpuTexture d = depth.texture();
        ensure(device, d.getWidth(0), d.getHeight(0));
        try (RenderPass pass = encoder.createRenderPass(() -> "Quicksilver depth pyramid", targetView, Optional.empty(), null, OptionalDouble.empty())) {
            pass.setPipeline(compiled(nearest ? minPipeline : maxPipeline));
            pass.setUniform("Sampler0", depth, RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST));
            pass.draw(6, 1, 0, 0);
        }
    }

    int tilesWide() {
        return tw;
    }

    int tilesHigh() {
        return th;
    }

    /** Copies level 0 to the waited-on buffer, waits for the GPU (at most {@code timeoutMs}); null on a timeout. */
    float[] readNow(CommandEncoder encoder, long timeoutMs, long[] waitNanos) {
        encoder.copyTextureToBuffer(target, waited, 0, () -> { }, 0);
        var fence = encoder.createFence();
        // renderpearl only waits on a fence whose work was submitted
        encoder.submit();
        long t0 = System.nanoTime();
        boolean done;
        try {
            done = fence.awaitCompletion(timeoutMs);
        } finally {
            fence.close();
        }
        waitNanos[0] = System.nanoTime() - t0;
        if (!done) return null;
        return read(waited);
    }

    /** Copies level 0 to the other buffer; {@code ready} gets it once the GPU is done (render thread). */
    void readLater(CommandEncoder encoder, java.util.function.Consumer<float[]> ready) {
        if (asyncPending) return;
        asyncPending = true;
        GpuBuffer buffer = async;
        encoder.copyTextureToBuffer(target, buffer, 0, () -> {
            if (buffer != async) return; // resized meanwhile
            asyncPending = false;
            float[] v;
            try {
                v = read(buffer);
            } catch (Throwable t) {
                GpuOcclusion.fail("reading the depth pyramid back", t);
                return;
            }
            ready.accept(v);
        }, 0);
    }

    private float[] read(GpuBuffer buffer) {
        int n = tw * th;
        float[] out = new float[n];
        try (var view = buffer.map(true, false)) {
            ByteBuffer b = view.data();
            for (int i = 0; i < n; i++) {
                int o = i * 4;
                int bits = (b.get(o) & 255) | (b.get(o + 1) & 255) << 8 | (b.get(o + 2) & 255) << 16 | (b.get(o + 3) & 255) << 24;
                out[i] = Float.intBitsToFloat(bits);
            }
        }
        readBytes += (long) n * 4;
        return out;
    }

    /** The result of {@link #calibrate}, filled in on the render thread once the GPU has drawn and copied it. */
    static final class Calibration {
        boolean done;
        /** {flipX, flipY}: row 0 / column 0 is the positive half of normalized x / y. */
        boolean[] flip;
        String error;
        /** Whether the CPU could wait for submitted work within the frame (the two-phase path needs it). */
        boolean midFrameWait;
    }

    /**
     * Calibration (once, no pass open): renders a 2x2 texture whose texels say which half of normalized x and y they
     * are in and reads it back when the GPU is done (the copy's callback). Also tries once whether a fence wait within
     * the frame completes (at most {@code waitMs}): on a backend where it does not, the two-phase path is not used.
     */
    static Calibration calibrate(CommandEncoder encoder, long waitMs) {
        GpuDevice device = RenderSystem.getDevice();
        Calibration c = new Calibration();
        GpuTexture t = device.createTexture(() -> "Quicksilver occlusion calibration", GpuTexture.USAGE_RENDER_ATTACHMENT | GpuTexture.USAGE_COPY_SRC,
            GpuFormat.RGBA8_UNORM, 2, 2, 1, 1);
        GpuTextureView v = device.createTextureView(t);
        GpuBuffer b = device.createBuffer(() -> "Quicksilver occlusion calibration readback", GpuBuffer.USAGE_MAP_READ | GpuBuffer.USAGE_COPY_DST, 16);
        try (RenderPass pass = encoder.createRenderPass(() -> "Quicksilver occlusion calibration", v, Optional.of(new Vector4f(0, 0, 0, 0)), null, OptionalDouble.empty())) {
            pass.setPipeline(compiled(calibratePipeline));
            pass.draw(6, 1, 0, 0);
        }
        encoder.copyTextureToBuffer(t, b, 0, () -> {
            try {
                if (!c.done) evaluate(c, b);
            } finally {
                b.close();
                v.close();
                t.close();
            }
        }, 0);
        var fence = encoder.createFence();
        // renderpearl only waits on a fence whose work was submitted
        encoder.submit();
        try {
            c.midFrameWait = fence.awaitCompletion(waitMs);
        } finally {
            fence.close();
        }
        // done already: read now (the callback, whenever it runs, then only frees the objects)
        if (c.midFrameWait) evaluate(c, b);
        return c;
    }

    private static void evaluate(Calibration c, GpuBuffer b) {
        int[][] r = new int[4][2];
        try (var view = b.map(true, false)) {
            ByteBuffer d = view.data();
            for (int i = 0; i < 4; i++) {
                r[i][0] = d.get(i * 4) & 255;
                r[i][1] = d.get(i * 4 + 1) & 255;
            }
        } catch (RuntimeException e) {
            c.error = "the calibration render could not be read back: " + e;
            c.done = true;
            return;
        }
        // texel i: column i & 1, row i >> 1; red = positive x half, green = positive y half
        boolean flipX = r[0][0] > 127, flipY = r[0][1] > 127;
        for (int i = 0; i < 4; i++) {
            boolean xPos = ((i & 1) == 0) == flipX, yPos = ((i >> 1) == 0) == flipY;
            if ((r[i][0] > 127) != xPos || (r[i][1] > 127) != yPos) {
                c.error = "the calibration render read back wrong: red/green per texel " + java.util.Arrays.deepToString(r);
                c.done = true;
                return;
            }
        }
        c.flip = new boolean[] {flipX, flipY};
        c.done = true;
    }

    // GPU objects replaced on a resize may still be used by submitted work (a readback on its way): closed a few frames later
    private record Retired(long frame, AutoCloseable[] objects) {
    }

    private final java.util.ArrayDeque<Retired> retired = new java.util.ArrayDeque<>();
    private long frames;

    private void retire(AutoCloseable... objects) {
        retired.add(new Retired(frames, objects));
    }

    /** Render thread, once a frame: closes what was retired more than three frames ago. */
    void frame() {
        frames++;
        if (checkPending && ++checkFrames > 600) {
            // never read back: a timeout, and the target and buffer are replaced (the copy may still be using them)
            checkPending = false;
            retire(checkView, checkTarget, checkBuffer);
            checkView = null;
            checkTarget = null;
            checkBuffer = null;
            cw = ch = -1;
            checkResult.accept(-1);
        }
        while (!retired.isEmpty() && frames - retired.peek().frame() > 3) {
            for (AutoCloseable c : retired.poll().objects()) {
                if (c == null) continue;
                try {
                    c.close();
                } catch (Exception ignored) {
                    // closing a GPU object does not fail in practice; nothing else to do with it
                }
            }
        }
    }

    void close() {
        if (targetView != null) targetView.close();
        if (target != null) target.close();
        if (waited != null) waited.close();
        if (async != null) async.close();
        targetView = null;
        target = null;
        waited = null;
        async = null;
    }

    // --- CI's occlusion check: a full-size RGBA8 target the culled sections are drawn into ---

    private GpuTexture checkTarget;
    private GpuTextureView checkView;
    private GpuBuffer checkBuffer;
    private int cw, ch;

    GpuTextureView checkTarget(int width, int height) {
        if (checkTarget == null || cw != width || ch != height) {
            retire(checkView, checkTarget, checkBuffer);
            GpuDevice device = RenderSystem.getDevice();
            cw = width;
            ch = height;
            checkTarget = device.createTexture(() -> "Quicksilver occlusion check", GpuTexture.USAGE_RENDER_ATTACHMENT | GpuTexture.USAGE_COPY_SRC,
                GpuFormat.RGBA8_UNORM, width, height, 1, 1);
            checkView = device.createTextureView(checkTarget);
            checkBuffer = device.createBuffer(() -> "Quicksilver occlusion check readback", GpuBuffer.USAGE_MAP_READ | GpuBuffer.USAGE_COPY_DST,
                (long) width * height * 4);
        }
        return checkView;
    }

    /** What the check target is cleared to (RGBA8 51, 102, 153, 204): a value terrain's colour is never expected to be. */
    static final org.joml.Vector4f CHECK_CLEAR = new org.joml.Vector4f(0.2f, 0.4f, 0.6f, 0.8f);
    private static final int CHECK_CLEAR_BITS = 51 | 102 << 8 | 153 << 16 | 204 << 24;

    // a check read back when the GPU is done (the copy's callback); the next check waits until then
    private boolean checkPending;
    private int checkFrames;
    private java.util.function.LongConsumer checkResult;

    boolean checkPending() {
        return checkPending;
    }

    /**
     * Copies the check target back; {@code result} gets the pixels something was drawn into (any byte changed from the
     * clear) once the GPU is done, or -1 if it never is (600 frames).
     */
    void checkPixelsLater(CommandEncoder encoder, java.util.function.LongConsumer result) {
        checkPending = true;
        checkFrames = 0;
        checkResult = result;
        GpuBuffer buffer = checkBuffer;
        int px = cw * ch;
        encoder.copyTextureToBuffer(checkTarget, buffer, 0, () -> {
            if (buffer != checkBuffer || !checkPending) return; // given up on, or replaced meanwhile
            checkPending = false;
            long n = 0;
            try (var view = buffer.map(true, false)) {
                ByteBuffer d = view.data();
                d.order(java.nio.ByteOrder.LITTLE_ENDIAN);
                for (int i = 0; i < px; i++) if (d.getInt(i * 4) != CHECK_CLEAR_BITS) n++;
            }
            result.accept(n);
        }, 0);
    }
}
