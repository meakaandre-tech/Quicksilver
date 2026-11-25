package com.meakaandre.quicksilver.lights;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.speed.Speed;
import java.nio.ByteBuffer;
import java.util.Arrays;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;

/**
 * Package 13: dynamic lights (design doc, "Dynamic lights"; the idea of LambDynamicLights, none of its code). A light
 * setting, off by default: held and dropped light sources, burning and glowing mobs and lit projectiles light the world
 * around them as they move.
 *
 * <p>How: once a frame (render thread) the light-giving entities near the camera are found and the nearest few kept
 * (Fast: 8, Fancy: 32); their positions and levels go to the GPU in one small uniform block. Quicksilver's terrain
 * vertex shader adds their light on top of each vertex's block light before it looks up the lightmap, so no chunk is
 * re-meshed when a light moves. Fancy also lights entities and block entities: each one's light value (the one their
 * shaders look the lightmap up with) is raised by the lights at its centre, the same rule at one point.
 *
 * <p>The rule: a light of level L at distance d (blocks, straight line) gives L - d, as vanilla's block light falls off by
 * one a block; a vertex takes the larger of its block light and the brightest dynamic light, never less than before.
 * Sky light is left alone. With the setting off nothing here runs: the terrain pipelines without lights are the ones
 * drawn, and no light value is touched (the picture is the normal one exactly).
 */
public final class DynamicLights {
    private DynamicLights() {
    }

    public static final int OFF = 0, FAST = 1, FANCY = 2;
    /** Most lights a frame can hold (Fancy); the shader's array. */
    public static final int MAX = 32;
    /** Lights per level. */
    static int limit(int level) {
        return level >= FANCY ? 32 : level == FAST ? 8 : 0;
    }

    /** Lights farther than this from the camera are not looked at (blocks; a level-15 light reaches 15 blocks). */
    static final double RANGE = 64;
    /** std140: vec4 box min (w: count), vec4 box max, then MAX vec4 (camera-relative position, level). */
    public static final int UBO_BYTES = 32 + MAX * 16;

    // this frame's lights (render thread): world position (relative to the camera they were found from, plus that
    // camera's position: cx/cy/cz below) and level, nearest first
    private static final float[] LX = new float[MAX], LY = new float[MAX], LZ = new float[MAX], LL = new float[MAX];
    private static int count;
    private static double camX, camY, camZ;
    private static long frame = -1;
    private static int levelThisFrame;
    private static boolean failed;

    // candidates (reused)
    private static double[] cd = new double[64];
    private static double[] wx = new double[64], wy = new double[64], wz = new double[64];
    private static float[] cl = new float[64];
    private static final double[] LWX = new double[MAX], LWY = new double[MAX], LWZ = new double[MAX];
    private static Integer[] order = new Integer[64];

    // bench counters (render thread)
    private static long windowFrames, windowLights, windowCandidates, windowNanos, windowNanosMax, windowEntitiesLit, windowBlockEntitiesLit;

    /** The setting: 0 off, 1 Fast, 2 Fancy. */
    public static int level() {
        return failed ? OFF : Speed.DYNAMIC_LIGHTS.value();
    }

    /** Whether terrain draws with lights this frame (the lit pipelines and the light block). */
    public static boolean terrainThisFrame() {
        return levelThisFrame > 0 && count > 0;
    }

    /** Whether entities and block entities take lights this frame (Fancy). */
    static boolean objectsThisFrame() {
        return levelThisFrame >= FANCY && count > 0;
    }

    /**
     * Once a frame, before the frame's entities and terrain are prepared (render thread): finds this frame's lights.
     * Safe to call more than once a frame (only the first call works).
     */
    public static void beginFrame(float partialTick) {
        long f = com.meakaandre.quicksilver.bench.FrameRecorder.presents();
        if (f == frame) return;
        frame = f;
        int level = level();
        levelThisFrame = level;
        count = 0;
        if (level == OFF || !Speed.cameraKnown()) return;
        long t0 = System.nanoTime();
        try {
            collect(level, partialTick);
        } catch (Throwable t) {
            failed = true;
            count = 0;
            levelThisFrame = OFF;
            QuicksilverClient.LOG.error("Quicksilver dynamic lights failed and switched off for this session", t);
            return;
        }
        long dt = System.nanoTime() - t0;
        if (com.meakaandre.quicksilver.bench.GpuCounters.enabled) {
            windowFrames++;
            windowLights += count;
            windowNanos += dt;
            windowNanosMax = Math.max(windowNanosMax, dt);
        }
    }

