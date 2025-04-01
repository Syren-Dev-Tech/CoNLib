package com.github.chrisofnormandy.conlib.blocks.plants.melons;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.blocks.plants.melons.types.Melon;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Melons {

    public static final Supplier<Melon> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.MELON));
    }

    public static final Supplier<Melon> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.MELON), creativeTab);
    }

    public static final Supplier<Melon> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new Melon(properties));
    }

    public static final Supplier<Melon> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new Melon(properties), creativeTab);
    }

    private Melons() {
        // Prevent instantiation
    }
}
