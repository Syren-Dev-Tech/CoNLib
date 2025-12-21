package com.github.syren_dev_tech.scylla.common.blocks.plants.foliage;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TallFoliage {

    public static final Supplier<TallGrassBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.TALL_GRASS));
    }

    public static final Supplier<TallGrassBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.TALL_GRASS), creativeTab);
    }

    public static final Supplier<TallGrassBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new TallGrassBlock(properties));
    }

    public static final Supplier<TallGrassBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new TallGrassBlock(properties), creativeTab);
    }

    private TallFoliage() {
        // Prevent instantiation
    }
}
