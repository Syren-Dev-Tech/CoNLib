package com.github.syren_dev_tech.scylla.common.blocks.landscapes;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NetherrackBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FlamableLand {

    public static final Supplier<NetherrackBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.NETHERRACK));
    }

    public static final Supplier<NetherrackBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.NETHERRACK), creativeTab);
    }

    public static final Supplier<NetherrackBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new NetherrackBlock(properties));
    }

    public static final Supplier<NetherrackBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new NetherrackBlock(properties), creativeTab);
    }

    private FlamableLand() {
        // Prevent instantiation
    }
}
