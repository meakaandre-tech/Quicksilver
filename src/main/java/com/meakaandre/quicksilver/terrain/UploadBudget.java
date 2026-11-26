package com.meakaandre.quicksilver.terrain;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.bench.GpuCounters;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.List;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.core.SectionPos;

/**
 * Upload budget (package 4b): freshly meshed sections are copied into the arenas under a per-frame byte and time
 * budget, nearest and visible first, instead of all at once, so flying into new terrain doesn't spike frame time.
 *
 * <ul>
 * <li>The unit is a section's mesh: all its staged layers go in the same frame (vanilla swaps a mesh in only once every
 * layer is in, so splitting one would only delay it). A new index list for a translucent layer already in is never
 * held (it is small, and vanilla uploads its own at once too); one for a mesh still waiting goes in right after it.</li>
 * <li>Order: meshes of the section the camera is in and its 26 neighbours first, always uploaded whatever the budget;
 * then sections in this frame's visible list, then the rest; nearest first inside each (squared distance from the
 * section's centre to the camera), staging order on ties.</li>
 * <li>Budget per frame: bytes = {@link #BYTES_PER_MS} times the measured frame time (an average over the last frames),
 * between {@link #MIN_BYTES} and {@link #MAX_BYTES}; time = an eighth of the measured frame time, between 1 and 6 ms.
 * So uploads per second stay about the same at any frame rate, and one frame never takes a burst. The first mesh
 * outside the camera's sections goes in every frame even if it alone is over the budget (except in a frame where an
 * arena grows ahead, package B), so nothing waits for ever.</li>
 * <li>Package B: a hard cap of twice the byte and time budget on what one frame copies in outside the camera's sections
 * (index lists and overdue meshes aside); visible meshes close to their maximum wait go first; an arena past three
 * quarters of its buffer grows ahead, in a frame that copies in only the camera's sections and overdue meshes.</li>
 * </ul>
 * Without a camera position (its hook didn't run) the order is visible first, then staging order.
 */
public final class UploadBudget {
    static final long BYTES_PER_MS = 64L << 10;
    static final long MIN_BYTES = 256L << 10;
    static final long MAX_BYTES = 2L << 20;
    static final long MIN_TIME_NANOS = 1_000_000L, MAX_TIME_NANOS = 6_000_000L;
    /**
     * A section in the visible list never waits more than this many frames once it is visible: then its mesh goes in
     * whatever the budget (review S4: the wait for visible sections is bounded and measured).
     */
    static final int MAX_VISIBLE_WAIT_FRAMES = 15;
    /** Package B: from this many frames of waiting a visible mesh goes first in the next frames (under the budget and cap). */
    static final int DUE_WAIT_FRAMES = 11;
    /** Staged meshes are CPU memory: past this many bytes waiting, the budget grows by the excess. */
    static final long STAGED_CAP = 64L << 20;
    /** Debug: everything staged goes in at once, as before package 4b. */
    static final boolean DEBUG_OFF = Boolean.getBoolean("quicksilver.debug.noUploadBudget");

    // render thread
    private static final LongOpenHashSet VISIBLE = new LongOpenHashSet();
    private static double[] camera;
    private static int camSX, camSY, camSZ;
    private static long lastUpload;
    private static double frameMs = 16.7;
    /** Frames counted at each end-of-frame upload. */
    private static int frame;

    // measuring window (render thread)
    private static long windowFrames, windowBytes, windowMaxBytes, windowMeshes, windowExempt, windowWaitingSum, windowWaitingMax,
        windowFramesHolding, windowBudgetSum, windowNanos, windowMaxNanos, windowVisibleWaitMax, windowVisibleWaited, windowForced,
        windowStagedMaxBytes;

    private UploadBudget() {
    }

    /** Render thread, as the frame's terrain draws are prepared: the sections vanilla found visible, and the camera. */
    static void frameVisible(List<SectionRenderDispatcher.RenderSection> visible) {
        VISIBLE.clear();
        for (SectionRenderDispatcher.RenderSection s : visible) VISIBLE.add(s.getSectionNode());
        camera = BackFaces.frameCamera();
        if (camera != null) {
            camSX = ((int) Math.floor(camera[0])) >> 4;
            camSY = ((int) Math.floor(camera[1])) >> 4;
            camSZ = ((int) Math.floor(camera[2])) >> 4;
        }
    }

    /** Render thread, at each end-of-frame upload: updates the measured frame time. */
    static void tick() {
        long now = System.nanoTime();
        if (lastUpload != 0) {
            double ms = Math.min(250, Math.max(1, (now - lastUpload) / 1e6));
            frameMs += (ms - frameMs) * 0.125;
        }
        lastUpload = now;
        frame++;
    }

