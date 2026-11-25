#!/usr/bin/env python3
"""Package A: the speed runs' report and gates.

usage: speed-compare.py RESULTS_DIR REPORT_DIR

Reads every speed run's speed/*.json (written by the mod's speed bench, bench/SpeedBench: a stage profile per scene, then
each listed switch off against on: three rounds for an option, five for a gated approximation or CI switch), writes REPORT_DIR/speed.md and REPORT_DIR/speed.json, and checks the
gates in ci/speed-gates.json: each default-on approximation must still remove work and must not make frames slower, so
it can't silently stop helping. Exit status 1 on a failed gate, a missing speed run (full mode) or a speed bench problem.

A gate: {"setting", "scene", "runs": [...], "metric", "max" or "min", "reason"}; metric is one of the summary's medians
("frameMsAvg", "terrainTrianglesPerFrame", ...) as on/off ("onOverOff") unless "value": "on" asks for the on-side median.
"""
import glob
import json
import os
import sys

SPEED_RUNS = ["speed-old", "speed-full"]


def main():
    res, rep = sys.argv[1], sys.argv[2]
    os.makedirs(rep, exist_ok=True)
    quick = os.environ.get("CI_MODE", "full") == "quick"
    # the speed runs the mode job put in the matrix (CI_EXTRA_RUNS); each must produce results
    expected = set(os.environ.get("CI_EXTRA_RUNS", "").split()) if os.environ.get("CI_EXTRA_RUNS") is not None else None
    gates = json.load(open("ci/speed-gates.json"))["gates"]
    failures, lines, data = [], [], {}
    lines.append("# Speed runs (package A)\n")
    lines.append("Each speed run plays the scenes with a `speedAb` list once more, with Quicksilver's defaults, the frame limit"
                 " and vsync off: first a stage profile (where frame time goes, the GPU waited for at each stage), then each"
                 " switch off against on, rounds of five seconds a side (off-on, on-off, off-on, ...), in the same session: three for an"
                 " option, five for an approximation or CI switch (the gated ones). Each side: the median over the rounds; on/off:"
                 " from the rounds' own ratios, with five rounds their geometric mean without the highest and lowest, with three"
                 " their median. On/off below 1 means the switch made it smaller.\n")
    found = False
    for run in SPEED_RUNS:
        d = os.path.join(res, f"core-{run}")
        files = sorted(glob.glob(os.path.join(d, "speed", "*.json")))
        if not files:
            if not quick or (expected is not None and run in expected):
                failures.append(f"speed: run {run} produced no speed results")
            lines.append(f"## {run}: no results\n")
            continue
        found = True
        lines.append(f"## {run}\n")
        for f in files:
            j = json.load(open(f))
            scene = j["scene"]
            data.setdefault(run, {})[scene] = j
            for p in j.get("problems", []):
                failures.append(f"speed: {run}/{scene}: {p}")
            prof = j.get("profile") or {}
            lines.append(f"### {scene}: profile ({prof.get('frames')} frames, {prof.get('profiledFrameMs')} ms per profiled frame,"
                         f" GPU waited for at each stage: {prof.get('gpuWaitAtEachStage')})\n")
            lines.append("| stage | ms/frame | share | draws/frame |\n|---|---|---|---|")
            for s in (prof.get("stages") or [])[:14]:
                lines.append(f"| {s['stage']} | {s['msPerFrame']} | {s['pct']}% | {s.get('drawsPerFrame', '')} |")
            dsum = sum(s.get("drawsPerFrame") or 0 for s in (prof.get("stages") or []))
            if dsum:
                lines.append(f"\nDraw calls per profiled frame: {round(dsum, 2)}")
            lines.append("")
            if j.get("ab"):
                lines.append("| switch (on value) | frame ms off → on | fps off → on | 1% low off → on | draws/frame | upload B/frame |"
                             " terrain triangles/frame | left out (on) |\n|---|---|---|---|---|---|---|---|")
            for e in j.get("ab", []):
                m = e["medians"]

                def pair(k):
                    return f"{m[k]['off']} → {m[k]['on']} ({m[k]['onOverOff']:.3f})"
                left = []
                for k, label in (("sectionsInFogPerFrame", "sections in fog/frame"), ("cutoutLayersSkippedPerFrame", "cutout layers/frame"),
                                 ("entitiesHiddenPerFrame", "entities/frame"), ("blockEntitiesHiddenPerFrame", "block entities/frame"),
                                 ("particlesDropped", "particles dropped")):
                    if m[k]["on"]:
                        left.append(f"{m[k]['on']} {label}")
                lines.append(f"| {e['setting']} ({e['onValue']}) | {pair('frameMsAvg')} | {pair('fps')} | {pair('low1pctFps')} |"
                             f" {pair('drawCallsPerFrame')} | {pair('uploadBytesPerFrame')} | {pair('terrainTrianglesPerFrame')} | {', '.join(left) or '-'} |")
            lines.append("")
            # package B: occlusion culling in each switch's windows
            occ = [e for e in j.get("ab", []) if "occlusionCulledPct" in e["medians"]]
            if occ:
                lines.append("| switch (on value) | occlusion culled % off → on | sections culled/frame off → on |"
                             " still frames drawn in full off → on |\n|---|---|---|---|")
                for e in occ:
                    m = e["medians"]
                    lines.append(f"| {e['setting']} ({e['onValue']}) | {m['occlusionCulledPct']['off']} → {m['occlusionCulledPct']['on']} |"
                                 f" {m['occlusionCulledPerFrame']['off']} → {m['occlusionCulledPerFrame']['on']} |"
                                 f" {m['stillFramesDrawnInFull']['off']} → {m['stillFramesDrawnInFull']['on']} |")
                lines.append("")
            hooks = j.get("hooks") or {}
            if hooks:
                lines.append("Speed hooks: " + ", ".join(f"{k} {v}" for k, v in sorted(hooks.items())) + "\n")
    # gates
    lines.append("## Gates (ci/speed-gates.json)\n")
    if not found:
        lines.append("No speed runs in this run (quick mode without [speed]): gates not checked.\n" if quick else "No speed runs.\n")
    else:
        lines.append("| setting | scene | run | metric | value | limit | |\n|---|---|---|---|---|---|---|")
        for g in gates:
            for run in g["runs"]:
                j = data.get(run, {}).get(g["scene"])
                if j is None:
                    if run in data or not quick or (expected is not None and run in expected):
                        failures.append(f"speed gate {g['setting']} {g['scene']} {run}: no result")
                    continue
                e = next((x for x in j.get("ab", []) if x["setting"] == g["setting"]
                          and ("onValue" not in g or x["onValue"] == g["onValue"])), None)
                if e is None:
                    failures.append(f"speed gate {g['setting']} {g['scene']} {run}: the switch was not measured")
                    continue
                m = e["medians"][g["metric"]]
                v = m["on"] if g.get("value") == "on" else m["onOverOff"]
                ok = True
                if "max" in g and v > g["max"]:
                    ok = False
                if "min" in g and v < g["min"]:
                    ok = False
                lim = ("<= %s" % g["max"]) if "max" in g else (">= %s" % g["min"])
                rr = m.get("roundRatios")
                rounds = f" (rounds {', '.join(str(x) for x in rr)})" if rr and g.get("value") != "on" else ""
                lines.append(f"| {g['setting']} | {g['scene']} | {run} | {g['metric']}{' (on)' if g.get('value') == 'on' else ' on/off'} | {v}{rounds} | {lim} | {'ok' if ok else '**FAIL**'} |")
                if not ok:
                    failures.append(f"speed gate {g['setting']} {g['scene']} {run}: {g['metric']} {v} not {lim} ({g['reason']})")
        lines.append("")
    lines.append("## Speed failures\n")
    lines.extend(f"- {f}" for f in failures) if failures else lines.append("none")
    open(os.path.join(rep, "speed.md"), "w").write("\n".join(lines) + "\n")
    json.dump(data, open(os.path.join(rep, "speed.json"), "w"), indent=1)
    print("\n".join(lines))
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
