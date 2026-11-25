package com.meakaandre.quicksilver.lights;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.meakaandre.quicksilver.QuicksilverClient;
import java.io.Reader;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Package 13: how much light an item or an entity gives when it moves (0-15). An item's light is vanilla's own: the
 * light its block gives (a torch item gives a torch's 14), unless a data file says otherwise; an entity type gives light
 * only from a data file (blazes, magma cubes...). Data files: {@code assets/<namespace>/quicksilver/dynamic_lights/*.json}
 * in any resource pack or mod, so a modded torch or lamp needs no code:
 *
 * <pre>{"items": {"minecraft:lava_bucket": 15}, "entities": {"minecraft:blaze": 10}}</pre>
 *
 * Files are read in name order and a later file's value for the same id replaces an earlier one; a resource pack higher
 * in the list replaces a lower pack's file of the same name (vanilla's rule). Read on every resource reload (and the
 * first time it is needed); ids that don't exist are skipped (a mod that isn't installed).
 */
public final class LightData {
    private LightData() {
    }

    private static volatile Map<Item, Integer> items = Map.of();
    private static volatile Map<EntityType<?>, Integer> entities = Map.of();
    /** Per item: the light it gives, worked out once (vanilla's value or the data file's). */
    private static final Map<Item, Integer> ITEM_CACHE = new IdentityHashMap<>();
    private static volatile boolean loaded;
    static volatile int files, itemEntries, entityEntries, skipped;
    /** Set by the resource-reload hook (the bench reports it; CI fails without it). */
    public static volatile boolean reloadHookSeen;

    /** The light an item stack gives (0-15). Render thread. */
    public static int item(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return 0;
        if (!loaded) reload(Minecraft.getInstance().getResourceManager());
        Item item = stack.getItem();
        Integer cached = ITEM_CACHE.get(item);
        if (cached != null) return cached;
        Integer data = items.get(item);
        int v;
        if (data != null) {
            v = data;
        } else if (item instanceof BlockItem b) {
            v = b.getBlock().defaultBlockState().getLightEmission();
        } else {
            v = 0;
        }
        v = Math.max(0, Math.min(15, v));
        ITEM_CACHE.put(item, v);
        return v;
    }

    /** The light an entity type gives by itself (0-15; burning and held items are counted elsewhere). */
    public static int entity(EntityType<?> type) {
        if (!loaded) reload(Minecraft.getInstance().getResourceManager());
        Integer v = entities.get(type);
        return v == null ? 0 : v;
    }

    /** Reads every data file again (resource reload). */
    public static synchronized void reload(ResourceManager manager) {
        Map<Item, Integer> it = new HashMap<>();
        Map<EntityType<?>, Integer> en = new HashMap<>();
        int f = 0, ni = 0, ne = 0, skip = 0;
        if (manager != null) {
            Map<Identifier, Resource> found = new TreeMap<>(manager.listResources("quicksilver/dynamic_lights", id -> id.getPath().endsWith(".json")));
            for (Map.Entry<Identifier, Resource> e : found.entrySet()) {
                try (Reader r = e.getValue().openAsReader()) {
                    JsonObject o = JsonParser.parseReader(r).getAsJsonObject();
                    f++;
                    if (o.has("items")) {
                        for (Map.Entry<String, JsonElement> x : o.getAsJsonObject("items").entrySet()) {
                            Identifier id = Identifier.tryParse(x.getKey());
                            // a value that isn't a number skips that entry only
                            if (!x.getValue().isJsonPrimitive() || !x.getValue().getAsJsonPrimitive().isNumber()) {
                                skip++;
                                continue;
                            }
                            if (id == null || !BuiltInRegistries.ITEM.containsKey(id)) {
                                skip++;
                                continue;
                            }
                            it.put(BuiltInRegistries.ITEM.getValue(id), clamp(x.getValue().getAsInt()));
                            ni++;
                        }
                    }
                    if (o.has("entities")) {
                        for (Map.Entry<String, JsonElement> x : o.getAsJsonObject("entities").entrySet()) {
                            Identifier id = Identifier.tryParse(x.getKey());
                            // a value that isn't a number skips that entry only
                            if (!x.getValue().isJsonPrimitive() || !x.getValue().getAsJsonPrimitive().isNumber()) {
                                skip++;
                                continue;
                            }
                            if (id == null || !BuiltInRegistries.ENTITY_TYPE.containsKey(id)) {
                                skip++;
                                continue;
                            }
                            en.put(BuiltInRegistries.ENTITY_TYPE.getValue(id), clamp(x.getValue().getAsInt()));
                            ne++;
                        }
                    }
                } catch (Exception ex) {
                    QuicksilverClient.LOG.warn("Quicksilver dynamic lights: could not read {}: {}", e.getKey(), ex.toString());
                }
            }
        }
        items = it;
        entities = en;
        ITEM_CACHE.clear();
        files = f;
        itemEntries = ni;
        entityEntries = ne;
        skipped = skip;
        loaded = true;
        QuicksilverClient.LOG.info("Quicksilver dynamic lights: {} data files, {} items, {} entity types ({} unknown ids skipped)", f, ni, ne, skip);
    }

    private static int clamp(int v) {
        return Math.max(0, Math.min(15, v));
    }
}
