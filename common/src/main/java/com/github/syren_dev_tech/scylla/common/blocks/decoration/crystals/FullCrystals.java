package com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FullCrystals {

    public static final Supplier<AmethystClusterBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.AMETHYST_CLUSTER));
    }

    public static final Supplier<AmethystClusterBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.AMETHYST_CLUSTER), creativeTab);
    }

    public static final Supplier<AmethystClusterBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new AmethystClusterBlock(7, 3, properties));
    }

    public static final Supplier<AmethystClusterBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new AmethystClusterBlock(7, 3, properties), creativeTab);
    }

    private FullCrystals() {
        // Prevent instantiation
    }
}
