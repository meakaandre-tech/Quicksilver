package com.meakaandre.quicksilver.logic;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.PalettedContainer;
import net.minecraft.world.level.chunk.status.ChunkStatus;

/**
 * P2-3b, logic.hopper-cache. A hopper that isn't cooling down looks up, every tick, the block it gives to (the block it
 * faces) and the block it takes from (the block above): the block state, then (for a block with a block entity) the
 * block entity, each read through the level's chunk lookup. Each hopper here remembers, for each of the two, what that
 * lookup found (the state, the block's container or none, the block entity it came from) together with the chunk
 * section it read it from and that section's block write count (P2-2's per-container counter, {@link SectionMasks.Writes}).
 * While no block of that section has been written since, the block entity (if any) hasn't been removed, and the hopper's
 * own state hasn't changed, the lookup's answer is the remembered one, and it is given without reading the world.
 *
 * <p><b>The chunk lookups stay vanilla's.</b> Every read of a block goes through the server's chunk lookup, which keeps
 * the last four chunks it gave out; one that isn't among them (a "miss") is looked up properly and gives the chunk a
 * one-tick ticket, which can keep a chunk loaded a tick longer, and moves the four along. A remembered answer is given
 * only when vanilla's first lookup for that block would have found the chunk among the four (read here without changing
 * them: {@link #peek}), and then every lookup vanilla's code makes for that block finds it there too (it changes
 * nothing). Otherwise vanilla's own code runs, misses and tickets included, and the answer is remembered afresh. So the
 * server's four chunks, its tickets and which chunks stay loaded are exactly vanilla's, at every tick (CI's border run
 * logs them at every tick's end, ci/server/scripted-run-core-border.txt, and its verify run checks every remembered
 * answer as it is given). That is the game's state; the one thing an answered lookup leaves out is the profiler's count of
 * chunk lookups (a debug counter, not game state).
 *
 * <p>What is remembered, and only that (anything else runs vanilla's code every time):
 * <ul>
 * <li>a block without a block entity, which isn't a {@link WorldlyContainerHolder} (a composter makes a new container
 * for every lookup): vanilla finds no container there;</li>
 * <li>a block entity that is the container vanilla's lookup gave (a single chest, a barrel, a hopper, a furnace, a modded
 * container), not part of a double chest (whose other half can be in another section);</li>
 * <li>a block entity that isn't a container: vanilla finds none there.</li>
 * </ul>
 * The entity container lookup (a chest minecart where the block has none) and the Fabric transfer API's lookup that
 * follow a "none" are left to vanilla's code, in their usual place.
 *
 * <p>The idea (hoppers remembering the containers they use) is Lithium's {@code block.hopper}; this design (the section
 * write counts, the four-chunk rule) and its code are Quicksilver's own. No identity hash, and no reflection or thread
 * on the server thread (the one reflective read, of the mixins applied to hoppers, is at start-up on the main thread:
 * {@link #init}); the remembered objects are compared by reference.
 *
 * <p>Other mods: with a mixin of any mod but Quicksilver in vanilla's hopper (Fabric API's two transfer hooks aside), the
 * cache stays off for the session ({@link #init}).
 *
 * <p>With {@code -Dquicksilver.debug.verifyLogic=true} every remembered answer is checked against vanilla's own lookup
 * as it is given (the same state, the same container, and the server's four chunks unchanged by the lookup: no miss);
 * any difference falls back.
 */
public final class HopperCache {
    public static final String ID = "hopper-cache";
    public static final Logic.Switch SWITCH = new Logic.Switch(ID);
    public static final boolean VERIFY = Logic.VERIFY;

    private HopperCache() {
    }

    /** One remembered lookup: one block a hopper takes from or gives to. */
    public static final class Entry {
        BlockPos pos;
        int sectionIndex;
        LevelChunkSection section;
        PalettedContainer<BlockState> states;
        int writes;
        BlockState state;
        BlockEntity blockEntity;
        Container container;

        /**
         * Fabric's transfer lookup at this position (ItemStorage.SIDED) found nothing, under these same section writes,
         * for a block without a block entity that no provider is registered for ({@link #fabricRemember}).
         */
        boolean fabricNone;

