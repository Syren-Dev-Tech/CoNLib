package com.github.syren_dev_tech.scylla.common.blocks.decoration.infested;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedRotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class InfestedPillarBlocks {

    public static final Supplier<InfestedRotatedPillarBlock> create(ModRegister register, String name, Block hostBlock) {
        return create(register, name, hostBlock, Properties.copy(hostBlock));
    }

    public static final Supplier<InfestedRotatedPillarBlock> create(ModRegister register, String name, Block hostBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, hostBlock, Properties.copy(hostBlock), creativeTab);
    }

    public static final Supplier<InfestedRotatedPillarBlock> create(ModRegister register, String name, Block hostBlock, Properties properties) {
        return register.blockRegistry.register(name, () -> new InfestedRotatedPillarBlock(hostBlock, properties));
    }

    public static final Supplier<InfestedRotatedPillarBlock> create(ModRegister register, String name, Block hostBlock, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new InfestedRotatedPillarBlock(hostBlock, properties), creativeTab);
    }

    private InfestedPillarBlocks() {
        // Prevent instantiation
    }
}
