package com.meakaandre.quicksilver.occlusion;

import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.bench.GpuCounters;
import com.meakaandre.quicksilver.terrain.TerrainRenderer;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.commands.RenderPassDescriptor;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.textures.GpuTexture;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.BitSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Properties;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

/**
 * Package 2b: GPU occlusion culling of terrain sections, from a small depth image (a depth pyramid) of what was drawn.
 * Conservative: a section is left out only when its whole box is proven behind drawn terrain; anything uncertain is
 * drawn. Two ways (config {@code occlusion=auto|two-phase|still-camera|off} in {@code config/quicksilver.properties},
 * or {@code -Dquicksilver.occlusion=...}):
 *
 * <ul>
 * <li><b>Two-phase</b> (auto where vanilla trusts the driver with multi-draw indirect): solid and cutout terrain of the
 * sections drawn last frame (minus those the latest pyramid shows hidden) are drawn first; then vanilla's main pass is
 * closed, a pyramid of this frame's depth is built and read back (the CPU waits for the GPU here, reported), every other
 * visible section is tested against it, those not proven hidden are drawn, and the pass is opened again. So a newly
 * revealed section is drawn in the same frame.</li>
 * <li><b>Still camera</b> (auto on the Intel / old-GPU path): no waiting. A pyramid is read back whenever the GPU is
 * done, and only used while the whole view (position, direction, projection, view bobbing included), the viewport and
 * every visible section's mesh are exactly what they were when it was drawn; then sections behind its depth are left
 * out. Any movement, turn or change stops it until a new pyramid comes back.</li>
 * </ul>
 *
 * <p>The pyramid holds solid and cutout terrain only (vanilla's and Quicksilver's), taken right after the opaque terrain
 * group, before entities, so nothing in it moves by itself. Translucent terrain is always drawn as before. Errors turn
 * the module off for the session (package 2's culling stays) with one line in the log.
 */
public final class GpuOcclusion {
    public enum Mode { AUTO, TWO_PHASE, STILL_CAMERA, OFF }

    enum Frame { NONE, TWO_PHASE, STILL }

    public static final int DRAW = 0, DEFER = 1, CULL = 2;

    static final boolean VERIFY = Boolean.getBoolean("quicksilver.debug.verifyOcclusion");
    /** How long the two-phase path waits for the GPU at most before drawing every candidate untested. */
    static final long WAIT_TIMEOUT_MS = 250;
    /** Timed-out waits in a row after which two-phase gives way to still camera (see where they are counted). */
    static final int MAX_TIMEOUTS_IN_A_ROW = 3;
    private static int timeoutsInARow;

    static Mode configured;
    static String state = "starting", reason = "";
    static int fallbacks;

