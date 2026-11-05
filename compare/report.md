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
- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
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
- old-gpu-2p: 0 / 0

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % | old-GPU two-phase % |
|---|---|---|---|---|---|---|
| spawn | 0.443 | 10.05 | 0.4437 | 0.0615 | 0.4395 | 0.053 |
| flythrough | 0.0 | 14.95 | 0.0011 | 0.0011 | 0.0012 | 0.0011 |
| water_glass | 0.0044 | 6.45 | 0.0048 | 0.004 | 0.0035 | 0.0039 |
| nether | 0.0068 | 0.8 | 0.0072 | 0.0317 | 0.0003 | 0.032 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 | 0.0 | 0.0 |
| outline | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| occlusion_move | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.open | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.closed | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2300 | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2297 | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2305 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2309 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_open | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2944 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2930 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2916 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| translucent_move | 0.0001 | 0.3 | 0.0001 | 0.0003 | 0.0 | 0.0001 |
| translucent_move.x2404 | 0.0002 | 0.3 | 0.0004 | 0.0005 | 0.0004 | 0.0003 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0002 | 0.0003 | 0.0001 | 0.0002 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0004 | 0.0003 | 0.0002 | 0.0003 |
| translucent_move.low | 0.0011 | 0.3 | 0.0014 | 0.0012 | 0.0013 | 0.0011 |
| translucent_move.back | 0.0 | 0.3 | 0.0001 | 0.0 | 0.0 | 0.0001 |
| translucent_move.bare_back | 0.0 | 0.3 | 0.0001 | 0.0001 | 0.0 | 0.0 |
| water_glass_oit | 0.0049 | 0.3 | 0.005 | 0.0058 | 0.0048 | 0.0055 |
| translucent_move_oit | 0.0001 | 0.3 | 0.0001 | 0.0 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0004 | 0.3 | 0.0005 | 0.0003 | 0.0005 | 0.0005 |
| translucent_move_oit.x2414 | 0.0 | 0.3 | 0.0001 | 0.0004 | 0.0003 | 0.0001 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0003 | 0.0001 | 0.0004 | 0.0003 |
| translucent_move_oit.low | 0.0003 | 0.3 | 0.0014 | 0.0013 | 0.0016 | 0.0014 |
| translucent_move_oit.back | 0.0 | 0.3 | 0.0 | 0.0001 | 0.0001 | 0.0003 |
| translucent_move_oit.bare_back | 0.0002 | 0.3 | 0.0001 | 0.0001 | 0.0 | 0.0001 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 | 0.0226 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| spawn | 92.6 | 18057 | 267 (773) | 260 (777) | 248 (769) | 230 (714) |
| flythrough | 97.31 | 6020 | 47 (293) | 47 (293) | 51 (294) | 47 (293) |
| water_glass | 95.81 | 25508 | 17 (2615) | 16 (2615) | 18 (2729) | 19 (2616) |
| nether | 99.38 | 905 | 3 (458) | 3 (458) | 3 (470) | 6 (461) |
| mobs | 99.39 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| outline | 98.19 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| outline.bare | 98.2 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion | 98.62 | 22 | 1 (74) | 1 (74) | 1 (74) | 1 (74) |
| occlusion_move | 99.15 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2297 | 98.94 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2305 | 98.96 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2309 | 99.13 | 32 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.open | 98.55 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.closed | 98.92 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2300 | 98.89 | 90 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2297 | 98.92 | 70 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2305 | 98.95 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2309 | 99.1 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_open | 98.5 | 110 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner | 95.9 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner.x-2944 | 95.57 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner.x-2930 | 93.72 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner.x-2916 | 94.04 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| translucent_move | 96.93 | 13 | 2 (78) | 3 (78) | 3 (69) | 1 (76) |
| translucent_move.x2404 | 95.93 | 15 | 3 (103) | 5 (105) | 4 (88) | 4 (104) |
| translucent_move.x2414 | 95.86 | 13 | 1 (104) | 3 (107) | 2 (100) | 2 (105) |
| translucent_move.x2424 | 96.74 | 13 | 3 (80) | 2 (80) | 2 (68) | 1 (78) |
| translucent_move.low | 96.11 | 41 | 17 (24) | 15 (21) | 15 (18) | 12 (18) |
| translucent_move.back | 96.93 | 13 | 2 (77) | 1 (76) | 1 (67) | 2 (77) |
| translucent_move.bare_back | 96.9 | 13 | 3 (79) | 2 (78) | 1 (67) | 2 (77) |
| water_glass_oit | 95.8 | 57 | 23 (2624) | 21 (2622) | 21 (2734) | 19 (2620) |
| translucent_move_oit | 96.93 | 12 | 1 (76) | 3 (78) | 1 (67) | 1 (76) |
| translucent_move_oit.x2404 | 95.93 | 16 | 6 (108) | 5 (105) | 6 (90) | 5 (105) |
| translucent_move_oit.x2414 | 95.86 | 10 | 2 (105) | 6 (110) | 4 (101) | 3 (106) |
| translucent_move_oit.x2424 | 96.74 | 15 | 3 (80) | 1 (78) | 5 (71) | 3 (80) |
| translucent_move_oit.low | 96.11 | 40 | 14 (21) | 13 (18) | 16 (19) | 13 (18) |
| translucent_move_oit.back | 96.93 | 12 | 1 (76) | 4 (80) | 2 (69) | 5 (80) |
| translucent_move_oit.bare_back | 96.9 | 15 | 3 (78) | 1 (76) | 2 (68) | 2 (77) |
| flat_plants | 98.22 | 350 | 225 (7416) | 225 (7416) | 217 (7347) | 225 (7416) |
| renderer_off | 99.2 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| particles | 99.99 | 4 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| particles.bare | 99.99 | 4 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| animation | 99.62 | 10 | 1 (3) | 1 (3) | 1 (3) | 1 (3) |
| animation.behind | 99.74 | 10 | 0 (2) | 0 (2) | 0 (1) | 0 (2) |
| animation.front | 99.62 | 10 | 1 (3) | 1 (3) | 1 (3) | 1 (3) |
| animated_items | 98.9 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| spawn | 0.205 / 338 | 0.2048 / 246 | 0.0701 / 351 | 0.2048 / 246 |
| flythrough | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0044 / 20 | 0.0041 / 17 | 0.0039 / 22 | 0.0041 / 17 |
| nether | 0.0068 / 0 | 0.0314 / 0 | 0.0 / 0 | 0.0314 / 0 |
| mobs | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| outline | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| outline.bare | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.x2297 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.x2305 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.x2309 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.open | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.closed | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2300 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2297 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2305 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_x2309 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_move.bare_open | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_corner | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_corner.x-2944 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_corner.x-2930 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| occlusion_corner.x-2916 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| translucent_move | 0.0002 / 1 | 0.0003 / 2 | 0.0 / 1 | 0.0003 / 2 |
| translucent_move.x2404 | 0.0002 / 0 | 0.0004 / 5 | 0.0003 / 3 | 0.0004 / 5 |
| translucent_move.x2414 | 0.0001 / 1 | 0.0001 / 1 | 0.0001 / 3 | 0.0001 / 1 |
| translucent_move.x2424 | 0.0001 / 1 | 0.0003 / 2 | 0.0 / 1 | 0.0003 / 2 |
| translucent_move.low | 0.0003 / 0 | 0.0004 / 4 | 0.0002 / 0 | 0.0004 / 4 |
| translucent_move.back | 0.0 / 0 | 0.0 / 0 | 0.0001 / 1 | 0.0 / 0 |
| translucent_move.bare_back | 0.0001 / 0 | 0.0 / 1 | 0.0 / 0 | 0.0 / 1 |
| water_glass_oit | 0.0041 / 18 | 0.0052 / 16 | 0.0041 / 18 | 0.0052 / 16 |
| translucent_move_oit | 0.0003 / 4 | 0.0 / 1 | 0.0002 / 2 | 0.0 / 1 |
| translucent_move_oit.x2404 | 0.0002 / 1 | 0.0002 / 2 | 0.0002 / 0 | 0.0002 / 2 |
| translucent_move_oit.x2414 | 0.0002 / 2 | 0.0 / 0 | 0.0002 / 1 | 0.0 / 0 |
| translucent_move_oit.x2424 | 0.0002 / 1 | 0.0002 / 2 | 0.0001 / 0 | 0.0002 / 2 |
| translucent_move_oit.low | 0.0004 / 3 | 0.0008 / 6 | 0.0007 / 1 | 0.0008 / 6 |
| translucent_move_oit.back | 0.0 / 0 | 0.0001 / 2 | 0.0001 / 1 | 0.0001 / 2 |
| translucent_move_oit.bare_back | 0.0002 / 2 | 0.0001 / 0 | 0.0 / 0 | 0.0001 / 0 |
| flat_plants | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| renderer_off | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| particles | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| particles.bare | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation.behind | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation.front | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animated_items | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, core full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 15.01 (base 13.6) | 15 (base 14) | 27244 (base 22476) | 253.25 (base 259.07) | 5.99 (base 3.99) |
| flythrough | 15.71 (reported, not gated) | 41 (reported, not gated) | 636664 (reported, not gated) | 308.45 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 9.89 (base 8.97) | 15 (base 15) | 11920 (base 15576) | 238.16 (base 250.02) | 5.99 (base 5.99) |
| nether | 13.86 (base 15.63) | 12 (base 12) | 10588 (base 19648) | 259.55 (base 273.53) | 5.99 (base 5.99) |
| mobs | 20.73 (base 19.77) | 16 (base 17) | 613388 (base 1010948) | 257.9 (base 268.37) | 5.99 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 257.73 (base 264.69) | 5.99 (base 5.48) |
| occlusion | 16.67 (base 15.67) | 15 (base 15) | 100032 (base 126320) | 263.74 (base 265.1) | 5.99 (base 4.24) |
| occlusion_move | 16.93 (reported, not gated) | 15 (reported, not gated) | 81924 (reported, not gated) | 264.0 (base 265.74) | 5.99 (base 4.24) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 268.39 (base 267.71) | 5.99 (base 5.48) |
| translucent_move | 8.91 (reported, not gated) | 15 (reported, not gated) | 5436 (reported, not gated) | 274.55 (base 267.48) | 5.99 (base 5.48) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 11920 (base 14688) | 236.79 (base 245.02) | 3.6 (base 3.73) |
| translucent_move_oit | 14.2 (reported, not gated) | 15 (reported, not gated) | 5360 (reported, not gated) | 239.85 (base 247.19) | 3.73 (base 3.73) |
| flat_plants | 17.24 (base 18.29) | 15 (base 15) | 4608 (base 9812) | 239.09 (base 246.92) | 3.48 (base 3.99) |
| renderer_off | 8.68 (base 7.67) | 14 (base 14) | 3612 (base 7164) | 232.56 (base 241.33) | 3.6 (base 4.12) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 265.46 (base 261.44) | 5.99 (base 5.99) |
| animation | 50 median (avg 40.91) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.97 (base 260.68) | 5.99 (base 5.99) |
| animated_items | 61 median (avg 47.79) (base 60) | 23 (base 23) | 21856 (base 21940) | 236.85 (base 239.81) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 15.01 / 15 (9.64) | 123.51 / 124 (9.34) | median and average, x 1.10 + 2 |
| flythrough | 15.71 / 16 (6.82) | 123.07 / 123 (5.73) | median and average, at most vanilla + 2 |
| water_glass | 9.89 / 10 (21.38) | 124.0 / 124 (16.25) | median, at most vanilla |
| nether | 13.86 / 16 (24.65) | 120.86 / 121 (15.76) | median, x 1.10 + 2 |
| mobs | 20.73 / 21 (27.29) | 132.55 / 134 (19.98) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 16.67 / 17 (29.99) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.93 / 18 (29.97) | 94.27 / 133 (29.99) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (29.99) | 82.33 / 121 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 8.91 / 9 (25.79) | 124.0 / 124 (16.96) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (10.75) | 129.0 / 129 (9.06) | median, at most vanilla |
| translucent_move_oit | 14.2 / 14 (10.71) | 129.0 / 129 (8.63) | median and average, at most vanilla |
| flat_plants | 17.24 / 20 (24.97) | 123.63 / 124 (16.56) | median, x 1.10 + 2 |
| renderer_off | 8.68 / 9 (29.61) | 94.55 / 123 (26.53) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 86.27 / 125 (30.01) | median and average, x 1.10 + 2 |
| animation | 40.91 / 50 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.79 / 61 (30.0) | 155.22 / 190 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 40.0 / 22.81 | 40.0 / 22.81 | 0.0 / 0.0 | 416.0 / 37.785 |
| flythrough | 112.0 / 83.269 | 112.0 / 83.269 | 0.0 / 0.0 | 416.0 / 143.075 |
| water_glass | 40.0 / 12.58 | 40.0 / 12.58 | 0.0 / 0.0 | 416.0 / 21.581 |
| nether | 20.0 / 15.214 | 20.0 / 15.214 | 0.0 / 0.0 | 256.0 / 26.763 |
| mobs | 16.0 / 9.59 | 16.0 / 9.59 | 0.0 / 0.0 | 256.0 / 16.78 |
| outline | 16.0 / 1.326 | 16.0 / 1.326 | 0.0 / 0.0 | 256.0 / 2.355 |
| occlusion | 20.0 / 2.602 | 20.0 / 2.602 | 0.0 / 0.0 | 416.0 / 4.169 |
| occlusion_move | 20.0 / 3.404 | 20.0 / 3.404 | 0.0 / 0.0 | 416.0 / 5.576 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.725 | 28.0 / 12.725 | 0.0 / 0.0 | 416.0 / 21.568 |
| water_glass_oit | 20.0 / 12.429 | 20.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| translucent_move_oit | 28.0 / 12.377 | 28.0 / 12.377 | 0.0 / 0.0 | 416.0 / 20.95 |
| flat_plants | 24.0 / 13.442 | 24.0 / 13.442 | 0.0 / 0.0 | 416.0 / 23.349 |
| renderer_off | 24.0 / 8.429 | 24.0 / 8.429 | 0.0 / 0.0 | 416.0 / 14.796 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 436619.686 (590321.686) | 26.037 | 1.194 | 505024 / 797780 | 477912 (2097152.0) | 191 / 186 | 0.0 / 0 |
| flythrough | 479303.882 (754764.75) | 36.496 | 1.084 | 2284612 / 7841108 | 2094264 (2097152.0) | 136 / 114 | 7.964 / 75 |
| water_glass | 113006.033 (197096.506) | 42.665 | 1.133 | 13824 / 260596 | 0 (2097152.0) | 127 / 324 | 0.0 / 0 |
| nether | 29503.724 (42403.838) | 30.422 | 2.0 | 138076 / 627024 | 128064 (2097152.0) | 123 / 315 | 0.0 / 0 |
| mobs | 62335.96 (111369.601) | 44.028 | 0.967 | 613388 / 861496 | 0 (2097152.0) | 10 / 135 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29557.262 (52110.851) | 43.28 | 1.279 | 254336 / 633424 | 154304 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 22346.127 (39337.726) | 43.194 | 1.259 | 654956 / 1112060 | 578816 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21841.285 (47200.651) | 53.727 | 1.214 | 35396 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21656.493 (27729.619) | 21.901 | 1.005 | 744396 / 1304360 | 739776 (2097152.0) | 129 / 339 | 0.0 / 0 |
| water_glass_oit | 113268.832 (197554.86) | 42.665 | 1.133 | 13600 / 260260 | 0 (2097152.0) | 214 / 181 | 0.0 / 0 |
| translucent_move_oit | 21840.075 (28027.065) | 22.075 | 1.005 | 745272 / 1303560 | 739776 (2097152.0) | 214 / 172 | 0.0 / 0 |
| flat_plants | 9102.204 (12478.958) | 27.06 | 1.045 | 5056 / 276596 | 0 (2097152.0) | 125 / 331 | 0.0 / 0 |
| renderer_off | 17461.496 (32773.36) | 46.72 | 1.0 | 3612 / 7292 | 0 (2097152.0) | 43 / 3 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.376 (5146.938) | 41.531 | 1.091 | 86772 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79584 / 123160 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.004 (117) | 3.28 (100) | 1.221 | 4.058 (61) | 0 | 992 / 0 | 9.518 / 13.107 | 5.333 / 7.608 |
| flythrough | 5.452 (1608) | 6.549 (1559) | 0.832 | 5.456 (1606) | 0 | 1407 / 0 | 6.849 / 9.78 | 4.303 / 6.538 |
| water_glass | 2.821 (23) | 2.56 (17) | 1.102 | None (0) | 0 | 1314 / 0 | 8.83 / 11.886 | 4.954 / 6.708 |
| nether | 2.326 (25) | 2.298 (30) | 1.012 | 2.793 (7) | 0 | 1942 / 0 | 7.48 / 10.033 | 4.184 / 5.692 |
| mobs | 2.156 (7) | 1.994 (9) | 1.081 | None (0) | 0 | 2174 / 0 | 7.255 / 9.713 | 3.997 / 5.524 |
| outline | 0.775 (12) | 0.471 (13) | 1.645 | None (0) | 0 | 2233 / 0 | 7.15 / 9.563 | 3.949 / 5.427 |
| occlusion | 1.566 (55) | 1.094 (40) | 1.431 | 4.339 (3) | 0 | 2366 / 0 | 7.014 / 9.334 | 3.755 / 5.269 |
| occlusion_move | 2.115 (78) | 2.115 (61) | 1.0 | 3.505 (24) | 0 | 2517 / 0 | 6.728 / 8.953 | 3.454 / 4.991 |
| occlusion_corner | 1.435 (110) | 1.469 (82) | 0.977 | 1.154 (1) | 0 | 2797 / 0 | 6.249 / 8.281 | 3.017 / 4.409 |
| translucent_move | 3.085 (124) | 3.036 (114) | 1.016 | 5.272 (37) | 0 | 3155 / 0 | 6.111 / 8.092 | 3.085 / 4.426 |
| water_glass_oit | 4.667 (153) | 3.607 (152) | 1.294 | None (0) | 0 | 412 / 0 | 8.639 / 11.677 | 4.939 / 6.375 |
| translucent_move_oit | 3.886 (212) | 4.646 (212) | 0.836 | 5.335 (26) | 0 | 963 / 0 | 5.97 / 8.079 | 3.071 / 4.444 |
| flat_plants | 1.854 (83) | 1.348 (89) | 1.375 | None (0) | 0 | 409 / 0 | 7.483 / 9.617 | 2.99 / 3.905 |
| renderer_off | 0.67 (25) | 0.439 (22) | 1.526 | None (0) | 0 | 327 / 0 | 9.137 / 13.478 | 3.649 / 6.644 |
| particles | 0.391 (30) | 0.251 (24) | 1.558 | None (0) | 0 | 3184 / 0 | 6.063 / 8.026 | 3.029 / 4.378 |
| animation | 0.995 (18) | 0.854 (18) | 1.165 | 1.71 (4) | 0 | 3259 / 0 | 5.947 / 7.868 | 2.914 / 4.199 |
| animated_items | 0.376 (42) | 0.331 (32) | 1.136 | 0.931 (2) | 0 | 3291 / 0 | 5.895 / 7.797 | 2.851 / 4.1 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.021 | 653.503 | 16 (vanilla 28) | 1377176 | 43.243 / 0.094 | 22.81 / 40.0 | 36.775 | 2688 / 0 | 4.058 (9.846) |
| flythrough | indirect, one multi-draw per arena and layer | 4.669 | 760.279 | 16 (vanilla 28) | 5042184 | 15.288 / 0.986 | 83.269 / 112.0 | 134.641 | 6453 / 0 | 5.456 (15.718) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 105.246 | 16 (vanilla 28) | 781264 | 35.542 / 0.086 | 12.58 / 40.0 | 20.862 | 3376 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.087 | 16 (vanilla 28) | 957112 | 30.132 / 0.181 | 15.214 / 20.0 | 25.558 | 4425 / 0 | 2.793 (3.804) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.11 | 16 (vanilla 28) | 599792 | 27.483 / 0.159 | 9.59 / 16.0 | 16.016 | 4869 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 83652 | 27.05 / 0.159 | 1.326 / 16.0 | 2.234 | 4963 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 163096 | 25.719 / 0.151 | 2.602 / 20.0 | 4.355 | 5228 / 0 | 4.339 (4.626) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.873 | 33.902 | 16 (vanilla 28) | 213476 | 24.193 / 0.141 | 3.404 / 20.0 | 5.7 | 5552 / 0 | 3.505 (8.327) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.057 | 60.88 | 16 (vanilla 28) | 122728 | 22.919 / 0.134 | 1.931 / 20.0 | 3.277 | 5941 / 0 | 1.154 (1.152) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.167 | 23.165 | 16 (vanilla 28) | 785620 | 20.036 / 0.123 | 12.725 / 28.0 | 20.978 | 6793 / 0 | 5.272 (13.105) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.023 | 113.528 | 16 (vanilla 28) | 772464 | 7.62 / 0.043 | 12.429 / 20.0 | 20.627 | 1086 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.215 | 37.407 | 16 (vanilla 28) | 763156 | 6.7 / 0.092 | 12.377 / 28.0 | 20.378 | 2413 / 0 | 5.335 (16.395) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.044 | 16 (vanilla 28) | 838656 | 6.415 / 0.01 | 13.442 / 24.0 | 22.395 | 942 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 529380 | 2.504 / 0.021 | 8.429 / 24.0 | 14.136 | 616 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 19.985 / 0.122 | 0.131 / 28.0 | 0.225 | 6839 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 19.836 / 0.121 | 0.302 / 28.0 | 0.518 | 6941 / 0 | 1.71 (2.409) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 19.783 / 0.122 | 0.153 / 28.0 | 0.261 | 6991 / 0 | 0.931 (1.482) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 152.396 | 1.0 | 0.0 | 0 | 0 | 52 (0.025 / 0.036 / 0.047; 0) | 0 | 29260 / 0 / 0 |
| flythrough | 188.241 | 1.0 | 0.0 | 0 | 0 | 852 (0.024 / 0.05 / 6.44; 0) | 49 | 25789 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1712 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.017 / 0.057 / 0.066; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.107 / 0.163 / 0.308; 0) | 180 | 3612 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 645 | 0 (None / None / None; 0) | 0 | 860 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 645 | 0 (None / None / None; 0) | 0 | 1505 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2000 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2368 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 342.417 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.087; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 438.818 | 1.0 (0.0, 0.0) | 1.482 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.064; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.123 (0.254; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.068 (0.114; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.373) | 6.0 (6.0, 2.282) | 0.059 (0.294; 0) | 0 | 2793 / 1513312 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.221 | 1.0 (0.0, 0.0) | 0.779 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.572 | 1.0 (0.0, 0.0) | 0.753 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.59 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 264.7 / 340.39 (22.2) | 264.69 / 75.69 / 0.01 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3633 / 0 |
| flythrough | two-phase | 316.19 / 406.32 (22.2) | 309.2 / 97.12 / 6.99 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3066 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 9116 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 32349 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10200 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3278 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.41 / 51.32 (56.3) | 22.36 / 28.96 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4341 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.85 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3160 / 0 |
| translucent_move | two-phase | 15.7 / 136.08 (88.5) | 15.67 / 120.41 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15536 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4644 / 0 |
| translucent_move_oit | two-phase | 15.73 / 135.94 (88.4) | 15.68 / 120.26 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6377 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 17732 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14948 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 116.655 / 42.474 | 0.028 / 0.02 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.286 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.832 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.743 / 53.734 | 0.023 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.485 | 0.863 / 0.631 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 50.716 / 6.567 | 0.078 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 113.559 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.598 / 12.583 | 0.005 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.589 / 53.651 | 0.012 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.818 / 11.74 | 0.006 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.495 | 0.634 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.548 / 3.254 | 0.017 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 86.792 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.044 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.244 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.004 / 0.009 | 56 (3) | 40.51 / 9.23 / 31.28 | 3 / 0 | 10.977 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| occlusion_corner | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
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
| spawn | 49.72 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 253.53 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 66.84 (reported, not gated) | 44 (reported, not gated) | 639708 (reported, not gated) | 307.43 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.86 (base 20.0) | 13 (base 14) | 7092 (base 10264) | 237.7 (base 249.83) | 3.99 (base 5.99) |
| nether | 23.69 (base 33.79) | 10 (base 11) | 4288 (base 10656) | 258.78 (base 272.57) | 3.99 (base 5.99) |
| mobs | 25.73 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.11 (base 268.23) | 3.99 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.12 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 18.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 262.85 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 24.03 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.31 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.72 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 17.97 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 274.0 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 6980 (base 7604) | 236.12 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 238.97 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 17.13 (base 33.0) | 13 (base 13) | 1604 (base 1716) | 239.45 (base 248.11) | 3.35 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 234.2 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.24 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.04) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.41 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 60 median (avg 47.04) (base 60) | 21 (base 22) | 21508 (base 21668) | 236.2 (base 239.53) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.72 / 50 (9.13) | 875.35 / 875 (10.06) | median and average, x 1.10 + 2 |
| flythrough | 66.84 / 64 (7.02) | 1007.78 / 1012 (5.92) | median and average, at most vanilla |
| water_glass | 19.86 / 20 (21.99) | 389.0 / 389 (16.83) | median, at most vanilla |
| nether | 23.69 / 26 (25.09) | 590.98 / 591 (16.75) | median, x 1.10 + 2 |
| mobs | 25.73 / 26 (27.24) | 320.62 / 329 (21.5) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 127.27 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 18.67 / 19 (30.0) | 162.46 / 201 (29.94) | median and average, x 1.10 + 2 |
| occlusion_move | 24.03 / 24 (29.97) | 167.6 / 202 (29.98) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (29.99) | 163.14 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 17.97 / 18 (18.78) | 370.94 / 370 (17.78) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (10.54) | 400.0 / 400 (8.79) | median, at most vanilla |
| translucent_move_oit | 25.53 / 26 (9.15) | 387.19 / 389 (8.64) | median and average, at most vanilla |
| flat_plants | 17.13 / 20 (25.69) | 404.98 / 405 (17.86) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.86) | 300.1 / 326 (25.78) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.04 / 50 (30.01) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.04 / 60 (30.0) | 167.46 / 202 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.02 | 36.0 / 23.02 | 0.0 / 0.0 | 416.0 / 37.875 |
| flythrough | 112.0 / 83.713 | 112.0 / 83.713 | 0.0 / 0.0 | 416.0 / 142.788 |
| water_glass | 36.0 / 12.429 | 36.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| nether | 20.0 / 15.215 | 20.0 / 15.215 | 0.0 / 0.0 | 256.0 / 27.042 |
| mobs | 16.0 / 9.59 | 16.0 / 9.59 | 0.0 / 0.0 | 256.0 / 16.783 |
| outline | 16.0 / 1.326 | 16.0 / 1.326 | 0.0 / 0.0 | 256.0 / 2.355 |
| occlusion | 20.0 / 2.481 | 20.0 / 2.481 | 0.0 / 0.0 | 416.0 / 4.459 |
| occlusion_move | 20.0 / 3.355 | 20.0 / 3.355 | 0.0 / 0.0 | 416.0 / 5.97 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.618 | 28.0 / 12.618 | 0.0 / 0.0 | 416.0 / 22.047 |
| water_glass_oit | 20.0 / 12.429 | 20.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| translucent_move_oit | 28.0 / 12.215 | 28.0 / 12.215 | 0.0 / 0.0 | 416.0 / 21.33 |
| flat_plants | 24.0 / 13.556 | 24.0 / 13.556 | 0.0 / 0.0 | 416.0 / 23.491 |
| renderer_off | 24.0 / 8.417 | 24.0 / 8.417 | 0.0 / 0.0 | 416.0 / 14.843 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 429573.198 (652996.725) | 34.215 | 1.778 | 433852 / 644320 | 432472 (2097152.0) | 182 / 201 | 0.0 / 0 |
| flythrough | 554670.771 (889184.557) | 37.62 | 1.084 | 2103964 / 7501992 | 2096192 (2097152.0) | 140 / 118 | 8.865 / 82 |
| water_glass | 112998.815 (197083.918) | 42.665 | 1.133 | 8996 / 11524 | 0 (2097152.0) | 113 / 336 | 0.0 / 0 |
| nether | 42404.052 (65864.677) | 35.619 | 1.885 | 231456 / 234328 | 227392 (2097152.0) | 145 / 334 | 0.0 / 0 |
| mobs | 62336.379 (111370.349) | 44.028 | 0.967 | 610676 / 612228 | 0 (2097152.0) | 33 / 19 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27575.96 (48210.351) | 42.801 | 1.302 | 98148 / 779900 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| occlusion_move | 49214.681 (86257.943) | 42.945 | 1.242 | 699068 / 1154012 | 624000 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27774.683 (60488.367) | 54.083 | 1.272 | 32840 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 195530.085 (345872.16) | 43.468 | 1.179 | 743204 / 1299012 | 739776 (2097152.0) | 324 / 352 | 0.0 / 0 |
| water_glass_oit | 113278.867 (197572.362) | 42.665 | 1.133 | 9444 / 11972 | 0 (2097152.0) | 210 / 176 | 0.0 / 0 |
| translucent_move_oit | 196781.137 (347899.978) | 43.437 | 1.177 | 744244 / 1299572 | 739776 (2097152.0) | 183 / 172 | 0.0 / 0 |
| flat_plants | 9101.639 (12478.183) | 27.06 | 1.045 | 2052 / 4356 | 0 (2097152.0) | 129 / 357 | 0.0 / 0 |
| renderer_off | 17395.089 (32644.59) | 46.714 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 10 / 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3044.12 (5227.76) | 41.77 | 1.087 | 86232 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2246.003 (4830.871) | 53.507 | 1.0 | 79236 / 122808 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.121 (101) | 3.961 (95) | 1.04 | 4.361 (55) | 0 | 908 / 0 | 9.796 / 12.802 | 5.21 / 7.363 |
| flythrough | 6.248 (1609) | 7.027 (1589) | 0.889 | 6.254 (1607) | 0 | 1397 / 0 | 6.73 / 9.808 | 4.424 / 6.807 |
| water_glass | 2.361 (16) | 2.213 (16) | 1.067 | None (0) | 0 | 1229 / 0 | 8.844 / 11.494 | 4.741 / 6.709 |
| nether | 2.562 (24) | 2.492 (15) | 1.028 | 2.639 (14) | 0 | 1858 / 0 | 7.083 / 9.169 | 3.413 / 5.111 |
| mobs | 1.481 (15) | 1.323 (7) | 1.119 | None (0) | 0 | 2088 / 0 | 6.838 / 8.885 | 3.344 / 4.987 |
| outline | 0.414 (12) | 0.384 (13) | 1.078 | None (0) | 0 | 2147 / 0 | 6.728 / 8.764 | 3.27 / 4.909 |
| occlusion | 0.912 (48) | 1.172 (40) | 0.778 | None (0) | 0 | 2280 / 0 | 6.632 / 8.666 | 3.175 / 4.729 |
| occlusion_move | 1.77 (56) | 2.445 (66) | 0.724 | 3.704 (17) | 0 | 2425 / 0 | 6.357 / 8.321 | 2.998 / 4.445 |
| occlusion_corner | 1.324 (110) | 1.466 (110) | 0.903 | 1.034 (1) | 0 | 2713 / 0 | 5.929 / 7.699 | 2.702 / 4.021 |
| translucent_move | 3.927 (112) | 3.705 (114) | 1.06 | 4.792 (41) | 0 | 3067 / 0 | 5.754 / 7.537 | 2.726 / 4.022 |
| water_glass_oit | 4.496 (154) | 3.719 (151) | 1.209 | None (0) | 0 | 411 / 0 | 9.538 / 12.91 | 5.774 / 7.371 |
| translucent_move_oit | 3.573 (215) | 4.648 (209) | 0.769 | 4.161 (26) | 0 | 962 / 0 | 6.475 / 8.896 | 3.668 / 5.011 |
| flat_plants | 1.851 (89) | 1.472 (91) | 1.257 | None (0) | 0 | 394 / 0 | 5.945 / 7.98 | 2.839 / 3.691 |
| renderer_off | 0.726 (25) | 0.5 (21) | 1.452 | None (0) | 0 | 320 / 0 | 7.696 / 12.495 | 4.059 / 6.013 |
| particles | 0.387 (30) | 0.25 (30) | 1.548 | None (0) | 0 | 3096 / 0 | 5.708 / 7.476 | 2.686 / 3.936 |
| animation | 1.115 (18) | 0.945 (18) | 1.18 | 1.182 (4) | 0 | 3171 / 0 | 5.601 / 7.327 | 2.63 / 3.812 |
| animated_items | 0.494 (42) | 0.336 (42) | 1.47 | 1.107 (2) | 0 | 3203 / 0 | 5.551 / 7.261 | 2.579 / 3.74 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.214 | 743.753 | 16 (vanilla 28) | 1390408 | 42.115 / 0.12 | 23.02 / 36.0 | 37.128 | 2449 / 0 | 4.361 (8.437) |
| flythrough | plain, one multi-draw per region and layer | 57.129 | 903.457 | 16 (vanilla 28) | 5073044 | 15.386 / 0.981 | 83.713 / 112.0 | 135.465 | 6435 / 0 | 6.254 (17.38) |
| water_glass | plain, one multi-draw per region and layer | 14.032 | 105.239 | 16 (vanilla 28) | 772464 | 34.296 / 0.108 | 12.429 / 36.0 | 20.627 | 3119 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.454 | 66.159 | 16 (vanilla 28) | 957128 | 28.779 / 0.195 | 15.215 / 20.0 | 25.558 | 4168 / 0 | 2.639 (3.981) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.11 | 16 (vanilla 28) | 599792 | 26.133 / 0.171 | 9.59 / 16.0 | 16.016 | 4624 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 83652 | 25.704 / 0.17 | 1.326 / 16.0 | 2.234 | 4718 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 155152 | 24.603 / 0.162 | 2.481 / 20.0 | 4.143 | 4959 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 10.977 | 74.269 | 16 (vanilla 28) | 209736 | 23.398 / 0.154 | 3.355 / 20.0 | 5.601 | 5227 / 0 | 3.704 (10.824) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.958 | 16 (vanilla 28) | 122728 | 22.06 / 0.145 | 1.931 / 20.0 | 3.277 | 5626 / 0 | 1.034 (1.033) |
| translucent_move | plain, one multi-draw per region and layer | 11.989 | 246.354 | 16 (vanilla 28) | 778424 | 19.271 / 0.133 | 12.618 / 28.0 | 20.786 | 6457 / 0 | 4.792 (14.147) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.076 | 113.538 | 16 (vanilla 28) | 772464 | 7.611 / 0.043 | 12.429 / 20.0 | 20.627 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.617 | 262.628 | 16 (vanilla 28) | 752680 | 6.838 / 0.112 | 12.215 / 28.0 | 20.099 | 2410 / 0 | 4.161 (11.774) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 846396 | 6.501 / 0.01 | 13.556 / 24.0 | 22.601 | 932 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 528792 | 2.516 / 0.021 | 8.417 / 24.0 | 14.12 | 602 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.217 / 0.132 | 0.131 / 28.0 | 0.225 | 6503 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 19.066 / 0.131 | 0.302 / 28.0 | 0.518 | 6605 / 0 | 1.182 (1.953) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 19.013 / 0.132 | 0.153 / 28.0 | 0.261 | 6655 / 0 | 1.107 (1.631) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.596 | 17.0 | 0.0 | 0 | 0 | 49 (0.03 / 0.042 / 0.055; 0) | 0 | 28474 / 0 / 0 |
| flythrough | 187.681 | 26.177 | 0.0 | 0 | 0 | 855 (0.043 / 0.046 / 10.041; 0) | 47 | 26463 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1760 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.01 / 0.01; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.119 / 0.163 / 3.146; 0) | 180 | 2639 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 633 | 0 (None / None / None; 0) | 0 | 844 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 552 | 0 (None / None / None; 0) | 0 | 1288 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2064 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 352.612 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.033 (0.082; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.489 | 1.0 (0.0, 0.0) | 1.447 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.069; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.139 (0.295; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.076 (0.117; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 50.36 | 10.0 (9.0, 2.367) | 6.0 (6.0, 2.278) | 0.073 (0.238; 0) | 0 | 2787 / 1509168 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 134.061 | 1.0 (0.0, 0.0) | 0.764 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 134.717 | 1.0 (0.0, 0.0) | 0.75 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 313.51 / 350.58 (10.6) | 313.51 / 0.0 / 0.0 | 0.14 | 0.0 (0.0, 0.0; 0.0) | 1967.21 | 1798 / 0 |
| flythrough | still | 403.71 / 404.14 (0.1) | 403.71 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 9460 / 0 |
| nether | still | 51.12 / 300.0 (83.0) | 51.12 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 257.65 | 30771 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10200 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.0 / 48.0 (45.8) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion_move | still | 50.13 / 50.31 (0.4) | 50.13 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.77 / 81.86 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 133.03 / 133.89 (0.6) | 133.03 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4558 / 0 |
| translucent_move_oit | still | 133.42 / 134.0 (0.4) | 133.42 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 18176 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 306 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4488.0 | 54 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.353 / 0.582 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 118.185 / 0.585 | 0.026 / 0.014 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.008 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.83 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.26 / 51.25 | 0.022 / 0.029 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.61 | 0.976 / 0.873 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 47.032 / 8.869 | 0.089 / 0.012 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 106.69 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.81 / 13.668 | 0.006 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.185 / 51.128 | 0.017 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.231 / 12.158 | 0.006 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.495 | 0.98 / 0.887 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.334 / 2.205 | 0.012 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.32 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.029 / 0.057 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.287 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.009 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | 136.793 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| occlusion_corner | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
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
| spawn | 13.25 (base 14.05) | 14 (base 15) | 22472 (base 27764) | 253.26 (base 257.2) | 4.23 (base 3.98) |
| flythrough | 13.06 (reported, not gated) | 33 (reported, not gated) | 392560 (reported, not gated) | 307.93 (base 318.06) | 3.71 (base 4.23) |
| water_glass | 8.8 (base 9.0) | 15 (base 15) | 11808 (base 15108) | 238.24 (base 244.39) | 4.23 (base 4.23) |
| nether | 13.21 (base 15.71) | 12 (base 12) | 11072 (base 19912) | 259.45 (base 268.95) | 4.23 (base 4.23) |
| mobs | 19.7 (base 19.97) | 17 (base 17) | 613548 (base 1008176) | 258.16 (base 264.31) | 4.23 (base 6.23) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 257.88 (base 264.58) | 4.23 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100032 (base 126356) | 263.38 (base 264.78) | 4.23 (base 3.98) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82524 (reported, not gated) | 264.21 (base 265.16) | 4.23 (base 4.23) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 268.14 (base 266.66) | 4.23 (base 3.71) |
| translucent_move | 8.87 (reported, not gated) | 15 (reported, not gated) | 10780 (reported, not gated) | 274.62 (base 268.35) | 8.23 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 12032 (base 15024) | 237.58 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 11004 (reported, not gated) | 240.26 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 15.95 (base 18.96) | 15 (base 15) | 4496 (base 9864) | 239.15 (base 248.07) | 3.46 (base 5.98) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 3612 (base 7180) | 232.38 (base 241.13) | 3.34 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 265.4 (base 261.4) | 8.23 (base 5.98) |
| animation | 49 median (avg 40.06) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.98 (base 260.68) | 8.23 (base 5.98) |
| animated_items | 60 median (avg 47.11) (base 60) | 24 (base 23) | 22136 (base 21940) | 236.71 (base 239.74) | 8.23 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.25 / 13 (12.54) | 123.52 / 124 (9.34) | median and average, x 1.10 + 2 |
| flythrough | 13.06 / 13 (8.53) | 123.07 / 123 (5.61) | median and average, at most vanilla + 2 |
| water_glass | 8.8 / 9 (24.81) | 124.0 / 124 (14.87) | median, at most vanilla |
| nether | 13.21 / 16 (25.43) | 120.84 / 121 (15.2) | median, x 1.10 + 2 |
| mobs | 19.7 / 20 (28.63) | 134.0 / 134 (19.09) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.46 / 133 (29.96) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (30.0) | 94.4 / 133 (29.94) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (30.0) | 82.27 / 121 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 8.87 / 9 (22.77) | 124.0 / 124 (15.87) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (11.91) | 129.0 / 129 (8.46) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (10.08) | 129.0 / 129 (7.98) | median and average, at most vanilla |
| flat_plants | 15.95 / 19 (27.38) | 123.96 / 124 (16.18) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.98) | 107.87 / 123 (23.01) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.06 / 49 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.11 / 60 (30.0) | 155.22 / 190 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.576 | 36.0 / 22.576 | 0.0 / 0.0 | 416.0 / 36.892 |
| flythrough | 112.0 / 83.536 | 112.0 / 83.536 | 0.0 / 0.0 | 416.0 / 142.307 |
| water_glass | 36.0 / 12.429 | 36.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| nether | 20.0 / 15.211 | 20.0 / 15.211 | 0.0 / 0.0 | 256.0 / 26.763 |
| mobs | 16.0 / 9.59 | 16.0 / 9.59 | 0.0 / 0.0 | 256.0 / 16.783 |
| outline | 16.0 / 1.326 | 16.0 / 1.326 | 0.0 / 0.0 | 256.0 / 2.355 |
| occlusion | 20.0 / 2.589 | 20.0 / 2.589 | 0.0 / 0.0 | 416.0 / 4.262 |
| occlusion_move | 20.0 / 3.391 | 20.0 / 3.391 | 0.0 / 0.0 | 416.0 / 5.796 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.693 | 28.0 / 12.693 | 0.0 / 0.0 | 416.0 / 21.862 |
| water_glass_oit | 20.0 / 12.429 | 20.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| translucent_move_oit | 28.0 / 12.345 | 28.0 / 12.345 | 0.0 / 0.0 | 416.0 / 21.147 |
| flat_plants | 24.0 / 13.427 | 24.0 / 13.427 | 0.0 / 0.0 | 416.0 / 23.286 |
| renderer_off | 24.0 / 8.429 | 24.0 / 8.429 | 0.0 / 0.0 | 416.0 / 14.827 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 470508.768 (634708.888) | 25.87 | 1.176 | 521060 / 878748 | 496160 (2097152.0) | 250 / 186 | 0.0 / 0 |
| flythrough | 556587.506 (891170.106) | 37.544 | 1.085 | 2126524 / 7354540 | 2096392 (2097152.0) | 170 / 112 | 6.842 / 73 |
| water_glass | 112969.762 (197033.244) | 42.665 | 1.133 | 13600 / 259476 | 0 (2097152.0) | 94 / 297 | 0.0 / 0 |
| nether | 56201.092 (82688.279) | 32.033 | 1.616 | 368112 / 362928 | 347136 (2097152.0) | 134 / 303 | 0.0 / 0 |
| mobs | 63778.752 (113999.927) | 44.054 | 0.968 | 775712 / 1039464 | 159424 (2097152.0) | 3 / 381 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29519.199 (52028.715) | 43.264 | 1.279 | 100032 / 411048 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50796.835 (89345.292) | 43.145 | 1.223 | 655824 / 1196452 | 578944 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27770.988 (60486.905) | 54.088 | 1.272 | 36096 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 197034.545 (348873.574) | 43.523 | 1.181 | 750428 / 1304452 | 739776 (2097152.0) | 13 / 317 | 0.0 / 0 |
| water_glass_oit | 113215.706 (197462.202) | 42.665 | 1.133 | 14272 / 16548 | 0 (2097152.0) | 238 / 169 | 0.0 / 0 |
| translucent_move_oit | 196990.498 (348507.343) | 43.476 | 1.18 | 749772 / 1303652 | 739776 (2097152.0) | 201 / 159 | 0.0 / 0 |
| flat_plants | 9100.577 (12476.726) | 27.06 | 1.045 | 4832 / 9812 | 0 (2097152.0) | 8 / 323 | 0.0 / 0 |
| renderer_off | 17461.053 (32772.53) | 46.72 | 1.0 | 3612 / 7292 | 0 (2097152.0) | 0 / 12 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3061.135 (5267.352) | 41.885 | 1.085 | 86740 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2247.6 (4834.543) | 53.51 | 1.0 | 79772 / 123000 | 57728 (2097152.0) | 0 / 3 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.044 (129) | 2.931 (133) | 0.697 | 2.164 (54) | 0 | 809 / 0 | 5.842 / 7.683 | 2.707 / 4.186 |
| flythrough | 4.111 (1698) | 6.056 (1560) | 0.679 | 4.114 (1696) | 0 | 1399 / 0 | 4.957 / 6.791 | 3.054 / 4.45 |
| water_glass | 1.521 (19) | 1.7 (15) | 0.895 | None (0) | 0 | 1130 / 0 | 5.331 / 6.982 | 2.454 / 3.7 |
| nether | 2.264 (34) | 2.409 (29) | 0.94 | 2.672 (18) | 0 | 1751 / 0 | 4.429 / 5.852 | 2.114 / 3.162 |
| mobs | 1.584 (10) | 2.209 (12) | 0.717 | 2.887 (2) | 0 | 1987 / 0 | 4.252 / 5.589 | 2.071 / 3.036 |
| outline | 0.394 (13) | 0.414 (13) | 0.952 | None (0) | 0 | 2047 / 0 | 4.173 / 5.509 | 2.057 / 2.986 |
| occlusion | 0.734 (46) | 0.815 (47) | 0.901 | None (0) | 0 | 2182 / 0 | 4.032 / 5.349 | 1.959 / 2.877 |
| occlusion_move | 1.408 (58) | 1.774 (57) | 0.794 | 3.05 (18) | 0 | 2337 / 0 | 3.867 / 5.132 | 1.902 / 2.756 |
| occlusion_corner | 0.983 (97) | 1.114 (110) | 0.882 | 0.957 (1) | 0 | 2617 / 0 | 3.601 / 4.816 | 1.722 / 2.527 |
| translucent_move | 2.292 (109) | 2.247 (116) | 1.02 | 2.604 (34) | 0 | 2988 / 0 | 3.541 / 4.754 | 1.772 / 2.585 |
| water_glass_oit | 3.162 (153) | 3.282 (153) | 0.963 | None (0) | 0 | 412 / 0 | 5.832 / 6.968 | 2.986 / 3.856 |
| translucent_move_oit | 2.427 (215) | 3.658 (213) | 0.663 | 2.858 (26) | 0 | 971 / 0 | 3.868 / 4.889 | 2.037 / 2.556 |
| flat_plants | 1.366 (93) | 1.456 (85) | 0.938 | None (0) | 0 | 406 / 0 | 4.507 / 5.435 | 1.846 / 2.062 |
| renderer_off | 0.485 (22) | 0.468 (21) | 1.036 | None (0) | 0 | 324 / 0 | 5.989 / 9.091 | 2.1 / 4.552 |
| particles | 0.272 (30) | 0.255 (30) | 1.067 | None (0) | 0 | 3016 / 0 | 3.514 / 4.716 | 1.752 / 2.549 |
| animation | 0.759 (18) | 1.103 (18) | 0.688 | 1.017 (4) | 0 | 3091 / 0 | 3.449 / 4.621 | 1.708 / 2.49 |
| animated_items | 0.301 (42) | 0.373 (32) | 0.807 | 0.924 (2) | 0 | 3123 / 0 | 3.419 / 4.578 | 1.683 / 2.445 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.012 | 715.008 | 16 (vanilla 28) | 1363508 | 40.538 / 0.093 | 22.576 / 36.0 | 36.41 | 2255 / 0 | 2.164 (3.436) |
| flythrough | indirect, one multi-draw per arena and layer | 3.018 | 915.406 | 16 (vanilla 28) | 5063412 | 15.333 / 1.01 | 83.536 / 112.0 | 135.208 | 6615 / 0 | 4.114 (12.276) |
| water_glass | indirect, one multi-draw per arena and layer | 3.006 | 105.212 | 16 (vanilla 28) | 772464 | 32.995 / 0.085 | 12.429 / 36.0 | 20.627 | 2936 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 82.697 | 16 (vanilla 28) | 957160 | 27.55 / 0.195 | 15.211 / 20.0 | 25.559 | 3989 / 0 | 2.672 (5.741) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 62.021 | 16 (vanilla 28) | 599792 | 24.939 / 0.169 | 9.59 / 16.0 | 16.016 | 4447 / 0 | 2.887 (2.922) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 83652 | 24.501 / 0.168 | 1.326 / 16.0 | 2.234 | 4544 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 162556 | 23.375 / 0.16 | 2.589 / 20.0 | 4.341 | 4790 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.003 | 76.352 | 16 (vanilla 28) | 212956 | 22.06 / 0.15 | 3.391 / 20.0 | 5.687 | 5083 / 0 | 3.05 (4.961) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.955 | 16 (vanilla 28) | 122728 | 20.854 / 0.142 | 1.931 / 20.0 | 3.277 | 5459 / 0 | 0.957 (0.934) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.002 | 249.563 | 16 (vanilla 28) | 783864 | 18.046 / 0.129 | 12.693 / 28.0 | 20.931 | 6316 / 0 | 2.604 (5.001) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.021 | 113.475 | 16 (vanilla 28) | 772464 | 7.599 / 0.043 | 12.429 / 20.0 | 20.627 | 1090 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.02 | 263.806 | 16 (vanilla 28) | 761368 | 6.953 / 0.114 | 12.345 / 28.0 | 20.331 | 2436 / 0 | 2.858 (7.509) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 22.04 | 16 (vanilla 28) | 838044 | 6.681 / 0.01 | 13.427 / 24.0 | 22.378 | 956 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 529392 | 2.53 / 0.021 | 8.429 / 24.0 | 14.136 | 607 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 17.994 / 0.128 | 0.131 / 28.0 | 0.225 | 6360 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.765 | 16 (vanilla 28) | 19416 | 17.85 / 0.127 | 0.302 / 28.0 | 0.518 | 6462 / 0 | 1.017 (1.559) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.712 | 16 (vanilla 28) | 9764 | 17.8 / 0.128 | 0.153 / 28.0 | 0.261 | 6512 / 0 | 0.924 (1.481) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 1.0 | 0.0 | 0 | 0 | 49 (0.021 / 0.037 / 0.05; 0) | 0 | 38403 / 0 / 0 |
| flythrough | 191.491 | 1.0 | 0.0 | 0 | 0 | 895 (0.024 / 0.039 / 4.399; 0) | 55 | 32745 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1984 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.009 / 0.012 / 0.013; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.094 / 0.158 / 0.195; 0) | 180 | 3192 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 717 | 0 (None / None / None; 0) | 0 | 956 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 606 | 0 (None / None / None; 0) | 0 | 1414 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2196 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 340.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.027 (0.07; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 438.474 | 1.0 (0.0, 0.0) | 1.877 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.011 (0.045; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.109 (0.184; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.058 (0.186; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.353 | 10.0 (9.0, 2.367) | 6.0 (6.0, 2.282) | 0.052 (0.233; 0) | 0 | 2789 / 1510082 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.127 | 1.0 (0.0, 0.0) | 0.768 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.327 | 1.0 (0.0, 0.0) | 0.748 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 299.9 / 338.0 (11.3) | 299.9 / 0.0 / 0.0 | 0.12 | 0.0 (0.0, 0.0; 0.0) | 1721.12 | 2409 / 0 |
| flythrough | still | 410.09 / 410.45 (0.1) | 410.09 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10578 / 0 |
| nether | still | 61.75 / 300.0 (79.4) | 61.75 / 0.0 / 0.0 | 0.03 | 0.0 (0.0, 0.0; 0.0) | 367.06 | 30245 / 0 |
| mobs | still | 33.05 / 107.0 (69.1) | 33.05 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 50.26 | 10575 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.0 / 49.0 (46.9) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion_move | still | 51.18 / 51.31 (0.2) | 51.18 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 37 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 135.25 / 135.97 (0.5) | 135.25 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 109 / 0 |
| water_glass_oit | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5074 / 0 |
| translucent_move_oit | still | 134.58 / 135.66 (0.8) | 134.58 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 152.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 19591 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 303 / 0 |
| animated_items | still | 12.68 / 13.0 (2.5) | 12.68 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4528.45 | 42 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.516 / 0.132 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 101.408 / 0.135 | 0.025 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.245 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.854 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.493 / 52.47 | 0.023 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.662 | 0.845 / 0.758 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 39.329 / 8.686 | 0.064 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.16 / 12.151 | 0.005 / 0.01 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.14 / 54.134 | 0.013 / 0.018 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.093 / 14.084 | 0.006 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.281 | 0.957 / 0.942 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.524 / 2.326 | 0.014 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 100.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.004 / 0.033 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.003 / 0.006 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.125 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.628 / 7.993 / 32.636 | 0 / 0 | 9.0 |

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
| occlusion_corner | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| translucent_move_oit | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flat_plants | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| renderer_off | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| particles | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animation | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| animated_items | 4.0 / 4.0 | 3.0 / 3.0 | 9.0 / 9.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

### Counts, core old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 51.23 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 252.52 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 70.09 (reported, not gated) | 46 (reported, not gated) | 625500 (reported, not gated) | 307.78 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 20.92 (base 20.0) | 13 (base 14) | 7540 (base 10264) | 238.12 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.08 (base 33.79) | 10 (base 11) | 4752 (base 10656) | 259.33 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.75 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.11 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.75 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.57 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.14 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.76 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.72 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.89 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.16 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 274.6 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7428 (base 7604) | 237.45 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 18.45 (reported, not gated) | 13 (reported, not gated) | 2612 (reported, not gated) | 240.03 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 18.04 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 239.23 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 13.69 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.73 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.4 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.78 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 236.65 (base 239.53) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 51.23 / 51 (10.15) | 875.35 / 875 (10.06) | median and average, x 1.10 + 2 |
| flythrough | 70.09 / 69 (6.73) | 1007.78 / 1012 (5.92) | median and average, at most vanilla |
| water_glass | 20.92 / 21 (20.72) | 389.0 / 389 (16.83) | median, at most vanilla |
| nether | 24.08 / 27 (25.45) | 590.98 / 591 (16.75) | median, x 1.10 + 2 |
| mobs | 26.75 / 27 (26.57) | 320.62 / 329 (21.5) | median, x 1.10 + 2 |
| outline | 11.75 / 12 (30.0) | 127.27 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 19.67 / 20 (29.95) | 162.46 / 201 (29.94) | median and average, x 1.10 + 2 |
| occlusion_move | 20.09 / 21 (29.79) | 167.6 / 202 (29.98) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.72 / 12 (29.99) | 163.14 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 11.16 / 11 (25.32) | 370.94 / 370 (17.78) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (10.3) | 400.0 / 400 (8.79) | median, at most vanilla |
| translucent_move_oit | 18.45 / 18 (10.58) | 387.19 / 389 (8.64) | median and average, at most vanilla |
| flat_plants | 18.04 / 21 (24.47) | 404.98 / 405 (17.86) | median, x 1.10 + 2 |
| renderer_off | 13.69 / 14 (29.16) | 300.1 / 326 (25.78) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.98 / 50 (30.0) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.01) | 167.46 / 202 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.996 | 36.0 / 22.996 | 0.0 / 0.0 | 416.0 / 37.875 |
| flythrough | 112.0 / 83.378 | 112.0 / 83.378 | 0.0 / 0.0 | 416.0 / 142.788 |
| water_glass | 36.0 / 12.429 | 36.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| nether | 20.0 / 15.215 | 20.0 / 15.215 | 0.0 / 0.0 | 256.0 / 27.042 |
| mobs | 16.0 / 9.59 | 16.0 / 9.59 | 0.0 / 0.0 | 256.0 / 16.783 |
| outline | 16.0 / 1.326 | 16.0 / 1.326 | 0.0 / 0.0 | 256.0 / 2.355 |
| occlusion | 20.0 / 2.602 | 20.0 / 2.602 | 0.0 / 0.0 | 416.0 / 4.459 |
| occlusion_move | 20.0 / 3.391 | 20.0 / 3.391 | 0.0 / 0.0 | 416.0 / 5.97 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.65 | 28.0 / 12.65 | 0.0 / 0.0 | 416.0 / 22.047 |
| water_glass_oit | 20.0 / 12.429 | 20.0 / 12.429 | 0.0 / 0.0 | 416.0 / 21.581 |
| translucent_move_oit | 28.0 / 12.247 | 28.0 / 12.247 | 0.0 / 0.0 | 416.0 / 21.33 |
| flat_plants | 24.0 / 13.434 | 24.0 / 13.434 | 0.0 / 0.0 | 416.0 / 23.491 |
| renderer_off | 24.0 / 8.429 | 24.0 / 8.429 | 0.0 / 0.0 | 416.0 / 14.843 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 397391.634 (597181.337) | 33.455 | 1.779 | 419332 / 644320 | 411904 (2097152.0) | 202 / 201 | 0.0 / 0 |
| flythrough | 479511.418 (754917.0) | 36.482 | 1.086 | 2101868 / 7501992 | 2093208 (2097152.0) | 134 / 118 | 7.467 / 71 |
| water_glass | 113014.324 (197110.966) | 42.665 | 1.133 | 10340 / 11524 | 0 (2097152.0) | 123 / 336 | 0.0 / 0 |
| nether | 29501.733 (42400.976) | 30.422 | 2.0 | 237348 / 234328 | 232256 (2097152.0) | 128 / 334 | 0.0 / 0 |
| mobs | 62339.4 (111375.747) | 44.028 | 0.967 | 610676 / 612228 | 0 (2097152.0) | 43 / 19 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 7724 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29561.269 (52124.875) | 43.288 | 1.279 | 98148 / 779900 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| occlusion_move | 22260.76 (39198.555) | 43.21 | 1.26 | 646204 / 1154012 | 571136 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21832.421 (47199.119) | 53.744 | 1.215 | 32840 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21661.085 (27747.061) | 21.934 | 1.005 | 744548 / 1299012 | 739776 (2097152.0) | 127 / 352 | 0.0 / 0 |
| water_glass_oit | 113291.961 (197595.2) | 42.665 | 1.133 | 9108 / 11972 | 0 (2097152.0) | 205 / 176 | 0.0 / 0 |
| translucent_move_oit | 21813.1 (27993.725) | 22.079 | 1.006 | 744020 / 1299572 | 739776 (2097152.0) | 211 / 172 | 0.0 / 0 |
| flat_plants | 9102.577 (12479.468) | 27.06 | 1.045 | 1828 / 4356 | 0 (2097152.0) | 123 / 357 | 0.0 / 0 |
| renderer_off | 17461.901 (32774.12) | 46.72 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 56 / 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86232 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79144 / 122808 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.697 (103) | 3.961 (95) | 0.933 | 3.811 (57) | 0 | 919 / 0 | 9.115 / 11.473 | 4.152 / 6.074 |
| flythrough | 5.768 (1612) | 7.027 (1589) | 0.821 | 5.773 (1610) | 0 | 1403 / 0 | 7.304 / 9.921 | 4.709 / 6.576 |
| water_glass | 1.809 (19) | 2.213 (16) | 0.817 | None (0) | 0 | 1231 / 0 | 8.391 / 10.673 | 3.962 / 5.791 |
| nether | 2.716 (36) | 2.492 (15) | 1.09 | 2.284 (15) | 0 | 1853 / 0 | 6.931 / 8.931 | 3.291 / 5.068 |
| mobs | 2.044 (9) | 1.323 (7) | 1.545 | None (0) | 0 | 2083 / 0 | 6.821 / 8.775 | 3.244 / 4.892 |
| outline | 0.513 (12) | 0.384 (13) | 1.336 | None (0) | 0 | 2142 / 0 | 6.715 / 8.648 | 3.205 / 4.796 |
| occlusion | 1.246 (44) | 1.172 (40) | 1.063 | None (0) | 0 | 2271 / 0 | 6.523 / 8.425 | 3.113 / 4.638 |
| occlusion_move | 2.05 (58) | 2.445 (66) | 0.838 | 4.499 (19) | 0 | 2420 / 0 | 6.255 / 8.083 | 2.989 / 4.392 |
| occlusion_corner | 1.233 (110) | 1.466 (110) | 0.841 | 1.516 (1) | 0 | 2704 / 0 | 5.802 / 7.493 | 2.627 / 3.919 |
| translucent_move | 3.289 (118) | 3.705 (114) | 0.888 | 4.668 (38) | 0 | 3086 / 0 | 5.669 / 7.338 | 2.733 / 4.063 |
| water_glass_oit | 4.684 (153) | 3.719 (151) | 1.259 | None (0) | 0 | 412 / 0 | 9.123 / 11.286 | 5.055 / 5.959 |
| translucent_move_oit | 3.568 (217) | 4.648 (209) | 0.768 | 4.574 (25) | 0 | 962 / 0 | 6.195 / 8.007 | 3.407 / 4.653 |
| flat_plants | 1.515 (79) | 1.472 (91) | 1.029 | None (0) | 0 | 406 / 0 | 6.721 / 8.015 | 3.27 / 3.955 |
| renderer_off | 0.585 (22) | 0.5 (21) | 1.17 | None (0) | 0 | 322 / 0 | 10.006 / 13.09 | 5.056 / 6.623 |
| particles | 0.403 (30) | 0.25 (30) | 1.612 | None (0) | 0 | 3116 / 0 | 5.623 / 7.281 | 2.675 / 4.021 |
| animation | 1.212 (18) | 0.945 (18) | 1.283 | 1.414 (4) | 0 | 3191 / 0 | 5.516 / 7.134 | 2.583 / 3.843 |
| animated_items | 0.473 (42) | 0.336 (42) | 1.408 | 0.88 (2) | 0 | 3223 / 0 | 5.468 / 7.069 | 2.542 / 3.801 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.193 | 664.272 | 16 (vanilla 28) | 1388564 | 39.442 / 0.106 | 22.996 / 36.0 | 37.079 | 2504 / 0 | 3.811 (7.175) |
| flythrough | plain, one multi-draw per region and layer | 59.373 | 758.03 | 16 (vanilla 28) | 5050720 | 15.69 / 1.026 | 83.378 / 112.0 | 134.869 | 6473 / 0 | 5.773 (17.197) |
| water_glass | plain, one multi-draw per region and layer | 14.034 | 105.254 | 16 (vanilla 28) | 772464 | 32.25 / 0.091 | 12.429 / 36.0 | 20.627 | 3155 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.024 | 43.084 | 16 (vanilla 28) | 957160 | 27.251 / 0.189 | 15.215 / 20.0 | 25.559 | 4214 / 0 | 2.284 (4.125) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.113 | 16 (vanilla 28) | 599792 | 24.822 / 0.166 | 9.59 / 16.0 | 16.016 | 4658 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 83652 | 24.417 / 0.165 | 1.326 / 16.0 | 2.234 | 4752 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 163124 | 23.351 / 0.157 | 2.602 / 20.0 | 4.356 | 4988 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.834 | 16 (vanilla 28) | 212532 | 22.13 / 0.149 | 3.391 / 20.0 | 5.675 | 5268 / 0 | 4.499 (14.171) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.878 | 16 (vanilla 28) | 122728 | 20.875 / 0.14 | 1.931 / 20.0 | 3.277 | 5665 / 0 | 1.516 (1.513) |
| translucent_move | plain, one multi-draw per region and layer | 4.414 | 23.189 | 16 (vanilla 28) | 781248 | 18.04 / 0.126 | 12.65 / 28.0 | 20.862 | 6555 / 0 | 4.668 (14.291) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.078 | 113.551 | 16 (vanilla 28) | 772464 | 7.582 / 0.043 | 12.429 / 20.0 | 20.627 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.483 | 37.374 | 16 (vanilla 28) | 755476 | 6.688 / 0.092 | 12.247 / 28.0 | 20.173 | 2415 / 0 | 4.574 (11.66) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.045 | 16 (vanilla 28) | 838456 | 6.099 / 0.01 | 13.434 / 24.0 | 22.389 | 921 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.038 | 16 (vanilla 28) | 529416 | 2.547 / 0.022 | 8.429 / 24.0 | 14.137 | 603 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 17.979 / 0.126 | 0.131 / 28.0 | 0.225 | 6603 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 17.84 / 0.125 | 0.302 / 28.0 | 0.518 | 6705 / 0 | 1.414 (1.91) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.792 / 0.125 | 0.153 / 28.0 | 0.261 | 6755 / 0 | 0.88 (1.384) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 52 (0.022 / 0.038 / 0.052; 0) | 0 | 31668 / 0 / 0 |
| flythrough | 187.837 | 26.311 | 0.0 | 0 | 0 | 856 (0.028 / 0.049 / 4.044; 0) | 38 | 25358 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1660 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.014 / 0.038 / 0.042; 0) | 32 | 1192 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.12 / 0.163 / 2.784; 0) | 180 | 3556 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 618 | 0 (None / None / None; 0) | 0 | 824 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 636 | 0 (None / None / None; 0) | 0 | 1484 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1960 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2336 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.046 (0.127; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.83 | 1.0 (0.0, 0.0) | 1.407 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.083; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.145 (0.22; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.08 (0.17; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.342 | 10.0 (9.0, 2.366) | 6.0 (6.0, 2.284) | 0.066 (1.562; 0) | 0 | 2771 / 1499836 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.281 | 1.0 (0.0, 0.0) | 0.781 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.708 | 1.0 (0.0, 0.0) | 0.75 (0.0, 0.0) | 0.001 (0.009; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 269.0 / 349.0 (22.9) | 269.0 / 80.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4000 / 0 |
| flythrough | two-phase | 314.37 / 404.36 (22.3) | 307.27 / 97.08 / 7.1 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 2976 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 8858 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 33401 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9975 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.38 / 51.29 (56.4) | 22.33 / 28.97 / 0.05 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4305 / 0 |
| occlusion_corner | two-phase | 60.75 / 81.85 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3164 / 0 |
| translucent_move | two-phase | 15.71 / 135.14 (88.4) | 15.69 / 119.45 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15053 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4386 / 0 |
| translucent_move_oit | two-phase | 15.71 / 135.08 (88.4) | 15.66 / 119.42 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6332 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 17446 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 14746 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.353 / 0.233 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 135.459 / 0.232 | 0.034 / 0.01 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.068 / 0.0 | 0.003 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.83 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 55.82 / 55.769 | 0.021 / 0.03 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.49 | 0.976 / 0.845 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 45.324 / 10.701 | 0.078 / 0.013 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 106.69 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.594 / 13.596 | 0.006 / 0.015 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.51 / 53.432 | 0.018 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.785 / 9.835 | 0.006 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.505 | 0.98 / 0.787 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.48 / 1.396 | 0.011 / 0.007 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.32 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.047 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 136.793 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

GUI pass, core old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

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
| occlusion_corner | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
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
siftec/quicksilver-full: bench kinetics_instancing: median meshing time 2.117 ms per section against vanilla's compiler 2.011 ms (1.053x; limit 2.011 ms; 115 pairs): reported, not gated (open gap)

siftec/quicksilver-full: bench factory_flat: median meshing time 0.884 ms per section against vanilla's compiler 0.605 ms (1.461x; limit 0.665 ms; 608 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench kinetics_instancing: median meshing time 1.726 ms per section against vanilla's compiler 1.29 ms (1.338x; limit 1.29 ms; 145 pairs): reported, not gated (open gap)

siftec/quicksilver-old: bench factory_flat: median meshing time 0.68 ms per section against vanilla's compiler 0.474 ms (1.435x; limit 0.521 ms; 605 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.628 ms per section against vanilla's compiler 0.572 ms (1.098x; limit 0.629 ms; 575 pairs): reported, not gated (open gap)

siftec/quicksilver-vk: bench kinetics_instancing: median meshing time 3.152 ms per section against vanilla's compiler 4.531 ms (0.696x; limit 4.531 ms; 142 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1014-aws amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.354 ms per section against vanilla's compiler 0.359 ms (0.986x; limit 0.395 ms; 604 pairs): reported, not gated (open gap)

siftec/quicksilver-2p-old: bench kinetics_instancing: median meshing time 2.063 ms per section against vanilla's compiler 1.652 ms (1.249x; limit 1.652 ms; 164 pairs): reported, not gated (open gap)

- measure-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1014-aws amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1014-aws amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- full: 6 / 6
- old-gpu: 54 / 54
- vulkan: 0 / 0
- old-gpu-2p: 54 / 54

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % | old-GPU two-phase % |
|---|---|---|---|---|---|---|
| factory | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0169 |
| factory_flat | 0.0034 | 0.3 | 0.0 | 0.0034 | 0.0 | 0.0034 |
| sift | 0.0 | 1.15 | 0.0065 | 0.0065 | 0.0064 | 0.0065 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0024 | 0.55 | 0.0059 | 0.0072 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | 0.0065 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| kinetics | 0.0141 | 0.25 | 0.0025 | 0.0168 | 0.0062 | 0.0082 |
| kinetics_instancing | 0.0027 | 0.25 | 0.0115 | 0.0165 | 0.0136 | 0.0028 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| factory | 95.6 | 370 | 0 (14) | 0 (14) | 0 (14) | 242 (371) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.89 | 100 | 53 (516) | 53 (516) | 59 (503) | 53 (516) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| mam | 98.54 | 10 | 0 (0) | 0 (106149) | 0 (1) | 0 (106149) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 36 (4277) | 41 (4281) | None (None) | 35 (4276) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| kinetics | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |
| kinetics_instancing | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |

Strict picture where the vanilla runs drawing the same way agree (package 5, Create scenes: Flywheel on in vanilla a and b, off in vanilla old and Vulkan), same strict limits:

| scene | runs | vanilla runs | agree on % of pixels | strict pixels |
|---|---|---|---|---|
| kinetics | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 10, vulkan 9, old-gpu-2p 8 |
| kinetics | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 3, old-gpu-2p 0 |
| kinetics_instancing | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics_instancing | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics_instancing | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 7, old-gpu-2p 8 |
| kinetics_instancing | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 0, old-gpu-2p 0 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0 / 0 | 0.0169 / 242 | 0.0 / 0 | 0.0169 / 242 |
| factory_flat | 0.0034 / 0 | 0.0034 / 0 | 0.0 / 0 | 0.0034 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.002 / 8 | 0.0027 / 8 | skipped | 0.0027 / 8 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| kinetics | 0.0114 / 0 | 0.0145 / 0 | 0.0087 / 0 | 0.0145 / 0 |
| kinetics_instancing | 0.0086 / 0 | 0.0018 / 0 | 0.0068 / 0 | 0.0018 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.68 (base 12.22) | 15 (base 15) | 6004 (base 6976) | 366.61 (base 361.48) | 5.99 (base 5.48) |
| factory_flat | 12.68 (reported, not gated) | 15 (base 15) | 6004 (base 6844) | 360.2 (base 360.51) | 3.73 (base 5.48) |
| sift | 24.0 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 385.04 (base 379.72) | 5.99 (base 5.87) |
| hub | 21.55 (base 21.53) | 16 (base 16) | 65656 (base 66576) | 397.67 (base 392.33) | 5.99 (base 5.48) |
| mam | 22.54 (base 22.53) | 19 (base 19) | 22088 (base 23748) | 411.19 (base 405.55) | 5.99 (base 8.12) |
| ponder | 88.26 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 409.8 (base 404.14) | 5.99 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 17 (base 17) | 43324 (base 44728) | 397.01 (base 392.95) | 5.81 (base 8.24) |
| create_ct | 7.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 398.07 (base 394.1) | 5.81 (base 10.24) |
| kinetics | 8.68 (base 8.67) | 13 (base 13) | 7692 (base 7692) | 396.71 (base 395.42) | 5.81 (base 8.06) |
| kinetics_instancing | 7.67 (base 7.67) | 13 (base 13) | 7792 (base 7792) | 360.18 (base 360.23) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.68 / 13 (29.1) | 105.16 / 152 (29.65) | median and average, at most vanilla |
| factory_flat | 12.68 / 13 (29.38) | 105.71 / 152 (29.74) | median and average, at most vanilla |
| sift | 24.0 / 24 (15.97) | 153.0 / 153 (19.18) | median, x 1.10 + 2 |
| hub | 21.55 / 21 (29.72) | 115.34 / 161 (29.85) | median and average, x 1.10 + 2 |
| mam | 22.54 / 22 (29.77) | 115.95 / 162 (29.95) | median, x 1.10 + 2 |
| ponder | 88.26 / 88 (29.83) | 181.38 / 227 (29.76) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.83) | 117.24 / 164 (29.89) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.96) | 100.0 / 147 (29.99) | median and average, x 1.10 + 2 |
| kinetics | 8.68 / 9 (29.36) | 100.92 / 148 (30.0) | median and average, at most vanilla |
| kinetics_instancing | 7.67 / 8 (30.0) | 100.92 / 148 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.891 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.214 | 32.0 / 20.214 | 0.0 / 0.0 | 416.0 / 33.916 |
| ponder | 32.0 / 17.517 | 32.0 / 17.517 | 0.0 / 0.0 | 416.0 / 29.21 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13584.145 (26449.053) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 6 / 6 | 0.0 / 0 |
| factory_flat | 13583.697 (26448.173) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 4 / 3 | 0.0 / 0 |
| sift | 115765.768 (158120.125) | 26.786 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 319 / 316 | 0.0 / 0 |
| hub | 474.798 (783.316) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 6 / 3 | 0.0 / 0 |
| mam | 568.953 (925.55) | 38.528 | 1.25 | 303192 / 304740 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61224 | 0 (2097152.0) | 1 / 5 | 0.0 / 0 |
| hologram | 3670.137 (6346.613) | 42.172 | 1.0 | 45788 / 46744 | 0 (2097152.0) | 5 / 2 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| kinetics | 5437.231 (10385.633) | 47.647 | 1.0 | 7692 / 7792 | 0 (2097152.0) | 6 / 0 | 0.0 / 0 |
| kinetics_instancing | 6068.114 (11697.496) | 48.125 | 1.0 | 7792 / 7792 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.587 (35) | 3.048 (35) | 1.177 | 4.487 (12) | 0 | 773 / 0 | 9.788 / 13.302 | 5.643 / 8.111 |
| factory_flat | 2.118 (69) | 1.736 (69) | 1.22 | 2.081 (14) | 0 | 608 / 0 | 2.388 / 2.215 | 0.884 / 0.605 |
| sift | 1.496 (41) | 1.168 (40) | 1.281 | None (0) | 0 | 1316 / 0 | 7.146 / 9.803 | 3.137 / 4.814 |
| hub | 0.416 (8) | 0.297 (8) | 1.401 | None (0) | 0 | 1369 / 0 | 7.03 / 9.634 | 3.074 / 4.759 |
| mam | 0.524 (4) | 0.351 (4) | 1.493 | None (0) | 0 | 1680 / 0 | 7.181 / 10.191 | 3.648 / 5.977 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1681 / 0 | 7.177 / 10.185 | 3.642 / 5.975 |
| hologram | 0.947 (19) | 0.574 (25) | 1.65 | None (0) | 0 | 1714 / 0 | 7.081 / 10.049 | 3.515 / 5.827 |
| create_ct | 0.71 (58) | 0.888 (47) | 0.8 | None (0) | 0 | 1770 / 0 | 6.914 / 9.794 | 3.422 / 5.531 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1860 / 0 | 6.684 / 9.401 | 2.992 / 5.075 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 115 / 0 | 7.611 / 9.318 | 2.117 / 2.011 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 32.055 | 16 (vanilla 28) | 96100 | 23.399 / 0.245 | 1.511 / 28.0 | 2.566 | 1555 / 0 | 4.487 (8.798) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 2.78 / 0.024 | 1.511 / 8.0 | 2.566 | 823 / 0 | 2.081 (2.396) |
| sift | indirect, one multi-draw per arena and layer | 3.009 | 321.003 | 16 (vanilla 28) | 462560 | 21.519 / 0.289 | 7.388 / 16.0 | 12.352 | 2564 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 20.859 / 0.279 | 1.879 / 12.0 | 3.137 | 2646 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1186920 | 22.077 / 0.32 | 20.214 / 32.0 | 31.694 | 3293 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1016184 | 22.077 / 0.32 | 17.517 / 32.0 | 27.135 | 3294 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 21.928 / 0.315 | 0.238 / 32.0 | 0.367 | 3352 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 21.486 / 0.309 | 0.171 / 32.0 | 0.283 | 3458 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 21.451 / 0.324 | 0.372 / 32.0 | 0.624 | 3564 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 27.045 | 16 (vanilla 28) | 23356 | 8.125 / 0.44 | 0.372 / 8.0 | 0.624 | 128 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1920 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 597 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.002 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.002 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6090 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6174 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5451 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5032 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7748 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 447 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 735 / 0 |
| kinetics_instancing | still | 23.0 / 23.0 (0.0) | 23.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.491 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.04 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 94.118 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.568 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 151.374 / 91.318 | 0.147 / 0.044 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.88 / 13.87 | 0.0 / 0.0 | 574.89 / 574.43 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.88 / 13.87 (8.0 / 8.0) |
| mam | 13.87 / 13.87 | 1.0 / 1.0 | 113.32 / 113.4 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| ponder | 82.59 / 82.59 | 0.11 / 0.0 | 204.04 / 203.98 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.62 / 81.62 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 15.93 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.36 (base 361.53) | 4.24 (base 5.48) |
| factory_flat | 15.95 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.86 (base 360.27) | 3.48 (base 5.48) |
| sift | 36.92 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.32 (base 379.69) | 4.24 (base 4.24) |
| hub | 20.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.88 (base 392.07) | 4.24 (base 5.99) |
| mam | 21.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.27 (base 404.98) | 8.24 (base 7.73) |
| ponder | 87.25 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 405.79 (base 403.64) | 8.24 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42328 (base 43652) | 396.16 (base 392.54) | 8.06 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.3 (base 393.74) | 8.06 (base 8.24) |
| kinetics | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.33 (base 396.01) | 8.06 (base 8.06) |
| kinetics_instancing | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 360.55 (base 360.95) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 15.93 / 16 (29.95) | 179.08 / 226 (29.94) | median and average, at most vanilla |
| factory_flat | 15.95 / 16 (29.95) | 179.0 / 226 (29.97) | median and average, at most vanilla |
| sift | 36.92 / 37 (19.8) | 569.67 / 579 (21.16) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (29.91) | 161.81 / 208 (29.97) | median and average, x 1.10 + 2 |
| mam | 21.54 / 21 (29.96) | 199.87 / 246 (30.01) | median, x 1.10 + 2 |
| ponder | 87.25 / 87 (29.9) | 180.42 / 227 (30.03) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.95) | 128.16 / 175 (29.92) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 110.92 / 158 (29.98) | median and average, x 1.10 + 2 |
| kinetics | 10.67 / 11 (30.01) | 126.92 / 174 (29.98) | median and average, at most vanilla |
| kinetics_instancing | 10.67 / 11 (30.0) | 127.0 / 174 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.891 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.268 | 32.0 / 20.268 | 0.0 / 0.0 | 416.0 / 33.994 |
| ponder | 32.0 / 17.572 | 32.0 / 17.572 | 0.0 / 0.0 | 416.0 / 29.177 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.725 | 8.0 / 0.725 | 0.0 / 0.0 | 256.0 / 1.122 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14349.957 (27750.746) | 48.29 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 1 / 2 | 0.0 / 0 |
| factory_flat | 14413.749 (27859.167) | 48.262 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 1 / 2 | 0.0 / 0 |
| sift | 115645.298 (158024.045) | 26.818 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 158 / 37 | 0.0 / 0 |
| hub | 474.791 (783.306) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 2 / 0 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| hologram | 3670.127 (6346.595) | 42.172 | 1.0 | 44548 / 45812 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics | 5437.032 (10385.251) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.782 (35) | 2.274 (35) | 1.223 | 2.628 (12) | 0 | 781 / 0 | 7.488 / 10.504 | 3.428 / 6.084 |
| factory_flat | 1.764 (68) | 1.311 (68) | 1.346 | 1.429 (13) | 0 | 605 / 0 | 1.913 / 1.618 | 0.68 / 0.474 |
| sift | 1.289 (41) | 1.438 (40) | 0.896 | None (0) | 0 | 1323 / 0 | 5.509 / 7.499 | 2.299 / 3.234 |
| hub | 0.336 (8) | 0.167 (8) | 2.012 | None (0) | 0 | 1376 / 0 | 5.442 / 7.396 | 2.223 / 3.206 |
| mam | 0.38 (4) | 0.243 (4) | 1.564 | None (0) | 0 | 1692 / 0 | 5.247 / 7.282 | 2.343 / 3.426 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1693 / 0 | 5.246 / 7.277 | 2.345 / 3.424 |
| hologram | 1.423 (25) | 0.536 (25) | 2.655 | None (0) | 0 | 1726 / 0 | 5.208 / 7.214 | 2.305 / 3.394 |
| create_ct | 0.541 (60) | 0.391 (60) | 1.384 | None (0) | 0 | 1782 / 0 | 5.087 / 7.034 | 2.194 / 3.299 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1877 / 0 | 4.935 / 6.781 | 2.035 / 3.113 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 145 / 0 | 6.062 / 5.883 | 1.726 / 1.29 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.247 | 34.582 | 16 (vanilla 28) | 96100 | 25.656 / 0.244 | 1.511 / 28.0 | 2.566 | 1620 / 0 | 2.628 (5.004) |
| factory_flat | plain, one multi-draw per region and layer | 4.268 | 34.793 | 16 (vanilla 28) | 96100 | 2.759 / 0.024 | 1.511 / 8.0 | 2.566 | 815 / 0 | 1.429 (1.721) |
| sift | plain, one multi-draw per region and layer | 17.043 | 320.808 | 16 (vanilla 28) | 462560 | 23.402 / 0.286 | 7.388 / 16.0 | 12.352 | 2628 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.669 / 0.277 | 1.879 / 12.0 | 3.137 | 2711 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1190296 | 23.474 / 0.316 | 20.268 / 32.0 | 31.784 | 3366 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019560 | 23.474 / 0.316 | 17.572 / 32.0 | 27.225 | 3367 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.274 / 0.311 | 0.238 / 32.0 | 0.367 | 3431 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.823 / 0.305 | 0.171 / 32.0 | 0.283 | 3539 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.8 / 0.323 | 0.372 / 32.0 | 0.624 | 3652 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 46060 | 6.164 / 0.31 | 0.725 / 8.0 | 1.23 | 163 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2382 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.041; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.52 / 69.0 (57.2) | 29.52 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.48 | 5922 / 0 |
| factory_flat | still | 29.73 / 69.0 (56.9) | 29.73 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.52 | 5712 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6831 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5100 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7748 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 755 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.006 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 130.733 / 9.924 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 140.453 / 85.683 | 0.137 / 0.039 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.89 | 0.0 / 0.0 | 574.48 / 575.21 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.89 (8.0 / 8.0) |
| mam | 13.88 / 13.87 | 1.0 / 1.0 | 113.69 / 113.48 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.88 / 13.87 (8.0 / 8.0) |
| ponder | 82.58 / 82.57 | 0.11 / 0.11 | 204.09 / 203.75 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 13.69 (base 14.25) | 15 (base 15) | 50660 (base 51624) | 364.29 (base 360.8) | 4.23 (base 5.46) |
| factory_flat | 13.69 (reported, not gated) | 15 (base 15) | 50660 (base 51500) | 360.35 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 382.65 (base 379.18) | 4.23 (base 5.46) |
| hub | 20.54 (base 21.57) | 16 (base 16) | 65656 (base 66576) | 395.04 (base 391.05) | 4.23 (base 5.46) |
| mam | 21.53 (base 22.55) | 19 (base 19) | 22088 (base 23748) | 409.36 (base 404.61) | 8.23 (base 7.71) |
| ponder | 87.25 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 407.9 (base 403.47) | 8.23 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 398.69 (base 395.99) | 8.04 (base 8.29) |
| kinetics | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 397.51 (base 398.76) | 8.04 (base 8.04) |
| kinetics_instancing | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 358.29 (base 359.57) | 3.46 (base 5.46) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 13.69 / 14 (29.71) | 108.11 / 154 (29.67) | median and average, at most vanilla |
| factory_flat | 13.69 / 14 (29.98) | 106.92 / 154 (29.97) | median and average, at most vanilla |
| sift | 23.0 / 23 (15.27) | 153.0 / 153 (17.03) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (29.67) | 115.5 / 161 (29.78) | median and average, x 1.10 + 2 |
| mam | 21.53 / 21 (29.5) | 116.33 / 162 (29.84) | median, x 1.10 + 2 |
| ponder | 87.25 / 87 (29.97) | 180.41 / 227 (30.01) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (30.0) | 99.92 / 147 (29.98) | median and average, x 1.10 + 2 |
| kinetics | 8.67 / 9 (30.0) | 102.0 / 149 (29.98) | median and average, at most vanilla |
| kinetics_instancing | 8.67 / 9 (30.0) | 102.0 / 149 (30.0) | median and average, at most vanilla |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.918 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.284 | 32.0 / 20.284 | 0.0 / 0.0 | 416.0 / 33.957 |
| ponder | 32.0 / 17.588 | 32.0 / 17.588 | 0.0 / 0.0 | 416.0 / 29.14 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14612.468 (28197.04) | 48.177 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 4 / 7 | 0.0 / 0 |
| factory_flat | 14752.287 (28434.624) | 48.119 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 0 / 0 | 0.0 / 0 |
| sift | 115782.374 (158142.807) | 26.786 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 305 / 340 | 0.0 / 0 |
| hub | 474.798 (783.316) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 5 / 5 | 0.0 / 0 |
| mam | 568.961 (925.563) | 38.528 | 1.25 | 41048 / 42688 | 0 (2097152.0) | 22 / 36 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics_instancing | 5437.047 (10385.28) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.917 (35) | 2.041 (35) | 1.429 | 2.82 (12) | 0 | 869 / 0 | 9.911 / 12.785 | 5.794 / 8.397 |
| factory_flat | 2.058 (48) | 1.123 (36) | 1.833 | 2.165 (14) | 0 | 575 / 0 | 3.001 / 2.803 | 0.628 / 0.572 |
| sift | 1.125 (41) | 1.109 (41) | 1.014 | None (0) | 0 | 1415 / 0 | 7.381 / 9.477 | 3.159 / 4.821 |
| hub | 0.433 (8) | 0.197 (8) | 2.198 | None (0) | 0 | 1472 / 0 | 7.234 / 9.342 | 3.069 / 4.765 |
| mam | 0.539 (4) | 0.236 (4) | 2.284 | None (0) | 0 | 1789 / 0 | 7.152 / 9.69 | 3.664 / 5.591 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1790 / 0 | 7.148 / 9.685 | 3.657 / 5.589 |
| create_ct | 1.039 (51) | 0.456 (60) | 2.279 | None (0) | 0 | 1844 / 0 | 7.053 / 9.513 | 3.583 / 5.386 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1939 / 0 | 6.832 / 9.125 | 3.24 / 5.008 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 142 / 0 | 8.338 / 10.11 | 3.152 / 4.531 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 35.448 | 16 (vanilla 28) | 96100 | 25.531 / 0.318 | 1.511 / 28.0 | 2.566 | 1803 / 0 | 2.82 (3.285) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 35.91 | 16 (vanilla 28) | 96100 | 2.421 / 0.031 | 1.511 / 8.0 | 2.566 | 715 / 0 | 2.165 (6.08) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 321.049 | 16 (vanilla 28) | 462560 | 23.467 / 0.342 | 7.388 / 16.0 | 12.352 | 2815 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.753 / 0.33 | 1.879 / 12.0 | 3.137 | 2906 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1191340 | 23.487 / 0.357 | 20.284 / 32.0 | 31.812 | 3562 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1020604 | 23.487 / 0.357 | 17.588 / 32.0 | 27.253 | 3563 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.09 / 0.351 | 0.171 / 32.0 | 0.283 | 3660 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 23.064 / 0.367 | 0.372 / 32.0 | 0.624 | 3773 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 5.848 / 0.201 | 0.372 / 8.0 | 0.624 | 182 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1836 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 592 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.045; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 30.39 / 69.0 (56.0) | 30.39 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 290.42 | 5712 / 0 |
| factory_flat | still | 30.78 / 69.0 (55.4) | 30.78 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.0 | 5712 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5313 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5066 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7696 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.435 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.004 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.96 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.27 / 574.69 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.85 / 13.86 | 1.0 / 1.0 | 112.67 / 113.02 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.85 / 13.86 (8.0 / 8.0) |
| ponder | 82.58 / 82.57 | 0.11 / 0.11 | 203.65 / 203.84 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.6 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.67 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 365.75 (base 361.53) | 4.24 (base 5.48) |
| factory_flat | 16.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.01 (base 360.27) | 5.48 (base 5.48) |
| sift | 37.03 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.03 (base 379.69) | 4.24 (base 4.24) |
| hub | 21.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.78 (base 392.07) | 4.24 (base 5.99) |
| mam | 22.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.27 (base 404.98) | 8.24 (base 7.73) |
| ponder | 88.25 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.24 (base 403.64) | 8.24 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 42980 (base 43652) | 395.83 (base 392.54) | 8.06 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 396.81 (base 393.74) | 8.06 (base 8.24) |
| kinetics | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 395.93 (base 396.01) | 8.06 (base 8.06) |
| kinetics_instancing | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 359.19 (base 360.95) | 5.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 16.67 / 17 (29.93) | 179.08 / 226 (29.94) | median and average, at most vanilla |
| factory_flat | 16.67 / 17 (29.98) | 179.0 / 226 (29.97) | median and average, at most vanilla |
| sift | 37.03 / 38 (21.51) | 569.67 / 579 (21.16) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.91) | 161.81 / 208 (29.97) | median and average, x 1.10 + 2 |
| mam | 22.54 / 22 (29.99) | 199.87 / 246 (30.01) | median, x 1.10 + 2 |
| ponder | 88.25 / 88 (29.98) | 180.42 / 227 (30.03) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.99) | 128.16 / 175 (29.92) | median, at most vanilla |
| create_ct | 7.67 / 8 (30.0) | 110.92 / 158 (29.98) | median and average, x 1.10 + 2 |
| kinetics | 11.67 / 12 (30.0) | 126.92 / 174 (29.98) | median and average, at most vanilla |
| kinetics_instancing | 11.67 / 12 (30.01) | 127.0 / 174 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.642 | 8.0 / 1.642 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.388 | 16.0 / 7.388 | 0.0 / 0.0 | 416.0 / 12.891 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.269 | 32.0 / 20.269 | 0.0 / 0.0 | 416.0 / 33.994 |
| ponder | 32.0 / 17.57 | 32.0 / 17.57 | 0.0 / 0.0 | 416.0 / 29.177 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.423 | 8.0 / 0.423 | 0.0 / 0.0 | 256.0 / 1.122 |


Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.475 (26447.749) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 2 / 2 | 0.0 / 0 |
| factory_flat | 13583.332 (26447.466) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 1 / 2 | 0.0 / 0 |
| sift | 115621.643 (157991.722) | 26.818 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 55 / 37 | 0.0 / 0 |
| hub | 474.793 (783.308) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 2 / 1 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| hologram | 3670.117 (6346.578) | 42.172 | 1.0 | 44772 / 45812 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics | 5437.047 (10385.28) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| kinetics_instancing | 5437.032 (10385.251) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.148 (35) | 2.274 (35) | 0.945 | 2.126 (12) | 0 | 813 / 0 | 6.24 / 8.203 | 2.291 / 3.688 |
| factory_flat | 1.46 (69) | 1.311 (68) | 1.114 | 1.401 (13) | 0 | 604 / 0 | 1.325 / 1.266 | 0.354 / 0.359 |
| sift | 1.112 (41) | 1.438 (40) | 0.773 | None (0) | 0 | 1353 / 0 | 4.396 / 5.846 | 1.402 / 2.16 |
| hub | 0.255 (8) | 0.167 (8) | 1.527 | None (0) | 0 | 1406 / 0 | 4.345 / 5.77 | 1.385 / 2.131 |
| mam | 0.337 (4) | 0.243 (4) | 1.387 | None (0) | 0 | 1721 / 0 | 4.164 / 5.71 | 1.548 / 2.455 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1722 / 0 | 4.161 / 5.707 | 1.546 / 2.454 |
| hologram | 0.512 (19) | 0.536 (25) | 0.955 | None (0) | 0 | 1755 / 0 | 4.118 / 5.649 | 1.527 / 2.437 |
| create_ct | 0.438 (48) | 0.391 (60) | 1.12 | None (0) | 0 | 1811 / 0 | 4.021 / 5.505 | 1.464 / 2.248 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1906 / 0 | 3.874 / 5.278 | 1.385 / 2.055 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 164 / 0 | 5.461 / 5.412 | 2.063 / 1.652 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 25.57 / 0.279 | 1.511 / 28.0 | 2.566 | 1685 / 0 | 2.126 (2.296) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.053 | 16 (vanilla 28) | 104424 | 2.899 / 0.038 | 1.642 / 8.0 | 2.788 | 807 / 0 | 1.401 (2.006) |
| sift | plain, one multi-draw per region and layer | 17.039 | 320.742 | 16 (vanilla 28) | 462560 | 23.369 / 0.313 | 7.388 / 16.0 | 12.352 | 2691 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.685 / 0.303 | 1.879 / 12.0 | 3.137 | 2773 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1190384 | 23.48 / 0.337 | 20.269 / 32.0 | 31.787 | 3425 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019520 | 23.48 / 0.337 | 17.57 / 32.0 | 27.224 | 3426 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.318 / 0.333 | 0.238 / 32.0 | 0.367 | 3484 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.92 / 0.327 | 0.171 / 32.0 | 0.283 | 3580 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.895 / 0.344 | 0.372 / 32.0 | 0.624 | 3693 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 26636 | 5.449 / 0.218 | 0.423 / 8.0 | 0.711 | 196 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2592 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.0 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.002 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6300 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6300 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7383 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5066 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 7748 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |
| kinetics_instancing | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 130.733 / 9.118 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 149.575 / 89.352 | 0.079 / 0.019 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.89 | 0.0 / 0.0 | 574.37 / 575.21 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.89 (8.0 / 8.0) |
| mam | 13.87 / 13.87 | 1.0 / 1.0 | 113.53 / 113.48 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| ponder | 82.58 / 82.57 | 0.0 / 0.11 | 203.7 / 203.75 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Flywheel (package 5)

Flywheel's own backend choice per run (CI's pin mod), and in Quicksilver's runs its visuals and the frames it drew before the terrain in the kinetics scene's bench.

