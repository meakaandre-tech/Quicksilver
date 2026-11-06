# Server suite (phase 2)

Mode: quick (suites expected: core, siftec; quick mode runs core only)

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

### World diff after the border run

| dimension | chunks | vanilla noise (a vs b, a vs c) | quicksilver vs vanilla-a | quicksilver where vanilla agrees |
|---|---|---|---|---|
| dimensions/minecraft/overworld/region | 1764 | 0 | 0 | 0 |

Keys compared: blocks, block entities, entity types. Noise examples in core-border-noise-b.json and -noise-c.json.

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
| vanilla-a | yes | 4 | 1.447 | 7.643 | 1 | 150.901 | 151.492 | 9689 | 562 |
| vanilla-b | yes | 3 | 1.852 | 11.369 | 2 | 151.133 | 151.672 | 12299 | 539 |
| vanilla-c | yes | 3 | 1.805 | 12.455 | 2 | 150.929 | 151.455 | 12912 | 541 |
| quicksilver | yes | 3 | 1.627 | 9.528 | 1 | 140.443 | 142.763 | 12870 | 591 |

### Random-tick run

| run | finished | random ticks, pins and spawns |
|---|---|---|
| vanilla-a | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |
| vanilla-b | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |
| vanilla-c | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |
| quicksilver | yes | positions=122035 ticks=892 sectionsOn=4501 sectionsOff=259054 precipOn=2021 precipOff=29994 monsters=4 creatures=0 |

### Border run (chunk watch)

| run | finished | changes | first difference from vanilla-a |
|---|---|---|---|
| vanilla-a | yes | 1241 | none |
| vanilla-b | yes | 1241 | none |
| vanilla-c | yes | 1241 | none |
| quicksilver | yes | 1241 | none |

Every run's history in core-border-watch.txt.

### Heap run (live heap after a full GC, MiB; ten minutes of game time)

| run | after load | after 10 min | finished |
|---|---|---|---|
| vanilla-a | 149.761 | 150.57 | yes |
| vanilla-b | 149.4 | 150.451 | yes |
| vanilla-c | 149.472 | 150.307 | yes |
| quicksilver | 139.04 | 140.116 | yes |
Heap after load: Quicksilver 139.0 MiB, vanilla 149.4 to 149.8 MiB (10.4 MiB, 7% below the lowest)
Heap after ten minutes: Quicksilver 140.1 MiB, vanilla 150.3 to 150.6 MiB (10.2 MiB, 7% below the lowest)

Where it goes: core-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1003, "tps": 20.06, "msptAvg": 1.771, "msptP50": 1.198, "msptP99": 12.459, "msptMax": 72.795, "ticksOver50ms": 1, "heapUsedMB": 229.635, "heapUsedAfterGcMB": 143.754, "startupMs": 15202, "worldLoadMs": 2921, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

## siftec

### Worldgen: settling before the save

SIFTEC's pieces (ore nodes, collectibles) are placed by the harness before the first tick, while every generated chunk is loaded; the save waits for the light engine and SIFTEC's own queue. Where the harness used to stop (light quiet for 20 ticks) is shown for the record.

| run | chunks given SIFTEC pieces | light quiet at tick | then: SIFTEC queue / generated chunks unloaded | saved at tick | at the save: queue / unloaded |
|---|---|---|---|---|---|
| vanilla-a | 6 | 20 | 0 / 0 | 50 | 0 / 0 |
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
| vanilla-a | yes | 4 | 1.55 | 7.464 | 2 | 279.332 | 279.784 | 13371 | 425 |
| vanilla-b | yes | 5 | 2.125 | 11.018 | 2 | 279.493 | 280.336 | 18575 | 531 |
| vanilla-c | yes | 3 | 2.014 | 9.184 | 2 | 278.999 | 279.964 | 11742 | 397 |
| quicksilver | yes | 4 | 2.055 | 12.123 | 2 | 218.132 | 220.717 | 20438 | 545 |

### Heap run (live heap after a full GC, MiB; ten minutes of game time)

| run | after load | after 10 min | finished |
|---|---|---|---|
| vanilla-a | 277.434 | 278.348 | yes |
| vanilla-b | 277.564 | 278.764 | yes |
| vanilla-c | 278.051 | 279.333 | yes |
| quicksilver | 216.675 | 217.955 | yes |
Heap after load: Quicksilver 216.7 MiB, vanilla 277.4 to 278.1 MiB (60.8 MiB, 22% below the lowest)
Heap after ten minutes: Quicksilver 218.0 MiB, vanilla 278.3 to 279.3 MiB (60.4 MiB, 22% below the lowest)

Where it goes: siftec-heap.md.

Quicksilver server bench: `{"side": "dedicated", "ticks": 1004, "tps": 20.08, "msptAvg": 2.28, "msptP50": 1.556, "msptP99": 11.707, "msptMax": 151.758, "ticksOver50ms": 2, "heapUsedMB": 469.796, "heapUsedAfterGcMB": 221.769, "startupMs": 22945, "worldLoadMs": 3050, "network": {"counting": true, "serverBytesInWindow": 0, "serverBytesIn": 0, "serverBytesOut": 0, "clientBytesIn": 0, "clientBytesOut": 0}, "players": 0}`

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

## Network check

| run | client joined | run finished | client left early | protocol problems | server bytes in/out |
|---|---|---|---|---|---|
| net-vanilla-client | True | True | False | 0 | 6364/2519872 |
| net-qs-client | True | True | False | 0 | -/- |

## Result

**PASS**
