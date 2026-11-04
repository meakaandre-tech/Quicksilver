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
 * logs them, ci/server/scripted-run-core-border.txt).
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
 * write counts, the four-chunk rule) and its code are Quicksilver's own. No identity hash, reflection or thread: the
 * remembered objects are compared by reference.
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
        LevelChunk chunk;
        int sectionIndex;
        LevelChunkSection section;
        PalettedContainer<BlockState> states;
        int writes;
        BlockState state;
        BlockEntity blockEntity;
        Container container;

        void clear() {
            pos = null;
            chunk = null;
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

    /** The hopper's facing (accessor mixin). */
    public interface Facing {
        net.minecraft.core.Direction quicksilver$facing();
    }

    // ---- the lookup in progress (server thread only; one at a time: set by the hopper's own hook, used by the hooks
    // inside vanilla's lookup for exactly that position, then cleared)

    private static Entry current;
    private static BlockPos currentPos;
    /** Whether the current lookup is answered from its entry (decided once, at its first block read). */
    private static boolean currentHit;
    /** The state vanilla read for the current lookup when it isn't answered from the entry. */
    private static BlockState currentState;

    /** Starts a hopper's lookup of {@code pos} with its entry: decides whether the entry answers it. */
    public static void begin(Level level, Entry e, BlockPos pos) {
        current = e;
        currentPos = pos;
        currentState = null;
        currentHit = false;
        if (!SWITCH.on) return;
        try {
            currentHit = valid(level, e, pos);
        } catch (Throwable t) {
            SWITCH.fail(t);
            currentHit = false;
        }
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
        if (e.chunk == null || !(level instanceof ServerLevel server) || !pos.equals(e.pos)) return false;
        LevelChunk c = peek(server, pos.getX() >> 4, pos.getZ() >> 4);
        if (c != e.chunk) return false;
        LevelChunkSection[] sections = c.getSections();
        int i = e.sectionIndex;
        if (i < 0 || i >= sections.length || sections[i] != e.section) return false;
        PalettedContainer<BlockState> states = e.section.getStates();
        if (states != e.states || ((SectionMasks.Writes) states).quicksilver$writes() != e.writes) return false;
        return e.blockEntity == null || !e.blockEntity.isRemoved();
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
            if (be == null || be.isRemoved()) return;
            if (c == be) {
                // a chest that is half of a double chest: its container depends on the other half
                if (state.hasProperty(BlockStateProperties.CHEST_TYPE) && state.getValue(BlockStateProperties.CHEST_TYPE) != ChestType.SINGLE) return;
            } else if (c != null || be instanceof Container) {
                return;
            }
        }
        PalettedContainer<BlockState> states = section.getStates();
        e.pos = pos.immutable();
        e.chunk = chunk;
        e.sectionIndex = i;
        e.section = section;
        e.states = states;
        e.writes = ((SectionMasks.Writes) states).quicksilver$writes();
        e.state = state;
        e.blockEntity = be;
        e.container = c;
    }

    // ---- CI's verify mode: the caller runs vanilla's own read or lookup as well, between these two calls

    /** Before vanilla's read in verify mode: the cache's four chunks as they are. */
    public static long[] before(Level level) {
        return snapshot((ServerLevel) level);
    }

    /** After it: vanilla's answer must be the remembered one, and its chunk lookups must not have missed. */
    public static void check(Level level, BlockPos pos, long[] before, Object remembered, Object vanilla, String what) {
        if (vanilla != remembered) {
            Logic.fallback(SWITCH, "verify: remembered " + what + " " + remembered + " at " + pos + " but vanilla finds " + vanilla, null);
        } else if (!java.util.Arrays.equals(before, snapshot((ServerLevel) level))) {
            Logic.fallback(SWITCH, "verify: vanilla's " + what + " lookup at " + pos + " was not among the last four chunks", null);
        }
    }

    /** The cache's four positions, and what each slot holds (enough to see a miss, which moves them along). */
    private static long[] snapshot(ServerLevel level) {
        Recent r = (Recent) level.getChunkSource();
        long[] out = new long[8];
        long[] pos = r.quicksilver$lastPos();
        ChunkAccess[] chunks = r.quicksilver$lastChunk();
        for (int i = 0; i < 4; i++) {
            out[i] = pos[i];
            out[4 + i] = chunks[i] == null ? 0 : (chunks[i] instanceof LevelChunk ? 1 : 2);
        }
        return out;
    }
}
