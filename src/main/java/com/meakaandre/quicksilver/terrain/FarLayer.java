package com.meakaandre.quicksilver.terrain;

import com.meakaandre.quicksilver.QuicksilverClient;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.CompiledRenderPipeline;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.vertex.VertexFormat;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.resources.Identifier;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;

/**
 * Package 12: far terrain on the GPU (design doc, "How it draws": "far terrain meshes go in the same region buffers and
 * draw lists as normal terrain"). Each far tile's quads (8-byte vertices, {@link #FORMAT}) live in Quicksilver's terrain
 * arenas, in arenas of their own layer ({@link TerrainStore#FAR}); they are copied in at the start of the frame, before
 * its terrain draws, under a byte budget of their own, and drawn right after the solid terrain layer in the same pass,
 * one multi-draw per far arena (draws by tile), with the shared quad index buffer.
 *
 * <p>The far vertex: x and z as 16-bit block offsets from the anchor (+32768), y in 1/16 block above the dimension's
 * floor, colour as RGB565 (lighting by facing already in it). Its shader puts the tile in the world against the camera,
 * fogs it with the game's own fog functions and lights it with the lightmap's full-sky texel, leaves out what lies inside
 * the hand-over circle and fades it in across the hand-over band by an ordered dither between behind and in front of
 * real terrain, so real terrain wins until the band and far terrain after it, with no hard line.
 *
 * <p>Tiles come from {@code far/FarTerrain} on its sampling thread ({@link #stage}, {@link #remove}); everything else
 * here is render thread.
 */
public final class FarLayer {
    public static final int BYTES = 8;
    static final VertexFormat FORMAT = VertexFormat.builder(0).addAttribute("QsFarVertex", GpuFormat.RGBA16_UINT).build();
    static final BindGroupLayout FAR = BindGroupLayout.builder().withUniform("QsFar", UniformType.UNIFORM_BUFFER).build();
    /**
     * std140: vec4 anchor (camera-relative anchor xyz, floor y), vec4 hand-over (start, end, behind, in front), vec4 debug
     * (x: 1 paints the hand-over band magenta, in front: CI's seam check finds the band with it; z: 1 fills holes), vec4
     * grid (x, z: the hole grid's corner against the camera, blocks; z: its width in chunks), uvec4 low[LOW_WORDS / 4]
     * (one byte per chunk column of the grid: bits 0-6 the lowest section with drawn real geometry, counted from the
     * dimension's floor, 127 for none; bit 7: that section is vanilla's cut; {@link #endColumns}).
     */
    static final int GRID = 68, GRID_HALF = 34;
    static final int LOW_WORDS = GRID * GRID / 4;
    static final int UBO_BYTES = 64 + LOW_WORDS * 4;
    /** Bytes copied in per frame at most (a whole tile always goes in once started). */
    static final long BUDGET_BYTES = 384 * 1024;

    private static final RenderPipeline PIPELINE = RenderPipeline.builder()
        .withLocation(Identifier.fromNamespaceAndPath("quicksilver", "pipeline/far_terrain"))
        .withVertexShader(Identifier.fromNamespaceAndPath("quicksilver", "core/far"))
        .withFragmentShader(Identifier.fromNamespaceAndPath("quicksilver", "core/far"))
        .withBindGroupLayout(BindGroupLayouts.GLOBALS)
        .withBindGroupLayout(BindGroupLayouts.PROJECTION)
        .withBindGroupLayout(BindGroupLayouts.FOG)
        .withBindGroupLayout(BindGroupLayouts.TERRAIN_INFO)
        .withBindGroupLayout(BindGroupLayouts.SAMPLER2)
        .withBindGroupLayout(FAR)
        .withVertexBinding(0, FORMAT)
        .withPrimitiveTopology(PrimitiveTopology.QUADS)
        .withDepthStencilState(DepthStencilState.DEFAULT)
        .withColorTargetState(ColorTargetState.DEFAULT)
        // both faces: far terrain's quads face every way (skirts, tree boxes), and back faces are behind front ones anyway
        .withCull(false)
        .build();

