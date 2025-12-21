package com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals.types;

import java.util.function.Supplier;

import net.minecraft.world.level.block.Block;

public class BuddingCrystalProperties<T extends Block> {
    Supplier<T> smallCrystal;
    Supplier<T> mediumCrystal;
    Supplier<T> largeCrystal;
    Supplier<T> fullCrystal;

    public BuddingCrystalProperties(Supplier<T> smallCrystal, Supplier<T> mediumCrystal, Supplier<T> largeCrystal, Supplier<T> fullCrystal) {
        this.smallCrystal = smallCrystal;
        this.mediumCrystal = mediumCrystal;
        this.largeCrystal = largeCrystal;
        this.fullCrystal = fullCrystal;
    }
}