        void clear() {
            fabricNone = false;
            pos = null;
            section = null;
            states = null;
            state = null;
            blockEntity = null;
            container = null;
        }
    }

    /** A hopper block entity's two entries (mixin). */
    public interface Holder {
        Entry quicksilver$extract();

        Entry quicksilver$insert();

        /** Both forgotten (the hopper's state changed). */
        void quicksilver$forget();
    }

    /** The server chunk cache's last four chunks (accessor mixin). */
    public interface Recent {
        long[] quicksilver$lastPos();

        ChunkStatus[] quicksilver$lastStatus();

        ChunkAccess[] quicksilver$lastChunk();

        Thread quicksilver$mainThread();
    }

    // ---- the lookup in progress (server thread only; one at a time: set by the hopper's own hook, used by the hooks
    // inside vanilla's lookup for exactly that position, then cleared)

    private static Entry current;
    private static BlockPos currentPos;
    /** Whether the current lookup is answered from its entry (decided once, at its first block read). */
    private static boolean currentHit;
    /** The state vanilla read for the current lookup when it isn't answered from the entry. */
    private static BlockState currentState;

    /**
     * Starts a hopper's lookup of {@code pos} with its entry: decides whether the entry answers it. Only a server level's
     * lookup on its own server thread starts one (anywhere else nothing is set and vanilla's code runs as it is).
     */
    public static void begin(Level level, Entry e, BlockPos pos) {
        end();
        pending = null;
        if (!SWITCH.on || !(level instanceof ServerLevel server)
            || Thread.currentThread() != ((Recent) server.getChunkSource()).quicksilver$mainThread()) return;
        current = e;
        currentPos = pos;
        try {
            currentHit = valid(level, e, pos);
        } catch (Throwable t) {
            SWITCH.fail(t);
            currentHit = false;
        }
    }

    /**
     * A hopper's lookup of {@code pos} whose block vanilla has already read ({@code state}): started here if its block
     * read didn't start it (that hook is optional). Vanilla's read was the lookup's first chunk lookup, so whether the
     * rest would miss is decided after it, as for any lookup.
     */
    public static void beginAfterRead(Level level, Entry e, BlockPos pos, BlockState state) {
        if (current == e && isCurrent(pos)) return;
        begin(level, e, pos);
        if (currentHit && state != e.state) currentHit = false;
        if (!currentHit) currentState = state;
    }

    /** Ends the current lookup (always, also on an exception). */
    public static void end() {
        current = null;
        currentPos = null;
        currentState = null;
        currentHit = false;
    }

    /** Whether the hooks inside vanilla's lookup are looking at the current lookup's block. */
    private static boolean isCurrent(BlockPos pos) {
        return current != null && currentPos != null && currentPos.equals(pos);
    }

    /**
     * Whether a block read inside vanilla's lookup ({@code Level.getBlockState} at {@code pos}) is the current lookup's
     * and the entry answers it: then the caller returns {@link #answerState()} instead of reading.
     */
    public static boolean answersState(BlockPos pos) {
        return currentHit && isCurrent(pos);
    }

    public static BlockState answerState() {
        return current.state;
    }

    /** After vanilla's own read of {@code pos} inside a lookup the entry doesn't answer: kept to be remembered. */
    public static void read(BlockPos pos, BlockState state) {
        if (!currentHit && isCurrent(pos)) currentState = state;
    }

    /**
     * Whether the block container lookup ({@code getBlockContainer} at {@code pos} for {@code state}) is the current
     * lookup's and the entry answers it: then the caller returns {@link #answerContainer()} instead of looking up.
     */
    public static boolean answersContainer(BlockPos pos, BlockState state) {
        return currentHit && isCurrent(pos) && state == current.state;
    }

    public static Container answerContainer() {
        return current.container;
    }

    /** After vanilla's own container lookup inside a lookup the entry doesn't answer: remembered when it can be. */
    public static void found(Level level, BlockPos pos, BlockState state, Container c) {
        if (currentHit || !isCurrent(pos)) return;
        Entry e = current;
        if (!SWITCH.on || state != currentState) {
            e.clear();
            return;
        }
        try {
            remember(level, e, pos, state, c);
        } catch (Throwable t) {
            SWITCH.fail(t);
            e.clear();
        }
    }

