#!/bin/bash
# Builds SIFTEC's server and CI world in ./siftec-server, the way SIFTEC's own CI does: the pack of
# ci/pack-sources.txt (the pack-snapshot release and pinned third-party jars), then SIFTEC's .github/smoke-commands.txt
# on a fresh world, seed 12345. SIFTEC's .github files come from a read-only checkout of SIFTEC at the commit the
# snapshot's SIFTEC was built from (ci/pack-snapshot.txt).
set +e
root=$PWD
S=$root/siftec/.github
mkdir -p /tmp/out
exec > >(tee /tmp/out/siftec-world.txt) 2>&1
mc=$(grep '^minecraft_version' gradle.properties | sed 's/.*= *//')
loader=$(grep '^loader_version' gradle.properties | sed 's/.*= *//')
fapi=$(grep '^fabric_version' gradle.properties | sed 's/.*= *//')
mkdir -p siftec-server/mods && cd siftec-server
inst=$(curl -fsSL https://meta.fabricmc.net/v2/versions/installer | python3 -c "import json,sys; print(json.load(sys.stdin)[0]['version'])")
curl -fsSL -o server.jar "https://meta.fabricmc.net/v2/versions/loader/$mc/$loader/$inst/server/jar" || exit 1
fapiurl=$(curl -fsSL "https://api.modrinth.com/v2/project/fabric-api/version" | python3 -c "import json,sys; v=[x for x in json.load(sys.stdin) if x['version_number']=='$fapi']; print(v[0]['files'][0]['url'])")
curl -fsSL -o mods/fabric-api.jar "$fapiurl" || exit 1
# the pack (ci/pack-sources.txt, Andre 2026-11-01): SIFTEC, its self-test mod (siftec selftest / worldtest), MapMod and
# Andre's Create forks from this repo's pack-snapshot release; the third-party jars at pinned versions; all checked
# against ci/pack-lock.txt
bash "$root/ci/pack-fetch.sh" siftec mods || { echo "the pack changed or a jar is missing (see above)"; exit 1; }
ls -l mods
echo "eula=true" > eula.txt
printf 'level-seed=12345\nwhite-list=false\nenforce-whitelist=false\nonline-mode=false\nmax-tick-time=-1\nview-distance=6\ngamemode=creative\ndifficulty=peaceful\nspawn-protection=0\npause-when-empty-seconds=-1\n' > server.properties
mkfifo in.fifo
# a time limit: a mod that fails at start-up can leave the server's JVM up without ever finishing (run 41188443125)
(timeout -k 10 1500 java -Xmx3G -jar server.jar --nogui < in.fifo > server.log 2>&1; echo "EXIT $?" >> server.log) &
exec 3> in.fifo
for i in $(seq 1 120); do
  if grep -q 'Done (' server.log || grep -q '^EXIT' server.log; then break; fi
  # a mod failing at start-up (SIFTEC with a newer MapMod, 2026-10-31): stop now instead of waiting out the limit
  if grep -q 'Could not execute entrypoint stage' server.log; then echo "a mod failed at start-up:"; grep -m3 -E 'Could not execute|Caused by' server.log; pkill -f 'server.jar --nogui'; break; fi
  sleep 5
done
if grep -q 'Done (' server.log; then
  while read -r line; do case "$line" in "#sleep "*) sleep "${line#\#sleep }";; *) echo "$line" >&3; sleep 0.3;; esac; done < "$S/smoke-commands.txt"
  sleep 10
  # Quicksilver's own addition: generate the areas the SIFTEC scenes look at that SIFTEC's smoke run doesn't (The Sift
  # around 0,0 and the MAM platform), so every client run loads the same saved chunks instead of generating them
  echo "execute in the_sift:the_sift run forceload add -128 -128 127 127" >&3
  echo "execute in minecraft:overworld run forceload add 2128 -2064 2271 -1937" >&3
  # package 7: the map scene's area round 300 -200 (what the fullscreen map shows at its scale, with room), so its
  # terrain is the same saved chunks in every run instead of generated (and recorded by SIFTEC's map) in each
  echo "execute in minecraft:overworld run forceload add 96 -400 255 -1" >&3
  echo "execute in minecraft:overworld run forceload add 256 -400 415 -1" >&3
  echo "execute in minecraft:overworld run forceload add 416 -400 511 -1" >&3
  sleep 210
  echo "execute in the_sift:the_sift run forceload remove all" >&3
  echo "execute in minecraft:overworld run forceload remove 2128 -2064 2271 -1937" >&3
  echo "execute in minecraft:overworld run forceload remove 96 -400 255 -1" >&3
  echo "execute in minecraft:overworld run forceload remove 256 -400 415 -1" >&3
  echo "execute in minecraft:overworld run forceload remove 416 -400 511 -1" >&3
  # package 7: no random ticks and no mob griefing in the CI world (water freezing over, grass and leaves changing at
  # random, sheep eating grass: one of the map's pixels changed colour in one run), in vanilla's runs as much as
  # Quicksilver's, so what each scene shows doesn't depend on how long a run has been going
  echo "gamerule random_tick_speed 0" >&3
  echo "gamerule mob_griefing false" >&3
  echo "save-all flush" >&3
  sleep 20
  echo "stop" >&3
  for i in $(seq 1 90); do grep -q '^EXIT' server.log && break; sleep 2; done
fi
exec 3>&-
rm -f in.fifo
cp server.log /tmp/out/siftec-world-server.log
grep -q 'Done (' server.log || exit 1
du -sh world mods
