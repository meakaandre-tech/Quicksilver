# Modrinth listing (ready to paste)

## Project settings

- **Name:** Quicksilver
- **URL slug:** `quicksilver`
- **Summary** (the short line under the name, at most 256 characters):

  > An all-in-one optimisation mod: a new renderer, speed presets, dynamic lights, a pixel art look, far terrain, and
  > server and memory optimisations. Tuned on old integrated graphics.

- **Categories:** Optimization, Utility (Modrinth's tags `optimization`, `utility`).
- **Environment:** Client: **optional**. Server: **optional**. (Modrinth's "Client and server, optional on both".) The
  client side gives the renderer, options and looks; the server side gives the server modules and, if the owner turns it
  on, far terrain's seed for players. Each side works without the other.
- **Licence:** LGPL-3.0-only
- **Source:** https://github.com/meakaandre-tech/Quicksilver
- **Issues:** https://github.com/meakaandre-tech/Quicksilver/issues

## Version 1.0.0

- **Version number:** `1.0.0+26.3`
- **Version name:** Quicksilver 1.0.0 for 26.3
- **Release channel:** Release
- **Loaders:** Fabric
- **Game versions:** 26.3
- **Dependencies:** Fabric API, **required**. Mod Menu, optional (adds a Configure button). Sodium and Iris:
  **incompatible** (Quicksilver turns itself off next to them).
- **File:** `quicksilver-1.0.0+26.3.jar` (the publish workflow uploads it with the changelog entry and these dependencies)

## Description (paste into the project's body)

**Quicksilver makes Minecraft 26.3 run faster.** It replaces the game's renderer, adds speed options and presets, and
brings dynamic lights, a pixel art look and far terrain, plus server and memory optimisations, in one mod. It is tuned
first on a school laptop with Intel UHD graphics, and runs on new machines too.

### What it does

- **A new renderer.** Terrain is built on worker threads into a compact format, kept in a few big GPU buffers and drawn
  with few draw calls. Faces turned away from you are skipped, terrain hidden behind hills is left out, and new chunks
  are uploaded a little at a time for smoother flying. Water and glass are sorted as in vanilla. It implements the
  Fabric Renderer API, so modded and connected-texture models still work. OpenGL and Vulkan.
- **Speed options and presets.** Low-end, Balanced (the default) and Quality. Balanced only uses shortcuts you can't
  see. Low-end also turns on opaque leaves, simple water, shorter entity and particle distances and a far-detail
  distance. Every option can be set on its own.
- **Dynamic lights** (off by default). Torches, lanterns and lava buckets in your hand or on the ground, burning mobs
  and flaming arrows light up their surroundings as they move. Mods can add their own light sources with a data file.
- **Pixel art look** (off by default). The world in chunky pixels with vanilla's colours, dithering and outlines. The
  HUD stays sharp, and it usually runs faster.
- **Far terrain** (off by default; on in the Quality preset). See hills, forests and snowy peaks out to 128 chunks
  without loading them. Quicksilver works them out from the world's own generator, so Terralith and other world-gen
  mods look right.
- **Server and memory modules.** Faster entity, hopper and mob AI ticks, cheaper chunk saving and smaller block-state
  tables, in single player and on servers.
- **A built-in benchmark:** `/qs bench`.

### Settings

**Options → Video Settings → Quicksilver...** (or Mod Menu, or `/qs settings`). Every button explains what it does and
whether it changes the look.

### On a school laptop

Intel Core i3-N305 with UHD graphics, average FPS (vanilla → Quicksilver): flythrough 116 → 187, spawn 174 → 243,
water and glass 244 → 393, nether 236 → 383, mobs 229 → 316. 1% lows stayed above 30 FPS in every scene. Full results:
[docs/laptop-results/r1.md](https://github.com/meakaandre-tech/Quicksilver/blob/main/docs/laptop-results/r1.md).

### Good to know

- **Not with Sodium or Iris.** Quicksilver does Sodium's job, so it doesn't run next to Sodium or Iris shader packs.
  If either is installed, Quicksilver turns itself off and tells you.
- **Far terrain needs the world's seed.** In single player it has it. On a server, the server needs Quicksilver with
  `far-terrain-share=on` in `config/quicksilver.properties` (off by default: the seed lets players find ores and
  bases). A Quicksilver server without it gives only land you have seen; a server without Quicksilver, no far terrain.
- **Create and Flywheel:** tested to load and draw, not checked picture by picture yet.
- Needs **Fabric API**. Java 25.

### Bugs and feedback

Please report problems on [GitHub](https://github.com/meakaandre-tech/Quicksilver/issues) with your
`logs/latest.log`, your mods list and your graphics card.

Quicksilver is open source (LGPL-3.0). It reuses a little code from Fabric API, FerriteCore and Lithium (see NOTICE),
and none from Sodium or other mods whose licences don't allow it.
