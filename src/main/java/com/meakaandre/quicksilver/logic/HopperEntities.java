package com.meakaandre.quicksilver.logic;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.AbortableIterationConsumer;
import net.minecraft.util.Continuation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.entity.EntitySection;
import net.minecraft.world.phys.AABB;

/**
 * P2-3, logic.hopper-entities: a hopper that isn't cooling down looks for item entities above it, and for a container
 * entity (a chest or hopper minecart, a chest boat) at the block it takes from and the block it gives to, with an entity
 * lookup each time, every tick it has nothing else to do. Each entity section counts the item entities and the
 * container entities it holds ({@code mixin/logic/EntitySectionHopperMixin}); when every section vanilla's lookup would
 * visit (the same walk, over the box vanilla's lookup is given) counts none, vanilla's lookup finds nothing, and an
 * empty list (vanilla's answer) is returned without walking the entities ({@code mixin/logic/HopperBlockEntityMixin}).
 * An empty answer draws no random number in vanilla either (a container entity is picked at random only from a list
 * that isn't empty). Only for a server level without ender dragon parts. The item lookup's one side effect that can
 * matter is kept: vanilla's lookup asks each visited section for its item entity list by class, which gives the class
 * object its hash code the first time ever; a skipped lookup asks for that hash code too ({@link #none}).
 *
 * <p>The idea (knowing from the sections that no entity is there) is Lithium's hopper entity trackers; the counts and
 * the code are Quicksilver's own, the same way as {@link EntityCollisions}.
 *
 * <p>With {@code -Dquicksilver.debug.verifyLogic=true} (CI's heap runs) every skipped lookup is run anyway and must be
 * empty, or the optimisation falls back.
 */
public final class HopperEntities {
    public static final String ID = "hopper-entities";
    public static final Logic.Switch SWITCH = new Logic.Switch(ID);
    public static final boolean VERIFY = Logic.VERIFY;

    /** Each entity section's counts (mixin). */
    public interface SectionCounts {
        int quicksilver$items();

        int quicksilver$containers();
    }

    private HopperEntities() {
    }

    /** Kinds an entity counts as: item entity, container entity. Fixed for a class. */
    public static boolean isItem(Object o) {
        return o instanceof ItemEntity;
    }

    public static boolean isContainer(Object o) {
        return o instanceof Entity && o instanceof Container;
    }

    /** Whether vanilla's lookup of item entities (containers when {@code items} is false) in {@code box} would find none. */
    public static boolean none(Level level, AABB box, boolean items) {
        if (!(level instanceof ServerLevel server)) return false;
        if (!server.dragonParts().isEmpty()) return false;
        Any any = new Any(items);
        ((EntityCollisions.ManagerSections) ((EntityCollisions.LevelEntities) server).quicksilver$entityManager())
            .quicksilver$sectionStorage().forEachAccessibleNonEmptySection(box, any);
        if (!any.found && items && any.visited) {
            // vanilla's lookup asks each section it visits for its list of item entities, keyed by the class: the first
            // time that ever happens the class object gets its hash code, and every hash code the server thread hands out
            // after that depends on when. Ask for it here too, at the same point (later calls cost nothing and change
            // nothing; the per-section lists vanilla's lookup would also make are never read in an order that matters)
            ITEM_CLASS.hashCode();
        }
        return !any.found;
    }

    /** CI's check: a lookup the counts skipped found something after all. */
    public static void verify(java.util.List<?> vanilla, String what) {
        if (!vanilla.isEmpty()) {
            Logic.fallback(SWITCH, "verify: the counts said no " + what + " but vanilla's lookup found " + vanilla.size(), null);
        }
    }

    private static final Class<?> ITEM_CLASS = ItemEntity.class;

    private static final class Any implements AbortableIterationConsumer<EntitySection<Entity>> {
        final boolean items;
        boolean found;
        boolean visited;

        Any(boolean items) {
            this.items = items;
        }

        @Override
        public Continuation accept(EntitySection<Entity> section) {
            visited = true;
            SectionCounts c = (SectionCounts) section;
            if ((items ? c.quicksilver$items() : c.quicksilver$containers()) > 0) {
                found = true;
                return Continuation.ABORT;
            }
            return Continuation.CONTINUE;
        }
    }

    /**
     * Called from the hopper mixin: true when vanilla's lookup may be skipped (its answer would be empty). On any
     * exception the optimisation falls back and the lookup runs.
     */
    public static boolean skip(Level level, AABB box, boolean itemsKind) {
        if (!SWITCH.on) return false;
        try {
            return none(level, box, itemsKind);
        } catch (Throwable t) {
            SWITCH.fail(t);
            return false;
        }
    }
}
