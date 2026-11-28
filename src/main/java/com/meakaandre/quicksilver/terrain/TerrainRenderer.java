package com.meakaandre.quicksilver.terrain;

import com.meakaandre.quicksilver.bench.GpuCounters;
import com.meakaandre.quicksilver.occlusion.DepthPyramid;
import com.meakaandre.quicksilver.occlusion.GpuOcclusion;
import com.meakaandre.quicksilver.visibility.VisibilityStats;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.device.DeviceFeatures;
import com.mojang.renderpearl.api.device.DeviceInfo;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.renderpearl.api.pipeline.CompiledRenderPipeline;
import com.mojang.renderpearl.api.pipeline.IndexType;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import it.unimi.dsi.fastutil.longs.Long2LongOpenHashMap;
import net.minecraft.client.renderer.DynamicGpuData;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.chunk.CompiledSectionMesh;
import net.minecraft.client.renderer.chunk.SectionMesh;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.util.Util;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;

/**
 * Draws Quicksilver's terrain, through renderpearl only (both backends). Per frame:
 *
 * <ul>
 * <li>{@link #prepare}, on the render thread as vanilla starts preparing its own terrain draws (before the frame
 * graph runs, no render pass open): picks the sections vanilla found visible whose layers Quicksilver holds, builds one
 * draw list per layer, and writes the little that changed (a region's fade-in values).</li>
 * <li>{@link #draw}, inside vanilla's terrain pass right after vanilla draws its own part of each layer (solid, then
 * cutout, then translucent), with vanilla's uniforms and samplers already bound; with Improved Transparency on,
 * translucent is drawn in each of vanilla's three stage passes, with that stage's pipeline.</li>
 * </ul>
 *
 * <p>Translucent (package 3) is drawn in exactly vanilla's order: vanilla's visible-section list, reversed (back to
 * front) on frames where vanilla sorts translucent terrain (Improved Transparency off), each section with vanilla's
 * own sorted index list. Quicksilver's draw calls cover runs of consecutive sections in that order that share a
 * region (plain path) and arena, so batching never changes the order.
 *
 * How it draws follows what vanilla does on the device:
 * <ul>
 * <li>INDIRECT, on frames where vanilla draws terrain with multi-draw indirect (vanilla trusts the driver with it):
 * one indirect multi-draw per layer and arena; section data in the same instance stream and command upload as
 * vanilla's.</li>
 * <li>PLAIN, everywhere else (Intel integrated graphics, where vanilla distrusts multi-draw indirect; drivers without
 * it): one direct multi-draw per layer per region of 8x4x8 sections, section origins from a small uniform block per
 * region that is only rewritten when a section's fade-in value changes. OpenGL always has these multi-draws
 * (glMultiDrawElementsBaseVertex, core since 3.2); on Vulkan the interleaved kind (VK_EXT_multi_draw) is used when the
 * device has it; with neither, one draw per section and layer, as vanilla does.</li>
 * </ul>
 */
public final class TerrainRenderer {
    enum Path { PLAIN_SEPARATE, PLAIN_INTERLEAVED, PLAIN_SINGLE, INDIRECT }

    /** One region's sections in one arena, for one layer (plain path). */
    private static final class RegionDraw {
        final TerrainStore.Region region;
        /** The region's uniform block as of this frame (a worker may drop the region before the draw). */
        GpuBuffer ubo;
        int[] counts = new int[16];
        int[] bases = new int[16];
        int n;
        /** Section layers in this region's list (each may be several index ranges since package 4b). */
        int layers;

        RegionDraw(TerrainStore.Region region) {
            this.region = region;
        }

        void add(int count, int base) {
            if (n == counts.length) {
                counts = Arrays.copyOf(counts, n * 2);
                bases = Arrays.copyOf(bases, n * 2);
            }
            counts[n] = count;
            bases[n] = base;
            n++;
        }
    }

    /** Everything one layer draws from one arena. */
    private static final class ArenaDraws {
        final TerrainStore.Arena arena;
        final List<RegionDraw> regions = new ArrayList<>();
        final Map<TerrainStore.Region, RegionDraw> byRegion = new IdentityHashMap<>();
        final List<DynamicGpuData.IndexedDraw> commands = new ArrayList<>();
        /** Where this list's commands start in the frame's one Quicksilver command list. */
        int commandStart;
        /** Section layers in this list (each may be several index ranges since package 4b). */
        int sectionLayers;

        ArenaDraws(TerrainStore.Arena arena) {
            this.arena = arena;
        }
    }

    /** Consecutive translucent section layers (in vanilla's order) that one draw call covers. */
    private static final class TRun {
        final TerrainStore.Arena arena;
        final IndexType type;
        final TerrainStore.Region region;
        /** The region's uniform block as of this frame (plain path). */
        GpuBuffer ubo;
        int[] counts = new int[8];
        int[] bases = new int[8];
        /** Where each section layer's indices start in the arena, in bytes. */
        long[] offsets = new long[8];
        int n;
        final List<DynamicGpuData.IndexedDraw> commands = new ArrayList<>();
        int commandStart;
        /** CI's check only: the section layers this run draws, in order. */
        final List<CompiledSectionMesh> meshes = new ArrayList<>();
        final List<TerrainStore.Entry> entries = new ArrayList<>();

        TRun(TerrainStore.Arena arena, IndexType type, TerrainStore.Region region) {
            this.arena = arena;
            this.type = type;
            this.region = region;
        }

        boolean fits(TerrainStore.Arena arena, IndexType type, TerrainStore.Region region) {
            return this.arena == arena && this.type == type && this.region == region;
        }

        void add(int count, int base, long offset) {
            if (n == counts.length) {
                counts = Arrays.copyOf(counts, n * 2);
                bases = Arrays.copyOf(bases, n * 2);
                offsets = Arrays.copyOf(offsets, n * 2);
            }
            counts[n] = count;
            bases[n] = base;
            offsets[n] = offset;
            n++;
        }
    }

    // this frame
    private static Path path;
    /** Whether this frame leaves out facing groups that face away from the camera (package 4b). */
    private static boolean skipBackFaces;
    /** One layer's index ranges ({@link BackFaces#ranges}): quad counts and first quads; render thread only. */
    private static final int[] RANGE_COUNT = new int[CompactVertex.GROUPS], RANGE_FIRST = new int[CompactVertex.GROUPS];
    /** This frame's translucent draws, in vanilla's order, and whether vanilla sorts translucent this frame. */
    private static final List<TRun> TRUNS = new ArrayList<>();
    private static boolean sortTranslucent;
    // per frame, reused: translucent layers in vanilla's visible order, their meshes and instances
    private static final List<TerrainStore.Entry> TL_ENTRIES = new ArrayList<>();
    private static final List<CompiledSectionMesh> TL_MESHES = new ArrayList<>();
    private static final it.unimi.dsi.fastutil.ints.IntArrayList TL_INSTANCES = new it.unimi.dsi.fastutil.ints.IntArrayList();
    // visible sections whose translucent layer Quicksilver doesn't hold (vanilla may)
    private static final List<SectionRenderDispatcher.RenderSection> TL_OTHER = new ArrayList<>();
    /** Sections sent back to vanilla's mesher so Quicksilver takes their translucent layer over: node to that mesh's build time. */
    private static final Long2LongOpenHashMap HANDED_OVER = new Long2LongOpenHashMap();
    private static boolean prepared;
    @SuppressWarnings("unchecked")
    /** Draw lists, index layer (0 solid, 1 cutout). */
    private static final List<ArenaDraws>[] FRAME = new List[] {new ArrayList<ArenaDraws>(), new ArrayList<ArenaDraws>()};
    private static final List<DynamicGpuData.ChunkSectionInfo> INSTANCES = new ArrayList<>();
    private static GpuBufferSlice instanceSlice;
    /** This frame's one Quicksilver command list (indirect path), all layers and arenas back to back, and its slice. */
    private static final List<DynamicGpuData.IndexedDraw> COMMANDS = new ArrayList<>();
    private static GpuBufferSlice commandSlice;
    private static int vanillaCommandLists;
    private static int vanillaInstances;
    private static int maxIndexCount;
    private static Path lastPath;
    /** Set the first time the draw hook (a MixinExtras wrap, applied late) runs. */
    static volatile boolean drawHookSeen;

    // reused CPU-side arrays for direct multi-draws (render thread only)
    private static IntBuffer counts = MemoryUtil.memAllocInt(1024);
    private static IntBuffer bases = MemoryUtil.memAllocInt(1024);
    private static IntBuffer interleaved = MemoryUtil.memAllocInt(3 * 1024);
    private static PointerBuffer zeroOffsets = MemoryUtil.memCallocPointer(1024);
    private static PointerBuffer offsets = MemoryUtil.memCallocPointer(1024);
    private static ByteBuffer uboScratch;

    private TerrainRenderer() {
    }

    private static Path plainPath(DeviceInfo info) {
        DeviceFeatures f = info.features();
        if (f.multiDrawDirectSeparate()) return Path.PLAIN_SEPARATE;
        if (f.multiDrawDirectInterleaved() && info.limits().maxMultiDrawDirectInterleavedDrawCount() > 1) return Path.PLAIN_INTERLEAVED;
        return Path.PLAIN_SINGLE;
    }

