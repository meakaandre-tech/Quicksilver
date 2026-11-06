# Chunk scenes (P2-4)

Measuring: everything below is reported, nothing is gated yet.

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.946 | 6.186 | 14.213 | 0 | 0.137 (0.049) | 0.185 (0.185) | 0.000 | - | 0: 14.2, 8: 14.0, 896: 13.5, 1139: 10.8, 40: 9.4 |
| 1 | quicksilver | yes | 1.015 | 6.672 | 18.909 | 0 | 0.121 (0.053) | 0.203 (0.203) | 0.000 | - | 856: 18.9, 8: 16.7, 0: 15.1, 203: 14.1, 88: 12.9 |
| 2 | vanilla | yes | 0.965 | 6.756 | 18.993 | 0 | 0.133 (0.063) | 0.188 (0.188) | 0.000 | - | 88: 19.0, 8: 15.6, 0: 15.0, 376: 13.5, 40: 12.5 |
| 2 | quicksilver | yes | 0.947 | 5.264 | 22.808 | 0 | 0.120 (0.056) | 0.195 (0.195) | 0.000 | - | 8: 22.8, 355: 16.9, 0: 16.0, 57: 15.3, 40: 11.0 |
| 3 | vanilla | yes | 1.022 | 6.156 | 14.728 | 0 | 0.128 (0.052) | 0.217 (0.217) | 0.000 | - | 8: 14.7, 0: 13.9, 120: 12.8, 104: 11.1, 1016: 10.9 |
| 3 | quicksilver | yes | 1.181 | 6.663 | 14.396 | 0 | 0.143 (0.059) | 0.243 (0.243) | 0.000 | - | 8: 14.4, 0: 13.2, 40: 12.4, 712: 12.3, 32: 9.4 |
| 4 | vanilla | yes | 1.050 | 6.576 | 17.914 | 0 | 0.122 (0.052) | 0.207 (0.207) | 0.000 | - | 0: 17.9, 8: 16.8, 224: 14.6, 24: 12.6, 40: 12.0 |
| 4 | quicksilver | yes | 1.298 | 7.052 | 18.750 | 0 | 0.149 (0.063) | 0.257 (0.257) | 0.000 | - | 8: 18.8, 40: 18.2, 0: 16.0, 120: 13.5, 98: 12.8 |
| 5 | vanilla | yes | 1.597 | 9.063 | 19.112 | 0 | 0.158 (0.070) | 0.346 (0.346) | 0.000 | - | 8: 19.1, 1136: 16.3, 0: 16.1, 256: 13.7, 960: 13.0 |
| 5 | quicksilver | yes | 1.222 | 6.832 | 20.570 | 0 | 0.145 (0.058) | 0.273 (0.273) | 0.000 | - | 8: 20.6, 64: 16.6, 40: 16.4, 816: 16.2, 0: 14.3 |
| 6 | vanilla | yes | 1.065 | 5.907 | 17.308 | 0 | 0.138 (0.058) | 0.217 (0.217) | 0.000 | - | 8: 17.3, 0: 15.6, 65: 14.4, 40: 12.1, 24: 10.5 |
| 6 | quicksilver | yes | 1.004 | 7.144 | 14.645 | 0 | 0.133 (0.059) | 0.205 (0.205) | 0.000 | - | 8: 14.6, 0: 13.9, 40: 13.7, 24: 13.0, 952: 12.1 |
| 7 | vanilla | yes | 1.159 | 6.511 | 17.378 | 0 | 0.133 (0.058) | 0.228 (0.228) | 0.000 | - | 8: 17.4, 0: 14.2, 640: 13.3, 40: 13.1, 688: 12.7 |
| 7 | quicksilver | yes | 1.383 | 8.849 | 20.200 | 0 | 0.152 (0.075) | 0.306 (0.306) | 0.000 | - | 8: 20.2, 0: 17.0, 98: 14.9, 648: 14.4, 40: 13.8 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 1.050 | 1.181 | 1.073 (0.77 to 1.24) |
| MSPT p99 | 6.511 | 6.832 | 1.079 (0.75 to 1.36) |
| slowest tick (ms) | 17.378 | 18.909 | 1.076 (0.85 to 1.33) |
| ticks over 50 ms | 0 | 0 | - (- to -) |
| chunk load, ms per tick (server thread) | 0.133 | 0.143 | 0.964 (0.88 to 1.22) |
|   of it in the tick | 0.058 | 0.059 | 1.083 (0.83 to 1.29) |
| chunk save, ms per tick (server thread) | 0.217 | 0.243 | 1.099 (0.79 to 1.34) |
|   of it in the tick | 0.217 | 0.243 | 1.099 (0.79 to 1.34) |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 59846 ms, 17223 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 204 / 0 | 0 / 0 | 0.170 | 387.6 |
| entity save | 15 / 0 | 0 / 0 | 0.013 | 6.9 |
| POI save | 3 / 0 | 0 / 0 | 0.003 | 0.0 |
| chunk load | 0 / 0 | 49 / 1 | 0.042 | 55.4 |
| chunk to full (promote) | 53 / 0 | 52 / 0 | 0.087 | 20.6 |
| entity load | 6 / 0 | 3 / 0 | 0.007 | 0.6 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 10 / 0 | 0 / 0 | 0.008 | 39.3 |
| light | 0 / 0 | 5 / 0 | 0.004 | 0.0 |
| chunk system (tickets, holders, tasks) | 310 / 0 | 162 / 0 | 0.393 | 225.5 |
| tick, other | 203 / 1 | 0 / 0 | 0.170 | 0.6 |
| idle or other | 0 / 0 | 50 / 0 | 0.042 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 868, MinecraftServer.runServer 868, Thread.run 867, MinecraftServer.processPacketsAndTick 601, DedicatedServer.tickServer 601, MinecraftServer.tickServer 601, ServerLevel.tick 593, MinecraftServer.tickChildren 593, ServerChunkCache.tick 564, ServerChunkCache.runDistanceManagerUpdates 296, DistanceManager.runAllUpdates 295, ServerChunkCache$MainThreadExecutor.pollTask 270, ServerChunkCache.pollTask 270, MinecraftServer.pollTaskInternal 269, MinecraftServer.waitUntilNextTick 268, MinecraftServer.pollTask 268, BlockableEventLoop.pollTask 260, BlockableEventLoop.doRunTask 257, ServerChunkCache$MainThreadExecutor.doRunTask 255, BlockableEventLoop.managedBlock 254, ChunkMap.tick 228, CompletableFuture$Completion.run 218, ChunkMap.processUnloads 215, DynamicGraphMinFixedPoint.runUpdates 197, LoadingChunkTracker.runDistanceUpdates 194, CompletableFuture$UniApply.tryFire 193, ChunkMap.saveChunksEagerly 188, ChunkTracker.checkNeighborsAfterUpdate 164, DynamicGraphMinFixedPoint.checkNeighbor 162, ChunkMap.save 158, SerializableChunkData.copyOf 157, ChunkMap.saveChunkIfNeeded 156, ChunkMap.lambda$prepareTickingChunk$1 138, ChunkResult$Success.map 138, ChunkMap.lambda$prepareTickingChunk$2 138, DynamicGraphMinFixedPoint.checkEdge 136, LevelChunk.postProcessGeneration 127, ChunkTracker.getComputedLevel 91, ChunkHolder.updateFutures 85, Block.updateFromNeighbourShapes 76, LoadingChunkTracker.getLevel 70, Level.getBlockState 55, PalettedContainer.get 53, Long2ObjectLinkedOpenHashMap.get 52, ChunkMap.lambda$scheduleChunkLoad$3 50, CompletableFuture$AsyncSupply.run 49, SerializableChunkData.read 49, LongOpenHashSet.contains 48, LevelChunk.getBlockState 47, LevelChunkSection.getBlockState 47, ChunkMap$DistanceManager.isChunkToRemove 47, LevelChunkSection.<init> 42, LevelChunkSection.copy 41, ChunkStatusTasks.lambda$full$0 41, PalettedContainer.copy 40, PalettedContainer.<init> 39, ServerChunkCache.tickChunks 38, AbstractPipeline.evaluate 37, ChunkMap.getChunkRangeFuture 37, LevelChunk.runPostLoad 37

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 52, PalettedContainer.get 48, LongOpenHashSet.contains 48, ChunkTracker.getComputedLevel 40, PalettedContainer$Data.copy 36, DynamicGraphMinFixedPoint.checkEdge 28, GenerationChunkHolder.getChunkIfPresentUnchecked 28, Long2ByteOpenHashMap.get 14, Long2ObjectFunctions$SynchronizedFunction.get 13, ChunkMap.onLevelChange 12, Long2ObjectOpenHashMap.getOrDefault 11, Long2ObjectOpenHashMap.get 10, HashMap.getNode 9, Long2LongOpenHashMap.getOrDefault 8, LongLinkedOpenHashSet.add 8, ChunkMap.saveChunksEagerly 8, ServerChunkCache.getChunk 7, MultifaceBlock.hasAnyFace 7, Objects.equals 7, AbstractConsecutiveExecutor.schedule 7, DistanceManager.runAllUpdates 6, PriorityQueue.siftUpUsingComparator 6, HashMap.putVal 6, ConcurrentLinkedQueue.offer 6, SerializableChunkData.copyOf 6, CompletableFuture.postComplete 6, ReferenceOpenHashSet.add 6, Util.sequence 6, LocalCache.connectAccessOrder 5, LongLinkedOpenHashSet.shiftKeys 5

