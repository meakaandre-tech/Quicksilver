#!/usr/bin/env python3
"""Where the server thread's time goes in a chunk scene (phase 2, P2-4; ci/server/chunks-run.sh, every round).

usage: chunks-jfr.py RECORDING.jfr OUT.json TICKS START_MS END_MS

Reads every server-thread sample of the recording, Java (jdk.ExecutionSample) and native (jdk.NativeMethodSample: zlib
compression, file writes), both taken every millisecond, in the tick (MinecraftServer.tickServer on the stack) and
between ticks (the server runs chunk tasks while it waits for the next tick), and puts each sample in the first
phase of PHASES whose frame is on its stack (so a save inside an unload counts as a save). A sample stands for about
one millisecond of the thread's time; ms per tick is a phase's samples over the run's ticks. Only samples inside the
run's wall-clock window count (START_MS and END_MS, epoch milliseconds, from the harness's result:
runStartEpochMs, runEndEpochMs): start-up and the window loading while frozen are left out.

Writes: per phase, samples in the tick and between ticks (Java and native apart), ms per tick; the server thread's top
methods (self and inclusive) among chunk frames; every thread's sample count by name (the chunk IO and worker
threads' share of the work); allocation on the server thread in the chunk phases. Method names only (no code): the
summary is published on the ci-logs branch.
"""
import json
import re
import subprocess
import sys
from collections import Counter, defaultdict

# exclusive, in this order: the first phase whose frame is on a sample's stack takes it
PHASES = [
    ("autosave", r"^MinecraftServer\.(autoSave|saveEverything|saveAllChunks)$"),
    ("chunk save", r"^ChunkMap\.(save|saveChunkIfNeeded|saveAllChunks|saveChunksEagerly)$|^SerializableChunkData\.(copyOf|write)|"
                   r"^ChunkSerializer\.write|^ChunkStorage\.write|^IOWorker\.store|^RegionFile\.write|^NbtIo\.write|^RegionFileStorage\.write"),
    ("entity save", r"^PersistentEntitySectionManager\.(storeChunkSections|saveAll|autoSave)|^EntityStorage\.storeEntities"),
    ("POI save", r"^SectionStorage\.(flush|writeColumn|tick)|^PoiManager\.(flush|tick)"),
    ("chunk load", r"^SerializableChunkData\.(read|parse)|^ChunkSerializer\.read|^ChunkMap\.(scheduleChunkLoad|readChunk|read)$|"
                   r"^IOWorker\.(load|loadAsync)|^RegionFile\.getChunkDataInputStream|^NbtIo\.read|^RegionFileStorage\.read|^ChunkStorage\.read"),
    ("chunk to full (promote)", r"^ChunkMap\.protoChunkToFullChunk$|^LevelChunk\.(<init>|runPostLoad|registerAllBlockEntitiesAfterLevelLoad)|"
                                r"^GenerationChunkHolder\.|^ChunkGenerationTask\.|^ChunkHolder\.(completeFutures|demoteFullChunk)"),
    ("entity load", r"^PersistentEntitySectionManager\.(requestChunkLoad|processPendingLoads|addEntity)|^EntityStorage\.loadEntities"),
    ("POI load", r"^SectionStorage\.(readColumn|getOrLoad|getOrCreate|onSectionLoad)|^PoiManager\.checkConsistency"),
    ("chunk unload", r"^ChunkMap\.(processUnloads|scheduleUnload|onChunkUnload)|^LevelChunk\.(clearAllBlockEntities|unregister)"),
    ("light", r"^ThreadedLevelLightEngine\.|^LightEngine\.|^LevelLightEngine\."),
    ("chunk system (tickets, holders, tasks)", r"^ChunkMap\.|^DistanceManager\.|^TicketStorage\.|^ChunkHolder\.|^ServerChunkCache\.|"
                                               r"^ChunkTaskDispatcher\.|^ChunkTaskPriorityQueue\.|^ChunkTrackingView\."),
    ("tick, other", r"^MinecraftServer\.tickServer$"),
]
# for each anchor: the methods it calls directly (the frame below it on the stack) and two levels down, in the samples
# that pass through it: where inside a load or a save the time goes
ANCHORS = ["SerializableChunkData.copyOf", "ChunkMap.save", "ChunkMap.saveChunksEagerly", "ChunkMap.processUnloads",
           "ChunkMap.saveAllChunks", "MinecraftServer.saveEverything", "ServerLevel.save", "SerializableChunkData.read",
           "ChunkMap.protoChunkToFullChunk", "LevelChunk.postProcessGeneration", "DistanceManager.runAllUpdates",
           "LevelChunk.<init>", "LevelChunk.runPostLoad", "SectionStorage.flush", "PersistentEntitySectionManager.autoSave"]
