# Chunk scenes (P2-4)

## core / churn

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 18.034 | 275.887 | 2659.122 | 31 | 0.043 (0.040) | 1.468 (1.462) | 1.462 | - | 220: 2659.1, 87: 516.2, 128: 509.3, 103: 384.2, 16: 289.4 |
| 1 | quicksilver | yes | 17.493 | 234.403 | 2538.654 | 28 | 0.042 (0.040) | 1.247 (1.237) | 1.240 | - | 220: 2538.7, 128: 624.6, 87: 579.6, 103: 493.9, 36: 332.2 |
| 2 | vanilla | yes | 16.728 | 231.543 | 2333.719 | 33 | 0.055 (0.050) | 1.342 (1.337) | 1.333 | - | 220: 2333.7, 87: 573.3, 128: 459.6, 103: 371.7, 139: 370.9 |
| 2 | quicksilver | yes | 16.840 | 260.256 | 2387.188 | 30 | 0.050 (0.047) | 1.093 (1.087) | 1.088 | - | 220: 2387.2, 87: 587.0, 128: 466.7, 103: 399.5, 139: 314.9 |
| 3 | vanilla | yes | 18.613 | 244.477 | 2748.314 | 31 | 0.047 (0.045) | 1.275 (1.265) | 1.268 | - | 220: 2748.3, 87: 708.4, 128: 523.7, 103: 382.1, 139: 281.6 |
| 3 | quicksilver | yes | 16.475 | 231.766 | 2283.912 | 27 | 0.038 (0.033) | 1.217 (1.212) | 1.212 | - | 220: 2283.9, 87: 510.9, 128: 499.9, 21: 353.7, 103: 349.6 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 18.034 | 16.840 | 0.970 (0.89 to 1.01) |
| MSPT p99 | 244.477 | 234.403 | 0.948 (0.85 to 1.12) |
| slowest tick (ms) | 2659.122 | 2387.188 | 0.955 (0.83 to 1.02) |
| ticks over 50 ms | 31 | 28 | 0.903 (0.87 to 0.91) |
| chunk load, ms per tick (server thread) | 0.047 | 0.042 | 0.909 (0.82 to 0.96) |
|   of it in the tick | 0.045 | 0.040 | 0.934 (0.74 to 1.00) |
| chunk save, ms per tick (server thread) | 1.342 | 1.217 | 0.849 (0.81 to 0.95) |
|   of it in the tick | 1.337 | 1.212 | 0.846 (0.81 to 0.96) |
| autosave, ms per tick | 1.333 | 1.212 | 0.848 (0.82 to 0.96) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 10871 ms, 36944 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 823 / 50 | 4 / 0 | 1.462 | 1562.9 |
| chunk save | 2 / 0 | 0 / 0 | 0.003 | 0.0 |
| entity save | 1 / 1 | 0 / 0 | 0.003 | 0.0 |
| POI save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk load | 6 / 0 | 0 / 0 | 0.010 | 6.5 |
| chunk to full (promote) | 17 / 0 | 1 / 0 | 0.030 | 4.6 |
| entity load | 1 / 0 | 1 / 0 | 0.003 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 21 / 0 | 0 / 0 | 0.035 | 0.5 |
| light | 0 / 0 | 0 / 0 | 0.000 | 29.5 |
| chunk system (tickets, holders, tasks) | 332 / 143 | 5 / 0 | 0.800 | 330.1 |
| tick, other | 177 / 1 | 0 / 0 | 0.297 | 50.5 |
| idle or other | 0 / 0 | 11 / 0 | 0.018 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1403, MinecraftServer.lambda$spin$0 1403, Thread.run 1401, DedicatedServer.tickServer 1397, MinecraftServer.tickServer 1397, MinecraftServer.processPacketsAndTick 1397, ServerTickEvents.lambda$static$1 1154, Harness.startTick 1154, CiChunks.startTick 1153, ContextChain.executeAll 878, CommandDispatcher.execute 878, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 878, ContextChain.runExecutable$mixinextras$wrapped$10 878, ContextChain.runExecutable 878, SaveAllCommand.lambda$register$0 877, MinecraftServer.saveEverything 877, SaveAllCommand.saveAll 877, Harness.command 877, DedicatedServer.saveAllChunks 866, MinecraftServer.saveAllChunks 866, ServerLevel.save 799, ChunkMap.saveAllChunks 748, ServerChunkCache.save 748, ChunkMap.saveChunkIfNeeded 737, ChunkMap.save 727, SerializableChunkData.copyOf 715, LevelChunkSection.copy 388, LevelChunkSection.<init> 387, PalettedContainer.copy 387, PalettedContainer.<init> 349, PalettedContainer$Data.copy 347, Level.getChunk 269, ServerChunkCache.getChunk 268, LevelReader.getChunk 267, Level.getBlockState 267, ServerLevel.tick 246, MinecraftServer.tickChildren 246, LevelWriter.setBlock 246, Level.setBlock 246, ServerChunkCache.tick 239, CollectingNeighborUpdater.runUpdates 235, CollectingNeighborUpdater.addAndRun 235, NeighborUpdater.executeShapeUpdate 235, CollectingNeighborUpdater$ShapeUpdate.runNext 235, CollectingNeighborUpdater.shapeUpdate 235, BlockBehaviour$BlockStateBase.updateNeighbourShapes 234, Level.neighborShapeChanged 234, ServerChunkCache.runDistanceManagerUpdates 202, DistanceManager.runAllUpdates 189, BlockableEventLoop.managedBlock 162, LoadingChunkTracker.runDistanceUpdates 157, DynamicGraphMinFixedPoint.runUpdates 157, BlockableEventLoop.waitForTasks 143, Thread.yield0 138, Thread.yield 138, ChunkTracker.checkNeighborsAfterUpdate 125, DynamicGraphMinFixedPoint.checkNeighbor 125, LoadingChunkTracker.getLevel 104, DynamicGraphMinFixedPoint.checkEdge 95, Encoder.encodeStart 81

Top chunk methods (self): PalettedContainer$Data.copy 336, Thread.yield0 138, Long2ObjectOpenHashMap.get 73, LongOpenHashSet.contains 63, Long2ObjectLinkedOpenHashMap.get 48, ServerChunkCache.getChunk 39, PalettedContainer.copy 38, SerializableChunkData.copyOf 28, ArrayList.grow 20, Deflater.init 17, UnixFileDispatcherImpl.write0 14, DataLayer.<init> 14, HashMap.putVal 11, LongLinkedOpenHashSet.add 11, Long2ByteOpenHashMap.get 11, Object.clone 10, LongLinkedOpenHashSet.rehash 9, TicketStorage.removeTicketIf 9, ConcurrentLinkedQueue.size 8, ReferenceOpenHashSet.add 8, StrictQueue$QueueStrictQueue.push 8, TimSort.countRunAndMakeAscending 8, Arrays.copyOf 7, Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 7, ShortArrayList.copyArrayFromSafe 7, SerializableChunkData.packStructureData 6, DynamicGraphMinFixedPoint.checkEdge 6, ChunkMap.promoteChunkMap 6, UnixNativeDispatcher.getlinelen 5, DirectMethodHandle.allocateInstance 5

Threads (all samples in the window): Worker-Main 6889, Netty Epoll IO  6820, Server thread 1597, IO-Worker 618, JFR Periodic Tasks 3

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 10547 ms, 38043 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 696 / 42 | 6 / 0 | 1.240 | 1128.9 |
| chunk save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 2 / 0 | 0 / 0 | 0.003 | 0.0 |
| POI save | 2 / 0 | 0 / 0 | 0.003 | 0.0 |
| chunk load | 5 / 0 | 0 / 0 | 0.008 | 20.8 |
| chunk to full (promote) | 19 / 0 | 1 / 0 | 0.033 | 0.9 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 19 / 0 | 0 / 0 | 0.032 | 0.9 |
| light | 1 / 0 | 0 / 0 | 0.002 | 3.3 |
| chunk system (tickets, holders, tasks) | 306 / 77 | 4 / 0 | 0.645 | 157.6 |
| tick, other | 211 / 4 | 0 / 0 | 0.358 | 87.6 |
| idle or other | 0 / 0 | 12 / 0 | 0.020 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1171, MinecraftServer.lambda$spin$0 1171, Thread.run 1169, MinecraftServer.tickServer 1169, DedicatedServer.tickServer 1168, MinecraftServer.processPacketsAndTick 1167, CiChunks.startTick 940, Harness.startTick 939, ServerTickEvents.lambda$static$1 939, SaveAllCommand.lambda$register$0 744, CommandDispatcher.execute 744, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 744, ContextChain.runExecutable$mixinextras$wrapped$10 744, ContextChain.runExecutable 744, ContextChain.executeAll 744, SaveAllCommand.saveAll 744, MinecraftServer.saveEverything 744, Harness.command 742, DedicatedServer.saveAllChunks 738, MinecraftServer.saveAllChunks 738, ServerLevel.save 681, ServerChunkCache.save 610, ChunkMap.saveAllChunks 610, ChunkMap.saveChunkIfNeeded 599, ChunkMap.save 583, SerializableChunkData.copyOf 562, MinecraftServer.tickChildren 233, ServerLevel.tick 233, ServerChunkCache.tick 228, LevelChunkSection.copy 223, LevelChunkSection.<init> 222, Level.getChunk 190, ServerChunkCache.getChunk 190, LevelReader.getChunk 189, Level.getBlockState 189, ServerChunkCache.runDistanceManagerUpdates 179, DistanceManager.runAllUpdates 173, Level.setBlock 161, LevelWriter.setBlock 161, CollectingNeighborUpdater.runUpdates 150, NeighborUpdater.executeShapeUpdate 150, CollectingNeighborUpdater.addAndRun 150, Level.neighborShapeChanged 150, CollectingNeighborUpdater.shapeUpdate 150, BlockBehaviour$BlockStateBase.updateNeighbourShapes 150, CollectingNeighborUpdater$ShapeUpdate.runNext 150, LoadingChunkTracker.runDistanceUpdates 138, DynamicGraphMinFixedPoint.runUpdates 138, ChunkTracker.checkNeighborsAfterUpdate 119, DynamicGraphMinFixedPoint.checkNeighbor 117, LoadingChunkTracker.getLevel 101, BlockableEventLoop.managedBlock 95, DynamicGraphMinFixedPoint.checkEdge 92, PalettedContainer.create$quicksilver_$md$069897$0 89, PalettedContainerInvoker.quicksilver$create 89, PalettedContainer.copy 89, PalettedContainer.handler$zom000$quicksilver$share 89, LightEngine.getDataLayerData 83, LayerLightSectionStorage.getDataLayerData 82, BlockableEventLoop.waitForTasks 75

