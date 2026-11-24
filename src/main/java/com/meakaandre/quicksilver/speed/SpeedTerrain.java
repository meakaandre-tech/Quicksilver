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

    /** The render-distance fog's end this frame, in blocks, or 0 when fog culling is off. */
    public static double fogEndThisFrame() {
        if (!Speed.FOG_SECTIONS.on() || !Speed.cameraKnown()) return 0;
        Minecraft mc = Minecraft.getInstance();
        if (mc.options == null || mc.level == null) return 0;
        if (mc.level.dimension() == net.minecraft.world.level.Level.END) return 0;
        if (Speed.camY > CLOUDS) return 0;
        return mc.options.getEffectiveRenderDistance() * 16.0 + 1.0;
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
        if (b[4] >= Speed.camY) return false;
        double dx = Math.max(0, Math.max(b[0] - Speed.camX, Speed.camX - b[3]));
        double dz = Math.max(0, Math.max(b[2] - Speed.camZ, Speed.camZ - b[5]));
        double dy = Speed.camY - b[4];
        return Math.max(Math.sqrt(dx * dx + dz * dz), dy) >= fogEnd;
    }
}
