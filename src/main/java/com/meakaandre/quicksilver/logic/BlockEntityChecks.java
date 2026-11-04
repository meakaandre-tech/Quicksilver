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
 *   once mods have initialised (a mod adding a valid block to a type later, during play, would leave a memo stale: a
 *   known limit). On the client's level too (the same exact answer).</li>
 * </ul>
 *
 * <p>The first is Lithium's {@code world.block_entity_ticking.chunk_tickable} idea, with the change counter added (Lithium
 * keeps the answer for the whole call); the second is Quicksilver's own.
 *
 * <p>With {@code -Dquicksilver.debug.verifyLogic=true} (CI's heap runs) every kept answer is checked against
 * vanilla's own call, and the optimisation falls back on a difference.
 */
public final class BlockEntityChecks {
    public static final String ID = "block-entity-checks";
    public static final Logic.Switch SWITCH = new Logic.Switch(ID);
    public static final boolean VERIFY = Logic.VERIFY;

    /**
     * Counted up on every simulation level write and every distance manager update run. Only the server thread writes it
     * (a dedicated server's or the integrated server's; one per JVM), so the plain increment is enough.
     */
    private static volatile long changes;

    private BlockEntityChecks() {
    }

    public static void changed() {
        changes++;
    }

    public static long changes() {
        return changes;
    }

    /** The hooks that count changes (both are also in the optimisation's hook list: one that didn't land falls back). */
    static final String TRACKER = "net.minecraft.server.level.SimulationChunkTracker";
    static final String CHUNK_CACHE = "net.minecraft.server.level.ServerChunkCache";
    private static volatile boolean countingChecked = false;

    /**
     * Whether the change counter is known to be counting: the simulation tracker's hook (every write of a chunk's
     * simulation level) must have landed. Checked once, when a server level first ticks its block entities (the tracker
     * exists by then); if it didn't land the optimisation falls back.
     */
    public static boolean counting() {
        if (countingChecked) return true;
        if (LogicMixins.called(TRACKER, "quicksilver$levelChanged")) {
            countingChecked = true;
            return true;
        }
        Logic.fallback(SWITCH, "the change hook didn't land (" + TRACKER + " setLevel)", null);
        return false;
    }

    /** CI's check: a kept answer differs from vanilla's. */
    public static void mismatch(String what) {
        Logic.fallback(SWITCH, "verify: " + what + " differs from vanilla's answer", null);
    }
}
