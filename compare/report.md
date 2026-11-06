# Quicksilver CI comparison

**FAILED**

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
- core/old-gpu/translucent_move: directBuffersMB rose from 3.73 to 8.24 (over 10%)
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
| spawn | 0.3016 | 10.05 | 0.2934 | 0.1915 |
| flythrough | 0.0 | 14.95 | 0.0011 | 0.0012 |
| water_glass | 0.0053 | 6.45 | 0.0044 | 0.0047 |
| nether | 0.0 | 0.8 | 0.019 | 0.0003 |
| mobs | 0.0 | 0.4 | 0.0 | 0.0 |
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
| translucent_move | 0.0003 | 0.3 | 0.0002 | 0.0002 |
| translucent_move.x2404 | 0.0003 | 0.3 | 0.0004 | 0.0003 |
| translucent_move.x2414 | 0.0 | 0.3 | 0.0003 | 0.0002 |
| translucent_move.x2424 | 0.0 | 0.3 | 0.0001 | 0.0002 |
| translucent_move.low | 0.0002 | 0.3 | 0.0011 | 0.0011 |
| translucent_move.back | 0.0002 | 0.3 | 0.0001 | 0.0001 |
| translucent_move.bare_back | 0.0003 | 0.3 | 0.0 | 0.0001 |
| water_glass_oit | 0.0035 | 0.3 | 0.0038 | 0.0049 |
| translucent_move_oit | 0.0002 | 0.3 | 0.0001 | 0.0 |
| translucent_move_oit.x2404 | 0.0004 | 0.3 | 0.0003 | 0.0002 |
| translucent_move_oit.x2414 | 0.0002 | 0.3 | 0.0004 | 0.0002 |
| translucent_move_oit.x2424 | 0.0 | 0.3 | 0.0001 | 0.0001 |
| translucent_move_oit.low | 0.001 | 0.3 | 0.0017 | 0.0015 |
| translucent_move_oit.back | 0.0001 | 0.3 | 0.0002 | 0.0 |
| translucent_move_oit.bare_back | 0.0 | 0.3 | 0.0001 | 0.0 |
| flat_plants | 0.0 | 0.3 | 0.023 | 0.023 |
| renderer_off | 0.0 | 0.25 | 0.0 | 0.0 |
| particles | 0.0 | 0.25 | 0.0 | 0.0 |
| particles.bare | 0.0 | 0.25 | 0.0 | 0.0 |
| animation | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animation.behind | 0.0 | 0.25 | 0.0 | 0.0 |
| animation.front | 0.0 | 0.25 | 0.0001 | 0.0001 |
| animated_items | 0.0 | 0.25 | 0.0 | 0.0 |
| block_entities | 0.6351 | None | 0.6318 | 0.6305 |
| block_entities.chest_open | 0.6293 | None | 0.6267 | 0.6262 |
| block_entities.sign_edit | 0.6377 | None | 0.629 | 0.6337 |
| block_entities.closed | 0.6294 | None | 0.6345 | 0.6255 |

Strict picture: pixels where both vanilla runs agree exactly but the Quicksilver run differs by more than 2/255 (in brackets: differs at all, reported only):

| scene | vanilla runs agree on % of pixels | strict limit (pixels) | old-GPU | old-GPU two-phase |
|---|---|---|---|---|
| spawn | 99.61 | 18057 | 437 (1107) | 1650 (2289) |
| flythrough | 100.0 | 6020 | 56 (328) | 57 (329) |
| water_glass | 99.99 | 25508 | 20 (3503) | 21 (3504) |
| nether | 100.0 | 905 | 176 (637) | 3 (464) |
| mobs | 100.0 | 10 | 0 (0) | 0 (0) |
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
| translucent_move | 100.0 | 13 | 2 (124) | 1 (123) |
| translucent_move.x2404 | 100.0 | 15 | 6 (175) | 4 (173) |
| translucent_move.x2414 | 100.0 | 13 | 5 (165) | 4 (164) |
| translucent_move.x2424 | 100.0 | 13 | 3 (122) | 3 (123) |
| translucent_move.low | 100.0 | 41 | 16 (22) | 15 (22) |
| translucent_move.back | 100.0 | 13 | 2 (124) | 1 (123) |
| translucent_move.bare_back | 100.0 | 13 | 1 (123) | 3 (125) |
| water_glass_oit | 100.0 | 57 | 20 (3503) | 30 (3517) |
| translucent_move_oit | 100.0 | 12 | 2 (124) | 3 (125) |
| translucent_move_oit.x2404 | 100.0 | 16 | 4 (175) | 3 (172) |
| translucent_move_oit.x2414 | 100.0 | 10 | 4 (164) | 2 (163) |
| translucent_move_oit.x2424 | 100.0 | 15 | 1 (120) | 1 (120) |
| translucent_move_oit.low | 100.0 | 40 | 19 (25) | 16 (22) |
| translucent_move_oit.back | 100.0 | 12 | 3 (125) | 3 (125) |
| translucent_move_oit.bare_back | 100.0 | 15 | 3 (125) | 1 (123) |
| flat_plants | 100.0 | 350 | 248 (8128) | 248 (8128) |
| renderer_off | 100.0 | 10 | 0 (0) | 0 (0) |
| particles | 100.0 | 4 | 0 (0) | 0 (0) |
| particles.bare | 100.0 | 4 | 0 (0) | 0 (0) |
| animation | 100.0 | 10 | 1 (3) | 1 (3) |
| animation.behind | 100.0 | 10 | 0 (2) | 0 (2) |
| animation.front | 100.0 | 10 | 1 (3) | 1 (3) |
| animated_items | 100.0 | 10 | 0 (0) | 0 (0) |
| block_entities | 99.36 | None | 34 (921) | 22 (909) |
| block_entities.chest_open | 99.37 | None | 19 (906) | 14 (901) |
| block_entities.sign_edit | 99.36 | None | 8 (899) | 51 (942) |
| block_entities.closed | 99.37 | None | 97 (988) | 14 (905) |

