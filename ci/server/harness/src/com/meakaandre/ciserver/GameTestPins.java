package com.meakaandre.ciserver;

import java.lang.reflect.Field;
import java.util.Map;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;

/**
 * CI only (fix-villager-flake). The GameTest server starts tests when it is ready, a varying number of ticks after
 * start-up, and other tests draw on the level's shared random while one runs; villager_trade finished at tick 25, 31,
 * 39 or 46 in vanilla's own runs (its villager's job search takes retry delays from that random, and its schedule follows
 * the day time). Three pins, the same in vanilla's runs and Quicksilver's:
 * <ul>
 * <li>the server's first test re-seeds the level's random and the seed counters and sets a fixed day time, once
 * ({@link #batchStart});</li>
 * <li>villager_trade runs in a GameTest batch of its own (its own, empty, test environment) and re-seeds and sets the
 * day time at its own setup ({@link #aloneStart});</li>
 * <li>a test's brain mob gets a fixed random seed and fixed sensor offsets right after it is spawned ({@link #pinMob}).</li>
 * </ul>
 * Checked over 16 GameTest servers with the batch starting between game time 7 and 6946, 8 of them with the randoms,
 * seed counters and day time moved first: villager_trade finished at the same tick in every one (run 41287372214).
 */
final class GameTestPins {
    private static boolean started = false;

    private GameTestPins() {
    }

    /**
     * At a test's setup: the server's first test re-seeds the level's random and the server thread's seed counter and sets
     * a fixed day time, once, so every test starts from the same state whenever the server starts them. Tests start a few
     * ticks apart (game time 3, 5, 7, 9), so doing it again for later tests would move the randoms under tests already
     * running.
     */
    static synchronized void batchStart(GameTestHelper h) {
        if (started) return;
        started = true;
        ServerLevel level = h.getLevel();
        long gt = level.getGameTime();
        SeedPin.resetThread(0x6A3E_7E57L);
        level.getRandom().setSeed(SeedPin.mix(level.dimension().identifier().toString().hashCode()));
        Harness.gameTestCommand(level.getServer(), "time set 1000");
        Harness.LOG.info("CI GAMETEST START at game time {}: level random and seed counters re-seeded, time set 1000", gt);
    }

    /**
     * At the setup of a test that runs in a batch of its own (villager_trade, environment ci_server_harness:villager_alone):
     * the level's random and the server thread's seed counter re-seeded and a fixed time of day set (a villager's schedule follows it).
     * Nothing else runs in that batch, so this moves no other test.
     */
    static synchronized void aloneStart(GameTestHelper h, String name) {
        ServerLevel level = h.getLevel();
        SeedPin.resetThread(0x6A3E_A10EL ^ name.hashCode());
        level.getRandom().setSeed(SeedPin.mix(name.hashCode()));
        Harness.gameTestCommand(level.getServer(), "time set 1000");
        Harness.LOG.info("CI GAMETEST ALONE {} at game time {}: level random and seed counters re-seeded, time set 1000", name, level.getGameTime());
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
            throw new IllegalStateException("CI harness: could not pin the sensors of " + mob + " (the harness's reflection no longer"
                + " fits Brain/Sensor; not a game difference)", ex);
        }
        if (pinned == 0) throw new IllegalStateException("CI harness: no brain sensors found on " + mob + " (the harness's reflection no"
            + " longer fits Brain; not a game difference)");
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
