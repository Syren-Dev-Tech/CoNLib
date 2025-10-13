package com.github.syren_dev_tech.scylla.blocks.basic;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FallingBlocks {

    public static final Supplier<FallingBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.SAND));
    }

    public static final Supplier<FallingBlock> create(ModRegister register, String name,
            ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.SAND), creativeTab);
    }

    /**
     * Creates and registers a falling block.
     *
     * @param name       The name of the block.
     * @param properties The properties of the block.
     * @return The registered falling block.
     */
    public static final Supplier<FallingBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FallingBlock(properties));
    }

    /**
     * Creates and registers a falling block with a specified creative tab.
     *
     * @param name        The name of the block.
     * @param properties  The properties of the block.
     * @param creativeTab The creative tab to which the block belongs.
     * @return The registered falling block.
     */
    public static final Supplier<FallingBlock> create(ModRegister register, String name, Properties properties,
            ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FallingBlock(properties), creativeTab);
    }

    private FallingBlocks() {
        // Prevent instantiation
    }
}
