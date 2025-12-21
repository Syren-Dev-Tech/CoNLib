package com.github.syren_dev_tech.scylla.common.blocks.plants.gourds;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.gourds.types.CarvedGourd;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CarvedGourds {

    public static final Supplier<CarvedGourd> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.CARVED_PUMPKIN));
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.CARVED_PUMPKIN), creativeTab);
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new CarvedGourd(properties));
    }

    public static final Supplier<CarvedGourd> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CarvedGourd(properties), creativeTab);
    }

    private CarvedGourds() {
        // Prevent instantiation
    }
}
