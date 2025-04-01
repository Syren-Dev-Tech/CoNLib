package com.github.chrisofnormandy.conlib.husbandry;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class DragonEgg {

    public static final Supplier<DragonEggBlock> create(ModRegister register, String name) {
        return create(register, name, Properties.copy(Blocks.DRAGON_EGG));
    }

    public static final Supplier<DragonEggBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, Properties.copy(Blocks.DRAGON_EGG), creativeTab);
    }

    public static final Supplier<DragonEggBlock> create(ModRegister register, String name, Properties properties) {
        return register.blockRegistry.register(name, () -> new DragonEggBlock(properties));
    }

    public static final Supplier<DragonEggBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new DragonEggBlock(properties), creativeTab);
    }

    private DragonEgg() {
        // Prevent instantiation
    }
}