| run | backend per session | kinetics: visuals | frames drawing before terrain |
|---|---|---|---|
| vanilla-a | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| vanilla-b | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| vanilla-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| vanilla-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| quicksilver-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | 24 | 589 / 588 |
| quicksilver-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 601 |
| quicksilver-vk | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 600 |
| measure-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| measure-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| measure-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 11.71 | 96.4 | 234 | 124 | 1039084 | [] |
| bench-plain | flythrough | 7.33 | 305.1 | 146 | 123 | 8093304 | [] |
| bench-plain | water_glass | 20.11 | 53.85 | 133 | 124 | 260484 | [] |
| bench-plain | nether | 19.4 | 61.25 | 378 | 121 | 276128 | [] |
| bench-sodium | spawn | 13.09 | 91.58 | 261 | 147 | 2320 | [] |
| bench-sodium | flythrough | 8.83 | 252.95 | 176 | 159 | 268472 | [] |
| bench-sodium | water_glass | 24.23 | 53.05 | 11 | 135 | 10460 | [] |
| bench-sodium | nether | 29.52 | 42.45 | 1 | 129 | 263888 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 54.567 (50.0) | 715 / 715 | 1655 | 1 | 40521.947 | 8.799 (0.0) | 1141 |

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
| core-bench-sodium | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-vk | spawn | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | water_glass | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | nether | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | mobs | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | outline | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion_corner | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | translucent_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | particles | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | animation | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | animated_items | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | flythrough | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-2p-old | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-2p-old | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-2p-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-2p-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | spawn | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | water_glass | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | nether | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | flat_plants | 3.35 | 3.35 (0) | 3.35 |  |
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
| core-quicksilver-vk | occlusion_corner | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | translucent_move | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| core-quicksilver-vk | particles | 8.23 | 8.23 (0) | 8.23 |  |
| core-quicksilver-vk | animation | 8.23 | 8.23 (0) | 8.23 |  |
| core-quicksilver-vk | animated_items | 8.23 | 8.23 (0) | 8.23 |  |
| core-quicksilver-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-sp-quicksilver | flythrough | 1.38 | 1.46 (88) | 1.46 |  |
| siftec-measure-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-full | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-full | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-full | kinetics_instancing | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-old | kinetics_instancing | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-measure-vk | factory | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-measure-vk | sift | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-measure-vk | hub | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-measure-vk | mam | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| siftec-measure-vk | ponder | 8.23 | 8.23 (0) | 8.23 |  |
| siftec-measure-vk | create_ct | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-measure-vk | kinetics | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-measure-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-measure-vk | kinetics_instancing | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-2p-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-2p-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-2p-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-2p-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-2p-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-2p-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-2p-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-2p-old | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-2p-old | factory_flat | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | kinetics_instancing | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-full | factory | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | sift | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | hub | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | kinetics | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | factory_flat | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-vk | factory | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | sift | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | hub | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | mam | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| siftec-quicksilver-vk | ponder | 8.23 | 8.23 (0) | 8.23 |  |
| siftec-quicksilver-vk | create_ct | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-quicksilver-vk | kinetics | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-vk | kinetics_instancing | 3.46 | 3.46 (0) | 3.46 |  |

Rises of 4 MB or more: core-quicksilver-vk/translucent_move: between scenes +4.00; siftec-measure-full/mam: between scenes +4.00; siftec-measure-old/mam: between scenes +4.00; siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-2p-old/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00; siftec-quicksilver-vk/mam: between scenes +4.00

