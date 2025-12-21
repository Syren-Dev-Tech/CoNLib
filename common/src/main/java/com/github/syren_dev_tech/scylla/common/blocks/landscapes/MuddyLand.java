package com.github.syren_dev_tech.scylla.common.blocks.landscapes;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class MuddyLand {

    public static final Supplier<MudBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.MUD));
    }

    public static final Supplier<MudBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.MUD), creativeTab);
    }

    public static final Supplier<MudBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new MudBlock(properties));
    }

    public static final Supplier<MudBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new MudBlock(properties), creativeTab);
    }

    private MuddyLand() {
        // Prevent instantiation
    }
}
