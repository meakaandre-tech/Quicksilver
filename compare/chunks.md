# Chunk scenes (P2-4)

## core / churn

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 18.234 | 302.695 | 2536.686 | 36 | 0.042 (0.038) | 1.382 (1.370) | 1.382 | - | 220: 2536.7, 128: 568.8, 87: 517.0, 103: 398.1, 31: 327.9 |
| 1 | quicksilver | yes | 18.433 | 262.746 | 2771.226 | 31 | 0.038 (0.032) | 1.147 (1.140) | 1.138 | - | 220: 2771.2, 128: 612.3, 87: 553.5, 103: 457.6, 16: 324.7 |
| 2 | vanilla | yes | 18.144 | 258.946 | 2503.937 | 28 | 0.045 (0.045) | 1.538 (1.528) | 1.525 | - | 220: 2503.9, 87: 550.6, 128: 547.2, 103: 391.8, 139: 284.6 |
| 2 | quicksilver | yes | 17.535 | 264.716 | 2525.403 | 26 | 0.050 (0.045) | 1.255 (1.243) | 1.245 | - | 220: 2525.4, 87: 605.0, 128: 558.5, 103: 412.1, 26: 329.1 |
| 3 | vanilla | yes | 19.184 | 267.410 | 2671.668 | 34 | 0.055 (0.052) | 1.598 (1.592) | 1.590 | - | 220: 2671.7, 128: 562.3, 87: 518.5, 103: 458.0, 7: 336.9 |
| 3 | quicksilver | yes | 18.351 | 307.614 | 2671.396 | 27 | 0.063 (0.058) | 1.178 (1.170) | 1.167 | - | 220: 2671.4, 128: 592.0, 87: 581.1, 103: 449.0, 16: 370.7 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 18.234 | 18.351 | 0.966 (0.96 to 1.01) |
| MSPT p99 | 267.410 | 264.716 | 1.022 (0.87 to 1.15) |
| slowest tick (ms) | 2536.686 | 2671.396 | 1.009 (1.00 to 1.09) |
| ticks over 50 ms | 34 | 27 | 0.861 (0.79 to 0.93) |
| chunk load, ms per tick (server thread) | 0.045 | 0.050 | 1.111 (0.92 to 1.15) |
|   of it in the tick | 0.045 | 0.045 | 1.000 (0.83 to 1.13) |
| chunk save, ms per tick (server thread) | 1.538 | 1.178 | 0.816 (0.74 to 0.83) |
|   of it in the tick | 1.528 | 1.170 | 0.814 (0.74 to 0.83) |
| autosave, ms per tick | 1.525 | 1.167 | 0.816 (0.73 to 0.82) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 10991 ms, 36709 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 773 / 49 | 7 / 0 | 1.382 | 1483.5 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 5 / 0 | 0 / 0 | 0.008 | 16.4 |
| chunk to full (promote) | 18 / 0 | 0 / 0 | 0.030 | 7.7 |
| entity load | 0 / 0 | 2 / 0 | 0.003 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 21 / 0 | 0 / 0 | 0.035 | 167.0 |
| light | 1 / 0 | 0 / 0 | 0.002 | 0.7 |
| chunk system (tickets, holders, tasks) | 346 / 292 | 4 / 0 | 1.070 | 236.9 |
| tick, other | 179 / 3 | 0 / 0 | 0.303 | 28.5 |
| idle or other | 0 / 0 | 11 / 0 | 0.018 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1510, MinecraftServer.lambda$spin$0 1510, Thread.run 1506, MinecraftServer.processPacketsAndTick 1505, MinecraftServer.tickServer 1505, DedicatedServer.tickServer 1505, CiChunks.startTick 1266, Harness.startTick 1266, ServerTickEvents.lambda$static$1 1265, SaveAllCommand.saveAll 829, ContextChain.runExecutable$mixinextras$wrapped$10 829, MinecraftServer.saveEverything 829, CommandDispatcher.execute 829, SaveAllCommand.lambda$register$0 829, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 829, ContextChain.runExecutable 829, ContextChain.executeAll 829, Harness.command 828, DedicatedServer.saveAllChunks 820, MinecraftServer.saveAllChunks 820, ServerLevel.save 759, ChunkMap.saveAllChunks 690, ServerChunkCache.save 690, ChunkMap.saveChunkIfNeeded 676, ChunkMap.save 659, SerializableChunkData.copyOf 643, Level.getChunk 426, Level.getBlockState 426, LevelReader.getChunk 426, ServerChunkCache.getChunk 426, LevelWriter.setBlock 393, Level.setBlock 393, Level.neighborShapeChanged 381, CollectingNeighborUpdater.addAndRun 381, CollectingNeighborUpdater.runUpdates 381, NeighborUpdater.executeShapeUpdate 381, CollectingNeighborUpdater.shapeUpdate 381, BlockBehaviour$BlockStateBase.updateNeighbourShapes 381, CollectingNeighborUpdater$ShapeUpdate.runNext 381, BlockableEventLoop.managedBlock 309, Thread.yield 290, BlockableEventLoop.waitForTasks 290, Thread.yield0 290, LevelChunkSection.<init> 286, LevelChunkSection.copy 286, PalettedContainer.copy 286, PalettedContainer.<init> 257, PalettedContainer$Data.copy 250, MinecraftServer.tickChildren 245, ServerLevel.tick 245, ServerChunkCache.tick 243, ServerChunkCache.runDistanceManagerUpdates 200, DistanceManager.runAllUpdates 191, DynamicGraphMinFixedPoint.runUpdates 146, LoadingChunkTracker.runDistanceUpdates 146, ChunkTracker.checkNeighborsAfterUpdate 115, DynamicGraphMinFixedPoint.checkNeighbor 113, DynamicGraphMinFixedPoint.checkEdge 99, LoadingChunkTracker.getLevel 87, Long2ObjectLinkedOpenHashMap.get 86

Top chunk methods (self): Thread.yield0 290, PalettedContainer$Data.copy 233, Long2ObjectLinkedOpenHashMap.get 86, Long2ObjectOpenHashMap.get 49, ServerChunkCache.getChunk 35, Long2ObjectFunctions$SynchronizedFunction.get 33, PalettedContainer.copy 29, Comparator.lambda$comparingLong$6043328a$1 24, UnixFileDispatcherImpl.write0 23, LongLinkedOpenHashSet.add 18, Collections$UnmodifiableCollection$1.hasNext 17, DataLayer.<init> 16, Object.clone 12, HashMap.putVal 12, ArrayList.grow 12, LevelHeightAccessor.getSectionsCount 12, ConcurrentLinkedQueue.offer 11, ReferencePipeline$3$1.accept 10, ChunkMap.saveAllChunks 10, LongLinkedOpenHashSet.rehash 9, ConcurrentLinkedQueue.size 9, ChunkMap.saveChunkIfNeeded 9, Long2ByteOpenHashMap.get 8, DistanceManager.runAllUpdates 7, LongOpenHashSet.contains 7, Entity.saveWithoutId 7, LevelChunkTicks.pack 7, Long2ObjectOpenHashMap.getOrDefault 7, TicketStorage.addTicket 7, RecordCodecBuilder$Instance.lambda$ap3$6 7

Threads (all samples in the window): Worker-Main 6769, Netty Epoll IO  6550, Server thread 1711, IO-Worker 641, JFR Periodic Tasks 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 11117 ms, 38492 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 637 / 42 | 4 / 0 | 1.138 | 851.2 |
| chunk save | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| entity save | 4 / 0 | 0 / 0 | 0.007 | 0.6 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 2 / 0 | 0 / 0 | 0.003 | 7.9 |
| chunk to full (promote) | 17 / 0 | 0 / 0 | 0.028 | 15.3 |
| entity load | 0 / 0 | 4 / 0 | 0.007 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 21 / 1 | 0 / 0 | 0.037 | 1.8 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 382 / 175 | 3 / 0 | 0.933 | 466.9 |
| tick, other | 188 / 5 | 0 / 0 | 0.322 | 56.0 |
| idle or other | 0 / 0 | 12 / 0 | 0.020 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1287, MinecraftServer.lambda$spin$0 1286, Thread.run 1285, DedicatedServer.tickServer 1282, MinecraftServer.tickServer 1282, MinecraftServer.processPacketsAndTick 1281, ServerTickEvents.lambda$static$1 1011, Harness.startTick 1011, CiChunks.startTick 1011, SaveAllCommand.saveAll 683, ContextChain.runExecutable$mixinextras$wrapped$10 683, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 683, ContextChain.executeAll 683, SaveAllCommand.lambda$register$0 683, CommandDispatcher.execute 683, ContextChain.runExecutable 683, MinecraftServer.saveEverything 683, Harness.command 682, DedicatedServer.saveAllChunks 676, MinecraftServer.saveAllChunks 676, ServerLevel.save 625, ServerChunkCache.save 560, ChunkMap.saveAllChunks 557, ChunkMap.saveChunkIfNeeded 544, ChunkMap.save 533, SerializableChunkData.copyOf 521, ServerChunkCache.getChunk 323, Level.getChunk 323, LevelReader.getChunk 319, Level.getBlockState 318, Level.setBlock 279, LevelWriter.setBlock 279, MinecraftServer.tickChildren 274, ServerLevel.tick 274, Level.neighborShapeChanged 268, CollectingNeighborUpdater.addAndRun 268, CollectingNeighborUpdater.runUpdates 268, CollectingNeighborUpdater.shapeUpdate 268, CollectingNeighborUpdater$ShapeUpdate.runNext 268, BlockBehaviour$BlockStateBase.updateNeighbourShapes 268, NeighborUpdater.executeShapeUpdate 268, ServerChunkCache.tick 256, ServerChunkCache.runDistanceManagerUpdates 224, DistanceManager.runAllUpdates 219, LevelChunkSection.copy 206, LevelChunkSection.<init> 203, BlockableEventLoop.managedBlock 185, DynamicGraphMinFixedPoint.runUpdates 176, LoadingChunkTracker.runDistanceUpdates 174, BlockableEventLoop.waitForTasks 174, Thread.yield 173, Thread.yield0 173, ChunkTracker.checkNeighborsAfterUpdate 141, DynamicGraphMinFixedPoint.checkNeighbor 137, LoadingChunkTracker.getLevel 122, DynamicGraphMinFixedPoint.checkEdge 116, PalettedContainerInvoker.quicksilver$create 99, PalettedContainer.create$quicksilver_$md$504ced$0 99, PalettedContainer.handler$zom000$quicksilver$share 99, PalettedContainer.copy 99

