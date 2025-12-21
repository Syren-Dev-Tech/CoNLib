package com.github.syren_dev_tech.scylla.common.blocks.decoration;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class StickyBlocks {
    public static class SlimeBlocks {

        public static final Supplier<SlimeBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.SLIME_BLOCK));
        }

        public static final Supplier<SlimeBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.SLIME_BLOCK), creativeTab);
        }

        public static final Supplier<SlimeBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new SlimeBlock(properties));
        }

        public static final Supplier<SlimeBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new SlimeBlock(properties), creativeTab);
        }

        private SlimeBlocks() {
            // Prevent instantiation
        }
    }

    public static class HoneyBlocks {

        public static final Supplier<HoneyBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.HONEY_BLOCK));
        }

        public static final Supplier<HoneyBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.HONEY_BLOCK), creativeTab);
        }

        public static final Supplier<HoneyBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new HoneyBlock(properties));
        }

        public static final Supplier<HoneyBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new HoneyBlock(properties), creativeTab);
        }

        private HoneyBlocks() {
            // Prevent instantiation
        }
    }

    private StickyBlocks() {
        // Prevent instantiation
    }
}
