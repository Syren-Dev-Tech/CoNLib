package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class Mushrooms {

    public static final Supplier<MushroomBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM);
    }

    public static final Supplier<MushroomBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.RED_MUSHROOM), TreeFeatures.HUGE_RED_MUSHROOM, creativeTab);
    }

    // Cannot define methods that implement features and creative tab because
    // they're the same type.

    public static final Supplier<MushroomBlock> create(ModRegister register, String name, Properties properties, ResourceKey<ConfiguredFeature<?, ?>> feature) {
        return register.blockRegistry.register(name, () -> new MushroomBlock(properties, feature));
    }

    public static final Supplier<MushroomBlock> create(ModRegister register, String name, Properties properties, ResourceKey<ConfiguredFeature<?, ?>> feature, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new MushroomBlock(properties, feature), creativeTab);
    }

    private Mushrooms() {
        // Prevent instantiation
    }
}