Top chunk methods (self): Thread.yield0 173, LevelChunkSection.<init> 104, PalettedContainer.create$quicksilver_$md$504ced$0 99, LongOpenHashSet.contains 74, ServerChunkCache.getChunk 54, Long2ObjectLinkedOpenHashMap.get 54, Long2ObjectOpenHashMap.get 53, Long2ObjectFunctions$SynchronizedFunction.get 34, SerializableChunkData.copyOf 32, DataLayer.<init> 28, UnixFileDispatcherImpl.write0 22, Long2ByteOpenHashMap.get 21, Long2ByteOpenHashMap.find 17, ArrayList.grow 14, DirectMethodHandle.allocateInstance 11, HashMap.putVal 10, LongLinkedOpenHashSet.add 9, ConcurrentLinkedQueue.size 9, ChunkMap.saveAllChunks 8, TimSort.countRunAndMakeAscending 8, Deflater.init 8, AbstractConsecutiveExecutor.schedule 7, DynamicGraphMinFixedPoint.checkNeighbor 6, DistanceManager.runAllUpdates 6, ConcurrentLinkedQueue.offer 6, ChunkMap.onLevelChange 6, ChunkMap.saveChunkIfNeeded 6, ReferenceOpenHashSet$SetIterator.next 5, Sink$ChainedReference.begin 5, LongLinkedOpenHashSet.rehash 5

Threads (all samples in the window): Worker-Main 7094, Netty Epoll IO  7014, Server thread 1498, IO-Worker 639

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2698: DedicatedServer.saveAllChunks 2676, MinecraftServer.warnOnLowDiskSpace 20<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2676, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 20
- **ServerLevel.save** 2494: ServerChunkCache.save 2274, PersistentEntitySectionManager.autoSave 165, ServerLevel.saveLevelData 54<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 2272, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 145, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 53, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 18, ServerChunkCache.save > ServerChunkCache.runDistanceManagerUpdates 1, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 1
- **ChunkMap.saveAllChunks** 2272: ChunkMap.saveChunkIfNeeded 2229, Long2ObjectLinkedOpenHashMap$ValueIterator.next 8, Long2ObjectLinkedOpenHashMap$1.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 2190, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 15, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 8, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 2, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 2
- **ChunkMap.save** 2190: SerializableChunkData.copyOf 2124, CompletableFuture.supplyAsync 26, SimpleRegionStorage.write 17, CompletableFuture.handle 10, ChunkMap.markPosition 4, DirectMethodHandle.allocateInstance 4, ChunkAccess.tryMarkSaved 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 1043, SerializableChunkData.copyOf > LightEngine.getDataLayerData 248, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 165, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 149, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 132, SerializableChunkData.copyOf > ReferencePipeline.toArray 77, SerializableChunkData.copyOf > DataLayer.copy 49, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 38, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 25, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 22, SerializableChunkData.copyOf > ArrayList.add 19, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 17
- **SerializableChunkData.copyOf** 2124: LevelChunkSection.copy 1043, LightEngine.getDataLayerData 248, SerializableChunkData.packStructureData 165, LevelChunk.getTicksForSerialization 149, LevelChunk.getBlockEntityNbtForSaving 132, ReferencePipeline.toArray 77, DataLayer.copy 49, ChunkAccess.getBlockEntitiesPos 38, Collections$UnmodifiableCollection$1.hasNext 20, ArrayList.add 19, LevelLightEngine.getMaxLightSection 17, Collections$UnmodifiableCollection$1.next 9<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 1042, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 246, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 145, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 129, SerializableChunkData.packStructureData > StructureStart.createTag 92, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 77, DataLayer.copy > DataLayer.<init> 39, ArrayList.add > ArrayList.add 19, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 17, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 17, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 13
- **DistanceManager.runAllUpdates** 603: LoadingChunkTracker.runDistanceUpdates 464, ChunkHolder.updateFutures 93, ReferenceOpenHashSet$SetIterator.next 15, ReferenceOpenHashSet.clear 10, GenerationChunkHolder.updateHighestAllowedStatus 3, DistanceManager$PlayerTicketTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 464, ChunkHolder.updateFutures > ChunkMap.onLevelChange 49, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 28, ReferenceOpenHashSet.clear > Arrays.fill 10, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 7, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 3, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 2, DistanceManager$PlayerTicketTracker.runAllUpdates > DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 1
- **PersistentEntitySectionManager.autoSave** 165: AbstractLongCollection.forEach 145, PersistentEntitySectionManager.getAllChunksToSave 18<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 145, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 9, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 3, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1
- **ChunkMap.processUnloads** 54: ConcurrentLinkedQueue.size 26, CompletableFuture$Completion.run 10, ChunkMap.scheduleUnload 9, LongOpenHashSet$SetIterator.remove 3, Long2ObjectLinkedOpenHashMap.put 2, Long2ObjectLinkedOpenHashMap.remove 1, ConcurrentLinkedQueue.poll 1, ChunkMap.saveChunksEagerly 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 10, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 7, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 3, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 2, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1, ChunkMap.saveChunksEagerly > Util.getMillis 1, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1, LongOpenHashSet$SetIterator.nextLong > LongArrayList.getLong 1
- **LevelChunk.runPostLoad** 25: SerializableChunkData.lambda$postLoadChunk$0 25<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 23, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 1, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 1
- **SerializableChunkData.read** 19: PoiManager.checkConsistencyWithBlocks 10, SerializableChunkData.unpackStructureReferences 2, LevelChunkTicks.<init> 2, Level.dimensionType 1, LevelHeightAccessor.getSectionsCount 1, ImposterProtoChunk.<init> 1, SerializableChunkData.unpackStructureStart 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 8, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 2, PoiManager.checkConsistencyWithBlocks > Util.ifElse 1, LevelHeightAccessor.getSectionsCount > LevelHeightAccessor.getMaxSectionY 1, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 1, LevelChunkTicks.<init> > ScheduledTick.probe 1, ImposterProtoChunk.<init> > ProtoChunk.<init> 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, PoiManager.checkConsistencyWithBlocks > SectionPos.asLong 1
- **ChunkMap.saveChunksEagerly** 1: Util.getMillis 1<br>two down: Util.getMillis > Util.getNanos 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2130: DedicatedServer.saveAllChunks 2110, MinecraftServer.warnOnLowDiskSpace 20<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2109, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 20
- **ServerLevel.save** 1953: ServerChunkCache.save 1761, PersistentEntitySectionManager.autoSave 157, ServerLevel.saveLevelData 34<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1758, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 144, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 34, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 13, ServerChunkCache.save > ServerChunkCache.runDistanceManagerUpdates 1
- **ChunkMap.saveAllChunks** 1758: ChunkMap.saveChunkIfNeeded 1727, Long2ObjectLinkedOpenHashMap$ValueIterator.next 6, Long2ObjectLinkedOpenHashMap$MapIterator.hasNext 1, Long2LongOpenHashMap.clear 1, Long2ObjectLinkedOpenHashMap$1.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1692, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 14, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 5, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1
- **ChunkMap.save** 1692: SerializableChunkData.copyOf 1651, CompletableFuture.supplyAsync 16, SimpleRegionStorage.write 13, ChunkMap.markPosition 7, DirectMethodHandle.allocateInstance 1, SectionStorage.flush 1, CompletableFuture.handle 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 658, SerializableChunkData.copyOf > LightEngine.getDataLayerData 264, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 144, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 132, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 115, SerializableChunkData.copyOf > ReferencePipeline.toArray 73, SerializableChunkData.copyOf > DataLayer.copy 66, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 29, SerializableChunkData.copyOf > ArrayList.add 16, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 16, SimpleRegionStorage.write > IOWorker.store 13, SerializableChunkData.copyOf > Heightmap.getRawData 8
- **SerializableChunkData.copyOf** 1651: LevelChunkSection.copy 658, LightEngine.getDataLayerData 264, LevelChunk.getBlockEntityNbtForSaving 144, SerializableChunkData.packStructureData 132, LevelChunk.getTicksForSerialization 115, ReferencePipeline.toArray 73, DataLayer.copy 66, ChunkAccess.getBlockEntitiesPos 29, ArrayList.add 16, Heightmap.getRawData 6, ChunkAccess.getHeightmaps 4, Collections$UnmodifiableCollection.iterator 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 654, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 260, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 137, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 113, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 73, SerializableChunkData.packStructureData > StructureStart.createTag 67, DataLayer.copy > DataLayer.<init> 64, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, ArrayList.add > ArrayList.add 16, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 10, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 8
- **DistanceManager.runAllUpdates** 609: LoadingChunkTracker.runDistanceUpdates 474, ChunkHolder.updateFutures 90, ReferenceOpenHashSet.clear 11, ReferenceOpenHashSet$SetIterator.next 9, GenerationChunkHolder.updateHighestAllowedStatus 7, SimulationChunkTracker.runAllUpdates 1, ReferenceOpenHashSet$SetIterator.hasNext 1, ReferenceOpenHashSet.iterator 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 474, ChunkHolder.updateFutures > ChunkMap.onLevelChange 48, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 26, ReferenceOpenHashSet.clear > Arrays.fill 11, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 8, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 7, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 4, SimulationChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 1, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 1, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 1, ReferenceOpenHashSet.iterator > ReferenceOpenHashSet.iterator 1
- **PersistentEntitySectionManager.autoSave** 157: AbstractLongCollection.forEach 144, PersistentEntitySectionManager.getAllChunksToSave 13<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 144, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 6, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 5, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 1
- **ChunkMap.processUnloads** 73: ConcurrentLinkedQueue.size 30, ChunkMap.scheduleUnload 13, CompletableFuture$Completion.run 11, Long2ObjectLinkedOpenHashMap.remove 5, LongOpenHashSet$SetIterator.remove 3, ChunkMap.saveChunksEagerly 3, Long2ObjectLinkedOpenHashMap.put 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 11, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 8, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 3, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 2, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 1, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 1
- **LevelChunk.runPostLoad** 22: SerializableChunkData.lambda$postLoadChunk$0 22<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 21, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 1
- **SerializableChunkData.read** 17: PoiManager.checkConsistencyWithBlocks 7, Objects.equals 2, SerializableChunkData.unpackStructureReferences 2, ThreadedLevelLightEngine.retainData 2, ImposterProtoChunk.<init> 1, ChunkAccess.setHeightmap 1, SerializableChunkData.unpackStructureStart 1, EnumSet.copyOf 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 6, Objects.equals > ChunkPos.equals 2, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 2, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 1, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, PoiManager.checkConsistencyWithBlocks > Util.ifElse 1, ThreadedLevelLightEngine.retainData > Util.name 1, EnumSet.copyOf > EnumSet.clone 1
- **ChunkMap.saveChunksEagerly** 3: LongLinkedOpenHashSet.iterator 2<br>two down: LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 357 | 13008 | 12739 | 0 | 269 | 0 |
| 1 | quicksilver | 357 | 12647 | 12644 | 0 | 3 | 0 |
| 2 | vanilla | 357 | 12739 | 12739 | 0 | 0 | 0 |
| 2 | quicksilver | 357 | 12903 | 12900 | 0 | 3 | 0 |
| 3 | vanilla | 357 | 12737 | 12737 | 0 | 0 | 0 |
| 3 | quicksilver | 357 | 12308 | 12290 | 0 | 18 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-3 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 7 | 1 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 285 / 357 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 7 | 1 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 244 / 357 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 7 | 1 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 271 / 357 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 268 / 357 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 7 | 1 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 255 / 357 | 0 |