    // captured from vanilla
    private static final Map<GpuBufferSlice, float[]> PROJECTIONS = new LinkedHashMap<>(16, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<GpuBufferSlice, float[]> e) {
            return size() > 16;
        }
    };
    private static final Matrix4f VIEW = new Matrix4f();
    private static boolean viewSeen;
    private static double camX, camY, camZ;
    private static RenderPassDescriptor lastDescriptor;
    private static long descriptorSerial;

    // this frame
    static Frame frame = Frame.NONE;
    private static final double[] M = new double[16];
    private static double[] eye;
    private static long visibleHash;
    private static boolean indirectFrame;
    private static boolean stillValid, buildStill;
    private static boolean wrappedThisFrame;
    private static int framesWithoutMatrices, projectionMismatches, framesWithoutOpaqueHook;
    private static boolean opaqueHookSeen, deferredUnhandled;
    private static int lastW, lastH;
    private static Stamp prevStamp;

    // pyramids
    private static final PyramidGpu GPU = new PyramidGpu();
    private static DepthPyramid latest;
    private static Stamp latestStamp;
    private static boolean[] calibration;
    private static boolean zeroToOne, reversed, conventionKnown;

    // two-phase: sections whose opaque layers were drawn last frame / this frame
    private static LongOpenHashSet drawnLast = new LongOpenHashSet(), drawnNow = new LongOpenHashSet();

    /** A pass without a depth attachment is not vanilla's main pass: left as it is. */
    static final class NoDepth extends RuntimeException {
        NoDepth() {
            super(null, null, false, false);
        }
    }

    /**
     * What a still-camera pyramid is valid for: the whole camera-relative view (projection and rotation), the camera
     * position, every visible section and its mesh, and the viewport. All must be exactly the same: the depth image is
     * then what the same pixels saw of the same geometry. (The same eye looking another way is not enough: other pixels
     * sample other rays, which can pass through gaps narrower than a pixel that every old sample missed.)
     */
    private record Stamp(java.util.List<Double> m, double cx, double cy, double cz, long visible, int w, int h, long changes) {
        static Stamp of(double[] m, double cx, double cy, double cz, long visible, int w, int h, long changes) {
            Double[] b = new Double[16];
            for (int i = 0; i < 16; i++) b[i] = m[i];
            return new Stamp(java.util.List.of(b), cx, cy, cz, visible, w, h, changes);
        }
    }

    /** Section meshes taken or let go since start-up (any thread): part of {@link #changes}. */
    private static final java.util.concurrent.atomic.AtomicLong MESH_CHANGES = new java.util.concurrent.atomic.AtomicLong();

    /** Mixin (any thread): a section layer was uploaded or a section mesh let go. */
    public static void meshChanged() {
        MESH_CHANGES.incrementAndGet();
    }

    /**
     * What else must not change while a still-camera pyramid is reused: section meshes (also caught by the visible list's
     * mesh identities), animated textures that can change the shape of cutout terrain (fire, kelp...) and Flywheel's
     * geometry (package 5).
     */
    private static long changes() {
        return MESH_CHANGES.get() * 1000003L + com.meakaandre.quicksilver.animation.Animation.cutoutShapeStamp()
            + (FLYWHEEL_STAMP ? com.meakaandre.quicksilver.compat.flywheel.FlywheelCompat.depthStamp() * 7919L : 0);
    }

    /**
     * Package 5: Create Fly's Flywheel draws its solid geometry into the main depth image before the terrain, so a
     * still-camera pyramid holds Flywheel's machines, contraptions and trains as they were in that frame. They move
     * from frame to frame on the GPU, so a frame in which Flywheel drew anything changes the stamp: the stamp read at
     * the frame's start never matches at its end, so while Flywheel holds any visual the still camera builds and reuses
     * no pyramid at all (nothing culled; two-phase is unaffected). Debug switch {@code quicksilver.debug.noFlywheelStamp}
     * (not set in CI): the stamp without Flywheel, to see what it costs.
     */
    private static final boolean FLYWHEEL_STAMP = !Boolean.getBoolean("quicksilver.debug.noFlywheelStamp");

    /** {@link #changes} as this frame's terrain was prepared; this frame's CI check (every few frames, see beginFrame). */
    private static long frameChanges;
    private static boolean verifyFrame, unknownLogged;
    private static long frameNumber;
    /** The size of this frame's main depth image (from the main pass's descriptor), -1 unknown. */
    private static int mainW = -1, mainH = -1;

    private GpuOcclusion() {
    }

    // ---------------------------------------------------------------- hooks from vanilla

    /** Mixin: a projection matrix was written into a uniform buffer slice. */
    public static void projection(GpuBufferSlice slice, Matrix4fc m) {
        if (slice == null || m == null) return;
        float[] f = new float[16];
        m.get(f);
        PROJECTIONS.put(slice, f);
    }

    /** Mixin: vanilla's terrain view rotation for this frame (the terrain shader's ModelViewMat). */
    public static void viewRotation(Matrix4fc view) {
        VIEW.set(view);
        viewSeen = true;
    }

    /** The camera position terrain is drawn relative to. */
    public static void camera(double x, double y, double z) {
        camX = x;
        camY = y;
        camZ = z;
    }

    /** Mixin: a render pass is being created from a descriptor. */
    public static void descriptor(RenderPassDescriptor d) {
        lastDescriptor = d;
        descriptorSerial++;
    }

    private static long serialBefore;
    private static boolean armed;

    /** Mixin: vanilla is about to create its main pass (the serial tells whether the descriptor hook saw it). */
    public static void beforeMainPass() {
        serialBefore = descriptorSerial;
        armed = true;
    }

    /** Mixin: vanilla created its main pass; wrapped when this frame splits it. */
    public static RenderPass mainPass(RenderPass pass) {
        boolean wasArmed = armed;
        armed = false;
        if (frame == Frame.NONE || !"on".equals(state)) return pass;
        mainW = mainH = -1;
        if (wasArmed && descriptorSerial != serialBefore && lastDescriptor != null) {
            try {
                GpuTextureView d = SplitPass.depthOf(lastDescriptor);
                if (d != null) {
                    mainW = d.texture().getWidth(0);
                    mainH = d.texture().getHeight(0);
                }
            } catch (Throwable ignored) {
                // unknown size: a still-camera frame then draws what it culled (afterOpaque)
            }
        }
        if (!needsSplit()) return pass;
        try {
            if (!wasArmed) throw new IllegalStateException("hook that did not apply: MainPassMixin#quicksilver$beforeMainPass");
            if (descriptorSerial == serialBefore || lastDescriptor == null) {
                throw new IllegalStateException("the main pass was not created from a descriptor Quicksilver saw (RenderPassDescriptorMixin)");
            }
            RenderPass wrapped = SplitPass.wrap(pass, lastDescriptor,
                d -> RenderSystem.getDevice().createCommandEncoder().createRenderPass((RenderPassDescriptor) d));
            wrappedThisFrame = true;
            return wrapped;
        } catch (NoDepth n) {
            return pass;
        } catch (Throwable t) {
            fail("wrapping the main pass", t);
            return pass;
        }
    }

    /**
     * The main pass is split only to build a pyramid (every two-phase frame; a still-camera frame when one is due) or
     * for CI's check. A still-camera frame reusing its pyramid only leaves sections out: no split.
     */
    private static boolean needsSplit() {
        return frame == Frame.TWO_PHASE || buildStill || (verifyFrame && TerrainRenderer.culledCount() > 0);
    }

    // ---------------------------------------------------------------- per frame

    /**
     * Render thread, as Quicksilver prepares its terrain draws: decides what this frame does. {@code visible} is
     * vanilla's visible section list; {@code indirect} whether vanilla draws terrain with multi-draw indirect this frame.
     */
    public static void beginFrame(List<SectionRenderDispatcher.RenderSection> visible, boolean indirect, boolean wireframe) {
        frame = Frame.NONE;
        wrappedThisFrame = false;
        buildStill = false;
        stillValid = false;
        indirectFrame = indirect;
        // CI's check runs every fourth frame, so the frames between run exactly as without it (no extra split)
        verifyFrame = VERIFY && (frameNumber++ & 3) == 0 && !GPU.checkPending();
        frameChanges = changes();
        GPU.frame();
        OcclusionStats.beginFrame();
        if (configured == null) start();
        // the last frame left sections out but the hook after the opaque terrain group never ran: it no longer fits
        if (deferredUnhandled) {
            deferredUnhandled = false;
            fail("checking hooks", new IllegalStateException("hook that did not run: MainPassMixin#quicksilver$afterOpaque"));
        }
        if (!"on".equals(state)) return;
        // nothing is left out until the hook after the opaque terrain group is known to run (every frame vanilla draws terrain)
        if (!opaqueHookSeen) {
            if (++framesWithoutOpaqueHook == 600) {
                fail("checking hooks", new IllegalStateException("hook that did not apply: MainPassMixin#quicksilver$afterOpaque"));
            }
            return;
        }
        try {
            if (wireframe) return;
            if (!calibrated()) return;
            float[] p = viewSeen ? PROJECTIONS.get(RenderSystem.getProjectionMatrixBuffer()) : null;
            if (p == null) {
                // the projection or view hook never gave anything: after a few seconds of world frames, say so and stop
                if (++framesWithoutMatrices == 600) {
                    fail("starting", new IllegalStateException(!viewSeen ? "hook that did not apply: LevelRendererMixin view rotation"
                        : PROJECTIONS.isEmpty() ? "hook that did not apply: ProjectionMatrixBufferMixin" : "the bound projection was never one Quicksilver saw written"));
                }
                return;
            }
            framesWithoutMatrices = 0;
            Matrix4f pm = new Matrix4f().set(p);
            Matrix4f mvp = pm.mul(VIEW, new Matrix4f());
            float[] f = new float[16];
            mvp.get(f);
            for (int i = 0; i < 16; i++) M[i] = f[i];
            double[] e = DepthPyramid.eye(M);
            if (e == null) return;
            eye = new double[] {camX + e[0], camY + e[1], camZ + e[2]};
            long h = 1469598103934665603L;
            for (SectionRenderDispatcher.RenderSection s : visible) {
                h = (h ^ s.getSectionNode()) * 1099511628211L;
                h = (h ^ System.identityHashCode(s.getSectionMesh())) * 1099511628211L;
            }
            visibleHash = h ^ visible.size();
            Stamp now = Stamp.of(M, camX, camY, camZ, visibleHash, lastW, lastH, frameChanges);
            Mode mode = configured == Mode.AUTO ? (indirect ? Mode.TWO_PHASE : Mode.STILL_CAMERA) : configured;
            // two-phase waits for the GPU in the middle of the frame: where that wait never completes (calibration
            // found it so, e.g. renderpearl's Vulkan backend), the still-camera path instead
            if (mode == Mode.TWO_PHASE && !midFrameWait) {
                if (!twoPhaseUnavailableLogged) {
                    twoPhaseUnavailableLogged = true;
                    QuicksilverClient.LOG.info("Quicksilver occlusion: two-phase needs the GPU to finish work within a frame, which this backend does not do; still camera instead");
                }
                mode = Mode.STILL_CAMERA;
            }
            if (mode == Mode.TWO_PHASE) {
                frame = Frame.TWO_PHASE;
            } else if (mode == Mode.STILL_CAMERA) {
                frame = Frame.STILL;
                stillValid = latest != null && now.equals(latestStamp);
                buildStill = !stillValid && !GPU.asyncPending() && now.equals(prevStamp);
            }
            prevStamp = now;
            LongOpenHashSet t = drawnLast;
            drawnLast = drawnNow;
            drawnNow = t;
            drawnNow.clear();
        } catch (Throwable t) {
            fail("starting the frame", t);
            frame = Frame.NONE;
        }
    }

    /**
     * Render thread, for each visible section Quicksilver draws with solid or cutout layers: {@link #DRAW} (now),
     * {@link #DEFER} (two-phase: tested after the first part of the frame) or {@link #CULL} (still camera: hidden).
     * The box is the section's geometry (world coordinates).
     */
    public static int classify(long section, double x0, double y0, double z0, double x1, double y1, double z1) {
        switch (frame) {
            case TWO_PHASE -> {
                if (drawnLast.contains(section) && (latest == null || latest.test(x0, y0, z0, x1, y1, z1) == DepthPyramid.Result.VISIBLE)) {
                    drawnNow.add(section);
                    OcclusionStats.phase1++;
                    return DRAW;
                }
                OcclusionStats.candidates++;
                deferredUnhandled = true;
                return DEFER;
            }
            case STILL -> {
                // the pyramid was drawn with exactly this frame's view (the stamp says so): its own-view test holds
                if (stillValid && latest.test(x0, y0, z0, x1, y1, z1, true) != DepthPyramid.Result.VISIBLE) {
                    OcclusionStats.culledStill++;
                    deferredUnhandled = true;
                    return CULL;
                }
                OcclusionStats.phase1++;
                return DRAW;
            }
            default -> {
                return DRAW;
            }
        }
    }

    /** Render thread, before each frame's terrain is prepared: nothing culled or deferred until decided. */
    public static void resetFrame() {
        frame = Frame.NONE;
        buildStill = false;
        stillValid = false;
    }

    /** Render thread: preparing this frame's terrain failed, so nothing was left out after all. */
    public static void abandonFrame() {
        resetFrame();
        deferredUnhandled = false;
    }

    /** Whether this frame culls or defers anything (classify is then asked for each section). */
    public static boolean active() {
        return frame != Frame.NONE;
    }

    /** Two-phase: of the deferred sections, how many the fresh pyramid showed visible and how many hidden. */
    public static void lateResult(int revealed, int hidden) {
        OcclusionStats.revealed += revealed;
        OcclusionStats.culledLate += hidden;
    }

    /** Two-phase: a candidate the fresh pyramid showed visible was drawn. */
    public static void drawnLate(long section) {
        drawnNow.add(section);
    }

    /**
     * Render thread, in vanilla's main pass right after the opaque terrain group (vanilla's solid and cutout, then
     * Quicksilver's). Two-phase: builds and reads the pyramid, tests and draws the candidates. Still camera: builds a
     * pyramid when one is due. CI: checks the culled sections.
     */
    public static void afterOpaque(RenderPass pass, boolean wireframe) {
        opaqueHookSeen = true;
        deferredUnhandled = false;
        if (frame == Frame.NONE) return;
        boolean twoPhase = frame == Frame.TWO_PHASE;
        SplitPass sp = SplitPass.of(pass);
        boolean phase2Done = false;
        try {
            boolean projectionOk = sameProjection();
            // still camera: something changed since the terrain was prepared (an animated texture redrawn, a mesh), or
            // this frame's depth image is not the size the pyramid was drawn at: what was culled is drawn after all,
            // and no pyramid is stamped for a frame that changed under it
            boolean stillStale = false;
            if (frame == Frame.STILL) {
                boolean changed = changes() != frameChanges;
                if (changed) buildStill = false;
                stillStale = TerrainRenderer.culledCount() > 0 && (changed || latestStamp == null || mainW != latestStamp.w() || mainH != latestStamp.h());
                if (stillStale) OcclusionStats.stillRedrawn++;
            }
            boolean splitNeeded = twoPhase || buildStill || (verifyFrame && TerrainRenderer.culledCount() > 0);
            if ((sp == null && splitNeeded) || wireframe || !"on".equals(state) || !projectionOk || stillStale) {
                // nothing left out may stay undrawn: deferred sections and (still camera) culled ones are drawn now
                boolean any = TerrainRenderer.candidateCount() > 0 || TerrainRenderer.culledCount() > 0;
                if (twoPhase) TerrainRenderer.drawCandidatesDirect(pass, wireframe, null);
                else TerrainRenderer.drawCulledDirect(pass, wireframe);
                phase2Done = true;
                if (any && !stillStale) OcclusionStats.untestedFrames++;
                if (!projectionOk && ++projectionMismatches == 60) {
                    fail("checking the projection", new IllegalStateException("the projection bound for the main pass is not the one prepared with"));
                }
                return;
            }
            projectionMismatches = 0;
            boolean candidates = TerrainRenderer.candidateCount() > 0;
            boolean verify = verifyFrame && TerrainRenderer.culledCount() > 0;
            if (!twoPhase && !buildStill && !verify) return;
            if (!sp.suspend()) {
                if (sp.unknownState() != null && !unknownLogged) {
                    unknownLogged = true;
                    QuicksilverClient.LOG.warn("Quicksilver occlusion: the main pass is not split after a call Quicksilver does not replay ({}); frames draw what they left out untested", sp.unknownState());
                }
                if (twoPhase) {
                    TerrainRenderer.drawCandidatesDirect(pass, false, null);
                    phase2Done = true;
                    OcclusionStats.untestedFrames++;
                }
                return;
            }
            OcclusionStats.splits++;
            CommandEncoder enc = RenderSystem.getDevice().createCommandEncoder();
            if (!ready(enc, sp.depth)) {
                sp.resume();
                if (twoPhase) {
                    TerrainRenderer.drawCandidatesDirect(pass, false, null);
                    phase2Done = true;
                }
                return;
            }
            GpuTexture dt = sp.depth.texture();
            int w = dt.getWidth(0), h = dt.getHeight(0);
            lastW = w;
            lastH = h;
            BitSet visible = null;
            if (twoPhase || buildStill) {
                GPU.render(enc, sp.depth, reversed);
                OcclusionStats.pyramids++;
                double[] mm = M.clone();
                double cx = camX, cy = camY, cz = camZ;
                Stamp stamp = Stamp.of(M, camX, camY, camZ, visibleHash, w, h, frameChanges);
                boolean fy = calibration[1], z01 = zeroToOne, rev = reversed;
                if (twoPhase && candidates) {
                    long[] waited = new long[1];
                    float[] l0 = GPU.readNow(enc, WAIT_TIMEOUT_MS, waited);
                    OcclusionStats.waited(waited[0]);
                    if (l0 == null) {
                        OcclusionStats.timeouts++;
                        // the calibration found the wait completing, but it stopped doing so (lavapipe, Vulkan: 590 waits
                        // timed out in one of the test pack's sessions, run fc717d5; why was not found): after a few in a
                        // row, the still-camera path, as where the calibration finds no wait (every timed-out frame drew
                        // every candidate). Vulkan only, where it was seen: on OpenGL a timed-out wait stays a failure CI
                        // catches. Until the next calibration (a resource reload calibrates again)
                        String backend = RenderSystem.getDevice().getDeviceInfo().backendName();
                        if (++timeoutsInARow >= MAX_TIMEOUTS_IN_A_ROW && midFrameWait && backend.toLowerCase(java.util.Locale.ROOT).contains("vulkan")) {
                            midFrameWait = false;
                            midFrameWaitSwitched = true;
                            QuicksilverClient.LOG.warn("Quicksilver occlusion: waiting for the GPU within a frame timed out {} times in a row on {}; still camera from now on",
                                timeoutsInARow, backend);
                        }
                    } else {
                        timeoutsInARow = 0;
                        DepthPyramid p = new DepthPyramid(w, h, l0, mm, cx, cy, cz, fy, z01, rev);
                        latest = p;
                        latestStamp = stamp;
                        visible = TerrainRenderer.testCandidates(p);
                    }
                    if (visible == null) {
                        visible = new BitSet();
                        visible.set(0, TerrainRenderer.candidateCount());
                    }
                } else if (!GPU.asyncPending()) {
                    GPU.readLater(enc, l0 -> {
                        latest = new DepthPyramid(w, h, l0, mm, cx, cy, cz, fy, z01, rev);
                        latestStamp = stamp;
                    });
                }
            }
            if (twoPhase && candidates) TerrainRenderer.preparePhase2(visible, enc);
            sp.resume();
            if (twoPhase && candidates) {
                TerrainRenderer.drawPhase2(pass);
                phase2Done = true;
            }
            if (verifyFrame && TerrainRenderer.culledCount() > 0) verify(sp, w, h);
        } catch (Throwable t) {
            fail("culling terrain", t);
            try {
                if (sp != null && sp.suspended()) sp.resume();
                if (twoPhase && !phase2Done) TerrainRenderer.drawCandidatesDirect(pass, wireframe, null);
                if (!twoPhase && !phase2Done) TerrainRenderer.drawCulledDirect(pass, wireframe);
            } catch (Throwable t2) {
                QuicksilverClient.LOG.error("Quicksilver occlusion: could not draw the deferred sections after the failure", t2);
            }
        }
    }

    /** The projection bound now is the one this frame's matrix was built from. */
    private static boolean sameProjection() {
        float[] p = PROJECTIONS.get(RenderSystem.getProjectionMatrixBuffer());
        if (p == null) return false;
        Matrix4f mvp = new Matrix4f().set(p).mul(VIEW, new Matrix4f());
        float[] f = new float[16];
        mvp.get(f);
        for (int i = 0; i < 16; i++) if ((double) f[i] != M[i]) return false;
        return true;
    }

    /** The main depth image can be sampled; false (module off) if not. */
    private static boolean ready(CommandEncoder enc, GpuTextureView depth) {
        if ((depth.texture().usage() & GpuTexture.USAGE_TEXTURE_BINDING) == 0) {
            fail("starting", new IllegalStateException("the main depth image can't be sampled (usage " + depth.texture().usage() + ")"));
            return false;
        }
        return true;
    }

    private static PyramidGpu.Calibration pendingCalibration;
    private static int calibrationFrames;
    /** Whether a fence wait within the frame completes on this backend (calibration): two-phase needs it. */
    static boolean midFrameWait;
    /** Whether the calibration found the wait within a frame completing (bench JSON). */
    static boolean midFrameWaitCalibrated;
    /** Whether timed-out waits switched this session to still camera since the last calibration (Vulkan only; bench JSON). */
    static boolean midFrameWaitSwitched;
    private static boolean twoPhaseUnavailableLogged;

    /**
     * Render thread, no pass open (as terrain is prepared): starts the calibration, then takes its result once the GPU
     * has drawn it. True once calibrated; nothing is left out before.
     */
    private static boolean calibrated() {
        if (calibration != null) return true;
        if (pendingCalibration == null) {
            pendingCalibration = PyramidGpu.calibrate(RenderSystem.getDevice().createCommandEncoder(), 100);
            calibrationFrames = 0;
        }
        PyramidGpu.Calibration c = pendingCalibration;
        if (!c.done) {
            if (++calibrationFrames == 600) fail("calibrating", new IllegalStateException("the calibration render was never read back (600 frames)"));
            return false;
        }
        if (c.error != null) {
            fail("calibrating", new IllegalStateException(c.error));
            return false;
        }
        if (c.flip[0]) {
            fail("calibrating", new IllegalStateException("the backend stores rendered columns right to left"));
            return false;
        }
        midFrameWait = c.midFrameWait;
        midFrameWaitCalibrated = c.midFrameWait;
        midFrameWaitSwitched = false;
        timeoutsInARow = 0;
        calibration = c.flip;
        QuicksilverClient.LOG.info("Quicksilver occlusion: rendered rows are stored {} first, depth {} ({}), backend {}, waiting for the GPU within a frame {}",
            calibration[1] ? "top" : "bottom", zeroToOne ? "0..1" : "-1..1 mapped to 0..1", reversed ? "greater is nearer" : "less is nearer",
            RenderSystem.getDevice().getDeviceInfo().backendName(), midFrameWait ? "works" : "does not complete (two-phase not used; still camera instead)");
        return true;
    }

    private static void verify(SplitPass sp, int w, int h) {
        boolean counting = GpuCounters.enabled;
        GpuCounters.enabled = false;
        try {
            if (!sp.suspend()) {
                OcclusionStats.verifySkipped++;
                return;
            }
            CommandEncoder enc = RenderSystem.getDevice().createCommandEncoder();
            GpuTextureView ct = GPU.checkTarget(w, h);
            try (RenderPass vp = enc.createRenderPass(() -> "Quicksilver occlusion check", ct, Optional.of(PyramidGpu.CHECK_CLEAR), sp.depth,
                OptionalDouble.empty())) {
                sp.replay(vp, true);
                TerrainRenderer.drawCulledForCheck(vp);
            }
            int sections = TerrainRenderer.culledCount();
            Frame f = frame;
            // read back when the GPU is done (no wait in the frame: not every backend can); the next check waits for it
            GPU.checkPixelsLater(enc, px -> {
                OcclusionStats.checked(sections, px, counting);
                if (px != 0) {
                    QuicksilverClient.LOG.warn("Quicksilver occlusion check: {} pixel(s) of {} culled section(s) would have been visible (mode {})",
                        px < 0 ? "unknown (timeout)" : px, sections, f);
                }
            });
            sp.resume();
        } finally {
            GpuCounters.enabled = counting;
        }
    }

    // ---------------------------------------------------------------- state

    private static void start() {
        configured = readMode();
        if (Boolean.getBoolean("quicksilver.ci.measureOnly")) {
            state = "off";
            reason = "measure run";
            return;
        }
        if (configured == Mode.OFF) {
            state = "off";
            reason = "occlusion=off";
            QuicksilverClient.LOG.info("Quicksilver occlusion: off (config)");
            return;
        }
        try {
            DepthStencilState ds = DepthStencilState.DEFAULT;
            String op = String.valueOf(ds.depthTest()).toUpperCase(Locale.ROOT);
            if (op.contains("GREATER")) reversed = true;
            else if (!op.contains("LESS")) throw new IllegalStateException("vanilla's depth test is " + op);
            zeroToOne = RenderSystem.getDevice().getDeviceInfo().isZZeroToOne();
            conventionKnown = true;
            String broken = PyramidGpu.compileAll();
            if (broken != null) throw new IllegalStateException(broken);
            state = "on";
            reason = "mode " + configured.name().toLowerCase(Locale.ROOT).replace('_', '-');
            QuicksilverClient.LOG.info("Quicksilver occlusion: on, {}", reason);
        } catch (Throwable t) {
            fail("starting", t);
        }
    }

    /** Turns the module off for the session (package 2's culling stays); deferred sections of this frame still draw. */
    static void fail(String where, Throwable t) {
        if (!"off".equals(state)) QuicksilverClient.LOG.error("Quicksilver occlusion: turned off ({}), package 2's culling stays", where, t);
        state = "off";
        reason = where + ": " + t;
        fallbacks++;
    }

    static Mode readMode() {
        String v = System.getProperty("quicksilver.occlusion");
        if (v == null) {
            Path file = FabricLoader.getInstance().getConfigDir().resolve("quicksilver.properties");
            if (Files.exists(file)) {
                Properties p = new Properties();
                try (InputStream in = Files.newInputStream(file)) {
                    p.load(in);
                    v = p.getProperty("occlusion");
                } catch (Exception e) {
                    QuicksilverClient.LOG.warn("Quicksilver occlusion: could not read {}; occlusion=auto", file, e);
                }
            }
        }
        if (v == null) return Mode.AUTO;
        switch (v.trim().toLowerCase(Locale.ROOT)) {
            case "auto": return Mode.AUTO;
            case "two-phase": return Mode.TWO_PHASE;
            case "still-camera": return Mode.STILL_CAMERA;
            case "off": return Mode.OFF;
            default:
                QuicksilverClient.LOG.warn("Quicksilver occlusion: occlusion={} is not auto, two-phase, still-camera or off; auto", v);
                return Mode.AUTO;
        }
    }

    static String frameName() {
        return frame.name().toLowerCase(Locale.ROOT).replace('_', '-');
    }

    static boolean indirectFrame() {
        return indirectFrame;
    }

    static long readBytes() {
        return GPU.readBytes;
    }
}
