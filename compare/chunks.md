# Chunk scenes (P2-4)

## core / churn

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 17.214 | 257.143 | 2334.964 | 32 | 0.062 (0.057) | 1.443 (1.437) | 1.438 | - | 220: 2335.0, 128: 479.3, 87: 470.5, 103: 364.2, 400: 283.1 |
| 1 | quicksilver | yes | 16.050 | 227.506 | 2114.594 | 28 | 0.063 (0.062) | 1.173 (1.160) | 1.163 | - | 220: 2114.6, 87: 478.4, 128: 468.0, 103: 354.3, 21: 272.2 |
| 2 | vanilla | yes | 17.034 | 195.379 | 2642.688 | 28 | 0.058 (0.058) | 1.372 (1.365) | 1.363 | - | 220: 2642.7, 87: 533.4, 128: 514.6, 103: 357.2, 139: 228.3 |
| 2 | quicksilver | yes | 16.617 | 216.288 | 2362.367 | 26 | 0.062 (0.055) | 1.282 (1.275) | 1.268 | - | 220: 2362.4, 128: 520.8, 87: 455.8, 103: 381.9, 21: 297.4 |
| 3 | vanilla | yes | 17.035 | 248.870 | 2368.933 | 31 | 0.070 (0.060) | 1.320 (1.308) | 1.315 | - | 220: 2368.9, 87: 556.0, 128: 483.6, 103: 381.3, 21: 281.9 |
| 3 | quicksilver | yes | 16.984 | 230.226 | 2535.149 | 27 | 0.055 (0.048) | 1.110 (1.098) | 1.098 | - | 220: 2535.1, 87: 588.5, 128: 514.3, 103: 420.9, 139: 262.0 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 17.035 | 16.617 | 0.976 (0.93 to 1.00) |
| MSPT p99 | 248.870 | 227.506 | 0.925 (0.88 to 1.11) |
| slowest tick (ms) | 2368.933 | 2362.367 | 0.906 (0.89 to 1.07) |
| ticks over 50 ms | 31 | 27 | 0.875 (0.87 to 0.93) |
| chunk load, ms per tick (server thread) | 0.062 | 0.062 | 1.026 (0.79 to 1.06) |
|   of it in the tick | 0.058 | 0.055 | 0.943 (0.81 to 1.09) |
| chunk save, ms per tick (server thread) | 1.372 | 1.173 | 0.841 (0.81 to 0.93) |
|   of it in the tick | 1.365 | 1.160 | 0.839 (0.81 to 0.93) |
| autosave, ms per tick | 1.363 | 1.163 | 0.835 (0.81 to 0.93) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 10395 ms, 34097 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 770 / 89 | 4 / 0 | 1.438 | 1703.3 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 3 / 0 | 0 / 0 | 0.005 | 0.0 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 5 / 1 | 1 / 0 | 0.012 | 6.4 |
| chunk to full (promote) | 24 / 0 | 2 / 0 | 0.043 | 1.8 |
| entity load | 4 / 0 | 0 / 0 | 0.007 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 29 / 0 | 0 / 0 | 0.048 | 0.0 |
| light | 1 / 0 | 0 / 0 | 0.002 | 1.4 |
| chunk system (tickets, holders, tasks) | 355 / 82 | 9 / 0 | 0.743 | 254.4 |
| tick, other | 193 / 3 | 0 / 0 | 0.327 | 14.6 |
| idle or other | 0 / 0 | 14 / 0 | 0.023 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1369, MinecraftServer.lambda$spin$0 1368, Thread.run 1365, MinecraftServer.tickServer 1363, DedicatedServer.tickServer 1361, MinecraftServer.processPacketsAndTick 1360, CiChunks.startTick 1108, ServerTickEvents.lambda$static$1 1108, Harness.startTick 1108, MinecraftServer.saveEverything 863, CommandDispatcher.execute 863, SaveAllCommand.saveAll 863, SaveAllCommand.lambda$register$0 863, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 863, ContextChain.runExecutable 863, ContextChain.runExecutable$mixinextras$wrapped$10 863, ContextChain.executeAll 863, Harness.command 861, DedicatedServer.saveAllChunks 855, MinecraftServer.saveAllChunks 855, ServerLevel.save 741, ChunkMap.saveAllChunks 676, ServerChunkCache.save 676, ChunkMap.saveChunkIfNeeded 666, ChunkMap.save 661, SerializableChunkData.copyOf 646, LevelChunkSection.copy 365, LevelChunkSection.<init> 364, PalettedContainer.copy 364, PalettedContainer.<init> 339, PalettedContainer$Data.copy 307, ServerLevel.tick 258, MinecraftServer.tickChildren 258, ServerChunkCache.tick 250, ServerChunkCache.getChunk 242, Level.getChunk 242, Level.getBlockState 241, LevelReader.getChunk 241, ServerChunkCache.runDistanceManagerUpdates 227, DistanceManager.runAllUpdates 213, Level.setBlock 201, LevelWriter.setBlock 200, BlockBehaviour$BlockStateBase.updateNeighbourShapes 192, NeighborUpdater.executeShapeUpdate 192, CollectingNeighborUpdater.addAndRun 192, CollectingNeighborUpdater.shapeUpdate 192, CollectingNeighborUpdater.runUpdates 192, CollectingNeighborUpdater$ShapeUpdate.runNext 192, Level.neighborShapeChanged 192, DynamicGraphMinFixedPoint.runUpdates 162, LoadingChunkTracker.runDistanceUpdates 162, ChunkTracker.checkNeighborsAfterUpdate 139, DynamicGraphMinFixedPoint.checkNeighbor 137, DynamicGraphMinFixedPoint.checkEdge 116, BlockableEventLoop.managedBlock 106, LoadingChunkTracker.getLevel 103, LevelStorageSource$LevelStorageAccess.saveDataTag 102, LevelStorageSource$LevelStorageAccess.saveLevelData 93, ServerChunkCache.getChunkFutureMainThread 84, ChunkTracker.getComputedLevel 84

Top chunk methods (self): PalettedContainer$Data.copy 296, Thread.yield0 80, LongOpenHashSet.contains 58, UnixFileDispatcherImpl.write0 57, Long2ObjectLinkedOpenHashMap.get 49, ServerChunkCache.getChunk 47, Long2ObjectOpenHashMap.get 47, PalettedContainer.<init> 32, SerializableChunkData.copyOf 30, PalettedContainer.copy 25, LongLinkedOpenHashSet.add 23, Long2ObjectFunctions$SynchronizedFunction.get 22, ArrayList.grow 21, ConcurrentLinkedQueue.size 17, UnixNativeDispatcher.unlink0 16, ConcurrentLinkedQueue.offer 13, Long2ObjectOpenHashMap.getOrDefault 13, LayerLightSectionStorage.getDataLayerData 12, Object.clone 11, TicketStorage.addTicket 11, TimSort.countRunAndMakeAscending 10, Long2ByteOpenHashMap.get 10, HashMap.putVal 10, DataLayer.<init> 9, ReferencePipeline$3$1.accept 8, LongOpenHashSet.add 7, LongLinkedOpenHashSet.rehash 6, ChunkMap.onLevelChange 6, TicketStorage.removeTicketIf 6, ForkJoinPool$WorkQueue.growArray 6

Threads (all samples in the window): Worker-Main 6502, Netty Epoll IO  6244, Server thread 1589, IO-Worker 872, JFR Periodic Tasks 2, JNA Cleaner 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 9695 ms, 35400 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 637 / 53 | 7 / 1 | 1.163 | 1088.6 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 3 / 1 | 0 / 0 | 0.007 | 0.6 |
| POI save | 2 / 0 | 0 / 0 | 0.003 | 0.9 |
| chunk load | 6 / 0 | 1 / 0 | 0.012 | 19.2 |
| chunk to full (promote) | 29 / 1 | 0 / 0 | 0.050 | 5.5 |
| entity load | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 21 / 0 | 0 / 0 | 0.035 | 1.8 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 370 / 106 | 7 / 0 | 0.805 | 170.3 |
| tick, other | 214 / 3 | 0 / 0 | 0.362 | 114.3 |
| idle or other | 0 / 0 | 16 / 0 | 0.027 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1235, MinecraftServer.lambda$spin$0 1233, MinecraftServer.tickServer 1230, MinecraftServer.processPacketsAndTick 1229, DedicatedServer.tickServer 1229, Thread.run 1229, CiChunks.startTick 965, Harness.startTick 963, ServerTickEvents.lambda$static$1 961, ContextChain.executeAll 698, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 698, SaveAllCommand.lambda$register$0 698, SaveAllCommand.saveAll 698, ContextChain.runExecutable 698, ContextChain.runExecutable$mixinextras$wrapped$10 698, MinecraftServer.saveEverything 698, CommandDispatcher.execute 697, Harness.command 695, DedicatedServer.saveAllChunks 689, MinecraftServer.saveAllChunks 687, ServerLevel.save 621, ChunkMap.saveAllChunks 553, ServerChunkCache.save 553, ChunkMap.saveChunkIfNeeded 549, ChunkMap.save 537, SerializableChunkData.copyOf 519, MinecraftServer.tickChildren 271, ServerLevel.tick 271, ServerChunkCache.tick 266, ServerChunkCache.getChunk 259, Level.getChunk 259, LevelReader.getChunk 259, Level.getBlockState 259, LevelChunkSection.copy 249, LevelChunkSection.<init> 249, ServerChunkCache.runDistanceManagerUpdates 224, Level.setBlock 216, LevelWriter.setBlock 216, DistanceManager.runAllUpdates 216, CollectingNeighborUpdater.shapeUpdate 205, Level.neighborShapeChanged 205, CollectingNeighborUpdater$ShapeUpdate.runNext 205, CollectingNeighborUpdater.runUpdates 205, BlockBehaviour$BlockStateBase.updateNeighbourShapes 205, CollectingNeighborUpdater.addAndRun 205, NeighborUpdater.executeShapeUpdate 205, DynamicGraphMinFixedPoint.runUpdates 156, LoadingChunkTracker.runDistanceUpdates 156, PalettedContainer.handler$zom000$quicksilver$share 135, PalettedContainerInvoker.quicksilver$create 135, PalettedContainer.create$quicksilver_$md$a58ead$0 135, PalettedContainer.copy 135, BlockableEventLoop.managedBlock 125, DynamicGraphMinFixedPoint.checkNeighbor 123, ChunkTracker.checkNeighborsAfterUpdate 123, DynamicGraphMinFixedPoint.checkEdge 113, LoadingChunkTracker.getLevel 106, Thread.yield0 105, Thread.yield 105, BlockableEventLoop.waitForTasks 105

