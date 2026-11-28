# Quicksilver CI comparison

**passed**

## Suite core

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
- vanilla-vk: backend `Vulkan` drivers `1.4.335 llvmpipe Mesa 26.0.8-1ubuntu0.3 (LLVM 21.1.8)`
- quicksilver-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="Mesa 26.0.8-1ubuntu0.3" gl=4.5 backend=OpenGL os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="Mesa 26.0.8-1ubuntu0.3" gl=3.3 backend=OpenGL os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- quicksilver-vk: backend `Vulkan` drivers `1.4.335 llvmpipe Mesa 26.0.8-1ubuntu0.3 (LLVM 21.1.8)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="1.4.335 llvmpipe Mesa 26.0.8-1ubuntu0.3 (LLVM 21.1.8)" gl=n/a backend=Vulkan os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="Mesa 26.0.8-1ubuntu0.3" gl=3.3 backend=OpenGL os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-full: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="Mesa 26.0.8-1ubuntu0.3" gl=4.5 backend=OpenGL os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=yes GL_ARB_buffer_storage=yes deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`
- measure-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 26.0.8-1ubuntu0.3`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="Mesa 26.0.8-1ubuntu0.3" gl=3.3 backend=OpenGL os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- measure-vk: backend `Vulkan` drivers `1.4.335 llvmpipe Mesa 26.0.8-1ubuntu0.3 (LLVM 21.1.8)`
  - probe: `gpuVendor="0x10005" renderer="llvmpipe (LLVM 21.1.8, 256 bits)" driver="1.4.335 llvmpipe Mesa 26.0.8-1ubuntu0.3 (LLVM 21.1.8)" gl=n/a backend=Vulkan os="Linux 7.0.0-1020-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=n/a GL_ARB_buffer_storage=n/a deviceType=CPU vanilla.multiDrawIndirect=yes vanilla.persistentMapping=yes vanilla.mdiKnownIssues=no`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- full: 0 / 0
- old-gpu: 0 / 0
- vulkan: 0 / 0
- old-gpu-2p: 0 / 0

Picture (package L): % of pixels over 8/255 against the profile's vanilla run. A Quicksilver run fails over the shot's approximation limit (ci/approx-limits.json), a measure run (vanilla stand-in) over its noise limit (ci/pixel-limits.json).

| scene | noise (vanilla a/b) % | noise limit % | approximation limit % | full % | old-GPU % | Vulkan % | old-GPU two-phase % |
|---|---|---|---|---|---|---|---|
| spawn | 0.2394 | 0.9 | 0.89 | 0.3043 | 0.4406 | 0.21 | 0.0563 |
| flythrough | 0.0 | 0.3 | 0.003 | 0.0012 | 0.0011 | 0.0012 | 0.0011 |
| water_glass | 0.0035 | 0.3 | 0.012 | 0.0036 | 0.0038 | 0.0046 | 0.0047 |
| nether | 0.0023 | 0.3 | 0.0715 | 0.0026 | 0.0003 | 0.0025 | 0.0003 |
| mobs | 0.0 | 0.4 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| mobs.far | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| outline | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.002 | 0.0009 | 0.0009 | 0.0009 | 0.0009 |
| occlusion_move.open | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.closed | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2300 | 0.0 | 0.3 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2297 | 0.0 | 0.3 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2305 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2309 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_open | 0.0 | 0.3 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2944 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2930 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2916 | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| translucent_move | 0.0 | 0.3 | 0.001 | 0.0 | 0.0002 | 0.0002 | 0.0001 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.001 | 0.0005 | 0.0002 | 0.0005 | 0.0002 |
| translucent_move.x2414 | 0.0002 | 0.3 | 0.001 | 0.0004 | 0.0002 | 0.0001 | 0.0002 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.001 | 0.0002 | 0.0003 | 0.0002 | 0.0002 |
| translucent_move.low | 0.0005 | 0.3 | 0.004 | 0.0011 | 0.0018 | 0.0012 | 0.0015 |
| translucent_move.back | 0.0001 | 0.3 | 0.001 | 0.0 | 0.0001 | 0.0001 | 0.0001 |
| translucent_move.bare_back | 0.0002 | 0.3 | 0.001 | 0.0 | 0.0002 | 0.0001 | 0.0002 |
| water_glass_oit | 0.0036 | 0.3 | 0.012 | 0.0051 | 0.0033 | 0.0044 | 0.0034 |
| translucent_move_oit | 0.0 | 0.3 | 0.001 | 0.0002 | 0.0001 | 0.0001 | 0.0002 |
| translucent_move_oit.x2404 | 0.0002 | 0.3 | 0.002 | 0.0007 | 0.0003 | 0.0003 | 0.0007 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.001 | 0.0001 | 0.0005 | 0.0002 | 0.0002 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.001 | 0.0002 | 0.0002 | 0.0003 | 0.0001 |
| translucent_move_oit.low | 0.0003 | 0.3 | 0.004 | 0.001 | 0.0012 | 0.0013 | 0.0009 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.001 | 0.0003 | 0.0 | 0.0002 | 0.0 |
| translucent_move_oit.bare_back | 0.0003 | 0.3 | 0.001 | 0.0004 | 0.0001 | 0.0 | 0.0 |
| flat_plants | 0.0 | 0.3 | 0.046 | 0.0186 | 0.0186 | 0.0188 | 0.0186 |
| renderer_off | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0008 | 0.0 | 0.0 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0008 | 0.0 | 0.0 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.001 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.001 | 0.0001 | 0.0001 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |
| block_entities | 0.0072 | 0.3 | 0.049 | 0.01 | 0.0139 | 0.0148 | 0.012 |
| block_entities.chest_open | 0.0082 | 0.3 | 0.0455 | 0.0137 | 0.0154 | 0.0091 | 0.0092 |
| block_entities.sign_edit | 0.0101 | 0.3 | 0.0515 | 0.009 | 0.0186 | 0.0189 | 0.0209 |
| block_entities.closed | 0.0037 | 0.3 | 0.049 | 0.0149 | 0.0114 | 0.01 | 0.0217 |
| lights | 0.0 | 0.25 | 0.001 | 0.0 | 0.0 | 0.0 | 0.0 |

Strict picture (reported only): pixels where all four vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all):

| scene | vanilla runs agree on % of pixels | full | old-GPU | Vulkan | old-GPU two-phase |
|---|---|---|---|---|---|
| spawn | 92.69 | 319 (860) | 336 (832) | 367 (916) | 241 (724) |
| flythrough | 97.3 | 48 (305) | 47 (304) | 50 (302) | 47 (304) |
| water_glass | 95.8 | 15 (2691) | 17 (2693) | 17 (2774) | 23 (2698) |
| nether | 99.42 | 3 (454) | 3 (454) | 3 (466) | 3 (454) |
| mobs | 99.39 | 1 (1) | 0 (0) | 2 (2) | 0 (0) |
| mobs.far | 99.83 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| outline | 98.18 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| outline.bare | 98.19 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion | 97.77 | 0 (55) | 0 (55) | 0 (55) | 0 (55) |
| occlusion_move | 99.16 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2297 | 98.95 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2305 | 98.98 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.x2309 | 99.15 | 8 (8) | 8 (8) | 8 (8) | 8 (8) |
| occlusion_move.open | 98.56 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.closed | 98.93 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2300 | 98.9 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2297 | 98.93 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2305 | 98.97 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_x2309 | 99.12 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_move.bare_open | 98.51 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner | 95.88 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner.x-2944 | 95.56 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner.x-2930 | 93.71 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| occlusion_corner.x-2916 | 94.0 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| translucent_move | 96.92 | 1 (77) | 3 (79) | 1 (69) | 2 (78) |
| translucent_move.x2404 | 95.93 | 6 (99) | 4 (97) | 6 (87) | 3 (96) |
| translucent_move.x2414 | 95.86 | 2 (89) | 1 (88) | 2 (86) | 1 (88) |
| translucent_move.x2424 | 96.74 | 2 (69) | 2 (69) | 1 (62) | 3 (70) |
| translucent_move.low | 96.12 | 13 (19) | 16 (22) | 17 (19) | 16 (22) |
| translucent_move.back | 96.92 | 2 (78) | 1 (78) | 2 (70) | 3 (80) |
| translucent_move.bare_back | 96.89 | 1 (77) | 3 (80) | 1 (69) | 1 (77) |
| water_glass_oit | 95.8 | 26 (2703) | 19 (2698) | 20 (2779) | 18 (2697) |
| translucent_move_oit | 96.92 | 3 (79) | 2 (78) | 2 (70) | 5 (81) |
| translucent_move_oit.x2404 | 95.93 | 3 (96) | 4 (97) | 4 (85) | 6 (99) |
| translucent_move_oit.x2414 | 95.86 | 1 (88) | 4 (91) | 1 (86) | 2 (89) |
| translucent_move_oit.x2424 | 96.74 | 1 (69) | 2 (69) | 2 (64) | 2 (69) |
| translucent_move_oit.low | 96.12 | 15 (21) | 15 (20) | 17 (19) | 12 (17) |
| translucent_move_oit.back | 96.92 | 3 (79) | 1 (77) | 2 (70) | 1 (77) |
| translucent_move_oit.bare_back | 96.89 | 3 (79) | 2 (78) | 1 (69) | 1 (77) |
| flat_plants | 98.22 | 185 (7374) | 185 (7374) | 180 (7293) | 185 (7374) |
| renderer_off | 99.2 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| particles | 99.99 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| particles.bare | 99.99 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| animation | 99.63 | 1 (3) | 1 (3) | 1 (3) | 1 (3) |
| animation.behind | 99.74 | 0 (2) | 0 (2) | 0 (1) | 0 (2) |
| animation.front | 99.63 | 1 (3) | 1 (3) | 1 (3) | 1 (3) |
| animated_items | 98.9 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |
| block_entities | 98.24 | 39 (823) | 59 (843) | 129 (934) | 43 (827) |
| block_entities.chest_open | 98.3 | 111 (895) | 130 (914) | 65 (870) | 73 (857) |
| block_entities.sign_edit | 98.27 | 11 (798) | 51 (838) | 28 (836) | 73 (860) |
| block_entities.closed | 98.25 | 108 (895) | 104 (891) | 39 (847) | 198 (985) |
| lights | 98.89 | 0 (0) | 0 (0) | 0 (0) | 0 (0) |

Far entity LOD (on) against its stored references, % of pixels over 8/255; last column: against vanilla's picture of the same view (LOD off), reported only:

| shot | profile | reference % | limit % | vanilla % |
|---|---|---|---|---|
| mobs.far_lod | full | 0.0 | 0.25 | 0.0 |
| mobs.far_lod | old-GPU | 0.0 | 0.25 | 0.0 |
| mobs.far_lod | Vulkan | 0.0014 | 0.25 | 0.0 |
| mobs.far_lod | old-GPU two-phase | 0.0 | 0.25 | 0.0 |

Dynamic lights (on) against their stored references, % of pixels over 8/255; last column: against the same run's unlit shot of the view (at least 0.5%):

| shot | profile | reference % | limit % | unlit % |
|---|---|---|---|---|
| lights.all_fast | full | 0.0 | 0.001 | 71.1816 |
| lights.all_fast | old-GPU | 0.0 | 0.001 | 71.1816 |
| lights.all_fast | Vulkan | 0.0001 | 0.001 | 71.181 |
| lights.all_fast | old-GPU two-phase | 0.0 | 0.001 | 71.1816 |
| lights.all_fancy | full | 0.0 | 0.001 | 75.2899 |
| lights.all_fancy | old-GPU | 0.0 | 0.001 | 75.2899 |
| lights.all_fancy | Vulkan | 0.0002 | 0.001 | 75.2892 |
| lights.all_fancy | old-GPU two-phase | 0.0 | 0.001 | 75.2899 |
| lights.torch | full | 0.0 | 0.001 | 48.2387 |
| lights.torch | old-GPU | 0.0 | 0.001 | 48.2387 |
| lights.torch | Vulkan | 0.0001 | 0.001 | 48.2389 |
| lights.torch | old-GPU two-phase | 0.0 | 0.001 | 48.2387 |
| lights.mob | full | 0.0 | 0.001 | 56.0066 |
| lights.mob | old-GPU | 0.0 | 0.001 | 56.0066 |
| lights.mob | Vulkan | 0.0 | 0.001 | 56.0069 |
| lights.mob | old-GPU two-phase | 0.0 | 0.001 | 56.0066 |
| lights.lantern | full | 0.0 | 0.001 | 50.4322 |
| lights.lantern | old-GPU | 0.0 | 0.001 | 50.4322 |
| lights.lantern | Vulkan | 0.0 | 0.001 | 50.432 |
| lights.lantern | old-GPU two-phase | 0.0 | 0.001 | 50.4322 |
| lights.arrow | full | 0.0 | 0.001 | 24.6267 |
| lights.arrow | old-GPU | 0.0 | 0.001 | 24.6267 |
| lights.arrow | Vulkan | 0.0 | 0.001 | 24.6285 |
| lights.arrow | old-GPU two-phase | 0.0 | 0.001 | 24.6267 |

Pixel art look against its stored references, % of pixels over 8/255; then against the scene's Normal shot (at least 5.0% for <scene>.pixel); outline check (spawn.pixel_outline): dark pixels on the flat floor (at most 0) / outline pixels around the block of its box's perimeter (at least 0.5x):

| shot | profile | reference % | limit % | Normal % | outline |
|---|---|---|---|---|---|
| spawn.pixel | full | 5.3861 | reported | 92.5859 |  |
| spawn.pixel | old-GPU | 5.3958 | reported | 92.5948 |  |
| spawn.pixel | Vulkan | 5.3981 | reported | 92.4905 |  |
| spawn.pixel | old-GPU two-phase | 5.3786 | reported | 92.5807 |  |
| spawn.pixel_outline | full | 0.0 | 0.001 | 99.9791 | 0 / 1022 of 250 |
| spawn.pixel_outline | old-GPU | 0.0 | 0.001 | 99.9791 | 0 / 1022 of 250 |
| spawn.pixel_outline | Vulkan | 0.0 | 0.001 | 99.9795 | 0 / 1022 of 250 |
| spawn.pixel_outline | old-GPU two-phase | 0.0 | 0.001 | 99.9791 | 0 / 1022 of 250 |
| spawn.pixel_island | full | 0.0 | 0.004 | 99.9902 |  |
| spawn.pixel_island | old-GPU | 0.0 | 0.004 | 99.9902 |  |
| spawn.pixel_island | Vulkan | 0.0039 | 0.01 | 99.9903 |  |
| spawn.pixel_island | old-GPU two-phase | 0.0 | 0.004 | 99.9902 |  |
| water_glass.pixel | full | 0.2471 | 0.666 | 90.7276 |  |
| water_glass.pixel | old-GPU | 0.2451 | 0.666 | 90.7274 |  |
| water_glass.pixel | Vulkan | 0.248 | 0.666 | 90.7516 |  |
| water_glass.pixel | old-GPU two-phase | 0.2451 | 0.666 | 90.7272 |  |
| nether.pixel | full | 0.0 | 0.0645 | 44.1284 |  |
| nether.pixel | old-GPU | 0.0 | 0.0645 | 44.1284 |  |
| nether.pixel | Vulkan | 0.0029 | 0.0645 | 44.1484 |  |
| nether.pixel | old-GPU two-phase | 0.0 | 0.0645 | 44.1284 |  |
| mobs.pixel | full | 0.0127 | 0.0255 | 99.9843 |  |
| mobs.pixel | old-GPU | 0.0127 | 0.0255 | 99.9843 |  |
| mobs.pixel | Vulkan | 0.0127 | 0.0255 | 99.9843 |  |
| mobs.pixel | old-GPU two-phase | 0.0127 | 0.0255 | 99.9843 |  |
| water_glass_oit.pixel | full | 0.2471 | 0.672 | 90.7275 |  |
| water_glass_oit.pixel | old-GPU | 0.2461 | 0.672 | 90.7271 |  |
| water_glass_oit.pixel | Vulkan | 0.248 | 0.672 | 90.7516 |  |
| water_glass_oit.pixel | old-GPU two-phase | 0.2461 | 0.672 | 90.7272 |  |
| lights.pixel_lit | full | 0.0 | 0.001 | 35.3158 |  |
| lights.pixel_lit | old-GPU | 0.0 | 0.001 | 35.3158 |  |
| lights.pixel_lit | Vulkan | 0.0 | 0.001 | 35.3186 |  |
| lights.pixel_lit | old-GPU two-phase | 0.0 | 0.001 | 35.3158 |  |

