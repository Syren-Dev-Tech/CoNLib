package com.github.syren_dev_tech.scylla.common.blocks.decoration.storage;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Bookshelves {

    public static final Supplier<ChiseledBookShelfBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CHISELED_BOOKSHELF));
    }

    public static final Supplier<ChiseledBookShelfBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CHISELED_BOOKSHELF), creativeTab);
    }

    public static final Supplier<ChiseledBookShelfBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new ChiseledBookShelfBlock(properties));
    }

    public static final Supplier<ChiseledBookShelfBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new ChiseledBookShelfBlock(properties), creativeTab);
    }

    private Bookshelves() {
        // Prevent instantiation
    }
}
