package com.github.syren_dev_tech.scylla.common.blocks.decoration.glass;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TintedGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TintedGlass {

    public static final Supplier<TintedGlassBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.TINTED_GLASS));
    }

    public static final Supplier<TintedGlassBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.TINTED_GLASS), creativeTab);
    }

    public static final Supplier<TintedGlassBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new TintedGlassBlock(properties));
    }

    public static final Supplier<TintedGlassBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new TintedGlassBlock(properties), creativeTab);
    }

    private TintedGlass() {
        // Prevent instantiation
    }
}
