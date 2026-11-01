package com.meakaandre.quicksilver.mixin.logic;

import com.meakaandre.quicksilver.logic.HopperEntities;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * P2-3, logic.hopper-entities ({@link HopperEntities}): a hopper's entity lookups (item entities above it, a container
 * entity where it takes from or gives to) answer with an empty list when no section vanilla's lookup would visit holds
 * such an entity. Redirects, so a call allocates no callback object; the hopper minecart's item lookup goes through the
 * same method and gets the same answer.
 */
@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin {
    @Redirect(method = "getItemsAtAndAbove", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/Level;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"))
    private static <T extends Entity> List<T> quicksilver$items(Level level, Class<T> cls, AABB box, Predicate<? super T> predicate) {
        if (cls == ItemEntity.class && HopperEntities.skip(level, box, true)) {
            if (!HopperEntities.VERIFY) return new ArrayList<>();
            List<T> v = level.getEntitiesOfClass(cls, box, predicate);
            HopperEntities.verify(v, "item entity");
            return v;
        }
        return level.getEntitiesOfClass(cls, box, predicate);
    }

    @Redirect(method = "getEntityContainer", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/Level;getEntities(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/AABB;Ljava/util/function/Predicate;)Ljava/util/List;"))
    private static List<Entity> quicksilver$containers(Level level, Entity except, AABB box, Predicate<? super Entity> predicate) {
        if (except == null && predicate == EntitySelector.CONTAINER_ENTITY_SELECTOR && HopperEntities.skip(level, box, false)) {
            if (!HopperEntities.VERIFY) return new ArrayList<>();
            List<Entity> v = level.getEntities(except, box, predicate);
            HopperEntities.verify(v, "container entity");
            return v;
        }
        return level.getEntities(except, box, predicate);
    }
}
