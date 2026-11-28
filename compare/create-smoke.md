# Create + Flywheel smoke (package A)

- client logs: 2; ERROR lines: 0 (and 6 that vanilla-a's run logs too: (Minecraft) Error starting SoundSystem. Turning off sounds & music; (Minecraft) Error while loading the narrator; (Minecraft) Failed to fetch Realms feature flags; (Minecraft) Failed to fetch user properties); mixin failures: 0
- Flywheel compat: Quicksilver compat: Flywheel backend flywheel:indirect (instancing with GPU culling (compute shaders, indirect draws)); Quicksilver keeps Flywheel's hooks: block entities through vanilla's block-entit
- bench flywheel block: {"createFly": "6.0.9-1", "backend": "flywheel:indirect", "backendNote": "instancing with GPU culling (compute shaders, indirect draws)", "backendChoicesInWindow": 0, "framesDrawingBeforeTerrain": 601, "frames": 600, "visuals": 13, "hooks": {"blockEntityStep": true, "lightUpdate": true, "beforeSolid": true}}
- shot: True

## Result

**PASS**
