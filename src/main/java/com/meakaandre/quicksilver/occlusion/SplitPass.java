package com.meakaandre.quicksilver.occlusion;

import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import org.joml.Vector4fc;

/**
 * Vanilla's main render pass (solid terrain, then entities, then translucent), wrapped so Quicksilver can close it after
 * solid terrain, work on the depth image outside any pass (package 2b), and open it again on the same attachments
 * without clearing them; vanilla keeps calling the same object throughout and never sees the switch.
 *
 * <p>Only renderpearl's public API is used: the wrapper is a {@link Proxy} of the {@link RenderPass} interface that
 * forwards every call to the pass currently open, and records the state calls (uniforms, pipeline, vertex and index
 * buffers, scissor) so that a re-opened pass gets the same bindings back. It refuses to split inside a debug group.
 */
public final class SplitPass implements InvocationHandler {
    private final Function<Object, RenderPass> open;
    private final Object descriptor;
    private RenderPass inner;
    private boolean closed;
    private int debugDepth;
    /** Calls to replay on a re-opened pass, keyed so a later call replaces an earlier one of the same kind. */
    private final Map<String, Object[]> state = new LinkedHashMap<>();
    private final Map<String, Method> methods = new LinkedHashMap<>();
    /** The pass's attachments (from its descriptor). */
    final GpuTextureView depth;
    final List<GpuTextureView> colors;

    private SplitPass(RenderPass inner, Object descriptor, Function<Object, RenderPass> open, GpuTextureView depth, List<GpuTextureView> colors) {
        this.inner = inner;
        this.descriptor = descriptor;
        this.open = open;
        this.depth = depth;
        this.colors = colors;
    }

    /** Wraps {@code pass}, created from {@code descriptor}; {@code open} creates a pass from a descriptor. */
    /** The depth attachment's view of a pass descriptor, or null if it has none. */
    static GpuTextureView depthOf(Object descriptor) {
        try {
            for (RecordComponent c : descriptor.getClass().getRecordComponents()) {
                Object v = c.getAccessor().invoke(descriptor);
                if (v != null && v.getClass().isRecord() && c.getName().toLowerCase(java.util.Locale.ROOT).contains("depth")) return viewOf(v);
            }
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("could not read the main pass's attachments: " + e, e);
        }
        return null;
    }

    static RenderPass wrap(RenderPass pass, Object descriptor, Function<Object, RenderPass> open) {
        List<GpuTextureView> views = new ArrayList<>();
        GpuTextureView depth = null;
        try {
            for (RecordComponent c : descriptor.getClass().getRecordComponents()) {
                Object v = c.getAccessor().invoke(descriptor);
                if (v instanceof List<?> l) {
                    for (Object a : l) {
                        GpuTextureView view = viewOf(a);
                        if (view != null) views.add(view);
                    }
                } else if (v != null && v.getClass().isRecord() && c.getName().toLowerCase(java.util.Locale.ROOT).contains("depth")) {
                    depth = viewOf(v);
                }
            }
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("could not read the main pass's attachments: " + e, e);
        }
        if (depth == null) throw new GpuOcclusion.NoDepth();
        SplitPass h = new SplitPass(pass, descriptor, open, depth, views);
        return (RenderPass) Proxy.newProxyInstance(RenderPass.class.getClassLoader(), new Class<?>[] {RenderPass.class}, h);
    }

    /** The handler of a pass made by {@link #wrap}, or null. */
    static SplitPass of(RenderPass pass) {
        if (pass != null && Proxy.isProxyClass(pass.getClass()) && Proxy.getInvocationHandler(pass) instanceof SplitPass s) return s;
        return null;
    }

