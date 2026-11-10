package com.meakaandre.quicksilver.chunks;

import java.util.Arrays;
import net.minecraft.util.BitStorage;
import net.minecraft.world.level.chunk.Palette;
import net.minecraft.world.level.chunk.PalettedContainer;

/**
 * P2-4, chunks.cow-sections: copy-on-write sections for chunk saves. To save a full chunk, vanilla snapshots it on the
 * server thread ({@code SerializableChunkData.copyOf}), copying every section's block and biome containers, and
 * serialises the snapshot on a worker thread. Here, while a full chunk's sections are snapshotted on the server thread,
 * a container's copy shares its data (the bit storage and palette) instead of copying it, and both containers are marked
 * shared; whichever of the two is written next first takes a copy of its own (as vanilla's copy would have been), so
 * the snapshot keeps the contents of the tick it was taken in and serialises to the same bytes. A section that isn't
 * written before the next save is never copied at all.
 *
 * <p>Every way a container's contents change goes through one of its setters (getAndSet, getAndSetUnchecked, set) or
 * reading it from the network (read); each unshares first. Only full chunks' sections are shared (only the server thread
 * writes them); a proto chunk's (written by worldgen threads) are copied as in vanilla. The shared flag is only read and
 * written on the server thread (the snapshot is taken there, and full chunks are written there).
 *
 * <p>Verify mode ({@link Chunks#VERIFY}, CI's full runs): every shared container also keeps a real copy, and when the
 * snapshot has been serialised the shared data is compared with it, raw storage and palette; any difference falls
 * back (CI fails on it).
 *
 * <p>Other mods: a mod that writes a section's storage without the container's setters would change data a snapshot
 * shares. With a mod known to do so ({@link Chunks#WRITERS}) or a mixin of any mod but Quicksilver in vanilla's section or its
 * containers ({@link #init}), cow-sections stays off for the session, with one line naming it.
 */
public final class CowSections {
    public static final String ID = "cow-sections";
    public static final Chunks.Switch SWITCH = new Chunks.Switch(ID);

    /** The thread whose snapshot is being made now (one at a time: another thread's snapshot copies as vanilla does). */
    private static final java.util.concurrent.atomic.AtomicReference<Thread> sharing = new java.util.concurrent.atomic.AtomicReference<>();

    private CowSections() {
    }

    /** A container shared with a snapshot (PalettedContainerCowMixin). */
    public interface Shared {
        /** Whether this container's data is shared with another container. */
        boolean quicksilver$shared();

        /** Verify mode: the real copy taken alongside the share, or null; cleared once checked. */
        Object quicksilver$verifyCopy();

        void quicksilver$verifyCopy(Object data);

        /** The container's data (its bit storage and palette). */
        Object quicksilver$data();
    }

    /** Around a full chunk's save snapshot (SerializableChunkDataCowMixin), on the thread making it. */
    public static void begin() {
        if (!ready) {
            // share only once every hook of this optimisation is known to have landed (a write hook missing would
            // leave a shared section unprotected); the classes are loaded by now, the check is map lookups
            Chunks.checkHooks();
            ready = SWITCH.on && Chunks.allChecked(ID);
            if (!ready) return;
        }
        sharing.compareAndSet(null, Thread.currentThread());
    }

    private static volatile boolean ready = false;

    public static void end() {
        sharing.compareAndSet(Thread.currentThread(), null);
    }

    /** Whether a container copy made now (on this thread) shares instead of copying. */
    public static boolean sharing() {
        return SWITCH.on && sharing.get() == Thread.currentThread();
    }

    /** Verify mode: a shared container of a serialised snapshot against its real copy; a difference falls back. */
    public static void check(Object container, String where) {
        if (!(container instanceof Shared s)) return;
        Object copy = s.quicksilver$verifyCopy();
        if (copy == null) return;
        s.quicksilver$verifyCopy(null);
        String diff = differs((PalettedContainer.Data<?>) s.quicksilver$data(), (PalettedContainer.Data<?>) copy);
        if (diff != null) Chunks.fallback(SWITCH, "verify: a shared section of " + where + " differs from its real copy (" + diff + ")", null);
    }

    /** Null if two containers' data hold the same raw storage and palette, else what differs. */
    static String differs(PalettedContainer.Data<?> a, PalettedContainer.Data<?> b) {
        BitStorage sa = a.storage(), sb = b.storage();
        if (sa.getBits() != sb.getBits()) return "bits " + sa.getBits() + " vs " + sb.getBits();
        if (sa.getSize() != sb.getSize()) return "size " + sa.getSize() + " vs " + sb.getSize();
        if (!Arrays.equals(sa.getRaw(), sb.getRaw())) return "storage";
        Palette<?> pa = a.palette(), pb = b.palette();
        if (pa.getSize() != pb.getSize()) return "palette size " + pa.getSize() + " vs " + pb.getSize();
        for (int i = 0; i < pa.getSize(); i++) if (pa.valueFor(i) != pb.valueFor(i)) return "palette entry " + i;
        return null;
    }

    // ---- other mods' writes to sections (at start-up, on the main thread, before any server thread)

    /** The classes whose storage a snapshot shares: a mixin of another mod in any of them turns cow-sections off. */
    static final String[] GUARDED = {
        "net.minecraft.world.level.chunk.LevelChunkSection",
        "net.minecraft.world.level.chunk.PalettedContainer",
        "net.minecraft.world.level.chunk.PalettedContainer$Data",
    };

    /**
     * Main thread, at start-up: every mixin merged into the guarded classes (read from the {@code @MixinMerged} marks
     * Mixin leaves on the members it adds, as logic.hopper-cache does). One from a mod other than Quicksilver could write a
     * shared container's storage without unsharing it, so then cow-sections stays off for the session (one line naming
     * each). Not seen: a mod writing the storage from its own classes through vanilla's public getters (the known
     * writers above).
     */
    static void init() {
        if (!SWITCH.on) return;
        java.util.Set<String> all = new java.util.TreeSet<>();
        java.util.Set<String> foreign = new java.util.TreeSet<>();
        try {
            for (String name : GUARDED) {
                Class<?> c = Class.forName(name, false, CowSections.class.getClassLoader());
                java.util.List<java.lang.reflect.Member> members = new java.util.ArrayList<>(java.util.List.of(c.getDeclaredMethods()));
                members.addAll(java.util.List.of(c.getDeclaredFields()));
                members.addAll(java.util.List.of(c.getDeclaredConstructors()));
                for (java.lang.reflect.Member m : members) {
                    org.spongepowered.asm.mixin.transformer.meta.MixinMerged a =
                        ((java.lang.reflect.AnnotatedElement) m).getAnnotation(org.spongepowered.asm.mixin.transformer.meta.MixinMerged.class);
                    if (a == null) continue;
                    all.add(a.mixin());
                    if (a.mixin().startsWith("com.meakaandre.quicksilver.")) continue;
                    foreign.add("mixin " + a.mixin() + " (" + m.getName() + ")");
                }
            }
        } catch (Throwable t) {
            Chunks.fallback(SWITCH, "could not read the mixins applied to sections: " + t, t);
            return;
        }
        // (seen in CI's logs: which mixins the check found)
        Chunks.LOG.info("Quicksilver cow-sections: mixins applied to sections and their containers (Quicksilver's included): {}",
            all.isEmpty() ? "(none)" : String.join(", ", all));
        if (!foreign.isEmpty()) Chunks.off(SWITCH, "mods change sections' storage: " + String.join(", ", foreign));
    }
}
