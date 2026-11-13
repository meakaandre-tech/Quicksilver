# Quicksilver CI comparison

**passed**

Noted (not failures):

- pack/quicksilver-vk: occlusion switched to still camera after timed-out waits within a frame (by bench kinetics_flat)

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
| spawn | 0.2113 | 10.05 | 0.2012 | 0.2101 | 0.204 | 0.2087 |
| flythrough | 0.0 | 14.95 | 0.0012 | 0.001 | 0.0011 | 0.001 |
| water_glass | 0.0042 | 6.45 | 0.0044 | 0.004 | 0.004 | 0.0051 |
| nether | 0.0014 | 0.8 | 0.0016 | 0.0064 | 0.0003 | 0.0003 |
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
| translucent_move | 0.0 | 0.3 | 0.0 | 0.0003 | 0.0001 | 0.0002 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0003 | 0.0003 | 0.0003 | 0.0002 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0003 | 0.0004 | 0.0002 | 0.0005 |
| translucent_move.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0002 | 0.0003 | 0.0001 |
| translucent_move.low | 0.0003 | 0.3 | 0.001 | 0.001 | 0.0012 | 0.0012 |
| translucent_move.back | 0.0 | 0.3 | 0.0 | 0.0 | 0.0001 | 0.0 |
| translucent_move.bare_back | 0.0 | 0.3 | 0.0001 | 0.0001 | 0.0001 | 0.0 |
| water_glass_oit | 0.0043 | 0.3 | 0.0039 | 0.0044 | 0.0055 | 0.0058 |
| translucent_move_oit | 0.0002 | 0.3 | 0.0002 | 0.0001 | 0.0001 | 0.0001 |
| translucent_move_oit.x2404 | 0.0004 | 0.3 | 0.0005 | 0.0002 | 0.0002 | 0.0002 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0003 | 0.0003 | 0.0001 | 0.0003 |
| translucent_move_oit.x2424 | 0.0 | 0.3 | 0.0003 | 0.0001 | 0.0002 | 0.0001 |
| translucent_move_oit.low | 0.0 | 0.3 | 0.0014 | 0.001 | 0.0013 | 0.0013 |
| translucent_move_oit.back | 0.0 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0001 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0 | 0.0 | 0.0002 | 0.0002 |
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
| spawn | 92.67 | 18057 | 261 (747) | 283 (807) | 293 (830) | 354 (880) |
| flythrough | 97.27 | 6020 | 50 (298) | 48 (296) | 52 (297) | 48 (296) |
| water_glass | 95.81 | 25508 | 20 (2621) | 21 (2624) | 16 (2731) | 24 (2627) |
| nether | 99.42 | 905 | 15 (469) | 59 (510) | 3 (469) | 3 (457) |
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
| translucent_move | 96.93 | 13 | 2 (77) | 2 (77) | 1 (67) | 1 (77) |
| translucent_move.x2404 | 95.93 | 15 | 4 (107) | 5 (105) | 3 (87) | 4 (104) |
| translucent_move.x2414 | 95.86 | 13 | 2 (105) | 2 (105) | 2 (99) | 3 (106) |
| translucent_move.x2424 | 96.74 | 13 | 2 (79) | 2 (79) | 4 (70) | 2 (79) |
| translucent_move.low | 96.11 | 41 | 15 (21) | 14 (19) | 14 (17) | 15 (21) |
| translucent_move.back | 96.93 | 13 | 2 (77) | 1 (76) | 1 (67) | 1 (76) |
| translucent_move.bare_back | 96.9 | 13 | 2 (78) | 2 (77) | 2 (68) | 2 (77) |
| water_glass_oit | 95.81 | 57 | 12 (2613) | 19 (2621) | 33 (2748) | 30 (2631) |
| translucent_move_oit | 96.93 | 12 | 4 (79) | 1 (76) | 1 (67) | 1 (76) |
| translucent_move_oit.x2404 | 95.93 | 16 | 4 (104) | 3 (103) | 3 (87) | 4 (105) |
| translucent_move_oit.x2414 | 95.86 | 10 | 5 (109) | 2 (105) | 1 (98) | 2 (106) |
| translucent_move_oit.x2424 | 96.74 | 15 | 3 (80) | 2 (80) | 2 (68) | 2 (79) |
| translucent_move_oit.low | 96.11 | 40 | 19 (26) | 14 (19) | 14 (16) | 17 (23) |
| translucent_move_oit.back | 96.93 | 12 | 2 (78) | 1 (76) | 1 (67) | 3 (78) |
| translucent_move_oit.bare_back | 96.9 | 15 | 2 (77) | 2 (77) | 3 (69) | 3 (78) |
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
| spawn | 0.4418 / 171 | 0.2959 / 194 | 0.2043 / 224 | 0.2959 / 194 |
| flythrough | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| water_glass | 0.0042 / 18 | 0.0037 / 19 | 0.0029 / 9 | 0.0037 / 19 |
| nether | 0.0026 / 24 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
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
| translucent_move | 0.0001 / 1 | 0.0004 / 3 | 0.0002 / 2 | 0.0004 / 3 |
| translucent_move.x2404 | 0.0 / 0 | 0.0003 / 5 | 0.0002 / 2 | 0.0003 / 5 |
| translucent_move.x2414 | 0.0001 / 1 | 0.0003 / 2 | 0.0001 / 1 | 0.0003 / 2 |
| translucent_move.x2424 | 0.0001 / 1 | 0.0 / 1 | 0.0001 / 1 | 0.0 / 1 |
| translucent_move.low | 0.0005 / 5 | 0.0002 / 3 | 0.0003 / 1 | 0.0002 / 3 |
| translucent_move.back | 0.0 / 0 | 0.0001 / 6 | 0.0002 / 1 | 0.0001 / 6 |
| translucent_move.bare_back | 0.0002 / 3 | 0.0001 / 2 | 0.0 / 0 | 0.0001 / 2 |
| water_glass_oit | 0.0056 / 29 | 0.0041 / 17 | 0.004 / 19 | 0.0041 / 17 |
| translucent_move_oit | 0.0001 / 0 | 0.0001 / 1 | 0.0 / 0 | 0.0001 / 1 |
| translucent_move_oit.x2404 | 0.0005 / 5 | 0.0001 / 0 | 0.0 / 1 | 0.0001 / 0 |
| translucent_move_oit.x2414 | 0.0002 / 2 | 0.0001 / 1 | 0.0003 / 4 | 0.0001 / 1 |
| translucent_move_oit.x2424 | 0.0001 / 1 | 0.0001 / 1 | 0.0 / 1 | 0.0001 / 1 |
| translucent_move_oit.low | 0.0001 / 1 | 0.0002 / 5 | 0.0008 / 4 | 0.0002 / 5 |
| translucent_move_oit.back | 0.0001 / 1 | 0.0 / 0 | 0.0 / 2 | 0.0 / 0 |
| translucent_move_oit.bare_back | 0.0001 / 1 | 0.0 / 1 | 0.0001 / 2 | 0.0 / 1 |
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
| spawn | 14.44 (base 13.6) | 15 (base 14) | 22536 (base 22476) | 252.92 (base 259.07) | 4.24 (base 3.99) |
| flythrough | 15.49 (reported, not gated) | 23 (reported, not gated) | 191344 (reported, not gated) | 311.37 (base 324.25) | 3.73 (base 4.24) |
| water_glass | 9.68 (base 8.97) | 15 (base 15) | 11956 (base 15576) | 237.98 (base 250.02) | 4.24 (base 5.99) |
| nether | 13.85 (base 15.63) | 12 (base 12) | 10496 (base 19648) | 259.42 (base 273.53) | 4.24 (base 5.99) |
| mobs | 20.67 (base 19.77) | 17 (base 17) | 613548 (base 1010948) | 258.17 (base 268.37) | 4.24 (base 6.99) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5596 (base 6356) | 257.99 (base 264.69) | 4.24 (base 5.48) |
| occlusion | 16.67 (base 15.67) | 15 (base 15) | 100048 (base 126320) | 263.46 (base 265.1) | 4.24 (base 4.24) |
| occlusion_move | 16.94 (reported, not gated) | 15 (reported, not gated) | 81940 (reported, not gated) | 263.85 (base 265.74) | 4.24 (base 4.24) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 268.16 (base 267.71) | 4.24 (base 5.48) |
| translucent_move | 8.86 (reported, not gated) | 15 (reported, not gated) | 5340 (reported, not gated) | 274.83 (base 267.48) | 8.24 (base 5.48) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 12496 (base 14688) | 237.55 (base 245.02) | 3.35 (base 3.73) |
| translucent_move_oit | 14.18 (reported, not gated) | 15 (reported, not gated) | 5488 (reported, not gated) | 240.52 (base 247.19) | 3.48 (base 3.73) |
| flat_plants | 16.81 (base 18.29) | 15 (base 15) | 4516 (base 9812) | 239.75 (base 246.92) | 3.21 (base 3.99) |
| renderer_off | 8.67 (base 7.67) | 14 (base 14) | 3612 (base 7164) | 232.9 (base 241.33) | 3.6 (base 4.12) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 265.6 (base 261.44) | 8.24 (base 5.99) |
| animation | 50 median (avg 40.94) (base 49) | 15 (base 15) | 2164 (base 2056) | 262.09 (base 260.68) | 8.24 (base 5.99) |
| animated_items | 61 median (avg 47.77) (base 60) | 24 (base 23) | 22016 (base 21940) | 236.6 (base 239.81) | 8.24 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.44 / 14 (13.55) | 123.0 / 123 (9.27) | median and average, x 1.10 + 2 |
| flythrough | 15.49 / 16 (10.95) | 123.05 / 123 (5.58) | median and average, at most vanilla + 2 |
| water_glass | 9.68 / 10 (29.31) | 124.0 / 124 (16.27) | median, at most vanilla |
| nether | 13.85 / 17 (27.11) | 120.74 / 121 (15.63) | median, x 1.10 + 2 |
| mobs | 20.67 / 21 (29.95) | 132.83 / 134 (19.9) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.01) | median, x 1.10 + 2 |
| occlusion | 16.67 / 17 (30.0) | 94.33 / 133 (29.97) | median and average, x 1.10 + 2 |
| occlusion_move | 16.94 / 18 (29.99) | 94.4 / 133 (29.96) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (30.01) | 82.33 / 121 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 8.86 / 9 (28.36) | 124.0 / 124 (16.59) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (15.98) | 129.0 / 129 (9.06) | median, at most vanilla |
| translucent_move_oit | 14.18 / 14 (15.53) | 129.0 / 129 (8.47) | median and average, at most vanilla |
| flat_plants | 16.81 / 20 (27.93) | 123.71 / 124 (16.26) | median, x 1.10 + 2 |
| renderer_off | 8.67 / 9 (30.0) | 96.87 / 123 (25.8) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 86.2 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.94 / 50 (30.0) | 144.22 / 179 (30.01) | median, x 1.10 + 2 |
| animated_items | 47.77 / 61 (30.0) | 155.46 / 190 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.841 | 36.0 / 22.841 | 0.0 / 0.0 | 416.0 / 37.084 |
| flythrough | 144.0 / 88.635 | 144.0 / 88.635 | 0.0 / 0.0 | 416.0 / 144.743 |
| water_glass | 36.0 / 12.354 | 36.0 / 12.354 | 0.0 / 0.0 | 416.0 / 21.451 |
| nether | 20.0 / 15.284 | 20.0 / 15.284 | 0.0 / 0.0 | 256.0 / 26.812 |
| mobs | 16.0 / 9.55 | 16.0 / 9.55 | 0.0 / 0.0 | 256.0 / 16.742 |
| outline | 16.0 / 1.397 | 16.0 / 1.397 | 0.0 / 0.0 | 256.0 / 2.444 |
| occlusion | 20.0 / 2.772 | 20.0 / 2.772 | 0.0 / 0.0 | 416.0 / 4.508 |
| occlusion_move | 20.0 / 3.578 | 20.0 / 3.578 | 0.0 / 0.0 | 416.0 / 5.834 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.214 | 28.0 / 13.214 | 0.0 / 0.0 | 416.0 / 22.34 |
| water_glass_oit | 20.0 / 12.354 | 20.0 / 12.354 | 0.0 / 0.0 | 416.0 / 21.451 |
| translucent_move_oit | 28.0 / 12.857 | 28.0 / 12.857 | 0.0 / 0.0 | 416.0 / 21.72 |
| flat_plants | 24.0 / 14.207 | 24.0 / 14.207 | 0.0 / 0.0 | 416.0 / 24.0 |
| renderer_off | 24.0 / 8.527 | 24.0 / 8.527 | 0.0 / 0.0 | 416.0 / 14.966 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 439645.141 (594949.77) | 26.104 | 1.194 | 505368 / 1054084 | 482944 (2097152.0) | 270 / 185 | 0.0 / 0 |
| flythrough | 498291.543 (785221.123) | 36.541 | 1.086 | 2257468 / 7211868 | 2096736 (2097152.0) | 219 / 111 | 6.332 / 73 |
| water_glass | 111219.148 (193657.349) | 42.569 | 1.133 | 14064 / 16340 | 0 (2097152.0) | 3 / 325 | 0.0 / 0 |
| nether | 29498.225 (42395.934) | 30.422 | 2.0 | 216056 / 602568 | 204352 (2097152.0) | 136 / 312 | 0.0 / 0 |
| mobs | 61526.716 (109685.114) | 43.906 | 0.967 | 613548 / 616308 | 0 (2097152.0) | 3 / 103 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5596 / 6336 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 31985.309 (56964.942) | 43.851 | 1.279 | 100048 / 425496 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 24029.636 (42696.137) | 43.719 | 1.259 | 708988 / 1111628 | 632832 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21838.644 (47199.866) | 53.732 | 1.214 | 35396 / 59420 | 31552 (2097152.0) | 1 / 0 | 0.0 / 0 |
| translucent_move | 21594.674 (27608.649) | 21.783 | 1.004 | 761276 / 1333552 | 756096 (2097152.0) | 126 / 331 | 0.0 / 0 |
| water_glass_oit | 111378.056 (193934.044) | 42.569 | 1.133 | 14288 / 16676 | 0 (2097152.0) | 319 / 181 | 0.0 / 0 |
| translucent_move_oit | 21686.665 (27754.568) | 21.863 | 1.005 | 730488 / 1277592 | 724864 (2097152.0) | 309 / 169 | 0.0 / 0 |
| flat_plants | 9100.25 (12476.279) | 27.06 | 1.045 | 4720 / 271580 | 0 (2097152.0) | 140 / 325 | 0.0 / 0 |
| renderer_off | 20762.547 (39369.507) | 47.262 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 3 / 10 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86772 / 150176 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79744 / 123000 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.0 (118) | 4.802 (98) | 0.416 | 2.255 (49) | 0 | 850 / 0 | 5.352 / 6.952 | 2.046 / 3.127 |
| flythrough | 3.057 (1741) | 6.615 (1528) | 0.462 | 3.059 (1739) | 0 | 1408 / 0 | 4.509 / 6.052 | 2.667 / 3.981 |
| water_glass | 1.56 (19) | 2.572 (14) | 0.607 | None (0) | 0 | 1181 / 0 | 4.734 / 6.097 | 1.891 / 2.813 |
| nether | 1.225 (29) | 3.037 (40) | 0.403 | 1.628 (10) | 0 | 1812 / 0 | 3.851 / 4.913 | 1.562 / 2.226 |
| mobs | 0.535 (6) | 0.635 (6) | 0.843 | None (0) | 0 | 2041 / 0 | 3.719 / 4.74 | 1.525 / 2.18 |
| outline | 0.26 (12) | 0.323 (12) | 0.805 | None (0) | 0 | 2101 / 0 | 3.667 / 4.679 | 1.505 / 2.143 |
| occlusion | 0.582 (39) | 1.066 (46) | 0.546 | None (0) | 0 | 2231 / 0 | 3.573 / 4.554 | 1.475 / 2.091 |
| occlusion_move | 0.882 (56) | 2.217 (56) | 0.398 | 1.961 (18) | 0 | 2375 / 0 | 3.429 / 4.368 | 1.421 / 2.013 |
| occlusion_corner | 0.708 (110) | 1.474 (110) | 0.48 | 0.924 (1) | 0 | 2655 / 0 | 3.151 / 4.018 | 1.24 / 1.769 |
| translucent_move | 1.821 (105) | 3.74 (117) | 0.487 | 2.743 (33) | 0 | 3025 / 0 | 3.093 / 4.024 | 1.273 / 1.83 |
| water_glass_oit | 2.095 (158) | 4.257 (150) | 0.492 | None (0) | 0 | 413 / 0 | 4.176 / 5.607 | 2.343 / 3.053 |
| translucent_move_oit | 2.556 (235) | 4.408 (213) | 0.58 | 3.257 (26) | 0 | 976 / 0 | 3.075 / 4.177 | 1.673 / 2.277 |
| flat_plants | 1.02 (96) | 1.197 (80) | 0.852 | None (0) | 0 | 407 / 0 | 4.909 / 5.774 | 1.829 / 1.837 |
| renderer_off | 0.424 (26) | 0.46 (21) | 0.922 | None (0) | 0 | 324 / 0 | 4.527 / 7.526 | 1.93 / 3.502 |
| particles | 0.285 (24) | 0.465 (30) | 0.613 | None (0) | 0 | 3058 / 0 | 3.066 / 3.989 | 1.26 / 1.814 |
| animation | 0.623 (18) | 1.119 (18) | 0.557 | 0.86 (4) | 0 | 3133 / 0 | 3.008 / 3.908 | 1.236 / 1.745 |
| animated_items | 0.219 (42) | 0.304 (42) | 0.72 | 0.625 (2) | 0 | 3165 / 0 | 2.982 / 3.873 | 1.219 / 1.71 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.011 | 653.411 | 16 (vanilla 28) | 1379312 | 40.773 / 0.095 | 22.841 / 36.0 | 36.832 | 2342 / 0 | 2.255 (5.47) |
| flythrough | indirect, one multi-draw per arena and layer | 4.438 | 778.521 | 16 (vanilla 28) | 5375396 | 15.167 / 1.021 | 88.635 / 144.0 | 143.539 | 6749 / 0 | 3.059 (10.268) |
| water_glass | indirect, one multi-draw per arena and layer | 3.005 | 105.179 | 16 (vanilla 28) | 767856 | 33.794 / 0.082 | 12.354 / 36.0 | 20.504 | 3045 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.079 | 16 (vanilla 28) | 959828 | 28.317 / 0.185 | 15.284 / 20.0 | 25.63 | 4099 / 0 | 1.628 (2.294) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 60.1 | 16 (vanilla 28) | 598372 | 25.774 / 0.163 | 9.55 / 16.0 | 15.978 | 4532 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 87112 | 25.322 / 0.162 | 1.397 / 16.0 | 2.326 | 4627 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 174288 | 24.129 / 0.154 | 2.772 / 20.0 | 4.654 | 4855 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.873 | 33.935 | 16 (vanilla 28) | 224948 | 22.9 / 0.146 | 3.578 / 20.0 | 6.007 | 5120 / 0 | 1.961 (5.213) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.053 | 60.88 | 16 (vanilla 28) | 122728 | 21.604 / 0.137 | 1.931 / 20.0 | 3.277 | 5509 / 0 | 0.924 (0.921) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.162 | 23.071 | 16 (vanilla 28) | 816876 | 18.724 / 0.125 | 13.214 / 28.0 | 21.813 | 6352 / 0 | 2.743 (9.182) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.016 | 113.354 | 16 (vanilla 28) | 767856 | 7.559 / 0.044 | 12.354 / 20.0 | 20.504 | 1091 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.19 | 37.194 | 16 (vanilla 28) | 794268 | 6.769 / 0.114 | 12.857 / 28.0 | 21.209 | 2465 / 0 | 3.257 (9.879) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 22.039 | 16 (vanilla 28) | 887532 | 6.386 / 0.01 | 14.207 / 24.0 | 23.7 | 960 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 535624 | 2.383 / 0.021 | 8.527 / 24.0 | 14.303 | 608 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 18.668 / 0.125 | 0.131 / 28.0 | 0.225 | 6403 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.52 / 0.124 | 0.302 / 28.0 | 0.518 | 6505 / 0 | 0.86 (1.415) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.469 / 0.124 | 0.153 / 28.0 | 0.261 | 6555 / 0 | 0.625 (0.904) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 1.0 | 0.0 | 0 | 0 | 37 (0.022 / 0.034 / 0.036; 0) | 0 | 41734 / 0 / 0 |
| flythrough | 195.482 | 1.0 | 0.0 | 0 | 0 | 933 (0.021 / 0.033 / 3.465; 0) | 67 | 43006 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2352 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.006 / 0.011 / 0.011; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.081 / 0.099 / 2.571; 0) | 180 | 3976 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 960 | 0 (None / None / None; 0) | 0 | 1280 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 933 | 0 (None / None / None; 0) | 0 | 2177 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2240 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 344.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.078; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 438.505 | 1.0 (0.0, 0.0) | 1.105 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.064; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.094 (0.17; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 50.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.053 (0.089; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 52.353 | 10.0 (9.0, 2.355) | 6.0 (6.0, 2.282) | 0.048 (0.211; 0) | 0 | 2782 / 1504392 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 137.136 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 137.437 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.011 (0.164; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 265.0 / 342.0 (22.5) | 265.0 / 77.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5159 / 0 |
| flythrough | two-phase | 322.3 / 415.75 (22.5) | 317.66 / 98.09 / 4.64 | 1.0 | 0.0 (0.0, 0.05; 100.0) | 14400.0 | 5091 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 12702 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 35505 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 11175 / 0 |
| outline | two-phase | 6.0 / 29.0 (79.3) | 6.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3450 / 0 |
| occlusion | two-phase | 26.0 / 50.0 (48.0) | 26.0 / 24.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3600 / 0 |
| occlusion_move | two-phase | 22.42 / 52.31 (57.1) | 22.37 / 29.95 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4450 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.85 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3164 / 0 |
| translucent_move | two-phase | 15.65 / 137.02 (88.6) | 15.63 / 121.39 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 17243 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6960 / 0 |
| translucent_move_oit | two-phase | 15.66 / 136.97 (88.6) | 15.63 / 121.34 / 0.03 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9345 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 19877 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15150 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.444 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 83.077 / 0.443 | 0.027 / 0.013 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.276 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.868 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.002 / 53.986 | 0.013 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.33 | 0.74 / 0.783 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.978 / 7.072 | 0.056 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 113.844 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.247 / 11.22 | 0.005 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 57.473 / 57.559 | 0.019 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.513 / 12.415 | 0.008 / 0.012 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.102 | 0.714 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.796 / 2.611 | 0.017 / 0.014 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.097 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.539 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.008 / 0.057 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.277 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.004 / 0.011 | 56 (3) | 40.51 / 9.24 / 31.27 | 3 / 0 | 10.987 |
| animated_items | 136.793 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 49.12 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 252.75 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 67.16 (reported, not gated) | 45 (reported, not gated) | 609244 (reported, not gated) | 309.49 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.85 (base 20.0) | 13 (base 14) | 7764 (base 10264) | 238.0 (base 249.83) | 3.99 (base 5.99) |
| nether | 23.79 (base 33.79) | 10 (base 11) | 4512 (base 10656) | 259.45 (base 272.57) | 3.99 (base 5.99) |
| mobs | 25.73 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 257.91 (base 268.23) | 3.99 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.78 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 18.71 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.76 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 24.05 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.19 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.6 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 17.99 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 274.72 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7092 (base 7604) | 237.17 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 3172 (reported, not gated) | 239.94 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 17.23 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 239.59 (base 248.11) | 3.21 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.44 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.72 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.76 (base 261.4) | 5.99 (base 4.24) |
| animation | 49 median (avg 40.06) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.28 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 60 median (avg 47.04) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.46 (base 239.53) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.12 / 49 (10.46) | 849.14 / 849 (10.34) | median and average, x 1.10 + 2 |
| flythrough | 67.16 / 64 (6.95) | 1003.53 / 1011 (5.81) | median and average, at most vanilla |
| water_glass | 19.85 / 20 (23.15) | 389.0 / 389 (17.16) | median, at most vanilla |
| nether | 23.79 / 26 (25.45) | 587.96 / 588 (16.64) | median, x 1.10 + 2 |
| mobs | 25.73 / 26 (27.46) | 318.87 / 328 (21.61) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.01) | 128.27 / 167 (30.0) | median, x 1.10 + 2 |
| occlusion | 18.71 / 19 (29.98) | 162.27 / 201 (29.97) | median and average, x 1.10 + 2 |
| occlusion_move | 24.05 / 24 (29.88) | 167.73 / 202 (29.94) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (30.0) | 163.13 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 17.99 / 18 (18.82) | 368.9 / 368 (17.32) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (10.48) | 400.0 / 400 (9.45) | median, at most vanilla |
| translucent_move_oit | 25.53 / 26 (9.21) | 385.84 / 387 (8.8) | median and average, at most vanilla |
| flat_plants | 17.23 / 20 (25.83) | 401.57 / 402 (17.35) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.89) | 298.92 / 325 (25.8) | median, x 1.10 + 2 |
| particles | 10.72 / 11 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.06 / 49 (30.0) | 156.22 / 191 (30.01) | median, x 1.10 + 2 |
| animated_items | 47.04 / 60 (29.99) | 167.22 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 23.201 | 36.0 / 23.201 | 0.0 / 0.0 | 416.0 / 37.018 |
| flythrough | 112.0 / 85.568 | 112.0 / 85.568 | 0.0 / 0.0 | 416.0 / 145.12 |
| water_glass | 36.0 / 12.354 | 36.0 / 12.354 | 0.0 / 0.0 | 416.0 / 21.451 |
| nether | 20.0 / 15.281 | 20.0 / 15.281 | 0.0 / 0.0 | 256.0 / 26.804 |
| mobs | 16.0 / 9.55 | 16.0 / 9.55 | 0.0 / 0.0 | 256.0 / 16.742 |
| outline | 16.0 / 1.397 | 16.0 / 1.397 | 0.0 / 0.0 | 256.0 / 2.444 |
| occlusion | 20.0 / 2.581 | 20.0 / 2.581 | 0.0 / 0.0 | 416.0 / 4.234 |
| occlusion_move | 20.0 / 3.337 | 20.0 / 3.337 | 0.0 / 0.0 | 416.0 / 5.683 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.886 | 28.0 / 12.886 | 0.0 / 0.0 | 416.0 / 22.183 |
| water_glass_oit | 20.0 / 12.354 | 20.0 / 12.354 | 0.0 / 0.0 | 416.0 / 21.451 |
| translucent_move_oit | 28.0 / 12.529 | 28.0 / 12.529 | 0.0 / 0.0 | 416.0 / 21.564 |
| flat_plants | 24.0 / 13.796 | 24.0 / 13.796 | 0.0 / 0.0 | 416.0 / 24.363 |
| renderer_off | 24.0 / 8.527 | 24.0 / 8.527 | 0.0 / 0.0 | 416.0 / 14.966 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 426419.608 (646277.206) | 34.019 | 1.777 | 342188 / 568728 | 340808 (2097152.0) | 209 / 206 | 0.0 / 0 |
| flythrough | 562474.734 (901732.187) | 37.623 | 1.082 | 2110668 / 7711240 | 2096200 (2097152.0) | 139 / 116 | 7.671 / 68 |
| water_glass | 111270.325 (193746.459) | 42.569 | 1.133 | 9556 / 10980 | 0 (2097152.0) | 60 / 343 | 0.0 / 0 |
| nether | 41338.935 (63891.175) | 35.298 | 1.893 | 134800 / 368496 | 128832 (2097152.0) | 146 / 332 | 0.0 / 0 |
| mobs | 61536.088 (109701.821) | 43.906 | 0.967 | 610676 / 612388 | 0 (2097152.0) | 37 / 39 | 0.0 / 0 |
| outline | 1057.757 (2295.814) | 53.927 | 1.0 | 5012 / 5476 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29611.353 (52172.947) | 43.244 | 1.278 | 150500 / 124924 | 52352 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50359.114 (88472.237) | 43.079 | 1.223 | 650364 / 1156620 | 575296 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27756.106 (60456.805) | 54.089 | 1.272 | 32932 / 57892 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 200192.665 (355112.0) | 43.625 | 1.183 | 758484 / 1324516 | 756096 (2097152.0) | 318 / 345 | 0.0 / 0 |
| water_glass_oit | 111561.244 (194253.014) | 42.569 | 1.133 | 9556 / 11428 | 0 (2097152.0) | 209 / 188 | 0.0 / 0 |
| translucent_move_oit | 200929.62 (356241.761) | 43.597 | 1.181 | 729892 / 1273684 | 724864 (2097152.0) | 184 / 176 | 0.0 / 0 |
| flat_plants | 9101.571 (12478.089) | 27.06 | 1.045 | 2052 / 4340 | 0 (2097152.0) | 130 / 346 | 0.0 / 0 |
| renderer_off | 20762.662 (39369.726) | 47.262 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 6 / 2 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9444 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3044.467 (5228.568) | 41.772 | 1.087 | 86232 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2246.003 (4830.871) | 53.507 | 1.0 | 79304 / 122808 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.53 (145) | 4.152 (93) | 1.091 | 4.422 (51) | 0 | 898 / 0 | 9.017 / 11.886 | 4.075 / 5.798 |
| flythrough | 6.737 (1627) | 6.897 (1559) | 0.977 | 6.744 (1625) | 0 | 1402 / 0 | 7.287 / 9.867 | 4.966 / 6.749 |
| water_glass | 2.831 (18) | 2.715 (14) | 1.043 | None (0) | 0 | 1210 / 0 | 8.245 / 10.796 | 3.866 / 5.382 |
| nether | 2.717 (23) | 4.32 (31) | 0.629 | 2.388 (9) | 0 | 1835 / 0 | 6.864 / 8.999 | 3.343 / 4.901 |
| mobs | 1.014 (6) | 0.772 (6) | 1.313 | None (0) | 0 | 2067 / 0 | 6.678 / 8.757 | 3.215 / 4.802 |
| outline | 0.551 (13) | 0.29 (13) | 1.9 | None (0) | 0 | 2127 / 0 | 6.59 / 8.646 | 3.163 / 4.704 |
| occlusion | 1.077 (47) | 0.81 (37) | 1.33 | 2.266 (2) | 0 | 2256 / 0 | 6.422 / 8.44 | 3.061 / 4.534 |
| occlusion_move | 1.787 (62) | 2.614 (60) | 0.684 | 3.751 (16) | 0 | 2404 / 0 | 6.16 / 8.113 | 2.949 / 4.232 |
| occlusion_corner | 1.523 (110) | 1.65 (110) | 0.923 | 1.447 (1) | 0 | 2684 / 0 | 5.779 / 7.543 | 2.696 / 3.82 |
| translucent_move | 3.587 (117) | 3.864 (110) | 0.928 | 5.193 (37) | 0 | 3050 / 0 | 5.665 / 7.447 | 2.759 / 3.903 |
| water_glass_oit | 4.671 (154) | 4.148 (150) | 1.126 | None (0) | 0 | 413 / 0 | 9.293 / 11.465 | 4.844 / 6.141 |
| translucent_move_oit | 4.113 (213) | 4.922 (216) | 0.836 | 4.436 (26) | 0 | 967 / 0 | 6.395 / 8.1 | 3.697 / 4.556 |
| flat_plants | 1.963 (87) | 1.939 (86) | 1.012 | None (0) | 0 | 403 / 0 | 7.872 / 9.865 | 3.604 / 4.213 |
| renderer_off | 0.971 (21) | 0.535 (21) | 1.815 | None (0) | 0 | 326 / 0 | 9.066 / 13.25 | 3.806 / 6.116 |
| particles | 0.407 (30) | 0.267 (30) | 1.524 | None (0) | 0 | 3077 / 0 | 5.621 / 7.389 | 2.721 / 3.854 |
| animation | 1.075 (18) | 1.393 (18) | 0.772 | 1.482 (4) | 0 | 3152 / 0 | 5.521 / 7.248 | 2.65 / 3.761 |
| animated_items | 0.385 (42) | 0.301 (42) | 1.279 | 0.925 (2) | 0 | 3184 / 0 | 5.471 / 7.183 | 2.6 / 3.685 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.187 | 726.646 | 16 (vanilla 28) | 1401680 | 43.071 / 0.098 | 23.201 / 36.0 | 37.429 | 2539 / 0 | 4.422 (8.171) |
| flythrough | plain, one multi-draw per region and layer | 57.446 | 904.302 | 16 (vanilla 28) | 5184356 | 15.223 / 0.985 | 85.568 / 112.0 | 138.437 | 6498 / 0 | 6.744 (19.2) |
| water_glass | plain, one multi-draw per region and layer | 14.03 | 105.227 | 16 (vanilla 28) | 767856 | 35.341 / 0.092 | 12.354 / 36.0 | 20.504 | 3187 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.417 | 64.008 | 16 (vanilla 28) | 959764 | 29.781 / 0.183 | 15.281 / 20.0 | 25.628 | 4216 / 0 | 2.388 (5.27) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.109 | 16 (vanilla 28) | 598372 | 27.107 / 0.161 | 9.55 / 16.0 | 15.978 | 4656 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 87112 | 26.64 / 0.16 | 1.397 / 16.0 | 2.326 | 4752 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.05 | 43.352 | 16 (vanilla 28) | 161716 | 25.542 / 0.153 | 2.581 / 20.0 | 4.318 | 4985 / 0 | 2.266 (2.384) |
| occlusion_move | plain, one multi-draw per region and layer | 10.988 | 76.36 | 16 (vanilla 28) | 209344 | 24.323 / 0.146 | 3.337 / 20.0 | 5.59 | 5265 / 0 | 3.751 (10.176) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.913 | 16 (vanilla 28) | 122728 | 22.974 / 0.137 | 1.931 / 20.0 | 3.277 | 5654 / 0 | 1.447 (1.446) |
| translucent_move | plain, one multi-draw per region and layer | 12.011 | 247.87 | 16 (vanilla 28) | 796228 | 19.905 / 0.125 | 12.886 / 28.0 | 21.262 | 6517 / 0 | 5.193 (15.397) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.077 | 113.541 | 16 (vanilla 28) | 767856 | 7.578 / 0.044 | 12.354 / 20.0 | 20.504 | 1083 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.614 | 263.728 | 16 (vanilla 28) | 773680 | 6.657 / 0.092 | 12.529 / 28.0 | 20.659 | 2407 / 0 | 4.436 (13.017) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 861480 | 6.027 / 0.01 | 13.796 / 24.0 | 23.004 | 924 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 535624 | 2.4 / 0.021 | 8.527 / 24.0 | 14.303 | 607 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.861 / 0.125 | 0.131 / 28.0 | 0.225 | 6559 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.524 | 16 (vanilla 28) | 19416 | 19.707 / 0.124 | 0.302 / 28.0 | 0.518 | 6661 / 0 | 1.482 (2.015) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 19.653 / 0.124 | 0.153 / 28.0 | 0.261 | 6711 / 0 | 0.925 (1.484) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 157.0 | 17.0 | 0.0 | 0 | 0 | 42 (0.028 / 0.042 / 0.057; 0) | 0 | 32970 / 0 / 0 |
| flythrough | 188.493 | 26.343 | 0.0 | 0 | 0 | 862 (0.017 / 0.049 / 0.933; 0) | 42 | 26389 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1852 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.01; 0) | 32 | 1198 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.105 / 0.168 / 0.197; 0) | 180 | 2639 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 630 | 0 (None / None / None; 0) | 0 | 840 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 555 | 0 (None / None / None; 0) | 0 | 1295 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2072 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 352.248 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.026 (0.115; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.607 | 1.0 (0.0, 0.0) | 1.193 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.069; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.129 (0.222; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.072 (0.128; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.356 | 10.0 (9.0, 2.356) | 6.0 (6.0, 2.277) | 0.06 (0.325; 0) | 0 | 2775 / 1501532 / 0 / 0 |
| occlusion_corner | 81.864 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.061 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.886 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.04; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 304.21 / 350.23 (13.1) | 304.21 / 0.0 / 0.0 | 0.12 | 0.0 (0.0, 0.0; 0.0) | 1714.29 | 2354 / 0 |
| flythrough | still | 403.5 / 403.96 (0.1) | 403.5 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10005 / 0 |
| nether | still | 49.89 / 300.0 (83.4) | 49.89 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 225.88 | 31823 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10275 / 0 |
| outline | still | 6.0 / 29.0 (79.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion | still | 26.23 / 49.0 (46.5) | 26.23 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 47.92 | 3427 / 0 |
| occlusion_move | still | 51.18 / 51.31 (0.2) | 51.18 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.73 / 81.86 (0.2) | 81.73 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 134.3 / 134.88 (0.4) | 134.3 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4611 / 0 |
| translucent_move_oit | still | 134.58 / 135.16 (0.4) | 134.58 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 150.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 18189 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 303 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 54 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.141 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 98.786 / 0.0 | 0.023 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.235 / 0.0 | 0.003 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.836 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 56.918 / 56.944 | 0.026 / 0.028 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.642 | 0.958 / 0.978 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 43.98 / 10.178 | 0.073 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 105.949 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.34 / 14.244 | 0.006 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.389 / 51.314 | 0.013 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.948 / 14.816 | 0.007 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.505 | 0.569 / 0.977 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.783 / 2.598 | 0.017 / 0.01 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.147 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.007 / 0.047 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.005 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
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
| spawn | 13.29 (base 14.05) | 14 (base 15) | 25104 (base 27764) | 253.31 (base 257.2) | 5.98 (base 3.98) |
| flythrough | 13.06 (reported, not gated) | 33 (reported, not gated) | 415060 (reported, not gated) | 310.62 (base 318.06) | 3.46 (base 4.23) |
| water_glass | 8.77 (base 9.0) | 15 (base 15) | 12048 (base 15108) | 238.43 (base 244.39) | 5.98 (base 4.23) |
| nether | 13.23 (base 15.71) | 12 (base 12) | 10588 (base 19912) | 260.3 (base 268.95) | 5.98 (base 4.23) |
| mobs | 19.7 (base 19.97) | 17 (base 17) | 613548 (base 1008176) | 258.28 (base 264.31) | 5.98 (base 6.23) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5596 (base 6356) | 258.13 (base 264.58) | 5.98 (base 3.71) |
| occlusion | 15.68 (base 15.67) | 15 (base 15) | 100032 (base 126356) | 263.85 (base 264.78) | 5.98 (base 3.98) |
| occlusion_move | 16.08 (reported, not gated) | 15 (reported, not gated) | 82504 (reported, not gated) | 264.37 (base 265.16) | 5.98 (base 4.23) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 268.82 (base 266.66) | 5.98 (base 3.71) |
| translucent_move | 8.87 (reported, not gated) | 15 (reported, not gated) | 10724 (reported, not gated) | 275.07 (base 268.35) | 5.98 (base 5.46) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 12160 (base 15024) | 237.84 (base 245.99) | 3.34 (base 3.46) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10760 (reported, not gated) | 240.52 (base 248.38) | 3.46 (base 3.46) |
| flat_plants | 16.12 (base 18.96) | 15 (base 15) | 4592 (base 9864) | 239.53 (base 248.07) | 3.2 (base 5.98) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 3612 (base 7180) | 232.68 (base 241.13) | 3.59 (base 4.1) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 265.79 (base 261.4) | 5.98 (base 5.98) |
| animation | 50 median (avg 40.14) (base 49) | 15 (base 15) | 2164 (base 2056) | 262.18 (base 260.68) | 5.98 (base 5.98) |
| animated_items | 60 median (avg 47.07) (base 60) | 23 (base 23) | 21976 (base 21940) | 236.9 (base 239.74) | 5.98 (base 5.98) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.29 / 13 (12.42) | 124.0 / 124 (11.19) | median and average, x 1.10 + 2 |
| flythrough | 13.06 / 13 (8.56) | 123.06 / 123 (7.02) | median and average, at most vanilla + 2 |
| water_glass | 8.77 / 9 (25.49) | 124.0 / 124 (18.49) | median, at most vanilla |
| nether | 13.23 / 16 (25.31) | 120.99 / 121 (18.0) | median, x 1.10 + 2 |
| mobs | 19.7 / 20 (28.25) | 117.14 / 134 (23.07) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (29.98) | 87.85 / 126 (29.82) | median, x 1.10 + 2 |
| occlusion | 15.68 / 16 (29.74) | 95.45 / 133 (29.53) | median and average, x 1.10 + 2 |
| occlusion_move | 16.08 / 17 (29.64) | 95.25 / 133 (29.63) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (29.82) | 82.98 / 121 (29.76) | median and average, x 1.10 + 2 |
| translucent_move | 8.87 / 9 (22.39) | 123.09 / 124 (19.24) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (11.98) | 129.0 / 129 (10.16) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (10.24) | 129.0 / 129 (9.32) | median and average, at most vanilla |
| flat_plants | 16.12 / 19 (27.01) | 124.0 / 124 (19.05) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.76) | 90.49 / 123 (27.68) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (29.94) | 86.46 / 125 (29.93) | median and average, x 1.10 + 2 |
| animation | 40.14 / 50 (29.9) | 145.21 / 179 (29.81) | median, x 1.10 + 2 |
| animated_items | 47.07 / 60 (29.97) | 155.91 / 190 (29.85) | median, x 1.10 + 2 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.985 | 36.0 / 22.985 | 0.0 / 0.0 | 416.0 / 39.041 |
| flythrough | 112.0 / 88.071 | 112.0 / 88.071 | 0.0 / 0.0 | 416.0 / 145.612 |
| water_glass | 36.0 / 12.503 | 36.0 / 12.503 | 0.0 / 0.0 | 416.0 / 21.438 |
| nether | 20.0 / 15.282 | 20.0 / 15.282 | 0.0 / 0.0 | 256.0 / 26.809 |
| mobs | 16.0 / 9.55 | 16.0 / 9.55 | 0.0 / 0.0 | 256.0 / 16.742 |
| outline | 16.0 / 1.397 | 16.0 / 1.397 | 0.0 / 0.0 | 256.0 / 2.444 |
| occlusion | 20.0 / 2.612 | 20.0 / 2.612 | 0.0 / 0.0 | 416.0 / 4.266 |
| occlusion_move | 20.0 / 3.368 | 20.0 / 3.368 | 0.0 / 0.0 | 416.0 / 5.716 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.935 | 28.0 / 12.935 | 0.0 / 0.0 | 416.0 / 22.158 |
| water_glass_oit | 20.0 / 12.354 | 20.0 / 12.354 | 0.0 / 0.0 | 416.0 / 21.451 |
| translucent_move_oit | 28.0 / 12.579 | 28.0 / 12.579 | 0.0 / 0.0 | 416.0 / 21.539 |
| flat_plants | 24.0 / 13.858 | 24.0 / 13.858 | 0.0 / 0.0 | 416.0 / 24.17 |
| renderer_off | 24.0 / 8.527 | 24.0 / 8.527 | 0.0 / 0.0 | 416.0 / 14.966 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 478919.452 (646261.129) | 25.894 | 1.173 | 375632 / 798872 | 350528 (2097152.0) | 248 / 223 | 0.0 / 0 |
| flythrough | 567499.298 (909445.509) | 37.599 | 1.083 | 2127940 / 7264128 | 2097120 (2097152.0) | 171 / 139 | 5.523 / 56 |
| water_glass | 111248.134 (193707.819) | 42.569 | 1.133 | 13504 / 16228 | 0 (2097152.0) | 43 / 369 | 0.0 / 0 |
| nether | 57116.719 (83912.067) | 31.933 | 1.613 | 392920 / 345508 | 368064 (2097152.0) | 125 / 359 | 0.0 / 0 |
| mobs | 61532.715 (109695.809) | 43.906 | 0.967 | 613548 / 616308 | 0 (2097152.0) | 15 / 33 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5596 / 6336 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29839.97 (52627.347) | 43.299 | 1.277 | 255684 / 584536 | 155072 (2097152.0) | 1 / 8 | 0.0 / 0 |
| occlusion_move | 50846.664 (89448.229) | 43.155 | 1.226 | 652220 / 1157996 | 575360 (2097152.0) | 6 / 4 | 0.0 / 0 |
| occlusion_corner | 27773.216 (60489.853) | 54.086 | 1.272 | 36096 / 59512 | 31552 (2097152.0) | 1 / 1 | 0.0 / 0 |
| translucent_move | 200796.349 (356371.145) | 43.655 | 1.183 | 767044 / 1333776 | 756096 (2097152.0) | 30 / 306 | 0.0 / 0 |
| water_glass_oit | 111494.561 (194136.904) | 42.569 | 1.133 | 14288 / 16452 | 0 (2097152.0) | 239 / 202 | 0.0 / 0 |
| translucent_move_oit | 200951.049 (356369.745) | 43.612 | 1.182 | 735120 / 1277704 | 724864 (2097152.0) | 204 / 186 | 0.0 / 0 |
| flat_plants | 9100.791 (12477.02) | 27.06 | 1.045 | 5376 / 9996 | 0 (2097152.0) | 16 / 319 | 0.0 / 0 |
| renderer_off | 20762.779 (39369.946) | 47.262 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 5 / 17 | 0.0 / 0 |
| particles | 1698.836 (3676.137) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| animation | 3061.32 (5267.779) | 41.886 | 1.085 | 86740 / 150176 | 84608 (2097152.0) | 0 / 1 | 0.0 / 0 |
| animated_items | 2246.04 (4830.957) | 53.507 | 1.0 | 79704 / 123160 | 57728 (2097152.0) | 5 / 13 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.171 (101) | 2.227 (113) | 0.975 | 2.155 (52) | 0 | 870 / 0 | 6.304 / 8.441 | 2.529 / 4.257 |
| flythrough | 3.776 (1669) | 4.412 (1616) | 0.856 | 3.779 (1666) | 0 | 1404 / 0 | 4.742 / 7.084 | 2.788 / 4.319 |
| water_glass | 1.374 (14) | 1.144 (14) | 1.201 | None (0) | 0 | 1178 / 0 | 5.7 / 7.611 | 2.409 / 3.827 |
| nether | 1.842 (40) | 1.856 (29) | 0.992 | 1.957 (17) | 0 | 1801 / 0 | 4.833 / 6.506 | 2.109 / 3.248 |
| mobs | 0.675 (6) | 0.609 (6) | 1.108 | None (0) | 0 | 2033 / 0 | 4.651 / 6.22 | 2.066 / 3.119 |
| outline | 0.345 (13) | 0.296 (13) | 1.166 | None (0) | 0 | 2093 / 0 | 4.573 / 6.128 | 2.053 / 3.066 |
| occlusion | 0.877 (52) | 0.627 (47) | 1.399 | 3.132 (2) | 0 | 2229 / 0 | 4.421 / 5.95 | 1.992 / 2.956 |
| occlusion_move | 1.175 (64) | 1.274 (70) | 0.922 | 2.875 (16) | 0 | 2386 / 0 | 4.231 / 5.701 | 1.933 / 2.829 |
| occlusion_corner | 1.001 (110) | 0.833 (110) | 1.202 | 0.992 (1) | 0 | 2668 / 0 | 3.928 / 5.296 | 1.727 / 2.565 |
| translucent_move | 2.003 (116) | 1.849 (144) | 1.083 | 3.315 (33) | 0 | 3027 / 0 | 3.796 / 5.185 | 1.753 / 2.606 |
| water_glass_oit | 2.869 (156) | 2.476 (152) | 1.159 | None (0) | 0 | 413 / 0 | 5.45 / 7.778 | 2.858 / 4.227 |
| translucent_move_oit | 3.09 (221) | 3.728 (221) | 0.829 | 2.775 (26) | 0 | 960 / 0 | 3.723 / 5.273 | 2.063 / 2.695 |
| flat_plants | 1.442 (95) | 1.018 (93) | 1.417 | None (0) | 0 | 409 / 0 | 6.179 / 6.866 | 1.969 / 2.424 |
| renderer_off | 0.427 (20) | 0.365 (20) | 1.17 | None (0) | 0 | 326 / 0 | 4.796 / 7.039 | 1.95 / 3.412 |
| particles | 0.272 (30) | 0.192 (24) | 1.417 | None (0) | 0 | 3054 / 0 | 3.767 / 5.143 | 1.737 / 2.581 |
| animation | 0.767 (18) | 0.663 (18) | 1.157 | 1.104 (4) | 0 | 3129 / 0 | 3.693 / 5.039 | 1.698 / 2.507 |
| animated_items | 0.299 (42) | 0.865 (32) | 0.346 | 1.073 (2) | 0 | 3161 / 0 | 3.66 / 4.993 | 1.67 / 2.471 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.012 | 725.464 | 16 (vanilla 28) | 1387816 | 39.229 / 0.105 | 22.985 / 36.0 | 37.059 | 2337 / 0 | 2.155 (2.938) |
| flythrough | indirect, one multi-draw per arena and layer | 3.018 | 916.994 | 16 (vanilla 28) | 5335548 | 15.1 / 0.998 | 88.071 / 112.0 | 142.475 | 6584 / 0 | 3.779 (10.873) |
| water_glass | indirect, one multi-draw per arena and layer | 3.006 | 105.206 | 16 (vanilla 28) | 776344 | 31.761 / 0.09 | 12.503 / 36.0 | 20.731 | 2970 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 83.496 | 16 (vanilla 28) | 959876 | 26.613 / 0.186 | 15.282 / 20.0 | 25.631 | 4032 / 0 | 1.957 (3.304) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.106 | 16 (vanilla 28) | 598372 | 24.225 / 0.17 | 9.55 / 16.0 | 15.978 | 4472 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 87112 | 23.79 / 0.168 | 1.397 / 16.0 | 2.326 | 4568 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.436 | 16 (vanilla 28) | 163616 | 22.534 / 0.159 | 2.612 / 20.0 | 4.369 | 4825 / 0 | 3.132 (3.785) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.003 | 75.374 | 16 (vanilla 28) | 211244 | 21.225 / 0.149 | 3.368 / 20.0 | 5.641 | 5126 / 0 | 2.875 (6.351) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.961 | 16 (vanilla 28) | 122728 | 19.999 / 0.141 | 1.931 / 20.0 | 3.277 | 5519 / 0 | 0.992 (0.991) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.002 | 246.635 | 16 (vanilla 28) | 799352 | 17.317 / 0.127 | 12.935 / 28.0 | 21.345 | 6364 / 0 | 3.315 (9.247) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.021 | 113.473 | 16 (vanilla 28) | 767856 | 7.511 / 0.042 | 12.354 / 20.0 | 20.504 | 1087 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.02 | 261.549 | 16 (vanilla 28) | 776736 | 6.844 / 0.098 | 12.579 / 28.0 | 20.741 | 2407 / 0 | 2.775 (7.716) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.041 | 16 (vanilla 28) | 865328 | 6.387 / 0.01 | 13.858 / 24.0 | 23.107 | 960 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 535616 | 2.41 / 0.021 | 8.527 / 24.0 | 14.302 | 604 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 17.278 / 0.127 | 0.131 / 28.0 | 0.225 | 6406 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.767 | 16 (vanilla 28) | 19416 | 17.142 / 0.126 | 0.302 / 28.0 | 0.518 | 6508 / 0 | 1.104 (1.513) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.692 | 16 (vanilla 28) | 9764 | 17.094 / 0.126 | 0.153 / 28.0 | 0.261 | 6558 / 0 | 1.073 (1.632) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 1.0 | 0.0 | 0 | 0 | 44 (0.021 / 0.03 / 0.077; 0) | 0 | 38346 / 0 / 0 |
| flythrough | 192.378 | 1.0 | 0.0 | 0 | 0 | 893 (0.017 / 0.037 / 2.373; 0) | 57 | 33089 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2040 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1190 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.022 / 0.07 / 0.081; 0) | 32 | 1188 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.079 / 0.125 / 0.147; 0) | 180 | 3136 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 720 | 0 (None / None / None; 0) | 0 | 960 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 615 | 0 (None / None / None; 0) | 0 | 1435 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2168 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2388 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 344.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.027 (0.27; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.372 | 1.0 (0.0, 0.0) | 1.163 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.136; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.112 (0.267; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.062 (0.295; 0) | 0 | 3570 / 1616020 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.359) | 6.0 (6.0, 2.274) | 0.057 (0.221; 0) | 0 | 2752 / 1489684 / 0 / 0 |
| occlusion_corner | 81.868 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.154 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.007; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.698 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.594 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 305.51 / 342.0 (10.7) | 305.51 / 0.0 / 0.0 | 0.12 | 0.0 (0.0, 0.0; 0.0) | 1677.11 | 2310 / 0 |
| flythrough | still | 409.96 / 410.33 (0.1) | 409.96 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11049 / 0 |
| nether | still | 61.9 / 300.0 (79.4) | 61.9 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 340.83 | 29982 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10575 / 0 |
| outline | still | 6.0 / 29.0 (79.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion | still | 26.31 / 49.0 (46.3) | 26.31 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.4 | 3358 / 0 |
| occlusion_move | still | 51.19 / 51.31 (0.2) | 51.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.77 / 81.86 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 134.29 / 135.01 (0.5) | 134.29 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5220 / 0 |
| translucent_move_oit | still | 133.99 / 135.04 (0.8) | 133.99 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 19312 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1155.85 | 333 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4480.53 | 48 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.173 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 118.721 / 0.177 | 0.024 / 0.006 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.855 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.168 / 54.145 | 0.017 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.648 | 0.994 / 0.792 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 42.571 / 11.828 | 0.063 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 98.286 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 77.181 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 77.771 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 77.572 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 114.102 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.96 / 10.935 | 0.004 / 0.009 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 56.566 / 56.55 | 0.013 / 0.018 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.765 / 12.756 | 0.005 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.394 | 1.0 / 0.983 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.898 / 3.642 | 0.015 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 82.767 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.795 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.01 / 0.045 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 137.538 / 32.394 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.798 / 2.796 | 0.005 / 0.007 | 56 (3) | 40.608 / 9.24 / 31.368 | 3 / 0 | 10.983 |
| animated_items | 137.24 / 28.09 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.564 / 7.98 / 32.584 | 0 / 0 | 9.0 |

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
| spawn | 50.23 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 252.52 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 69.74 (reported, not gated) | 49 (reported, not gated) | 1000012 (reported, not gated) | 309.61 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.92 (base 20.0) | 13 (base 14) | 7540 (base 10264) | 237.44 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.09 (base 33.79) | 10 (base 11) | 4284 (base 10656) | 258.52 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.75 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 256.97 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.75 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 262.89 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.5 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.73 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.35 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.15 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 274.09 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7540 (base 7604) | 236.65 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.43 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 239.37 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.13 (base 33.0) | 13 (base 13) | 1604 (base 1716) | 239.47 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 13.68 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.06 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 264.76 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.94) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.25 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 22 (base 22) | 21668 (base 21668) | 235.8 (base 239.53) | 5.99 (base 5.99) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.23 / 50 (8.6) | 849.14 / 849 (10.34) | median and average, x 1.10 + 2 |
| flythrough | 69.74 / 70 (6.16) | 1003.53 / 1011 (5.81) | median and average, at most vanilla |
| water_glass | 20.92 / 21 (20.03) | 389.0 / 389 (17.16) | median, at most vanilla |
| nether | 24.09 / 27 (23.48) | 587.96 / 588 (16.64) | median, x 1.10 + 2 |
| mobs | 26.75 / 27 (26.35) | 318.87 / 328 (21.61) | median, x 1.10 + 2 |
| outline | 11.67 / 12 (30.0) | 128.27 / 167 (30.0) | median, x 1.10 + 2 |
| occlusion | 19.67 / 20 (29.79) | 162.27 / 201 (29.97) | median and average, x 1.10 + 2 |
| occlusion_move | 20.09 / 21 (29.75) | 167.73 / 202 (29.94) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.73 / 12 (29.94) | 163.13 / 201 (29.98) | median and average, x 1.10 + 2 |
| translucent_move | 11.15 / 11 (24.31) | 368.9 / 368 (17.32) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (10.65) | 400.0 / 400 (9.45) | median, at most vanilla |
| translucent_move_oit | 18.43 / 18 (10.33) | 385.84 / 387 (8.8) | median and average, at most vanilla |
| flat_plants | 18.13 / 21 (24.93) | 401.57 / 402 (17.35) | median, x 1.10 + 2 |
| renderer_off | 13.68 / 14 (29.34) | 298.92 / 325 (25.8) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (29.99) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.94 / 50 (30.0) | 156.22 / 191 (30.01) | median, x 1.10 + 2 |
| animated_items | 47.73 / 61 (30.01) | 167.22 / 202 (30.0) | median, x 1.10 + 2 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 40.0 / 23.101 | 40.0 / 23.101 | 0.0 / 0.0 | 416.0 / 37.018 |
| flythrough | 112.0 / 85.018 | 112.0 / 85.018 | 0.0 / 0.0 | 416.0 / 145.12 |
| water_glass | 40.0 / 12.503 | 40.0 / 12.503 | 0.0 / 0.0 | 416.0 / 21.451 |
| nether | 20.0 / 15.284 | 20.0 / 15.284 | 0.0 / 0.0 | 256.0 / 26.804 |
| mobs | 16.0 / 9.55 | 16.0 / 9.55 | 0.0 / 0.0 | 256.0 / 16.742 |
| outline | 16.0 / 1.397 | 16.0 / 1.397 | 0.0 / 0.0 | 256.0 / 2.444 |
| occlusion | 20.0 / 2.772 | 20.0 / 2.772 | 0.0 / 0.0 | 416.0 / 4.234 |
| occlusion_move | 20.0 / 3.529 | 20.0 / 3.529 | 0.0 / 0.0 | 416.0 / 5.683 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.093 | 28.0 / 13.093 | 0.0 / 0.0 | 416.0 / 22.183 |
| water_glass_oit | 20.0 / 12.354 | 20.0 / 12.354 | 0.0 / 0.0 | 416.0 / 21.451 |
| translucent_move_oit | 28.0 / 12.737 | 28.0 / 12.737 | 0.0 / 0.0 | 416.0 / 21.564 |
| flat_plants | 24.0 / 14.027 | 24.0 / 14.027 | 0.0 / 0.0 | 416.0 / 24.363 |
| renderer_off | 24.0 / 8.527 | 24.0 / 8.527 | 0.0 / 0.0 | 416.0 / 14.966 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 398948.971 (599062.854) | 33.404 | 1.773 | 493212 / 568728 | 491608 (2097152.0) | 171 / 206 | 0.0 / 0 |
| flythrough | 482547.593 (760935.301) | 36.585 | 1.086 | 2106452 / 7711240 | 2095816 (2097152.0) | 123 / 116 | 9.403 / 74 |
| water_glass | 111307.575 (193811.32) | 42.569 | 1.133 | 9220 / 10980 | 0 (2097152.0) | 129 / 343 | 0.0 / 0 |
| nether | 29506.78 (42408.23) | 30.422 | 2.0 | 347584 / 368496 | 342400 (2097152.0) | 117 / 332 | 0.0 / 0 |
| mobs | 61540.776 (109710.179) | 43.906 | 0.967 | 610516 / 612388 | 0 (2097152.0) | 46 / 39 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 6424 / 5476 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 32001.694 (56995.63) | 43.852 | 1.279 | 237540 / 124924 | 139392 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion_move | 23938.721 (42542.367) | 43.73 | 1.26 | 650016 / 1156620 | 575040 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21836.457 (47203.275) | 53.74 | 1.215 | 32840 / 57892 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21592.486 (27609.152) | 21.792 | 1.005 | 758820 / 1324516 | 756096 (2097152.0) | 121 / 345 | 0.0 / 0 |
| water_glass_oit | 111551.268 (194235.643) | 42.569 | 1.133 | 9668 / 11428 | 0 (2097152.0) | 213 / 188 | 0.0 / 0 |
| translucent_move_oit | 21741.34 (27847.864) | 21.928 | 1.006 | 729556 / 1273684 | 724864 (2097152.0) | 206 / 176 | 0.0 / 0 |
| flat_plants | 9102.204 (12478.958) | 27.06 | 1.045 | 1940 / 4340 | 0 (2097152.0) | 125 / 346 | 0.0 / 0 |
| renderer_off | 20763.312 (39370.957) | 47.262 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 38 / 2 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.389 (5146.952) | 41.531 | 1.091 | 86324 / 149896 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79396 / 122808 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.879 (109) | 4.152 (93) | 1.175 | 4.904 (59) | 0 | 964 / 0 | 9.289 / 12.337 | 4.804 / 7.778 |
| flythrough | 6.156 (1621) | 6.897 (1559) | 0.893 | 6.162 (1619) | 0 | 1406 / 0 | 7.97 / 10.568 | 5.146 / 7.019 |
| water_glass | 2.722 (15) | 2.715 (14) | 1.003 | None (0) | 0 | 1278 / 0 | 8.9 / 11.529 | 4.642 / 7.247 |
| nether | 2.682 (38) | 4.32 (31) | 0.621 | 2.551 (22) | 0 | 1906 / 0 | 7.493 / 9.618 | 3.967 / 5.89 |
| mobs | 0.85 (13) | 0.772 (6) | 1.101 | None (0) | 0 | 2137 / 0 | 7.287 / 9.321 | 3.87 / 5.645 |
| outline | 0.469 (12) | 0.29 (13) | 1.617 | None (0) | 0 | 2197 / 0 | 7.184 / 9.196 | 3.796 / 5.52 |
| occlusion | 1.416 (45) | 0.81 (37) | 1.748 | 2.588 (6) | 0 | 2342 / 0 | 6.995 / 8.939 | 3.711 / 5.39 |
| occlusion_move | 2.3 (66) | 2.614 (60) | 0.88 | 4.036 (30) | 0 | 2510 / 0 | 6.705 / 8.592 | 3.49 / 5.032 |
| occlusion_corner | 1.732 (97) | 1.65 (110) | 1.05 | 1.648 (1) | 0 | 2794 / 0 | 6.251 / 7.972 | 3.187 / 4.491 |
| translucent_move | 3.723 (113) | 3.864 (110) | 0.964 | 5.62 (34) | 0 | 3175 / 0 | 6.069 / 7.828 | 3.199 / 4.518 |
| water_glass_oit | 4.065 (154) | 4.148 (150) | 0.98 | None (0) | 0 | 412 / 0 | 8.07 / 11.092 | 4.813 / 5.92 |
| translucent_move_oit | 3.743 (195) | 4.922 (216) | 0.76 | 4.197 (26) | 0 | 964 / 0 | 5.939 / 8.001 | 3.42 / 4.568 |
| flat_plants | 2.078 (77) | 1.939 (86) | 1.072 | None (0) | 0 | 407 / 0 | 6.766 / 8.548 | 2.92 / 3.906 |
| renderer_off | 0.568 (24) | 0.535 (21) | 1.062 | None (0) | 0 | 318 / 0 | 8.49 / 12.218 | 3.945 / 4.964 |
| particles | 0.393 (24) | 0.267 (30) | 1.472 | None (0) | 0 | 3203 / 0 | 6.022 / 7.767 | 3.158 / 4.48 |
| animation | 1.117 (18) | 1.393 (18) | 0.802 | 1.278 (4) | 0 | 3278 / 0 | 5.911 / 7.614 | 3.045 / 4.336 |
| animated_items | 0.457 (32) | 0.301 (42) | 1.518 | 1.18 (2) | 0 | 3310 / 0 | 5.862 / 7.549 | 2.989 / 4.265 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.228 | 659.836 | 16 (vanilla 28) | 1393688 | 42.494 / 0.113 | 23.101 / 40.0 | 37.215 | 2629 / 0 | 4.904 (9.818) |
| flythrough | plain, one multi-draw per region and layer | 59.065 | 751.675 | 16 (vanilla 28) | 5151160 | 15.343 / 1.04 | 85.018 / 112.0 | 137.551 | 6495 / 0 | 6.162 (18.049) |
| water_glass | plain, one multi-draw per region and layer | 14.035 | 105.263 | 16 (vanilla 28) | 776544 | 34.97 / 0.098 | 12.503 / 40.0 | 20.736 | 3274 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.026 | 43.092 | 16 (vanilla 28) | 959908 | 29.39 / 0.177 | 15.284 / 20.0 | 25.632 | 4341 / 0 | 2.551 (4.022) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.114 | 16 (vanilla 28) | 598372 | 26.794 / 0.156 | 9.55 / 16.0 | 15.978 | 4793 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 87112 | 26.348 / 0.155 | 1.397 / 16.0 | 2.326 | 4888 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 174352 | 24.893 / 0.146 | 2.772 / 20.0 | 4.656 | 5158 / 0 | 2.588 (3.159) |
| occlusion_move | plain, one multi-draw per region and layer | 6.04 | 33.884 | 16 (vanilla 28) | 221960 | 23.321 / 0.136 | 3.529 / 20.0 | 5.927 | 5492 / 0 | 4.036 (9.195) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.068 | 60.885 | 16 (vanilla 28) | 122728 | 22.099 / 0.129 | 1.931 / 20.0 | 3.277 | 5876 / 0 | 1.648 (1.634) |
| translucent_move | plain, one multi-draw per region and layer | 4.395 | 23.076 | 16 (vanilla 28) | 809884 | 19.117 / 0.117 | 13.093 / 28.0 | 21.626 | 6759 / 0 | 5.62 (15.679) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.075 | 113.531 | 16 (vanilla 28) | 767856 | 7.577 / 0.044 | 12.354 / 20.0 | 20.504 | 1081 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.466 | 37.282 | 16 (vanilla 28) | 787336 | 6.774 / 0.105 | 12.737 / 28.0 | 21.024 | 2399 / 0 | 4.197 (11.85) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.044 | 16 (vanilla 28) | 876940 | 5.766 / 0.01 | 14.027 / 24.0 | 23.417 | 915 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.037 | 16 (vanilla 28) | 535616 | 2.435 / 0.021 | 8.527 / 24.0 | 14.302 | 594 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.079 / 0.117 | 0.131 / 28.0 | 0.225 | 6800 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.938 / 0.116 | 0.302 / 28.0 | 0.518 | 6902 / 0 | 1.278 (2.216) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.888 / 0.116 | 0.153 / 28.0 | 0.261 | 6951 / 0 | 1.18 (1.978) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 51 (0.025 / 0.041 / 0.057; 0) | 0 | 26832 / 0 / 0 |
| flythrough | 185.823 | 25.863 | 0.0 | 0 | 0 | 869 (0.028 / 0.048 / 6.044; 0) | 46 | 23042 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1604 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1192 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.012 / 0.024; 0) | 32 | 1190 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.123 / 0.164 / 2.316; 0) | 180 | 3409 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 642 | 0 (None / None / None; 0) | 0 | 856 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 621 | 0 (None / None / None; 0) | 0 | 1449 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2000 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2352 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 346.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.031 (0.115; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.403 | 1.0 (0.0, 0.0) | 1.169 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.055; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.144 (0.445; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 29.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 50.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.076 (0.144; 0) | 0 | 3576 / 1618736 / 0 / 0 |
| occlusion_move | 52.351 | 10.0 (9.0, 2.37) | 6.0 (6.0, 2.281) | 0.068 (0.288; 0) | 0 | 2767 / 1499224 / 0 / 0 |
| occlusion_corner | 81.863 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.181 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.691 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.097; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 267.0 / 344.0 (22.4) | 267.0 / 77.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3234 / 0 |
| flythrough | two-phase | 311.62 / 400.28 (22.1) | 304.02 / 96.26 / 7.6 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 2634 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 8700 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 30771 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9825 / 0 |
| outline | two-phase | 6.0 / 29.0 (79.3) | 6.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3450 / 0 |
| occlusion | two-phase | 26.0 / 50.0 (48.0) | 26.0 / 24.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3576 / 0 |
| occlusion_move | two-phase | 22.4 / 52.31 (57.2) | 22.35 / 29.96 / 0.05 | 1.0 | 0.0 (0.0, 0.05; 100.0) | 14400.0 | 4418 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.68 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3161 / 0 |
| translucent_move | two-phase | 15.65 / 136.05 (88.5) | 15.63 / 120.42 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 14569 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4611 / 0 |
| translucent_move_oit | two-phase | 15.67 / 136.04 (88.5) | 15.62 / 120.43 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6146 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 17732 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14847 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.141 / 0.228 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 83.835 / 0.36 | 0.022 / 0.008 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.177 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.831 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.94 / 53.993 | 0.015 / 0.028 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.484 | 0.958 / 0.859 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 32.59 / 8.566 | 0.065 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 105.949 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.566 / 11.532 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 56.08 / 56.21 | 0.012 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.356 / 11.261 | 0.006 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 7.515 | 0.569 / 0.868 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.372 / 2.21 | 0.013 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | 89.147 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.051 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.009 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
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

## Suite pack

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
- quicksilver-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
pack/quicksilver-full: bench kinetics_flat: median meshing time 5.61 ms per section against vanilla's compiler 5.177 ms (1.084x; limit 5.695 ms; 40 pairs): reported, not gated (open gap)

pack/quicksilver-full: bench kinetics_instancing: median meshing time 5.673 ms per section against vanilla's compiler 6.607 ms (0.859x; limit 6.607 ms; 40 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
pack/quicksilver-old: bench kinetics_flat: median meshing time 4.557 ms per section against vanilla's compiler 3.925 ms (1.161x; limit 4.317 ms; 40 pairs): reported, not gated (open gap)

pack/quicksilver-old: bench kinetics_instancing: median meshing time 7.511 ms per section against vanilla's compiler 6.596 ms (1.139x; limit 6.596 ms; 40 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
pack/quicksilver-vk: bench kinetics_flat: median meshing time 5.575 ms per section against vanilla's compiler 7.023 ms (0.794x; limit 7.725 ms; 40 pairs): reported, not gated (open gap)

pack/quicksilver-vk: bench kinetics_instancing: median meshing time 5.806 ms per section against vanilla's compiler 6.679 ms (0.869x; limit 6.679 ms; 40 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
pack/quicksilver-2p-old: bench kinetics_flat: median meshing time 5.928 ms per section against vanilla's compiler 4.829 ms (1.228x; limit 5.312 ms; 40 pairs): reported, not gated (open gap)

pack/quicksilver-2p-old: bench kinetics_instancing: median meshing time 5.338 ms per section against vanilla's compiler 6.136 ms (0.87x; limit 6.136 ms; 40 pairs): reported, not gated (open gap)

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
| minimap | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| geckolib | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| jei | 0.1185 | 0.4 | 0.0627 | 0.1092 | 0.0734 | 0.1219 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| terrain | 0.0 | 0.3 | 0.0051 | 0.0051 | 0.005 | 0.0051 |
| continuity | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| kinetics | 0.005 | 0.3 | 0.0031 | 0.014 | 0.0156 | 0.0087 |
| kinetics_instancing | 0.0155 | 0.3 | 0.0041 | 0.0116 | 0.0093 | 0.0101 |
| kinetics_flat | 0.0098 | 0.3 | 0.0102 | 0.0176 | 0.012 | 0.012 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| minimap | 99.12 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| geckolib | 97.54 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| jei | 97.26 | 10 | 0 (2584) | 0 (2584) | 0 (2584) | 0 (2584) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| terrain | 91.36 | 340 | 213 (3476) | 213 (3476) | 203 (3286) | 213 (3476) |
| continuity | 98.03 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| create_ct | 98.41 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| kinetics | 95.56 | 30 | 8 (838) | 8 (838) | 7 (880) | 8 (838) |
| kinetics_instancing | 95.56 | 30 | 8 (838) | 8 (838) | 7 (880) | 8 (838) |
| kinetics_flat | 95.65 | 30 | 8 (917) | 8 (917) | 7 (964) | 8 (917) |

Strict picture where the vanilla runs drawing the same way agree (package 5, Create scenes: Flywheel on in vanilla a and b, off in vanilla old and Vulkan), same strict limits:

| scene | runs | vanilla runs | agree on % of pixels | strict pixels |
|---|---|---|---|---|
| kinetics | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics | Quicksilver | vanilla-old and vanilla-vk | 96.04 | old-gpu 10, vulkan 11, old-gpu-2p 8 |
| kinetics | measure | vanilla-old and vanilla-vk | 96.04 | old-gpu 3, vulkan 0, old-gpu-2p 3 |
| kinetics_instancing | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics_instancing | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics_instancing | Quicksilver | vanilla-old and vanilla-vk | 96.04 | old-gpu 8, vulkan 7, old-gpu-2p 8 |
| kinetics_instancing | measure | vanilla-old and vanilla-vk | 96.04 | old-gpu 0, vulkan 0, old-gpu-2p 0 |
| kinetics_flat | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics_flat | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics_flat | Quicksilver | vanilla-old and vanilla-vk | 96.03 | old-gpu 8, vulkan 7, old-gpu-2p 9 |
| kinetics_flat | measure | vanilla-old and vanilla-vk | 96.03 | old-gpu 0, vulkan 1, old-gpu-2p 0 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| minimap | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| geckolib | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| jei | 0.04 / 0 | 0.1222 / 0 | 0.1241 / 0 | 0.1222 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| terrain | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| continuity | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| kinetics | 0.0061 / 0 | 0.011 / 0 | 0.0104 / 0 | 0.011 / 0 |
| kinetics_instancing | 0.0023 / 0 | 0.0129 / 0 | 0.0115 / 0 | 0.0129 / 0 |
| kinetics_flat | 0.0137 / 0 | 0.0003 / 0 | 0.0105 / 0 | 0.0003 / 0 |

### Counts, pack full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| minimap | 41.68 (base 41.67) | 61 (base 63) | 13076 (base 13396) | 340.28 (base 343.96) | 7.63 (base 8.79) |
| geckolib | 9.67 (base 9.67) | 15 (base 15) | 65352 (base 65352) | 339.38 (base 343.38) | 7.71 (base 8.87) |
| jei | 23.67 (base 23.67) | 15 (base 15) | 43856 (base 43856) | 338.3 (base 339.06) | 8.34 (base 9.1) |
| ponder | 82.63 (base 82.64) | 15 (base 15) | 53520 (base 53520) | 338.21 (base 338.07) | 8.34 (base 9.1) |
| terrain | 13.0 (base 13.0) | 12 (base 12) | 26756 (base 26812) | 362.54 (base 362.99) | 10.31 (base 9.07) |
| continuity | 7.67 (base 7.67) | 12 (base 12) | 1816 (base 1816) | 347.99 (base 348.99) | 10.31 (base 9.07) |
| create_ct | 7.67 (base 7.67) | 12 (base 12) | 1664 (base 1664) | 346.69 (base 347.7) | 11.09 (base 9.85) |
| kinetics | 9.18 (base 9.2) | 13 (base 13) | 7696 (base 7672) | 341.29 (base 342.53) | 11.79 (base 10.56) |
| kinetics_instancing | 8.18 (base 8.21) | 13 (base 13) | 7712 (base 7736) | 330.9 (base 332.96) | 6.01 (base 6.09) |
| kinetics_flat | 9.17 (base 9.17) | 13 (base 13) | 7644 (base 7696) | 332.46 (base 332.88) | 6.01 (base 6.07) |

Draw calls against vanilla measured in the same run (measure-full), pack full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| minimap | 41.68 / 42 (29.34) | 128.96 / 171 (29.46) | median and average, x 1.10 + 2 |
| geckolib | 9.67 / 10 (30.0) | 9.67 / 10 (30.0) | median and average, x 1.10 + 2 |
| jei | 23.67 / 24 (30.0) | 109.26 / 153 (30.0) | median and average, x 1.10 + 2 |
| ponder | 82.63 / 83 (30.03) | 168.29 / 212 (30.03) | median and average, x 1.10 + 2 |
| terrain | 13.0 / 13 (8.69) | 137.0 / 137 (8.91) | median and average, x 1.10 + 2 |
| continuity | 7.67 / 8 (30.0) | 93.33 / 137 (30.01) | median and average, x 1.10 + 2 |
| create_ct | 7.67 / 8 (30.0) | 93.26 / 137 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 9.18 / 9 (29.96) | 94.96 / 138 (29.95) | median and average, at most vanilla |
| kinetics_instancing | 8.18 / 8 (30.0) | 94.76 / 138 (30.01) | median and average, at most vanilla |
| kinetics_flat | 9.17 / 9 (29.76) | 94.74 / 138 (30.0) | median and average, at most vanilla |

Terrain GPU memory, pack full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| minimap | 52.0 / 0.215 | 52.0 / 0.215 | 0.0 / 0.0 | 128.0 / 0.386 |
| geckolib | 52.0 / 0.328 | 52.0 / 0.328 | 0.0 / 0.0 | 256.0 / 0.583 |
| jei | 52.0 / 0.678 | 52.0 / 0.678 | 0.0 / 0.0 | 416.0 / 1.096 |
| ponder | 52.0 / 0.679 | 52.0 / 0.679 | 0.0 / 0.0 | 416.0 / 1.097 |
| terrain | 56.0 / 24.097 | 56.0 / 24.097 | 0.0 / 0.0 | 416.0 / 40.902 |
| continuity | 56.0 / 0.302 | 56.0 / 0.302 | 0.0 / 0.0 | 416.0 / 0.516 |
| create_ct | 56.0 / 0.216 | 56.0 / 0.216 | 0.0 / 0.0 | 416.0 / 0.372 |
| kinetics | 56.0 / 0.356 | 56.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |
| kinetics_instancing | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |
| kinetics_flat | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |


Package 4b, pack full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| minimap | 3225.495 (6831.638) | 52.786 | 1.0 | 13076 / 13076 | 0 (2097152.0) | 1 / 5 | 0.0 / 0 |
| geckolib | 4213.022 (9111.185) | 53.76 | 0.619 | 65352 / 65612 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| jei | 20.033 (24.04) | 16.667 | 1.5 | 568052 / 568032 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| ponder | 18.03 (24.04) | 25.0 | 1.5 | 315688 / 315688 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| terrain | 443006.012 (579928.925) | 23.61 | 1.154 | 26756 / 28576 | 0 (2097152.0) | 173 / 178 | 0.0 / 0 |
| continuity | 4511.519 (8586.311) | 47.457 | 0.955 | 1816 / 1876 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| create_ct | 2730.551 (5665.442) | 51.803 | 1.0 | 1664 / 1704 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics | 5443.072 (10395.326) | 47.639 | 1.0 | 7788 / 7804 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics_instancing | 5833.723 (11182.638) | 47.832 | 1.0 | 7804 / 7804 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| kinetics_flat | 5443.148 (10395.471) | 47.639 | 1.0 | 7764 / 7804 | 0 (2097152.0) | 2 / 0 | 0.0 / 0 |

Package 4c, pack full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| minimap | 1.292 (30) | 1.194 (32) | 1.082 | None (0) | 0 | 351 / 0 | 18.153 / 22.335 | 11.875 / 17.36 |
| geckolib | 0.705 (18) | 0.569 (18) | 1.239 | None (0) | 0 | 378 / 0 | 16.978 / 20.922 | 10.962 / 15.385 |
| jei | 0.568 (1) | 0.213 (1) | 2.667 | None (0) | 0 | 394 / 0 | 16.518 / 20.315 | 10.665 / 14.876 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 395 / 0 | 16.478 / 20.264 | 10.587 / 14.842 |
| terrain | 3.965 (3) | 5.018 (5) | 0.79 | None (0) | 0 | 1258 / 0 | 9.758 / 11.985 | 6.048 / 7.121 |
| continuity | 1.215 (54) | 0.729 (47) | 1.667 | None (0) | 0 | 1326 / 0 | 9.341 / 11.479 | 5.611 / 6.668 |
| create_ct | 0.831 (60) | 1.218 (53) | 0.682 | None (0) | 0 | 1385 / 0 | 9.033 / 11.08 | 5.441 / 6.409 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1468 / 0 | 8.635 / 10.582 | 5.071 / 6.071 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 9.03 / 8.466 | 5.673 / 6.607 |
| kinetics_flat | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 9.319 / 8.009 | 5.61 / 5.177 |

Terrain module, pack full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| minimap | indirect, one multi-draw per arena and layer | 1.002 | 16.027 | 16 (vanilla 28) | 13640 | 22.457 / 0.033 | 0.215 / 52.0 | 0.364 | 797 / 0 | None (None) |
| geckolib | indirect, one multi-draw per arena and layer | 1.002 | 21.035 | 16 (vanilla 28) | 20832 | 21.938 / 0.032 | 0.328 / 52.0 | 0.556 | 860 / 0 | None (None) |
| jei | indirect, one multi-draw per arena and layer | 1.002 | 2.003 | 16 (vanilla 28) | 38108 | 22.172 / 0.031 | 0.678 / 52.0 | 1.018 | 888 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 2.003 | 16 (vanilla 28) | 38132 | 22.172 / 0.031 | 0.679 / 52.0 | 1.018 | 889 / 0 | None (None) |
| terrain | indirect, one multi-draw per arena and layer | 3.017 | 815.688 | 16 (vanilla 28) | 1438632 | 24.027 / 0.02 | 24.097 / 56.0 | 38.416 | 2947 / 0 | None (None) |
| continuity | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 18516 | 23.384 / 0.019 | 0.302 / 56.0 | 0.494 | 3081 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 15.025 | 16 (vanilla 28) | 13460 | 22.858 / 0.019 | 0.216 / 56.0 | 0.359 | 3192 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 22328 | 22.786 / 0.04 | 0.356 / 56.0 | 0.596 | 3291 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 24.04 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |
| kinetics_flat | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |

Translucency, pack full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| minimap | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| geckolib | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| jei | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| terrain | 276.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 48024 / 0 / 0 |
| continuity | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, pack full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| minimap | 16.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| geckolib | 18.0 | 7.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| jei | 2.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 3.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| terrain | 432.0 | 1.0 (0.0, 0.0) | 2.0 (0.0, 0.0) | 0.002 (0.006; 0) | 0 | 0 / 0 / 0 / 0 |
| continuity | 17.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 15.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 20.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 20.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.003 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_flat | 20.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.003 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), pack full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| minimap | two-phase | 16.0 / 16.0 (0.0) | 16.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| geckolib | two-phase | 13.0 / 18.0 (27.8) | 13.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 750 / 0 |
| jei | two-phase | 2.0 / 2.0 (0.0) | 2.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| ponder | two-phase | 2.0 / 3.0 (33.3) | 2.0 / 1.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 150 / 0 |
| terrain | two-phase | 299.0 / 429.0 (30.3) | 299.0 / 130.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5590 / 0 |
| continuity | two-phase | 16.0 / 17.0 (5.9) | 16.0 / 1.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 150 / 0 |
| create_ct | two-phase | 13.0 / 15.0 (13.3) | 13.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 300 / 0 |
| kinetics | two-phase | 18.0 / 20.0 (10.0) | 18.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 300 / 0 |
| kinetics_instancing | still | 20.0 / 20.0 (0.0) | 20.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics_flat | two-phase | 18.0 / 20.0 (10.0) | 18.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 298 / 0 |

Effects, pack full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| minimap | 88.285 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.001 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 73 (0) | 0.0 / 0.0 / 0.0 | 0 / 0 | 0.0 |
| jei | 86.594 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.0 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| ponder | 86.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| terrain | 130.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 73 (1) | 26.0 / 1.0 / 25.0 | 0 / 0 | 10.0 |
| continuity | 86.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| create_ct | 86.594 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics | 86.811 / 0.0 | 0.486 / 0.509 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.516 / 0.51 | 0.003 / 0.004 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics_instancing | 86.594 / 0.0 | 0.497 / 0.514 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.505 / 0.515 | 0.009 / 0.013 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| kinetics_flat | 86.594 / 0.0 | 0.476 / 0.497 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.483 / 0.496 | 0.008 / 0.013 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |

GUI pass, pack full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| minimap | 5.0 / 5.0 | 30.0 / 30.0 | 19.0 / 19.0 | 5.0 / 5.0 (pipelines 5.0, textures 4.0, scissors 1.0) | 5.0 / 5.0 (5.0 / 5.0) |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| jei | 16.0 / 16.0 | 2.0 / 2.0 | 190.0 / 190.0 | 6.0 / 6.0 (pipelines 4.0, textures 6.0, scissors 1.0) | 16.0 / 16.0 (6.0 / 6.0) |
| ponder | 75.95 / 75.95 | 1.15 / 1.11 | 167.0 / 167.0 | 71.0 / 71.0 (pipelines 5.0, textures 70.0, scissors 1.0) | 74.98 / 74.98 (72.0 / 72.0) |
| terrain | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| continuity | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_flat | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, pack old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| minimap | 41.67 (base 41.67) | 57 (base 57) | 12180 (base 12180) | 340.45 (base 343.04) | 8.87 (base 8.88) |
| geckolib | 9.67 (base 9.67) | 12 (base 12) | 64644 (base 64644) | 339.15 (base 342.19) | 8.87 (base 8.88) |
| jei | 23.67 (base 23.67) | 13 (base 13) | 43764 (base 43764) | 338.06 (base 338.76) | 9.1 (base 9.12) |
| ponder | 82.63 (base 82.64) | 13 (base 13) | 53412 (base 53412) | 337.84 (base 338.1) | 9.1 (base 9.12) |
| terrain | 82.0 (base 83.0) | 10 (base 10) | 1124 (base 1124) | 362.84 (base 362.58) | 9.07 (base 9.01) |
| continuity | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 348.07 (base 348.52) | 9.07 (base 9.01) |
| create_ct | 7.67 (base 7.67) | 10 (base 10) | 1124 (base 1124) | 347.05 (base 347.41) | 9.93 (base 9.79) |
| kinetics | 11.2 (base 11.2) | 11 (base 11) | 260452 (base 260480) | 341.71 (base 342.34) | 10.56 (base 10.57) |
| kinetics_instancing | 11.21 (base 11.19) | 11 (base 11) | 260480 (base 260480) | 331.25 (base 332.62) | 6.07 (base 6.03) |
| kinetics_flat | 11.21 (base 11.17) | 11 (base 11) | 260452 (base 260432) | 331.31 (base 333.03) | 6.09 (base 6.03) |

Draw calls against vanilla measured in the same run (measure-old), pack old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| minimap | 41.67 / 42 (29.97) | 142.26 / 186 (30.01) | median and average, x 1.10 + 2 |
| geckolib | 9.67 / 10 (30.01) | 33.67 / 34 (30.0) | median and average, x 1.10 + 2 |
| jei | 23.67 / 24 (30.0) | 110.33 / 154 (30.01) | median and average, x 1.10 + 2 |
| ponder | 82.63 / 83 (30.01) | 170.29 / 214 (30.03) | median and average, x 1.10 + 2 |
| terrain | 82.0 / 82 (10.92) | 1161.0 / 1161 (11.37) | median and average, x 1.10 + 2 |
| continuity | 6.67 / 7 (30.0) | 114.26 / 158 (30.0) | median and average, x 1.10 + 2 |
| create_ct | 7.67 / 8 (30.0) | 107.19 / 151 (30.01) | median and average, x 1.10 + 2 |
| kinetics | 11.2 / 11 (30.01) | 117.7 / 161 (30.01) | median and average, at most vanilla |
| kinetics_instancing | 11.21 / 11 (30.01) | 117.76 / 161 (30.01) | median and average, at most vanilla |
| kinetics_flat | 11.21 / 11 (30.01) | 117.65 / 161 (30.01) | median and average, at most vanilla |

Terrain GPU memory, pack old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| minimap | 28.0 / 0.889 | 28.0 / 0.889 | 0.0 / 0.0 | 256.0 / 1.889 |
| geckolib | 28.0 / 1.002 | 28.0 / 1.002 | 0.0 / 0.0 | 256.0 / 2.086 |
| jei | 28.0 / 1.352 | 28.0 / 1.352 | 0.0 / 0.0 | 416.0 / 2.599 |
| ponder | 28.0 / 1.353 | 28.0 / 1.353 | 0.0 / 0.0 | 416.0 / 2.6 |
| terrain | 40.0 / 24.772 | 40.0 / 24.772 | 0.0 / 0.0 | 416.0 / 42.405 |
| continuity | 40.0 / 0.976 | 40.0 / 0.976 | 0.0 / 0.0 | 416.0 / 2.018 |
| create_ct | 40.0 / 0.89 | 40.0 / 0.89 | 0.0 / 0.0 | 416.0 / 1.875 |
| kinetics | 40.0 / 1.03 | 40.0 / 1.03 | 0.0 / 0.0 | 256.0 / 2.135 |
| kinetics_instancing | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |
| kinetics_flat | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |


Package 4b, pack old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| minimap | 3225.376 (6831.386) | 52.786 | 1.0 | 12180 / 12756 | 0 (2097152.0) | 2 / 0 | 0.0 / 0 |
| geckolib | 4213.022 (9111.185) | 53.76 | 0.619 | 64644 / 64932 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| jei | 20.033 (24.04) | 16.667 | 1.5 | 43764 / 43796 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| ponder | 18.03 (24.04) | 25.0 | 1.5 | 53460 / 53508 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| terrain | 412421.202 (579240.936) | 28.8 | 1.524 | 1124 / 8036 | 0 (2097152.0) | 218 / 227 | 0.0 / 0 |
| continuity | 4511.519 (8586.311) | 47.457 | 0.955 | 1124 / 1396 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| create_ct | 2730.536 (5665.411) | 51.803 | 1.0 | 1124 / 1364 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics | 5443.072 (10395.326) | 47.639 | 1.0 | 260544 / 260892 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics_instancing | 5443.072 (10395.326) | 47.639 | 1.0 | 260572 / 260864 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics_flat | 5443.072 (10395.326) | 47.639 | 1.0 | 260544 / 260864 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, pack old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| minimap | 1.764 (30) | 0.497 (46) | 3.549 | None (0) | 0 | 335 / 0 | 20.042 / 23.132 | 13.73 / 17.261 |
| geckolib | 1.553 (18) | 0.827 (18) | 1.878 | None (0) | 0 | 362 / 0 | 18.712 / 21.579 | 12.913 / 16.163 |
| jei | 0.497 (1) | 0.264 (1) | 1.883 | None (0) | 0 | 378 / 0 | 18.554 / 21.4 | 12.913 / 15.716 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 379 / 0 | 18.507 / 21.344 | 12.902 / 15.584 |
| terrain | 5.587 (3) | 4.274 (8) | 1.307 | None (0) | 0 | 1241 / 0 | 10.801 / 12.53 | 6.635 / 7.972 |
| continuity | 1.45 (41) | 0.554 (54) | 2.617 | None (0) | 0 | 1309 / 0 | 10.341 / 11.988 | 6.235 / 7.407 |
| create_ct | 1.317 (43) | 0.665 (46) | 1.98 | None (0) | 0 | 1368 / 0 | 9.997 / 11.565 | 5.894 / 7.007 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1461 / 0 | 9.483 / 10.986 | 5.358 / 6.503 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 9.364 / 8.971 | 7.511 / 6.596 |
| kinetics_flat | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 8.358 / 6.724 | 4.557 / 3.925 |

Terrain module, pack old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| minimap | plain, one multi-draw per region and layer | 2.003 | 16.027 | 16 (vanilla 28) | 54472 | 23.078 / 0.049 | 0.889 / 28.0 | 1.455 | 754 / 0 | None (None) |
| geckolib | plain, one multi-draw per region and layer | 2.003 | 21.035 | 16 (vanilla 28) | 61664 | 22.506 / 0.048 | 1.002 / 28.0 | 1.647 | 817 / 0 | None (None) |
| jei | plain, one multi-draw per region and layer | 2.003 | 2.003 | 16 (vanilla 28) | 78940 | 22.745 / 0.047 | 1.352 / 28.0 | 2.108 | 845 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 2.003 | 2.003 | 16 (vanilla 28) | 78964 | 22.745 / 0.047 | 1.353 / 28.0 | 2.109 | 846 / 0 | None (None) |
| terrain | plain, one multi-draw per region and layer | 73.335 | 814.72 | 16 (vanilla 28) | 1479464 | 24.31 / 0.026 | 24.772 / 40.0 | 39.506 | 2902 / 0 | None (None) |
| continuity | plain, one multi-draw per region and layer | 3.005 | 22.037 | 16 (vanilla 28) | 59348 | 23.719 / 0.025 | 0.976 / 40.0 | 1.585 | 3024 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 4.007 | 15.025 | 16 (vanilla 28) | 54292 | 23.251 / 0.024 | 0.89 / 40.0 | 1.45 | 3121 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 63160 | 23.204 / 0.051 | 1.03 / 40.0 | 1.687 | 3233 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |
| kinetics_flat | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |

Translucency, pack old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| minimap | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| geckolib | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| jei | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| terrain | 276.0 | 56.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 60444 / 0 / 0 |
| continuity | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 602 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, pack old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| minimap | 16.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| geckolib | 18.0 | 7.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| jei | 2.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 3.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| terrain | 432.0 | 1.0 (0.0, 0.0) | 3.0 (1.0, 0.0) | 0.044 (0.163; 0) | 0 | 0 / 0 / 0 / 0 |
| continuity | 17.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 15.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_flat | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), pack old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| minimap | still | 16.0 / 16.0 (0.0) | 16.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| geckolib | still | 13.0 / 18.0 (27.8) | 13.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 745 / 0 |
| jei | still | 2.0 / 2.0 (0.0) | 2.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| ponder | still | 2.0 / 3.0 (33.3) | 2.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 150 / 0 |
| terrain | still | 299.0 / 429.0 (30.3) | 299.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7150 / 0 |
| continuity | still | 16.0 / 17.0 (5.9) | 16.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 150 / 0 |
| create_ct | still | 13.0 / 15.0 (13.3) | 13.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 300 / 0 |
| kinetics | still | 18.0 / 20.0 (10.0) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 300 / 0 |
| kinetics_instancing | still | 18.0 / 20.0 (10.0) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 300 / 0 |
| kinetics_flat | still | 18.0 / 20.0 (10.0) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 298 / 0 |

