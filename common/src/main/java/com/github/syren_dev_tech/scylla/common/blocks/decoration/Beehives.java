package com.github.syren_dev_tech.scylla.common.blocks.decoration;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Beehives {

    public static final Supplier<BeehiveBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.BEEHIVE));
    }

    public static final Supplier<BeehiveBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.BEEHIVE), creativeTab);
    }

    public static final Supplier<BeehiveBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new BeehiveBlock(properties));
    }

    public static final Supplier<BeehiveBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new BeehiveBlock(properties), creativeTab);
    }

    private Beehives() {
        // Prevent instantiation
    }
}
