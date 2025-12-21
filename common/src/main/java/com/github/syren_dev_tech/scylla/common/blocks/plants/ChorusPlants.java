package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChorusFlowerBlock;
import net.minecraft.world.level.block.ChorusPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ChorusPlants {
    public static class ChorusStalks {

        public static final Supplier<ChorusPlantBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.CHORUS_PLANT));
        }

        public static final Supplier<ChorusPlantBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.CHORUS_PLANT), creativeTab);
        }

        public static final Supplier<ChorusPlantBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new ChorusPlantBlock(properties));
        }

        public static final Supplier<ChorusPlantBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new ChorusPlantBlock(properties), creativeTab);
        }

        private ChorusStalks() {
            // Prevent instantiation
        }
    }

    public static class ChorusFlowers {

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.CHORUS_FLOWER));
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.CHORUS_FLOWER), creativeTab);
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, ChorusPlantBlock plantBlock) {
            return create(register, name, Properties.copy(Blocks.CHORUS_FLOWER), plantBlock);
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, ChorusPlantBlock plantBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.CHORUS_FLOWER), plantBlock, creativeTab);
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, (ChorusPlantBlock) Blocks.CHORUS_PLANT);
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, (ChorusPlantBlock) Blocks.CHORUS_PLANT, creativeTab);
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, Properties properties, ChorusPlantBlock plantBlock) {
            return register.blockRegistry.register(name, () -> new ChorusFlowerBlock(plantBlock, properties));
        }

        public static final Supplier<ChorusFlowerBlock> create(ModRegister register, String name, Properties properties, ChorusPlantBlock plantBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new ChorusFlowerBlock(plantBlock, properties), creativeTab);
        }

        private ChorusFlowers() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<ChorusPlantBlock>, Supplier<ChorusFlowerBlock>> create(ModRegister register, String name) {
        var plantBlock = ChorusStalks.create(register, name);
        var flowerBlock = ChorusFlowers.create(register, name, plantBlock.get());

        return new Tuple<>(plantBlock, flowerBlock);
    }

    public static final Tuple<Supplier<ChorusPlantBlock>, Supplier<ChorusFlowerBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        var plantBlock = ChorusStalks.create(register, name, creativeTab);
        var flowerBlock = ChorusFlowers.create(register, name, plantBlock.get(), creativeTab);

        return new Tuple<>(plantBlock, flowerBlock);
    }

    public static final Tuple<Supplier<ChorusPlantBlock>, Supplier<ChorusFlowerBlock>> create(ModRegister register, String name, Properties stalkProperties, Properties flowerProperties) {
        var plantBlock = ChorusStalks.create(register, name, stalkProperties);
        var flowerBlock = ChorusFlowers.create(register, name, flowerProperties, plantBlock.get());

        return new Tuple<>(plantBlock, flowerBlock);
    }

    public static final Tuple<Supplier<ChorusPlantBlock>, Supplier<ChorusFlowerBlock>> create(ModRegister register, String name, Properties stalkProperties, Properties flowerProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var plantBlock = ChorusStalks.create(register, name, stalkProperties, creativeTab);
        var flowerBlock = ChorusFlowers.create(register, name, flowerProperties, plantBlock.get(), creativeTab);

        return new Tuple<>(plantBlock, flowerBlock);
    }

    private ChorusPlants() {
        // Prevent instantiation
    }
}
