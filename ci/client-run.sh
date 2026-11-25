#!/bin/bash
# One CI client run: SUITE (core) x RUN (vanilla-a | vanilla-b | vanilla-old | vanilla-vk | quicksilver-full |
# quicksilver-old | quicksilver-vk | quicksilver-2p-old | measure-full | measure-old | measure-vk). measure runs load Quicksilver with every module
# off (quicksilver.ci.measureOnly): vanilla draws everything and Quicksilver's bench measures it, in the same profile as the
# Quicksilver run of the same name (package 3).
#
# Starts the suite's server (core: a plain Fabric server with Fabric API, seed 12345, the core-world job's world), then
# one dev client per session (render distance, client options and shard of the suite's scenes), drives the scenes
# (ci/drive.py), and leaves everything in $OUT.
# SHARD (package L): 1 or 2 runs only the sessions of that shard (scene key "ciShard", default 1), so one run's scenes are
# split over two jobs; every run, vanilla and Quicksilver alike, is split the same way. Unset or 0: every session.
# Sessions keep one numbering over both shards (client-<n>.log), so the two jobs' files never collide. Quicksilver runs put the built jar in the client's and
# the server's mods; vanilla runs have no Quicksilver anywhere (the dev classpath's own copy is emptied out first).
# old runs hide multi-draw indirect and buffer storage and force GL down to vanilla's minimum (3.3); the Quicksilver old
# run also sets quicksilver.debug.forceIntelMdiIssue (vanilla's Intel multi-draw-indirect flag, the school laptop's path).
# vk runs use Mesa's Vulkan driver (lavapipe) through the --graphicsBackend launch argument.
set +e
# package 4c: the single-player run has its own script (no dedicated server, the client's integrated one)
case "$RUN" in sp-*) exec bash ci/sp-run.sh;; esac
root=$PWD
OUT=${OUT:-/tmp/out}
BENCH_SECONDS=${BENCH_SECONDS:-20}
mkdir -p "$OUT"
SHARD=${SHARD:-0}
sfx=""; [ "$SHARD" -gt 1 ] && sfx="-$SHARD"
exec > >(tee "$OUT/run$sfx.txt") 2>&1
echo "suite=$SUITE run=$RUN shard=$SHARD"
mc=$(grep '^minecraft_version' gradle.properties | sed 's/.*= *//')
loader=$(grep '^loader_version' gradle.properties | sed 's/.*= *//')
fapi=$(grep '^fabric_version' gradle.properties | sed 's/.*= *//')
suitefile=src/main/resources/quicksilver/scenes/$SUITE.json

case "$RUN" in quicksilver-*|measure-*|speed-*|preset-*) qs=1;; *) qs=0;; esac
# package 9: preset-low-old / preset-balanced-old / preset-quality-old: Quicksilver on the old-GPU profile (the laptop's
# plain path) with "preset=<preset>" in its config file, in PRESET_SCENES only, shots only (no bench, so none of the
# verify* checks, whose results go to the bench: only the upload-queue log the driver waits on); ci/preset-compare.py
# compares the shots with vanilla-old's. The balanced run also runs the
# options screen's test after its scenes (settings/ScreenTest, with Mod Menu loaded) and takes its screenshot.
preset=""
case "$RUN" in preset-*) preset=${RUN#preset-}; preset=${preset%-old}; [ "$preset" = low ] && preset=low-end;; esac
# package A: speed-old / speed-full run Quicksilver with its defaults and the speed bench (bench/SpeedBench: a stage
# profile, then each scene's "speedAb" switches off against on, frame limit and vsync off) in the scenes that list
# switches, in the old-GPU or full profile; no CI checks (verify*) that would slow the frames; not gated on pictures
# (ci/speed-compare.py reads bench/speed/*.json)
case "$RUN" in speed-*) speed=1;; *) speed=0;; esac
# package 4b: bench-plain / bench-sodium load only the bench-only jar (quicksilver-bench, every Quicksilver module out),
# on plain Fabric or next to Sodium, and bench the scenes in BENCH_SCENES; the server has no Quicksilver
case "$RUN" in bench-*) benchonly=1;; *) benchonly=0;; esac
case "$RUN" in measure-*) measure=1;; *) measure=0;; esac
case "$RUN" in *-old)
  export MESA_EXTENSION_OVERRIDE="-GL_ARB_multi_draw_indirect -GL_ARB_buffer_storage"
  export MESA_GL_VERSION_OVERRIDE=3.3
  export MESA_GLSL_VERSION_OVERRIDE=330
  echo "old-GPU profile: MESA_EXTENSION_OVERRIDE='$MESA_EXTENSION_OVERRIDE' MESA_GL_VERSION_OVERRIDE=3.3 MESA_GLSL_VERSION_OVERRIDE=330";;