    static int frameNumber() {
        return frame;
    }

    /** Whether a section (origin in blocks) is in this frame's visible list. */
    static boolean visible(int x, int y, int z) {
        return VISIBLE.contains(SectionPos.asLong(x >> 4, y >> 4, z >> 4));
    }

    /** A visible section's mesh went in after waiting {@code frames} frames since it was first seen visible. */
    static void visibleWait(int frames) {
        if (!GpuCounters.enabled) return;
        windowVisibleWaitMax = Math.max(windowVisibleWaitMax, frames);
        if (frames > 0) windowVisibleWaited++;
    }

    static long bytes() {
        if (DEBUG_OFF) return Long.MAX_VALUE;
        return Math.max(MIN_BYTES, Math.min(MAX_BYTES, (long) (BYTES_PER_MS * frameMs)));
    }

    /**
     * Package B: the most one frame copies in outside the camera's sections, overdue visible meshes included: twice the
     * byte budget (the first mesh of a frame always goes in, whatever its size).
     */
    static long hardCap() {
        if (DEBUG_OFF) return Long.MAX_VALUE;
        return 2 * bytes();
    }

    /** Package B: past this much upload time in a frame, overdue meshes wait for the next frame too (twice the time budget). */
    static long hardNanos() {
        if (DEBUG_OFF) return Long.MAX_VALUE;
        return 2 * nanos();
    }

    /** Package B: an arena grew ahead of need, in a frame of its own. */
    static void preGrew() {
        if (GpuCounters.enabled) windowPreGrows++;
    }

    static long nanos() {
        if (DEBUG_OFF) return Long.MAX_VALUE;
        return Math.max(MIN_TIME_NANOS, Math.min(MAX_TIME_NANOS, (long) (frameMs * 1e6 / 8)));
    }

    /** Whether a section (origin in blocks) is the camera's or next to it: never held back. */
    static boolean exempt(int x, int y, int z) {
        if (camera == null) return false;
        return Math.abs((x >> 4) - camSX) <= 1 && Math.abs((y >> 4) - camSY) <= 1 && Math.abs((z >> 4) - camSZ) <= 1;
    }

    /** Sort key of a section's mesh (origin in blocks): lower goes first. */
    static double priority(int x, int y, int z) {
        boolean visible = VISIBLE.contains(SectionPos.asLong(x >> 4, y >> 4, z >> 4));
        if (exempt(x, y, z)) return -1;
        double d = 0;
        if (camera != null) {
            double dx = x + 8 - camera[0], dy = y + 8 - camera[1], dz = z + 8 - camera[2];
            d = dx * dx + dy * dy + dz * dz;
        }
        // visible sections before the rest, nearest first inside each
        return (visible ? 0 : 1e12) + d;
    }

    /**
     * Debug (CI): one log line each time meshes start waiting for a later frame and each time the queue is empty again,
     * so CI's screenshots wait until Quicksilver has caught up (the steady-shot check alone can't see one late section).
     */
    static final boolean DEBUG_LOG = Boolean.getBoolean("quicksilver.debug.logUploadQueue");
    private static boolean wasWaiting;

    private static boolean wasUnmeshed;
    private static String lastState = "";
    private static long lastStateAt;

    /**
     * Debug (CI, main fix 2026-11-25): one log line each time visible sections start waiting for their first mesh (vanilla's
     * "not compiled yet" mesh: new sections, and every section after F3+A) and each time none waits again, so CI's screenshots also wait for meshing: in CI's
     * Quicksilver runs the mesher check meshes every section twice (Quicksilver's mesher and vanilla's compiler, to
     * compare them), so after F3+A the last sections can come later than in a vanilla run. Also the terrain's state
     * (visible, left out by fog, left out by occlusion, waiting for a mesh) when it changes, at most twice a second, so
     * a picture failure can be matched to what was drawn when the shot was taken.
     */
    static void meshWait(int unmeshed, int visible, int fogged, int culled) {
        if ((unmeshed > 0) != wasUnmeshed) {
            wasUnmeshed = unmeshed > 0;
            com.meakaandre.quicksilver.QuicksilverClient.LOG.info(wasUnmeshed ? "Quicksilver meshing: waiting ({} visible sections)" : "Quicksilver meshing: caught up", unmeshed);
        }
        String state = visible + " visible, " + fogged + " in fog, " + culled + " occluded, " + unmeshed + " waiting for a mesh";
        long now = System.nanoTime();
        if (!state.equals(lastState) && now - lastStateAt > 500_000_000L) {
            lastState = state;
            lastStateAt = now;
            com.meakaandre.quicksilver.QuicksilverClient.LOG.info("Quicksilver terrain state: {}", state);
        }
    }

