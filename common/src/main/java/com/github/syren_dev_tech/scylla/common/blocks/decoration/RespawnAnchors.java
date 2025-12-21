package com.github.syren_dev_tech.scylla.common.blocks.decoration;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class RespawnAnchors {

    public static final Supplier<RespawnAnchorBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.RESPAWN_ANCHOR));
    }

    public static final Supplier<RespawnAnchorBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.RESPAWN_ANCHOR), creativeTab);
    }

    public static final Supplier<RespawnAnchorBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new RespawnAnchorBlock(properties));
    }

    public static final Supplier<RespawnAnchorBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new RespawnAnchorBlock(properties), creativeTab);
    }

    private RespawnAnchors() {
        // Prevent instantiation
    }
}
