# Quicksilver CI comparison

**FAILED**

- core/mobs.far: no pixel limit in ci/pixel-limits.json
- core/mobs.far: no pixel limit in ci/pixel-limits.json
- core/mobs.far: no strict pixel limit in ci/strict-pixel-limits.json
- core/mobs.far: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities: no pixel limit in ci/pixel-limits.json
- core/block_entities: no pixel limit in ci/pixel-limits.json
- core/block_entities: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities.chest_open: no pixel limit in ci/pixel-limits.json
- core/block_entities.chest_open: no pixel limit in ci/pixel-limits.json
- core/block_entities.chest_open: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities.chest_open: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities.sign_edit: no pixel limit in ci/pixel-limits.json
- core/block_entities.sign_edit: no pixel limit in ci/pixel-limits.json
- core/block_entities.sign_edit: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities.sign_edit: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities.closed: no pixel limit in ci/pixel-limits.json
- core/block_entities.closed: no pixel limit in ci/pixel-limits.json
- core/block_entities.closed: no strict pixel limit in ci/strict-pixel-limits.json
- core/block_entities.closed: no strict pixel limit in ci/strict-pixel-limits.json
- core/mobs.far_lod: no LOD limit in ci/lod-limits.json
- core/mobs.far_lod: no LOD limit in ci/lod-limits.json
- core/old-gpu/block_entities: no committed baseline entry in ci/baselines/core-old-gpu.json
- core/old-gpu-2p/block_entities: no committed baseline entry in ci/baselines/core-old-gpu.json

## Suite core

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- old-gpu: 0 / 0
- old-gpu-2p: 0 / 0

**Quick mode** (core suite; vanilla a, vanilla b, Quicksilver old-GPU against vanilla a): the measure-run gates (same-run draw calls, terrain GPU memory, measure pictures) and the full and Vulkan profiles are not run. A merge needs a full run.

| scene | noise (vanilla a/b) % | limit % | old-GPU % | old-GPU two-phase % |
|---|---|---|---|---|
| spawn | 0.1992 | 10.05 | 0.435 | 0.4383 |
| flythrough | 0.0 | 14.95 | 0.0011 | 0.0011 |
| water_glass | 0.0037 | 6.45 | 0.0042 | 0.0044 |
| nether | 0.0 | 0.8 | 0.0003 | 0.0003 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 |
| mobs.far | 0.0 | None | 0.0 | 0.0 |
| outline | 0.0 | 0.25 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.0001 | 0.0001 |
| occlusion_move | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.0 | 0.0 |
| occlusion_move.open | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.closed | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.bare_x2300 | 0.0 | 0.3 | 0.0 | 0.0 |
| occlusion_move.bare_x2297 | 0.0 | 0.3 | 0.0 | 0.0 |
| occlusion_move.bare_x2305 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.bare_x2309 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.bare_open | 0.0 | 0.3 | 0.0 | 0.0 |
| occlusion_corner | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_corner.x-2944 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_corner.x-2930 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_corner.x-2916 | 0.0 | 0.25 | 0.0 | 0.0 |
| translucent_move | 0.0001 | 0.3 | 0.0002 | 0.0001 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0003 | 0.0003 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0003 | 0.0001 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0001 | 0.0004 |
| translucent_move.low | 0.0004 | 0.3 | 0.0014 | 0.0013 |
| translucent_move.back | 0.0002 | 0.3 | 0.0002 | 0.0003 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| water_glass_oit | 0.0054 | 0.3 | 0.0054 | 0.006 |
| translucent_move_oit | 0.0 | 0.3 | 0.0001 | 0.0003 |
| translucent_move_oit.x2404 | 0.0002 | 0.3 | 0.0007 | 0.0005 |
| translucent_move_oit.x2414 | 0.0 | 0.3 | 0.0003 | 0.0002 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0002 | 0.0002 |
| translucent_move_oit.low | 0.0001 | 0.3 | 0.001 | 0.0008 |
| translucent_move_oit.back | 0.0004 | 0.3 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0001 | 0.0 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 |
| block_entities | 0.0142 | None | 0.0042 | 0.0133 |
| block_entities.chest_open | 0.008 | None | 0.015 | 0.0154 |
| block_entities.sign_edit | 0.0055 | None | 0.005 | 0.0094 |
| block_entities.closed | 0.0151 | None | 0.0233 | 0.0127 |

