# Server suite (phase 2)

Mode: quick (suites expected: core; quick mode runs core only)

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
| vanilla-a | yes | 3 | 1.922 | 10.796 | 2 | 150.882 | 151.471 | 12305 | 690 |
| vanilla-b | yes | 11 | 1.741 | 7.918 | 1 | 150.602 | 151.26 | 8372 | 400 |
| vanilla-c | yes | 4 | 1.138 | 4.882 | 1 | 149.928 | 150.449 | 7375 | 373 |
| quicksilver | yes | 4 | 1.461 | 6.292 | 1 | 138.803 | 141.216 | 10273 | 442 |

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
| vanilla-a | 149.584 | 150.333 | yes |
| vanilla-b | 149.404 | 150.007 | yes |
| vanilla-c | 147.982 | 148.786 | yes |
| quicksilver | 138.616 | 139.436 | yes |
Heap after load: Quicksilver 138.6 MiB, vanilla 148.0 to 149.6 MiB (9.4 MiB, 6% below the lowest)
Heap after ten minutes: Quicksilver 139.4 MiB, vanilla 148.8 to 150.3 MiB (9.3 MiB, 6% below the lowest)

Where it goes: core-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1003, "tps": 20.06, "msptAvg": 1.595, "msptP50": 1.135, "msptP99": 8.385, "msptMax": 85.641, "ticksOver50ms": 1, "heapUsedMB": 203.352, "heapUsedAfterGcMB": 142.208, "startupMs": 12257, "worldLoadMs": 2425, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

## Network check

| run | client joined | run finished | client left early | protocol problems | server bytes in/out |
|---|---|---|---|---|---|
| net-vanilla-client | True | True | False | 0 | 6300/2603583 |
| net-qs-client | True | True | False | 0 | -/- |

## Result

**PASS**
