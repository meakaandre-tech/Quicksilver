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
| spawn | 0.2196 | 10.05 | 0.214 | 0.0622 | 0.2028 | 0.2026 |
| flythrough | 0.0 | 14.95 | 0.0011 | 0.0011 | 0.0012 | 0.0011 |
| water_glass | 0.0047 | 6.45 | 0.0062 | 0.0031 | 0.0041 | 0.0034 |
| nether | 0.0 | 0.8 | 0.0003 | 0.0003 | 0.0003 | 0.002 |
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
| translucent_move | 0.0 | 0.3 | 0.0002 | 0.0001 | 0.0001 | 0.0 |
| translucent_move.x2404 | 0.0002 | 0.3 | 0.0002 | 0.0002 | 0.0002 | 0.0003 |
| translucent_move.x2414 | 0.0002 | 0.3 | 0.0003 | 0.0002 | 0.0005 | 0.0003 |
| translucent_move.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0001 | 0.0004 | 0.0002 |
| translucent_move.low | 0.0002 | 0.3 | 0.001 | 0.0012 | 0.002 | 0.0013 |
| translucent_move.back | 0.0 | 0.3 | 0.0 | 0.0002 | 0.0002 | 0.0003 |
| translucent_move.bare_back | 0.0002 | 0.3 | 0.0002 | 0.0 | 0.0002 | 0.0 |
| water_glass_oit | 0.0038 | 0.3 | 0.0055 | 0.0046 | 0.0052 | 0.0044 |
| translucent_move_oit | 0.0001 | 0.3 | 0.0001 | 0.0 | 0.0002 | 0.0 |
| translucent_move_oit.x2404 | 0.0 | 0.3 | 0.0003 | 0.0004 | 0.0005 | 0.0003 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.0002 | 0.0002 | 0.0004 | 0.0003 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0002 | 0.0001 | 0.0003 |
| translucent_move_oit.low | 0.0011 | 0.3 | 0.0018 | 0.0009 | 0.0011 | 0.002 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0001 | 0.0001 | 0.0 | 0.0001 |
| translucent_move_oit.bare_back | 0.0001 | 0.3 | 0.0001 | 0.0 | 0.0002 | 0.0 |
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
| spawn | 92.67 | 18057 | 249 (738) | 252 (745) | 251 (753) | 224 (707) |
| flythrough | 97.26 | 6020 | 47 (293) | 47 (293) | 51 (294) | 47 (293) |
| water_glass | 95.8 | 25508 | 26 (2627) | 18 (2618) | 20 (2734) | 21 (2622) |
| nether | 99.42 | 905 | 3 (458) | 3 (458) | 3 (470) | 18 (473) |
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
| translucent_move | 96.93 | 13 | 4 (79) | 1 (76) | 1 (68) | 3 (78) |
| translucent_move.x2404 | 95.93 | 15 | 10 (110) | 5 (105) | 3 (88) | 5 (105) |
| translucent_move.x2414 | 95.86 | 13 | 3 (106) | 1 (104) | 2 (99) | 3 (106) |
| translucent_move.x2424 | 96.74 | 13 | 1 (78) | 1 (78) | 5 (71) | 4 (81) |
| translucent_move.low | 96.11 | 41 | 13 (19) | 16 (21) | 13 (16) | 15 (20) |
| translucent_move.back | 96.93 | 13 | 1 (75) | 2 (76) | 5 (71) | 4 (78) |
| translucent_move.bare_back | 96.9 | 13 | 1 (76) | 3 (78) | 3 (70) | 1 (77) |
| water_glass_oit | 95.81 | 57 | 31 (2631) | 22 (2622) | 23 (2734) | 28 (2630) |
| translucent_move_oit | 96.93 | 12 | 3 (78) | 1 (76) | 1 (67) | 3 (79) |
| translucent_move_oit.x2404 | 95.93 | 16 | 6 (106) | 4 (104) | 6 (90) | 3 (103) |
| translucent_move_oit.x2414 | 95.86 | 10 | 6 (109) | 3 (106) | 2 (99) | 4 (107) |
| translucent_move_oit.x2424 | 96.74 | 15 | 1 (78) | 1 (78) | 1 (67) | 3 (81) |
| translucent_move_oit.low | 96.11 | 40 | 15 (20) | 12 (17) | 14 (16) | 25 (30) |
| translucent_move_oit.back | 96.93 | 12 | 2 (77) | 2 (77) | 2 (68) | 1 (76) |
| translucent_move_oit.bare_back | 96.9 | 15 | 1 (77) | 1 (76) | 1 (67) | 1 (76) |
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
| spawn | 0.4505 / 248 | 0.4402 / 242 | 0.2957 / 247 | 0.4402 / 242 |
| flythrough | 0.0 / 0 | 0.0 / 0 | 0.0003 / 3 | 0.0 / 0 |
| water_glass | 0.006 / 32 | 0.0027 / 16 | 0.0044 / 20 | 0.0027 / 16 |
| nether | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
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
| translucent_move | 0.0 / 0 | 0.0001 / 2 | 0.0004 / 3 | 0.0001 / 2 |
| translucent_move.x2404 | 0.0002 / 4 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| translucent_move.x2414 | 0.0001 / 1 | 0.0002 / 2 | 0.0002 / 2 | 0.0002 / 2 |
| translucent_move.x2424 | 0.0002 / 2 | 0.0 / 1 | 0.0002 / 0 | 0.0 / 1 |
| translucent_move.low | 0.0002 / 1 | 0.0004 / 3 | 0.0014 / 6 | 0.0004 / 3 |
| translucent_move.back | 0.0 / 0 | 0.0002 / 2 | 0.0 / 0 | 0.0002 / 2 |
| translucent_move.bare_back | 0.0003 / 2 | 0.0 / 0 | 0.0001 / 0 | 0.0 / 0 |
| water_glass_oit | 0.004 / 24 | 0.004 / 19 | 0.0041 / 16 | 0.004 / 19 |
| translucent_move_oit | 0.0 / 0 | 0.0 / 1 | 0.0002 / 0 | 0.0 / 1 |
| translucent_move_oit.x2404 | 0.0 / 1 | 0.0001 / 1 | 0.0001 / 2 | 0.0001 / 1 |
| translucent_move_oit.x2414 | 0.0001 / 1 | 0.0001 / 1 | 0.0002 / 0 | 0.0001 / 1 |
| translucent_move_oit.x2424 | 0.0001 / 0 | 0.0001 / 3 | 0.0 / 1 | 0.0001 / 3 |
| translucent_move_oit.low | 0.0011 / 3 | 0.0001 / 2 | 0.0004 / 5 | 0.0001 / 2 |
| translucent_move_oit.back | 0.0001 / 0 | 0.0001 / 1 | 0.0 / 0 | 0.0001 / 1 |
| translucent_move_oit.bare_back | 0.0001 / 1 | 0.0 / 0 | 0.0002 / 1 | 0.0 / 0 |
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
| spawn | 14.0 (base 13.6) | 14 (base 14) | 22540 (base 22476) | 254.45 (base 259.07) | 3.73 (base 3.99) |
| flythrough | 15.61 (reported, not gated) | 36 (reported, not gated) | 338884 (reported, not gated) | 310.19 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 9.8 (base 8.97) | 15 (base 15) | 11916 (base 15576) | 238.66 (base 250.02) | 3.73 (base 5.99) |
| nether | 13.98 (base 15.63) | 12 (base 12) | 10388 (base 19648) | 259.81 (base 273.53) | 3.73 (base 5.99) |
| mobs | 20.71 (base 19.77) | 17 (base 17) | 613580 (base 1010948) | 258.62 (base 268.37) | 3.73 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 258.48 (base 264.69) | 3.73 (base 5.48) |
| occlusion | 16.67 (base 15.67) | 15 (base 15) | 100052 (base 126320) | 263.95 (base 265.1) | 3.73 (base 4.24) |
| occlusion_move | 16.92 (reported, not gated) | 15 (reported, not gated) | 81944 (reported, not gated) | 264.66 (base 265.74) | 3.73 (base 4.24) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 269.06 (base 267.71) | 3.73 (base 5.48) |
| translucent_move | 8.91 (reported, not gated) | 15 (reported, not gated) | 5340 (reported, not gated) | 275.18 (base 267.48) | 3.73 (base 5.48) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 12140 (base 14688) | 237.14 (base 245.02) | 3.6 (base 3.73) |
| translucent_move_oit | 14.19 (reported, not gated) | 15 (reported, not gated) | 5584 (reported, not gated) | 239.95 (base 247.19) | 3.73 (base 3.73) |
| flat_plants | 17.1 (base 18.29) | 15 (base 15) | 4480 (base 9812) | 239.63 (base 246.92) | 3.48 (base 3.99) |
| renderer_off | 8.67 (base 7.67) | 14 (base 14) | 3612 (base 7164) | 233.47 (base 241.33) | 3.6 (base 4.12) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 266.34 (base 261.44) | 3.73 (base 5.99) |
| animation | 50 median (avg 40.95) (base 49) | 15 (base 15) | 2164 (base 2056) | 262.69 (base 260.68) | 3.73 (base 5.99) |
| animated_items | 61 median (avg 47.73) (base 60) | 23 (base 23) | 21856 (base 21940) | 237.54 (base 239.81) | 3.73 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.0 / 14 (10.93) | 124.24 / 124 (11.55) | median and average, x 1.10 + 2 |
| flythrough | 15.61 / 16 (8.6) | 123.06 / 123 (8.31) | median and average, at most vanilla + 2 |
| water_glass | 9.8 / 10 (24.76) | 119.23 / 124 (20.67) | median, at most vanilla |
| nether | 13.98 / 17 (24.42) | 113.44 / 121 (21.1) | median, x 1.10 + 2 |
| mobs | 20.71 / 21 (28.09) | 100.65 / 134 (28.04) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 87.2 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 16.67 / 17 (30.0) | 94.33 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 16.92 / 18 (29.92) | 94.27 / 133 (29.99) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (29.99) | 82.33 / 121 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 8.91 / 9 (26.41) | 113.43 / 124 (21.97) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (12.08) | 129.0 / 129 (11.27) | median, at most vanilla |
| translucent_move_oit | 14.19 / 14 (12.44) | 129.0 / 129 (10.82) | median and average, at most vanilla |
| flat_plants | 17.1 / 20 (26.31) | 110.59 / 124 (22.6) | median, x 1.10 + 2 |
| renderer_off | 8.67 / 9 (29.87) | 84.27 / 123 (29.99) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.01) | 86.27 / 125 (30.01) | median and average, x 1.10 + 2 |
| animation | 40.95 / 50 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.895 | 36.0 / 22.895 | 0.0 / 0.0 | 416.0 / 37.903 |
| flythrough | 112.0 / 85.541 | 112.0 / 85.541 | 0.0 / 0.0 | 416.0 / 149.634 |
| water_glass | 36.0 / 12.543 | 36.0 / 12.543 | 0.0 / 0.0 | 416.0 / 21.777 |
| nether | 20.0 / 15.242 | 20.0 / 15.242 | 0.0 / 0.0 | 256.0 / 26.683 |
| mobs | 16.0 / 9.703 | 16.0 / 9.703 | 0.0 / 0.0 | 256.0 / 16.975 |
| outline | 16.0 / 1.225 | 16.0 / 1.225 | 0.0 / 0.0 | 256.0 / 2.153 |
| occlusion | 20.0 / 2.478 | 20.0 / 2.478 | 0.0 / 0.0 | 416.0 / 4.475 |
| occlusion_move | 20.0 / 3.32 | 20.0 / 3.32 | 0.0 / 0.0 | 416.0 / 5.823 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.96 | 28.0 / 12.96 | 0.0 / 0.0 | 416.0 / 22.56 |
| water_glass_oit | 20.0 / 12.543 | 20.0 / 12.543 | 0.0 / 0.0 | 416.0 / 21.777 |
| translucent_move_oit | 28.0 / 12.549 | 28.0 / 12.549 | 0.0 / 0.0 | 416.0 / 21.844 |
| flat_plants | 24.0 / 13.967 | 24.0 / 13.967 | 0.0 / 0.0 | 416.0 / 23.937 |
| renderer_off | 24.0 / 8.662 | 24.0 / 8.662 | 0.0 / 0.0 | 416.0 / 15.275 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 437646.266 (591583.174) | 26.021 | 1.193 | 362508 / 882432 | 339968 (2097152.0) | 218 / 231 | 0.0 / 0 |
| flythrough | 493680.222 (778610.316) | 36.595 | 1.085 | 2310896 / 8547728 | 2088544 (2097152.0) | 171 / 166 | 7.343 / 55 |
| water_glass | 113218.263 (197618.424) | 42.709 | 1.124 | 14044 / 17032 | 0 (2097152.0) | 46 / 57 | 0.0 / 0 |
| nether | 29504.336 (42404.717) | 30.422 | 2.0 | 221288 / 516140 | 208576 (2097152.0) | 122 / 76 | 0.0 / 0 |
| mobs | 62853.641 (112447.73) | 44.104 | 0.967 | 613580 / 616260 | 0 (2097152.0) | 14 / 1 | 0.0 / 0 |
| outline | 1057.757 (2295.814) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27346.524 (47758.544) | 42.74 | 1.302 | 198712 / 385624 | 98752 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 21084.054 (36867.639) | 42.811 | 1.274 | 673664 / 1112900 | 597504 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_corner | 21836.838 (47193.169) | 53.729 | 1.214 | 35488 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21615.621 (27651.22) | 21.828 | 1.003 | 761208 / 1333048 | 755968 (2097152.0) | 131 / 16 | 0.0 / 0 |
| water_glass_oit | 113458.838 (198038.34) | 42.709 | 1.124 | 14380 / 16696 | 0 (2097152.0) | 241 / 225 | 0.0 / 0 |
| translucent_move_oit | 21736.411 (27841.669) | 21.928 | 1.003 | 727272 / 1274288 | 722688 (2097152.0) | 248 / 216 | 0.0 / 0 |
| flat_plants | 9101.27 (12477.677) | 27.06 | 1.045 | 266512 / 271600 | 0 (2097152.0) | 132 / 4 | 0.0 / 0 |
| renderer_off | 20155.649 (38175.732) | 47.203 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 20 / 0 | 0.0 / 0 |
| particles | 1698.827 (3676.117) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86680 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79492 / 122908 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.691 (104) | 2.212 (105) | 1.217 | 2.739 (54) | 0 | 879 / 0 | 6.797 / 9.027 | 2.885 / 4.639 |
| flythrough | 4.071 (1692) | 3.888 (1670) | 1.047 | 4.073 (1690) | 0 | 1394 / 0 | 5.372 / 7.347 | 3.277 / 5.294 |
| water_glass | 2.027 (17) | 0.927 (14) | 2.187 | None (0) | 0 | 1202 / 0 | 6.043 / 7.91 | 2.717 / 3.922 |
| nether | 1.832 (24) | 1.93 (26) | 0.949 | 1.735 (16) | 0 | 1838 / 0 | 4.843 / 6.393 | 2.148 / 3.084 |
| mobs | 0.759 (6) | 0.442 (13) | 1.717 | None (0) | 0 | 2074 / 0 | 4.616 / 6.072 | 2.084 / 2.95 |
| outline | 0.441 (13) | 0.337 (13) | 1.309 | None (0) | 0 | 2132 / 0 | 4.533 / 5.971 | 2.053 / 2.914 |
| occlusion | 0.917 (47) | 0.794 (39) | 1.155 | 2.193 (1) | 0 | 2267 / 0 | 4.411 / 5.795 | 2.0 / 2.817 |
| occlusion_move | 1.655 (65) | 1.276 (63) | 1.297 | 4.107 (20) | 0 | 2416 / 0 | 4.237 / 5.567 | 1.936 / 2.702 |
| occlusion_corner | 0.918 (110) | 0.784 (97) | 1.171 | 1.361 (1) | 0 | 2698 / 0 | 3.924 / 5.158 | 1.742 / 2.465 |
| translucent_move | 2.502 (124) | 2.302 (130) | 1.087 | 3.874 (40) | 0 | 3061 / 0 | 3.864 / 5.118 | 1.797 / 2.521 |
| water_glass_oit | 3.216 (154) | 2.35 (152) | 1.369 | None (0) | 0 | 413 / 0 | 5.85 / 7.377 | 3.36 / 4.342 |
| translucent_move_oit | 3.089 (221) | 3.066 (223) | 1.008 | 3.817 (25) | 0 | 968 / 0 | 4.303 / 5.518 | 2.279 / 3.153 |
| flat_plants | 1.151 (98) | 0.886 (102) | 1.299 | None (0) | 0 | 408 / 0 | 5.602 / 6.046 | 2.18 / 2.455 |
| renderer_off | 0.422 (26) | 0.263 (19) | 1.605 | None (0) | 0 | 324 / 0 | 5.486 / 7.326 | 2.384 / 4.043 |
| particles | 0.293 (30) | 0.173 (30) | 1.694 | None (0) | 0 | 3088 / 0 | 3.835 / 5.078 | 1.779 / 2.498 |
| animation | 0.727 (18) | 0.599 (18) | 1.214 | 0.996 (4) | 0 | 3163 / 0 | 3.76 / 4.976 | 1.717 / 2.426 |
| animated_items | 0.282 (42) | 0.186 (42) | 1.516 | 0.613 (2) | 0 | 3195 / 0 | 3.73 / 4.931 | 1.698 / 2.385 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.018 | 654.761 | 16 (vanilla 28) | 1382280 | 39.796 / 0.094 | 22.895 / 36.0 | 36.911 | 2356 / 0 | 2.739 (6.413) |
| flythrough | indirect, one multi-draw per arena and layer | 4.561 | 770.374 | 16 (vanilla 28) | 5186928 | 14.896 / 0.991 | 85.541 / 112.0 | 138.506 | 6607 / 0 | 4.073 (11.958) |
| water_glass | indirect, one multi-draw per arena and layer | 3.006 | 105.212 | 16 (vanilla 28) | 778240 | 32.606 / 0.082 | 12.543 / 36.0 | 20.781 | 3032 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.088 | 16 (vanilla 28) | 956484 | 27.41 / 0.185 | 15.242 / 20.0 | 25.541 | 4093 / 0 | 1.735 (2.862) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.107 | 16 (vanilla 28) | 605824 | 24.905 / 0.162 | 9.703 / 16.0 | 16.177 | 4541 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 77236 | 24.513 / 0.161 | 1.225 / 16.0 | 2.062 | 4635 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 154672 | 23.382 / 0.153 | 2.478 / 20.0 | 4.13 | 4880 / 0 | 2.193 (2.189) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.873 | 33.878 | 16 (vanilla 28) | 207036 | 22.148 / 0.145 | 3.32 / 20.0 | 5.528 | 5167 / 0 | 4.107 (12.593) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.052 | 60.868 | 16 (vanilla 28) | 122728 | 20.876 / 0.137 | 1.931 / 20.0 | 3.277 | 5560 / 0 | 1.361 (1.359) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.165 | 23.08 | 16 (vanilla 28) | 800192 | 18.034 / 0.124 | 12.96 / 28.0 | 21.367 | 6429 / 0 | 3.874 (11.378) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.021 | 113.469 | 16 (vanilla 28) | 778240 | 7.504 / 0.043 | 12.543 / 20.0 | 20.781 | 1086 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.202 | 37.238 | 16 (vanilla 28) | 774360 | 6.736 / 0.111 | 12.549 / 28.0 | 20.678 | 2423 / 0 | 3.817 (8.087) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.042 | 16 (vanilla 28) | 872012 | 6.531 / 0.01 | 13.967 / 24.0 | 23.285 | 966 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 544872 | 2.4 / 0.021 | 8.662 / 24.0 | 14.55 | 608 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 17.993 / 0.123 | 0.131 / 28.0 | 0.225 | 6471 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 17.851 / 0.122 | 0.302 / 28.0 | 0.518 | 6573 / 0 | 0.996 (1.557) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.801 / 0.123 | 0.153 / 28.0 | 0.261 | 6623 / 0 | 0.613 (0.919) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.845 | 1.0 | 0.0 | 0 | 0 | 49 (0.022 / 0.034 / 0.05; 0) | 0 | 33692 / 0 / 0 |
| flythrough | 193.355 | 1.0 | 0.0 | 0 | 0 | 888 (0.023 / 0.034 / 5.864; 0) | 56 | 33257 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1984 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.013 / 0.04 / 0.043; 0) | 32 | 1198 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.082 / 0.126 / 0.144; 0) | 180 | 3703 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 726 | 0 (None / None / None; 0) | 0 | 968 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 747 | 0 (None / None / None; 0) | 0 | 1743 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2108 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 349.863 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.073; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 438.169 | 1.0 (0.0, 0.0) | 1.134 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.063; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 109.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.129 (0.218; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.066 (0.157; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.356 | 10.0 (9.0, 2.372) | 6.0 (6.0, 2.28) | 0.059 (0.295; 0) | 0 | 2787 / 1510164 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.24 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.763 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.047; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 264.92 / 347.84 (23.8) | 264.92 / 82.92 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4560 / 0 |
| flythrough | two-phase | 317.9 / 410.16 (22.5) | 312.11 / 98.05 / 5.79 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3927 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10701 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 32086 / 0 |
| mobs | two-phase | 32.0 / 109.0 (70.6) | 32.0 / 77.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 10780 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3427 / 0 |
| occlusion_move | two-phase | 22.4 / 51.31 (56.3) | 22.35 / 28.97 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4343 / 0 |
| occlusion_corner | two-phase | 60.74 / 81.85 (25.8) | 60.67 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3161 / 0 |
| translucent_move | two-phase | 15.65 / 135.11 (88.4) | 15.64 / 119.48 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15773 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5220 / 0 |
| translucent_move_oit | two-phase | 15.66 / 135.23 (88.4) | 15.62 / 119.61 / 0.04 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7408 / 0 |
| flat_plants | two-phase | 9.0 / 151.0 (94.0) | 9.0 / 142.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18602 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15049 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 894 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.238 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 102.549 / 0.0 | 0.027 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.802 / 0.0 | 0.011 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.86 |
| water_glass | 110.266 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.873 / 53.893 | 0.02 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 107.642 / 7.48 | 0.86 / 0.754 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 39.493 / 6.806 | 0.07 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 81.938 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 104.522 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.157 / 12.198 | 0.006 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.339 / 54.426 | 0.015 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.488 / 13.337 | 0.007 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 101.77 / 7.452 | 0.934 / 0.907 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.748 / 2.463 | 0.015 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.01 / 0.059 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.287 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.002 / 0.011 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 49.41 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.19 (base 256.29) | 3.48 (base 3.73) |
| flythrough | 66.0 (reported, not gated) | 52 (reported, not gated) | 1178596 (reported, not gated) | 306.12 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.98 (base 20.0) | 13 (base 14) | 7540 (base 10264) | 239.26 (base 249.83) | 3.48 (base 5.99) |
| nether | 23.73 (base 33.79) | 10 (base 11) | 3840 (base 10656) | 260.82 (base 272.57) | 3.48 (base 5.99) |
| mobs | 25.78 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 259.11 (base 268.23) | 3.48 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.95 (base 264.41) | 3.48 (base 3.73) |
| occlusion | 18.76 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 264.6 (base 264.64) | 5.48 (base 4.24) |
| occlusion_move | 24.0 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 265.25 (base 265.66) | 5.48 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 269.12 (base 267.41) | 5.48 (base 3.73) |
| translucent_move | 18.0 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 275.42 (base 268.19) | 5.48 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7428 (base 7604) | 236.83 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.52 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 239.73 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 16.88 (base 33.0) | 12 (base 13) | 1492 (base 1716) | 239.68 (base 248.11) | 3.35 (base 5.99) |
| renderer_off | 12.68 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.31 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.77 (base 261.4) | 5.48 (base 4.24) |
| animation | 50 median (avg 40.02) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.8 (base 260.68) | 5.48 (base 4.24) |
| animated_items | 60 median (avg 47.14) (base 60) | 22 (base 22) | 21668 (base 21668) | 237.5 (base 239.53) | 5.48 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.41 / 49 (8.83) | 871.34 / 872 (14.95) | median and average, x 1.10 + 2 |
| flythrough | 66.0 / 63 (5.26) | 1043.7 / 1048 (10.47) | median and average, at most vanilla |
| water_glass | 19.98 / 20 (18.91) | 367.88 / 390 (24.68) | median, at most vanilla |
| nether | 23.73 / 26 (23.12) | 567.86 / 590 (24.62) | median, x 1.10 + 2 |
| mobs | 25.78 / 26 (24.89) | 293.98 / 332 (29.72) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 127.33 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 18.76 / 19 (29.58) | 162.27 / 201 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 24.0 / 24 (29.38) | 167.6 / 202 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (29.85) | 163.2 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 18.0 / 18 (15.29) | 340.98 / 368 (26.67) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (8.74) | 401.0 / 401 (13.45) | median, at most vanilla |
| translucent_move_oit | 25.52 / 26 (7.44) | 386.28 / 386 (13.37) | median and average, at most vanilla |
| flat_plants | 16.88 / 19 (25.27) | 362.9 / 398 (28.61) | median, x 1.10 + 2 |
| renderer_off | 12.68 / 13 (29.13) | 286.27 / 325 (30.0) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (29.99) | 97.27 / 136 (30.01) | median and average, x 1.10 + 2 |
| animation | 40.02 / 50 (30.01) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.14 / 60 (29.95) | 167.22 / 202 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.973 | 36.0 / 22.973 | 0.0 / 0.0 | 416.0 / 38.057 |
| flythrough | 112.0 / 84.531 | 112.0 / 84.531 | 0.0 / 0.0 | 416.0 / 153.314 |
| water_glass | 36.0 / 12.543 | 36.0 / 12.543 | 0.0 / 0.0 | 416.0 / 22.091 |
| nether | 20.0 / 15.241 | 20.0 / 15.241 | 0.0 / 0.0 | 256.0 / 26.677 |
| mobs | 16.0 / 9.703 | 16.0 / 9.703 | 0.0 / 0.0 | 256.0 / 16.975 |
| outline | 16.0 / 1.225 | 16.0 / 1.225 | 0.0 / 0.0 | 256.0 / 2.153 |
| occlusion | 20.0 / 2.581 | 20.0 / 2.581 | 0.0 / 0.0 | 416.0 / 4.475 |
| occlusion_move | 20.0 / 3.388 | 20.0 / 3.388 | 0.0 / 0.0 | 416.0 / 5.798 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.028 | 28.0 / 13.028 | 0.0 / 0.0 | 416.0 / 22.536 |
| water_glass_oit | 20.0 / 12.543 | 20.0 / 12.543 | 0.0 / 0.0 | 416.0 / 21.777 |
| translucent_move_oit | 28.0 / 12.618 | 28.0 / 12.618 | 0.0 / 0.0 | 416.0 / 21.821 |
| flat_plants | 24.0 / 13.89 | 24.0 / 13.89 | 0.0 / 0.0 | 416.0 / 23.888 |
| renderer_off | 24.0 / 8.662 | 24.0 / 8.662 | 0.0 / 0.0 | 416.0 / 15.275 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 423929.659 (643580.67) | 34.13 | 1.776 | 565524 / 615268 | 564032 (2097152.0) | 176 / 298 | 0.0 / 0 |
| flythrough | 543856.533 (872837.943) | 37.691 | 1.086 | 2196996 / 7045612 | 2185216 (2097152.0) | 105 / 209 | 22.755 / 127 |
| water_glass | 113288.915 (197741.746) | 42.709 | 1.124 | 9220 / 11540 | 0 (2097152.0) | 159 / 10 | 0.0 / 0 |
| nether | 46695.024 (73610.568) | 36.565 | 1.863 | 237796 / 380928 | 234304 (2097152.0) | 139 / 11 | 0.0 / 0 |
| mobs | 62867.988 (112473.398) | 44.104 | 0.967 | 610676 / 989812 | 0 (2097152.0) | 126 / 0 | 0.0 / 0 |
| outline | 1057.757 (2295.814) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29547.534 (52021.824) | 43.202 | 1.276 | 248996 / 662076 | 150848 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_move | 50379.022 (88568.351) | 43.118 | 1.223 | 648508 / 1097036 | 573440 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_corner | 27771.91 (60486.325) | 54.086 | 1.272 | 32840 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 201919.477 (358868.699) | 43.734 | 1.175 | 758804 / 1269108 | 755968 (2097152.0) | 306 / 5 | 0.0 / 0 |
| water_glass_oit | 113639.368 (198353.448) | 42.709 | 1.124 | 8996 / 11988 | 0 (2097152.0) | 174 / 269 | 0.0 / 0 |
| translucent_move_oit | 202586.446 (359711.635) | 43.681 | 1.173 | 728164 / 1269332 | 722688 (2097152.0) | 148 / 267 | 0.0 / 0 |
| flat_plants | 9101.988 (12478.661) | 27.06 | 1.045 | 1828 / 4420 | 0 (2097152.0) | 126 / 3 | 0.0 / 0 |
| renderer_off | 20156.574 (38177.485) | 47.203 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 51 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3044.114 (5227.753) | 41.77 | 1.087 | 86324 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2245.967 (4830.786) | 53.507 | 1.0 | 79396 / 122900 | 57728 (2097139.125) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 5.616 (121) | 2.492 (110) | 2.254 | 5.757 (65) | 0 | 890 / 0 | 10.206 / 13.824 | 5.118 / 6.852 |
| flythrough | 8.299 (1468) | 3.884 (1706) | 2.137 | 8.308 (1466) | 0 | 1394 / 0 | 8.319 / 10.41 | 5.425 / 7.2 |
| water_glass | 3.371 (15) | 1.436 (20) | 2.347 | None (0) | 0 | 1205 / 0 | 9.377 / 12.417 | 4.996 / 6.432 |
| nether | 3.542 (31) | 1.902 (28) | 1.862 | 3.176 (12) | 0 | 1832 / 0 | 7.864 / 10.282 | 4.166 / 5.467 |
| mobs | 1.073 (13) | 2.166 (7) | 0.495 | None (0) | 0 | 2065 / 0 | 7.72 / 9.941 | 4.072 / 5.381 |
| outline | 0.502 (12) | 0.234 (13) | 2.145 | None (0) | 0 | 2123 / 0 | 7.62 / 9.776 | 4.028 / 5.238 |
| occlusion | 1.407 (50) | 1.168 (69) | 1.205 | 4.04 (6) | 0 | 2256 / 0 | 7.427 / 9.488 | 3.888 / 5.052 |
| occlusion_move | 2.33 (57) | 1.441 (63) | 1.617 | 3.886 (16) | 0 | 2410 / 0 | 7.121 / 9.103 | 3.687 / 4.84 |
| occlusion_corner | 2.018 (93) | 0.782 (82) | 2.581 | 1.936 (1) | 0 | 2719 / 0 | 6.622 / 8.402 | 3.304 / 4.363 |
| translucent_move | 4.447 (86) | 2.429 (114) | 1.831 | 6.143 (34) | 0 | 3078 / 0 | 6.514 / 8.205 | 3.448 / 4.426 |
| water_glass_oit | 5.827 (152) | 2.351 (152) | 2.479 | None (0) | 0 | 413 / 0 | 9.911 / 13.11 | 5.341 / 7.078 |
| translucent_move_oit | 5.672 (208) | 2.438 (232) | 2.326 | 6.382 (26) | 0 | 1040 / 0 | 6.887 / 9.257 | 4.026 / 5.299 |
| flat_plants | 2.451 (87) | 0.871 (89) | 2.814 | None (0) | 0 | 403 / 0 | 7.853 / 9.366 | 4.387 / 4.83 |
| renderer_off | 0.634 (21) | 0.25 (24) | 2.536 | None (0) | 0 | 327 / 0 | 11.576 / 16.122 | 5.648 / 6.612 |
| particles | 0.431 (24) | 0.175 (24) | 2.463 | None (0) | 0 | 3105 / 0 | 6.465 / 8.14 | 3.39 / 4.353 |
| animation | 1.532 (18) | 3.078 (18) | 0.498 | 1.377 (4) | 0 | 3180 / 0 | 6.339 / 7.979 | 3.227 / 4.194 |
| animated_items | 0.386 (38) | 0.414 (32) | 0.932 | 1.159 (2) | 0 | 3212 / 0 | 6.285 / 7.91 | 3.147 / 4.143 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.222 | 729.46 | 16 (vanilla 28) | 1386844 | 42.855 / 0.111 | 22.973 / 36.0 | 37.033 | 2445 / 0 | 5.757 (10.811) |
| flythrough | plain, one multi-draw per region and layer | 56.41 | 860.533 | 16 (vanilla 28) | 5121716 | 15.239 / 0.971 | 84.531 / 112.0 | 136.765 | 6152 / 0 | 8.308 (22.689) |
| water_glass | plain, one multi-draw per region and layer | 14.037 | 105.278 | 16 (vanilla 28) | 778240 | 34.391 / 0.095 | 12.543 / 36.0 | 20.781 | 3097 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.599 | 73.731 | 16 (vanilla 28) | 956436 | 28.73 / 0.185 | 15.241 / 20.0 | 25.54 | 4152 / 0 | 3.176 (5.173) |
| mobs | plain, one multi-draw per region and layer | 8.016 | 60.12 | 16 (vanilla 28) | 605824 | 26.072 / 0.162 | 9.703 / 16.0 | 16.177 | 4608 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77236 | 25.671 / 0.161 | 1.225 / 16.0 | 2.062 | 4701 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.091 | 43.64 | 16 (vanilla 28) | 161184 | 24.44 / 0.153 | 2.581 / 20.0 | 4.304 | 4951 / 0 | 4.04 (5.347) |
| occlusion_move | plain, one multi-draw per region and layer | 10.959 | 76.25 | 16 (vanilla 28) | 212048 | 23.054 / 0.144 | 3.388 / 20.0 | 5.662 | 5239 / 0 | 3.886 (7.347) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.955 | 16 (vanilla 28) | 122728 | 21.753 / 0.136 | 1.931 / 20.0 | 3.277 | 5641 / 0 | 1.936 (1.924) |
| translucent_move | plain, one multi-draw per region and layer | 12.013 | 247.814 | 16 (vanilla 28) | 805188 | 18.94 / 0.123 | 13.028 / 28.0 | 21.501 | 6453 / 0 | 6.143 (19.24) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.092 | 113.649 | 16 (vanilla 28) | 778240 | 7.459 / 0.041 | 12.543 / 20.0 | 20.781 | 1082 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.628 | 263.426 | 16 (vanilla 28) | 779356 | 7.236 / 0.197 | 12.618 / 28.0 | 20.811 | 2546 / 0 | 6.382 (17.381) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.044 | 16 (vanilla 28) | 867100 | 6.231 / 0.01 | 13.89 / 24.0 | 23.154 | 932 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.038 | 16 (vanilla 28) | 544856 | 2.399 / 0.02 | 8.662 / 24.0 | 14.549 | 609 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.902 / 0.123 | 0.131 / 28.0 | 0.225 | 6492 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 18.753 / 0.122 | 0.302 / 28.0 | 0.518 | 6594 / 0 | 1.377 (2.187) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 18.705 / 0.122 | 0.153 / 28.0 | 0.261 | 6641 / 0 | 1.159 (1.937) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 52 (0.03 / 0.045 / 0.053; 0) | 0 | 27612 / 0 / 0 |
| flythrough | 178.198 | 25.943 | 0.0 | 0 | 0 | 773 (0.036 / 0.059 / 5.073; 0) | 31 | 18889 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1516 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1186 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 38 (0.009 / 0.016 / 0.018; 0) | 32 | 1176 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.113 / 0.175 / 0.368; 0) | 180 | 2149 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 525 | 0 (None / None / None; 0) | 0 | 700 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 447 | 0 (None / None / None; 0) | 0 | 1043 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2024 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2332 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.077; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 421.387 | 1.0 (0.0, 0.0) | 1.245 (0.0, 0.0) | 0.001 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.018 (0.071; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 109.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.143 (0.212; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.075 (0.2; 0) | 0 | 3558 / 1610588 / 0 / 0 |
| occlusion_move | 51.327 | 10.0 (9.0, 2.372) | 6.0 (6.0, 2.281) | 0.062 (0.245; 0) | 0 | 2736 / 1482908 / 0 / 0 |
| occlusion_corner | 81.861 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.042 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.685 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.011 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 305.92 / 349.0 (12.3) | 305.92 / 0.0 / 0.0 | 0.12 | 0.0 (0.0, 0.0; 0.0) | 1789.83 | 2050 / 0 |
| flythrough | still | 379.46 / 380.04 (0.2) | 379.46 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 8265 / 0 |
| nether | still | 56.35 / 300.0 (81.2) | 56.35 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 342.86 | 28141 / 0 |
| mobs | still | 32.0 / 109.0 (70.6) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 9548 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.47 / 49.0 (46.0) | 26.47 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 97.13 | 3312 / 0 |
| occlusion_move | still | 51.14 / 51.27 (0.2) | 51.14 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 134.11 / 134.81 (0.5) | 134.11 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3828 / 0 |
| translucent_move_oit | still | 134.07 / 134.79 (0.5) | 134.07 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 17892 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 14746 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 447 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4495.49 | 48 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.21 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 100.421 / 0.209 | 0.026 / 0.014 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.058 / 0.0 | 0.004 / 0.004 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.792 |
| water_glass | 93.073 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 55.965 / 56.021 | 0.02 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 93.262 / 7.701 | 0.791 / 0.681 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 35.576 / 5.764 | 0.07 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 86.142 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.449 / 13.388 | 0.005 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.168 / 54.069 | 0.016 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.219 / 14.094 | 0.007 / 0.012 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 80.42 / 7.505 | 0.783 / 0.622 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.177 / 1.123 | 0.011 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.01 / 0.05 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.011 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.11 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 13.67 (base 14.05) | 15 (base 15) | 23112 (base 27764) | 252.35 (base 257.2) | 3.46 (base 3.98) |
| flythrough | 13.07 (reported, not gated) | 24 (reported, not gated) | 179832 (reported, not gated) | 311.04 (base 318.06) | 3.71 (base 4.23) |
| water_glass | 8.72 (base 9.0) | 15 (base 15) | 12028 (base 15108) | 238.17 (base 244.39) | 3.46 (base 4.23) |
| nether | 12.76 (base 15.71) | 12 (base 12) | 10912 (base 19912) | 258.92 (base 268.95) | 3.46 (base 4.23) |
| mobs | 19.68 (base 19.97) | 17 (base 17) | 613580 (base 1008176) | 257.76 (base 264.31) | 3.46 (base 6.23) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 257.55 (base 264.58) | 3.46 (base 3.71) |
| occlusion | 15.68 (base 15.67) | 15 (base 15) | 100052 (base 126356) | 263.37 (base 264.78) | 5.46 (base 3.98) |
| occlusion_move | 16.06 (reported, not gated) | 15 (reported, not gated) | 82524 (reported, not gated) | 263.97 (base 265.16) | 5.46 (base 4.23) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 268.15 (base 266.66) | 5.46 (base 3.71) |
| translucent_move | 8.76 (reported, not gated) | 15 (reported, not gated) | 11092 (reported, not gated) | 274.38 (base 268.35) | 5.46 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 12140 (base 15024) | 237.88 (base 245.99) | 3.59 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10992 (reported, not gated) | 240.81 (base 248.38) | 3.71 (base 3.46) |
| flat_plants | 15.57 (base 18.96) | 15 (base 15) | 4480 (base 9864) | 239.8 (base 248.07) | 3.59 (base 5.98) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 3612 (base 7180) | 232.69 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 265.46 (base 261.4) | 5.46 (base 5.98) |
| animation | 50 median (avg 40.13) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.8 (base 260.68) | 5.46 (base 5.98) |
| animated_items | 60 median (avg 47.19) (base 60) | 24 (base 23) | 22136 (base 21940) | 236.74 (base 239.74) | 5.46 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.67 / 14 (14.78) | 123.77 / 124 (11.37) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (11.34) | 123.06 / 123 (6.99) | median and average, at most vanilla + 2 |
| water_glass | 8.72 / 9 (27.64) | 124.0 / 124 (17.65) | median, at most vanilla |
| nether | 12.76 / 16 (27.46) | 120.78 / 121 (17.79) | median, x 1.10 + 2 |
| mobs | 19.68 / 20 (29.05) | 120.51 / 134 (22.4) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (29.92) | 87.53 / 126 (29.88) | median, x 1.10 + 2 |
| occlusion | 15.68 / 16 (29.62) | 95.51 / 133 (29.55) | median and average, x 1.10 + 2 |
| occlusion_move | 16.06 / 17 (29.68) | 95.25 / 133 (29.66) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (29.88) | 82.92 / 121 (29.74) | median and average, x 1.10 + 2 |
| translucent_move | 8.76 / 9 (25.81) | 123.08 / 124 (18.98) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (14.92) | 129.0 / 129 (10.23) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (13.08) | 129.0 / 129 (9.67) | median and average, at most vanilla |
| flat_plants | 15.57 / 19 (28.46) | 123.7 / 124 (19.31) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.92) | 92.92 / 123 (26.82) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (29.87) | 86.59 / 125 (29.89) | median and average, x 1.10 + 2 |
| animation | 40.13 / 50 (29.88) | 144.91 / 179 (29.84) | median, x 1.10 + 2 |
| animated_items | 47.19 / 60 (29.82) | 156.21 / 190 (29.84) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.675 | 36.0 / 22.675 | 0.0 / 0.0 | 416.0 / 37.905 |
| flythrough | 112.0 / 88.493 | 112.0 / 88.493 | 0.0 / 0.0 | 416.0 / 146.507 |
| water_glass | 36.0 / 12.543 | 36.0 / 12.543 | 0.0 / 0.0 | 416.0 / 21.777 |
| nether | 20.0 / 15.238 | 20.0 / 15.238 | 0.0 / 0.0 | 256.0 / 26.676 |
| mobs | 16.0 / 9.703 | 16.0 / 9.703 | 0.0 / 0.0 | 256.0 / 16.975 |
| outline | 16.0 / 1.225 | 16.0 / 1.225 | 0.0 / 0.0 | 256.0 / 2.153 |
| occlusion | 20.0 / 2.486 | 20.0 / 2.486 | 0.0 / 0.0 | 416.0 / 4.373 |
| occlusion_move | 20.0 / 3.331 | 20.0 / 3.331 | 0.0 / 0.0 | 416.0 / 5.737 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.972 | 28.0 / 12.972 | 0.0 / 0.0 | 416.0 / 22.488 |
| water_glass_oit | 20.0 / 12.543 | 20.0 / 12.543 | 0.0 / 0.0 | 416.0 / 21.777 |
| translucent_move_oit | 28.0 / 12.616 | 28.0 / 12.616 | 0.0 / 0.0 | 416.0 / 21.775 |
| flat_plants | 24.0 / 13.968 | 24.0 / 13.968 | 0.0 / 0.0 | 416.0 / 23.861 |
| renderer_off | 24.0 / 8.662 | 24.0 / 8.662 | 0.0 / 0.0 | 416.0 / 15.275 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 468545.037 (632544.475) | 25.927 | 1.176 | 397220 / 721660 | 371968 (2097152.0) | 295 / 227 | 0.0 / 0 |
| flythrough | 573722.08 (921527.717) | 37.742 | 1.085 | 2125300 / 7835816 | 2095368 (2097152.0) | 226 / 139 | 6.938 / 84 |
| water_glass | 113194.692 (197577.283) | 42.709 | 1.124 | 13596 / 16696 | 0 (2097152.0) | 20 / 352 | 0.0 / 0 |
| nether | 45339.592 (66208.08) | 31.52 | 1.718 | 234736 / 231532 | 213312 (2097152.0) | 17 / 355 | 0.0 / 0 |
| mobs | 62850.176 (112441.531) | 44.104 | 0.967 | 613580 / 616420 | 0 (2097152.0) | 17 / 41 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion | 27488.355 (48041.014) | 42.781 | 1.302 | 100052 / 781300 | 0 (2097152.0) | 2 / 5 | 0.0 / 0 |
| occlusion_move | 49102.449 (86035.278) | 42.928 | 1.239 | 697872 / 1094940 | 620992 (2097152.0) | 3 / 3 | 0.0 / 0 |
| occlusion_corner | 27770.318 (60486.883) | 54.089 | 1.272 | 36096 / 59512 | 31552 (2097152.0) | 0 / 1 | 0.0 / 0 |
| translucent_move | 201271.233 (357599.899) | 43.716 | 1.171 | 765828 / 1333140 | 755968 (2097152.0) | 24 / 309 | 0.0 / 0 |
| water_glass_oit | 113369.161 (197881.812) | 42.709 | 1.124 | 13372 / 16472 | 0 (2097152.0) | 298 / 204 | 0.0 / 0 |
| translucent_move_oit | 200939.985 (356768.46) | 43.678 | 1.17 | 733088 / 1274492 | 722688 (2097152.0) | 261 / 193 | 0.0 / 0 |
| flat_plants | 9099.965 (12475.888) | 27.06 | 1.045 | 4704 / 9828 | 0 (2097152.0) | 10 / 305 | 0.0 / 0 |
| renderer_off | 20155.593 (38175.626) | 47.203 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 1 / 21 | 0.0 / 0 |
| particles | 1698.836 (3676.137) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| animation | 3060.873 (5266.749) | 41.883 | 1.085 | 86832 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2245.893 (4830.614) | 53.507 | 1.0 | 79864 / 123000 | 57728 (2097152.0) | 18 / 12 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 1.917 (135) | 2.301 (82) | 0.833 | 1.726 (63) | 0 | 952 / 0 | 5.315 / 7.105 | 2.084 / 2.931 |
| flythrough | 3.041 (1767) | 4.665 (1651) | 0.652 | 3.044 (1764) | 0 | 1398 / 0 | 3.789 / 5.395 | 2.048 / 3.235 |
| water_glass | 1.178 (21) | 1.497 (15) | 0.787 | None (0) | 0 | 1276 / 0 | 4.729 / 6.294 | 1.948 / 2.666 |
| nether | 1.457 (16) | 2.056 (29) | 0.709 | 1.626 (10) | 0 | 1904 / 0 | 3.904 / 5.263 | 1.659 / 2.301 |
| mobs | 0.475 (6) | 0.557 (6) | 0.853 | None (0) | 0 | 2137 / 0 | 3.798 / 5.103 | 1.625 / 2.221 |
| outline | 0.287 (12) | 0.255 (13) | 1.125 | None (0) | 0 | 2195 / 0 | 3.743 / 5.034 | 1.613 / 2.196 |
| occlusion | 0.544 (41) | 0.665 (47) | 0.818 | None (0) | 0 | 2335 / 0 | 3.608 / 4.855 | 1.577 / 2.117 |
| occlusion_move | 0.986 (65) | 1.267 (55) | 0.778 | 2.328 (16) | 0 | 2493 / 0 | 3.46 / 4.648 | 1.538 / 2.05 |
| occlusion_corner | 0.796 (92) | 0.829 (101) | 0.96 | 0.848 (1) | 0 | 2773 / 0 | 3.221 / 4.297 | 1.374 / 1.842 |
| translucent_move | 1.277 (116) | 1.858 (119) | 0.687 | 2.14 (32) | 0 | 3138 / 0 | 3.124 / 4.178 | 1.396 / 1.865 |
| water_glass_oit | 2.202 (158) | 2.319 (152) | 0.95 | None (0) | 0 | 413 / 0 | 4.952 / 6.187 | 2.516 / 3.627 |
| translucent_move_oit | 2.209 (235) | 2.916 (216) | 0.758 | 2.203 (26) | 0 | 969 / 0 | 3.204 / 4.159 | 1.562 / 2.084 |
| flat_plants | 0.966 (98) | 1.083 (86) | 0.892 | None (0) | 0 | 411 / 0 | 3.746 / 4.951 | 1.513 / 1.754 |
| renderer_off | 0.307 (23) | 0.296 (23) | 1.037 | None (0) | 0 | 329 / 0 | 5.201 / 7.065 | 1.576 / 2.151 |
| particles | 0.232 (30) | 0.234 (30) | 0.991 | None (0) | 0 | 3166 / 0 | 3.1 / 4.145 | 1.385 / 1.843 |
| animation | 0.574 (18) | 0.737 (18) | 0.779 | 0.818 (4) | 0 | 3241 / 0 | 3.043 / 4.062 | 1.346 / 1.786 |
| animated_items | 0.209 (42) | 0.181 (38) | 1.155 | 0.82 (2) | 0 | 3273 / 0 | 3.017 / 4.026 | 1.328 / 1.765 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.01 | 711.888 | 16 (vanilla 28) | 1368244 | 40.391 / 0.103 | 22.675 / 36.0 | 36.536 | 2671 / 0 | 1.726 (3.089) |
| flythrough | indirect, one multi-draw per arena and layer | 3.013 | 926.708 | 16 (vanilla 28) | 5363092 | 14.719 / 0.957 | 88.493 / 112.0 | 143.21 | 6796 / 0 | 3.044 (9.866) |
| water_glass | indirect, one multi-draw per arena and layer | 3.005 | 105.19 | 16 (vanilla 28) | 778240 | 33.331 / 0.09 | 12.543 / 36.0 | 20.781 | 3361 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 66.466 | 16 (vanilla 28) | 956228 | 28.426 / 0.184 | 15.238 / 20.0 | 25.534 | 4390 / 0 | 1.626 (2.725) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 60.103 | 16 (vanilla 28) | 605824 | 25.97 / 0.162 | 9.703 / 16.0 | 16.177 | 4832 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 77236 | 25.59 / 0.161 | 1.225 / 16.0 | 2.062 | 4925 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.073 | 16 (vanilla 28) | 155236 | 24.481 / 0.154 | 2.486 / 20.0 | 4.145 | 5171 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.002 | 75.266 | 16 (vanilla 28) | 208220 | 23.16 / 0.145 | 3.331 / 20.0 | 5.56 | 5477 / 0 | 2.328 (5.552) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.957 | 16 (vanilla 28) | 122728 | 21.973 / 0.138 | 1.931 / 20.0 | 3.277 | 5848 / 0 | 0.848 (0.847) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.004 | 247.225 | 16 (vanilla 28) | 801436 | 19.135 / 0.125 | 12.972 / 28.0 | 21.401 | 6696 / 0 | 2.14 (4.753) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.017 | 113.379 | 16 (vanilla 28) | 778240 | 7.482 / 0.043 | 12.543 / 20.0 | 20.781 | 1094 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.015 | 261.073 | 16 (vanilla 28) | 778904 | 6.868 / 0.115 | 12.616 / 28.0 | 20.799 | 2449 / 0 | 2.203 (5.721) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 22.039 | 16 (vanilla 28) | 872504 | 6.423 / 0.01 | 13.968 / 24.0 | 23.298 | 971 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 544864 | 2.373 / 0.02 | 8.662 / 24.0 | 14.549 | 614 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 19.091 / 0.125 | 0.131 / 28.0 | 0.225 | 6740 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.761 | 16 (vanilla 28) | 19416 | 18.946 / 0.124 | 0.302 / 28.0 | 0.518 | 6842 / 0 | 0.818 (1.214) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.69 | 16 (vanilla 28) | 9764 | 18.895 / 0.124 | 0.153 / 28.0 | 0.261 | 6892 / 0 | 0.82 (1.212) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 1.0 | 0.0 | 0 | 0 | 49 (0.016 / 0.027 / 0.038; 0) | 0 | 45288 / 0 / 0 |
| flythrough | 196.093 | 1.0 | 0.0 | 0 | 0 | 911 (0.016 / 0.032 / 5.032; 0) | 45 | 44513 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2212 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1186 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.01 / 0.013 / 0.014; 0) | 32 | 1188 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 183 (0.07 / 0.102 / 0.379; 0) | 183 | 3619 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 897 | 0 (None / None / None; 0) | 0 | 1196 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 786 | 0 (None / None / None; 0) | 0 | 1834 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2280 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 343.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.031 (0.076; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.952 | 1.0 (0.0, 0.0) | 1.141 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.054; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 109.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.103 (0.27; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.065 (0.226; 0) | 0 | 3558 / 1610588 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.364) | 6.0 (6.0, 2.279) | 0.056 (0.304; 0) | 0 | 2758 / 1493202 / 0 / 0 |
| occlusion_corner | 81.863 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.215 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.385 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.165; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 298.31 / 341.0 (12.5) | 298.31 / 0.0 / 0.0 | 0.1 | 0.0 (0.0, 0.0; 0.0) | 1508.11 | 3120 / 0 |
| flythrough | still | 413.38 / 413.92 (0.1) | 413.38 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 61 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 12006 / 0 |
| nether | still | 51.35 / 300.0 (82.9) | 51.35 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 183.27 | 33927 / 0 |
| mobs | still | 32.0 / 109.0 (70.6) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11165 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.0 / 49.0 (46.9) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3404 / 0 |
| occlusion_move | still | 51.12 / 51.3 (0.4) | 51.12 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 37 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 134.67 / 135.09 (0.3) | 134.67 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6525 / 0 |
| translucent_move_oit | still | 134.05 / 134.87 (0.6) | 134.05 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 108 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 20164 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1177.96 | 381 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4462.31 | 48 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.767 / 0.512 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 135.763 / 0.865 | 0.035 / 0.012 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.105 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.868 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.428 / 54.418 | 0.019 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.195 | 0.777 / 0.831 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.459 / 9.069 | 0.06 / 0.012 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 101.622 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.859 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 77.834 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 77.572 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 77.247 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 114.09 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.352 / 13.275 | 0.007 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.0 / 53.97 | 0.016 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.965 / 13.939 | 0.005 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 114.702 / 6.995 | 1.0 / 0.875 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.237 / 2.102 | 0.016 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 85.177 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.923 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.052 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 137.24 / 32.375 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.796 | 0.004 / 0.008 | 56 (3) | 40.536 / 9.232 / 31.304 | 3 / 0 | 10.982 |
| animated_items | 137.482 / 28.205 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 50.48 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 253.78 (base 256.29) | 4.48 (base 3.73) |
| flythrough | 69.67 (reported, not gated) | 45 (reported, not gated) | 822748 (reported, not gated) | 309.6 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.92 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 238.36 (base 249.83) | 4.48 (base 5.99) |
| nether | 24.05 (base 33.79) | 10 (base 11) | 4400 (base 10656) | 259.66 (base 272.57) | 4.48 (base 5.99) |
| mobs | 26.75 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.31 (base 268.23) | 4.48 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.25 (base 264.41) | 4.48 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.78 (base 264.64) | 4.48 (base 4.24) |
| occlusion_move | 20.1 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.24 (base 265.66) | 4.48 (base 5.99) |
| occlusion_corner | 11.72 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.72 (base 267.41) | 6.48 (base 3.73) |
| translucent_move | 11.16 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 275.25 (base 268.19) | 6.48 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7204 (base 7604) | 237.71 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.45 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 240.61 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.24 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 239.4 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 13.69 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.74 (base 240.73) | 3.35 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.18 (base 261.4) | 6.48 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.5 (base 260.68) | 6.48 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.82 (base 239.53) | 6.48 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.48 / 50 (8.62) | 871.34 / 872 (14.95) | median and average, x 1.10 + 2 |
| flythrough | 69.67 / 69 (6.82) | 1043.7 / 1048 (10.47) | median and average, at most vanilla |
| water_glass | 20.92 / 21 (20.31) | 367.88 / 390 (24.68) | median, at most vanilla |
| nether | 24.05 / 27 (24.21) | 567.86 / 590 (24.62) | median, x 1.10 + 2 |
| mobs | 26.75 / 27 (26.38) | 293.98 / 332 (29.72) | median, x 1.10 + 2 |
| outline | 11.67 / 12 (30.0) | 127.33 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 19.67 / 20 (29.86) | 162.27 / 201 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 20.1 / 21 (29.79) | 167.6 / 202 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.72 / 12 (29.97) | 163.2 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 11.16 / 11 (24.57) | 340.98 / 368 (26.67) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (10.34) | 401.0 / 401 (13.45) | median, at most vanilla |
| translucent_move_oit | 18.45 / 18 (10.42) | 386.28 / 386 (13.37) | median and average, at most vanilla |
| flat_plants | 18.24 / 21 (24.24) | 362.9 / 398 (28.61) | median, x 1.10 + 2 |
| renderer_off | 13.69 / 14 (28.93) | 286.27 / 325 (30.0) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (30.0) | 97.27 / 136 (30.01) | median and average, x 1.10 + 2 |
| animation | 40.98 / 50 (30.0) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.0) | 167.22 / 202 (30.01) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.995 | 36.0 / 22.995 | 0.0 / 0.0 | 416.0 / 38.057 |
| flythrough | 112.0 / 85.175 | 112.0 / 85.175 | 0.0 / 0.0 | 416.0 / 153.314 |
| water_glass | 36.0 / 12.543 | 36.0 / 12.543 | 0.0 / 0.0 | 416.0 / 22.091 |
| nether | 20.0 / 15.237 | 20.0 / 15.237 | 0.0 / 0.0 | 256.0 / 26.677 |
| mobs | 16.0 / 9.703 | 16.0 / 9.703 | 0.0 / 0.0 | 256.0 / 16.975 |
| outline | 16.0 / 1.225 | 16.0 / 1.225 | 0.0 / 0.0 | 256.0 / 2.153 |
| occlusion | 20.0 / 2.607 | 20.0 / 2.607 | 0.0 / 0.0 | 416.0 / 4.475 |
| occlusion_move | 20.0 / 3.332 | 20.0 / 3.332 | 0.0 / 0.0 | 416.0 / 5.798 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.015 | 28.0 / 13.015 | 0.0 / 0.0 | 416.0 / 22.536 |
| water_glass_oit | 20.0 / 12.543 | 20.0 / 12.543 | 0.0 / 0.0 | 416.0 / 21.777 |
| translucent_move_oit | 28.0 / 12.604 | 28.0 / 12.604 | 0.0 / 0.0 | 416.0 / 21.821 |
| flat_plants | 24.0 / 13.795 | 24.0 / 13.795 | 0.0 / 0.0 | 416.0 / 23.888 |
| renderer_off | 24.0 / 8.633 | 24.0 / 8.633 | 0.0 / 0.0 | 416.0 / 15.275 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 396288.709 (595035.035) | 33.401 | 1.775 | 1021540 / 615268 | 1020160 (2097152.0) | 172 / 298 | 0.0 / 0 |
| flythrough | 484180.235 (764033.824) | 36.628 | 1.088 | 2108412 / 7045612 | 2096496 (2097152.0) | 136 / 209 | 9.277 / 57 |
| water_glass | 113267.617 (197704.57) | 42.709 | 1.124 | 9108 / 11540 | 0 (2097152.0) | 137 / 10 | 0.0 / 0 |
| nether | 29504.709 (42405.254) | 30.422 | 2.0 | 136932 / 380928 | 133440 (2097152.0) | 122 / 11 | 0.0 / 0 |
| mobs | 62860.83 (112460.591) | 44.104 | 0.967 | 610676 / 989812 | 0 (2097152.0) | 37 / 0 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion | 29603.504 (52209.307) | 43.298 | 1.279 | 277988 / 662076 | 179840 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 22347.429 (39369.503) | 43.237 | 1.26 | 651068 / 1097036 | 576000 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_corner | 21836.013 (47201.162) | 53.738 | 1.215 | 32932 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21656.163 (27731.614) | 21.908 | 1.004 | 758968 / 1269108 | 756224 (2097152.0) | 123 / 5 | 0.0 / 0 |
| water_glass_oit | 113538.495 (198177.379) | 42.709 | 1.124 | 8548 / 11988 | 0 (2097152.0) | 206 / 269 | 0.0 / 0 |
| translucent_move_oit | 21793.0 (27952.202) | 22.035 | 1.004 | 727716 / 1269332 | 722688 (2097152.0) | 208 / 267 | 0.0 / 0 |
| flat_plants | 9102.691 (12479.626) | 27.06 | 1.045 | 2164 / 4420 | 0 (2097152.0) | 122 / 3 | 0.0 / 0 |
| renderer_off | 19685.941 (37248.221) | 47.149 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 62 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86232 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79304 / 122900 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.304 (123) | 2.492 (110) | 1.727 | 4.076 (75) | 0 | 866 / 0 | 9.298 / 11.873 | 4.386 / 6.052 |
| flythrough | 6.051 (1625) | 3.884 (1706) | 1.558 | 6.056 (1623) | 0 | 1398 / 0 | 7.388 / 10.245 | 4.76 / 6.899 |
| water_glass | 2.669 (14) | 1.436 (20) | 1.859 | None (0) | 0 | 1184 / 0 | 8.392 / 10.762 | 4.16 / 5.626 |
| nether | 3.017 (22) | 1.902 (28) | 1.586 | 2.844 (8) | 0 | 1807 / 0 | 7.009 / 8.932 | 3.421 / 4.845 |
| mobs | 0.946 (6) | 2.166 (7) | 0.437 | None (0) | 0 | 2038 / 0 | 6.794 / 8.727 | 3.36 / 4.778 |
| outline | 0.615 (13) | 0.234 (13) | 2.628 | None (0) | 0 | 2096 / 0 | 6.684 / 8.59 | 3.293 / 4.663 |
| occlusion | 2.043 (45) | 1.168 (69) | 1.749 | 2.677 (6) | 0 | 2225 / 0 | 6.617 / 8.438 | 3.229 / 4.534 |
| occlusion_move | 1.975 (69) | 1.441 (63) | 1.371 | 3.661 (16) | 0 | 2394 / 0 | 6.32 / 8.077 | 3.056 / 4.285 |
| occlusion_corner | 1.43 (110) | 0.782 (82) | 1.829 | 1.565 (1) | 0 | 2682 / 0 | 5.871 / 7.472 | 2.791 / 3.792 |
| translucent_move | 3.266 (124) | 2.429 (114) | 1.345 | 5.089 (35) | 0 | 3042 / 0 | 5.787 / 7.436 | 2.877 / 3.89 |
| water_glass_oit | 4.428 (154) | 2.351 (152) | 1.883 | None (0) | 0 | 413 / 0 | 9.587 / 11.836 | 5.49 / 6.54 |
| translucent_move_oit | 3.778 (211) | 2.438 (232) | 1.55 | 5.436 (25) | 0 | 961 / 0 | 6.412 / 8.206 | 3.698 / 4.686 |
| flat_plants | 1.765 (82) | 0.871 (89) | 2.026 | None (0) | 0 | 393 / 0 | 8.042 / 9.611 | 3.491 / 4.32 |
| renderer_off | 0.647 (21) | 0.25 (24) | 2.588 | None (0) | 0 | 320 / 0 | 9.153 / 12.31 | 3.733 / 5.341 |
| particles | 0.388 (30) | 0.175 (24) | 2.217 | None (0) | 0 | 3070 / 0 | 5.74 / 7.376 | 2.838 / 3.847 |
| animation | 1.289 (18) | 3.078 (18) | 0.419 | 1.364 (4) | 0 | 3145 / 0 | 5.627 / 7.227 | 2.739 / 3.71 |
| animated_items | 0.392 (42) | 0.414 (32) | 0.947 | 0.962 (2) | 0 | 3177 / 0 | 5.577 / 7.161 | 2.695 / 3.623 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.233 | 660.355 | 16 (vanilla 28) | 1387876 | 42.253 / 0.098 | 22.995 / 36.0 | 37.06 | 2396 / 0 | 4.076 (9.209) |
| flythrough | plain, one multi-draw per region and layer | 58.956 | 756.25 | 16 (vanilla 28) | 5161548 | 15.227 / 1.024 | 85.175 / 112.0 | 137.828 | 6507 / 0 | 6.056 (18.34) |
| water_glass | plain, one multi-draw per region and layer | 14.034 | 105.258 | 16 (vanilla 28) | 778240 | 34.158 / 0.089 | 12.543 / 36.0 | 20.781 | 3053 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.025 | 43.089 | 16 (vanilla 28) | 956324 | 28.671 / 0.189 | 15.237 / 20.0 | 25.537 | 4084 / 0 | 2.844 (3.906) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.114 | 16 (vanilla 28) | 605824 | 26.025 / 0.165 | 9.703 / 16.0 | 16.177 | 4522 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77236 | 25.613 / 0.164 | 1.225 / 16.0 | 2.062 | 4616 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 163096 | 24.409 / 0.156 | 2.607 / 20.0 | 4.355 | 4854 / 0 | 2.677 (3.321) |
| occlusion_move | plain, one multi-draw per region and layer | 6.037 | 33.897 | 16 (vanilla 28) | 209084 | 22.92 / 0.146 | 3.332 / 20.0 | 5.583 | 5196 / 0 | 3.661 (10.383) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.878 | 16 (vanilla 28) | 122728 | 21.606 / 0.138 | 1.931 / 20.0 | 3.277 | 5593 / 0 | 1.565 (1.564) |
| translucent_move | plain, one multi-draw per region and layer | 4.415 | 23.12 | 16 (vanilla 28) | 805360 | 18.656 / 0.124 | 13.015 / 28.0 | 21.505 | 6447 / 0 | 5.089 (15.447) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.078 | 113.549 | 16 (vanilla 28) | 778240 | 7.507 / 0.043 | 12.543 / 20.0 | 20.781 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.49 | 37.327 | 16 (vanilla 28) | 779520 | 6.584 / 0.091 | 12.604 / 28.0 | 20.815 | 2401 / 0 | 5.436 (12.955) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.045 | 16 (vanilla 28) | 862092 | 6.216 / 0.01 | 13.795 / 24.0 | 23.02 | 912 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.038 | 16 (vanilla 28) | 542688 | 2.459 / 0.021 | 8.633 / 24.0 | 14.491 | 595 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.61 / 0.124 | 0.131 / 28.0 | 0.225 | 6491 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.463 / 0.123 | 0.302 / 28.0 | 0.518 | 6593 / 0 | 1.364 (2.229) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.412 / 0.124 | 0.153 / 28.0 | 0.261 | 6643 / 0 | 0.962 (1.568) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.688 | 17.0 | 0.0 | 0 | 0 | 64 (0.13 / 0.039 / 4.051; 0) | 0 | 26934 / 0 / 0 |
| flythrough | 187.978 | 26.161 | 0.0 | 0 | 0 | 862 (0.024 / 0.048 / 5.066; 0) | 43 | 25753 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1632 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1196 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.01 / 0.01; 0) | 32 | 1192 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.116 / 0.15 / 3.176; 0) | 180 | 3451 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 621 | 0 (None / None / None; 0) | 0 | 828 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 627 | 0 (None / None / None; 0) | 0 | 1463 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1948 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2320 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.59 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.032 (0.105; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.431 | 1.0 (0.0, 0.0) | 1.19 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.008; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.056; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 109.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.133 (0.299; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.076 (0.144; 0) | 0 | 3588 / 1624168 / 0 / 0 |
| occlusion_move | 50.356 | 10.0 (9.0, 2.366) | 6.0 (6.0, 2.277) | 0.066 (0.367; 0) | 0 | 2767 / 1498290 / 0 / 0 |
| occlusion_corner | 81.86 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.237 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.474 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.062; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 266.84 / 349.54 (23.7) | 266.84 / 82.7 / 0.01 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3556 / 0 |
| flythrough | two-phase | 312.31 / 400.61 (22.0) | 305.35 / 95.26 / 6.96 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 2982 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 8787 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 31823 / 0 |
| mobs | two-phase | 32.0 / 109.0 (70.6) | 32.0 / 77.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 10164 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 48.0 (45.8) | 26.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3278 / 0 |
| occlusion_move | two-phase | 22.41 / 50.31 (55.5) | 22.35 / 27.95 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4156 / 0 |
| occlusion_corner | two-phase | 60.75 / 81.85 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3164 / 0 |
| translucent_move | two-phase | 15.67 / 135.1 (88.4) | 15.65 / 119.45 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 14693 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4524 / 0 |
| translucent_move_oit | two-phase | 15.7 / 134.84 (88.4) | 15.65 / 119.19 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6188 / 0 |
| flat_plants | two-phase | 9.0 / 150.0 (94.0) | 9.0 / 141.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 17061 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.03; 100.0) | 14400.0 | 14544 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.477 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 103.04 / 0.572 | 0.031 / 0.013 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.16 / 0.0 | 0.003 / 0.001 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.839 |
| water_glass | 93.073 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.299 / 54.377 | 0.027 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 93.262 / 7.505 | 0.791 / 0.792 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 45.077 / 9.342 | 0.082 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 86.142 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.082 / 14.0 | 0.006 / 0.015 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.449 / 51.459 | 0.013 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.367 / 12.263 | 0.006 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 80.42 / 7.49 | 0.783 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.394 / 3.22 | 0.015 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.012 / 0.062 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.012 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
siftec/quicksilver-full: bench kinetics_instancing: median meshing time 2.075 ms per section against vanilla's compiler 2.233 ms (0.929x; limit 2.233 ms; 115 pairs): reported, not gated (open gap)

siftec/quicksilver-full: bench factory_flat: median meshing time 0.83 ms per section against vanilla's compiler 0.577 ms (1.438x; limit 0.635 ms; 608 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench kinetics_instancing: median meshing time 3.72 ms per section against vanilla's compiler 3.526 ms (1.055x; limit 3.526 ms; 149 pairs): reported, not gated (open gap)

siftec/quicksilver-old: bench factory_flat: median meshing time 0.772 ms per section against vanilla's compiler 0.748 ms (1.032x; limit 0.823 ms; 609 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.915 ms per section against vanilla's compiler 0.571 ms (1.602x; limit 0.628 ms; 575 pairs): reported, not gated (open gap)

siftec/quicksilver-vk: bench kinetics_instancing: median meshing time 4.082 ms per section against vanilla's compiler 4.317 ms (0.946x; limit 4.317 ms; 144 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench kinetics_instancing: median meshing time 4.345 ms per section against vanilla's compiler 3.597 ms (1.208x; limit 3.597 ms; 138 pairs): reported, not gated (open gap)

siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.904 ms per section against vanilla's compiler 0.589 ms (1.535x; limit 0.648 ms; 608 pairs): reported, not gated (open gap)

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
| factory | 0.0 | 0.3 | 0.0 | 0.0 | 0.0169 | 0.0 |
| factory_flat | 0.0 | 0.3 | 0.0034 | 0.0 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 | 0.0068 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0011 | 0.55 | 0.0059 | 0.0065 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | 0.0059 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| kinetics | 0.0041 | 0.25 | 0.0102 | 0.0008 | 0.0018 | 0.0176 |
| kinetics_instancing | 0.0077 | 0.25 | 0.0021 | 0.01 | 0.0158 | 0.0165 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| factory | 95.56 | 370 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) | 55 (536) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| mam | 87.03 | 10 | 0 (0) | 0 (0) | 0 (40) | 0 (0) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 41 (4282) | 42 (4282) | None (None) | 36 (4274) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| kinetics | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |
| kinetics_instancing | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |

