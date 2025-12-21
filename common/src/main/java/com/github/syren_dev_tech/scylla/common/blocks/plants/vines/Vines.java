package com.github.syren_dev_tech.scylla.common.blocks.plants.vines;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Vines {

    public static final Supplier<VineBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.VINE));
    }

    public static final Supplier<VineBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.VINE), creativeTab);
    }

    public static final Supplier<VineBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new VineBlock(properties));
    }

    public static final Supplier<VineBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new VineBlock(properties), creativeTab);
    }

    private Vines() {
        // Prevent instantiation
    }
}