    /** The camera position of the frame being extracted (render thread); see {@link BackFaces}. */
    public static void camera(double x, double y, double z) {
        BackFaces.camera(x, y, z);
        com.meakaandre.quicksilver.speed.Speed.camera(x, y, z);
        com.meakaandre.quicksilver.occlusion.GpuOcclusion.camera(x, y, z);
        com.meakaandre.quicksilver.far.FarTerrain.camera(x, y, z);
    }

    static String plainPathName() {
        try {
            return name(plainPath(RenderSystem.getDevice().getDeviceInfo()));
        } catch (Throwable t) {
            return "unknown";
        }
    }

    /** Package B: whether the last frame drew terrain on a plain path (one draw per region and layer); render thread. */
    static boolean plainPathInUse() {
        Path p = lastPath;
        if (p != null) return p != Path.INDIRECT;
        // before the first terrain frame (the world loading: most arenas are made then): what vanilla will choose, from
        // its own flag for drivers whose multi-draw indirect has known issues (Intel), or the debug switch
        if (Terrain.FORCE_PLAIN) return true;
        try {
            return RenderSystem.getDevice().getDeviceInfo().hintsAndWorkarounds().multiDrawIndirectHasKnownIssues();
        } catch (Throwable t) {
            return true;
        }
    }

    static String lastPathName() {
        Path p = lastPath;
        return p == null ? "none" : name(p);
    }

    private static String name(Path p) {
        return switch (p) {
            case PLAIN_SEPARATE -> "plain, one multi-draw per region and layer";
            case PLAIN_INTERLEAVED -> "plain, one interleaved multi-draw per region and layer";
            case PLAIN_SINGLE -> "plain, one draw per section and layer";
            case INDIRECT -> "indirect, one multi-draw per arena and layer";
        };
    }

    /**
     * Render thread, as vanilla starts preparing this frame's terrain draws. {@code indirect}: vanilla draws terrain
     * with multi-draw indirect this frame; {@code sort}: vanilla draws translucent back to front this frame (Improved
     * Transparency off).
     */
    public static void prepare(List<SectionRenderDispatcher.RenderSection> visible, double fadeSeconds, boolean indirect, boolean sort) {
        prepared = false;
        LATE.clear();
        CULLED.clear();
        GpuOcclusion.resetFrame();
        Terrain.beginFrame();
        // package 12: far terrain's parameters for this frame (nothing drawn unless Quicksilver's terrain draws)
        try {
            com.meakaandre.quicksilver.far.FarTerrain.frame(Terrain.drawing());
        } catch (Throwable t) {
            FarLayer.fail("preparing far terrain", t);
        }
        if (!Terrain.drawing()) return;
        // run-time fix (2026-11-26): an arena's grow ahead of need, before this frame's terrain draws
        try {
            TerrainStore.growAhead();
        } catch (Throwable t) {
            Terrain.fail("growing an arena", t, false);
        }
        // package 12b: the chunk columns real terrain draws this frame, for far terrain's holes (before its block is written)
        try {
            farColumns(visible);
        } catch (Throwable t) {
            FarLayer.fail("finding far terrain's holes", t);
        }
        // package 12: far terrain's tiles, copied in before this frame's draws (their own budget)
        com.meakaandre.quicksilver.bench.StageProfile.push("terrain.far-upload");
        try {
            FarLayer.upload();
        } catch (Throwable t) {
            FarLayer.fail("copying far terrain in", t);
        } finally {
            com.meakaandre.quicksilver.bench.StageProfile.pop("terrain.far-upload");
        }
        com.meakaandre.quicksilver.bench.StageProfile.push("terrain.prepare");
        try {
            sortTranslucent = sort;
            prepareFrame(visible, fadeSeconds, indirect && !Terrain.FORCE_PLAIN);
            prepared = true;
        } catch (Throwable t) {
            GpuOcclusion.abandonFrame();
            LATE.clear();
            CULLED.clear();
            Terrain.fail("preparing terrain draws", t, false);
        } finally {
            com.meakaandre.quicksilver.bench.StageProfile.pop();
        }
    }

    /**
     * Package 12b: while far terrain draws, the sections vanilla handed over that have geometry (held by Quicksilver or
     * by vanilla), whether or not occlusion culling then hides them (hidden: far terrain there would be hidden too). Far
     * terrain fills, inside the hand-over circle, what lies below the lowest of them in each chunk column.
     */
    private static final ChunkSectionLayer[] LAYERS = ChunkSectionLayer.values();

    private static void farColumns(List<SectionRenderDispatcher.RenderSection> visible) {
        if (!FarLayer.wantsColumns()) {
            FarLayer.clearColumns();
            return;
        }
        FarLayer.beginColumns();
        synchronized (TerrainStore.LOCK) {
            for (SectionRenderDispatcher.RenderSection section : visible) {
                SectionMesh mesh = section.getSectionMesh();
                boolean geometry = false;
                TerrainStore.Entry[] es = TerrainStore.ENTRIES.get(mesh);
                if (es != null) {
                    for (TerrainStore.Entry e : es) {
                        if (e != null) {
                            geometry = true;
                            break;
                        }
                    }
                }
                if (!geometry) {
                    for (ChunkSectionLayer layer : LAYERS) {
                        if (mesh.getSectionDraw(layer) != null) {
                            geometry = true;
                            break;
                        }
                    }
                }
                if (geometry) {
                    long node = section.getSectionNode();
                    FarLayer.covered(net.minecraft.core.SectionPos.x(node), net.minecraft.core.SectionPos.y(node), net.minecraft.core.SectionPos.z(node));
                }
            }
        }
        FarLayer.endColumns();
    }

