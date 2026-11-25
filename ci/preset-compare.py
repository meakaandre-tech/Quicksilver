#!/usr/bin/env python3
"""Package 9: the preset runs and the options screen's test.

usage: preset-compare.py RESULTS_DIR REPORT_DIR

Preset runs (ci/client-run.sh, RUN=preset-<low|balanced|quality>-old: Quicksilver on the old-GPU profile with
"preset=<preset>" in its config file, the scenes of PRESET_SCENES, shots only): each shot against vanilla's shot of the
same scene and profile (vanilla-old; vanilla-a in a quick run, as compare.py does for quicksilver-old), the share of
pixels over 8/255 (ci/compare.py's rule). Balanced and Quality fail over the shot's approximation limit
(ci/approx-limits.json, today's limits); Low-end, which changes the look on purpose, over its own limit
(ci/preset-limits.json, "low-end"). Every run: its client logs say the preset was applied, no Quicksilver fallback, no
crash report, every shot taken, no failed scene set-up or timed-out upload wait.
Screen test (the balanced run; settings/ScreenTest): every expected check passed, END with failed=0, and its screenshot.
Writes REPORT_DIR/presets.md and presets.json; exit 1 on a failure. A preset run that is missing fails in full mode, or
when CI_EXTRA_RUNS names it.
"""
import glob
import json
import os
import re
import sys

import numpy as np
from PIL import Image

THRESHOLD = 8
PRESETS = {"low": "low-end", "balanced": "balanced", "quality": "quality"}
SCREEN_CHECKS = ["command-sync", "opens-from-video-settings", "opens-from-mod-menu", "custom-after-command",
                 "preset low-end", "save-load low-end", "preset quality", "save-load quality", "preset balanced",
                 "save-load balanced", "custom-after-change option.opaque-leaves", "remesh-without-restart option.opaque-leaves",
                 "custom-after-change option.simple-water", "remesh-without-restart option.simple-water", "back-to-balanced",
                 "module-switch-saved", "tooltips", "gui-scale-1", "gui-scale-2", "gui-scale-3", "gui-scale-4"]


def diff(a, b):
    x = np.asarray(Image.open(a).convert("RGB"), dtype=np.int16)
    y = np.asarray(Image.open(b).convert("RGB"), dtype=np.int16)
    if x.shape != y.shape:
        return 100.0
    return round(float((np.abs(x - y).max(axis=2) > THRESHOLD).mean() * 100), 4)


def text(p):
    try:
        with open(p, errors="replace") as f:
            return f.read()
    except OSError:
        return ""