    // ---- validity and remembering

    /** The packed key the server's chunk cache uses for a chunk position (x in the low 32 bits, z in the high). */
    private static long key(int cx, int cz) {
        return (cx & 0xFFFFFFFFL) | (cz & 0xFFFFFFFFL) << 32;
    }

    /**
     * The chunk vanilla's {@code level.getChunk(cx, cz)} would return from the cache's last four chunks without changing
     * anything (the same loop as the game's: the position and the full status, an empty slot skipped), or null if that
     * call would miss (or run anywhere but the server thread). Reads the four only.
     */
    static LevelChunk peek(ServerLevel level, int cx, int cz) {
        ServerChunkCache cache = level.getChunkSource();
        Recent r = (Recent) cache;
        if (Thread.currentThread() != r.quicksilver$mainThread()) return null;
        long k = key(cx, cz);
        long[] pos = r.quicksilver$lastPos();
        ChunkStatus[] status = r.quicksilver$lastStatus();
        ChunkAccess[] chunks = r.quicksilver$lastChunk();
        for (int i = 0; i < 4; i++) {
            if (pos[i] == k && status[i] == ChunkStatus.FULL) {
                ChunkAccess c = chunks[i];
                if (c != null) return c instanceof LevelChunk lc ? lc : null;
            }
        }
        return null;
    }

    /** Whether the entry answers a lookup of {@code pos} now, exactly as vanilla's code would. */
    static boolean valid(Level level, Entry e, BlockPos pos) {
        if (e.section == null || !(level instanceof ServerLevel server) || !pos.equals(e.pos)) return false;
        LevelChunk c = peek(server, pos.getX() >> 4, pos.getZ() >> 4);
        // (the same section object: the same chunk, still loaded; a chunk loaded again has new sections)
        if (c == null) return false;
        LevelChunkSection[] sections = c.getSections();
        int i = e.sectionIndex;
        if (i < 0 || i >= sections.length || sections[i] != e.section) return false;
        PalettedContainer<BlockState> states = e.section.getStates();
        if (states != e.states || ((SectionMasks.Writes) states).quicksilver$writes() != e.writes) return false;
        // (and still at that position: a mod that moves block entities without removing them)
        return e.blockEntity == null || (!e.blockEntity.isRemoved() && e.blockEntity.getBlockPos().equals(pos));
    }

    /**
     * After vanilla's own lookup of {@code pos} (its state {@code state}, its container {@code c}): remembers it when it
     * can be given again while the section and block entity stay as they are (the list in the class comment).
     */
    static void remember(Level level, Entry e, BlockPos pos, BlockState state, Container c) {
        e.clear();
        if (!(level instanceof ServerLevel server) || level.isOutsideBuildHeight(pos)) return;
        if (state.getBlock() instanceof WorldlyContainerHolder) return;
        // the chunk vanilla's lookup just read (it is among the four now; if not, nothing is remembered)
        LevelChunk chunk = peek(server, pos.getX() >> 4, pos.getZ() >> 4);
        if (chunk == null) return;
        int i = chunk.getSectionIndex(pos.getY());
        LevelChunkSection[] sections = chunk.getSections();
        if (i < 0 || i >= sections.length) return;
        LevelChunkSection section = sections[i];
        if (section == null || section.getBlockState(pos.getX() & 15, pos.getY() & 15, pos.getZ() & 15) != state) return;
        BlockEntity be = null;
        if (!state.hasBlockEntity()) {
            if (c != null) return;
        } else {
            be = chunk.getBlockEntities().get(pos);
            if (be == null || be.isRemoved() || !be.getBlockPos().equals(pos)) return;
            if (c == be) {
                // a chest that is half of a double chest: its container depends on the other half
                if (state.hasProperty(BlockStateProperties.CHEST_TYPE) && state.getValue(BlockStateProperties.CHEST_TYPE) != ChestType.SINGLE) return;
            } else if (c != null || be instanceof Container) {
                return;
            }
        }
        PalettedContainer<BlockState> states = section.getStates();
        e.pos = pos.immutable();
        e.sectionIndex = i;
        e.section = section;
        e.states = states;
        e.writes = ((SectionMasks.Writes) states).quicksilver$writes();
        e.state = state;
        e.blockEntity = be;
        e.container = c;
    }