    private static void prepareFrame(List<SectionRenderDispatcher.RenderSection> visible, double fadeSeconds, boolean indirect) {
        // after a resource reload the pipelines are compiled again here, before any render pass is open
        String broken = TerrainPipelines.compileAll();
        if (broken != null) throw new IllegalStateException(broken);
        GpuDevice device = RenderSystem.getDevice();
        // package 13: this frame's dynamic lights (lit pipelines and their block while any is near)
        TerrainLights.prepare(device, net.minecraft.client.Minecraft.getInstance().getDeltaTracker().getGameTimeDeltaPartialTick(false));
        path = indirect ? Path.INDIRECT : plainPath(device.getDeviceInfo());
        boolean plain = path != Path.INDIRECT;
        for (List<ArenaDraws> l : FRAME) l.clear();
        PENDING.clear();
        TRUNS.clear();
        TL_ENTRIES.clear();
        TL_MESHES.clear();
        TL_INSTANCES.clear();
        TL_OTHER.clear();
        INSTANCES.clear();
        instanceSlice = null;
        COMMANDS.clear();
        commandSlice = null;
        vanillaCommandLists = -1;
        maxIndexCount = 0;
        long now = Util.getMillis();
        long fadeMs = Util.toMillis(fadeSeconds);
        List<TerrainStore.Region> touched = new ArrayList<>();
        skipBackFaces = BackFaces.beginFrame(TerrainPipelines.pipeline(plain, false), TerrainPipelines.pipeline(plain, true));
        UploadBudget.frameVisible(visible);
        lastVisibleSections = visible.size();
        lastFogged = FOGGED.size();
        // package 2b: what occlusion culling does this frame (nothing when off)
        GpuOcclusion.beginFrame(visible, path == Path.INDIRECT, BackFaces.wireframe());
        boolean culling = GpuOcclusion.active();

        boolean audit = GpuCounters.enabled;
        int audited = 0;
        // package A: sections wholly inside the render-distance fog, and the cutout layer beyond the far-detail distance
        boolean speedCount = com.meakaandre.quicksilver.speed.Speed.counting;
        double fogEnd = com.meakaandre.quicksilver.speed.SpeedTerrain.fogEndThisFrame();
        double farCutout = com.meakaandre.quicksilver.speed.SpeedTerrain.farCutoutBlocks();
        FOGGED.clear();
        AUDIT_MESHES.clear();
        AUDIT_LAYERS.clear();
        synchronized (TerrainStore.LOCK) {
            TerrainStore.closePending();
            int unmeshed = 0;
            for (SectionRenderDispatcher.RenderSection section : visible) {
                SectionMesh mesh = section.getSectionMesh();
                if (UploadBudget.DEBUG_LOG && mesh == CompiledSectionMesh.UNCOMPILED) unmeshed++;
                TerrainStore.Entry[] es = TerrainStore.ENTRIES.get(mesh);
                if (audit) audited += audit(mesh, es);
                TerrainStore.Entry tl = es == null ? null : es[TerrainStore.TRANSLUCENT];
                if (tl == null && mesh.getSectionDraw(ChunkSectionLayer.TRANSLUCENT) != null) TL_OTHER.add(section);
                if (es == null) continue;
                TerrainStore.Entry any = es[0] != null ? es[0] : es[1] != null ? es[1] : es[2];
                if (any == null) continue;
                double nearXz = 0;
                if (fogEnd > 0 || farCutout > 0) {
                    nearXz = com.meakaandre.quicksilver.speed.SpeedTerrain.nearXz(any.originX, any.originZ);
                    if (speedCount) com.meakaandre.quicksilver.speed.Speed.SECTIONS_SEEN.increment();
                    if (fogEnd > 0 && fogBox(es, any) && com.meakaandre.quicksilver.speed.SpeedTerrain.inFogBelowEye(FOG_BOX, fogEnd)) {
                        if (speedCount) com.meakaandre.quicksilver.speed.Speed.SECTIONS_IN_FOG.increment();
                        FOGGED.add(section);
                        continue;
                    }
                }
                float visibility = section.getVisibility(now, fadeMs);
                int instance = INSTANCES.size();
                if (plain) {
                    TerrainStore.Region r = any.region;
                    if (!r.touched) {
                        r.touched = true;
                        touched.add(r);
                    }
                    r.pending[any.slot] = visibility;
                } else {
                    INSTANCES.add(new DynamicGpuData.ChunkSectionInfo(any.originX, any.originY, any.originZ, visibility));
                }
                // package 2b: solid and cutout drawn now, deferred to the late pass (two-phase) or proven hidden
                int decision = GpuOcclusion.DRAW;
                if (culling) decision = classify(section, es);
                if (decision != GpuOcclusion.DRAW) {
                    Late late = late(section.getSectionNode(), es, instance, farCutout > 0 && nearXz > farCutout);
                    if (late != null) (decision == GpuOcclusion.DEFER ? LATE : CULLED).add(late);
                }
                for (int li = 0; li < 2 && decision == GpuOcclusion.DRAW; li++) {
                    TerrainStore.Entry e = es[li];
                    if (e == null) continue;
                    if (li == 1 && farCutout > 0 && nearXz > farCutout) {
                        if (speedCount) com.meakaandre.quicksilver.speed.Speed.CUTOUT_SKIPPED.increment();
                        continue;
                    }
                    {
                        TerrainStore.Part part = e.part;
                        if (part == null) continue;
                        ArenaDraws ad = arenaDraws(li, part.arena);
                        int whole = part.indexCount();
                        maxIndexCount = Math.max(maxIndexCount, whole);
                        // the layer's quads as index ranges: the facing groups that may face the camera (package 4b)
                        // one span per section layer where each range would cost something: a draw call (one draw per
                        // section) or an indirect command uploaded every frame (20 bytes each; ranges there raised upload
                        // bytes per frame by about 20 KB in spawn, run 40619534606); on the plain multi-draw paths the
                        // ranges are CPU-side entries of the same call and cost nothing to upload
                        boolean span = path == Path.PLAIN_SINGLE || path == Path.INDIRECT;
                        int ranges = BackFaces.ranges(part, e, skipBackFaces, span, RANGE_COUNT, RANGE_FIRST);
                        if (speedCount) {
                            long quads = 0;
                            for (int r = 0; r < ranges; r++) quads += RANGE_COUNT[r];
                            com.meakaandre.quicksilver.speed.Speed.TERRAIN_TRIANGLES.add(quads * 2);
                        }
                        if (path == Path.INDIRECT) {
                            // decided after the loop, in this order: a few layers may get their full ranges (EXTRA_COMMANDS)
                            Pending pd = new Pending(ad, instance, part, whole, RANGE_COUNT[0], ranges == 0 ? 0 : RANGE_FIRST[0], ranges);
                            pd.multi = BackFaces.ranges(part, e, skipBackFaces, false, pd.count, pd.first);
                            PENDING.add(pd);
                            ad.sectionLayers++;
                            continue;
                        }
                        int drawn = 0;
                        RegionDraw rd = null;
                        if (plain) {
                            rd = ad.byRegion.get(e.region);
                            if (rd == null) {
                                rd = new RegionDraw(e.region);
                                ad.byRegion.put(e.region, rd);
                                ad.regions.add(rd);
                            }
                        }
                        for (int r = 0; r < ranges; r++) {
                            int count = RANGE_COUNT[r] * 6;
                            int base = part.baseVertex + RANGE_FIRST[r] * 4;
                            drawn += count;
                            if (plain) rd.add(count, base);
                            else ad.commands.add(new DynamicGpuData.IndexedDraw(count, 1, 0, base, instance));
                        }
                        ad.sectionLayers++;
                        if (rd != null) rd.layers++;
                        if (audit) TerrainStats.layerTriangles(drawn / 3, whole / 3, ranges);
                    }
                }
                if (tl != null && tl.index != null && mesh instanceof CompiledSectionMesh cm) {
                    if (audit && tl.part != null) TerrainStats.layerTriangles(tl.index.count / 3, tl.index.count / 3, 1);
                    if (speedCount) com.meakaandre.quicksilver.speed.Speed.TERRAIN_TRIANGLES.add(tl.index.count / 3);
                    TL_ENTRIES.add(tl);
                    TL_MESHES.add(cm);
                    TL_INSTANCES.add(instance);
                }
            }
            if (UploadBudget.DEBUG_LOG) UploadBudget.meshWait(unmeshed, visible.size(), FOGGED.size(), CULLED.size());
            if (!PENDING.isEmpty()) emitPending(audit);
            if (skipBackFaces) checkDrawLimits(device);
            buildTranslucentRuns(plain);
            if (TranslucencyCheck.ENABLED) {
                List<CompiledSectionMesh> drawnMeshes = new ArrayList<>(TL_MESHES.size());
                List<TerrainStore.Entry> drawn = new ArrayList<>(TL_ENTRIES.size());
                for (TRun run : TRUNS) {
                    drawnMeshes.addAll(run.meshes);
                    drawn.addAll(run.entries);
                }
                // package A: a section left out inside the fog is not drawn on purpose; the check sees the rest
                List<SectionRenderDispatcher.RenderSection> checked = visible;
                if (!FOGGED.isEmpty()) {
                    checked = new ArrayList<>(visible.size());
                    java.util.Set<SectionRenderDispatcher.RenderSection> out = java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());
                    out.addAll(FOGGED);
                    for (SectionRenderDispatcher.RenderSection sec : visible) if (!out.contains(sec)) checked.add(sec);
                }
                TranslucencyCheck.frame(checked, sortTranslucent, groupedTranslucent, drawnMeshes, drawn);
            }
            CommandEncoder encoder = null;
            for (TerrainStore.Region r : touched) {
                r.touched = false;
                encoder = writeRegion(device, encoder, r);
            }
            for (List<ArenaDraws> l : FRAME) for (ArenaDraws ad : l) for (RegionDraw rd : ad.regions) rd.ubo = rd.region.ubo;
            for (Late l : LATE) l.ubo = l.region.ubo;
            for (Late l : CULLED) l.ubo = l.region.ubo;
            for (TRun run : TRUNS) if (run.region != null) run.ubo = run.region.ubo;
        }
        if (maxIndexCount > 0) RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS).requestIndexCount(maxIndexCount);
        if (audit) VisibilityStats.terrainFrame(audited, missingFromVanilla());
        translucentOthers();
    }

    /**
     * Indirect path, package 4b: a section layer is one command (one span of its kept facing groups), except that up to
     * {@link #EXTRA_COMMANDS} more commands per frame go to the layers whose full ranges leave out the most quads per
     * extra command. Each command is 20 bytes uploaded every frame, so this caps what back-face skipping adds to the
     * frame's uploads at about 2.5 KB.
     */
    static final int EXTRA_COMMANDS = 128;

    private static final class Pending {
        final ArenaDraws ad;
        final int instance, whole, spanCount, spanFirst, spanRanges;
        final TerrainStore.Part part;
        final int[] count = new int[CompactVertex.GROUPS], first = new int[CompactVertex.GROUPS];
        int multi;
        boolean useMulti;

        Pending(ArenaDraws ad, int instance, TerrainStore.Part part, int whole, int spanCount, int spanFirst, int spanRanges) {
            this.ad = ad;
            this.instance = instance;
            this.part = part;
            this.whole = whole;
            this.spanCount = spanCount;
            this.spanFirst = spanFirst;
            this.spanRanges = spanRanges;
        }

        int multiQuads() {
            int q = 0;
            for (int r = 0; r < multi; r++) q += count[r];
            return q;
        }

        /** Quads the full ranges leave out beyond the span, per extra command. */
        double gain() {
            int extra = multi - Math.max(1, spanRanges);
            return extra <= 0 ? 0 : (double) ((spanRanges == 0 ? 0 : spanCount) - multiQuads()) / extra;
        }
    }

    private static final List<Pending> PENDING = new ArrayList<>();

    private static void emitPending(boolean audit) {
        int n = PENDING.size();
        Integer[] order = new Integer[n];
        double[] gain = new double[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
            gain[i] = PENDING.get(i).gain();
        }
        Arrays.sort(order, (a, b) -> Double.compare(gain[b], gain[a]));
        int left = EXTRA_COMMANDS;
        for (int i : order) {
            Pending pd = PENDING.get(i);
            int extra = pd.multi - Math.max(1, pd.spanRanges);
            if (gain[i] <= 0 || extra > left) continue;
            pd.useMulti = true;
            left -= extra;
        }
        // in the order the layers were listed
        for (Pending pd : PENDING) {
            int drawn = 0, ranges;
            if (pd.useMulti) {
                ranges = pd.multi;
                for (int r = 0; r < ranges; r++) {
                    pd.ad.commands.add(new DynamicGpuData.IndexedDraw(pd.count[r] * 6, 1, 0, pd.part.baseVertex + pd.first[r] * 4, pd.instance));
                    drawn += pd.count[r] * 6;
                }
            } else {
                ranges = pd.spanRanges;
                if (ranges > 0) {
                    pd.ad.commands.add(new DynamicGpuData.IndexedDraw(pd.spanCount * 6, 1, 0, pd.part.baseVertex + pd.spanFirst * 4, pd.instance));
                    drawn = pd.spanCount * 6;
                }
            }
            if (audit) TerrainStats.layerTriangles(drawn / 3, pd.whole / 3, ranges);
        }
        PENDING.clear();
    }

    /**
     * Package 4b: a list whose index ranges are more than the device takes in one multi-draw (and whose whole layers
     * would not be) would split into more draw calls; then facing groups are drawn whole from the next frame on.
     */
    private static void checkDrawLimits(GpuDevice device) {
        var limits = device.getDeviceInfo().limits();
        if (path == Path.INDIRECT) {
            int max = Math.max(1, limits.maxDrawIndirectDrawCount());
            for (List<ArenaDraws> l : FRAME) for (ArenaDraws ad : l) {
                if (ad.commands.size() > max && ad.sectionLayers <= max) BackFaces.drawLimitHit("indirect multi-draw limit " + max);
            }
        } else if (path == Path.PLAIN_INTERLEAVED) {
            int max = Math.max(1, limits.maxMultiDrawDirectInterleavedDrawCount());
            for (List<ArenaDraws> l : FRAME) for (ArenaDraws ad : l) for (RegionDraw rd : ad.regions) {
                if (rd.n > max && rd.layers <= max) BackFaces.drawLimitHit("interleaved multi-draw limit " + max);
            }
        }
    }

    /** Package B: whether this frame's translucent layers are drawn region by region ({@code approx.translucent-regions}). */
    private static boolean groupedTranslucent;
    private static final it.unimi.dsi.fastutil.ints.IntArrayList TL_ORDER = new it.unimi.dsi.fastutil.ints.IntArrayList();
    /**
     * Package B: translucent sections whose centre is within this many blocks of the camera are never grouped: they are
     * drawn last, in vanilla's order. Vanilla's translucent terrain writes depth, so near glass drawn early (with its
     * region, before a farther region's water) would hide that water behind it.
     */
    static final double NEAR_TRANSLUCENT = 64.0;

    /** Whether a section (origin in blocks) is near enough to keep vanilla's exact translucent order (render thread). */
    static boolean nearTranslucent(int ox, int oy, int oz) {
        double[] cam = BackFaces.frameCamera();
        if (cam == null) return true; // no camera: nothing is grouped
        double dx = ox + 8 - cam[0], dy = oy + 8 - cam[1], dz = oz + 8 - cam[2];
        return dx * dx + dy * dy + dz * dz <= NEAR_TRANSLUCENT * NEAR_TRANSLUCENT;
    }

    /**
     * Indices into TL_ENTRIES in draw order: vanilla's order (reversed when it sorts), or with
     * {@code approx.translucent-regions} on the plain path, the sections farther than {@link #NEAR_TRANSLUCENT} grouped by
     * region (stable: regions in the order vanilla's order first reaches them, each region's layers in vanilla's order),
     * then the near ones in vanilla's order.
     */
    static void translucentOrder(int n, boolean sorted, boolean grouped, java.util.function.IntFunction<Object> regionOf,
                                 java.util.function.IntPredicate near, it.unimi.dsi.fastutil.ints.IntArrayList out) {
        out.clear();
        if (!grouped) {
            for (int k = 0; k < n; k++) out.add(sorted ? n - 1 - k : k);
            return;
        }
        Map<Object, it.unimi.dsi.fastutil.ints.IntArrayList> byRegion = new java.util.LinkedHashMap<>();
        it.unimi.dsi.fastutil.ints.IntArrayList last = new it.unimi.dsi.fastutil.ints.IntArrayList();
        for (int k = 0; k < n; k++) {
            int i = sorted ? n - 1 - k : k;
            if (near.test(i)) {
                last.add(i);
            } else {
                byRegion.computeIfAbsent(new IdentityKey(regionOf.apply(i)), r -> new it.unimi.dsi.fastutil.ints.IntArrayList()).add(i);
            }
        }
        for (it.unimi.dsi.fastutil.ints.IntArrayList l : byRegion.values()) out.addAll(l);
        out.addAll(last);
    }

    /** Identity map key (LinkedHashMap keeps first-reached order; regions compare by identity). */
    private record IdentityKey(Object o) {
        @Override
        public boolean equals(Object other) {
            return other instanceof IdentityKey k && k.o == o;
        }

        @Override
        public int hashCode() {
            return System.identityHashCode(o);
        }
    }

    /**
     * This frame's translucent runs, in the order {@link #translucentOrder} gives: vanilla's order (the visible list as
     * is, or reversed when vanilla sorts), grouped by region on the plain path with {@code approx.translucent-regions}. A
     * run goes on while the next section layer shares its arena, index type and (plain path) region.
     */
    private static void buildTranslucentRuns(boolean plain) {
        int n = TL_ENTRIES.size();
        groupedTranslucent = plain && com.meakaandre.quicksilver.speed.Speed.TRANSLUCENT_REGIONS.on();
        translucentOrder(n, sortTranslucent, groupedTranslucent, i -> TL_ENTRIES.get(i).region,
            i -> nearTranslucent(TL_ENTRIES.get(i).originX, TL_ENTRIES.get(i).originY, TL_ENTRIES.get(i).originZ), TL_ORDER);
        TRun run = null;
        for (int k = 0; k < n; k++) {
            int i = TL_ORDER.getInt(k);
            TerrainStore.Entry e = TL_ENTRIES.get(i);
            TerrainStore.Part part = e.part;
            TerrainStore.IndexPart ip = e.index;
            if (part == null || ip.arena != part.arena) throw new IllegalStateException("a translucent layer's vertices and indices are not in one arena");
            TerrainStore.Region region = plain ? e.region : null;
            if (run == null || !run.fits(part.arena, ip.type, region)) {
                if (run != null) TranslucencyStats.runBreak(run.arena != part.arena, run.type != ip.type, run.region != region);
                run = new TRun(part.arena, ip.type, region);
                TRUNS.add(run);
            }
            run.add(ip.count, part.baseVertex, ip.offset());
            if (TranslucencyCheck.ENABLED) {
                run.meshes.add(TL_MESHES.get(i));
                run.entries.add(e);
            }
            if (!plain) {
                run.commands.add(new DynamicGpuData.IndexedDraw(ip.count, 1, (int) (ip.offset() / ip.type.bytes), part.baseVertex, TL_INSTANCES.getInt(i)));
            }
        }
    }

    /**
     * Visible sections with translucent geometry that Quicksilver doesn't hold: vanilla draws them (meshed before
     * Quicksilver turned on, or while it was handing terrain back). Vanilla draws its part of the layer before Quicksilver's,
     * so in a frame with both the order between the two sets would not be vanilla's: such a section is sent back to
     * vanilla's mesher once, so that its next mesh comes to Quicksilver. Counted in the bench (mixed frames).
     */
    private static void translucentOthers() {
        int vanillaHeld = 0, handed = 0;
        if (!TL_OTHER.isEmpty()) {
            SectionRenderDispatcher dispatcher = net.minecraft.client.Minecraft.getInstance().levelRenderer.sectionRenderDispatcher();
            if (dispatcher != null) {
                List<SectionRenderDispatcher.RenderSection> held = new ArrayList<>();
                dispatcher.lock();
                try {
                    for (SectionRenderDispatcher.RenderSection s : TL_OTHER) {
                        if (dispatcher.getRenderSectionSlice(s.getSectionMesh(), ChunkSectionLayer.TRANSLUCENT) != null) held.add(s);
                    }
                } finally {
                    dispatcher.unlock();
                }
                vanillaHeld = held.size();
                var extractor = net.minecraft.client.Minecraft.getInstance().levelExtractor;
                if (Terrain.takingTranslucent() && extractor != null) {
                    for (SectionRenderDispatcher.RenderSection s : held) {
                        long node = s.getSectionNode();
                        long built = s.getSectionMesh().getCompileTaskStartTime();
                        if (HANDED_OVER.containsKey(node) && HANDED_OVER.get(node) == built) continue;
                        HANDED_OVER.put(node, built);
                        extractor.setSectionDirty(net.minecraft.core.SectionPos.x(node), net.minecraft.core.SectionPos.y(node), net.minecraft.core.SectionPos.z(node));
                        handed++;
                    }
                }
            }
            TL_OTHER.clear();
        }
        if (HANDED_OVER.size() > 65536) HANDED_OVER.clear();
        TranslucencyStats.frame(TL_ENTRIES.size(), vanillaHeld, handed);
    }

    // pop-in audit (only while a bench measures): solid, cutout and translucent layers of vanilla's visible sections
    // that have geometry must be drawn by Quicksilver (in this frame's draw lists) or by vanilla (in its buffers)
    private static final List<SectionMesh> AUDIT_MESHES = new ArrayList<>();
    private static final List<ChunkSectionLayer> AUDIT_LAYERS = new ArrayList<>();
    private static final ChunkSectionLayer[] AUDIT_LAYER_ORDER = {ChunkSectionLayer.SOLID, ChunkSectionLayer.CUTOUT, ChunkSectionLayer.TRANSLUCENT};

    /** Counts this section's layers with geometry; remembers those Quicksilver doesn't hold, for vanilla's check. */
    private static int audit(SectionMesh mesh, TerrainStore.Entry[] es) {
        int n = 0;
        for (int li = 0; li < TerrainStore.LAYERS; li++) {
            if (mesh.getSectionDraw(AUDIT_LAYER_ORDER[li]) == null) continue;
            n++;
            TerrainStore.Entry e = es == null ? null : es[li];
            if (e == null || e.part == null || (li == TerrainStore.TRANSLUCENT && e.index == null)) {
                AUDIT_MESHES.add(mesh);
                AUDIT_LAYERS.add(AUDIT_LAYER_ORDER[li]);
            }
        }
        return n;
    }

    /** Of the layers Quicksilver doesn't hold, those vanilla's buffers don't hold either (under vanilla's own lock). */
    private static int missingFromVanilla() {
        if (AUDIT_MESHES.isEmpty()) return 0;
        SectionRenderDispatcher dispatcher = net.minecraft.client.Minecraft.getInstance().levelRenderer.sectionRenderDispatcher();
        if (dispatcher == null) return AUDIT_MESHES.size();
        int missing = 0;
        dispatcher.lock();
        try {
            for (int i = 0; i < AUDIT_MESHES.size(); i++) {
                if (dispatcher.getRenderSectionSlice(AUDIT_MESHES.get(i), AUDIT_LAYERS.get(i)) == null) missing++;
            }
        } finally {
            dispatcher.unlock();
        }
        AUDIT_MESHES.clear();
        AUDIT_LAYERS.clear();
        return missing;
    }

    private static ArenaDraws arenaDraws(int list, TerrainStore.Arena arena) {
        for (ArenaDraws ad : FRAME[list]) if (ad.arena == arena) return ad;
        ArenaDraws ad = new ArenaDraws(arena);
        FRAME[list].add(ad);
        return ad;
    }

    /** Writes a region's uniform block if it is new or a section's fade-in value changed; clears what was pending. */
    private static CommandEncoder writeRegion(GpuDevice device, CommandEncoder encoder, TerrainStore.Region r) {
        boolean changed = r.ubo == null;
        if (r.ubo == null) {
            r.ubo = device.createBuffer(() -> "Quicksilver terrain region", GpuBuffer.USAGE_UNIFORM | GpuBuffer.USAGE_COPY_DST,
                TerrainPipelines.REGION_UBO_BYTES);
        }
        for (int i = 0; i < 256 && !changed; i++) {
            float v = r.pending[i];
            if (!Float.isNaN(v) && Float.compare(v, r.written[i]) != 0) changed = true;
        }
        if (changed) {
            if (uboScratch == null) uboScratch = MemoryUtil.memAlloc(TerrainPipelines.REGION_UBO_BYTES);
            ByteBuffer b = uboScratch;
            b.clear();
            b.putInt(0, r.originX).putInt(4, r.originY).putInt(8, r.originZ).putInt(12, 0);
            for (int i = 0; i < 256; i++) {
                float v = r.pending[i];
                if (Float.isNaN(v)) v = Float.isNaN(r.written[i]) ? 1f : r.written[i];
                r.written[i] = v;
                b.putFloat(16 + i * 4, v);
            }
            if (encoder == null) encoder = device.createCommandEncoder();
            encoder.writeToBuffer(r.ubo.slice(), b.position(0).limit(TerrainPipelines.REGION_UBO_BYTES));
        }
        Arrays.fill(r.pending, Float.NaN);
        return encoder;
    }

    /**
     * Vanilla, preparing multi-draw indirect, writes its indirect commands: Quicksilver's lists go into the same upload.
     * Quicksilver's sections will follow vanilla's in the instance stream, so their base instances move past vanilla's
     * (every vanilla section has at least one draw, so the highest base instance tells how many there are).
     */
    public static List<List<DynamicGpuData.IndexedDraw>> withCommands(List<List<DynamicGpuData.IndexedDraw>> vanilla) {
        if (!prepared || path != Path.INDIRECT) return vanilla;
        try {
            return addCommands(vanilla);
        } catch (Throwable t) {
            prepared = false;
            Terrain.fail("preparing indirect terrain draws", t, false);
            return vanilla;
        }
    }

    private static List<List<DynamicGpuData.IndexedDraw>> addCommands(List<List<DynamicGpuData.IndexedDraw>> vanilla) {
        int shift = 0;
        for (List<DynamicGpuData.IndexedDraw> l : vanilla) for (DynamicGpuData.IndexedDraw d : l) shift = Math.max(shift, d.baseInstance() + 1);
        vanillaInstances = shift;
        vanillaCommandLists = vanilla.size();
        // one list for all of Quicksilver's draws this frame (one slice, no per-list padding); each layer and arena
        // draws its own range of it
        COMMANDS.clear();
        for (List<ArenaDraws> l : FRAME) {
            for (ArenaDraws ad : l) {
                ad.commandStart = COMMANDS.size();
                for (DynamicGpuData.IndexedDraw d : ad.commands) {
                    COMMANDS.add(shift == 0 ? d : new DynamicGpuData.IndexedDraw(d.indexCount(), 1, 0, d.baseVertex(), d.baseInstance() + shift));
                }
            }
        }
        for (TRun run : TRUNS) {
            run.commandStart = COMMANDS.size();
            for (DynamicGpuData.IndexedDraw d : run.commands) {
                COMMANDS.add(shift == 0 ? d : new DynamicGpuData.IndexedDraw(d.indexCount(), 1, d.firstIndex(), d.baseVertex(), d.baseInstance() + shift));
            }
        }
        if (COMMANDS.isEmpty()) return vanilla;
        List<List<DynamicGpuData.IndexedDraw>> all = new ArrayList<>(vanilla.size() + 1);
        all.addAll(vanilla);
        all.add(COMMANDS);
        return all;
    }

    /** Takes the slice of Quicksilver's command list; hands vanilla back the slices of its own. */
    public static GpuBufferSlice[] commandsWritten(GpuBufferSlice[] all, int vanillaLists) {
        noteCommandUsage(all);
        if (!prepared || path != Path.INDIRECT || vanillaCommandLists != vanillaLists || all.length != vanillaLists + 1) return all;
        commandSlice = all[vanillaLists];
        return Arrays.copyOf(all, vanillaLists);
    }

    /** Vanilla writes its section instance data: Quicksilver's goes into the same upload, after vanilla's. */
    public static List<DynamicGpuData.ChunkSectionInfo> withInstances(List<DynamicGpuData.ChunkSectionInfo> vanilla) {
        if (!prepared || path != Path.INDIRECT || INSTANCES.isEmpty()) return vanilla;
        if (vanillaCommandLists < 0 || vanilla.size() != vanillaInstances) {
            prepared = false;
            Terrain.fail("preparing indirect terrain draws", new IllegalStateException(
                "vanilla wrote " + vanilla.size() + " section instances, its commands use " + vanillaInstances), false);
            return vanilla;
        }
        List<DynamicGpuData.ChunkSectionInfo> all = new ArrayList<>(vanilla.size() + INSTANCES.size());
        all.addAll(vanilla);
        all.addAll(INSTANCES);
        return all;
    }

    /** Vanilla's indirect command slices: their buffer's usage is what package 2b's late command buffer needs. */
    private static void noteCommandUsage(GpuBufferSlice[] slices) {
        if (indirectUsage != 0 || slices == null) return;
        for (GpuBufferSlice sl : slices) {
            if (sl != null) {
                indirectUsage = sl.buffer().usage();
                return;
            }
        }
    }

    public static void instancesWritten(GpuBufferSlice slice) {
        if (prepared && path == Path.INDIRECT) instanceSlice = slice;
    }

    /**
     * Render thread, in vanilla's terrain pass right after vanilla drew its own part of {@code layer}. Vanilla has
     * bound the terrain uniforms, the block atlas and the lightmap.
     */
    public static void draw(ChunkSectionLayer layer, RenderPass pass, RenderPipeline override, RenderPipeline overrideMultidraw) {
        drawHookSeen = true;
        if (!prepared || !Terrain.drawing()) return;
        int li = TerrainStore.layerIndex(layer);
        if (li < 0) return;
        if (li == TerrainStore.TRANSLUCENT) {
            drawTranslucent(pass, override, overrideMultidraw);
            return;
        }
        boolean wireframe = override != null || overrideMultidraw != null;
        // package 4b: the wireframe view draws back faces' edges too, so the next frames draw every facing group
        if (li == 0) BackFaces.wireframeFrame(wireframe);
        if (FRAME[li].isEmpty()) {
            if (li == 0 && !wireframe) drawFar(pass);
            return;
        }
        try {
            TerrainGpuErrors.Mark mark = TerrainGpuErrors.mark();
            boolean plain = path != Path.INDIRECT;
            RenderSystem.AutoStorageIndexBuffer quads = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
            GpuBuffer indexBuffer = quads.getBuffer();
            if (indexBuffer == null || !quads.hasStorage(maxIndexCount)) throw new IllegalStateException("the shared quad index buffer is too small");
            int draws = 0, sectionLayers = 0;
            {
                List<ArenaDraws> list = FRAME[li];
                CompiledRenderPipeline pipeline;
                boolean lit = !wireframe && TerrainLights.on();
                if (wireframe) {
                    pipeline = TerrainPipelines.wireframe(plain);
                } else {
                    pipeline = TerrainPipelines.compiled(TerrainPipelines.pipeline(plain, li == 1, lit));
                }
                if (pipeline == null) return;
                pass.setPipeline(pipeline);
                if (lit) TerrainLights.bind(pass);
                pass.setIndexBuffer(indexBuffer, quads.type());
                draws += plain ? drawPlain(pass, list) : drawIndirect(pass, list);
                for (ArenaDraws ad : list) sectionLayers += ad.sectionLayers;
            }
            lastPath = path;
            TerrainStats.drew(draws, sectionLayers);
            String err = TerrainGpuErrors.since(mark);
            if (err != null) {
                prepared = false;
                Terrain.fail("drawing terrain", new IllegalStateException("GPU error: " + err), false);
            }
        } catch (Throwable t) {
            prepared = false;
            Terrain.fail("drawing terrain", t, false);
        }
        if (li == 0 && !wireframe) drawFar(pass);
    }

    /** Package 12: far terrain, right after the solid layer (real terrain's depth already there), in the same pass. */
    private static void drawFar(RenderPass pass) {
        try {
            TerrainGpuErrors.Mark mark = TerrainGpuErrors.mark();
            // package 12c: far terrain's own stage in the speed bench's profile (inside terrain.solid)
            com.meakaandre.quicksilver.bench.StageProfile.push("terrain.far");
            try {
                FarLayer.draw(pass);
            } finally {
                com.meakaandre.quicksilver.bench.StageProfile.pop("terrain.far");
            }
            String err = TerrainGpuErrors.since(mark);
            if (err != null) FarLayer.fail("drawing far terrain", new IllegalStateException("GPU error: " + err));
        } catch (Throwable t) {
            FarLayer.fail("drawing far terrain", t);
        }
    }

    /**
     * Translucent, right after vanilla's own part of it (in the classic pass, or in one of the Improved Transparency
     * stage passes): Quicksilver's runs in order, each with the pipeline made from the one vanilla draws this mode with.
     */
    private static void drawTranslucent(RenderPass pass, RenderPipeline override, RenderPipeline overrideMultidraw) {
        int mode = TerrainPipelines.translucentMode(override, overrideMultidraw);
        if (mode >= 1) TranslucencyStats.oitFrame();
        if (TRUNS.isEmpty()) return;
        try {
            if (mode == -2) throw new IllegalStateException("vanilla drew translucent terrain with a pipeline Quicksilver does not know: " + override + ", " + overrideMultidraw);
            TerrainGpuErrors.Mark mark = TerrainGpuErrors.mark();
            boolean plain = path != Path.INDIRECT;
            if (!plain) {
                if (vanillaCommandLists < 0) throw new IllegalStateException("hook that did not apply: LevelRenderer#quicksilver$commands");
                if (instanceSlice == null) throw new IllegalStateException("hook that did not apply: LevelRenderer#quicksilver$instances");
                if (commandSlice == null) throw new IllegalStateException("no indirect commands this frame");
                pass.setVertexBuffer(1, instanceSlice);
            }
            int maxInterleaved = path == Path.PLAIN_INTERLEAVED
                ? RenderSystem.getDevice().getDeviceInfo().limits().maxMultiDrawDirectInterleavedDrawCount() : 0;
            int maxIndirect = Math.max(1, RenderSystem.getDevice().getDeviceInfo().limits().maxDrawIndirectDrawCount());
            CompiledRenderPipeline current = null;
            int draws = 0, sectionLayers = 0;
            boolean tlit;
            for (TRun run : TRUNS) {
                CompiledRenderPipeline pipeline;
                if (mode == -1) {
                    pipeline = TerrainPipelines.wireframe(plain);
                    if (pipeline == null) continue;
                    tlit = false;
                } else {
                    RenderPipeline p = TerrainLights.on() ? TerrainPipelines.translucentLit(mode, plain) : null;
                    tlit = p != null;
                    if (p == null) p = TerrainPipelines.translucent(mode, plain);
                    if (p == null) throw new IllegalStateException("no translucent pipeline");
                    pipeline = TerrainPipelines.compiled(p);
                }
                if (pipeline != current) {
                    pass.setPipeline(pipeline);
                    current = pipeline;
                    if (tlit) TerrainLights.bind(pass);
                }
                pass.setVertexBuffer(0, run.arena.buffer.slice());
                pass.setIndexBuffer(run.arena.buffer, run.type);
                int n = run.n;
                sectionLayers += n;
                if (!plain) {
                    GpuBuffer buffer = commandSlice.buffer();
                    long base = commandSlice.offset() + (long) run.commandStart * RenderPass.INDIRECT_INDEXED_DRAW_SIZE;
                    for (int done = 0; done < n; ) {
                        int m = Math.min(maxIndirect, n - done);
                        pass.drawIndexedIndirect(buffer.slice(base + (long) done * RenderPass.INDIRECT_INDEXED_DRAW_SIZE,
                            (long) m * RenderPass.INDIRECT_INDEXED_DRAW_SIZE), m);
                        done += m;
                        draws++;
                    }
                    continue;
                }
                pass.setUniform("QsRegion", run.ubo);
                switch (path) {
                    case PLAIN_SEPARATE -> {
                        ensureCapacity(n);
                        counts.clear().put(run.counts, 0, n).flip();
                        bases.clear().put(run.bases, 0, n).flip();
                        offsets.clear();
                        for (int i = 0; i < n; i++) offsets.put(run.offsets[i]);
                        offsets.flip();
                        pass.multiDrawIndexed(offsets, counts, bases, n);
                        draws++;
                    }
                    case PLAIN_INTERLEAVED -> {
                        for (int done = 0; done < n; ) {
                            int m = Math.min(n - done, maxInterleaved);
                            ensureCapacity(m);
                            interleaved.clear();
                            for (int i = done; i < done + m; i++) {
                                interleaved.put((int) (run.offsets[i] / run.type.bytes)).put(run.counts[i]).put(run.bases[i]);
                            }
                            interleaved.flip();
                            pass.multiDrawIndexed(interleaved, 1, 0, m);
                            done += m;
                            draws++;
                        }
                    }
                    default -> {
                        for (int i = 0; i < n; i++) {
                            pass.drawIndexed(run.counts[i], 1, (int) (run.offsets[i] / run.type.bytes), run.bases[i], 0);
                            draws++;
                        }
                    }
                }
            }
            lastPath = path;
            TerrainStats.drew(draws, sectionLayers);
            TranslucencyStats.drew(draws);
            String err = TerrainGpuErrors.since(mark);
            if (err != null) {
                prepared = false;
                Terrain.fail("drawing translucent terrain", new IllegalStateException("GPU error: " + err), false);
            }
        } catch (Throwable t) {
            prepared = false;
            Terrain.fail("drawing translucent terrain", t, false);
        }
    }

    private static int drawPlain(RenderPass pass, List<ArenaDraws> list) {
        int draws = 0;
        int maxInterleaved = path == Path.PLAIN_INTERLEAVED
            ? RenderSystem.getDevice().getDeviceInfo().limits().maxMultiDrawDirectInterleavedDrawCount() : 0;
        for (ArenaDraws ad : list) {
            pass.setVertexBuffer(0, ad.arena.buffer.slice());
            for (RegionDraw rd : ad.regions) {
                int n = rd.n;
                if (n == 0) continue;
                pass.setUniform("QsRegion", rd.ubo);
                switch (path) {
                    case PLAIN_SEPARATE -> {
                        ensureCapacity(n);
                        counts.clear().put(rd.counts, 0, n).flip();
                        bases.clear().put(rd.bases, 0, n).flip();
                        zeroOffsets.clear().limit(n);
                        pass.multiDrawIndexed(zeroOffsets, counts, bases, n);
                        draws++;
                    }
                    case PLAIN_INTERLEAVED -> {
                        for (int done = 0; done < n; ) {
                            int m = Math.min(n - done, maxInterleaved);
                            ensureCapacity(m);
                            interleaved.clear();
                            for (int i = done; i < done + m; i++) interleaved.put(0).put(rd.counts[i]).put(rd.bases[i]);
                            interleaved.flip();
                            pass.multiDrawIndexed(interleaved, 1, 0, m);
                            done += m;
                            draws++;
                        }
                    }
                    default -> {
                        for (int i = 0; i < n; i++) {
                            pass.drawIndexed(rd.counts[i], 1, 0, rd.bases[i], 0);
                            draws++;
                        }
                    }
                }
            }
        }
        return draws;
    }

    private static int drawIndirect(RenderPass pass, List<ArenaDraws> list) {
        if (vanillaCommandLists < 0) throw new IllegalStateException("hook that did not apply: LevelRenderer#quicksilver$commands");
        if (instanceSlice == null) throw new IllegalStateException("hook that did not apply: LevelRenderer#quicksilver$instances");
        int draws = 0;
        pass.setVertexBuffer(1, instanceSlice);
        int max = Math.max(1, RenderSystem.getDevice().getDeviceInfo().limits().maxDrawIndirectDrawCount());
        for (ArenaDraws ad : list) {
            int count = ad.commands.size();
            if (count == 0) continue;
            if (commandSlice == null) throw new IllegalStateException("no indirect commands this frame");
            pass.setVertexBuffer(0, ad.arena.buffer.slice());
            GpuBuffer buffer = commandSlice.buffer();
            long offset = commandSlice.offset() + (long) ad.commandStart * RenderPass.INDIRECT_INDEXED_DRAW_SIZE;
            for (int done = 0; done < count; ) {
                int n = Math.min(max, count - done);
                pass.drawIndexedIndirect(buffer.slice(offset + (long) done * RenderPass.INDIRECT_INDEXED_DRAW_SIZE,
                    (long) n * RenderPass.INDIRECT_INDEXED_DRAW_SIZE), n);
                done += n;
                draws++;
            }
        }
        return draws;
    }

    // ---------------------------------------------------------------- package 2b: occlusion culling

    /** A section whose solid and cutout layers were not drawn in the first part of the frame: its prepared draws. */
    private static final class Late {
        final long key;
        final double x0, y0, z0, x1, y1, z1;
        final int instance;
        final TerrainStore.Region region;
        GpuBuffer ubo;
        final TerrainStore.Arena[] arena = new TerrainStore.Arena[2];
        final int[][] count = new int[2][], base = new int[2][];
        final int[] n = new int[2], whole = new int[2];

        Late(long key, double[] b, int instance, TerrainStore.Region region) {
            this.key = key;
            x0 = b[0];
            y0 = b[1];
            z0 = b[2];
            x1 = b[3];
            y1 = b[4];
            z1 = b[5];
            this.instance = instance;
            this.region = region;
        }
    }

    /** This frame: sections deferred to the late pass (two-phase), and sections proven hidden (not drawn). */
    private static final List<Late> LATE = new ArrayList<>(), CULLED = new ArrayList<>();
    /** Package A: sections left out this frame because they are wholly inside the fog. */
    private static final List<SectionRenderDispatcher.RenderSection> FOGGED = new ArrayList<>();
    /** Package 12 diagnostics (far terrain's status line): sections vanilla handed over, and those fog-sections left out, the frame before. */
    private static int lastVisibleSections, lastFogged;

    public static String sectionCounts() {
        return "real sections handed over " + lastVisibleSections + ", left out in fog " + lastFogged;
    }
    /** The late pass's draw lists (solid, cutout). */
    @SuppressWarnings("unchecked")
    private static final List<ArenaDraws>[] FRAME2 = new List[] {new ArrayList<ArenaDraws>(), new ArrayList<ArenaDraws>()};
    /** Usage bits of vanilla's indirect command buffer; the late pass's commands go into a buffer of the same kind. */
    private static int indirectUsage;
    private static GpuBuffer lateCommands;
    private static final List<GpuBuffer> RETIRED = new ArrayList<>();
    private static int retireIn;
    private static ByteBuffer lateScratch;
    private static boolean lateIndirect;

    private static final double[] BOX = new double[6];
    private static final double[] FOG_BOX = new double[6];

    /**
     * Package A: the box the fog test uses, in FOG_BOX: the solid and cutout vertices' recorded bounds, grown to the block
     * box plus {@code SpeedTerrain.TRANSLUCENT_MARGIN} when the section has translucent geometry; false if not known.
     */
    private static boolean fogBox(TerrainStore.Entry[] es, TerrainStore.Entry any) {
        boolean solid = es[0] != null && es[0].part != null || es[1] != null && es[1].part != null;
        if (solid && !box(es, FOG_BOX)) return false;
        if (es[2] != null) {
            double m = com.meakaandre.quicksilver.speed.SpeedTerrain.TRANSLUCENT_MARGIN;
            double ax = any.originX - m, ay = any.originY - m, az = any.originZ - m, bx = any.originX + 16 + m, by = any.originY + 16 + m,
                bz = any.originZ + 16 + m;
            if (solid) {
                FOG_BOX[0] = Math.min(FOG_BOX[0], ax);
                FOG_BOX[1] = Math.min(FOG_BOX[1], ay);
                FOG_BOX[2] = Math.min(FOG_BOX[2], az);
                FOG_BOX[3] = Math.max(FOG_BOX[3], bx);
                FOG_BOX[4] = Math.max(FOG_BOX[4], by);
                FOG_BOX[5] = Math.max(FOG_BOX[5], bz);
            } else {
                FOG_BOX[0] = ax;
                FOG_BOX[1] = ay;
                FOG_BOX[2] = az;
                FOG_BOX[3] = bx;
                FOG_BOX[4] = by;
                FOG_BOX[5] = bz;
            }
            return true;
        }
        return solid;
    }

    /** The box of a section's solid and cutout geometry (world coordinates); false if it has none. */
    private static boolean box(TerrainStore.Entry[] es, double[] out) {
        boolean any = false;
        double ax = Double.POSITIVE_INFINITY, ay = ax, az = ax, bx = Double.NEGATIVE_INFINITY, by = bx, bz = bx;
        for (int li = 0; li < 2; li++) {
            TerrainStore.Entry e = es[li];
            if (e == null || e.part == null) continue;
            if (!(e.minX <= e.maxX)) return false; // bounds unknown: never culled
            any = true;
            ax = Math.min(ax, e.originX + e.minX);
            ay = Math.min(ay, e.originY + e.minY);
            az = Math.min(az, e.originZ + e.minZ);
            bx = Math.max(bx, e.originX + e.maxX);
            by = Math.max(by, e.originY + e.maxY);
            bz = Math.max(bz, e.originZ + e.maxZ);
        }
        if (!any) return false;
        out[0] = ax;
        out[1] = ay;
        out[2] = az;
        out[3] = bx;
        out[4] = by;
        out[5] = bz;
        return true;
    }

    private static int classify(SectionRenderDispatcher.RenderSection section, TerrainStore.Entry[] es) {
        if (!box(es, BOX)) return GpuOcclusion.DRAW;
        return GpuOcclusion.classify(section.getSectionNode(), BOX[0], BOX[1], BOX[2], BOX[3], BOX[4], BOX[5]);
    }

    /** The prepared solid and cutout draws of a section left out of the first part of the frame. */
    private static Late late(long key, TerrainStore.Entry[] es, int instance, boolean noCutout) {
        if (!box(es, BOX)) return null;
        TerrainStore.Entry any = es[0] != null ? es[0] : es[1];
        Late l = new Late(key, BOX, instance, any.region);
        boolean span = path == Path.PLAIN_SINGLE || path == Path.INDIRECT;
        for (int li = 0; li < 2; li++) {
            TerrainStore.Entry e = es[li];
            if (e == null || e.part == null) continue;
            // package A, option far-detail: the late pass leaves the cutout layer out past the distance too
            if (li == 1 && noCutout) continue;
            TerrainStore.Part part = e.part;
            maxIndexCount = Math.max(maxIndexCount, part.indexCount());
            int ranges = BackFaces.ranges(part, e, skipBackFaces, span, RANGE_COUNT, RANGE_FIRST);
            if (com.meakaandre.quicksilver.speed.Speed.counting) {
                long quads = 0;
                for (int r = 0; r < ranges; r++) quads += RANGE_COUNT[r];
                com.meakaandre.quicksilver.speed.Speed.TERRAIN_TRIANGLES.add(quads * 2);
            }
            l.arena[li] = part.arena;
            l.count[li] = new int[ranges];
            l.base[li] = new int[ranges];
            l.n[li] = ranges;
            l.whole[li] = part.indexCount();
            for (int r = 0; r < ranges; r++) {
                l.count[li][r] = RANGE_COUNT[r] * 6;
                l.base[li][r] = part.baseVertex + RANGE_FIRST[r] * 4;
            }
        }
        return l;
    }

    public static int candidateCount() {
        return LATE.size();
    }

    public static int culledCount() {
        return CULLED.size();
    }

    /** Tests the deferred sections against a fresh pyramid: the bits of those to draw; the rest join the culled list. */
    public static BitSet testCandidates(DepthPyramid p) {
        BitSet visible = new BitSet(LATE.size());
        for (int i = 0; i < LATE.size(); i++) {
            Late l = LATE.get(i);
            if (p.test(l.x0, l.y0, l.z0, l.x1, l.y1, l.z1) == DepthPyramid.Result.VISIBLE) visible.set(i);
            else CULLED.add(l);
        }
        GpuOcclusion.lateResult(visible.cardinality(), LATE.size() - visible.cardinality());
        return visible;
    }

    /**
     * Builds the late pass's draw lists from the deferred sections in {@code visible} and, on the indirect path, writes
     * their commands into Quicksilver's own command buffer. No render pass may be open.
     */
    public static void preparePhase2(BitSet visible, CommandEncoder encoder) {
        lateVisible = visible;
        for (List<ArenaDraws> l : FRAME2) l.clear();
        boolean plain = path != Path.INDIRECT;
        lateIndirect = !plain && indirectUsage != 0 && instanceSlice != null && vanillaCommandLists >= 0;
        boolean audit = GpuCounters.enabled;
        for (int i = visible.nextSetBit(0); i >= 0; i = visible.nextSetBit(i + 1)) {
            Late l = LATE.get(i);
            GpuOcclusion.drawnLate(l.key);
            for (int li = 0; li < 2; li++) {
                if (l.arena[li] == null) continue;
                ArenaDraws ad = null;
                for (ArenaDraws a : FRAME2[li]) if (a.arena == l.arena[li]) ad = a;
                if (ad == null) {
                    ad = new ArenaDraws(l.arena[li]);
                    FRAME2[li].add(ad);
                }
                int drawn = 0;
                RegionDraw rd = null;
                if (plain) {
                    rd = ad.byRegion.get(l.region);
                    if (rd == null) {
                        rd = new RegionDraw(l.region);
                        rd.ubo = l.ubo;
                        ad.byRegion.put(l.region, rd);
                        ad.regions.add(rd);
                    }
                }
                for (int r = 0; r < l.n[li]; r++) {
                    drawn += l.count[li][r];
                    if (plain) rd.add(l.count[li][r], l.base[li][r]);
                    else ad.commands.add(new DynamicGpuData.IndexedDraw(l.count[li][r], 1, 0, l.base[li][r], l.instance + vanillaInstances));
                }
                ad.sectionLayers++;
                if (rd != null) rd.layers++;
                if (audit) TerrainStats.layerTriangles(drawn / 3, l.whole[li] / 3, l.n[li]);
            }
        }
        if (!lateIndirect) return;
        int total = 0;
        for (List<ArenaDraws> list : FRAME2) for (ArenaDraws ad : list) total += ad.commands.size();
        if (total == 0) return;
        long bytes = (long) total * RenderPass.INDIRECT_INDEXED_DRAW_SIZE;
        GpuDevice device = RenderSystem.getDevice();
        if (retireIn > 0 && --retireIn == 0) {
            for (GpuBuffer b : RETIRED) b.close();
            RETIRED.clear();
        }
        if (lateCommands == null || lateCommands.size() < bytes) {
            if (lateCommands != null) {
                RETIRED.add(lateCommands);
                retireIn = 8;
            }
            long size = Math.max(64 * 1024, Long.highestOneBit(bytes) * 2);
            lateCommands = device.createBuffer(() -> "Quicksilver late terrain commands", indirectUsage | GpuBuffer.USAGE_COPY_DST, size);
        }
        if (lateScratch == null || lateScratch.capacity() < bytes) {
            if (lateScratch != null) MemoryUtil.memFree(lateScratch);
            lateScratch = MemoryUtil.memAlloc((int) Math.max(64 * 1024, bytes));
        }
        ByteBuffer b = lateScratch;
        b.clear();
        int at = 0;
        for (List<ArenaDraws> list : FRAME2) {
            for (ArenaDraws ad : list) {
                ad.commandStart = at;
                for (DynamicGpuData.IndexedDraw d : ad.commands) {
                    b.putInt(d.indexCount()).putInt(d.instanceCount()).putInt(d.firstIndex()).putInt(d.baseVertex()).putInt(d.baseInstance());
                    at++;
                }
            }
        }
        b.flip();
        encoder.writeToBuffer(lateCommands.slice(0, bytes), b);
    }

    /** Draws the late pass (solid, then cutout) in vanilla's re-opened main pass, with the terrain uniforms bound again. */
    public static void drawPhase2(RenderPass pass) {
        boolean plain = path != Path.INDIRECT;
        if (!plain && !lateIndirect) {
            // no command buffer of the right kind yet (the first frames): one draw per range, still tested
            drawLateDirect(pass, false, LATE, visibleLate(), false);
            return;
        }
        RenderSystem.AutoStorageIndexBuffer quads = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
        GpuBuffer indexBuffer = quads.getBuffer();
        if (indexBuffer == null || !quads.hasStorage(maxIndexCount)) throw new IllegalStateException("the shared quad index buffer is too small");
        int draws = 0, layers = 0;
        for (int li = 0; li < 2; li++) {
            List<ArenaDraws> list = FRAME2[li];
            if (list.isEmpty()) continue;
            boolean lit = TerrainLights.on();
            pass.setPipeline(TerrainPipelines.compiled(TerrainPipelines.pipeline(plain, li == 1, lit)));
            if (lit) TerrainLights.bind(pass);
            pass.setIndexBuffer(indexBuffer, quads.type());
            if (plain) {
                draws += drawPlain(pass, list);
            } else {
                pass.setVertexBuffer(1, instanceSlice);
                int max = Math.max(1, RenderSystem.getDevice().getDeviceInfo().limits().maxDrawIndirectDrawCount());
                for (ArenaDraws ad : list) {
                    int count = ad.commands.size();
                    if (count == 0) continue;
                    pass.setVertexBuffer(0, ad.arena.buffer.slice());
                    long offset = (long) ad.commandStart * RenderPass.INDIRECT_INDEXED_DRAW_SIZE;
                    for (int done = 0; done < count; ) {
                        int n = Math.min(max, count - done);
                        pass.drawIndexedIndirect(lateCommands.slice(offset + (long) done * RenderPass.INDIRECT_INDEXED_DRAW_SIZE,
                            (long) n * RenderPass.INDIRECT_INDEXED_DRAW_SIZE), n);
                        done += n;
                        draws++;
                    }
                }
            }
            for (ArenaDraws ad : list) layers += ad.sectionLayers;
        }
        TerrainStats.drew(draws, layers);
    }

    private static BitSet lateVisible;

    private static BitSet visibleLate() {
        return lateVisible;
    }

    /** Remembers which deferred sections the late pass draws (for the direct fallback). */
    public static void lateVisible(BitSet visible) {
        lateVisible = visible;
    }

    /**
     * Draws deferred sections one range at a time in {@code pass}: every one ({@code only} null), when the late pass
     * can't run (no split possible, an error, wireframe), so nothing deferred is ever left undrawn.
     */
    public static void drawCandidatesDirect(RenderPass pass, boolean wireframe, BitSet only) {
        if (LATE.isEmpty() || !prepared) return;
        for (int i = 0; i < LATE.size(); i++) if (only == null || only.get(i)) GpuOcclusion.drawnLate(LATE.get(i).key);
        drawLateDirect(pass, wireframe, LATE, only, false);
    }

    /** Still camera, when the culling can't be trusted this frame after all: the culled sections are drawn now. */
    public static void drawCulledDirect(RenderPass pass, boolean wireframe) {
        if (CULLED.isEmpty() || !prepared) return;
        drawLateDirect(pass, wireframe, CULLED, null, false);
        CULLED.clear();
    }

    /** CI's occlusion check: the culled sections, in the check's own pass (depth test against the frame's, no writes). */
    public static void drawCulledForCheck(RenderPass pass) {
        drawLateDirect(pass, false, CULLED, null, true);
    }

    private static void drawLateDirect(RenderPass pass, boolean wireframe, List<Late> lates, BitSet only, boolean check) {
        boolean plain = path != Path.INDIRECT;
        RenderSystem.AutoStorageIndexBuffer quads = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
        GpuBuffer indexBuffer = quads.getBuffer();
        if (indexBuffer == null || !quads.hasStorage(maxIndexCount)) throw new IllegalStateException("the shared quad index buffer is too small");
        if (!plain && instanceSlice == null) throw new IllegalStateException("no section instances this frame");
        int draws = 0, layers = 0;
        for (int li = 0; li < 2; li++) {
            CompiledRenderPipeline pipeline = check ? TerrainPipelines.check(plain, li == 1) : wireframe ? TerrainPipelines.wireframe(plain) : null;
            // CI's check must never pass by drawing nothing; a missing wireframe pipeline draws what was left out normally
            if (check && pipeline == null) throw new IllegalStateException("the occlusion check pipeline did not compile");
            boolean lit = false;
            if (pipeline == null) {
                lit = TerrainLights.on();
                pipeline = TerrainPipelines.compiled(TerrainPipelines.pipeline(plain, li == 1, lit));
            }
            pass.setPipeline(pipeline);
            if (lit) TerrainLights.bind(pass);
            pass.setIndexBuffer(indexBuffer, quads.type());
            if (!plain) pass.setVertexBuffer(1, instanceSlice);
            for (int i = 0; i < lates.size(); i++) {
                if (only != null && !only.get(i)) continue;
                Late l = lates.get(i);
                if (l.arena[li] == null) continue;
                pass.setVertexBuffer(0, l.arena[li].buffer.slice());
                if (plain) pass.setUniform("QsRegion", l.ubo);
                for (int r = 0; r < l.n[li]; r++) {
                    pass.drawIndexed(l.count[li][r], 1, 0, l.base[li][r], plain ? 0 : l.instance + vanillaInstances);
                    draws++;
                }
                layers++;
            }
        }
        if (!check) TerrainStats.drew(draws, layers);
    }

    private static void ensureCapacity(int n) {
        if (counts.capacity() < n) {
            int c = Math.max(n, counts.capacity() * 2);
            MemoryUtil.memFree(counts);
            MemoryUtil.memFree(bases);
            MemoryUtil.memFree(zeroOffsets);
            MemoryUtil.memFree(offsets);
            MemoryUtil.memFree(interleaved);
            counts = MemoryUtil.memAllocInt(c);
            bases = MemoryUtil.memAllocInt(c);
            zeroOffsets = MemoryUtil.memCallocPointer(c);
            offsets = MemoryUtil.memCallocPointer(c);
            interleaved = MemoryUtil.memAllocInt(3 * c);
        }
    }
}
