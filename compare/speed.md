# Speed runs (package A)

Each speed run plays the scenes with a `speedAb` list once more, with Quicksilver's defaults, the frame limit and vsync off: first a stage profile (where frame time goes, the GPU waited for at each stage), then each switch off against on, rounds of five seconds a side (off-on, on-off, off-on, ...), in the same session: three for an option, five for an approximation or CI switch (the gated ones). Each side: the median over the rounds; on/off: from the rounds' own ratios, with five rounds their geometric mean without the highest and lowest, with three their median. On/off below 1 means the switch made it smaller.

## speed-old

### water_glass: profile (190 frames, 42.18 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 11.86 | 28.1% | 7.0 |
| terrain.translucent | 10.1 | 23.9% | 1.0 |
| terrain.cutout | 9.88 | 23.4% | 6.0 |
| other | 6.23 | 14.8% | 0.84 |
| gui | 3.38 | 8.0% | 1.0 |
| sky | 0.25 | 0.6% | 3.0 |
| particles.draw | 0.21 | 0.5% | 1.0 |
| terrain.prepare | 0.18 | 0.4% | 0.0 |
| particles.extract | 0.03 | 0.1% | 0.0 |
| animation | 0.02 | 0.0% | 0.0 |
| particles.tick | 0.02 | 0.0% | 0.0 |
| light.updates | 0.01 | 0.0% | 0.0 |
| terrain.far-upload | 0.01 | 0.0% | 0.0 |
| features.Particle | 0.01 | 0.0% | 0.0 |

Draw calls per profiled frame: 19.84

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.simple-water (1) | 40.53 → 37.46 (0.918) | 24.67 → 26.7 (1.089) | 17.25 → 18.87 (1.126) | 19.81 → 19.75 (0.997) | 7292.0 → 7673.0 (1.039) | 217720.0 → 216268.0 (0.993) | - |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.simple-water (1) | 61.87 → 64.03 | 86.0 → 89.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### nether: profile (402 frames, 19.84 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 10.74 | 54.1% | 7.0 |
| other | 5.07 | 25.5% | 0.4 |
| gui | 3.17 | 16.0% | 1.0 |
| animation | 0.28 | 1.4% | 3.98 |
| terrain.cutout | 0.22 | 1.1% | 5.01 |
| terrain.prepare | 0.15 | 0.8% | 0.0 |
| particles.draw | 0.09 | 0.4% | 0.76 |
| particles.tick | 0.06 | 0.3% | 0.0 |
| features.Entity Model | 0.03 | 0.2% | 1.0 |
| blockEntities.submit | 0.02 | 0.1% | 0.0 |
| particles.extract | 0.01 | 0.0% | 0.0 |
| terrain.far | 0.0 | 0.0% | 0.0 |
| terrain.translucent | 0.0 | 0.0% | 0.0 |
| light.updates | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 19.15

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| approx.fog-sections (1) | 18.9 → 18.68 (0.964) | 52.91 → 53.52 (1.037) | 18.62 → 25.17 (1.325) | 19.28 → 18.86 (0.977) | 5379.0 → 4450.0 (0.837) | 269575.0 → 168277.0 (0.624) | 113.42 sections in fog/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| approx.fog-sections (1) | 85.65 → 79.32 | 256.95 → 148.32 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### mobs: profile (282 frames, 28.44 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 8.59 | 30.2% | 5.0 |
| other | 6.01 | 21.1% | 0.57 |
| terrain.cutout | 4.9 | 17.2% | 3.0 |
| features.Entity Model | 4.08 | 14.3% | 2.0 |
| gui | 3.15 | 11.1% | 1.0 |
| features.Shadow | 0.78 | 2.7% | 1.0 |
| features.Extended Block Model | 0.4 | 1.4% | 2.0 |
| sky | 0.31 | 1.1% | 3.0 |
| entities.submit | 0.11 | 0.4% | 0.0 |
| terrain.prepare | 0.1 | 0.3% | 0.0 |
| animation | 0.01 | 0.0% | 0.0 |
| light.updates | 0.0 | 0.0% | 0.0 |
| terrain.translucent | 0.0 | 0.0% | 0.0 |
| terrain.far | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 17.57

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.entity-distance (16) | 27.02 → 24.48 (0.912) | 37.01 → 40.84 (1.096) | 27.54 → 29.25 (1.086) | 17.54 → 17.49 (0.998) | 610633.0 → 214053.0 (0.350) | 169404.0 → 169324.0 (1.000) | 42.21 entities/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.entity-distance (16) | 70.91 → 70.91 | 78.0 → 78.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### lights: profile (377 frames, 21.18 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 10.11 | 47.7% | 1.0 |
| other | 5.73 | 27.0% | 0.42 |
| gui | 3.28 | 15.5% | 4.0 |
| features.Item | 0.66 | 3.1% | 2.0 |
| features.Entity Model | 0.59 | 2.8% | 3.0 |
| sky | 0.51 | 2.4% | 3.0 |
| features.Flame | 0.17 | 0.8% | 1.0 |
| terrain.prepare | 0.05 | 0.2% | 0.0 |
| entities.submit | 0.04 | 0.2% | 0.0 |
| animation | 0.01 | 0.0% | 0.0 |
| light.updates | 0.01 | 0.0% | 0.0 |
| blockEntities.submit | 0.0 | 0.0% | 0.0 |
| terrain.cutout | 0.0 | 0.0% | 0.0 |
| terrain.translucent | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 14.42

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.dynamic-lights (1) | 19.18 → 19.35 (0.997) | 52.13 → 51.68 (1.003) | 35.02 → 36.49 (1.027) | 14.4 → 14.38 (0.999) | 33117.0 → 33659.0 (1.016) | 11406.0 → 11406.0 (1.000) | - |
| option.dynamic-lights (2) | 18.77 → 19.19 (1.025) | 53.27 → 52.11 (0.976) | 36.09 → 29.84 (0.878) | 14.37 → 14.38 (1.001) | 33114.0 → 33659.0 (1.016) | 11405.0 → 11406.0 (1.000) | - |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.dynamic-lights (1) | 25.0 → 25.0 | 3.0 → 3.0 | 0.0 → 0.0 |
| option.dynamic-lights (2) | 25.0 → 25.0 | 3.0 → 3.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### spawn: profile (97 frames, 82.18 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 32.24 | 39.2% | 11.0 |
| terrain.solid | 25.28 | 30.8% | 11.0 |
| terrain.translucent | 11.3 | 13.7% | 8.0 |
| other | 7.16 | 8.7% | 1.09 |
| gui | 2.74 | 3.3% | 1.0 |
| particles.draw | 1.4 | 1.7% | 1.0 |
| animation | 0.7 | 0.9% | 5.05 |
| terrain.prepare | 0.43 | 0.5% | 0.0 |
| sky | 0.3 | 0.4% | 3.0 |
| features.Entity Model | 0.27 | 0.3% | 1.0 |
| particles.tick | 0.19 | 0.2% | 0.0 |
| particles.extract | 0.11 | 0.1% | 0.0 |
| entities.submit | 0.05 | 0.1% | 0.0 |
| light.updates | 0.02 | 0.0% | 0.0 |

