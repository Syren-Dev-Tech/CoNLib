package com.github.syren_dev_tech.scylla.common.blocks.fluids;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Ice {

    public static final Supplier<CustomIce> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.ICE));
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.ICE), creativeTab);
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, Block meltedBlock) {
        return create(register, name, Properties.copy(Blocks.ICE), meltedBlock);
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, Block meltedBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.ICE), meltedBlock, creativeTab);
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CustomIce(properties));
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CustomIce(properties), creativeTab);
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, Properties properties, Block meltedBlock) {
        return register.blockRegistry.register(name, () -> new CustomIce(properties, meltedBlock));
    }

    public static final Supplier<CustomIce> create(ModRegister register, String name, Properties properties, Block meltedBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CustomIce(properties, meltedBlock), creativeTab);
    }

    private Ice() {
        // Prevent instantiation
    }
}