    /** One frame's upload, for the bench: bytes and meshes put in, exempt ones among them, meshes left waiting. */
    /** Meshes put in past the budget because a visible section had waited too long, and bytes staged this frame. */
    static void forced(int meshes, long stagedBytes) {
        if (!GpuCounters.enabled) return;
        windowForced += meshes;
        windowStagedMaxBytes = Math.max(windowStagedMaxBytes, stagedBytes);
    }

    /** Package A: meshes waiting for upload at the last frame (the speed bench waits for none). */
    public static volatile int lastWaiting;

    static void frame(long bytes, int meshes, int exempt, int waiting, long budget, long nanos) {
        lastWaiting = waiting;
        if (DEBUG_LOG && (waiting > 0) != wasWaiting) {
            wasWaiting = waiting > 0;
            com.meakaandre.quicksilver.QuicksilverClient.LOG.info(wasWaiting ? "Quicksilver uploads: waiting ({} meshes)" : "Quicksilver uploads: caught up", waiting);
        }
        if (!GpuCounters.enabled) return;
        windowFrames++;
        windowBytes += bytes;
        windowMaxBytes = Math.max(windowMaxBytes, bytes);
        windowMeshes += meshes;
        windowExempt += exempt;
        windowWaitingSum += waiting;
        windowWaitingMax = Math.max(windowWaitingMax, waiting);
        if (waiting > 0) windowFramesHolding++;
        windowBudgetSum += Math.min(budget, Long.MAX_VALUE / 4);
        windowNanos += nanos;
        windowMaxNanos = Math.max(windowMaxNanos, nanos);
    }

    // CI flakes (2026-11-25): each frame's upload less the time its thread waited for a CPU (CpuWait)
    private static long windowMaxNanosLessWait, windowWaitAtMax, windowFramesWaitKnown;

    /** The frame's run-queue wait during its upload (ns; -1 unknown) and its wall time; call before {@link #frame}. */
    static void cpuWait(long waitNanos, long wallNanos) {
        if (!GpuCounters.enabled) return;
        long less = waitNanos < 0 ? wallNanos : Math.max(0, wallNanos - waitNanos);
        if (waitNanos >= 0) windowFramesWaitKnown++;
        if (less > windowMaxNanosLessWait) {
            windowMaxNanosLessWait = less;
            windowWaitAtMax = Math.max(0, waitNanos);
        }
    }

    // package B: the worst frame in detail (bytes without the camera's sections, the slowest single mesh, arena grows)
    private static long windowMaxNonExemptBytes, windowMaxMeshNanos, windowGrows, windowGrowNanosMax, windowGrowBytesMax, windowPreGrows,
        windowMaxCap;

    /** Frames whose bytes under the hard cap went past it (beyond their first mesh). */
    private static long windowOverCapFrames;

    /**
     * The frame's bytes under the hard cap (outside the camera's sections, index lists and forced meshes), its slowest
     * single mesh copy, the cap and the first mesh's bytes (render thread).
     */
    static void frameDetail(long nonExemptBytes, long meshNanosMax, long cap, long firstMeshBytes) {
        if (!GpuCounters.enabled) return;
        windowMaxNonExemptBytes = Math.max(windowMaxNonExemptBytes, nonExemptBytes);
        windowMaxCap = Math.max(windowMaxCap, cap);
        // over the cap only by the frame's first mesh (which always goes in) is not over it
        if (nonExemptBytes > Math.max(cap, firstMeshBytes)) windowOverCapFrames++;
        windowMaxMeshNanos = Math.max(windowMaxMeshNanos, meshNanosMax);
    }

    /** Run-time fix (2026-11-26): the slowest grow's time on a CPU and waiting for one (-1 unknown); grows at a frame's start. */
    private static long windowGrowCpuAtMax, windowGrowWaitAtMax, windowGrowsAtFrameStart;

    /**
     * An arena buffer grew into a bigger one (new buffer and copy of what it held): its time, new size, the render
     * thread's time on a CPU and waiting for one during it (-1 unknown; the rest it was blocked), and whether it was the
     * grow ahead at the frame's start.
     */
    static void grew(long nanos, long newBytes, long cpuNanos, long waitNanos, boolean atFrameStart) {
        if (!GpuCounters.enabled) return;
        windowGrows++;
        if (atFrameStart) windowGrowsAtFrameStart++;
        if (nanos >= windowGrowNanosMax) {
            windowGrowCpuAtMax = cpuNanos;
            windowGrowWaitAtMax = waitNanos;
        }
        windowGrowNanosMax = Math.max(windowGrowNanosMax, nanos);
        windowGrowBytesMax = Math.max(windowGrowBytesMax, newBytes);
    }

