package com.github.syren_dev_tech.scylla.common.effects.particles;

import net.minecraft.core.particles.SimpleParticleType;

public class ModParticle extends SimpleParticleType {
    public ModParticle() {
        super(false);
    }

    public ModParticle(boolean overrideLimiter) {
        super(overrideLimiter);
    }
}
