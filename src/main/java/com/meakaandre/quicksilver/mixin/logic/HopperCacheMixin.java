package com.meakaandre.quicksilver.mixin.logic;

import com.llamalad7.mixinextras.sugar.Local;
import com.meakaandre.quicksilver.logic.HopperCache;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * P2-3b, logic.hopper-cache ({@link HopperCache}): a hopper's two block lookups (the block above it, the block it faces)
 * answered from what the hopper remembers while the block's section and block entity stay as they were, else vanilla's.
 *
 * <p>Each lookup is marked as the hopper's around vanilla's own call ({@code getSourceContainer} in suckInItems, whose
 * block read just before it starts the lookup; {@code getAttachedContainer} in ejectItems); inside, vanilla's block read
 * and block container lookup at that position are the two points that answer from the entry or remember vanilla's
 * answer. Everything else in vanilla's code (the entity container lookup, other mods' hooks there, the Fabric transfer
 * API's lookup after a "none") runs as before. A hopper minecart's lookups are left alone. Redirects, so a lookup
 * allocates no callback object.
 */
@Mixin(HopperBlockEntity.class)
public abstract class HopperCacheMixin implements HopperCache.Holder {
    @Shadow
    private Direction facing;

    @Unique
    private HopperCache.Entry quicksilver$extractEntry;

    @Unique
    private HopperCache.Entry quicksilver$insertEntry;

    @Override
    public HopperCache.Entry quicksilver$extract() {
        HopperCache.Entry e = quicksilver$extractEntry;
        if (e == null) quicksilver$extractEntry = e = new HopperCache.Entry();
        return e;
    }

    @Override
    public HopperCache.Entry quicksilver$insert() {
        HopperCache.Entry e = quicksilver$insertEntry;
        if (e == null) quicksilver$insertEntry = e = new HopperCache.Entry();
        return e;
    }

    @Override
    public void quicksilver$forget() {
        quicksilver$extractEntry = null;
        quicksilver$insertEntry = null;
    }

    /** The hopper's state changed (its facing, its enabled flag): both entries forgotten. */
    @Inject(method = "setBlockState(Lnet/minecraft/world/level/block/state/BlockState;)V", at = @At("HEAD"))
    private void quicksilver$stateChanged(BlockState state, CallbackInfo ci) {
        quicksilver$forget();
    }

    // ---- taking from the block above (suckInItems: its block read starts the lookup, getSourceContainer ends it)

    @Redirect(method = "suckInItems(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/entity/Hopper;)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;",
            ordinal = 0))
    private static BlockState quicksilver$sourceState(Level level, BlockPos pos, @Local(argsOnly = true) Hopper hopper) {
        if (!HopperCache.SWITCH.on || !(hopper instanceof HopperCache.Holder h)) {
            HopperCache.end();
            return level.getBlockState(pos);
        }
        try {
            HopperCache.begin(level, h.quicksilver$extract(), pos);
            return quicksilver$read(level, pos);
        } catch (Throwable t) {
            HopperCache.SWITCH.fail(t);
            HopperCache.end();
            return level.getBlockState(pos);
        }
    }

    @Redirect(method = "suckInItems(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/entity/Hopper;)Z",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/HopperBlockEntity;getSourceContainer(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/entity/Hopper;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/Container;"))
    private static Container quicksilver$source(Level level, Hopper hopper, BlockPos pos, BlockState state) {
        try {
            return HopperCacheInvoker.quicksilver$vanillaSource(level, hopper, pos, state);
        } finally {
            HopperCache.end();
        }
    }

    // ---- giving to the block it faces (ejectItems: getAttachedContainer is the lookup)

    @Redirect(method = "ejectItems", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/block/entity/HopperBlockEntity;getAttachedContainer(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/HopperBlockEntity;)Lnet/minecraft/world/Container;"))
    private static Container quicksilver$attached(Level level, BlockPos pos, HopperBlockEntity hopper) {
        if (HopperCache.SWITCH.on) {
            try {
                HopperCacheMixin self = (HopperCacheMixin) (Object) hopper;
                HopperCache.begin(level, self.quicksilver$insert(), pos.relative(self.facing));
            } catch (Throwable t) {
                HopperCache.SWITCH.fail(t);
                HopperCache.end();
            }
        } else {
            HopperCache.end();
        }
        try {
            return HopperCacheInvoker.quicksilver$vanillaAttached(level, pos, hopper);
        } finally {
            HopperCache.end();
        }
    }

    /** The block read in getContainerAt(level, pos), vanilla's lookup for the block a hopper faces. */
    @Redirect(method = "getContainerAt(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/Container;",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;"))
    private static BlockState quicksilver$targetState(Level level, BlockPos pos) {
        try {
            return quicksilver$read(level, pos);
        } catch (Throwable t) {
            HopperCache.SWITCH.fail(t);
            HopperCache.end();
            return level.getBlockState(pos);
        }
    }

    // ---- inside vanilla's lookup: the block container at the lookup's position

    @Redirect(method = "getContainerAt(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;DDD)Lnet/minecraft/world/Container;",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/HopperBlockEntity;getBlockContainer(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/world/Container;"))
    private static Container quicksilver$blockContainer(Level level, BlockPos pos, BlockState state) {
        boolean answers;
        try {
            answers = HopperCache.answersContainer(pos, state);
        } catch (Throwable t) {
            HopperCache.SWITCH.fail(t);
            HopperCache.end();
            answers = false;
        }
        if (answers) {
            Container c = HopperCache.answerContainer();
            if (HopperCache.VERIFY) {
                long[] before = HopperCache.before(level);
                HopperCache.check(level, pos, before, c, HopperCacheInvoker.quicksilver$vanillaBlockContainer(level, pos, state), "container");
            }
            return c;
        }
        Container c = HopperCacheInvoker.quicksilver$vanillaBlockContainer(level, pos, state);
        HopperCache.found(level, pos, state, c);
        return c;
    }

    /** A block read at the current lookup's position: the remembered state, or vanilla's read (kept to be remembered). */
    @Unique
    private static BlockState quicksilver$read(Level level, BlockPos pos) {
        if (HopperCache.answersState(pos)) {
            BlockState s = HopperCache.answerState();
            if (HopperCache.VERIFY) {
                long[] before = HopperCache.before(level);
                HopperCache.check(level, pos, before, s, level.getBlockState(pos), "state");
            }
            return s;
        }
        BlockState s = level.getBlockState(pos);
        HopperCache.read(pos, s);
        return s;
    }
}
