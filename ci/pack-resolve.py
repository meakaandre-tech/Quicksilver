#!/usr/bin/env python3
"""Resolves the test pack's third-party mods on Modrinth (the deliberate "pick a version" step; docs/ci-limits.md,
"Pack lock"). Input: ci/pack-resolve.txt, lines "<set>/<name>  <modrinth slug>" or "<set>/<name>  search:<words>".
For each, takes the newest Fabric build for the game version in gradle.properties (release channel first, else beta,
else alpha), downloads its primary file, and prints:
  - a ci/pack-sources.txt line (the file's own pinned URL),
  - a ci/pack-lock.txt line (sha256 of the download),
  - the project's licence, total downloads, version number and required dependencies, for the record.
Writes them to the output file (argument 1). Run in CI only: the agent workspace can't reach Modrinth.
"""
import hashlib, json, os, sys, urllib.parse, urllib.request

API = "https://api.modrinth.com/v2"
UA = {"User-Agent": "meakaandre-tech/Quicksilver CI pack resolver"}


def get(url):
    with urllib.request.urlopen(urllib.request.Request(url, headers=UA), timeout=60) as r:
        return r.read()


def j(url):
    return json.loads(get(url))


def main():
    out = sys.argv[1]
    mc = next(l.split("=", 1)[1].strip() for l in open("gradle.properties") if l.startswith("minecraft_version"))
    src, lock, info = [], [], []
    for line in open("ci/pack-resolve.txt"):
        line = line.strip()
        if not line or line.startswith("#"):
            continue
        key, ref = line.split(None, 1)
        if ref.startswith("search:"):
            q = urllib.parse.quote(ref[7:])
            facets = urllib.parse.quote(json.dumps([["categories:fabric"], ["versions:" + mc], ["project_type:mod"]]))
            hits = j(f"{API}/search?query={q}&facets={facets}&limit=5")["hits"]
            info.append(f"# search '{ref[7:]}': " + "; ".join(f"{h['slug']} ({h['title']}, {h['downloads']})" for h in hits))
            if not hits:
                info.append(f"# {key}: no Fabric {mc} project found")
                continue
            slug = hits[0]["slug"]
        else:
            slug = ref
        p = j(f"{API}/project/{slug}")
        loaders = urllib.parse.quote(json.dumps(["fabric"]))
        gv = urllib.parse.quote(json.dumps([mc]))
        vs = j(f"{API}/project/{slug}/version?loaders={loaders}&game_versions={gv}")
        if not vs:
            info.append(f"# {key}: {slug} has no Fabric {mc} version")
            continue
        rank = {"release": 0, "beta": 1, "alpha": 2}
        # newest of the best channel
        best = min(rank.get(x["version_type"], 3) for x in vs)
        v = sorted([x for x in vs if rank.get(x["version_type"], 3) == best], key=lambda x: x["date_published"])[-1]
        f = next((x for x in v["files"] if x.get("primary")), v["files"][0])
        data = get(f["url"])
        sha = hashlib.sha256(data).hexdigest()
        if hashlib.sha512(data).hexdigest() != f["hashes"].get("sha512", hashlib.sha512(data).hexdigest()):
            info.append(f"# {key}: sha512 does not match Modrinth's")
            continue
        name = urllib.parse.unquote(f["filename"])
        setname = key.split("/")[0]
        deps = []
        for d in v.get("dependencies") or []:
            if d.get("dependency_type") == "required":
                try:
                    deps.append(j(f"{API}/project/{d['project_id']}")["slug"])
                except Exception as e:  # noqa
                    deps.append(str(d.get("project_id")))
        lic = (p.get("license") or {}).get("id")
        src.append(f"{setname}/{name}  {f['url']}")
        lock.append(f"{sha}  {setname}/{name}")
        info.append(f"# {setname}/{name}: {p['title']} ({slug}) {v['version_number']} [{v['version_type']}], "
                    f"published {v['date_published'][:10]}; licence {lic}; project downloads {p['downloads']}; "
                    f"environment client={p.get('client_side')} server={p.get('server_side')}; required: {', '.join(deps) or '-'}")
    with open(out, "w") as o:
        o.write("# ci/pack-resolve.py output for Minecraft %s (Modrinth, %s)\n" % (mc, os.environ.get("GITHUB_RUN_ID", "local")))
        o.write("\n".join(info) + "\n\n# pack-sources.txt\n" + "\n".join(src) + "\n\n# pack-lock.txt\n" + "\n".join(lock) + "\n")
    print(open(out).read())


if __name__ == "__main__":
    main()