Vanilla's noise (rounds 2-3 against 1): dimensions/minecraft/overworld/entities: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 1.813 | 9.900 | 47.599 | 0 | 0.198 (0.096) | 0.299 (0.299) | 0.000 | - | 40: 47.6, 8: 28.8, 35: 24.6, 0: 22.5, 682: 15.3 |
| 1 | quicksilver | yes | 1.724 | 8.987 | 40.984 | 0 | 0.188 (0.086) | 0.287 (0.287) | 0.000 | - | 40: 41.0, 8: 31.5, 0: 22.8, 640: 22.0, 576: 18.1 |
| 2 | vanilla | yes | 1.659 | 9.093 | 27.860 | 0 | 0.183 (0.087) | 0.301 (0.301) | 0.000 | - | 8: 27.9, 232: 25.5, 0: 22.0, 144: 19.3, 1000: 18.6 |
| 2 | quicksilver | yes | 1.688 | 8.852 | 33.661 | 0 | 0.186 (0.084) | 0.306 (0.306) | 0.000 | - | 8: 33.7, 880: 26.2, 0: 18.7, 40: 17.9, 1136: 15.7 |
| 3 | vanilla | yes | 1.881 | 10.668 | 26.054 | 0 | 0.224 (0.109) | 0.350 (0.350) | 0.000 | - | 8: 26.1, 272: 20.0, 40: 20.0, 0: 18.6, 424: 17.6 |
| 3 | quicksilver | yes | 1.861 | 10.251 | 30.557 | 0 | 0.204 (0.100) | 0.327 (0.327) | 0.000 | - | 8: 30.6, 0: 24.0, 696: 21.6, 186: 16.9, 40: 16.7 |
| 4 | vanilla | yes | 1.838 | 10.959 | 30.860 | 0 | 0.216 (0.102) | 0.323 (0.323) | 0.000 | - | 8: 30.9, 0: 23.3, 208: 23.3, 40: 19.8, 944: 17.8 |
| 4 | quicksilver | yes | 1.838 | 10.729 | 31.830 | 0 | 0.215 (0.108) | 0.292 (0.292) | 0.000 | - | 8: 31.8, 40: 28.2, 0: 24.7, 16: 20.0, 488: 19.1 |
| 5 | vanilla | yes | 2.026 | 12.590 | 26.338 | 0 | 0.218 (0.097) | 0.362 (0.362) | 0.000 | - | 8: 26.3, 616: 20.8, 112: 20.7, 0: 20.7, 83: 20.2 |
| 5 | quicksilver | yes | 1.651 | 9.564 | 31.670 | 0 | 0.189 (0.084) | 0.287 (0.287) | 0.000 | - | 8: 31.7, 0: 23.2, 40: 22.2, 688: 17.9, 467: 17.0 |
| 6 | vanilla | yes | 1.778 | 10.833 | 41.937 | 0 | 0.197 (0.094) | 0.295 (0.295) | 0.000 | - | 40: 41.9, 8: 26.1, 0: 20.1, 48: 18.5, 752: 17.0 |
| 6 | quicksilver | yes | 1.824 | 10.655 | 26.419 | 0 | 0.216 (0.092) | 0.321 (0.321) | 0.000 | - | 8: 26.4, 0: 24.6, 1024: 24.2, 40: 22.7, 16: 18.4 |
| 7 | vanilla | yes | 1.840 | 9.639 | 37.410 | 0 | 0.216 (0.098) | 0.324 (0.324) | 0.000 | - | 8: 37.4, 40: 25.9, 120: 23.8, 0: 22.5, 32: 17.6 |
| 7 | quicksilver | yes | 1.818 | 10.379 | 26.651 | 0 | 0.202 (0.094) | 0.294 (0.294) | 0.000 | - | 40: 26.7, 8: 25.3, 0: 21.7, 59: 20.8, 120: 17.4 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 1.838 | 1.818 | 0.989 (0.81 to 1.03) |
| MSPT p99 | 10.668 | 10.251 | 0.973 (0.76 to 1.08) |
| slowest tick (ms) | 30.860 | 31.670 | 1.031 (0.63 to 1.21) |
| ticks over 50 ms | 0 | 0 | - (- to -) |
| chunk load, ms per tick (server thread) | 0.216 | 0.202 | 0.949 (0.87 to 1.10) |
|   of it in the tick | 0.097 | 0.092 | 0.966 (0.87 to 1.06) |
| chunk save, ms per tick (server thread) | 0.323 | 0.294 | 0.933 (0.79 to 1.09) |
|   of it in the tick | 0.323 | 0.294 | 0.933 (0.79 to 1.09) |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 59787 ms, 22555 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 339 / 0 | 0 / 0 | 0.282 | 408.7 |
| entity save | 18 / 0 | 0 / 0 | 0.015 | 4.5 |
| POI save | 2 / 0 | 0 / 0 | 0.002 | 0.0 |
| chunk load | 0 / 0 | 62 / 2 | 0.053 | 69.5 |
| chunk to full (promote) | 104 / 0 | 57 / 0 | 0.134 | 31.2 |
| entity load | 11 / 0 | 1 / 0 | 0.010 | 0.1 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 15 / 0 | 0 / 0 | 0.013 | 10.2 |
| light | 0 / 0 | 1 / 0 | 0.001 | 1.4 |
| chunk system (tickets, holders, tasks) | 447 / 1 | 253 / 1 | 0.585 | 200.7 |
| tick, other | 426 / 0 | 0 / 0 | 0.355 | 0.9 |
| idle or other | 0 / 0 | 82 / 1 | 0.069 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1311, MinecraftServer.lambda$spin$0 1311, Thread.run 1308, MinecraftServer.tickServer 937, MinecraftServer.processPacketsAndTick 937, DedicatedServer.tickServer 937, ServerLevel.tick 929, MinecraftServer.tickChildren 929, ServerChunkCache.tick 884, ServerChunkCache.runDistanceManagerUpdates 442, DistanceManager.runAllUpdates 440, MinecraftServer.pollTaskInternal 376, ServerChunkCache$MainThreadExecutor.pollTask 375, MinecraftServer.pollTask 375, ServerChunkCache.pollTask 375, MinecraftServer.waitUntilNextTick 374, ChunkMap.tick 371, BlockableEventLoop.managedBlock 369, BlockableEventLoop.pollTask 364, BlockableEventLoop.doRunTask 360, ServerChunkCache$MainThreadExecutor.doRunTask 359, ChunkMap.processUnloads 354, CompletableFuture$Completion.run 326, ChunkMap.saveChunksEagerly 318, CompletableFuture$UniApply.tryFire 295, DynamicGraphMinFixedPoint.runUpdates 280, LoadingChunkTracker.runDistanceUpdates 280, ChunkMap.saveChunkIfNeeded 242, ChunkTracker.checkNeighborsAfterUpdate 238, DynamicGraphMinFixedPoint.checkNeighbor 234, ChunkMap.save 222, ChunkResult$Success.map 220, ChunkMap.lambda$prepareTickingChunk$1 218, ChunkMap.lambda$prepareTickingChunk$2 218, SerializableChunkData.copyOf 216, LevelChunk.postProcessGeneration 209, Long2ObjectLinkedOpenHashMap.get 189, LoadingChunkTracker.getLevel 153, DynamicGraphMinFixedPoint.checkEdge 141, ChunkHolder.updateFutures 135, ChunkTracker.getComputedLevel 119, Block.updateFromNeighbourShapes 119, ChunkMap.getUpdatingChunkIfPresent 108, ChunkMap$DistanceManager.getChunk 107, PalettedContainer.get 88, ChunkMap.getChunkRangeFuture 84, Level.getBlockState 83, LevelChunk.getBlockState 82, LevelChunkSection.getBlockState 78, GenerationChunkHolder.scheduleChunkGenerationTask 71, LevelChunkSection.<init> 71, LevelChunkSection.copy 71, ChunkGenerationTask.create 69, StaticCache2D.<init> 69, GenerationChunkHolder.rescheduleChunkTask 69, StaticCache2D.create 69, ChunkGenerationTask.lambda$create$0 69, ChunkMap.acquireGeneration 69, ChunkMap.scheduleGenerationTask 69, PalettedContainer.copy 69

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 189, PalettedContainer.get 74, PalettedContainer$Data.copy 50, LongOpenHashSet.contains 47, Long2LongOpenHashMap.getOrDefault 37, Long2ByteOpenHashMap.get 36, ChunkTracker.getComputedLevel 28, GenerationChunkHolder.getChunkIfPresentUnchecked 28, DynamicGraphMinFixedPoint.checkNeighbor 19, ChunkMap.saveChunksEagerly 19, Long2ObjectOpenHashMap.get 17, StateHolder.valueIndex 14, LongLinkedOpenHashSet.add 14, PalettedContainer.copy 13, ServerChunkCache.getChunk 12, Long2ObjectFunctions$SynchronizedFunction.get 12, VarHandleReferences$Array.getVolatile 12, NaturalSpawner.createState 11, DirectMethodHandle.allocateInstance 10, CrudeIncrementalIntIdentityHashBiMap.byId 10, DistanceManager.runAllUpdates 9, SerializableChunkData.copyOf 9, ReferenceOpenHashSet.add 9, LongLinkedOpenHashSet.rehash 8, FluidState.isEmpty 8, DynamicGraphMinFixedPoint.runUpdates 7, LocalCache.connectAccessOrder 7, ChunkHolder.updateFutures 7, LongLinkedOpenHashSet$SetIterator.nextLong 7, ConcurrentLinkedQueue.offer 6

