package com.meakaandre.quicksilver.compat;

import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.bench.StandDown;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.AlertScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

/**
 * Release prep: with Sodium or Iris installed Quicksilver stands down ({@link StandDown}) and says so once: on the first
 * title screen, as a screen with one button (back to the title screen), or, when the game goes straight into a world
 * (quick play, CI), as one line in the chat. Nothing else of Quicksilver's runs.
 */
public final class StandDownMessage {
    private static boolean shown;

    private StandDownMessage() {
    }

    public static void init() {
        QuicksilverClient.LOG.warn("Quicksilver: turned off: {} installed; none of Quicksilver's modules or mixins are in use. {}",
            String.join(" and ", StandDown.conflicts()), StandDown.message());
        ClientTickEvents.END_CLIENT_TICK.register(StandDownMessage::tick);
        ClientPlayConnectionEvents.JOIN.register((handler, sender, mc) -> mc.execute(StandDownMessage::inChat));
    }

    private static void tick(Minecraft mc) {
        if (shown || !(mc.gui.screen() instanceof TitleScreen title)) return;
        shown = true;
        try {
            mc.gui.setScreen(screen(title));
            QuicksilverClient.LOG.info("Quicksilver: told the player it is turned off (title screen)");
        } catch (Throwable t) {
            shown = false;
            QuicksilverClient.LOG.warn("Quicksilver: could not show its turned-off screen; it says so in the chat instead", t);
        }
    }

    private static void inChat() {
        Minecraft mc = Minecraft.getInstance();
        if (shown || mc.gui == null) return;
        shown = true;
        mc.gui.hud.getChat().addClientSystemMessage(Component.literal("[Quicksilver] " + StandDown.message()));
        QuicksilverClient.LOG.info("Quicksilver: told the player it is turned off (chat)");
    }

    /** The message as a screen with one button back to {@code parent} (the title screen; Mod Menu's list). */
    public static Screen screen(Screen parent) {
        Minecraft mc = Minecraft.getInstance();
        return new AlertScreen(() -> mc.gui.setScreen(parent), Component.literal("Quicksilver is turned off"), Component.literal(StandDown.message()));
    }
}
