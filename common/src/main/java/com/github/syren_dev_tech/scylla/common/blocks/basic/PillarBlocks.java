package com.github.syren_dev_tech.scylla.common.blocks.basic;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PillarBlocks {

    public static final Supplier<RotatedPillarBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.DIRT));
    }

    public static final Supplier<RotatedPillarBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.DIRT), creativeTab);
    }

    public static final Supplier<RotatedPillarBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new RotatedPillarBlock(properties));
    }

    public static final Supplier<RotatedPillarBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new RotatedPillarBlock(properties), creativeTab);
    }

    private PillarBlocks() {
        // Prevent instantiation
    }
}