Top chunk methods (self): PalettedContainer.create$quicksilver_$md$a58ead$0 135, LevelChunkSection.<init> 114, Thread.yield0 105, Long2ObjectOpenHashMap.get 63, LongOpenHashSet.contains 58, Long2ObjectLinkedOpenHashMap.get 52, ServerChunkCache.getChunk 42, UnixFileDispatcherImpl.write0 32, SerializableChunkData.copyOf 27, TimSort.countRunAndMakeAscending 25, LayerLightSectionStorage.getDataLayerData 23, LongLinkedOpenHashSet.rehash 19, StrictQueue$QueueStrictQueue.push 17, DynamicGraphMinFixedPoint.checkEdge 13, LongLinkedOpenHashSet.add 12, Long2ByteOpenHashMap.get 11, DataLayer.<init> 11, ChunkMap.saveChunkIfNeeded 9, ConcurrentLinkedQueue.size 9, CompletableFuture.join 9, AbstractConsecutiveExecutor.schedule 9, UnixNativeDispatcher.unlink0 8, HashMap.putVal 7, ShortArrayList.copyArrayFromSafe 7, ForkJoinPool$WorkQueue.growArray 7, TicketStorage.removeTicketIf 6, Long2ObjectOpenHashMap$MapIterator.nextEntry 6, GenerationChunkHolder.increaseGenerationRefCount 5, LongOpenHashSet.add 5, Encoder$2.encode 5

Threads (all samples in the window): Worker-Main 6115, Netty Epoll IO  5958, Server thread 1479, IO-Worker 743, JFR Periodic Tasks 2, JNA Cleaner 1

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2470: DedicatedServer.saveAllChunks 2443, MinecraftServer.warnOnLowDiskSpace 26<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2443, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 26
- **ServerLevel.save** 2180: ServerChunkCache.save 1974, PersistentEntitySectionManager.autoSave 152, ServerLevel.saveLevelData 54<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1974, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 142, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 53, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 10
- **ChunkMap.saveAllChunks** 1974: ChunkMap.saveChunkIfNeeded 1946, Long2ObjectLinkedOpenHashMap$ValueIterator.next 8, Long2ObjectLinkedOpenHashMap$1.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1915, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 16, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 8, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1, Long2ObjectLinkedOpenHashMap$1.iterator > Long2ObjectLinkedOpenHashMap$ValueIterator.<init> 1
- **ChunkMap.save** 1915: SerializableChunkData.copyOf 1876, CompletableFuture.supplyAsync 22, SimpleRegionStorage.write 6, ChunkMap.markPosition 6, ChunkAccess.tryMarkSaved 2, CompletableFuture.handle 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 983, SerializableChunkData.copyOf > LightEngine.getDataLayerData 253, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 141, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 137, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 116, SerializableChunkData.copyOf > ReferencePipeline.toArray 63, SerializableChunkData.copyOf > DataLayer.copy 38, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 22, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 19, SerializableChunkData.copyOf > DataLayer.isEmpty 19, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 11, SimpleRegionStorage.write > IOWorker.store 6
- **SerializableChunkData.copyOf** 1876: LevelChunkSection.copy 983, LightEngine.getDataLayerData 253, LevelChunk.getTicksForSerialization 141, LevelChunk.getBlockEntityNbtForSaving 137, SerializableChunkData.packStructureData 116, ReferencePipeline.toArray 63, DataLayer.copy 38, ChunkAccess.getBlockEntitiesPos 19, DataLayer.isEmpty 19, Collections$UnmodifiableCollection$1.hasNext 10, LevelLightEngine.getMaxLightSection 6, ArrayList.add 5<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 981, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 251, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 137, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 132, SerializableChunkData.packStructureData > StructureStart.createTag 77, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 63, DataLayer.copy > DataLayer.<init> 36, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 10, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 9, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, ArrayList.add > ArrayList.add 6, SerializableChunkData.packStructureData > CompoundTag.put 6
- **DistanceManager.runAllUpdates** 651: LoadingChunkTracker.runDistanceUpdates 492, ChunkHolder.updateFutures 110, ReferenceOpenHashSet$SetIterator.next 10, GenerationChunkHolder.updateHighestAllowedStatus 8, ReferenceOpenHashSet.clear 6, DistanceManager$PlayerTicketTracker.runAllUpdates 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 492, ChunkHolder.updateFutures > ChunkMap.onLevelChange 56, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 32, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 12, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 7, ReferenceOpenHashSet.clear > Arrays.fill 6, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 5, GenerationChunkHolder.updateHighestAllowedStatus > ChunkLevel.generationStatus 1
- **PersistentEntitySectionManager.autoSave** 152: AbstractLongCollection.forEach 142, PersistentEntitySectionManager.getAllChunksToSave 10<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 142, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 5, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 1
- **ChunkMap.processUnloads** 84: ConcurrentLinkedQueue.size 49, ChunkMap.scheduleUnload 10, CompletableFuture$Completion.run 7, LongOpenHashSet$SetIterator.remove 6, Long2ObjectLinkedOpenHashMap.remove 5, Long2ObjectLinkedOpenHashMap.put 3, LongOpenHashSet$SetIterator.nextLong 2<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 7, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 4, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 4, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 3, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 3, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 3, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 2
- **SerializableChunkData.read** 24: PoiManager.checkConsistencyWithBlocks 13, SerializableChunkData.unpackStructureReferences 4, LevelChunk.<init> 3, ThreadedLevelLightEngine.retainData 2, LevelChunkTicks.<init> 2<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 11, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 4, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 2, LevelChunk.<init> > Heightmap.<init> 1, LevelChunk.<init> > ChunkAccess.<init> 1, PoiManager.checkConsistencyWithBlocks > DirectMethodHandle.allocateInstance 1, LevelChunk.<init> > Int2ObjectOpenHashMap.<init> 1, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 1, PoiManager.checkConsistencyWithBlocks > Util.ifElse 1
- **LevelChunk.runPostLoad** 23: SerializableChunkData.lambda$postLoadChunk$0 23<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 20, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 1
- **LevelChunk.<init>** 3: Heightmap.<init> 1, ChunkAccess.<init> 1, Int2ObjectOpenHashMap.<init> 1<br>two down: Heightmap.<init> > ChunkAccess.getHeight 1, ChunkAccess.<init> > LevelHeightAccessor.getSectionsCount 1, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2118: DedicatedServer.saveAllChunks 2096, MinecraftServer.warnOnLowDiskSpace 22<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2094, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 22
- **ServerLevel.save** 1882: ServerChunkCache.save 1696, PersistentEntitySectionManager.autoSave 153, ServerLevel.saveLevelData 33<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1696, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 133, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 32, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 20
- **ChunkMap.saveAllChunks** 1696: ChunkMap.saveChunkIfNeeded 1671, Long2ObjectLinkedOpenHashMap$ValueIterator.next 11<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1638, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 14, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 11, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 2, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1
- **ChunkMap.save** 1638: SerializableChunkData.copyOf 1598, CompletableFuture.supplyAsync 19, SimpleRegionStorage.write 7, CompletableFuture.handle 6, ChunkMap.markPosition 5, SectionStorage.flush 2<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 720, SerializableChunkData.copyOf > LightEngine.getDataLayerData 249, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 134, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 122, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 104, SerializableChunkData.copyOf > DataLayer.copy 54, SerializableChunkData.copyOf > ReferencePipeline.toArray 46, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 30, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 22, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 19, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 13, SerializableChunkData.copyOf > ArrayList.add 10
- **SerializableChunkData.copyOf** 1598: LevelChunkSection.copy 720, LightEngine.getDataLayerData 249, LevelChunk.getBlockEntityNbtForSaving 134, LevelChunk.getTicksForSerialization 122, SerializableChunkData.packStructureData 104, DataLayer.copy 54, ReferencePipeline.toArray 46, Collections$UnmodifiableCollection$1.hasNext 30, LevelLightEngine.getMaxLightSection 22, ChunkAccess.getBlockEntitiesPos 13, ArrayList.add 10, ChunkAccess.getHeightmaps 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 716, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 247, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 127, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 120, SerializableChunkData.packStructureData > StructureStart.createTag 74, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 46, DataLayer.copy > DataLayer.<init> 46, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 22, ArrayList.add > ArrayList.add 10, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 7, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 7, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 6
- **DistanceManager.runAllUpdates** 712: LoadingChunkTracker.runDistanceUpdates 538, ChunkHolder.updateFutures 140, GenerationChunkHolder.updateHighestAllowedStatus 9, ReferenceOpenHashSet$SetIterator.next 8, ReferenceOpenHashSet.clear 6<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 537, ChunkHolder.updateFutures > ChunkMap.onLevelChange 86, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 38, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 9, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 6, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 5, ReferenceOpenHashSet.clear > Arrays.fill 5, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 1
- **PersistentEntitySectionManager.autoSave** 153: AbstractLongCollection.forEach 133, PersistentEntitySectionManager.getAllChunksToSave 20<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 133, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 9, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 2, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 2, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 1
- **ChunkMap.processUnloads** 76: ConcurrentLinkedQueue.size 43, CompletableFuture$Completion.run 12, ChunkMap.scheduleUnload 6, LongOpenHashSet$SetIterator.remove 5, Long2ObjectLinkedOpenHashMap.remove 2, LongOpenHashSet.iterator 1, ChunkMap.saveChunksEagerly 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 12, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 4, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 1, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1, ChunkMap.saveChunksEagerly > Util.getMillis 1, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 1
- **SerializableChunkData.read** 28: PoiManager.checkConsistencyWithBlocks 13, SerializableChunkData.unpackStructureReferences 5, SerializableChunkData.unpackStructureStart 2, LevelChunkTicks.<init> 2, LevelHeightAccessor.getSectionsCount 1, ImposterProtoChunk.<init> 1, LevelChunk.<init> 1, Objects.equals 1, ChunkAccess.addPackedPostProcess 1, ChunkAccess.setAllStarts 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 11, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 5, PoiManager.checkConsistencyWithBlocks > Util.ifElse 1, LevelHeightAccessor.getSectionsCount > LevelHeightAccessor.getMaxSectionY 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 1, LevelChunk.<init> > ChunkAccess.<init> 1, Objects.equals > ChunkPos.equals 1, ChunkAccess.addPackedPostProcess > ShortList.addAll 1
- **LevelChunk.runPostLoad** 18: SerializableChunkData.lambda$postLoadChunk$0 18<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 14, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 3
- **SectionStorage.flush** 2: LongLinkedOpenHashSet.remove 2<br>two down: 
- **ChunkMap.saveChunksEagerly** 1: Util.getMillis 1<br>two down: Util.getMillis > Util.getNanos 1
- **LevelChunk.<init>** 1: ChunkAccess.<init> 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 357 | 13651 | 13299 | 0 | 352 | 0 |
| 1 | quicksilver | 357 | 13046 | 13046 | 0 | 0 | 0 |
| 2 | vanilla | 357 | 13266 | 13261 | 0 | 5 | 0 |
| 2 | quicksilver | 357 | 12805 | 12805 | 0 | 0 | 0 |
| 3 | vanilla | 357 | 12995 | 12995 | 0 | 0 | 0 |
| 3 | quicksilver | 357 | 12853 | 12851 | 0 | 2 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-3 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 248 / 357 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 2 / 7 | 1 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 279 / 357 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 269 / 357 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 255 / 357 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 261 / 357 | 0 |