        /** Tiles wholly beyond the hand-over band: the plain fragment stage (no dither, no depth of its own). */
    private static final RenderPipeline PIPELINE_SIMPLE = RenderPipeline.builder()
        .withLocation(Identifier.fromNamespaceAndPath("quicksilver", "pipeline/far_terrain_simple"))
        .withVertexShader(Identifier.fromNamespaceAndPath("quicksilver", "core/far_front"))
        .withFragmentShader(Identifier.fromNamespaceAndPath("quicksilver", "core/far_simple"))
        .withBindGroupLayout(BindGroupLayouts.GLOBALS)
        .withBindGroupLayout(BindGroupLayouts.PROJECTION)
        .withBindGroupLayout(BindGroupLayouts.FOG)
        .withBindGroupLayout(BindGroupLayouts.TERRAIN_INFO)
        .withBindGroupLayout(BindGroupLayouts.SAMPLER2)
        .withBindGroupLayout(FAR)
        .withVertexBinding(0, FORMAT)
        .withPrimitiveTopology(PrimitiveTopology.QUADS)
        .withDepthStencilState(DepthStencilState.DEFAULT)
        .withColorTargetState(ColorTargetState.DEFAULT)
        // both faces: far terrain's quads face every way (skirts, tree boxes), and back faces are behind front ones anyway
        .withCull(false)
        .build();

    private record Staged(long key, ByteBuffer data, int quads, int session, Bounds bounds) {
    }

    /** A tile's box in world blocks (the frustum test leaves out tiles off screen). */
    private record Bounds(int minX, int minZ, int maxX, int maxZ, int minY, int maxY) {
    }

    /** Each drawn tile's box (render thread). */
    private static final Long2ObjectOpenHashMap<Bounds> BOUNDS = new Long2ObjectOpenHashMap<>();
    /** This frame's view (the camera's rotation and projection, camera-relative), side planes only. */
    private static final org.joml.FrustumIntersection VIEW = new org.joml.FrustumIntersection();
    private static final org.joml.Matrix4f VIEW_MATRIX = new org.joml.Matrix4f();
    private static boolean viewSet;
    /** Side planes only: far terrain reaches past the projection's far plane's culling use, and nothing is near. */
    private static final int SIDE_PLANES = org.joml.FrustumIntersection.PLANE_MASK_NX | org.joml.FrustumIntersection.PLANE_MASK_PX
        | org.joml.FrustumIntersection.PLANE_MASK_NY | org.joml.FrustumIntersection.PLANE_MASK_PY;
    /** Bench: tiles left out as off screen in the last frame. */
    private static int lastOffScreen;

    // ---- package 12c: real sections past the band left out where far terrain covers them

    /** The session's tiles whose staged mesh is current (FarTiles.current; FarTerrain.frame sets it), or null. */
    private static volatile java.util.Set<Long> currentTiles;
    private static int coveredThisFrame, lastCovered;

    public static void currentTiles(java.util.Set<Long> s) {
        currentTiles = s;
    }

    /**
     * The horizontal distance from the camera (blocks) past which a real section may be left out because far terrain is
     * drawn in front of real terrain there (beyond the hand-over band's end), or 0 this frame (far terrain off, under a
     * ceiling, failed, or CI's A/B without it). The section's own tile must be covered too ({@link #covers}).
     */
    public static double coverFrom() {
        // the counter of the frame before
        lastCovered = coveredThisFrame;
        coveredThisFrame = 0;
        if (!on || behindOnly || failed != null || currentTiles == null || PARTS.isEmpty() || mark
            || com.meakaandre.quicksilver.speed.Speed.CI_FAR_NO_COVER.on()) return 0;
        return handEnd;
    }

    /** Whether the far tile holding the block column (x, z) is current and in the arenas (render thread). */
    public static boolean covers(int x, int z) {
        long key = (long) Math.floorDiv(x, 128) << 32 | (Math.floorDiv(z, 128) & 0xFFFFFFFFL);
        java.util.Set<Long> cur = currentTiles;
        return cur != null && (PARTS.containsKey(key) || PARTS.containsKey(beyondKey(key))) && cur.contains(key);
    }

    /** A real section left out under far terrain this frame (bench). */
    public static void coveredSection() {
        coveredThisFrame++;
    }

    /** Bench: real sections left out under far terrain in the last frame. */
    public static int lastCovered() {
        return lastCovered;
    }

    /** This frame's dimension has a ceiling: far terrain never in front of real terrain (FarTerrain.frame sets it). */
    private static boolean behindOnly;

    public static void behindOnly(boolean b) {
        behindOnly = b;
    }

    public static boolean isBehindOnly() {
        return behindOnly;
    }

    /** Render thread, as a frame is extracted: the camera's view for the tile test. */
    public static void view(net.minecraft.client.Camera camera) {
        try {
            // the level's projection rolls and skews the view while hurt or dying and with nausea or a portal's warp,
            // which this matrix doesn't have: no test then (every tile drawn)
            if (camera.entity() instanceof net.minecraft.world.entity.LivingEntity le && (le.hurtTime > 0 || le.deathTime > 0 || le.isDeadOrDying())) {
                viewSet = false;
                return;
            }
            var player = net.minecraft.client.Minecraft.getInstance().player;
            if (player != null && (player.portalEffectIntensity > 0 || player.oPortalEffectIntensity > 0
                || player.hasEffect(net.minecraft.world.effect.MobEffects.NAUSEA))) {
                viewSet = false;
                return;
            }
            camera.getViewRotationProjectionMatrix(VIEW_MATRIX);
            VIEW.set(VIEW_MATRIX, false);
            viewSet = true;
        } catch (Throwable t) {
            viewSet = false;
        }
    }

