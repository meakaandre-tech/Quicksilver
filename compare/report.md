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
| spawn | 0.2069 | 10.05 | 0.3053 |
| flythrough | 0.0 | 14.95 | 0.0012 |
| water_glass | 0.004 | 6.45 | 0.0048 |
| nether | 0.0 | 0.8 | 0.0003 |
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
| translucent_move | 0.0001 | 0.3 | 0.0 |
| translucent_move.x2404 | 0.0002 | 0.3 | 0.0003 |
| translucent_move.x2414 | 0.0003 | 0.3 | 0.0002 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0001 |
| translucent_move.low | 0.0003 | 0.3 | 0.0015 |
| translucent_move.back | 0.0002 | 0.3 | 0.0 |
| translucent_move.bare_back | 0.0001 | 0.3 | 0.0 |
| water_glass_oit | 0.0044 | 0.3 | 0.0041 |
| translucent_move_oit | 0.0001 | 0.3 | 0.0001 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0002 |
| translucent_move_oit.x2414 | 0.0001 | 0.3 | 0.0002 |
| translucent_move_oit.x2424 | 0.0002 | 0.3 | 0.0001 |
| translucent_move_oit.low | 0.0004 | 0.3 | 0.0012 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0 |
| translucent_move_oit.bare_back | 0.0001 | 0.3 | 0.0001 |
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
| spawn | 99.7 | 18057 | 2654 (3326) |
| flythrough | 100.0 | 6020 | 58 (330) |
| water_glass | 100.0 | 25508 | 33 (3516) |
| nether | 100.0 | 905 | 3 (464) |
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
| translucent_move | 100.0 | 13 | 2 (124) |
| translucent_move.x2404 | 100.0 | 15 | 4 (174) |
| translucent_move.x2414 | 100.0 | 13 | 4 (164) |
| translucent_move.x2424 | 100.0 | 13 | 3 (122) |
| translucent_move.low | 100.0 | 41 | 15 (21) |
| translucent_move.back | 100.0 | 13 | 3 (125) |
| translucent_move.bare_back | 100.0 | 13 | 1 (123) |
| water_glass_oit | 100.0 | 57 | 24 (3510) |
| translucent_move_oit | 100.0 | 12 | 1 (123) |
| translucent_move_oit.x2404 | 100.0 | 16 | 4 (174) |
| translucent_move_oit.x2414 | 100.0 | 10 | 4 (164) |
| translucent_move_oit.x2424 | 100.0 | 15 | 1 (120) |
| translucent_move_oit.low | 100.0 | 40 | 14 (20) |
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
| spawn | 48.86 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 248.08 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 67.07 (reported, not gated) | 35 (reported, not gated) | 249380 (reported, not gated) | 305.57 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.9 (base 20.0) | 13 (base 14) | 7204 (base 10264) | 233.78 (base 249.83) | 3.99 (base 5.99) |
| nether | 32.6 (base 33.79) | 10 (base 11) | 4288 (base 10656) | 254.86 (base 272.57) | 3.99 (base 5.99) |
| mobs | 28.74 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 254.65 (base 268.23) | 3.99 (base 5.99) |
| outline | 19.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 253.29 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 22.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 259.25 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 24.04 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 259.47 (base 265.66) | 3.99 (base 5.99) |
| translucent_move | 17.87 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 261.49 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 6980 (base 7604) | 233.4 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 235.67 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 31.36 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 235.53 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 17.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 228.54 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 256.62 (base 261.4) | 5.99 (base 4.24) |
| animation | 49 median (avg 39.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 253.93 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 60 median (avg 46.77) (base 60) | 21 (base 22) | 21508 (base 21668) | 228.87 (base 239.53) | 5.99 (base 5.99) |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 442752.827 (678861.536) | 34.78 | 1.779 | 651028 | 649536 (2097152.0) | 237 | 0.0 / 0 |
| flythrough | 560455.744 (899242.3) | 37.675 | 1.085 | 2104140 | 2096520 (2097152.0) | 180 | 6.801 / 80 |
| water_glass | 218582.779 (391770.387) | 44.206 | 1.117 | 8996 | 0 (2097152.0) | 31 | 0.0 / 0 |
| nether | 270085.49 (479479.097) | 43.671 | 1.704 | 235012 | 229696 (2097152.0) | 37 | 0.0 / 0 |
| mobs | 169755.781 (306789.078) | 44.667 | 0.99 | 610676 | 0 (2097152.0) | 9 | 0.0 / 0 |
| outline | 23605.342 (39195.326) | 39.775 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 46329.215 (81445.743) | 43.116 | 1.2 | 98148 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 51207.356 (90150.968) | 43.198 | 1.226 | 697120 | 622144 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 206760.349 (367757.913) | 43.778 | 1.183 | 758740 | 756352 (2097152.0) | 8 | 0.0 / 0 |
| water_glass_oit | 219026.026 (392564.828) | 44.206 | 1.117 | 9556 | 0 (2097152.0) | 232 | 0.0 / 0 |
| translucent_move_oit | 207023.406 (367986.804) | 43.742 | 1.181 | 754868 | 749952 (2097152.0) | 219 | 0.0 / 0 |
| flat_plants | 239880.71 (439772.949) | 45.454 | 1.06 | 1828 | 0 (2097152.0) | 17 | 0.0 / 0 |
| renderer_off | 148843.66 (270011.27) | 44.875 | 1.02 | 1380 | 0 (2097152.0) | 0 | 0.0 / 0 |
| particles | 1927.212 (4215.025) | 54.278 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3217.743 (5631.766) | 42.864 | 1.071 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2271.786 (4890.15) | 53.544 | 1.0 | 79236 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 38.16 | 760.194 | 16 (vanilla 28) | 1369772 | 40.653 / 0.1 | 22.736 / 36.0 | 36.577 | 2431 / 0 | 3.63 (6.776) |
| flythrough | plain, one multi-draw per region and layer | 57.283 | 916.256 | 16 (vanilla 28) | 5274788 | 15.154 / 1.005 | 87.16 / 112.0 | 140.852 | 6603 / 0 | 6.591 (17.331) |
| water_glass | plain, one multi-draw per region and layer | 14.032 | 274.624 | 16 (vanilla 28) | 799252 | 33.164 / 0.088 | 12.92 / 36.0 | 21.342 | 3086 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 20.045 | 470.059 | 16 (vanilla 28) | 956880 | 27.925 / 0.18 | 15.227 / 20.0 | 25.551 | 4155 / 0 | 2.888 (3.868) |
| mobs | plain, one multi-draw per region and layer | 11.02 | 204.378 | 16 (vanilla 28) | 612444 | 25.435 / 0.158 | 9.825 / 16.0 | 16.354 | 4601 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 11.018 | 42.07 | 16 (vanilla 28) | 78260 | 25.038 / 0.158 | 1.247 / 16.0 | 2.09 | 4695 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 10.017 | 70.117 | 16 (vanilla 28) | 162620 | 23.847 / 0.15 | 2.599 / 20.0 | 4.342 | 4937 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 11.0 | 75.467 | 16 (vanilla 28) | 216588 | 22.464 / 0.141 | 3.452 / 20.0 | 5.784 | 5246 / 0 | 5.594 (10.986) |
| translucent_move | plain, one multi-draw per region and layer | 12.026 | 248.397 | 16 (vanilla 28) | 823348 | 19.293 / 0.126 | 13.307 / 28.0 | 21.986 | 6099 / 0 | 5.907 (13.699) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.069 | 283.216 | 16 (vanilla 28) | 781760 | 7.507 / 0.043 | 12.622 / 20.0 | 20.875 | 1093 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.603 | 263.397 | 16 (vanilla 28) | 797504 | 6.648 / 0.109 | 12.896 / 28.0 | 21.296 | 2430 / 0 | 6.561 (17.331) |
| flat_plants | plain, one multi-draw per region and layer | 17.038 | 282.625 | 16 (vanilla 28) | 877600 | 6.238 / 0.01 | 14.051 / 24.0 | 23.434 | 949 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 13.022 | 205.342 | 16 (vanilla 28) | 539124 | 2.412 / 0.021 | 8.569 / 24.0 | 14.396 | 596 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 12.02 | 16 (vanilla 28) | 8416 | 19.234 / 0.126 | 0.131 / 28.0 | 0.225 | 6145 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 14.023 | 16 (vanilla 28) | 19416 | 19.079 / 0.125 | 0.302 / 28.0 | 0.518 | 6247 / 0 | 1.054 (1.47) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 13.022 | 16 (vanilla 28) | 9764 | 19.025 / 0.125 | 0.153 / 28.0 | 0.261 | 6297 / 0 | 0.992 (1.391) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 16.0 | 0.0 | 0 | 0 | 53 (0.024 / 0.051 / 0.068; 0) | 0 | 36652 / 0 / 0 |
| flythrough | 192.32 | 26.138 | 0.0 | 0 | 0 | 898 (0.02 / 0.039 / 3.075; 0) | 60 | 34810 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1760 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.011 / 0.012; 0) | 32 | 1200 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.09 / 0.153 / 0.165; 0) | 180 | 3220 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 699 | 0 (None / None / None; 0) | 0 | 932 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 660 | 0 (None / None / None; 0) | 0 | 1540 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1808 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 328.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.031 (0.102; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.486 | 1.0 (0.0, 0.0) | 1.409 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.017 (0.115; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 111.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.133 (0.237; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.069 (0.123; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.377) | 6.0 (6.0, 2.282) | 0.061 (1.127; 0) | 0 | 2795 / 1514896 / 0 / 0 |
| translucent_move | 136.102 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.623 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.017; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.009 (0.049; 0) | 0 | 0 / 0 / 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.865 | - / 3.0 | - / 0.0 | - / 0.0 | 104.633 / 0.866 | 0.033 / 0.017 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.768 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.845 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 52.335 / 52.314 | 0.013 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 8.871 | - / 0.842 | - / 0.0 | - / 0.0 | - / 0.0 | 42.298 / 6.649 | 0.078 / 0.013 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.529 / 11.463 | 0.006 / 0.013 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 51.973 / 51.863 | 0.018 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.318 / 13.305 | 0.008 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 8.825 | - / 0.652 | - / 3.0 | - / 0.0 | - / 0.0 | 1.382 / 1.352 | 0.013 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.008 / 0.058 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.004 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.987 |
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
| core-quicksilver-old | spawn | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | water_glass | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | nether | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | mobs | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | outline | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | occlusion | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | occlusion_move | 3.99 | 3.99 (0) | 3.99 |  |
| core-quicksilver-old | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |

Rises of 4 MB or more: none

