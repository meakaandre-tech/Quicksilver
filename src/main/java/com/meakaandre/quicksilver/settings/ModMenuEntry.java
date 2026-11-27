package com.meakaandre.quicksilver.settings;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

/**
 * Package 9: Mod Menu's "Configure" button for Quicksilver opens {@link SettingsScreen}. Loaded only by Mod Menu (its
 * "modmenu" entrypoint), so without Mod Menu this class is never touched; Mod Menu is a compile-only dependency, not bundled.
 */
public final class ModMenuEntry implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        // release prep: next to Sodium or Iris, the button shows why Quicksilver is off
        if (com.meakaandre.quicksilver.bench.StandDown.active()) return com.meakaandre.quicksilver.compat.StandDownMessage::screen;
        return SettingsScreen::new;
    }
}
