package com.meakaandre.quicksilver.logic;

/**
 * P2-3, logic.block-entity-checks: the checks vanilla makes for every ticking block entity, every tick, before ticking
 * it, answered from what is already known when nothing they depend on can have changed:
 *
 * <ul>
 *   <li>{@code Level#tickBlockEntities} asks {@code shouldTickBlocksAt(pos)} (the chunk's simulation level, a hash
 *   lookup) for each block entity. Block entities are listed largely chunk by chunk, so the answer for the chunk asked
 *   last is kept: a "yes" for the same chunk is given again, as long as no chunk's simulation level can have changed
 *   since. Every write of a simulation level, and every run of the distance manager's updates, counts up a number
 *   ({@link #changed}); a kept answer is used only while that number is the same, and only within one
 *   {@code tickBlockEntities} call ({@code mixin/logic/LevelBlockEntityTickMixin}).</li>
 *   <li>Each block entity's tick wrapper asks {@code BlockEntityType#isValid(state)} (a hash set lookup of the state's
 *   block). The wrapper keeps the last state it asked about, the type and the answer, and gives the same answer for the
 *   same state and type ({@code mixin/logic/BoundTickingBlockEntityMixin}). A block entity type's valid blocks are fixed
 *   once the game has started.</li>
 * </ul>
 *
 * <p>The first is Lithium's {@code world.block_entity_ticking.chunk_tickable} idea, with the change counter added (Lithium
 * keeps the answer for the whole call); the second is Quicksilver's own.
 *
 * <p>With {@code -Dquicksilver.debug.verifyLogic=true} (CI's server suite) every kept answer is checked against
 * vanilla's own call, and the optimisation falls back on a difference.
 */
public final class BlockEntityChecks {
    public static final String ID = "block-entity-checks";
    public static final Logic.Switch SWITCH = new Logic.Switch(ID);
    public static final boolean VERIFY = BrainBehaviours.VERIFY;

    /** Counted up on every simulation level write and every distance manager update run (server thread only). */
    private static volatile long changes;

    private BlockEntityChecks() {
    }

    public static void changed() {
        changes++;
    }

    public static long changes() {
        return changes;
    }

    /** The hooks that count changes: at least one must have landed before a kept answer is used. */
    static final String TRACKER = "net.minecraft.server.level.SimulationChunkTracker";
    static final String CHUNK_CACHE = "net.minecraft.server.level.ServerChunkCache";
    private static volatile boolean countingChecked = false;

    /**
     * Whether the change counter is known to be counting (one of its hooks landed). Checked once, when the first server
     * level ticks its block entities (the distance manager, its tracker and the chunk cache exist by then); if neither
     * hook landed the optimisation falls back.
     */
    public static boolean counting() {
        if (countingChecked) return true;
        boolean tracker = LogicMixins.called(TRACKER, "quicksilver$levelChanged");
        boolean cache = LogicMixins.called(CHUNK_CACHE, "quicksilver$distanceUpdates");
        if (tracker || cache) {
            countingChecked = true;
            return true;
        }
        Logic.fallback(SWITCH, "neither change hook landed (" + TRACKER + " setLevel, " + CHUNK_CACHE + " runDistanceManagerUpdates)", null);
        return false;
    }

    /** CI's check: a kept answer differs from vanilla's. */
    public static void mismatch(String what) {
        Logic.fallback(SWITCH, "verify: " + what + " differs from vanilla's answer", null);
    }
}