Threads (all samples in the window): Netty Epoll IO  50717, IO-Worker 6363, Worker-Main 2734, Server thread 1127, JFR Periodic Tasks 4

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 59845 ms, 17240 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 218 / 0 | 0 / 0 | 0.182 | 359.2 |
| entity save | 25 / 0 | 0 / 0 | 0.021 | 3.7 |
| POI save | 1 / 0 | 0 / 0 | 0.001 | 0.0 |
| chunk load | 0 / 0 | 38 / 3 | 0.034 | 58.1 |
| chunk to full (promote) | 58 / 0 | 39 / 0 | 0.081 | 41.8 |
| entity load | 6 / 0 | 1 / 0 | 0.006 | 3.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 7 / 0 | 0 / 0 | 0.006 | 15.6 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.2 |
| chunk system (tickets, holders, tasks) | 326 / 1 | 170 / 1 | 0.415 | 263.3 |
| tick, other | 182 / 0 | 0 / 0 | 0.152 | 1.2 |
| idle or other | 0 / 0 | 63 / 1 | 0.053 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 891, MinecraftServer.lambda$spin$0 890, Thread.run 889, DedicatedServer.tickServer 642, MinecraftServer.processPacketsAndTick 642, MinecraftServer.tickServer 642, MinecraftServer.tickChildren 637, ServerLevel.tick 637, ServerChunkCache.tick 592, ServerChunkCache.runDistanceManagerUpdates 304, DistanceManager.runAllUpdates 303, MinecraftServer.pollTask 253, MinecraftServer.pollTaskInternal 253, ServerChunkCache.pollTask 252, ServerChunkCache$MainThreadExecutor.pollTask 252, MinecraftServer.waitUntilNextTick 251, BlockableEventLoop.pollTask 247, ServerChunkCache$MainThreadExecutor.doRunTask 243, BlockableEventLoop.doRunTask 243, BlockableEventLoop.managedBlock 241, ChunkMap.tick 237, ChunkMap.processUnloads 225, CompletableFuture$Completion.run 215, LoadingChunkTracker.runDistanceUpdates 204, DynamicGraphMinFixedPoint.runUpdates 204, ChunkMap.saveChunksEagerly 203, CompletableFuture$UniApply.tryFire 188, ChunkMap.save 169, ChunkTracker.checkNeighborsAfterUpdate 168, ChunkMap.saveChunkIfNeeded 167, DynamicGraphMinFixedPoint.checkNeighbor 167, SerializableChunkData.copyOf 166, ChunkResult$Success.map 145, ChunkMap.lambda$prepareTickingChunk$1 144, ChunkMap.lambda$prepareTickingChunk$2 144, LevelChunk.postProcessGeneration 137, DynamicGraphMinFixedPoint.checkEdge 112, LoadingChunkTracker.getLevel 99, ChunkTracker.getComputedLevel 96, ChunkHolder.updateFutures 87, Block.updateFromNeighbourShapes 86, Long2ObjectLinkedOpenHashMap.get 75, LongOpenHashSet.contains 62, ChunkMap$DistanceManager.isChunkToRemove 61, BlockBehaviour$BlockStateBase.updateShape 46, PalettedContainer.copy 46, LevelChunkSection.copy 46, LevelChunkSection.<init> 46, PalettedContainer.get 45, ChunkMap.getChunkRangeFuture 44, Level.getBlockState 43, ServerChunkCache.tickChunks 42, PalettedContainer.<init> 41, SerializableChunkData.read 41, ChunkMap.lambda$scheduleChunkLoad$3 41, CompletableFuture$AsyncSupply.run 40, LevelChunk.getBlockState 40, LevelChunk.getBlockEntityNbtForSaving 39, BlockEntity.saveWithFullMetadata 39, LevelChunkSection.getBlockState 39

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 75, LongOpenHashSet.contains 62, PalettedContainer.get 43, PalettedContainer$Data.copy 35, GenerationChunkHolder.getChunkIfPresentUnchecked 27, ChunkTracker.getComputedLevel 23, Long2ObjectOpenHashMap.get 21, DynamicGraphMinFixedPoint.checkNeighbor 18, Long2ByteOpenHashMap.get 18, LongLinkedOpenHashSet.add 13, StateHolder.valueIndex 11, DynamicGraphMinFixedPoint.runUpdates 9, HashMap.getNode 8, LayerLightSectionStorage.getDataLayerData 8, CompletableFuture.postComplete 8, Long2ObjectOpenHashMap.getOrDefault 7, MultifaceBlock.updateShape 7, ConcurrentLinkedQueue.offer 7, ServerChunkCache.getChunk 6, ReferenceOpenHashSet.add 6, Long2LongOpenHashMap.getOrDefault 6, ImmutableCollections$SetN.probe 6, Util.sequence 6, AbstractConsecutiveExecutor.schedule 6, Inflater.inflateBytesBytes 5, ReferencePipeline$3$1.accept 5, LocalCache.connectAccessOrder 5, PalettedContainer.copy 5, Block.updateFromNeighbourShapes 5, LevelChunk.postProcessGeneration 5

