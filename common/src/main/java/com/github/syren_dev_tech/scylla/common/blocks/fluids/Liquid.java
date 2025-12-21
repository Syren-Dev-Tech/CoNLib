package com.github.syren_dev_tech.scylla.common.blocks.fluids;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;

// Need some way to define liquid states for flowing fluids.

public class Liquid {

    public static final Supplier<LiquidBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.WATER), () -> Fluids.WATER);
    }

    public static final Supplier<LiquidBlock> create(ModRegister register, String name, Supplier<? extends FlowingFluid> flowingFluid) {
        return create(register, name, Properties.copy(Blocks.WATER), flowingFluid);
    }

    public static final Supplier<LiquidBlock> create(ModRegister register, String name, Properties properties, Supplier<? extends FlowingFluid> flowingFluid) {
        return register.blockRegistry.register(name, () -> new LiquidBlock(flowingFluid, properties));
    }

    private Liquid() {
        // Prevent instantiation
    }
}
