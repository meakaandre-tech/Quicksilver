#!/usr/bin/env python3
"""Writes ci/baselines/<suite>-<profile>.json from the report.json of several clean CI runs (compare.py output).

usage: make-baselines.py REPORT_JSON[=RUN_LABEL]...

Each run's label (its commit or run id) is listed in the baseline as "fromRuns".

Each count's baseline is the highest value seen across the runs: CI then fails when a build goes more than 10% (plus
compare.py's small step allowance) over the worst a clean build has done.
"""
import json
import os
import sys

KEYS = ["drawCallsPerFrame", "uploadsPerFrame", "uploadBytesPerFrame", "heapUsedAfterGcMB", "directBuffersMB"]
args = [a.split("=", 1) for a in sys.argv[1:]]
runs = [json.load(open(a[0]))["suites"] for a in args]
labels = [a[1] if len(a) > 1 else os.path.basename(a[0]) for a in args]
os.makedirs("ci/baselines", exist_ok=True)
for suite in runs[0]:
    for prof in runs[0][suite]["counts"]:
        out = {}
        for r, label in zip(runs, labels):
            for sid, c in r.get(suite, {}).get("counts", {}).get(prof, {}).items():
                o = out.setdefault(sid, {k: 0 for k in KEYS})
                for k in KEYS:
                    o[k] = max(o[k], c.get(k) or 0)
                o["runs"] = o.get("runs", 0) + 1
                o.setdefault("fromRuns", []).append(label)
        with open(f"ci/baselines/{suite}-{prof}.json", "w") as f:
            json.dump(out, f, indent=2, sort_keys=True)
            f.write("\n")
        print(suite, prof, len(out), "scenes")
