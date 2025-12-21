package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class WeightedPressurePlates {
    public static final int LIGHT_WEIGHT = 15;
    public static final int HEAVY_WEIGHT = 150;

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), LIGHT_WEIGHT);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), LIGHT_WEIGHT, creativeTab);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, LIGHT_WEIGHT);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, LIGHT_WEIGHT, creativeTab);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Integer maxWeight) {
        return create(register, name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), maxWeight);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Integer maxWeight, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE), maxWeight, creativeTab);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Properties properties, Integer maxWeight) {
        return create(register, name, properties, maxWeight, BlockSetType.IRON);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Properties properties, Integer maxWeight, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, maxWeight, BlockSetType.IRON, creativeTab);
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Properties properties, Integer maxWeight, BlockSetType blockSetType) {
        return register.blockRegistry.register(name, () -> new WeightedPressurePlateBlock(maxWeight, properties, blockSetType));
    }

    public static final Supplier<WeightedPressurePlateBlock> create(ModRegister register, String name, Properties properties, Integer maxWeight, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new WeightedPressurePlateBlock(maxWeight, properties, blockSetType), creativeTab);
    }

    private WeightedPressurePlates() {
        // Prevent instantiation
    }
}
