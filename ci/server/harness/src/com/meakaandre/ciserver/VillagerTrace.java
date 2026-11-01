package com.meakaandre.ciserver;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.npc.villager.Villager;

/**
 * CI only, diagnosis (fix-villager-flake, -Dci.harness.villagerTrace=true): one line per tick of the villager_trade
 * GameTest until it finishes: game time, the villager's profession, its job-site memories, each brain sensor's ticks
 * to its next scan, and the seeds of the level's and the villager's randoms (read, not drawn from). Finds which of
 * them differs between vanilla's runs when the test finishes at another tick.
 */
final class VillagerTrace {
    private VillagerTrace() {
    }

    static void log(GameTestHelper h, Villager v, int tick) {
        StringBuilder b = new StringBuilder();
        try {
            b.append("gt=").append(h.getLevel().getGameTime());
            b.append(" data=").append(v.getVillagerData());
            Brain<?> brain = v.getBrain();
            b.append(" job=").append(brain.getMemory(MemoryModuleType.JOB_SITE).map(Object::toString).orElse("-"));
            b.append(" potential=").append(brain.getMemory(MemoryModuleType.POTENTIAL_JOB_SITE).map(Object::toString).orElse("-"));
            b.append(" sensors=");
            for (Field f : Brain.class.getDeclaredFields()) {
                if (!Map.class.isAssignableFrom(f.getType())) continue;
                f.setAccessible(true);
                Object m = f.get(brain);
                if (!(m instanceof Map<?, ?> map) || map.isEmpty()) continue;
                Object first = map.values().iterator().next();
                if (first == null || !first.getClass().getName().contains("Sensor")) continue;
                for (var e : map.entrySet()) b.append(e.getKey()).append(':').append(timeToTick(e.getValue())).append(',');
            }
            b.append(" levelSeed=").append(seed(h.getLevel().getRandom()));
            b.append(" mobSeed=").append(seed(v.getRandom()));
        } catch (Throwable t) {
            b.append(" error=").append(t);
        }
        Harness.LOG.info("CI VILLAGER t={} {}", tick, b);
    }

    private static String timeToTick(Object sensor) throws IllegalAccessException {
        for (Class<?> c = sensor.getClass(); c != null; c = c.getSuperclass()) {
            for (Field f : c.getDeclaredFields()) {
                if (f.getName().equals("timeToTick")) {
                    f.setAccessible(true);
                    return String.valueOf(f.get(sensor));
                }
            }
        }
        return "?";
    }

    private static String seed(Object random) throws IllegalAccessException {
        for (Class<?> c = random.getClass(); c != null; c = c.getSuperclass()) {
            for (Field f : c.getDeclaredFields()) {
                if (f.getType() == AtomicLong.class || f.getType() == long.class && !java.lang.reflect.Modifier.isStatic(f.getModifiers())) {
                    f.setAccessible(true);
                    Object val = f.get(random);
                    return random.getClass().getSimpleName() + "/" + val;
                }
            }
        }
        return random.getClass().getSimpleName() + "/?";
    }
}
