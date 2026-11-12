# Chunk scenes (P2-4)

## core / churn

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 15.042 | 214.476 | 1806.168 | 32 | 0.047 (0.047) | 1.410 (1.402) | 1.402 | - | 220: 1806.2, 128: 440.4, 87: 434.6, 139: 336.3, 103: 312.1 |
| 1 | quicksilver | yes | 14.226 | 188.786 | 1983.635 | 28 | 0.052 (0.043) | 1.008 (1.003) | 1.003 | - | 220: 1983.6, 87: 596.3, 128: 438.6, 103: 322.9, 139: 296.4 |
| 2 | vanilla | yes | 14.811 | 196.332 | 1846.897 | 31 | 0.045 (0.037) | 1.335 (1.330) | 1.328 | - | 220: 1846.9, 128: 466.7, 87: 441.8, 103: 313.6, 139: 224.7 |
| 2 | quicksilver | yes | 13.803 | 195.881 | 1849.018 | 27 | 0.033 (0.028) | 1.128 (1.128) | 1.123 | - | 220: 1849.0, 128: 367.1, 87: 355.3, 103: 289.8, 21: 229.5 |
| 3 | vanilla | yes | 14.657 | 209.862 | 2074.312 | 30 | 0.045 (0.043) | 1.328 (1.325) | 1.323 | - | 220: 2074.3, 87: 431.1, 128: 396.9, 103: 340.4, 7: 228.1 |
| 3 | quicksilver | yes | 13.806 | 180.842 | 1727.387 | 30 | 0.030 (0.025) | 1.122 (1.115) | 1.118 | - | 220: 1727.4, 87: 396.9, 128: 379.3, 103: 290.4, 21: 237.5 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 14.811 | 13.806 | 0.942 (0.93 to 0.95) |
| MSPT p99 | 209.862 | 188.786 | 0.880 (0.86 to 1.00) |
| slowest tick (ms) | 1846.897 | 1849.018 | 1.001 (0.83 to 1.10) |
| ticks over 50 ms | 31 | 28 | 0.875 (0.87 to 1.00) |
| chunk load, ms per tick (server thread) | 0.045 | 0.033 | 0.740 (0.67 to 1.11) |
|   of it in the tick | 0.043 | 0.028 | 0.771 (0.58 to 0.93) |
| chunk save, ms per tick (server thread) | 1.335 | 1.122 | 0.844 (0.72 to 0.85) |
|   of it in the tick | 1.330 | 1.115 | 0.842 (0.72 to 0.85) |
| autosave, ms per tick | 1.328 | 1.118 | 0.845 (0.72 to 0.85) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 9073 ms, 31307 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 765 / 71 | 5 / 0 | 1.402 | 1713.7 |
| chunk save | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| entity save | 4 / 0 | 0 / 0 | 0.007 | 0.0 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 6 / 0 | 0 / 0 | 0.010 | 0.9 |
| chunk to full (promote) | 21 / 1 | 0 / 0 | 0.037 | 3.8 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 17 / 2 | 0 / 0 | 0.032 | 0.0 |
| light | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| chunk system (tickets, holders, tasks) | 267 / 130 | 3 / 0 | 0.667 | 207.0 |
| tick, other | 164 / 3 | 0 / 0 | 0.278 | 41.2 |
| idle or other | 0 / 0 | 8 / 0 | 0.013 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1289, MinecraftServer.lambda$spin$0 1288, DedicatedServer.tickServer 1286, MinecraftServer.processPacketsAndTick 1286, MinecraftServer.tickServer 1286, Thread.run 1283, CiChunks.startTick 1091, ServerTickEvents.lambda$static$1 1090, Harness.startTick 1090, MinecraftServer.saveEverything 841, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 841, ContextChain.runExecutable$mixinextras$wrapped$10 841, ContextChain.runExecutable 841, SaveAllCommand.lambda$register$0 841, SaveAllCommand.saveAll 841, ContextChain.executeAll 840, CommandDispatcher.execute 840, Harness.command 838, DedicatedServer.saveAllChunks 835, MinecraftServer.saveAllChunks 835, ServerLevel.save 748, ChunkMap.saveAllChunks 694, ServerChunkCache.save 694, ChunkMap.saveChunkIfNeeded 686, ChunkMap.save 677, SerializableChunkData.copyOf 666, LevelChunkSection.<init> 414, LevelChunkSection.copy 414, PalettedContainer.copy 414, PalettedContainer.<init> 370, PalettedContainer$Data.copy 365, LevelReader.getChunk 250, Level.getBlockState 250, Level.getChunk 250, ServerChunkCache.getChunk 250, Level.setBlock 225, LevelWriter.setBlock 225, CollectingNeighborUpdater.runUpdates 220, CollectingNeighborUpdater$ShapeUpdate.runNext 220, BlockBehaviour$BlockStateBase.updateNeighbourShapes 220, CollectingNeighborUpdater.addAndRun 220, CollectingNeighborUpdater.shapeUpdate 220, NeighborUpdater.executeShapeUpdate 220, Level.neighborShapeChanged 220, ServerLevel.tick 197, MinecraftServer.tickChildren 197, ServerChunkCache.tick 188, ServerChunkCache.runDistanceManagerUpdates 179, DistanceManager.runAllUpdates 170, BlockableEventLoop.managedBlock 151, Thread.yield0 130, BlockableEventLoop.waitForTasks 130, Thread.yield 130, DynamicGraphMinFixedPoint.runUpdates 120, LoadingChunkTracker.runDistanceUpdates 119, ChunkTracker.checkNeighborsAfterUpdate 100, DynamicGraphMinFixedPoint.checkNeighbor 97, DynamicGraphMinFixedPoint.checkEdge 90, LoadingChunkTracker.getLevel 81, LevelStorageSource$LevelStorageAccess.saveDataTag 79

Top chunk methods (self): PalettedContainer$Data.copy 347, Thread.yield0 130, LongOpenHashSet.contains 55, Long2ObjectOpenHashMap.get 49, PalettedContainer.copy 44, UnixFileDispatcherImpl.write0 34, ServerChunkCache.getChunk 30, Long2ObjectLinkedOpenHashMap.get 29, ArrayList.grow 21, SerializableChunkData.copyOf 20, Deflater.init 20, ConcurrentLinkedQueue.offer 16, Object.clone 14, LayerLightSectionStorage.getDataLayerData 12, HashMap.putVal 11, TimSort.countRunAndMakeAscending 10, DirectMethodHandle.allocateInstance 9, UnixNativeDispatcher.unlink0 8, ConcurrentLinkedQueue.size 8, Arrays.copyOf 8, Long2ByteOpenHashMap.get 8, ChunkMap.saveAllChunks 8, Long2ByteOpenHashMap.find 8, DataLayer.<init> 7, ChunkMap.onLevelChange 7, LongLinkedOpenHashSet.rehash 7, LongLinkedOpenHashSet.add 7, TicketStorage.addTicket 6, DynamicGraphMinFixedPoint.runUpdates 5, PiecesContainer.save 5

Threads (all samples in the window): Worker-Main 5693, Netty Epoll IO  5527, Server thread 1469, IO-Worker 624, Reference Handler 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 8585 ms, 31956 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 548 / 51 | 3 / 0 | 1.003 | 1062.4 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 3 / 0 | 0 / 0 | 0.005 | 0.6 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 7 / 0 | 0 / 0 | 0.012 | 33.8 |
| chunk to full (promote) | 19 / 0 | 0 / 0 | 0.032 | 1.9 |
| entity load | 0 / 0 | 5 / 0 | 0.008 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 13 / 1 | 0 / 0 | 0.023 | 0.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 61.1 |
| chunk system (tickets, holders, tasks) | 270 / 75 | 5 / 0 | 0.583 | 177.2 |
| tick, other | 208 / 5 | 0 / 0 | 0.355 | 91.9 |
| idle or other | 0 / 0 | 11 / 0 | 0.018 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 994, MinecraftServer.lambda$spin$0 992, Thread.run 991, DedicatedServer.tickServer 987, MinecraftServer.tickServer 987, MinecraftServer.processPacketsAndTick 986, ServerTickEvents.lambda$static$1 800, Harness.startTick 800, CiChunks.startTick 799, ContextChain.runExecutable$mixinextras$wrapped$10 603, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 603, ContextChain.runExecutable 603, ContextChain.executeAll 603, CommandDispatcher.execute 603, Harness.command 602, SaveAllCommand.saveAll 602, SaveAllCommand.lambda$register$0 602, MinecraftServer.saveEverything 602, DedicatedServer.saveAllChunks 597, MinecraftServer.saveAllChunks 597, ServerLevel.save 532, ServerChunkCache.save 488, ChunkMap.saveAllChunks 488, ChunkMap.saveChunkIfNeeded 481, ChunkMap.save 468, SerializableChunkData.copyOf 456, LevelChunkSection.<init> 199, LevelChunkSection.copy 199, Level.getChunk 195, ServerChunkCache.getChunk 195, LevelReader.getChunk 194, Level.getBlockState 194, ServerLevel.tick 189, MinecraftServer.tickChildren 189, ServerChunkCache.tick 183, Level.setBlock 163, LevelWriter.setBlock 163, CollectingNeighborUpdater.shapeUpdate 159, ServerChunkCache.runDistanceManagerUpdates 159, NeighborUpdater.executeShapeUpdate 159, CollectingNeighborUpdater$ShapeUpdate.runNext 159, CollectingNeighborUpdater.runUpdates 159, BlockBehaviour$BlockStateBase.updateNeighbourShapes 159, Level.neighborShapeChanged 159, CollectingNeighborUpdater.addAndRun 159, DistanceManager.runAllUpdates 153, DynamicGraphMinFixedPoint.runUpdates 115, LoadingChunkTracker.runDistanceUpdates 115, BlockableEventLoop.managedBlock 95, ChunkTracker.checkNeighborsAfterUpdate 93, DynamicGraphMinFixedPoint.checkNeighbor 90, LayerLightSectionStorage.getDataLayerData 82, LightEngine.getDataLayerData 82, PalettedContainer.create$quicksilver_$md$282e8b$0 81, PalettedContainer.copy 81, PalettedContainerInvoker.quicksilver$create 81, PalettedContainer.handler$zom000$quicksilver$share 81, LoadingChunkTracker.getLevel 78, Thread.yield 75, BlockableEventLoop.waitForTasks 75

