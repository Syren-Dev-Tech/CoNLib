package com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CrystalBlocks {

    public static final Supplier<AmethystBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.AMETHYST_BLOCK));
    }

    public static final Supplier<AmethystBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.AMETHYST_BLOCK), creativeTab);
    }

    public static final Supplier<AmethystBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new AmethystBlock(properties));
    }

    public static final Supplier<AmethystBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new AmethystBlock(properties), creativeTab);
    }

    private CrystalBlocks() {
        // Prevent instantiation
    }
}
