package com.meakaandre.quicksilver.phase2;

import java.lang.management.ManagementFactory;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.gui.screens.TitleScreen;

/**
 * Phase 2 (P2-0), measurement only: the client's start-up time, from the JVM's start to the first title screen, and
 * to the first world joined (a launch straight into a world, as CI's, never shows the title screen).
 */
public final class ClientTimes implements ClientModInitializer {
    private static long firstOtherScreenMs;

    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, w, h) -> {
            if (ServerNumbers.clientStartupMs != 0) return;
            long ms = System.currentTimeMillis() - ManagementFactory.getRuntimeMXBean().getStartTime();
            if (screen instanceof TitleScreen) {
                ServerNumbers.clientStartupMs = ms;
                if (firstOtherScreenMs > 0) ServerNumbers.clientStartupScreenMs = ms - firstOtherScreenMs;
                NetworkBytes.LOG.info("Quicksilver: client start-up to the title screen {} ms{}", ms, firstOtherScreenMs > 0
                    ? " (" + ServerNumbers.clientStartupScreenMs + " ms of it after " + ServerNumbers.clientStartupScreen + " was shown first)" : "");
            } else if (firstOtherScreenMs == 0) {
                // package B: a screen before the title screen (the first-run welcome / accessibility screen waits for a
                // click), so the start-up time includes however long it stayed up
                firstOtherScreenMs = ms;
                ServerNumbers.clientStartupScreen = screen.getClass().getSimpleName();
            }
        });
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            if (ServerNumbers.clientFirstJoinMs == 0) {
                ServerNumbers.clientFirstJoinMs = System.currentTimeMillis() - ManagementFactory.getRuntimeMXBean().getStartTime();
            }
        });
    }
}
