# Chunk scenes (P2-4)

## core / churn

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 14.635 | 198.922 | 1792.333 | 30 | 0.057 (0.050) | 1.317 (1.307) | 1.312 | - | 220: 1792.3, 128: 717.6, 87: 430.1, 103: 349.5, 139: 275.1 |
| 1 | quicksilver | yes | 15.168 | 204.017 | 2145.659 | 29 | 0.055 (0.048) | 1.305 (1.293) | 1.298 | - | 220: 2145.7, 87: 561.4, 128: 383.2, 103: 361.4, 26: 219.2 |
| 2 | vanilla | yes | 16.292 | 226.821 | 2094.531 | 34 | 0.032 (0.028) | 1.758 (1.750) | 1.752 | - | 220: 2094.5, 128: 413.0, 87: 406.4, 21: 279.4, 103: 276.1 |
| 2 | quicksilver | yes | 14.007 | 203.738 | 1818.542 | 25 | 0.042 (0.042) | 1.150 (1.145) | 1.143 | - | 220: 1818.5, 87: 432.7, 128: 384.4, 103: 296.6, 21: 219.8 |
| 3 | vanilla | yes | 15.815 | 226.923 | 1522.101 | 34 | 0.038 (0.038) | 1.627 (1.622) | 1.618 | - | 220: 1522.1, 35: 566.8, 60: 529.7, 87: 450.5, 139: 375.2 |
| 3 | quicksilver | yes | 14.602 | 199.474 | 1930.902 | 35 | 0.047 (0.045) | 1.295 (1.283) | 1.288 | - | 220: 1930.9, 128: 463.4, 87: 388.7, 103: 304.2, 139: 237.7 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 15.815 | 14.602 | 0.923 (0.86 to 1.04) |
| MSPT p99 | 226.821 | 203.738 | 0.898 (0.88 to 1.03) |
| slowest tick (ms) | 1792.333 | 1930.902 | 1.197 (0.87 to 1.27) |
| ticks over 50 ms | 34 | 29 | 0.967 (0.74 to 1.03) |
| chunk load, ms per tick (server thread) | 0.038 | 0.047 | 1.219 (0.97 to 1.32) |
|   of it in the tick | 0.038 | 0.045 | 1.175 (0.97 to 1.47) |
| chunk save, ms per tick (server thread) | 1.627 | 1.295 | 0.796 (0.65 to 0.99) |
|   of it in the tick | 1.622 | 1.283 | 0.791 (0.65 to 0.99) |
| autosave, ms per tick | 1.618 | 1.288 | 0.796 (0.65 to 0.99) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 8829 ms, 31590 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 725 / 56 | 6 / 0 | 1.312 | 1383.9 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 3 / 0 | 0 / 0 | 0.005 | 0.0 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 6 / 0 | 0 / 0 | 0.010 | 42.3 |
| chunk to full (promote) | 23 / 0 | 2 / 0 | 0.042 | 1.1 |
| entity load | 1 / 0 | 2 / 0 | 0.005 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 14 / 0 | 0 / 0 | 0.023 | 1.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 26.5 |
| chunk system (tickets, holders, tasks) | 315 / 119 | 6 / 0 | 0.733 | 442.6 |
| tick, other | 169 / 2 | 0 / 0 | 0.285 | 13.0 |
| idle or other | 0 / 0 | 14 / 0 | 0.023 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1269, MinecraftServer.lambda$spin$0 1268, Thread.run 1266, MinecraftServer.tickServer 1262, DedicatedServer.tickServer 1261, MinecraftServer.processPacketsAndTick 1261, Harness.startTick 1061, CiChunks.startTick 1061, ServerTickEvents.lambda$static$1 1060, MinecraftServer.saveEverything 787, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 787, ContextChain.runExecutable 787, ContextChain.executeAll 787, ContextChain.runExecutable$mixinextras$wrapped$10 787, SaveAllCommand.lambda$register$0 787, SaveAllCommand.saveAll 787, Harness.command 786, CommandDispatcher.execute 786, DedicatedServer.saveAllChunks 776, MinecraftServer.saveAllChunks 776, ServerLevel.save 708, ServerChunkCache.save 654, ChunkMap.saveAllChunks 654, ChunkMap.saveChunkIfNeeded 649, ChunkMap.save 641, SerializableChunkData.copyOf 624, LevelChunkSection.copy 346, PalettedContainer.copy 344, LevelChunkSection.<init> 344, PalettedContainer.<init> 304, PalettedContainer$Data.copy 294, Level.getChunk 267, ServerChunkCache.getChunk 267, LevelReader.getChunk 266, Level.getBlockState 266, Level.setBlock 231, LevelWriter.setBlock 231, CollectingNeighborUpdater$ShapeUpdate.runNext 219, CollectingNeighborUpdater.addAndRun 219, Level.neighborShapeChanged 219, CollectingNeighborUpdater.runUpdates 219, CollectingNeighborUpdater.shapeUpdate 219, BlockBehaviour$BlockStateBase.updateNeighbourShapes 219, NeighborUpdater.executeShapeUpdate 219, MinecraftServer.tickChildren 205, ServerLevel.tick 205, ServerChunkCache.tick 200, ServerChunkCache.runDistanceManagerUpdates 192, DistanceManager.runAllUpdates 180, BlockableEventLoop.managedBlock 137, DynamicGraphMinFixedPoint.runUpdates 130, LoadingChunkTracker.runDistanceUpdates 129, BlockableEventLoop.waitForTasks 119, Thread.yield0 119, Thread.yield 119, DynamicGraphMinFixedPoint.checkNeighbor 101, ChunkTracker.checkNeighborsAfterUpdate 101, DynamicGraphMinFixedPoint.checkEdge 93, LayerLightSectionStorage.getDataLayerData 85, LightEngine.getDataLayerData 85

Top chunk methods (self): PalettedContainer$Data.copy 279, Thread.yield0 119, Long2ObjectOpenHashMap.get 75, LongOpenHashSet.contains 61, ServerChunkCache.getChunk 49, PalettedContainer.copy 40, Long2ObjectLinkedOpenHashMap.get 38, UnixFileDispatcherImpl.write0 28, SerializableChunkData.copyOf 22, Collections$UnmodifiableCollection$1.hasNext 21, TimSort.binarySort 17, TimSort.countRunAndMakeAscending 13, Object.clone 12, HashMap.putVal 10, ChunkMap.onLevelChange 10, LayerLightSectionStorage.getDataLayerData 10, PalettedContainer.<init> 10, DynamicGraphMinFixedPoint.checkEdge 9, LongLinkedOpenHashSet.rehash 8, ConcurrentLinkedQueue.offer 8, Long2ByteOpenHashMap.get 7, TicketStorage.removeTicketIf 7, LongLinkedOpenHashSet.add 7, ForkJoinPool$WorkQueue.growArray 7, Long2ObjectOpenHashMap.getOrDefault 6, HashMapPalette.copy 6, ConcurrentLinkedQueue.size 6, UnixNativeDispatcher.rename0 6, ReferencePipeline$3$1.accept 6, TicketStorage.addTicket 6

Threads (all samples in the window): Worker-Main 5673, Netty Epoll IO  5534, Server thread 1463, IO-Worker 645, JFR Periodic Tasks 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 9154 ms, 32607 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 650 / 122 | 7 / 0 | 1.298 | 1009.2 |
| chunk save | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| entity save | 2 / 0 | 0 / 0 | 0.003 | 0.8 |
| POI save | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| chunk load | 9 / 0 | 0 / 0 | 0.015 | 18.0 |
| chunk to full (promote) | 18 / 0 | 1 / 0 | 0.032 | 11.9 |
| entity load | 2 / 0 | 3 / 0 | 0.008 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 18 / 0 | 0 / 0 | 0.030 | 1.7 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.4 |
| chunk system (tickets, holders, tasks) | 323 / 68 | 5 / 0 | 0.660 | 196.7 |
| tick, other | 193 / 7 | 0 / 0 | 0.333 | 165.1 |
| idle or other | 0 / 0 | 11 / 0 | 0.018 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1222, MinecraftServer.lambda$spin$0 1220, MinecraftServer.tickServer 1214, DedicatedServer.tickServer 1214, MinecraftServer.processPacketsAndTick 1214, Thread.run 1214, CiChunks.startTick 989, Harness.startTick 989, ServerTickEvents.lambda$static$1 988, ContextChain.executeAll 779, MinecraftServer.saveEverything 779, ContextChain.runExecutable 779, Harness.command 779, ContextChain.runExecutable$mixinextras$wrapped$10 779, SaveAllCommand.lambda$register$0 779, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 779, CommandDispatcher.execute 779, SaveAllCommand.saveAll 779, DedicatedServer.saveAllChunks 774, MinecraftServer.saveAllChunks 773, ServerLevel.save 628, ChunkMap.saveAllChunks 560, ServerChunkCache.save 560, ChunkMap.saveChunkIfNeeded 554, ChunkMap.save 544, SerializableChunkData.copyOf 530, MinecraftServer.tickChildren 231, ServerLevel.tick 231, ServerChunkCache.tick 220, ServerChunkCache.getChunk 202, LevelReader.getChunk 202, Level.getBlockState 202, Level.getChunk 202, LevelChunkSection.copy 198, LevelChunkSection.<init> 197, ServerChunkCache.runDistanceManagerUpdates 173, DistanceManager.runAllUpdates 169, Level.setBlock 146, LevelWriter.setBlock 146, LevelStorageSource$LevelStorageAccess.saveDataTag 137, CollectingNeighborUpdater$ShapeUpdate.runNext 135, NeighborUpdater.executeShapeUpdate 135, CollectingNeighborUpdater.runUpdates 134, CollectingNeighborUpdater.shapeUpdate 134, Level.neighborShapeChanged 134, BlockBehaviour$BlockStateBase.updateNeighbourShapes 134, CollectingNeighborUpdater.addAndRun 134, LoadingChunkTracker.runDistanceUpdates 131, DynamicGraphMinFixedPoint.runUpdates 131, LevelStorageSource$LevelStorageAccess.saveLevelData 129, ChunkTracker.checkNeighborsAfterUpdate 110, DynamicGraphMinFixedPoint.checkNeighbor 106, LayerLightSectionStorage.getDataLayerData 106, LightEngine.getDataLayerData 106, NbtIo.writeCompressed 105, FilterOutputStream.close 96, BufferedOutputStream.flush 95, ChannelOutputStream.write 95, FileChannelImpl.traceImplWrite 95, BufferedOutputStream.flushBuffer 95

