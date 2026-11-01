package com.meakaandre.quicksilver.occlusion;

import com.google.gson.JsonObject;
import com.meakaandre.quicksilver.bench.GpuCounters;

/**
 * Package 2b's bench numbers (the {@code occlusion} block), per measured frame: sections with solid or cutout layers
 * Quicksilver would draw without occlusion culling, how many it drew, how many were proven hidden, and what the culling
 * cost (pyramids built, the CPU's wait for the GPU on the two-phase path, bytes read back); and CI's check.
 */
public final class OcclusionStats {
    // this frame (render thread)
    static int phase1, candidates, revealed, culledLate, culledStill, splits, pyramids, timeouts, untestedFrames, verifySkipped;
    static long waitNanos;
    static boolean waitedThisFrame;
    // the measuring window
    private static long frames, wPhase1, wCandidates, wRevealed, wCulledLate, wCulledStill, wSplits, wPyramids, wTimeouts, wUntested;
    private static long wWaitNanos, wWaitMax, wWaitFrames, wReadStart;
    private static long checkedSections, checkPixels, checkTimeouts, checkFrames, wVerifySkipped;
    // since start-up, CI gates these too
    private static long allCheckPixels, allCheckTimeouts;

    private OcclusionStats() {
    }

    public static void startWindow() {
        frames = wPhase1 = wCandidates = wRevealed = wCulledLate = wCulledStill = wSplits = wPyramids = wTimeouts = wUntested = 0;
        wWaitNanos = wWaitMax = wWaitFrames = 0;
        checkedSections = checkPixels = checkTimeouts = checkFrames = wVerifySkipped = 0;
        wReadStart = GpuOcclusion.readBytes();
    }

    /** Folds the frame that just ended into the window (while a bench measures), then clears the frame's counts. */
    static void beginFrame() {
        if (GpuCounters.enabled) {
            frames++;
            wPhase1 += phase1;
            wCandidates += candidates;
            wRevealed += revealed;
            wCulledLate += culledLate;
            wCulledStill += culledStill;
            wSplits += splits;
            wPyramids += pyramids;
            wTimeouts += timeouts;
            wUntested += untestedFrames;
            wVerifySkipped += verifySkipped;
            if (waitedThisFrame) {
                wWaitFrames++;
                wWaitNanos += waitNanos;
                wWaitMax = Math.max(wWaitMax, waitNanos);
            }
        }
        phase1 = candidates = revealed = culledLate = culledStill = splits = pyramids = timeouts = untestedFrames = verifySkipped = 0;
        waitNanos = 0;
        waitedThisFrame = false;
    }

    static void waited(long nanos) {
        waitNanos += nanos;
        waitedThisFrame = true;
    }

    /** CI's check of one frame: {@code sections} culled sections drawn into the check target, {@code pixels} that passed. */
    static void checked(int sections, long pixels) {
        if (pixels < 0) allCheckTimeouts++;
        else allCheckPixels += pixels;
        if (!GpuCounters.enabled) return;
        checkFrames++;
        checkedSections += sections;
        if (pixels < 0) checkTimeouts++;
        else checkPixels += pixels;
    }

    private static double per(long v) {
        return frames == 0 ? 0 : Math.round(v * 100.0 / frames) / 100.0;
    }

    public static JsonObject json() {
        JsonObject o = new JsonObject();
        o.addProperty("state", GpuOcclusion.state);
        o.addProperty("reason", GpuOcclusion.reason);
        o.addProperty("configured", GpuOcclusion.configured == null ? "unset" : GpuOcclusion.configured.name().toLowerCase(java.util.Locale.ROOT).replace('_', '-'));
        o.addProperty("lastFrame", GpuOcclusion.frameName());
        o.addProperty("fallbacks", GpuOcclusion.fallbacks);
        o.addProperty("frames", frames);
        long without = wPhase1 + wCandidates + wCulledStill;
        long drawn = wPhase1 + wRevealed;
        o.addProperty("sectionsWithoutCullingPerFrame", per(without));
        o.addProperty("sectionsDrawnPerFrame", per(drawn));
        o.addProperty("sectionsCulledPerFrame", per(wCulledLate + wCulledStill));
        o.addProperty("culledPct", without == 0 ? 0 : Math.round((without - drawn) * 1000.0 / without) / 10.0);
        o.addProperty("firstPassPerFrame", per(wPhase1));
        o.addProperty("candidatesPerFrame", per(wCandidates));
        o.addProperty("revealedPerFrame", per(wRevealed));
        o.addProperty("pyramidsPerFrame", per(wPyramids));
        o.addProperty("passSplitsPerFrame", per(wSplits));
        o.addProperty("waitFramesPct", frames == 0 ? 0 : Math.round(wWaitFrames * 1000.0 / frames) / 10.0);
        o.addProperty("waitMsPerFrame", frames == 0 ? 0 : Math.round(wWaitNanos / 1e4 / frames) / 100.0);
        o.addProperty("waitMsAvgWhenWaiting", wWaitFrames == 0 ? 0 : Math.round(wWaitNanos / 1e4 / wWaitFrames) / 100.0);
        o.addProperty("waitMsMax", Math.round(wWaitMax / 1e4) / 100.0);
        o.addProperty("timeouts", wTimeouts);
        o.addProperty("untestedFrames", wUntested);
        o.addProperty("readbackBytesPerFrame", per(GpuOcclusion.readBytes() - wReadStart));
        o.addProperty("checkFrames", checkFrames);
        o.addProperty("checkedSections", checkedSections);
        o.addProperty("checkPixels", checkPixels);
        o.addProperty("checkTimeouts", checkTimeouts);
        o.addProperty("checkSkipped", wVerifySkipped);
        o.addProperty("checkPixelsSinceStart", allCheckPixels);
        o.addProperty("checkTimeoutsSinceStart", allCheckTimeouts);
        o.addProperty("checkOn", GpuOcclusion.VERIFY);
        return o;
    }

    public static String line(JsonObject o) {
        return o.get("state").getAsString() + " (" + o.get("reason").getAsString() + "), last frame " + o.get("lastFrame").getAsString()
            + ", sections drawn/frame " + o.get("sectionsDrawnPerFrame") + " of " + o.get("sectionsWithoutCullingPerFrame") + " ("
            + o.get("culledPct") + "% culled; first pass " + o.get("firstPassPerFrame") + ", tested late " + o.get("candidatesPerFrame")
            + ", revealed " + o.get("revealedPerFrame") + "), pyramids/frame " + o.get("pyramidsPerFrame") + ", wait ms/frame "
            + o.get("waitMsPerFrame") + " (max " + o.get("waitMsMax") + ", " + o.get("waitFramesPct") + "% of frames), readback bytes/frame "
            + o.get("readbackBytesPerFrame") + ", timeouts " + o.get("timeouts") + ", untested frames " + o.get("untestedFrames")
            + ", check: " + o.get("checkedSections") + " culled sections, " + o.get("checkPixels") + " pixels visible (since start "
            + o.get("checkPixelsSinceStart") + "), fallbacks " + o.get("fallbacks");
    }
}
