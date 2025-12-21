package com.github.syren_dev_tech.scylla.common.blocks.misc;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CryingObsidianBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Crying {

    public static final Supplier<CryingObsidianBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CRYING_OBSIDIAN));
    }

    public static final Supplier<CryingObsidianBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CRYING_OBSIDIAN), creativeTab);
    }

    public static final Supplier<CryingObsidianBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CryingObsidianBlock(properties));
    }

    public static final Supplier<CryingObsidianBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CryingObsidianBlock(properties), creativeTab);
    }

    private Crying() {
        // Prevent instantiation
    }
}