Top chunk methods (self): LevelChunkSection.<init> 133, PalettedContainer.create$quicksilver_$md$069897$0 89, Thread.yield0 74, Long2ObjectOpenHashMap.get 62, LongOpenHashSet.contains 54, Long2ObjectLinkedOpenHashMap.get 52, SerializableChunkData.copyOf 40, ServerChunkCache.getChunk 32, Comparator.lambda$comparingLong$6043328a$1 29, LayerLightSectionStorage.getDataLayerData 20, LevelHeightAccessor.getSectionsCount 18, UnixFileDispatcherImpl.write0 17, Long2ByteOpenHashMap.find 13, Long2ByteOpenHashMap.get 12, DirectMethodHandle.allocateInstance 9, ConcurrentLinkedQueue.size 9, DataLayer.<init> 8, Deflater.init 8, ConcurrentLinkedQueue.offer 8, TicketStorage.removeTicketIf 7, AbstractConsecutiveExecutor.schedule 7, ArrayList.grow 7, ChunkMap.saveChunkIfNeeded 7, ChunkMap.saveAllChunks 6, ReferencePipeline$3$1.accept 6, HashMap.putVal 6, AbstractCollection.addAll 5, Heightmap.getRawData 5, TicketStorage.addTicket 5, ReferenceOpenHashSet$SetIterator.next 5

Threads (all samples in the window): Netty Epoll IO  6706, Worker-Main 6691, Server thread 1407, IO-Worker 610, JFR Periodic Tasks 2

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2438: DedicatedServer.saveAllChunks 2411, MinecraftServer.warnOnLowDiskSpace 25<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2410, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 25, DedicatedServer.saveAllChunks > NotificationManager.serverSaveStarted 1
- **ServerLevel.save** 2232: ServerChunkCache.save 2048, PersistentEntitySectionManager.autoSave 162, ServerLevel.saveLevelData 22<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 2047, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 145, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 22, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 16, ServerChunkCache.save > ServerChunkCache.runDistanceManagerUpdates 1
- **ChunkMap.saveAllChunks** 2047: ChunkMap.saveChunkIfNeeded 2017, Long2ObjectLinkedOpenHashMap$ValueIterator.next 11, Long2ObjectLinkedOpenHashMap$1.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1992, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 12, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 11, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 3, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1, Long2ObjectLinkedOpenHashMap$1.iterator > Long2ObjectLinkedOpenHashMap$ValueIterator.<init> 1
- **ChunkMap.save** 1992: SerializableChunkData.copyOf 1943, CompletableFuture.supplyAsync 23, SimpleRegionStorage.write 17, DirectMethodHandle.allocateInstance 2, CompletableFuture.handle 2, ChunkMap.markPosition 2, ChunkAccess.tryMarkSaved 1, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 990, SerializableChunkData.copyOf > LightEngine.getDataLayerData 249, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 144, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 123, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 121, SerializableChunkData.copyOf > ReferencePipeline.toArray 70, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 32, SerializableChunkData.copyOf > DataLayer.copy 29, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 23, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 23, SerializableChunkData.copyOf > ArrayList.add 18, SimpleRegionStorage.write > IOWorker.store 17
- **SerializableChunkData.copyOf** 1943: LevelChunkSection.copy 990, LightEngine.getDataLayerData 249, LevelChunk.getBlockEntityNbtForSaving 144, LevelChunk.getTicksForSerialization 123, SerializableChunkData.packStructureData 121, ReferencePipeline.toArray 70, Collections$UnmodifiableCollection$1.hasNext 32, DataLayer.copy 28, ChunkAccess.getBlockEntitiesPos 23, ArrayList.add 18, Collections$UnmodifiableCollection$1.next 7, StructurePieceSerializationContext.fromLevel 7<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 988, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 247, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 135, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 119, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 70, SerializableChunkData.packStructureData > StructureStart.createTag 61, DataLayer.copy > DataLayer.<init> 25, ArrayList.add > ArrayList.add 18, SerializableChunkData.packStructureData > CompoundTag.put 12, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 11, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, SerializableChunkData.packStructureData > Collections$UnmodifiableMap$UnmodifiableEntrySet$1.next 8
- **DistanceManager.runAllUpdates** 578: LoadingChunkTracker.runDistanceUpdates 467, ChunkHolder.updateFutures 81, ReferenceOpenHashSet.clear 7, ReferenceOpenHashSet$SetIterator.next 7, GenerationChunkHolder.updateHighestAllowedStatus 3, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 1<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 467, ChunkHolder.updateFutures > ChunkMap.onLevelChange 35, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 31, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 9, ReferenceOpenHashSet.clear > Arrays.fill 7, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 6, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 2, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates > DynamicGraphMinFixedPoint.runUpdates 1
- **PersistentEntitySectionManager.autoSave** 162: AbstractLongCollection.forEach 145, PersistentEntitySectionManager.getAllChunksToSave 16<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 145, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 3, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 2, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$MapEntry.getValue 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps$1.iterator 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 1
- **ChunkMap.processUnloads** 61: ConcurrentLinkedQueue.size 21, CompletableFuture$Completion.run 11, ChunkMap.scheduleUnload 9, LongOpenHashSet$SetIterator.remove 4, ChunkMap.saveChunksEagerly 4, Long2ObjectLinkedOpenHashMap.put 4, LongOpenHashSet$SetIterator.nextLong 1<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 11, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 5, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 4, ChunkMap.saveChunksEagerly > Util.getMillis 3, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 2, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 1, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 1, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 1, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 1
- **LevelChunk.runPostLoad** 21: SerializableChunkData.lambda$postLoadChunk$0 21<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 18, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 3
- **SerializableChunkData.read** 20: PoiManager.checkConsistencyWithBlocks 7, SerializableChunkData.unpackStructureStart 3, ChunkAccess.addPackedPostProcess 2, ThreadedLevelLightEngine.retainData 1, Objects.equals 1, ChunkAccess.setAllStarts 1, ChunkAccess.setLightCorrect 1, LevelChunk.<init> 1, ImposterProtoChunk.<init> 1, SerializableChunkData.unpackStructureReferences 1<br>two down: PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 6, ChunkAccess.addPackedPostProcess > ShortList.addAll 2, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 2, ThreadedLevelLightEngine.retainData > ThreadedLevelLightEngine.addTask 1, Objects.equals > ChunkPos.equals 1, ChunkAccess.setAllStarts > HashMap.putAll 1, ChunkAccess.setLightCorrect > LevelChunk.markUnsaved 1, LevelChunk.<init> > ChunkAccess.<init> 1, ImposterProtoChunk.<init> > ProtoChunk.<init> 1, SerializableChunkData.unpackStructureStart > RegistryAccess.lookupOrThrow 1, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 1, PoiManager.checkConsistencyWithBlocks > Util.ifElse 1
- **ChunkMap.saveChunksEagerly** 4: Util.getMillis 3, LongLinkedOpenHashSet.iterator 1<br>two down: Util.getMillis > Util.getNanos 3, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 1
- **LevelChunk.<init>** 1: ChunkAccess.<init> 1<br>two down: ChunkAccess.<init> > Maps.newEnumMap 1
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 2124: DedicatedServer.saveAllChunks 2103, MinecraftServer.warnOnLowDiskSpace 21<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 2103, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 21
- **ServerLevel.save** 1933: ServerChunkCache.save 1741, PersistentEntitySectionManager.autoSave 155, ServerLevel.saveLevelData 37<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 1741, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 134, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 37, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 20, PersistentEntitySectionManager.autoSave > DirectMethodHandle.allocateInstance 1
- **ChunkMap.saveAllChunks** 1741: ChunkMap.saveChunkIfNeeded 1712, Long2ObjectLinkedOpenHashMap$ValueIterator.next 7, Long2LongOpenHashMap.clear 1, Long2ObjectLinkedOpenHashMap$1.iterator 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1683, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 12, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 7, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 5, Long2ObjectLinkedOpenHashMap$1.iterator > Long2ObjectLinkedOpenHashMap$ValueIterator.<init> 1
- **ChunkMap.save** 1683: SerializableChunkData.copyOf 1629, CompletableFuture.supplyAsync 24, ChunkMap.markPosition 12, CompletableFuture.handle 6, SimpleRegionStorage.write 6, SectionStorage.flush 2, Profiler.get 2, DirectMethodHandle.allocateInstance 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 679, SerializableChunkData.copyOf > LightEngine.getDataLayerData 217, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 146, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 138, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 116, SerializableChunkData.copyOf > ReferencePipeline.toArray 74, SerializableChunkData.copyOf > DataLayer.copy 31, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 28, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 27, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 24, ChunkMap.markPosition > Long2ByteOpenHashMap.put 12, SerializableChunkData.copyOf > ArrayList.add 9
- **SerializableChunkData.copyOf** 1629: LevelChunkSection.copy 679, LightEngine.getDataLayerData 217, LevelChunk.getTicksForSerialization 146, LevelChunk.getBlockEntityNbtForSaving 138, SerializableChunkData.packStructureData 116, ReferencePipeline.toArray 74, DataLayer.copy 31, ChunkAccess.getBlockEntitiesPos 28, LevelLightEngine.getMaxLightSection 25, ArrayList.add 9, Heightmap.getRawData 7, Collections$UnmodifiableCollection$1.hasNext 7<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 676, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 215, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 141, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 133, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 73, SerializableChunkData.packStructureData > StructureStart.createTag 64, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 26, DataLayer.copy > DataLayer.<init> 21, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 17, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 11, SerializableChunkData.packStructureData > CompoundTag.put 10, ArrayList.add > ArrayList.add 9
- **DistanceManager.runAllUpdates** 553: LoadingChunkTracker.runDistanceUpdates 427, ChunkHolder.updateFutures 85, ReferenceOpenHashSet$SetIterator.next 13, ReferenceOpenHashSet.clear 12, GenerationChunkHolder.updateHighestAllowedStatus 7<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 427, ChunkHolder.updateFutures > ChunkMap.onLevelChange 48, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 21, ReferenceOpenHashSet.clear > Arrays.fill 12, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 9, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 5, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 2, ChunkHolder.updateFutures > DirectMethodHandle.allocateInstance 1, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 1, ChunkHolder.updateFutures > CompletableFuture.complete 1
- **PersistentEntitySectionManager.autoSave** 155: AbstractLongCollection.forEach 134, PersistentEntitySectionManager.getAllChunksToSave 20, DirectMethodHandle.allocateInstance 1<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 134, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 9, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 3, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps$1.iterator 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectMaps.fastIterable 1, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1
- **ChunkMap.processUnloads** 47: ConcurrentLinkedQueue.size 20, ChunkMap.scheduleUnload 6, CompletableFuture$Completion.run 6, LongOpenHashSet$SetIterator.remove 4, Long2ObjectLinkedOpenHashMap.put 4, Long2ObjectLinkedOpenHashMap.remove 3<br>two down: CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 6, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet$SetIterator.shiftKeys 2, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.find 2, Long2ObjectLinkedOpenHashMap.put > Long2ObjectLinkedOpenHashMap.insert 2, LongOpenHashSet$SetIterator.remove > LongOpenHashSet.remove 1, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 1, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 1
- **LevelChunk.runPostLoad** 22: SerializableChunkData.lambda$postLoadChunk$0 22<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 20, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 1
- **SerializableChunkData.read** 18: PoiManager.checkConsistencyWithBlocks 6, SerializableChunkData.unpackStructureReferences 4, ThreadedLevelLightEngine.queueSectionData 1, SectionPos.of 1, SerializableChunkData.unpackStructureStart 1, ChunkAccess.setLightCorrect 1, ImposterProtoChunk.<init> 1<br>two down: SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 4, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 4, PoiManager.checkConsistencyWithBlocks > Util.ifElse 2, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 1, SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 1, ChunkAccess.setLightCorrect > LevelChunk.markUnsaved 1, ImposterProtoChunk.<init> > ProtoChunk.<init> 1
- **SectionStorage.flush** 2: LongLinkedOpenHashSet.remove 2<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 357 | 12760 | 12760 | 0 | 0 | 0 |
| 1 | quicksilver | 357 | 12655 | 12655 | 0 | 0 | 0 |
| 2 | vanilla | 357 | 12888 | 12715 | 0 | 173 | 0 |
| 2 | quicksilver | 357 | 12735 | 12735 | 0 | 0 | 0 |
| 3 | vanilla | 357 | 12834 | 12834 | 0 | 0 | 0 |
| 3 | quicksilver | 357 | 12609 | 12600 | 0 | 9 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-3 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 2 / 7 | 1 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 268 / 357 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 2 / 7 | 1 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 262 / 357 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 7 | 1 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 245 / 357 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 243 / 357 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 203 | 0 (0) | 0 (0) | 0 (0) | - | 3 / 7 | 1 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 1 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 240 / 357 | 0 |

