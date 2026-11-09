package com.meakaandre.quicksilver.mesher;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.meakaandre.quicksilver.QuicksilverClient;
import com.meakaandre.quicksilver.animation.Animation;
import com.meakaandre.quicksilver.bench.BenchRun;
import com.meakaandre.quicksilver.terrain.Terrain;
import com.meakaandre.quicksilver.terrain.TerrainStats;
import com.mojang.blaze3d.vertex.VertexSorting;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.BiConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.SectionBufferBuilderPack;
import net.minecraft.client.renderer.block.BlockStateModelSet;
import net.minecraft.client.renderer.block.FluidRenderer;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.chunk.CompiledSectionMesh;
import net.minecraft.client.renderer.chunk.RenderSectionRegion;
import net.minecraft.client.renderer.chunk.SectionCompiler;
import net.minecraft.client.renderer.chunk.SectionRenderDispatcher;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.lwjgl.system.MemoryUtil;

/**
 * Quicksilver's section mesher (design doc, package 4c), in place of vanilla's section compiler: vanilla still decides
 * which sections to mesh and when, runs the task on its worker threads and swaps the finished mesh in; the body of
 * {@code SectionCompiler.compile} is Quicksilver's ({@link MeshWorker}). The section is copied once into a snapshot,
 * meshed with Quicksilver's block renderer (the Fabric Renderer API implementation of package 4) and its own fluid
 * mesher, and written straight into the 16-byte terrain vertex, grouped by facing; the terrain module takes the result
 * as it is ({@link #take}).
 *
 * <p>It meshes only while the terrain module takes every layer (solid, cutout and translucent), since only the terrain
 * module can draw its vertex. A section it cannot hold in that vertex (a position or UV out of range, a colour alpha)
 * is handed to vanilla's compiler, as before. Anything unexpected turns it off for the session with one ERROR line:
 * vanilla's compiler meshes every section from then on, and what Quicksilver meshed stays drawn (it is correct).
 *
 * <p>Compatibility: vanilla's own block-entity step still runs for every block entity (mods take block entities over
 * there, e.g. Flywheel); fluids a mod draws through Fabric API's fluid handlers go through vanilla's fluid renderer. If
 * a mod Quicksilver doesn't know changes vanilla's section compiler or region copy, vanilla's compiler keeps meshing
 * (one WARN line names the mixins); if one changes vanilla's fluid renderer, that mod's own fluids go through vanilla's
 * renderer (every fluid, if the mixin's mod can't be found), and every other fluid is still compared with vanilla's
 * renderer once before Quicksilver draws it ({@link FluidProbe}).
 */
public final class Mesher {
    private Mesher() {
    }

    /** CI only: Quicksilver's mesh of every section is checked against vanilla's compiler's, vertex for vertex. */
    static final boolean VERIFY = Boolean.getBoolean("quicksilver.debug.verifyMesher");
    /** Debug: vanilla's compiler meshes every section (as before package 4c). */
    private static final boolean VANILLA = Boolean.getBoolean("quicksilver.debug.vanillaMesher");

    private enum State { STARTING, ON, OFF }

    private static volatile State state = State.STARTING;
    private static volatile String reason = "waiting for the first section";
    /** Whether every fluid goes through vanilla's fluid renderer (a mod Quicksilver can't name changes it). */
    static volatile boolean fluidsThroughVanilla;
    /**
     * The mods (by id, which is their fluids' namespace) that change vanilla's fluid renderer: their fluids go through
     * it (package 5, Andre 2026-11-04: only The Sift's own fluids, not every fluid, while The Sift is installed).
     */
    static volatile java.util.Set<String> fluidModsThroughVanilla = java.util.Set.of();

    private static final java.util.concurrent.atomic.AtomicLong CHECK_ORDER = new java.util.concurrent.atomic.AtomicLong();
    /**
     * Each meshing thread's mesher. Vanilla's worker pool retires idle threads, so every mesher is also listed with its
     * thread, and {@link #sweep} frees the native buffers of those whose thread has ended.
     */
    private static final ThreadLocal<MeshWorker> WORKER = new ThreadLocal<>();
    private static final java.util.concurrent.ConcurrentHashMap<Thread, MeshWorker> WORKERS = new java.util.concurrent.ConcurrentHashMap<>();
    static final java.util.concurrent.atomic.AtomicLong WORKERS_FREED = new java.util.concurrent.atomic.AtomicLong();
    private static long lastSweep;

