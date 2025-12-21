package com.github.syren_dev_tech.scylla.common.blocks.decoration.crafting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Furnaces {

    public static final Supplier<FurnaceBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FURNACE));
    }

    public static final Supplier<FurnaceBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FURNACE), creativeTab);
    }

    public static final Supplier<FurnaceBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FurnaceBlock(properties));
    }

    public static final Supplier<FurnaceBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FurnaceBlock(properties), creativeTab);
    }

    private Furnaces() {
        // Prevent instantiation
    }
}
