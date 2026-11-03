package com.meakaandre.quicksilver.logic;

/**
 * P2-3, logic.gate-behaviours: a gate behaviour (a group of behaviours run as one: a villager's work, rest, meet and idle
 * packages are built of them) ticks, starts and stops its members through Java streams over its shuffled list. The same
 * walks as plain loops over the list's entries, in the list's order, with every check made at the same point as the
 * stream's: ticking the running members and then, as a second walk, whether none is still running; stopping the
 * running members; starting the stopped members until one starts (run one) or all (try all). The gate's start still
 * makes the one stream vanilla passes to its run policy (it is made before the policy is called), but walks no stream.
 * ({@code mixin/logic/GateBehaviorMixin}.)
 *
 * <p>The idea is Lithium's ({@code ai.task.replace_streams}); Lithium decides whether any member still runs during the
 * ticking walk, which can differ from vanilla's second walk when a member's tick stops another one. Quicksilver keeps
 * vanilla's two walks.
 */
public final class GateBehaviours {
    public static final String ID = "gate-behaviours";
    public static final Logic.Switch SWITCH = new Logic.Switch(ID);

    private GateBehaviours() {
    }
}
