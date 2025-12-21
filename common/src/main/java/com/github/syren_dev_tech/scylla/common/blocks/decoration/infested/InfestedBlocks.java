package com.github.syren_dev_tech.scylla.common.blocks.decoration.infested;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class InfestedBlocks {

    public static final Supplier<InfestedBlock> create(ModRegister register, String name, Block hostBlock) {
        return create(register, name, hostBlock, Properties.copy(hostBlock));
    }

    public static final Supplier<InfestedBlock> create(ModRegister register, String name, Block hostBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, hostBlock, Properties.copy(hostBlock), creativeTab);
    }

    public static final Supplier<InfestedBlock> create(ModRegister register, String name, Block hostBlock, Properties properties) {
        return register.blockRegistry.register(name, () -> new InfestedBlock(hostBlock, properties));
    }

    public static final Supplier<InfestedBlock> create(ModRegister register, String name, Block hostBlock, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new InfestedBlock(hostBlock, properties), creativeTab);
    }

    private InfestedBlocks() {
        // Prevent instantiation
    }
}
