#!/usr/bin/env python3
"""Package 12: far terrain's CI checks (docs/ci-limits.md, "Package 12").

usage: far-compare.py RESULTS_DIR REPORT_DIR

Far terrain is off by default, so every ordinary shot is compared with vanilla by ci/compare.py as before. This script
checks the far terrain steps ("ciFarSteps", ci/drive.py) of the core suite's Quicksilver client runs and of the far
suite's runs (far-terralith: a fresh Terralith world; far-flat: a superflat world, real chunks only):
- every "#far" step settled (every wanted tile made and copied in), and the client never logged a far terrain failure;
- each far shot against its stored Quicksilver reference (counted only where the same view with far terrain off
  matches its own reference: the natural world's trees differ between runs, vanilla's world generation), each off
  shot whole, (ci/references/<suite>/<scene>.<shot>.png, a .vulkan.png one
  for the Vulkan run where present), share of pixels over 8/255 at most the shot's limit in ci/far-limits.json; a
  missing reference fails and the shot goes to the report's new-references folder;
- "far terrain showed": the shots listed in APPLIED differ from the same view with far terrain off by at least
  APPLIED_MIN_PCT;
- the seam: in the shot taken with the hand-over band painted (<shot>_mark), the band's pixels give, per screen column,
  where the band is; in the normal far shot the mean brightness of a 3-pixel strip just outside the band (beyond it)
  against one just inside it (nearer) is the step at the hand-over, and the same 6 pixels further out on each side the
  picture's own change over that distance. A visible line is a step well over that: fail if step > SEAM_FACTOR x own
  change + SEAM_FLOOR (0-255 brightness);
- probes ("#probe x z", logged): what far terrain held there before and after (a real chunk replacing its sample).
Writes REPORT_DIR/far.md; exit 1 on a failure.
"""
import glob
import json
import os
import re
import shutil
import sys

import numpy as np
from PIL import Image

THRESHOLD = 8
APPLIED_MIN_PCT = 2.0
SEAM_FACTOR = 2.0
SEAM_FLOOR = 4.0
# shots that must show far terrain (the same view with it off is <scene>.<shot>_off where taken, else <scene>.far_off)
APPLIED = {"core/lights.far", "core/lights.far_real", "core/lights.far_end", "far/far_land.far", "far/far_nether.far", "far/far_flat.far_seen"}
NETHER_FLOOR = r"sampled from the generator, top ([0-9]|[1-9][0-9]|1[01][0-9]|12[0-2])$"
# probes: (suite/scene, x, z, which line of that probe, regex the line must match)
PROBES = [
    ("core/lights", 800, -27, 0, r"sampled from the generator"),
    ("core/lights", 800, -27, -1, r"real chunk data: real, top 231, block .*gold_block"),
    ("far/far_land", 900, 0, 0, r"sampled from the generator"),
    # the nether: the floor under the roof (the roof's underside is at 123 at the lowest; the floor is below 123)
    ("core/lights", 300, 0, 0, NETHER_FLOOR),
    ("far/far_nether", 300, 0, 0, NETHER_FLOOR),
    ("far/far_flat", 600, 0, 0, r"nothing \(no real chunk there, and no generator\)"),
    ("far/far_flat", 400, 0, -1, r"real chunk data: real"),
]
# the runs that play far steps, by suite
RUNS = {"core": ["quicksilver-full", "quicksilver-old", "quicksilver-vk", "quicksilver-2p-old"], "far": ["far-terralith", "far-flat", "far-default"]}
# package 12b: far suite runs whose server keeps the default config (no far-terrain-share line): it must send no seed
DEFAULT_SERVER_RUNS = {"far-default"}
# which far suite run plays which scene
SCENE_RUN = {"far_land": "far-terralith", "far_nether": "far-terralith", "far_flat": "far-flat"}
# lines the client logs when far terrain starts, per suite/scene (the source it used)
SOURCES = {"core/lights": "from the dimension's own generator", "far/far_land": "from the dimension's own generator", "far/far_nether": "from the dimension's own generator",
           "far/far_flat": "from real chunks only (the generator isn't noise-based)"}


def load(path):
    return np.asarray(Image.open(path).convert("RGB"), dtype=np.int16) if os.path.exists(path) else None


def pct(a, b):
    if a is None or b is None or a.shape != b.shape:
        return None
    return round(float((np.abs(a - b).max(axis=2) > THRESHOLD).mean() * 100), 4)


