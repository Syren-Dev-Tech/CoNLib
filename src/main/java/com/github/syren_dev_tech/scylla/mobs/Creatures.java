package com.github.syren_dev_tech.scylla.mobs;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.mobs.creatures.CustomCreature;
import com.github.syren_dev_tech.scylla.mobs.creatures.CustomFlyingCreature;
import com.github.syren_dev_tech.scylla.mobs.creatures.CustomSwimmingCreature;
import com.github.syren_dev_tech.scylla.registry.ModRegister;

import net.minecraft.world.entity.EntityType;

public class Creatures {
    public static final Supplier<EntityType<CustomCreature>> create(ModRegister register, String name) {
        return register.mobRegistry.register(name, CustomCreature::new);
    }

    public static final Supplier<EntityType<CustomCreature>> createSwimming(ModRegister register, String name) {
        return register.mobRegistry.register(name, CustomSwimmingCreature::new);
    }

    public static final Supplier<EntityType<CustomCreature>> createFlying(ModRegister register, String name) {
        return register.mobRegistry.register(name, CustomFlyingCreature::new);
    }
}
