package com.github.syren_dev_tech.scylla.common.blocks.decoration.glass;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class StainedGlassPanes {

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), DyeColor.WHITE);
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), DyeColor.WHITE, creativeTab);
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, DyeColor.WHITE);
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, DyeColor.WHITE, creativeTab);
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, DyeColor color) {
        return create(register, name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), color);
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE), color, creativeTab);
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, Properties properties, DyeColor color) {
        return register.blockRegistry.register(name, () -> new StainedGlassPaneBlock(color, properties));
    }

    public static final Supplier<StainedGlassPaneBlock> create(ModRegister register, String name, Properties properties, DyeColor color, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new StainedGlassPaneBlock(color, properties), creativeTab);
    }

    private StainedGlassPanes() {
        // Prevent instantiation
    }
}