    private static void collect(int level, float partialTick) {
        Minecraft mc = Minecraft.getInstance();
        ClientLevel world = mc.level;
        if (world == null) return;
        camX = Speed.camX;
        camY = Speed.camY;
        camZ = Speed.camZ;
        int n = 0;
        for (Entity e : world.entitiesForRendering()) {
            int l = light(e);
            if (l <= 0) continue;
            Vec3 p = e.getPosition(partialTick);
            double x = p.x, y = p.y + e.getBbHeight() * centreHeight(e), z = p.z;
            double dx = x - camX, dy = y - camY, dz = z - camZ;
            double d2 = dx * dx + dy * dy + dz * dz;
            if (d2 > RANGE * RANGE) continue;
            if (n == cd.length) grow();
            cd[n] = d2;
            wx[n] = x;
            wy[n] = y;
            wz[n] = z;
            cl[n] = l;
            n++;
        }
        if (com.meakaandre.quicksilver.bench.GpuCounters.enabled) windowCandidates += n;
        int keep = Math.min(n, limit(level));
        if (n > keep) {
            for (int i = 0; i < n; i++) order[i] = i;
            final double[] d = cd;
            Arrays.sort(order, 0, n, (a, b) -> Double.compare(d[a], d[b]));
        } else {
            for (int i = 0; i < n; i++) order[i] = i;
        }
        for (int i = 0; i < keep; i++) {
            int j = order[i];
            LWX[i] = wx[j];
            LWY[i] = wy[j];
            LWZ[i] = wz[j];
            LL[i] = cl[j];
        }
        count = keep;
    }

    private static void grow() {
        int m = cd.length * 2;
        cd = Arrays.copyOf(cd, m);
        wx = Arrays.copyOf(wx, m);
        wy = Arrays.copyOf(wy, m);
        wz = Arrays.copyOf(wz, m);
        cl = Arrays.copyOf(cl, m);
        order = Arrays.copyOf(order, m);
    }

    /** Where on an entity its light sits, as a share of its height: a held item at the hands, anything else its middle. */
    private static double centreHeight(Entity e) {
        return e instanceof LivingEntity ? 0.6 : 0.5;
    }

    /** The light an entity gives (0-15): burning 15, its type's own (data), what it holds, or the item it is. */
    static int light(Entity e) {
        if (e.isRemoved() || e.isSpectator()) return 0;
        int l = LightData.entity(e.getType());
        if (e.displayFireAnimation()) l = 15;
        if (l >= 15) return 15;
        if (e instanceof LivingEntity le) {
            l = Math.max(l, Math.max(LightData.item(le.getMainHandItem()), LightData.item(le.getOffhandItem())));
        } else if (e instanceof ItemEntity it) {
            l = Math.max(l, LightData.item(it.getItem()));
        }
        return l;
    }

