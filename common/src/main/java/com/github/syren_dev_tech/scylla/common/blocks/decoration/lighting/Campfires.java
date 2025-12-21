package com.github.syren_dev_tech.scylla.common.blocks.decoration.lighting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Campfires {

    public static final Supplier<CampfireBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CAMPFIRE), true, 1);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CAMPFIRE), true, 1, creativeTab);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, true, 1);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, true, 1, creativeTab);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Boolean spawnParticles) {
        return create(register, name, Properties.copy(Blocks.CAMPFIRE), spawnParticles, 1);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Boolean spawnParticles, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CAMPFIRE), spawnParticles, 1, creativeTab);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Integer fireDamage) {
        return create(register, name, Properties.copy(Blocks.CAMPFIRE), true, fireDamage);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Integer fireDamage, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CAMPFIRE), true, fireDamage, creativeTab);
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Properties properties, Boolean spawnParticles, Integer fireDamage) {
        return register.blockRegistry.register(name, () -> new CampfireBlock(spawnParticles, fireDamage, properties));
    }

    public static final Supplier<CampfireBlock> create(ModRegister register, String name, Properties properties, Boolean spawnParticles, Integer fireDamage, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CampfireBlock(spawnParticles, fireDamage, properties), creativeTab);
    }

    private Campfires() {
        // Prevent instantiation
    }
}
