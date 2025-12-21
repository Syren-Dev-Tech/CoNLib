package com.github.syren_dev_tech.scylla.common.blocks.decoration.signs;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HangingSigns {

    public static class CeilingHangingSigns {

        public static final Supplier<CeilingHangingSignBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final Supplier<CeilingHangingSignBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK, creativeTab);
        }

        public static final Supplier<CeilingHangingSignBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, WoodType.OAK);
        }

        public static final Supplier<CeilingHangingSignBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, WoodType.OAK, creativeTab);
        }

        public static final Supplier<CeilingHangingSignBlock> create(ModRegister register, String name, Properties properties, WoodType woodType) {
            return register.blockRegistry.register(name, () -> new CeilingHangingSignBlock(properties, woodType));
        }

        public static final Supplier<CeilingHangingSignBlock> create(ModRegister register, String name, Properties properties, WoodType woodType, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new CeilingHangingSignBlock(properties, woodType), creativeTab);
        }

        private CeilingHangingSigns() {
            // Prevent instantiation
        }
    }

    public static class WallHangingSigns {

        public static final Supplier<WallHangingSignBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.OAK_SIGN), WoodType.OAK);
        }

        public static final Supplier<WallHangingSignBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, WoodType.OAK);
        }

        public static final Supplier<WallHangingSignBlock> create(ModRegister register, String name, Properties properties, WoodType woodType) {
            return register.blockRegistry.register(name, () -> new WallHangingSignBlock(properties, woodType));
        }

        private WallHangingSigns() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<WallHangingSignBlock>, Supplier<CeilingHangingSignBlock>> create(ModRegister register, String name) {
        var ceiling = CeilingHangingSigns.create(register, name);
        var wall = WallHangingSigns.create(register, name);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<Supplier<WallHangingSignBlock>, Supplier<CeilingHangingSignBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        var ceiling = CeilingHangingSigns.create(register, name, creativeTab);
        var wall = WallHangingSigns.create(register, name);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<Supplier<WallHangingSignBlock>, Supplier<CeilingHangingSignBlock>> create(ModRegister register, String name, Properties properties) {
        var ceiling = CeilingHangingSigns.create(register, name, properties);
        var wall = WallHangingSigns.create(register, name, properties);

        return new Tuple<>(wall, ceiling);
    }

    public static final Tuple<Supplier<WallHangingSignBlock>, Supplier<CeilingHangingSignBlock>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var ceiling = CeilingHangingSigns.create(register, "hanging_" + name + "_sign", properties, creativeTab);
        var wall = WallHangingSigns.create(register, "hanging_" + name + "_wall_sign", properties);

        return new Tuple<>(wall, ceiling);
    }

    private HangingSigns() {
        // Prevent instantiation
    }
}
