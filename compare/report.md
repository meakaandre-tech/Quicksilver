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
| spawn | 0.2878 | 10.05 | 0.4379 | 0.1976 | 0.1963 |
| flythrough | 0.0 | 14.95 | 0.0011 | 0.0011 | 0.0012 |
| water_glass | 0.0054 | 6.45 | 0.0058 | 0.0051 | 0.0043 |
| nether | 0.0 | 0.8 | 0.0012 | 0.0003 | 0.0003 |
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
| translucent_move | 0.0001 | 0.3 | 0.0 | 0.0 | 0.0002 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0003 | 0.0002 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0001 | 0.0002 | 0.0003 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.0002 | 0.0001 | 0.0003 |
| translucent_move.low | 0.0008 | 0.3 | 0.0012 | 0.001 | 0.0018 |
| translucent_move.back | 0.0 | 0.3 | 0.0002 | 0.0001 | 0.0 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0003 | 0.0 | 0.0002 |
| water_glass_oit | 0.0043 | 0.3 | 0.0059 | 0.0056 | 0.0046 |
| translucent_move_oit | 0.0001 | 0.3 | 0.0002 | 0.0 | 0.0 |
| translucent_move_oit.x2404 | 0.0002 | 0.3 | 0.0004 | 0.0004 | 0.0007 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.0003 | 0.0002 | 0.0001 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0003 | 0.0002 |
| translucent_move_oit.low | 0.0002 | 0.3 | 0.0011 | 0.0013 | 0.0009 |
| translucent_move_oit.back | 0.0003 | 0.3 | 0.0002 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0 | 0.0001 | 0.0001 |
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
| spawn | 92.62 | 18057 | 308 (828) | 299 (814) | 276 (817) |
| flythrough | 97.3 | 6020 | 47 (302) | 47 (302) | 51 (301) |
| water_glass | 95.8 | 25508 | 26 (2626) | 22 (2623) | 23 (2734) |
| nether | 99.42 | 905 | 11 (466) | 3 (458) | 3 (470) |
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
| translucent_move | 96.93 | 13 | 1 (76) | 2 (77) | 5 (71) |
| translucent_move.x2404 | 95.93 | 15 | 3 (103) | 3 (103) | 4 (89) |
| translucent_move.x2414 | 95.86 | 13 | 2 (105) | 1 (104) | 6 (103) |
| translucent_move.x2424 | 96.74 | 13 | 3 (80) | 1 (78) | 2 (68) |
| translucent_move.low | 96.11 | 41 | 12 (17) | 15 (21) | 16 (21) |
| translucent_move.back | 96.93 | 13 | 5 (80) | 1 (76) | 1 (67) |
| translucent_move.bare_back | 96.9 | 13 | 3 (78) | 1 (76) | 1 (67) |
| water_glass_oit | 95.8 | 57 | 24 (2622) | 32 (2632) | 15 (2728) |
| translucent_move_oit | 96.93 | 12 | 3 (78) | 2 (77) | 4 (70) |
| translucent_move_oit.x2404 | 95.93 | 16 | 3 (103) | 4 (104) | 6 (90) |
| translucent_move_oit.x2414 | 95.86 | 10 | 2 (105) | 3 (106) | 2 (99) |
| translucent_move_oit.x2424 | 96.74 | 15 | 5 (82) | 2 (79) | 1 (67) |
| translucent_move_oit.low | 96.11 | 40 | 16 (22) | 14 (19) | 14 (17) |
| translucent_move_oit.back | 96.93 | 12 | 3 (78) | 2 (78) | 2 (68) |
| translucent_move_oit.bare_back | 96.9 | 15 | 2 (77) | 2 (77) | 2 (68) |
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
| spawn | 0.1949 / 198 | 0.1914 / 247 | 0.1866 / 193 |
| flythrough | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0052 / 21 | 0.0033 / 10 | 0.0044 / 27 |
| nether | 0.0016 / 15 | 0.0 / 0 | 0.0 / 0 |
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
| translucent_move | 0.0001 / 1 | 0.0 / 1 | 0.0002 / 2 |
| translucent_move.x2404 | 0.0002 / 1 | 0.0002 / 2 | 0.0001 / 2 |
| translucent_move.x2414 | 0.0 / 2 | 0.0001 / 1 | 0.0 / 3 |
| translucent_move.x2424 | 0.0001 / 1 | 0.0001 / 2 | 0.0001 / 0 |
| translucent_move.low | 0.0004 / 3 | 0.0003 / 4 | 0.0009 / 4 |
| translucent_move.back | 0.0 / 1 | 0.0002 / 4 | 0.0002 / 2 |
| translucent_move.bare_back | 0.0001 / 2 | 0.0 / 0 | 0.0002 / 0 |
| water_glass_oit | 0.0056 / 25 | 0.0047 / 23 | 0.005 / 20 |
| translucent_move_oit | 0.0001 / 1 | 0.0 / 0 | 0.0002 / 3 |
| translucent_move_oit.x2404 | 0.0002 / 2 | 0.0005 / 2 | 0.0004 / 5 |
| translucent_move_oit.x2414 | 0.0001 / 0 | 0.0005 / 6 | 0.0 / 0 |
| translucent_move_oit.x2424 | 0.0 / 0 | 0.0001 / 0 | 0.0002 / 2 |
| translucent_move_oit.low | 0.0003 / 2 | 0.0004 / 5 | 0.0005 / 5 |
| translucent_move_oit.back | 0.0001 / 0 | 0.0001 / 0 | 0.0001 / 1 |
| translucent_move_oit.bare_back | 0.0002 / 2 | 0.0002 / 4 | 0.0 / 2 |
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
| spawn | 13.42 (base 13.6) | 14 (base 14) | 24176 (base 22476) | 250.67 (base 259.07) | 5.99 (base 3.99) |
| flythrough | 13.07 (reported, not gated) | 22 (reported, not gated) | 142412 (reported, not gated) | 308.95 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 8.68 (base 8.97) | 15 (base 15) | 15564 (base 15576) | 236.92 (base 250.02) | 5.99 (base 5.99) |
| nether | 12.83 (base 15.63) | 12 (base 12) | 21940 (base 19648) | 258.37 (base 273.53) | 5.99 (base 5.99) |
| mobs | 19.67 (base 19.77) | 16 (base 17) | 616144 (base 1010948) | 256.55 (base 268.37) | 5.99 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6316 (base 6356) | 256.41 (base 264.69) | 5.99 (base 5.48) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100652 (base 126320) | 262.06 (base 265.1) | 5.99 (base 4.24) |
| occlusion_move | 16.07 (reported, not gated) | 15 (reported, not gated) | 82544 (reported, not gated) | 262.77 (base 265.74) | 5.99 (base 4.24) |
| translucent_move | 8.69 (reported, not gated) | 15 (reported, not gated) | 10964 (reported, not gated) | 264.52 (base 267.48) | 5.99 (base 5.48) |
| water_glass_oit | 14.01 (base 14.0) | 15 (base 15) | 15656 (base 14688) | 235.72 (base 245.02) | 3.6 (base 3.73) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 11020 (reported, not gated) | 238.27 (base 247.19) | 3.73 (base 3.73) |
| flat_plants | 15.85 (base 18.29) | 15 (base 15) | 10128 (base 9812) | 237.87 (base 246.92) | 3.48 (base 3.99) |
| renderer_off | 7.67 (base 7.67) | 14 (base 14) | 7408 (base 7164) | 231.1 (base 241.33) | 3.35 (base 4.12) |
| particles | 9.67 (base 9.72) | 15 (base 15) | 9204 (base 17128) | 259.64 (base 261.44) | 5.99 (base 5.99) |
| animation | 49 median (avg 39.95) (base 49) | 15 (base 15) | 2224 (base 2056) | 257.18 (base 260.68) | 5.99 (base 5.99) |
| animated_items | 60 median (avg 46.77) (base 60) | 24 (base 23) | 22136 (base 21940) | 232.25 (base 239.81) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.42 / 13 (14.9) | 123.54 / 124 (11.21) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (11.94) | 123.06 / 123 (7.27) | median and average, at most vanilla + 2 |
| water_glass | 8.68 / 9 (29.41) | 124.0 / 124 (19.59) | median, at most vanilla |
| nether | 12.83 / 16 (28.06) | 120.92 / 121 (19.11) | median, x 1.10 + 2 |
| mobs | 19.67 / 20 (29.89) | 112.65 / 134 (24.5) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 87.26 / 126 (30.01) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.33 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.07 / 17 (29.97) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 8.69 / 9 (28.85) | 122.27 / 124 (20.17) | median, at most vanilla |
| water_glass_oit | 14.01 / 14 (15.95) | 129.0 / 129 (11.05) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (14.54) | 129.0 / 129 (10.02) | median and average, at most vanilla |
| flat_plants | 15.85 / 19 (27.94) | 121.86 / 124 (20.08) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.95) | 84.4 / 123 (29.95) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.95 / 49 (30.0) | 144.22 / 179 (30.01) | median, x 1.10 + 2 |
| animated_items | 46.77 / 60 (30.0) | 155.22 / 190 (29.99) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.258 | 36.0 / 22.258 | 0.0 / 0.0 | 416.0 / 38.218 |
| flythrough | 144.0 / 89.035 | 144.0 / 89.035 | 0.0 / 0.0 | 416.0 / 148.754 |
| water_glass | 36.0 / 12.351 | 36.0 / 12.351 | 0.0 / 0.0 | 416.0 / 21.725 |
| nether | 20.0 / 15.252 | 20.0 / 15.252 | 0.0 / 0.0 | 256.0 / 26.737 |
| mobs | 16.0 / 9.563 | 16.0 / 9.563 | 0.0 / 0.0 | 256.0 / 16.764 |
| outline | 16.0 / 1.363 | 16.0 / 1.363 | 0.0 / 0.0 | 256.0 / 2.389 |
| occlusion | 20.0 / 2.57 | 20.0 / 2.57 | 0.0 / 0.0 | 416.0 / 4.484 |
| occlusion_move | 20.0 / 3.573 | 20.0 / 3.573 | 0.0 / 0.0 | 416.0 / 6.081 |
| translucent_move | 28.0 / 12.859 | 28.0 / 12.859 | 0.0 / 0.0 | 416.0 / 22.14 |
| water_glass_oit | 20.0 / 12.351 | 20.0 / 12.351 | 0.0 / 0.0 | 416.0 / 21.461 |
| translucent_move_oit | 28.0 / 12.353 | 28.0 / 12.353 | 0.0 / 0.0 | 416.0 / 21.521 |
| flat_plants | 24.0 / 13.88 | 24.0 / 13.88 | 0.0 / 0.0 | 416.0 / 23.845 |
| renderer_off | 24.0 / 8.513 | 24.0 / 8.513 | 0.0 / 0.0 | 416.0 / 14.847 |
| particles | 28.0 / 0.233 | 28.0 / 0.233 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.404 | 28.0 / 0.404 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.255 | 28.0 / 0.255 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 501088.108 (674512.067) | 25.711 | 1.164 | 815288 / 830476 | 791112 (2097152.0) | 297 / 224 | 0.0 / 0 |
| flythrough | 572711.697 (917814.529) | 37.6 | 1.083 | 2380100 / 7040124 | 2096200 (2097152.0) | 238 / 145 | 4.728 / 53 |
| water_glass | 214764.626 (384254.384) | 44.109 | 1.117 | 17112 / 17984 | 0 (2097152.0) | 1 / 282 | 0.0 / 0 |
| nether | 320517.989 (479600.552) | 33.17 | 1.273 | 230220 / 534888 | 208512 (2097152.0) | 1 / 378 | 0.0 / 0 |
| mobs | 165775.216 (299444.744) | 44.639 | 0.99 | 616144 / 890696 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| outline | 25204.007 (42470.785) | 40.656 | 1.0 | 6316 / 7684 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 44109.516 (77084.474) | 42.778 | 1.211 | 100652 / 397572 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 49694.63 (87229.22) | 43.03 | 1.232 | 795984 / 1311624 | 719104 (2097152.0) | 2 / 0 | 0.0 / 0 |
| translucent_move | 198822.61 (352805.217) | 43.645 | 1.174 | 746280 / 1298104 | 736192 (2097152.0) | 1 / 167 | 0.0 / 0 |
| water_glass_oit | 215076.22 (384810.302) | 44.109 | 1.117 | 24732 / 17480 | 0 (2097152.0) | 318 / 220 | 0.0 / 0 |
| translucent_move_oit | 198632.083 (352250.69) | 43.611 | 1.174 | 745960 / 1297528 | 736192 (2097152.0) | 290 / 200 | 0.0 / 0 |
| flat_plants | 236681.401 (433050.688) | 45.346 | 1.059 | 272160 / 271932 | 0 (2097152.0) | 2 / 127 | 0.0 / 0 |
| renderer_off | 147550.328 (267298.241) | 44.799 | 1.029 | 7408 / 7288 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86740 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79772 / 123000 | 57728 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.17 (97) | 2.703 (98) | 0.803 | 2.14 (54) | 0 | 861 / 0 | 5.542 / 7.492 | 2.233 / 3.429 |
| flythrough | 2.888 (1754) | 5.206 (1659) | 0.555 | 2.888 (1754) | 0 | 1386 / 0 | 3.826 / 5.758 | 2.002 / 3.667 |
| water_glass | 1.041 (20) | 2.201 (22) | 0.473 | None (0) | 0 | 1170 / 0 | 4.9 / 6.575 | 2.08 / 3.027 |
| nether | 1.608 (33) | 2.237 (23) | 0.719 | 1.613 (14) | 0 | 1791 / 0 | 3.941 / 5.323 | 1.656 / 2.358 |
| mobs | 0.769 (6) | 1.712 (8) | 0.449 | None (0) | 0 | 2023 / 0 | 3.809 / 5.122 | 1.615 / 2.293 |
| outline | 0.279 (13) | 0.298 (13) | 0.936 | None (0) | 0 | 2084 / 0 | 3.753 / 5.064 | 1.594 / 2.263 |
| occlusion | 0.73 (55) | 0.838 (46) | 0.871 | None (0) | 0 | 2225 / 0 | 3.647 / 4.914 | 1.565 / 2.194 |
| occlusion_move | 1.208 (71) | 1.545 (64) | 0.782 | 2.379 (18) | 0 | 2379 / 0 | 3.489 / 4.699 | 1.507 / 2.1 |
| translucent_move | 1.649 (115) | 2.716 (124) | 0.607 | 2.441 (34) | 0 | 2707 / 0 | 3.333 / 4.497 | 1.504 / 2.1 |
| water_glass_oit | 2.429 (153) | 2.978 (152) | 0.816 | None (0) | 0 | 414 / 0 | 5.142 / 6.635 | 2.398 / 3.603 |
| translucent_move_oit | 2.153 (231) | 3.569 (216) | 0.603 | 3.477 (25) | 0 | 971 / 0 | 3.487 / 4.706 | 1.563 / 2.245 |
| flat_plants | 0.935 (99) | 1.29 (99) | 0.725 | None (0) | 0 | 413 / 0 | 4.145 / 5.077 | 1.42 / 1.646 |
| renderer_off | 0.275 (22) | 0.384 (22) | 0.716 | None (0) | 0 | 328 / 0 | 5.409 / 8.136 | 1.854 / 2.637 |
| particles | 0.239 (30) | 0.211 (24) | 1.133 | None (0) | 0 | 2734 / 0 | 3.304 / 4.457 | 1.482 / 2.074 |
| animation | 0.577 (18) | 0.848 (18) | 0.68 | 0.82 (4) | 0 | 2809 / 0 | 3.229 / 4.354 | 1.43 / 2.011 |
| animated_items | 0.221 (42) | 0.181 (38) | 1.221 | 0.672 (2) | 0 | 2841 / 0 | 3.197 / 4.31 | 1.4 / 1.975 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.01 | 757.542 | 16 (vanilla 28) | 1344796 | 40.654 / 0.088 | 22.258 / 36.0 | 35.91 | 2322 / 0 | 2.14 (4.768) |
| flythrough | indirect, one multi-draw per arena and layer | 3.013 | 930.324 | 16 (vanilla 28) | 5394848 | 15.372 / 0.996 | 89.035 / 144.0 | 144.058 | 6748 / 0 | 2.888 (8.824) |
| water_glass | indirect, one multi-draw per arena and layer | 3.005 | 273.464 | 16 (vanilla 28) | 767204 | 32.948 / 0.081 | 12.351 / 36.0 | 20.487 | 2967 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 469.835 | 16 (vanilla 28) | 957572 | 27.659 / 0.163 | 15.252 / 20.0 | 25.57 | 4011 / 0 | 1.613 (2.504) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 197.33 | 16 (vanilla 28) | 597888 | 25.162 / 0.143 | 9.563 / 16.0 | 15.965 | 4448 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 42.07 | 16 (vanilla 28) | 84800 | 24.722 / 0.142 | 1.363 / 16.0 | 2.264 | 4543 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 71.119 | 16 (vanilla 28) | 160252 | 23.441 / 0.134 | 2.57 / 20.0 | 4.279 | 4818 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 76.483 | 16 (vanilla 28) | 222756 | 22.041 / 0.126 | 3.573 / 20.0 | 5.948 | 5128 / 0 | 2.379 (7.12) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.005 | 248.657 | 16 (vanilla 28) | 793048 | 19.235 / 0.116 | 12.859 / 28.0 | 21.177 | 5914 / 0 | 2.441 (6.308) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.016 | 281.884 | 16 (vanilla 28) | 767208 | 7.589 / 0.043 | 12.351 / 20.0 | 20.487 | 1084 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.017 | 262.755 | 16 (vanilla 28) | 760900 | 6.919 / 0.116 | 12.353 / 28.0 | 20.318 | 2445 / 0 | 3.477 (9.881) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 286.513 | 16 (vanilla 28) | 864552 | 6.544 / 0.01 | 13.88 / 24.0 | 23.086 | 974 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 205.343 | 16 (vanilla 28) | 533704 | 2.429 / 0.021 | 8.513 / 24.0 | 14.251 | 606 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 14756 | 19.189 / 0.116 | 0.233 / 28.0 | 0.394 | 5956 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 25756 | 19.028 / 0.115 | 0.404 / 28.0 | 0.688 | 6058 / 0 | 0.82 (1.174) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 16104 | 18.971 / 0.115 | 0.255 / 28.0 | 0.43 | 6108 / 0 | 0.672 (1.003) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 1.0 | 0.0 | 0 | 0 | 50 (0.018 / 0.028 / 0.033; 0) | 0 | 45892 / 0 / 0 |
| flythrough | 196.18 | 1.0 | 0.0 | 0 | 0 | 928 (0.01 / 0.031 / 0.076; 0) | 67 | 46887 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2356 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.068 / 0.735 / 0.924; 0) | 32 | 1202 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.071 / 0.103 / 0.414; 0) | 180 | 4046 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 957 | 0 (None / None / None; 0) | 0 | 1276 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 873 | 0 (None / None / None; 0) | 0 | 2037 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2236 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 326.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.072; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.071 | 1.0 (0.0, 0.0) | 1.586 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.075; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.1 (0.203; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.061 (0.18; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.361) | 6.0 (6.0, 2.275) | 0.053 (0.29; 0) | 0 | 2786 / 1508442 / 0 / 0 |
| translucent_move | 135.265 | 1.0 (0.0, 0.0) | 0.782 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.405 | 1.0 (0.0, 0.0) | 0.756 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 154.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.013 (0.075; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.545 / 0.37 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 67.168 / 0.591 | 0.024 / 0.01 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.308 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.866 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.299 / 53.302 | 0.021 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.117 | 0.919 / 0.998 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.474 / 17.373 | 0.074 / 0.015 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 93.834 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 113.288 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.005 / 12.983 | 0.006 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.778 / 53.705 | 0.031 / 0.031 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.3 / 13.203 | 0.008 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 112.993 / 7.151 | 0.888 / 0.989 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.79 / 2.589 | 0.021 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.006 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.003 / 0.038 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.287 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.005 / 0.01 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 49.1 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 252.23 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 66.64 (reported, not gated) | 45 (reported, not gated) | 529796 (reported, not gated) | 307.88 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.98 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 236.7 (base 249.83) | 4.24 (base 5.99) |
| nether | 33.87 (base 33.79) | 10 (base 11) | 4644 (base 10656) | 257.4 (base 272.57) | 4.24 (base 5.99) |
| mobs | 28.86 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 256.25 (base 268.23) | 4.24 (base 5.99) |
| outline | 19.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 255.89 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 22.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 261.65 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.04 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 261.91 (base 265.66) | 4.24 (base 5.99) |
| translucent_move | 17.99 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 264.37 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7540 (base 7604) | 235.81 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.52 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 238.46 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 32.81 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 238.33 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 17.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 231.47 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 259.32 (base 261.4) | 4.24 (base 4.24) |
| animation | 49 median (avg 39.88) (base 49) | 13 (base 13) | 1716 (base 1716) | 256.89 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 46.77) (base 60) | 22 (base 22) | 21668 (base 21668) | 232.22 (base 239.53) | 4.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.1 / 49 (11.17) | 864.04 / 864 (16.45) | median and average, x 1.10 + 2 |
| flythrough | 66.64 / 64 (7.19) | 1039.36 / 1034 (10.73) | median and average, at most vanilla |
| water_glass | 19.98 / 20 (19.99) | 360.08 / 390 (26.8) | median, at most vanilla |
| nether | 33.87 / 34 (17.07) | 561.32 / 588 (25.9) | median, x 1.10 + 2 |
| mobs | 28.86 / 29 (23.17) | 290.98 / 329 (29.72) | median, x 1.10 + 2 |
| outline | 19.67 / 20 (30.0) | 127.2 / 166 (30.01) | median, x 1.10 + 2 |
| occlusion | 22.67 / 23 (29.99) | 162.27 / 201 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 24.04 / 24 (29.91) | 167.6 / 202 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 17.99 / 18 (18.75) | 336.56 / 367 (27.66) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (10.15) | 401.0 / 401 (15.21) | median, at most vanilla |
| translucent_move_oit | 25.52 / 26 (9.13) | 386.62 / 387 (14.2) | median and average, at most vanilla |
| flat_plants | 32.81 / 33 (18.64) | 367.0 / 403 (29.01) | median, x 1.10 + 2 |
| renderer_off | 17.67 / 18 (29.6) | 286.46 / 325 (29.93) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.88 / 49 (30.0) | 156.46 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.77 / 60 (30.0) | 167.46 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.107 | 36.0 / 23.107 | 0.0 / 0.0 | 416.0 / 37.751 |
| flythrough | 112.0 / 84.335 | 112.0 / 84.335 | 0.0 / 0.0 | 416.0 / 152.397 |
| water_glass | 36.0 / 12.351 | 36.0 / 12.351 | 0.0 / 0.0 | 416.0 / 21.461 |
| nether | 20.0 / 15.247 | 20.0 / 15.247 | 0.0 / 0.0 | 256.0 / 26.736 |
| mobs | 16.0 / 9.563 | 16.0 / 9.563 | 0.0 / 0.0 | 256.0 / 16.764 |
| outline | 16.0 / 1.363 | 16.0 / 1.363 | 0.0 / 0.0 | 256.0 / 2.389 |
| occlusion | 20.0 / 2.602 | 20.0 / 2.602 | 0.0 / 0.0 | 416.0 / 4.246 |
| occlusion_move | 20.0 / 3.504 | 20.0 / 3.504 | 0.0 / 0.0 | 416.0 / 5.969 |
| translucent_move | 28.0 / 12.847 | 28.0 / 12.847 | 0.0 / 0.0 | 416.0 / 21.886 |
| water_glass_oit | 20.0 / 12.351 | 20.0 / 12.351 | 0.0 / 0.0 | 416.0 / 21.461 |
| translucent_move_oit | 28.0 / 12.434 | 28.0 / 12.434 | 0.0 / 0.0 | 416.0 / 21.173 |
| flat_plants | 24.0 / 13.764 | 24.0 / 13.764 | 0.0 / 0.0 | 416.0 / 23.984 |
| renderer_off | 24.0 / 8.513 | 24.0 / 8.513 | 0.0 / 0.0 | 416.0 / 14.847 |
| particles | 28.0 / 0.196 | 28.0 / 0.196 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.367 | 28.0 / 0.367 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.218 | 28.0 / 0.218 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 456981.417 (701127.354) | 34.822 | 1.783 | 636004 / 707924 | 634624 (2097152.0) | 223 / 328 | 0.0 / 0 |
| flythrough | 559450.448 (896210.28) | 37.576 | 1.082 | 2108404 / 7298200 | 2093760 (2097152.0) | 143 / 214 | 6.924 / 51 |
| water_glass | 214937.343 (384563.409) | 44.109 | 1.117 | 9668 / 11316 | 0 (2097152.0) | 125 / 11 | 0.0 / 0 |
| nether | 270698.815 (480109.126) | 43.617 | 1.704 | 187600 / 424160 | 183424 (2097152.0) | 341 / 11 | 0.0 / 0 |
| mobs | 165855.447 (299587.663) | 44.639 | 0.99 | 610516 / 886712 | 0 (2097152.0) | 18 / 4 | 0.0 / 0 |
| outline | 25204.007 (42470.785) | 40.656 | 1.0 | 5012 / 5476 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion | 46382.523 (81567.067) | 43.136 | 1.197 | 277860 / 302444 | 179712 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 51487.643 (90747.589) | 43.263 | 1.219 | 764668 / 1361804 | 689600 (2097152.0) | 0 / 1 | 0.0 / 0 |
| translucent_move | 199795.269 (354380.107) | 43.621 | 1.179 | 737876 / 1293060 | 733888 (2097152.0) | 306 / 6 | 0.0 / 0 |
| water_glass_oit | 215461.386 (385501.02) | 44.109 | 1.117 | 9108 / 10980 | 0 (2097152.0) | 202 / 304 | 0.0 / 0 |
| translucent_move_oit | 199852.703 (354159.385) | 43.57 | 1.177 | 740548 / 1292724 | 736192 (2097152.0) | 182 / 284 | 0.0 / 0 |
| flat_plants | 235342.946 (430387.855) | 45.318 | 1.059 | 1940 / 4484 | 0 (2097152.0) | 372 / 5 | 0.0 / 0 |
| renderer_off | 147556.831 (267310.777) | 44.8 | 1.029 | 1380 / 3188 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| particles | 1927.207 (4215.013) | 54.278 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.71 (5631.72) | 42.865 | 1.071 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79396 / 122808 | 57728 (2097149.992) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.765 (114) | 2.098 (107) | 2.271 | 4.925 (60) | 0 | 883 / 0 | 10.502 / 14.842 | 5.838 / 8.05 |
| flythrough | 5.881 (1635) | 3.904 (1705) | 1.506 | 5.881 (1635) | 0 | 1389 / 0 | 8.122 / 10.862 | 5.093 / 7.439 |
| water_glass | 3.136 (18) | 1.051 (18) | 2.984 | None (0) | 0 | 1201 / 0 | 9.444 / 13.058 | 5.226 / 7.509 |
| nether | 2.575 (31) | 1.694 (50) | 1.52 | 2.487 (14) | 0 | 1822 / 0 | 7.612 / 10.49 | 3.703 / 5.823 |
| mobs | 0.95 (6) | 1.081 (8) | 0.879 | None (0) | 0 | 2055 / 0 | 7.351 / 10.011 | 3.572 / 5.621 |
| outline | 0.767 (13) | 0.188 (13) | 4.08 | None (0) | 0 | 2116 / 0 | 7.237 / 9.844 | 3.497 / 5.543 |
| occlusion | 1.068 (38) | 0.477 (48) | 2.239 | 3.645 (2) | 0 | 2250 / 0 | 7.022 / 9.529 | 3.38 / 5.417 |
| occlusion_move | 2.162 (57) | 1.482 (67) | 1.459 | 4.852 (17) | 0 | 2405 / 0 | 6.731 / 9.132 | 3.21 / 4.985 |
| translucent_move | 3.698 (116) | 2.067 (116) | 1.789 | 5.505 (33) | 0 | 2742 / 0 | 6.421 / 8.73 | 3.182 / 4.818 |
| water_glass_oit | 4.294 (154) | 1.969 (152) | 2.181 | None (0) | 0 | 414 / 0 | 10.799 / 13.774 | 5.385 / 7.383 |
| translucent_move_oit | 3.697 (217) | 2.483 (217) | 1.489 | 5.021 (26) | 0 | 965 / 0 | 7.121 / 9.485 | 3.499 / 5.394 |
| flat_plants | 1.86 (89) | 0.82 (90) | 2.268 | None (0) | 0 | 402 / 0 | 7.466 / 8.553 | 3.052 / 3.964 |
| renderer_off | 0.999 (22) | 0.448 (20) | 2.23 | None (0) | 0 | 328 / 0 | 10.141 / 12.886 | 4.962 / 5.858 |
| particles | 0.488 (24) | 0.161 (30) | 3.031 | None (0) | 0 | 2770 / 0 | 6.364 / 8.653 | 3.155 / 4.728 |
| animation | 1.248 (18) | 1.323 (18) | 0.943 | 1.702 (4) | 0 | 2845 / 0 | 6.231 / 8.455 | 3.09 / 4.52 |
| animated_items | 0.358 (38) | 0.143 (42) | 2.503 | 1.167 (2) | 0 | 2877 / 0 | 6.17 / 8.368 | 3.055 / 4.436 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.175 | 803.587 | 16 (vanilla 28) | 1396348 | 40.335 / 0.098 | 23.107 / 36.0 | 37.287 | 2411 / 0 | 4.925 (8.758) |
| flythrough | plain, one multi-draw per region and layer | 56.923 | 904.28 | 16 (vanilla 28) | 5110148 | 15.408 / 1.016 | 84.335 / 112.0 | 136.456 | 6491 / 0 | 5.881 (16.998) |
| water_glass | plain, one multi-draw per region and layer | 14.035 | 273.684 | 16 (vanilla 28) | 767204 | 33.163 / 0.087 | 12.351 / 36.0 | 20.487 | 3079 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 20.059 | 470.375 | 16 (vanilla 28) | 957460 | 27.949 / 0.184 | 15.247 / 20.0 | 25.567 | 4118 / 0 | 2.487 (4.212) |
| mobs | plain, one multi-draw per region and layer | 11.024 | 197.425 | 16 (vanilla 28) | 597884 | 25.45 / 0.161 | 9.563 / 16.0 | 15.965 | 4557 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 11.018 | 42.07 | 16 (vanilla 28) | 84800 | 25.007 / 0.16 | 1.363 / 16.0 | 2.264 | 4652 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 10.017 | 71.118 | 16 (vanilla 28) | 162856 | 23.88 / 0.152 | 2.602 / 20.0 | 4.349 | 4888 / 0 | 3.645 (3.969) |
| occlusion_move | plain, one multi-draw per region and layer | 10.995 | 76.447 | 16 (vanilla 28) | 220164 | 22.557 / 0.144 | 3.504 / 20.0 | 5.879 | 5179 / 0 | 4.852 (15.195) |
| translucent_move | plain, one multi-draw per region and layer | 12.032 | 248.501 | 16 (vanilla 28) | 794236 | 19.594 / 0.13 | 12.847 / 28.0 | 21.208 | 5976 / 0 | 5.505 (18.81) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.079 | 282.391 | 16 (vanilla 28) | 767204 | 7.616 / 0.044 | 12.351 / 20.0 | 20.487 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.61 | 263.137 | 16 (vanilla 28) | 767868 | 6.775 / 0.096 | 12.434 / 28.0 | 20.504 | 2419 / 0 | 5.021 (16.787) |
| flat_plants | plain, one multi-draw per region and layer | 17.046 | 287.772 | 16 (vanilla 28) | 858468 | 5.987 / 0.01 | 13.764 / 24.0 | 22.924 | 928 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 13.022 | 205.346 | 16 (vanilla 28) | 533720 | 2.437 / 0.021 | 8.513 / 24.0 | 14.252 | 608 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 12.02 | 16 (vanilla 28) | 12304 | 19.537 / 0.13 | 0.196 / 28.0 | 0.329 | 6017 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 14.023 | 16 (vanilla 28) | 23304 | 19.372 / 0.129 | 0.367 / 28.0 | 0.622 | 6119 / 0 | 1.702 (2.371) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 13.022 | 16 (vanilla 28) | 13652 | 19.32 / 0.129 | 0.218 / 28.0 | 0.365 | 6166 / 0 | 1.167 (1.713) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 50 (0.028 / 0.05 / 0.08; 0) | 0 | 34944 / 0 / 0 |
| flythrough | 188.882 | 25.896 | 0.0 | 0 | 0 | 867 (0.022 / 0.049 / 4.865; 0) | 44 | 27199 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1600 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.028 / 0.029; 0) | 32 | 1200 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.099 / 0.157 / 0.178; 0) | 180 | 2632 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 609 | 0 (None / None / None; 0) | 0 | 812 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 549 | 0 (None / None / None; 0) | 0 | 1281 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1492 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2372 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 350.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.036 (1.478; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.903 | 1.0 (0.0, 0.0) | 1.618 (0.0, 0.0) | 0.001 (0.011; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.017 (0.062; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.139 (0.249; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.072 (0.114; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.353 | 10.0 (9.0, 2.358) | 6.0 (6.0, 2.278) | 0.063 (0.226; 0) | 0 | 2782 / 1505776 / 0 / 0 |
| translucent_move | 135.098 | 1.0 (0.0, 0.0) | 0.763 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.464 | 1.0 (0.0, 0.0) | 0.738 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 155.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.008; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.591 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.099 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 102.234 / 0.098 | 0.031 / 0.011 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.153 / 0.0 | 0.003 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.833 |
| water_glass | 85.336 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.515 / 54.625 | 0.015 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 88.752 / 10.0 | 0.795 / 0.865 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 46.818 / 10.558 | 0.078 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 82.825 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.207 / 13.146 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.858 / 53.818 | 0.014 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.416 / 12.23 | 0.006 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 79.31 / 10.0 | 1.0 / 0.806 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.005 / 1.895 | 0.013 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.045 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.213 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.796 | 0.003 / 0.009 | 56 (3) | 40.536 / 9.232 / 31.304 | 3 / 0 | 10.978 |
| animated_items | 136.793 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 13.13 (base 14.05) | 14 (base 15) | 25460 (base 27764) | 251.91 (base 257.2) | 4.23 (base 3.98) |
| flythrough | 13.07 (reported, not gated) | 40 (reported, not gated) | 812576 (reported, not gated) | 308.44 (base 318.06) | 3.71 (base 4.23) |
| water_glass | 9.0 (base 9.0) | 15 (base 15) | 15656 (base 15108) | 236.88 (base 244.39) | 4.23 (base 4.23) |
| nether | 15.57 (base 15.71) | 12 (base 12) | 20488 (base 19912) | 257.52 (base 268.95) | 4.23 (base 4.23) |
| mobs | 19.84 (base 19.97) | 17 (base 17) | 616304 (base 1008176) | 256.31 (base 264.31) | 4.23 (base 6.23) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6316 (base 6356) | 256.13 (base 264.58) | 4.23 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100576 (base 126356) | 261.77 (base 264.78) | 4.23 (base 3.98) |
| occlusion_move | 16.07 (reported, not gated) | 15 (reported, not gated) | 82468 (reported, not gated) | 261.98 (base 265.16) | 4.23 (base 4.23) |
| translucent_move | 9.0 (reported, not gated) | 15 (reported, not gated) | 10836 (reported, not gated) | 264.48 (base 268.35) | 4.23 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15544 (base 15024) | 235.41 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10872 (reported, not gated) | 238.2 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 18.8 (base 18.96) | 15 (base 15) | 10184 (base 9864) | 238.47 (base 248.07) | 3.46 (base 5.98) |
| renderer_off | 7.69 (base 7.83) | 14 (base 14) | 7408 (base 7180) | 231.62 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9204 (base 17128) | 259.69 (base 261.4) | 4.23 (base 5.98) |
| animation | 49 median (avg 39.94) (base 49) | 15 (base 15) | 2224 (base 2056) | 256.82 (base 260.68) | 4.23 (base 5.98) |
| animated_items | 60 median (avg 46.73) (base 60) | 23 (base 23) | 21976 (base 21940) | 232.05 (base 239.74) | 4.23 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.13 / 13 (10.08) | 123.23 / 123 (9.53) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (6.58) | 123.06 / 123 (5.44) | median and average, at most vanilla + 2 |
| water_glass | 9.0 / 9 (18.65) | 124.0 / 124 (15.32) | median, at most vanilla |
| nether | 15.57 / 16 (18.09) | 120.9 / 121 (15.46) | median, x 1.10 + 2 |
| mobs | 19.84 / 20 (23.76) | 134.0 / 134 (19.21) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (29.98) | 94.33 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.07 / 17 (29.89) | 94.46 / 133 (29.96) | median and average, x 1.10 + 2 |
| translucent_move | 9.0 / 9 (18.86) | 124.0 / 124 (16.12) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (9.38) | 129.0 / 129 (8.69) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (8.76) | 129.0 / 129 (8.18) | median and average, at most vanilla |
| flat_plants | 18.8 / 19 (19.66) | 124.0 / 124 (15.91) | median, x 1.10 + 2 |
| renderer_off | 7.69 / 8 (29.1) | 105.9 / 123 (23.41) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (29.99) | median and average, x 1.10 + 2 |
| animation | 39.94 / 49 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.73 / 60 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.095 | 36.0 / 23.095 | 0.0 / 0.0 | 416.0 / 38.014 |
| flythrough | 112.0 / 84.974 | 112.0 / 84.974 | 0.0 / 0.0 | 416.0 / 144.215 |
| water_glass | 36.0 / 12.351 | 36.0 / 12.351 | 0.0 / 0.0 | 416.0 / 21.461 |
| nether | 20.0 / 15.249 | 20.0 / 15.249 | 0.0 / 0.0 | 256.0 / 26.736 |
| mobs | 16.0 / 9.563 | 16.0 / 9.563 | 0.0 / 0.0 | 256.0 / 16.764 |
| outline | 16.0 / 1.363 | 16.0 / 1.363 | 0.0 / 0.0 | 256.0 / 2.389 |
| occlusion | 20.0 / 2.533 | 20.0 / 2.533 | 0.0 / 0.0 | 416.0 / 4.243 |
| occlusion_move | 20.0 / 3.438 | 20.0 / 3.438 | 0.0 / 0.0 | 416.0 / 5.97 |
| translucent_move | 28.0 / 12.719 | 28.0 / 12.719 | 0.0 / 0.0 | 416.0 / 21.992 |
| water_glass_oit | 20.0 / 12.351 | 20.0 / 12.351 | 0.0 / 0.0 | 416.0 / 21.461 |
| translucent_move_oit | 28.0 / 12.316 | 28.0 / 12.316 | 0.0 / 0.0 | 416.0 / 21.369 |
| flat_plants | 24.0 / 13.692 | 24.0 / 13.692 | 0.0 / 0.0 | 416.0 / 24.027 |
| renderer_off | 24.0 / 8.513 | 24.0 / 8.513 | 0.0 / 0.0 | 416.0 / 14.847 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 520652.796 (701381.493) | 25.768 | 1.155 | 563148 / 892408 | 537688 (2097152.0) | 201 / 190 | 0.0 / 0 |
| flythrough | 554638.565 (888178.901) | 37.553 | 1.083 | 2120940 / 7275344 | 2094736 (2097152.0) | 131 / 108 | 9.727 / 64 |
| water_glass | 214976.804 (384632.429) | 44.109 | 1.117 | 17336 / 289864 | 0 (2097152.0) | 373 / 306 | 0.0 / 0 |
| nether | 320779.535 (480019.424) | 33.174 | 1.272 | 170072 / 340712 | 149696 (2097152.0) | 361 / 309 | 0.0 / 0 |
| mobs | 165846.417 (299573.356) | 44.639 | 0.99 | 616304 / 616344 | 0 (2097152.0) | 15 / 368 | 0.0 / 0 |
| outline | 25204.007 (42470.785) | 40.656 | 1.0 | 6316 / 6316 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 45349.027 (79517.45) | 42.97 | 1.203 | 474756 / 584500 | 374272 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50490.107 (88753.167) | 43.112 | 1.225 | 771588 / 1362808 | 694784 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 198703.178 (352555.464) | 43.639 | 1.181 | 746732 / 1298328 | 736192 (2097152.0) | 313 / 322 | 0.0 / 0 |
| water_glass_oit | 215548.535 (385655.358) | 44.109 | 1.117 | 17448 / 16696 | 0 (2097152.0) | 187 / 173 | 0.0 / 0 |
| translucent_move_oit | 199006.194 (352827.989) | 43.597 | 1.179 | 746300 / 1297640 | 736192 (2097152.0) | 175 / 163 | 0.0 / 0 |
| flat_plants | 234324.733 (428377.252) | 45.299 | 1.06 | 10408 / 10012 | 0 (2097152.0) | 157 / 318 | 0.0 / 0 |
| renderer_off | 147563.546 (267323.318) | 44.8 | 1.029 | 7408 / 7288 | 0 (2097152.0) | 1 / 11 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.73 (5631.753) | 42.865 | 1.071 | 86832 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79704 / 122908 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.752 (111) | 2.976 (112) | 0.925 | 2.634 (59) | 0 | 845 / 0 | 9.012 / 12.244 | 4.13 / 6.538 |
| flythrough | 5.544 (1643) | 6.241 (1523) | 0.888 | 5.544 (1643) | 0 | 1388 / 0 | 7.153 / 10.226 | 4.685 / 6.877 |
| water_glass | 2.418 (14) | 2.696 (13) | 0.897 | None (0) | 0 | 1167 / 0 | 8.237 / 10.898 | 3.799 / 5.602 |
| nether | 2.71 (23) | 2.459 (25) | 1.102 | 2.27 (6) | 0 | 1785 / 0 | 6.847 / 8.935 | 3.147 / 4.633 |
| mobs | 1.508 (6) | 0.795 (6) | 1.897 | None (0) | 0 | 2016 / 0 | 6.67 / 8.704 | 3.079 / 4.451 |
| outline | 0.681 (13) | 0.398 (13) | 1.711 | None (0) | 0 | 2077 / 0 | 6.572 / 8.574 | 3.025 / 4.421 |
| occlusion | 1.062 (46) | 0.801 (42) | 1.326 | 4.351 (3) | 0 | 2195 / 0 | 6.461 / 8.41 | 2.98 / 4.325 |
| occlusion_move | 1.894 (56) | 1.672 (65) | 1.133 | 4.562 (17) | 0 | 2332 / 0 | 6.211 / 8.088 | 2.852 / 4.148 |
| translucent_move | 2.331 (106) | 2.847 (111) | 0.819 | 3.485 (30) | 0 | 2647 / 0 | 5.931 / 7.853 | 2.843 / 4.156 |
| water_glass_oit | 3.742 (154) | 3.134 (150) | 1.194 | None (0) | 0 | 414 / 0 | 10.416 / 14.542 | 5.498 / 6.78 |
| translucent_move_oit | 3.206 (211) | 3.803 (213) | 0.843 | 3.194 (27) | 0 | 957 / 0 | 6.611 / 9.17 | 3.297 / 4.548 |
| flat_plants | 1.931 (85) | 1.64 (86) | 1.177 | None (0) | 0 | 399 / 0 | 8.68 / 9.557 | 2.685 / 3.444 |
| renderer_off | 0.662 (20) | 0.453 (21) | 1.461 | None (0) | 0 | 328 / 0 | 8.519 / 12.502 | 4.239 / 5.807 |
| particles | 0.443 (30) | 0.271 (24) | 1.635 | None (0) | 0 | 2674 / 0 | 5.877 / 7.78 | 2.811 / 4.106 |
| animation | 0.981 (18) | 1.167 (18) | 0.841 | 1.423 (4) | 0 | 2749 / 0 | 5.743 / 7.594 | 2.673 / 3.961 |
| animated_items | 0.391 (42) | 0.281 (42) | 1.391 | 1.018 (2) | 0 | 2781 / 0 | 5.685 / 7.516 | 2.617 / 3.907 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.015 | 803.98 | 16 (vanilla 28) | 1396120 | 39.926 / 0.105 | 23.095 / 36.0 | 37.28 | 2301 / 0 | 2.634 (4.19) |
| flythrough | indirect, one multi-draw per arena and layer | 3.023 | 894.618 | 16 (vanilla 28) | 5150236 | 15.36 / 0.985 | 84.974 / 112.0 | 137.526 | 6522 / 0 | 5.544 (15.942) |
| water_glass | indirect, one multi-draw per arena and layer | 3.008 | 273.732 | 16 (vanilla 28) | 767208 | 32.47 / 0.092 | 12.351 / 36.0 | 20.487 | 2971 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.006 | 471.302 | 16 (vanilla 28) | 957428 | 27.309 / 0.18 | 15.249 / 20.0 | 25.566 | 3991 / 0 | 2.27 (3.314) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 197.415 | 16 (vanilla 28) | 597888 | 24.81 / 0.157 | 9.563 / 16.0 | 15.965 | 4427 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 42.07 | 16 (vanilla 28) | 84800 | 24.368 / 0.156 | 1.363 / 16.0 | 2.264 | 4522 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 69.115 | 16 (vanilla 28) | 158772 | 23.366 / 0.149 | 2.533 / 20.0 | 4.24 | 4733 / 0 | 4.351 (5.442) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 74.452 | 16 (vanilla 28) | 216308 | 22.212 / 0.142 | 3.438 / 20.0 | 5.776 | 4985 / 0 | 4.562 (10.685) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.008 | 246.576 | 16 (vanilla 28) | 786464 | 19.388 / 0.13 | 12.719 / 28.0 | 21.001 | 5736 / 0 | 3.485 (8.581) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.027 | 282.503 | 16 (vanilla 28) | 767208 | 7.616 / 0.044 | 12.351 / 20.0 | 20.487 | 1086 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.029 | 261.594 | 16 (vanilla 28) | 760664 | 6.686 / 0.093 | 12.316 / 28.0 | 20.312 | 2394 / 0 | 3.194 (6.408) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.008 | 284.723 | 16 (vanilla 28) | 854580 | 5.908 / 0.01 | 13.692 / 24.0 | 22.82 | 913 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 205.353 | 16 (vanilla 28) | 533728 | 2.452 / 0.021 | 8.513 / 24.0 | 14.252 | 605 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 19.339 / 0.13 | 0.131 / 28.0 | 0.225 | 5778 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.17 / 0.129 | 0.302 / 28.0 | 0.518 | 5880 / 0 | 1.423 (2.106) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.11 / 0.129 | 0.153 / 28.0 | 0.261 | 5930 / 0 | 1.018 (1.507) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 1.0 | 0.0 | 0 | 0 | 52 (0.028 / 0.044 / 0.293; 0) | 0 | 31512 / 0 / 0 |
| flythrough | 186.864 | 1.0 | 0.0 | 0 | 0 | 875 (0.015 / 0.043 / 0.114; 0) | 50 | 24666 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1496 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.015 / 0.036 / 0.038; 0) | 32 | 1198 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.114 / 0.189 / 0.616; 0) | 180 | 2646 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 564 | 0 (None / None / None; 0) | 0 | 752 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 528 | 0 (None / None / None; 0) | 0 | 1232 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1576 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2328 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 350.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.075; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 431.455 | 1.0 (0.0, 0.0) | 1.197 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.045; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.116 (0.285; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.069 (0.112; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 50.356 | 10.0 (9.0, 2.362) | 6.0 (6.0, 2.275) | 0.059 (0.317; 0) | 0 | 2778 / 1504186 / 0 / 0 |
| translucent_move | 134.148 | 1.0 (0.0, 0.0) | 0.767 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 134.693 | 1.0 (0.0, 0.0) | 0.75 (0.0, 0.0) | 0.001 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.592 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.226 / 0.134 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 101.82 / 0.139 | 0.022 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.353 / 0.0 | 0.004 / 0.004 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.841 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.641 / 53.62 | 0.025 / 0.017 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 10.0 | 0.9 / 0.568 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 37.808 / 4.831 | 0.067 / 0.006 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.925 / 12.913 | 0.005 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.693 / 53.697 | 0.011 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.005 / 11.943 | 0.003 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 9.898 | 1.0 / 0.913 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.895 / 2.713 | 0.015 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 98.045 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.008 / 0.044 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.003 / 0.008 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.982 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
siftec/quicksilver-full: bench factory_flat: median meshing time 0.572 ms per section against vanilla's compiler 0.561 ms (1.02x; limit 0.617 ms; 564 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench factory_flat: median meshing time 0.295 ms per section against vanilla's compiler 0.281 ms (1.05x; limit 0.309 ms; 572 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.426 ms per section against vanilla's compiler 0.432 ms (0.986x; limit 0.475 ms; 564 pairs): reported, not gated (open gap)

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
| factory | 0.0004 | 0.3 | 0.0004 | 0.0 | 0.0 |
| factory_flat | 0.0036 | 0.3 | 0.0036 | 0.0039 | 0.0035 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0025 | 0.55 | 0.0079 | 0.0063 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan |
|---|---|---|---|---|---|
| factory | 95.6 | 500 | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) |
| mam | 87.02 | 10 | 0 (0) | 0 (0) | 0 (26) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 53 (4295) | 41 (4284) | None (None) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0004 / 0 | 0.0 / 0 | 0.0013 / 6 |
| factory_flat | 0.0036 / 0 | 0.0039 / 0 | 0.0035 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.002 / 5 | 0.002 / 9 | skipped |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.17 (base 12.22) | 15 (base 15) | 6844 (base 6976) | 363.44 (base 361.48) | 3.73 (base 5.48) |
| factory_flat | 12.19 (reported, not gated) | 15 (base 15) | 6956 (base 6844) | 361.5 (base 360.51) | 3.48 (base 5.48) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 381.75 (base 379.72) | 3.73 (base 5.87) |
| hub | 21.54 (base 21.53) | 16 (base 16) | 66576 (base 66576) | 394.13 (base 392.33) | 3.73 (base 5.48) |
| mam | 22.52 (base 22.53) | 19 (base 19) | 23748 (base 23748) | 407.3 (base 405.55) | 7.73 (base 8.12) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 405.87 (base 404.14) | 7.73 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 17 (base 17) | 43272 (base 44728) | 393.14 (base 392.95) | 7.54 (base 8.24) |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 394.12 (base 394.1) | 7.54 (base 10.24) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.17 / 12 (29.31) | 105.6 / 152 (29.89) | median and average, x 1.10 + 2 |
| factory_flat | 12.19 / 12 (29.65) | 105.25 / 152 (29.96) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (16.33) | 136.12 / 153 (22.59) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.7) | 115.02 / 161 (29.92) | median and average, x 1.10 + 2 |
| mam | 22.52 / 22 (29.73) | 115.85 / 162 (29.99) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.75) | 180.97 / 227 (29.85) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.95) | 117.31 / 164 (29.91) | median, at most vanilla |
| create_ct | 6.67 / 7 (29.99) | 99.92 / 147 (30.0) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.088 | 32.0 / 20.088 | 0.0 / 0.0 | 416.0 / 34.186 |
| ponder | 32.0 / 17.346 | 32.0 / 17.346 | 0.0 / 0.0 | 416.0 / 29.268 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26337.689 (48129.635) | 45.278 | 1.0 | 114684 / 190188 | 100928 (2097152.0) | 9 / 2 | 0.0 / 0 |
| factory_flat | 26337.088 (48128.535) | 45.278 | 1.0 | 114684 / 190096 | 100928 (2097152.0) | 4 / 2 | 0.0 / 0 |
| sift | 147721.748 (205016.963) | 27.947 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 326 / 25 | 0.0 / 0 |
| hub | 33472.351 (58845.066) | 43.118 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 7 / 4 | 0.0 / 0 |
| mam | 66860.182 (117338.877) | 43.02 | 1.011 | 42708 / 42688 | 0 (2097152.0) | 4 / 1 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 7 / 6 | 0.0 / 0 |
| hologram | 3910.507 (6871.433) | 43.09 | 1.0 | 45736 / 47192 | 0 (2097152.0) | 2 / 3 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.067 (35) | 2.597 (36) | 1.566 | 4.479 (12) | 0 | 806 / 0 | 9.582 / 12.801 | 5.923 / 7.689 |
| factory_flat | 4.35 (13) | 1.375 (2) | 3.164 | 4.35 (13) | 0 | 564 / 0 | 2.406 / 2.453 | 0.572 / 0.561 |
| sift | 1.55 (41) | 1.176 (41) | 1.318 | None (0) | 0 | 1349 / 0 | 7.145 / 9.445 | 3.468 / 4.552 |
| hub | 0.382 (8) | 0.211 (8) | 1.81 | None (0) | 0 | 1399 / 0 | 7.052 / 9.309 | 3.319 / 4.51 |
| mam | 0.549 (4) | 0.235 (4) | 2.336 | None (0) | 0 | 1707 / 0 | 6.995 / 9.553 | 3.522 / 5.081 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1708 / 0 | 6.992 / 9.547 | 3.518 / 5.069 |
| hologram | 2.464 (19) | 0.407 (25) | 6.054 | None (0) | 0 | 1741 / 0 | 7.007 / 9.51 | 3.537 / 5.034 |
| create_ct | 0.801 (60) | 0.416 (54) | 1.925 | None (0) | 0 | 1797 / 0 | 6.834 / 9.291 | 3.447 / 4.894 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.126 | 16 (vanilla 28) | 96100 | 25.115 / 0.28 | 1.511 / 28.0 | 2.566 | 1643 / 0 | 4.479 (9.66) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.125 | 16 (vanilla 28) | 96084 | 1.463 / 0.004 | 1.511 / 12.0 | 2.566 | 632 / 0 | 4.35 (11.991) |
| sift | indirect, one multi-draw per arena and layer | 3.009 | 430.316 | 16 (vanilla 28) | 462608 | 23.01 / 0.314 | 7.389 / 16.0 | 12.353 | 2652 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.084 | 16 (vanilla 28) | 117492 | 22.339 / 0.304 | 1.879 / 12.0 | 3.137 | 2730 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.146 | 16 (vanilla 28) | 1180788 | 23.138 / 0.337 | 20.088 / 32.0 | 31.53 | 3365 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1007136 | 23.138 / 0.337 | 17.346 / 32.0 | 26.893 | 3366 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 13.022 | 16 (vanilla 28) | 13744 | 22.945 / 0.332 | 0.238 / 32.0 | 0.367 | 3430 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.503 / 0.325 | 0.171 / 32.0 | 0.283 | 3538 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1962 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 594 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 596 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.003 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.003 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.411 / 0.0 | 0.52 / 0.493 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.945 / 10.01 | 0.016 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.489 / 0.0 | 0.09 / 0.519 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.878 / 10.306 | 0.03 / 0.019 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 123.237 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.645 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 148.202 / 88.973 | 0.118 / 0.036 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.86 | 0.0 / 0.0 | 574.56 / 574.14 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.86 (8.0 / 8.0) |
| mam | 13.85 / 13.85 | 1.0 / 1.0 | 112.67 / 112.57 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.85 / 13.85 (8.0 / 8.0) |
| ponder | 82.57 / 82.57 | 0.0 / 0.0 | 203.77 / 203.8 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 20.18 (base 20.24) | 13 (base 13) | 49032 (base 49024) | 364.6 (base 361.53) | 3.73 (base 5.48) |
| factory_flat | 19.88 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 362.07 (base 360.27) | 3.48 (base 5.48) |
| sift | 38.99 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 383.11 (base 379.69) | 3.73 (base 4.24) |
| hub | 25.53 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 394.95 (base 392.07) | 3.73 (base 5.99) |
| mam | 24.53 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 408.49 (base 404.98) | 7.73 (base 7.73) |
| ponder | 87.23 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 406.92 (base 403.64) | 7.73 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43204 (base 43652) | 394.7 (base 392.54) | 7.54 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 395.83 (base 393.74) | 7.54 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 20.18 / 20 (30.01) | 180.34 / 226 (29.5) | median and average, x 1.10 + 2 |
| factory_flat | 19.88 / 20 (29.97) | 179.74 / 226 (29.9) | median and average, x 1.10 + 2 |
| sift | 38.99 / 41 (24.4) | 579.0 / 579 (14.42) | median, x 1.10 + 2 |
| hub | 25.53 / 25 (29.98) | 162.64 / 208 (29.65) | median and average, x 1.10 + 2 |
| mam | 24.53 / 24 (29.96) | 200.57 / 246 (29.76) | median, x 1.10 + 2 |
| ponder | 87.23 / 87 (29.95) | 181.37 / 227 (29.79) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.98) | 128.47 / 175 (29.86) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 111.0 / 158 (29.98) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.527 | 12.0 / 1.527 | 0.0 / 0.0 | 256.0 / 2.752 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.892 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.31 | 32.0 / 20.31 | 0.0 / 0.0 | 416.0 / 34.041 |
| ponder | 32.0 / 17.563 | 32.0 / 17.563 | 0.0 / 0.0 | 416.0 / 29.124 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26336.623 (48127.683) | 45.278 | 1.0 | 156760 / 233368 | 100928 (2097152.0) | 0 / 7 | 0.0 / 0 |
| factory_flat | 26337.277 (48128.99) | 45.278 | 1.0 | 156760 / 233360 | 100928 (2097152.0) | 2 / 1 | 0.0 / 0 |
| sift | 145760.69 (204809.692) | 28.831 | 1.434 | 4148 / 8052 | 0 (2097152.0) | 23 / 288 | 0.0 / 0 |
| hub | 33471.786 (58844.073) | 43.118 | 1.02 | 83908 / 84516 | 0 (2097152.0) | 0 / 6 | 0.0 / 0 |
| mam | 67091.633 (117850.09) | 43.07 | 1.011 | 40068 / 40948 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61212 / 61204 | 0 (2097152.0) | 2 / 6 | 0.0 / 0 |
| hologram | 3910.518 (6871.452) | 43.09 | 1.0 | 45780 / 45252 | 0 (2097152.0) | 1 / 3 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.404 (36) | 3.68 (35) | 0.653 | 2.369 (12) | 0 | 929 / 0 | 5.708 / 7.659 | 2.225 / 3.197 |
| factory_flat | 2.09 (5) | 1.855 (11) | 1.127 | 2.09 (5) | 0 | 572 / 0 | 1.375 / 1.279 | 0.295 / 0.281 |
| sift | 0.825 (41) | 2.097 (40) | 0.393 | None (0) | 0 | 1471 / 0 | 4.175 / 5.572 | 1.428 / 2.15 |
| hub | 0.246 (8) | 0.251 (8) | 0.98 | None (0) | 0 | 1523 / 0 | 4.122 / 5.483 | 1.407 / 2.046 |
| mam | 0.445 (4) | 0.344 (4) | 1.294 | None (0) | 0 | 1837 / 0 | 3.982 / 5.445 | 1.525 / 2.323 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1838 / 0 | 3.98 / 5.442 | 1.524 / 2.322 |
| hologram | 0.537 (25) | 0.635 (19) | 0.846 | None (0) | 0 | 1871 / 0 | 3.971 / 5.402 | 1.519 / 2.314 |
| create_ct | 0.532 (60) | 0.576 (52) | 0.924 | None (0) | 0 | 1927 / 0 | 3.886 / 5.278 | 1.445 / 2.192 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 8.013 | 74.123 | 16 (vanilla 28) | 96100 | 26.588 / 0.338 | 1.511 / 28.0 | 2.566 | 1998 / 0 | 2.369 (5.292) |
| factory_flat | plain, one multi-draw per region and layer | 8.013 | 74.123 | 16 (vanilla 28) | 97020 | 1.308 / 0.004 | 1.527 / 12.0 | 2.591 | 622 / 0 | 2.09 (3.223) |
| sift | plain, one multi-draw per region and layer | 21.043 | 429.881 | 16 (vanilla 28) | 462608 | 24.383 / 0.358 | 7.389 / 16.0 | 12.353 | 3006 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 7.012 | 50.083 | 16 (vanilla 28) | 117492 | 23.758 / 0.348 | 1.879 / 12.0 | 3.137 | 3087 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 5.008 | 87.145 | 16 (vanilla 28) | 1193196 | 24.297 / 0.37 | 20.31 / 32.0 | 31.862 | 3737 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019176 | 24.297 / 0.37 | 17.563 / 32.0 | 27.215 | 3738 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 3.005 | 13.022 | 16 (vanilla 28) | 13744 | 24.099 / 0.364 | 0.238 / 32.0 | 0.367 | 3802 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.666 / 0.358 | 0.171 / 32.0 | 0.283 | 3910 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2928 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.008; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.002 (0.184; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.126 / 0.0 | 0.543 / 0.513 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.726 / 10.567 | 0.016 / 0.008 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.568 / 0.0 | 0.504 / 0.213 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 4.701 / 4.576 | 0.04 / 0.014 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 8.172 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.122 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.04 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 94.118 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.802 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 154.583 / 92.08 | 0.118 / 0.041 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.85 | 0.0 / 0.0 | 574.49 / 573.66 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.85 (8.0 / 8.0) |
| mam | 13.86 / 13.86 | 1.0 / 1.0 | 113.09 / 113.16 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.11 / 0.11 | 203.65 / 203.9 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 14.23 (base 14.25) | 15 (base 15) | 51608 (base 51624) | 363.42 (base 360.8) | 3.71 (base 5.46) |
| factory_flat | 13.67 (reported, not gated) | 15 (base 15) | 51500 (base 51500) | 359.82 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 381.88 (base 379.18) | 3.71 (base 5.46) |
| hub | 21.53 (base 21.57) | 16 (base 16) | 66576 (base 66576) | 394.5 (base 391.05) | 3.71 (base 5.46) |
| mam | 22.52 (base 22.55) | 19 (base 19) | 23748 (base 23748) | 408.0 (base 404.61) | 7.71 (base 7.71) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 406.08 (base 403.47) | 7.71 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.66 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 397.14 (base 395.99) | 7.52 (base 8.29) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 14.23 / 14 (29.98) | 109.22 / 154 (29.45) | median and average, x 1.10 + 2 |
| factory_flat | 13.67 / 14 (29.99) | 109.42 / 154 (29.16) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (17.63) | 153.0 / 153 (12.57) | median, x 1.10 + 2 |
| hub | 21.53 / 21 (29.84) | 119.12 / 161 (28.56) | median and average, x 1.10 + 2 |
| mam | 22.52 / 22 (29.92) | 126.36 / 162 (26.86) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (30.0) | 181.76 / 227 (29.56) | median and average, x 1.10 + 2 |
| create_ct | 6.66 / 7 (29.98) | 100.24 / 147 (29.85) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.33 | 32.0 / 20.33 | 0.0 / 0.0 | 416.0 / 32.922 |
| ponder | 32.0 / 17.582 | 32.0 / 17.582 | 0.0 / 0.0 | 416.0 / 28.113 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26336.603 (48127.643) | 45.278 | 1.0 | 159336 / 234848 | 100928 (2097152.0) | 0 / 4 | 0.0 / 0 |
| factory_flat | 26337.896 (48130.217) | 45.278 | 1.0 | 51500 / 51500 | 0 (2097152.0) | 0 / 5 | 0.0 / 0 |
| sift | 147688.381 (204970.653) | 27.947 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 352 / 251 | 0.0 / 0 |
| hub | 33471.973 (58844.402) | 43.118 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 2 / 17 | 0.0 / 0 |
| mam | 67091.82 (117850.417) | 43.07 | 1.011 | 42708 / 42688 | 0 (2097152.0) | 11 / 28 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61248 | 0 (2097152.0) | 0 / 3 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.412 (35) | 3.152 (35) | 0.765 | 2.286 (12) | 0 | 872 / 0 | 6.932 / 9.851 | 3.269 / 6.065 |
| factory_flat | None (0) | None (0) | None | None (0) | 0 | 564 / 0 | 1.799 / 1.852 | 0.426 / 0.432 |
| sift | 1.069 (41) | 1.422 (41) | 0.752 | None (0) | 0 | 1416 / 0 | 5.256 / 7.311 | 2.072 / 3.093 |
| hub | 0.316 (8) | 0.284 (8) | 1.113 | None (0) | 0 | 1470 / 0 | 5.199 / 7.218 | 2.064 / 3.064 |
| mam | 0.464 (4) | 0.459 (4) | 1.011 | None (0) | 0 | 1786 / 0 | 5.01 / 7.127 | 2.188 / 3.538 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1787 / 0 | 5.008 / 7.123 | 2.181 / 3.536 |
| create_ct | 0.558 (46) | 0.844 (48) | 0.661 | None (0) | 0 | 1843 / 0 | 4.893 / 6.949 | 2.081 / 3.335 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.123 | 16 (vanilla 28) | 96100 | 26.488 / 0.353 | 1.511 / 28.0 | 2.566 | 1862 / 0 | 2.286 (2.902) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.124 | 16 (vanilla 28) | 96100 | 1.203 / 0.004 | 1.511 / 12.0 | 2.566 | 606 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.009 | 430.219 | 16 (vanilla 28) | 462608 | 24.21 / 0.37 | 7.389 / 16.0 | 12.353 | 2872 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.084 | 16 (vanilla 28) | 117492 | 23.463 / 0.357 | 1.879 / 12.0 | 3.137 | 2957 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.145 | 16 (vanilla 28) | 1194384 | 24.069 / 0.379 | 20.33 / 32.0 | 31.893 | 3611 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1020364 | 24.069 / 0.379 | 17.582 / 32.0 | 27.247 | 3612 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.674 / 0.373 | 0.171 / 32.0 | 0.283 | 3709 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2118 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 95.0 / 0.0 | 0.541 / 0.558 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.564 / 10.448 | 0.018 / 0.008 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 95.739 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 97.583 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 103.762 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 94.518 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.86 / 13.84 | 0.0 / 0.0 | 574.12 / 573.54 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.86 / 13.84 (8.0 / 8.0) |
| mam | 13.85 / 13.86 | 1.0 / 1.0 | 112.49 / 112.72 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.85 / 13.86 (8.0 / 8.0) |
| ponder | 82.58 / 82.58 | 0.11 / 0.0 | 203.73 / 203.68 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.6 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 11.31 | 105.82 | 226 | 123 | 587944 | [] |
| bench-plain | flythrough | 7.19 | 368.98 | 143 | 123 | 7519868 | [] |
| bench-plain | water_glass | 19.7 | 58.92 | 252 | 124 | 16808 | [] |
| bench-plain | nether | 19.15 | 69.76 | 380 | 121 | 303188 | [] |
| bench-sodium | spawn | 17.49 | 75.0 | 349 | 147 | 2096 | [] |
| bench-sodium | flythrough | 12.61 | 203.72 | 251 | 158 | 265804 | [] |
| bench-sodium | water_glass | 29.78 | 43.78 | 1 | 135 | 8780 | [] |
| bench-sodium | nether | 30.0 | 39.22 | 0 | 129 | 263552 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 53.609 (50.0) | 730 / 730 | 1733 | 1 | 40413.513 | 5.62 (0.0) | 1263 |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | nether | 4.12 | 4.12 (0) | 4.12 |  |
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
| core-measure-full | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flythrough | 5.48 | 5.48 (0) | 5.48 |  |
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
| core-measure-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-vk | spawn | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | water_glass | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | nether | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | mobs | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | outline | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | occlusion | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | occlusion_move | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | translucent_move | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | particles | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | animation | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | animated_items | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | flat_plants | 3.59 | 3.59 (0) | 3.59 |  |
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
| core-quicksilver-full | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-sp-quicksilver | flythrough | 1.38 | 1.52 (229) | 1.52 |  |
| siftec-measure-full | factory | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-full | sift | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-full | hub | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-full | mam | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-full | ponder | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-full | hologram | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-measure-full | create_ct | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-measure-full | factory_flat | 3.29 | 3.29 (0) | 3.29 |  |
| siftec-measure-old | factory | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-measure-old | sift | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-measure-old | hub | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-measure-old | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-old | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-old | factory_flat | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-vk | factory | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | sift | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | hub | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | mam | 7.71 | 7.71 (0) | 7.71 | between scenes +4.00 |
| siftec-measure-vk | ponder | 7.71 | 7.71 (0) | 7.71 |  |
| siftec-measure-vk | create_ct | 7.52 | 7.52 (0) | 7.52 |  |
| siftec-measure-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-full | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-full | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-full | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-full | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-old | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-old | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-vk | factory | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-quicksilver-vk | sift | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-quicksilver-vk | hub | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-quicksilver-vk | mam | 7.71 | 7.71 (0) | 7.71 | between scenes +4.00 |
| siftec-quicksilver-vk | ponder | 7.71 | 7.71 (0) | 7.71 |  |
| siftec-quicksilver-vk | create_ct | 7.52 | 7.52 (0) | 7.52 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |

Rises of 4 MB or more: siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-full/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00; siftec-quicksilver-vk/mam: between scenes +4.00