    /** The far terrain session whose tiles are drawn; a staged tile from another (an old thread finishing) is dropped. */
    private static volatile int session;

    private static final Object QUEUE = new Object();
    private static final ArrayDeque<Staged> STAGED = new ArrayDeque<>();
    private static final ArrayDeque<Long> REMOVED = new ArrayDeque<>();
    private static boolean clearAll;

    /** The tiles in the arenas now (render thread). */
    private static final Long2ObjectOpenHashMap<TerrainStore.FarPart> PARTS = new Long2ObjectOpenHashMap<>();
    private static int partsGeneration = -1;
    private static GpuBuffer ubo;
    private static ByteBuffer uboScratch;

    // this frame's parameters (render thread, FarTerrain)
    private static boolean on;
    private static double camX, camY, camZ;
    private static int anchorX, anchorZ, floorY;
    private static float handStart, handEnd;
    private static boolean pipelineFailed;
    /** Bench: what the last frame drew. */
    private static int lastDraws, lastTiles;
    private static long lastQuads;
    private static long uploadedBytes, uploadedTiles;
    /** Set when the arenas were emptied under far terrain's feet ({@link TerrainStore#clear}): it stages every tile again. */
    private static volatile boolean lost;

    private FarLayer() {
    }

    /** A tile's quads (memAlloc'd, owned here from now on); replaces the tile's earlier quads. Any thread. */
    public static void stage(long key, ByteBuffer data, int quads, int fromSession, int minX, int minZ, int maxX, int maxZ, int minY, int maxY) {
        synchronized (QUEUE) {
            if (fromSession != session) {
                MemoryUtil.memFree(data);
                return;
            }
            STAGED.addLast(new Staged(key, data, quads, fromSession, new Bounds(minX, minZ, maxX, maxZ, minY, maxY)));
        }
    }

    /** Package 12c: the key of a tile's second part (its quads past the band; FarTiles splits tiles near the band). */
    public static long beyondKey(long key) {
        return key ^ 0x40000000L;
    }

    /** A tile goes, both its parts (and any of their quads still waiting to be copied in). Any thread. */
    public static void remove(long key, int fromSession) {
        removePart(key, fromSession);
        removePart(beyondKey(key), fromSession);
    }

    /** One part of a tile goes. Any thread. */
    public static void removePart(long key, int fromSession) {
        synchronized (QUEUE) {
            if (fromSession != session) return;
            STAGED.removeIf(s -> {
                if (s.key != key) return false;
                MemoryUtil.memFree(s.data);
                return true;
            });
            REMOVED.addLast(key);
        }
    }

    /** Every tile goes, and from now on only tiles of session {@code next} are taken. Any thread. */
    public static void removeAll(int next) {
        synchronized (QUEUE) {
            session = next;
            for (Staged s : STAGED) MemoryUtil.memFree(s.data);
            STAGED.clear();
            REMOVED.clear();
            clearAll = true;
        }
    }

    /** Every tile goes (far terrain off, another dimension, disconnect). Any thread. */
    public static void removeAll() {
        synchronized (QUEUE) {
            for (Staged s : STAGED) MemoryUtil.memFree(s.data);
            STAGED.clear();
            REMOVED.clear();
            clearAll = true;
        }
    }


    // package 12b: holes inside the hand-over circle. Vanilla's section graph leaves out sections more than the render
    // distance below the camera (and sections not meshed yet); far terrain moves the fog out, so without this the
    // clear colour would show there. Per chunk column of a grid around the camera: the lowest section whose real geometry
    // is drawn this frame. Far terrain fills, behind real terrain, wherever its fragment lies below that section (the land
    // under the cut), and, at the band's front depth (0.5% nearer), in a column with nothing real drawn. Render thread.
    private static final byte[] LOW = new byte[GRID * GRID];
    private static int gridCx, gridCz, floorSection;
    /**
     * The lowest section vanilla's section graph hands over this frame (the camera's section less the render distance:
     * nothing below it is drawn however near). A column whose lowest drawn section is that one is cut there, not ending in
     * blocks: far terrain also fills its steep parts within that section, where the real section's blocks stop at its
     * bottom and far terrain's slopes don't line up with them (a fringe of the clear colour otherwise).
     */
    private static int cutSection = Integer.MIN_VALUE;
    private static boolean fill, holesSet;
    /** Bench: columns with nothing drawn, columns drawn only above their lowest sections, and tiles drawn wholly inside the circle for them. */
    private static int lastHoles, lastPartial, lastCut, lastInsideTiles;