Vanilla's noise (rounds 2-3 against 1): dimensions/minecraft/overworld/entities: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 1.902 | 10.998 | 26.643 | 0 | 0.211 (0.102) | 0.347 (0.347) | 0.000 | - | 216: 26.6, 8: 26.6, 0: 24.6, 560: 23.9, 40: 18.9 |
| 1 | quicksilver | yes | 1.860 | 11.244 | 31.247 | 0 | 0.195 (0.089) | 0.305 (0.305) | 0.000 | - | 8: 31.2, 40: 26.6, 1152: 22.0, 368: 20.7, 1080: 20.5 |
| 2 | vanilla | yes | 1.997 | 11.419 | 27.314 | 0 | 0.204 (0.111) | 0.373 (0.373) | 0.000 | - | 8: 27.3, 0: 20.6, 40: 18.2, 1072: 16.1, 331: 14.8 |
| 2 | quicksilver | yes | 1.803 | 8.748 | 32.552 | 0 | 0.219 (0.093) | 0.316 (0.316) | 0.000 | - | 8: 32.6, 40: 22.7, 33: 22.2, 88: 22.2, 0: 21.8 |
| 3 | vanilla | yes | 1.954 | 10.492 | 36.132 | 0 | 0.223 (0.108) | 0.361 (0.361) | 0.000 | - | 40: 36.1, 8: 26.0, 0: 23.8, 888: 19.4, 260: 15.1 |
| 3 | quicksilver | yes | 1.913 | 9.874 | 28.168 | 0 | 0.204 (0.106) | 0.358 (0.358) | 0.000 | - | 8: 28.2, 0: 19.5, 40: 19.3, 602: 13.0, 24: 12.8 |
| 4 | vanilla | yes | 1.998 | 9.176 | 32.962 | 0 | 0.226 (0.106) | 0.362 (0.362) | 0.000 | - | 195: 33.0, 8: 25.2, 0: 24.4, 40: 23.6, 24: 17.8 |
| 4 | quicksilver | yes | 1.952 | 9.343 | 27.077 | 0 | 0.227 (0.101) | 0.347 (0.347) | 0.000 | - | 8: 27.1, 0: 20.6, 360: 19.5, 40: 16.7, 16: 11.4 |
| 5 | vanilla | yes | 2.077 | 13.234 | 23.243 | 0 | 0.207 (0.091) | 0.342 (0.342) | 0.000 | - | 1128: 23.2, 8: 23.1, 0: 19.9, 115: 19.7, 40: 18.5 |
| 5 | quicksilver | yes | 1.968 | 10.026 | 29.664 | 0 | 0.212 (0.101) | 0.334 (0.334) | 0.000 | - | 8: 29.7, 0: 22.9, 57: 20.1, 504: 19.1, 336: 17.9 |
| 6 | vanilla | yes | 1.985 | 9.636 | 29.886 | 0 | 0.203 (0.100) | 0.342 (0.342) | 0.000 | - | 8: 29.9, 40: 26.9, 1144: 21.5, 0: 19.6, 648: 18.8 |
| 6 | quicksilver | yes | 2.089 | 14.051 | 31.667 | 0 | 0.208 (0.102) | 0.344 (0.344) | 0.000 | - | 8: 31.7, 0: 21.7, 1024: 20.4, 27: 20.1, 40: 19.7 |
| 7 | vanilla | yes | 1.880 | 10.126 | 47.292 | 0 | 0.212 (0.098) | 0.347 (0.347) | 0.000 | - | 40: 47.3, 8: 25.0, 123: 20.7, 0: 20.0, 594: 15.8 |
| 7 | quicksilver | yes | 1.980 | 10.082 | 41.324 | 0 | 0.201 (0.097) | 0.339 (0.339) | 0.000 | - | 40: 41.3, 8: 31.6, 0: 25.9, 128: 23.0, 240: 19.1 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 1.985 | 1.952 | 0.978 (0.90 to 1.05) |
| MSPT p99 | 10.492 | 10.026 | 0.996 (0.76 to 1.46) |
| slowest tick (ms) | 29.886 | 31.247 | 1.060 (0.78 to 1.28) |
| ticks over 50 ms | 0 | 0 | - (- to -) |
| chunk load, ms per tick (server thread) | 0.211 | 0.208 | 1.004 (0.92 to 1.07) |
|   of it in the tick | 0.102 | 0.101 | 0.977 (0.84 to 1.11) |
| chunk save, ms per tick (server thread) | 0.347 | 0.339 | 0.976 (0.85 to 1.01) |
|   of it in the tick | 0.347 | 0.339 | 0.976 (0.85 to 1.01) |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 59792 ms, 21402 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 392 / 0 | 0 / 0 | 0.327 | 394.7 |
| entity save | 19 / 0 | 0 / 0 | 0.016 | 7.4 |
| POI save | 6 / 0 | 0 / 0 | 0.005 | 0.0 |
| chunk load | 0 / 0 | 67 / 4 | 0.059 | 57.0 |
| chunk to full (promote) | 111 / 0 | 55 / 0 | 0.138 | 36.6 |
| entity load | 11 / 0 | 5 / 0 | 0.013 | 1.7 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 13 / 0 | 0 / 0 | 0.011 | 8.9 |
| light | 0 / 0 | 2 / 0 | 0.002 | 1.1 |
| chunk system (tickets, holders, tasks) | 518 / 1 | 241 / 1 | 0.634 | 211.4 |
| tick, other | 509 / 0 | 0 / 0 | 0.424 | 8.0 |
| idle or other | 0 / 0 | 77 / 1 | 0.065 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1442, MinecraftServer.lambda$spin$0 1441, Thread.run 1440, DedicatedServer.tickServer 1071, MinecraftServer.tickServer 1071, MinecraftServer.processPacketsAndTick 1071, MinecraftServer.tickChildren 1059, ServerLevel.tick 1059, ServerChunkCache.tick 1005, ServerChunkCache.runDistanceManagerUpdates 489, DistanceManager.runAllUpdates 483, ChunkMap.tick 425, ChunkMap.processUnloads 407, ChunkMap.saveChunksEagerly 379, MinecraftServer.pollTaskInternal 374, ServerChunkCache.pollTask 374, MinecraftServer.pollTask 374, ServerChunkCache$MainThreadExecutor.pollTask 374, MinecraftServer.waitUntilNextTick 373, BlockableEventLoop.pollTask 367, BlockableEventLoop.managedBlock 363, BlockableEventLoop.doRunTask 358, ServerChunkCache$MainThreadExecutor.doRunTask 357, CompletableFuture$Completion.run 314, DynamicGraphMinFixedPoint.runUpdates 294, LoadingChunkTracker.runDistanceUpdates 293, CompletableFuture$UniApply.tryFire 292, ChunkTracker.checkNeighborsAfterUpdate 253, DynamicGraphMinFixedPoint.checkNeighbor 246, ChunkMap.saveChunkIfNeeded 234, ChunkResult$Success.map 212, ChunkMap.save 210, ChunkMap.lambda$prepareTickingChunk$1 209, SerializableChunkData.copyOf 209, ChunkMap.lambda$prepareTickingChunk$2 208, LevelChunk.postProcessGeneration 194, DynamicGraphMinFixedPoint.checkEdge 185, ChunkHolder.updateFutures 163, LoadingChunkTracker.getLevel 163, Long2ObjectLinkedOpenHashMap.get 150, ChunkTracker.getComputedLevel 125, Block.updateFromNeighbourShapes 120, GenerationChunkHolder.getChunkIfPresentUnchecked 118, GenerationChunkHolder.getLatestChunk 110, LongOpenHashSet.contains 94, ChunkMap$DistanceManager.isChunkToRemove 94, Level.getBlockState 88, PalettedContainer.get 85, ServerChunkCache.tickChunks 84, ChunkMap.getChunkRangeFuture 82, ChunkMap.getUpdatingChunkIfPresent 77, SerializableChunkData.read 71, ChunkMap.lambda$scheduleChunkLoad$3 71, ChunkMap$DistanceManager.getChunk 70, LevelChunk.getBlockState 70, LevelChunkSection.getBlockState 70, GenerationChunkHolder.scheduleChunkGenerationTask 67, LevelChunk.getBlockEntityNbtForSaving 66, ChunkMap.scheduleGenerationTask 65, GenerationChunkHolder.rescheduleChunkTask 65

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 150, GenerationChunkHolder.getChunkIfPresentUnchecked 107, LongOpenHashSet.contains 94, PalettedContainer.get 78, PalettedContainer$Data.copy 42, DynamicGraphMinFixedPoint.checkEdge 41, Long2ByteOpenHashMap.get 35, ChunkMap.saveChunksEagerly 22, Long2ObjectOpenHashMap.get 21, ServerChunkCache.getChunk 20, Long2LongOpenHashMap.getOrDefault 18, CompletableFuture.postComplete 16, ChunkMap.onLevelChange 15, HashMap.putVal 13, AbstractConsecutiveExecutor.schedule 13, DistanceManager.runAllUpdates 13, GenerationChunkHolder.increaseGenerationRefCount 12, NaturalSpawner.createState 12, StateHolder.valueIndex 12, ConcurrentLinkedQueue.offer 12, VarHandleReferences$Array.getVolatile 11, Long2ObjectFunctions$SynchronizedFunction.get 11, Long2ObjectOpenHashMap.getOrDefault 10, ChunkTracker.getComputedLevel 9, LocalCache.connectAccessOrder 9, LongLinkedOpenHashSet$SetIterator.nextLong 9, ConcurrentLinkedQueue.poll 8, ChunkMap.updateChunkScheduling 7, ObjectOpenCustomHashSet.add 7, LongLinkedOpenHashSet.add 7

