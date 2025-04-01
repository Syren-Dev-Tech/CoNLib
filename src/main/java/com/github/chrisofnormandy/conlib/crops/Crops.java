package com.github.chrisofnormandy.conlib.crops;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.crops.types.Crop;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Crops {

    public static final Supplier<Crop> create(ModRegister register, String name, Item seed) {
        return register.blockRegistry.register(name, () -> new Crop(seed));
    }

    public static final Supplier<Crop> create(ModRegister register, String name, Properties properties, Item seed) {
        return register.blockRegistry.register(name, () -> new Crop(properties, seed));
    }
}