    /**
     * This frame: whether far terrain fills holes inside the hand-over circle (not under a ceiling), and the lowest
     * section vanilla hands over (the camera's section less the render distance). FarTerrain.frame sets it.
     */
    public static void fill(boolean b, int lowestHandedOver) {
        fill = b;
        cutSection = lowestHandedOver;
    }

    /** Whether this frame wants the sections real terrain draws ({@link #beginColumns}). */
    public static boolean wantsColumns() {
        return on && fill && failed == null;
    }

    /** No columns this frame (far terrain off, under a ceiling, or no fill): the counters read zero, no stale grid. */
    public static void clearColumns() {
        holesSet = false;
        lastHoles = 0;
        lastPartial = 0;
        lastCut = 0;
    }

    public static void beginColumns() {
        // 127: nothing drawn; bit 7 (set in endColumns): the column's lowest drawn section is vanilla's cut
        java.util.Arrays.fill(LOW, (byte) 127);
        holesSet = false;
        gridCx = Math.floorDiv((int) Math.floor(camX), 16) - GRID_HALF;
        gridCz = Math.floorDiv((int) Math.floor(camZ), 16) - GRID_HALF;
        floorSection = Math.floorDiv(floorY, 16);
    }

    /** A drawn real section (section coordinates) that has geometry this frame. */
    public static void covered(int sx, int sy, int sz) {
        int gx = sx - gridCx, gz = sz - gridCz;
        if (gx < 0 || gz < 0 || gx >= GRID || gz >= GRID) return;
        int i = gz * GRID + gx;
        int rel = Math.max(0, Math.min(126, sy - floorSection));
        if (rel < (LOW[i] & 0x7F)) LOW[i] = (byte) rel;
    }

    /** The frame's columns are in: counts for the bench (columns inside the hand-over circle only). */
    public static void endColumns() {
        int holes = 0, partial = 0, cut = 0;
        for (int gz = 0; gz < GRID; gz++) {
            for (int gx = 0; gx < GRID; gx++) {
                int cx = gridCx + gx, cz = gridCz + gz;
                double x0 = cx * 16.0, z0 = cz * 16.0;
                double nx = Math.max(Math.max(x0 - camX, camX - (x0 + 16)), 0), nz = Math.max(Math.max(z0 - camZ, camZ - (z0 + 16)), 0);
                if (Math.sqrt(nx * nx + nz * nz) >= handStart) continue;
                int i = gz * GRID + gx;
                int low = LOW[i] & 0x7F;
                if (low == 127) {
                    holes++;
                } else {
                    partial++;
                    if (low > 0 && floorSection + low == cutSection) {
                        LOW[i] = (byte) (low | 0x80);
                        cut++;
                    }
                }
            }
        }
        lastHoles = holes;
        lastPartial = partial;
        lastCut = cut;
        holesSet = true;
    }

    /**
     * Whether far terrain can show anywhere in this tile's box inside the circle: a column of it with nothing drawn, or
     * one whose lowest drawn section starts above the tile's lowest point.
     */
    private static boolean holeIn(int minX, int minZ, int maxX, int maxZ, int minY) {
        if (!holesSet) return false;
        int cx0 = Math.floorDiv(minX, 16) - gridCx, cz0 = Math.floorDiv(minZ, 16) - gridCz;
        int cx1 = Math.floorDiv(maxX - 1, 16) - gridCx, cz1 = Math.floorDiv(maxZ - 1, 16) - gridCz;
        // outside the grid: no mask there (the shader fills nothing), nothing to draw for holes
        int lowSection = Math.floorDiv(minY, 16) - floorSection;
        for (int gz = Math.max(0, cz0); gz <= Math.min(GRID - 1, cz1); gz++) {
            for (int gx = Math.max(0, cx0); gx <= Math.min(GRID - 1, cx1); gx++) {
                int low = LOW[gz * GRID + gx] & 0x7F;
                if (low == 127 || low + ((LOW[gz * GRID + gx] & 0x80) != 0 ? 1 : 0) > lowSection) return true;
            }
        }
        return false;
    }