Top chunk methods (self): LevelChunkSection.<init> 111, UnixFileDispatcherImpl.write0 94, Long2ObjectLinkedOpenHashMap.get 86, PalettedContainer.create$quicksilver_$md$a06ebc$0 86, Long2ObjectOpenHashMap.get 73, Thread.yield0 65, ServerChunkCache.getChunk 49, LayerLightSectionStorage.getDataLayerData 31, Comparator.lambda$comparingLong$6043328a$1 29, SerializableChunkData.copyOf 26, LongOpenHashSet.contains 15, UnixNativeDispatcher.unlink0 11, ConcurrentLinkedQueue.size 11, DataLayer.<init> 11, Arrays.copyOf 11, ArrayList.grow 11, HashMap.putVal 10, DynamicGraphMinFixedPoint.checkNeighbor 9, ConcurrentLinkedQueue.offer 9, ChunkMap.onLevelChange 9, CompletableFuture.join 8, Heightmap.getRawData 8, ShortArrayList.copyArrayFromSafe 8, LongLinkedOpenHashSet.rehash 7, Long2ObjectOpenHashMap$MapIterator.nextEntry 7, Deflater.init 7, DynamicGraphMinFixedPoint.checkEdge 6, LevelChunkTicks.pack 6, LongLinkedOpenHashSet.add 6, ChunkMap.saveChunkIfNeeded 6

Threads (all samples in the window): Worker-Main 5971, Netty Epoll IO  5646, Server thread 1441, IO-Worker 790, JFR Periodic Tasks 1

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2809: DedicatedServer.saveAllChunks 2790, MinecraftServer.warnOnLowDiskSpace 19<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2789, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 19
- **ServerLevel.save** 2316: ServerChunkCache.save 2156, PersistentEntitySectionManager.autoSave 124, ServerLevel.saveLevelData 36<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 2155, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 114, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 36, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 9, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkMethodHandleConstant 1
- **ChunkMap.saveAllChunks** 2155: ChunkMap.saveChunkIfNeeded 2134, Long2ObjectLinkedOpenHashMap$ValueIterator.next 10<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 2093, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 24, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 9, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 2, ChunkMap.saveChunkIfNeeded > ChunkHolder.isReadyForSaving 1
- **ChunkMap.save** 2093: SerializableChunkData.copyOf 2046, CompletableFuture.supplyAsync 24, SimpleRegionStorage.write 10, ChunkMap.markPosition 8<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 1097, SerializableChunkData.copyOf > LightEngine.getDataLayerData 284, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 132, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 121, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 115, SerializableChunkData.copyOf > ReferencePipeline.toArray 55, SerializableChunkData.copyOf > DataLayer.copy 41, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 28, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 26, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 23, SimpleRegionStorage.write > IOWorker.store 10, SerializableChunkData.copyOf > Heightmap.getRawData 9
- **SerializableChunkData.copyOf** 2046: LevelChunkSection.copy 1097, LightEngine.getDataLayerData 284, LevelChunk.getTicksForSerialization 132, SerializableChunkData.packStructureData 121, LevelChunk.getBlockEntityNbtForSaving 115, ReferencePipeline.toArray 55, DataLayer.copy 41, ChunkAccess.getBlockEntitiesPos 28, Collections$UnmodifiableCollection$1.hasNext 26, Heightmap.getRawData 9, ArrayList.add 5, LevelHeightAccessor.getMinSectionY 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 1092, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 284, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 129, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 108, SerializableChunkData.packStructureData > StructureStart.createTag 74, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 55, DataLayer.copy > DataLayer.<init> 37, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 16, SerializableChunkData.packStructureData > CompoundTag.put 12, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 11, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 8, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 6
- **DistanceManager.runAllUpdates** 563: LoadingChunkTracker.runDistanceUpdates 429, ChunkHolder.updateFutures 99, ReferenceOpenHashSet.clear 8, ReferenceOpenHashSet$SetIterator.next 4, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 3, GenerationChunkHolder.updateHighestAllowedStatus 3, ReferenceOpenHashSet.iterator 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 429, ChunkHolder.updateFutures > ChunkMap.onLevelChange 56, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 30, ReferenceOpenHashSet.clear > Arrays.fill 8, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 6, ChunkHolder.updateFutures > CompletableFuture.complete 2, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 2, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 2, ReferenceOpenHashSet.iterator > ReferenceOpenHashSet.iterator 1
- **PersistentEntitySectionManager.autoSave** 124: AbstractLongCollection.forEach 114, PersistentEntitySectionManager.getAllChunksToSave 9, MethodHandleNatives.linkMethodHandleConstant 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 114, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 3, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 2, MethodHandleNatives.linkMethodHandleConstant > MethodHandles$Lookup.linkMethodHandleConstant 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps$1.iterator 1
- **ChunkMap.processUnloads** 47: ConcurrentLinkedQueue.size 28, CompletableFuture$Completion.run 11, ChunkMap.scheduleUnload 6, LongOpenHashSet$SetIterator.remove 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 11, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 3, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 1
- **LevelChunk.runPostLoad** 24: SerializableChunkData.lambda$postLoadChunk$0 24<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 23
- **SerializableChunkData.read** 10: PoiManager.checkConsistencyWithBlocks 5, LevelChunk.<init> 1, LevelChunkTicks.<init> 1, SerializableChunkData.unpackStructureStart 1, ChunkAccess.setHeightmap 1, ThreadedLevelLightEngine.retainData 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 5, LevelChunk.<init> > ChunkAccess.<init> 1, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.<init> 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, ChunkAccess.setHeightmap > Heightmap.setRawData 1, ThreadedLevelLightEngine.retainData > Util.name 1
- **LevelChunk.<init>** 1: ChunkAccess.<init> 1<br>two down: ChunkAccess.<init> > Maps.newEnumMap 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2238: DedicatedServer.saveAllChunks 2215, MinecraftServer.warnOnLowDiskSpace 21<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2212, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 20, DedicatedServer.saveAllChunks > NotificationManager.serverSaveStarted 1, DedicatedServer.saveAllChunks > MinecraftServer.notificationManager 1
- **ServerLevel.save** 1882: ServerChunkCache.save 1698, PersistentEntitySectionManager.autoSave 148, ServerLevel.saveLevelData 35<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1697, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 136, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 34, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 12
- **ChunkMap.saveAllChunks** 1697: ChunkMap.saveChunkIfNeeded 1677, Long2ObjectLinkedOpenHashMap$ValueIterator.next 3, Long2ObjectLinkedOpenHashMap$1.iterator 1, Long2ObjectLinkedOpenHashMap.values 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1640, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 11, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 3, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 2, Long2ObjectLinkedOpenHashMap$1.iterator > Long2ObjectLinkedOpenHashMap$ValueIterator.<init> 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 1640: SerializableChunkData.copyOf 1598, CompletableFuture.supplyAsync 17, SimpleRegionStorage.write 11, ChunkMap.markPosition 7, CompletableFuture.handle 3, Profiler.get 1, ProfilerFiller.incrementCounter 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 648, SerializableChunkData.copyOf > LightEngine.getDataLayerData 294, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 146, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 112, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 108, SerializableChunkData.copyOf > ReferencePipeline.toArray 55, SerializableChunkData.copyOf > DataLayer.copy 28, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 25, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 24, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 17, SerializableChunkData.copyOf > ArrayList.add 12, SimpleRegionStorage.write > IOWorker.store 11
- **SerializableChunkData.copyOf** 1598: LevelChunkSection.copy 648, LightEngine.getDataLayerData 294, LevelChunk.getTicksForSerialization 146, LevelChunk.getBlockEntityNbtForSaving 112, SerializableChunkData.packStructureData 108, ReferencePipeline.toArray 55, DataLayer.copy 28, ChunkAccess.getBlockEntitiesPos 25, Collections$UnmodifiableCollection$1.hasNext 24, ArrayList.add 12, Heightmap.getRawData 10, DataLayer.isEmpty 6<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 645, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 294, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 141, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 107, SerializableChunkData.packStructureData > StructureStart.createTag 68, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 55, DataLayer.copy > DataLayer.<init> 25, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 13, ArrayList.add > ArrayList.add 12, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 11, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 5, SerializableChunkData.packStructureData > MappedRegistry.getKey 5
- **DistanceManager.runAllUpdates** 515: LoadingChunkTracker.runDistanceUpdates 393, ChunkHolder.updateFutures 91, ReferenceOpenHashSet$SetIterator.next 10, ReferenceOpenHashSet.clear 9, GenerationChunkHolder.updateHighestAllowedStatus 4, ReferenceOpenHashSet.iterator 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 393, ChunkHolder.updateFutures > ChunkMap.onLevelChange 55, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 24, ReferenceOpenHashSet.clear > Arrays.fill 9, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 8, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 4, ReferenceOpenHashSet.iterator > ReferenceOpenHashSet.iterator 1, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 1
- **PersistentEntitySectionManager.autoSave** 148: AbstractLongCollection.forEach 136, PersistentEntitySectionManager.getAllChunksToSave 12<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 136, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 6, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 3, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 1
- **ChunkMap.processUnloads** 49: ConcurrentLinkedQueue.size 22, ChunkMap.scheduleUnload 11, CompletableFuture$Completion.run 7, LongOpenHashSet$SetIterator.remove 3, Long2ObjectLinkedOpenHashMap.remove 2, LongOpenHashSet$SetIterator.nextLong 2, ChunkMap.saveChunksEagerly 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 7, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 5, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, ChunkMap.saveChunksEagerly > Util.getMillis 1, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 1, LongOpenHashSet$SetIterator.nextLong > LongArrayList.getLong 1, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1
- **SerializableChunkData.read** 20: PoiManager.checkConsistencyWithBlocks 11, LevelChunk.<init> 2, SerializableChunkData.unpackStructureReferences 2, SerializableChunkData.unpackStructureStart 1, ProtoChunkTicks.load 1, LevelChunkTicks.<init> 1, ImposterProtoChunk.<init> 1, LevelHeightAccessor.getSectionsCount 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 10, LevelChunk.<init> > ChunkAccess.<init> 2, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 2, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, ProtoChunkTicks.load > ProtoChunkTicks.<init> 1, ImposterProtoChunk.<init> > ProtoChunk.<init> 1, LevelHeightAccessor.getSectionsCount > LevelHeightAccessor.getMinSectionY 1
- **LevelChunk.runPostLoad** 18: SerializableChunkData.lambda$postLoadChunk$0 18<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 17
- **LevelChunk.<init>** 2: ChunkAccess.<init> 2<br>two down: ChunkAccess.<init> > ChunkAccess.replaceMissingSections 1, ChunkAccess.<init> > ChunkSkyLightSources.<init> 1
- **ChunkMap.saveChunksEagerly** 1: Util.getMillis 1<br>two down: Util.getMillis > Util.getNanos 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 357 | 12936 | 12922 | 0 | 14 | 0 |
| 1 | quicksilver | 357 | 13224 | 13224 | 0 | 0 | 0 |
| 2 | vanilla | 357 | 15084 | 14154 | 0 | 930 | 0 |
| 2 | quicksilver | 357 | 13224 | 13221 | 0 | 3 | 0 |
| 3 | vanilla | 357 | 13818 | 13787 | 0 | 31 | 0 |
| 3 | quicksilver | 357 | 13482 | 13472 | 0 | 10 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-3 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 2 / 7 | 1 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 231 / 357 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 7 | 1 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 250 / 357 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 2 / 7 | 1 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 253 / 357 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 7 | 1 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 1 (0) | 0 (0) | LastUpdate 1 | 281 / 357 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 7 | 1 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 248 / 357 | 0 |

