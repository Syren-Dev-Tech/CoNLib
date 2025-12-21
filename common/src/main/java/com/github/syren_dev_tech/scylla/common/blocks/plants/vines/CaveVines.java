package com.github.syren_dev_tech.scylla.common.blocks.plants.vines;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CaveVinesPlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Need custom implementation and berries...

public class CaveVines {
    public static class CaveVineBodies {

        public static final Supplier<CaveVinesPlantBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.CAVE_VINES_PLANT));
        }

        public static final Supplier<CaveVinesPlantBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.CAVE_VINES_PLANT), creativeTab);
        }

        public static final Supplier<CaveVinesPlantBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new CaveVinesPlantBlock(properties));
        }

        public static final Supplier<CaveVinesPlantBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new CaveVinesPlantBlock(properties), creativeTab);
        }

        private CaveVineBodies() {
            // Prevent instantiation
        }
    }

    public static class CaveVineTips {

        public static final Supplier<CaveVinesBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.CAVE_VINES));
        }

        public static final Supplier<CaveVinesBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.CAVE_VINES), creativeTab);
        }

        public static final Supplier<CaveVinesBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new CaveVinesBlock(properties));
        }

        public static final Supplier<CaveVinesBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new CaveVinesBlock(properties), creativeTab);
        }

        private CaveVineTips() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<CaveVinesBlock>, Supplier<CaveVinesPlantBlock>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CAVE_VINES), Properties.copy(Blocks.CAVE_VINES_PLANT));
    }

    public static final Tuple<Supplier<CaveVinesBlock>, Supplier<CaveVinesPlantBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CAVE_VINES), Properties.copy(Blocks.CAVE_VINES_PLANT), creativeTab);
    }

    public static final Tuple<Supplier<CaveVinesBlock>, Supplier<CaveVinesPlantBlock>> create(ModRegister register, String name, Properties topProperties, Properties bodyProperties) {
        var top = CaveVineTips.create(register, name, topProperties);
        var body = CaveVineBodies.create(register, name + "_plant", bodyProperties);

        return new Tuple<>(top, body);
    }

    public static final Tuple<Supplier<CaveVinesBlock>, Supplier<CaveVinesPlantBlock>> create(ModRegister register, String name, Properties topProperties, Properties bodyProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var top = CaveVineTips.create(register, name, topProperties, creativeTab);
        var body = CaveVineBodies.create(register, name + "_plant", bodyProperties, creativeTab);

        return new Tuple<>(top, body);
    }

    private CaveVines() {
        // Prevent instantiation
    }
}