    /**
     * Status line: for a chunk column inside the hand-over circle, the lowest section (absolute section y) with real
     * geometry drawn last frame, {@link Integer#MAX_VALUE} for none, or {@link Integer#MIN_VALUE} if it isn't inside the
     * circle or the grid.
     */
    public static int lowestDrawn(int cx, int cz) {
        if (!holesSet) return Integer.MIN_VALUE;
        int gx = cx - gridCx, gz = cz - gridCz;
        if (gx < 0 || gz < 0 || gx >= GRID || gz >= GRID) return Integer.MIN_VALUE;
        double x0 = cx * 16.0, z0 = cz * 16.0;
        double nx = Math.max(Math.max(x0 - camX, camX - (x0 + 16)), 0), nz = Math.max(Math.max(z0 - camZ, camZ - (z0 + 16)), 0);
        if (Math.sqrt(nx * nx + nz * nz) >= handStart) return Integer.MIN_VALUE;
        int low = LOW[gz * GRID + gx] & 0x7F;
        return low == 127 ? Integer.MAX_VALUE : floorSection + low;
    }

    public static int lastCut() {
        return lastCut;
    }

    public static int lastPartial() {
        return lastPartial;
    }

    public static int lastHoles() {
        return lastHoles;
    }

    public static int lastInsideTiles() {
        return lastInsideTiles;
    }

    private static volatile String failed;

    /** Whether far terrain's GPU part works (not failed for the session). */
    public static boolean usable() {
        return failed == null;
    }
    private static volatile boolean mark;

    /** {@code /quicksilver far mark on|off}: the hand-over band painted magenta (CI's seam check). */
    public static void mark(boolean on) {
        mark = on;
    }

    /**
     * Something went wrong in far terrain's part (its copy-in or its draw): far terrain is off for the session, with one
     * log line; real terrain is untouched. Render thread.
     */
    static void fail(String where, Throwable t) {
        if (failed != null) return;
        failed = where + ": " + t;
        pipelineFailed = true;
        QuicksilverClient.LOG.error("Quicksilver far terrain: turned off for the session (failed in {})", where, t);
        try {
            for (TerrainStore.FarPart p : PARTS.values()) TerrainStore.farFree(p);
        } catch (Throwable u) {
            // the store's own clear frees the arenas
        }
        PARTS.clear();
        BOUNDS.clear();
        removeAll();
    }

    /** Why far terrain's GPU part stopped for the session, or null. */
    public static String failure() {
        return failed;
    }

    /** Whether the arenas were emptied since the last call (every tile must be staged again); clears it. */
    public static boolean takeLost() {
        boolean l = lost;
        lost = false;
        return l;
    }

    /**
     * This frame's parameters (render thread, before terrain is prepared): whether far terrain draws, the camera, the
     * vertices' anchor and floor, and the hand-over band (horizontal distances from the camera, blocks).
     */
    public static void frame(boolean draw, double x, double y, double z, int ax, int az, int floor, float start, float end) {
        on = draw;
        camX = x;
        camY = y;
        camZ = z;
        anchorX = ax;
        anchorZ = az;
        floorY = floor;
        handStart = start;
        handEnd = end;
    }

    /** Render thread, as terrain preparation starts (with the arenas' grow ahead): removals, then staged tiles under the budget. */
    static void upload() {
        if (failed != null) {
            removeAll();
            synchronized (QUEUE) {
                clearAll = false;
            }
            return;
        }
        try {
            uploadTiles();
        } finally {
            // the frame's block and the index count, here: nothing may be written inside the render pass the draw runs in
            if (on && !PARTS.isEmpty()) {
                writeUbo();
                int maxQuads = 0;
                for (TerrainStore.FarPart p : PARTS.values()) maxQuads = Math.max(maxQuads, p.vertices() / 4);
                RenderSystem.AutoStorageIndexBuffer quads = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
                if (!quads.hasStorage(maxQuads * 6)) quads.requestIndexCount(maxQuads * 6);
                uboWritten = true;
            } else {
                uboWritten = false;
            }
        }
    }

    private static boolean uboWritten;

