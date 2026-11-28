# Quicksilver

An all-in-one optimisation mod for Minecraft 26.3 on Fabric. Drop it into an instance and the game runs faster.
Quicksilver replaces Minecraft's renderer and adds speed options, presets, dynamic lights, a pixel art look, far
terrain, and server and memory optimisations. It is built to run well on old integrated graphics (it is tuned on a
school laptop with Intel UHD graphics) as well as on new machines.

- **Minecraft:** 26.3 · **Loader:** Fabric 0.19.5 or newer · **Needs:** Fabric API · **Java:** 25
- **Side:** client and server, both optional (each side works without the other)
- **Licence:** LGPL-3.0-only

## Features

- **Renderer.** Terrain is meshed on worker threads into a compact 16-byte vertex format and kept in a few large GPU
  buffers, then drawn with few draw calls. Faces that point away from the camera are skipped. Uploads are spread over
  frames to keep frame times smoother while flying into new terrain. Terrain hidden behind other terrain is left out
  (occlusion culling). Translucent blocks (water, glass) are sorted as in vanilla (one shortcut, fewer glass draws, may group them by region; it
  can be switched off). Quicksilver implements the Fabric
  Renderer API itself, so modded and connected-texture models draw as they do with Indigo. Mobs share a texture atlas,
  so a crowd of mobs takes a few draw calls instead of hundreds. Works on OpenGL and Vulkan.
- **Speed options.** Shortcuts you can't see, on by default: terrain hidden in fog is left out, and glass is drawn in
  fewer calls. Visible speed options are off until you choose them (or pick Low-end): opaque leaves, simple water, a far-detail distance,
  and entity, block entity and particle distances and particle density.
- **Presets.** Low-end, Balanced (the default) and Quality set every speed option at once. Any change of your own shows
  as Custom.
- **Dynamic lights** (off by default). Held and dropped torches, lanterns, glowstone and lava buckets, burning and
  glowing mobs, and lit projectiles light up the world around them as they move. Fast lights the nearest 8, on terrain;
  Fancy lights the nearest 32, also on mobs and block entities. Light levels come from data files
  (`assets/<namespace>/quicksilver/dynamic_lights/*.json`), so a mod or resource pack can add its own items.
- **Pixel art look** (off by default). The world is drawn as chunky pixel art in vanilla's own colours, with dithered
  shading and dark outlines on block edges. The HUD and menus stay sharp. Pixel size, dithering and outlines are
  options.
- **Far terrain** (off by default; Quality turns it on at 128 chunks). Shows simple terrain out to 32, 64, 96, 128, 192
  or 256 chunks (192 and 256 are for strong GPUs) without loading those chunks. It is worked out from the world's own
  generator on one background thread, so world-gen mods and datapacks such as Terralith show up correctly: hills,
  biomes, ground blocks, water in its biome's colour, snow and ice where the game would put them, trees shaped by kind
  and the outlines of villages, mansions and ocean monuments. Chunks you have loaded replace the estimate. It is kept on
  disk per world (at most 256 MB each), so a second visit shows it at once. In single player it uses the world's seed. On
  a server the seed comes only from a Quicksilver server whose owner turns sharing on (see "Server owners" below); on
  any other server far terrain shows the land you have seen there, which Quicksilver remembers on your computer (nothing
  is sent). Underground (no sky light) it isn't drawn.
