package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class TrapDoors {

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK, creativeTab);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, BlockSetType.OAK);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, BlockSetType.OAK, creativeTab);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, Block block) {
        return create(register, name, Properties.copy(block), BlockSetType.OAK);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, Block block, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(block), BlockSetType.OAK, creativeTab);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, BlockSetType blockSetType) {
        return create(register, name, Properties.copy(Blocks.OAK_TRAPDOOR), blockSetType);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_TRAPDOOR), blockSetType, creativeTab);
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, Properties properties, BlockSetType blockSetType) {
        return register.blockRegistry.register(name, () -> new TrapDoorBlock(properties, blockSetType));
    }

    public static final Supplier<TrapDoorBlock> create(ModRegister register, String name, Properties properties, BlockSetType blockSetType, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new TrapDoorBlock(properties, blockSetType), creativeTab);
    }

    private TrapDoors() {
        // Prevent instantiation
    }
}
