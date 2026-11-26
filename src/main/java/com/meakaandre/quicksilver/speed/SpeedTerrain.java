package com.meakaandre.quicksilver.speed;

import net.minecraft.client.Minecraft;

/**
 * Package A, terrain: the fog test for whole sections and the far-detail distance. Render thread, once per frame and
 * once per visible section.
 *
 * <p><b>Fog.</b> The game's terrain shader mixes each fragment towards the fog colour by the larger of two fog values; the
 * render-distance one is {@code linear_fog_value(cylindrical distance, start, end)}, which is exactly 1 (the fragment is
 * the fog colour, whatever the block) once the cylindrical distance, {@code max(length(xz), abs(y))} from the camera,
 * reaches the render-distance fog's end. That end is the render distance in blocks (vanilla's fog set-up), and the fog
 * colour's alpha is 1 in the overworld, the nether and the end. A section whose nearest point is beyond it is therefore
 * the fog colour on every pixel it covers; leaving it out shows what is behind it instead (more fogged terrain, which is
 * the same colour, or the sky). Conservative: the nearest point of the section's box, with one block of margin, and the
 * larger of the horizontal and vertical parts (each a lower bound on the shader's distance over the box).
 *
 * <p><b>What shows instead.</b> Behind a fogged section is more fogged terrain (the same colour) or the sky, which need
 * not be the fog colour (the sun or moon low over the horizon, the sunrise fan, clouds, the End's sky box). So only
 * sections whose geometry is wholly below the camera's eye are left out: every line of sight to them points downwards,
 * where the sky holds none of those (the sun, moon and sunrise sit above the horizon, clouds are above a camera below
 * them, and with the camera above the clouds the test is off), and never in the End. The box is the section's recorded
 * vertex bounds (models may reach outside their block), so nothing of it can lie nearer than tested.
 */
public final class SpeedTerrain {
    private SpeedTerrain() {
    }

    /** Margin for translucent geometry, whose vertex box isn't recorded (water and glass stay inside their block). */
    public static final double TRANSLUCENT_MARGIN = 1.0;

    /** Clouds are drawn from about this height up; above it a downward line of sight may meet them. */
    static final double CLOUDS = 180.0;

    // ---- package B: the fog end confirmed from what vanilla writes for the shaders (mixin.speed.FogRendererMixin)

    /** Terrain preparations and presented frames so far; the preparation and frame during which the fog hook last ran. */
    private static long prepares, hookPrepare, hookPresent = -1;
    private static boolean hookSeen;
    private static volatile boolean hookEnabled;
    private static volatile float hookStart = Float.NaN, hookEnd = Float.NaN, hookEnvStart = Float.NaN, hookEnvEnd = Float.NaN,
        hookAlpha = Float.NaN;
    /** This frame's test: whether sections above the eye may go too (a dimension without a sky: the nether). */
    private static boolean noSkyThisFrame;
    /** What this frame's end came from (bench). */
    private static volatile String endFrom = "";
    /** Why fog-sections is off this frame though switched on (null: it works); the reasons logged, once per kind. */
    private static volatile String offReason = "no frame yet";
    private static final java.util.Set<String> LOGGED = java.util.concurrent.ConcurrentHashMap.newKeySet();

    /**
     * The fog hook (render thread, at the end of {@code FogRenderer.updateBuffer}, so after any mod that changes the fog
     * data on its way in): fog switched on (vanilla's debug toggle), both fogs' start and end, the fog colour's alpha.
     */
    public static void fogWritten(boolean enabled, float renderDistanceStart, float renderDistanceEnd, float environmentalStart,
                                  float environmentalEnd, float alpha) {
        // CI's check of the switch-off: as if the hook had never run (the real "didn't run" path is what it tests)
        if (Speed.CI_FOG_UNCONFIRMED.on()) return;
        hookEnabled = enabled;
        hookStart = renderDistanceStart;
        hookEnd = renderDistanceEnd;
        hookEnvStart = environmentalStart;
        hookEnvEnd = environmentalEnd;
        hookAlpha = alpha;
        hookPrepare = prepares;
        hookPresent = com.meakaandre.quicksilver.bench.FrameRecorder.presents();
        hookSeen = true;
    }

