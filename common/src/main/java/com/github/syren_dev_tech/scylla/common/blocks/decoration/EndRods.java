package com.github.syren_dev_tech.scylla.common.blocks.decoration;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class EndRods {

    public static Supplier<EndRodBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.END_ROD));
    }

    public static Supplier<EndRodBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.END_ROD), creativeTab);
    }

    public static Supplier<EndRodBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new EndRodBlock(properties));
    }

    public static Supplier<EndRodBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new EndRodBlock(properties), creativeTab);
    }

    private EndRods() {
        // Prevent instantiation
    }
}
