#!/usr/bin/env python3
"""Writes the GameTest suite's empty structures (each test builds its machine in code) as SNBT, and its test
environments (data/ci_server_harness/test_environment/).

usage: make-structures.py OUT_DIR   (OUT_DIR = .../data/ci_server_harness/gametest/structure)
Same layout as Fabric API's own empty test structure: an old DataVersion (the game upgrades it on load) and every
position listed as air.
"""
import os
import sys

SIZES = {"box8": (8, 8, 8), "box16": (16, 8, 16), "tall": (5, 32, 5)}

out = sys.argv[1]
os.makedirs(out, exist_ok=True)
for name, (sx, sy, sz) in SIZES.items():
    rows = ",\n".join('        {pos: [%d, %d, %d], state: "minecraft:air"}' % (x, y, z)
                      for x in range(sx) for y in range(sy) for z in range(sz))
    with open(os.path.join(out, name + ".snbt"), "w") as f:
        f.write("{\n    DataVersion: 2730,\n    size: [%d, %d, %d],\n    data: [\n%s\n    ],\n    entities: [],\n"
                "    palette: [\n        \"minecraft:air\"\n    ]\n}\n" % (sx, sy, sz, rows))
    print("structure", name, sx, sy, sz)

# fix-villager-flake: villager_trade runs in a GameTest batch of its own (tests are batched by environment), so no other
# test draws on the level's shared random while it runs; the environment also sets a fixed time of day at the batch's
# start (a villager's schedule follows it)
env = os.path.join(os.path.dirname(os.path.dirname(os.path.normpath(out))), "test_environment")
os.makedirs(env, exist_ok=True)
with open(os.path.join(env, "villager_alone.json"), "w") as f:
    f.write('{\n  "type": "minecraft:all_of",\n  "definitions": [\n    {"type": "minecraft:time_of_day", "time": 1000}\n  ]\n}\n')
print("test environment villager_alone")
