package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Doors {

    public static final Supplier<DoorBlock> create(ModRegister register, String name) {
        return create(register, name, Blocks.OAK_DOOR, BlockSetType.OAK);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Blocks.OAK_DOOR, BlockSetType.OAK, creativeTab);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, BlockSetType.OAK);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, BlockSetType.OAK, creativeTab);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, BlockSetType blockSetType) {
        return create(register, name, Blocks.OAK_DOOR, blockSetType);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Blocks.OAK_DOOR, blockSetType, creativeTab);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Block sourceBlock) {
        return create(register, name, Properties.copy(sourceBlock), BlockSetType.OAK);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Block sourceBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(sourceBlock), BlockSetType.OAK, creativeTab);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Block sourceBlock, BlockSetType blockSetType) {
        return create(register, name, Properties.copy(sourceBlock), blockSetType);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Block sourceBlock, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(sourceBlock), blockSetType, creativeTab);
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Properties properties, BlockSetType blockSetType) {
        return register.blockRegistry.register(name, () -> new DoorBlock(properties.noOcclusion(), blockSetType));
    }

    public static final Supplier<DoorBlock> create(ModRegister register, String name, Properties properties, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new DoorBlock(properties.noOcclusion(), blockSetType), creativeTab);
    }

    private Doors() {
        // Prevent instantiation
    }
}