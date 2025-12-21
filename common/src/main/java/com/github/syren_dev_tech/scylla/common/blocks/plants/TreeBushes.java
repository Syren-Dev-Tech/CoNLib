package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.AzaleaBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Needs custom implementation...

public class TreeBushes {

    public static final Supplier<AzaleaBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.AZALEA));
    }

    public static final Supplier<AzaleaBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.AZALEA), creativeTab);
    }

    public static final Supplier<AzaleaBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new AzaleaBlock(properties));
    }

    public static final Supplier<AzaleaBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new AzaleaBlock(properties), creativeTab);
    }

    private TreeBushes() {
        // Prevent instantiation
    }
}
