package com.github.syren_dev_tech.scylla.common.blocks.plants.leaves;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.leaves.types.CustomLeaves;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Leaves {

    public static final Supplier<CustomLeaves> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.OAK_LEAVES));
    }

    public static final Supplier<CustomLeaves> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.OAK_LEAVES), creativeTab);
    }

    public static final Supplier<CustomLeaves> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CustomLeaves(properties));
    }

    public static final Supplier<CustomLeaves> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CustomLeaves(properties), creativeTab);
    }

    // Adding particles makes the leaves like cherry blossom leaves instead of
    // defaults.

    public static final Supplier<CustomLeaves> create(ModRegister register, String name, Properties properties, ParticleOptions particles) {
        return register.blockRegistry.register(name, () -> new CustomLeaves(properties, particles));
    }

    public static final Supplier<CustomLeaves> create(ModRegister register, String name, Properties properties, ParticleOptions particles, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CustomLeaves(properties, particles), creativeTab);
    }

    private Leaves() {
        // Prevent instantiation
    }
}