Top chunk methods (self): LevelChunkSection.<init> 118, PalettedContainer.create$quicksilver_$md$282e8b$0 81, Thread.yield0 75, Long2ObjectOpenHashMap.get 59, LongOpenHashSet.contains 51, ServerChunkCache.getChunk 34, Long2ObjectLinkedOpenHashMap.get 31, SerializableChunkData.copyOf 22, UnixFileDispatcherImpl.write0 22, Collections$UnmodifiableCollection$1.hasNext 16, LayerLightSectionStorage.getDataLayerData 15, UnixNativeDispatcher.unlink0 11, TimSort.countRunAndMakeAscending 11, Long2ObjectOpenHashMap$MapIterator.nextEntry 9, HashMap.putVal 9, LongLinkedOpenHashSet.add 9, Deflater.init 9, ShortArrayList.copyArrayFromSafe 8, Long2ObjectFunctions$SynchronizedFunction.get 8, LevelChunkTicks.pack 8, ChunkMap.onLevelChange 8, Long2ByteOpenHashMap.get 7, LongLinkedOpenHashSet.rehash 6, TicketStorage.removeTicketIf 6, DataLayer.isEmpty 6, ConcurrentLinkedQueue.size 6, Arrays.copyOf 5, ChunkMap.saveAllChunks 5, NaturalSpawner.createState 5, ChunkMap.saveChunkIfNeeded 5

Threads (all samples in the window): Worker-Main 5515, Netty Epoll IO  5400, Server thread 1224, IO-Worker 635

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2432: DedicatedServer.saveAllChunks 2413, MinecraftServer.warnOnLowDiskSpace 19<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2413, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 19
- **ServerLevel.save** 2152: ServerChunkCache.save 2006, PersistentEntitySectionManager.autoSave 120, ServerLevel.saveLevelData 23<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 2005, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 107, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 23, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 12, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkMethodHandleConstant 1, ServerChunkCache.save > ServerChunkCache.runDistanceManagerUpdates 1
- **ChunkMap.saveAllChunks** 2005: ChunkMap.saveChunkIfNeeded 1981, Long2ObjectLinkedOpenHashMap$ValueIterator.next 4<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1953, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 13, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 4
- **ChunkMap.save** 1953: SerializableChunkData.copyOf 1920, CompletableFuture.supplyAsync 22, ChunkMap.markPosition 4, SimpleRegionStorage.write 4, CompletableFuture.handle 1, Profiler.get 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 1085, SerializableChunkData.copyOf > LightEngine.getDataLayerData 220, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 129, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 120, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 112, SerializableChunkData.copyOf > ReferencePipeline.toArray 45, SerializableChunkData.copyOf > DataLayer.copy 42, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 29, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 28, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 21, SerializableChunkData.copyOf > ArrayList.add 18, SerializableChunkData.copyOf > Heightmap.getRawData 4
- **SerializableChunkData.copyOf** 1920: LevelChunkSection.copy 1085, LightEngine.getDataLayerData 220, LevelChunk.getTicksForSerialization 129, LevelChunk.getBlockEntityNbtForSaving 120, SerializableChunkData.packStructureData 112, ReferencePipeline.toArray 45, DataLayer.copy 42, ChunkAccess.getBlockEntitiesPos 29, Collections$UnmodifiableCollection$1.hasNext 27, ArrayList.add 18, DataLayer.isEmpty 4, Heightmap.getRawData 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 1081, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 218, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 128, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 115, SerializableChunkData.packStructureData > StructureStart.createTag 63, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 42, DataLayer.copy > DataLayer.<init> 38, ArrayList.add > ArrayList.add 18, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, SerializableChunkData.packStructureData > CompoundTag.put 11, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 10, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 6
- **DistanceManager.runAllUpdates** 510: LoadingChunkTracker.runDistanceUpdates 386, ChunkHolder.updateFutures 90, ReferenceOpenHashSet$SetIterator.next 11, ReferenceOpenHashSet.clear 8, GenerationChunkHolder.updateHighestAllowedStatus 2, DistanceManager$PlayerTicketTracker.runAllUpdates 1, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 1, ReferenceOpenHashSet.iterator 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 386, ChunkHolder.updateFutures > ChunkMap.onLevelChange 43, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 29, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 11, ReferenceOpenHashSet.clear > Arrays.fill 8, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 2, DistanceManager$PlayerTicketTracker.runAllUpdates > DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 1, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 1, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 1, ReferenceOpenHashSet.iterator > ReferenceOpenHashSet.iterator 1, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 1
- **PersistentEntitySectionManager.autoSave** 120: AbstractLongCollection.forEach 107, PersistentEntitySectionManager.getAllChunksToSave 12, MethodHandleNatives.linkMethodHandleConstant 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 107, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 7, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 2, MethodHandleNatives.linkMethodHandleConstant > MethodHandles$Lookup.linkMethodHandleConstant 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1
- **ChunkMap.processUnloads** 54: ConcurrentLinkedQueue.size 24, ChunkMap.scheduleUnload 13, LongOpenHashSet$SetIterator.remove 4, CompletableFuture$Completion.run 4, ChunkMap.saveChunksEagerly 2, Long2ObjectLinkedOpenHashMap.remove 1, LongOpenHashSet.iterator 1, Long2ObjectLinkedOpenHashMap.put 1<br>two down: ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 5, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 4, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 2, ChunkMap.saveChunksEagerly > Util.getMillis 2, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 1, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 1
- **LevelChunk.runPostLoad** 19: SerializableChunkData.lambda$postLoadChunk$0 19<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 16, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 1, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 1
- **SerializableChunkData.read** 17: PoiManager.checkConsistencyWithBlocks 11, LevelChunk.<init> 2, SerializableChunkData.unpackStructureStart 1, SerializableChunkData.unpackStructureReferences 1, ImposterProtoChunk.<init> 1, ChunkAccess.setAllStarts 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 9, LevelChunk.<init> > ChunkAccess.<init> 2, PoiManager.checkConsistencyWithBlocks > Util.ifElse 2, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 1, ImposterProtoChunk.<init> > ProtoChunk.<init> 1
- **ChunkMap.saveChunksEagerly** 2: Util.getMillis 2<br>two down: Util.getMillis > Util.getNanos 2
- **LevelChunk.<init>** 2: ChunkAccess.<init> 2<br>two down: ChunkAccess.<init> > ChunkAccess.replaceMissingSections 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 1947: DedicatedServer.saveAllChunks 1932, MinecraftServer.warnOnLowDiskSpace 15<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 1931, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 15
- **ServerLevel.save** 1718: ServerChunkCache.save 1567, PersistentEntitySectionManager.autoSave 116, ServerLevel.saveLevelData 35<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1567, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 102, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 34, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 14
- **ChunkMap.saveAllChunks** 1567: ChunkMap.saveChunkIfNeeded 1551, Long2ObjectLinkedOpenHashMap$ValueIterator.next 4<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1518, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 11, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 4, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 3, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 1518: SerializableChunkData.copyOf 1482, CompletableFuture.supplyAsync 18, SimpleRegionStorage.write 7, ChunkMap.markPosition 7, CompletableFuture.handle 2, DirectMethodHandle.allocateInstance 1, Profiler.get 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 673, SerializableChunkData.copyOf > LightEngine.getDataLayerData 231, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 104, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 100, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 98, SerializableChunkData.copyOf > DataLayer.copy 51, SerializableChunkData.copyOf > ReferencePipeline.toArray 46, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 37, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 21, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 17, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 14, SerializableChunkData.copyOf > EnumMap$EntryIterator$Entry.getKey 12
- **SerializableChunkData.copyOf** 1482: LevelChunkSection.copy 673, LightEngine.getDataLayerData 231, SerializableChunkData.packStructureData 104, LevelChunk.getTicksForSerialization 100, LevelChunk.getBlockEntityNbtForSaving 98, DataLayer.copy 51, ReferencePipeline.toArray 46, Collections$UnmodifiableCollection$1.hasNext 37, ChunkAccess.getBlockEntitiesPos 21, LevelLightEngine.getMaxLightSection 14, EnumMap$EntryIterator$Entry.getKey 12, DataLayer.isEmpty 6<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 673, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 230, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 98, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 92, SerializableChunkData.packStructureData > StructureStart.createTag 68, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 46, DataLayer.copy > DataLayer.<init> 37, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 15, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 13, ArrayList.add > ArrayList.add 8, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 7, SerializableChunkData.packStructureData > CompoundTag.putLongArray 6
- **DistanceManager.runAllUpdates** 478: LoadingChunkTracker.runDistanceUpdates 354, ChunkHolder.updateFutures 89, ReferenceOpenHashSet$SetIterator.next 11, ReferenceOpenHashSet.clear 10, GenerationChunkHolder.updateHighestAllowedStatus 4, ReferenceOpenHashSet.iterator 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 354, ChunkHolder.updateFutures > ChunkMap.onLevelChange 47, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 25, ReferenceOpenHashSet.clear > Arrays.fill 10, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 9, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 3, ReferenceOpenHashSet.iterator > ReferenceOpenHashSet.iterator 2, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 1
- **PersistentEntitySectionManager.autoSave** 116: AbstractLongCollection.forEach 102, PersistentEntitySectionManager.getAllChunksToSave 14<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 102, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 4, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 4, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 2, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 2
- **ChunkMap.processUnloads** 52: ConcurrentLinkedQueue.size 25, ChunkMap.scheduleUnload 9, CompletableFuture$Completion.run 7, LongOpenHashSet$SetIterator.remove 5, LongOpenHashSet.iterator 1, LongOpenHashSet$SetIterator.nextLong 1, Long2ObjectLinkedOpenHashMap.remove 1, Long2ObjectLinkedOpenHashMap.get 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 7, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 4, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkMethodHandleConstant 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 2, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 1, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 1, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1
- **SerializableChunkData.read** 16: PoiManager.checkConsistencyWithBlocks 4, ImposterProtoChunk.<init> 4, SerializableChunkData.unpackStructureReferences 2, LevelChunk.<init> 1, SerializableChunkData.unpackStructureStart 1, ChunkAccess.setAllStarts 1, LevelChunkTicks.<init> 1, LevelHeightAccessor.getSectionsCount 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 4, ImposterProtoChunk.<init> > ProtoChunk.<init> 3, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 2, LevelChunk.<init> > Heightmap.<init> 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 1, LevelHeightAccessor.getSectionsCount > LevelHeightAccessor.getMaxSectionY 1
- **LevelChunk.runPostLoad** 15: SerializableChunkData.lambda$postLoadChunk$0 15<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 12, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 1
- **LevelChunk.<init>** 1: Heightmap.<init> 1<br>two down: Heightmap.<init> > ChunkAccess.getHeight 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 357 | 13087 | 13085 | 0 | 2 | 0 |
| 1 | quicksilver | 357 | 12825 | 12809 | 0 | 16 | 0 |
| 2 | vanilla | 357 | 13560 | 13170 | 0 | 390 | 0 |
| 2 | quicksilver | 357 | 13216 | 13214 | 0 | 2 | 0 |
| 3 | vanilla | 357 | 13170 | 13170 | 0 | 0 | 0 |
| 3 | quicksilver | 357 | 13415 | 13415 | 0 | 0 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-3 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 242 / 357 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 2 / 7 | 1 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 270 / 357 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 263 / 357 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 7 | 1 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 250 / 357 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 264 / 357 | 0 |

