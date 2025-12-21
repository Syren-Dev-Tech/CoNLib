package com.github.syren_dev_tech.scylla.common.ores;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.items.ModItem;
import com.github.syren_dev_tech.scylla.common.ores.types.Ore;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;
import com.github.syren_dev_tech.scylla.common.registry.features.OreFeature;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// RedstoneOre

public class Ores {

    private Ores() {
    }

    public class GemOre {

        private GemOre() {
        }

        public static final void create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTabItem, ResourceKey<CreativeModeTab> creativeTabBlock) {
            ModItem.create(register, name, creativeTabItem);
            Ores.create(register, name + "_ore", creativeTabBlock);
        }
    }

    public class MetalOre {

        private MetalOre() {
        }

        public static final void create(ModRegister register, String name, Item.Properties ingotProperties, ResourceKey<CreativeModeTab> creativeTabItem, ResourceKey<CreativeModeTab> creativeTabBlock) {
            ModItem.create(register, name + "_ingot", ingotProperties, creativeTabItem);
            ModItem.create(register, name + "_nugget", ingotProperties, creativeTabItem);
            Ores.create(register, name + "_ore", creativeTabBlock);
        }
    }

    public static final Supplier<Ore> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.IRON_ORE));
    }

    public static final Supplier<Ore> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.IRON_ORE), creativeTab);
    }

    public static final Supplier<Ore> create(ModRegister register, String name, Properties properties) {
        var ore = register.blockRegistry.register(name, () -> new Ore(properties.requiresCorrectToolForDrops()));
        OreFeature.register(name, ore.get());

        return ore;
    }

    public static final Supplier<Ore> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var ore = register.blockRegistry.register(name, () -> new Ore(properties.requiresCorrectToolForDrops()), creativeTab);
        OreFeature.register(name, ore.get());

        return ore;
    }
}
