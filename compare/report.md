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
| spawn | 0.1977 | 10.05 | 0.0675 | 0.2054 |
| flythrough | 0.0 | 14.95 | 0.0012 | 0.0012 |
| water_glass | 0.0048 | 6.45 | 0.0043 | 0.0041 |
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
| translucent_move | 0.0001 | 0.3 | 0.0 | 0.0001 |
| translucent_move.x2404 | 0.0001 | 0.3 | 0.0002 | 0.0003 |
| translucent_move.x2414 | 0.0 | 0.3 | 0.0004 | 0.0002 |
| translucent_move.x2424 | 0.0002 | 0.3 | 0.0003 | 0.0004 |
| translucent_move.low | 0.0005 | 0.3 | 0.001 | 0.001 |
| translucent_move.back | 0.0003 | 0.3 | 0.0001 | 0.0002 |
| translucent_move.bare_back | 0.0 | 0.3 | 0.0001 | 0.0001 |
| water_glass_oit | 0.0033 | 0.3 | 0.0039 | 0.0047 |
| translucent_move_oit | 0.0001 | 0.3 | 0.0 | 0.0001 |
| translucent_move_oit.x2404 | 0.0001 | 0.3 | 0.0004 | 0.0005 |
| translucent_move_oit.x2414 | 0.0004 | 0.3 | 0.0001 | 0.0003 |
| translucent_move_oit.x2424 | 0.0001 | 0.3 | 0.0001 | 0.0001 |
| translucent_move_oit.low | 0.0009 | 0.3 | 0.0014 | 0.0011 |
| translucent_move_oit.back | 0.0002 | 0.3 | 0.0001 | 0.0001 |
| translucent_move_oit.bare_back | 0.0002 | 0.3 | 0.0002 | 0.0001 |
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
| spawn | 99.63 | 18057 | 337 (953) | 325 (944) |
| flythrough | 100.0 | 6020 | 53 (302) | 53 (302) |
| water_glass | 99.99 | 25508 | 26 (3511) | 22 (3507) |
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
| translucent_move | 100.0 | 13 | 1 (124) | 3 (125) |
| translucent_move.x2404 | 100.0 | 15 | 3 (172) | 6 (175) |
| translucent_move.x2414 | 100.0 | 13 | 6 (166) | 6 (166) |
| translucent_move.x2424 | 100.0 | 13 | 1 (121) | 2 (121) |
| translucent_move.low | 100.0 | 41 | 12 (18) | 14 (20) |
| translucent_move.back | 100.0 | 13 | 3 (125) | 3 (125) |
| translucent_move.bare_back | 100.0 | 13 | 2 (124) | 2 (125) |
| water_glass_oit | 99.99 | 57 | 19 (3504) | 26 (3510) |
| translucent_move_oit | 100.0 | 12 | 1 (123) | 3 (125) |
| translucent_move_oit.x2404 | 100.0 | 16 | 6 (175) | 5 (174) |
| translucent_move_oit.x2414 | 100.0 | 10 | 3 (163) | 6 (166) |
| translucent_move_oit.x2424 | 100.0 | 15 | 1 (120) | 1 (120) |
| translucent_move_oit.low | 100.0 | 40 | 18 (24) | 14 (20) |
| translucent_move_oit.back | 100.0 | 12 | 2 (124) | 3 (125) |
| translucent_move_oit.bare_back | 100.0 | 15 | 3 (125) | 2 (124) |
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
| spawn | 49.21 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 252.42 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 66.8 (reported, not gated) | 42 (reported, not gated) | 749228 (reported, not gated) | 309.24 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.88 (base 20.0) | 13 (base 14) | 7204 (base 10264) | 238.35 (base 249.83) | 4.24 (base 5.99) |
| nether | 23.79 (base 33.79) | 10 (base 11) | 4284 (base 10656) | 259.57 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.73 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 258.1 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.75 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.73 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.66 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.01 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.19 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.26 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 17.98 (reported, not gated) | 13 (reported, not gated) | 3060 (reported, not gated) | 274.76 (base 268.19) | 4.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 7316 (base 7604) | 237.55 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 25.53 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 240.13 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 17.14 (base 33.0) | 13 (base 13) | 1624 (base 1716) | 240.01 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.43 (base 240.73) | 3.6 (base 5.87) |
| particles | 10.72 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.85 (base 261.4) | 4.24 (base 4.24) |
| animation | 49 median (avg 40.06) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.3 (base 260.68) | 4.24 (base 4.24) |
| animated_items | 60 median (avg 47.09) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.92 (base 239.53) | 4.24 (base 5.99) |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 410516.688 (622025.395) | 34.003 | 1.77 | 726532 | 719104 (2097152.0) | 215 | 0.0 / 0 |
| flythrough | 555407.174 (891956.043) | 37.732 | 1.085 | 2104684 | 2096024 (2097152.0) | 138 | 10.835 / 75 |
| water_glass | 113207.871 (197466.413) | 42.67 | 1.133 | 187012 | 179584 (2097152.0) | 110 | 0.0 / 0 |
| nether | 42177.725 (65432.792) | 35.54 | 1.888 | 155148 | 151296 (2097152.0) | 146 | 0.0 / 0 |
| mobs | 62364.641 (111629.201) | 44.132 | 0.966 | 610516 | 0 (2097152.0) | 37 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29467.7 (51879.487) | 43.2 | 1.277 | 472328 | 374272 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 50383.205 (88575.409) | 43.118 | 1.223 | 766252 | 692224 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_corner | 27770.988 (60486.905) | 54.088 | 1.272 | 32840 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 202613.152 (360030.303) | 43.723 | 1.186 | 759172 | 756224 (2097152.0) | 308 | 0.0 / 0 |
| water_glass_oit | 112795.08 (196675.042) | 42.649 | 1.133 | 9332 | 0 (2097152.0) | 213 | 0.0 / 0 |
| translucent_move_oit | 202821.175 (360044.734) | 43.668 | 1.184 | 727156 | 722688 (2097152.0) | 177 | 0.0 / 0 |
| flat_plants | 9101.742 (12478.324) | 27.06 | 1.045 | 2052 | 0 (2097152.0) | 128 | 0.0 / 0 |
| renderer_off | 20319.98 (38472.335) | 47.183 | 1.0 | 1380 | 0 (2097152.0) | 11 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 10116 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.467 (5228.568) | 41.772 | 1.087 | 86232 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2247.566 (4834.464) | 53.51 | 1.0 | 79304 | 57728 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 4.733 (97) | 4.603 (53) | 0 | 833 / 0 | 9.781 / 12.696 | 5.278 / 7.604 |
| flythrough | 6.5 (1616) | 6.5 (1616) | 0 | 1400 / 0 | 6.92 / 9.908 | 4.803 / 6.648 |
| water_glass | 2.458 (19) | 4.63 (1) | 0 | 1156 / 0 | 8.604 / 11.266 | 4.728 / 6.848 |
| nether | 2.821 (35) | 2.83 (10) | 0 | 1776 / 0 | 7.009 / 9.163 | 3.612 / 5.298 |
| mobs | 1.61 (7) | None (0) | 0 | 2018 / 0 | 6.747 / 8.803 | 3.441 / 5.143 |
| outline | 0.433 (13) | None (0) | 0 | 2076 / 0 | 6.66 / 8.675 | 3.351 / 5.054 |
| occlusion | 1.244 (44) | 3.454 (6) | 0 | 2212 / 0 | 6.456 / 8.438 | 3.208 / 4.897 |
| occlusion_move | 2.539 (57) | 4.548 (18) | 0 | 2375 / 0 | 6.174 / 8.068 | 3.038 / 4.615 |
| occlusion_corner | 1.661 (110) | 4.652 (1) | 0 | 2659 / 0 | 5.762 / 7.479 | 2.773 / 4.072 |
| translucent_move | 3.048 (122) | 4.904 (34) | 0 | 3010 / 0 | 5.695 / 7.478 | 2.846 / 4.12 |
| water_glass_oit | 4.103 (155) | None (0) | 0 | 415 / 0 | 9.337 / 11.47 | 5.441 / 6.952 |
| translucent_move_oit | 5.17 (216) | 5.943 (26) | 0 | 966 / 0 | 6.489 / 8.253 | 3.544 / 5.035 |
| flat_plants | 1.65 (88) | None (0) | 0 | 405 / 0 | 7.217 / 9.137 | 3.335 / 3.87 |
| renderer_off | 0.871 (25) | None (0) | 0 | 328 / 0 | 9.156 / 13.359 | 4.622 / 6.193 |
| particles | 0.4 (30) | None (0) | 0 | 3037 / 0 | 5.65 / 7.418 | 2.794 / 4.071 |
| animation | 1.015 (18) | 1.524 (4) | 0 | 3112 / 0 | 5.546 / 7.274 | 2.728 / 3.982 |
| animated_items | 0.407 (42) | 1.277 (2) | 0 | 3144 / 0 | 5.497 / 7.206 | 2.672 / 3.909 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 38.177 | 692.54 | 16 (vanilla 28) | 1341548 | 40.767 / 0.081 | 22.229 / 36.0 | 35.823 | 2261 / 0 | 4.603 (8.289) |
| flythrough | plain, one multi-draw per region and layer | 57.101 | 896.565 | 16 (vanilla 28) | 5142656 | 14.706 / 0.96 | 85.05 / 112.0 | 137.324 | 6466 / 0 | 6.5 (18.323) |
| water_glass | plain, one multi-draw per region and layer | 14.031 | 106.373 | 16 (vanilla 28) | 774132 | 33.072 / 0.073 | 12.51 / 36.0 | 20.672 | 2944 / 0 | 4.63 (4.627) |
| nether | plain, one multi-draw per region and layer | 12.447 | 65.637 | 16 (vanilla 28) | 954488 | 27.66 / 0.169 | 15.215 / 20.0 | 25.488 | 3990 / 0 | 2.83 (4.149) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 58.107 | 16 (vanilla 28) | 598904 | 25.066 / 0.147 | 9.605 / 16.0 | 15.992 | 4454 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77236 | 24.667 / 0.147 | 1.225 / 16.0 | 2.062 | 4548 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.07 | 43.492 | 16 (vanilla 28) | 161208 | 23.484 / 0.139 | 2.581 / 20.0 | 4.305 | 4797 / 0 | 3.454 (5.555) |
| occlusion_move | plain, one multi-draw per region and layer | 10.966 | 76.221 | 16 (vanilla 28) | 212052 | 22.134 / 0.131 | 3.388 / 20.0 | 5.662 | 5103 / 0 | 4.548 (13.156) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.955 | 16 (vanilla 28) | 122728 | 20.833 / 0.123 | 1.931 / 20.0 | 3.277 | 5500 / 0 | 4.652 (4.638) |
| translucent_move | plain, one multi-draw per region and layer | 11.989 | 248.317 | 16 (vanilla 28) | 808952 | 18.08 / 0.112 | 13.093 / 28.0 | 21.601 | 6332 / 0 | 4.904 (12.009) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.075 | 113.531 | 16 (vanilla 28) | 774132 | 7.563 / 0.043 | 12.51 / 20.0 | 20.672 | 1095 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.576 | 263.418 | 16 (vanilla 28) | 786404 | 6.716 / 0.095 | 12.737 / 28.0 | 20.999 | 2424 / 0 | 5.943 (15.174) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.043 | 16 (vanilla 28) | 877540 | 6.051 / 0.01 | 14.063 / 24.0 | 23.433 | 941 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 546096 | 2.386 / 0.02 | 8.679 / 24.0 | 14.582 | 616 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.039 / 0.112 | 0.131 / 28.0 | 0.225 | 6374 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.524 | 16 (vanilla 28) | 19416 | 17.895 / 0.111 | 0.302 / 28.0 | 0.518 | 6476 / 0 | 1.524 (2.223) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.711 | 16 (vanilla 28) | 9764 | 17.845 / 0.112 | 0.153 / 28.0 | 0.261 | 6526 / 0 | 1.277 (2.015) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 154.0 | 16.0 | 0.0 | 0 | 0 | 49 (0.027 / 0.049 / 0.065; 0) | 0 | 33264 / 0 / 0 |
| flythrough | 186.698 | 26.223 | 0.0 | 0 | 0 | 846 (0.029 / 0.047 / 9.05; 0) | 52 | 25951 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1804 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.008 / 0.029 / 0.034; 0) | 32 | 1194 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.1 / 0.151 / 0.411; 0) | 180 | 2548 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 642 | 0 (None / None / None; 0) | 0 | 856 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 534 | 0 (None / None / None; 0) | 0 | 1246 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2052 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2392 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 327.0 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.045 (0.162; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 432.058 | 1.0 (0.0, 0.0) | 1.187 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.016 (0.051; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.146 (0.228; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.022; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.081 (0.202; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.347 | 10.0 (9.0, 2.357) | 6.0 (6.0, 2.281) | 0.059 (0.205; 0) | 0 | 2769 / 1498366 / 0 / 0 |
| occlusion_corner | 81.862 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.055 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.004; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.781 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.064; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.007 (0.036; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 286.78 / 325.0 (11.8) | 286.78 / 0.0 / 0.0 | 0.11 | 0.0 (0.0, 0.0; 0.0) | 1600.0 | 1950 / 0 |
| flythrough | still | 398.53 / 398.97 (0.1) | 398.53 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.59 / 141.0 (62.0) | 53.59 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 31.93 | 9944 / 0 |
| nether | still | 50.9 / 300.0 (83.0) | 50.9 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 253.62 | 31297 / 0 |
| mobs | still | 31.0 / 110.0 (71.8) | 31.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 10744 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.34 / 49.0 (46.2) | 26.34 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 71.88 | 3450 / 0 |
| occlusion_move | still | 51.11 / 51.29 (0.4) | 51.11 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 37 / 0 |
| occlusion_corner | still | 81.77 / 81.85 (0.1) | 81.77 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 26 / 0 |
| translucent_move | still | 134.98 / 135.87 (0.7) | 134.98 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass_oit | still | 53.0 / 141.0 (62.4) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 4664 / 0 |
| translucent_move_oit | still | 134.81 / 136.03 (0.9) | 134.81 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 18176 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 600 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1152.0 | 444 / 0 |
| animated_items | still | 12.68 / 13.0 (2.5) | 12.68 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 48 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.098 | - / 3.0 | - / 0.0 | - / 0.0 | 67.219 / 0.097 | 0.018 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.328 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.827 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 53.112 / 53.14 | 0.02 / 0.028 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.667 | - / 0.92 | - / 0.0 | - / 0.0 | - / 0.0 | 36.005 / 6.826 | 0.064 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 14.558 / 14.431 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 53.638 / 53.598 | 0.014 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.165 / 11.118 | 0.006 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.52 | - / 0.871 | - / 3.0 | - / 0.0 | - / 0.0 | 2.691 / 2.519 | 0.014 / 0.009 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.009 / 0.063 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.798 | 0.005 / 0.01 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.988 |
| animated_items | - / 28.104 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |

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
| spawn | 51.0 (base 49.0) | 13 (base 13) | 7428 (base 6372) | 253.87 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 69.89 (reported, not gated) | 45 (reported, not gated) | 685596 (reported, not gated) | 309.33 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 20.91 (base 20.0) | 13 (base 14) | 7316 (base 10264) | 237.85 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.17 (base 33.79) | 10 (base 11) | 4420 (base 10656) | 259.62 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.75 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 258.47 (base 268.23) | 3.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.85 (base 264.41) | 3.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 265.02 (base 264.64) | 3.99 (base 4.24) |
| occlusion_move | 20.08 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.03 (base 265.66) | 3.99 (base 5.99) |
| occlusion_corner | 11.77 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.39 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.15 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 274.87 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7316 (base 7604) | 238.05 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.43 (reported, not gated) | 13 (reported, not gated) | 2836 (reported, not gated) | 240.91 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 18.18 (base 33.0) | 13 (base 13) | 1512 (base 1716) | 239.82 (base 248.11) | 3.73 (base 5.99) |
| renderer_off | 13.68 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.92 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.96 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.98) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.36 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.69) (base 60) | 21 (base 22) | 21508 (base 21668) | 237.07 (base 239.53) | 5.99 (base 5.99) |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 399054.584 (600311.191) | 33.525 | 1.776 | 316236 | 308808 (2097152.0) | 178 | 0.0 / 0 |
| flythrough | 483736.559 (763502.912) | 36.642 | 1.087 | 2103596 | 2095976 (2097152.0) | 136 | 7.175 / 58 |
| water_glass | 112538.525 (196227.701) | 42.649 | 1.133 | 10004 | 0 (2097152.0) | 130 | 0.0 / 0 |
| nether | 29509.749 (42408.992) | 30.416 | 2.0 | 337428 | 332672 (2097152.0) | 127 | 0.0 / 0 |
| mobs | 62366.355 (111632.269) | 44.132 | 0.966 | 610516 | 0 (2097152.0) | 41 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 31939.41 (56869.099) | 43.837 | 1.279 | 98148 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 24025.544 (42736.081) | 43.782 | 1.253 | 665120 | 590144 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 21842.154 (47219.643) | 53.744 | 1.215 | 32840 | 31552 (2097152.0) | 2 | 0.0 / 0 |
| translucent_move | 21627.447 (27674.091) | 21.849 | 1.005 | 758760 | 756352 (2097152.0) | 127 | 0.0 / 0 |
| water_glass_oit | 112807.75 (196697.135) | 42.649 | 1.133 | 8884 | 0 (2097152.0) | 208 | 0.0 / 0 |
| translucent_move_oit | 21746.8 (27871.076) | 21.974 | 1.005 | 727604 | 722688 (2097152.0) | 210 | 0.0 / 0 |
| flat_plants | 9102.846 (12479.838) | 27.06 | 1.045 | 1828 | 0 (2097152.0) | 120 | 0.0 / 0 |
| renderer_off | 20404.525 (38641.383) | 47.195 | 1.0 | 1380 | 0 (2097152.0) | 41 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79236 | 57728 (2097152.0) | 1 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 3.605 (111) | 3.27 (51) | 0 | 890 / 0 | 8.606 / 11.659 | 3.655 / 5.485 |
| flythrough | 6.095 (1630) | 6.095 (1630) | 0 | 1397 / 0 | 7.669 / 10.816 | 5.22 / 7.359 |
| water_glass | 2.605 (18) | None (0) | 0 | 1209 / 0 | 7.852 / 10.365 | 3.599 / 5.262 |
| nether | 2.853 (45) | 2.829 (25) | 0 | 1839 / 0 | 6.513 / 8.616 | 3.133 / 4.454 |
| mobs | 0.912 (6) | None (0) | 0 | 2079 / 0 | 6.347 / 8.471 | 3.054 / 4.372 |
| outline | 0.478 (13) | None (0) | 0 | 2137 / 0 | 6.248 / 8.365 | 3.012 / 4.307 |
| occlusion | 1.313 (39) | None (0) | 0 | 2266 / 0 | 6.116 / 8.154 | 2.983 / 4.231 |
| occlusion_move | 1.717 (62) | 4.296 (17) | 0 | 2415 / 0 | 5.888 / 7.832 | 2.884 / 4.01 |
| occlusion_corner | 1.318 (99) | 1.286 (1) | 0 | 2695 / 0 | 5.52 / 7.286 | 2.665 / 3.743 |
| translucent_move | 3.648 (105) | 5.528 (31) | 0 | 3048 / 0 | 5.463 / 7.212 | 2.733 / 3.791 |
| water_glass_oit | 4.628 (155) | None (0) | 0 | 415 / 0 | 9.015 / 11.154 | 4.637 / 6.366 |
| translucent_move_oit | 4.891 (217) | 4.922 (25) | 0 | 1030 / 0 | 6.186 / 7.945 | 3.424 / 4.412 |
| flat_plants | 1.658 (84) | 2.381 (1) | 0 | 405 / 0 | 6.713 / 9.075 | 2.918 / 3.161 |
| renderer_off | 0.595 (20) | None (0) | 0 | 327 / 0 | 9.165 / 12.959 | 4.282 / 7.008 |
| particles | 0.369 (24) | None (0) | 0 | 3077 / 0 | 5.42 / 7.152 | 2.7 / 3.764 |
| animation | 1.076 (18) | 1.528 (4) | 0 | 3152 / 0 | 5.316 / 7.006 | 2.637 / 3.645 |
| animated_items | 0.347 (38) | 0.983 (2) | 0 | 3184 / 0 | 5.268 / 6.942 | 2.601 / 3.583 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.219 | 664.713 | 16 (vanilla 28) | 1394548 | 42.01 / 0.084 | 23.068 / 36.0 | 37.238 | 2426 / 0 | 3.27 (6.593) |
| flythrough | plain, one multi-draw per region and layer | 59.169 | 755.213 | 16 (vanilla 28) | 5155444 | 15.348 / 1.043 | 85.2 / 112.0 | 137.665 | 6518 / 0 | 6.095 (17.306) |
| water_glass | plain, one multi-draw per region and layer | 14.034 | 105.253 | 16 (vanilla 28) | 774132 | 34.073 / 0.076 | 12.51 / 36.0 | 20.672 | 3095 / 0 | None (None) |
| nether | plain, one multi-draw per region and layer | 12.024 | 43.084 | 16 (vanilla 28) | 954632 | 28.429 / 0.169 | 15.215 / 20.0 | 25.491 | 4179 / 0 | 2.829 (4.803) |
| mobs | plain, one multi-draw per region and layer | 8.015 | 58.108 | 16 (vanilla 28) | 598904 | 25.83 / 0.148 | 9.605 / 16.0 | 15.992 | 4637 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77236 | 25.431 / 0.148 | 1.225 / 16.0 | 2.062 | 4731 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 178220 | 24.28 / 0.141 | 2.847 / 20.0 | 4.759 | 4956 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.035 | 33.82 | 16 (vanilla 28) | 229076 | 23.014 / 0.133 | 3.655 / 20.0 | 6.117 | 5238 / 0 | 4.296 (11.86) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.068 | 60.905 | 16 (vanilla 28) | 122728 | 21.775 / 0.126 | 1.931 / 20.0 | 3.277 | 5616 / 0 | 1.286 (1.284) |
| translucent_move | plain, one multi-draw per region and layer | 4.403 | 23.109 | 16 (vanilla 28) | 822720 | 18.897 / 0.114 | 13.299 / 28.0 | 21.969 | 6427 / 0 | 5.528 (14.991) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.077 | 113.543 | 16 (vanilla 28) | 774132 | 7.561 / 0.043 | 12.51 / 20.0 | 20.672 | 1095 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.467 | 37.5 | 16 (vanilla 28) | 796892 | 7.296 / 0.198 | 12.888 / 28.0 | 21.279 | 2539 / 0 | 4.922 (15.403) |
| flat_plants | plain, one multi-draw per region and layer | 4.008 | 22.046 | 16 (vanilla 28) | 902596 | 5.84 / 0.01 | 14.442 / 24.0 | 24.102 | 926 / 0 | 2.381 (2.378) |
| renderer_off | plain, one multi-draw per region and layer | 8.014 | 22.037 | 16 (vanilla 28) | 546464 | 2.368 / 0.02 | 8.687 / 24.0 | 14.592 | 607 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.85 / 0.114 | 0.131 / 28.0 | 0.225 | 6470 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.701 / 0.113 | 0.302 / 28.0 | 0.518 | 6572 / 0 | 1.528 (2.234) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.654 / 0.113 | 0.153 / 28.0 | 0.261 | 6619 / 0 | 0.983 (1.606) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 156.0 | 17.0 | 0.0 | 0 | 0 | 38 (0.025 / 0.049 / 0.053; 0) | 0 | 27924 / 0 / 0 |
| flythrough | 187.518 | 26.139 | 0.0 | 0 | 0 | 872 (0.021 / 0.048 / 3.522; 0) | 42 | 25690 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1664 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1196 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 38 (0.008 / 0.018 / 0.022; 0) | 32 | 1194 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.098 / 0.152 / 0.188; 0) | 180 | 3549 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 627 | 0 (None / None / None; 0) | 0 | 836 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 633 | 0 (None / None / None; 0) | 0 | 1477 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1932 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2364 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 351.134 | 2.0 (1.0, 0.0) | 11.0 (1.0, 0.0) | 0.046 (0.108; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 433.234 | 1.0 (0.0, 0.0) | 1.182 (0.0, 0.0) | 0.001 (0.033; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 300.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.086; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 110.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.133 (0.206; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 50.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.077 (0.181; 0) | 0 | 3588 / 1624168 / 0 / 0 |
| occlusion_move | 52.353 | 10.0 (9.0, 2.365) | 6.0 (6.0, 2.28) | 0.061 (0.234; 0) | 0 | 2773 / 1501896 / 0 / 0 |
| occlusion_corner | 81.867 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.241 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 141.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.82 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 152.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.024; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.071; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 269.0 / 349.12 (22.9) | 269.0 / 80.12 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3525 / 0 |
| flythrough | two-phase | 311.26 / 400.64 (22.3) | 304.32 / 96.31 / 6.94 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3056 / 0 |
| water_glass | two-phase | 53.0 / 141.0 (62.4) | 53.0 / 88.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 9152 / 0 |
| nether | two-phase | 37.0 / 300.0 (87.7) | 37.0 / 263.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 33401 / 0 |
| mobs | two-phase | 31.0 / 110.0 (71.8) | 31.0 / 79.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 10586 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 50.0 (48.0) | 26.0 / 24.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3600 / 0 |
| occlusion_move | two-phase | 22.38 / 52.3 (57.2) | 22.33 / 29.98 / 0.05 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4450 / 0 |
| occlusion_corner | two-phase | 60.78 / 81.86 (25.8) | 60.7 / 21.16 / 0.08 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.67 / 136.11 (88.5) | 15.65 / 120.46 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15297 / 0 |
| water_glass_oit | two-phase | 53.0 / 141.0 (62.4) | 53.0 / 88.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4576 / 0 |
| translucent_move_oit | two-phase | 15.89 / 136.14 (88.3) | 15.84 / 120.3 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6381 / 0 |
| flat_plants | two-phase | 9.0 / 152.0 (94.1) | 9.0 / 143.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 17303 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 14847 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 596 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 84.708 / 0.0 | 0.025 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.11 / 0.0 | 0.003 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.832 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 54.555 / 54.567 | 0.015 / 0.024 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.49 | - / 0.935 | - / 0.0 | - / 0.0 | - / 0.0 | 49.83 / 8.877 | 0.077 / 0.012 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.015 / 10.966 | 0.004 / 0.01 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 52.771 / 52.818 | 0.012 / 0.02 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.751 / 12.687 | 0.007 / 0.009 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 7.51 | - / 0.917 | - / 3.0 | - / 0.0 | - / 0.0 | 1.83 / 1.731 | 0.011 / 0.008 | 56 (5) | 23.0 / 2.0 / 21.0 | 0 / 0 | 6.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.007 / 0.049 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.311 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.003 / 0.009 | 56 (3) | 40.608 / 9.248 / 31.36 | 3 / 0 | 10.987 |
| animated_items | - / 28.028 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (9) | 40.51 / 7.97 / 32.54 | 0 / 0 | 9.0 |

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
siftec/quicksilver-old: bench kinetics_instancing: median meshing time 1.854 ms per section against vanilla's compiler 2.201 ms (0.842x; limit 2.201 ms; 156 pairs): reported, not gated (open gap)

siftec/quicksilver-old: bench factory_flat: median meshing time 0.456 ms per section against vanilla's compiler 0.429 ms (1.063x; limit 0.472 ms; 601 pairs): reported, not gated (open gap)

- quicksilver-2p-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`
  - probe: `gpuVendor="Mesa" renderer="llvmpipe (LLVM 20.1.2, 256 bits)" driver="Mesa 25.2.8-0ubuntu0.24.04.4" gl=3.3 backend=OpenGL os="Linux 7.0.0-1017-azure amd64" windowSystem=X11 cpuCores=4 GL_ARB_multi_draw_indirect=no GL_ARB_buffer_storage=no deviceType=CPU vanilla.multiDrawIndirect=no vanilla.persistentMapping=no vanilla.mdiKnownIssues=yes`
siftec/quicksilver-2p-old: bench factory_flat: median meshing time 0.547 ms per section against vanilla's compiler 0.48 ms (1.14x; limit 0.528 ms; 605 pairs): reported, not gated (open gap)

siftec/quicksilver-2p-old: bench kinetics_instancing: median meshing time 1.711 ms per section against vanilla's compiler 1.171 ms (1.461x; limit 1.171 ms; 151 pairs): reported, not gated (open gap)

- vanilla-old: backend `OpenGL` drivers `3.3 (Core Profile) Mesa 25.2.8-0ubuntu0.24.04.4`

GPU error messages in the client logs (Quicksilver run / vanilla run of the same profile):

- old-gpu: 54 / 54
- old-gpu-2p: 54 / 54

**Quick mode** (core suite; vanilla a, vanilla b, Quicksilver old-GPU against vanilla a): the measure-run gates (same-run draw calls, terrain GPU memory, measure pictures) and the full and Vulkan profiles are not run. A merge needs a full run.

| scene | noise (vanilla a/b) % | limit % | old-GPU % | old-GPU two-phase % |
|---|---|---|---|---|
| factory | 0.0169 | 0.3 | 0.0 | 0.0 |
| factory_flat | 0.0034 | 0.3 | 0.0 | 0.0 |
| sift | 0.0 | 1.15 | 0.0065 | 0.0065 |
| hub | 0.0 | 0.25 | 0.0 | 0.0 |
| mam | 0.0 | 0.25 | 0.0 | 0.0 |
| ponder | 0.0 | 0.25 | 0.0 | 0.0 |
| map | skipped: MapMod is being finished (Andre, 2026-10-30): the map scene is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| hologram | 0.0018 | 0.55 | 0.0056 | 0.0061 |
| hud | skipped: MapMod is being finished (Andre, 2026-10-30): the HUD scene (its minimap) is out of the bench and CI until then; with it, its limits are re-collected | | | | |
| create_ct | 0.0 | 0.25 | 0.0 | 0.0 |
| kinetics | 0.0187 | 0.25 | 0.0061 | 0.0112 |
| kinetics_instancing | 0.0038 | 0.25 | 0.0091 | 0.0089 |

Strict picture: pixels where all three vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| factory | 99.96 | 370 | 0 (15) | 0 (15) |
| factory_flat | 94.16 | 40 | 0 (16) | 0 (16) |
| sift | 100.0 | 100 | 82 (729) | 82 (729) |
| hub | 100.0 | 10 | 0 (0) | 0 (0) |
| mam | 87.25 | 10 | 0 (0) | 0 (0) |
| ponder | 100.0 | 10 | 0 (0) | 0 (0) |
| hologram | 94.16 | 413 | 38 (4278) | 42 (4283) |
| create_ct | 100.0 | 10 | 0 (0) | 0 (0) |
| kinetics | 98.55 | 30 | 9 (1141) | 9 (1141) |
| kinetics_instancing | 98.55 | 30 | 9 (1141) | 9 (1141) |

### Counts, siftec old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 15.93 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 365.8 (base 361.53) | 4.24 (base 5.48) |
| factory_flat | 15.95 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.71 (base 360.27) | 3.48 (base 5.48) |
| sift | 36.56 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.15 (base 379.69) | 4.24 (base 4.24) |
| hub | 20.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.25 (base 392.07) | 4.24 (base 5.99) |
| mam | 21.53 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.29 (base 404.98) | 8.24 (base 7.73) |
| ponder | 87.25 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 405.89 (base 403.64) | 8.24 (base 8.24) |
| hologram | 24 median (avg 23.67) (reported, not gated) | 15 (base 15) | 42532 (base 43652) | 396.76 (base 392.54) | 8.06 (base 7.54) |
| create_ct | 6.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 397.43 (base 393.74) | 8.06 (base 8.24) |
| kinetics | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.78 (base 396.01) | 8.06 (base 8.06) |
| kinetics_instancing | 10.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 358.83 (base 360.95) | 5.48 (base 5.48) |

Package 4b, siftec old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 14348.634 (27748.487) | 48.29 | 1.0 | 149844 | 100928 (2097152.0) | 1 | 0.0 / 0 |
| factory_flat | 14413.689 (27859.047) | 48.262 | 1.0 | 149844 | 100928 (2097152.0) | 1 | 0.0 / 0 |
| sift | 115645.298 (158024.045) | 26.818 | 1.431 | 4148 | 0 (2097152.0) | 123 | 0.0 / 0 |
| hub | 474.795 (783.312) | 39.386 | 1.0 | 83908 | 0 (2097152.0) | 4 | 0.0 / 0 |
| mam | 568.948 (925.543) | 38.528 | 1.25 | 40068 | 0 (2097152.0) | 6 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 | 0 (2097152.0) | 0 | 0.0 / 0 |
| hologram | 3670.117 (6346.578) | 42.172 | 1.0 | 44436 | 0 (2097152.0) | 1 | 0.0 / 0 |
| create_ct | 2538.216 (5312.825) | 52.225 | 1.0 | 1124 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, siftec old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| factory | 3.028 (35) | 3.281 (12) | 0 | 1070 / 0 | 6.883 / 9.047 | 3.466 / 5.392 |
| factory_flat | 1.753 (69) | 2.13 (13) | 0 | 601 / 0 | 1.819 / 1.774 | 0.456 / 0.429 |
| sift | 1.97 (41) | None (0) | 0 | 1611 / 0 | 5.419 / 7.244 | 2.113 / 3.417 |
| hub | 0.298 (8) | None (0) | 0 | 1666 / 0 | 5.315 / 7.108 | 2.021 / 3.363 |
| mam | 0.379 (4) | None (0) | 0 | 1978 / 0 | 5.255 / 7.287 | 2.345 / 4.135 |
| ponder | None (0) | None (0) | 0 | 1979 / 0 | 5.252 / 7.283 | 2.339 / 4.129 |
| hologram | 1.425 (13) | None (0) | 0 | 2012 / 0 | 5.214 / 7.216 | 2.288 / 3.971 |
| create_ct | 0.52 (46) | None (0) | 0 | 2068 / 0 | 5.115 / 7.065 | 2.176 / 3.625 |
| kinetics | None (0) | None (0) | 0 | 2163 / 0 | 4.952 / 6.813 | 2.0 / 3.385 |
| kinetics_instancing | None (0) | None (0) | 0 | 156 / 0 | 6.738 / 7.331 | 1.854 / 2.201 |

Terrain module, siftec old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.247 | 34.578 | 16 (vanilla 28) | 96100 | 24.625 / 0.341 | 1.511 / 28.0 | 2.566 | 2255 / 0 | 3.281 (5.796) |
| factory_flat | plain, one multi-draw per region and layer | 4.268 | 34.793 | 16 (vanilla 28) | 96084 | 2.743 / 0.025 | 1.511 / 8.0 | 2.566 | 809 / 0 | 2.13 (5.809) |
| sift | plain, one multi-draw per region and layer | 17.043 | 320.808 | 16 (vanilla 28) | 462560 | 22.912 / 0.359 | 7.388 / 16.0 | 12.352 | 3262 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 22.326 / 0.348 | 1.879 / 12.0 | 3.137 | 3349 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1182660 | 23.084 / 0.369 | 20.133 / 32.0 | 31.58 | 3995 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1011808 | 23.084 / 0.369 | 17.437 / 32.0 | 27.018 | 3996 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 22.947 / 0.365 | 0.238 / 32.0 | 0.367 | 4054 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 22.603 / 0.359 | 0.171 / 32.0 | 0.283 | 4151 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 22.586 / 0.374 | 0.372 / 32.0 | 0.624 | 4264 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 52840 | 5.864 / 0.276 | 0.833 / 8.0 | 1.411 | 178 / 0 | None (None) |

Translucency, siftec old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2382 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 597 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 600 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 602 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.004 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.003 (0.028; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | still | 29.52 / 69.0 (57.2) | 29.52 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 288.0 | 5922 / 0 |
| factory_flat | still | 29.73 / 69.0 (56.9) | 29.73 / 0.0 / 0.0 | 0.02 | 0.0 (0.0, 0.0; 0.0) | 312.52 | 5880 / 0 |
| sift | still | 175.0 / 244.0 (28.3) | 175.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 6831 / 0 |
| hub | still | 4.0 / 38.0 (89.5) | 4.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 5066 / 0 |
| mam | still | 3.0 / 55.0 (94.5) | 3.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7800 / 0 |
| ponder | still | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| hologram | still | 6.0 / 9.0 (33.3) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 447 / 0 |
| create_ct | still | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| kinetics | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |
| kinetics_instancing | still | 18.0 / 23.0 (21.7) | 18.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 750 / 0 |

Effects, siftec old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.003 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | - / 9.596 | - / 0.0 | - / 4.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.0 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 141.628 / 86.963 | 0.116 / 0.033 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| factory_flat | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| sift | 5.0 / - | 0.0 / - | 20.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| hub | 13.87 / - | 0.0 / - | 574.59 / - | 6.0 / - (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / - (8.0 / -) |
| mam | 13.86 / - | 1.0 / - | 112.91 / - | 7.0 / - (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / - (8.0 / -) |
| ponder | 82.58 / - | 0.11 / - | 203.7 / - | 73.0 / - (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / - (75.0 / -) |
| hologram | 16.0 / - | 0.0 / - | 163.0 / - | 5.0 / - (pipelines 5.0, textures 5.0, scissors 1.0) | 16.0 / - (5.0 / -) |
| create_ct | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |
| kinetics | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |
| kinetics_instancing | 0.0 / - | 0.0 / - | 0.0 / - | 0.0 / - (pipelines 0.0, textures 0.0, scissors 0.0) | 0.0 / - (0.0 / -) |

### Counts, siftec old-gpu-2p

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| factory | 16.67 (base 20.24) | 13 (base 13) | 48916 (base 49024) | 366.52 (base 361.53) | 3.73 (base 5.48) |
| factory_flat | 16.67 (reported, not gated) | 13 (base 13) | 48916 (base 48916) | 361.49 (base 360.27) | 5.48 (base 5.48) |
| sift | 38.0 (base 41.0) | 16 (base 18) | 4148 (base 81788) | 384.78 (base 379.69) | 3.73 (base 4.24) |
| hub | 21.54 (base 25.55) | 14 (base 14) | 64948 (base 64948) | 397.37 (base 392.07) | 3.73 (base 5.99) |
| mam | 22.52 (base 24.54) | 17 (base 17) | 21108 (base 21108) | 410.76 (base 404.98) | 7.73 (base 7.73) |
| ponder | 88.24 (base 87.26) | 12 (base 12) | 52212 (base 52212) | 409.54 (base 403.64) | 7.73 (base 8.24) |
| hologram | 25 median (avg 24.67) (reported, not gated) | 15 (base 15) | 43316 (base 43652) | 397.05 (base 392.54) | 7.54 (base 7.54) |
| create_ct | 7.67 (base 6.67) | 10 (base 10) | 1124 (base 1124) | 398.1 (base 393.74) | 7.54 (base 8.24) |
| kinetics | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 396.85 (base 396.01) | 7.54 (base 8.06) |
| kinetics_instancing | 11.67 (base 11.67) | 11 (base 11) | 252956 (base 252956) | 359.91 (base 360.95) | 3.48 (base 5.48) |

Package 4b, siftec old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| factory | 13583.693 (26448.172) | 48.64 | 1.0 | 149752 | 100928 (2097152.0) | 8 | 0.0 / 0 |
| factory_flat | 13583.462 (26447.722) | 48.64 | 1.0 | 149844 | 100928 (2097152.0) | 1 | 0.0 / 0 |
| sift | 115659.979 (158044.106) | 26.818 | 1.431 | 4148 | 0 (2097152.0) | 261 | 0.0 / 0 |
| hub | 474.797 (783.314) | 39.386 | 1.0 | 83908 | 0 (2097152.0) | 2 | 0.0 / 0 |
| mam | 568.947 (925.54) | 38.528 | 1.25 | 40068 | 0 (2097152.0) | 2 | 0.0 / 0 |
| ponder | 10.017 (12.02) | 16.667 | 2.0 | 61188 | 0 (2097152.0) | 0 | 0.0 / 0 |
| hologram | 3670.148 (6346.631) | 42.172 | 1.0 | 45892 | 0 (2097152.0) | 3 | 0.0 / 0 |
| create_ct | 2538.223 (5312.84) | 52.225 | 1.0 | 1124 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 0 | 0.0 / 0 |
| kinetics_instancing | 5437.062 (10385.309) | 47.647 | 1.0 | 252956 | 0 (2097152.0) | 1 | 0.0 / 0 |

Package 4c, siftec old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| factory | 2.613 (35) | 2.421 (12) | 0 | 926 / 0 | 7.409 / 9.53 | 4.204 / 6.032 |
| factory_flat | 1.711 (69) | 1.819 (13) | 0 | 605 / 0 | 1.827 / 1.695 | 0.547 / 0.48 |
| sift | 0.996 (41) | None (0) | 0 | 1469 / 0 | 5.517 / 7.095 | 2.257 / 3.418 |
| hub | 0.326 (8) | None (0) | 0 | 1517 / 0 | 5.401 / 6.972 | 2.195 / 3.381 |
| mam | 0.454 (4) | None (0) | 0 | 1829 / 0 | 5.381 / 7.284 | 2.379 / 3.965 |
| ponder | None (0) | None (0) | 0 | 1830 / 0 | 5.378 / 7.28 | 2.371 / 3.961 |
| hologram | 0.756 (19) | None (0) | 0 | 1863 / 0 | 5.33 / 7.2 | 2.345 / 3.832 |
| create_ct | 0.468 (46) | None (0) | 0 | 1919 / 0 | 5.209 / 7.033 | 2.219 / 3.569 |
| kinetics | None (0) | None (0) | 0 | 2014 / 0 | 5.02 / 6.753 | 2.019 / 3.316 |
| kinetics_instancing | None (0) | None (0) | 0 | 151 / 0 | 5.708 / 5.524 | 1.711 / 1.171 |

Terrain module, siftec old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| factory | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96100 | 26.959 / 0.306 | 1.511 / 28.0 | 2.566 | 1974 / 0 | 2.421 (2.65) |
| factory_flat | plain, one multi-draw per region and layer | 4.007 | 32.054 | 16 (vanilla 28) | 96084 | 2.765 / 0.024 | 1.511 / 8.0 | 2.566 | 817 / 0 | 1.819 (4.611) |
| sift | plain, one multi-draw per region and layer | 17.045 | 320.849 | 16 (vanilla 28) | 462560 | 24.669 / 0.332 | 7.388 / 16.0 | 12.352 | 2983 / 0 | None (None) |
| hub | plain, one multi-draw per region and layer | 2.003 | 5.008 | 16 (vanilla 28) | 117492 | 24.092 / 0.324 | 1.879 / 12.0 | 3.137 | 3057 / 0 | None (None) |
| mam | plain, one multi-draw per region and layer | 2.003 | 4.007 | 16 (vanilla 28) | 1187136 | 24.563 / 0.352 | 20.207 / 32.0 | 31.7 | 3706 / 0 | None (None) |
| ponder | plain, one multi-draw per region and layer | 1.002 | 1.002 | 16 (vanilla 28) | 1015948 | 24.563 / 0.352 | 17.505 / 32.0 | 27.129 | 3707 / 0 | None (None) |
| hologram | plain, one multi-draw per region and layer | 2.003 | 10.017 | 16 (vanilla 28) | 13744 | 24.399 / 0.347 | 0.238 / 32.0 | 0.367 | 3765 / 0 | None (None) |
| create_ct | plain, one multi-draw per region and layer | 3.005 | 14.023 | 16 (vanilla 28) | 10608 | 24.011 / 0.342 | 0.171 / 32.0 | 0.283 | 3862 / 0 | None (None) |
| kinetics | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 23356 | 23.969 / 0.358 | 0.372 / 32.0 | 0.624 | 3975 / 0 | None (None) |
| kinetics_instancing | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 61144 | 6.102 / 0.31 | 0.963 / 8.0 | 1.633 | 169 / 0 | None (None) |

Translucency, siftec old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| factory | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| factory_flat | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| sift | 6.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2268 / 0 / 0 |
| hub | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 596 / 0 / 0 |
| mam | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| ponder | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| hologram | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2388 / 0 / 0 |
| create_ct | 1.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 601 / 0 / 0 |
| kinetics | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| kinetics_instancing | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, siftec old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| factory | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.023; 0) | 0 | 0 / 0 / 0 / 0 |
| factory_flat | 69.0 | 1.0 (0.0, 0.0) | 45.0 (0.0, 0.0) | 0.005 (0.037; 0) | 0 | 0 / 0 / 0 / 0 |
| sift | 244.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| hub | 38.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| mam | 55.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.001 (0.018; 0) | 0 | 0 / 0 / 0 / 0 |
| ponder | 1.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| hologram | 9.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| create_ct | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.005 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |
| kinetics_instancing | 23.0 | 3.0 (0.0, 0.0) | 24.0 (0.0, 0.0) | 0.004 (0.021; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), siftec old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| factory | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6216 / 0 |
| factory_flat | two-phase | 27.0 / 69.0 (60.9) | 27.0 / 42.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 6300 / 0 |
| sift | two-phase | 175.0 / 244.0 (28.3) | 175.0 / 69.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 6555 / 0 |
| hub | two-phase | 4.0 / 38.0 (89.5) | 4.0 / 34.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 5066 / 0 |
| mam | two-phase | 3.0 / 55.0 (94.5) | 3.0 / 52.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7800 / 0 |
| ponder | two-phase | 1.0 / 1.0 (0.0) | 1.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| hologram | two-phase | 6.0 / 9.0 (33.3) | 6.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 447 / 0 |
| create_ct | two-phase | 12.0 / 12.0 (0.0) | 12.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |
| kinetics | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 750 / 0 |
| kinetics_instancing | two-phase | 18.0 / 23.0 (21.7) | 18.0 / 5.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 745 / 0 |

Effects, siftec old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| factory | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.003 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| factory_flat | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.003 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| sift | - / 10.0 | - / 0.0 | - / 4.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.002 | 119 (2) | 28.0 / 2.0 / 26.0 | 0 / 0 | 4.0 |
| hub | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| mam | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| ponder | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| hologram | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 156.965 / 94.02 | 0.148 / 0.039 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 3.0 |
| create_ct | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 119 (2) | 28.0 / 0.0 / 28.0 | 0 / 0 | 2.0 |
| kinetics_instancing | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.002 / 0.001 | 119 (1) | 28.0 / 0.0 / 28.0 | 0 / 0 | 1.0 |

GUI pass, siftec old-gpu-2p (package 7, reported): draw calls/frame of the game's GUI pass (preparation: item atlas, picture-in-picture), elements, distinct states (fewest possible draws), draws if reordered without changing the picture (text counted as overlapping everything; in brackets as overlapping nothing, an upper bound); Quicksilver / vanilla (measure run):

| scene | GUI draws/frame | preparation draws/frame | elements/frame | states/frame | reordered draws/frame |
|---|---|---|---|---|---|
| factory | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| factory_flat | 5.0 / - | 0.0 / - | 21.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| sift | 5.0 / - | 0.0 / - | 20.0 / - | 3.0 / - (pipelines 3.0, textures 3.0, scissors 1.0) | 5.0 / - (3.0 / -) |
| hub | 13.87 / - | 0.0 / - | 574.43 / - | 6.0 / - (pipelines 6.0, textures 5.0, scissors 1.0) | 13.87 / - (8.0 / -) |
| mam | 13.86 / - | 1.0 / - | 112.85 / - | 7.0 / - (pipelines 6.0, textures 6.0, scissors 1.0) | 13.86 / - (8.0 / -) |
| ponder | 82.58 / - | 0.11 / - | 203.88 / - | 73.0 / - (pipelines 6.0, textures 72.0, scissors 1.0) | 81.61 / - (75.0 / -) |
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
| quicksilver-2p-old | flywheel:off, flywheel:off, flywheel:off | 0 | 0 / 599 |
| vanilla-old | flywheel:off, flywheel:off, flywheel:off | - | - / - |

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
| core-quicksilver-old | flat_plants | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | renderer_off | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | water_glass_oit | 3.6 | 3.6 (0) | 3.6 |  |
| core-quicksilver-old | translucent_move_oit | 3.73 | 3.73 (0) | 3.73 |  |
| core-quicksilver-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-2p-old | factory | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | sift | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | hub | 3.73 | 3.73 (0) | 3.73 |  |
| siftec-quicksilver-2p-old | mam | 7.73 | 7.73 (0) | 7.73 | between scenes +4.00 |
| siftec-quicksilver-2p-old | ponder | 7.73 | 7.73 (0) | 7.73 |  |
| siftec-quicksilver-2p-old | hologram | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-2p-old | create_ct | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-2p-old | kinetics | 7.54 | 7.54 (0) | 7.54 |  |
| siftec-quicksilver-2p-old | factory_flat | 5.48 | 5.48 (0) | 5.48 |  |
| siftec-quicksilver-2p-old | kinetics_instancing | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | factory | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | sift | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | hub | 4.24 | 4.24 (0) | 4.24 |  |
| siftec-quicksilver-old | mam | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| siftec-quicksilver-old | ponder | 8.24 | 8.24 (0) | 8.24 |  |
| siftec-quicksilver-old | hologram | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | create_ct | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | kinetics | 8.06 | 8.06 (0) | 8.06 |  |
| siftec-quicksilver-old | factory_flat | 3.48 | 3.48 (0) | 3.48 |  |
| siftec-quicksilver-old | kinetics_instancing | 5.48 | 5.48 (0) | 5.48 |  |

Rises of 4 MB or more: siftec-quicksilver-2p-old/mam: between scenes +4.00; siftec-quicksilver-old/mam: between scenes +4.00