    // ---- CI's verify mode: the caller runs vanilla's own read or lookup as well, between these two calls

    /** Remembered answers checked against vanilla's in verify mode (server thread; logged when the server stops). */
    private static long checks = 0;

    public static long checks() {
        return checks;
    }

    /** Before vanilla's read in verify mode: the cache's four chunks as they are. */
    public static Object[] before(Level level) {
        return snapshot((ServerLevel) level);
    }

    /**
     * After it: vanilla's answer must be the remembered one, and its chunk lookups must not have missed (the four slots'
     * positions, statuses and chunks unchanged). Returns the answer to give: vanilla's (the same one, or after a difference,
     * which falls back).
     */
    public static <T> T check(Level level, BlockPos pos, Object[] before, T remembered, T vanilla, String what) {
        checks++;
        if (vanilla != remembered) {
            Logic.fallback(SWITCH, "verify: remembered " + what + " " + remembered + " at " + pos + " but vanilla finds " + vanilla, null);
        } else if (!sameSlots(before, snapshot((ServerLevel) level))) {
            Logic.fallback(SWITCH, "verify: vanilla's " + what + " lookup at " + pos + " was not among the last four chunks", null);
        }
        // (after a difference the lookup is answered by vanilla's code from here on)
        if (!SWITCH.on) end();
        return vanilla;
    }

    /** The cache's four slots: positions (boxed, compared by value), statuses and chunks (compared by reference). */
    private static Object[] snapshot(ServerLevel level) {
        Recent r = (Recent) level.getChunkSource();
        Object[] out = new Object[12];
        long[] pos = r.quicksilver$lastPos();
        ChunkStatus[] status = r.quicksilver$lastStatus();
        ChunkAccess[] chunks = r.quicksilver$lastChunk();
        for (int i = 0; i < 4; i++) {
            out[i] = pos[i];
            out[4 + i] = status[i];
            out[8 + i] = chunks[i];
        }
        return out;
    }

    private static boolean sameSlots(Object[] a, Object[] b) {
        for (int i = 0; i < 12; i++) {
            if (i < 4 ? !a[i].equals(b[i]) : a[i] != b[i]) return false;
        }
        return true;
    }

    // ---- Fabric's transfer lookup after a "none" (Andre, 2026-11-06)
    //
    // When vanilla's lookup finds no container, Fabric API's hopper hooks ask ItemStorage.SIDED at the same position
    // (BlockApiLookupImpl.find: the block read, its block entity if the state has one, the block's own provider, then
    // the fallback providers in order). For a block without a block entity, that is not a WorldlyContainerHolder and has
    // no provider of its own, with exactly Fabric's two fallbacks registered, that answer is "none" whatever the
    // direction: the first fallback needs a block entity, the second one too or a WorldlyContainerHolder. So it is
    // remembered with the entry (the same section and write count) and given again, without the call, while the entry
    // holds and Fabric's own block read would hit the four chunks (peek). Not given: anything else, or for the session
    // once the fallback list is not exactly Fabric's two (one line in the log). The skipped call's provider lookup hashes
    // a Block by identity: a hash the game computed when it registered the block, so skipping it changes no later hash.

    /** Whether Fabric's "none" is cached this session (and why not). */
    private static volatile boolean fabricOn = true;
    private static volatile String fabricWhy = null;

    /** Fabric's own two fallback providers, as at start-up (compared by reference before each use). */
    private static Object fabric0, fabric1;
    private static java.util.List<?> fabricList;

    /** The hopper lookup that just found "none" (set after vanilla's lookup, taken by Fabric's next find). */
    private static Entry pending;
    private static BlockPos pendingPos;
    private static Level pendingLevel;
    /** The server thread these belong to (Fabric's find is also called on other threads: those leave them alone). */
    private static Thread owner;

    /** Inside Fabric's find for that lookup: the entry to remember "none" in, and whether the block had no provider. */
    private static Entry observing;
    private static boolean observedNoProvider;
    private static Object[] fabricBefore;
    private static long fabricChecks = 0;

    public static long fabricChecks() {
        return fabricChecks;
    }

