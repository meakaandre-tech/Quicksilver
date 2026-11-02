# Server suite (phase 2)

Mode: full (suites expected: core, siftec, terralith; quick mode runs core only)

## core

### Worldgen: settling before the save

SIFTEC's pieces (ore nodes, collectibles) are placed by the harness before the first tick, while every generated chunk is loaded; the save waits for the light engine and SIFTEC's own queue. Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | chunks given SIFTEC pieces | light quiet at tick | then: SIFTEC queue / generated chunks unloaded | saved at tick | at the save: queue / unloaded |
|---|---|---|---|---|---|
| vanilla-a | 0 | 20 | 0 / 0 | 40 | 0 / 0 |
| vanilla-b | 0 | 20 | 0 / 0 | 40 | 0 / 0 |
| vanilla-c | 0 | 20 | 0 / 0 | 40 | 0 / 0 |
| quicksilver | 0 | 20 | 0 / 0 | 40 | 0 / 0 |

### Worldgen (byte for byte)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_end/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_nether/region | 144 | 0 | 0 | 0 |

Keys compared: chunks. Noise examples in core-genbytes-noise-b.json and -noise-c.json.

### Worldgen (block by block)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_end/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_nether/region | 144 | 0 | 0 | 0 |

Keys compared: blocks, block entities, scheduled ticks, entities. Noise examples in core-gen-noise-b.json and -noise-c.json.

### World diff after the scripted run

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 1764 | 0 | 0 | 0 |

Keys compared: blocks, block entities, entity types. Noise examples in core-run-noise-b.json and -noise-c.json.

### World diff after the random-tick run

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 1764 | 0 | 0 | 0 |

Keys compared: blocks, block entities, entity types. Noise examples in core-random-noise-b.json and -noise-c.json.

### GameTests (tick finished, result)

| test | vanilla-a | vanilla-b | vanilla-c | quicksilver |
|---|---|---|---|---|
| hopper_chain | 542: moved=64 | 542: moved=64 | 542: moved=64 | 542: moved=64 |
| redstone_clock | 100: lampOn=1 observerPulses=17 | 100: lampOn=1 observerPulses=17 | 100: lampOn=1 observerPulses=17 | 100: lampOn=1 observerPulses=17 |
| piston_machine | 200: extensions=10 line=stone,_,cobblestone,oak_planks, | 200: extensions=10 line=stone,_,cobblestone,oak_planks, | 200: extensions=10 line=stone,_,cobblestone,oak_planks, | 200: extensions=10 line=stone,_,cobblestone,oak_planks, |
| piston_door | 63: closedAt=13 | 63: closedAt=13 | 63: closedAt=13 | 63: closedAt=13 |
| item_sorter | 436: sorted=19 passed=20 strays=0 filter=18 lock=1 line=0 input=0 torch=true | 436: sorted=19 passed=20 strays=0 filter=18 lock=1 line=0 input=0 torch=true | 436: sorted=19 passed=20 strays=0 filter=18 lock=1 line=0 input=0 torch=true | 436: sorted=19 passed=20 strays=0 filter=18 lock=1 line=0 input=0 torch=true |
| crop_farm | 200: grown=6 dispensersEmpty=false | 200: grown=6 dispensersEmpty=false | 200: grown=6 dispensersEmpty=false | 200: grown=6 dispensersEmpty=false |
| mob_farm | 141: drops=14 beef=9 leather=5 | 141: drops=14 beef=9 leather=5 | 141: drops=14 beef=9 leather=5 | 141: drops=14 beef=9 leather=5 |
| villager_trade | 41: offers=2 first=minecraft:bookshelf xp=1 | 41: offers=2 first=minecraft:bookshelf xp=1 | 41: offers=2 first=minecraft:bookshelf xp=1 | 41: offers=2 first=minecraft:bookshelf xp=1 |

### Scripted run (relative only)

| run | finished | load wait (ticks) | mspt avg | mspt p99 | ticks over 50 ms | heap after load MB | heap end MB | start-up ms | world load ms |
|---|---|---|---|---|---|---|---|---|---|
| vanilla-a | yes | 3 | 1.717 | 8.967 | 1 | 151.097 | 151.398 | 9380 | 570 |
| vanilla-b | yes | 3 | 1.51 | 8.439 | 1 | 151.1 | 151.663 | 9545 | 504 |
| vanilla-c | yes | 3 | 1.53 | 11.666 | 2 | 151.004 | 151.572 | 12393 | 629 |
| quicksilver | yes | 2 | 0.887 | 5.703 | 1 | 139.597 | 141.844 | 7665 | 416 |

### Random-tick run

