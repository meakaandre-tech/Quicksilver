# Terrain uploads: the worst frame (package B)

Package B: gates on the worst frame of terrain uploads (ci/upload-compare.py), in the plain-path runs (old GPU: Intel's path, where R1's spike was measured): there arenas are 16 MB, so a grow copies at most 8 MB. Baseline (run 45351034373, before package B): fly-through's slowest frame upload 28.8 ms (old GPU) and 41.8 ms (two-phase old GPU), each an arena growing to 64 MB (32 MB copied); with 16 MB arenas 3.7-10.7 ms. The indirect-path runs (full, Vulkan, single player) keep 64 MB arenas (fewer draws there) and are reported, not gated. The single-player run plays only the fly-through.

| run | scene | bytes/frame | budget | hard cap (max) | largest frame | under the cap (max) | frames over cap | upload ms max (less CPU wait; wait) | slowest mesh ms | arena grows (ahead) | grow ms max (slowest grow: on CPU, waiting for a CPU, blocked; grows at a frame's start) | limit ms | |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|
| quicksilver-2p-old | flythrough | 939522.061 | 2097152.0 | 4194304 | 2092328 | 2092328 | 0 | 8.477 (8.477; 0.0) | 7.37 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | 20 | ok |
| quicksilver-2p-old | spawn | 31775.12 | 2097152.0 | 4194304 | 539456 | 539456 | 0 | 1.07 (1.07; 0.0) | 0.501 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | 20 | ok |
| quicksilver-2p-old | nether | 2842.018 | 2097152.0 | 4194304 | 232064 | 232064 | 0 | 0.332 (0.332; 0.0) | 0.089 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | 20 | ok |
| quicksilver-full | flythrough | 885587.357 | 2097152.0 | 4194304 | 2094912 | 2094912 | 0 | 28.731 (28.718; 0.013) | 3.071 | 3 (3) | 28.49 (on CPU 27.984, waiting 0.013, blocked 0.494; 3 at frame start) | reported | |
| quicksilver-full | spawn | 29062.735 | 2097152.0 | 4194304 | 318160 | 318160 | 0 | 1.203 (1.079; 0.0) | 0.138 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | reported | |
| quicksilver-full | nether | 1757.421 | 2097152.0 | 4194304 | 156608 | 156608 | 0 | 0.42 (0.42; 0.0) | 0.072 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | reported | |
| quicksilver-old | flythrough | 678330.736 | 2097152.0 | 4194304 | 2096848 | 2096848 | 0 | 8.327 (6.729; 1.598) | 5.943 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | 20 | ok |
| quicksilver-old | spawn | 23643.549 | 2097152.0 | 4194304 | 453184 | 453184 | 0 | 1.139 (1.139; 0.0) | 0.134 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | 20 | ok |
| quicksilver-old | nether | 1850.97 | 2097143.395 | 4194304 | 171328 | 171328 | 0 | 0.281 (0.281; 0.0) | 0.068 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | 20 | ok |
| quicksilver-vk | flythrough | 963004.168 | 2097152.0 | 4194304 | 2095536 | 2095536 | 0 | 6.344 (2.258; 0.0) | 5.152 | 3 (3) | 0.196 (on CPU 0.0, waiting 0.0, blocked 0.196; 3 at frame start) | reported | |
| quicksilver-vk | spawn | 40406.132 | 2097152.0 | 4194304 | 612288 | 612288 | 0 | 1.137 (1.137; 0.0) | 0.133 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | reported | |
| quicksilver-vk | nether | 1819.273 | 2097152.0 | 4194304 | 168256 | 168256 | 0 | 0.324 (0.324; 0.0) | 0.062 | 0 (0) | 0.0 (on CPU -1.0, waiting -1.0, blocked -1.0; 0 at frame start) | reported | |
| sp-quicksilver | flythrough | 688656.475 | 2097152.0 | 4194304 | 2090432 | 2090432 | 0 | 65.501 (37.511; 27.99) | 3.073 | 4 (4) | 64.818 (on CPU 37.13, waiting 27.99, blocked 0.0; 4 at frame start) | reported | |

## Upload failures

none
