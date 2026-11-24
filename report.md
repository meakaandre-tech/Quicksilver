# [rerun] check for run 45337291458 (b3de28f, attempt 1)

Run: https://github.com/meakaandre-tech/Quicksilver/actions/runs/45337291458

## Failed jobs

- infra: server (terralith, vanilla-a) (failed in Set up job)
- comparison: server-compare

## Comparison failures (published reports)

- missing run: report.md: terralith: run vanilla-a missing
- missing run: report.md: terralith worldgen vanilla-a: the harness did not finish (no result)
- names terralith: report.md: terralith worldgen vanilla-a: no CI HARNESS GEN DONE in its log
- missing run: report.md: terralith worldgen (byte for byte): a world is missing or the comparison failed
- missing run: report.md: terralith worldgen (block by block): a world is missing or the comparison failed
- missing run: report.md: terralith heap run vanilla-a: no finished heap run (no result)
- names terralith: report.md: terralith heap run: no live heap after load in every run
- names terralith: report.md: terralith heap run: no live heap after ten minutes in every run

## Decision: RE-RUN the failed jobs

Why: infrastructure failure only (server (terralith, vanilla-a) (failed in Set up job)); every comparison failure is a missing run caused by it.

Re-run requested at 2026-11-24T07:41:20Z by https://github.com/meakaandre-tech/Quicksilver/actions/runs/45349876146