### Counts, core old-gpu

| scene | draw calls/frame (avg, or median where marked) | uploads/frame (median) | upload bytes/frame (median) | heap after GC MB | direct MB |
|---|---|---|---|---|---|
| spawn | 49.09 (base 49.0) | 12 (base 13) | 1380 (base 6372) | 253.95 (base 256.29) | 4.24 (base 3.73) |
| flythrough | 67.97 (reported, not gated) | 28 (reported, not gated) | 118676 (reported, not gated) | 310.05 (base 324.79) | 3.48 (base 5.99) |
| water_glass | 19.69 (base 20.0) | 13 (base 14) | 7000 (base 10264) | 238.3 (base 249.83) | 4.24 (base 5.99) |
| nether | 22.47 (base 33.79) | 10 (base 11) | 4284 (base 10656) | 259.99 (base 272.57) | 4.24 (base 5.99) |
| mobs | 25.67 (base 28.97) | 14 (base 16) | 610516 (base 1015892) | 258.41 (base 268.23) | 4.24 (base 5.99) |
| outline | 10.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.92 (base 264.41) | 4.24 (base 3.73) |
| occlusion | 18.71 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.88 (base 264.64) | 4.24 (base 4.24) |
| occlusion_move | 24.03 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 264.56 (base 265.66) | 4.24 (base 5.99) |
| occlusion_corner | 10.67 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 268.58 (base 267.41) | 4.24 (base 3.73) |
| translucent_move | 17.68 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 274.86 (base 268.19) | 8.24 (base 3.73) |
| water_glass_oit | 25.0 (base 25.0) | 13 (base 14) | 6868 (base 7604) | 237.33 (base 245.78) | 3.35 (base 3.73) |
| translucent_move_oit | 25.28 (reported, not gated) | 13 (reported, not gated) | 2724 (reported, not gated) | 239.94 (base 248.15) | 5.48 (base 3.73) |
| flat_plants | 9.67 (base 33.0) | 13 (base 13) | 1716 (base 1716) | 237.02 (base 248.11) | 3.21 (base 5.99) |
| renderer_off | 12.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.29 (base 240.73) | 3.35 (base 5.87) |
| particles | 10.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 266.44 (base 261.4) | 8.24 (base 4.24) |
| animation | 50 median (avg 40.02) (base 49) | 13 (base 13) | 1716 (base 1716) | 262.71 (base 260.68) | 8.24 (base 4.24) |
| animated_items | 60 median (avg 47.08) (base 60) | 21 (base 22) | 21508 (base 21668) | 237.26 (base 239.53) | 8.24 (base 5.99) |
| block_entities | 35.11 | 15 | 94472 | 236.62 | 8.24 |

Package 4b, core old-gpu: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 408727.925 (618542.766) | 33.921 | 1.78 | 485604 | 484224 (2097152.0) | 295 | 0.0 / 0 |
| flythrough | 570042.566 (913850.55) | 37.622 | 1.083 | 2106300 | 2096600 (2097152.0) | 251 | 6.04 / 69 |
| water_glass | 114226.672 (199458.534) | 42.732 | 1.133 | 147096 | 140096 (2097152.0) | 4 | 0.0 / 0 |
| nether | 36362.482 (54876.219) | 33.737 | 1.927 | 201848 | 196864 (2097151.513) | 146 | 0.0 / 0 |
| mobs | 62782.463 (112425.063) | 44.156 | 0.967 | 610516 | 0 (2097152.0) | 1 | 0.0 / 0 |
| outline | 1057.76 (2295.82) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 27390.912 (47794.037) | 42.69 | 1.301 | 215716 | 117568 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_move | 48572.083 (84993.085) | 42.852 | 1.236 | 672316 | 597248 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 27754.464 (60455.165) | 54.091 | 1.272 | 32932 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 199994.059 (355062.799) | 43.674 | 1.178 | 758020 | 755968 (2097152.0) | 2 | 0.0 / 0 |
| water_glass_oit | 113817.192 (198689.685) | 42.716 | 1.133 | 8548 | 0 (2097152.0) | 338 | 0.0 / 0 |
| translucent_move_oit | 199970.72 (354758.962) | 43.632 | 1.177 | 727380 | 722688 (2097152.0) | 289 | 0.0 / 0 |
| flat_plants | 9099.165 (12474.791) | 27.06 | 1.045 | 2164 | 0 (2097152.0) | 54 | 0.0 / 0 |
| renderer_off | 20762.604 (39369.616) | 47.262 | 1.0 | 1380 | 0 (2097152.0) | 1 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3044.114 (5227.753) | 41.77 | 1.087 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 2246.785 (4832.668) | 53.508 | 1.0 | 79236 | 57728 (2097152.0) | 0 | 0.0 / 0 |
| block_entities | 3461.77 (4439.399) | 22.022 | 1.6 | 135168 | 41472 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 2.016 (121) | 2.02 (66) | 0 | 886 / 0 | 5.011 / 7.127 | 2.008 / 3.172 |
| flythrough | 3.39 (1705) | 3.39 (1705) | 0 | 1396 / 0 | 3.796 / 5.328 | 2.195 / 3.331 |
| water_glass | 1.129 (20) | 2.803 (1) | 0 | 1204 / 0 | 4.547 / 6.35 | 1.894 / 2.865 |
| nether | 1.682 (31) | 1.863 (7) | 0 | 1825 / 0 | 3.705 / 5.125 | 1.541 / 2.257 |
| mobs | 0.549 (6) | None (0) | 0 | 2065 / 0 | 3.591 / 4.998 | 1.523 / 2.224 |
| outline | 0.329 (12) | None (0) | 0 | 2123 / 0 | 3.539 / 4.916 | 1.509 / 2.192 |
| occlusion | 0.591 (52) | 1.279 (4) | 0 | 2263 / 0 | 3.431 / 4.789 | 1.468 / 2.129 |
| occlusion_move | 0.904 (62) | 2.126 (16) | 0 | 2417 / 0 | 3.281 / 4.582 | 1.413 / 2.049 |
| occlusion_corner | 0.752 (97) | 0.732 (1) | 0 | 2697 / 0 | 3.038 / 4.229 | 1.236 / 1.823 |
| translucent_move | 1.809 (131) | 3.519 (35) | 0 | 3059 / 0 | 2.947 / 4.147 | 1.269 / 1.889 |
| water_glass_oit | 2.226 (158) | None (0) | 0 | 414 / 0 | 5.233 / 6.665 | 2.236 / 3.289 |
| translucent_move_oit | 2.232 (220) | 3.182 (25) | 0 | 970 / 0 | 3.408 / 4.53 | 1.458 / 2.129 |
| flat_plants | 1.09 (99) | None (0) | 0 | 400 / 0 | 3.945 / 5.39 | 1.447 / 2.127 |
| renderer_off | 0.435 (26) | None (0) | 0 | 321 / 0 | 4.222 / 5.614 | 1.382 / 2.056 |
| particles | 0.258 (30) | None (0) | 0 | 3086 / 0 | 2.924 / 4.114 | 1.26 / 1.868 |
| animation | 0.706 (18) | 0.886 (4) | 0 | 3161 / 0 | 2.867 / 4.032 | 1.232 / 1.791 |
| animated_items | 0.22 (42) | 0.853 (2) | 0 | 3193 / 0 | 2.844 / 3.995 | 1.212 / 1.76 |
| block_entities | 0.58 (83) | 1.027 (1) | 0 | 3275 / 0 | 2.788 / 3.912 | 1.181 / 1.703 |