Draw calls per profiled frame: 42.14

### spawn: profile with option.far-terrain=96 (87 frames, 91.97 ms per profiled frame)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 30.86 | 33.5% | 11.0 |
| terrain.solid | 24.74 | 26.9% | 11.0 |
| terrain.far | 13.05 | 14.2% | 2.0 |
| terrain.translucent | 10.51 | 11.4% | 8.0 |
| other | 6.81 | 7.4% | 1.14 |
| gui | 2.65 | 2.9% | 1.0 |
| particles.draw | 1.4 | 1.5% | 1.0 |
| animation | 0.66 | 0.7% | 5.06 |
| terrain.prepare | 0.32 | 0.3% | 0.0 |
| sky | 0.28 | 0.3% | 3.0 |
| features.Entity Model | 0.24 | 0.3% | 1.0 |
| particles.tick | 0.19 | 0.2% | 0.0 |
| light.updates | 0.11 | 0.1% | 0.0 |
| particles.extract | 0.1 | 0.1% | 0.0 |
| terrain.far-upload | 0.02 | 0.0% | 0.0 |
| entities.submit | 0.02 | 0.0% | 0.0 |

Far terrain (package 12c): on side, medians over the rounds; memory at each window's end

| chunks | frame ms off → on (on/off) | far quads/frame | far tiles drawn | tiles held | far vertices KB | far arenas (VRAM) KB | far samples (heap) KB | heap used MB off → on | sampling CPU ms/s |
|---|---|---|---|---|---|---|---|---|---|
| 96 | 78.03 → 91.51 (1.160) | 22448.0 | 179.0 | 505.0 | 2782.0 | 16384.0 | 3009.0 | 372.0 → 341.0 | 1.79 |
| 64 | 78.99 → 89.6 (1.134) | 21975.0 | 154.0 | 420.0 | 2733.0 | 16384.0 | 2892.0 | 329.0 → 477.0 | 1.6 |
| 128 | 77.51 → 90.82 (1.168) | 24450.0 | 300.0 | 875.0 | 2965.0 | 16384.0 | 3515.0 | 337.0 → 449.0 | 2.75 |
| 192 | 78.88 → 93.37 (1.183) | 26102.0 | 632.0 | 1914.0 | 3117.0 | 16384.0 | 4141.0 | 318.0 → 410.0 | 5.19 |
| 256 | 79.07 → 94.1 (1.198) | 28058.0 | 1086.0 | 3357.0 | 3299.0 | 16384.0 | 5010.0 | 395.0 → 364.0 | 8.76 |

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| approx.fog-sections (1) | 85.92 → 82.25 (0.953) | 11.64 → 12.16 (1.050) | 8.94 → 9.35 (1.062) | 42.16 → 42.29 (0.998) | 253894.0 → 253561.0 (1.005) | 462459.0 → 430126.0 (0.929) | 30.5 sections in fog/frame |
| ci.fog-unconfirmed (1) | 79.41 → 84.57 (1.061) | 12.59 → 11.82 (0.943) | 10.26 → 9.91 (0.959) | 42.26 → 42.14 (1.001) | 250995.0 → 255691.0 (1.033) | 430848.0 → 463550.0 (1.076) | - |
| option.opaque-leaves (1) | 79.0 → 63.08 (0.798) | 12.66 → 15.85 (1.252) | 10.91 → 11.82 (1.083) | 42.15 → 43.08 (1.014) | 247557.0 → 236410.0 (0.941) | 426792.0 → 351837.0 (0.819) | 30.38 sections in fog/frame |
| option.far-detail (4) | 79.19 → 59.4 (0.755) | 12.63 → 16.84 (1.325) | 10.18 → 13.32 (1.266) | 42.13 → 40.06 (0.951) | 257173.0 → 247795.0 (0.964) | 424959.0 → 282749.0 (0.667) | 30.36 sections in fog/frame, 163.69 cutout layers/frame |
| option.particle-distance (24) | 78.81 → 77.98 (0.996) | 12.69 → 12.82 (1.003) | 9.48 → 10.73 (1.005) | 42.68 → 42.1 (0.986) | 244621.0 → 121410.0 (0.480) | 427669.0 → 427580.0 (1.000) | 30.48 sections in fog/frame, 2349.0 particles dropped |
| option.particle-density (50) | 79.43 → 76.92 (0.990) | 12.59 → 13.0 (1.010) | 10.72 → 10.17 (0.944) | 42.33 → 42.09 (0.998) | 252664.0 → 140599.0 (0.561) | 428078.0 → 427994.0 (1.000) | 30.47 sections in fog/frame, 1750.0 particles dropped |
| option.look (1) | 79.71 → 53.78 (0.680) | 12.55 → 18.59 (1.471) | 9.19 → 13.63 (1.497) | 42.31 → 44.11 (1.044) | 245149.0 → 244148.0 (0.985) | 437621.0 → 435349.0 (0.995) | 30.32 sections in fog/frame |
| option.far-terrain (96) | 78.03 → 91.51 (1.160) | 12.82 → 10.93 (0.862) | 10.67 → 8.78 (0.862) | 42.06 → 44.1 (1.048) | 241208.0 → 236507.0 (0.965) | 438634.0 → 436232.0 (0.995) | 32.59 sections under far terrain/frame |
| option.far-terrain (64) | 78.99 → 89.6 (1.134) | 12.66 → 11.16 (0.881) | 9.89 → 9.77 (0.988) | 42.08 → 44.15 (1.048) | 237532.0 → 241924.0 (1.028) | 439315.0 → 436630.0 (0.994) | 32.58 sections under far terrain/frame |
| option.far-terrain (128) | 77.51 → 90.82 (1.168) | 12.9 → 11.01 (0.856) | 10.52 → 9.18 (0.873) | 42.59 → 44.07 (1.047) | 241744.0 → 242675.0 (1.021) | 439876.0 → 437285.0 (0.995) | 32.58 sections under far terrain/frame |
| option.far-terrain (192) | 78.88 → 93.37 (1.183) | 12.68 → 10.71 (0.845) | 10.16 → 8.68 (0.820) | 42.66 → 44.08 (1.036) | 239944.0 → 245682.0 (1.035) | 440553.0 → 438297.0 (0.995) | 32.6 sections under far terrain/frame |
| option.far-terrain (256) | 79.07 → 94.1 (1.198) | 12.65 → 10.63 (0.835) | 11.05 → 9.04 (0.838) | 42.1 → 44.53 (1.058) | 253985.0 → 237097.0 (0.941) | 441093.0 → 438918.0 (0.995) | 32.6 sections under far terrain/frame |
| ci.far-no-cover (1) with option.far-terrain=96 | 92.11 → 96.05 (1.040) | 10.86 → 10.41 (0.962) | 9.03 → 8.76 (1.006) | 44.09 → 44.08 (1.000) | 243035.0 → 239139.0 (0.994) | 439417.0 → 476777.0 (1.085) | - |
| ci.far-old-mesh (1) with option.far-terrain=96 | 91.63 → 100.13 (1.092) | 10.91 → 9.99 (0.916) | 8.5 → 8.7 (1.013) | 44.07 → 44.18 (1.003) | 235937.0 → 234751.0 (1.012) | 440206.0 → 441096.0 (1.002) | 32.65 sections under far terrain/frame |
| ci.far-box-trees (1) with option.far-terrain=96 | 91.32 → 91.65 (1.005) | 10.95 → 10.91 (0.995) | 9.18 → 8.99 (1.004) | 44.09 → 44.43 (0.999) | 243284.0 → 236330.0 (0.982) | 440950.0 → 441172.0 (1.000) | 32.59 sections under far terrain/frame |
| ci.far-full-trees (1) with option.far-terrain=96 | 90.56 → 91.14 (1.003) | 11.04 → 10.97 (0.997) | 9.03 → 9.09 (1.021) | 44.06 → 44.09 (1.001) | 236456.0 → 232309.0 (1.001) | 441657.0 → 441796.0 (1.000) | 32.59 sections under far terrain/frame |
| ci.far-no-structures (1) with option.far-terrain=96 | 91.04 → 90.63 (1.001) | 10.98 → 11.03 (0.999) | 9.2 → 9.16 (1.007) | 44.19 → 44.07 (0.999) | 236590.0 → 239805.0 (1.008) | 442536.0 → 442439.0 (1.000) | 32.58 sections under far terrain/frame |
| ci.far-old-look (1) with option.far-terrain=96 | 90.97 → 90.63 (0.996) | 10.99 → 11.03 (1.005) | 9.17 → 9.1 (0.988) | 44.28 → 44.31 (0.995) | 234933.0 → 241451.0 (1.003) | 443151.0 → 443427.0 (1.000) | 32.58 sections under far terrain/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| approx.fog-sections (1) | 14.79 → 13.13 | 50.45 → 41.74 | 0.0 → 0.0 |
| ci.fog-unconfirmed (1) | 14.89 → 14.51 | 47.51 → 50.64 | 0.0 → 0.0 |
| option.opaque-leaves (1) | 13.02 → 16.5 | 40.22 → 51.31 | 0.0 → 0.0 |
| option.far-detail (4) | 12.54 → 16.62 | 38.76 → 51.36 | 0.0 → 0.0 |
| option.particle-distance (24) | 13.8 → 15.48 | 42.92 → 48.16 | 0.0 → 0.0 |
| option.particle-density (50) | 12.99 → 15.34 | 40.41 → 47.71 | 0.0 → 0.0 |
| option.look (1) | 14.96 → 18.83 | 48.16 → 60.64 | 0.0 → 0.0 |
| option.far-terrain (96) | 17.6 → 18.41 | 56.66 → 58.91 | 0.0 → 0.0 |
| option.far-terrain (64) | 17.6 → 15.99 | 56.66 → 51.16 | 0.0 → 0.0 |
| option.far-terrain (128) | 17.68 → 18.98 | 56.92 → 60.75 | 0.0 → 0.0 |
| option.far-terrain (192) | 18.6 → 17.81 | 59.9 → 57.0 | 0.0 → 0.0 |
| option.far-terrain (256) | 16.52 → 18.98 | 53.19 → 60.75 | 0.0 → 0.0 |
| ci.far-no-cover (1) | 17.49 → 19.23 | 55.96 → 67.7 | 0.0 → 0.0 |
| ci.far-old-mesh (1) | 18.41 → 20.35 | 58.91 → 65.12 | 0.0 → 0.0 |
| ci.far-box-trees (1) | 17.49 → 18.87 | 55.96 → 60.38 | 0.0 → 0.0 |
| ci.far-full-trees (1) | 21.24 → 19.33 | 67.98 → 61.85 | 0.0 → 0.0 |
| ci.far-no-structures (1) | 21.17 → 18.98 | 67.75 → 60.75 | 0.0 → 0.0 |
| ci.far-old-look (1) | 18.87 → 20.34 | 60.38 → 65.09 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### flythrough: profile (44 frames, 185.83 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 61.07 | 32.8% | 14.48 |
| terrain.solid | 53.58 | 28.8% | 14.39 |
| terrain.translucent | 27.98 | 15.0% | 7.34 |
| other | 25.95 | 13.9% | 1.0 |
| gui | 8.85 | 4.8% | 1.0 |
| animation | 5.23 | 2.8% | 5.11 |
| sky | 1.6 | 0.9% | 3.0 |
| light.updates | 1.23 | 0.7% | 0.0 |
| terrain.prepare | 0.58 | 0.3% | 0.0 |
| terrain.far | 0.02 | 0.0% | 0.0 |
| particles.tick | 0.01 | 0.0% | 0.0 |
| terrain.far-upload | 0.01 | 0.0% | 0.0 |
| particles.extract | 0.0 | 0.0% | 0.0 |
| weather | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 46.32

