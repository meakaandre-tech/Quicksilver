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
APPLIED = {"core/lights.far", "core/lights.far_real", "core/lights.far_end", "far/far_land.far", "far/far_nether.far", "far/far_flat.far_seen",
           # package 12c
           "far/far_cliff.far", "far/far_views.snow", "far/far_views.forest", "far/far_views.shore", "far/far_amplified.far",
           "far/far_largebiomes.far", "far/far_nullscape.far", "far/far_end.far"}
NETHER_FLOOR = r"sampled from the generator, top ([0-9]|[1-9][0-9]|1[01][0-9]|12[0-2])(, biome .*)?$"
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
    # package 12c: the other worlds sample their own generators; the Nullscape pack's End biomes reach far terrain
    ("far/far_amplified", 900, 0, 0, r"sampled from the generator"),
    ("far/far_largebiomes", 900, 0, 0, r"sampled from the generator"),
    ("far/far_nullscape", 900, 0, 0, r"sampled from the generator"),
    ("far/far_end", 1500, 0, 0, r"sampled from the generator, top \d+, biome nullscape:"),
    # the seen chunks: the land seen in the first session is real chunk data in the second at once (the disk cache)
    ("far/far_seen1_vanilla", 400, 0, -1, r"real chunk data: real"),
    ("far/far_seen2_vanilla", 400, 0, -1, r"real chunk data: real"),
    ("far/far_seen1_default", 400, 0, -1, r"real chunk data: real"),
    ("far/far_seen2_default", 400, 0, -1, r"real chunk data: real"),
]
# the runs that play far steps, by suite
RUNS = {"core": ["quicksilver-full", "quicksilver-old", "quicksilver-vk", "quicksilver-2p-old"],
        "far": ["far-terralith", "far-flat", "far-default", "far-vanilla", "far-amplified", "far-largebiomes", "far-nullscape", "far-flight"]}
# package 12b: far suite runs whose server keeps the default config (no far-terrain-share line): it must send no seed
DEFAULT_SERVER_RUNS = {"far-default"}
# package 12c: runs whose server doesn't send its generator (far-vanilla's runs no Quicksilver at all)
NO_SHARE_RUNS = {"far-default", "far-vanilla"}
# which far suite run plays which scene: every run not in the scene's "ciSkipRuns" (package 12c)
# lines the client logs when far terrain starts, per suite/scene (the source it used)
GEN = "from the dimension's own generator"
SOURCES = {"core/lights": GEN, "far/far_land": GEN, "far/far_nether": GEN, "far/far_flat": "from real chunks only (the generator isn't noise-based)",
           "far/far_cliff": GEN, "far/far_views": GEN, "far/far_amplified": GEN, "far/far_largebiomes": GEN, "far/far_nullscape": GEN, "far/far_end": GEN,
           "far/far_flight": GEN, "far/far_relog": GEN,
           "far/far_seen1_vanilla": "from real chunks only (the server doesn't run Quicksilver)",
           "far/far_seen2_vanilla": "from real chunks only (the server doesn't run Quicksilver)",
           "far/far_seen1_default": "from real chunks only (this server doesn't share its world seed)",
           "far/far_seen2_default": "from real chunks only (this server doesn't share its world seed)"}
# package 12c: the cliff seam against real terrain at a larger render distance (<shot>_truth): per screen column the step
# across the band's edges in the far shot may exceed the truth's step at the same rows by at most SEAM_FACTOR x the
# picture's own change + SEAM_FLOOR; and gaps (far shot pixels of the fog's colour where the truth shows land) in the strip
# around the band at most GAP_MAX_PCT of that strip
GAP_MAX_PCT = 0.5


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


