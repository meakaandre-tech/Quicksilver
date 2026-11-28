package com.meakaandre.quicksilver.far;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

/**
 * Package 12c: big structures as simple silhouettes in far terrain (Andre: villages, mansions and ocean monuments;
 * strongholds stay hidden), placed where the world's own structure sets put them from the seed alone, as {@code /locate}
 * finds them, without generating a chunk: each set's random-spread grid gives the one possible chunk per grid cell (the
 * seed and the set's salt), and the structure is drawn if the biome at that chunk's centre, at the surface, is one of its
 * biomes (close to vanilla's check, which reads the biome at the start's own position; vanilla's later checks can drop a
 * few, and a few may differ either way). Only vanilla's three sets
 * (a data pack's own sets aren't drawn). Sampling thread.
 */
final class FarStructures {
    static final int VILLAGE = 0, MANSION = 1, MONUMENT = 2;

    /** A structure's start: its chunk's centre (blocks), the kind, and which village (its structure's name, for the colours). */
    record Site(int x, int z, int kind, String variant) {
    }

    private record Group(RandomSpreadStructurePlacement placement, List<Holder<Structure>> structures, int kind) {
    }

    private final List<Group> sets = new ArrayList<>();
    private final long seed;
    private final FarSource source;
    volatile String problem;

    FarStructures(RegistryAccess access, long seed, FarSource source) {
        this.seed = seed;
        this.source = source;
        try {
            access.lookupOrThrow(Registries.STRUCTURE_SET).listElements().forEach(ref -> {
                String name = ref.key().identifier().toString();
                int kind = switch (name) {
                    case "minecraft:villages" -> VILLAGE;
                    case "minecraft:woodland_mansions" -> MANSION;
                    case "minecraft:ocean_monuments" -> MONUMENT;
                    default -> -1;
                };
                if (kind < 0) return;
                StructureSet set = ref.value();
                StructurePlacement p = set.placement();
                if (!(p instanceof RandomSpreadStructurePlacement rsp)) return;
                List<Holder<Structure>> list = new ArrayList<>();
                for (StructureSet.StructureSelectionEntry e : set.structures()) list.add(e.structure());
                sets.add(new Group(rsp, list, kind));
            });
        } catch (Throwable t) {
            problem = t.toString();
        }
    }

    /** The structures whose start chunk lies in the tile (tx, tz) (128 x 128 blocks). */
    List<Site> in(int tx, int tz) {
        if (sets.isEmpty()) return List.of();
        List<Site> out = new ArrayList<>();
        int cx0 = tx * (FarTiles.TILE / 16), cz0 = tz * (FarTiles.TILE / 16), cx1 = cx0 + FarTiles.TILE / 16 - 1, cz1 = cz0 + FarTiles.TILE / 16 - 1;
        for (Group s : sets) {
            try {
                int spacing = s.placement().spacing();
                for (int rz = Math.floorDiv(cz0, spacing); rz <= Math.floorDiv(cz1, spacing); rz++) {
                    for (int rx = Math.floorDiv(cx0, spacing); rx <= Math.floorDiv(cx1, spacing); rx++) {
                        ChunkPos c = s.placement().getPotentialStructureChunk(seed, rx * spacing, rz * spacing);
                        if (c.x() < cx0 || c.x() > cx1 || c.z() < cz0 || c.z() > cz1) continue;
                        int x = c.x() * 16 + 8, z = c.z() * 16 + 8;
                        FarSource.Heights h = source.heights(x, z);
                        if (h == null) continue;
                        int y = s.kind() == MONUMENT ? source.seaLevel : h.solidTop();
                        Holder<Biome> b = source.biome(x, y, z);
                        for (Holder<Structure> st : s.structures()) {
                            if (!st.value().biomes().contains(b)) continue;
                            out.add(new Site(x, z, s.kind(), st.unwrapKey().map(k -> k.identifier().getPath()).orElse("")));
                            break;
                        }
                    }
                }
            } catch (Throwable t) {
                problem = t.toString();
            }
        }
        return out;
    }
}
