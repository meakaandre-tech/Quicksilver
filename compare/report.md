# Quicksilver CI comparison

**passed**

## Suite core

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- old-gpu: 0 / 0
- old-gpu-2p: 0 / 0

**Quick mode** (core suite; vanilla a, vanilla b, Quicksilver old-GPU against vanilla a): the measure-run gates (same-run draw calls, terrain GPU memory, measure pictures) and the full and Vulkan profiles are not run. A merge needs a full run.

| scene | noise (vanilla a/b) % | limit % | old-GPU % | old-GPU two-phase % |
|---|---|---|---|---|
| spawn | 0.4284 | 10.05 | 0.2033 | 0.2923 |
| flythrough | 0.0 | 14.95 | 0.0011 | 0.0011 |
| water_glass | 0.0041 | 6.45 | 0.0059 | 0.0052 |
| nether | 0.0004 | 0.8 | 0.0003 | 0.0003 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 |
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
| translucent_move | 0.0 | 0.3 | 0.0002 | 0.0004 |
| translucent_move.x2404 | 0.0 | 0.3 | 0.0004 | 0.0004 |
| translucent_move.x2414 | 0.0 | 0.3 | 0.0002 | 0.0003 |
| translucent_move.x2424 | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| translucent_move.low | 0.0005 | 0.3 | 0.0014 | 0.0014 |
| translucent_move.back | 0.0001 | 0.3 | 0.0 | 0.0 |
| translucent_move.bare_back | 0.0 | 0.3 | 0.0002 | 0.0 |
| water_glass_oit | 0.0031 | 0.3 | 0.0042 | 0.0038 |
| translucent_move_oit | 0.0 | 0.3 | 0.0 | 0.0001 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0003 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.0002 | 0.0003 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0002 | 0.0002 |
| translucent_move_oit.low | 0.0016 | 0.3 | 0.0012 | 0.0011 |
| translucent_move_oit.back | 0.0 | 0.3 | 0.0 | 0.0 |
| translucent_move_oit.bare_back | 0.0001 | 0.3 | 0.0 | 0.0 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 |

