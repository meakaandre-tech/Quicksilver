# Quicksilver CI comparison

**passed**

## Suite core

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
- quicksilver-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1014-aws amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
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
| spawn | 0.4372 | 10.05 | 0.2958 | 0.451 | 0.4398 | 0.212 |
| flythrough | 0.0 | 14.95 | 0.0009 | 0.0009 | 0.001 | 0.0009 |
| water_glass | 0.0034 | 6.45 | 0.0044 | 0.0056 | 0.004 | 0.0048 |
| nether | 0.002 | 0.8 | 0.0023 | 0.0012 | 0.0451 | 0.0016 |
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
| translucent_move | 0.0001 | 0.3 | 0.0 | 0.0001 | 0.0002 | 0.0001 |
| translucent_move.x2404 | 0.0002 | 0.3 | 0.0005 | 0.0003 | 0.0004 | 0.0005 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0001 | 0.0001 | 0.0002 | 0.0002 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.0004 | 0.0001 | 0.0001 | 0.0002 |
| translucent_move.low | 0.0014 | 0.3 | 0.0024 | 0.0015 | 0.0011 | 0.0012 |
| translucent_move.back | 0.0001 | 0.3 | 0.0001 | 0.0 | 0.0 | 0.0001 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0001 | 0.0001 | 0.0001 | 0.0 |
| water_glass_oit | 0.0053 | 0.3 | 0.0035 | 0.0042 | 0.0044 | 0.0051 |
| translucent_move_oit | 0.0002 | 0.3 | 0.0002 | 0.0001 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0005 | 0.0004 | 0.0003 | 0.0004 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.0002 | 0.0003 | 0.0003 | 0.0002 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0008 | 0.0001 | 0.0002 | 0.0001 |
| translucent_move_oit.low | 0.0001 | 0.3 | 0.001 | 0.0012 | 0.0015 | 0.0014 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0002 | 0.0001 | 0.0 | 0.0 |
| translucent_move_oit.bare_back | 0.0003 | 0.3 | 0.0002 | 0.0002 | 0.0002 | 0.0001 |
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
| spawn | 92.58 | 18057 | 256 (761) | 314 (815) | 309 (830) | 255 (744) |
| flythrough | 97.24 | 6020 | 47 (299) | 47 (299) | 51 (300) | 47 (299) |
| water_glass | 95.81 | 25508 | 20 (2620) | 23 (2621) | 12 (2725) | 17 (2618) |
| nether | 99.42 | 905 | 3 (458) | 3 (458) | 410 (877) | 7 (462) |
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
| translucent_move | 96.93 | 13 | 1 (76) | 1 (77) | 2 (69) | 1 (76) |
| translucent_move.x2404 | 95.93 | 15 | 5 (105) | 3 (103) | 5 (89) | 5 (105) |
| translucent_move.x2414 | 95.86 | 13 | 1 (104) | 1 (104) | 1 (98) | 2 (105) |
| translucent_move.x2424 | 96.74 | 13 | 2 (79) | 2 (79) | 4 (70) | 4 (81) |
| translucent_move.low | 96.11 | 41 | 20 (26) | 17 (22) | 15 (17) | 15 (21) |
| translucent_move.back | 96.93 | 13 | 2 (78) | 3 (78) | 1 (67) | 2 (77) |
| translucent_move.bare_back | 96.9 | 13 | 2 (77) | 2 (77) | 2 (69) | 1 (77) |
| water_glass_oit | 95.81 | 57 | 13 (2614) | 17 (2616) | 15 (2727) | 22 (2621) |
| translucent_move_oit | 96.93 | 12 | 2 (77) | 2 (77) | 2 (68) | 1 (76) |
| translucent_move_oit.x2404 | 95.93 | 16 | 6 (106) | 3 (104) | 4 (88) | 4 (104) |
| translucent_move_oit.x2414 | 95.86 | 10 | 2 (105) | 2 (105) | 2 (99) | 1 (104) |
| translucent_move_oit.x2424 | 96.74 | 15 | 5 (82) | 2 (79) | 1 (67) | 2 (79) |
| translucent_move_oit.low | 96.11 | 40 | 12 (18) | 14 (19) | 19 (21) | 19 (25) |
| translucent_move_oit.back | 96.93 | 12 | 3 (78) | 2 (77) | 1 (67) | 2 (77) |
| translucent_move_oit.bare_back | 96.9 | 15 | 1 (76) | 2 (78) | 2 (68) | 1 (76) |
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
| spawn | 0.0645 / 276 | 0.4446 / 251 | 0.4347 / 319 | 0.4446 / 251 |
| flythrough | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0036 / 13 | 0.0047 / 16 | 0.0048 / 20 | 0.0047 / 16 |
| nether | 0.002 / 0 | 0.0101 / 85 | 0.0 / 0 | 0.0101 / 85 |
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
| translucent_move | 0.0 / 1 | 0.0001 / 0 | 0.0002 / 1 | 0.0001 / 0 |
| translucent_move.x2404 | 0.0002 / 2 | 0.0001 / 0 | 0.0001 / 1 | 0.0001 / 0 |
| translucent_move.x2414 | 0.0001 / 1 | 0.0001 / 1 | 0.0003 / 4 | 0.0001 / 1 |
| translucent_move.x2424 | 0.0003 / 1 | 0.0002 / 2 | 0.0002 / 2 | 0.0002 / 2 |
| translucent_move.low | 0.0011 / 3 | 0.0003 / 5 | 0.0004 / 3 | 0.0003 / 5 |
| translucent_move.back | 0.0 / 3 | 0.0 / 1 | 0.0 / 0 | 0.0 / 1 |
| translucent_move.bare_back | 0.0 / 0 | 0.0 / 0 | 0.0002 / 1 | 0.0 / 0 |
| water_glass_oit | 0.0047 / 24 | 0.0038 / 16 | 0.0047 / 14 | 0.0038 / 16 |
| translucent_move_oit | 0.0002 / 1 | 0.0 / 0 | 0.0001 / 0 | 0.0 / 0 |
| translucent_move_oit.x2404 | 0.0002 / 0 | 0.0003 / 2 | 0.0001 / 1 | 0.0003 / 2 |
| translucent_move_oit.x2414 | 0.0 / 1 | 0.0002 / 4 | 0.0002 / 1 | 0.0002 / 4 |
| translucent_move_oit.x2424 | 0.0003 / 1 | 0.0 / 0 | 0.0001 / 0 | 0.0 / 0 |
| translucent_move_oit.low | 0.0005 / 8 | 0.0003 / 4 | 0.0007 / 6 | 0.0003 / 4 |
| translucent_move_oit.back | 0.0002 / 0 | 0.0001 / 1 | 0.0 / 2 | 0.0001 / 1 |
| translucent_move_oit.bare_back | 0.0002 / 0 | 0.0001 / 0 | 0.0003 / 2 | 0.0001 / 0 |
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
| spawn | 15.0 (base 13.6) | 15 (base 14) | 28740 (base 22476) | 253.51 (base 259.07) | 4.24 (base 3.99) |
| flythrough | 15.6 (reported, not gated) | 30 (reported, not gated) | 308648 (reported, not gated) | 309.29 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 9.83 (base 8.97) | 15 (base 15) | 11936 (base 15576) | 238.33 (base 250.02) | 4.24 (base 5.99) |
| nether | 14.16 (base 15.63) | 12 (base 12) | 11032 (base 19648) | 259.09 (base 273.53) | 4.24 (base 5.99) |
| mobs | 20.69 (base 19.77) | 16 (base 17) | 613388 (base 1010948) | 258.05 (base 268.37) | 4.24 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 257.83 (base 264.69) | 4.24 (base 5.48) |
| occlusion | 16.67 (base 15.67) | 15 (base 15) | 100032 (base 126320) | 264.76 (base 265.1) | 4.24 (base 4.24) |
| occlusion_move | 16.92 (reported, not gated) | 15 (reported, not gated) | 81924 (reported, not gated) | 265.33 (base 265.74) | 4.24 (base 4.24) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 269.42 (base 267.71) | 4.24 (base 5.48) |
| translucent_move | 8.91 (reported, not gated) | 15 (reported, not gated) | 5808 (reported, not gated) | 275.75 (base 267.48) | 4.24 (base 5.48) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 12160 (base 14688) | 236.7 (base 245.02) | 3.6 (base 3.73) |
| translucent_move_oit | 14.18 (reported, not gated) | 15 (reported, not gated) | 5436 (reported, not gated) | 239.58 (base 247.19) | 3.73 (base 3.73) |
| flat_plants | 16.8 (base 18.29) | 15 (base 15) | 4480 (base 9812) | 239.32 (base 246.92) | 3.73 (base 3.99) |
| renderer_off | 8.67 (base 7.67) | 14 (base 14) | 3612 (base 7164) | 232.98 (base 241.33) | 3.6 (base 4.12) |
| particles | 10.72 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 267.17 (base 261.44) | 4.24 (base 5.99) |
| animation | 50 median (avg 40.93) (base 49) | 15 (base 15) | 2164 (base 2056) | 263.53 (base 260.68) | 4.24 (base 5.99) |
| animated_items | 61 median (avg 47.77) (base 60) | 23 (base 23) | 21856 (base 21940) | 238.09 (base 239.81) | 4.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 15.0 / 15 (11.93) | 123.56 / 124 (9.07) | median and average, x 1.10 + 2 |
| flythrough | 15.6 / 16 (9.36) | 123.04 / 123 (5.63) | median and average, at most vanilla + 2 |
| water_glass | 9.83 / 10 (24.08) | 124.0 / 124 (16.22) | median, at most vanilla |
| nether | 14.16 / 17 (26.42) | 120.89 / 121 (16.0) | median, x 1.10 + 2 |
| mobs | 20.69 / 21 (29.05) | 131.4 / 134 (20.08) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.54 / 126 (29.85) | median, x 1.10 + 2 |
| occlusion | 16.67 / 17 (29.98) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.92 / 18 (30.01) | 94.33 / 133 (29.97) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (30.0) | 82.27 / 121 (29.99) | median and average, x 1.10 + 2 |
| translucent_move | 8.91 / 9 (26.68) | 124.0 / 124 (16.84) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (13.33) | 129.0 / 129 (9.15) | median, at most vanilla |
| translucent_move_oit | 14.18 / 14 (13.67) | 129.0 / 129 (8.62) | median and average, at most vanilla |
| flat_plants | 16.8 / 20 (28.08) | 123.74 / 124 (16.5) | median, x 1.10 + 2 |
| renderer_off | 8.67 / 9 (29.92) | 94.22 / 123 (26.61) | median, x 1.10 + 2 |
| particles | 10.72 / 11 (30.0) | 86.27 / 125 (30.01) | median and average, x 1.10 + 2 |
| animation | 40.93 / 50 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.77 / 61 (30.0) | 155.15 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.199 | 36.0 / 23.199 | 0.0 / 0.0 | 416.0 / 39.786 |
| flythrough | 112.0 / 86.665 | 112.0 / 86.665 | 0.0 / 0.0 | 416.0 / 144.109 |
| water_glass | 36.0 / 12.381 | 36.0 / 12.381 | 0.0 / 0.0 | 416.0 / 22.24 |
| nether | 20.0 / 15.238 | 20.0 / 15.238 | 0.0 / 0.0 | 256.0 / 26.743 |
| mobs | 16.0 / 9.548 | 16.0 / 9.548 | 0.0 / 0.0 | 256.0 / 16.748 |
| outline | 16.0 / 1.384 | 16.0 / 1.384 | 0.0 / 0.0 | 256.0 / 2.457 |
| occlusion | 20.0 / 2.601 | 20.0 / 2.601 | 0.0 / 0.0 | 416.0 / 4.265 |
| occlusion_move | 20.0 / 3.504 | 20.0 / 3.504 | 0.0 / 0.0 | 416.0 / 6.011 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.887 | 28.0 / 12.887 | 0.0 / 0.0 | 416.0 / 22.135 |
| water_glass_oit | 20.0 / 12.381 | 20.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| translucent_move_oit | 28.0 / 12.484 | 28.0 / 12.484 | 0.0 / 0.0 | 416.0 / 21.514 |
| flat_plants | 24.0 / 13.608 | 24.0 / 13.608 | 0.0 / 0.0 | 416.0 / 23.767 |
| renderer_off | 24.0 / 8.534 | 24.0 / 8.534 | 0.0 / 0.0 | 416.0 / 14.916 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 444430.748 (601797.185) | 26.149 | 1.192 | 390972 / 851068 | 362232 (2097152.0) | 238 / 181 | 0.0 / 0 |
| flythrough | 490705.07 (773326.396) | 36.546 | 1.084 | 2334308 / 6969372 | 2095584 (2097152.0) | 187 / 112 | 6.048 / 67 |
| water_glass | 111763.875 (194713.971) | 42.601 | 1.133 | 13952 / 17144 | 0 (2097152.0) | 71 / 324 | 0.0 / 0 |
| nether | 29499.765 (42398.148) | 30.422 | 2.0 | 255960 / 385376 | 244480 (2097152.0) | 132 / 319 | 0.0 / 0 |
| mobs | 62156.983 (110954.972) | 43.98 | 0.967 | 613388 / 616328 | 0 (2097152.0) | 2 / 91 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5580 / 14812 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| occlusion | 29487.063 (51972.477) | 43.264 | 1.279 | 262116 / 584648 | 162176 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 22265.626 (39183.74) | 43.176 | 1.259 | 765548 / 1404548 | 689408 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21844.775 (47215.331) | 53.734 | 1.214 | 35488 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21580.038 (27577.82) | 21.749 | 1.004 | 753056 / 1319420 | 748032 (2097152.0) | 134 / 336 | 0.0 / 0 |
| water_glass_oit | 111951.293 (195040.489) | 42.601 | 1.133 | 14064 / 16360 | 0 (2097152.0) | 266 / 182 | 0.0 / 0 |
| translucent_move_oit | 21662.176 (27702.374) | 21.804 | 1.004 | 753904 / 1319252 | 748032 (2097152.0) | 273 / 172 | 0.0 / 0 |
| flat_plants | 9100.164 (12476.16) | 27.06 | 1.045 | 266512 / 271676 | 0 (2097152.0) | 141 / 329 | 0.0 / 0 |
| renderer_off | 19374.29 (36601.002) | 47.066 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 7 / 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9796 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.376 (5146.938) | 41.531 | 1.091 | 86772 / 150268 | 84608 (2097152.0) | 0 / 1 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79584 / 123160 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.285 (79) | 3.849 (122) | 0.594 | 2.204 (39) | 0 | 918 / 0 | 5.996 / 8.185 | 2.637 / 3.94 |
| flythrough | 3.65 (1707) | 6.472 (1532) | 0.564 | 3.65 (1707) | 0 | 1390 / 0 | 4.464 / 6.298 | 2.379 / 4.185 |
| water_glass | 1.5 (19) | 1.662 (14) | 0.903 | None (0) | 0 | 1241 / 0 | 5.346 / 7.19 | 2.42 / 3.423 |
| nether | 1.904 (23) | 2.275 (28) | 0.837 | 1.86 (14) | 0 | 1859 / 0 | 4.458 / 5.893 | 2.081 / 2.797 |
| mobs | 0.639 (13) | 0.514 (6) | 1.243 | None (0) | 0 | 2093 / 0 | 4.314 / 5.681 | 2.022 / 2.696 |
| outline | 0.832 (12) | 0.566 (13) | 1.47 | None (0) | 0 | 2151 / 0 | 4.258 / 5.616 | 2.009 / 2.65 |
| occlusion | 1.032 (45) | 0.925 (42) | 1.116 | 3.931 (1) | 0 | 2281 / 0 | 4.119 / 5.454 | 1.943 / 2.571 |
| occlusion_move | 1.358 (60) | 2.101 (70) | 0.646 | 2.804 (16) | 0 | 2422 / 0 | 3.96 / 5.249 | 1.833 / 2.446 |
| occlusion_corner | 0.855 (97) | 1.349 (110) | 0.634 | 0.73 (1) | 0 | 2694 / 0 | 3.683 / 4.868 | 1.645 / 2.201 |
| translucent_move | 1.833 (128) | 3.472 (126) | 0.528 | 2.949 (34) | 0 | 3060 / 0 | 3.602 / 4.791 | 1.681 / 2.256 |
| water_glass_oit | 2.747 (154) | 3.512 (152) | 0.782 | None (0) | 0 | 413 / 0 | 6.087 / 8.152 | 2.845 / 4.006 |
| translucent_move_oit | 2.34 (225) | 4.294 (216) | 0.545 | 3.455 (25) | 0 | 973 / 0 | 3.979 / 5.426 | 1.781 / 2.611 |
| flat_plants | 1.031 (90) | 1.427 (82) | 0.722 | None (0) | 0 | 402 / 0 | 5.626 / 7.002 | 1.81 / 2.61 |
| renderer_off | 0.47 (22) | 0.603 (21) | 0.779 | None (0) | 0 | 322 / 0 | 5.808 / 8.465 | 2.049 / 4.156 |
| particles | 0.239 (24) | 0.276 (30) | 0.866 | None (0) | 0 | 3088 / 0 | 3.574 / 4.751 | 1.651 / 2.222 |
| animation | 0.67 (18) | 0.817 (18) | 0.82 | 0.965 (4) | 0 | 3163 / 0 | 3.505 / 4.657 | 1.594 / 2.159 |
| animated_items | 0.272 (32) | 0.312 (38) | 0.872 | 0.541 (2) | 0 | 3195 / 0 | 3.474 / 4.615 | 1.554 / 2.138 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.017 | 659.597 | 16 (vanilla 28) | 1402216 | 40.319 / 0.104 | 23.199 / 36.0 | 37.443 | 2431 / 0 | 2.204 (5.552) |
| flythrough | indirect, one multi-draw per arena and layer | 4.551 | 770.856 | 16 (vanilla 28) | 5247864 | 15.092 / 0.956 | 86.665 / 112.0 | 140.133 | 6644 / 0 | 3.65 (10.868) |
| water_glass | indirect, one multi-draw per arena and layer | 3.006 | 105.218 | 16 (vanilla 28) | 768368 | 33.274 / 0.097 | 12.381 / 36.0 | 20.518 | 3112 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.081 | 16 (vanilla 28) | 958136 | 28.192 / 0.202 | 15.238 / 20.0 | 25.585 | 4130 / 0 | 1.86 (2.951) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 60.103 | 16 (vanilla 28) | 597244 | 25.62 / 0.176 | 9.548 / 16.0 | 15.948 | 4590 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 87444 | 25.178 / 0.175 | 1.384 / 16.0 | 2.335 | 4683 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 162868 | 24.059 / 0.167 | 2.601 / 20.0 | 4.349 | 4918 / 0 | 3.931 (3.922) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.873 | 33.893 | 16 (vanilla 28) | 220148 | 22.887 / 0.158 | 3.504 / 20.0 | 5.879 | 5181 / 0 | 2.804 (5.819) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.055 | 60.897 | 16 (vanilla 28) | 122728 | 21.673 / 0.15 | 1.931 / 20.0 | 3.277 | 5550 / 0 | 0.73 (0.728) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.167 | 23.079 | 16 (vanilla 28) | 796744 | 18.835 / 0.137 | 12.887 / 28.0 | 21.275 | 6412 / 0 | 2.949 (7.867) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.019 | 113.425 | 16 (vanilla 28) | 768368 | 7.563 / 0.044 | 12.381 / 20.0 | 20.518 | 1090 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.198 | 37.201 | 16 (vanilla 28) | 770984 | 6.798 / 0.113 | 12.484 / 28.0 | 20.587 | 2445 / 0 | 3.455 (8.396) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 22.039 | 16 (vanilla 28) | 849344 | 6.386 / 0.01 | 13.608 / 24.0 | 22.68 | 938 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 536364 | 2.456 / 0.021 | 8.534 / 24.0 | 14.322 | 602 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 18.794 / 0.137 | 0.131 / 28.0 | 0.225 | 6453 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.645 / 0.136 | 0.302 / 28.0 | 0.518 | 6555 / 0 | 0.965 (1.382) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.593 / 0.136 | 0.153 / 28.0 | 0.261 | 6604 / 0 | 0.541 (0.822) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.222 | 1.0 | 0.0 | 0 | 0 | 32 (0.023 / 0.035 / 0.037; 0) | 0 | 37098 / 0 / 0 |
| flythrough | 193.548 | 1.0 | 0.0 | 0 | 0 | 893 (0.016 / 0.034 / 2.513; 0) | 62 | 36387 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1928 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.084 / 1.199 / 1.27; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.109 / 0.143 / 3.15; 0) | 180 | 3738 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 801 | 0 (None / None / None; 0) | 0 | 1068 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 822 | 0 (None / None / None; 0) | 0 | 1918 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2252 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.234 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.047 (0.233; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.676 | 1.0 (0.0, 0.0) | 1.144 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.011 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.103 (0.177; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.066 (0.242; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.37) | 6.0 (6.0, 2.283) | 0.052 (0.23; 0) | 0 | 2792 / 1512568 / 0 / 0 |
| occlusion_corner | 81.864 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.279 | 1.0 (0.0, 0.0) | 0.781 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.763 | 1.0 (0.0, 0.0) | 0.759 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.59 (0.0, 0.0) | 0.001 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 267.61 / 349.21 (23.4) | 267.61 / 81.61 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4815 / 0 |
| flythrough | two-phase | 319.08 / 410.36 (22.2) | 313.69 / 96.66 / 5.39 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4327 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10440 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 34716 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10875 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.4 / 51.31 (56.3) | 22.35 / 28.96 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4344 / 0 |
| occlusion_corner | two-phase | 60.77 / 81.86 (25.8) | 60.69 / 21.16 / 0.08 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3177 / 0 |
| translucent_move | two-phase | 15.66 / 136.15 (88.5) | 15.64 / 120.51 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 16021 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5829 / 0 |
| translucent_move_oit | two-phase | 15.66 / 136.26 (88.5) | 15.62 / 120.63 / 0.03 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 8198 / 0 |
| flat_plants | two-phase | 9.0 / 151.0 (94.0) | 9.0 / 142.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 20022 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 15150 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.564 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 68.274 / 0.0 | 0.02 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.898 / 0.0 | 0.009 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.862 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.898 / 53.78 | 0.023 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.5 | 0.893 / 0.907 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 43.34 / 13.28 | 0.058 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 112.419 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.735 / 14.727 | 0.007 / 0.015 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.713 / 54.801 | 0.012 / 0.017 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.58 / 12.613 | 0.005 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.1 | 0.736 / 0.993 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.893 / 1.81 | 0.009 / 0.005 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 86.466 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.003 / 0.028 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.269 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.795 | 0.003 / 0.006 | 56 (3) | 40.608 / 9.235 / 31.373 | 3 / 0 | 10.975 |
| animated_items | 136.426 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 50.11 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 253.67 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 67.09 (reported, not gated) | 35 (reported, not gated) | 294100 (reported, not gated) | 309.63 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.71 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 237.94 (base 249.83) | 4.24 (base 5.99) |
| nether | 23.19 (base 33.79) | 10 (base 11) | 4400 (base 10656) | 258.8 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.68 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 257.87 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.59 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.71 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.41 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.06 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.68 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.98 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 17.87 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 274.27 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7540 (base 7604) | 237.03 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.27 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 239.74 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 16.74 (base 33.0) | 13 (base 13) | 1512 (base 1716) | 239.54 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.34 (base 240.73) | 3.35 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.31 (base 261.4) | 4.24 (base 4.24) |
| animation | 50 median (avg 40.02) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.74 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 47.09) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.27 (base 239.53) | 4.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.11 / 50 (12.81) | 849.0 / 849 (11.58) | median and average, x 1.10 + 2 |
| flythrough | 67.09 / 64 (9.39) | 1021.92 / 1024 (7.11) | median and average, at most vanilla |
| water_glass | 19.71 / 20 (28.06) | 389.7 / 390 (19.14) | median, at most vanilla |
| nether | 23.19 / 26 (27.14) | 587.98 / 588 (18.68) | median, x 1.10 + 2 |
| mobs | 25.68 / 26 (29.27) | 307.89 / 329 (24.45) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 127.27 / 166 (30.01) | median, x 1.10 + 2 |
| occlusion | 18.71 / 19 (30.0) | 160.33 / 199 (29.99) | median and average, x 1.10 + 2 |
| occlusion_move | 24.06 / 24 (29.97) | 165.62 / 200 (29.96) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (30.0) | 163.27 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 17.87 / 18 (23.06) | 366.03 / 366 (19.09) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (13.53) | 401.0 / 401 (9.91) | median, at most vanilla |
| translucent_move_oit | 25.27 / 25 (10.98) | 383.54 / 385 (9.5) | median and average, at most vanilla |
| flat_plants | 16.74 / 20 (27.69) | 394.82 / 397 (19.73) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.99) | 290.83 / 325 (28.37) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.32 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.02 / 50 (30.0) | 156.46 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.09 / 60 (30.01) | 167.22 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.145 | 36.0 / 23.145 | 0.0 / 0.0 | 416.0 / 37.199 |
| flythrough | 112.0 / 86.835 | 112.0 / 86.835 | 0.0 / 0.0 | 416.0 / 145.479 |
| water_glass | 36.0 / 12.381 | 36.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| nether | 20.0 / 15.241 | 20.0 / 15.241 | 0.0 / 0.0 | 256.0 / 26.742 |
| mobs | 16.0 / 9.644 | 16.0 / 9.644 | 0.0 / 0.0 | 256.0 / 16.748 |
| outline | 16.0 / 1.384 | 16.0 / 1.384 | 0.0 / 0.0 | 256.0 / 2.457 |
| occlusion | 20.0 / 2.589 | 20.0 / 2.589 | 0.0 / 0.0 | 416.0 / 4.344 |
| occlusion_move | 20.0 / 3.557 | 20.0 / 3.557 | 0.0 / 0.0 | 416.0 / 6.029 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.887 | 28.0 / 12.887 | 0.0 / 0.0 | 416.0 / 22.1 |
| water_glass_oit | 20.0 / 12.381 | 20.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| translucent_move_oit | 28.0 / 12.539 | 28.0 / 12.539 | 0.0 / 0.0 | 416.0 / 21.361 |
| flat_plants | 24.0 / 13.673 | 24.0 / 13.673 | 0.0 / 0.0 | 416.0 / 23.454 |
| renderer_off | 24.0 / 8.534 | 24.0 / 8.534 | 0.0 / 0.0 | 416.0 / 14.916 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 420924.753 (639733.718) | 34.203 | 1.785 | 416660 / 571748 | 409232 (2097152.0) | 255 / 231 | 0.0 / 0 |
| flythrough | 563527.754 (903281.818) | 37.613 | 1.082 | 2104308 / 7159144 | 2093568 (2097152.0) | 187 / 142 | 6.66 / 63 |
| water_glass | 111722.441 (194647.733) | 42.603 | 1.133 | 8660 / 11876 | 0 (2097152.0) | 4 / 333 | 0.0 / 0 |
| nether | 37500.502 (56902.033) | 34.096 | 1.919 | 211492 / 437592 | 208000 (2097152.0) | 135 / 357 | 0.0 / 0 |
| mobs | 62155.887 (110953.017) | 43.98 | 0.967 | 610676 / 612388 | 0 (2097152.0) | 1 / 5 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29383.873 (51735.927) | 43.204 | 1.278 | 404808 / 216524 | 306752 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 51494.26 (90799.447) | 43.288 | 1.219 | 770108 / 1341292 | 695040 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27772.217 (60488.367) | 54.087 | 1.272 | 32840 / 57800 | 31552 (2097152.0) | 0 / 1 | 0.0 / 0 |
| translucent_move | 200185.132 (355360.646) | 43.667 | 1.179 | 753844 / 1293044 | 748032 (2097152.0) | 3 / 305 | 0.0 / 0 |
| water_glass_oit | 111937.052 (195021.637) | 42.603 | 1.133 | 8884 / 10644 | 0 (2097152.0) | 270 / 198 | 0.0 / 0 |
| translucent_move_oit | 199962.037 (354705.132) | 43.626 | 1.177 | 754212 / 1314772 | 748032 (2097152.0) | 219 / 190 | 0.0 / 0 |
| flat_plants | 9100.397 (12476.48) | 27.06 | 1.045 | 1940 / 4740 | 0 (2097152.0) | 138 / 181 | 0.0 / 0 |
| renderer_off | 19374.29 (36601.002) | 47.066 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 9636 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3044.114 (5227.753) | 41.77 | 1.087 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2246.785 (4832.668) | 53.508 | 1.0 | 79396 / 122740 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.77 (106) | 2.842 (87) | 0.975 | 2.949 (56) | 0 | 923 / 0 | 6.477 / 9.797 | 2.876 / 4.961 |
| flythrough | 4.446 (1711) | 4.657 (1623) | 0.955 | 4.446 (1711) | 0 | 1388 / 0 | 5.194 / 7.249 | 3.007 / 4.934 |
| water_glass | 1.207 (17) | 1.069 (18) | 1.129 | None (0) | 0 | 1238 / 0 | 5.89 / 8.734 | 2.681 / 4.495 |
| nether | 2.145 (24) | 1.931 (24) | 1.111 | 2.4 (7) | 0 | 1875 / 0 | 4.706 / 6.946 | 2.201 / 3.325 |
| mobs | 0.724 (6) | 0.509 (6) | 1.422 | None (0) | 0 | 2109 / 0 | 4.544 / 6.693 | 2.165 / 3.237 |
| outline | 0.381 (13) | 0.255 (12) | 1.494 | None (0) | 0 | 2167 / 0 | 4.466 / 6.584 | 2.136 / 3.187 |
| occlusion | 1.054 (48) | 0.664 (43) | 1.587 | 2.18 (6) | 0 | 2298 / 0 | 4.33 / 6.406 | 2.069 / 3.097 |
| occlusion_move | 1.441 (65) | 2.035 (70) | 0.708 | 3.208 (22) | 0 | 2456 / 0 | 4.15 / 6.141 | 1.999 / 2.939 |
| occlusion_corner | 0.958 (84) | 0.802 (110) | 1.195 | 1.406 (1) | 0 | 2736 / 0 | 3.887 / 5.694 | 1.803 / 2.673 |
| translucent_move | 2.542 (109) | 2.443 (131) | 1.041 | 3.719 (35) | 0 | 3105 / 0 | 3.816 / 5.584 | 1.853 / 2.726 |
| water_glass_oit | 3.127 (154) | 2.587 (152) | 1.209 | None (0) | 0 | 412 / 0 | 5.731 / 8.01 | 3.253 / 4.482 |
| translucent_move_oit | 2.952 (219) | 3.597 (212) | 0.821 | 3.692 (27) | 0 | 971 / 0 | 4.179 / 5.945 | 2.142 / 3.34 |
| flat_plants | 1.321 (95) | 1.443 (95) | 0.915 | None (0) | 0 | 402 / 0 | 5.366 / 6.724 | 1.951 / 2.483 |
| renderer_off | 0.459 (26) | 0.614 (26) | 0.748 | None (0) | 0 | 325 / 0 | 6.77 / 10.297 | 2.889 / 4.542 |
| particles | 0.389 (24) | 0.219 (30) | 1.776 | None (0) | 0 | 3132 / 0 | 3.787 / 5.539 | 1.828 / 2.682 |
| animation | 0.758 (18) | 0.516 (18) | 1.469 | 0.964 (4) | 0 | 3207 / 0 | 3.715 / 5.432 | 1.772 / 2.604 |
| animated_items | 0.336 (32) | 0.256 (42) | 1.312 | 0.695 (2) | 0 | 3239 / 0 | 3.683 / 5.383 | 1.748 / 2.568 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.153 | 712.635 | 16 (vanilla 28) | 1398272 | 40.666 / 0.092 | 23.145 / 36.0 | 37.338 | 2499 / 0 | 2.949 (6.49) |
| flythrough | plain, one multi-draw per region and layer | 57.262 | 919.439 | 16 (vanilla 28) | 5253560 | 15.244 / 1.024 | 86.835 / 112.0 | 140.285 | 6631 / 0 | 4.446 (13.152) |
| water_glass | plain, one multi-draw per region and layer | 14.025 | 105.187 | 16 (vanilla 28) | 768352 | 33.04 / 0.085 | 12.381 / 36.0 | 20.517 | 3155 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.288 | 57.227 | 16 (vanilla 28) | 958248 | 27.793 / 0.17 | 15.241 / 20.0 | 25.588 | 4214 / 0 | 2.4 (3.215) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.102 | 16 (vanilla 28) | 603164 | 25.281 / 0.149 | 9.644 / 16.0 | 16.106 | 4660 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 87444 | 24.841 / 0.148 | 1.384 / 16.0 | 2.335 | 4754 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.05 | 43.352 | 16 (vanilla 28) | 161808 | 23.658 / 0.141 | 2.589 / 20.0 | 4.321 | 5001 / 0 | 2.18 (2.815) |
| occlusion_move | plain, one multi-draw per region and layer | 10.995 | 76.388 | 16 (vanilla 28) | 222796 | 22.234 / 0.132 | 3.557 / 20.0 | 5.949 | 5307 / 0 | 3.208 (7.467) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.958 | 16 (vanilla 28) | 122728 | 21.085 / 0.125 | 1.931 / 20.0 | 3.277 | 5670 / 0 | 1.406 (1.393) |
| translucent_move | plain, one multi-draw per region and layer | 12.009 | 247.931 | 16 (vanilla 28) | 796184 | 18.314 / 0.115 | 12.887 / 28.0 | 21.26 | 6523 / 0 | 3.719 (9.703) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.059 | 113.419 | 16 (vanilla 28) | 768352 | 7.576 / 0.044 | 12.381 / 20.0 | 20.517 | 1084 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.311 | 261.973 | 16 (vanilla 28) | 773724 | 6.765 / 0.112 | 12.539 / 28.0 | 20.661 | 2437 / 0 | 3.692 (10.883) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 852376 | 6.577 / 0.01 | 13.673 / 24.0 | 22.761 | 952 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 536348 | 2.434 / 0.021 | 8.534 / 24.0 | 14.322 | 612 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.278 / 0.115 | 0.131 / 28.0 | 0.225 | 6562 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 18.135 / 0.114 | 0.302 / 28.0 | 0.518 | 6664 / 0 | 0.964 (1.536) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.701 | 16 (vanilla 28) | 9764 | 18.085 / 0.114 | 0.153 / 28.0 | 0.261 | 6713 / 0 | 0.695 (1.084) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 17.0 | 0.0 | 0 | 0 | 47 (0.021 / 0.034 / 0.066; 0) | 0 | 39424 / 0 / 0 |
| flythrough | 193.936 | 26.181 | 0.0 | 0 | 0 | 895 (0.025 / 0.038 / 7.023; 0) | 46 | 36460 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2252 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.094 / 0.978 / 1.781; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 182 (0.083 / 0.126 / 0.155; 0) | 182 | 3234 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 813 | 0 (None / None / None; 0) | 0 | 1084 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 660 | 0 (None / None / None; 0) | 0 | 1540 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2220 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 350.027 | 2.0 (1.0, 0.0) | 11.0 (0.996, 0.0) | 0.052 (2.062; 1) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.016 | 1.0 (0.0, 0.0) | 1.154 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.268; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.111 (0.219; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.063 (0.105; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.363) | 6.0 (6.0, 2.276) | 0.054 (0.283; 0) | 0 | 2788 / 1509506 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.091 | 1.0 (0.0, 0.0) | 0.768 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.377 | 1.0 (0.0, 0.0) | 0.745 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.043; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 298.05 / 348.02 (14.4) | 298.05 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1518.75 | 3198 / 0 |
| flythrough | still | 410.61 / 411.3 (0.2) | 410.61 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 12180 / 0 |
| nether | still | 45.72 / 300.0 (84.8) | 45.72 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 159.12 | 34190 / 0 |
| mobs | still | 32.0 / 110.0 (70.9) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11388 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.23 / 49.0 (46.5) | 26.23 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.0 | 3381 / 0 |
| occlusion_move | still | 51.19 / 51.32 (0.2) | 51.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.77 / 81.86 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 134.46 / 134.93 (0.3) | 134.46 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5829 / 0 |
| translucent_move_oit | still | 133.79 / 134.77 (0.7) | 133.79 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 150.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 19458 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 447 / 0 |
| animated_items | still | 12.67 / 13.0 (2.5) | 12.67 / 0.0 / 0.0 | 0.32 | 0.0 (0.0, 0.0; 0.0) | 4536.0 | 48 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 83.533 / 0.0 | 0.027 / 0.004 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.093 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.856 |
| water_glass | 114.699 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.087 / 54.117 | 0.015 / 0.029 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.343 | 0.981 / 0.838 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 42.048 / 8.639 | 0.069 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 94.07 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 114.094 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.393 / 13.329 | 0.006 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.743 / 53.782 | 0.017 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.055 / 12.1 | 0.006 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 112.957 / 7.22 | 0.881 / 0.798 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.998 / 1.856 | 0.011 / 0.007 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 81.129 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.036 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.003 / 0.007 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 14.11 (base 14.05) | 15 (base 15) | 28496 (base 27764) | 253.47 (base 257.2) | 4.23 (base 3.98) |
| flythrough | 13.07 (reported, not gated) | 28 (reported, not gated) | 290672 (reported, not gated) | 310.58 (base 318.06) | 3.71 (base 4.23) |
| water_glass | 8.74 (base 9.0) | 15 (base 15) | 12160 (base 15108) | 238.65 (base 244.39) | 4.23 (base 4.23) |
| nether | 13.25 (base 15.71) | 12 (base 12) | 11032 (base 19912) | 259.45 (base 268.95) | 4.23 (base 4.23) |
| mobs | 19.7 (base 19.97) | 17 (base 17) | 613548 (base 1008176) | 258.48 (base 264.31) | 4.23 (base 6.23) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 258.19 (base 264.58) | 4.23 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100016 (base 126356) | 264.19 (base 264.78) | 4.23 (base 3.98) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82468 (reported, not gated) | 264.58 (base 265.16) | 4.23 (base 4.23) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 268.78 (base 266.66) | 4.23 (base 3.71) |
| translucent_move | 8.88 (reported, not gated) | 15 (reported, not gated) | 11076 (reported, not gated) | 275.17 (base 268.35) | 8.23 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 12384 (base 15024) | 236.69 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10964 (reported, not gated) | 239.38 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 16.13 (base 18.96) | 15 (base 15) | 4560 (base 9864) | 239.5 (base 248.07) | 3.46 (base 5.98) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 3612 (base 7180) | 232.62 (base 241.13) | 3.34 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 266.12 (base 261.4) | 8.23 (base 5.98) |
| animation | 50 median (avg 40.05) (base 49) | 15 (base 15) | 2164 (base 2056) | 262.8 (base 260.68) | 8.23 (base 5.98) |
| animated_items | 60 median (avg 46.98) (base 60) | 23 (base 23) | 21976 (base 21940) | 237.08 (base 239.74) | 8.23 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.11 / 14 (12.56) | 123.0 / 123 (9.24) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (9.02) | 123.06 / 123 (5.34) | median and average, at most vanilla + 2 |
| water_glass | 8.74 / 9 (27.01) | 124.0 / 124 (15.23) | median, at most vanilla |
| nether | 13.25 / 16 (25.96) | 120.88 / 121 (15.3) | median, x 1.10 + 2 |
| mobs | 19.7 / 20 (28.76) | 134.0 / 134 (19.21) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.59 / 133 (29.91) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (30.0) | 94.53 / 133 (29.89) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (30.0) | 82.4 / 121 (29.95) | median and average, x 1.10 + 2 |
| translucent_move | 8.88 / 9 (22.63) | 124.0 / 124 (15.66) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (11.58) | 129.0 / 129 (8.43) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (10.36) | 129.0 / 129 (7.99) | median and average, at most vanilla |
| flat_plants | 16.13 / 19 (27.09) | 123.97 / 124 (15.81) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.96) | 108.06 / 123 (22.94) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.32 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.05 / 50 (30.0) | 144.46 / 179 (29.99) | median, x 1.10 + 2 |
| animated_items | 46.98 / 60 (30.0) | 155.28 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 40.0 / 22.902 | 40.0 / 22.902 | 0.0 / 0.0 | 416.0 / 37.41 |
| flythrough | 112.0 / 87.507 | 112.0 / 87.507 | 0.0 / 0.0 | 416.0 / 144.334 |
| water_glass | 40.0 / 12.381 | 40.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| nether | 20.0 / 15.241 | 20.0 / 15.241 | 0.0 / 0.0 | 256.0 / 26.743 |
| mobs | 16.0 / 9.548 | 16.0 / 9.548 | 0.0 / 0.0 | 256.0 / 16.748 |
| outline | 16.0 / 1.384 | 16.0 / 1.384 | 0.0 / 0.0 | 256.0 / 2.457 |
| occlusion | 20.0 / 2.591 | 20.0 / 2.591 | 0.0 / 0.0 | 416.0 / 4.79 |
| occlusion_move | 20.0 / 3.503 | 20.0 / 3.503 | 0.0 / 0.0 | 416.0 / 6.387 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.884 | 28.0 / 12.884 | 0.0 / 0.0 | 416.0 / 22.481 |
| water_glass_oit | 20.0 / 12.381 | 20.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| translucent_move_oit | 28.0 / 12.536 | 28.0 / 12.536 | 0.0 / 0.0 | 416.0 / 21.768 |
| flat_plants | 24.0 / 13.588 | 24.0 / 13.588 | 0.0 / 0.0 | 416.0 / 23.669 |
| renderer_off | 24.0 / 8.53 | 24.0 / 8.53 | 0.0 / 0.0 | 416.0 / 14.916 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 475801.673 (643093.594) | 26.014 | 1.175 | 451072 / 649284 | 419976 (2097152.0) | 251 / 184 | 0.0 / 0 |
| flythrough | 561179.244 (899458.478) | 37.609 | 1.082 | 2125540 / 7457728 | 2097024 (2097152.0) | 180 / 106 | 4.713 / 61 |
| water_glass | 111730.526 (194661.819) | 42.603 | 1.133 | 14512 / 17592 | 0 (2097152.0) | 14 / 304 | 0.0 / 0 |
| nether | 51925.151 (76126.861) | 31.791 | 1.653 | 232772 / 271812 | 210176 (2097152.0) | 120 / 305 | 0.0 / 0 |
| mobs | 62157.913 (110956.633) | 43.98 | 0.967 | 613548 / 616328 | 0 (2097152.0) | 1 / 376 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29716.712 (52403.787) | 43.293 | 1.278 | 474848 / 126344 | 374272 (2097152.0) | 0 / 1 | 0.0 / 0 |
| occlusion_move | 51454.174 (90680.16) | 43.258 | 1.225 | 828388 / 1311008 | 751808 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27774.67 (60488.367) | 54.083 | 1.272 | 36096 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 200739.382 (356282.949) | 43.657 | 1.179 | 759352 / 1319868 | 748032 (2097152.0) | 6 / 313 | 0.0 / 0 |
| water_glass_oit | 112006.788 (195143.134) | 42.603 | 1.133 | 13392 / 17368 | 0 (2097152.0) | 231 / 168 | 0.0 / 0 |
| translucent_move_oit | 201461.585 (357315.71) | 43.618 | 1.178 | 759196 / 1319140 | 748032 (2097152.0) | 207 / 159 | 0.0 / 0 |
| flat_plants | 9100.791 (12477.02) | 27.06 | 1.045 | 5008 / 9868 | 0 (2097152.0) | 37 / 316 | 0.0 / 0 |
| renderer_off | 19374.29 (36601.002) | 47.066 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 0 / 4 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9876 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3061.135 (5267.352) | 41.885 | 1.085 | 86832 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2244.519 (4827.461) | 53.505 | 1.0 | 79704 / 123068 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 1.962 (122) | 2.85 (110) | 0.688 | 2.022 (51) | 0 | 896 / 0 | 4.915 / 6.785 | 2.141 / 3.074 |
| flythrough | 3.05 (1658) | 7.035 (1511) | 0.434 | 3.05 (1658) | 0 | 1392 / 0 | 4.212 / 5.77 | 2.297 / 3.344 |
| water_glass | 1.067 (15) | 2.362 (14) | 0.452 | None (0) | 0 | 1211 / 0 | 4.484 / 6.03 | 2.008 / 2.743 |
| nether | 1.713 (29) | 1.857 (14) | 0.922 | 1.696 (14) | 0 | 1832 / 0 | 3.756 / 4.98 | 1.736 / 2.343 |
| mobs | 0.54 (6) | 0.752 (6) | 0.718 | None (0) | 0 | 2068 / 0 | 3.615 / 4.77 | 1.696 / 2.295 |
| outline | 0.324 (12) | 0.573 (12) | 0.565 | None (0) | 0 | 2126 / 0 | 3.563 / 4.696 | 1.68 / 2.277 |
| occlusion | 0.836 (51) | 0.913 (47) | 0.916 | 2.852 (2) | 0 | 2255 / 0 | 3.5 / 4.627 | 1.649 / 2.247 |
| occlusion_move | 1.136 (56) | 1.877 (61) | 0.605 | 2.477 (19) | 0 | 2409 / 0 | 3.358 / 4.442 | 1.618 / 2.174 |
| occlusion_corner | 1.037 (97) | 1.157 (110) | 0.896 | 0.667 (1) | 0 | 2689 / 0 | 3.139 / 4.113 | 1.425 / 1.948 |
| translucent_move | 1.808 (124) | 2.462 (116) | 0.734 | 2.024 (42) | 0 | 3050 / 0 | 3.077 / 4.075 | 1.476 / 1.99 |
| water_glass_oit | 2.076 (154) | 3.171 (148) | 0.655 | None (0) | 0 | 413 / 0 | 5.366 / 6.582 | 2.277 / 3.48 |
| translucent_move_oit | 2.35 (224) | 4.142 (210) | 0.567 | 2.676 (26) | 0 | 967 / 0 | 3.504 / 4.51 | 1.652 / 2.25 |
| flat_plants | 1.294 (96) | 2.01 (74) | 0.644 | None (0) | 0 | 403 / 0 | 5.693 / 6.03 | 1.76 / 1.927 |
| renderer_off | 0.348 (24) | 0.469 (21) | 0.742 | None (0) | 0 | 320 / 0 | 5.2 / 6.84 | 1.605 / 2.405 |
| particles | 0.224 (24) | 0.284 (30) | 0.789 | None (0) | 0 | 3080 / 0 | 3.052 / 4.041 | 1.458 / 1.967 |
| animation | 0.697 (18) | 1.167 (18) | 0.597 | 0.827 (4) | 0 | 3155 / 0 | 2.993 / 3.961 | 1.397 / 1.909 |
| animated_items | 0.293 (32) | 0.354 (42) | 0.828 | 0.651 (2) | 0 | 3187 / 0 | 2.967 / 3.925 | 1.372 / 1.876 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.012 | 717.657 | 16 (vanilla 28) | 1382428 | 41.335 / 0.085 | 22.902 / 40.0 | 36.915 | 2490 / 0 | 2.022 (3.146) |
| flythrough | indirect, one multi-draw per arena and layer | 3.017 | 917.922 | 16 (vanilla 28) | 5300004 | 15.206 / 0.987 | 87.507 / 112.0 | 141.525 | 6527 / 0 | 3.05 (9.018) |
| water_glass | indirect, one multi-draw per arena and layer | 3.006 | 105.194 | 16 (vanilla 28) | 768352 | 33.963 / 0.078 | 12.381 / 40.0 | 20.517 | 3141 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 75.979 | 16 (vanilla 28) | 958232 | 28.653 / 0.184 | 15.241 / 20.0 | 25.588 | 4177 / 0 | 1.696 (2.859) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 60.104 | 16 (vanilla 28) | 597228 | 26.081 / 0.161 | 9.548 / 16.0 | 15.948 | 4627 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 87444 | 25.639 / 0.16 | 1.384 / 16.0 | 2.335 | 4720 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.245 | 16 (vanilla 28) | 162596 | 24.388 / 0.152 | 2.591 / 20.0 | 4.342 | 4965 / 0 | 2.852 (3.126) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.003 | 74.361 | 16 (vanilla 28) | 220900 | 22.983 / 0.143 | 3.503 / 20.0 | 5.899 | 5251 / 0 | 2.477 (5.571) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.958 | 16 (vanilla 28) | 122728 | 21.773 / 0.135 | 1.931 / 20.0 | 3.277 | 5627 / 0 | 0.667 (0.664) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.004 | 247.066 | 16 (vanilla 28) | 797648 | 18.884 / 0.123 | 12.884 / 28.0 | 21.299 | 6483 / 0 | 2.024 (3.579) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.022 | 113.489 | 16 (vanilla 28) | 768352 | 7.575 / 0.044 | 12.381 / 20.0 | 20.517 | 1086 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.024 | 262.614 | 16 (vanilla 28) | 775156 | 6.97 / 0.118 | 12.536 / 28.0 | 20.699 | 2424 / 0 | 2.676 (7.13) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.041 | 16 (vanilla 28) | 848660 | 6.538 / 0.01 | 13.588 / 24.0 | 22.662 | 956 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 536344 | 2.455 / 0.021 | 8.53 / 24.0 | 14.322 | 600 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 18.83 / 0.123 | 0.131 / 28.0 | 0.225 | 6528 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.765 | 16 (vanilla 28) | 19416 | 18.685 / 0.122 | 0.302 / 28.0 | 0.518 | 6630 / 0 | 0.827 (1.339) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.672 | 16 (vanilla 28) | 9764 | 18.635 / 0.122 | 0.153 / 28.0 | 0.261 | 6679 / 0 | 0.651 (0.979) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 1.0 | 0.0 | 0 | 0 | 49 (0.023 / 0.035 / 0.057; 0) | 0 | 39060 / 0 / 0 |
| flythrough | 193.055 | 1.0 | 0.0 | 0 | 0 | 874 (0.014 / 0.036 / 1.054; 0) | 57 | 34943 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2164 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1204 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.014 / 0.068 / 0.082; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.091 / 0.136 / 0.878; 0) | 180 | 3178 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 696 | 0 (None / None / None; 0) | 0 | 928 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 624 | 0 (None / None / None; 0) | 0 | 1456 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2168 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 343.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.042 (0.097; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.144 | 1.0 (0.0, 0.0) | 1.116 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.042; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.099 (0.213; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.055 (0.133; 0) | 0 | 3612 / 1635032 / 0 / 0 |
| occlusion_move | 50.36 | 10.0 (9.0, 2.367) | 6.0 (6.0, 2.28) | 0.04 (0.229; 0) | 0 | 2788 / 1509788 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.156 | 1.0 (0.0, 0.0) | 0.771 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.726 | 1.0 (0.0, 0.0) | 0.75 (0.0, 0.0) | 0.002 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 149.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.004 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 301.42 / 341.0 (11.6) | 301.42 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1600.0 | 2475 / 0 |
| flythrough | still | 411.22 / 411.57 (0.1) | 411.22 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11745 / 0 |
| nether | still | 57.27 / 300.0 (80.9) | 57.27 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 277.46 | 31297 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10725 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.15 / 48.0 (45.5) | 26.15 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 23.92 | 3300 / 0 |
| occlusion_move | still | 50.19 / 50.31 (0.2) | 50.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 36 / 0 |
| occlusion_corner | still | 81.77 / 81.86 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 134.52 / 135.0 (0.4) | 134.52 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5046 / 0 |
| translucent_move_oit | still | 134.56 / 135.08 (0.4) | 134.56 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 149.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 18900 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 303 / 0 |
| animated_items | still | 12.64 / 13.0 (2.8) | 12.64 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4497.01 | 54 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 117.791 / 0.0 | 0.021 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 4.266 / 0.0 | 0.011 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.862 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 56.591 / 56.66 | 0.011 / 0.015 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.625 | 0.882 / 0.847 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 40.363 / 8.967 | 0.059 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.923 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.859 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.165 / 13.075 | 0.006 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 56.135 / 55.94 | 0.013 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.481 / 13.327 | 0.004 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.394 | 0.968 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.202 / 2.98 | 0.014 / 0.006 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 100.186 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.033 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.302 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.795 | 0.001 / 0.006 | 56 (3) | 40.608 / 9.245 / 31.363 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.003 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.536 / 7.97 / 32.566 | 0 / 0 | 9.0 |

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
| spawn | 51.62 (base 49.0) | 13 (base 13) | 7572 (base 6372) | 252.42 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 69.93 (reported, not gated) | 45 (reported, not gated) | 678028 (reported, not gated) | 308.07 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.91 (base 20.0) | 13 (base 14) | 7540 (base 10264) | 237.67 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.1 (base 33.79) | 10 (base 11) | 4392 (base 10656) | 259.31 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.74 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 257.5 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.72 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.26 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.05 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.58 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.8 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.1 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 274.36 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7316 (base 7604) | 236.97 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.41 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 239.6 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.04 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 239.57 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 13.71 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.06 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.71 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.22 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.89 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 236.09 (base 239.53) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 51.62 / 52 (10.22) | 849.0 / 849 (11.58) | median and average, x 1.10 + 2 |
| flythrough | 69.93 / 69 (6.75) | 1021.92 / 1024 (7.11) | median and average, at most vanilla |
| water_glass | 20.91 / 21 (20.97) | 389.7 / 390 (19.14) | median, at most vanilla |
| nether | 24.1 / 27 (25.43) | 587.98 / 588 (18.68) | median, x 1.10 + 2 |
| mobs | 26.74 / 27 (27.16) | 307.89 / 329 (24.45) | median, x 1.10 + 2 |
| outline | 11.72 / 12 (29.99) | 127.27 / 166 (30.01) | median, x 1.10 + 2 |
| occlusion | 19.67 / 20 (29.98) | 160.33 / 199 (29.99) | median and average, x 1.10 + 2 |
| occlusion_move | 20.09 / 21 (29.79) | 165.62 / 200 (29.96) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.8 / 12 (29.99) | 163.27 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 11.13 / 11 (25.45) | 366.03 / 366 (19.09) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (10.44) | 401.0 / 401 (9.91) | median, at most vanilla |
| translucent_move_oit | 18.41 / 18 (10.89) | 383.54 / 385 (9.5) | median and average, at most vanilla |
| flat_plants | 18.04 / 21 (24.19) | 394.82 / 397 (19.73) | median, x 1.10 + 2 |
| renderer_off | 13.71 / 14 (28.2) | 290.83 / 325 (28.37) | median, x 1.10 + 2 |
| particles | 11.71 / 12 (29.99) | 97.32 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.98 / 50 (30.0) | 156.46 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (29.99) | 167.22 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.201 | 36.0 / 23.201 | 0.0 / 0.0 | 416.0 / 37.199 |
| flythrough | 112.0 / 84.73 | 112.0 / 84.73 | 0.0 / 0.0 | 416.0 / 145.479 |
| water_glass | 36.0 / 12.381 | 36.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| nether | 20.0 / 15.24 | 20.0 / 15.24 | 0.0 / 0.0 | 256.0 / 26.742 |
| mobs | 16.0 / 9.548 | 16.0 / 9.548 | 0.0 / 0.0 | 256.0 / 16.748 |
| outline | 16.0 / 1.384 | 16.0 / 1.384 | 0.0 / 0.0 | 256.0 / 2.457 |
| occlusion | 20.0 / 2.458 | 20.0 / 2.458 | 0.0 / 0.0 | 416.0 / 4.344 |
| occlusion_move | 20.0 / 3.461 | 20.0 / 3.461 | 0.0 / 0.0 | 416.0 / 6.029 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.852 | 28.0 / 12.852 | 0.0 / 0.0 | 416.0 / 22.1 |
| water_glass_oit | 20.0 / 12.381 | 20.0 / 12.381 | 0.0 / 0.0 | 416.0 / 21.503 |
| translucent_move_oit | 28.0 / 12.449 | 28.0 / 12.449 | 0.0 / 0.0 | 416.0 / 21.361 |
| flat_plants | 24.0 / 13.721 | 24.0 / 13.721 | 0.0 / 0.0 | 416.0 / 23.454 |
| renderer_off | 24.0 / 8.534 | 24.0 / 8.534 | 0.0 / 0.0 | 416.0 / 14.916 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 400504.775 (602901.833) | 33.57 | 1.783 | 363328 / 571748 | 355648 (2097152.0) | 204 / 231 | 0.0 / 0 |
| flythrough | 480003.17 (756871.822) | 36.581 | 1.085 | 2102356 / 7159144 | 2092656 (2097152.0) | 135 / 142 | 8.779 / 75 |
| water_glass | 111790.167 (194765.728) | 42.603 | 1.133 | 9220 / 11876 | 0 (2097152.0) | 116 / 333 | 0.0 / 0 |
| nether | 29501.847 (42401.139) | 30.422 | 2.0 | 220924 / 437592 | 216064 (2097152.0) | 128 / 357 | 0.0 / 0 |
| mobs | 62164.273 (110967.985) | 43.98 | 0.967 | 610516 / 612388 | 0 (2097152.0) | 20 / 5 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 6380 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27345.5 (47757.463) | 42.741 | 1.302 | 98148 / 216524 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 21033.855 (36791.261) | 42.829 | 1.275 | 793916 / 1341292 | 718848 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21832.217 (47199.422) | 53.745 | 1.214 | 32840 / 57800 | 31552 (2097152.0) | 0 / 1 | 0.0 / 0 |
| translucent_move | 21594.813 (27607.807) | 21.78 | 1.005 | 752948 / 1293044 | 748032 (2097152.0) | 128 / 305 | 0.0 / 0 |
| water_glass_oit | 112060.173 (195236.144) | 42.603 | 1.133 | 8884 / 10644 | 0 (2097152.0) | 208 / 198 | 0.0 / 0 |
| translucent_move_oit | 21703.687 (27776.654) | 21.864 | 1.005 | 754884 / 1314772 | 748032 (2097152.0) | 217 / 190 | 0.0 / 0 |
| flat_plants | 9102.807 (12479.785) | 27.06 | 1.045 | 100116 / 4740 | 98624 (2097152.0) | 121 / 181 | 0.0 / 0 |
| renderer_off | 19376.355 (36604.902) | 47.066 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 74 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9444 / 9636 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86232 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79144 / 122740 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.622 (119) | 2.842 (87) | 1.274 | 3.398 (65) | 0 | 875 / 0 | 9.09 / 11.545 | 4.193 / 5.941 |
| flythrough | 5.829 (1576) | 4.657 (1623) | 1.252 | 5.829 (1576) | 0 | 1406 / 0 | 6.972 / 9.348 | 4.654 / 6.305 |
| water_glass | 2.95 (18) | 1.069 (18) | 2.76 | None (0) | 0 | 1206 / 0 | 8.298 / 10.409 | 3.942 / 5.438 |
| nether | 2.959 (36) | 1.931 (24) | 1.532 | 2.681 (15) | 0 | 1823 / 0 | 6.941 / 8.701 | 3.433 / 4.71 |
| mobs | 0.956 (6) | 0.509 (6) | 1.878 | None (0) | 0 | 2054 / 0 | 6.776 / 8.489 | 3.348 / 4.526 |
| outline | 0.572 (12) | 0.255 (12) | 2.243 | None (0) | 0 | 2112 / 0 | 6.659 / 8.379 | 3.231 / 4.479 |
| occlusion | 1.252 (46) | 0.664 (43) | 1.886 | None (0) | 0 | 2245 / 0 | 6.465 / 8.153 | 3.098 / 4.354 |
| occlusion_move | 2.387 (65) | 2.035 (70) | 1.173 | 5.286 (18) | 0 | 2394 / 0 | 6.214 / 7.826 | 2.967 / 4.084 |
| occlusion_corner | 1.31 (110) | 0.802 (110) | 1.633 | 1.526 (1) | 0 | 2663 / 0 | 5.8 / 7.262 | 2.72 / 3.712 |
| translucent_move | 3.498 (113) | 2.443 (131) | 1.432 | 6.517 (32) | 0 | 3027 / 0 | 5.717 / 7.238 | 2.796 / 3.86 |
| water_glass_oit | 4.035 (154) | 2.587 (152) | 1.56 | None (0) | 0 | 413 / 0 | 9.637 / 12.36 | 5.391 / 6.949 |
| translucent_move_oit | 3.403 (214) | 3.597 (212) | 0.946 | 4.29 (25) | 0 | 959 / 0 | 6.42 / 8.512 | 3.633 / 4.703 |
| flat_plants | 1.983 (76) | 1.443 (95) | 1.374 | 2.161 (1) | 0 | 402 / 0 | 7.415 / 9.036 | 3.535 / 3.988 |
| renderer_off | 0.659 (21) | 0.614 (26) | 1.073 | None (0) | 0 | 321 / 0 | 8.194 / 10.649 | 3.607 / 4.957 |
| particles | 0.38 (30) | 0.219 (30) | 1.735 | None (0) | 0 | 3057 / 0 | 5.669 / 7.176 | 2.757 / 3.796 |
| animation | 1.218 (18) | 0.516 (18) | 2.36 | 1.2 (4) | 0 | 3132 / 0 | 5.561 / 7.038 | 2.674 / 3.686 |
| animated_items | 0.486 (42) | 0.256 (42) | 1.898 | 1.24 (2) | 0 | 3164 / 0 | 5.51 / 6.973 | 2.631 / 3.641 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.191 | 661.225 | 16 (vanilla 28) | 1402512 | 40.697 / 0.104 | 23.201 / 36.0 | 37.451 | 2389 / 0 | 3.398 (7.27) |
| flythrough | plain, one multi-draw per region and layer | 59.2 | 751.311 | 16 (vanilla 28) | 5129620 | 15.301 / 0.998 | 84.73 / 112.0 | 136.976 | 6406 / 0 | 5.829 (16.462) |
| water_glass | plain, one multi-draw per region and layer | 14.033 | 105.251 | 16 (vanilla 28) | 768352 | 33.412 / 0.088 | 12.381 / 36.0 | 20.517 | 3092 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.024 | 43.084 | 16 (vanilla 28) | 958216 | 28.029 / 0.179 | 15.24 / 20.0 | 25.587 | 4135 / 0 | 2.681 (4.298) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.11 | 16 (vanilla 28) | 597228 | 25.532 / 0.157 | 9.548 / 16.0 | 15.948 | 4575 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 87444 | 25.091 / 0.156 | 1.384 / 16.0 | 2.335 | 4668 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 153680 | 23.959 / 0.149 | 2.458 / 20.0 | 4.104 | 4909 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.834 | 16 (vanilla 28) | 216168 | 22.597 / 0.14 | 3.461 / 20.0 | 5.772 | 5203 / 0 | 5.286 (13.417) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.88 | 16 (vanilla 28) | 122728 | 21.353 / 0.132 | 1.931 / 20.0 | 3.277 | 5581 / 0 | 1.526 (1.523) |
| translucent_move | plain, one multi-draw per region and layer | 4.387 | 23.092 | 16 (vanilla 28) | 792896 | 18.572 / 0.121 | 12.852 / 28.0 | 21.173 | 6430 / 0 | 6.517 (15.034) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.077 | 113.543 | 16 (vanilla 28) | 768352 | 7.574 / 0.044 | 12.381 / 20.0 | 20.517 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.442 | 37.253 | 16 (vanilla 28) | 767112 | 6.626 / 0.092 | 12.449 / 28.0 | 20.484 | 2403 / 0 | 4.29 (11.891) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.046 | 16 (vanilla 28) | 855708 | 5.708 / 0.01 | 13.721 / 24.0 | 22.85 | 908 / 0 | 2.161 (2.156) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.039 | 16 (vanilla 28) | 536356 | 2.453 / 0.021 | 8.534 / 24.0 | 14.322 | 598 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.514 / 0.12 | 0.131 / 28.0 | 0.225 | 6478 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.368 / 0.119 | 0.302 / 28.0 | 0.518 | 6580 / 0 | 1.2 (2.075) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.317 / 0.12 | 0.153 / 28.0 | 0.261 | 6630 / 0 | 1.24 (1.914) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 46 (0.026 / 0.044 / 0.061; 0) | 0 | 31980 / 0 / 0 |
| flythrough | 186.294 | 26.272 | 0.0 | 0 | 0 | 841 (0.036 / 0.043 / 5.955; 0) | 44 | 25336 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1680 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.008 / 0.008; 0) | 32 | 1192 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.121 / 0.162 / 3.181; 0) | 180 | 3570 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 627 | 0 (None / None / None; 0) | 0 | 836 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 654 | 0 (None / None / None; 0) | 0 | 1526 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1936 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2256 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 352.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.043 (0.118; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.61 | 1.0 (0.0, 0.0) | 1.588 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.054; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.126 (0.297; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.066 (0.117; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 50.342 | 10.0 (9.0, 2.364) | 6.0 (6.0, 2.279) | 0.058 (0.325; 0) | 0 | 2767 / 1498184 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.231 | 1.0 (0.0, 0.0) | 0.78 (0.0, 0.0) | 0.001 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.477 | 1.0 (0.0, 0.0) | 0.748 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 149.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.054; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 268.0 / 350.0 (23.4) | 268.0 / 82.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4182 / 0 |
| flythrough | two-phase | 310.76 / 399.86 (22.3) | 303.76 / 96.1 / 6.99 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 2997 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 9048 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 33401 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10125 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 48.0 (45.8) | 26.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion_move | two-phase | 22.38 / 50.29 (55.5) | 22.33 / 27.97 / 0.05 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4155 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.85 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3162 / 0 |
| translucent_move | two-phase | 15.66 / 135.1 (88.4) | 15.64 / 119.46 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15180 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4524 / 0 |
| translucent_move_oit | two-phase | 15.66 / 134.78 (88.4) | 15.62 / 119.16 / 0.04 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6427 / 0 |
| flat_plants | two-phase | 9.0 / 149.0 (94.0) | 9.0 / 140.0 / 0.0 | 1.0 | 0.0 (0.0, 0.18; 100.0) | 14400.0 | 16800 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14241 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 894 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.618 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 102.035 / 0.941 | 0.029 / 0.011 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.045 / 0.0 | 0.016 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.838 |
| water_glass | 114.699 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.673 / 54.602 | 0.016 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.485 | 0.981 / 0.868 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.137 / 8.471 | 0.068 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 94.07 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 114.094 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.681 / 14.624 | 0.006 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.4 / 53.402 | 0.013 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.89 / 13.748 | 0.006 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 112.957 / 7.536 | 0.881 / 0.752 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.4 / 1.37 | 0.01 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 81.129 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.01 / 0.051 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.002 / 0.006 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
siftec/quicksilver-full: bench kinetics_instancing: median meshing time 1.175 ms per section against vanilla's compiler 0.92 ms (1.277x; limit 0.92 ms; 128 pairs): reported, not gated (open gap)

siftec/quicksilver-full: bench factory_flat: median meshing time 0.297 ms per section against vanilla's compiler 0.293 ms (1.014x; limit 0.322 ms; 597 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench factory_flat: median meshing time 0.488 ms per section against vanilla's compiler 0.432 ms (1.13x; limit 0.475 ms; 605 pairs): reported, not gated (open gap)

siftec/quicksilver-old: bench kinetics_instancing: median meshing time 1.565 ms per section against vanilla's compiler 1.671 ms (0.937x; limit 1.671 ms; 153 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.315 ms per section against vanilla's compiler 0.3 ms (1.05x; limit 0.33 ms; 575 pairs): reported, not gated (open gap)

siftec/quicksilver-vk: bench kinetics_instancing: median meshing time 1.612 ms per section against vanilla's compiler 1.482 ms (1.088x; limit 1.482 ms; 144 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.864 ms per section against vanilla's compiler 0.663 ms (1.303x; limit 0.729 ms; 609 pairs): reported, not gated (open gap)

siftec/quicksilver-2p-old: bench kinetics_instancing: median meshing time 2.44 ms per section against vanilla's compiler 2.217 ms (1.101x; limit 2.217 ms; 136 pairs): reported, not gated (open gap)

- measure-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- full: 6 / 6
- old-gpu: 54 / 54
- vulkan: 0 / 0
- old-gpu-2p: 54 / 54

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % | old-GPU two-phase % |
|---|---|---|---|---|---|---|
| factory | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| factory_flat | 0.0 | 0.3 | 0.0034 | 0.0034 | 0.0034 | 0.0 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 | 0.0068 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0011 | 0.55 | 0.0054 | 0.0062 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | 0.0059 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| kinetics | 0.0109 | 0.25 | 0.0068 | 0.0226 | 0.0104 | 0.0226 |
| kinetics_instancing | 0.0114 | 0.25 | 0.0081 | 0.0133 | 0.0102 | 0.0098 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| factory | 95.6 | 370 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) | 55 (536) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| mam | 87.02 | 10 | 0 (0) | 0 (0) | 0 (27) | 0 (0) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 36 (4277) | 38 (4278) | None (None) | 35 (4275) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| kinetics | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |
| kinetics_instancing | 95.36 | 30 | 8 (855) | 8 (855) | 7 (892) | 9 (857) |

Strict picture where the vanilla runs drawing the same way agree (package 5, Create scenes: Flywheel on in vanilla a and b, off in vanilla old and Vulkan), same strict limits:

| scene | runs | vanilla runs | agree on % of pixels | strict pixels |
|---|---|---|---|---|
| kinetics | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 7, old-gpu-2p 8 |
| kinetics | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 2, vulkan 2, old-gpu-2p 2 |
| kinetics_instancing | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics_instancing | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics_instancing | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 8, old-gpu-2p 11 |
| kinetics_instancing | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 0, old-gpu-2p 0 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| factory_flat | 0.0 / 0 | 0.0034 / 0 | 0.0034 / 0 | 0.0034 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0016 / 9 | 0.0027 / 14 | skipped | 0.0027 / 14 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| kinetics | 0.0078 / 0 | 0.0178 / 0 | 0.0095 / 0 | 0.0178 / 0 |
| kinetics_instancing | 0.0021 / 0 | 0.0154 / 0 | 0.0111 / 0 | 0.0154 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.67 (base 12.22) | 15 (base 15) | 6004 (base 6976) | 365.17 (base 361.48) | 3.73 (base 5.48) |
| factory_flat | 12.67 (reported, not gated) | 15 (base 15) | 6004 (base 6844) | 360.86 (base 360.51) | 3.48 (base 5.48) |
| sift | 21.31 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 383.7 (base 379.72) | 3.73 (base 5.87) |
| hub | 21.54 (base 21.53) | 16 (base 16) | 65656 (base 66576) | 396.12 (base 392.33) | 3.73 (base 5.48) |
| mam | 22.53 (base 22.53) | 19 (base 19) | 22088 (base 23748) | 409.75 (base 405.55) | 7.73 (base 8.12) |
| ponder | 88.25 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 408.3 (base 404.14) | 7.73 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 17 (base 17) | 43120 (base 44728) | 394.75 (base 392.95) | 7.54 (base 8.24) |
| create_ct | 7.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 395.79 (base 394.1) | 7.54 (base 10.24) |
| kinetics | 8.67 (base 8.67) | 13 (base 13) | 7692 (base 7692) | 394.41 (base 395.42) | 7.54 (base 8.06) |
| kinetics_instancing | 7.67 (base 7.67) | 13 (base 13) | 7792 (base 7792) | 360.74 (base 360.23) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.67 / 13 (29.81) | 106.36 / 152 (29.32) | median and average, at most vanilla |
| factory_flat | 12.67 / 13 (29.94) | 106.43 / 152 (29.55) | median and average, at most vanilla |
| sift | 21.31 / 24 (26.39) | 153.0 / 153 (14.81) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.96) | 115.43 / 161 (29.75) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.99) | 119.37 / 162 (28.87) | median, x 1.10 + 2 |
| ponder | 88.25 / 88 (29.98) | 180.88 / 227 (29.92) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.98) | 117.24 / 164 (29.89) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.98) | 100.08 / 147 (29.96) | median and average, x 1.10 + 2 |
| kinetics | 8.67 / 9 (29.95) | 102.28 / 148 (29.49) | median and average, at most vanilla |
| kinetics_instancing | 7.67 / 8 (30.01) | 100.92 / 148 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.211 | 32.0 / 20.211 | 0.0 / 0.0 | 416.0 / 33.877 |
| ponder | 32.0 / 17.514 | 32.0 / 17.514 | 0.0 / 0.0 | 416.0 / 29.178 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.511 (26447.819) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 4 / 7 | 0.0 / 0 |
| factory_flat | 13583.408 (26447.615) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 3 / 1 | 0.0 / 0 |
| sift | 115647.028 (157949.146) | 26.782 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 10 / 296 | 0.0 / 0 |
| hub | 474.793 (783.308) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 2 / 4 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 303100 / 304740 | 0 (2097152.0) | 2 / 11 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61248 | 0 (2097152.0) | 2 / 2 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 46012 / 45288 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 2 / 2 | 0.0 / 0 |
| kinetics | 5437.077 (10385.338) | 47.647 | 1.0 | 7692 / 7792 | 0 (2097152.0) | 3 / 5 | 0.0 / 0 |
| kinetics_instancing | 6068.114 (11697.496) | 48.125 | 1.0 | 7792 / 7792 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.094 (35) | 4.194 (35) | 0.499 | 1.982 (12) | 0 | 770 / 0 | 5.929 / 7.198 | 2.031 / 2.697 |
| factory_flat | 1.325 (68) | 1.896 (69) | 0.699 | 1.264 (13) | 0 | 597 / 0 | 1.268 / 1.295 | 0.297 / 0.293 |
| sift | 0.828 (41) | 1.697 (41) | 0.488 | None (0) | 0 | 1311 / 0 | 4.118 / 5.04 | 1.162 / 1.621 |
| hub | 0.23 (8) | 0.264 (8) | 0.871 | None (0) | 0 | 1363 / 0 | 4.049 / 4.97 | 1.148 / 1.603 |
| mam | 0.256 (4) | 0.377 (4) | 0.679 | None (0) | 0 | 1677 / 0 | 3.814 / 4.832 | 1.257 / 1.858 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1678 / 0 | 3.812 / 4.829 | 1.256 / 1.855 |
| hologram | 0.446 (25) | 1.087 (13) | 0.41 | None (0) | 0 | 1711 / 0 | 3.775 / 4.767 | 1.257 / 1.812 |
| create_ct | 0.37 (46) | 0.789 (55) | 0.469 | None (0) | 0 | 1767 / 0 | 3.677 / 4.643 | 1.2 / 1.704 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1861 / 0 | 3.549 / 4.452 | 1.14 / 1.586 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 128 / 0 | 3.979 / 4.89 | 1.175 / 0.92 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 25.262 / 0.236 | 1.511 / 28.0 | 2.566 | 1551 / 0 | 1.982 (2.181) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 2.716 / 0.025 | 1.511 / 8.0 | 2.566 | 799 / 0 | 1.264 (1.501) |
| sift | indirect, one multi-draw per arena and layer | 3.006 | 320.607 | 16 (vanilla 28) | 462608 | 23.054 / 0.281 | 7.389 / 16.0 | 12.353 | 2558 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.398 / 0.272 | 1.879 / 12.0 | 3.137 | 2639 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1187460 | 23.254 / 0.313 | 20.211 / 32.0 | 31.709 | 3290 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1016684 | 23.254 / 0.313 | 17.514 / 32.0 | 27.148 | 3291 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.053 / 0.308 | 0.238 / 32.0 | 0.367 | 3355 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.654 / 0.303 | 0.171 / 32.0 | 0.283 | 3452 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 22.636 / 0.321 | 0.372 / 32.0 | 0.624 | 3564 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 27.045 | 16 (vanilla 28) | 23356 | 6.599 / 0.279 | 0.372 / 8.0 | 0.624 | 154 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 3168 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.041; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.002 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.003 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6258 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6258 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 9108 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5066 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7800 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 745 / 0 |
| kinetics_instancing | still | 23.0 / 23.0 (0.0) | 23.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.685 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.755 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 7.552 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.882 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 96.811 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.568 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 147.955 / 89.85 | 0.1 / 0.036 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 94.601 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.88 | 0.0 / 0.0 | 574.47 / 574.85 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| mam | 13.87 / 13.87 | 1.0 / 1.0 | 113.36 / 113.46 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| ponder | 82.58 / 82.57 | 0.0 / 0.11 | 203.86 / 203.75 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 15.93 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.91 (base 361.53) | 5.48 (base 5.48) |
| factory_flat | 15.95 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.82 (base 360.27) | 3.48 (base 5.48) |
| sift | 36.59 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 385.1 (base 379.69) | 5.48 (base 4.24) |
| hub | 20.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.44 (base 392.07) | 5.48 (base 5.99) |
| mam | 21.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 411.22 (base 404.98) | 5.48 (base 7.73) |
| ponder | 87.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.68 (base 403.64) | 5.48 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42756 (base 43652) | 396.44 (base 392.54) | 5.29 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.53 (base 393.74) | 5.29 (base 8.24) |
| kinetics | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.72 (base 396.01) | 5.29 (base 8.06) |
| kinetics_instancing | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 359.82 (base 360.95) | 5.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 15.93 / 16 (29.89) | 179.79 / 226 (29.57) | median and average, at most vanilla |
| factory_flat | 15.95 / 16 (30.01) | 179.16 / 226 (29.86) | median and average, at most vanilla |
| sift | 36.59 / 37 (19.92) | 579.0 / 579 (14.37) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (30.0) | 163.05 / 208 (29.51) | median and average, x 1.10 + 2 |
| mam | 21.54 / 21 (29.91) | 202.22 / 246 (29.09) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.99) | 180.74 / 227 (29.94) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.96) | 128.87 / 175 (29.63) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 110.92 / 158 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 10.67 / 11 (29.99) | 127.16 / 174 (29.94) | median and average, at most vanilla |
| kinetics_instancing | 10.67 / 11 (30.01) | 126.92 / 174 (29.98) | median and average, at most vanilla |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.254 | 32.0 / 20.254 | 0.0 / 0.0 | 416.0 / 33.964 |
| ponder | 32.0 / 17.552 | 32.0 / 17.552 | 0.0 / 0.0 | 416.0 / 29.217 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.499 | 8.0 / 0.499 | 0.0 / 0.0 | 256.0 / 0.923 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14349.95 (27750.732) | 48.29 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 2 / 5 | 0.0 / 0 |
| factory_flat | 14412.274 (27856.634) | 48.263 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 0 / 2 | 0.0 / 0 |
| sift | 115667.894 (158046.106) | 26.814 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 98 / 287 | 0.0 / 0 |
| hub | 474.791 (783.306) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 1 / 9 | 0.0 / 0 |
| mam | 568.951 (925.548) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 3 / 7 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61212 / 61204 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 44884 / 45140 | 0 (2097152.0) | 1 / 6 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.318 (35) | 4.252 (35) | 0.78 | 3.056 (12) | 0 | 977 / 0 | 7.425 / 10.092 | 3.162 / 5.601 |
| factory_flat | 1.657 (68) | 1.659 (68) | 0.999 | 1.745 (13) | 0 | 605 / 0 | 1.947 / 1.683 | 0.488 / 0.432 |
| sift | 1.302 (41) | 1.709 (41) | 0.762 | None (0) | 0 | 1518 / 0 | 5.499 / 7.457 | 2.004 / 3.265 |
| hub | 0.306 (8) | 0.283 (8) | 1.081 | None (0) | 0 | 1572 / 0 | 5.406 / 7.329 | 1.964 / 3.209 |
| mam | 0.456 (4) | 0.429 (4) | 1.063 | None (0) | 0 | 1887 / 0 | 5.676 / 7.855 | 2.322 / 3.82 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1888 / 0 | 5.674 / 7.851 | 2.322 / 3.81 |
| hologram | 1.337 (25) | 1.752 (19) | 0.763 | None (0) | 0 | 1921 / 0 | 5.645 / 7.796 | 2.315 / 3.776 |
| create_ct | 0.555 (60) | 0.913 (58) | 0.608 | None (0) | 0 | 1977 / 0 | 5.538 / 7.618 | 2.206 / 3.539 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 2072 / 0 | 5.348 / 7.33 | 2.02 / 3.326 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 153 / 0 | 5.636 / 5.819 | 1.565 / 1.671 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.247 | 34.582 | 16 (vanilla 28) | 96100 | 26.956 / 0.285 | 1.511 / 28.0 | 2.566 | 2099 / 0 | 3.056 (8.53) |
| factory_flat | plain, one multi-draw per region and layer | 4.267 | 34.788 | 16 (vanilla 28) | 96100 | 2.759 / 0.024 | 1.511 / 8.0 | 2.566 | 815 / 0 | 1.745 (3.78) |
| sift | plain, one multi-draw per region and layer | 17.043 | 320.804 | 16 (vanilla 28) | 462608 | 24.768 / 0.314 | 7.389 / 16.0 | 12.353 | 3106 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 24.105 / 0.305 | 1.879 / 12.0 | 3.137 | 3191 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1189460 | 24.527 / 0.333 | 20.254 / 32.0 | 31.762 | 3845 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1018348 | 24.527 / 0.333 | 17.552 / 32.0 | 27.193 | 3846 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 24.335 / 0.328 | 0.238 / 32.0 | 0.367 | 3910 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.913 / 0.323 | 0.171 / 32.0 | 0.283 | 4018 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 23.874 / 0.338 | 0.372 / 32.0 | 0.624 | 4131 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 31372 | 6.096 / 0.309 | 0.499 / 8.0 | 0.838 | 171 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2394 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.058; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.007; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.52 / 69.0 (57.2) | 29.52 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.48 | 5796 / 0 |
| factory_flat | still | 29.73 / 69.0 (56.9) | 29.73 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.0 | 5754 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6831 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5100 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7748 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 745 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 745 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.122 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.49 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 9.623 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.518 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 95.663 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 94.199 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 143.279 / 87.664 | 0.123 / 0.044 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.86 | 0.0 / 0.0 | 574.66 / 574.3 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.86 (8.0 / 8.0) |
| mam | 13.88 / 13.88 | 1.0 / 1.0 | 113.63 / 113.65 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.88 / 13.88 (8.0 / 8.0) |
| ponder | 82.57 / 82.58 | 0.11 / 0.11 | 203.78 / 203.88 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 13.69 (base 14.25) | 15 (base 15) | 50660 (base 51624) | 365.15 (base 360.8) | 5.46 (base 5.46) |
| factory_flat | 13.69 (reported, not gated) | 15 (base 15) | 50660 (base 51500) | 359.35 (base 359.9) | 3.46 (base 3.46) |
| sift | 20.69 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 383.87 (base 379.18) | 5.46 (base 5.46) |
| hub | 20.54 (base 21.57) | 16 (base 16) | 65656 (base 66576) | 396.31 (base 391.05) | 5.46 (base 5.46) |
| mam | 21.54 (base 22.55) | 19 (base 19) | 22088 (base 23748) | 410.44 (base 404.61) | 5.46 (base 7.71) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 405.98 (base 403.47) | 5.46 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 399.56 (base 395.99) | 5.27 (base 8.29) |
| kinetics | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 398.52 (base 398.76) | 5.27 (base 8.04) |
| kinetics_instancing | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 360.13 (base 359.57) | 5.46 (base 5.46) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 13.69 / 14 (30.0) | 108.2 / 154 (29.44) | median and average, at most vanilla |
| factory_flat | 13.69 / 14 (30.0) | 108.52 / 154 (29.45) | median and average, at most vanilla |
| sift | 20.69 / 23 (25.04) | 153.0 / 153 (13.28) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (29.99) | 116.32 / 161 (29.44) | median and average, x 1.10 + 2 |
| mam | 21.54 / 21 (29.99) | 121.73 / 162 (28.03) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.99) | 181.67 / 227 (29.52) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (30.0) | 100.24 / 147 (29.89) | median and average, x 1.10 + 2 |
| kinetics | 8.67 / 9 (30.0) | 102.24 / 149 (29.89) | median and average, at most vanilla |
| kinetics_instancing | 8.67 / 9 (30.0) | 101.84 / 149 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.301 | 32.0 / 20.301 | 0.0 / 0.0 | 416.0 / 33.331 |
| ponder | 32.0 / 17.605 | 32.0 / 17.605 | 0.0 / 0.0 | 416.0 / 28.632 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14603.699 (28182.09) | 48.181 | 1.0 | 152336 / 228124 | 100928 (2097152.0) | 0 / 6 | 0.0 / 0 |
| factory_flat | 14688.668 (28326.518) | 48.145 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 0 / 1 | 0.0 / 0 |
| sift | 115658.395 (157964.671) | 26.782 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 22 / 265 | 0.0 / 0 |
| hub | 474.79 (783.303) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 0 / 4 | 0.0 / 0 |
| mam | 568.947 (925.54) | 38.528 | 1.25 | 41048 / 42688 | 0 (2097152.0) | 3 / 25 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61248 | 0 (2097152.0) | 2 / 10 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 1.682 (35) | 3.116 (35) | 0.54 | 1.652 (12) | 0 | 974 / 0 | 4.591 / 6.383 | 1.742 / 2.557 |
| factory_flat | 1.531 (35) | 1.526 (46) | 1.003 | 1.326 (13) | 0 | 575 / 0 | 1.251 / 1.199 | 0.315 / 0.3 |
| sift | 0.69 (41) | 1.436 (41) | 0.481 | None (0) | 0 | 1514 / 0 | 3.459 / 4.847 | 1.198 / 1.891 |
| hub | 0.288 (8) | 0.285 (8) | 1.011 | None (0) | 0 | 1573 / 0 | 3.418 / 4.792 | 1.182 / 1.877 |
| mam | 0.338 (4) | 0.421 (4) | 0.803 | None (0) | 0 | 1890 / 0 | 3.443 / 4.859 | 1.272 / 2.043 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1891 / 0 | 3.441 / 4.856 | 1.272 / 2.043 |
| create_ct | 0.543 (48) | 1.12 (48) | 0.485 | None (0) | 0 | 1947 / 0 | 3.391 / 4.767 | 1.257 / 1.976 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 2042 / 0 | 3.311 / 4.587 | 1.222 / 1.88 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 144 / 0 | 4.295 / 4.504 | 1.612 / 1.482 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 35.419 | 16 (vanilla 28) | 96100 | 26.658 / 0.343 | 1.511 / 28.0 | 2.566 | 2067 / 0 | 1.652 (2.285) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 35.699 | 16 (vanilla 28) | 96084 | 2.298 / 0.034 | 1.511 / 8.0 | 2.566 | 689 / 0 | 1.326 (1.508) |
| sift | indirect, one multi-draw per arena and layer | 3.006 | 320.639 | 16 (vanilla 28) | 462608 | 24.481 / 0.362 | 7.389 / 16.0 | 12.353 | 3073 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 23.723 / 0.349 | 1.879 / 12.0 | 3.137 | 3167 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1192324 | 24.272 / 0.371 | 20.301 / 32.0 | 31.838 | 3823 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1021548 | 24.272 / 0.371 | 17.605 / 32.0 | 27.278 | 3824 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.888 / 0.366 | 0.171 / 32.0 | 0.283 | 3920 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 23.848 / 0.381 | 0.372 / 32.0 | 0.624 | 4033 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 5.811 / 0.197 | 0.372 / 8.0 | 0.624 | 184 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 3012 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.041; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.119; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 30.36 / 69.0 (56.0) | 30.36 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.0 | 5754 / 0 |
| factory_flat | still | 30.64 / 69.0 (55.6) | 30.64 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.0 | 5754 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 8625 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5100 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7800 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.524 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.839 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 7.904 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.762 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 99.146 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 94.441 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.178 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.88 | 0.0 / 0.0 | 574.48 / 575.05 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| mam | 13.87 / 13.88 | 1.0 / 1.0 | 113.48 / 113.53 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| ponder | 82.58 / 82.56 | 0.0 / 0.0 | 203.73 / 203.3 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.59 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.67 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.06 (base 361.53) | 5.48 (base 5.48) |
| factory_flat | 16.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.1 (base 360.27) | 3.48 (base 5.48) |
| sift | 38.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.52 (base 379.69) | 5.48 (base 4.24) |
| hub | 21.53 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.87 (base 392.07) | 5.48 (base 5.99) |
| mam | 22.52 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.4 (base 404.98) | 5.48 (base 7.73) |
| ponder | 88.26 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.13 (base 403.64) | 5.48 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43336 (base 43652) | 396.15 (base 392.54) | 5.29 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.36 (base 393.74) | 5.29 (base 8.24) |
| kinetics | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.28 (base 396.01) | 5.29 (base 8.06) |
| kinetics_instancing | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 359.84 (base 360.95) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 16.67 / 17 (29.7) | 179.79 / 226 (29.57) | median and average, at most vanilla |
| factory_flat | 16.67 / 17 (29.69) | 179.16 / 226 (29.86) | median and average, at most vanilla |
| sift | 38.0 / 38 (15.65) | 579.0 / 579 (14.37) | median, x 1.10 + 2 |
| hub | 21.53 / 21 (29.51) | 163.05 / 208 (29.51) | median and average, x 1.10 + 2 |
| mam | 22.52 / 22 (29.03) | 202.22 / 246 (29.09) | median, x 1.10 + 2 |
| ponder | 88.26 / 88 (29.77) | 180.74 / 227 (29.94) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.95) | 128.87 / 175 (29.63) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.95) | 110.92 / 158 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 11.67 / 12 (29.98) | 127.16 / 174 (29.94) | median and average, at most vanilla |
| kinetics_instancing | 11.67 / 12 (30.01) | 126.92 / 174 (29.98) | median and average, at most vanilla |