    private static GpuTextureView viewOf(Object attachment) throws ReflectiveOperationException {
        if (attachment instanceof GpuTextureView v) return v;
        if (attachment == null || !attachment.getClass().isRecord()) return null;
        for (RecordComponent c : attachment.getClass().getRecordComponents()) {
            Object v = c.getAccessor().invoke(attachment);
            if (v instanceof GpuTextureView view) return view;
        }
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if (method.getDeclaringClass() == Object.class) {
            return switch (name) {
                case "equals" -> proxy == args[0];
                case "hashCode" -> System.identityHashCode(proxy);
                case "toString" -> "Quicksilver split pass over " + inner;
                default -> method.invoke(this, args);
            };
        }
        if (name.equals("close")) {
            if (!closed) {
                closed = true;
                if (inner != null) inner.close();
                inner = null;
            }
            return null;
        }
        if (inner == null) throw new IllegalStateException("Quicksilver split pass used while suspended: " + name);
        record(method, args);
        try {
            return method.invoke(inner, args);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    /** A call this class does not know whether it sets state (null: none yet), see {@link #record}. */
    private String unknownState;

    String unknownState() {
        return unknownState;
    }

    private void record(Method m, Object[] args) {
        String name = m.getName();
        String key = switch (name) {
            case "setUniform" -> "u:" + args[0];
            case "setVertexBuffer" -> "v:" + args[0];
            case "setIndexBuffer" -> "i";
            case "setPipeline" -> "p";
            case "enableScissor", "disableScissor" -> "s";
            case "pushDebugGroup" -> {
                debugDepth++;
                yield null;
            }
            case "popDebugGroup" -> {
                debugDepth--;
                yield null;
            }
            default -> {
                // any other call that is not a draw may set pass state this class does not replay (one a later
                // renderpearl adds): the pass is then never split
                if (!name.startsWith("draw")) unknownState = name;
                yield null;
            }
        };
        if (key == null) return;
        // a uniform keeps its first position (the order vanilla bound things in), with its latest value
        state.put(key, args == null ? new Object[0] : args.clone());
        methods.put(key, m);
    }

    /** Closes the open pass. False (nothing done) inside a debug group, after an unknown call, or when it can't be split. */
    boolean suspend() {
        if (inner == null || closed || debugDepth != 0 || unknownState != null) return false;
        inner.close();
        inner = null;
        return true;
    }

    /** Opens the pass again on the same attachments, keeping what is in them, and binds the recorded state again. */
    void resume() {
        if (inner != null || closed) return;
        inner = open.apply(withoutClears(descriptor));
        replay(inner, false);
    }

    boolean suspended() {
        return inner == null && !closed;
    }

    /**
     * Binds the recorded uniforms (and with {@code all}, the pipeline, buffers and scissor) on another pass: CI's
     * occlusion check draws in a pass of its own with vanilla's projection, fog and terrain uniforms.
     */
    void replay(RenderPass target, boolean uniformsOnly) {
        for (var e : state.entrySet()) {
            if (uniformsOnly && !e.getKey().startsWith("u:")) continue;
            try {
                methods.get(e.getKey()).invoke(target, e.getValue());
            } catch (InvocationTargetException ex) {
                throw new IllegalStateException("could not bind " + e.getKey() + " again: " + ex.getCause(), ex.getCause());
            } catch (IllegalAccessException ex) {
                throw new IllegalStateException(ex);
            }
        }
    }

    /**
     * The descriptor with every clear left out (attachments loaded as they are): clear colours ({@code Optional} of a
     * colour) and clear depth ({@code OptionalDouble}) emptied, records rebuilt through their canonical constructors.
     */
    static Object withoutClears(Object o) {
        if (o == null) return null;
        if (o instanceof OptionalDouble) return OptionalDouble.empty();
        if (o instanceof Optional<?> opt) return opt.isEmpty() || opt.get() instanceof Vector4fc ? Optional.empty() : o;
        if (o instanceof List<?> l) {
            List<Object> out = new ArrayList<>(l.size());
            for (Object x : l) out.add(withoutClears(x));
            return List.copyOf(out);
        }
        if (o instanceof Enum<?> e && e.name().equals("CLEAR")) {
            for (Object c : e.getDeclaringClass().getEnumConstants()) if (((Enum<?>) c).name().equals("LOAD")) return c;
            return o;
        }
        Class<?> c = o.getClass();
        if (!c.isRecord() || !c.getName().startsWith("com.mojang.renderpearl.")) return o;
        try {
            RecordComponent[] rc = c.getRecordComponents();
            Object[] values = new Object[rc.length];
            Class<?>[] types = new Class<?>[rc.length];
            for (int i = 0; i < rc.length; i++) {
                values[i] = withoutClears(rc[i].getAccessor().invoke(o));
                types[i] = rc[i].getType();
            }
            var ctor = c.getDeclaredConstructor(types);
            ctor.setAccessible(true);
            return ctor.newInstance(values);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("could not re-open the main pass without clearing it: " + e, e);
        }
    }
}
