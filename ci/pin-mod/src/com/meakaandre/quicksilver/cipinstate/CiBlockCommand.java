package com.meakaandre.quicksilver.cipinstate;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CI only (package 6): {@code /qscichest open|close x y z} opens or closes a chest, ender chest or shulker box's lid
 * the way a player opening it would (the block event clients animate the lid from), so the block entities scene can
 * check a lid that animates and then rests open, in every client run alike. The game has no command for it.
 */
public final class CiBlockCommand implements ModInitializer {
    private static final Logger LOG = LoggerFactory.getLogger("quicksilver_ci_pin");

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((d, registry, env) -> d.register(Commands.literal("qscichest")
            .then(Commands.argument("args", StringArgumentType.greedyString()).executes(c -> {
                run(c.getSource().getLevel(), StringArgumentType.getString(c, "args"));
                return 1;
            }))));
    }

    private static void run(ServerLevel level, String args) {
        String[] p = args.trim().split("\\s+");
        try {
            BlockPos pos = new BlockPos(Integer.parseInt(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]));
            int openers = switch (p[0]) {
                case "open" -> 1;
                case "close" -> 0;
                default -> throw new IllegalArgumentException("unknown step " + p[0]);
            };
            level.blockEvent(pos, level.getBlockState(pos).getBlock(), 1, openers);
            LOG.info("Quicksilver CI chest: {} done", args);
        } catch (Throwable t) {
            LOG.warn("Quicksilver CI chest: {} FAILED", args, t);
        }
    }
}
