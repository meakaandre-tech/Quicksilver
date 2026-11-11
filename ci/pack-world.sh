#!/bin/bash
# Builds the popular-mods test pack's server and CI world in ./pack-server (2026-11-12, replacing SIFTEC's): the pack
# set of ci/pack-sources.txt (Create Fly from this repo's pack-snapshot release, the third-party mods at pinned
# Modrinth versions, all checked against ci/pack-lock.txt) on a fresh world, seed 12345, with the areas the pack scenes
# look at generated and saved, so every client run loads the same chunks (as ci/core-world.sh does for core).
set +e
root=$PWD
mkdir -p /tmp/out
exec > >(tee /tmp/out/pack-world.txt) 2>&1
mc=$(grep '^minecraft_version' gradle.properties | sed 's/.*= *//')
loader=$(grep '^loader_version' gradle.properties | sed 's/.*= *//')
fapi=$(grep '^fabric_version' gradle.properties | sed 's/.*= *//')
mkdir -p pack-server/mods && cd pack-server
inst=$(curl -fsSL https://meta.fabricmc.net/v2/versions/installer | python3 -c "import json,sys; print(json.load(sys.stdin)[0]['version'])")
curl -fsSL -o server.jar "https://meta.fabricmc.net/v2/versions/loader/$mc/$loader/$inst/server/jar" || exit 1
fapiurl=$(curl -fsSL "https://api.modrinth.com/v2/project/fabric-api/version" | python3 -c "import json,sys; v=[x for x in json.load(sys.stdin) if x['version_number']=='$fapi']; print(v[0]['files'][0]['url'])")
curl -fsSL -o mods/fabric-api.jar "$fapiurl" || exit 1
bash "$root/ci/pack-fetch.sh" pack mods || { echo "the pack changed or a jar is missing (see above)"; exit 1; }
ls -l mods
echo "eula=true" > eula.txt
printf 'level-seed=12345\nwhite-list=false\nenforce-whitelist=false\nonline-mode=false\nmax-tick-time=-1\nview-distance=8\ngamemode=creative\ndifficulty=peaceful\nspawn-protection=0\npause-when-empty-seconds=-1\n' > server.properties
mkfifo in.fifo
# a time limit: a mod that fails at start-up can leave the server's JVM up without ever finishing
(timeout -k 10 1500 java -Xmx3G -jar server.jar --nogui < in.fifo > server.log 2>&1; echo "EXIT $?" >> server.log) &
exec 3> in.fifo
for i in $(seq 1 120); do
  if grep -q 'Done (' server.log || grep -q '^EXIT' server.log; then break; fi
  if grep -q 'Could not execute entrypoint stage' server.log; then echo "a mod failed at start-up:"; grep -m3 -E 'Could not execute|Caused by' server.log; pkill -f 'server.jar --nogui'; break; fi
  sleep 5
done
# forceload takes at most 256 chunks per command: each area is cut into strips of whole chunks (as core-world.sh)
area() { # dimension x1 z1 x2 z2 (block coordinates, inclusive)
  python3 - "$@" <<'PY'
import sys
dim, x1, z1, x2, z2 = sys.argv[1], *map(int, sys.argv[2:])
cx1, cz1, cx2, cz2 = x1 >> 4, z1 >> 4, x2 >> 4, z2 >> 4
rows = cz2 - cz1 + 1
step = max(1, 256 // rows)
cx = cx1
while cx <= cx2:
    e = min(cx2, cx + step - 1)
    print(f"execute in {dim} run forceload add {cx*16} {cz1*16} {e*16+15} {cz2*16+15}")
    cx = e + 1
PY
}
if grep -q 'Done (' server.log; then
  {
    # every pack scene is round 2000..2300, -1985 (platforms high over Terralith's terrain, 8 chunks), and the
    # terrain scene at 600 300 (Terralith's land, 8 chunks)
    area minecraft:overworld 1856 -2128 2447 -1840
    area minecraft:overworld 456 156 743 443
  } > /tmp/out/pack-world-commands.txt
  while read -r line; do echo "$line" >&3; sleep 0.3; done < /tmp/out/pack-world-commands.txt
  sleep 300
  echo "execute in minecraft:overworld run forceload remove all" >&3
  # no random ticks and no mob griefing in the CI world, in vanilla's runs as much as Quicksilver's, so what each
  # scene shows doesn't depend on how long a run has been going (as SIFTEC's world, package 7)
  echo "gamerule random_tick_speed 0" >&3
  echo "gamerule mob_griefing false" >&3
  echo "save-all flush" >&3
  sleep 30
  echo "stop" >&3
  for i in $(seq 1 90); do grep -q '^EXIT' server.log && break; sleep 2; done
fi
exec 3>&-
rm -f in.fifo
cp server.log /tmp/out/pack-world-server.log
grep -q 'Done (' server.log || exit 1
du -sh world mods
