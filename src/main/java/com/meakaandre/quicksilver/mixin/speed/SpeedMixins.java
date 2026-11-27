package com.meakaandre.quicksilver.mixin.speed;

import com.meakaandre.quicksilver.QuicksilverClient;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.service.MixinService;

/**
 * Package A: the speed module's mixins target game methods no other Quicksilver mixin uses, so before applying each one
 * this checks that the target still has the exact method (and, for particles, fields) it is written against. A mixin
 * whose target doesn't match is skipped with one log line (the option it serves then does nothing, and the bench's
 * {@code hooks} block of the speed results says so) instead of failing to apply.
 */
public final class SpeedMixins implements IMixinConfigPlugin {
    /** mixin simple name -> target class, required "name desc" methods and "name desc" fields. */
    private static final Map<String, String[][]> NEEDS = Map.of(
        "ParticleEngineSpeedMixin", new String[][] {{"net.minecraft.client.particle.ParticleEngine"},
            {"add (Lnet/minecraft/client/particle/Particle;)V"}, {}},
        "ParticleAccessor", new String[][] {{"net.minecraft.client.particle.Particle"}, {}, {"x D", "y D", "z D"}},
        "LightUpdatesProfileMixin", new String[][] {{"net.minecraft.world.level.lighting.LevelLightEngine"}, {"runLightUpdates ()I"}, {}},
        "FogRendererMixin", new String[][] {{"net.minecraft.client.renderer.fog.FogRenderer"},
            {"updateBuffer (Lnet/minecraft/client/renderer/fog/FogData;)V"}, {"fogEnabled Z"}});

    public static final Map<String, String> RESULT = new ConcurrentHashMap<>();

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        // release prep: none of Quicksilver's mixins next to Sodium or Iris (bench/StandDown)
        if (com.meakaandre.quicksilver.bench.StandDown.active()) return false;
        String simple = mixinClassName.substring(mixinClassName.lastIndexOf('.') + 1);
        String[][] need = NEEDS.get(simple);
        if (need == null) return true;
        try {
            ClassNode node = MixinService.getService().getBytecodeProvider().getClassNode(need[0][0].replace('.', '/'));
            for (String m : need[1]) {
                String[] nd = m.split(" ");
                boolean found = false;
                for (MethodNode mn : node.methods) if (mn.name.equals(nd[0]) && mn.desc.equals(nd[1])) found = true;
                if (!found) return skip(simple, "no method " + m + " in " + need[0][0]);
            }
            for (String f : need[2]) {
                String[] nd = f.split(" ");
                boolean found = false;
                for (FieldNode fn : node.fields) if (fn.name.equals(nd[0]) && fn.desc.equals(nd[1])) found = true;
                if (!found) return skip(simple, "no field " + f + " in " + need[0][0]);
            }
        } catch (Throwable t) {
            return skip(simple, "could not read " + need[0][0] + ": " + t);
        }
        RESULT.put(simple, "applied");
        return true;
    }

    private static boolean skip(String mixin, String why) {
        RESULT.put(mixin, "skipped: " + why);
        QuicksilverClient.LOG.warn("Quicksilver speed: mixin {} not applied ({}); what it serves does nothing", mixin, why);
        return false;
    }

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
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

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
