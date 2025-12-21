package com.github.syren_dev_tech.scylla.common.blocks.decoration;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Carpets {

    public static Supplier<CarpetBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.WHITE_CARPET));
    }

    public static Supplier<CarpetBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WHITE_CARPET), creativeTab);
    }

    public static Supplier<CarpetBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CarpetBlock(properties));
    }

    public static Supplier<CarpetBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CarpetBlock(properties), creativeTab);
    }

    private Carpets() {
        // Prevent instantiation
    }
}
