package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Lily {

    public static final Supplier<WaterlilyBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.LILY_PAD));
    }

    public static final Supplier<WaterlilyBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.LILY_PAD), creativeTab);
    }

    public static final Supplier<WaterlilyBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new WaterlilyBlock(properties));
    }

    public static final Supplier<WaterlilyBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new WaterlilyBlock(properties), creativeTab);
    }

    private Lily() {
        // Prevent instantiation
    }
}
