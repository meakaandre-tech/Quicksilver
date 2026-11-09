# Quicksilver CI comparison

**FAILED**

- core/quicksilver-old: the Memory module was not fully on: off, quicksilver.ci.measureOnly is set
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
| spawn | 0.1912 | 10.05 | 0.0515 | 0.0583 |
| flythrough | 0.0 | 14.95 | 0.0009 | 0.0009 |
| water_glass | 0.0038 | 6.45 | 0.0048 | 0.0039 |
| nether | 0.0 | 0.8 | 0.0003 | 0.0003 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 |
| mobs.far | 0.0 | 0.25 | 0.0 | 0.0 |
| outline | 0.0 | 0.25 | 0.0 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.0001 | 0.0001 |
| occlusion_move | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.0 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.0009 | 0.0009 |
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
| translucent_move | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| translucent_move.x2404 | 0.0003 | 0.3 | 0.0004 | 0.0004 |
| translucent_move.x2414 | 0.0001 | 0.3 | 0.0002 | 0.0003 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.0004 | 0.0003 |
| translucent_move.low | 0.0004 | 0.3 | 0.0013 | 0.0013 |
| translucent_move.back | 0.0001 | 0.3 | 0.0001 | 0.0 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0 | 0.0001 |
| water_glass_oit | 0.0044 | 0.3 | 0.0043 | 0.0048 |
| translucent_move_oit | 0.0 | 0.3 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0003 | 0.3 | 0.0005 | 0.0004 |
| translucent_move_oit.x2414 | 0.0004 | 0.3 | 0.0008 | 0.0005 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0004 | 0.0002 |
| translucent_move_oit.low | 0.0009 | 0.3 | 0.001 | 0.0011 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0002 | 0.0 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0 | 0.0 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 |
| block_entities | 0.0226 | None | 0.0117 | 0.0181 |
| block_entities.chest_open | 0.0215 | None | 0.0195 | 0.0275 |
| block_entities.sign_edit | 0.0074 | None | 0.0145 | 0.0089 |
| block_entities.closed | 0.0067 | None | 0.0041 | 0.0144 |

Strict picture: pixels where both vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| spawn | 99.73 | 18057 | 481 (1158) | 476 (1157) |
| flythrough | 100.0 | 6020 | 53 (315) | 53 (315) |
| water_glass | 100.0 | 25508 | 29 (3516) | 22 (3508) |
| nether | 100.0 | 905 | 3 (464) | 3 (464) |
| mobs | 100.0 | 10 | 1 (1) | 1 (1) |
| mobs.far | 100.0 | 10 | 0 (0) | 0 (0) |
| outline | 100.0 | 10 | 0 (0) | 0 (0) |
| outline.bare | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion | 100.0 | 22 | 1 (76) | 1 (76) |
| occlusion_move | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.x2297 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.x2305 | 100.0 | 10 | 0 (0) | 0 (0) |
| occlusion_move.x2309 | 100.0 | 32 | 8 (8) | 8 (8) |
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
| translucent_move | 100.0 | 13 | 4 (126) | 2 (124) |
| translucent_move.x2404 | 100.0 | 15 | 4 (173) | 4 (173) |
| translucent_move.x2414 | 100.0 | 13 | 2 (162) | 5 (165) |
| translucent_move.x2424 | 100.0 | 13 | 2 (121) | 1 (123) |
| translucent_move.low | 100.0 | 41 | 18 (24) | 15 (22) |
| translucent_move.back | 100.0 | 13 | 3 (126) | 3 (125) |
| translucent_move.bare_back | 100.0 | 13 | 1 (124) | 4 (126) |
| water_glass_oit | 99.99 | 57 | 22 (3506) | 26 (3511) |
| translucent_move_oit | 100.0 | 12 | 2 (124) | 2 (124) |
| translucent_move_oit.x2404 | 100.0 | 16 | 5 (174) | 4 (173) |
| translucent_move_oit.x2414 | 100.0 | 10 | 5 (165) | 3 (163) |
| translucent_move_oit.x2424 | 100.0 | 15 | 3 (122) | 1 (120) |
| translucent_move_oit.low | 100.0 | 40 | 14 (20) | 14 (20) |
| translucent_move_oit.back | 100.0 | 12 | 3 (126) | 2 (125) |
| translucent_move_oit.bare_back | 100.0 | 15 | 1 (123) | 2 (124) |
| flat_plants | 100.0 | 350 | 248 (8128) | 248 (8128) |
| renderer_off | 100.0 | 10 | 0 (0) | 0 (0) |
| particles | 100.0 | 4 | 0 (0) | 0 (0) |
| particles.bare | 100.0 | 4 | 0 (0) | 0 (0) |
| animation | 100.0 | 10 | 1 (3) | 1 (3) |
| animation.behind | 100.0 | 10 | 0 (2) | 0 (2) |
| animation.front | 100.0 | 10 | 1 (3) | 1 (3) |
| animated_items | 100.0 | 10 | 0 (0) | 0 (0) |
| block_entities | 99.98 | None | 52 (939) | 110 (997) |
| block_entities.chest_open | 99.98 | None | 49 (936) | 122 (1009) |
| block_entities.sign_edit | 99.99 | None | 120 (1011) | 68 (959) |
| block_entities.closed | 99.99 | None | 25 (916) | 119 (1010) |

