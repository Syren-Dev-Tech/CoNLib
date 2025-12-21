package com.github.syren_dev_tech.scylla.common.crops;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.crops.types.Crop;
import com.github.syren_dev_tech.scylla.common.crops.types.CropProperties;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.item.Item;

public class Crops {

    private Crops() {
    }

    public static final Supplier<Crop> create(ModRegister register, String name, CropProperties properties, Supplier<Item> seed) {
        return register.blockRegistry.register(name, () -> new Crop(properties, seed));
    }
}
