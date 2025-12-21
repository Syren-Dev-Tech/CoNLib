package com.github.syren_dev_tech.scylla.common.blocks.plants.gourds;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.gourds.types.Gourd;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Gourds {

    public static final Supplier<Gourd> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.PUMPKIN));
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.PUMPKIN), creativeTab);
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new Gourd(properties));
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new Gourd(properties), creativeTab);
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, Block carvedBlock, StemBlock stemBlock, AttachedStemBlock attachedStemBlock, Item seeds) {
        return register.blockRegistry.register(name, () -> new Gourd(Properties.copy(Blocks.PUMPKIN), carvedBlock, stemBlock, attachedStemBlock, seeds));
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, Block carvedBlock, StemBlock stemBlock, AttachedStemBlock attachedStemBlock, Item seeds, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new Gourd(Properties.copy(Blocks.PUMPKIN), carvedBlock, stemBlock, attachedStemBlock, seeds), creativeTab);
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, Properties properties, Block carvedBlock, StemBlock stemBlock, AttachedStemBlock attachedStemBlock, Item seeds) {
        return register.blockRegistry.register(name, () -> new Gourd(properties, carvedBlock, stemBlock, attachedStemBlock, seeds));
    }

    public static final Supplier<Gourd> create(ModRegister register, String name, Properties properties, Block carvedBlock, StemBlock stemBlock, AttachedStemBlock attachedStemBlock, Item seeds, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new Gourd(properties, carvedBlock, stemBlock, attachedStemBlock, seeds), creativeTab);
    }

    private Gourds() {
        // Prevent instantiation
    }
}
