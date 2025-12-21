package com.github.syren_dev_tech.scylla.common.blocks.rails;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ActivatorRails {

    public static final Supplier<PoweredRailBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.ACTIVATOR_RAIL));
    }

    public static final Supplier<PoweredRailBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.ACTIVATOR_RAIL), creativeTab);
    }

    public static final Supplier<PoweredRailBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new PoweredRailBlock(properties));
    }

    public static final Supplier<PoweredRailBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new PoweredRailBlock(properties), creativeTab);
    }

    private ActivatorRails() {
        // Prevent instantiation
    }
}