    /**
     * The brightest dynamic light at a point (world coordinates), 0-15, fractional; 0 when there are no lights this
     * frame. The same rule as the terrain shader's.
     */
    static float at(double x, double y, double z) {
        float best = 0;
        for (int i = 0; i < count; i++) {
            double dx = x - LWX[i], dy = y - LWY[i], dz = z - LWZ[i];
            float v = LL[i] - (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (v > best) best = v;
        }
        return Math.min(15f, best);
    }

    /**
     * Fancy: an entity's or block entity's light value raised by the lights at a point (its centre). Block light is in
     * the low 16 bits as 16 steps a level (vanilla's packing); sky light is kept.
     */
    public static int raise(int lightCoords, double x, double y, double z, boolean blockEntity) {
        if (!objectsThisFrame()) return lightCoords;
        float d = at(x, y, z);
        if (d <= 0) return lightCoords;
        int block = lightCoords & 0xFFFF;
        int dyn = Math.min(240, (int) (d * 16f));
        if (dyn <= block) return lightCoords;
        if (com.meakaandre.quicksilver.bench.GpuCounters.enabled) {
            if (blockEntity) windowBlockEntitiesLit++;
            else windowEntitiesLit++;
        }
        return (lightCoords & 0xFFFF0000) | dyn;
    }

    /**
     * The terrain shader's light block for this frame: the box (camera-relative) where any light reaches, with the count
     * in its first w, then each light. Returns false when there is nothing to draw with.
     */
    public static boolean write(ByteBuffer b) {
        if (count == 0) return false;
        // relative to the camera the terrain is drawn from (read now, not when the lights were found)
        for (int i = 0; i < count; i++) {
            LX[i] = (float) (LWX[i] - Speed.camX);
            LY[i] = (float) (LWY[i] - Speed.camY);
            LZ[i] = (float) (LWZ[i] - Speed.camZ);
        }
        float minX = Float.MAX_VALUE, minY = Float.MAX_VALUE, minZ = Float.MAX_VALUE;
        float maxX = -Float.MAX_VALUE, maxY = -Float.MAX_VALUE, maxZ = -Float.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            float r = LL[i];
            minX = Math.min(minX, LX[i] - r);
            minY = Math.min(minY, LY[i] - r);
            minZ = Math.min(minZ, LZ[i] - r);
            maxX = Math.max(maxX, LX[i] + r);
            maxY = Math.max(maxY, LY[i] + r);
            maxZ = Math.max(maxZ, LZ[i] + r);
        }
        b.clear();
        b.putFloat(0, minX).putFloat(4, minY).putFloat(8, minZ).putFloat(12, count);
        b.putFloat(16, maxX).putFloat(20, maxY).putFloat(24, maxZ).putFloat(28, 0);
        for (int i = 0; i < MAX; i++) {
            int o = 32 + i * 16;
            boolean on = i < count;
            b.putFloat(o, on ? LX[i] : 0).putFloat(o + 4, on ? LY[i] : 0).putFloat(o + 8, on ? LZ[i] : 0).putFloat(o + 12, on ? LL[i] : 0);
        }
        b.position(0).limit(UBO_BYTES);
        return true;
    }

    /** For tests and the bench: this frame's light count. */
    public static int count() {
        return count;
    }

    // ---- bench

    public static void startWindow() {
        windowFrames = windowLights = windowCandidates = windowNanos = windowNanosMax = windowEntitiesLit = windowBlockEntitiesLit = 0;
    }

    public static JsonObject json() {
        JsonObject o = new JsonObject();
        int level = level();
        o.addProperty("state", failed ? "failed (switched off)" : level == OFF ? "off" : level == FAST ? "fast" : "fancy");
        o.addProperty("maxLights", limit(level));
        long f = Math.max(1, windowFrames);
        o.addProperty("frames", windowFrames);
        o.addProperty("lightsPerFrame", Math.round(windowLights * 100.0 / f) / 100.0);
        o.addProperty("candidatesPerFrame", Math.round(windowCandidates * 100.0 / f) / 100.0);
        o.addProperty("collectMsAvg", Math.round(windowNanos / 1e4 / f) / 100.0);
        o.addProperty("collectMsMax", Math.round(windowNanosMax / 1e4) / 100.0);
        o.addProperty("entitiesLitPerFrame", Math.round(windowEntitiesLit * 100.0 / f) / 100.0);
        o.addProperty("blockEntitiesLitPerFrame", Math.round(windowBlockEntitiesLit * 100.0 / f) / 100.0);
        o.addProperty("dataFiles", LightData.files);
        o.addProperty("dataItems", LightData.itemEntries);
        o.addProperty("dataEntities", LightData.entityEntries);
        o.addProperty("terrainLitFrames", com.meakaandre.quicksilver.terrain.TerrainLights.litFrames);
        o.addProperty("extractHookSeen", ObjectLights.hookSeen);
        o.addProperty("reloadHookSeen", LightData.reloadHookSeen);
        return o;
    }

    public static String line(JsonObject o) {
        return o.get("state").getAsString() + ", lights/frame " + o.get("lightsPerFrame") + " (of " + o.get("candidatesPerFrame") + " near; at most "
            + o.get("maxLights") + "), collect ms avg " + o.get("collectMsAvg") + " max " + o.get("collectMsMax") + ", entities lit/frame "
            + o.get("entitiesLitPerFrame") + ", block entities lit/frame " + o.get("blockEntitiesLitPerFrame") + ", data files " + o.get("dataFiles");
    }
}