Effects, pack old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| minimap | 86.594 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 73 (0) | 0.0 / 0.0 / 0.0 | 0 / 0 | 0.0 |
| jei | 86.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| ponder | 86.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| terrain | 130.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.112 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 1.0 / 25.0 | 0 / 0 | 10.0 |
| continuity | 86.594 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| create_ct | 86.522 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics | 86.522 / 0.0 | 0.514 / 0.536 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.538 / 0.535 | 0.002 / 0.007 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics_instancing | 86.594 / 0.0 | 0.497 / 0.546 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.528 / 0.547 | 0.007 / 0.01 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| kinetics_flat | 86.522 / 0.0 | 0.458 / 0.548 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.548 / 0.548 | 0.007 / 0.01 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |

GUI pass, pack old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| minimap | 5.0 / 5.0 | 30.0 / 30.0 | 19.0 / 19.0 | 5.0 / 5.0 (pipelines 5.0, textures 4.0, scissors 1.0) | 5.0 / 5.0 (5.0 / 5.0) |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| jei | 16.0 / 16.0 | 2.0 / 2.0 | 190.0 / 190.0 | 6.0 / 6.0 (pipelines 4.0, textures 6.0, scissors 1.0) | 16.0 / 16.0 (7.0 / 7.0) |
| ponder | 75.96 / 75.96 | 1.0 / 1.11 | 167.0 / 167.0 | 71.0 / 71.0 (pipelines 5.0, textures 70.0, scissors 1.0) | 74.99 / 74.99 (72.0 / 72.0) |
| terrain | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| continuity | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_flat | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, pack vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| minimap | 40.68 (base 40.68) | 61 (base 61) | 13076 (base 13076) | 338.68 (base 340.88) | 8.87 (base 9.02) |
| geckolib | 8.67 (base 8.67) | 15 (base 15) | 65352 (base 65352) | 337.77 (base 339.97) | 8.95 (base 9.02) |
| jei | 22.67 (base 22.67) | 15 (base 15) | 43856 (base 43856) | 337.33 (base 338.63) | 9.1 (base 9.26) |
| ponder | 81.63 (base 81.63) | 15 (base 15) | 53520 (base 53520) | 334.2 (base 338.38) | 9.1 (base 9.26) |
| terrain | 12.0 (base 12.0) | 12 (base 12) | 26756 (base 26812) | 362.0 (base 361.79) | 8.99 (base 9.15) |
| continuity | 6.67 (base 6.67) | 12 (base 12) | 1816 (base 1816) | 347.07 (base 347.03) | 8.99 (base 9.15) |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1664 (base 1664) | 345.84 (base 345.74) | 9.77 (base 9.93) |
| kinetics | 9.13 (base 9.17) | 13 (base 13) | 261192 (base 261212) | 341.05 (base 341.27) | 10.55 (base 10.55) |
| kinetics_instancing | 9.19 (base 9.22) | 13 (base 13) | 261240 (base 261240) | 331.65 (base 332.37) | 6.01 (base 6.01) |
| kinetics_flat | 9.17 (base 9.18) | 13 (base 13) | 261212 (base 261212) | 331.88 (base 332.51) | 6.01 (base 6.01) |

