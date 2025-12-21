package com.github.syren_dev_tech.scylla.common.blocks.decoration.lighting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;

public class Candles {

    public static class CakeCandles {

        public static final Supplier<CandleCakeBlock> create(ModRegister register, String name, Block standingCandle) {
            return create(register, name, Properties.copy(Blocks.CANDLE_CAKE), standingCandle);
        }

        public static final Supplier<CandleCakeBlock> create(ModRegister register, String name, Block standingCandle, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.CANDLE_CAKE), standingCandle, creativeTab);
        }

        public static final Supplier<CandleCakeBlock> create(ModRegister register, String name, Properties properties, Block standingCandle) {
            return register.blockRegistry.register(name, () -> new CandleCakeBlock(standingCandle, properties));
        }

        public static final Supplier<CandleCakeBlock> create(ModRegister register, String name, Properties properties, Block standingCandle, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new CandleCakeBlock(standingCandle, properties), creativeTab);
        }

        private CakeCandles() {
            // Prevent instantiation
        }
    }

    public static class PlainCandles {

        public static final Supplier<CandleBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.FIRE));
        }

        public static final Supplier<CandleBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.FIRE), creativeTab);
        }

        public static final Supplier<CandleBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new CandleBlock(properties));
        }

        public static final Supplier<CandleBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new CandleBlock(properties), creativeTab);
        }

        private PlainCandles() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<CandleBlock>, Supplier<CandleCakeBlock>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.WHITE_CANDLE));
    }

    public static final Tuple<Supplier<CandleBlock>, Supplier<CandleCakeBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WHITE_CANDLE), creativeTab);
    }

    public static final Tuple<Supplier<CandleBlock>, Supplier<CandleCakeBlock>> create(ModRegister register, String name, Properties properties) {
        var standing = PlainCandles.create(register, name, properties);
        var cake = CakeCandles.create(register, name + "_cake", properties, standing.get());

        return new Tuple<>(standing, cake);
    }

    public static final Tuple<Supplier<CandleBlock>, Supplier<CandleCakeBlock>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var standing = PlainCandles.create(register, name, properties, creativeTab);
        var cake = CakeCandles.create(register, name + "_cake", properties, standing.get());

        return new Tuple<>(standing, cake);
    }

    private Candles() {
        // Prevent instantiation
    }
}