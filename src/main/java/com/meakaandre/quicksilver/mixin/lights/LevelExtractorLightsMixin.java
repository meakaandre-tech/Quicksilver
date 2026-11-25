package com.meakaandre.quicksilver.mixin.lights;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.meakaandre.quicksilver.lights.DynamicLights;
import com.meakaandre.quicksilver.lights.LightData;
import com.meakaandre.quicksilver.lights.ObjectLights;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.extract.LevelExtractor;
import net.minecraft.client.renderer.state.level.LevelRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 13: the frame's dynamic lights are found before its entities are extracted; Fancy raises each block entity's
 * light value by them; the data files are read again on a resource reload.
 */
@Mixin(LevelExtractor.class)
abstract class LevelExtractorLightsMixin {
    @Inject(method = "extractVisibleEntities", at = @At("HEAD"))
    private void quicksilver$lightsStart(Camera camera, Frustum frustum, DeltaTracker deltaTracker, LevelRenderState state, CallbackInfo ci) {
        ObjectLights.hookSeen = true;
        DynamicLights.beginFrame(deltaTracker.getGameTimeDeltaPartialTick(false));
    }

    @ModifyExpressionValue(method = "extractVisibleBlockEntities", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderDispatcher;tryExtractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;FLnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;Z)Lnet/minecraft/client/renderer/blockentity/state/BlockEntityRenderState;"))
    private BlockEntityRenderState quicksilver$blockEntityLight(BlockEntityRenderState s) {
        if (s != null) s.lightCoords = ObjectLights.blockEntity(s.lightCoords, s.blockPos.getX() + 0.5, s.blockPos.getY() + 0.5, s.blockPos.getZ() + 0.5);
        return s;
    }

    @Inject(method = "onResourceManagerReload", at = @At("HEAD"))
    private void quicksilver$lightsReload(net.minecraft.server.packs.resources.ResourceManager manager, CallbackInfo ci) {
        LightData.reloadHookSeen = true;
        LightData.reload(manager);
    }
}
