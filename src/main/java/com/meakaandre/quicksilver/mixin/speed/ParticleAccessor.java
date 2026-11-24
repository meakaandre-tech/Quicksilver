package com.meakaandre.quicksilver.mixin.speed;

import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/** Package A: a new particle's position, for the particle-distance option. Read only. */
@Mixin(Particle.class)
public interface ParticleAccessor {
    @Accessor("x")
    double quicksilver$x();

    @Accessor("y")
    double quicksilver$y();

    @Accessor("z")
    double quicksilver$z();
}
