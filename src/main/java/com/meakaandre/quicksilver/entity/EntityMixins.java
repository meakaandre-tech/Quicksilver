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
 * Mixin plugin for package 6's entity mixins (not required, require 0): records which hooks landed. The entity atlas
 * only turns on when the submit hook did ({@link EntityAtlas}); far entity LOD only when all three of its hooks did.
 */
public final class EntityMixins implements IMixinConfigPlugin {
    static final String TARGET = "net.minecraft.client.renderer.SubmitNodeCollection";
    static final String HANDLER = "quicksilver$entityAtlas";
    private static volatile boolean applied;

    /** Far entity LOD's hooks: target class, handlers (every one must apply: an end without its begin would thin later cubes). */
    static final java.util.Map<String, java.util.List<String>> LOD = java.util.Map.of(
        "net.minecraft.client.renderer.entity.EntityRenderer", java.util.List.of("quicksilver$lodExtracted"),
        "net.minecraft.client.renderer.feature.ModelFeatureRenderer", java.util.List.of("quicksilver$lodBegin", "quicksilver$lodEnd"),
        "net.minecraft.client.model.geom.ModelPart$Cube", java.util.List.of("quicksilver$lodCube"));
    private static final Set<String> LOD_APPLIED = java.util.concurrent.ConcurrentHashMap.newKeySet();

    static boolean lodApplied() {
        for (String t : LOD.keySet()) {
            try {
                Class.forName(t, true, EntityMixins.class.getClassLoader());
            } catch (Throwable e) {
                return false;
            }
        }
        for (var e : LOD.entrySet()) {
            for (String h : e.getValue()) if (!LOD_APPLIED.contains(e.getKey() + "#" + h)) return false;
        }
        return true;
    }

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
        java.util.List<String> handlers = TARGET.equals(targetClassName) ? java.util.List.of(HANDLER) : LOD.get(targetClassName);
        if (handlers == null) return;
        for (MethodNode m : targetClass.methods) {
            for (AbstractInsnNode insn = m.instructions.getFirst(); insn != null; insn = insn.getNext()) {
                if (!(insn instanceof MethodInsnNode call) || !call.owner.equals(targetClass.name)) continue;
                for (String handler : handlers) {
                    if (!call.name.endsWith(handler)) continue;
                    if (TARGET.equals(targetClassName)) applied = true;
                    else LOD_APPLIED.add(targetClassName + "#" + handler);
                }
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