    /**
     * Package 11: the fog the world is drawn with now, for the pixel art look's outlines (they fade out in it): {start,
     * end} in blocks, the nearer of the render-distance fog and the environmental fog (water, lava, the nether's thick
     * fog) where each has its start before its end; null if the fog hook has not seen a fog with an end, or fog is off.
     */
    public static float[] fogForLook() {
        if (!hookSeen || !hookEnabled) return null;
        float s = hookStart, e = hookEnd;
        if (!(Float.isFinite(e) && Float.isFinite(s) && s < e)) {
            s = Float.POSITIVE_INFINITY;
            e = Float.POSITIVE_INFINITY;
        }
        float es = hookEnvStart, ee = hookEnvEnd;
        if (Float.isFinite(ee) && Float.isFinite(es) && es < ee && ee < e) {
            s = es;
            e = ee;
        }
        return Float.isFinite(e) ? new float[] {s, e} : null;
    }

    /**
     * The fog end this frame, in blocks, or 0 when fog culling is off. Package B: only an end the fog hook saw vanilla
     * write for the shaders this frame or the one before (its value, plus one block of margin), with vanilla's fog switched
     * on, start before end, a fog colour that is opaque, no shader pack in use and no world border within reach of the
     * view; otherwise fog-sections switches itself off (logged once per kind of reason) and comes back by itself when all
     * hold again.
     */
    public static double fogEndThisFrame() {
        long frame = ++prepares;
        noSkyThisFrame = false;
        endFrom = "";
        if (!Speed.FOG_SECTIONS.on()) return 0;
        Minecraft mc = Minecraft.getInstance();
        String skip = !Speed.cameraKnown() ? "the camera hook has not run" : mc.options == null || mc.level == null ? "no world"
            : mc.level.dimension() == net.minecraft.world.level.Level.END ? "the End (its sky box shows behind terrain)"
            : Speed.camY > CLOUDS ? "the camera is above the clouds" : null;
        if (skip != null) {
            offReason = "not used here: " + skip;
            return 0;
        }
        String why = unconfirmed(frame, mc);
        offReason = why;
        if (why != null) {
            String kind = why.contains(" (") ? why.substring(0, why.indexOf(" (")) : why;
            if (LOGGED.add(kind)) com.meakaandre.quicksilver.QuicksilverClient.LOG.info("Quicksilver speed: approx.fog-sections switched itself off: {}", why);
            return 0;
        }
        double end = Math.max(hookEnd, mc.options.getEffectiveRenderDistance() * 16.0f) + 1.0;
        endFrom = "render-distance fog";
        // package B: in a dimension without a sky (the nether) the environmental fog too: the shader takes the larger of
        // the two fog values, so a fragment is the fog colour once either reaches its end, and the nether's thick fog ends
        // at about half the render distance. Only its value written during this frame, before the terrain is prepared (a
        // value from an earlier frame may have moved since), and only with its start before its end. The frame is cleared
        // with the fog colour there, so sections above the eye may go too.
        if (mc.level.dimension() == net.minecraft.world.level.Level.NETHER) {
            noSkyThisFrame = true;
            float env = hookEnvEnd;
            long presents = com.meakaandre.quicksilver.bench.FrameRecorder.presents();
            if (presents > 0 && hookPresent == presents && Float.isFinite(env) && env > 0 && hookEnvStart < env && env + 1.0 < end) {
                end = env + 1.0;
                endFrom = "environmental fog";
            }
        }
        return end;
    }

