#!/bin/bash
# usage: pack-fetch.sh SET DIR
# Downloads every jar of SET listed in ci/pack-sources.txt into DIR (Andre's own builds from this repo's pack-snapshot
# release, third-party jars at their pinned versions), then checks DIR against ci/pack-lock.txt (complete, unless
# PACK_CHECK=partial: a jar "provided" by the caller may not be there yet). Run from the repo root.
set_=$1
dir=$2
here="$(cd "$(dirname "$0")" && pwd)"
repo=${GITHUB_REPOSITORY:-meakaandre-tech/Quicksilver}
mkdir -p "$dir"
fetch() { curl -fsSL --retry 5 --retry-all-errors --retry-delay 5 -o "$1" "$2"; }
bad=0
while read -r key src _; do
  case "$key" in ''|'#'*) continue;; esac
  [ "${key%%/*}" = "$set_" ] || continue
  name=${key#*/}
  case "$src" in
    provided) continue;;
    snapshot) url="https://github.com/$repo/releases/download/pack-snapshot/$name";;
    https://*) url=$src;;
    modrinth:*)
      p=${src#modrinth:}
      url=$(curl -fsSL --retry 5 --retry-all-errors --retry-delay 5 "https://api.modrinth.com/v2/project/${p%%@*}/version" | python3 -c "
import json,sys
v=[x for x in json.load(sys.stdin) if x['version_number']=='${p#*@}']
f=v and next((x for x in v[0]['files'] if x.get('primary')), v[0]['files'][0])
print(f['url'] if f else '')")
      [ -n "$url" ] || { echo "pack: no Modrinth version ${p#*@} of ${p%%@*}"; bad=1; continue; };;
    *) echo "pack: unknown source '$src' for $key"; bad=1; continue;;
  esac
  if fetch "$dir/$name" "$url"; then echo "pack: $key <- $url"; else echo "pack: could not fetch $key from $url"; bad=1; fi
done < "$here/pack-sources.txt"
[ $bad = 0 ] || exit 1
bash "$here/pack-check.sh" "$dir" "$set_" "${PACK_CHECK:-complete}" "${PACK_REPORT:-/dev/stdout}"