Threads (all samples in the window): Netty Epoll IO  50676, IO-Worker 6145, Worker-Main 2946, Server thread 1140, JFR Periodic Tasks 14

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 2152: LoadingChunkTracker.runDistanceUpdates 1364, ChunkHolder.updateFutures 677, GenerationChunkHolder.updateHighestAllowedStatus 41, ReferenceOpenHashSet$SetIterator.next 10, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 4, DistanceManager$PlayerTicketTracker.runAllUpdates 4, ReferenceOpenHashSet.clear 3, SimulationChunkTracker.runAllUpdates 2, ReferenceOpenHashSet.iterator 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1364, ChunkHolder.updateFutures > ChunkMap.onLevelChange 183, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 157, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 105, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 103, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 85, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 27, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 13, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 10, ChunkHolder.updateFutures > CompletableFuture.complete 4, DistanceManager$PlayerTicketTracker.runAllUpdates > DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 4, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 3
- **ChunkMap.processUnloads** 1825: ChunkMap.saveChunksEagerly 1647, CompletableFuture$Completion.run 150, ChunkMap.scheduleUnload 8, Long2ObjectLinkedOpenHashMap.remove 6, ConcurrentLinkedQueue.size 3, ConcurrentLinkedQueue.poll 2, LongOpenHashSet$SetIterator.remove 2, Long2ObjectLinkedOpenHashMap.put 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1324, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 184, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 150, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 39, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 25, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 6, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 6, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 3, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 2, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 2, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 1
- **ChunkMap.saveChunksEagerly** 1647: ChunkMap.saveChunkIfNeeded 1324, GenerationChunkHolder.getLatestChunk 184, Long2ObjectLinkedOpenHashMap.get 39, LongLinkedOpenHashSet$SetIterator.nextLong 25, LongLinkedOpenHashSet$SetIterator.remove 2, LongLinkedOpenHashSet.iterator 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1138, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 170, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 142, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 23, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 2, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2
- **ChunkMap.save** 1252: SerializableChunkData.copyOf 1224, CompletableFuture.supplyAsync 8, SimpleRegionStorage.write 7, ChunkMap.markPosition 7, CompletableFuture.handle 1, ImposterProtoChunk.getPos 1, SectionStorage.flush 1, Profiler.get 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 347, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 270, SerializableChunkData.copyOf > LightEngine.getDataLayerData 227, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 146, SerializableChunkData.copyOf > ReferencePipeline.toArray 42, SerializableChunkData.copyOf > DataLayer.copy 32, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 30, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 20, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 8, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 8, SimpleRegionStorage.write > IOWorker.store 7, SerializableChunkData.copyOf > ArrayList.add 6
- **SerializableChunkData.copyOf** 1224: LevelChunkSection.copy 347, LevelChunk.getBlockEntityNbtForSaving 270, LightEngine.getDataLayerData 227, SerializableChunkData.packStructureData 146, ReferencePipeline.toArray 42, DataLayer.copy 32, LevelChunk.getTicksForSerialization 30, ChunkAccess.getBlockEntitiesPos 20, Collections$UnmodifiableCollection$1.hasNext 8, ArrayList.add 6, Heightmap.getRawData 5, ChunkAccess.getHeightmaps 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 345, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 262, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 226, SerializableChunkData.packStructureData > StructureStart.createTag 107, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 41, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 26, DataLayer.copy > DataLayer.<init> 23, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 16, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 8, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 8, ArrayList.add > ArrayList.add 6, Collections$UnmodifiableCollection$1.hasNext > EnumMap$EnumMapIterator.hasNext 5
- **LevelChunk.postProcessGeneration** 944: Block.updateFromNeighbourShapes 542, FluidState.tick 150, BlockBehaviour$BlockStateBase.tick 134, LevelChunk.getBlockState 48, FluidState.isEmpty 17, UpgradeData.upgrade 9, LevelWriter.setBlock 9, ImmutableList.copyOf 5, ShortListIterator.next 3, LevelHeightAccessor.getSectionYFromSectionIndex 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 299, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 220, FluidState.tick > FlowingFluid.tick 150, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 134, LevelChunk.getBlockState > LevelChunkSection.getBlockState 48, LevelWriter.setBlock > Level.setBlock 9, ShortListIterator.next > ShortListIterator.next 3, UpgradeData.upgrade > UpgradeData.upgradeSides 3, UpgradeData.upgrade > Iterable.forEach 3, UpgradeData.upgrade > UpgradeData.upgradeInside 2, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 1, ImmutableList.copyOf > HashMap$KeySet.toArray 1
- **SerializableChunkData.read** 313: SerializableChunkData.unpackStructureStart 170, PoiManager.checkConsistencyWithBlocks 36, LevelChunkTicks.<init> 25, SerializableChunkData.unpackStructureReferences 23, ImposterProtoChunk.<init> 19, LevelChunk.<init> 11, ChunkAccess.setAllReferences 5, ChunkAccess.addPackedPostProcess 4, ThreadedLevelLightEngine.retainData 3, ChunkAccess.setHeightmap 2, ThreadedLevelLightEngine.queueSectionData 2, Objects.equals 1<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 170, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 25, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 22, PoiManager.checkConsistencyWithBlocks > Util.ifElse 21, ImposterProtoChunk.<init> > ProtoChunk.<init> 19, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 15, LevelChunk.<init> > ChunkAccess.<init> 8, ChunkAccess.setAllReferences > HashMap.putAll 4, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 3, ChunkAccess.addPackedPostProcess > ShortList.addAll 3, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 2, Objects.equals > ChunkPos.equals 1
- **LevelChunk.runPostLoad** 226: SerializableChunkData.lambda$postLoadChunk$0 225<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 185, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 10, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 10, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 8, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 5
- **LevelChunk.<init>** 11: ChunkAccess.<init> 8, Int2ObjectOpenHashMap.<init> 1, EnumMap.put 1, RegularEnumSet.contains 1<br>two down: ChunkAccess.<init> > LevelHeightAccessor.getSectionsCount 2, ChunkAccess.<init> > Maps.newEnumMap 2, ChunkAccess.<init> > ChunkAccess.replaceMissingSections 2, ChunkAccess.<init> > Maps.newHashMap 1, EnumMap.put > EnumMap.put 1
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 2222: LoadingChunkTracker.runDistanceUpdates 1420, ChunkHolder.updateFutures 690, GenerationChunkHolder.updateHighestAllowedStatus 52, ReferenceOpenHashSet$SetIterator.next 11, ReferenceOpenHashSet.clear 4, SimulationChunkTracker.runAllUpdates 3, ReferenceOpenHashSet.iterator 2, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1418, ChunkHolder.updateFutures > ChunkMap.onLevelChange 178, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 164, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 117, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 113, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 74, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 34, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 12, ChunkHolder.updateFutures > CompletableFuture.complete 9, ReferenceOpenHashSet.clear > Arrays.fill 4, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 3, GenerationChunkHolder.updateHighestAllowedStatus > ChunkLevel.generationStatus 3
- **ChunkMap.processUnloads** 1928: ChunkMap.saveChunksEagerly 1760, CompletableFuture$Completion.run 141, ChunkMap.scheduleUnload 7, LongOpenHashSet$SetIterator.remove 4, ConcurrentLinkedQueue.poll 4, ConcurrentLinkedQueue.size 2, Long2ObjectLinkedOpenHashMap.remove 1, Long2ObjectLinkedOpenHashMap.put 1, LongOpenHashSet.iterator 1, LongOpenHashSet$SetIterator.nextLong 1, Long2ObjectLinkedOpenHashMap.get 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1366, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 251, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 141, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 47, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 17, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 3, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 2, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 1, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 1
- **ChunkMap.saveChunksEagerly** 1760: ChunkMap.saveChunkIfNeeded 1366, GenerationChunkHolder.getLatestChunk 251, Long2ObjectLinkedOpenHashMap.get 47, LongLinkedOpenHashSet$SetIterator.nextLong 17, LongLinkedOpenHashSet$SetIterator.remove 3, LongLinkedOpenHashSet.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1155, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 250, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 159, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 28, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 2, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 2, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1
- **ChunkMap.save** 1265: SerializableChunkData.copyOf 1245, SimpleRegionStorage.write 5, ChunkMap.markPosition 4, SectionStorage.flush 3, CompletableFuture.handle 2, CompletableFuture.supplyAsync 2, ChunkAccess.tryMarkSaved 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 377, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 263, SerializableChunkData.copyOf > LightEngine.getDataLayerData 234, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 136, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 66, SerializableChunkData.copyOf > DataLayer.copy 33, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 21, SerializableChunkData.copyOf > ReferencePipeline.toArray 18, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 14, SimpleRegionStorage.write > IOWorker.store 5, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 5, ChunkMap.markPosition > Long2ByteOpenHashMap.put 4
- **SerializableChunkData.copyOf** 1245: LevelChunkSection.copy 377, LevelChunk.getBlockEntityNbtForSaving 263, LightEngine.getDataLayerData 234, SerializableChunkData.packStructureData 136, LevelChunk.getTicksForSerialization 66, DataLayer.copy 33, ChunkAccess.getBlockEntitiesPos 21, ReferencePipeline.toArray 18, Collections$UnmodifiableCollection$1.hasNext 13, LevelLightEngine.getMaxLightSection 5, ProblemReporter$ScopedCollector.<init> 4, ChunkAccess.getHeightmaps 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 370, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 255, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 233, SerializableChunkData.packStructureData > StructureStart.createTag 97, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 65, DataLayer.copy > DataLayer.<init> 27, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 18, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 12, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, SerializableChunkData.packStructureData > CompoundTag.put 6, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 4, ProblemReporter$ScopedCollector.<init> > ProblemReporter$Collector.<init> 4
- **LevelChunk.postProcessGeneration** 977: Block.updateFromNeighbourShapes 577, FluidState.tick 165, BlockBehaviour$BlockStateBase.tick 121, LevelChunk.getBlockState 39, FluidState.isEmpty 11, UpgradeData.upgrade 10, LevelWriter.setBlock 9, ImmutableList.copyOf 6, LevelHeightAccessor.getSectionYFromSectionIndex 6, ShortListIterator.next 5, ProtoChunk.unpackOffsetCoordinates 1, ShortArrayList.clear 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 312, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 244, FluidState.tick > FlowingFluid.tick 163, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 121, LevelChunk.getBlockState > LevelChunkSection.getBlockState 38, LevelWriter.setBlock > Level.setBlock 9, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 6, UpgradeData.upgrade > Iterable.forEach 5, ShortListIterator.next > ShortListIterator.next 5, ImmutableList.copyOf > HashMap$KeySet.toArray 4, UpgradeData.upgrade > UpgradeData.upgradeInside 2, UpgradeData.upgrade > ArrayList.forEach 1
- **SerializableChunkData.read** 312: SerializableChunkData.unpackStructureStart 167, LevelChunkTicks.<init> 37, PoiManager.checkConsistencyWithBlocks 36, SerializableChunkData.unpackStructureReferences 24, ImposterProtoChunk.<init> 22, LevelChunk.<init> 6, ChunkAccess.addPackedPostProcess 5, ChunkAccess.setAllStarts 2, ChunkAccess.setHeightmap 2, ThreadedLevelLightEngine.queueSectionData 1, Objects.equals 1, ThreadedLevelLightEngine.retainData 1<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 162, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 37, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 24, PoiManager.checkConsistencyWithBlocks > Util.ifElse 23, ImposterProtoChunk.<init> > ProtoChunk.<init> 21, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 13, ChunkAccess.addPackedPostProcess > ShortList.addAll 4, LevelChunk.<init> > ChunkAccess.<init> 4, SerializableChunkData.unpackStructureStart > CompoundTag.getCompoundOrEmpty 3, ChunkAccess.setAllStarts > HashMap.putAll 2, ChunkAccess.addPackedPostProcess > ChunkAccess.getOrCreateOffsetList 1, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 1
- **LevelChunk.runPostLoad** 212: SerializableChunkData.lambda$postLoadChunk$0 211<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 174, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 12, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 9, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 8, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 5
- **LevelChunk.<init>** 6: ChunkAccess.<init> 4, Heightmap.<init> 1, Int2ObjectOpenHashMap.<init> 1<br>two down: ChunkAccess.<init> > Maps.newEnumMap 1, ChunkAccess.<init> > ChunkSkyLightSources.<init> 1, Heightmap.<init> > Mth.ceillog2 1, ChunkAccess.<init> > Object2ObjectOpenHashMap.<init> 1
- **SectionStorage.flush** 3: LongLinkedOpenHashSet.remove 3<br>two down: 

