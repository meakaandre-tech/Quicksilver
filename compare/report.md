# Quicksilver CI comparison

**passed**

## Suite core

- vanilla-a: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- vanilla-b: backend `OpenGL` drivers `4.5 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
- quicksilver-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- old-gpu: 0 / 0

**Quick mode** (core suite; vanilla a, vanilla b, Quicksilver old-GPU against vanilla a): the measure-run gates (same-run draw calls, terrain GPU memory, measure pictures) and the full and Vulkan profiles are not run. A merge needs a full run.

| scene | noise (vanilla a/b) % | limit % | old-GPU % |
|---|---|---|---|
| spawn | 0.3021 | 10.05 | 0.0548 |
| flythrough | 0.0003 | 14.95 | 0.0012 |
| water_glass | 0.0036 | 6.45 | 0.0039 |
| nether | 0.0112 | 0.8 | 0.0115 |
| mobs | 0.0 | 0.4 | 0.0 |
| outline | 0.0 | 0.25 | 0.0 |
| outline.bare | 0.0 | 0.25 | 0.0 |
| occlusion | 0.0 | 0.25 | 0.0001 |
| occlusion_move | 0.0 | 0.25 | 0.0 |
| occlusion_move.x2297 | 0.0 | 0.25 | 0.0 |
| occlusion_move.x2305 | 0.0 | 0.25 | 0.0 |
| occlusion_move.x2309 | 0.0 | 0.3 | 0.0 |
| occlusion_move.open | 0.0 | 0.25 | 0.0 |
| occlusion_move.closed | 0.0 | 0.25 | 0.0 |
| occlusion_move.bare_x2300 | 0.0 | 0.3 | 0.0 |
| occlusion_move.bare_x2297 | 0.0 | 0.3 | 0.0 |
| occlusion_move.bare_x2305 | 0.0 | 0.25 | 0.0 |
| occlusion_move.bare_x2309 | 0.0 | 0.25 | 0.0 |
| occlusion_move.bare_open | 0.0 | 0.3 | 0.0 |
| translucent_move | 0.0 | 0.3 | 0.0 |
| translucent_move.x2404 | 0.0003 | 0.3 | 0.0004 |
| translucent_move.x2414 | 0.0002 | 0.3 | 0.0004 |
| translucent_move.x2424 | 0.0003 | 0.3 | 0.0002 |
| translucent_move.low | 0.0009 | 0.3 | 0.0012 |
| translucent_move.back | 0.0002 | 0.3 | 0.0001 |
| translucent_move.bare_back | 0.0002 | 0.3 | 0.0003 |
| water_glass_oit | 0.0044 | 0.3 | 0.0041 |
| translucent_move_oit | 0.0 | 0.3 | 0.0001 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0002 |
| translucent_move_oit.x2414 | 0.0 | 0.3 | 0.0003 |
| translucent_move_oit.x2424 | 0.0004 | 0.3 | 0.0004 |
| translucent_move_oit.low | 0.0009 | 0.3 | 0.0012 |
| translucent_move_oit.back | 0.0 | 0.3 | 0.0 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0001 |
| flat_plants | 0.0 | 0.3 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 |

Strict picture: pixels where both vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU |
|---|---|---|---|
| spawn | 99.61 | 18057 | 375 (1016) |
| flythrough | 100.0 | 6020 | 54 (316) |
| water_glass | 100.0 | 25508 | 26 (3511) |
| nether | 99.99 | 905 | 3 (464) |
| mobs | 100.0 | 10 | 0 (0) |
| outline | 100.0 | 10 | 0 (0) |
| outline.bare | 100.0 | 10 | 0 (0) |
| occlusion | 100.0 | 22 | 1 (76) |
| occlusion_move | 100.0 | 10 | 0 (0) |
| occlusion_move.x2297 | 100.0 | 10 | 0 (0) |
| occlusion_move.x2305 | 100.0 | 10 | 0 (0) |
| occlusion_move.x2309 | 100.0 | 32 | 0 (0) |
| occlusion_move.open | 100.0 | 10 | 0 (0) |
| occlusion_move.closed | 100.0 | 10 | 0 (0) |
| occlusion_move.bare_x2300 | 100.0 | 90 | 0 (0) |
| occlusion_move.bare_x2297 | 100.0 | 70 | 0 (0) |
| occlusion_move.bare_x2305 | 100.0 | 10 | 0 (0) |
| occlusion_move.bare_x2309 | 100.0 | 10 | 0 (0) |
| occlusion_move.bare_open | 100.0 | 110 | 0 (0) |
| translucent_move | 100.0 | 13 | 1 (123) |
| translucent_move.x2404 | 100.0 | 15 | 4 (173) |
| translucent_move.x2414 | 100.0 | 13 | 6 (167) |
| translucent_move.x2424 | 100.0 | 13 | 3 (122) |
| translucent_move.low | 100.0 | 41 | 12 (18) |
| translucent_move.back | 100.0 | 13 | 2 (124) |
| translucent_move.bare_back | 100.0 | 13 | 3 (125) |
| water_glass_oit | 99.99 | 57 | 18 (3503) |
| translucent_move_oit | 100.0 | 12 | 4 (126) |
| translucent_move_oit.x2404 | 100.0 | 16 | 3 (173) |
| translucent_move_oit.x2414 | 100.0 | 10 | 5 (165) |
| translucent_move_oit.x2424 | 100.0 | 15 | 2 (121) |
| translucent_move_oit.low | 100.0 | 40 | 12 (18) |
| translucent_move_oit.back | 100.0 | 12 | 1 (123) |
| translucent_move_oit.bare_back | 100.0 | 15 | 3 (125) |
| flat_plants | 100.0 | 350 | 248 (8128) |
| renderer_off | 100.0 | 10 | 0 (0) |
| particles | 100.0 | 4 | 0 (0) |
| particles.bare | 100.0 | 4 | 0 (0) |
| animation | 100.0 | 10 | 1 (3) |
| animation.behind | 100.0 | 10 | 0 (2) |
| animation.front | 100.0 | 10 | 1 (3) |
| animated_items | 100.0 | 10 | 0 (0) |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 50.59 (base 49.0) | 13 (base 13) | 7572 (base 6372) | 253.08 (base 256.29) | 3.48 (base 3.73) |
| flythrough | 66.39 (reported, not gated) | 45 (reported, not gated) | 554948 (reported, not gated) | 307.96 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.0 (base 20.0) | 13 (base 14) | 7764 (base 10264) | 237.95 (base 249.83) | 3.48 (base 5.99) |
| nether | 33.72 (base 33.79) | 10 (base 11) | 3744 (base 10656) | 259.12 (base 272.57) | 3.48 (base 5.99) |
| mobs | 28.88 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 257.94 (base 268.23) | 3.48 (base 5.99) |
| outline | 19.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.65 (base 264.41) | 3.48 (base 3.73) |
| occlusion | 22.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.34 (base 264.64) | 3.48 (base 4.24) |
| occlusion_move | 24.04 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.57 (base 265.66) | 3.48 (base 5.99) |
| translucent_move | 18.0 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 266.02 (base 268.19) | 5.48 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7652 (base 7604) | 236.22 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.52 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 239.14 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 32.71 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 239.59 (base 248.11) | 3.35 (base 5.99) |
| renderer_off | 17.68 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.92 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 261.11 (base 261.4) | 5.48 (base 4.24) |
| animation | 49 median (avg 39.95) (base 49) | 13 (base 13) | 1716 (base 1716) | 258.52 (base 260.68) | 5.48 (base 4.24) |
| animated_items | 60 median (avg 46.77) (base 60) | 22 (base 22) | 21668 (base 21668) | 233.44 (base 239.53) | 5.48 (base 5.99) |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 459677.611 (705972.526) | 34.887 | 1.775 | 360724 | 353152 (2097152.0) | 190 | 0.0 / 0 |
| flythrough | 555603.714 (890173.743) | 37.585 | 1.083 | 2104196 | 2095256 (2097152.0) | 140 | 7.213 / 41 |
| water_glass | 215553.1 (385674.35) | 44.11 | 1.117 | 10004 | 0 (2097152.0) | 360 | 0.0 / 0 |
| nether | 271889.831 (482245.45) | 43.62 | 1.701 | 152344 | 146368 (2097152.0) | 367 | 0.0 / 0 |
| mobs | 166719.613 (301214.558) | 44.651 | 0.99 | 610676 | 0 (2097152.0) | 7 | 0.0 / 0 |
| outline | 25899.165 (43790.985) | 40.857 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 45556.054 (79933.445) | 43.008 | 1.214 | 98148 | 0 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_move | 50037.548 (87861.464) | 43.049 | 1.239 | 664956 | 589888 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 199427.507 (353741.223) | 43.623 | 1.171 | 752388 | 748032 (2097152.0) | 330 | 0.0 / 0 |
| water_glass_oit | 216093.333 (386640.952) | 44.11 | 1.117 | 9444 | 0 (2097152.0) | 189 | 0.0 / 0 |
| translucent_move_oit | 199612.431 (353774.066) | 43.576 | 1.169 | 753396 | 748032 (2097152.0) | 181 | 0.0 / 0 |
| flat_plants | 232077.03 (424939.233) | 45.386 | 1.056 | 2052 | 0 (2097152.0) | 73 | 0.0 / 0 |
| renderer_off | 149277.874 (270778.508) | 44.871 | 1.029 | 1380 | 0 (2097152.0) | 2 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86232 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 3.673 (117) | 3.763 (63) | 0 | 904 / 0 | 8.676 / 12.317 | 3.907 / 5.553 |
| flythrough | 6.089 (1603) | 6.09 (1602) | 0 | 1391 / 0 | 7.041 / 10.061 | 4.717 / 6.978 |
| water_glass | 1.699 (14) | None (0) | 0 | 1231 / 0 | 7.92 / 11.054 | 3.767 / 5.408 |
| nether | 3.093 (30) | 2.844 (8) | 0 | 1845 / 0 | 6.662 / 9.172 | 3.267 / 4.709 |
| mobs | 0.85 (6) | None (0) | 0 | 2077 / 0 | 6.496 / 8.925 | 3.16 / 4.579 |
| outline | 0.473 (13) | None (0) | 0 | 2135 / 0 | 6.405 / 8.796 | 3.107 / 4.498 |
| occlusion | 0.914 (45) | None (0) | 0 | 2259 / 0 | 6.307 / 8.671 | 3.03 / 4.397 |
| occlusion_move | 1.989 (59) | 4.32 (16) | 0 | 2399 / 0 | 6.069 / 8.339 | 2.91 / 4.167 |
| translucent_move | 3.26 (108) | 4.142 (31) | 0 | 2711 / 0 | 5.911 / 8.058 | 2.91 / 4.171 |
| water_glass_oit | 5.18 (154) | None (0) | 0 | 413 / 0 | 10.623 / 13.238 | 5.51 / 6.874 |
| translucent_move_oit | 3.654 (216) | 5.47 (25) | 0 | 951 / 0 | 7.078 / 9.189 | 3.901 / 5.034 |
| flat_plants | 1.765 (98) | None (0) | 0 | 407 / 0 | 8.205 / 10.491 | 3.346 / 3.881 |
| renderer_off | 0.584 (21) | None (0) | 0 | 322 / 0 | 8.157 / 11.547 | 3.314 / 6.211 |
| particles | 0.429 (30) | None (0) | 0 | 2738 / 0 | 5.858 / 7.986 | 2.856 / 4.137 |
| animation | 1.123 (18) | 1.494 (4) | 0 | 2813 / 0 | 5.732 / 7.812 | 2.78 / 4.004 |
| animated_items | 0.393 (42) | 1.191 (2) | 0 | 2845 / 0 | 5.677 / 7.732 | 2.741 / 3.93 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.205 | 805.216 | 16 (vanilla 28) | 1404848 | 41.721 / 0.088 | 23.275 / 36.0 | 37.513 | 2497 / 0 | 3.763 (7.153) |
| flythrough | plain, one multi-draw per region and layer | 56.679 | 901.9 | 16 (vanilla 28) | 5097732 | 15.16 / 0.999 | 84.201 / 112.0 | 136.124 | 6416 / 0 | 6.09 (17.668) |
| water_glass | plain, one multi-draw per region and layer | 14.039 | 273.758 | 16 (vanilla 28) | 769212 | 34.299 / 0.08 | 12.387 / 36.0 | 20.54 | 3188 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 20.054 | 472.283 | 16 (vanilla 28) | 961908 | 28.982 / 0.179 | 15.315 / 20.0 | 25.686 | 4213 / 0 | 2.844 (3.904) |
| mobs | plain, one multi-draw per region and layer | 11.024 | 198.435 | 16 (vanilla 28) | 601108 | 26.416 / 0.157 | 9.617 / 16.0 | 16.051 | 4653 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 11.018 | 42.07 | 16 (vanilla 28) | 87436 | 25.964 / 0.157 | 1.384 / 16.0 | 2.335 | 4747 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 10.017 | 70.117 | 16 (vanilla 28) | 159600 | 24.919 / 0.15 | 2.559 / 20.0 | 4.262 | 4966 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 10.993 | 75.439 | 16 (vanilla 28) | 209292 | 23.779 / 0.143 | 3.352 / 20.0 | 5.589 | 5223 / 0 | 4.32 (11.687) |
| translucent_move | plain, one multi-draw per region and layer | 12.032 | 247.458 | 16 (vanilla 28) | 791088 | 20.873 / 0.131 | 12.804 / 28.0 | 21.124 | 5953 / 0 | 4.142 (8.866) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.085 | 282.487 | 16 (vanilla 28) | 769212 | 7.605 / 0.044 | 12.387 / 20.0 | 20.54 | 1086 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.613 | 262.497 | 16 (vanilla 28) | 765344 | 6.581 / 0.099 | 12.399 / 28.0 | 20.437 | 2391 / 0 | 5.47 (13.261) |
| flat_plants | plain, one multi-draw per region and layer | 17.042 | 284.703 | 16 (vanilla 28) | 847780 | 6.649 / 0.01 | 13.556 / 24.0 | 22.638 | 951 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 13.022 | 205.349 | 16 (vanilla 28) | 540636 | 2.489 / 0.021 | 8.584 / 24.0 | 14.437 | 596 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 12.02 | 16 (vanilla 28) | 8416 | 20.823 / 0.131 | 0.131 / 28.0 | 0.225 | 5995 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 20.648 / 0.13 | 0.302 / 28.0 | 0.518 | 6097 / 0 | 1.494 (1.949) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 20.586 / 0.13 | 0.153 / 28.0 | 0.261 | 6147 / 0 | 1.191 (1.836) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 53 (0.027 / 0.042 / 0.044; 0) | 0 | 29796 / 0 / 0 |
| flythrough | 188.397 | 25.695 | 0.0 | 0 | 0 | 852 (0.025 / 0.051 / 3.879; 0) | 47 | 26564 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1444 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1198 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.017 / 0.064 / 0.066; 0) | 32 | 1196 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.11 / 0.17 / 0.188; 0) | 180 | 2618 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 570 | 0 (None / None / None; 0) | 0 | 760 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 546 | 0 (None / None / None; 0) | 0 | 1274 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1620 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2352 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 350.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.047 (0.138; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.369 | 1.0 (0.0, 0.0) | 1.326 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 108.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.144 (0.234; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.081 (0.193; 0) | 0 | 3594 / 1626884 / 0 / 0 |
| occlusion_move | 51.351 | 10.0 (9.0, 2.353) | 6.0 (6.0, 2.279) | 0.063 (0.25; 0) | 0 | 2770 / 1498334 / 0 / 0 |
| translucent_move | 135.07 | 1.0 (0.0, 0.0) | 0.767 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.002 (0.063; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.747 | 1.0 (0.0, 0.0) | 0.736 (0.0, 0.0) | 0.002 (0.005; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 153.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.034; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.595 | - / 3.0 | - / 0.0 | - / 0.0 | 135.464 / 0.592 | 0.035 / 0.016 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.155 / 0.0 | 0.004 / 0.003 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.837 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 56.993 / 57.075 | 0.019 / 0.029 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 10.0 | - / 0.717 | - / 0.0 | - / 0.0 | - / 0.0 | 45.88 / 6.766 | 0.099 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.48 / 11.473 | 0.005 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 56.335 / 56.321 | 0.015 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.356 / 13.401 | 0.005 / 0.012 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 9.752 | - / 0.985 | - / 3.0 | - / 0.0 | - / 0.0 | 3.283 / 2.983 | 0.02 / 0.013 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.006 / 0.057 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.287 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.798 | 0.004 / 0.012 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.988 |
| animated_items | - / 28.104 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| core-quicksilver-old | spawn | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | water_glass | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | nether | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | mobs | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | outline | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | occlusion | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | occlusion_move | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | translucent_move | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | particles | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animation | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | animated_items | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | flat_plants | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |

Rises of 4 MB or more: none