Threads (all samples in the window): Netty Epoll IO  47174, IO-Worker 9171, Worker-Main 4781, Server thread 2033, JFR Periodic Tasks 7, JNA Cleaner 1, Reference Handler 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 59800 ms, 21803 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 341 / 0 | 0 / 0 | 0.284 | 205.0 |
| entity save | 18 / 1 | 0 / 0 | 0.016 | 8.2 |
| POI save | 6 / 0 | 0 / 0 | 0.005 | 0.0 |
| chunk load | 0 / 0 | 64 / 5 | 0.058 | 59.9 |
| chunk to full (promote) | 96 / 0 | 53 / 0 | 0.124 | 34.8 |
| entity load | 11 / 0 | 5 / 0 | 0.013 | 2.1 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 16 / 0 | 0 / 0 | 0.013 | 37.2 |
| light | 0 / 0 | 5 / 0 | 0.004 | 0.0 |
| chunk system (tickets, holders, tasks) | 496 / 0 | 283 / 0 | 0.649 | 229.9 |
| tick, other | 491 / 1 | 0 / 0 | 0.410 | 3.4 |
| idle or other | 0 / 0 | 84 / 0 | 0.070 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1398, MinecraftServer.lambda$spin$0 1398, Thread.run 1392, DedicatedServer.tickServer 985, MinecraftServer.processPacketsAndTick 985, MinecraftServer.tickServer 985, MinecraftServer.tickChildren 978, ServerLevel.tick 978, ServerChunkCache.tick 928, ServerChunkCache.runDistanceManagerUpdates 463, DistanceManager.runAllUpdates 449, ServerChunkCache$MainThreadExecutor.pollTask 414, MinecraftServer.pollTaskInternal 413, MinecraftServer.pollTask 413, MinecraftServer.waitUntilNextTick 413, ServerChunkCache.pollTask 413, BlockableEventLoop.managedBlock 400, BlockableEventLoop.pollTask 393, ServerChunkCache$MainThreadExecutor.doRunTask 383, BlockableEventLoop.doRunTask 383, ChunkMap.tick 380, ChunkMap.processUnloads 358, CompletableFuture$Completion.run 349, ChunkMap.saveChunksEagerly 325, CompletableFuture$UniApply.tryFire 315, LoadingChunkTracker.runDistanceUpdates 288, DynamicGraphMinFixedPoint.runUpdates 288, ChunkMap.saveChunkIfNeeded 279, ChunkTracker.checkNeighborsAfterUpdate 258, DynamicGraphMinFixedPoint.checkNeighbor 251, ChunkResult$Success.map 235, ChunkMap.lambda$prepareTickingChunk$1 234, ChunkMap.lambda$prepareTickingChunk$2 234, LevelChunk.postProcessGeneration 222, DynamicGraphMinFixedPoint.checkEdge 197, ChunkMap.save 186, SerializableChunkData.copyOf 183, LoadingChunkTracker.getLevel 147, ChunkHolder.updateFutures 141, Long2ObjectLinkedOpenHashMap.get 135, Block.updateFromNeighbourShapes 127, ChunkTracker.getComputedLevel 127, GenerationChunkHolder.getChunkIfPresentUnchecked 119, GenerationChunkHolder.getLatestChunk 113, PalettedContainer.get 95, Level.getBlockState 88, ServerChunkCache.tickChunks 83, ChunkMap.getUpdatingChunkIfPresent 81, ChunkMap.getChunkRangeFuture 80, ChunkMap$DistanceManager.getChunk 76, LevelChunk.getBlockState 75, LevelChunkSection.getBlockState 75, LongOpenHashSet.contains 72, ChunkMap$DistanceManager.isChunkToRemove 72, ChunkMap.lambda$scheduleChunkLoad$3 68, SerializableChunkData.read 66, NaturalSpawner.createState 61, GenerationChunkHolder.scheduleChunkGenerationTask 61, ChunkMap.scheduleGenerationTask 58, GenerationChunkHolder.rescheduleChunkTask 58

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 135, GenerationChunkHolder.getChunkIfPresentUnchecked 111, PalettedContainer.get 91, LongOpenHashSet.contains 72, DynamicGraphMinFixedPoint.checkEdge 37, Long2ByteOpenHashMap.get 31, PalettedContainer.create$quicksilver_$md$aa123b$0 26, Long2ObjectOpenHashMap.get 22, Long2ObjectFunctions$SynchronizedFunction.get 22, LongLinkedOpenHashSet.add 20, Long2ObjectOpenHashMap.getOrDefault 16, ChunkMap.saveChunksEagerly 16, Long2LongOpenHashMap.getOrDefault 14, ChunkMap.onLevelChange 14, NaturalSpawner.createState 13, ConcurrentLinkedQueue.offer 13, ArrayList.forEach 12, StateHolder.valueIndex 12, GenerationChunkHolder.increaseGenerationRefCount 11, ServerChunkCache.getChunk 11, LevelChunkSection.<init> 10, ChunkTracker.getComputedLevel 10, DataLayer.<init> 9, SerializableChunkData.copyOf 9, ServerChunkCache.tickChunks 8, ConcurrentLinkedQueue.poll 8, HashMap.getNode 8, AbstractConsecutiveExecutor.schedule 8, VarHandleReferences$Array.getVolatile 8, ChunkTracker.checkNeighborsAfterUpdate 7

