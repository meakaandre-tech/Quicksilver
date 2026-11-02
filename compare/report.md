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
| spawn | 0.0558 | 10.05 | 0.0664 | 0.0468 | 0.0598 | 0.0482 |
| flythrough | 0.0 | 14.95 | 0.001 | 0.001 | 0.0011 | 0.001 |
| water_glass | 0.0044 | 6.45 | 0.0058 | 0.0036 | 0.005 | 0.0041 |
| nether | 0.0 | 0.8 | 0.0003 | 0.0003 | 0.0003 | 0.0463 |
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
| translucent_move | 0.0003 | 0.3 | 0.0003 | 0.0004 | 0.0001 | 0.0001 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0003 | 0.0008 | 0.0004 | 0.0005 |
| translucent_move.x2414 | 0.0 | 0.3 | 0.0002 | 0.0002 | 0.0001 | 0.0003 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0001 | 0.0002 | 0.0002 | 0.0001 |
| translucent_move.low | 0.0003 | 0.3 | 0.0011 | 0.0012 | 0.0014 | 0.0012 |
| translucent_move.back | 0.0 | 0.3 | 0.0 | 0.0003 | 0.0001 | 0.0001 |
| translucent_move.bare_back | 0.0002 | 0.3 | 0.0 | 0.0002 | 0.0002 | 0.0001 |
| water_glass_oit | 0.0048 | 0.3 | 0.0044 | 0.0055 | 0.0038 | 0.0039 |
| translucent_move_oit | 0.0001 | 0.3 | 0.0002 | 0.0001 | 0.0002 | 0.0 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0005 | 0.0008 | 0.0008 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.0001 | 0.0002 | 0.0002 | 0.0002 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0003 | 0.0003 | 0.0001 | 0.0003 |
| translucent_move_oit.low | 0.0009 | 0.3 | 0.0016 | 0.0013 | 0.0012 | 0.0012 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0 | 0.0002 | 0.0002 | 0.0002 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0 | 0.0003 | 0.0001 | 0.0003 |
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
| spawn | 93.2 | 18057 | 304 (818) | 233 (734) | 341 (922) | 302 (823) |
| flythrough | 97.24 | 6020 | 47 (299) | 47 (299) | 51 (299) | 47 (299) |
| water_glass | 95.81 | 25508 | 28 (2626) | 16 (2614) | 21 (2731) | 17 (2615) |
| nether | 99.42 | 905 | 3 (458) | 3 (458) | 3 (470) | 427 (859) |
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
| translucent_move | 96.93 | 13 | 3 (78) | 6 (81) | 2 (68) | 2 (77) |
| translucent_move.x2404 | 95.93 | 15 | 3 (103) | 6 (106) | 4 (88) | 7 (107) |
| translucent_move.x2414 | 95.86 | 13 | 3 (106) | 1 (104) | 2 (99) | 3 (106) |
| translucent_move.x2424 | 96.74 | 13 | 1 (78) | 3 (80) | 3 (70) | 2 (79) |
| translucent_move.low | 96.11 | 41 | 14 (20) | 11 (17) | 16 (18) | 13 (19) |
| translucent_move.back | 96.93 | 13 | 2 (79) | 4 (79) | 1 (67) | 2 (77) |
| translucent_move.bare_back | 96.9 | 13 | 3 (78) | 4 (80) | 1 (67) | 3 (78) |
| water_glass_oit | 95.81 | 57 | 19 (2619) | 30 (2631) | 19 (2733) | 19 (2620) |
| translucent_move_oit | 96.93 | 12 | 4 (79) | 3 (78) | 4 (70) | 3 (78) |
| translucent_move_oit.x2404 | 95.93 | 16 | 5 (105) | 5 (105) | 4 (88) | 4 (104) |
| translucent_move_oit.x2414 | 95.86 | 10 | 2 (106) | 5 (108) | 1 (98) | 4 (108) |
| translucent_move_oit.x2424 | 96.74 | 15 | 2 (79) | 1 (79) | 1 (67) | 2 (79) |
| translucent_move_oit.low | 96.11 | 40 | 17 (23) | 14 (20) | 14 (16) | 14 (19) |
| translucent_move_oit.back | 96.93 | 12 | 1 (76) | 2 (77) | 5 (72) | 1 (77) |
| translucent_move_oit.bare_back | 96.9 | 15 | 2 (77) | 1 (76) | 2 (68) | 1 (76) |
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
| spawn | 0.4392 / 3318 | 0.0406 / 187 | 0.0547 / 246 | 0.0406 / 187 |
| flythrough | 0.0001 / 1 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0037 / 12 | 0.004 / 19 | 0.0042 / 18 | 0.004 / 19 |
| nether | 0.0324 / 301 | 0.001 / 9 | 0.0 / 0 | 0.001 / 9 |
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
| translucent_move | 0.0002 / 0 | 0.0 / 2 | 0.0001 / 1 | 0.0 / 2 |
| translucent_move.x2404 | 0.0003 / 3 | 0.0003 / 2 | 0.0001 / 2 | 0.0003 / 2 |
| translucent_move.x2414 | 0.0 / 1 | 0.0002 / 0 | 0.0 / 2 | 0.0002 / 0 |
| translucent_move.x2424 | 0.0001 / 2 | 0.0001 / 4 | 0.0 / 0 | 0.0001 / 4 |
| translucent_move.low | 0.0004 / 3 | 0.0007 / 4 | 0.0007 / 7 | 0.0007 / 4 |
| translucent_move.back | 0.0001 / 2 | 0.0001 / 1 | 0.0002 / 1 | 0.0001 / 1 |
| translucent_move.bare_back | 0.0 / 4 | 0.0002 / 2 | 0.0002 / 0 | 0.0002 / 2 |
| water_glass_oit | 0.0033 / 8 | 0.0048 / 26 | 0.0034 / 16 | 0.0048 / 26 |
| translucent_move_oit | 0.0 / 1 | 0.0 / 0 | 0.0001 / 0 | 0.0 / 0 |
| translucent_move_oit.x2404 | 0.0001 / 1 | 0.0004 / 0 | 0.0004 / 0 | 0.0004 / 0 |
| translucent_move_oit.x2414 | 0.0001 / 2 | 0.0002 / 0 | 0.0002 / 1 | 0.0002 / 0 |
| translucent_move_oit.x2424 | 0.0001 / 1 | 0.0002 / 0 | 0.0 / 0 | 0.0002 / 0 |
| translucent_move_oit.low | 0.0002 / 0 | 0.0005 / 5 | 0.0009 / 6 | 0.0005 / 5 |
| translucent_move_oit.back | 0.0 / 0 | 0.0002 / 0 | 0.0002 / 3 | 0.0002 / 0 |
| translucent_move_oit.bare_back | 0.0001 / 1 | 0.0004 / 1 | 0.0002 / 1 | 0.0004 / 1 |
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
| spawn | 14.0 (base 13.6) | 14 (base 14) | 22440 (base 22476) | 253.34 (base 259.07) | 3.73 (base 3.99) |
| flythrough | 15.77 (reported, not gated) | 41 (reported, not gated) | 827072 (reported, not gated) | 308.43 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 9.92 (base 8.97) | 15 (base 15) | 11864 (base 15576) | 237.78 (base 250.02) | 3.73 (base 5.99) |
| nether | 13.98 (base 15.63) | 12 (base 12) | 10804 (base 19648) | 258.6 (base 273.53) | 3.73 (base 5.99) |
| mobs | 20.74 (base 19.77) | 17 (base 17) | 613548 (base 1010948) | 257.54 (base 268.37) | 3.73 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5596 (base 6356) | 257.44 (base 264.69) | 3.73 (base 5.48) |
| occlusion | 16.67 (base 15.67) | 15 (base 15) | 100028 (base 126320) | 263.1 (base 265.1) | 3.73 (base 4.24) |
| occlusion_move | 16.93 (reported, not gated) | 15 (reported, not gated) | 81920 (reported, not gated) | 263.59 (base 265.74) | 3.73 (base 4.24) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 267.61 (base 267.71) | 3.73 (base 5.48) |
| translucent_move | 8.92 (reported, not gated) | 15 (reported, not gated) | 5376 (reported, not gated) | 274.32 (base 267.48) | 3.73 (base 5.48) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 11304 (base 14688) | 236.19 (base 245.02) | 3.6 (base 3.73) |
| translucent_move_oit | 14.19 (reported, not gated) | 15 (reported, not gated) | 5616 (reported, not gated) | 239.1 (base 247.19) | 3.73 (base 3.73) |
| flat_plants | 16.98 (base 18.29) | 15 (base 15) | 4464 (base 9812) | 239.71 (base 246.92) | 3.48 (base 3.99) |
| renderer_off | 8.69 (base 7.67) | 14 (base 14) | 3628 (base 7164) | 231.6 (base 241.33) | 3.6 (base 4.12) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 265.22 (base 261.44) | 3.73 (base 5.99) |
| animation | 50 median (avg 40.98) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.54 (base 260.68) | 3.73 (base 5.99) |
| animated_items | 61 median (avg 47.73) (base 60) | 24 (base 23) | 22016 (base 21940) | 236.07 (base 239.81) | 3.73 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.0 / 14 (9.1) | 124.0 / 124 (15.1) | median and average, x 1.10 + 2 |
| flythrough | 15.77 / 16 (6.56) | 123.07 / 123 (10.23) | median and average, at most vanilla + 2 |
| water_glass | 9.92 / 10 (20.85) | 95.33 / 124 (26.53) | median, at most vanilla |
| nether | 13.98 / 17 (23.08) | 101.56 / 121 (23.94) | median, x 1.10 + 2 |
| mobs | 20.74 / 21 (26.83) | 96.18 / 134 (29.66) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 16.67 / 17 (29.94) | 94.4 / 133 (29.94) | median and average, x 1.10 + 2 |
| occlusion_move | 16.93 / 18 (29.73) | 94.27 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (29.99) | 82.2 / 121 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 8.92 / 9 (24.61) | 96.72 / 124 (26.14) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (10.15) | 129.0 / 129 (13.83) | median, at most vanilla |
| translucent_move_oit | 14.19 / 14 (10.37) | 129.0 / 129 (13.37) | median and average, at most vanilla |
| flat_plants | 16.98 / 20 (24.85) | 98.41 / 124 (25.6) | median, x 1.10 + 2 |
| renderer_off | 8.69 / 9 (29.1) | 84.33 / 123 (29.89) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.98 / 50 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.56 | 36.0 / 22.56 | 0.0 / 0.0 | 416.0 / 36.247 |
| flythrough | 112.0 / 84.118 | 112.0 / 84.118 | 0.0 / 0.0 | 416.0 / 150.427 |
| water_glass | 36.0 / 12.376 | 36.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.433 |
| nether | 20.0 / 15.305 | 20.0 / 15.305 | 0.0 / 0.0 | 256.0 / 26.881 |
| mobs | 16.0 / 9.61 | 16.0 / 9.61 | 0.0 / 0.0 | 256.0 / 16.797 |
| outline | 16.0 / 1.431 | 16.0 / 1.431 | 0.0 / 0.0 | 256.0 / 2.489 |
| occlusion | 20.0 / 2.834 | 20.0 / 2.834 | 0.0 / 0.0 | 416.0 / 4.259 |
| occlusion_move | 20.0 / 3.677 | 20.0 / 3.677 | 0.0 / 0.0 | 416.0 / 5.774 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.104 | 28.0 / 13.104 | 0.0 / 0.0 | 416.0 / 22.115 |
| water_glass_oit | 20.0 / 12.376 | 20.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.433 |
| translucent_move_oit | 28.0 / 12.693 | 28.0 / 12.693 | 0.0 / 0.0 | 416.0 / 21.402 |
| flat_plants | 24.0 / 14.157 | 24.0 / 14.157 | 0.0 / 0.0 | 416.0 / 23.993 |
| renderer_off | 24.0 / 8.682 | 24.0 / 8.682 | 0.0 / 0.0 | 416.0 / 15.245 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 435995.271 (590821.967) | 26.205 | 1.194 | 463920 / 1058936 | 441480 (2097152.0) | 181 / 301 | 0.0 / 0 |
| flythrough | 483882.046 (761852.275) | 36.486 | 1.084 | 2340624 / 7880828 | 2096160 (2097152.0) | 131 / 204 | 8.614 / 70 |
| water_glass | 112298.657 (195505.717) | 42.56 | 1.131 | 152296 / 17032 | 140096 (2097152.0) | 121 / 1 | 0.0 / 0 |
| nether | 29507.732 (42409.597) | 30.422 | 2.0 | 485356 / 352916 | 475200 (2097152.0) | 116 / 8 | 0.0 / 0 |
| mobs | 62047.545 (110830.388) | 44.016 | 0.967 | 613548 / 861496 | 0 (2097152.0) | 35 / 2 | 0.0 / 0 |
| outline | 1057.757 (2295.814) | 53.927 | 1.0 | 5596 / 6336 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 33033.055 (59002.337) | 44.014 | 1.256 | 100028 / 584592 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| occlusion_move | 24453.37 (43531.081) | 43.825 | 1.235 | 694288 / 1155384 | 618240 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_corner | 21835.576 (47191.225) | 53.73 | 1.214 | 35488 / 59512 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21625.142 (27664.561) | 21.831 | 1.004 | 894308 / 1566436 | 889024 (2097152.0) | 123 / 3 | 0.0 / 0 |
| water_glass_oit | 112584.604 (196003.535) | 42.56 | 1.131 | 12648 / 17144 | 0 (2097152.0) | 202 / 276 | 0.0 / 0 |
| translucent_move_oit | 21745.768 (27841.014) | 21.893 | 1.004 | 895248 / 1565596 | 889024 (2097152.0) | 207 / 267 | 0.0 / 0 |
| flat_plants | 9102.315 (12479.109) | 27.06 | 1.045 | 266608 / 271688 | 0 (2097152.0) | 124 / 9 | 0.0 / 0 |
| renderer_off | 17696.354 (33251.034) | 46.78 | 1.0 | 3628 / 7328 | 0 (2097152.0) | 49 / 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86680 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79744 / 122908 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.44 (102) | 2.115 (90) | 1.626 | 3.522 (51) | 0 | 876 / 0 | 9.684 / 12.883 | 4.62 / 6.936 |
| flythrough | 5.764 (1608) | 3.747 (1714) | 1.538 | 5.756 (1605) | 0 | 1397 / 0 | 7.113 / 10.384 | 4.466 / 6.813 |
| water_glass | 3.944 (15) | 0.988 (20) | 3.992 | 5.005 (1) | 0 | 1193 / 0 | 8.728 / 11.435 | 4.195 / 6.228 |
| nether | 2.836 (31) | 1.75 (24) | 1.621 | 2.948 (20) | 0 | 1814 / 0 | 7.268 / 9.45 | 3.63 / 5.328 |
| mobs | 2.013 (8) | 0.852 (7) | 2.363 | None (0) | 0 | 2048 / 0 | 7.098 / 9.131 | 3.526 / 5.161 |
| outline | 0.573 (13) | 0.223 (13) | 2.57 | None (0) | 0 | 2109 / 0 | 6.965 / 9.007 | 3.459 / 5.062 |
| occlusion | 1.41 (38) | 0.676 (56) | 2.086 | None (0) | 0 | 2240 / 0 | 6.838 / 8.859 | 3.374 / 4.91 |
| occlusion_move | 1.487 (62) | 1.225 (65) | 1.214 | 3.537 (17) | 0 | 2391 / 0 | 6.567 / 8.502 | 3.201 / 4.595 |
| occlusion_corner | 1.276 (110) | 0.808 (110) | 1.579 | 1.148 (1) | 0 | 2679 / 0 | 6.123 / 7.864 | 2.818 / 3.978 |
| translucent_move | 3.175 (113) | 2.391 (124) | 1.328 | 5.925 (31) | 0 | 3033 / 0 | 5.975 / 7.738 | 2.871 / 4.129 |
| water_glass_oit | 4.404 (154) | 1.896 (153) | 2.323 | None (0) | 0 | 414 / 0 | 8.742 / 10.787 | 4.868 / 6.04 |
| translucent_move_oit | 4.185 (215) | 2.447 (226) | 1.71 | 5.221 (25) | 0 | 963 / 0 | 6.134 / 7.696 | 3.563 / 4.454 |
| flat_plants | 2.007 (78) | 1.321 (92) | 1.519 | None (0) | 0 | 406 / 0 | 7.128 / 8.736 | 2.967 / 3.472 |
| renderer_off | 0.616 (25) | 0.315 (26) | 1.956 | None (0) | 0 | 327 / 0 | 8.202 / 11.174 | 4.083 / 5.46 |
| particles | 0.422 (30) | 0.177 (30) | 2.384 | None (0) | 0 | 3062 / 0 | 5.927 / 7.674 | 2.82 / 4.056 |
| animation | 1.026 (18) | 0.497 (18) | 2.064 | 1.043 (4) | 0 | 3137 / 0 | 5.813 / 7.519 | 2.746 / 3.907 |
| animated_items | 0.384 (42) | 0.187 (42) | 2.053 | 1.205 (2) | 0 | 3169 / 0 | 5.761 / 7.45 | 2.687 / 3.854 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.017 | 654.597 | 16 (vanilla 28) | 1363072 | 42.094 / 0.095 | 22.56 / 36.0 | 36.398 | 2368 / 0 | 3.522 (6.945) |
| flythrough | indirect, one multi-draw per arena and layer | 4.74 | 755.504 | 16 (vanilla 28) | 5091124 | 15.155 / 0.962 | 84.118 / 112.0 | 135.948 | 6415 / 0 | 5.756 (16.624) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 107.257 | 16 (vanilla 28) | 767236 | 34.032 / 0.083 | 12.376 / 36.0 | 20.487 | 3025 / 0 | 5.005 (4.993) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.093 | 16 (vanilla 28) | 962284 | 28.476 / 0.175 | 15.305 / 20.0 | 25.696 | 4066 / 0 | 2.948 (5.712) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.112 | 16 (vanilla 28) | 599804 | 25.791 / 0.153 | 9.61 / 16.0 | 16.016 | 4516 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 89660 | 25.317 / 0.152 | 1.431 / 16.0 | 2.394 | 4613 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 178044 | 24.167 / 0.144 | 2.834 / 20.0 | 4.754 | 4841 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.872 | 34.153 | 16 (vanilla 28) | 230456 | 22.825 / 0.136 | 3.677 / 20.0 | 6.154 | 5124 / 0 | 3.537 (12.402) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.052 | 60.863 | 16 (vanilla 28) | 122728 | 21.528 / 0.128 | 1.931 / 20.0 | 3.277 | 5521 / 0 | 1.148 (1.146) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.167 | 23.083 | 16 (vanilla 28) | 810152 | 18.691 / 0.117 | 13.104 / 28.0 | 21.633 | 6341 / 0 | 5.925 (13.604) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.025 | 115.569 | 16 (vanilla 28) | 767236 | 7.59 / 0.044 | 12.376 / 20.0 | 20.487 | 1088 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.208 | 37.251 | 16 (vanilla 28) | 784320 | 6.63 / 0.092 | 12.693 / 28.0 | 20.944 | 2405 / 0 | 5.221 (16.146) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.044 | 16 (vanilla 28) | 885232 | 5.792 / 0.01 | 14.157 / 24.0 | 23.638 | 919 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.038 | 16 (vanilla 28) | 545960 | 2.404 / 0.021 | 8.682 / 24.0 | 14.579 | 610 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 18.642 / 0.117 | 0.131 / 28.0 | 0.225 | 6387 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.494 / 0.116 | 0.302 / 28.0 | 0.518 | 6489 / 0 | 1.043 (1.47) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.443 / 0.116 | 0.153 / 28.0 | 0.261 | 6539 / 0 | 1.205 (2.011) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 1.0 | 0.0 | 0 | 0 | 41 (0.029 / 0.052 / 0.092; 0) | 0 | 28210 / 0 / 0 |
| flythrough | 186.053 | 1.0 | 0.0 | 0 | 0 | 840 (0.02 / 0.043 / 3.104; 0) | 41 | 24559 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1672 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.009 / 0.023 / 0.024; 0) | 32 | 1190 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.101 / 0.153 / 0.215; 0) | 180 | 3451 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 609 | 0 (None / None / None; 0) | 0 | 812 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 624 | 0 (None / None / None; 0) | 0 | 1456 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1988 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2332 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 345.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.037 (0.138; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.205 | 1.0 (0.0, 0.0) | 1.174 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.017 (0.081; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.149 (0.307; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 50.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.075 (0.187; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 52.681 | 10.0 (9.0, 2.358) | 6.0 (6.0, 2.279) | 0.067 (0.287; 0) | 0 | 2759 / 1493152 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 137.215 | 1.0 (0.0, 0.0) | 0.777 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 137.663 | 1.0 (0.0, 0.0) | 0.75 (0.0, 0.0) | 0.002 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 157.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.039; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 263.0 / 343.0 (23.3) | 263.0 / 80.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3680 / 0 |
| flythrough | two-phase | 313.89 / 402.78 (22.1) | 306.67 / 96.11 / 7.23 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 2842 / 0 |
| water_glass | two-phase | 54.0 / 140.0 (61.4) | 54.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 8944 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 30245 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10050 / 0 |
| outline | two-phase | 6.0 / 29.0 (79.3) | 6.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3473 / 0 |
| occlusion | two-phase | 26.0 / 50.0 (48.0) | 26.0 / 24.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3576 / 0 |
| occlusion_move | two-phase | 22.57 / 52.63 (57.1) | 22.51 / 30.12 / 0.06 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4483 / 0 |
| occlusion_corner | two-phase | 60.74 / 81.85 (25.8) | 60.66 / 21.19 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3167 / 0 |
| translucent_move | two-phase | 15.66 / 137.07 (88.6) | 15.63 / 121.43 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 14945 / 0 |
| water_glass_oit | two-phase | 54.0 / 140.0 (61.4) | 54.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4386 / 0 |
| translucent_move_oit | two-phase | 15.65 / 137.03 (88.6) | 15.6 / 121.43 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6204 / 0 |
| flat_plants | two-phase | 9.0 / 157.0 (94.3) | 9.0 / 148.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18352 / 0 |
| renderer_off | two-phase | 11.0 / 113.0 (90.3) | 11.0 / 102.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 14892 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 596 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 900 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 83.278 / 0.0 | 0.024 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.01 / 0.0 | 0.003 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.833 |
| water_glass | 86.575 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.706 / 52.701 | 0.017 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 95.793 / 7.511 | 0.929 / 0.721 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 38.58 / 9.017 | 0.071 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 77.508 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 87.954 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.778 / 11.791 | 0.006 / 0.014 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 47.248 / 47.256 | 0.012 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.58 / 13.572 | 0.006 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 89.795 / 7.5 | 0.838 / 0.73 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.005 / 0.942 | 0.01 / 0.007 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.007 / 0.056 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
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
| spawn | 50.23 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 252.38 (base 256.29) | 3.48 (base 3.73) |
| flythrough | 67.07 (reported, not gated) | 42 (reported, not gated) | 601468 (reported, not gated) | 308.54 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.86 (base 20.0) | 13 (base 14) | 7316 (base 10264) | 237.07 (base 249.83) | 3.48 (base 5.99) |
| nether | 23.82 (base 33.79) | 10 (base 11) | 4196 (base 10656) | 258.4 (base 272.57) | 3.48 (base 5.99) |
| mobs | 25.73 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 256.74 (base 268.23) | 3.48 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.48 (base 264.41) | 3.48 (base 3.73) |
| occlusion | 18.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 261.77 (base 264.64) | 3.48 (base 4.24) |
| occlusion_move | 24.03 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 262.56 (base 265.66) | 3.48 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 266.96 (base 267.41) | 5.48 (base 3.73) |
| translucent_move | 18.0 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 273.23 (base 268.19) | 5.48 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7540 (base 7604) | 236.37 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 239.06 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 16.87 (base 33.0) | 13 (base 13) | 1512 (base 1716) | 239.41 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.56 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 264.48 (base 261.4) | 5.48 (base 4.24) |
| animation | 50 median (avg 40.02) (base 49) | 13 (base 13) | 1716 (base 1716) | 260.8 (base 260.68) | 5.48 (base 4.24) |
| animated_items | 60 median (avg 47.01) (base 60) | 21 (base 22) | 21508 (base 21668) | 235.75 (base 239.53) | 5.48 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.23 / 50 (10.78) | 878.25 / 878 (10.02) | median and average, x 1.10 + 2 |
| flythrough | 67.07 / 67 (7.09) | 1003.01 / 1010 (6.07) | median and average, at most vanilla |
| water_glass | 19.86 / 20 (23.15) | 394.0 / 394 (15.98) | median, at most vanilla |
| nether | 23.82 / 26 (25.21) | 587.83 / 588 (16.29) | median, x 1.10 + 2 |
| mobs | 25.73 / 26 (27.32) | 322.4 / 329 (21.12) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 128.27 / 167 (30.0) | median, x 1.10 + 2 |
| occlusion | 18.67 / 19 (29.99) | 162.27 / 201 (29.99) | median and average, x 1.10 + 2 |
| occlusion_move | 24.03 / 24 (29.7) | 167.68 / 202 (29.97) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (29.99) | 163.14 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 18.0 / 18 (19.0) | 369.62 / 369 (16.91) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (11.13) | 401.0 / 401 (8.69) | median, at most vanilla |
| translucent_move_oit | 25.53 / 26 (9.4) | 385.9 / 388 (7.84) | median and average, at most vanilla |
| flat_plants | 16.87 / 20 (27.57) | 405.73 / 406 (17.82) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.95) | 300.92 / 327 (25.82) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.33 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.02 / 50 (30.0) | 156.22 / 191 (30.01) | median, x 1.10 + 2 |
| animated_items | 47.01 / 60 (30.0) | 167.42 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.825 | 36.0 / 22.825 | 0.0 / 0.0 | 416.0 / 37.627 |
| flythrough | 112.0 / 84.443 | 112.0 / 84.443 | 0.0 / 0.0 | 416.0 / 143.585 |
| water_glass | 36.0 / 12.376 | 36.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.539 |
| nether | 20.0 / 15.309 | 20.0 / 15.309 | 0.0 / 0.0 | 256.0 / 26.88 |
| mobs | 16.0 / 9.61 | 16.0 / 9.61 | 0.0 / 0.0 | 256.0 / 16.797 |
| outline | 16.0 / 1.431 | 16.0 / 1.431 | 0.0 / 0.0 | 256.0 / 2.489 |
| occlusion | 20.0 / 2.692 | 20.0 / 2.692 | 0.0 / 0.0 | 416.0 / 4.806 |
| occlusion_move | 20.0 / 3.48 | 20.0 / 3.48 | 0.0 / 0.0 | 416.0 / 6.185 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.908 | 28.0 / 12.908 | 0.0 / 0.0 | 416.0 / 22.44 |
| water_glass_oit | 20.0 / 12.376 | 20.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.433 |
| translucent_move_oit | 28.0 / 12.497 | 28.0 / 12.497 | 0.0 / 0.0 | 416.0 / 21.727 |
| flat_plants | 24.0 / 13.872 | 24.0 / 13.872 | 0.0 / 0.0 | 416.0 / 24.134 |
| renderer_off | 24.0 / 8.671 | 24.0 / 8.671 | 0.0 / 0.0 | 416.0 / 15.245 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 420523.972 (639910.158) | 34.284 | 1.775 | 578644 / 614784 | 571216 (2097152.0) | 215 / 200 | 0.0 / 0 |
| flythrough | 556318.128 (890338.894) | 37.516 | 1.084 | 2098116 / 7559376 | 2094720 (2097152.0) | 141 / 121 | 8.634 / 69 |
| water_glass | 112271.965 (195459.248) | 42.56 | 1.131 | 9444 / 253156 | 0 (2097152.0) | 70 / 319 | 0.0 / 0 |
| nether | 46280.683 (72876.06) | 36.494 | 1.867 | 167920 / 390772 | 162176 (2097152.0) | 153 / 325 | 0.0 / 0 |
| mobs | 62053.236 (110834.252) | 44.013 | 0.967 | 610676 / 612388 | 0 (2097152.0) | 40 / 20 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5476 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 31133.89 (55316.194) | 43.717 | 1.279 | 98148 / 877004 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 51929.155 (91663.993) | 43.348 | 1.229 | 658556 / 1117104 | 583488 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27753.663 (60453.776) | 54.091 | 1.272 | 32932 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 198910.484 (352201.226) | 43.524 | 1.188 | 894052 / 1560452 | 889024 (2097152.0) | 324 / 338 | 0.0 / 0 |
| water_glass_oit | 112542.676 (195924.586) | 42.558 | 1.131 | 8884 / 11428 | 0 (2097152.0) | 222 / 173 | 0.0 / 0 |
| translucent_move_oit | 199571.968 (353141.17) | 43.487 | 1.186 | 893604 / 1560628 | 889024 (2097152.0) | 188 / 156 | 0.0 / 0 |
| flat_plants | 9100.516 (12476.644) | 27.06 | 1.045 | 1716 / 4404 | 0 (2097152.0) | 137 / 356 | 0.0 / 0 |
| renderer_off | 17629.382 (33121.202) | 46.773 | 1.0 | 1380 / 3188 | 0 (2097152.0) | 5 / 0 | 0.0 / 0 |
| particles | 1698.822 (3676.106) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3043.426 (5226.144) | 41.765 | 1.087 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2244.441 (4827.279) | 53.505 | 1.0 | 79236 / 122740 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.626 (123) | 3.931 (106) | 1.177 | 4.767 (72) | 0 | 902 / 0 | 9.243 / 11.965 | 4.321 / 6.309 |
| flythrough | 6.485 (1650) | 6.445 (1570) | 1.006 | 6.486 (1649) | 0 | 1397 / 0 | 7.017 / 10.019 | 4.777 / 6.567 |
| water_glass | 2.997 (18) | 3.16 (16) | 0.948 | None (0) | 0 | 1220 / 0 | 8.339 / 10.891 | 3.96 / 5.94 |
| nether | 2.139 (29) | 3.097 (38) | 0.691 | 2.235 (15) | 0 | 1841 / 0 | 7.01 / 9.062 | 3.418 / 4.944 |
| mobs | 1.568 (7) | 0.708 (6) | 2.215 | None (0) | 0 | 2082 / 0 | 6.826 / 8.859 | 3.396 / 4.836 |
| outline | 0.719 (13) | 0.315 (12) | 2.283 | None (0) | 0 | 2142 / 0 | 6.725 / 8.743 | 3.334 / 4.749 |
| occlusion | 1.012 (40) | 2.037 (41) | 0.497 | None (0) | 0 | 2266 / 0 | 6.553 / 8.555 | 3.247 / 4.65 |
| occlusion_move | 1.569 (60) | 2.442 (59) | 0.643 | 3.432 (17) | 0 | 2410 / 0 | 6.305 / 8.223 | 3.082 / 4.388 |
| occlusion_corner | 1.465 (107) | 1.619 (97) | 0.905 | 1.598 (1) | 0 | 2687 / 0 | 5.86 / 7.663 | 2.742 / 4.06 |
| translucent_move | 3.694 (102) | 3.972 (127) | 0.93 | 5.512 (30) | 0 | 3033 / 0 | 5.761 / 7.565 | 2.821 / 4.173 |
| water_glass_oit | 4.205 (154) | 3.56 (150) | 1.181 | None (0) | 0 | 416 / 0 | 11.47 / 15.027 | 5.733 / 6.644 |
| translucent_move_oit | 3.74 (217) | 4.463 (209) | 0.838 | 5.395 (25) | 0 | 958 / 0 | 7.187 / 9.569 | 3.467 / 4.685 |
| flat_plants | 2.203 (99) | 1.68 (95) | 1.311 | None (0) | 0 | 411 / 0 | 8.591 / 10.068 | 3.685 / 4.197 |
| renderer_off | 0.72 (22) | 0.457 (21) | 1.575 | None (0) | 0 | 329 / 0 | 9.577 / 12.511 | 5.042 / 6.355 |
| particles | 0.377 (30) | 0.371 (24) | 1.016 | None (0) | 0 | 3062 / 0 | 5.715 / 7.503 | 2.786 / 4.118 |
| animation | 0.99 (18) | 0.917 (18) | 1.08 | 1.307 (4) | 0 | 3137 / 0 | 5.607 / 7.356 | 2.702 / 3.981 |
| animated_items | 0.444 (32) | 0.517 (32) | 0.859 | 0.966 (2) | 0 | 3169 / 0 | 5.557 / 7.289 | 2.646 / 3.949 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.181 | 728.353 | 16 (vanilla 28) | 1379692 | 42.016 / 0.097 | 22.825 / 36.0 | 36.842 | 2498 / 0 | 4.767 (9.913) |
| flythrough | plain, one multi-draw per region and layer | 57.326 | 905.624 | 16 (vanilla 28) | 5110084 | 15.146 / 0.982 | 84.443 / 112.0 | 136.454 | 6514 / 0 | 6.486 (18.084) |
| water_glass | plain, one multi-draw per region and layer | 14.03 | 107.231 | 16 (vanilla 28) | 767236 | 34.181 / 0.084 | 12.376 / 36.0 | 20.487 | 3163 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.579 | 72.669 | 16 (vanilla 28) | 962348 | 28.739 / 0.17 | 15.309 / 20.0 | 25.697 | 4198 / 0 | 2.235 (3.456) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.11 | 16 (vanilla 28) | 599812 | 25.966 / 0.147 | 9.61 / 16.0 | 16.017 | 4660 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 89660 | 25.511 / 0.146 | 1.431 / 16.0 | 2.394 | 4755 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 167632 | 24.473 / 0.14 | 2.692 / 20.0 | 4.476 | 4968 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 10.981 | 74.315 | 16 (vanilla 28) | 217140 | 23.249 / 0.133 | 3.48 / 20.0 | 5.798 | 5236 / 0 | 3.432 (7.551) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.907 | 16 (vanilla 28) | 122728 | 21.984 / 0.126 | 1.931 / 20.0 | 3.277 | 5619 / 0 | 1.598 (1.594) |
| translucent_move | plain, one multi-draw per region and layer | 12.011 | 246.653 | 16 (vanilla 28) | 797132 | 19.236 / 0.117 | 12.908 / 28.0 | 21.286 | 6412 / 0 | 5.512 (14.713) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.072 | 115.518 | 16 (vanilla 28) | 767244 | 7.625 / 0.043 | 12.376 / 20.0 | 20.488 | 1092 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.617 | 262.202 | 16 (vanilla 28) | 771280 | 6.724 / 0.093 | 12.497 / 28.0 | 20.595 | 2402 / 0 | 5.395 (13.113) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 866264 | 6.327 / 0.01 | 13.872 / 24.0 | 23.132 | 957 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 545380 | 2.419 / 0.021 | 8.671 / 24.0 | 14.563 | 611 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.175 / 0.116 | 0.131 / 28.0 | 0.225 | 6458 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.509 | 16 (vanilla 28) | 19416 | 19.024 / 0.115 | 0.302 / 28.0 | 0.518 | 6560 / 0 | 1.307 (1.948) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.671 | 16 (vanilla 28) | 9764 | 18.971 / 0.116 | 0.153 / 28.0 | 0.261 | 6609 / 0 | 0.966 (1.583) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 50 (0.025 / 0.037 / 0.052; 0) | 0 | 33696 / 0 / 0 |
| flythrough | 188.148 | 26.246 | 0.0 | 0 | 0 | 865 (0.03 / 0.049 / 9.083; 0) | 41 | 26717 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1856 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.017 / 0.019; 0) | 32 | 1190 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.099 / 0.15 / 0.18; 0) | 180 | 2667 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 669 | 0 (None / None / None; 0) | 0 | 892 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 567 | 0 (None / None / None; 0) | 0 | 1323 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2204 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 353.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.042 (0.096; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 438.408 | 1.0 (0.0, 0.0) | 1.169 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.053; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.128 (0.259; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.068 (0.113; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 50.338 | 10.0 (9.0, 2.358) | 6.0 (6.0, 2.284) | 0.064 (0.236; 0) | 0 | 2762 / 1494448 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 134.084 | 1.0 (0.0, 0.0) | 0.769 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 134.635 | 1.0 (0.0, 0.0) | 0.746 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 155.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.046; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 305.21 / 351.0 (13.0) | 305.21 / 0.0 / 0.0 | 0.14 | 0.0 (0.0, 0.0; 0.0) | 2000.0 | 2064 / 0 |
| flythrough | still | 405.35 / 405.8 (0.1) | 405.35 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 54.0 / 140.0 (61.4) | 54.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 9976 / 0 |
| nether | still | 55.23 / 300.0 (81.6) | 55.23 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 313.66 | 31034 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10275 / 0 |
| outline | still | 6.0 / 29.0 (79.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion | still | 26.0 / 48.0 (45.8) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion_move | still | 50.17 / 50.3 (0.2) | 50.17 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.72 / 81.85 (0.2) | 81.72 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 133.34 / 133.9 (0.4) | 133.34 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 54.0 / 140.0 (61.4) | 54.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4816 / 0 |
| translucent_move_oit | still | 133.37 / 133.94 (0.4) | 133.37 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 155.0 (94.2) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 20148 / 0 |
| renderer_off | still | 11.0 / 113.0 (90.3) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15300 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 604 / 0 |
| animation | still | 10.49 / 13.0 (19.3) | 10.49 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 309 / 0 |
| animated_items | still | 12.64 / 13.0 (2.8) | 12.64 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 54 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.245 / 0.093 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 100.711 / 0.093 | 0.02 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.145 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.845 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.07 / 52.088 | 0.028 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.718 | 0.834 / 0.75 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 48.531 / 10.315 | 0.082 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 108.46 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.31 / 12.228 | 0.007 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.81 / 54.861 | 0.012 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.91 / 11.825 | 0.005 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.236 | 0.733 / 0.913 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.708 / 1.603 | 0.013 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.147 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.667 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.044 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.277 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.005 / 0.008 | 56 (3) | 40.51 / 9.24 / 31.27 | 3 / 0 | 10.987 |
| animated_items | 136.757 / 28.028 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.51 / 7.97 / 32.54 | 0 / 0 | 9.0 |

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
| spawn | 14.15 (base 14.05) | 15 (base 15) | 23592 (base 27764) | 253.54 (base 257.2) | 3.46 (base 3.98) |
| flythrough | 13.07 (reported, not gated) | 21 (reported, not gated) | 136056 (reported, not gated) | 309.49 (base 318.06) | 3.46 (base 4.23) |
| water_glass | 8.69 (base 9.0) | 15 (base 15) | 11752 (base 15108) | 237.82 (base 244.39) | 3.46 (base 4.23) |
| nether | 12.37 (base 15.71) | 12 (base 12) | 10472 (base 19912) | 258.84 (base 268.95) | 3.46 (base 4.23) |
| mobs | 19.67 (base 19.97) | 16 (base 17) | 613388 (base 1008176) | 258.31 (base 264.31) | 3.46 (base 6.23) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5596 (base 6356) | 257.33 (base 264.58) | 3.46 (base 3.71) |
| occlusion | 15.67 (base 15.67) | 15 (base 15) | 100052 (base 126356) | 262.85 (base 264.78) | 5.46 (base 3.98) |
| occlusion_move | 16.07 (reported, not gated) | 15 (reported, not gated) | 82544 (reported, not gated) | 263.64 (base 265.16) | 5.46 (base 4.23) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 267.61 (base 266.66) | 5.46 (base 3.71) |
| translucent_move | 8.68 (reported, not gated) | 15 (reported, not gated) | 11116 (reported, not gated) | 274.07 (base 268.35) | 5.46 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 11976 (base 15024) | 236.71 (base 245.99) | 3.34 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10856 (reported, not gated) | 239.39 (base 248.38) | 3.46 (base 3.46) |
| flat_plants | 15.6 (base 18.96) | 15 (base 15) | 4560 (base 9864) | 239.34 (base 248.07) | 3.46 (base 5.98) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 3628 (base 7180) | 231.71 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 265.32 (base 261.4) | 5.46 (base 5.98) |
| animation | 50 median (avg 40.04) (base 49) | 15 (base 15) | 2164 (base 2056) | 261.64 (base 260.68) | 5.46 (base 5.98) |
| animated_items | 60 median (avg 47.14) (base 60) | 23 (base 23) | 21976 (base 21940) | 236.38 (base 239.74) | 5.46 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.15 / 14 (14.85) | 124.6 / 125 (9.43) | median and average, x 1.10 + 2 |
| flythrough | 13.07 / 13 (12.32) | 123.07 / 123 (5.36) | median and average, at most vanilla + 2 |
| water_glass | 8.69 / 9 (28.8) | 124.0 / 124 (15.3) | median, at most vanilla |
| nether | 12.37 / 16 (28.81) | 120.88 / 121 (15.23) | median, x 1.10 + 2 |
| mobs | 19.67 / 20 (29.89) | 134.0 / 134 (19.15) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (30.0) | 94.4 / 133 (29.94) | median and average, x 1.10 + 2 |
| occlusion_move | 16.07 / 17 (29.99) | 94.46 / 133 (29.93) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (30.0) | 82.59 / 121 (29.9) | median and average, x 1.10 + 2 |
| translucent_move | 8.68 / 9 (29.61) | 124.0 / 124 (16.1) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (16.54) | 129.0 / 129 (8.54) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (12.84) | 129.0 / 129 (8.16) | median and average, at most vanilla |
| flat_plants | 15.6 / 19 (28.52) | 124.0 / 124 (16.03) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.99) | 105.72 / 123 (23.47) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.34 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.04 / 50 (30.0) | 144.46 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.14 / 60 (30.0) | 155.46 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.803 | 36.0 / 22.803 | 0.0 / 0.0 | 416.0 / 36.709 |
| flythrough | 144.0 / 88.718 | 144.0 / 88.718 | 0.0 / 0.0 | 416.0 / 143.195 |
| water_glass | 36.0 / 12.376 | 36.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.433 |
| nether | 20.0 / 15.303 | 20.0 / 15.303 | 0.0 / 0.0 | 256.0 / 26.877 |
| mobs | 16.0 / 9.61 | 16.0 / 9.61 | 0.0 / 0.0 | 256.0 / 16.797 |
| outline | 16.0 / 1.431 | 16.0 / 1.431 | 0.0 / 0.0 | 256.0 / 2.489 |
| occlusion | 20.0 / 2.469 | 20.0 / 2.469 | 0.0 / 0.0 | 416.0 / 4.262 |
| occlusion_move | 20.0 / 3.351 | 20.0 / 3.351 | 0.0 / 0.0 | 416.0 / 5.796 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.838 | 28.0 / 12.838 | 0.0 / 0.0 | 416.0 / 22.092 |
| water_glass_oit | 20.0 / 12.376 | 20.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.433 |
| translucent_move_oit | 28.0 / 12.481 | 28.0 / 12.481 | 0.0 / 0.0 | 416.0 / 21.473 |
| flat_plants | 24.0 / 13.899 | 24.0 / 13.899 | 0.0 / 0.0 | 416.0 / 23.957 |
| renderer_off | 24.0 / 8.682 | 24.0 / 8.682 | 0.0 / 0.0 | 416.0 / 15.276 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 470345.345 (635649.345) | 26.006 | 1.174 | 421308 / 1059760 | 395456 (2097152.0) | 296 / 188 | 0.0 / 0 |
| flythrough | 570097.341 (911866.919) | 37.48 | 1.083 | 2123540 / 7696932 | 2096256 (2097152.0) | 246 / 107 | 4.907 / 71 |
| water_glass | 112224.159 (195376.021) | 42.56 | 1.131 | 13880 / 261080 | 0 (2097152.0) | 5 / 306 | 0.0 / 0 |
| nether | 49243.205 (72099.858) | 31.701 | 1.679 | 172100 / 288968 | 149632 (2097152.0) | 1 / 304 | 0.0 / 0 |
| mobs | 62035.739 (110809.3) | 44.016 | 0.967 | 613388 / 616328 | 0 (2097152.0) | 1 / 380 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5596 / 6336 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27311.443 (47671.32) | 42.709 | 1.302 | 100052 / 220108 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 49064.863 (85945.487) | 42.912 | 1.236 | 677196 / 1197328 | 600448 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27753.796 (60453.776) | 54.091 | 1.272 | 36188 / 59512 | 31552 (2097152.0) | 0 / 1 | 0.0 / 0 |
| translucent_move | 197583.791 (350252.878) | 43.588 | 1.181 | 899972 / 1565896 | 889024 (2097152.0) | 0 / 322 | 0.0 / 0 |
| water_glass_oit | 113610.285 (197914.842) | 42.596 | 1.13 | 336248 / 16248 | 320256 (2097152.0) | 330 / 170 | 0.0 / 0 |
| translucent_move_oit | 196786.336 (348466.211) | 43.528 | 1.181 | 899928 / 1565840 | 889024 (2097152.0) | 256 / 163 | 0.0 / 0 |
| flat_plants | 9099.937 (12475.849) | 27.06 | 1.045 | 5008 / 10160 | 0 (2097152.0) | 3 / 320 | 0.0 / 0 |
| renderer_off | 17695.443 (33249.323) | 46.78 | 1.0 | 3628 / 7328 | 0 (2097152.0) | 0 / 6 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 10548 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3060.775 (5266.531) | 41.883 | 1.085 | 86740 / 150268 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2247.566 (4834.464) | 53.51 | 1.0 | 79612 / 123160 | 57728 (2097152.0) | 0 / 4 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 1.846 (98) | 2.812 (102) | 0.656 | 2.023 (54) | 0 | 889 / 0 | 4.998 / 6.569 | 1.941 / 2.59 |
| flythrough | 2.799 (1680) | 6.25 (1499) | 0.448 | 2.799 (1679) | 0 | 1398 / 0 | 4.132 / 6.025 | 2.245 / 3.658 |
| water_glass | 1.263 (18) | 2.263 (15) | 0.558 | None (0) | 0 | 1211 / 0 | 4.324 / 5.659 | 1.814 / 2.412 |
| nether | 1.53 (21) | 2.658 (24) | 0.576 | 1.56 (13) | 0 | 1832 / 0 | 3.564 / 4.651 | 1.502 / 2.066 |
| mobs | 0.569 (13) | 0.867 (6) | 0.656 | None (0) | 0 | 2067 / 0 | 3.395 / 4.481 | 1.464 / 1.993 |
| outline | 0.237 (13) | 0.348 (12) | 0.681 | None (0) | 0 | 2127 / 0 | 3.34 / 4.414 | 1.444 / 1.965 |
| occlusion | 0.491 (42) | 0.791 (47) | 0.621 | None (0) | 0 | 2260 / 0 | 3.228 / 4.276 | 1.394 / 1.897 |
| occlusion_move | 0.845 (69) | 2.046 (61) | 0.413 | 1.84 (18) | 0 | 2411 / 0 | 3.1 / 4.101 | 1.346 / 1.86 |
| occlusion_corner | 0.657 (110) | 1.198 (92) | 0.548 | 0.603 (1) | 0 | 2693 / 0 | 2.876 / 3.778 | 1.206 / 1.654 |
| translucent_move | 1.41 (135) | 2.875 (114) | 0.49 | 1.947 (33) | 0 | 3051 / 0 | 2.769 / 3.674 | 1.228 / 1.676 |
| water_glass_oit | 1.501 (160) | 3.063 (150) | 0.49 | 2.479 (2) | 0 | 416 / 0 | 4.469 / 5.505 | 1.968 / 2.517 |
| translucent_move_oit | 1.746 (231) | 3.767 (211) | 0.463 | 2.725 (26) | 0 | 975 / 0 | 2.928 / 3.788 | 1.402 / 1.858 |
| flat_plants | 1.119 (87) | 1.456 (84) | 0.769 | None (0) | 0 | 414 / 0 | 4.388 / 5.043 | 1.409 / 1.601 |
| renderer_off | 0.32 (26) | 0.439 (21) | 0.729 | None (0) | 0 | 329 / 0 | 4.977 / 6.939 | 1.543 / 2.324 |
| particles | 0.224 (30) | 0.312 (30) | 0.718 | None (0) | 0 | 3079 / 0 | 2.747 / 3.644 | 1.213 / 1.659 |
| animation | 0.504 (18) | 0.912 (18) | 0.553 | 0.66 (4) | 0 | 3154 / 0 | 2.698 / 3.575 | 1.179 / 1.621 |
| animated_items | 0.19 (42) | 0.347 (32) | 0.548 | 0.569 (2) | 0 | 3186 / 0 | 2.674 / 3.543 | 1.171 / 1.596 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.01 | 723.139 | 16 (vanilla 28) | 1379208 | 42.852 / 0.083 | 22.803 / 36.0 | 36.829 | 2396 / 0 | 2.023 (3.557) |
| flythrough | indirect, one multi-draw per arena and layer | 3.012 | 931.74 | 16 (vanilla 28) | 5371216 | 15.475 / 0.995 | 88.718 / 144.0 | 143.427 | 6581 / 0 | 2.799 (9.074) |
| water_glass | indirect, one multi-draw per arena and layer | 3.005 | 107.185 | 16 (vanilla 28) | 767236 | 34.756 / 0.077 | 12.376 / 36.0 | 20.487 | 3077 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.003 | 71.918 | 16 (vanilla 28) | 962220 | 29.107 / 0.168 | 15.303 / 20.0 | 25.694 | 4099 / 0 | 1.56 (2.441) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 60.101 | 16 (vanilla 28) | 599804 | 26.4 / 0.153 | 9.61 / 16.0 | 16.016 | 4561 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 89660 | 25.925 / 0.152 | 1.431 / 16.0 | 2.394 | 4656 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 154212 | 24.803 / 0.145 | 2.469 / 20.0 | 4.118 | 4891 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.003 | 76.388 | 16 (vanilla 28) | 208780 | 23.455 / 0.137 | 3.351 / 20.0 | 5.575 | 5191 / 0 | 1.84 (5.377) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.907 | 16 (vanilla 28) | 122728 | 22.111 / 0.129 | 1.931 / 20.0 | 3.277 | 5584 / 0 | 0.603 (0.602) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.003 | 250.049 | 16 (vanilla 28) | 791928 | 19.198 / 0.12 | 12.838 / 28.0 | 21.147 | 6444 / 0 | 1.947 (4.287) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.015 | 117.361 | 16 (vanilla 28) | 767236 | 7.629 / 0.043 | 12.376 / 20.0 | 20.487 | 1104 / 0 | 2.479 (2.957) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.016 | 263.371 | 16 (vanilla 28) | 769384 | 6.966 / 0.115 | 12.481 / 28.0 | 20.545 | 2467 / 0 | 2.725 (8.681) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 22.039 | 16 (vanilla 28) | 868292 | 6.159 / 0.01 | 13.899 / 24.0 | 23.186 | 945 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 545952 | 2.42 / 0.021 | 8.682 / 24.0 | 14.578 | 615 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 19.151 / 0.12 | 0.131 / 28.0 | 0.225 | 6488 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.76 | 16 (vanilla 28) | 19416 | 18.999 / 0.119 | 0.302 / 28.0 | 0.518 | 6590 / 0 | 0.66 (0.922) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.711 | 16 (vanilla 28) | 9764 | 18.946 / 0.119 | 0.153 / 28.0 | 0.261 | 6640 / 0 | 0.569 (0.888) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 1.0 | 0.0 | 0 | 0 | 44 (0.016 / 0.028 / 0.037; 0) | 0 | 46332 / 0 / 0 |
| flythrough | 195.955 | 1.0 | 0.0 | 0 | 0 | 903 (0.01 / 0.027 / 0.104; 0) | 53 | 48401 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2312 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.006 / 0.008 / 0.009; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.063 / 0.094 / 0.098; 0) | 180 | 4151 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 993 | 0 (None / None / None; 0) | 0 | 1324 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 771 | 0 (None / None / None; 0) | 0 | 1799 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2284 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.084 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.079; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 439.401 | 1.0 (0.0, 0.0) | 1.121 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.188; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.105 (0.353; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.058 (0.133; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.364) | 6.0 (6.0, 2.275) | 0.045 (0.263; 0) | 0 | 2788 / 1509894 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.298 | 1.0 (0.0, 0.0) | 0.786 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.191 | 1.0 (0.0, 0.0) | 0.755 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 156.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.592 (0.0, 0.0) | 0.0 (0.009; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.151; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 302.65 / 349.07 (13.3) | 302.65 / 0.0 / 0.0 | 0.09 | 0.0 (0.0, 0.0; 0.0) | 1357.58 | 3365 / 0 |
| flythrough | still | 418.24 / 418.75 (0.1) | 418.24 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 54.0 / 140.0 (61.4) | 54.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 12384 / 0 |
| nether | still | 54.78 / 300.0 (81.7) | 54.78 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 224.61 | 35242 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11175 / 0 |
| outline | still | 6.0 / 29.0 (79.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion | still | 26.0 / 49.0 (46.9) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion_move | still | 51.19 / 51.32 (0.2) | 51.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.72 / 81.85 (0.2) | 81.72 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 135.8 / 136.16 (0.3) | 135.8 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 109 / 0 |
| water_glass_oit | still | 55.04 / 140.0 (60.7) | 55.04 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 43.5 | 7052 / 0 |
| translucent_move_oit | still | 134.77 / 135.62 (0.6) | 134.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 109 / 0 |
| flat_plants | still | 9.0 / 156.0 (94.2) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 21021 / 0 |
| renderer_off | still | 11.0 / 113.0 (90.3) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15300 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 303 / 0 |
| animated_items | still | 12.68 / 13.0 (2.5) | 12.68 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 48 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.601 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 118.875 / 5.458 | 0.032 / 0.011 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.616 / 0.0 | 0.006 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.874 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.19 / 51.208 | 0.023 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 6.944 | 0.882 / 0.715 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 39.758 / 6.26 | 0.062 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.923 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.372 / 13.373 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.338 / 53.338 | 0.017 / 0.018 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.368 / 11.471 | 0.008 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.0 | 1.0 / 0.902 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.459 / 2.336 | 0.017 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 97.872 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.004 / 0.045 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.793 / 32.294 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.003 / 0.005 | 56 (3) | 40.608 / 9.243 / 31.365 | 3 / 0 | 10.98 |
| animated_items | 136.793 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 51.53 (base 49.0) | 13 (base 13) | 7572 (base 6372) | 252.2 (base 256.29) | 3.73 (base 3.73) |
| flythrough | 69.17 (reported, not gated) | 38 (reported, not gated) | 385236 (reported, not gated) | 308.27 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.79 (base 20.0) | 13 (base 14) | 6868 (base 10264) | 236.99 (base 249.83) | 3.73 (base 5.99) |
| nether | 24.06 (base 33.79) | 10 (base 11) | 4284 (base 10656) | 257.92 (base 272.57) | 3.73 (base 5.99) |
| mobs | 26.69 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 256.77 (base 268.23) | 3.73 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.39 (base 264.41) | 3.73 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 262.34 (base 264.64) | 3.73 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 262.52 (base 265.66) | 3.73 (base 5.99) |
| occlusion_corner | 11.78 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 266.9 (base 267.41) | 3.73 (base 3.73) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 2968 (reported, not gated) | 273.04 (base 268.19) | 3.73 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7652 (base 7604) | 237.09 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 18.44 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 239.6 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 18.21 (base 33.0) | 13 (base 13) | 1940 (base 1716) | 238.72 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 231.56 (base 240.73) | 3.35 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 264.25 (base 261.4) | 3.73 (base 4.24) |
| animation | 50 median (avg 40.94) (base 49) | 13 (base 13) | 1716 (base 1716) | 260.58 (base 260.68) | 3.73 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 22 (base 22) | 21668 (base 21668) | 235.27 (base 239.53) | 3.73 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 51.53 / 52 (11.65) | 878.25 / 878 (10.02) | median and average, x 1.10 + 2 |
| flythrough | 69.17 / 68 (8.31) | 1003.01 / 1010 (6.07) | median and average, at most vanilla |
| water_glass | 20.79 / 21 (25.23) | 394.0 / 394 (15.98) | median, at most vanilla |
| nether | 24.06 / 27 (25.85) | 587.83 / 588 (16.29) | median, x 1.10 + 2 |
| mobs | 26.69 / 27 (28.92) | 322.4 / 329 (21.12) | median, x 1.10 + 2 |
| outline | 11.67 / 12 (30.0) | 128.27 / 167 (30.0) | median, x 1.10 + 2 |
| occlusion | 19.67 / 20 (30.0) | 162.27 / 201 (29.99) | median and average, x 1.10 + 2 |
| occlusion_move | 20.09 / 21 (30.0) | 167.68 / 202 (29.97) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.78 / 12 (30.0) | 163.14 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 11.13 / 11 (26.51) | 369.62 / 369 (16.91) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (11.84) | 401.0 / 401 (8.69) | median, at most vanilla |
| translucent_move_oit | 18.44 / 18 (12.24) | 385.9 / 388 (7.84) | median and average, at most vanilla |
| flat_plants | 18.21 / 21 (26.05) | 405.73 / 406 (17.82) | median, x 1.10 + 2 |
| renderer_off | 13.67 / 14 (29.94) | 300.92 / 327 (25.82) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (30.0) | 97.33 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.94 / 50 (30.0) | 156.22 / 191 (30.01) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.0) | 167.42 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.545 | 36.0 / 22.545 | 0.0 / 0.0 | 416.0 / 37.627 |
| flythrough | 112.0 / 86.079 | 112.0 / 86.079 | 0.0 / 0.0 | 416.0 / 143.585 |
| water_glass | 36.0 / 12.376 | 36.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.539 |
| nether | 20.0 / 15.307 | 20.0 / 15.307 | 0.0 / 0.0 | 256.0 / 26.88 |
| mobs | 16.0 / 9.61 | 16.0 / 9.61 | 0.0 / 0.0 | 256.0 / 16.797 |
| outline | 16.0 / 1.431 | 16.0 / 1.431 | 0.0 / 0.0 | 256.0 / 2.489 |
| occlusion | 20.0 / 2.607 | 20.0 / 2.607 | 0.0 / 0.0 | 416.0 / 4.806 |
| occlusion_move | 20.0 / 3.397 | 20.0 / 3.397 | 0.0 / 0.0 | 416.0 / 6.185 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.826 | 28.0 / 12.826 | 0.0 / 0.0 | 416.0 / 22.44 |
| water_glass_oit | 20.0 / 12.376 | 20.0 / 12.376 | 0.0 / 0.0 | 416.0 / 21.433 |
| translucent_move_oit | 28.0 / 12.415 | 28.0 / 12.415 | 0.0 / 0.0 | 416.0 / 21.727 |
| flat_plants | 24.0 / 13.775 | 24.0 / 13.775 | 0.0 / 0.0 | 416.0 / 24.134 |
| renderer_off | 24.0 / 8.671 | 24.0 / 8.671 | 0.0 / 0.0 | 416.0 / 15.245 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 391458.328 (590078.776) | 33.66 | 1.768 | 569556 / 614784 | 561984 (2097152.0) | 232 / 200 | 0.0 / 0 |
| flythrough | 490015.108 (771528.301) | 36.488 | 1.085 | 2107948 / 7559376 | 2092864 (2097152.0) | 166 / 121 | 6.958 / 84 |
| water_glass | 112252.282 (195424.98) | 42.56 | 1.131 | 147320 / 253156 | 140096 (2097152.0) | 13 / 319 | 0.0 / 0 |
| nether | 29500.952 (42399.853) | 30.422 | 2.0 | 263888 / 390772 | 259712 (2097152.0) | 129 / 325 | 0.0 / 0 |
| mobs | 62038.964 (110815.06) | 44.016 | 0.967 | 610676 / 612388 | 0 (2097152.0) | 3 / 20 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5476 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29689.93 (52374.043) | 43.312 | 1.279 | 404808 / 877004 | 306752 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 22408.007 (39485.229) | 43.25 | 1.26 | 654304 / 1117104 | 579328 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21835.873 (47206.083) | 53.744 | 1.215 | 32840 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21617.051 (27660.079) | 21.847 | 1.005 | 893624 / 1560452 | 889024 (2097152.0) | 132 / 338 | 0.0 / 0 |
| water_glass_oit | 112504.703 (195864.432) | 42.56 | 1.131 | 9220 / 11428 | 0 (2097152.0) | 236 / 173 | 0.0 / 0 |
| translucent_move_oit | 21792.828 (27958.115) | 22.052 | 1.006 | 895316 / 1560628 | 889024 (2097152.0) | 244 / 156 | 0.0 / 0 |
| flat_plants | 9101.469 (12477.95) | 27.06 | 1.045 | 2276 / 4404 | 0 (2097152.0) | 130 / 356 | 0.0 / 0 |
| renderer_off | 17629.382 (33121.202) | 46.773 | 1.0 | 1380 / 3188 | 0 (2097152.0) | 9 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.389 (5146.952) | 41.531 | 1.091 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79396 / 122740 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.923 (115) | 3.931 (106) | 0.744 | 2.715 (44) | 0 | 883 / 0 | 6.325 / 8.308 | 3.029 / 4.612 |
| flythrough | 4.494 (1645) | 6.445 (1570) | 0.697 | 4.494 (1644) | 0 | 1400 / 0 | 5.704 / 7.988 | 3.582 / 5.383 |
| water_glass | 2.145 (23) | 3.16 (16) | 0.679 | 3.044 (2) | 0 | 1202 / 0 | 5.727 / 7.395 | 2.839 / 4.099 |
| nether | 1.997 (30) | 3.097 (38) | 0.645 | 2.0 (17) | 0 | 1830 / 0 | 4.807 / 6.163 | 2.408 / 3.313 |
| mobs | 1.244 (8) | 0.708 (6) | 1.757 | None (0) | 0 | 2060 / 0 | 4.717 / 6.079 | 2.386 / 3.282 |
| outline | 0.406 (13) | 0.315 (12) | 1.289 | None (0) | 0 | 2120 / 0 | 4.647 / 6.007 | 2.331 / 3.246 |
| occlusion | 1.219 (63) | 2.037 (41) | 0.598 | 2.604 (12) | 0 | 2261 / 0 | 4.515 / 5.859 | 2.269 / 3.16 |
| occlusion_move | 1.497 (66) | 2.442 (59) | 0.613 | 3.423 (17) | 0 | 2409 / 0 | 4.339 / 5.645 | 2.172 / 3.041 |
| occlusion_corner | 0.952 (110) | 1.619 (97) | 0.588 | 4.429 (1) | 0 | 2689 / 0 | 4.066 / 5.266 | 1.916 / 2.7 |
| translucent_move | 2.385 (120) | 3.972 (127) | 0.6 | 4.554 (33) | 0 | 3059 / 0 | 3.972 / 5.223 | 2.006 / 2.816 |
| water_glass_oit | 3.389 (156) | 3.56 (150) | 0.952 | None (0) | 0 | 415 / 0 | 8.097 / 10.22 | 4.297 / 5.797 |
| translucent_move_oit | 2.856 (215) | 4.463 (209) | 0.64 | 3.935 (25) | 0 | 965 / 0 | 5.225 / 6.747 | 2.64 / 3.475 |
| flat_plants | 1.053 (90) | 1.68 (95) | 0.627 | None (0) | 0 | 419 / 0 | 6.244 / 6.783 | 2.312 / 2.279 |
| renderer_off | 0.416 (25) | 0.457 (21) | 0.91 | None (0) | 0 | 327 / 0 | 7.352 / 10.991 | 2.851 / 4.968 |
| particles | 0.257 (24) | 0.371 (24) | 0.693 | None (0) | 0 | 3086 / 0 | 3.941 / 5.181 | 1.968 / 2.79 |
| animation | 0.917 (18) | 0.917 (18) | 1.0 | 1.315 (4) | 0 | 3161 / 0 | 3.866 / 5.077 | 1.888 / 2.654 |
| animated_items | 0.254 (38) | 0.517 (32) | 0.491 | 0.709 (2) | 0 | 3193 / 0 | 3.832 / 5.03 | 1.861 / 2.613 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.168 | 653.806 | 16 (vanilla 28) | 1363128 | 40.597 / 0.143 | 22.545 / 36.0 | 36.399 | 2427 / 0 | 2.715 (5.776) |
| flythrough | plain, one multi-draw per region and layer | 58.361 | 765.512 | 16 (vanilla 28) | 5211928 | 15.054 / 0.949 | 86.079 / 112.0 | 139.173 | 6523 / 0 | 4.494 (13.152) |
| water_glass | plain, one multi-draw per region and layer | 14.028 | 107.212 | 16 (vanilla 28) | 767236 | 32.975 / 0.12 | 12.376 / 36.0 | 20.487 | 3105 / 0 | 3.044 (3.807) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.083 | 16 (vanilla 28) | 962348 | 27.658 / 0.196 | 15.307 / 20.0 | 25.697 | 4158 / 0 | 2.0 (3.07) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.104 | 16 (vanilla 28) | 599804 | 25.153 / 0.171 | 9.61 / 16.0 | 16.016 | 4600 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 89660 | 24.705 / 0.17 | 1.431 / 16.0 | 2.394 | 4695 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 163496 | 23.157 / 0.159 | 2.607 / 20.0 | 4.366 | 4986 / 0 | 2.604 (4.914) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.895 | 16 (vanilla 28) | 213316 | 21.907 / 0.15 | 3.397 / 20.0 | 5.696 | 5274 / 0 | 3.423 (10.628) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.887 | 16 (vanilla 28) | 122728 | 20.697 / 0.142 | 1.931 / 20.0 | 3.277 | 5663 / 0 | 4.429 (4.428) |
| translucent_move | plain, one multi-draw per region and layer | 4.391 | 23.085 | 16 (vanilla 28) | 793240 | 17.914 / 0.128 | 12.826 / 28.0 | 21.182 | 6531 / 0 | 4.554 (15.257) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.068 | 115.487 | 16 (vanilla 28) | 767236 | 7.636 / 0.043 | 12.376 / 20.0 | 20.487 | 1094 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.471 | 37.291 | 16 (vanilla 28) | 767356 | 6.838 / 0.106 | 12.415 / 28.0 | 20.491 | 2428 / 0 | 3.935 (9.443) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.042 | 16 (vanilla 28) | 860980 | 6.21 / 0.01 | 13.775 / 24.0 | 22.991 | 964 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 545364 | 2.431 / 0.021 | 8.671 / 24.0 | 14.563 | 610 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 17.878 / 0.128 | 0.131 / 28.0 | 0.225 | 6570 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 17.741 / 0.127 | 0.302 / 28.0 | 0.518 | 6672 / 0 | 1.315 (1.857) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.697 / 0.127 | 0.153 / 28.0 | 0.261 | 6719 / 0 | 0.709 (1.025) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 17.0 | 0.0 | 0 | 0 | 33 (0.024 / 0.038 / 0.114; 0) | 0 | 36115 / 0 / 0 |
| flythrough | 190.15 | 26.012 | 0.0 | 0 | 0 | 866 (0.02 / 0.04 / 3.027; 0) | 49 | 31755 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2020 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.012 / 0.025 / 0.03; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.102 / 0.156 / 0.177; 0) | 180 | 3710 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 711 | 0 (None / None / None; 0) | 0 | 948 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 735 | 0 (None / None / None; 0) | 0 | 1715 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2084 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 345.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.051 (0.164; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.329 | 1.0 (0.0, 0.0) | 1.15 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.008 (0.053; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.086 (0.144; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.05 (0.126; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 50.36 | 10.0 (9.0, 2.37) | 6.0 (6.0, 2.283) | 0.044 (0.217; 0) | 0 | 2792 / 1512242 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.008; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 134.194 | 1.0 (0.0, 0.0) | 0.779 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 134.478 | 1.0 (0.0, 0.0) | 0.755 (0.0, 0.0) | 0.002 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 155.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 113.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.004 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 263.0 / 343.0 (23.3) | 263.0 / 80.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4640 / 0 |
| flythrough | two-phase | 317.53 / 407.86 (22.1) | 311.68 / 96.18 / 5.85 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3823 / 0 |
| water_glass | two-phase | 54.0 / 140.0 (61.4) | 54.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10836 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 33927 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10800 / 0 |
| outline | two-phase | 6.0 / 29.0 (79.3) | 6.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3427 / 0 |
| occlusion | two-phase | 26.0 / 48.0 (45.8) | 26.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3278 / 0 |
| occlusion_move | two-phase | 22.41 / 50.31 (55.5) | 22.35 / 27.96 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4190 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.69 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3164 / 0 |
| translucent_move | two-phase | 15.66 / 134.05 (88.3) | 15.64 / 118.42 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15744 / 0 |
| water_glass_oit | two-phase | 54.0 / 140.0 (61.4) | 54.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 5074 / 0 |
| translucent_move_oit | two-phase | 15.69 / 133.94 (88.3) | 15.65 / 118.29 / 0.04 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7215 / 0 |
| flat_plants | two-phase | 9.0 / 155.0 (94.2) | 9.0 / 146.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18980 / 0 |
| renderer_off | two-phase | 11.0 / 113.0 (90.3) | 11.0 / 102.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 15198 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.245 / 0.534 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 118.363 / 0.85 | 0.029 / 0.013 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.424 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.85 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 50.61 / 50.562 | 0.013 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.505 | 0.834 / 0.805 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 35.584 / 8.591 | 0.077 / 0.007 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 108.46 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.455 / 13.453 | 0.005 / 0.009 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 56.035 / 56.076 | 0.011 / 0.019 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.558 / 12.531 | 0.006 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.5 | 0.733 / 0.963 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 5.193 / 4.86 | 0.021 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.147 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.667 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.007 / 0.037 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.005 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.757 / 28.063 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
siftec/quicksilver-full: bench factory_flat: median meshing time 0.789 ms per section against vanilla's compiler 0.512 ms (1.541x; limit 0.563 ms; 564 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench factory_flat: median meshing time 0.737 ms per section against vanilla's compiler 0.737 ms (1.0x; limit 0.811 ms; 574 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.591 ms per section against vanilla's compiler 0.465 ms (1.271x; limit 0.512 ms; 564 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.675 ms per section against vanilla's compiler 0.539 ms (1.252x; limit 0.593 ms; 574 pairs): reported, not gated (open gap)

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
- old-gpu-2p: 36 / 36

| scene | noise (vanilla a/b) % | limit % | full % | old-GPU % | Vulkan % | old-GPU two-phase % |
|---|---|---|---|---|---|---|
| factory | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| factory_flat | 0.0043 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0062 | 0.0062 | 0.0058 | 0.0062 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0017 | 0.55 | 0.0058 | 0.0065 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | 0.0066 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| factory | 95.6 | 500 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| sift | 95.02 | 100 | 48 (423) | 48 (423) | 52 (416) | 48 (423) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| mam | 98.54 | 10 | 0 (67167) | 0 (0) | 0 (106114) | 0 (0) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 38 (4279) | 40 (4280) | None (None) | 41 (4280) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| factory_flat | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0015 / 7 | 0.0024 / 9 | skipped | 0.0024 / 9 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 13.25 (base 12.22) | 15 (base 15) | 6228 (base 6976) | 365.34 (base 361.48) | 4.24 (base 5.48) |
| factory_flat | 13.25 (reported, not gated) | 15 (base 15) | 6116 (base 6844) | 362.04 (base 360.51) | 3.35 (base 5.48) |
| sift | 24.0 (base 23.0) | 18 (base 19) | 16904 (base 81788) | 383.23 (base 379.72) | 4.24 (base 5.87) |
| hub | 21.55 (base 21.53) | 16 (base 16) | 65656 (base 66576) | 395.53 (base 392.33) | 4.24 (base 5.48) |
| mam | 22.53 (base 22.53) | 19 (base 19) | 22088 (base 23748) | 408.39 (base 405.55) | 8.24 (base 8.12) |
| ponder | 88.23 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 407.27 (base 404.14) | 8.24 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 17 (base 17) | 43436 (base 44728) | 394.79 (base 392.95) | 8.06 (base 8.24) |
| create_ct | 7.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 395.72 (base 394.1) | 8.06 (base 10.24) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 13.25 / 13 (28.33) | 106.1 / 152 (29.72) | median and average, x 1.10 + 2 |
| factory_flat | 13.25 / 13 (29.49) | 106.39 / 152 (29.61) | median and average, x 1.10 + 2 |
| sift | 24.0 / 24 (15.78) | 153.0 / 153 (18.39) | median, x 1.10 + 2 |
| hub | 21.55 / 21 (29.48) | 114.95 / 161 (29.95) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.41) | 116.82 / 162 (29.69) | median, x 1.10 + 2 |
| ponder | 88.23 / 88 (29.95) | 180.57 / 227 (29.99) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.89) | 117.0 / 164 (30.0) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.85) | 100.0 / 147 (29.97) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.386 | 16.0 / 7.386 | 0.0 / 0.0 | 416.0 / 12.908 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 19.684 | 32.0 / 19.684 | 0.0 / 0.0 | 416.0 / 34.094 |
| ponder | 32.0 / 17.075 | 32.0 / 17.075 | 0.0 / 0.0 | 416.0 / 29.172 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13584.76 (26450.251) | 48.64 | 1.0 | 113844 / 190188 | 100928 (2097152.0) | 16 / 6 | 0.0 / 0 |
| factory_flat | 13583.712 (26448.207) | 48.64 | 1.0 | 113844 / 190188 | 100928 (2097152.0) | 1 / 4 | 0.0 / 0 |
| sift | 116380.292 (158216.686) | 26.442 | 1.404 | 16904 / 16564 | 0 (2097152.0) | 315 / 362 | 0.0 / 0 |
| hub | 474.805 (783.328) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 11 / 0 | 0.0 / 0 |
| mam | 568.966 (925.571) | 38.528 | 1.25 | 303100 / 304832 | 0 (2097152.0) | 16 / 3 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61248 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |
| hologram | 3670.137 (6346.613) | 42.172 | 1.0 | 46236 / 45512 | 0 (2097152.0) | 2 / 1 | 0.0 / 0 |
| create_ct | 2538.252 (5312.899) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.807 (35) | 3.135 (35) | 1.214 | 3.714 (12) | 0 | 789 / 0 | 10.052 / 13.114 | 5.736 / 7.367 |
| factory_flat | 3.353 (13) | 3.036 (6) | 1.104 | 3.353 (13) | 0 | 564 / 0 | 2.659 / 2.52 | 0.789 / 0.512 |
| sift | 1.419 (41) | 1.21 (40) | 1.173 | None (0) | 0 | 1327 / 0 | 7.463 / 9.699 | 3.429 / 4.845 |
| hub | 0.39 (8) | 0.232 (8) | 1.681 | None (0) | 0 | 1376 / 0 | 7.341 / 9.557 | 3.401 / 4.809 |
| mam | 0.565 (4) | 0.286 (4) | 1.976 | None (0) | 0 | 1670 / 0 | 7.299 / 9.971 | 3.66 / 5.608 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1671 / 0 | 7.295 / 9.965 | 3.66 / 5.605 |
| hologram | 2.138 (19) | 1.564 (13) | 1.367 | None (0) | 0 | 1704 / 0 | 7.298 / 9.925 | 3.653 / 5.578 |
| create_ct | 0.743 (58) | 0.572 (57) | 1.299 | None (0) | 0 | 1760 / 0 | 7.116 / 9.673 | 3.491 / 5.276 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.004 | 32.057 | 16 (vanilla 28) | 96100 | 24.308 / 0.244 | 1.511 / 28.0 | 2.566 | 1577 / 0 | 3.714 (7.037) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96084 | 1.463 / 0.004 | 1.511 / 12.0 | 2.566 | 632 / 0 | 3.353 (6.326) |
| sift | indirect, one multi-draw per arena and layer | 3.01 | 318.006 | 16 (vanilla 28) | 462736 | 22.359 / 0.287 | 7.386 / 16.0 | 12.356 | 2585 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 21.741 / 0.278 | 1.879 / 12.0 | 3.137 | 2660 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1155700 | 22.804 / 0.315 | 19.684 / 32.0 | 30.861 | 3274 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 990128 | 22.804 / 0.315 | 17.075 / 32.0 | 26.439 | 3275 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 22.609 / 0.31 | 0.238 / 32.0 | 0.367 | 3339 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.169 / 0.304 | 0.171 / 32.0 | 0.283 | 3445 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1896 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 590 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 589 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 597 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.003 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 241.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 5922 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6216 / 0 |
| sift | two-phase | 171.0 / 241.0 (29.0) | 171.0 / 70.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5460 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4998 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7644 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.885 / 0.0 | 0.547 / 0.56 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.713 / 10.61 | 0.019 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.435 / 0.0 | 0.278 / 0.571 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.571 / 11.069 | 0.073 / 0.025 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.276 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.333 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 147.993 / 91.44 | 0.15 / 0.045 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.64 / 574.71 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.86 / 13.87 | 1.0 / 1.0 | 112.71 / 113.25 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| ponder | 82.56 / 82.57 | 0.11 / 0.11 | 203.57 / 203.78 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.59 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.48 (base 20.24) | 13 (base 13) | 49024 (base 49024) | 365.84 (base 361.53) | 4.24 (base 5.48) |
| factory_flat | 16.56 (reported, not gated) | 13 (base 13) | 49132 (base 48916) | 361.82 (base 360.27) | 3.48 (base 5.48) |
| sift | 39.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.02 (base 379.69) | 4.24 (base 4.24) |
| hub | 20.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.75 (base 392.07) | 4.24 (base 5.99) |
| mam | 21.5 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.1 (base 404.98) | 8.24 (base 7.73) |
| ponder | 87.23 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 405.76 (base 403.64) | 8.24 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42868 (base 43652) | 396.05 (base 392.54) | 8.06 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 396.93 (base 393.74) | 8.06 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 16.48 / 16 (29.55) | 180.73 / 226 (29.29) | median and average, x 1.10 + 2 |
| factory_flat | 16.56 / 16 (29.99) | 180.76 / 226 (29.59) | median and average, x 1.10 + 2 |
| sift | 39.0 / 39 (16.73) | 578.0 / 578 (14.83) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (29.88) | 163.21 / 208 (29.37) | median and average, x 1.10 + 2 |
| mam | 21.5 / 21 (29.61) | 203.29 / 246 (28.83) | median, x 1.10 + 2 |
| ponder | 87.23 / 87 (29.89) | 181.04 / 227 (29.72) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (30.01) | 128.08 / 175 (29.96) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.01) | 111.16 / 158 (29.96) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 40.0 / 1.511 | 40.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.622 | 12.0 / 1.622 | 0.0 / 0.0 | 416.0 / 2.904 |
| sift | 16.0 / 7.386 | 16.0 / 7.386 | 0.0 / 0.0 | 416.0 / 12.935 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.168 | 32.0 / 20.168 | 0.0 / 0.0 | 416.0 / 33.987 |
| ponder | 32.0 / 17.46 | 32.0 / 17.46 | 0.0 / 0.0 | 416.0 / 29.145 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14359.31 (27766.714) | 48.286 | 1.0 | 156752 / 233368 | 100928 (2097152.0) | 11 / 11 | 0.0 / 0 |
| factory_flat | 14410.93 (27854.363) | 48.263 | 1.0 | 156752 / 233360 | 100928 (2096996.281) | 0 / 4 | 0.0 / 0 |
| sift | 116327.246 (158188.204) | 26.463 | 1.423 | 4148 / 8004 | 0 (2097152.0) | 334 / 296 | 0.0 / 0 |
| hub | 474.793 (783.308) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 2 / 12 | 0.0 / 0 |
| mam | 568.961 (925.563) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 9 / 8 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 2 / 4 | 0.0 / 0 |
| hologram | 3670.097 (6346.542) | 42.172 | 1.0 | 45780 / 45700 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.756 (35) | 4.364 (35) | 0.861 | 3.94 (12) | 0 | 959 / 0 | 11.379 / 15.207 | 8.367 / 11.109 |
| factory_flat | 3.8 (14) | 2.187 (13) | 1.738 | 3.797 (13) | 0 | 574 / 0 | 2.824 / 3.129 | 0.737 / 0.737 |
| sift | 1.823 (41) | 2.097 (41) | 0.869 | None (0) | 0 | 1496 / 0 | 8.492 / 11.305 | 4.582 / 6.428 |
| hub | 0.414 (8) | 0.291 (8) | 1.423 | None (0) | 0 | 1548 / 0 | 8.346 / 11.083 | 4.516 / 6.28 |
| mam | 0.683 (4) | 0.41 (4) | 1.666 | None (0) | 0 | 1857 / 0 | 8.022 / 10.944 | 4.544 / 6.808 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1858 / 0 | 8.018 / 10.938 | 4.544 / 6.807 |
| hologram | 2.705 (19) | 0.917 (19) | 2.95 | None (0) | 0 | 1891 / 0 | 7.931 / 10.799 | 4.481 / 6.517 |
| create_ct | 0.67 (53) | 0.754 (53) | 0.889 | None (0) | 0 | 1947 / 0 | 7.769 / 10.543 | 4.267 / 6.175 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.25 | 34.613 | 16 (vanilla 28) | 96100 | 27.995 / 0.325 | 1.511 / 40.0 | 2.566 | 2115 / 0 | 3.94 (8.459) |
| factory_flat | plain, one multi-draw per region and layer | 4.267 | 34.783 | 16 (vanilla 28) | 102988 | 1.469 / 0.004 | 1.622 / 12.0 | 2.75 | 644 / 0 | 3.797 (7.486) |
| sift | plain, one multi-draw per region and layer | 19.057 | 317.949 | 16 (vanilla 28) | 462736 | 25.621 / 0.346 | 7.386 / 16.0 | 12.356 | 3122 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 24.941 / 0.336 | 1.879 / 12.0 | 3.137 | 3201 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1185548 | 25.233 / 0.358 | 20.168 / 32.0 | 31.658 | 3841 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1013932 | 25.233 / 0.358 | 17.46 / 32.0 | 27.075 | 3842 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 25.03 / 0.353 | 0.238 / 32.0 | 0.367 | 3906 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 24.622 / 0.348 | 0.171 / 32.0 | 0.283 | 4007 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2010 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 592 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2408 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 241.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.55 / 69.0 (57.2) | 29.55 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 291.89 | 5796 / 0 |
| factory_flat | still | 29.73 / 69.0 (56.9) | 29.73 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 311.48 | 6048 / 0 |
| sift | still | 171.0 / 241.0 (29.0) | 171.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5810 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5066 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7696 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.53 / 0.0 | 0.528 / 0.538 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.364 / 10.253 | 0.018 / 0.007 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| factory_flat | 94.518 / 0.0 | 0.572 / 0.607 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.589 / 10.507 | 0.035 / 0.016 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (1) | 28.0 / 2.0 / 26.0 | 0 / 0 | 3.0 |
| hub | 94.685 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| mam | 96.736 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| ponder | 93.805 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |
| hologram | 93.411 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 145.426 / 90.061 | 0.138 / 0.043 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.85 | 0.0 / 0.0 | 574.29 / 573.97 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.85 (8.0 / 8.0) |
| mam | 13.83 / 13.87 | 1.0 / 1.0 | 111.61 / 112.99 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.83 / 13.87 (8.0 / 8.0) |
| ponder | 82.56 / 82.56 | 0.0 / 0.11 | 203.51 / 203.52 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.59 / 81.59 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 14.23 (base 14.25) | 15 (base 15) | 50784 (base 51624) | 364.12 (base 360.8) | 4.23 (base 5.46) |
| factory_flat | 13.67 (reported, not gated) | 15 (base 15) | 50660 (base 51500) | 360.26 (base 359.9) | 3.46 (base 3.46) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 16904 (base 81788) | 381.95 (base 379.18) | 4.23 (base 5.46) |
| hub | 20.53 (base 21.57) | 16 (base 16) | 65656 (base 66576) | 395.01 (base 391.05) | 4.23 (base 5.46) |
| mam | 21.52 (base 22.55) | 19 (base 19) | 22088 (base 23748) | 408.53 (base 404.61) | 8.23 (base 7.71) |
| ponder | 87.24 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 406.91 (base 403.47) | 8.23 (base 8.23) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 398.13 (base 395.99) | 8.04 (base 8.29) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 14.23 / 14 (29.81) | 117.85 / 154 (26.95) | median and average, x 1.10 + 2 |
| factory_flat | 13.67 / 14 (30.01) | 112.65 / 154 (28.28) | median and average, x 1.10 + 2 |
| sift | 23.0 / 23 (17.27) | 153.0 / 153 (11.51) | median, x 1.10 + 2 |
| hub | 20.53 / 20 (29.95) | 124.22 / 161 (27.12) | median and average, x 1.10 + 2 |
| mam | 21.52 / 21 (30.0) | 136.83 / 162 (24.36) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.99) | 181.05 / 227 (29.87) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (30.0) | 100.0 / 147 (29.96) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.511 | 12.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.386 | 16.0 / 7.386 | 0.0 / 0.0 | 416.0 / 12.908 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.34 | 32.0 / 20.34 | 0.0 / 0.0 | 416.0 / 33.984 |
| ponder | 32.0 / 17.589 | 32.0 / 17.589 | 0.0 / 0.0 | 416.0 / 29.142 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14608.943 (28191.03) | 48.179 | 1.0 | 159336 / 234848 | 100928 (2097152.0) | 4 / 7 | 0.0 / 0 |
| factory_flat | 13584.641 (26450.083) | 48.64 | 1.0 | 50660 / 51500 | 0 (2097152.0) | 0 / 4 | 0.0 / 0 |
| sift | 116348.267 (158173.148) | 26.442 | 1.404 | 16904 / 16564 | 0 (2097152.0) | 344 / 230 | 0.0 / 0 |
| hub | 474.79 (783.303) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 1 / 17 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 41048 / 42688 | 0 (2097152.0) | 8 / 28 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61268 / 61248 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.342 (35) | 3.194 (35) | 0.733 | 2.372 (12) | 0 | 787 / 0 | 7.6 / 10.075 | 3.38 / 4.886 |
| factory_flat | None (0) | None (0) | None | None (0) | 0 | 564 / 0 | 2.071 / 2.129 | 0.591 / 0.465 |
| sift | 1.101 (41) | 1.607 (40) | 0.685 | None (0) | 0 | 1323 / 0 | 5.513 / 7.288 | 2.054 / 2.95 |
| hub | 0.339 (8) | 0.314 (8) | 1.08 | None (0) | 0 | 1378 / 0 | 5.44 / 7.194 | 2.046 / 2.916 |
| mam | 0.502 (4) | 0.448 (4) | 1.121 | None (0) | 0 | 1695 / 0 | 5.382 / 7.328 | 2.286 / 3.535 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1696 / 0 | 5.379 / 7.324 | 2.283 / 3.517 |
| create_ct | 0.683 (60) | 1.101 (37) | 0.62 | None (0) | 0 | 1752 / 0 | 5.259 / 7.153 | 2.15 / 3.357 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 35.436 | 16 (vanilla 28) | 96100 | 24.073 / 0.367 | 1.511 / 28.0 | 2.566 | 1582 / 0 | 2.372 (3.335) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.053 | 16 (vanilla 28) | 96100 | 1.203 / 0.004 | 1.511 / 12.0 | 2.566 | 606 / 0 | None (None) |
| sift | indirect, one multi-draw per arena and layer | 3.009 | 317.919 | 16 (vanilla 28) | 462736 | 22.138 / 0.383 | 7.386 / 16.0 | 12.356 | 2588 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 21.446 / 0.369 | 1.879 / 12.0 | 3.137 | 2674 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1195052 | 22.498 / 0.391 | 20.34 / 32.0 | 31.911 | 3330 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1020964 | 22.498 / 0.391 | 17.589 / 32.0 | 27.263 | 3331 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.046 / 0.383 | 0.171 / 32.0 | 0.283 | 3439 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2076 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.003 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 241.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 30.38 / 69.0 (56.0) | 30.38 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 289.45 | 5754 / 0 |
| factory_flat | still | 27.0 / 69.0 (60.9) | 27.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6300 / 0 |
| sift | still | 171.0 / 241.0 (29.0) | 171.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6020 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5100 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7800 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 103.569 / 0.0 | 0.537 / 0.539 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.208 / 10.134 | 0.013 / 0.004 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 98.94 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 102.615 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 114.18 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.802 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.88 | 0.0 / 0.0 | 574.44 / 574.67 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| mam | 13.85 / 13.84 | 1.0 / 1.0 | 112.62 / 111.93 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.85 / 13.84 (8.0 / 8.0) |
| ponder | 82.57 / 82.57 | 0.0 / 0.11 | 203.7 / 203.69 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.6 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 17.23 (base 20.24) | 13 (base 13) | 49144 (base 49024) | 364.79 (base 361.53) | 5.99 (base 5.48) |
| factory_flat | 17.18 (reported, not gated) | 13 (base 13) | 48932 (base 48916) | 362.45 (base 360.27) | 3.48 (base 5.48) |
| sift | 40.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 382.82 (base 379.69) | 5.99 (base 4.24) |
| hub | 21.59 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 395.24 (base 392.07) | 5.99 (base 5.99) |
| mam | 22.53 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 408.72 (base 404.98) | 5.99 (base 7.73) |
| ponder | 88.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 407.42 (base 403.64) | 5.99 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43336 (base 43652) | 394.44 (base 392.54) | 5.81 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 395.62 (base 393.74) | 5.81 (base 8.24) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 17.23 / 17 (29.78) | 180.73 / 226 (29.29) | median and average, x 1.10 + 2 |
| factory_flat | 17.18 / 17 (29.91) | 180.76 / 226 (29.59) | median and average, x 1.10 + 2 |
| sift | 40.0 / 40 (15.59) | 578.0 / 578 (14.83) | median, x 1.10 + 2 |
| hub | 21.59 / 21 (28.32) | 163.21 / 208 (29.37) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (29.91) | 203.29 / 246 (28.83) | median, x 1.10 + 2 |
| ponder | 88.24 / 88 (29.69) | 181.04 / 227 (29.72) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.74) | 128.08 / 175 (29.96) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.98) | 111.16 / 158 (29.96) | median and average, x 1.10 + 2 |

Terrain GPU memory, siftec old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 12.0 / 1.583 | 12.0 / 1.583 | 0.0 / 0.0 | 416.0 / 2.904 |
| sift | 16.0 / 7.386 | 16.0 / 7.386 | 0.0 / 0.0 | 416.0 / 12.935 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.12 | 32.0 / 20.12 | 0.0 / 0.0 | 416.0 / 33.987 |
| ponder | 32.0 / 17.454 | 32.0 / 17.454 | 0.0 / 0.0 | 416.0 / 29.145 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |


Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.583 (26447.96) | 48.64 | 1.0 | 156760 / 233368 | 100928 (2097152.0) | 3 / 11 | 0.0 / 0 |
| factory_flat | 13583.446 (26447.693) | 48.64 | 1.0 | 156752 / 233360 | 100928 (2097152.0) | 1 / 4 | 0.0 / 0 |
| sift | 116352.926 (158223.125) | 26.463 | 1.423 | 4148 / 8004 | 0 (2097152.0) | 311 / 296 | 0.0 / 0 |
| hub | 474.837 (783.382) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 35 / 12 | 0.0 / 0 |
| mam | 568.95 (925.545) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 2 / 8 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 6 / 4 | 0.0 / 0 |
| hologram | 3670.168 (6346.667) | 42.172 | 1.0 | 46228 / 45700 | 0 (2097152.0) | 4 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 1 / 2 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 4.119 (35) | 4.364 (35) | 0.944 | 3.389 (12) | 0 | 788 / 0 | 10.193 / 13.472 | 6.093 / 8.294 |
| factory_flat | 3.436 (12) | 2.187 (13) | 1.571 | 3.436 (12) | 0 | 574 / 0 | 3.253 / 2.735 | 0.675 / 0.539 |
| sift | 1.27 (41) | 2.097 (41) | 0.606 | None (0) | 0 | 1329 / 0 | 7.505 / 9.861 | 3.494 / 5.296 |
| hub | 0.386 (8) | 0.291 (8) | 1.326 | None (0) | 0 | 1380 / 0 | 7.424 / 9.714 | 3.48 / 5.263 |
| mam | 0.552 (4) | 0.41 (4) | 1.346 | None (0) | 0 | 1689 / 0 | 7.564 / 10.299 | 3.858 / 6.142 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1690 / 0 | 7.56 / 10.293 | 3.852 / 6.137 |
| hologram | 1.884 (19) | 0.917 (19) | 2.055 | None (0) | 0 | 1723 / 0 | 7.584 / 10.218 | 3.889 / 6.06 |
| create_ct | 0.72 (55) | 0.754 (53) | 0.955 | None (0) | 0 | 1779 / 0 | 7.401 / 9.949 | 3.674 / 5.785 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 25.441 / 0.301 | 1.511 / 28.0 | 2.566 | 1621 / 0 | 3.389 (4.619) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.053 | 16 (vanilla 28) | 100592 | 1.437 / 0.004 | 1.583 / 12.0 | 2.686 | 638 / 0 | 3.436 (8.991) |
| sift | plain, one multi-draw per region and layer | 19.061 | 318.019 | 16 (vanilla 28) | 462736 | 23.294 / 0.33 | 7.386 / 16.0 | 12.356 | 2632 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.004 | 5.009 | 16 (vanilla 28) | 117492 | 22.628 / 0.32 | 1.879 / 12.0 | 3.137 | 2711 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1181548 | 23.459 / 0.347 | 20.12 / 32.0 | 31.551 | 3352 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1012452 | 23.459 / 0.347 | 17.454 / 32.0 | 27.035 | 3353 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.261 / 0.342 | 0.238 / 32.0 | 0.367 | 3417 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.833 / 0.335 | 0.171 / 32.0 | 0.283 | 3520 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1872 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 567 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2380 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 241.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6258 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6300 / 0 |
| sift | two-phase | 171.0 / 241.0 (29.0) | 171.0 / 70.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5460 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4794 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 7800 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 447 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.53 / 0.0 | 0.528 / 0.553 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.177 / 10.381 | 0.017 / 0.007 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.518 / 0.0 | 0.572 / 0.509 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.107 / 9.817 | 0.062 / 0.022 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.685 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 96.736 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.805 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.411 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 154.905 / 92.417 | 0.135 / 0.047 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.489 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.9 / 13.85 | 0.0 / 0.0 | 575.55 / 573.97 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.9 / 13.85 (8.0 / 8.0) |
| mam | 13.86 / 13.87 | 1.0 / 1.0 | 112.83 / 112.99 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / 13.87 (8.0 / 8.0) |
| ponder | 82.56 / 82.56 | 0.0 / 0.11 | 203.69 / 203.52 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.59 / 81.59 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 9.06 | 150.0 | 181 | 125 | 487388 | [] |
| bench-plain | flythrough | 4.91 | 415.94 | 98 | 123 | 8059728 | [] |
| bench-plain | water_glass | 16.28 | 67.79 | 325 | 124 | 330296 | [] |
| bench-plain | nether | 15.78 | 74.14 | 315 | 121 | 422332 | [] |
| bench-sodium | spawn | 10.93 | 114.56 | 218 | 148 | 8144 | [] |
| bench-sodium | flythrough | 6.6 | 298.97 | 132 | 159 | 267800 | [] |
| bench-sodium | water_glass | 20.04 | 57.91 | 139 | 135 | 9676 | [] |
| bench-sodium | nether | 27.2 | 47.28 | 1 | 129 | 263664 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 54.433 (50.0) | 717 / 717 | 1622 | 1 | 40577.22 | 5.179 (0.0) | 1218 |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-plain | water_glass | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-plain | nether | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-plain | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-bench-sodium | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | nether | 3.6 | 3.6 (0) | 3.6 |  |
| core-bench-sodium | flythrough | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | spawn | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | water_glass | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | nether | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | mobs | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | outline | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | occlusion | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | occlusion_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | occlusion_corner | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-measure-full | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flythrough | 5.48 | 5.48 (0) | 5.48 |  |
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
| core-measure-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-quicksilver-2p-old | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | mobs | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | outline | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | occlusion | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | occlusion_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | occlusion_corner | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | translucent_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | particles | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | animation | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | animated_items | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-2p-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-quicksilver-old | occlusion | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | occlusion_move | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | occlusion_corner | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | water_glass_oit | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | flythrough | 3.46 | 3.46 (0) | 3.46 |  |
| core-sp-quicksilver | flythrough | 1.44 | 1.46 (91) | 1.46 |  |
| siftec-measure-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-full | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-full | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | factory_flat | 3.48 | 3.48 (0) | 3.29 |  |
| siftec-measure-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
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
| siftec-quicksilver-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-full | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-full | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-full | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-full | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-full | factory_flat | 3.35 | 3.35 (0) | 3.35 |  |
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

Rises of 4 MB or more: siftec-measure-full/mam: between scenes +4.00; siftec-measure-old/mam: between scenes +4.00; siftec-measure-vk/mam: between scenes +4.00; siftec-quicksilver-full/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00; siftec-quicksilver-vk/mam: between scenes +4.00

