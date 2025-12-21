package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Triplet;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.piston.PistonHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Pistons {

    public static class PistonBases {

        public static Supplier<PistonBaseBlock> create(ModRegister register, String name, boolean sticky) {
            return create(register, name, Properties.copy(Blocks.PISTON), sticky);
        }

        public static Supplier<PistonBaseBlock> create(ModRegister register, String name, boolean sticky, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.PISTON), sticky, creativeTab);
        }

        public static Supplier<PistonBaseBlock> create(ModRegister register, String name, Properties properties, boolean sticky) {
            return register.blockRegistry.register(name, () -> new PistonBaseBlock(sticky, properties));
        }

        public static Supplier<PistonBaseBlock> create(ModRegister register, String name, Properties properties, boolean sticky, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new PistonBaseBlock(sticky, properties), creativeTab);
        }

        private PistonBases() {
            // Prevent instantiation
        }
    }

    public static class PistonHeads {

        public static Supplier<PistonHeadBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.PISTON_HEAD));
        }

        public static Supplier<PistonHeadBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.PISTON_HEAD), creativeTab);
        }

        public static Supplier<PistonHeadBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new PistonHeadBlock(properties));
        }

        public static Supplier<PistonHeadBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new PistonHeadBlock(properties), creativeTab);
        }

        private PistonHeads() {
            // Prevent instantiation
        }
    }

    public static class MovingPistons {

        public static Supplier<MovingPistonBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.MOVING_PISTON));
        }

        public static Supplier<MovingPistonBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.MOVING_PISTON), creativeTab);
        }

        public static Supplier<MovingPistonBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new MovingPistonBlock(properties));
        }

        public static Supplier<MovingPistonBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new MovingPistonBlock(properties), creativeTab);
        }

        private MovingPistons() {
            // Prevent instantiation
        }
    }

    public static final Triplet<Supplier<PistonBaseBlock>, Supplier<PistonHeadBlock>, Supplier<MovingPistonBlock>> createSticky(ModRegister register, String name) {
        return create(register, name, false);
    }

    public static final Triplet<Supplier<PistonBaseBlock>, Supplier<PistonHeadBlock>, Supplier<MovingPistonBlock>> createSticky(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, false, creativeTab);
    }

    public static final Triplet<Supplier<PistonBaseBlock>, Supplier<PistonHeadBlock>, Supplier<MovingPistonBlock>> create(ModRegister register, String name, boolean sticky) {
        var pistonBaseBlock = PistonBases.create(register, name, sticky);
        var pistonHeadBlock = PistonHeads.create(register, name + "_head");
        var movingPistonBlock = MovingPistons.create(register, "moving_" + name);

        return new Triplet<>(pistonBaseBlock, pistonHeadBlock, movingPistonBlock);
    }

    public static final Triplet<Supplier<PistonBaseBlock>, Supplier<PistonHeadBlock>, Supplier<MovingPistonBlock>> create(ModRegister register, String name, boolean sticky, ResourceKey<CreativeModeTab> creativeTab) {
        var pistonBaseBlock = PistonBases.create(register, name, sticky, creativeTab);
        var pistonHeadBlock = PistonHeads.create(register, name + "_head", creativeTab);
        var movingPistonBlock = MovingPistons.create(register, "moving_" + name, creativeTab);

        return new Triplet<>(pistonBaseBlock, pistonHeadBlock, movingPistonBlock);
    }

    private Pistons() {
        // Prevent instantiation
    }
}
