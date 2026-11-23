package com.meakaandre.quicksilver.mixin.entity;

import com.meakaandre.quicksilver.entity.EntityAtlas;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.SubmitNodeCollection;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.UvMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package 6: a model submit whose texture can go to the entity atlas is made again with the atlas render type and the
 * texture's slot as its mapping ({@link EntityAtlas}); every other submit is vanilla's, untouched.
 */
@Mixin(SubmitNodeCollection.class)
public abstract class SubmitNodeCollectionMixin {
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Inject(method = "submitModel(Lnet/minecraft/client/model/Model;Ljava/lang/Object;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/rendertype/RenderType;IIILnet/minecraft/client/renderer/texture/UvMapping;I)V",
        at = @At("HEAD"), cancellable = true)
    private void quicksilver$entityAtlas(Model model, Object state, PoseStack pose, RenderType type, int light, int overlay, int tint,
                                         UvMapping uv, int outline, CallbackInfo ci) {
        if (!EntityAtlas.redirect(type, uv, outline)) return;
        ci.cancel();
        // the atlas render type's texture is a page, never a plain texture again, so this submit is not redirected twice
        ((SubmitNodeCollection) (Object) this).submitModel(model, state, pose, EntityAtlas.outType, light, overlay, tint, EntityAtlas.outUv, outline);
    }
}