def main(res, rep):
    os.makedirs(rep, exist_ok=True)
    full = os.environ.get("CI_MODE") == "full"
    extra = os.environ.get("CI_EXTRA_RUNS", "").split()
    approx = json.load(open("ci/approx-limits.json"))
    low_limits = json.load(open("ci/preset-limits.json")) if os.path.exists("ci/preset-limits.json") else {}
    fails, lines, out = [], ["# Presets and the options screen (package 9)\n"], {}
    vanilla = os.path.join(res, "core-vanilla-old")
    if not os.path.isdir(os.path.join(vanilla, "shots")):
        vanilla = os.path.join(res, "core-vanilla-a")
    lines.append("Each preset run's shots against %s's (share of pixels over %d/255, %%; limit in brackets).\n" % (os.path.basename(vanilla)[5:], THRESHOLD))
    for short, pid in PRESETS.items():
        run = "preset-%s-old" % short
        d = os.path.join(res, "core-" + run)
        if not os.path.isdir(d):
            if full or run in extra:
                fails.append("%s: no results" % run)
            continue
        logs = "\n".join(text(p) for p in sorted(glob.glob(os.path.join(d, "client-*.log"))))
        got = re.findall(r"Quicksilver settings: preset (\S+)", logs)
        # every session starts on the preset (a scene's own config lines may make it custom, but not every session)
        if pid not in got or any(g != pid and g != "custom" for g in got):
            fails.append("%s: the client logs no 'Quicksilver settings: preset %s' line (%s)" % (run, pid, got[:3] or "none"))
        fb = [l for l in logs.splitlines() if re.search(r"Quicksilver [a-z ]*fallback", l)]
        if fb:
            fails.append("%s: %d Quicksilver fallback lines (first: %s)" % (run, len(fb), fb[0][:200]))
        if glob.glob(os.path.join(d, "client-crash-reports*", "*")):
            fails.append("%s: a client crash report" % run)
        for f in glob.glob(os.path.join(d, "drive-*.json")):
            for e in json.load(open(f)):
                if e.get("skipped"):
                    continue
                if not e.get("shot"):
                    fails.append("%s/%s: no shot" % (run, e["scene"]))
                if -1 in (e.get("uploadWaits") or []):
                    fails.append("%s/%s: a shot was taken while terrain uploads still waited" % (run, e["scene"]))
                for x in e.get("setupFailed") or []:
                    fails.append("%s/%s: scene set-up failed: %s" % (run, e["scene"], x.get("command", "")[:80]))
        rows = {}
        for shot in sorted(glob.glob(os.path.join(d, "shots", "*.png"))):
            sid = os.path.basename(shot)[:-4]
            if sid.endswith(".prev"):
                continue
            ref = os.path.join(vanilla, "shots", sid + ".png")
            if not os.path.exists(ref):
                fails.append("%s/%s: no vanilla shot to compare with" % (run, sid))
                continue
            pct = diff(shot, ref)
            if pid == "low-end":
                limit = (low_limits.get("low-end") or {}).get(sid)
            else:
                limit = approx["core"].get(sid, approx.get("default"))
            low = (low_limits.get("low-end-min") or {}).get(sid) if pid == "low-end" else None
            rows[sid] = {"pct": pct, "limit": limit, "min": low}
            if low is not None and pct < low:
                fails.append("%s/%s: %.4f%% of pixels over %d/255 against vanilla, under %s%%: the Low-end options didn't change the picture" % (run, sid, pct, THRESHOLD, low))
            if limit is None:
                fails.append("%s/%s: no limit for this shot (ci/preset-limits.json)" % (run, sid))
            elif pct > limit:
                fails.append("%s/%s: %.4f%% of pixels over %d/255 against vanilla, over its limit %s%%" % (run, sid, pct, THRESHOLD, limit))
        out[run] = rows
        lines.append("## %s (preset=%s)\n" % (run, pid))
        lines.append("| shot | over 8/255 % | limit % |\n|---|---|---|")
        lines += ["| %s | %s | %s |" % (k, v["pct"], v["limit"]) for k, v in rows.items()]
        lines.append("")
        if not rows:
            fails.append("%s: no shots" % run)
        if pid == "balanced":
            # the options screen's test (settings/ScreenTest)
            res_lines = list(dict.fromkeys(re.findall(r"QUICKSILVER SCREEN TEST (.+?): (PASS|FAIL|SKIP) ?(.*)", logs)))
            end = re.findall(r"QUICKSILVER SCREEN TEST END passed=(\d+) failed=(\d+)", logs)
            seen = {n: (r, x) for n, r, x in res_lines}
            lines.append("### Options screen test\n")
            lines.append("| check | result | detail |\n|---|---|---|")
            lines += ["| %s | %s | %s |" % (n, r, x.replace("|", "/")[:300]) for n, r, x in res_lines]
            lines.append("")
            mods = text(os.path.join(d, "mod-ids.txt")).split()
            if "modmenu" not in mods:
                fails.append("%s: Mod Menu was not loaded (ci/pack-fetch.sh modmenu: not fetched, or not as in ci/pack-lock.txt)" % run)
            for n in SCREEN_CHECKS:
                r = seen.get(n, (None, ""))[0]
                if r == "PASS":
                    continue
                fails.append("screen test %s: %s" % (n, r or "did not run"))
            for n, (r, x) in seen.items():
                if r == "FAIL" and n not in SCREEN_CHECKS:
                    fails.append("screen test %s: FAIL %s" % (n, x[:200]))
            if not end or end[-1][1] != "0":
                fails.append("screen test: no END line with failed=0 (%s)" % (end[-1:] or "none"))
            shot = os.path.join(d, "settings", "settings-screen.png")
            if os.path.exists(shot):
                lines.append("Screenshot (GUI scale 2, 1280x720): `runs/core-%s/settings/settings-screen.png`\n" % run)
            else:
                fails.append("screen test: no screenshot")
            out["screenTest"] = {n: r for n, (r, _) in seen.items()}
    if fails:
        lines.append("## Failures\n")
        lines += ["- " + f for f in fails]
    elif not out:
        lines.append("No preset runs in this run: nothing checked.")
    else:
        lines.append("All preset and screen checks passed.")
    with open(os.path.join(rep, "presets.md"), "w") as f:
        f.write("\n".join(lines) + "\n")
    with open(os.path.join(rep, "presets.json"), "w") as f:
        json.dump({"runs": out, "failures": fails}, f, indent=1)
    print("\n".join(lines[-5:]))
    return 1 if fails else 0


if __name__ == "__main__":
    if len(sys.argv) != 3:
        print(__doc__)
        sys.exit(2)
    sys.exit(main(sys.argv[1], sys.argv[2]))