def pct_where_same(a, b, off_a, off_b):
    """% of all pixels over THRESHOLD between a and b, counted only where the two runs' far-off views agree (within
    THRESHOLD): the real terrain there is the same, so a difference is far terrain's. Vanilla's world generation
    places features that cross chunk borders in a varying order, so the natural world's trees differ between runs
    (docs/ci-limits.md, "Package 12"); those pixels are the off shots' own check. Without both off views: all pixels."""
    if a is None or b is None or a.shape != b.shape:
        return None, None
    diff = np.abs(a - b).max(axis=2) > THRESHOLD
    if off_a is None or off_b is None or off_a.shape != a.shape or off_b.shape != a.shape:
        return round(float(diff.mean() * 100), 4), 100.0
    same = np.abs(off_a - off_b).max(axis=2) <= THRESHOLD
    return round(float((diff & same).mean() * 100), 4), round(float(same.mean() * 100), 2)


def seam(shot, mark):
    """The hand-over step and the picture's own change around it (0-255 brightness), or None without a band."""
    if shot is None or mark is None or shot.shape != mark.shape:
        return None
    band = (mark[:, :, 0] > 230) & (mark[:, :, 1] < 30) & (mark[:, :, 2] > 230)
    lum = shot[:, :, 0] * 0.299 + shot[:, :, 1] * 0.587 + shot[:, :, 2] * 0.114
    h = shot.shape[0]
    steps, own, cols = [], [], 0
    for x in range(shot.shape[1]):
        rows = np.nonzero(band[:, x])[0]
        if len(rows) < 2:
            continue
        top, bottom = rows.min(), rows.max()
        # beyond the band is above it on screen (further away), nearer below it
        if top - 10 < 0 or bottom + 10 >= h:
            continue
        out1, in1 = lum[top - 3:top, x].mean(), lum[bottom + 1:bottom + 4, x].mean()
        out2, in2 = lum[top - 9:top - 6, x].mean(), lum[bottom + 7:bottom + 10, x].mean()
        steps.append(abs(out1 - in1))
        own.append((abs(out2 - out1) + abs(in1 - in2)) / 2)
        cols += 1
    if cols < 20:
        return {"columns": cols}
    return {"columns": cols, "step": round(float(np.mean(steps)), 2), "own": round(float(np.mean(own)), 2)}


