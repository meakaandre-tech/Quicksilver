# Terrain uploads: the worst frame (package B)

Package B: gates on the worst frame of terrain uploads (ci/upload-compare.py), in the plain-path runs (old GPU: Intel's path, where R1's spike was measured): there arenas are 16 MB, so a grow copies at most 8 MB. Baseline (run 45351034373, before package B): fly-through's slowest frame upload 28.8 ms (old GPU) and 41.8 ms (two-phase old GPU), each an arena growing to 64 MB (32 MB copied); with 16 MB arenas 3.7-10.7 ms. The indirect-path runs (full, Vulkan, single player) keep 64 MB arenas (fewer draws there) and are reported, not gated. The single-player run plays only the fly-through.

| run | scene | bytes/frame | budget | hard cap (max) | largest frame | under the cap (max) | frames over cap | upload ms max (less CPU wait; wait) | slowest mesh ms | arena grows (ahead) | grow ms max (slowest grow: on CPU, waiting for a CPU, blocked; grows at a frame's start) | limit ms | |
|---|---|---|---|---|---|---|---|---|---|---|---|---|---|

## Upload failures

- upload: no Quicksilver client runs found
