package com.meakaandre.quicksilver.terrain;

import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.lights.DynamicLights;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.commands.RenderPass;
import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryUtil;

/**
 * Package 13: dynamic lights on Quicksilver's terrain. While the setting is on and a light is near, terrain is drawn with
 * the lit pipelines ({@link TerrainPipelines#pipeline(boolean, boolean, boolean)}: the same shaders with
 * {@code QUICKSILVER_DYNLIGHTS}) and the frame's light block bound; otherwise with the ordinary ones, so with it off
 * nothing differs. Render thread.
 */
public final class TerrainLights {
    private TerrainLights() {
    }

    private static GpuBuffer ubo;
    private static ByteBuffer scratch;
    private static boolean on, broken;
    private static int loggedLevel;
    public static volatile long litFrames;

    /** This frame: draw terrain lit? */
    static boolean on() {
        return on;
    }

    /** Once a frame, while terrain draws are prepared: finds the lights and writes their block. */
    static void prepare(GpuDevice device, float partialTick) {
        on = false;
        if (broken) return;
        DynamicLights.beginFrame(partialTick);
        if (DynamicLights.level() == DynamicLights.OFF) loggedLevel = 0;
        if (!DynamicLights.terrainThisFrame()) return;
        try {
            // every lit frame (cheap once compiled; after a resource reload this compiles them again before the pass)
            String problem = TerrainPipelines.compileLit();
            if (problem != null) {
                broken = true;
                QuicksilverClient.LOG.error("Quicksilver dynamic lights: terrain stays unlit for this session ({})", problem);
                return;
            }
            if (ubo == null) {
                ubo = device.createBuffer(() -> "Quicksilver dynamic lights", GpuBuffer.USAGE_UNIFORM | GpuBuffer.USAGE_COPY_DST, DynamicLights.UBO_BYTES);
            }
            if (scratch == null) scratch = MemoryUtil.memAlloc(DynamicLights.UBO_BYTES);
            if (!DynamicLights.write(scratch)) return;
            device.createCommandEncoder().writeToBuffer(ubo.slice(), scratch);
            on = true;
            litFrames++;
            int level = DynamicLights.level();
            if (level != loggedLevel) {
                loggedLevel = level;
                QuicksilverClient.LOG.info("Quicksilver dynamic lights: terrain drawn lit ({} lights, {})", DynamicLights.count(), level == DynamicLights.FAST ? "fast" : "fancy");
            }
        } catch (Throwable t) {
            broken = true;
            QuicksilverClient.LOG.error("Quicksilver dynamic lights: terrain stays unlit for this session", t);
        }
    }

    /** After a lit pipeline is set: binds the frame's light block. */
    static void bind(RenderPass pass) {
        pass.setUniform("QsLights", ubo);
    }
}
