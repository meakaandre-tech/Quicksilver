package com.meakaandre.quicksilver.cipin;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * CI only (the test pack, 2026-11-12): a connection that fails on a packet logs only "Internal Exception: ..." as its
 * disconnect reason; this logs the whole exception with its causes, so a pack mod whose packet doesn't decode (the
 * test pack's fabric:recipe_sync, in about half its client sessions, vanilla's and Quicksilver's alike) can be named.
 * Changes nothing.
 */
@Mixin(Connection.class)
public abstract class ConnectionErrorMixin {
    private static final Logger LOG = LoggerFactory.getLogger("quicksilver_ci_pin");

    @Inject(method = "exceptionCaught", at = @At("HEAD"), require = 0)
    private void quicksilverCi$log(ChannelHandlerContext ctx, Throwable cause, CallbackInfo ci) {
        LOG.error("Quicksilver CI pin: connection exception", cause);
    }
}
