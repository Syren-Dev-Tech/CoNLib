package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangroveRootsBlock;
import net.minecraft.world.level.block.RootedDirtBlock;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Roots {

    public static class HangingRoots {

        public static final Supplier<RootsBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.HANGING_ROOTS));
        }

        public static final Supplier<RootsBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.HANGING_ROOTS), creativeTab);
        }

        public static final Supplier<RootsBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new RootsBlock(properties));
        }

        public static final Supplier<RootsBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new RootsBlock(properties), creativeTab);
        }

        private HangingRoots() {
            // Prevent instantiation
        }
    }

    public static class SolidRoots {

        public static final Supplier<MangroveRootsBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.MANGROVE_ROOTS));
        }

        public static final Supplier<MangroveRootsBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.MANGROVE_ROOTS), creativeTab);
        }

        public static final Supplier<MangroveRootsBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new MangroveRootsBlock(properties));
        }

        public static final Supplier<MangroveRootsBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new MangroveRootsBlock(properties), creativeTab);
        }

        private SolidRoots() {
            // Prevent instantiation
        }
    }

    public static class SoilRoots {
        public static final Supplier<RootedDirtBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.ROOTED_DIRT));
        }

        public static final Supplier<RootedDirtBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.ROOTED_DIRT), creativeTab);
        }

        public static final Supplier<RootedDirtBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new RootedDirtBlock(properties));
        }

        public static final Supplier<RootedDirtBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new RootedDirtBlock(properties), creativeTab);
        }

        private SoilRoots() {
            // Prevent instantiation
        }
    }

    private Roots() {
        // Prevent instantiation
    }
}
