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
| spawn | 0.3064 | 10.05 | 0.0553 | 0.2008 | 0.4449 | 0.2942 |
| flythrough | 0.0 | 14.95 | 0.001 | 0.0011 | 0.0011 | 0.0011 |
| water_glass | 0.0031 | 6.45 | 0.0035 | 0.0043 | 0.0036 | 0.0052 |
| nether | 0.0 | 0.8 | 0.0003 | 0.0167 | 0.0003 | 0.0356 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 | 0.0 | 0.0 |
| mobs.far | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| outline | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| occlusion_move | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.0009 | 0.0009 | 0.0009 | 0.0009 |
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
| translucent_move | 0.0001 | 0.3 | 0.0002 | 0.0001 | 0.0001 | 0.0001 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0002 | 0.0002 | 0.0004 | 0.0004 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0001 | 0.0001 | 0.0002 | 0.0002 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0001 | 0.0002 | 0.0004 | 0.0002 |
| translucent_move.low | 0.0003 | 0.3 | 0.0013 | 0.0013 | 0.0018 | 0.0013 |
| translucent_move.back | 0.0004 | 0.3 | 0.0002 | 0.0002 | 0.0001 | 0.0001 |
| translucent_move.bare_back | 0.0002 | 0.3 | 0.0002 | 0.0001 | 0.0 | 0.0001 |
| water_glass_oit | 0.0042 | 0.3 | 0.004 | 0.0051 | 0.0035 | 0.0053 |
| translucent_move_oit | 0.0003 | 0.3 | 0.0002 | 0.0002 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0002 | 0.3 | 0.0003 | 0.0007 | 0.0002 | 0.0008 |
| translucent_move_oit.x2414 | 0.0 | 0.3 | 0.0001 | 0.0005 | 0.0003 | 0.0004 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0001 | 0.0003 | 0.0003 | 0.0003 |
| translucent_move_oit.low | 0.0003 | 0.3 | 0.0011 | 0.001 | 0.0012 | 0.0008 |
| translucent_move_oit.back | 0.0004 | 0.3 | 0.0003 | 0.0003 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0002 | 0.3 | 0.0002 | 0.0 | 0.0001 | 0.0 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 | 0.0226 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| block_entities | 0.0195 | 0.3 | 0.0193 | 0.0201 | 0.0094 | 0.0127 |
| block_entities.chest_open | 0.0196 | 0.3 | 0.0157 | 0.0097 | 0.0065 | 0.0137 |
| block_entities.sign_edit | 0.019 | 0.3 | 0.0233 | 0.0048 | 0.0114 | 0.0095 |
| block_entities.closed | 0.0089 | 0.3 | 0.0048 | 0.0244 | 0.0123 | 0.0127 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| spawn | 92.67 | 18057 | 196 (690) | 261 (765) | 371 (922) | 194 (671) |
| flythrough | 97.3 | 6020 | 47 (294) | 47 (294) | 51 (292) | 47 (294) |
| water_glass | 95.81 | 25508 | 15 (2616) | 12 (2614) | 19 (2735) | 20 (2621) |
| nether | 99.41 | 905 | 3 (458) | 3 (458) | 3 (470) | 254 (709) |
| mobs | 99.39 | 10 | 1 (1) | 1 (1) | 1 (1) | 1 (1) |
| mobs.far | 99.83 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| outline | 98.19 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| outline.bare | 98.2 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion | 98.62 | 22 | 1 (74) | 1 (74) | 1 (74) | 1 (74) |
| occlusion_move | 99.15 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2297 | 98.94 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2305 | 98.96 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2309 | 99.13 | 32 | 8 (8) | 8 (8) | 8 (8) | 8 (8) |
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
| translucent_move | 96.93 | 13 | 2 (77) | 1 (76) | 1 (67) | 3 (78) |
| translucent_move.x2404 | 95.93 | 15 | 3 (103) | 4 (104) | 5 (89) | 5 (105) |
| translucent_move.x2414 | 95.86 | 13 | 3 (106) | 1 (104) | 3 (100) | 2 (105) |
| translucent_move.x2424 | 96.74 | 13 | 1 (78) | 1 (78) | 2 (68) | 2 (79) |
| translucent_move.low | 96.11 | 41 | 14 (19) | 16 (22) | 16 (19) | 17 (22) |
| translucent_move.back | 96.93 | 13 | 1 (76) | 4 (79) | 2 (68) | 2 (78) |
| translucent_move.bare_back | 96.9 | 13 | 2 (77) | 2 (78) | 2 (68) | 2 (77) |
| water_glass_oit | 95.8 | 57 | 15 (2617) | 18 (2619) | 16 (2730) | 17 (2617) |
| translucent_move_oit | 96.93 | 12 | 1 (76) | 4 (79) | 4 (70) | 2 (77) |
| translucent_move_oit.x2404 | 95.93 | 16 | 6 (107) | 5 (105) | 3 (87) | 4 (104) |
| translucent_move_oit.x2414 | 95.86 | 10 | 1 (104) | 3 (106) | 3 (100) | 2 (105) |
| translucent_move_oit.x2424 | 96.74 | 15 | 2 (79) | 4 (82) | 2 (68) | 2 (79) |
| translucent_move_oit.low | 96.11 | 40 | 14 (20) | 16 (21) | 16 (19) | 12 (19) |
| translucent_move_oit.back | 96.93 | 12 | 3 (78) | 2 (77) | 4 (70) | 1 (76) |
| translucent_move_oit.bare_back | 96.9 | 15 | 2 (77) | 3 (78) | 1 (67) | 1 (76) |
| flat_plants | 98.22 | 350 | 225 (7416) | 225 (7416) | 217 (7347) | 225 (7416) |
| renderer_off | 99.2 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| particles | 99.99 | 4 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| particles.bare | 99.99 | 4 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| animation | 99.62 | 10 | 1 (3) | 1 (3) | 1 (3) | 1 (3) |
| animation.behind | 99.74 | 10 | 0 (2) | 0 (2) | 0 (1) | 0 (2) |
| animation.front | 99.62 | 10 | 1 (3) | 1 (3) | 1 (3) | 1 (3) |
| animated_items | 98.9 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| block_entities | 98.22 | 270 | 81 (911) | 108 (938) | 41 (892) | 41 (871) |
| block_entities.chest_open | 98.28 | 240 | 41 (871) | 10 (840) | 52 (903) | 47 (877) |
| block_entities.sign_edit | 98.28 | 280 | 63 (897) | 35 (869) | 77 (932) | 79 (913) |
| block_entities.closed | 98.23 | 310 | 33 (867) | 125 (959) | 80 (935) | 17 (851) |

Far entity LOD (on) against its stored references, % of pixels over 8/255; last column: against vanilla's picture of the same view (LOD off), reported only:

| shot | profile | reference % | limit % | vanilla % |
|---|---|---|---|---|
| mobs.far_lod | full | 0.0069 | 0.25 | 0.0 |
| mobs.far_lod | old-GPU | 0.0069 | 0.25 | 0.0 |
| mobs.far_lod | Vulkan | 0.0084 | 0.25 | 0.0 |
| mobs.far_lod | old-GPU two-phase | 0.0069 | 0.25 | 0.0 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| spawn | 0.2095 / 289 | 0.2959 / 194 | 0.4278 / 215 | 0.2959 / 194 |
| flythrough | 0.0 / 0 | 0.0001 / 0 | 0.0003 / 3 | 0.0001 / 0 |
| water_glass | 0.0031 / 14 | 0.004 / 11 | 0.0033 / 11 | 0.004 / 11 |
| nether | 0.0 / 0 | 0.0164 / 0 | 0.0016 / 15 | 0.0164 / 0 |
| mobs | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mobs.far | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
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
| translucent_move | 0.0001 / 0 | 0.0001 / 1 | 0.0001 / 1 | 0.0001 / 1 |
| translucent_move.x2404 | 0.0 / 2 | 0.0 / 0 | 0.0 / 1 | 0.0 / 0 |
| translucent_move.x2414 | 0.0001 / 2 | 0.0001 / 0 | 0.0001 / 2 | 0.0001 / 0 |
| translucent_move.x2424 | 0.0001 / 2 | 0.0002 / 2 | 0.0002 / 1 | 0.0002 / 2 |
| translucent_move.low | 0.0003 / 1 | 0.0007 / 7 | 0.0011 / 6 | 0.0007 / 7 |
| translucent_move.back | 0.0003 / 1 | 0.0002 / 2 | 0.0001 / 1 | 0.0002 / 2 |
| translucent_move.bare_back | 0.0001 / 0 | 0.0001 / 1 | 0.0 / 0 | 0.0001 / 1 |
| water_glass_oit | 0.0041 / 15 | 0.0053 / 19 | 0.0037 / 18 | 0.0053 / 19 |
| translucent_move_oit | 0.0003 / 1 | 0.0001 / 2 | 0.0001 / 2 | 0.0001 / 2 |
| translucent_move_oit.x2404 | 0.0001 / 1 | 0.0004 / 1 | 0.0 / 0 | 0.0004 / 1 |
| translucent_move_oit.x2414 | 0.0001 / 2 | 0.0003 / 0 | 0.0 / 2 | 0.0003 / 0 |
| translucent_move_oit.x2424 | 0.0001 / 1 | 0.0004 / 4 | 0.0002 / 2 | 0.0004 / 4 |
| translucent_move_oit.low | 0.0003 / 4 | 0.0002 / 2 | 0.0002 / 1 | 0.0002 / 2 |
| translucent_move_oit.back | 0.0002 / 0 | 0.0002 / 2 | 0.0002 / 2 | 0.0002 / 2 |
| translucent_move_oit.bare_back | 0.0003 / 1 | 0.0 / 0 | 0.0001 / 0 | 0.0 / 0 |
| flat_plants | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| renderer_off | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| particles | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| particles.bare | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation.behind | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animation.front | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| animated_items | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| block_entities | 0.0167 / 55 | 0.0093 / 10 | 0.0082 / 29 | 0.0093 / 10 |
| block_entities.chest_open | 0.0137 / 22 | 0.0095 / 9 | 0.0116 / 99 | 0.0095 / 9 |
| block_entities.sign_edit | 0.0256 / 83 | 0.0028 / 17 | 0.0112 / 75 | 0.0028 / 17 |
| block_entities.closed | 0.0077 / 62 | 0.0155 / 43 | 0.0054 / 17 | 0.0155 / 43 |