### flythrough: profile with option.far-terrain=96 (76 frames, 105.19 ms per profiled frame)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 30.6 | 29.1% | 16.76 |
| terrain.solid | 29.11 | 27.7% | 17.58 |
| terrain.far | 17.15 | 16.3% | 2.0 |
| terrain.translucent | 14.43 | 13.7% | 7.58 |
| other | 8.56 | 8.1% | 1.0 |
| gui | 3.2 | 3.0% | 1.0 |
| animation | 1.19 | 1.1% | 5.07 |
| sky | 0.52 | 0.5% | 3.0 |
| terrain.prepare | 0.36 | 0.3% | 0.0 |
| terrain.far-upload | 0.05 | 0.1% | 0.0 |
| light.updates | 0.05 | 0.0% | 0.0 |
| particles.tick | 0.0 | 0.0% | 0.0 |
| particles.extract | 0.0 | 0.0% | 0.0 |
| weather | 0.0 | 0.0% | 0.0 |

Far terrain (package 12c): on side, medians over the rounds; memory at each window's end

| chunks | frame ms off → on (on/off) | far quads/frame | far tiles drawn | tiles held | far vertices KB | far arenas (VRAM) KB | far samples (heap) KB | heap used MB off → on | sampling CPU ms/s |
|---|---|---|---|---|---|---|---|---|---|
| 96 | 79.51 → 90.38 (1.137) | 40810.0 | 184.0 | 524.0 | 2361.0 | 16384.0 | 3223.0 | 464.0 → 458.0 | 34.74 |

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| approx.fog-sections (1) | 82.9 → 81.19 (0.955) | 12.06 → 12.32 (1.048) | 8.9 → 9.24 (1.056) | 54.02 → 53.38 (0.992) | 208048.0 → 205424.0 (0.924) | 679994.0 → 673278.0 (0.983) | 26.15 sections in fog/frame |
| approx.translucent-regions (1) | 80.09 → 79.85 (1.002) | 12.49 → 12.52 (0.998) | 9.86 → 9.29 (0.963) | 72.81 → 53.44 (0.734) | 176252.0 → 183588.0 (1.026) | 672162.0 → 689157.0 (1.001) | 26.34 sections in fog/frame |
| option.far-detail (6) | 79.04 → 58.56 (0.746) | 12.65 → 17.08 (1.341) | 9.08 → 11.49 (1.259) | 53.6 → 42.0 (0.786) | 178715.0 → 152662.0 (0.855) | 647290.0 → 463691.0 (0.716) | 35.07 sections in fog/frame, 258.87 cutout layers/frame |
| option.far-terrain (96) | 79.51 → 90.38 (1.137) | 12.58 → 11.06 (0.879) | 9.28 → 6.97 (0.766) | 53.5 → 55.6 (1.043) | 195141.0 → 371293.0 (1.903) | 660191.0 → 603443.0 (0.914) | 25.13 sections under far terrain/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| approx.fog-sections (1) | 0.0 → 0.0 | 0.0 → 0.0 | 0.0 → 0.0 |
| approx.translucent-regions (1) | 0.0 → 0.0 | 0.0 → 0.0 | 0.0 → 0.0 |
| option.far-detail (6) | 0.0 → 0.0 | 0.0 → 0.0 | 0.0 → 0.0 |
| option.far-terrain (96) | 0.0 → 0.0 | 0.0 → 0.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### block_entities: profile (540 frames, 14.86 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| other | 4.86 | 32.7% | 0.3 |
| terrain.solid | 4.79 | 32.2% | 2.0 |
| gui | 2.5 | 16.8% | 1.0 |
| features.Entity Model | 1.81 | 12.2% | 12.0 |
| sky | 0.39 | 2.6% | 3.0 |
| features.Text | 0.13 | 0.8% | 1.0 |
| terrain.cutout | 0.11 | 0.8% | 1.0 |
| particles.draw | 0.11 | 0.7% | 1.0 |
| blockEntities.submit | 0.07 | 0.5% | 0.0 |
| terrain.prepare | 0.04 | 0.3% | 0.0 |
| particles.extract | 0.01 | 0.1% | 0.0 |
| light.updates | 0.01 | 0.1% | 0.0 |
| animation | 0.01 | 0.0% | 0.0 |
| terrain.far-upload | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 21.44

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.block-entity-distance (12) | 12.84 → 12.56 (0.981) | 77.86 → 79.61 (1.020) | 47.97 → 46.35 (0.945) | 21.26 → 16.23 (0.763) | 94374.0 → 46280.0 (0.491) | 3465.0 → 3465.0 (1.000) | 18.05 block entities/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.block-entity-distance (12) | 0.0 → 0.0 | 0.0 → 0.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