Vanilla's noise (rounds 2-3 against 1): dimensions/minecraft/overworld/entities: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 1.552 | 8.058 | 23.482 | 0 | 0.169 (0.083) | 0.351 (0.350) | 0.000 | - | 8: 23.5, 32: 17.8, 184: 17.2, 0: 16.1, 40: 13.7 |
| 1 | quicksilver | yes | 1.552 | 7.802 | 22.931 | 0 | 0.170 (0.078) | 0.298 (0.298) | 0.000 | - | 8: 22.9, 0: 21.1, 984: 20.4, 1080: 18.5, 864: 16.3 |
| 2 | vanilla | yes | 1.562 | 7.659 | 23.864 | 0 | 0.167 (0.071) | 0.327 (0.327) | 0.000 | - | 8: 23.9, 0: 18.9, 24: 16.5, 760: 15.5, 88: 13.0 |
| 2 | quicksilver | yes | 1.536 | 7.160 | 32.091 | 0 | 0.178 (0.077) | 0.308 (0.308) | 0.000 | - | 8: 32.1, 0: 18.6, 24: 15.1, 40: 14.6, 584: 11.8 |
| 3 | vanilla | yes | 1.564 | 7.187 | 23.931 | 0 | 0.142 (0.072) | 0.311 (0.311) | 0.000 | - | 8: 23.9, 98: 17.4, 0: 16.2, 40: 15.7, 24: 13.3 |
| 3 | quicksilver | yes | 1.489 | 6.904 | 26.507 | 0 | 0.161 (0.074) | 0.291 (0.291) | 0.000 | - | 8: 26.5, 0: 19.9, 40: 17.9, 760: 12.5, 24: 11.2 |
| 4 | vanilla | yes | 1.596 | 9.298 | 21.674 | 0 | 0.161 (0.074) | 0.325 (0.325) | 0.000 | - | 8: 21.7, 56: 16.5, 0: 16.1, 595: 14.6, 216: 14.4 |
| 4 | quicksilver | yes | 1.542 | 7.515 | 24.178 | 0 | 0.164 (0.082) | 0.287 (0.286) | 0.000 | - | 8: 24.2, 0: 16.1, 24: 13.7, 75: 13.0, 242: 12.6 |
| 5 | vanilla | yes | 1.548 | 8.094 | 33.577 | 0 | 0.171 (0.078) | 0.307 (0.307) | 0.000 | - | 8: 33.6, 248: 27.5, 0: 17.6, 24: 15.6, 40: 14.5 |
| 5 | quicksilver | yes | 1.510 | 7.616 | 21.792 | 0 | 0.169 (0.070) | 0.309 (0.309) | 0.000 | - | 40: 21.8, 8: 21.6, 0: 18.6, 488: 14.5, 338: 13.4 |
| 6 | vanilla | yes | 1.558 | 8.479 | 21.553 | 0 | 0.174 (0.080) | 0.342 (0.342) | 0.000 | - | 8: 21.6, 0: 19.3, 169: 16.4, 91: 15.5, 40: 13.9 |
| 6 | quicksilver | yes | 1.524 | 7.078 | 24.096 | 0 | 0.172 (0.080) | 0.278 (0.278) | 0.000 | - | 8: 24.1, 40: 20.5, 0: 18.1, 24: 15.8, 282: 12.9 |
| 7 | vanilla | yes | 1.625 | 9.427 | 21.522 | 0 | 0.156 (0.071) | 0.295 (0.295) | 0.000 | - | 8: 21.5, 0: 18.0, 568: 17.8, 40: 17.1, 616: 16.9 |
| 7 | quicksilver | yes | 1.535 | 8.034 | 26.477 | 0 | 0.157 (0.068) | 0.312 (0.312) | 0.000 | - | 8: 26.5, 1016: 18.7, 0: 16.7, 40: 14.0, 868: 13.4 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 1.562 | 1.535 | 0.975 (0.94 to 1.00) |
| MSPT p99 | 8.094 | 7.515 | 0.935 (0.81 to 0.97) |
| slowest tick (ms) | 23.482 | 24.178 | 1.116 (0.65 to 1.34) |
| ticks over 50 ms | 0 | 0 | - (- to -) |
| chunk load, ms per tick (server thread) | 0.167 | 0.169 | 1.006 (0.99 to 1.13) |
|   of it in the tick | 0.074 | 0.077 | 1.000 (0.89 to 1.10) |
| chunk save, ms per tick (server thread) | 0.325 | 0.298 | 0.936 (0.81 to 1.06) |
|   of it in the tick | 0.325 | 0.298 | 0.936 (0.81 to 1.06) |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 59836 ms, 19433 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 396 / 0 | 1 / 0 | 0.331 | 384.9 |
| entity save | 20 / 0 | 0 / 0 | 0.017 | 6.4 |
| POI save | 4 / 0 | 0 / 0 | 0.003 | 0.8 |
| chunk load | 0 / 0 | 49 / 2 | 0.043 | 75.9 |
| chunk to full (promote) | 91 / 0 | 50 / 0 | 0.117 | 36.6 |
| entity load | 8 / 1 | 2 / 0 | 0.009 | 1.8 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 14 / 0 | 0 / 0 | 0.012 | 8.9 |
| light | 0 / 0 | 4 / 0 | 0.003 | 0.0 |
| chunk system (tickets, holders, tasks) | 388 / 2 | 207 / 0 | 0.497 | 215.5 |
| tick, other | 445 / 0 | 0 / 0 | 0.371 | 1.8 |
| idle or other | 0 / 0 | 65 / 0 | 0.054 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1235, MinecraftServer.lambda$spin$0 1235, Thread.run 1233, MinecraftServer.tickServer 924, MinecraftServer.processPacketsAndTick 924, DedicatedServer.tickServer 924, MinecraftServer.tickChildren 915, ServerLevel.tick 915, ServerChunkCache.tick 872, ChunkMap.tick 430, ChunkMap.processUnloads 411, ChunkMap.saveChunksEagerly 381, ServerChunkCache.runDistanceManagerUpdates 372, DistanceManager.runAllUpdates 369, ServerChunkCache$MainThreadExecutor.pollTask 313, MinecraftServer.pollTask 312, MinecraftServer.pollTaskInternal 312, MinecraftServer.waitUntilNextTick 312, ServerChunkCache.pollTask 312, BlockableEventLoop.pollTask 305, ServerChunkCache$MainThreadExecutor.doRunTask 304, BlockableEventLoop.doRunTask 304, BlockableEventLoop.managedBlock 291, CompletableFuture$Completion.run 276, CompletableFuture$UniApply.tryFire 249, DynamicGraphMinFixedPoint.runUpdates 234, LoadingChunkTracker.runDistanceUpdates 234, ChunkMap.saveChunkIfNeeded 232, ChunkMap.save 211, SerializableChunkData.copyOf 207, ChunkTracker.checkNeighborsAfterUpdate 191, ChunkMap.lambda$prepareTickingChunk$1 190, ChunkResult$Success.map 190, ChunkMap.lambda$prepareTickingChunk$2 190, LevelChunk.postProcessGeneration 183, DynamicGraphMinFixedPoint.checkNeighbor 180, DynamicGraphMinFixedPoint.checkEdge 153, GenerationChunkHolder.getChunkIfPresentUnchecked 124, ChunkHolder.updateFutures 121, GenerationChunkHolder.getLatestChunk 119, Block.updateFromNeighbourShapes 116, LoadingChunkTracker.getLevel 98, ChunkTracker.getComputedLevel 95, PalettedContainer.get 94, Level.getBlockState 91, Long2ObjectLinkedOpenHashMap.get 85, LevelChunk.getBlockState 85, LevelChunkSection.getBlockState 83, LongOpenHashSet.contains 80, ChunkMap$DistanceManager.isChunkToRemove 80, ChunkMap.getChunkRangeFuture 74, ServerChunkCache.tickChunks 62, PalettedContainer.copy 60, LevelChunkSection.<init> 60, LevelChunkSection.copy 60, GenerationChunkHolder.scheduleChunkGenerationTask 58, ChunkGenerationTask.create 57, GenerationChunkHolder.rescheduleChunkTask 57, ChunkMap.scheduleGenerationTask 57, Encoder.encodeStart 56

