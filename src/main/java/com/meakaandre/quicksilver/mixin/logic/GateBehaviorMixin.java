/*
 * Quicksilver: P2-3, logic.gate-behaviours. The idea (a gate behaviour's streams as loops over its shuffled list's
 * entries) is from Lithium (https://github.com/CaffeineMC/lithium, branch develop at 383d299, common/src/main/java/net/
 * caffeinemc/mods/lithium/mixin/ai/task/replace_streams/GateBehaviorMixin.java, RunningPolicyRunOneMixin.java,
 * RunningPolicyTryAllMixin.java), Copyright (C) CaffeineMC and Lithium's contributors, licensed under the GNU Lesser
 * General Public License v3.0 only (LICENSE, COPYING). Changed for Quicksilver: its own switch; the tick keeps vanilla's
 * second walk for "is any member still running" (Lithium folds it into the ticking walk); the run policies are handled in
 * the gate's own start (no mixins on the policies); injections, no overwrites.
 */
package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.GateBehaviours;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.GateBehavior;
import net.minecraft.world.entity.ai.behavior.ShufflingList;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** P2-3, logic.gate-behaviours ({@link GateBehaviours}). */
@Mixin(GateBehavior.class)
public abstract class GateBehaviorMixin<E extends LivingEntity> {
    @Shadow
    @Final
    private ShufflingList<BehaviorControl<? super E>> behaviors;

    @Shadow
    @Final
    private Set<MemoryModuleType<?>> exitErasedMemories;

    @Shadow
    private Behavior.Status status;

    @Shadow
    public abstract void doStop(ServerLevel level, E body, long time);

    @Unique
    @SuppressWarnings({"unchecked", "rawtypes"})
    private List<ShufflingList.WeightedEntry<? extends BehaviorControl<? super E>>> quicksilver$entries() {
        return ((ShufflingListAccessor) (Object) this.behaviors).quicksilver$entries();
    }

    /** Vanilla: tick each running member (in order, each checked as it is reached), then stop if none is running. */
    @Inject(method = "tickOrStop", at = @At("HEAD"), cancellable = true)
    private void quicksilver$tick(ServerLevel level, E body, long time, CallbackInfo ci) {
        if (!GateBehaviours.SWITCH.on) return;
        var entries = this.quicksilver$entries();
        for (int i = 0; i < entries.size(); i++) {
            BehaviorControl<? super E> b = entries.get(i).getData();
            if (b.getStatus() == Behavior.Status.RUNNING) b.tickOrStop(level, body, time);
        }
        boolean anyRunning = false;
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getData().getStatus() == Behavior.Status.RUNNING) {
                anyRunning = true;
                break;
            }
        }
        if (!anyRunning) this.doStop(level, body, time);
        ci.cancel();
    }

    /** Vanilla: stopped; each running member stopped (in order); the gate's exit memories erased. */
    @Inject(method = "doStop", at = @At("HEAD"), cancellable = true)
    private void quicksilver$stop(ServerLevel level, E body, long time, CallbackInfo ci) {
        if (!GateBehaviours.SWITCH.on) return;
        this.status = Behavior.Status.STOPPED;
        var entries = this.quicksilver$entries();
        for (int i = 0; i < entries.size(); i++) {
            BehaviorControl<? super E> b = entries.get(i).getData();
            if (b.getStatus() == Behavior.Status.RUNNING) b.doStop(level, body, time);
        }
        Brain<?> brain = body.getBrain();
        for (MemoryModuleType<?> m : this.exitErasedMemories) brain.eraseMemory(m);
        ci.cancel();
    }

    /**
     * Vanilla's run policies, as loops: run one starts stopped members until one starts; try all starts each. A redirect
     * (the call to the policy in the gate's start), so the hook check sees it land; any other policy is vanilla's.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Redirect(method = "tryStart", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/entity/ai/behavior/GateBehavior$RunningPolicy;apply(Ljava/util/stream/Stream;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;J)V"))
    private void quicksilver$policy(GateBehavior.RunningPolicy policy, Stream stream, ServerLevel level, LivingEntity body, long time) {
        boolean runOne = policy == GateBehavior.RunningPolicy.RUN_ONE;
        if (!GateBehaviours.SWITCH.on || !(runOne || policy == GateBehavior.RunningPolicy.TRY_ALL)) {
            policy.apply(stream, level, body, time);
            return;
        }
        E e = (E) body;
        var entries = this.quicksilver$entries();
        for (int i = 0; i < entries.size(); i++) {
            BehaviorControl<? super E> b = entries.get(i).getData();
            if (b.getStatus() == Behavior.Status.STOPPED && b.tryStart(level, e, time) && runOne) return;
        }
    }
}
