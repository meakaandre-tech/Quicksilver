# Presets and the options screen (package 9)

Each preset run's shots against vanilla-old's (share of pixels over 8/255, %; limit in brackets).

## preset-low-old (preset=low-end)

| shot | over 8/255 % | limit % |
|---|---|---|
| block_entities.chest_open | 0.0039 | 0.0455 |
| block_entities.closed | 0.0071 | 0.049 |
| block_entities | 0.0124 | 0.049 |
| block_entities.sign_edit | 0.0151 | 0.0515 |
| flat_plants | 0.3184 | 0.637 |
| flythrough | 4.3738 | 8.8045 |
| mobs.far | 0.3554 | 0.711 |
| mobs | 0.0 | 0.001 |
| nether | 0.0003 | 0.0715 |
| particles.bare | 0.0 | 0.001 |
| particles | 2.7045 | 5.409 |
| spawn | 18.272 | 36.89 |
| water_glass | 14.5196 | 29.039 |

## preset-balanced-old (preset=balanced)

| shot | over 8/255 % | limit % |
|---|---|---|
| block_entities.chest_open | 0.0055 | 0.0455 |
| block_entities.closed | 0.0049 | 0.049 |
| block_entities | 0.0109 | 0.049 |
| block_entities.sign_edit | 0.0243 | 0.0515 |
| flat_plants | 0.0186 | 0.046 |
| flythrough | 0.0011 | 0.003 |
| mobs.far | 0.0 | 0.001 |
| mobs | 0.0 | 0.001 |
| nether | 0.0061 | 0.0715 |
| particles.bare | 0.0 | 0.0008 |
| particles | 0.0 | 0.0008 |
| spawn | 0.3125 | 0.89 |
| water_glass | 0.005 | 0.012 |

### Options screen test

| check | result | detail |
|---|---|---|
| command-sync | PASS | far-detail=6 file=6 preset=custom file preset=custom |
| opens-from-video-settings | PASS | button found, screen now SettingsScreen |
| opens-from-mod-menu | PASS | SettingsScreen |
| custom-after-command | PASS | shown CUSTOM, far detail button 6 |
| preset low-end | PASS | current low-end, shown LOW_END |
| save-load low-end | PASS | 17 switches and the preset read back |
| preset quality | PASS | current quality, shown QUALITY |
| save-load quality | PASS | 17 switches and the preset read back |
| preset balanced | PASS | current balanced, shown BALANCED |
| save-load balanced | PASS | 17 switches and the preset read back |
| custom-after-change option.opaque-leaves | PASS | option.opaque-leaves=on shown CUSTOM file on/custom |
| remesh-without-restart option.opaque-leaves | PASS | re-meshes 2 -> 3 |
| custom-after-change option.simple-water | PASS | option.simple-water=on shown CUSTOM file on/custom |
| remesh-without-restart option.simple-water | PASS | re-meshes 4 -> 5 |
| back-to-balanced | PASS | shown BALANCED |
| module-switch-saved | PASS | chunks.cow-sections on -> off (saved, restart asked: true) -> on (true) |
| tooltips | PASS | 34 rows and 16 module switches |
| gui-scale-1 | PASS | screen 1280x720, 32 buttons shown, all inside |
| gui-scale-2 | PASS | screen 640x360, 9 buttons shown, all inside |
| gui-scale-3 | PASS | screen 427x240, 8 buttons shown, all inside |
| gui-scale-4 | PASS | the window offers scale 3 at most; checked by size: 320 px wide, rows 310 px |

Screenshot (GUI scale 2, 1280x720): `runs/core-preset-balanced-old/settings/settings-screen.png`

## preset-quality-old (preset=quality)

| shot | over 8/255 % | limit % |
|---|---|---|
| block_entities.chest_open | 0.0089 | 0.0455 |
| block_entities.closed | 0.0109 | 0.049 |
| block_entities | 0.0118 | 0.049 |
| block_entities.sign_edit | 0.0204 | 0.0515 |
| flat_plants | 0.0186 | 0.046 |
| flythrough | 0.0011 | 0.003 |
| mobs.far | 0.0 | 0.001 |
| mobs | 0.0 | 0.001 |
| nether | 0.0003 | 0.0715 |
| particles.bare | 0.0 | 0.0008 |
| particles | 0.0 | 0.0008 |
| spawn | 0.4398 | 0.89 |
| water_glass | 0.0043 | 0.012 |

All preset and screen checks passed.
