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
| spawn | 0.4328 | 10.05 | 0.0474 | 0.0854 | 0.4333 |
| flythrough | 0.0001 | 14.95 | 0.001 | 0.001 | 0.0011 |
| water_glass | 0.0049 | 6.45 | 0.005 | 0.0047 | 0.0051 |
| nether | 0.0022 | 0.8 | 0.0052 | 0.0003 | 0.0005 |
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
| translucent_move | 0.0002 | 0.3 | 0.0 | 0.0001 | 0.0002 |
| translucent_move.x2404 | 0.0 | 0.3 | 0.0002 | 0.0005 | 0.0003 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0001 | 0.0003 | 0.0003 |
| translucent_move.x2424 | 0.0005 | 0.3 | 0.001 | 0.0002 | 0.0002 |
| translucent_move.low | 0.0009 | 0.3 | 0.0014 | 0.0012 | 0.0014 |
| translucent_move.back | 0.0 | 0.3 | 0.0001 | 0.0003 | 0.0002 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0003 | 0.0 | 0.0002 |
| water_glass_oit | 0.0036 | 0.3 | 0.0035 | 0.0052 | 0.0036 |
| translucent_move_oit | 0.0 | 0.3 | 0.0 | 0.0002 | 0.0003 |
| translucent_move_oit.x2404 | 0.0 | 0.3 | 0.0002 | 0.0004 | 0.0003 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0003 | 0.0003 | 0.0003 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0002 | 0.0002 |
| translucent_move_oit.low | 0.0011 | 0.3 | 0.0016 | 0.0015 | 0.0013 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0003 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0004 | 0.3 | 0.0003 | 0.0001 | 0.0 |
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
| spawn | 92.75 | 18057 | 179 (644) | 438 (921) | 268 (800) |
| flythrough | 97.28 | 6020 | 47 (292) | 47 (292) | 51 (294) |
| water_glass | 95.81 | 25508 | 23 (2624) | 22 (2623) | 17 (2732) |
| nether | 99.42 | 905 | 22 (477) | 3 (458) | 5 (472) |
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
| translucent_move | 96.93 | 13 | 2 (77) | 3 (78) | 2 (68) |
| translucent_move.x2404 | 95.93 | 15 | 3 (103) | 3 (104) | 6 (90) |
| translucent_move.x2414 | 95.86 | 13 | 2 (105) | 4 (107) | 4 (102) |
| translucent_move.x2424 | 96.74 | 13 | 4 (81) | 2 (79) | 3 (69) |
| translucent_move.low | 96.11 | 41 | 14 (19) | 14 (20) | 16 (18) |
| translucent_move.back | 96.93 | 13 | 2 (77) | 2 (77) | 2 (68) |
| translucent_move.bare_back | 96.9 | 13 | 2 (77) | 1 (76) | 1 (68) |
| water_glass_oit | 95.81 | 57 | 14 (2616) | 23 (2625) | 17 (2731) |
| translucent_move_oit | 96.93 | 12 | 2 (77) | 1 (76) | 4 (70) |
| translucent_move_oit.x2404 | 95.93 | 16 | 4 (105) | 4 (104) | 5 (89) |
| translucent_move_oit.x2414 | 95.86 | 10 | 2 (105) | 2 (106) | 2 (99) |
| translucent_move_oit.x2424 | 96.74 | 15 | 1 (78) | 1 (79) | 2 (68) |
| translucent_move_oit.low | 96.11 | 40 | 15 (20) | 17 (22) | 14 (17) |
| translucent_move_oit.back | 96.93 | 12 | 3 (79) | 1 (76) | 3 (70) |
| translucent_move_oit.bare_back | 96.9 | 15 | 2 (77) | 1 (76) | 4 (70) |
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
| spawn | 0.0489 / 228 | 0.0573 / 198 | 0.0533 / 223 |
| flythrough | 0.0 / 0 | 0.0003 / 3 | 0.0 / 0 |
| water_glass | 0.005 / 23 | 0.0039 / 17 | 0.006 / 26 |
| nether | 0.002 / 0 | 0.0017 / 15 | 0.0 / 0 |
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
| translucent_move | 0.0 / 0 | 0.0001 / 0 | 0.0001 / 1 |
| translucent_move.x2404 | 0.0001 / 2 | 0.0001 / 0 | 0.0 / 1 |
| translucent_move.x2414 | 0.0 / 0 | 0.0 / 0 | 0.0001 / 1 |
| translucent_move.x2424 | 0.0005 / 0 | 0.0 / 1 | 0.0 / 0 |
| translucent_move.low | 0.0005 / 2 | 0.0007 / 5 | 0.0008 / 2 |
| translucent_move.back | 0.0 / 1 | 0.0002 / 0 | 0.0003 / 1 |
| translucent_move.bare_back | 0.0001 / 1 | 0.0001 / 2 | 0.0003 / 0 |
| water_glass_oit | 0.0039 / 18 | 0.0041 / 17 | 0.0022 / 8 |
| translucent_move_oit | 0.0001 / 3 | 0.0004 / 6 | 0.0002 / 1 |
| translucent_move_oit.x2404 | 0.0 / 2 | 0.0001 / 1 | 0.0001 / 1 |
| translucent_move_oit.x2414 | 0.0002 / 0 | 0.0002 / 1 | 0.0003 / 3 |
| translucent_move_oit.x2424 | 0.0003 / 3 | 0.0001 / 1 | 0.0 / 0 |
| translucent_move_oit.low | 0.0007 / 3 | 0.0007 / 3 | 0.0008 / 3 |
| translucent_move_oit.back | 0.0001 / 0 | 0.0001 / 1 | 0.0 / 1 |
| translucent_move_oit.bare_back | 0.0003 / 0 | 0.0001 / 1 | 0.0 / 1 |
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
| spawn | 13.0 (base 13.6) | 14 (base 14) | 25476 (base 22476) | 247.83 (base 259.07) | 3.48 (base 3.99) |
| flythrough | 13.07 (reported, not gated) | 33 (reported, not gated) | 384740 (reported, not gated) | 306.59 (base 324.25) | 3.48 (base 4.24) |
| water_glass | 8.96 (base 8.97) | 15 (base 15) | 15880 (base 15576) | 233.36 (base 250.02) | 3.48 (base 5.99) |
| nether | 15.81 (base 15.63) | 12 (base 12) | 20876 (base 19648) | 254.76 (base 273.53) | 3.48 (base 5.99) |
| mobs | 19.75 (base 19.77) | 17 (base 17) | 616288 (base 1010948) | 253.62 (base 268.37) | 3.48 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6300 (base 6356) | 252.59 (base 264.69) | 3.48 (base 5.48) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100612 (base 126320) | 258.1 (base 265.1) | 5.48 (base 4.24) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82504 (reported, not gated) | 258.82 (base 265.74) | 5.48 (base 4.24) |
| translucent_move | 8.91 (reported, not gated) | 15 (reported, not gated) | 10876 (reported, not gated) | 260.64 (base 267.48) | 5.48 (base 5.48) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15432 (base 14688) | 232.59 (base 245.02) | 3.35 (base 3.73) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10836 (reported, not gated) | 235.47 (base 247.19) | 3.48 (base 3.73) |
| flat_plants | 17.81 (base 18.29) | 15 (base 15) | 9944 (base 9812) | 234.82 (base 246.92) | 3.46 (base 3.99) |
| renderer_off | 7.67 (base 7.67) | 14 (base 14) | 7296 (base 7164) | 228.06 (base 241.33) | 3.35 (base 4.12) |
| particles | 9.67 (base 9.72) | 15 (base 15) | 9204 (base 17128) | 255.78 (base 261.44) | 5.48 (base 5.99) |
| animation | 49 median (avg 39.98) (base 49) | 15 (base 15) | 2224 (base 2056) | 253.35 (base 260.68) | 5.48 (base 5.99) |
| animated_items | 60 median (avg 46.77) (base 60) | 24 (base 23) | 22136 (base 21940) | 228.36 (base 239.81) | 5.48 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.0 / 13 (10.69) | 123.81 / 124 (11.33) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (8.49) | 123.08 / 123 (6.63) | median and average, at most vanilla + 2 |
| water_glass | 8.96 / 9 (20.62) | 122.55 / 124 (19.99) | median, at most vanilla |
| nether | 15.81 / 16 (18.91) | 120.85 / 121 (19.52) | median, x 1.10 + 2 |
| mobs | 19.75 / 20 (26.77) | 108.7 / 134 (25.48) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 87.2 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.33 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (30.0) | 94.2 / 133 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 8.91 / 9 (21.78) | 121.42 / 124 (20.27) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (12.03) | 129.0 / 129 (11.12) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (10.97) | 129.0 / 129 (10.29) | median and average, at most vanilla |
| flat_plants | 17.81 / 19 (21.57) | 121.38 / 124 (20.43) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.99) | 84.4 / 123 (29.95) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.98 / 49 (29.99) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.77 / 60 (30.0) | 155.46 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.132 | 36.0 / 23.132 | 0.0 / 0.0 | 416.0 / 37.722 |
| flythrough | 112.0 / 84.746 | 112.0 / 84.746 | 0.0 / 0.0 | 416.0 / 143.97 |
| water_glass | 36.0 / 12.333 | 36.0 / 12.333 | 0.0 / 0.0 | 416.0 / 21.905 |
| nether | 20.0 / 15.215 | 20.0 / 15.215 | 0.0 / 0.0 | 256.0 / 26.664 |
| mobs | 16.0 / 9.471 | 16.0 / 9.471 | 0.0 / 0.0 | 256.0 / 16.57 |
| outline | 16.0 / 1.261 | 16.0 / 1.261 | 0.0 / 0.0 | 256.0 / 2.229 |
| occlusion | 20.0 / 2.599 | 20.0 / 2.599 | 0.0 / 0.0 | 416.0 / 4.475 |
| occlusion_move | 20.0 / 3.406 | 20.0 / 3.406 | 0.0 / 0.0 | 416.0 / 5.823 |
| translucent_move | 28.0 / 13.07 | 28.0 / 13.07 | 0.0 / 0.0 | 416.0 / 22.383 |
| water_glass_oit | 20.0 / 12.333 | 20.0 / 12.333 | 0.0 / 0.0 | 416.0 / 21.407 |
| translucent_move_oit | 28.0 / 12.659 | 28.0 / 12.659 | 0.0 / 0.0 | 416.0 / 21.764 |
| flat_plants | 24.0 / 13.94 | 24.0 / 13.94 | 0.0 / 0.0 | 416.0 / 23.906 |
| renderer_off | 24.0 / 8.408 | 24.0 / 8.408 | 0.0 / 0.0 | 416.0 / 14.782 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 515945.427 (697893.615) | 26.071 | 1.156 | 718744 / 1307284 | 693696 (2097152.0) | 213 / 226 | 0.0 / 0 |
| flythrough | 560333.811 (897489.112) | 37.567 | 1.083 | 2169068 / 7732460 | 2090608 (2097152.0) | 169 / 132 | 6.982 / 90 |
| water_glass | 214002.165 (383360.233) | 44.177 | 1.117 | 17224 / 16024 | 0 (2097152.0) | 82 / 196 | 0.0 / 0 |
| nether | 319501.058 (477790.709) | 33.129 | 1.274 | 238712 / 323964 | 217728 (2097152.0) | 336 / 335 | 0.0 / 0 |
| mobs | 164278.49 (296162.542) | 44.531 | 0.99 | 616288 / 616168 | 0 (2097152.0) | 3 / 2 | 0.0 / 0 |
| outline | 23859.634 (39723.987) | 39.936 | 1.0 | 6300 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 46317.067 (81421.477) | 43.114 | 1.2 | 100612 / 126344 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50900.611 (89573.736) | 43.175 | 1.226 | 649788 / 1112992 | 572928 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 202928.717 (360442.846) | 43.7 | 1.186 | 766668 / 1332788 | 756224 (2097152.0) | 23 / 167 | 0.0 / 0 |
| water_glass_oit | 214373.517 (384025.467) | 44.177 | 1.117 | 17224 / 16584 | 0 (2097152.0) | 240 / 222 | 0.0 / 0 |
| translucent_move_oit | 202843.562 (360053.005) | 43.663 | 1.185 | 737032 / 1281584 | 726016 (2097152.0) | 219 / 205 | 0.0 / 0 |
| flat_plants | 237814.497 (435642.432) | 45.411 | 1.06 | 272200 / 271600 | 0 (2097152.0) | 29 / 39 | 0.0 / 0 |
| renderer_off | 146441.663 (264842.67) | 44.706 | 1.015 | 7296 / 7236 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86740 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79864 / 123160 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.014 | 796.484 | 16 (vanilla 28) | 1396756 | 40.497 / 0.109 | 23.132 / 36.0 | 37.297 | 2412 / 0 | 3.128 (5.741) |
| flythrough | indirect, one multi-draw per arena and layer | 3.018 | 915.012 | 16 (vanilla 28) | 5128704 | 15.249 / 1.015 | 84.746 / 112.0 | 136.951 | 6588 / 0 | 4.696 (12.255) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 273.663 | 16 (vanilla 28) | 764864 | 33.554 / 0.094 | 12.333 / 36.0 | 20.424 | 3099 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.005 | 468.235 | 16 (vanilla 28) | 953136 | 28.049 / 0.181 | 15.215 / 20.0 | 25.451 | 4170 / 0 | 2.649 (2.935) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 197.368 | 16 (vanilla 28) | 591220 | 25.624 / 0.159 | 9.471 / 16.0 | 15.787 | 4604 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 42.07 | 16 (vanilla 28) | 79316 | 25.212 / 0.159 | 1.261 / 16.0 | 2.118 | 4699 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 70.117 | 16 (vanilla 28) | 162572 | 24.138 / 0.151 | 2.599 / 20.0 | 4.341 | 4926 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 75.454 | 16 (vanilla 28) | 213400 | 22.833 / 0.143 | 3.406 / 20.0 | 5.698 | 5219 / 0 | 3.212 (5.605) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.007 | 248.809 | 16 (vanilla 28) | 806568 | 19.762 / 0.13 | 13.07 / 28.0 | 21.538 | 6030 / 0 | 5.349 (13.317) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.021 | 282.171 | 16 (vanilla 28) | 764864 | 7.654 / 0.044 | 12.333 / 20.0 | 20.424 | 1085 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.023 | 263.388 | 16 (vanilla 28) | 780688 | 6.724 / 0.111 | 12.659 / 28.0 | 20.847 | 2455 / 0 | 4.288 (10.575) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.007 | 284.659 | 16 (vanilla 28) | 869268 | 6.341 / 0.01 | 13.94 / 24.0 | 23.212 | 952 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 204.34 | 16 (vanilla 28) | 528804 | 2.443 / 0.021 | 8.408 / 24.0 | 14.121 | 601 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 19.712 / 0.129 | 0.131 / 28.0 | 0.225 | 6074 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.549 / 0.128 | 0.302 / 28.0 | 0.518 | 6176 / 0 | 1.091 (1.252) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.492 / 0.129 | 0.153 / 28.0 | 0.261 | 6226 / 0 | 0.842 (1.164) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.519 | 1.0 | 0.0 | 0 | 0 | 33 (0.027 / 0.041 / 0.061; 0) | 0 | 33067 / 0 / 0 |
| flythrough | 192.329 | 1.0 | 0.0 | 0 | 0 | 899 (0.026 / 0.041 / 6.036; 0) | 61 | 32696 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1652 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.009 / 0.023 / 0.04; 0) | 32 | 1200 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.096 / 0.143 / 0.456; 0) | 180 | 3052 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 723 | 0 (None / None / None; 0) | 0 | 964 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 660 | 0 (None / None / None; 0) | 0 | 1540 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1728 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 347.215 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.033 (0.085; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.588 | 1.0 (0.0, 0.0) | 1.6 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.018 (0.053; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.122 (0.195; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.051 (0.111; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.368) | 6.0 (6.0, 2.28) | 0.038 (0.18; 0) | 0 | 2789 / 1510470 / 0 / 0 |
| translucent_move | 136.305 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.614 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.039; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 111.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.752 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 85.003 / 0.0 | 0.027 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.513 / 0.0 | 0.006 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.847 |
| water_glass | 113.559 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.13 / 53.16 | 0.014 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 10.0 | 0.854 / 0.81 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.843 / 6.562 | 0.076 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 89.921 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 112.444 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.585 / 12.555 | 0.005 / 0.015 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 50.658 / 50.71 | 0.014 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.628 / 13.605 | 0.008 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 112.463 / 9.258 | 0.939 / 0.629 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.027 / 0.935 | 0.012 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.006 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.004 / 0.034 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.005 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 136.793 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 50.46 (base 49.0) | 13 (base 13) | 17060 (base 6372) | 248.6 (base 256.29) | 5.48 (base 3.73) |
| flythrough | 67.53 (reported, not gated) | 28 (reported, not gated) | 111364 (reported, not gated) | 304.51 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.69 (base 20.0) | 13 (base 14) | 7204 (base 10264) | 233.05 (base 249.83) | 5.48 (base 5.99) |
| nether | 30.16 (base 33.79) | 10 (base 11) | 4084 (base 10656) | 253.78 (base 272.57) | 5.48 (base 5.99) |
| mobs | 28.67 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 253.57 (base 268.23) | 5.48 (base 5.99) |
| outline | 19.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 252.41 (base 264.41) | 5.48 (base 3.73) |
| occlusion | 22.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 257.59 (base 264.64) | 5.48 (base 4.24) |
| occlusion_move | 24.06 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 258.28 (base 265.66) | 5.48 (base 5.99) |
| translucent_move | 17.67 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 260.35 (base 268.19) | 5.48 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7540 (base 7604) | 232.31 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.28 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 235.16 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 29.66 (base 33.0) | 13 (base 13) | 1624 (base 1716) | 234.64 (base 248.11) | 3.21 (base 5.99) |
| renderer_off | 17.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 228.2 (base 240.73) | 3.35 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 255.36 (base 261.4) | 5.48 (base 4.24) |
| animation | 49 median (avg 39.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 252.94 (base 260.68) | 5.48 (base 4.24) |
| animated_items | 60 median (avg 46.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 227.87 (base 239.53) | 5.48 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.46 / 50 (15.63) | 848.67 / 848 (13.18) | median and average, x 1.10 + 2 |
| flythrough | 67.53 / 64 (12.29) | 1027.06 / 1026 (8.17) | median and average, at most vanilla |
| water_glass | 19.69 / 20 (28.63) | 382.12 / 390 (21.33) | median, at most vanilla |
| nether | 30.16 / 34 (29.77) | 580.54 / 586 (20.9) | median, x 1.10 + 2 |
| mobs | 28.67 / 29 (29.9) | 297.36 / 329 (27.48) | median, x 1.10 + 2 |
| outline | 19.67 / 20 (30.0) | 127.2 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 22.67 / 23 (29.98) | 161.27 / 200 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 24.06 / 24 (29.97) | 166.6 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 17.67 / 18 (29.71) | 356.2 / 367 (22.42) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (15.49) | 401.0 / 401 (11.75) | median, at most vanilla |
| translucent_move_oit | 25.28 / 25 (14.66) | 385.69 / 385 (10.83) | median and average, at most vanilla |
| flat_plants | 29.66 / 33 (28.43) | 388.08 / 401 (22.5) | median, x 1.10 + 2 |
| renderer_off | 17.67 / 18 (29.9) | 285.79 / 324 (29.73) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.98 / 49 (30.0) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.73 / 60 (30.0) | 167.22 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.147 | 36.0 / 23.147 | 0.0 / 0.0 | 416.0 / 37.262 |
| flythrough | 112.0 / 88.485 | 112.0 / 88.485 | 0.0 / 0.0 | 416.0 / 148.189 |
| water_glass | 36.0 / 12.333 | 36.0 / 12.333 | 0.0 / 0.0 | 416.0 / 21.407 |
| nether | 20.0 / 15.211 | 20.0 / 15.211 | 0.0 / 0.0 | 256.0 / 26.663 |
| mobs | 16.0 / 9.471 | 16.0 / 9.471 | 0.0 / 0.0 | 256.0 / 16.57 |
| outline | 16.0 / 1.261 | 16.0 / 1.261 | 0.0 / 0.0 | 256.0 / 2.229 |
| occlusion | 20.0 / 2.594 | 20.0 / 2.594 | 0.0 / 0.0 | 416.0 / 4.373 |
| occlusion_move | 20.0 / 3.348 | 20.0 / 3.348 | 0.0 / 0.0 | 416.0 / 5.734 |
| translucent_move | 28.0 / 12.999 | 28.0 / 12.999 | 0.0 / 0.0 | 416.0 / 22.37 |
| water_glass_oit | 20.0 / 12.333 | 20.0 / 12.333 | 0.0 / 0.0 | 416.0 / 21.407 |
| translucent_move_oit | 28.0 / 12.588 | 28.0 / 12.588 | 0.0 / 0.0 | 416.0 / 21.657 |
| flat_plants | 24.0 / 13.853 | 24.0 / 13.853 | 0.0 / 0.0 | 416.0 / 23.928 |
| renderer_off | 24.0 / 8.408 | 24.0 / 8.408 | 0.0 / 0.0 | 416.0 / 14.782 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 453756.987 (700499.321) | 35.224 | 1.775 | 355748 / 521608 | 338688 (2097152.0) | 312 / 263 | 0.0 / 0 |
| flythrough | 565901.404 (906376.971) | 37.564 | 1.084 | 2106396 / 7664936 | 2095656 (2097152.0) | 245 / 163 | 6.183 / 98 |
| water_glass | 213856.572 (383099.421) | 44.177 | 1.117 | 9108 / 11764 | 0 (2097152.0) | 10 / 22 | 0.0 / 0 |
| nether | 268860.316 (477223.919) | 43.662 | 1.707 | 219680 / 438596 | 216064 (2097152.0) | 0 / 15 | 0.0 / 0 |
| mobs | 164246.66 (296105.159) | 44.531 | 0.99 | 610516 / 612228 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| outline | 23859.7 (39724.097) | 39.936 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 46233.055 (81245.409) | 43.095 | 1.197 | 98148 / 124924 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_move | 50637.003 (89005.33) | 43.108 | 1.223 | 651068 / 1093116 | 576000 (2097152.0) | 2 / 0 | 0.0 / 0 |
| translucent_move | 202146.175 (358985.627) | 43.69 | 1.186 | 756532 / 1328228 | 753920 (2097152.0) | 1 / 6 | 0.0 / 0 |
| water_glass_oit | 214174.887 (383669.644) | 44.177 | 1.117 | 9444 / 11540 | 0 (2097152.0) | 309 / 235 | 0.0 / 0 |
| translucent_move_oit | 201918.055 (358280.689) | 43.642 | 1.185 | 731860 / 1275828 | 726016 (2097152.0) | 293 / 216 | 0.0 / 0 |
| flat_plants | 236577.047 (433202.004) | 45.389 | 1.06 | 1940 / 4564 | 0 (2097152.0) | 1 / 9 | 0.0 / 0 |
| renderer_off | 146446.485 (264850.154) | 44.706 | 1.015 | 1380 / 3156 | 0 (2097152.0) | 2 / 1 | 0.0 / 0 |
| particles | 1927.207 (4215.013) | 54.278 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.736 (5631.76) | 42.864 | 1.071 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79144 / 122648 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.125 | 802.564 | 16 (vanilla 28) | 1396832 | 39.89 / 0.096 | 23.147 / 36.0 | 37.299 | 2336 / 0 | 2.418 (4.643) |
| flythrough | plain, one multi-draw per region and layer | 57.669 | 926.012 | 16 (vanilla 28) | 5357492 | 15.06 / 0.983 | 88.485 / 112.0 | 143.06 | 6699 / 0 | 4.66 (11.979) |
| water_glass | plain, one multi-draw per region and layer | 14.024 | 273.476 | 16 (vanilla 28) | 764864 | 32.558 / 0.084 | 12.333 / 36.0 | 20.424 | 2991 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 20.034 | 467.785 | 16 (vanilla 28) | 952880 | 27.499 / 0.181 | 15.211 / 20.0 | 25.445 | 3995 / 0 | 1.917 (2.188) |
| mobs | plain, one multi-draw per region and layer | 11.018 | 197.33 | 16 (vanilla 28) | 591220 | 25.051 / 0.159 | 9.471 / 16.0 | 15.787 | 4441 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 11.018 | 42.07 | 16 (vanilla 28) | 79316 | 24.638 / 0.158 | 1.261 / 16.0 | 2.118 | 4535 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 10.017 | 71.119 | 16 (vanilla 28) | 162220 | 23.581 / 0.151 | 2.594 / 20.0 | 4.332 | 4755 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 11.01 | 76.497 | 16 (vanilla 28) | 210396 | 22.365 / 0.143 | 3.348 / 20.0 | 5.618 | 5029 / 0 | 3.693 (6.711) |
| translucent_move | plain, one multi-draw per region and layer | 12.02 | 249.835 | 16 (vanilla 28) | 803384 | 19.319 / 0.13 | 12.999 / 28.0 | 21.453 | 5832 / 0 | 5.371 (12.383) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.052 | 281.909 | 16 (vanilla 28) | 764864 | 7.654 / 0.044 | 12.333 / 20.0 | 20.424 | 1085 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.331 | 263.904 | 16 (vanilla 28) | 777552 | 6.901 / 0.116 | 12.588 / 28.0 | 20.763 | 2457 / 0 | 4.645 (12.156) |
| flat_plants | plain, one multi-draw per region and layer | 17.03 | 285.501 | 16 (vanilla 28) | 864884 | 6.048 / 0.01 | 13.853 / 24.0 | 23.095 | 946 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 13.022 | 204.341 | 16 (vanilla 28) | 528816 | 2.474 / 0.022 | 8.408 / 24.0 | 14.121 | 596 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 12.02 | 16 (vanilla 28) | 8416 | 19.259 / 0.129 | 0.131 / 28.0 | 0.225 | 5878 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.094 / 0.128 | 0.302 / 28.0 | 0.518 | 5980 / 0 | 0.904 (1.182) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.037 / 0.129 | 0.153 / 28.0 | 0.261 | 6030 / 0 | 0.838 (1.119) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 17.0 | 0.0 | 0 | 0 | 39 (0.018 / 0.031 / 0.031; 0) | 0 | 48515 / 0 / 0 |
| flythrough | 195.862 | 26.553 | 0.0 | 0 | 0 | 890 (0.017 / 0.032 / 3.036; 0) | 44 | 48182 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2296 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.011 / 0.037 / 0.042; 0) | 32 | 1202 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 200 (0.112 / 0.099 / 9.538; 0) | 200 | 4172 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 930 | 0 (None / None / None; 0) | 0 | 1240 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 882 | 0 (None / None / None; 0) | 0 | 2058 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2280 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 2.927 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.033 (0.573; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.0 | 1.0 (0.0, 0.0) | 1.581 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.106 (0.534; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.058 (0.252; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.359) | 6.0 (6.0, 2.275) | 0.053 (0.265; 0) | 0 | 2785 / 1507998 / 0 / 0 |
| translucent_move | 136.372 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.442 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 111.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.148; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.011 (0.168; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.445 / 0.455 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 84.228 / 0.454 | 0.029 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.294 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.862 |
| water_glass | 107.19 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.421 / 52.448 | 0.014 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 109.773 / 6.706 | 0.811 / 0.788 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 42.103 / 7.107 | 0.06 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 83.636 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 102.422 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.157 / 12.171 | 0.005 / 0.014 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.873 / 54.819 | 0.02 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.576 / 10.425 | 0.008 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 102.194 / 7.03 | 1.0 / 0.926 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.81 / 2.653 | 0.017 / 0.012 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 77.118 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.007 / 0.061 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.004 / 0.011 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.983 |
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
| spawn | 13.0 (base 14.05) | 14 (base 15) | 25516 (base 27764) | 249.04 (base 257.2) | 3.71 (base 3.98) |
| flythrough | 13.05 (reported, not gated) | 41 (reported, not gated) | 839728 (reported, not gated) | 303.7 (base 318.06) | 3.46 (base 4.23) |
| water_glass | 9.0 (base 9.0) | 15 (base 15) | 15320 (base 15108) | 233.36 (base 244.39) | 3.71 (base 4.23) |
| nether | 15.92 (base 15.71) | 12 (base 12) | 21436 (base 19912) | 254.49 (base 268.95) | 3.71 (base 4.23) |
| mobs | 19.84 (base 19.97) | 16 (base 17) | 616128 (base 1008176) | 253.07 (base 264.31) | 3.71 (base 6.23) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 6300 (base 6356) | 252.82 (base 264.58) | 3.71 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100632 (base 126356) | 258.07 (base 264.78) | 3.71 (base 3.98) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82524 (reported, not gated) | 258.66 (base 265.16) | 3.71 (base 4.23) |
| translucent_move | 9.0 (reported, not gated) | 15 (reported, not gated) | 10816 (reported, not gated) | 260.77 (base 268.35) | 3.71 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 15544 (base 15024) | 232.49 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10892 (reported, not gated) | 235.01 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 18.94 (base 18.96) | 15 (base 15) | 10168 (base 9864) | 235.53 (base 248.07) | 3.46 (base 5.98) |
| renderer_off | 7.68 (base 7.83) | 14 (base 14) | 7296 (base 7180) | 228.29 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9204 (base 17128) | 255.96 (base 261.4) | 3.71 (base 5.98) |
| animation | 49 median (avg 39.94) (base 49) | 15 (base 15) | 2224 (base 2056) | 253.21 (base 260.68) | 3.71 (base 5.98) |
| animated_items | 60 median (avg 46.76) (base 60) | 24 (base 23) | 22136 (base 21940) | 228.38 (base 239.74) | 3.71 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.0 / 13 (10.07) | 123.0 / 123 (8.99) | median and average, x 1.10 + 2 |
| flythrough | 13.05 / 13 (6.16) | 123.05 / 123 (5.48) | median and average, at most vanilla + 2 |
| water_glass | 9.0 / 9 (18.89) | 124.0 / 124 (15.13) | median, at most vanilla |
| nether | 15.92 / 16 (17.99) | 120.92 / 121 (14.86) | median, x 1.10 + 2 |
| mobs | 19.84 / 20 (23.93) | 134.0 / 134 (18.82) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.46 / 133 (29.96) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (29.94) | 95.05 / 133 (29.7) | median and average, x 1.10 + 2 |
| translucent_move | 9.0 / 9 (19.01) | 124.0 / 124 (15.78) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (9.46) | 129.0 / 129 (8.48) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (8.87) | 129.0 / 129 (7.81) | median and average, at most vanilla |
| flat_plants | 18.94 / 19 (19.43) | 124.0 / 124 (15.6) | median, x 1.10 + 2 |
| renderer_off | 7.68 / 8 (29.48) | 109.43 / 123 (22.68) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 39.94 / 49 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 46.76 / 60 (30.0) | 155.65 / 190 (29.95) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 40.0 / 23.224 | 40.0 / 23.224 | 0.0 / 0.0 | 416.0 / 38.109 |
| flythrough | 112.0 / 84.154 | 112.0 / 84.154 | 0.0 / 0.0 | 416.0 / 143.424 |
| water_glass | 40.0 / 12.333 | 40.0 / 12.333 | 0.0 / 0.0 | 416.0 / 21.407 |
| nether | 20.0 / 15.207 | 20.0 / 15.207 | 0.0 / 0.0 | 256.0 / 26.666 |
| mobs | 16.0 / 9.471 | 16.0 / 9.471 | 0.0 / 0.0 | 256.0 / 16.57 |
| outline | 16.0 / 1.261 | 16.0 / 1.261 | 0.0 / 0.0 | 256.0 / 2.229 |
| occlusion | 20.0 / 2.414 | 20.0 / 2.414 | 0.0 / 0.0 | 416.0 / 4.169 |
| occlusion_move | 20.0 / 3.215 | 20.0 / 3.215 | 0.0 / 0.0 | 416.0 / 5.69 |
| translucent_move | 28.0 / 12.8 | 28.0 / 12.8 | 0.0 / 0.0 | 416.0 / 22.407 |
| water_glass_oit | 20.0 / 12.333 | 20.0 / 12.333 | 0.0 / 0.0 | 416.0 / 21.407 |
| translucent_move_oit | 28.0 / 12.443 | 28.0 / 12.443 | 0.0 / 0.0 | 416.0 / 21.776 |
| flat_plants | 24.0 / 13.899 | 24.0 / 13.899 | 0.0 / 0.0 | 416.0 / 24.157 |
| renderer_off | 24.0 / 8.408 | 24.0 / 8.408 | 0.0 / 0.0 | 416.0 / 14.782 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 520465.134 (703712.289) | 26.04 | 1.155 | 457068 / 776940 | 431552 (2097152.0) | 201 / 179 | 0.0 / 0 |
| flythrough | 548106.585 (876882.504) | 37.494 | 1.083 | 2123256 / 7534220 | 2095344 (2097152.0) | 123 / 109 | 9.371 / 74 |
| water_glass | 214050.271 (383446.408) | 44.177 | 1.117 | 16552 / 17256 | 0 (2097152.0) | 377 / 302 | 0.0 / 0 |
| nether | 319447.733 (477759.487) | 33.136 | 1.274 | 146012 / 251852 | 124800 (2097152.0) | 359 / 297 | 0.0 / 0 |
| mobs | 164315.038 (296228.431) | 44.531 | 0.99 | 616128 / 616168 | 0 (2097152.0) | 14 / 373 | 0.0 / 0 |
| outline | 23859.634 (39723.987) | 39.936 | 1.0 | 6300 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 43264.107 (75391.653) | 42.614 | 1.214 | 100632 / 126324 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 47823.355 (83472.722) | 42.708 | 1.239 | 666740 / 1232496 | 589952 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 198189.853 (351536.789) | 43.622 | 1.183 | 766592 / 1333924 | 756224 (2097152.0) | 311 / 315 | 0.0 / 0 |
| water_glass_oit | 214613.545 (384455.45) | 44.177 | 1.117 | 17560 / 17032 | 0 (2097152.0) | 189 / 169 | 0.0 / 0 |
| translucent_move_oit | 198332.678 (351527.266) | 43.58 | 1.182 | 737984 / 1281600 | 726016 (2097152.0) | 177 / 156 | 0.0 / 0 |
| flat_plants | 237259.923 (434587.191) | 45.406 | 1.06 | 10280 / 9884 | 0 (2097152.0) | 287 / 312 | 0.0 / 0 |
| renderer_off | 146446.214 (264850.9) | 44.706 | 1.015 | 7296 / 7236 | 0 (2097152.0) | 0 / 13 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 9204 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86740 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2271.78 (4890.137) | 53.544 | 1.0 | 79864 / 123000 | 57728 (2097152.0) | 2 / 3 | 0.0 / 0 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.015 | 805.99 | 16 (vanilla 28) | 1400724 | 41.582 / 0.091 | 23.224 / 40.0 | 37.403 | 2464 / 0 | 3.617 (5.933) |
| flythrough | indirect, one multi-draw per arena and layer | 3.024 | 886.902 | 16 (vanilla 28) | 5092664 | 15.23 / 0.98 | 84.154 / 112.0 | 135.989 | 6393 / 0 | 8.313 (21.512) |
| water_glass | indirect, one multi-draw per arena and layer | 3.008 | 273.724 | 16 (vanilla 28) | 764864 | 33.974 / 0.085 | 12.333 / 40.0 | 20.424 | 3114 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.006 | 468.301 | 16 (vanilla 28) | 952928 | 28.569 / 0.165 | 15.207 / 20.0 | 25.446 | 4142 / 0 | 2.507 (2.974) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 197.412 | 16 (vanilla 28) | 591220 | 26.033 / 0.145 | 9.471 / 16.0 | 15.787 | 4580 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 2.003 | 42.07 | 16 (vanilla 28) | 79316 | 25.612 / 0.145 | 1.261 / 16.0 | 2.118 | 4674 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 70.117 | 16 (vanilla 28) | 150532 | 24.517 / 0.138 | 2.414 / 20.0 | 4.02 | 4907 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.005 | 75.453 | 16 (vanilla 28) | 200984 | 23.411 / 0.132 | 3.215 / 20.0 | 5.367 | 5162 / 0 | 5.249 (12.786) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.008 | 247.545 | 16 (vanilla 28) | 789572 | 20.405 / 0.121 | 12.8 / 28.0 | 21.084 | 5918 / 0 | 5.513 (10.632) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.026 | 282.487 | 16 (vanilla 28) | 764864 | 7.609 / 0.042 | 12.333 / 20.0 | 20.424 | 1081 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.028 | 262.056 | 16 (vanilla 28) | 767048 | 6.714 / 0.107 | 12.443 / 28.0 | 20.482 | 2407 / 0 | 5.238 (13.479) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.008 | 284.732 | 16 (vanilla 28) | 866940 | 6.154 / 0.01 | 13.899 / 24.0 | 23.15 | 926 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 204.346 | 16 (vanilla 28) | 528804 | 2.462 / 0.021 | 8.408 / 24.0 | 14.121 | 597 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 12.02 | 16 (vanilla 28) | 8416 | 20.348 / 0.12 | 0.131 / 28.0 | 0.225 | 5964 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 20.174 / 0.119 | 0.302 / 28.0 | 0.518 | 6066 / 0 | 1.691 (2.245) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 20.113 / 0.12 | 0.153 / 28.0 | 0.261 | 6115 / 0 | 0.941 (1.277) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 157.0 | 1.0 | 0.0 | 0 | 0 | 43 (0.023 / 0.036 / 0.037; 0) | 0 | 31714 / 0 / 0 |
| flythrough | 186.04 | 1.0 | 0.0 | 0 | 0 | 832 (0.016 / 0.051 / 0.16; 0) | 43 | 23069 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1512 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.012 / 0.017; 0) | 32 | 1198 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.097 / 0.153 / 0.184; 0) | 180 | 2667 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 570 | 0 (None / None / None; 0) | 0 | 760 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 534 | 0 (None / None / None; 0) | 0 | 1246 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1556 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2360 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.028 (0.076; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 427.742 | 1.0 (0.0, 0.0) | 1.637 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.061; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.117 (0.214; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.06 (0.094; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.356 | 10.0 (9.0, 2.362) | 6.0 (6.0, 2.28) | 0.055 (0.268; 0) | 0 | 2781 / 1505570 / 0 / 0 |
| translucent_move | 135.121 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.438 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 111.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.005 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 133.372 / 0.0 | 0.021 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.443 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.831 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 49.424 / 49.439 | 0.016 / 0.018 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 10.0 | 0.923 / 0.922 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.695 / 13.175 | 0.085 / 0.012 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 77.378 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.633 / 11.575 | 0.005 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.331 / 52.242 | 0.011 / 0.019 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.08 / 14.017 | 0.005 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 10.0 | 1.0 / 0.943 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.584 / 2.452 | 0.015 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 101.545 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.003 / 0.029 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.279 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.795 | 0.003 / 0.005 | 56 (3) | 40.58 / 9.243 / 31.338 | 3 / 0 | 10.985 |
| animated_items | 136.985 / 28.09 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.564 / 7.98 / 32.584 | 0 / 0 | 9.0 |

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
| factory | 0.0 | 0.3 | 0.0169 | 0.0171 | 0.0002 |
| factory_flat | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0025 | 0.55 | 0.0065 | 0.0059 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan |
|---|---|---|---|---|---|
| factory | 95.56 | 500 | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) |
| mam | 88.16 | 10 | 0 (0) | 0 (20) | 0 (10509) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 38 (4275) | 36 (4273) | None (None) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0 / 0 | 0.0171 / 0 | 0.0002 / 0 |
| factory_flat | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0039 / 22 | 0.0027 / 17 | skipped |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.24 (base 12.22) | 15 (base 15) | 6956 (base 6976) | 361.12 (base 361.48) | 4.24 (base 5.48) |
| factory_flat | 11.68 (reported, not gated) | 15 (base 15) | 6844 (base 6844) | 360.04 (base 360.51) | 3.48 (base 5.48) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 379.39 (base 379.72) | 4.24 (base 5.87) |
| hub | 21.55 (base 21.53) | 16 (base 16) | 66576 (base 66576) | 391.42 (base 392.33) | 4.24 (base 5.48) |
| mam | 22.51 (base 22.53) | 19 (base 19) | 23748 (base 23748) | 404.66 (base 405.55) | 4.24 (base 8.12) |
| ponder | 87.23 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 403.21 (base 404.14) | 4.24 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 17 (base 17) | 43404 (base 44728) | 392.15 (base 392.95) | 4.06 (base 8.24) |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 393.23 (base 394.1) | 4.06 (base 10.24) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.24 / 12 (28.17) | 108.79 / 152 (28.53) | median and average, x 1.10 + 2 |
| factory_flat | 11.68 / 12 (29.25) | 105.87 / 152 (29.68) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (15.35) | 153.0 / 153 (15.31) | median, x 1.10 + 2 |
| hub | 21.55 / 21 (29.39) | 115.5 / 161 (29.8) | median and average, x 1.10 + 2 |
| mam | 22.51 / 22 (29.56) | 118.13 / 162 (29.15) | median, x 1.10 + 2 |
| ponder | 87.23 / 87 (29.95) | 181.03 / 227 (29.85) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.99) | 118.11 / 164 (29.63) | median, at most vanilla |
| create_ct | 6.67 / 7 (29.91) | 100.24 / 147 (29.9) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.894 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.315 | 32.0 / 20.315 | 0.0 / 0.0 | 416.0 / 33.606 |
| ponder | 32.0 / 17.566 | 32.0 / 17.566 | 0.0 / 0.0 | 416.0 / 28.775 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26339.503 (48132.945) | 45.278 | 1.0 | 114684 / 190188 | 100928 (2097152.0) | 21 / 11 | 0.0 / 0 |
| factory_flat | 26339.024 (48132.277) | 45.278 | 1.0 | 6844 / 6844 | 0 (2097152.0) | 4 / 2 | 0.0 / 0 |
| sift | 147749.707 (205055.765) | 27.947 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 307 / 306 | 0.0 / 0 |
| hub | 33472.927 (58846.078) | 43.118 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 14 / 3 | 0.0 / 0 |
| mam | 66880.975 (117396.305) | 43.03 | 1.011 | 304852 / 304832 | 0 (2097152.0) | 5 / 5 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| hologram | 3910.518 (6871.452) | 43.09 | 1.0 | 45736 / 45512 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 1 / 3 | 0.0 / 0 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.004 | 74.131 | 16 (vanilla 28) | 96100 | 26.188 / 0.239 | 1.511 / 28.0 | 2.566 | 1701 / 0 | 4.877 (10.848) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.127 | 16 (vanilla 28) | 96100 | 1.156 / 0.004 | 1.511 / 12.0 | 2.566 | 162 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 430.397 | 16 (vanilla 28) | 462640 | 23.874 / 0.281 | 7.39 / 16.0 | 12.354 | 2710 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.085 | 16 (vanilla 28) | 117492 | 23.086 / 0.271 | 1.879 / 12.0 | 3.137 | 2797 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.147 | 16 (vanilla 28) | 1193152 | 23.785 / 0.311 | 20.315 / 32.0 | 31.861 | 3447 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019160 | 23.785 / 0.311 | 17.566 / 32.0 | 27.215 | 3448 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 13.022 | 16 (vanilla 28) | 13744 | 23.623 / 0.307 | 0.238 / 32.0 | 0.367 | 3506 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.228 / 0.301 | 0.171 / 32.0 | 0.283 | 3603 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1848 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 588 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 592 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.046; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.007; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 96.526 / 0.0 | 0.574 / 0.544 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.676 / 10.587 | 0.02 / 0.009 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.199 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.96 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 95.575 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 94.435 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 142.865 / 89.193 | 0.128 / 0.045 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.39 / 574.28 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.84 / 13.87 | 1.0 / 1.0 | 112.32 / 113.24 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.84 / 13.87 (8.0 / 8.0) |
| ponder | 82.57 / 82.56 | 0.11 / 0.11 | 203.73 / 203.45 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.59 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 20.2 (base 20.24) | 13 (base 13) | 49024 (base 49024) | 361.13 (base 361.53) | 3.99 (base 5.48) |
| factory_flat | 19.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 359.38 (base 360.27) | 3.48 (base 5.48) |
| sift | 38.44 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 379.1 (base 379.69) | 3.99 (base 4.24) |
| hub | 25.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 391.22 (base 392.07) | 3.99 (base 5.99) |
| mam | 24.52 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 404.93 (base 404.98) | 5.99 (base 7.73) |
| ponder | 87.23 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 403.8 (base 403.64) | 5.99 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43540 (base 43652) | 392.27 (base 392.54) | 5.81 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 393.26 (base 393.74) | 5.81 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 20.2 / 20 (29.98) | 179.73 / 226 (29.98) | median and average, x 1.10 + 2 |
| factory_flat | 19.67 / 20 (30.01) | 178.92 / 226 (30.0) | median and average, x 1.10 + 2 |
| sift | 38.44 / 41 (25.99) | 551.6 / 579 (24.72) | median, x 1.10 + 2 |
| hub | 25.54 / 25 (30.0) | 161.72 / 208 (30.01) | median and average, x 1.10 + 2 |
| mam | 24.52 / 24 (29.96) | 200.16 / 246 (29.87) | median, x 1.10 + 2 |
| ponder | 87.23 / 87 (30.02) | 180.83 / 227 (29.9) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.99) | 127.92 / 175 (29.99) | median, at most vanilla |
| create_ct | 6.67 / 7 (29.98) | 110.92 / 158 (30.0) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.56 | 12.0 / 1.56 | 0.0 / 0.0 | 416.0 / 2.815 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.894 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.316 | 32.0 / 20.316 | 0.0 / 0.0 | 416.0 / 34.188 |
| ponder | 32.0 / 17.565 | 32.0 / 17.565 | 0.0 / 0.0 | 416.0 / 29.267 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26336.63 (48127.697) | 45.278 | 1.0 | 156752 / 233360 | 100928 (2097152.0) | 1 / 0 | 0.0 / 0 |
| factory_flat | 26337.896 (48130.217) | 45.278 | 1.0 | 48916 / 50020 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| sift | 145741.735 (204783.058) | 28.831 | 1.434 | 4148 / 8052 | 0 (2097152.0) | 13 / 15 | 0.0 / 0 |
| hub | 33471.693 (58843.91) | 43.118 | 1.02 | 83908 / 84516 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| mam | 66873.27 (117383.313) | 43.03 | 1.011 | 40068 / 40948 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| hologram | 3910.507 (6871.433) | 43.09 | 1.0 | 45668 / 44916 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 8.013 | 74.123 | 16 (vanilla 28) | 96100 | 27.352 / 0.338 | 1.511 / 28.0 | 2.566 | 1858 / 0 | 2.841 (4.098) |
| factory_flat | plain, one multi-draw per region and layer | 8.013 | 74.124 | 16 (vanilla 28) | 99144 | 1.098 / 0.004 | 1.56 / 12.0 | 2.647 | 176 / 0 | None (None) |
| sift | plain, one multi-draw per region and layer | 21.04 | 429.825 | 16 (vanilla 28) | 462640 | 24.885 / 0.359 | 7.39 / 16.0 | 12.354 | 2868 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 7.012 | 50.083 | 16 (vanilla 28) | 117492 | 24.145 / 0.347 | 1.879 / 12.0 | 3.137 | 2954 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 5.008 | 87.145 | 16 (vanilla 28) | 1193360 | 24.626 / 0.37 | 20.316 / 32.0 | 31.866 | 3606 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019208 | 24.626 / 0.37 | 17.565 / 32.0 | 27.216 | 3607 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 3.005 | 13.022 | 16 (vanilla 28) | 13744 | 24.416 / 0.364 | 0.238 / 32.0 | 0.367 | 3671 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.963 / 0.358 | 0.171 / 32.0 | 0.283 | 3779 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 3126 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.108; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.489 / 0.0 | 0.569 / 0.53 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.893 / 10.849 | 0.016 / 0.008 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 112.794 / 7.673 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.255 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 156.294 / 95.141 | 0.094 / 0.036 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.88 | 0.0 / 0.0 | 574.48 / 574.78 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| mam | 13.86 / 13.85 | 1.0 / 1.0 | 112.92 / 112.46 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.85 (8.0 / 8.0) |
| ponder | 82.56 / 82.59 | 0.11 / 0.0 | 203.64 / 203.77 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.59 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 14.19 (base 14.25) | 15 (base 15) | 51516 (base 51624) | 360.69 (base 360.8) | 5.98 (base 5.46) |
| factory_flat | 13.67 (reported, not gated) | 15 (base 15) | 51500 (base 51500) | 359.03 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 19192 (base 81788) | 379.12 (base 379.18) | 5.98 (base 5.46) |
| hub | 21.53 (base 21.57) | 16 (base 16) | 66576 (base 66576) | 391.13 (base 391.05) | 5.98 (base 5.46) |
| mam | 22.52 (base 22.55) | 19 (base 19) | 23748 (base 23748) | 404.61 (base 404.61) | 5.98 (base 7.71) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 403.32 (base 403.47) | 5.98 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 395.76 (base 395.99) | 5.79 (base 8.29) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 14.19 / 14 (29.56) | 111.09 / 154 (28.58) | median and average, x 1.10 + 2 |
| factory_flat | 13.67 / 14 (29.74) | 107.87 / 154 (29.63) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (14.64) | 153.0 / 153 (13.27) | median, x 1.10 + 2 |
| hub | 21.53 / 21 (29.36) | 116.39 / 161 (29.32) | median and average, x 1.10 + 2 |
| mam | 22.52 / 22 (29.7) | 123.64 / 162 (27.63) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.87) | 181.04 / 227 (29.82) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (29.99) | 100.0 / 147 (29.99) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.894 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.317 | 32.0 / 20.317 | 0.0 / 0.0 | 416.0 / 34.115 |
| ponder | 32.0 / 17.572 | 32.0 / 17.572 | 0.0 / 0.0 | 416.0 / 29.202 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 26337.306 (48128.934) | 45.278 | 1.0 | 159336 / 234840 | 100928 (2097152.0) | 7 / 13 | 0.0 / 0 |
| factory_flat | 26338.266 (48130.892) | 45.278 | 1.0 | 51500 / 51500 | 0 (2097152.0) | 4 / 2 | 0.0 / 0 |
| sift | 147774.349 (205089.966) | 27.947 | 1.298 | 19192 / 16632 | 0 (2097152.0) | 292 / 265 | 0.0 / 0 |
| hub | 33472.83 (58845.908) | 43.118 | 1.02 | 85536 / 85516 | 0 (2097152.0) | 10 / 3 | 0.0 / 0 |
| mam | 66790.064 (117216.672) | 43.02 | 1.011 | 42708 / 42688 | 0 (2097152.0) | 16 / 16 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61224 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 74.125 | 16 (vanilla 28) | 96100 | 26.596 / 0.252 | 1.511 / 28.0 | 2.566 | 1911 / 0 | 3.728 (6.453) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 74.125 | 16 (vanilla 28) | 96100 | 1.156 / 0.004 | 1.511 / 12.0 | 2.566 | 162 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 430.469 | 16 (vanilla 28) | 462640 | 24.365 / 0.289 | 7.39 / 16.0 | 12.354 | 2922 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 3.005 | 50.085 | 16 (vanilla 28) | 117492 | 23.669 / 0.28 | 1.879 / 12.0 | 3.137 | 3003 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 3.005 | 87.146 | 16 (vanilla 28) | 1193288 | 24.21 / 0.315 | 20.317 / 32.0 | 31.864 | 3654 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019472 | 24.21 / 0.315 | 17.572 / 32.0 | 27.223 | 3655 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.772 / 0.31 | 0.171 / 32.0 | 0.283 | 3761 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1758 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 589 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 596 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 96.848 / 0.0 | 0.548 / 0.519 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.519 / 10.514 | 0.017 / 0.008 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.199 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.846 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 101.083 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.86 / 13.87 | 0.0 / 0.0 | 574.06 / 574.4 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| mam | 13.85 / 13.84 | 1.0 / 1.0 | 112.66 / 111.95 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.85 / 13.84 (8.0 / 8.0) |
| ponder | 82.57 / 82.56 | 0.11 / 0.0 | 203.83 / 203.54 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.59 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 9.43 | 126.08 | 188 | 123 | 1570032 | [] |
| bench-plain | flythrough | 5.66 | 429.87 | 113 | 123 | 8078164 | [] |
| bench-plain | water_glass | 16.29 | 71.97 | 325 | 124 | 16808 | [] |
| bench-plain | nether | 15.96 | 73.49 | 319 | 121 | 248140 | [] |
| bench-sodium | spawn | 18.27 | 59.82 | 361 | 147 | 3440 | [] |
| bench-sodium | flythrough | 13.47 | 162.55 | 269 | 159 | 266476 | [] |
| bench-sodium | water_glass | 29.97 | 37.37 | 0 | 135 | 9788 | [] |
| bench-sodium | nether | 30.0 | 37.64 | 0 | 129 | 263664 | [] |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-plain | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-plain | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-plain | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-sodium | spawn | 5.48 | 5.48 (0) | 5.48 |  |
| core-bench-sodium | water_glass | 5.48 | 5.48 (0) | 5.48 |  |
| core-bench-sodium | nether | 5.35 | 5.35 (0) | 5.35 |  |
| core-bench-sodium | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | spawn | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | water_glass | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | nether | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | mobs | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | outline | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | occlusion | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | occlusion_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | spawn | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | water_glass | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | nether | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | mobs | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | outline | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | occlusion | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | occlusion_move | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-old | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-old | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-old | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-old | flat_plants | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-vk | spawn | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | water_glass | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | nether | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | mobs | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | outline | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | occlusion | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | occlusion_move | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | translucent_move | 5.46 | 5.46 (0) | 5.46 |  |
| core-measure-vk | particles | 5.46 | 5.46 (0) | 5.46 |  |
| core-measure-vk | animation | 5.46 | 5.46 (0) | 5.46 |  |
| core-measure-vk | animated_items | 5.46 | 5.46 (0) | 5.46 |  |
| core-measure-vk | flat_plants | 3.45 | 3.45 (0) | 3.45 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | water_glass_oit | 3.34 | 3.34 (0) | 3.34 |  |
| core-measure-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | flythrough | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-full | spawn | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | water_glass | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | nether | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | mobs | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | outline | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | occlusion | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-full | occlusion_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-full | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-full | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-full | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-full | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-full | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-full | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | spawn | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | water_glass | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | nether | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | mobs | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | outline | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | occlusion | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | occlusion_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-vk | spawn | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | water_glass | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | nether | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | mobs | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | outline | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | occlusion | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | occlusion_move | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | translucent_move | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | particles | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | animation | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | animated_items | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | flythrough | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-measure-full | factory | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-full | sift | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-full | hub | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-full | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-full | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-full | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-full | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-vk | factory | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | sift | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | hub | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | mam | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | ponder | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | create_ct | 5.79 | 5.79 (0) | 5.79 |  |
| siftec-measure-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | mam | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | ponder | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | hologram | 4.06 | 4.06 (0) | 4.06 |  |
| siftec-quicksilver-full | create_ct | 4.06 | 4.06 (0) | 4.06 |  |
| siftec-quicksilver-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-old | sift | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-old | hub | 3.99 | 3.99 (0) | 3.99 |  |
| siftec-quicksilver-old | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-old | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-vk | factory | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | sift | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | hub | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | mam | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | ponder | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | create_ct | 5.79 | 5.79 (0) | 5.79 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |

Rises of 4 MB or more: siftec-measure-old/mam: between scenes +4.00

