package com.github.chrisofnormandy.conlib.blocks.decoration.crystals;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class CrystalSet {

    public static final Supplier<?>[] create(ModRegister register, String name) {
        var smallCrystal = SmallCrystals.create(register, "small_" + name + "_bud");
        var mediumCrystal = MediumCrystals.create(register, "medium_" + name + "_bud");
        var largeCrystal = LargeCrystals.create(register, "large_" + name + "_bud");
        var fullCrystal = FullCrystals.create(register, name + "_cluster");
        var buddingCrystal = CrystalBudBlocks.create(register, "budding_" + name, smallCrystal.get(), mediumCrystal.get(), largeCrystal.get(), fullCrystal.get());
        var block = CrystalBlocks.create(register, name + "_block");

        return new Supplier<?>[] { smallCrystal, mediumCrystal, largeCrystal, fullCrystal, buddingCrystal, block };
    }

    public static final Supplier<?>[] create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        var smallCrystal = SmallCrystals.create(register, "small_" + name + "_bud", creativeTab);
        var mediumCrystal = MediumCrystals.create(register, "medium_" + name + "_bud", creativeTab);
        var largeCrystal = LargeCrystals.create(register, "large_" + name + "_bud", creativeTab);
        var fullCrystal = FullCrystals.create(register, name + "_cluster", creativeTab);
        var buddingCrystal = CrystalBudBlocks.create(register, "budding_" + name, smallCrystal.get(), mediumCrystal.get(), largeCrystal.get(), fullCrystal.get(), creativeTab);
        var block = CrystalBlocks.create(register, name + "_block", creativeTab);

        return new Supplier<?>[] { smallCrystal, mediumCrystal, largeCrystal, fullCrystal, buddingCrystal, block };
    }

    private CrystalSet() {
        // Prevent instantiation
    }
}
