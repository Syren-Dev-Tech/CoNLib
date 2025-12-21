package com.github.syren_dev_tech.scylla.common.blocks.decoration;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BellBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bells {

    public static final Supplier<BellBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.BELL));
    }

    public static final Supplier<BellBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.BELL), creativeTab);
    }

    public static final Supplier<BellBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new BellBlock(properties));
    }

    public static final Supplier<BellBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new BellBlock(properties), creativeTab);
    }

    private Bells() {
        // Prevent instantiation
    }
}