Draw calls against vanilla measured in the same run (measure-vk), pack vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| minimap | 40.68 / 41 (29.49) | 128.81 / 171 (29.51) | median and average, x 1.10 + 2 |
| geckolib | 8.67 / 9 (29.91) | 9.67 / 10 (29.84) | median and average, x 1.10 + 2 |
| jei | 22.67 / 23 (29.8) | 110.07 / 153 (29.75) | median and average, x 1.10 + 2 |
| ponder | 81.63 / 82 (29.77) | 169.19 / 212 (29.71) | median and average, x 1.10 + 2 |
| terrain | 12.0 / 12 (9.47) | 137.0 / 137 (10.14) | median and average, x 1.10 + 2 |
| continuity | 6.67 / 7 (29.89) | 93.92 / 137 (29.81) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (29.95) | 93.99 / 137 (29.73) | median and average, x 1.10 + 2 |
| kinetics | 9.13 / 9 (29.8) | 96.87 / 139 (29.66) | median and average, at most vanilla |
| kinetics_instancing | 9.19 / 9 (29.83) | 96.69 / 139 (29.69) | median and average, at most vanilla |
| kinetics_flat | 9.17 / 9 (29.8) | 96.41 / 139 (29.81) | median and average, at most vanilla |

Terrain GPU memory, pack vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| minimap | 40.0 / 0.215 | 40.0 / 0.215 | 0.0 / 0.0 | 128.0 / 0.386 |
| geckolib | 40.0 / 0.328 | 40.0 / 0.328 | 0.0 / 0.0 | 256.0 / 0.583 |
| jei | 40.0 / 0.678 | 40.0 / 0.678 | 0.0 / 0.0 | 416.0 / 1.096 |
| ponder | 40.0 / 0.679 | 40.0 / 0.679 | 0.0 / 0.0 | 416.0 / 1.097 |
| terrain | 40.0 / 24.097 | 40.0 / 24.097 | 0.0 / 0.0 | 416.0 / 40.902 |
| continuity | 40.0 / 0.302 | 40.0 / 0.302 | 0.0 / 0.0 | 416.0 / 0.515 |
| create_ct | 40.0 / 0.216 | 40.0 / 0.216 | 0.0 / 0.0 | 416.0 / 0.372 |
| kinetics | 40.0 / 0.356 | 40.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |
| kinetics_instancing | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |
| kinetics_flat | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |


