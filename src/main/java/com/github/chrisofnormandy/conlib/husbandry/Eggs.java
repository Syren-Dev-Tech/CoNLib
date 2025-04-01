package com.github.chrisofnormandy.conlib.husbandry;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.husbandry.types.Egg;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Eggs {

    public static final <T extends Animal> Supplier<Egg<T>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.SNIFFER_EGG));
    }

    public static final <T extends Animal> Supplier<Egg<T>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.SNIFFER_EGG), creativeTab);
    }

    public static final <T extends Animal> Supplier<Egg<T>> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new Egg<T>(properties));
    }

    public static final <T extends Animal> Supplier<Egg<T>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new Egg<T>(properties), creativeTab);
    }

    private Eggs() {
        // Prevent instantiation
    }
}
