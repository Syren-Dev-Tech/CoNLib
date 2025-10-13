package com.github.syren_dev_tech.scylla.ores;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.items.ModItem;
import com.github.syren_dev_tech.scylla.ores.types.Ore;
import com.github.syren_dev_tech.scylla.registry.ModRegister;
import com.github.syren_dev_tech.scylla.registry.features.OreFeature;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// RedstoneOre

public class Ores {

    public static class GemOre {
        public static final void create(ModRegister register, String name,
                net.minecraft.world.item.Item.Properties toolProperties, Tier toolTier,
                ResourceKey<CreativeModeTab> creativeTab_Item, ResourceKey<CreativeModeTab> creativeTab_Block) {
            ModItem.create(register, name, creativeTab_Item);
            Ores.create(register, name + "_ore", creativeTab_Block);
        }
    }

    public static class MetalOre {
        public static final void create(ModRegister register, String name,
                net.minecraft.world.item.Item.Properties ingotProperties,
                net.minecraft.world.item.Item.Properties toolProperties, Tier toolTier,
                ResourceKey<CreativeModeTab> creativeTab_Item, ResourceKey<CreativeModeTab> creativeTab_Block) {
            ModItem.create(register, name + "_ingot", ingotProperties, creativeTab_Item);
            ModItem.create(register, name + "_nugget", ingotProperties, creativeTab_Item);
            Ores.create(register, name + "_ore", creativeTab_Block);
        }
    }

    public static final Supplier<Ore> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.IRON_ORE));
    }

    public static final Supplier<Ore> create(ModRegister register, String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.IRON_ORE), creativeTab);
    }

    public static final Supplier<Ore> create(ModRegister register, String name, Properties properties) {
        var ore = register.blockRegistry.register(name, () -> new Ore(properties.requiresCorrectToolForDrops()));
        OreFeature.register(name, ore.get());

        return ore;
    }

    public static final Supplier<Ore> create(ModRegister register, String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        var ore = register.blockRegistry.register(name, () -> new Ore(properties.requiresCorrectToolForDrops()),
                creativeTab);
        OreFeature.register(name, ore.get());

        return ore;
    }
}
