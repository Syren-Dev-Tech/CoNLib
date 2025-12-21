package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Explosives {

    public static final Supplier<TntBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.TNT));
    }

    public static final Supplier<TntBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.TNT), creativeTab);
    }

    public static final Supplier<TntBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new TntBlock(properties));
    }

    public static final Supplier<TntBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new TntBlock(properties), creativeTab);
    }

    private Explosives() {
        // Prevent instantiation
    }
}
