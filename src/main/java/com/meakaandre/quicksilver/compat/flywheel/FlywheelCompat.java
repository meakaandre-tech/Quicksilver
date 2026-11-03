package com.meakaandre.quicksilver.compat.flywheel;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.QuicksilverClient;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Package 5: Quicksilver's side of Flywheel, as Create Fly bundles it ({@code com.zurrtum.create.client.flywheel}).
 * Everything here runs only when Create Fly is installed (the {@code quicksilver.flywheel} mixins load only then,
 * {@link FlywheelMixins}); without it this class is never touched by a hook and reports "absent".
 *
 * <p>What Flywheel gets from Sodium, and where it comes from with Quicksilver (read from Create Fly's code, CC0, and
 * its bundled Flywheel, MIT; nothing copied):
 * <ul>
 * <li><b>Block entities Flywheel draws are not drawn by vanilla's renderer.</b> With Sodium, Flywheel registers a
 * render predicate per block-entity type (Sodium's own section builder skips vanilla's block-entity step). Without
 * Sodium, Create Fly cancels vanilla's {@code SectionCompiler.handleBlockEntity} for every block entity it takes.
 * Quicksilver's mesher calls that very method for every block entity, in vanilla's order (package 4c), so Flywheel
 * takes its own there; nothing else is needed ({@link FlywheelMixins#hookReport} checks the hook is in place).</li>
 * <li><b>Light.</b> Flywheel's light storage reads the client level's light engine and listens to
 * {@code ClientChunkCache.onLightUpdate}; Quicksilver changes neither.</li>
 * <li><b>Section rebuild events.</b> Create Fly's Flywheel has none to listen to (no hook on section rebuilds with or
 * without Sodium), so there is nothing to send.</li>
 * <li><b>Animated sprites.</b> With Sodium, Create marks the sprites its own renderers use as active. Quicksilver's
 * animation module (package 8) counts every sprite read outside section meshing as used, which covers Create's and
 * Flywheel's model caches.</li>
 * </ul>
 * What Quicksilver adds: the backend Flywheel chose is logged and reported, and the frames Flywheel draws solid
 * geometry into the main depth image before the terrain are counted ({@link #depthStamp}): the occlusion module's
 * still-camera pyramid is built from that depth image, so it must not be reused once Flywheel's moving geometry has
 * changed it.
 */
public final class FlywheelCompat {
    /** Create Fly's bundled Flywheel. */
    static final String FLW = "com.zurrtum.create.client.flywheel";

    private static volatile String backend = "unknown";
    private static volatile String backendNote = "";
    private static volatile boolean loggedPresent;
    /** Frames in which Flywheel drew visuals into the main depth image before the terrain (render thread). */
    private static final AtomicLong DEPTH_FRAMES = new AtomicLong();
    private static long windowStartFrames, windowStartChoices;
    private static volatile long backendChoices;
    private static volatile int lastVisuals;

    private static Field contextManager;
    private static Method visualCount, blockEntities, entities, effects;
    private static boolean reflectionFailed;

    private FlywheelCompat() {
    }

    /** Whether Create Fly (and so its Flywheel) is installed. */
    public static boolean present() {
        return FlywheelMixins.present();
    }

    /** Mixin, after Flywheel chose a backend (resource reload, level renderer reload). */
    public static void backendChosen() {
        String now = backendString();
        backendChoices++;
        String before = backend;
        backend = now;
        backendNote = describe(now);
        if (!now.equals(before)) {
            QuicksilverClient.LOG.info("Quicksilver compat: Flywheel backend {} ({}); Quicksilver keeps Flywheel's hooks: block entities through"
                + " vanilla's block-entity step, light from the client light engine", now, backendNote);
        }
    }

    private static String describe(String id) {
        return switch (id) {
            case "flywheel:indirect" -> "instancing with GPU culling (compute shaders, indirect draws)";
            case "flywheel:instancing" -> "instancing";
            case "flywheel:off" -> "off: Flywheel's fallback, vanilla's block-entity and entity renderers draw everything";
            default -> "not one of Flywheel's own";
        };
    }

    /** Flywheel's {@code BackendManagerImpl.getBackendString()}, by reflection (Quicksilver is built without Create Fly). */
    private static String backendString() {
        try {
            Class<?> c = Class.forName(FLW + ".impl.BackendManagerImpl");
            return String.valueOf(c.getMethod("getBackendString").invoke(null));
        } catch (Throwable t) {
            return "unknown (" + t.getClass().getSimpleName() + ")";
        }
    }

    /**
     * Mixin, at the start of Flywheel's {@code RenderContextImpl.beforeSolid} (render thread, every frame Flywheel is
     * set up for the level): if Flywheel has any visual, it is about to draw it into the main target, depth included.
     */
    public static void beforeSolid(Object renderContext) {
        if (!loggedPresent) {
            loggedPresent = true;
            QuicksilverClient.LOG.info("Quicksilver compat: Create Fly's Flywheel draws before the terrain this session (backend {})", backend);
        }
        int n = visuals(renderContext);
        lastVisuals = n;
        if (n > 0) DEPTH_FRAMES.incrementAndGet();
    }

    /** Visuals Flywheel holds for the level of this render context (block entities, entities, effects), or 0. */
    private static int visuals(Object ctx) {
        if (reflectionFailed || ctx == null) return 0;
        try {
            if (contextManager == null) {
                contextManager = ctx.getClass().getField("visualizationManager");
                Class<?> vm = Class.forName(FLW + ".api.visualization.VisualizationManager");
                Class<?> m = Class.forName(FLW + ".api.visualization.VisualManager");
                blockEntities = vm.getMethod("blockEntities");
                entities = vm.getMethod("entities");
                effects = vm.getMethod("effects");
                visualCount = m.getMethod("visualCount");
            }
            Object vm = contextManager.get(ctx);
            if (vm == null) return 0;
            return (int) visualCount.invoke(blockEntities.invoke(vm)) + (int) visualCount.invoke(entities.invoke(vm))
                + (int) visualCount.invoke(effects.invoke(vm));
        } catch (Throwable t) {
            reflectionFailed = true;
            QuicksilverClient.LOG.warn("Quicksilver compat: could not read Flywheel's visual count; every frame counts as one Flywheel drew in", t);
            return 1;
        }
    }

    /**
     * For the occlusion module's still-camera stamp: changes in every frame in which Flywheel drew into the main depth
     * image. Flywheel's instances move on the GPU from frame to frame (rotation and scrolling follow its frame time), so a
     * depth image it drew into is valid for that frame only. 0 and constant without Create Fly.
     */
    public static long depthStamp() {
        return DEPTH_FRAMES.get();
    }

    /** Bench window start. */
    public static void startWindow() {
        windowStartFrames = DEPTH_FRAMES.get();
        windowStartChoices = backendChoices;
    }

    /** The bench's "flywheel" block. */
    public static JsonObject json(int frames) {
        JsonObject o = new JsonObject();
        boolean on = present();
        o.addProperty("createFly", on ? version("create") : "absent");
        if (!on) return o;
        o.addProperty("backend", backend);
        o.addProperty("backendNote", backendNote);
        o.addProperty("backendChoicesInWindow", backendChoices - windowStartChoices);
        o.addProperty("framesDrawingBeforeTerrain", DEPTH_FRAMES.get() - windowStartFrames);
        o.addProperty("frames", frames);
        o.addProperty("visuals", lastVisuals);
        JsonObject be = FlywheelMixins.hookReport();
        o.add("hooks", be);
        return o;
    }

    public static String line(JsonObject o) {
        if (!o.has("backend")) return "Create Fly " + o.get("createFly").getAsString();
        return "Create Fly " + o.get("createFly").getAsString() + ", backend " + o.get("backend").getAsString() + ", visuals " + o.get("visuals")
            + ", frames drawing before the terrain " + o.get("framesDrawingBeforeTerrain") + " of " + o.get("frames");
    }

    private static String version(String mod) {
        return FabricLoader.getInstance().getModContainer(mod).map(c -> c.getMetadata().getVersion().getFriendlyString()).orElse("absent");
    }
}
