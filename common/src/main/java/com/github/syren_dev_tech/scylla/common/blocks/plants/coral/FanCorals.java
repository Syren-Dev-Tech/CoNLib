package com.github.syren_dev_tech.scylla.common.blocks.plants.coral;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CoralFanBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FanCorals {

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_FAN), Blocks.DEAD_FIRE_CORAL_FAN);
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_FAN), Blocks.DEAD_FIRE_CORAL_FAN, creativeTab);
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, Blocks.DEAD_FIRE_CORAL_FAN);
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, Blocks.DEAD_FIRE_CORAL_FAN, creativeTab);
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, Block deadBlock) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_FAN), deadBlock);
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, Block deadBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FIRE_CORAL_FAN), deadBlock, creativeTab);
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, Properties properties, Block deadBlock) {
        return register.blockRegistry.register(name, () -> new CoralFanBlock(deadBlock, properties));
    }

    public static final Supplier<CoralFanBlock> create(ModRegister register, String name, Properties properties, Block deadBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CoralFanBlock(deadBlock, properties), creativeTab);
    }

    private FanCorals() {
        // Prevent instantiation
    }
}
