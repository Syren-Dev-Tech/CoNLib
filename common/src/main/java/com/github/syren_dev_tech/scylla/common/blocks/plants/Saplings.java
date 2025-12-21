package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Saplings {

    public static final Supplier<SaplingBlock> create(ModRegister register, String name, AbstractTreeGrower treeGrower) {
        return create(register, name, Properties.copy(Blocks.OAK_SAPLING), treeGrower);
    }

    public static final Supplier<SaplingBlock> create(ModRegister register, String name, AbstractTreeGrower treeGrower, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_SAPLING), treeGrower, creativeTab);
    }

    public static final Supplier<SaplingBlock> create(ModRegister register, String name, Properties properties, AbstractTreeGrower treeGrower) {
        return register.blockRegistry.register(name, () -> new SaplingBlock(treeGrower, properties));
    }

    public static final Supplier<SaplingBlock> create(ModRegister register, String name, Properties properties, AbstractTreeGrower treeGrower, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new SaplingBlock(treeGrower, properties), creativeTab);
    }

    private Saplings() {
        // Prevent instantiation
    }
}