esac
extra_args=""
client_jvm=""
case "$RUN" in *-vk) extra_args="--graphicsBackend vulkan"; echo "Vulkan profile: --graphicsBackend vulkan on lavapipe";; esac
case "$RUN" in quicksilver-old|quicksilver-2p-old|measure-old|speed-old|preset-*-old) client_jvm="-Dquicksilver.debug.forceIntelMdiIssue=true"; echo "old-GPU Quicksilver run: $client_jvm";; esac
# package 2b (Andre, 2026-11-02): one more old-GPU run with occlusion culling forced to two-phase (auto is still-camera
# on that path), so the laptop's plain path is tested with the CPU waiting for the GPU too
case "$RUN" in quicksilver-2p-old) client_jvm="$client_jvm -Dquicksilver.occlusion=two-phase"; echo "two-phase occlusion run: $client_jvm";; esac
# every Quicksilver run: the visibility module checks each entity and block entity it hides with rays from the camera
# (package 2's pop-in check; ci/compare.py fails on any violation). VISIBILITY_DRY_RUN=1 makes it decide and count but hide
# nothing (used once to sample the new occlusion scene's noise with Quicksilver drawing exactly vanilla's set).
# every Quicksilver run also checks its translucent draws each frame against vanilla's order and latest sort (package 3;
# ci/compare.py fails on any miss). TRANSLUCENCY_DRY_RUN=1 leaves translucent terrain with vanilla (noise collection only).
# and every Quicksilver run runs the renderer's self-test once in the world (package 4; ci/compare.py requires "passed").
if [ $speed = 1 ]; then
  client_jvm="$client_jvm -Dquicksilver.ci.speed=true"
  echo "speed run JVM properties:$client_jvm"
elif [ $measure = 1 ]; then
  client_jvm="$client_jvm -Dquicksilver.ci.measureOnly=true"
  echo "measure run JVM properties:$client_jvm"
elif [ -n "$preset" ]; then
  client_jvm="$client_jvm -Dquicksilver.debug.logUploadQueue=true"
  [ "$preset" = balanced ] && client_jvm="$client_jvm -Dquicksilver.ci.screenTest=true"
  echo "preset run JVM properties:$client_jvm"
elif [ $qs = 1 ]; then
  # package 8: the animation module logs each animated sprite's first use outside terrain, with where it came from
  # package 4b: the terrain upload budget logs when meshes wait for a later frame and when it has caught up, so
  # drive.py takes no screenshot while a section is still waiting (vanilla uploads at once and logs nothing)
  # package 4c: every section meshed outside a bench is also meshed by vanilla's compiler and compared, vertex by vertex
  client_jvm="$client_jvm -Dquicksilver.debug.logUploadQueue=true -Dquicksilver.debug.verifyVisibility=true -Dquicksilver.debug.verifyTranslucency=true -Dquicksilver.debug.verifyRenderer=true -Dquicksilver.debug.animationUses=true -Dquicksilver.debug.verifyMesher=true -Dquicksilver.debug.verifyOcclusion=true"
  if [ "${VISIBILITY_DRY_RUN:-0}" = 1 ]; then client_jvm="$client_jvm -Dquicksilver.debug.visibilityDryRun=true"; fi
  if [ "${TRANSLUCENCY_DRY_RUN:-0}" = 1 ]; then client_jvm="$client_jvm -Dquicksilver.debug.translucencyDryRun=true"; fi
  echo "Quicksilver run JVM properties:$client_jvm"