Strict picture: pixels where both vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| spawn | 99.72 | 18057 | 2698 (3376) | 2723 (3392) |
| flythrough | 100.0 | 6020 | 57 (318) | 57 (318) |
| water_glass | 100.0 | 25508 | 21 (3505) | 24 (3509) |
| nether | 100.0 | 905 | 3 (464) | 3 (464) |
| mobs | 100.0 | 10 | 0 (0) | 0 (0) |
| mobs.far | 100.0 | None | 0 (0) | 0 (0) |
| outline | 100.0 | 10 | 0 (0) | 0 (0) |
| outline.bare | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion | 100.0 | 22 | 1 (76) | 1 (76) |
| occlusion_move | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.x2297 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.x2305 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.x2309 | 100.0 | 32 | 0 (0) | 0 (0) |
| occlusion_move.open | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.closed | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.bare_x2300 | 100.0 | 90 | 0 (0) | 0 (0) |
| occlusion_move.bare_x2297 | 100.0 | 70 | 0 (0) | 0 (0) |
| occlusion_move.bare_x2305 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.bare_x2309 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.bare_open | 100.0 | 110 | 0 (0) | 0 (0) |
| occlusion_corner | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_corner.x-2944 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_corner.x-2930 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_corner.x-2916 | 100.0 | 10 | 0 (0) | 0 (0) |
| translucent_move | 100.0 | 13 | 3 (125) | 1 (123) |
| translucent_move.x2404 | 100.0 | 15 | 4 (174) | 3 (172) |
| translucent_move.x2414 | 100.0 | 13 | 5 (166) | 3 (163) |
| translucent_move.x2424 | 100.0 | 13 | 1 (120) | 4 (123) |
| translucent_move.low | 100.0 | 41 | 15 (21) | 15 (21) |
| translucent_move.back | 100.0 | 13 | 3 (125) | 2 (124) |
| translucent_move.bare_back | 100.0 | 13 | 2 (124) | 1 (123) |
| water_glass_oit | 99.99 | 57 | 23 (3509) | 29 (3513) |
| translucent_move_oit | 100.0 | 12 | 3 (125) | 4 (126) |
| translucent_move_oit.x2404 | 100.0 | 16 | 5 (174) | 5 (174) |
| translucent_move_oit.x2414 | 100.0 | 10 | 5 (165) | 3 (163) |
| translucent_move_oit.x2424 | 100.0 | 15 | 1 (119) | 2 (120) |
| translucent_move_oit.low | 100.0 | 40 | 14 (20) | 13 (20) |
| translucent_move_oit.back | 100.0 | 12 | 1 (123) | 2 (124) |
| translucent_move_oit.bare_back | 100.0 | 15 | 3 (125) | 1 (123) |
| flat_plants | 100.0 | 350 | 248 (8128) | 248 (8128) |
| renderer_off | 100.0 | 10 | 0 (0) | 0 (0) |
| particles | 100.0 | 4 | 0 (0) | 0 (0) |
| particles.bare | 100.0 | 4 | 0 (0) | 0 (0) |
| animation | 100.0 | 10 | 1 (3) | 1 (3) |
| animation.behind | 100.0 | 10 | 0 (2) | 0 (2) |
| animation.front | 100.0 | 10 | 1 (3) | 1 (3) |
| animated_items | 100.0 | 10 | 0 (0) | 0 (0) |
| block_entities | 99.99 | None | 24 (911) | 108 (995) |
| block_entities.chest_open | 99.99 | None | 67 (954) | 71 (958) |
| block_entities.sign_edit | 99.99 | None | 32 (923) | 75 (966) |
| block_entities.closed | 99.98 | None | 107 (998) | 10 (901) |

Far entity LOD (on) against its stored references, % of pixels over 8/255; last column: against vanilla's picture of the same view (LOD off), reported only:

