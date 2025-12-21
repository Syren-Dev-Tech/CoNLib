package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class NoteBlocks {

    public static final Supplier<NoteBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.NOTE_BLOCK));
    }

    public static final Supplier<NoteBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.NOTE_BLOCK), creativeTab);
    }

    public static final Supplier<NoteBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new NoteBlock(properties));
    }

    public static final Supplier<NoteBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new NoteBlock(properties), creativeTab);
    }

    private NoteBlocks() {
        // Prevent instantiation
    }
}
