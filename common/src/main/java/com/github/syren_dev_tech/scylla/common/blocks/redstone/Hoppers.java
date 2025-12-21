package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Hoppers {

    public static final Supplier<HopperBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.HOPPER));
    }

    public static final Supplier<HopperBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.HOPPER), creativeTab);
    }

    public static final Supplier<HopperBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new HopperBlock(properties));
    }

    public static final Supplier<HopperBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new HopperBlock(properties), creativeTab);
    }

    private Hoppers() {
        // Prevent instantiation
    }
}