</details>

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (5) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 830 (8) | 0 (0) | LastUpdate 189, block_ticks 539, fluid_ticks 501, sections 1 | 1534 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 779 (0) | 0 (0) | LastUpdate 195, block_ticks 509, fluid_ticks 440 | 1541 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (5) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 761 (5) | 0 (0) | LastUpdate 198, block_ticks 479, fluid_ticks 431, sections 4 | 1517 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 790 (0) | 0 (0) | LastUpdate 197, block_ticks 498, fluid_ticks 456, sections 1 | 1524 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 793 (8) | 0 (0) | LastUpdate 252, block_ticks 463, fluid_ticks 472, sections 1 | 1530 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 784 (0) | 0 (0) | LastUpdate 211, block_ticks 488, fluid_ticks 451 | 1517 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (6) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 792 (13) | 0 (0) | LastUpdate 203, block_ticks 496, fluid_ticks 460, sections 2 | 1517 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 881 (0) | 0 (0) | LastUpdate 233, block_ticks 553, fluid_ticks 496, sections 4 | 1512 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 17 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 844 (27) | 0 (0) | LastUpdate 229, block_ticks 523, fluid_ticks 502, sections 1 | 1524 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 18 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 715 (0) | 0 (0) | LastUpdate 176, block_ticks 459, fluid_ticks 420, sections 3 | 1502 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 786 (9) | 0 (0) | LastUpdate 179, block_ticks 494, fluid_ticks 492 | 1548 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 798 (0) | 0 (0) | LastUpdate 218, block_ticks 520, fluid_ticks 441, sections 1 | 1514 / 1681 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (1) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 24 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 807 (12) | 0 (0) | LastUpdate 200, block_ticks 511, fluid_ticks 496 | 1519 / 1681 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 1 data, 0 bytes only, 0 one side, keys Entities 1; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1087 data, 0 bytes only, 0 one side, keys LastUpdate 1230, block_ticks 3027, fluid_ticks 2704, sections 9

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.328 | 0.281 | 1837.089 | 1 | 0.001 (0.001) | 0.009 (0.009) | 0.009 | 5755 (35.4) | 700: 1837.1, 100: 45.3, 5755: 35.4, 400: 32.8, 0: 18.3 |
| 1 | quicksilver | yes | 0.320 | 0.439 | 1640.047 | 3 | 0.000 (0.000) | 0.014 (0.014) | 0.014 | 5754 (33.1) | 700: 1640.0, 100: 104.4, 400: 51.6, 5754: 33.1, 2134: 28.6 |
| 2 | vanilla | yes | 0.342 | 0.361 | 1778.877 | 4 | 0.001 (0.001) | 0.014 (0.014) | 0.014 | 5755 (144.2) | 700: 1778.9, 5755: 144.2, 400: 78.8, 100: 57.8, 0: 14.4 |
| 2 | quicksilver | yes | 0.337 | 0.352 | 1743.595 | 2 | 0.000 (0.000) | 0.008 (0.008) | 0.008 | 5758 (36.9) | 700: 1743.6, 400: 56.7, 100: 46.7, 4414: 45.8, 5758: 36.9 |
| 3 | vanilla | yes | 0.326 | 0.428 | 1735.221 | 2 | 0.000 (0.000) | 0.009 (0.009) | 0.009 | 5754 (27.2) | 700: 1735.2, 400: 71.3, 100: 45.6, 5754: 27.2, 0: 16.3 |
| 3 | quicksilver | yes | 0.331 | 0.430 | 1715.104 | 4 | 0.000 (0.000) | 0.010 (0.010) | 0.010 | 5758 (79.1) | 700: 1715.1, 5758: 79.1, 400: 69.5, 100: 56.7, 0: 17.1 |
| 4 | vanilla | yes | 0.331 | 0.313 | 1756.578 | 3 | 0.000 (0.000) | 0.013 (0.013) | 0.012 | 5757 (50.9) | 700: 1756.6, 100: 65.6, 5757: 50.9, 400: 46.2, 0: 14.9 |
| 4 | quicksilver | yes | 0.340 | 0.342 | 1762.823 | 2 | 0.000 (0.000) | 0.014 (0.014) | 0.014 | 5759 (31.0) | 700: 1762.8, 100: 89.4, 2500: 47.8, 400: 44.2, 5759: 31.0 |
| 5 | vanilla | yes | 0.327 | 0.289 | 1843.874 | 2 | 0.000 (0.000) | 0.006 (0.006) | 0.006 | 5759 (29.2) | 700: 1843.9, 100: 59.7, 5251: 47.2, 400: 34.0, 5759: 29.2 |
| 5 | quicksilver | yes | 0.345 | 0.473 | 1791.283 | 3 | 0.000 (0.000) | 0.011 (0.011) | 0.011 | 5757 (79.9) | 700: 1791.3, 5757: 79.9, 100: 62.0, 400: 48.1, 491: 25.8 |
| 6 | vanilla | yes | 0.345 | 0.409 | 1813.573 | 4 | 0.001 (0.001) | 0.009 (0.008) | 0.008 | 5754 (83.9) | 700: 1813.6, 5754: 83.9, 400: 82.0, 100: 52.5, 0: 16.9 |
| 6 | quicksilver | yes | 0.354 | 0.277 | 2013.766 | 2 | 0.000 (0.000) | 0.007 (0.007) | 0.007 | 5759 (25.5) | 700: 2013.8, 100: 53.2, 4233: 43.6, 400: 33.8, 645: 27.4 |
| 7 | vanilla | yes | 0.348 | 0.318 | 1969.394 | 2 | 0.000 (0.000) | 0.008 (0.008) | 0.008 | 5755 (33.3) | 700: 1969.4, 100: 52.5, 400: 39.5, 5755: 33.3, 682: 24.3 |
| 7 | quicksilver | yes | 0.334 | 0.549 | 1774.013 | 3 | 0.000 (0.000) | 0.008 (0.008) | 0.008 | 5757 (90.0) | 700: 1774.0, 5757: 90.0, 400: 62.5, 100: 43.7, 0: 15.2 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 0.331 | 0.337 | 1.015 (0.96 to 1.06) |
| MSPT p99 | 0.318 | 0.430 | 1.093 (0.68 to 1.73) |
| slowest tick (ms) | 1813.573 | 1762.823 | 0.980 (0.89 to 1.11) |
| ticks over 50 ms | 2 | 3 | 1.500 (0.50 to 3.00) |
| chunk load, ms per tick (server thread) | 0.000 | 0.000 | 0.167 (0.00 to 4.00) |
|   of it in the tick | 0.000 | 0.000 | 0.167 (0.00 to 4.00) |
| chunk save, ms per tick (server thread) | 0.009 | 0.010 | 1.061 (0.58 to 1.73) |
|   of it in the tick | 0.009 | 0.010 | 1.078 (0.56 to 1.82) |
| autosave, ms per tick | 0.009 | 0.010 | 1.111 (0.60 to 1.79) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 2309 ms, 18541 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 60 / 2 | 0 / 0 | 0.009 | 163.0 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 1.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 3 / 0 | 0 / 0 | 0.000 | 2.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 5 / 0 | 0 / 0 | 0.001 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 83 / 1 | 0 / 0 | 0.012 | 39.6 |
| tick, other | 143 / 2 | 0 / 0 | 0.021 | 5.8 |
| idle or other | 0 / 0 | 9 / 0 | 0.001 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 155, MinecraftServer.lambda$spin$0 155, Thread.run 155, MinecraftServer.tickServer 155, MinecraftServer.processPacketsAndTick 155, DedicatedServer.tickServer 155, MinecraftServer.tickChildren 86, ServerLevel.tick 86, ServerChunkCache.tick 71, MinecraftServer.saveEverything 62, DedicatedServer.saveAllChunks 61, MinecraftServer.saveAllChunks 61, ServerLevel.save 57, Harness.startTick 56, ServerTickEvents.lambda$static$1 56, ServerChunkCache.tickChunks 52, ServerChunkCache.save 52, ChunkMap.saveAllChunks 52, ContextChain.executeAll 49, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 49, ContextChain.runExecutable$mixinextras$wrapped$10 49, ContextChain.runExecutable 49, SaveAllCommand.saveAll 49, Harness.command 49, CommandDispatcher.execute 49, SerializableChunkData.copyOf 46, ChunkMap.save 46, NaturalSpawner.createState 42, ServerChunkCache.getFullChunk 37, ChunkResult$Success.ifSuccess 37, NaturalSpawner.lambda$createState$0 37, ChunkMap.saveChunkIfNeeded 35, EnvironmentAttributeReader.getValue 32, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 31, EnvironmentAttributeSystem$ValueSampler.getValue 31, EnvironmentAttributeSystem.getValue 31, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 28, SaveAllCommand.lambda$register$0 28, BiomeManager.getBiome 25, LevelReader.getNoiseBiome 23, Level.getChunk 22, ServerChunkCache.getChunk 22, SaveAllCommand.lambda$register$1 21, AbstractPipeline.evaluate 19, AbstractPipeline.wrapAndCopyInto 19, AbstractPipeline.copyInto 19, SimulationChunkTracker.getLevel 18, Long2ByteOpenHashMap.get 18, ReferencePipeline$3$1.accept 17, ForEachOps$ForEachOp$OfRef.evaluateSequential 16, AbstractList$RandomAccessSpliterator.forEachRemaining 16, ForEachOps$ForEachOp.evaluateSequential 16, ReferencePipeline.forEach 16, LevelChunkSection.copy 15, LevelTicks.collectTicks 15, LevelTicks.tick 15, LevelTicks.sortContainersToTick 15, ServerChunkCache.isPositionTicking 15, ServerLevel.isPositionTickingWithEntitiesLoaded 15, DistanceManager.inBlockTickingRange 15

