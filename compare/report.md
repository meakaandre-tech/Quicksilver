# Quicksilver CI comparison

**passed**

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
| spawn | 0.4391 | 10.05 | 0.3086 | 0.2968 |
| flythrough | 0.0 | 14.95 | 0.0005 | 0.0005 |
| water_glass | 0.0029 | 6.45 | 0.0041 | 0.0033 |
| nether | 0.0106 | 0.8 | 0.0103 | 0.0103 |
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
| translucent_move | 0.0 | 0.3 | 0.0 | 0.0 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0003 |
| translucent_move.x2414 | 0.0 | 0.3 | 0.0001 | 0.0001 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.0003 | 0.0003 |
| translucent_move.low | 0.0004 | 0.3 | 0.0011 | 0.0013 |
| translucent_move.back | 0.0002 | 0.3 | 0.0001 | 0.0 |
| translucent_move.bare_back | 0.0 | 0.3 | 0.0001 | 0.0 |
| water_glass_oit | 0.0033 | 0.3 | 0.0028 | 0.0043 |
| translucent_move_oit | 0.0002 | 0.3 | 0.0003 | 0.0002 |
| translucent_move_oit.x2404 | 0.0002 | 0.3 | 0.0005 | 0.0007 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0003 | 0.0003 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0002 | 0.0002 |
| translucent_move_oit.low | 0.0011 | 0.3 | 0.0018 | 0.0016 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0003 | 0.3 | 0.0002 | 0.0003 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 |

