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
| spawn | 0.0571 | 10.05 | 0.0613 | 0.0598 | 0.3016 |
| flythrough | 0.0002 | 14.95 | 0.0013 | 0.0011 | 0.0012 |
| water_glass | 0.0051 | 6.45 | 0.005 | 0.0043 | 0.0047 |
| nether | 0.0033 | 0.8 | 0.0003 | 0.0003 | 0.0003 |
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
| translucent_move | 0.0003 | 0.3 | 0.0002 | 0.0002 | 0.0 |
| translucent_move.x2404 | 0.0 | 0.3 | 0.0003 | 0.0004 | 0.0004 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0004 | 0.0002 | 0.0003 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.0003 | 0.0002 | 0.0002 |
| translucent_move.low | 0.0007 | 0.3 | 0.0014 | 0.0009 | 0.0012 |
| translucent_move.back | 0.0 | 0.3 | 0.0 | 0.0001 | 0.0 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0 | 0.0 | 0.0 |
| water_glass_oit | 0.0043 | 0.3 | 0.0038 | 0.0031 | 0.0046 |
| translucent_move_oit | 0.0003 | 0.3 | 0.0001 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0003 | 0.0003 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0003 | 0.0003 | 0.0001 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0001 | 0.0003 | 0.0001 |
| translucent_move_oit.low | 0.0005 | 0.3 | 0.0013 | 0.0012 | 0.0012 |
| translucent_move_oit.back | 0.0002 | 0.3 | 0.0001 | 0.0 | 0.0001 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0 | 0.0 | 0.0001 |
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
| spawn | 92.62 | 18057 | 305 (843) | 245 (741) | 302 (819) |
| flythrough | 97.24 | 6020 | 46 (299) | 46 (299) | 50 (299) |
| water_glass | 95.81 | 25508 | 20 (2621) | 21 (2622) | 24 (2738) |
| nether | 99.42 | 905 | 3 (458) | 3 (458) | 3 (470) |
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
| translucent_move | 96.93 | 13 | 2 (78) | 1 (76) | 2 (68) |
| translucent_move.x2404 | 95.93 | 15 | 4 (104) | 3 (103) | 5 (90) |
| translucent_move.x2414 | 95.86 | 13 | 4 (108) | 1 (105) | 5 (102) |
| translucent_move.x2424 | 96.74 | 13 | 3 (80) | 2 (79) | 3 (69) |
| translucent_move.low | 96.11 | 41 | 16 (21) | 13 (18) | 12 (15) |
| translucent_move.back | 96.93 | 13 | 2 (77) | 2 (77) | 3 (69) |
| translucent_move.bare_back | 96.9 | 13 | 1 (76) | 2 (78) | 2 (68) |
| water_glass_oit | 95.81 | 57 | 18 (2619) | 20 (2622) | 16 (2731) |
| translucent_move_oit | 96.93 | 12 | 1 (76) | 2 (77) | 3 (69) |
| translucent_move_oit.x2404 | 95.93 | 16 | 4 (104) | 3 (103) | 5 (89) |
| translucent_move_oit.x2414 | 95.86 | 10 | 3 (106) | 2 (106) | 2 (99) |
| translucent_move_oit.x2424 | 96.74 | 15 | 1 (78) | 2 (79) | 1 (67) |
| translucent_move_oit.low | 96.11 | 40 | 13 (18) | 15 (21) | 15 (18) |
| translucent_move_oit.back | 96.93 | 12 | 1 (76) | 1 (76) | 1 (67) |
| translucent_move_oit.bare_back | 96.9 | 15 | 1 (77) | 3 (78) | 2 (68) |
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
| spawn | 0.0632 / 313 | 0.2189 / 361 | 0.2997 / 269 |
| flythrough | 0.0002 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0049 / 18 | 0.0036 / 16 | 0.0026 / 10 |
| nether | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
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
| translucent_move | 0.0004 / 3 | 0.0004 / 4 | 0.0001 / 1 |
| translucent_move.x2404 | 0.0 / 1 | 0.0001 / 0 | 0.0001 / 1 |
| translucent_move.x2414 | 0.0001 / 2 | 0.0002 / 4 | 0.0 / 1 |
| translucent_move.x2424 | 0.0004 / 2 | 0.0 / 2 | 0.0 / 1 |
| translucent_move.low | 0.0005 / 2 | 0.0002 / 2 | 0.0005 / 2 |
| translucent_move.back | 0.0001 / 2 | 0.0002 / 2 | 0.0001 / 2 |
| translucent_move.bare_back | 0.0 / 2 | 0.0 / 1 | 0.0 / 2 |
| water_glass_oit | 0.0037 / 15 | 0.0029 / 16 | 0.0044 / 23 |
| translucent_move_oit | 0.0001 / 0 | 0.0001 / 0 | 0.0001 / 3 |
| translucent_move_oit.x2404 | 0.0002 / 1 | 0.0002 / 3 | 0.0003 / 2 |
| translucent_move_oit.x2414 | 0.0004 / 3 | 0.0004 / 4 | 0.0002 / 4 |
| translucent_move_oit.x2424 | 0.0002 / 2 | 0.0002 / 2 | 0.0001 / 3 |
| translucent_move_oit.low | 0.0009 / 6 | 0.0001 / 3 | 0.0007 / 5 |
| translucent_move_oit.back | 0.0001 / 0 | 0.0001 / 1 | 0.0003 / 2 |
| translucent_move_oit.bare_back | 0.0 / 1 | 0.0 / 0 | 0.0003 / 1 |
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
| spawn | 14.08 (base 13.6) | 15 (base 14) | 31584 (base 22476) | 252.08 (base 259.07) | 5.99 (base 3.99) |
| flythrough | 13.06 (reported, not gated) | 39 (reported, not gated) | 558840 (reported, not gated) | 307.39 (base 324.25) | 3.48 (base 4.24) |
| water_glass | 9.0 (base 8.97) | 15 (base 15) | 15320 (base 15576) | 236.62 (base 250.02) | 5.99 (base 5.99) |
| nether | 15.73 (base 15.63) | 12 (base 12) | 20660 (base 19648) | 258.34 (base 273.53) | 5.99 (base 5.99) |
| mobs | 19.84 (base 19.77) | 17 (base 17) | 616288 (base 1010948) | 256.85 (base 268.37) | 5.99 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6356 (base 6356) | 256.26 (base 264.69) | 5.99 (base 5.48) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100632 (base 126320) | 261.96 (base 265.1) | 5.99 (base 4.24) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82524 (reported, not gated) | 262.83 (base 265.74) | 5.99 (base 4.24) |
| translucent_move | 8.99 (reported, not gated) | 15 (reported, not gated) | 11116 (reported, not gated) | 264.95 (base 267.48) | 5.99 (base 5.48) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15544 (base 14688) | 235.59 (base 245.02) | 3.35 (base 3.73) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10856 (reported, not gated) | 238.57 (base 247.19) | 3.48 (base 3.73) |
| flat_plants | 18.92 (base 18.29) | 15 (base 15) | 10112 (base 9812) | 239.31 (base 246.92) | 3.6 (base 3.99) |
| renderer_off | 7.67 (base 7.67) | 14 (base 14) | 7352 (base 7164) | 232.33 (base 241.33) | 3.6 (base 4.12) |
| particles | 9.67 (base 9.72) | 15 (base 15) | 9204 (base 17128) | 259.84 (base 261.44) | 5.99 (base 5.99) |
| animation | 49 median (avg 39.94) (base 49) | 15 (base 15) | 2224 (base 2056) | 257.37 (base 260.68) | 5.99 (base 5.99) |
| animated_items | 60 median (avg 46.69) (base 60) | 23 (base 23) | 21976 (base 21940) | 231.91 (base 239.81) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.08 / 14 (9.73) | 124.0 / 124 (11.33) | median and average, x 1.10 + 2 |
| flythrough | 13.06 / 13 (6.84) | 123.06 / 123 (7.87) | median and average, at most vanilla + 2 |
| water_glass | 9.0 / 9 (18.97) | 122.55 / 124 (20.01) | median, at most vanilla |
| nether | 15.73 / 16 (18.4) | 120.53 / 121 (19.48) | median, x 1.10 + 2 |
| mobs | 19.84 / 20 (23.61) | 111.17 / 134 (24.85) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (29.99) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (29.91) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 8.99 / 9 (19.13) | 120.07 / 124 (20.65) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (10.48) | 129.0 / 129 (11.24) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (9.5) | 129.0 / 129 (10.4) | median and average, at most vanilla |
| flat_plants | 18.92 / 19 (19.27) | 122.5 / 124 (20.04) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.76) | 84.98 / 123 (29.76) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.2 / 125 (30.01) | median and average, x 1.10 + 2 |
| animation | 39.94 / 49 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.69 / 60 (30.0) | 155.09 / 190 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 40.0 / 22.988 | 40.0 / 22.988 | 0.0 / 0.0 | 416.0 / 38.482 |
| flythrough | 112.0 / 83.584 | 112.0 / 83.584 | 0.0 / 0.0 | 416.0 / 144.996 |
| water_glass | 40.0 / 12.521 | 40.0 / 12.521 | 0.0 / 0.0 | 416.0 / 21.725 |
| nether | 20.0 / 15.337 | 20.0 / 15.337 | 0.0 / 0.0 | 256.0 / 26.724 |
| mobs | 16.0 / 9.672 | 16.0 / 9.672 | 0.0 / 0.0 | 256.0 / 16.909 |
| outline | 16.0 / 1.346 | 16.0 / 1.346 | 0.0 / 0.0 | 256.0 / 2.362 |
| occlusion | 20.0 / 2.568 | 20.0 / 2.568 | 0.0 / 0.0 | 416.0 / 4.253 |
| occlusion_move | 20.0 / 3.426 | 20.0 / 3.426 | 0.0 / 0.0 | 416.0 / 5.725 |
| translucent_move | 28.0 / 13.067 | 28.0 / 13.067 | 0.0 / 0.0 | 416.0 / 22.32 |
| water_glass_oit | 20.0 / 12.521 | 20.0 / 12.521 | 0.0 / 0.0 | 416.0 / 21.725 |
| translucent_move_oit | 28.0 / 12.711 | 28.0 / 12.711 | 0.0 / 0.0 | 416.0 / 21.698 |
| flat_plants | 24.0 / 13.92 | 24.0 / 13.92 | 0.0 / 0.0 | 416.0 / 24.073 |
| renderer_off | 24.0 / 8.461 | 24.0 / 8.461 | 0.0 / 0.0 | 416.0 / 14.868 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 517567.072 (697349.031) | 25.781 | 1.154 | 736352 / 831176 | 704768 (2097152.0) | 194 / 226 | 0.0 / 0 |
| flythrough | 551021.176 (881314.765) | 37.477 | 1.084 | 2189584 / 7041216 | 2095504 (2097152.0) | 136 / 157 | 7.38 / 67 |
| water_glass | 217103.325 (388951.557) | 44.182 | 1.117 | 16888 / 17144 | 0 (2097152.0) | 379 / 150 | 0.0 / 0 |
| nether | 320287.542 (479488.153) | 33.202 | 1.274 | 212876 / 351392 | 192000 (2097152.0) | 367 / 366 | 0.0 / 0 |
| mobs | 167144.626 (302143.433) | 44.68 | 0.99 | 616288 / 616328 | 0 (2097152.0) | 15 / 7 | 0.0 / 0 |
| outline | 25159.863 (42344.457) | 40.583 | 1.0 | 6356 / 6356 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 45852.421 (80488.147) | 43.032 | 1.197 | 248728 / 126344 | 148096 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50767.355 (89273.773) | 43.133 | 1.223 | 731444 / 1191168 | 654656 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 203452.937 (361320.084) | 43.692 | 1.181 | 767008 / 1333516 | 756096 (2097152.0) | 315 / 76 | 0.0 / 0 |
| water_glass_oit | 217568.038 (389784.115) | 44.182 | 1.117 | 17224 / 16024 | 0 (2097152.0) | 209 / 224 | 0.0 / 0 |
| translucent_move_oit | 203445.095 (360969.179) | 43.639 | 1.18 | 736780 / 1280296 | 725632 (2097152.0) | 190 / 208 | 0.0 / 0 |
| flat_plants | 238269.278 (436460.727) | 45.409 | 1.056 | 272256 / 271712 | 0 (2097152.0) | 365 / 120 | 0.0 / 0 |
| renderer_off | 147767.933 (267196.316) | 44.697 | 1.01 | 7352 / 7312 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.736 (5631.76) | 42.864 | 1.071 | 86832 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79704 / 123000 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.907 (118) | 2.911 (108) | 1.342 | 3.982 (62) | 0 | 913 / 0 | 9.214 / 12.707 | 4.708 / 6.675 |
| flythrough | 5.946 (1561) | 4.914 (1664) | 1.21 | 5.946 (1561) | 0 | 1402 / 0 | 7.278 / 10.423 | 5.063 / 7.37 |
| water_glass | 2.611 (14) | 1.179 (14) | 2.215 | None (0) | 0 | 1221 / 0 | 8.53 / 11.554 | 4.507 / 6.053 |
| nether | 2.399 (31) | 2.056 (19) | 1.167 | 2.024 (16) | 0 | 1841 / 0 | 7.091 / 9.433 | 3.762 / 4.997 |
| mobs | 1.26 (6) | 0.635 (13) | 1.984 | None (0) | 0 | 2074 / 0 | 6.928 / 9.15 | 3.649 / 4.844 |
| outline | 0.593 (13) | 0.579 (12) | 1.024 | None (0) | 0 | 2135 / 0 | 6.828 / 9.002 | 3.586 / 4.747 |
| occlusion | 0.964 (36) | 0.493 (41) | 1.955 | 4.869 (1) | 0 | 2284 / 0 | 6.587 / 8.673 | 3.426 / 4.512 |
| occlusion_move | 1.933 (62) | 1.693 (62) | 1.142 | 5.144 (16) | 0 | 2435 / 0 | 6.34 / 8.331 | 3.281 / 4.207 |
| translucent_move | 3.187 (117) | 3.012 (123) | 1.058 | 5.77 (32) | 0 | 2774 / 0 | 6.072 / 8.027 | 3.267 / 4.184 |
| water_glass_oit | 4.521 (154) | 2.897 (152) | 1.561 | None (0) | 0 | 413 / 0 | 9.717 / 11.968 | 5.117 / 6.422 |
| translucent_move_oit | 4.607 (214) | 3.806 (219) | 1.21 | 7.173 (26) | 0 | 966 / 0 | 6.758 / 8.609 | 3.772 / 4.885 |
| flat_plants | 1.905 (95) | 0.818 (99) | 2.329 | None (0) | 0 | 407 / 0 | 8.109 / 9.045 | 2.934 / 3.856 |
| renderer_off | 0.762 (21) | 0.35 (24) | 2.177 | None (0) | 0 | 322 / 0 | 8.394 / 12.447 | 3.431 / 5.637 |
| particles | 0.872 (30) | 0.182 (24) | 4.791 | None (0) | 0 | 2803 / 0 | 6.018 / 7.953 | 3.209 / 4.133 |
| animation | 1.028 (18) | 0.776 (18) | 1.325 | 1.539 (4) | 0 | 2878 / 0 | 5.889 / 7.779 | 3.073 / 4.008 |
| animated_items | 0.455 (32) | 0.274 (32) | 1.661 | 1.035 (2) | 0 | 2910 / 0 | 5.832 / 7.7 | 3.021 / 3.95 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.015 | 807.139 | 16 (vanilla 28) | 1387920 | 42.648 / 0.099 | 22.988 / 40.0 | 37.061 | 2520 / 0 | 3.982 (7.26) |
| flythrough | indirect, one multi-draw per arena and layer | 3.022 | 901.926 | 16 (vanilla 28) | 5059468 | 15.582 / 1.047 | 83.584 / 112.0 | 135.102 | 6362 / 0 | 5.946 (16.571) |
| water_glass | indirect, one multi-draw per arena and layer | 3.008 | 273.72 | 16 (vanilla 28) | 775856 | 34.613 / 0.091 | 12.521 / 40.0 | 20.718 | 3149 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.005 | 468.272 | 16 (vanilla 28) | 961576 | 29.084 / 0.177 | 15.337 / 20.0 | 25.677 | 4183 / 0 | 2.024 (3.595) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 197.416 | 16 (vanilla 28) | 603012 | 26.475 / 0.155 | 9.672 / 16.0 | 16.102 | 4625 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 44.073 | 16 (vanilla 28) | 84548 | 26.024 / 0.155 | 1.346 / 16.0 | 2.258 | 4724 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 71.119 | 16 (vanilla 28) | 160708 | 24.84 / 0.147 | 2.568 / 20.0 | 4.291 | 4980 / 0 | 4.869 (4.865) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 76.455 | 16 (vanilla 28) | 215288 | 23.5 / 0.139 | 3.426 / 20.0 | 5.749 | 5267 / 0 | 5.144 (12.047) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.008 | 250.521 | 16 (vanilla 28) | 809072 | 20.391 / 0.127 | 13.067 / 28.0 | 21.605 | 6070 / 0 | 5.77 (15.112) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.024 | 282.344 | 16 (vanilla 28) | 775856 | 7.569 / 0.043 | 12.521 / 20.0 | 20.718 | 1088 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.026 | 264.826 | 16 (vanilla 28) | 786524 | 6.743 / 0.109 | 12.711 / 28.0 | 21.002 | 2425 / 0 | 7.173 (17.29) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.008 | 287.745 | 16 (vanilla 28) | 870660 | 6.107 / 0.01 | 13.92 / 24.0 | 23.249 | 950 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 207.348 | 16 (vanilla 28) | 533496 | 2.458 / 0.021 | 8.461 / 24.0 | 14.246 | 602 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 20.331 / 0.126 | 0.131 / 28.0 | 0.225 | 6116 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 20.163 / 0.125 | 0.302 / 28.0 | 0.518 | 6218 / 0 | 1.539 (2.071) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 20.104 / 0.126 | 0.153 / 28.0 | 0.261 | 6267 / 0 | 1.035 (1.691) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 1.0 | 0.0 | 0 | 0 | 55 (0.025 / 0.036 / 0.039; 0) | 0 | 30420 / 0 / 0 |
| flythrough | 187.839 | 1.0 | 0.0 | 0 | 0 | 853 (0.024 / 0.052 / 3.083; 0) | 55 | 25734 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1520 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.012; 0) | 32 | 1198 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.101 / 0.159 / 0.188; 0) | 180 | 2681 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 630 | 0 (None / None / None; 0) | 0 | 840 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 573 | 0 (None / None / None; 0) | 0 | 1337 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1544 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2384 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.043 (0.273; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 434.263 | 1.0 (0.0, 0.0) | 1.635 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.046; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.133 (0.275; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.067 (0.115; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.356 | 10.0 (9.0, 2.362) | 6.0 (6.0, 2.277) | 0.062 (0.25; 0) | 0 | 2779 / 1504806 / 0 / 0 |
| translucent_move | 136.11 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.319 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.007; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.077 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 120.761 / 0.077 | 0.027 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.004 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.832 |
| water_glass | 113.563 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 49.833 / 49.837 | 0.017 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 10.0 | 0.527 / 0.733 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 44.605 / 5.438 | 0.081 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 92.369 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 111.102 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.965 / 14.948 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.873 / 51.876 | 0.011 / 0.018 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.679 / 11.571 | 0.006 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 113.563 / 10.0 | 0.95 / 0.925 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.314 / 2.179 | 0.014 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.539 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.011 / 0.049 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.007 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.426 / 28.028 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.51 / 7.97 / 32.54 | 0 / 0 | 9.0 |

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
| spawn | 50.42 (base 49.0) | 13 (base 13) | 7540 (base 6372) | 251.56 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 67.59 (reported, not gated) | 27 (reported, not gated) | 127772 (reported, not gated) | 309.92 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.73 (base 20.0) | 13 (base 14) | 7336 (base 10264) | 237.37 (base 249.83) | 4.24 (base 5.99) |
| nether | 30.34 (base 33.79) | 10 (base 11) | 4400 (base 10656) | 258.04 (base 272.57) | 4.24 (base 5.99) |
| mobs | 28.67 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 257.16 (base 268.23) | 4.24 (base 5.99) |
| outline | 19.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.83 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 22.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 262.91 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.06 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.32 (base 265.66) | 4.24 (base 5.99) |
| translucent_move | 17.7 (reported, not gated) | 13 (reported, not gated) | 2744 (reported, not gated) | 265.31 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7876 (base 7604) | 236.6 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 239.03 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 30.1 (base 33.0) | 13 (base 13) | 1604 (base 1716) | 238.17 (base 248.11) | 3.35 (base 5.99) |
| renderer_off | 17.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.36 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 260.59 (base 261.4) | 4.24 (base 4.24) |
| animation | 49 median (avg 39.94) (base 49) | 13 (base 13) | 1716 (base 1716) | 257.98 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 46.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 232.75 (base 239.53) | 4.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.42 / 50 (14.35) | 907.0 / 907 (12.82) | median and average, x 1.10 + 2 |
| flythrough | 67.59 / 64 (12.96) | 1028.3 / 1028 (8.11) | median and average, at most vanilla |
| water_glass | 19.73 / 20 (27.12) | 387.69 / 394 (21.17) | median, at most vanilla |
| nether | 30.34 / 34 (29.44) | 581.49 / 586 (20.75) | median, x 1.10 + 2 |
| mobs | 28.67 / 29 (29.66) | 299.67 / 329 (26.72) | median, x 1.10 + 2 |
| outline | 19.67 / 20 (30.0) | 129.27 / 168 (30.0) | median, x 1.10 + 2 |
| occlusion | 22.67 / 23 (29.98) | 161.27 / 200 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 24.06 / 24 (29.96) | 166.62 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 17.7 / 18 (28.26) | 358.95 / 368 (22.09) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (15.32) | 401.0 / 401 (10.67) | median, at most vanilla |
| translucent_move_oit | 25.53 / 26 (14.2) | 386.46 / 388 (10.51) | median and average, at most vanilla |
| flat_plants | 30.1 / 33 (26.67) | 399.6 / 403 (20.49) | median, x 1.10 + 2 |
| renderer_off | 17.67 / 18 (29.99) | 288.59 / 327 (29.91) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (29.99) | 97.27 / 136 (30.01) | median and average, x 1.10 + 2 |
| animation | 39.94 / 49 (30.0) | 156.46 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.73 / 60 (30.0) | 167.22 / 202 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.655 | 36.0 / 22.655 | 0.0 / 0.0 | 416.0 / 39.058 |
| flythrough | 112.0 / 88.21 | 112.0 / 88.21 | 0.0 / 0.0 | 416.0 / 148.423 |
| water_glass | 36.0 / 12.521 | 36.0 / 12.521 | 0.0 / 0.0 | 416.0 / 21.981 |
| nether | 20.0 / 15.254 | 20.0 / 15.254 | 0.0 / 0.0 | 256.0 / 26.732 |
| mobs | 16.0 / 9.672 | 16.0 / 9.672 | 0.0 / 0.0 | 256.0 / 16.909 |
| outline | 16.0 / 1.346 | 16.0 / 1.346 | 0.0 / 0.0 | 256.0 / 2.362 |
| occlusion | 20.0 / 2.486 | 20.0 / 2.486 | 0.0 / 0.0 | 416.0 / 4.388 |
| occlusion_move | 20.0 / 3.331 | 20.0 / 3.331 | 0.0 / 0.0 | 416.0 / 5.718 |
| translucent_move | 28.0 / 12.906 | 28.0 / 12.906 | 0.0 / 0.0 | 416.0 / 22.249 |
| water_glass_oit | 20.0 / 12.521 | 20.0 / 12.521 | 0.0 / 0.0 | 416.0 / 21.725 |
| translucent_move_oit | 28.0 / 12.496 | 28.0 / 12.496 | 0.0 / 0.0 | 416.0 / 21.532 |
| flat_plants | 24.0 / 13.886 | 24.0 / 13.886 | 0.0 / 0.0 | 416.0 / 23.621 |
| renderer_off | 24.0 / 8.461 | 24.0 / 8.461 | 0.0 / 0.0 | 416.0 / 14.868 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 447423.371 (686157.238) | 34.793 | 1.776 | 604484 / 1029444 | 597056 (2097152.0) | 286 / 256 | 0.0 / 0 |
| flythrough | 566384.44 (906301.892) | 37.506 | 1.086 | 2104676 / 7372068 | 2094488 (2097152.0) | 259 / 162 | 5.169 / 80 |
| water_glass | 216930.77 (388642.416) | 44.182 | 1.117 | 9444 / 11460 | 0 (2097152.0) | 6 / 15 | 0.0 / 0 |
| nether | 269871.468 (478981.097) | 43.657 | 1.707 | 144176 / 269364 | 139776 (2097152.0) | 2 / 21 | 0.0 / 0 |
| mobs | 167073.268 (302014.442) | 44.68 | 0.99 | 610676 / 612388 | 0 (2097152.0) | 3 / 2 | 0.0 / 0 |
| outline | 25159.933 (42344.574) | 40.583 | 1.0 | 5012 / 5476 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 44452.14 (77745.957) | 42.824 | 1.214 | 359944 / 124924 | 261888 (2097152.0) | 2 / 0 | 0.0 / 0 |
| occlusion_move | 49288.463 (86355.627) | 42.924 | 1.24 | 695868 / 1105904 | 620800 (2097152.0) | 1 / 1 | 0.0 / 0 |
| translucent_move | 200439.657 (355567.95) | 43.628 | 1.179 | 759092 / 1275316 | 756480 (2097152.0) | 5 / 8 | 0.0 / 0 |
| water_glass_oit | 217239.621 (389195.739) | 44.182 | 1.117 | 9108 / 10644 | 0 (2097152.0) | 306 / 213 | 0.0 / 0 |
| translucent_move_oit | 200430.648 (355334.366) | 43.594 | 1.177 | 730436 / 1275044 | 725632 (2097152.0) | 284 / 210 | 0.0 / 0 |
| flat_plants | 237266.319 (434515.7) | 45.395 | 1.056 | 2276 / 4468 | 0 (2097152.0) | 9 / 38 | 0.0 / 0 |
| renderer_off | 147765.867 (267192.58) | 44.697 | 1.01 | 1380 / 3172 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.736 (5631.76) | 42.864 | 1.071 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79236 / 122900 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.123 (126) | 3.058 (137) | 0.694 | 2.234 (63) | 0 | 881 / 0 | 5.196 / 6.996 | 2.011 / 3.058 |
| flythrough | 3.389 (1771) | 4.849 (1711) | 0.699 | 3.389 (1769) | 0 | 1400 / 0 | 4.047 / 6.114 | 2.165 / 4.019 |
| water_glass | 0.97 (21) | 1.864 (16) | 0.52 | None (0) | 0 | 1199 / 0 | 4.689 / 6.291 | 1.922 / 2.7 |
| nether | 1.554 (16) | 1.836 (23) | 0.846 | 1.399 (11) | 0 | 1826 / 0 | 3.926 / 5.232 | 1.609 / 2.286 |
| mobs | 0.53 (6) | 0.577 (6) | 0.919 | None (0) | 0 | 2056 / 0 | 3.824 / 5.057 | 1.568 / 2.226 |
| outline | 0.28 (13) | 0.32 (13) | 0.875 | None (0) | 0 | 2117 / 0 | 3.762 / 4.981 | 1.547 / 2.206 |
| occlusion | 0.683 (49) | 0.566 (39) | 1.207 | 2.346 (4) | 0 | 2249 / 0 | 3.634 / 4.823 | 1.513 / 2.116 |
| occlusion_move | 1.177 (61) | 1.666 (62) | 0.706 | 3.008 (17) | 0 | 2403 / 0 | 3.473 / 4.62 | 1.466 / 2.037 |
| translucent_move | 1.891 (133) | 3.377 (116) | 0.56 | 3.102 (34) | 0 | 2735 / 0 | 3.325 / 4.47 | 1.471 / 2.056 |
| water_glass_oit | 2.244 (154) | 3.046 (152) | 0.737 | None (0) | 0 | 413 / 0 | 5.448 / 6.76 | 2.566 / 3.923 |
| translucent_move_oit | 2.556 (231) | 3.62 (223) | 0.706 | 2.528 (25) | 0 | 972 / 0 | 3.552 / 4.546 | 1.594 / 2.069 |
| flat_plants | 0.852 (106) | 1.411 (99) | 0.604 | None (0) | 0 | 408 / 0 | 5.039 / 6.206 | 1.657 / 2.065 |
| renderer_off | 0.423 (26) | 0.359 (26) | 1.178 | None (0) | 0 | 327 / 0 | 5.291 / 7.372 | 2.017 / 3.427 |
| particles | 0.232 (24) | 0.215 (30) | 1.079 | None (0) | 0 | 2763 / 0 | 3.296 / 4.429 | 1.453 / 2.031 |
| animation | 0.606 (18) | 0.707 (18) | 0.857 | 0.829 (4) | 0 | 2838 / 0 | 3.226 / 4.333 | 1.413 / 1.976 |
| animated_items | 0.267 (32) | 0.294 (42) | 0.908 | 0.591 (2) | 0 | 2870 / 0 | 3.194 / 4.289 | 1.394 / 1.95 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.136 | 788.748 | 16 (vanilla 28) | 1367812 | 40.61 / 0.091 | 22.655 / 36.0 | 36.525 | 2441 / 0 | 2.234 (4.766) |
| flythrough | plain, one multi-draw per region and layer | 57.71 | 934.139 | 16 (vanilla 28) | 5340032 | 15.312 / 1.007 | 88.21 / 112.0 | 142.594 | 6787 / 0 | 3.389 (10.97) |
| water_glass | plain, one multi-draw per region and layer | 14.026 | 273.503 | 16 (vanilla 28) | 775856 | 33.495 / 0.085 | 12.521 / 36.0 | 20.718 | 3115 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 20.034 | 467.796 | 16 (vanilla 28) | 956364 | 28.22 / 0.165 | 15.254 / 20.0 | 25.538 | 4135 / 0 | 1.399 (2.182) |
| mobs | plain, one multi-draw per region and layer | 11.019 | 197.332 | 16 (vanilla 28) | 603012 | 25.669 / 0.144 | 9.672 / 16.0 | 16.102 | 4573 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 11.018 | 44.073 | 16 (vanilla 28) | 84548 | 25.228 / 0.144 | 1.346 / 16.0 | 2.258 | 4672 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 10.017 | 70.117 | 16 (vanilla 28) | 155252 | 24.089 / 0.137 | 2.486 / 20.0 | 4.146 | 4915 / 0 | 2.346 (3.058) |
| occlusion_move | plain, one multi-draw per region and layer | 11.008 | 75.503 | 16 (vanilla 28) | 208208 | 22.81 / 0.129 | 3.331 / 20.0 | 5.56 | 5205 / 0 | 3.008 (11.094) |
| translucent_move | plain, one multi-draw per region and layer | 12.021 | 248.478 | 16 (vanilla 28) | 797628 | 19.806 / 0.12 | 12.906 / 28.0 | 21.299 | 6015 / 0 | 3.102 (8.986) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.052 | 281.918 | 16 (vanilla 28) | 775856 | 7.556 / 0.043 | 12.521 / 20.0 | 20.718 | 1092 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.585 | 263.211 | 16 (vanilla 28) | 771732 | 6.831 / 0.114 | 12.496 / 28.0 | 20.607 | 2457 / 0 | 2.528 (7.569) |
| flat_plants | plain, one multi-draw per region and layer | 17.032 | 286.537 | 16 (vanilla 28) | 867404 | 6.539 / 0.01 | 13.886 / 24.0 | 23.162 | 973 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 13.022 | 207.345 | 16 (vanilla 28) | 533496 | 2.408 / 0.021 | 8.461 / 24.0 | 14.246 | 616 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 12.02 | 16 (vanilla 28) | 8416 | 19.758 / 0.12 | 0.131 / 28.0 | 0.225 | 6056 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.593 / 0.119 | 0.302 / 28.0 | 0.518 | 6158 / 0 | 0.829 (1.222) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.535 / 0.119 | 0.153 / 28.0 | 0.261 | 6207 / 0 | 0.591 (0.929) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 17.0 | 0.0 | 0 | 0 | 59 (0.068 / 0.032 / 3.044; 0) | 0 | 43911 / 0 / 0 |
| flythrough | 197.181 | 26.542 | 0.0 | 0 | 0 | 924 (0.046 / 0.033 / 17.269; 0) | 63 | 51267 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2176 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 38 (0.008 / 0.009 / 0.01; 0) | 32 | 1202 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.07 / 0.102 / 0.233; 0) | 180 | 3962 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 921 | 0 (None / None / None; 0) | 0 | 1228 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 855 | 0 (None / None / None; 0) | 0 | 1995 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2136 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 343.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.047 (0.114; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 438.919 | 1.0 (0.0, 0.0) | 1.138 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.047; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.109 (0.46; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.061 (0.205; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.371 | 10.0 (9.0, 2.354) | 6.0 (6.0, 2.275) | 0.051 (0.257; 0) | 0 | 2782 / 1505776 / 0 / 0 |
| translucent_move | 135.177 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.628 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.011 (0.165; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.42 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 134.683 / 0.418 | 0.038 / 0.008 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.873 |
| water_glass | 108.747 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.444 / 53.434 | 0.022 / 0.027 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 110.833 / 6.78 | 0.696 / 0.881 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 37.108 / 9.898 | 0.062 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 85.927 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.003 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.003 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 104.048 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.633 / 12.668 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 58.107 / 58.023 | 0.019 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.392 / 12.375 | 0.009 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 111.626 / 7.505 | 1.0 / 0.841 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.589 / 2.455 | 0.019 / 0.012 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.923 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.051 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.009 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 14.0 (base 14.05) | 15 (base 15) | 31584 (base 27764) | 252.82 (base 257.2) | 4.23 (base 3.98) |
| flythrough | 13.06 (reported, not gated) | 44 (reported, not gated) | 1085988 (reported, not gated) | 306.23 (base 318.06) | 3.46 (base 4.23) |
| water_glass | 9.0 (base 9.0) | 15 (base 15) | 15880 (base 15108) | 237.34 (base 244.39) | 4.23 (base 4.23) |
| nether | 15.85 (base 15.71) | 12 (base 12) | 21200 (base 19912) | 258.76 (base 268.95) | 4.23 (base 4.23) |
| mobs | 20.0 (base 19.97) | 17 (base 17) | 616288 (base 1008176) | 257.25 (base 264.31) | 4.23 (base 6.23) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6356 (base 6356) | 257.09 (base 264.58) | 4.23 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100632 (base 126356) | 262.67 (base 264.78) | 4.23 (base 3.98) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82524 (reported, not gated) | 263.49 (base 265.16) | 4.23 (base 4.23) |
| translucent_move | 9.0 (reported, not gated) | 15 (reported, not gated) | 10912 (reported, not gated) | 265.73 (base 268.35) | 4.23 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15544 (base 15024) | 236.11 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 11148 (reported, not gated) | 238.96 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 18.77 (base 18.96) | 15 (base 15) | 10000 (base 9864) | 238.97 (base 248.07) | 3.46 (base 5.98) |
| renderer_off | 7.84 (base 7.83) | 14 (base 14) | 7352 (base 7180) | 232.58 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9204 (base 17128) | 260.7 (base 261.4) | 4.23 (base 5.98) |
| animation | 49 median (avg 39.94) (base 49) | 15 (base 15) | 2224 (base 2056) | 258.15 (base 260.68) | 4.23 (base 5.98) |
| animated_items | 60 median (avg 46.69) (base 60) | 23 (base 23) | 21976 (base 21940) | 232.9 (base 239.74) | 4.23 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.0 / 14 (8.44) | 124.34 / 124 (9.54) | median and average, x 1.10 + 2 |
| flythrough | 13.06 / 13 (5.41) | 123.07 / 123 (5.41) | median and average, at most vanilla + 2 |
| water_glass | 9.0 / 9 (14.95) | 124.0 / 124 (15.21) | median, at most vanilla |
| nether | 15.85 / 16 (14.68) | 120.77 / 121 (15.32) | median, x 1.10 + 2 |
| mobs | 20.0 / 20 (17.88) | 134.0 / 134 (18.7) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (29.98) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (29.72) | 94.4 / 133 (29.94) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (29.62) | 94.66 / 133 (29.83) | median and average, x 1.10 + 2 |
| translucent_move | 9.0 / 9 (15.19) | 124.0 / 124 (15.72) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (7.92) | 129.0 / 129 (8.48) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (7.17) | 129.0 / 129 (7.93) | median and average, at most vanilla |
| flat_plants | 18.77 / 19 (16.1) | 123.95 / 124 (15.85) | median, x 1.10 + 2 |
| renderer_off | 7.84 / 8 (23.67) | 106.15 / 123 (23.43) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.94 / 49 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.69 / 60 (30.0) | 155.22 / 190 (29.98) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.987 | 36.0 / 22.987 | 0.0 / 0.0 | 416.0 / 36.923 |
| flythrough | 112.0 / 84.195 | 112.0 / 84.195 | 0.0 / 0.0 | 416.0 / 142.762 |
| water_glass | 36.0 / 12.521 | 36.0 / 12.521 | 0.0 / 0.0 | 416.0 / 21.725 |
| nether | 20.0 / 15.256 | 20.0 / 15.256 | 0.0 / 0.0 | 256.0 / 26.724 |
| mobs | 16.0 / 9.672 | 16.0 / 9.672 | 0.0 / 0.0 | 256.0 / 16.909 |
| outline | 16.0 / 1.346 | 16.0 / 1.346 | 0.0 / 0.0 | 256.0 / 2.362 |
| occlusion | 20.0 / 2.581 | 20.0 / 2.581 | 0.0 / 0.0 | 416.0 / 4.814 |
| occlusion_move | 20.0 / 3.388 | 20.0 / 3.388 | 0.0 / 0.0 | 416.0 / 6.137 |
| translucent_move | 28.0 / 12.959 | 28.0 / 12.959 | 0.0 / 0.0 | 416.0 / 22.712 |
| water_glass_oit | 20.0 / 12.521 | 20.0 / 12.521 | 0.0 / 0.0 | 416.0 / 21.725 |
| translucent_move_oit | 28.0 / 12.603 | 28.0 / 12.603 | 0.0 / 0.0 | 416.0 / 22.077 |
| flat_plants | 24.0 / 13.81 | 24.0 / 13.81 | 0.0 / 0.0 | 416.0 / 24.253 |
| renderer_off | 24.0 / 8.461 | 24.0 / 8.461 | 0.0 / 0.0 | 416.0 / 14.868 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 517787.833 (697717.429) | 25.788 | 1.154 | 655200 / 533768 | 623616 (2097152.0) | 168 / 190 | 0.0 / 0 |
| flythrough | 544148.056 (871748.222) | 37.58 | 1.083 | 2123788 / 7534192 | 2094984 (2097152.0) | 108 / 108 | 6.917 / 62 |
| water_glass | 217256.187 (389225.418) | 44.182 | 1.117 | 17672 / 16584 | 0 (2097152.0) | 299 / 304 | 0.0 / 0 |
| nether | 320485.283 (479795.154) | 33.204 | 1.274 | 281448 / 386236 | 259456 (2097152.0) | 293 / 306 | 0.0 / 0 |
| mobs | 167259.204 (302350.555) | 44.68 | 0.99 | 616288 / 616328 | 0 (2097152.0) | 357 / 374 | 0.0 / 0 |
| outline | 25159.933 (42344.574) | 40.583 | 1.0 | 6356 / 6356 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 45979.146 (80741.472) | 43.054 | 1.197 | 152984 / 505276 | 52352 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_move | 50523.831 (88823.926) | 43.119 | 1.223 | 650320 / 1098468 | 573440 (2097152.0) | 3 / 0 | 0.0 / 0 |
| translucent_move | 201460.812 (357497.815) | 43.647 | 1.182 | 766428 / 1332992 | 756224 (2097152.0) | 303 / 314 | 0.0 / 0 |
| water_glass_oit | 217902.456 (390383.241) | 44.182 | 1.117 | 17000 / 16584 | 0 (2097152.0) | 158 / 169 | 0.0 / 0 |
| translucent_move_oit | 201598.685 (357394.056) | 43.592 | 1.18 | 737192 / 1280780 | 725632 (2097152.0) | 143 / 158 | 0.0 / 0 |
| flat_plants | 236311.888 (432547.315) | 45.367 | 1.056 | 10336 / 9996 | 0 (2097152.0) | 321 / 317 | 0.0 / 0 |
| renderer_off | 147831.882 (267311.949) | 44.697 | 1.01 | 7352 / 7312 | 0 (2097152.0) | 7 / 7 | 0.0 / 0 |
| particles | 1927.207 (4215.013) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.736 (5631.76) | 42.864 | 1.071 | 86832 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79704 / 123068 | 57728 (2097152.0) | 1 / 2 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.218 (105) | 3.125 (96) | 1.03 | 3.249 (53) | 0 | 887 / 0 | 9.342 / 12.738 | 5.009 / 7.002 |
| flythrough | 5.809 (1508) | 6.381 (1526) | 0.91 | 5.81 (1507) | 0 | 1398 / 0 | 7.061 / 10.15 | 4.848 / 6.802 |
| water_glass | 1.788 (16) | 2.076 (14) | 0.861 | None (0) | 0 | 1207 / 0 | 8.585 / 11.331 | 4.68 / 6.219 |
| nether | 2.534 (35) | 2.162 (21) | 1.172 | 2.367 (21) | 0 | 1822 / 0 | 7.131 / 9.357 | 3.925 / 5.228 |
| mobs | 1.121 (6) | 1.506 (6) | 0.744 | None (0) | 0 | 2053 / 0 | 6.969 / 9.077 | 3.741 / 4.987 |
| outline | 0.491 (13) | 0.235 (12) | 2.089 | None (0) | 0 | 2114 / 0 | 6.872 / 8.942 | 3.638 / 4.917 |
| occlusion | 1.001 (43) | 0.916 (49) | 1.093 | 2.083 (2) | 0 | 2239 / 0 | 6.686 / 8.69 | 3.537 / 4.793 |
| occlusion_move | 1.932 (64) | 1.723 (70) | 1.121 | 4.044 (19) | 0 | 2383 / 0 | 6.422 / 8.35 | 3.368 / 4.526 |
| translucent_move | 2.992 (105) | 2.903 (118) | 1.031 | 3.83 (34) | 0 | 2705 / 0 | 6.136 / 8.007 | 3.304 / 4.434 |
| water_glass_oit | 3.705 (152) | 2.907 (150) | 1.275 | None (0) | 0 | 413 / 0 | 9.582 / 11.82 | 5.397 / 6.36 |
| translucent_move_oit | 5.145 (205) | 5.262 (211) | 0.978 | 4.693 (26) | 0 | 961 / 0 | 6.296 / 7.949 | 3.502 / 4.518 |
| flat_plants | 2.755 (80) | 1.685 (87) | 1.635 | None (0) | 0 | 401 / 0 | 8.005 / 10.046 | 3.024 / 4.358 |
| renderer_off | 0.564 (23) | 0.487 (21) | 1.158 | None (0) | 0 | 320 / 0 | 9.475 / 12.406 | 5.203 / 6.271 |
| particles | 0.482 (24) | 0.279 (30) | 1.728 | None (0) | 0 | 2733 / 0 | 6.082 / 7.933 | 3.237 / 4.378 |
| animation | 1.344 (18) | 0.936 (18) | 1.436 | 1.575 (4) | 0 | 2808 / 0 | 5.949 / 7.759 | 3.088 / 4.242 |
| animated_items | 0.476 (38) | 0.331 (32) | 1.438 | 1.678 (2) | 0 | 2840 / 0 | 5.891 / 7.681 | 3.041 / 4.176 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.018 | 807.78 | 16 (vanilla 28) | 1387512 | 39.386 / 0.08 | 22.987 / 36.0 | 37.051 | 2412 / 0 | 3.249 (5.425) |
| flythrough | indirect, one multi-draw per arena and layer | 3.028 | 884.676 | 16 (vanilla 28) | 5098956 | 15.678 / 1.022 | 84.195 / 112.0 | 136.157 | 6250 / 0 | 5.81 (17.222) |
| water_glass | indirect, one multi-draw per arena and layer | 3.01 | 273.913 | 16 (vanilla 28) | 775856 | 32.117 / 0.07 | 12.521 / 36.0 | 20.718 | 3075 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.007 | 468.601 | 16 (vanilla 28) | 956412 | 27.074 / 0.158 | 15.256 / 20.0 | 25.539 | 4107 / 0 | 2.367 (3.981) |
| mobs | indirect, one multi-draw per arena and layer | 2.006 | 197.552 | 16 (vanilla 28) | 603012 | 24.628 / 0.138 | 9.672 / 16.0 | 16.102 | 4547 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 44.073 | 16 (vanilla 28) | 84548 | 24.201 / 0.137 | 1.346 / 16.0 | 2.258 | 4646 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 71.119 | 16 (vanilla 28) | 161212 | 23.22 / 0.131 | 2.581 / 20.0 | 4.305 | 4867 / 0 | 2.083 (2.463) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 76.413 | 16 (vanilla 28) | 212080 | 22.043 / 0.124 | 3.388 / 20.0 | 5.663 | 5143 / 0 | 4.044 (9.101) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.01 | 249.624 | 16 (vanilla 28) | 801200 | 19.202 / 0.114 | 12.959 / 28.0 | 21.394 | 5899 / 0 | 3.83 (7.908) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.032 | 282.778 | 16 (vanilla 28) | 775856 | 7.526 / 0.041 | 12.521 / 20.0 | 20.718 | 1084 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.035 | 264.65 | 16 (vanilla 28) | 778660 | 6.788 / 0.11 | 12.603 / 28.0 | 20.792 | 2396 / 0 | 4.693 (12.153) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.009 | 287.894 | 16 (vanilla 28) | 862408 | 5.736 / 0.01 | 13.81 / 24.0 | 23.029 | 911 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.006 | 207.438 | 16 (vanilla 28) | 533496 | 2.475 / 0.021 | 8.461 / 24.0 | 14.246 | 599 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 19.156 / 0.114 | 0.131 / 28.0 | 0.225 | 5940 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 18.992 / 0.113 | 0.302 / 28.0 | 0.518 | 6042 / 0 | 1.575 (2.291) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 18.94 / 0.113 | 0.153 / 28.0 | 0.261 | 6089 / 0 | 1.678 (2.708) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 1.0 | 0.0 | 0 | 0 | 41 (0.028 / 0.043 / 0.055; 0) | 0 | 26364 / 0 / 0 |
| flythrough | 183.853 | 1.0 | 0.0 | 0 | 0 | 829 (0.031 / 0.054 / 6.045; 0) | 42 | 20040 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1192 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.01 / 0.015; 0) | 32 | 1188 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.11 / 0.177 / 0.208; 0) | 180 | 2128 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 477 | 0 (None / None / None; 0) | 0 | 636 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 432 | 0 (None / None / None; 0) | 0 | 1008 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1288 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1896 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.041 (0.151; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 432.174 | 1.0 (0.0, 0.0) | 1.853 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.118 (0.229; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.066 (0.138; 0) | 0 | 3576 / 1618736 / 0 / 0 |
| occlusion_move | 51.347 | 10.0 (9.0, 2.342) | 6.0 (6.0, 2.278) | 0.06 (0.334; 0) | 0 | 2744 / 1483382 / 0 / 0 |
| translucent_move | 135.099 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.792 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.05; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.342 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 133.569 / 0.0 | 0.029 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.194 / 0.0 | 0.011 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.817 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.49 / 53.517 | 0.014 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 10.0 | 0.775 / 0.85 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 40.863 / 7.884 | 0.067 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.988 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.005 / 12.984 | 0.004 / 0.01 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.582 / 51.547 | 0.01 / 0.017 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.224 / 14.118 | 0.005 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 10.0 | 0.953 / 0.769 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.598 / 1.512 | 0.01 / 0.007 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 98.291 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.046 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.009 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.028 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.51 / 7.97 / 32.54 | 0 / 0 | 9.0 |

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
siftec/quicksilver-full: bench factory_flat: median meshing time 0.548 ms per section against vanilla's compiler 0.508 ms (1.079x; limit 0.559 ms; 564 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench factory_flat: median meshing time 0.555 ms per section against vanilla's compiler 0.559 ms (0.993x; limit 0.615 ms; 570 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.662 ms per section against vanilla's compiler 0.411 ms (1.611x; limit 0.452 ms; 564 pairs): reported, not gated (open gap)

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
| factory | 0.0178 | 0.3 | 0.0178 | 0.018 | 0.0 |
| factory_flat | 0.0036 | 0.3 | 0.0036 | 0.0036 | 0.0033 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.004 | 0.55 | 0.0071 | 0.0052 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan |
|---|---|---|---|---|---|
| factory | 95.56 | 500 | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) |
| mam | 87.02 | 10 | 0 (0) | 0 (0) | 0 (8) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 40 (4280) | 34 (4273) | None (None) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0178 / 0 | 0.0 / 0 | 0.0 / 0 |
| factory_flat | 0.0036 / 0 | 0.0036 / 0 | 0.0033 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0029 / 10 | 0.0022 / 13 | skipped |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.19 (base 12.22) | 15 (base 15) | 6864 (base 6976) | 365.12 (base 361.48) | 3.99 (base 5.48) |
| factory_flat | 12.26 (reported, not gated) | 15 (base 15) | 7068 (base 6844) | 361.72 (base 360.51) | 3.35 (base 5.48) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 383.14 (base 379.72) | 3.99 (base 5.87) |
| hub | 21.54 (base 21.53) | 16 (base 16) | 66576 (base 66576) | 396.06 (base 392.33) | 3.99 (base 5.48) |
| mam | 22.53 (base 22.53) | 19 (base 19) | 23748 (base 23748) | 408.87 (base 405.55) | 5.99 (base 8.12) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 407.61 (base 404.14) | 5.99 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 17 (base 17) | 43720 (base 44728) | 395.02 (base 392.95) | 5.81 (base 8.24) |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 395.94 (base 394.1) | 5.81 (base 10.24) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.19 / 12 (29.16) | 108.42 / 152 (28.76) | median and average, x 1.10 + 2 |
| factory_flat | 12.26 / 12 (29.49) | 108.46 / 152 (29.09) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (15.66) | 153.0 / 153 (15.12) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.68) | 119.34 / 161 (27.92) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.86) | 117.38 / 162 (29.48) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.95) | 182.23 / 227 (29.32) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.94) | 117.63 / 164 (29.81) | median, at most vanilla |
| create_ct | 6.67 / 7 (29.99) | 100.0 / 147 (29.99) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.917 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 19.991 | 32.0 / 19.991 | 0.0 / 0.0 | 416.0 / 33.783 |
| ponder | 32.0 / 17.518 | 32.0 / 17.518 | 0.0 / 0.0 | 416.0 / 29.037 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26337.983 (48130.168) | 45.278 | 1.0 | 114684 / 190188 | 100928 (2097152.0) | 9 / 11 | 0.0 / 0 |
| factory_flat | 26337.379 (48129.053) | 45.278 | 1.0 | 114684 / 190188 | 100928 (2097152.0) | 4 / 7 | 0.0 / 0 |
| sift | 147684.332 (204986.824) | 27.954 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 313 / 302 | 0.0 / 0 |
| hub | 33472.351 (58845.066) | 43.118 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 6 / 34 | 0.0 / 0 |
| mam | 66465.332 (116463.081) | 42.93 | 1.011 | 42708 / 304832 | 0 (2097152.0) | 1 / 3 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61248 | 0 (2097152.0) | 1 / 14 | 0.0 / 0 |
| hologram | 3910.528 (6871.472) | 43.09 | 1.0 | 45848 / 45736 | 0 (2097152.0) | 1 / 4 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.479 (35) | 3.887 (35) | 1.152 | 4.912 (12) | 0 | 918 / 0 | 9.473 / 13.728 | 5.581 / 8.085 |
| factory_flat | 5.627 (13) | 2.825 (14) | 1.992 | 5.627 (13) | 0 | 564 / 0 | 2.53 / 2.645 | 0.548 / 0.508 |
| sift | 1.416 (41) | 1.888 (41) | 0.75 | None (0) | 0 | 1461 / 0 | 7.191 / 10.512 | 3.371 / 5.171 |
| hub | 0.407 (8) | 0.313 (8) | 1.3 | None (0) | 0 | 1515 / 0 | 7.078 / 10.347 | 3.286 / 5.067 |
| mam | 0.58 (4) | 0.382 (4) | 1.518 | None (0) | 0 | 1822 / 0 | 7.042 / 10.496 | 3.648 / 6.047 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1823 / 0 | 7.038 / 10.491 | 3.642 / 6.037 |
| hologram | 4.054 (19) | 1.306 (19) | 3.104 | None (0) | 0 | 1856 / 0 | 6.987 / 10.402 | 3.575 / 5.888 |
| create_ct | 0.707 (53) | 0.991 (36) | 0.713 | None (0) | 0 | 1912 / 0 | 6.829 / 10.159 | 3.432 / 5.634 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.127 | 16 (vanilla 28) | 96100 | 21.731 / 0.222 | 1.511 / 28.0 | 2.566 | 1869 / 0 | 4.912 (10.837) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.126 | 16 (vanilla 28) | 96084 | 1.463 / 0.004 | 1.511 / 12.0 | 2.566 | 632 / 0 | 5.627 (13.122) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 430.371 | 16 (vanilla 28) | 462496 | 20.381 / 0.266 | 7.388 / 16.0 | 12.35 | 2878 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.084 | 16 (vanilla 28) | 117492 | 19.786 / 0.258 | 1.879 / 12.0 | 3.137 | 2962 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.146 | 16 (vanilla 28) | 1173104 | 21.122 / 0.3 | 19.991 / 32.0 | 31.325 | 3600 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1016872 | 21.122 / 0.3 | 17.518 / 32.0 | 27.153 | 3601 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 13.022 | 16 (vanilla 28) | 13744 | 20.961 / 0.295 | 0.238 / 32.0 | 0.367 | 3665 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 20.587 / 0.29 | 0.171 / 32.0 | 0.283 | 3769 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1884 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 594 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 597 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 96.174 / 0.0 | 0.555 / 0.509 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.995 / 9.604 | 0.018 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 96.145 / 0.0 | 0.627 / 0.586 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.665 / 11.419 | 0.042 / 0.025 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 97.849 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.839 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 95.009 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.96 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 152.745 / 91.863 | 0.145 / 0.051 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.79 | 0.0 / 0.0 | 574.39 / 572.03 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.79 (8.0 / 8.0) |
| mam | 13.86 / 13.86 | 1.0 / 1.0 | 112.96 / 113.12 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| ponder | 82.58 / 82.54 | 0.11 / 0.11 | 203.64 / 202.85 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.57 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 20.22 (base 20.24) | 13 (base 13) | 49144 (base 49024) | 366.71 (base 361.53) | 5.48 (base 5.48) |
| factory_flat | 20.25 (reported, not gated) | 13 (base 13) | 49132 (base 48916) | 361.82 (base 360.27) | 3.48 (base 5.48) |
| sift | 41.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 385.16 (base 379.69) | 5.48 (base 4.24) |
| hub | 25.56 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.56 (base 392.07) | 5.48 (base 5.99) |
| mam | 24.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.32 (base 404.98) | 5.48 (base 7.73) |
| ponder | 87.22 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 408.77 (base 403.64) | 5.48 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 44120 (base 43652) | 396.51 (base 392.54) | 5.29 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.43 (base 393.74) | 5.29 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 20.22 / 20 (29.37) | 180.59 / 226 (29.31) | median and average, x 1.10 + 2 |
| factory_flat | 20.25 / 20 (29.72) | 179.8 / 226 (29.85) | median and average, x 1.10 + 2 |
| sift | 41.0 / 41 (15.37) | 579.0 / 579 (14.79) | median, x 1.10 + 2 |
| hub | 25.56 / 25 (29.2) | 162.58 / 208 (29.72) | median and average, x 1.10 + 2 |
| mam | 24.54 / 24 (29.75) | 200.57 / 246 (29.73) | median, x 1.10 + 2 |
| ponder | 87.22 / 87 (29.77) | 180.89 / 227 (29.9) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.89) | 128.16 / 175 (29.97) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 111.0 / 158 (30.0) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.521 | 12.0 / 1.521 | 0.0 / 0.0 | 416.0 / 2.769 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.889 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.282 | 32.0 / 20.282 | 0.0 / 0.0 | 416.0 / 33.902 |
| ponder | 32.0 / 17.581 | 32.0 / 17.581 | 0.0 / 0.0 | 416.0 / 29.089 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26337.5 (48129.282) | 45.278 | 1.0 | 156760 / 233360 | 100928 (2097152.0) | 13 / 11 | 0.0 / 0 |
| factory_flat | 26336.906 (48128.172) | 45.278 | 1.0 | 156752 / 233368 | 100928 (2097127.079) | 7 / 3 | 0.0 / 0 |
| sift | 145879.635 (204999.583) | 28.839 | 1.434 | 4148 / 8052 | 0 (2097152.0) | 307 / 295 | 0.0 / 0 |
| hub | 33473.317 (58846.765) | 43.118 | 1.02 | 83908 / 84516 | 0 (2097152.0) | 14 / 5 | 0.0 / 0 |
| mam | 66459.697 (116453.721) | 42.93 | 1.011 | 40068 / 40948 | 0 (2097152.0) | 3 / 3 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61212 / 61228 | 0 (2097152.0) | 4 / 5 | 0.0 / 0 |
| hologram | 3910.539 (6871.491) | 43.09 | 1.0 | 47348 / 45140 | 0 (2097152.0) | 2 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.316 (35) | 4.205 (35) | 1.026 | 3.888 (12) | 0 | 908 / 0 | 10.309 / 13.648 | 7.123 / 9.607 |
| factory_flat | 3.866 (15) | 1.998 (14) | 1.935 | 3.294 (13) | 0 | 570 / 0 | 2.393 / 2.663 | 0.555 / 0.559 |
| sift | 1.632 (41) | 1.841 (40) | 0.886 | None (0) | 0 | 1450 / 0 | 7.646 / 10.317 | 3.766 / 5.977 |
| hub | 0.42 (8) | 0.325 (8) | 1.292 | None (0) | 0 | 1500 / 0 | 7.55 / 10.153 | 3.73 / 5.822 |
| mam | 0.627 (4) | 0.411 (4) | 1.526 | None (0) | 0 | 1813 / 0 | 7.46 / 10.304 | 4.15 / 6.657 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1814 / 0 | 7.456 / 10.298 | 4.149 / 6.647 |
| hologram | 1.495 (19) | 1.93 (19) | 0.775 | None (0) | 0 | 1847 / 0 | 7.384 / 10.2 | 4.036 / 6.545 |
| create_ct | 0.929 (46) | 0.652 (43) | 1.425 | None (0) | 0 | 1903 / 0 | 7.218 / 9.952 | 3.737 / 6.242 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 8.014 | 74.126 | 16 (vanilla 28) | 96100 | 26.808 / 0.36 | 1.511 / 28.0 | 2.566 | 1935 / 0 | 3.888 (9.815) |
| factory_flat | plain, one multi-draw per region and layer | 8.013 | 74.125 | 16 (vanilla 28) | 96652 | 1.498 / 0.004 | 1.521 / 12.0 | 2.581 | 640 / 0 | 3.294 (9.196) |
| sift | plain, one multi-draw per region and layer | 21.068 | 430.397 | 16 (vanilla 28) | 462496 | 24.561 / 0.375 | 7.388 / 16.0 | 12.35 | 2943 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 7.012 | 50.086 | 16 (vanilla 28) | 117492 | 23.934 / 0.365 | 1.879 / 12.0 | 3.137 | 3021 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 5.008 | 87.146 | 16 (vanilla 28) | 1191356 | 24.431 / 0.384 | 20.282 / 32.0 | 31.813 | 3670 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1020632 | 24.431 / 0.384 | 17.581 / 32.0 | 27.254 | 3671 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 3.005 | 13.022 | 16 (vanilla 28) | 13744 | 24.233 / 0.378 | 0.238 / 32.0 | 0.367 | 3735 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.803 / 0.372 | 0.171 / 32.0 | 0.283 | 3841 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1848 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 584 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.369 / 0.0 | 0.549 / 0.549 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.19 / 10.256 | 0.02 / 0.006 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.568 / 0.0 | 0.563 / 0.572 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.581 / 11.64 | 0.029 / 0.015 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.04 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.04 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 168.243 / 102.217 | 0.149 / 0.046 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.88 / 13.87 | 0.0 / 0.0 | 574.7 / 574.54 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.88 / 13.87 (8.0 / 8.0) |
| mam | 13.87 / 13.86 | 1.0 / 1.0 | 113.28 / 112.75 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.86 (8.0 / 8.0) |
| ponder | 82.55 / 82.58 | 0.11 / 0.11 | 203.37 / 203.75 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.58 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 14.21 (base 14.25) | 15 (base 15) | 51716 (base 51624) | 363.68 (base 360.8) | 5.46 (base 5.46) |
| factory_flat | 13.67 (reported, not gated) | 15 (base 15) | 51500 (base 51500) | 360.31 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 382.2 (base 379.18) | 5.46 (base 5.46) |
| hub | 21.54 (base 21.57) | 16 (base 16) | 66576 (base 66576) | 394.75 (base 391.05) | 5.46 (base 5.46) |
| mam | 22.52 (base 22.55) | 19 (base 19) | 23748 (base 23748) | 408.53 (base 404.61) | 5.46 (base 7.71) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 407.16 (base 403.47) | 5.46 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 397.85 (base 395.99) | 5.27 (base 8.29) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 14.21 / 14 (29.97) | 108.72 / 154 (29.33) | median and average, x 1.10 + 2 |
| factory_flat | 13.67 / 14 (29.98) | 109.01 / 154 (29.35) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (17.99) | 153.0 / 153 (13.27) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.95) | 118.48 / 161 (28.11) | median and average, x 1.10 + 2 |
| mam | 22.52 / 22 (29.8) | 122.32 / 162 (27.73) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (30.01) | 181.05 / 227 (29.88) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (30.0) | 99.92 / 147 (30.0) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.889 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.188 | 32.0 / 20.188 | 0.0 / 0.0 | 416.0 / 33.939 |
| ponder | 32.0 / 17.482 | 32.0 / 17.482 | 0.0 / 0.0 | 416.0 / 29.241 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26336.688 (48127.8) | 45.278 | 1.0 | 159336 / 234848 | 100928 (2097152.0) | 0 / 5 | 0.0 / 0 |
| factory_flat | 26337.823 (48130.083) | 45.278 | 1.0 | 51500 / 51500 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| sift | 147624.067 (204903.175) | 27.954 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 359 / 265 | 0.0 / 0 |
| hub | 33471.786 (58844.073) | 43.118 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 1 / 26 | 0.0 / 0 |
| mam | 66304.878 (116098.144) | 42.889 | 1.011 | 42708 / 42688 | 0 (2097152.0) | 18 / 28 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61248 | 0 (2097152.0) | 0 / 3 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.217 (35) | 3.268 (35) | 0.678 | 2.054 (12) | 0 | 815 / 0 | 7.455 / 9.144 | 2.807 / 4.386 |
| factory_flat | None (0) | None (0) | None | None (0) | 0 | 564 / 0 | 2.021 / 1.875 | 0.662 / 0.411 |
| sift | 0.931 (41) | 1.556 (40) | 0.598 | None (0) | 0 | 1360 / 0 | 5.316 / 6.654 | 1.722 / 2.628 |
| hub | 0.327 (8) | 0.307 (8) | 1.065 | None (0) | 0 | 1415 / 0 | 5.234 / 6.581 | 1.715 / 2.616 |
| mam | 0.449 (4) | 0.466 (4) | 0.964 | None (0) | 0 | 1728 / 0 | 5.353 / 6.915 | 1.965 / 3.123 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1729 / 0 | 5.35 / 6.911 | 1.965 / 3.122 |
| create_ct | 0.555 (60) | 0.964 (46) | 0.576 | None (0) | 0 | 1785 / 0 | 5.23 / 6.756 | 1.869 / 2.925 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.124 | 16 (vanilla 28) | 96100 | 25.46 / 0.3 | 1.511 / 28.0 | 2.566 | 1668 / 0 | 2.054 (2.279) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.123 | 16 (vanilla 28) | 96100 | 1.203 / 0.004 | 1.511 / 12.0 | 2.566 | 606 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.008 | 430.195 | 16 (vanilla 28) | 462496 | 23.279 / 0.33 | 7.388 / 16.0 | 12.35 | 2679 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.083 | 16 (vanilla 28) | 117492 | 22.524 / 0.317 | 1.879 / 12.0 | 3.137 | 2767 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.146 | 16 (vanilla 28) | 1185716 | 23.351 / 0.349 | 20.188 / 32.0 | 31.662 | 3416 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1014656 | 23.35 / 0.349 | 17.482 / 32.0 | 27.094 | 3417 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.897 / 0.342 | 0.171 / 32.0 | 0.283 | 3525 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2160 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.011; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.53 / 0.0 | 0.516 / 0.546 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.06 / 10.047 | 0.016 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 95.324 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 96.98 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 99.712 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.8 | 0.0 / 0.0 | 574.66 / 572.44 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.8 (8.0 / 8.0) |
| mam | 13.85 / 13.89 | 1.0 / 1.0 | 112.58 / 114.03 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.85 / 13.89 (8.0 / 8.0) |
| ponder | 82.58 / 82.58 | 0.11 / 0.0 | 203.7 / 203.77 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 15.18 | 77.76 | 303 | 124 | 1149156 | [] |
| bench-plain | flythrough | 10.33 | 226.21 | 206 | 123 | 7478008 | [] |
| bench-plain | water_glass | 25.81 | 46.74 | 1 | 124 | 16584 | [] |
| bench-plain | nether | 24.72 | 49.6 | 4 | 121 | 353992 | [] |
| bench-sodium | spawn | 10.76 | 109.16 | 215 | 148 | 8144 | [] |
| bench-sodium | flythrough | 6.85 | 309.99 | 137 | 159 | 267800 | [] |
| bench-sodium | water_glass | 20.0 | 58.42 | 132 | 135 | 9228 | [] |
| bench-sodium | nether | 26.07 | 46.4 | 2 | 129 | 263776 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 55.027 (50.0) | 706 / 706 | 1527 | 1 | 40530.177 | 5.115 (0.0) | 1080 |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | flythrough | 5.48 | 5.48 (0) | 5.48 |  |
| core-bench-sodium | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | nether | 4.12 | 4.12 (0) | 4.12 |  |
| core-bench-sodium | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-measure-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | flythrough | 5.48 | 5.48 (0) | 5.48 |  |
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
| core-measure-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
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
| core-quicksilver-full | flat_plants | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-quicksilver-old | flat_plants | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-vk | spawn | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | water_glass | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | nether | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | mobs | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | outline | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | occlusion | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | occlusion_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | translucent_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | particles | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | animation | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | animated_items | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | flythrough | 3.46 | 3.46 (0) | 3.46 |  |
| core-sp-quicksilver | flythrough | 1.31 | 1.39 (218) | 1.39 |  |
| siftec-measure-full | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-measure-full | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-measure-full | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-measure-full | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-measure-full | factory_flat | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-vk | factory | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | sift | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | hub | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | mam | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | ponder | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | create_ct | 5.27 | 5.27 (0) | 5.27 |  |
| siftec-measure-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-full | factory | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-full | sift | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-full | hub | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-full | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | factory_flat | 3.35 | 3.35 (0) | 3.35 |  |
| siftec-quicksilver-old | factory | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | sift | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | hub | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | mam | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | ponder | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | hologram | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-old | create_ct | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-vk | factory | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | sift | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | hub | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | mam | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | ponder | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | create_ct | 5.27 | 5.27 (0) | 5.27 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |

Rises of 4 MB or more: siftec-measure-full/mam: between scenes +4.00; siftec-measure-old/mam: between scenes +4.00

