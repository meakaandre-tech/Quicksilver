#!/bin/bash
# CI only (the test pack, 2026-11-12): what a pack mod's classes do, for pinning a scene's noise in CI's pin mod.
# usage: pack-inspect.sh JAR_URL CLASS_REGEX OUT. Lists the jar's classes and writes javap -c -p of those matching
# CLASS_REGEX to OUT (only lines naming animations, randomness, time or ticks, with each method's header).
set -e
d=$(mktemp -d)
curl -fsSL -o "$d/m.jar" "$1"
{
  echo "# classes in $(basename "$1")"
  unzip -Z1 "$d/m.jar" | grep '\.class$' | sed 's/\.class$//' | sort
  for c in $(unzip -Z1 "$d/m.jar" | grep '\.class$' | sed 's/\.class$//' | grep -E "$2"); do
    echo; echo "## $c"
    javap -c -p -cp "$d/m.jar" "$c" 2>&1 | grep -E '^  [a-z].*\(|^  public|^  private|^  protected|^  static|[Aa]nim|[Rr]andom|tickCount|getTick|Tick|RawAnimation|thenLoop|thenPlay|controller|Controller|nextInt|nextFloat|nextDouble|ldc|[Tt]ime|[Pp]artial|Frozen|frozen' | head -500
  done
} > "$3"
