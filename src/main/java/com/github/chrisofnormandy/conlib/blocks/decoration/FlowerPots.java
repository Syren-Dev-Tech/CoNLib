package com.github.chrisofnormandy.conlib.blocks.decoration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlowerPots {
    public static class PotWithFlower {

        public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Block flower) {
            return create(register, name, Properties.copy(Blocks.FLOWER_POT), flower);
        }

        public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Block flower, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.FLOWER_POT), flower, creativeTab);
        }

        // Can't use "create" methods here because null is allowed for creative tabs.

        public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Properties properties, Block flower) {
            return register.blockRegistry.register(name, () -> new FlowerPotBlock(null, () -> flower, properties));
        }

        public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Properties properties, Block flower, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new FlowerPotBlock(null, () -> flower, properties), creativeTab);
        }

        public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Properties properties, Block flower, @Nullable Supplier<FlowerPotBlock> emptyPot) {
            return register.blockRegistry.register(name, () -> new FlowerPotBlock(emptyPot, () -> flower, properties));
        }

        public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Properties properties, Block flower, @Nullable Supplier<FlowerPotBlock> emptyPot, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new FlowerPotBlock(emptyPot, () -> flower, properties), creativeTab);
        }

        public static List<Supplier<FlowerPotBlock>> create(ModRegister register, String name, List<Block> flowers) {
            List<Supplier<FlowerPotBlock>> pots = new ArrayList<>();

            flowers.forEach((Block flower) -> pots.add(create(register, name, Properties.copy(Blocks.FLOWER_POT), flower)));

            return pots;
        }

        public static List<Supplier<FlowerPotBlock>> create(ModRegister register, String name, List<Block> flowers, Properties properties) {
            List<Supplier<FlowerPotBlock>> pots = new ArrayList<>();

            flowers.forEach((Block flower) -> pots.add(create(register, name, properties, flower)));

            return pots;
        }

        private PotWithFlower() {
            // Prevent instantiation
        }
    }

    public static Supplier<FlowerPotBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FLOWER_POT));
    }

    public static Supplier<FlowerPotBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FLOWER_POT), creativeTab);
    }

    public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FlowerPotBlock(null, () -> Blocks.AIR, properties));
    }

    public static Supplier<FlowerPotBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FlowerPotBlock(null, () -> Blocks.AIR, properties), creativeTab);
    }

    private FlowerPots() {
        // Prevent instantiation
    }
}