Strict picture where the vanilla runs drawing the same way agree (package 5, Create scenes: Flywheel on in vanilla a and b, off in vanilla old and Vulkan), same strict limits:

| scene | runs | vanilla runs | agree on % of pixels | strict pixels |
|---|---|---|---|---|
| kinetics | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 10, old-gpu-2p 8 |
| kinetics | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 3, old-gpu-2p 0 |
| kinetics_instancing | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics_instancing | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics_instancing | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 7, old-gpu-2p 8 |
| kinetics_instancing | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 0, old-gpu-2p 0 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0169 / 0 | 0.0169 / 0 | 0.0169 / 0 | 0.0169 / 0 |
| factory_flat | 0.0034 / 0 | 0.0034 / 0 | 0.0 / 0 | 0.0034 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.002 / 14 | 0.002 / 8 | skipped | 0.002 / 8 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| kinetics | 0.0173 / 0 | 0.0053 / 0 | 0.0066 / 0 | 0.0053 / 0 |
| kinetics_instancing | 0.0062 / 0 | 0.0033 / 0 | 0.0029 / 0 | 0.0033 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.68 (base 12.22) | 15 (base 15) | 6004 (base 6976) | 366.26 (base 361.48) | 4.24 (base 5.48) |
| factory_flat | 12.68 (reported, not gated) | 15 (base 15) | 6004 (base 6844) | 361.15 (base 360.51) | 3.48 (base 5.48) |
| sift | 24.0 (base 23.0) | 18 (base 19) | 16992 (base 81788) | 384.64 (base 379.72) | 4.24 (base 5.87) |
| hub | 21.54 (base 21.53) | 16 (base 16) | 65656 (base 66576) | 397.02 (base 392.33) | 4.24 (base 5.48) |
| mam | 22.53 (base 22.53) | 19 (base 19) | 22088 (base 23748) | 410.46 (base 405.55) | 8.24 (base 8.12) |
| ponder | 88.25 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 406.36 (base 404.14) | 8.24 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 17 (base 17) | 43568 (base 44728) | 396.84 (base 392.95) | 8.06 (base 8.24) |
| create_ct | 7.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 397.87 (base 394.1) | 8.06 (base 10.24) |
| kinetics | 8.68 (base 8.67) | 13 (base 13) | 7692 (base 7692) | 396.62 (base 395.42) | 8.06 (base 8.06) |
| kinetics_instancing | 7.67 (base 7.67) | 13 (base 13) | 7792 (base 7792) | 359.04 (base 360.23) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.68 / 13 (29.06) | 105.0 / 152 (29.99) | median and average, at most vanilla |
| factory_flat | 12.68 / 13 (29.32) | 105.55 / 152 (29.76) | median and average, at most vanilla |
| sift | 24.0 / 24 (15.36) | 132.94 / 153 (23.22) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.56) | 115.02 / 161 (29.92) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.79) | 115.79 / 162 (30.01) | median, x 1.10 + 2 |
| ponder | 88.25 / 88 (29.96) | 180.58 / 227 (29.89) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.54) | 117.16 / 164 (29.97) | median, at most vanilla |
| create_ct | 7.67 / 8 (30.0) | 100.08 / 147 (29.95) | median and average, x 1.10 + 2 |
| kinetics | 8.68 / 9 (29.59) | 101.31 / 148 (29.88) | median and average, at most vanilla |
| kinetics_instancing | 7.67 / 8 (29.96) | 100.92 / 148 (29.98) | median and average, at most vanilla |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.918 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.307 | 32.0 / 20.307 | 0.0 / 0.0 | 416.0 / 34.132 |
| ponder | 32.0 / 17.561 | 32.0 / 17.561 | 0.0 / 0.0 | 416.0 / 29.209 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13584.214 (26449.188) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 4 / 1 | 0.0 / 0 |
| factory_flat | 13583.758 (26448.29) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 2 / 5 | 0.0 / 0 |
| sift | 115779.909 (158139.44) | 26.786 | 1.401 | 16992 / 16612 | 0 (2097152.0) | 307 / 43 | 0.0 / 0 |
| hub | 474.803 (783.325) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 5 / 3 | 0.0 / 0 |
| mam | 568.953 (925.55) | 38.528 | 1.25 | 303192 / 42688 | 0 (2097152.0) | 7 / 0 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61224 | 0 (2097152.0) | 0 / 5 | 0.0 / 0 |
| hologram | 3670.2 (6346.721) | 42.172 | 1.0 | 46796 / 46520 | 0 (2097152.0) | 5 / 2 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics | 5437.169 (10385.514) | 47.647 | 1.0 | 7692 / 7792 | 0 (2097152.0) | 5 / 2 | 0.0 / 0 |
| kinetics_instancing | 6068.13 (11697.528) | 48.125 | 1.0 | 7792 / 7792 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.251 (35) | 2.656 (35) | 1.601 | 4.567 (12) | 0 | 751 / 0 | 10.883 / 13.137 | 5.649 / 7.324 |
| factory_flat | 2.43 (69) | 1.107 (68) | 2.195 | 2.629 (14) | 0 | 608 / 0 | 2.26 / 1.963 | 0.83 / 0.577 |
| sift | 1.577 (41) | 0.991 (41) | 1.591 | None (0) | 0 | 1295 / 0 | 7.769 / 9.311 | 3.429 / 4.366 |
| hub | 0.461 (8) | 0.189 (8) | 2.439 | None (0) | 0 | 1345 / 0 | 7.643 / 9.14 | 3.427 / 4.309 |
| mam | 0.525 (4) | 0.215 (4) | 2.442 | None (0) | 0 | 1658 / 0 | 7.576 / 9.508 | 3.596 / 4.95 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1659 / 0 | 7.572 / 9.503 | 3.592 / 4.95 |
| hologram | 0.869 (13) | 0.421 (31) | 2.064 | None (0) | 0 | 1692 / 0 | 7.509 / 9.383 | 3.573 / 4.794 |
| create_ct | 0.77 (60) | 0.357 (60) | 2.157 | None (0) | 0 | 1748 / 0 | 7.318 / 9.145 | 3.455 / 4.625 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1838 / 0 | 7.108 / 8.817 | 3.393 / 4.382 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 115 / 0 | 9.471 / 10.073 | 2.075 / 2.233 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 32.055 | 16 (vanilla 28) | 96100 | 25.249 / 0.233 | 1.511 / 28.0 | 2.566 | 1509 / 0 | 4.567 (7.927) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.055 | 16 (vanilla 28) | 96100 | 2.78 / 0.024 | 1.511 / 8.0 | 2.566 | 823 / 0 | 2.629 (9.287) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 320.039 | 16 (vanilla 28) | 462560 | 23.008 / 0.279 | 7.389 / 16.0 | 12.352 | 2517 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.348 / 0.271 | 1.879 / 12.0 | 3.137 | 2595 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1192904 | 23.202 / 0.312 | 20.307 / 32.0 | 31.854 | 3244 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019156 | 23.202 / 0.312 | 17.561 / 32.0 | 27.214 | 3245 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.04 / 0.308 | 0.238 / 32.0 | 0.367 | 3303 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.579 / 0.301 | 0.171 / 32.0 | 0.283 | 3411 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 22.526 / 0.316 | 0.372 / 32.0 | 0.624 | 3517 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 27.045 | 16 (vanilla 28) | 23356 | 8.125 / 0.44 | 0.372 / 8.0 | 0.624 | 128 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1848 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 591 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 597 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2368 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.002 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.002 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6090 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6132 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 5313 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5032 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7748 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 441 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 740 / 0 |
| kinetics_instancing | still | 23.0 / 23.0 (0.0) | 23.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.882 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 120.086 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 154.995 / 92.008 | 0.163 / 0.046 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.86 / 13.86 | 0.0 / 0.0 | 574.27 / 574.22 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| mam | 13.86 / 13.87 | 1.0 / 1.0 | 113.24 / 113.34 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| ponder | 82.59 / 82.59 | 0.0 / 0.11 | 203.65 / 203.93 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.61 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 15.96 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.2 (base 361.53) | 5.99 (base 5.48) |
| factory_flat | 15.96 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.02 (base 360.27) | 3.48 (base 5.48) |
| sift | 37.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.67 (base 379.69) | 5.99 (base 4.24) |
| hub | 20.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.19 (base 392.07) | 5.99 (base 5.99) |
| mam | 21.52 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.29 (base 404.98) | 5.99 (base 7.73) |
| ponder | 87.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.02 (base 403.64) | 5.99 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42756 (base 43652) | 396.16 (base 392.54) | 5.81 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.28 (base 393.74) | 5.81 (base 8.24) |
| kinetics | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.56 (base 396.01) | 5.81 (base 8.06) |
| kinetics_instancing | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 362.12 (base 360.95) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 15.96 / 16 (28.72) | 179.31 / 226 (29.91) | median and average, at most vanilla |
| factory_flat | 15.96 / 16 (29.59) | 178.92 / 226 (30.0) | median and average, at most vanilla |
| sift | 37.0 / 37 (13.23) | 550.95 / 578 (24.55) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (29.73) | 161.79 / 208 (29.99) | median and average, x 1.10 + 2 |
| mam | 21.52 / 21 (29.78) | 199.78 / 246 (30.02) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.85) | 180.73 / 227 (29.97) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.66) | 127.92 / 175 (30.01) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 111.0 / 158 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 10.67 / 11 (30.01) | 126.92 / 174 (30.0) | median and average, at most vanilla |
| kinetics_instancing | 10.67 / 11 (30.0) | 126.92 / 174 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.918 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.211 | 32.0 / 20.211 | 0.0 / 0.0 | 416.0 / 34.156 |
| ponder | 32.0 / 17.471 | 32.0 / 17.471 | 0.0 / 0.0 | 416.0 / 29.241 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.776 | 8.0 / 0.776 | 0.0 / 0.0 | 256.0 / 1.122 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14382.972 (27807.111) | 48.276 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 19 / 2 | 0.0 / 0 |
| factory_flat | 14422.389 (27873.909) | 48.258 | 1.0 | 149844 / 226644 | 100928 (2096945.128) | 5 / 1 | 0.0 / 0 |
| sift | 115790.947 (158223.068) | 26.818 | 1.433 | 4148 / 8052 | 0 (2097152.0) | 264 / 22 | 0.0 / 0 |
| hub | 474.798 (783.316) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| mam | 568.955 (925.553) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 7 / 0 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 2 / 3 | 0.0 / 0 |
| hologram | 3670.179 (6346.685) | 42.172 | 1.0 | 45668 / 44356 | 0 (2097152.0) | 4 / 0 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics | 5437.047 (10385.28) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.985 (35) | 2.218 (35) | 2.248 | 5.196 (12) | 0 | 804 / 0 | 11.937 / 13.82 | 7.102 / 9.073 |
| factory_flat | 2.806 (68) | 1.194 (69) | 2.35 | 2.297 (13) | 0 | 609 / 0 | 2.521 / 2.542 | 0.772 / 0.748 |
| sift | 1.619 (41) | 1.142 (41) | 1.418 | None (0) | 0 | 1350 / 0 | 8.729 / 10.39 | 4.212 / 5.888 |
| hub | 0.442 (8) | 0.174 (8) | 2.54 | None (0) | 0 | 1407 / 0 | 8.582 / 10.27 | 4.174 / 5.857 |
| mam | 0.564 (4) | 0.219 (4) | 2.575 | None (0) | 0 | 1717 / 0 | 8.415 / 10.649 | 4.613 / 6.841 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1718 / 0 | 8.41 / 10.643 | 4.608 / 6.837 |
| hologram | 2.26 (13) | 0.434 (25) | 5.207 | None (0) | 0 | 1751 / 0 | 8.293 / 10.499 | 4.476 / 6.67 |
| create_ct | 0.93 (53) | 0.386 (60) | 2.409 | None (0) | 0 | 1807 / 0 | 8.117 / 10.245 | 4.344 / 6.197 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1902 / 0 | 7.836 / 9.847 | 4.144 / 5.723 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 149 / 0 | 7.222 / 10.022 | 3.72 / 3.526 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.258 | 34.69 | 16 (vanilla 28) | 96100 | 24.836 / 0.28 | 1.511 / 28.0 | 2.566 | 1636 / 0 | 5.196 (10.791) |
| factory_flat | plain, one multi-draw per region and layer | 4.27 | 34.821 | 16 (vanilla 28) | 96100 | 2.78 / 0.024 | 1.511 / 8.0 | 2.566 | 823 / 0 | 2.297 (2.657) |
| sift | plain, one multi-draw per region and layer | 17.064 | 320.208 | 16 (vanilla 28) | 462560 | 22.797 / 0.314 | 7.389 / 16.0 | 12.352 | 2646 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.036 / 0.302 | 1.879 / 12.0 | 3.137 | 2736 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1187440 | 22.89 / 0.336 | 20.211 / 32.0 | 31.708 | 3377 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1014060 | 22.89 / 0.336 | 17.471 / 32.0 | 27.078 | 3378 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 22.738 / 0.331 | 0.238 / 32.0 | 0.367 | 3436 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.325 / 0.325 | 0.171 / 32.0 | 0.283 | 3540 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.312 / 0.342 | 0.372 / 32.0 | 0.624 | 3653 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 49340 | 6.137 / 0.315 | 0.776 / 8.0 | 1.318 | 167 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1590 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 596 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2376 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.425; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.63 / 69.0 (57.1) | 29.63 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 300.52 | 5544 / 0 |
| factory_flat | still | 29.76 / 69.0 (56.9) | 29.76 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 315.68 | 5796 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4554 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5032 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7748 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 444 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 113.143 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.255 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 150.16 / 88.731 | 0.139 / 0.043 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.65 / 574.66 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.86 | 1.0 / 1.0 | 112.83 / 112.97 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| ponder | 82.58 / 82.57 | 0.11 / 0.11 | 203.72 / 203.89 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 13.7 (base 14.25) | 15 (base 15) | 50660 (base 51624) | 367.14 (base 360.8) | 4.23 (base 5.46) |
| factory_flat | 13.7 (reported, not gated) | 15 (base 15) | 50660 (base 51500) | 360.0 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 16992 (base 81788) | 385.83 (base 379.18) | 4.23 (base 5.46) |
| hub | 20.56 (base 21.57) | 16 (base 16) | 65656 (base 66576) | 398.34 (base 391.05) | 4.23 (base 5.46) |
| mam | 21.55 (base 22.55) | 19 (base 19) | 22088 (base 23748) | 411.89 (base 404.61) | 8.23 (base 7.71) |
| ponder | 87.27 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 410.39 (base 403.47) | 8.23 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 401.7 (base 395.99) | 8.04 (base 8.29) |
| kinetics | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 400.54 (base 398.76) | 8.04 (base 8.04) |
| kinetics_instancing | 8.68 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 359.37 (base 359.57) | 3.46 (base 5.46) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 13.7 / 14 (29.01) | 111.4 / 154 (28.33) | median and average, at most vanilla |
| factory_flat | 13.7 / 14 (28.85) | 109.76 / 154 (29.04) | median and average, at most vanilla |
| sift | 23.0 / 23 (14.62) | 153.0 / 153 (13.42) | median, x 1.10 + 2 |
| hub | 20.56 / 20 (29.11) | 119.13 / 161 (28.36) | median and average, x 1.10 + 2 |
| mam | 21.55 / 21 (29.2) | 124.32 / 162 (27.26) | median, x 1.10 + 2 |
| ponder | 87.27 / 87 (29.43) | 181.21 / 227 (29.78) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (29.87) | 100.24 / 147 (29.9) | median and average, x 1.10 + 2 |
| kinetics | 8.67 / 9 (29.77) | 102.39 / 149 (29.84) | median and average, at most vanilla |
| kinetics_instancing | 8.68 / 9 (29.59) | 102.31 / 149 (29.92) | median and average, at most vanilla |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.89 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.297 | 32.0 / 20.297 | 0.0 / 0.0 | 416.0 / 34.118 |
| ponder | 32.0 / 17.545 | 32.0 / 17.545 | 0.0 / 0.0 | 416.0 / 29.204 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14637.879 (28240.383) | 48.167 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 21 / 18 | 0.0 / 0 |
| factory_flat | 14821.983 (28553.33) | 48.09 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 20 / 8 | 0.0 / 0 |
| sift | 115799.219 (158165.815) | 26.786 | 1.401 | 16992 / 16612 | 0 (2097152.0) | 292 / 268 | 0.0 / 0 |
| hub | 474.814 (783.344) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 20 / 23 | 0.0 / 0 |
| mam | 568.973 (925.582) | 38.528 | 1.25 | 41048 / 42688 | 0 (2097152.0) | 36 / 33 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 15 / 1 | 0.0 / 0 |
| create_ct | 2538.245 (5312.884) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| kinetics | 5437.107 (10385.396) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| kinetics_instancing | 5437.169 (10385.514) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 10 / 0 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.088 (35) | 2.6 (35) | 1.188 | 2.976 (12) | 0 | 961 / 0 | 8.772 / 12.055 | 5.02 / 7.239 |
| factory_flat | 2.076 (48) | 1.228 (43) | 1.691 | 1.954 (14) | 0 | 575 / 0 | 2.79 / 2.654 | 0.915 / 0.571 |
| sift | 1.2 (41) | 0.934 (40) | 1.285 | None (0) | 0 | 1505 / 0 | 6.691 / 9.269 | 2.849 / 4.86 |
| hub | 0.428 (8) | 0.2 (8) | 2.14 | None (0) | 0 | 1560 / 0 | 6.606 / 9.137 | 2.806 / 4.819 |
| mam | 0.568 (4) | 0.347 (4) | 1.637 | None (0) | 0 | 1872 / 0 | 6.552 / 9.262 | 3.07 / 5.216 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1873 / 0 | 6.549 / 9.257 | 3.069 / 5.212 |
| create_ct | 0.75 (41) | 0.533 (58) | 1.407 | None (0) | 0 | 1929 / 0 | 6.426 / 9.085 | 2.916 / 5.032 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 2024 / 0 | 6.219 / 8.757 | 2.701 / 4.772 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 144 / 0 | 9.712 / 10.586 | 4.082 / 4.317 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 35.531 | 16 (vanilla 28) | 96100 | 24.624 / 0.327 | 1.511 / 28.0 | 2.566 | 2005 / 0 | 2.976 (3.856) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 36.139 | 16 (vanilla 28) | 96100 | 2.421 / 0.031 | 1.511 / 8.0 | 2.566 | 715 / 0 | 1.954 (2.481) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 320.092 | 16 (vanilla 28) | 462560 | 22.82 / 0.349 | 7.389 / 16.0 | 12.352 | 3013 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.009 | 16 (vanilla 28) | 117492 | 22.184 / 0.337 | 1.879 / 12.0 | 3.137 | 3100 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1192196 | 22.978 / 0.362 | 20.297 / 32.0 | 31.835 | 3748 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1018112 | 22.978 / 0.362 | 17.545 / 32.0 | 27.187 | 3749 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.634 / 0.357 | 0.171 / 32.0 | 0.283 | 3841 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 22.616 / 0.372 | 0.372 / 32.0 | 0.624 | 3954 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 5.774 / 0.193 | 0.372 / 8.0 | 0.624 | 186 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1758 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 583 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 585 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 598 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 30.47 / 69.0 (55.8) | 30.47 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 297.42 | 5586 / 0 |
| factory_flat | still | 31.08 / 69.0 (55.0) | 31.08 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 349.39 | 5460 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5037 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4930 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7592 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 745 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 740 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 97.703 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 96.069 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 97.606 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 101.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.96 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.88 / 13.83 | 0.0 / 0.0 | 574.77 / 573.45 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.88 / 13.83 (8.0 / 8.0) |
| mam | 13.87 / 13.88 | 1.0 / 1.0 | 113.5 / 113.47 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| ponder | 82.59 / 82.58 | 0.12 / 0.11 | 204.0 / 203.88 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.61 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.68 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.08 (base 361.53) | 4.24 (base 5.48) |
| factory_flat | 16.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.93 (base 360.27) | 3.48 (base 5.48) |
| sift | 38.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.49 (base 379.69) | 4.24 (base 4.24) |
| hub | 21.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.98 (base 392.07) | 4.24 (base 5.99) |
| mam | 22.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.61 (base 404.98) | 8.24 (base 7.73) |
| ponder | 88.23 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 406.55 (base 403.64) | 8.24 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43316 (base 43652) | 396.23 (base 392.54) | 8.06 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.23 (base 393.74) | 8.06 (base 8.24) |
| kinetics | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.44 (base 396.01) | 8.06 (base 8.06) |
| kinetics_instancing | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 361.34 (base 360.95) | 3.48 (base 5.48) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 16.68 / 17 (28.96) | 179.31 / 226 (29.91) | median and average, at most vanilla |
| factory_flat | 16.67 / 17 (29.79) | 178.92 / 226 (30.0) | median and average, at most vanilla |
| sift | 38.0 / 38 (14.64) | 550.95 / 578 (24.55) | median, x 1.10 + 2 |
| hub | 21.54 / 21 (29.05) | 161.79 / 208 (29.99) | median and average, x 1.10 + 2 |
| mam | 22.54 / 22 (29.71) | 199.78 / 246 (30.02) | median, x 1.10 + 2 |
| ponder | 88.23 / 88 (29.96) | 180.73 / 227 (29.97) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.97) | 127.92 / 175 (30.01) | median, at most vanilla |
| create_ct | 7.67 / 8 (30.0) | 111.0 / 158 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 11.67 / 12 (29.98) | 126.92 / 174 (30.0) | median and average, at most vanilla |
| kinetics_instancing | 11.67 / 12 (30.0) | 126.92 / 174 (30.01) | median and average, at most vanilla |

