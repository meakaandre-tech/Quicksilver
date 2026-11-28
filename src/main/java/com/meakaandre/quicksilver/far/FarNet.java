package com.meakaandre.quicksilver.far;

import io.netty.buffer.Unpooled;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySynchronization;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagNetworkSerialization;
import net.minecraft.world.level.dimension.LevelStem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package 12: far terrain's optional handshake with a server that also runs Quicksilver. A client with far terrain on
 * asks ({@link Hello}); the server answers once with what the client needs to sample the world's own generator: the
 * world seed, every dimension's generator (its level stem) and the entries and tags of the server's world registries
 * (noise settings, density functions, noises, biomes, features...), as the server's own registries hold them, so
 * world-gen datapacks and mods (Terralith) arrive as they are. The client rebuilds them with vanilla's registry loader
 * ({@link FarWorld}). Off by default (package 12b, Andre: the seed lets players find ores, structures and bases): a
 * server sends nothing unless its owner opts in with {@code far-terrain-share=on} in {@code config/quicksilver.properties};
 * otherwise it answers with no data and a note, and the client's far terrain shows real chunks only (land it has seen).
 * Nothing is sent unless a client asks. A client on any other server never gets an answer and keeps far terrain off.
 *
 * <p>Both sides: the payload types are registered by the main entrypoint, the server's receiver too (it only ever runs
 * on a logical server); the client's receiver is {@link FarTerrain}'s.
 */
public final class FarNet {
    static final Logger LOG = LoggerFactory.getLogger("Quicksilver");

    /** Package 12c: the mod's version (the disk cache's identities hold it). */
    static String modVersion() {
        return net.fabricmc.loader.api.FabricLoader.getInstance().getModContainer("quicksilver").map(c -> c.getMetadata().getVersion().getFriendlyString()).orElse("?");
    }
    /** The handshake's version: a client and server of different versions don't talk (the client stays off). */
    public static final int VERSION = 2;
    /** The largest answer (Fabric splits it into packets); a world whose registries need more stays off. */
    static final int MAX_BYTES = 64 << 20;

    /** Client to server: far terrain is on and would like the world's generator. */
    public record Hello(int version) implements CustomPacketPayload {
        public static final Type<Hello> TYPE = new Type<>(Identifier.fromNamespaceAndPath("quicksilver", "far_hello_v2"));
        public static final StreamCodec<FriendlyByteBuf, Hello> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, Hello::version, Hello::new);

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    /**
     * Server to client: the answer. {@code data} is the deflated world data ({@link #write}), empty if the server doesn't
     * share it; {@code note} says why in that case.
     */
    public record WorldData(int version, byte[] data, String note) implements CustomPacketPayload {
        public static final Type<WorldData> TYPE = new Type<>(Identifier.fromNamespaceAndPath("quicksilver", "far_world_v2"));
        public static final StreamCodec<FriendlyByteBuf, WorldData> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, WorldData::version,
            ByteBufCodecs.byteArray(MAX_BYTES), WorldData::data, ByteBufCodecs.STRING_UTF8, WorldData::note, WorldData::new);

