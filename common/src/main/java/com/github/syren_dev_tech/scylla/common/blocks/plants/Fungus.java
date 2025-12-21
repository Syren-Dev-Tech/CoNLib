package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class Fungus {

    public static final Supplier<FungusBlock> create(ModRegister register, String name, Block requiredBlock) {
        return create(register, name, Properties.copy(Blocks.WARPED_FUNGUS), TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock);
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, Block requiredBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WARPED_FUNGUS), TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock, creativeTab);
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, Properties properties, Block requiredBlock) {
        return create(register, name, properties, TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock);
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, Properties properties, Block requiredBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, TreeFeatures.WARPED_FUNGUS_PLANTED, requiredBlock, creativeTab);
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock) {
        return create(register, name, Properties.copy(Blocks.WARPED_FUNGUS), feature, requiredBlock);
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WARPED_FUNGUS), feature, requiredBlock, creativeTab);
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, Properties properties, ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock) {
        return register.blockRegistry.register(name, () -> new FungusBlock(properties, feature, requiredBlock));
    }

    public static final Supplier<FungusBlock> create(ModRegister register, String name, Properties properties, ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FungusBlock(properties, feature, requiredBlock), creativeTab);
    }

    private Fungus() {
        // Prevent instantiation
    }
}