## speed-full

### water_glass: profile (207 frames, 38.62 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 9.98 | 25.8% | 1.0 |
| terrain.translucent | 8.45 | 21.9% | 1.0 |
| terrain.cutout | 8.34 | 21.6% | 1.0 |
| other | 8.34 | 21.6% | 1.77 |
| gui | 2.78 | 7.2% | 1.0 |
| particles.draw | 0.23 | 0.6% | 1.0 |
| sky | 0.21 | 0.5% | 3.0 |
| terrain.prepare | 0.2 | 0.5% | 0.0 |
| particles.extract | 0.03 | 0.1% | 0.0 |
| animation | 0.02 | 0.1% | 0.0 |
| particles.tick | 0.02 | 0.0% | 0.0 |
| terrain.far | 0.01 | 0.0% | 0.0 |
| features.Particle | 0.01 | 0.0% | 0.0 |
| terrain.far-upload | 0.01 | 0.0% | 0.0 |

Draw calls per profiled frame: 9.77

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.simple-water (1) | 38.02 → 35.49 (0.929) | 26.3 → 28.18 (1.076) | 19.39 → 21.22 (1.094) | 9.76 → 9.71 (0.994) | 12944.0 → 12058.0 (0.953) | 237743.0 → 236310.0 (0.994) | - |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.simple-water (1) | 61.87 → 64.03 | 86.0 → 89.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### nether: profile (434 frames, 18.48 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 8.46 | 45.8% | 1.0 |
| other | 6.58 | 35.6% | 1.37 |
| gui | 2.62 | 14.2% | 1.0 |
| animation | 0.24 | 1.3% | 3.71 |
| terrain.prepare | 0.22 | 1.2% | 0.0 |
| terrain.cutout | 0.17 | 0.9% | 1.0 |
| particles.draw | 0.06 | 0.3% | 0.52 |
| features.Entity Model | 0.05 | 0.3% | 1.0 |
| blockEntities.submit | 0.03 | 0.1% | 0.0 |
| particles.tick | 0.02 | 0.1% | 0.0 |
| particles.extract | 0.01 | 0.0% | 0.0 |
| terrain.far | 0.0 | 0.0% | 0.0 |
| light.updates | 0.0 | 0.0% | 0.0 |
| terrain.translucent | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 9.6

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| approx.fog-sections (1) | 17.46 → 17.36 (0.990) | 57.28 → 57.61 (1.011) | 40.61 → 41.45 (1.157) | 9.81 → 9.66 (0.986) | 11984.0 → 9523.0 (0.823) | 461326.0 → 279280.0 (0.605) | 113.39 sections in fog/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| approx.fog-sections (1) | 87.67 → 80.21 | 263.0 → 150.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### mobs: profile (301 frames, 26.7 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| other | 7.83 | 29.3% | 1.53 |
| terrain.solid | 7.07 | 26.5% | 1.0 |
| terrain.cutout | 4.12 | 15.4% | 1.0 |
| features.Entity Model | 3.44 | 12.9% | 2.0 |
| gui | 2.66 | 10.0% | 1.0 |
| features.Shadow | 0.66 | 2.5% | 1.0 |
| features.Extended Block Model | 0.38 | 1.4% | 2.0 |
| sky | 0.28 | 1.0% | 3.0 |
| terrain.prepare | 0.12 | 0.4% | 0.0 |
| entities.submit | 0.11 | 0.4% | 0.0 |
| animation | 0.01 | 0.0% | 0.0 |
| light.updates | 0.01 | 0.0% | 0.0 |
| terrain.far | 0.0 | 0.0% | 0.0 |
| terrain.translucent | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 12.53

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.entity-distance (16) | 25.64 → 23.41 (0.913) | 39.0 → 42.72 (1.095) | 28.12 → 31.02 (1.083) | 12.51 → 12.46 (0.996) | 613551.0 → 216971.0 (0.354) | 169362.0 → 169289.0 (1.000) | 42.2 entities/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.entity-distance (16) | 70.91 → 70.91 | 78.0 → 78.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### lights: profile (392 frames, 20.38 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.solid | 8.19 | 40.2% | 1.0 |
| other | 7.55 | 37.0% | 1.41 |
| gui | 2.74 | 13.4% | 4.0 |
| features.Item | 0.59 | 2.9% | 2.0 |
| features.Entity Model | 0.52 | 2.5% | 3.0 |
| sky | 0.47 | 2.3% | 3.0 |
| features.Flame | 0.14 | 0.7% | 1.0 |
| entities.submit | 0.07 | 0.3% | 0.0 |
| terrain.prepare | 0.06 | 0.3% | 0.0 |
| animation | 0.01 | 0.1% | 0.0 |
| blockEntities.submit | 0.01 | 0.0% | 0.0 |
| light.updates | 0.01 | 0.0% | 0.0 |
| terrain.cutout | 0.01 | 0.0% | 0.0 |
| terrain.translucent | 0.01 | 0.0% | 0.0 |