Vanilla's noise (rounds 2-3 against 1): dimensions/minecraft/overworld/entities: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1 data, 0 bytes only, 0 one side, keys LastUpdate 1

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 1.743 | 7.998 | 26.672 | 0 | 0.177 (0.080) | 0.353 (0.353) | 0.000 | - | 0: 26.7, 8: 25.2, 40: 21.1, 226: 16.4, 848: 12.5 |
| 1 | quicksilver | yes | 1.731 | 9.143 | 28.540 | 0 | 0.179 (0.085) | 0.357 (0.357) | 0.000 | - | 8: 28.5, 24: 24.7, 40: 17.2, 0: 16.8, 219: 15.5 |
| 2 | vanilla | yes | 1.671 | 7.244 | 27.199 | 0 | 0.169 (0.082) | 0.361 (0.361) | 0.000 | - | 0: 27.2, 40: 23.9, 8: 21.6, 216: 16.5, 24: 14.2 |
| 2 | quicksilver | yes | 1.726 | 8.335 | 27.031 | 0 | 0.174 (0.083) | 0.340 (0.340) | 0.000 | - | 8: 27.0, 0: 21.0, 840: 17.9, 40: 15.1, 954: 13.8 |
| 3 | vanilla | yes | 1.658 | 7.055 | 35.982 | 0 | 0.169 (0.067) | 0.358 (0.358) | 0.000 | - | 40: 36.0, 0: 20.1, 8: 18.6, 16: 13.1, 645: 12.5 |
| 3 | quicksilver | yes | 1.599 | 7.980 | 22.917 | 0 | 0.171 (0.079) | 0.314 (0.314) | 0.000 | - | 8: 22.9, 0: 21.4, 58: 17.1, 24: 16.3, 40: 16.1 |
| 4 | vanilla | yes | 1.664 | 7.630 | 22.817 | 0 | 0.177 (0.084) | 0.347 (0.347) | 0.000 | - | 8: 22.8, 952: 19.5, 211: 19.3, 0: 18.8, 144: 17.9 |
| 4 | quicksilver | yes | 1.588 | 8.246 | 21.170 | 0 | 0.170 (0.076) | 0.326 (0.326) | 0.000 | - | 8: 21.2, 0: 16.2, 40: 14.7, 1112: 14.5, 1000: 14.2 |
| 5 | vanilla | yes | 1.666 | 8.087 | 18.834 | 0 | 0.178 (0.089) | 0.350 (0.350) | 0.000 | - | 0: 18.8, 8: 18.8, 568: 15.9, 40: 14.5, 24: 12.0 |
| 5 | quicksilver | yes | 1.624 | 8.333 | 24.876 | 0 | 0.158 (0.077) | 0.323 (0.323) | 0.000 | - | 8: 24.9, 96: 22.6, 0: 18.6, 728: 17.4, 450: 16.3 |
| 6 | vanilla | yes | 1.661 | 8.352 | 22.769 | 0 | 0.173 (0.079) | 0.336 (0.336) | 0.000 | - | 0: 22.8, 8: 22.6, 640: 15.8, 864: 14.6, 40: 14.3 |
| 6 | quicksilver | yes | 1.632 | 8.369 | 19.462 | 0 | 0.168 (0.083) | 0.312 (0.312) | 0.000 | - | 8: 19.5, 40: 16.7, 0: 16.7, 24: 9.8, 474: 9.8 |
| 7 | vanilla | yes | 1.671 | 8.103 | 21.459 | 0 | 0.158 (0.071) | 0.334 (0.334) | 0.000 | - | 0: 21.5, 8: 18.8, 24: 17.5, 193: 15.9, 16: 15.7 |
| 7 | quicksilver | yes | 1.569 | 7.587 | 23.268 | 0 | 0.177 (0.081) | 0.291 (0.291) | 0.000 | - | 8: 23.3, 40: 16.8, 0: 16.7, 115: 14.7, 24: 13.2 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 1.666 | 1.624 | 0.975 (0.94 to 1.03) |
| MSPT p99 | 7.998 | 8.333 | 1.081 (0.94 to 1.15) |
| slowest tick (ms) | 22.817 | 23.268 | 0.994 (0.64 to 1.32) |
| ticks over 50 ms | 0 | 0 | - (- to -) |
| chunk load, ms per tick (server thread) | 0.173 | 0.171 | 1.009 (0.89 to 1.12) |
|   of it in the tick | 0.080 | 0.081 | 1.052 (0.87 to 1.19) |
| chunk save, ms per tick (server thread) | 0.350 | 0.323 | 0.928 (0.87 to 1.01) |
|   of it in the tick | 0.350 | 0.323 | 0.928 (0.87 to 1.01) |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 59784 ms, 21301 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 386 / 0 | 0 / 0 | 0.322 | 429.9 |
| entity save | 29 / 0 | 0 / 0 | 0.024 | 5.3 |
| POI save | 9 / 0 | 0 / 0 | 0.007 | 0.0 |
| chunk load | 0 / 0 | 48 / 3 | 0.043 | 54.1 |
| chunk to full (promote) | 87 / 0 | 58 / 0 | 0.121 | 33.7 |
| entity load | 9 / 0 | 7 / 0 | 0.013 | 2.1 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 15 / 0 | 0 / 0 | 0.013 | 7.0 |
| light | 0 / 0 | 1 / 0 | 0.001 | 0.0 |
| chunk system (tickets, holders, tasks) | 429 / 1 | 220 / 0 | 0.542 | 204.7 |
| tick, other | 539 / 3 | 0 / 0 | 0.452 | 1.4 |
| idle or other | 0 / 0 | 75 / 0 | 0.062 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1297, MinecraftServer.lambda$spin$0 1297, Thread.run 1295, MinecraftServer.processPacketsAndTick 965, DedicatedServer.tickServer 965, MinecraftServer.tickServer 965, ServerLevel.tick 957, MinecraftServer.tickChildren 957, ServerChunkCache.tick 896, ChunkMap.tick 426, ChunkMap.processUnloads 402, ChunkMap.saveChunksEagerly 370, ServerChunkCache.runDistanceManagerUpdates 365, DistanceManager.runAllUpdates 360, ServerChunkCache$MainThreadExecutor.pollTask 335, MinecraftServer.pollTask 334, MinecraftServer.pollTaskInternal 334, ServerChunkCache.pollTask 334, MinecraftServer.waitUntilNextTick 334, BlockableEventLoop.pollTask 325, BlockableEventLoop.managedBlock 325, BlockableEventLoop.doRunTask 324, ServerChunkCache$MainThreadExecutor.doRunTask 323, CompletableFuture$Completion.run 283, CompletableFuture$UniApply.tryFire 259, ChunkMap.saveChunkIfNeeded 255, DynamicGraphMinFixedPoint.runUpdates 232, LoadingChunkTracker.runDistanceUpdates 231, ChunkMap.save 219, SerializableChunkData.copyOf 218, ChunkTracker.checkNeighborsAfterUpdate 196, ChunkResult$Success.map 196, ChunkMap.lambda$prepareTickingChunk$1 195, ChunkMap.lambda$prepareTickingChunk$2 195, DynamicGraphMinFixedPoint.checkNeighbor 194, LevelChunk.postProcessGeneration 185, Long2ObjectLinkedOpenHashMap.get 164, DynamicGraphMinFixedPoint.checkEdge 144, ChunkHolder.updateFutures 116, GenerationChunkHolder.getChunkIfPresentUnchecked 115, Block.updateFromNeighbourShapes 113, GenerationChunkHolder.getLatestChunk 111, LoadingChunkTracker.getLevel 104, ChunkTracker.getComputedLevel 96, ServerChunkCache.tickChunks 92, ChunkMap.getUpdatingChunkIfPresent 84, ChunkMap$DistanceManager.getChunk 83, Level.getBlockState 82, PalettedContainer.get 82, LevelChunkSection.getBlockState 71, LevelChunk.getBlockState 71, ChunkMap.getChunkRangeFuture 68, LevelChunkSection.<init> 62, LevelChunkSection.copy 62, NaturalSpawner.createState 61, PalettedContainer.copy 61, GenerationChunkHolder.scheduleChunkGenerationTask 60, GenerationChunkHolder.rescheduleChunkTask 59, StaticCache2D.create 59, StaticCache2D.<init> 59

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 164, GenerationChunkHolder.getChunkIfPresentUnchecked 107, PalettedContainer.get 74, PalettedContainer$Data.copy 49, Long2ByteOpenHashMap.get 39, Long2ObjectOpenHashMap.get 35, ChunkTracker.getComputedLevel 26, DynamicGraphMinFixedPoint.checkEdge 25, LongOpenHashSet.contains 23, Long2LongOpenHashMap.getOrDefault 16, ServerChunkCache.getChunk 13, ConcurrentLinkedQueue.offer 13, NaturalSpawner.createState 12, ChunkMap.saveChunksEagerly 12, LongLinkedOpenHashSet.add 11, StateHolder.getNullableValue 10, SerializableChunkData.copyOf 10, PalettedContainer.copy 10, ChunkMap.onLevelChange 9, StateHolder.valueIndex 8, VarHandleReferences$Array.getVolatile 8, BlockBehaviour$BlockStateBase.updateShape 8, LongLinkedOpenHashSet.rehash 8, TicketStorage.removeTicketIf 7, DirectMethodHandle.allocateInstance 7, Reference2ObjectOpenHashMap.get 7, ReferenceOpenHashSet.add 6, FastBufferedInputStream.read 6, CrudeIncrementalIntIdentityHashBiMap.byId 6, TypedInstance.is 6

