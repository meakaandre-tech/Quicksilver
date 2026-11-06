#!/bin/bash
# The chunk scenes (phase 2, P2-4): chunk loading and saving on the server thread, vanilla against Quicksilver on ONE
# runner, alternating as the perf job does (ci/server/perf-run.sh): rounds 1-7, vanilla first in odd rounds,
# Quicksilver first in even ones. Every round records Java Flight Recorder (Java and native samples of every thread
# every millisecond, allocation samples), summarised by ci/server/chunks-jfr.py over the run's ticks only; and its saved
# world as hashes (ci/server/regiondump.py, against the saved terrain it started from).
# SUITE: the scenes in ci/server/chunks-<SUITE>.txt on the saved terrain of ci/server/chunks-area-<SUITE>.txt, generated
# by vanilla once (the harness's gen mode; chunks-base.tar, kept by the workflow's cache while its inputs don't change).
# Every run loads the CI harness and runs with -Dmax.bg.threads=1, as the server suite does.
# Output: $OUT/<scene>/<side><round>/ (ci-harness-result.json, ticks.json, the server log, jfr.json, dump.json) and
# $OUT/base.json (the saved terrain's dump).
set +e
root=$PWD
SUITE=${SUITE:-core}
OUT=${OUT:-/tmp/sout/$SUITE-chunks}
ROUNDS=${ROUNDS:-7}
mkdir -p "$OUT"
exec > >(tee "$OUT/chunks.txt") 2>&1
spec=ci/server/chunks-$SUITE.txt
if [ ! -f "$spec" ]; then echo "no $spec: no chunk scenes for $SUITE"; exit 0; fi
echo "chunk scenes suite=$SUITE rounds=$ROUNDS"
srv=$root/srv
rm -rf "$srv"
bash ci/server/fetch-server.sh "$srv" || { echo "could not fetch the server"; exit 1; }
cp ci-server-harness/ci-server-harness.jar "$srv/mods/" || { echo "ci-server-harness.jar missing"; exit 1; }
[ -f dist/quicksilver.jar ] || { echo "dist/quicksilver.jar missing"; exit 1; }
nproc; grep -m1 'model name' /proc/cpuinfo; java -version 2>&1 | head -1

props() { # level-name difficulty
  printf 'level-seed=12345\nlevel-name=%s\nwhite-list=false\nenforce-whitelist=false\nonline-mode=false\nmax-tick-time=-1\npause-when-empty-seconds=-1\nspawn-protection=0\ndifficulty=%s\ngamemode=survival\nview-distance=6\nsimulation-distance=6\nsync-chunk-writes=true\n' "$1" "$2" > "$srv/server.properties"
}

# the saved terrain: vanilla, generated once (or from the workflow's cache)
if [ ! -f chunks-base.tar ]; then
  echo "== generating the saved terrain (ci/server/chunks-area-$SUITE.txt)"
  props chunksbase peaceful
  mkdir -p "$OUT/base"
  (cd "$srv" && timeout 3000 java -Xmx3G -Dmax.bg.threads=1 -Dci.harness.out="$OUT/base" \
     -Dci.harness.gen="$root/ci/server/chunks-area-$SUITE.txt" -jar server.jar --nogui < /dev/null > "$OUT/base-server.log" 2>&1
   echo "EXIT $?" >> "$OUT/base-server.log")
  grep -q 'CI HARNESS GEN DONE' "$OUT/base-server.log" || { echo "saved terrain: generation did not finish"; tail -n 20 "$OUT/base-server.log"; exit 1; }
  (cd "$srv" && rm -f chunksbase/session.lock && tar cf "$root/chunks-base.tar" chunksbase)
  rm -rf "$srv/chunksbase"
else
  echo "== saved terrain from the cache"
fi
ls -l chunks-base.tar
(cd "$srv" && tar xf "$root/chunks-base.tar") && python3 -I ci/server/regiondump.py "$srv/chunksbase" "$OUT/base.json"
rm -rf "$srv/chunksbase"