Terrain GPU memory, siftec old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.919 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.243 | 32.0 / 20.243 | 0.0 / 0.0 | 416.0 / 33.964 |
| ponder | 32.0 / 17.546 | 32.0 / 17.546 | 0.0 / 0.0 | 416.0 / 29.217 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.74 | 8.0 / 0.74 | 0.0 / 0.0 | 256.0 / 0.923 |


Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.633 (26448.057) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 6 / 5 | 0.0 / 0 |
| factory_flat | 13583.465 (26447.721) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 3 / 2 | 0.0 / 0 |
| sift | 115747.801 (158155.288) | 26.814 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 312 / 287 | 0.0 / 0 |
| hub | 474.805 (783.328) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 9 / 9 | 0.0 / 0 |
| mam | 568.979 (925.593) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 20 / 7 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 2 / 1 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 46564 / 45140 | 0 (2097152.0) | 1 / 6 | 0.0 / 0 |
| create_ct | 2538.237 (5312.87) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| kinetics | 5437.047 (10385.28) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.966 (35) | 4.252 (35) | 0.933 | 4.79 (12) | 0 | 903 / 0 | 9.875 / 12.787 | 5.455 / 7.306 |
| factory_flat | 2.39 (69) | 1.659 (68) | 1.441 | 2.356 (13) | 0 | 609 / 0 | 2.786 / 2.381 | 0.864 / 0.663 |
| sift | 1.546 (41) | 1.709 (41) | 0.905 | None (0) | 0 | 1446 / 0 | 7.549 / 9.835 | 3.385 / 5.064 |
| hub | 0.454 (8) | 0.283 (8) | 1.604 | None (0) | 0 | 1500 / 0 | 7.474 / 9.728 | 3.369 / 4.969 |
| mam | 0.926 (4) | 0.429 (4) | 2.159 | None (0) | 0 | 1813 / 0 | 7.215 / 9.989 | 3.515 / 5.774 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1814 / 0 | 7.211 / 9.984 | 3.514 / 5.773 |
| hologram | 1.71 (19) | 1.752 (19) | 0.976 | None (0) | 0 | 1841 / 0 | 7.138 / 9.879 | 3.459 / 5.678 |
| create_ct | 0.831 (41) | 0.913 (58) | 0.91 | None (0) | 0 | 1897 / 0 | 6.987 / 9.646 | 3.368 / 5.489 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1992 / 0 | 6.736 / 9.275 | 3.096 / 5.018 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 136 / 0 | 8.008 / 8.521 | 2.44 / 2.217 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 24.176 / 0.263 | 1.511 / 28.0 | 2.566 | 1864 / 0 | 4.79 (10.531) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96084 | 2.785 / 0.024 | 1.511 / 8.0 | 2.566 | 825 / 0 | 2.356 (3.277) |
| sift | plain, one multi-draw per region and layer | 17.054 | 321.026 | 16 (vanilla 28) | 462608 | 22.381 / 0.298 | 7.389 / 16.0 | 12.353 | 2872 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 21.713 / 0.288 | 1.879 / 12.0 | 3.137 | 2957 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1188660 | 22.659 / 0.323 | 20.243 / 32.0 | 31.741 | 3607 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1017884 | 22.659 / 0.323 | 17.546 / 32.0 | 27.18 | 3608 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 22.515 / 0.319 | 0.238 / 32.0 | 0.367 | 3666 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.133 / 0.314 | 0.171 / 32.0 | 0.283 | 3767 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.124 / 0.33 | 0.372 / 32.0 | 0.624 | 3880 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 47160 | 6.574 / 0.34 | 0.74 / 8.0 | 1.259 | 153 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1878 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 590 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 581 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.007; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6258 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6216 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5382 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4998 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7540 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |
| kinetics_instancing | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 750 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.122 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.49 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.518 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 95.663 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 94.199 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 152.803 / 93.998 | 0.144 / 0.043 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.86 / 13.86 | 0.0 / 0.0 | 574.18 / 574.3 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| mam | 13.84 / 13.88 | 1.0 / 1.0 | 112.43 / 113.65 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.84 / 13.88 (8.0 / 8.0) |
| ponder | 82.59 / 82.58 | 0.11 / 0.11 | 203.96 / 203.88 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.62 / 81.61 (75.0 / 75.0) |
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
| quicksilver-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | 24 | 599 / 598 |
| quicksilver-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| quicksilver-vk | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 600 |
| measure-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| measure-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| measure-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 8.82 | 131.65 | 176 | 125 | 1034996 | [] |
| bench-plain | flythrough | 5.36 | 329.03 | 107 | 123 | 7973456 | [] |
| bench-plain | water_glass | 15.96 | 67.88 | 319 | 124 | 16920 | [] |
| bench-plain | nether | 15.53 | 75.97 | 310 | 121 | 464116 | [] |
| bench-sodium | spawn | 9.86 | 162.22 | 197 | 148 | 9040 | [] |
| bench-sodium | flythrough | 7.46 | 365.04 | 149 | 159 | 267800 | [] |
| bench-sodium | water_glass | 19.14 | 61.63 | 365 | 135 | 15584 | [] |
| bench-sodium | nether | 26.38 | 46.07 | 2 | 129 | 264224 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 52.494 (50.0) | 749 / 749 | 1766 | 1 | 40438.943 | 13.993 (0.0) | 1355 |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-sodium | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-bench-sodium | nether | 4.06 | 4.06 (0) | 4.06 |  |
| core-bench-sodium | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-full | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-full | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-measure-old | flat_plants | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-vk | spawn | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | water_glass | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | nether | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | mobs | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | outline | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | occlusion | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | occlusion_move | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | occlusion_corner | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | translucent_move | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | particles | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | animation | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | animated_items | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
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
| core-quicksilver-2p-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-2p-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-full | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
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
| core-sp-quicksilver | flythrough | 1.44 | 1.52 (93) | 1.52 |  |
| siftec-measure-full | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | mam | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | ponder | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-measure-full | hologram | 3.54 | 3.54 (0) | 3.54 |  |
| siftec-measure-full | create_ct | 3.54 | 3.54 (0) | 3.54 |  |
| siftec-measure-full | kinetics | 3.54 | 3.54 (0) | 3.54 |  |
| siftec-measure-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-full | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | mam | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | ponder | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-vk | factory | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | sift | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | hub | 3.71 | 3.71 (0) | 3.71 |  |
| siftec-measure-vk | mam | 7.71 | 7.71 (0) | 7.71 | between scenes +4.00 |
| siftec-measure-vk | ponder | 7.71 | 7.71 (0) | 7.71 |  |
| siftec-measure-vk | create_ct | 7.52 | 7.52 (0) | 7.52 |  |
| siftec-measure-vk | kinetics | 7.52 | 7.52 (0) | 7.52 |  |
| siftec-measure-vk | factory_flat | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | kinetics_instancing | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-2p-old | factory | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | sift | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | hub | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | mam | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | ponder | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | hologram | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-2p-old | create_ct | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-2p-old | kinetics | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-2p-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-2p-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-full | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-full | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-full | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-full | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-full | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-full | kinetics | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-full | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | sift | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | hub | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | mam | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | ponder | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | hologram | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-old | create_ct | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-old | kinetics | 5.29 | 5.29 (0) | 5.29 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | kinetics_instancing | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-vk | factory | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | sift | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | hub | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | mam | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | ponder | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-quicksilver-vk | create_ct | 5.27 | 5.27 (0) | 5.27 |  |
| siftec-quicksilver-vk | kinetics | 5.27 | 5.27 (0) | 5.27 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-vk | kinetics_instancing | 5.46 | 5.46 (0) | 5.46 |  |

Rises of 4 MB or more: core-quicksilver-vk/translucent_move: between scenes +4.00; siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-full/mam: between scenes +4.00

