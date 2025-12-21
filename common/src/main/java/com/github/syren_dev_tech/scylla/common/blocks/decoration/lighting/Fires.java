package com.github.syren_dev_tech.scylla.common.blocks.decoration.lighting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;

public class Fires {

    public static final Supplier<FireBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FIRE));
    }

    public static final Supplier<FireBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FIRE), creativeTab);
    }

    public static final Supplier<FireBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FireBlock(properties));
    }

    public static final Supplier<FireBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FireBlock(properties), creativeTab);
    }

    private Fires() {
        // Prevent instantiation
    }
}