Strict picture: pixels where all three vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| spawn | 99.43 | 18057 | 418 (1051) | 345 (960) |
| flythrough | 100.0 | 6020 | 52 (324) | 52 (324) |
| water_glass | 99.99 | 25508 | 28 (3510) | 23 (3507) |
| nether | 100.0 | 905 | 3 (464) | 3 (464) |
| mobs | 100.0 | 10 | 0 (0) | 0 (0) |
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
| translucent_move | 100.0 | 13 | 1 (123) | 3 (125) |
| translucent_move.x2404 | 100.0 | 15 | 3 (172) | 3 (172) |
| translucent_move.x2414 | 100.0 | 13 | 2 (162) | 4 (164) |
| translucent_move.x2424 | 100.0 | 13 | 1 (121) | 2 (121) |
| translucent_move.low | 100.0 | 41 | 18 (24) | 17 (24) |
| translucent_move.back | 100.0 | 13 | 1 (123) | 3 (125) |
| translucent_move.bare_back | 100.0 | 13 | 3 (125) | 2 (124) |
| water_glass_oit | 99.99 | 57 | 23 (3509) | 19 (3505) |
| translucent_move_oit | 100.0 | 12 | 3 (125) | 3 (125) |
| translucent_move_oit.x2404 | 100.0 | 16 | 4 (173) | 4 (173) |
| translucent_move_oit.x2414 | 100.0 | 10 | 4 (164) | 3 (163) |
| translucent_move_oit.x2424 | 100.0 | 15 | 3 (122) | 2 (121) |
| translucent_move_oit.low | 100.0 | 40 | 16 (22) | 18 (26) |
| translucent_move_oit.back | 100.0 | 12 | 3 (125) | 1 (123) |
| translucent_move_oit.bare_back | 100.0 | 15 | 1 (123) | 3 (125) |
| flat_plants | 100.0 | 350 | 248 (8128) | 248 (8128) |
| renderer_off | 100.0 | 10 | 0 (0) | 0 (0) |
| particles | 100.0 | 4 | 0 (0) | 0 (0) |
| particles.bare | 100.0 | 4 | 0 (0) | 0 (0) |
| animation | 100.0 | 10 | 1 (3) | 1 (3) |
| animation.behind | 100.0 | 10 | 0 (2) | 0 (2) |
| animation.front | 100.0 | 10 | 1 (3) | 1 (3) |
| animated_items | 100.0 | 10 | 0 (0) | 0 (0) |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 49.27 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.72 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 67.21 (reported, not gated) | 41 (reported, not gated) | 482884 (reported, not gated) | 310.01 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.83 (base 20.0) | 13 (base 14) | 7316 (base 10264) | 238.65 (base 249.83) | 4.24 (base 5.99) |
| nether | 23.69 (base 33.79) | 10 (base 11) | 4512 (base 10656) | 259.96 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.7 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.46 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.34 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.69 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 265.26 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.05 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.57 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.55 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 17.98 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 275.21 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7428 (base 7604) | 237.18 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 240.09 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 17.0 (base 33.0) | 13 (base 13) | 1604 (base 1716) | 240.27 (base 248.11) | 3.46 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.53 (base 240.73) | 3.34 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.21 (base 261.4) | 4.24 (base 4.24) |
| animation | 50 median (avg 39.99) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.65 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 47.05) (base 60) | 22 (base 22) | 21668 (base 21668) | 237.35 (base 239.53) | 4.24 (base 5.99) |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 417142.939 (631438.167) | 33.938 | 1.776 | 445796 | 444416 (2097152.0) | 228 | 0.0 / 0 |
| flythrough | 559930.203 (897866.432) | 37.638 | 1.084 | 2105004 | 2096344 (2097152.0) | 148 | 7.342 / 56 |
| water_glass | 112333.542 (195769.004) | 42.619 | 1.124 | 9108 | 0 (2097152.0) | 29 | 0.0 / 0 |
| nether | 39258.163 (60104.473) | 34.683 | 1.905 | 152052 | 147520 (2097152.0) | 143 | 0.0 / 0 |
| mobs | 62497.838 (111618.165) | 44.007 | 0.967 | 610676 | 0 (2097152.0) | 16 | 0.0 / 0 |
| outline | 1057.757 (2295.814) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 27430.758 (47902.467) | 42.736 | 1.302 | 397540 | 299392 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 48972.338 (85771.08) | 42.903 | 1.239 | 766288 | 692352 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 27756.975 (60455.165) | 54.087 | 1.272 | 32932 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 201967.078 (358787.444) | 43.708 | 1.183 | 798036 | 794752 (2097152.0) | 218 | 0.0 / 0 |
| water_glass_oit | 112596.018 (196226.434) | 42.619 | 1.124 | 9108 | 0 (2097152.0) | 226 | 0.0 / 0 |
| translucent_move_oit | 201313.29 (357309.86) | 43.659 | 1.181 | 736644 | 731840 (2097152.0) | 186 | 0.0 / 0 |
| flat_plants | 9100.699 (12476.893) | 27.06 | 1.045 | 2052 | 0 (2097152.0) | 136 | 0.0 / 0 |
| renderer_off | 20073.624 (37973.607) | 47.138 | 1.0 | 1380 | 0 (2097152.0) | 13 | 0.0 / 0 |
| particles | 1698.822 (3676.106) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.1 (5227.74) | 41.77 | 1.087 | 86324 | 84608 (2097152.0) | 1 | 0.0 / 0 |
| animated_items | 2246.003 (4830.871) | 53.507 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 4.391 (88) | 4.228 (41) | 0 | 890 / 0 | 7.965 / 11.524 | 3.486 / 5.254 |
| flythrough | 6.096 (1650) | 6.096 (1650) | 0 | 1402 / 0 | 7.859 / 11.287 | 5.17 / 7.424 |
| water_glass | 2.159 (15) | None (0) | 0 | 1202 / 0 | 7.424 / 10.351 | 3.363 / 4.937 |
| nether | 2.423 (20) | 2.219 (8) | 0 | 1834 / 0 | 6.24 / 8.592 | 2.908 / 4.276 |
| mobs | 0.898 (6) | None (0) | 0 | 2063 / 0 | 6.157 / 8.48 | 2.876 / 4.247 |
| outline | 0.537 (12) | None (0) | 0 | 2122 / 0 | 6.069 / 8.37 | 2.846 / 4.197 |
| occlusion | 0.931 (39) | 3.06 (4) | 0 | 2250 / 0 | 6.051 / 8.267 | 2.81 / 4.091 |
| occlusion_move | 2.645 (63) | 5.162 (15) | 0 | 2420 / 0 | 5.805 / 7.912 | 2.699 / 3.921 |
| occlusion_corner | 1.724 (97) | 1.626 (1) | 0 | 2701 / 0 | 5.429 / 7.393 | 2.494 / 3.67 |
| translucent_move | 3.965 (116) | 6.195 (31) | 0 | 3052 / 0 | 5.401 / 7.441 | 2.573 / 3.797 |
| water_glass_oit | 4.112 (153) | None (0) | 0 | 411 / 0 | 9.411 / 11.023 | 5.016 / 6.056 |
| translucent_move_oit | 4.659 (217) | 5.674 (26) | 0 | 954 / 0 | 6.459 / 8.008 | 3.605 / 4.568 |
| flat_plants | 2.335 (83) | None (0) | 0 | 407 / 0 | 7.271 / 9.026 | 3.174 / 4.585 |
| renderer_off | 0.598 (24) | None (0) | 0 | 324 / 0 | 9.126 / 13.33 | 4.92 / 5.398 |
| particles | 0.392 (30) | None (0) | 0 | 3079 / 0 | 5.359 / 7.382 | 2.548 / 3.78 |
| animation | 0.993 (18) | 1.513 (4) | 0 | 3154 / 0 | 5.26 / 7.237 | 2.479 / 3.67 |
| animated_items | 0.425 (42) | 1.27 (2) | 0 | 3186 / 0 | 5.215 / 7.173 | 2.443 / 3.611 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.171 | 714.329 | 16 (vanilla 28) | 1383556 | 41.552 / 0.112 | 22.921 / 36.0 | 36.945 | 2365 / 0 | 4.228 (8.366) |
| flythrough | plain, one multi-draw per region and layer | 57.473 | 908.682 | 16 (vanilla 28) | 5154904 | 15.234 / 1.003 | 85.237 / 112.0 | 137.651 | 6535 / 0 | 6.096 (17.743) |
| water_glass | plain, one multi-draw per region and layer | 14.029 | 105.219 | 16 (vanilla 28) | 770340 | 33.394 / 0.096 | 12.412 / 36.0 | 20.57 | 3008 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.349 | 60.543 | 16 (vanilla 28) | 954712 | 28.013 / 0.21 | 15.238 / 20.0 | 25.494 | 4055 / 0 | 2.219 (3.459) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.106 | 16 (vanilla 28) | 600308 | 25.459 / 0.183 | 9.607 / 16.0 | 16.03 | 4490 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 96884 | 24.957 / 0.182 | 1.539 / 16.0 | 2.587 | 4584 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.03 | 43.207 | 16 (vanilla 28) | 154664 | 23.953 / 0.174 | 2.478 / 20.0 | 4.13 | 4807 / 0 | 3.06 (5.692) |
| occlusion_move | plain, one multi-draw per region and layer | 10.995 | 75.373 | 16 (vanilla 28) | 207044 | 22.459 / 0.163 | 3.32 / 20.0 | 5.529 | 5138 / 0 | 5.162 (17.962) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.91 | 16 (vanilla 28) | 122728 | 21.225 / 0.154 | 1.931 / 20.0 | 3.277 | 5516 / 0 | 1.626 (1.625) |
| translucent_move | plain, one multi-draw per region and layer | 12.03 | 247.624 | 16 (vanilla 28) | 804440 | 18.428 / 0.138 | 13.048 / 28.0 | 21.481 | 6336 / 0 | 6.195 (12.741) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.071 | 113.5 | 16 (vanilla 28) | 770340 | 7.486 / 0.043 | 12.412 / 20.0 | 20.57 | 1083 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.575 | 261.753 | 16 (vanilla 28) | 781872 | 6.582 / 0.091 | 12.691 / 28.0 | 20.878 | 2404 / 0 | 5.674 (14.701) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 899928 | 5.86 / 0.01 | 14.44 / 24.0 | 24.031 | 930 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 567344 | 2.323 / 0.02 | 9.039 / 24.0 | 15.15 | 603 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.386 / 0.138 | 0.131 / 28.0 | 0.225 | 6378 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 18.238 / 0.137 | 0.302 / 28.0 | 0.518 | 6480 / 0 | 1.513 (2.038) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 18.187 / 0.137 | 0.153 / 28.0 | 0.261 | 6530 / 0 | 1.27 (1.952) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 37 (0.154 / 0.426 / 4.328; 0) | 0 | 35724 / 0 / 0 |
| flythrough | 189.376 | 26.349 | 0.0 | 0 | 0 | 872 (0.024 / 0.046 / 4.552; 0) | 39 | 28217 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1924 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 38 (0.007 / 0.016 / 0.017; 0) | 34 | 1198 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 186 (0.106 / 0.166 / 0.191; 0) | 186 | 2800 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 681 | 0 (None / None / None; 0) | 0 | 908 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 561 | 0 (None / None / None; 0) | 0 | 1309 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2180 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2388 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.082; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.007 | 1.0 (0.0, 0.0) | 1.477 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.045; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.128 (0.266; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.066 (0.106; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.356 | 10.0 (9.0, 2.366) | 6.0 (6.0, 2.28) | 0.06 (0.231; 0) | 0 | 2783 / 1506890 / 0 / 0 |
| occlusion_corner | 81.86 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.193 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.941 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.59 (0.0, 0.0) | 0.0 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.006 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 297.25 / 349.0 (14.8) | 297.25 / 0.0 / 0.0 | 0.1 | 0.0 (0.0, 0.0; 0.0) | 1446.29 | 2844 / 0 |
| flythrough | still | 405.78 / 406.19 (0.1) | 405.78 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10320 / 0 |
| nether | still | 47.68 / 300.0 (84.1) | 47.68 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 194.97 | 32612 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10650 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.12 / 49.0 (46.7) | 26.12 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.0 | 3427 / 0 |
| occlusion_move | still | 51.19 / 51.31 (0.2) | 51.19 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.72 / 81.85 (0.2) | 81.72 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 135.02 / 135.02 (0.0) | 135.02 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4816 / 0 |
| translucent_move_oit | still | 134.06 / 135.22 (0.9) | 134.06 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 152.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 19448 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 604 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 447 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 48 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.167 | - / 3.0 | - / 0.0 | - / 0.0 | 135.228 / 0.17 | 0.029 / 0.008 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.16 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.832 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 53.187 / 53.214 | 0.018 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.616 | - / 0.973 | - / 0.0 | - / 0.0 | - / 0.0 | 45.36 / 10.164 | 0.079 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.633 / 12.63 | 0.006 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.067 / 53.956 | 0.013 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.865 / 12.743 | 0.006 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.279 | - / 0.993 | - / 3.0 | - / 0.0 | - / 0.0 | 2.553 / 2.38 | 0.014 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.005 / 0.04 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.244 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.003 / 0.006 | 56 (3) | 40.51 / 9.23 / 31.28 | 3 / 0 | 10.977 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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

### Counts, core old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 50.0 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.22 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 68.94 (reported, not gated) | 34 (reported, not gated) | 243428 (reported, not gated) | 310.27 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 20.79 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 238.81 (base 249.83) | 4.24 (base 5.99) |
| nether | 24.09 (base 33.79) | 10 (base 11) | 4068 (base 10656) | 259.98 (base 272.57) | 4.24 (base 5.99) |
| mobs | 26.7 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.62 (base 268.23) | 4.24 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.5 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 264.09 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.39 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 11.78 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 269.11 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 275.11 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7652 (base 7604) | 237.29 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.42 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 240.36 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.02 (base 33.0) | 13 (base 13) | 1828 (base 1716) | 239.54 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.73 (base 240.73) | 3.35 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.46 (base 261.4) | 4.24 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.79 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 237.43 (base 239.53) | 4.24 (base 5.99) |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 391985.127 (589839.773) | 33.544 | 1.776 | 716964 | 715584 (2097152.0) | 220 | 0.0 / 0 |
| flythrough | 491390.43 (774698.022) | 36.57 | 1.086 | 2099524 | 2097104 (2097152.0) | 186 | 6.235 / 62 |
| water_glass | 112321.105 (195747.329) | 42.619 | 1.124 | 10564 | 0 (2097152.0) | 17 | 0.0 / 0 |
| nether | 29500.732 (42399.538) | 30.422 | 2.0 | 239028 | 234944 (2097152.0) | 130 | 0.0 / 0 |
| mobs | 62497.645 (111617.821) | 44.007 | 0.967 | 610676 | 0 (2097152.0) | 2 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29487.145 (51972.621) | 43.264 | 1.279 | 231688 | 133632 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 22236.917 (39147.133) | 43.197 | 1.26 | 643132 | 568064 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 21840.097 (47208.127) | 53.737 | 1.215 | 32840 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 21628.672 (27688.489) | 21.886 | 1.005 | 797044 | 794880 (2097152.0) | 133 | 0.0 / 0 |
| water_glass_oit | 112553.846 (196152.939) | 42.619 | 1.124 | 9892 | 0 (2097152.0) | 247 | 0.0 / 0 |
| translucent_move_oit | 21727.532 (27846.278) | 21.973 | 1.005 | 738804 | 731840 (2097152.0) | 252 | 0.0 / 0 |
| flat_plants | 9100.607 (12476.768) | 27.06 | 1.045 | 2164 | 0 (2097152.0) | 137 | 0.0 / 0 |
| renderer_off | 20073.4 (37973.183) | 47.138 | 1.0 | 1380 | 0 (2097152.0) | 5 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79144 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 2.878 (91) | 2.999 (44) | 0 | 863 / 0 | 6.669 / 9.323 | 2.951 / 4.746 |
| flythrough | 3.916 (1730) | 3.916 (1730) | 0 | 1403 / 0 | 5.597 / 8.021 | 3.719 / 5.414 |
| water_glass | 2.173 (14) | None (0) | 0 | 1184 / 0 | 5.933 / 8.169 | 2.692 / 4.162 |
| nether | 1.735 (29) | 1.815 (14) | 0 | 1807 / 0 | 4.758 / 6.521 | 2.152 / 3.13 |
| mobs | 0.78 (6) | None (0) | 0 | 2038 / 0 | 4.532 / 6.189 | 2.107 / 3.041 |
| outline | 0.318 (13) | None (0) | 0 | 2097 / 0 | 4.468 / 6.107 | 2.091 / 3.016 |
| occlusion | 1.023 (51) | 2.696 (2) | 0 | 2239 / 0 | 4.321 / 5.907 | 1.997 / 2.922 |
| occlusion_move | 1.333 (68) | 2.882 (20) | 0 | 2402 / 0 | 4.144 / 5.66 | 1.908 / 2.774 |
| occlusion_corner | 0.911 (110) | 1.219 (1) | 0 | 2682 / 0 | 3.865 / 5.245 | 1.74 / 2.475 |
| translucent_move | 2.325 (113) | 4.264 (32) | 0 | 3039 / 0 | 3.799 / 5.187 | 1.782 / 2.556 |
| water_glass_oit | 3.093 (153) | None (0) | 0 | 410 / 0 | 5.482 / 7.68 | 2.773 / 4.394 |
| translucent_move_oit | 3.265 (222) | 4.536 (25) | 0 | 968 / 0 | 3.892 / 5.445 | 2.026 / 2.849 |
| flat_plants | 1.686 (83) | None (0) | 0 | 405 / 0 | 5.837 / 6.906 | 2.19 / 2.739 |
| renderer_off | 0.96 (22) | None (0) | 0 | 325 / 0 | 6.71 / 9.26 | 2.75 / 4.301 |
| particles | 0.307 (30) | None (0) | 0 | 3067 / 0 | 3.769 / 5.144 | 1.761 / 2.522 |
| animation | 0.694 (18) | 0.858 (4) | 0 | 3142 / 0 | 3.695 / 5.042 | 1.713 / 2.434 |
| animated_items | 0.298 (42) | 0.874 (2) | 0 | 3174 / 0 | 3.663 / 4.996 | 1.692 / 2.365 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.182 | 653.791 | 16 (vanilla 28) | 1379560 | 40.838 / 0.095 | 22.871 / 36.0 | 36.838 | 2308 / 0 | 2.999 (7.368) |
| flythrough | plain, one multi-draw per region and layer | 58.134 | 773.296 | 16 (vanilla 28) | 5325672 | 15.134 / 1.004 | 87.929 / 112.0 | 142.211 | 6715 / 0 | 3.916 (11.935) |
| water_glass | plain, one multi-draw per region and layer | 14.028 | 105.207 | 16 (vanilla 28) | 786612 | 33.349 / 0.082 | 12.688 / 36.0 | 21.005 | 2983 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.083 | 16 (vanilla 28) | 954760 | 28.008 / 0.196 | 15.237 / 20.0 | 25.495 | 4028 / 0 | 1.815 (2.897) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.105 | 16 (vanilla 28) | 600308 | 25.424 / 0.171 | 9.607 / 16.0 | 16.03 | 4468 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 96884 | 24.916 / 0.17 | 1.539 / 16.0 | 2.587 | 4563 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 162272 | 23.587 / 0.16 | 2.594 / 20.0 | 4.333 | 4838 / 0 | 2.696 (3.279) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.873 | 16 (vanilla 28) | 209444 | 22.202 / 0.15 | 3.335 / 20.0 | 5.593 | 5160 / 0 | 2.882 (5.769) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.068 | 60.888 | 16 (vanilla 28) | 122728 | 20.946 / 0.142 | 1.931 / 20.0 | 3.277 | 5549 / 0 | 1.219 (1.218) |
| translucent_move | plain, one multi-draw per region and layer | 4.399 | 23.146 | 16 (vanilla 28) | 806480 | 18.211 / 0.129 | 13.051 / 28.0 | 21.535 | 6386 / 0 | 4.264 (10.817) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.065 | 113.457 | 16 (vanilla 28) | 770340 | 7.475 / 0.043 | 12.412 / 20.0 | 20.57 | 1085 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.452 | 37.286 | 16 (vanilla 28) | 780648 | 6.897 / 0.117 | 12.64 / 28.0 | 20.846 | 2431 / 0 | 4.536 (12.624) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 892260 | 5.904 / 0.01 | 14.297 / 24.0 | 23.826 | 924 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 567336 | 2.319 / 0.02 | 9.039 / 24.0 | 15.15 | 606 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.166 / 0.129 | 0.131 / 28.0 | 0.225 | 6430 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.022 / 0.128 | 0.302 / 28.0 | 0.518 | 6532 / 0 | 0.858 (1.374) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.972 / 0.128 | 0.153 / 28.0 | 0.261 | 6582 / 0 | 0.874 (1.306) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 151.552 | 17.0 | 0.0 | 0 | 0 | 36 (0.024 / 0.033 / 0.043; 0) | 0 | 33493 / 0 / 0 |
| flythrough | 193.711 | 26.348 | 0.0 | 0 | 0 | 919 (0.017 / 0.039 / 3.208; 0) | 63 | 36224 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2032 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.007 / 0.01 / 0.01; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.082 / 0.125 / 0.292; 0) | 180 | 3759 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 744 | 0 (None / None / None; 0) | 0 | 992 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 759 | 0 (None / None / None; 0) | 0 | 1771 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2192 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 341.57 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.09; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 437.567 | 1.0 (0.0, 0.0) | 1.85 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.064; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.12 (0.245; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.068 (0.143; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.361) | 6.0 (6.0, 2.276) | 0.058 (0.217; 0) | 0 | 2787 / 1509018 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.25 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.439 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.094; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 265.28 / 339.54 (21.9) | 265.27 / 74.27 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4084 / 0 |
| flythrough | two-phase | 319.53 / 412.21 (22.5) | 314.27 / 97.94 / 5.26 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4229 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10836 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 33927 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10650 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.4 / 51.32 (56.3) | 22.35 / 28.97 / 0.05 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4342 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.69 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.69 / 135.12 (88.4) | 15.67 / 119.45 / 0.02 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 16006 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5332 / 0 |
| translucent_move_oit | two-phase | 15.68 / 134.83 (88.4) | 15.64 / 119.19 / 0.04 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7514 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 19591 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15150 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 894 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 67.558 / 0.0 | 0.021 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.167 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.856 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.96 / 54.925 | 0.022 / 0.027 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.495 | - / 0.842 | - / 0.0 | - / 0.0 | - / 0.0 | 44.275 / 7.627 | 0.069 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.575 / 12.521 | 0.005 / 0.011 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 56.733 / 56.718 | 0.015 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 14.107 / 13.976 | 0.004 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.294 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 4.389 / 4.097 | 0.02 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.007 / 0.049 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.004 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.987 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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

## Suite siftec

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-old: bench kinetics_instancing: median meshing time 1.394 ms per section against vanilla's compiler 1.134 ms (1.229x; limit 1.134 ms; 154 pairs): reported, not gated (open gap)

siftec/quicksilver-old: bench factory_flat: median meshing time 0.365 ms per section against vanilla's compiler 0.343 ms (1.064x; limit 0.377 ms; 597 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench kinetics_instancing: median meshing time 3.429 ms per section against vanilla's compiler 1.834 ms (1.87x; limit 1.834 ms; 150 pairs): reported, not gated (open gap)

siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.798 ms per section against vanilla's compiler 0.643 ms (1.241x; limit 0.707 ms; 609 pairs): reported, not gated (open gap)

- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- old-gpu: 54 / 54
- old-gpu-2p: 54 / 54

**Quick mode** (core suite; vanilla a, vanilla b, Quicksilver old-GPU against vanilla a): the measure-run gates (same-run draw calls, terrain GPU memory, measure pictures) and the full and Vulkan profiles are not run. A merge needs a full run.

| scene | noise (vanilla a/b) % | limit % | old-GPU % | old-GPU two-phase % |
|---|---|---|---|---|
| factory | 0.0169 | 0.3 | 0.0 | 0.0 |
| factory_flat | 0.0034 | 0.3 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0068 | 0.0068 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0033 | 0.55 | 0.0055 | 0.0065 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 |
| kinetics | 0.0035 | 0.25 | 0.0174 | 0.0008 |
| kinetics_instancing | 0.0101 | 0.25 | 0.0053 | 0.0082 |

Strict picture: pixels where all three vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| factory | 99.96 | 370 | 0 (15) | 0 (15) |
| factory_flat | 94.16 | 40 | 0 (16) | 0 (16) |
| sift | 100.0 | 100 | 85 (752) | 85 (752) |
| hub | 100.0 | 10 | 0 (0) | 0 (0) |
| mam | 91.48 | 10 | 0 (0) | 0 (0) |
| ponder | 100.0 | 10 | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 31 (4271) | 41 (4281) |
| create_ct | 100.0 | 10 | 0 (0) | 0 (0) |
| kinetics | 98.55 | 30 | 9 (1141) | 9 (1141) |
| kinetics_instancing | 98.55 | 30 | 9 (1141) | 9 (1141) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 15.93 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.02 (base 361.53) | 3.73 (base 5.48) |
| factory_flat | 15.95 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.22 (base 360.27) | 5.48 (base 5.48) |
| sift | 34.91 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.54 (base 379.69) | 3.73 (base 4.24) |
| hub | 20.53 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 396.75 (base 392.07) | 3.73 (base 5.99) |
| mam | 21.53 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.54 (base 404.98) | 7.73 (base 7.73) |
| ponder | 87.25 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.18 (base 403.64) | 7.73 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42980 (base 43652) | 396.29 (base 392.54) | 7.54 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.48 (base 393.74) | 7.54 (base 8.24) |
| kinetics | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.68 (base 396.01) | 7.54 (base 8.06) |
| kinetics_instancing | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 359.47 (base 360.95) | 3.48 (base 5.48) |

Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14349.95 (27750.732) | 48.29 | 1.0 | 149844 | 100928 (2097152.0) | 2 | 0.0 / 0 |
| factory_flat | 14412.354 (27856.795) | 48.263 | 1.0 | 149844 | 100928 (2097152.0) | 0 | 0.0 / 0 |
| sift | 115613.947 (157972.393) | 26.814 | 1.431 | 4148 | 0 (2097152.0) | 31 | 0.0 / 0 |
| hub | 474.79 (783.303) | 39.386 | 1.0 | 83908 | 0 (2097152.0) | 1 | 0.0 / 0 |
| mam | 568.95 (925.545) | 38.528 | 1.25 | 40068 | 0 (2097152.0) | 3 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 | 0 (2097152.0) | 2 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 45108 | 0 (2097152.0) | 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 1 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| factory | 2.474 (35) | 2.338 (12) | 0 | 964 / 0 | 5.434 / 6.814 | 2.116 / 2.803 |
| factory_flat | 1.341 (69) | 1.241 (13) | 0 | 597 / 0 | 1.684 / 1.766 | 0.365 / 0.343 |
| sift | 0.903 (41) | None (0) | 0 | 1507 / 0 | 4.207 / 5.327 | 1.415 / 2.279 |
| hub | 0.25 (8) | None (0) | 0 | 1561 / 0 | 4.151 / 5.253 | 1.389 / 2.213 |
| mam | 0.325 (4) | None (0) | 0 | 1878 / 0 | 4.165 / 5.385 | 1.527 / 2.378 |
| ponder | None (0) | None (0) | 0 | 1879 / 0 | 4.163 / 5.382 | 1.526 / 2.378 |
| hologram | 0.889 (25) | None (0) | 0 | 1912 / 0 | 4.149 / 5.349 | 1.526 / 2.347 |
| create_ct | 0.41 (60) | None (0) | 0 | 1968 / 0 | 4.067 / 5.233 | 1.485 / 2.293 |
| kinetics | None (0) | None (0) | 0 | 2063 / 0 | 3.929 / 5.036 | 1.411 / 2.05 |
| kinetics_instancing | None (0) | None (0) | 0 | 154 / 0 | 4.506 / 4.724 | 1.394 / 1.134 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.247 | 34.582 | 16 (vanilla 28) | 96100 | 26.771 / 0.366 | 1.511 / 28.0 | 2.566 | 2052 / 0 | 2.338 (2.428) |
| factory_flat | plain, one multi-draw per region and layer | 4.267 | 34.788 | 16 (vanilla 28) | 96084 | 2.721 / 0.025 | 1.511 / 8.0 | 2.566 | 801 / 0 | 1.241 (1.46) |
| sift | plain, one multi-draw per region and layer | 17.035 | 320.654 | 16 (vanilla 28) | 462608 | 24.585 / 0.38 | 7.389 / 16.0 | 12.353 | 3061 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 23.932 / 0.369 | 1.879 / 12.0 | 3.137 | 3145 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1191888 | 24.447 / 0.388 | 20.302 / 32.0 | 31.827 | 3801 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1022712 | 24.447 / 0.388 | 17.618 / 32.0 | 27.309 | 3802 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 24.253 / 0.383 | 0.238 / 32.0 | 0.367 | 3866 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.826 / 0.376 | 0.171 / 32.0 | 0.283 | 3974 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 23.788 / 0.391 | 0.372 / 32.0 | 0.624 | 4087 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 35436 | 5.653 / 0.238 | 0.563 / 8.0 | 0.946 | 183 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2940 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.006 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.52 / 69.0 (57.2) | 29.52 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.48 | 5880 / 0 |
| factory_flat | still | 29.73 / 69.0 (56.9) | 29.73 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.0 | 6006 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 8418 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5100 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7748 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 450 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.005 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | - / 8.098 | - / 0.0 | - / 4.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 148.017 / 90.151 | 0.12 / 0.041 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| factory_flat | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| sift | 5.0 / - | 0.0 / - | 20.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| hub | 13.87 / - | 0.0 / - | 574.37 / - | 6.0 / - (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / - (8.0 / -) |
| mam | 13.86 / - | 1.0 / - | 113.19 / - | 7.0 / - (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / - (8.0 / -) |
| ponder | 82.59 / - | 0.0 / - | 203.73 / - | 73.0 / - (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / - (75.0 / -) |
| hologram | 16.0 / - | 0.0 / - | 163.0 / - | 5.0 / - (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / - (5.0 / -) |
| create_ct | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |
| kinetics | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |
| kinetics_instancing | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.68 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 364.74 (base 361.53) | 3.73 (base 5.48) |
| factory_flat | 16.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 362.03 (base 360.27) | 3.48 (base 5.48) |
| sift | 38.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 382.95 (base 379.69) | 3.73 (base 4.24) |
| hub | 21.55 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 395.32 (base 392.07) | 3.73 (base 5.99) |
| mam | 22.55 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 408.66 (base 404.98) | 7.73 (base 7.73) |
| ponder | 88.23 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 405.6 (base 403.64) | 7.73 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43540 (base 43652) | 395.36 (base 392.54) | 7.54 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 396.33 (base 393.74) | 7.54 (base 8.24) |
| kinetics | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 395.57 (base 396.01) | 7.54 (base 8.06) |
| kinetics_instancing | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 358.5 (base 360.95) | 3.48 (base 5.48) |

Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.898 (26448.577) | 48.64 | 1.0 | 149844 | 100928 (2097152.0) | 10 | 0.0 / 0 |
| factory_flat | 13583.466 (26447.728) | 48.64 | 1.0 | 149844 | 100928 (2097152.0) | 5 | 0.0 / 0 |
| sift | 115744.279 (158150.476) | 26.814 | 1.431 | 4148 | 0 (2097152.0) | 315 | 0.0 / 0 |
| hub | 474.793 (783.308) | 39.386 | 1.0 | 83908 | 0 (2097152.0) | 1 | 0.0 / 0 |
| mam | 568.956 (925.556) | 38.528 | 1.25 | 40068 | 0 (2097152.0) | 5 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 | 0 (2097152.0) | 1 | 0.0 / 0 |
| hologram | 3670.107 (6346.56) | 42.172 | 1.0 | 46340 | 0 (2097152.0) | 0 | 0.0 / 0 |
| create_ct | 2538.23 (5312.855) | 52.225 | 1.0 | 1124 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics | 5437.047 (10385.28) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 1 | 0.0 / 0 |
| kinetics_instancing | 5437.047 (10385.28) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 1 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| factory | 3.814 (35) | 4.999 (12) | 0 | 868 / 0 | 9.663 / 13.603 | 6.091 / 8.294 |
| factory_flat | 2.079 (69) | 1.95 (13) | 0 | 609 / 0 | 2.667 / 2.602 | 0.798 / 0.643 |
| sift | 1.712 (41) | None (0) | 0 | 1410 / 0 | 7.122 / 9.977 | 3.465 / 4.977 |
| hub | 0.41 (4) | None (0) | 0 | 1461 / 0 | 7.043 / 9.82 | 3.448 / 4.887 |
| mam | 0.529 (4) | None (0) | 0 | 1761 / 0 | 7.347 / 10.352 | 4.004 / 5.916 |
| ponder | None (0) | None (0) | 0 | 1762 / 0 | 7.343 / 10.346 | 4.001 / 5.915 |
| hologram | 1.254 (19) | None (0) | 0 | 1795 / 0 | 7.308 / 10.275 | 3.986 / 5.865 |
| create_ct | 0.857 (46) | None (0) | 0 | 1851 / 0 | 7.156 / 10.038 | 3.663 / 5.568 |
| kinetics | None (0) | None (0) | 0 | 1946 / 0 | 6.905 / 9.642 | 3.449 / 5.128 |
| kinetics_instancing | None (0) | None (0) | 0 | 150 / 0 | 8.257 / 8.089 | 3.429 / 1.834 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 26.148 / 0.263 | 1.511 / 28.0 | 2.566 | 1818 / 0 | 4.999 (14.448) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96084 | 2.785 / 0.024 | 1.511 / 8.0 | 2.566 | 825 / 0 | 1.95 (2.312) |
| sift | plain, one multi-draw per region and layer | 17.054 | 321.016 | 16 (vanilla 28) | 462608 | 23.943 / 0.298 | 7.389 / 16.0 | 12.353 | 2826 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 23.317 / 0.29 | 1.879 / 12.0 | 3.137 | 2901 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1162296 | 24.025 / 0.322 | 19.815 / 32.0 | 31.037 | 3526 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1008744 | 24.025 / 0.322 | 17.383 / 32.0 | 26.936 | 3527 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 23.825 / 0.317 | 0.238 / 32.0 | 0.367 | 3591 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 23.387 / 0.312 | 0.171 / 32.0 | 0.283 | 3697 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 23.355 / 0.328 | 0.372 / 32.0 | 0.624 | 3810 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 60312 | 6.127 / 0.311 | 0.95 / 8.0 | 1.611 | 168 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1896 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 599 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 595 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.046; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.026; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6174 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 6258 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5451 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5100 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 7748 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |
| kinetics_instancing | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | - / 10.0 | - / 0.0 | - / 4.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 162.469 / 96.75 | 0.148 / 0.045 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| factory_flat | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| sift | 5.0 / - | 0.0 / - | 20.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| hub | 13.88 / - | 0.0 / - | 575.61 / - | 6.0 / - (pipelines 6.0, textures 5.0, scissors 1.0) | 13.88 / - (8.0 / -) |
| mam | 13.88 / - | 1.0 / - | 113.59 / - | 7.0 / - (pipelines 6.0, textures 6.0, scissors 1.0) | 13.88 / - (8.0 / -) |
| ponder | 82.57 / - | 0.11 / - | 203.85 / - | 73.0 / - (pipelines 6.0, textures 72.0, scissors 1.0) | 81.6 / - (75.0 / -) |
| hologram | 16.0 / - | 0.0 / - | 163.0 / - | 5.0 / - (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / - (5.0 / -) |
| create_ct | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |
| kinetics | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |
| kinetics_instancing | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |

## Flywheel (package 5)

Flywheel's own backend choice per run (CI's pin mod), and in Quicksilver's runs its visuals and the frames it drew before the terrain in the kinetics scene's bench.

| run | backend per session | kinetics: visuals | frames drawing before terrain |
|---|---|---|---|
| vanilla-a | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| vanilla-b | flywheel:indirect, flywheel:indirect, flywheel:instancing | - | - / - |
| quicksilver-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 600 |
| vanilla-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |

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
| core-quicksilver-2p-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
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
| core-quicksilver-old | flat_plants | 3.46 | 3.46 (0) | 3.46 |  |
| core-quicksilver-old | renderer_off | 3.34 | 3.34 (0) | 3.34 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-2p-old | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-2p-old | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-2p-old | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-2p-old | kinetics | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-2p-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-2p-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-old | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-old | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-old | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | kinetics | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-old | factory_flat | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |

Rises of 4 MB or more: siftec-quicksilver-2p-old/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00