        @Override
        public Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }

    private static boolean registered;

    private FarNet() {
    }

    /** Main entrypoint (both sides): the payload types and the server's receiver. */
    public static void init() {
        if (registered) return;
        registered = true;
        try {
            PayloadTypeRegistry.serverboundPlay().register(Hello.TYPE, Hello.CODEC);
            PayloadTypeRegistry.clientboundPlay().registerLarge(WorldData.TYPE, WorldData.CODEC, MAX_BYTES + 4096);
            ServerPlayNetworking.registerGlobalReceiver(Hello.TYPE, (payload, context) -> hello(context.server(), context.player(), payload));
            // a stopped server (a single player world opened to LAN) is not kept by what was built for it
            net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents.SERVER_STOPPED.register(s -> {
                synchronized (FarNet.class) {
                    if (builtFor == s) {
                        builtFor = null;
                        built = null;
                    }
                }
            });
        } catch (Throwable t) {
            LOG.warn("Quicksilver far terrain: its handshake could not be registered; far terrain stays off on servers", t);
        }
    }

    /** What this server sends, built once (in the background) on the first request; null until then. */
    private static volatile CompletableFuture<byte[]> built;
    private static volatile MinecraftServer builtFor;
    /** Connections already answered. */
    private static final java.util.Set<Object> ANSWERED = java.util.Collections.newSetFromMap(new java.util.WeakHashMap<>());

    private static void hello(MinecraftServer server, ServerPlayer player, Hello payload) {
        // one answer per connection (a client asking again gets nothing more), shared or not
        synchronized (ANSWERED) {
            if (!ANSWERED.add(player.connection)) return;
        }
        if (payload.version() != VERSION) {
            ServerPlayNetworking.send(player, new WorldData(VERSION, new byte[0], "the server's Quicksilver speaks far terrain handshake " + VERSION + ", the client's " + payload.version()));
            return;
        }
        if (!shareEnabled()) {
            ServerPlayNetworking.send(player, new WorldData(VERSION, new byte[0], "this server doesn't share its world seed"));
            LOG.info("Quicksilver far terrain: {} asked for the world's generator; not shared (far-terrain-share is off, the default;"
                + " far-terrain-share=on in config/quicksilver.properties shares the seed)", player.getName().getString());
            return;
        }
        CompletableFuture<byte[]> f;
        synchronized (FarNet.class) {
            if (built == null || builtFor != server) {
                builtFor = server;
                try {
                    // encoded on the server thread's registries, compressed off it
                    byte[] raw = write(server);
                    built = CompletableFuture.supplyAsync(() -> deflate(raw), net.minecraft.util.Util.backgroundExecutor());
                    LOG.info("Quicksilver far terrain: this server shares its world seed and generator with Quicksilver clients that ask"
                        + " (far-terrain-share=on in config/quicksilver.properties; players can use the seed to find ores, structures and bases)");
                } catch (Throwable t) {
                    built = CompletableFuture.failedFuture(t);
                }
            }
            f = built;
        }
        f.whenComplete((data, err) -> server.execute(() -> {
            if (player.hasDisconnected()) return;
            if (err != null || data == null || data.length > MAX_BYTES) {
                String why = err != null ? "the server could not pack its world generator (" + err + ")" : "the server's world generator is too large to send";
                ServerPlayNetworking.send(player, new WorldData(VERSION, new byte[0], why));
                LOG.warn("Quicksilver far terrain: {}", why);
                return;
            }
            ServerPlayNetworking.send(player, new WorldData(VERSION, data, ""));
            LOG.info("Quicksilver far terrain: sent the world's generator to {} ({} KB)", player.getName().getString(), data.length / 1024);
        }));
    }

    /**
     * {@code far-terrain-share} in the server's {@code config/quicksilver.properties}: off unless it says on (package 12b:
     * the seed lets players find ores, structures and bases, so a server owner opts in). Unreadable: off.
     */
    static boolean shareEnabled() {
        try {
            Path file = FabricLoader.getInstance().getConfigDir().resolve("quicksilver.properties");
            if (!Files.exists(file)) return false;
            Properties p = new Properties();
            try (var in = Files.newInputStream(file)) {
                p.load(in);
            }
            String v = p.getProperty("far-terrain-share", "off").trim();
            return v.equalsIgnoreCase("on") || v.equalsIgnoreCase("true");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * The world data, uncompressed: version, seed, then every world registry (Fabric's {@link
     * net.fabricmc.fabric.api.event.registry.DynamicRegistries#getWorldRegistries()}: vanilla's and those mods add, such
     * as Lithostitched's, which Terralith's density functions read) as the network sync packs one (its entries in id order, each encoded with the
     * registry's own codec against the server's registries, then its tags by entry id), then every dimension's level
     * stem. Server thread.
     */
    static byte[] write(MinecraftServer server) {
        var access = server.registryAccess();
        RegistryOps<Tag> ops = RegistryOps.create(NbtOps.INSTANCE, access);
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        try {
            buf.writeVarInt(VERSION);
            buf.writeLong(server.overworld().getSeed());
            List<RegistryDataLoader.RegistryData<?>> regs = net.fabricmc.fabric.api.event.registry.DynamicRegistries.getWorldRegistries();
            buf.writeVarInt(regs.size());
            for (RegistryDataLoader.RegistryData<?> rd : regs) writeRegistry(buf, ops, access, rd);
            Registry<LevelStem> stems = access.lookupOrThrow(Registries.LEVEL_STEM);
            List<Map.Entry<Identifier, Tag>> dims = new ArrayList<>();
            for (int i = 0; i < stems.size(); i++) {
                LevelStem stem = stems.byId(i);
                Identifier id = stems.getKey(stem);
                if (stem == null || id == null) continue;
                Optional<Tag> t = LevelStem.CODEC.encodeStart(ops, stem).result();
                if (t.isPresent()) dims.add(Map.entry(id, t.get()));
                else LOG.warn("Quicksilver far terrain: dimension {} could not be encoded; far terrain stays off there", id);
            }
            buf.writeVarInt(dims.size());
            for (Map.Entry<Identifier, Tag> e : dims) {
                buf.writeIdentifier(e.getKey());
                buf.writeNbt(e.getValue());
            }
            byte[] out = new byte[buf.readableBytes()];
            buf.readBytes(out);
            return out;
        } finally {
            buf.release();
        }
    }

    private static <T> void writeRegistry(FriendlyByteBuf buf, RegistryOps<Tag> ops, net.minecraft.core.RegistryAccess access, RegistryDataLoader.RegistryData<T> rd) {
        buf.writeIdentifier(rd.key().identifier());
        Optional<? extends Registry<T>> found = access.lookup(rd.key());
        if (found.isEmpty()) {
            buf.writeVarInt(0);
            TagNetworkSerialization.NetworkPayload.STREAM_CODEC.encode(buf, TagNetworkSerialization.NetworkPayload.EMPTY);
            return;
        }
        Registry<T> reg = found.get();
        List<RegistrySynchronization.PackedRegistryEntry> entries = new ArrayList<>(reg.size());
        for (int i = 0; i < reg.size(); i++) {
            T value = reg.byId(i);
            Identifier id = value == null ? null : reg.getKey(value);
            if (id == null) continue;
            Optional<Tag> t = rd.elementCodec().encodeStart(ops, value).result();
            // an entry that can't be encoded is sent without data: the client's loader then fails this registry, and far
            // terrain stays off (never a partial world)
            entries.add(new RegistrySynchronization.PackedRegistryEntry(id, t));
        }
        buf.writeVarInt(entries.size());
        // each entry as id, then its data (an entry can be larger than the network codec's NBT limit: Terralith's biome lists)
        for (RegistrySynchronization.PackedRegistryEntry e : entries) {
            buf.writeIdentifier(e.id());
            buf.writeBoolean(e.data().isPresent());
            e.data().ifPresent(buf::writeNbt);
        }
        Map<Identifier, IntList> tags = new java.util.LinkedHashMap<>();
        reg.getTags().forEach((HolderSet.Named<T> named) -> {
            IntList ids = new IntArrayList();
            for (var h : named) ids.add(reg.getId(h.value()));
            tags.put(named.key().location(), ids);
        });
        TagNetworkSerialization.NetworkPayload.STREAM_CODEC.encode(buf, new TagNetworkSerialization.NetworkPayload(tags));
    }

    static byte[] deflate(byte[] raw) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(raw.length / 4 + 64);
        try (DeflaterOutputStream out = new DeflaterOutputStream(bos, new Deflater(6))) {
            out.write(raw);
        } catch (java.io.IOException e) {
            throw new java.io.UncheckedIOException(e);
        }
        return bos.toByteArray();
    }
}
