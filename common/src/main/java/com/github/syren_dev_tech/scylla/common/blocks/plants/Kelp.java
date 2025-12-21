package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.KelpPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Kelp {
    public static class KelpStalks {

        public static final Supplier<KelpPlantBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.KELP_PLANT));
        }

        public static final Supplier<KelpPlantBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.KELP_PLANT), creativeTab);
        }

        public static final Supplier<KelpPlantBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new KelpPlantBlock(properties));
        }

        public static final Supplier<KelpPlantBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new KelpPlantBlock(properties), creativeTab);
        }

        private KelpStalks() {
            // Prevent instantiation
        }
    }

    public static class KelpTops {

        public static final Supplier<KelpBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.KELP));
        }

        public static final Supplier<KelpBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.KELP), creativeTab);
        }

        public static final Supplier<KelpBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new KelpBlock(properties));
        }

        public static final Supplier<KelpBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new KelpBlock(properties), creativeTab);
        }

        private KelpTops() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<KelpPlantBlock>, Supplier<KelpBlock>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.KELP), Properties.copy(Blocks.KELP_PLANT));
    }

    public static final Tuple<Supplier<KelpPlantBlock>, Supplier<KelpBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.KELP), Properties.copy(Blocks.KELP_PLANT), creativeTab);
    }

    public static final Tuple<Supplier<KelpPlantBlock>, Supplier<KelpBlock>> create(ModRegister register, String name, Properties kelpProperties, Properties kelpPlantProperties) {
        var stalk = KelpTops.create(register, name + "_plant", kelpPlantProperties);
        var top = KelpStalks.create(register, name, kelpProperties);

        return new Tuple<>(top, stalk);
    }

    public static final Tuple<Supplier<KelpPlantBlock>, Supplier<KelpBlock>> create(ModRegister register, String name, Properties kelpProperties, Properties kelpPlantProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var stalk = KelpTops.create(register, name + "_plant", kelpPlantProperties, creativeTab);
        var top = KelpStalks.create(register, name, kelpProperties, creativeTab);

        return new Tuple<>(top, stalk);
    }

    private Kelp() {
        // Prevent instantiation
    }
}
