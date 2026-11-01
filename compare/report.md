# Quicksilver CI comparison

**passed**

## Suite core

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
- quicksilver-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- full: 0 / 0
- old-gpu: 0 / 0
- vulkan: 0 / 0

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % |
|---|---|---|---|---|---|
| spawn | 0.0616 | 10.05 | 0.3013 | 0.4365 | 0.1984 |
| flythrough | 0.0 | 14.95 | 0.0012 | 0.0012 | 0.0013 |
| water_glass | 0.0034 | 6.45 | 0.004 | 0.0054 | 0.0041 |
| nether | 0.0451 | 0.8 | 0.0455 | 0.0033 | 0.0097 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 | 0.0 |
| outline | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 |
| occlusion_move | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 |
| occlusion_move.open | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.closed | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2300 | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2297 | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2305 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2309 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_open | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 |
| translucent_move | 0.0 | 0.3 | 0.0001 | 0.0 | 0.0 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0002 | 0.0003 | 0.0003 |
| translucent_move.x2414 | 0.0004 | 0.3 | 0.0003 | 0.0001 | 0.0003 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0002 | 0.0002 | 0.0001 |
| translucent_move.low | 0.0005 | 0.3 | 0.0011 | 0.0012 | 0.0014 |
| translucent_move.back | 0.0001 | 0.3 | 0.0001 | 0.0001 | 0.0 |
| translucent_move.bare_back | 0.0003 | 0.3 | 0.0003 | 0.0 | 0.0 |
| water_glass_oit | 0.0049 | 0.3 | 0.0038 | 0.005 | 0.0048 |
| translucent_move_oit | 0.0 | 0.3 | 0.0001 | 0.0002 | 0.0 |
| translucent_move_oit.x2404 | 0.0 | 0.3 | 0.0002 | 0.0003 | 0.0003 |
| translucent_move_oit.x2414 | 0.0003 | 0.3 | 0.0005 | 0.0005 | 0.0002 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0002 | 0.0001 | 0.0003 |
| translucent_move_oit.low | 0.0007 | 0.3 | 0.0013 | 0.0015 | 0.0012 |
| translucent_move_oit.back | 0.0002 | 0.3 | 0.0 | 0.0 | 0.0001 |
| translucent_move_oit.bare_back | 0.0003 | 0.3 | 0.0002 | 0.0 | 0.0001 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 | 0.0226 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan |
|---|---|---|---|---|---|
| spawn | 92.59 | 18057 | 327 (863) | 253 (850) | 225 (750) |
| flythrough | 97.29 | 6020 | 46 (298) | 46 (298) | 50 (297) |
| water_glass | 95.8 | 25508 | 18 (2619) | 22 (2623) | 21 (2736) |
| nether | 99.38 | 905 | 3 (454) | 30 (481) | 92 (550) |
| mobs | 99.39 | 10 | 0 (0) | 0 (0) | 0 (0) |
| outline | 98.19 | 10 | 0 (0) | 0 (0) | 0 (0) |
| outline.bare | 98.2 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion | 98.62 | 22 | 1 (74) | 1 (74) | 1 (74) |
| occlusion_move | 99.15 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2297 | 98.94 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2305 | 98.96 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2309 | 99.13 | 32 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.open | 98.55 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.closed | 98.92 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2300 | 98.89 | 90 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2297 | 98.92 | 70 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2305 | 98.95 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2309 | 99.1 | 10 | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_open | 98.5 | 110 | 0 (0) | 0 (0) | 0 (0) |
| translucent_move | 96.93 | 13 | 1 (76) | 1 (76) | 2 (68) |
| translucent_move.x2404 | 95.93 | 15 | 4 (104) | 4 (104) | 4 (88) |
| translucent_move.x2414 | 95.86 | 13 | 1 (104) | 1 (104) | 2 (99) |
| translucent_move.x2424 | 96.74 | 13 | 3 (80) | 3 (80) | 1 (67) |
| translucent_move.low | 96.11 | 41 | 16 (22) | 14 (20) | 15 (17) |
| translucent_move.back | 96.93 | 13 | 1 (76) | 2 (77) | 2 (68) |
| translucent_move.bare_back | 96.9 | 13 | 2 (77) | 2 (77) | 1 (67) |
| water_glass_oit | 95.8 | 57 | 10 (2609) | 22 (2620) | 25 (2738) |
| translucent_move_oit | 96.93 | 12 | 1 (76) | 1 (76) | 4 (70) |
| translucent_move_oit.x2404 | 95.93 | 16 | 4 (104) | 5 (105) | 5 (89) |
| translucent_move_oit.x2414 | 95.86 | 10 | 7 (110) | 4 (108) | 2 (99) |
| translucent_move_oit.x2424 | 96.74 | 15 | 1 (78) | 3 (80) | 1 (67) |
| translucent_move_oit.low | 96.11 | 40 | 13 (18) | 16 (21) | 18 (20) |
| translucent_move_oit.back | 96.93 | 12 | 1 (76) | 2 (77) | 1 (67) |
| translucent_move_oit.bare_back | 96.9 | 15 | 1 (76) | 1 (76) | 5 (71) |
| flat_plants | 98.22 | 350 | 225 (7416) | 225 (7416) | 217 (7347) |
| renderer_off | 99.2 | 10 | 0 (0) | 0 (0) | 0 (0) |
| particles | 99.99 | 4 | 0 (0) | 0 (0) | 0 (0) |
| particles.bare | 99.99 | 4 | 0 (0) | 0 (0) | 0 (0) |
| animation | 99.62 | 10 | 1 (3) | 1 (3) | 1 (3) |
| animation.behind | 99.74 | 10 | 0 (2) | 0 (2) | 0 (1) |
| animation.front | 99.62 | 10 | 1 (3) | 1 (3) | 1 (3) |
| animated_items | 98.9 | 10 | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| spawn | 0.446 / 251 | 0.2107 / 252 | 0.2937 / 296 |
| flythrough | 0.0 / 0 | 0.0 / 0 | 0.0 / 1 |
| water_glass | 0.0031 / 11 | 0.0051 / 20 | 0.0026 / 13 |
| nether | 0.0451 / 0 | 0.0 / 0 | 0.0 / 0 |
| mobs | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| outline | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| outline.bare | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.x2297 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.x2305 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.x2309 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.open | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.closed | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2300 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2297 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2305 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2309 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_open | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| translucent_move | 0.0 / 1 | 0.0001 / 1 | 0.0 / 0 |
| translucent_move.x2404 | 0.0 / 0 | 0.0001 / 2 | 0.0002 / 2 |
| translucent_move.x2414 | 0.0004 / 1 | 0.0002 / 2 | 0.0007 / 4 |
| translucent_move.x2424 | 0.0 / 1 | 0.0001 / 1 | 0.0 / 1 |
| translucent_move.low | 0.0005 / 6 | 0.0002 / 3 | 0.0005 / 4 |
| translucent_move.back | 0.0001 / 0 | 0.0001 / 0 | 0.0003 / 3 |
| translucent_move.bare_back | 0.0003 / 2 | 0.0001 / 0 | 0.0 / 0 |
| water_glass_oit | 0.0048 / 18 | 0.0044 / 19 | 0.0039 / 16 |
| translucent_move_oit | 0.0 / 0 | 0.0003 / 1 | 0.0 / 1 |
| translucent_move_oit.x2404 | 0.0 / 0 | 0.0001 / 1 | 0.0003 / 3 |
| translucent_move_oit.x2414 | 0.0002 / 0 | 0.0004 / 2 | 0.0 / 0 |
| translucent_move_oit.x2424 | 0.0001 / 2 | 0.0001 / 2 | 0.0002 / 1 |
| translucent_move_oit.low | 0.0003 / 2 | 0.0003 / 1 | 0.0002 / 2 |
| translucent_move_oit.back | 0.0001 / 1 | 0.0001 / 1 | 0.0001 / 0 |
| translucent_move_oit.bare_back | 0.0003 / 1 | 0.0001 / 1 | 0.0 / 0 |
| flat_plants | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| renderer_off | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| particles | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| particles.bare | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation.behind | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation.front | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animated_items | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, core full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 13.88 (base 13.6) | 15 (base 14) | 25236 (base 22476) | 248.18 (base 259.07) | 5.99 (base 3.99) |
| flythrough | 13.07 (reported, not gated) | 33 (reported, not gated) | 357204 (reported, not gated) | 304.18 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 8.9 (base 8.97) | 15 (base 15) | 15976 (base 15576) | 233.64 (base 250.02) | 5.99 (base 5.99) |
| nether | 14.82 (base 15.63) | 12 (base 12) | 20940 (base 19648) | 254.62 (base 273.53) | 5.99 (base 5.99) |
| mobs | 19.72 (base 19.77) | 17 (base 17) | 616252 (base 1010948) | 253.21 (base 268.37) | 5.99 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6320 (base 6356) | 253.11 (base 264.69) | 5.99 (base 5.48) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100632 (base 126320) | 258.37 (base 265.1) | 5.99 (base 4.24) |
| occlusion_move | 16.07 (reported, not gated) | 15 (reported, not gated) | 82524 (reported, not gated) | 259.06 (base 265.74) | 5.99 (base 4.24) |
| translucent_move | 8.86 (reported, not gated) | 15 (reported, not gated) | 10984 (reported, not gated) | 261.06 (base 267.48) | 5.99 (base 5.48) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15528 (base 14688) | 232.63 (base 245.02) | 3.35 (base 3.73) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10984 (reported, not gated) | 235.16 (base 247.19) | 3.48 (base 3.73) |
| flat_plants | 17.36 (base 18.29) | 15 (base 15) | 9984 (base 9812) | 234.98 (base 246.92) | 3.48 (base 3.99) |
| renderer_off | 7.67 (base 7.67) | 14 (base 14) | 7352 (base 7164) | 228.53 (base 241.33) | 3.6 (base 4.12) |
| particles | 9.67 (base 9.72) | 15 (base 15) | 9204 (base 17128) | 256.22 (base 261.44) | 5.99 (base 5.99) |
| animation | 49 median (avg 39.94) (base 49) | 15 (base 15) | 2224 (base 2056) | 253.5 (base 260.68) | 5.99 (base 5.99) |
| animated_items | 60 median (avg 46.73) (base 60) | 24 (base 23) | 22136 (base 21940) | 228.43 (base 239.81) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.88 / 14 (11.62) | 124.0 / 124 (11.23) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (8.42) | 123.07 / 123 (7.56) | median and average, at most vanilla + 2 |
| water_glass | 8.9 / 9 (22.17) | 123.41 / 124 (19.5) | median, at most vanilla |
| nether | 14.82 / 16 (22.16) | 120.7 / 121 (19.17) | median, x 1.10 + 2 |
| mobs | 19.72 / 20 (27.57) | 110.94 / 134 (24.95) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.2 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.07 / 17 (30.0) | 94.27 / 133 (29.99) | median and average, x 1.10 + 2 |
| translucent_move | 8.86 / 9 (23.14) | 120.03 / 124 (20.45) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (11.96) | 129.0 / 129 (10.59) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (10.93) | 129.0 / 129 (10.19) | median and average, at most vanilla |
| flat_plants | 17.36 / 19 (23.11) | 122.95 / 124 (19.78) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.93) | 85.18 / 123 (29.65) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.01) | median and average, x 1.10 + 2 |
| animation | 39.94 / 49 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.73 / 60 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.513 | 36.0 / 22.513 | 0.0 / 0.0 | 416.0 / 38.7 |
| flythrough | 112.0 / 86.327 | 112.0 / 86.327 | 0.0 / 0.0 | 416.0 / 145.252 |
| water_glass | 36.0 / 12.555 | 36.0 / 12.555 | 0.0 / 0.0 | 416.0 / 22.118 |
| nether | 20.0 / 15.107 | 20.0 / 15.107 | 0.0 / 0.0 | 256.0 / 26.554 |
| mobs | 16.0 / 9.733 | 16.0 / 9.733 | 0.0 / 0.0 | 256.0 / 17.048 |
| outline | 16.0 / 1.56 | 16.0 / 1.56 | 0.0 / 0.0 | 256.0 / 2.746 |
| occlusion | 20.0 / 2.585 | 20.0 / 2.585 | 0.0 / 0.0 | 416.0 / 4.508 |
| occlusion_move | 20.0 / 3.401 | 20.0 / 3.401 | 0.0 / 0.0 | 416.0 / 5.855 |
| translucent_move | 28.0 / 13.01 | 28.0 / 13.01 | 0.0 / 0.0 | 416.0 / 22.417 |
| water_glass_oit | 20.0 / 12.555 | 20.0 / 12.555 | 0.0 / 0.0 | 416.0 / 21.818 |
| translucent_move_oit | 28.0 / 12.599 | 28.0 / 12.599 | 0.0 / 0.0 | 416.0 / 21.798 |
| flat_plants | 24.0 / 14.35 | 24.0 / 14.35 | 0.0 / 0.0 | 416.0 / 24.499 |
| renderer_off | 24.0 / 8.944 | 24.0 / 8.944 | 0.0 / 0.0 | 416.0 / 15.725 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 506099.767 (682751.931) | 25.874 | 1.158 | 649764 / 589968 | 624640 (2097152.0) | 232 / 224 | 0.0 / 0 |
| flythrough | 557902.833 (893868.571) | 37.586 | 1.084 | 2316196 / 7479352 | 2096600 (2097152.0) | 168 / 151 | 6.544 / 82 |
| water_glass | 217370.749 (390045.657) | 44.27 | 1.117 | 172412 / 16792 | 156864 (2097152.0) | 7 / 323 | 0.0 / 0 |
| nether | 317593.174 (476450.962) | 33.342 | 1.272 | 271868 / 478928 | 251264 (2097152.0) | 7 / 376 | 0.0 / 0 |
| mobs | 167998.345 (304165.024) | 44.767 | 0.99 | 616252 / 616132 | 0 (2097152.0) | 5 / 2 | 0.0 / 0 |
| outline | 28639.653 (49290.013) | 41.896 | 1.0 | 6320 / 6320 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 46043.159 (80825.129) | 43.034 | 1.197 | 199292 / 126324 | 98752 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50592.361 (88907.038) | 43.095 | 1.222 | 666268 / 1375724 | 589504 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 201355.104 (357291.671) | 43.644 | 1.182 | 767036 / 1333328 | 756480 (2097152.0) | 4 / 128 | 0.0 / 0 |
| water_glass_oit | 217792.815 (390802.706) | 44.27 | 1.117 | 171320 / 17128 | 156800 (2097152.0) | 238 / 211 | 0.0 / 0 |
| translucent_move_oit | 201631.193 (357555.633) | 43.608 | 1.177 | 742948 / 1290636 | 731840 (2097152.0) | 218 / 203 | 0.0 / 0 |
| flat_plants | 243361.619 (447488.498) | 45.616 | 1.06 | 272220 / 271636 | 0 (2097152.0) | 13 / 260 | 0.0 / 0 |
| renderer_off | 156262.437 (281417.028) | 44.473 | 1.015 | 7352 / 7292 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.736 (5631.76) | 42.864 | 1.071 | 86832 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79864 / 123068 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.013 | 787.379 | 16 (vanilla 28) | 1359992 | 40.918 / 0.084 | 22.513 / 36.0 | 36.316 | 2403 / 0 | 3.691 (7.491) |
| flythrough | indirect, one multi-draw per arena and layer | 3.018 | 904.179 | 16 (vanilla 28) | 5231696 | 15.261 / 0.982 | 86.327 / 112.0 | 139.701 | 6566 / 0 | 5.902 (15.305) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 273.616 | 16 (vanilla 28) | 778336 | 33.08 / 0.078 | 12.555 / 36.0 | 20.784 | 3104 / 0 | 4.829 (4.113) |
| nether | indirect, one multi-draw per arena and layer | 2.005 | 472.063 | 16 (vanilla 28) | 950804 | 27.759 / 0.173 | 15.107 / 20.0 | 25.389 | 4168 / 0 | 2.352 (2.752) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 196.356 | 16 (vanilla 28) | 607228 | 25.213 / 0.151 | 9.733 / 16.0 | 16.215 | 4606 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 43.072 | 16 (vanilla 28) | 98416 | 24.72 / 0.15 | 1.56 / 16.0 | 2.628 | 4702 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 71.119 | 16 (vanilla 28) | 161380 | 23.543 / 0.142 | 2.585 / 20.0 | 4.309 | 4951 / 0 | 2.129 (2.049) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 76.8 | 16 (vanilla 28) | 211804 | 22.35 / 0.135 | 3.401 / 20.0 | 5.656 | 5229 / 0 | 4.149 (10.959) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.006 | 249.381 | 16 (vanilla 28) | 801752 | 19.557 / 0.125 | 13.01 / 28.0 | 21.409 | 5982 / 0 | 6.587 (19.295) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.021 | 282.181 | 16 (vanilla 28) | 778332 | 7.444 / 0.043 | 12.555 / 20.0 | 20.784 | 1093 / 0 | 6.861 (6.161) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.023 | 264.417 | 16 (vanilla 28) | 775916 | 6.68 / 0.11 | 12.599 / 28.0 | 20.719 | 2436 / 0 | 6.927 (18.934) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 285.617 | 16 (vanilla 28) | 893044 | 6.263 / 0.01 | 14.35 / 24.0 | 23.847 | 940 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 206.344 | 16 (vanilla 28) | 561896 | 2.362 / 0.02 | 8.944 / 24.0 | 15.004 | 604 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 19.511 / 0.124 | 0.131 / 28.0 | 0.225 | 6023 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.347 / 0.123 | 0.302 / 28.0 | 0.518 | 6125 / 0 | 1.091 (1.356) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.29 / 0.124 | 0.153 / 28.0 | 0.261 | 6174 / 0 | 1.009 (1.41) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 1.0 | 0.0 | 0 | 0 | 55 (0.023 / 0.034 / 0.055; 0) | 0 | 35649 / 0 / 0 |
| flythrough | 189.982 | 1.0 | 0.0 | 0 | 0 | 886 (0.016 / 0.037 / 2.865; 0) | 51 | 32107 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1776 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.011 / 0.012; 0) | 32 | 1200 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.114 / 0.138 / 2.274; 0) | 180 | 3241 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 717 | 0 (None / None / None; 0) | 0 | 956 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 657 | 0 (None / None / None; 0) | 0 | 1533 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1852 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 342.0 | 1.369 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.028 (0.112; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 430.047 | 1.0 (0.0, 0.0) | 1.166 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.048; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 106.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.139 (0.293; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.065 (0.148; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.692 | 10.0 (9.0, 2.358) | 6.0 (6.0, 2.282) | 0.057 (0.222; 0) | 0 | 2784 / 1506126 / 0 / 0 |
| translucent_move | 136.089 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.676 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.448 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 68.082 / 0.515 | 0.024 / 0.011 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.414 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.84 |
| water_glass | 114.41 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 55.561 / 55.653 | 0.021 / 0.031 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 9.029 | 0.7 / 0.885 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 46.628 / 6.284 | 0.087 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 92.139 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 111.064 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.528 / 12.434 | 0.006 / 0.017 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.038 / 52.05 | 0.017 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.973 / 11.849 | 0.007 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 114.127 / 8.658 | 0.828 / 0.835 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.918 / 1.721 | 0.014 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 77.508 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.01 / 0.055 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.013 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

GUI pass, core full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| occlusion_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flat_plants | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| renderer_off | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| particles | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animation | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animated_items | 4.0 / 4.0 | 3.0 / 3.0 | 9.0 / 9.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 49.54 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 247.83 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 66.83 (reported, not gated) | 44 (reported, not gated) | 527812 (reported, not gated) | 303.8 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.98 (base 20.0) | 13 (base 14) | 7204 (base 10264) | 233.53 (base 249.83) | 4.24 (base 5.99) |
| nether | 33.84 (base 33.79) | 10 (base 11) | 4064 (base 10656) | 254.42 (base 272.57) | 4.24 (base 5.99) |
| mobs | 28.86 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 252.48 (base 268.23) | 4.24 (base 5.99) |
| outline | 19.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 252.29 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 22.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 257.6 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.03 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 258.42 (base 265.66) | 4.24 (base 5.99) |
| translucent_move | 17.99 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 260.29 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 6868 (base 7604) | 232.94 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.52 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 235.65 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 32.88 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 235.52 (base 248.11) | 3.46 (base 5.99) |
| renderer_off | 17.68 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 228.04 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 255.22 (base 261.4) | 4.24 (base 4.24) |
| animation | 49 median (avg 39.95) (base 49) | 13 (base 13) | 1716 (base 1716) | 252.99 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 46.77) (base 60) | 21 (base 22) | 21508 (base 21668) | 227.91 (base 239.53) | 4.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.54 / 49 (11.2) | 848.11 / 847 (18.27) | median and average, x 1.10 + 2 |
| flythrough | 66.83 / 64 (6.94) | 1043.15 / 1044 (11.78) | median and average, at most vanilla |
| water_glass | 19.98 / 20 (20.29) | 354.7 / 390 (28.72) | median, at most vanilla |
| nether | 33.84 / 34 (19.01) | 556.22 / 590 (28.14) | median, x 1.10 + 2 |
| mobs | 28.86 / 29 (23.1) | 289.33 / 328 (29.99) | median, x 1.10 + 2 |
| outline | 19.67 / 20 (29.97) | 128.27 / 167 (30.0) | median, x 1.10 + 2 |
| occlusion | 22.67 / 23 (30.0) | 161.27 / 200 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 24.03 / 24 (29.86) | 166.6 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 17.99 / 18 (18.73) | 331.56 / 367 (29.71) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (10.13) | 401.0 / 401 (15.07) | median, at most vanilla |
| translucent_move_oit | 25.52 / 26 (9.37) | 385.88 / 385 (13.91) | median and average, at most vanilla |
| flat_plants | 32.88 / 33 (18.99) | 364.07 / 401 (29.28) | median, x 1.10 + 2 |
| renderer_off | 17.68 / 18 (29.31) | 287.27 / 326 (30.01) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.29 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.95 / 49 (30.0) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.77 / 60 (30.0) | 167.09 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.513 | 36.0 / 22.513 | 0.0 / 0.0 | 416.0 / 36.722 |
| flythrough | 112.0 / 83.787 | 112.0 / 83.787 | 0.0 / 0.0 | 416.0 / 152.049 |
| water_glass | 36.0 / 12.555 | 36.0 / 12.555 | 0.0 / 0.0 | 416.0 / 21.818 |
| nether | 20.0 / 15.111 | 20.0 / 15.111 | 0.0 / 0.0 | 256.0 / 26.551 |
| mobs | 16.0 / 9.733 | 16.0 / 9.733 | 0.0 / 0.0 | 256.0 / 17.048 |
| outline | 16.0 / 1.56 | 16.0 / 1.56 | 0.0 / 0.0 | 256.0 / 2.746 |
| occlusion | 20.0 / 2.46 | 20.0 / 2.46 | 0.0 / 0.0 | 416.0 / 4.497 |
| occlusion_move | 20.0 / 3.302 | 20.0 / 3.302 | 0.0 / 0.0 | 416.0 / 5.915 |
| translucent_move | 28.0 / 12.971 | 28.0 / 12.971 | 0.0 / 0.0 | 416.0 / 22.616 |
| water_glass_oit | 20.0 / 12.555 | 20.0 / 12.555 | 0.0 / 0.0 | 416.0 / 21.818 |
| translucent_move_oit | 28.0 / 12.614 | 28.0 / 12.614 | 0.0 / 0.0 | 416.0 / 21.903 |
| flat_plants | 24.0 / 14.289 | 24.0 / 14.289 | 0.0 / 0.0 | 416.0 / 24.743 |
| renderer_off | 24.0 / 8.944 | 24.0 / 8.944 | 0.0 / 0.0 | 416.0 / 15.725 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 445005.865 (682674.843) | 34.814 | 1.772 | 311908 / 875328 | 310528 (2097152.0) | 223 / 365 | 0.0 / 0 |
| flythrough | 552750.145 (885557.884) | 37.582 | 1.082 | 2111156 / 6929928 | 2096256 (2097152.0) | 138 / 235 | 9.014 / 75 |
| water_glass | 217416.617 (390128.015) | 44.27 | 1.117 | 164180 / 11188 | 156864 (2097152.0) | 86 / 1 | 0.0 / 0 |
| nether | 268638.879 (476725.037) | 43.649 | 1.7 | 158672 / 449680 | 154944 (2097152.0) | 378 / 2 | 0.0 / 0 |
| mobs | 168057.761 (304272.599) | 44.767 | 0.99 | 617268 / 870372 | 6592 (2097152.0) | 29 / 0 | 0.0 / 0 |
| outline | 28639.733 (49290.15) | 41.896 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion | 43973.289 (76781.97) | 42.73 | 1.211 | 196772 / 358220 | 98624 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 48652.553 (85130.506) | 42.849 | 1.236 | 672224 / 1117980 | 597248 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 200627.31 (356059.353) | 43.653 | 1.182 | 759220 / 1329236 | 756608 (2097152.0) | 312 / 0 | 0.0 / 0 |
| water_glass_oit | 217955.673 (391094.574) | 44.27 | 1.117 | 7988 / 11412 | 0 (2097152.0) | 202 / 301 | 0.0 / 0 |
| translucent_move_oit | 200785.241 (356092.246) | 43.614 | 1.181 | 737204 / 1285572 | 731840 (2097152.0) | 187 / 278 | 0.0 / 0 |
| flat_plants | 242500.158 (445749.024) | 45.597 | 1.06 | 2052 / 4452 | 0 (2097152.0) | 379 / 3 | 0.0 / 0 |
| renderer_off | 156266.212 (281419.42) | 44.472 | 1.015 | 1380 / 3172 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| particles | 1927.207 (4215.013) | 54.278 | 1.0 | 8772 / 9636 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86232 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79236 / 122580 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.175 | 787.516 | 16 (vanilla 28) | 1359440 | 38.978 / 0.08 | 22.513 / 36.0 | 36.301 | 2378 / 0 | 6.507 (11.021) |
| flythrough | plain, one multi-draw per region and layer | 57.116 | 895.899 | 16 (vanilla 28) | 5074776 | 15.408 / 1.02 | 83.787 / 112.0 | 135.511 | 6433 / 0 | 8.434 (21.814) |
| water_glass | plain, one multi-draw per region and layer | 14.035 | 273.674 | 16 (vanilla 28) | 778336 | 31.48 / 0.073 | 12.555 / 36.0 | 20.784 | 3027 / 0 | 13.54 (8.696) |
| nether | plain, one multi-draw per region and layer | 20.053 | 471.237 | 16 (vanilla 28) | 950996 | 26.364 / 0.179 | 15.111 / 20.0 | 25.394 | 4128 / 0 | 3.012 (5.69) |
| mobs | plain, one multi-draw per region and layer | 11.024 | 196.425 | 16 (vanilla 28) | 607228 | 23.96 / 0.156 | 9.733 / 16.0 | 16.215 | 4576 / 0 | 0.391 (0.351) |
| outline | plain, one multi-draw per region and layer | 11.018 | 43.072 | 16 (vanilla 28) | 98416 | 23.487 / 0.154 | 1.56 / 16.0 | 2.628 | 4673 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 10.017 | 71.119 | 16 (vanilla 28) | 153308 | 22.413 / 0.147 | 2.46 / 20.0 | 4.094 | 4924 / 0 | 3.315 (2.772) |
| occlusion_move | plain, one multi-draw per region and layer | 10.987 | 76.427 | 16 (vanilla 28) | 205644 | 21.256 / 0.139 | 3.302 / 20.0 | 5.491 | 5202 / 0 | 7.084 (15.51) |
| translucent_move | plain, one multi-draw per region and layer | 12.032 | 249.449 | 16 (vanilla 28) | 799128 | 18.415 / 0.126 | 12.971 / 28.0 | 21.339 | 6001 / 0 | 7.426 (18.137) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.079 | 282.391 | 16 (vanilla 28) | 778336 | 7.465 / 0.043 | 12.555 / 20.0 | 20.784 | 1089 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.61 | 264.342 | 16 (vanilla 28) | 776560 | 6.404 / 0.086 | 12.614 / 28.0 | 20.736 | 2438 / 0 | 9.202 (24.883) |
| flat_plants | plain, one multi-draw per region and layer | 17.045 | 285.752 | 16 (vanilla 28) | 889152 | 5.775 / 0.01 | 14.289 / 24.0 | 23.743 | 933 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 13.022 | 206.352 | 16 (vanilla 28) | 561880 | 2.365 / 0.02 | 8.944 / 24.0 | 15.004 | 608 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 12.02 | 16 (vanilla 28) | 8416 | 18.369 / 0.125 | 0.131 / 28.0 | 0.225 | 6045 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 18.216 / 0.124 | 0.302 / 28.0 | 0.518 | 6147 / 0 | 2.55 (2.775) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 18.163 / 0.125 | 0.153 / 28.0 | 0.261 | 6197 / 0 | 0.99 (1.427) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 17.0 | 0.0 | 0 | 0 | 37 (0.061 / 0.078 / 1.2; 0) | 0 | 34272 / 0 / 0 |
| flythrough | 187.381 | 26.129 | 0.0 | 0 | 0 | 859 (0.046 / 0.049 / 11.027; 0) | 41 | 26046 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1624 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.01 / 0.011; 0) | 32 | 1196 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 181 (0.152 / 0.171 / 3.177; 0) | 181 | 2625 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 609 | 0 (None / None / None; 0) | 0 | 812 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 564 | 0 (None / None / None; 0) | 0 | 1316 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1520 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2348 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 342.0 | 1.33 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.072; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 428.144 | 1.0 (0.0, 0.0) | 1.266 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 106.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.133 (0.273; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.07 (0.108; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.351 | 10.0 (9.0, 2.351) | 6.0 (6.0, 2.278) | 0.066 (0.227; 0) | 0 | 2768 / 1497314 / 0 / 0 |
| translucent_move | 136.067 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.574 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.079; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.157 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 70.578 / 0.156 | 0.024 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.283 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.82 |
| water_glass | 80.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.655 / 51.68 | 0.021 / 0.03 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 81.646 / 10.0 | 0.861 / 0.839 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 37.372 / 8.068 | 0.068 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 77.441 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.623 / 12.541 | 0.006 / 0.016 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 48.035 / 48.025 | 0.011 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.392 / 13.287 | 0.006 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 78.436 / 10.0 | 0.954 / 0.876 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.098 / 2.908 | 0.016 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.007 / 0.061 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.287 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.011 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | 136.426 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

GUI pass, core old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| occlusion_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flat_plants | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| renderer_off | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| particles | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animation | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animated_items | 4.0 / 4.0 | 3.0 / 3.0 | 9.0 / 9.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

### Counts, core vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 14.08 (base 14.05) | 15 (base 15) | 31060 (base 27764) | 247.97 (base 257.2) | 3.98 (base 3.98) |
| flythrough | 13.05 (reported, not gated) | 22 (reported, not gated) | 169840 (reported, not gated) | 304.34 (base 318.06) | 3.71 (base 4.23) |
| water_glass | 8.68 (base 9.0) | 15 (base 15) | 15528 (base 15108) | 233.35 (base 244.39) | 3.98 (base 4.23) |
| nether | 12.3 (base 15.71) | 12 (base 12) | 20828 (base 19912) | 254.6 (base 268.95) | 3.98 (base 4.23) |
| mobs | 19.67 (base 19.97) | 16 (base 17) | 616092 (base 1008176) | 252.74 (base 264.31) | 5.98 (base 6.23) |
| outline | 10.72 (base 10.67) | 18 (base 18) | 6320 (base 6356) | 252.46 (base 264.58) | 5.98 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100652 (base 126356) | 259.39 (base 264.78) | 5.98 (base 3.98) |
| occlusion_move | 16.07 (reported, not gated) | 15 (reported, not gated) | 82544 (reported, not gated) | 258.5 (base 265.16) | 5.98 (base 4.23) |
| translucent_move | 8.68 (reported, not gated) | 15 (reported, not gated) | 11004 (reported, not gated) | 260.53 (base 268.35) | 5.98 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15528 (base 15024) | 232.54 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10836 (reported, not gated) | 235.02 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 15.45 (base 18.96) | 15 (base 15) | 10096 (base 9864) | 234.84 (base 248.07) | 3.2 (base 5.98) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 7352 (base 7180) | 228.4 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9204 (base 17128) | 255.7 (base 261.4) | 5.98 (base 5.98) |
| animation | 49 median (avg 39.93) (base 49) | 15 (base 15) | 2224 (base 2056) | 253.19 (base 260.68) | 5.98 (base 5.98) |
| animated_items | 60 median (avg 46.77) (base 60) | 24 (base 23) | 22136 (base 21940) | 228.22 (base 239.74) | 5.98 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.08 / 14 (16.06) | 123.3 / 123 (9.44) | median and average, x 1.10 + 2 |
| flythrough | 13.05 / 13 (11.12) | 123.06 / 123 (5.52) | median and average, at most vanilla + 2 |
| water_glass | 8.68 / 9 (29.13) | 124.0 / 124 (15.39) | median, at most vanilla |
| nether | 12.3 / 16 (29.24) | 120.98 / 121 (15.65) | median, x 1.10 + 2 |
| mobs | 19.67 / 20 (29.98) | 134.0 / 134 (19.52) | median, x 1.10 + 2 |
| outline | 10.72 / 11 (29.98) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.46 / 133 (29.93) | median and average, x 1.10 + 2 |
| occlusion_move | 16.07 / 17 (29.98) | 94.33 / 133 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 8.68 / 9 (29.47) | 124.0 / 124 (16.4) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (15.65) | 129.0 / 129 (8.63) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (13.28) | 129.0 / 129 (8.23) | median and average, at most vanilla |
| flat_plants | 15.45 / 19 (29.36) | 123.85 / 124 (15.78) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.86) | 107.22 / 123 (23.16) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.93 / 49 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.77 / 60 (30.01) | 155.22 / 190 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.539 | 36.0 / 22.539 | 0.0 / 0.0 | 416.0 / 38.37 |
| flythrough | 112.0 / 88.432 | 112.0 / 88.432 | 0.0 / 0.0 | 416.0 / 144.272 |
| water_glass | 36.0 / 12.555 | 36.0 / 12.555 | 0.0 / 0.0 | 416.0 / 21.818 |
| nether | 20.0 / 15.105 | 20.0 / 15.105 | 0.0 / 0.0 | 256.0 / 26.545 |
| mobs | 16.0 / 9.733 | 16.0 / 9.733 | 0.0 / 0.0 | 256.0 / 17.048 |
| outline | 16.0 / 1.56 | 16.0 / 1.56 | 0.0 / 0.0 | 256.0 / 2.746 |
| occlusion | 20.0 / 2.455 | 20.0 / 2.455 | 0.0 / 0.0 | 416.0 / 4.231 |
| occlusion_move | 20.0 / 3.3 | 20.0 / 3.3 | 0.0 / 0.0 | 416.0 / 5.684 |
| translucent_move | 28.0 / 12.916 | 28.0 / 12.916 | 0.0 / 0.0 | 416.0 / 22.29 |
| water_glass_oit | 20.0 / 12.555 | 20.0 / 12.555 | 0.0 / 0.0 | 416.0 / 21.818 |
| translucent_move_oit | 28.0 / 12.559 | 28.0 / 12.559 | 0.0 / 0.0 | 416.0 / 21.666 |
| flat_plants | 24.0 / 14.309 | 24.0 / 14.309 | 0.0 / 0.0 | 416.0 / 24.822 |
| renderer_off | 24.0 / 8.944 | 24.0 / 8.944 | 0.0 / 0.0 | 416.0 / 15.725 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 505473.533 (681909.47) | 25.874 | 1.158 | 359300 / 660848 | 328240 (2097152.0) | 321 / 188 | 0.0 / 0 |
| flythrough | 565188.802 (905524.784) | 37.584 | 1.082 | 2122980 / 7980044 | 2094472 (2097152.0) | 222 / 110 | 6.457 / 85 |
| water_glass | 217252.646 (389834.67) | 44.271 | 1.117 | 171768 / 16568 | 156800 (2097152.0) | 7 / 307 | 0.0 / 0 |
| nether | 317437.887 (476208.827) | 33.341 | 1.272 | 252196 / 429748 | 230144 (2097152.0) | 3 / 312 | 0.0 / 0 |
| mobs | 167973.957 (304120.868) | 44.767 | 0.99 | 616092 / 616292 | 0 (2097152.0) | 0 / 290 | 0.0 / 0 |
| outline | 28639.653 (49290.013) | 41.896 | 1.0 | 7824 / 6320 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 43975.292 (76793.99) | 42.736 | 1.211 | 100652 / 126344 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| occlusion_move | 48757.783 (85305.633) | 42.843 | 1.236 | 697928 / 1150084 | 621120 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 200424.922 (355735.78) | 43.659 | 1.182 | 769876 / 1333944 | 759040 (2097152.0) | 6 / 327 | 0.0 / 0 |
| water_glass_oit | 217577.135 (390415.333) | 44.27 | 1.117 | 17656 / 17240 | 0 (2097152.0) | 312 / 172 | 0.0 / 0 |
| translucent_move_oit | 199970.77 (354571.962) | 43.602 | 1.181 | 743044 / 1290804 | 731840 (2097152.0) | 265 / 164 | 0.0 / 0 |
| flat_plants | 242794.917 (446381.152) | 45.608 | 1.06 | 10636 / 10016 | 0 (2097152.0) | 6 / 315 | 0.0 / 0 |
| renderer_off | 156261.307 (281410.586) | 44.472 | 1.015 | 7352 / 7292 | 0 (2097152.0) | 2 / 4 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86832 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79864 / 123000 | 57728 (2097152.0) | 0 / 1 | 0.0 / 0 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.009 | 786.442 | 16 (vanilla 28) | 1359928 | 41.158 / 0.08 | 22.539 / 36.0 | 36.314 | 2403 / 0 | 1.807 (2.05) |
| flythrough | indirect, one multi-draw per arena and layer | 3.014 | 918.743 | 16 (vanilla 28) | 5360292 | 15.372 / 1.037 | 88.432 / 112.0 | 143.135 | 6719 / 0 | 4.272 (10.926) |
| water_glass | indirect, one multi-draw per arena and layer | 3.005 | 273.469 | 16 (vanilla 28) | 778332 | 33.08 / 0.072 | 12.555 / 36.0 | 20.784 | 3060 / 0 | 2.489 (2.149) |
| nether | indirect, one multi-draw per arena and layer | 2.003 | 470.803 | 16 (vanilla 28) | 950868 | 27.796 / 0.168 | 15.105 / 20.0 | 25.391 | 4120 / 0 | 1.855 (2.622) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 196.327 | 16 (vanilla 28) | 607228 | 25.278 / 0.157 | 9.733 / 16.0 | 16.215 | 4562 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 43.072 | 16 (vanilla 28) | 98416 | 24.786 / 0.156 | 1.56 / 16.0 | 2.628 | 4658 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 71.119 | 16 (vanilla 28) | 153332 | 23.721 / 0.149 | 2.455 / 20.0 | 4.094 | 4893 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 76.461 | 16 (vanilla 28) | 206300 | 22.535 / 0.141 | 3.3 / 20.0 | 5.509 | 5169 / 0 | 2.84 (7.115) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.005 | 248.886 | 16 (vanilla 28) | 796976 | 19.596 / 0.129 | 12.916 / 28.0 | 21.282 | 5950 / 0 | 3.174 (6.158) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.016 | 281.901 | 16 (vanilla 28) | 778336 | 7.47 / 0.044 | 12.555 / 20.0 | 20.784 | 1089 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.019 | 262.981 | 16 (vanilla 28) | 774432 | 6.817 / 0.113 | 12.559 / 28.0 | 20.68 | 2444 / 0 | 3.469 (7.193) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 285.486 | 16 (vanilla 28) | 891244 | 6.183 / 0.01 | 14.309 / 24.0 | 23.799 | 943 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 206.345 | 16 (vanilla 28) | 561880 | 2.308 / 0.02 | 8.944 / 24.0 | 15.004 | 616 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 19.521 / 0.129 | 0.131 / 28.0 | 0.225 | 5994 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.358 / 0.128 | 0.302 / 28.0 | 0.518 | 6096 / 0 | 0.848 (1.089) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.301 / 0.128 | 0.153 / 28.0 | 0.261 | 6146 / 0 | 0.762 (1.026) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 1.0 | 0.0 | 0 | 0 | 45 (0.017 / 0.027 / 0.043; 0) | 0 | 49266 / 0 / 0 |
| flythrough | 194.103 | 1.0 | 0.0 | 0 | 0 | 931 (0.014 / 0.039 / 0.151; 0) | 62 | 43285 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2332 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.015 / 0.019; 0) | 32 | 1200 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.072 / 0.115 / 0.131; 0) | 180 | 4137 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 939 | 0 (None / None / None; 0) | 0 | 1252 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 798 | 0 (None / None / None; 0) | 0 | 1862 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2352 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 342.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.045 (0.09; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 430.413 | 1.0 (0.0, 0.0) | 1.157 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 106.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.104 (0.162; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.049 (0.151; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.353 | 10.0 (9.0, 2.367) | 6.0 (6.0, 2.28) | 0.046 (0.225; 0) | 0 | 2788 / 1509462 / 0 / 0 |
| translucent_move | 135.421 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.515 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.237; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.298 / 0.084 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 83.252 / 0.087 | 0.025 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.865 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.448 / 53.455 | 0.013 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 6.821 | 0.978 / 0.798 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 37.17 / 6.679 | 0.059 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.768 / 12.763 | 0.005 / 0.015 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.168 / 52.233 | 0.016 / 0.019 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.461 / 11.353 | 0.007 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 6.814 | 0.848 / 0.957 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.077 / 2.823 | 0.018 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 99.352 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.004 / 0.019 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.269 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.795 | 0.006 / 0.009 | 56 (3) | 40.51 / 9.238 / 31.273 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

GUI pass, core vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| occlusion_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flat_plants | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| renderer_off | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| particles | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animation | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animated_items | 4.0 / 4.0 | 3.0 / 3.0 | 9.0 / 9.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

## Suite siftec

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
- quicksilver-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- full: 4 / 4
- old-gpu: 36 / 36
- vulkan: 0 / 0

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % |
|---|---|---|---|---|---|
| factory | 0.0001 | 0.3 | 0.0001 | 0.0 | 0.0167 |
| factory_flat | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0023 | 0.55 | 0.0061 | 0.0075 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan |
|---|---|---|---|---|---|
| factory | 95.6 | 500 | 0 (14) | 0 (14) | 242 (372) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) |
| mam | 99.77 | 10 | 0 (0) | 0 (0) | 0 (117383) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 37 (4278) | 37 (4278) | None (None) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0001 / 0 | 0.0 / 0 | 0.0 / 0 |
| factory_flat | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0023 / 10 | 0.0035 / 8 | skipped |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.23 (base 12.22) | 15 (base 15) | 6956 (base 6976) | 361.83 (base 361.48) | 3.99 (base 5.48) |
| factory_flat | 11.67 (reported, not gated) | 15 (base 15) | 6844 (base 6844) | 359.74 (base 360.51) | 3.48 (base 5.48) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 379.38 (base 379.72) | 3.99 (base 5.87) |
| hub | 21.54 (base 21.53) | 16 (base 16) | 66576 (base 66576) | 391.6 (base 392.33) | 3.99 (base 5.48) |
| mam | 22.51 (base 22.53) | 19 (base 19) | 23748 (base 23748) | 405.48 (base 405.55) | 5.99 (base 8.12) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 403.92 (base 404.14) | 5.99 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 17 (base 17) | 43852 (base 44728) | 392.68 (base 392.95) | 5.81 (base 8.24) |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 393.74 (base 394.1) | 5.81 (base 10.24) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.23 / 12 (29.37) | 106.71 / 152 (29.54) | median and average, x 1.10 + 2 |
| factory_flat | 11.67 / 12 (29.79) | 105.63 / 152 (29.84) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (15.42) | 153.0 / 153 (15.0) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.63) | 116.16 / 161 (29.28) | median and average, x 1.10 + 2 |
| mam | 22.51 / 22 (29.43) | 118.17 / 162 (29.03) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.79) | 180.66 / 227 (29.87) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.86) | 117.71 / 164 (29.68) | median, at most vanilla |
| create_ct | 6.67 / 7 (29.99) | 100.0 / 147 (29.99) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.894 |
| hub | 12.0 / 1.886 | 12.0 / 1.886 | 0.0 / 0.0 | 416.0 / 3.307 |
| mam | 32.0 / 20.297 | 32.0 / 20.297 | 0.0 / 0.0 | 416.0 / 34.153 |
| ponder | 32.0 / 17.527 | 32.0 / 17.527 | 0.0 / 0.0 | 416.0 / 29.214 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26337.574 (48129.417) | 45.278 | 1.0 | 114684 / 190188 | 100928 (2097152.0) | 8 / 5 | 0.0 / 0 |
| factory_flat | 26338.117 (48130.621) | 45.278 | 1.0 | 6844 / 6844 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| sift | 147756.175 (205061.63) | 27.945 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 308 / 300 | 0.0 / 0 |
| hub | 33694.821 (59330.051) | 43.208 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 8 / 14 | 0.0 / 0 |
| mam | 66931.443 (117619.355) | 43.095 | 1.011 | 42708 / 304832 | 0 (2097152.0) | 6 / 8 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 2 / 5 | 0.0 / 0 |
| hologram | 3910.528 (6871.472) | 43.09 | 1.0 | 46296 / 45512 | 0 (2097152.0) | 3 / 6 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.126 | 16 (vanilla 28) | 96100 | 23.773 / 0.237 | 1.511 / 28.0 | 2.566 | 1907 / 0 | 4.96 (9.783) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.124 | 16 (vanilla 28) | 96100 | 1.156 / 0.004 | 1.511 / 12.0 | 2.566 | 162 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 430.393 | 16 (vanilla 28) | 462656 | 22.062 / 0.277 | 7.39 / 16.0 | 12.354 | 2919 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.084 | 16 (vanilla 28) | 118460 | 21.496 / 0.269 | 1.886 / 12.0 | 3.163 | 2996 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.148 | 16 (vanilla 28) | 1192928 | 22.462 / 0.306 | 20.297 / 32.0 | 31.855 | 3647 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1017724 | 22.462 / 0.306 | 17.527 / 32.0 | 27.176 | 3648 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 13.022 | 16 (vanilla 28) | 13744 | 22.288 / 0.302 | 0.238 / 32.0 | 0.367 | 3712 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 21.909 / 0.297 | 0.171 / 32.0 | 0.283 | 3813 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1854 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 593 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 590 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.003 (0.042; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.062; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.518 / 0.0 | 0.518 / 0.555 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.095 / 10.051 | 0.018 / 0.006 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.96 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.608 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 95.663 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 94.04 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 151.087 / 93.072 | 0.137 / 0.054 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.88 | 0.0 / 0.0 | 574.26 / 574.41 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| mam | 13.83 / 13.83 | 1.0 / 1.0 | 112.01 / 111.81 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.83 / 13.83 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.0 / 0.0 | 203.64 / 203.75 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 20.2 (base 20.24) | 13 (base 13) | 49132 (base 49024) | 361.02 (base 361.53) | 3.73 (base 5.48) |
| factory_flat | 19.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 359.42 (base 360.27) | 3.48 (base 5.48) |
| sift | 40.94 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 378.26 (base 379.69) | 3.73 (base 4.24) |
| hub | 25.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 390.58 (base 392.07) | 3.73 (base 5.99) |
| mam | 24.53 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 404.36 (base 404.98) | 7.73 (base 7.73) |
| ponder | 87.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 403.04 (base 403.64) | 7.73 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43336 (base 43652) | 391.75 (base 392.54) | 7.54 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 392.75 (base 393.74) | 7.54 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 20.2 / 20 (29.98) | 179.96 / 226 (29.79) | median and average, x 1.10 + 2 |
| factory_flat | 19.67 / 20 (30.01) | 179.24 / 226 (29.91) | median and average, x 1.10 + 2 |
| sift | 40.94 / 41 (19.75) | 579.0 / 579 (14.98) | median, x 1.10 + 2 |
| hub | 25.54 / 25 (29.81) | 161.8 / 208 (29.99) | median and average, x 1.10 + 2 |
| mam | 24.53 / 24 (29.84) | 200.73 / 246 (29.52) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (30.01) | 180.73 / 227 (29.81) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.94) | 128.16 / 175 (29.95) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 111.0 / 158 (29.98) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.633 | 12.0 / 1.633 | 0.0 / 0.0 | 416.0 / 2.922 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.894 |
| hub | 12.0 / 1.886 | 12.0 / 1.886 | 0.0 / 0.0 | 416.0 / 3.307 |
| mam | 32.0 / 20.272 | 32.0 / 20.272 | 0.0 / 0.0 | 416.0 / 34.148 |
| ponder | 32.0 / 17.508 | 32.0 / 17.508 | 0.0 / 0.0 | 416.0 / 29.215 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26336.623 (48127.683) | 45.278 | 1.0 | 156752 / 233360 | 100928 (2097152.0) | 1 / 3 | 0.0 / 0 |
| factory_flat | 26337.896 (48130.217) | 45.278 | 1.0 | 48916 / 50020 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| sift | 145839.213 (204916.777) | 28.83 | 1.434 | 4148 / 8052 | 0 (2097152.0) | 179 / 299 | 0.0 / 0 |
| hub | 33694.345 (59329.213) | 43.208 | 1.02 | 83908 / 84516 | 0 (2097152.0) | 3 / 0 | 0.0 / 0 |
| mam | 67084.181 (117971.276) | 43.135 | 1.011 | 40068 / 40948 | 0 (2097152.0) | 3 / 6 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 0 / 3 | 0.0 / 0 |
| hologram | 3910.528 (6871.472) | 43.09 | 1.0 | 45444 / 45252 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 8.013 | 74.123 | 16 (vanilla 28) | 96100 | 26.067 / 0.317 | 1.511 / 28.0 | 2.566 | 1684 / 0 | 3.037 (2.859) |
| factory_flat | plain, one multi-draw per region and layer | 8.013 | 74.124 | 16 (vanilla 28) | 103664 | 1.114 / 0.004 | 1.633 / 12.0 | 2.768 | 174 / 0 | None (None) |
| sift | plain, one multi-draw per region and layer | 21.053 | 430.089 | 16 (vanilla 28) | 462656 | 23.783 / 0.343 | 7.39 / 16.0 | 12.354 | 2692 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 7.012 | 50.084 | 16 (vanilla 28) | 118460 | 23.162 / 0.333 | 1.886 / 12.0 | 3.163 | 2767 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 5.008 | 87.146 | 16 (vanilla 28) | 1191972 | 23.823 / 0.361 | 20.272 / 32.0 | 31.829 | 3419 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1017104 | 23.823 / 0.361 | 17.508 / 32.0 | 27.16 | 3420 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 3.005 | 13.022 | 16 (vanilla 28) | 13744 | 23.62 / 0.356 | 0.238 / 32.0 | 0.367 | 3484 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.168 / 0.349 | 0.171 / 32.0 | 0.283 | 3592 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2370 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.725 / 0.0 | 0.57 / 0.538 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.269 / 10.09 | 0.015 / 0.006 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 9.949 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.203 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.49 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 154.113 / 94.326 | 0.115 / 0.041 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.88 | 0.0 / 0.0 | 574.55 / 574.87 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| mam | 13.87 / 13.86 | 1.0 / 1.0 | 113.1 / 112.83 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.86 (8.0 / 8.0) |
| ponder | 82.58 / 82.57 | 0.0 / 0.11 | 203.73 / 203.8 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 14.19 (base 14.25) | 15 (base 15) | 51616 (base 51624) | 360.67 (base 360.8) | 4.23 (base 5.46) |
| factory_flat | 13.67 (reported, not gated) | 15 (base 15) | 51500 (base 51500) | 358.77 (base 359.9) | 5.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 377.79 (base 379.18) | 4.23 (base 5.46) |
| hub | 21.54 (base 21.57) | 16 (base 16) | 66576 (base 66576) | 390.51 (base 391.05) | 4.23 (base 5.46) |
| mam | 22.53 (base 22.55) | 19 (base 19) | 23748 (base 23748) | 403.87 (base 404.61) | 8.23 (base 7.71) |
| ponder | 87.23 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 402.33 (base 403.47) | 8.23 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 394.77 (base 395.99) | 8.04 (base 8.29) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 14.19 / 14 (29.92) | 107.71 / 154 (29.85) | median and average, x 1.10 + 2 |
| factory_flat | 13.67 / 14 (30.0) | 107.08 / 154 (29.95) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (17.78) | 143.96 / 153 (21.07) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.86) | 114.87 / 161 (29.96) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.75) | 116.17 / 162 (29.87) | median, x 1.10 + 2 |
| ponder | 87.23 / 87 (30.0) | 180.58 / 227 (30.01) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (30.0) | 99.92 / 147 (30.0) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.894 |
| hub | 12.0 / 1.886 | 12.0 / 1.886 | 0.0 / 0.0 | 416.0 / 3.307 |
| mam | 32.0 / 20.205 | 32.0 / 20.205 | 0.0 / 0.0 | 416.0 / 34.112 |
| ponder | 32.0 / 17.441 | 32.0 / 17.441 | 0.0 / 0.0 | 416.0 / 29.174 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26336.773 (48127.957) | 45.278 | 1.0 | 159252 / 234840 | 100928 (2097152.0) | 2 / 3 | 0.0 / 0 |
| factory_flat | 26337.896 (48130.217) | 45.278 | 1.0 | 51500 / 51500 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| sift | 147692.868 (204973.769) | 27.945 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 355 / 45 | 0.0 / 0 |
| hub | 33694.251 (59329.047) | 43.208 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| mam | 67090.568 (117981.956) | 43.135 | 1.011 | 42708 / 42688 | 0 (2097152.0) | 17 / 11 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61224 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.124 | 16 (vanilla 28) | 96100 | 24.451 / 0.284 | 1.511 / 28.0 | 2.566 | 2107 / 0 | 2.58 (2.89) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.124 | 16 (vanilla 28) | 96100 | 1.156 / 0.004 | 1.511 / 12.0 | 2.566 | 162 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.008 | 430.208 | 16 (vanilla 28) | 462656 | 22.703 / 0.314 | 7.39 / 16.0 | 12.354 | 3116 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.084 | 16 (vanilla 28) | 118460 | 22.077 / 0.304 | 1.886 / 12.0 | 3.163 | 3199 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.146 | 16 (vanilla 28) | 1188132 | 22.866 / 0.335 | 20.205 / 32.0 | 31.727 | 3846 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1013264 | 22.866 / 0.335 | 17.441 / 32.0 | 27.057 | 3847 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.479 / 0.329 | 0.171 / 32.0 | 0.283 | 3951 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2136 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 596 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.49 / 0.0 | 0.557 / 0.518 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.99 / 9.798 | 0.014 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 131.021 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.71 / 574.48 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.86 | 1.0 / 1.0 | 113.12 / 112.77 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.0 / 0.11 | 203.62 / 203.86 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 9.45 | 121.9 | 188 | 123 | 730384 | [] |
| bench-plain | flythrough | 5.17 | 327.47 | 103 | 123 | 7437300 | [] |
| bench-plain | water_glass | 16.06 | 70.72 | 321 | 124 | 24492 | [] |
| bench-plain | nether | 15.95 | 72.62 | 318 | 121 | 259272 | [] |
| bench-sodium | spawn | 10.71 | 123.93 | 214 | 148 | 8144 | [] |
| bench-sodium | flythrough | 6.69 | 278.27 | 134 | 159 | 267800 | [] |
| bench-sodium | water_glass | 19.59 | 61.29 | 298 | 135 | 9564 | [] |
| bench-sodium | nether | 26.86 | 44.11 | 0 | 129 | 264000 | [] |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-sodium | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-sodium | nether | 3.81 | 3.81 (0) | 3.81 |  |
| core-bench-sodium | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | spawn | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | water_glass | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | nether | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-measure-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-old | water_glass_oit | 5.35 | 5.35 (0) | 5.35 |  |
| core-measure-old | translucent_move_oit | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-vk | spawn | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | water_glass | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | nether | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | mobs | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | outline | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | translucent_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | particles | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | animation | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | animated_items | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | flat_plants | 3.45 | 3.45 (0) | 3.45 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-full | spawn | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | water_glass | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | nether | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-vk | spawn | 3.98 | 3.98 (0) | 3.98 |  |
| core-quicksilver-vk | water_glass | 3.98 | 3.98 (0) | 3.98 |  |
| core-quicksilver-vk | nether | 3.98 | 3.98 (0) | 3.98 |  |
| core-quicksilver-vk | mobs | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | outline | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | occlusion | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | occlusion_move | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | translucent_move | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | particles | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | animation | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | animated_items | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | flat_plants | 3.2 | 3.2 (0) | 3.2 |  |
| core-quicksilver-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-full | factory | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-measure-full | sift | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-measure-full | hub | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-measure-full | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-full | ponder | 5.99 | 5.99 (0) | 5.81 |  |
| siftec-measure-full | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-full | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-old | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-old | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-old | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-old | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-measure-old | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-measure-old | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-measure-old | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-measure-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-vk | factory | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | sift | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | hub | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | mam | 7.71 | 7.71 (0) | 7.71 | between scenes +4.00 |
| siftec-measure-vk | ponder | 7.71 | 7.71 (0) | 7.71 |  |
| siftec-measure-vk | create_ct | 7.52 | 7.52 (0) | 7.52 |  |
| siftec-measure-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-full | factory | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-full | sift | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-full | hub | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-full | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-old | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-old | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-vk | factory | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | sift | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | hub | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | mam | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| siftec-quicksilver-vk | ponder | 8.23 | 8.23 (0) | 8.23 |  |
| siftec-quicksilver-vk | create_ct | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-quicksilver-vk | factory_flat | 5.46 | 5.46 (0) | 5.46 |  |

Rises of 4 MB or more: siftec-measure-old/mam: between scenes +4.00; siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00; siftec-quicksilver-vk/mam: between scenes +4.00

