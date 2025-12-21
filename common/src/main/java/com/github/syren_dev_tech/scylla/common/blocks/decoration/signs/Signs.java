package com.github.syren_dev_tech.scylla.common.blocks.decoration.signs;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class Signs {

    public static class StandingSigns {

        public static final Supplier<StandingSignBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final Supplier<StandingSignBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final Supplier<StandingSignBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, WoodType.OAK);
        }

        public static final Supplier<StandingSignBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, WoodType.OAK, creativeTab);
        }

        public static final Supplier<StandingSignBlock> create(ModRegister register, String name, Properties properties, WoodType woodType) {
            return register.blockRegistry.register(name, () -> new StandingSignBlock(properties, woodType));
        }

        public static final Supplier<StandingSignBlock> create(ModRegister register, String name, Properties properties, WoodType woodType, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new StandingSignBlock(properties, woodType), creativeTab);
        }

        private StandingSigns() {
            // Prevent instantiation
        }
    }

    public static class WallSigns {

        public static final Supplier<WallSignBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final Supplier<WallSignBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, WoodType.OAK);
        }

        public static final Supplier<WallSignBlock> create(ModRegister register, String name, Properties properties, WoodType woodType) {
            return register.blockRegistry.register(name, () -> new WallSignBlock(properties, woodType));
        }

        private WallSigns() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<WallSignBlock>, Supplier<StandingSignBlock>> create(ModRegister register, String name) {
        var standing = StandingSigns.create(register, name);
        var wall = WallSigns.create(register, name);

        return new Tuple<>(wall, standing);
    }

    public static final Tuple<Supplier<WallSignBlock>, Supplier<StandingSignBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingSigns.create(register, name, creativeTab);
        var wall = WallSigns.create(register, name);

        return new Tuple<>(wall, standing);
    }

    public static final Tuple<Supplier<WallSignBlock>, Supplier<StandingSignBlock>> create(ModRegister register, String name, Properties properties) {
        var standing = StandingSigns.create(register, name, properties);
        var wall = WallSigns.create(register, name, properties);

        return new Tuple<>(wall, standing);
    }

    public static final Tuple<Supplier<WallSignBlock>, Supplier<StandingSignBlock>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingSigns.create(register, name + "_sign", properties, creativeTab);
        var wall = WallSigns.create(register, name + "_wall_sign", properties);

        return new Tuple<>(wall, standing);
    }

    private Signs() {
        // Prevent instantiation
    }
}
