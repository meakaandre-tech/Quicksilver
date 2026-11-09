package com.meakaandre.quicksilver.entity;

import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/**
 * Far entity LOD (package 6, opt-in, off by default). Mobs and item entities beyond {@link #distance} blocks:
 * <ul>
 *   <li>update their animation at most once per game tick (50 ms): between updates every animation float of the render
 *   state (age, walk cycle, head turn and each renderer's own animation floats) keeps the value it had at the last
 *   update; position, body turn, death, size and shadow stay live;</li>
 *   <li>skip model cubes smaller than a pixel on screen: the cube's bounding sphere (its diagonal) at the depth of its
 *   nearest point, an upper bound on the size it is drawn at anywhere on screen.</li>
 * </ul>
 * Off, nothing here runs past the first check, so the picture is vanilla's. On, CI checks it against its own stored
 * references (docs/ci-limits.md, "Far entity LOD"). Players are never held or thinned.
 */
public final class EntityLod {
    /** On or off: {@code /quicksilver lod on|off}, or {@code -Dquicksilver.entityLod=true} at start. */
    public static volatile boolean enabled = Boolean.getBoolean("quicksilver.entityLod") && !Boolean.getBoolean("quicksilver.ci.measureOnly");
    public static volatile double distance = Double.parseDouble(System.getProperty("quicksilver.entityLod.distance", "32"));
    static final long HOLD_NANOS = 50_000_000L;
    /** A cube is skipped when its bounding sphere would cover less than this many pixels on screen. */
    static final float SKIP_PIXELS = 1f;

    /** Render-state floats that stay live (not animation, or a jump would show). */
    static final Set<String> LIVE = Set.of("bodyRot", "deathTime", "scale", "ageScale", "boundingBoxWidth", "boundingBoxHeight",
        "eyeHeight", "shadowRadius", "ticksSinceKineticHitFeedback");

    private static final Map<Class<?>, Field[]> FIELDS = new HashMap<>();
    private static final Map<Entity, Held> HELD = new WeakHashMap<>();

    private record Held(Class<?> cls, float[] values, long at) {
    }

    // the model being written right now (render thread only): its pixels per block at distance 1, or 0 when not thinned
    private static float modelPixels;
    private static Matrix4f viewRotation;
    private static final Vector3f TMP = new Vector3f();

    private static long states, heldStates, cubesTested, cubesSkipped, models;

    private EntityLod() {
    }

    static boolean eligible(Entity e, EntityRenderState s) {
        return (s instanceof LivingEntityRenderState && !(e instanceof Player)) || s instanceof ItemEntityRenderState;
    }

    /** End of an entity's render-state extraction. */
    public static void extracted(Entity e, EntityRenderState s) {
        if (!enabled || s == null || e == null) return;
        try {
            if (!eligible(e, s)) return;
            double d = distance;
            if (s.distanceToCameraSq < d * d) {
                HELD.remove(e);
                return;
            }
            states++;
            Field[] fields = FIELDS.computeIfAbsent(s.getClass(), EntityLod::animationFloats);
            long now = System.nanoTime();
            Held h = HELD.get(e);
            if (h == null || h.cls() != s.getClass() || now - h.at() >= HOLD_NANOS) {
                float[] v = new float[fields.length];
                for (int i = 0; i < fields.length; i++) v[i] = fields[i].getFloat(s);
                HELD.put(e, new Held(s.getClass(), v, now));
                return;
            }
            for (int i = 0; i < fields.length; i++) fields[i].setFloat(s, h.values()[i]);
            heldStates++;
        } catch (Throwable t) {
            enabled = false;
            com.meakaandre.quicksilver.QuicksilverClient.LOG.error("Quicksilver entity LOD failed, turned off", t);
        }
    }

    private static Field[] animationFloats(Class<?> c) {
        List<Field> out = new ArrayList<>();
        for (Class<?> k = c; k != null && k != Object.class; k = k.getSuperclass()) {
            for (Field f : k.getDeclaredFields()) {
                int m = f.getModifiers();
                if (f.getType() != float.class || Modifier.isStatic(m) || Modifier.isFinal(m) || LIVE.contains(f.getName())) continue;
                f.setAccessible(true);
                out.add(f);
            }
        }
        return out.toArray(new Field[0]);
    }

    /** A model submit is about to be written: thin it if it is a far mob's. */
    public static void beginModel(Object state) {
        modelPixels = 0;
        if (!enabled || !(state instanceof LivingEntityRenderState s) || s instanceof net.minecraft.client.renderer.entity.state.AvatarRenderState) return;
        double d = distance;
        if (s.distanceToCameraSq < d * d) return;
        try {
            var cam = Minecraft.getInstance().gameRenderer.gameRenderState().levelRenderState.cameraRenderState;
            if (cam == null || cam.projectionMatrix == null) return;
            if (cam.viewRotationMatrix == null) return;
            viewRotation = cam.viewRotationMatrix;
            modelPixels = cam.projectionMatrix.m11() * Minecraft.getInstance().getWindow().getHeight() * 0.5f;
            models++;
        } catch (Throwable t) {
            modelPixels = 0;
        }
    }