- **Server and memory modules.** Lithium-style shortcuts for entity lookups, mob AI and block entity ticking; faster
  chunk saving; smaller block-state tables (FerriteCore's idea). Each one checks at start-up that its hooks
  are in place and otherwise leaves that job to vanilla. They work in single player and on a dedicated server.
- **Bench.** `/quicksilver bench` (or `/qs bench`) measures frame rate, frame times, draw calls and memory, and writes the
  results to `latest.log` and `<game dir>/quicksilver/bench/`.

## The settings screen

Open it from **Options → Video Settings → Quicksilver...**, from Mod Menu's Configure button, or with `/qs settings`.
It has the preset at the top, then:

- **Look:** Normal or Pixel art, with pixel size, dithering and outlines.
- **Far terrain:** off, 32, 64, 96, 128, 192 or 256 chunks; Far cache and Seen chunks (both on).
- **Lighting:** dynamic lights (Off, Fast, Fancy).
- **Speed options (change the look):** opaque leaves, simple water, far detail, entity, block entity and particle
  distances, particle density.
- **Shortcuts you can't see:** fog culling and fewer glass draws.
- **Modules (need a restart):** block renderer, occlusion culling, and the Memory, Logic and Chunks modules with each of
  their optimisations.

Every button has a tooltip that says what it does and whether it changes the look. Everything is saved in
`config/quicksilver.properties`, which you can also edit by hand. `/qs speed <option> <value>` changes one option from
the chat.

### Server owners

The server modules need nothing set up. A server running Quicksilver doesn't share its world seed: sharing it lets
players find ores, structures and bases. To let Quicksilver players see far terrain worked out from the world's
generator, add this line to the server's `config/quicksilver.properties` and restart:

```
far-terrain-share=on
```

## Results on a school laptop (R1)

Measured on an ASUS BR1402CGA (Intel Core i3-N305, Intel UHD integrated graphics, 8 GB RAM, Windows), one run per
scene, before the later speed work (full results in `docs/laptop-results/r1.md`):

| scene | vanilla avg FPS | Sodium avg FPS | Quicksilver avg FPS | vanilla 1% low | Sodium 1% low | Quicksilver 1% low |
|---|---|---|---|---|---|---|
| flythrough | 116 | 184 | 187 | 38 | 34 | 43 |
| spawn | 174 | 261 | 243 | 112 | 176 | 162 |
| water and glass | 244 | 373 | 393 | 159 | 204 | 209 |
| nether | 236 | 435 | 383 | 113 | 238 | 182 |
| mobs | 229 | 290 | 316 | 136 | 180 | 198 |
| spawn, 10 minutes | 154 | – | 247 | 77 | – | 171 |

Quicksilver beat vanilla in every scene, and its 1% lows stayed above 30 FPS everywhere. It was ahead of Sodium in the
flythrough, water and mobs scenes and behind it in spawn and the nether. Heap after 10 minutes: 461 MB against
vanilla's 479 MB.

## Known limits

- **Doesn't run with Sodium or Iris shader packs.** Quicksilver does Sodium's job. With Sodium or Iris installed,
  Quicksilver turns itself off, tells you once, and the game runs as if it weren't there.
- **Far terrain needs the seed.** In single player that is automatic. On a server, the server must run Quicksilver and
  have `far-terrain-share=on`. On any other server far terrain shows only land you have already seen there (remembered
  between visits). A dimension whose
  generator isn't noise-based (superflat, void, custom generators) also shows only land you have seen.
- **Create and Flywheel are only smoke-tested.** Create's machines, belts and contraptions are checked to load and draw
  in CI, but not picture by picture.
- Far terrain is simpler than real terrain: trees and big structures as simple shapes; a few structures the game would
  leave out may still show as outlines.
- While flying into new terrain, a section can appear a few frames later than in vanilla (uploads are spread out for
  smoother frame times).

## Reporting bugs

Open an issue at <https://github.com/meakaandre-tech/Quicksilver/issues> with:

- what happened and what you expected, with a screenshot if it's about the picture;
- your `logs/latest.log` (and the crash report from `crash-reports/` if the game crashed);
- your mods list, your graphics card and driver, and your operating system;
- whether it still happens with the Normal look and with the problem module switched off in the settings screen
  (Modules), if you can try that.

If something draws wrong, `block-renderer=off` or `occlusion=off` in `config/quicksilver.properties` (then restart)
hands that part back to vanilla, which helps narrow it down.

## Building

`./gradlew build` builds `build/libs/quicksilver-<version>+26.3.jar` and the bench-only jar. Every build is checked in
CI against vanilla (pictures, draw calls, memory, server tick times) on OpenGL, an old-GPU profile and Vulkan; see
`docs/ci-limits.md` and `docs/progress.md`.

## Licence

Quicksilver is free software under the GNU Lesser General Public License, version 3 only (`LICENSE`), which builds on
the GNU General Public License, version 3 (`COPYING`). It reuses some code from Fabric API (Apache-2.0), FerriteCore
(MIT) and Lithium (LGPL-3.0); see `NOTICE`. It contains no code from Sodium, Ecstatic or other mods whose licences
don't allow it: their ideas only.