def seam_truth(shot, mark, truth, off):
    """Package 12c: the cliff seam judged against the truth view (real terrain across the band) and the gaps."""
    if shot is None or mark is None or truth is None or off is None or shot.shape != mark.shape or truth.shape != shot.shape or off.shape != shot.shape:
        return None
    band = (mark[:, :, 0] > 230) & (mark[:, :, 1] < 30) & (mark[:, :, 2] > 230)
    lum = lambda im: im[:, :, 0] * 0.299 + im[:, :, 1] * 0.587 + im[:, :, 2] * 0.114
    ls, lt = lum(shot), lum(truth)
    h = shot.shape[0]
    excess, own, cols = [], [], 0
    strip = np.zeros(band.shape, dtype=bool)
    tops = []
    for x in range(shot.shape[1]):
        rows = np.nonzero(band[:, x])[0]
        if len(rows) < 2:
            continue
        top, bottom = rows.min(), rows.max()
        if top - 10 < 0 or bottom + 10 >= h:
            continue
        tops.append(top)
        strip[max(0, top - 12):min(h, bottom + 13), x] = True
        s_far = abs(ls[top - 3:top, x].mean() - ls[bottom + 1:bottom + 4, x].mean())
        s_true = abs(lt[top - 3:top, x].mean() - lt[bottom + 1:bottom + 4, x].mean())
        excess.append(max(0.0, s_far - s_true))
        own.append((abs(ls[top - 9:top - 6, x].mean() - ls[top - 3:top, x].mean()) + abs(ls[bottom + 1:bottom + 4, x].mean() - ls[bottom + 7:bottom + 10, x].mean())) / 2)
        cols += 1
    if cols < 20:
        return {"columns": cols}
    # the fog's colour: the off view (render distance 8) beyond the band, well above it on screen
    above = int(max(0, min(tops) - 20))
    fog = np.median(off[:max(1, above)].reshape(-1, 3), axis=0) if above > 0 else None
    gaps = None
    if fog is not None:
        near_fog = np.abs(shot - fog).max(axis=2) <= 10
        truth_land = np.abs(truth - fog).max(axis=2) > 30
        n = int(strip.sum())
        gaps = round(float((near_fog & truth_land & strip).sum() / max(1, n) * 100), 4)
    return {"columns": cols, "excess": round(float(np.mean(excess)), 2), "own": round(float(np.mean(own)), 2), "gaps": gaps}


# package 12c: shots taken for a check only (no stored reference)
CHECK_ONLY = {"far/far_land.pixel_old", "far/far_land.pixel_rain_old"}
CHECKER_MAX_SHARE = 0.5


def checker_share(img, flat_from, step=3, pale=140):
    """Package 12c: the share of checkerboard pixels of a pixel art shot (its art pixels sampled at their centres, 3 window
    pixels a side), counted in the pale, flat areas of the same view without pixel art (fog, haze, sky): a pixel whose right
    and lower neighbours both differ from it by over 12 and whose diagonal neighbour matches it (within 6)."""
    if img is None or flat_from is None or img.shape != flat_from.shape:
        return None, 0
    lum = lambda im: im[:, :, 0] * 0.299 + im[:, :, 1] * 0.587 + im[:, :, 2] * 0.114
    a = lum(img)[1::step, 1::step]
    f = lum(flat_from)
    # flat and pale in the plain view: a 9-pixel neighbourhood's spread under 3, brighter than 140
    h, w = f.shape
    flat = np.zeros_like(f, dtype=bool)
    from numpy.lib.stride_tricks import sliding_window_view
    win = sliding_window_view(f, (9, 9))
    spread = win.max(axis=(2, 3)) - win.min(axis=(2, 3))
    flat[4:h - 4, 4:w - 4] = (spread < 3) & (f[4:h - 4, 4:w - 4] > pale)
    m = flat[1::step, 1::step]
    hh, ww = a.shape
    a0, ar, ad, ag = a[:hh - 1, :ww - 1], a[:hh - 1, 1:], a[1:, :ww - 1], a[1:, 1:]
    chk = (np.abs(a0 - ar) > 12) & (np.abs(a0 - ad) > 12) & (np.abs(a0 - ag) <= 6)
    mm = m[:hh - 1, :ww - 1]
    n = int(mm.sum())
    return (round(float((chk & mm).sum() / n * 100), 3) if n else None), n