Threads (all samples in the window): Netty Epoll IO  46719, IO-Worker 9895, Worker-Main 4333, Server thread 1919, JFR Periodic Tasks 8

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 59827 ms, 20070 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 402 / 0 | 0 / 0 | 0.335 | 230.8 |
| entity save | 23 / 0 | 0 / 0 | 0.019 | 6.1 |
| POI save | 4 / 0 | 0 / 0 | 0.003 | 0.3 |
| chunk load | 0 / 0 | 56 / 3 | 0.049 | 71.2 |
| chunk to full (promote) | 94 / 0 | 52 / 0 | 0.122 | 50.9 |
| entity load | 8 / 0 | 2 / 0 | 0.008 | 1.5 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 11 / 0 | 0 / 0 | 0.009 | 15.0 |
| light | 0 / 0 | 3 / 0 | 0.003 | 0.0 |
| chunk system (tickets, holders, tasks) | 409 / 0 | 217 / 0 | 0.522 | 214.4 |
| tick, other | 556 / 0 | 0 / 0 | 0.463 | 1.2 |
| idle or other | 0 / 0 | 81 / 0 | 0.068 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1279, MinecraftServer.lambda$spin$0 1278, Thread.run 1274, MinecraftServer.tickServer 951, DedicatedServer.tickServer 951, MinecraftServer.processPacketsAndTick 951, ServerLevel.tick 942, MinecraftServer.tickChildren 942, ServerChunkCache.tick 889, ChunkMap.tick 432, ChunkMap.processUnloads 414, ChunkMap.saveChunksEagerly 384, ServerChunkCache.runDistanceManagerUpdates 375, DistanceManager.runAllUpdates 367, ServerChunkCache$MainThreadExecutor.pollTask 330, MinecraftServer.pollTask 330, MinecraftServer.pollTaskInternal 330, ServerChunkCache.pollTask 330, MinecraftServer.waitUntilNextTick 329, BlockableEventLoop.pollTask 318, BlockableEventLoop.managedBlock 314, BlockableEventLoop.doRunTask 310, ServerChunkCache$MainThreadExecutor.doRunTask 309, CompletableFuture$Completion.run 276, CompletableFuture$UniApply.tryFire 254, ChunkMap.saveChunkIfNeeded 245, LoadingChunkTracker.runDistanceUpdates 224, DynamicGraphMinFixedPoint.runUpdates 223, ChunkMap.save 211, SerializableChunkData.copyOf 208, ChunkTracker.checkNeighborsAfterUpdate 182, ChunkResult$Success.map 181, ChunkMap.lambda$prepareTickingChunk$1 180, ChunkMap.lambda$prepareTickingChunk$2 179, DynamicGraphMinFixedPoint.checkNeighbor 178, LevelChunk.postProcessGeneration 166, GenerationChunkHolder.getChunkIfPresentUnchecked 133, DynamicGraphMinFixedPoint.checkEdge 131, GenerationChunkHolder.getLatestChunk 126, ChunkHolder.updateFutures 125, Block.updateFromNeighbourShapes 102, Long2ObjectLinkedOpenHashMap.get 92, ChunkTracker.getComputedLevel 88, LoadingChunkTracker.getLevel 83, ChunkMap.getChunkRangeFuture 82, ServerChunkCache.tickChunks 78, PalettedContainer.get 66, ChunkMap$DistanceManager.isChunkToRemove 64, GenerationChunkHolder.rescheduleChunkTask 64, GenerationChunkHolder.scheduleChunkGenerationTask 64, LongOpenHashSet.contains 63, ChunkMap.scheduleGenerationTask 63, ChunkMap.acquireGeneration 61, ChunkGenerationTask.lambda$create$0 61, StaticCache2D.<init> 61, StaticCache2D.create 61, ChunkGenerationTask.create 61, ChunkMap.lambda$scheduleChunkLoad$3 60, LightEngine.getDataLayerData 60, SerializableChunkData.read 59

Top chunk methods (self): GenerationChunkHolder.getChunkIfPresentUnchecked 118, Long2ObjectLinkedOpenHashMap.get 92, LongOpenHashSet.contains 63, PalettedContainer.get 63, Long2ObjectOpenHashMap.get 40, Long2ByteOpenHashMap.get 35, ChunkTracker.getComputedLevel 32, DynamicGraphMinFixedPoint.checkEdge 27, PalettedContainer.copy 21, Long2LongOpenHashMap.getOrDefault 20, Long2ObjectFunctions$SynchronizedFunction.get 18, PalettedContainer.create$quicksilver_$md$35dc8b$0 17, VarHandleReferences$Array.getVolatile 15, ConcurrentLinkedQueue.offer 13, ChunkMap.saveChunksEagerly 13, Long2ObjectOpenHashMap.getOrDefault 13, HashMap.getNode 12, ServerChunkCache.getChunk 11, ConcurrentLinkedQueue.poll 11, StateHolder.valueIndex 10, ServerChunkCache.tickChunks 10, CompletableFuture.postComplete 10, ChunkMap.saveChunkIfNeeded 9, LongLinkedOpenHashSet.add 8, StateHolder.getNullableValue 8, GenerationChunkHolder.increaseGenerationRefCount 8, BlockBehaviour$BlockStateBase.updateShape 8, LongLinkedOpenHashSet$SetIterator.nextLong 8, ReferenceOpenHashSet.add 8, DistanceManager.runAllUpdates 7

