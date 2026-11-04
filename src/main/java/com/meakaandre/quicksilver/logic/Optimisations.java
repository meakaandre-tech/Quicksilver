package com.meakaandre.quicksilver.logic;

import java.util.List;
import java.util.Map;

/**
 * The Logic module's optimisations: their ids and descriptions (the status line and the config file), which mixins
 * belong to each ({@link LogicMixins}), and the hooks each must have landed (checked when a server starts).
 */
final class Optimisations {
    private Optimisations() {
    }

    /** One optimisation: id, what it does, its mixins (simple names), and its hooks (target class, handler name). */
    private record Opt(String id, String what, List<String> mixins, List<String[]> hooks) {
    }

    private static final List<Opt> ALL = List.of(
        new Opt(SectionMasks.ID, "block collision sweeps skip, unread, positions that hold air and shell positions without an oversized shape (per-section masks)",
            List.of("BlockCollisionsMixin", "LevelChunkSectionMixin", "PalettedContainerMixin"),
            List.<String[]>of(new String[] {"net.minecraft.world.level.BlockCollisions", "call:quicksilver$skipEdges"},
                new String[] {"net.minecraft.world.level.chunk.LevelChunkSection", "quicksilver$mask"},
                new String[] {"net.minecraft.world.level.chunk.LevelChunkSection", "call:quicksilver$beforeSet"},
                new String[] {"net.minecraft.world.level.chunk.LevelChunkSection", "call:quicksilver$afterSet"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$getAndSet"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$getAndSetUnchecked"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$set"},
                new String[] {"net.minecraft.world.level.chunk.PalettedContainer", "call:quicksilver$read"})),
        new Opt(EntitySections.ID, "entity sections near a small box looked up directly, in vanilla's order (Lithium's fast_retrieval)",
            List.of("EntitySectionStorageMixin"),
            List.<String[]>of(new String[] {"net.minecraft.world.level.entity.EntitySectionStorage", "call:quicksilver$sections"})),
        new Opt(EntityCollisions.ID, "lookups for entities to collide with like blocks answered from per-section counts when there are none",
            List.of("EntityGetterMixin", "EntitySectionMixin", "EntityTypeMixin", "ServerLevelEntitiesAccessor", "PersistentEntitySectionManagerAccessor"),
            List.<String[]>of(new String[] {"net.minecraft.world.level.EntityGetter", "call:quicksilver$noHardEntities"},
                new String[] {"net.minecraft.world.level.entity.EntitySection", "call:quicksilver$added"},
                new String[] {"net.minecraft.world.level.entity.EntitySection", "call:quicksilver$removed"},
                new String[] {"net.minecraft.world.entity.EntityType", "quicksilver$memo"},
                new String[] {"net.minecraft.server.level.ServerLevel", "quicksilver$entityManager"},
                new String[] {"net.minecraft.world.level.entity.PersistentEntitySectionManager", "quicksilver$sectionStorage"})),
        // P2-3
        new Opt(BrainBehaviours.ID, "a brain's behaviours walked from a flat copy of its behaviour maps, in their order, each activity checked as vanilla checks it",
            List.of("BrainMixin"),
            List.<String[]>of(new String[] {"net.minecraft.world.entity.ai.Brain", "call:quicksilver$startEach"},
                new String[] {"net.minecraft.world.entity.ai.Brain", "call:quicksilver$running"},
                new String[] {"net.minecraft.world.entity.ai.Brain", "call:quicksilver$changed"},
                new String[] {"net.minecraft.world.entity.ai.Brain", "call:quicksilver$cleared"})),
        new Opt(GateBehaviours.ID, "gate behaviours tick, start and stop their members with loops instead of streams, in the same order",
            List.of("GateBehaviorMixin", "ShufflingListAccessor"),
            List.<String[]>of(new String[] {"net.minecraft.world.entity.ai.behavior.GateBehavior", "call:quicksilver$tick"},
                new String[] {"net.minecraft.world.entity.ai.behavior.GateBehavior", "call:quicksilver$stop"},
                new String[] {"net.minecraft.world.entity.ai.behavior.GateBehavior", "call:quicksilver$policy"},
                new String[] {"net.minecraft.world.entity.ai.behavior.ShufflingList", "quicksilver$entries"})),
        new Opt(HopperEntities.ID, "hoppers' item and container entity lookups answered from per-section counts when there are none",
            List.of("HopperBlockEntityMixin", "EntitySectionHopperMixin", "ServerLevelEntitiesAccessor", "PersistentEntitySectionManagerAccessor"),
            List.<String[]>of(new String[] {"net.minecraft.world.level.block.entity.HopperBlockEntity", "call:quicksilver$items"},
                new String[] {"net.minecraft.world.level.block.entity.HopperBlockEntity", "call:quicksilver$containers"},
                new String[] {"net.minecraft.world.level.entity.EntitySection", "call:quicksilver$hopperAdded"},
                new String[] {"net.minecraft.world.level.entity.EntitySection", "call:quicksilver$hopperRemoved"},
                new String[] {"net.minecraft.server.level.ServerLevel", "quicksilver$entityManager"},
                new String[] {"net.minecraft.world.level.entity.PersistentEntitySectionManager", "quicksilver$sectionStorage"})),
        new Opt(BlockEntityChecks.ID, "block entity ticking: the chunk ticking check and BlockEntityType.isValid answered again while nothing they depend on changed",
            List.of("LevelBlockEntityTickMixin", "BoundTickingBlockEntityMixin", "SimulationChunkTrackerMixin", "ServerChunkCacheChangesMixin"),
            List.<String[]>of(new String[] {"net.minecraft.world.level.Level", "call:quicksilver$beBegin"},
                new String[] {"net.minecraft.world.level.Level", "call:quicksilver$shouldTick"},
                new String[] {"net.minecraft.world.level.chunk.LevelChunk$BoundTickingBlockEntity", "call:quicksilver$valid"},
                new String[] {BlockEntityChecks.TRACKER, "call:quicksilver$levelChanged"},
                new String[] {BlockEntityChecks.CHUNK_CACHE, "call:quicksilver$distanceUpdates"})));

    /** Each optimisation, in the order the status line lists them. */
    static void register(Map<String, String> m) {
        for (Opt o : ALL) m.put(o.id(), o.what());
    }

    /** Each mixin class (simple name) and the optimisations it belongs to (a shared accessor can serve more than one). */
    static List<String> owners(String mixinSimpleName) {
        List<String> ids = new java.util.ArrayList<>();
        for (Opt o : ALL) if (o.mixins().contains(mixinSimpleName)) ids.add(o.id());
        return ids;
    }

    /** Hooks already checked, per optimisation (id, target and name): a hook two optimisations share is checked for each. */
    private static final java.util.Set<String> CHECKED = java.util.concurrent.ConcurrentHashMap.newKeySet();

    /**
     * An optimisation that is on but whose hooks didn't land falls back (CI fails on it). Only classes the game has
     * already loaded (their mixins applied) are checked: nothing is loaded or looked up by reflection here, so this
     * can run on the server thread (at start and every few seconds, until every hook has been seen).
     */
    static void checkHooks() {
        for (Opt o : ALL) {
            Logic.Switch s = switchOf(o.id());
            if (s == null || !s.on) continue;
            for (String[] h : o.hooks()) {
                String key = o.id() + "#" + h[0] + "#" + h[1];
                if (CHECKED.contains(key) || !LogicMixins.transformed(h[0])) continue;
                // "call:" an injection that must be called from the target's own code; otherwise a member it must have
                boolean ok = h[1].startsWith("call:") ? LogicMixins.called(h[0], h[1].substring(5)) : LogicMixins.member(h[0], h[1]);
                CHECKED.add(key);
                if (!ok) Logic.fallback(s, "hook " + h[1] + " did not land in " + h[0], null);
            }
        }
    }

    /** Whether every hook of every optimisation that is still on has been checked. */
    static boolean allChecked() {
        for (Opt o : ALL) {
            Logic.Switch s = switchOf(o.id());
            if (s == null || !s.on) continue;
            for (String[] h : o.hooks()) if (!CHECKED.contains(o.id() + "#" + h[0] + "#" + h[1])) return false;
        }
        return true;
    }

    private static Logic.Switch switchOf(String id) {
        if (id.equals(SectionMasks.ID)) return SectionMasks.SWITCH;
        if (id.equals(EntitySections.ID)) return EntitySections.SWITCH;
        if (id.equals(EntityCollisions.ID)) return EntityCollisions.SWITCH;
        if (id.equals(BrainBehaviours.ID)) return BrainBehaviours.SWITCH;
        if (id.equals(GateBehaviours.ID)) return GateBehaviours.SWITCH;
        if (id.equals(HopperEntities.ID)) return HopperEntities.SWITCH;
        if (id.equals(BlockEntityChecks.ID)) return BlockEntityChecks.SWITCH;
        return null;
    }
}