    public static boolean fabricOn() {
        return fabricOn;
    }

    public static String fabricWhy() {
        return fabricWhy;
    }

    /** Fabric's "none" off for the session (one line). */
    public static void fabricOff(String why) {
        if (!fabricOn) return;
        fabricOn = false;
        fabricWhy = why;
        Logic.LOG.info("Quicksilver hopper-cache: Fabric's \"none\" not cached for the session ({})", why);
    }

    /** Main thread, at start-up: Fabric's fallback providers for ItemStorage.SIDED must be exactly its own two. */
    static void fabricInit() {
        try {
            java.util.List<?> list = ((net.fabricmc.fabric.impl.lookup.block.BlockApiLookupImpl<?, ?>)
                net.fabricmc.fabric.api.transfer.v1.item.ItemStorage.SIDED).getFallbackProviders();
            java.util.List<String> names = new java.util.ArrayList<>();
            boolean fabrics = list.size() == 2;
            for (Object f : list) {
                String n = f.getClass().getName();
                names.add(n);
                fabrics &= n.startsWith("net.fabricmc.fabric.api.transfer.v1.item.ItemStorage$$");
            }
            if (!fabrics) {
                fabricOff("the fallback providers for item storage are not exactly Fabric's two: " + names);
                return;
            }
            fabricList = list;
            fabric0 = list.get(0);
            fabric1 = list.get(1);
        } catch (Throwable t) {
            fabricOff("could not read Fabric's fallback providers: " + t);
        }
    }

    /** The fallback list still exactly Fabric's two (a mod that registers one later turns this off for the session). */
    private static boolean fabricListSame() {
        java.util.List<?> l = fabricList;
        if (l != null && l.size() == 2 && l.get(0) == fabric0 && l.get(1) == fabric1) return true;
        fabricOff("a fallback provider for item storage was registered after start-up");
        return false;
    }

    /** The entry's block: no block entity, not a WorldlyContainerHolder, remembered as "none" by vanilla's lookup. */
    private static boolean fabricEligible(Entry e) {
        return e.section != null && e.state != null && e.blockEntity == null && e.container == null
            && !e.state.hasBlockEntity() && !(e.state.getBlock() instanceof WorldlyContainerHolder);
    }

    /** After a hopper's lookup of {@code pos}: vanilla's answer was "none", so Fabric's lookup comes next. */
    public static void after(Level level, BlockPos pos, Container c) {
        pending = null;
        if (c != null || !fabricOn || !SWITCH.on || current == null || !isCurrent(pos)) return;
        pending = current;
        pendingPos = pos;
        pendingLevel = level;
        owner = Thread.currentThread();
    }

    /**
     * Head of Fabric's find: true to answer "none" without it. Only the find of the hopper lookup just marked (the same
     * level and position, ItemStorage.SIDED, no state or block entity passed: Fabric's hooks).
     */
    public static boolean fabricAnswers(Object lookup, Level level, BlockPos pos, BlockState state, BlockEntity be) {
        if (Thread.currentThread() != owner) return false;
        Entry e = pending;
        // (a find inside the observed one, or any other find: whatever was being observed is dropped)
        observing = null;
        fabricBefore = null;
        if (e == null) return false;
        pending = null;
        if (lookup != net.fabricmc.fabric.api.transfer.v1.item.ItemStorage.SIDED || state != null || be != null
            || level != pendingLevel || !pos.equals(pendingPos) || !fabricOn || !SWITCH.on) return false;
        if (!fabricEligible(e) || !valid(level, e, pos) || !fabricListSame()) return false;
        if (e.fabricNone) {
            if (!VERIFY) return true;
            // verify mode: Fabric's find runs, and must find nothing without a chunk lookup that misses
            fabricBefore = before(level);
            observing = e;
            return false;
        }
        observing = e;
        observedNoProvider = false;
        return false;
    }

    /** Fabric's find asked for the block's own provider (only noted for the lookup being observed). */
    public static void fabricProvider(Object provider) {
        if (observing != null && Thread.currentThread() == owner) observedNoProvider = provider == null;
    }

