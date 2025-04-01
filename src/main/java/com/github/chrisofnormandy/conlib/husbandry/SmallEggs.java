package com.github.chrisofnormandy.conlib.husbandry;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.husbandry.types.SmallEgg;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SmallEggs {

    public static final <T extends Animal> Supplier<SmallEgg<T>> create(ModRegister register, String name, EntityType<T> creature) {
        return create(register, name, Properties.copy(Blocks.TURTLE_EGG), creature);
    }

    public static final <T extends Animal> Supplier<SmallEgg<T>> create(ModRegister register, String name, EntityType<T> creature, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.TURTLE_EGG), creature, creativeTab);
    }

    public static final <T extends Animal> Supplier<SmallEgg<T>> create(ModRegister register, String name, Properties properties, EntityType<T> creature) {
        return register.blockRegistry.register(name, () -> new SmallEgg<T>(creature, properties));
    }

    public static final <T extends Animal> Supplier<SmallEgg<T>> create(ModRegister register, String name, Properties properties, EntityType<T> creature, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new SmallEgg<T>(creature, properties), creativeTab);
    }

    private SmallEggs() {
        // Prevent instantiation
    }
}