SUMMED = ("chunk load", "chunk to full (promote)", "entity load", "POI load")
SAVE = ("chunk save", "entity save", "POI save", "autosave")

FRAME = re.compile(r"^\s+([\w$.<>]+)\(")


def short(full):
    parts = full.split(".")
    return ".".join(parts[-2:]) if len(parts) >= 2 else full


def events(path, kinds, depth=256):
    p = subprocess.Popen(["jfr", "print", "--events", ",".join(kinds), "--stack-depth", str(depth), path],
                         stdout=subprocess.PIPE, text=True, errors="replace")
    kind, thread, stack, in_stack, weight, t = None, None, [], False, 0, None
    for line in p.stdout:
        s = line.strip()
        head = s.split(" ")[0] if s else ""
        if head in kinds:
            kind, thread, stack, in_stack, weight, t = head, None, [], False, 0, None
        elif s.startswith("startTime = "):
            t = when(s[len("startTime = "):])
        elif s.startswith("sampledThread") or s.startswith("eventThread"):
            m = re.search(r'"([^"]*)"', s)
            thread = m.group(1) if m else None
        elif s.startswith("weight = "):
            m = re.match(r"weight = ([\d.]+) (bytes|kB|MB|GB)", s)
            if m:
                weight = float(m.group(1)) * {"bytes": 1, "kB": 1024, "MB": 1 << 20, "GB": 1 << 30}[m.group(2)]
        elif s.startswith("stackTrace = ["):
            in_stack = True
        elif in_stack and s == "]":
            in_stack = False
        elif in_stack:
            m = FRAME.match(line)
            if m:
                stack.append(m.group(1))
        elif s == "}" and kind:
            yield kind, thread, stack, weight, t
            kind = None
    p.wait()


def when(text):
    """jfr print's "14:22:33.123 (2026-11-06)" (the runner's local time, UTC on CI) as epoch milliseconds."""
    import calendar
    m = re.match(r"(\d+):(\d+):(\d+)(?:\.(\d+))? \((\d+)-(\d+)-(\d+)\)", text)
    if not m:
        return None
    h, mi, se, frac, y, mo, d = m.groups()
    ms = int((frac or "0").ljust(3, "0")[:3])
    return calendar.timegm((int(y), int(mo), int(d), int(h), int(mi), int(se))) * 1000 + ms


def phase_of(names, pats):
    seen = set(names)
    for name, rx in pats:
        if any(rx.search(x) for x in seen):
            return name
    return None