Pixel art's log lines per run: 'on' lines, window sizes seen (the resizes before spawn.pixel), live GPU objects (at most 3):

| profile | on lines | window sizes | live GPU objects |
|---|---|---|---|
| full | 28 | 1100x620, 1280x720, 1920x1080, 640x360, 800x600, 960x540 | 3 |
| old-GPU | 28 | 1100x620, 1280x720, 1920x1080, 640x360, 800x600, 960x540 | 3 |
| Vulkan | 28 | 1100x620, 1280x720, 1920x1080, 640x360, 800x600, 960x540 | 3 |
| old-GPU two-phase | 28 | 1100x620, 1280x720, 1920x1080, 640x360, 800x600, 960x540 | 3 |

Measure runs (Quicksilver loaded, every module off) against vanilla's run of the same profile: % of pixels over 8/255; the noise limit:

| scene | full | old-GPU | Vulkan |
|---|---|---|---|
| spawn | 0.0645 | 0.4469 | 0.0519 | 0.4469 |
| flythrough | 0.0 | 0.0 | 0.0 | 0.0 |
| water_glass | 0.0034 | 0.0033 | 0.0046 | 0.0033 |
| nether | 0.0023 | 0.0 | 0.0058 | 0.0 |
| mobs | 0.0 | 0.0 | 0.0 | 0.0 |
| mobs.far | 0.0 | 0.0 | 0.0 | 0.0 |
| outline | 0.0 | 0.0 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.open | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.closed | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2300 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2297 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2305 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_x2309 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_move.bare_open | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2944 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2930 | 0.0 | 0.0 | 0.0 | 0.0 |
| occlusion_corner.x-2916 | 0.0 | 0.0 | 0.0 | 0.0 |
| translucent_move | 0.0 | 0.0003 | 0.0002 | 0.0003 |
| translucent_move.x2404 | 0.0001 | 0.0001 | 0.0003 | 0.0001 |
| translucent_move.x2414 | 0.0004 | 0.0001 | 0.0 | 0.0001 |
| translucent_move.x2424 | 0.0001 | 0.0003 | 0.0 | 0.0003 |
| translucent_move.low | 0.0003 | 0.001 | 0.0001 | 0.001 |
| translucent_move.back | 0.0 | 0.0001 | 0.0001 | 0.0001 |
| translucent_move.bare_back | 0.0 | 0.0001 | 0.0001 | 0.0001 |
| water_glass_oit | 0.004 | 0.0031 | 0.0044 | 0.0031 |
| translucent_move_oit | 0.0 | 0.0002 | 0.0001 | 0.0002 |
| translucent_move_oit.x2404 | 0.0003 | 0.0001 | 0.0 | 0.0001 |
| translucent_move_oit.x2414 | 0.0 | 0.0001 | 0.0001 | 0.0001 |
| translucent_move_oit.x2424 | 0.0003 | 0.0 | 0.0001 | 0.0 |
| translucent_move_oit.low | 0.0001 | 0.0004 | 0.0004 | 0.0004 |
| translucent_move_oit.back | 0.0003 | 0.0 | 0.0001 | 0.0 |
| translucent_move_oit.bare_back | 0.0002 | 0.0001 | 0.0 | 0.0001 |
| flat_plants | 0.0 | 0.0 | 0.0 | 0.0 |
| renderer_off | 0.0 | 0.0 | 0.0 | 0.0 |
| particles | 0.0 | 0.0 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.0 | 0.0 | 0.0 |
| animation | 0.0 | 0.0 | 0.0 | 0.0 |
| animation.behind | 0.0 | 0.0 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.0 | 0.0 | 0.0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0.0 |
| block_entities | 0.0061 | 0.0099 | 0.0092 | 0.0099 |
| block_entities.chest_open | 0.0082 | 0.0103 | 0.0058 | 0.0103 |
| block_entities.sign_edit | 0.0106 | 0.0205 | 0.0201 | 0.0205 |
| block_entities.closed | 0.012 | 0.0081 | 0.0115 | 0.0081 |
| lights | 0.0 | 0.0 | 0.0 | 0.0 |

### Counts, core full

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 15.1 (base 13.6) | 15 (base 14) | 27272 (base 22476) | 262.85 (base 259.07) | 8.24 (against vanilla, below) |
| flythrough | 15.96 (reported, not gated) | 41 (reported, not gated) | 587680 (reported, not gated) | 314.3 (base 324.25) | 3.48 (against vanilla, below) |
| water_glass | 9.9 (base 8.97) | 15 (base 15) | 11808 (base 15576) | 243.27 (base 250.02) | 8.24 (against vanilla, below) |
| nether | 13.9 (base 15.63) | 12 (base 12) | 8780 (base 19648) | 264.91 (base 273.53) | 8.24 (against vanilla, below) |
| mobs | 12.74 (base 19.77) | 17 (base 17) | 613596 (base 1010948) | 263.87 (base 268.37) | 8.24 (against vanilla, below) |
| outline | 10.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 262.6 (base 264.69) | 8.24 (against vanilla, below) |
| occlusion | 15.67 (base 15.67) | 17 (base 15) | 116224 (base 126320) | 242.36 (base 265.1) | 3.99 (against vanilla, below) |
| occlusion_move | 12.35 (reported, not gated) | 15 (reported, not gated) | 81960 (reported, not gated) | 242.54 (base 265.74) | 3.99 (against vanilla, below) |
| occlusion_corner | 6.72 (reported, not gated) | 14 (reported, not gated) | 4176 (reported, not gated) | 245.86 (base 267.71) | 5.99 (against vanilla, below) |
| translucent_move | 8.85 (reported, not gated) | 15 (reported, not gated) | 5456 (reported, not gated) | 248.1 (base 267.48) | 3.99 (against vanilla, below) |
| water_glass_oit | 15.0 (base 14.0) | 15 (base 15) | 12144 (base 14688) | 235.71 (base 245.02) | 3.48 (against vanilla, below) |
| translucent_move_oit | 14.15 (reported, not gated) | 15 (reported, not gated) | 5432 (reported, not gated) | 237.64 (base 247.19) | 3.48 (against vanilla, below) |
| flat_plants | 9.74 (base 18.29) | 15 (base 15) | 4444 (base 9812) | 240.63 (base 246.92) | 3.46 (against vanilla, below) |
| renderer_off | 8.69 (base 7.67) | 14 (base 14) | 3564 (base 7164) | 232.5 (base 241.33) | 3.34 (against vanilla, below) |
| particles | 10.67 (base 9.72) | 15 (base 15) | 9124 (base 17128) | 237.45 (base 261.44) | 3.99 (against vanilla, below) |
| animation | 45 median (avg 37.8) (base 49) | 15 (base 15) | 2128 (base 2056) | 234.09 (base 260.68) | 5.99 (against vanilla, below) |
| animated_items | 56 median (avg 44.61) (base 60) | 24 (base 23) | 21980 (base 21940) | 234.06 (base 239.81) | 5.99 (against vanilla, below) |
| block_entities | 35.12 (base 35.11) | 17 (base 17) | 94708 (base 95156) | 233.53 (base 236.44) | 5.99 (against vanilla, below) |
| lights | 15.67 (base 15.67) | 17 (base 17) | 33664 (base 33664) | 287.2 (base 265.73) | 5.99 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-full), core full: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 15.1 / 15 (10.75) | 125.62 / 126 (10.58) | median and average, x 1.10 + 2 |
| flythrough | 15.96 / 16 (7.1) | 123.06 / 123 (7.15) | median and average, at most vanilla + 2 |
| water_glass | 9.9 / 10 (20.74) | 124.0 / 124 (18.79) | median, at most vanilla |
| nether | 13.9 / 17 (27.24) | 120.66 / 121 (19.05) | median, x 1.10 + 2 |
| mobs | 12.74 / 13 (26.76) | 115.03 / 134 (23.88) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 87.33 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 15.67 / 16 (29.94) | 97.46 / 136 (29.97) | median and average, x 1.10 + 2 |
| occlusion_move | 12.35 / 13 (29.93) | 94.66 / 133 (29.85) | median and average, x 1.10 + 2 |
| occlusion_corner | 6.72 / 7 (30.0) | 82.4 / 121 (29.94) | median and average, x 1.10 + 2 |
| translucent_move | 8.85 / 9 (28.94) | 124.0 / 124 (16.45) | median, at most vanilla |
| water_glass_oit | 15.0 / 15 (17.41) | 129.0 / 129 (8.4) | median, at most vanilla |
| translucent_move_oit | 14.15 / 14 (17.61) | 129.0 / 129 (7.96) | median and average, at most vanilla |
| flat_plants | 9.74 / 10 (25.63) | 124.0 / 124 (14.92) | median, x 1.10 + 2 |
| renderer_off | 8.69 / 9 (28.8) | 103.75 / 123 (23.85) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 86.27 / 125 (30.01) | median and average, x 1.10 + 2 |
| animation | 37.8 / 45 (30.0) | 144.22 / 179 (30.0) | median, x 1.10 + 2 |
| animated_items | 44.61 / 56 (30.01) | 155.46 / 190 (30.0) | median, x 1.10 + 2 |
| block_entities | 35.12 / 42 (30.01) | 97.39 / 136 (30.0) | median and average, x 1.10 + 2 |
| lights | 15.67 / 16 (30.01) | 93.27 / 132 (29.99) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-full), core full (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool). Gated without Netty's pooled network buffers where both runs' benches show them in the JVM's pool (run-time fix, 2026-11-26: when the pool takes another chunk is packet timing, the same code in both runs):

| scene | Quicksilver end / peak | vanilla end / peak | of which Netty (Quicksilver / vanilla, end) | gated: Quicksilver end / peak | gated: vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|---|---|---|
| spawn | 8.24 / 8.24 | 4.24 / 4.24 | 7.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.39 |
| flythrough | 3.48 / 3.48 | 5.48 / 5.48 | 2.77 / 4.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| water_glass | 8.24 / 8.24 | 4.24 / 4.24 | 7.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| nether | 8.24 / 8.24 | 4.24 / 4.24 | 7.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| mobs | 8.24 / 8.24 | 4.24 / 4.24 | 7.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 15.69 |
| outline | 8.24 / 8.24 | 4.24 / 4.24 | 7.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.03 |
| occlusion | 3.99 / 3.99 | 4.24 / 4.24 | 3.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| occlusion_move | 3.99 / 3.99 | 4.24 / 4.24 | 3.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| occlusion_corner | 5.99 / 5.99 | 4.24 / 4.24 | 5.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.03 |
| translucent_move | 3.99 / 3.99 | 4.24 / 4.24 | 3.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.03 |
| water_glass_oit | 3.48 / 3.48 | 3.48 / 3.48 | 2.77 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| translucent_move_oit | 3.48 / 3.48 | 3.48 / 3.48 | 2.77 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| flat_plants | 3.46 / 3.46 | 3.21 / 3.21 | 2.76 / 2.51 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.39 |
| renderer_off | 3.34 / 3.34 | 3.34 / 3.34 | 2.63 / 2.63 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.53 |
| particles | 3.99 / 3.99 | 4.24 / 4.24 | 3.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| animation | 5.99 / 5.99 | 4.24 / 4.24 | 5.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| animated_items | 5.99 / 5.99 | 4.24 / 4.24 | 5.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| block_entities | 5.99 / 5.99 | 4.24 / 4.24 | 5.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| lights | 5.99 / 5.99 | 4.24 / 4.24 | 5.29 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.39 |

