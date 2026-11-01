package com.meakaandre.quicksilver.logic;

/**
 * P2-3, logic.brain-behaviours: every brain tick (villagers, piglins, allays, axolotls and other brain mobs) vanilla walks
 * the brain's behaviours twice through nested maps (priority, then activity, then behaviours), once to start the stopped
 * ones of each active activity and once to list the running ones. Each brain keeps a flat copy of that walk, in the
 * maps' own order, made from the maps the first time it is needed and dropped whenever a behaviour is added or all are
 * removed ({@code mixin/logic/BrainMixin}). Walking the copy visits the same behaviours in the same order, and asks
 * {@code activeActivities.contains(activity)} for each activity at the same moment vanilla does (a behaviour that starts
 * can change the active activities, such as a villager's panic trigger; the next activities see the change, as in
 * vanilla). The running list is built new on every call, as vanilla's is.
 *
 * <p>The idea of a flat, cached walk is Lithium's ({@code ai.task.launch}); Lithium caches the behaviours of the active
 * activities as a list, which keeps using that list when an activity changes during the walk. Quicksilver's walk checks
 * the activities as it goes, so the copy holds every activity.
 *
 * <p>With {@code -Dquicksilver.debug.verifyLogic=true} (CI's server suite) every walk first checks the copy against the
 * maps, entry by entry, and falls back on a difference.
 */
public final class BrainBehaviours {
    public static final String ID = "brain-behaviours";
    public static final Logic.Switch SWITCH = new Logic.Switch(ID);
    public static final boolean VERIFY = Boolean.getBoolean("quicksilver.debug.verifyLogic");

    private BrainBehaviours() {
    }
}