Draw calls per profiled frame: 15.41

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.dynamic-lights (1) | 18.97 → 18.92 (1.000) | 52.72 → 52.86 (1.000) | 31.26 → 35.65 (1.106) | 15.38 → 15.38 (1.000) | 33607.0 → 34151.0 (1.016) | 13832.0 → 13832.0 (1.000) | - |
| option.dynamic-lights (2) | 18.1 → 18.32 (1.006) | 55.24 → 54.59 (0.994) | 35.92 → 37.33 (1.021) | 15.36 → 15.36 (1.000) | 33605.0 → 34149.0 (1.016) | 13830.0 → 13830.0 (1.000) | - |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.dynamic-lights (1) | 25.0 → 25.0 | 3.0 → 3.0 | 0.0 → 0.0 |
| option.dynamic-lights (2) | 25.0 → 25.0 | 3.0 → 3.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### spawn: profile (102 frames, 77.78 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 28.42 | 36.5% | 1.0 |
| terrain.solid | 22.99 | 29.5% | 1.0 |
| terrain.translucent | 10.17 | 13.1% | 1.0 |
| other | 9.91 | 12.7% | 2.0 |
| gui | 2.66 | 3.4% | 1.0 |
| particles.draw | 1.36 | 1.7% | 1.25 |
| animation | 0.74 | 1.0% | 5.05 |
| terrain.prepare | 0.55 | 0.7% | 0.0 |
| sky | 0.33 | 0.4% | 3.0 |
| particles.tick | 0.27 | 0.3% | 0.0 |
| features.Entity Model | 0.2 | 0.3% | 1.0 |
| particles.extract | 0.1 | 0.1% | 0.0 |
| entities.submit | 0.06 | 0.1% | 0.0 |
| terrain.far | 0.02 | 0.0% | 0.0 |

Draw calls per profiled frame: 16.3

### spawn: profile with option.far-terrain=96 (106 frames, 75.44 ms per profiled frame)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 24.72 | 32.8% | 1.0 |
| terrain.solid | 20.12 | 26.7% | 1.0 |
| terrain.far | 9.96 | 13.2% | 2.0 |
| terrain.translucent | 8.49 | 11.3% | 1.0 |
| other | 7.24 | 9.6% | 2.0 |
| gui | 2.25 | 3.0% | 1.0 |
| particles.draw | 1.01 | 1.3% | 1.0 |
| animation | 0.57 | 0.8% | 5.05 |
| terrain.prepare | 0.39 | 0.5% | 0.0 |
| features.Entity Model | 0.24 | 0.3% | 1.0 |
| sky | 0.21 | 0.3% | 3.0 |
| particles.tick | 0.13 | 0.2% | 0.0 |
| particles.extract | 0.08 | 0.1% | 0.0 |
| terrain.far-upload | 0.02 | 0.0% | 0.0 |
| entities.submit | 0.01 | 0.0% | 0.0 |
| features.Particle | 0.01 | 0.0% | 0.0 |

Far terrain (package 12c): on side, medians over the rounds; memory at each window's end