Top chunk methods (self): GenerationChunkHolder.getChunkIfPresentUnchecked 98, PalettedContainer.get 87, Long2ObjectLinkedOpenHashMap.get 85, LongOpenHashSet.contains 80, PalettedContainer$Data.copy 46, DynamicGraphMinFixedPoint.checkEdge 41, Long2ObjectOpenHashMap.get 38, VarHandleReferences$Array.getVolatile 26, ChunkMap.saveChunksEagerly 24, Long2ByteOpenHashMap.get 22, Long2LongOpenHashMap.getOrDefault 20, Long2ObjectOpenHashMap.getOrDefault 14, LongLinkedOpenHashSet.add 12, ChunkTracker.checkNeighborsAfterUpdate 11, GenerationChunkHolder.increaseGenerationRefCount 11, ServerChunkCache.getChunk 10, PalettedContainer.copy 10, NaturalSpawner.createState 10, Block.updateFromNeighbourShapes 9, ChunkTracker.getComputedLevel 8, BlockBehaviour$BlockStateBase.updateShape 8, StateHolder.getNullableValue 8, ReferenceOpenHashSet.add 7, ConcurrentLinkedQueue.offer 7, CompletableFuture.postComplete 7, TicketStorage.removeTicketIf 6, DynamicGraphMinFixedPoint.runUpdates 6, StateHolder.valueIndex 6, Encoder$1.encode 6, SerializableChunkData.copyOf 6

Threads (all samples in the window): Netty Epoll IO  48748, IO-Worker 7897, Worker-Main 4048, Server thread 1749, JFR Periodic Tasks 9, JNA Cleaner 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 59808 ms, 19944 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 333 / 0 | 0 / 0 | 0.278 | 245.9 |
| entity save | 18 / 0 | 0 / 0 | 0.015 | 5.1 |
| POI save | 7 / 0 | 0 / 0 | 0.006 | 4.1 |
| chunk load | 0 / 0 | 52 / 2 | 0.045 | 68.3 |
| chunk to full (promote) | 79 / 0 | 54 / 0 | 0.111 | 17.7 |
| entity load | 15 / 0 | 2 / 0 | 0.014 | 1.9 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 8 / 0 | 0 / 0 | 0.007 | 9.9 |
| light | 0 / 0 | 2 / 0 | 0.002 | 0.9 |
| chunk system (tickets, holders, tasks) | 388 / 0 | 218 / 1 | 0.506 | 242.0 |
| tick, other | 463 / 2 | 0 / 0 | 0.388 | 1.7 |
| idle or other | 0 / 0 | 73 / 2 | 0.062 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 1177, MinecraftServer.runServer 1177, Thread.run 1174, DedicatedServer.tickServer 848, MinecraftServer.tickServer 848, MinecraftServer.processPacketsAndTick 848, MinecraftServer.tickChildren 839, ServerLevel.tick 839, ServerChunkCache.tick 787, ServerChunkCache.runDistanceManagerUpdates 364, ChunkMap.tick 359, DistanceManager.runAllUpdates 357, ChunkMap.processUnloads 342, MinecraftServer.pollTaskInternal 331, MinecraftServer.pollTask 331, ServerChunkCache$MainThreadExecutor.pollTask 330, ServerChunkCache.pollTask 330, MinecraftServer.waitUntilNextTick 329, BlockableEventLoop.pollTask 324, BlockableEventLoop.doRunTask 320, ServerChunkCache$MainThreadExecutor.doRunTask 319, ChunkMap.saveChunksEagerly 317, BlockableEventLoop.managedBlock 312, CompletableFuture$Completion.run 281, CompletableFuture$UniApply.tryFire 257, ChunkMap.saveChunkIfNeeded 238, DynamicGraphMinFixedPoint.runUpdates 231, LoadingChunkTracker.runDistanceUpdates 226, ChunkTracker.checkNeighborsAfterUpdate 200, DynamicGraphMinFixedPoint.checkNeighbor 195, ChunkResult$Success.map 193, ChunkMap.save 193, ChunkMap.lambda$prepareTickingChunk$2 192, ChunkMap.lambda$prepareTickingChunk$1 192, SerializableChunkData.copyOf 187, LevelChunk.postProcessGeneration 170, Long2ObjectLinkedOpenHashMap.get 160, DynamicGraphMinFixedPoint.checkEdge 126, ChunkHolder.updateFutures 118, Block.updateFromNeighbourShapes 108, LoadingChunkTracker.getLevel 107, ChunkTracker.getComputedLevel 106, ChunkMap.getUpdatingChunkIfPresent 85, ChunkMap$DistanceManager.getChunk 83, PalettedContainer.get 81, LevelChunk.getBlockState 77, Level.getBlockState 75, LevelChunkSection.getBlockState 74, ChunkMap.getChunkRangeFuture 73, ServerChunkCache.tickChunks 60, GenerationChunkHolder.scheduleChunkGenerationTask 56, ChunkGenerationTask.lambda$create$0 55, StaticCache2D.<init> 55, ChunkGenerationTask.create 55, ChunkMap.scheduleGenerationTask 55, ChunkMap.acquireGeneration 55, GenerationChunkHolder.rescheduleChunkTask 55, StaticCache2D.create 55, SerializableChunkData.read 54, ChunkMap.lambda$scheduleChunkLoad$3 54

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 160, PalettedContainer.get 70, Long2LongOpenHashMap.getOrDefault 54, ChunkTracker.getComputedLevel 36, GenerationChunkHolder.getChunkIfPresentUnchecked 32, Long2ByteOpenHashMap.get 29, LongOpenHashSet.contains 27, ChunkMap.saveChunksEagerly 23, Long2ObjectOpenHashMap.get 23, LevelChunkSection.<init> 20, DynamicGraphMinFixedPoint.checkNeighbor 19, PalettedContainer.create$quicksilver_$md$ca2364$0 18, ChunkMap.onLevelChange 12, ConcurrentLinkedQueue.offer 11, ServerChunkCache.getChunk 11, StateHolder.valueIndex 11, Long2ObjectFunctions$SynchronizedFunction.get 11, VarHandleReferences$Array.getVolatile 10, CompletableFuture.postComplete 9, Comparator.lambda$comparingLong$6043328a$1 9, ReferenceOpenHashSet.add 9, Long2ObjectOpenHashMap.getOrDefault 8, BlockBehaviour$BlockStateBase.updateShape 7, StateHolder.getNullableValue 7, DirectMethodHandle.allocateInstance 7, LongLinkedOpenHashSet.add 7, HashMap.getNode 6, CrudeIncrementalIntIdentityHashBiMap.byId 6, NaturalSpawner.createState 6, Long2ByteOpenHashMap.shiftKeys 6