    /** End of Fabric's find: remember its "none" (or, in verify mode, check the remembered one). */
    public static Object fabricResult(Level level, BlockPos pos, Object result) {
        Entry e = observing;
        if (e == null || Thread.currentThread() != owner) return result;
        observing = null;
        Object[] before = fabricBefore;
        fabricBefore = null;
        if (before != null) {
            fabricChecks++;
            return check(level, pos, before, null, result, "Fabric lookup");
        }
        if (result == null && observedNoProvider && fabricOn && SWITCH.on && fabricEligible(e) && valid(level, e, pos)) {
            e.fabricNone = true;
        }
        return result;
    }

    // ---- other mods' changes to hoppers (at start-up, on the main thread, before any server thread)

    /**
     * Other mods' hopper hooks that change none of the lookups the cache answers (by mixin and handler name, as the
     * mesher's list): anything else those mixins add later is still caught.
     */
    private static final String[][] KEPT = {
        // Fabric API's transfer hooks: run after vanilla's lookups, on a "none", outside the lookup
        {"net.fabricmc.fabric.mixin.transfer.HopperBlockEntityMixin", "hookInsert"},
        {"net.fabricmc.fabric.mixin.transfer.HopperBlockEntityMixin", "hookExtract"},
        // SIFTEC's claims (CI run 41968436348): at the head of suckInItems and ejectItems, they read the hopper's own
        // state and cancel the whole transfer across a claim or sealed-building border, before any lookup starts; when
        // they don't, vanilla's code runs as usual (their block read is before the lookup, in vanilla's runs too)
        {"com.meakaandre.siftec.mixin.claim.ClaimHopperMixin", "siftec$noSiphon"},
        {"com.meakaandre.siftec.mixin.claim.ClaimHopperMixin", "siftec$noPush"},
    };

    /**
     * Main thread, at start-up: every mixin merged into vanilla's hopper (read from the {@code @MixinMerged} marks Mixin
     * leaves on the members it adds, as the mesher does). One from a mod other than Quicksilver, but for Fabric API's two
     * transfer hooks, could make a lookup's answer depend on something the cache doesn't watch, so then the cache stays
     * off for the session (one line naming each). Not seen: a mod's change to the code vanilla's lookup calls (a chest's
     * own container, the level's block entity lookup).
     */
    static void init() {
        if (!SWITCH.on) return;
        java.util.Set<String> all = new java.util.TreeSet<>();
        java.util.Set<String> foreign = new java.util.TreeSet<>();
        try {
            Class<?> c = Class.forName("net.minecraft.world.level.block.entity.HopperBlockEntity", false, HopperCache.class.getClassLoader());
            java.util.List<java.lang.reflect.Member> members = new java.util.ArrayList<>(java.util.List.of(c.getDeclaredMethods()));
            members.addAll(java.util.List.of(c.getDeclaredFields()));
            for (java.lang.reflect.Member m : members) {
                org.spongepowered.asm.mixin.transformer.meta.MixinMerged a =
                    ((java.lang.reflect.AnnotatedElement) m).getAnnotation(org.spongepowered.asm.mixin.transformer.meta.MixinMerged.class);
                if (a == null) continue;
                all.add(a.mixin());
                if (a.mixin().startsWith("com.meakaandre.quicksilver.")) continue;
                boolean kept = false;
                // (the handler itself, prefixed by Mixin, or a lambda inside it: "...$lambda$hookExtract$0$0", CI 41963694647)
                for (String[] k : KEPT) kept |= a.mixin().equals(k[0]) && (m.getName().endsWith("$" + k[1]) || m.getName().contains("$lambda$" + k[1] + "$"));
                if (!kept) foreign.add("mixin " + a.mixin() + " (" + m.getName() + ")");
            }
        } catch (Throwable t) {
            Logic.fallback(SWITCH, "could not read the mixins applied to hoppers: " + t, t);
            return;
        }
        // (seen in CI's logs: which mixins the check found)
        Logic.LOG.info("Quicksilver hopper-cache: mixins applied to vanilla's hopper (Quicksilver's included): {}",
            all.isEmpty() ? "(none)" : String.join(", ", all));
        if (!foreign.isEmpty()) {
            Logic.off(SWITCH, "mods change vanilla's hopper: " + String.join(", ", foreign));
            return;
        }
        fabricInit();
    }
}