    private static void uploadTiles() {
        int gen = TerrainStore.generation();
        if (gen != partsGeneration) {
            if (!PARTS.isEmpty()) lost = true;
            // arenas the store closed are gone with it; any it kept still hold these tiles: freed
            for (TerrainStore.FarPart p : PARTS.values()) TerrainStore.farFree(p);
            PARTS.clear();
            BOUNDS.clear();
            partsGeneration = gen;
        }
        List<Staged> take = new ArrayList<>();
        List<Long> drop = new ArrayList<>();
        boolean all;
        synchronized (QUEUE) {
            all = clearAll;
            clearAll = false;
            drop.addAll(REMOVED);
            REMOVED.clear();
            long bytes = 0;
            while (!STAGED.isEmpty() && (take.isEmpty() || bytes + STAGED.peekFirst().data.remaining() <= BUDGET_BYTES)) {
                Staged s = STAGED.pollFirst();
                if (s.session != session) {
                    MemoryUtil.memFree(s.data);
                    continue;
                }
                bytes += s.data.remaining();
                take.add(s);
            }
        }
        if (all) {
            for (TerrainStore.FarPart p : PARTS.values()) TerrainStore.farFree(p);
            PARTS.clear();
            BOUNDS.clear();
        }
        for (long k : drop) {
            TerrainStore.FarPart p = PARTS.remove(k);
            BOUNDS.remove(k);
            if (p != null) TerrainStore.farFree(p);
        }
        if (take.isEmpty()) return;
        GpuDevice device = RenderSystem.getDevice();
        CommandEncoder encoder = device.createCommandEncoder();
        for (Staged s : take) {
            try {
                TerrainStore.FarPart old = PARTS.remove(s.key);
                if (old != null) TerrainStore.farFree(old);
                if (s.quads > 0) {
                    PARTS.put(s.key, TerrainStore.farCopy(device, encoder, s.data, s.quads * 4, BYTES));
                    BOUNDS.put(s.key, s.bounds);
                    uploadedBytes += s.data.remaining();
                    uploadedTiles++;
                }
            } finally {
                MemoryUtil.memFree(s.data);
            }
        }
    }

    private static IntBuffer counts = MemoryUtil.memAllocInt(256), bases = MemoryUtil.memAllocInt(256);
    private static PointerBuffer zeroOffsets = MemoryUtil.memCallocPointer(256);

