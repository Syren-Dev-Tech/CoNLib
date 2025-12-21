package com.github.syren_dev_tech.scylla.common.blocks.basic;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FallingBlocks {

    public static final Supplier<FallingBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.SAND));
    }

    public static final Supplier<FallingBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.SAND), creativeTab);
    }

    public static final Supplier<FallingBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FallingBlock(properties));
    }

    public static final Supplier<FallingBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FallingBlock(properties), creativeTab);
    }

    private FallingBlocks() {
        // Prevent instantiation
    }
}
