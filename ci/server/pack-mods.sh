#!/bin/bash
# usage: pack-mods.sh MODS_DIR
# The popular-mods test pack in MODS_DIR, as ci/pack-world.sh assembles it: every pack jar of ci/pack-sources.txt
# (Create Fly from the pack-snapshot release, the third-party mods pinned), checked against ci/pack-lock.txt (Fabric
# API is added to this folder separately).
set -e
PACK_CHECK=partial bash ci/pack-fetch.sh pack "$1" || { echo "the pack changed or a jar is missing (see above)"; exit 1; }
ls -l "$1"
