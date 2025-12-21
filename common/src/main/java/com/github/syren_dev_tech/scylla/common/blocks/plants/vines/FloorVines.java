package com.github.syren_dev_tech.scylla.common.blocks.plants.vines;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.vines.types.FloorVineBodyBlock;
import com.github.syren_dev_tech.scylla.common.blocks.plants.vines.types.FloorVineHeadBlock;
import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FloorVines {
    public static class FloorVineBodies {

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES_PLANT), (GrowingPlantHeadBlock) Blocks.TWISTING_VINES);
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES_PLANT), (GrowingPlantHeadBlock) Blocks.TWISTING_VINES, creativeTab);
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, (GrowingPlantHeadBlock) Blocks.TWISTING_VINES);
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, (GrowingPlantHeadBlock) Blocks.TWISTING_VINES, creativeTab);
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, GrowingPlantHeadBlock headBlock) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES_PLANT), headBlock);
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, GrowingPlantHeadBlock headBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES_PLANT), headBlock, creativeTab);
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, Properties properties, GrowingPlantHeadBlock headBlock) {
            return register.blockRegistry.register(name, () -> new FloorVineBodyBlock(properties, headBlock));
        }

        public static final Supplier<FloorVineBodyBlock> create(ModRegister register, String name, Properties properties, GrowingPlantHeadBlock headBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new FloorVineBodyBlock(properties, headBlock), creativeTab);
        }

        private FloorVineBodies() {
            // Prevent instantiation
        }
    }

    public static class FloorVineTips {

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES), Blocks.TWISTING_VINES_PLANT);
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES), Blocks.TWISTING_VINES_PLANT, creativeTab);
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, Blocks.TWISTING_VINES_PLANT);
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, Blocks.TWISTING_VINES_PLANT, creativeTab);
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, Block bodyBlock) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES), bodyBlock);
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, Block bodyBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TWISTING_VINES), bodyBlock, creativeTab);
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, Properties properties, Block bodyBlock) {
            return register.blockRegistry.register(name, () -> new FloorVineHeadBlock(properties, bodyBlock));
        }

        public static final Supplier<FloorVineHeadBlock> create(ModRegister register, String name, Properties properties, Block bodyBlock, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new FloorVineHeadBlock(properties, bodyBlock), creativeTab);
        }

        private FloorVineTips() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<FloorVineHeadBlock>, Supplier<FloorVineBodyBlock>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.TWISTING_VINES), Properties.copy(Blocks.TWISTING_VINES_PLANT));
    }

    public static final Tuple<Supplier<FloorVineHeadBlock>, Supplier<FloorVineBodyBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.TWISTING_VINES), Properties.copy(Blocks.TWISTING_VINES_PLANT), creativeTab);
    }

    public static final Tuple<Supplier<FloorVineHeadBlock>, Supplier<FloorVineBodyBlock>> create(ModRegister register, String name, Properties topProperties, Properties bodyProperties) {
        var top = FloorVineTips.create(register, name, topProperties);
        var body = FloorVineBodies.create(register, name + "_plant", bodyProperties, top.get());
        top.get().setBodyBlock(body.get());

        return new Tuple<>(top, body);
    }

    public static final Tuple<Supplier<FloorVineHeadBlock>, Supplier<FloorVineBodyBlock>> create(ModRegister register, String name, Properties topProperties, Properties bodyProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var top = FloorVineTips.create(register, name, topProperties, creativeTab);
        var body = FloorVineBodies.create(register, name + "_plant", bodyProperties, top.get(), creativeTab);
        top.get().setBodyBlock(body.get());

        return new Tuple<>(top, body);
    }

    private FloorVines() {
        // Prevent instantiation
    }
}
