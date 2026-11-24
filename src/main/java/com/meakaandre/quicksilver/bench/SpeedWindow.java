package com.meakaandre.quicksilver.bench;

import it.unimi.dsi.fastutil.longs.LongArrayList;

/**
 * Package A: frame times and draw/upload counts for one of the speed bench's windows (its own recorder, so the main
 * bench window's numbers are untouched). Render thread.
 */
public final class SpeedWindow {
    private static volatile boolean recording;
    private static long lastPresent;
    static final LongArrayList FRAMES = new LongArrayList();
    static long draws, bytes;
    private static long[] lastDraws, lastBytes;

    private SpeedWindow() {
    }

    static void start() {
        FRAMES.clear();
        lastPresent = 0;
        draws = bytes = 0;
        GpuCounters.enabled = true;
        recording = true;
    }

    static void stop() {
        recording = false;
        GpuCounters.enabled = false;
    }

    /** Called at each present (from {@link FrameRecorder#onPresent}). */
    public static void onPresent() {
        if (!recording) return;
        long now = System.nanoTime();
        long[] d = GpuCounters.snapshot(GpuCounters.DRAWS);
        long[] b = GpuCounters.snapshot(GpuCounters.UPLOAD_BYTES);
        if (lastPresent != 0) {
            FRAMES.add(now - lastPresent);
            draws += FrameRecorder.sum(d) - FrameRecorder.sum(lastDraws);
            bytes += FrameRecorder.sum(b) - FrameRecorder.sum(lastBytes);
        }
        lastPresent = now;
        lastDraws = d;
        lastBytes = b;
    }
}
