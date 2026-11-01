/*
 * Quicksilver: P2-3, logic.brain-behaviours. The idea (a flat copy of the brain's behaviour maps, dropped when behaviours
 * are added or removed, and the hooks where that happens) is from Lithium (https://github.com/CaffeineMC/lithium, branch
 * develop at 383d299, common/src/main/java/net/caffeinemc/mods/lithium/mixin/ai/task/launch/BrainMixin.java), Copyright
 * (C) CaffeineMC and Lithium's contributors, licensed under the GNU Lesser General Public License v3.0 only (LICENSE,
 * COPYING). Changed for Quicksilver: its own switch, fallback and CI check; the copy holds every activity and each one's
 * activity is checked as vanilla checks it, during the walk (Lithium copies only the active activities' behaviours); the
 * running list is built new on every call, as vanilla's (Lithium keeps a live masked list); injections, no overwrites.
 */
package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.BrainBehaviours;
import com.meakaandre.quicksilver.logic.Logic;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.schedule.Activity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * P2-3, logic.brain-behaviours ({@link BrainBehaviours}): vanilla's two walks over the behaviour maps, over a flat copy
 * of them in the same order.
 */
@Mixin(Brain.class)
public abstract class BrainMixin<E extends LivingEntity> {
    @Shadow
    @Final
    private Map<Integer, Map<Activity, Set<BehaviorControl<? super E>>>> availableBehaviorsByPriority;

    @Shadow
    @Final
    private Set<Activity> activeActivities;

    /** The copy: for each (priority, activity) entry in the maps' order, its activity and its behaviours. */
    @Unique
    private Activity[] quicksilver$activities;

    @Unique
    private BehaviorControl<?>[][] quicksilver$behaviours;

    @Unique
    private void quicksilver$build() {
        List<Activity> acts = new ArrayList<>();
        List<BehaviorControl<?>[]> bs = new ArrayList<>();
        for (Map<Activity, Set<BehaviorControl<? super E>>> byActivity : this.availableBehaviorsByPriority.values()) {
            for (Map.Entry<Activity, Set<BehaviorControl<? super E>>> e : byActivity.entrySet()) {
                acts.add(e.getKey());
                bs.add(e.getValue().toArray(new BehaviorControl<?>[0]));
            }
        }
        this.quicksilver$activities = acts.toArray(new Activity[0]);
        this.quicksilver$behaviours = bs.toArray(new BehaviorControl<?>[0][]);
    }

    /** CI's check: the copy against the maps, entry by entry. */
    @Unique
    private boolean quicksilver$matches() {
        int i = 0;
        Activity[] acts = this.quicksilver$activities;
        BehaviorControl<?>[][] bs = this.quicksilver$behaviours;
        for (Map<Activity, Set<BehaviorControl<? super E>>> byActivity : this.availableBehaviorsByPriority.values()) {
            for (Map.Entry<Activity, Set<BehaviorControl<? super E>>> e : byActivity.entrySet()) {
                if (i >= acts.length || acts[i] != e.getKey() || bs[i].length != e.getValue().size()) return false;
                int j = 0;
                for (BehaviorControl<? super E> b : e.getValue()) {
                    if (bs[i][j++] != b) return false;
                }
                i++;
            }
        }
        return i == acts.length;
    }

    /** The copy, built when missing; null when the optimisation is off or has just fallen back (vanilla's code runs). */
    @Unique
    private BehaviorControl<?>[][] quicksilver$copy() {
        if (!BrainBehaviours.SWITCH.on) return null;
        try {
            if (this.quicksilver$behaviours == null) this.quicksilver$build();
            if (BrainBehaviours.VERIFY && !this.quicksilver$matches()) {
                Logic.fallback(BrainBehaviours.SWITCH, "verify: a brain's copy differs from its behaviour maps", null);
                return null;
            }
            return this.quicksilver$behaviours;
        } catch (Throwable t) {
            BrainBehaviours.SWITCH.fail(t);
            return null;
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Inject(method = "startEachNonRunningBehavior", at = @At("HEAD"), cancellable = true)
    private void quicksilver$startEach(ServerLevel level, E body, CallbackInfo ci) {
        BehaviorControl<?>[][] bs = this.quicksilver$copy();
        if (bs == null) return;
        Activity[] acts = this.quicksilver$activities;
        long time = level.getGameTime();
        // vanilla's walk: each (priority, activity) entry in order, its activity checked now, then each stopped behaviour
        // of it started (outside any try: an exception from a behaviour is the game's, as in vanilla)
        for (int i = 0; i < bs.length; i++) {
            if (!this.activeActivities.contains(acts[i])) continue;
            for (BehaviorControl b : bs[i]) {
                if (b.getStatus() == Behavior.Status.STOPPED) b.tryStart(level, body, time);
            }
        }
        ci.cancel();
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Inject(method = "getRunningBehaviors", at = @At("HEAD"), cancellable = true)
    private void quicksilver$running(CallbackInfoReturnable<List<BehaviorControl<? super E>>> cir) {
        BehaviorControl<?>[][] bs = this.quicksilver$copy();
        if (bs == null) return;
        List list = new ObjectArrayList<>();
        for (BehaviorControl<?>[] group : bs) {
            for (BehaviorControl<?> b : group) {
                if (b.getStatus() == Behavior.Status.RUNNING) list.add(b);
            }
        }
        cir.setReturnValue(list);
    }

    @Inject(method = "addActivity(Lnet/minecraft/world/entity/schedule/Activity;Lcom/google/common/collect/ImmutableList;Ljava/util/Set;Ljava/util/Set;)V", at = @At("RETURN"))
    private void quicksilver$changed(CallbackInfo ci) {
        this.quicksilver$behaviours = null;
        this.quicksilver$activities = null;
    }

    @Inject(method = "removeAllBehaviors", at = @At("RETURN"))
    private void quicksilver$cleared(CallbackInfo ci) {
        this.quicksilver$behaviours = null;
        this.quicksilver$activities = null;
    }
}
