package com.meakaandre.quicksilver.cipincreate;

import com.meakaandre.quicksilver.cipinstate.CreatePins;
import java.lang.reflect.Field;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * CI only (package 5): a standing train's carriage drawn at the same place in every run. On the client Create moves
 * each carriage's track points a fraction of the way towards the server's last sync per tick, scaled by the server's
 * measured speed, so a standing carriage ends a run a fraction of a pixel to either side (vanilla against vanilla too,
 * run 41613381142). In the Create pin areas the points are put exactly at the server's synced places instead (the
 * places Create's own fallback uses when it can't path to them). Every run, vanilla and Quicksilver alike.
 */
@Pseudo
@Mixin(targets = "com.zurrtum.create.content.trains.entity.CarriageSyncData", remap = false)
public abstract class CarriageApproachMixin {
    private static volatile boolean quicksilverCi$failed, quicksilverCi$logged, quicksilverCi$loggedFallback;

    @Inject(method = "approach", at = @At("HEAD"), cancellable = true, remap = false)
    private void quicksilverCi$snap(@Coerce Object entity, @Coerce Object carriage, float partial, CallbackInfo ci) {
        if (!CreatePins.pinned || quicksilverCi$failed) return;
        try {
            Object self = this;
            Object fallback = field(self.getClass(), "fallbackLocations").get(self);
            if (fallback != null) {
                // Create's other path (no track graph on the client): the carriage's anchor and its bogeys' rotation
                // anchors approach the synced vectors; put them there
                Object level = entity.getClass().getMethod("level").invoke(entity);
                Object dce = null;
                for (java.lang.reflect.Method m : carriage.getClass().getMethods()) {
                    if (m.getName().equals("getDimensional") && m.getParameterCount() == 1 && m.getParameterTypes()[0].isInstance(level)) {
                        dce = m.invoke(carriage, level);
                        break;
                    }
                }
                if (dce == null) return;
                Object pos = fallback.getClass().getMethod("getFirst").invoke(fallback);
                Object rot = fallback.getClass().getMethod("getSecond").invoke(fallback);
                if (pos == null || rot == null) return;
                field(dce.getClass(), "positionAnchor").set(dce, pos);
                Object anchors = field(dce.getClass(), "rotationAnchors").get(dce);
                java.lang.reflect.Method getR = rot.getClass().getMethod("get", boolean.class);
                java.lang.reflect.Method set = anchors.getClass().getMethod("set", boolean.class, Object.class);
                set.invoke(anchors, true, getR.invoke(rot, true));
                set.invoke(anchors, false, getR.invoke(rot, false));
                if (!quicksilverCi$loggedFallback) {
                    quicksilverCi$loggedFallback = true;
                    CreatePins.LOG.info("Quicksilver CI pin: a standing carriage put at its synced place (Create's CarriageSyncData.approach, synced vectors)");
                }
                ci.cancel();
                return;
            }
            Object[] targets = (Object[]) field(self.getClass(), "pointsToApproach").get(self);
            float[] snapshot = (float[]) field(self.getClass(), "pointDistanceSnapshot").get(self);
            Object bogeys = field(carriage.getClass(), "bogeys").get(carriage);
            boolean two = (boolean) carriage.getClass().getMethod("isOnTwoBogeys").invoke(carriage);
            java.lang.reflect.Method get = bogeys.getClass().getMethod("get", boolean.class);
            for (int b = 0; b < 2; b++) {
                boolean first = b == 0;
                if (!first && !two) break;
                Object bogey = get.invoke(bogeys, first);
                if (bogey == null) continue;
                Object points = field(bogey.getClass(), "points").get(bogey);
                for (int p = 0; p < 2; p++) {
                    int index = (first ? 0 : 2) + p;
                    Object target = targets[index];
                    if (target == null || field(target.getClass(), "edge").get(target) == null) continue;
                    Object point = get.invoke(points, p == 0);
                    for (String f : new String[] {"node1", "node2", "edge", "position"}) {
                        Field g = field(point.getClass(), f);
                        g.set(point, field(target.getClass(), f).get(target));
                    }
                    snapshot[index] = 0;
                }
            }
            if (!quicksilverCi$logged) {
                quicksilverCi$logged = true;
                CreatePins.LOG.info("Quicksilver CI pin: a standing carriage put at its synced place (Create's CarriageSyncData.approach, track points)");
            }
            ci.cancel();
        } catch (Throwable t) {
            quicksilverCi$failed = true;
            CreatePins.LOG.warn("Quicksilver CI pin: could not put the carriage at its synced place (Create's approach runs unpinned)", t);
        }
    }

    private static Field field(Class<?> c, String name) throws NoSuchFieldException {
        for (Class<?> k = c; k != null; k = k.getSuperclass()) {
            try {
                Field f = k.getDeclaredField(name);
                f.setAccessible(true);
                return f;
            } catch (NoSuchFieldException ignored) {
                // superclass
            }
        }
        throw new NoSuchFieldException(c.getName() + "." + name);
    }
}