| shot | profile | reference % | limit % | vanilla % |
|---|---|---|---|---|
| mobs.far_lod | old-GPU | 0.0369 | None | 0.0 |
| mobs.far_lod | old-GPU two-phase | 0.0369 | None | 0.0 |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 49.42 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 252.56 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 68.03 (reported, not gated) | 27 (reported, not gated) | 93380 (reported, not gated) | 309.61 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.68 (base 20.0) | 13 (base 14) | 7652 (base 10264) | 237.98 (base 249.83) | 4.24 (base 5.99) |
| nether | 22.68 (base 33.79) | 10 (base 11) | 3852 (base 10656) | 259.17 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.72 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.68 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.35 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.69 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.17 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.06 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.58 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.66 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 17.72 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 273.87 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7316 (base 7604) | 237.44 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.27 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 240.53 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 9.67 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 237.51 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.65 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.13 (base 261.4) | 4.24 (base 4.24) |
| animation | 49 median (avg 40.06) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.69 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 47.09) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.62 (base 239.53) | 4.24 (base 5.99) |
| block_entities | 35.06 | 15 | 94488 | 235.86 | 4.24 |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 411022.57 (622648.991) | 33.988 | 1.776 | 340372 | 338992 (2097152.0) | 323 | 0.0 / 0 |
| flythrough | 562663.383 (899782.0) | 37.467 | 1.085 | 2098708 | 2095680 (2097152.0) | 269 | 5.422 / 87 |
| water_glass | 109308.331 (190435.139) | 42.601 | 1.124 | 9220 | 0 (2097152.0) | 4 | 0.0 / 0 |
| nether | 44227.609 (69124.967) | 36.018 | 1.877 | 297616 | 293440 (2097152.0) | 144 | 0.0 / 0 |
| mobs | 61731.229 (110188.261) | 43.977 | 0.967 | 611396 | 0 (2097152.0) | 3 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 27122.093 (47267.579) | 42.62 | 1.302 | 268040 | 169984 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 48581.293 (84948.527) | 42.811 | 1.238 | 672252 | 597184 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_corner | 27772.217 (60488.367) | 54.087 | 1.272 | 32840 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 200934.383 (357029.939) | 43.721 | 1.183 | 758756 | 756480 (2097152.0) | 0 | 0.0 / 0 |
| water_glass_oit | 109440.301 (190665.055) | 42.601 | 1.124 | 10116 | 0 (2097152.0) | 345 | 0.0 / 0 |
| translucent_move_oit | 201203.445 (357330.089) | 43.693 | 1.183 | 737796 | 731840 (2097152.0) | 292 | 0.0 / 0 |
| flat_plants | 9099.191 (12474.826) | 27.06 | 1.045 | 1940 | 0 (2097152.0) | 68 | 0.0 / 0 |
| renderer_off | 23657.363 (45159.14) | 47.613 | 1.0 | 1380 | 0 (2097152.0) | 2 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.467 (5228.568) | 41.772 | 1.087 | 86232 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2246.785 (4832.668) | 53.508 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |
| block_entities | 3461.77 (4439.399) | 22.022 | 1.6 | 134592 | 41472 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 2.066 (107) | 2.061 (55) | 0 | 895 / 0 | 4.902 / 6.429 | 2.093 / 2.906 |
| flythrough | 3.312 (1802) | 3.312 (1802) | 0 | 1390 / 0 | 4.071 / 5.807 | 2.18 / 3.944 |
| water_glass | 1.098 (14) | None (0) | 0 | 1212 / 0 | 4.475 / 5.778 | 1.996 / 2.688 |
| nether | 1.56 (28) | 1.527 (15) | 0 | 1831 / 0 | 3.636 / 4.802 | 1.615 / 2.226 |
| mobs | 1.573 (68) | None (0) | 0 | 2069 / 0 | 3.498 / 4.622 | 1.557 / 2.16 |
| outline | 0.314 (13) | None (0) | 0 | 2128 / 0 | 3.459 / 4.572 | 1.548 / 2.141 |
| occlusion | 0.77 (55) | 1.927 (2) | 0 | 2269 / 0 | 3.356 / 4.434 | 1.506 / 2.089 |
| occlusion_move | 1.048 (69) | 2.229 (24) | 0 | 2423 / 0 | 3.218 / 4.255 | 1.451 / 2.013 |
| occlusion_corner | 0.848 (110) | 0.917 (1) | 0 | 2703 / 0 | 3.01 / 3.969 | 1.295 / 1.767 |
| translucent_move | 1.761 (140) | 3.103 (33) | 0 | 3059 / 0 | 2.981 / 3.95 | 1.326 / 1.848 |
| water_glass_oit | 2.701 (155) | None (0) | 0 | 411 / 0 | 4.817 / 6.977 | 2.63 / 4.047 |
| translucent_move_oit | 1.95 (238) | 2.57 (25) | 0 | 1026 / 0 | 3.193 / 4.524 | 1.429 / 2.11 |
| flat_plants | 0.871 (100) | None (0) | 0 | 402 / 0 | 5.06 / 6.25 | 1.609 / 1.979 |
| renderer_off | 0.42 (25) | None (0) | 0 | 322 / 0 | 5.09 / 7.392 | 1.737 / 3.736 |
| particles | 0.241 (30) | None (0) | 0 | 3086 / 0 | 2.959 / 3.919 | 1.303 / 1.814 |
| animation | 0.898 (18) | 0.84 (4) | 0 | 3161 / 0 | 2.901 / 3.841 | 1.259 / 1.75 |
| animated_items | 0.23 (42) | 0.495 (2) | 0 | 3193 / 0 | 2.876 / 3.808 | 1.24 / 1.722 |
| block_entities | 0.581 (83) | 0.938 (1) | 0 | 3275 / 0 | 2.82 / 3.731 | 1.201 / 1.654 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.121 | 693.901 | 16 (vanilla 28) | 1376468 | 42.966 / 0.1 | 22.803 / 36.0 | 36.756 | 2446 / 0 | 2.061 (4.315) |
| flythrough | plain, one multi-draw per region and layer | 58.141 | 932.409 | 16 (vanilla 28) | 5286060 | 15.179 / 1.009 | 87.338 / 144.0 | 141.153 | 6842 / 0 | 3.312 (10.96) |
| water_glass | plain, one multi-draw per region and layer | 14.024 | 105.177 | 16 (vanilla 28) | 773708 | 35.106 / 0.088 | 12.487 / 36.0 | 20.66 | 3105 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.515 | 69.256 | 16 (vanilla 28) | 950608 | 29.596 / 0.195 | 15.135 / 20.0 | 25.384 | 4133 / 0 | 1.527 (2.157) |
| mobs | plain, one multi-draw per region and layer | 8.013 | 60.101 | 16 (vanilla 28) | 626732 | 26.282 / 0.167 | 10.141 / 20.0 | 16.736 | 4702 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 96900 | 25.789 / 0.165 | 1.539 / 20.0 | 2.588 | 4797 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.03 | 43.202 | 16 (vanilla 28) | 152008 | 24.528 / 0.157 | 2.427 / 20.0 | 4.059 | 5070 / 0 | 1.927 (2.247) |
| occlusion_move | plain, one multi-draw per region and layer | 10.995 | 74.388 | 16 (vanilla 28) | 207252 | 23.201 / 0.148 | 3.319 / 20.0 | 5.534 | 5376 / 0 | 2.229 (6.008) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.958 | 16 (vanilla 28) | 122728 | 21.952 / 0.14 | 1.931 / 20.0 | 3.277 | 5765 / 0 | 0.917 (0.917) |
| translucent_move | plain, one multi-draw per region and layer | 12.007 | 247.099 | 16 (vanilla 28) | 801992 | 19.13 / 0.129 | 13.017 / 28.0 | 21.415 | 6631 / 0 | 3.103 (9.94) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.046 | 113.328 | 16 (vanilla 28) | 773708 | 7.53 / 0.045 | 12.487 / 20.0 | 20.66 | 1088 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.329 | 261.812 | 16 (vanilla 28) | 776156 | 7.46 / 0.203 | 12.606 / 28.0 | 20.726 | 2561 / 0 | 2.57 (7.153) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 882760 | 6.527 / 0.01 | 14.164 / 24.0 | 23.572 | 962 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 566368 | 2.368 / 0.02 | 9.029 / 24.0 | 15.124 | 603 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.089 / 0.129 | 0.131 / 28.0 | 0.225 | 6673 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.524 | 16 (vanilla 28) | 19416 | 18.944 / 0.128 | 0.302 / 28.0 | 0.518 | 6775 / 0 | 0.84 (1.141) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.701 | 16 (vanilla 28) | 9764 | 18.894 / 0.128 | 0.153 / 28.0 | 0.261 | 6825 / 0 | 0.495 (0.737) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 18.605 / 0.126 | 0.142 / 28.0 | 0.237 | 6984 / 0 | 0.938 (0.937) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 153.0 | 17.0 | 0.0 | 0 | 0 | 45 (0.019 / 0.028 / 0.031; 0) | 0 | 49572 / 0 / 0 |
| flythrough | 197.744 | 26.852 | 0.0 | 0 | 0 | 934 (0.03 / 0.034 / 6.018; 0) | 59 | 53391 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2372 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.022 / 0.023; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.073 / 0.104 / 0.37; 0) | 180 | 3885 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 1038 | 0 (None / None / None; 0) | 0 | 1384 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 879 | 0 (None / None / None; 0) | 0 | 2051 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 343.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.114; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.67 | 1.0 (0.0, 0.0) | 1.096 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.089; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 111.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.097 (0.347; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.048 (0.29; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 50.364 | 10.0 (9.0, 2.364) | 6.0 (6.0, 2.275) | 0.059 (0.279; 0) | 0 | 2788 / 1509894 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.157 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.403 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.012; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.083; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.03 (0.176; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 287.56 / 341.0 (15.7) | 287.56 / 0.0 / 0.0 | 0.1 | 0.0 (0.0, 0.0; 0.0) | 1466.67 | 4602 / 0 |
| flythrough | still | 415.37 / 415.84 (0.1) | 415.37 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 12728 / 0 |
| nether | still | 53.15 / 299.0 (82.2) | 53.15 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 295.89 | 35108 / 0 |
| mobs | still | 32.0 / 111.0 (71.2) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11771 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.11 / 48.0 (45.6) | 26.11 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.0 | 3278 / 0 |
| occlusion_move | still | 50.2 / 50.32 (0.2) | 50.2 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.77 / 81.86 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 134.65 / 135.04 (0.3) | 134.65 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7396 / 0 |
| translucent_move_oit | still | 134.55 / 134.91 (0.3) | 134.55 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 21300 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 303 / 0 |
| animated_items | still | 12.67 / 13.0 (2.5) | 12.67 / 0.0 / 0.0 | 0.32 | 0.0 (0.0, 0.0; 0.0) | 4536.0 | 48 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.0 | 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.319 | - / 3.0 | - / 0.0 | - / 0.0 | 118.608 / 0.318 | 0.029 / 0.011 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.238 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.874 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 55.905 / 55.911 | 0.019 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 6.827 | - / 0.659 | - / 0.0 | - / 0.0 | - / 0.0 | 29.225 / 4.825 | 0.051 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.369 / 13.366 | 0.007 / 0.014 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.002 / 54.003 | 0.02 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.918 / 13.867 | 0.009 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 3.147 / 2.893 | 0.016 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.004 / 0.052 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.798 | 0.004 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | - / 28.104 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |
| block_entities | - / 13.322 | - / 0.953 | - / 3.0 | - / 0.0 | - / 0.0 | 11.73 / 11.7 | 0.002 / 0.004 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

GUI pass, core old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| flythrough | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| water_glass | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| nether | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| mobs | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| outline | 3.0 / - | 0.0 / - | 4.0 / - | 3.0 / - (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / - (3.0 / -) |
| occlusion | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| occlusion_move | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| occlusion_corner | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| translucent_move | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| water_glass_oit | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| translucent_move_oit | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| flat_plants | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| renderer_off | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| particles | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| animation | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| animated_items | 4.0 / - | 3.0 / - | 9.0 / - | 4.0 / - (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / - (4.0 / -) |
| block_entities | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |

### Counts, core old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 50.17 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.19 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 69.16 (reported, not gated) | 37 (reported, not gated) | 294724 (reported, not gated) | 310.07 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 20.79 (base 20.0) | 13 (base 14) | 7112 (base 10264) | 237.9 (base 249.83) | 4.24 (base 5.99) |
| nether | 23.99 (base 33.79) | 10 (base 11) | 3960 (base 10656) | 259.29 (base 272.57) | 4.24 (base 5.99) |
| mobs | 26.7 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.93 (base 268.23) | 4.24 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.54 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.31 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.76 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 11.73 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.15 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 11.14 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 274.42 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7540 (base 7604) | 237.31 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.42 (reported, not gated) | 13 (reported, not gated) | 3284 (reported, not gated) | 240.13 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 10.75 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 237.72 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.41 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.58 (base 261.4) | 4.24 (base 4.24) |
| animation | 50 median (avg 40.94) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.91 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 236.59 (base 239.53) | 4.24 (base 5.99) |
| block_entities | 36.11 | 15 | 94692 | 235.87 | 4.24 |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 396492.925 (596342.458) | 33.513 | 1.779 | 422180 | 420800 (2097152.0) | 214 | 0.0 / 0 |
| flythrough | 485232.82 (764145.027) | 36.5 | 1.087 | 2110324 | 2095424 (2097152.0) | 183 | 7.565 / 76 |
| water_glass | 109340.946 (190491.96) | 42.601 | 1.124 | 8772 | 0 (2097152.0) | 32 | 0.0 / 0 |
| nether | 29501.284 (42400.331) | 30.422 | 2.0 | 136232 | 131264 (2097152.0) | 128 | 0.0 / 0 |
| mobs | 61736.309 (110197.329) | 43.977 | 0.967 | 610676 | 0 (2097152.0) | 9 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 27461.693 (47995.86) | 42.783 | 1.293 | 437412 | 339264 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 21929.247 (38583.737) | 43.165 | 1.26 | 682412 | 608384 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 21837.61 (47210.167) | 53.744 | 1.215 | 32932 | 31552 (2097152.0) | 1 | 0.0 / 0 |
| translucent_move | 21609.62 (27642.129) | 21.824 | 1.005 | 759204 | 756480 (2097152.0) | 132 | 0.0 / 0 |
| water_glass_oit | 109567.593 (190886.821) | 42.601 | 1.124 | 8884 | 0 (2097152.0) | 246 | 0.0 / 0 |
| translucent_move_oit | 21717.13 (27812.967) | 21.917 | 1.005 | 737316 | 731840 (2097152.0) | 246 | 0.0 / 0 |
| flat_plants | 9101.605 (12478.136) | 27.06 | 1.045 | 2388 | 0 (2097152.0) | 129 | 0.0 / 0 |
| renderer_off | 23657.495 (45159.391) | 47.613 | 1.0 | 1380 | 0 (2097152.0) | 15 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.389 (5146.952) | 41.531 | 1.091 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79236 | 57728 (2097152.0) | 0 | 0.0 / 0 |
| block_entities | 3461.77 (4439.399) | 22.022 | 1.6 | 136592 | 41472 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 3.203 (109) | 3.089 (49) | 0 | 904 / 0 | 6.768 / 9.239 | 2.991 / 4.795 |
| flythrough | 4.519 (1708) | 4.519 (1708) | 0 | 1391 / 0 | 5.576 / 7.82 | 3.469 / 5.436 |
| water_glass | 1.228 (15) | None (0) | 0 | 1216 / 0 | 5.994 / 8.136 | 2.781 / 4.386 |
| nether | 1.835 (28) | 1.837 (9) | 0 | 1840 / 0 | 5.0 / 6.817 | 2.252 / 3.37 |
| mobs | 2.404 (68) | None (0) | 0 | 2074 / 0 | 4.904 / 6.609 | 2.199 / 3.271 |
| outline | 0.428 (13) | None (0) | 0 | 2133 / 0 | 4.836 / 6.522 | 2.179 / 3.221 |
| occlusion | 1.306 (50) | 1.953 (4) | 0 | 2258 / 0 | 4.707 / 6.325 | 2.12 / 3.099 |
| occlusion_move | 1.399 (63) | 3.37 (17) | 0 | 2414 / 0 | 4.521 / 6.078 | 2.061 / 3.035 |
| occlusion_corner | 1.159 (110) | 1.163 (1) | 0 | 2694 / 0 | 4.202 / 5.612 | 1.857 / 2.646 |
| translucent_move | 2.297 (107) | 3.896 (32) | 0 | 3074 / 0 | 4.052 / 5.431 | 1.893 / 2.693 |
| water_glass_oit | 2.813 (153) | None (0) | 0 | 411 / 0 | 6.208 / 8.515 | 3.192 / 4.473 |
| translucent_move_oit | 3.355 (224) | 3.715 (25) | 0 | 967 / 0 | 4.223 / 5.841 | 2.162 / 3.022 |
| flat_plants | 1.129 (82) | None (0) | 0 | 401 / 0 | 6.14 / 7.981 | 2.298 / 2.6 |
| renderer_off | 0.433 (19) | None (0) | 0 | 326 / 0 | 7.45 / 8.766 | 2.718 / 4.339 |
| particles | 0.276 (24) | None (0) | 0 | 3101 / 0 | 4.021 / 5.388 | 1.871 / 2.66 |
| animation | 0.752 (18) | 0.938 (4) | 0 | 3176 / 0 | 3.943 / 5.28 | 1.818 / 2.556 |
| animated_items | 0.257 (38) | 0.643 (2) | 0 | 3208 / 0 | 3.909 / 5.233 | 1.79 / 2.508 |
| block_entities | 0.889 (57) | 0.986 (1) | 0 | 3290 / 0 | 3.832 / 5.125 | 1.732 / 2.385 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.182 | 656.051 | 16 (vanilla 28) | 1392484 | 40.22 / 0.102 | 23.057 / 36.0 | 37.183 | 2459 / 0 | 3.089 (8.866) |
| flythrough | plain, one multi-draw per region and layer | 58.35 | 767.109 | 16 (vanilla 28) | 5189216 | 14.936 / 0.987 | 85.686 / 112.0 | 138.567 | 6658 / 0 | 4.519 (13.291) |
| water_glass | plain, one multi-draw per region and layer | 14.028 | 105.209 | 16 (vanilla 28) | 773708 | 32.775 / 0.091 | 12.487 / 36.0 | 20.66 | 3104 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.084 | 16 (vanilla 28) | 950592 | 27.651 / 0.178 | 15.128 / 20.0 | 25.384 | 4144 / 0 | 1.837 (2.941) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.105 | 16 (vanilla 28) | 626732 | 24.633 / 0.152 | 10.141 / 20.0 | 16.736 | 4705 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 96900 | 24.169 / 0.151 | 1.539 / 20.0 | 2.588 | 4800 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 41.068 | 16 (vanilla 28) | 162680 | 23.146 / 0.145 | 2.59 / 20.0 | 4.344 | 5031 / 0 | 1.953 (3.488) |
| occlusion_move | plain, one multi-draw per region and layer | 6.033 | 33.55 | 16 (vanilla 28) | 216356 | 21.794 / 0.136 | 3.443 / 20.0 | 5.777 | 5329 / 0 | 3.37 (8.488) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.07 | 60.892 | 16 (vanilla 28) | 122728 | 20.613 / 0.129 | 1.931 / 20.0 | 3.277 | 5718 / 0 | 1.163 (1.163) |
| translucent_move | plain, one multi-draw per region and layer | 4.397 | 23.093 | 16 (vanilla 28) | 812792 | 17.869 / 0.117 | 13.168 / 28.0 | 21.704 | 6587 / 0 | 3.896 (9.727) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.065 | 113.459 | 16 (vanilla 28) | 773708 | 7.486 / 0.043 | 12.487 / 20.0 | 20.66 | 1084 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.455 | 37.236 | 16 (vanilla 28) | 786960 | 6.844 / 0.115 | 12.757 / 28.0 | 21.014 | 2435 / 0 | 3.715 (11.27) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 884444 | 6.074 / 0.01 | 14.18 / 24.0 | 23.617 | 919 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 566400 | 2.377 / 0.02 | 9.029 / 24.0 | 15.125 | 604 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 17.835 / 0.117 | 0.131 / 28.0 | 0.225 | 6626 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 17.7 / 0.116 | 0.302 / 28.0 | 0.518 | 6728 / 0 | 0.938 (1.458) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.657 / 0.117 | 0.153 / 28.0 | 0.261 | 6775 / 0 | 0.643 (0.962) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 17.439 / 0.115 | 0.142 / 28.0 | 0.237 | 6908 / 0 | 0.986 (0.986) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 17.0 | 0.0 | 0 | 0 | 40 (0.023 / 0.031 / 0.035; 0) | 0 | 33110 / 0 / 0 |
| flythrough | 193.038 | 26.451 | 0.0 | 0 | 0 | 901 (0.023 / 0.036 / 4.855; 0) | 52 | 35519 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2016 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.018; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.085 / 0.131 / 0.267; 0) | 180 | 3689 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 741 | 0 (None / None / None; 0) | 0 | 988 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 741 | 0 (None / None / None; 0) | 0 | 1729 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2068 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2396 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 350.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.028 (0.068; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 432.451 | 1.0 (0.0, 0.0) | 1.13 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.087; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 111.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.123 (0.217; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.013; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.069 (0.159; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.359) | 6.0 (6.0, 2.276) | 0.065 (1.488; 0) | 0 | 2786 / 1508292 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.264 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.725 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.044 (0.08; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 265.0 / 348.0 (23.9) | 265.0 / 83.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4399 / 0 |
| flythrough | two-phase | 315.17 / 406.41 (22.5) | 309.83 / 96.58 / 5.34 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4128 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10836 / 0 |
| nether | two-phase | 37.0 / 299.0 (87.6) | 37.0 / 262.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 33798 / 0 |
| mobs | two-phase | 32.0 / 111.0 (71.2) | 32.0 / 79.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 11218 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3278 / 0 |
| occlusion | two-phase | 25.0 / 49.0 (49.0) | 25.0 / 24.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3600 / 0 |
| occlusion_move | two-phase | 22.24 / 51.31 (56.6) | 22.19 / 29.12 / 0.06 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4358 / 0 |
| occlusion_corner | two-phase | 60.77 / 81.86 (25.8) | 60.69 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.66 / 136.12 (88.5) | 15.64 / 120.48 / 0.02 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 15897 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5246 / 0 |
| translucent_move_oit | two-phase | 15.66 / 136.19 (88.5) | 15.62 / 120.57 / 0.04 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 7477 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 18447 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 15049 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.168 | - / 3.0 | - / 0.0 | - / 0.0 | 117.82 / 0.167 | 0.024 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.213 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.853 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 50.843 / 50.855 | 0.023 / 0.028 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.49 | - / 0.751 | - / 0.0 | - / 0.0 | - / 0.0 | 48.19 / 6.548 | 0.077 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.294 / 12.239 | 0.005 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.045 / 53.964 | 0.016 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 15.568 / 15.53 | 0.008 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 3.726 / 3.485 | 0.017 / 0.012 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.006 / 0.053 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.27 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.798 | 0.004 / 0.009 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |
| block_entities | - / 13.322 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.765 / 13.812 | 0.004 / 0.01 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

GUI pass, core old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| spawn | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| flythrough | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| water_glass | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| nether | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| mobs | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| outline | 3.0 / - | 0.0 / - | 4.0 / - | 3.0 / - (pipelines 3.0, textures 2.0, scissors 1.0) | 3.0 / - (3.0 / -) |
| occlusion | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| occlusion_move | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| occlusion_corner | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| translucent_move | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| water_glass_oit | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| translucent_move_oit | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| flat_plants | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| renderer_off | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| particles | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| animation | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |
| animated_items | 4.0 / - | 3.0 / - | 9.0 / - | 4.0 / - (pipelines 4.0, textures 3.0, scissors 1.0) | 4.0 / - (4.0 / -) |
| block_entities | 1.0 / - | 0.0 / - | 1.0 / - | 1.0 / - (pipelines 1.0, textures 1.0, scissors 1.0) | 1.0 / - (1.0 / -) |

## Direct buffers per scene (reported; open bug, see docs/progress.md)

| run | scene | start MB | peak MB (tick) | end MB | rise |
|---|---|---|---|---|---|
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
| core-quicksilver-2p-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
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
| core-quicksilver-old | block_entities | 4.24 | 4.24 (0) | 4.24 |  |
| core-quicksilver-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |

Rises of 4 MB or more: none

