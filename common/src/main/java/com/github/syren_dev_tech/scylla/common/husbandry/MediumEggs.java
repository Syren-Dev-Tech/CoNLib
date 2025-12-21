package com.github.syren_dev_tech.scylla.common.husbandry;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.husbandry.types.MediumEgg;
import com.github.syren_dev_tech.scylla.common.husbandry.types.MediumEggData;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class MediumEggs {

    public static final <T extends Animal> Supplier<MediumEgg<T>> create(ModRegister register, String name, MediumEggData<T> eggData) {
        return create(register, name, Properties.copy(Blocks.SNIFFER_EGG), eggData);
    }

    public static final <T extends Animal> Supplier<MediumEgg<T>> create(ModRegister register, String name, MediumEggData<T> eggData, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.SNIFFER_EGG), eggData, creativeTab);
    }

    public static final <T extends Animal> Supplier<MediumEgg<T>> create(ModRegister register, String name, Properties properties, MediumEggData<T> eggData) {
        return register.blockRegistry.register(name, () -> new MediumEgg<T>(properties, eggData));
    }

    public static final <T extends Animal> Supplier<MediumEgg<T>> create(ModRegister register, String name, Properties properties, MediumEggData<T> eggData, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new MediumEgg<T>(properties, eggData), creativeTab);
    }

    private MediumEggs() {
        // Prevent instantiation
    }
}
