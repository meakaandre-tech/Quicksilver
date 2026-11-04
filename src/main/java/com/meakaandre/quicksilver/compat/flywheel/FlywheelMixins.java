package com.meakaandre.quicksilver.compat.flywheel;

import com.google.gson.JsonObject;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Mixin plugin for {@code quicksilver.flywheel.mixins.json} (package 5): its mixins target Create Fly's own classes by
 * name ({@code @Pseudo}), so they load only when Create Fly is installed and its Flywheel classes are there. Without
 * Create Fly nothing in this package is applied and Quicksilver runs exactly as before.
 */
public final class FlywheelMixins implements IMixinConfigPlugin {
    private static volatile Boolean present;

    /** Create Fly installed, with the Flywheel it bundles. */
    static boolean present() {
        Boolean p = present;
        if (p == null) {
            boolean mod = FabricLoader.getInstance().isModLoaded("create");
            boolean classes = mod && FlywheelMixins.class.getClassLoader().getResource(
                FlywheelCompat.FLW.replace('.', '/') + "/impl/BackendManagerImpl.class") != null;
            present = p = mod && classes;
        }
        return p;
    }

    /**
     * Flywheel's hooks on vanilla's classes, found by their handler names in the loaded classes (Mixin keeps the
     * handler's name as a suffix): the block-entity step, the light update and the draw before the terrain. CI requires
     * all three wherever Create Fly is installed.
     */
    static JsonObject hookReport() {
        JsonObject o = new JsonObject();
        o.addProperty("blockEntityStep", has("net.minecraft.client.renderer.chunk.SectionCompiler", "flywheel$tryAddBlockEntity"));
        o.addProperty("lightUpdate", has("net.minecraft.client.multiplayer.ClientChunkCache", "flywheel$onLightUpdate"));
        o.addProperty("beforeSolid", has("net.minecraft.client.renderer.LevelRenderer", "flywheel$beforeSolid"));
        return o;
    }

    private static boolean has(String cls, String handler) {
        try {
            for (Method m : Class.forName(cls, false, FlywheelMixins.class.getClassLoader()).getDeclaredMethods()) {
                if (m.getName().endsWith(handler)) return true;
            }
        } catch (Throwable ignored) {
            // not loaded: no hook
        }
        return false;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return present();
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