    private static MeshWorker worker() {
        MeshWorker w = WORKER.get();
        if (w == null) {
            w = new MeshWorker();
            WORKER.set(w);
            WORKERS.put(Thread.currentThread(), w);
        }
        return w;
    }

    static int workersLive() {
        return WORKERS.size();
    }

    /** Render thread, once a frame: frees (every few seconds) the meshers of threads that have ended. */
    public static void sweep() {
        long now = System.nanoTime();
        if (now - lastSweep < 5_000_000_000L) return;
        lastSweep = now;
        WORKERS.entrySet().removeIf(e -> {
            if (e.getKey().isAlive()) return false;
            try {
                e.getValue().free();
            } catch (Throwable t) {
                QuicksilverClient.LOG.warn("Quicksilver mesher: freeing an ended thread's buffers failed", t);
            }
            WORKERS_FREED.incrementAndGet();
            return true;
        });
    }
    private static final Map<SectionCompiler, Object[]> COMPILER_PARTS = new WeakHashMap<>();

    public static String state() {
        return state.name().toLowerCase(java.util.Locale.ROOT);
    }

    public static String reason() {
        return reason;
    }

    /** {@code SectionCompiler.compile}, as wrapped by Quicksilver's mixin: Quicksilver's mesh, or vanilla's. */
    @SuppressWarnings("unchecked")
    public static SectionCompiler.Results compile(SectionCompiler compiler, boolean ao, BlockColors colors, SectionPos section,
                                                  RenderSectionRegion region, VertexSorting sorting, SectionBufferBuilderPack pack,
                                                  Operation<SectionCompiler.Results> original,
                                                  BiConsumer<SectionCompiler.Results, BlockEntity> handleBlockEntity) {
        MeshWorker worker = null;
        SectionCompiler.Results checkFirst = null, mine = null;
        try {
            if (state == State.STARTING) start();
            if (state != State.ON || !Terrain.takingAllLayers()) {
                if (state == State.ON) MesherStats.vanilla("the terrain module is not taking every layer");
                return original.call(section, region, sorting, pack);
            }
            worker = worker();
            Object[] parts = parts(compiler);
            // CI's check meshes each section with both meshers; every other section vanilla's goes first, so neither gets
            // the warm caches of the other in the like-for-like timing
            boolean check = VERIFY && !BenchRun.running();
            if (check) FluidSelfTest.runOnce(worker, ((ThreadLocal<FluidRenderer>) parts[1]).get(), region.cardinalLighting(), region.getLightEngine());
            boolean vanillaFirst = check && (CHECK_ORDER.getAndIncrement() & 1) == 1;
            SectionCompiler.Results first = null;
            long firstNanos = 0;
            if (vanillaFirst) {
                long v0 = System.nanoTime();
                first = MesherCheck.vanilla(section, region, sorting, pack, original);
                firstNanos = System.nanoTime() - v0;
                checkFirst = first;
            }
            long t0 = System.nanoTime();
            SectionCompiler.Results results;
            Animation.notAUseEnter();
            try {
                results = worker.compile(compiler, ao, colors, (BlockStateModelSet) parts[0], ((ThreadLocal<FluidRenderer>) parts[1]).get(), section, region,
                    sorting, handleBlockEntity);
            } finally {
                Animation.notAUseExit();
            }
            long nanos = System.nanoTime() - t0;
            if (results == null) {
                MesherStats.vanilla(worker.declined);
                if (first != null) return first;
                return original.call(section, region, sorting, pack);
            }
            mine = results;
            TerrainStats.meshed(nanos);
            MesherStats.meshed(nanos);
            if (VERIFY) {
                if (!check) {
                    MesherStats.checkSkipped();
                } else {
                    String bad;
                    if (first != null) {
                        bad = MesherCheck.compareWith(worker, section, results, Math.max(1, nanos - worker.probeNanos), first, firstNanos, true);
                        checkFirst = null; // closed by the comparison: no longer a fallback
                    } else {
                        long v0 = System.nanoTime();
                        SectionCompiler.Results v = MesherCheck.vanilla(section, region, sorting, pack, original);
                        bad = MesherCheck.compareWith(worker, section, results, Math.max(1, nanos - worker.probeNanos), v, System.nanoTime() - v0, false);
                    }
                    if (bad != null) {
                        // light and blocks are read from the live level by both meshers, so the world may have changed
                        // between the two (light still spreading, say): both mesh the section again, one right after the
                        // other, and only a difference that stays counts
                        mine = null;
                        // the first mesh is dropped: let go of its layers before meshing again (they share the thread's buffers)
                        for (com.mojang.blaze3d.vertex.MeshData m : results.renderedLayers.values()) m.close();
                        SectionCompiler.Results again;
                        Animation.notAUseEnter();
                        try {
                            again = worker.compile(compiler, ao, colors, (BlockStateModelSet) parts[0], ((ThreadLocal<FluidRenderer>) parts[1]).get(),
                                section, region, sorting, handleBlockEntity);
                        } finally {
                            Animation.notAUseExit();
                        }
                        if (again == null) {
                            MesherStats.MISMATCHED.incrementAndGet();
                            MesherCheck.warn(MesherCheck.where(section) + bad + " (and meshing again went to vanilla's compiler: " + worker.declined + ")");
                            MesherStats.vanilla(worker.declined);
                            return original.call(section, region, sorting, pack);
                        }
                        mine = again;
                        results = again;
                        String still = MesherCheck.compareWith(worker, section, again, 0, MesherCheck.vanilla(section, region, sorting, pack, original), 0, false);
                        if (still == null) {
                            MesherStats.CHANGED_DURING_CHECK.incrementAndGet();
                        } else {
                            MesherStats.MISMATCHED.incrementAndGet();
                            MesherCheck.warn(MesherCheck.where(section) + still + " (the first time: " + bad + ")");
                        }
                    }
                }
            }
            return results;
        } catch (Throwable t) {
            if (t instanceof VirtualMachineError e) throw e;
            if (mine != null) {
                // Quicksilver's mesh is done (its block entities handed over): what failed came after it (CI's check
                // with vanilla's side, or the bookkeeping); Quicksilver's mesh stands
                if (VERIFY) {
                    MesherStats.MISMATCHED.incrementAndGet();
                    MesherCheck.warn("section " + section.x() + " " + section.y() + " " + section.z() + ": failed after Quicksilver's mesh was done: " + t);
                } else {
                    QuicksilverClient.LOG.warn("Quicksilver mesher: a failure after section {} was meshed (the mesh stands)", section, t);
                }
                return mine;
            }
            if (worker != null && worker.handedBlockEntities) {
                // a mod's block-entity hook failed while Quicksilver handed the section's block entities over: vanilla's
                // compiler would have failed the same way, and handing them over again could take them twice
                worker.output.clear();
                fail("handing block entities over in section " + section, t);
                throw t instanceof RuntimeException r ? r : new RuntimeException(t);
            }
            if (worker != null) worker.output.clear();
            fail("meshing section " + section, t);
            if (checkFirst != null) return checkFirst;
            return original.call(section, region, sorting, pack);
        }
    }