| run | finished | random ticks, pins and spawns |
|---|---|---|
| vanilla-a | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |
| vanilla-b | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |
| vanilla-c | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |
| quicksilver | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |

### Heap run (live heap after a full GC, MiB; ten minutes of game time)

| run | after load | after 10 min | finished |
|---|---|---|---|
| vanilla-a | 149.624 | 150.389 | yes |
| vanilla-b | 149.532 | 150.305 | yes |
| vanilla-c | 149.65 | 150.523 | yes |
| quicksilver | 138.48 | 139.27 | yes |
Heap after load: Quicksilver 138.5 MiB, vanilla 149.5 to 149.7 MiB (11.1 MiB, 7% below the lowest)
Heap after ten minutes: Quicksilver 139.3 MiB, vanilla 150.3 to 150.5 MiB (11.0 MiB, 7% below the lowest)

Where it goes: core-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1003, "tps": 20.06, "msptAvg": 0.983, "msptP50": 0.552, "msptP99": 7.542, "msptMax": 68.061, "ticksOver50ms": 1, "heapUsedMB": 263.146, "heapUsedAfterGcMB": 142.837, "startupMs": 8991, "worldLoadMs": 1741, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

## siftec

### Worldgen: settling before the save

SIFTEC's pieces (ore nodes, collectibles) are placed by the harness before the first tick, while every generated chunk is loaded; the save waits for the light engine and SIFTEC's own queue. Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | chunks given SIFTEC pieces | light quiet at tick | then: SIFTEC queue / generated chunks unloaded | saved at tick | at the save: queue / unloaded |
|---|---|---|---|---|---|
| vanilla-a | 6 | 22 | 0 / 0 | 50 | 0 / 0 |
| vanilla-b | 6 | 20 | 0 / 0 | 50 | 0 / 0 |
| vanilla-c | 6 | 22 | 0 / 0 | 50 | 0 / 0 |
| quicksilver | 6 | 20 | 0 / 0 | 50 | 0 / 0 |

### Worldgen (byte for byte)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_nether/region | 144 | 0 | 0 | 0 |
| dimensions/the_sift/the_sift/region | 144 | 0 | 0 | 0 |

Keys compared: chunks. Noise examples in siftec-genbytes-noise-b.json and -noise-c.json.

### Worldgen (block by block)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_nether/region | 144 | 0 | 0 | 0 |
| dimensions/the_sift/the_sift/region | 144 | 0 | 0 | 0 |

Keys compared: blocks, block entities, scheduled ticks, entities. Noise examples in siftec-gen-noise-b.json and -noise-c.json.

### World diff after the scripted run

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 1764 | 0 | 0 | 0 |

Keys compared: blocks, block entities, entity types. Noise examples in siftec-run-noise-b.json and -noise-c.json.

### Scripted run (relative only)

| run | finished | load wait (ticks) | mspt avg | mspt p99 | ticks over 50 ms | heap after load MB | heap end MB | start-up ms | world load ms |
|---|---|---|---|---|---|---|---|---|---|
| vanilla-a | yes | 5 | 2.069 | 11.036 | 2 | 279.015 | 279.833 | 19136 | 641 |
| vanilla-b | yes | 3 | 1.862 | 8.195 | 2 | 279.443 | 280.394 | 11446 | 483 |
| vanilla-c | yes | 5 | 1.566 | 10.072 | 2 | 278.915 | 279.84 | 19168 | 500 |
| quicksilver | yes | 6 | 2.05 | 12.448 | 2 | 217.763 | 220.175 | 20430 | 577 |

### Heap run (live heap after a full GC, MiB; ten minutes of game time)

| run | after load | after 10 min | finished |
|---|---|---|---|
| vanilla-a | 277.487 | 278.684 | yes |
| vanilla-b | 278.098 | 279.468 | yes |
| vanilla-c | 277.572 | 278.824 | yes |
| quicksilver | 215.836 | 216.933 | yes |
Heap after load: Quicksilver 215.8 MiB, vanilla 277.5 to 278.1 MiB (61.7 MiB, 22% below the lowest)
Heap after ten minutes: Quicksilver 216.9 MiB, vanilla 278.7 to 279.5 MiB (61.8 MiB, 22% below the lowest)

Where it goes: siftec-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1004, "tps": 20.08, "msptAvg": 2.269, "msptP50": 1.572, "msptP99": 11.47, "msptMax": 148.325, "ticksOver50ms": 2, "heapUsedMB": 479.119, "heapUsedAfterGcMB": 221.185, "startupMs": 22622, "worldLoadMs": 2767, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

### Create train

| run | result |
|---|---|
| vanilla-a | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |
| vanilla-b | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |
| vanilla-c | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |
| quicksilver | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |

### SIFTEC self-tests (passed/failed)

| suite | vanilla-a | vanilla-b | vanilla-c | quicksilver |
|---|---|---|---|---|
| always | 15/0 | 15/0 | 15/0 | 15/0 |
| always edges | 20/0 | 20/0 | 20/0 | 20/0 |
| buildgun-ui | 13/0 | 13/0 | 13/0 | 13/0 |
| buildingfix | 13/0 | 13/0 | 13/0 | 13/0 |
| buildings | 26/0 | 26/0 | 26/0 | 26/0 |
| buildings_a | 55/0 | 55/0 | 55/0 | 55/0 |
| buildings_b | 78/0 | 78/0 | 78/0 | 78/0 |
| datafix | 20/0 | 20/0 | 20/0 | 20/0 |
| designer | 41/0 | 41/0 | 41/0 | 41/0 |
| exploits | 40/0 | 40/0 | 40/0 | 40/0 |
| exploration | 34/0 | 34/0 | 34/0 | 34/0 |
| fixes | 21/0 | 21/0 | 21/0 | 21/0 |
| food | 31/0 | 31/0 | 31/0 | 31/0 |
| guide | 4/0 | 4/0 | 4/0 | 4/0 |
| logistics | 44/0 | 44/0 | 44/0 | 44/0 |
| machines | 60/0 | 60/0 | 60/0 | 60/0 |
| map | 12/0 | 12/0 | 12/0 | 12/0 |
| ownership | 15/0 | 15/0 | 15/0 | 15/0 |
| polish | 39/0 | 39/0 | 39/0 | 39/0 |
| powerfix | 10/0 | 10/0 | 10/0 | 10/0 |
| progression | 16/0 | 16/0 | 16/0 | 16/0 |
| quality | 8/0 | 8/0 | 8/0 | 8/0 |
| state gun | 22/0 | 22/0 | 22/0 | 22/0 |
| style | 85/0 | 85/0 | 85/0 | 85/0 |
| vehicles | 19/0 | 19/0 | 19/0 | 19/0 |
| world break | 9/0 | 9/0 | 9/0 | 9/0 |
| world clump | 5/0 | 5/0 | 5/0 | 5/0 |
| world deployer | 2/0 | 2/0 | 2/0 | 2/0 |
| world drops | 21/0 | 21/0 | 21/0 | 21/0 |
| world pads | 15/0 | 15/0 | 15/0 | 15/0 |
| world regrow | 10/0 | 10/0 | 10/0 | 10/0 |
| world restart setup | 1/0 | 1/0 | 1/0 | 1/0 |

## terralith

### Worldgen: settling before the save

SIFTEC's pieces (ore nodes, collectibles) are placed by the harness before the first tick, while every generated chunk is loaded; the save waits for the light engine and SIFTEC's own queue. Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | chunks given SIFTEC pieces | light quiet at tick | then: SIFTEC queue / generated chunks unloaded | saved at tick | at the save: queue / unloaded |
|---|---|---|---|---|---|
| vanilla-a | 0 | 20 | 0 / 0 | 40 | 0 / 0 |
| vanilla-b | 0 | 20 | 0 / 0 | 40 | 0 / 0 |
| vanilla-c | 0 | 20 | 0 / 0 | 40 | 0 / 0 |
| quicksilver | 0 | 20 | 0 / 0 | 40 | 0 / 0 |

### Worldgen (byte for byte)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |

Keys compared: chunks. Noise examples in terralith-genbytes-noise-b.json and -noise-c.json.

### Worldgen (block by block)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |

Keys compared: blocks, block entities, scheduled ticks, entities. Noise examples in terralith-gen-noise-b.json and -noise-c.json.


### Heap run (live heap after a full GC, MiB; ten minutes of game time)

| run | after load | after 10 min | finished |
|---|---|---|---|
| vanilla-a | 152.342 | 153.063 | yes |
| vanilla-b | 151.913 | 152.777 | yes |
| vanilla-c | 152.185 | 152.904 | yes |
| quicksilver | 140.768 | 141.561 | yes |
Heap after load: Quicksilver 140.8 MiB, vanilla 151.9 to 152.3 MiB (11.1 MiB, 7% below the lowest)
Heap after ten minutes: Quicksilver 141.6 MiB, vanilla 152.8 to 153.1 MiB (11.2 MiB, 7% below the lowest)

Where it goes: terralith-heap.md.

## Network check

| run | client joined | run finished | client left early | protocol problems | server bytes in/out |
|---|---|---|---|---|---|
| net-vanilla-client | True | True | False | 0 | 6331/2481796 |
| net-qs-client | True | True | False | 0 | -/- |

## Result

**PASS**