### Counts, core full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 14.44 (base 13.6) | 15 (base 14) | 22884 (base 22476) | 254.15 (base 259.07) | 3.99 (against vanilla, below) |
| flythrough | 15.78 (reported, not gated) | 42 (reported, not gated) | 591420 (reported, not gated) | 309.15 (base 324.25) | 3.73 (against vanilla, below) |
| water_glass | 9.9 (base 8.97) | 15 (base 15) | 11956 (base 15576) | 238.59 (base 250.02) | 3.99 (against vanilla, below) |
| nether | 14.1 (base 15.63) | 12 (base 12) | 11164 (base 19648) | 260.02 (base 273.53) | 3.99 (against vanilla, below) |
| mobs | 12.74 (base 19.77) | 16 (base 17) | 613436 (base 1010948) | 260.05 (base 268.37) | 3.99 (against vanilla, below) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 258.67 (base 264.69) | 3.99 (against vanilla, below) |
| occlusion | 11.67 (base 15.67) | 15 (base 15) | 100032 (base 126320) | 264.21 (base 265.1) | 3.99 (against vanilla, below) |
| occlusion_move | 12.36 (reported, not gated) | 15 (reported, not gated) | 81924 (reported, not gated) | 264.96 (base 265.74) | 3.99 (against vanilla, below) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 269.2 (base 267.71) | 5.99 (against vanilla, below) |
| translucent_move | 8.92 (reported, not gated) | 15 (reported, not gated) | 5424 (reported, not gated) | 275.64 (base 267.48) | 5.99 (against vanilla, below) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 11732 (base 14688) | 237.95 (base 245.02) | 3.6 (against vanilla, below) |
| translucent_move_oit | 14.19 (reported, not gated) | 15 (reported, not gated) | 5376 (reported, not gated) | 240.83 (base 247.19) | 3.73 (against vanilla, below) |
| flat_plants | 9.55 (base 18.29) | 15 (base 15) | 4404 (base 9812) | 238.02 (base 246.92) | 3.46 (against vanilla, below) |
| renderer_off | 8.68 (base 7.67) | 14 (base 14) | 3612 (base 7164) | 233.76 (base 241.33) | 3.6 (against vanilla, below) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 266.63 (base 261.44) | 5.99 (against vanilla, below) |
| animation | 50 median (avg 40.95) (base 49) | 15 (base 15) | 2164 (base 2056) | 262.89 (base 260.68) | 5.99 (against vanilla, below) |
| animated_items | 61 median (avg 47.69) (base 60) | 24 (base 23) | 22016 (base 21940) | 237.48 (base 239.81) | 5.99 (against vanilla, below) |
| block_entities | 35.12 (base 35.11) | 17 (base 17) | 95380 (base 95156) | 236.9 (base 236.44) | 5.99 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.44 / 14 (9.67) | 123.05 / 123 (9.29) | median and average, x 1.10 + 2 |
| flythrough | 15.78 / 16 (6.64) | 123.05 / 123 (5.96) | median and average, at most vanilla + 2 |
| water_glass | 9.9 / 10 (20.77) | 124.0 / 124 (16.29) | median, at most vanilla |
| nether | 14.1 / 17 (24.32) | 120.78 / 121 (16.03) | median, x 1.10 + 2 |
| mobs | 12.74 / 13 (26.98) | 134.0 / 134 (19.78) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 11.67 / 12 (29.9) | 94.33 / 133 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 12.36 / 13 (29.85) | 94.27 / 133 (29.99) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (29.97) | 82.33 / 121 (29.96) | median and average, x 1.10 + 2 |
| translucent_move | 8.92 / 9 (25.08) | 124.0 / 124 (17.02) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (10.27) | 129.0 / 129 (8.87) | median, at most vanilla |
| translucent_move_oit | 14.19 / 14 (10.35) | 129.0 / 129 (8.59) | median and average, at most vanilla |
| flat_plants | 9.55 / 10 (25.64) | 123.99 / 124 (16.45) | median, x 1.10 + 2 |
| renderer_off | 8.68 / 9 (29.24) | 92.24 / 123 (27.22) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (29.99) | 86.27 / 125 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.95 / 50 (29.99) | 144.42 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.69 / 61 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |
| block_entities | 35.12 / 42 (29.97) | 97.38 / 136 (30.0) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-full), core full (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| spawn | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 12.39 |
| flythrough | 3.73 / 3.73 | 3.73 / 3.73 | 7.73 / 7.73 | 12.66 |
| water_glass | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.59 |
| nether | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.59 |
| mobs | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 15.69 |
| outline | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.03 |
| occlusion | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 12.66 |
| occlusion_move | 3.99 / 3.99 | 3.73 / 3.73 | 7.73 / 7.73 | 12.66 |
| occlusion_corner | 5.99 / 5.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.03 |
| translucent_move | 5.99 / 5.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.03 |
| water_glass_oit | 3.6 / 3.6 | 3.35 / 3.35 | 7.35 / 7.35 | 12.1 |
| translucent_move_oit | 3.73 / 3.73 | 3.48 / 3.48 | 7.48 / 7.48 | 12.1 |
| flat_plants | 3.46 / 3.46 | 3.34 / 3.34 | 7.34 / 7.34 | 12.39 |
| renderer_off | 3.6 / 3.6 | 3.6 / 3.6 | 7.6 / 7.6 | 12.53 |
| particles | 5.99 / 5.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.59 |
| animation | 5.99 / 5.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.59 |
| animated_items | 5.99 / 5.99 | 3.73 / 3.73 | 7.73 / 7.73 | 14.59 |
| block_entities | 5.99 / 5.99 | 3.73 / 3.73 | 7.73 / 7.73 | 12.66 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.83 | 36.0 / 22.83 | 0.0 / 0.0 | 416.0 / 38.695 |
| flythrough | 112.0 / 83.364 | 112.0 / 83.364 | 0.0 / 0.0 | 416.0 / 141.771 |
| water_glass | 36.0 / 12.459 | 36.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| nether | 20.0 / 15.328 | 20.0 / 15.328 | 0.0 / 0.0 | 256.0 / 26.87 |
| mobs | 20.0 / 10.094 | 20.0 / 10.094 | 0.0 / 0.0 | 416.0 / 17.546 |
| outline | 20.0 / 1.539 | 20.0 / 1.539 | 0.0 / 0.0 | 256.0 / 2.711 |
| occlusion | 20.0 / 2.594 | 20.0 / 2.594 | 0.0 / 0.0 | 416.0 / 4.45 |
| occlusion_move | 20.0 / 3.348 | 20.0 / 3.348 | 0.0 / 0.0 | 416.0 / 5.864 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.006 | 28.0 / 13.006 | 0.0 / 0.0 | 416.0 / 22.408 |
| water_glass_oit | 20.0 / 12.459 | 20.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| translucent_move_oit | 28.0 / 12.651 | 28.0 / 12.651 | 0.0 / 0.0 | 416.0 / 21.695 |
| flat_plants | 24.0 / 14.233 | 24.0 / 14.233 | 0.0 / 0.0 | 416.0 / 24.634 |
| renderer_off | 24.0 / 8.924 | 24.0 / 8.924 | 0.0 / 0.0 | 416.0 / 15.69 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |
| block_entities | 28.0 / 0.142 | 28.0 / 0.142 | 0.0 / 0.0 | 256.0 / 0.247 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 439178.708 (592308.125) | 25.853 | 1.19 | 589908 / 1299324 | 567008 (2097152.0) | 192 / 185 | 0.0 / 0 |
| flythrough | 475817.182 (747037.788) | 36.306 | 1.083 | 2123256 / 7061976 | 2088792 (2097152.0) | 132 / 119 | 6.789 / 67 |
| water_glass | 113718.707 (198630.332) | 42.749 | 1.132 | 14196 / 16736 | 0 (2097152.0) | 129 / 325 | 0.0 / 0 |
| nether | 29504.709 (42405.254) | 30.422 | 2.0 | 226368 / 409016 | 216448 (2097152.0) | 121 / 320 | 0.0 / 0 |
| mobs | 62149.091 (110939.443) | 43.979 | 0.967 | 613436 / 616336 | 0 (2097152.0) | 32 / 185 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5580 / 6300 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion | 29475.29 (51948.871) | 43.261 | 1.279 | 233728 / 781228 | 133696 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 22276.574 (39203.359) | 43.177 | 1.259 | 652076 / 1108512 | 575936 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21841.038 (47203.479) | 53.73 | 1.214 | 35488 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21628.863 (27669.586) | 21.832 | 1.004 | 761244 / 1332900 | 755968 (2097152.0) | 126 / 340 | 0.0 / 0 |
| water_glass_oit | 113999.395 (199120.605) | 42.749 | 1.132 | 13188 / 16512 | 0 (2097152.0) | 205 / 177 | 0.0 / 0 |
| translucent_move_oit | 21729.072 (27806.493) | 21.856 | 1.004 | 737040 / 1291440 | 731840 (2097152.0) | 207 / 171 | 0.0 / 0 |
| flat_plants | 9101.742 (12478.324) | 27.06 | 1.045 | 350432 / 271580 | 346048 (2097152.0) | 128 / 328 | 0.0 / 0 |
| renderer_off | 20763.493 (39371.301) | 47.262 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 50 / 2 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86680 / 150176 | 84608 (2097152.0) | 1 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79744 / 122840 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |
| block_entities | 3461.76 (4439.387) | 22.022 | 1.6 | 137728 / 166400 | 41472 (2097152.0) | 1 / 0 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.97 (107) | 3.969 (133) | 1.0 | 4.396 (54) | 0 | 858 / 0 | 9.551 / 12.924 | 4.663 / 6.423 |
| flythrough | 5.348 (1592) | 5.759 (1549) | 0.929 | 5.348 (1592) | 0 | 1390 / 0 | 7.429 / 10.074 | 4.771 / 6.633 |
| water_glass | 2.263 (14) | 1.37 (14) | 1.652 | None (0) | 0 | 1171 / 0 | 8.696 / 11.494 | 4.347 / 5.899 |
| nether | 2.872 (33) | 2.616 (36) | 1.098 | 2.97 (18) | 0 | 1800 / 0 | 7.094 / 9.434 | 3.407 / 5.035 |
| mobs | 3.344 (67) | 3.118 (67) | 1.072 | None (0) | 0 | 2034 / 0 | 6.929 / 9.219 | 3.367 / 4.918 |
| outline | 0.502 (13) | 0.538 (13) | 0.933 | None (0) | 0 | 2093 / 0 | 6.841 / 9.092 | 3.319 / 4.817 |
| occlusion | 1.258 (44) | 0.881 (42) | 1.428 | 2.7 (4) | 0 | 2226 / 0 | 6.746 / 8.957 | 3.287 / 4.633 |
| occlusion_move | 1.779 (67) | 1.779 (63) | 1.0 | 4.063 (18) | 0 | 2372 / 0 | 6.464 / 8.596 | 3.138 / 4.381 |
| occlusion_corner | 1.459 (97) | 1.322 (82) | 1.104 | 1.309 (1) | 0 | 2646 / 0 | 6.05 / 7.979 | 2.85 / 3.934 |
| translucent_move | 3.756 (120) | 3.563 (117) | 1.054 | 7.532 (35) | 0 | 3025 / 0 | 6.097 / 8.137 | 2.991 / 4.073 |
| water_glass_oit | 3.765 (154) | 3.469 (150) | 1.085 | None (0) | 0 | 413 / 0 | 9.314 / 11.261 | 4.981 / 6.166 |
| translucent_move_oit | 3.734 (215) | 5.514 (209) | 0.677 | 5.392 (26) | 0 | 959 / 0 | 6.217 / 7.833 | 3.257 / 4.153 |
| flat_plants | 1.652 (96) | 1.191 (81) | 1.387 | 1.503 (4) | 0 | 396 / 0 | 8.245 / 10.206 | 3.497 / 3.884 |
| renderer_off | 0.795 (21) | 0.405 (25) | 1.963 | None (0) | 0 | 328 / 0 | 9.655 / 12.892 | 4.159 / 5.771 |
| particles | 0.385 (30) | 0.239 (30) | 1.611 | None (0) | 0 | 3052 / 0 | 6.049 / 8.07 | 2.947 / 4.031 |
| animation | 0.991 (18) | 0.874 (18) | 1.134 | 1.116 (4) | 0 | 3127 / 0 | 5.932 / 7.905 | 2.826 / 3.909 |
| animated_items | 0.445 (32) | 0.225 (38) | 1.978 | 1.224 (2) | 0 | 3159 / 0 | 5.878 / 7.832 | 2.78 / 3.874 |
| block_entities | 0.914 (60) | 0.711 (58) | 1.286 | 1.794 (1) | 0 | 3241 / 0 | 5.757 / 7.665 | 2.66 / 3.739 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.016 | 665.448 | 16 (vanilla 28) | 1377872 | 40.712 / 0.082 | 22.83 / 36.0 | 36.793 | 2324 / 0 | 4.396 (10.616) |
| flythrough | indirect, one multi-draw per arena and layer | 4.727 | 756.765 | 16 (vanilla 28) | 5050472 | 15.584 / 0.997 | 83.364 / 112.0 | 134.862 | 6401 / 0 | 5.348 (15.447) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 106.255 | 16 (vanilla 28) | 772256 | 32.84 / 0.08 | 12.459 / 36.0 | 20.621 | 2969 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.089 | 16 (vanilla 28) | 962592 | 27.516 / 0.17 | 15.328 / 20.0 | 25.704 | 4028 / 0 | 2.97 (6.262) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.111 | 16 (vanilla 28) | 624308 | 24.426 / 0.144 | 10.094 / 20.0 | 16.671 | 4589 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 96900 | 23.952 / 0.144 | 1.539 / 20.0 | 2.588 | 4684 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 162220 | 22.884 / 0.137 | 2.594 / 20.0 | 4.332 | 4927 / 0 | 2.7 (4.595) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.874 | 33.883 | 16 (vanilla 28) | 210392 | 21.708 / 0.129 | 3.348 / 20.0 | 5.618 | 5213 / 0 | 4.063 (10.84) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.053 | 60.88 | 16 (vanilla 28) | 122728 | 20.551 / 0.123 | 1.931 / 20.0 | 3.277 | 5584 / 0 | 1.309 (1.308) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.169 | 23.117 | 16 (vanilla 28) | 803836 | 17.668 / 0.11 | 13.006 / 28.0 | 21.465 | 6468 / 0 | 7.532 (20.392) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.024 | 114.556 | 16 (vanilla 28) | 772256 | 7.51 / 0.043 | 12.459 / 20.0 | 20.621 | 1089 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.213 | 37.242 | 16 (vanilla 28) | 781308 | 6.48 / 0.087 | 12.651 / 28.0 | 20.863 | 2415 / 0 | 5.392 (11.54) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 22.043 | 16 (vanilla 28) | 888052 | 5.843 / 0.01 | 14.233 / 24.0 | 23.714 | 940 / 0 | 1.503 (2.326) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.038 | 16 (vanilla 28) | 560360 | 2.338 / 0.02 | 8.924 / 24.0 | 14.963 | 610 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 17.629 / 0.11 | 0.131 / 28.0 | 0.225 | 6510 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 17.492 / 0.109 | 0.302 / 28.0 | 0.518 | 6612 / 0 | 1.116 (1.651) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.444 / 0.11 | 0.153 / 28.0 | 0.261 | 6661 / 0 | 1.224 (1.889) |
| block_entities | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 8864 | 17.221 / 0.108 | 0.142 / 28.0 | 0.237 | 6797 / 0 | 1.794 (1.794) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 1.0 | 0.0 | 0 | 0 | 42 (0.028 / 0.038 / 0.079; 0) | 0 | 30108 / 0 / 0 |
| flythrough | 188.083 | 1.0 | 0.0 | 0 | 0 | 843 (0.023 / 0.049 / 4.849; 0) | 43 | 25015 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1668 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1196 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.052 / 0.112 / 1.211; 0) | 32 | 1194 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.12 / 0.16 / 3.439; 0) | 180 | 3528 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 618 | 0 (None / None / None; 0) | 0 | 824 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 624 | 0 (None / None / None; 0) | 0 | 1456 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2052 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2340 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 352.383 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.078; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.0 | 1.0 (0.0, 0.0) | 1.195 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.141 (0.271; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.075 (0.144; 0) | 0 | 3588 / 1624168 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.353) | 6.0 (6.0, 2.28) | 0.066 (0.256; 0) | 0 | 2766 / 1496206 / 0 / 0 |
| occlusion_corner | 81.86 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.266 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.673 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.057 (0.099; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 270.0 / 350.37 (22.9) | 270.0 / 80.37 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3858 / 0 |
| flythrough | two-phase | 311.49 / 399.96 (22.1) | 304.3 / 95.66 / 7.19 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3010 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 9048 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 32086 / 0 |
| mobs | two-phase | 32.0 / 110.0 (70.9) | 32.0 / 78.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10530 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3427 / 0 |
| occlusion_move | two-phase | 22.4 / 51.31 (56.4) | 22.34 / 28.97 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4305 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.85 (25.8) | 60.68 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3142 / 0 |
| translucent_move | two-phase | 15.67 / 136.12 (88.5) | 15.65 / 120.47 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15059 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4437 / 0 |
| translucent_move_oit | two-phase | 15.64 / 136.02 (88.5) | 15.6 / 120.43 / 0.05 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6140 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18304 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 14746 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.0 / 0.443 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 119.267 / 0.44 | 0.025 / 0.012 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.183 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.835 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.414 / 53.448 | 0.019 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.526 | 0.784 / 0.819 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 44.98 / 10.34 | 0.077 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 115.0 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.938 / 11.907 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.564 / 51.534 | 0.016 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.91 / 11.904 | 0.006 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 0.0 | 0.994 / 0.805 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.758 / 1.673 | 0.01 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | 84.503 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.048 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.757 / 32.287 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.01 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.028 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.51 / 7.97 / 32.54 | 0 / 0 | 9.0 |
| block_entities | 76.603 / 13.333 | 0.995 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 15.985 / 16.023 | 0.005 / 0.011 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| block_entities | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 49.48 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 254.3 (base 256.29) | 3.73 (against vanilla, below) |
| flythrough | 67.27 (reported, not gated) | 41 (reported, not gated) | 372532 (reported, not gated) | 309.76 (base 324.79) | 3.73 (against vanilla, below) |
| water_glass | 19.86 (base 20.0) | 13 (base 14) | 8100 (base 10264) | 238.79 (base 249.83) | 3.73 (against vanilla, below) |
| nether | 23.65 (base 33.79) | 10 (base 11) | 4176 (base 10656) | 260.29 (base 272.57) | 3.73 (against vanilla, below) |
| mobs | 17.71 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 259.81 (base 268.23) | 3.73 (against vanilla, below) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.75 (base 264.41) | 3.73 (against vanilla, below) |
| occlusion | 13.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 264.39 (base 264.64) | 3.73 (against vanilla, below) |
| occlusion_move | 19.47 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.74 (base 265.66) | 3.73 (against vanilla, below) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.94 (base 267.41) | 3.73 (against vanilla, below) |
| translucent_move | 17.99 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 275.62 (base 268.19) | 3.73 (against vanilla, below) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 6980 (base 7604) | 236.67 (base 245.78) | 3.6 (against vanilla, below) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 3172 (reported, not gated) | 239.57 (base 248.15) | 3.73 (against vanilla, below) |
| flat_plants | 9.41 (base 33.0) | 12 (base 13) | 1492 (base 1716) | 238.83 (base 248.11) | 3.46 (against vanilla, below) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.37 (base 240.73) | 3.34 (against vanilla, below) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.23 (base 261.4) | 3.73 (against vanilla, below) |
| animation | 50 median (avg 40.02) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.76 (base 260.68) | 3.73 (against vanilla, below) |
| animated_items | 60 median (avg 47.01) (base 60) | 22 (base 22) | 21668 (base 21668) | 237.44 (base 239.53) | 3.73 (against vanilla, below) |
| block_entities | 35.1 (base 36.11) | 15 (base 15) | 94672 (base 95140) | 236.64 (base 236.55) | 3.73 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 49.48 / 49 (11.1) | 899.44 / 899 (12.79) | median and average, x 1.10 + 2 |
| flythrough | 67.27 / 64 (8.32) | 1027.18 / 1024 (8.27) | median and average, at most vanilla |
| water_glass | 19.86 / 20 (23.18) | 385.59 / 392 (20.84) | median, at most vanilla |
| nether | 23.65 / 25 (25.48) | 584.24 / 588 (20.32) | median, x 1.10 + 2 |
| mobs | 17.71 / 18 (28.24) | 306.61 / 335 (26.38) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 127.33 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 13.67 / 14 (29.99) | 162.27 / 201 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 19.47 / 19 (29.95) | 167.6 / 202 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (30.01) | 163.21 / 201 (29.99) | median and average, x 1.10 + 2 |
| translucent_move | 17.99 / 18 (19.16) | 359.33 / 367 (21.59) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (11.05) | 403.0 / 403 (10.72) | median, at most vanilla |
| translucent_move_oit | 25.53 / 26 (9.49) | 386.33 / 387 (10.37) | median and average, at most vanilla |
| flat_plants | 9.41 / 9 (27.49) | 392.04 / 401 (21.61) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.93) | 287.11 / 325 (29.67) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.02 / 50 (30.0) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.01 / 60 (30.0) | 167.28 / 202 (30.01) | median, x 1.10 + 2 |
| block_entities | 35.1 / 42 (30.01) | 105.29 / 144 (30.0) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-old), core old-gpu (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| spawn | 3.73 / 3.73 | 3.99 / 3.99 | 7.99 / 7.99 | 12.1 |
| flythrough | 3.73 / 3.73 | 3.48 / 3.48 | 7.48 / 7.48 | 14.59 |
| water_glass | 3.73 / 3.73 | 3.99 / 3.99 | 7.99 / 7.99 | 14.59 |
| nether | 3.73 / 3.73 | 3.99 / 3.99 | 7.99 / 7.99 | 14.59 |
| mobs | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 14.59 |
| outline | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 12.1 |
| occlusion | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 12.66 |
| occlusion_move | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 14.59 |
| occlusion_corner | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 12.1 |
| translucent_move | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 12.1 |
| water_glass_oit | 3.6 / 3.6 | 3.6 / 3.6 | 7.6 / 7.6 | 12.1 |
| translucent_move_oit | 3.73 / 3.73 | 3.73 / 3.73 | 7.73 / 7.73 | 12.1 |
| flat_plants | 3.46 / 3.46 | 3.21 / 3.21 | 7.21 / 7.21 | 14.59 |
| renderer_off | 3.34 / 3.34 | 3.6 / 3.6 | 7.6 / 7.6 | 14.46 |
| particles | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 12.66 |
| animation | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 12.66 |
| animated_items | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 14.59 |
| block_entities | 3.73 / 3.73 | 5.99 / 5.99 | 9.99 / 9.99 | 17.06 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.571 | 36.0 / 22.571 | 0.0 / 0.0 | 416.0 / 38.396 |
| flythrough | 112.0 / 84.498 | 112.0 / 84.498 | 0.0 / 0.0 | 416.0 / 147.446 |
| water_glass | 36.0 / 12.459 | 36.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| nether | 20.0 / 15.328 | 20.0 / 15.328 | 0.0 / 0.0 | 256.0 / 26.868 |
| mobs | 20.0 / 10.095 | 20.0 / 10.095 | 0.0 / 0.0 | 416.0 / 17.542 |
| outline | 20.0 / 1.539 | 20.0 / 1.539 | 0.0 / 0.0 | 256.0 / 2.711 |
| occlusion | 20.0 / 2.581 | 20.0 / 2.581 | 0.0 / 0.0 | 416.0 / 4.475 |
| occlusion_move | 20.0 / 3.388 | 20.0 / 3.388 | 0.0 / 0.0 | 416.0 / 5.823 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.053 | 28.0 / 13.053 | 0.0 / 0.0 | 416.0 / 22.385 |
| water_glass_oit | 20.0 / 12.459 | 20.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| translucent_move_oit | 28.0 / 12.697 | 28.0 / 12.697 | 0.0 / 0.0 | 416.0 / 21.765 |
| flat_plants | 24.0 / 14.305 | 24.0 / 14.305 | 0.0 / 0.0 | 416.0 / 24.774 |
| renderer_off | 24.0 / 8.924 | 24.0 / 8.924 | 0.0 / 0.0 | 416.0 / 15.69 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |
| block_entities | 28.0 / 0.142 | 28.0 / 0.142 | 0.0 / 0.0 | 256.0 / 0.247 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 413149.919 (626088.253) | 34.011 | 1.773 | 554916 / 561580 | 553536 (2097152.0) | 221 / 255 | 0.0 / 0 |
| flythrough | 553843.386 (885111.325) | 37.427 | 1.082 | 2104820 / 7226120 | 2096776 (2097152.0) | 166 / 165 | 7.952 / 95 |
| water_glass | 113691.024 (198581.978) | 42.749 | 1.132 | 9556 / 11092 | 0 (2097152.0) | 56 / 46 | 0.0 / 0 |
| nether | 46619.395 (73444.11) | 36.524 | 1.866 | 154480 / 337268 | 149184 (2097152.0) | 152 / 68 | 0.0 / 0 |
| mobs | 62143.989 (110930.337) | 43.979 | 0.967 | 610676 / 612276 | 0 (2097152.0) | 37 / 10 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 29226.711 (51449.75) | 43.194 | 1.279 | 98148 / 394844 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 50514.481 (88802.708) | 43.116 | 1.223 | 648252 / 1111260 | 573184 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27758.835 (60456.805) | 54.085 | 1.272 | 32932 / 57892 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 201850.245 (358406.517) | 43.681 | 1.182 | 759156 / 1327988 | 756096 (2097152.0) | 296 / 41 | 0.0 / 0 |
| water_glass_oit | 113961.664 (199054.7) | 42.749 | 1.132 | 9668 / 12100 | 0 (2097152.0) | 220 / 214 | 0.0 / 0 |
| translucent_move_oit | 201718.653 (357977.189) | 43.65 | 1.18 | 736980 / 1286228 | 731840 (2097152.0) | 190 / 207 | 0.0 / 0 |
| flat_plants | 10376.24 (14841.425) | 30.086 | 1.046 | 269192 / 4564 | 267904 (2097152.0) | 138 / 43 | 0.0 / 0 |
| renderer_off | 20762.662 (39369.726) | 47.262 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 8 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3044.114 (5227.753) | 41.77 | 1.087 | 86324 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2244.441 (4827.279) | 53.505 | 1.0 | 79396 / 124632 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |
| block_entities | 3461.75 (4439.374) | 22.022 | 1.6 | 135696 / 167300 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 3.991 (120) | 2.468 (133) | 1.617 | 3.55 (52) | 0 | 905 / 0 | 7.112 / 9.105 | 3.36 / 4.692 |
| flythrough | 4.433 (1731) | 4.959 (1634) | 0.894 | 4.433 (1731) | 0 | 1390 / 0 | 5.941 / 8.222 | 3.606 / 5.41 |
| water_glass | 2.074 (18) | 1.427 (18) | 1.453 | None (0) | 0 | 1227 / 0 | 6.319 / 8.024 | 3.004 / 4.173 |
| nether | 2.014 (34) | 2.126 (26) | 0.947 | 2.027 (15) | 0 | 1858 / 0 | 5.173 / 6.559 | 2.261 / 3.145 |
| mobs | 2.253 (74) | 3.153 (67) | 0.715 | None (0) | 0 | 2092 / 0 | 4.977 / 6.371 | 2.231 / 3.048 |
| outline | 0.324 (13) | 0.291 (13) | 1.113 | None (0) | 0 | 2151 / 0 | 4.903 / 6.281 | 2.209 / 2.993 |
| occlusion | 0.984 (55) | 2.116 (50) | 0.465 | None (0) | 0 | 2293 / 0 | 4.736 / 6.094 | 2.145 / 2.884 |
| occlusion_move | 1.534 (67) | 1.428 (63) | 1.074 | 3.364 (18) | 0 | 2448 / 0 | 4.532 / 5.828 | 2.018 / 2.742 |
| occlusion_corner | 1.005 (110) | 0.925 (110) | 1.086 | 3.381 (1) | 0 | 2728 / 0 | 4.205 / 5.394 | 1.809 / 2.464 |
| translucent_move | 2.886 (117) | 2.863 (131) | 1.008 | 4.661 (32) | 0 | 3108 / 0 | 4.068 / 5.263 | 1.844 / 2.559 |
| water_glass_oit | 2.832 (154) | 3.095 (152) | 0.915 | None (0) | 0 | 413 / 0 | 5.732 / 7.015 | 3.073 / 4.433 |
| translucent_move_oit | 3.41 (220) | 4.243 (216) | 0.804 | 3.482 (26) | 0 | 972 / 0 | 4.12 / 5.359 | 2.031 / 3.087 |
| flat_plants | 1.834 (97) | 1.553 (98) | 1.181 | 2.209 (2) | 0 | 405 / 0 | 6.531 / 8.012 | 2.178 / 3.154 |
| renderer_off | 0.65 (24) | 0.337 (21) | 1.929 | None (0) | 0 | 323 / 0 | 6.47 / 10.27 | 2.351 / 3.643 |
| particles | 0.35 (30) | 0.202 (24) | 1.733 | None (0) | 0 | 3138 / 0 | 4.037 / 5.221 | 1.823 / 2.525 |
| animation | 0.913 (18) | 1.271 (18) | 0.718 | 1.731 (4) | 0 | 3213 / 0 | 3.962 / 5.117 | 1.755 / 2.42 |
| animated_items | 0.372 (42) | 0.269 (32) | 1.383 | 0.723 (2) | 0 | 3245 / 0 | 3.928 / 5.071 | 1.727 / 2.37 |
| block_entities | 0.7 (57) | 0.613 (59) | 1.142 | 1.188 (1) | 0 | 3327 / 0 | 3.85 / 4.969 | 1.652 / 2.26 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.176 | 712.932 | 16 (vanilla 28) | 1361736 | 43.254 / 0.09 | 22.571 / 36.0 | 36.362 | 2501 / 0 | 3.55 (7.176) |
| flythrough | plain, one multi-draw per region and layer | 57.494 | 912.331 | 16 (vanilla 28) | 5122612 | 15.242 / 0.969 | 84.498 / 112.0 | 136.788 | 6702 / 0 | 4.433 (12.876) |
| water_glass | plain, one multi-draw per region and layer | 14.03 | 106.229 | 16 (vanilla 28) | 772256 | 35.262 / 0.08 | 12.459 / 36.0 | 20.621 | 3181 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.589 | 73.214 | 16 (vanilla 28) | 962528 | 29.603 / 0.168 | 15.328 / 20.0 | 25.702 | 4248 / 0 | 2.027 (4.245) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.106 | 16 (vanilla 28) | 624308 | 26.321 / 0.144 | 10.095 / 20.0 | 16.671 | 4824 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 96900 | 25.836 / 0.143 | 1.539 / 20.0 | 2.588 | 4919 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 161228 | 24.543 / 0.135 | 2.581 / 20.0 | 4.305 | 5197 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 10.992 | 76.374 | 16 (vanilla 28) | 212072 | 23.206 / 0.128 | 3.388 / 20.0 | 5.663 | 5507 / 0 | 3.364 (8.912) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.913 | 16 (vanilla 28) | 122728 | 21.979 / 0.121 | 1.931 / 20.0 | 3.277 | 5896 / 0 | 3.381 (3.38) |
| translucent_move | plain, one multi-draw per region and layer | 12.01 | 248.945 | 16 (vanilla 28) | 805260 | 18.988 / 0.11 | 13.053 / 28.0 | 21.503 | 6785 / 0 | 4.661 (14.33) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.073 | 114.518 | 16 (vanilla 28) | 772256 | 7.511 / 0.043 | 12.459 / 20.0 | 20.621 | 1089 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.568 | 263.489 | 16 (vanilla 28) | 782712 | 6.752 / 0.111 | 12.697 / 28.0 | 20.901 | 2433 / 0 | 3.482 (10.18) |
| flat_plants | plain, one multi-draw per region and layer | 4.078 | 23.469 | 16 (vanilla 28) | 891992 | 6.301 / 0.009 | 14.305 / 24.0 | 23.819 | 963 / 0 | 2.209 (2.634) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 560352 | 2.359 / 0.02 | 8.924 / 24.0 | 14.963 | 603 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.92 / 0.11 | 0.131 / 28.0 | 0.225 | 6833 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 18.781 / 0.109 | 0.302 / 28.0 | 0.518 | 6935 / 0 | 1.731 (4.212) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.671 | 16 (vanilla 28) | 9764 | 18.732 / 0.109 | 0.153 / 28.0 | 0.261 | 6985 / 0 | 0.723 (1.155) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 18.505 / 0.108 | 0.142 / 28.0 | 0.237 | 7118 / 0 | 1.188 (1.188) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 17.0 | 0.0 | 0 | 0 | 45 (0.032 / 0.044 / 0.059; 0) | 0 | 34410 / 0 / 0 |
| flythrough | 192.425 | 26.413 | 0.0 | 0 | 0 | 898 (0.024 / 0.046 / 3.061; 0) | 46 | 32135 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1856 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.009 / 0.017 / 0.022; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.122 / 0.167 / 2.161; 0) | 180 | 2688 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 663 | 0 (None / None / None; 0) | 0 | 884 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 573 | 0 (None / None / None; 0) | 0 | 1337 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2204 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 346.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.036 (0.099; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.269 | 1.0 (0.0, 0.0) | 1.15 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.019 (0.061; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.117 (0.286; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.068 (0.125; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.368) | 6.0 (6.0, 2.277) | 0.061 (0.287; 0) | 0 | 2787 / 1509600 / 0 / 0 |
| occlusion_corner | 81.864 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.104 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.691 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.045; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.011 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.043 (0.075; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 297.78 / 344.0 (13.4) | 297.78 / 0.0 / 0.0 | 0.1 | 0.0 (0.0, 0.0; 0.0) | 1427.03 | 2660 / 0 |
| flythrough | still | 404.81 / 405.19 (0.1) | 404.81 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10005 / 0 |
| nether | still | 55.05 / 300.0 (81.7) | 55.05 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 282.35 | 31297 / 0 |
| mobs | still | 32.0 / 110.0 (70.9) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10998 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3278 / 0 |
| occlusion | still | 26.0 / 49.0 (46.9) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion_move | still | 51.19 / 51.31 (0.2) | 51.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.73 / 81.86 (0.2) | 81.73 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 135.35 / 135.92 (0.4) | 135.35 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 109 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4785 / 0 |
| translucent_move_oit | still | 134.84 / 135.98 (0.8) | 134.84 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.78 / 152.0 (93.6) | 9.78 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 26.13 | 19448 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 447 / 0 |
| animated_items | still | 12.64 / 13.0 (2.8) | 12.64 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 54 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 23.92 | 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.435 / 0.376 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 84.06 / 0.378 | 0.026 / 0.013 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.09 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.85 |
| water_glass | 108.642 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 59.558 / 59.509 | 0.017 / 0.033 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 111.318 / 7.682 | 0.958 / 0.615 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 43.38 / 6.239 | 0.073 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 86.85 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 105.417 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.037 / 12.016 | 0.006 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 50.978 / 50.914 | 0.017 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.933 / 14.817 | 0.005 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 106.215 / 0.0 | 0.898 / 0.605 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.075 / 1.009 | 0.012 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | 77.441 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.008 / 0.062 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.27 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.006 / 0.012 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | 136.553 / 28.028 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.51 / 7.97 / 32.54 | 0 / 0 | 9.0 |
| block_entities | 76.667 / 13.311 | 0.832 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.828 / 12.829 | 0.004 / 0.011 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| block_entities | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |

### Counts, core vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 13.1 (base 14.05) | 14 (base 15) | 22444 (base 27764) | 253.59 (base 257.2) | 5.98 (against vanilla, below) |
| flythrough | 13.05 (reported, not gated) | 23 (reported, not gated) | 177844 (reported, not gated) | 310.52 (base 318.06) | 3.71 (against vanilla, below) |
| water_glass | 8.69 (base 9.0) | 15 (base 15) | 11956 (base 15108) | 238.68 (base 244.39) | 5.98 (against vanilla, below) |
| nether | 12.4 (base 15.71) | 12 (base 12) | 10804 (base 19912) | 260.13 (base 268.95) | 5.98 (against vanilla, below) |
| mobs | 11.67 (base 19.97) | 17 (base 17) | 613596 (base 1008176) | 259.54 (base 264.31) | 5.98 (against vanilla, below) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 258.51 (base 264.58) | 5.98 (against vanilla, below) |
| occlusion | 10.67 (base 15.67) | 15 (base 15) | 100052 (base 126356) | 263.99 (base 264.78) | 5.98 (against vanilla, below) |
| occlusion_move | 11.49 (reported, not gated) | 15 (reported, not gated) | 82544 (reported, not gated) | 264.53 (base 265.16) | 5.98 (against vanilla, below) |
| occlusion_corner | 5.67 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 268.78 (base 266.66) | 5.98 (against vanilla, below) |
| translucent_move | 8.68 (reported, not gated) | 15 (reported, not gated) | 11056 (reported, not gated) | 275.43 (base 268.35) | 5.98 (against vanilla, below) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 11844 (base 15024) | 238.82 (base 245.99) | 5.34 (against vanilla, below) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 11132 (reported, not gated) | 241.22 (base 248.38) | 5.46 (against vanilla, below) |
| flat_plants | 8.53 (base 18.96) | 15 (base 15) | 4496 (base 9864) | 237.8 (base 248.07) | 3.45 (against vanilla, below) |
| renderer_off | 7.67 (base 7.83) | 14 (base 14) | 3612 (base 7180) | 233.58 (base 241.13) | 3.34 (against vanilla, below) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 266.32 (base 261.4) | 5.98 (against vanilla, below) |
| animation | 49 median (avg 40.06) (base 49) | 15 (base 15) | 2164 (base 2056) | 262.97 (base 260.68) | 5.98 (against vanilla, below) |
| animated_items | 60 median (avg 47.17) (base 60) | 24 (base 23) | 22136 (base 21940) | 237.33 (base 239.74) | 5.98 (against vanilla, below) |
| block_entities | 33.96 (base 34.15) | 17 (base 17) | 94576 (base 94912) | 236.59 (base 236.53) | 5.98 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 13.1 / 13 (16.57) | 123.57 / 124 (14.09) | median and average, x 1.10 + 2 |
| flythrough | 13.05 / 13 (10.63) | 123.06 / 123 (9.57) | median and average, at most vanilla + 2 |
| water_glass | 8.69 / 9 (28.81) | 109.02 / 124 (22.49) | median, at most vanilla |
| nether | 12.4 / 16 (28.64) | 104.85 / 121 (22.47) | median, x 1.10 + 2 |
| mobs | 11.67 / 12 (29.71) | 101.19 / 134 (27.76) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (29.99) | 87.59 / 126 (29.89) | median, x 1.10 + 2 |
| occlusion | 10.67 / 11 (29.97) | 95.11 / 133 (29.68) | median and average, x 1.10 + 2 |
| occlusion_move | 11.49 / 12 (29.93) | 94.98 / 133 (29.75) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.67 / 6 (29.99) | 82.92 / 121 (29.75) | median and average, x 1.10 + 2 |
| translucent_move | 8.68 / 9 (29.26) | 105.04 / 124 (23.56) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (12.64) | 129.0 / 129 (11.79) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (13.26) | 129.0 / 129 (11.52) | median and average, at most vanilla |
| flat_plants | 8.53 / 9 (29.36) | 107.36 / 124 (22.69) | median, x 1.10 + 2 |
| renderer_off | 7.67 / 8 (29.95) | 86.05 / 123 (29.32) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (30.0) | 86.66 / 125 (29.84) | median and average, x 1.10 + 2 |
| animation | 40.06 / 49 (29.98) | 145.38 / 179 (29.8) | median, x 1.10 + 2 |
| animated_items | 47.17 / 60 (29.94) | 156.14 / 190 (29.79) | median, x 1.10 + 2 |
| block_entities | 33.96 / 41 (29.99) | 97.51 / 136 (29.97) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-vk), core vulkan (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| spawn | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.38 |
| flythrough | 3.71 / 3.71 | 3.71 / 3.71 | 7.71 / 7.71 | 12.65 |
| water_glass | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.65 |
| nether | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.65 |
| mobs | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 14.85 |
| outline | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.08 |
| occlusion | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.38 |
| occlusion_move | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.65 |
| occlusion_corner | 5.98 / 5.98 | 4.23 / 4.23 | 8.23 / 8.23 | 12.08 |
| translucent_move | 5.98 / 5.98 | 8.23 / 8.23 | 12.23 / 12.23 | 14.01 |
| water_glass_oit | 5.34 / 5.34 | 3.59 / 3.59 | 7.59 / 7.59 | 11.81 |
| translucent_move_oit | 5.46 / 5.46 | 3.71 / 3.71 | 7.71 / 7.71 | 11.81 |
| flat_plants | 3.45 / 3.45 | 3.32 / 3.32 | 7.32 / 7.32 | 14.58 |
| renderer_off | 3.34 / 3.34 | 3.59 / 3.59 | 7.59 / 7.59 | 12.51 |
| particles | 5.98 / 5.98 | 8.23 / 8.23 | 12.23 / 12.23 | 14.58 |
| animation | 5.98 / 5.98 | 8.23 / 8.23 | 12.23 / 12.23 | 14.58 |
| animated_items | 5.98 / 5.98 | 8.23 / 8.23 | 12.23 / 12.23 | 14.58 |
| block_entities | 5.98 / 5.98 | 8.23 / 8.23 | 12.23 / 12.23 | 12.65 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 40.0 / 22.466 | 40.0 / 22.466 | 0.0 / 0.0 | 416.0 / 37.321 |
| flythrough | 112.0 / 85.747 | 112.0 / 85.747 | 0.0 / 0.0 | 416.0 / 148.818 |
| water_glass | 40.0 / 12.459 | 40.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| nether | 20.0 / 15.329 | 20.0 / 15.329 | 0.0 / 0.0 | 256.0 / 26.868 |
| mobs | 20.0 / 10.095 | 20.0 / 10.095 | 0.0 / 0.0 | 416.0 / 17.542 |
| outline | 20.0 / 1.539 | 20.0 / 1.539 | 0.0 / 0.0 | 256.0 / 2.711 |
| occlusion | 20.0 / 2.476 | 20.0 / 2.476 | 0.0 / 0.0 | 416.0 / 4.432 |
| occlusion_move | 20.0 / 3.394 | 20.0 / 3.394 | 0.0 / 0.0 | 416.0 / 5.811 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.037 | 28.0 / 13.037 | 0.0 / 0.0 | 416.0 / 22.462 |
| water_glass_oit | 20.0 / 12.459 | 20.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| translucent_move_oit | 28.0 / 12.626 | 28.0 / 12.626 | 0.0 / 0.0 | 416.0 / 21.745 |
| flat_plants | 24.0 / 14.412 | 24.0 / 14.412 | 0.0 / 0.0 | 416.0 / 24.883 |
| renderer_off | 24.0 / 8.959 | 24.0 / 8.959 | 0.0 / 0.0 | 416.0 / 15.69 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.259 |
| block_entities | 28.0 / 0.143 | 28.0 / 0.143 | 0.0 / 0.0 | 256.0 / 0.247 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 461319.746 (621984.314) | 25.831 | 1.178 | 433320 / 834916 | 408256 (2097152.0) | 331 / 281 | 0.0 / 0 |
| flythrough | 562079.396 (898499.868) | 37.442 | 1.084 | 2123796 / 6879676 | 2095904 (2097152.0) | 212 / 191 | 4.103 / 65 |
| water_glass | 113642.614 (198497.421) | 42.749 | 1.132 | 14644 / 17632 | 0 (2097152.0) | 8 / 36 | 0.0 / 0 |
| nether | 64188.621 (94482.171) | 32.063 | 1.568 | 237956 / 279112 | 217472 (2097152.0) | 10 / 48 | 0.0 / 0 |
| mobs | 62138.434 (110920.421) | 43.979 | 0.967 | 613596 / 616336 | 0 (2097152.0) | 3 / 19 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5580 / 8476 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27363.53 (47783.507) | 42.734 | 1.302 | 100052 / 422996 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| occlusion_move | 49369.379 (86572.327) | 42.973 | 1.232 | 748708 / 1136940 | 671808 (2097152.0) | 0 / 1 | 0.0 / 0 |
| occlusion_corner | 27756.267 (60453.776) | 54.087 | 1.272 | 36188 / 59512 | 31552 (2097152.0) | 0 / 3 | 0.0 / 0 |
| translucent_move | 202107.244 (359069.128) | 43.714 | 1.174 | 768192 / 1333252 | 756352 (2097152.0) | 9 / 23 | 0.0 / 0 |
| water_glass_oit | 113896.183 (198940.325) | 42.749 | 1.132 | 14756 / 17072 | 0 (2097152.0) | 252 / 235 | 0.0 / 0 |
| translucent_move_oit | 201372.906 (357490.687) | 43.67 | 1.173 | 743060 / 1290448 | 731840 (2097152.0) | 264 / 230 | 0.0 / 0 |
| flat_plants | 9099.475 (12475.216) | 27.06 | 1.045 | 4944 / 10144 | 0 (2097152.0) | 3 / 46 | 0.0 / 0 |
| renderer_off | 21241.462 (40321.314) | 47.32 | 1.0 | 3612 / 7272 | 0 (2097152.0) | 0 / 12 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3061.135 (5267.352) | 41.885 | 1.085 | 86740 / 150176 | 84608 (2097152.0) | 0 / 2 | 0.0 / 0 |
| animated_items | 2246.785 (4832.668) | 53.508 | 1.0 | 79772 / 122908 | 57728 (2097152.0) | 12 / 16 | 0.0 / 0 |
| block_entities | 3461.77 (4439.399) | 22.022 | 1.6 | 136064 / 169496 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 1.657 (105) | 1.803 (111) | 0.919 | 1.736 (54) | 0 | 931 / 0 | 5.081 / 6.299 | 1.825 / 2.601 |
| flythrough | 3.112 (1697) | 3.196 (1744) | 0.974 | 3.112 (1697) | 0 | 1391 / 0 | 3.937 / 5.393 | 2.124 / 3.256 |
| water_glass | 0.977 (20) | 0.938 (18) | 1.042 | None (0) | 0 | 1263 / 0 | 4.459 / 5.566 | 1.671 / 2.323 |
| nether | 1.544 (43) | 1.486 (42) | 1.039 | 1.615 (21) | 0 | 1888 / 0 | 3.692 / 4.665 | 1.429 / 1.95 |
| mobs | 1.596 (67) | 1.681 (67) | 0.949 | None (0) | 0 | 2127 / 0 | 3.543 / 4.454 | 1.404 / 1.9 |
| outline | 0.244 (12) | 0.216 (13) | 1.13 | None (0) | 0 | 2186 / 0 | 3.506 / 4.428 | 1.399 / 1.896 |
| occlusion | 0.46 (41) | 0.392 (43) | 1.173 | None (0) | 0 | 2315 / 0 | 3.406 / 4.323 | 1.366 / 1.849 |
| occlusion_move | 1.17 (63) | 0.939 (60) | 1.246 | 2.153 (19) | 0 | 2454 / 0 | 3.272 / 4.16 | 1.323 / 1.811 |
| occlusion_corner | 0.863 (110) | 0.61 (110) | 1.415 | 0.741 (1) | 0 | 2734 / 0 | 3.056 / 3.901 | 1.191 / 1.605 |
| translucent_move | 1.487 (133) | 1.475 (127) | 1.008 | 2.25 (33) | 0 | 3112 / 0 | 2.954 / 3.783 | 1.219 / 1.63 |
| water_glass_oit | 2.008 (158) | 1.827 (154) | 1.099 | None (0) | 0 | 413 / 0 | 4.256 / 5.698 | 1.857 / 2.412 |
| translucent_move_oit | 2.12 (230) | 2.641 (220) | 0.803 | 1.899 (29) | 0 | 967 / 0 | 3.04 / 4.058 | 1.455 / 2.059 |
| flat_plants | 1.035 (97) | 0.756 (96) | 1.369 | None (0) | 0 | 402 / 0 | 4.296 / 6.184 | 1.308 / 1.834 |
| renderer_off | 0.303 (20) | 0.27 (25) | 1.122 | None (0) | 0 | 326 / 0 | 3.774 / 6.097 | 1.419 / 2.142 |
| particles | 0.209 (30) | 0.156 (30) | 1.34 | None (0) | 0 | 3140 / 0 | 2.931 / 3.754 | 1.203 / 1.618 |
| animation | 0.548 (18) | 0.547 (18) | 1.002 | 0.843 (4) | 0 | 3215 / 0 | 2.875 / 3.679 | 1.177 / 1.583 |
| animated_items | 0.22 (42) | 0.799 (42) | 0.275 | 0.628 (2) | 0 | 3247 / 0 | 2.85 / 3.646 | 1.162 / 1.564 |
| block_entities | 0.536 (83) | 0.544 (83) | 0.985 | 0.88 (1) | 0 | 3329 / 0 | 2.794 / 3.573 | 1.133 / 1.519 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.009 | 706.205 | 16 (vanilla 28) | 1356240 | 43.159 / 0.101 | 22.466 / 40.0 | 36.216 | 2548 / 0 | 1.736 (2.583) |
| flythrough | indirect, one multi-draw per arena and layer | 3.014 | 927.873 | 16 (vanilla 28) | 5197020 | 15.509 / 1.051 | 85.747 / 112.0 | 138.775 | 6626 / 0 | 3.112 (10.424) |
| water_glass | indirect, one multi-draw per arena and layer | 3.005 | 106.184 | 16 (vanilla 28) | 772256 | 35.56 / 0.088 | 12.459 / 40.0 | 20.621 | 3258 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.003 | 93.63 | 16 (vanilla 28) | 962608 | 29.876 / 0.184 | 15.329 / 20.0 | 25.704 | 4331 / 0 | 1.615 (2.129) |
| mobs | indirect, one multi-draw per arena and layer | 2.003 | 60.101 | 16 (vanilla 28) | 624308 | 26.615 / 0.168 | 10.095 / 20.0 | 16.671 | 4903 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 96900 | 26.134 / 0.167 | 1.539 / 20.0 | 2.588 | 4997 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 3.005 | 43.072 | 16 (vanilla 28) | 154464 | 25.138 / 0.16 | 2.476 / 20.0 | 4.125 | 5223 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.003 | 76.374 | 16 (vanilla 28) | 212220 | 23.969 / 0.152 | 3.394 / 20.0 | 5.667 | 5488 / 0 | 2.153 (5.297) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.907 | 16 (vanilla 28) | 122728 | 22.691 / 0.144 | 1.931 / 20.0 | 3.277 | 5877 / 0 | 0.741 (0.738) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.003 | 249.393 | 16 (vanilla 28) | 805028 | 19.464 / 0.129 | 13.037 / 28.0 | 21.497 | 6785 / 0 | 2.25 (5.201) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.02 | 114.452 | 16 (vanilla 28) | 772256 | 7.485 / 0.043 | 12.459 / 20.0 | 20.621 | 1097 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.015 | 262.875 | 16 (vanilla 28) | 779176 | 6.774 / 0.112 | 12.626 / 28.0 | 20.806 | 2451 / 0 | 1.899 (3.852) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 899432 | 6.293 / 0.01 | 14.412 / 24.0 | 24.017 | 953 / 0 | None (None) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.037 | 16 (vanilla 28) | 562680 | 2.325 / 0.02 | 8.959 / 24.0 | 15.025 | 604 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 19.415 / 0.129 | 0.131 / 28.0 | 0.225 | 6829 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 11.765 | 16 (vanilla 28) | 19416 | 19.271 / 0.128 | 0.302 / 28.0 | 0.518 | 6931 / 0 | 0.843 (1.129) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 12.701 | 16 (vanilla 28) | 9764 | 19.22 / 0.128 | 0.153 / 28.0 | 0.261 | 6981 / 0 | 0.628 (0.948) |
| block_entities | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 8864 | 18.933 / 0.126 | 0.143 / 28.0 | 0.237 | 7140 / 0 | 0.88 (0.876) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 1.0 | 0.0 | 0 | 0 | 48 (0.017 / 0.029 / 0.103; 0) | 0 | 50796 / 0 / 0 |
| flythrough | 195.559 | 1.0 | 0.0 | 0 | 0 | 929 (0.013 / 0.034 / 1.364; 0) | 55 | 41654 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2312 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.006 / 0.008 / 0.009; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.067 / 0.099 / 0.485; 0) | 180 | 4102 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 759 | 0 (None / None / None; 0) | 0 | 1012 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 798 | 0 (None / None / None; 0) | 0 | 1862 / 0 / 0 |
| flat_plants | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2352 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 344.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.027 (0.658; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.178 | 1.0 (0.0, 0.0) | 1.183 (0.0, 0.0) | 0.001 (0.009; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.19; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.096 (0.18; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.044 (0.165; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.362) | 6.0 (6.0, 2.278) | 0.045 (0.409; 0) | 0 | 2784 / 1506902 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.312 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.263 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.041; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.003 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.027 (0.249; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 295.99 / 342.0 (13.5) | 295.99 / 0.0 / 0.0 | 0.09 | 0.0 (0.0, 0.0; 0.0) | 1344.58 | 3876 / 0 |
| flythrough | still | 412.8 / 413.09 (0.1) | 412.8 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 12615 / 0 |
| nether | still | 68.16 / 300.0 (77.3) | 68.16 / 0.0 / 0.0 | 0.03 | 0.0 (0.0, 0.0; 0.0) | 426.48 | 33138 / 0 |
| mobs | still | 32.0 / 110.0 (70.9) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11622 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.0 / 49.0 (46.9) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion_move | still | 51.19 / 51.31 (0.2) | 51.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 37 / 0 |
| occlusion_corner | still | 81.72 / 81.85 (0.2) | 81.72 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 135.83 / 136.2 (0.3) | 135.83 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 109 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5481 / 0 |
| translucent_move_oit | still | 134.95 / 135.77 (0.6) | 134.95 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 152.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 21021 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.74 / 13.0 (17.4) | 10.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 303 / 0 |
| animated_items | still | 12.67 / 13.0 (2.5) | 12.67 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4488.0 | 48 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.0 | 0 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.509 / 0.009 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 117.756 / 0.009 | 0.025 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.859 |
| water_glass | 100.145 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.501 / 53.526 | 0.017 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 99.12 / 6.963 | 0.866 / 0.712 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 46.09 / 7.436 | 0.057 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 82.468 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.859 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 77.441 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 77.311 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 77.247 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 96.2 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.88 / 13.858 | 0.006 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.337 / 53.237 | 0.017 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.978 / 13.977 | 0.007 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 98.499 / 0.0 | 1.0 / 0.85 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.658 / 2.457 | 0.013 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | 78.365 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.988 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.002 / 0.017 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 137.713 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.002 / 0.004 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 137.471 / 28.137 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.564 / 7.98 / 32.584 | 0 / 0 | 9.0 |
| block_entities | 76.667 / 13.322 | 1.0 / 0.848 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.125 / 11.145 | 0.002 / 0.003 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| block_entities | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |

### Counts, core old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 50.0 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.1 (base 256.29) | 4.24 (against vanilla, below) |
| flythrough | 68.73 (reported, not gated) | 36 (reported, not gated) | 248652 (reported, not gated) | 310.44 (base 324.79) | 3.73 (against vanilla, below) |
| water_glass | 20.82 (base 20.0) | 13 (base 14) | 7764 (base 10264) | 238.47 (base 249.83) | 4.24 (against vanilla, below) |
| nether | 24.05 (base 33.79) | 10 (base 11) | 4288 (base 10656) | 260.07 (base 272.57) | 4.24 (against vanilla, below) |
| mobs | 18.7 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 259.74 (base 268.23) | 4.24 (against vanilla, below) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.45 (base 264.41) | 4.24 (against vanilla, below) |
| occlusion | 14.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 264.07 (base 264.64) | 4.24 (against vanilla, below) |
| occlusion_move | 15.51 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 265.01 (base 265.66) | 4.24 (against vanilla, below) |
| occlusion_corner | 11.72 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.85 (base 267.41) | 4.24 (against vanilla, below) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 275.39 (base 268.19) | 4.24 (against vanilla, below) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 6756 (base 7604) | 238.34 (base 245.78) | 3.6 (against vanilla, below) |
| translucent_move_oit | 18.43 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 240.98 (base 248.15) | 3.73 (against vanilla, below) |
| flat_plants | 10.75 (base 33.0) | 13 (base 13) | 1624 (base 1716) | 237.81 (base 248.11) | 3.21 (against vanilla, below) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.26 (base 240.73) | 3.6 (against vanilla, below) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.3 (base 261.4) | 4.24 (against vanilla, below) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.71 (base 260.68) | 4.24 (against vanilla, below) |
| animated_items | 61 median (avg 47.77) (base 60) | 22 (base 22) | 21668 (base 21668) | 237.24 (base 239.53) | 4.24 (against vanilla, below) |
| block_entities | 36.12 (base 36.11) | 15 (base 15) | 94560 (base 95140) | 236.48 (base 236.55) | 4.24 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 50.0 / 50 (12.62) | 899.44 / 899 (12.79) | median and average, x 1.10 + 2 |
| flythrough | 68.73 / 67 (9.05) | 1027.18 / 1024 (8.27) | median and average, at most vanilla |
| water_glass | 20.82 / 21 (24.42) | 385.59 / 392 (20.84) | median, at most vanilla |
| nether | 24.05 / 27 (26.7) | 584.24 / 588 (20.32) | median, x 1.10 + 2 |
| mobs | 18.7 / 19 (28.57) | 306.61 / 335 (26.38) | median, x 1.10 + 2 |
| outline | 11.67 / 12 (30.0) | 127.33 / 166 (30.0) | median, x 1.10 + 2 |
| occlusion | 14.67 / 15 (30.0) | 162.27 / 201 (30.0) | median and average, x 1.10 + 2 |
| occlusion_move | 15.51 / 16 (29.96) | 167.6 / 202 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.72 / 12 (30.0) | 163.21 / 201 (29.99) | median and average, x 1.10 + 2 |
| translucent_move | 11.13 / 11 (27.19) | 359.33 / 367 (21.59) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (12.4) | 403.0 / 403 (10.72) | median, at most vanilla |
| translucent_move_oit | 18.43 / 18 (12.25) | 386.33 / 387 (10.37) | median and average, at most vanilla |
| flat_plants | 10.75 / 11 (25.71) | 392.04 / 401 (21.61) | median, x 1.10 + 2 |
| renderer_off | 13.67 / 14 (29.93) | 287.11 / 325 (29.67) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (30.0) | 97.27 / 136 (30.0) | median and average, x 1.10 + 2 |
| animation | 40.98 / 50 (30.0) | 156.22 / 191 (30.0) | median, x 1.10 + 2 |
| animated_items | 47.77 / 61 (30.0) | 167.28 / 202 (30.01) | median, x 1.10 + 2 |
| block_entities | 36.12 / 43 (30.0) | 105.29 / 144 (30.0) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-old), core old-gpu-2p (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| spawn | 4.24 / 4.24 | 3.99 / 3.99 | 7.99 / 7.99 | 12.1 |
| flythrough | 3.73 / 3.73 | 3.48 / 3.48 | 7.48 / 7.48 | 14.59 |
| water_glass | 4.24 / 4.24 | 3.99 / 3.99 | 7.99 / 7.99 | 14.59 |
| nether | 4.24 / 4.24 | 3.99 / 3.99 | 7.99 / 7.99 | 14.59 |
| mobs | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 14.59 |
| outline | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 12.1 |
| occlusion | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 12.66 |
| occlusion_move | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 14.59 |
| occlusion_corner | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 12.1 |
| translucent_move | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 12.1 |
| water_glass_oit | 3.6 / 3.6 | 3.6 / 3.6 | 7.6 / 7.6 | 12.1 |
| translucent_move_oit | 3.73 / 3.73 | 3.73 / 3.73 | 7.73 / 7.73 | 12.1 |
| flat_plants | 3.21 / 3.21 | 3.21 / 3.21 | 7.21 / 7.21 | 14.59 |
| renderer_off | 3.6 / 3.6 | 3.6 / 3.6 | 7.6 / 7.6 | 14.46 |
| particles | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 12.66 |
| animation | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 12.66 |
| animated_items | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 14.59 |
| block_entities | 4.24 / 4.24 | 5.99 / 5.99 | 9.99 / 9.99 | 17.06 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 36.0 / 22.467 | 36.0 / 22.467 | 0.0 / 0.0 | 416.0 / 38.396 |
| flythrough | 112.0 / 85.648 | 112.0 / 85.648 | 0.0 / 0.0 | 416.0 / 147.446 |
| water_glass | 36.0 / 12.459 | 36.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| nether | 20.0 / 15.324 | 20.0 / 15.324 | 0.0 / 0.0 | 256.0 / 26.868 |
| mobs | 20.0 / 10.094 | 20.0 / 10.094 | 0.0 / 0.0 | 416.0 / 17.542 |
| outline | 20.0 / 1.539 | 20.0 / 1.539 | 0.0 / 0.0 | 256.0 / 2.711 |
| occlusion | 20.0 / 2.478 | 20.0 / 2.478 | 0.0 / 0.0 | 416.0 / 4.475 |
| occlusion_move | 20.0 / 3.32 | 20.0 / 3.32 | 0.0 / 0.0 | 416.0 / 5.823 |
| occlusion_corner | 20.0 / 1.931 | 20.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 12.988 | 28.0 / 12.988 | 0.0 / 0.0 | 416.0 / 22.385 |
| water_glass_oit | 20.0 / 12.459 | 20.0 / 12.459 | 0.0 / 0.0 | 416.0 / 21.614 |
| translucent_move_oit | 28.0 / 12.577 | 28.0 / 12.577 | 0.0 / 0.0 | 416.0 / 21.765 |
| flat_plants | 24.0 / 14.383 | 24.0 / 14.383 | 0.0 / 0.0 | 416.0 / 24.774 |
| renderer_off | 24.0 / 8.924 | 24.0 / 8.924 | 0.0 / 0.0 | 416.0 / 15.69 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.302 | 28.0 / 0.302 | 0.0 / 0.0 | 256.0 / 0.545 |
| animated_items | 28.0 / 0.153 | 28.0 / 0.153 | 0.0 / 0.0 | 128.0 / 0.272 |
| block_entities | 28.0 / 0.142 | 28.0 / 0.142 | 0.0 / 0.0 | 256.0 / 0.247 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 388646.438 (584840.988) | 33.547 | 1.776 | 366860 / 561580 | 365480 (2097152.0) | 251 / 255 | 0.0 / 0 |
| flythrough | 482867.348 (758305.89) | 36.323 | 1.085 | 2107444 / 7226120 | 2096704 (2097152.0) | 181 / 165 | 7.154 / 90 |
| water_glass | 113678.471 (198560.053) | 42.749 | 1.132 | 166404 / 11092 | 158080 (2097152.0) | 49 / 46 | 0.0 / 0 |
| nether | 29499.139 (42397.247) | 30.422 | 2.0 | 152676 / 337268 | 149184 (2097152.0) | 133 / 68 | 0.0 / 0 |
| mobs | 62142.641 (110927.93) | 43.979 | 0.967 | 610676 / 612276 | 0 (2097152.0) | 12 / 10 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 27349.507 (47761.47) | 42.737 | 1.302 | 98148 / 394844 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 21070.163 (36858.89) | 42.836 | 1.275 | 672316 / 1111260 | 597248 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21836.93 (47208.453) | 53.744 | 1.215 | 32840 / 57892 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21617.629 (27658.393) | 21.841 | 1.005 | 758372 / 1327988 | 756096 (2097152.0) | 132 / 41 | 0.0 / 0 |
| water_glass_oit | 113905.296 (198956.243) | 42.749 | 1.132 | 8548 / 12100 | 0 (2097152.0) | 247 / 214 | 0.0 / 0 |
| translucent_move_oit | 21732.631 (27841.762) | 21.942 | 1.006 | 726932 / 1286228 | 722688 (2097152.0) | 244 / 207 | 0.0 / 0 |
| flat_plants | 9101.673 (12478.23) | 27.06 | 1.045 | 1940 / 4564 | 0 (2097152.0) | 128 / 43 | 0.0 / 0 |
| renderer_off | 20762.604 (39369.616) | 47.262 | 1.0 | 1380 / 3172 | 0 (2097152.0) | 11 / 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86232 / 149988 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79396 / 124632 | 57728 (2097152.0) | 0 / 0 | 0.0 / 0 |
| block_entities | 3461.77 (4439.399) | 22.022 | 1.6 | 135920 / 167300 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 2.53 (128) | 2.468 (133) | 1.025 | 2.526 (55) | 0 | 858 / 0 | 7.311 / 9.732 | 3.053 / 4.839 |
| flythrough | 4.348 (1665) | 4.959 (1634) | 0.877 | 4.348 (1665) | 0 | 1393 / 0 | 5.614 / 7.838 | 3.245 / 5.286 |
| water_glass | 1.696 (21) | 1.427 (18) | 1.189 | 2.637 (1) | 0 | 1170 / 0 | 6.568 / 8.658 | 2.776 / 4.319 |
| nether | 1.87 (31) | 2.126 (26) | 0.88 | 2.025 (10) | 0 | 1791 / 0 | 5.302 / 6.965 | 2.274 / 3.287 |
| mobs | 2.488 (67) | 3.153 (67) | 0.789 | None (0) | 0 | 2027 / 0 | 5.114 / 6.748 | 2.256 / 3.209 |
| outline | 0.472 (13) | 0.291 (13) | 1.622 | None (0) | 0 | 2086 / 0 | 5.042 / 6.641 | 2.229 / 3.168 |
| occlusion | 0.926 (45) | 2.116 (50) | 0.438 | None (0) | 0 | 2228 / 0 | 4.862 / 6.391 | 2.177 / 2.996 |
| occlusion_move | 1.469 (71) | 1.428 (63) | 1.029 | 2.912 (25) | 0 | 2382 / 0 | 4.663 / 6.119 | 2.105 / 2.872 |
| occlusion_corner | 0.937 (110) | 0.925 (110) | 1.013 | 0.831 (1) | 0 | 2662 / 0 | 4.333 / 5.663 | 1.875 / 2.524 |
| translucent_move | 2.437 (128) | 2.863 (131) | 0.851 | 3.898 (44) | 0 | 3047 / 0 | 4.178 / 5.511 | 1.909 / 2.628 |
| water_glass_oit | 2.876 (154) | 3.095 (152) | 0.929 | None (0) | 0 | 413 / 0 | 6.688 / 8.889 | 3.446 / 4.688 |
| translucent_move_oit | 3.454 (222) | 4.243 (216) | 0.814 | 4.602 (25) | 0 | 967 / 0 | 4.54 / 6.037 | 2.121 / 3.034 |
| flat_plants | 1.701 (83) | 1.553 (98) | 1.095 | None (0) | 0 | 402 / 0 | 6.958 / 8.43 | 2.192 / 2.959 |
| renderer_off | 0.64 (21) | 0.337 (21) | 1.899 | None (0) | 0 | 324 / 0 | 5.466 / 7.986 | 2.283 / 3.718 |
| particles | 0.316 (30) | 0.202 (24) | 1.564 | None (0) | 0 | 3074 / 0 | 4.146 / 5.467 | 1.89 / 2.584 |
| animation | 0.716 (18) | 1.271 (18) | 0.563 | 0.91 (4) | 0 | 3149 / 0 | 4.066 / 5.357 | 1.836 / 2.475 |
| animated_items | 0.287 (42) | 0.269 (32) | 1.067 | 0.646 (2) | 0 | 3181 / 0 | 4.03 / 5.308 | 1.813 / 2.453 |
| block_entities | 1.0 (82) | 0.613 (59) | 1.631 | 1.473 (1) | 0 | 3263 / 0 | 3.951 / 5.2 | 1.743 / 2.378 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.155 | 654.598 | 16 (vanilla 28) | 1355720 | 41.497 / 0.082 | 22.467 / 36.0 | 36.202 | 2393 / 0 | 2.526 (6.039) |
| flythrough | plain, one multi-draw per region and layer | 57.917 | 766.193 | 16 (vanilla 28) | 5193100 | 14.93 / 0.929 | 85.648 / 112.0 | 138.671 | 6564 / 0 | 4.348 (12.732) |
| water_glass | plain, one multi-draw per region and layer | 14.029 | 106.217 | 16 (vanilla 28) | 772256 | 33.419 / 0.074 | 12.459 / 36.0 | 20.621 | 3052 / 0 | 2.637 (2.626) |
| nether | plain, one multi-draw per region and layer | 12.022 | 43.081 | 16 (vanilla 28) | 962400 | 27.988 / 0.165 | 15.324 / 20.0 | 25.699 | 4092 / 0 | 2.025 (2.765) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.105 | 16 (vanilla 28) | 624308 | 24.849 / 0.14 | 10.094 / 20.0 | 16.671 | 4657 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 96900 | 24.372 / 0.14 | 1.539 / 20.0 | 2.588 | 4752 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 154676 | 23.22 / 0.133 | 2.478 / 20.0 | 4.13 | 5007 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.873 | 16 (vanilla 28) | 207032 | 21.951 / 0.125 | 3.32 / 20.0 | 5.528 | 5316 / 0 | 2.912 (6.383) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.888 | 16 (vanilla 28) | 122728 | 20.741 / 0.118 | 1.931 / 20.0 | 3.277 | 5705 / 0 | 0.831 (0.83) |
| translucent_move | plain, one multi-draw per region and layer | 4.404 | 23.11 | 16 (vanilla 28) | 800408 | 17.872 / 0.108 | 12.988 / 28.0 | 21.373 | 6615 / 0 | 3.898 (9.362) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.065 | 114.462 | 16 (vanilla 28) | 772256 | 7.511 / 0.043 | 12.459 / 20.0 | 20.621 | 1089 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.467 | 37.246 | 16 (vanilla 28) | 774588 | 6.759 / 0.112 | 12.577 / 28.0 | 20.684 | 2424 / 0 | 4.602 (12.605) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 896604 | 5.888 / 0.01 | 14.383 / 24.0 | 23.942 | 924 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 560372 | 2.353 / 0.02 | 8.924 / 24.0 | 14.964 | 601 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 17.833 / 0.108 | 0.131 / 28.0 | 0.225 | 6657 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 17.697 / 0.107 | 0.302 / 28.0 | 0.518 | 6759 / 0 | 0.91 (1.488) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.649 / 0.108 | 0.153 / 28.0 | 0.261 | 6809 / 0 | 0.646 (0.988) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 17.38 / 0.106 | 0.142 / 28.0 | 0.237 | 6967 / 0 | 1.473 (1.472) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 17.0 | 0.0 | 0 | 0 | 51 (0.022 / 0.035 / 0.045; 0) | 0 | 38556 / 0 / 0 |
| flythrough | 192.346 | 26.077 | 0.0 | 0 | 0 | 879 (0.037 / 0.036 / 12.042; 0) | 60 | 35007 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1956 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.009; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.081 / 0.124 / 0.153; 0) | 180 | 3815 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 744 | 0 (None / None / None; 0) | 0 | 992 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 735 | 0 (None / None / None; 0) | 0 | 1715 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2060 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 344.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.254; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 432.434 | 1.0 (0.0, 0.0) | 1.582 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.076; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.123 (0.354; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.073 (0.217; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (8.993, 2.354) | 6.0 (5.99, 2.271) | 0.067 (3.417; 1) | 0 | 2780 / 1504862 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.301 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.429 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.042; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.044 (0.076; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 266.0 / 342.0 (22.2) | 266.0 / 76.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4712 / 0 |
| flythrough | two-phase | 314.9 / 405.93 (22.4) | 309.42 / 96.51 / 5.48 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4117 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10614 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 34979 / 0 |
| mobs | two-phase | 32.0 / 110.0 (70.9) | 32.0 / 78.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 11076 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.41 / 51.32 (56.3) | 22.35 / 28.96 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4327 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.69 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.68 / 136.17 (88.5) | 15.66 / 120.51 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 16394 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5394 / 0 |
| translucent_move_oit | two-phase | 15.67 / 135.89 (88.5) | 15.62 / 120.27 / 0.04 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7327 / 0 |
| flat_plants | two-phase | 9.0 / 153.0 (94.1) | 9.0 / 144.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18432 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15150 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 894 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.435 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 100.83 / 0.0 | 0.026 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.566 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.852 |
| water_glass | 108.642 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 59.062 / 59.047 | 0.03 / 0.03 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 111.318 / 7.453 | 0.958 / 0.852 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.838 / 6.798 | 0.067 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 86.85 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | 105.417 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.005 / 12.0 | 0.005 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 48.365 / 48.423 | 0.015 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.614 / 11.563 | 0.007 / 0.012 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 106.215 / 0.0 | 0.898 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.963 / 2.744 | 0.016 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | 77.441 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.005 / 0.047 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | 136.553 / 32.311 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.004 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | 136.553 / 28.104 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |
| block_entities | 76.667 / 13.322 | 0.832 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.288 / 12.258 | 0.003 / 0.01 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| block_entities | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |

## Suite siftec

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
- quicksilver-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=4.5 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-full: bench kinetics_instancing: median meshing time 0.746 ms per section against vanilla's compiler 0.821 ms (0.909x; limit 0.821 ms; 128 pairs): reported, not gated (open gap)

siftec/quicksilver-full: bench factory_flat: median meshing time 0.293 ms per section against vanilla's compiler 0.279 ms (1.05x; limit 0.307 ms; 597 pairs): reported, not gated (open gap)

- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench kinetics_instancing: median meshing time 1.638 ms per section against vanilla's compiler 1.519 ms (1.078x; limit 1.519 ms; 142 pairs): reported, not gated (open gap)

siftec/quicksilver-old: bench factory_flat: median meshing time 0.692 ms per section against vanilla's compiler 0.504 ms (1.373x; limit 0.554 ms; 609 pairs): reported, not gated (open gap)

- quicksilver-vk: backend `Vulkan` drivers `1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="1.4.318 llvmpipe Mesa 25.2.8-0ubuntu0.24.04.4 (LLVM 20.1.2)" gl=n/a backend=Vulkan os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
siftec/quicksilver-vk: bench factory_flat: median meshing time 0.443 ms per section against vanilla's compiler 0.413 ms (1.073x; limit 0.454 ms; 575 pairs): reported, not gated (open gap)

siftec/quicksilver-vk: bench kinetics_instancing: median meshing time 2.155 ms per section against vanilla's compiler 1.715 ms (1.257x; limit 1.715 ms; 145 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.948 ms per section against vanilla's compiler 0.718 ms (1.32x; limit 0.79 ms; 613 pairs): reported, not gated (open gap)

siftec/quicksilver-2p-old: bench kinetics_instancing: median meshing time 3.018 ms per section against vanilla's compiler 2.291 ms (1.317x; limit 2.291 ms; 151 pairs): reported, not gated (open gap)

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
| factory | 0.0169 | 0.3 | 0.0 | 0.0 | 0.0 | 0.0 |
| factory_flat | 0.0 | 0.3 | 0.0 | 0.0034 | 0.0034 | 0.0034 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 | 0.0067 | 0.0068 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0026 | 0.55 | 0.0063 | 0.0071 | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | 0.0069 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 | 0.0 | 0.0 |
| kinetics | 0.0076 | 0.25 | 0.0036 | 0.0116 | 0.0098 | 0.0094 |
| kinetics_instancing | 0.0105 | 0.25 | 0.0103 | 0.0103 | 0.0181 | 0.0167 |

Strict picture: pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|---|
| factory | 95.56 | 370 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| factory_flat | 89.7 | 40 | 0 (14) | 0 (14) | 0 (14) | 0 (14) |
| sift | 93.9 | 100 | 55 (536) | 55 (536) | 61 (519) | 55 (536) |
| hub | 99.84 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| mam | 95.45 | 10 | 0 (0) | 0 (0) | 0 (67171) | 0 (0) |
| ponder | 99.69 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 39 (4282) | 44 (4287) | None (None) | 43 (4284) |
| create_ct | 98.36 | 10 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| kinetics | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |
| kinetics_instancing | 95.36 | 30 | 8 (855) | 8 (855) | 7 (891) | 8 (855) |

Strict picture where the vanilla runs drawing the same way agree (package 5, Create scenes: Flywheel on in vanilla a and b, off in vanilla old and Vulkan), same strict limits:

| scene | runs | vanilla runs | agree on % of pixels | strict pixels |
|---|---|---|---|---|
| kinetics | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 9 |
| kinetics | measure | vanilla-a and vanilla-b | 99.17 | full 0 |
| kinetics | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 7, old-gpu-2p 8 |
| kinetics | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 0, old-gpu-2p 0 |
| kinetics_instancing | Quicksilver | vanilla-a and vanilla-b | 99.17 | full 13 |
| kinetics_instancing | measure | vanilla-a and vanilla-b | 99.17 | full 4 |
| kinetics_instancing | Quicksilver | vanilla-old and vanilla-vk | 95.98 | old-gpu 8, vulkan 7, old-gpu-2p 8 |
| kinetics_instancing | measure | vanilla-old and vanilla-vk | 95.98 | old-gpu 0, vulkan 0, old-gpu-2p 0 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255 / strict pixels over 2/255; the same limits as Quicksilver's runs:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| factory | 0.0 / 0 | 0.0 / 0 | 0.0169 / 0 | 0.0 / 0 |
| factory_flat | 0.0 / 0 | 0.0034 / 0 | 0.0034 / 0 | 0.0034 / 0 |
| sift | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hub | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| mam | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| ponder | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| hologram | 0.0018 / 7 | 0.0025 / 10 | skipped | 0.0025 / 10 |
| create_ct | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 | 0.0 / 0 |
| kinetics | 0.0074 / 0 | 0.0174 / 0 | 0.0086 / 0 | 0.0174 / 0 |
| kinetics_instancing | 0.0074 / 0 | 0.0081 / 0 | 0.0077 / 0 | 0.0081 / 0 |

### Counts, siftec full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 12.67 (base 12.22) | 15 (base 15) | 6004 (base 6976) | 367.21 (base 361.48) | 4.24 (against vanilla, below) |
| factory_flat | 12.67 (reported, not gated) | 15 (base 15) | 6004 (base 6844) | 360.97 (base 360.51) | 3.48 (against vanilla, below) |
| sift | 21.27 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 385.42 (base 379.72) | 4.24 (against vanilla, below) |
| hub | 21.53 (base 21.53) | 16 (base 16) | 65656 (base 66576) | 398.01 (base 392.33) | 4.24 (against vanilla, below) |
| mam | 22.53 (base 22.53) | 19 (base 19) | 22088 (base 23748) | 411.77 (base 405.55) | 8.24 (against vanilla, below) |
| ponder | 88.26 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 407.88 (base 404.14) | 8.24 (against vanilla, below) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 17 (base 17) | 43100 (base 44728) | 397.71 (base 392.95) | 8.06 (against vanilla, below) |
| create_ct | 7.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 398.93 (base 394.1) | 8.06 (against vanilla, below) |
| kinetics | 8.67 (base 8.67) | 13 (base 13) | 7692 (base 7692) | 397.48 (base 395.42) | 8.06 (against vanilla, below) |
| kinetics_instancing | 7.67 (base 7.67) | 13 (base 13) | 7792 (base 7792) | 360.61 (base 360.23) | 3.48 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-full), siftec full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 12.67 / 13 (29.94) | 106.85 / 152 (29.17) | median and average, at most vanilla |
| factory_flat | 12.67 / 13 (29.81) | 106.43 / 152 (29.58) | median and average, at most vanilla |
| sift | 21.27 / 24 (26.36) | 153.0 / 153 (15.08) | median, x 1.10 + 2 |
| hub | 21.53 / 21 (30.0) | 117.17 / 161 (28.88) | median and average, x 1.10 + 2 |
| mam | 22.53 / 22 (30.02) | 117.97 / 162 (29.21) | median, x 1.10 + 2 |
| ponder | 88.26 / 88 (30.02) | 180.57 / 227 (30.02) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.89) | 117.08 / 164 (29.94) | median, at most vanilla |
| create_ct | 7.67 / 8 (30.0) | 99.92 / 147 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 8.67 / 9 (30.01) | 101.0 / 148 (29.96) | median and average, at most vanilla |
| kinetics_instancing | 7.67 / 8 (30.01) | 100.92 / 148 (30.01) | median and average, at most vanilla |

Direct buffers against vanilla measured in the same run (measure-full), siftec full (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| factory | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.03 |
| factory_flat | 3.48 / 3.48 | 3.48 / 3.48 | 7.48 / 7.48 | 14.03 |
| sift | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.46 |
| hub | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.03 |
| mam | 8.24 / 8.24 | 8.24 / 8.24 | 12.24 / 12.24 | 16.93 |
| ponder | 8.24 / 8.24 | 8.24 / 8.24 | 12.24 / 12.24 | 17.06 |
| hologram | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 17.06 |
| create_ct | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 19.26 |
| kinetics | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 16.87 |
| kinetics_instancing | 3.48 / 3.48 | 3.48 / 3.48 | 7.48 / 7.48 | 14.03 |

Terrain GPU memory, siftec full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.885 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.342 | 32.0 / 20.342 | 0.0 / 0.0 | 416.0 / 34.092 |
| ponder | 32.0 / 17.597 | 32.0 / 17.597 | 0.0 / 0.0 | 416.0 / 29.179 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.439 (26447.679) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 2 / 7 | 0.0 / 0 |
| factory_flat | 13583.55 (26447.892) | 48.64 | 1.0 | 106932 / 183468 | 100928 (2097152.0) | 4 / 2 | 0.0 / 0 |
| sift | 115647.028 (157949.146) | 26.782 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 16 / 301 | 0.0 / 0 |
| hub | 474.789 (783.301) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 0 / 20 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 303192 / 42688 | 0 (2097152.0) | 2 / 7 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61248 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| hologram | 3670.127 (6346.595) | 42.172 | 1.0 | 45004 / 46072 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| kinetics | 5437.047 (10385.28) | 47.647 | 1.0 | 7692 / 7792 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics_instancing | 6068.114 (11697.496) | 48.125 | 1.0 | 7792 / 7792 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, siftec full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 1.943 (35) | 3.872 (35) | 0.502 | 1.91 (12) | 0 | 969 / 0 | 4.636 / 6.659 | 1.827 / 2.582 |
| factory_flat | 1.358 (68) | 1.866 (69) | 0.728 | 1.398 (13) | 0 | 597 / 0 | 1.147 / 1.058 | 0.293 / 0.279 |
| sift | 0.766 (41) | 1.399 (40) | 0.548 | None (0) | 0 | 1510 / 0 | 3.408 / 4.908 | 1.136 / 1.76 |
| hub | 0.287 (8) | 0.242 (8) | 1.186 | None (0) | 0 | 1560 / 0 | 3.366 / 4.838 | 1.115 / 1.735 |
| mam | 0.373 (4) | 0.385 (4) | 0.969 | None (0) | 0 | 1877 / 0 | 3.292 / 4.906 | 1.211 / 2.068 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1878 / 0 | 3.29 / 4.903 | 1.21 / 2.065 |
| hologram | 0.545 (25) | 1.183 (19) | 0.461 | None (0) | 0 | 1911 / 0 | 3.247 / 4.839 | 1.187 / 2.016 |
| create_ct | 0.393 (60) | 0.543 (55) | 0.724 | None (0) | 0 | 1967 / 0 | 3.181 / 4.727 | 1.143 / 1.879 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 2061 / 0 | 3.095 / 4.548 | 1.097 / 1.72 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 128 / 0 | 4.73 / 4.933 | 0.746 / 0.821 |

Terrain module, siftec full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 32.053 | 16 (vanilla 28) | 96100 | 26.502 / 0.294 | 1.511 / 28.0 | 2.566 | 2047 / 0 | 1.91 (2.175) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 32.054 | 16 (vanilla 28) | 96100 | 2.716 / 0.025 | 1.511 / 8.0 | 2.566 | 799 / 0 | 1.398 (1.493) |
| sift | indirect, one multi-draw per arena and layer | 3.006 | 320.607 | 16 (vanilla 28) | 462508 | 24.36 / 0.322 | 7.39 / 16.0 | 12.35 | 3054 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 23.752 / 0.313 | 1.879 / 12.0 | 3.137 | 3131 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1194732 | 24.283 / 0.342 | 20.342 / 32.0 | 31.903 | 3786 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1020916 | 24.283 / 0.342 | 17.597 / 32.0 | 27.261 | 3787 / 0 | None (None) |
| hologram | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 24.09 / 0.338 | 0.238 / 32.0 | 0.367 | 3851 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.664 / 0.332 | 0.171 / 32.0 | 0.283 | 3959 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 23.63 / 0.347 | 0.372 / 32.0 | 0.624 | 4071 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 27.045 | 16 (vanilla 28) | 23356 | 6.599 / 0.279 | 0.372 / 8.0 | 0.624 | 154 / 0 | None (None) |

Translucency, siftec full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 3168 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 602 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.086; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 34.0 (0.0, 0.0) | 0.004 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.002 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 4.0 (0.0, 0.0) | 0.003 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6300 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6258 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9108 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5100 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7800 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 750 / 0 |
| kinetics_instancing | still | 23.0 / 23.0 (0.0) | 23.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |

Effects, siftec full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 95.171 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.755 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 7.514 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 95.598 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 95.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.411 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 145.668 / 88.321 | 0.102 / 0.036 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.89 | 0.0 / 0.0 | 574.39 / 575.17 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.89 (8.0 / 8.0) |
| mam | 13.87 / 13.88 | 1.0 / 1.0 | 113.32 / 113.75 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.88 (8.0 / 8.0) |
| ponder | 82.59 / 82.58 | 0.11 / 0.11 | 203.86 / 203.7 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.6 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 15.93 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.53 (base 361.53) | 4.24 (against vanilla, below) |
| factory_flat | 15.97 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.97 (base 360.27) | 3.48 (against vanilla, below) |
| sift | 36.69 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.92 (base 379.69) | 4.24 (against vanilla, below) |
| hub | 20.53 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.65 (base 392.07) | 4.24 (against vanilla, below) |
| mam | 21.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 411.11 (base 404.98) | 8.24 (against vanilla, below) |
| ponder | 87.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.93 (base 403.64) | 8.24 (against vanilla, below) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42532 (base 43652) | 397.31 (base 392.54) | 8.06 (against vanilla, below) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 398.3 (base 393.74) | 8.06 (against vanilla, below) |
| kinetics | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 397.36 (base 396.01) | 8.06 (against vanilla, below) |
| kinetics_instancing | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 360.89 (base 360.95) | 3.48 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 15.93 / 16 (29.79) | 179.63 / 226 (29.78) | median and average, at most vanilla |
| factory_flat | 15.97 / 16 (29.97) | 179.08 / 226 (29.94) | median and average, at most vanilla |
| sift | 36.69 / 37 (19.51) | 579.0 / 579 (17.58) | median, x 1.10 + 2 |
| hub | 20.53 / 20 (29.94) | 162.27 / 208 (29.84) | median and average, x 1.10 + 2 |
| mam | 21.54 / 21 (29.99) | 200.25 / 246 (29.78) | median, x 1.10 + 2 |
| ponder | 87.24 / 87 (29.88) | 180.79 / 227 (29.87) | median and average, x 1.10 + 2 |
| hologram | 23.67 / 24 (29.92) | 128.16 / 175 (29.95) | median, at most vanilla |
| create_ct | 6.67 / 7 (30.0) | 110.92 / 158 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 10.67 / 11 (29.98) | 127.0 / 174 (29.98) | median and average, at most vanilla |
| kinetics_instancing | 10.67 / 11 (30.02) | 126.92 / 174 (30.0) | median and average, at most vanilla |

Direct buffers against vanilla measured in the same run (measure-old), siftec old-gpu (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| factory | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.03 |
| factory_flat | 3.48 / 3.48 | 3.48 / 3.48 | 7.48 / 7.48 | 14.03 |
| sift | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 12.66 |
| hub | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.59 |
| mam | 8.24 / 8.24 | 8.24 / 8.24 | 12.24 / 12.24 | 16.5 |
| ponder | 8.24 / 8.24 | 8.24 / 8.24 | 12.24 / 12.24 | 17.06 |
| hologram | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 16.29 |
| create_ct | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 17.06 |
| kinetics | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 16.87 |
| kinetics_instancing | 3.48 / 3.48 | 5.48 / 5.48 | 9.48 / 9.48 | 14.03 |

Terrain GPU memory, siftec old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.64 | 8.0 / 1.64 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.885 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.326 | 32.0 / 20.326 | 0.0 / 0.0 | 416.0 / 34.022 |
| ponder | 32.0 / 17.575 | 32.0 / 17.575 | 0.0 / 0.0 | 416.0 / 29.108 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.624 | 8.0 / 0.624 | 0.0 / 0.0 | 256.0 / 0.774 |


Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14352.594 (27755.245) | 48.289 | 1.0 | 149752 / 226644 | 100928 (2097152.0) | 6 / 4 | 0.0 / 0 |
| factory_flat | 14475.967 (27964.888) | 48.235 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 2 / 1 | 0.0 / 0 |
| sift | 115673.841 (158054.231) | 26.814 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 139 / 351 | 0.0 / 0 |
| hub | 474.791 (783.306) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 0 / 5 | 0.0 / 0 |
| mam | 568.947 (925.54) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 2 / 3 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 4 / 3 | 0.0 / 0 |
| hologram | 3670.117 (6346.578) | 42.172 | 1.0 | 43764 / 45028 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 2 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.052 (35) | 2.778 (35) | 1.099 | 2.457 (12) | 0 | 959 / 0 | 6.899 / 9.228 | 3.222 / 5.301 |
| factory_flat | 1.771 (69) | 1.434 (69) | 1.235 | 1.737 (14) | 0 | 609 / 0 | 2.066 / 1.83 | 0.692 / 0.504 |
| sift | 1.532 (41) | 1.263 (40) | 1.213 | None (0) | 0 | 1502 / 0 | 5.22 / 7.145 | 1.883 / 3.399 |
| hub | 0.337 (8) | 0.227 (8) | 1.485 | None (0) | 0 | 1554 / 0 | 5.151 / 7.025 | 1.859 / 3.367 |
| mam | 0.444 (4) | 0.324 (4) | 1.37 | None (0) | 0 | 1870 / 0 | 5.163 / 7.162 | 2.077 / 3.791 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1871 / 0 | 5.16 / 7.158 | 2.067 / 3.783 |
| hologram | 0.655 (19) | 0.725 (19) | 0.903 | None (0) | 0 | 1904 / 0 | 5.148 / 7.132 | 2.077 / 3.75 |
| create_ct | 0.56 (46) | 0.48 (53) | 1.167 | None (0) | 0 | 1960 / 0 | 5.041 / 6.966 | 1.981 / 3.524 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 2055 / 0 | 4.899 / 6.719 | 1.869 / 3.37 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 142 / 0 | 5.527 / 5.899 | 1.638 / 1.519 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.248 | 34.591 | 16 (vanilla 28) | 96100 | 24.835 / 0.336 | 1.511 / 28.0 | 2.566 | 1994 / 0 | 2.457 (2.809) |
| factory_flat | plain, one multi-draw per region and layer | 4.287 | 34.998 | 16 (vanilla 28) | 104260 | 2.925 / 0.037 | 1.64 / 8.0 | 2.784 | 817 / 0 | 1.737 (1.977) |
| sift | plain, one multi-draw per region and layer | 17.044 | 320.821 | 16 (vanilla 28) | 462508 | 22.96 / 0.356 | 7.39 / 16.0 | 12.35 | 3003 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.379 / 0.346 | 1.879 / 12.0 | 3.137 | 3084 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1193720 | 23.173 / 0.37 | 20.326 / 32.0 | 31.876 | 3738 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1019568 | 23.172 / 0.37 | 17.575 / 32.0 | 27.225 | 3739 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.025 / 0.365 | 0.238 / 32.0 | 0.367 | 3797 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.66 / 0.359 | 0.171 / 32.0 | 0.283 | 3894 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.642 / 0.375 | 0.372 / 32.0 | 0.624 | 4007 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 39584 | 6.125 / 0.282 | 0.624 / 8.0 | 1.057 | 165 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2346 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.53 / 69.0 (57.2) | 29.53 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 289.45 | 6006 / 0 |
| factory_flat | still | 29.94 / 69.0 (56.6) | 29.94 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 336.0 | 5964 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6693 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5066 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7800 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.96 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 9.718 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 141.025 / 85.303 | 0.12 / 0.039 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.32 / 574.69 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.87 / 13.85 | 1.0 / 1.0 | 113.48 / 112.72 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.85 (8.0 / 8.0) |
| ponder | 82.57 / 82.56 | 0.11 / 0.11 | 203.78 / 203.53 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / 81.58 (75.0 / 75.0) |
| hologram | 16.0 / 16.0 | 0.0 / 0.0 | 163.0 / 163.0 | 5.0 / 5.0 (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / 16.0 (5.0 / 5.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 13.7 (base 14.25) | 15 (base 15) | 50660 (base 51624) | 365.37 (base 360.8) | 5.98 (against vanilla, below) |
| factory_flat | 13.7 (reported, not gated) | 15 (base 15) | 50660 (base 51500) | 360.33 (base 359.9) | 3.46 (against vanilla, below) |
| sift | 23.0 (base 23.0) | 18 (base 19) | 17012 (base 81788) | 383.75 (base 379.18) | 5.98 (against vanilla, below) |
| hub | 20.54 (base 21.57) | 16 (base 16) | 65656 (base 66576) | 396.61 (base 391.05) | 5.98 (against vanilla, below) |
| mam | 21.54 (base 22.55) | 19 (base 19) | 22088 (base 23748) | 409.91 (base 404.61) | 5.98 (against vanilla, below) |
| ponder | 87.26 (base 87.24) | 14 (base 14) | 52268 (base 52268) | 408.97 (base 403.47) | 5.98 (against vanilla, below) |
| hologram | skipped (Mesa's lavapipe Vulkan driver segfaults drawing Create's outliner (the hologram), in vanilla's run too) | | | | |
| create_ct | 6.67 (base 6.67) | 12 (base 12) | 1596 (base 1596) | 399.42 (base 395.99) | 5.79 (against vanilla, below) |
| kinetics | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 398.4 (base 398.76) | 5.79 (against vanilla, below) |
| kinetics_instancing | 8.67 (base 8.67) | 13 (base 13) | 253764 (base 253764) | 358.33 (base 359.57) | 3.46 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-vk), siftec vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 13.7 / 14 (29.38) | 108.2 / 154 (29.44) | median and average, at most vanilla |
| factory_flat | 13.7 / 14 (29.41) | 108.04 / 154 (29.45) | median and average, at most vanilla |
| sift | 23.0 / 23 (17.33) | 135.7 / 153 (22.03) | median, x 1.10 + 2 |
| hub | 20.54 / 20 (29.49) | 116.15 / 161 (29.41) | median and average, x 1.10 + 2 |
| mam | 21.54 / 21 (29.48) | 117.45 / 162 (29.31) | median, x 1.10 + 2 |
| ponder | 87.26 / 87 (29.56) | 181.8 / 227 (29.54) | median and average, x 1.10 + 2 |
| create_ct | 6.67 / 7 (29.92) | 101.11 / 147 (29.64) | median and average, x 1.10 + 2 |
| kinetics | 8.67 / 9 (29.72) | 102.95 / 149 (29.59) | median and average, at most vanilla |
| kinetics_instancing | 8.67 / 9 (29.95) | 103.27 / 149 (29.62) | median and average, at most vanilla |

Direct buffers against vanilla measured in the same run (measure-vk), siftec vulkan (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| factory | 5.98 / 5.98 | 5.98 / 5.98 | 9.98 / 9.98 | 14.01 |
| factory_flat | 3.46 / 3.46 | 5.46 / 5.46 | 9.46 / 9.46 | 11.81 |
| sift | 5.98 / 5.98 | 5.98 / 5.98 | 9.98 / 9.98 | 14.01 |
| hub | 5.98 / 5.98 | 5.98 / 5.98 | 9.98 / 9.98 | 14.01 |
| mam | 5.98 / 5.98 | 5.98 / 5.98 | 9.98 / 9.98 | 16.48 |
| ponder | 5.98 / 5.98 | 5.98 / 5.98 | 9.98 / 9.98 | 17.05 |
| create_ct | 5.79 / 5.79 | 5.79 / 5.79 | 9.79 / 9.79 | 17.12 |
| kinetics | 5.79 / 5.79 | 5.79 / 5.79 | 9.79 / 9.79 | 16.84 |
| kinetics_instancing | 3.46 / 3.46 | 5.46 / 5.46 | 9.46 / 9.46 | 14.01 |

Terrain GPU memory, siftec vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.913 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 20.35 | 32.0 / 20.35 | 0.0 / 0.0 | 416.0 / 33.961 |
| ponder | 32.0 / 17.604 | 32.0 / 17.604 | 0.0 / 0.0 | 416.0 / 29.058 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.372 | 8.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |


Package 4b, siftec vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14625.029 (28218.467) | 48.172 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 12 / 10 | 0.0 / 0 |
| factory_flat | 14707.694 (28358.92) | 48.137 | 1.0 | 152428 / 228124 | 100928 (2097152.0) | 11 / 11 | 0.0 / 0 |
| sift | 115761.607 (158105.636) | 26.782 | 1.4 | 17012 / 16632 | 0 (2097152.0) | 345 / 50 | 0.0 / 0 |
| hub | 474.805 (783.328) | 39.386 | 1.0 | 84616 / 85516 | 0 (2097152.0) | 8 / 13 | 0.0 / 0 |
| mam | 568.963 (925.566) | 38.528 | 1.25 | 41048 / 42688 | 0 (2097152.0) | 22 / 29 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61244 / 61224 | 0 (2097152.0) | 8 / 10 | 0.0 / 0 |
| create_ct | 2538.237 (5312.87) | 52.225 | 1.0 | 1596 / 1596 | 0 (2097152.0) | 0 / 8 | 0.0 / 0 |
| kinetics | 5437.123 (10385.425) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 3 / 7 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 253764 / 253864 | 0 (2097152.0) | 0 / 6 | 0.0 / 0 |

Package 4c, siftec vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 2.452 (35) | 1.74 (35) | 1.409 | 2.342 (12) | 0 | 843 / 0 | 6.331 / 8.382 | 2.83 / 4.549 |
| factory_flat | 1.63 (41) | 0.939 (35) | 1.736 | 1.589 (13) | 0 | 575 / 0 | 1.674 / 1.707 | 0.443 / 0.413 |
| sift | 1.055 (41) | 0.755 (41) | 1.397 | None (0) | 0 | 1386 / 0 | 4.739 / 6.387 | 1.81 / 2.89 |
| hub | 0.311 (8) | 0.225 (8) | 1.382 | None (0) | 0 | 1437 / 0 | 4.669 / 6.251 | 1.782 / 2.797 |
| mam | 0.442 (4) | 0.21 (4) | 2.105 | None (0) | 0 | 1753 / 0 | 4.687 / 6.583 | 1.969 / 3.429 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1754 / 0 | 4.685 / 6.579 | 1.969 / 3.427 |
| create_ct | 0.609 (55) | 0.402 (60) | 1.515 | None (0) | 0 | 1810 / 0 | 4.581 / 6.442 | 1.874 / 3.227 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 1905 / 0 | 4.438 / 6.188 | 1.779 / 2.942 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 145 / 0 | 5.506 / 5.814 | 2.155 / 1.715 |

Terrain module, siftec vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | indirect, one multi-draw per arena and layer | 2.003 | 35.489 | 16 (vanilla 28) | 96100 | 25.304 / 0.326 | 1.511 / 28.0 | 2.566 | 1742 / 0 | 2.342 (2.86) |
| factory_flat | indirect, one multi-draw per arena and layer | 2.003 | 35.762 | 16 (vanilla 28) | 96084 | 2.357 / 0.033 | 1.511 / 8.0 | 2.566 | 701 / 0 | 1.589 (1.936) |
| sift | indirect, one multi-draw per arena and layer | 3.009 | 320.925 | 16 (vanilla 28) | 462508 | 23.216 / 0.35 | 7.39 / 16.0 | 12.35 | 2751 / 0 | None (None) |
| hub | indirect, one multi-draw per arena and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.593 / 0.339 | 1.879 / 12.0 | 3.137 | 2830 / 0 | None (None) |
| mam | indirect, one multi-draw per arena and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1195248 | 23.373 / 0.365 | 20.35 / 32.0 | 31.917 | 3484 / 0 | None (None) |
| ponder | indirect, one multi-draw per arena and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1021432 | 23.373 / 0.365 | 17.604 / 32.0 | 27.275 | 3485 / 0 | None (None) |
| create_ct | indirect, one multi-draw per arena and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.945 / 0.358 | 0.171 / 32.0 | 0.283 | 3588 / 0 | None (None) |
| kinetics | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 22.92 / 0.375 | 0.372 / 32.0 | 0.624 | 3701 / 0 | None (None) |
| kinetics_instancing | indirect, one multi-draw per arena and layer | 2.003 | 22.037 | 16 (vanilla 28) | 23356 | 5.74 / 0.189 | 0.372 / 8.0 | 0.624 | 188 / 0 | None (None) |

Translucency, siftec vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2082 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 590 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 591 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.008; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 30.43 / 69.0 (55.9) | 30.43 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 293.88 | 5670 / 0 |
| factory_flat | still | 30.7 / 69.0 (55.5) | 30.7 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 317.29 | 5628 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6003 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5032 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7696 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 740 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 94.524 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 94.363 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 122.818 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 94.601 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 94.923 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 94.518 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| create_ct | 94.435 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 94.281 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 94.595 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.87 / 13.87 | 0.0 / 0.0 | 574.72 / 574.61 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / 13.87 (8.0 / 8.0) |
| mam | 13.87 / 13.85 | 1.0 / 1.0 | 113.4 / 112.43 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.85 (8.0 / 8.0) |
| ponder | 82.59 / 82.6 | 0.11 / 0.11 | 203.76 / 204.0 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.63 (75.0 / 75.0) |
| create_ct | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |
| kinetics_instancing | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / 0.0 (0.0 / 0.0) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.69 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.8 (base 361.53) | 4.24 (against vanilla, below) |
| factory_flat | 16.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.62 (base 360.27) | 3.48 (against vanilla, below) |
| sift | 38.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.96 (base 379.69) | 4.24 (against vanilla, below) |
| hub | 21.56 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.37 (base 392.07) | 4.24 (against vanilla, below) |
| mam | 22.54 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.53 (base 404.98) | 8.24 (against vanilla, below) |
| ponder | 88.25 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.28 (base 403.64) | 8.24 (against vanilla, below) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43672 (base 43652) | 396.91 (base 392.54) | 8.06 (against vanilla, below) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.69 (base 393.74) | 8.06 (against vanilla, below) |
| kinetics | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.83 (base 396.01) | 8.06 (against vanilla, below) |
| kinetics_instancing | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 359.67 (base 360.95) | 3.48 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-old), siftec old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| factory | 16.69 / 17 (28.74) | 179.63 / 226 (29.78) | median and average, at most vanilla |
| factory_flat | 16.67 / 17 (29.74) | 179.08 / 226 (29.94) | median and average, at most vanilla |
| sift | 38.0 / 38 (15.22) | 579.0 / 579 (17.58) | median, x 1.10 + 2 |
| hub | 21.56 / 21 (29.31) | 162.27 / 208 (29.84) | median and average, x 1.10 + 2 |
| mam | 22.54 / 22 (29.48) | 200.25 / 246 (29.78) | median, x 1.10 + 2 |
| ponder | 88.25 / 88 (29.93) | 180.79 / 227 (29.87) | median and average, x 1.10 + 2 |
| hologram | 24.67 / 25 (29.69) | 128.16 / 175 (29.95) | median, at most vanilla |
| create_ct | 7.67 / 8 (29.99) | 110.92 / 158 (30.0) | median and average, x 1.10 + 2 |
| kinetics | 11.67 / 12 (29.93) | 127.0 / 174 (29.98) | median and average, at most vanilla |
| kinetics_instancing | 11.67 / 12 (30.0) | 126.92 / 174 (30.0) | median and average, at most vanilla |

Direct buffers against vanilla measured in the same run (measure-old), siftec old-gpu-2p (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool):

| scene | Quicksilver end / peak | vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|
| factory | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.03 |
| factory_flat | 3.48 / 3.48 | 3.48 / 3.48 | 7.48 / 7.48 | 14.03 |
| sift | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 12.66 |
| hub | 4.24 / 4.24 | 4.24 / 4.24 | 8.24 / 8.24 | 14.59 |
| mam | 8.24 / 8.24 | 8.24 / 8.24 | 12.24 / 12.24 | 16.5 |
| ponder | 8.24 / 8.24 | 8.24 / 8.24 | 12.24 / 12.24 | 17.06 |
| hologram | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 16.29 |
| create_ct | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 17.06 |
| kinetics | 8.06 / 8.06 | 8.06 / 8.06 | 12.06 / 12.06 | 16.87 |
| kinetics_instancing | 3.48 / 3.48 | 5.48 / 5.48 | 9.48 / 9.48 | 14.03 |

Terrain GPU memory, siftec old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| factory | 28.0 / 1.511 | 28.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| factory_flat | 8.0 / 1.511 | 8.0 / 1.511 | 0.0 / 0.0 | 256.0 / 2.723 |
| sift | 16.0 / 7.39 | 16.0 / 7.39 | 0.0 / 0.0 | 416.0 / 12.885 |
| hub | 12.0 / 1.879 | 12.0 / 1.879 | 0.0 / 0.0 | 416.0 / 3.276 |
| mam | 32.0 / 19.822 | 32.0 / 19.822 | 0.0 / 0.0 | 416.0 / 34.022 |
| ponder | 32.0 / 17.211 | 32.0 / 17.211 | 0.0 / 0.0 | 416.0 / 29.108 |
| hologram | 32.0 / 0.238 | 32.0 / 0.238 | 0.0 / 0.0 | 288.0 / 0.388 |
| create_ct | 32.0 / 0.171 | 32.0 / 0.171 | 0.0 / 0.0 | 416.0 / 0.294 |
| kinetics | 32.0 / 0.372 | 32.0 / 0.372 | 0.0 / 0.0 | 256.0 / 0.657 |
| kinetics_instancing | 8.0 / 0.683 | 8.0 / 0.683 | 0.0 / 0.0 | 256.0 / 0.774 |


Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13584.415 (26449.578) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 20 / 4 | 0.0 / 0 |
| factory_flat | 13583.563 (26447.919) | 48.64 | 1.0 | 149844 / 226644 | 100928 (2097152.0) | 0 / 1 | 0.0 / 0 |
| sift | 115757.533 (158168.586) | 26.814 | 1.431 | 4148 / 8052 | 0 (2097152.0) | 304 / 351 | 0.0 / 0 |
| hub | 474.809 (783.334) | 39.386 | 1.0 | 83908 / 84516 | 0 (2097152.0) | 12 / 5 | 0.0 / 0 |
| mam | 568.963 (925.566) | 38.528 | 1.25 | 40068 / 40948 | 0 (2097152.0) | 11 / 3 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 / 61204 | 0 (2097152.0) | 2 / 3 | 0.0 / 0 |
| hologram | 3670.168 (6346.667) | 42.172 | 1.0 | 45668 / 45028 | 0 (2097152.0) | 3 / 1 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 / 1316 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |
| kinetics | 5437.077 (10385.338) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 3 / 2 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 / 253324 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| factory | 3.775 (35) | 2.778 (35) | 1.359 | 3.726 (12) | 0 | 950 / 0 | 9.995 / 12.727 | 6.027 / 8.264 |
| factory_flat | 2.056 (68) | 1.434 (69) | 1.434 | 1.934 (13) | 0 | 613 / 0 | 2.517 / 2.354 | 0.948 / 0.718 |
| sift | 1.186 (41) | 1.263 (40) | 0.939 | None (0) | 0 | 1493 / 0 | 7.723 / 10.068 | 3.898 / 5.972 |
| hub | 0.5 (8) | 0.227 (8) | 2.203 | None (0) | 0 | 1551 / 0 | 7.603 / 9.955 | 3.734 / 5.903 |
| mam | 0.589 (4) | 0.324 (4) | 1.818 | None (0) | 0 | 1856 / 0 | 7.343 / 9.992 | 3.952 / 6.214 |
| ponder | None (0) | None (0) | None | None (0) | 0 | 1857 / 0 | 7.34 / 9.987 | 3.94 / 6.213 |
| hologram | 1.872 (19) | 0.725 (19) | 2.582 | None (0) | 0 | 1884 / 0 | 7.295 / 9.875 | 3.858 / 6.119 |
| create_ct | 0.848 (55) | 0.48 (53) | 1.767 | None (0) | 0 | 1940 / 0 | 7.144 / 9.653 | 3.639 / 5.814 |
| kinetics | None (0) | None (0) | None | None (0) | 0 | 2035 / 0 | 6.929 / 9.278 | 3.418 / 5.446 |
| kinetics_instancing | None (0) | None (0) | None | None (0) | 0 | 151 / 0 | 7.289 / 7.518 | 3.018 / 2.291 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.056 | 16 (vanilla 28) | 96100 | 25.216 / 0.341 | 1.511 / 28.0 | 2.566 | 2001 / 0 | 3.726 (6.882) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 2.8 / 0.024 | 1.511 / 8.0 | 2.566 | 831 / 0 | 1.934 (2.237) |
| sift | plain, one multi-draw per region and layer | 17.056 | 321.053 | 16 (vanilla 28) | 462508 | 23.278 / 0.36 | 7.39 / 16.0 | 12.35 | 3010 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.009 | 16 (vanilla 28) | 117492 | 22.556 / 0.347 | 1.879 / 12.0 | 3.137 | 3102 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1164152 | 23.341 / 0.369 | 19.822 / 32.0 | 31.086 | 3730 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 998356 | 23.341 / 0.369 | 17.211 / 32.0 | 26.659 | 3731 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.195 / 0.364 | 0.238 / 32.0 | 0.367 | 3789 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.796 / 0.358 | 0.171 / 32.0 | 0.283 | 3892 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.776 / 0.373 | 0.372 / 32.0 | 0.624 | 4005 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 43060 | 6.102 / 0.31 | 0.683 / 8.0 | 1.15 | 169 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1830 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 587 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 591 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2380 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.039; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.09; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6048 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6258 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5244 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4964 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7644 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 745 / 0 |
| kinetics_instancing | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | 93.96 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | 93.411 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | 140.0 / 10.0 | 0.0 / 0.0 | 4.0 / 4.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | 93.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | 93.725 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | 93.568 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | 93.489 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 155.511 / 96.489 | 0.141 / 0.044 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | 93.333 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | 93.255 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| factory_flat | 5.0 / 5.0 | 0.0 / 0.0 | 21.0 / 21.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| sift | 5.0 / 5.0 | 0.0 / 0.0 | 20.0 / 20.0 | 3.0 / 3.0 (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / 5.0 (3.0 / 3.0) |
| hub | 13.89 / 13.87 | 0.0 / 0.0 | 575.33 / 574.69 | 6.0 / 6.0 (pipelines 6.0, textures 5.0, scissors 1.0) | 13.89 / 13.87 (8.0 / 8.0) |
| mam | 13.87 / 13.85 | 1.0 / 1.0 | 113.11 / 112.72 | 7.0 / 7.0 (pipelines 6.0, textures 6.0, scissors 1.0) | 13.87 / 13.85 (8.0 / 8.0) |
| ponder | 82.58 / 82.56 | 0.11 / 0.11 | 203.94 / 203.53 | 73.0 / 73.0 (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / 81.58 (75.0 / 75.0) |
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
| quicksilver-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | 24 | 601 / 600 |
| quicksilver-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| quicksilver-vk | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 595 |
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 598 |
| measure-full | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| measure-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |
| measure-vk | flywheel:off, flywheel:off, flywheel:off | - | - / - |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 14.33 | 101.12 | 286 | 123 | 795940 | [] |
| bench-plain | flythrough | 9.66 | 250.6 | 193 | 123 | 7660636 | [] |
| bench-plain | water_glass | 23.98 | 57.38 | 16 | 124 | 17744 | [] |
| bench-plain | nether | 23.93 | 52.24 | 14 | 121 | 316272 | [] |
| bench-sodium | spawn | 13.54 | 94.16 | 270 | 147 | 2096 | [] |
| bench-sodium | flythrough | 9.11 | 280.99 | 182 | 159 | 268492 | [] |
| bench-sodium | water_glass | 24.35 | 56.41 | 13 | 135 | 8668 | [] |
| bench-sodium | nether | 29.57 | 43.64 | 0 | 129 | 263796 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 50.968 (50.0) | 767 / 767 | 1738 | 1 | 40445.163 | 12.15 (0.0) | 1300 |

## Direct buffers per scene (gated against the same-run measure run and the ceiling, see the counts)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
| core-bench-plain | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-plain | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-bench-sodium | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-sodium | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-bench-sodium | nether | 3.87 | 3.87 (0) | 3.87 |  |
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
| core-measure-full | block_entities | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-full | flat_plants | 3.34 | 3.34 (0) | 3.34 |  |
| core-measure-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-full | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | block_entities | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-measure-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-vk | spawn | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | water_glass | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | nether | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | mobs | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | outline | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | occlusion_corner | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | translucent_move | 8.23 | 8.23 (0) | 8.23 | between scenes +4.00 |
| core-measure-vk | particles | 8.23 | 8.23 (0) | 8.23 |  |
| core-measure-vk | animation | 8.23 | 8.23 (0) | 8.23 |  |
| core-measure-vk | animated_items | 8.23 | 8.23 (0) | 8.23 |  |
| core-measure-vk | block_entities | 8.23 | 8.23 (0) | 8.23 |  |
| core-measure-vk | flat_plants | 3.32 | 3.32 (0) | 3.32 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | water_glass_oit | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | translucent_move_oit | 3.71 | 3.71 (0) | 3.71 |  |
| core-measure-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-quicksilver-2p-old | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | block_entities | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-2p-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | block_entities | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-full | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-full | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-full | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | spawn | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | water_glass | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | nether | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | mobs | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | outline | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | occlusion | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | occlusion_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | occlusion_corner | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | translucent_move | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | particles | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | animation | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | animated_items | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | block_entities | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-old | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.46 | 3.73 (196) | 3.73 |  |
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
| core-quicksilver-vk | block_entities | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | flat_plants | 3.45 | 3.45 (0) | 3.45 |  |
| core-quicksilver-vk | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-vk | water_glass_oit | 5.34 | 5.34 (0) | 5.34 |  |
| core-quicksilver-vk | translucent_move_oit | 5.46 | 5.46 (0) | 5.46 |  |
| core-quicksilver-vk | flythrough | 3.71 | 3.71 (0) | 3.71 |  |
| core-sp-quicksilver | flythrough | 1.38 | 1.39 (88) | 1.39 |  |
| siftec-measure-full | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-measure-full | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-measure-full | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-measure-full | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-measure-full | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-measure-full | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
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
| siftec-measure-vk | factory | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | sift | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | hub | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | mam | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | ponder | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-measure-vk | create_ct | 5.79 | 5.79 (0) | 5.79 |  |
| siftec-measure-vk | kinetics | 5.79 | 5.79 (0) | 5.79 |  |
| siftec-measure-vk | factory_flat | 5.46 | 5.46 (0) | 5.46 |  |
| siftec-measure-vk | kinetics_instancing | 5.46 | 5.46 (0) | 5.46 |  |
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
| siftec-quicksilver-vk | factory | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | sift | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | hub | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | mam | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | ponder | 5.98 | 5.98 (0) | 5.98 |  |
| siftec-quicksilver-vk | create_ct | 5.79 | 5.79 (0) | 5.79 |  |
| siftec-quicksilver-vk | kinetics | 5.79 | 5.79 (0) | 5.79 |  |
| siftec-quicksilver-vk | factory_flat | 3.46 | 3.46 (0) | 3.46 |  |
| siftec-quicksilver-vk | kinetics_instancing | 3.46 | 3.46 (0) | 3.46 |  |

Rises of 4 MB or more: core-measure-vk/translucent_move: between scenes +4.00; siftec-measure-full/mam: between scenes +4.00; siftec-measure-old/mam: between scenes +4.00; siftec-quicksilver-2p-old/mam: between scenes +4.00; siftec-quicksilver-full/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00

