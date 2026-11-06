package com.meakaandre.quicksilver.entity;

import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Mixin plugin for package 6's entity mixins (not required, require 0): records whether the submit hook landed; the
 * entity atlas only turns on when it did ({@link EntityAtlas}).
 */
public final class EntityMixins implements IMixinConfigPlugin {
    static final String TARGET = "net.minecraft.client.renderer.SubmitNodeCollection";
    static final String HANDLER = "quicksilver$entityAtlas";
    private static volatile boolean applied;

    static boolean applied() {
        try {
            Class.forName(TARGET, true, EntityMixins.class.getClassLoader());
        } catch (Throwable t) {
            return false;
        }
        return applied;
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        if (!TARGET.equals(targetClassName)) return;
        for (MethodNode m : targetClass.methods) {
            for (AbstractInsnNode insn = m.instructions.getFirst(); insn != null; insn = insn.getNext()) {
                if (insn instanceof MethodInsnNode call && call.owner.equals(targetClass.name) && call.name.endsWith(HANDLER)) applied = true;
            }
        }
    }

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