Terrain GPU memory, core full (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 56.0 / 23.346 | 56.0 / 23.346 | 0.0 / 0.0 | 416.0 / 39.595 |
| flythrough | 144.0 / 85.198 | 144.0 / 85.198 | 0.0 / 0.0 | 416.0 / 146.329 |
| water_glass | 56.0 / 12.463 | 56.0 / 12.463 | 0.0 / 0.0 | 416.0 / 22.142 |
| nether | 36.0 / 15.185 | 36.0 / 15.185 | 0.0 / 0.0 | 256.0 / 26.636 |
| mobs | 28.0 / 10.134 | 28.0 / 10.134 | 0.0 / 0.0 | 416.0 / 17.63 |
| outline | 28.0 / 1.472 | 28.0 / 1.472 | 0.0 / 0.0 | 256.0 / 2.595 |
| occlusion | 56.0 / 2.077 | 56.0 / 2.077 | 0.0 / 0.0 | 416.0 / 3.655 |
| occlusion_move | 56.0 / 3.32 | 56.0 / 3.32 | 0.0 / 0.0 | 416.0 / 5.92 |
| occlusion_corner | 56.0 / 1.931 | 56.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 36.0 / 13.454 | 36.0 / 13.454 | 0.0 / 0.0 | 416.0 / 22.698 |
| water_glass_oit | 28.0 / 12.463 | 28.0 / 12.463 | 0.0 / 0.0 | 416.0 / 21.628 |
| translucent_move_oit | 28.0 / 13.06 | 28.0 / 13.06 | 0.0 / 0.0 | 416.0 / 22.017 |
| flat_plants | 28.0 / 13.936 | 28.0 / 13.936 | 0.0 / 0.0 | 416.0 / 24.754 |
| renderer_off | 28.0 / 8.928 | 28.0 / 8.928 | 0.0 / 0.0 | 416.0 / 15.737 |
| particles | 36.0 / 0.131 | 36.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 36.0 / 0.297 | 36.0 / 0.297 | 0.0 / 0.0 | 256.0 / 0.536 |
| animated_items | 36.0 / 0.146 | 36.0 / 0.146 | 0.0 / 0.0 | 128.0 / 0.26 |
| block_entities | 36.0 / 0.143 | 36.0 / 0.143 | 0.0 / 0.0 | 256.0 / 0.247 |
| lights | 8.0 / 0.492 | 8.0 / 0.492 | 0.0 / 0.0 | 256.0 / 0.851 |


Package 4b, core full: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-full:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 406966.953 (557450.879) | 26.995 | 1.208 | 345576 / 588496 | 318160 (2097152.0) | 214 / 211 | 0.0 / 0 |
| flythrough | 464700.732 (730080.775) | 36.349 | 1.088 | 2167688 / 6935360 | 2094912 (2097152.0) | 142 / 143 | 6.392 / 49 |
| water_glass | 113286.981 (197760.531) | 42.715 | 1.133 | 169456 / 17612 | 156864 (2097152.0) | 131 / 373 | 0.0 / 0 |
| nether | 29506.04 (42403.662) | 30.416 | 2.0 | 166828 / 399592 | 156608 (2097152.0) | 136 / 374 | 0.0 / 0 |
| mobs | 62314.258 (111345.735) | 44.035 | 0.967 | 613596 / 616496 | 0 (2097152.0) | 32 / 12 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5580 / 6320 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |
| occlusion | 3702.17 (5717.529) | 35.249 | 1.182 | 116224 / 128496 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 20606.083 (35882.087) | 42.573 | 1.274 | 672112 / 1217524 | 595968 (2097152.0) | 0 / 1 | 0.0 / 0 |
| occlusion_corner | 21844.397 (47204.86) | 53.724 | 1.214 | 35396 / 59420 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 21573.097 (27568.187) | 21.746 | 1.004 | 817568 / 1431364 | 812096 (2097152.0) | 105 / 328 | 0.0 / 0 |
| water_glass_oit | 113338.753 (197850.908) | 42.715 | 1.133 | 13488 / 331604 | 0 (2097152.0) | 348 / 168 | 0.0 / 0 |
| translucent_move_oit | 21617.284 (27631.574) | 21.766 | 1.004 | 794808 / 1430768 | 790336 (2097152.0) | 259 / 159 | 0.0 / 0 |
| flat_plants | 5350.409 (8726.979) | 38.691 | 1.048 | 266476 / 10040 | 105792 (2097152.0) | 129 / 298 | 0.0 / 0 |
| renderer_off | 21174.762 (40173.746) | 47.292 | 1.0 | 3564 / 7184 | 0 (2097152.0) | 110 / 8 | 0.0 / 0 |
| particles | 1698.827 (3676.117) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 2913.235 (4982.684) | 41.533 | 1.1 | 86644 / 150232 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1674.791 (3581.97) | 53.244 | 1.0 | 79708 / 123124 | 57728 (2097152.0) | 1 / 0 | 0.0 / 0 |
| block_entities | 3461.76 (4439.387) | 22.022 | 1.6 | 136048 / 167276 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |
| lights | 11114.524 (14808.681) | 24.946 | 1.667 | 33664 / 33624 | 0 (2097152.0) | 0 / 1 | 0.0 / 0 |

Package 4c, core full: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-full:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 5.627 (455) | 2.977 (136) | 1.89 | 3.384 (56) | 0 | 1221 / 0 | 8.191 / 10.851 | 3.938 / 5.144 |
| flythrough | 5.29 (1643) | 4.976 (1636) | 1.063 | 5.29 (1643) | 0 | 1517 / 0 | 6.174 / 8.683 | 4.124 / 5.55 |
| water_glass | 2.747 (24) | 1.302 (18) | 2.11 | 4.446 (3) | 0 | 1530 / 0 | 7.573 / 10.0 | 3.793 / 5.02 |
| nether | 2.626 (27) | 2.379 (34) | 1.104 | 2.465 (11) | 0 | 2161 / 0 | 6.421 / 8.621 | 3.36 / 4.685 |
| mobs | 3.607 (67) | 2.507 (67) | 1.439 | None (0) | 0 | 2399 / 0 | 6.282 / 8.429 | 3.317 / 4.597 |
| outline | 0.312 (12) | 0.593 (13) | 0.526 | None (0) | 0 | 2458 / 0 | 6.215 / 8.332 | 3.253 / 4.567 |
| occlusion | 1.592 (40) | 0.819 (37) | 1.944 | None (0) | 0 | 1090 / 0 | 9.842 / 14.097 | 7.096 / 10.498 |
| occlusion_move | 1.577 (59) | 2.275 (54) | 0.693 | 3.864 (16) | 0 | 1239 / 0 | 8.938 / 12.765 | 5.813 / 9.131 |
| occlusion_corner | 1.21 (110) | 1.187 (110) | 1.019 | 4.171 (1) | 0 | 1527 / 0 | 7.593 / 10.865 | 4.128 / 7.019 |
| translucent_move | 1.807 (107) | 4.187 (106) | 0.432 | 2.895 (34) | 0 | 739 / 0 | 6.22 / 8.447 | 2.206 / 3.684 |
| water_glass_oit | 2.311 (155) | 5.214 (152) | 0.443 | None (0) | 0 | 310 / 0 | 8.268 / 9.365 | 2.903 / 3.972 |
| translucent_move_oit | 1.826 (237) | 5.399 (209) | 0.338 | 2.903 (27) | 0 | 868 / 0 | 4.251 / 5.263 | 1.535 / 2.147 |
| flat_plants | 1.794 (78) | 0.878 (85) | 2.043 | 2.189 (1) | 0 | 403 / 0 | 6.212 / 8.086 | 2.449 / 3.382 |
| renderer_off | 0.506 (26) | 0.362 (22) | 1.398 | None (0) | 0 | 316 / 0 | 7.227 / 10.318 | 3.963 / 5.127 |
| particles | 0.171 (30) | 0.269 (24) | 0.636 | None (0) | 0 | 768 / 0 | 6.004 / 8.146 | 2.077 / 3.433 |
| animation | 0.532 (18) | 0.928 (18) | 0.573 | 0.795 (4) | 0 | 841 / 0 | 5.524 / 7.492 | 1.886 / 2.771 |
| animated_items | 0.191 (43) | 0.391 (32) | 0.488 | 0.526 (2) | 0 | 871 / 0 | 5.346 / 7.249 | 1.804 / 2.62 |
| block_entities | 0.52 (83) | 0.93 (80) | 0.559 | 0.726 (1) | 0 | 953 / 0 | 4.94 / 6.685 | 1.577 / 2.196 |
| lights | 1.842 (21) | 1.517 (21) | 1.214 | None (0) | 0 | 2647 / 0 | 6.69 / 9.471 | 3.682 / 6.29 |

Terrain module, core full (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.014 | 609.836 | 16 (vanilla 28) | 1406744 | 42.358 / 0.109 | 23.346 / 56.0 | 37.564 | 3973 / 0 | 3.384 (6.264) |
| flythrough | indirect, one multi-draw per arena and layer | 4.908 | 739.408 | 16 (vanilla 28) | 5158776 | 25.163 / 0.951 | 85.198 / 144.0 | 137.754 | 6975 / 0 | 5.29 (14.722) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 105.254 | 16 (vanilla 28) | 773732 | 36.777 / 0.1 | 12.463 / 56.0 | 20.661 | 4630 / 0 | 4.446 (5.548) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 43.079 | 16 (vanilla 28) | 953652 | 32.309 / 0.169 | 15.185 / 36.0 | 25.465 | 5681 / 0 | 2.465 (3.455) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 60.112 | 16 (vanilla 28) | 628012 | 29.362 / 0.149 | 10.134 / 28.0 | 16.77 | 6250 / 0 | None (None) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 92996 | 28.952 / 0.149 | 1.472 / 28.0 | 2.483 | 6346 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 2.003 | 11.018 | 16 (vanilla 28) | 129800 | 28.222 / 0.556 | 2.077 / 56.0 | 3.466 | 2424 / 0 | None (None) |
| occlusion_move | indirect, one multi-draw per arena and layer | 2.871 | 33.883 | 16 (vanilla 28) | 207644 | 24.812 / 0.487 | 3.32 / 56.0 | 5.545 | 2698 / 0 | 3.864 (10.041) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.053 | 60.882 | 16 (vanilla 28) | 122728 | 21.769 / 0.427 | 1.931 / 56.0 | 3.277 | 3095 / 0 | 4.171 (4.167) |
| translucent_move | indirect, one multi-draw per arena and layer | 2.166 | 23.067 | 16 (vanilla 28) | 831004 | 15.086 / 0.058 | 13.454 / 36.0 | 22.19 | 1699 / 0 | 2.895 (8.538) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.014 | 113.325 | 16 (vanilla 28) | 773732 | 8.561 / 0.043 | 12.463 / 28.0 | 20.661 | 896 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 4.185 | 37.139 | 16 (vanilla 28) | 806524 | 7.2 / 0.12 | 13.06 / 28.0 | 21.537 | 2262 / 0 | 2.903 (7.287) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 21.041 | 16 (vanilla 28) | 871716 | 5.563 / 0.0 | 13.936 / 28.0 | 23.277 | 923 / 0 | 2.189 (2.185) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.038 | 16 (vanilla 28) | 560212 | 2.163 / 0.014 | 8.928 / 28.0 | 14.959 | 604 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 14.963 / 0.058 | 0.131 / 36.0 | 0.225 | 1745 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 19088 | 14.576 / 0.056 | 0.297 / 36.0 | 0.51 | 1845 / 0 | 0.795 (1.1) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 9304 | 14.448 / 0.058 | 0.146 / 36.0 | 0.248 | 1893 / 0 | 0.526 (0.76) |
| block_entities | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 8864 | 13.742 / 0.055 | 0.143 / 36.0 | 0.237 | 2052 / 0 | 0.726 (0.723) |
| lights | indirect, one multi-draw per arena and layer | 1.002 | 9.015 | 16 (vanilla 28) | 30544 | 15.064 / 0.304 | 0.492 / 8.0 | 0.816 | 5027 / 0 | None (None) |

Translucency, core full (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 144.0 | 1.0 | 0.0 | 0 | 0 | 44 (0.025 / 0.035 / 0.038; 0) | 0 | 30960 / 0 / 0 |
| flythrough | 185.161 | 1.0 | 0.0 | 0 | 0 | 883 (0.039 / 0.046 / 7.047; 0) | 54 | 26478 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1660 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.013 / 0.022; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.1 / 0.103 / 3.099; 0) | 180 | 4053 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 1047 | 0 (None / None / None; 0) | 0 | 1396 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 1059 | 0 (None / None / None; 0) | 0 | 2471 / 0 / 0 |
| flat_plants | 3.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1542 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2304 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| lights | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core full (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 354.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.041 (0.086; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.741 | 1.0 (0.0, 0.0) | 1.182 (0.0, 0.0) | 0.001 (0.01; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.083; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.134 (0.319; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 46.0 | 11.0 (10.0, 1.0) | 9.0 (9.0, 1.0) | 0.068 (0.225; 0) | 0 | 1200 / 638400 / 0 / 0 |
| occlusion_move | 52.36 | 10.0 (9.0, 2.367) | 6.0 (6.0, 2.278) | 0.055 (0.212; 0) | 0 | 2787 / 1509450 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.556 | 1.0 (0.0, 0.0) | 0.782 (0.0, 0.0) | 0.002 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.05; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.388 | 1.0 (0.0, 0.0) | 0.759 (0.0, 0.0) | 0.002 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 109.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.068; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 12.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 12.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.117; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.037 (0.156; 0) | 0 | 0 / 0 / 0 / 0 |
| lights | 12.0 | 5.0 (2.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.047; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core full (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 248.0 / 322.0 (23.0) | 248.0 / 74.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3996 / 0 |
| flythrough | two-phase | 305.38 / 393.56 (22.4) | 298.75 / 94.81 / 6.63 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3107 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 8944 / 0 |
| nether | two-phase | 37.0 / 187.0 (80.2) | 37.0 / 150.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 20550 / 0 |
| mobs | two-phase | 32.0 / 110.0 (70.9) | 32.0 / 78.0 / 0.0 | 1.0 | 0.0 (0.0, 0.03; 100.0) | 14400.0 | 10374 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 9.0 / 46.0 (80.4) | 9.0 / 37.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 5550 / 0 |
| occlusion_move | two-phase | 22.41 / 52.31 (57.2) | 22.35 / 29.96 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4444 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3162 / 0 |
| translucent_move | two-phase | 15.65 / 135.43 (88.4) | 15.64 / 119.79 / 0.02 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 17369 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7482 / 0 |
| translucent_move_oit | two-phase | 15.64 / 134.99 (88.4) | 15.61 / 119.37 / 0.03 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10510 / 0 |
| flat_plants | two-phase | 9.0 / 150.0 (94.0) | 9.0 / 141.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18048 / 0 |
| renderer_off | two-phase | 11.0 / 109.0 (89.9) | 11.0 / 98.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14112 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 9.0 / 12.0 (25.0) | 9.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 6.0 / 12.0 (50.0) | 6.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| lights | two-phase | 9.0 / 12.0 (25.0) | 9.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |

Effects, core full (reported; draw calls per frame by what they draw for; vanilla = measure-full):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.758 / 0.103 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 67.168 / 0.102 | 0.02 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.112 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.825 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.172 / 52.214 | 0.017 / 0.019 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.321 | 0.664 / 0.846 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 36.621 / 6.821 | 0.063 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 96.195 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.795 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_move | 76.988 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_corner | 76.731 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.123 / 13.121 | 0.01 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.227 / 53.309 | 0.018 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.033 / 12.034 | 0.008 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 0.0 | 1.0 / 0.988 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.773 / 2.504 | 0.017 / 0.01 | 56 (2) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| renderer_off | 95.914 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.007 / 0.047 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| animation | 136.553 / 29.132 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.001 / 0.005 | 56 (2) | 40.58 / 8.298 / 32.283 | 3 / 0 | 9.988 |
| animated_items | 136.793 / 24.94 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (8) | 40.608 / 7.04 / 33.568 | 0 / 0 | 8.0 |
| block_entities | 76.603 / 13.333 | 1.0 / 0.995 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.903 / 9.912 | 0.006 / 0.009 | 56 (8) | 23.0 / 4.0 / 19.0 | 0 / 0 | 8.0 |
| lights | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (3) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |

GUI pass, core full (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
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
| lights | 4.0 / 4.0 | 0.0 / 0.0 | 5.0 / 5.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 41.43 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 262.03 (base 256.29) | 8.24 (against vanilla, below) |
| flythrough | 52.28 (reported, not gated) | 31 (reported, not gated) | 187700 (reported, not gated) | 313.69 (base 324.79) | 3.73 (against vanilla, below) |
| water_glass | 19.72 (base 20.0) | 13 (base 14) | 7112 (base 10264) | 243.25 (base 249.83) | 8.24 (against vanilla, below) |
| nether | 22.33 (base 33.79) | 10 (base 11) | 4552 (base 10656) | 264.81 (base 272.57) | 8.24 (against vanilla, below) |
| mobs | 17.69 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 264.18 (base 268.23) | 8.24 (against vanilla, below) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 262.89 (base 264.41) | 8.24 (against vanilla, below) |
| occlusion | 16.73 (base 22.67) | 15 (base 14) | 115228 (base 124172) | 242.42 (base 264.64) | 4.24 (against vanilla, below) |
| occlusion_move | 19.47 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 242.08 (base 265.66) | 4.24 (against vanilla, below) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 245.55 (base 267.41) | 4.24 (against vanilla, below) |
| translucent_move | 17.88 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 249.44 (base 268.19) | 4.24 (against vanilla, below) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7428 (base 7604) | 236.07 (base 245.78) | 3.48 (against vanilla, below) |
| translucent_move_oit | 25.0 (reported, not gated) | 13 (reported, not gated) | 3284 (reported, not gated) | 237.92 (base 248.15) | 3.48 (against vanilla, below) |
| flat_plants | 8.45 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 241.25 (base 248.11) | 5.21 (against vanilla, below) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.0 (base 240.73) | 3.34 (against vanilla, below) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 238.68 (base 261.4) | 4.24 (against vanilla, below) |
| animation | 45 median (avg 36.88) (base 49) | 13 (base 13) | 1716 (base 1716) | 235.65 (base 260.68) | 4.24 (against vanilla, below) |
| animated_items | 55 median (avg 43.92) (base 60) | 22 (base 22) | 21668 (base 21668) | 235.51 (base 239.53) | 4.24 (against vanilla, below) |
| block_entities | 35.11 (base 36.11) | 15 (base 15) | 94488 (base 95140) | 234.92 (base 236.55) | 4.24 (against vanilla, below) |
| lights | 14.67 (base 15.67) | 15 (base 15) | 33172 (base 33172) | 287.1 (base 265.68) | 8.24 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 41.43 / 41 (14.15) | 848.29 / 848 (12.18) | median and average, x 1.10 + 2 |
| flythrough | 52.28 / 52 (9.62) | 1025.82 / 1026 (7.46) | median and average, at most vanilla |
| water_glass | 19.72 / 20 (27.75) | 387.84 / 391 (20.24) | median, at most vanilla |
| nether | 22.33 / 26 (29.9) | 587.49 / 588 (19.8) | median, x 1.10 + 2 |
| mobs | 17.69 / 18 (29.55) | 309.53 / 335 (25.54) | median, x 1.10 + 2 |
| outline | 10.67 / 11 (30.0) | 128.27 / 167 (30.01) | median, x 1.10 + 2 |
| occlusion | 16.73 / 17 (30.02) | 148.33 / 187 (30.01) | median and average, x 1.10 + 2 |
| occlusion_move | 19.47 / 19 (29.99) | 168.57 / 203 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 10.67 / 11 (30.0) | 163.2 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 17.88 / 18 (21.62) | 367.24 / 366 (16.6) | median, at most vanilla |
| water_glass_oit | 25.0 / 25 (13.18) | 400.0 / 400 (8.15) | median, at most vanilla |
| translucent_move_oit | 25.0 / 25 (10.91) | 382.53 / 383 (8.74) | median and average, at most vanilla |
| flat_plants | 8.45 / 9 (28.75) | 391.32 / 399 (21.27) | median, x 1.10 + 2 |
| renderer_off | 12.67 / 13 (29.91) | 285.58 / 323 (29.51) | median, x 1.10 + 2 |
| particles | 10.67 / 11 (30.0) | 97.27 / 136 (30.01) | median and average, x 1.10 + 2 |
| animation | 36.88 / 45 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |
| animated_items | 43.92 / 55 (30.0) | 166.28 / 201 (30.0) | median, x 1.10 + 2 |
| block_entities | 35.11 / 42 (30.0) | 105.38 / 144 (30.01) | median and average, x 1.10 + 2 |
| lights | 14.67 / 15 (30.0) | 104.27 / 143 (30.0) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-old), core old-gpu (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool). Gated without Netty's pooled network buffers where both runs' benches show them in the JVM's pool (run-time fix, 2026-11-26: when the pool takes another chunk is packet timing, the same code in both runs):

| scene | Quicksilver end / peak | vanilla end / peak | of which Netty (Quicksilver / vanilla, end) | gated: Quicksilver end / peak | gated: vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|---|---|---|
| spawn | 8.24 / 8.24 | 3.99 / 3.99 | 7.54 / 3.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| flythrough | 3.73 / 3.73 | 3.48 / 3.48 | 3.02 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| water_glass | 8.24 / 8.24 | 3.99 / 3.99 | 7.54 / 3.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| nether | 8.24 / 8.24 | 3.99 / 3.99 | 7.54 / 3.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| mobs | 8.24 / 8.24 | 5.99 / 5.99 | 7.54 / 5.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| outline | 8.24 / 8.24 | 5.99 / 5.99 | 7.54 / 5.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| occlusion | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| occlusion_move | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| occlusion_corner | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| translucent_move | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| water_glass_oit | 3.48 / 3.48 | 3.48 / 3.48 | 2.77 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| translucent_move_oit | 3.48 / 3.48 | 3.48 / 3.48 | 2.77 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| flat_plants | 5.21 / 5.21 | 3.35 / 3.35 | 4.51 / 2.65 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| renderer_off | 3.34 / 3.34 | 3.6 / 3.6 | 2.63 / 2.9 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.46 |
| particles | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| animation | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| animated_items | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| block_entities | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 17.06 |
| lights | 8.24 / 8.31 | 4.24 / 4.24 | 7.54 / 3.54 | 0.71 / 0.77 | 0.71 / 0.71 | 4.71 / 4.71 | 14.39 |

Terrain GPU memory, core old-gpu (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 64.0 / 23.33 | 64.0 / 23.33 | 0.0 / 0.0 | 416.0 / 37.373 |
| flythrough | 128.0 / 86.991 | 128.0 / 86.991 | 0.0 / 0.0 | 416.0 / 142.963 |
| water_glass | 48.0 / 12.463 | 48.0 / 12.463 | 0.0 / 0.0 | 416.0 / 21.91 |
| nether | 32.0 / 15.19 | 32.0 / 15.19 | 0.0 / 0.0 | 256.0 / 26.636 |
| mobs | 48.0 / 10.134 | 48.0 / 10.134 | 0.0 / 0.0 | 416.0 / 17.63 |
| outline | 48.0 / 1.472 | 48.0 / 1.472 | 0.0 / 0.0 | 256.0 / 2.595 |
| occlusion | 48.0 / 2.133 | 48.0 / 2.133 | 0.0 / 0.0 | 416.0 / 11.696 |
| occlusion_move | 48.0 / 3.449 | 48.0 / 3.449 | 0.0 / 0.0 | 416.0 / 5.819 |
| occlusion_corner | 48.0 / 1.931 | 48.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 48.0 / 13.382 | 48.0 / 13.382 | 0.0 / 0.0 | 416.0 / 22.835 |
| water_glass_oit | 48.0 / 12.463 | 48.0 / 12.463 | 0.0 / 0.0 | 416.0 / 21.628 |
| translucent_move_oit | 48.0 / 13.141 | 48.0 / 13.141 | 0.0 / 0.0 | 416.0 / 22.153 |
| flat_plants | 64.0 / 14.193 | 64.0 / 14.193 | 0.0 / 0.0 | 416.0 / 24.414 |
| renderer_off | 48.0 / 8.952 | 48.0 / 8.952 | 0.0 / 0.0 | 416.0 / 15.703 |
| particles | 48.0 / 0.131 | 48.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 48.0 / 0.297 | 48.0 / 0.297 | 0.0 / 0.0 | 256.0 / 0.536 |
| animated_items | 48.0 / 0.146 | 48.0 / 0.146 | 0.0 / 0.0 | 128.0 / 0.26 |
| block_entities | 48.0 / 0.142 | 48.0 / 0.142 | 0.0 / 0.0 | 256.0 / 0.247 |
| lights | 32.0 / 0.483 | 32.0 / 0.483 | 0.0 / 0.0 | 256.0 / 0.851 |


Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 389653.943 (588229.336) | 33.758 | 1.775 | 460612 / 769620 | 453184 (2097152.0) | 283 / 243 | 0.0 / 0 |
| flythrough | 540902.844 (864925.0) | 37.462 | 1.087 | 2104412 / 7285272 | 2096848 (2097152.0) | 192 / 149 | 5.508 / 59 |
| water_glass | 113217.629 (197639.467) | 42.715 | 1.133 | 9220 / 11876 | 0 (2097152.0) | 9 / 93 | 0.0 / 0 |
| nether | 37612.288 (57015.859) | 34.032 | 1.931 | 175972 / 407584 | 171328 (2097143.395) | 105 / 140 | 0.0 / 0 |
| mobs | 62842.836 (112309.35) | 44.045 | 0.967 | 767380 / 928004 | 156864 (2097152.0) | 5 / 11 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 4049.689 (6325.783) | 35.981 | 1.184 | 277916 / 127084 | 162688 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 49996.711 (87794.404) | 43.053 | 1.229 | 691116 / 1196252 | 617088 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 27756.922 (60455.165) | 54.087 | 1.272 | 32840 / 57800 | 31552 (2097152.0) | 0 / 0 | 0.0 / 0 |
| translucent_move | 207717.167 (369883.87) | 43.843 | 1.182 | 817012 / 1426612 | 812096 (2097152.0) | 56 / 331 | 0.0 / 0 |
| water_glass_oit | 114618.023 (200196.639) | 42.747 | 1.133 | 163556 / 285028 | 156800 (2097152.0) | 263 / 162 | 0.0 / 0 |
| translucent_move_oit | 207564.991 (369400.853) | 43.81 | 1.181 | 817348 / 1425988 | 812096 (2097152.0) | 218 / 174 | 0.0 / 0 |
| flat_plants | 5349.303 (8725.174) | 38.691 | 1.048 | 1940 / 4292 | 0 (2097152.0) | 143 / 53 | 0.0 / 0 |
| renderer_off | 21243.465 (40303.284) | 47.291 | 1.0 | 1380 / 3124 | 0 (2097152.0) | 8 / 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 2947.96 (5063.486) | 41.78 | 1.095 | 86232 / 149880 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2119.352 (4604.08) | 53.968 | 1.0 | 79304 / 122884 | 57728 (2097152.0) | 1 / 1 | 0.0 / 0 |
| block_entities | 3461.76 (4439.387) | 22.022 | 1.6 | 136160 / 167524 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |
| lights | 11114.524 (14808.681) | 24.946 | 1.667 | 33172 / 33364 | 0 (2097152.0) | 1 / 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 4.205 (450) | 2.661 (106) | 1.58 | 2.744 (56) | 0 | 1292 / 0 | 5.651 / 7.553 | 2.494 / 3.547 |
| flythrough | 4.775 (1674) | 5.123 (1595) | 0.932 | 4.775 (1674) | 0 | 1524 / 0 | 4.84 / 6.658 | 2.926 / 4.285 |
| water_glass | 2.052 (15) | 1.113 (14) | 1.844 | None (0) | 0 | 1605 / 0 | 5.154 / 6.933 | 2.389 / 3.424 |
| nether | 1.85 (36) | 2.216 (24) | 0.835 | 1.713 (15) | 0 | 2254 / 0 | 4.504 / 6.065 | 2.198 / 3.152 |
| mobs | 2.594 (73) | 2.921 (75) | 0.888 | 3.858 (1) | 0 | 2494 / 0 | 4.412 / 5.886 | 2.166 / 3.101 |
| outline | 0.258 (12) | 0.25 (13) | 1.032 | None (0) | 0 | 2553 / 0 | 4.381 / 5.85 | 2.153 / 3.097 |
| occlusion | 1.229 (45) | 4.519 (114) | 0.272 | 2.532 (4) | 0 | 1237 / 0 | 6.551 / 9.387 | 3.029 / 5.876 |
| occlusion_move | 1.457 (60) | 1.931 (68) | 0.755 | 3.231 (18) | 0 | 1390 / 0 | 6.026 / 8.583 | 2.611 / 5.102 |
| occlusion_corner | 0.937 (110) | 1.147 (82) | 0.817 | 1.14 (1) | 0 | 1670 / 0 | 5.307 / 7.483 | 2.136 / 3.939 |
| translucent_move | 2.302 (117) | 4.327 (104) | 0.532 | 3.515 (43) | 0 | 713 / 0 | 7.551 / 10.866 | 3.604 / 6.153 |
| water_glass_oit | 3.249 (155) | 4.832 (150) | 0.672 | 10.662 (1) | 0 | 308 / 0 | 8.083 / 9.972 | 3.838 / 4.758 |
| translucent_move_oit | 3.195 (233) | 4.792 (212) | 0.667 | 4.469 (29) | 0 | 873 / 0 | 5.136 / 6.619 | 2.436 / 3.265 |
| flat_plants | 1.297 (90) | 1.128 (89) | 1.15 | None (0) | 0 | 406 / 0 | 6.453 / 8.182 | 2.386 / 2.868 |
| renderer_off | 0.82 (25) | 0.496 (21) | 1.653 | None (0) | 0 | 316 / 0 | 6.529 / 8.95 | 2.994 / 4.699 |
| particles | 0.264 (30) | 0.237 (24) | 1.114 | None (0) | 0 | 742 / 0 | 7.277 / 10.473 | 3.386 / 5.722 |
| animation | 1.632 (18) | 1.688 (18) | 0.967 | 5.145 (4) | 0 | 815 / 0 | 6.701 / 9.628 | 2.737 / 4.826 |
| animated_items | 0.248 (43) | 0.257 (38) | 0.965 | 0.844 (2) | 0 | 845 / 0 | 6.483 / 9.305 | 2.617 / 4.395 |
| block_entities | 0.723 (80) | 0.793 (60) | 0.912 | 1.177 (1) | 0 | 927 / 0 | 5.978 / 8.578 | 2.084 / 3.578 |
| lights | 1.319 (21) | 1.846 (21) | 0.715 | None (0) | 0 | 2811 / 0 | 4.814 / 6.741 | 2.052 / 3.466 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 30.106 | 650.304 | 16 (vanilla 28) | 1407032 | 43.823 / 0.1 | 23.33 / 64.0 | 37.572 | 4163 / 0 | 2.744 (5.828) |
| flythrough | plain, one multi-draw per region and layer | 42.417 | 891.328 | 16 (vanilla 28) | 5263192 | 25.275 / 0.928 | 86.991 / 128.0 | 140.542 | 7049 / 0 | 4.775 (13.349) |
| water_glass | plain, one multi-draw per region and layer | 14.025 | 105.189 | 16 (vanilla 28) | 773728 | 38.37 / 0.093 | 12.463 / 48.0 | 20.661 | 4817 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.079 | 57.142 | 16 (vanilla 28) | 953860 | 33.452 / 0.159 | 15.19 / 32.0 | 25.471 | 5919 / 0 | 1.713 (3.063) |
| mobs | plain, one multi-draw per region and layer | 8.029 | 60.827 | 16 (vanilla 28) | 628012 | 30.363 / 0.141 | 10.134 / 48.0 | 16.77 | 6505 / 0 | 3.858 (3.854) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 92996 | 29.955 / 0.14 | 1.472 / 48.0 | 2.483 | 6601 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 4.067 | 11.559 | 16 (vanilla 28) | 132864 | 24.753 / 0.93 | 2.133 / 48.0 | 3.548 | 2774 / 0 | 2.532 (2.927) |
| occlusion_move | plain, one multi-draw per region and layer | 10.993 | 77.366 | 16 (vanilla 28) | 213912 | 22.02 / 0.823 | 3.449 / 48.0 | 5.712 | 3059 / 0 | 3.231 (7.553) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.91 | 16 (vanilla 28) | 122728 | 19.615 / 0.733 | 1.931 / 48.0 | 3.277 | 3448 / 0 | 1.14 (1.137) |
| translucent_move | plain, one multi-draw per region and layer | 11.991 | 247.764 | 16 (vanilla 28) | 826584 | 11.97 / 0.076 | 13.382 / 48.0 | 22.072 | 1640 / 0 | 3.515 (10.78) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.061 | 115.335 | 16 (vanilla 28) | 773728 | 8.505 / 0.042 | 12.463 / 48.0 | 20.661 | 896 / 0 | 10.662 (10.659) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.037 | 261.573 | 16 (vanilla 28) | 811748 | 6.841 / 0.111 | 13.141 / 48.0 | 21.676 | 2280 / 0 | 4.469 (9.09) |
| flat_plants | plain, one multi-draw per region and layer | 3.005 | 21.037 | 16 (vanilla 28) | 886656 | 5.921 / 0.0 | 14.193 / 64.0 | 23.676 | 954 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 561016 | 2.15 / 0.013 | 8.952 / 48.0 | 14.981 | 602 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 11.84 / 0.075 | 0.131 / 48.0 | 0.225 | 1686 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 10.518 | 16 (vanilla 28) | 19088 | 11.52 / 0.073 | 0.297 / 48.0 | 0.51 | 1786 / 0 | 5.145 (9.488) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 11.71 | 16 (vanilla 28) | 9304 | 11.415 / 0.075 | 0.146 / 48.0 | 0.248 | 1834 / 0 | 0.844 (1.334) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 10.851 / 0.07 | 0.142 / 48.0 | 0.237 | 1990 / 0 | 1.177 (1.174) |
| lights | plain, one multi-draw per region and layer | 1.002 | 9.015 | 16 (vanilla 28) | 30052 | 14.237 / 0.498 | 0.483 / 32.0 | 0.802 | 5421 / 0 | None (None) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 144.0 | 8.0 | 0.0 | 0 | 0 | 48 (0.027 / 0.041 / 0.319; 0) | 0 | 40896 / 0 / 0 |
| flythrough | 189.249 | 8.342 | 0.0 | 0 | 0 | 895 (0.028 / 0.04 / 11.278; 0) | 53 | 36525 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2224 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.01; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.095 / 0.132 / 1.831; 0) | 180 | 3031 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 792 | 0 (None / None / None; 0) | 0 | 1056 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 657 | 0 (None / None / None; 0) | 0 | 1533 / 0 / 0 |
| flat_plants | 3.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1725 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| lights | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 354.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.04 (0.084; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.088 | 1.0 (0.0, 0.0) | 1.166 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.009; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.01 (0.041; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.118 (0.245; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 46.0 | 11.0 (10.0, 1.0) | 9.0 (9.0, 1.0) | 0.06 (0.127; 0) | 0 | 1200 / 638400 / 0 / 0 |
| occlusion_move | 52.353 | 10.0 (9.0, 2.368) | 6.0 (6.0, 2.282) | 0.056 (0.247; 0) | 0 | 2790 / 1510482 / 0 / 0 |
| occlusion_corner | 81.86 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.0; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.376 | 1.0 (0.0, 0.0) | 0.771 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.411 | 1.0 (0.0, 0.0) | 0.74 (0.0, 0.0) | 0.003 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 109.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 12.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 12.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.045 (0.142; 0) | 0 | 0 / 0 / 0 / 0 |
| lights | 12.0 | 5.0 (2.0, 0.0) | 1.0 (1.0, 0.0) | 0.01 (0.039; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 271.71 / 322.0 (15.6) | 271.71 / 0.0 / 0.0 | 0.1 | 0.0 (0.0, 0.0; 0.0) | 1369.01 | 3330 / 0 |
| flythrough | still | 397.29 / 397.58 (0.1) | 397.29 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11954 / 0 |
| nether | still | 45.78 / 187.0 (75.5) | 45.78 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 264.88 | 20850 / 0 |
| mobs | still | 32.4 / 110.0 (70.5) | 32.4 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.32 | 11466 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3278 / 0 |
| occlusion | still | 9.37 / 46.0 (79.6) | 9.37 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.0 | 5476 / 0 |
| occlusion_move | still | 52.19 / 52.31 (0.2) | 52.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.72 / 81.85 (0.2) | 81.72 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 134.46 / 135.21 (0.6) | 134.46 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 108 / 0 |
| water_glass_oit | still | 53.98 / 139.0 (61.2) | 53.98 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 54.55 | 5676 / 0 |
| translucent_move_oit | still | 133.71 / 134.69 (0.7) | 133.71 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 20448 / 0 |
| renderer_off | still | 11.0 / 109.0 (89.9) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 14700 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 9.5 / 12.0 (20.8) | 9.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 441 / 0 |
| animated_items | still | 11.68 / 12.0 (2.7) | 11.68 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 48 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 23.96 | 0 / 0 |
| lights | still | 9.0 / 12.0 (25.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.288 / 0.332 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 101.576 / 0.581 | 0.029 / 0.008 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.357 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.85 |
| water_glass | 111.869 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.332 / 52.318 | 0.016 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 114.709 / 6.683 | 0.782 / 0.903 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 42.798 / 9.997 | 0.058 / 0.007 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 89.745 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_move | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.315 / 11.115 | 0.008 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.534 / 53.557 | 0.017 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 14.298 / 14.215 | 0.007 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 107.424 / 0.0 | 0.96 / 0.76 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 1.481 / 1.398 | 0.012 / 0.008 | 56 (2) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| renderer_off | 77.903 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.009 / 0.047 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| animation | 136.553 / 29.132 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.001 / 0.007 | 56 (2) | 40.58 / 8.298 / 32.283 | 3 / 0 | 9.988 |
| animated_items | 136.553 / 24.94 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (8) | 40.608 / 7.04 / 33.568 | 0 / 0 | 8.0 |
| block_entities | 76.539 / 13.333 | 1.0 / 0.988 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.848 / 9.875 | 0.004 / 0.006 | 56 (8) | 23.0 / 4.0 / 19.0 | 0 / 0 | 8.0 |
| lights | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (3) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |

GUI pass, core old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
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
| lights | 4.0 / 4.0 | 0.0 / 0.0 | 5.0 / 5.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

### Counts, core vulkan

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 14.14 (base 14.05) | 15 (base 15) | 29532 (base 27764) | 262.96 (base 257.2) | 8.23 (against vanilla, below) |
| flythrough | 13.03 (reported, not gated) | 42 (reported, not gated) | 810312 (reported, not gated) | 311.05 (base 318.06) | 7.71 (against vanilla, below) |
| water_glass | 8.92 (base 9.0) | 15 (base 15) | 11696 (base 15108) | 243.67 (base 244.39) | 8.23 (against vanilla, below) |
| nether | 13.28 (base 15.71) | 12 (base 12) | 9212 (base 19912) | 265.35 (base 268.95) | 8.23 (against vanilla, below) |
| mobs | 11.76 (base 19.97) | 17 (base 17) | 613596 (base 1008176) | 264.67 (base 264.31) | 8.23 (against vanilla, below) |
| outline | 9.67 (base 10.67) | 18 (base 18) | 5580 (base 6356) | 263.26 (base 264.58) | 8.23 (against vanilla, below) |
| occlusion | 14.68 (base 15.67) | 17 (base 15) | 116224 (base 126356) | 242.34 (base 264.78) | 4.23 (against vanilla, below) |
| occlusion_move | 11.49 (reported, not gated) | 15 (reported, not gated) | 82580 (reported, not gated) | 242.28 (base 265.16) | 4.23 (against vanilla, below) |
| occlusion_corner | 5.77 (reported, not gated) | 14 (reported, not gated) | 4756 (reported, not gated) | 246.53 (base 266.66) | 4.23 (against vanilla, below) |
| translucent_move | 8.91 (reported, not gated) | 15 (reported, not gated) | 11080 (reported, not gated) | 247.85 (base 268.35) | 3.98 (against vanilla, below) |
| water_glass_oit | 14.0 (base 14.0) | 15 (base 15) | 11696 (base 15024) | 235.41 (base 245.99) | 3.46 (against vanilla, below) |
| translucent_move_oit | 14.0 (reported, not gated) | 15 (reported, not gated) | 10632 (reported, not gated) | 236.96 (base 248.38) | 3.46 (against vanilla, below) |
| flat_plants | 8.75 (base 18.96) | 15 (base 15) | 4556 (base 9864) | 241.89 (base 248.07) | 3.2 (against vanilla, below) |
| renderer_off | 7.69 (base 7.83) | 14 (base 14) | 3564 (base 7180) | 234.02 (base 241.13) | 3.32 (against vanilla, below) |
| particles | 9.67 (base 9.67) | 15 (base 15) | 9124 (base 17128) | 238.1 (base 261.4) | 3.98 (against vanilla, below) |
| animation | 45 median (avg 36.93) (base 49) | 15 (base 15) | 2128 (base 2056) | 234.93 (base 260.68) | 5.98 (against vanilla, below) |
| animated_items | 55 median (avg 44.05) (base 60) | 24 (base 23) | 22100 (base 21940) | 234.67 (base 239.74) | 5.98 (against vanilla, below) |
| block_entities | 34.03 (base 34.15) | 17 (base 17) | 94688 (base 94912) | 234.09 (base 236.53) | 5.98 (against vanilla, below) |
| lights | 14.68 (base 14.67) | 17 (base 17) | 33664 (base 33664) | 287.94 (base 265.79) | 8.16 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-vk), core vulkan: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 14.14 / 14 (9.82) | 124.19 / 124 (10.81) | median and average, x 1.10 + 2 |
| flythrough | 13.03 / 13 (5.94) | 123.06 / 123 (5.86) | median and average, at most vanilla + 2 |
| water_glass | 8.92 / 9 (20.25) | 124.0 / 124 (18.5) | median, at most vanilla |
| nether | 13.28 / 16 (26.35) | 120.95 / 121 (18.36) | median, x 1.10 + 2 |
| mobs | 11.76 / 12 (26.13) | 114.75 / 134 (23.86) | median, x 1.10 + 2 |
| outline | 9.67 / 10 (29.81) | 87.27 / 126 (30.0) | median, x 1.10 + 2 |
| occlusion | 14.68 / 15 (29.63) | 99.12 / 136 (29.23) | median and average, x 1.10 + 2 |
| occlusion_move | 11.49 / 12 (29.44) | 96.14 / 133 (28.99) | median and average, x 1.10 + 2 |
| occlusion_corner | 5.77 / 6 (29.59) | 83.78 / 121 (29.41) | median and average, x 1.10 + 2 |
| translucent_move | 8.91 / 9 (21.45) | 123.38 / 124 (18.73) | median, at most vanilla |
| water_glass_oit | 14.0 / 14 (11.36) | 129.0 / 129 (10.24) | median, at most vanilla |
| translucent_move_oit | 14.0 / 14 (9.63) | 129.0 / 129 (9.57) | median and average, at most vanilla |
| flat_plants | 8.75 / 9 (24.57) | 123.81 / 124 (15.23) | median, x 1.10 + 2 |
| renderer_off | 7.69 / 8 (28.63) | 112.41 / 123 (21.39) | median, x 1.10 + 2 |
| particles | 9.67 / 10 (29.98) | 86.4 / 125 (29.95) | median and average, x 1.10 + 2 |
| animation | 36.93 / 45 (29.95) | 144.65 / 179 (29.91) | median, x 1.10 + 2 |
| animated_items | 44.05 / 55 (29.82) | 155.55 / 190 (29.9) | median, x 1.10 + 2 |
| block_entities | 34.03 / 41 (29.97) | 97.56 / 136 (29.95) | median and average, x 1.10 + 2 |
| lights | 14.68 / 15 (29.49) | 94.38 / 132 (29.5) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-vk), core vulkan (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool). Gated without Netty's pooled network buffers where both runs' benches show them in the JVM's pool (run-time fix, 2026-11-26: when the pool takes another chunk is packet timing, the same code in both runs):

| scene | Quicksilver end / peak | vanilla end / peak | of which Netty (Quicksilver / vanilla, end) | gated: Quicksilver end / peak | gated: vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|---|---|---|
| spawn | 8.23 / 8.23 | 5.98 / 5.98 | 7.54 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.38 |
| flythrough | 7.71 / 7.71 | 3.71 / 3.71 | 7.02 / 3.02 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.65 |
| water_glass | 8.23 / 8.23 | 5.98 / 5.98 | 7.54 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.65 |
| nether | 8.23 / 8.23 | 5.98 / 5.98 | 7.54 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.65 |
| mobs | 8.23 / 8.23 | 5.98 / 5.98 | 7.54 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 14.85 |
| outline | 8.23 / 8.23 | 5.98 / 5.98 | 7.54 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.08 |
| occlusion | 4.23 / 4.23 | 4.23 / 4.23 | 3.54 / 3.54 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.38 |
| occlusion_move | 4.23 / 4.23 | 4.23 / 4.23 | 3.54 / 3.54 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.65 |
| occlusion_corner | 4.23 / 4.23 | 4.23 / 4.23 | 3.54 / 3.54 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.08 |
| translucent_move | 3.98 / 3.98 | 3.98 / 3.98 | 3.29 / 3.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 14.01 |
| water_glass_oit | 3.46 / 3.46 | 3.46 / 3.46 | 2.77 / 2.77 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 11.81 |
| translucent_move_oit | 3.46 / 3.46 | 3.46 / 3.46 | 2.77 / 2.77 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 11.81 |
| flat_plants | 3.2 / 3.2 | 3.46 / 3.46 | 2.51 / 2.77 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 14.58 |
| renderer_off | 3.32 / 3.32 | 3.59 / 3.59 | 2.63 / 2.9 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.51 |
| particles | 3.98 / 3.98 | 3.98 / 3.98 | 3.29 / 3.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 14.58 |
| animation | 5.98 / 5.98 | 5.98 / 5.98 | 5.29 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 14.58 |
| animated_items | 5.98 / 5.98 | 5.98 / 5.98 | 5.29 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 14.58 |
| block_entities | 5.98 / 5.98 | 5.98 / 5.98 | 5.29 / 5.29 | 0.69 / 0.69 | 0.69 / 0.69 | 4.69 / 4.69 | 12.65 |
| lights | 8.16 / 8.16 | 4.23 / 4.23 | 7.54 / 3.54 | 0.63 / 0.63 | 0.69 / 0.69 | 4.69 / 4.69 | 13.8 |

Terrain GPU memory, core vulkan (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 56.0 / 23.234 | 56.0 / 23.234 | 0.0 / 0.0 | 416.0 / 39.208 |
| flythrough | 144.0 / 83.257 | 144.0 / 83.257 | 0.0 / 0.0 | 416.0 / 144.083 |
| water_glass | 56.0 / 12.553 | 56.0 / 12.553 | 0.0 / 0.0 | 416.0 / 21.628 |
| nether | 36.0 / 15.185 | 36.0 / 15.185 | 0.0 / 0.0 | 256.0 / 26.639 |
| mobs | 20.0 / 10.135 | 20.0 / 10.135 | 0.0 / 0.0 | 416.0 / 17.631 |
| outline | 20.0 / 1.472 | 20.0 / 1.472 | 0.0 / 0.0 | 256.0 / 2.595 |
| occlusion | 56.0 / 2.114 | 56.0 / 2.114 | 0.0 / 0.0 | 416.0 / 3.871 |
| occlusion_move | 56.0 / 3.4 | 56.0 / 3.4 | 0.0 / 0.0 | 416.0 / 6.101 |
| occlusion_corner | 56.0 / 1.931 | 56.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 28.0 / 13.358 | 28.0 / 13.358 | 0.0 / 0.0 | 416.0 / 23.301 |
| water_glass_oit | 28.0 / 12.463 | 28.0 / 12.463 | 0.0 / 0.0 | 416.0 / 21.628 |
| translucent_move_oit | 28.0 / 12.972 | 28.0 / 12.972 | 0.0 / 0.0 | 416.0 / 22.62 |
| flat_plants | 28.0 / 14.011 | 28.0 / 14.011 | 0.0 / 0.0 | 416.0 / 24.368 |
| renderer_off | 28.0 / 8.962 | 28.0 / 8.962 | 0.0 / 0.0 | 416.0 / 15.685 |
| particles | 28.0 / 0.131 | 28.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 28.0 / 0.297 | 28.0 / 0.297 | 0.0 / 0.0 | 256.0 / 0.536 |
| animated_items | 28.0 / 0.146 | 28.0 / 0.146 | 0.0 / 0.0 | 128.0 / 0.26 |
| block_entities | 28.0 / 0.143 | 28.0 / 0.143 | 0.0 / 0.0 | 256.0 / 0.247 |
| lights | 8.0 / 0.483 | 8.0 / 0.483 | 0.0 / 0.0 | 256.0 / 0.836 |


Package 4b, core vulkan: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-vk:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 453339.571 (620283.918) | 26.914 | 1.182 | 641820 / 846916 | 612288 (2097152.0) | 196 / 216 | 0.0 / 0 |
| flythrough | 527524.576 (843308.61) | 37.446 | 1.086 | 2120684 / 7965448 | 2095536 (2097152.0) | 118 / 117 | 7.16 / 53 |
| water_glass | 113293.738 (197772.327) | 42.715 | 1.133 | 13936 / 17332 | 0 (2097152.0) | 124 / 367 | 0.0 / 0 |
| nether | 38431.696 (57537.032) | 33.205 | 1.837 | 185444 / 454920 | 168256 (2097152.0) | 25 / 367 | 0.0 / 0 |
| mobs | 63131.713 (112835.272) | 44.05 | 0.967 | 773320 / 1206736 | 156864 (2097152.0) | 43 / 23 | 0.0 / 0 |
| outline | 1057.769 (2295.839) | 53.927 | 1.0 | 5580 / 6320 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 3935.663 (6126.057) | 35.755 | 1.183 | 179176 / 534516 | 61632 (2097152.0) | 6 / 19 | 0.0 / 0 |
| occlusion_move | 49674.116 (87172.201) | 43.016 | 1.229 | 701168 / 1216068 | 624384 (2097152.0) | 9 / 18 | 0.0 / 0 |
| occlusion_corner | 27771.436 (60488.351) | 54.088 | 1.272 | 36188 / 59420 | 31552 (2097152.0) | 5 / 10 | 0.0 / 0 |
| translucent_move | 207331.192 (369088.028) | 43.826 | 1.179 | 823640 / 1431196 | 812096 (2097152.0) | 54 / 309 | 0.0 / 0 |
| water_glass_oit | 113511.859 (198153.093) | 42.715 | 1.133 | 13824 / 16996 | 0 (2097152.0) | 227 / 204 | 0.0 / 0 |
| translucent_move_oit | 207969.865 (369875.021) | 43.773 | 1.178 | 822964 / 1431160 | 812096 (2097152.0) | 192 / 191 | 0.0 / 0 |
| flat_plants | 7240.326 (12227.625) | 40.787 | 1.048 | 269892 / 9908 | 259776 (2097152.0) | 127 / 304 | 0.0 / 0 |
| renderer_off | 21481.424 (40797.075) | 47.346 | 1.0 | 3564 / 7184 | 0 (2097152.0) | 11 / 58 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 9124 / 9204 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 2965.06 (5103.284) | 41.899 | 1.093 | 86704 / 150232 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 2119.248 (4603.839) | 53.968 | 1.0 | 79736 / 122964 | 57728 (2097152.0) | 11 / 10 | 0.0 / 0 |
| block_entities | 3461.76 (4439.387) | 22.022 | 1.6 | 136516 / 167284 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |
| lights | 11114.839 (14809.1) | 24.946 | 1.667 | 33664 / 33624 | 0 (2097152.0) | 13 / 11 | 0.0 / 0 |

Package 4c, core vulkan: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-vk:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 5.032 (463) | 2.44 (124) | 2.062 | 2.779 (72) | 0 | 1261 / 0 | 6.511 / 9.521 | 3.177 / 4.62 |
| flythrough | 6.923 (1499) | 5.66 (1556) | 1.223 | 6.923 (1499) | 0 | 1533 / 0 | 5.984 / 8.284 | 3.507 / 5.049 |
| water_glass | 1.592 (21) | 1.482 (16) | 1.074 | None (0) | 0 | 1572 / 0 | 6.067 / 8.712 | 3.081 / 4.37 |
| nether | 2.226 (38) | 1.613 (22) | 1.38 | 2.09 (15) | 0 | 2212 / 0 | 5.308 / 7.69 | 2.78 / 4.133 |
| mobs | 2.632 (68) | 2.176 (70) | 1.21 | 4.823 (1) | 0 | 2448 / 0 | 5.268 / 7.544 | 2.739 / 4.116 |
| outline | 0.434 (13) | 0.271 (13) | 1.601 | None (0) | 0 | 2507 / 0 | 5.211 / 7.48 | 2.732 / 4.079 |
| occlusion | 1.066 (30) | 2.08 (46) | 0.512 | 1.664 (2) | 0 | 1027 / 0 | 10.634 / 14.135 | 7.243 / 10.568 |
| occlusion_move | 1.668 (70) | 1.888 (61) | 0.883 | 3.346 (20) | 0 | 1193 / 0 | 9.433 / 12.536 | 5.797 / 9.258 |
| occlusion_corner | 1.146 (110) | 1.075 (94) | 1.066 | 1.537 (1) | 0 | 1473 / 0 | 8.013 / 10.574 | 4.113 / 6.678 |
| translucent_move | 2.027 (117) | 2.429 (118) | 0.834 | 2.622 (36) | 0 | 721 / 0 | 8.048 / 10.626 | 3.996 / 6.272 |
| water_glass_oit | 2.771 (153) | 2.755 (151) | 1.006 | None (0) | 0 | 311 / 0 | 8.628 / 10.848 | 3.697 / 5.089 |
| translucent_move_oit | 2.59 (220) | 3.038 (218) | 0.853 | 3.297 (27) | 0 | 873 / 0 | 4.925 / 6.324 | 2.223 / 2.942 |
| flat_plants | 1.626 (85) | 1.331 (82) | 1.222 | 2.469 (2) | 0 | 402 / 0 | 7.213 / 9.774 | 3.024 / 3.673 |
| renderer_off | 0.562 (22) | 0.428 (21) | 1.313 | None (0) | 0 | 315 / 0 | 7.683 / 11.022 | 3.609 / 5.118 |
| particles | 0.238 (30) | 0.217 (24) | 1.097 | None (0) | 0 | 750 / 0 | 7.756 / 10.238 | 3.653 / 5.815 |
| animation | 0.732 (18) | 0.614 (18) | 1.192 | 1.084 (4) | 0 | 823 / 0 | 7.129 / 9.406 | 3.009 / 4.567 |
| animated_items | 0.263 (43) | 0.228 (38) | 1.154 | 0.688 (2) | 0 | 853 / 0 | 6.895 / 9.099 | 2.755 / 4.259 |
| block_entities | 0.68 (83) | 0.67 (73) | 1.015 | 1.069 (1) | 0 | 935 / 0 | 6.363 / 8.383 | 2.394 / 3.202 |
| lights | 2.255 (21) | 2.021 (21) | 1.116 | None (0) | 0 | 2598 / 0 | 7.058 / 9.342 | 3.739 / 5.925 |

Terrain module, core vulkan (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | indirect, one multi-draw per arena and layer | 3.015 | 690.709 | 16 (vanilla 28) | 1401156 | 42.504 / 0.102 | 23.234 / 56.0 | 37.415 | 4140 / 0 | 2.779 (4.537) |
| flythrough | indirect, one multi-draw per arena and layer | 3.025 | 864.627 | 16 (vanilla 28) | 5038764 | 25.921 / 0.908 | 83.257 / 144.0 | 134.55 | 6677 / 0 | 6.923 (20.957) |
| water_glass | indirect, one multi-draw per arena and layer | 3.007 | 105.26 | 16 (vanilla 28) | 779356 | 37.064 / 0.094 | 12.553 / 56.0 | 20.811 | 4796 / 0 | None (None) |
| nether | indirect, one multi-draw per arena and layer | 2.004 | 57.655 | 16 (vanilla 28) | 953780 | 32.448 / 0.171 | 15.185 / 36.0 | 25.469 | 5885 / 0 | 2.09 (4.801) |
| mobs | indirect, one multi-draw per arena and layer | 2.004 | 61.211 | 16 (vanilla 28) | 628012 | 29.539 / 0.151 | 10.135 / 20.0 | 16.77 | 6453 / 0 | 4.823 (4.809) |
| outline | indirect, one multi-draw per arena and layer | 1.002 | 6.01 | 16 (vanilla 28) | 92996 | 29.131 / 0.151 | 1.472 / 20.0 | 2.483 | 6550 / 0 | None (None) |
| occlusion | indirect, one multi-draw per arena and layer | 2.01 | 11.383 | 16 (vanilla 28) | 132516 | 24.837 / 0.546 | 2.114 / 56.0 | 3.539 | 2264 / 0 | 1.664 (1.928) |
| occlusion_move | indirect, one multi-draw per arena and layer | 3.002 | 77.269 | 16 (vanilla 28) | 212308 | 21.201 / 0.463 | 3.4 / 56.0 | 5.669 | 2595 / 0 | 3.346 (7.571) |
| occlusion_corner | indirect, one multi-draw per arena and layer | 1.002 | 81.956 | 16 (vanilla 28) | 122728 | 18.501 / 0.404 | 1.931 / 56.0 | 3.277 | 2984 / 0 | 1.537 (1.534) |
| translucent_move | indirect, one multi-draw per arena and layer | 3.002 | 246.771 | 16 (vanilla 28) | 824952 | 17.523 / 0.082 | 13.358 / 28.0 | 22.029 | 1718 / 0 | 2.622 (7.794) |
| water_glass_oit | indirect, one multi-draw per arena and layer | 5.022 | 113.498 | 16 (vanilla 28) | 773728 | 8.524 / 0.042 | 12.463 / 28.0 | 20.661 | 894 / 0 | None (None) |
| translucent_move_oit | indirect, one multi-draw per arena and layer | 5.026 | 261.365 | 16 (vanilla 28) | 800516 | 6.959 / 0.113 | 12.972 / 28.0 | 21.376 | 2249 / 0 | 3.297 (8.954) |
| flat_plants | indirect, one multi-draw per arena and layer | 3.006 | 23.185 | 16 (vanilla 28) | 876640 | 5.618 / 0.0 | 14.011 / 28.0 | 23.409 | 937 / 0 | 2.469 (3.418) |
| renderer_off | indirect, one multi-draw per arena and layer | 3.005 | 22.038 | 16 (vanilla 28) | 561436 | 2.15 / 0.014 | 8.962 / 28.0 | 14.992 | 597 / 0 | None (None) |
| particles | indirect, one multi-draw per arena and layer | 1.002 | 8.013 | 16 (vanilla 28) | 8416 | 17.357 / 0.081 | 0.131 / 28.0 | 0.225 | 1764 / 0 | None (None) |
| animation | indirect, one multi-draw per arena and layer | 2.003 | 10.764 | 16 (vanilla 28) | 19088 | 16.91 / 0.079 | 0.297 / 28.0 | 0.51 | 1864 / 0 | 1.084 (1.475) |
| animated_items | indirect, one multi-draw per arena and layer | 1.002 | 11.708 | 16 (vanilla 28) | 9304 | 16.76 / 0.081 | 0.146 / 28.0 | 0.248 | 1912 / 0 | 0.688 (1.074) |
| block_entities | indirect, one multi-draw per arena and layer | 2.003 | 10.017 | 16 (vanilla 28) | 8864 | 15.932 / 0.076 | 0.143 / 28.0 | 0.237 | 2071 / 0 | 1.069 (1.067) |
| lights | indirect, one multi-draw per arena and layer | 1.002 | 9.015 | 16 (vanilla 28) | 30052 | 13.239 / 0.306 | 0.483 / 8.0 | 0.802 | 4935 / 0 | None (None) |

Translucency, core vulkan (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 141.0 | 1.0 | 0.0 | 0 | 0 | 58 (0.02 / 0.039 / 0.047; 0) | 0 | 27777 / 0 / 0 |
| flythrough | 181.134 | 1.0 | 0.0 | 0 | 0 | 808 (0.041 / 0.046 / 9.091; 0) | 38 | 21555 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1620 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1188 / 0 / 0 |
| occlusion_move | 2.0 | 1.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.014 / 0.019; 0) | 32 | 1178 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 1.0 | 0.0 | 0 | 0 | 180 (0.087 / 0.139 / 0.38; 0) | 180 | 3003 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 684 | 0 (None / None / None; 0) | 0 | 912 / 0 / 0 |
| translucent_move_oit | 7.0 | 3.0 | 0.0 | 0 | 579 | 0 (None / None / None; 0) | 0 | 1351 / 0 / 0 |
| flat_plants | 3.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1476 / 0 / 0 |
| renderer_off | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2296 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| lights | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core vulkan (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 349.513 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.046 (0.117; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 431.0 | 1.0 (0.0, 0.0) | 1.445 (0.0, 0.0) | 0.001 (0.011; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.017 (0.047; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.127 (0.226; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 46.0 | 11.0 (10.0, 1.0) | 9.0 (9.0, 1.0) | 0.07 (0.14; 0) | 0 | 1188 / 632016 / 0 / 0 |
| occlusion_move | 52.358 | 10.0 (9.0, 2.355) | 6.0 (6.0, 2.28) | 0.065 (0.181; 0) | 0 | 2730 / 1476772 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 134.38 | 1.0 (0.0, 0.0) | 0.769 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 134.223 | 1.0 (0.0, 0.0) | 0.746 (0.0, 0.0) | 0.002 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 109.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 12.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 12.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.048 (0.156; 0) | 0 | 0 / 0 / 0 / 0 |
| lights | 12.0 | 5.0 (2.0, 0.0) | 1.0 (1.0, 0.0) | 0.017 (0.041; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core vulkan (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 295.26 / 317.5 (7.0) | 295.26 / 0.0 / 0.0 | 0.14 | 0.0 (0.0, 0.0; 0.0) | 1973.6 | 988 / 0 |
| flythrough | still | 383.53 / 383.99 (0.1) | 383.53 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 8686 / 0 |
| nether | still | 46.09 / 187.0 (75.4) | 46.09 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 190.91 | 18450 / 0 |
| mobs | still | 32.6 / 110.0 (70.4) | 32.6 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 27.53 | 10140 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3278 / 0 |
| occlusion | still | 9.25 / 46.0 (79.9) | 9.25 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.24 | 5439 / 0 |
| occlusion_move | still | 52.12 / 52.31 (0.4) | 52.12 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 133.47 / 134.21 (0.6) | 133.47 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4816 / 0 |
| translucent_move_oit | still | 132.97 / 133.52 (0.4) | 132.97 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 10.15 / 150.0 (93.2) | 10.15 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 29.27 | 17061 / 0 |
| renderer_off | still | 11.0 / 109.0 (89.9) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 14014 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 9.74 / 12.0 (18.8) | 9.74 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1153.92 | 303 / 0 |
| animated_items | still | 11.68 / 12.0 (2.7) | 11.68 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4462.31 | 42 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 23.96 | 0 / 0 |
| lights | still | 9.0 / 12.0 (25.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 441 / 0 |

Effects, core vulkan (reported; draw calls per frame by what they draw for; vanilla = measure-vk):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.194 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 85.633 / 0.0 | 0.027 / 0.004 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.305 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.798 |
| water_glass | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 51.15 / 51.148 | 0.015 / 0.017 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 115.0 / 7.552 | 0.954 / 0.964 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 47.868 / 11.347 | 0.074 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 95.914 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 78.436 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_move | 78.454 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.002 / 0.0 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_corner | 78.098 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| translucent_move | 114.385 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 13.295 / 13.184 | 0.008 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 52.576 / 52.693 | 0.014 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 11.696 / 11.689 | 0.003 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 115.0 / 0.0 | 0.813 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.374 / 3.11 | 0.016 / 0.011 | 56 (2) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| renderer_off | 104.496 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.731 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.006 / 0.048 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| animation | 136.985 / 29.179 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.798 | 0.002 / 0.01 | 56 (2) | 40.608 / 8.293 / 32.315 | 3 / 0 | 9.983 |
| animated_items | 136.883 / 25.065 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (8) | 40.608 / 7.04 / 33.568 | 0 / 0 | 8.0 |
| block_entities | 76.795 / 13.333 | 0.982 / 0.91 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 9.017 / 9.037 | 0.005 / 0.008 | 56 (8) | 23.0 / 4.0 / 19.0 | 0 / 0 | 8.0 |
| lights | 77.708 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (3) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |

GUI pass, core vulkan (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
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
| lights | 4.0 / 4.0 | 0.0 / 0.0 | 5.0 / 5.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

### Counts, core old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 41.79 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 263.14 (base 256.29) | 5.99 (against vanilla, below) |
| flythrough | 55.57 (reported, not gated) | 46 (reported, not gated) | 707924 (reported, not gated) | 314.53 (base 324.79) | 3.48 (against vanilla, below) |
| water_glass | 20.95 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 244.0 (base 249.83) | 5.99 (against vanilla, below) |
| nether | 23.66 (base 33.79) | 10 (base 11) | 3728 (base 10656) | 265.6 (base 272.57) | 5.99 (against vanilla, below) |
| mobs | 18.76 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 264.6 (base 268.23) | 5.99 (against vanilla, below) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 263.21 (base 264.41) | 5.99 (against vanilla, below) |
| occlusion | 17.67 (base 22.67) | 15 (base 14) | 115228 (base 124172) | 245.02 (base 264.64) | 4.24 (against vanilla, below) |
| occlusion_move | 15.51 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 241.92 (base 265.66) | 4.24 (against vanilla, below) |
| occlusion_corner | 11.73 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 245.75 (base 267.41) | 4.24 (against vanilla, below) |
| translucent_move | 11.12 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 247.84 (base 268.19) | 4.24 (against vanilla, below) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7652 (base 7604) | 236.55 (base 245.78) | 3.73 (against vanilla, below) |
| translucent_move_oit | 18.42 (reported, not gated) | 13 (reported, not gated) | 2612 (reported, not gated) | 238.22 (base 248.15) | 3.73 (against vanilla, below) |
| flat_plants | 9.69 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 240.03 (base 248.11) | 5.21 (against vanilla, below) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.8 (base 240.73) | 3.34 (against vanilla, below) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 237.9 (base 261.4) | 4.24 (against vanilla, below) |
| animation | 45 median (avg 37.78) (base 49) | 13 (base 13) | 1716 (base 1716) | 234.97 (base 260.68) | 4.24 (against vanilla, below) |
| animated_items | 56 median (avg 44.52) (base 60) | 21 (base 22) | 21508 (base 21668) | 235.04 (base 239.53) | 4.24 (against vanilla, below) |
| block_entities | 35.98 (base 36.11) | 15 (base 15) | 94224 (base 95140) | 233.91 (base 236.55) | 4.24 (against vanilla, below) |
| lights | 15.67 (base 15.67) | 15 (base 15) | 33172 (base 33172) | 287.13 (base 265.68) | 8.18 (against vanilla, below) |

Draw calls against vanilla measured in the same run (measure-old), core old-gpu-2p: average and median per frame; translucent scenes (ci/vanilla-draw-calls.json) at most vanilla's, the others at most vanilla's x 1.10 + 2:

| scene | Quicksilver avg / median (fps) | vanilla avg / median (fps) | gated on |
|---|---|---|---|
| spawn | 41.79 / 42 (9.98) | 848.29 / 848 (12.18) | median and average, x 1.10 + 2 |
| flythrough | 55.57 / 56 (6.57) | 1025.82 / 1026 (7.46) | median and average, at most vanilla |
| water_glass | 20.95 / 21 (19.51) | 387.84 / 391 (20.24) | median, at most vanilla |
| nether | 23.66 / 26 (27.55) | 587.49 / 588 (19.8) | median, x 1.10 + 2 |
| mobs | 18.76 / 19 (26.37) | 309.53 / 335 (25.54) | median, x 1.10 + 2 |
| outline | 11.67 / 12 (29.99) | 128.27 / 167 (30.01) | median, x 1.10 + 2 |
| occlusion | 17.67 / 18 (30.0) | 148.33 / 187 (30.01) | median and average, x 1.10 + 2 |
| occlusion_move | 15.51 / 16 (29.96) | 168.57 / 203 (30.0) | median and average, x 1.10 + 2 |
| occlusion_corner | 11.73 / 12 (29.96) | 163.2 / 201 (30.0) | median and average, x 1.10 + 2 |
| translucent_move | 11.12 / 11 (26.7) | 367.24 / 366 (16.6) | median, at most vanilla |
| water_glass_oit | 26.0 / 26 (11.3) | 400.0 / 400 (8.15) | median, at most vanilla |
| translucent_move_oit | 18.42 / 18 (11.73) | 382.53 / 383 (8.74) | median and average, at most vanilla |
| flat_plants | 9.69 / 10 (29.1) | 391.32 / 399 (21.27) | median, x 1.10 + 2 |
| renderer_off | 13.67 / 14 (29.81) | 285.58 / 323 (29.51) | median, x 1.10 + 2 |
| particles | 11.67 / 12 (30.0) | 97.27 / 136 (30.01) | median and average, x 1.10 + 2 |
| animation | 37.78 / 45 (30.0) | 155.22 / 190 (30.0) | median, x 1.10 + 2 |
| animated_items | 44.52 / 56 (30.01) | 166.28 / 201 (30.0) | median, x 1.10 + 2 |
| block_entities | 35.98 / 43 (30.0) | 105.38 / 144 (30.01) | median and average, x 1.10 + 2 |
| lights | 15.67 / 16 (30.0) | 104.27 / 143 (30.0) | median and average, x 1.10 + 2 |

Direct buffers against vanilla measured in the same run (measure-old), core old-gpu-2p (MB at the end of each scene; at most vanilla's + 4.0, one step of the JVM's direct pool). Gated without Netty's pooled network buffers where both runs' benches show them in the JVM's pool (run-time fix, 2026-11-26: when the pool takes another chunk is packet timing, the same code in both runs):

| scene | Quicksilver end / peak | vanilla end / peak | of which Netty (Quicksilver / vanilla, end) | gated: Quicksilver end / peak | gated: vanilla end / peak | limit end / peak | ceiling (baseline x 1.10 + 8.0) |
|---|---|---|---|---|---|---|---|
| spawn | 5.99 / 5.99 | 3.99 / 3.99 | 5.29 / 3.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| flythrough | 3.48 / 3.48 | 3.48 / 3.48 | 2.77 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| water_glass | 5.99 / 5.99 | 3.99 / 3.99 | 5.29 / 3.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| nether | 5.99 / 5.99 | 3.99 / 3.99 | 5.29 / 3.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| mobs | 5.99 / 5.99 | 5.99 / 5.99 | 5.29 / 5.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| outline | 5.99 / 5.99 | 5.99 / 5.99 | 5.29 / 5.29 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| occlusion | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| occlusion_move | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| occlusion_corner | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| translucent_move | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| water_glass_oit | 3.73 / 3.73 | 3.48 / 3.48 | 3.02 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| translucent_move_oit | 3.73 / 3.73 | 3.48 / 3.48 | 3.02 / 2.77 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.1 |
| flat_plants | 5.21 / 5.21 | 3.35 / 3.35 | 4.51 / 2.65 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| renderer_off | 3.34 / 3.34 | 3.6 / 3.6 | 2.63 / 2.9 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.46 |
| particles | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| animation | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 12.66 |
| animated_items | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 14.59 |
| block_entities | 4.24 / 4.24 | 4.24 / 4.24 | 3.54 / 3.54 | 0.71 / 0.71 | 0.71 / 0.71 | 4.71 / 4.71 | 17.06 |
| lights | 8.18 / 8.18 | 4.24 / 4.24 | 7.54 / 3.54 | 0.64 / 0.64 | 0.71 / 0.71 | 4.71 / 4.71 | 14.39 |

Terrain GPU memory, core old-gpu-2p (MB; reserved in the Quicksilver run must not be more than vanilla's):

| scene | Quicksilver run reserved / used | of which Quicksilver's arenas | of which vanilla's heaps | vanilla (measure run) reserved / used |
|---|---|---|---|---|
| spawn | 64.0 / 23.582 | 64.0 / 23.582 | 0.0 / 0.0 | 416.0 / 37.373 |
| flythrough | 128.0 / 83.916 | 128.0 / 83.916 | 0.0 / 0.0 | 416.0 / 142.963 |
| water_glass | 48.0 / 12.715 | 48.0 / 12.715 | 0.0 / 0.0 | 416.0 / 21.91 |
| nether | 32.0 / 15.187 | 32.0 / 15.187 | 0.0 / 0.0 | 256.0 / 26.636 |
| mobs | 48.0 / 10.135 | 48.0 / 10.135 | 0.0 / 0.0 | 416.0 / 17.63 |
| outline | 48.0 / 1.472 | 48.0 / 1.472 | 0.0 / 0.0 | 256.0 / 2.595 |
| occlusion | 48.0 / 7.508 | 48.0 / 7.508 | 0.0 / 0.0 | 416.0 / 11.696 |
| occlusion_move | 48.0 / 3.437 | 48.0 / 3.437 | 0.0 / 0.0 | 416.0 / 5.819 |
| occlusion_corner | 48.0 / 1.931 | 48.0 / 1.931 | 0.0 / 0.0 | 128.0 / 3.436 |
| translucent_move | 48.0 / 13.47 | 48.0 / 13.47 | 0.0 / 0.0 | 416.0 / 22.835 |
| water_glass_oit | 48.0 / 12.463 | 48.0 / 12.463 | 0.0 / 0.0 | 416.0 / 21.628 |
| translucent_move_oit | 48.0 / 13.068 | 48.0 / 13.068 | 0.0 / 0.0 | 416.0 / 22.153 |
| flat_plants | 64.0 / 14.124 | 64.0 / 14.124 | 0.0 / 0.0 | 416.0 / 24.414 |
| renderer_off | 48.0 / 8.962 | 48.0 / 8.962 | 0.0 / 0.0 | 416.0 / 15.703 |
| particles | 48.0 / 0.131 | 48.0 / 0.131 | 0.0 / 0.0 | 128.0 / 0.235 |
| animation | 48.0 / 0.297 | 48.0 / 0.297 | 0.0 / 0.0 | 256.0 / 0.536 |
| animated_items | 48.0 / 0.146 | 48.0 / 0.146 | 0.0 / 0.0 | 128.0 / 0.26 |
| block_entities | 48.0 / 0.142 | 48.0 / 0.142 | 0.0 / 0.0 | 256.0 / 0.247 |
| lights | 32.0 / 0.508 | 32.0 / 0.508 | 0.0 / 0.0 | 256.0 / 0.851 |


Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting; vanilla from measure-old:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver / vanilla | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver / vanilla | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 371536.121 (557493.025) | 33.356 | 1.773 | 541060 / 769620 | 539456 (2097152.0) | 199 / 243 | 0.0 / 0 |
| flythrough | 463789.435 (729507.206) | 36.424 | 1.089 | 2102028 / 7285272 | 2092328 (2097152.0) | 131 / 149 | 8.212 / 67 |
| water_glass | 113303.779 (197789.856) | 42.715 | 1.133 | 8996 / 11876 | 0 (2097152.0) | 130 / 93 | 0.0 / 0 |
| nether | 29505.549 (42402.956) | 30.416 | 2.0 | 235700 / 407584 | 232064 (2097152.0) | 135 / 140 | 0.0 / 0 |
| mobs | 62315.799 (111348.489) | 44.035 | 0.967 | 610676 / 928004 | 0 (2097152.0) | 89 / 11 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 / 5460 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion | 3702.17 (5717.529) | 35.249 | 1.182 | 115228 / 127084 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_move | 21007.553 (36713.41) | 42.78 | 1.275 | 716560 / 1196252 | 642624 (2097152.0) | 0 / 0 | 0.0 / 0 |
| occlusion_corner | 21833.74 (47202.597) | 53.745 | 1.215 | 32840 / 57800 | 31552 (2097152.0) | 1 / 0 | 0.0 / 0 |
| translucent_move | 21565.154 (27555.659) | 21.74 | 1.004 | 817368 / 1426612 | 812096 (2097152.0) | 130 / 331 | 0.0 / 0 |
| water_glass_oit | 113514.062 (198156.938) | 42.715 | 1.133 | 162836 / 285028 | 156864 (2097152.0) | 226 / 162 | 0.0 / 0 |
| translucent_move_oit | 21706.744 (27787.65) | 21.883 | 1.005 | 816676 / 1425988 | 812096 (2097152.0) | 234 / 174 | 0.0 / 0 |
| flat_plants | 5349.191 (8724.991) | 38.691 | 1.048 | 1940 / 4292 | 0 (2097152.0) | 140 / 53 | 0.0 / 0 |
| renderer_off | 21479.98 (40794.332) | 47.346 | 1.0 | 1380 / 3124 | 0 (2097152.0) | 38 / 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 / 8964 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animation | 2913.215 (4982.664) | 41.533 | 1.1 | 86324 / 149880 | 84608 (2097152.0) | 0 / 0 | 0.0 / 0 |
| animated_items | 1674.782 (3581.95) | 53.244 | 1.0 | 79236 / 122884 | 57728 (2097152.0) | 0 / 1 | 0.0 / 0 |
| block_entities | 3461.76 (4439.387) | 22.022 | 1.6 | 135472 / 167524 | 41472 (2097152.0) | 0 / 0 | 0.0 / 0 |
| lights | 11114.493 (14808.64) | 24.946 | 1.667 | 33172 / 33364 | 0 (2097152.0) | 0 / 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets), Quicksilver's mesher against vanilla's compiler in measure-old:

| scene | Quicksilver ms/section (sections) | vanilla ms/section (sections) | Quicksilver / vanilla | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|---|---|
| spawn | 5.725 (451) | 2.661 (106) | 2.151 | 4.488 (49) | 0 | 1243 / 0 | 7.096 / 9.384 | 3.578 / 4.846 |
| flythrough | 6.08 (1582) | 5.123 (1595) | 1.187 | 6.08 (1582) | 0 | 1503 / 0 | 6.431 / 8.976 | 4.176 / 5.987 |
| water_glass | 1.967 (18) | 1.113 (14) | 1.767 | None (0) | 0 | 1558 / 0 | 6.572 / 8.575 | 3.468 / 4.604 |
| nether | 2.039 (34) | 2.216 (24) | 0.92 | 2.081 (20) | 0 | 2195 / 0 | 5.683 / 7.487 | 3.023 / 4.07 |
| mobs | 3.623 (67) | 2.921 (75) | 1.24 | None (0) | 0 | 2435 / 0 | 5.632 / 7.381 | 2.995 / 4.051 |
| outline | 0.429 (13) | 0.25 (13) | 1.716 | None (0) | 0 | 2494 / 0 | 5.578 / 7.314 | 2.973 / 4.039 |
| occlusion | 1.95 (122) | 4.519 (114) | 0.432 | None (0) | 0 | 1254 / 0 | 5.205 / 7.26 | 2.054 / 3.673 |
| occlusion_move | 1.073 (65) | 1.931 (68) | 0.556 | 2.549 (18) | 0 | 1406 / 0 | 4.781 / 6.671 | 1.883 / 2.987 |
| occlusion_corner | 0.619 (110) | 1.147 (82) | 0.54 | 0.817 (1) | 0 | 1690 / 0 | 4.132 / 5.749 | 1.544 / 2.335 |
| translucent_move | 2.31 (111) | 4.327 (104) | 0.534 | 3.894 (33) | 0 | 738 / 0 | 7.514 / 9.719 | 3.228 / 5.124 |
| water_glass_oit | 2.997 (157) | 4.832 (150) | 0.62 | 3.533 (1) | 0 | 307 / 0 | 7.38 / 9.772 | 2.915 / 4.597 |
| translucent_move_oit | 2.602 (227) | 4.792 (212) | 0.543 | 3.594 (26) | 0 | 862 / 0 | 4.445 / 6.057 | 1.875 / 2.68 |
| flat_plants | 0.837 (99) | 1.128 (89) | 0.742 | None (0) | 0 | 400 / 0 | 4.77 / 7.139 | 1.675 / 1.92 |
| renderer_off | 0.288 (24) | 0.496 (21) | 0.581 | None (0) | 0 | 315 / 0 | 4.167 / 5.546 | 1.591 / 2.62 |
| particles | 0.196 (30) | 0.237 (24) | 0.827 | None (0) | 0 | 766 / 0 | 7.255 / 9.38 | 2.892 / 4.57 |
| animation | 0.616 (18) | 1.688 (18) | 0.365 | 0.954 (4) | 0 | 839 / 0 | 6.677 / 8.625 | 2.388 / 3.614 |
| animated_items | 0.269 (32) | 0.257 (38) | 1.047 | 0.627 (2) | 0 | 869 / 0 | 6.464 / 8.345 | 2.281 / 3.295 |
| block_entities | 0.564 (60) | 0.793 (60) | 0.711 | 0.764 (1) | 0 | 951 / 0 | 5.968 / 7.7 | 1.977 / 2.774 |
| lights | 3.396 (21) | 1.846 (21) | 1.84 | None (0) | 0 | 2859 / 0 | 3.669 / 5.04 | 1.45 / 2.218 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 30.151 | 610.05 | 16 (vanilla 28) | 1420576 | 42.219 / 0.101 | 23.582 / 64.0 | 37.933 | 4028 / 0 | 4.488 (8.812) |
| flythrough | plain, one multi-draw per region and layer | 44.794 | 735.916 | 16 (vanilla 28) | 5075780 | 24.855 / 0.921 | 83.916 / 128.0 | 135.538 | 6792 / 0 | 6.08 (18.176) |
| water_glass | plain, one multi-draw per region and layer | 14.036 | 105.269 | 16 (vanilla 28) | 788080 | 36.826 / 0.092 | 12.715 / 48.0 | 21.044 | 4688 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.022 | 43.078 | 16 (vanilla 28) | 953780 | 32.209 / 0.16 | 15.187 / 32.0 | 25.469 | 5765 / 0 | 2.081 (3.051) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.114 | 16 (vanilla 28) | 628008 | 29.296 / 0.142 | 10.135 / 48.0 | 16.77 | 6339 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 92996 | 28.887 / 0.141 | 1.472 / 48.0 | 2.483 | 6436 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 4.007 | 11.018 | 16 (vanilla 28) | 423048 | 26.292 / 0.929 | 7.508 / 48.0 | 11.297 | 2947 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.87 | 16 (vanilla 28) | 213380 | 23.413 / 0.823 | 3.437 / 48.0 | 5.698 | 3240 / 0 | 2.549 (6.335) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.07 | 60.885 | 16 (vanilla 28) | 122728 | 20.935 / 0.736 | 1.931 / 48.0 | 3.277 | 3637 / 0 | 0.817 (0.813) |
| translucent_move | plain, one multi-draw per region and layer | 4.376 | 23.075 | 16 (vanilla 28) | 831280 | 15.052 / 0.081 | 13.47 / 48.0 | 22.198 | 1692 / 0 | 3.894 (10.159) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.071 | 113.5 | 16 (vanilla 28) | 773732 | 8.524 / 0.042 | 12.463 / 48.0 | 20.661 | 894 / 0 | 3.533 (3.523) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.453 | 37.265 | 16 (vanilla 28) | 806808 | 7.166 / 0.12 | 13.068 / 48.0 | 21.544 | 2240 / 0 | 3.594 (10.236) |
| flat_plants | plain, one multi-draw per region and layer | 3.005 | 21.036 | 16 (vanilla 28) | 882312 | 6.227 / 0.0 | 14.124 / 64.0 | 23.56 | 963 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 561436 | 2.157 / 0.014 | 8.962 / 48.0 | 14.992 | 600 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 14.918 / 0.08 | 0.131 / 48.0 | 0.225 | 1736 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 19088 | 14.536 / 0.078 | 0.297 / 48.0 | 0.51 | 1836 / 0 | 0.954 (1.364) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 6.01 | 16 (vanilla 28) | 9304 | 14.409 / 0.08 | 0.146 / 48.0 | 0.248 | 1883 / 0 | 0.627 (0.897) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 13.824 / 0.076 | 0.142 / 48.0 | 0.237 | 2019 / 0 | 0.764 (0.76) |
| lights | plain, one multi-draw per region and layer | 1.002 | 9.015 | 16 (vanilla 28) | 31636 | 14.893 / 0.49 | 0.508 / 32.0 | 0.845 | 5667 / 0 | None (None) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 144.0 | 8.0 | 0.0 | 0 | 0 | 40 (0.038 / 0.047 / 0.068; 0) | 0 | 28800 / 0 / 0 |
| flythrough | 184.083 | 8.318 | 0.0 | 0 | 0 | 840 (0.045 / 0.063 / 6.774; 0) | 43 | 24299 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1564 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.01; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.106 / 0.143 / 3.146; 0) | 180 | 3745 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 681 | 0 (None / None / None; 0) | 0 | 908 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 705 | 0 (None / None / None; 0) | 0 | 1645 / 0 / 0 |
| flat_plants | 3.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1746 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2388 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| lights | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 354.0 | 1.24 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.038 (0.493; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.008 | 1.0 (0.0, 0.0) | 1.197 (0.0, 0.0) | 0.002 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.062; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (63.881, 0.0) | 0.0 (0.0, 0.0) | 0.148 (2.256; 1) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 39.0 | 11.0 (10.0, 1.0) | 9.0 (9.0, 1.0) | 0.06 (0.142; 0) | 0 | 1200 / 638400 / 0 / 0 |
| occlusion_move | 52.364 | 10.0 (9.0, 2.359) | 6.0 (6.0, 2.273) | 0.053 (0.184; 0) | 0 | 2784 / 1507660 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.531 | 1.0 (0.0, 0.0) | 0.783 (0.0, 0.0) | 0.002 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.519 | 1.0 (0.0, 0.0) | 0.753 (0.0, 0.0) | 0.005 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 109.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 12.0 | 1.0 (0.0, 0.0) | 2.59 (0.0, 0.0) | 0.001 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 12.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.041 (0.127; 0) | 0 | 0 / 0 / 0 / 0 |
| lights | 12.0 | 5.0 (2.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.117; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 248.0 / 322.0 (23.0) | 248.0 / 74.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3626 / 0 |
| flythrough | two-phase | 303.92 / 390.19 (22.1) | 296.8 / 93.39 / 7.13 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 2793 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 8428 / 0 |
| nether | two-phase | 37.0 / 187.0 (80.2) | 37.0 / 150.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 20700 / 0 |
| mobs | two-phase | 32.0 / 110.0 (70.9) | 32.0 / 78.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10296 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3278 / 0 |
| occlusion | two-phase | 9.0 / 39.0 (76.9) | 9.0 / 30.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4500 / 0 |
| occlusion_move | two-phase | 22.41 / 52.32 (57.2) | 22.35 / 29.97 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4490 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.68 / 21.18 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3164 / 0 |
| translucent_move | two-phase | 15.66 / 136.39 (88.5) | 15.64 / 120.75 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 16180 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4816 / 0 |
| translucent_move_oit | two-phase | 15.68 / 135.96 (88.5) | 15.64 / 120.32 / 0.04 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7101 / 0 |
| flat_plants | two-phase | 9.0 / 150.0 (94.0) | 9.0 / 141.0 / 0.0 | 1.0 | 0.0 (0.0, 0.04; 100.0) | 14400.0 | 20445 / 0 |
| renderer_off | two-phase | 11.0 / 109.0 (89.9) | 11.0 / 98.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 14602 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 9.0 / 12.0 (25.0) | 9.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 6.0 / 12.0 (50.0) | 6.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 906 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| lights | two-phase | 9.0 / 12.0 (25.0) | 9.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = measure-old):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | 115.0 / 5.0 | 0.288 / 0.553 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 101.18 / 0.64 | 0.032 / 0.015 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | 115.0 / 5.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.541 / 0.0 | 0.007 / 0.003 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.826 |
| water_glass | 111.869 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 53.913 / 53.946 | 0.019 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | 114.709 / 7.255 | 0.782 / 0.684 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 39.95 / 4.396 | 0.071 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | 89.745 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_move | 76.539 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| occlusion_corner | 76.667 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| translucent_move | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 12.167 / 12.168 | 0.008 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| water_glass_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 54.848 / 54.824 | 0.015 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | 115.0 / 0.0 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 10.511 / 10.43 | 0.004 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | 107.424 / 0.0 | 0.96 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 3.245 / 2.988 | 0.02 / 0.012 | 56 (2) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| renderer_off | 77.903 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | 76.603 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 66.0 / 66.0 | 0.004 / 0.033 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 0.0 |
| animation | 136.553 / 29.114 | 1.0 / 1.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 2.8 / 2.797 | 0.005 / 0.007 | 56 (2) | 40.608 / 8.288 / 32.32 | 3 / 0 | 9.977 |
| animated_items | 136.553 / 24.859 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (8) | 40.536 / 7.025 / 33.511 | 0 / 0 | 8.0 |
| block_entities | 76.539 / 13.333 | 1.0 / 0.86 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 7.943 / 7.965 | 0.003 / 0.007 | 56 (8) | 23.0 / 4.0 / 19.0 | 0 / 0 | 8.0 |
| lights | 76.603 / 0.0 | 0.0 / 0.0 | 3.0 / 3.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (3) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |

GUI pass, core old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| flythrough | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| water_glass | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| nether | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| mobs | 1.0 / 1.0 | 0.0 / 0.0 | 1.0 / 1.0 | 1.0 / 1.0 (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / 1.0 (1.0 / 1.0) |
| outline | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
| occlusion | 3.0 / 3.0 | 0.0 / 0.0 | 4.0 / 4.0 | 3.0 / 3.0 (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / 3.0 (3.0 / 3.0) |
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
| lights | 4.0 / 4.0 | 0.0 / 0.0 | 5.0 / 5.0 | 4.0 / 4.0 (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / 4.0 (4.0 / 4.0) |

## Bench-only jar (quicksilver-bench)

| run | scene | fps avg | frame time p99 ms | frames over 50 ms | draw calls/frame (median) | largest upload bytes in one frame | counters missing |
|---|---|---|---|---|---|---|---|
| bench-plain | spawn | 12.63 | 95.54 | 252 | 124 | 944208 | [] |
| bench-plain | flythrough | 6.79 | 318.97 | 135 | 123 | 7035784 | [] |
| bench-plain | water_glass | 21.6 | 60.14 | 26 | 124 | 16660 | [] |
| bench-plain | nether | 19.43 | 61.13 | 317 | 121 | 341028 | [] |
| bench-sodium | spawn | 10.58 | 118.12 | 211 | 149 | 8936 | [] |
| bench-sodium | flythrough | 6.56 | 316.95 | 131 | 158 | 266476 | [] |
| bench-sodium | water_glass | 19.45 | 66.51 | 226 | 135 | 10236 | [] |
| bench-sodium | nether | 26.24 | 50.02 | 6 | 129 | 264112 | [] |

## Single-player run (server-aware meshing)

| state | single player | server tick ms avg (budget) | ticks backed off / ticks | sections meshed while behind | most runs at once while behind | ms behind | of it no run meshing with work waiting | restarts |
|---|---|---|---|---|---|---|---|---|
| on | True | 53.578 (50.0) | 726 / 726 | 1505 | 1 | 40546.748 | 7.201 (0.0) | 1114 |

## Direct buffers per scene (gated against the same-run measure run and the ceiling, see the counts)

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
| core-measure-full | spawn | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | outline | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | flythrough | 5.09 | 5.48 (194) | 5.48 |  |
| core-measure-full | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | block_entities | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | lights | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-full | water_glass_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-measure-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-full | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-measure-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | lights | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | flat_plants | 3.35 | 3.35 (0) | 3.35 |  |
| core-measure-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-measure-old | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-measure-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-measure-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | flythrough | 3.09 | 3.48 (194) | 3.48 |  |
| core-measure-old | block_entities | 4.24 | 4.24 (0) | 4.24 |  |
| core-measure-old | water_glass_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-measure-vk | spawn | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | occlusion | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | water_glass | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | nether | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | occlusion_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | mobs | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | occlusion_corner | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | translucent_move | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | outline | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | lights | 4.23 | 4.23 (0) | 4.23 |  |
| core-measure-vk | particles | 3.98 | 3.98 (0) | 3.98 |  |
| core-measure-vk | flythrough | 3.32 | 3.71 (195) | 3.71 |  |
| core-measure-vk | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | animation | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | animated_items | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | renderer_off | 3.59 | 3.59 (0) | 3.59 |  |
| core-measure-vk | block_entities | 5.98 | 5.98 (0) | 5.98 |  |
| core-measure-vk | water_glass_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-measure-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-2p-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | block_entities | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | spawn | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | water_glass | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | nether | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | flythrough | 3.09 | 3.48 (195) | 3.48 |  |
| core-quicksilver-2p-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-2p-old | lights | 8.18 | 8.18 (0) | 8.18 |  |
| core-quicksilver-2p-old | flat_plants | 5.21 | 5.21 (0) | 5.21 |  |
| core-quicksilver-2p-old | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-full | translucent_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | particles | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-full | block_entities | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | water_glass_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-full | lights | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-full | spawn | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-full | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-full | water_glass | 8.24 | 8.24 (0) | 8.24 | between scenes +4.78 |
| core-quicksilver-full | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-full | nether | 8.24 | 8.24 (0) | 8.24 | between scenes +4.90 |
| core-quicksilver-full | mobs | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-full | outline | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-full | flythrough | 3.09 | 3.48 (194) | 3.48 |  |
| core-quicksilver-old | occlusion | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | translucent_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | particles | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | occlusion_move | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | animation | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | occlusion_corner | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | animated_items | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | block_entities | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | water_glass_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | lights | 8.31 | 8.31 (0) | 8.24 | between scenes +4.83 |
| core-quicksilver-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | flat_plants | 5.21 | 5.21 (0) | 5.21 |  |
| core-quicksilver-old | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-old | spawn | 8.24 | 8.24 (0) | 8.24 | between scenes +4.90 |
| core-quicksilver-old | water_glass | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | nether | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | mobs | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | outline | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | flythrough | 3.34 | 3.73 (193) | 3.73 |  |
| core-quicksilver-vk | translucent_move | 3.98 | 3.98 (0) | 3.98 |  |
| core-quicksilver-vk | spawn | 8.23 | 8.23 (0) | 8.23 | between scenes +4.25 |
| core-quicksilver-vk | particles | 3.98 | 3.98 (0) | 3.98 |  |
| core-quicksilver-vk | water_glass | 8.23 | 8.23 (0) | 8.23 | between scenes +4.25 |
| core-quicksilver-vk | animation | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | nether | 8.23 | 8.23 (0) | 8.23 |  |
| core-quicksilver-vk | animated_items | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | mobs | 8.23 | 8.23 (0) | 8.23 |  |
| core-quicksilver-vk | block_entities | 5.98 | 5.98 (0) | 5.98 |  |
| core-quicksilver-vk | outline | 8.23 | 8.23 (0) | 8.23 |  |
| core-quicksilver-vk | water_glass_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | flythrough | 7.32 | 7.71 (195) | 7.71 |  |
| core-quicksilver-vk | translucent_move_oit | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-vk | occlusion | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | occlusion_move | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | occlusion_corner | 4.23 | 4.23 (0) | 4.23 |  |
| core-quicksilver-vk | lights | 8.16 | 8.16 (0) | 8.16 |  |
| core-quicksilver-vk | flat_plants | 3.2 | 3.2 (0) | 3.2 |  |
| core-quicksilver-vk | renderer_off | 3.32 | 3.32 (0) | 3.32 |  |
| core-sp-quicksilver | flythrough | 1.38 | 1.39 (95) | 1.39 |  |
| core-speed-full | water_glass | 4.24 | 4.24 (0) | 4.24 |  |
| core-speed-full | nether | 4.24 | 4.24 (0) | 4.24 |  |
| core-speed-full | mobs | 4.24 | 4.24 (0) | 4.24 |  |
| core-speed-full | lights | 3.29 | 3.29 (0) | 3.29 |  |
| core-speed-full | spawn | 4.31 | 4.31 (0) | 4.31 |  |
| core-speed-full | flythrough | 4.31 | 4.31 (0) | 4.31 |  |
| core-speed-full | block_entities | 3.73 | 3.73 (0) | 3.73 |  |
| core-speed-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-speed-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-speed-old | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-speed-old | lights | 3.48 | 3.48 (0) | 3.35 |  |
| core-speed-old | spawn | 4.31 | 4.31 (0) | 4.31 |  |
| core-speed-old | flythrough | 4.31 | 4.31 (0) | 4.31 |  |
| core-speed-old | block_entities | 3.03 | 3.03 (0) | 3.03 |  |
| create-quicksilver-smoke | create_smoke | 3.99 | 3.99 (0) | 3.99 |  |
| far-far-amplified | far_amplified | 3.6 | 3.6 (0) | 3.6 |  |
| far-far-default | far_flat | 3.73 | 3.73 (0) | 3.73 |  |
| far-far-default | far_seen1_default | 3.02 | 3.02 (0) | 3.02 |  |
| far-far-default | far_seen2_default | 3.14 | 3.14 (0) | 3.14 |  |
| far-far-flat | far_flat | 3.54 | 3.54 (0) | 3.54 |  |
| far-far-flight | far_flight | 4.37 | 4.37 (0) | 4.37 |  |
| far-far-flight | far_relog | 3.79 | 3.79 (0) | 3.79 |  |
| far-far-largebiomes | far_largebiomes | 3.79 | 3.79 (0) | 3.79 |  |
| far-far-nullscape | far_nullscape | 3.6 | 3.6 (0) | 3.6 |  |
| far-far-nullscape | far_end | 3.6 | 3.6 (0) | 3.6 |  |
| far-far-terralith | far_nether | 5.54 | 5.54 (0) | 5.54 |  |
| far-far-terralith | far_land | 5.35 | 5.35 (0) | 5.35 |  |
| far-far-terralith | far_cliff | 4.31 | 4.31 (0) | 4.31 |  |
| far-far-terralith | far_views | 8.12 | 8.12 (0) | 8.12 |  |
| far-far-vanilla | far_seen1_vanilla | 4.31 | 4.31 (0) | 4.31 |  |
| far-far-vanilla | far_seen2_vanilla | 3.79 | 3.79 (0) | 3.79 |  |

Rises of 4 MB or more: core-quicksilver-full/water_glass: between scenes +4.78; core-quicksilver-full/nether: between scenes +4.90; core-quicksilver-old/lights: between scenes +4.83; core-quicksilver-old/spawn: between scenes +4.90; core-quicksilver-vk/spawn: between scenes +4.25; core-quicksilver-vk/water_glass: between scenes +4.25