def status_lines(log):
    """Package 12c: far terrain's status lines' memory part, parsed (CI's flight)."""
    out = []
    # the logged status lines only (the chat echoes each one)
    log = "\n".join(l for l in log.splitlines() if "Quicksilver far terrain status:" in l)
    for m in re.finditer(r"memory: heap used (\d+) MB, direct (\d+|\?) MB, far samples (\d+) KB, far vertices (\d+) KB, far arenas (\d+) KB, disk cache (-?\d+) KB; frames (\d+), slowest (\d+) ms, (\d+) over 1 s; nearest missing tile (-?\d+) blocks; real chunks (\d+)", log):
        g = m.groups()
        out.append({"heap": int(g[0]), "direct": -1 if g[1] == "?" else int(g[1]), "samples": int(g[2]), "vertices": int(g[3]), "arenas": int(g[4]),
                    "cache": int(g[5]), "frames": int(g[6]), "slowest": int(g[7]), "slow": int(g[8]), "missing": int(g[9]), "real": int(g[10])})
    return out


def flight_checks(d, log, drives, lines, failures):
    """Package 12c: the 10-minute flight: memory flat (far terrain's own, the real chunks held, the heap and direct
    buffers), no stall, tiles made ahead (none missing near); the teleport and the nether settle; underground nothing drawn;
    the relog settles fast from the disk cache."""
    sts = status_lines(log)
    entry = next((e for e in drives if e.get("scene") == "far_flight"), None)
    if entry is None or len(sts) < 10:
        failures.append(f"far/far-flight: too few status lines ({len(sts)}) for the flight checks")
        return
    # the flight's lines: the status lines between the first and the one after the flight (11 or so); warm-up: the first 2
    fly = sts[1:12]
    warm, rest = fly[:3], fly[3:]
    def grow(k, slack):
        a, b = max(x[k] for x in warm), max(x[k] for x in rest[-3:])
        return a, b, b <= a * 1.3 + slack
    for k, slack, label in (("samples", 2048, "far samples KB"), ("vertices", 2048, "far vertices KB"), ("arenas", 16384, "far arenas KB"),
                            ("real", 4000, "real chunks held"), ("direct", 64, "direct buffers MB")):
        a, b, ok = grow(k, slack)
        lines.append(f"| far-flight | flight memory: {label} | first {a}, last {b} (at most 1.3 x + {slack}) | | | {'ok' if ok else '**FAIL**'} |")
        if not ok:
            failures.append(f"far/far-flight: {label} grew during the flight: {a} to {b}")
    # the heap saws between GCs (300-950 MB in one flight), so a median of three readings follows where the saw was;
    # a leak raises the floor: the lowest reading of the flight's second half against the warm-up's lowest
    ha = min(x["heap"] for x in warm)
    second = rest[len(rest) // 2:]
    hb = min(x["heap"] for x in second)
    peak = max(x["heap"] for x in fly)
    ok = hb <= ha * 1.5 + 256
    lines.append(f"| far-flight | flight memory: heap used MB (lowest reading, after GC) | warm-up {ha}, second half {hb}, peak {peak} (at most 1.5 x + 256) | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append(f"far/far-flight: the heap's floor grew during the flight: {ha} to {hb} MB")
    caches = [x["cache"] for x in fly if x["cache"] >= 0]
    ok = not caches or max(caches) <= 256 * 1024
    lines.append(f"| far-flight | disk cache KB | {caches[:1]} to {caches[-1:]} (cap 262144) | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append(f"far/far-flight: the disk cache passed its cap: {max(caches)} KB")
    slow = sum(x["slow"] for x in rest)
    worst = max(x["slowest"] for x in rest)
    ok = slow <= 3
    lines.append(f"| far-flight | frames over 1 s while flying | {slow} (slowest {worst} ms; at most 3) | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append(f"far/far-flight: {slow} frames over a second while flying (stalls)")
    miss = [x["missing"] for x in rest]
    near = [m for m in miss if 0 <= m < 160]
    ok = not near
    lines.append(f"| far-flight | nearest tile not made while flying (blocks) | {miss} (never under 160) | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append(f"far/far-flight: tiles weren't made in time: a wanted tile only {min(near)} blocks away was missing")
    # underground: not drawn (a status line saying so after the step that put the player in the ground)
    ok = "underground: not drawn" in log
    lines.append(f"| far-flight | underground (no sky light) | {'not drawn' if ok else 'drawn'} | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append("far/far-flight: far terrain didn't stand down underground")
    # the relog: far terrain from the disk cache (columns from it) and settled at once
    relog = next((e for e in drives if e.get("scene") == "far_relog"), None)
    first = next((st for st in entry.get("farSteps", []) if st["step"].startswith("#far ") and st.get("settled")), None)
    again = next((st for st in (relog or {}).get("farSteps", []) if st["step"].startswith("#far ") and st.get("settled")), None)
    # the relog session's own status line: the last one in the log (review: the whole log's counted the flight's own reads)
    cached = [int(c) for c in re.findall(r"disk cache columns (\d+)", "\n".join(l for l in log.splitlines() if "Quicksilver far terrain status:" in l))]
    cached = cached[-1:]
    ok = again is not None and first is not None and again["seconds"] <= first["seconds"] * 0.5 and cached and cached[0] > 0
    lines.append(f"| far-flight | relog: settled in {again and again['seconds']} s (first visit {first and first['seconds']} s), disk cache columns {max(cached) if cached else 0} | | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append(f"far/far-flight: after the relog far terrain didn't come from the disk cache at once (settled in {again and again.get('seconds')} s, first {first and first.get('seconds')} s, cache columns {max(cached) if cached else 0})")


def seen_checks(d, run, log, lines, failures, limits):
    """Package 12c: a server that doesn't share its seed: the second session shows the land seen in the first at once."""
    tag = "vanilla" if run == "far-vanilla" else "default"
    a = load(os.path.join(d, "shots", f"far_seen1_{tag}.seen.png"))
    b = load(os.path.join(d, "shots", f"far_seen2_{tag}.seen.png"))
    v = pct(a, b)
    lim = limits.get("far", {}).get(f"far_seen2_{tag}.vs_first", 0.001)
    loaded = [int(c) for c in re.findall(r"seen chunks loaded (\d+)", log)]
    ok = v is not None and v <= lim and loaded and max(loaded) > 0
    lines.append(f"| far-{run[4:]} | seen chunks after a relog | second session's view {v}% from the first's (limit {lim}%), seen chunks loaded from disk {max(loaded) if loaded else 0} | | | {'ok' if ok else '**FAIL**'} |")
    if not ok:
        failures.append(f"far/{run}: after the relog the seen chunks didn't show at once ({v}% from the first session's view, {max(loaded) if loaded else 0} loaded from disk)")


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
                if suite == "far" and run in sc.get("ciSkipRuns", []):
                    continue
                entry = next((e for e in drives if e.get("scene") == sid), None)
                if entry is None or entry.get("skipped"):
                    failures.append(f"{suite}/{run}/{sid}: the scene didn't run")
                    continue
                found += 1
                for st in entry.get("farSteps", []):
                    if (st["step"].startswith("#far ") or st["step"].startswith("#settle")) and not st.get("settled"):
                        failures.append(f"{suite}/{run}/{sid}: far terrain didn't settle at '{st['step']}' ({st.get('seconds')} s)")
                    # package 12c: settle times (a teleport, a dimension change, a relog) and the finds, for the report
                    if st["step"].startswith(("#settle", "#far ")) and st.get("settled"):
                        lines.append(f"| {suite}-{run} | {sid}: {st['step']} | settled in {st.get('seconds')} s | | | |")
                    if st["step"].startswith("#find"):
                        lines.append(f"| {suite}-{run} | {sid}: {st['step']} | {st.get('found')} | | | {'ok' if st.get('found') and not st['found'].startswith('none') else '**FAIL**'} |")
                        if not st.get("found") or st["found"].startswith("none"):
                            failures.append(f"{suite}/{run}/{sid}: '{st['step']}' found nothing")
                want = SOURCES.get(f"{suite}/{sid}")
                # package 12c: a server that doesn't send its generator gives real chunks only, whatever the world
                if run in NO_SHARE_RUNS and want:
                    want = "from real chunks only"
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
                    if f"{suite}/{shot_id}" in CHECK_ONLY:
                        pass
                    elif not os.path.exists(ref):
                        os.makedirs(os.path.join(rep, "new-references", suite), exist_ok=True)
                        shutil.copy(got, os.path.join(rep, "new-references", suite, f"{shot_id}-{run}.png"))
                        failures.append(f"{suite}/{run}/{shot_id}: no stored reference (copied to new-references)")
                    else:
                        if name.endswith("off") or name.endswith("_truth"):
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
                    if (name + "_mark") in shots and (name + "_truth") not in shots:
                        sm = seam(a, load(os.path.join(d, "shots", f"{shot_id}_mark.png")))
                        if sm is None or sm.get("columns", 0) < 20:
                            failures.append(f"{suite}/{run}/{shot_id}: the hand-over band wasn't found in its marked shot ({sm})")
                        elif sm["step"] > SEAM_FACTOR * sm["own"] + SEAM_FLOOR:
                            failures.append(f"{suite}/{run}/{shot_id}: a line at the hand-over: step {sm['step']} against the picture's own change {sm['own']} (at most {SEAM_FACTOR} x + {SEAM_FLOOR})")
                    # package 12c: a shot with a truth view (the cliff seam): its seam against the truth, and gaps
                    if (name + "_truth") in shots and (name + "_mark") in shots:
                        offn = f"{name}_off" if f"{name}_off" in shots else "far_off"
                        st = seam_truth(a, load(os.path.join(d, "shots", f"{shot_id}_mark.png")), load(os.path.join(d, "shots", f"{shot_id}_truth.png")),
                                        load(os.path.join(d, "shots", f"{sid}.{offn}.png")))
                        ok = st is not None and st.get("columns", 0) >= 20 and st["excess"] <= SEAM_FACTOR * st["own"] + SEAM_FLOOR and (st.get("gaps") is not None and st["gaps"] <= GAP_MAX_PCT)
                        lines.append(f"| {suite}-{run} | {shot_id}: seam against real terrain at render distance 12 | excess step {st and st.get('excess')} / own {st and st.get('own')} ({st and st.get('columns')} columns), gaps {st and st.get('gaps')}% of the band's strip (at most {GAP_MAX_PCT}%) | | | {'ok' if ok else '**FAIL**'} |")
                        if not ok:
                            failures.append(f"{suite}/{run}/{shot_id}: the cliff seam against real terrain: {st}")
                        # the seam rule of 12b can't hold where a real cliff stands in the band: the truth rule replaces it
                        sm = None
                    if f"{suite}/{shot_id}" in ("far/far_land.pixel", "far/far_land.pixel_rain"):
                        flat_src = load(os.path.join(d, "shots", f"{sid}.{'far' if name == 'pixel' else 'rain'}.png"))
                        # (in rain the fog is greyer and darker: pale there is over 90)
                        pale = 140 if name == "pixel" else 90
                        new, n = checker_share(a, flat_src, pale=pale)
                        old, _ = checker_share(load(os.path.join(d, "shots", f"{sid}.{name}_old.png")), flat_src, pale=pale)
                        ok = new is not None and old is not None and n > 200 and (new <= old * CHECKER_MAX_SHARE or new <= 0.5)
                        lines.append(f"| {suite}-{run} | {shot_id}: checkerboard in pale flat fog ({n} art pixels) | {new}% with the fog tones, {old}% without (at most {CHECKER_MAX_SHARE} x, or 0.5%) | | | {'ok' if ok else '**FAIL**'} |")
                        if not ok:
                            failures.append(f"{suite}/{run}/{shot_id}: pixel art's checkerboard in the fog didn't drop: {new}% against {old}% without the fog tones ({n} art pixels)")
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
            if suite == "far" and run == "far-flight":
                flight_checks(d, log, drives, lines, failures)
            if suite == "far" and run in NO_SHARE_RUNS:
                seen_checks(d, run, log, lines, failures, limits)
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
                elif run == "far-vanilla":
                    # package 12c: a server without Quicksilver: the client can't ask; real chunks only, nothing sent
                    clog = log
                    ok = "the server doesn't run Quicksilver (it can't share its world seed); real chunks only" in clog
                    lines.append(f"| {suite}-{run} | server without Quicksilver | client {'drew real chunks only' if ok else 'not as expected'} | | | {'ok' if ok else '**FAIL**'} |")
                    if not ok:
                        failures.append(f"{suite}/{run}: on a server without Quicksilver the client didn't log real chunks only")
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
