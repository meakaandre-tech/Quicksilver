package com.meakaandre.ciserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;

/**
 * CI only (P2-3b): the border run's chunk watch. Script line {@code watch-chunks DIM CX1 CZ1 CX2 CZ2}: at the end of
 * every tick of the run, for each chunk in the box, its tickets (type, level, ticks left), its chunk holder's ticket
 * level and full status and whether it ticks blocks, and the server chunk cache's last four chunks (read without
 * changing them). Whenever any of that changes from the tick before it is written down ({@code t=TICK X,Z state}), so the
 * result is the whole history of those chunks' tickets and levels; CI requires it equal in every run, vanilla's and
 * Quicksilver's. A chunk lookup that missed the last four chunks gives its chunk a one-tick ticket (and moves the four
 * along), so any lookup Quicksilver skipped or added where vanilla's would miss shows up here at the tick it happened.
 *
 * <p>The tickets and holders are read by reflection (CI only, after the tick, the same in every run).
 */
final class ChunkWatch {
    private record Box(String dim, int x1, int z1, int x2, int z2) {
    }

    private static final List<Box> boxes = new ArrayList<>();
    private static final Map<String, String> last = new HashMap<>();
    private static final JsonArray events = new JsonArray();
    private static int changes = 0;
    private static String error = null;

    private ChunkWatch() {
    }

    static void add(String dim, int x1, int z1, int x2, int z2) {
        boxes.add(new Box(dim, x1, z1, x2, z2));
    }

    static boolean on() {
        return !boxes.isEmpty();
    }

    /** At the end of one of the run's ticks. */
    static void tick(MinecraftServer server, int tick) {
        if (boxes.isEmpty() || error != null) return;
        try {
            for (Box b : boxes) {
                ServerLevel level = server.getLevel(net.minecraft.resources.ResourceKey.create(net.minecraft.core.registries.Registries.DIMENSION,
                    net.minecraft.resources.Identifier.parse(b.dim())));
                ServerChunkCache cache = level.getChunkSource();
                note(tick, b.dim() + " recent", recent(cache));
                for (int cz = b.z1(); cz <= b.z2(); cz++) {
                    for (int cx = b.x1(); cx <= b.x2(); cx++) note(tick, b.dim() + " " + cx + "," + cz, state(level, cache, cx, cz));
                }
            }
        } catch (Throwable t) {
            error = String.valueOf(t);
            Harness.LOG.error("CI CHUNK WATCH FAILED", t);
        }
    }

    private static void note(int tick, String key, String state) {
        if (state.equals(last.get(key))) return;
        last.put(key, state);
        changes++;
        // the first 20000 changes in full (enough for the border run), then only counted
        if (events.size() < 20000) events.add("t=" + tick + " " + key + " " + state);
    }

    static void result(JsonObject result) {
        if (boxes.isEmpty()) return;
        JsonObject w = new JsonObject();
        w.addProperty("changes", changes);
        w.add("events", events);
        if (error != null) {
            w.addProperty("error", error);
            result.addProperty("error", "chunk watch: " + error);
        }
        result.add("chunkWatch", w);
        Harness.LOG.info("CI CHUNK WATCH {} changes over {} chunks", changes, last.size());
    }

    // ---- reading the game's state (reflection, CI only)

    private static Field distanceManager, ticketStorage, lastPos, lastChunk;
    private static List<Field> ticketMaps;
    private static Method visibleHolder, holderLevel, holderFull;

    private static String state(ServerLevel level, ServerChunkCache cache, int cx, int cz) throws ReflectiveOperationException {
        long key = (cx & 0xFFFFFFFFL) | (cz & 0xFFFFFFFFL) << 32;
        StringBuilder s = new StringBuilder();
        Object holder = holder(cache, key);
        if (holder == null) {
            s.append("no-holder");
        } else {
            s.append("level=").append(holderLevel.invoke(holder)).append(" full=").append(holderFull.invoke(holder));
        }
        // (not getChunkNow: it would put the chunk among the last four itself; not entity ticking: a chunk's entities
        // load from disk on another thread, at no fixed tick)
        s.append(" ticking=").append(level.shouldTickBlocksAt(key));
        s.append(" tickets=").append(tickets(cache, key));
        return s.toString();
    }

    private static Object holder(ServerChunkCache cache, long key) throws ReflectiveOperationException {
        if (visibleHolder == null) {
            visibleHolder = findMethod(ServerChunkCache.class, "getVisibleChunkIfPresent", long.class);
            Class<?> h = visibleHolder.getReturnType();
            holderLevel = findMethod(h, "getTicketLevel");
            holderFull = findMethod(h, "getFullStatus");
        }
        return visibleHolder.invoke(cache, key);
    }

