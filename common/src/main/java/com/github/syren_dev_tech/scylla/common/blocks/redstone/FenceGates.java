package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FenceGates {

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_FENCE_GATE), WoodType.OAK, creativeTab);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, WoodType.OAK);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, WoodType.OAK, creativeTab);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, WoodType woodType) {
        return create(register, name, Properties.copy(Blocks.OAK_FENCE_GATE), woodType);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, WoodType woodType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_FENCE_GATE), woodType, creativeTab);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Block sourceBlock) {
        return create(register, name, Properties.copy(sourceBlock), WoodType.OAK);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(sourceBlock), WoodType.OAK, creativeTab);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Block sourceBlock, WoodType woodType) {
        return create(register, name, Properties.copy(sourceBlock), woodType);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Block sourceBlock, WoodType woodType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(sourceBlock), woodType, creativeTab);
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Properties properties, WoodType woodType) {
        return register.blockRegistry.register(name, () -> new FenceGateBlock(properties, woodType));
    }

    public static final Supplier<FenceGateBlock> create(ModRegister register, String name, Properties properties, WoodType woodType, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FenceGateBlock(properties, woodType), creativeTab);
    }

    private FenceGates() {
        // Prevent instantiation
    }
}