Package 4b, pack vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| minimap | 3225.467 (6831.579) | 52.786 | 1.0 | 13076 / 12756 | 0 (2097152.0) | 9 / 10 | 0.0 / 0 |
| geckolib | 4213.033 (9111.211) | 53.76 | 0.619 | 65352 / 65452 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| jei | 20.034 (24.04) | 16.667 | 1.5 | 43856 / 43836 | 0 (2097152.0) | 3 / 2 | 0.0 / 0 |
| ponder | 18.03 (24.04) | 25.0 | 1.5 | 53568 / 53568 | 0 (2097152.0) | 4 / 1 | 0.0 / 0 |
| terrain | 442790.476 (579646.772) | 23.61 | 1.154 | 26756 / 28576 | 0 (2097152.0) | 189 / 202 | 0.0 / 0 |
| continuity | 4511.532 (8586.334) | 47.457 | 0.955 | 1816 / 1876 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| create_ct | 2730.559 (5665.458) | 51.803 | 1.0 | 1664 / 1704 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics | 5443.102 (10395.384) | 47.639 | 1.0 | 261304 / 261372 | 0 (2097152.0) | 1 / 5 | 0.0 / 0 |
| kinetics_instancing | 5443.102 (10395.384) | 47.639 | 1.0 | 261332 / 261372 | 0 (2097152.0) | 0 / 5 | 0.0 / 0 |
| kinetics_flat | 5443.133 (10395.442) | 47.639 | 1.0 | 261304 / 261344 | 0 (2097152.0) | 1 / 1 | 0.0 / 0 |

