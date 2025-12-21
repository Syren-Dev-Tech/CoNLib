package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RedstoneTorches {

    public static final Supplier<RedstoneTorchBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.REDSTONE_TORCH));
    }

    public static final Supplier<RedstoneTorchBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.REDSTONE_TORCH), creativeTab);
    }

    public static final Supplier<RedstoneTorchBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new RedstoneTorchBlock(properties));
    }

    public static final Supplier<RedstoneTorchBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new RedstoneTorchBlock(properties), creativeTab);
    }

    private RedstoneTorches() {
        // Prevent instantiation
    }
}