Threads (all samples in the window): Netty Epoll IO  49283, IO-Worker 7289, Worker-Main 4345, Server thread 1719, JFR Periodic Tasks 7

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **ChunkMap.processUnloads** 2647: ChunkMap.saveChunksEagerly 2452, CompletableFuture$Completion.run 156, ChunkMap.scheduleUnload 11, LongOpenHashSet.iterator 4, LongOpenHashSet$SetIterator.remove 2, ConcurrentLinkedQueue.poll 2, Long2ObjectLinkedOpenHashMap.get 1, LongOpenHashSet$SetIterator.nextLong 1, Long2ObjectLinkedOpenHashMap.remove 1, Long2ObjectLinkedOpenHashMap.put 1, MinecraftServer.haveTime 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1789, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 397, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 156, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 82, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 36, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 5, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 3, ChunkMap.saveChunksEagerly > MinecraftServer.haveTime 2, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 2
- **DistanceManager.runAllUpdates** 2522: LoadingChunkTracker.runDistanceUpdates 1603, ChunkHolder.updateFutures 789, GenerationChunkHolder.updateHighestAllowedStatus 41, ReferenceOpenHashSet$SetIterator.next 11, ReferenceOpenHashSet.clear 8, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 4, ReferenceOpenHashSet.iterator 2, DistanceManager$PlayerTicketTracker.runAllUpdates 2, SimulationChunkTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1601, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 256, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 131, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 131, ChunkHolder.updateFutures > ChunkMap.onLevelChange 126, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 99, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 28, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 17, ReferenceOpenHashSet.clear > Arrays.fill 8, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 4, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 3, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 3
- **ChunkMap.saveChunksEagerly** 2452: ChunkMap.saveChunkIfNeeded 1789, GenerationChunkHolder.getLatestChunk 397, Long2ObjectLinkedOpenHashMap.get 82, LongLinkedOpenHashSet$SetIterator.nextLong 36, LongLinkedOpenHashSet.iterator 3, MinecraftServer.haveTime 2, LongLinkedOpenHashSet$SetIterator.remove 2, Util.getMillis 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1423, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 396, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 290, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 58, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 3, MinecraftServer.haveTime > Util.getNanos 2, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 2, Util.getMillis > Util.getNanos 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 1521: SerializableChunkData.copyOf 1487, SimpleRegionStorage.write 10, CompletableFuture.supplyAsync 10, ChunkMap.markPosition 5, Profiler.get 2, SectionStorage.flush 1, CompletableFuture.handle 1, ChunkAccess.tryMarkSaved 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 414, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 309, SerializableChunkData.copyOf > LightEngine.getDataLayerData 301, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 161, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 53, SerializableChunkData.copyOf > ReferencePipeline.toArray 43, SerializableChunkData.copyOf > DataLayer.copy 41, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 36, SimpleRegionStorage.write > IOWorker.store 10, SerializableChunkData.copyOf > ArrayList.add 9, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 8, SerializableChunkData.copyOf > Collections$UnmodifiableCollection.iterator 7
- **SerializableChunkData.copyOf** 1487: LevelChunkSection.copy 414, LevelChunk.getBlockEntityNbtForSaving 309, LightEngine.getDataLayerData 301, SerializableChunkData.packStructureData 161, LevelChunk.getTicksForSerialization 53, ReferencePipeline.toArray 43, DataLayer.copy 41, ChunkAccess.getBlockEntitiesPos 36, ArrayList.add 8, Collections$UnmodifiableCollection.iterator 7, Heightmap.getRawData 5, ChunkAccess.getAllStarts 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 411, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 304, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 298, SerializableChunkData.packStructureData > StructureStart.createTag 113, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 47, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 41, DataLayer.copy > DataLayer.<init> 26, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 19, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 15, ArrayList.add > ArrayList.add 9, Collections$UnmodifiableCollection.iterator > Collections$UnmodifiableCollection$1.<init> 7, SerializableChunkData.packStructureData > Collections$UnmodifiableMap$UnmodifiableEntrySet$1.next 6
- **LevelChunk.postProcessGeneration** 1193: Block.updateFromNeighbourShapes 721, FluidState.tick 188, BlockBehaviour$BlockStateBase.tick 150, LevelChunk.getBlockState 55, FluidState.isEmpty 15, UpgradeData.upgrade 10, LevelWriter.setBlock 9, ShortListIterator.next 6, ImmutableList.copyOf 6, LevelHeightAccessor.getSectionYFromSectionIndex 3, ShortArrayList$1.hasNext 3, ProtoChunk.unpackOffsetCoordinates 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 409, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 277, FluidState.tick > FlowingFluid.tick 188, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 150, LevelChunk.getBlockState > LevelChunkSection.getBlockState 55, LevelWriter.setBlock > Level.setBlock 9, ShortListIterator.next > ShortListIterator.next 6, UpgradeData.upgrade > Iterable.forEach 4, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 3, UpgradeData.upgrade > UpgradeData.upgradeSides 3, UpgradeData.upgrade > ArrayList.forEach 2, UpgradeData.upgrade > UpgradeData.upgradeInside 1
- **SerializableChunkData.read** 347: SerializableChunkData.unpackStructureStart 198, LevelChunkTicks.<init> 30, PoiManager.checkConsistencyWithBlocks 29, SerializableChunkData.unpackStructureReferences 28, ImposterProtoChunk.<init> 21, LevelChunk.<init> 8, ChunkAccess.addPackedPostProcess 4, ThreadedLevelLightEngine.retainData 4, ChunkAccess.setAllReferences 3, ChunkAccess.setHeightmap 3, Heightmap.primeHeightmaps 2, ThreadedLevelLightEngine.queueSectionData 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 193, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 27, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 25, ImposterProtoChunk.<init> > ProtoChunk.<init> 21, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 15, PoiManager.checkConsistencyWithBlocks > Util.ifElse 14, LevelChunk.<init> > ChunkAccess.<init> 5, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 4, ChunkAccess.addPackedPostProcess > ShortList.addAll 3, ChunkAccess.setAllReferences > HashMap.putAll 3, SerializableChunkData.unpackStructureStart > CompoundTag.keySet 3, LevelChunk.<init> > Int2ObjectOpenHashMap.<init> 2
- **LevelChunk.runPostLoad** 234: SerializableChunkData.lambda$postLoadChunk$0 234<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 194, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 15, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 14, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 5, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 3, SerializableChunkData.lambda$postLoadChunk$0 > ImmutableCollections$ListItr.next 1
- **LevelChunk.<init>** 8: ChunkAccess.<init> 5, Int2ObjectOpenHashMap.<init> 2, Heightmap$Types.values 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 3, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 2, ChunkAccess.<init> > Maps.newEnumMap 1, Heightmap$Types.values > Object.clone 1
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 2541: LoadingChunkTracker.runDistanceUpdates 1603, ChunkHolder.updateFutures 836, GenerationChunkHolder.updateHighestAllowedStatus 32, ReferenceOpenHashSet$SetIterator.next 12, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 9, ReferenceOpenHashSet.clear 5, SimulationChunkTracker.runAllUpdates 2, ReferenceOpenHashSet.iterator 2, DistanceManager$PlayerTicketTracker.runAllUpdates 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1603, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 233, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 174, ChunkHolder.updateFutures > ChunkMap.onLevelChange 148, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 107, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 106, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 22, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 16, ChunkHolder.updateFutures > CompletableFuture.complete 12, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 9, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 6, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 4
- **ChunkMap.processUnloads** 2392: ChunkMap.saveChunksEagerly 2193, CompletableFuture$Completion.run 162, ChunkMap.scheduleUnload 7, Long2ObjectLinkedOpenHashMap.put 4, ConcurrentLinkedQueue.size 3, LongOpenHashSet.iterator 3, ConcurrentLinkedQueue.poll 2, Long2ObjectLinkedOpenHashMap.remove 2, MinecraftServer.haveTime 1, LongOpenHashSet$SetIterator.remove 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1502, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 425, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 162, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 92, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 36, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 3, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 3, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 3, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 2, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 1
- **ChunkMap.saveChunksEagerly** 2193: ChunkMap.saveChunkIfNeeded 1502, GenerationChunkHolder.getLatestChunk 425, Long2ObjectLinkedOpenHashMap.get 92, LongLinkedOpenHashSet$SetIterator.nextLong 36, LongLinkedOpenHashSet.iterator 3, Util.getMillis 1, LongLinkedOpenHashSet$SetIterator.remove 1, MinecraftServer.haveTime 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1198, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 373, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 176, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 87, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 3, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 3, Util.getMillis > Util.getNanos 1, MinecraftServer.haveTime > Util.getNanos 1
- **ChunkMap.save** 1322: SerializableChunkData.copyOf 1283, CompletableFuture.supplyAsync 10, SimpleRegionStorage.write 8, ChunkMap.markPosition 7, DirectMethodHandle.allocateInstance 3, ChunkAccess.tryMarkSaved 1, Profiler.get 1, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 304, SerializableChunkData.copyOf > LightEngine.getDataLayerData 278, SerializableChunkData.copyOf > LevelChunkSection.copy 250, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 171, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 55, SerializableChunkData.copyOf > DataLayer.copy 39, SerializableChunkData.copyOf > ReferencePipeline.toArray 36, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 32, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 10, SimpleRegionStorage.write > IOWorker.store 8, SerializableChunkData.copyOf > ArrayList.add 7, ChunkMap.markPosition > Long2ByteOpenHashMap.put 7
- **SerializableChunkData.copyOf** 1283: LevelChunk.getBlockEntityNbtForSaving 304, LightEngine.getDataLayerData 278, LevelChunkSection.copy 250, SerializableChunkData.packStructureData 171, LevelChunk.getTicksForSerialization 55, DataLayer.copy 39, ReferencePipeline.toArray 36, ChunkAccess.getBlockEntitiesPos 32, ArrayList.add 7, Collections$UnmodifiableCollection$1.hasNext 6, LevelHeightAccessor.getSectionIndexFromSectionY 5, Heightmap.getRawData 5<br>two down: LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 294, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 274, LevelChunkSection.copy > LevelChunkSection.<init> 243, SerializableChunkData.packStructureData > StructureStart.createTag 121, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 53, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 36, DataLayer.copy > DataLayer.<init> 28, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 20, SerializableChunkData.packStructureData > Identifier.toString 10, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 9, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 9, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 8
- **LevelChunk.postProcessGeneration** 1244: Block.updateFromNeighbourShapes 728, FluidState.tick 196, BlockBehaviour$BlockStateBase.tick 168, LevelChunk.getBlockState 66, FluidState.isEmpty 25, LevelWriter.setBlock 15, ImmutableList.copyOf 8, LevelHeightAccessor.getSectionYFromSectionIndex 6, UpgradeData.upgrade 5, ShortListIterator.next 2<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 413, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 279, FluidState.tick > FlowingFluid.tick 196, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 168, LevelChunk.getBlockState > LevelChunkSection.getBlockState 63, LevelWriter.setBlock > Level.setBlock 15, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 6, UpgradeData.upgrade > Iterable.forEach 3, UpgradeData.upgrade > UpgradeData.upgradeInside 2, ShortListIterator.next > ShortListIterator.next 2, LevelChunk.getBlockState > LevelHeightAccessor.getSectionIndex 2, ImmutableList.copyOf > HashMap$KeySet.toArray 1
- **SerializableChunkData.read** 365: SerializableChunkData.unpackStructureStart 214, LevelChunkTicks.<init> 40, PoiManager.checkConsistencyWithBlocks 29, SerializableChunkData.unpackStructureReferences 22, ImposterProtoChunk.<init> 20, LevelChunk.<init> 9, ChunkAccess.setAllReferences 5, ChunkAccess.setAllStarts 3, ThreadedLevelLightEngine.queueSectionData 3, ChunkAccess.setHeightmap 3, ChunkAccess.setLightCorrect 2, Heightmap.primeHeightmaps 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 212, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 38, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 21, ImposterProtoChunk.<init> > ProtoChunk.<init> 20, PoiManager.checkConsistencyWithBlocks > Util.ifElse 15, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 14, LevelChunk.<init> > ChunkAccess.<init> 6, ChunkAccess.setAllReferences > HashMap.putAll 5, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 3, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 2, ChunkAccess.setAllStarts > HashMap.putAll 1, LevelChunk.<init> > Heightmap.<init> 1
- **LevelChunk.runPostLoad** 239: SerializableChunkData.lambda$postLoadChunk$0 237<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 200, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 14, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 8, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 5, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 5
- **LevelChunk.<init>** 9: ChunkAccess.<init> 6, Heightmap.<init> 1, Int2ObjectOpenHashMap.<init> 1, EnumMap.put 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 4, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1, ChunkAccess.<init> > Object2ObjectOpenHashMap.<init> 1, ChunkAccess.<init> > LevelHeightAccessor.getSectionsCount 1, EnumMap.put > EnumMap.put 1
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 1614 | 6015 | 3545 | 1830 | 640 | 233 (first [-1, -16]) |
| 1 | quicksilver | 1614 | 6015 | 3644 | 2014 | 357 | 256 (first [-1, -18]) |
| 2 | vanilla | 1614 | 6015 | 3609 | 1876 | 530 | 242 (first [-1, -16]) |
| 2 | quicksilver | 1614 | 6015 | 3734 | 1903 | 378 | 273 (first [-1, -16]) |
| 3 | vanilla | 1614 | 6015 | 3562 | 1758 | 695 | 262 (first [-1, 17]) |
| 3 | quicksilver | 1614 | 6015 | 3548 | 1895 | 572 | 311 (first [-1, -16]) |
| 4 | vanilla | 1614 | 6016 | 3597 | 1848 | 571 | 279 (first [-1, -16]) |
| 4 | quicksilver | 1614 | 6015 | 3657 | 1943 | 415 | 267 (first [-1, -18]) |
| 5 | vanilla | 1614 | 6015 | 3626 | 1823 | 566 | 295 (first [-1, -16]) |
| 5 | quicksilver | 1614 | 6015 | 3561 | 2001 | 453 | 239 (first [-1, -16]) |
| 6 | vanilla | 1614 | 6015 | 3567 | 1792 | 656 | 293 (first [-10, -17]) |
| 6 | quicksilver | 1614 | 6015 | 3718 | 1995 | 302 | 242 (first [-1, -17]) |
| 7 | vanilla | 1614 | 6015 | 3745 | 1795 | 475 | 354 (first [-1, -16]) |
| 7 | quicksilver | 1614 | 6015 | 3621 | 1931 | 463 | 249 (first [-1, -19]) |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (1) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 815 (217) | 0 (0) | LastUpdate 211, block_ticks 539, fluid_ticks 458 | 1527 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 706 (0) | 0 (0) | LastUpdate 210, block_ticks 434, fluid_ticks 408, sections 1 | 1524 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 743 (216) | 0 (0) | LastUpdate 232, block_ticks 466, fluid_ticks 416 | 1533 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 836 (0) | 0 (0) | LastUpdate 283, block_ticks 498, fluid_ticks 478, sections 4 | 1512 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 856 (304) | 0 (0) | LastUpdate 245, block_ticks 548, fluid_ticks 503, sections 1 | 1521 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 785 (0) | 0 (0) | LastUpdate 223, block_ticks 483, fluid_ticks 471, sections 3 | 1520 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 746 (213) | 0 (0) | LastUpdate 204, block_ticks 479, fluid_ticks 419 | 1509 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 775 (0) | 0 (0) | LastUpdate 214, block_ticks 492, fluid_ticks 468 | 1524 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 780 (248) | 0 (0) | LastUpdate 176, block_ticks 506, fluid_ticks 450, sections 4 | 1519 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 844 (0) | 0 (0) | LastUpdate 233, block_ticks 543, fluid_ticks 487 | 1544 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 814 (204) | 0 (0) | LastUpdate 223, block_ticks 521, fluid_ticks 485 | 1515 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 24 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 788 (0) | 0 (0) | LastUpdate 211, block_ticks 504, fluid_ticks 435 | 1508 / 1681 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 829 (263) | 0 (0) | LastUpdate 247, block_ticks 540, fluid_ticks 442 | 1517 / 1681 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 6 data, 0 bytes only, 0 one side, keys DataVersion 10, Entities 11, Position 10; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1115 data, 0 bytes only, 0 one side, keys LastUpdate 1374, block_ticks 2954, fluid_ticks 2747, sections 8

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.520 | 0.709 | 2295.889 | 7 | 0.001 (0.001) | 0.027 (0.027) | 0.027 | 5742 (35.7) | 700: 2295.9, 2200: 108.7, 1000: 105.8, 3100: 94.8, 100: 77.8 |
| 1 | quicksilver | yes | 0.542 | 1.399 | 2350.189 | 6 | 0.000 (0.000) | 0.029 (0.028) | 0.028 | 5747 (37.6) | 700: 2350.2, 3100: 148.8, 1600: 100.9, 3700: 96.0, 100: 72.2 |
| 2 | vanilla | yes | 0.535 | 0.872 | 2325.686 | 7 | 0.001 (0.001) | 0.025 (0.025) | 0.025 | 5743 (34.0) | 700: 2325.7, 1600: 142.2, 2200: 95.1, 3100: 86.0, 3700: 67.9 |
| 2 | quicksilver | yes | 0.504 | 0.935 | 2192.363 | 7 | 0.001 (0.001) | 0.022 (0.021) | 0.021 | 5743 (56.7) | 700: 2192.4, 3400: 108.0, 2200: 96.0, 5743: 56.7, 1300: 55.6 |
| 3 | vanilla | yes | 0.556 | 0.957 | 2441.769 | 8 | 0.001 (0.001) | 0.042 (0.041) | 0.042 | 5742 (77.4) | 700: 2441.8, 2800: 104.8, 2200: 98.8, 3400: 91.4, 100: 85.1 |
| 3 | quicksilver | yes | 0.531 | 0.844 | 2304.628 | 6 | 0.000 (0.000) | 0.030 (0.030) | 0.029 | 5745 (37.9) | 700: 2304.6, 2800: 149.8, 1600: 102.0, 100: 80.2, 3100: 53.9 |
| 4 | vanilla | yes | 0.519 | 0.882 | 2283.536 | 8 | 0.000 (0.000) | 0.026 (0.026) | 0.025 | 5745 (57.2) | 700: 2283.5, 2200: 105.7, 1000: 91.9, 3100: 86.0, 100: 64.7 |
| 4 | quicksilver | yes | 0.525 | 1.482 | 2206.466 | 5 | 0.001 (0.001) | 0.026 (0.025) | 0.026 | 5747 (52.3) | 700: 2206.5, 3700: 143.3, 2200: 103.6, 100: 71.9, 5747: 52.3 |
| 5 | vanilla | yes | 0.552 | 1.057 | 2400.537 | 8 | 0.001 (0.001) | 0.041 (0.040) | 0.040 | 5745 (41.0) | 700: 2400.5, 2500: 101.6, 3400: 95.3, 100: 92.8, 1300: 91.8 |
| 5 | quicksilver | yes | 0.533 | 0.969 | 2276.826 | 8 | 0.000 (0.000) | 0.032 (0.032) | 0.032 | 5746 (32.5) | 700: 2276.8, 2500: 91.0, 2800: 86.0, 4006: 78.5, 3100: 73.7 |
| 6 | vanilla | yes | 0.525 | 0.647 | 2318.282 | 8 | 0.000 (0.000) | 0.032 (0.032) | 0.032 | 5743 (54.7) | 700: 2318.3, 1000: 111.5, 3400: 104.1, 3700: 88.7, 100: 88.6 |
| 6 | quicksilver | yes | 0.538 | 1.023 | 2397.418 | 7 | 0.001 (0.001) | 0.034 (0.034) | 0.034 | 5741 (31.1) | 700: 2397.4, 1000: 114.4, 2500: 101.7, 4336: 73.8, 1900: 61.0 |
| 7 | vanilla | yes | 0.547 | 1.174 | 2271.976 | 9 | 0.001 (0.001) | 0.031 (0.031) | 0.031 | 5740 (114.5) | 700: 2272.0, 5740: 114.5, 1900: 106.7, 3400: 104.3, 2800: 95.0 |
| 7 | quicksilver | yes | 0.496 | 1.151 | 1966.118 | 9 | 0.000 (0.000) | 0.035 (0.034) | 0.034 | 5743 (59.4) | 700: 1966.1, 1600: 98.1, 3400: 96.9, 400: 77.7, 100: 77.7 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 0.535 | 0.531 | 0.966 (0.91 to 1.04) |
| MSPT p99 | 0.882 | 1.023 | 1.072 (0.88 to 1.97) |
| slowest tick (ms) | 2318.282 | 2276.826 | 0.948 (0.87 to 1.03) |
| ticks over 50 ms | 8 | 7 | 0.875 (0.62 to 1.00) |
| chunk load, ms per tick (server thread) | 0.001 | 0.000 | 0.667 (0.43 to 2.50) |
|   of it in the tick | 0.001 | 0.000 | 0.667 (0.43 to 2.50) |
| chunk save, ms per tick (server thread) | 0.031 | 0.030 | 0.988 (0.72 to 1.12) |
|   of it in the tick | 0.031 | 0.030 | 0.992 (0.73 to 1.12) |
| autosave, ms per tick | 0.031 | 0.029 | 1.008 (0.70 to 1.10) |
| save-all tick (ms, mean of the script's) | 61.606 | 55.702 | 0.913 (0.84 to 1.00) |
| save-all flush tick (ms) | 2318.282 | 2276.826 | 0.948 (0.87 to 1.03) |
| autosave tick (ms, the game's own) | 54.662 | 37.933 | 0.794 (0.49 to 1.67) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 3665 ms, 25407 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 181 / 7 | 2 / 0 | 0.027 | 484.2 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 1.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 4 / 0 | 0 / 0 | 0.001 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 1 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 62 / 1 | 1 / 0 | 0.009 | 110.7 |
| tick, other | 160 / 6 | 0 / 0 | 0.024 | 6.1 |
| idle or other | 0 / 0 | 5 / 0 | 0.001 | 0.0 |

Top chunk methods (inclusive): Thread.run 260, MinecraftServer.runServer 260, MinecraftServer.lambda$spin$0 260, MinecraftServer.tickServer 258, MinecraftServer.processPacketsAndTick 258, DedicatedServer.tickServer 258, MinecraftServer.saveEverything 189, MinecraftServer.saveAllChunks 187, DedicatedServer.saveAllChunks 187, ServerLevel.save 181, ServerTickEvents.lambda$static$1 177, Harness.startTick 177, SaveAllCommand.saveAll 175, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 175, ContextChain.runExecutable$mixinextras$wrapped$10 175, CommandDispatcher.execute 175, ContextChain.runExecutable 175, ContextChain.executeAll 175, Harness.command 174, ServerChunkCache.save 161, ChunkMap.saveAllChunks 161, SaveAllCommand.lambda$register$0 154, ChunkMap.save 153, SerializableChunkData.copyOf 146, ChunkMap.saveChunkIfNeeded 141, ServerLevel.tick 66, MinecraftServer.tickChildren 66, ServerChunkCache.tick 62, LevelChunkSection.copy 54, LevelChunkSection.<init> 52, PalettedContainer.copy 52, ServerChunkCache.tickChunks 51, NaturalSpawner.createState 46, PalettedContainer.<init> 46, PalettedContainer$Data.copy 45, ServerChunkCache.getFullChunk 41, ChunkResult$Success.ifSuccess 39, NaturalSpawner.lambda$createState$0 39, EnvironmentAttributeReader.getValue 36, EnvironmentAttributeSystem.getValue 35, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 34, EnvironmentAttributeSystem$ValueSampler.getValue 34, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 34, BiomeManager.getBiome 30, LevelReader.getNoiseBiome 28, LightEngine.getDataLayerData 25, LayerLightSectionStorage.getDataLayerData 25, ImposterProtoChunk.getNoiseBiome 21, PalettedContainer.get 21, LevelChunkSection.getNoiseBiome 21, ChunkAccess.getNoiseBiome 21, SaveAllCommand.lambda$register$1 21, LevelChunk.getBlockEntityNbtForSaving 19, AbstractPipeline.wrapAndCopyInto 19, AbstractPipeline.evaluate 19, AbstractPipeline.copyInto 19, BlockEntity.saveWithFullMetadata 18, Encoder.encodeStart 17, PersistentEntitySectionManager.storeChunkSections 17, ForEachOps$ForEachOp$OfRef.evaluateSequential 15

Top chunk methods (self): PalettedContainer$Data.copy 41, PalettedContainer.get 20, SerializableChunkData.copyOf 14, Long2ObjectOpenHashMap.get 14, Long2ObjectFunctions$SynchronizedFunction.get 6, PalettedContainer.copy 6, LayerLightSectionStorage.getDataLayerData 5, CompletableFuture.reportJoin 5, ServerChunkCache.getChunk 4, Long2ByteOpenHashMap.get 4, Object.clone 4, Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 3, HashMap.resize 3, UnixFileDispatcherImpl.write0 3, Arrays.copyOf 3, HashMap.putVal 3, DataLayer.<init> 3, SerializableChunkData.packStructureData 2, HashMap.put 2, LevelChunkSection.copy 2, Spliterators$ArraySpliterator.forEachRemaining 2, ServerChunkCache.tickChunks 2, NaturalSpawner.createState 2, DirectMethodHandle.allocateInstance 2, RegistryAccess$ImmutableRegistryAccess.lookup 2, TimSort.sort 2, TimSort.countRunAndMakeAscending 2, FileInputStream.readBytes 2, BlockableEventLoop.managedBlock 2, ChunkMap.saveAllChunks 2

Threads (all samples in the window): Netty Epoll IO  1821, Worker-Main 1142, IO-Worker 803, Server thread 433

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 3843 ms, 25872 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 181 / 14 | 3 / 0 | 0.028 | 219.5 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 3 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 3 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 2 / 0 | 0 / 0 | 0.000 | 0.5 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 127 / 1 | 1 / 0 | 0.018 | 185.1 |
| tick, other | 94 / 2 | 0 / 0 | 0.014 | 4.0 |
| idle or other | 0 / 0 | 4 / 0 | 0.001 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.tickServer 331, DedicatedServer.tickServer 331, MinecraftServer.runServer 330, MinecraftServer.processPacketsAndTick 330, MinecraftServer.lambda$spin$0 330, Thread.run 329, DedicatedServer.saveAllChunks 196, MinecraftServer.saveAllChunks 196, MinecraftServer.saveEverything 196, Harness.startTick 184, ServerTickEvents.lambda$static$1 183, ContextChain.runExecutable 182, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 182, ContextChain.executeAll 182, ContextChain.runExecutable$mixinextras$wrapped$10 182, CommandDispatcher.execute 182, Harness.command 182, SaveAllCommand.saveAll 182, ServerLevel.save 180, SaveAllCommand.lambda$register$0 164, ServerChunkCache.save 151, ChunkMap.saveAllChunks 151, ChunkMap.save 146, SerializableChunkData.copyOf 143, ChunkMap.saveChunkIfNeeded 136, MinecraftServer.tickChildren 133, ServerLevel.tick 133, ServerChunkCache.tick 71, ServerLevel.shouldTickBlocksAt 60, DistanceManager.inBlockTickingRange 60, LevelTicks.collectTicks 59, LevelTicks.tick 59, LevelTicks.sortContainersToTick 59, ServerChunkCache.isPositionTicking 59, ServerLevel.isPositionTickingWithEntitiesLoaded 59, ChunkLevel.isBlockTicking 58, ServerChunkCache.tickChunks 56, NaturalSpawner.createState 41, LevelChunkSection.copy 39, LevelChunkSection.<init> 37, PalettedContainer.copy 37, ServerChunkCache.getFullChunk 36, ChunkResult$Success.ifSuccess 32, NaturalSpawner.lambda$createState$0 30, AbstractPipeline.evaluate 29, Encoder.encodeStart 27, EnvironmentAttributeSystem.getValue 25, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 25, EnvironmentAttributeReader.getValue 25, EnvironmentAttributeSystem$ValueSampler.getValue 25, PersistentEntitySectionManager.storeChunkSections 24, AbstractPipeline.wrapAndCopyInto 24, LevelChunk.getBlockEntityNbtForSaving 23, LightEngine.getDataLayerData 23, AbstractPipeline.copyInto 23, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 22, PalettedContainer.handler$zom000$quicksilver$share 22, PalettedContainerInvoker.quicksilver$create 22, PalettedContainer.create$quicksilver_$md$4e2291$0 22, BlockEntity.saveWithFullMetadata 21

Top chunk methods (self): ChunkLevel.isBlockTicking 58, PalettedContainer.create$quicksilver_$md$4e2291$0 22, Long2ObjectOpenHashMap.get 20, PalettedContainer.copy 15, UnixFileDispatcherImpl.write0 13, Long2ByteOpenHashMap.get 9, PalettedContainer.get 9, ServerChunkCache.tickChunks 6, CompletableFuture.reportJoin 6, DataLayer.<init> 5, ShortArrayList.copyArrayFromSafe 4, SerializableChunkData.copyOf 4, Arrays.copyOf 3, TimSort.sort 3, Arrays.fill 3, TimSort.countRunAndMakeAscending 3, HashSet.<init> 3, RegularImmutableMap.get 3, DataLayer.copy 2, SectionPos.asLong 2, Formatter.<init> 2, Encoder.encodeStart 2, ChunkMap.processUnloads 2, RecordCodecBuilder$Instance.lambda$ap3$6 2, StreamOpFlag.fromCharacteristics 2, ServerChunkCache.getChunk 2, LevelChunkSection.copy 2, LivingEntity.addAdditionalSaveData 2, Entity.saveWithoutId 2, ReferencePipeline$3$1.accept 2

Threads (all samples in the window): Netty Epoll IO  1865, Worker-Main 1256, IO-Worker 809, Server thread 435

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 1548: DedicatedServer.saveAllChunks 1543, MinecraftServer.warnOnLowDiskSpace 4<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 1543, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 4
- **ServerLevel.save** 1448: ServerChunkCache.save 1293, PersistentEntitySectionManager.autoSave 117, PersistentEntitySectionManager.saveAll 23, ServerLevel.saveLevelData 15<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1292, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 110, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 19, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 14, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 6, PersistentEntitySectionManager.saveAll > EntityStorage.flush 3, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkCallSite 1, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 1
- **ChunkMap.saveAllChunks** 1292: ChunkMap.saveChunkIfNeeded 1192, ReferencePipeline.forEach 70, Long2ObjectLinkedOpenHashMap$ValueIterator.next 9, ReferencePipeline.toList 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1180, ReferencePipeline.forEach > AbstractPipeline.evaluate 70, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 7, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 4, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 3, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 2, ReferencePipeline.toList > ReferencePipeline.toArray 2, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 1244: SerializableChunkData.copyOf 1218, SimpleRegionStorage.write 13, CompletableFuture.supplyAsync 8, DirectMethodHandle.allocateInstance 1, CompletableFuture.handle 1, SectionStorage.flush 1, ChunkMap.markPosition 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 520, SerializableChunkData.copyOf > LightEngine.getDataLayerData 145, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 145, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 98, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 65, SerializableChunkData.copyOf > ReferencePipeline.toArray 33, SerializableChunkData.copyOf > DataLayer.copy 31, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 23, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 14, SimpleRegionStorage.write > IOWorker.store 13, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 9, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 8
- **SerializableChunkData.copyOf** 1218: LevelChunkSection.copy 520, LightEngine.getDataLayerData 145, LevelChunk.getBlockEntityNbtForSaving 145, SerializableChunkData.packStructureData 98, LevelChunk.getTicksForSerialization 65, ReferencePipeline.toArray 33, DataLayer.copy 31, ChunkAccess.getBlockEntitiesPos 23, Collections$UnmodifiableCollection$1.hasNext 14, LevelLightEngine.getMaxLightSection 9, ArrayList.add 8, Heightmap.getRawData 8<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 505, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 142, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 139, SerializableChunkData.packStructureData > StructureStart.createTag 74, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 58, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 31, DataLayer.copy > DataLayer.<init> 16, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 12, ArrayList.add > ArrayList.add 8, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 7, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 6, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 6
- **PersistentEntitySectionManager.autoSave** 117: AbstractLongCollection.forEach 110, PersistentEntitySectionManager.getAllChunksToSave 6, MethodHandleNatives.linkCallSite 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 110, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 2, MethodHandleNatives.linkCallSite > MethodHandleNatives.linkCallSiteImpl 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$MapEntry.getLongKey 1
- **ChunkMap.processUnloads** 13: ChunkMap.saveChunksEagerly 7, LongOpenHashSet.iterator 3, ConcurrentLinkedQueue.size 1<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 1
- **ChunkMap.saveChunksEagerly** 7: Util.getMillis 2<br>two down: Util.getMillis > Util.getNanos 2
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 1416: DedicatedServer.saveAllChunks 1410, MinecraftServer.warnOnLowDiskSpace 6<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 1410, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 6
- **ServerLevel.save** 1316: ServerChunkCache.save 1136, PersistentEntitySectionManager.autoSave 130, ServerLevel.saveLevelData 28, PersistentEntitySectionManager.saveAll 21<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1135, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 125, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 27, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 18, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 5, PersistentEntitySectionManager.saveAll > EntityStorage.flush 2, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 1, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 1
- **ChunkMap.saveAllChunks** 1135: ChunkMap.saveChunkIfNeeded 1024, ReferencePipeline.forEach 85, Long2ObjectLinkedOpenHashMap$ValueIterator.next 7, ReferencePipeline.toList 2, Long2LongOpenHashMap.clear 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1010, ReferencePipeline.forEach > AbstractPipeline.evaluate 85, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 6, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 6, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 4, ReferencePipeline.toList > ReferencePipeline.toArray 2, Long2LongOpenHashMap.clear > Arrays.fill 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 1090: SerializableChunkData.copyOf 1070, CompletableFuture.supplyAsync 10, SimpleRegionStorage.write 4, ChunkMap.markPosition 3, CompletableFuture.handle 1, DirectMethodHandle.allocateInstance 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 363, SerializableChunkData.copyOf > LightEngine.getDataLayerData 168, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 139, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 117, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 71, SerializableChunkData.copyOf > ReferencePipeline.toArray 30, SerializableChunkData.copyOf > DataLayer.copy 28, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 22, SerializableChunkData.copyOf > ArrayList.add 11, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 10, SerializableChunkData.copyOf > Heightmap.getRawData 9, SerializableChunkData.copyOf > ChunkAccess.getHeightmaps 6
- **SerializableChunkData.copyOf** 1070: LevelChunkSection.copy 363, LightEngine.getDataLayerData 168, LevelChunk.getBlockEntityNbtForSaving 139, SerializableChunkData.packStructureData 117, LevelChunk.getTicksForSerialization 71, ReferencePipeline.toArray 30, DataLayer.copy 28, ChunkAccess.getBlockEntitiesPos 22, ArrayList.add 11, Heightmap.getRawData 9, ChunkAccess.getHeightmaps 6, LevelLightEngine.getMaxLightSection 5<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 337, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 160, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 137, SerializableChunkData.packStructureData > StructureStart.createTag 86, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 63, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 29, DataLayer.copy > DataLayer.<init> 21, ArrayList.add > ArrayList.add 11, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 10, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 10, LightEngine.getDataLayerData > SectionPos.asLong 7, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 5
- **PersistentEntitySectionManager.autoSave** 130: AbstractLongCollection.forEach 125, PersistentEntitySectionManager.getAllChunksToSave 5<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 125, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 4
- **ChunkMap.processUnloads** 16: ChunkMap.saveChunksEagerly 10, ConcurrentLinkedQueue.size 1, LongOpenHashSet.iterator 1<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 2, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1
- **ChunkMap.saveChunksEagerly** 10: Util.getMillis 2, LongLinkedOpenHashSet.iterator 1<br>two down: Util.getMillis > Util.getNanos 2, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 625 | 2878 | 2878 | 0 | 0 | 0 |
| 1 | quicksilver | 625 | 2964 | 2964 | 0 | 0 | 0 |
| 2 | vanilla | 625 | 2864 | 2864 | 0 | 0 | 0 |
| 2 | quicksilver | 625 | 2995 | 2981 | 0 | 14 | 0 |
| 3 | vanilla | 625 | 2920 | 2920 | 0 | 0 | 0 |
| 3 | quicksilver | 625 | 2791 | 2791 | 0 | 0 | 0 |
| 4 | vanilla | 625 | 2872 | 2872 | 0 | 0 | 0 |
| 4 | quicksilver | 625 | 3228 | 2981 | 0 | 247 | 0 |
| 5 | vanilla | 625 | 2781 | 2781 | 0 | 0 | 0 |
| 5 | quicksilver | 625 | 2848 | 2848 | 0 | 0 | 0 |
| 6 | vanilla | 625 | 2809 | 2809 | 0 | 0 | 0 |
| 6 | quicksilver | 625 | 2974 | 2974 | 0 | 0 | 0 |
| 7 | vanilla | 625 | 2981 | 2920 | 0 | 61 | 0 |
| 7 | quicksilver | 625 | 2930 | 2930 | 0 | 0 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 455 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 4 (0) | 0 (0) | DataVersion 2, Entities 4, Position 2 | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 466 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 508 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 472 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 438 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 491 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 472 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 507 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 460 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 460 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 469 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 467 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 468 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 4 data, 0 bytes only, 0 one side, keys DataVersion 8, Entities 14, Position 8; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

## core / kill: a kill -9 mid-save (save-all flush of 625 changed chunks)

| run | killed mid-save | chunks: complete save's / its at another tick / saved terrain's / other / unreadable (region) | entities, poi: other / unreadable | reloaded |
|---|---|---|---|---|
| quicksilver-killed1 | yes | 9530 / 186 / 85 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| quicksilver-killed2 | yes | 9568 / 151 / 82 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed1 | yes | 9605 / 114 / 82 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed2 | yes | 9631 / 89 / 81 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
quicksilver-complete1 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0

quicksilver-complete2 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0


Each chunk of a killed save is either the complete save's (possibly written at another tick: it differs only in LastUpdate, block_ticks, fluid_ticks) or the saved terrain's: a kill loses the chunks not yet written, and breaks none. Entity and POI files are reported only (their data follows entity and POI timing, as in vanilla's own rounds).

## Failures

- core/flyover: msptMax, median per-round ratio to vanilla 1.116, over 1.10 (a regression)
