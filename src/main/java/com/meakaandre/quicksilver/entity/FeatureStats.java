package com.meakaandre.quicksilver.entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.systems.ScissorState;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.StagedVertexBuffer;
import net.minecraft.client.renderer.rendertype.PreparedRenderType;
import org.joml.Matrix4f;

/**
 * Package 6, measured first: what 26.3's feature pass (entities, block entities, items, text, outlines and the rest,
 * {@code FeatureRenderDispatcher$PreparedFrame}) draws per frame, counted while a bench measures. Every feature draw
 * goes through {@code PreparedRenderType.draw}; for each one the state that decides whether two draws could be one is
 * recorded (pipeline, textures and samplers, scissor, the render type's dynamic transforms by value, vertex and index
 * buffer, index type, topology). Per phase run (solid, translucent, outline, ...):
 * <ul>
 *   <li>{@code adjacentSame}: draws whose state equals the draw just before them in the same phase run: what merging
 *   neighbours wins without changing the draw order at all;</li>
 *   <li>{@code adjacentContiguous}: of those, the ones whose index range also continues the previous one (one plain
 *   draw call; the rest would need a multi-draw);</li>
 *   <li>{@code states}: distinct states per phase run, the fewest draws any reordering could reach;</li>
 *   <li>{@code statesIgnoringTransforms}: the same with the dynamic transforms left out (what differs only in them).</li>
 * </ul>
 * Also: draws by phase, by feature type and by render type name, and the block entities and entities submitted per
 * frame by render-state class (what baking could take out). Observes only; render thread only.
 */
public final class FeatureStats {
    private static boolean window;
    private static String phase;
    private static String feature = "?";
    private static boolean strictlyOrdered;
    private static long frames, draws, backendDraws, adjacentSame, adjacentContiguous, states, statesNoTransforms, phaseRuns;

    private static final Map<String, long[]> BY_PHASE = new HashMap<>();
    private static final Map<String, long[]> BY_FEATURE = new HashMap<>();
    private static final Map<String, long[]> BY_RENDER_TYPE = new HashMap<>();
    private static final Map<String, long[]> BLOCK_ENTITIES = new HashMap<>();
    private static final Map<String, long[]> ENTITIES = new HashMap<>();
    /** Dynamic transforms written this frame, by slice, so draws compare them by value. */
    private static final Map<GpuBufferSlice, Matrix4f> TRANSFORMS = new HashMap<>();

    private record Key(RenderPipeline pipeline, List<PreparedRenderType.Texture> textures, long scissor, boolean scissorOn,
                       Object transforms, Object vertexBuffer, Object indexBuffer, Object indexType, Object topology) {
        Key withoutTransforms() {
            return new Key(pipeline, textures, scissor, scissorOn, null, vertexBuffer, indexBuffer, indexType, topology);
        }
    }

    private static Key last;
    private static int lastEnd = -1;
    private static int lastBase;
    private static final List<Key> PHASE_STATES = new ArrayList<>();
    private static final List<Key> PHASE_STATES_NT = new ArrayList<>();

    private FeatureStats() {
    }

    public static void startWindow() {
        frames = draws = backendDraws = adjacentSame = adjacentContiguous = states = statesNoTransforms = phaseRuns = 0;
        BY_PHASE.clear();
        BY_FEATURE.clear();
        BY_RENDER_TYPE.clear();
        BLOCK_ENTITIES.clear();
        ENTITIES.clear();
        window = true;
    }

    public static void stopWindow() {
        window = false;
    }

    public static void frameEnd() {
        TRANSFORMS.clear();
        if (window) frames++;
    }

    /** A {@code PreparedFrame.execute*} starts. */
    public static void phaseStart(String name) {
        phase = name;
        feature = "?";
        last = null;
        lastEnd = -1;
        PHASE_STATES.clear();
        PHASE_STATES_NT.clear();
    }

    public static void phaseEnd() {
        if (window && phase != null) {
            phaseRuns++;
            states += PHASE_STATES.size();
            statesNoTransforms += PHASE_STATES_NT.size();
        }
        phase = null;
    }

    /** A prepared group of one feature type starts executing inside the current phase. */
    public static void group(Object featureType, boolean ordered) {
        feature = String.valueOf(featureType);
        strictlyOrdered = ordered;
    }

    /** {@code RenderType.writeDynamicTransforms} returned this slice for this matrix. */
    public static void transforms(GpuBufferSlice slice, Matrix4f matrix) {
        if (slice != null && matrix != null) TRANSFORMS.put(slice, new Matrix4f(matrix));
    }