fi

# ---- server
if [ -d core-server ]; then
  # the core world, generated once per CI run by ci/core-world.sh, so every run loads the same chunks
  cp -r core-server server
  echo "core server and world: from the core-world job"
else
  mkdir -p server/mods
  inst=$(curl -fsSL https://meta.fabricmc.net/v2/versions/installer | python3 -c "import json,sys; print(json.load(sys.stdin)[0]['version'])")
  curl -fsSL -o server/server.jar "https://meta.fabricmc.net/v2/versions/loader/$mc/$loader/$inst/server/jar"
  fapiurl=$(curl -fsSL "https://api.modrinth.com/v2/project/fabric-api/version" | python3 -c "import json,sys; v=[x for x in json.load(sys.stdin) if x['version_number']=='$fapi']; print(v[0]['files'][0]['url'])")
  curl -fsSL -o server/mods/fabric-api.jar "$fapiurl"
  echo "eula=true" > server/eula.txt
fi
if [ $qs = 1 ]; then cp dist/quicksilver.jar server/mods/; fi
# package A: the Create + Flywheel smoke job (suite create): Create Fly, which carries Flywheel, on the server and the
# client (the client gets every server jar but Fabric API, below)
packset=core
if [ "$SUITE" = create ]; then
  packset=create
  PACK_CHECK=partial PACK_REPORT="$OUT/pack-sha256.txt" bash ci/pack-fetch.sh create /tmp/create-jars || { echo "could not fetch Create Fly, or it changed (see above)"; exit 1; }
  cp /tmp/create-jars/*.jar server/mods/
fi
# package 5: CI's pin mod on the server too, in every run alike, for its /qsci command (the kinetics scene's belt and
# train, which Create has no command for); its mixins are client-only and its command needs Create, so the core
# suite's server and every other scene are unchanged
if [ -f ci-pin/ci-pin.jar ]; then cp ci-pin/ci-pin.jar server/mods/; fi
# measure runs stand in for vanilla, so Fabric's Indigo draws there as in the vanilla runs: their copy of the jar does
# not declare fabric-renderer-api-v1:contains_renderer (and Quicksilver does not register its renderer, measureOnly)
if [ $measure = 1 ]; then
  python3 -I - server/mods/quicksilver.jar <<'PY' || { echo "could not take contains_renderer out of the measure run's jar"; exit 1; }
import json, os, sys, zipfile
jar = sys.argv[1]
src = zipfile.ZipFile(jar)
out = zipfile.ZipFile(jar + ".tmp", "w", zipfile.ZIP_DEFLATED)
for item in src.infolist():
    data = src.read(item.filename)
    if item.filename == "fabric.mod.json":
        meta = json.loads(data)
        del meta["custom"]["fabric-renderer-api-v1:contains_renderer"]
        data = json.dumps(meta, indent=2).encode()
    out.writestr(item, data)
out.close()
os.replace(jar + ".tmp", jar)
print("measure run: contains_renderer taken out of the jar's fabric.mod.json (Indigo draws)")
PY
fi
# the pack lock (ci/pack-lock.txt): this run's server jars, as checked in the world jobs (the hashes go to the logs)
bash ci/pack-check.sh server/mods $packset complete "$OUT/pack-sha256.txt" || { echo "the pack changed (see above)"; exit 1; }
cd server
# a view distance that covers the 12-chunk fly-through and no console echo in chat
printf 'level-seed=12345\nwhite-list=false\nenforce-whitelist=false\nonline-mode=false\nmax-tick-time=-1\nview-distance=12\ngamemode=creative\ndifficulty=peaceful\nspawn-protection=0\npause-when-empty-seconds=-1\nbroadcast-console-to-ops=false\n' > server.properties
ls -l mods
rm -f in.fifo; mkfifo in.fifo
(java -Xmx3G -jar server.jar --nogui < in.fifo > server.log 2>&1; echo "EXIT $?" >> server.log) &
exec 3> in.fifo
for i in $(seq 1 120); do
  if grep -q 'Done (' server.log || grep -q '^EXIT' server.log; then break; fi
  sleep 5
done
cd "$root"
if ! grep -q 'Done (' server/server.log; then echo "server did not start"; cp server/server.log "$OUT/server$sfx.log"; exit 1; fi

# ---- client
sudo apt-get update -q >/dev/null 2>&1
sudo apt-get install -y -q xvfb xdotool x11-utils imagemagick libgl1-mesa-dri libglx-mesa0 libegl1 libegl-mesa0 libgles2 mesa-utils mesa-vulkan-drivers libvulkan1 vulkan-tools python3-numpy python3-pil >/dev/null 2>&1
lvp=$(ls /usr/share/vulkan/icd.d/lvp_icd*.json 2>/dev/null | head -1)
case "$RUN" in *-vk) [ -n "$lvp" ] && export VK_DRIVER_FILES="$lvp" VK_ICD_FILENAMES="$lvp";; esac
mkdir -p run/mods
for j in server/mods/*.jar; do case "$j" in *fabric-api*) ;; *) cp "$j" run/mods/;; esac; done
if [ $benchonly = 1 ]; then
  [ -f dist/quicksilver-bench.jar ] || { echo "dist/quicksilver-bench.jar missing"; exit 1; }
  cp dist/quicksilver-bench.jar run/mods/
  if [ "$RUN" = bench-sodium ]; then
    # Sodium 0.9.2 for this Minecraft version, pinned in ci/pack-sources.txt and locked (a runtime test only: nothing of
    # Sodium's is in the repo)
    PACK_REPORT="$OUT/pack-sha256.txt" bash ci/pack-fetch.sh sodium /tmp/sodium-check || { echo "could not fetch Sodium, or it changed (see above)"; exit 1; }
    cp /tmp/sodium-check/sodium.jar run/mods/
  fi
fi
# package 9: Mod Menu in the balanced preset run (the options screen's test opens the screen through Mod Menu's factory)
if [ "$preset" = balanced ]; then
  if PACK_REPORT="$OUT/pack-sha256-modmenu.txt" bash ci/pack-fetch.sh modmenu /tmp/modmenu; then cp /tmp/modmenu/*.jar run/mods/
  else echo "Mod Menu: not fetched or not as locked (see above); the screen test skips it"; fi
fi
# every run, vanilla and Quicksilver alike: CI's lightmap pin (ci/pin-mod), which holds the block-light flicker still
if [ -f ci-pin/ci-pin.jar ]; then cp ci-pin/ci-pin.jar run/mods/; else echo "ci-pin.jar missing"; exit 1; fi
ls -l run/mods
# mod ids the client loads (pack jars plus the dev classpath's Minecraft, loader and Fabric API), for scenes that need one
(for j in run/mods/*.jar; do unzip -p "$j" fabric.mod.json 2>/dev/null | python3 -c "import json,sys; print(json.load(sys.stdin)['id'])" 2>/dev/null; done; echo minecraft fabricloader fabric-api) > "$OUT/mod-ids.txt"
export MOD_IDS="$OUT/mod-ids.txt"
# the dev classpath must not carry Quicksilver: every run loads it from run/mods or not at all
rm -rf build/classes/java/main build/resources/main
mkdir -p build/classes/java/main build/resources/main
export LIBGL_ALWAYS_SOFTWARE=1
# MC 26.3 (SDL3) asks for an sRGB-capable framebuffer; Xvfb's GLX visuals have none, EGL does
export SDL_VIDEO_FORCE_EGL=1
Xvfb :99 -screen 0 1280x720x24 >/dev/null 2>&1 &
export DISPLAY=:99
sleep 2
(glxinfo -B; eglinfo -B 2>/dev/null | head -60; vulkaninfo --summary 2>/dev/null | head -60) > "$OUT/gfx.txt" 2>&1
echo "op @a" >&3

# one client session per render distance and set of client options (package 3: scenes with "clientOptions", e.g.
# Improved Transparency, get their own session with those lines in options.txt; the same in every run; package 4:
# "quicksilverConfig", e.g. the block renderer off, likewise, written to config/quicksilver.properties)
groups=$(python3 -c "
import json; s=json.load(open('$suitefile'))
rd={}
for x in s['scenes']:
    o=dict(x.get('clientOptions') or {}); o.update({'quicksilver.'+k: v for k,v in (x.get('quicksilverConfig') or {}).items()}); o.update({'flywheel.'+k: v for k,v in (x.get('flywheelConfig') or {}).items()})
    opts=','.join(k+'='+str(v) for k,v in sorted(o.items()))
    rd.setdefault((x.get('ciShard',1), x.get('renderDistance',8), opts),[]).append(x['id'])
print(' '.join(str(k[0])+'|'+str(k[1])+'|'+(k[2] or '-')+'|'+','.join(v) for k,v in sorted(rd.items())))")
echo "sessions: $groups"
n=0
for g in $groups; do
  n=$((n+1))
  shard=${g%%|*}; g=${g#*|}
  rd=${g%%|*}; rest=${g#*|}; opts=${rest%%|*}; ids=$(echo "${rest#*|}" | tr ',' ' ')
  if [ "$SHARD" -gt 0 ] && [ "$shard" != "$SHARD" ]; then echo "session $n: shard $shard, not this job's"; continue; fi
  if [ $speed = 1 ]; then
    keep=""
    for id in $ids; do
      python3 -c "import json,sys; s=[x for x in json.load(open('$suitefile'))['scenes'] if x['id']=='$id']; sys.exit(0 if s and s[0].get('speedAb') else 1)" && keep="$keep $id"
    done
    ids=$(echo $keep)
    if [ -z "$ids" ]; then echo "session $n: no scene with speedAb, not started"; continue; fi
  fi
  if [ -n "$preset" ]; then
    keep=""
    for id in $ids; do case " ${PRESET_SCENES:-spawn flythrough water_glass nether mobs block_entities particles flat_plants} " in *" $id "*) keep="$keep $id";; esac; done
    ids=$(echo $keep)
    if [ -z "$ids" ]; then echo "session $n: no scene of PRESET_SCENES, not started"; continue; fi
  fi
  if [ $benchonly = 1 ]; then
    keep=""
    for id in $ids; do case " $BENCH_SCENES " in *" $id "*) keep="$keep $id";; esac; done
    ids=$(echo $keep)
    if [ -z "$ids" ]; then echo "session $n: no scene of BENCH_SCENES, not started"; continue; fi
  fi
  # clouds off: their position follows elapsed game time, which differs between runs, so they would only add noise
  # no version line: the file is datafixed from the oldest layout, where key codes are LWJGL2 numbers (22 = U)
  # glintSpeed 0 (package 7): the enchantment glint's texture offset follows the wall clock, so a glinting item (the MAM's
  # selected tab) was caught in a different phase in every run; at speed 0 it is still drawn, but holds still
  # menuBackgroundBlurriness 0 (package 7): the menu blur behind screens such as Create's Ponder index came out
  # differently on Vulkan than on OpenGL (433,000 pixels apart), which left the strict check blind on 63% of that screen
  # chatHeightFocused 0.25 (package 7): the open chat shows its last 6 lines only, so the SIFTEC hud scene's chat shows
  # its own lines and not the bench messages earlier scenes leave in Quicksilver runs
  # glDebugVerbosity 1 (the game's default, set explicitly): the GPU's high-severity debug messages, errors among them,
  # go to the log in every run alike; ci/compare.py compares their counts between Quicksilver and vanilla
  printf 'pauseOnLostFocus:false\nglDebugVerbosity:1\nonboardAccessibility:false\ntutorialStep:none\nnarrator:0\nrenderDistance:%s\nguiScale:2\nmaxFps:30\nsoundCategory_master:0.0\nrenderClouds:"false"\nglintSpeed:0.0\nmenuBackgroundBlurriness:0\nchatHeightFocused:0.25\nkey_key.use:22\n' "$rd" > run/options.txt
  # package 4: "quicksilverConfig" entries (quicksilver.<key>=<value>) go to Quicksilver's config file, the rest to options.txt
  # package 5: "flywheelConfig" entries (flywheel.<key>=<value>) go to Flywheel's client config (Create Fly's
  # run/config/flywheel-client.json), e.g. its backend forced to instancing; the file is removed for every other session
  mkdir -p run/config; rm -f run/config/quicksilver.properties run/config/flywheel-client.json
  [ -n "$preset" ] && echo "preset=$preset" > run/config/quicksilver.properties
  if [ "$opts" != "-" ]; then
    for kv in $(echo "$opts" | tr ',' ' '); do
      case "$kv" in
        quicksilver.*) k=${kv%%=*}; echo "${k#quicksilver.}=${kv#*=}" >> run/config/quicksilver.properties;;
        flywheel.*) k=${kv%%=*}; python3 -I -c 'import json,sys,os; p=sys.argv[1]; d=json.load(open(p)) if os.path.exists(p) else {}; d[sys.argv[2]]={"value": sys.argv[3]}; json.dump(d,open(p,"w"))' run/config/flywheel-client.json "${k#flywheel.}" "${kv#*=}";;
        *) echo "${kv%%=*}:${kv#*=}" >> run/options.txt;;
      esac
    done
    echo "session $n client options: $opts"
  fi
  # no game of an earlier session may still be running (see the wait after each session)
  if pgrep -f KnotClient >/dev/null; then echo "session $n: a game is still running before the start, killed"; pkill -9 -f KnotClient; sleep 2; fi
  rm -f run/logs/latest.log run/logs/*.log.gz run/logs/*.log
  : > "$OUT/joined-$n.txt"
  before=$(grep -c 'joined the game' server/server.log)
  # --username (package 7): the dev launcher otherwise names the player Player<random digits>, and the offline UUID
  # made from the name picks the default skin, so the first-person arm and SIFTEC's company name ("<player>'s
  # Company" on the HUB and MAM screens) differed between runs; one fixed name in every run
  (env -u CI JAVA_TOOL_OPTIONS="${client_jvm# }" timeout 2400 ./gradlew runClient --no-daemon -Dorg.gradle.console=plain -x compileJava -x processResources -x classes \
     --args="--quickPlayMultiplayer localhost --width 1280 --height 720 --username QuicksilverCI $extra_args" > "$OUT/client-gradle-$n.log" 2>&1; echo "EXIT $?" >> "$OUT/client-gradle-$n.log") &
  client_pid=$!
  for i in $(seq 1 150); do
    now=$(grep -c 'joined the game' server/server.log)
    if [ "$now" -gt "$before" ] || grep -q '^EXIT' "$OUT/client-gradle-$n.log"; then break; fi
    sleep 5
  done
  if [ "$(grep -c 'joined the game' server/server.log)" -gt "$before" ]; then
    echo "op @a" >&3
    sleep 40
    xdotool mousemove 640 360
    python3 -I ci/drive.py "$suitefile" server/in.fifo "$OUT" run/logs/latest.log "$([ -z "$preset" ] && { [ $qs = 1 ] || [ $benchonly = 1 ]; } && echo quicksilver || echo vanilla)" "$BENCH_SECONDS" $ids
    last_session=$n
  else
    echo "client did not join (session $n)"
    import -window root "$OUT/no-join-$n.png"
  fi
  # package 9: the options screen's test, in the balanced preset run's first session that ran (settings/ScreenTest): the command
  # first (the test checks it saved the file and the screen shows Custom), then the test, its screenshot at GUI scale 2
  if [ "$preset" = balanced ] && [ "${last_session:-}" = "$n" ] && [ -z "${screen_done:-}" ]; then
    screen_done=1
    chat9() { xdotool key slash; sleep 1.5; xdotool type --delay 40 "$1"; sleep 0.5; xdotool key Return; sleep 2; }
    start=$(stat -c %s run/logs/latest.log)
    chat9 "qs speed far-detail 6"
    chat9 "qs screentest"
    shot=0
    for i in $(seq 1 120); do
      sleep 2
      if [ $shot = 0 ] && tail -c +"$start" run/logs/latest.log | grep -q 'QUICKSILVER SCREEN TEST SHOT'; then
        sleep 4; xdotool mousemove 1 1; sleep 2; mkdir -p "$OUT/settings"; import -window root "$OUT/settings/settings-screen.png"; shot=1
      fi
      tail -c +"$start" run/logs/latest.log | grep -q 'QUICKSILVER SCREEN TEST END' && break
    done
    echo "screen test: $(tail -c +"$start" run/logs/latest.log | grep -o 'QUICKSILVER SCREEN TEST END.*' | tail -1) (shot taken: $shot)"
  fi
  # the session's game must be gone before its log is read and the next session starts: a game still shutting down
  # (pkill only asks) kept writing run/logs/latest.log by path, and run 45511522980's client-6.log, which crossed midnight
  # UTC while session 5's game was still exiting, held session 5's lines (its log rolled over into the next session's
  # file). Wait up to 60 s for it to exit, then kill it outright; then the Gradle launcher.
  pkill -f KnotClient
  for i in $(seq 1 60); do pgrep -f KnotClient >/dev/null || break; sleep 1; done
  if pgrep -f KnotClient >/dev/null; then echo "session $n: the game did not exit within 60 s, killed"; pkill -9 -f KnotClient; sleep 2; fi
  for i in $(seq 1 30); do kill -0 "$client_pid" 2>/dev/null || break; sleep 1; done
  sleep 2
  # the game rolls latest.log over at midnight (UTC on the runners) into a dated .log.gz: keep the session's rolled
  # parts in front of it, so client-$n.log is the whole session (run 40605316942 crossed midnight and lost them)
  # (one session is one game start: only the text from its last "Loading Minecraft" line on, since the game may also
  # archive a previous session's log into a .log.gz when it starts)
  # rolled parts in the order they were written (oldest first), not by name
  { for z in $(ls -tr run/logs/*.log.gz 2>/dev/null); do zcat "$z"; done; cat run/logs/latest.log 2>/dev/null; } \
    | awk '/Loading Minecraft .* with Fabric Loader/ {n++} {l[NR]=$0; s[NR]=n} END {for (i=1;i<=NR;i++) if (s[i]==n) print l[i]}' > "$OUT/client-$n.log"
  cp -r run/crash-reports "$OUT/client-crash-reports$sfx" 2>/dev/null
done
mkdir -p "$OUT/bench" && cp run/quicksilver/bench/*.json "$OUT/bench/" 2>/dev/null
if [ $speed = 1 ]; then mkdir -p "$OUT/speed" && cp run/quicksilver/bench/speed/*.json "$OUT/speed/" 2>/dev/null; fi
echo "stop" >&3
for i in $(seq 1 60); do grep -q '^EXIT' server/server.log && break; sleep 2; done
exec 3>&-
cp server/server.log "$OUT/server$sfx.log"
cp -r server/crash-reports "$OUT/server-crash-reports$sfx" 2>/dev/null
ls -R "$OUT" | head -80
exit 0