Far entity LOD (on) against its stored references, % of pixels over 8/255; last column: against vanilla's picture of the same view (LOD off), reported only:

| shot | profile | reference % | limit % | vanilla % |
|---|---|---|---|---|
| mobs.far_lod | old-GPU | 0.0 | 0.25 | 0.0 |
| mobs.far_lod | old-GPU two-phase | 0.0 | 0.25 | 0.0 |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 49.82 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 266.0 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 66.69 (reported, not gated) | 46 (reported, not gated) | 697564 (reported, not gated) | 320.86 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.85 (base 20.0) | 13 (base 14) | 7204 (base 10264) | 250.24 (base 249.83) | 3.99 (base 5.99) |
| nether | 23.95 (base 33.79) | 10 (base 11) | 4736 (base 10656) | 272.04 (base 272.57) | 3.99 (base 5.99) |
| mobs | 17.72 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 271.45 (base 268.23) | 3.99 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 269.98 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 13.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 275.6 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 19.45 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 276.36 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 280.31 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 17.99 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 287.09 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7092 (base 7604) | 249.01 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 251.4 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 9.67 (base 33.0) | 13 (base 13) | 1604 (base 1716) | 249.92 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 244.92 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 277.95 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.06) (base 49) | 13 (base 13) | 1716 (base 1716) | 274.36 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 60 median (avg 47.09) (base 60) | 22 (base 22) | 21668 (base 21668) | 248.85 (base 239.53) | 5.99 (base 5.99) |
| block_entities | 31.1 | 15 | 94468 | 248.27 | 5.99 |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 426602.404 (648375.459) | 34.204 | 1.78 | 475428 | 474048 (2097152.0) | 218 | 0.0 / 0 |
| flythrough | 555770.759 (891273.927) | 37.643 | 1.084 | 2101548 | 2096104 (2097152.0) | 137 | 7.986 / 58 |
| water_glass | 114456.278 (200186.243) | 42.825 | 1.133 | 8660 | 0 (2097152.0) | 88 | 0.0 / 0 |
| nether | 45095.652 (70732.443) | 36.245 | 1.872 | 212004 | 208256 (2097152.0) | 153 | 0.0 / 0 |
| mobs | 64278.446 (115479.201) | 44.338 | 0.967 | 610516 | 0 (2097152.0) | 47 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29571.285 (52136.895) | 43.281 | 1.279 | 98148 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 50764.195 (89302.232) | 43.155 | 1.223 | 645884 | 570816 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 27770.922 (60486.905) | 54.088 | 1.272 | 32840 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 198183.25 (351354.447) | 43.594 | 1.173 | 898900 | 893760 (2097152.0) | 310 | 0.0 / 0 |
| water_glass_oit | 114765.115 (200720.385) | 42.823 | 1.133 | 8996 | 0 (2097152.0) | 208 | 0.0 / 0 |
| translucent_move_oit | 198867.924 (352348.562) | 43.559 | 1.172 | 898116 | 893760 (2097152.0) | 185 | 0.0 / 0 |
| flat_plants | 9100.486 (12476.603) | 27.06 | 1.045 | 2052 | 0 (2097152.0) | 138 | 0.0 / 0 |
| renderer_off | 17929.983 (33764.462) | 46.897 | 1.0 | 1380 | 0 (2097152.0) | 6 | 0.0 / 0 |
| particles | 1698.827 (3676.117) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.467 (5228.568) | 41.772 | 1.087 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2246.785 (4832.668) | 53.508 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |
| block_entities | 3461.75 (4439.374) | 22.022 | 1.6 | 136276 | 41472 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 4.59 (99) | 4.825 (57) | 0 | 868 / 0 | 9.618 / 13.651 | 4.9 / 7.311 |
| flythrough | 6.86 (1653) | 6.86 (1653) | 0 | 1399 / 0 | 7.81 / 10.776 | 5.142 / 7.361 |
| water_glass | 1.981 (18) | None (0) | 0 | 1191 / 0 | 8.731 / 12.139 | 4.432 / 6.537 |
| nether | 2.763 (31) | 2.862 (14) | 0 | 1793 / 0 | 7.311 / 9.833 | 3.669 / 5.143 |
| mobs | 3.684 (67) | None (0) | 0 | 2032 / 0 | 7.082 / 9.472 | 3.559 / 5.035 |
| outline | 0.507 (13) | None (0) | 0 | 2090 / 0 | 6.963 / 9.313 | 3.499 / 4.957 |
| occlusion | 1.263 (41) | None (0) | 0 | 2224 / 0 | 6.849 / 9.117 | 3.383 / 4.857 |
| occlusion_move | 2.457 (65) | 5.588 (16) | 0 | 2373 / 0 | 6.561 / 8.735 | 3.228 / 4.534 |
| occlusion_corner | 1.924 (103) | 1.093 (1) | 0 | 2644 / 0 | 6.142 / 8.104 | 2.972 / 4.128 |
| translucent_move | 4.327 (121) | 7.154 (33) | 0 | 3014 / 0 | 5.973 / 7.878 | 2.986 / 4.152 |
| water_glass_oit | 4.264 (154) | None (0) | 0 | 413 / 0 | 9.6 / 12.518 | 6.039 / 7.062 |
| translucent_move_oit | 3.891 (218) | 4.59 (26) | 0 | 963 / 0 | 6.554 / 8.735 | 3.681 / 4.801 |
| flat_plants | 2.061 (83) | None (0) | 0 | 404 / 0 | 7.881 / 9.494 | 3.426 / 3.856 |
| renderer_off | 0.598 (25) | None (0) | 0 | 326 / 0 | 9.598 / 11.257 | 4.817 / 4.811 |
| particles | 0.388 (30) | None (0) | 0 | 3043 / 0 | 5.925 / 7.813 | 2.959 / 4.106 |
| animation | 0.938 (18) | 1.257 (4) | 0 | 3118 / 0 | 5.81 / 7.652 | 2.861 / 3.955 |
| animated_items | 0.477 (32) | 1.32 (2) | 0 | 3150 / 0 | 5.758 / 7.581 | 2.817 / 3.883 |
| block_entities | 1.131 (80) | 1.871 (1) | 0 | 3232 / 0 | 5.639 / 7.421 | 2.7 / 3.728 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.179 | 725.344 | 16 (vanilla 28) | 1406460 | 41.486 / 0.083 | 23.249 / 36.0 | 37.557 | 2341 / 0 | 4.825 (10.055) |
| flythrough | plain, one multi-draw per region and layer | 56.985 | 898.139 | 16 (vanilla 28) | 5135268 | 15.172 / 1.01 | 84.815 / 112.0 | 137.126 | 6560 / 0 | 6.86 (18.688) |
| water_glass | plain, one multi-draw per region and layer | 14.03 | 105.228 | 16 (vanilla 28) | 787632 | 33.966 / 0.075 | 12.711 / 36.0 | 21.032 | 3024 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.545 | 70.868 | 16 (vanilla 28) | 953288 | 28.599 / 0.176 | 15.187 / 20.0 | 25.456 | 4038 / 0 | 2.862 (4.208) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.109 | 16 (vanilla 28) | 637096 | 25.247 / 0.149 | 10.321 / 20.0 | 17.012 | 4610 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 91252 | 24.801 / 0.148 | 1.46 / 20.0 | 2.437 | 4703 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 163148 | 23.704 / 0.141 | 2.602 / 20.0 | 4.357 | 4942 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 10.973 | 76.235 | 16 (vanilla 28) | 212516 | 22.491 / 0.134 | 3.391 / 20.0 | 5.675 | 5230 / 0 | 5.588 (15.3) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.955 | 16 (vanilla 28) | 122728 | 21.319 / 0.127 | 1.931 / 20.0 | 3.277 | 5603 / 0 | 1.093 (1.09) |
| translucent_move | plain, one multi-draw per region and layer | 12.011 | 249.553 | 16 (vanilla 28) | 795360 | 18.492 / 0.115 | 12.861 / 28.0 | 21.238 | 6471 / 0 | 7.154 (17.254) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.077 | 113.543 | 16 (vanilla 28) | 787648 | 7.471 / 0.043 | 12.711 / 20.0 | 21.032 | 1090 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.616 | 265.124 | 16 (vanilla 28) | 772832 | 6.63 / 0.102 | 12.505 / 28.0 | 20.637 | 2431 / 0 | 4.59 (14.341) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 849712 | 6.328 / 0.01 | 13.575 / 24.0 | 22.69 | 929 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 545588 | 2.436 / 0.021 | 8.671 / 24.0 | 14.569 | 612 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.446 / 0.115 | 0.131 / 28.0 | 0.225 | 6517 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.524 | 16 (vanilla 28) | 19416 | 18.304 / 0.114 | 0.302 / 28.0 | 0.518 | 6619 / 0 | 1.257 (1.766) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.701 | 16 (vanilla 28) | 9764 | 18.254 / 0.114 | 0.153 / 28.0 | 0.261 | 6668 / 0 | 1.32 (2.042) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 17.971 / 0.112 | 0.142 / 28.0 | 0.237 | 6824 / 0 | 1.871 (1.869) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 53 (0.027 / 0.05 / 0.054; 0) | 0 | 34164 / 0 / 0 |
| flythrough | 188.283 | 25.957 | 0.0 | 0 | 0 | 878 (0.031 / 0.049 / 6.293; 0) | 49 | 25983 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1844 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.009 / 0.009; 0) | 32 | 1194 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.11 / 0.165 / 1.18; 0) | 180 | 2639 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 627 | 0 (None / None / None; 0) | 0 | 836 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 558 | 0 (None / None / None; 0) | 0 | 1302 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2208 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 350.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.083; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 431.514 | 1.0 (0.0, 0.0) | 1.217 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.053; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.133 (0.227; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.069 (0.135; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.347 | 10.0 (9.0, 2.352) | 6.0 (6.0, 2.28) | 0.061 (0.243; 0) | 0 | 2765 / 1495480 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.032 | 1.0 (0.0, 0.0) | 0.764 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.591 | 1.0 (0.0, 0.0) | 0.742 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.006 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.05 (0.093; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 302.91 / 348.0 (13.0) | 302.91 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1578.08 | 2054 / 0 |
| flythrough | still | 398.09 / 398.96 (0.2) | 398.09 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 60 / 0 |
| water_glass | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10005 / 0 |
| nether | still | 54.12 / 300.0 (82.0) | 54.12 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.43 | 31560 / 0 |
| mobs | still | 32.0 / 110.0 (70.9) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10764 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.0 / 49.0 (46.9) | 26.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3450 / 0 |
| occlusion_move | still | 51.11 / 51.3 (0.4) | 51.11 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 37 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 135.27 / 135.85 (0.4) | 135.27 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4524 / 0 |
| translucent_move_oit | still | 135.28 / 135.87 (0.4) | 135.28 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 153.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 19872 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 303 / 0 |
| animated_items | still | 12.67 / 13.0 (2.5) | 12.67 / 0.0 / 0.0 | 0.32 | 0.0 (0.0, 0.0; 0.0) | 4536.0 | 48 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 23.92 | 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.711 | - / 3.0 | - / 0.0 | - / 0.0 | 120.25 / 1.224 | 0.034 / 0.016 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.04 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.826 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 52.771 / 52.738 | 0.027 / 0.025 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.688 | - / 0.953 | - / 0.0 | - / 0.0 | - / 0.0 | 55.8 / 10.884 | 0.086 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.778 / 11.666 | 0.005 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 50.903 / 50.976 | 0.013 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 10.724 / 10.71 | 0.005 / 0.007 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 0.0 | - / 0.947 | - / 3.0 | - / 0.0 | - / 0.0 | 2.688 / 2.429 | 0.014 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.004 / 0.036 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.004 / 0.007 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.987 |
| animated_items | - / 28.104 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |
| block_entities | - / 13.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 10.773 / 10.789 | 0.002 / 0.006 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| spawn | 49.04 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 251.12 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 68.75 (reported, not gated) | 37 (reported, not gated) | 293060 (reported, not gated) | 308.64 (base 324.79) | 5.48 (base 5.99) |
| water_glass | 20.92 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 237.58 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.02 (base 33.79) | 10 (base 11) | 4288 (base 10656) | 258.86 (base 272.57) | 3.99 (base 5.99) |
| mobs | 18.7 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.64 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.93 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 14.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.79 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 15.51 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 262.94 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.72 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.41 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 273.78 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7428 (base 7604) | 236.84 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.41 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 239.52 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 10.47 (base 33.0) | 13 (base 13) | 1512 (base 1716) | 237.61 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.04 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 264.55 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.11 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.77) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.07 (base 239.53) | 5.99 (base 5.99) |
| block_entities | 32.1 | 15 | 94336 | 235.62 | 5.99 |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 392230.363 (589679.529) | 33.484 | 1.77 | 409060 | 407680 (2097152.0) | 204 | 0.0 / 0 |
| flythrough | 489182.103 (770033.806) | 36.473 | 1.087 | 2100036 | 2096296 (2097152.0) | 175 | 6.438 / 76 |
| water_glass | 114490.693 (200246.436) | 42.825 | 1.133 | 8996 | 0 (2097152.0) | 124 | 0.0 / 0 |
| nether | 29508.206 (42406.775) | 30.416 | 2.0 | 238928 | 235200 (2097152.0) | 131 | 0.0 / 0 |
| mobs | 64273.586 (115470.47) | 44.338 | 0.967 | 610676 | 0 (2097152.0) | 14 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29697.413 (52393.177) | 43.318 | 1.279 | 98148 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 22416.244 (39493.813) | 43.241 | 1.26 | 645792 | 570816 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 21832.584 (47203.346) | 53.748 | 1.214 | 32932 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 21626.428 (27678.69) | 21.866 | 1.003 | 898228 | 893760 (2097152.0) | 133 | 0.0 / 0 |
| water_glass_oit | 114668.516 (200557.452) | 42.825 | 1.133 | 8660 | 0 (2097152.0) | 248 | 0.0 / 0 |
| translucent_move_oit | 21715.61 (27818.255) | 21.938 | 1.004 | 899940 | 893760 (2097152.0) | 251 | 0.0 / 0 |
| flat_plants | 9100.368 (12476.44) | 27.06 | 1.045 | 1828 | 0 (2097152.0) | 139 | 0.0 / 0 |
| renderer_off | 17863.773 (33636.06) | 46.891 | 1.0 | 1380 | 0 (2097152.0) | 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |
| block_entities | 3461.75 (4439.374) | 22.022 | 1.6 | 135696 | 41472 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 3.31 (109) | 3.486 (51) | 0 | 873 / 0 | 7.222 / 9.157 | 2.59 / 3.804 |
| flythrough | 4.133 (1657) | 4.133 (1657) | 0 | 1392 / 0 | 5.216 / 7.32 | 3.159 / 4.9 |
| water_glass | 1.29 (18) | None (0) | 0 | 1185 / 0 | 6.413 / 8.216 | 2.495 / 3.621 |
| nether | 1.703 (32) | 2.116 (12) | 0 | 1801 / 0 | 5.328 / 6.921 | 2.205 / 3.186 |
| mobs | 2.437 (75) | None (0) | 0 | 2035 / 0 | 5.112 / 6.688 | 2.145 / 3.089 |
| outline | 0.394 (13) | None (0) | 0 | 2093 / 0 | 5.031 / 6.572 | 2.128 / 3.06 |
| occlusion | 0.636 (47) | None (0) | 0 | 2217 / 0 | 4.991 / 6.453 | 2.098 / 2.963 |
| occlusion_move | 1.543 (61) | 3.62 (17) | 0 | 2362 / 0 | 4.782 / 6.195 | 2.037 / 2.839 |
| occlusion_corner | 0.925 (110) | 1.146 (1) | 0 | 2633 / 0 | 4.416 / 5.742 | 1.781 / 2.574 |
| translucent_move | 2.302 (111) | 3.872 (33) | 0 | 3005 / 0 | 4.297 / 5.649 | 1.867 / 2.648 |
| water_glass_oit | 3.153 (154) | None (0) | 0 | 412 / 0 | 6.677 / 8.15 | 3.683 / 4.574 |
| translucent_move_oit | 2.892 (223) | 4.226 (25) | 0 | 968 / 0 | 4.504 / 5.78 | 2.326 / 3.117 |
| flat_plants | 1.082 (89) | None (0) | 0 | 403 / 0 | 7.532 / 9.887 | 2.374 / 2.891 |
| renderer_off | 0.428 (25) | None (0) | 0 | 323 / 0 | 6.445 / 8.995 | 2.234 / 4.705 |
| particles | 0.996 (24) | None (0) | 0 | 3032 / 0 | 4.263 / 5.603 | 1.842 / 2.629 |
| animation | 0.765 (18) | 1.0 (4) | 0 | 3107 / 0 | 4.18 / 5.488 | 1.762 / 2.55 |
| animated_items | 0.395 (38) | 1.067 (2) | 0 | 3139 / 0 | 4.143 / 5.438 | 1.742 / 2.52 |
| block_entities | 0.719 (57) | 1.165 (1) | 0 | 3221 / 0 | 4.057 / 5.322 | 1.681 / 2.435 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 38.186 | 643.137 | 16 (vanilla 28) | 1353892 | 44.45 / 0.101 | 22.423 / 36.0 | 36.153 | 2423 / 0 | 3.486 (8.637) |
| flythrough | plain, one multi-draw per region and layer | 57.943 | 767.509 | 16 (vanilla 28) | 5233684 | 15.082 / 1.008 | 86.411 / 112.0 | 139.754 | 6557 / 0 | 4.133 (12.299) |
| water_glass | plain, one multi-draw per region and layer | 14.035 | 105.26 | 16 (vanilla 28) | 787616 | 36.065 / 0.087 | 12.711 / 36.0 | 21.032 | 3075 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.082 | 16 (vanilla 28) | 953288 | 30.286 / 0.187 | 15.186 / 20.0 | 25.456 | 4106 / 0 | 2.116 (2.999) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.104 | 16 (vanilla 28) | 637080 | 26.79 / 0.16 | 10.321 / 20.0 | 17.012 | 4684 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 91252 | 26.327 / 0.159 | 1.46 / 20.0 | 2.437 | 4777 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 163528 | 25.288 / 0.152 | 2.607 / 20.0 | 4.367 | 5002 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.038 | 33.906 | 16 (vanilla 28) | 212316 | 24.028 / 0.144 | 3.384 / 20.0 | 5.669 | 5275 / 0 | 3.62 (12.472) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.876 | 16 (vanilla 28) | 122728 | 22.763 / 0.137 | 1.931 / 20.0 | 3.277 | 5655 / 0 | 1.146 (1.146) |
| translucent_move | plain, one multi-draw per region and layer | 4.392 | 23.079 | 16 (vanilla 28) | 795196 | 19.756 / 0.125 | 12.855 / 28.0 | 21.234 | 6507 / 0 | 3.872 (11.082) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.065 | 113.456 | 16 (vanilla 28) | 787616 | 7.471 / 0.043 | 12.711 / 20.0 | 21.032 | 1088 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.446 | 37.207 | 16 (vanilla 28) | 769356 | 6.909 / 0.116 | 12.444 / 28.0 | 20.544 | 2430 / 0 | 4.226 (10.252) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 850020 | 6.474 / 0.01 | 13.577 / 24.0 | 22.698 | 940 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 545008 | 2.447 / 0.021 | 8.66 / 24.0 | 14.553 | 606 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.718 / 0.124 | 0.131 / 28.0 | 0.225 | 6546 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 19.568 / 0.124 | 0.302 / 28.0 | 0.518 | 6648 / 0 | 1.0 (1.481) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 19.52 / 0.124 | 0.153 / 28.0 | 0.261 | 6695 / 0 | 1.067 (1.767) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 19.276 / 0.122 | 0.142 / 28.0 | 0.237 | 6828 / 0 | 1.165 (1.165) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 16.0 | 0.0 | 0 | 0 | 49 (0.064 / 0.034 / 2.044; 0) | 0 | 31570 / 0 / 0 |
| flythrough | 192.358 | 26.131 | 0.0 | 0 | 0 | 891 (0.023 / 0.036 / 6.051; 0) | 58 | 33855 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1620 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.006 / 0.009 / 0.009; 0) | 32 | 1198 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.086 / 0.133 / 0.598; 0) | 180 | 3738 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 747 | 0 (None / None / None; 0) | 0 | 996 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 756 | 0 (None / None / None; 0) | 0 | 1764 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2224 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 325.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.375; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.449 | 1.0 (0.0, 0.0) | 1.04 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.122 (0.244; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 48.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.064 (0.094; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 50.356 | 10.0 (9.0, 2.366) | 6.0 (6.0, 2.282) | 0.056 (0.25; 0) | 0 | 2784 / 1507228 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.21 | 1.0 (0.0, 0.0) | 0.779 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.401 | 1.0 (0.0, 0.0) | 0.754 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.006 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.042 (0.083; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 260.0 / 323.0 (19.5) | 260.0 / 63.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3213 / 0 |
| flythrough | two-phase | 316.16 / 408.16 (22.5) | 310.6 / 97.56 / 5.56 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4049 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 8787 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 34453 / 0 |
| mobs | two-phase | 32.0 / 110.0 (70.9) | 32.0 / 78.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 11154 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 48.0 (45.8) | 26.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion_move | two-phase | 22.41 / 50.3 (55.4) | 22.36 / 27.94 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4189 / 0 |
| occlusion_corner | two-phase | 60.75 / 81.85 (25.8) | 60.68 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.66 / 135.07 (88.4) | 15.64 / 119.44 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15886 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5394 / 0 |
| translucent_move_oit | two-phase | 15.65 / 134.84 (88.4) | 15.61 / 119.23 / 0.04 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7516 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 19734 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 15150 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 596 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.039 | - / 3.0 | - / 0.0 | - / 0.0 | 100.344 / 0.039 | 0.027 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.155 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.858 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.823 / 54.798 | 0.014 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.5 | - / 0.775 | - / 0.0 | - / 0.0 | - / 0.0 | 39.232 / 8.112 | 0.062 / 0.008 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.003 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.09 / 11.064 | 0.005 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.182 / 54.088 | 0.015 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.471 / 13.302 | 0.005 / 0.012 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 0.0 | - / 0.755 | - / 3.0 | - / 0.0 | - / 0.0 | 1.92 / 1.746 | 0.011 / 0.007 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.009 / 0.048 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.005 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.987 |
| animated_items | - / 28.104 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |
| block_entities | - / 13.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.421 / 11.415 | 0.003 / 0.008 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| core-quicksilver-2p-old | block_entities | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flythrough | 5.48 | 5.48 (0) | 5.48 |  |
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
| core-quicksilver-old | block_entities | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |

Rises of 4 MB or more: none

