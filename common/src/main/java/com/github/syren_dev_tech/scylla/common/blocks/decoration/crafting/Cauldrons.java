package com.github.syren_dev_tech.scylla.common.blocks.decoration.crafting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CauldronBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Liquid filled ones...

public class Cauldrons {

    public static final Supplier<CauldronBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CAULDRON));
    }

    public static final Supplier<CauldronBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CAULDRON), creativeTab);
    }

    public static final Supplier<CauldronBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CauldronBlock(properties));
    }

    public static final Supplier<CauldronBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CauldronBlock(properties), creativeTab);
    }

    private Cauldrons() {
        // Prevent instantiation
    }
}
