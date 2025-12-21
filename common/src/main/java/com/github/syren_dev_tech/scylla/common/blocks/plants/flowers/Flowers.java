package com.github.syren_dev_tech.scylla.common.blocks.plants.flowers;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.flowers.types.CustomFlower;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Flowers {

    public static final Supplier<CustomFlower> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.POPPY), MobEffects.HEAL, 0);
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.POPPY), MobEffects.HEAL, 0, creativeTab);
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, Properties properties) {
        return create(register, name, properties, MobEffects.HEAL, 0);
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, properties, MobEffects.HEAL, 0, creativeTab);
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, MobEffect effect, Integer duration) {
        return create(register, name, Properties.copy(Blocks.POPPY), effect, duration);
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, MobEffect effect, Integer duration, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.POPPY), effect, duration, creativeTab);
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, Properties properties, MobEffect effect, Integer duration) {
        return register.blockRegistry.register(name, () -> new CustomFlower(() -> effect, duration, properties));
    }

    public static final Supplier<CustomFlower> create(ModRegister register, String name, Properties properties, MobEffect effect, Integer duration, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new CustomFlower(() -> effect, duration, properties), creativeTab);
    }

    private Flowers() {
        // Prevent instantiation
    }
}
