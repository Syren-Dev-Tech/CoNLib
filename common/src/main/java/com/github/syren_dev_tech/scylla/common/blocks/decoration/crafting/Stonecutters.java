package com.github.syren_dev_tech.scylla.common.blocks.decoration.crafting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Stonecutters {

    public static final Supplier<StonecutterBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.STONECUTTER));
    }

    public static final Supplier<StonecutterBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONECUTTER), creativeTab);
    }

    public static final Supplier<StonecutterBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new StonecutterBlock(properties));
    }

    public static final Supplier<StonecutterBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new StonecutterBlock(properties), creativeTab);
    }

    private Stonecutters() {
        // Prevent instantiation
    }
}