# the shapes of the methods P2-4's mixins target (CI SIG lines; a vanilla start of its own, not measured)
props world normal
(cd "$srv" && tar xf "$root/chunks-base.tar" && mv chunksbase world)
mkdir -p "$OUT/sig"
(cd "$srv" && timeout 600 java -Xmx3G -Dmax.bg.threads=1 -Dci.harness.out="$OUT/sig" -Dci.harness.run="$root/ci/server/chunks-sig.txt" \
   "-Dci.harness.signatures=net.minecraft.server.level.ChunkMap#save|saveChunkIfNeeded|saveAllChunks|saveChunksEagerly|processUnloads|scheduleUnload|scheduleChunkLoad|readChunk|protoChunkToFullChunk|write|flushWorker|markPosition,net.minecraft.world.level.chunk.storage.SerializableChunkData#copyOf|read|parse|write|*record|packStructureData|unpackStructureStart|saveTicks|makeBiomeCodec,net.minecraft.world.level.chunk.storage.IOWorker#store|loadAsync|synchronize|storePendingChunk|runStore|submitTask|scheduleWrite|tellStorePending,net.minecraft.world.level.chunk.storage.ChunkStorage#write|read|flushWorker|upgradeChunkTag,net.minecraft.world.level.chunk.storage.RegionFile#write|getChunkDataOutputStream|getChunkDataInputStream|flush|close|<init>,net.minecraft.world.level.chunk.storage.RegionFileStorage#write|read|getRegionFile|flush|<init>,net.minecraft.world.level.chunk.storage.RegionFileVersion#getCompressionFormat|wrap|getSelected|<init>,net.minecraft.server.MinecraftServer#autoSave|saveEverything|saveAllChunks|computeNextAutosaveInterval,net.minecraft.server.level.ServerLevel#save|saveLevelData,net.minecraft.world.level.chunk.LevelChunkSection#copy|<init>,net.minecraft.world.level.chunk.PalettedContainer#copy|<init>|pack|unpack|codecRW,net.minecraft.world.level.chunk.DataLayer#copy|<init>|isEmpty,net.minecraft.world.level.chunk.LevelChunk#postProcessGeneration|getBlockEntityNbtForSaving|runPostLoad|<init>|registerAllBlockEntitiesAfterLevelLoad,net.minecraft.world.level.chunk.ChunkAccess#getBlockEntityNbtForSaving|getTicksForSerialization|tryMarkSaved|markUnsaved|isUnsaved|getAllStarts|getPostProcessing,net.minecraft.world.entity.ai.village.poi.PoiManager#flush,net.minecraft.world.level.chunk.storage.SectionStorage#flush|flushAll|writeColumn|tick,net.minecraft.world.level.chunk.storage.EntityStorage#storeEntities|loadEntities|flush,net.minecraft.world.level.entity.PersistentEntitySectionManager#autoSave|saveAll|storeChunkSections,net.minecraft.server.level.DistanceManager#runAllUpdates" -jar server.jar --nogui < /dev/null > "$OUT/sig-server.log" 2>&1)
grep 'CI SIG' "$OUT/sig-server.log" | sed 's/.*CI SIG/CI SIG/'
rm -rf "$srv/world"

# one run: side (vanilla|quicksilver) round scene script ticks speed
one() {
  local side=$1 round=$2 scene=$3 script=$4 ticks=$5 speed=$6
  local dir="$OUT/$scene/$side$round"
  mkdir -p "$dir"
  rm -f "$srv/mods/quicksilver.jar"
  [ "$side" = quicksilver ] && cp dist/quicksilver.jar "$srv/mods/"
  rm -rf "$srv/world" "$srv/quicksilver" "$srv/crash-reports"
  (cd "$srv" && tar xf "$root/chunks-base.tar" && mv chunksbase world)
  props world normal
  cp "ci/server/$script" "$dir/script.txt"
  [ "$speed" = sprint ] && printf '\nat 0 tick sprint %s\n' "$ticks" >> "$dir/script.txt"
  local t0=$(date +%s)
  (cd "$srv" && timeout 1800 java -Xmx3G -Dmax.bg.threads=1 -Dci.harness.out="$dir" -Dci.harness.run="$dir/script.txt" \
     -Dci.harness.ticks="$ticks" \
     "-XX:StartFlightRecording=filename=$dir/rec.jfr,dumponexit=true,settings=profile,jdk.ExecutionSample#period=1ms,jdk.NativeMethodSample#period=1ms" \
     -jar server.jar --nogui < /dev/null > "$dir/server.log" 2>&1
   echo "EXIT $?" >> "$dir/server.log")
  python3 -c "
import json,sys
j=json.load(open(sys.argv[1]))
print('$scene $side r$round: mspt avg/p99/max', j.get('msptAvg'), j.get('msptP99'), j.get('msptMax'), 'over 50 ms', j.get('ticksOver50ms'), 'autosaves', [a.get('tick') for a in j.get('autosaves', []) if a.get('stage') == 'RUNNING'], j.get('chunks'), j.get('error',''))
" "$dir/ci-harness-result.json" 2>/dev/null || echo "$scene $side r$round: no result"
  echo "  ($(( $(date +%s) - t0 )) s)"
  grep -q 'CI HARNESS RUN DONE' "$dir/server.log" || { echo "  did not finish:"; tail -n 5 "$dir/server.log"; }
  if [ -f "$dir/rec.jfr" ]; then
    read -r a b < <(python3 -c "import json,sys; j=json.load(open(sys.argv[1])); print(j.get('runStartEpochMs',0), j.get('runEndEpochMs',0))" "$dir/ci-harness-result.json" 2>/dev/null)
    python3 -I ci/server/chunks-jfr.py "$dir/rec.jfr" "$dir/jfr.json" "$ticks" "${a:-0}" "${b:-0}" || echo "  jfr summary failed"
    rm -f "$dir/rec.jfr"
  else
    echo "  no JFR recording"
  fi
  python3 -I ci/server/regiondump.py "$srv/world" "$dir/dump.json" --base "$OUT/base.json" || echo "  region dump failed"
  cp -r "$srv/crash-reports" "$dir/crash-reports" 2>/dev/null
  rm -rf "$srv/world" "$srv/quicksilver" "$srv/crash-reports"
}

while read -r scene script ticks speed; do
  case "$scene" in ''|'#'*) continue;; esac
  echo "== scene $scene ($script, $ticks ticks, $speed)"
  for r in $(seq 1 "$ROUNDS"); do
    if [ $((r % 2)) = 1 ]; then first=vanilla; second=quicksilver; else first=quicksilver; second=vanilla; fi
    one $first $r "$scene" "$script" "$ticks" "$speed"
    one $second $r "$scene" "$script" "$ticks" "$speed"
  done
done < "$spec"
echo "chunk scenes done"