Threads (all samples in the window): Netty Epoll IO  47449, IO-Worker 8015, Worker-Main 5172, Server thread 1823, JFR Periodic Tasks 7

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 59790 ms, 23586 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 317 / 0 | 0 / 0 | 0.264 | 228.4 |
| entity save | 18 / 0 | 0 / 0 | 0.015 | 8.8 |
| POI save | 9 / 0 | 0 / 0 | 0.007 | 0.1 |
| chunk load | 0 / 0 | 50 / 6 | 0.047 | 64.0 |
| chunk to full (promote) | 92 / 0 | 61 / 0 | 0.128 | 46.4 |
| entity load | 11 / 0 | 5 / 0 | 0.013 | 3.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 12 / 0 | 0 / 0 | 0.010 | 21.2 |
| light | 0 / 0 | 2 / 0 | 0.002 | 0.9 |
| chunk system (tickets, holders, tasks) | 451 / 1 | 259 / 0 | 0.593 | 204.7 |
| tick, other | 427 / 2 | 0 / 0 | 0.357 | 6.5 |
| idle or other | 0 / 0 | 80 / 1 | 0.068 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 1287, MinecraftServer.runServer 1287, Thread.run 1286, DedicatedServer.tickServer 911, MinecraftServer.tickServer 911, MinecraftServer.processPacketsAndTick 911, ServerLevel.tick 908, MinecraftServer.tickChildren 908, ServerChunkCache.tick 864, ServerChunkCache.runDistanceManagerUpdates 433, DistanceManager.runAllUpdates 432, ServerChunkCache$MainThreadExecutor.pollTask 379, MinecraftServer.pollTaskInternal 378, MinecraftServer.pollTask 378, ServerChunkCache.pollTask 378, MinecraftServer.waitUntilNextTick 377, BlockableEventLoop.doRunTask 371, BlockableEventLoop.pollTask 371, ServerChunkCache$MainThreadExecutor.doRunTask 369, ChunkMap.tick 350, BlockableEventLoop.managedBlock 331, ChunkMap.processUnloads 329, CompletableFuture$Completion.run 328, ChunkMap.saveChunksEagerly 300, CompletableFuture$UniApply.tryFire 295, DynamicGraphMinFixedPoint.runUpdates 269, LoadingChunkTracker.runDistanceUpdates 268, ChunkMap.lambda$prepareTickingChunk$1 229, ChunkResult$Success.map 229, ChunkMap.lambda$prepareTickingChunk$2 226, ChunkTracker.checkNeighborsAfterUpdate 224, DynamicGraphMinFixedPoint.checkNeighbor 217, ChunkMap.saveChunkIfNeeded 214, ChunkMap.save 210, LevelChunk.postProcessGeneration 210, SerializableChunkData.copyOf 204, DynamicGraphMinFixedPoint.checkEdge 165, ChunkHolder.updateFutures 143, ChunkTracker.getComputedLevel 118, Block.updateFromNeighbourShapes 113, LoadingChunkTracker.getLevel 104, Long2ObjectLinkedOpenHashMap.get 99, ChunkMap.getChunkRangeFuture 93, PalettedContainer.get 82, LongOpenHashSet.contains 81, ChunkMap$DistanceManager.isChunkToRemove 81, ServerChunkCache.tickChunks 73, Level.getBlockState 73, LevelChunkSection.getBlockState 72, LevelChunk.getBlockState 72, GenerationChunkHolder.rescheduleChunkTask 70, GenerationChunkHolder.scheduleChunkGenerationTask 70, ChunkMap.acquireGeneration 69, ChunkMap.scheduleGenerationTask 69, StaticCache2D.<init> 69, StaticCache2D.create 69, ChunkGenerationTask.create 69, ChunkGenerationTask.lambda$create$0 69, GenerationChunkHolder.getChunkIfPresentUnchecked 68, GenerationChunkHolder.getLatestChunk 59

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 99, LongOpenHashSet.contains 81, PalettedContainer.get 73, ChunkTracker.getComputedLevel 50, GenerationChunkHolder.getChunkIfPresentUnchecked 46, Long2ByteOpenHashMap.get 36, Long2ObjectOpenHashMap.get 32, DynamicGraphMinFixedPoint.checkEdge 27, PalettedContainer.create$quicksilver_$md$bb8d19$0 15, ServerChunkCache.getChunk 14, VarHandleReferences$Array.getVolatile 14, StateHolder.valueIndex 13, LevelChunkSection.<init> 13, ChunkMap.saveChunksEagerly 13, ChunkMap.onLevelChange 13, HashMap.getNode 12, MultifaceBlock.updateShape 11, Long2ObjectOpenHashMap.getOrDefault 11, ConcurrentLinkedQueue.offer 11, SerializableChunkData.copyOf 10, NaturalSpawner.createState 10, Long2LongOpenHashMap.getOrDefault 10, ReferenceOpenHashSet.add 9, CompletableFuture.getNow 9, DynamicGraphMinFixedPoint.runUpdates 8, GenerationChunkHolder.increaseGenerationRefCount 8, DirectMethodHandle.allocateInstance 8, Block.updateFromNeighbourShapes 8, LongLinkedOpenHashSet.add 8, Comparator.lambda$comparingLong$6043328a$1 8

