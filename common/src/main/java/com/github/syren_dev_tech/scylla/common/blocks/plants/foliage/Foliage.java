package com.github.syren_dev_tech.scylla.common.blocks.plants.foliage;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Foliage {

    public static final Supplier<GrassBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.GRASS));
    }

    public static final Supplier<GrassBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.GRASS), creativeTab);
    }

    public static final Supplier<GrassBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new GrassBlock(properties));
    }

    public static final Supplier<GrassBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new GrassBlock(properties), creativeTab);
    }

    private Foliage() {
        // Prevent instantiation
    }
}