    public static void endModel() {
        modelPixels = 0;
    }

    /** True when {@code cube} would cover less than {@link #SKIP_PIXELS} pixels: leave it out. */
    public static boolean skipCube(ModelPart.Cube cube, PoseStack.Pose pose) {
        float k = modelPixels;
        if (k <= 0) return false;
        cubesTested++;
        Matrix4f m = pose.pose();
        float sx = (cube.maxX - cube.minX) / 16f, sy = (cube.maxY - cube.minY) / 16f, sz = (cube.maxZ - cube.minZ) / 16f;
        float scale = Math.max(m.getScale(TMP).x, Math.max(TMP.y, TMP.z));
        float diag = (float) Math.sqrt(sx * sx + sy * sy + sz * sz) * scale;
        m.transformPosition((cube.minX + cube.maxX) / 32f, (cube.minY + cube.maxY) / 32f, (cube.minZ + cube.maxZ) / 32f, TMP);
        viewRotation.transformPosition(TMP);
        float near = -TMP.z - diag * 0.5f; // the sphere's nearest depth
        if (near <= 0 || diag * k >= SKIP_PIXELS * near) return false;
        cubesSkipped++;
        return true;
    }

    // ---- command

    /** {@code /quicksilver lod on|off} and {@code /quicksilver lod distance <blocks>} (also under {@code /qs}). */
    public static void register(com.mojang.brigadier.CommandDispatcher<net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource> dispatcher) {
        for (String name : new String[] {"quicksilver", "qs"}) {
            dispatcher.register(net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal(name)
                .then(net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal("lod")
                    .then(net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal("on").executes(c -> set(c.getSource(), true)))
                    .then(net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal("off").executes(c -> set(c.getSource(), false)))
                    .then(net.fabricmc.fabric.api.client.command.v2.ClientCommands.literal("distance")
                        .then(net.fabricmc.fabric.api.client.command.v2.ClientCommands.argument("blocks", com.mojang.brigadier.arguments.IntegerArgumentType.integer(8, 512))
                            .executes(c -> {
                                distance = com.mojang.brigadier.arguments.IntegerArgumentType.getInteger(c, "blocks");
                                c.getSource().sendFeedback(net.minecraft.network.chat.Component.literal("[Quicksilver] Far entity LOD beyond " + (int) distance + " blocks."));
                                return 1;
                            })))));
        }
    }

    private static int set(net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource src, boolean on) {
        if (on && !EntityMixins.lodApplied()) {
            src.sendError(net.minecraft.network.chat.Component.literal("[Quicksilver] Far entity LOD can't turn on: its hooks did not apply to this game."));
            return 0;
        }
        enabled = on;
        HELD.clear();
        com.meakaandre.quicksilver.QuicksilverClient.LOG.info("Quicksilver entity LOD: {} (since the last switch: far states {}, held {}, models {}, cubes tested {}, skipped {})",
            on ? "on" : "off", states, heldStates, models, cubesTested, cubesSkipped);
        states = heldStates = cubesTested = cubesSkipped = models = 0;
        src.sendFeedback(net.minecraft.network.chat.Component.literal("[Quicksilver] Far entity LOD " + (on ? "on" : "off") + "."));
        return 1;
    }

    // ---- bench

    public static void startWindow() {
        states = heldStates = cubesTested = cubesSkipped = models = 0;
    }

    public static JsonObject json(int frames) {
        JsonObject o = new JsonObject();
        o.addProperty("enabled", enabled);
        o.addProperty("hooks", EntityMixins.lodApplied());
        o.addProperty("distance", distance);
        double f = Math.max(1, frames);
        o.addProperty("farStatesPerFrame", Math.round(states / f * 100) / 100.0);
        o.addProperty("heldStatesPerFrame", Math.round(heldStates / f * 100) / 100.0);
        o.addProperty("thinnedModelsPerFrame", Math.round(models / f * 100) / 100.0);
        o.addProperty("cubesTestedPerFrame", Math.round(cubesTested / f * 100) / 100.0);
        o.addProperty("cubesSkippedPerFrame", Math.round(cubesSkipped / f * 100) / 100.0);
        return o;
    }

    public static String line(JsonObject o) {
        return (o.get("enabled").getAsBoolean() ? "on" : "off") + " (hooks " + o.get("hooks") + "), beyond " + o.get("distance") + " blocks: "
            + o.get("farStatesPerFrame") + " far states/frame, " + o.get("heldStatesPerFrame") + " held; cubes tested " + o.get("cubesTestedPerFrame")
            + ", skipped " + o.get("cubesSkippedPerFrame");
    }
}