    /**
     * The section's block-state models and fluid renderer as the compiler that asked holds them (its own, so a section
     * meshed during a resource reload uses what vanilla's would): its fields of those types.
     */
    private record LastParts(SectionCompiler compiler, Object[] parts) {
    }

    /** The parts of the compiler asked for last (vanilla keeps one compiler until a reload): no lock per section. */
    private static volatile LastParts lastParts;

    private static Object[] parts(SectionCompiler compiler) throws ReflectiveOperationException {
        LastParts last = lastParts;
        if (last != null && last.compiler() == compiler) return last.parts();
        Object[] found = partsLocked(compiler);
        lastParts = new LastParts(compiler, found);
        return found;
    }

    private static Object[] partsLocked(SectionCompiler compiler) throws ReflectiveOperationException {
        synchronized (COMPILER_PARTS) {
            Object[] p = COMPILER_PARTS.get(compiler);
            if (p != null) return p;
            BlockStateModelSet models = null;
            FluidRenderer fluids = null;
            for (Field f : SectionCompiler.class.getDeclaredFields()) {
                if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) continue;
                if (BlockStateModelSet.class.isAssignableFrom(f.getType())) {
                    f.setAccessible(true);
                    models = (BlockStateModelSet) f.get(compiler);
                } else if (FluidRenderer.class.isAssignableFrom(f.getType())) {
                    f.setAccessible(true);
                    fluids = (FluidRenderer) f.get(compiler);
                }
            }
            if (models == null) models = Minecraft.getInstance().getModelManager().getBlockStateModelSet();
            if (fluids == null) {
                // vanilla makes its fluid renderer as it meshes, from the fluid models the compiler holds (or the model
                // manager's): Quicksilver makes one the same way, with the constructor that takes them
                Object fluidModels = null;
                for (Field f : SectionCompiler.class.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) continue;
                    if (net.minecraft.client.renderer.block.FluidStateModelSet.class.isAssignableFrom(f.getType())) {
                        f.setAccessible(true);
                        fluidModels = f.get(compiler);
                    }
                }
                if (fluidModels == null) fluidModels = Minecraft.getInstance().getModelManager().getFluidStateModelSet();
                java.lang.reflect.Constructor<?> make = null;
                for (java.lang.reflect.Constructor<?> c : FluidRenderer.class.getDeclaredConstructors()) {
                    Class<?>[] params = c.getParameterTypes();
                    if (params.length == 1 && params[0].isInstance(fluidModels)) make = c;
                }
                if (make == null) throw new IllegalStateException("no way to make vanilla's fluid renderer from its fluid models");
                make.setAccessible(true);
                // one per meshing thread, as vanilla makes one per section it meshes
                java.lang.reflect.Constructor<?> ctor = make;
                Object models0 = fluidModels;
                ThreadLocal<FluidRenderer> perThread = ThreadLocal.withInitial(() -> {
                    try {
                        return (FluidRenderer) ctor.newInstance(models0);
                    } catch (ReflectiveOperationException e) {
                        throw new IllegalStateException(e);
                    }
                });
                p = new Object[] {models, perThread};
                COMPILER_PARTS.put(compiler, p);
                return p;
            }
            FluidRenderer shared = fluids;
            p = new Object[] {models, ThreadLocal.withInitial(() -> shared)};
            COMPILER_PARTS.put(compiler, p);
            return p;
        }
    }

    /** Once, at the first section: on, or off with the reason (measure runs, the debug switch, a mod changing the compiler). */
    private static synchronized void start() {
        if (state != State.STARTING) return;
        if ((Boolean.getBoolean("quicksilver.ci.measureOnly") || Boolean.getBoolean("quicksilver.debug.diagOff.mesher"))) {
            off("measure only (CI)", false);
            return;
        }
        if (VANILLA) {
            off("quicksilver.debug.vanillaMesher is set", false);
            QuicksilverClient.LOG.warn("Quicksilver debug: quicksilver.debug.vanillaMesher is set, vanilla's section compiler meshes every section");
            return;
        }
        // package 5: what Mixin reports as applied to the compiler (every mod, Quicksilver's included), so the foreign-mixin
        // check below can be seen working in CI's logs
        QuicksilverClient.LOG.info("Quicksilver mesher: mixins applied to vanilla's section compiler (Quicksilver's included): {}", appliedMixins("net/minecraft/client/renderer/chunk/SectionCompiler"));
        List<String> compiler = foreignMixins("net/minecraft/client/renderer/chunk/SectionCompiler");
        compiler.addAll(foreignMixins("net/minecraft/client/renderer/chunk/RenderSectionRegion"));
        if (!compiler.isEmpty()) {
            off("mods change vanilla's section compiler or region: " + String.join(", ", compiler), false);
            // one line, naming each mixin
            QuicksilverClient.LOG.warn("Quicksilver mesher: off for the session (vanilla's section compiler meshes every section): {}",
                String.join("; ", compiler));
            return;
        }
        List<String> plain = foreignMixins("net/minecraft/client/renderer/block/dispatch/SingleVariant");
        plain.addAll(foreignMixins("net/minecraft/client/renderer/block/dispatch/WeightedVariants"));
        plain.addAll(foreignMixins("net/minecraft/client/resources/model/SimpleModelWrapper"));
        plain.addAll(foreignMixins("net/minecraft/client/resources/model/geometry/QuadCollection"));
        if (!plain.isEmpty()) {
            HiddenBlocks.off = true;
            QuicksilverClient.LOG.warn("Quicksilver mesher: every block is asked of its model, because mods Quicksilver doesn't know change vanilla's"
                + " plain models: {}", String.join(", ", plain));
        }
        List<String> fluids = foreignMixins("net/minecraft/client/renderer/block/FluidRenderer");
        if (!fluids.isEmpty()) {
            java.util.Set<String> mods = new java.util.TreeSet<>();
            boolean unknown = false;
            for (String line : fluids) {
                String mod = line.startsWith("mixin ") ? modOf(line.substring("mixin ".length())) : null;
                if (mod == null) unknown = true;
                else mods.add(mod);
            }
            if (unknown) {
                fluidsThroughVanilla = true;
                QuicksilverClient.LOG.warn("Quicksilver mesher: every fluid goes through vanilla's fluid renderer, because mods Quicksilver doesn't know"
                    + " change it: {}", String.join(", ", fluids));
            } else {
                fluidModsThroughVanilla = java.util.Set.copyOf(mods);
                QuicksilverClient.LOG.warn("Quicksilver mesher: the fluids of {} go through vanilla's fluid renderer, because those mods change it: {};"
                    + " every other fluid is compared with vanilla's renderer before Quicksilver draws it", String.join(", ", mods), String.join(", ", fluids));
            }
        }
        state = State.ON;
        reason = "on";
        QuicksilverClient.LOG.info("Quicksilver mesher: on (Quicksilver meshes sections in place of vanilla's section compiler: a snapshot of"
            + " each section, blocks through Quicksilver's Fabric Renderer API renderer, {} fluids, 16-byte vertices written directly)",
            fluidsThroughVanilla ? "vanilla's renderer for"
                : fluidModsThroughVanilla.isEmpty() ? "its own mesher for vanilla and Fabric API model"
                : "vanilla's renderer for " + String.join(", ", fluidModsThroughVanilla) + "'s and its own mesher for other");
        if (VERIFY) QuicksilverClient.LOG.info("Quicksilver mesher: per-section check on (debug; outside benches every section Quicksilver meshes"
            + " is also meshed by vanilla's compiler and compared vertex for vertex)");
    }

    /**
     * Hooks other mods' mixins add that Quicksilver's mesher keeps, by mixin and merged member (Mixin renames handlers
     * with a prefix and keeps the handler's own name at the end), so anything else the same mixin class adds later is
     * still caught.
     */
    private static final String[][] KEPT = {
        // Flywheel hooks vanilla's block-entity step, which Quicksilver's mesher calls for every block entity
        {"dev.engine_room.flywheel.impl.mixin.visualmanage.SectionCompilerMixin", "flywheel$tryAddBlockEntity"},
        // the same hook as Create Fly bundles it (package 5): it cancels vanilla's step for the block entities it draws
        {"com.zurrtum.create.client.mixin.SectionCompilerMixin", "flywheel$tryAddBlockEntity"},
        // Create Fly's model mixin only makes SimpleModelWrapper.bake return Create's own part class for OBJ models;
        // the hidden-block check takes parts of exactly vanilla's class, so those are always asked of their model
        {"com.zurrtum.create.client.mixin.SimpleModelWrapperMixin", "$bake"},
    };

    /** Mixins applied to a vanilla class by mods other than Quicksilver and Fabric API, but for the hooks in {@link #KEPT}. */
    private static List<String> foreignMixins(String internalName) {
        List<String> out = new ArrayList<>();
        try {
            for (String[] m : mergedMembers(internalName)) {
                String n = m[0];
                if (n.startsWith("com.meakaandre.quicksilver.") || n.startsWith("net.fabricmc.fabric.")) continue;
                boolean kept = false;
                for (String[] k : KEPT) kept |= n.equals(k[0]) && m[1].endsWith(k[1]);
                if (kept) continue;
                String line = "mixin " + n;
                if (!out.contains(line)) out.add(line);
            }
        } catch (Throwable t) {
            out.add("(could not read the mixins applied to " + internalName + ": " + t + ")");
        }
        return out;
    }

    /** The id of the mod whose jar holds a (mixin) class, or null if none does. */
    private static String modOf(String className) {
        String path = className.replace('.', '/') + ".class";
        try {
            for (net.fabricmc.loader.api.ModContainer mod : net.fabricmc.loader.api.FabricLoader.getInstance().getAllMods()) {
                String id = mod.getMetadata().getId();
                if (id.equals("minecraft") || id.equals("java")) continue;
                if (mod.findPath(path).isPresent()) return id;
            }
        } catch (Throwable t) {
            if (t instanceof VirtualMachineError e) throw e;
        }
        return null;
    }

    /** Every mixin applied to a class, Quicksilver's included (diagnostic, package 5). */
    private static String appliedMixins(String internalName) {
        try {
            java.util.Set<String> all = new java.util.TreeSet<>();
            for (String[] m : mergedMembers(internalName)) all.add(m[0]);
            return all.isEmpty() ? "(none)" : String.join(", ", all);
        } catch (Throwable t) {
            return "(could not read: " + t + ")";
        }
    }

    /**
     * Every method and field mixins merged into a class, as {mixin, member name}, read from the {@code @MixinMerged}
     * marks Mixin leaves on them (runtime retention; injector handlers and overwrites included). Package 5: until then
     * this asked Mixin's {@code ClassInfo} of the target for its applied mixins, but Mixin records those on the mixin's
     * own class info, so the target's list was always empty and no foreign mixin was ever seen. Not seen either way:
     * changes that merge nothing (a final made mutable, access wideners) and mixins into supertypes or interfaces.
     */
    private static List<String[]> mergedMembers(String internalName) throws ClassNotFoundException {
        Class<?> c = Class.forName(internalName.replace('/', '.'), false, Mesher.class.getClassLoader());
        List<String[]> out = new ArrayList<>();
        for (java.lang.reflect.Method m : c.getDeclaredMethods()) {
            org.spongepowered.asm.mixin.transformer.meta.MixinMerged a = m.getAnnotation(org.spongepowered.asm.mixin.transformer.meta.MixinMerged.class);
            if (a != null) out.add(new String[] {a.mixin(), m.getName()});
        }
        for (java.lang.reflect.Field f : c.getDeclaredFields()) {
            org.spongepowered.asm.mixin.transformer.meta.MixinMerged a = f.getAnnotation(org.spongepowered.asm.mixin.transformer.meta.MixinMerged.class);
            if (a != null) out.add(new String[] {a.mixin(), f.getName()});
        }
        return out;
    }

    private static void off(String why, boolean failure) {
        state = State.OFF;
        reason = why;
    }

    /** Something unexpected: off for the session, vanilla's compiler meshes from now on. Any thread. */
    static void fail(String where, Throwable t) {
        synchronized (Mesher.class) {
            if (state == State.OFF) return;
            state = State.OFF;
            reason = where + ": " + t;
        }
        MesherStats.FALLBACKS.incrementAndGet();
        QuicksilverClient.LOG.error("Quicksilver mesher: turned off, vanilla's section compiler meshes every section from now on (fallback in {})",
            where, t);
    }

    /**
     * Where vanilla hands a freshly meshed layer to its GPU upload (the same thread, right after the compile): true if
     * it is a layer Quicksilver meshed, now taken by the terrain module as it is. Vanilla's own layers return false.
     */
    public static boolean take(SectionRenderDispatcher.RenderSection section, ChunkSectionLayer layer, CompiledSectionMesh mesh,
                               ByteBuffer vertices, ByteBuffer indices) {
        if (vertices == null) return false;
        MeshWorker worker = WORKER.get();
        if (worker == null) return false;
        MesherOutput out = worker.output;
        if (!out.active) return false;
        int li = layer == ChunkSectionLayer.SOLID ? 0 : layer == ChunkSectionLayer.CUTOUT ? 1 : layer == ChunkSectionLayer.TRANSLUCENT ? 2 : -1;
        if (li < 0) return false;
        MesherOutput.LayerOut lo = out.layers[li];
        if (!lo.present || lo.taken || lo.vertexAddress != MemoryUtil.memAddress(vertices) || lo.vertexBytes != vertices.remaining()) return false;
        lo.taken = true;
        Animation.meshLayerFound(mesh, out.spriteTable, out.found, out.cutoutFound);
        java.nio.ByteBuffer owned = lo.owned;
        lo.owned = null; // the terrain module owns it from here (and frees it)
        Terrain.takeMeshed(section, layer, mesh, owned, lo.vertices, lo.positionsRounded, lo.uvsRounded, lo.faces, indices, lo.centroids);
        return true;
    }
}