| chunks | frame ms off → on (on/off) | far quads/frame | far tiles drawn | tiles held | far vertices KB | far arenas (VRAM) KB | far samples (heap) KB | heap used MB off → on | sampling CPU ms/s |
|---|---|---|---|---|---|---|---|---|---|
| 96 | 64.48 → 74.95 (1.162) | 22458.0 | 179.0 | 505.0 | 2783.0 | 8192.0 | 3009.0 | 457.0 → 297.0 | 1.79 |
| 64 | 65.17 → 72.11 (1.110) | 21985.0 | 154.0 | 420.0 | 2733.0 | 4096.0 | 2892.0 | 419.0 → 382.0 | 1.58 |
| 128 | 64.2 → 73.16 (1.142) | 24460.0 | 300.0 | 875.0 | 2966.0 | 8192.0 | 3515.0 | 439.0 → 413.0 | 2.58 |
| 192 | 64.73 → 74.49 (1.135) | 26100.0 | 632.0 | 1914.0 | 3117.0 | 8192.0 | 4141.0 | 426.0 → 488.0 | 5.0 |
| 256 | 64.77 → 74.39 (1.159) | 28053.0 | 1086.0 | 3357.0 | 3299.0 | 8192.0 | 5010.0 | 422.0 → 484.0 | 7.75 |

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| approx.fog-sections (1) | 75.81 → 71.09 (0.953) | 13.19 → 14.07 (1.050) | 10.97 → 11.37 (1.096) | 16.0 → 16.64 (1.028) | 281139.0 → 272412.0 (0.981) | 600533.0 → 553543.0 (0.922) | 30.43 sections in fog/frame |
| ci.fog-unconfirmed (1) | 67.42 → 71.39 (1.058) | 14.83 → 14.01 (0.946) | 11.62 → 11.78 (0.993) | 16.0 → 16.0 (0.997) | 273714.0 → 268318.0 (0.995) | 553953.0 → 600955.0 (1.085) | - |
| option.opaque-leaves (1) | 66.72 → 53.88 (0.810) | 14.99 → 18.56 (1.236) | 10.51 → 13.29 (1.218) | 17.0 → 16.0 (0.941) | 262142.0 → 260399.0 (0.944) | 554844.0 → 447908.0 (0.807) | 30.33 sections in fog/frame |
| option.far-detail (4) | 66.09 → 51.62 (0.781) | 15.13 → 19.37 (1.280) | 12.4 → 13.66 (1.081) | 16.3 → 16.08 (0.971) | 269668.0 → 258286.0 (0.958) | 555418.0 → 362586.0 (0.653) | 30.31 sections in fog/frame, 156.61 cutout layers/frame |
| option.particle-distance (24) | 64.27 → 63.12 (0.976) | 15.56 → 15.84 (1.025) | 12.6 → 13.61 (1.016) | 16.0 → 16.0 (1.000) | 265947.0 → 137627.0 (0.513) | 555687.0 → 555377.0 (1.000) | 30.38 sections in fog/frame, 2438.0 particles dropped |
| option.particle-density (50) | 63.98 → 64.39 (1.006) | 15.63 → 15.53 (0.994) | 12.93 → 11.99 (0.950) | 16.0 → 16.0 (1.000) | 260543.0 → 163093.0 (0.611) | 556129.0 → 556041.0 (1.000) | 30.39 sections in fog/frame, 1803.0 particles dropped |
| option.look (1) | 64.88 → 44.53 (0.686) | 15.41 → 22.46 (1.458) | 12.82 → 16.76 (1.377) | 16.0 → 17.3 (1.080) | 262804.0 → 260739.0 (0.992) | 566957.0 → 564626.0 (0.996) | 30.27 sections in fog/frame |
| option.far-terrain (96) | 64.48 → 74.95 (1.162) | 15.51 → 13.34 (0.860) | 13.31 → 10.83 (0.800) | 16.47 → 18.65 (1.125) | 269567.0 → 252179.0 (0.936) | 567952.0 → 564084.0 (0.993) | 32.48 sections under far terrain/frame |
| option.far-terrain (64) | 65.17 → 72.11 (1.110) | 15.34 → 13.87 (0.900) | 10.66 → 11.89 (1.103) | 16.0 → 18.0 (1.125) | 262664.0 → 265255.0 (1.011) | 568856.0 → 564366.0 (0.992) | 32.46 sections under far terrain/frame |
| option.far-terrain (128) | 64.2 → 73.16 (1.142) | 15.58 → 13.67 (0.876) | 12.93 → 10.82 (0.835) | 16.0 → 18.0 (1.125) | 262583.0 → 249010.0 (0.953) | 569329.0 → 564955.0 (0.993) | 32.47 sections under far terrain/frame |
| option.far-terrain (192) | 64.73 → 74.49 (1.135) | 15.45 → 13.43 (0.881) | 12.34 → 11.55 (0.916) | 16.0 → 18.0 (1.125) | 267685.0 → 264182.0 (0.987) | 570013.0 → 565851.0 (0.993) | 32.48 sections under far terrain/frame |
| option.far-terrain (256) | 64.77 → 74.39 (1.159) | 15.44 → 13.44 (0.863) | 12.03 → 11.23 (0.933) | 16.0 → 18.0 (1.125) | 272225.0 → 260545.0 (0.957) | 570526.0 → 566347.0 (0.993) | 32.48 sections under far terrain/frame |
| ci.far-no-cover (1) with option.far-terrain=96 | 74.46 → 77.21 (1.047) | 13.43 → 12.95 (0.955) | 10.91 → 10.74 (0.956) | 18.19 → 18.0 (0.985) | 254816.0 → 263328.0 (1.021) | 567275.0 → 620894.0 (1.095) | - |
| ci.far-old-mesh (1) with option.far-terrain=96 | 73.85 → 80.53 (1.086) | 13.54 → 12.42 (0.921) | 11.04 → 10.61 (0.952) | 18.0 → 18.0 (1.000) | 257899.0 → 261973.0 (1.025) | 568217.0 → 568986.0 (1.001) | 32.52 sections under far terrain/frame |
| ci.far-box-trees (1) with option.far-terrain=96 | 74.03 → 75.03 (1.000) | 13.51 → 13.33 (1.000) | 10.67 → 11.1 (1.050) | 18.0 → 18.9 (1.019) | 251514.0 → 253506.0 (1.006) | 569082.0 → 569203.0 (1.000) | 32.48 sections under far terrain/frame |
| ci.far-full-trees (1) with option.far-terrain=96 | 72.68 → 73.99 (1.015) | 13.76 → 13.52 (0.985) | 11.11 → 11.17 (1.034) | 18.0 → 18.0 (1.003) | 250436.0 → 252363.0 (0.983) | 569470.0 → 569672.0 (1.000) | 32.48 sections under far terrain/frame |
| ci.far-no-structures (1) with option.far-terrain=96 | 75.26 → 74.09 (1.001) | 13.29 → 13.5 (0.999) | 10.6 → 11.34 (1.065) | 18.54 → 18.0 (0.976) | 259460.0 → 253584.0 (0.984) | 570299.0 → 570216.0 (1.000) | 32.48 sections under far terrain/frame |
| ci.far-old-look (1) with option.far-terrain=96 | 74.81 → 73.58 (0.981) | 13.37 → 13.59 (1.020) | 11.03 → 11.02 (1.019) | 18.0 → 18.0 (1.000) | 249835.0 → 247544.0 (0.987) | 571229.0 → 571094.0 (1.000) | 32.48 sections under far terrain/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| approx.fog-sections (1) | 22.58 → 21.54 | 77.0 → 67.0 | 0.0 → 0.0 |
| ci.fog-unconfirmed (1) | 21.54 → 22.58 | 67.0 → 77.0 | 0.0 → 0.0 |
| option.opaque-leaves (1) | 21.54 → 23.51 | 67.0 → 75.0 | 0.0 → 0.0 |
| option.far-detail (4) | 21.54 → 21.22 | 67.0 → 66.0 | 0.0 → 0.0 |
| option.particle-distance (24) | 21.54 → 21.54 | 67.0 → 67.0 | 0.0 → 0.0 |
| option.particle-density (50) | 21.54 → 21.54 | 67.0 → 67.0 | 0.0 → 0.0 |
| option.look (1) | 22.98 → 23.29 | 74.0 → 75.0 | 0.0 → 0.0 |
| option.far-terrain (96) | 22.98 → 25.31 | 74.0 → 81.0 | 0.0 → 0.0 |
| option.far-terrain (64) | 22.98 → 25.31 | 74.0 → 81.0 | 0.0 → 0.0 |
| option.far-terrain (128) | 22.98 → 25.31 | 74.0 → 81.0 | 0.0 → 0.0 |
| option.far-terrain (192) | 22.98 → 25.31 | 74.0 → 81.0 | 0.0 → 0.0 |
| option.far-terrain (256) | 22.98 → 25.31 | 74.0 → 81.0 | 0.0 → 0.0 |
| ci.far-no-cover (1) | 25.31 → 26.14 | 81.0 → 92.0 | 0.0 → 0.0 |
| ci.far-old-mesh (1) | 25.31 → 25.31 | 81.0 → 81.0 | 0.0 → 0.0 |
| ci.far-box-trees (1) | 25.31 → 25.31 | 81.0 → 81.0 | 0.0 → 0.0 |
| ci.far-full-trees (1) | 25.31 → 25.31 | 81.0 → 81.0 | 0.0 → 0.0 |
| ci.far-no-structures (1) | 25.31 → 25.31 | 81.0 → 81.0 | 0.0 → 0.0 |
| ci.far-old-look (1) | 25.31 → 25.31 | 81.0 → 81.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### flythrough: profile (58 frames, 137.59 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 45.33 | 32.9% | 1.0 |
| terrain.solid | 36.79 | 26.7% | 1.0 |
| other | 24.33 | 17.7% | 3.88 |
| terrain.translucent | 20.06 | 14.6% | 1.0 |
| gui | 5.96 | 4.3% | 1.0 |
| animation | 2.97 | 2.2% | 5.09 |
| sky | 1.01 | 0.7% | 3.0 |
| light.updates | 0.68 | 0.5% | 0.0 |
| terrain.prepare | 0.61 | 0.4% | 0.0 |
| terrain.far | 0.02 | 0.0% | 0.0 |
| particles.tick | 0.01 | 0.0% | 0.0 |
| terrain.far-upload | 0.01 | 0.0% | 0.0 |
| particles.extract | 0.0 | 0.0% | 0.0 |
| weather | 0.0 | 0.0% | 0.0 |

