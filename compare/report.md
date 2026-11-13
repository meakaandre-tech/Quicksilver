# Server suite (phase 2)

Mode: full (suites expected: core, pack, terralith; quick mode runs core only)

## core

### Worldgen: settling before the save

The save waits for the light engine (40 quiet ticks). Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | light quiet at tick | then: generated chunks unloaded | saved at tick | at the save: unloaded |
|---|---|---|---|---|
| vanilla-a | 20 | 0 | 40 | 0 |
| vanilla-b | 20 | 0 | 40 | 0 |
| vanilla-c | 20 | 0 | 40 | 0 |
| quicksilver | 20 | 0 | 40 | 0 |

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
| vanilla-a | yes | 2 | 1.337 | 10.511 | 2 | 151.02 | 151.584 | 12359 | 582 |
| vanilla-b | yes | 6 | 1.766 | 7.822 | 1 | 151.09 | 151.406 | 9264 | 500 |
| vanilla-c | yes | 2 | 1.589 | 6.963 | 1 | 151.328 | 151.896 | 9650 | 477 |
| quicksilver | yes | 4 | 1.655 | 7.194 | 1 | 139.088 | 140.949 | 8410 | 374 |

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
| vanilla-a | 148.161 | 148.868 | yes |
| vanilla-b | 147.705 | 148.52 | yes |
| vanilla-c | 149.678 | 150.492 | yes |
| quicksilver | 138.923 | 139.932 | yes |
Heap after load: Quicksilver 138.9 MiB, vanilla 147.7 to 149.7 MiB (8.8 MiB, 6% below the lowest)
Heap after ten minutes: Quicksilver 139.9 MiB, vanilla 148.5 to 150.5 MiB (8.6 MiB, 6% below the lowest)

Where it goes: core-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1003, "tps": 20.06, "msptAvg": 1.783, "msptP50": 1.314, "msptP99": 8.332, "msptMax": 76.756, "ticksOver50ms": 1, "heapUsedMB": 169.942, "heapUsedAfterGcMB": 141.942, "startupMs": 9825, "worldLoadMs": 1788, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

## pack

### Worldgen: settling before the save

The save waits for the light engine (40 quiet ticks). Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | light quiet at tick | then: generated chunks unloaded | saved at tick | at the save: unloaded |
|---|---|---|---|---|
| vanilla-a | 20 | 0 | 40 | 0 |
| vanilla-b | 20 | 0 | 40 | 0 |
| vanilla-c | 20 | 0 | 40 | 0 |
| quicksilver | 20 | 0 | 40 | 0 |

### Worldgen (byte for byte)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_nether/region | 144 | 0 | 0 | 0 |

Keys compared: chunks. Noise examples in pack-genbytes-noise-b.json and -noise-c.json.

### Worldgen (block by block)

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 144 | 0 | 0 | 0 |
| dimensions/minecraft/the_nether/region | 144 | 0 | 0 | 0 |

Keys compared: blocks, block entities, scheduled ticks, entities. Noise examples in pack-gen-noise-b.json and -noise-c.json.

### World diff after the scripted run

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 1764 | 0 | 0 | 0 |

Keys compared: blocks, block entities, entity types. Noise examples in pack-run-noise-b.json and -noise-c.json.

### Scripted run (relative only)

| run | finished | load wait (ticks) | mspt avg | mspt p99 | ticks over 50 ms | heap after load MB | heap end MB | start-up ms | world load ms |
|---|---|---|---|---|---|---|---|---|---|
| vanilla-a | yes | 3 | 1.882 | 8.589 | 1 | 331.845 | 332.792 | 13304 | 541 |
| vanilla-b | yes | 3 | 2.09 | 9.57 | 1 | 332.708 | 333.57 | 14701 | 495 |
| vanilla-c | yes | 4 | 1.751 | 8.684 | 1 | 332.777 | 333.703 | 16385 | 569 |
| quicksilver | yes | 3 | 1.786 | 8.096 | 1 | 231.035 | 233.937 | 13764 | 526 |

### Heap run (live heap after a full GC, MiB; ten minutes of game time)

| run | after load | after 10 min | finished |
|---|---|---|---|
| vanilla-a | 330.699 | 331.737 | yes |
| vanilla-b | 330.996 | 332.185 | yes |
| vanilla-c | 330.792 | 331.839 | yes |
| quicksilver | 229.243 | 230.807 | yes |
Heap after load: Quicksilver 229.2 MiB, vanilla 330.7 to 331.0 MiB (101.5 MiB, 31% below the lowest)
Heap after ten minutes: Quicksilver 230.8 MiB, vanilla 331.7 to 332.2 MiB (100.9 MiB, 30% below the lowest)

Where it goes: pack-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1004, "tps": 20.08, "msptAvg": 1.989, "msptP50": 1.437, "msptP99": 8.232, "msptMax": 111.546, "ticksOver50ms": 1, "heapUsedMB": 479.323, "heapUsedAfterGcMB": 235.231, "startupMs": 16641, "worldLoadMs": 3402, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

### Create train

| run | result |
|---|---|
| vanilla-a | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |
| vanilla-b | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |
| vanilla-c | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |
| quicksilver | arrivals=11 B@136,A@235,B@335,A@434,B@534,A@633,B@733,A@832,B@932,A@1031,B@1131 speed=0.31499999295920134 derailed=false entry=1 state=IN_TRANSIT |

## terralith

### Worldgen: settling before the save

The save waits for the light engine (40 quiet ticks). Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | light quiet at tick | then: generated chunks unloaded | saved at tick | at the save: unloaded |
|---|---|---|---|---|
| vanilla-a | 20 | 0 | 40 | 0 |
| vanilla-b | 20 | 0 | 40 | 0 |
| vanilla-c | 20 | 0 | 40 | 0 |
| quicksilver | 20 | 0 | 40 | 0 |

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
| vanilla-a | 152.507 | 153.245 | yes |
| vanilla-b | 150.422 | 151.285 | yes |
| vanilla-c | 152.26 | 153.371 | yes |
| quicksilver | 141.533 | 142.726 | yes |
Heap after load: Quicksilver 141.5 MiB, vanilla 150.4 to 152.5 MiB (8.9 MiB, 6% below the lowest)
Heap after ten minutes: Quicksilver 142.7 MiB, vanilla 151.3 to 153.4 MiB (8.6 MiB, 6% below the lowest)

Where it goes: terralith-heap.md.

## Network check

| run | client joined | run finished | client left early | protocol problems | server bytes in/out |
|---|---|---|---|---|---|
| net-vanilla-client | True | True | False | 0 | 6395/2520276 |
| net-qs-client | True | True | False | 0 | -/- |

## Result

**PASS**
