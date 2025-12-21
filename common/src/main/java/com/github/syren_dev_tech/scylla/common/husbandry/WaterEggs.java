package com.github.syren_dev_tech.scylla.common.husbandry;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.husbandry.types.WaterEgg;
import com.github.syren_dev_tech.scylla.common.husbandry.types.WaterEggData;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Needs custom implementation...

public class WaterEggs {

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, WaterEggData<T> eggData) {
        return create(register, name, Properties.copy(Blocks.FROGSPAWN), eggData);
    }

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, WaterEggData<T> eggData, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FROGSPAWN), eggData, creativeTab);
    }

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, Properties properties, WaterEggData<T> eggData) {
        return register.blockRegistry.register(name, () -> new WaterEgg<T>(properties, eggData));
    }

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, Properties properties, WaterEggData<T> eggData, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new WaterEgg<T>(properties, eggData), creativeTab);
    }

    private WaterEggs() {
        // Prevent instantiation
    }
}
