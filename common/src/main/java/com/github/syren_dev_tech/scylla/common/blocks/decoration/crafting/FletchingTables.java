package com.github.syren_dev_tech.scylla.common.blocks.decoration.crafting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FletchingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FletchingTables {

    public static final Supplier<FletchingTableBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FLETCHING_TABLE));
    }

    public static final Supplier<FletchingTableBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FLETCHING_TABLE), creativeTab);
    }

    public static final Supplier<FletchingTableBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new FletchingTableBlock(properties));
    }

    public static final Supplier<FletchingTableBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new FletchingTableBlock(properties), creativeTab);
    }

    private FletchingTables() {
        // Prevent instantiation
    }
}
