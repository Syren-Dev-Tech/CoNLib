package com.github.syren_dev_tech.scylla.common.blocks.basic;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Stairs {

    public static final Supplier<StairBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.STONE_STAIRS), () -> Blocks.STONE);
    }

    public static final Supplier<StairBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE_STAIRS), () -> Blocks.STONE, creativeTab);
    }

    public static final Supplier<StairBlock> create(ModRegister register, String name, Supplier<Block> sourceBlock) {
        return create(register, name, Properties.copy(Blocks.STONE_STAIRS), sourceBlock);
    }

    public static final Supplier<StairBlock> create(ModRegister register, String name, Supplier<Block> sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE_STAIRS), sourceBlock, creativeTab);
    }

    public static final Supplier<StairBlock> create(ModRegister register, String name, Properties properties, Supplier<Block> sourceBlock) {
        return register.blockRegistry.register(name, () -> new StairBlock(() -> sourceBlock.get().defaultBlockState(), properties));
    }

    public static final Supplier<StairBlock> create(ModRegister register, String name, Properties properties, Supplier<Block> sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new StairBlock(() -> sourceBlock.get().defaultBlockState(), properties), creativeTab);
    }

    private Stairs() {
        // Prevent instantiation
    }
}
