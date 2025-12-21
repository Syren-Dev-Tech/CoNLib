package com.github.syren_dev_tech.scylla.common.blocks.misc;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.basic.FullBlocks;
import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Concrete {
    public static class ConcretePowders {

        public static final Supplier<ConcretePowderBlock> create(ModRegister register, String name, Block hardenedBlock) {
            return create(register, name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA), hardenedBlock);
        }

        public static final Supplier<ConcretePowderBlock> create(ModRegister register, String name, Block hardenedBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA), hardenedBlock, creativeTab);
        }

        public static final Supplier<ConcretePowderBlock> create(ModRegister register, String name, Properties properties, Block hardenedBlock) {
            return register.blockRegistry.register(name, () -> new ConcretePowderBlock(hardenedBlock, properties));
        }

        public static final Supplier<ConcretePowderBlock> create(ModRegister register, String name, Properties properties, Block hardenedBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new ConcretePowderBlock(hardenedBlock, properties), creativeTab);
        }

        private ConcretePowders() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<Block>, Supplier<ConcretePowderBlock>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.WHITE_CONCRETE), Properties.copy(Blocks.WHITE_CONCRETE_POWDER));
    }

    public static final Tuple<Supplier<Block>, Supplier<ConcretePowderBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WHITE_CONCRETE), Properties.copy(Blocks.WHITE_CONCRETE_POWDER), creativeTab);
    }

    public static final Tuple<Supplier<Block>, Supplier<ConcretePowderBlock>> create(ModRegister register, String name, Properties hardenedProperties, Properties powderProperties) {
        var solid = FullBlocks.create(register, name, hardenedProperties);
        var powder = ConcretePowders.create(register, name, powderProperties, solid.get());

        return new Tuple<>(solid, powder);
    }

    public static final Tuple<Supplier<Block>, Supplier<ConcretePowderBlock>> create(ModRegister register, String name, Properties hardenedProperties, Properties powderProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var solid = FullBlocks.create(register, name, hardenedProperties, creativeTab);
        var powder = ConcretePowders.create(register, name, powderProperties, solid.get(), creativeTab);

        return new Tuple<>(solid, powder);
    }

    private Concrete() {
        // Prevent instantiation
    }
}
