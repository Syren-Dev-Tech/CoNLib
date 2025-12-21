package com.github.syren_dev_tech.scylla.common.blocks.rails;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class Rails {

    public static final Supplier<RailBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.RAIL));
    }

    public static final Supplier<RailBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.RAIL), creativeTab);
    }

    public static final Supplier<RailBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new RailBlock(properties));
    }

    public static final Supplier<RailBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new RailBlock(properties), creativeTab);
    }

    private Rails() {
        // Prevent instantiation
    }
}
