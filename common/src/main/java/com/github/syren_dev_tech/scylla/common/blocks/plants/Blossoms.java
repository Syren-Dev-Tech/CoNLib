package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SporeBlossomBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Needs custom implementation...

public class Blossoms {

    public static final Supplier<SporeBlossomBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.SPORE_BLOSSOM));
    }

    public static final Supplier<SporeBlossomBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.SPORE_BLOSSOM), creativeTab);
    }

    public static final Supplier<SporeBlossomBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new SporeBlossomBlock(properties));
    }

    public static final Supplier<SporeBlossomBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new SporeBlossomBlock(properties), creativeTab);
    }

    private Blossoms() {
        // Prevent instantiation
    }
}
