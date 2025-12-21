package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class PressurePlates {

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, BlockSetType.STONE);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, BlockSetType.STONE, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Sensitivity.EVERYTHING, BlockSetType.STONE);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Sensitivity.EVERYTHING, BlockSetType.STONE, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Sensitivity sensitivity) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, BlockSetType.STONE);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Sensitivity sensitivity, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, BlockSetType.STONE, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, Sensitivity sensitivity) {
        return create(register, name, properties, sensitivity, BlockSetType.STONE);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, Sensitivity sensitivity, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, sensitivity, BlockSetType.STONE, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, BlockSetType blockSetType) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, blockSetType);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), Sensitivity.EVERYTHING, blockSetType, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, BlockSetType blockSetType) {
        return create(register, name, properties, Sensitivity.EVERYTHING, blockSetType);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Sensitivity.EVERYTHING, blockSetType, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Sensitivity sensitivity, BlockSetType blockSetType) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, blockSetType);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Sensitivity sensitivity, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE_PRESSURE_PLATE), sensitivity, blockSetType, creativeTab);
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, Sensitivity sensitivity, BlockSetType blockSetType) {
        return register.blockRegistry.register(name, () -> new PressurePlateBlock(sensitivity, properties, blockSetType));
    }

    public static final Supplier<PressurePlateBlock> create(ModRegister register, String name, Properties properties, Sensitivity sensitivity, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new PressurePlateBlock(sensitivity, properties, blockSetType), creativeTab);
    }

    private PressurePlates() {
        // Prevent instantiation
    }
}