Threads (all samples in the window): Netty Epoll IO  47308, IO-Worker 9126, Worker-Main 4848, Server thread 1976, JFR Periodic Tasks 2

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 3326: LoadingChunkTracker.runDistanceUpdates 2060, ChunkHolder.updateFutures 1077, GenerationChunkHolder.updateHighestAllowedStatus 80, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 14, ReferenceOpenHashSet$SetIterator.next 13, ReferenceOpenHashSet.clear 12, SimulationChunkTracker.runAllUpdates 4, DistanceManager$PlayerTicketTracker.runAllUpdates 4, ReferenceOpenHashSet.iterator 3<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 2060, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 298, ChunkHolder.updateFutures > ChunkMap.onLevelChange 229, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 215, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 156, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 122, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 59, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 20, ChunkHolder.updateFutures > CompletableFuture.complete 12, ReferenceOpenHashSet.clear > Arrays.fill 12, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 9, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 6
- **ChunkMap.processUnloads** 2878: ChunkMap.saveChunksEagerly 2646, CompletableFuture$Completion.run 173, ChunkMap.scheduleUnload 26, ConcurrentLinkedQueue.size 5, MinecraftServer.haveTime 5, Long2ObjectLinkedOpenHashMap.remove 3, ConcurrentLinkedQueue.poll 1, LongOpenHashSet$SetIterator.remove 1, LongOpenHashSet$SetIterator.nextLong 1, Long2ObjectLinkedOpenHashMap.put 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1808, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 542, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 172, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 84, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 55, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 14, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 5, MinecraftServer.haveTime > Util.getNanos 5, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 5, ChunkMap.saveChunksEagerly > Util.getMillis 3, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 2, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2
- **ChunkMap.saveChunksEagerly** 2646: ChunkMap.saveChunkIfNeeded 1808, GenerationChunkHolder.getLatestChunk 542, Long2ObjectLinkedOpenHashMap.get 84, LongLinkedOpenHashSet$SetIterator.nextLong 55, LongLinkedOpenHashSet$SetIterator.remove 5, Util.getMillis 3, LongLinkedOpenHashSet.iterator 1, MinecraftServer.haveTime 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1421, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 483, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 315, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 50, Util.getMillis > Util.getNanos 3, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 3, LongLinkedOpenHashSet$SetIterator.remove > LongLinkedOpenHashSet.fixPointers 2, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1, MinecraftServer.haveTime > Util.getNanos 1, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 1
- **ChunkMap.save** 1543: SerializableChunkData.copyOf 1513, CompletableFuture.supplyAsync 12, SimpleRegionStorage.write 4, ChunkMap.markPosition 3, CompletableFuture.handle 2, Profiler.get 1, DirectMethodHandle.allocateInstance 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 393, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 383, SerializableChunkData.copyOf > LightEngine.getDataLayerData 279, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 160, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 86, SerializableChunkData.copyOf > ReferencePipeline.toArray 33, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 33, SerializableChunkData.copyOf > DataLayer.copy 15, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 12, SerializableChunkData.copyOf > ArrayList.add 8, SerializableChunkData.copyOf > ProblemReporter$ScopedCollector.<init> 5, SerializableChunkData.copyOf > EnumMap.<init> 5
- **SerializableChunkData.copyOf** 1513: LevelChunkSection.copy 393, LevelChunk.getBlockEntityNbtForSaving 383, LightEngine.getDataLayerData 279, SerializableChunkData.packStructureData 160, LevelChunk.getTicksForSerialization 86, ReferencePipeline.toArray 33, ChunkAccess.getBlockEntitiesPos 33, DataLayer.copy 15, ArrayList.add 8, ProblemReporter$ScopedCollector.<init> 5, Collections$UnmodifiableCollection.iterator 4, ChunkAccess.getAllReferences 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 389, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 371, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 275, SerializableChunkData.packStructureData > StructureStart.createTag 105, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 83, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 32, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 20, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 13, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 11, DataLayer.copy > DataLayer.<init> 9, ArrayList.add > ArrayList.add 8, SerializableChunkData.packStructureData > CompoundTag.put 7
- **LevelChunk.postProcessGeneration** 1377: Block.updateFromNeighbourShapes 813, FluidState.tick 228, BlockBehaviour$BlockStateBase.tick 173, LevelChunk.getBlockState 72, FluidState.isEmpty 31, LevelWriter.setBlock 12, ImmutableList.copyOf 11, LevelHeightAccessor.getSectionYFromSectionIndex 7, UpgradeData.upgrade 2, ImmutableList.iterator 1, ShortArrayList$1.hasNext 1, AbstractShortList.iterator 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 439, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 352, FluidState.tick > FlowingFluid.tick 227, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 173, LevelChunk.getBlockState > LevelChunkSection.getBlockState 71, LevelWriter.setBlock > Level.setBlock 12, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 7, ImmutableList.copyOf > HashMap$KeySet.toArray 2, UpgradeData.upgrade > UpgradeData.upgradeInside 1, ImmutableList.iterator > ImmutableList.listIterator 1, AbstractShortList.iterator > AbstractShortList.listIterator 1, UpgradeData.upgrade > Iterable.forEach 1
- **SerializableChunkData.read** 465: SerializableChunkData.unpackStructureStart 240, LevelChunkTicks.<init> 58, PoiManager.checkConsistencyWithBlocks 51, ImposterProtoChunk.<init> 35, SerializableChunkData.unpackStructureReferences 34, LevelChunk.<init> 6, ThreadedLevelLightEngine.queueSectionData 5, ChunkAccess.addPackedPostProcess 5, ChunkAccess.setAllStarts 4, ChunkAccess.setLightCorrect 4, ThreadedLevelLightEngine.retainData 3, Heightmap.primeHeightmaps 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 238, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 56, ImposterProtoChunk.<init> > ProtoChunk.<init> 34, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 32, PoiManager.checkConsistencyWithBlocks > Util.ifElse 27, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 24, LevelChunk.<init> > ChunkAccess.<init> 6, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 4, ChunkAccess.addPackedPostProcess > ShortList.addAll 4, ChunkAccess.setAllStarts > HashMap.putAll 2, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 2, Objects.equals > ChunkPos.equals 2
- **LevelChunk.runPostLoad** 277: SerializableChunkData.lambda$postLoadChunk$0 276<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 245, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 12, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 9, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 7, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 2
- **LevelChunk.<init>** 6: ChunkAccess.<init> 6<br>two down: ChunkAccess.<init> > ChunkAccess.replaceMissingSections 3, ChunkAccess.<init> > ChunkSkyLightSources.<init> 2, ChunkAccess.<init> > LevelHeightAccessor.getSectionsCount 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 3208: LoadingChunkTracker.runDistanceUpdates 2018, ChunkHolder.updateFutures 1014, GenerationChunkHolder.updateHighestAllowedStatus 75, ReferenceOpenHashSet$SetIterator.next 21, ReferenceOpenHashSet.clear 8, DistanceManager$PlayerTicketTracker.runAllUpdates 4, ReferenceOpenHashSet.iterator 3, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 3, SimulationChunkTracker.runAllUpdates 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 2017, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 275, ChunkHolder.updateFutures > ChunkMap.onLevelChange 236, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 179, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 147, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 122, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 49, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 18, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 8, ReferenceOpenHashSet.clear > Arrays.fill 7, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 5, ChunkHolder.updateFutures > CompletableFuture.complete 5
- **ChunkMap.processUnloads** 2730: ChunkMap.saveChunksEagerly 2495, CompletableFuture$Completion.run 171, ChunkMap.scheduleUnload 17, ConcurrentLinkedQueue.size 7, Long2ObjectLinkedOpenHashMap.put 6, Long2ObjectLinkedOpenHashMap.remove 5, MinecraftServer.haveTime 5, LongOpenHashSet$SetIterator.remove 4, ConcurrentLinkedQueue.poll 3, LongOpenHashSet.iterator 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1616, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 581, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 171, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 90, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 57, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 14, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 5, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 5, MinecraftServer.haveTime > Util.getNanos 5, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 4, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 3, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 3
- **ChunkMap.saveChunksEagerly** 2495: ChunkMap.saveChunkIfNeeded 1616, GenerationChunkHolder.getLatestChunk 581, Long2ObjectLinkedOpenHashMap.get 90, LongLinkedOpenHashSet$SetIterator.nextLong 57, LongLinkedOpenHashSet$SetIterator.remove 4, MinecraftServer.haveTime 1, Util.getMillis 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1273, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 466, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 169, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 137, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 3, ChunkMap.saveChunkIfNeeded > ChunkHolder.isReadyForSaving 1, LongLinkedOpenHashSet$SetIterator.remove > LongLinkedOpenHashSet$SetIterator.ensureIndexKnown 1, MinecraftServer.haveTime > Util.getNanos 1, Util.getMillis > Util.getNanos 1
- **LevelChunk.postProcessGeneration** 1476: Block.updateFromNeighbourShapes 849, FluidState.tick 247, BlockBehaviour$BlockStateBase.tick 216, LevelChunk.getBlockState 65, FluidState.isEmpty 27, LevelWriter.setBlock 16, LevelHeightAccessor.getSectionYFromSectionIndex 10, UpgradeData.upgrade 8, ShortListIterator.next 7, ImmutableList.copyOf 6, ImmutableList.iterator 1, AbstractShortList.iterator 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 435, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 375, FluidState.tick > FlowingFluid.tick 244, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 216, LevelChunk.getBlockState > LevelChunkSection.getBlockState 65, LevelWriter.setBlock > Level.setBlock 16, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 10, ShortListIterator.next > ShortListIterator.next 7, UpgradeData.upgrade > Iterable.forEach 4, UpgradeData.upgrade > UpgradeData.upgradeInside 2, ImmutableList.iterator > ImmutableList.listIterator 1, UpgradeData.upgrade > UpgradeData.upgradeSides 1
- **ChunkMap.save** 1392: SerializableChunkData.copyOf 1356, CompletableFuture.supplyAsync 11, SimpleRegionStorage.write 10, ChunkMap.markPosition 4, CompletableFuture.handle 2, Profiler.get 2, DirectMethodHandle.allocateInstance 1, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 314, SerializableChunkData.copyOf > LightEngine.getDataLayerData 305, SerializableChunkData.copyOf > LevelChunkSection.copy 249, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 164, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 72, SerializableChunkData.copyOf > ReferencePipeline.toArray 51, SerializableChunkData.copyOf > DataLayer.copy 45, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 27, SimpleRegionStorage.write > IOWorker.store 10, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 8, SerializableChunkData.copyOf > SerializableChunkData.handler$zon000$quicksilver$copied 5, SerializableChunkData.copyOf > ArrayList.add 5
- **SerializableChunkData.copyOf** 1356: LevelChunk.getBlockEntityNbtForSaving 314, LightEngine.getDataLayerData 305, LevelChunkSection.copy 249, SerializableChunkData.packStructureData 164, LevelChunk.getTicksForSerialization 72, ReferencePipeline.toArray 51, DataLayer.copy 45, ChunkAccess.getBlockEntitiesPos 27, SerializableChunkData.handler$zon000$quicksilver$copied 5, Collections$UnmodifiableCollection$1.hasNext 5, ArrayList.add 4, ChunkAccess.fabric_writeAttachmentsToNbt 4<br>two down: LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 309, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 303, LevelChunkSection.copy > LevelChunkSection.<init> 246, SerializableChunkData.packStructureData > StructureStart.createTag 107, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 64, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 48, DataLayer.copy > DataLayer.<init> 33, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, SerializableChunkData.packStructureData > CompoundTag.putLongArray 7, SerializableChunkData.packStructureData > Identifier.toString 7, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 7
- **SerializableChunkData.read** 477: SerializableChunkData.unpackStructureStart 250, LevelChunkTicks.<init> 66, PoiManager.checkConsistencyWithBlocks 45, ImposterProtoChunk.<init> 37, SerializableChunkData.unpackStructureReferences 27, LevelChunk.<init> 13, ChunkAccess.addPackedPostProcess 5, ThreadedLevelLightEngine.retainData 4, ChunkAccess.setAllReferences 3, ThreadedLevelLightEngine.queueSectionData 3, SerializableChunkData.postLoadChunk 3, CompoundTag.put 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 242, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 63, ImposterProtoChunk.<init> > ProtoChunk.<init> 37, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 26, PoiManager.checkConsistencyWithBlocks > Util.ifElse 24, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 21, LevelChunk.<init> > ChunkAccess.<init> 8, ChunkAccess.addPackedPostProcess > ShortList.addAll 5, ChunkAccess.setAllReferences > HashMap.putAll 3, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 3, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 3, SerializableChunkData.postLoadChunk > ImmutableCollections$ListN.isEmpty 3
- **LevelChunk.runPostLoad** 245: SerializableChunkData.lambda$postLoadChunk$0 245<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 220, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 9, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 7, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 2, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 1, SerializableChunkData.lambda$postLoadChunk$0 > ImmutableCollections$ListItr.next 1
- **LevelChunk.<init>** 13: ChunkAccess.<init> 8, Int2ObjectOpenHashMap.<init> 2, Heightmap$Types.values 1, Maps.newHashMap 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 3, ChunkAccess.<init> > ChunkAccess.replaceMissingSections 3, ChunkAccess.<init> > Object2ObjectOpenHashMap.<init> 2, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 1614 | 6015 | 3759 | 1785 | 471 | 302 (first [-1, -17]) |
| 1 | quicksilver | 1614 | 6015 | 3561 | 1852 | 602 | 275 (first [-1, -18]) |
| 2 | vanilla | 1614 | 6015 | 3689 | 1808 | 518 | 266 (first [-1, 18]) |
| 2 | quicksilver | 1614 | 6015 | 3553 | 1938 | 524 | 256 (first [-1, -16]) |
| 3 | vanilla | 1614 | 6015 | 3700 | 1756 | 559 | 269 (first [-1, -17]) |
| 3 | quicksilver | 1614 | 6016 | 3459 | 1992 | 565 | 192 (first [-1, -16]) |
| 4 | vanilla | 1614 | 6015 | 3614 | 1807 | 594 | 327 (first [-1, -18]) |
| 4 | quicksilver | 1614 | 6015 | 3531 | 1950 | 534 | 275 (first [-1, -16]) |
| 5 | vanilla | 1614 | 6015 | 3657 | 1832 | 526 | 291 (first [-1, -19]) |
| 5 | quicksilver | 1614 | 6015 | 3610 | 1908 | 497 | 274 (first [-1, -16]) |
| 6 | vanilla | 1614 | 6015 | 3636 | 1807 | 572 | 334 (first [-1, -17]) |
| 6 | quicksilver | 1614 | 6015 | 3547 | 1931 | 537 | 247 (first [-1, 11]) |
| 7 | vanilla | 1614 | 6015 | 3744 | 1840 | 431 | 244 (first [-11, -17]) |
| 7 | quicksilver | 1614 | 6015 | 3673 | 1953 | 389 | 259 (first [-1, -18]) |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (1) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 805 (326) | 0 (0) | LastUpdate 231, block_ticks 521, fluid_ticks 471 | 1514 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 860 (0) | 0 (0) | LastUpdate 288, block_ticks 538, fluid_ticks 462 | 1543 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (1) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 801 (285) | 0 (0) | LastUpdate 235, block_ticks 511, fluid_ticks 444, sections 3 | 1534 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 796 (0) | 0 (0) | LastUpdate 256, block_ticks 527, fluid_ticks 443, sections 1 | 1516 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (1) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 680 (268) | 0 (0) | LastUpdate 236, block_ticks 418, fluid_ticks 390 | 1521 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 777 (0) | 0 (0) | LastUpdate 201, block_ticks 509, fluid_ticks 459 | 1530 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 18 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 781 (294) | 0 (0) | LastUpdate 228, block_ticks 503, fluid_ticks 442 | 1513 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 854 (0) | 0 (0) | LastUpdate 250, block_ticks 524, fluid_ticks 501, sections 1 | 1521 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 809 (304) | 0 (0) | LastUpdate 258, block_ticks 492, fluid_ticks 484 | 1519 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 790 (0) | 0 (0) | LastUpdate 233, block_ticks 506, fluid_ticks 449, sections 1 | 1533 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 751 (294) | 0 (0) | LastUpdate 251, block_ticks 456, fluid_ticks 425 | 1517 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 705 (0) | 0 (0) | LastUpdate 232, block_ticks 428, fluid_ticks 385 | 1526 / 1681 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 765 (237) | 0 (0) | LastUpdate 278, block_ticks 475, fluid_ticks 411 | 1529 / 1681 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 6 data, 0 bytes only, 0 one side, keys DataVersion 15, Entities 16, Position 15; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1101 data, 0 bytes only, 0 one side, keys LastUpdate 1460, block_ticks 3032, fluid_ticks 2699, sections 3

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 218 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.513 | 0.758 | 2725.256 | 4 | 0.000 (0.000) | 0.012 (0.012) | 0.011 | 5734 (64.0) | 700: 2725.3, 100: 64.8, 5734: 64.0, 400: 57.2, 656: 31.5 |
| 1 | quicksilver | yes | 0.523 | 0.670 | 2813.058 | 2 | 0.000 (0.000) | 0.011 (0.011) | 0.011 | 5733 (45.8) | 700: 2813.1, 100: 74.5, 400: 48.9, 5733: 45.8, 0: 21.3 |
| 2 | vanilla | yes | 0.513 | 0.681 | 2777.540 | 4 | 0.000 (0.000) | 0.010 (0.010) | 0.009 | 5734 (107.6) | 700: 2777.5, 5734: 107.6, 100: 97.2, 400: 50.8, 0: 20.6 |
| 2 | quicksilver | yes | 0.512 | 0.775 | 2620.896 | 4 | 0.000 (0.000) | 0.012 (0.011) | 0.011 | 5742 (46.7) | 700: 2620.9, 6804: 79.6, 100: 65.4, 400: 51.4, 5742: 46.7 |
| 3 | vanilla | yes | 0.529 | 0.794 | 2821.647 | 4 | 0.000 (0.000) | 0.013 (0.013) | 0.012 | 5732 (117.4) | 700: 2821.6, 5732: 117.4, 100: 71.4, 400: 65.0, 0: 24.8 |
| 3 | quicksilver | yes | 0.538 | 0.765 | 2830.261 | 3 | 0.001 (0.001) | 0.013 (0.013) | 0.012 | 5736 (132.0) | 700: 2830.3, 5736: 132.0, 100: 64.8, 400: 49.1, 0: 25.3 |
| 4 | vanilla | yes | 0.532 | 0.953 | 2702.310 | 3 | 0.000 (0.000) | 0.018 (0.018) | 0.018 | 5735 (48.2) | 700: 2702.3, 100: 104.7, 400: 65.6, 3888: 49.6, 5735: 48.2 |
| 4 | quicksilver | yes | 0.509 | 0.674 | 2762.810 | 3 | 0.001 (0.001) | 0.014 (0.014) | 0.013 | 5732 (41.1) | 700: 2762.8, 100: 78.2, 400: 70.6, 5732: 41.1, 0: 34.5 |
| 5 | vanilla | yes | 0.545 | 0.643 | 2920.436 | 4 | 0.000 (0.000) | 0.014 (0.014) | 0.013 | 5729 (118.2) | 700: 2920.4, 5729: 118.2, 100: 65.6, 400: 53.5, 0: 23.9 |
| 5 | quicksilver | yes | 0.539 | 0.541 | 2886.316 | 4 | 0.001 (0.001) | 0.022 (0.021) | 0.020 | 5731 (61.2) | 700: 2886.3, 100: 82.2, 400: 61.9, 5731: 61.2, 0: 30.2 |
| 6 | vanilla | yes | 0.511 | 0.851 | 2651.433 | 4 | 0.001 (0.001) | 0.012 (0.012) | 0.012 | 5730 (43.3) | 700: 2651.4, 400: 100.1, 100: 92.5, 6546: 66.1, 5730: 43.3 |
| 6 | quicksilver | yes | 0.491 | 0.785 | 2709.376 | 3 | 0.001 (0.001) | 0.011 (0.011) | 0.011 | 5735 (32.1) | 700: 2709.4, 100: 83.2, 400: 54.1, 5735: 32.1, 0: 23.5 |
| 7 | vanilla | yes | 0.494 | 0.736 | 2748.939 | 3 | 0.001 (0.001) | 0.011 (0.011) | 0.011 | 5731 (48.8) | 700: 2748.9, 100: 79.6, 400: 57.8, 5731: 48.8, 0: 24.3 |
| 7 | quicksilver | yes | 0.517 | 0.783 | 2746.030 | 4 | 0.001 (0.001) | 0.011 (0.011) | 0.010 | 5729 (54.8) | 700: 2746.0, 400: 60.1, 100: 58.5, 5729: 54.8, 0: 27.0 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 0.513 | 0.517 | 0.998 (0.96 to 1.05) |
| MSPT p99 | 0.758 | 0.765 | 0.922 (0.71 to 1.14) |
| slowest tick (ms) | 2748.939 | 2762.810 | 1.003 (0.94 to 1.03) |
| ticks over 50 ms | 4 | 3 | 1.000 (0.50 to 1.33) |
| chunk load, ms per tick (server thread) | 0.000 | 0.001 | 1.000 (1.00 to 6.00) |
|   of it in the tick | 0.000 | 0.001 | 1.000 (1.00 to 6.00) |
| chunk save, ms per tick (server thread) | 0.012 | 0.012 | 0.977 (0.76 to 1.58) |
|   of it in the tick | 0.012 | 0.011 | 0.977 (0.77 to 1.57) |
| autosave, ms per tick | 0.012 | 0.011 | 0.972 (0.73 to 1.52) |
| save-all tick (ms, mean of the script's) | 68.744 | 61.709 | 0.863 (0.71 to 1.21) |
| save-all flush tick (ms) | 2748.939 | 2762.810 | 1.003 (0.94 to 1.03) |
| autosave tick (ms, the game's own) | 63.951 | 46.693 | 0.742 (0.43 to 1.12) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 3625 ms, 22903 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 72 / 4 | 0 / 0 | 0.011 | 158.4 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 0.1 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 5 / 0 | 0 / 0 | 0.001 | 0.6 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 2 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 162 / 1 | 0 / 0 | 0.023 | 32.3 |
| tick, other | 253 / 3 | 0 / 0 | 0.037 | 12.9 |
| idle or other | 0 / 0 | 14 / 1 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 247, MinecraftServer.processPacketsAndTick 247, MinecraftServer.tickServer 247, DedicatedServer.tickServer 247, MinecraftServer.lambda$spin$0 246, Thread.run 245, MinecraftServer.tickChildren 168, ServerLevel.tick 168, ServerChunkCache.tick 142, ServerChunkCache.tickChunks 116, NaturalSpawner.createState 83, ServerChunkCache.getFullChunk 75, MinecraftServer.saveEverything 75, MinecraftServer.saveAllChunks 75, DedicatedServer.saveAllChunks 75, ServerLevel.save 70, ChunkMap.saveAllChunks 61, ServerChunkCache.save 61, ChunkMap.save 58, SerializableChunkData.copyOf 58, ChunkMap.saveChunkIfNeeded 56, ServerTickEvents.lambda$static$1 47, Harness.startTick 47, ChunkResult$Success.ifSuccess 44, NaturalSpawner.lambda$createState$0 44, CommandDispatcher.execute 44, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 44, ContextChain.runExecutable 44, Harness.command 44, ContextChain.runExecutable$mixinextras$wrapped$10 44, ContextChain.executeAll 44, SaveAllCommand.saveAll 44, EnvironmentAttributeReader.getValue 42, EnvironmentAttributeSystem$ValueSampler.getValue 42, EnvironmentAttributeSystem.getValue 42, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 42, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 37, SaveAllCommand.lambda$register$0 33, BiomeManager.getBiome 32, MinecraftServer.autoSave 32, LevelReader.getNoiseBiome 30, Level.getChunk 28, ServerChunkCache.getChunk 28, SimulationChunkTracker.getLevel 27, Long2ByteOpenHashMap.get 27, LevelTicks.sortContainersToTick 25, DistanceManager.inBlockTickingRange 25, LevelTicks.tick 25, ServerLevel.shouldTickBlocksAt 25, LevelTicks.collectTicks 25, ServerLevel.isPositionTickingWithEntitiesLoaded 25, ServerChunkCache.isPositionTicking 25, Encoder.encodeStart 16, LevelChunkSection.copy 16, PalettedContainer.copy 16, LevelChunkSection.<init> 16, PalettedContainer$Data.copy 16, PalettedContainer.<init> 16, ChunkMap.tick 15, TagValueOutput.store 15

Top chunk methods (self): Long2ByteOpenHashMap.get 27, ServerChunkCache.tickChunks 19, ServerChunkCache.getChunk 19, ServerChunkCache.getFullChunk 19, PalettedContainer$Data.copy 16, Long2ObjectLinkedOpenHashMap.get 12, Long2ObjectOpenHashMap.<init> 5, CompletableFuture.reportJoin 5, Long2ObjectFunctions$SynchronizedFunction.get 4, SerializableChunkData.copyOf 4, ArrayList.grow 4, SectionPos.of 3, NaturalSpawner.createState 3, Comparator.lambda$comparingLong$6043328a$1 3, TicketStorage.purgeStaleTickets 3, Long2ObjectOpenHashMap$MapIterator.nextEntry 3, Long2ObjectOpenHashMap$MapIterator.<init> 2, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 2, TicketStorage.removeTicketIf 2, Long2ObjectOpenHashMap.get 2, ServerChunkCache.storeInCache 2, UnixFileDispatcherImpl.write0 2, Long2ByteOpenHashMap$MapIterator.<init> 2, DirectMethodHandle.allocateInstance 2, RegularImmutableMap.get 2, Object2BooleanOpenHashMap$KeyIterator.<init> 2, Long2ByteOpenHashMap$KeyIterator.<init> 2, ConstantUtils.dropFirstAndLastChar 1, HashMap.putVal 1, BufWriterImpl.grow 1

Threads (all samples in the window): Netty Epoll IO  2127, Worker-Main 1028, IO-Worker 907, Server thread 518

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 3704 ms, 22821 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 71 / 3 | 0 / 0 | 0.011 | 96.3 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 4 / 0 | 0 / 0 | 0.001 | 1.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 2 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 152 / 0 | 0 / 0 | 0.022 | 56.5 |
| tick, other | 282 / 1 | 0 / 0 | 0.040 | 6.2 |
| idle or other | 0 / 0 | 15 / 0 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 234, DedicatedServer.tickServer 234, MinecraftServer.tickServer 234, MinecraftServer.processPacketsAndTick 234, MinecraftServer.lambda$spin$0 234, Thread.run 233, ServerLevel.tick 158, MinecraftServer.tickChildren 158, ServerChunkCache.tick 136, ServerChunkCache.tickChunks 108, NaturalSpawner.createState 89, MinecraftServer.saveEverything 72, MinecraftServer.saveAllChunks 71, DedicatedServer.saveAllChunks 71, ServerChunkCache.getFullChunk 70, ServerLevel.save 67, ChunkResult$Success.ifSuccess 65, NaturalSpawner.lambda$createState$0 64, Harness.startTick 58, ServerTickEvents.lambda$static$1 58, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 56, ContextChain.runExecutable$mixinextras$wrapped$10 56, Harness.command 56, ContextChain.runExecutable 56, ContextChain.executeAll 56, CommandDispatcher.execute 56, SaveAllCommand.saveAll 56, ChunkMap.saveAllChunks 54, ServerChunkCache.save 54, EnvironmentAttributeReader.getValue 52, EnvironmentAttributeSystem.getValue 52, ChunkMap.save 52, EnvironmentAttributeSystem$ValueSampler.getValue 51, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 51, SerializableChunkData.copyOf 51, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 49, BiomeManager.getBiome 40, ChunkMap.saveChunkIfNeeded 39, SaveAllCommand.lambda$register$0 38, LevelReader.getNoiseBiome 37, ImposterProtoChunk.getNoiseBiome 26, ChunkAccess.getNoiseBiome 26, LevelChunkSection.getNoiseBiome 25, PalettedContainer.get 24, Long2ByteOpenHashMap.get 23, SimulationChunkTracker.getLevel 22, DistanceManager.inBlockTickingRange 21, ServerLevel.shouldTickBlocksAt 21, SaveAllCommand.lambda$register$1 18, MinecraftServer.autoSave 18, LevelTicks.sortContainersToTick 17, LevelTicks.collectTicks 17, ServerLevel.isPositionTickingWithEntitiesLoaded 17, LevelTicks.tick 17, ServerChunkCache.isPositionTicking 17, AbstractPipeline.wrapAndCopyInto 16, AbstractPipeline.evaluate 16, ChunkMap.tick 15, AbstractPipeline.copyInto 15, LightEngine.getDataLayerData 14

Top chunk methods (self): PalettedContainer.get 24, Long2ByteOpenHashMap.get 23, Long2ObjectOpenHashMap.get 8, RegularImmutableMap.get 6, PalettedContainer.create$quicksilver_$md$74d16b$0 6, SerializableChunkData.copyOf 5, NaturalSpawner.createState 5, ServerChunkCache.tickChunks 5, ServerChunkCache.getChunk 4, TicketStorage.purgeStaleTickets 4, MobSpawnSettingsModifier$Overlay.apply 3, Long2ObjectFunctions$SynchronizedFunction.get 3, LevelChunkSection.<init> 3, UnixFileDispatcherImpl.write0 3, ServerChunkCache.storeInCache 3, CompletableFuture.reportJoin 3, BiomeManager.getBiome 2, ChunkMap.getPlayersCloseForSpawning 2, ChunkMap.tick 2, DirectMethodHandle.allocateInstance 2, Encoder$2.encode 2, TimSort.countRunAndMakeAscending 2, DelegatingOps.createInt 2, ChunkMap.saveAllChunks 2, Reference2ObjectOpenHashMap.get 2, BlockableEventLoop.managedBlock 2, LayerLightSectionStorage.getDataLayerData 2, Iterators$1.hasNext 2, Iterables.unmodifiableIterable 2, Entity.isPassenger 2

Threads (all samples in the window): Netty Epoll IO  2181, Worker-Main 1070, IO-Worker 887, Server thread 532

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 585: DedicatedServer.saveAllChunks 580, MinecraftServer.warnOnLowDiskSpace 4<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 580, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 4
- **ServerLevel.save** 546: ServerChunkCache.save 457, PersistentEntitySectionManager.autoSave 50, PersistentEntitySectionManager.saveAll 31, ServerLevel.saveLevelData 8<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 457, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 47, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 24, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 6, PersistentEntitySectionManager.saveAll > EntityStorage.flush 4, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 3, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 2, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 2, PersistentEntitySectionManager.saveAll > MethodHandleNatives.linkCallSite 1
- **ChunkMap.saveAllChunks** 457: ChunkMap.saveChunkIfNeeded 369, ReferencePipeline.forEach 78, ReferencePipeline.toList 2, ChunkMap.processUnloads 1, Util.getMillis 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 366, ReferencePipeline.forEach > AbstractPipeline.evaluate 78, ReferencePipeline.toList > ReferencePipeline.toArray 2, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 2, ChunkMap.processUnloads > ConcurrentLinkedQueue.size 1, Util.getMillis > Util.getNanos 1
- **ChunkMap.save** 441: SerializableChunkData.copyOf 430, SimpleRegionStorage.write 3, ChunkMap.markPosition 2, CompletableFuture.supplyAsync 2, ChunkAccess.tryMarkSaved 1, DirectMethodHandle.allocateInstance 1, CompletableFuture.handle 1, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 148, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 69, SerializableChunkData.copyOf > LightEngine.getDataLayerData 50, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 38, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 35, SerializableChunkData.copyOf > DataLayer.copy 16, SerializableChunkData.copyOf > ReferencePipeline.toArray 8, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 7, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 5, SerializableChunkData.copyOf > Heightmap.getRawData 5, SerializableChunkData.copyOf > LevelHeightAccessor.getSectionIndexFromSectionY 3, SimpleRegionStorage.write > IOWorker.store 3
- **SerializableChunkData.copyOf** 430: LevelChunkSection.copy 148, LevelChunk.getBlockEntityNbtForSaving 69, LightEngine.getDataLayerData 50, LevelChunk.getTicksForSerialization 38, SerializableChunkData.packStructureData 35, DataLayer.copy 16, ReferencePipeline.toArray 8, ChunkAccess.getBlockEntitiesPos 7, LevelLightEngine.getMaxLightSection 5, Heightmap.getRawData 5, LevelHeightAccessor.getSectionIndexFromSectionY 3, ArrayList.add 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 140, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 67, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 49, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 35, SerializableChunkData.packStructureData > StructureStart.createTag 25, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 7, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 6, LevelHeightAccessor.getSectionIndexFromSectionY > LevelHeightAccessor.getMinSectionY 3, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 3, ArrayList.add > ArrayList.add 3, LevelLightEngine.getMaxLightSection > LevelLightEngine.getMinLightSection 3, SerializableChunkData.packStructureData > Collections$UnmodifiableMap$UnmodifiableEntrySet.iterator 2
- **PersistentEntitySectionManager.autoSave** 50: AbstractLongCollection.forEach 47, PersistentEntitySectionManager.getAllChunksToSave 3<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 47, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps$1.iterator 1, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 1
- **ChunkMap.processUnloads** 25: ChunkMap.saveChunksEagerly 14, ConcurrentLinkedQueue.size 4, LongOpenHashSet.iterator 1<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 8, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 3, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 1, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 14: Util.getMillis 8, LongLinkedOpenHashSet.iterator 3<br>two down: Util.getMillis > Util.getNanos 8, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 3
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 599: DedicatedServer.saveAllChunks 596, MinecraftServer.warnOnLowDiskSpace 3<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 596, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 3
- **ServerLevel.save** 560: ServerChunkCache.save 470, PersistentEntitySectionManager.autoSave 56, PersistentEntitySectionManager.saveAll 24, ServerLevel.saveLevelData 9<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 470, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 54, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 20, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 5, PersistentEntitySectionManager.saveAll > EntityStorage.flush 4, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 4, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkCallSite 1, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 1
- **ChunkMap.saveAllChunks** 470: ChunkMap.saveChunkIfNeeded 371, ReferencePipeline.forEach 86, Long2ObjectLinkedOpenHashMap$ValueIterator.next 3, ReferencePipeline.toList 2, CompletableFuture.join 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 368, ReferencePipeline.forEach > AbstractPipeline.evaluate 86, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 3, ReferencePipeline.toList > ReferencePipeline.toArray 2, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1
- **ChunkMap.save** 446: SerializableChunkData.copyOf 436, CompletableFuture.supplyAsync 5, SimpleRegionStorage.write 5<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 108, SerializableChunkData.copyOf > LightEngine.getDataLayerData 67, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 66, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 46, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 35, SerializableChunkData.copyOf > DataLayer.copy 21, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 13, SerializableChunkData.copyOf > ReferencePipeline.toArray 7, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 5, SimpleRegionStorage.write > IOWorker.store 5, SerializableChunkData.copyOf > Heightmap.getRawData 5, SerializableChunkData.copyOf > SectionPos.of 4
- **SerializableChunkData.copyOf** 436: LevelChunkSection.copy 108, LightEngine.getDataLayerData 67, LevelChunk.getBlockEntityNbtForSaving 66, SerializableChunkData.packStructureData 46, LevelChunk.getTicksForSerialization 35, DataLayer.copy 21, ChunkAccess.getBlockEntitiesPos 13, ReferencePipeline.toArray 7, Heightmap.getRawData 5, SectionPos.of 4, ArrayList.add 3, Collections$UnmodifiableCollection$1.hasNext 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 102, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 63, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 61, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 33, SerializableChunkData.packStructureData > StructureStart.createTag 31, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 8, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 6, LightEngine.getDataLayerData > SectionPos.asLong 5, DataLayer.copy > DataLayer.<init> 5, ArrayList.add > ArrayList.add 3, SerializableChunkData.packStructureData > Identifier.toString 3, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 3
- **PersistentEntitySectionManager.autoSave** 56: AbstractLongCollection.forEach 54, MethodHandleNatives.linkCallSite 1, PersistentEntitySectionManager.getAllChunksToSave 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 54, MethodHandleNatives.linkCallSite > MethodHandleNatives.linkCallSiteImpl 1, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 1
- **ChunkMap.processUnloads** 25: ChunkMap.saveChunksEagerly 13, LongOpenHashSet.iterator 3, ConcurrentLinkedQueue.size 2<br>two down: ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 6, ChunkMap.saveChunksEagerly > Util.getMillis 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 2, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 13: LongLinkedOpenHashSet.iterator 6, Util.getMillis 2<br>two down: LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 6, Util.getMillis > Util.getNanos 2

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 625 | 2006 | 2006 | 0 | 0 | 0 |
| 1 | quicksilver | 625 | 2082 | 1875 | 0 | 207 | 0 |
| 2 | vanilla | 625 | 2034 | 2006 | 0 | 28 | 0 |
| 2 | quicksilver | 625 | 2109 | 1875 | 0 | 234 | 0 |
| 3 | vanilla | 625 | 2099 | 1875 | 0 | 224 | 0 |
| 3 | quicksilver | 625 | 2051 | 1875 | 0 | 176 | 0 |
| 4 | vanilla | 625 | 2044 | 1875 | 0 | 169 | 0 |
| 4 | quicksilver | 625 | 2040 | 2040 | 0 | 0 | 0 |
| 5 | vanilla | 625 | 2080 | 1875 | 0 | 205 | 0 |
| 5 | quicksilver | 625 | 2015 | 2015 | 0 | 0 | 0 |
| 6 | vanilla | 625 | 2067 | 1875 | 0 | 192 | 0 |
| 6 | quicksilver | 625 | 2003 | 2003 | 0 | 0 | 0 |
| 7 | vanilla | 625 | 2033 | 1875 | 0 | 158 | 0 |
| 7 | quicksilver | 625 | 2014 | 2014 | 0 | 0 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 493 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 464 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 464 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 462 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 483 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 474 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 467 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 482 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 504 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 483 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 471 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 449 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 475 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 3 data, 0 bytes only, 0 one side, keys DataVersion 4, Entities 6, Position 4; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 1 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / kill: a kill -9 mid-save (save-all flush of 625 changed chunks)

| run | killed mid-save | chunks: complete save's / its at another tick / saved terrain's / other / unreadable (region) | entities, poi: other / unreadable | reloaded |
|---|---|---|---|---|
| quicksilver-killed1 | yes | 9470 / 244 / 87 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| quicksilver-killed2 | yes | 9424 / 289 / 88 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed1 | yes | 9499 / 217 / 85 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed2 | yes | 9468 / 246 / 87 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
quicksilver-complete1 against vanilla's complete saves: entities 2 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0

quicksilver-complete2 against vanilla's complete saves: entities 3 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0


Each chunk of a killed save is either the complete save's (possibly written at another tick: it differs only in LastUpdate, block_ticks, fluid_ticks) or the saved terrain's: a kill loses the chunks not yet written, and breaks none. Entity and POI files are reported only (their data follows entity and POI timing, as in vanilla's own rounds).