    /** Render thread, right after the solid layer's draws, in the same pass. */
    static void draw(RenderPass pass) {
        lastDraws = 0;
        lastTiles = 0;
        lastQuads = 0;
        lastOffScreen = 0;
        lastBeyond = 0;
        lastInsideTiles = 0;
        if (!on || PARTS.isEmpty() || pipelineFailed) return;
        CompiledRenderPipeline pipeline;
        try {
            pipeline = RenderSystem.getCompiledPipelineNullable(PIPELINE);
        } catch (Throwable t) {
            pipeline = null;
        }
        if (pipeline == null) {
            fail("compiling its pipeline", new IllegalStateException("pipeline " + PIPELINE.getLocation() + " did not compile"));
            return;
        }
        int maxQuads = 0;
        Map<TerrainStore.Arena, List<TerrainStore.FarPart>> byArena = new IdentityHashMap<>();
        Map<TerrainStore.Arena, List<TerrainStore.FarPart>> byArenaBeyond = new IdentityHashMap<>();
        int offScreen = 0, inside = 0;
        boolean test = viewSet;
        NEAR.clear();
        for (Long2ObjectMap.Entry<TerrainStore.FarPart> en : PARTS.long2ObjectEntrySet()) {
            TerrainStore.FarPart p = en.getValue();
            if (p.arena().closed) continue;
            Bounds b = test ? BOUNDS.get(en.getLongKey()) : null;
            if (b != null) {
                // camera-relative, the mesh's own box, a block of margin and 2 degrees of view (the level's projection
                // adds view bob, which this matrix hasn't; the hurt and death roll and nausea turn the test off: view())
                double ncx = Math.max(Math.max(b.minX() - camX, camX - b.maxX()), 0), ncz = Math.max(Math.max(b.minZ() - camZ, camZ - b.maxZ()), 0);
                float m = 1 + (float) (Math.sqrt(ncx * ncx + ncz * ncz) * 0.035);
                float x0 = (float) (b.minX() - camX) - m, z0 = (float) (b.minZ() - camZ) - m;
                float x1 = (float) (b.maxX() - camX) + m, z1 = (float) (b.maxZ() - camZ) + m;
                float y0 = (float) (b.minY() - camY) - m, y1 = (float) (b.maxY() - camY) + m;
                if (VIEW.intersectAab(x0, y0, z0, x1, y1, z1, SIDE_PLANES) >= 0) {
                    // outside: JOML returns the index of the plane that culls the box (0 to 5)
                    offScreen++;
                    continue;
                }
            }
            // package 12b: wholly inside the hand-over circle (its farthest point): drawn only for a hole in it
            if (b != null) {
                double fx = Math.max(Math.abs(b.minX() - camX), Math.abs(b.maxX() - camX)), fz = Math.max(Math.abs(b.minZ() - camZ), Math.abs(b.maxZ() - camZ));
                if (Math.sqrt(fx * fx + fz * fz) < handStart) {
                    if (!fill || !holeIn(b.minX(), b.minZ(), b.maxX(), b.maxZ(), b.minY())) continue;
                    inside++;
                }
            }
            // wholly beyond the band's far edge (its nearest point, from the camera, across the ground): the plain stage
            boolean beyond = false;
            if (b != null) {
                double nx = Math.max(Math.max(b.minX() - camX, camX - b.maxX()), 0), nz = Math.max(Math.max(b.minZ() - camZ, camZ - b.maxZ()), 0);
                beyond = Math.sqrt(nx * nx + nz * nz) - 1 >= handEnd;
            }
            (beyond ? byArenaBeyond : byArena).computeIfAbsent(p.arena(), k -> new ArrayList<>()).add(p);
            if (b != null) {
                double nx = Math.max(Math.max(b.minX() - camX, camX - b.maxX()), 0), nz = Math.max(Math.max(b.minZ() - camZ, camZ - b.maxZ()), 0);
                NEAR.put(p, nx * nx + nz * nz);
            }
            maxQuads = Math.max(maxQuads, p.vertices() / 4);
        }
        lastOffScreen = offScreen;
        lastInsideTiles = inside;
        if (byArena.isEmpty() && byArenaBeyond.isEmpty()) return;
        CompiledRenderPipeline simple = null;
        if (!byArenaBeyond.isEmpty()) {
            try {
                simple = RenderSystem.getCompiledPipelineNullable(PIPELINE_SIMPLE);
            } catch (Throwable t) {
                simple = null;
            }
            if (simple == null) {
                // the plain stage didn't compile: the band's stage draws those tiles too (same picture, slower)
                for (Map.Entry<TerrainStore.Arena, List<TerrainStore.FarPart>> e : byArenaBeyond.entrySet())
                    byArena.computeIfAbsent(e.getKey(), k -> new ArrayList<>()).addAll(e.getValue());
                byArenaBeyond.clear();
            }
        }
        RenderSystem.AutoStorageIndexBuffer quads = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
        if (!quads.hasStorage(maxQuads * 6)) {
            // asked for now, there from the next frame
            quads.requestIndexCount(maxQuads * 6);
            return;
        }
        if (!uboWritten) return;
        GpuBuffer indexBuffer = quads.getBuffer();
        boolean separate = RenderSystem.getDevice().getDeviceInfo().features().multiDrawDirectSeparate();
        // nearest first: the band's tiles, then those beyond (hidden pixels of the latter are rejected before shading)
        // package 12c: each list nearest first, so nearer tiles' depth hides farther pixels before they are shaded
        if (!com.meakaandre.quicksilver.speed.Speed.CI_FAR_NO_SORT.on()) {
            for (List<TerrainStore.FarPart> l : byArena.values()) sortNearFirst(l);
            for (List<TerrainStore.FarPart> l : byArenaBeyond.values()) sortNearFirst(l);
        }
        if (!byArena.isEmpty()) drawLists(pass, pipeline, indexBuffer, quads, separate, byArena);
        if (!byArenaBeyond.isEmpty()) drawLists(pass, simple, indexBuffer, quads, separate, byArenaBeyond);
        lastBeyond = 0;
        for (List<TerrainStore.FarPart> l : byArenaBeyond.values()) lastBeyond += l.size();
        TerrainStats.drew(lastDraws, 0);
    }

    private static final java.util.IdentityHashMap<TerrainStore.FarPart, Double> NEAR = new java.util.IdentityHashMap<>();

    private static void sortNearFirst(List<TerrainStore.FarPart> l) {
        if (l.size() < 2) return;
        l.sort((a, b) -> Double.compare(NEAR.getOrDefault(a, 0.0), NEAR.getOrDefault(b, 0.0)));
    }

    /** Bench: tiles drawn with the plain stage (wholly beyond the band) in the last frame. */
    private static int lastBeyond;

    public static int lastBeyond() {
        return lastBeyond;
    }

