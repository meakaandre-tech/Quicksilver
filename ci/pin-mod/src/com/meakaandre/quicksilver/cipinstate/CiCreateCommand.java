package com.meakaandre.quicksilver.cipinstate;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CI only (package 5): the two steps of the SIFTEC kinetics scene that Create has no command for, done by reflection
 * (the pin mod is compiled without Create), in every client run alike. Never registered without Create.
 * <ul>
 * <li>{@code /qsci belt X1 Y1 Z1 X2 Y2 Z2}: a belt between two shafts already placed there (Create's belt connector).</li>
 * <li>{@code /qsci train build X Y Z}: the station at X Y Z goes into assembly mode and a one-bogey carriage is built
 * behind it (a bogey, three casings, a fourth casing between two controls, glued); {@code /qsci train assemble X Y Z}
 * assembles it. The train stays at the station (no schedule). As ci/server/harness's CiTrain does.</li>
 * </ul>
 * Each step logs "Quicksilver CI create: STEP done" or "... FAILED"; CI requires the done lines.
 */
public final class CiCreateCommand implements ModInitializer {
    private static final Logger LOG = LoggerFactory.getLogger("quicksilver_ci_pin");

    @Override
    public void onInitialize() {
        try {
            Class.forName("com.zurrtum.create.content.kinetics.belt.item.BeltConnectorItem", false, getClass().getClassLoader());
        } catch (Throwable t) {
            return;
        }
        CommandRegistrationCallback.EVENT.register((dispatcher, registry, env) -> register(dispatcher));
    }

    private static void register(CommandDispatcher<CommandSourceStack> d) {
        d.register(Commands.literal("qsci")
            .then(Commands.argument("args", StringArgumentType.greedyString()).executes(c -> {
                String args = StringArgumentType.getString(c, "args");
                run(c.getSource().getLevel(), args);
                return 1;
            })));
    }

    private static void run(ServerLevel level, String args) {
        String[] p = args.trim().split("\\s+");
        try {
            switch (p[0]) {
                case "belt" -> belt(level, pos(p, 1), pos(p, 4));
                case "train" -> {
                    BlockPos station = pos(p, 2);
                    if (p[1].equals("build")) trainBuild(level, station);
                    else if (p[1].equals("assemble")) trainAssemble(level, station);
                    else throw new IllegalArgumentException("unknown train step " + p[1]);
                }
                default -> throw new IllegalArgumentException("unknown step " + p[0]);
            }
            LOG.info("Quicksilver CI create: {} done", args);
        } catch (Throwable t) {
            LOG.warn("Quicksilver CI create: {} FAILED", args, t);
        }
    }

    private static BlockPos pos(String[] p, int i) {
        return new BlockPos(Integer.parseInt(p[i]), Integer.parseInt(p[i + 1]), Integer.parseInt(p[i + 2]));
    }

    private static void belt(ServerLevel level, BlockPos a, BlockPos b) throws Exception {
        Class<?> c = Class.forName("com.zurrtum.create.content.kinetics.belt.item.BeltConnectorItem");
        Method m = null;
        for (Method x : c.getMethods()) {
            if (x.getName().equals("createBelts") && x.getParameterCount() == 3) m = x;
        }
        if (m == null) throw new NoSuchMethodException("BeltConnectorItem.createBelts");
        m.invoke(null, level, a, b);
    }

    private static void trainBuild(ServerLevel level, BlockPos at) throws Exception {
        if (train(level) != null) {
            LOG.info("Quicksilver CI create: a train is already there, not built again");
            return;
        }
        Object st = level.getBlockEntity(at);
        if (st == null) throw new IllegalStateException("no station block entity at " + at);
        if (call(st, "getStation") == null) throw new IllegalStateException("the station has no edge point on the track yet");
        call(st, "enterAssemblyMode", (Object) null);
        Direction d = (Direction) call(st, "getAssemblyDirection");
        BlockPos track = (BlockPos) call(get(st, "edgePoint"), "getGlobalPosition");
        String axis = d.getAxis().getName();
        BlockPos bogey = track.relative(d).above();
        BlockPos blaze = track.relative(d, 2).above(3);
        List<String> cmds = new ArrayList<>();
        cmds.add(set(bogey, "create:small_bogey[axis=" + axis + "]"));
        for (int i = 1; i <= 3; i++) cmds.add(set(track.relative(d, i).above(2), "create:railway_casing"));
        // a casing where CiTrain has a blaze burner: a standing train needs no conductor, and the burner's flame and
        // head move by client ticks (not Create's animation clock), so they differed between runs
        cmds.add(set(blaze, "create:railway_casing"));
        cmds.add(set(blaze.relative(d.getOpposite()), "create:controls[facing=" + d.getName() + "]"));
        cmds.add(set(blaze.relative(d), "create:controls[facing=" + d.getOpposite().getName() + "]"));
        List<BlockPos> parts = new ArrayList<>(List.of(bogey, blaze, blaze.relative(d), blaze.relative(d.getOpposite())));
        for (int i = 1; i <= 3; i++) parts.add(track.relative(d, i).above(2));
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE, z1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE, z2 = Integer.MIN_VALUE;
        for (BlockPos q : parts) {
            x1 = Math.min(x1, q.getX());
            y1 = Math.min(y1, q.getY());
            z1 = Math.min(z1, q.getZ());
            x2 = Math.max(x2, q.getX());
            y2 = Math.max(y2, q.getY());
            z2 = Math.max(z2, q.getZ());
        }
        cmds.add(String.format(java.util.Locale.ROOT, "summon create:super_glue %.1f %.1f %.1f {Box:[0d,0d,0d,%dd,",
            (x1 + x2 + 1) / 2.0, (double) y1, (z1 + z2 + 1) / 2.0, x2 - x1 + 1) + (y2 - y1 + 1) + "d," + (z2 - z1 + 1) + "d]}");
        var server = level.getServer();
        for (String c : cmds) server.getCommands().getDispatcher().execute(c, server.createCommandSourceStack().withSuppressedOutput());
    }

    private static void trainAssemble(ServerLevel level, BlockPos at) throws Exception {
        if (train(level) != null) return;
        Object st = level.getBlockEntity(at);
        call(st, "assemble", new UUID(0x51C5L, 0x7EC1L));
        if (train(level) == null) {
            Object ex = get(st, "lastException");
            throw new IllegalStateException("no train after assembly: " + (ex == null ? null : get(ex, "component")));
        }
        call(st, "exitAssemblyMode");
    }

    private static String set(BlockPos p, String state) {
        return "setblock " + p.getX() + " " + p.getY() + " " + p.getZ() + " " + state;
    }

    @SuppressWarnings("unchecked")
    private static Object train(ServerLevel level) throws Exception {
        Object manager = Class.forName("com.zurrtum.create.Create").getField("RAILWAYS").get(null);
        Object sided = call(manager, "sided", level);
        Map<UUID, ?> trains = (Map<UUID, ?>) get(sided, "trains");
        return trains.isEmpty() ? null : trains.values().iterator().next();
    }

    private static Object call(Object target, String name, Object... args) throws Exception {
        for (Class<?> c = target.getClass(); c != null; c = c.getSuperclass()) {
            for (Method m : c.getDeclaredMethods()) {
                if (m.getName().equals(name) && m.getParameterCount() == args.length) {
                    m.setAccessible(true);
                    return m.invoke(target, args);
                }
            }
        }
        throw new NoSuchMethodException(target.getClass().getName() + "." + name + "/" + args.length);
    }

    private static Object get(Object target, String name) throws Exception {
        for (Class<?> c = target.getClass(); c != null; c = c.getSuperclass()) {
            try {
                Field f = c.getDeclaredField(name);
                f.setAccessible(true);
                return f.get(target);
            } catch (NoSuchFieldException e) {
                // the superclass, then
            }
        }
        throw new NoSuchFieldException(target.getClass().getName() + "." + name);
    }
}
