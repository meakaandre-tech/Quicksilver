# Speed runs (package A)

Each speed run plays the scenes with a `speedAb` list once more, with Quicksilver's defaults, the frame limit and vsync off: first a stage profile (where frame time goes, the GPU waited for at each stage), then each switch off against on, rounds of five seconds a side (off-on, on-off, off-on, ...), in the same session: three for an option, five for an approximation or CI switch (the gated ones). Each side: the median over the rounds; on/off: from the rounds' own ratios, with five rounds their geometric mean without the highest and lowest, with three their median. On/off below 1 means the switch made it smaller.

## speed-old: no results

## speed-full: no results

## Gates (ci/speed-gates.json)

No speed runs in this run (quick mode without [speed]): gates not checked.

## Speed failures

none
