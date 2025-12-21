package com.github.syren_dev_tech.scylla.common.blocks.brushable;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.brushable.types.CustomBrushableBlock;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BrushableStones {

    public static final Supplier<CustomBrushableBlock> create(ModRegister register, String name, Supplier<Block> dustedBlock) {
        return create(register, name, Properties.copy(Blocks.STONE), dustedBlock);
    }

    public static final Supplier<CustomBrushableBlock> create(ModRegister register, String name, Supplier<Block> dustedBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.STONE), dustedBlock, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, creativeTab);
    }

    public static final Supplier<CustomBrushableBlock> create(ModRegister register, String name, Properties properties, Supplier<Block> dustedBlock) {
        return create(register, name, properties, dustedBlock, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED);
    }

    public static final Supplier<CustomBrushableBlock> create(ModRegister register, String name, Properties properties, Supplier<Block> dustedBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, dustedBlock, SoundEvents.BRUSH_SAND, SoundEvents.BRUSH_SAND_COMPLETED, creativeTab);
    }

    public static final Supplier<CustomBrushableBlock> create(ModRegister register, String name, Properties properties, Supplier<Block> dustedBlock, SoundEvent dustingSound, SoundEvent dustingCompletedSound) {
        return register.blockRegistry.register(name, () -> new CustomBrushableBlock(dustedBlock.get(), properties, dustingSound, dustingCompletedSound));
    }

    public static final Supplier<CustomBrushableBlock> create(ModRegister register, String name, Properties properties, Supplier<Block> dustedBlock, SoundEvent dustingSound, SoundEvent dustingCompletedSound, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CustomBrushableBlock(dustedBlock.get(), properties, dustingSound, dustingCompletedSound), creativeTab);
    }

    private BrushableStones() {
        // Prevent instantiation
    }
}
