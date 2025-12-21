package com.github.syren_dev_tech.scylla.common.blocks.plants.gourds;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.gourds.types.CarvedGourd;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Basically identical to CarvedGourds, but this one applies lighting.

public class CarvedGourdLanterns {

    public static final Supplier<CarvedGourd> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.JACK_O_LANTERN), 15);
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.JACK_O_LANTERN), 15, creativeTab);
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, 15);
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, 15, creativeTab);
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, Properties properties, int lightLevel) {
        return register.blockRegistry.register(name, () -> new CarvedGourd(properties.lightLevel(blockState -> lightLevel)));
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, Properties properties, int lightLevel, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CarvedGourd(properties.lightLevel(blockState -> lightLevel)), creativeTab);
    }

    private CarvedGourdLanterns() {
        // Prevent instantiation
    }
}
