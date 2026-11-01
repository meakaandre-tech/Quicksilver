#!/bin/bash
# usage: update-pack-snapshot.sh [--expect]
# The deliberate "update the pack" step (Andre, 2026-11-01; docs/ci-limits.md, "Pack lock"), run by the
# update-pack-snapshot workflow (manual): downloads the current builds of Andre's own jars (the "snapshot" lines of
# ci/pack-sources.txt, from the moving tag each names), copies them into this repo's pack-snapshot release, and writes
# their hashes into ci/pack-lock.txt and their origins (repo, tag, the tag's commit) into ci/pack-snapshot.txt. The
# workflow commits the two files to the branch it ran on; then re-collect the numbers the changed jars affect.
# --expect: copy only if every download matches the hash already in ci/pack-snapshot.txt (the first snapshot: the
# set chosen by hand), and change no file.
set -euo pipefail
expect=0
[ "${1:-}" = --expect ] && expect=1
here="$(cd "$(dirname "$0")" && pwd)"
repo=${GITHUB_REPOSITORY:-meakaandre-tech/Quicksilver}
d=$(mktemp -d)
rec=$d/pack-snapshot.txt
siftec_commit=
while read -r key src from url; do
  case "$key" in ''|'#'*) continue;; esac
  [ "$src" = snapshot ] || continue
  [ "$from" = from ] || { echo "no 'from <URL>' for $key in ci/pack-sources.txt"; exit 1; }
  name=${key#*/}
  curl -fsSL --retry 5 --retry-all-errors --retry-delay 5 -o "$d/$name" "$url"
  sha=$(sha256sum "$d/$name" | cut -c1-64)
  # https://github.com/OWNER/REPO/releases/download/TAG/FILE
  IFS=/ read -r _ _ _ owner gh_repo _ _ tag _ <<< "$url"
  commit=$(git ls-remote "https://github.com/$owner/$gh_repo" "refs/tags/$tag" | cut -c1-40)
  [ "$gh_repo" = SIFTEC ] && siftec_commit=$commit
  echo "$name  $sha  $gh_repo $tag $commit" >> "$rec.jars"
  echo "$name: $sha ($gh_repo $tag at ${commit:0:12})"
  if [ $expect = 1 ]; then
    want=$(awk -v n="$name" '$1 == n {print $2}' "$here/pack-snapshot.txt")
    [ "$want" = "$sha" ] || { echo "$name is not the expected build (got $sha, expected ${want:-none}): nothing copied"; exit 1; }
  fi
done < "$here/pack-sources.txt"
if [ $expect = 1 ]; then
  cp "$here/pack-snapshot.txt" "$rec"
else
  { sed -n '/^#/p' "$here/pack-snapshot.txt"
    echo "siftec_commit=$siftec_commit"
    echo "taken=$(date -u +%F)"
    cat "$rec.jars"; } > "$rec"
fi
if ! gh release view pack-snapshot -R "$repo" > /dev/null 2>&1; then
  gh release create pack-snapshot -R "$repo" --prerelease --title "Pack snapshot (CI)" --notes "Exact copies of Andre's own \
builds that CI uses (SIFTEC, its self-test mod, MapMod, the Create forks). Not a Quicksilver release. Changed only by \
ci/update-pack-snapshot.sh (docs/ci-limits.md, \"Pack lock\"): hashes in ci/pack-lock.txt, origins in ci/pack-snapshot.txt."
fi
gh release upload pack-snapshot -R "$repo" --clobber "$d"/*.jar "$rec"
# read back: the release must now serve exactly these files
while read -r name sha _; do
  got=$(curl -fsSL --retry 5 --retry-all-errors --retry-delay 5 "https://github.com/$repo/releases/download/pack-snapshot/$name" | sha256sum | cut -c1-64)
  [ "$got" = "$sha" ] || { echo "pack-snapshot serves $name as $got, not $sha"; exit 1; }
done < "$rec.jars"
echo "pack-snapshot: $(wc -l < "$rec.jars") jars copied and read back"
[ $expect = 1 ] && exit 0
cp "$rec" "$here/pack-snapshot.txt"
while read -r name sha _; do
  sed -i "s#^[0-9a-f*]\{1,64\}  siftec/$name\$#$sha  siftec/$name#" "$here/pack-lock.txt"
  grep -q "^$sha  siftec/$name\$" "$here/pack-lock.txt" || { echo "siftec/$name is not in ci/pack-lock.txt"; exit 1; }
done < "$rec.jars"
echo "ci/pack-lock.txt and ci/pack-snapshot.txt updated"
