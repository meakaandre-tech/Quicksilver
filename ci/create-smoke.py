#!/usr/bin/env python3
"""Package A: the Create + Flywheel smoke job's check.

usage: create-smoke.py RESULTS_DIR REPORT_DIR

The job (suite "create", run quicksilver-smoke, full GPU profile) loads the core world with Create Fly (which carries
Flywheel) and Quicksilver on the server and the client and plays the create_smoke scene. It passes when the client
joined and the scene's bench finished, there is no crash report, the client log has no ERROR line and no mixin that
failed to apply, Create Fly is loaded with Quicksilver's Flywheel compatibility (package 5) on, and Flywheel drew
visuals. No picture comparison: the scene only has to draw without errors. Writes REPORT_DIR/create-smoke.md.
"""
import glob
import json
import os
import re
import sys


def norm(line):
    """An ERROR line without its time stamp and thread: '(logger) message'."""
    return re.sub(r"^\[[^\]]*\] \[[^\]]*/ERROR\] ", "", line.strip())


def main():
    res, rep = sys.argv[1], sys.argv[2]
    os.makedirs(rep, exist_ok=True)
    quick = os.environ.get("CI_MODE", "full") == "quick"
    d = os.path.join(res, "create-quicksilver-smoke")
    fails, lines = [], ["# Create + Flywheel smoke (package A)\n"]
    expected = "quicksilver-smoke" in os.environ.get("CI_EXTRA_RUNS", "").split()
    if not os.path.isdir(d):
        if not quick or expected:
            fails.append("the smoke run produced no results")
        lines.append("No smoke run in this run" + (" (quick mode without [create])." if quick else "."))
    else:
        logs = sorted(glob.glob(os.path.join(d, "client-*.log")))
        text = "\n".join(open(p, errors="replace").read() for p in logs)
        if not logs or not text.strip():
            fails.append("no client log")
        drives = [x for f in glob.glob(os.path.join(d, "drive-*.json")) for x in json.load(open(f))]
        scene = next((x for x in drives if x.get("scene") == "create_smoke"), None)
        if scene is None:
            fails.append("create_smoke did not run (client did not join?)")
        elif scene.get("skipped"):
            fails.append("create_smoke was skipped: " + scene["skipped"])
        elif scene.get("bench") != "done":
            fails.append("create_smoke's bench did not finish: %s" % scene.get("bench"))
        if glob.glob(os.path.join(d, "client-crash-reports*", "*")) or glob.glob(os.path.join(d, "server-crash-reports*", "*")):
            fails.append("a crash report was written")
        # an ERROR line vanilla's own run (core vanilla-a, same machine image) also logs is the runner's environment (no
        # sound device, no network for Realms and profiles), reported, not failed
        noise = set()
        for p in glob.glob(os.path.join(res, "core-vanilla-a", "client-*.log")):
            for l in open(p, errors="replace"):
                if re.search(r"/ERROR\]", l):
                    noise.add(norm(l))
        all_errors = [l for l in text.splitlines() if re.search(r"/ERROR\]", l)]
        errors = [l for l in all_errors if norm(l) not in noise]
        env = sorted({norm(l) for l in all_errors if norm(l) in noise})
        mixin = [l for l in text.splitlines() if re.search(r"Mixin apply (for mod \S+ )?failed|InvalidInjectionException|MixinApplyError", l)]
        for l in errors[:10]:
            fails.append("client ERROR: " + l.strip()[:300])
        if len(errors) > 10:
            fails.append("... %d more ERROR lines" % (len(errors) - 10))
        for l in mixin[:5]:
            fails.append("mixin: " + l.strip()[:300])
        compat = re.findall(r"Quicksilver compat: Flywheel backend .*", text)
        if not compat:
            fails.append("no 'Quicksilver compat: Flywheel backend' line: Quicksilver's Flywheel compatibility did not start")
        benches = [json.load(open(f)) for f in sorted(glob.glob(os.path.join(d, "bench", "*-create_smoke.json")))]
        fw = benches[-1].get("flywheel", {}) if benches else {}
        if not benches:
            fails.append("no bench report for create_smoke")
        elif fw.get("createFly", "absent") == "absent":
            fails.append("the bench says Create Fly is absent")
        elif not fw.get("visuals"):
            fails.append("Flywheel drew no visuals (%s)" % fw)
        server = "\n".join(open(p, errors="replace").read() for p in glob.glob(os.path.join(d, "server*.log")))
        if "Done (" not in server:
            fails.append("the server did not start")
        lines.append(f"- client logs: {len(logs)}; ERROR lines: {len(errors)} (and {len(all_errors) - len(errors)} that vanilla-a's run logs too:"
                     f" {'; '.join(env)[:400] or 'none'}); mixin failures: {len(mixin)}")
        if not noise:
            lines.append("- (no vanilla-a client log to tell environment noise apart: every ERROR line fails)")
        lines.append(f"- Flywheel compat: {compat[0][:200] if compat else 'none'}")
        lines.append(f"- bench flywheel block: {json.dumps(fw)[:400]}")
        lines.append(f"- shot: {os.path.exists(os.path.join(d, 'shots', 'create_smoke.png'))}")
    lines.append("\n## Result\n\n**%s**" % ("PASS" if not fails else "FAIL"))
    lines += ["- " + f for f in fails]
    open(os.path.join(rep, "create-smoke.md"), "w").write("\n".join(lines) + "\n")
    print("\n".join(lines))
    sys.exit(1 if fails else 0)


if __name__ == "__main__":
    main()
