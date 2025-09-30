package com.github.chrisofnormandy.conlib.mobs;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.mobs.creatures.CustomCreature;
import com.github.chrisofnormandy.conlib.mobs.creatures.CustomFlyingCreature;
import com.github.chrisofnormandy.conlib.mobs.creatures.CustomSwimmingCreature;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

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
