# Changelog

All notable changes to Quicksilver. Versions are `<version>+<Minecraft version>`.

## 1.0.0 (Minecraft 26.3)

The first public release, for Minecraft 26.3 on Fabric (needs Fabric API).

- **Renderer:** terrain meshed on worker threads into a compact 16-byte vertex format, packed into a few large GPU
  buffers and drawn with few draw calls; faces turned away from the camera skipped; uploads spread over frames;
  occlusion culling of terrain hidden behind terrain; vanilla's translucent order kept; Quicksilver's own Fabric
  Renderer API implementation (modded and connected-texture models); mobs drawn through a shared texture atlas;
  animated textures updated only when seen; OpenGL and Vulkan.
- **Speed options:** fog culling and fewer glass draws on by default (invisible); opaque leaves, simple water, far
  detail, entity, block entity and particle distances and particle density as opt-in options.
- **Presets and settings screen:** Low-end, Balanced (default) and Quality; a settings screen in Video Settings, Mod
  Menu and `/qs settings`, with a tooltip on every option; `config/quicksilver.properties`.
- **Dynamic lights** (off by default): held, dropped, burning and glowing light sources light their surroundings; Fast
  and Fancy levels; light levels from data files.
- **Pixel art look** (off by default): vanilla's colours in chunky pixels with dithering and outlines.
- **Far terrain** (off by default; 96 chunks in Quality): terrain out to 128 chunks worked out from the world's own
  generator, without loading chunks; real chunks replace it; works with world-gen mods such as Terralith. Fills the
  gaps where the game draws no terrain (for example far below the camera over the ocean). Servers running Quicksilver
  share their seed only with `far-terrain-share=on`; otherwise far terrain shows land the player has seen (and on a
  server without Quicksilver it stays off).
- **Server and memory modules:** faster entity lookups, mob AI and block entity ticks, cheaper chunk saving, smaller
  block-state tables; each checks its hooks at start-up and leaves the job to vanilla otherwise.
- **Bench:** `/qs bench` and a bench-only jar to compare vanilla, Sodium and Quicksilver.
- **Compatibility:** with Sodium or Iris installed, Quicksilver turns itself off with one clear message instead of
  failing to start; Create and Flywheel smoke-tested.