Top chunk methods (self): ServerChunkCache.getChunk 22, Long2ByteOpenHashMap.get 18, PalettedContainer$Data.copy 9, Long2ObjectFunctions$SynchronizedFunction.get 7, Long2ObjectOpenHashMap.get 5, GenerationChunkHolder.getChunkIfPresentUnchecked 5, RegularImmutableMap.get 3, NaturalSpawner.createState 3, SerializableChunkData.copyOf 3, Object.clone 3, ServerChunkCache.tickChunks 3, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 2, HashMap.putVal 2, HashMap.resize 2, UnixFileDispatcherImpl.write0 2, ChunkMap.tick 2, NaturalSpawner.lambda$createState$0 2, ArrayList.forEach 2, VarHandleReferences$Array.getVolatile 2, LambdaForm.useCount 1, Inflater.inflateBytesBytes 1, SwitchBootstraps.lambda$generateTypeSwitchSkeleton$0 1, TicketStorage.removeTicketIf 1, ChunkMap.getPlayersCloseForSpawning 1, Vec3.atCenterOf 1, MobSpawnSettings.definedCategories 1, BiomeManager.getFiddledDistance 1, Math.floorMod 1, ChunkPos.pack 1, Long2ObjectOpenHashMap$MapIterator.<init> 1