Terrain GPU memory, siftec old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.389 | 16.0 / 7.389 | 0.0 / 0.0 | 416.0 / 12.918 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.204 | 32.0 / 20.204 | 0.0 / 0.0 | 416.0 / 34.156 |
| ponder | 32.0 / 17.452 | 32.0 / 17.452 | 0.0 / 0.0 | 416.0 / 29.241 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.853 | 8.0 / 0.853 | 0.0 / 0.0 | 256.0 / 1.122 |


Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13584.329 (26449.415) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 18 / 2 | 0.0 / 0 |
| factory_flat | 13583.386 (26447.567) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 2 / 1 | 0.0 / 0 |
| sift | 115749.048 (158165.815) | 26.818 | 1.433 | 4148 / 8052 | 0 (2097152.0) | 292 / 22 | 0.0 / 0 |
| hub | 474.817 (783.348) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 17 / 1 | 0.0 / 0 |
| mam | 568.956 (925.556) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 8 / 0 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61212 / 61204 | 0 (2097152.0) | 0 / 3 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 45892 / 44356 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.493 (35) | 2.218 (35) | 2.026 | 5.097 (12) | 0 | 875 / 0 | 9.944 / 13.904 | 6.528 / 9.174 |
| factory_flat | 2.342 (69) | 1.194 (69) | 1.961 | 1.922 (13) | 0 | 608 / 0 | 2.921 / 2.257 | 0.904 / 0.589 |
| sift | 1.508 (41) | 1.142 (41) | 1.32 | None (0) | 0 | 1419 / 0 | 7.399 / 10.249 | 3.794 / 5.532 |
| hub | None (0) | 0.174 (8) | None | None (0) | 0 | 1470 / 0 | 7.275 / 10.114 | 3.749 / 5.463 |
| mam | 0.446 (4) | 0.219 (4) | 2.037 | None (0) | 0 | 1782 / 0 | 7.205 / 10.163 | 3.914 / 6.059 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1783 / 0 | 7.201 / 10.158 | 3.907 / 6.057 |
| hologram | 2.088 (19) | 0.434 (25) | 4.811 | None (0) | 0 | 1816 / 0 | 7.108 / 10.044 | 3.811 / 5.95 |
| create_ct | 1.452 (50) | 0.386 (60) | 3.762 | None (0) | 0 | 1872 / 0 | 6.936 / 9.791 | 3.669 / 5.714 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1967 / 0 | 6.706 / 9.408 | 3.449 / 5.17 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 138 / 0 | 9.399 / 10.161 | 4.345 / 3.597 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.055 | 16 (vanilla 28) | 96100 | 27.331 / 0.305 | 1.511 / 28.0 | 2.566 | 1872 / 0 | 5.097 (13.793) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 2.78 / 0.024 | 1.511 / 8.0 | 2.566 | 823 / 0 | 1.922 (2.423) |
| sift | plain, one multi-draw per region and layer | 17.058 | 320.092 | 16 (vanilla 28) | 462560 | 24.918 / 0.332 | 7.389 / 16.0 | 12.352 | 2880 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.009 | 16 (vanilla 28) | 117492 | 24.246 / 0.322 | 1.879 / 12.0 | 3.137 | 2951 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1187424 | 24.668 / 0.351 | 20.204 / 32.0 | 31.708 | 3597 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1013340 | 24.668 / 0.351 | 17.452 / 32.0 | 27.059 | 3598 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 24.463 / 0.346 | 0.238 / 32.0 | 0.367 | 3662 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 24.052 / 0.34 | 0.171 / 32.0 | 0.283 | 3763 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 24.008 / 0.356 | 0.372 / 32.0 | 0.624 | 3876 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 54152 | 6.419 / 0.33 | 0.853 / 8.0 | 1.446 | 156 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1758 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 581 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6090 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6258 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5037 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4930 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 7696 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 750 / 0 |
| kinetics_instancing | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.03; 100.0) | 14400.0 | 745 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.645 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.004 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 113.143 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.003 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.255 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 152.464 / 91.557 | 0.154 / 0.049 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.86 / 13.87 | 0.0 / 0.0 | 574.48 / 574.66 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.86 | 1.0 / 1.0 | 113.16 / 112.97 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.86 (8.0 / 8.0) |
| ponder | 82.56 / 82.57 | 0.0 / 0.11 | 203.57 / 203.89 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.59 / 81.6 (75.0 / 75.0) |
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
| quicksilver-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | 24 | 593 / 592 |
| quicksilver-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 600 |
| quicksilver-vk | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 596 |
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| measure-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| measure-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| measure-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 11.39 | 103.77 | 227 | 123 | 955624 | [] |
| bench-plain | flythrough | 7.36 | 291.0 | 147 | 123 | 7002680 | [] |
| bench-plain | water_glass | 19.56 | 66.89 | 208 | 124 | 16808 | [] |
| bench-plain | nether | 19.35 | 61.49 | 352 | 121 | 420252 | [] |
| bench-sodium | spawn | 10.61 | 120.12 | 212 | 147 | 2320 | [] |
| bench-sodium | flythrough | 7.03 | 312.2 | 140 | 159 | 268472 | [] |
| bench-sodium | water_glass | 19.41 | 62.36 | 278 | 135 | 10348 | [] |
| bench-sodium | nether | 25.52 | 50.78 | 8 | 129 | 263888 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 53.726 (50.0) | 728 / 728 | 1572 | 1 | 40568.181 | 11.001 (0.0) | 1194 |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-plain | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-plain | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-plain | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-sodium | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | nether | 3.6 | 3.6 (0) | 3.6 |  |
| core-bench-sodium | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | mobs | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | outline | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | occlusion | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | occlusion_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | occlusion_corner | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | translucent_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | particles | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | animation | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | animated_items | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | mobs | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | outline | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | occlusion | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | occlusion_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | occlusion_corner | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | translucent_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | particles | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | animation | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | animated_items | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | flat_plants | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-vk | spawn | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | water_glass | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | nether | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | mobs | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | outline | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | occlusion | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | occlusion_move | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | occlusion_corner | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | translucent_move | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | particles | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | animation | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | animated_items | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-2p-old | spawn | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | water_glass | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | nether | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | mobs | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | outline | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | occlusion | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | occlusion_move | 4.48 | 4.48 (0) | 4.48 |  |
| core-quicksilver-2p-old | occlusion_corner | 6.48 | 6.48 (0) | 6.48 |  |
| core-quicksilver-2p-old | translucent_move | 6.48 | 6.48 (0) | 6.48 |  |
| core-quicksilver-2p-old | particles | 6.48 | 6.48 (0) | 6.48 |  |
| core-quicksilver-2p-old | animation | 6.48 | 6.48 (0) | 6.48 |  |
| core-quicksilver-2p-old | animated_items | 6.48 | 6.48 (0) | 6.48 |  |
| core-quicksilver-2p-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-2p-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | mobs | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | outline | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | occlusion | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | occlusion_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | occlusion_corner | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | translucent_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | particles | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | animation | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | animated_items | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | spawn | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | water_glass | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | nether | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | mobs | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | outline | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | occlusion | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | occlusion_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | occlusion_corner | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | flat_plants | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-vk | spawn | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | water_glass | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | nether | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | mobs | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | outline | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | occlusion | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | occlusion_move | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | occlusion_corner | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | translucent_move | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | particles | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | animation | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | animated_items | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | flat_plants | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-sp-quicksilver | flythrough | 1.38 | 1.46 (119) | 1.46 |  |
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
| siftec-measure-vk | kinetics_instancing | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-2p-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-2p-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-2p-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-2p-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-2p-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-2p-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-2p-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-2p-old | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-2p-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-2p-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-full | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-full | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-full | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-full | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-full | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | sift | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | hub | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | mam | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | ponder | 5.99 | 5.99 (0) | 5.99 |  |
| siftec-quicksilver-old | hologram | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-old | create_ct | 5.81 | 5.81 (0) | 5.81 |  |
| siftec-quicksilver-old | kinetics | 5.81 | 5.81 (0) | 5.81 |  |
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

Rises of 4 MB or more: siftec-measure-full/mam: between scenes +4.00; siftec-measure-old/mam: between scenes +4.00; siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-2p-old/mam: between scenes +4.00; siftec-quicksilver-full/mam: between scenes +4.00; siftec-quicksilver-vk/mam: between scenes +4.00

