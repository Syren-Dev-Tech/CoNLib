package com.github.chrisofnormandy.conlib.husbandry;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.husbandry.types.WaterEgg;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

// Needs custom implementation...

public class WaterEggs {

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.FROGSPAWN));
    }

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.FROGSPAWN), creativeTab);
    }

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new WaterEgg<T>(properties));
    }

    public static final <T extends Animal> Supplier<WaterEgg<T>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new WaterEgg<T>(properties), creativeTab);
    }

    private WaterEggs() {
        // Prevent instantiation
    }
}