Package 4c, pack vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| minimap | 1.079 (30) | 0.581 (40) | 1.857 | None (0) | 0 | 355 / 0 | 17.765 / 22.118 | 11.918 / 15.448 |
| geckolib | 0.646 (18) | 0.385 (18) | 1.678 | None (0) | 0 | 382 / 0 | 16.612 / 20.67 | 11.005 / 14.189 |
| jei | 0.368 (1) | 0.321 (1) | 1.146 | None (0) | 0 | 398 / 0 | 16.425 / 20.373 | 10.97 / 14.189 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 399 / 0 | 16.386 / 20.323 | 10.937 / 14.179 |
| terrain | 3.354 (3) | 3.14 (7) | 1.068 | None (0) | 0 | 1262 / 0 | 9.93 / 12.47 | 6.247 / 8.12 |
| continuity | 0.869 (48) | 0.61 (56) | 1.425 | None (0) | 0 | 1330 / 0 | 9.501 / 11.912 | 5.87 / 7.529 |
| create_ct | 1.399 (60) | 1.087 (46) | 1.287 | None (0) | 0 | 1389 / 0 | 9.183 / 11.5 | 5.59 / 7.094 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1482 / 0 | 8.725 / 10.915 | 5.186 / 6.552 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 12.099 / 10.117 | 5.806 / 6.679 |
| kinetics_flat | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 9.609 / 9.121 | 5.575 / 7.023 |