Threads (all samples in the window): Netty Epoll IO  47566, IO-Worker 7988, Worker-Main 5208, Server thread 1804, JFR Periodic Tasks 9, JNA Cleaner 1

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 3081: LoadingChunkTracker.runDistanceUpdates 1935, ChunkHolder.updateFutures 996, GenerationChunkHolder.updateHighestAllowedStatus 42, ReferenceOpenHashSet$SetIterator.next 13, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 10, ReferenceOpenHashSet.clear 8, DistanceManager$PlayerTicketTracker.runAllUpdates 4, ReferenceOpenHashSet.iterator 2, SimulationChunkTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1934, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 294, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 205, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 158, ChunkHolder.updateFutures > ChunkMap.onLevelChange 146, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 140, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 33, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 16, ChunkHolder.updateFutures > CompletableFuture.complete 11, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 10, ReferenceOpenHashSet.clear > Arrays.fill 7, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 5
- **ChunkMap.processUnloads** 2617: ChunkMap.saveChunksEagerly 2397, CompletableFuture$Completion.run 179, ChunkMap.scheduleUnload 12, ConcurrentLinkedQueue.size 5, Long2ObjectLinkedOpenHashMap.remove 5, Long2ObjectLinkedOpenHashMap.put 2, LongOpenHashSet$SetIterator.remove 2, ConcurrentLinkedQueue.poll 2, Long2ObjectLinkedOpenHashMap.get 2, LongOpenHashSet.iterator 1, MinecraftServer.haveTime 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1831, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 304, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 179, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 103, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 42, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 6, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 5, ChunkMap.saveChunksEagerly > Util.getMillis 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 2, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 2
- **ChunkMap.saveChunksEagerly** 2397: ChunkMap.saveChunkIfNeeded 1831, GenerationChunkHolder.getLatestChunk 304, Long2ObjectLinkedOpenHashMap.get 103, LongLinkedOpenHashSet$SetIterator.nextLong 42, Util.getMillis 3, MinecraftServer.haveTime 2, LongLinkedOpenHashSet$SetIterator.remove 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1529, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 304, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 215, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 57, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 4, Util.getMillis > Util.getNanos 3, MinecraftServer.haveTime > Util.getNanos 2
- **ChunkMap.save** 1658: SerializableChunkData.copyOf 1612, CompletableFuture.supplyAsync 12, SimpleRegionStorage.write 11, ChunkMap.markPosition 7, ChunkAccess.tryMarkSaved 3, SectionStorage.flush 3, DirectMethodHandle.allocateInstance 3, Profiler.get 3, CompletableFuture.handle 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 388, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 348, SerializableChunkData.copyOf > LightEngine.getDataLayerData 279, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 215, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 80, SerializableChunkData.copyOf > ReferencePipeline.toArray 59, SerializableChunkData.copyOf > DataLayer.copy 46, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 34, SerializableChunkData.copyOf > Heightmap.getRawData 12, SimpleRegionStorage.write > IOWorker.store 11, SerializableChunkData.copyOf > ArrayList.add 11, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 10
- **SerializableChunkData.copyOf** 1612: LevelChunkSection.copy 388, LevelChunk.getBlockEntityNbtForSaving 348, LightEngine.getDataLayerData 279, SerializableChunkData.packStructureData 215, LevelChunk.getTicksForSerialization 80, ReferencePipeline.toArray 59, DataLayer.copy 46, ChunkAccess.getBlockEntitiesPos 33, Heightmap.getRawData 11, Collections$UnmodifiableCollection$1.hasNext 10, ArrayList.add 10, ProblemReporter$ScopedCollector.<init> 7<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 384, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 335, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 278, SerializableChunkData.packStructureData > StructureStart.createTag 158, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 72, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 57, DataLayer.copy > DataLayer.<init> 38, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 18, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 14, ArrayList.add > ArrayList.add 11, LevelHeightAccessor.getSectionIndexFromSectionY > LevelHeightAccessor.getMinSectionY 8, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 8
- **LevelChunk.postProcessGeneration** 1506: Block.updateFromNeighbourShapes 909, FluidState.tick 215, BlockBehaviour$BlockStateBase.tick 195, LevelChunk.getBlockState 63, FluidState.isEmpty 33, LevelWriter.setBlock 20, UpgradeData.upgrade 11, ImmutableList.copyOf 9, ShortListIterator.next 8, LevelHeightAccessor.getSectionYFromSectionIndex 7, ShortArrayList$1.hasNext 4, ProtoChunk.unpackOffsetCoordinates 2<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 493, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 368, FluidState.tick > FlowingFluid.tick 215, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 195, LevelChunk.getBlockState > LevelChunkSection.getBlockState 63, LevelWriter.setBlock > Level.setBlock 20, ShortListIterator.next > ShortListIterator.next 8, UpgradeData.upgrade > Iterable.forEach 7, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 7, ImmutableList.copyOf > HashMap$KeySet.toArray 5, AbstractShortList.iterator > AbstractShortList.listIterator 1, UpgradeData.upgrade > ArrayList.forEach 1
- **SerializableChunkData.read** 455: SerializableChunkData.unpackStructureStart 292, SerializableChunkData.unpackStructureReferences 35, PoiManager.checkConsistencyWithBlocks 34, LevelChunkTicks.<init> 28, ImposterProtoChunk.<init> 23, LevelChunk.<init> 8, ChunkAccess.setAllReferences 5, ChunkAccess.addPackedPostProcess 5, ChunkAccess.setHeightmap 3, CompoundTag.put 3, ChunkAccess.setAllStarts 3, ChunkAccess.setLightCorrect 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 289, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 31, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 28, ImposterProtoChunk.<init> > ProtoChunk.<init> 22, PoiManager.checkConsistencyWithBlocks > Util.ifElse 18, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 16, LevelChunk.<init> > ChunkAccess.<init> 5, ChunkAccess.addPackedPostProcess > ChunkAccess.getOrCreateOffsetList 3, ChunkAccess.setAllReferences > HashMap.putAll 3, SerializableChunkData.unpackStructureReferences > DirectMethodHandle.allocateInstance 3, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 2, ChunkAccess.setLightCorrect > LevelChunk.markUnsaved 2
- **LevelChunk.runPostLoad** 292: SerializableChunkData.lambda$postLoadChunk$0 292<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 251, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 19, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 7, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 7, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 4
- **LevelChunk.<init>** 8: ChunkAccess.<init> 5, Heightmap.<init> 2, Int2ObjectOpenHashMap.<init> 1<br>two down: ChunkAccess.<init> > Maps.newEnumMap 2, Heightmap.<init> > ChunkAccess.getHeight 2, ChunkAccess.<init> > ChunkAccess.replaceMissingSections 1, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1
- **SectionStorage.flush** 3: LongLinkedOpenHashSet.remove 3<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 3018: LoadingChunkTracker.runDistanceUpdates 1904, ChunkHolder.updateFutures 979, GenerationChunkHolder.updateHighestAllowedStatus 44, ReferenceOpenHashSet$SetIterator.next 15, ReferenceOpenHashSet.clear 6, DistanceManager$PlayerTicketTracker.runAllUpdates 5, ReferenceOpenHashSet.iterator 3, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 3, SimulationChunkTracker.runAllUpdates 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1904, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 302, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 199, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 150, ChunkHolder.updateFutures > ChunkMap.onLevelChange 135, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 125, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 30, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 12, ChunkHolder.updateFutures > CompletableFuture.complete 9, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 8, ReferenceOpenHashSet.clear > Arrays.fill 5, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 4
- **ChunkMap.processUnloads** 2416: ChunkMap.saveChunksEagerly 2210, CompletableFuture$Completion.run 164, ChunkMap.scheduleUnload 10, ConcurrentLinkedQueue.poll 7, LongOpenHashSet$SetIterator.remove 4, Long2ObjectLinkedOpenHashMap.put 4, Long2ObjectLinkedOpenHashMap.remove 4, Long2ObjectLinkedOpenHashMap.get 2, MinecraftServer.haveTime 1, ConcurrentLinkedQueue.size 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1568, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 392, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 164, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 75, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 37, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 6, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 4, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 4, ChunkMap.saveChunksEagerly > MinecraftServer.haveTime 4, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 3, ChunkMap.saveChunksEagerly > Util.getMillis 3
- **ChunkMap.saveChunksEagerly** 2210: ChunkMap.saveChunkIfNeeded 1568, GenerationChunkHolder.getLatestChunk 392, Long2ObjectLinkedOpenHashMap.get 75, LongLinkedOpenHashSet$SetIterator.nextLong 37, LongLinkedOpenHashSet$SetIterator.remove 4, MinecraftServer.haveTime 4, Util.getMillis 3<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1350, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 366, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 112, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 71, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 4, MinecraftServer.haveTime > Util.getNanos 4, Util.getMillis > Util.getNanos 3, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 1, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 1
- **LevelChunk.postProcessGeneration** 1518: Block.updateFromNeighbourShapes 892, FluidState.tick 246, BlockBehaviour$BlockStateBase.tick 192, LevelChunk.getBlockState 69, FluidState.isEmpty 40, LevelHeightAccessor.getSectionYFromSectionIndex 13, LevelWriter.setBlock 9, UpgradeData.upgrade 8, ShortListIterator.next 4, ImmutableList.copyOf 4, ShortArrayList$1.hasNext 3, ProtoChunk.unpackOffsetCoordinates 2<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 481, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 362, FluidState.tick > FlowingFluid.tick 246, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 192, LevelChunk.getBlockState > LevelChunkSection.getBlockState 69, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 13, LevelWriter.setBlock > Level.setBlock 9, ShortListIterator.next > ShortListIterator.next 4, UpgradeData.upgrade > UpgradeData.upgradeInside 3, UpgradeData.upgrade > ArrayList.forEach 1, ImmutableList.copyOf > HashMap$KeySet.toArray 1, AbstractShortList.iterator > AbstractShortList.listIterator 1
- **ChunkMap.save** 1469: SerializableChunkData.copyOf 1422, CompletableFuture.supplyAsync 16, SimpleRegionStorage.write 12, SectionStorage.flush 5, ChunkMap.markPosition 3, CompletableFuture.handle 3, Profiler.get 2, DirectMethodHandle.allocateInstance 1, ChunkAccess.tryMarkSaved 1<br>two down: SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 373, SerializableChunkData.copyOf > LightEngine.getDataLayerData 288, SerializableChunkData.copyOf > LevelChunkSection.copy 220, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 211, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 60, SerializableChunkData.copyOf > ReferencePipeline.toArray 51, SerializableChunkData.copyOf > DataLayer.copy 36, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 31, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 16, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 15, SerializableChunkData.copyOf > ArrayList.add 12, SimpleRegionStorage.write > IOWorker.store 12
- **SerializableChunkData.copyOf** 1422: LevelChunk.getBlockEntityNbtForSaving 373, LightEngine.getDataLayerData 288, LevelChunkSection.copy 220, SerializableChunkData.packStructureData 211, LevelChunk.getTicksForSerialization 60, ReferencePipeline.toArray 51, DataLayer.copy 36, ChunkAccess.getBlockEntitiesPos 31, Collections$UnmodifiableCollection$1.hasNext 16, ArrayList.add 12, ChunkAccess.getHeightmaps 6, SerializableChunkData.handler$zon000$quicksilver$copySection 5<br>two down: LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 354, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 280, LevelChunkSection.copy > LevelChunkSection.<init> 213, SerializableChunkData.packStructureData > StructureStart.createTag 152, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 57, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 49, DataLayer.copy > DataLayer.<init> 26, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 13, ArrayList.add > ArrayList.add 12, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, SerializableChunkData.packStructureData > CompoundTag.put 8
- **SerializableChunkData.read** 393: SerializableChunkData.unpackStructureStart 258, LevelChunkTicks.<init> 32, SerializableChunkData.unpackStructureReferences 25, ImposterProtoChunk.<init> 24, PoiManager.checkConsistencyWithBlocks 21, LevelChunk.<init> 10, ChunkAccess.addPackedPostProcess 3, ChunkAccess.setAllStarts 2, ThreadedLevelLightEngine.retainData 2, ThreadedLevelLightEngine.queueSectionData 2, Heightmap.primeHeightmaps 2, SerializableChunkData.postLoadChunk 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 255, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 31, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 23, ImposterProtoChunk.<init> > ProtoChunk.<init> 22, PoiManager.checkConsistencyWithBlocks > Util.ifElse 11, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 10, LevelChunk.<init> > ChunkAccess.<init> 5, ChunkAccess.addPackedPostProcess > ShortList.addAll 3, LevelChunk.<init> > Heightmap.<init> 3, ChunkAccess.setAllStarts > HashMap.putAll 2, SerializableChunkData.unpackStructureStart > RegistryAccess.lookupOrThrow 2, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 2
- **LevelChunk.runPostLoad** 302: SerializableChunkData.lambda$postLoadChunk$0 302<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 240, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 27, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 15, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 9, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 4
- **LevelChunk.<init>** 10: ChunkAccess.<init> 5, Heightmap.<init> 3, Int2ObjectOpenHashMap.<init> 1, Heightmap$Types.values 1<br>two down: Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1, ChunkAccess.<init> > Maps.newEnumMap 1, ChunkAccess.<init> > LevelHeightAccessor.getSectionsCount 1, Heightmap.<init> > ChunkAccess.getHeight 1, ChunkAccess.<init> > ChunkSkyLightSources.<init> 1, Heightmap.<init> > SimpleBitStorage.<init> 1, Heightmap.<init> > Mth.ceillog2 1, ChunkAccess.<init> > ChunkAccess.replaceMissingSections 1, Heightmap$Types.values > Object.clone 1
- **SectionStorage.flush** 5: ChunkPos.pack 3, LongLinkedOpenHashSet.remove 2<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 1614 | 6015 | 3580 | 1774 | 661 | 313 (first [-1, -18]) |
| 1 | quicksilver | 1614 | 6016 | 3586 | 2013 | 417 | 214 (first [-1, -17]) |
| 2 | vanilla | 1614 | 6016 | 3542 | 1800 | 674 | 281 (first [-1, -16]) |
| 2 | quicksilver | 1614 | 6015 | 3602 | 2027 | 386 | 221 (first [-1, -17]) |
| 3 | vanilla | 1614 | 6015 | 3483 | 1890 | 642 | 258 (first [-1, -16]) |
| 3 | quicksilver | 1614 | 6015 | 3598 | 1948 | 469 | 263 (first [-1, -16]) |
| 4 | vanilla | 1614 | 6015 | 3519 | 1867 | 629 | 257 (first [-1, -17]) |
| 4 | quicksilver | 1614 | 6015 | 3622 | 1796 | 597 | 290 (first [-1, -16]) |
| 5 | vanilla | 1614 | 6015 | 3573 | 1862 | 580 | 282 (first [-1, -17]) |
| 5 | quicksilver | 1614 | 6015 | 3616 | 1955 | 444 | 308 (first [-1, -16]) |
| 6 | vanilla | 1614 | 6015 | 3521 | 1840 | 654 | 253 (first [-1, 10]) |
| 6 | quicksilver | 1614 | 6015 | 3514 | 1931 | 570 | 268 (first [-1, 18]) |
| 7 | vanilla | 1614 | 6015 | 3403 | 1996 | 616 | 275 (first [-1, -16]) |
| 7 | quicksilver | 1614 | 6015 | 3534 | 1989 | 492 | 255 (first [-1, -17]) |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 761 (218) | 0 (0) | LastUpdate 213, block_ticks 488, fluid_ticks 458 | 1517 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 855 (0) | 0 (0) | LastUpdate 250, block_ticks 540, fluid_ticks 488 | 1507 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 694 (224) | 0 (0) | LastUpdate 213, block_ticks 445, fluid_ticks 376 | 1521 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 847 (0) | 0 (0) | LastUpdate 271, block_ticks 525, fluid_ticks 508 | 1522 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 768 (289) | 0 (0) | LastUpdate 216, block_ticks 500, fluid_ticks 471, sections 1 | 1519 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 834 (0) | 0 (0) | LastUpdate 262, block_ticks 530, fluid_ticks 467, sections 1 | 1486 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 860 (370) | 0 (0) | LastUpdate 319, block_ticks 530, fluid_ticks 479, sections 1 | 1524 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 735 (0) | 0 (0) | LastUpdate 233, block_ticks 438, fluid_ticks 442 | 1534 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 821 (265) | 0 (0) | LastUpdate 235, block_ticks 545, fluid_ticks 468, sections 1 | 1488 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 744 (0) | 0 (0) | LastUpdate 264, block_ticks 444, fluid_ticks 443, sections 1 | 1500 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (1) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 781 (277) | 0 (0) | LastUpdate 238, block_ticks 511, fluid_ticks 437 | 1545 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 847 (0) | 0 (0) | LastUpdate 222, block_ticks 525, fluid_ticks 487 | 1528 / 1681 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 710 (242) | 0 (0) | LastUpdate 220, block_ticks 449, fluid_ticks 418 | 1512 / 1681 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 7 data, 0 bytes only, 0 one side, keys DataVersion 10, Entities 13, Position 10; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1115 data, 0 bytes only, 0 one side, keys LastUpdate 1502, block_ticks 3002, fluid_ticks 2835, sections 2

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.539 | 0.930 | 2656.512 | 5 | 0.000 (0.000) | 0.018 (0.018) | 0.017 | 5724 (85.5) | 700: 2656.5, 100: 107.5, 400: 96.7, 5724: 85.5, 6470: 64.0 |
| 1 | quicksilver | yes | 0.538 | 0.619 | 2589.703 | 5 | 0.001 (0.001) | 0.015 (0.015) | 0.013 | 5730 (80.5) | 700: 2589.7, 100: 94.4, 5730: 80.5, 6671: 55.3, 400: 50.9 |
| 2 | vanilla | yes | 0.528 | 0.778 | 2601.045 | 4 | 0.000 (0.000) | 0.015 (0.015) | 0.014 | 5728 (70.1) | 700: 2601.0, 400: 72.6, 100: 70.4, 5728: 70.1, 604: 34.0 |
| 2 | quicksilver | yes | 0.518 | 0.923 | 2557.952 | 5 | 0.000 (0.000) | 0.020 (0.020) | 0.019 | 5731 (60.0) | 700: 2558.0, 400: 80.2, 100: 73.3, 5731: 60.0, 6410: 52.6 |
| 3 | vanilla | yes | 0.524 | 0.731 | 2678.045 | 3 | 0.000 (0.000) | 0.018 (0.018) | 0.017 | 5727 (48.1) | 700: 2678.0, 100: 113.5, 400: 88.0, 5727: 48.1, 0: 22.3 |
| 3 | quicksilver | yes | 0.516 | 0.747 | 2624.770 | 3 | 0.000 (0.000) | 0.015 (0.015) | 0.014 | 5726 (44.6) | 700: 2624.8, 100: 79.0, 400: 72.3, 5726: 44.6, 689: 29.6 |
| 4 | vanilla | yes | 0.513 | 0.926 | 2678.076 | 4 | 0.001 (0.001) | 0.011 (0.011) | 0.009 | 5725 (53.0) | 700: 2678.1, 100: 75.1, 400: 54.8, 5725: 53.0, 0: 25.6 |
| 4 | quicksilver | yes | 0.499 | 0.739 | 2474.990 | 3 | 0.000 (0.000) | 0.012 (0.012) | 0.011 | 5726 (48.9) | 700: 2475.0, 100: 86.3, 400: 55.4, 5726: 48.9, 4334: 43.3 |
| 5 | vanilla | yes | 0.526 | 0.874 | 2598.024 | 3 | 0.000 (0.000) | 0.013 (0.013) | 0.013 | 5726 (47.6) | 700: 2598.0, 100: 97.0, 400: 70.9, 5726: 47.6, 403: 33.9 |
| 5 | quicksilver | yes | 0.523 | 0.737 | 2648.369 | 4 | 0.000 (0.000) | 0.018 (0.018) | 0.018 | 5724 (45.4) | 700: 2648.4, 100: 103.2, 400: 61.2, 1080: 58.7, 5724: 45.4 |
| 6 | vanilla | yes | 0.522 | 0.948 | 2531.081 | 4 | 0.001 (0.001) | 0.021 (0.021) | 0.019 | 5732 (74.6) | 700: 2531.1, 100: 144.6, 400: 78.5, 5732: 74.6, 0: 25.3 |
| 6 | quicksilver | yes | 0.533 | 0.819 | 2675.114 | 4 | 0.001 (0.001) | 0.016 (0.016) | 0.015 | 5728 (64.3) | 700: 2675.1, 100: 69.0, 5728: 64.3, 400: 62.5, 0: 21.2 |
| 7 | vanilla | yes | 0.541 | 0.915 | 2554.867 | 5 | 0.000 (0.000) | 0.014 (0.014) | 0.013 | 5724 (111.6) | 700: 2554.9, 5724: 111.6, 100: 87.2, 400: 68.4, 0: 55.2 |
| 7 | quicksilver | yes | 0.533 | 0.661 | 2641.350 | 3 | 0.000 (0.000) | 0.015 (0.015) | 0.014 | 5724 (77.0) | 700: 2641.3, 100: 99.6, 5724: 77.0, 400: 49.1, 630: 29.7 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 0.526 | 0.523 | 0.985 (0.97 to 1.02) |
| MSPT p99 | 0.915 | 0.739 | 0.843 (0.67 to 1.19) |
| slowest tick (ms) | 2601.045 | 2624.770 | 0.983 (0.92 to 1.06) |
| ticks over 50 ms | 4 | 4 | 1.000 (0.60 to 1.33) |
| chunk load, ms per tick (server thread) | 0.000 | 0.000 | 1.000 (0.10 to 4.00) |
|   of it in the tick | 0.000 | 0.000 | 1.000 (0.10 to 4.00) |
| chunk save, ms per tick (server thread) | 0.015 | 0.015 | 1.101 (0.76 to 1.38) |
|   of it in the tick | 0.015 | 0.015 | 1.086 (0.76 to 1.40) |
| autosave, ms per tick | 0.014 | 0.014 | 1.046 (0.77 to 1.40) |
| save-all tick (ms, mean of the script's) | 83.960 | 74.339 | 0.955 (0.59 to 1.09) |
| save-all flush tick (ms) | 2601.045 | 2624.770 | 0.983 (0.92 to 1.06) |
| autosave tick (ms, the game's own) | 70.071 | 59.991 | 0.924 (0.69 to 0.95) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 3817 ms, 23685 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 120 / 1 | 1 / 0 | 0.017 | 160.5 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 2.8 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 6 / 0 | 0 / 0 | 0.001 | 2.9 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 2 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 5 / 0 | 0 / 0 | 0.001 | 0.0 |
| light | 0 / 0 | 2 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 158 / 2 | 2 / 0 | 0.023 | 32.2 |
| tick, other | 293 / 0 | 0 / 0 | 0.042 | 10.0 |
| idle or other | 0 / 0 | 16 / 0 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 300, MinecraftServer.runServer 300, Thread.run 299, MinecraftServer.processPacketsAndTick 296, DedicatedServer.tickServer 296, MinecraftServer.tickServer 296, MinecraftServer.tickChildren 171, ServerLevel.tick 171, ServerChunkCache.tick 161, ServerChunkCache.tickChunks 131, MinecraftServer.saveEverything 120, MinecraftServer.saveAllChunks 119, DedicatedServer.saveAllChunks 119, ServerLevel.save 117, ChunkMap.saveAllChunks 106, ServerChunkCache.save 106, ChunkMap.save 103, SerializableChunkData.copyOf 101, NaturalSpawner.createState 91, Harness.startTick 77, ChunkMap.saveChunkIfNeeded 77, ServerTickEvents.lambda$static$1 76, ContextChain.runExecutable 73, CommandDispatcher.execute 73, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 73, SaveAllCommand.saveAll 73, Harness.command 73, ContextChain.runExecutable$mixinextras$wrapped$10 73, ContextChain.executeAll 73, ServerChunkCache.getFullChunk 67, NaturalSpawner.lambda$createState$0 53, ChunkResult$Success.ifSuccess 53, MinecraftServer.autoSave 49, LevelChunkSection.copy 42, EnvironmentAttributeReader.getValue 41, LevelChunkSection.<init> 40, PalettedContainer.copy 40, SaveAllCommand.lambda$register$0 39, PalettedContainer.<init> 38, PalettedContainer$Data.copy 37, EnvironmentAttributeSystem.getValue 36, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 35, EnvironmentAttributeSystem$ValueSampler.getValue 35, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 34, AbstractPipeline.evaluate 34, AbstractPipeline.copyInto 34, AbstractPipeline.wrapAndCopyInto 34, SaveAllCommand.lambda$register$1 34, ReferencePipeline$3$1.accept 31, ForEachOps$ForEachOp$OfRef.evaluateSequential 30, ReferencePipeline.forEach 30, ForEachOps$ForEachOp.evaluateSequential 30, ReferencePipeline$2$1.accept 29, BiomeManager.getBiome 28, AbstractList$RandomAccessSpliterator.forEachRemaining 27, Encoder.encodeStart 20, LevelReader.getNoiseBiome 20, ChunkMap.tick 19, LevelChunk.getBlockEntityNbtForSaving 17, TagValueOutput.store 16

Top chunk methods (self): PalettedContainer$Data.copy 23, Long2ByteOpenHashMap.get 15, ServerChunkCache.tickChunks 13, CompletableFuture.reportJoin 12, Long2ObjectOpenHashMap.<init> 11, PalettedContainer.get 11, Object.clone 10, Iterators$1.hasNext 10, ServerChunkCache.getChunk 7, Math.floorMod 5, NaturalSpawner.createState 4, SerializableChunkData.copyOf 4, BiomeManager.getBiome 3, TimSort.sort 3, Long2ObjectOpenHashMap.get 3, Arrays.copyOf 3, LinearPalette.copy 3, HashMap.putVal 3, ConcurrentLinkedQueue.size 3, Object2IntOpenHashMap.<init> 3, Long2ObjectOpenHashMap$MapIterator.nextEntry 3, Vec3.atLowerCornerWithOffset 3, Collections$UnmodifiableCollection$1.hasNext 3, LongOpenHashSet.contains 2, Reference2ObjectOpenHashMap.get 2, Iterables.unmodifiableIterable 2, Math.floor 2, Unsafe.allocateInstance 2, SectionPos.asLong 2, Int2ObjectLinkedOpenHashMap$MapIterator.nextEntry 2

Threads (all samples in the window): Netty Epoll IO  2229, Worker-Main 1203, IO-Worker 825, Server thread 610, JFR Periodic Tasks 2

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 3825 ms, 24441 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 92 / 2 | 0 / 0 | 0.013 | 95.5 |
| chunk save | 3 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 8 / 0 | 0 / 0 | 0.001 | 2.7 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 3 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 3 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 197 / 0 | 3 / 0 | 0.029 | 45.3 |
| tick, other | 375 / 2 | 0 / 0 | 0.054 | 13.2 |
| idle or other | 0 / 0 | 18 / 0 | 0.003 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 312, MinecraftServer.lambda$spin$0 312, Thread.run 310, DedicatedServer.tickServer 309, MinecraftServer.processPacketsAndTick 309, MinecraftServer.tickServer 309, ServerLevel.tick 212, MinecraftServer.tickChildren 212, ServerChunkCache.tick 192, ServerChunkCache.tickChunks 155, NaturalSpawner.createState 93, MinecraftServer.saveAllChunks 92, MinecraftServer.saveEverything 92, DedicatedServer.saveAllChunks 92, ServerLevel.save 89, ServerChunkCache.save 75, ChunkMap.saveAllChunks 75, Harness.startTick 69, ServerTickEvents.lambda$static$1 69, ChunkMap.save 68, CommandDispatcher.execute 66, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 66, Harness.command 66, ContextChain.runExecutable$mixinextras$wrapped$10 66, SaveAllCommand.saveAll 66, ContextChain.runExecutable 66, ContextChain.executeAll 66, SerializableChunkData.copyOf 65, ServerChunkCache.getFullChunk 62, ChunkMap.saveChunkIfNeeded 59, ChunkResult$Success.ifSuccess 53, NaturalSpawner.lambda$createState$0 52, EnvironmentAttributeReader.getValue 47, SaveAllCommand.lambda$register$0 46, EnvironmentAttributeSystem.getValue 42, EnvironmentAttributeSystem$ValueSampler.getValue 40, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 39, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 36, BiomeManager.getBiome 33, LevelReader.getNoiseBiome 31, MinecraftServer.autoSave 28, ChunkMap.tick 27, AbstractPipeline.evaluate 22, AbstractPipeline.wrapAndCopyInto 22, Long2ByteOpenHashMap.get 21, SimulationChunkTracker.getLevel 21, ChunkAccess.getNoiseBiome 21, ImposterProtoChunk.getNoiseBiome 21, AbstractPipeline.copyInto 20, SaveAllCommand.lambda$register$1 20, PalettedContainer.get 20, LevelChunkSection.getNoiseBiome 20, ReferencePipeline.forEach 17, LevelTicks.tick 17, LevelTicks.sortContainersToTick 17, LevelTicks.collectTicks 17, ServerChunkCache.isPositionTicking 17, ServerLevel.isPositionTickingWithEntitiesLoaded 17, DistanceManager.inBlockTickingRange 17, ServerLevel.shouldTickBlocksAt 17

Top chunk methods (self): ServerChunkCache.tickChunks 34, Long2ByteOpenHashMap.get 21, PalettedContainer.get 19, Iterators$1.hasNext 14, Long2ObjectOpenHashMap.<init> 11, PalettedContainer.create$quicksilver_$md$35cf4d$0 11, SerializableChunkData.copyOf 10, SectionPos.of 8, NaturalSpawner.createState 8, Long2ObjectOpenHashMap.get 8, CompletableFuture.reportJoin 8, Long2ObjectLinkedOpenHashMap.get 5, ArrayList.grow 4, ChunkPos.pack 4, SectionStorage.unpackPendingLoads 4, Iterables.unmodifiableIterable 4, ServerChunkCache$MainThreadExecutor.pollTask 3, AbstractPipeline.copyInto 3, Long2ByteOpenHashMap$MapEntrySet.fastIterator 3, DirectMethodHandle.allocateInstance 3, Long2ByteOpenHashMap$MapIterator.<init> 3, Vec3.atLowerCornerWithOffset 3, ChunkMap.saveChunksEagerly 3, Long2ObjectOpenHashMap$FastEntryIterator.next 3, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 2, NaturalSpawner.lambda$createState$0 2, Math.floorMod 2, Comparator.lambda$comparingLong$6043328a$1 2, RegistryAccess$ImmutableRegistryAccess.lookup 2, LongOpenHashSet$SetIterator.<init> 2

Threads (all samples in the window): Netty Epoll IO  2268, Worker-Main 1122, IO-Worker 765, Server thread 707

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 714: DedicatedServer.saveAllChunks 712, MinecraftServer.warnOnLowDiskSpace 2<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 712, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 2
- **ServerLevel.save** 682: ServerChunkCache.save 597, PersistentEntitySectionManager.autoSave 45, PersistentEntitySectionManager.saveAll 31, ServerLevel.saveLevelData 9<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 597, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 44, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 27, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 6, PersistentEntitySectionManager.saveAll > EntityStorage.flush 4, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 3, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 1
- **ChunkMap.saveAllChunks** 597: ChunkMap.saveChunkIfNeeded 479, ReferencePipeline.forEach 109, ReferencePipeline.toList 3, Long2ObjectLinkedOpenHashMap$ValueIterator.next 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 472, ReferencePipeline.forEach > AbstractPipeline.evaluate 109, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 4, ReferencePipeline.toList > ReferencePipeline.toArray 3, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 577: SerializableChunkData.copyOf 558, SimpleRegionStorage.write 7, CompletableFuture.supplyAsync 7, DirectMethodHandle.allocateInstance 2, SectionStorage.flush 2, Profiler.get 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 198, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 73, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 71, SerializableChunkData.copyOf > LightEngine.getDataLayerData 52, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 41, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 14, SerializableChunkData.copyOf > DataLayer.copy 14, SerializableChunkData.copyOf > ReferencePipeline.toArray 11, SimpleRegionStorage.write > IOWorker.store 7, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 7, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 6, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 5
- **SerializableChunkData.copyOf** 558: LevelChunkSection.copy 198, SerializableChunkData.packStructureData 73, LevelChunk.getBlockEntityNbtForSaving 71, LightEngine.getDataLayerData 52, LevelChunk.getTicksForSerialization 41, ChunkAccess.getBlockEntitiesPos 14, DataLayer.copy 14, ReferencePipeline.toArray 11, LevelLightEngine.getMaxLightSection 7, Collections$UnmodifiableCollection$1.hasNext 5, ArrayList.add 5, Heightmap.getRawData 5<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 185, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 66, SerializableChunkData.packStructureData > StructureStart.createTag 50, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 43, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 39, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 11, LightEngine.getDataLayerData > SectionPos.asLong 9, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 6, ArrayList.add > ArrayList.add 5, LevelLightEngine.getMaxLightSection > LevelLightEngine.getMinLightSection 5, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 4, SerializableChunkData.packStructureData > Identifier.toString 4
- **PersistentEntitySectionManager.autoSave** 45: AbstractLongCollection.forEach 44, PersistentEntitySectionManager.getAllChunksToSave 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 44, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 1
- **ChunkMap.processUnloads** 26: ChunkMap.saveChunksEagerly 13, ConcurrentLinkedQueue.size 4, LongOpenHashSet.iterator 3<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 6, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1
- **ChunkMap.saveChunksEagerly** 13: Util.getMillis 6, LongLinkedOpenHashSet.iterator 1<br>two down: Util.getMillis > Util.getNanos 6, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1
- **SectionStorage.flush** 2: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 721: DedicatedServer.saveAllChunks 719, MinecraftServer.warnOnLowDiskSpace 2<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 719, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 2
- **ServerLevel.save** 690: ServerChunkCache.save 585, PersistentEntitySectionManager.autoSave 62, PersistentEntitySectionManager.saveAll 32, ServerLevel.saveLevelData 11<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 585, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 61, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 25, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 7, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 4, PersistentEntitySectionManager.saveAll > EntityStorage.flush 4, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 3, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 1
- **ChunkMap.saveAllChunks** 585: ChunkMap.saveChunkIfNeeded 481, ReferencePipeline.forEach 87, ReferencePipeline.toList 2, Long2ObjectLinkedOpenHashMap$ValueIterator.next 2, Long2ObjectLinkedOpenHashMap$MapIterator.hasNext 1, ChunkMap.processUnloads 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 471, ReferencePipeline.forEach > AbstractPipeline.evaluate 87, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 6, ReferencePipeline.toList > ReferencePipeline.toArray 2, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 1, ChunkMap.processUnloads > ChunkMap.saveChunksEagerly 1, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 1
- **ChunkMap.save** 554: SerializableChunkData.copyOf 533, CompletableFuture.supplyAsync 8, SimpleRegionStorage.write 7, DirectMethodHandle.allocateInstance 2, ChunkMap.markPosition 2, ProfilerFiller.incrementCounter 1, Profiler.get 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 115, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 92, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 67, SerializableChunkData.copyOf > LightEngine.getDataLayerData 58, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 53, SerializableChunkData.copyOf > DataLayer.copy 27, SerializableChunkData.copyOf > ReferencePipeline.toArray 17, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 14, SerializableChunkData.copyOf > SectionPos.of 8, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 8, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 8, SerializableChunkData.copyOf > ArrayList.add 8
- **SerializableChunkData.copyOf** 533: LevelChunkSection.copy 115, LevelChunk.getBlockEntityNbtForSaving 92, SerializableChunkData.packStructureData 67, LightEngine.getDataLayerData 58, LevelChunk.getTicksForSerialization 53, DataLayer.copy 27, ReferencePipeline.toArray 17, ChunkAccess.getBlockEntitiesPos 14, SectionPos.of 8, LevelLightEngine.getMaxLightSection 8, ArrayList.add 8, SerializableChunkData.<init> 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 105, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 89, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 54, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 50, SerializableChunkData.packStructureData > StructureStart.createTag 42, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 17, ArrayList.add > ArrayList.add 8, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 7, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 7, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 6, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 5, LightEngine.getDataLayerData > SectionPos.asLong 4
- **PersistentEntitySectionManager.autoSave** 62: AbstractLongCollection.forEach 61, PersistentEntitySectionManager.getAllChunksToSave 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 61, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 1
- **ChunkMap.processUnloads** 26: ChunkMap.saveChunksEagerly 15, LongOpenHashSet.iterator 4, ConcurrentLinkedQueue.size 3<br>two down: LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 4, ChunkMap.saveChunksEagerly > Util.getMillis 3, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 15: Util.getMillis 3, LongLinkedOpenHashSet.iterator 1<br>two down: Util.getMillis > Util.getNanos 3, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 625 | 2086 | 2086 | 0 | 0 | 0 |
| 1 | quicksilver | 625 | 2060 | 1875 | 0 | 185 | 0 |
| 2 | vanilla | 625 | 2042 | 1875 | 0 | 167 | 0 |
| 2 | quicksilver | 625 | 2093 | 1875 | 0 | 218 | 0 |
| 3 | vanilla | 625 | 2139 | 1875 | 0 | 264 | 0 |
| 3 | quicksilver | 625 | 2089 | 2089 | 0 | 0 | 0 |
| 4 | vanilla | 625 | 2049 | 1875 | 0 | 174 | 0 |
| 4 | quicksilver | 625 | 2122 | 2099 | 0 | 23 | 0 |
| 5 | vanilla | 625 | 2099 | 1875 | 0 | 224 | 0 |
| 5 | quicksilver | 625 | 2124 | 2124 | 0 | 0 | 0 |
| 6 | vanilla | 625 | 2058 | 1875 | 0 | 183 | 0 |
| 6 | quicksilver | 625 | 2039 | 2039 | 0 | 0 | 0 |
| 7 | vanilla | 625 | 2134 | 2086 | 0 | 48 | 0 |
| 7 | quicksilver | 625 | 2046 | 2046 | 0 | 0 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 471 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 479 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 467 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 461 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 452 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 449 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 450 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 439 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 482 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 464 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 435 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 432 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 439 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 3 data, 0 bytes only, 0 one side, keys DataVersion 12, Entities 13, Position 12; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

## core / kill: a kill -9 mid-save (save-all flush of 625 changed chunks)

| run | killed mid-save | chunks: complete save's / its at another tick / saved terrain's / other / unreadable (region) | entities, poi: other / unreadable | reloaded |
|---|---|---|---|---|
| quicksilver-killed1 | yes | 9522 / 194 / 85 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| quicksilver-killed2 | yes | 9442 / 270 / 89 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed1 | yes | 9481 / 233 / 87 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed2 | yes | 9485 / 228 / 88 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
quicksilver-complete1 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0

quicksilver-complete2 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0


Each chunk of a killed save is either the complete save's (possibly written at another tick: it differs only in LastUpdate, block_ticks, fluid_ticks) or the saved terrain's: a kill loses the chunks not yet written, and breaks none. Entity and POI files are reported only (their data follows entity and POI timing, as in vanilla's own rounds).

