package com.github.syren_dev_tech.scylla.common.blocks.decoration.storage;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ShulkerBoxes {

    public static final Supplier<ShulkerBoxBlock> create(ModRegister register, String name, DyeColor color) {
        return create(register, name, color, Properties.copy(Blocks.WHITE_SHULKER_BOX));
    }

    public static final Supplier<ShulkerBoxBlock> create(ModRegister register, String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, color, Properties.copy(Blocks.WHITE_SHULKER_BOX), creativeTab);
    }

    public static final Supplier<ShulkerBoxBlock> create(ModRegister register, String name, DyeColor color, Properties properties) {
        return register.blockRegistry.register(name, () -> new ShulkerBoxBlock(color, properties));
    }

    public static final Supplier<ShulkerBoxBlock> create(ModRegister register, String name, DyeColor color, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new ShulkerBoxBlock(color, properties), creativeTab);
    }

    private ShulkerBoxes() {
        // Prevent instantiation
    }
}