def main(rec, out, ticks, start_ms, end_ms):
    pats = [(n, re.compile(rx)) for n, rx in PHASES]
    by = defaultdict(Counter)  # phase -> Counter{"tick java", "tick native", "between java", "between native"}
    threads = Counter()
    self_c, incl = Counter(), Counter()
    total = Counter()
    anchors = {a: [0, Counter(), Counter()] for a in ANCHORS}
    outside, untimed = 0, 0
    for kind, thread, stack, _, t in events(rec, ["jdk.ExecutionSample", "jdk.NativeMethodSample"]):
        if t is None:
            untimed += 1  # a time format this script doesn't read: counted (reported as untimed)
        elif t < start_ms or t > end_ms:
            outside += 1
            continue
        if thread:
            threads[re.sub(r"[-#]?\d+$", "", thread)] += 1
        if thread != "Server thread" or not stack:
            continue
        names = [short(f) for f in stack]
        where = "tick" if "MinecraftServer.tickServer" in names else "between"
        kind_s = "java" if kind == "jdk.ExecutionSample" else "native"
        ph = phase_of(names, pats) or ("idle or other" if where == "between" else "tick, other")
        by[ph][where + " " + kind_s] += 1
        total[where + " " + kind_s] += 1
        for a, acc in anchors.items():
            if a in names:
                i = names.index(a)  # stack[0] is the top frame: callees have lower indices
                acc[0] += 1
                if i >= 1:
                    acc[1][names[i - 1]] += 1
                if i >= 2:
                    acc[2][names[i - 1] + " > " + names[i - 2]] += 1
        if ph not in ("tick, other", "idle or other"):
            self_c[names[0]] += 1
            for x in set(names):
                incl[x] += 1
    alloc = Counter()
    for kind, thread, stack, w, t in events(rec, ["jdk.ObjectAllocationSample"], 64):
        if (t is not None and (t < start_ms or t > end_ms)) or thread != "Server thread" or not stack:
            continue
        ph = phase_of([short(f) for f in stack], pats)
        if ph:
            alloc[ph] += w
    phases = []
    for name, _ in PHASES + [("idle or other", None)]:
        c = by.get(name, Counter())
        n_tick = c["tick java"] + c["tick native"]
        n_between = c["between java"] + c["between native"]
        phases.append({"phase": name, "tickJava": c["tick java"], "tickNative": c["tick native"],
                       "betweenJava": c["between java"], "betweenNative": c["between native"],
                       "msPerTickInTick": round(n_tick / ticks, 4) if ticks else None,
                       "msPerTickAll": round((n_tick + n_between) / ticks, 4) if ticks else None,
                       "allocMB": round(alloc[name] / (1 << 20), 2)})

    def summed(names):
        s_tick = sum(p["tickJava"] + p["tickNative"] for p in phases if p["phase"] in names)
        s_all = s_tick + sum(p["betweenJava"] + p["betweenNative"] for p in phases if p["phase"] in names)
        return {"msPerTickInTick": round(s_tick / ticks, 4), "msPerTickAll": round(s_all / ticks, 4)}

    res = {"ticks": ticks, "windowMs": end_ms - start_ms, "samplesOutsideWindow": outside, "samplesUntimed": untimed, "samples": dict(total), "phases": phases,
           "load": summed(SUMMED), "save": summed(SAVE), "autosave": summed(("autosave",)),
           "anchors": {a: {"samples": v[0], "callees": [{"method": k, "samples": n} for k, n in v[1].most_common(15)],
                           "callees2": [{"path": k, "samples": n} for k, n in v[2].most_common(20)]}
                       for a, v in anchors.items() if v[0]},
           "self": [{"method": k, "samples": v} for k, v in self_c.most_common(60)],
           "inclusive": [{"method": k, "samples": v} for k, v in incl.most_common(150)],
           "threads": [{"thread": k, "samples": v} for k, v in threads.most_common(30)]}
    with open(out, "w") as f:
        json.dump(res, f, indent=1)
    print("%s: server thread %s; load %.3f, save %.3f ms per tick (in the tick and between)" % (
        rec, dict(total), res["load"]["msPerTickAll"], res["save"]["msPerTickAll"]))
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 6:
        print(__doc__)
        sys.exit(2)
    sys.exit(main(sys.argv[1], sys.argv[2], int(sys.argv[3]), int(sys.argv[4]), int(sys.argv[5])))