Threads (all samples in the window): Netty Epoll IO  49034, IO-Worker 7666, Worker-Main 4231, Server thread 1921, JFR Periodic Tasks 4

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **ChunkMap.processUnloads** 2821: ChunkMap.saveChunksEagerly 2591, CompletableFuture$Completion.run 189, ChunkMap.scheduleUnload 9, Long2ObjectLinkedOpenHashMap.remove 5, ConcurrentLinkedQueue.poll 4, LongOpenHashSet.iterator 4, ConcurrentLinkedQueue.size 3, Long2ObjectLinkedOpenHashMap.put 2, Long2ObjectLinkedOpenHashMap.get 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1789, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 514, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 189, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 102, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 38, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 5, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 5, ChunkMap.saveChunksEagerly > Util.getMillis 3, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 2, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 2591: ChunkMap.saveChunkIfNeeded 1789, GenerationChunkHolder.getLatestChunk 514, Long2ObjectLinkedOpenHashMap.get 102, LongLinkedOpenHashSet$SetIterator.nextLong 38, Util.getMillis 3, LongLinkedOpenHashSet$SetIterator.remove 1, LongLinkedOpenHashSet.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1455, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 463, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 152, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 150, Util.getMillis > Util.getNanos 3, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1
- **DistanceManager.runAllUpdates** 2578: LoadingChunkTracker.runDistanceUpdates 1601, ChunkHolder.updateFutures 828, GenerationChunkHolder.updateHighestAllowedStatus 47, ReferenceOpenHashSet$SetIterator.next 12, ReferenceOpenHashSet.clear 11, DistanceManager$PlayerTicketTracker.runAllUpdates 5, SimulationChunkTracker.runAllUpdates 4, ReferenceOpenHashSet.iterator 4, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1599, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 244, ChunkHolder.updateFutures > ChunkMap.onLevelChange 159, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 147, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 120, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 101, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 27, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 22, ReferenceOpenHashSet.clear > Arrays.fill 10, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 8, ChunkHolder.updateFutures > CompletableFuture.complete 6, SimulationChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 4
- **ChunkMap.save** 1594: SerializableChunkData.copyOf 1564, CompletableFuture.supplyAsync 6, SimpleRegionStorage.write 5, CompletableFuture.handle 4, ChunkMap.markPosition 4, SectionStorage.flush 2, DirectMethodHandle.allocateInstance 1, Profiler.get 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 446, SerializableChunkData.copyOf > LightEngine.getDataLayerData 340, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 316, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 168, SerializableChunkData.copyOf > ReferencePipeline.toArray 65, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 57, SerializableChunkData.copyOf > DataLayer.copy 31, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 27, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 9, SerializableChunkData.copyOf > ArrayList.add 9, SerializableChunkData.copyOf > Heightmap.getRawData 8, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 7
- **SerializableChunkData.copyOf** 1564: LevelChunkSection.copy 446, LightEngine.getDataLayerData 340, LevelChunk.getBlockEntityNbtForSaving 316, SerializableChunkData.packStructureData 168, ReferencePipeline.toArray 65, LevelChunk.getTicksForSerialization 57, DataLayer.copy 31, ChunkAccess.getBlockEntitiesPos 27, LevelLightEngine.getMaxLightSection 9, Heightmap.getRawData 8, ArrayList.add 8, Collections$UnmodifiableCollection$1.hasNext 6<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 437, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 336, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 309, SerializableChunkData.packStructureData > StructureStart.createTag 112, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 65, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 52, DataLayer.copy > DataLayer.<init> 20, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 15, SerializableChunkData.packStructureData > CompoundTag.put 12, ArrayList.add > ArrayList.add 9, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 8, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 7
- **LevelChunk.postProcessGeneration** 1236: Block.updateFromNeighbourShapes 723, FluidState.tick 195, BlockBehaviour$BlockStateBase.tick 155, LevelChunk.getBlockState 78, FluidState.isEmpty 23, LevelWriter.setBlock 12, LevelHeightAccessor.getSectionYFromSectionIndex 8, ImmutableList.copyOf 5, UpgradeData.upgrade 5, ShortListIterator.next 4, AbstractShortList.iterator 2, BlockBehaviour$BlockStateBase.getBlock 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 391, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 297, FluidState.tick > FlowingFluid.tick 194, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 153, LevelChunk.getBlockState > LevelChunkSection.getBlockState 77, LevelWriter.setBlock > Level.setBlock 12, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 8, ShortListIterator.next > ShortListIterator.next 4, AbstractShortList.iterator > AbstractShortList.listIterator 2, UpgradeData.upgrade > Iterable.forEach 2, ImmutableList.copyOf > HashMap$KeySet.toArray 1, LevelChunk.getBlockState > LevelHeightAccessor.getSectionIndex 1
- **SerializableChunkData.read** 366: SerializableChunkData.unpackStructureStart 229, LevelChunkTicks.<init> 38, PoiManager.checkConsistencyWithBlocks 37, SerializableChunkData.unpackStructureReferences 20, ImposterProtoChunk.<init> 17, ChunkAccess.setHeightmap 4, LevelChunk.<init> 3, ChunkAccess.addPackedPostProcess 2, ChunkAccess.setAllReferences 2, CompoundTag.put 1, ChunkAccess.setLightCorrect 1, ChunkAccess.setAllStarts 1<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 221, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 38, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 19, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 18, PoiManager.checkConsistencyWithBlocks > Util.ifElse 18, ImposterProtoChunk.<init> > ProtoChunk.<init> 16, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 4, LevelChunk.<init> > ChunkAccess.<init> 3, SerializableChunkData.unpackStructureStart > CompoundTag.getCompoundOrEmpty 2, SerializableChunkData.unpackStructureReferences > DirectMethodHandle.allocateInstance 2, SerializableChunkData.unpackStructureStart > RegistryAccess.lookupOrThrow 2, ChunkAccess.setLightCorrect > LevelChunk.markUnsaved 1
- **LevelChunk.runPostLoad** 242: SerializableChunkData.lambda$postLoadChunk$0 241<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 206, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 10, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 8, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 7, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 6
- **LevelChunk.<init>** 3: ChunkAccess.<init> 3<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 2, ChunkAccess.<init> > Maps.newEnumMap 1
- **SectionStorage.flush** 2: LongLinkedOpenHashSet.remove 2<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **ChunkMap.processUnloads** 2629: ChunkMap.saveChunksEagerly 2421, CompletableFuture$Completion.run 159, ChunkMap.scheduleUnload 13, ConcurrentLinkedQueue.size 5, ConcurrentLinkedQueue.poll 5, Long2ObjectLinkedOpenHashMap.put 4, LongOpenHashSet$SetIterator.remove 1, Long2ObjectLinkedOpenHashMap.get 1, MinecraftServer.haveTime 1, LongOpenHashSet.iterator 1, Long2ObjectLinkedOpenHashMap.remove 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1610, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 528, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 159, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 106, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 41, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 4, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 4, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 3, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 2, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 2
- **DistanceManager.runAllUpdates** 2519: LoadingChunkTracker.runDistanceUpdates 1563, ChunkHolder.updateFutures 813, GenerationChunkHolder.updateHighestAllowedStatus 53, ReferenceOpenHashSet$SetIterator.next 10, ReferenceOpenHashSet.clear 6, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 5, DistanceManager$PlayerTicketTracker.runAllUpdates 2, ReferenceOpenHashSet.iterator 1, SimulationChunkTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1562, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 238, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 164, ChunkHolder.updateFutures > ChunkMap.onLevelChange 136, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 116, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 115, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 42, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 8, ReferenceOpenHashSet.clear > Arrays.fill 6, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 4, ChunkHolder.updateFutures > CompletableFuture.complete 4, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 4
- **ChunkMap.saveChunksEagerly** 2421: ChunkMap.saveChunkIfNeeded 1610, GenerationChunkHolder.getLatestChunk 528, Long2ObjectLinkedOpenHashMap.get 106, LongLinkedOpenHashSet$SetIterator.nextLong 41, LongLinkedOpenHashSet.iterator 2, Util.getMillis 2, MinecraftServer.haveTime 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1276, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 451, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 198, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 96, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 2, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2, Util.getMillis > Util.getNanos 2, MinecraftServer.haveTime > Util.getNanos 1, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 1
- **ChunkMap.save** 1392: SerializableChunkData.copyOf 1370, ChunkMap.markPosition 6, SimpleRegionStorage.write 6, DirectMethodHandle.allocateInstance 2, CompletableFuture.supplyAsync 2, ChunkAccess.tryMarkSaved 2, SectionStorage.flush 1, ProfilerFiller.incrementCounter 1, CompletableFuture.handle 1<br>two down: SerializableChunkData.copyOf > LightEngine.getDataLayerData 361, SerializableChunkData.copyOf > LevelChunkSection.copy 278, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 260, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 172, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 51, SerializableChunkData.copyOf > ReferencePipeline.toArray 42, SerializableChunkData.copyOf > DataLayer.copy 41, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 25, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 23, SerializableChunkData.copyOf > Heightmap.getRawData 9, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 7, SerializableChunkData.copyOf > ArrayList.add 7
- **SerializableChunkData.copyOf** 1370: LightEngine.getDataLayerData 361, LevelChunkSection.copy 278, LevelChunk.getBlockEntityNbtForSaving 260, SerializableChunkData.packStructureData 172, LevelChunk.getTicksForSerialization 51, ReferencePipeline.toArray 42, DataLayer.copy 41, ChunkAccess.getBlockEntitiesPos 25, Collections$UnmodifiableCollection$1.hasNext 23, Heightmap.getRawData 9, LevelLightEngine.getMaxLightSection 6, ArrayList.add 6<br>two down: LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 358, LevelChunkSection.copy > LevelChunkSection.<init> 274, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 254, SerializableChunkData.packStructureData > StructureStart.createTag 115, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 48, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 40, DataLayer.copy > DataLayer.<init> 26, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 13, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 10, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 9, SerializableChunkData.packStructureData > Identifier.toString 8, ArrayList.add > ArrayList.add 7
- **LevelChunk.postProcessGeneration** 1239: Block.updateFromNeighbourShapes 743, FluidState.tick 206, BlockBehaviour$BlockStateBase.tick 131, LevelChunk.getBlockState 67, FluidState.isEmpty 25, LevelWriter.setBlock 11, UpgradeData.upgrade 10, ImmutableList.copyOf 10, LevelHeightAccessor.getSectionYFromSectionIndex 6, ShortListIterator.next 3, ProtoChunk.unpackOffsetCoordinates 2<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 420, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 289, FluidState.tick > FlowingFluid.tick 205, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 131, LevelChunk.getBlockState > LevelChunkSection.getBlockState 67, LevelWriter.setBlock > Level.setBlock 11, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 6, UpgradeData.upgrade > UpgradeData.upgradeInside 5, UpgradeData.upgrade > Iterable.forEach 4, ShortListIterator.next > ShortListIterator.next 3
- **SerializableChunkData.read** 350: SerializableChunkData.unpackStructureStart 202, PoiManager.checkConsistencyWithBlocks 40, LevelChunkTicks.<init> 36, SerializableChunkData.unpackStructureReferences 24, ImposterProtoChunk.<init> 19, ChunkAccess.setHeightmap 5, LevelChunk.<init> 4, ChunkAccess.addPackedPostProcess 3, ChunkAccess.setAllStarts 2, ChunkAccess.setLightCorrect 2, SectionPos.of 2, ChunkAccess.setAllReferences 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 199, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 36, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 24, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 20, PoiManager.checkConsistencyWithBlocks > Util.ifElse 20, ImposterProtoChunk.<init> > ProtoChunk.<init> 18, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 4, ChunkAccess.addPackedPostProcess > ShortList.addAll 3, LevelChunk.<init> > ChunkAccess.<init> 2, SerializableChunkData.unpackStructureStart > RegistryAccess.lookupOrThrow 2, LevelChunk.<init> > Int2ObjectOpenHashMap.<init> 1, ChunkAccess.setAllStarts > HashMap.clear 1
- **LevelChunk.runPostLoad** 230: SerializableChunkData.lambda$postLoadChunk$0 230<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 191, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 10, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 10, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 9, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 5
- **LevelChunk.<init>** 4: ChunkAccess.<init> 2, Int2ObjectOpenHashMap.<init> 1, EnumMap.put 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 1, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1, EnumMap.put > EnumMap.put 1
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 1614 | 6016 | 3536 | 1807 | 673 | 288 (first [-1, -17]) |
| 1 | quicksilver | 1614 | 6015 | 3624 | 1920 | 471 | 243 (first [-1, 18]) |
| 2 | vanilla | 1614 | 6015 | 3567 | 1814 | 634 | 309 (first [-1, -17]) |
| 2 | quicksilver | 1614 | 6015 | 3577 | 1937 | 501 | 249 (first [-1, 10]) |
| 3 | vanilla | 1614 | 6015 | 3575 | 1835 | 605 | 286 (first [-1, -16]) |
| 3 | quicksilver | 1614 | 6015 | 3669 | 1846 | 500 | 297 (first [-1, -16]) |
| 4 | vanilla | 1614 | 6015 | 3597 | 1923 | 495 | 265 (first [-1, -17]) |
| 4 | quicksilver | 1614 | 6015 | 3528 | 1985 | 502 | 208 (first [-10, 11]) |
| 5 | vanilla | 1614 | 6015 | 3583 | 1796 | 636 | 280 (first [-1, -16]) |
| 5 | quicksilver | 1614 | 6015 | 3667 | 1977 | 371 | 250 (first [-1, -16]) |
| 6 | vanilla | 1614 | 6016 | 3583 | 1732 | 701 | 324 (first [-1, 18]) |
| 6 | quicksilver | 1614 | 6015 | 3639 | 1956 | 420 | 286 (first [-1, 9]) |
| 7 | vanilla | 1614 | 6015 | 3646 | 1851 | 518 | 269 (first [-1, -17]) |
| 7 | quicksilver | 1614 | 6015 | 3607 | 1947 | 461 | 270 (first [-1, 10]) |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 720 (283) | 0 (0) | LastUpdate 219, block_ticks 455, fluid_ticks 388 | 1541 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 852 (0) | 0 (0) | LastUpdate 229, block_ticks 563, fluid_ticks 458, sections 1 | 1533 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 791 (267) | 0 (0) | LastUpdate 227, block_ticks 500, fluid_ticks 454, sections 1 | 1552 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 782 (0) | 0 (0) | LastUpdate 237, block_ticks 490, fluid_ticks 449 | 1528 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 795 (252) | 0 (0) | LastUpdate 227, block_ticks 507, fluid_ticks 475 | 1529 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 718 (0) | 0 (0) | LastUpdate 250, block_ticks 437, fluid_ticks 391, sections 1 | 1519 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 742 (272) | 0 (0) | LastUpdate 231, block_ticks 457, fluid_ticks 419, sections 4 | 1540 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 784 (0) | 0 (0) | LastUpdate 244, block_ticks 497, fluid_ticks 458, sections 4 | 1533 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 17 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 821 (276) | 0 (0) | LastUpdate 215, block_ticks 534, fluid_ticks 476, sections 1 | 1533 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 826 (0) | 0 (0) | LastUpdate 255, block_ticks 520, fluid_ticks 476, sections 1 | 1532 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 766 (236) | 0 (0) | LastUpdate 220, block_ticks 467, fluid_ticks 459 | 1545 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 814 (0) | 0 (0) | LastUpdate 271, block_ticks 492, fluid_ticks 469 | 1514 / 1681 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 20 / 24 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 717 (270) | 0 (0) | LastUpdate 209, block_ticks 462, fluid_ticks 417 | 1535 / 1681 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 7 data, 0 bytes only, 0 one side, keys DataVersion 15, Entities 25, Position 15; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1110 data, 0 bytes only, 0 one side, keys LastUpdate 1486, block_ticks 2999, fluid_ticks 2701, sections 7

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 247 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.437 | 0.453 | 2452.070 | 3 | 0.001 (0.001) | 0.014 (0.014) | 0.013 | 5740 (60.8) | 700: 2452.1, 100: 67.2, 5740: 60.8, 400: 49.7, 0: 19.7 |
| 1 | quicksilver | yes | 0.434 | 0.526 | 2319.303 | 2 | 0.000 (0.000) | 0.009 (0.009) | 0.009 | 5743 (40.8) | 700: 2319.3, 100: 63.0, 5743: 40.8, 6896: 39.5, 400: 38.8 |
| 2 | vanilla | yes | 0.440 | 0.485 | 2356.685 | 3 | 0.000 (0.000) | 0.009 (0.009) | 0.008 | 5743 (46.2) | 700: 2356.7, 100: 60.1, 400: 57.1, 5743: 46.2, 0: 19.0 |
| 2 | quicksilver | yes | 0.441 | 0.511 | 2301.477 | 4 | 0.001 (0.001) | 0.012 (0.012) | 0.011 | 5740 (51.2) | 700: 2301.5, 100: 68.2, 400: 55.0, 5740: 51.2, 0: 19.3 |
| 3 | vanilla | yes | 0.488 | 0.653 | 2630.327 | 4 | 0.000 (0.000) | 0.014 (0.014) | 0.013 | 5742 (111.4) | 700: 2630.3, 5742: 111.4, 100: 87.0, 400: 73.2, 499: 32.9 |
| 3 | quicksilver | yes | 0.472 | 0.496 | 2508.801 | 4 | 0.000 (0.000) | 0.018 (0.018) | 0.017 | 5740 (52.0) | 700: 2508.8, 100: 99.4, 400: 68.6, 5740: 52.0, 0: 18.7 |
| 4 | vanilla | yes | 0.414 | 0.602 | 2157.167 | 4 | 0.000 (0.000) | 0.010 (0.010) | 0.010 | 5739 (36.0) | 700: 2157.2, 100: 82.3, 400: 81.9, 4451: 57.9, 5739: 36.0 |
| 4 | quicksilver | yes | 0.424 | 0.645 | 2169.475 | 3 | 0.000 (0.000) | 0.012 (0.011) | 0.010 | 5739 (56.0) | 700: 2169.5, 100: 65.9, 5739: 56.0, 400: 45.3, 0: 20.3 |
| 5 | vanilla | yes | 0.456 | 0.568 | 2433.115 | 4 | 0.000 (0.000) | 0.015 (0.015) | 0.014 | 5737 (37.8) | 700: 2433.1, 100: 69.7, 400: 66.9, 6836: 60.4, 5737: 37.8 |
| 5 | quicksilver | yes | 0.423 | 0.446 | 2323.007 | 3 | 0.000 (0.000) | 0.012 (0.012) | 0.012 | 5742 (53.1) | 700: 2323.0, 100: 59.0, 5742: 53.1, 400: 48.1, 0: 17.9 |
| 6 | vanilla | yes | 0.425 | 0.617 | 2216.637 | 4 | 0.001 (0.001) | 0.011 (0.011) | 0.011 | 5748 (42.9) | 700: 2216.6, 100: 85.5, 400: 77.9, 6571: 55.0, 5748: 42.9 |
| 6 | quicksilver | yes | 0.422 | 0.653 | 2203.963 | 3 | 0.001 (0.001) | 0.011 (0.011) | 0.011 | 5743 (40.8) | 700: 2204.0, 100: 89.0, 400: 60.3, 5743: 40.8, 429: 32.0 |
| 7 | vanilla | yes | 0.453 | 0.658 | 2295.314 | 3 | 0.001 (0.001) | 0.011 (0.011) | 0.011 | 5742 (41.8) | 700: 2295.3, 400: 83.4, 100: 73.7, 6043: 47.7, 5742: 41.8 |
| 7 | quicksilver | yes | 0.446 | 0.619 | 2338.250 | 3 | 0.000 (0.000) | 0.010 (0.010) | 0.009 | 5750 (37.9) | 700: 2338.2, 400: 69.8, 100: 67.4, 5750: 37.9, 613: 30.7 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 0.440 | 0.434 | 0.993 (0.93 to 1.02) |
| MSPT p99 | 0.602 | 0.526 | 1.054 (0.76 to 1.16) |
| slowest tick (ms) | 2356.685 | 2319.303 | 0.977 (0.95 to 1.02) |
| ticks over 50 ms | 4 | 3 | 0.750 (0.67 to 1.33) |
| chunk load, ms per tick (server thread) | 0.000 | 0.000 | 1.000 (0.33 to 4.33) |
|   of it in the tick | 0.000 | 0.000 | 1.000 (0.33 to 4.33) |
| chunk save, ms per tick (server thread) | 0.011 | 0.012 | 1.018 (0.68 to 1.30) |
|   of it in the tick | 0.011 | 0.011 | 1.027 (0.69 to 1.35) |
| autosave, ms per tick | 0.011 | 0.011 | 1.018 (0.67 to 1.31) |
| save-all tick (ms, mean of the script's) | 78.541 | 61.596 | 0.873 (0.68 to 1.05) |
| save-all flush tick (ms) | 2356.685 | 2319.303 | 0.977 (0.95 to 1.02) |
| autosave tick (ms, the game's own) | 42.876 | 51.178 | 0.952 (0.47 to 1.56) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 3081 ms, 21921 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 89 / 1 | 1 / 0 | 0.013 | 166.4 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 5 / 0 | 0 / 0 | 0.001 | 1.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 4 / 0 | 0 / 0 | 0.001 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 1 / 0 | 0 / 0 | 0.000 | 1.0 |
| light | 0 / 0 | 1 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 188 / 0 | 1 / 0 | 0.027 | 40.9 |
| tick, other | 89 / 2 | 0 / 0 | 0.013 | 8.0 |
| idle or other | 0 / 0 | 8 / 0 | 0.001 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 291, MinecraftServer.lambda$spin$0 290, Thread.run 290, MinecraftServer.processPacketsAndTick 289, DedicatedServer.tickServer 289, MinecraftServer.tickServer 289, MinecraftServer.tickChildren 195, ServerLevel.tick 195, ServerChunkCache.tick 113, ServerChunkCache.tickChunks 91, MinecraftServer.saveEverything 90, DedicatedServer.saveAllChunks 90, MinecraftServer.saveAllChunks 90, ServerLevel.save 87, SimulationChunkTracker.getLevel 80, ServerLevel.shouldTickBlocksAt 80, LevelTicks.tick 80, ServerChunkCache.isPositionTicking 80, LevelTicks.sortContainersToTick 80, LevelTicks.collectTicks 80, DistanceManager.inBlockTickingRange 80, ServerLevel.isPositionTickingWithEntitiesLoaded 80, Long2ByteOpenHashMap.get 79, ChunkMap.saveAllChunks 77, ServerChunkCache.save 77, ChunkMap.save 73, SerializableChunkData.copyOf 72, ChunkMap.saveChunkIfNeeded 69, NaturalSpawner.createState 60, Harness.startTick 58, ServerTickEvents.lambda$static$1 58, ContextChain.runExecutable 54, ContextChain.executeAll 54, Harness.command 54, SaveAllCommand.saveAll 54, CommandDispatcher.execute 54, ContextChain.runExecutable$mixinextras$wrapped$10 54, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 54, SaveAllCommand.lambda$register$0 40, ServerChunkCache.getFullChunk 39, MinecraftServer.autoSave 37, ChunkResult$Success.ifSuccess 33, NaturalSpawner.lambda$createState$0 33, PalettedContainer.copy 32, LevelChunkSection.copy 32, LevelChunkSection.<init> 32, PalettedContainer.<init> 29, EnvironmentAttributeReader.getValue 28, PalettedContainer$Data.copy 28, EnvironmentAttributeSystem.getValue 22, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 22, EnvironmentAttributeSystem$ValueSampler.getValue 22, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 19, BiomeManager.getBiome 17, LevelReader.getNoiseBiome 14, SaveAllCommand.lambda$register$1 14, ChunkMap.tick 12, LightEngine.getDataLayerData 11, LayerLightSectionStorage.getDataLayerData 9, Encoder.encodeStart 9

Top chunk methods (self): Long2ByteOpenHashMap.get 79, PalettedContainer$Data.copy 28, ServerChunkCache.tickChunks 18, Iterators$1.hasNext 9, PalettedContainer.get 8, Long2ObjectOpenHashMap.get 7, Vec3.atLowerCornerWithOffset 6, Long2ObjectLinkedOpenHashMap.get 6, NaturalSpawner.createState 5, TicketStorage.removeTicketIf 4, ArrayList.grow 3, DirectMethodHandle.allocateInstance 3, PalettedContainer.copy 3, Iterables.unmodifiableIterable 3, SectionPos.of 2, GenerationChunkHolder.getChunkIfPresentUnchecked 2, LayerLightSectionStorage.getDataLayerData 2, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 2, Math.floorMod 2, SectionPos.asLong 2, Applicative.ap2 2, RegularImmutableMap.fromEntryArrayCheckingBucketOverflow 2, Long2ObjectOpenHashMap.<init> 2, Long2ByteOpenHashMap$MapIterator.<init> 2, LongLinkedOpenHashSet.iterator 2, Long2ByteOpenHashMap$KeyIterator.<init> 2, InvokerBytecodeGenerator.emitStaticInvoke 1, EntryMap.firstToken 1, DistanceManager$FixedPlayerDistanceChunkTracker.getLevel 1, JVM.getEventWriter 1

Threads (all samples in the window): Netty Epoll IO  1885, Worker-Main 994, IO-Worker 779, Server thread 391, JFR Periodic Tasks 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 3072 ms, 21743 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 60 / 1 | 0 / 0 | 0.009 | 106.7 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 1.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 4 / 0 | 0 / 0 | 0.001 | 3.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 3 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 2 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 1 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 92 / 2 | 1 / 0 | 0.014 | 40.3 |
| tick, other | 223 / 1 | 0 / 0 | 0.032 | 6.4 |
| idle or other | 0 / 0 | 16 / 0 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 167, MinecraftServer.runServer 167, Thread.run 166, DedicatedServer.tickServer 165, MinecraftServer.processPacketsAndTick 165, MinecraftServer.tickServer 165, MinecraftServer.tickChildren 100, ServerLevel.tick 100, ServerChunkCache.tick 83, DedicatedServer.saveAllChunks 61, MinecraftServer.saveEverything 61, MinecraftServer.saveAllChunks 61, ServerLevel.save 58, Harness.startTick 55, ServerTickEvents.lambda$static$1 55, ServerChunkCache.tickChunks 54, SaveAllCommand.saveAll 51, ContextChain.runExecutable$mixinextras$wrapped$10 51, ContextChain.runExecutable 51, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 51, CommandDispatcher.execute 51, Harness.command 51, ContextChain.executeAll 51, ServerChunkCache.save 49, ChunkMap.saveAllChunks 49, NaturalSpawner.createState 46, ChunkMap.save 46, SerializableChunkData.copyOf 42, ChunkMap.saveChunkIfNeeded 39, SaveAllCommand.lambda$register$0 36, ServerChunkCache.getFullChunk 34, ChunkResult$Success.ifSuccess 30, NaturalSpawner.lambda$createState$0 28, EnvironmentAttributeReader.getValue 25, EnvironmentAttributeSystem.getValue 24, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 23, EnvironmentAttributeSystem$ValueSampler.getValue 23, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 23, SimulationChunkTracker.getLevel 23, Long2ByteOpenHashMap.get 23, ChunkMap.tick 21, BiomeManager.getBiome 20, LevelReader.getNoiseBiome 17, ServerLevel.isPositionTickingWithEntitiesLoaded 16, LevelTicks.collectTicks 16, ServerChunkCache.isPositionTicking 16, ServerLevel.shouldTickBlocksAt 16, LevelTicks.sortContainersToTick 16, DistanceManager.inBlockTickingRange 16, LevelTicks.tick 16, SaveAllCommand.lambda$register$1 15, ImposterProtoChunk.getNoiseBiome 13, LevelChunkSection.getNoiseBiome 13, ChunkAccess.getNoiseBiome 13, AbstractPipeline.evaluate 12, PalettedContainer.get 12, LevelChunk.getBlockEntityNbtForSaving 11, AbstractPipeline.wrapAndCopyInto 11, Encoder.encodeStart 10, TagValueOutput.store 10

Top chunk methods (self): Long2ByteOpenHashMap.get 23, PalettedContainer.get 12, Long2ObjectOpenHashMap.get 7, NaturalSpawner.createState 5, PalettedContainer.create$quicksilver_$md$7641d5$0 4, Long2ObjectLinkedOpenHashMap.get 4, DirectMethodHandle.allocateInstance 3, VarHandleReferences$Array.getVolatile 3, LevelChunkTicks.pack 3, TicketStorage.removeTicketIf 3, ChunkResult$Success.ifSuccess 2, Math.floorMod 2, NaturalSpawner.lambda$createState$0 2, PoolElementStructurePiece.addAdditionalSaveData 2, ChunkPos.pack 2, ThreadLocal.get 2, Iterators$1.hasNext 2, SectionPos.of 2, HashMap.getNode 1, LongOpenHashSet$SetIterator.<init> 1, TicketType.equals 1, ServerChunkCache.getFullChunk 1, LevelChunkSection.getNoiseBiome 1, BiomeManager.getFiddledDistance 1, LevelLightEngine.hasLightWork 1, RegularImmutableMap.get 1, LongLinkedOpenHashSet.iterator 1, RegistryAccess$ImmutableRegistryAccess.lookup 1, Codec$20.encode 1, LevelHeightAccessor.getMinSectionY 1

Threads (all samples in the window): Netty Epoll IO  1792, Worker-Main 869, IO-Worker 716, Server thread 407

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 557: DedicatedServer.saveAllChunks 554, MinecraftServer.warnOnLowDiskSpace 3<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 554, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 3
- **ServerLevel.save** 518: ServerChunkCache.save 450, PersistentEntitySectionManager.autoSave 32, PersistentEntitySectionManager.saveAll 26, ServerLevel.saveLevelData 10<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 450, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 28, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 21, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 7, PersistentEntitySectionManager.saveAll > EntityStorage.flush 5, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 3, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 3, PersistentEntitySectionManager.autoSave > MethodHandleNatives.findMethodHandleType 1
- **ChunkMap.saveAllChunks** 450: ChunkMap.saveChunkIfNeeded 357, ReferencePipeline.forEach 87, ReferencePipeline.toList 3<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 352, ReferencePipeline.forEach > AbstractPipeline.evaluate 87, ReferencePipeline.toList > ReferencePipeline.toArray 3, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 1, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1
- **ChunkMap.save** 434: SerializableChunkData.copyOf 418, CompletableFuture.supplyAsync 5, SimpleRegionStorage.write 5, DirectMethodHandle.allocateInstance 1, ChunkMap.markPosition 1, ProfilerFiller.incrementCounter 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 146, SerializableChunkData.copyOf > LightEngine.getDataLayerData 57, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 52, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 41, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 34, SerializableChunkData.copyOf > DataLayer.copy 15, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 11, SerializableChunkData.copyOf > Heightmap.getRawData 8, SerializableChunkData.copyOf > ReferencePipeline.toArray 7, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 5, SimpleRegionStorage.write > IOWorker.store 5, SerializableChunkData.copyOf > ArrayList.add 4
- **SerializableChunkData.copyOf** 418: LevelChunkSection.copy 146, LightEngine.getDataLayerData 57, LevelChunk.getBlockEntityNbtForSaving 52, SerializableChunkData.packStructureData 41, LevelChunk.getTicksForSerialization 34, DataLayer.copy 15, ChunkAccess.getBlockEntitiesPos 11, Heightmap.getRawData 8, ReferencePipeline.toArray 7, ArrayList.add 4, LevelLightEngine.getMaxLightSection 4, Collections$UnmodifiableCollection.iterator 2<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 138, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 51, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 49, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 32, SerializableChunkData.packStructureData > StructureStart.createTag 31, LightEngine.getDataLayerData > SectionPos.asLong 8, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 7, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 7, ArrayList.add > ArrayList.add 4, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 4, DataLayer.copy > DataLayer.<init> 4, SerializableChunkData.packStructureData > Identifier.toString 3
- **PersistentEntitySectionManager.autoSave** 32: AbstractLongCollection.forEach 28, PersistentEntitySectionManager.getAllChunksToSave 3, MethodHandleNatives.findMethodHandleType 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 28, MethodHandleNatives.findMethodHandleType > MethodType.methodType 1
- **ChunkMap.processUnloads** 12: ChunkMap.saveChunksEagerly 3, LongOpenHashSet.iterator 2, ConcurrentLinkedQueue.size 2<br>two down: LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2, ChunkMap.saveChunksEagerly > Util.getMillis 1, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 3: Util.getMillis 1<br>two down: Util.getMillis > Util.getNanos 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 551: DedicatedServer.saveAllChunks 547, MinecraftServer.warnOnLowDiskSpace 4<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 547, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 4
- **ServerLevel.save** 517: ServerChunkCache.save 445, PersistentEntitySectionManager.autoSave 45, PersistentEntitySectionManager.saveAll 22, ServerLevel.saveLevelData 5<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 445, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 42, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 17, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 3, PersistentEntitySectionManager.saveAll > EntityStorage.flush 3, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 2, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 2, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 2, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkCallSite 1
- **ChunkMap.saveAllChunks** 445: ChunkMap.saveChunkIfNeeded 354, ReferencePipeline.forEach 85, Long2ObjectLinkedOpenHashMap$ValueIterator.next 3, ReferencePipeline.toList 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 346, ReferencePipeline.forEach > AbstractPipeline.evaluate 85, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 3, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 2, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1, ReferencePipeline.toList > ReferencePipeline.toArray 1
- **ChunkMap.save** 426: SerializableChunkData.copyOf 408, SimpleRegionStorage.write 7, CompletableFuture.supplyAsync 3, ChunkMap.markPosition 2, CompletableFuture.handle 1, ProfilerFiller.incrementCounter 1, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 118, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 60, SerializableChunkData.copyOf > LightEngine.getDataLayerData 54, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 36, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 31, SerializableChunkData.copyOf > DataLayer.copy 16, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 12, SimpleRegionStorage.write > IOWorker.store 7, SerializableChunkData.copyOf > Heightmap.getRawData 5, SerializableChunkData.copyOf > ArrayList.add 5, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 4, SerializableChunkData.copyOf > SerializableChunkData.handler$zon000$quicksilver$copySection 3
- **SerializableChunkData.copyOf** 408: LevelChunkSection.copy 118, LevelChunk.getBlockEntityNbtForSaving 60, LightEngine.getDataLayerData 54, SerializableChunkData.packStructureData 36, LevelChunk.getTicksForSerialization 31, DataLayer.copy 16, ChunkAccess.getBlockEntitiesPos 12, Heightmap.getRawData 5, ArrayList.add 5, LevelLightEngine.getMaxLightSection 4, SerializableChunkData.handler$zon000$quicksilver$copySection 3, Collections$UnmodifiableCollection$1.hasNext 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 108, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 58, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 53, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 30, SerializableChunkData.packStructureData > StructureStart.createTag 21, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 7, ArrayList.add > ArrayList.add 5, LevelLightEngine.getMaxLightSection > LevelLightEngine.getMinLightSection 4, SerializableChunkData.packStructureData > CompoundTag.put 4, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 4, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 3, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 3
- **PersistentEntitySectionManager.autoSave** 45: AbstractLongCollection.forEach 42, PersistentEntitySectionManager.getAllChunksToSave 2, MethodHandleNatives.linkCallSite 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 42, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 1, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 1, MethodHandleNatives.linkCallSite > MethodHandleNatives.linkCallSiteImpl 1
- **ChunkMap.processUnloads** 16: ChunkMap.saveChunksEagerly 7, LongOpenHashSet.iterator 5, ConcurrentLinkedQueue.size 1<br>two down: LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 4, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 2, ChunkMap.saveChunksEagerly > Util.getMillis 1, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 7: LongLinkedOpenHashSet.iterator 2, Util.getMillis 1<br>two down: LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2, Util.getMillis > Util.getNanos 1
- **SectionStorage.flush** 1: ChunkPos.pack 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 625 | 2029 | 1875 | 0 | 154 | 0 |
| 1 | quicksilver | 625 | 2068 | 2059 | 0 | 9 | 0 |
| 2 | vanilla | 625 | 2059 | 1875 | 0 | 184 | 0 |
| 2 | quicksilver | 625 | 2017 | 2017 | 0 | 0 | 0 |
| 3 | vanilla | 625 | 2043 | 2041 | 0 | 2 | 0 |
| 3 | quicksilver | 625 | 2011 | 2011 | 0 | 0 | 0 |
| 4 | vanilla | 625 | 2044 | 1875 | 0 | 169 | 0 |
| 4 | quicksilver | 625 | 2028 | 2028 | 0 | 0 | 0 |
| 5 | vanilla | 625 | 2124 | 1875 | 0 | 249 | 0 |
| 5 | quicksilver | 625 | 2032 | 2032 | 0 | 0 | 0 |
| 6 | vanilla | 625 | 2043 | 1875 | 0 | 168 | 0 |
| 6 | quicksilver | 625 | 2095 | 2059 | 0 | 36 | 0 |
| 7 | vanilla | 625 | 2041 | 2041 | 0 | 0 | 0 |
| 7 | quicksilver | 625 | 2054 | 1875 | 0 | 179 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 479 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 487 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 502 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 473 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 487 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 484 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 470 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 475 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (1) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 482 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 472 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 478 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 456 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 495 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 3 data, 0 bytes only, 0 one side, keys DataVersion 8, Entities 9, Position 8; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / kill: a kill -9 mid-save (save-all flush of 625 changed chunks)

| run | killed mid-save | chunks: complete save's / its at another tick / saved terrain's / other / unreadable (region) | entities, poi: other / unreadable | reloaded |
|---|---|---|---|---|
| quicksilver-killed1 | yes | 9656 / 68 / 77 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| quicksilver-killed2 | yes | 9567 / 151 / 83 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed1 | yes | 9564 / 153 / 84 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed2 | yes | 9555 / 162 / 84 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
quicksilver-complete1 against vanilla's complete saves: entities 3 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0

quicksilver-complete2 against vanilla's complete saves: entities 2 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0


Each chunk of a killed save is either the complete save's (possibly written at another tick: it differs only in LastUpdate, block_ticks, fluid_ticks) or the saved terrain's: a kill loses the chunks not yet written, and breaks none. Entity and POI files are reported only (their data follows entity and POI timing, as in vanilla's own rounds).

