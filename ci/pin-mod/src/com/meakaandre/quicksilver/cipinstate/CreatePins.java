package com.meakaandre.quicksilver.cipinstate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CI only (package 5): Create's animation clock held still in the SIFTEC scenes that show Create machines (the factory
 * row and the kinetics scene), in every client run, vanilla and Quicksilver alike. Create turns shafts, cogs, belts,
 * fans and mixers by its own animation clock (on the CPU, for vanilla's block-entity renderers) and by Flywheel's frame
 * time (on the GPU, for Flywheel's instances); both start from when the client joined, so a shot taken a few ticks
 * later showed a striped part in another phase in about one run in four (315 pixels in the factory). While the player
 * is in one of these areas both clocks read {@link #TICKS} ticks plus {@link #PARTIAL}, so every run draws the same
 * phase. Outside them nothing changes. Also logs Flywheel's backend (its own choice), in every run.
 */
public final class CreatePins {
    private static final Logger LOG = LoggerFactory.getLogger("quicksilver_ci_pin");
    /** The pinned clock: an odd tick and a quarter, so shafts and cogs are at an angle and belts part-way. */
    public static final int TICKS = 37;
    public static final float PARTIAL = 0.25f;

    /** Whether the player is in a Create pin area (client thread). */
    public static volatile boolean pinned;
    private static final java.util.Set<String> LOGGED = java.util.concurrent.ConcurrentHashMap.newKeySet();
    private static String backend = "";
    private static int tick;

    private CreatePins() {
    }

    /** Create pin areas: the SIFTEC factory row (scenes factory, factory_flat) and the kinetics scene. */
    static boolean area(Level level, double x, double y, double z) {
        if (level == null || level.dimension() != Level.OVERWORLD) return false;
        if (x >= 1170 && x <= 1300 && z >= 950 && z <= 1050) return true;
        return x >= 2136 && x <= 2186 && z >= -2020 && z <= -1976 && y >= 225 && y <= 265;
    }

    /** Once per client tick. */
    public static void clientTick(Minecraft mc) {
        LocalPlayer p = mc.player;
        boolean now = p != null && area(mc.level, p.getX(), p.getY(), p.getZ());
        if (now != pinned) {
            pinned = now;
            LOG.info("Quicksilver CI pin: Create's animation clock {}", now ? "held at " + TICKS + " ticks + " + PARTIAL : "running");
        }
        // once a level is there: before it, Flywheel's backend is its "off" placeholder until it first chooses
        if (mc.level != null && ++tick % 20 == 0) {
            String b = flywheelBackend();
            if (b != null && !b.equals(backend)) {
                backend = b;
                LOG.info("Quicksilver CI pin: Flywheel backend {}", b);
            }
        }
    }

    /** Create Fly's Flywheel backend (its own choice), or null without Create Fly. */
    private static String flywheelBackend() {
        try {
            Class<?> c = Class.forName("com.zurrtum.create.client.flywheel.impl.BackendManagerImpl");
            return String.valueOf(c.getMethod("getBackendString").invoke(null));
        } catch (ClassNotFoundException e) {
            return null;
        } catch (Throwable t) {
            return "unreadable (" + t + ")";
        }
    }

    /** First use of each pin (logged once per pin, so a run shows each pin reached Create's code). */
    public static void used(String what) {
        if (!LOGGED.add(what)) return;
        LOG.info("Quicksilver CI pin: Create's animation clock pinned in {}", what);
    }
}
