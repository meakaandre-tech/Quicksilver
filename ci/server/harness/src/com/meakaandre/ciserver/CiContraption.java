package com.meakaandre.ciserver;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;

/**
 * CI only (P2-2): checks on Create contraptions in SIFTEC's scripted run, at fixed ticks in every run alike.
 *
 * <p>Script line {@code at T ci-contraption check NAME EXPECT X1 Y1 Z1 X2 Y2 Z2}: counts the contraption entities
 * (entity types whose id contains "contraption") touching the box one block wider than X1..Z2, and the blocks that
 * aren't air inside X1..Z2 (the contraption's frame while it is placed). EXPECT is {@code assembled} (at least one
 * contraption entity and no frame block left), {@code placed} (no contraption entity, the frame back as blocks) or
 * {@code -} (recorded only). At the end of the run one line, {@code CI CONTRAPTION result=...}, lists every check with
 * its tick, counts and whether it met its expectation; CI requires the same line in every run, vanilla's and
 * Quicksilver's, and every expectation met.
 */
final class CiContraption {
    private static final List<String> checks = new ArrayList<>();
    private static boolean allMet = true;

    private CiContraption() {
    }

    static void command(MinecraftServer server, int tick, String args) {
        String[] p = args.trim().split("\\s+");
        try {
            if (!p[0].equals("check") || p.length != 9) throw new IllegalArgumentException("usage: check NAME EXPECT X1 Y1 Z1 X2 Y2 Z2");
            String name = p[1], expect = p[2];
            int x1 = Integer.parseInt(p[3]), y1 = Integer.parseInt(p[4]), z1 = Integer.parseInt(p[5]);
            int x2 = Integer.parseInt(p[6]), y2 = Integer.parseInt(p[7]), z2 = Integer.parseInt(p[8]);
            ServerLevel level = server.overworld();
            int blocks = 0;
            for (BlockPos pos : BlockPos.betweenClosed(x1, y1, z1, x2, y2, z2)) {
                if (!level.getBlockState(pos).isAir()) blocks++;
            }
            AABB box = new AABB(x1 - 1, y1 - 1, z1 - 1, x2 + 2, y2 + 2, z2 + 2);
            int contraptions = 0;
            for (Entity e : level.getEntities((Entity) null, box, Entity::isAlive)) {
                if (BuiltInRegistries.ENTITY_TYPE.getKey(e.getType()).getPath().contains("contraption")) contraptions++;
            }
            boolean met = switch (expect) {
                case "assembled" -> contraptions > 0 && blocks == 0;
                case "placed" -> contraptions == 0 && blocks > 0;
                case "-" -> true;
                default -> throw new IllegalArgumentException("unknown expectation " + expect);
            };
            allMet &= met;
            String c = "t" + tick + ":" + name + ":contraptions=" + contraptions + ",blocks=" + blocks + ",expect=" + expect + ",met=" + met;
            checks.add(c);
            Harness.LOG.info("CI CONTRAPTION CHECK {}", c);
        } catch (Throwable e) {
            allMet = false;
            checks.add("t" + tick + ":error=" + e);
            Harness.LOG.warn("CI CONTRAPTION CHECK t={} FAILED", tick, e);
        }
    }

    /** The run's line (null when the script has no contraption checks). */
    static String result() {
        if (checks.isEmpty()) return null;
        return "allMet=" + allMet + " " + String.join(" ", checks);
    }
}