Strict picture: pixels where both vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| spawn | 99.47 | 18057 | 576 (1288) | 496 (1198) |
| flythrough | 100.0 | 6020 | 45 (317) | 45 (317) |
| water_glass | 100.0 | 25508 | 29 (3513) | 19 (3504) |
| nether | 99.99 | 905 | 3 (461) | 3 (461) |
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
| translucent_move | 100.0 | 13 | 1 (123) | 2 (124) |
| translucent_move.x2404 | 100.0 | 15 | 5 (174) | 4 (173) |
| translucent_move.x2414 | 100.0 | 13 | 2 (162) | 3 (163) |
| translucent_move.x2424 | 100.0 | 13 | 1 (120) | 1 (120) |
| translucent_move.low | 100.0 | 41 | 14 (21) | 18 (24) |
| translucent_move.back | 100.0 | 13 | 2 (124) | 1 (124) |
| translucent_move.bare_back | 100.0 | 13 | 2 (124) | 1 (123) |
| water_glass_oit | 100.0 | 57 | 16 (3501) | 27 (3512) |
| translucent_move_oit | 100.0 | 12 | 2 (124) | 2 (124) |
| translucent_move_oit.x2404 | 100.0 | 16 | 5 (174) | 6 (175) |
| translucent_move_oit.x2414 | 100.0 | 10 | 3 (163) | 2 (162) |
| translucent_move_oit.x2424 | 100.0 | 15 | 6 (125) | 2 (121) |
| translucent_move_oit.low | 100.0 | 40 | 15 (22) | 15 (21) |
| translucent_move_oit.back | 100.0 | 12 | 2 (124) | 1 (123) |
| translucent_move_oit.bare_back | 100.0 | 15 | 2 (124) | 3 (125) |
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
| spawn | 48.11 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.11 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 67.27 (reported, not gated) | 36 (reported, not gated) | 279780 (reported, not gated) | 311.33 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.71 (base 20.0) | 13 (base 14) | 7092 (base 10264) | 238.66 (base 249.83) | 3.99 (base 5.99) |
| nether | 23.35 (base 33.79) | 10 (base 11) | 4084 (base 10656) | 260.06 (base 272.57) | 3.99 (base 5.99) |
| mobs | 25.68 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.69 (base 268.23) | 3.99 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.34 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 18.71 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 264.2 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 24.04 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.69 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.84 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 17.87 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 275.49 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7764 (base 7604) | 237.62 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 240.43 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 16.79 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 239.77 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.85 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.42 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.06) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.59 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 60 median (avg 47.05) (base 60) | 22 (base 22) | 21668 (base 21668) | 237.12 (base 239.53) | 5.99 (base 5.99) |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 403537.494 (610630.657) | 33.915 | 1.775 | 347508 | 345088 (2097152.0) | 265 | 0.0 / 0 |
| flythrough | 563325.968 (902321.892) | 37.569 | 1.083 | 2106028 | 2096360 (2097152.0) | 186 | 6.882 / 72 |
| water_glass | 112819.463 (196871.556) | 42.694 | 1.133 | 9220 | 0 (2097152.0) | 8 | 0.0 / 0 |
| nether | 43268.089 (67374.935) | 35.78 | 1.882 | 187296 | 182784 (2097152.0) | 138 | 0.0 / 0 |
| mobs | 62138.401 (110929.949) | 43.984 | 0.967 | 610676 | 0 (2097152.0) | 6 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29401.683 (51765.756) | 43.202 | 1.278 | 250212 | 152064 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 51717.607 (91231.047) | 43.311 | 1.219 | 818848 | 743872 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_corner | 27770.988 (60486.905) | 54.088 | 1.272 | 32840 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 203588.013 (361733.62) | 43.719 | 1.174 | 753316 | 748288 (2097152.0) | 20 | 0.0 / 0 |
| water_glass_oit | 113054.504 (197281.705) | 42.694 | 1.133 | 9332 | 0 (2097152.0) | 258 | 0.0 / 0 |
| translucent_move_oit | 203647.696 (361625.06) | 43.685 | 1.172 | 753876 | 748288 (2097152.0) | 217 | 0.0 / 0 |
| flat_plants | 9100.516 (12476.644) | 27.06 | 1.045 | 2052 | 0 (2097152.0) | 137 | 0.0 / 0 |
| renderer_off | 19374.29 (36601.002) | 47.066 | 1.0 | 1380 | 0 (2097152.0) | 0 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.467 (5228.568) | 41.772 | 1.087 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2246.003 (4830.871) | 53.507 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 2.982 (101) | 3.096 (57) | 0 | 860 / 0 | 6.589 / 8.752 | 2.849 / 4.756 |
| flythrough | 4.635 (1724) | 4.635 (1724) | 0 | 1393 / 0 | 5.691 / 8.283 | 3.503 / 5.478 |
| water_glass | 1.509 (15) | None (0) | 0 | 1169 / 0 | 5.946 / 7.963 | 2.699 / 4.286 |
| nether | 2.162 (28) | 2.235 (13) | 0 | 1790 / 0 | 4.939 / 6.524 | 2.29 / 3.269 |
| mobs | 0.685 (6) | None (0) | 0 | 2022 / 0 | 4.712 / 6.216 | 2.219 / 3.196 |
| outline | 0.374 (13) | None (0) | 0 | 2080 / 0 | 4.639 / 6.14 | 2.167 / 3.177 |
| occlusion | 1.05 (48) | 3.439 (2) | 0 | 2208 / 0 | 4.598 / 6.144 | 2.119 / 3.1 |
| occlusion_move | 1.958 (56) | 4.799 (17) | 0 | 2366 / 0 | 4.406 / 5.899 | 2.059 / 2.969 |
| occlusion_corner | 1.043 (110) | 0.926 (1) | 0 | 2646 / 0 | 4.12 / 5.465 | 1.835 / 2.638 |
| translucent_move | 2.365 (118) | 3.945 (35) | 0 | 3026 / 0 | 4.109 / 5.509 | 1.917 / 2.765 |
| water_glass_oit | 3.14 (153) | None (0) | 0 | 410 / 0 | 7.403 / 9.909 | 4.058 / 5.588 |
| translucent_move_oit | 2.963 (223) | 3.617 (26) | 0 | 965 / 0 | 4.833 / 6.529 | 2.349 / 3.574 |
| flat_plants | 1.518 (86) | None (0) | 0 | 404 / 0 | 5.614 / 7.082 | 2.415 / 3.026 |
| renderer_off | 0.438 (23) | None (0) | 0 | 319 / 0 | 6.778 / 8.387 | 2.305 / 3.604 |
| particles | 0.301 (30) | None (0) | 0 | 3054 / 0 | 4.076 / 5.464 | 1.897 / 2.715 |
| animation | 0.837 (18) | 1.058 (4) | 0 | 3129 / 0 | 3.998 / 5.357 | 1.822 / 2.623 |
| animated_items | 0.3 (38) | 0.789 (2) | 0 | 3161 / 0 | 3.963 / 5.307 | 1.791 / 2.58 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 38.143 | 684.034 | 16 (vanilla 28) | 1333360 | 42.299 / 0.124 | 22.093 / 36.0 | 35.605 | 2352 / 0 | 3.096 (6.776) |
| flythrough | plain, one multi-draw per region and layer | 57.473 | 918.048 | 16 (vanilla 28) | 5318916 | 15.037 / 0.997 | 87.82 / 112.0 | 142.03 | 6688 / 0 | 4.635 (13.955) |
| water_glass | plain, one multi-draw per region and layer | 14.025 | 105.188 | 16 (vanilla 28) | 770792 | 34.11 / 0.105 | 12.419 / 36.0 | 20.582 | 2991 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.481 | 67.49 | 16 (vanilla 28) | 956516 | 28.601 / 0.203 | 15.213 / 20.0 | 25.542 | 4024 / 0 | 2.235 (3.151) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.103 | 16 (vanilla 28) | 605148 | 25.985 / 0.178 | 9.686 / 16.0 | 16.159 | 4466 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 91864 | 25.5 / 0.176 | 1.457 / 16.0 | 2.453 | 4562 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.05 | 43.352 | 16 (vanilla 28) | 161864 | 24.355 / 0.168 | 2.589 / 20.0 | 4.322 | 4793 / 0 | 3.439 (3.473) |
| occlusion_move | plain, one multi-draw per region and layer | 10.987 | 76.293 | 16 (vanilla 28) | 225960 | 22.857 / 0.157 | 3.603 / 20.0 | 6.034 | 5087 / 0 | 4.799 (12.676) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.955 | 16 (vanilla 28) | 122728 | 21.561 / 0.148 | 1.931 / 20.0 | 3.277 | 5476 / 0 | 0.926 (0.916) |
| translucent_move | plain, one multi-draw per region and layer | 12.009 | 248.954 | 16 (vanilla 28) | 808484 | 18.411 / 0.132 | 13.079 / 28.0 | 21.589 | 6367 / 0 | 3.945 (12.038) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.062 | 113.438 | 16 (vanilla 28) | 770792 | 7.544 / 0.043 | 12.419 / 20.0 | 20.582 | 1083 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.567 | 263.7 | 16 (vanilla 28) | 786032 | 6.925 / 0.117 | 12.73 / 28.0 | 20.989 | 2422 / 0 | 3.617 (8.258) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 863216 | 6.208 / 0.01 | 13.835 / 24.0 | 23.05 | 936 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 541400 | 2.427 / 0.021 | 8.622 / 24.0 | 14.457 | 598 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.364 / 0.132 | 0.131 / 28.0 | 0.225 | 6411 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.524 | 16 (vanilla 28) | 19416 | 18.221 / 0.131 | 0.302 / 28.0 | 0.518 | 6513 / 0 | 1.058 (1.588) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 18.175 / 0.131 | 0.153 / 28.0 | 0.261 | 6560 / 0 | 0.789 (1.223) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 152.617 | 16.0 | 0.0 | 0 | 0 | 53 (0.079 / 0.035 / 3.049; 0) | 0 | 40596 / 0 / 0 |
| flythrough | 193.578 | 26.321 | 0.0 | 0 | 0 | 904 (0.019 / 0.036 / 5.551; 0) | 50 | 36199 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2240 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.006 / 0.009 / 0.009; 0) | 32 | 1202 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.096 / 0.128 / 2.498; 0) | 180 | 3213 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 777 | 0 (None / None / None; 0) | 0 | 1036 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 654 | 0 (None / None / None; 0) | 0 | 1526 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2204 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 325.632 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.027 (0.08; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.727 | 1.0 (0.0, 0.0) | 1.567 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.013 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.123 (0.224; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.061 (0.11; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.364 | 10.0 (9.0, 2.366) | 6.0 (6.0, 2.278) | 0.053 (0.199; 0) | 0 | 2791 / 1511622 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.1 | 1.0 (0.0, 0.0) | 0.771 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.748 | 1.0 (0.0, 0.0) | 0.752 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.027; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 111.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 283.21 / 323.61 (12.5) | 283.21 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1569.92 | 2702 / 0 |
| flythrough | still | 408.99 / 409.32 (0.1) | 408.99 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11954 / 0 |
| nether | still | 52.04 / 300.0 (82.7) | 52.04 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 265.68 | 33401 / 0 |
| mobs | still | 32.0 / 110.0 (70.9) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11388 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.23 / 49.0 (46.5) | 26.23 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.0 | 3404 / 0 |
| occlusion_move | still | 51.13 / 51.32 (0.4) | 51.13 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 37 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 135.47 / 135.94 (0.3) | 135.47 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 139.0 (61.9) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5504 / 0 |
| translucent_move_oit | still | 135.13 / 136.13 (0.7) | 135.13 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 19596 / 0 |
| renderer_off | still | 11.0 / 111.0 (90.1) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 14900 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 447 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 48 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 118.128 / 0.0 | 0.028 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.234 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.856 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 52.198 / 52.132 | 0.02 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.375 | - / 0.763 | - / 0.0 | - / 0.0 | - / 0.0 | 38.438 / 6.57 | 0.067 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.192 / 12.122 | 0.005 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 57.1 / 57.081 | 0.016 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.309 / 12.193 | 0.007 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.273 | - / 0.791 | - / 3.0 | - / 0.0 | - / 0.0 | 1.786 / 1.63 | 0.013 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.01 / 0.054 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.005 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.987 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 50.0 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 254.02 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 69.52 (reported, not gated) | 45 (reported, not gated) | 561156 (reported, not gated) | 308.83 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.89 (base 20.0) | 13 (base 14) | 7428 (base 10264) | 238.79 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.05 (base 33.79) | 10 (base 11) | 4392 (base 10656) | 259.97 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.74 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.55 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 258.56 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 264.19 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 20.08 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 265.0 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.72 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 269.02 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 2744 (reported, not gated) | 275.52 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7764 (base 7604) | 237.23 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.41 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 239.9 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.24 (base 33.0) | 13 (base 13) | 1604 (base 1716) | 239.47 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 13.68 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.34 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.42 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.87 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 22 (base 22) | 21668 (base 21668) | 237.35 (base 239.53) | 5.99 (base 5.99) |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 396931.114 (595860.629) | 33.385 | 1.777 | 344932 | 343552 (2097152.0) | 210 | 0.0 / 0 |
| flythrough | 487787.755 (769635.928) | 36.621 | 1.085 | 2102324 | 2092624 (2097152.0) | 139 | 9.6 / 56 |
| water_glass | 112884.867 (196985.687) | 42.694 | 1.133 | 9220 | 0 (2097152.0) | 128 | 0.0 / 0 |
| nether | 29501.284 (42400.331) | 30.422 | 2.0 | 395256 | 390272 (2097152.0) | 128 | 0.0 / 0 |
| mobs | 62146.45 (110944.317) | 43.984 | 0.967 | 610676 | 0 (2097152.0) | 26 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29216.603 (51441.583) | 43.204 | 1.279 | 277796 | 179648 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 22119.035 (38921.674) | 43.17 | 1.26 | 770044 | 694976 (2097152.0) | 2 | 0.0 / 0 |
| occlusion_corner | 21826.701 (47191.282) | 53.748 | 1.214 | 32932 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 21582.707 (27586.191) | 21.763 | 1.004 | 753204 | 748288 (2097152.0) | 128 | 0.0 / 0 |
| water_glass_oit | 113151.735 (197451.374) | 42.694 | 1.133 | 9780 | 0 (2097152.0) | 211 | 0.0 / 0 |
| translucent_move_oit | 21682.645 (27738.498) | 21.832 | 1.005 | 753908 | 748288 (2097152.0) | 217 | 0.0 / 0 |
| flat_plants | 9101.605 (12478.136) | 27.06 | 1.045 | 2276 | 0 (2097152.0) | 129 | 0.0 / 0 |
| renderer_off | 19374.728 (36601.827) | 47.066 | 1.0 | 1380 | 0 (2097152.0) | 42 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86232 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 3.372 (107) | 3.572 (54) | 0 | 871 / 0 | 8.348 / 11.434 | 3.796 / 5.889 |
| flythrough | 5.867 (1604) | 5.867 (1604) | 0 | 1390 / 0 | 7.103 / 9.871 | 4.702 / 7.03 |
| water_glass | 1.838 (14) | None (0) | 0 | 1179 / 0 | 7.997 / 10.522 | 3.755 / 5.517 |
| nether | 3.043 (32) | 3.3 (18) | 0 | 1802 / 0 | 6.637 / 8.931 | 3.188 / 4.918 |
| mobs | 1.007 (6) | None (0) | 0 | 2031 / 0 | 6.518 / 8.782 | 3.13 / 4.824 |
| outline | 0.42 (12) | None (0) | 0 | 2089 / 0 | 6.422 / 8.67 | 3.078 / 4.745 |
| occlusion | 1.204 (46) | 1.967 (4) | 0 | 2216 / 0 | 6.347 / 8.539 | 3.042 / 4.602 |
| occlusion_move | 1.998 (55) | 4.614 (16) | 0 | 2390 / 0 | 6.077 / 8.169 | 2.895 / 4.411 |
| occlusion_corner | 1.38 (110) | 1.528 (1) | 0 | 2672 / 0 | 5.662 / 7.567 | 2.648 / 3.874 |
| translucent_move | 3.135 (123) | 4.809 (41) | 0 | 3032 / 0 | 5.574 / 7.489 | 2.739 / 3.983 |
| water_glass_oit | 4.095 (151) | None (0) | 0 | 410 / 0 | 9.757 / 12.732 | 4.592 / 6.028 |
| translucent_move_oit | 3.634 (218) | 4.281 (25) | 0 | 953 / 0 | 6.549 / 8.407 | 3.323 / 4.388 |
| flat_plants | 1.902 (82) | None (0) | 0 | 406 / 0 | 6.251 / 7.664 | 2.591 / 3.338 |
| renderer_off | 0.449 (17) | None (0) | 0 | 325 / 0 | 8.548 / 12.546 | 3.627 / 6.147 |
| particles | 0.699 (30) | None (0) | 0 | 3061 / 0 | 5.528 / 7.426 | 2.701 / 3.912 |
| animation | 0.852 (18) | 1.057 (4) | 0 | 3136 / 0 | 5.42 / 7.275 | 2.599 / 3.801 |
| animated_items | 0.496 (38) | 0.951 (2) | 0 | 3168 / 0 | 5.371 / 7.208 | 2.554 / 3.733 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.186 | 666.157 | 16 (vanilla 28) | 1387656 | 41.627 / 0.152 | 22.963 / 36.0 | 37.054 | 2370 / 0 | 3.572 (6.611) |
| flythrough | plain, one multi-draw per region and layer | 58.791 | 759.043 | 16 (vanilla 28) | 5160364 | 15.141 / 1.016 | 85.182 / 112.0 | 137.797 | 6427 / 0 | 5.867 (17.323) |
| water_glass | plain, one multi-draw per region and layer | 14.033 | 105.249 | 16 (vanilla 28) | 770792 | 33.544 / 0.125 | 12.419 / 36.0 | 20.582 | 3007 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.084 | 16 (vanilla 28) | 956500 | 28.031 / 0.21 | 15.211 / 20.0 | 25.541 | 4054 / 0 | 3.3 (7.257) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 60.111 | 16 (vanilla 28) | 599676 | 25.481 / 0.188 | 9.599 / 16.0 | 16.013 | 4490 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 91864 | 25.012 / 0.186 | 1.457 / 16.0 | 2.453 | 4585 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 161800 | 23.886 / 0.178 | 2.589 / 20.0 | 4.321 | 4821 / 0 | 1.967 (2.168) |
| occlusion_move | plain, one multi-draw per region and layer | 6.032 | 33.729 | 16 (vanilla 28) | 222820 | 22.359 / 0.166 | 3.557 / 20.0 | 5.95 | 5145 / 0 | 4.614 (13.957) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.067 | 60.865 | 16 (vanilla 28) | 122728 | 21.094 / 0.157 | 1.931 / 20.0 | 3.277 | 5536 / 0 | 1.528 (1.526) |
| translucent_move | plain, one multi-draw per region and layer | 4.381 | 23.088 | 16 (vanilla 28) | 795752 | 18.219 / 0.14 | 12.88 / 28.0 | 21.249 | 6399 / 0 | 4.809 (13.014) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.076 | 113.536 | 16 (vanilla 28) | 770792 | 7.486 / 0.041 | 12.419 / 20.0 | 20.582 | 1083 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.442 | 37.244 | 16 (vanilla 28) | 769960 | 6.607 / 0.091 | 12.477 / 28.0 | 20.56 | 2397 / 0 | 4.281 (11.006) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 853136 | 6.012 / 0.01 | 13.694 / 24.0 | 22.781 | 930 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.037 | 16 (vanilla 28) | 541400 | 2.406 / 0.021 | 8.622 / 24.0 | 14.457 | 603 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.162 / 0.14 | 0.131 / 28.0 | 0.225 | 6445 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.019 / 0.139 | 0.302 / 28.0 | 0.518 | 6547 / 0 | 1.057 (1.528) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 17.973 / 0.139 | 0.153 / 28.0 | 0.261 | 6594 / 0 | 0.951 (1.372) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 158.0 | 17.0 | 0.0 | 0 | 0 | 47 (0.026 / 0.038 / 0.052; 0) | 0 | 33338 / 0 / 0 |
| flythrough | 189.364 | 25.957 | 0.0 | 0 | 0 | 852 (0.029 / 0.049 / 5.091; 0) | 42 | 26511 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1692 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 37 (0.007 / 0.013 / 0.014; 0) | 33 | 1192 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.1 / 0.154 / 0.207; 0) | 180 | 3591 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 636 | 0 (None / None / None; 0) | 0 | 848 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 654 | 0 (None / None / None; 0) | 0 | 1526 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2068 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2368 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.029 (0.075; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 436.129 | 1.0 (0.0, 0.0) | 1.186 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.061; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.136 (0.268; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.065 (0.108; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.342 | 10.0 (9.0, 2.357) | 6.0 (6.0, 2.279) | 0.058 (0.275; 0) | 0 | 2763 / 1495562 / 0 / 0 |
| occlusion_corner | 81.857 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.269 | 1.0 (0.0, 0.0) | 0.782 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 139.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.431 | 1.0 (0.0, 0.0) | 0.748 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 111.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 269.0 / 349.0 (22.9) | 269.0 / 80.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4160 / 0 |
| flythrough | two-phase | 313.01 / 402.47 (22.2) | 306.15 / 96.32 / 6.86 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3062 / 0 |
| water_glass | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 9030 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 33664 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10125 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3278 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.33 / 51.3 (56.5) | 22.28 / 29.02 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4277 / 0 |
| occlusion_corner | two-phase | 60.74 / 81.85 (25.8) | 60.66 / 21.19 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3167 / 0 |
| translucent_move | two-phase | 15.66 / 135.12 (88.4) | 15.64 / 119.47 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15303 / 0 |
| water_glass_oit | two-phase | 53.0 / 139.0 (61.9) | 53.0 / 86.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4558 / 0 |
| translucent_move_oit | two-phase | 15.66 / 134.83 (88.4) | 15.61 / 119.21 / 0.04 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6553 / 0 |
| flat_plants | two-phase | 9.0 / 151.0 (94.0) | 9.0 / 142.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 18318 / 0 |
| renderer_off | two-phase | 11.0 / 111.0 (90.1) | 11.0 / 100.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14800 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 117.519 / 0.0 | 0.026 / 0.004 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.048 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.836 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.244 / 54.128 | 0.025 / 0.028 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.49 | - / 0.813 | - / 0.0 | - / 0.0 | - / 0.0 | 44.683 / 9.305 | 0.074 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.239 / 12.234 | 0.004 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 56.985 / 57.094 | 0.013 / 0.021 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.449 / 12.394 | 0.006 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.5 | - / 0.99 | - / 3.0 | - / 0.0 | - / 0.0 | 2.883 / 2.731 | 0.012 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.003 / 0.038 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.798 | 0.003 / 0.007 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| core-quicksilver-2p-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-2p-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-2p-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-2p-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |
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
| core-quicksilver-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |

Rises of 4 MB or more: none