Vanilla's noise (rounds 2-3 against 1): dimensions/minecraft/overworld/entities: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 1 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / flyover

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 1.531 | 8.973 | 42.005 | 0 | 0.204 (0.089) | 0.287 (0.287) | 0.000 | - | 40: 42.0, 8: 30.6, 0: 18.4, 16: 17.4, 1034: 14.5 |
| 1 | quicksilver | yes | 1.461 | 9.133 | 22.002 | 0 | 0.194 (0.089) | 0.250 (0.250) | 0.000 | - | 8: 22.0, 0: 19.9, 40: 18.9, 736: 18.1, 154: 13.2 |
| 2 | vanilla | yes | 1.560 | 8.723 | 23.928 | 0 | 0.198 (0.090) | 0.252 (0.252) | 0.000 | - | 8: 23.9, 40: 19.3, 0: 17.5, 187: 16.8, 1139: 16.0 |
| 2 | quicksilver | yes | 1.535 | 8.943 | 29.591 | 0 | 0.217 (0.102) | 0.263 (0.263) | 0.000 | - | 8: 29.6, 40: 28.8, 48: 19.8, 0: 18.2, 228: 17.4 |
| 3 | vanilla | yes | 1.528 | 9.308 | 26.904 | 0 | 0.198 (0.087) | 0.277 (0.277) | 0.000 | - | 8: 26.9, 219: 20.6, 40: 18.5, 0: 17.9, 1112: 15.6 |
| 3 | quicksilver | yes | 1.549 | 11.160 | 31.404 | 0 | 0.180 (0.086) | 0.242 (0.242) | 0.000 | - | 40: 31.4, 8: 30.1, 0: 22.0, 208: 20.6, 32: 19.1 |
| 4 | vanilla | yes | 1.637 | 9.256 | 34.868 | 0 | 0.199 (0.092) | 0.296 (0.296) | 0.000 | - | 0: 34.9, 40: 30.9, 8: 30.0, 24: 19.5, 32: 16.0 |
| 4 | quicksilver | yes | 1.541 | 8.765 | 37.442 | 0 | 0.193 (0.086) | 0.242 (0.242) | 0.000 | - | 8: 37.4, 40: 28.1, 0: 22.7, 1096: 18.1, 664: 17.9 |
| 5 | vanilla | yes | 1.563 | 8.589 | 25.419 | 0 | 0.182 (0.084) | 0.283 (0.283) | 0.000 | - | 8: 25.4, 24: 25.0, 40: 24.9, 0: 22.7, 379: 16.1 |
| 5 | quicksilver | yes | 1.546 | 9.213 | 41.918 | 0 | 0.207 (0.100) | 0.234 (0.234) | 0.000 | - | 40: 41.9, 8: 30.7, 0: 21.0, 728: 17.9, 236: 16.3 |
| 6 | vanilla | yes | 1.649 | 10.289 | 28.028 | 0 | 0.201 (0.096) | 0.273 (0.273) | 0.000 | - | 1024: 28.0, 8: 26.6, 1136: 23.1, 0: 22.0, 345: 20.0 |
| 6 | quicksilver | yes | 1.530 | 8.429 | 27.647 | 0 | 0.194 (0.091) | 0.257 (0.257) | 0.000 | - | 8: 27.6, 960: 20.3, 0: 18.6, 82: 17.3, 40: 16.9 |
| 7 | vanilla | yes | 1.565 | 10.316 | 29.328 | 0 | 0.177 (0.085) | 0.268 (0.268) | 0.000 | - | 8: 29.3, 632: 25.1, 1000: 23.3, 952: 19.2, 120: 18.8 |
| 7 | quicksilver | yes | 1.502 | 9.471 | 29.917 | 0 | 0.196 (0.087) | 0.247 (0.247) | 0.000 | - | 40: 29.9, 8: 27.2, 184: 18.6, 688: 18.1, 760: 18.0 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 1.563 | 1.535 | 0.960 (0.93 to 1.01) |
| MSPT p99 | 9.256 | 9.133 | 1.018 (0.82 to 1.20) |
| slowest tick (ms) | 28.028 | 29.917 | 1.074 (0.52 to 1.65) |
| ticks over 50 ms | 0 | 0 | - (- to -) |
| chunk load, ms per tick (server thread) | 0.198 | 0.194 | 0.970 (0.91 to 1.14) |
|   of it in the tick | 0.089 | 0.089 | 1.000 (0.93 to 1.19) |
| chunk save, ms per tick (server thread) | 0.277 | 0.247 | 0.876 (0.82 to 1.05) |
|   of it in the tick | 0.277 | 0.247 | 0.876 (0.82 to 1.05) |
| autosave, ms per tick | 0.000 | 0.000 | - (- to -) |
| save-all tick (ms, mean of the script's) | - | - | - (- to -) |
| save-all flush tick (ms) | - | - | - (- to -) |
| autosave tick (ms, the game's own) | - | - | - (- to -) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 59791 ms, 23199 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 324 / 0 | 0 / 0 | 0.270 | 395.6 |
| entity save | 17 / 1 | 0 / 0 | 0.015 | 2.7 |
| POI save | 3 / 0 | 0 / 0 | 0.003 | 0.0 |
| chunk load | 0 / 0 | 60 / 2 | 0.052 | 55.1 |
| chunk to full (promote) | 99 / 0 | 69 / 0 | 0.140 | 37.9 |
| entity load | 8 / 0 | 7 / 0 | 0.013 | 2.1 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 11 / 0 | 0 / 0 | 0.009 | 8.6 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 417 / 0 | 236 / 0 | 0.544 | 210.3 |
| tick, other | 309 / 0 | 0 / 0 | 0.258 | 8.5 |
| idle or other | 0 / 0 | 61 / 0 | 0.051 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 1245, MinecraftServer.runServer 1245, Thread.run 1242, MinecraftServer.processPacketsAndTick 880, MinecraftServer.tickServer 880, DedicatedServer.tickServer 880, ServerLevel.tick 876, MinecraftServer.tickChildren 876, ServerChunkCache.tick 838, ServerChunkCache.runDistanceManagerUpdates 431, DistanceManager.runAllUpdates 426, MinecraftServer.pollTask 368, MinecraftServer.pollTaskInternal 368, ServerChunkCache.pollTask 367, ServerChunkCache$MainThreadExecutor.pollTask 367, MinecraftServer.waitUntilNextTick 366, BlockableEventLoop.pollTask 364, BlockableEventLoop.doRunTask 362, ServerChunkCache$MainThreadExecutor.doRunTask 358, BlockableEventLoop.managedBlock 348, ChunkMap.tick 341, ChunkMap.processUnloads 335, CompletableFuture$Completion.run 316, ChunkMap.saveChunksEagerly 307, CompletableFuture$UniApply.tryFire 298, DynamicGraphMinFixedPoint.runUpdates 282, LoadingChunkTracker.runDistanceUpdates 279, ChunkMap.saveChunkIfNeeded 249, ChunkTracker.checkNeighborsAfterUpdate 244, DynamicGraphMinFixedPoint.checkNeighbor 236, ChunkMap.save 224, SerializableChunkData.copyOf 219, ChunkMap.lambda$prepareTickingChunk$1 216, ChunkMap.lambda$prepareTickingChunk$2 216, ChunkResult$Success.map 215, LevelChunk.postProcessGeneration 198, Long2ObjectLinkedOpenHashMap.get 163, DynamicGraphMinFixedPoint.checkEdge 162, LoadingChunkTracker.getLevel 142, ChunkTracker.getComputedLevel 137, ChunkHolder.updateFutures 127, Block.updateFromNeighbourShapes 117, PalettedContainer.get 104, ChunkMap.getUpdatingChunkIfPresent 100, ChunkMap$DistanceManager.getChunk 94, LevelChunkSection.getBlockState 93, LevelChunk.getBlockState 93, Level.getBlockState 89, ChunkMap.getChunkRangeFuture 77, GenerationChunkHolder.scheduleChunkGenerationTask 66, AbstractPipeline.evaluate 66, CompletableFuture$AsyncSupply.run 65, ChunkGenerationTask.lambda$create$0 64, ChunkMap.scheduleGenerationTask 64, ChunkGenerationTask.create 64, StaticCache2D.create 64, ChunkMap.acquireGeneration 64, GenerationChunkHolder.rescheduleChunkTask 64, StaticCache2D.<init> 64, ChunkMap.lambda$scheduleChunkLoad$3 63

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 163, PalettedContainer.get 93, LongOpenHashSet.contains 49, Long2ObjectOpenHashMap.get 48, Long2LongOpenHashMap.getOrDefault 37, DynamicGraphMinFixedPoint.checkNeighbor 36, PalettedContainer$Data.copy 35, GenerationChunkHolder.getChunkIfPresentUnchecked 29, Long2ByteOpenHashMap.get 24, Long2ObjectOpenHashMap.getOrDefault 17, ChunkMap.saveChunksEagerly 16, ServerChunkCache.getChunk 13, VarHandleReferences$Array.getVolatile 13, ReferenceOpenHashSet.add 11, CompletableFuture.postComplete 10, Block.updateFromNeighbourShapes 9, GenerationChunkHolder.increaseGenerationRefCount 9, ChunkMap.onLevelChange 9, LongLinkedOpenHashSet.rehash 8, LongLinkedOpenHashSet.add 8, MultifaceBlock.hasAnyFace 8, FluidState.isEmpty 8, DynamicGraphMinFixedPoint.checkEdge 8, PriorityQueue.siftUpUsingComparator 8, ChunkTracker.checkNeighborsAfterUpdate 8, ChunkTracker.getComputedLevel 7, StateHolder.valueIndex 7, DirectMethodHandle.allocateInstance 7, SerializableChunkData.copyOf 7, HashMap.getNode 7

Threads (all samples in the window): Netty Epoll IO  47777, IO-Worker 7744, Worker-Main 5010, Server thread 1624, JFR Periodic Tasks 11

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 59792 ms, 22481 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk save | 282 / 0 | 0 / 0 | 0.235 | 269.6 |
| entity save | 14 / 0 | 0 / 0 | 0.012 | 3.4 |
| POI save | 4 / 0 | 0 / 0 | 0.003 | 0.0 |
| chunk load | 0 / 0 | 46 / 2 | 0.040 | 53.0 |
| chunk to full (promote) | 102 / 0 | 74 / 0 | 0.147 | 29.4 |
| entity load | 5 / 0 | 4 / 0 | 0.007 | 1.4 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 11 / 0 | 0 / 0 | 0.009 | 12.6 |
| light | 0 / 0 | 2 / 0 | 0.002 | 0.5 |
| chunk system (tickets, holders, tasks) | 399 / 1 | 263 / 0 | 0.552 | 213.6 |
| tick, other | 344 / 1 | 0 / 0 | 0.287 | 4.9 |
| idle or other | 0 / 0 | 70 / 2 | 0.060 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 1203, MinecraftServer.lambda$spin$0 1203, Thread.run 1202, DedicatedServer.tickServer 818, MinecraftServer.processPacketsAndTick 818, MinecraftServer.tickServer 818, MinecraftServer.tickChildren 813, ServerLevel.tick 813, ServerChunkCache.tick 784, ServerChunkCache.runDistanceManagerUpdates 406, DistanceManager.runAllUpdates 400, ServerChunkCache$MainThreadExecutor.pollTask 390, ServerChunkCache.pollTask 390, MinecraftServer.pollTaskInternal 388, MinecraftServer.pollTask 388, MinecraftServer.waitUntilNextTick 386, BlockableEventLoop.pollTask 380, BlockableEventLoop.doRunTask 378, ServerChunkCache$MainThreadExecutor.doRunTask 378, BlockableEventLoop.managedBlock 369, CompletableFuture$Completion.run 327, ChunkMap.tick 313, CompletableFuture$UniApply.tryFire 303, ChunkMap.processUnloads 293, ChunkMap.saveChunksEagerly 263, DynamicGraphMinFixedPoint.runUpdates 259, LoadingChunkTracker.runDistanceUpdates 259, ChunkResult$Success.map 238, ChunkMap.lambda$prepareTickingChunk$1 236, ChunkMap.lambda$prepareTickingChunk$2 235, ChunkTracker.checkNeighborsAfterUpdate 223, DynamicGraphMinFixedPoint.checkNeighbor 218, LevelChunk.postProcessGeneration 217, ChunkMap.saveChunkIfNeeded 209, ChunkMap.save 196, SerializableChunkData.copyOf 190, DynamicGraphMinFixedPoint.checkEdge 176, Long2ObjectLinkedOpenHashMap.get 161, ChunkHolder.updateFutures 131, Block.updateFromNeighbourShapes 126, LoadingChunkTracker.getLevel 125, ChunkTracker.getComputedLevel 107, PalettedContainer.get 96, Level.getBlockState 91, ChunkMap.getChunkRangeFuture 85, LevelChunk.getBlockState 85, LevelChunkSection.getBlockState 85, ChunkMap.getUpdatingChunkIfPresent 84, ChunkMap$DistanceManager.getChunk 83, GenerationChunkHolder.rescheduleChunkTask 76, ChunkMap.scheduleGenerationTask 76, GenerationChunkHolder.scheduleChunkGenerationTask 76, StaticCache2D.create 75, ChunkGenerationTask.create 75, ChunkMap.acquireGeneration 75, ChunkGenerationTask.lambda$create$0 75, StaticCache2D.<init> 75, ServerChunkCache.tickChunks 67, CompletableFuture$AsyncSupply.run 65, BlockBehaviour$BlockStateBase.updateShape 57

Top chunk methods (self): Long2ObjectLinkedOpenHashMap.get 161, PalettedContainer.get 89, LongOpenHashSet.contains 42, DynamicGraphMinFixedPoint.checkEdge 39, GenerationChunkHolder.getChunkIfPresentUnchecked 27, Long2LongOpenHashMap.getOrDefault 26, Long2ByteOpenHashMap.get 23, Long2ObjectOpenHashMap.get 21, PalettedContainer.create$quicksilver_$md$6fdee8$0 20, Long2ObjectFunctions$SynchronizedFunction.get 15, LevelChunkSection.<init> 15, LongLinkedOpenHashSet.add 14, ServerChunkCache.getChunk 13, ChunkMap.saveChunksEagerly 12, ChunkTracker.getComputedLevel 10, ReferenceOpenHashSet.add 9, Long2ByteOpenHashMap.find 9, VarHandleReferences$Array.getVolatile 9, Block.updateFromNeighbourShapes 8, Objects.equals 8, BlockBehaviour$BlockStateBase.updateShape 8, StateHolder.valueIndex 8, MultifaceBlock.updateShape 8, ConcurrentLinkedQueue.offer 8, CompletableFuture.postFire 7, ChunkMap.onLevelChange 7, FluidState.isEmpty 6, LocalCache.connectAccessOrder 6, ChunkMap.saveChunkIfNeeded 6, SerializableChunkData.copyOf 6

Threads (all samples in the window): Netty Epoll IO  47897, IO-Worker 7728, Worker-Main 5014, Server thread 1626, JFR Periodic Tasks 10

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 2936: LoadingChunkTracker.runDistanceUpdates 1869, ChunkHolder.updateFutures 896, GenerationChunkHolder.updateHighestAllowedStatus 53, ReferenceOpenHashSet$SetIterator.next 14, ReferenceOpenHashSet.clear 13, DistanceManager$PlayerTicketTracker.runAllUpdates 6, SimulationChunkTracker.runAllUpdates 4, DistanceManager$FixedPlayerDistanceChunkTracker.runAllUpdates 4, ReferenceOpenHashSet.iterator 2<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1868, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 294, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 180, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 130, ChunkHolder.updateFutures > ChunkMap.onLevelChange 127, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 111, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 37, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 20, ReferenceOpenHashSet.clear > Arrays.fill 13, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 6, ChunkHolder.updateFutures > CompletableFuture.complete 5, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 5
- **ChunkMap.processUnloads** 2239: ChunkMap.saveChunksEagerly 2018, CompletableFuture$Completion.run 181, ChunkMap.scheduleUnload 11, ConcurrentLinkedQueue.size 8, LongOpenHashSet.iterator 3, Long2ObjectLinkedOpenHashMap.remove 2, ConcurrentLinkedQueue.poll 1, Long2ObjectLinkedOpenHashMap.get 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1600, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 220, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 180, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 67, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 15, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 7, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.remove 5, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 4, ChunkMap.saveChunksEagerly > MinecraftServer.haveTime 3, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 1, ChunkMap.saveChunksEagerly > Util.getMillis 1
- **ChunkMap.saveChunksEagerly** 2018: ChunkMap.saveChunkIfNeeded 1600, GenerationChunkHolder.getLatestChunk 220, Long2ObjectLinkedOpenHashMap.get 67, LongLinkedOpenHashSet$SetIterator.nextLong 15, LongLinkedOpenHashSet$SetIterator.remove 5, MinecraftServer.haveTime 3, Util.getMillis 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1374, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 219, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 168, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 40, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 4, MinecraftServer.haveTime > Util.getNanos 3, LongLinkedOpenHashSet$SetIterator.remove > LongLinkedOpenHashSet$SetIterator.ensureIndexKnown 1, Util.getMillis > Util.getNanos 1
- **ChunkMap.save** 1500: SerializableChunkData.copyOf 1463, CompletableFuture.supplyAsync 10, SimpleRegionStorage.write 10, ChunkMap.markPosition 4, DirectMethodHandle.allocateInstance 3, ChunkAccess.tryMarkSaved 2, Profiler.get 1, CompletableFuture.handle 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 329, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 321, SerializableChunkData.copyOf > LightEngine.getDataLayerData 276, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 203, SerializableChunkData.copyOf > ReferencePipeline.toArray 68, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 57, SerializableChunkData.copyOf > DataLayer.copy 51, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 35, SerializableChunkData.copyOf > ArrayList.add 12, SimpleRegionStorage.write > IOWorker.store 10, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 9, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 8
- **SerializableChunkData.copyOf** 1463: LevelChunkSection.copy 329, LevelChunk.getBlockEntityNbtForSaving 321, LightEngine.getDataLayerData 276, SerializableChunkData.packStructureData 203, ReferencePipeline.toArray 68, LevelChunk.getTicksForSerialization 57, DataLayer.copy 51, ChunkAccess.getBlockEntitiesPos 35, ArrayList.add 11, LevelLightEngine.getMaxLightSection 9, Collections$UnmodifiableCollection$1.hasNext 8, Collections$UnmodifiableCollection$1.next 6<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 320, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 310, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 272, SerializableChunkData.packStructureData > StructureStart.createTag 140, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 66, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 54, DataLayer.copy > DataLayer.<init> 37, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 22, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 10, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 10, ArrayList.add > ArrayList.add 10, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 9
- **LevelChunk.postProcessGeneration** 1438: Block.updateFromNeighbourShapes 818, FluidState.tick 244, BlockBehaviour$BlockStateBase.tick 193, LevelChunk.getBlockState 80, FluidState.isEmpty 29, LevelWriter.setBlock 15, UpgradeData.upgrade 9, ShortListIterator.next 8, LevelHeightAccessor.getSectionYFromSectionIndex 7, ProtoChunk.unpackOffsetCoordinates 3, ShortArrayList$1.hasNext 3, ImmutableList.copyOf 2<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 456, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 312, FluidState.tick > FlowingFluid.tick 243, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 193, LevelChunk.getBlockState > LevelChunkSection.getBlockState 80, LevelWriter.setBlock > Level.setBlock 15, ShortListIterator.next > ShortListIterator.next 8, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 7, UpgradeData.upgrade > Iterable.forEach 2, UpgradeData.upgrade > UpgradeData.upgradeSides 2, ImmutableList.iterator > ImmutableList.listIterator 1, UpgradeData.upgrade > ArrayList.forEach 1
- **SerializableChunkData.read** 397: SerializableChunkData.unpackStructureStart 274, PoiManager.checkConsistencyWithBlocks 26, LevelChunkTicks.<init> 22, ImposterProtoChunk.<init> 20, SerializableChunkData.unpackStructureReferences 20, LevelChunk.<init> 5, ChunkAccess.addPackedPostProcess 4, ThreadedLevelLightEngine.queueSectionData 3, ChunkAccess.setHeightmap 3, ChunkAccess.setAllReferences 2, ChunkAccess.setAllStarts 2, Objects.equals 2<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 272, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 21, ImposterProtoChunk.<init> > ProtoChunk.<init> 19, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 19, PoiManager.checkConsistencyWithBlocks > Util.ifElse 17, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 9, ChunkAccess.addPackedPostProcess > ShortList.addAll 3, ChunkAccess.setAllReferences > HashMap.putAll 2, LevelChunk.<init> > ChunkAccess.<init> 2, Objects.equals > ChunkPos.equals 2, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 2, LevelHeightAccessor.getSectionIndexFromSectionY > LevelHeightAccessor.getMinSectionY 1
- **LevelChunk.runPostLoad** 304: SerializableChunkData.lambda$postLoadChunk$0 304<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 263, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 15, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 10, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 8, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 6
- **LevelChunk.<init>** 5: ChunkAccess.<init> 2, Int2ObjectOpenHashMap.<init> 1<br>two down: ChunkAccess.<init> > ChunkSkyLightSources.<init> 1, Int2ObjectOpenHashMap.<init> > Int2ObjectOpenHashMap.<init> 1, ChunkAccess.<init> > ChunkAccess.replaceMissingSections 1

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **DistanceManager.runAllUpdates** 2925: LoadingChunkTracker.runDistanceUpdates 1864, ChunkHolder.updateFutures 924, GenerationChunkHolder.updateHighestAllowedStatus 47, ReferenceOpenHashSet$SetIterator.next 15, ReferenceOpenHashSet.clear 11, DistanceManager$PlayerTicketTracker.runAllUpdates 6<br>two down: LoadingChunkTracker.runDistanceUpdates > DynamicGraphMinFixedPoint.runUpdates 1864, ChunkHolder.updateFutures > ChunkMap.prepareAccessibleChunk 319, ChunkHolder.updateFutures > ChunkMap.prepareEntityTickingChunk 161, ChunkHolder.updateFutures > ChunkHolder.demoteFullChunk 139, ChunkHolder.updateFutures > ChunkMap.prepareTickingChunk 128, ChunkHolder.updateFutures > ChunkMap.onLevelChange 118, GenerationChunkHolder.updateHighestAllowedStatus > GenerationChunkHolder.failAndClearPendingFuturesBetween 32, ChunkHolder.updateFutures > ChunkHolder.scheduleFullChunkPromotion 19, ReferenceOpenHashSet.clear > Arrays.fill 11, ChunkHolder.updateFutures > ChunkHolder.addSaveDependency 9, ChunkHolder.updateFutures > GenerationChunkHolder.getChunkIfPresentUnchecked 8, ChunkHolder.updateFutures > CompletableFuture.complete 7
- **ChunkMap.processUnloads** 1984: ChunkMap.saveChunksEagerly 1788, CompletableFuture$Completion.run 157, ChunkMap.scheduleUnload 14, ConcurrentLinkedQueue.size 3, ConcurrentLinkedQueue.poll 3, Long2ObjectLinkedOpenHashMap.remove 3, LongOpenHashSet$SetIterator.nextLong 2, LongOpenHashSet$SetIterator.remove 1, Long2ObjectLinkedOpenHashMap.get 1, LongOpenHashSet.iterator 1, Long2ObjectLinkedOpenHashMap.put 1<br>two down: ChunkMap.saveChunksEagerly > ChunkMap.saveChunkIfNeeded 1361, ChunkMap.saveChunksEagerly > GenerationChunkHolder.getLatestChunk 230, CompletableFuture$Completion.run > CompletableFuture$UniRun.tryFire 157, ChunkMap.saveChunksEagerly > Long2ObjectLinkedOpenHashMap.get 74, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet$SetIterator.nextLong 16, ChunkMap.saveChunksEagerly > MinecraftServer.haveTime 3, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 3, ChunkMap.scheduleUnload > CompletableFuture.thenRunAsync 3, ChunkMap.scheduleUnload > DirectMethodHandle.allocateInstance 3, Long2ObjectLinkedOpenHashMap.remove > Long2ObjectLinkedOpenHashMap.removeEntry 3, ChunkMap.scheduleUnload > MethodHandleNatives.linkCallSite 2, ChunkMap.scheduleUnload > CompletableFuture.whenComplete 2
- **ChunkMap.saveChunksEagerly** 1788: ChunkMap.saveChunkIfNeeded 1361, GenerationChunkHolder.getLatestChunk 230, Long2ObjectLinkedOpenHashMap.get 74, LongLinkedOpenHashSet$SetIterator.nextLong 16, MinecraftServer.haveTime 3, LongLinkedOpenHashSet.iterator 3, Util.getMillis 1, LongLinkedOpenHashSet$SetIterator.remove 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 1172, GenerationChunkHolder.getLatestChunk > GenerationChunkHolder.getChunkIfPresentUnchecked 218, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 118, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 40, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 4, MinecraftServer.haveTime > Util.getNanos 3, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 3, Util.getMillis > Util.getNanos 1, ChunkMap.saveChunkIfNeeded > ChunkHolder.isReadyForSaving 1
- **LevelChunk.postProcessGeneration** 1498: Block.updateFromNeighbourShapes 885, BlockBehaviour$BlockStateBase.tick 222, FluidState.tick 217, LevelChunk.getBlockState 67, FluidState.isEmpty 22, LevelWriter.setBlock 14, ShortListIterator.next 9, LevelHeightAccessor.getSectionYFromSectionIndex 9, UpgradeData.upgrade 7, ProtoChunk.unpackOffsetCoordinates 3, ShortArrayList$1.hasNext 2, ImmutableList.copyOf 1<br>two down: Block.updateFromNeighbourShapes > Level.getBlockState 462, Block.updateFromNeighbourShapes > BlockBehaviour$BlockStateBase.updateShape 367, BlockBehaviour$BlockStateBase.tick > LiquidBlock.tick 222, FluidState.tick > FlowingFluid.tick 217, LevelChunk.getBlockState > LevelChunkSection.getBlockState 65, LevelWriter.setBlock > Level.setBlock 14, ShortListIterator.next > ShortListIterator.next 9, LevelHeightAccessor.getSectionYFromSectionIndex > LevelHeightAccessor.getMinSectionY 9, UpgradeData.upgrade > UpgradeData.upgradeInside 3, UpgradeData.upgrade > UpgradeData.upgradeSides 2, UpgradeData.upgrade > Iterable.forEach 2, ImmutableList.copyOf > ImmutableList.construct 1
- **ChunkMap.save** 1289: SerializableChunkData.copyOf 1259, SimpleRegionStorage.write 12, ChunkMap.markPosition 5, DirectMethodHandle.allocateInstance 3, SectionStorage.flush 3, CompletableFuture.supplyAsync 2, ChunkAccess.tryMarkSaved 2<br>two down: SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 267, SerializableChunkData.copyOf > LevelChunkSection.copy 242, SerializableChunkData.copyOf > LightEngine.getDataLayerData 237, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 210, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 56, SerializableChunkData.copyOf > ReferencePipeline.toArray 52, SerializableChunkData.copyOf > DataLayer.copy 30, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 30, SerializableChunkData.copyOf > Collections$UnmodifiableCollection$1.hasNext 16, SimpleRegionStorage.write > IOWorker.store 12, SerializableChunkData.copyOf > ArrayList.add 9, SerializableChunkData.copyOf > ProblemReporter$ScopedCollector.close 5
- **SerializableChunkData.copyOf** 1259: LevelChunk.getBlockEntityNbtForSaving 267, LevelChunkSection.copy 242, LightEngine.getDataLayerData 237, SerializableChunkData.packStructureData 210, LevelChunk.getTicksForSerialization 56, ReferencePipeline.toArray 52, DataLayer.copy 30, ChunkAccess.getBlockEntitiesPos 30, Collections$UnmodifiableCollection$1.hasNext 15, ArrayList.add 8, ProblemReporter$ScopedCollector.close 5, SerializableChunkData.handler$zon000$quicksilver$copied 4<br>two down: LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 256, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 235, LevelChunkSection.copy > LevelChunkSection.<init> 230, SerializableChunkData.packStructureData > StructureStart.createTag 146, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 54, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 51, DataLayer.copy > DataLayer.<init> 22, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 19, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 10, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 10, ArrayList.add > ArrayList.add 9, SerializableChunkData.packStructureData > Identifier.toString 9
- **SerializableChunkData.read** 384: SerializableChunkData.unpackStructureStart 271, LevelChunkTicks.<init> 29, PoiManager.checkConsistencyWithBlocks 26, SerializableChunkData.unpackStructureReferences 18, ImposterProtoChunk.<init> 15, ChunkAccess.setAllReferences 5, LevelChunk.<init> 4, ChunkAccess.setAllStarts 2, ChunkAccess.setHeightmap 2, ThreadedLevelLightEngine.queueSectionData 2, ThreadedLevelLightEngine.retainData 1, ChunkAccess.addPackedPostProcess 1<br>two down: SerializableChunkData.unpackStructureStart > StructureStart.loadStaticStart 264, LevelChunkTicks.<init> > ObjectOpenCustomHashSet.add 29, SerializableChunkData.unpackStructureReferences > CompoundTag.forEach 17, ImposterProtoChunk.<init> > ProtoChunk.<init> 15, PoiManager.checkConsistencyWithBlocks > SectionStorage.getOrLoad 14, PoiManager.checkConsistencyWithBlocks > Util.ifElse 12, LevelChunk.<init> > ChunkAccess.<init> 3, SerializableChunkData.unpackStructureStart > CompoundTag.getCompoundOrEmpty 3, ChunkAccess.setAllReferences > HashMap.putAll 2, ChunkAccess.setHeightmap > ChunkAccess.getOrCreateHeightmapUnprimed 2, SerializableChunkData.unpackStructureStart > CompoundTag.keySet 2, ThreadedLevelLightEngine.queueSectionData > ThreadedLevelLightEngine.addTask 2
- **LevelChunk.runPostLoad** 281: SerializableChunkData.lambda$postLoadChunk$0 281<br>two down: SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.loadStatic 238, SerializableChunkData.lambda$postLoadChunk$0 > BlockEntity.getPosFromTag 14, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.setBlockEntity 11, SerializableChunkData.lambda$postLoadChunk$0 > LevelChunk.getBlockState 9, SerializableChunkData.lambda$postLoadChunk$0 > CompoundTag.getBooleanOr 3
- **LevelChunk.<init>** 4: ChunkAccess.<init> 3<br>two down: ChunkAccess.<init> > ChunkAccess.replaceMissingSections 1, ChunkAccess.<init> > Maps.newEnumMap 1
- **SectionStorage.flush** 3: ChunkPos.pack 2, LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 1614 | 6015 | 3542 | 1934 | 539 | 258 (first [-1, 10]) |
| 1 | quicksilver | 1614 | 6015 | 3554 | 1916 | 545 | 225 (first [-1, 17]) |
| 2 | vanilla | 1614 | 6015 | 3651 | 1850 | 514 | 247 (first [-1, -18]) |
| 2 | quicksilver | 1614 | 6015 | 3595 | 1869 | 551 | 292 (first [-1, -16]) |
| 3 | vanilla | 1614 | 6015 | 3602 | 1760 | 653 | 317 (first [-1, -18]) |
| 3 | quicksilver | 1614 | 6015 | 3642 | 1899 | 474 | 242 (first [-1, -16]) |
| 4 | vanilla | 1614 | 6015 | 3513 | 1804 | 698 | 328 (first [-1, -16]) |
| 4 | quicksilver | 1614 | 6015 | 3475 | 1947 | 593 | 258 (first [-1, -17]) |
| 5 | vanilla | 1614 | 6015 | 3720 | 1746 | 549 | 310 (first [-1, -16]) |
| 5 | quicksilver | 1614 | 6015 | 3603 | 1911 | 501 | 240 (first [-1, -16]) |
| 6 | vanilla | 1614 | 6015 | 3467 | 1784 | 764 | 275 (first [-1, 11]) |
| 6 | quicksilver | 1614 | 6015 | 3632 | 1898 | 485 | 278 (first [-1, -17]) |
| 7 | vanilla | 1614 | 6015 | 3590 | 1798 | 627 | 316 (first [-1, -16]) |
| 7 | quicksilver | 1614 | 6015 | 3557 | 1984 | 474 | 257 (first [-1, -16]) |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 18 / 24 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 829 (303) | 0 (0) | LastUpdate 239, block_ticks 514, fluid_ticks 472 | 1509 / 1681 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 15 / 24 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 769 (0) | 0 (0) | LastUpdate 236, block_ticks 484, fluid_ticks 441 | 1525 / 1681 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 850 (313) | 0 (0) | LastUpdate 235, block_ticks 524, fluid_ticks 504, sections 1 | 1528 / 1681 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 2 (0) | 0 (0) | Entities 2 | 0 / 51 | 3 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 24 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 711 (0) | 0 (0) | LastUpdate 239, block_ticks 430, fluid_ticks 420, sections 1 | 1534 / 1681 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 12 / 24 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 778 (223) | 0 (0) | LastUpdate 224, block_ticks 470, fluid_ticks 449, sections 1 | 1515 / 1681 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 837 (0) | 0 (0) | LastUpdate 216, block_ticks 533, fluid_ticks 494, sections 1 | 1480 / 1681 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 804 (279) | 0 (0) | LastUpdate 228, block_ticks 537, fluid_ticks 437, sections 1 | 1506 / 1681 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 24 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 822 (0) | 0 (0) | LastUpdate 255, block_ticks 508, fluid_ticks 486 | 1485 / 1681 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 10 / 24 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 823 (251) | 0 (0) | LastUpdate 211, block_ticks 521, fluid_ticks 478, sections 1 | 1520 / 1681 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 883 (0) | 0 (0) | LastUpdate 269, block_ticks 567, fluid_ticks 481 | 1483 / 1681 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 877 (292) | 0 (0) | LastUpdate 283, block_ticks 572, fluid_ticks 469, sections 1 | 1524 / 1681 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 6 (0) | 0 (0) | DataVersion 5, Entities 6, Position 5 | 0 / 51 | 3 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 9 / 24 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 803 (0) | 0 (0) | LastUpdate 220, block_ticks 494, fluid_ticks 473 | 1532 / 1681 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 205 | 0 (0) | 5 (0) | 0 (0) | DataVersion 5, Entities 5, Position 5 | 0 / 51 | 3 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 11 / 24 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 745 (224) | 0 (0) | LastUpdate 223, block_ticks 466, fluid_ticks 444 | 1512 / 1681 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 7 data, 0 bytes only, 0 one side, keys DataVersion 25, Entities 29, Position 25; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 1107 data, 0 bytes only, 0 one side, keys LastUpdate 1435, block_ticks 3016, fluid_ticks 2795, sections 2

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 249 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / save

| round | side | finished | mspt avg | p99 | max | over 50 ms | load ms/tick (in tick) | save ms/tick (in tick) | autosave ms/tick | autosave ticks (ms) | slowest ticks |
|---|---|---|---|---|---|---|---|---|---|---|---|
| 1 | vanilla | yes | 0.528 | 0.774 | 2566.174 | 4 | 0.001 (0.001) | 0.018 (0.018) | 0.018 | 5727 (79.6) | 700: 2566.2, 100: 82.8, 5727: 79.6, 400: 64.4, 0: 32.5 |
| 1 | quicksilver | yes | 0.554 | 0.782 | 2701.919 | 4 | 0.001 (0.001) | 0.020 (0.020) | 0.019 | 5727 (96.1) | 700: 2701.9, 5727: 96.1, 100: 92.8, 400: 76.6, 0: 27.4 |
| 2 | vanilla | yes | 0.519 | 1.038 | 2565.210 | 3 | 0.000 (0.000) | 0.012 (0.012) | 0.012 | 5730 (49.6) | 700: 2565.2, 100: 80.7, 400: 78.2, 5730: 49.6, 569: 30.9 |
| 2 | quicksilver | yes | 0.502 | 0.671 | 2561.471 | 4 | 0.000 (0.000) | 0.020 (0.020) | 0.019 | 5728 (72.6) | 700: 2561.5, 100: 84.6, 400: 80.7, 5728: 72.6, 0: 21.5 |
| 3 | vanilla | yes | 0.511 | 1.092 | 2440.183 | 4 | 0.000 (0.000) | 0.014 (0.014) | 0.013 | 5723 (69.6) | 700: 2440.2, 100: 71.6, 5723: 69.6, 400: 68.6, 453: 40.1 |
| 3 | quicksilver | yes | 0.516 | 0.672 | 2556.302 | 4 | 0.000 (0.000) | 0.011 (0.011) | 0.010 | 5728 (34.7) | 700: 2556.3, 100: 70.9, 4112: 54.5, 400: 50.9, 561: 38.7 |
| 4 | vanilla | yes | 0.508 | 0.917 | 2546.005 | 4 | 0.001 (0.001) | 0.012 (0.012) | 0.012 | 5728 (48.8) | 700: 2546.0, 400: 100.1, 100: 84.6, 6143: 54.4, 5728: 48.8 |
| 4 | quicksilver | yes | 0.525 | 0.990 | 2486.553 | 4 | 0.000 (0.000) | 0.020 (0.020) | 0.019 | 5727 (45.4) | 700: 2486.6, 100: 98.8, 400: 81.0, 1083: 58.9, 576: 46.1 |
| 5 | vanilla | yes | 0.507 | 0.779 | 2380.670 | 4 | 0.000 (0.000) | 0.015 (0.015) | 0.014 | 5727 (50.9) | 700: 2380.7, 100: 108.8, 400: 65.2, 5727: 50.9, 524: 33.7 |
| 5 | quicksilver | yes | 0.537 | 0.757 | 2640.223 | 4 | 0.000 (0.000) | 0.016 (0.016) | 0.014 | 5726 (63.3) | 700: 2640.2, 100: 94.5, 400: 82.0, 5726: 63.3, 0: 24.2 |
| 6 | vanilla | yes | 0.506 | 0.607 | 2586.199 | 4 | 0.000 (0.000) | 0.013 (0.013) | 0.013 | 5724 (71.8) | 700: 2586.2, 100: 77.4, 5724: 71.8, 400: 60.2, 0: 35.5 |
| 6 | quicksilver | yes | 0.524 | 0.802 | 2569.136 | 4 | 0.000 (0.000) | 0.016 (0.016) | 0.015 | 5728 (63.6) | 700: 2569.1, 100: 101.0, 5728: 63.6, 400: 59.5, 0: 19.8 |
| 7 | vanilla | yes | 0.538 | 0.787 | 2650.235 | 3 | 0.000 (0.000) | 0.017 (0.017) | 0.016 | 5726 (45.8) | 700: 2650.2, 100: 100.7, 400: 59.8, 5726: 45.8, 575: 37.3 |
| 7 | quicksilver | yes | 0.510 | 0.657 | 2580.757 | 4 | 0.000 (0.000) | 0.017 (0.016) | 0.015 | 5728 (68.9) | 700: 2580.8, 100: 94.9, 6115: 71.3, 5728: 68.9, 400: 49.6 |

| measure | vanilla median | Quicksilver median | Quicksilver / vanilla, median of rounds (range) |
|---|---|---|---|
| MSPT average | 0.511 | 0.524 | 1.033 (0.95 to 1.06) |
| MSPT p99 | 0.787 | 0.757 | 0.972 (0.62 to 1.32) |
| slowest tick (ms) | 2565.210 | 2569.136 | 0.999 (0.97 to 1.11) |
| ticks over 50 ms | 4 | 4 | 1.000 (1.00 to 1.33) |
| chunk load, ms per tick (server thread) | 0.000 | 0.000 | 0.429 (0.25 to 4.00) |
|   of it in the tick | 0.000 | 0.000 | 0.429 (0.25 to 4.00) |
| chunk save, ms per tick (server thread) | 0.014 | 0.017 | 1.098 (0.81 to 1.61) |
|   of it in the tick | 0.014 | 0.016 | 1.110 (0.81 to 1.60) |
| autosave, ms per tick | 0.013 | 0.015 | 1.080 (0.77 to 1.60) |
| save-all tick (ms, mean of the script's) | 79.451 | 82.653 | 1.014 (0.87 to 1.17) |
| save-all flush tick (ms) | 2565.210 | 2569.136 | 0.999 (0.97 to 1.11) |
| autosave tick (ms, the game's own) | 50.894 | 63.618 | 1.208 (0.50 to 1.50) |

<details><summary>vanilla round 1: server thread by phase (samples, about 1 ms each; window 3741 ms, 23654 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 119 / 3 | 1 / 0 | 0.018 | 165.7 |
| chunk save | 2 / 0 | 0 / 0 | 0.000 | 0.0 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 3 / 0 | 0 / 0 | 0.000 | 0.9 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 4 / 0 | 0 / 0 | 0.001 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 1 / 0 | 0 / 0 | 0.000 | 0.0 |
| light | 0 / 0 | 1 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 176 / 5 | 2 / 0 | 0.026 | 33.4 |
| tick, other | 427 / 0 | 0 / 0 | 0.061 | 7.0 |
| idle or other | 0 / 0 | 16 / 0 | 0.002 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.lambda$spin$0 316, MinecraftServer.runServer 316, Thread.run 316, DedicatedServer.tickServer 313, MinecraftServer.processPacketsAndTick 313, MinecraftServer.tickServer 313, ServerLevel.tick 188, MinecraftServer.tickChildren 188, ServerChunkCache.tick 168, ServerChunkCache.tickChunks 144, DedicatedServer.saveAllChunks 122, MinecraftServer.saveEverything 122, MinecraftServer.saveAllChunks 122, ServerLevel.save 116, NaturalSpawner.createState 112, ChunkMap.saveAllChunks 107, ServerChunkCache.save 107, ChunkMap.save 104, SerializableChunkData.copyOf 102, ChunkMap.saveChunkIfNeeded 92, ServerChunkCache.getFullChunk 82, Harness.startTick 76, ServerTickEvents.lambda$static$1 76, ChunkResult$Success.ifSuccess 74, CommandDispatcher.execute 73, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 73, ContextChain.runExecutable$mixinextras$wrapped$10 73, Harness.command 73, SaveAllCommand.saveAll 73, ContextChain.executeAll 73, ContextChain.runExecutable 73, NaturalSpawner.lambda$createState$0 72, EnvironmentAttributeReader.getValue 61, EnvironmentAttributeSystem$ValueSampler.getValue 60, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 60, EnvironmentAttributeSystem.getValue 60, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 53, SaveAllCommand.lambda$register$0 52, MinecraftServer.autoSave 50, BiomeManager.getBiome 43, ServerChunkCache.getChunk 38, LevelReader.getNoiseBiome 38, Level.getChunk 38, LevelChunkSection.copy 34, LevelChunkSection.<init> 33, PalettedContainer.copy 33, PalettedContainer$Data.copy 30, PalettedContainer.<init> 30, SerializableChunkData.packStructureData 23, Long2ByteOpenHashMap.get 22, SimulationChunkTracker.getLevel 21, SaveAllCommand.lambda$register$1 21, ServerLevel.shouldTickBlocksAt 20, DistanceManager.inBlockTickingRange 20, AbstractPipeline.evaluate 19, ServerChunkCache.isPositionTicking 19, LevelTicks.tick 19, LevelTicks.collectTicks 19, ServerLevel.isPositionTickingWithEntitiesLoaded 19, LevelTicks.sortContainersToTick 19

Top chunk methods (self): ServerChunkCache.getChunk 29, PalettedContainer$Data.copy 28, Long2ByteOpenHashMap.get 22, NaturalSpawner.createState 20, ServerChunkCache.tickChunks 8, SerializableChunkData.copyOf 6, Long2ObjectOpenHashMap.get 6, RandomAccessFile.readBytes0 5, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 5, Long2ObjectOpenHashMap.<init> 5, CompletableFuture.reportJoin 5, BiomeManager.getBiome 4, ChunkMap.tick 4, RegularImmutableMap.get 4, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 4, MappedRegistry.getKey 3, SerializableChunkData.packStructureData 3, HashMap.putVal 3, ChunkPos.pack 3, SectionPos.of 3, PiecesContainer.save 3, PalettedContainer.copy 3, BlockableEventLoop.managedBlock 3, Entity.isPassenger 3, ArrayList.forEach 3, Long2ByteMaps$1.iterator 2, VarHandleReferences$Array.getVolatile 2, Spliterator.getExactSizeIfKnown 2, DataLayer.copy 2, SculkShriekerBlockEntity.saveAdditional 2

Threads (all samples in the window): Netty Epoll IO  2260, Worker-Main 1121, Server thread 760, IO-Worker 738

</details>

<details><summary>quicksilver round 1: server thread by phase (samples, about 1 ms each; window 3938 ms, 23844 samples outside, 0 untimed)</summary>

| phase | in tick (Java / native) | between ticks (Java / native) | ms per tick, all | allocated MB |
|---|---|---|---|---|
| autosave | 130 / 3 | 0 / 0 | 0.019 | 107.4 |
| chunk save | 3 / 0 | 0 / 0 | 0.000 | 1.5 |
| entity save | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI save | 5 / 0 | 0 / 0 | 0.001 | 0.6 |
| chunk load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk to full (promote) | 4 / 0 | 0 / 0 | 0.001 | 0.0 |
| entity load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| POI load | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk unload | 1 / 0 | 0 / 0 | 0.000 | 0.6 |
| light | 0 / 0 | 0 / 0 | 0.000 | 0.0 |
| chunk system (tickets, holders, tasks) | 164 / 1 | 1 / 0 | 0.024 | 32.4 |
| tick, other | 416 / 1 | 0 / 0 | 0.060 | 7.9 |
| idle or other | 0 / 0 | 28 / 0 | 0.004 | 0.0 |

Top chunk methods (inclusive): MinecraftServer.runServer 312, MinecraftServer.lambda$spin$0 312, MinecraftServer.processPacketsAndTick 311, MinecraftServer.tickServer 311, DedicatedServer.tickServer 311, Thread.run 309, ServerLevel.tick 173, MinecraftServer.tickChildren 173, ServerChunkCache.tick 153, DedicatedServer.saveAllChunks 133, MinecraftServer.saveEverything 133, MinecraftServer.saveAllChunks 133, ServerLevel.save 129, ServerChunkCache.tickChunks 124, Harness.startTick 119, ServerTickEvents.lambda$static$1 119, Harness.command 114, SaveAllCommand.saveAll 114, CommandDispatcher.execute 114, ContextChain.mixinextras$bridge$runExecutable$mixinextras$wrapped$10$11 114, ContextChain.executeAll 114, ContextChain.runExecutable$mixinextras$wrapped$10 114, ContextChain.runExecutable 114, ServerChunkCache.save 112, ChunkMap.saveAllChunks 112, ChunkMap.save 110, SerializableChunkData.copyOf 108, ChunkMap.saveChunkIfNeeded 101, SaveAllCommand.lambda$register$0 95, NaturalSpawner.createState 92, ServerChunkCache.getFullChunk 67, NaturalSpawner.lambda$createState$0 54, ChunkResult$Success.ifSuccess 54, EnvironmentAttributeReader.getValue 44, EnvironmentAttributeSystem.getValue 42, EnvironmentAttributeSystem$ValueSampler.computeValuePositional 41, EnvironmentAttributeSystem$ValueSampler.getValue 41, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 40, BiomeManager.getBiome 33, LevelReader.getNoiseBiome 32, Level.getChunk 31, ServerChunkCache.getChunk 31, LevelChunkSection.copy 24, Encoder.encodeStart 23, LevelChunkSection.<init> 23, PalettedContainer.create$quicksilver_$md$657a6a$0 20, PalettedContainerInvoker.quicksilver$create 20, PalettedContainer.handler$zom000$quicksilver$share 20, PalettedContainer.copy 20, SimulationChunkTracker.getLevel 19, SaveAllCommand.lambda$register$1 19, MinecraftServer.autoSave 19, ServerLevel.shouldTickBlocksAt 18, Long2ByteOpenHashMap.get 18, DistanceManager.inBlockTickingRange 18, LevelTicks.sortContainersToTick 17, ServerChunkCache.isPositionTicking 17, LevelTicks.tick 17, ServerLevel.isPositionTickingWithEntitiesLoaded 17, LevelTicks.collectTicks 17

Top chunk methods (self): SerializableChunkData.copyOf 25, ServerChunkCache.getChunk 22, PalettedContainer.create$quicksilver_$md$657a6a$0 20, Long2ByteOpenHashMap.get 18, ServerChunkCache.tickChunks 16, Long2ObjectLinkedOpenHashMap.get 10, NaturalSpawner.createState 9, Iterators$1.hasNext 9, DataLayer.copy 7, Long2ObjectOpenHashMap.<init> 5, CompletableFuture.reportJoin 5, NaturalSpawner.lambda$createState$0 4, ServerChunkCache.storeInCache 4, ArrayList.forEach 4, Arrays.copyOf 3, Long2ObjectOpenHashMap.get 3, LevelChunkSection.<init> 3, EnvironmentAttributeSystem.lambda$addBiomeLayerForAttribute$0 3, ArrayList.addAll 3, TimSort.sort 3, Reference2ObjectOpenHashMap.get 3, TicketStorage.purgeStaleTickets 3, Long2ObjectOpenHashMap$MapIterator.nextEntry 3, Vec3.atLowerCornerWithOffset 2, ChunkPos.pack 2, VarHandleReferences$Array.getVolatile 2, ScheduledTick.toSavedTick 2, Direction.lambda$static$1 2, VibrationSelector.lambda$static$2 2, Sets.newHashSet 2

Threads (all samples in the window): Netty Epoll IO  2440, Worker-Main 1289, IO-Worker 776, Server thread 757, JFR Periodic Tasks 1

</details>

<details><summary>vanilla, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 665: DedicatedServer.saveAllChunks 663, MinecraftServer.warnOnLowDiskSpace 2<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 663, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 2
- **ServerLevel.save** 627: ServerChunkCache.save 546, PersistentEntitySectionManager.autoSave 41, PersistentEntitySectionManager.saveAll 30, ServerLevel.saveLevelData 10<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 546, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 39, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 23, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 7, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 4, PersistentEntitySectionManager.saveAll > EntityStorage.flush 3, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 3, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 2
- **ChunkMap.saveAllChunks** 546: ChunkMap.saveChunkIfNeeded 405, ReferencePipeline.forEach 125, ReferencePipeline.toList 5, Collection.stream 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 401, ReferencePipeline.forEach > AbstractPipeline.evaluate 125, ReferencePipeline.toList > ReferencePipeline.toArray 5, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1, Collection.stream > StreamSupport.stream 1
- **ChunkMap.save** 515: SerializableChunkData.copyOf 493, CompletableFuture.supplyAsync 8, SimpleRegionStorage.write 4, ChunkMap.markPosition 2, ChunkAccess.tryMarkSaved 2, CompletableFuture.handle 1, ProfilerFiller.incrementCounter 1, DirectMethodHandle.allocateInstance 1, Profiler.get 1, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 122, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 83, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 79, SerializableChunkData.copyOf > LightEngine.getDataLayerData 66, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 36, SerializableChunkData.copyOf > LevelLightEngine.getMaxLightSection 15, SerializableChunkData.copyOf > ReferencePipeline.toArray 13, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 9, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 8, SerializableChunkData.copyOf > DataLayer.copy 7, SimpleRegionStorage.write > IOWorker.store 4, SerializableChunkData.copyOf > Heightmap.getRawData 3
- **SerializableChunkData.copyOf** 493: LevelChunkSection.copy 122, LevelChunk.getBlockEntityNbtForSaving 83, SerializableChunkData.packStructureData 79, LightEngine.getDataLayerData 66, LevelChunk.getTicksForSerialization 36, LevelLightEngine.getMaxLightSection 15, ReferencePipeline.toArray 13, ChunkAccess.getBlockEntitiesPos 9, DataLayer.copy 7, Heightmap.getRawData 3, ArrayList.add 3, TagValueOutput.createWithContext 2<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 120, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 77, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 58, SerializableChunkData.packStructureData > StructureStart.createTag 46, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 32, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 12, LevelLightEngine.getMaxLightSection > LevelLightEngine.getLightSectionCount 10, LevelChunk.getBlockEntityNbtForSaving > LevelChunk.getBlockEntity 6, LightEngine.getDataLayerData > SectionPos.asLong 6, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 5, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 5, LevelLightEngine.getMaxLightSection > LevelLightEngine.getMinLightSection 5
- **PersistentEntitySectionManager.autoSave** 41: AbstractLongCollection.forEach 39, PersistentEntitySectionManager.getAllChunksToSave 2<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 39
- **ChunkMap.processUnloads** 28: ChunkMap.saveChunksEagerly 14, LongOpenHashSet.iterator 2, ConcurrentLinkedQueue.size 1<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 7, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 2, LongOpenHashSet.iterator > LongOpenHashSet$SetIterator.<init> 1
- **ChunkMap.saveChunksEagerly** 14: Util.getMillis 7, LongLinkedOpenHashSet.iterator 2<br>two down: Util.getMillis > Util.getNanos 7, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2
- **SectionStorage.flush** 1: LongLinkedOpenHashSet.remove 1<br>two down: 

</details>

<details><summary>quicksilver, all rounds: inside loads and saves (samples under each method, its callees)</summary>

- **MinecraftServer.saveEverything** 774: DedicatedServer.saveAllChunks 769, MinecraftServer.warnOnLowDiskSpace 5<br>two down: DedicatedServer.saveAllChunks > MinecraftServer.saveAllChunks 768, MinecraftServer.warnOnLowDiskSpace > LevelStorageSource$LevelStorageAccess.checkForLowDiskSpace 5
- **ServerLevel.save** 739: ServerChunkCache.save 629, PersistentEntitySectionManager.autoSave 57, PersistentEntitySectionManager.saveAll 37, ServerLevel.saveLevelData 15<br>two down: ServerChunkCache.save > ChunkMap.saveAllChunks 629, PersistentEntitySectionManager.autoSave > AbstractLongCollection.forEach 49, PersistentEntitySectionManager.saveAll > LongCollection.removeIf 31, ServerLevel.saveLevelData > SavedDataStorage.scheduleSave 11, PersistentEntitySectionManager.autoSave > PersistentEntitySectionManager.getAllChunksToSave 8, ServerLevel.saveLevelData > SavedDataStorage.saveAndJoin 4, PersistentEntitySectionManager.saveAll > EntityStorage.flush 3, PersistentEntitySectionManager.saveAll > PersistentEntitySectionManager.getAllChunksToSave 2, PersistentEntitySectionManager.saveAll > MethodHandleNatives.linkCallSite 1
- **ChunkMap.saveAllChunks** 629: ChunkMap.saveChunkIfNeeded 543, ReferencePipeline.forEach 78, Long2ObjectLinkedOpenHashMap$ValueIterator.next 3, ReferencePipeline.toList 1<br>two down: ChunkMap.saveChunkIfNeeded > ChunkMap.save 539, ReferencePipeline.forEach > AbstractPipeline.evaluate 78, Long2ObjectLinkedOpenHashMap$ValueIterator.next > Long2ObjectLinkedOpenHashMap$MapIterator.nextEntry 3, ReferencePipeline.toList > ReferencePipeline.toArray 1, ChunkMap.saveChunkIfNeeded > GenerationChunkHolder.getLatestChunk 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.put 1, ChunkMap.saveChunkIfNeeded > Long2LongOpenHashMap.getOrDefault 1
- **ChunkMap.save** 610: SerializableChunkData.copyOf 586, CompletableFuture.supplyAsync 10, SimpleRegionStorage.write 7, DirectMethodHandle.allocateInstance 2, CompletableFuture.handle 2, ChunkMap.markPosition 2, SectionStorage.flush 1<br>two down: SerializableChunkData.copyOf > LevelChunkSection.copy 171, SerializableChunkData.copyOf > LevelChunk.getBlockEntityNbtForSaving 88, SerializableChunkData.copyOf > SerializableChunkData.packStructureData 67, SerializableChunkData.copyOf > DataLayer.copy 62, SerializableChunkData.copyOf > LevelChunk.getTicksForSerialization 43, SerializableChunkData.copyOf > LightEngine.getDataLayerData 26, SerializableChunkData.copyOf > ChunkAccess.getBlockEntitiesPos 19, SerializableChunkData.copyOf > ArrayList.add 11, SerializableChunkData.copyOf > ReferencePipeline.toArray 11, CompletableFuture.supplyAsync > CompletableFuture.asyncSupplyStage 10, SimpleRegionStorage.write > IOWorker.store 7, SerializableChunkData.copyOf > Collections$UnmodifiableCollection.iterator 3
- **SerializableChunkData.copyOf** 586: LevelChunkSection.copy 171, LevelChunk.getBlockEntityNbtForSaving 88, SerializableChunkData.packStructureData 67, DataLayer.copy 62, LevelChunk.getTicksForSerialization 43, LightEngine.getDataLayerData 26, ChunkAccess.getBlockEntitiesPos 19, ArrayList.add 11, ReferencePipeline.toArray 11, Collections$UnmodifiableCollection.iterator 3, SectionPos.of 3, Collections$UnmodifiableCollection$1.hasNext 3<br>two down: LevelChunkSection.copy > LevelChunkSection.<init> 159, LevelChunk.getBlockEntityNbtForSaving > BlockEntity.saveWithFullMetadata 86, SerializableChunkData.packStructureData > StructureStart.createTag 45, LevelChunk.getTicksForSerialization > LevelChunkTicks.pack 42, LightEngine.getDataLayerData > LayerLightSectionStorage.getDataLayerData 23, ArrayList.add > ArrayList.add 11, ReferencePipeline.toArray > AbstractPipeline.evaluateToArrayNode 10, ChunkAccess.getBlockEntitiesPos > Sets.newHashSet 9, ChunkAccess.getBlockEntitiesPos > AbstractCollection.addAll 5, SerializableChunkData.packStructureData > RegistryAccess.lookupOrThrow 5, Collections$UnmodifiableCollection.iterator > Collections$UnmodifiableCollection$1.<init> 3, SerializableChunkData.packStructureData > AbstractLongCollection.toLongArray 3
- **PersistentEntitySectionManager.autoSave** 57: AbstractLongCollection.forEach 49, PersistentEntitySectionManager.getAllChunksToSave 8<br>two down: AbstractLongCollection.forEach > LongIterable.forEach 49, PersistentEntitySectionManager.getAllChunksToSave > LongOpenHashSet.add 4, PersistentEntitySectionManager.getAllChunksToSave > EntitySectionStorage.getAllChunksWithExistingSections 2, PersistentEntitySectionManager.getAllChunksToSave > Long2ObjectOpenHashMap$FastEntryIterator.next 1
- **ChunkMap.processUnloads** 26: ChunkMap.saveChunksEagerly 18, ConcurrentLinkedQueue.size 2, LongOpenHashSet.iterator 2<br>two down: ChunkMap.saveChunksEagerly > Util.getMillis 4, ChunkMap.saveChunksEagerly > LongLinkedOpenHashSet.iterator 2, ConcurrentLinkedQueue.size > ConcurrentLinkedQueue.first 1
- **ChunkMap.saveChunksEagerly** 18: Util.getMillis 4, LongLinkedOpenHashSet.iterator 2<br>two down: Util.getMillis > Util.getNanos 4, LongLinkedOpenHashSet.iterator > LongLinkedOpenHashSet.iterator 2
- **SectionStorage.flush** 1: ChunkPos.pack 1<br>two down: 

</details>

Every save's content (each chunk tag serialised for saving, against the other vanilla rounds' saves of that chunk at the same game tick):

| round | side | chunks saved | saves | compared | at a tick vanilla's rounds differ | no vanilla save at that tick | chunks with a save none of vanilla's |
|---|---|---|---|---|---|---|---|
| 1 | vanilla | 625 | 2022 | 2022 | 0 | 0 | 0 |
| 1 | quicksilver | 625 | 2086 | 2086 | 0 | 0 | 0 |
| 2 | vanilla | 625 | 2123 | 1875 | 0 | 248 | 0 |
| 2 | quicksilver | 625 | 2033 | 2033 | 0 | 0 | 0 |
| 3 | vanilla | 625 | 2106 | 1875 | 0 | 231 | 0 |
| 3 | quicksilver | 625 | 2044 | 2044 | 0 | 0 | 0 |
| 4 | vanilla | 625 | 2161 | 1875 | 0 | 286 | 0 |
| 4 | quicksilver | 625 | 2088 | 2088 | 0 | 0 | 0 |
| 5 | vanilla | 625 | 2117 | 2022 | 0 | 95 | 0 |
| 5 | quicksilver | 625 | 2031 | 2031 | 0 | 0 | 0 |
| 6 | vanilla | 625 | 2040 | 1875 | 0 | 165 | 0 |
| 6 | quicksilver | 625 | 2056 | 2056 | 0 | 0 | 0 |
| 7 | vanilla | 625 | 2069 | 1875 | 0 | 194 | 0 |
| 7 | quicksilver | 625 | 2113 | 2113 | 0 | 0 | 0 |

Saved files against vanilla round 1 (every stored chunk; vanilla's rounds 2-7 are its noise):

| round | side | store | chunks | only one side | data differs (outside vanilla's noise) | same data, other bytes | keys that differ | header: place / time differs | not in the saved terrain |
|---|---|---|---|---|---|---|---|---|---|
| 1 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 1 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 1 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 460 / 625 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 2 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 2 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 447 / 625 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 2 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 2 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 452 / 625 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 3 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 5 / 9 | 0 |
| 3 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 466 / 625 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 3 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 3 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 488 / 625 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 4 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 4 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 455 / 625 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 4 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 7 / 9 | 0 |
| 4 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 439 / 625 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 16 | 2 |
| 5 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 4 / 9 | 0 |
| 5 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 444 / 625 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 5 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 5 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 443 / 625 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 6 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 6 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 443 / 625 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 1 (0) | 0 (0) | Entities 1 | 0 / 16 | 2 |
| 6 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 0 / 9 | 0 |
| 6 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 454 / 625 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 2 (0) | 0 (0) | DataVersion 2, Entities 2, Position 2 | 0 / 16 | 2 |
| 7 | vanilla | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 8 / 9 | 0 |
| 7 | vanilla | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 470 / 625 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/entities | 204 | 0 (0) | 3 (0) | 0 (0) | DataVersion 2, Entities 3, Position 2 | 0 / 16 | 2 |
| 7 | quicksilver | dimensions/minecraft/overworld/poi | 71 | 0 (0) | 0 (0) | 0 (0) | - | 6 / 9 | 0 |
| 7 | quicksilver | dimensions/minecraft/overworld/region | 9801 | 0 (0) | 0 (0) | 0 (0) | - | 487 / 625 | 0 |

Vanilla's noise (rounds 2-7 against 1): dimensions/minecraft/overworld/entities: 3 data, 0 bytes only, 0 one side, keys DataVersion 8, Entities 12, Position 8; dimensions/minecraft/overworld/poi: 0 data, 0 bytes only, 0 one side, keys -; dimensions/minecraft/overworld/region: 0 data, 0 bytes only, 0 one side, keys -

Verify run (full runs: chunks verify mode, every shared section checked against a real copy): finished; cow-sections=on, verify=on; saved files against vanilla round 1: entities: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), poi: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds), region: 0 data, 0 bytes only, 0 one side (outside vanilla's rounds)

## core / kill: a kill -9 mid-save (save-all flush of 625 changed chunks)

| run | killed mid-save | chunks: complete save's / its at another tick / saved terrain's / other / unreadable (region) | entities, poi: other / unreadable | reloaded |
|---|---|---|---|---|
| quicksilver-killed1 | yes | 9479 / 234 / 88 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| quicksilver-killed2 | yes | 9493 / 221 / 87 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed1 | yes | 9459 / 254 / 88 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
| vanilla-killed2 | yes | 9535 / 181 / 85 / 0 / 0 | entities 0 / 0; poi 0 / 0 | yes |
quicksilver-complete1 against vanilla's complete saves: entities 1 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0

quicksilver-complete2 against vanilla's complete saves: entities 0 / 0 / 0; poi 0 / 0 / 0; region 0 / 0 / 0


Each chunk of a killed save is either the complete save's (possibly written at another tick: it differs only in LastUpdate, block_ticks, fluid_ticks) or the saved terrain's: a kill loses the chunks not yet written, and breaks none. Entity and POI files are reported only (their data follows entity and POI timing, as in vanilla's own rounds).

## Failures

- core/save: saveAllMs, median per-round ratio to vanilla 1.014, not below 1.00
