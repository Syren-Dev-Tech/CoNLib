package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Cactus {

    public static final Supplier<CactusBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CACTUS));
    }

    public static final Supplier<CactusBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CACTUS), creativeTab);
    }

    public static final Supplier<CactusBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CactusBlock(properties));
    }

    public static final Supplier<CactusBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CactusBlock(properties), creativeTab);
    }

    private Cactus() {
        // Prevent instantiation
    }
}
