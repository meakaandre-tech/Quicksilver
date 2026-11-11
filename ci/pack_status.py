"""The test pack's suites (2026-11-12, replacing SIFTEC's; this file was ci/siftec_status.py): names in the report why
the pack didn't start or wasn't put together, and, while the workflow's mode job sets CI_PACK_REPORT_ONLY=true, lists
the pack's failures (client or server) without failing on them; core and Terralith gate as usual. Gating by default."""
import glob
import os
import re

REPORT_ONLY = os.environ.get("CI_PACK_REPORT_ONLY") == "true"
# a pack mod not starting: an entrypoint error, or a missing class or method of another mod it calls
START_FAIL = re.compile(r"Could not execute entrypoint stage '\w+' due to errors|Incompatible mods? found|"
                        r"net\.fabricmc\.loader\.impl\.FormattedException", re.I)
# the pack not even put together: a jar that isn't the locked one, or no download
PACK_FAIL = re.compile(r"^pack changed: .*$|^could not assemble the test pack.*$|^pack: could not fetch .*$|^pack: no Modrinth version .*$", re.M)


def is_pack(failure):
    return failure.startswith(("pack", "suite pack"))


def start_status(res):
    """{run directory: why the pack didn't start} for every pack run: not assembled (run.txt), a mod failing at
    start-up (a log), or no game log at all."""
    bad = {}
    for d in sorted(glob.glob(os.path.join(res, "pack-*"))):
        try:
            run = open(os.path.join(d, "run.txt"), errors="replace").read()
        except OSError:
            run = ""
        packs = PACK_FAIL.findall(run)
        if packs:
            bad[os.path.basename(d)] = "the pack: " + "; ".join(p.strip()[:160] for p in packs[:3])
            continue
        logs = [f for f in glob.glob(os.path.join(d, "**", "*.log"), recursive=True)]
        if not logs:
            bad[os.path.basename(d)] = "no game log"
            continue
        for f in sorted(logs):
            try:
                text = open(f, errors="replace").read()
            except OSError:
                continue
            m = START_FAIL.search(text)
            if m:
                line = text[text.rfind("\n", 0, m.start()) + 1:text.find("\n", m.end()) if "\n" in text[m.end():] else len(text)]
                bad[os.path.basename(d)] = "%s: %s" % (os.path.relpath(f, d), line.strip()[:240])
                break
    return bad


def split(failures, res, world_txt=None):
    """(gating failures, the pack's report-only failures, report lines). Without report-only mode, everything gates.
    world_txt: the pack world job's log (the client suite's runs all start from that world)."""
    bad = start_status(res)
    lines = []
    runs = glob.glob(os.path.join(res, "pack-*"))
    world = ""
    if world_txt:
        try:
            world = open(world_txt, errors="replace").read()
        except OSError:
            world = ""
    packs = PACK_FAIL.findall(world)
    if packs:
        lines.append("**The test pack's world job stopped at the pack check** (the pack's runs need its world):\n")
        lines += ["- `%s`" % p.strip()[:200] for p in packs[:6]]
        lines.append("")
    if not runs and any(is_pack(f) for f in failures):
        lines.append("**No test pack run left any results** (its world or pack job failed first).\n")
    if bad:
        lines.append("**The test pack did not start** in %d of %d run(s):\n" % (len(bad), len(runs)))
        lines += ["- %s: `%s`" % (r, e) for r, e in sorted(bad.items())]
        lines.append("")
    # a pack that didn't assemble or start is named in the failure list itself, not only in the notes above
    failures = list(failures) + ["pack world job: %s" % p.strip()[:200] for p in packs[:6]]
    failures += ["%s: %s" % (r, e) for r, e in sorted(bad.items())]
    if not REPORT_ONLY:
        return failures, [], lines
    gate = [f for f in failures if not is_pack(f)]
    soft = [f for f in failures if is_pack(f)]
    head = ["## Test pack: report only\n", "The test pack's suites fail nothing while CI_PACK_REPORT_ONLY=true. Core and"
            " Terralith gate as usual.\n"]
    if runs and not bad:
        head.append("The test pack started in every run.\n")
    body = ["Test pack failures (not gating):\n"] + ["- " + f for f in soft] if soft else ["No test pack failures.\n"]
    return gate, soft, head + lines + body + [""]
