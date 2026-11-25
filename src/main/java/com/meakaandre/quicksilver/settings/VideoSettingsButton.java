package com.meakaandre.quicksilver.settings;

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.VideoSettingsScreen;
import net.minecraft.network.chat.Component;

/**
 * Package 9: a "Quicksilver..." button at the end of Video Settings' list, opening {@link SettingsScreen}. Added with
 * Fabric API's screen event (no mixin); the list field is made accessible by the class tweaker.
 */
public final class VideoSettingsButton {
    private VideoSettingsButton() {
    }

    /** The last button added, and the screen it is on (the CI test presses it). */
    static volatile Button last;
    static volatile Screen lastScreen;

    public static void register() {
        ScreenEvents.AFTER_INIT.register((client, screen, w, h) -> {
            if (!(screen instanceof VideoSettingsScreen video)) return;
            Button b = Button.builder(Component.literal("Quicksilver..."), btn -> open(video))
                .tooltip(Tooltip.create(Component.literal("Quicksilver's options: presets, speed options and modules.")))
                .width(310)
                .build();
            video.list.addBig(b);
            last = b;
            lastScreen = video;
        });
    }

    /** What the button does: Quicksilver's screen, going back to {@code parent} when it closes. */
    static void open(Screen parent) {
        Minecraft.getInstance().gui.setScreen(new SettingsScreen(parent));
    }

    /** {@code /qs settings}: opened on the next client tick (the chat screen closes after the command runs). */
    public static volatile boolean openNextTick;

    public static void tick(Minecraft mc) {
        if (!openNextTick) return;
        openNextTick = false;
        mc.gui.setScreen(new SettingsScreen(mc.gui.screen()));
    }
}
