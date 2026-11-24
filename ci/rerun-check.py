#!/usr/bin/env python3
"""Decides whether main's latest Build run may be re-run ([rerun] in .github/workflows/cleanup.yml).

Usage: rerun-check.py RUN_JSON JOBS_JSON LOGS_DIR OUT_MD
  RUN_JSON   GitHub's run object (actions/runs/<id>)
  JOBS_JSON  its jobs ({"jobs": [...]}, actions/runs/<id>/jobs, latest attempt)
  LOGS_DIR   holds client/ (ci-logs-main) and server/ (ci-logs-server-main), each with commit.txt and compare/*.md
  OUT_MD     the report (also the step summary)
Prints "rerun" or "no" on stdout. Exit 0 either way.

Rules (Andre, 2026-11-24): only main's latest run, only its failed jobs, at most once per run (attempt 1), and only for
infrastructure failures, never for a real Quicksilver failure:
- a test job's failure is infra only if it failed in GitHub's own "Set up job" step (runner set-up, action download) or
  failed with no failed or cancelled step at all (runner lost); any other failed step, or a cancelled one (a timeout:
  a hang), counts as real;
- the comparison jobs (compare, server-compare) fail when a run is missing: their failure is explained only if at least
  one test job failed for infra and every failure line in their published reports either says a run, world, dump or
  result is missing, or names that infra job's suite or run (its matrix values but "core", e.g. "terralith" for
  "server (terralith, vanilla-a)"). Report sections read: **FAIL** / **FAILED** lists, any "... failures" heading's
  list, and table rows marked **FAIL**. Only the failed jobs are re-run: the passing Quicksilver jobs keep their results, so a
  real Quicksilver difference in them shows again in the re-run's comparison;
- anything else (a real failure, an unexplained comparison failure, a run that isn't complete or isn't failed, attempt 2+)
  is not re-run, and the report says why.
"""
import glob
import json
import os
import re
import sys

AGGREGATORS = {"compare", "server-compare"}
SKIP = {"release"}  # skipped when anything before it fails; re-run with its needs
MISSING = re.compile(r"missing|did not run|no results?\b|lost its results|did not finish", re.I)


def failure_lines(d):
    """Failure bullets of every report in d/compare: lines under a FAIL/FAILED/Failures heading."""
    out = []
    for p in sorted(glob.glob(os.path.join(d, "compare", "*.md"))):
        take = False
        for line in open(p, errors="replace"):
            s = line.strip()
            # **FAIL** / **FAILED** (compare.py, compare-server.py) and any "... failures" heading (Speed, Upload, chunks)
            if re.match(r"^(\*\*FAIL(ED)?\*\*|#+ .*[Ff]ailures?)$", s):
                take = True
                continue
            if take:
                if s.startswith("- "):
                    out.append("%s: %s" % (os.path.basename(p), s[2:]))
                elif s.startswith("#") or s.startswith("**"):
                    take = False
            # a gate row marked **FAIL** in any table counts too
            if s.startswith("|") and "**FAIL**" in s:
                out.append("%s: %s" % (os.path.basename(p), s))
    return out


def logs_sha(d):
    try:
        return open(os.path.join(d, "commit.txt")).read().split()[0]
    except (OSError, IndexError):
        return None


def main(run_json, jobs_json, logs_dir, out_md):
    run = json.load(open(run_json))
    jobs = json.load(open(jobs_json))["jobs"]
    sha = run["head_sha"]
    lines = ["# [rerun] check for run %s (%s, attempt %s)\n" % (run["id"], sha[:7], run.get("run_attempt")),
             "Run: %s\n" % run.get("html_url", "")]
    reasons, infra, real, agg, tokens = [], [], [], [], set()

    if run.get("head_branch") != "main" or run.get("event") != "push":
        reasons.append("not a push run on main")
    if run.get("status") != "completed":
        reasons.append("run not finished (status %s)" % run.get("status"))
    elif run.get("conclusion") != "failure":
        reasons.append("run did not fail (conclusion %s)" % run.get("conclusion"))
    if (run.get("run_attempt") or 1) > 1:
        reasons.append("already re-run once (attempt %s): at most one re-run per run" % run.get("run_attempt"))

    for j in jobs:
        if j.get("conclusion") not in ("failure", "timed_out", "cancelled"):
            continue
        name = j["name"]
        base = name.split(" (")[0]
        if base in SKIP:
            continue
        steps = j.get("steps") or []
        failed = [s["name"] for s in steps if s.get("conclusion") == "failure"]
        cancelled = [s["name"] for s in steps if s.get("conclusion") == "cancelled"]
        if base in AGGREGATORS:
            agg.append(name)
        elif j.get("conclusion") == "failure" and (failed == ["Set up job"] or (not failed and not cancelled)):
            # a step cancelled under a failed job is a timeout (timeout-minutes): a hang is not infrastructure
            infra.append("%s (%s)" % (name, "failed in Set up job" if failed else "no failed or cancelled step: runner lost"))
            m = re.search(r"\((.*)\)$", name)
            # the job's matrix values; "core" (every job's suite) explains nothing
            tokens |= {t.strip() for t in m.group(1).split(",") if len(t.strip()) > 2 and t.strip() != "core"} if m else set()
        else:
            real.append("%s (failed step: %s)" % (name, ", ".join(failed) or j.get("conclusion")))

    lines.append("## Failed jobs\n")
    for n in infra:
        lines.append("- infra: %s" % n)
    for n in real:
        lines.append("- **real**: %s" % n)
    for n in agg:
        lines.append("- comparison: %s" % n)
    if not (infra or real or agg):
        lines.append("- none")

    if real:
        reasons.append("a test job failed in its own steps (a real failure, not re-run): " + "; ".join(real))
    if agg and not infra:
        reasons.append("a comparison failed with no infrastructure failure behind it: " + ", ".join(agg))
    if agg:
        lines.append("\n## Comparison failures (published reports)\n")
        for job, sub in (("compare", "client"), ("server-compare", "server")):
            if not any(a.split(" (")[0] == job for a in agg):
                continue
            d = os.path.join(logs_dir, sub)
            if logs_sha(d) != sha:
                reasons.append("%s: its published report is not from this run (%s)" % (job, logs_sha(d)))
                continue
            fl = failure_lines(d)
            if not fl:
                reasons.append("%s: failed but its report lists no failure line" % job)
            for f in fl:
                why = "missing run" if MISSING.search(f) else next(("names %s" % t for t in sorted(tokens) if t in f), None)
                ok = why is not None
                lines.append("- %s: %s" % (why if ok else "**not explained**", f))
                if not ok:
                    reasons.append("%s reports a failure that isn't a missing run: %s" % (job, f))
    if not (infra or real or agg) and not reasons:
        reasons.append("no failed job found")

    decision = "no" if reasons else "rerun"
    lines.append("\n## Decision: %s\n" % ("RE-RUN the failed jobs" if decision == "rerun" else "not re-run"))
    if decision == "rerun":
        lines.append("Why: infrastructure failure only (%s); every comparison failure is a missing run caused by it."
                     % "; ".join(infra))
    else:
        lines += ["- " + r for r in reasons]
    open(out_md, "w").write("\n".join(lines) + "\n")
    print(decision)


if __name__ == "__main__":
    main(*sys.argv[1:5])
