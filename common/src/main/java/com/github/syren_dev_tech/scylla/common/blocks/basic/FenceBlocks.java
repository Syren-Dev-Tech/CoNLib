package com.github.syren_dev_tech.scylla.common.blocks.basic;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class FenceBlocks {

    public static final Supplier<FenceBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.OAK_FENCE));
    }

    public static final Supplier<FenceBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_FENCE), creativeTab);
    }

    public static final Supplier<FenceBlock> create(ModRegister register, String name, Block sourceBlock) {
        return create(register, name, Properties.copy(sourceBlock));
    }

    public static final Supplier<FenceBlock> create(ModRegister register, String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(sourceBlock), creativeTab);
    }

    public static final Supplier<FenceBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FenceBlock(properties));
    }

    public static final Supplier<FenceBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FenceBlock(properties), creativeTab);
    }

    private FenceBlocks() {
        // Prevent instantiation
    }
}