Terrain module, pack vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| minimap | indirect, one multi-draw per arena and layer | 1.002 | 16.027 | 16 (vanilla 28) | 13640 | 24.247 / 0.063 | 0.215 / 40.0 | 0.364 | 815 / 0 | None (None) |
| geckolib | indirect, one multi-draw per arena and layer | 1.002 | 21.035 | 16 (vanilla 28) | 20832 | 23.66 / 0.062 | 0.328 / 40.0 | 0.556 | 878 / 0 | None (None) |
| jei | indirect, one multi-draw per arena and layer | 1.002 | 2.003 | 16 (vanilla 28) | 38108 | 23.871 / 0.06 | 0.678 / 40.0 | 1.018 | 906 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 2.003 | 16 (vanilla 28) | 38132 | 23.87 / 0.06 | 0.679 / 40.0 | 1.018 | 907 / 0 | None (None) |
| terrain | indirect, one multi-draw per arena and layer | 3.016 | 815.291 | 16 (vanilla 28) | 1438632 | 24.738 / 0.031 | 24.097 / 40.0 | 38.416 | 2965 / 0 | None (None) |
| continuity | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 18516 | 24.105 / 0.03 | 0.302 / 40.0 | 0.494 | 3092 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 15.025 | 16 (vanilla 28) | 13460 | 23.553 / 0.03 | 0.216 / 40.0 | 0.359 | 3203 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 22328 | 23.5 / 0.056 | 0.356 / 40.0 | 0.596 | 3315 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |
| kinetics_flat | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |

