package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Mosses {

    public static final Supplier<MossBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.MOSS_BLOCK));
    }

    public static final Supplier<MossBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.MOSS_BLOCK), creativeTab);
    }

    public static final Supplier<MossBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new MossBlock(properties));
    }

    public static final Supplier<MossBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new MossBlock(properties), creativeTab);
    }

    private Mosses() {
        // Prevent instantiation
    }
}
