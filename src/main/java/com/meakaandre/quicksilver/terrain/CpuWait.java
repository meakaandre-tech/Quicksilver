package com.meakaandre.quicksilver.terrain;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * How long the calling thread has waited for a CPU while runnable (Linux: {@code /proc/thread-self/schedstat}, second
 * field, nanoseconds), so a timing can leave out time the operating system gave to other work. CI's upload gate uses it:
 * on a shared runner one terrain upload frame took 32.6 ms (run 45511522980) while its own work (the slowest arena grow)
 * took 6.7 ms. Bench only; -1 where the file can't be read (other systems), and then nothing is left out. Also the
 * JVM's stop-the-world GC time ({@link #gcPauseMillis}): a pause stops the thread without it waiting on a run queue.
 */
final class CpuWait {
    private CpuWait() {
    }

    private static final Path FILE = Path.of("/proc/thread-self/schedstat");
    private static boolean broken;

    /** Nanoseconds this thread has spent waiting on a run queue since it started, or -1. */
    static long nanos() {
        if (broken) return -1;
        try {
            String s = new String(Files.readAllBytes(FILE), StandardCharsets.US_ASCII).trim();
            String[] f = s.split(" ");
            return Long.parseLong(f[1]);
        } catch (IOException | RuntimeException e) {
            broken = true;
            return -1;
        }
    }

    private static java.util.List<java.lang.management.GarbageCollectorMXBean> pauseBeans;

    /**
     * Milliseconds of stop-the-world garbage collection since start-up: the collectors whose time is their pauses (G1's
     * young and old collections; ZGC's and Shenandoah's "Pauses"), not those that count concurrent work.
     */
    static long gcPauseMillis() {
        if (pauseBeans == null) {
            java.util.List<java.lang.management.GarbageCollectorMXBean> l = new java.util.ArrayList<>();
            for (var b : java.lang.management.ManagementFactory.getGarbageCollectorMXBeans()) {
                String n = b.getName();
                if (n.contains("Concurrent") || n.contains("Cycles")) continue;
                l.add(b);
            }
            pauseBeans = l;
        }
        long t = 0;
        for (var b : pauseBeans) t += Math.max(0, b.getCollectionTime());
        return t;
    }

    /**
     * Run-time fix (2026-11-26): this thread's time on a CPU and its time waiting on a run queue (schedstat's first two
     * fields, nanoseconds) in one reading, or null where the file can't be read. What a timed span spent neither running
     * nor waiting for a CPU, it spent blocked (for a lock, a fence, the driver's own threads).
     */
    static long[] cpuAndWait() {
        if (broken) return null;
        try {
            String s = new String(Files.readAllBytes(FILE), StandardCharsets.US_ASCII).trim();
            String[] f = s.split(" ");
            return new long[] {Long.parseLong(f[0]), Long.parseLong(f[1])};
        } catch (IOException | RuntimeException e) {
            broken = true;
            return null;
        }
    }

    /** The wait between two readings, 0 if either is unknown. */
    static long between(long before, long after) {
        return before < 0 || after < 0 ? 0 : Math.max(0, after - before);
    }
}