Translucency, pack vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| minimap | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| geckolib | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| jei | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| terrain | 276.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 52440 / 0 / 0 |
| continuity | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1198 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, pack vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| minimap | 16.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| geckolib | 18.0 | 7.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| jei | 2.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 3.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| terrain | 432.0 | 1.0 (0.0, 0.0) | 3.0 (1.0, 0.0) | 0.045 (0.072; 0) | 0 | 0 / 0 / 0 / 0 |
| continuity | 17.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 15.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_flat | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), pack vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| minimap | still | 16.0 / 16.0 (0.0) | 16.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| geckolib | still | 13.0 / 18.0 (27.8) | 13.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| jei | still | 2.0 / 2.0 (0.0) | 2.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| ponder | still | 2.0 / 3.0 (33.3) | 2.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 149 / 0 |
| terrain | still | 299.0 / 429.0 (30.3) | 299.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6110 / 0 |
| continuity | still | 16.0 / 17.0 (5.9) | 16.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 149 / 0 |
| create_ct | still | 13.0 / 15.0 (13.3) | 13.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 298 / 0 |
| kinetics | still | 18.0 / 20.0 (10.0) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 300 / 0 |
| kinetics_instancing | still | 18.0 / 20.0 (10.0) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 300 / 0 |
| kinetics_flat | still | 18.0 / 20.0 (10.0) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 298 / 0 |

Effects, pack vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| minimap | 88.136 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 73 (0) | 0.0 / 0.0 / 0.0 | 0 / 0 | 0.0 |
| jei | 87.395 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| ponder | 87.542 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| terrain | 130.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 73 (1) | 26.0 / 1.0 / 25.0 | 0 / 0 | 10.0 |
| continuity | 87.248 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| create_ct | 87.323 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics | 87.69 / 0.0 | 0.506 / 0.464 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.466 / 0.463 | 0.002 / 0.004 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics_instancing | 87.47 / 0.0 | 0.548 / 0.521 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.531 / 0.52 | 0.005 / 0.009 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| kinetics_flat | 87.248 / 0.0 | 0.49 / 0.503 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.493 / 0.503 | 0.006 / 0.009 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |

GUI pass, pack vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| minimap | 5.0 / 5.0 | 30.0 / 30.0 | 19.0 / 19.0 | 5.0 / 5.0 (pipelines 5.0, textures 4.0, scissors 1.0) | 5.0 / 5.0 (5.0 / 5.0) |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| jei | 16.0 / 16.0 | 2.0 / 2.0 | 190.0 / 190.0 | 6.0 / 6.0 (pipelines 4.0, textures 6.0, scissors 1.0) | 16.0 / 16.0 (6.0 / 6.0) |
| ponder | 75.95 / 75.97 | 1.0 / 1.11 | 167.0 / 167.0 | 71.0 / 71.0 (pipelines 5.0, textures 70.0, scissors 1.0) | 74.98 / 74.99 (72.0 / 72.0) |
| terrain | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| continuity | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_flat | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, pack old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| minimap | 42.67 (base 41.67) | 59 (base 57) | 12500 (base 12180) | 341.24 (base 343.04) | 8.87 (base 8.88) |
| geckolib | 10.67 (base 9.67) | 12 (base 12) | 64644 (base 64644) | 340.29 (base 342.19) | 8.95 (base 8.88) |
| jei | 24.67 (base 23.67) | 13 (base 13) | 43764 (base 43764) | 340.17 (base 338.76) | 9.18 (base 9.12) |
| ponder | 83.62 (base 82.64) | 13 (base 13) | 53412 (base 53412) | 340.01 (base 338.1) | 9.18 (base 9.12) |
| terrain | 83.0 (base 83.0) | 10 (base 10) | 1124 (base 1124) | 363.04 (base 362.58) | 9.07 (base 9.01) |
| continuity | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 348.73 (base 348.52) | 9.07 (base 9.01) |
| create_ct | 8.67 (base 7.67) | 10 (base 10) | 1124 (base 1124) | 347.74 (base 347.41) | 9.85 (base 9.79) |
| kinetics | 12.1 (base 11.2) | 11 (base 11) | 260432 (base 260480) | 342.91 (base 342.34) | 10.56 (base 10.57) |
| kinetics_instancing | 12.2 (base 11.19) | 11 (base 11) | 260452 (base 260480) | 332.51 (base 332.62) | 6.03 (base 6.03) |
| kinetics_flat | 12.18 (base 11.17) | 11 (base 11) | 260452 (base 260432) | 331.55 (base 333.03) | 6.03 (base 6.03) |

Draw calls against vanilla measured in the same run (measure-old), pack old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| minimap | 42.67 / 43 (29.99) | 142.26 / 186 (30.01) | median and average, x 1.10 + 2 |
| geckolib | 10.67 / 11 (30.0) | 33.67 / 34 (30.0) | median and average, x 1.10 + 2 |
| jei | 24.67 / 25 (30.01) | 110.33 / 154 (30.01) | median and average, x 1.10 + 2 |
| ponder | 83.62 / 84 (30.02) | 170.29 / 214 (30.03) | median and average, x 1.10 + 2 |
| terrain | 83.0 / 83 (9.81) | 1161.0 / 1161 (11.37) | median and average, x 1.10 + 2 |
| continuity | 7.67 / 8 (30.0) | 114.26 / 158 (30.0) | median and average, x 1.10 + 2 |
| create_ct | 8.67 / 9 (30.0) | 107.19 / 151 (30.01) | median and average, x 1.10 + 2 |
| kinetics | 12.1 / 12 (30.01) | 117.7 / 161 (30.01) | median and average, at most vanilla |
| kinetics_instancing | 12.2 / 12 (29.97) | 117.76 / 161 (30.01) | median and average, at most vanilla |
| kinetics_flat | 12.18 / 12 (30.0) | 117.65 / 161 (30.01) | median and average, at most vanilla |

Terrain GPU memory, pack old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| minimap | 52.0 / 0.215 | 52.0 / 0.215 | 0.0 / 0.0 | 256.0 / 1.889 |
| geckolib | 52.0 / 0.328 | 52.0 / 0.328 | 0.0 / 0.0 | 256.0 / 2.086 |
| jei | 52.0 / 0.678 | 52.0 / 0.678 | 0.0 / 0.0 | 416.0 / 2.599 |
| ponder | 52.0 / 0.679 | 52.0 / 0.679 | 0.0 / 0.0 | 416.0 / 2.6 |
| terrain | 56.0 / 24.097 | 56.0 / 24.097 | 0.0 / 0.0 | 416.0 / 42.405 |
| continuity | 56.0 / 0.302 | 56.0 / 0.302 | 0.0 / 0.0 | 416.0 / 2.018 |
| create_ct | 56.0 / 0.216 | 56.0 / 0.216 | 0.0 / 0.0 | 416.0 / 1.875 |
| kinetics | 56.0 / 0.356 | 56.0 / 0.356 | 0.0 / 0.0 | 256.0 / 2.135 |
| kinetics_instancing | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |
| kinetics_flat | 8.0 / 0.356 | 8.0 / 0.356 | 0.0 / 0.0 | 256.0 / 0.632 |


