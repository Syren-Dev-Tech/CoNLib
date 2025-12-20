package com.github.syren_dev_tech.scylla.crops;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.crops.types.Crop;
import com.github.syren_dev_tech.scylla.crops.types.CropProperties;
import com.github.syren_dev_tech.scylla.registry.ModRegister;

import net.minecraft.world.item.Item;

public class Crops {

    private Crops() {
    }

    public static final Supplier<Crop> create(ModRegister register, String name, CropProperties properties, Supplier<Item> seed) {
        return register.blockRegistry.register(name, () -> new Crop(properties, seed));
    }
}
