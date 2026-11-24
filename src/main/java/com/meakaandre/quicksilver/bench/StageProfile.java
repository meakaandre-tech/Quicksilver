package com.meakaandre.quicksilver.bench;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Package A, step 1: where a frame's time goes, by stage (terrain layers, feature groups, particles, sky, GUI, light
 * updates and the rest). Only while a speed bench's profile window runs ({@link #start}); nothing here changes what is
 * drawn.
 *
 * <p>On OpenGL every stage boundary waits for the GPU ({@code glFinish}), so a stage's time is its CPU time plus the GPU
 * work it queued: on CI's software rasteriser (llvmpipe) that is where the GPU time is. The waits make the profiled frame
 * slower than a plain one, so the profile gives shares, not frame rates; the speed bench measures frame rates in its own
 * windows without it. Off OpenGL (Vulkan) there is no wait and the times are CPU only (the report says which).
 *
 * <p>Stages nest ({@link #push} / {@link #pop}): an entity submitted while the feature pass runs counts as entity
 * submission, and the rest of the pass as the feature group. Render thread only.
 */
public final class StageProfile {
    private static volatile boolean active;
    private static boolean sync;
    private static final Map<String, long[]> TOTALS = new HashMap<>();
    private static final List<String> STACK = new ArrayList<>();
    private static String current = "other";
    private static long last;
    private static long frames, frameStart, frameNanosSum;

    private StageProfile() {
    }

    public static boolean active() {
        return active;
    }

    /** Starts a profile window; {@code glSync}: wait for the GPU at each stage boundary (OpenGL only). */
    static void start(boolean glSync) {
        TOTALS.clear();
        STACK.clear();
        current = "other";
        sync = glSync;
        frames = 0;
        frameNanosSum = 0;
        finish();
        last = System.nanoTime();
        frameStart = 0;
        active = true;
    }

    static void stop() {
        active = false;
        STACK.clear();
    }

    /** Enters a stage (render thread). */
    public static void push(String stage) {
        if (!active) return;
        switchTo(stage);
        STACK.add(stage);
    }

    /** Leaves {@code stage} if it is the one entered last (a hook whose push may not have run doesn't unbalance the stack). */
    public static void pop(String stage) {
        if (!active || STACK.isEmpty() || !STACK.get(STACK.size() - 1).equals(stage)) return;
        pop();
    }

    /** Leaves the stage entered last; back to the one around it. */
    public static void pop() {
        if (!active) return;
        if (!STACK.isEmpty()) STACK.remove(STACK.size() - 1);
        switchTo(STACK.isEmpty() ? "other" : STACK.get(STACK.size() - 1));
    }

    private static void switchTo(String stage) {
        if (stage.equals(current)) return;
        finish();
        long now = System.nanoTime();
        long[] t = TOTALS.computeIfAbsent(current, k -> new long[2]);
        t[0] += now - last;
        t[1]++;
        current = stage;
        last = now;
    }

    /** At each present: the frame's last stage ends, and the frame is counted. */
    public static void frameEnd() {
        if (!active) return;
        finish();
        long now = System.nanoTime();
        long[] t = TOTALS.computeIfAbsent(current, k -> new long[2]);
        t[0] += now - last;
        t[1]++;
        last = now;
        STACK.clear();
        current = "other";
        if (frameStart != 0) {
            frames++;
            frameNanosSum += now - frameStart;
        } else {
            TOTALS.clear(); // the part before the first present belongs to no whole frame
        }
        frameStart = now;
    }

    private static void finish() {
        if (!sync) return;
        try {
            org.lwjgl.opengl.GL11.glFinish();
        } catch (Throwable t) {
            sync = false;
        }
    }

    /** The window's stages, slowest first: ms per frame and share of the profiled frame. */
    static JsonObject json() {
        JsonObject o = new JsonObject();
        o.addProperty("frames", frames);
        o.addProperty("gpuWaitAtEachStage", sync);
        double f = Math.max(1, frames);
        o.addProperty("profiledFrameMs", Math.round(frameNanosSum / f / 1e4) / 100.0);
        List<Map.Entry<String, long[]>> list = new ArrayList<>(TOTALS.entrySet());
        list.sort((a, b) -> Long.compare(b.getValue()[0], a.getValue()[0]));
        long sum = 0;
        for (var e : list) sum += e.getValue()[0];
        JsonArray stages = new JsonArray();
        for (var e : list) {
            JsonObject s = new JsonObject();
            s.addProperty("stage", e.getKey());
            s.addProperty("msPerFrame", Math.round(e.getValue()[0] / f / 1e4) / 100.0);
            s.addProperty("pct", sum == 0 ? 0 : Math.round(1000.0 * e.getValue()[0] / sum) / 10.0);
            s.addProperty("entriesPerFrame", Math.round(e.getValue()[1] / f * 10) / 10.0);
            stages.add(s);
        }
        o.add("stages", stages);
        o.addProperty("note", "time per frame in each stage of the render thread while profiling; on OpenGL every stage"
            + " boundary waits for the GPU (glFinish), so a stage holds its CPU time and the GPU work it queued (on CI's"
            + " software rasteriser the GPU work is CPU time too); the waits make profiled frames slower than plain ones, so"
            + " read shares, not frame rates. 'other' is everything outside the named stages (the game tick, extraction,"
            + " vanilla's frame graph set-up, the frame limiter's wait if any).");
        return o;
    }
}