Draw calls per profiled frame: 15.97

### flythrough: profile with option.far-terrain=96 (90 frames, 88.41 ms per profiled frame)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| terrain.cutout | 23.83 | 26.9% | 1.0 |
| terrain.solid | 22.02 | 24.9% | 1.0 |
| terrain.far | 13.45 | 15.2% | 2.0 |
| terrain.translucent | 12.14 | 13.7% | 1.0 |
| other | 12.06 | 13.6% | 3.79 |
| gui | 2.93 | 3.3% | 1.0 |
| animation | 0.94 | 1.1% | 5.06 |
| terrain.prepare | 0.46 | 0.5% | 0.0 |
| sky | 0.39 | 0.4% | 3.0 |
| terrain.far-upload | 0.11 | 0.1% | 0.0 |
| particles.tick | 0.04 | 0.0% | 0.0 |
| light.updates | 0.04 | 0.0% | 0.0 |
| weather | 0.0 | 0.0% | 0.0 |
| particles.extract | 0.0 | 0.0% | 0.0 |

Far terrain (package 12c): on side, medians over the rounds; memory at each window's end

| chunks | frame ms off → on (on/off) | far quads/frame | far tiles drawn | tiles held | far vertices KB | far arenas (VRAM) KB | far samples (heap) KB | heap used MB off → on | sampling CPU ms/s |
|---|---|---|---|---|---|---|---|---|---|
| 96 | 73.93 → 82.96 (1.122) | 39781.0 | 184.0 | 524.0 | 2346.0 | 4096.0 | 3243.0 | 358.0 → 350.0 | 53.36 |

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| approx.fog-sections (1) | 74.69 → 71.97 (0.947) | 13.39 → 13.89 (1.056) | 9.0 → 10.58 (1.148) | 15.69 → 15.93 (1.015) | 214716.0 → 203365.0 (0.894) | 761970.0 → 724729.0 (0.948) | 28.59 sections in fog/frame |
| approx.translucent-regions (1) | 74.93 → 74.63 (0.993) | 13.35 → 13.4 (1.007) | 9.93 → 9.95 (0.988) | 15.97 → 15.93 (0.998) | 210502.0 → 208797.0 (0.991) | 710605.0 → 720377.0 (1.015) | 29.23 sections in fog/frame |
| option.far-detail (6) | 72.77 → 53.87 (0.736) | 13.74 → 18.56 (1.359) | 10.29 → 13.75 (1.320) | 15.94 → 15.25 (0.959) | 200993.0 → 233670.0 (1.148) | 727991.0 → 438886.0 (0.602) | 32.43 sections in fog/frame, 210.4 cutout layers/frame |
| option.far-terrain (96) | 73.93 → 82.96 (1.122) | 13.53 → 12.05 (0.891) | 9.63 → 8.73 (0.906) | 15.88 → 17.9 (1.127) | 204048.0 → 519905.0 (2.554) | 716431.0 → 649603.0 (0.930) | 27.87 sections under far terrain/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| approx.fog-sections (1) | 14.95 → 14.5 | 57.29 → 50.9 | 0.0 → 0.0 |
| approx.translucent-regions (1) | 13.88 → 14.08 | 49.57 → 50.32 | 0.0 → 0.0 |
| option.far-detail (6) | 13.45 → 14.2 | 47.42 → 47.84 | 0.0 → 0.0 |
| option.far-terrain (96) | 14.49 → 16.8 | 52.25 → 62.63 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

