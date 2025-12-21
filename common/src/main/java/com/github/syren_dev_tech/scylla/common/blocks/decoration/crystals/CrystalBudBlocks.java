package com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals.types.BuddingCrystal;
import com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals.types.BuddingCrystalProperties;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CrystalBudBlocks {

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.BUDDING_AMETHYST));
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.BUDDING_AMETHYST), creativeTab);
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new BuddingCrystal<>(properties));
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new BuddingCrystal<>(properties), creativeTab);
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, BuddingCrystalProperties<T> crystalBudBlockProperties) {
        return register.blockRegistry.register(name, () -> new BuddingCrystal<>(Properties.copy(Blocks.BUDDING_AMETHYST), crystalBudBlockProperties));
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, BuddingCrystalProperties<T> crystalBudBlockProperties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new BuddingCrystal<>(Properties.copy(Blocks.BUDDING_AMETHYST), crystalBudBlockProperties), creativeTab);
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, Properties properties, BuddingCrystalProperties<T> crystalBudBlockProperties) {
        return register.blockRegistry.register(name, () -> new BuddingCrystal<>(properties, crystalBudBlockProperties));
    }

    public static final <T extends Block> Supplier<BuddingCrystal<T>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab, BuddingCrystalProperties<T> crystalBudBlockProperties) {
        return register.blockRegistry.register(name, () -> new BuddingCrystal<>(properties, crystalBudBlockProperties), creativeTab);
    }

    private CrystalBudBlocks() {
        // Prevent instantiation
    }
}