Threads (all samples in the window): Netty Epoll IO  1366, Worker-Main 648, IO-Worker 623, Server thread 309

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 2265 ms, 18420 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 93 / 4 | 0 / 0 | 0.014 | 149.1 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 1.2 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 0 / 0 | 0 / 0 | 0.000 | 0.8 |
| light | 0 / 0 | 1 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 52 / 0 | 0 / 0 | 0.007 | 53.8 |
| tick, other | 137 / 3 | 0 / 0 | 0.020 | 9.3 |
| idle or other | 0 / 0 | 9 / 0 | 0.001 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.tickServer 150, DedicatedServer.tickServer 150, Thread.run 149, MinecraftServer.processPacketsAndTick 149, MinecraftServer.lambda$spin$0 149, MinecraftServer.runServer 149, MinecraftServer.saveEverything 95, DedicatedServer.saveAllChunks 94, MinecraftServer.saveAllChunks 94, ServerTickEvents.lambda$static$1 91, Harness.startTick 91, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 90, ContextChain.executeAll 90, SaveAllCommand.saveAll 90, Harness.command 90, CommandDispatcher.execute 90, ContextChain.runExecutable 90, ContextChain.runExecutable$mixinextras$wrapped$10 90, ServerLevel.save 89, ChunkMap.saveAllChunks 75, ServerChunkCache.save 75, ChunkMap.save 72, SerializableChunkData.copyOf 70, SaveAllCommand.lambda$register$0 59, MinecraftServer.tickChildren 52, ServerLevel.tick 52, ChunkMap.saveChunkIfNeeded 48, ServerChunkCache.tick 44, ServerChunkCache.tickChunks 39, NaturalSpawner.createState 31, AbstractPipeline.evaluate 31, SaveAllCommand.lambda$register$1 31, AbstractPipeline.wrapAndCopyInto 29, AbstractPipeline.copyInto 28, ReferencePipeline$3$1.accept 26, LevelChunkSection.copy 25, ReferencePipeline.forEach 25, AbstractList$RandomAccessSpliterator.forEachRemaining 25, ForEachOps$ForEachOp$OfRef.evaluateSequential 25, ForEachOps$ForEachOp.evaluateSequential 25, ReferencePipeline$2$1.accept 24, ServerChunkCache.getFullChunk 22, PalettedContainer.<init> 22, LevelChunkSection.<init> 22, PalettedContainer.copy 22, PalettedContainer$Data.copy 21, ChunkResult$Success.ifSuccess 19, NaturalSpawner.lambda$createState$0 19, EnvironmentAttributeReader.getValue 16, EnvironmentAttributeSystem.getValue 15, EnvironmentAttributeSystem$ValueSampler.getValue 15, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 15, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 14, BiomeManager.getBiome 13, Encoder.encodeStart 13, Codec$2.encode 10, PersistentEntitySectionManager.autoSave 9, ServerChunkCache.getChunk 9, LevelReader.getNoiseBiome 9, Level.getChunk 9