Terrain module, core old-gpu (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.132 | 695.956 | 16 (vanilla 28) | 1359776 | 42.309 / 0.079 | 22.521 / 36.0 | 36.31 | 2451 / 0 | 2.02 (4.227) |
| flythrough | plain, one multi-draw per region and layer | 58.084 | 939.474 | 16 (vanilla 28) | 5229288 | 15.124 / 1.018 | 86.425 / 112.0 | 139.637 | 6634 / 0 | 3.39 (10.53) |
| water_glass | plain, one multi-draw per region and layer | 14.024 | 106.055 | 16 (vanilla 28) | 780956 | 34.238 / 0.075 | 12.617 / 36.0 | 20.854 | 3120 / 0 | 2.803 (2.791) |
| nether | plain, one multi-draw per region and layer | 12.25 | 55.285 | 16 (vanilla 28) | 955824 | 28.666 / 0.167 | 15.21 / 20.0 | 25.523 | 4166 / 0 | 1.863 (2.521) |
| mobs | plain, one multi-draw per region and layer | 8.013 | 60.1 | 16 (vanilla 28) | 606220 | 25.971 / 0.146 | 9.727 / 16.0 | 16.188 | 4626 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77496 | 25.576 / 0.145 | 1.225 / 16.0 | 2.069 | 4719 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.05 | 43.352 | 16 (vanilla 28) | 153320 | 24.422 / 0.138 | 2.46 / 20.0 | 4.094 | 4988 / 0 | 1.279 (1.589) |
| occlusion_move | plain, one multi-draw per region and layer | 10.983 | 76.279 | 16 (vanilla 28) | 205688 | 23.163 / 0.131 | 3.302 / 20.0 | 5.492 | 5281 / 0 | 2.126 (5.662) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.01 | 81.91 | 16 (vanilla 28) | 122728 | 21.93 / 0.124 | 1.931 / 20.0 | 3.277 | 5657 / 0 | 0.732 (0.729) |
| translucent_move | plain, one multi-draw per region and layer | 11.993 | 248.859 | 16 (vanilla 28) | 797156 | 19.09 / 0.116 | 12.939 / 28.0 | 21.286 | 6517 / 0 | 3.519 (11.401) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.046 | 113.324 | 16 (vanilla 28) | 780956 | 7.541 / 0.043 | 12.617 / 20.0 | 20.854 | 1099 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 16.304 | 263.211 | 16 (vanilla 28) | 771316 | 6.718 / 0.11 | 12.528 / 28.0 | 20.596 | 2446 / 0 | 3.182 (7.085) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.037 | 16 (vanilla 28) | 878792 | 6.52 / 0.01 | 14.109 / 24.0 | 23.466 | 959 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 540900 | 2.433 / 0.021 | 8.61 / 24.0 | 14.444 | 603 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 19.048 / 0.116 | 0.131 / 28.0 | 0.225 | 6559 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.519 | 16 (vanilla 28) | 19416 | 18.899 / 0.115 | 0.302 / 28.0 | 0.518 | 6661 / 0 | 0.886 (1.259) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 12.701 | 16 (vanilla 28) | 9764 | 18.847 / 0.115 | 0.153 / 28.0 | 0.261 | 6711 / 0 | 0.853 (1.271) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 18.551 / 0.113 | 0.143 / 28.0 | 0.237 | 6870 / 0 | 1.027 (1.027) |

Translucency, core old-gpu (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 152.203 | 17.0 | 0.0 | 0 | 0 | 50 (0.018 / 0.026 / 0.028; 0) | 0 | 45052 / 0 / 0 |
| flythrough | 197.857 | 26.944 | 0.0 | 0 | 0 | 914 (0.02 / 0.032 / 6.041; 0) | 61 | 49860 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2324 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1200 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.031 / 0.033 / 0.684; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.068 / 0.102 / 0.114; 0) | 180 | 4039 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 1050 | 0 (None / None / None; 0) | 0 | 1400 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 870 | 0 (None / None / None; 0) | 0 | 2030 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2400 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 342.213 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.028 (0.088; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 445.087 | 1.0 (0.0, 0.0) | 1.563 (0.0, 0.0) | 0.001 (0.019; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.014 (0.086; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.099 (0.538; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.007; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.056 (0.202; 0) | 0 | 3600 / 1629600 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.375) | 6.0 (6.0, 2.285) | 0.044 (0.198; 0) | 0 | 2796 / 1515040 / 0 / 0 |
| occlusion_corner | 81.86 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 136.224 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 136.452 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.02; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.593 (0.0, 0.0) | 0.001 (0.003; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.01 (0.03; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.031 (0.062; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | still | 289.65 / 340.2 (14.9) | 289.65 / 0.0 / 0.0 | 0.09 | 0.0 (0.0, 0.0; 0.0) | 1313.51 | 3703 / 0 |
| flythrough | still | 422.52 / 423.02 (0.1) | 422.52 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| water_glass | still | 53.45 / 140.0 (61.8) | 53.45 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.78 | 12528 / 0 |
| nether | still | 44.5 / 299.0 (85.1) | 44.5 / 0.0 / 0.0 | 0.01 | 0.0 (0.0, 0.0; 0.0) | 121.21 | 37466 / 0 |
| mobs | still | 32.0 / 107.0 (70.1) | 32.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 11250 / 0 |
| outline | still | 6.0 / 28.0 (78.6) | 6.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 3300 / 0 |
| occlusion | still | 26.23 / 49.0 (46.5) | 26.23 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 48.0 | 3404 / 0 |
| occlusion_move | still | 51.13 / 51.31 (0.4) | 51.13 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| occlusion_corner | still | 81.72 / 81.85 (0.2) | 81.72 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| translucent_move | still | 135.54 / 136.1 (0.4) | 135.54 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 109 / 0 |
| water_glass_oit | still | 53.0 / 140.0 (62.1) | 53.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 7656 / 0 |
| translucent_move_oit | still | 135.21 / 135.96 (0.6) | 135.21 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 0 / 0 |
| flat_plants | still | 9.0 / 151.0 (94.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 21300 / 0 |
| renderer_off | still | 11.0 / 112.0 (90.2) | 11.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 15150 / 0 |
| particles | still | 8.0 / 12.0 (33.3) | 8.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 0.0 | 596 / 0 |
| animation | still | 10.5 / 13.0 (19.2) | 10.5 / 0.0 / 0.0 | 0.08 | 0.0 (0.0, 0.0; 0.0) | 1176.0 | 441 / 0 |
| animated_items | still | 12.67 / 13.0 (2.5) | 12.67 / 0.0 / 0.0 | 0.31 | 0.0 (0.0, 0.0; 0.0) | 4512.0 | 48 / 0 |
| block_entities | still | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 0.0 | 0.0 (0.0, 0.0; 0.0) | 24.0 | 0 / 0 |

Effects, core old-gpu (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 85.255 / 0.0 | 0.027 / 0.005 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.379 / 0.0 | 0.006 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.869 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 51.653 / 51.659 | 0.013 / 0.022 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 6.712 | - / 0.85 | - / 0.0 | - / 0.0 | - / 0.0 | 34.638 / 7.274 | 0.05 / 0.009 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.438 / 11.369 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 49.125 / 49.094 | 0.017 / 0.018 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 11.518 / 11.372 | 0.008 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 3.048 / 2.855 | 0.015 / 0.01 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.005 / 0.002 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.004 / 0.05 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.27 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.798 | 0.004 / 0.008 | 56 (3) | 40.58 / 9.24 / 31.34 | 3 / 0 | 10.985 |
| animated_items | - / 28.104 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.608 / 7.99 / 32.618 | 0 / 0 | 9.0 |
| block_entities | - / 13.322 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 10.563 / 10.543 | 0.002 / 0.007 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| spawn | 50.73 (base 49.0) | 13 (base 13) | 1492 (base 6372) | 252.63 (base 256.29) | 3.99 (base 3.73) |
| flythrough | 68.92 (reported, not gated) | 32 (reported, not gated) | 233132 (reported, not gated) | 310.15 (base 324.79) | 3.73 (base 5.99) |
| water_glass | 20.79 (base 20.0) | 13 (base 14) | 7316 (base 10264) | 237.89 (base 249.83) | 3.99 (base 5.99) |
| nether | 24.0 (base 33.79) | 10 (base 11) | 3976 (base 10656) | 258.74 (base 272.57) | 3.99 (base 5.99) |
| mobs | 26.69 (base 28.97) | 15 (base 16) | 610676 (base 1015892) | 258.66 (base 268.23) | 5.99 (base 5.99) |
| outline | 11.67 (base 19.67) | 16 (base 16) | 5012 (base 5012) | 257.47 (base 264.41) | 5.99 (base 3.73) |
| occlusion | 19.67 (base 22.67) | 13 (base 14) | 98148 (base 124172) | 263.38 (base 264.64) | 5.99 (base 4.24) |
| occlusion_move | 20.09 (reported, not gated) | 13 (reported, not gated) | 79984 (reported, not gated) | 263.84 (base 265.66) | 5.99 (base 5.99) |
| occlusion_corner | 11.82 (reported, not gated) | 12 (reported, not gated) | 1380 (reported, not gated) | 267.92 (base 267.41) | 5.99 (base 3.73) |
| translucent_move | 11.13 (reported, not gated) | 13 (reported, not gated) | 2856 (reported, not gated) | 274.42 (base 268.19) | 5.99 (base 3.73) |
| water_glass_oit | 26.0 (base 25.0) | 13 (base 14) | 7652 (base 7604) | 237.13 (base 245.78) | 3.6 (base 3.73) |
| translucent_move_oit | 18.42 (reported, not gated) | 13 (reported, not gated) | 2948 (reported, not gated) | 239.86 (base 248.15) | 3.73 (base 3.73) |
| flat_plants | 10.52 (base 33.0) | 13 (base 13) | 1492 (base 1716) | 237.88 (base 248.11) | 3.09 (base 5.99) |
| renderer_off | 13.67 (base 17.77) | 12 (base 12) | 1380 (base 1380) | 233.32 (base 240.73) | 3.6 (base 5.87) |
| particles | 11.67 (base 10.72) | 13 (base 13) | 8772 (base 16164) | 265.48 (base 261.4) | 5.99 (base 4.24) |
| animation | 50 median (avg 40.95) (base 49) | 13 (base 13) | 1716 (base 1716) | 261.84 (base 260.68) | 5.99 (base 4.24) |
| animated_items | 61 median (avg 47.73) (base 60) | 22 (base 22) | 21668 (base 21668) | 236.67 (base 239.53) | 5.99 (base 5.99) |
| block_entities | 36.11 | 15 | 94496 | 235.98 | 5.99 |

Package 4b, core old-gpu-2p: Quicksilver's terrain triangles per frame (with every face, as before 4b), and the largest upload bytes in one frame (all of the frame's uploads), frames over 50 ms and sections waiting:

| scene | triangles/frame (every face) | left out % | ranges per section layer | largest upload bytes in one frame: Quicksilver | Quicksilver terrain bytes, largest frame (budget avg) | frames over 50 ms: Quicksilver | sections waiting avg / max |
|---|---|---|---|---|---|---|---|
| spawn | 394149.276 (591721.24) | 33.389 | 1.776 | 807908 | 806528 (2097152.0) | 221 | 0.0 / 0 |
| flythrough | 494342.466 (779274.952) | 36.564 | 1.084 | 2105724 | 2096024 (2097152.0) | 189 | 5.858 / 63 |
| water_glass | 113717.183 (198515.099) | 42.716 | 1.133 | 147636 | 140096 (2097152.0) | 21 | 0.0 / 0 |
| nether | 29500.842 (42399.695) | 30.422 | 2.0 | 228220 | 223936 (2097152.0) | 130 | 0.0 / 0 |
| mobs | 62786.066 (112431.514) | 44.156 | 0.967 | 610676 | 0 (2097152.0) | 2 | 0.0 / 0 |
| outline | 1057.763 (2295.826) | 53.927 | 1.0 | 5012 | 0 (2097152.0) | 0 | 0.0 / 0 |
| occlusion | 29340.82 (51694.013) | 43.241 | 1.279 | 98148 | 0 (2097152.0) | 1 | 0.0 / 0 |
| occlusion_move | 22287.703 (39255.786) | 43.224 | 1.261 | 648416 | 573440 (2097152.0) | 0 | 0.0 / 0 |
| occlusion_corner | 21834.523 (47204.06) | 53.744 | 1.215 | 32840 | 31552 (2097152.0) | 0 | 0.0 / 0 |
| translucent_move | 21604.444 (27632.78) | 21.816 | 1.005 | 759140 | 755968 (2097152.0) | 133 | 0.0 / 0 |
| water_glass_oit | 113947.791 (198917.671) | 42.716 | 1.133 | 9556 | 0 (2097152.0) | 249 | 0.0 / 0 |
| translucent_move_oit | 21717.027 (27814.792) | 21.923 | 1.005 | 727044 | 722688 (2097152.0) | 255 | 0.0 / 0 |
| flat_plants | 9100.546 (12476.685) | 27.06 | 1.045 | 1828 | 0 (2097152.0) | 137 | 0.0 / 0 |
| renderer_off | 20762.547 (39369.507) | 47.262 | 1.0 | 1380 | 0 (2097152.0) | 3 | 0.0 / 0 |
| particles | 1698.831 (3676.127) | 53.787 | 1.0 | 8772 | 0 (2097152.0) | 0 | 0.0 / 0 |
| animation | 3009.396 (5146.958) | 41.531 | 1.091 | 86324 | 84608 (2097152.0) | 0 | 0.0 / 0 |
| animated_items | 1803.005 (3812.354) | 52.706 | 1.0 | 79396 | 57728 (2097152.0) | 0 | 0.0 / 0 |
| block_entities | 3461.77 (4439.399) | 22.022 | 1.6 | 136060 | 41472 (2097152.0) | 0 | 0.0 / 0 |

Package 4c, core old-gpu-2p: meshing ms per section over each bench (sections in brackets):

| scene | Quicksilver ms/section (sections) | while measuring: Quicksilver ms/section (sections) | to vanilla's compiler this bench | checked / mismatched since start-up | same sections, same thread: Quicksilver / vanilla's compiler ms (mean) | median (gated) |
|---|---|---|---|---|---|---|
| spawn | 3.192 (147) | 3.125 (79) | 0 | 878 / 0 | 6.737 / 9.652 | 3.028 / 5.102 |
| flythrough | 4.083 (1653) | 4.083 (1651) | 0 | 1400 / 0 | 4.874 / 7.248 | 3.045 / 4.947 |
| water_glass | 2.649 (21) | 2.635 (1) | 0 | 1193 / 0 | 6.109 / 8.596 | 2.793 / 4.608 |
| nether | 2.134 (28) | 1.974 (12) | 0 | 1805 / 0 | 4.881 / 6.878 | 2.174 / 3.221 |
| mobs | 1.191 (7) | None (0) | 0 | 2043 / 0 | 4.765 / 6.673 | 2.142 / 3.143 |
| outline | 0.326 (12) | None (0) | 0 | 2101 / 0 | 4.702 / 6.564 | 2.114 / 3.1 |
| occlusion | 0.84 (47) | None (0) | 0 | 2237 / 0 | 4.559 / 6.334 | 2.077 / 2.978 |
| occlusion_move | 1.758 (66) | 3.857 (18) | 0 | 2406 / 0 | 4.363 / 6.055 | 1.999 / 2.891 |
| occlusion_corner | 1.07 (82) | 1.162 (1) | 0 | 2686 / 0 | 4.055 / 5.595 | 1.78 / 2.536 |
| translucent_move | 2.196 (116) | 3.785 (34) | 0 | 3061 / 0 | 3.974 / 5.51 | 1.866 / 2.625 |
| water_glass_oit | 2.889 (155) | None (0) | 0 | 415 / 0 | 6.023 / 7.424 | 3.057 / 4.009 |
| translucent_move_oit | 3.296 (219) | 4.864 (25) | 0 | 968 / 0 | 4.246 / 5.45 | 2.191 / 3.024 |
| flat_plants | 1.229 (102) | None (0) | 0 | 401 / 0 | 5.006 / 6.381 | 1.975 / 2.436 |
| renderer_off | 0.479 (25) | None (0) | 0 | 323 / 0 | 6.127 / 8.3 | 2.347 / 3.199 |
| particles | 0.291 (30) | None (0) | 0 | 3091 / 0 | 3.942 / 5.464 | 1.831 / 2.606 |
| animation | 0.747 (18) | 1.005 (4) | 0 | 3166 / 0 | 3.863 / 5.354 | 1.767 / 2.514 |
| animated_items | 0.263 (38) | 0.615 (2) | 0 | 3198 / 0 | 3.83 / 5.305 | 1.738 / 2.479 |
| block_entities | 0.747 (81) | 1.385 (1) | 0 | 3280 / 0 | 3.753 / 5.193 | 1.68 / 2.371 |

Terrain module, core old-gpu-2p (reported, not gated):

| scene | path | Quicksilver draws/frame | section layers/frame | bytes per vertex | live vertices | % vertices with a position / UV rounded | arena MB used / allocated | vanilla format would need MB | layers taken / kept by vanilla | meshing ms/section (vanilla mesher p95) |
|---|---|---|---|---|---|---|---|---|---|---|
| spawn | plain, one multi-draw per region and layer | 39.176 | 657.964 | 16 (vanilla 28) | 1365180 | 41.249 / 0.099 | 22.625 / 36.0 | 36.454 | 2472 / 0 | 3.125 (7.155) |
| flythrough | plain, one multi-draw per region and layer | 58.116 | 778.979 | 16 (vanilla 28) | 5242124 | 15.036 / 0.987 | 86.649 / 112.0 | 139.98 | 6545 / 0 | 4.083 (12.14) |
| water_glass | plain, one multi-draw per region and layer | 14.028 | 105.208 | 16 (vanilla 28) | 780956 | 33.519 / 0.086 | 12.617 / 36.0 | 20.854 | 3136 / 0 | 2.635 (2.623) |
| nether | plain, one multi-draw per region and layer | 12.023 | 43.083 | 16 (vanilla 28) | 955696 | 28.329 / 0.171 | 15.205 / 20.0 | 25.52 | 4157 / 0 | 1.974 (2.947) |
| mobs | plain, one multi-draw per region and layer | 8.014 | 60.103 | 16 (vanilla 28) | 606220 | 25.721 / 0.156 | 9.727 / 16.0 | 16.188 | 4615 / 0 | None (None) |
| outline | plain, one multi-draw per region and layer | 2.003 | 6.01 | 16 (vanilla 28) | 77496 | 25.334 / 0.155 | 1.225 / 16.0 | 2.069 | 4708 / 0 | None (None) |
| occlusion | plain, one multi-draw per region and layer | 6.01 | 43.072 | 16 (vanilla 28) | 162556 | 24.062 / 0.147 | 2.599 / 20.0 | 4.341 | 4957 / 0 | None (None) |
| occlusion_move | plain, one multi-draw per region and layer | 6.037 | 33.826 | 16 (vanilla 28) | 213428 | 22.445 / 0.137 | 3.406 / 20.0 | 5.699 | 5292 / 0 | 3.857 (11.279) |
| occlusion_corner | plain, one multi-draw per region and layer | 6.068 | 60.885 | 16 (vanilla 28) | 122728 | 21.33 / 0.13 | 1.931 / 20.0 | 3.277 | 5653 / 0 | 1.162 (1.158) |
| translucent_move | plain, one multi-draw per region and layer | 4.399 | 23.088 | 16 (vanilla 28) | 801612 | 18.371 / 0.118 | 12.982 / 28.0 | 21.405 | 6530 / 0 | 3.785 (10.862) |
| water_glass_oit | plain, one multi-draw per region and layer | 16.064 | 113.454 | 16 (vanilla 28) | 780956 | 7.476 / 0.039 | 12.617 / 20.0 | 20.854 | 1095 / 0 | None (None) |
| translucent_move_oit | plain, one multi-draw per region and layer | 8.455 | 37.243 | 16 (vanilla 28) | 775764 | 6.69 / 0.108 | 12.571 / 28.0 | 20.715 | 2434 / 0 | 4.864 (14.248) |
| flat_plants | plain, one multi-draw per region and layer | 4.007 | 22.04 | 16 (vanilla 28) | 876572 | 6.39 / 0.01 | 14.068 / 24.0 | 23.407 | 956 / 0 | None (None) |
| renderer_off | plain, one multi-draw per region and layer | 8.013 | 22.037 | 16 (vanilla 28) | 540900 | 2.407 / 0.021 | 8.61 / 24.0 | 14.444 | 605 / 0 | None (None) |
| particles | plain, one multi-draw per region and layer | 2.003 | 8.013 | 16 (vanilla 28) | 8416 | 18.317 / 0.118 | 0.131 / 28.0 | 0.225 | 6578 / 0 | None (None) |
| animation | plain, one multi-draw per region and layer | 2.003 | 11.018 | 16 (vanilla 28) | 19416 | 18.179 / 0.117 | 0.302 / 28.0 | 0.518 | 6680 / 0 | 1.005 (1.45) |
| animated_items | plain, one multi-draw per region and layer | 1.002 | 7.012 | 16 (vanilla 28) | 9764 | 18.135 / 0.117 | 0.153 / 28.0 | 0.261 | 6727 / 0 | 0.615 (0.935) |
| block_entities | plain, one multi-draw per region and layer | 3.005 | 10.017 | 16 (vanilla 28) | 8864 | 17.863 / 0.115 | 0.142 / 28.0 | 0.237 | 6884 / 0 | 1.385 (1.383) |

Translucency, core old-gpu-2p (package 3; the check, mixed frames and dry run gated above):

| scene | Quicksilver's translucent section layers/frame | its draws/frame | vanilla's own layers/frame | mixed frames | OIT stage draws | sorts (ms avg / p95 / max; on render thread) | new index lists uploaded | check: entries / unchecked / misses |
|---|---|---|---|---|---|---|---|---|
| spawn | 155.0 | 17.0 | 0.0 | 0 | 0 | 62 (0.02 / 0.033 / 0.041; 0) | 0 | 34410 / 0 / 0 |
| flythrough | 194.505 | 26.426 | 0.0 | 0 | 0 | 878 (0.024 / 0.034 / 6.968; 0) | 59 | 36956 / 0 / 0 |
| water_glass | 4.0 | 1.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2020 / 0 / 0 |
| nether | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| mobs | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| outline | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| occlusion | 2.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 1202 / 0 / 0 |
| occlusion_move | 2.0 | 2.0 | 0.0 | 0 | 0 | 36 (0.1 / 1.596 / 1.596; 0) | 32 | 1200 / 0 / 0 |
| occlusion_corner | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| translucent_move | 7.0 | 2.0 | 0.0 | 0 | 0 | 180 (0.097 / 0.127 / 2.523; 0) | 180 | 3759 / 0 / 0 |
| water_glass_oit | 4.0 | 3.0 | 0.0 | 0 | 750 | 0 (None / None / None; 0) | 0 | 1000 / 0 / 0 |
| translucent_move_oit | 7.0 | 6.0 | 0.0 | 0 | 768 | 0 (None / None / None; 0) | 0 | 1792 / 0 / 0 |
| flat_plants | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2200 / 0 / 0 |
| renderer_off | 4.0 | 2.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 2404 / 0 / 0 |
| particles | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animation | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| animated_items | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |
| block_entities | 0.0 | 0.0 | 0.0 | 0 | 0 | 0 (None / None / None; 0) | 0 | 0 / 0 / 0 |

Visibility, core old-gpu-2p (reported; pop-in and fallbacks gated above):

| scene | sections visible/frame | entities/frame (tested, hidden) | block entities/frame (tested, hidden) | cull ms/frame (max; frames over budget) | section layers missing | ray check: objects / rays / violations / unchecked |
|---|---|---|---|---|---|---|
| spawn | 345.0 | 1.0 (0.0, 0.0) | 11.0 (1.0, 0.0) | 0.03 (0.316; 0) | 0 | 0 / 0 / 0 / 0 |
| flythrough | 442.732 | 1.0 (0.0, 0.0) | 1.574 (0.0, 0.0) | 0.002 (0.087; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| nether | 299.0 | 1.0 (0.0, 0.0) | 1.0 (1.0, 0.0) | 0.012 (0.038; 0) | 0 | 0 / 0 / 0 / 0 |
| mobs | 107.0 | 65.0 (64.0, 0.0) | 0.0 (0.0, 0.0) | 0.117 (0.22; 0) | 0 | 0 / 0 / 0 / 0 |
| outline | 28.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| occlusion | 49.0 | 11.0 (10.0, 2.0) | 9.0 (9.0, 4.0) | 0.063 (0.126; 0) | 0 | 3606 / 1632316 / 0 / 0 |
| occlusion_move | 51.36 | 10.0 (9.0, 2.357) | 6.0 (6.0, 2.278) | 0.055 (0.212; 0) | 0 | 2781 / 1505094 / 0 / 0 |
| occlusion_corner | 81.865 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move | 135.225 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.015; 0) | 0 | 0 / 0 / 0 / 0 |
| water_glass_oit | 140.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| translucent_move_oit | 135.785 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.001 (0.001; 0) | 0 | 0 / 0 / 0 / 0 |
| flat_plants | 151.0 | 1.0 (0.0, 0.0) | 1.0 (0.0, 0.0) | 0.002 (0.029; 0) | 0 | 0 / 0 / 0 / 0 |
| renderer_off | 112.0 | 2.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| particles | 12.0 | 1.0 (0.0, 0.0) | 0.0 (0.0, 0.0) | 0.0 (0.002; 0) | 0 | 0 / 0 / 0 / 0 |
| animation | 13.0 | 1.0 (0.0, 0.0) | 2.595 (0.0, 0.0) | 0.001 (0.016; 0) | 0 | 0 / 0 / 0 / 0 |
| animated_items | 13.0 | 4.0 (1.0, 0.0) | 0.0 (0.0, 0.0) | 0.008 (0.025; 0) | 0 | 0 / 0 / 0 / 0 |
| block_entities | 9.0 | 1.0 (0.0, 0.0) | 36.0 (31.0, 0.0) | 0.041 (0.115; 0) | 0 | 0 / 0 / 0 / 0 |

Occlusion (package 2b), core old-gpu-2p (reported; mode, check, fallbacks and draw calls gated above):

| scene | mode | sections drawn / without culling per frame (culled %) | first pass / tested late / revealed | pyramids/frame | wait ms/frame (when waiting, max; % frames) | readback bytes/frame | check: culled sections / visible pixels |
|---|---|---|---|---|---|---|---|
| spawn | two-phase | 267.0 / 343.0 (22.2) | 267.0 / 76.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 4180 / 0 |
| flythrough | two-phase | 324.28 / 417.23 (22.3) | 319.04 / 98.19 / 5.25 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4361 / 0 |
| water_glass | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10962 / 0 |
| nether | two-phase | 37.0 / 299.0 (87.6) | 37.0 / 262.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 34060 / 0 |
| mobs | two-phase | 32.0 / 107.0 (70.1) | 32.0 / 75.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 10875 / 0 |
| outline | two-phase | 6.0 / 28.0 (78.6) | 6.0 / 22.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 3300 / 0 |
| occlusion | two-phase | 26.0 / 49.0 (46.9) | 26.0 / 23.0 / 0.0 | 1.0 | 0.0 (0.0, 0.02; 100.0) | 14400.0 | 3450 / 0 |
| occlusion_move | two-phase | 22.37 / 51.31 (56.4) | 22.32 / 28.99 / 0.05 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 4301 / 0 |
| occlusion_corner | two-phase | 60.76 / 81.86 (25.8) | 60.68 / 21.17 / 0.08 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 3163 / 0 |
| translucent_move | two-phase | 15.66 / 135.09 (88.4) | 15.64 / 119.45 / 0.02 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 16004 / 0 |
| water_glass_oit | two-phase | 53.0 / 140.0 (62.1) | 53.0 / 87.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 5394 / 0 |
| translucent_move_oit | two-phase | 15.67 / 135.27 (88.4) | 15.63 / 119.64 / 0.04 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 7658 / 0 |
| flat_plants | two-phase | 9.0 / 151.0 (94.0) | 9.0 / 142.0 / 0.0 | 1.0 | 0.0 (0.0, 0.03; 100.0) | 14400.0 | 19596 / 0 |
| renderer_off | two-phase | 11.0 / 112.0 (90.2) | 11.0 / 101.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 15150 / 0 |
| particles | two-phase | 8.0 / 12.0 (33.3) | 8.0 / 4.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 600 / 0 |
| animation | two-phase | 10.0 / 13.0 (23.1) | 10.0 / 3.0 / 0.0 | 1.0 | 0.0 (0.0, 0.01; 100.0) | 14400.0 | 447 / 0 |
| animated_items | two-phase | 7.0 / 13.0 (46.2) | 7.0 / 6.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 100.0) | 14400.0 | 900 / 0 |
| block_entities | two-phase | 9.0 / 9.0 (0.0) | 9.0 / 0.0 / 0.0 | 1.0 | 0.0 (0.0, 0.0; 0.0) | 14400.0 | 0 / 0 |

Effects, core old-gpu-2p (reported; draw calls per frame by what they draw for; vanilla = no measure run in quick mode):

| scene | animation draws: vanilla / Quicksilver | particles | sky | weather | clouds | particles alive / drawn per frame | particle tick ms / extract ms | animated sprites (used outside terrain) | per tick changed / redrawn / left out | caught up / late | seen per frame |
|---|---|---|---|---|---|---|---|---|---|---|---|
| spawn | - / 5.0 | - / 0.606 | - / 3.0 | - / 0.0 | - / 0.0 | 86.229 / 0.631 | 0.028 / 0.013 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.0 |
| flythrough | - / 5.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.275 / 0.0 | 0.004 / 0.002 | 56 (0) | 23.0 / 1.0 / 22.0 | 0 / 0 | 10.858 |
| water_glass | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 53.324 / 53.287 | 0.014 / 0.026 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| nether | - / 7.51 | - / 0.737 | - / 0.0 | - / 0.0 | - / 0.0 | 48.267 / 8.99 | 0.067 / 0.01 | 56 (1) | 23.0 / 2.0 / 21.0 | 0 / 0 | 7.0 |
| mobs | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| outline | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| occlusion | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_move | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| occlusion_corner | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.0 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.185 / 13.205 | 0.006 / 0.012 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| water_glass_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 56.11 / 56.18 | 0.017 / 0.023 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| translucent_move_oit | - / 0.0 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 13.518 / 13.527 | 0.005 / 0.011 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 2.0 |
| flat_plants | - / 0.0 | - / 0.792 | - / 3.0 | - / 0.0 | - / 0.0 | 1.638 / 1.518 | 0.01 / 0.008 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| renderer_off | - / 0.0 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.004 / 0.001 | 56 (0) | 23.0 / 0.0 / 23.0 | 0 / 0 | 3.0 |
| particles | - / 0.0 | - / 4.0 | - / 3.0 | - / 0.0 | - / 0.0 | 66.0 / 66.0 | 0.005 / 0.038 | 56 (1) | 23.0 / 0.0 / 23.0 | 0 / 0 | 1.0 |
| animation | - / 32.287 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 2.8 / 2.797 | 0.004 / 0.008 | 56 (3) | 40.58 / 9.245 / 31.335 | 3 / 0 | 10.987 |
| animated_items | - / 28.063 | - / 0.0 | - / 3.0 | - / 0.0 | - / 0.0 | 0.0 / 0.0 | 0.001 / 0.001 | 56 (9) | 40.58 / 7.98 / 32.6 | 0 / 0 | 9.0 |
| block_entities | - / 13.322 | - / 1.0 | - / 3.0 | - / 0.0 | - / 0.0 | 12.375 / 12.395 | 0.003 / 0.006 | 56 (9) | 23.0 / 4.0 / 19.0 | 0 / 0 | 9.0 |

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
| core-quicksilver-2p-old | mobs | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | outline | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | occlusion | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | occlusion_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | occlusion_corner | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | translucent_move | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | particles | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | animation | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | animated_items | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | block_entities | 5.99 | 5.99 (0) | 5.99 |  |
| core-quicksilver-2p-old | flat_plants | 3.09 | 3.09 (0) | 3.09 |  |
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
| core-quicksilver-old | translucent_move | 8.24 | 8.24 (0) | 8.24 | between scenes +4.00 |
| core-quicksilver-old | particles | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | animation | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | animated_items | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | block_entities | 8.24 | 8.24 (0) | 8.24 |  |
| core-quicksilver-old | flat_plants | 3.21 | 3.21 (0) | 3.21 |  |
| core-quicksilver-old | renderer_off | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | water_glass_oit | 3.35 | 3.35 (0) | 3.35 |  |
| core-quicksilver-old | translucent_move_oit | 5.48 | 5.48 (0) | 5.48 |  |
| core-quicksilver-old | flythrough | 3.48 | 3.48 (0) | 3.48 |  |

Rises of 4 MB or more: core-quicksilver-old/translucent_move: between scenes +4.00

