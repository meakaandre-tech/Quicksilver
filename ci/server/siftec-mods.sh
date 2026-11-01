#!/bin/bash
# usage: siftec-mods.sh MODS_DIR
# SIFTEC's pack in MODS_DIR, as ci/siftec-world.sh assembles it: every siftec jar of ci/pack-sources.txt (SIFTEC, its
# self-test mod, MapMod and Andre's Create forks from the pack-snapshot release; third-party jars pinned).
set -e
mods=$1
S=$PWD/siftec/.github
mc=$(grep '^minecraft_version' gradle.properties | sed 's/.*= *//')
# the pack (ci/pack-sources.txt): Andre's builds from this repo's pack-snapshot release, third-party jars at pinned
# versions, all checked against ci/pack-lock.txt (Fabric API is added to this folder separately)
PACK_CHECK=partial bash ci/pack-fetch.sh siftec "$mods" || { echo "the pack changed or a jar is missing (see above)"; exit 1; }
ls -l "$mods"