    /** One feature draw, just before it is made. */
    public static void draw(PreparedRenderType type, StagedVertexBuffer.ExecuteInfo info, RenderPipeline pipeline) {
        if (!window) return;
        String ph = phase == null ? "outside" : phase;
        count(BY_PHASE, ph);
        count(BY_FEATURE, ph + " / " + feature + (strictlyOrdered ? " (ordered)" : ""));
        count(BY_RENDER_TYPE, ph + " / " + type.name());
        draws++;
        ScissorState s = type.scissorState();
        boolean on = s != null && s.enabled();
        long sc = on ? ((long) s.x() << 48) ^ ((long) s.y() << 32) ^ ((long) s.width() << 16) ^ s.height() : 0;
        GpuBufferSlice t = type.dynamicTransforms();
        Object tr = t == null ? null : TRANSFORMS.getOrDefault(t, null);
        if (tr == null) tr = t;
        Key k = new Key(pipeline, type.textures(), sc, on, tr, info.vertexBuffer(), info.indexBuffer(), info.indexType(), info.topology());
        if (k.equals(last)) {
            adjacentSame++;
            if (info.firstIndex() == lastEnd && info.baseVertex() == lastBase) adjacentContiguous++;
        }
        last = k;
        lastEnd = info.firstIndex() + info.indexCount();
        lastBase = info.baseVertex();
        if (!PHASE_STATES.contains(k)) PHASE_STATES.add(k);
        Key nt = k.withoutTransforms();
        if (!PHASE_STATES_NT.contains(nt)) PHASE_STATES_NT.add(nt);
    }

    /** A draw reached the backend while a feature phase runs (checks one backend draw per feature draw). */
    public static void onBackendDraw() {
        if (window && phase != null) backendDraws++;
    }

    public static void blockEntity(Object state) {
        if (window && state != null) count(BLOCK_ENTITIES, state.getClass().getName());
    }

    public static void entity(Object state) {
        if (window && state != null) count(ENTITIES, state.getClass().getName());
    }

    private static void count(Map<String, long[]> m, String k) {
        m.computeIfAbsent(k, x -> new long[1])[0]++;
    }

    public static JsonObject json() {
        JsonObject o = new JsonObject();
        o.addProperty("frames", frames);
        o.addProperty("featureDrawsPerFrame", per(draws));
        o.addProperty("backendDrawsInPhasesPerFrame", per(backendDraws));
        o.addProperty("adjacentSamePerFrame", per(adjacentSame));
        o.addProperty("adjacentContiguousPerFrame", per(adjacentContiguous));
        o.addProperty("statesPerFrame", per(states));
        o.addProperty("statesIgnoringTransformsPerFrame", per(statesNoTransforms));
        o.addProperty("phaseRunsPerFrame", per(phaseRuns));
        o.add("byPhase", top(BY_PHASE, 20));
        o.add("byFeature", top(BY_FEATURE, 40));
        o.add("byRenderType", top(BY_RENDER_TYPE, 40));
        o.add("blockEntitiesSubmitted", top(BLOCK_ENTITIES, 40));
        o.add("entitiesSubmitted", top(ENTITIES, 40));
        o.addProperty("note", "package 6 measurement: feature draws (PreparedRenderType.draw) per frame; adjacentSame = draws with the same state as the draw before them in the same phase run (merged without reordering); adjacentContiguous = of those, index ranges that continue the previous one; states = distinct states per phase run (fewest draws any reordering could reach); per-frame averages");
        return o;
    }

    public static String line(JsonObject o) {
        return "feature draws/frame " + o.get("featureDrawsPerFrame") + " (backend " + o.get("backendDrawsInPhasesPerFrame") + "), adjacent same "
            + o.get("adjacentSamePerFrame") + " (contiguous " + o.get("adjacentContiguousPerFrame") + "), states " + o.get("statesPerFrame")
            + " (ignoring transforms " + o.get("statesIgnoringTransformsPerFrame") + "), phase runs " + o.get("phaseRunsPerFrame")
            + "; by phase " + o.get("byPhase");
    }

    private static JsonArray top(Map<String, long[]> m, int n) {
        JsonArray a = new JsonArray();
        m.entrySet().stream().sorted((x, y) -> Long.compare(y.getValue()[0], x.getValue()[0])).limit(n).forEach(e -> {
            JsonObject r = new JsonObject();
            r.addProperty("name", e.getKey());
            r.addProperty("perFrame", per(e.getValue()[0]));
            a.add(r);
        });
        return a;
    }

    private static double per(long v) {
        return frames == 0 ? 0 : Math.round(100.0 * v / frames) / 100.0;
    }
}