    static void startWindow() {
        windowMaxNonExemptBytes = windowMaxMeshNanos = windowGrows = windowGrowNanosMax = windowGrowBytesMax = windowPreGrows = windowMaxCap = 0;
        windowGrowCpuAtMax = windowGrowWaitAtMax = windowGrowsAtFrameStart = 0;
        windowOverCapFrames = 0;
        windowMaxNanosLessWait = windowWaitAtMax = windowFramesWaitKnown = 0;
        windowFrames = windowBytes = windowMaxBytes = windowMeshes = windowExempt = windowWaitingSum = windowWaitingMax = 0;
        windowFramesHolding = windowBudgetSum = windowNanos = windowMaxNanos = 0;
        windowVisibleWaitMax = windowVisibleWaited = windowForced = windowStagedMaxBytes = 0;
    }

    public static JsonObject json() {
        JsonObject o = new JsonObject();
        o.addProperty("state", DEBUG_OFF ? "off (debug: quicksilver.debug.noUploadBudget)" : "on");
        o.addProperty("cameraKnown", camera != null);
        long f = Math.max(1, windowFrames);
        o.addProperty("frames", windowFrames);
        o.addProperty("bytesPerFrame", round((double) windowBytes / f));
        o.addProperty("maxBytesInOneFrame", windowMaxBytes);
        o.addProperty("budgetBytesPerFrame", DEBUG_OFF ? -1 : round((double) windowBudgetSum / f));
        o.addProperty("meshesPerFrame", round((double) windowMeshes / f));
        o.addProperty("cameraSectionMeshes", windowExempt);
        o.addProperty("sectionsWaitingAvg", round((double) windowWaitingSum / f));
        o.addProperty("sectionsWaitingMax", windowWaitingMax);
        o.addProperty("framesWithSectionsWaiting", windowFramesHolding);
        o.addProperty("visibleWaitFramesMax", windowVisibleWaitMax);
        o.addProperty("visibleMeshesThatWaited", windowVisibleWaited);
        o.addProperty("maxVisibleWaitFramesAllowed", MAX_VISIBLE_WAIT_FRAMES);
        o.addProperty("meshesForcedPastBudget", windowForced);
        o.addProperty("stagedMBMax", round(windowStagedMaxBytes / 1048576.0));
        o.addProperty("uploadMsAvg", round(windowNanos / 1e6 / f));
        o.addProperty("uploadMsMax", round(windowMaxNanos / 1e6));
        // the slowest frame once the time its thread waited for a CPU (the OS running other work) or stood in a GC pause is left out; what CI gates
        o.addProperty("uploadMsMaxLessCpuWait", round(windowMaxNanosLessWait / 1e6));
        o.addProperty("cpuWaitMsInThatFrame", round(windowWaitAtMax / 1e6));
        o.addProperty("framesWithCpuWaitKnown", windowFramesWaitKnown);
        o.addProperty("maxBytesUnderHardCap", windowMaxNonExemptBytes);
        o.addProperty("slowestMeshMs", round(windowMaxMeshNanos / 1e6));
        o.addProperty("arenaGrows", windowGrows);
        o.addProperty("arenaGrowMsMax", round(windowGrowNanosMax / 1e6));
        o.addProperty("arenaGrowMBMax", round(windowGrowBytesMax / 1048576.0));
        o.addProperty("arenaGrowsAhead", windowPreGrows);
        // run-time fix (2026-11-26): where the slowest grow's time went (on a CPU, waiting for one, blocked: for the
        // driver's own threads, a fence or a lock); the grows done at a frame's start (before its terrain draws)
        o.addProperty("arenaGrowsAtFrameStart", windowGrowsAtFrameStart);
        boolean known = windowGrows > 0 && windowGrowCpuAtMax >= 0 && windowGrowWaitAtMax >= 0;
        o.addProperty("arenaGrowCpuMsAtMax", known ? round(windowGrowCpuAtMax / 1e6) : -1);
        o.addProperty("arenaGrowCpuWaitMsAtMax", known ? round(windowGrowWaitAtMax / 1e6) : -1);
        o.addProperty("arenaGrowBlockedMsAtMax", known ? round(Math.max(0, windowGrowNanosMax - windowGrowCpuAtMax - windowGrowWaitAtMax) / 1e6) : -1);
        o.addProperty("hardCapBytesMax", windowMaxCap);
        o.addProperty("framesOverHardCap", windowOverCapFrames);
        o.addProperty("note", "Quicksilver's terrain uploads at the end of each measured frame: bytes copied into its arenas, meshes put in"
            + " (those of the camera's section and its neighbours are never held back), sections still waiting for a later frame");
        return o;
    }

    private static double round(double v) {
        return Math.round(v * 1000.0) / 1000.0;
    }
}