### block_entities: profile (595 frames, 13.49 ms per profiled frame, GPU waited for at each stage: True)

| stage | ms/frame | share | draws/frame |
|---|---|---|---|
| other | 5.21 | 38.6% | 1.27 |
| terrain.solid | 3.95 | 29.3% | 1.0 |
| gui | 2.07 | 15.4% | 1.0 |
| features.Entity Model | 1.47 | 10.9% | 12.0 |
| sky | 0.31 | 2.3% | 3.0 |
| features.Text | 0.1 | 0.8% | 1.0 |
| terrain.cutout | 0.1 | 0.7% | 1.0 |
| particles.draw | 0.1 | 0.7% | 1.0 |
| blockEntities.submit | 0.07 | 0.5% | 0.0 |
| terrain.prepare | 0.06 | 0.4% | 0.0 |
| particles.extract | 0.01 | 0.1% | 0.0 |
| animation | 0.01 | 0.1% | 0.0 |
| light.updates | 0.01 | 0.1% | 0.0 |
| terrain.far-upload | 0.01 | 0.0% | 0.0 |

Draw calls per profiled frame: 21.41

| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame | terrain triangles/frame | left out (on) |
|---|---|---|---|---|---|---|---|
| option.block-entity-distance (12) | 11.92 → 11.21 (0.953) | 83.9 → 89.17 (1.049) | 54.79 → 58.46 (0.980) | 21.24 → 16.22 (0.764) | 94775.0 → 47192.0 (0.496) | 3995.0 → 3995.0 (1.000) | 18.04 block entities/frame |

| switch (on value) | occlusion culled % off → on | sections culled/frame off → on | still frames drawn in full off → on |
|---|---|---|---|
| option.block-entity-distance (12) | 0.0 → 0.0 | 0.0 → 0.0 | 0.0 → 0.0 |

Speed hooks: FogRendererMixin applied, LightUpdatesProfileMixin applied, ParticleAccessor applied, ParticleEngineSpeedMixin applied

## Gates (ci/speed-gates.json)

| setting | scene | run | metric | value | limit | |
|---|---|---|---|---|---|---|
| approx.fog-sections | spawn | speed-old | sectionsInFogPerFrame (on) | 30.5 | >= 10 | ok |
| approx.fog-sections | spawn | speed-full | sectionsInFogPerFrame (on) | 30.43 | >= 10 | ok |
| approx.fog-sections | spawn | speed-old | terrainTrianglesPerFrame on/off | 0.9295 (rounds 0.9278, 0.9294, 0.9295, 0.9295, 0.9304) | <= 0.96 | ok |
| approx.fog-sections | spawn | speed-full | terrainTrianglesPerFrame on/off | 0.9217 (rounds 0.9214, 0.9214, 0.9218, 0.922, 0.9221) | <= 0.96 | ok |
| approx.fog-sections | spawn | speed-old | frameMsAvg on/off | 0.9527 (rounds 0.9209, 0.9337, 0.9573, 0.9673, 0.9898) | <= 1.0 | ok |
| approx.fog-sections | spawn | speed-full | frameMsAvg on/off | 0.9527 (rounds 0.9263, 0.945, 0.948, 0.9652, 0.9826) | <= 1.0 | ok |
| approx.fog-sections | flythrough | speed-old | sectionsInFogPerFrame (on) | 26.15 | >= 5 | ok |
| approx.fog-sections | flythrough | speed-full | sectionsInFogPerFrame (on) | 28.59 | >= 5 | ok |
| ci.fog-unconfirmed | spawn | speed-old | sectionsInFogPerFrame (on) | 0.0 | <= 0 | ok |
| ci.fog-unconfirmed | spawn | speed-full | sectionsInFogPerFrame (on) | 0.0 | <= 0 | ok |
| approx.translucent-regions | flythrough | speed-old | drawCallsPerFrame on/off | 0.7341 (rounds 0.7273, 0.7299, 0.736, 0.7364, 0.7377) | <= 0.95 | ok |
| approx.translucent-regions | flythrough | speed-old | frameMsAvg on/off | 1.0018 (rounds 0.9838, 0.9916, 1.0049, 1.0089, 1.0274) | <= 1.03 | ok |
| approx.fog-sections | nether | speed-old | sectionsInFogPerFrame (on) | 113.42 | >= 50 | ok |
| approx.fog-sections | nether | speed-full | sectionsInFogPerFrame (on) | 113.39 | >= 50 | ok |
| approx.fog-sections | nether | speed-old | terrainTrianglesPerFrame on/off | 0.6241 (rounds 0.624, 0.6241, 0.6241, 0.6241, 0.6242) | <= 0.8 | ok |
| approx.fog-sections | nether | speed-full | terrainTrianglesPerFrame on/off | 0.6054 (rounds 0.6053, 0.6054, 0.6054, 0.6054, 0.6054) | <= 0.8 | ok |
| option.dynamic-lights | lights | speed-old | frameMsAvg on/off | 0.997 (rounds 0.8827, 0.9709, 0.9979, 1.0228, 1.0443) | <= 1.05 | ok |
| option.look | spawn | speed-old | frameMsAvg on/off | 0.6797 (rounds 0.6665, 0.6766, 0.6772, 0.6854, 0.697) | <= 1.0 | ok |
| option.far-terrain | spawn | speed-old | frameMsAvg on/off | 1.1603 (rounds 1.1479, 1.1603, 1.2357) | <= 1.22 | ok |
| option.far-terrain | spawn | speed-old | frameMsAvg on/off | 1.168 (rounds 1.1565, 1.168, 1.1903) | <= 1.22 | ok |
| option.far-terrain | flythrough | speed-old | farCpuMsPerSecond (on) | 34.74 | <= 850 | ok |
| option.far-terrain | flythrough | speed-full | farCpuMsPerSecond (on) | 53.36 | <= 850 | ok |

## Speed failures

none
