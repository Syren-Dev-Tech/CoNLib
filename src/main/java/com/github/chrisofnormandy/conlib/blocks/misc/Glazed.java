package com.github.chrisofnormandy.conlib.blocks.misc;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Glazed {

    public static final Supplier<GlazedTerracottaBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA));
    }

    public static final Supplier<GlazedTerracottaBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WHITE_GLAZED_TERRACOTTA), creativeTab);
    }

    public static final Supplier<GlazedTerracottaBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new GlazedTerracottaBlock(properties));
    }

    public static final Supplier<GlazedTerracottaBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new GlazedTerracottaBlock(properties), creativeTab);
    }

    private Glazed() {
        // Prevent instantiation
    }
}