Package 4b, pack old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| minimap | 3225.367 (6831.367) | 52.786 | 1.0 | 12500 / 12756 | 0 (2097152.0) | 2 / 0 | 0.0 / 0 |
| geckolib | 4213.022 (9111.185) | 53.76 | 0.619 | 64644 / 64932 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| jei | 20.033 (24.04) | 16.667 | 1.5 | 43764 / 43796 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| ponder | 18.03 (24.04) | 25.0 | 1.5 | 53460 / 53508 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| terrain | 412643.323 (579552.903) | 28.8 | 1.524 | 1124 / 8036 | 0 (2097152.0) | 195 / 227 | 0.0 / 0 |
| continuity | 4511.507 (8586.287) | 47.457 | 0.955 | 1124 / 1396 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| create_ct | 2730.543 (5665.427) | 51.803 | 1.0 | 1124 / 1364 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics | 5443.042 (10395.268) | 47.639 | 1.0 | 260572 / 260892 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics_instancing | 5443.057 (10395.297) | 47.639 | 1.0 | 260544 / 260864 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| kinetics_flat | 5443.072 (10395.326) | 47.639 | 1.0 | 260544 / 260864 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, pack old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| minimap | 0.946 (30) | 0.497 (46) | 1.903 | None (0) | 0 | 434 / 0 | 17.974 / 22.108 | 12.406 / 15.969 |
| geckolib | 1.032 (18) | 0.827 (18) | 1.248 | None (0) | 0 | 461 / 0 | 17.015 / 20.942 | 11.717 / 14.658 |
| jei | 0.399 (1) | 0.264 (1) | 1.511 | None (0) | 0 | 477 / 0 | 16.61 / 20.386 | 11.551 / 13.766 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 478 / 0 | 16.576 / 20.344 | 11.539 / 13.76 |
| terrain | 4.628 (3) | 4.274 (8) | 1.083 | None (0) | 0 | 1340 / 0 | 10.635 / 14.472 | 6.204 / 7.805 |
| continuity | 0.715 (51) | 0.554 (54) | 1.291 | None (0) | 0 | 1408 / 0 | 10.202 / 13.873 | 5.83 / 7.39 |
| create_ct | 0.899 (43) | 0.665 (46) | 1.352 | None (0) | 0 | 1467 / 0 | 9.859 / 13.391 | 5.484 / 6.795 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1560 / 0 | 9.374 / 12.716 | 5.099 / 6.357 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 9.687 / 10.382 | 5.338 / 6.136 |
| kinetics_flat | None (0) | None (0) | None | None (0) | 0 | 40 / 0 | 9.249 / 8.78 | 5.928 / 4.829 |

Terrain module, pack old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| minimap | plain, one multi-draw per region and layer | 2.003 | 16.027 | 16 (vanilla 28) | 13640 | 21.52 / 0.031 | 0.215 / 52.0 | 0.364 | 1023 / 0 | None (None) |
| geckolib | plain, one multi-draw per region and layer | 2.003 | 21.035 | 16 (vanilla 28) | 20832 | 21.134 / 0.031 | 0.328 / 52.0 | 0.556 | 1086 / 0 | None (None) |
| jei | plain, one multi-draw per region and layer | 2.003 | 2.003 | 16 (vanilla 28) | 38108 | 21.328 / 0.03 | 0.678 / 52.0 | 1.018 | 1114 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 2.003 | 2.003 | 16 (vanilla 28) | 38132 | 21.328 / 0.03 | 0.679 / 52.0 | 1.018 | 1115 / 0 | None (None) |
| terrain | plain, one multi-draw per region and layer | 73.374 | 815.159 | 16 (vanilla 28) | 1438632 | 23.442 / 0.02 | 24.097 / 56.0 | 38.416 | 3171 / 0 | None (None) |
| continuity | plain, one multi-draw per region and layer | 3.005 | 22.037 | 16 (vanilla 28) | 18516 | 22.898 / 0.02 | 0.302 / 56.0 | 0.494 | 3301 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 4.007 | 15.025 | 16 (vanilla 28) | 13460 | 22.503 / 0.02 | 0.216 / 56.0 | 0.359 | 3398 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 22328 | 22.477 / 0.043 | 0.356 / 56.0 | 0.596 | 3510 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |
| kinetics_flat | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 22328 | 23.361 / 1.397 | 0.356 / 8.0 | 0.596 | 48 / 0 | None (None) |

Translucency, pack old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| minimap | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| geckolib | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| jei | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| terrain | 276.0 | 56.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 54096 / 0 / 0 |
| continuity | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, pack old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| minimap | 16.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.108; 0) | 0 | 0 / 0 / 0 / 0 |
| geckolib | 18.0 | 7.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| jei | 2.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 3.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| terrain | 432.0 | 1.0 (0.0, 0.0) | 3.0 (1.0, 0.0) | 0.041 (0.087; 0) | 0 | 0 / 0 / 0 / 0 |
| continuity | 17.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 15.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_flat | 20.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), pack old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| minimap | two-phase | 16.0 / 16.0 (0.0) | 16.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| geckolib | two-phase | 13.0 / 18.0 (27.8) | 13.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 745 / 0 |
| jei | two-phase | 2.0 / 2.0 (0.0) | 2.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| ponder | two-phase | 2.0 / 3.0 (33.3) | 2.0 / 1.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 149 / 0 |
| terrain | two-phase | 299.0 / 429.0 (30.3) | 299.0 / 130.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6370 / 0 |
| continuity | two-phase | 16.0 / 17.0 (5.9) | 16.0 / 1.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 150 / 0 |
| create_ct | two-phase | 13.0 / 15.0 (13.3) | 13.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 300 / 0 |
| kinetics | two-phase | 18.0 / 20.0 (10.0) | 18.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 300 / 0 |
| kinetics_instancing | two-phase | 18.0 / 20.0 (10.0) | 18.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 300 / 0 |
| kinetics_flat | two-phase | 18.0 / 20.0 (10.0) | 18.0 / 2.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 298 / 0 |

Effects, pack old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| minimap | 86.594 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 73 (0) | 0.0 / 0.0 / 0.0 | 0 / 0 | 0.0 |
| jei | 86.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| ponder | 86.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| terrain | 130.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 1.0 / 25.0 | 0 / 0 | 10.0 |
| continuity | 86.594 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| create_ct | 86.522 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics | 86.522 / 0.0 | 0.514 / 0.436 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.436 / 0.435 | 0.002 / 0.004 | 73 (1) | 26.0 / 0.0 / 26.0 | 0 / 0 | 1.0 |
| kinetics_instancing | 86.594 / 0.0 | 0.497 / 0.533 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.531 / 0.532 | 0.007 / 0.011 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |
| kinetics_flat | 86.522 / 0.0 | 0.458 / 0.518 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.502 / 0.517 | 0.008 / 0.013 | 73 (0) | 26.0 / 0.0 / 26.0 | 0 / 0 | 0.0 |

GUI pass, pack old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| minimap | 5.0 / 5.0 | 30.0 / 30.0 | 19.0 / 19.0 | 5.0 / 5.0 (pipelines 5.0, textures 4.0, scissors 1.0) | 5.0 / 5.0 (5.0 / 5.0) |
| geckolib | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| jei | 16.0 / 16.0 | 2.0 / 2.0 | 190.0 / 190.0 | 6.0 / 6.0 (pipelines 4.0, textures 6.0, scissors 1.0) | 16.0 / 16.0 (7.0 / 7.0) |
| ponder | 75.96 / 75.96 | 1.15 / 1.11 | 167.0 / 167.0 | 71.0 / 71.0 (pipelines 5.0, textures 70.0, scissors 1.0) | 74.98 / 74.99 (72.0 / 72.0) |
| terrain | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| continuity | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_flat | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

## Flywheel (package 5)

Flywheel's own backend choice per run (CI's pin mod), and in Quicksilver's runs its visuals and the frames it drew before the terrain in the kinetics scene's bench.

| run | backend per session | kinetics: visuals | frames drawing before terrain |
|---|---|---|---|
| vanilla-a | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| vanilla-b | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| vanilla-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| vanilla-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| quicksilver-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | 24 | 600 / 599 |
| quicksilver-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| quicksilver-vk | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 597 |
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 601 |
| measure-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| measure-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| measure-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 8.61 | 142.96 | 172 | 124 | 954496 | [] |
| bench-plain | flythrough | 5.22 | 380.93 | 104 | 123 | 7858036 | [] |
| bench-plain | water_glass | 15.45 | 83.18 | 308 | 124 | 16900 | [] |
| bench-plain | nether | 15.31 | 75.56 | 306 | 121 | 279448 | [] |
| bench-sodium | spawn | 13.29 | 95.94 | 265 | 147 | 2096 | [] |
| bench-sodium | flythrough | 9.36 | 244.51 | 187 | 159 | 267148 | [] |
| bench-sodium | water_glass | 25.55 | 46.97 | 1 | 135 | 10348 | [] |
| bench-sodium | nether | 29.81 | 40.79 | 0 | 129 | 263664 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 54.054 (50.0) | 726 / 726 | 1720 | 1 | 40612.852 | 16.799 (0.0) | 1221 |

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
| core-bench-sodium | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-measure-full | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-measure-full | renderer_off | 3.09 | 3.09 (0) | 3.09 |  |
| core-measure-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | flythrough | 3.21 | 3.48 (197) | 3.48 |  |
| core-measure-old | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-old | renderer_off | 3.09 | 3.09 (0) | 3.09 |  |
| core-measure-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | flythrough | 3.46 | 3.73 (194) | 3.73 |  |
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
| core-measure-vk | flat_plants | 3.2 | 3.2 (0) | 3.2 |  |
| core-measure-vk | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-measure-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
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
| core-quicksilver-2p-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-full | translucent_move | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| core-quicksilver-full | particles | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-full | animation | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-full | animated_items | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-full | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-quicksilver-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-vk | spawn | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | water_glass | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | nether | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | mobs | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | outline | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | occlusion | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | occlusion_move | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | occlusion_corner | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | translucent_move | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | particles | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | animation | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | animated_items | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | flat_plants | 3.2 | 3.2 (0) | 3.2 |  |
| core-quicksilver-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-quicksilver-vk | water_glass_oit | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | flythrough | 3.46 | 3.46 (0) | 3.46 |  |
| core-sp-quicksilver | flythrough | 1.38 | 1.39 (91) | 1.39 |  |
| pack-measure-full | minimap | 8.4 | 8.4 (0) | 8.4 |  |
| pack-measure-full | geckolib | 8.48 | 8.48 (0) | 8.48 |  |
| pack-measure-full | jei | 9.18 | 9.18 (0) | 9.18 |  |
| pack-measure-full | ponder | 9.18 | 9.18 (0) | 9.18 |  |
| pack-measure-full | terrain | 9.07 | 9.07 (0) | 9.07 |  |
| pack-measure-full | continuity | 9.07 | 9.07 (0) | 9.07 |  |
| pack-measure-full | create_ct | 9.85 | 9.85 (0) | 9.85 |  |
| pack-measure-full | kinetics | 10.56 | 10.56 (0) | 10.56 |  |
| pack-measure-full | kinetics_flat | 6.03 | 6.03 (0) | 6.03 |  |
| pack-measure-full | kinetics_instancing | 6.03 | 6.03 (0) | 6.03 |  |
| pack-measure-old | minimap | 8.35 | 8.35 (0) | 8.35 |  |
| pack-measure-old | geckolib | 8.35 | 8.35 (0) | 8.35 |  |
| pack-measure-old | jei | 8.59 | 8.59 (0) | 8.59 |  |
| pack-measure-old | ponder | 8.59 | 8.59 (0) | 8.59 |  |
| pack-measure-old | terrain | 8.48 | 8.48 (0) | 8.48 |  |
| pack-measure-old | continuity | 8.48 | 8.48 (0) | 8.48 |  |
| pack-measure-old | create_ct | 9.26 | 9.26 (0) | 9.26 |  |
| pack-measure-old | kinetics | 10.04 | 10.04 (0) | 10.04 |  |
| pack-measure-old | kinetics_flat | 6.01 | 6.01 (0) | 6.01 |  |
| pack-measure-old | kinetics_instancing | 6.03 | 6.03 (0) | 6.03 |  |
| pack-measure-vk | minimap | 8.26 | 8.26 (0) | 8.26 |  |
| pack-measure-vk | geckolib | 8.26 | 8.26 (0) | 8.26 |  |
| pack-measure-vk | jei | 8.65 | 8.65 (0) | 8.65 |  |
| pack-measure-vk | ponder | 8.65 | 8.65 (0) | 8.65 |  |
| pack-measure-vk | terrain | 8.54 | 8.54 (0) | 8.54 |  |
| pack-measure-vk | continuity | 8.54 | 8.54 (0) | 8.54 |  |
| pack-measure-vk | create_ct | 9.32 | 9.32 (0) | 9.32 |  |
| pack-measure-vk | kinetics | 10.02 | 10.02 (0) | 10.02 |  |
| pack-measure-vk | kinetics_flat | 6.01 | 6.01 (0) | 6.01 |  |
| pack-measure-vk | kinetics_instancing | 5.99 | 5.99 (0) | 5.99 |  |
| pack-quicksilver-2p-old | minimap | 8.87 | 8.87 (0) | 8.87 |  |
| pack-quicksilver-2p-old | geckolib | 8.95 | 8.95 (0) | 8.95 |  |
| pack-quicksilver-2p-old | jei | 9.18 | 9.18 (0) | 9.18 |  |
| pack-quicksilver-2p-old | ponder | 9.18 | 9.18 (0) | 9.18 |  |
| pack-quicksilver-2p-old | terrain | 9.07 | 9.07 (0) | 9.07 |  |
| pack-quicksilver-2p-old | continuity | 9.07 | 9.07 (0) | 9.07 |  |
| pack-quicksilver-2p-old | create_ct | 9.85 | 9.85 (0) | 9.85 |  |
| pack-quicksilver-2p-old | kinetics | 10.56 | 10.56 (0) | 10.56 |  |
| pack-quicksilver-2p-old | kinetics_flat | 6.03 | 6.03 (0) | 6.03 |  |
| pack-quicksilver-2p-old | kinetics_instancing | 6.03 | 6.03 (0) | 6.03 |  |
| pack-quicksilver-full | minimap | 7.63 | 7.63 (0) | 7.63 |  |
| pack-quicksilver-full | geckolib | 7.71 | 7.71 (0) | 7.71 |  |
| pack-quicksilver-full | jei | 8.34 | 8.34 (0) | 8.34 |  |
| pack-quicksilver-full | ponder | 8.34 | 8.34 (0) | 8.34 |  |
| pack-quicksilver-full | terrain | 10.31 | 10.31 (0) | 10.31 |  |
| pack-quicksilver-full | continuity | 10.31 | 10.31 (0) | 10.31 |  |
| pack-quicksilver-full | create_ct | 11.09 | 11.09 (0) | 11.09 |  |
| pack-quicksilver-full | kinetics | 11.79 | 11.79 (0) | 11.79 |  |
| pack-quicksilver-full | kinetics_flat | 6.01 | 6.01 (0) | 6.01 |  |
| pack-quicksilver-full | kinetics_instancing | 6.01 | 6.01 (0) | 6.01 |  |
| pack-quicksilver-old | minimap | 8.87 | 8.87 (0) | 8.87 |  |
| pack-quicksilver-old | geckolib | 8.87 | 8.87 (0) | 8.87 |  |
| pack-quicksilver-old | jei | 9.1 | 9.1 (0) | 9.1 |  |
| pack-quicksilver-old | ponder | 9.1 | 9.1 (0) | 9.1 |  |
| pack-quicksilver-old | terrain | 9.07 | 9.07 (0) | 9.07 |  |
| pack-quicksilver-old | continuity | 9.07 | 9.07 (0) | 9.07 |  |
| pack-quicksilver-old | create_ct | 9.93 | 9.93 (0) | 9.93 |  |
| pack-quicksilver-old | kinetics | 10.56 | 10.56 (0) | 10.56 |  |
| pack-quicksilver-old | kinetics_flat | 6.09 | 6.09 (0) | 6.09 |  |
| pack-quicksilver-old | kinetics_instancing | 6.07 | 6.07 (0) | 6.07 |  |
| pack-quicksilver-vk | minimap | 8.87 | 8.87 (0) | 8.87 |  |
| pack-quicksilver-vk | geckolib | 8.95 | 8.95 (0) | 8.95 |  |
| pack-quicksilver-vk | jei | 9.1 | 9.1 (0) | 9.1 |  |
| pack-quicksilver-vk | ponder | 9.1 | 9.1 (0) | 9.1 |  |
| pack-quicksilver-vk | terrain | 8.99 | 8.99 (0) | 8.99 |  |
| pack-quicksilver-vk | continuity | 8.99 | 8.99 (0) | 8.99 |  |
| pack-quicksilver-vk | create_ct | 9.77 | 9.77 (0) | 9.77 |  |
| pack-quicksilver-vk | kinetics | 10.55 | 10.55 (0) | 10.55 |  |
| pack-quicksilver-vk | kinetics_flat | 6.01 | 6.01 (0) | 6.01 |  |
| pack-quicksilver-vk | kinetics_instancing | 6.01 | 6.01 (0) | 6.01 |  |

Rises of 4 MB or more: core-quicksilver-full/translucent_move: between scenes +4.00

