#!/usr/bin/env python3
"""Package B: the worst frame of terrain uploads, gated (R1: one laptop frame uploaded 987 KB against a ~351 KB budget,
one upload took 58 ms).

usage: upload-compare.py RESULTS_DIR REPORT_DIR

For every Quicksilver client run (core-quicksilver-*, core-sp-quicksilver) and every scene listed in
ci/upload-gates.json, reads the bench's uploadBudget block; in the runs listed in "gatedRuns" (the plain-path ones) it
checks:
- framesOverHardCap == 0: no frame copied in more than the hard cap (twice the byte budget), counting what the cap
  governs (outside the camera's sections, index lists and overdue meshes forced in), beyond the frame's first mesh;
- the slowest frame's whole terrain upload on the render thread (arena grows included) <= the scene's limit, less the
  time the render thread waited for a CPU or stood in a stop-the-world GC pause during it (uploadMsMaxLessCpuWait: the
  runner's scheduler giving the CPU to other work, read from Linux's schedstat, and the JVM's GC pause time; CI flakes 2026-11-25: one 32.6 ms frame in run 45511522980 whose own work, the
  slowest arena grow, took 6.7 ms). The wall-clock slowest frame (uploadMsMax) and that frame's CPU wait are reported.
Writes REPORT_DIR/upload.md; exit 1 on a failed gate or a run that should have the scene and has no bench for it.
"""
import glob
import json
import os
import sys


def main():
    res, rep = sys.argv[1], sys.argv[2]
    os.makedirs(rep, exist_ok=True)
    cfg = json.load(open("ci/upload-gates.json"))
    failures, lines = [], ["# Terrain uploads: the worst frame (package B)\n", cfg.get("note", "") + "\n"]
    lines.append("| run | scene | bytes/frame | budget | hard cap (max) | largest frame | under the cap (max) | frames over cap |"
                 " upload ms max (less CPU wait; wait) | slowest mesh ms | arena grows (ahead) | grow ms max | limit ms | |")
    lines.append("|---|---|---|---|---|---|---|---|---|---|---|---|---|---|")
    runs = sorted(d for d in glob.glob(os.path.join(res, "core-*quicksilver*")) if os.path.isdir(d)
                  and not os.path.basename(d).startswith(("core-measure", "core-speed")))
    for d in runs:
        run = os.path.basename(d)[len("core-"):]
        for scene, gate in cfg["scenes"].items():
            if run in gate.get("skipRuns", []):
                continue
            files = sorted(glob.glob(os.path.join(d, "bench", f"*-{scene}.json")))
            if not files and run in cfg.get("gatedRuns", [run]):
                # every Quicksilver client run plays these scenes: a missing bench is a failure, not a pass
                failures.append(f"{run}/{scene}: no bench")
                lines.append(f"| {run} | {scene} | no bench | | | | | | | | | | | **FAIL** |")
                continue
            if not files:
                lines.append(f"| {run} | {scene} | no bench (reported run) | | | | | | | | | | | |")
                continue
            j = json.load(open(files[-1]))
            u = j.get("uploadBudget") or {}
            if "framesOverHardCap" not in u:
                failures.append(f"{run}/{scene}: no worst-frame upload numbers in the bench")
                continue
            gated = run in cfg.get("gatedRuns", [run])
            ok = True
            if not gated:
                lines.append(f"| {run} | {scene} | {u.get('bytesPerFrame')} | {u.get('budgetBytesPerFrame')} | {u.get('hardCapBytesMax')} |"
                             f" {u.get('maxBytesInOneFrame')} | {u.get('maxBytesUnderHardCap')} | {u.get('framesOverHardCap')} |"
                             f" {u.get('uploadMsMax')} ({u.get('uploadMsMaxLessCpuWait')}; {u.get('cpuWaitMsInThatFrame')}) | {u.get('slowestMeshMs')} | {u.get('arenaGrows')} ({u.get('arenaGrowsAhead')}) |"
                             f" {u.get('arenaGrowMsMax')} | reported | |")
                continue
            if u["framesOverHardCap"] > 0:
                ok = False
                failures.append(f"{run}/{scene}: {u['framesOverHardCap']} frames copied in more than the hard cap"
                                f" ({u['hardCapBytesMax']} bytes) outside the camera's sections")
            gated_ms = u.get("uploadMsMaxLessCpuWait", u["uploadMsMax"])
            if "uploadMsMaxLessCpuWait" in u and not u.get("framesWithCpuWaitKnown"):
                ok = False
                failures.append(f"{run}/{scene}: no frame's CPU wait could be read (schedstat)")
            if gated_ms > gate["uploadMsMax"]:
                ok = False
                failures.append(f"{run}/{scene}: the slowest frame's terrain upload took {gated_ms} ms less CPU wait"
                                f" ({u['uploadMsMax']} ms wall; limit {gate['uploadMsMax']} ms)")
            lines.append(f"| {run} | {scene} | {u.get('bytesPerFrame')} | {u.get('budgetBytesPerFrame')} | {u.get('hardCapBytesMax')} |"
                         f" {u.get('maxBytesInOneFrame')} | {u.get('maxBytesUnderHardCap')} | {u.get('framesOverHardCap')} |"
                         f" {u.get('uploadMsMax')} ({u.get('uploadMsMaxLessCpuWait')}; {u.get('cpuWaitMsInThatFrame')}) | {u.get('slowestMeshMs')} | {u.get('arenaGrows')} ({u.get('arenaGrowsAhead')}) |"
                         f" {u.get('arenaGrowMsMax')} | {gate['uploadMsMax']} | {'ok' if ok else '**FAIL**'} |")
    if not runs:
        failures.append("upload: no Quicksilver client runs found")
    lines.append("\n## Upload failures\n")
    lines.extend(f"- {f}" for f in failures) if failures else lines.append("none")
    open(os.path.join(rep, "upload.md"), "w").write("\n".join(lines) + "\n")
    print("\n".join(lines))
    sys.exit(1 if failures else 0)


if __name__ == "__main__":
    main()