def main():
    res, rep = sys.argv[1], sys.argv[2]
    os.makedirs(rep, exist_ok=True)
    limits = json.load(open("ci/far-limits.json")) if os.path.exists("ci/far-limits.json") else {}
    failures, lines = [], ["# Far terrain (package 12)\n"]
    lines.append("| run | shot | vs reference % (limit) | vs far off % | seam step / own change (columns) | |")
    lines.append("|---|---|---|---|---|---|")
    found = 0
    for suite, runs in RUNS.items():
        suitefile = f"src/main/resources/quicksilver/scenes/{suite}.json"
        scenes = [s for s in json.load(open(suitefile))["scenes"] if s.get("ciFarSteps")]
        for run in runs:
            d = os.path.join(res, f"{suite}-{run}")
            if not os.path.isdir(d):
                # quick mode has only some of these runs (and the far suite's only with [far], which lists them as extra runs)
                if os.environ.get("CI_MODE", "full") != "full" and run not in os.environ.get("CI_EXTRA_RUNS", "").split():
                    continue
                failures.append(f"{suite}/{run}: no results")
                continue
            log = "".join(open(f, errors="replace").read() for f in sorted(glob.glob(os.path.join(d, "client-*.log"))))
            if "Quicksilver far terrain: turned off for the session" in log or "Quicksilver far terrain: its sampling thread stopped" in log:
                failures.append(f"{suite}/{run}: far terrain failed (see the client log)")
            drives = []
            for f in glob.glob(os.path.join(d, "drive-*.json")):
                drives.extend(json.load(open(f)))
            for sc in scenes:
                sid = sc["id"]
                if suite == "far" and SCENE_RUN.get(sid) != run:
                    continue
                entry = next((e for e in drives if e.get("scene") == sid), None)
                if entry is None or entry.get("skipped"):
                    failures.append(f"{suite}/{run}/{sid}: the scene didn't run")
                    continue
                found += 1
                for st in entry.get("farSteps", []):
                    if st["step"].startswith("#far ") and not st.get("settled"):
                        failures.append(f"{suite}/{run}/{sid}: far terrain didn't settle at '{st['step']}' ({st.get('seconds')} s)")
                want = SOURCES.get(f"{suite}/{sid}")
                if want and want not in log:
                    failures.append(f"{suite}/{run}/{sid}: far terrain never started {want} (no such line in the client log)")
                shots = [st[6:].strip() for st in sc["ciFarSteps"] if st.startswith("#shot ")]
                for name in shots:
                    shot_id = f"{sid}.{name}"
                    got = os.path.join(d, "shots", shot_id + ".png")
                    a = load(got)
                    if a is None:
                        failures.append(f"{suite}/{run}/{shot_id}: no screenshot")
                        continue
                    ref = os.path.join("ci", "references", suite, shot_id + ".png")
                    vref = os.path.join("ci", "references", suite, shot_id + ".vulkan.png")
                    if run.endswith("-vk") and os.path.exists(vref):
                        ref = vref
                    limit = limits.get(suite, {}).get(shot_id)
                    vs = None
                    same_share = None
                    if not os.path.exists(ref):
                        os.makedirs(os.path.join(rep, "new-references", suite), exist_ok=True)
                        shutil.copy(got, os.path.join(rep, "new-references", suite, f"{shot_id}-{run}.png"))
                        failures.append(f"{suite}/{run}/{shot_id}: no stored reference (copied to new-references)")
                    else:
                        if name.endswith("off"):
                            # an off shot: the whole picture (the world's own variance; its limit by the rule)
                            vs = pct(a, load(ref))
                        else:
                            # a far shot: where the real terrain matched the reference run's (the same view off)
                            offn = f"{name}_off" if f"{name}_off" in shots else ("far_off" if "far_off" in shots else None)
                            if name.endswith("_mark") and f"{name[:-5]}_off" in shots:
                                offn = f"{name[:-5]}_off"
                            off_run = load(os.path.join(d, "shots", f"{sid}.{offn}.png")) if offn else None
                            off_ref_p = os.path.join("ci", "references", suite, f"{sid}.{offn}.png") if offn else None
                            if off_ref_p and run.endswith("-vk") and os.path.exists(off_ref_p[:-4] + ".vulkan.png"):
                                off_ref_p = off_ref_p[:-4] + ".vulkan.png"
                            off_ref = load(off_ref_p) if off_ref_p else None
                            vs, same_share = pct_where_same(a, load(ref), off_run, off_ref)
                            # the share compared can't fall below what the off shot's own limit lets differ
                            off_limit = limits.get(suite, {}).get(f"{sid}.{offn}") if offn else None
                            if isinstance(off_limit, (int, float)) and same_share is not None and same_share < 100 - off_limit:
                                failures.append(f"{suite}/{run}/{shot_id}: compared on only {same_share}% of the picture (the rest differs in the view with far terrain off; at least {round(100 - off_limit, 4)}%)")
                        if limit is None:
                            failures.append(f"{suite}/{run}/{shot_id}: no limit in ci/far-limits.json")
                        elif vs is None or vs > limit:
                            failures.append(f"{suite}/{run}/{shot_id}: {vs}% of pixels over 8/255 from its reference (limit {limit}%)")
                    applied = None
                    if f"{suite}/{shot_id}" in APPLIED:
                        # the same view with far terrain off: <shot>_off where the steps take one, else far_off
                        off = f"{name}_off" if f"{name}_off" in shots else "far_off"
                        applied = pct(a, load(os.path.join(d, "shots", f"{sid}.{off}.png")))
                        if applied is None or applied < APPLIED_MIN_PCT:
                            failures.append(f"{suite}/{run}/{shot_id}: differs from the view with far terrain off on only {applied}% of pixels (at least {APPLIED_MIN_PCT}%): far terrain didn't show")
                    sm = None
                    if (name + "_mark") in shots:
                        sm = seam(a, load(os.path.join(d, "shots", f"{shot_id}_mark.png")))
                        if sm is None or sm.get("columns", 0) < 20:
                            failures.append(f"{suite}/{run}/{shot_id}: the hand-over band wasn't found in its marked shot ({sm})")
                        elif sm["step"] > SEAM_FACTOR * sm["own"] + SEAM_FLOOR:
                            failures.append(f"{suite}/{run}/{shot_id}: a line at the hand-over: step {sm['step']} against the picture's own change {sm['own']} (at most {SEAM_FACTOR} x + {SEAM_FLOOR})")
                    seam_txt = f"{sm.get('step')} / {sm.get('own')} ({sm.get('columns')})" if sm else ""
                    lines.append(f"| {suite}-{run} | {shot_id} | {vs} ({limit}){'' if same_share is None else f', on {same_share}%'} | {applied if applied is not None else ''} | {seam_txt} | |")
                for (key, x, z, which, rx) in PROBES:
                    if key != f"{suite}/{sid}":
                        continue
                    got = re.findall(rf"Quicksilver far terrain probe {x} {z}: (.*)", log)
                    if not got:
                        failures.append(f"{suite}/{run}/{sid}: no probe line for {x} {z}")
                        continue
                    line = got[which]
                    ok = re.search(rx, line.strip()) is not None
                    lines.append(f"| {suite}-{run} | probe {x} {z} ({'first' if which == 0 else 'last'}) | {line} | | | {'ok' if ok else '**FAIL**'} |")
                    if not ok:
                        failures.append(f"{suite}/{run}/{sid}: probe {x} {z} ({'first' if which == 0 else 'last'}) said '{line}', expected /{rx}/")
            if suite == "far":
                st = os.path.join(d, "server.log")
                st = open(st, errors="replace").read() if os.path.exists(st) else ""
                # package 12b: the Terralith view must have columns cut by vanilla's vertical reach (the steep fill's case)
                if run == "far-terralith":
                    cuts = [int(c) for c in re.findall(r"(\d+) of them cut by vanilla's vertical reach", log)]
                    ok = bool(cuts) and max(cuts) > 0
                    lines.append(f"| {suite}-{run} | columns at vanilla's vertical cut | {cuts} | | | {'ok' if ok else '**FAIL**'} |")
                    if not ok:
                        failures.append(f"{suite}/{run}: no far status line counted columns cut by vanilla's vertical reach (the camera is 230 high at render distance 8: there must be some)")
                if run in DEFAULT_SERVER_RUNS:
                    # package 12b: the nether on a server that doesn't share its seed: real chunks only, still under a ceiling
                    ok = any("under a ceiling: behind real terrain, no band, no holes filled" in m.group(0)
                             for m in re.finditer(r"far terrain status: on, [^\n]*", log))
                    lines.append(f"| {suite}-{run} | nether, real chunks only: behind real terrain | {'yes' if ok else 'no'} | | | {'ok' if ok else '**FAIL**'} |")
                    if not ok:
                        failures.append(f"{suite}/{run}: in the nether (seed not shared) far terrain's status never said it stays behind real terrain under the ceiling")
                    # package 12b: a server with the default config shares no seed: it says so to the client that asks,
                    # never sends its generator, and the client draws real chunks only
                    clog = "".join(open(f, errors="replace").read() for f in sorted(glob.glob(os.path.join(d, "client-*.log"))))
                    asked = "asked for the world's generator; not shared (far-terrain-share is off, the default" in st
                    sent = "Quicksilver far terrain: sent the world's generator" in st or "shares its world seed and generator" in st
                    told = "the server didn't share its world generator" in clog and "from real chunks only (this server doesn't share its world seed)" in clog
                    lines.append(f"| {suite}-{run} | default server, seed | {'asked, not shared' if asked else 'no request seen'}; {'SENT' if sent else 'nothing sent'}; client {'told' if told else 'not told'} | | | {'ok' if asked and not sent and told else '**FAIL**'} |")
                    if not asked:
                        failures.append(f"{suite}/{run}: the default server never logged a request it didn't share (far-terrain-share is off by default)")
                    if sent:
                        failures.append(f"{suite}/{run}: a server with the default config sent its world seed and generator")
                    if not told:
                        failures.append(f"{suite}/{run}: the client never logged that the server didn't share its generator (real chunks only)")
                elif "Quicksilver far terrain: sent the world's generator" not in st:
                    failures.append(f"{suite}/{run}: the server never sent its world generator (handshake)")
    if found == 0:
        failures.append("far terrain: no far steps ran anywhere")
    lines.append("\n## Far terrain failures\n")
    lines.extend(f"- {f}" for f in failures) if failures else lines.append("none")
    open(os.path.join(rep, "far.md"), "w").write("\n".join(lines) + "\n")
    print("\n".join(lines))
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
