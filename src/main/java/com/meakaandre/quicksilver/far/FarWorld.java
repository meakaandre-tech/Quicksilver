package com.meakaandre.quicksilver.far;

import io.netty.buffer.Unpooled;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.InflaterInputStream;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySynchronization;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.tags.TagNetworkSerialization;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.RandomState;

/**
 * Package 12: where far terrain's generator comes from. Single player: the integrated server's own levels (their
 * generators and random states, the world's seed). A server running Quicksilver: its handshake ({@link FarNet}), decoded
 * here with vanilla's registry loader into registries of the client's own, and each dimension's generator with a
 * random state made from the seed it sent. Never anything guessed: a dimension with no generator here gets no source.
 */
abstract class FarWorld {
    /** The most the server's world data may inflate to on the client. */
    static final int MAX_RAW = 256 << 20;

    /** The source for a dimension (null: not noise-based, or not known here), made for one sampling thread. */
    abstract FarSource source(ResourceKey<Level> dimension);

    /** Whether the dimension's generator is known here at all (then a null source means: not noise-based). */
    abstract boolean knows(ResourceKey<Level> dimension);

    abstract String describe();

    /**
     * Package 12c: what a dimension's sampled tiles depend on, for the disk cache (another identity empties it): single
     * player, the world's seed, the dimension's generator as its codec writes it and the data packs; a server, a hash of
     * its whole handshake. Null: nothing to cache (real chunks only).
     */
    String identity(ResourceKey<Level> dimension) {
        return null;
    }

    static String sha256(byte[] data) {
        try {
            byte[] d = java.security.MessageDigest.getInstance("SHA-256").digest(data);
            StringBuilder b = new StringBuilder();
            for (byte x : d) b.append(String.format("%02x", x));
            return b.toString();
        } catch (Exception e) {
            return Integer.toHexString(java.util.Arrays.hashCode(data));
        }
    }

    /**
     * Package 12b: a server that runs Quicksilver but doesn't share its seed (the default): no generator for any
     * dimension, so far terrain is drawn from real chunks only (land the client has had).
     */
    static FarWorld realOnly(String why) {
        return new FarWorld() {
            @Override
            FarSource source(ResourceKey<Level> dimension) {
                return null;
            }

            @Override
            boolean knows(ResourceKey<Level> dimension) {
                return false;
            }

            @Override
            boolean shares() {
                return false;
            }

            @Override
            String describe() {
                return "real chunks only (" + why + ")";
            }
        };
    }

    /** Whether this world came with a generator at all (false: a server that doesn't share its seed). */
    boolean shares() {
        return true;
    }

    /** Single player: the integrated server's levels. */
    static FarWorld of(MinecraftServer server) {
        return new FarWorld() {
            private String spIdentity;

            @Override
            FarSource source(ResourceKey<Level> dimension) {
                ServerLevel l = server.getLevel(dimension);
                if (l == null) return null;
                return FarSource.of(l.getChunkSource().getGenerator(), l.getChunkSource().randomState(), l, l.dimensionType().hasCeiling(),
                    l.dimensionType().logicalHeight(), server.registryAccess(), l.getSeed());
            }

            @Override
            boolean knows(ResourceKey<Level> dimension) {
                return server.getLevel(dimension) != null;
            }

            @Override
            String describe() {
                return "the integrated server's generators";
            }

            @Override
            String identity(ResourceKey<Level> dimension) {
                ServerLevel l = server.getLevel(dimension);
                if (l == null) return null;
                // the seed, every world registry's contents and every dimension's level stem, as a server's handshake packs
                // them (review: the generator's codec wrote only registry names, so a world-gen mod's update under the
                // same name kept its old land cached), hashed once per world
                if (spIdentity == null) {
                    try {
                        spIdentity = "single player " + sha256(FarNet.write(server));
                    } catch (Throwable t) {
                        spIdentity = "single player seed " + l.getSeed() + " packs " + server.getPackRepository().getSelectedIds();
                    }
                }
                return spIdentity;
            }
        };
    }

