package com.meakaandre.ciserver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.core.BlockPos;

/**
 * CI only (P2-1, diagnosis of the pending scheduled ticks that varied between vanilla's own runs). With
 * {@code -Dci.harness.trace=x1,y1,z1,x2,y2,z2;...} (block boxes, inclusive) every scheduled block or fluid tick inside a
 * box is logged with the harness's stage, the run's tick, the game time, its trigger tick and the calls that scheduled
 * it; every chunk's post-processing and tick unpacking is logged too. Lines start {@code CI TRACE}; at most
 * {@link #MAX} lines per server start.
 */
public final class Trace {
    private static final int MAX = 6000;
    private static final List<int[]> BOXES = new ArrayList<>();
    private static int lines = 0;
    private static boolean on = false;

    private Trace() {
    }

    static void init() {
        String spec = System.getProperty("ci.harness.trace");
        if (spec == null || spec.isBlank()) return;
        for (String b : spec.split(";")) {
            String[] p = b.trim().split(",");
            int[] v = new int[6];
            for (int i = 0; i < 6; i++) v[i] = Integer.parseInt(p[i].trim());
            BOXES.add(v);
        }
        on = true;
        Harness.LOG.info("CI TRACE boxes {}", spec);
    }

    public static boolean on() {
        return on;
    }

    private static boolean inside(BlockPos p) {
        for (int[] b : BOXES) {
            if (p.getX() >= b[0] && p.getY() >= b[1] && p.getZ() >= b[2] && p.getX() <= b[3] && p.getY() <= b[4] && p.getZ() <= b[5]) return true;
        }
        return false;
    }

    private static synchronized void log(String s) {
        if (lines >= MAX) return;
        if (++lines == MAX) s += " (trace limit reached)";
        Harness.LOG.info("CI TRACE {} {}", Harness.where(), s);
    }

    public static void scheduled(Object type, BlockPos pos, long trigger) {
        if (!inside(pos)) return;
        String by = StackWalker.getInstance().walk(f -> f.skip(2).limit(7)
            .map(x -> x.getClassName().substring(x.getClassName().lastIndexOf('.') + 1) + "." + x.getMethodName())
            .collect(Collectors.joining("<")));
        log("sched " + type + " " + pos.getX() + "," + pos.getY() + "," + pos.getZ() + " trigger=" + trigger + " thread="
            + Thread.currentThread().getName() + " by=" + by);
    }

    // ---- item entities (the test pack, 2026-11-12): with -Dci.harness.itemTrace=x1,y1,z1,x2,y2,z2 every item entity
    // inside the box is logged every 20 ticks of the run (and at ticks 0 to 3): its UUID, position, motion, stack, age
    // and whether it is on the ground, as lines "CI ITEMS". Diagnosis of two item entities at 56,2,41 that ended in
    // another place in about one Quicksilver run in nine (runs 43106805198, 43127438207), never in vanilla's
    private static final int[] ITEM_BOX = itemBox();

    private static int[] itemBox() {
        String spec = System.getProperty("ci.harness.itemTrace");
        if (spec == null || spec.isBlank()) return null;
        String[] p = spec.trim().split(",");
        int[] v = new int[6];
        for (int i = 0; i < 6; i++) v[i] = Integer.parseInt(p[i].trim());
        return v;
    }

    static void items(net.minecraft.server.MinecraftServer server, int tick) {
        if (ITEM_BOX == null || !(tick <= 3 || tick % 20 == 0)) return;
        int[] b = ITEM_BOX;
        net.minecraft.world.phys.AABB box = new net.minecraft.world.phys.AABB(b[0], b[1], b[2], b[3] + 1, b[4] + 1, b[5] + 1);
        List<net.minecraft.world.entity.item.ItemEntity> all = server.overworld().getEntitiesOfClass(
            net.minecraft.world.entity.item.ItemEntity.class, box, e -> true);
        StringBuilder sb = new StringBuilder();
        all.stream().sorted(java.util.Comparator.comparing(e -> e.getUUID().toString())).forEach(e -> sb.append(String.format(
            java.util.Locale.ROOT, " [%s %.3f,%.3f,%.3f v=%.4f,%.4f,%.4f %s age=%d ground=%s]",
            e.getUUID().toString().substring(0, 8), e.getX(), e.getY(), e.getZ(), e.getDeltaMovement().x, e.getDeltaMovement().y,
            e.getDeltaMovement().z, e.getItem().toString(), e.getAge(), e.onGround())));
        Harness.LOG.info("CI ITEMS tick={} n={}{}", tick, all.size(), sb);
    }

    public static void chunk(String what, int cx, int cz) {
        log(what + " chunk " + cx + "," + cz + " thread=" + Thread.currentThread().getName());
    }
}
