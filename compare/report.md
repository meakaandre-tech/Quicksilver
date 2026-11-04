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
| spawn | 0.0601 | 10.05 | 0.4417 | 0.2066 | 0.2955 | 0.0601 |
| flythrough | 0.0 | 14.95 | 0.001 | 0.001 | 0.0011 | 0.001 |
| water_glass | 0.0026 | 6.45 | 0.0034 | 0.0048 | 0.0041 | 0.0054 |
| nether | 0.0 | 0.8 | 0.0007 | 0.0204 | 0.0003 | 0.0003 |
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
| translucent_move | 0.0003 | 0.3 | 0.0003 | 0.0 | 0.0001 | 0.0 |
| translucent_move.x2404 | 0.0002 | 0.3 | 0.0003 | 0.0003 | 0.0004 | 0.0002 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0002 | 0.0003 | 0.0002 | 0.0003 |
| translucent_move.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0003 | 0.0004 | 0.0002 |
| translucent_move.low | 0.001 | 0.3 | 0.0011 | 0.0011 | 0.0009 | 0.0014 |
| translucent_move.back | 0.0 | 0.3 | 0.0 | 0.0002 | 0.0 | 0.0002 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0001 | 0.0002 | 0.0001 | 0.0002 |
| water_glass_oit | 0.0039 | 0.3 | 0.0046 | 0.0042 | 0.0044 | 0.0031 |
| translucent_move_oit | 0.0004 | 0.3 | 0.0005 | 0.0 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0002 | 0.3 | 0.0004 | 0.0004 | 0.0002 | 0.0004 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0002 | 0.0004 | 0.0002 | 0.0003 |
| translucent_move_oit.x2424 | 0.0 | 0.3 | 0.0001 | 0.0003 | 0.0002 | 0.0003 |
| translucent_move_oit.low | 0.0004 | 0.3 | 0.001 | 0.0013 | 0.0012 | 0.0012 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0 | 0.0002 | 0.0002 | 0.0001 |
| translucent_move_oit.bare_back | 0.0001 | 0.3 | 0.0001 | 0.0001 | 0.0 | 0.0001 |
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
| spawn | 92.62 | 18057 | 281 (794) | 307 (799) | 206 (686) | 265 (745) |
| flythrough | 97.25 | 6020 | 48 (298) | 48 (298) | 51 (297) | 48 (298) |
| water_glass | 95.8 | 25508 | 22 (2623) | 14 (2615) | 20 (2735) | 23 (2624) |
| nether | 99.42 | 905 | 6 (461) | 279 (734) | 3 (470) | 3 (458) |
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
| translucent_move | 96.93 | 13 | 1 (77) | 3 (78) | 3 (69) | 3 (78) |
| translucent_move.x2404 | 95.93 | 15 | 5 (106) | 5 (105) | 5 (89) | 4 (105) |
| translucent_move.x2414 | 95.86 | 13 | 1 (104) | 3 (106) | 2 (100) | 1 (105) |
| translucent_move.x2424 | 96.74 | 13 | 2 (79) | 4 (81) | 2 (68) | 2 (79) |
| translucent_move.low | 96.11 | 41 | 15 (21) | 15 (20) | 14 (16) | 16 (21) |
| translucent_move.back | 96.93 | 13 | 1 (76) | 2 (77) | 1 (67) | 2 (77) |
| translucent_move.bare_back | 96.9 | 13 | 2 (77) | 2 (77) | 1 (67) | 3 (78) |
| water_glass_oit | 95.81 | 57 | 22 (2624) | 24 (2626) | 23 (2737) | 9 (2611) |
| translucent_move_oit | 96.93 | 12 | 3 (78) | 2 (77) | 1 (67) | 3 (78) |
| translucent_move_oit.x2404 | 95.93 | 16 | 3 (103) | 5 (105) | 6 (90) | 4 (104) |
| translucent_move_oit.x2414 | 95.86 | 10 | 2 (105) | 4 (107) | 2 (99) | 2 (105) |
| translucent_move_oit.x2424 | 96.74 | 15 | 1 (78) | 2 (79) | 1 (68) | 2 (79) |
| translucent_move_oit.low | 96.11 | 40 | 14 (19) | 15 (20) | 14 (16) | 12 (18) |
| translucent_move_oit.back | 96.93 | 12 | 2 (78) | 3 (78) | 1 (67) | 2 (77) |
| translucent_move_oit.bare_back | 96.9 | 15 | 1 (76) | 2 (78) | 3 (70) | 2 (77) |
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
| spawn | 0.0647 / 255 | 0.0508 / 182 | 0.0637 / 172 | 0.0508 / 182 |
| flythrough | 0.0001 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0033 / 18 | 0.0049 / 15 | 0.0044 / 24 | 0.0049 / 15 |
| nether | 0.0009 / 8 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
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
| translucent_move | 0.0004 / 1 | 0.0 / 1 | 0.0002 / 2 | 0.0 / 1 |
| translucent_move.x2404 | 0.0002 / 2 | 0.0001 / 1 | 0.0001 / 3 | 0.0001 / 1 |
| translucent_move.x2414 | 0.0001 / 0 | 0.0003 / 1 | 0.0001 / 2 | 0.0003 / 1 |
| translucent_move.x2424 | 0.0002 / 2 | 0.0002 / 2 | 0.0001 / 0 | 0.0002 / 2 |
| translucent_move.low | 0.0003 / 2 | 0.0007 / 5 | 0.0003 / 5 | 0.0007 / 5 |
| translucent_move.back | 0.0001 / 1 | 0.0001 / 0 | 0.0001 / 1 | 0.0001 / 0 |
| translucent_move.bare_back | 0.0 / 2 | 0.0002 / 2 | 0.0001 / 1 | 0.0002 / 2 |
| water_glass_oit | 0.0041 / 18 | 0.0031 / 15 | 0.0034 / 17 | 0.0031 / 15 |
| translucent_move_oit | 0.0003 / 0 | 0.0 / 1 | 0.0001 / 0 | 0.0 / 1 |
| translucent_move_oit.x2404 | 0.0002 / 1 | 0.0002 / 1 | 0.0 / 1 | 0.0002 / 1 |
| translucent_move_oit.x2414 | 0.0002 / 2 | 0.0001 / 0 | 0.0003 / 3 | 0.0001 / 0 |
| translucent_move_oit.x2424 | 0.0 / 1 | 0.0001 / 0 | 0.0001 / 1 | 0.0001 / 0 |
| translucent_move_oit.low | 0.0001 / 4 | 0.0008 / 5 | 0.0009 / 5 | 0.0008 / 5 |
| translucent_move_oit.back | 0.0 / 2 | 0.0 / 0 | 0.0002 / 0 | 0.0 / 0 |
| translucent_move_oit.bare_back | 0.0001 / 2 | 0.0 / 0 | 0.0001 / 2 | 0.0 / 0 |
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
| spawn | 14.4 (base 13.6) | 15 (base 14) | 21972 (base 22476) | 251.32 (base 259.07) | 5.99 (base 3.99) |
| flythrough | 15.77 (reported, not gated) | 41 (reported, not gated) | 632092 (reported, not gated) | 308.85 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 9.9 (base 8.97) | 15 (base 15) | 12068 (base 15576) | 237.57 (base 250.02) | 5.99 (base 5.99) |
| nether | 14.05 (base 15.63) | 12 (base 12) | 10380 (base 19648) | 258.95 (base 273.53) | 5.99 (base 5.99) |
| mobs | 20.73 (base 19.77) | 16 (base 17) | 613404 (base 1010948) | 257.36 (base 268.37) | 5.99 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 257.01 (base 264.69) | 5.99 (base 5.48) |
| occlusion | 16.67 (base 15.67) | 15 (base 15) | 100052 (base 126320) | 262.89 (base 265.1) | 5.99 (base 4.24) |
| occlusion_move | 16.92 (reported, not gated) | 15 (reported, not gated) | 81944 (reported, not gated) | 263.35 (base 265.74) | 5.99 (base 4.24) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 267.62 (base 267.71) | 5.99 (base 5.48) |
| translucent_move | 8.91 (reported, not gated) | 15 (reported, not gated) | 5372 (reported, not gated) | 273.78 (base 267.48) | 5.99 (base 5.48) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 12608 (base 14688) | 236.91 (base 245.02) | 3.6 (base 3.73) |
| translucent_move_oit | 14.2 (reported, not gated) | 15 (reported, not gated) | 5376 (reported, not gated) | 239.75 (base 247.19) | 3.73 (base 3.73) |
| flat_plants | 17.24 (base 18.29) | 15 (base 15) | 4608 (base 9812) | 238.78 (base 246.92) | 3.21 (base 3.99) |
| renderer_off | 8.68 (base 7.67) | 14 (base 14) | 3612 (base 7164) | 232.93 (base 241.33) | 3.6 (base 4.12) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 264.9 (base 261.44) | 5.99 (base 5.99) |
| animation | 50 median (avg 40.94) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.46 (base 260.68) | 5.99 (base 5.99) |
| animated_items | 61 median (avg 47.73) (base 60) | 24 (base 23) | 22016 (base 21940) | 236.12 (base 239.81) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.4 / 14 (9.5) | 123.0 / 123 (11.65) | median and average, x 1.10 + 2 |
| flythrough | 15.77 / 16 (6.64) | 123.07 / 123 (7.99) | median and average, at most vanilla + 2 |
| water_glass | 9.9 / 10 (21.24) | 121.37 / 124 (19.87) | median, at most vanilla |
| nether | 14.05 / 17 (23.48) | 120.84 / 121 (19.42) | median, x 1.10 + 2 |
| mobs | 20.73 / 21 (27.3) | 111.93 / 134 (24.73) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 16.67 / 17 (29.99) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.92 / 18 (29.78) | 94.2 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (29.98) | 82.33 / 121 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 8.91 / 9 (25.1) | 120.32 / 124 (20.54) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (10.18) | 129.0 / 129 (11.17) | median, at most vanilla |
| translucent_move_oit | 14.2 / 14 (10.32) | 129.0 / 129 (10.42) | median and average, at most vanilla |
| flat_plants | 17.24 / 20 (25.0) | 123.69 / 124 (19.73) | median, x 1.10 + 2 |
| renderer_off | 8.68 / 9 (29.27) | 84.98 / 123 (29.76) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.94 / 50 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.0) | 155.46 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 21.881 | 36.0 / 21.881 | 0.0 / 0.0 | 416.0 / 36.77 |
| flythrough | 112.0 / 84.094 | 112.0 / 84.094 | 0.0 / 0.0 | 416.0 / 143.944 |
| water_glass | 36.0 / 12.539 | 36.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.799 |
| nether | 20.0 / 15.236 | 20.0 / 15.236 | 0.0 / 0.0 | 256.0 / 26.725 |
| mobs | 16.0 / 9.715 | 16.0 / 9.715 | 0.0 / 0.0 | 256.0 / 17.006 |
| outline | 16.0 / 1.378 | 16.0 / 1.378 | 0.0 / 0.0 | 256.0 / 2.448 |
| occlusion | 20.0 / 2.428 | 20.0 / 2.428 | 0.0 / 0.0 | 416.0 / 4.464 |
| occlusion_move | 20.0 / 3.229 | 20.0 / 3.229 | 0.0 / 0.0 | 416.0 / 5.787 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.935 | 28.0 / 12.935 | 0.0 / 0.0 | 416.0 / 22.312 |
| water_glass_oit | 20.0 / 12.539 | 20.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.799 |
| translucent_move_oit | 28.0 / 12.524 | 28.0 / 12.524 | 0.0 / 0.0 | 416.0 / 21.591 |
| flat_plants | 24.0 / 14.058 | 24.0 / 14.058 | 0.0 / 0.0 | 416.0 / 24.121 |
| renderer_off | 24.0 / 8.763 | 24.0 / 8.763 | 0.0 / 0.0 | 416.0 / 15.427 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 427863.238 (579177.312) | 26.126 | 1.197 | 517636 / 850976 | 495776 (2097152.0) | 189 / 233 | 0.0 / 0 |
| flythrough | 480027.439 (755516.121) | 36.464 | 1.084 | 2361244 / 7158552 | 2095936 (2097152.0) | 132 / 159 | 5.82 / 61 |
| water_glass | 113110.142 (197402.476) | 42.701 | 1.133 | 13392 / 17592 | 0 (2097152.0) | 115 / 198 | 0.0 / 0 |
| nether | 29514.797 (42416.247) | 30.416 | 2.0 | 193416 / 450788 | 183168 (2097152.0) | 117 / 382 | 0.0 / 0 |
| mobs | 62047.432 (110790.542) | 43.996 | 0.967 | 613404 / 616364 | 0 (2097152.0) | 21 / 1 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 26598.257 (46277.0) | 42.524 | 1.302 | 100052 / 397720 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 20555.687 (35818.077) | 42.611 | 1.274 | 665984 / 1099104 | 589824 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21842.657 (47208.34) | 53.731 | 1.214 | 35396 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21623.032 (27657.984) | 21.82 | 1.005 | 761128 / 1328420 | 756096 (2097152.0) | 126 / 96 | 0.0 / 0 |
| water_glass_oit | 113399.882 (197908.138) | 42.701 | 1.133 | 14064 / 17592 | 0 (2097152.0) | 203 / 223 | 0.0 / 0 |
| translucent_move_oit | 21810.039 (27958.922) | 21.993 | 1.005 | 755760 / 1320784 | 749440 (2097152.0) | 206 / 208 | 0.0 / 0 |
| flat_plants | 9102.132 (12478.858) | 27.06 | 1.045 | 266528 / 271636 | 0 (2097152.0) | 126 / 284 | 0.0 / 0 |
| renderer_off | 20763.432 (39371.186) | 47.262 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 57 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86772 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79744 / 123160 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.027 (100) | 2.94 (129) | 1.37 | 4.012 (59) | 0 | 863 / 0 | 7.97 / 11.131 | 4.291 / 6.274 |
| flythrough | 5.159 (1586) | 4.919 (1650) | 1.049 | 5.159 (1586) | 0 | 1396 / 0 | 7.669 / 10.448 | 5.154 / 7.324 |
| water_glass | 2.551 (14) | 1.028 (14) | 2.482 | None (0) | 0 | 1188 / 0 | 7.409 / 10.102 | 4.122 / 5.824 |
| nether | 2.999 (28) | 2.124 (31) | 1.412 | 2.648 (15) | 0 | 1823 / 0 | 6.32 / 8.53 | 3.582 / 5.056 |
| mobs | 1.012 (6) | 0.689 (13) | 1.469 | None (0) | 0 | 2061 / 0 | 6.168 / 8.257 | 3.532 / 4.911 |
| outline | 0.384 (12) | 0.325 (13) | 1.182 | None (0) | 0 | 2119 / 0 | 6.101 / 8.149 | 3.505 / 4.821 |
| occlusion | 1.529 (37) | 0.563 (42) | 2.716 | None (0) | 0 | 2245 / 0 | 5.942 / 7.926 | 3.346 / 4.71 |
| occlusion_move | 1.921 (54) | 1.271 (61) | 1.511 | 4.478 (16) | 0 | 2382 / 0 | 5.731 / 7.636 | 3.182 / 4.483 |
| occlusion_corner | 1.315 (82) | 1.005 (110) | 1.308 | 2.201 (1) | 0 | 2653 / 0 | 5.355 / 7.059 | 2.853 / 3.916 |
| translucent_move | 3.751 (109) | 2.358 (128) | 1.591 | 6.649 (36) | 0 | 3020 / 0 | 5.374 / 7.094 | 2.953 / 4.013 |
| water_glass_oit | 3.998 (154) | 2.984 (152) | 1.34 | None (0) | 0 | 413 / 0 | 8.558 / 10.789 | 4.826 / 6.423 |
| translucent_move_oit | 3.7 (216) | 3.891 (215) | 0.951 | 4.613 (25) | 0 | 960 / 0 | 6.073 / 7.683 | 3.427 / 4.412 |
| flat_plants | 2.187 (76) | 0.878 (101) | 2.491 | None (0) | 0 | 405 / 0 | 7.924 / 9.551 | 3.139 / 4.168 |
| renderer_off | 0.891 (22) | 0.432 (21) | 2.062 | None (0) | 0 | 327 / 0 | 8.155 / 12.825 | 4.078 / 5.737 |
| particles | 0.356 (24) | 0.216 (30) | 1.648 | None (0) | 0 | 3047 / 0 | 5.334 / 7.038 | 2.914 / 3.952 |
| animation | 1.184 (18) | 0.882 (18) | 1.342 | 1.503 (4) | 0 | 3122 / 0 | 5.238 / 6.896 | 2.827 / 3.829 |
| animated_items | 0.425 (32) | 0.206 (42) | 2.063 | 0.914 (2) | 0 | 3154 / 0 | 5.191 / 6.832 | 2.786 / 3.771 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.016 | 641.376 | 16 (vanilla 28) | 1320444 | 42.803 / 0.097 | 21.881 / 36.0 | 35.26 | 2360 / 0 | 4.012 (8.752) |
| flythrough | indirect, one multi-draw per arena and layer | 4.735 | 758.917 | 16 (vanilla 28) | 5089284 | 15.616 / 1.008 | 84.094 / 112.0 | 135.899 | 6405 / 0 | 5.159 (15.165) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 105.248 | 16 (vanilla 28) | 777948 | 35.132 / 0.086 | 12.539 / 36.0 | 20.773 | 3039 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.092 | 16 (vanilla 28) | 956788 | 29.35 / 0.184 | 15.236 / 20.0 | 25.549 | 4102 / 0 | 2.648 (3.784) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.11 | 16 (vanilla 28) | 606744 | 26.594 / 0.16 | 9.715 / 16.0 | 16.202 | 4554 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 86860 | 26.137 / 0.16 | 1.378 / 16.0 | 2.319 | 4647 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 151068 | 25.111 / 0.153 | 2.428 / 20.0 | 4.034 | 4863 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.869 | 33.837 | 16 (vanilla 28) | 201508 | 24.005 / 0.146 | 3.229 / 20.0 | 5.381 | 5111 / 0 | 4.478 (10.945) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.058 | 60.89 | 16 (vanilla 28) | 122728 | 22.787 / 0.139 | 1.931 / 20.0 | 3.277 | 5463 / 0 | 2.201 (2.198) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.167 | 23.104 | 16 (vanilla 28) | 797488 | 19.603 / 0.126 | 12.935 / 28.0 | 21.295 | 6308 / 0 | 6.649 (23.897) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.025 | 113.557 | 16 (vanilla 28) | 777948 | 7.491 / 0.043 | 12.539 / 20.0 | 20.773 | 1086 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.218 | 37.335 | 16 (vanilla 28) | 771652 | 6.709 / 0.095 | 12.524 / 28.0 | 20.605 | 2403 / 0 | 4.613 (16.125) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.044 | 16 (vanilla 28) | 876304 | 5.947 / 0.01 | 14.058 / 24.0 | 23.4 | 909 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.038 | 16 (vanilla 28) | 550324 | 2.38 / 0.02 | 8.763 / 24.0 | 14.695 | 609 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 19.563 / 0.125 | 0.131 / 28.0 | 0.225 | 6347 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 19.408 / 0.124 | 0.302 / 28.0 | 0.518 | 6449 / 0 | 1.503 (2.103) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 19.354 / 0.125 | 0.153 / 28.0 | 0.261 | 6498 / 0 | 0.914 (1.452) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 152.0 | 1.0 | 0.0 | 0 | 0 | 51 (0.024 / 0.038 / 0.053; 0) | 0 | 28880 / 0 / 0 |
| flythrough | 188.421 | 1.0 | 0.0 | 0 | 0 | 848 (0.038 / 0.052 / 4.67; 0) | 39 | 25060 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1700 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 38 (0.009 / 0.026 / 0.028; 0) | 32 | 1192 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.117 / 0.161 / 2.545; 0) | 180 | 3521 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 612 | 0 (None / None / None; 0) | 0 | 816 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 621 | 0 (None / None / None; 0) | 0 | 1449 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2008 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2344 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 325.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.031 (0.082; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.842 | 1.0 (0.0, 0.0) | 1.203 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.046; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.126 (0.263; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.074 (0.127; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.349 | 10.0 (9.0, 2.361) | 6.0 (6.0, 2.279) | 0.067 (0.298; 0) | 0 | 2765 / 1496970 / 0 / 0 |
| occlusion_corner | 81.867 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.219 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.855 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 259.0 / 323.0 (19.8) | 259.0 / 64.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3072 / 0 |
| flythrough | two-phase | 313.97 / 403.11 (22.1) | 306.84 / 96.27 / 7.13 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 2950 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.03; 100.0) | 14400.0 | 9222 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 30771 / 0 |
| mobs | two-phase | 32.0 / 108.0 (70.4) | 32.0 / 76.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10336 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.39 / 51.3 (56.4) | 22.33 / 28.97 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4306 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.69 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3164 / 0 |
| translucent_move | two-phase | 15.66 / 136.08 (88.5) | 15.64 / 120.44 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15059 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4437 / 0 |
| translucent_move_oit | two-phase | 15.7 / 136.22 (88.5) | 15.65 / 120.57 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6268 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 17875 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14746 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.402 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 135.449 / 0.4 | 0.039 / 0.014 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.288 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.827 |
| water_glass | 112.393 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.055 / 54.066 | 0.019 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.484 | 0.84 / 0.817 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 44.778 / 5.609 | 0.073 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 93.117 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 111.354 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.163 / 12.107 | 0.005 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 58.409 / 58.426 | 0.017 / 0.027 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.085 / 12.101 | 0.005 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 114.708 / 7.505 | 0.982 / 0.986 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.372 / 3.046 | 0.016 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.056 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.277 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.004 / 0.01 | 56 (3) | 40.51 / 9.24 / 31.27 | 3 / 0 | 10.987 |
| animated_items | 136.793 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 49.29 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.4 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 66.82 (reported, not gated) | 45 (reported, not gated) | 553788 (reported, not gated) | 310.41 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.88 (base 20.0) | 13 (base 14) | 7092 (base 10264) | 238.0 (base 249.83) | 4.24 (base 5.99) |
| nether | 23.83 (base 33.79) | 10 (base 11) | 4176 (base 10656) | 259.37 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.71 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.02 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.88 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.71 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.73 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.05 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.09 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.39 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 18.0 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 274.62 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7428 (base 7604) | 237.05 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.52 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 239.71 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 16.84 (base 33.0) | 12 (base 13) | 1604 (base 1716) | 239.31 (base 248.11) | 3.21 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.13 (base 240.73) | 3.35 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.79 (base 261.4) | 4.24 (base 4.24) |
| animation | 50 median (avg 40.04) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.05 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 47.04) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.58 (base 239.53) | 4.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.29 / 49 (9.61) | 896.17 / 896 (10.13) | median and average, x 1.10 + 2 |
| flythrough | 66.82 / 64 (7.22) | 999.83 / 1009 (5.58) | median and average, at most vanilla |
| water_glass | 19.88 / 20 (22.16) | 390.0 / 390 (16.73) | median, at most vanilla |
| nether | 23.83 / 26 (24.84) | 588.82 / 589 (16.64) | median, x 1.10 + 2 |
| mobs | 25.71 / 26 (27.91) | 322.12 / 330 (21.36) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 127.2 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 18.71 / 19 (30.0) | 161.27 / 200 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 24.05 / 24 (29.9) | 166.7 / 201 (29.99) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (30.0) | 163.14 / 201 (29.99) | median and average, x 1.10 + 2 |
| translucent_move | 18.0 / 18 (18.76) | 367.84 / 367 (17.62) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (10.6) | 401.0 / 401 (8.67) | median, at most vanilla |
| translucent_move_oit | 25.52 / 26 (8.68) | 385.08 / 386 (8.67) | median and average, at most vanilla |
| flat_plants | 16.84 / 19 (25.71) | 400.0 / 400 (17.6) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.93) | 301.8 / 325 (25.01) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.2 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.04 / 50 (30.0) | 156.46 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.04 / 60 (30.0) | 167.46 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.017 | 36.0 / 23.017 | 0.0 / 0.0 | 416.0 / 38.312 |
| flythrough | 112.0 / 86.296 | 112.0 / 86.296 | 0.0 / 0.0 | 416.0 / 143.536 |
| water_glass | 36.0 / 12.734 | 36.0 / 12.734 | 0.0 / 0.0 | 416.0 / 21.799 |
| nether | 20.0 / 15.23 | 20.0 / 15.23 | 0.0 / 0.0 | 256.0 / 26.724 |
| mobs | 16.0 / 9.715 | 16.0 / 9.715 | 0.0 / 0.0 | 256.0 / 17.006 |
| outline | 16.0 / 1.378 | 16.0 / 1.378 | 0.0 / 0.0 | 256.0 / 2.448 |
| occlusion | 20.0 / 2.612 | 20.0 / 2.612 | 0.0 / 0.0 | 416.0 / 4.161 |
| occlusion_move | 20.0 / 3.366 | 20.0 / 3.366 | 0.0 / 0.0 | 416.0 / 5.557 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.04 | 28.0 / 13.04 | 0.0 / 0.0 | 416.0 / 22.132 |
| water_glass_oit | 20.0 / 12.539 | 20.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.799 |
| translucent_move_oit | 28.0 / 12.684 | 28.0 / 12.684 | 0.0 / 0.0 | 416.0 / 21.513 |
| flat_plants | 24.0 / 13.993 | 24.0 / 13.993 | 0.0 / 0.0 | 416.0 / 24.218 |
| renderer_off | 24.0 / 8.763 | 24.0 / 8.763 | 0.0 / 0.0 | 416.0 / 15.427 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 421043.083 (638891.802) | 34.098 | 1.774 | 382324 / 1226688 | 380272 (2097152.0) | 192 / 202 | 0.0 / 0 |
| flythrough | 553728.333 (886782.694) | 37.558 | 1.084 | 2104524 / 7022248 | 2096904 (2097152.0) | 144 / 111 | 7.303 / 69 |
| water_glass | 113098.727 (197382.555) | 42.701 | 1.133 | 9108 / 11540 | 0 (2097152.0) | 113 / 334 | 0.0 / 0 |
| nether | 46881.727 (73931.458) | 36.588 | 1.864 | 236252 / 245632 | 229952 (2097152.0) | 154 / 332 | 0.0 / 0 |
| mobs | 62045.192 (110786.542) | 43.996 | 0.967 | 610676 / 612404 | 0 (2097152.0) | 43 / 17 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29769.796 (52501.683) | 43.297 | 1.278 | 472420 / 302444 | 374272 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50871.007 (89499.92) | 43.161 | 1.226 | 651068 / 1135564 | 576000 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27758.835 (60456.805) | 54.085 | 1.272 | 32932 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 201943.397 (358466.368) | 43.665 | 1.183 | 758468 / 1317300 | 755968 (2097152.0) | 324 / 352 | 0.0 / 0 |
| water_glass_oit | 113378.806 (197871.355) | 42.701 | 1.133 | 10116 / 10980 | 0 (2097152.0) | 211 / 173 | 0.0 / 0 |
| translucent_move_oit | 202681.873 (359460.382) | 43.615 | 1.181 | 754020 / 1317700 | 749440 (2097152.0) | 173 / 173 | 0.0 / 0 |
| flat_plants | 9101.673 (12478.23) | 27.06 | 1.045 | 2052 / 4564 | 0 (2097152.0) | 129 / 351 | 0.0 / 0 |
| renderer_off | 20762.604 (39369.616) | 47.262 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 7 / 5 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3044.12 (5227.76) | 41.77 | 1.087 | 86232 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2246.003 (4830.871) | 53.507 | 1.0 | 79304 / 122900 | 57728 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.928 (96) | 3.422 (143) | 1.148 | 4.138 (48) | 0 | 873 / 0 | 7.356 / 10.478 | 3.722 / 4.727 |
| flythrough | 5.94 (1645) | 6.932 (1551) | 0.857 | 5.94 (1645) | 0 | 1398 / 0 | 6.799 / 8.854 | 4.491 / 6.226 |
| water_glass | 1.891 (14) | 2.356 (14) | 0.803 | None (0) | 0 | 1193 / 0 | 7.016 / 9.747 | 3.622 / 4.567 |
| nether | 2.546 (26) | 3.01 (31) | 0.846 | 2.888 (16) | 0 | 1826 / 0 | 5.787 / 7.902 | 3.031 / 3.915 |
| mobs | 0.839 (6) | 0.447 (3) | 1.877 | None (0) | 0 | 2058 / 0 | 5.711 / 7.666 | 2.953 / 3.858 |
| outline | 0.741 (13) | 0.686 (12) | 1.08 | None (0) | 0 | 2116 / 0 | 5.632 / 7.562 | 2.911 / 3.812 |
| occlusion | 1.282 (56) | 0.906 (43) | 1.415 | 3.917 (4) | 0 | 2253 / 0 | 5.482 / 7.356 | 2.838 / 3.705 |
| occlusion_move | 2.109 (69) | 2.284 (65) | 0.923 | 3.905 (21) | 0 | 2409 / 0 | 5.262 / 7.051 | 2.713 / 3.585 |
| occlusion_corner | 1.356 (110) | 1.351 (110) | 1.004 | 1.107 (1) | 0 | 2689 / 0 | 4.937 / 6.576 | 2.451 / 3.284 |
| translucent_move | 3.617 (111) | 4.208 (122) | 0.86 | 5.21 (39) | 0 | 3066 / 0 | 4.92 / 6.55 | 2.558 / 3.463 |
| water_glass_oit | 3.789 (154) | 3.673 (150) | 1.032 | None (0) | 0 | 412 / 0 | 9.417 / 12.129 | 5.056 / 6.993 |
| translucent_move_oit | 3.857 (218) | 4.818 (213) | 0.801 | 6.175 (26) | 0 | 957 / 0 | 6.353 / 8.517 | 3.453 / 4.597 |
| flat_plants | 1.723 (88) | 1.283 (88) | 1.343 | None (0) | 0 | 405 / 0 | 7.797 / 9.374 | 3.514 / 4.306 |
| renderer_off | 0.735 (21) | 0.528 (22) | 1.392 | None (0) | 0 | 332 / 0 | 8.532 / 11.129 | 3.584 / 5.051 |
| particles | 0.414 (30) | 0.433 (30) | 0.956 | None (0) | 0 | 3093 / 0 | 4.881 / 6.498 | 2.516 / 3.418 |
| animation | 1.017 (18) | 1.051 (18) | 0.968 | 0.989 (4) | 0 | 3168 / 0 | 4.789 / 6.372 | 2.423 / 3.289 |
| animated_items | 0.323 (42) | 0.839 (32) | 0.385 | 0.719 (2) | 0 | 3200 / 0 | 4.748 / 6.315 | 2.39 / 3.212 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.203 | 729.286 | 16 (vanilla 28) | 1389508 | 41.435 / 0.105 | 23.017 / 36.0 | 37.104 | 2338 / 0 | 4.138 (9.979) |
| flythrough | plain, one multi-draw per region and layer | 57.097 | 906.278 | 16 (vanilla 28) | 5221628 | 15.486 / 1.045 | 86.296 / 112.0 | 139.433 | 6544 / 0 | 5.94 (17.105) |
| water_glass | plain, one multi-draw per region and layer | 14.032 | 105.237 | 16 (vanilla 28) | 788956 | 34.028 / 0.091 | 12.734 / 36.0 | 21.067 | 3003 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.602 | 73.882 | 16 (vanilla 28) | 956756 | 28.461 / 0.181 | 15.23 / 20.0 | 25.548 | 4058 / 0 | 2.888 (4.914) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.108 | 16 (vanilla 28) | 606744 | 25.834 / 0.158 | 9.715 / 16.0 | 16.202 | 4497 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 86860 | 25.375 / 0.157 | 1.378 / 16.0 | 2.319 | 4591 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.05 | 43.342 | 16 (vanilla 28) | 163580 | 24.053 / 0.148 | 2.612 / 20.0 | 4.368 | 4858 / 0 | 3.917 (5.987) |
| occlusion_move | plain, one multi-draw per region and layer | 10.988 | 75.36 | 16 (vanilla 28) | 211760 | 22.71 / 0.14 | 3.366 / 20.0 | 5.655 | 5167 / 0 | 3.905 (7.476) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.913 | 16 (vanilla 28) | 122728 | 21.429 / 0.132 | 1.931 / 20.0 | 3.277 | 5556 / 0 | 1.107 (1.094) |
| translucent_move | plain, one multi-draw per region and layer | 12.011 | 247.909 | 16 (vanilla 28) | 806276 | 18.503 / 0.12 | 13.04 / 28.0 | 21.53 | 6425 / 0 | 5.21 (15.529) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.076 | 113.536 | 16 (vanilla 28) | 777948 | 7.488 / 0.043 | 12.539 / 20.0 | 20.773 | 1084 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.613 | 263.468 | 16 (vanilla 28) | 783716 | 6.609 / 0.092 | 12.684 / 28.0 | 20.927 | 2407 / 0 | 6.175 (19.182) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 872892 | 6.27 / 0.01 | 13.993 / 24.0 | 23.309 | 937 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 550324 | 2.358 / 0.02 | 8.763 / 24.0 | 14.695 | 617 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.462 / 0.12 | 0.131 / 28.0 | 0.225 | 6467 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 18.317 / 0.119 | 0.302 / 28.0 | 0.518 | 6569 / 0 | 0.989 (1.503) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 18.266 / 0.119 | 0.153 / 28.0 | 0.261 | 6619 / 0 | 0.719 (1.092) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 38 (0.221 / 0.073 / 7.09; 0) | 0 | 30108 / 0 / 0 |
| flythrough | 189.297 | 26.028 | 0.0 | 0 | 0 | 884 (0.03 / 0.052 / 9.088; 0) | 49 | 27448 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1776 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.012 / 0.02; 0) | 32 | 1198 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.124 / 0.186 / 0.521; 0) | 180 | 2632 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 636 | 0 (None / None / None; 0) | 0 | 848 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 522 | 0 (None / None / None; 0) | 0 | 1218 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2060 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.959 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.031 (0.088; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.414 | 1.0 (0.0, 0.0) | 1.138 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.057; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.108 (0.266; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.057 (0.094; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.356 | 10.0 (9.0, 2.366) | 6.0 (6.0, 2.279) | 0.049 (0.291; 0) | 0 | 2782 / 1506270 / 0 / 0 |
| occlusion_corner | 81.864 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.064 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.626 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.005 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 304.8 / 349.94 (12.9) | 304.8 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1641.45 | 1998 / 0 |
| flythrough | still | 404.21 / 404.65 (0.1) | 404.21 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 9657 / 0 |
| nether | still | 55.97 / 300.0 (81.3) | 55.97 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 346.29 | 30771 / 0 |
| mobs | still | 32.0 / 108.0 (70.4) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10640 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.23 / 49.0 (46.5) | 26.23 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.0 | 3404 / 0 |
| occlusion_move | still | 51.18 / 51.31 (0.2) | 51.18 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.73 / 81.86 (0.2) | 81.73 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 135.31 / 135.89 (0.4) | 135.31 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4611 / 0 |
| translucent_move_oit | still | 135.23 / 135.86 (0.5) | 135.23 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 152.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 18304 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 306 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 54 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.168 / 0.12 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 99.393 / 0.145 | 0.026 / 0.008 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.07 / 0.0 | 0.003 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.834 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.778 / 52.773 | 0.011 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.691 | 0.898 / 0.769 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 43.848 / 8.898 | 0.075 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 107.19 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.483 / 12.418 | 0.004 / 0.01 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.978 / 54.094 | 0.011 / 0.019 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.748 / 13.575 | 0.005 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.49 | 1.0 / 0.605 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.5 / 2.336 | 0.013 / 0.006 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 92.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.539 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.003 / 0.039 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.287 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.003 / 0.006 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | 136.793 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 13.53 (base 14.05) | 15 (base 15) | 25200 (base 27764) | 252.5 (base 257.2) | 4.23 (base 3.98) |
| flythrough | 13.05 (reported, not gated) | 45 (reported, not gated) | 1204768 (reported, not gated) | 307.17 (base 318.06) | 3.71 (base 4.23) |
| water_glass | 9.0 (base 9.0) | 15 (base 15) | 11712 (base 15108) | 237.64 (base 244.39) | 4.23 (base 4.23) |
| nether | 13.71 (base 15.71) | 12 (base 12) | 11380 (base 19912) | 259.51 (base 268.95) | 4.23 (base 4.23) |
| mobs | 19.81 (base 19.97) | 16 (base 17) | 613404 (base 1008176) | 257.98 (base 264.31) | 4.23 (base 6.23) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 257.5 (base 264.58) | 4.23 (base 3.71) |
| occlusion | 15.68 (base 15.67) | 15 (base 15) | 100048 (base 126356) | 263.04 (base 264.78) | 4.23 (base 3.98) |
| occlusion_move | 16.07 (reported, not gated) | 15 (reported, not gated) | 82560 (reported, not gated) | 263.71 (base 265.16) | 4.23 (base 4.23) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 267.85 (base 266.66) | 4.23 (base 3.71) |
| translucent_move | 9.0 (reported, not gated) | 15 (reported, not gated) | 11076 (reported, not gated) | 274.52 (base 268.35) | 4.23 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 11824 (base 15024) | 237.85 (base 245.99) | 3.34 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 11244 (reported, not gated) | 240.58 (base 248.38) | 3.46 (base 3.46) |
| flat_plants | 16.1 (base 18.96) | 15 (base 15) | 4532 (base 9864) | 239.06 (base 248.07) | 3.2 (base 5.98) |
| renderer_off | 7.72 (base 7.83) | 14 (base 14) | 3612 (base 7180) | 232.94 (base 241.13) | 3.34 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 265.43 (base 261.4) | 4.23 (base 5.98) |
| animation | 50 median (avg 40.17) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.94 (base 260.68) | 4.23 (base 5.98) |
| animated_items | 60 median (avg 47.09) (base 60) | 22 (base 23) | 21816 (base 21940) | 236.34 (base 239.74) | 4.23 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.53 / 13 (8.41) | 123.08 / 123 (11.61) | median and average, x 1.10 + 2 |
| flythrough | 13.05 / 13 (5.15) | 123.06 / 123 (7.32) | median and average, at most vanilla + 2 |
| water_glass | 9.0 / 9 (16.51) | 124.0 / 124 (18.56) | median, at most vanilla |
| nether | 13.71 / 16 (20.33) | 120.96 / 121 (18.65) | median, x 1.10 + 2 |
| mobs | 19.81 / 20 (23.41) | 116.1 / 134 (23.64) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (30.0) | 87.33 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.68 / 16 (29.72) | 94.33 / 133 (29.99) | median and average, x 1.10 + 2 |
| occlusion_move | 16.07 / 17 (28.57) | 94.33 / 133 (29.98) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (29.82) | 82.33 / 121 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 9.0 / 9 (14.36) | 123.1 / 124 (19.31) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (8.16) | 129.0 / 129 (10.22) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (7.03) | 129.0 / 129 (9.79) | median and average, at most vanilla |
| flat_plants | 16.1 / 19 (23.17) | 124.0 / 124 (19.23) | median, x 1.10 + 2 |
| renderer_off | 7.72 / 8 (27.65) | 89.06 / 123 (28.21) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.17 / 50 (29.91) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.09 / 60 (29.95) | 155.22 / 190 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.56 | 36.0 / 22.56 | 0.0 / 0.0 | 416.0 / 38.893 |
| flythrough | 112.0 / 83.588 | 112.0 / 83.588 | 0.0 / 0.0 | 416.0 / 147.685 |
| water_glass | 36.0 / 12.539 | 36.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.799 |
| nether | 20.0 / 15.233 | 20.0 / 15.233 | 0.0 / 0.0 | 256.0 / 26.728 |
| mobs | 16.0 / 9.715 | 16.0 / 9.715 | 0.0 / 0.0 | 256.0 / 17.006 |
| outline | 16.0 / 1.378 | 16.0 / 1.378 | 0.0 / 0.0 | 256.0 / 2.448 |
| occlusion | 20.0 / 2.772 | 20.0 / 2.772 | 0.0 / 0.0 | 416.0 / 4.814 |
| occlusion_move | 20.0 / 3.514 | 20.0 / 3.514 | 0.0 / 0.0 | 416.0 / 6.136 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.191 | 28.0 / 13.191 | 0.0 / 0.0 | 416.0 / 22.81 |
| water_glass_oit | 20.0 / 12.539 | 20.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.799 |
| translucent_move_oit | 28.0 / 12.78 | 28.0 / 12.78 | 0.0 / 0.0 | 416.0 / 22.175 |
| flat_plants | 24.0 / 14.155 | 24.0 / 14.155 | 0.0 / 0.0 | 416.0 / 24.656 |
| renderer_off | 24.0 / 8.763 | 24.0 / 8.763 | 0.0 / 0.0 | 416.0 / 15.427 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 482184.286 (650300.107) | 25.852 | 1.168 | 362888 / 749268 | 337688 (2097152.0) | 168 / 232 | 0.0 / 0 |
| flythrough | 537027.981 (859979.146) | 37.553 | 1.083 | 2121400 / 7089288 | 2093952 (2097152.0) | 103 / 146 | 6.019 / 45 |
| water_glass | 113185.952 (197534.782) | 42.701 | 1.133 | 13616 / 17144 | 0 (2097152.0) | 330 / 371 | 0.0 / 0 |
| nether | 77554.385 (114565.946) | 32.306 | 1.503 | 265652 / 457844 | 243712 (2097152.0) | 152 / 373 | 0.0 / 0 |
| mobs | 62066.338 (110824.299) | 43.996 | 0.967 | 613404 / 616364 | 0 (2097152.0) | 117 / 5 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 32349.513 (57606.208) | 43.844 | 1.276 | 271740 / 443024 | 171072 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 53357.874 (94485.219) | 43.528 | 1.22 | 644596 / 1098468 | 567680 (2097152.0) | 6 / 0 | 0.0 / 0 |
| occlusion_corner | 27753.356 (60451.557) | 54.09 | 1.272 | 36188 / 59420 | 31552 (2097152.0) | 3 / 0 | 0.0 / 0 |
| translucent_move | 204841.199 (363330.328) | 43.621 | 1.181 | 766892 / 1332972 | 756096 (2097152.0) | 286 / 314 | 0.0 / 0 |
| water_glass_oit | 113536.294 (198146.209) | 42.701 | 1.133 | 13168 / 16584 | 0 (2097152.0) | 163 / 204 | 0.0 / 0 |
| translucent_move_oit | 205408.557 (363968.3) | 43.564 | 1.179 | 761052 / 1321640 | 749440 (2097152.0) | 140 / 195 | 0.0 / 0 |
| flat_plants | 9103.62 (12480.898) | 27.06 | 1.045 | 4848 / 10144 | 0 (2097152.0) | 115 / 384 | 0.0 / 0 |
| renderer_off | 20765.551 (39375.203) | 47.262 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 7 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3061.227 (5267.565) | 41.885 | 1.085 | 86832 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2245.967 (4830.786) | 53.507 | 1.0 | 79544 / 123000 | 57728 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.06 (129) | 2.024 (114) | 1.512 | 3.019 (53) | 0 | 872 / 0 | 8.365 / 11.157 | 4.142 / 5.645 |
| flythrough | 6.571 (1476) | 4.7 (1651) | 1.398 | 6.571 (1476) | 0 | 1397 / 0 | 7.632 / 10.29 | 4.848 / 6.874 |
| water_glass | 2.491 (14) | 1.24 (16) | 2.009 | None (0) | 0 | 1202 / 0 | 7.689 / 10.243 | 3.895 / 5.39 |
| nether | 2.58 (42) | 1.789 (46) | 1.442 | 2.797 (25) | 0 | 1830 / 0 | 6.467 / 8.543 | 3.377 / 4.614 |
| mobs | 0.987 (6) | 0.547 (13) | 1.804 | None (0) | 0 | 2063 / 0 | 6.442 / 8.525 | 3.347 / 4.498 |
| outline | 0.541 (13) | 0.275 (13) | 1.967 | None (0) | 0 | 2121 / 0 | 6.352 / 8.402 | 3.293 / 4.441 |
| occlusion | 1.309 (44) | 0.583 (46) | 2.245 | 3.428 (4) | 0 | 2263 / 0 | 6.285 / 8.284 | 3.237 / 4.358 |
| occlusion_move | 2.191 (65) | 1.272 (59) | 1.722 | 4.401 (16) | 0 | 2422 / 0 | 6.036 / 7.94 | 3.079 / 4.198 |
| occlusion_corner | 1.393 (101) | 0.812 (110) | 1.716 | 1.706 (1) | 0 | 2702 / 0 | 5.648 / 7.375 | 2.795 / 3.772 |
| translucent_move | 3.17 (112) | 1.91 (146) | 1.66 | 4.149 (39) | 0 | 3069 / 0 | 5.626 / 7.337 | 2.905 / 3.9 |
| water_glass_oit | 4.052 (152) | 2.307 (148) | 1.756 | None (0) | 0 | 413 / 0 | 7.938 / 9.782 | 4.387 / 5.384 |
| translucent_move_oit | 3.57 (212) | 3.144 (220) | 1.135 | 4.269 (26) | 0 | 956 / 0 | 6.008 / 7.426 | 3.365 / 4.379 |
| flat_plants | 2.004 (79) | 1.085 (94) | 1.847 | None (0) | 0 | 410 / 0 | 7.861 / 9.217 | 2.982 / 3.663 |
| renderer_off | 0.523 (24) | 0.386 (20) | 1.355 | None (0) | 0 | 338 / 0 | 8.854 / 12.246 | 4.314 / 5.688 |
| particles | 0.483 (30) | 0.212 (30) | 2.278 | None (0) | 0 | 3101 / 0 | 5.582 / 7.279 | 2.842 / 3.83 |
| animation | 1.122 (18) | 0.761 (18) | 1.474 | 1.673 (4) | 0 | 3176 / 0 | 5.478 / 7.135 | 2.739 / 3.678 |
| animated_items | 0.536 (32) | 0.213 (42) | 2.516 | 1.107 (2) | 0 | 3208 / 0 | 5.43 / 7.071 | 2.689 / 3.61 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.018 | 745.042 | 16 (vanilla 28) | 1362540 | 42.022 / 0.114 | 22.56 / 36.0 | 36.384 | 2443 / 0 | 3.019 (4.997) |
| flythrough | indirect, one multi-draw per arena and layer | 3.029 | 873.903 | 16 (vanilla 28) | 5060780 | 15.961 / 1.044 | 83.588 / 112.0 | 135.137 | 6177 / 0 | 6.571 (19.335) |
| water_glass | indirect, one multi-draw per arena and layer | 3.009 | 105.318 | 16 (vanilla 28) | 777948 | 34.337 / 0.103 | 12.539 / 36.0 | 20.773 | 3135 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.005 | 113.58 | 16 (vanilla 28) | 956836 | 28.841 / 0.181 | 15.233 / 20.0 | 25.55 | 4207 / 0 | 2.797 (4.58) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.128 | 16 (vanilla 28) | 606744 | 26.242 / 0.159 | 9.715 / 16.0 | 16.202 | 4649 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 86860 | 25.792 / 0.158 | 1.378 / 16.0 | 2.319 | 4743 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.657 | 16 (vanilla 28) | 174352 | 24.433 / 0.149 | 2.772 / 20.0 | 4.656 | 5003 / 0 | 3.428 (5.531) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.004 | 77.224 | 16 (vanilla 28) | 221500 | 22.981 / 0.14 | 3.514 / 20.0 | 5.915 | 5310 / 0 | 4.401 (7.283) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.903 | 16 (vanilla 28) | 122728 | 21.752 / 0.133 | 1.931 / 20.0 | 3.277 | 5691 / 0 | 1.706 (1.704) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.007 | 249.948 | 16 (vanilla 28) | 815924 | 18.787 / 0.119 | 13.191 / 28.0 | 21.788 | 6542 / 0 | 4.149 (13.343) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.031 | 113.693 | 16 (vanilla 28) | 777948 | 7.445 / 0.041 | 12.539 / 20.0 | 20.773 | 1082 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.036 | 265.529 | 16 (vanilla 28) | 790008 | 6.446 / 0.081 | 12.78 / 28.0 | 21.095 | 2395 / 0 | 4.269 (11.187) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.048 | 16 (vanilla 28) | 883828 | 5.944 / 0.01 | 14.155 / 24.0 | 23.601 | 926 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.04 | 16 (vanilla 28) | 550332 | 2.315 / 0.019 | 8.763 / 24.0 | 14.695 | 633 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 18.7 / 0.118 | 0.131 / 28.0 | 0.225 | 6594 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.766 | 16 (vanilla 28) | 19416 | 18.558 / 0.118 | 0.302 / 28.0 | 0.518 | 6696 / 0 | 1.673 (2.648) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 18.509 / 0.118 | 0.153 / 28.0 | 0.261 | 6745 / 0 | 1.107 (1.561) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 1.0 | 0.0 | 0 | 0 | 50 (0.026 / 0.044 / 0.057; 0) | 0 | 26195 / 0 / 0 |
| flythrough | 181.413 | 1.0 | 0.0 | 0 | 0 | 806 (0.042 / 0.056 / 6.087; 0) | 36 | 18867 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1324 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1192 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 38 (0.01 / 0.015 / 0.05; 0) | 32 | 1144 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.116 / 0.186 / 0.512; 0) | 180 | 2016 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 492 | 0 (None / None / None; 0) | 0 | 656 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 423 | 0 (None / None / None; 0) | 0 | 987 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1856 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2212 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 345.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.075; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 428.981 | 1.0 (0.0, 0.0) | 1.221 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.056; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.118 (0.235; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 50.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.067 (0.124; 0) | 0 | 3576 / 1618736 / 0 / 0 |
| occlusion_move | 52.315 | 10.0 (9.0, 2.348) | 6.0 (6.0, 2.28) | 0.064 (0.318; 0) | 0 | 2647 / 1431672 / 0 / 0 |
| occlusion_corner | 81.853 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 137.097 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 137.709 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.594 (0.0, 0.0) | 0.001 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 314.6 / 343.0 (8.3) | 314.6 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1533.73 | 1125 / 0 |
| flythrough | still | 387.96 / 388.57 (0.2) | 387.96 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7134 / 0 |
| nether | still | 80.4 / 300.0 (73.2) | 80.4 / 0.0 / 0.0 | 0.04 | 0.0 (0.0, 0.0; 0.0) | 602.96 | 22092 / 0 |
| mobs | still | 32.0 / 108.0 (70.4) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 8892 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.48 / 50.0 (47.0) | 26.48 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 72.48 | 3480 / 0 |
| occlusion_move | still | 52.13 / 52.26 (0.3) | 52.13 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.71 / 81.84 (0.2) | 81.71 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 136.11 / 136.88 (0.6) | 136.11 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3480 / 0 |
| translucent_move_oit | still | 135.99 / 136.77 (0.6) | 135.99 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 153.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 16560 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 13938 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1177.96 | 372 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4495.49 | 54 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.082 / 0.423 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 135.622 / 0.42 | 0.027 / 0.017 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.817 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.536 / 51.547 | 0.015 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.951 | 0.96 / 0.923 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.565 / 10.091 | 0.072 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 97.252 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 114.106 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.805 / 12.726 | 0.004 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.055 / 52.085 | 0.011 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.855 / 14.773 | 0.006 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.43 | 1.0 / 0.927 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.496 / 2.386 | 0.013 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 81.356 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.047 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.415 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.796 | 0.005 / 0.01 | 56 (3) | 40.564 / 9.239 / 31.324 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.11 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 50.26 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.28 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 69.9 (reported, not gated) | 43 (reported, not gated) | 627012 (reported, not gated) | 309.05 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 20.89 (base 20.0) | 13 (base 14) | 7764 (base 10264) | 237.62 (base 249.83) | 3.99 (base 5.99) |
| nether | 23.89 (base 33.79) | 10 (base 11) | 3976 (base 10656) | 258.81 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.74 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 257.14 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.95 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 262.65 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.26 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.72 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.37 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.14 (reported, not gated) | 13 (reported, not gated) | 2968 (reported, not gated) | 273.84 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7764 (base 7604) | 238.25 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.45 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 240.83 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.19 (base 33.0) | 13 (base 13) | 1624 (base 1716) | 239.29 (base 248.11) | 3.21 (base 5.99) |
| renderer_off | 13.69 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.18 (base 240.73) | 3.35 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.15 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.97) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.3 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 22 (base 22) | 21668 (base 21668) | 235.94 (base 239.53) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.26 / 50 (10.58) | 896.17 / 896 (10.13) | median and average, x 1.10 + 2 |
| flythrough | 69.9 / 69 (6.92) | 999.83 / 1009 (5.58) | median and average, at most vanilla |
| water_glass | 20.89 / 21 (21.48) | 390.0 / 390 (16.73) | median, at most vanilla |
| nether | 23.89 / 26 (25.74) | 588.82 / 589 (16.64) | median, x 1.10 + 2 |
| mobs | 26.74 / 27 (27.15) | 322.12 / 330 (21.36) | median, x 1.10 + 2 |
| outline | 11.67 / 12 (30.0) | 127.2 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 19.67 / 20 (29.94) | 161.27 / 200 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 20.09 / 21 (29.86) | 166.7 / 201 (29.99) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.72 / 12 (30.0) | 163.14 / 201 (29.99) | median and average, x 1.10 + 2 |
| translucent_move | 11.14 / 11 (25.78) | 367.84 / 367 (17.62) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (10.76) | 401.0 / 401 (8.67) | median, at most vanilla |
| translucent_move_oit | 18.45 / 18 (11.1) | 385.08 / 386 (8.67) | median and average, at most vanilla |
| flat_plants | 18.19 / 21 (25.17) | 400.0 / 400 (17.6) | median, x 1.10 + 2 |
| renderer_off | 13.69 / 14 (29.0) | 301.8 / 325 (25.01) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (30.0) | 97.2 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.97 / 50 (30.0) | 156.46 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.0) | 167.46 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.897 | 36.0 / 22.897 | 0.0 / 0.0 | 416.0 / 38.312 |
| flythrough | 112.0 / 84.838 | 112.0 / 84.838 | 0.0 / 0.0 | 416.0 / 143.536 |
| water_glass | 36.0 / 12.629 | 36.0 / 12.629 | 0.0 / 0.0 | 416.0 / 21.799 |
| nether | 20.0 / 15.238 | 20.0 / 15.238 | 0.0 / 0.0 | 256.0 / 26.724 |
| mobs | 16.0 / 9.715 | 16.0 / 9.715 | 0.0 / 0.0 | 256.0 / 17.006 |
| outline | 16.0 / 1.378 | 16.0 / 1.378 | 0.0 / 0.0 | 256.0 / 2.448 |
| occlusion | 20.0 / 2.478 | 20.0 / 2.478 | 0.0 / 0.0 | 416.0 / 4.161 |
| occlusion_move | 20.0 / 3.32 | 20.0 / 3.32 | 0.0 / 0.0 | 416.0 / 5.557 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.011 | 28.0 / 13.011 | 0.0 / 0.0 | 416.0 / 22.132 |
| water_glass_oit | 20.0 / 12.539 | 20.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.799 |
| translucent_move_oit | 28.0 / 12.533 | 28.0 / 12.533 | 0.0 / 0.0 | 416.0 / 21.513 |
| flat_plants | 24.0 / 14.125 | 24.0 / 14.125 | 0.0 / 0.0 | 416.0 / 24.218 |
| renderer_off | 24.0 / 8.763 | 24.0 / 8.763 | 0.0 / 0.0 | 416.0 / 15.427 |
| particles | 28.0 / 0.198 | 28.0 / 0.198 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.369 | 28.0 / 0.369 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.22 | 28.0 / 0.22 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 396625.934 (596355.678) | 33.492 | 1.772 | 339044 / 1226688 | 337664 (2097152.0) | 211 / 202 | 0.0 / 0 |
| flythrough | 484670.681 (764685.725) | 36.618 | 1.085 | 2106164 / 7022248 | 2095648 (2097152.0) | 138 / 111 | 7.806 / 68 |
| water_glass | 113107.04 (197397.063) | 42.701 | 1.133 | 9556 / 11540 | 0 (2097152.0) | 112 / 334 | 0.0 / 0 |
| nether | 29509.3 (42408.346) | 30.416 | 2.0 | 222024 / 245632 | 217472 (2097152.0) | 129 / 332 | 0.0 / 0 |
| mobs | 62048.059 (110791.661) | 43.996 | 0.967 | 610676 / 612404 | 0 (2097152.0) | 39 / 17 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27345.712 (47755.846) | 42.739 | 1.302 | 382792 / 302444 | 284736 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 21052.456 (36825.359) | 42.832 | 1.275 | 752012 / 1135564 | 663296 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21829.075 (47193.098) | 53.745 | 1.214 | 32840 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21608.453 (27639.717) | 21.821 | 1.005 | 758388 / 1317300 | 756224 (2097152.0) | 129 / 352 | 0.0 / 0 |
| water_glass_oit | 113371.308 (197858.271) | 42.701 | 1.133 | 10004 / 10980 | 0 (2097152.0) | 214 / 173 | 0.0 / 0 |
| translucent_move_oit | 21772.595 (27910.964) | 21.993 | 1.005 | 754692 / 1317700 | 749440 (2097152.0) | 222 / 173 | 0.0 / 0 |
| flat_plants | 9102.06 (12478.759) | 27.06 | 1.045 | 1940 / 4564 | 0 (2097152.0) | 126 / 351 | 0.0 / 0 |
| renderer_off | 20763.676 (39371.649) | 47.262 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 120 / 5 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86232 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79304 / 122900 | 57728 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.813 (101) | 3.422 (143) | 1.114 | 3.778 (47) | 0 | 876 / 0 | 8.895 / 12.891 | 4.647 / 6.876 |
| flythrough | 6.318 (1563) | 6.932 (1551) | 0.911 | 6.318 (1563) | 0 | 1400 / 0 | 6.834 / 10.217 | 4.567 / 7.088 |
| water_glass | 2.093 (14) | 2.356 (14) | 0.888 | None (0) | 0 | 1195 / 0 | 8.089 / 11.46 | 4.366 / 6.197 |
| nether | 2.643 (23) | 3.01 (31) | 0.878 | 2.73 (10) | 0 | 1833 / 0 | 6.672 / 9.371 | 3.499 / 5.043 |
| mobs | 0.978 (6) | 0.447 (3) | 2.188 | None (0) | 0 | 2068 / 0 | 6.483 / 8.984 | 3.391 / 4.799 |
| outline | 0.462 (13) | 0.686 (12) | 0.673 | None (0) | 0 | 2126 / 0 | 6.41 / 8.861 | 3.319 / 4.765 |
| occlusion | 1.928 (50) | 0.906 (43) | 2.128 | 3.809 (10) | 0 | 2258 / 0 | 6.211 / 8.574 | 3.174 / 4.596 |
| occlusion_move | 2.179 (72) | 2.284 (65) | 0.954 | 4.177 (27) | 0 | 2411 / 0 | 5.961 / 8.23 | 2.996 / 4.348 |
| occlusion_corner | 1.289 (110) | 1.351 (110) | 0.954 | 1.3 (1) | 0 | 2693 / 0 | 5.549 / 7.609 | 2.655 / 3.92 |
| translucent_move | 3.184 (106) | 4.208 (122) | 0.757 | 5.671 (32) | 0 | 3075 / 0 | 5.555 / 7.606 | 2.741 / 3.973 |
| water_glass_oit | 4.272 (154) | 3.673 (150) | 1.163 | None (0) | 0 | 413 / 0 | 9.3 / 11.205 | 4.751 / 6.221 |
| translucent_move_oit | 3.83 (219) | 4.818 (213) | 0.795 | 4.836 (25) | 0 | 960 / 0 | 6.439 / 7.862 | 3.486 / 4.584 |
| flat_plants | 1.876 (78) | 1.283 (88) | 1.462 | None (0) | 0 | 400 / 0 | 7.139 / 8.161 | 3.021 / 3.405 |
| renderer_off | 0.63 (21) | 0.528 (22) | 1.193 | None (0) | 0 | 324 / 0 | 8.575 / 10.917 | 3.802 / 5.082 |
| particles | 0.373 (30) | 0.433 (30) | 0.861 | None (0) | 0 | 3105 / 0 | 5.51 / 7.542 | 2.703 / 3.934 |
| animation | 0.936 (18) | 1.051 (18) | 0.891 | 1.355 (4) | 0 | 3180 / 0 | 5.406 / 7.394 | 2.626 / 3.81 |
| animated_items | 0.377 (42) | 0.839 (32) | 0.449 | 0.936 (2) | 0 | 3212 / 0 | 5.359 / 7.326 | 2.577 / 3.753 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.185 | 666.142 | 16 (vanilla 28) | 1382704 | 41.326 / 0.101 | 22.897 / 36.0 | 36.922 | 2369 / 0 | 3.778 (7.994) |
| flythrough | plain, one multi-draw per region and layer | 59.21 | 759.986 | 16 (vanilla 28) | 5134744 | 15.198 / 0.992 | 84.838 / 112.0 | 137.112 | 6371 / 0 | 6.318 (18.067) |
| water_glass | plain, one multi-draw per region and layer | 14.033 | 105.245 | 16 (vanilla 28) | 783024 | 33.423 / 0.089 | 12.629 / 36.0 | 20.909 | 3027 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.084 | 16 (vanilla 28) | 956804 | 27.982 / 0.185 | 15.238 / 20.0 | 25.549 | 4086 / 0 | 2.73 (4.367) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.11 | 16 (vanilla 28) | 606744 | 25.4 / 0.161 | 9.715 / 16.0 | 16.202 | 4531 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 86860 | 24.951 / 0.16 | 1.378 / 16.0 | 2.319 | 4625 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 154676 | 23.777 / 0.152 | 2.478 / 20.0 | 4.13 | 4876 / 0 | 3.809 (6.752) |
| occlusion_move | plain, one multi-draw per region and layer | 6.037 | 33.854 | 16 (vanilla 28) | 207052 | 22.421 / 0.143 | 3.32 / 20.0 | 5.529 | 5185 / 0 | 4.177 (11.405) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.871 | 16 (vanilla 28) | 122728 | 21.143 / 0.135 | 1.931 / 20.0 | 3.277 | 5578 / 0 | 1.3 (1.279) |
| translucent_move | plain, one multi-draw per region and layer | 4.399 | 23.093 | 16 (vanilla 28) | 802516 | 18.272 / 0.123 | 13.011 / 28.0 | 21.429 | 6449 / 0 | 5.671 (15.112) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.075 | 113.528 | 16 (vanilla 28) | 777948 | 7.487 / 0.043 | 12.539 / 20.0 | 20.773 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.486 | 37.311 | 16 (vanilla 28) | 772436 | 6.74 / 0.112 | 12.533 / 28.0 | 20.626 | 2415 / 0 | 4.836 (11.415) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.044 | 16 (vanilla 28) | 880084 | 5.922 / 0.01 | 14.125 / 24.0 | 23.501 | 910 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.038 | 16 (vanilla 28) | 550332 | 2.379 / 0.02 | 8.763 / 24.0 | 14.695 | 601 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 12676 | 18.212 / 0.122 | 0.198 / 28.0 | 0.338 | 6497 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 23676 | 18.069 / 0.121 | 0.369 / 28.0 | 0.632 | 6599 / 0 | 1.355 (2.028) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 14024 | 18.019 / 0.122 | 0.22 / 28.0 | 0.374 | 6649 / 0 | 0.936 (1.484) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 40 (0.026 / 0.038 / 0.047; 0) | 0 | 33072 / 0 / 0 |
| flythrough | 188.95 | 26.388 | 0.0 | 0 | 0 | 834 (0.031 / 0.046 / 9.045; 0) | 40 | 26264 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1720 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1198 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.012 / 0.03; 0) | 32 | 1194 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.099 / 0.153 / 0.183; 0) | 180 | 3619 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 645 | 0 (None / None / None; 0) | 0 | 860 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 669 | 0 (None / None / None; 0) | 0 | 1561 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2016 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2328 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.084; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 434.122 | 1.0 (0.0, 0.0) | 1.633 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.061; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.127 (0.294; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.068 (0.147; 0) | 0 | 3594 / 1626884 / 0 / 0 |
| occlusion_move | 51.347 | 10.0 (9.0, 2.365) | 6.0 (6.0, 2.285) | 0.059 (0.232; 0) | 0 | 2776 / 1502214 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.288 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.717 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 270.0 / 349.0 (22.6) | 270.0 / 79.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4187 / 0 |
| flythrough | two-phase | 314.24 / 402.17 (21.9) | 307.35 / 94.81 / 6.88 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3045 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 9396 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 33927 / 0 |
| mobs | two-phase | 32.0 / 108.0 (70.4) | 32.0 / 76.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10336 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3427 / 0 |
| occlusion_move | two-phase | 22.39 / 51.3 (56.4) | 22.34 / 28.96 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4305 / 0 |
| occlusion_corner | two-phase | 60.75 / 81.85 (25.8) | 60.67 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3161 / 0 |
| translucent_move | two-phase | 15.66 / 135.15 (88.4) | 15.64 / 119.5 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15416 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4698 / 0 |
| translucent_move_oit | two-phase | 15.69 / 135.13 (88.4) | 15.65 / 119.48 / 0.04 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6574 / 0 |
| flat_plants | two-phase | 9.0 / 153.0 (94.1) | 9.0 / 144.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 18000 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 14645 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 596 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.168 / 0.204 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 101.955 / 0.203 | 0.027 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.304 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.835 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 57.332 / 57.351 | 0.015 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.51 | 0.898 / 0.634 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 40.853 / 6.017 | 0.072 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 107.19 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.052 / 13.002 | 0.004 / 0.01 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 57.584 / 57.442 | 0.012 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.948 / 13.87 | 0.006 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.495 | 1.0 / 0.942 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.99 / 2.728 | 0.015 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 92.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.539 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.04 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.302 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.795 | 0.004 / 0.007 | 56 (3) | 40.608 / 9.245 / 31.363 | 3 / 0 | 10.985 |
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
siftec/quicksilver-full: bench factory_flat: median meshing time 0.309 ms per section against vanilla's compiler 0.283 ms (1.092x; limit 0.311 ms; 564 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench factory_flat: median meshing time 0.36 ms per section against vanilla's compiler 0.288 ms (1.25x; limit 0.317 ms; 573 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.98 ms per section against vanilla's compiler 0.554 ms (1.769x; limit 0.609 ms; 564 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.565 ms per section against vanilla's compiler 0.556 ms (1.016x; limit 0.612 ms; 572 pairs): reported, not gated (open gap)

- measure-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1014-aws amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- full: 4 / 4
- old-gpu: 36 / 36
- vulkan: 0 / 0
- old-gpu-2p: 36 / 36

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % | old-GPU two-phase % |
|---|---|---|---|---|---|---|
| factory | 0.017 | 0.3 | 0.0 | 0.0 | 0.017 | 0.0 |
| factory_flat | 0.0039 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 | 0.0068 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0027 | 0.55 | 0.0066 | 0.0067 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | 0.0069 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| factory | 95.56 | 500 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) | 55 (536) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| mam | 88.16 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (10473) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 34 (4274) | 39 (4275) | None (None) | 41 (4279) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0 / 0 | 0.0 / 0 | 0.017 / 0 | 0.0 / 0 |
| factory_flat | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0026 / 9 | 0.0029 / 12 | skipped | 0.0029 / 12 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 13.25 (base 12.22) | 15 (base 15) | 6228 (base 6976) | 365.5 (base 361.48) | 5.99 (base 5.48) |
| factory_flat | 12.74 (reported, not gated) | 15 (base 15) | 6004 (base 6844) | 363.01 (base 360.51) | 3.48 (base 5.48) |
| sift | 21.21 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 384.08 (base 379.72) | 5.99 (base 5.87) |
| hub | 21.54 (base 21.53) | 16 (base 16) | 65656 (base 66576) | 396.64 (base 392.33) | 5.99 (base 5.48) |
| mam | 22.53 (base 22.53) | 19 (base 19) | 22088 (base 23748) | 410.42 (base 405.55) | 5.99 (base 8.12) |
| ponder | 88.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 408.89 (base 404.14) | 5.99 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 17 (base 17) | 43660 (base 44728) | 395.57 (base 392.95) | 5.81 (base 8.24) |
| create_ct | 7.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 396.69 (base 394.1) | 5.81 (base 10.24) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 13.25 / 13 (29.72) | 108.44 / 152 (28.84) | median and average, x 1.10 + 2 |
| factory_flat | 12.74 / 13 (29.95) | 109.28 / 152 (28.77) | median and average, x 1.10 + 2 |
| sift | 21.21 / 24 (26.64) | 153.0 / 153 (14.99) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.89) | 115.27 / 161 (29.69) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.98) | 117.29 / 162 (29.52) | median, x 1.10 + 2 |
| ponder | 88.24 / 88 (29.94) | 181.05 / 227 (29.88) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.97) | 116.92 / 164 (30.01) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.99) | 100.08 / 147 (29.94) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.336 | 32.0 / 20.336 | 0.0 / 0.0 | 416.0 / 34.001 |
| ponder | 32.0 / 17.585 | 32.0 / 17.585 | 0.0 / 0.0 | 416.0 / 29.217 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.699 (26448.186) | 48.64 | 1.0 | 113844 / 190188 | 100928 (2097152.0) | 4 / 15 | 0.0 / 0 |
| factory_flat | 13584.478 (26449.756) | 48.64 | 1.0 | 113752 / 190188 | 100928 (2097152.0) | 2 / 7 | 0.0 / 0 |
| sift | 115644.97 (157946.335) | 26.782 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 7 / 299 | 0.0 / 0 |
| hub | 474.794 (783.31) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 3 / 6 | 0.0 / 0 |
| mam | 568.947 (925.54) | 38.528 | 1.25 | 303192 / 304740 | 0 (2097152.0) | 4 / 4 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 3 / 2 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 45452 / 46184 | 0 (2097152.0) | 2 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.182 (35) | 4.043 (35) | 0.54 | 2.05 (12) | 0 | 846 / 0 | 6.386 / 7.712 | 2.271 / 3.443 |
| factory_flat | 2.027 (2) | 2.114 (14) | 0.959 | 2.027 (2) | 0 | 564 / 0 | 1.257 / 1.196 | 0.309 / 0.283 |
| sift | 0.602 (41) | 1.638 (41) | 0.368 | None (0) | 0 | 1389 / 0 | 4.579 / 5.495 | 1.38 / 2.014 |
| hub | 0.353 (8) | 0.308 (8) | 1.146 | None (0) | 0 | 1448 / 0 | 4.517 / 5.427 | 1.368 / 1.989 |
| mam | 0.305 (4) | 0.425 (4) | 0.718 | None (0) | 0 | 1764 / 0 | 4.225 / 5.249 | 1.404 / 2.15 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1765 / 0 | 4.223 / 5.247 | 1.403 / 2.144 |
| hologram | 1.255 (25) | 0.938 (13) | 1.338 | None (0) | 0 | 1798 / 0 | 4.203 / 5.222 | 1.409 / 2.143 |
| create_ct | 0.423 (60) | 0.672 (53) | 0.629 | None (0) | 0 | 1854 / 0 | 4.098 / 5.091 | 1.368 / 2.007 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 26.668 / 0.269 | 1.511 / 28.0 | 2.566 | 1783 / 0 | 2.05 (2.163) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 1.246 / 0.004 | 1.511 / 12.0 | 2.566 | 610 / 0 | 2.027 (2.219) |
| sift | indirect, one multi-draw per arena and layer | 3.006 | 320.602 | 16 (vanilla 28) | 462608 | 24.304 / 0.304 | 7.389 / 16.0 | 12.353 | 2792 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 23.393 / 0.291 | 1.879 / 12.0 | 3.137 | 2887 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1194700 | 24.014 / 0.324 | 20.336 / 32.0 | 31.902 | 3541 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1020612 | 24.014 / 0.324 | 17.585 / 32.0 | 27.253 | 3542 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.814 / 0.32 | 0.238 / 32.0 | 0.367 | 3606 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.371 / 0.314 | 0.171 / 32.0 | 0.283 | 3714 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 3198 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.011; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6216 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6300 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9177 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5100 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7800 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 96.25 / 0.0 | 0.505 / 0.576 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.858 / 10.868 | 0.017 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 96.979 / 0.0 | 0.611 / 0.072 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.675 / 1.639 | 0.009 / 0.008 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 7.462 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.727 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.755 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.255 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 153.948 / 93.599 | 0.102 / 0.027 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.44 / 574.42 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.86 | 1.0 / 1.0 | 112.96 / 112.91 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.0 / 0.11 | 203.59 / 203.77 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.5 (base 20.24) | 13 (base 13) | 49052 (base 49024) | 365.46 (base 361.53) | 4.24 (base 5.48) |
| factory_flat | 15.8 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 363.03 (base 360.27) | 3.48 (base 5.48) |
| sift | 34.33 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.11 (base 379.69) | 4.24 (base 4.24) |
| hub | 20.53 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.46 (base 392.07) | 4.24 (base 5.99) |
| mam | 21.53 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.35 (base 404.98) | 8.24 (base 7.73) |
| ponder | 87.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 405.21 (base 403.64) | 8.24 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42532 (base 43652) | 395.76 (base 392.54) | 8.06 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 396.65 (base 393.74) | 8.06 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 16.5 / 16 (30.0) | 179.55 / 226 (29.97) | median and average, x 1.10 + 2 |
| factory_flat | 15.8 / 16 (29.97) | 179.33 / 226 (29.96) | median and average, x 1.10 + 2 |
| sift | 34.33 / 37 (26.41) | 579.0 / 579 (18.13) | median, x 1.10 + 2 |
| hub | 20.53 / 20 (30.0) | 161.94 / 208 (29.96) | median and average, x 1.10 + 2 |
| mam | 21.53 / 21 (29.95) | 199.95 / 246 (29.94) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.98) | 180.66 / 227 (29.81) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.99) | 128.0 / 175 (30.0) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 110.84 / 158 (30.01) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.565 | 12.0 / 1.565 | 0.0 / 0.0 | 416.0 / 2.933 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.892 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.336 | 32.0 / 20.336 | 0.0 / 0.0 | 416.0 / 34.114 |
| ponder | 32.0 / 17.591 | 32.0 / 17.591 | 0.0 / 0.0 | 416.0 / 29.201 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14348.641 (27748.501) | 48.29 | 1.0 | 156760 / 233368 | 100928 (2097152.0) | 1 / 1 | 0.0 / 0 |
| factory_flat | 13711.973 (26666.484) | 48.58 | 1.0 | 156668 / 233360 | 100928 (2097152.0) | 2 / 1 | 0.0 / 0 |
| sift | 115596.519 (157948.58) | 26.814 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 11 / 359 | 0.0 / 0 |
| hub | 474.791 (783.306) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 4 / 1 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61228 | 0 (2097152.0) | 2 / 2 | 0.0 / 0 |
| hologram | 3670.117 (6346.578) | 42.172 | 1.0 | 45780 / 46260 | 0 (2097152.0) | 2 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.113 (35) | 2.508 (35) | 0.843 | 1.915 (12) | 0 | 845 / 0 | 5.319 / 6.642 | 1.917 / 2.628 |
| factory_flat | 3.497 (2) | 1.245 (4) | 2.809 | 3.497 (2) | 0 | 573 / 0 | 1.511 / 1.359 | 0.36 / 0.288 |
| sift | 0.834 (41) | 1.097 (40) | 0.76 | None (0) | 0 | 1384 / 0 | 3.81 / 4.855 | 1.184 / 1.679 |
| hub | 0.244 (8) | 0.195 (8) | 1.251 | None (0) | 0 | 1435 / 0 | 3.737 / 4.757 | 1.165 / 1.664 |
| mam | 0.425 (4) | 0.265 (4) | 1.604 | None (0) | 0 | 1754 / 0 | 3.632 / 4.852 | 1.288 / 1.996 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1755 / 0 | 3.63 / 4.85 | 1.287 / 1.995 |
| hologram | 0.519 (31) | 0.72 (25) | 0.721 | None (0) | 0 | 1788 / 0 | 3.606 / 4.821 | 1.264 / 1.955 |
| create_ct | 0.401 (48) | 0.542 (60) | 0.74 | None (0) | 0 | 1844 / 0 | 3.519 / 4.709 | 1.213 / 1.832 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.247 | 34.578 | 16 (vanilla 28) | 96100 | 25.347 / 0.372 | 1.511 / 28.0 | 2.566 | 1766 / 0 | 1.915 (2.089) |
| factory_flat | plain, one multi-draw per region and layer | 4.047 | 32.474 | 16 (vanilla 28) | 99476 | 1.241 / 0.004 | 1.565 / 12.0 | 2.656 | 617 / 0 | 3.497 (5.463) |
| sift | plain, one multi-draw per region and layer | 17.032 | 320.606 | 16 (vanilla 28) | 462608 | 23.269 / 0.386 | 7.389 / 16.0 | 12.353 | 2771 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.674 / 0.375 | 1.879 / 12.0 | 3.137 | 2850 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1194808 | 23.344 / 0.392 | 20.336 / 32.0 | 31.905 | 3510 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1021056 | 23.344 / 0.392 | 17.591 / 32.0 | 27.265 | 3511 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.117 / 0.386 | 0.238 / 32.0 | 0.367 | 3581 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.734 / 0.379 | 0.171 / 32.0 | 0.283 | 3677 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 3174 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.086; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.52 / 69.0 (57.2) | 29.52 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.0 | 5796 / 0 |
| factory_flat | still | 27.42 / 69.0 (60.3) | 27.42 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.0 | 6258 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 9108 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5066 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7800 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.333 / 0.0 | 0.547 / 0.574 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.478 / 10.303 | 0.015 / 0.006 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.489 / 0.0 | 0.172 / 0.087 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.815 / 1.782 | 0.009 / 0.009 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 7.576 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.412 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.333 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 141.38 / 86.582 | 0.111 / 0.036 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.86 / 13.87 | 0.0 / 0.0 | 574.14 / 574.4 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.87 | 1.0 / 1.0 | 113.01 / 113.4 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.11 / 0.11 | 203.64 / 203.99 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 14.25 (base 14.25) | 15 (base 15) | 50784 (base 51624) | 365.26 (base 360.8) | 4.23 (base 5.46) |
| factory_flat | 13.67 (reported, not gated) | 15 (base 15) | 50660 (base 51500) | 360.34 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 383.77 (base 379.18) | 4.23 (base 5.46) |
| hub | 20.55 (base 21.57) | 16 (base 16) | 65656 (base 66576) | 395.8 (base 391.05) | 4.23 (base 5.46) |
| mam | 21.53 (base 22.55) | 19 (base 19) | 22088 (base 23748) | 408.99 (base 404.61) | 8.23 (base 7.71) |
| ponder | 87.23 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 404.45 (base 403.47) | 8.23 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 398.72 (base 395.99) | 8.04 (base 8.29) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 14.25 / 14 (29.9) | 108.01 / 154 (29.73) | median and average, x 1.10 + 2 |
| factory_flat | 13.67 / 14 (29.89) | 107.08 / 154 (29.94) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (14.94) | 153.0 / 153 (16.57) | median, x 1.10 + 2 |
| hub | 20.55 / 20 (29.69) | 114.79 / 161 (30.0) | median and average, x 1.10 + 2 |
| mam | 21.53 / 21 (29.83) | 116.16 / 162 (29.74) | median, x 1.10 + 2 |
| ponder | 87.23 / 87 (29.99) | 180.72 / 227 (29.91) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (30.0) | 100.0 / 147 (29.97) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.892 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 19.999 | 32.0 / 19.999 | 0.0 / 0.0 | 416.0 / 34.125 |
| ponder | 32.0 / 17.449 | 32.0 / 17.449 | 0.0 / 0.0 | 416.0 / 29.212 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14607.196 (28188.054) | 48.179 | 1.0 | 159336 / 234848 | 100928 (2097152.0) | 1 / 5 | 0.0 / 0 |
| factory_flat | 13584.717 (26450.231) | 48.64 | 1.0 | 50660 / 51500 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| sift | 115815.342 (158179.027) | 26.782 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 298 / 331 | 0.0 / 0 |
| hub | 474.798 (783.316) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 4 / 0 | 0.0 / 0 |
| mam | 568.951 (925.548) | 38.528 | 1.25 | 41048 / 42688 | 0 (2097152.0) | 14 / 8 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61248 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.07 (35) | 2.482 (35) | 1.237 | 3.115 (12) | 0 | 838 / 0 | 9.501 / 12.51 | 6.119 / 7.245 |
| factory_flat | None (0) | None (0) | None | None (0) | 0 | 564 / 0 | 3.339 / 3.11 | 0.98 / 0.554 |
| sift | 1.281 (41) | 1.374 (40) | 0.932 | None (0) | 0 | 1381 / 0 | 7.17 / 9.345 | 3.876 / 4.94 |
| hub | 0.499 (8) | 0.267 (8) | 1.869 | None (0) | 0 | 1433 / 0 | 7.082 / 9.199 | 3.834 / 4.925 |
| mam | 0.651 (4) | 0.378 (4) | 1.722 | None (0) | 0 | 1738 / 0 | 7.122 / 9.593 | 4.111 / 5.621 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1739 / 0 | 7.118 / 9.588 | 4.111 / 5.619 |
| create_ct | 1.247 (43) | 0.545 (58) | 2.288 | None (0) | 0 | 1794 / 0 | 7.02 / 9.392 | 4.065 / 5.466 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 35.43 | 16 (vanilla 28) | 96100 | 24.913 / 0.299 | 1.511 / 28.0 | 2.566 | 1749 / 0 | 3.115 (3.93) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 1.203 / 0.004 | 1.511 / 12.0 | 2.566 | 606 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 321.074 | 16 (vanilla 28) | 462608 | 22.911 / 0.328 | 7.389 / 16.0 | 12.353 | 2758 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.236 / 0.317 | 1.879 / 12.0 | 3.137 | 2839 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1173912 | 23.129 / 0.344 | 19.999 / 32.0 | 31.347 | 3472 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1012192 | 23.129 / 0.344 | 17.449 / 32.0 | 27.028 | 3473 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.709 / 0.338 | 0.171 / 32.0 | 0.283 | 3575 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1794 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.04; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 30.37 / 69.0 (56.0) | 30.37 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.96 | 5796 / 0 |
| factory_flat | still | 27.0 / 69.0 (60.9) | 27.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6300 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5106 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5032 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7748 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.805 / 0.0 | 0.537 / 0.564 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.35 / 10.151 | 0.019 / 0.008 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.647 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.88 / 13.87 | 0.0 / 0.0 | 574.89 / 574.49 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.88 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.85 | 1.0 / 1.0 | 113.02 / 112.42 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.85 (8.0 / 8.0) |
| ponder | 82.56 / 82.57 | 0.0 / 0.11 | 203.46 / 203.73 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.59 / 81.6 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 17.21 (base 20.24) | 13 (base 13) | 49032 (base 49024) | 365.93 (base 361.53) | 5.99 (base 5.48) |
| factory_flat | 17.27 (reported, not gated) | 13 (base 13) | 49148 (base 48916) | 362.31 (base 360.27) | 3.48 (base 5.48) |
| sift | 38.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.18 (base 379.69) | 5.99 (base 4.24) |
| hub | 21.56 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.64 (base 392.07) | 5.99 (base 5.99) |
| mam | 22.52 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 409.81 (base 404.98) | 5.99 (base 7.73) |
| ponder | 88.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 408.59 (base 403.64) | 5.99 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 42868 (base 43652) | 395.66 (base 392.54) | 5.81 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 396.85 (base 393.74) | 5.81 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 17.21 / 17 (29.46) | 179.55 / 226 (29.97) | median and average, x 1.10 + 2 |
| factory_flat | 17.27 / 17 (29.81) | 179.33 / 226 (29.96) | median and average, x 1.10 + 2 |
| sift | 38.0 / 38 (15.24) | 579.0 / 579 (18.13) | median, x 1.10 + 2 |
| hub | 21.56 / 21 (29.05) | 161.94 / 208 (29.96) | median and average, x 1.10 + 2 |
| mam | 22.52 / 22 (29.92) | 199.95 / 246 (29.94) | median, x 1.10 + 2 |
| ponder | 88.24 / 88 (29.97) | 180.66 / 227 (29.81) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.77) | 128.0 / 175 (30.0) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.93) | 110.84 / 158 (30.01) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.527 | 12.0 / 1.527 | 0.0 / 0.0 | 416.0 / 2.933 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.892 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.077 | 32.0 / 20.077 | 0.0 / 0.0 | 416.0 / 34.114 |
| ponder | 32.0 / 17.329 | 32.0 / 17.329 | 0.0 / 0.0 | 416.0 / 29.201 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.817 (26448.414) | 48.64 | 1.0 | 156760 / 233368 | 100928 (2097152.0) | 6 / 1 | 0.0 / 0 |
| factory_flat | 13583.372 (26447.54) | 48.64 | 1.0 | 156752 / 233360 | 100928 (2097152.0) | 2 / 1 | 0.0 / 0 |
| sift | 115757.533 (158168.586) | 26.814 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 304 / 359 | 0.0 / 0 |
| hub | 474.814 (783.344) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 22 / 1 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61212 / 61228 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| hologram | 3670.148 (6346.631) | 42.172 | 1.0 | 46116 / 46260 | 0 (2097152.0) | 5 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.955 (35) | 2.508 (35) | 1.577 | 3.421 (12) | 0 | 850 / 0 | 10.284 / 14.21 | 6.338 / 8.79 |
| factory_flat | 2.71 (16) | 1.245 (4) | 2.177 | 2.623 (13) | 0 | 572 / 0 | 2.527 / 2.622 | 0.565 / 0.556 |
| sift | 1.766 (41) | 1.097 (40) | 1.61 | None (0) | 0 | 1395 / 0 | 7.514 / 10.197 | 3.6 / 4.752 |
| hub | 0.389 (8) | 0.195 (8) | 1.995 | None (0) | 0 | 1442 / 0 | 7.422 / 10.032 | 3.566 / 4.714 |
| mam | None (0) | 0.265 (4) | None | None (0) | 0 | 1750 / 0 | 7.466 / 10.274 | 3.884 / 5.628 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1751 / 0 | 7.462 / 10.268 | 3.876 / 5.622 |
| hologram | 1.519 (19) | 0.72 (25) | 2.11 | None (0) | 0 | 1784 / 0 | 7.37 / 10.124 | 3.755 / 5.427 |
| create_ct | 0.841 (46) | 0.542 (60) | 1.552 | None (0) | 0 | 1840 / 0 | 7.206 / 9.867 | 3.601 / 5.075 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 26.427 / 0.237 | 1.511 / 28.0 | 2.566 | 1772 / 0 | 3.421 (4.257) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 97036 | 1.514 / 0.004 | 1.527 / 12.0 | 2.591 | 644 / 0 | 2.623 (4.618) |
| sift | plain, one multi-draw per region and layer | 17.056 | 321.053 | 16 (vanilla 28) | 462608 | 24.142 / 0.278 | 7.389 / 16.0 | 12.353 | 2783 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.009 | 16 (vanilla 28) | 117492 | 23.526 / 0.27 | 1.879 / 12.0 | 3.137 | 2855 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1179460 | 24.137 / 0.308 | 20.077 / 32.0 | 31.495 | 3489 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1005580 | 24.137 / 0.308 | 17.329 / 32.0 | 26.852 | 3490 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.935 / 0.303 | 0.238 / 32.0 | 0.367 | 3554 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.492 / 0.298 | 0.171 / 32.0 | 0.283 | 3660 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1830 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 583 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2388 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.039; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6174 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6258 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5244 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.03; 100.0) | 14400.0 | 4930 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7800 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 447 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.333 / 0.0 | 0.547 / 0.531 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.07 / 10.031 | 0.018 / 0.009 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.489 / 0.0 | 0.172 / 0.597 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.431 / 11.32 | 0.035 / 0.014 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.412 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.333 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 148.374 / 89.64 | 0.151 / 0.045 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.88 / 13.87 | 0.0 / 0.0 | 574.5 / 574.4 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.88 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.87 | 1.0 / 1.0 | 113.04 / 113.4 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.11 / 0.11 | 203.57 / 203.99 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 9.2 | 160.68 | 183 | 123 | 708956 | [] |
| bench-plain | flythrough | 5.33 | 341.54 | 106 | 123 | 7697360 | [] |
| bench-plain | water_glass | 15.82 | 76.68 | 316 | 124 | 16696 | [] |
| bench-plain | nether | 15.7 | 73.63 | 313 | 121 | 229800 | [] |
| bench-sodium | spawn | 10.97 | 100.79 | 219 | 147 | 2096 | [] |
| bench-sodium | flythrough | 6.63 | 347.67 | 132 | 159 | 266476 | [] |
| bench-sodium | water_glass | 19.53 | 66.72 | 266 | 135 | 10684 | [] |
| bench-sodium | nether | 26.66 | 45.98 | 1 | 129 | 263664 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 53.883 (50.0) | 724 / 724 | 1662 | 1 | 40519.563 | 5.112 (0.0) | 1366 |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-plain | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-sodium | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | nether | 4.12 | 4.12 (0) | 4.12 |  |
| core-bench-sodium | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | translucent_move | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| core-measure-full | particles | 8.24 | 8.24 (0) | 8.24 |  |
| core-measure-full | animation | 8.24 | 8.24 (0) | 8.24 |  |
| core-measure-full | animated_items | 8.24 | 8.24 (0) | 8.24 |  |
| core-measure-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
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
| core-measure-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-measure-vk | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-measure-vk | water_glass_oit | 3.34 | 3.34 (0) | 3.34 |  |
| core-measure-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
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
| core-quicksilver-2p-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-2p-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-full | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
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
| core-quicksilver-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
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
| core-quicksilver-vk | translucent_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | particles | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | animation | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | animated_items | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | flat_plants | 3.2 | 3.2 (0) | 3.2 |  |
| core-quicksilver-vk | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-vk | water_glass_oit | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-sp-quicksilver | flythrough | 1.56 | 1.56 (0) | 1.46 |  |
| siftec-measure-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-full | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-full | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | factory_flat | 5.48 | 5.48 (0) | 5.29 |  |
| siftec-measure-old | factory | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | sift | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | hub | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-measure-old | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-old | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-measure-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-vk | factory | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-measure-vk | sift | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-measure-vk | hub | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-measure-vk | mam | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| siftec-measure-vk | ponder | 8.23 | 8.23 (0) | 8.23 |  |
| siftec-measure-vk | create_ct | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-measure-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-2p-old | factory | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-2p-old | sift | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-2p-old | hub | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-2p-old | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-2p-old | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-2p-old | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-2p-old | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-2p-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-full | factory | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | sift | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | hub | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-full | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-vk | factory | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | sift | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | hub | 4.23 | 4.23 (0) | 4.23 |  |
| siftec-quicksilver-vk | mam | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| siftec-quicksilver-vk | ponder | 8.23 | 8.23 (0) | 8.23 |  |
| siftec-quicksilver-vk | create_ct | 8.04 | 8.04 (0) | 8.04 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |

Rises of 4 MB or more: core-measure-full/translucent_move: between scenes +4.00; siftec-measure-full/mam: between scenes +4.00; siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00; siftec-quicksilver-vk/mam: between scenes +4.00

