package com.meakaandre.quicksilver.mixin.speed;

import com.meakaandre.quicksilver.speed.Speed;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Package A, options particle-distance and particle-density: a new particle is dropped before it joins the engine. Both
 * options are off by default, and then this does nothing.
 */
@Mixin(ParticleEngine.class)
public abstract class ParticleEngineSpeedMixin {
    @Inject(method = "add(Lnet/minecraft/client/particle/Particle;)V", at = @At("HEAD"), cancellable = true)
    private void quicksilver$speedAdd(Particle particle, CallbackInfo ci) {
        if (!Speed.PARTICLE_DISTANCE.on() && Speed.PARTICLE_DENSITY.value() >= 100) return;
        if (!"applied".equals(SpeedMixins.RESULT.get("ParticleAccessor"))) return;
        ParticleAccessor p = (ParticleAccessor) particle;
        if (Speed.dropNewParticle(p.quicksilver$x(), p.quicksilver$y(), p.quicksilver$z())) ci.cancel();
    }
}
