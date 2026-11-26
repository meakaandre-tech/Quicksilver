package com.meakaandre.quicksilver.look;

import java.util.LinkedHashSet;
import java.util.Set;
import net.minecraft.world.level.material.MapColor;

/**
 * Package 11: the natural palette, made from vanilla's own colours: the map colours (one per kind of block: grass,
 * plants, water, stone, wood, sand, snow, the sixteen dyes, ...), each in the four shades vanilla's maps draw it in
 * (the map's own multipliers 180, 220, 255 and 135 of 255). So grass stays green, water blue, sand yellow: about 240 map
 * colours; with vanilla's default biome colours (grass, foliage, water, fog) and its sky colours (each also darker, for dusk
 * and night) 469. Nearest by the "redmean" colour distance (a cheap perceptual weighting of RGB).
 */
final class Palette {
    private Palette() {
    }

    /** The map shades' multipliers (out of 255), as vanilla's map colours use them. */
    static final int[] SHADES = {180, 220, 255, 135};

    /**
     * Vanilla's default biome colours (its data's values): grass and foliage of the common biomes (plains, forest, birch,
     * dark forest, jungle, swamp, savanna, badlands, taiga, snowy), water and water fog, the default fog and the nether's
     * fogs. Each in the four map shades, like the map colours.
     */
    static final int[] BIOME = {0x91BD59, 0x77AB2F, 0x79C05A, 0x59AE30, 0x88BB67, 0x6BA941, 0x507A32, 0x59C93C, 0x30BB0B, 0x6A7039,
        0xBFB755, 0xAEA42A, 0x90814D, 0x9E814D, 0x86B783, 0x68A464, 0x80B497, 0x60A17B, 0x619961, 0x80A755, 0x3F76E4, 0x050533,
        0xC0D8FF, 0x330808, 0x1B4745, 0x330303, 0x3B0B0B};

    /** The palette as 0xRRGGBB, without repeats. */
    static int[] natural() {
        Set<Integer> out = new LinkedHashSet<>();
        for (int c : BIOME) {
            int r = (c >> 16) & 255, g = (c >> 8) & 255, b = c & 255;
            for (int s : SHADES) out.add((r * s / 255) << 16 | (g * s / 255) << 8 | (b * s / 255));
        }
        // the overworld's sky colours (vanilla's sky colour of a biome: hue 0.622 - 0.05 t, saturation 0.5 + 0.1 t, value 1,
        // with t its temperature / 3 within -1..1), and each darker as the sky is at dusk and night
        for (int i = -10; i <= 10; i++) {
            float t = i / 10f;
            int c = net.minecraft.util.Mth.hsvToRgb(0.62222224f - t * 0.05f, 0.5f + t * 0.1f, 1.0f) & 0xFFFFFF;
            int r = (c >> 16) & 255, g = (c >> 8) & 255, b = c & 255;
            for (int v : new int[] {255, 216, 176, 136, 96, 56}) out.add((r * v / 255) << 16 | (g * v / 255) << 8 | (b * v / 255));
        }
        for (int id = 1; id < 64; id++) {
            MapColor m;
            try {
                m = MapColor.byId(id);
            } catch (RuntimeException e) {
                continue;
            }
            if (m == null || m == MapColor.NONE || m.col == 0) continue;
            int r = (m.col >> 16) & 255, g = (m.col >> 8) & 255, b = m.col & 255;
            for (int s : SHADES) out.add((r * s / 255) << 16 | (g * s / 255) << 8 | (b * s / 255));
        }
        int[] a = new int[out.size()];
        int i = 0;
        for (int c : out) a[i++] = c;
        return a;
    }

    /** The palette colour nearest to (r, g, b), 0-255 each. */
    static int nearest(int[] palette, int r, int g, int b) {
        long best = Long.MAX_VALUE;
        int pick = 0;
        for (int c : palette) {
            int pr = (c >> 16) & 255, pg = (c >> 8) & 255, pb = c & 255;
            int rm = (r + pr) / 2, dr = r - pr, dg = g - pg, db = b - pb;
            long d = (long) (512 + rm) * dr * dr + 1024L * dg * dg + (long) (767 - rm) * db * db;
            if (d < best) {
                best = d;
                pick = c;
            }
        }
        return pick;
    }
}
