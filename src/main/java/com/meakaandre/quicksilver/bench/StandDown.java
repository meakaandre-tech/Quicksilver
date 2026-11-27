package com.meakaandre.quicksilver.bench;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Release prep: Quicksilver does Sodium's job (and is the Fabric Renderer API's renderer itself), so it can't run next
 * to Sodium, or next to Iris, which needs Sodium. With either installed, Quicksilver stands down instead of crashing: none
 * of its mixins apply (every mixin config's plugin asks {@link #active}), its entrypoints register nothing, it doesn't
 * register its renderer (Sodium's draws), and the player gets one clear message (the title screen, or the chat when the
 * game goes straight into a world: {@code compat/StandDownMessage}). The game then runs with Sodium (and Iris) as if
 * Quicksilver weren't there.
 *
 * <p>In the bench package so the bench-only jar has it too; there Quicksilver itself isn't loaded (the bench jar runs
 * next to Sodium on purpose), so it never stands down. Read at mixin-config time: the loader knows every mod by then.
 */
public final class StandDown implements IMixinConfigPlugin {
    private static volatile List<String> found;

    /** The installed mods Quicksilver can't run with, by name (empty: none). Any thread. */
    public static List<String> conflicts() {
        List<String> f = found;
        if (f != null) return f;
        List<String> out = new ArrayList<>();
        try {
            FabricLoader l = FabricLoader.getInstance();
            if (l.isModLoaded("quicksilver")) {
                if (l.isModLoaded("sodium")) out.add("Sodium");
                if (l.isModLoaded("iris")) out.add("Iris");
            }
        } catch (Throwable t) {
            // the loader always answers; nothing found if it doesn't
        }
        found = List.copyOf(out);
        return found;
    }

    /** Whether Quicksilver stands down for this game (Sodium or Iris is installed). */
    public static boolean active() {
        return !conflicts().isEmpty();
    }

    /** The one message: which mods, what happens, what to do. */
    public static String message() {
        List<String> c = conflicts();
        String which = String.join(" and ", c);
        boolean several = c.size() > 1;
        return "Quicksilver is turned off: " + which + (several ? " are" : " is") + " installed. Quicksilver does Sodium's job, so it can't run with"
            + " Sodium or with Iris shader packs; the game runs as if Quicksilver weren't there. Remove " + which + " to use Quicksilver, or remove"
            + " Quicksilver to keep " + (several ? "them" : "it") + ".";
    }

    // ---- as a mixin config plugin: for Quicksilver's configs that have no plugin of their own

    @Override
    public void onLoad(String mixinPackage) {
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return !active();
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