    private static void drawLists(RenderPass pass, CompiledRenderPipeline pipeline, GpuBuffer indexBuffer, RenderSystem.AutoStorageIndexBuffer quads,
                                  boolean separate, Map<TerrainStore.Arena, List<TerrainStore.FarPart>> byArena) {
        pass.setPipeline(pipeline);
        pass.setUniform("QsFar", ubo);
        pass.setIndexBuffer(indexBuffer, quads.type());
        for (Map.Entry<TerrainStore.Arena, List<TerrainStore.FarPart>> e : byArena.entrySet()) {
            List<TerrainStore.FarPart> list = e.getValue();
            int n = list.size();
            pass.setVertexBuffer(0, e.getKey().buffer.slice());
            if (separate) {
                if (counts.capacity() < n) {
                    MemoryUtil.memFree(counts);
                    MemoryUtil.memFree(bases);
                    MemoryUtil.memFree(zeroOffsets);
                    counts = MemoryUtil.memAllocInt(n * 2);
                    bases = MemoryUtil.memAllocInt(n * 2);
                    zeroOffsets = MemoryUtil.memCallocPointer(n * 2);
                }
                counts.clear();
                bases.clear();
                for (TerrainStore.FarPart p : list) {
                    counts.put(p.vertices() / 4 * 6);
                    bases.put((int) (p.offset() / BYTES));
                }
                counts.flip();
                bases.flip();
                zeroOffsets.clear().limit(n);
                pass.multiDrawIndexed(zeroOffsets, counts, bases, n);
                lastDraws++;
            } else {
                for (TerrainStore.FarPart p : list) {
                    pass.drawIndexed(p.vertices() / 4 * 6, 1, 0, (int) (p.offset() / BYTES), 0);
                    lastDraws++;
                }
            }
            for (TerrainStore.FarPart p : list) lastQuads += p.vertices() / 4;
            lastTiles += n;
        }
    }

    private static void writeUbo() {
        GpuDevice device = RenderSystem.getDevice();
        if (ubo == null) {
            ubo = device.createBuffer(() -> "Quicksilver far terrain", GpuBuffer.USAGE_UNIFORM | GpuBuffer.USAGE_COPY_DST, UBO_BYTES);
            uboScratch = MemoryUtil.memAlloc(UBO_BYTES);
        }
        ByteBuffer b = uboScratch.clear();
        b.putFloat((float) (anchorX - camX)).putFloat((float) (floorY - camY)).putFloat((float) (anchorZ - camZ)).putFloat(floorY);
        // behind: 1.5% further (real terrain wins where both draw); in front: 0.5% nearer (far terrain wins past the band)
        // under a ceiling (the nether) far terrain's surface is the first floor below the roof, not the caverns real
        // terrain shows: it stays behind real terrain everywhere, never in front
        b.putFloat(handStart).putFloat(handEnd).putFloat(1.015f).putFloat(behindOnly ? 1.015f : 0.995f);
        boolean holes = fill && holesSet;
        b.putFloat(mark ? 1f : 0f).putFloat(0).putFloat(holes ? 1f : 0f).putFloat(0);
        // the hole grid's corner against the camera (small numbers: the shader adds them to the eye position), its width
        b.putFloat((float) (gridCx * 16.0 - camX)).putFloat((float) (gridCz * 16.0 - camZ)).putFloat(GRID).putFloat(haze);
        // the lowest drawn section of each column, four columns to a word (byte i of word i / 4 at bits 8 * (i % 4))
        for (int i = 0; i < LOW_WORDS; i++) {
            int w = 0;
            for (int k = 0; k < 4; k++) w |= (holes ? LOW[i * 4 + k] & 0xFF : 0) << (8 * k);
            b.putInt(w);
        }
        b.flip();
        device.createCommandEncoder().writeToBuffer(ubo.slice(), b);
    }

    /** Package 12c: the haze's share at the fog's end this frame (FarTerrain.frame), 0 for none. */
    private static float haze;

    public static void haze(float h) {
        haze = h;
    }

    /** Bench: tiles held, quads and draws of the last frame, bytes copied in so far. */
    public static String describe() {
        long bytes = 0;
        for (TerrainStore.FarPart p : PARTS.values()) bytes += (long) p.vertices() * BYTES;
        return "tiles " + PARTS.size() + " (" + bytes / 1024 + " KB), drawn last frame: " + lastTiles + " tiles (" + lastOffScreen + " off screen, "
            + lastInsideTiles + " inside for holes), " + lastQuads + " quads in " + lastDraws + " draws, columns with nothing drawn " + lastHoles
            + ", with real sections drawn " + lastPartial;
    }

    /** Tiles staged and not yet copied in (any thread). */
    public static int pending() {
        synchronized (QUEUE) {
            return STAGED.size() + REMOVED.size();
        }
    }

    public static int tilesHeld() {
        return PARTS.size();
    }

    public static long bytesHeld() {
        long bytes = 0;
        for (TerrainStore.FarPart p : PARTS.values()) bytes += (long) p.vertices() * BYTES;
        return bytes;
    }

    public static int lastDraws() {
        return lastDraws;
    }

    public static long lastQuads() {
        return lastQuads;
    }

    public static int lastOffScreen() {
        return lastOffScreen;
    }

    /** Whether the frame's view reached the tile test (the camera hook ran). */
    public static boolean viewTested() {
        return viewSet;
    }

    public static int lastTiles() {
        return lastTiles;
    }

    public static long uploadedBytes() {
        return uploadedBytes;
    }
}