    private static String tickets(ServerChunkCache cache, long key) throws ReflectiveOperationException {
        if (ticketStorage == null) {
            distanceManager = fieldOfType(ServerChunkCache.class, "DistanceManager");
            Object dm = distanceManager.get(cache);
            ticketStorage = fieldOfType(dm.getClass(), "TicketStorage");
            Object ts = ticketStorage.get(dm);
            ticketMaps = new ArrayList<>();
            for (Class<?> c = ts.getClass(); c != null && c != Object.class; c = c.getSuperclass()) {
                for (Field f : c.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) continue;
                    if (it.unimi.dsi.fastutil.longs.Long2ObjectMap.class.isAssignableFrom(f.getType())) {
                        f.setAccessible(true);
                        ticketMaps.add(f);
                    }
                }
            }
            if (ticketMaps.isEmpty()) throw new NoSuchFieldException("TicketStorage has no ticket map");
        }
        Object ts = ticketStorage.get(distanceManager.get(cache));
        StringBuilder s = new StringBuilder("[");
        for (Field f : ticketMaps) {
            Object list = ((it.unimi.dsi.fastutil.longs.Long2ObjectMap<?>) f.get(ts)).get(key);
            s.append(f.getName()).append(':');
            if (list == null) {
                s.append('-');
            } else {
                for (Object t : (Iterable<?>) list) s.append(describe(t)).append(' ');
            }
            s.append(';');
        }
        return s.append(']').toString();
    }

    /**
     * One ticket as its fields' values (its type by registry name), never through a toString that could print an object's
     * hash code (which differs between runs).
     */
    private static String describe(Object ticket) throws ReflectiveOperationException {
        StringBuilder s = new StringBuilder("{");
        for (Class<?> c = ticket.getClass(); c != null && c != Object.class; c = c.getSuperclass()) {
            for (Field f : c.getDeclaredFields()) {
                if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) continue;
                f.setAccessible(true);
                Object v = f.get(ticket);
                s.append(f.getName()).append('=').append(value(v)).append(',');
            }
        }
        return s.append('}').toString();
    }

    private static String value(Object v) {
        if (v == null || v instanceof Number || v instanceof Boolean || v instanceof CharSequence || v instanceof Enum<?>) return String.valueOf(v);
        Object name = typeName(v);
        return name != null ? String.valueOf(name) : v.getClass().getSimpleName();
    }

    /** A ticket type's registry name, if the game registers ticket types (else null). */
    private static Object typeName(Object v) {
        try {
            Field f = net.minecraft.core.registries.BuiltInRegistries.class.getField("TICKET_TYPE");
            Object registry = f.get(null);
            Method getKey = registry.getClass().getMethod("getKey", Object.class);
            return getKey.invoke(registry, v);
        } catch (ReflectiveOperationException | RuntimeException e) {
            return null;
        }
    }

    /** The server chunk cache's last four chunk positions (the chunk lookups' own cache). */
    private static String recent(ServerChunkCache cache) throws ReflectiveOperationException {
        if (lastPos == null) {
            lastPos = ServerChunkCache.class.getDeclaredField("lastChunkPos");
            lastPos.setAccessible(true);
            lastChunk = ServerChunkCache.class.getDeclaredField("lastChunk");
            lastChunk.setAccessible(true);
        }
        long[] p = (long[]) lastPos.get(cache);
        Object[] c = (Object[]) lastChunk.get(cache);
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < p.length; i++) {
            s.append((int) p[i]).append(',').append((int) (p[i] >> 32)).append(c[i] == null ? "(empty)" : "").append(' ');
        }
        return s.toString().trim();
    }

    private static Field fieldOfType(Class<?> owner, String simpleName) throws NoSuchFieldException {
        for (Class<?> c = owner; c != null && c != Object.class; c = c.getSuperclass()) {
            for (Field f : c.getDeclaredFields()) {
                if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) continue;
                for (Class<?> t = f.getType(); t != null; t = t.getSuperclass()) {
                    if (t.getSimpleName().equals(simpleName)) {
                        f.setAccessible(true);
                        return f;
                    }
                }
            }
        }
        throw new NoSuchFieldException(owner.getName() + " has no field of type " + simpleName);
    }

    private static Method findMethod(Class<?> owner, String name, Class<?>... args) throws NoSuchMethodException {
        for (Class<?> c = owner; c != null; c = c.getSuperclass()) {
            try {
                Method m = c.getDeclaredMethod(name, args);
                m.setAccessible(true);
                return m;
            } catch (NoSuchMethodException ignored) {
                // a superclass may declare it
            }
        }
        throw new NoSuchMethodException(owner.getName() + "." + name);
    }
}
