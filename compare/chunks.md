# Chunk scenes (P2-4)

## core / churn

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 17.245 | 214.292 | 2397.744 | 32 | 0.030 (0.030) | 1.423 (1.412) | 1.417 | - | 220: 2397.7, 87: 621.2, 139: 500.1, 103: 375.6, 36: 264.2 |
| 1 | quicksilver | yes | 16.868 | 231.283 | 2535.215 | 30 | 0.047 (0.047) | 1.098 (1.088) | 1.088 | - | 220: 2535.2, 87: 585.7, 128: 496.7, 103: 358.3, 139: 288.0 |
| 2 | vanilla | yes | 17.489 | 270.549 | 2478.603 | 31 | 0.057 (0.050) | 1.342 (1.335) | 1.332 | - | 220: 2478.6, 87: 570.1, 128: 520.3, 103: 475.0, 139: 303.3 |
| 2 | quicksilver | yes | 17.315 | 248.221 | 2461.821 | 30 | 0.037 (0.035) | 1.133 (1.125) | 1.125 | - | 220: 2461.8, 128: 589.2, 87: 549.5, 103: 434.9, 21: 252.5 |
| 3 | vanilla | yes | 17.355 | 229.277 | 2859.219 | 30 | 0.048 (0.045) | 1.303 (1.293) | 1.297 | - | 220: 2859.2, 128: 560.4, 87: 547.2, 103: 402.0, 139: 244.9 |
| 3 | quicksilver | yes | 17.410 | 229.297 | 2636.892 | 28 | 0.032 (0.028) | 1.165 (1.157) | 1.162 | - | 220: 2636.9, 128: 606.3, 87: 600.3, 103: 411.5, 21: 297.9 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) | gated: trimmed geometric mean of rounds |
|---|---|---|---|---|
| MSPT average | 17.355 | 17.315 | 0.990 (0.98 to 1.00) | 0.990 |
| MSPT p99 | 229.277 | 231.283 | 1.000 (0.92 to 1.08) | 1.000 |
| slowest tick (ms) | 2478.603 | 2535.215 | 0.993 (0.92 to 1.06) | 0.993 |
| ticks over 50 ms | 31 | 30 | 0.938 (0.93 to 0.97) | 0.938 |
| chunk load, ms per tick (server thread) | 0.048 | 0.037 | 0.656 (0.65 to 1.56) | 0.656 |
|   of it in the tick | 0.045 | 0.035 | 0.700 (0.63 to 1.56) | 0.700 |
| chunk save, ms per tick (server thread) | 1.342 | 1.133 | 0.845 (0.77 to 0.89) | 0.845 |
|   of it in the tick | 1.335 | 1.125 | 0.843 (0.77 to 0.89) | 0.843 |
| autosave, ms per tick | 1.332 | 1.125 | 0.845 (0.77 to 0.90) | 0.845 |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) | - |
| save-all flush tick (ms) | - | - | - (- to -) | - |
| autosave tick (ms, the game's own) | - | - | - (- to -) | - |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 10405 ms, 36404 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 802 / 41 | 7 / 0 | 1.417 | 1682.2 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 3 / 0 | 0 / 0 | 0.005 | 0.0 |
| POI save | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| chunk load | 3 / 0 | 0 / 0 | 0.005 | 3.5 |
| chunk to full (promote) | 13 / 1 | 0 / 0 | 0.023 | 0.0 |
| entity load | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 17 / 0 | 0 / 0 | 0.028 | 1.0 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 296 / 181 | 8 / 1 | 0.810 | 139.2 |
| tick, other | 183 / 2 | 0 / 0 | 0.308 | 120.8 |
| idle or other | 0 / 0 | 11 / 0 | 0.018 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1367, MinecraftServer.lambda$spin$0 1367, Thread.run 1366, MinecraftServer.tickServer 1359, MinecraftServer.processPacketsAndTick 1358, DedicatedServer.tickServer 1358, CiChunks.startTick 1153, Harness.startTick 1153, ServerTickEvents.lambda$static$1 1151, ContextChain.runExecutable$mixinextras$wrapped$10 850, SaveAllCommand.saveAll 850, ContextChain.executeAll 850, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 850, MinecraftServer.saveEverything 850, SaveAllCommand.lambda$register$0 850, ContextChain.runExecutable 850, CommandDispatcher.execute 848, Harness.command 845, MinecraftServer.saveAllChunks 841, DedicatedServer.saveAllChunks 841, ServerLevel.save 794, ServerChunkCache.save 733, ChunkMap.saveAllChunks 733, ChunkMap.saveChunkIfNeeded 720, ChunkMap.save 711, SerializableChunkData.copyOf 689, LevelChunkSection.copy 371, LevelChunkSection.<init> 370, PalettedContainer.copy 370, PalettedContainer.<init> 337, PalettedContainer$Data.copy 331, ServerChunkCache.getChunk 293, Level.getChunk 293, LevelReader.getChunk 292, Level.getBlockState 292, LevelWriter.setBlock 265, Level.setBlock 265, CollectingNeighborUpdater.addAndRun 248, CollectingNeighborUpdater.runUpdates 248, NeighborUpdater.executeShapeUpdate 248, Level.neighborShapeChanged 248, CollectingNeighborUpdater.shapeUpdate 248, BlockBehaviour$BlockStateBase.updateNeighbourShapes 248, CollectingNeighborUpdater$ShapeUpdate.runNext 248, MinecraftServer.tickChildren 208, ServerLevel.tick 208, ServerChunkCache.tick 201, BlockableEventLoop.managedBlock 191, ServerChunkCache.runDistanceManagerUpdates 182, BlockableEventLoop.waitForTasks 179, Thread.yield0 179, Thread.yield 179, DistanceManager.runAllUpdates 171, DynamicGraphMinFixedPoint.runUpdates 123, LoadingChunkTracker.runDistanceUpdates 123, ChunkTracker.checkNeighborsAfterUpdate 91, DynamicGraphMinFixedPoint.checkNeighbor 87, DynamicGraphMinFixedPoint.checkEdge 75, LoadingChunkTracker.getLevel 70, ServerChunkCache.getChunkFutureMainThread 68

Top chunk methods (self): PalettedContainer$Data.copy 314, Thread.yield0 179, SerializableChunkData.copyOf 42, LongOpenHashSet.contains 41, Long2ObjectOpenHashMap.get 38, Long2ObjectLinkedOpenHashMap.get 34, PalettedContainer.copy 33, ServerChunkCache.getChunk 29, TimSort.countRunAndMakeAscending 29, UnixFileDispatcherImpl.write0 23, ConcurrentLinkedQueue.offer 19, HashMap.putVal 16, Object.clone 13, DataLayer.<init> 13, LongLinkedOpenHashSet.add 12, ChunkMap.saveAllChunks 11, LongLinkedOpenHashSet.rehash 11, LayerLightSectionStorage.getDataLayerData 11, LevelChunkTicks.pack 11, Long2ByteOpenHashMap.get 10, ReferencePipeline$3$1.accept 9, Arrays.copyOf 8, HashMap.resize 8, DirectMethodHandle.allocateInstance 7, Long2ObjectOpenHashMap.getOrDefault 7, TicketStorage.removeTicketIf 6, LinearPalette.copy 6, DistanceManager.runAllUpdates 6, PalettedContainer.<init> 6, DynamicGraphMinFixedPoint.runUpdates 6

Threads (all samples in the window): Worker-Main 6409, Netty Epoll IO  6316, Server thread 1571, IO-Worker 596

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 10179 ms, 37358 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 606 / 41 | 6 / 0 | 1.088 | 934.5 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 4 / 1 | 0 / 0 | 0.008 | 0.0 |
| POI save | 1 / 0 | 0 / 0 | 0.002 | 0.0 |
| chunk load | 8 / 0 | 0 / 0 | 0.013 | 3.0 |
| chunk to full (promote) | 18 / 0 | 0 / 0 | 0.030 | 2.0 |
| entity load | 2 / 0 | 0 / 0 | 0.003 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 19 / 0 | 0 / 0 | 0.032 | 2.9 |
| light | 0 / 0 | 0 / 0 | 0.000 | 26.4 |
| chunk system (tickets, holders, tasks) | 291 / 114 | 6 / 0 | 0.685 | 218.1 |
| tick, other | 196 / 6 | 0 / 0 | 0.337 | 215.5 |
| idle or other | 0 / 0 | 13 / 0 | 0.022 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1109, MinecraftServer.lambda$spin$0 1109, Thread.run 1106, MinecraftServer.tickServer 1105, DedicatedServer.tickServer 1105, MinecraftServer.processPacketsAndTick 1104, CiChunks.startTick 878, Harness.startTick 878, ServerTickEvents.lambda$static$1 877, CommandDispatcher.execute 653, ContextChain.runExecutable$mixinextras$wrapped$10 653, ContextChain.runExecutable 653, SaveAllCommand.saveAll 653, ContextChain.executeAll 653, MinecraftServer.saveEverything 653, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 653, SaveAllCommand.lambda$register$0 653, Harness.command 651, DedicatedServer.saveAllChunks 647, MinecraftServer.saveAllChunks 647, ServerLevel.save 587, ServerChunkCache.save 527, ChunkMap.saveAllChunks 527, ChunkMap.saveChunkIfNeeded 520, ChunkMap.save 509, SerializableChunkData.copyOf 490, MinecraftServer.tickChildren 231, ServerLevel.tick 231, LevelReader.getChunk 222, Level.getChunk 222, ServerChunkCache.getChunk 222, Level.getBlockState 222, ServerChunkCache.tick 220, LevelChunkSection.copy 211, LevelChunkSection.<init> 208, ServerChunkCache.runDistanceManagerUpdates 197, LevelWriter.setBlock 194, Level.setBlock 194, Level.neighborShapeChanged 188, CollectingNeighborUpdater.addAndRun 188, NeighborUpdater.executeShapeUpdate 188, CollectingNeighborUpdater$ShapeUpdate.runNext 188, BlockBehaviour$BlockStateBase.updateNeighbourShapes 188, CollectingNeighborUpdater.runUpdates 188, CollectingNeighborUpdater.shapeUpdate 188, DistanceManager.runAllUpdates 185, DynamicGraphMinFixedPoint.runUpdates 132, LoadingChunkTracker.runDistanceUpdates 132, BlockableEventLoop.managedBlock 130, Thread.yield0 113, BlockableEventLoop.waitForTasks 113, Thread.yield 113, ChunkTracker.checkNeighborsAfterUpdate 102, DynamicGraphMinFixedPoint.checkNeighbor 98, PalettedContainer.handler$zom000$quicksilver$share 94, PalettedContainer.copy 94, PalettedContainerInvoker.quicksilver$create 94, PalettedContainer.create$quicksilver_$md$7c7ca1$0 94, DynamicGraphMinFixedPoint.checkEdge 82, LoadingChunkTracker.getLevel 81

Top chunk methods (self): LevelChunkSection.<init> 114, Thread.yield0 113, PalettedContainer.create$quicksilver_$md$7c7ca1$0 94, LongOpenHashSet.contains 57, Long2ObjectFunctions$SynchronizedFunction.get 36, Long2ObjectLinkedOpenHashMap.get 31, ServerChunkCache.getChunk 29, UnixFileDispatcherImpl.write0 26, Long2ObjectOpenHashMap.get 26, SerializableChunkData.copyOf 23, ArrayList.add 21, Long2ByteOpenHashMap.find 17, LongLinkedOpenHashSet.rehash 15, ConcurrentLinkedQueue.offer 12, ChunkMap.onLevelChange 11, Long2ByteOpenHashMap.get 9, DataLayer.<init> 9, HashMap.putVal 9, TicketStorage.removeTicketIf 8, Arrays.copyOf 8, ChunkMap.promoteChunkMap 7, TicketType.equals 7, ChunkMap.saveChunkIfNeeded 7, ChunkMap.saveAllChunks 7, ReferencePipeline$3$1.accept 7, ShortArrayList.copyArrayFromSafe 7, ChunkHolder.broadcastChanges 5, ConcurrentLinkedQueue.size 5, HashMap$HashIterator.<init> 5, Long2ObjectOpenHashMap.getOrDefault 5

Threads (all samples in the window): Worker-Main 6339, Netty Epoll IO  6314, Server thread 1332, IO-Worker 629, JFR Periodic Tasks 3

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2427: DedicatedServer.saveAllChunks 2404, MinecraftServer.warnOnLowDiskSpace 23<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2403, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 23
- **ServerLevel.save** 2238: ServerChunkCache.save 2057, PersistentEntitySectionManager.autoSave 152, ServerLevel.saveLevelData 29<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 2057, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 135, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 29, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 16
- **ChunkMap.saveAllChunks** 2057: ChunkMap.saveChunkIfNeeded 2025, Long2ObjectLinkedOpenHashMap$ValueIterator.next 5<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1996, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 12, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 5, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 4, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 2
- **ChunkMap.save** 1996: SerializableChunkData.copyOf 1934, CompletableFuture.supplyAsync 27, SimpleRegionStorage.write 16, CompletableFuture.handle 9, DirectMethodHandle.allocateInstance 3, ChunkMap.markPosition 2, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 983, SerializableChunkData.copyOf > LightEngine.getDataLayerData 203, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 149, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 131, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 118, SerializableChunkData.copyOf > ReferencePipeline.toArray 71, SerializableChunkData.copyOf > DataLayer.copy 43, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 39, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 27, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 23, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 17, SimpleRegionStorage.write > IOWorker.store 16
- **SerializableChunkData.copyOf** 1934: LevelChunkSection.copy 983, LightEngine.getDataLayerData 203, LevelChunk.getBlockEntityNbtForSaving 149, LevelChunk.getTicksForSerialization 131, SerializableChunkData.packStructureData 118, ReferencePipeline.toArray 71, DataLayer.copy 43, ChunkAccess.getBlockEntitiesPos 39, LevelLightEngine.getMaxLightSection 23, Collections$UnmodifiableCollection$1.hasNext 17, ArrayList.add 12, ChunkAccess.fabric_writeAttachmentsToNbt 6<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 981, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 200, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 140, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 125, SerializableChunkData.packStructureData > StructureStart.createTag 74, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 71, DataLayer.copy > DataLayer.<init> 38, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 22, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 21, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, SerializableChunkData.packStructureData > CompoundTag.put 14, ArrayList.add > ArrayList.add 12
- **DistanceManager.runAllUpdates** 557: LoadingChunkTracker.runDistanceUpdates 426, ChunkHolder.updateFutures 90, ReferenceOpenHashSet.clear 12, ReferenceOpenHashSet$SetIterator.next 8, GenerationChunkHolder.updateHighestAllowedStatus 5, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 426, ChunkHolder.updateFutures > ChunkMap.onLevelChange 48, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 26, ReferenceOpenHashSet.clear > Arrays.fill 12, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 9, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 4, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 4, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 1, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 1
- **PersistentEntitySectionManager.autoSave** 152: AbstractLongCollection.forEach 135, PersistentEntitySectionManager.getAllChunksToSave 16<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 135, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 12, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 1
- **ChunkMap.processUnloads** 53: ConcurrentLinkedQueue.size 18, CompletableFuture$Completion.run 12, ChunkMap.scheduleUnload 6, ChunkMap.saveChunksEagerly 4, LongOpenHashSet$SetIterator.remove 3, Long2ObjectLinkedOpenHashMap.put 2, Long2ObjectLinkedOpenHashMap.get 2, LongOpenHashSet.iterator 1, Long2ObjectLinkedOpenHashMap.remove 1, LongOpenHashSet$SetIterator.nextLong 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 12, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 4, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 2, ChunkMap.saveChunksEagerly > Util.getMillis 2, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 1, LongOpenHashSet$SetIterator.remove > LongOpenHashSet.remove 1, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 1, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 1
- **LevelChunk.runPostLoad** 23: SerializableChunkData.lambda$postLoadChunk$0 23<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 18, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 4
- **SerializableChunkData.read** 15: PoiManager.checkConsistencyWithBlocks 4, SerializableChunkData.unpackStructureReferences 3, LevelChunk.<init> 2, ImposterProtoChunk.<init> 2, LevelHeightAccessor.getSectionsCount 1, Heightmap.primeHeightmaps 1, SerializableChunkData.unpackStructureStart 1, ChunkAccess.addPackedPostProcess 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 4, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 2, LevelChunk.<init> > Int2ObjectOpenHashMap.<init> 2, ImposterProtoChunk.<init> > ProtoChunk.<init> 2, LevelHeightAccessor.getSectionsCount > LevelHeightAccessor.getMinSectionY 1, Heightmap.primeHeightmaps > RegularEnumSet.isEmpty 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, ChunkAccess.addPackedPostProcess > ShortList.addAll 1
- **ChunkMap.saveChunksEagerly** 4: Util.getMillis 2<br>two down: Util.getMillis > Util.getNanos 2
- **LevelChunk.<init>** 2: Int2ObjectOpenHashMap.<init> 2<br>two down: Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 2
- **SectionStorage.flush** 1: ChunkPos.pack 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2025: DedicatedServer.saveAllChunks 2008, MinecraftServer.warnOnLowDiskSpace 17<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2005, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 17
- **ServerLevel.save** 1830: ServerChunkCache.save 1652, PersistentEntitySectionManager.autoSave 143, ServerLevel.saveLevelData 33<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1652, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 130, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 31, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 11, PersistentEntitySectionManager.autoSave > MethodHandleNatives.linkMethodHandleConstant 1, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 1
- **ChunkMap.saveAllChunks** 1652: ChunkMap.saveChunkIfNeeded 1622, Long2ObjectLinkedOpenHashMap$ValueIterator.next 5, Long2ObjectLinkedOpenHashMap$1.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1593, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 9, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 5, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1, Long2ObjectLinkedOpenHashMap$1.iterator > Long2ObjectLinkedOpenHashMap$ValueIterator.<init> 1, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 1
- **ChunkMap.save** 1593: SerializableChunkData.copyOf 1545, CompletableFuture.supplyAsync 16, SimpleRegionStorage.write 13, ChunkMap.markPosition 11, SectionStorage.flush 3, DirectMethodHandle.allocateInstance 2, ChunkAccess.tryMarkSaved 1, ProfilerFiller.incrementCounter 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 670, SerializableChunkData.copyOf > LightEngine.getDataLayerData 193, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 131, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 130, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 97, SerializableChunkData.copyOf > ReferencePipeline.toArray 69, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 41, SerializableChunkData.copyOf > ArrayList.add 26, SerializableChunkData.copyOf > DataLayer.copy 22, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 16, SerializableChunkData.copyOf > DataLayer.isEmpty 16, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 15
- **SerializableChunkData.copyOf** 1545: LevelChunkSection.copy 670, LightEngine.getDataLayerData 193, LevelChunk.getBlockEntityNbtForSaving 131, SerializableChunkData.packStructureData 130, LevelChunk.getTicksForSerialization 97, ReferencePipeline.toArray 69, ChunkAccess.getBlockEntitiesPos 41, ArrayList.add 26, DataLayer.copy 22, LevelLightEngine.getMaxLightSection 16, DataLayer.isEmpty 16, Collections$UnmodifiableCollection$1.hasNext 11<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 667, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 192, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 129, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 95, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 69, SerializableChunkData.packStructureData > StructureStart.createTag 67, ArrayList.add > ArrayList.add 26, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 22, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 19, DataLayer.copy > DataLayer.<init> 17, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 15, SerializableChunkData.packStructureData > CompoundTag.put 13
- **DistanceManager.runAllUpdates** 582: LoadingChunkTracker.runDistanceUpdates 436, ChunkHolder.updateFutures 104, ReferenceOpenHashSet$SetIterator.next 14, ReferenceOpenHashSet.clear 10, GenerationChunkHolder.updateHighestAllowedStatus 6, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 436, ChunkHolder.updateFutures > ChunkMap.onLevelChange 59, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 26, ReferenceOpenHashSet.clear > Arrays.fill 10, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 9, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 7, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 5, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 2
- **PersistentEntitySectionManager.autoSave** 143: AbstractLongCollection.forEach 130, PersistentEntitySectionManager.getAllChunksToSave 11, MethodHandleNatives.linkMethodHandleConstant 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 130, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 5, MethodHandleNatives.linkMethodHandleConstant > MethodHandles$Lookup.linkMethodHandleConstant 1, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps$1.iterator 1
- **ChunkMap.processUnloads** 52: ConcurrentLinkedQueue.size 26, ChunkMap.scheduleUnload 10, CompletableFuture$Completion.run 7, LongOpenHashSet$SetIterator.remove 3, Long2ObjectLinkedOpenHashMap.remove 2, Long2ObjectLinkedOpenHashMap.put 1, ChunkMap.saveChunksEagerly 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 6, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 4, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet.remove 2, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 2, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 2, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 1, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 1, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 1, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1
- **SerializableChunkData.read** 14: PoiManager.checkConsistencyWithBlocks 9, ImposterProtoChunk.<init> 2, SerializableChunkData.unpackStructureReferences 1, SerializableChunkData.unpackStructureStart 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 7, ImposterProtoChunk.<init> > ProtoChunk.<init> 2, PoiManager.checkConsistencyWithBlocks > Util.ifElse 2, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1
- **LevelChunk.runPostLoad** 12: SerializableChunkData.lambda$postLoadChunk$0 11<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 7, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 2, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 1
- **SectionStorage.flush** 3: LongLinkedOpenHashSet.remove 3<br>two down: 
- **ChunkMap.saveChunksEagerly** 1: LongLinkedOpenHashSet.iterator 1<br>two down: LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 357 | 12563 | 12396 | 0 | 167 | 0 |
| 1 | quicksilver | 357 | 12619 | 12619 | 0 | 0 | 0 |
| 2 | vanilla | 357 | 12598 | 12591 | 0 | 7 | 0 |
| 2 | quicksilver | 357 | 12532 | 12528 | 0 | 4 | 0 |
| 3 | vanilla | 357 | 12752 | 12746 | 0 | 6 | 0 |
| 3 | quicksilver | 357 | 12570 | 12562 | 0 | 8 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-3 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 1 (0) | 0 (0) | LastUpdate 1 | 270 / 357 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 1 (0) | 0 (0) | LastUpdate 1 | 263 / 357 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 1 (0) | 0 (0) | LastUpdate 1 | 269 / 357 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 1 (0) | 0 (0) | LastUpdate 1 | 266 / 357 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 1 (0) | 0 (0) | LastUpdate 1 | 261 / 357 | 0 |

Vanilla's noise (rounds 2-3 against 1): dimensions/minecraft/overworld/entities: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1 data, 0 bytes only, 0 one side, keys LastUpdate 2

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 1.457 | 5.999 | 16.574 | 0 | 0.140 (0.068) | 0.317 (0.317) | 0.000 | - | 392: 16.6, 608: 16.5, 1008: 13.1, 228: 12.6, 962: 12.3 |
| 1 | quicksilver | yes | 1.021 | 5.758 | 13.701 | 0 | 0.125 (0.059) | 0.224 (0.224) | 0.000 | - | 384: 13.7, 1208: 13.0, 1136: 12.7, 613: 10.7, 112: 7.6 |
| 2 | vanilla | yes | 1.383 | 6.332 | 17.398 | 0 | 0.154 (0.063) | 0.324 (0.324) | 0.000 | - | 352: 17.4, 1256: 14.4, 1128: 12.4, 176: 11.2, 240: 8.4 |
| 2 | quicksilver | yes | 1.160 | 5.670 | 11.431 | 0 | 0.140 (0.066) | 0.248 (0.248) | 0.000 | - | 752: 11.4, 358: 10.9, 146: 9.8, 440: 9.6, 715: 9.5 |
| 3 | vanilla | yes | 1.151 | 5.843 | 16.480 | 0 | 0.138 (0.062) | 0.277 (0.277) | 0.000 | - | 1120: 16.5, 64: 13.6, 304: 9.5, 128: 8.5, 712: 8.1 |
| 3 | quicksilver | yes | 1.487 | 6.016 | 14.797 | 0 | 0.150 (0.073) | 0.319 (0.319) | 0.000 | - | 512: 14.8, 584: 12.3, 571: 10.0, 971: 9.6, 248: 7.6 |
| 4 | vanilla | yes | 1.259 | 6.614 | 15.016 | 0 | 0.158 (0.070) | 0.274 (0.274) | 0.000 | - | 616: 15.0, 712: 14.9, 496: 13.9, 280: 12.2, 481: 11.9 |
| 4 | quicksilver | yes | 1.431 | 6.106 | 14.914 | 0 | 0.140 (0.063) | 0.315 (0.315) | 0.000 | - | 280: 14.9, 496: 12.6, 212: 11.4, 232: 9.1, 120: 6.9 |
| 5 | vanilla | yes | 0.991 | 5.941 | 17.563 | 0 | 0.133 (0.066) | 0.210 (0.210) | 0.000 | - | 240: 17.6, 568: 13.3, 624: 12.7, 288: 9.3, 643: 8.6 |
| 5 | quicksilver | yes | 1.346 | 5.899 | 14.605 | 0 | 0.146 (0.074) | 0.296 (0.296) | 0.000 | - | 104: 14.6, 752: 13.9, 240: 10.6, 488: 10.5, 139: 9.0 |
| 6 | vanilla | yes | 1.129 | 5.747 | 12.263 | 0 | 0.142 (0.067) | 0.248 (0.248) | 0.000 | - | 872: 12.3, 816: 8.7, 619: 7.4, 394: 6.6, 688: 6.5 |
| 6 | quicksilver | yes | 1.167 | 6.698 | 13.188 | 0 | 0.154 (0.077) | 0.237 (0.237) | 0.000 | - | 368: 13.2, 364: 11.3, 211: 10.6, 904: 10.0, 90: 9.2 |
| 7 | vanilla | yes | 1.494 | 7.824 | 20.868 | 0 | 0.203 (0.095) | 0.307 (0.306) | 0.000 | - | 1080: 20.9, 240: 9.9, 120: 9.5, 116: 9.2, 128: 8.3 |
| 7 | quicksilver | yes | 1.489 | 7.487 | 22.966 | 0 | 0.203 (0.094) | 0.289 (0.289) | 0.000 | - | 1120: 23.0, 144: 18.7, 1058: 17.3, 1145: 14.2, 712: 9.4 |
| 8 | vanilla | yes | 1.525 | 8.069 | 14.419 | 0 | 0.192 (0.093) | 0.305 (0.305) | 0.000 | - | 1256: 14.4, 322: 10.5, 120: 9.9, 184: 9.5, 912: 9.2 |
| 8 | quicksilver | yes | 1.551 | 8.123 | 20.839 | 0 | 0.199 (0.097) | 0.282 (0.282) | 0.000 | - | 168: 20.8, 612: 15.7, 608: 12.0, 128: 10.1, 256: 10.0 |
| 9 | vanilla | yes | 1.559 | 7.910 | 18.447 | 0 | 0.192 (0.084) | 0.309 (0.309) | 0.000 | - | 368: 18.4, 464: 18.1, 880: 17.4, 616: 9.3, 88: 8.6 |
| 9 | quicksilver | yes | 1.557 | 8.581 | 22.928 | 0 | 0.213 (0.094) | 0.273 (0.273) | 0.000 | - | 696: 22.9, 1160: 19.3, 240: 15.6, 1232: 14.7, 616: 12.5 |
| 10 | vanilla | yes | 1.684 | 8.618 | 24.733 | 0 | 0.192 (0.097) | 0.365 (0.365) | 0.000 | - | 568: 24.7, 640: 22.2, 1232: 21.8, 612: 15.5, 352: 12.7 |
| 10 | quicksilver | yes | 1.516 | 7.752 | 19.481 | 0 | 0.196 (0.098) | 0.272 (0.272) | 0.000 | - | 82: 19.5, 608: 10.6, 616: 10.5, 1024: 10.4, 120: 9.0 |
| 11 | vanilla | yes | 1.536 | 7.978 | 25.316 | 0 | 0.211 (0.104) | 0.321 (0.321) | 0.000 | - | 216: 25.3, 755: 12.1, 728: 9.6, 320: 8.9, 608: 8.8 |
| 11 | quicksilver | yes | 1.545 | 8.454 | 22.117 | 0 | 0.195 (0.099) | 0.283 (0.283) | 0.000 | - | 952: 22.1, 1099: 16.2, 947: 15.9, 248: 11.9, 328: 11.3 |
| 12 | vanilla | yes | 1.539 | 7.778 | 15.308 | 0 | 0.199 (0.088) | 0.304 (0.304) | 0.000 | - | 835: 15.3, 840: 13.9, 128: 10.9, 248: 10.3, 240: 10.0 |
| 12 | quicksilver | yes | 1.504 | 7.500 | 20.034 | 0 | 0.192 (0.093) | 0.294 (0.294) | 0.000 | - | 952: 20.0, 240: 12.6, 402: 12.5, 712: 9.2, 120: 8.6 |
| 13 | vanilla | yes | 1.788 | 9.028 | 17.831 | 0 | 0.176 (0.073) | 0.365 (0.365) | 0.000 | - | 944: 17.8, 88: 17.0, 632: 16.6, 744: 15.0, 1042: 12.7 |
| 13 | quicksilver | yes | 1.704 | 7.195 | 17.322 | 0 | 0.181 (0.082) | 0.362 (0.362) | 0.000 | - | 1208: 17.3, 1144: 16.9, 346: 13.4, 259: 13.2, 232: 9.4 |
| 14 | vanilla | yes | 1.410 | 7.244 | 17.836 | 0 | 0.183 (0.085) | 0.298 (0.298) | 0.000 | - | 240: 17.8, 1208: 12.0, 72: 9.5, 96: 8.7, 880: 8.5 |
| 14 | quicksilver | yes | 1.740 | 7.288 | 17.773 | 0 | 0.199 (0.090) | 0.365 (0.365) | 0.000 | - | 616: 17.8, 576: 17.4, 1128: 16.0, 224: 9.7, 248: 8.9 |
| 15 | vanilla | yes | 1.195 | 6.152 | 12.047 | 0 | 0.192 (0.074) | 0.256 (0.256) | 0.000 | - | 691: 12.0, 144: 8.9, 120: 7.2, 72: 7.0, 1144: 6.9 |
| 15 | quicksilver | yes | 1.214 | 6.439 | 13.307 | 0 | 0.167 (0.073) | 0.258 (0.258) | 0.000 | - | 352: 13.3, 128: 12.4, 768: 11.1, 240: 9.0, 74: 8.9 |
| 16 | vanilla | yes | 1.224 | 6.113 | 19.689 | 0 | 0.168 (0.075) | 0.286 (0.286) | 0.000 | - | 64: 19.7, 268: 11.3, 314: 9.2, 720: 9.1, 216: 7.7 |
| 16 | quicksilver | yes | 1.553 | 6.783 | 18.693 | 0 | 0.182 (0.074) | 0.328 (0.328) | 0.000 | - | 112: 18.7, 1072: 16.5, 232: 10.4, 96: 10.3, 120: 9.6 |
| 17 | vanilla | yes | 1.353 | 6.681 | 20.098 | 0 | 0.180 (0.078) | 0.290 (0.290) | 0.000 | - | 248: 20.1, 960: 16.8, 344: 14.1, 380: 13.6, 298: 12.3 |
| 17 | quicksilver | yes | 1.398 | 6.889 | 18.387 | 0 | 0.183 (0.081) | 0.286 (0.286) | 0.000 | - | 512: 18.4, 368: 18.0, 240: 15.3, 1011: 11.8, 571: 10.4 |
| 18 | vanilla | yes | 1.542 | 7.266 | 18.566 | 0 | 0.201 (0.085) | 0.317 (0.317) | 0.000 | - | 200: 18.6, 488: 11.4, 353: 10.3, 72: 8.7, 984: 8.4 |
| 18 | quicksilver | yes | 1.336 | 6.796 | 16.439 | 0 | 0.175 (0.076) | 0.274 (0.274) | 0.000 | - | 496: 16.4, 1256: 14.9, 1224: 12.0, 107: 11.6, 129: 10.2 |
| 19 | vanilla | yes | 1.772 | 8.593 | 19.769 | 0 | 0.219 (0.118) | 0.348 (0.348) | 0.000 | - | 1139: 19.8, 384: 18.3, 744: 17.5, 498: 17.0, 616: 13.8 |
| 19 | quicksilver | yes | 1.810 | 9.011 | 21.797 | 0 | 0.217 (0.101) | 0.325 (0.325) | 0.000 | - | 410: 21.8, 1140: 17.3, 608: 11.6, 1096: 11.4, 216: 11.4 |
| 20 | vanilla | yes | 1.717 | 8.203 | 27.397 | 0 | 0.222 (0.101) | 0.320 (0.320) | 0.000 | - | 352: 27.4, 1248: 19.1, 616: 11.4, 760: 10.2, 624: 9.2 |
| 20 | quicksilver | yes | 1.833 | 9.216 | 20.868 | 0 | 0.184 (0.092) | 0.332 (0.332) | 0.000 | - | 92: 20.9, 371: 20.7, 64: 20.3, 992: 18.7, 912: 16.7 |
| 21 | vanilla | yes | 1.753 | 9.083 | 20.346 | 0 | 0.210 (0.098) | 0.335 (0.335) | 0.000 | - | 352: 20.3, 952: 19.0, 171: 17.8, 560: 16.9, 520: 12.4 |
| 21 | quicksilver | yes | 1.831 | 8.950 | 21.431 | 0 | 0.231 (0.102) | 0.344 (0.344) | 0.000 | - | 1112: 21.4, 251: 15.7, 115: 13.3, 224: 12.2, 226: 11.0 |
| 22 | vanilla | yes | 1.753 | 9.389 | 20.280 | 0 | 0.183 (0.085) | 0.339 (0.339) | 0.000 | - | 608: 20.3, 944: 19.2, 872: 17.0, 504: 16.2, 1008: 15.1 |
| 22 | quicksilver | yes | 1.688 | 8.771 | 23.586 | 0 | 0.199 (0.096) | 0.318 (0.318) | 0.000 | - | 1136: 23.6, 840: 18.2, 156: 13.4, 875: 12.2, 72: 11.3 |
| 23 | vanilla | yes | 1.805 | 8.415 | 23.984 | 0 | 0.217 (0.106) | 0.358 (0.358) | 0.000 | - | 96: 24.0, 352: 20.2, 696: 19.6, 256: 11.5, 144: 10.9 |
| 23 | quicksilver | yes | 1.759 | 8.201 | 23.635 | 0 | 0.205 (0.094) | 0.324 (0.324) | 0.000 | - | 608: 23.6, 880: 20.6, 128: 18.8, 616: 16.8, 216: 15.7 |
| 24 | vanilla | yes | 1.619 | 8.480 | 19.307 | 0 | 0.186 (0.085) | 0.319 (0.319) | 0.000 | - | 880: 19.3, 219: 18.4, 592: 18.2, 224: 10.7, 344: 9.9 |
| 24 | quicksilver | yes | 1.644 | 8.252 | 10.120 | 0 | 0.208 (0.101) | 0.324 (0.324) | 0.000 | - | 232: 10.1, 608: 10.1, 96: 10.1, 128: 10.0, 104: 9.8 |

Tick numbers (MSPT, p99, slowest, over 50 ms) leave out the first 64 ticks (warm-up); JFR ms per tick is the whole run.

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) | gated: trimmed geometric mean of rounds |
|---|---|---|---|---|
| MSPT average | 1.530 | 1.531 | 1.016 (0.70 to 1.36) | 1.024 |
| MSPT p99 | 7.801 | 7.388 | 0.989 (0.80 to 1.17) | 0.995 |
| slowest tick (ms) | 18.506 | 18.540 | 0.978 (0.52 to 1.45) | 0.964 |
| ticks over 50 ms | 0.000 | 0.000 | - (- to -) | - |
| chunk load, ms per tick (server thread) | 0.189 | 0.188 | 1.017 (0.83 to 1.12) | 1.001 |
|   of it in the tick | 0.085 | 0.091 | 1.034 (0.85 to 1.19) | 1.019 |
| chunk save, ms per tick (server thread) | 0.313 | 0.295 | 0.961 (0.71 to 1.41) | 0.968 |
|   of it in the tick | 0.313 | 0.295 | 0.961 (0.71 to 1.41) | 0.968 |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) | - |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) | - |
| save-all flush tick (ms) | - | - | - (- to -) | - |
| autosave tick (ms, the game's own) | - | - | - (- to -) | - |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 63021 ms, 18839 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 362 / 0 | 0 / 0 | 0.286 | 425.6 |
| entity save | 27 / 0 | 0 / 0 | 0.021 | 5.7 |
| POI save | 11 / 0 | 0 / 0 | 0.009 | 0.0 |
| chunk load | 0 / 0 | 38 / 2 | 0.032 | 76.5 |
| chunk to full (promote) | 76 / 0 | 49 / 0 | 0.099 | 41.1 |
| entity load | 10 / 0 | 2 / 0 | 0.009 | 0.3 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 11 / 0 | 0 / 0 | 0.009 | 14.2 |
| light | 0 / 0 | 3 / 0 | 0.002 | 1.0 |
| chunk system (tickets, holders, tasks) | 404 / 0 | 174 / 1 | 0.458 | 190.5 |
| tick, other | 528 / 1 | 0 / 0 | 0.418 | 4.3 |
| idle or other | 0 / 0 | 82 / 2 | 0.067 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 1168, MinecraftServer.runServer 1168, Thread.run 1167, MinecraftServer.tickServer 901, MinecraftServer.processPacketsAndTick 901, DedicatedServer.tickServer 901, MinecraftServer.tickChildren 891, ServerLevel.tick 891, ServerChunkCache.tick 838, ChunkMap.tick 402, ChunkMap.processUnloads 372, ServerChunkCache.runDistanceManagerUpdates 361, DistanceManager.runAllUpdates 358, ChunkMap.saveChunksEagerly 352, ServerChunkCache$MainThreadExecutor.pollTask 269, ServerChunkCache.pollTask 269, MinecraftServer.waitUntilNextTick 268, MinecraftServer.pollTask 268, MinecraftServer.pollTaskInternal 268, BlockableEventLoop.managedBlock 255, BlockableEventLoop.pollTask 254, BlockableEventLoop.doRunTask 251, ServerChunkCache$MainThreadExecutor.doRunTask 251, ChunkMap.saveChunkIfNeeded 235, DynamicGraphMinFixedPoint.runUpdates 220, LoadingChunkTracker.runDistanceUpdates 219, CompletableFuture$Completion.run 211, ChunkMap.save 205, SerializableChunkData.copyOf 202, CompletableFuture$UniApply.tryFire 193, ChunkTracker.checkNeighborsAfterUpdate 188, DynamicGraphMinFixedPoint.checkNeighbor 181, DynamicGraphMinFixedPoint.checkEdge 152, ChunkResult$Success.map 144, ChunkMap.lambda$prepareTickingChunk$2 142, ChunkMap.lambda$prepareTickingChunk$1 142, LevelChunk.postProcessGeneration 137, Long2ObjectLinkedOpenHashMap.get 124, ChunkHolder.updateFutures 114, LoadingChunkTracker.getLevel 111, ChunkTracker.getComputedLevel 107, GenerationChunkHolder.getLatestChunk 100, ChunkMap.getUpdatingChunkIfPresent 74, ServerChunkCache.tickChunks 73, Block.updateFromNeighbourShapes 73, ChunkMap$DistanceManager.getChunk 73, GenerationChunkHolder.getChunkIfPresentUnchecked 65, ChunkMap.getChunkRangeFuture 60, LevelChunkSection.copy 58, LevelChunkSection.<init> 58, PalettedContainer.copy 57, PalettedContainer.<init> 51, NaturalSpawner.createState 50, PalettedContainer.get 50, CompletableFuture$AsyncSupply.run 49, Level.getBlockState 47, LightEngine.getDataLayerData 47, LayerLightSectionStorage.getDataLayerData 47, PalettedContainer$Data.copy 47, Encoder.encodeStart 45

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 124, GenerationChunkHolder.getChunkIfPresentUnchecked 54, PalettedContainer.get 44, PalettedContainer$Data.copy 43, GenerationChunkHolder.getLatestChunk 41, Long2ObjectOpenHashMap.get 40, LongOpenHashSet.contains 39, DynamicGraphMinFixedPoint.checkEdge 32, Long2ByteOpenHashMap.get 21, ChunkMap.saveChunksEagerly 20, ChunkMap.onLevelChange 15, Long2LongOpenHashMap.getOrDefault 15, NaturalSpawner.createState 13, ChunkTracker.getComputedLevel 12, Long2ObjectFunctions$SynchronizedFunction.get 12, VarHandleReferences$Array.getVolatile 11, DistanceManager.runAllUpdates 11, CompletableFuture.allOf 11, AbstractConsecutiveExecutor.schedule 9, LongLinkedOpenHashSet$SetIterator.nextLong 9, ServerChunkCache.getChunk 8, HashMap.getNode 8, Long2ObjectOpenHashMap.getOrDefault 8, DynamicGraphMinFixedPoint.checkNeighbor 7, ChunkTracker.checkNeighborsAfterUpdate 7, PalettedContainer.copy 7, DataLayer.<init> 7, FluidState.isEmpty 6, BlockBehaviour$BlockStateBase.updateShape 6, Long2ObjectOpenHashMap.<init> 5

Threads (all samples in the window): Netty Epoll IO  53365, IO-Worker 6550, Worker-Main 3255, Server thread 1783, JFR Periodic Tasks 11, JNA Cleaner 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 63044 ms, 18895 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 266 / 0 | 0 / 0 | 0.210 | 231.1 |
| entity save | 13 / 0 | 0 / 0 | 0.010 | 22.5 |
| POI save | 4 / 0 | 0 / 0 | 0.003 | 0.7 |
| chunk load | 0 / 0 | 40 / 1 | 0.032 | 29.0 |
| chunk to full (promote) | 66 / 0 | 42 / 0 | 0.085 | 38.9 |
| entity load | 9 / 0 | 0 / 0 | 0.007 | 0.3 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 11 / 0 | 0 / 0 | 0.009 | 8.9 |
| light | 0 / 0 | 3 / 0 | 0.002 | 0.0 |
| chunk system (tickets, holders, tasks) | 336 / 0 | 168 / 0 | 0.399 | 272.2 |
| tick, other | 310 / 0 | 0 / 0 | 0.245 | 6.1 |
| idle or other | 0 / 0 | 66 / 0 | 0.052 | 0.0 |

Top chunk methods (inclusive): Thread.run 955, MinecraftServer.lambda$spin$0 955, MinecraftServer.runServer 955, MinecraftServer.processPacketsAndTick 705, DedicatedServer.tickServer 705, MinecraftServer.tickServer 705, MinecraftServer.tickChildren 700, ServerLevel.tick 700, ServerChunkCache.tick 661, ServerChunkCache.runDistanceManagerUpdates 318, DistanceManager.runAllUpdates 314, ChunkMap.tick 290, ChunkMap.processUnloads 276, ServerChunkCache$MainThreadExecutor.pollTask 252, ServerChunkCache.pollTask 252, MinecraftServer.pollTaskInternal 252, MinecraftServer.pollTask 252, ChunkMap.saveChunksEagerly 251, MinecraftServer.waitUntilNextTick 251, BlockableEventLoop.pollTask 246, BlockableEventLoop.managedBlock 246, BlockableEventLoop.doRunTask 245, ServerChunkCache$MainThreadExecutor.doRunTask 244, ChunkMap.saveChunkIfNeeded 228, CompletableFuture$Completion.run 209, DynamicGraphMinFixedPoint.runUpdates 200, LoadingChunkTracker.runDistanceUpdates 200, CompletableFuture$UniApply.tryFire 184, ChunkMap.save 176, ChunkTracker.checkNeighborsAfterUpdate 174, SerializableChunkData.copyOf 172, DynamicGraphMinFixedPoint.checkNeighbor 171, DynamicGraphMinFixedPoint.checkEdge 138, ChunkResult$Success.map 137, ChunkMap.lambda$prepareTickingChunk$2 137, ChunkMap.lambda$prepareTickingChunk$1 137, LevelChunk.postProcessGeneration 127, Long2ObjectLinkedOpenHashMap.get 122, LoadingChunkTracker.getLevel 111, ChunkHolder.updateFutures 102, ChunkTracker.getComputedLevel 93, ChunkMap.getUpdatingChunkIfPresent 78, ChunkMap$DistanceManager.getChunk 76, Block.updateFromNeighbourShapes 72, Long2LongOpenHashMap.getOrDefault 58, ChunkMap.getChunkRangeFuture 57, PalettedContainer.get 50, GenerationChunkHolder.scheduleChunkGenerationTask 47, CompletableFuture$AsyncSupply.run 47, Level.getBlockState 45, LevelChunk.getBlockState 45, ServerChunkCache.tickChunks 44, GenerationChunkHolder.rescheduleChunkTask 44, ChunkMap.scheduleGenerationTask 44, LevelChunkSection.getBlockState 44, ChunkMap.acquireGeneration 43, ChunkGenerationTask.lambda$create$0 43, StaticCache2D.create 43, StaticCache2D.<init> 43, ChunkGenerationTask.create 43

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 122, Long2LongOpenHashMap.getOrDefault 58, PalettedContainer.get 41, DynamicGraphMinFixedPoint.checkEdge 38, LongOpenHashSet.contains 35, Long2ByteOpenHashMap.get 26, Long2ObjectOpenHashMap.get 22, Long2ObjectFunctions$SynchronizedFunction.get 19, PalettedContainer.create$quicksilver_$md$abdfe5$0 17, LevelChunkSection.<init> 15, ChunkMap.onLevelChange 12, ServerChunkCache.getChunk 11, GenerationChunkHolder.getChunkIfPresentUnchecked 11, GenerationChunkHolder.increaseGenerationRefCount 10, SerializableChunkData.copyOf 10, BlockBehaviour$BlockStateBase.updateShape 8, HashMap.getNode 8, AbstractConsecutiveExecutor.schedule 8, ChunkTracker.getComputedLevel 7, ConcurrentLinkedQueue.offer 7, CrudeIncrementalIntIdentityHashBiMap.byId 7, ChunkMap.saveChunksEagerly 7, DirectMethodHandle.allocateInstance 6, LocalCache.connectAccessOrder 6, ChunkMap.saveChunkIfNeeded 6, Long2ObjectOpenHashMap.getOrDefault 6, RecordCodecBuilder$Instance.lambda$ap3$6 5, PriorityQueue.siftUpUsingComparator 5, TicketStorage.removeTicketIf 5, MultifaceBlock.hasAnyFace 5

Threads (all samples in the window): Netty Epoll IO  53535, IO-Worker 6233, Worker-Main 3383, Server thread 1335, JFR Periodic Tasks 7

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 9863: LoadingChunkTracker.runDistanceUpdates 6165, ChunkHolder.updateFutures 3262, GenerationChunkHolder.updateHighestAllowedStatus 156, ReferenceOpenHashSet$SetIterator.next 36, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 22, ReferenceOpenHashSet.clear 19, DistanceManager$PlayerTicketTracker.runAllUpdates 12, SimulationChunkTracker.runAllUpdates 9, ReferenceOpenHashSet.iterator 6<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 6161, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 1002, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 590, ChunkHolder.updateFutures > ChunkMap.onLevelChange 579, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 475, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 418, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 101, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 62, ChunkHolder.updateFutures > CompletableFuture.complete 33, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 21, ReferenceOpenHashSet.clear > Arrays.fill 18, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 12
- **ChunkMap.processUnloads** 8974: ChunkMap.saveChunksEagerly 8240, CompletableFuture$Completion.run 580, ChunkMap.scheduleUnload 44, Long2ObjectLinkedOpenHashMap.remove 16, ConcurrentLinkedQueue.size 16, Long2ObjectLinkedOpenHashMap.put 10, LongOpenHashSet.iterator 10, MinecraftServer.haveTime 7, LongOpenHashSet$SetIterator.remove 5, ConcurrentLinkedQueue.poll 4, LongOpenHashSet$SetIterator.nextLong 3, Long2ObjectLinkedOpenHashMap.get 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 6073, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 1331, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 579, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 325, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 112, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 22, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 15, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 13, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 11, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 9, MinecraftServer.haveTime > Util.getNanos 7, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 7
- **ChunkMap.saveChunksEagerly** 8240: ChunkMap.saveChunkIfNeeded 6073, GenerationChunkHolder.getLatestChunk 1331, Long2ObjectLinkedOpenHashMap.get 325, LongLinkedOpenHashSet$SetIterator.nextLong 112, LongLinkedOpenHashSet$SetIterator.remove 13, Util.getMillis 5, MinecraftServer.haveTime 4, LongLinkedOpenHashSet.iterator 3<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 4990, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 1089, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 753, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 229, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 10, Util.getMillis > Util.getNanos 5, MinecraftServer.haveTime > Util.getNanos 4, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 3, ChunkMap.saveChunkIfNeeded > ChunkHolder.isReadyForSaving 2, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 1
- **ChunkMap.save** 5395: SerializableChunkData.copyOf 5261, CompletableFuture.supplyAsync 42, SimpleRegionStorage.write 31, ChunkMap.markPosition 23, CompletableFuture.handle 5, ChunkAccess.tryMarkSaved 5, Profiler.get 4, DirectMethodHandle.allocateInstance 4, SectionStorage.flush 3, ProfilerFiller.incrementCounter 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 1322, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 1137, SerializableChunkData.copyOf > LightEngine.getDataLayerData 1049, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 613, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 220, SerializableChunkData.copyOf > ReferencePipeline.toArray 185, SerializableChunkData.copyOf > DataLayer.copy 138, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 120, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 40, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 38, SimpleRegionStorage.write > IOWorker.store 30, ChunkMap.markPosition > Long2ByteOpenHashMap.put 21
- **SerializableChunkData.copyOf** 5261: LevelChunkSection.copy 1322, LevelChunk.getBlockEntityNbtForSaving 1137, LightEngine.getDataLayerData 1049, SerializableChunkData.packStructureData 613, LevelChunk.getTicksForSerialization 220, ReferencePipeline.toArray 185, DataLayer.copy 138, ChunkAccess.getBlockEntitiesPos 120, Collections$UnmodifiableCollection$1.hasNext 39, ProblemReporter$ScopedCollector.close 19, ArrayList.add 17, LevelLightEngine.getMaxLightSection 15<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 1289, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 1093, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 1035, SerializableChunkData.packStructureData > StructureStart.createTag 421, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 208, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 181, DataLayer.copy > DataLayer.<init> 112, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 72, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 36, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 30, SerializableChunkData.packStructureData > Identifier.toString 27, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 25
- **LevelChunk.postProcessGeneration** 4174: Block.updateFromNeighbourShapes 2432, FluidState.tick 687, BlockBehaviour$BlockStateBase.tick 516, LevelChunk.getBlockState 236, FluidState.isEmpty 79, LevelWriter.setBlock 41, UpgradeData.upgrade 33, ImmutableList.copyOf 21, LevelHeightAccessor.getSectionYFromSectionIndex 14, ShortListIterator.next 13, ProtoChunk.unpackOffsetCoordinates 4, ShortArrayList$1.hasNext 4<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 1354, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 988, FluidState.tick > FlowingFluid.tick 681, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 514, LevelChunk.getBlockState > LevelChunkSection.getBlockState 235, LevelWriter.setBlock > Level.setBlock 37, UpgradeData.upgrade > Iterable.forEach 15, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 14, ShortListIterator.next > ShortListIterator.next 13, UpgradeData.upgrade > UpgradeData.upgradeInside 9, ImmutableList.copyOf > HashMap$KeySet.toArray 4, ImmutableList.copyOf > ImmutableList.construct 3
- **SerializableChunkData.read** 1482: SerializableChunkData.unpackStructureStart 793, LevelChunkTicks.<init> 170, PoiManager.checkConsistencyWithBlocks 162, ImposterProtoChunk.<init> 100, SerializableChunkData.unpackStructureReferences 98, ChunkAccess.setAllReferences 24, LevelChunk.<init> 21, ChunkAccess.addPackedPostProcess 21, ChunkAccess.setHeightmap 10, ThreadedLevelLightEngine.queueSectionData 10, ChunkAccess.setAllStarts 7, ThreadedLevelLightEngine.retainData 7<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 775, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 167, ImposterProtoChunk.<init> > ProtoChunk.<init> 98, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 92, PoiManager.checkConsistencyWithBlocks > Util.ifElse 88, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 74, ChunkAccess.addPackedPostProcess > ShortList.addAll 21, ChunkAccess.setAllReferences > HashMap.putAll 19, LevelChunk.<init> > ChunkAccess.<init> 13, SerializableChunkData.unpackStructureStart > RegistryAccess.lookupOrThrow 9, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 8, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 6
- **LevelChunk.runPostLoad** 893: SerializableChunkData.lambda$postLoadChunk$0 888<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 746, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 47, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 40, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 23, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 13, SerializableChunkData.lambda$postLoadChunk$0 > ImmutableCollections$ListItr.next 1
- **LevelChunk.<init>** 21: ChunkAccess.<init> 13, Heightmap.<init> 4, RegularEnumSet.contains 1, Int2ObjectOpenHashMap.<init> 1<br>two down: ChunkAccess.<init> > ChunkAccess.replaceMissingSections 6, ChunkAccess.<init> > Maps.newEnumMap 2, Heightmap.<init> > Mth.ceillog2 2, Heightmap.<init> > SimpleBitStorage.<init> 1, Heightmap.<init> > ChunkAccess.getHeight 1, ChunkAccess.<init> > ChunkSkyLightSources.<init> 1
- **SectionStorage.flush** 3: LongLinkedOpenHashSet.remove 2<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 9880: LoadingChunkTracker.runDistanceUpdates 6178, ChunkHolder.updateFutures 3228, GenerationChunkHolder.updateHighestAllowedStatus 187, ReferenceOpenHashSet$SetIterator.next 32, ReferenceOpenHashSet.clear 27, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 15, DistanceManager$PlayerTicketTracker.runAllUpdates 11, SimulationChunkTracker.runAllUpdates 8, ReferenceOpenHashSet.iterator 6, ReferenceOpenHashSet.isEmpty 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 6177, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 951, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 605, ChunkHolder.updateFutures > ChunkMap.onLevelChange 587, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 451, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 438, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 123, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 56, ChunkHolder.updateFutures > CompletableFuture.complete 30, ReferenceOpenHashSet.clear > Arrays.fill 26, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 20, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 15
- **ChunkMap.processUnloads** 8702: ChunkMap.saveChunksEagerly 7958, CompletableFuture$Completion.run 582, ChunkMap.scheduleUnload 47, LongOpenHashSet.iterator 15, Long2ObjectLinkedOpenHashMap.remove 12, MinecraftServer.haveTime 8, ConcurrentLinkedQueue.size 8, LongOpenHashSet$SetIterator.remove 8, ConcurrentLinkedQueue.poll 8, Long2ObjectLinkedOpenHashMap.put 7, LongOpenHashSet$SetIterator.nextLong 3, Long2ObjectLinkedOpenHashMap.get 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 5770, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 1320, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 582, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 325, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 119, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 21, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 15, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 11, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 11, MinecraftServer.haveTime > Util.getNanos 8, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 7, ChunkMap.saveChunksEagerly > Util.getMillis 7
- **ChunkMap.saveChunksEagerly** 7958: ChunkMap.saveChunkIfNeeded 5770, GenerationChunkHolder.getLatestChunk 1320, Long2ObjectLinkedOpenHashMap.get 325, LongLinkedOpenHashSet$SetIterator.nextLong 119, LongLinkedOpenHashSet$SetIterator.remove 15, Util.getMillis 7, MinecraftServer.haveTime 3, LongLinkedOpenHashSet.iterator 2<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 4490, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 1256, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1014, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 163, Util.getMillis > Util.getNanos 7, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 6, ChunkMap.saveChunkIfNeeded > ChunkPos.pack 5, MinecraftServer.haveTime > Util.getNanos 3, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 3, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2, ChunkMap.saveChunkIfNeeded > ChunkHolder.isReadyForSaving 1, LongLinkedOpenHashSet$SetIterator.remove > LongLinkedOpenHashSet.fixPointers 1
- **ChunkMap.save** 4904: SerializableChunkData.copyOf 4770, SimpleRegionStorage.write 31, CompletableFuture.supplyAsync 24, ChunkMap.markPosition 17, SectionStorage.flush 9, CompletableFuture.handle 9, DirectMethodHandle.allocateInstance 7, Profiler.get 4, ChunkAccess.tryMarkSaved 1, ProfilerFiller.incrementCounter 1<br>two down: SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 1080, SerializableChunkData.copyOf > LightEngine.getDataLayerData 1003, SerializableChunkData.copyOf > LevelChunkSection.copy 803, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 643, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 271, SerializableChunkData.copyOf > ReferencePipeline.toArray 198, SerializableChunkData.copyOf > DataLayer.copy 172, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 112, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 34, SimpleRegionStorage.write > IOWorker.store 30, SerializableChunkData.copyOf > Heightmap.getRawData 24, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 22
- **SerializableChunkData.copyOf** 4770: LevelChunk.getBlockEntityNbtForSaving 1080, LightEngine.getDataLayerData 1003, LevelChunkSection.copy 803, SerializableChunkData.packStructureData 643, LevelChunk.getTicksForSerialization 271, ReferencePipeline.toArray 198, DataLayer.copy 171, ChunkAccess.getBlockEntitiesPos 111, Collections$UnmodifiableCollection$1.hasNext 32, Heightmap.getRawData 19, ArrayList.add 19, ChunkAccess.getHeightmaps 15<br>two down: LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 1045, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 993, LevelChunkSection.copy > LevelChunkSection.<init> 785, SerializableChunkData.packStructureData > StructureStart.createTag 458, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 252, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 191, DataLayer.copy > DataLayer.<init> 140, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 62, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 36, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 30, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 24, ArrayList.add > ArrayList.add 21
- **LevelChunk.postProcessGeneration** 4381: Block.updateFromNeighbourShapes 2562, FluidState.tick 725, BlockBehaviour$BlockStateBase.tick 572, LevelChunk.getBlockState 207, FluidState.isEmpty 89, LevelWriter.setBlock 40, UpgradeData.upgrade 30, LevelHeightAccessor.getSectionYFromSectionIndex 25, ImmutableList.copyOf 25, ProtoChunk.unpackOffsetCoordinates 9, ShortArrayList$1.hasNext 6, ShortListIterator.next 3<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 1399, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 1047, FluidState.tick > FlowingFluid.tick 721, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 572, LevelChunk.getBlockState > LevelChunkSection.getBlockState 206, LevelWriter.setBlock > Level.setBlock 39, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 25, UpgradeData.upgrade > Iterable.forEach 9, UpgradeData.upgrade > UpgradeData.upgradeInside 8, ImmutableList.copyOf > ImmutableList.construct 3, ShortListIterator.next > ShortListIterator.next 3, UpgradeData.upgrade > UpgradeData.upgradeSides 3
- **SerializableChunkData.read** 1417: SerializableChunkData.unpackStructureStart 796, PoiManager.checkConsistencyWithBlocks 156, LevelChunkTicks.<init> 151, SerializableChunkData.unpackStructureReferences 93, ImposterProtoChunk.<init> 78, LevelChunk.<init> 35, ChunkAccess.addPackedPostProcess 18, ChunkAccess.setAllReferences 13, ChunkAccess.setAllStarts 9, ChunkAccess.setHeightmap 7, ThreadedLevelLightEngine.queueSectionData 5, ThreadedLevelLightEngine.retainData 5<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 769, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 150, PoiManager.checkConsistencyWithBlocks > Util.ifElse 91, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 90, ImposterProtoChunk.<init> > ProtoChunk.<init> 75, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 65, LevelChunk.<init> > ChunkAccess.<init> 21, ChunkAccess.addPackedPostProcess > ShortList.addAll 17, ChunkAccess.setAllReferences > HashMap.putAll 12, SerializableChunkData.unpackStructureStart > CompoundTag.getCompoundOrEmpty 9, LevelChunk.<init> > Heightmap.<init> 8, SerializableChunkData.unpackStructureStart > RegistryAccess.lookupOrThrow 6
- **LevelChunk.runPostLoad** 917: SerializableChunkData.lambda$postLoadChunk$0 916<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 767, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 55, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 35, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 26, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 21, SerializableChunkData.lambda$postLoadChunk$0 > ImmutableCollections$AbstractImmutableList.iterator 1, SerializableChunkData.lambda$postLoadChunk$0 > ProblemReporter$ScopedCollector.close 1, SerializableChunkData.lambda$postLoadChunk$0 > ImmutableCollections$ListN.isEmpty 1
- **LevelChunk.<init>** 35: ChunkAccess.<init> 21, Heightmap.<init> 8, Maps.newHashMap 3, Int2ObjectOpenHashMap.<init> 2, EnumMap.put 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 7, ChunkAccess.<init> > ChunkAccess.replaceMissingSections 7, Heightmap.<init> > Mth.ceillog2 6, ChunkAccess.<init> > Object2ObjectOpenHashMap.<init> 2, Heightmap.<init> > ChunkAccess.getHeight 2, ChunkAccess.<init> > Maps.newEnumMap 1, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1, EnumMap.put > EnumMap.put 1
- **SectionStorage.flush** 9: LongLinkedOpenHashSet.remove 5, ChunkPos.pack 4<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 1614 | 6378 | 3521 | 2736 | 121 | 44 (first [-1, -18]) |
| 1 | quicksilver | 1614 | 6379 | 3566 | 2725 | 88 | 61 (first [-13, 19]) |
| 2 | vanilla | 1614 | 6378 | 3543 | 2755 | 80 | 73 (first [-1, 17]) |
| 2 | quicksilver | 1614 | 6378 | 3518 | 2757 | 103 | 52 (first [-1, -17]) |
| 3 | vanilla | 1614 | 6379 | 3557 | 2718 | 104 | 75 (first [-10, -19]) |
| 3 | quicksilver | 1614 | 6378 | 3548 | 2729 | 101 | 74 (first [-1, 9]) |
| 4 | vanilla | 1614 | 6378 | 3479 | 2719 | 180 | 66 (first [-1, 18]) |
| 4 | quicksilver | 1614 | 6378 | 3529 | 2727 | 122 | 70 (first [-1, 18]) |
| 5 | vanilla | 1614 | 6380 | 3510 | 2718 | 152 | 47 (first [-16, 10]) |
| 5 | quicksilver | 1614 | 6378 | 3515 | 2762 | 101 | 45 (first [-10, 16]) |
| 6 | vanilla | 1614 | 6378 | 3527 | 2697 | 154 | 61 (first [-1, 9]) |
| 6 | quicksilver | 1614 | 6378 | 3547 | 2679 | 152 | 75 (first [-13, -18]) |
| 7 | vanilla | 1614 | 6378 | 3527 | 2673 | 178 | 81 (first [-10, 11]) |
| 7 | quicksilver | 1614 | 6378 | 3524 | 2743 | 111 | 59 (first [-1, 10]) |
| 8 | vanilla | 1614 | 6379 | 3488 | 2735 | 156 | 61 (first [-1, -16]) |
| 8 | quicksilver | 1614 | 6378 | 3530 | 2771 | 77 | 47 (first [-1, 9]) |
| 9 | vanilla | 1614 | 6378 | 3514 | 2784 | 80 | 51 (first [-12, -19]) |
| 9 | quicksilver | 1614 | 6378 | 3550 | 2738 | 90 | 67 (first [-10, 16]) |
| 10 | vanilla | 1614 | 6378 | 3514 | 2716 | 148 | 59 (first [-1, -17]) |
| 10 | quicksilver | 1614 | 6378 | 3479 | 2792 | 107 | 45 (first [-12, 16]) |
| 11 | vanilla | 1614 | 6378 | 3531 | 2706 | 141 | 80 (first [-1, -18]) |
| 11 | quicksilver | 1614 | 6378 | 3537 | 2704 | 137 | 85 (first [-1, 18]) |
| 12 | vanilla | 1614 | 6379 | 3529 | 2709 | 141 | 60 (first [-1, 10]) |
| 12 | quicksilver | 1614 | 6378 | 3528 | 2726 | 124 | 56 (first [-1, 9]) |
| 13 | vanilla | 1614 | 6378 | 3535 | 2736 | 107 | 57 (first [-16, 10]) |
| 13 | quicksilver | 1614 | 6378 | 3618 | 2658 | 102 | 91 (first [-1, -17]) |
| 14 | vanilla | 1614 | 6378 | 3518 | 2804 | 56 | 51 (first [-1, -18]) |
| 14 | quicksilver | 1614 | 6378 | 3530 | 2755 | 93 | 74 (first [-1, 18]) |
| 15 | vanilla | 1614 | 6378 | 3513 | 2747 | 118 | 33 (first [-14, 16]) |
| 15 | quicksilver | 1614 | 6378 | 3536 | 2733 | 109 | 58 (first [-11, 8]) |
| 16 | vanilla | 1614 | 6378 | 3564 | 2709 | 105 | 81 (first [-1, 18]) |
| 16 | quicksilver | 1614 | 6378 | 3511 | 2825 | 42 | 41 (first [-14, 13]) |
| 17 | vanilla | 1614 | 6378 | 3534 | 2785 | 59 | 42 (first [-16, -2]) |
| 17 | quicksilver | 1613 | 6375 | 3549 | 2783 | 43 | 48 (first [-14, -16]) |
| 18 | vanilla | 1614 | 6378 | 3516 | 2758 | 104 | 65 (first [-1, -18]) |
| 18 | quicksilver | 1614 | 6378 | 3551 | 2785 | 42 | 43 (first [-19, 13]) |
| 19 | vanilla | 1614 | 6379 | 3545 | 2736 | 98 | 78 (first [-1, 11]) |
| 19 | quicksilver | 1614 | 6378 | 3477 | 2778 | 123 | 52 (first [-1, 10]) |
| 20 | vanilla | 1614 | 6378 | 3509 | 2700 | 169 | 56 (first [-10, -18]) |
| 20 | quicksilver | 1614 | 6378 | 3502 | 2831 | 45 | 30 (first [-16, -13]) |
| 21 | vanilla | 1614 | 6378 | 3505 | 2769 | 104 | 63 (first [-1, -17]) |
| 21 | quicksilver | 1614 | 6378 | 3494 | 2698 | 186 | 52 (first [-11, -16]) |
| 22 | vanilla | 1614 | 6378 | 3564 | 2633 | 181 | 75 (first [-1, -16]) |
| 22 | quicksilver | 1614 | 6378 | 3548 | 2729 | 101 | 74 (first [-10, -17]) |
| 23 | vanilla | 1614 | 6378 | 3518 | 2777 | 83 | 49 (first [-12, -16]) |
| 23 | quicksilver | 1614 | 6378 | 3542 | 2727 | 109 | 73 (first [-1, 18]) |
| 24 | vanilla | 1614 | 6379 | 3530 | 2693 | 156 | 87 (first [-11, -19]) |
| 24 | quicksilver | 1614 | 6378 | 3496 | 2632 | 250 | 89 (first [-1, 18]) |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-24 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 792 (90) | 0 (0) | LastUpdate 192, block_ticks 509, fluid_ticks 489, sections 4 | 1555 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 779 (0) | 0 (0) | LastUpdate 219, block_ticks 505, fluid_ticks 427 | 1558 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 707 (90) | 0 (0) | LastUpdate 191, block_ticks 459, fluid_ticks 427, sections 5 | 1540 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 821 (0) | 0 (0) | LastUpdate 161, block_ticks 534, fluid_ticks 507, sections 5 | 1555 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 789 (100) | 0 (0) | LastUpdate 225, block_ticks 480, fluid_ticks 460, sections 4 | 1547 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 764 (0) | 0 (0) | LastUpdate 195, block_ticks 486, fluid_ticks 463, sections 5 | 1568 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 749 (90) | 0 (0) | LastUpdate 197, block_ticks 462, fluid_ticks 457, sections 5 | 1578 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 745 (0) | 0 (0) | LastUpdate 205, block_ticks 470, fluid_ticks 438, sections 4 | 1550 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (1) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 730 (61) | 0 (0) | LastUpdate 183, block_ticks 476, fluid_ticks 426, sections 1 | 1558 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 800 (0) | 0 (0) | LastUpdate 221, block_ticks 519, fluid_ticks 458, sections 3 | 1566 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 7 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 853 (135) | 0 (0) | LastUpdate 234, block_ticks 574, fluid_ticks 475, sections 4 | 1563 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 201 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 205 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 71 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 770 (0) | 0 (0) | LastUpdate 197, block_ticks 514, fluid_ticks 448, sections 3 | 3662 / 9801 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 18 / 71 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 734 (83) | 0 (0) | LastUpdate 182, block_ticks 469, fluid_ticks 443, sections 3 | 3661 / 9801 | 0 |
| 8 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 8 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 71 | 0 |
| 8 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 747 (0) | 0 (0) | LastUpdate 190, block_ticks 475, fluid_ticks 427, sections 3 | 3680 / 9801 | 0 |
| 8 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 8 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 71 | 0 |
| 8 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 710 (62) | 0 (0) | LastUpdate 190, block_ticks 438, fluid_ticks 439, sections 3 | 3657 / 9801 | 0 |
| 9 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 9 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 71 | 0 |
| 9 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 805 (0) | 0 (0) | LastUpdate 212, block_ticks 505, fluid_ticks 474, sections 3 | 3666 / 9801 | 0 |
| 9 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 201 (0) | 0 (0) | - | 0 / 205 | 3 |
| 9 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 71 | 0 |
| 9 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 809 (82) | 0 (0) | LastUpdate 242, block_ticks 506, fluid_ticks 455, sections 3 | 3661 / 9801 | 0 |
| 10 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | Entities 1 | 0 / 205 | 3 |
| 10 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 71 | 0 |
| 10 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 880 (0) | 0 (0) | LastUpdate 224, block_ticks 559, fluid_ticks 504, sections 4 | 3659 / 9801 | 0 |
| 10 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 10 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 71 | 0 |
| 10 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 805 (67) | 0 (0) | LastUpdate 226, block_ticks 491, fluid_ticks 494, sections 3 | 3667 / 9801 | 0 |
| 11 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | Entities 1 | 0 / 205 | 3 |
| 11 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 71 | 0 |
| 11 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 819 (0) | 0 (0) | LastUpdate 185, block_ticks 535, fluid_ticks 473, sections 3 | 3662 / 9801 | 0 |
| 11 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | Entities 1 | 0 / 205 | 3 |
| 11 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 71 | 0 |
| 11 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 819 (106) | 0 (0) | LastUpdate 224, block_ticks 534, fluid_ticks 446, sections 3 | 3673 / 9801 | 0 |
| 12 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | Entities 1 | 0 / 205 | 3 |
| 12 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 71 | 0 |
| 12 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 798 (0) | 0 (0) | LastUpdate 246, block_ticks 510, fluid_ticks 444, sections 4 | 3662 / 9801 | 0 |
| 12 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 12 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 71 | 0 |
| 12 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 743 (88) | 0 (0) | LastUpdate 215, block_ticks 492, fluid_ticks 405, sections 3 | 3667 / 9801 | 0 |
| 13 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 13 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 71 | 0 |
| 13 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 819 (0) | 0 (0) | LastUpdate 227, block_ticks 500, fluid_ticks 464, sections 5 | 3491 / 9801 | 0 |
| 13 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 201 (0) | 0 (0) | - | 0 / 205 | 3 |
| 13 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 18 / 71 | 0 |
| 13 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 775 (109) | 0 (0) | LastUpdate 253, block_ticks 476, fluid_ticks 401, sections 5 | 3498 / 9801 | 0 |
| 14 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 14 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 71 | 0 |
| 14 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 706 (0) | 0 (0) | LastUpdate 224, block_ticks 446, fluid_ticks 371, sections 2 | 3487 / 9801 | 0 |
| 14 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 14 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 71 | 0 |
| 14 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 725 (72) | 0 (0) | LastUpdate 198, block_ticks 471, fluid_ticks 413, sections 3 | 3492 / 9801 | 0 |
| 15 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 15 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 71 | 0 |
| 15 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 699 (0) | 0 (0) | LastUpdate 199, block_ticks 449, fluid_ticks 402, sections 5 | 3497 / 9801 | 0 |
| 15 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 15 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 71 | 0 |
| 15 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 833 (92) | 0 (0) | LastUpdate 233, block_ticks 529, fluid_ticks 491, sections 3 | 3492 / 9801 | 0 |
| 16 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 16 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 71 | 0 |
| 16 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 779 (0) | 0 (0) | LastUpdate 202, block_ticks 487, fluid_ticks 486, sections 5 | 3503 / 9801 | 0 |
| 16 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 16 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 16 / 71 | 0 |
| 16 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 800 (98) | 0 (0) | LastUpdate 206, block_ticks 525, fluid_ticks 458, sections 4 | 3501 / 9801 | 0 |
| 17 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 17 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 14 / 71 | 0 |
| 17 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 770 (0) | 0 (0) | LastUpdate 197, block_ticks 492, fluid_ticks 425, sections 4 | 3495 / 9801 | 0 |
| 17 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 17 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 71 | 0 |
| 17 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 764 (70) | 0 (0) | LastUpdate 193, block_ticks 491, fluid_ticks 454, sections 2 | 3497 / 9801 | 0 |
| 18 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 18 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 71 | 0 |
| 18 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 870 (0) | 0 (0) | LastUpdate 217, block_ticks 545, fluid_ticks 513, sections 5 | 3503 / 9801 | 0 |
| 18 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 18 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 18 / 71 | 0 |
| 18 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 635 (62) | 0 (0) | LastUpdate 183, block_ticks 415, fluid_ticks 376, sections 4 | 3474 / 9801 | 0 |
| 19 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 19 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 13 / 71 | 0 |
| 19 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 738 (0) | 0 (0) | LastUpdate 228, block_ticks 442, fluid_ticks 425, sections 3 | 3669 / 9801 | 0 |
| 19 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | Entities 1 | 0 / 205 | 3 |
| 19 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 71 | 0 |
| 19 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 788 (105) | 0 (0) | LastUpdate 229, block_ticks 480, fluid_ticks 461, sections 4 | 3654 / 9801 | 0 |
| 20 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 20 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 71 | 0 |
| 20 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 805 (0) | 0 (0) | LastUpdate 243, block_ticks 495, fluid_ticks 454, sections 4 | 3676 / 9801 | 0 |
| 20 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 20 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 71 | 0 |
| 20 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 699 (44) | 0 (0) | LastUpdate 156, block_ticks 458, fluid_ticks 403, sections 4 | 3666 / 9801 | 0 |
| 21 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | Entities 1 | 0 / 205 | 3 |
| 21 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 71 | 0 |
| 21 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 750 (0) | 0 (0) | LastUpdate 231, block_ticks 477, fluid_ticks 416, sections 3 | 3671 / 9801 | 0 |
| 21 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 21 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 71 | 0 |
| 21 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 773 (138) | 0 (0) | LastUpdate 217, block_ticks 496, fluid_ticks 448, sections 4 | 3669 / 9801 | 0 |
| 22 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 22 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 71 | 0 |
| 22 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 785 (0) | 0 (0) | LastUpdate 201, block_ticks 523, fluid_ticks 452, sections 4 | 3675 / 9801 | 0 |
| 22 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 22 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 71 | 0 |
| 22 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 802 (72) | 0 (0) | LastUpdate 217, block_ticks 526, fluid_ticks 440, sections 3 | 3677 / 9801 | 0 |
| 23 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 23 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 71 | 0 |
| 23 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 748 (0) | 0 (0) | LastUpdate 190, block_ticks 488, fluid_ticks 439, sections 1 | 3679 / 9801 | 0 |
| 23 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | DataVersion 5, Entities 7, Position 5 | 0 / 205 | 3 |
| 23 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 71 | 0 |
| 23 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 848 (69) | 0 (0) | LastUpdate 240, block_ticks 543, fluid_ticks 495, sections 4 | 3666 / 9801 | 0 |
| 24 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 203 (0) | 0 (0) | Entities 2 | 0 / 205 | 3 |
| 24 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 71 | 0 |
| 24 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 895 (0) | 0 (0) | LastUpdate 232, block_ticks 562, fluid_ticks 513, sections 3 | 3684 / 9801 | 0 |
| 24 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 202 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 205 | 3 |
| 24 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 71 | 0 |
| 24 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 754 (137) | 0 (0) | LastUpdate 231, block_ticks 460, fluid_ticks 455, sections 4 | 3670 / 9801 | 0 |

Vanilla's noise (rounds 2-24 against 1): dimensions/minecraft/overworld/entities: 203 data, 0 bytes only, 0 one side, keys DataVersion 60, Entities 95, Position 60; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1094 data, 0 bytes only, 0 one side, keys LastUpdate 4846, block_ticks 11518, fluid_ticks 10423, sections 81

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 1 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 98 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.651 | 1.401 | 2771.284 | 12 | 0.001 (0.001) | 0.030 (0.030) | 0.029 | 5728 (52.1) | 700: 2771.3, 1900: 130.5, 2500: 121.8, 3100: 91.9, 100: 79.8 |
| 1 | quicksilver | yes | 0.596 | 0.973 | 2514.159 | 9 | 0.000 (0.000) | 0.040 (0.040) | 0.039 | 5733 (31.1) | 700: 2514.2, 2500: 133.2, 100: 87.9, 1000: 64.3, 1300: 64.3 |
| 2 | vanilla | yes | 0.640 | 1.489 | 2678.106 | 8 | 0.000 (0.000) | 0.026 (0.026) | 0.026 | 5725 (62.3) | 700: 2678.1, 1000: 133.9, 2200: 132.9, 100: 86.7, 3159: 68.1 |
| 2 | quicksilver | yes | 0.628 | 1.454 | 2593.180 | 10 | 0.001 (0.001) | 0.035 (0.035) | 0.034 | 5729 (61.7) | 700: 2593.2, 2500: 114.0, 2800: 80.3, 1900: 77.8, 1666: 76.9 |
| 3 | vanilla | yes | 0.628 | 1.004 | 2585.186 | 9 | 0.001 (0.001) | 0.052 (0.051) | 0.051 | 5732 (53.3) | 700: 2585.2, 4389: 127.8, 1648: 95.0, 1600: 83.5, 100: 82.7 |
| 3 | quicksilver | yes | 0.616 | 0.742 | 2681.990 | 11 | 0.000 (0.000) | 0.053 (0.052) | 0.051 | 5730 (36.7) | 700: 2682.0, 2800: 177.4, 100: 69.6, 1300: 67.0, 1600: 66.8 |
| 4 | vanilla | yes | 0.610 | 1.368 | 2452.786 | 6 | 0.000 (0.000) | 0.025 (0.025) | 0.024 | 5729 (45.6) | 700: 2452.8, 2500: 121.6, 1600: 114.3, 100: 100.2, 3464: 68.5 |
| 4 | quicksilver | yes | 0.603 | 1.214 | 2569.758 | 8 | 0.001 (0.001) | 0.028 (0.028) | 0.027 | 5720 (57.7) | 700: 2569.8, 2800: 138.1, 1600: 107.6, 100: 73.6, 5720: 57.7 |
| 5 | vanilla | yes | 0.620 | 1.280 | 2608.952 | 8 | 0.000 (0.000) | 0.040 (0.040) | 0.039 | 5729 (95.0) | 700: 2609.0, 100: 109.1, 1300: 108.5, 2500: 108.5, 5729: 95.0 |
| 5 | quicksilver | yes | 0.588 | 1.087 | 2458.529 | 7 | 0.000 (0.000) | 0.030 (0.030) | 0.030 | 5720 (45.9) | 700: 2458.5, 3100: 118.0, 100: 114.7, 1600: 103.5, 1300: 61.5 |
| 6 | vanilla | yes | 0.646 | 1.634 | 2612.754 | 8 | 0.000 (0.000) | 0.023 (0.023) | 0.023 | 5721 (56.6) | 700: 2612.8, 1300: 138.8, 2200: 113.0, 100: 84.1, 2500: 69.0 |
| 6 | quicksilver | yes | 0.611 | 1.178 | 2637.669 | 7 | 0.000 (0.000) | 0.019 (0.019) | 0.019 | 5724 (78.3) | 700: 2637.7, 2800: 130.9, 1600: 103.2, 3100: 81.8, 5724: 78.3 |
| 7 | vanilla | yes | 0.598 | 1.039 | 2586.608 | 6 | 0.001 (0.001) | 0.032 (0.031) | 0.031 | 5729 (39.9) | 700: 2586.6, 2500: 126.1, 1300: 125.0, 100: 82.7, 1000: 72.1 |
| 7 | quicksilver | yes | 0.642 | 1.570 | 2594.077 | 9 | 0.001 (0.001) | 0.035 (0.035) | 0.034 | 5725 (42.1) | 700: 2594.1, 2500: 133.3, 100: 98.3, 1000: 75.2, 400: 72.2 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) | gated: trimmed geometric mean of rounds |
|---|---|---|---|---|
| MSPT average | 0.628 | 0.611 | 0.981 (0.92 to 1.07) | 0.969 |
| MSPT p99 | 1.368 | 1.178 | 0.849 (0.69 to 1.51) | 0.829 |
| slowest tick (ms) | 2608.952 | 2593.180 | 1.003 (0.91 to 1.05) | 0.992 |
| ticks over 50 ms | 8 | 9 | 1.222 (0.75 to 1.50) | 1.093 |
| chunk load, ms per tick (server thread) | 0.000 | 0.000 | 0.600 (0.00 to 7.00) | 0.978 |
|   of it in the tick | 0.000 | 0.000 | 0.600 (0.00 to 7.00) | 0.978 |
| chunk save, ms per tick (server thread) | 0.030 | 0.035 | 1.104 (0.76 to 1.34) | 1.070 |
|   of it in the tick | 0.030 | 0.035 | 1.102 (0.75 to 1.34) | 1.065 |
| autosave, ms per tick | 0.029 | 0.034 | 1.096 (0.76 to 1.34) | 1.063 |
| save-all tick (ms, mean of the script's) | 65.694 | 64.552 | 0.969 (0.84 to 1.19) | 0.976 |
| save-all flush tick (ms) | 2608.952 | 2593.180 | 1.003 (0.91 to 1.05) | 0.992 |
| autosave tick (ms, the game's own) | 53.286 | 45.880 | 0.990 (0.48 to 1.38) | 0.885 |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 4650 ms, 28207 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 194 / 11 | 1 / 0 | 0.029 | 343.2 |
| chunk save | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 6 / 0 | 0 / 0 | 0.001 | 0.0 |
| entity load | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 1 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 138 / 4 | 1 / 0 | 0.020 | 135.5 |
| tick, other | 222 / 2 | 0 / 0 | 0.032 | 47.5 |
| idle or other | 0 / 0 | 17 / 0 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 357, MinecraftServer.runServer 357, MinecraftServer.tickServer 356, Thread.run 356, DedicatedServer.tickServer 356, MinecraftServer.processPacketsAndTick 355, MinecraftServer.saveEverything 205, DedicatedServer.saveAllChunks 203, MinecraftServer.saveAllChunks 202, ServerTickEvents.lambda$static$1 197, Harness.startTick 197, ContextChain.executeAll 193, SaveAllCommand.saveAll 193, ContextChain.runExecutable$mixinextras$wrapped$10 193, CommandDispatcher.execute 193, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 193, ContextChain.runExecutable 193, Harness.command 192, ServerLevel.save 191, SaveAllCommand.lambda$register$0 180, ServerChunkCache.save 163, ChunkMap.saveAllChunks 163, ChunkMap.save 158, SerializableChunkData.copyOf 155, ChunkMap.saveChunkIfNeeded 155, ServerLevel.tick 146, MinecraftServer.tickChildren 146, ServerChunkCache.tick 129, ServerChunkCache.tickChunks 114, NaturalSpawner.createState 88, ServerChunkCache.getFullChunk 69, LevelChunkSection.copy 59, PalettedContainer.copy 58, LevelChunkSection.<init> 58, ChunkResult$Success.ifSuccess 55, NaturalSpawner.lambda$createState$0 54, EnvironmentAttributeSystem.getValue 50, EnvironmentAttributeReader.getValue 50, PalettedContainer.<init> 48, PalettedContainer$Data.copy 45, EnvironmentAttributeSystem$ValueSampler.getValue 44, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 44, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 36, BiomeManager.getBiome 32, LevelReader.getNoiseBiome 29, Encoder.encodeStart 27, LayerLightSectionStorage.getDataLayerData 27, LightEngine.getDataLayerData 27, Level.getChunk 23, ServerChunkCache.getChunk 23, LevelChunk.getBlockEntityNbtForSaving 22, SerializableChunkData.packStructureData 22, BlockEntity.saveWithFullMetadata 20, TagValueOutput.store 19, PersistentEntitySectionManager.storeChunkSections 19, LongOpenHashSet.forEach 18, PersistentEntitySectionManager.autoSave 18, AbstractLongCollection.forEach 18, LongIterable.forEach 18, Codec$2.encode 17

Top chunk methods (self): PalettedContainer$Data.copy 38, ServerChunkCache.getChunk 17, Long2ByteOpenHashMap.get 13, Long2ObjectOpenHashMap.get 13, ServerChunkCache.tickChunks 11, Long2ObjectLinkedOpenHashMap.get 10, PalettedContainer.copy 10, Long2ObjectFunctions$SynchronizedFunction.get 8, SerializableChunkData.copyOf 8, Iterators$1.hasNext 8, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 6, UnixFileDispatcherImpl.write0 6, LayerLightSectionStorage.getDataLayerData 6, Reference2ObjectOpenHashMap.get 6, NaturalSpawner.createState 5, Object.clone 4, CompletableFuture.reportJoin 4, Inflater.inflateBytesBytes 3, MobSpawnSettingsModifier$Overlay.apply 3, PiecesContainer.save 3, DataLayer.copy 3, DispatchedMapCodec.encode 3, GenerationChunkHolder.getChunkIfPresentUnchecked 3, PalettedContainer.<init> 3, DirectMethodHandle.allocateInstance 3, TimSort.countRunAndMakeAscending 3, Long2ObjectOpenHashMap$MapIterator.nextEntry 3, NaturalSpawner.lambda$createState$0 2, SimulationChunkTracker.getLevel 2, Iterables.unmodifiableIterable 2

Threads (all samples in the window): Netty Epoll IO  2210, Worker-Main 1519, IO-Worker 860, Server thread 600, JFR Periodic Tasks 1

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 4241 ms, 28609 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 267 / 7 | 1 / 0 | 0.039 | 311.6 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 4 / 0 | 0 / 0 | 0.001 | 3.0 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 3 / 0 | 0 / 0 | 0.000 | 0.4 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 144 / 1 | 2 / 0 | 0.021 | 39.6 |
| tick, other | 285 / 3 | 0 / 0 | 0.041 | 6.2 |
| idle or other | 0 / 0 | 14 / 0 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.tickServer 427, MinecraftServer.lambda$spin$0 427, MinecraftServer.runServer 427, DedicatedServer.tickServer 426, MinecraftServer.processPacketsAndTick 425, Thread.run 425, MinecraftServer.saveEverything 274, DedicatedServer.saveAllChunks 272, MinecraftServer.saveAllChunks 272, ServerTickEvents.lambda$static$1 266, Harness.startTick 266, ServerLevel.save 264, SaveAllCommand.saveAll 263, CommandDispatcher.execute 263, ContextChain.runExecutable 263, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 263, ContextChain.runExecutable$mixinextras$wrapped$10 263, ContextChain.executeAll 263, Harness.command 263, SaveAllCommand.lambda$register$0 248, ChunkMap.saveAllChunks 230, ServerChunkCache.save 230, ChunkMap.save 228, SerializableChunkData.copyOf 222, ChunkMap.saveChunkIfNeeded 220, ServerLevel.tick 150, MinecraftServer.tickChildren 150, ServerChunkCache.tick 134, LevelChunkSection.copy 102, ServerChunkCache.tickChunks 100, LevelChunkSection.<init> 100, NaturalSpawner.createState 73, ServerChunkCache.getFullChunk 52, ChunkResult$Success.ifSuccess 46, NaturalSpawner.lambda$createState$0 45, EnvironmentAttributeReader.getValue 42, PalettedContainer.handler$zom000$quicksilver$share 42, PalettedContainerInvoker.quicksilver$create 42, PalettedContainer.copy 42, PalettedContainer.create$quicksilver_$md$cb9600$0 42, Encoder.encodeStart 39, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 33, EnvironmentAttributeSystem.getValue 33, EnvironmentAttributeSystem$ValueSampler.getValue 33, TagValueOutput.store 33, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 31, PersistentEntitySectionManager.storeChunkSections 31, LevelChunk.getBlockEntityNbtForSaving 30, BlockEntity.saveWithFullMetadata 30, BlockEntity.saveWithoutMetadata 28, PersistentEntitySectionManager.autoSave 28, BiomeManager.getBiome 27, AbstractLongCollection.forEach 27, LongOpenHashSet.forEach 27, PersistentEntitySectionManager.lambda$autoSave$0 27, LongIterable.forEach 27, Codec$2.encode 24, LevelReader.getNoiseBiome 23, SerializableChunkData.packStructureData 23, Level.getChunk 21

Top chunk methods (self): LevelChunkSection.<init> 58, PalettedContainer.create$quicksilver_$md$cb9600$0 42, SerializableChunkData.copyOf 24, ServerChunkCache.getChunk 17, Long2ByteOpenHashMap.get 15, Long2ObjectOpenHashMap.<init> 15, LevelChunkTicks.pack 8, Long2ObjectOpenHashMap.get 8, Vec3.atLowerCornerWithOffset 7, HashMap.putVal 6, Iterators$1.hasNext 6, NaturalSpawner.createState 5, Long2ObjectLinkedOpenHashMap.get 5, BlockEntity.saveWithoutMetadata 5, Iterables.unmodifiableIterable 4, ChunkMap.tick 4, CompletableFuture.reportJoin 4, TicketStorage.purgeStaleTickets 3, DataResult.success 3, Long2ObjectOpenHashMap$FastEntryIterator.next 3, SectionPos.of 3, Long2ObjectOpenHashMap$MapIterator.<init> 3, DispatchedMapCodec.encode 3, UnixFileDispatcherImpl.write0 3, ArrayList.forEach 3, TicketStorage.removeTicketIf 2, Math.floorMod 2, UnmodifiableIterator.<init> 2, GenerationChunkHolder.getChunkIfPresentUnchecked 2, DelegatingOps.createString 2

Threads (all samples in the window): Netty Epoll IO  2239, Worker-Main 1575, IO-Worker 829, Server thread 732

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 1560: DedicatedServer.saveAllChunks 1552, MinecraftServer.warnOnLowDiskSpace 8<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 1551, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 8
- **ServerLevel.save** 1488: ServerChunkCache.save 1310, PersistentEntitySectionManager.autoSave 136, PersistentEntitySectionManager.saveAll 29, ServerLevel.saveLevelData 13<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1310, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 125, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 25, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 12, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 11, PersistentEntitySectionManager.saveAll > EntityStorage.flush 3, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 1, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 1
- **ChunkMap.saveAllChunks** 1310: ChunkMap.saveChunkIfNeeded 1188, ReferencePipeline.forEach 93, Long2ObjectLinkedOpenHashMap$ValueIterator.next 4, ReferencePipeline.toList 3, Long2ObjectLinkedOpenHashMap$1.iterator 1, CompletableFuture.join 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1168, ReferencePipeline.forEach > AbstractPipeline.evaluate 93, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 12, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 4, ReferencePipeline.toList > ReferencePipeline.toArray 3, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 3, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 2, ChunkMap.saveChunkIfNeeded > ChunkHolder.refreshAccessibility 1, Long2ObjectLinkedOpenHashMap$1.iterator > Long2ObjectLinkedOpenHashMap$ValueIterator.<init> 1, CompletableFuture.join > CompletableFuture.reportJoin 1
- **ChunkMap.save** 1258: SerializableChunkData.copyOf 1226, CompletableFuture.supplyAsync 13, SimpleRegionStorage.write 8, ChunkMap.markPosition 4, CompletableFuture.handle 2, DirectMethodHandle.allocateInstance 2<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 434, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 161, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 152, SerializableChunkData.copyOf > LightEngine.getDataLayerData 137, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 79, SerializableChunkData.copyOf > DataLayer.copy 42, SerializableChunkData.copyOf > ReferencePipeline.toArray 28, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 27, SerializableChunkData.copyOf > Heightmap.getRawData 13, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 12, SerializableChunkData.copyOf > ArrayList.add 11, SimpleRegionStorage.write > IOWorker.store 8
- **SerializableChunkData.copyOf** 1226: LevelChunkSection.copy 434, SerializableChunkData.packStructureData 161, LevelChunk.getBlockEntityNbtForSaving 152, LightEngine.getDataLayerData 137, LevelChunk.getTicksForSerialization 79, DataLayer.copy 42, ReferencePipeline.toArray 28, ChunkAccess.getBlockEntitiesPos 27, Heightmap.getRawData 12, ArrayList.add 11, ChunkAccess.getHeightmaps 5, Collections$UnmodifiableCollection.iterator 4<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 418, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 146, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 134, SerializableChunkData.packStructureData > StructureStart.createTag 98, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 76, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 26, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 18, DataLayer.copy > DataLayer.<init> 17, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 14, ArrayList.add > ArrayList.add 11, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 9, SerializableChunkData.packStructureData > Collections$UnmodifiableMap$UnmodifiableEntrySet$1.next 6
- **PersistentEntitySectionManager.autoSave** 136: AbstractLongCollection.forEach 125, PersistentEntitySectionManager.getAllChunksToSave 11<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 125, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 4, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 4
- **ChunkMap.processUnloads** 22: ChunkMap.saveChunksEagerly 10, LongOpenHashSet.iterator 4, ConcurrentLinkedQueue.size 3<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 4, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 3, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 2, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1
- **ChunkMap.saveChunksEagerly** 10: Util.getMillis 4, LongLinkedOpenHashSet.iterator 1<br>two down: Util.getMillis > Util.getNanos 4, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 1636: DedicatedServer.saveAllChunks 1628, MinecraftServer.warnOnLowDiskSpace 8<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 1628, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 8
- **ServerLevel.save** 1565: ServerChunkCache.save 1381, PersistentEntitySectionManager.autoSave 141, PersistentEntitySectionManager.saveAll 34, ServerLevel.saveLevelData 8<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1381, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 131, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 29, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 10, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 7, PersistentEntitySectionManager.saveAll > EntityStorage.flush 2, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 2, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 1, PersistentEntitySectionManager.saveAll > MethodHandleNatives.linkCallSite 1
- **ChunkMap.saveAllChunks** 1381: ChunkMap.saveChunkIfNeeded 1285, ReferencePipeline.forEach 72, Long2ObjectLinkedOpenHashMap$ValueIterator.next 4, ReferencePipeline.toList 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1265, ReferencePipeline.forEach > AbstractPipeline.evaluate 72, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 11, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 3, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 3, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 3, ReferencePipeline.toList > ReferencePipeline.toArray 1
- **ChunkMap.save** 1332: SerializableChunkData.copyOf 1292, CompletableFuture.supplyAsync 14, SimpleRegionStorage.write 9, CompletableFuture.handle 9, ChunkMap.markPosition 4, DirectMethodHandle.allocateInstance 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 385, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 189, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 147, SerializableChunkData.copyOf > LightEngine.getDataLayerData 106, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 78, SerializableChunkData.copyOf > DataLayer.copy 45, SerializableChunkData.copyOf > ReferencePipeline.toArray 31, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 22, SerializableChunkData.copyOf > ArrayList.add 19, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 12, SerializableChunkData.copyOf > TagValueOutput.createWithContext 11, SerializableChunkData.copyOf > SectionPos.of 10
- **SerializableChunkData.copyOf** 1292: LevelChunkSection.copy 385, LevelChunk.getBlockEntityNbtForSaving 189, SerializableChunkData.packStructureData 147, LightEngine.getDataLayerData 106, LevelChunk.getTicksForSerialization 78, DataLayer.copy 45, ReferencePipeline.toArray 31, ChunkAccess.getBlockEntitiesPos 22, ArrayList.add 19, TagValueOutput.createWithContext 10, SectionPos.of 10, LevelLightEngine.getMaxLightSection 8<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 373, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 183, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 100, SerializableChunkData.packStructureData > StructureStart.createTag 96, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 71, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 29, ArrayList.add > ArrayList.add 19, DataLayer.copy > DataLayer.<init> 15, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 14, SerializableChunkData.packStructureData > CompoundTag.put 9, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 9, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 8
- **PersistentEntitySectionManager.autoSave** 141: AbstractLongCollection.forEach 131, PersistentEntitySectionManager.getAllChunksToSave 10<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 131, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 5, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1
- **ChunkMap.processUnloads** 27: ChunkMap.saveChunksEagerly 11, ConcurrentLinkedQueue.size 7, LongOpenHashSet$SetIterator.hasNext 1, LongOpenHashSet.iterator 1<br>two down: ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 7, ChunkMap.saveChunksEagerly > Util.getMillis 4, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1
- **ChunkMap.saveChunksEagerly** 11: Util.getMillis 4, LongLinkedOpenHashSet.iterator 1<br>two down: Util.getMillis > Util.getNanos 4, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 625 | 3015 | 3015 | 0 | 0 | 0 |
| 1 | quicksilver | 625 | 2854 | 2854 | 0 | 0 | 0 |
| 2 | vanilla | 625 | 3017 | 3015 | 0 | 2 | 0 |
| 2 | quicksilver | 625 | 3091 | 3017 | 0 | 74 | 0 |
| 3 | vanilla | 625 | 2930 | 2930 | 0 | 0 | 0 |
| 3 | quicksilver | 625 | 2850 | 2850 | 0 | 0 | 0 |
| 4 | vanilla | 625 | 2965 | 2965 | 0 | 0 | 0 |
| 4 | quicksilver | 625 | 2976 | 2976 | 0 | 0 | 0 |
| 5 | vanilla | 625 | 2957 | 2957 | 0 | 0 | 0 |
| 5 | quicksilver | 625 | 2892 | 2892 | 0 | 0 | 0 |
| 6 | vanilla | 625 | 2913 | 2913 | 0 | 0 | 0 |
| 6 | quicksilver | 625 | 2940 | 2940 | 0 | 0 | 0 |
| 7 | vanilla | 625 | 2893 | 2893 | 0 | 0 | 0 |
| 7 | quicksilver | 625 | 2904 | 2904 | 0 | 0 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 450 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 482 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 455 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 517 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 477 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 446 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 435 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 470 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 459 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 438 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 467 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 491 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 461 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 3 data, 0 bytes only, 0 one side, keys DataVersion 8, Entities 14, Position 8; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / kill: a kill -9 mid-save (save-all flush of 625 changed chunks)

| run | killed mid-save | chunks: complete save's / its at another tick / saved terrain's / other / unreadable (region) | entities, poi: other / unreadable | reloaded |
|---|---|---|---|---|
| quicksilver-killed1 | yes | 9431 / 281 / 89 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| quicksilver-killed2 | yes | 9460 / 253 / 88 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed1 | yes | 9484 / 230 / 87 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed2 | yes | 9403 / 309 / 89 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
quicksilver-complete1 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0

quicksilver-complete2 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0


Each chunk of a killed save is either the complete save's (possibly written at another tick: it differs only in LastUpdate, block_ticks, fluid_ticks) or the saved terrain's: a kill loses the chunks not yet written, and breaks none. Entity and POI files are reported only (their data follows entity and POI timing, as in vanilla's own rounds).

