package com.github.syren_dev_tech.scylla.common.blocks.plants.coral;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Corals {

    public static final Supplier<CoralBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), Blocks.DEAD_FIRE_CORAL_BLOCK);
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), Blocks.DEAD_FIRE_CORAL_BLOCK, creativeTab);
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Blocks.DEAD_FIRE_CORAL_BLOCK);
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Blocks.DEAD_FIRE_CORAL_BLOCK, creativeTab);
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, Block deadBlock) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), deadBlock);
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, Block deadBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_BLOCK), deadBlock, creativeTab);
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, Properties properties, Block deadBlock) {
        return register.blockRegistry.register(name, () -> new CoralBlock(deadBlock, properties));
    }

    public static final Supplier<CoralBlock> create(ModRegister register, String name, Properties properties, Block deadBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CoralBlock(deadBlock, properties), creativeTab);
    }

    private Corals() {
        // Prevent instantiation
    }
}
