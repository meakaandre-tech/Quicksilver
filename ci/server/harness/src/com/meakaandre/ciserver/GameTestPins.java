package com.meakaandre.ciserver;

import java.lang.reflect.Field;
import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;

/**
 * CI only (fix-villager-flake): the GameTest server starts a batch of tests when it is ready, a varying number of ticks
 * after start-up (game time 3 in one run, 27 in another), so the level's shared random, the seed counters and the
 * randoms an entity takes when it is made were at different points from the tests' first tick: villager_trade finished
 * at tick 25, 31, 39 or 46. Here a batch's start (the first test set up in a game tick) re-seeds the level's random and
 * the seed counters once, and a test's brain mob gets a fixed random seed and fixed sensor offsets right after it is
 * spawned, so a test plays the same from its first tick whenever it starts. The same in vanilla's runs and Quicksilver's.
 */
final class GameTestPins {
    private static long lastBatchTick = Long.MIN_VALUE;

    private GameTestPins() {
    }

    /** At a test's setup: the first test of a game tick re-seeds the level's random and the seed counters. */
    static synchronized void batchStart(GameTestHelper h) {
        ServerLevel level = h.getLevel();
        long gt = level.getGameTime();
        if (gt == lastBatchTick) return;
        lastBatchTick = gt;
        SeedPin.reset(0x6A3E_7E57L);
        level.getRandom().setSeed(SeedPin.mix(level.dimension().identifier().toString().hashCode()));
        Harness.LOG.info("CI GAMETEST BATCH at game time {}: level random and seed counters re-seeded", gt);
    }

    /**
     * Right after a test spawns a mob with a brain: its random from a fixed seed, and each brain sensor's ticks to its
     * next scan from a fixed sequence keyed by the sensor's id (not by the brain's map order). Sensors take those offsets
     * from one random shared by every sensor in the game when they are made, and the mob its random from the seed
     * counters, both moved by whatever was made before.
     */
    static void pinMob(LivingEntity mob, String salt) {
        long seed = SeedPin.mix(salt.hashCode());
        mob.getRandom().setSeed(seed);
        Brain<?> brain = mob.getBrain();
        int pinned = 0;
        try {
            for (Field f : Brain.class.getDeclaredFields()) {
                if (!Map.class.isAssignableFrom(f.getType())) continue;
                f.setAccessible(true);
                if (!(f.get(brain) instanceof Map<?, ?> map) || map.isEmpty()) continue;
                Object first = map.values().iterator().next();
                if (first == null || !first.getClass().getName().contains("Sensor")) continue;
                for (var e : map.entrySet()) {
                    Object id = BuiltInRegistries.SENSOR_TYPE.getKey((net.minecraft.world.entity.ai.sensing.SensorType<?>) e.getKey());
                    int rate = intField(e.getValue(), "scanRate");
                    long offset = Math.floorMod(SeedPin.mix(seed ^ String.valueOf(id).hashCode()), (long) Math.max(1, rate));
                    setLongField(e.getValue(), "timeToTick", offset);
                    pinned++;
                }
            }
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("could not pin the sensors of " + mob, ex);
        }
        if (pinned == 0) throw new IllegalStateException("no brain sensors found on " + mob);
        Harness.LOG.info("CI GAMETEST PIN {}: random and {} sensors pinned", salt, pinned);
    }

    private static Field field(Object o, String name) throws NoSuchFieldException {
        for (Class<?> c = o.getClass(); c != null; c = c.getSuperclass()) {
            for (Field f : c.getDeclaredFields()) {
                if (f.getName().equals(name)) {
                    f.setAccessible(true);
                    return f;
                }
            }
        }
        throw new NoSuchFieldException(name + " in " + o.getClass().getName());
    }

    private static int intField(Object o, String name) throws ReflectiveOperationException {
        return field(o, name).getInt(o);
    }

    private static void setLongField(Object o, String name, long v) throws ReflectiveOperationException {
        field(o, name).setLong(o, v);
    }
}
