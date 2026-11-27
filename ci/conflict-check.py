#!/usr/bin/env python3
"""Release prep: Quicksilver next to Sodium (and Iris) stands down with one clear message (bench/StandDown).

usage: conflict-check.py RESULTS_DIR REPORT_DIR

For each conflict run (core-conflict-sodium: Quicksilver and Sodium; core-conflict-iris: Quicksilver, Sodium and Iris),
from ci/client-run.sh's two sessions (1: the title screen; 2: straight into the world):
- the client logged that Quicksilver is turned off, naming the mods found, in both sessions;
- session 1 showed Quicksilver's turned-off screen on the title screen, session 2 put the message in the chat (once);
- the game was still running at the end of each session, and no crash report was written;
- none of Quicksilver's modules started (no renderer, terrain, far terrain or settings lines), and no mixin failed;
- session 2 joined the server (the world ran with Sodium).
Writes REPORT_DIR/conflict.md; exit 1 on a failure. Only runs that are present are checked (quick mode has none unless
the commit asks for them with [conflict]); in full mode both must be there.
"""
import os
import re
import sys

RUNS = {"conflict-sodium": ["Sodium"], "conflict-iris": ["Sodium", "Iris"]}
# lines only a running Quicksilver module logs; none may appear while it stands down
MODULE_LINES = ["Quicksilver: Fabric Renderer API implementation registered", "Quicksilver capabilities:", "Quicksilver terrain:",
                "Quicksilver mesher:", "Quicksilver renderer", "Quicksilver far terrain:", "Quicksilver speed:", "Quicksilver pixel art:",
                "Quicksilver occlusion:", "Quicksilver logic:", "Quicksilver animation:", "Quicksilver visibility", "Quicksilver settings:",
                "Quicksilver memory:", "Quicksilver chunks:", "Quicksilver entity atlas:", "Quicksilver dynamic lights:",
                "Quicksilver compat:", "Quicksilver translucency", "Quicksilver block renderer:"]


def read(path):
    return open(path, errors="replace").read() if os.path.exists(path) else None


def main():
    res, rep = sys.argv[1], sys.argv[2]
    os.makedirs(rep, exist_ok=True)
    full = os.environ.get("CI_MODE", "full") == "full"
    extra = os.environ.get("CI_EXTRA_RUNS", "").split()
    failures, lines = [], ["# Quicksilver next to Sodium and Iris (release prep)\n", "| run | check | result | |", "|---|---|---|---|"]
    for run, mods in RUNS.items():
        d = os.path.join(res, f"core-{run}")
        if not os.path.isdir(d):
            if full or run in extra:
                failures.append(f"{run}: no results")
            continue
        txt = read(os.path.join(d, "run.txt")) or ""
        logs = {n: read(os.path.join(d, f"client-{n}.log")) for n in (1, 2)}
        for n, log in logs.items():
            label = "title screen" if n == 1 else "world"
            if log is None:
                failures.append(f"{run}: session {n} ({label}) left no client log")
                continue
            want = "Quicksilver: turned off: " + " and ".join(mods) + " installed"
            ok = want in log
            lines.append(f"| {run} | session {n}: turned-off line | {'found' if ok else 'missing'} | {'ok' if ok else '**FAIL**'} |")
            if not ok:
                failures.append(f"{run}: session {n} ({label}): no '{want}' line")
            told = re.findall(r"Quicksilver: told the player it is turned off \((title screen|chat)\)", log)
            expect = "title screen" if n == 1 else "chat"
            ok = told == [expect]
            lines.append(f"| {run} | session {n}: message shown | {told} | {'ok' if ok else '**FAIL**'} |")
            if not ok:
                failures.append(f"{run}: session {n} ({label}): the message should be shown once, on the {expect}; got {told}")
            bad = [m for m in MODULE_LINES if m in log]
            if bad:
                failures.append(f"{run}: session {n} ({label}): Quicksilver modules ran while standing down: {bad}")
            if re.search(r"Mixin apply failed|MixinApplyError|InvalidMixinException|Mixin transformation of .* failed", log) or \
                    re.search(r"mixin[^\n]*quicksilver[^\n]*(error|failed|could not)|quicksilver[^\n]*mixin[^\n]*(error|failed|could not)", log, re.I):
                failures.append(f"{run}: session {n} ({label}): a mixin failed to apply (see the client log)")
            running = f"session {n}: the game was running at the end" in txt
            lines.append(f"| {run} | session {n}: still running at the end | {running} | {'ok' if running else '**FAIL**'} |")
            if not running:
                failures.append(f"{run}: session {n} ({label}): the game wasn't running at the end (crashed or quit)")
        if os.path.isdir(os.path.join(d, "client-crash-reports")) and os.listdir(os.path.join(d, "client-crash-reports")):
            failures.append(f"{run}: a crash report was written")
        joins = (read(os.path.join(d, "joins.txt")) or "0").strip()
        ok = joins.isdigit() and int(joins) >= 1
        lines.append(f"| {run} | session 2 joined the world | {joins} join(s) | {'ok' if ok else '**FAIL**'} |")
        if not ok:
            failures.append(f"{run}: the client never joined the world")
        for shot in ("conflict.title", "conflict.world", "conflict.chat"):
            if not os.path.exists(os.path.join(d, "shots", f"{shot}.png")):
                failures.append(f"{run}: no {shot} screenshot")
    lines.append("\n## Failures\n")
    lines.extend(f"- {f}" for f in failures) if failures else lines.append("none")
    open(os.path.join(rep, "conflict.md"), "w").write("\n".join(lines) + "\n")
    print("\n".join(lines))
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