Top chunk methods (self): PalettedContainer$Data.copy 17, ServerChunkCache.getChunk 8, Long2ByteOpenHashMap.get 8, SerializableChunkData.copyOf 7, Long2ObjectFunctions$SynchronizedFunction.get 4, HashMap.putVal 4, NaturalSpawner.createState 4, BiomeManager.getBiome 3, DataLayer.copy 3, Long2ObjectOpenHashMap.get 3, LevelChunkSection.copy 3, LevelChunkTicks.pack 3, Object.clone 3, Long2ObjectLinkedOpenHashMap.get 3, Codec.lambda$stringResolver$8 2, Encoder$1.encode 2, ServerChunkCache.tickChunks 2, LevelChunk.getBlockEntity 2, ChunkPos.pack 2, StackMapGenerator.processLdc 1, BiomeManager.getFiddledDistance 1, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 1, Long2ObjectOpenHashMap$MapIterator.<init> 1, Long2ByteMaps$1.iterator 1, Nodes$IntFixedNodeBuilder.build 1, Comparator.lambda$comparingLong$6043328a$1 1, LinkedHashSet.<init> 1, PalettedContainer.<init> 1, LinearPalette.copy 1, TagValueOutput.store 1

Threads (all samples in the window): Netty Epoll IO  1260, Worker-Main 635, IO-Worker 633, Server thread 300

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 451: DedicatedServer.saveAllChunks 447, MinecraftServer.warnOnLowDiskSpace 4<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 447, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 4
- **ServerLevel.save** 410: ServerChunkCache.save 352, PersistentEntitySectionManager.autoSave 31, PersistentEntitySectionManager.saveAll 20, ServerLevel.saveLevelData 7<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 352, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 30, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 15, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 4, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 3, PersistentEntitySectionManager.saveAll > MethodHandleNatives.linkCallSite 2, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 2, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 1, PersistentEntitySectionManager.saveAll > EntityStorage.flush 1
- **ChunkMap.saveAllChunks** 352: ChunkMap.saveChunkIfNeeded 272, ReferencePipeline.forEach 72, Long2ObjectLinkedOpenHashMap$ValueIterator.next 2, ReferencePipeline.toList 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 268, ReferencePipeline.forEach > AbstractPipeline.evaluate 72, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 3, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 2, ReferencePipeline.toList > ReferencePipeline.toArray 2
- **ChunkMap.save** 336: SerializableChunkData.copyOf 328, CompletableFuture.supplyAsync 3, ChunkMap.markPosition 2, CompletableFuture.handle 1, SimpleRegionStorage.write 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 135, SerializableChunkData.copyOf > LightEngine.getDataLayerData 51, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 35, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 25, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 21, SerializableChunkData.copyOf > ReferencePipeline.toArray 7, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 4, SerializableChunkData.copyOf > ArrayList.add 3, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 3, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 3, SerializableChunkData.copyOf > DataLayer.copy 3, ChunkMap.markPosition > Long2ByteOpenHashMap.put 2
- **SerializableChunkData.copyOf** 328: LevelChunkSection.copy 135, LightEngine.getDataLayerData 51, LevelChunk.getBlockEntityNbtForSaving 35, SerializableChunkData.packStructureData 25, LevelChunk.getTicksForSerialization 21, ReferencePipeline.toArray 7, ChunkAccess.getBlockEntitiesPos 4, ArrayList.add 3, Collections$UnmodifiableCollection$1.hasNext 3, DataLayer.copy 3, LevelLightEngine.getMaxLightSection 2, Heightmap.getRawData 1<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 129, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 49, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 33, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 19, SerializableChunkData.packStructureData > StructureStart.createTag 16, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 7, ArrayList.add > ArrayList.add 3, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 2, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 2, LightEngine.getDataLayerData > SectionPos.asLong 2, SerializableChunkData.packStructureData > Collections$UnmodifiableMap$UnmodifiableEntrySet.iterator 2, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 2
- **PersistentEntitySectionManager.autoSave** 31: AbstractLongCollection.forEach 30, PersistentEntitySectionManager.getAllChunksToSave 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 30, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 1
- **ChunkMap.processUnloads** 14: ChunkMap.saveChunksEagerly 8, LongOpenHashSet.iterator 3<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 4, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2
- **ChunkMap.saveChunksEagerly** 8: Util.getMillis 4<br>two down: Util.getMillis > Util.getNanos 4

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 496: DedicatedServer.saveAllChunks 492, MinecraftServer.warnOnLowDiskSpace 4<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 492, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 4
- **ServerLevel.save** 465: ServerChunkCache.save 403, PersistentEntitySectionManager.autoSave 32, PersistentEntitySectionManager.saveAll 17, ServerLevel.saveLevelData 13<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 403, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 29, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 12, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 9, PersistentEntitySectionManager.saveAll > EntityStorage.flush 4, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 4, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 2, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkCallSite 1
- **ChunkMap.saveAllChunks** 403: ChunkMap.saveChunkIfNeeded 279, ReferencePipeline.forEach 115, ReferencePipeline.toList 4, Long2ObjectLinkedOpenHashMap$ValueIterator.next 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 275, ReferencePipeline.forEach > AbstractPipeline.evaluate 115, ReferencePipeline.toList > ReferencePipeline.toArray 4, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 2, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 2, ChunkMap.saveChunkIfNeeded > ChunkHolder.isReadyForSaving 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1
- **ChunkMap.save** 386: SerializableChunkData.copyOf 371, CompletableFuture.supplyAsync 7, SimpleRegionStorage.write 5, SectionStorage.flush 2<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 122, SerializableChunkData.copyOf > LightEngine.getDataLayerData 56, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 45, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 38, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 27, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 10, SerializableChunkData.copyOf > DataLayer.copy 8, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 7, SerializableChunkData.copyOf > ReferencePipeline.toArray 6, SimpleRegionStorage.write > IOWorker.store 5, SerializableChunkData.copyOf > Heightmap.getRawData 5, SerializableChunkData.copyOf > ArrayList.add 4
- **SerializableChunkData.copyOf** 371: LevelChunkSection.copy 122, LightEngine.getDataLayerData 56, LevelChunk.getBlockEntityNbtForSaving 45, SerializableChunkData.packStructureData 38, LevelChunk.getTicksForSerialization 27, ChunkAccess.getBlockEntitiesPos 10, DataLayer.copy 8, ReferencePipeline.toArray 6, Heightmap.getRawData 5, ArrayList.add 4, LevelLightEngine.getMaxLightSection 3, ProblemReporter$ScopedCollector.<init> 2<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 112, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 54, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 42, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 27, SerializableChunkData.packStructureData > StructureStart.createTag 26, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 6, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 5, ArrayList.add > ArrayList.add 3, SerializableChunkData.packStructureData > Identifier.toString 3, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 2, ProblemReporter$ScopedCollector.<init> > ProblemReporter$Collector.<init> 2, LevelLightEngine.getMaxLightSection > LevelLightEngine.getMinLightSection 2
- **PersistentEntitySectionManager.autoSave** 32: AbstractLongCollection.forEach 29, PersistentEntitySectionManager.getAllChunksToSave 2, MethodHandleNatives.linkCallSite 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 29, MethodHandleNatives.linkCallSite > MethodHandleNatives.linkCallSiteImpl 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 1
- **ChunkMap.processUnloads** 5: ChunkMap.saveChunksEagerly 3<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 2
- **ChunkMap.saveChunksEagerly** 3: Util.getMillis 2<br>two down: Util.getMillis > Util.getNanos 2
- **SectionStorage.flush** 2: ChunkPos.pack 1, LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 477 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 461 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 439 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 464 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 468 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 457 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 452 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 478 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 478 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 455 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 462 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 456 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 467 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 3 data, 0 bytes only, 0 one side, keys DataVersion 8, Entities 10, Position 8; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