    /** A server's handshake data (deflated, {@link FarNet#write}); throws if it can't be read or loaded. Any thread. */
    static FarWorld decode(byte[] deflated) throws Exception {
        String handshake = sha256(deflated);
        byte[] raw;
        try (InflaterInputStream in = new InflaterInputStream(new ByteArrayInputStream(deflated))) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(deflated.length * 4);
            byte[] chunk = new byte[65536];
            for (int n; (n = in.read(chunk)) > 0; ) {
                bos.write(chunk, 0, n);
                if (bos.size() > MAX_RAW) throw new IllegalStateException("the server's world data inflates past " + (MAX_RAW >> 20) + " MB");
            }
            raw = bos.toByteArray();
        }
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.wrappedBuffer(raw));
        int version = buf.readVarInt();
        if (version != FarNet.VERSION) throw new IllegalStateException("handshake version " + version + ", not " + FarNet.VERSION);
        long seed = buf.readLong();
        int regs = buf.readVarInt();
        Map<ResourceKey<? extends Registry<?>>, RegistryDataLoader.NetworkedRegistryData> data = new HashMap<>();
        for (int r = 0; r < regs; r++) {
            Identifier id = buf.readIdentifier();
            int n = buf.readVarInt();
            List<RegistrySynchronization.PackedRegistryEntry> entries = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                Identifier eid = buf.readIdentifier();
                java.util.Optional<net.minecraft.nbt.Tag> entryData = buf.readBoolean()
                    ? java.util.Optional.of(buf.readNbt(net.minecraft.nbt.NbtAccounter.create(64L << 20))) : java.util.Optional.empty();
                entries.add(new RegistrySynchronization.PackedRegistryEntry(eid, entryData));
            }
            TagNetworkSerialization.NetworkPayload tags = TagNetworkSerialization.NetworkPayload.STREAM_CODEC.decode(buf);
            data.put(ResourceKey.createRegistryKey(id), new RegistryDataLoader.NetworkedRegistryData(entries, tags));
        }
        int dims = buf.readVarInt();
        Map<Identifier, Tag> stems = new HashMap<>();
        for (int i = 0; i < dims; i++) {
            Identifier id = buf.readIdentifier();
            stems.put(id, buf.readNbt(net.minecraft.nbt.NbtAccounter.create(64L << 20)));
        }
        RegistryAccess.Frozen statics = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
        List<HolderLookup.RegistryLookup<?>> context = statics.listRegistries().toList();
        RegistryAccess.Frozen loaded = RegistryDataLoader.load(data, ResourceProvider.EMPTY, context, net.fabricmc.fabric.api.event.registry.DynamicRegistries.getWorldRegistries(),
            net.minecraft.util.Util.backgroundExecutor()).join();
        HolderLookup.Provider all = HolderLookup.Provider.create(Stream.concat(context.stream(), loaded.listRegistries()));
        RegistryOps<Tag> ops = RegistryOps.create(NbtOps.INSTANCE, all);
        Map<Identifier, LevelStem> decoded = new HashMap<>();
        List<String> failed = new ArrayList<>();
        for (Map.Entry<Identifier, Tag> e : stems.entrySet()) {
            var res = LevelStem.CODEC.parse(ops, e.getValue());
            if (res.result().isPresent()) decoded.put(e.getKey(), res.result().get());
            else failed.add(e.getKey() + " (" + res.error().map(Object::toString).orElse("?") + ")");
        }
        if (!failed.isEmpty()) FarNet.LOG.warn("Quicksilver far terrain: the server's dimensions {} could not be read; far terrain stays off there", failed);
        HolderLookup.RegistryLookup<net.minecraft.world.level.levelgen.synth.NormalNoise> noises = all.lookupOrThrow(Registries.NOISE);
        int entries = data.values().stream().mapToInt(d -> d.elements().size()).sum();
        return new FarWorld() {
            @Override
            FarSource source(ResourceKey<Level> dimension) {
                LevelStem stem = decoded.get(dimension.identifier());
                if (stem == null) return null;
                DimensionType type = stem.type().value();
                LevelHeightAccessor height = LevelHeightAccessor.create(type.minY(), type.height());
                if (!(stem.generator() instanceof NoiseBasedChunkGenerator n)) return null;
                RandomState random = RandomState.create(noises, seed, n.generatorSettings().value());
                return FarSource.of(n, random, height, type.hasCeiling(), type.logicalHeight(), loaded, seed);
            }

            @Override
            boolean knows(ResourceKey<Level> dimension) {
                return decoded.containsKey(dimension.identifier());
            }

            @Override
            String describe() {
                return "the server's generators (" + decoded.size() + " dimensions, " + entries + " registry entries, " + deflated.length / 1024 + " KB)";
            }

            @Override
            String identity(ResourceKey<Level> dimension) {
                return decoded.containsKey(dimension.identifier()) ? "server handshake " + handshake : null;
            }
        };
    }
}
