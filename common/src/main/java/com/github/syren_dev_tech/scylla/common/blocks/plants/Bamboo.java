package com.github.syren_dev_tech.scylla.common.blocks.plants;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.block.BambooStalkBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bamboo {
    public static class BambooStalks {

        public static final Supplier<BambooStalkBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.BAMBOO));
        }

        public static final Supplier<BambooStalkBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.BAMBOO), creativeTab);
        }

        public static final Supplier<BambooStalkBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new BambooStalkBlock(properties));
        }

        public static final Supplier<BambooStalkBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new BambooStalkBlock(properties), creativeTab);
        }

        private BambooStalks() {
            // Prevent instantiation
        }
    }

    public static class BambooSaplings {

        public static final Supplier<BambooSaplingBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.BAMBOO_SAPLING));
        }

        public static final Supplier<BambooSaplingBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.BAMBOO_SAPLING), creativeTab);
        }

        public static final Supplier<BambooSaplingBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new BambooSaplingBlock(properties));
        }

        public static final Supplier<BambooSaplingBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new BambooSaplingBlock(properties), creativeTab);
        }

        private BambooSaplings() {
            // Prevent instantiation
        }
    }

    public static final Tuple<Supplier<BambooStalkBlock>, Supplier<BambooSaplingBlock>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.BAMBOO), Properties.copy(Blocks.BAMBOO_SAPLING));
    }

    public static final Tuple<Supplier<BambooStalkBlock>, Supplier<BambooSaplingBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.BAMBOO), Properties.copy(Blocks.BAMBOO_SAPLING), creativeTab);
    }

    public static final Tuple<Supplier<BambooStalkBlock>, Supplier<BambooSaplingBlock>> create(ModRegister register, String name, Properties stalkProperties, Properties saplingProperties) {
        return new Tuple<>(BambooStalks.create(register, name, stalkProperties), BambooSaplings.create(register, name, saplingProperties));
    }

    public static final Tuple<Supplier<BambooStalkBlock>, Supplier<BambooSaplingBlock>> create(ModRegister register, String name, Properties stalkProperties, Properties saplingProperties, ResourceKey<CreativeModeTab> creativeTab) {
        return new Tuple<>(BambooStalks.create(register, name, stalkProperties, creativeTab), BambooSaplings.create(register, name, saplingProperties, creativeTab));
    }

    private Bamboo() {
        // Prevent instantiation
    }
}