    private static String unconfirmed(long frame, Minecraft mc) {
        String mixin = com.meakaandre.quicksilver.mixin.speed.SpeedMixins.RESULT.getOrDefault("FogRendererMixin", "not applied");
        if (!mixin.equals("applied")) return "the fog hook was not applied (" + mixin + ")";
        if (!hookSeen || frame - hookPrepare > 1) {
            return "the fog end could not be confirmed (vanilla's fog set-up did not run for this frame; a mod may draw the fog its own way)";
        }
        if (!hookEnabled) return "the fog is switched off (vanilla's debug fog toggle)";
        float end = hookEnd, alpha = hookAlpha;
        if (!Float.isFinite(end) || end <= 0 || !(hookStart < end)) return "the fog end is not a distance past its start (" + hookStart + " to " + end + ")";
        if (!(alpha >= 1f)) return "the fog colour is not opaque (alpha " + alpha + ")";
        if (shaderPackInUse()) return "a shader pack is in use (its fog is its own)";
        // the world border is drawn without fog: it would show through a section left out in front of it
        double border = mc.level.getWorldBorder().getDistanceToBorder(Speed.camX, Speed.camZ);
        if (border < mc.options.getEffectiveRenderDistance() * 16.0 + 32.0) return "the world border is within reach of the view (" + Math.round(border) + " blocks)";
        return null;
    }

    private static java.lang.reflect.Method irisInUse;
    private static Object irisApi;
    private static boolean irisLooked;

    /** Iris's public API, by reflection (looked up once): whether a shader pack is in use. Iris unreadable counts as in use. */
    private static boolean shaderPackInUse() {
        if (!irisLooked) {
            irisLooked = true;
            if (net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("iris")) {
                try {
                    Class<?> api = Class.forName("net.irisshaders.iris.api.v0.IrisApi");
                    irisApi = api.getMethod("getInstance").invoke(null);
                    irisInUse = api.getMethod("isShaderPackInUse");
                } catch (Throwable t) {
                    irisApi = Boolean.TRUE; // present but unreadable
                }
            }
        }
        if (irisApi == null) return false;
        if (irisInUse == null) return true;
        try {
            return (Boolean) irisInUse.invoke(irisApi);
        } catch (Throwable t) {
            return true;
        }
    }

    /** For the bench: whether fog-sections works this frame, or why it switched itself off. */
    public static String fogState() {
        if (!Speed.FOG_SECTIONS.on()) return "off (switched off)";
        String r = offReason;
        return r == null ? "on (fog end confirmed: render distance " + hookEnd + ", environmental " + hookEnvEnd + " blocks; using the "
            + endFrom + (noSkyThisFrame ? ", above the eye too (no sky)" : "") + ")" : "off: " + r;
    }

    /** The far-detail distance in blocks, or 0 when off. */
    public static double farCutoutBlocks() {
        int chunks = Speed.FAR_CUTOUT.value();
        return chunks <= 0 ? 0 : chunks * 16.0;
    }

    /** Horizontal distance from the camera to the nearest point of the section whose minimum corner is at x, z. */
    public static double nearXz(int ox, int oz) {
        double dx = Math.max(0, Math.max(ox - Speed.camX, Speed.camX - (ox + 16)));
        double dz = Math.max(0, Math.max(oz - Speed.camZ, Speed.camZ - (oz + 16)));
        return Math.sqrt(dx * dx + dz * dz);
    }

    /**
     * Whether a section's geometry, the box {@code minX, minY, minZ, maxX, maxY, maxZ} in world coordinates (its
     * solid and cutout vertices as recorded, grown to its block box plus a margin if it has translucent geometry), is
     * wholly past the fog end by the shader's cylindrical distance and wholly below the camera's eye.
     */
    public static boolean inFogBelowEye(double[] b, double fogEnd) {
        // package B: in a dimension without a sky the box may also be above the eye (dy then from its bottom)
        if (b[4] >= Speed.camY && !noSkyThisFrame) return false;
        double dx = Math.max(0, Math.max(b[0] - Speed.camX, Speed.camX - b[3]));
        double dz = Math.max(0, Math.max(b[2] - Speed.camZ, Speed.camZ - b[5]));
        double dy = Math.max(0, Math.max(Speed.camY - b[4], b[1] - Speed.camY));
        // max(horizontal, vertical) is a lower bound on both the cylindrical (render-distance fog) and the spherical
        // distance, so the box is past whichever fog end applies
        return Math.max(Math.sqrt(dx * dx + dz * dz), dy) >= fogEnd;
    }
}
