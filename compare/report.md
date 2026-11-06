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
| spawn | 0.1929 | 10.05 | 0.0511 | 0.2987 |
| flythrough | 0.0 | 14.95 | 0.0012 | 0.0012 |
| water_glass | 0.0039 | 6.45 | 0.0048 | 0.0044 |
| nether | 0.0 | 0.8 | 0.0003 | 0.0003 |
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
| translucent_move | 0.0003 | 0.3 | 0.0002 | 0.0003 |
| translucent_move.x2404 | 0.0 | 0.3 | 0.0004 | 0.0003 |
| translucent_move.x2414 | 0.0 | 0.3 | 0.0001 | 0.0002 |
| translucent_move.x2424 | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| translucent_move.low | 0.0002 | 0.3 | 0.001 | 0.001 |
| translucent_move.back | 0.0 | 0.3 | 0.0 | 0.0002 |
| translucent_move.bare_back | 0.0 | 0.3 | 0.0 | 0.0001 |
| water_glass_oit | 0.0039 | 0.3 | 0.0038 | 0.0034 |
| translucent_move_oit | 0.0003 | 0.3 | 0.0003 | 0.0002 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0004 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0002 | 0.0001 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0003 | 0.0002 |
| translucent_move_oit.low | 0.0007 | 0.3 | 0.0016 | 0.0017 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0 | 0.0 |
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
| spawn | 99.72 | 18057 | 346 (979) | 2645 (3290) |
| flythrough | 100.0 | 6020 | 53 (302) | 53 (302) |
| water_glass | 100.0 | 25508 | 30 (3516) | 25 (3510) |
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
| translucent_move | 100.0 | 13 | 1 (124) | 2 (124) |
| translucent_move.x2404 | 100.0 | 15 | 6 (176) | 4 (173) |
| translucent_move.x2414 | 100.0 | 13 | 2 (162) | 4 (164) |
| translucent_move.x2424 | 100.0 | 13 | 1 (120) | 1 (121) |
| translucent_move.low | 100.0 | 41 | 17 (23) | 16 (22) |
| translucent_move.back | 100.0 | 13 | 2 (124) | 3 (125) |
| translucent_move.bare_back | 100.0 | 13 | 2 (124) | 3 (126) |
| water_glass_oit | 100.0 | 57 | 21 (3505) | 20 (3505) |
| translucent_move_oit | 100.0 | 12 | 3 (125) | 1 (123) |
| translucent_move_oit.x2404 | 100.0 | 16 | 4 (173) | 5 (174) |
| translucent_move_oit.x2414 | 100.0 | 10 | 3 (163) | 4 (164) |
| translucent_move_oit.x2424 | 100.0 | 15 | 3 (122) | 2 (121) |
| translucent_move_oit.low | 100.0 | 40 | 16 (22) | 18 (25) |
| translucent_move_oit.back | 100.0 | 12 | 1 (123) | 3 (125) |
| translucent_move_oit.bare_back | 100.0 | 15 | 1 (123) | 2 (124) |
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
| spawn | 50.35 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 252.77 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 67.71 (reported, not gated) | 27 (reported, not gated) | 122820 (reported, not gated) | 309.89 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 19.68 (base 20.0) | 13 (base 14) | 7896 (base 10264) | 237.22 (base 249.83) | 4.24 (base 5.99) |
| nether | 22.52 (base 33.79) | 10 (base 11) | 4284 (base 10656) | 258.06 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.67 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 257.14 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 256.67 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.69 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.55 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.03 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 262.83 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.01 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 17.74 (reported, not gated) | 13 (reported, not gated) | 3172 (reported, not gated) | 273.94 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7316 (base 7604) | 236.98 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 25.27 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 240.03 (base 248.15) | 3.48 (base 3.73) |
| flat_plants | 16.33 (base 33.0) | 12 (base 13) | 1492 (base 1716) | 239.4 (base 248.11) | 3.48 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.05 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 264.66 (base 261.4) | 4.24 (base 4.24) |
| animation | 50 median (avg 40.05) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.09 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 47.04) (base 60) | 21 (base 22) | 21508 (base 21668) | 236.0 (base 239.53) | 4.24 (base 5.99) |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 412283.604 (624520.625) | 33.984 | 1.774 | 430100 | 422528 (2097152.0) | 323 | 0.0 / 0 |
| flythrough | 567525.339 (910809.79) | 37.69 | 1.086 | 2100148 | 2091488 (2097152.0) | 257 | 4.504 / 53 |
| water_glass | 112457.963 (196087.228) | 42.649 | 1.133 | 10452 | 0 (2097152.0) | 0 | 0.0 / 0 |
| nether | 33634.68 (49909.326) | 32.608 | 1.952 | 112932 | 109440 (2097152.0) | 144 | 0.0 / 0 |
| mobs | 62353.75 (111609.707) | 44.132 | 0.966 | 610516 | 0 (2097152.0) | 2 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 31916.371 (56797.489) | 43.807 | 1.278 | 156324 | 58176 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 52935.249 (93637.529) | 43.468 | 1.217 | 642876 | 567808 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 27758.835 (60456.805) | 54.085 | 1.272 | 32932 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 205650.49 (365247.042) | 43.696 | 1.184 | 758500 | 756224 (2097152.0) | 5 | 0.0 / 0 |
| water_glass_oit | 112611.327 (196354.642) | 42.649 | 1.133 | 9668 | 0 (2097152.0) | 327 | 0.0 / 0 |
| translucent_move_oit | 205470.817 (364798.878) | 43.676 | 1.184 | 726708 | 722688 (2097152.0) | 262 | 0.0 / 0 |
| flat_plants | 9099.909 (12475.811) | 27.06 | 1.045 | 1940 | 0 (2097152.0) | 142 | 0.0 / 0 |
| renderer_off | 20319.866 (38472.12) | 47.183 | 1.0 | 1380 | 0 (2097152.0) | 2 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.114 (5227.753) | 41.77 | 1.087 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2246.003 (4830.871) | 53.507 | 1.0 | 79236 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 2.568 (111) | 2.183 (53) | 0 | 825 / 0 | 5.319 / 7.989 | 2.328 / 4.002 |
| flythrough | 3.182 (1711) | 3.182 (1711) | 0 | 1397 / 0 | 4.301 / 6.124 | 2.141 / 3.813 |
| water_glass | 1.077 (23) | None (0) | 0 | 1146 / 0 | 4.731 / 6.944 | 2.11 / 3.382 |
| nether | 1.995 (24) | 1.608 (3) | 0 | 1767 / 0 | 3.829 / 5.504 | 1.635 / 2.39 |
| mobs | 0.605 (6) | None (0) | 0 | 2003 / 0 | 3.673 / 5.233 | 1.584 / 2.308 |
| outline | 0.255 (13) | None (0) | 0 | 2061 / 0 | 3.628 / 5.156 | 1.582 / 2.272 |
| occlusion | 0.454 (42) | 1.492 (1) | 0 | 2199 / 0 | 3.497 / 4.986 | 1.552 / 2.217 |
| occlusion_move | 1.16 (66) | 2.642 (20) | 0 | 2354 / 0 | 3.353 / 4.763 | 1.498 / 2.108 |
| occlusion_corner | 0.935 (106) | 1.095 (1) | 0 | 2635 / 0 | 3.108 / 4.393 | 1.322 / 1.841 |
| translucent_move | 1.965 (130) | 3.187 (38) | 0 | 3015 / 0 | 3.09 / 4.328 | 1.379 / 1.923 |
| water_glass_oit | 2.352 (159) | None (0) | 0 | 415 / 0 | 4.886 / 6.431 | 2.144 / 3.988 |
| translucent_move_oit | 2.354 (225) | 3.236 (25) | 0 | 976 / 0 | 3.41 / 4.578 | 1.611 / 2.352 |
| flat_plants | 1.067 (87) | None (0) | 0 | 409 / 0 | 4.665 / 5.871 | 1.634 / 2.048 |
| renderer_off | 0.403 (26) | None (0) | 0 | 328 / 0 | 5.189 / 7.618 | 1.776 / 3.264 |
| particles | 0.226 (30) | None (0) | 0 | 3045 / 0 | 3.065 / 4.292 | 1.361 / 1.902 |
| animation | 0.591 (18) | 0.817 (4) | 0 | 3120 / 0 | 3.005 / 4.205 | 1.313 / 1.818 |
| animated_items | 0.227 (42) | 0.611 (2) | 0 | 3152 / 0 | 2.978 / 4.167 | 1.294 / 1.782 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.121 | 700.245 | 16 (vanilla 28) | 1377648 | 39.488 / 0.105 | 22.815 / 36.0 | 36.787 | 2259 / 0 | 2.183 (3.804) |
| flythrough | plain, one multi-draw per region and layer | 57.825 | 927.459 | 16 (vanilla 28) | 5374740 | 15.189 / 0.998 | 88.814 / 144.0 | 143.521 | 6667 / 0 | 3.182 (9.556) |
| water_glass | plain, one multi-draw per region and layer | 14.024 | 105.178 | 16 (vanilla 28) | 774132 | 31.778 / 0.091 | 12.51 / 36.0 | 20.672 | 2939 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.159 | 50.432 | 16 (vanilla 28) | 954344 | 26.75 / 0.193 | 15.211 / 20.0 | 25.484 | 3967 / 0 | 1.608 (1.928) |
| mobs | plain, one multi-draw per region and layer | 8.013 | 58.097 | 16 (vanilla 28) | 598904 | 24.298 / 0.169 | 9.605 / 16.0 | 15.992 | 4416 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77236 | 23.906 / 0.168 | 1.225 / 16.0 | 2.062 | 4510 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.03 | 43.222 | 16 (vanilla 28) | 172444 | 22.741 / 0.159 | 2.741 / 20.0 | 4.605 | 4753 / 0 | 1.492 (1.488) |
| occlusion_move | plain, one multi-draw per region and layer | 10.977 | 78.262 | 16 (vanilla 28) | 219616 | 21.417 / 0.15 | 3.482 / 20.0 | 5.864 | 5055 / 0 | 2.642 (6.433) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.913 | 16 (vanilla 28) | 122728 | 20.18 / 0.141 | 1.931 / 20.0 | 3.277 | 5442 / 0 | 1.095 (1.091) |
| translucent_move | plain, one multi-draw per region and layer | 12.007 | 251.059 | 16 (vanilla 28) | 817068 | 17.252 / 0.126 | 13.191 / 28.0 | 21.818 | 6348 / 0 | 3.187 (9.312) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.049 | 113.346 | 16 (vanilla 28) | 774132 | 7.544 / 0.043 | 12.51 / 20.0 | 20.672 | 1103 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.305 | 265.24 | 16 (vanilla 28) | 791224 | 6.706 / 0.11 | 12.78 / 28.0 | 21.128 | 2461 / 0 | 3.236 (8.41) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.039 | 16 (vanilla 28) | 885644 | 5.991 / 0.01 | 14.163 / 24.0 | 23.649 | 943 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 546112 | 2.367 / 0.02 | 8.679 / 24.0 | 14.583 | 617 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 17.196 / 0.125 | 0.131 / 28.0 | 0.225 | 6396 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 17.06 / 0.124 | 0.302 / 28.0 | 0.518 | 6498 / 0 | 0.817 (1.364) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.691 | 16 (vanilla 28) | 9764 | 17.013 / 0.125 | 0.153 / 28.0 | 0.261 | 6548 / 0 | 0.611 (0.874) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 17.0 | 0.0 | 0 | 0 | 46 (0.019 / 0.028 / 0.029; 0) | 0 | 50220 / 0 / 0 |
| flythrough | 196.353 | 26.612 | 0.0 | 0 | 0 | 906 (0.015 / 0.032 / 2.528; 0) | 58 | 50659 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2368 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.01 / 0.012; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.071 / 0.103 / 0.273; 0) | 180 | 3808 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 984 | 0 (None / None / None; 0) | 0 | 1312 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 789 | 0 (None / None / None; 0) | 0 | 1841 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2288 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 345.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.047 (0.178; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 434.419 | 1.0 (0.0, 0.0) | 1.124 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.014; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.031; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.1 (0.425; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 50.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.061 (0.194; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 52.36 | 10.0 (9.0, 2.358) | 6.0 (6.0, 2.28) | 0.061 (0.3; 0) | 0 | 2783 / 1506114 / 0 / 0 |
| occlusion_corner | 81.864 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 137.147 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 137.46 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.035; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.012 (0.174; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 290.69 / 343.0 (15.3) | 290.69 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1555.56 | 4484 / 0 |
| flythrough | still | 413.02 / 413.5 (0.1) | 413.02 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.0 / 141.0 (62.4) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 13024 / 0 |
| nether | still | 41.99 / 300.0 (86.0) | 41.99 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 99.31 | 37083 / 0 |
| mobs | still | 31.0 / 110.0 (71.8) | 31.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11850 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.12 / 50.0 (47.8) | 26.12 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.0 | 3552 / 0 |
| occlusion_move | still | 52.12 / 52.31 (0.4) | 52.12 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.73 / 81.86 (0.2) | 81.73 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 136.61 / 137.01 (0.3) | 136.61 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 110 / 0 |
| water_glass_oit | still | 53.0 / 141.0 (62.4) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7128 / 0 |
| translucent_move_oit | still | 136.12 / 136.96 (0.6) | 136.12 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 110 / 0 |
| flat_plants | still | 9.0 / 152.0 (94.1) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 20449 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15049 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.3) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 447 / 0 |
| animated_items | still | 12.66 / 13.0 (2.6) | 12.66 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4488.0 | 54 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.238 | - / 3.0 | - / 0.0 | - / 0.0 | 82.868 / 0.238 | 0.028 / 0.01 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.228 / 0.0 | 0.005 / 0.003 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.876 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 58.613 / 58.635 | 0.015 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 6.891 | - / 0.808 | - / 0.0 | - / 0.0 | - / 0.0 | 40.96 / 8.367 | 0.061 / 0.011 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 14.519 / 14.496 | 0.007 / 0.014 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 53.908 / 53.823 | 0.018 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.76 / 12.753 | 0.005 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 6.988 | - / 0.643 | - / 3.0 | - / 0.0 | - / 0.0 | 1.788 / 1.65 | 0.016 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.004 / 0.054 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.302 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.798 / 2.795 | 0.005 / 0.01 | 56 (3) | 40.608 / 9.245 / 31.363 | 3 / 0 | 10.982 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| spawn | 51.5 (base 49.0) | 13 (base 13) | 7540 (base 6372) | 252.24 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 68.58 (reported, not gated) | 28 (reported, not gated) | 130020 (reported, not gated) | 311.27 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.74 (base 20.0) | 13 (base 14) | 7092 (base 10264) | 238.15 (base 249.83) | 3.99 (base 5.99) |
| nether | 23.44 (base 33.79) | 10 (base 11) | 4064 (base 10656) | 259.49 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.67 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 257.77 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.39 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.57 (base 264.64) | 5.99 (base 4.24) |
| occlusion_move | 20.08 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.82 (base 265.66) | 5.99 (base 5.99) |
| occlusion_corner | 11.73 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.37 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.08 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 274.47 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 6980 (base 7604) | 236.97 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.41 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 239.61 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 17.77 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 239.51 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 232.51 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.58 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.09 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 21 (base 22) | 21508 (base 21668) | 236.7 (base 239.53) | 5.99 (base 5.99) |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 392843.024 (591907.441) | 33.631 | 1.776 | 632180 | 624640 (2097152.0) | 254 | 0.0 / 0 |
| flythrough | 495565.041 (781323.909) | 36.574 | 1.089 | 2099924 | 2091704 (2097152.0) | 242 | 4.609 / 58 |
| water_glass | 112476.289 (196119.184) | 42.649 | 1.133 | 187684 | 179584 (2097152.0) | 4 | 0.0 / 0 |
| nether | 29503.31 (42399.739) | 30.416 | 2.0 | 229348 | 225856 (2097152.0) | 143 | 0.0 / 0 |
| mobs | 62353.923 (111610.017) | 44.132 | 0.966 | 610676 | 0 (2097152.0) | 2 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29342.857 (51700.057) | 43.244 | 1.279 | 277732 | 179584 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_move | 22290.157 (39258.712) | 43.222 | 1.261 | 648508 | 573440 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_corner | 21840.277 (47210.557) | 53.739 | 1.215 | 32840 | 31552 (2097152.0) | 1 | 0.0 / 0 |
| translucent_move | 21606.153 (27637.414) | 21.823 | 1.005 | 759172 | 756224 (2097152.0) | 118 | 0.0 / 0 |
| water_glass_oit | 112661.923 (196442.863) | 42.649 | 1.133 | 8884 | 0 (2097152.0) | 285 | 0.0 / 0 |
| translucent_move_oit | 21648.427 (27699.094) | 21.844 | 1.005 | 727380 | 722688 (2097152.0) | 308 | 0.0 / 0 |
| flat_plants | 9100.397 (12476.48) | 27.06 | 1.045 | 1940 | 0 (2097152.0) | 139 | 0.0 / 0 |
| renderer_off | 20319.866 (38472.12) | 47.183 | 1.0 | 1380 | 0 (2097152.0) | 6 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.389 (5146.952) | 41.531 | 1.091 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79236 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 2.528 (107) | 2.688 (57) | 0 | 888 / 0 | 5.033 / 6.687 | 2.082 / 3.079 |
| flythrough | 2.917 (1701) | 2.917 (1701) | 0 | 1395 / 0 | 4.031 / 5.739 | 2.128 / 3.986 |
| water_glass | 1.429 (21) | 3.368 (1) | 0 | 1212 / 0 | 4.518 / 5.897 | 1.993 / 2.778 |
| nether | 1.545 (35) | 1.488 (18) | 0 | 1847 / 0 | 3.691 / 4.856 | 1.622 / 2.276 |
| mobs | 0.649 (6) | None (0) | 0 | 2087 / 0 | 3.578 / 4.717 | 1.577 / 2.197 |
| outline | 0.271 (12) | None (0) | 0 | 2145 / 0 | 3.53 / 4.655 | 1.566 / 2.171 |
| occlusion | 0.783 (57) | 1.826 (2) | 0 | 2281 / 0 | 3.508 / 4.597 | 1.548 / 2.12 |
| occlusion_move | 0.898 (65) | 2.056 (16) | 0 | 2426 / 0 | 3.366 / 4.415 | 1.496 / 2.034 |
| occlusion_corner | 0.692 (106) | 0.971 (1) | 0 | 2709 / 0 | 3.133 / 4.094 | 1.309 / 1.807 |
| translucent_move | 1.981 (129) | 3.116 (33) | 0 | 3071 / 0 | 3.221 / 4.265 | 1.367 / 1.889 |
| water_glass_oit | 2.662 (159) | None (0) | 0 | 415 / 0 | 5.902 / 7.611 | 3.073 / 4.105 |
| translucent_move_oit | 2.105 (229) | 2.862 (25) | 0 | 976 / 0 | 3.859 / 4.981 | 1.906 / 2.639 |
| flat_plants | 1.222 (88) | None (0) | 0 | 403 / 0 | 4.322 / 5.491 | 1.443 / 1.918 |
| renderer_off | 0.39 (26) | None (0) | 0 | 323 / 0 | 5.076 / 7.233 | 1.99 / 3.456 |
| particles | 0.221 (30) | None (0) | 0 | 3098 / 0 | 3.196 / 4.231 | 1.349 / 1.866 |
| animation | 0.646 (18) | 0.735 (4) | 0 | 3173 / 0 | 3.134 / 4.149 | 1.298 / 1.779 |
| animated_items | 0.221 (42) | 0.539 (2) | 0 | 3205 / 0 | 3.108 / 4.111 | 1.274 / 1.759 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.157 | 652.563 | 16 (vanilla 28) | 1372576 | 40.494 / 0.099 | 22.712 / 40.0 | 36.652 | 2421 / 0 | 2.688 (7.067) |
| flythrough | plain, one multi-draw per region and layer | 57.715 | 779.649 | 16 (vanilla 28) | 5379436 | 15.277 / 1.005 | 88.904 / 112.0 | 143.646 | 6637 / 0 | 2.917 (9.09) |
| water_glass | plain, one multi-draw per region and layer | 14.026 | 105.195 | 16 (vanilla 28) | 774132 | 33.402 / 0.09 | 12.51 / 40.0 | 20.672 | 3112 / 0 | 3.368 (3.363) |
| nether | plain, one multi-draw per region and layer | 12.021 | 43.075 | 16 (vanilla 28) | 954648 | 28.016 / 0.178 | 15.217 / 20.0 | 25.492 | 4186 / 0 | 1.488 (2.433) |
| mobs | plain, one multi-draw per region and layer | 8.013 | 58.097 | 16 (vanilla 28) | 598904 | 25.512 / 0.156 | 9.605 / 16.0 | 15.992 | 4644 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77236 | 25.122 / 0.155 | 1.225 / 16.0 | 2.062 | 4737 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 162564 | 23.828 / 0.147 | 2.599 / 20.0 | 4.341 | 5004 / 0 | 1.826 (1.858) |
| occlusion_move | plain, one multi-draw per region and layer | 6.033 | 33.823 | 16 (vanilla 28) | 213428 | 22.589 / 0.139 | 3.406 / 20.0 | 5.699 | 5283 / 0 | 2.056 (4.312) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.068 | 60.89 | 16 (vanilla 28) | 122728 | 21.319 / 0.131 | 1.931 / 20.0 | 3.277 | 5674 / 0 | 0.971 (0.967) |
| translucent_move | plain, one multi-draw per region and layer | 4.395 | 23.088 | 16 (vanilla 28) | 807036 | 18.474 / 0.12 | 13.05 / 28.0 | 21.55 | 6530 / 0 | 3.116 (8.581) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.056 | 113.396 | 16 (vanilla 28) | 774132 | 7.541 / 0.043 | 12.51 / 20.0 | 20.672 | 1103 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.434 | 37.184 | 16 (vanilla 28) | 781192 | 6.936 / 0.117 | 12.64 / 28.0 | 20.86 | 2466 / 0 | 2.862 (7.186) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 878808 | 6.056 / 0.01 | 14.079 / 24.0 | 23.467 | 933 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 546096 | 2.402 / 0.021 | 8.679 / 24.0 | 14.582 | 606 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.434 / 0.12 | 0.131 / 28.0 | 0.225 | 6572 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.29 / 0.119 | 0.302 / 28.0 | 0.518 | 6674 / 0 | 0.735 (1.007) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.24 / 0.119 | 0.153 / 28.0 | 0.261 | 6724 / 0 | 0.539 (0.757) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 152.333 | 17.0 | 0.0 | 0 | 0 | 48 (0.018 / 0.028 / 0.031; 0) | 0 | 38845 / 0 / 0 |
| flythrough | 196.572 | 26.564 | 0.0 | 0 | 0 | 921 (0.012 / 0.031 / 0.806; 0) | 69 | 47767 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2160 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.011 / 0.035 / 0.035; 0) | 32 | 1198 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.088 / 0.105 / 1.718; 0) | 180 | 4046 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 858 | 0 (None / None / None; 0) | 0 | 1144 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 930 | 0 (None / None / None; 0) | 0 | 2170 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2220 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 342.349 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.046 (0.202; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 435.621 | 1.0 (0.0, 0.0) | 1.078 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.015 (0.131; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.101 (0.285; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.056 (0.308; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.349 | 10.0 (9.0, 2.371) | 6.0 (6.0, 2.282) | 0.051 (0.191; 0) | 0 | 2787 / 1509406 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.24 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.519 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 150.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.032; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.115; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.151; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 264.67 / 340.33 (22.2) | 264.66 / 75.66 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 4842 / 0 |
| flythrough | two-phase | 320.79 / 414.38 (22.6) | 316.58 / 97.81 / 4.21 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5835 / 0 |
| water_glass | two-phase | 53.0 / 141.0 (62.4) | 53.0 / 88.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 11880 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 37609 / 0 |
| mobs | two-phase | 31.0 / 110.0 (71.8) | 31.0 / 79.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 11850 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3278 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.37 / 51.3 (56.4) | 22.32 / 28.98 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4343 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.69 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.66 / 135.11 (88.4) | 15.65 / 119.46 / 0.02 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 17199 / 0 |
| water_glass_oit | two-phase | 53.0 / 141.0 (62.4) | 53.0 / 88.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6336 / 0 |
| translucent_move_oit | two-phase | 15.66 / 135.09 (88.4) | 15.63 / 119.46 / 0.03 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9201 / 0 |
| flat_plants | two-phase | 9.0 / 150.0 (94.0) | 9.0 / 141.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 19599 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.13; 100.0) | 14400.0 | 15049 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.06; 100.0) | 14400.0 | 596 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 450 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.5 | - / 3.0 | - / 0.0 | - / 0.0 | 66.808 / 0.502 | 0.024 / 0.007 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.078 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.872 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 51.738 / 51.819 | 0.015 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 6.951 | - / 0.793 | - / 0.0 | - / 0.0 | - / 0.0 | 47.773 / 5.866 | 0.069 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.003 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.938 / 11.907 | 0.006 / 0.014 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 49.818 / 49.72 | 0.02 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.873 / 12.794 | 0.01 / 0.013 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.202 | - / 0.852 | - / 3.0 | - / 0.0 | - / 0.0 | 1.958 / 1.838 | 0.013 / 0.011 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.011 / 0.058 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.006 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.983 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |

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
| core-quicksilver-2p-old | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
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
| core-quicksilver-old | flat_plants | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | translucent_move_oit | 3.48 | 3.48 (0) | 3.48 |  |
| core-quicksilver-old | flythrough | 3.73 | 3.73 (0) | 3.73 |  |

Rises of 4 MB or more: none

