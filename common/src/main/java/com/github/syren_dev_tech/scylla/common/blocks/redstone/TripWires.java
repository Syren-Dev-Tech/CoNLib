package com.github.syren_dev_tech.scylla.common.blocks.redstone;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TripWireBlock;
import net.minecraft.world.level.block.TripWireHookBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TripWires {

    public static class TripWireHooks {
        public static final Supplier<TripWireHookBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.TRIPWIRE_HOOK));
        }

        public static final Supplier<TripWireHookBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TRIPWIRE_HOOK), creativeTab);
        }

        public static final Supplier<TripWireHookBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new TripWireHookBlock(properties));
        }

        public static final Supplier<TripWireHookBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new TripWireHookBlock(properties), creativeTab);
        }

        private TripWireHooks() {
            // Prevent instantiation
        }
    }

    public static final Supplier<TripWireBlock> create(ModRegister register, String name, TripWireHookBlock hookBlock) {
        return create(register, name, hookBlock, Properties.copy(Blocks.TRIPWIRE));
    }

    public static final Supplier<TripWireBlock> create(ModRegister register, String name, TripWireHookBlock hookBlock, ResourceKey<CreativeModeTab> creativeTab) {
        return create(register, name, hookBlock, Properties.copy(Blocks.TRIPWIRE), creativeTab);
    }

    public static final Supplier<TripWireBlock> create(ModRegister register, String name, TripWireHookBlock hookBlock, Properties properties) {
        return register.blockRegistry.register(name, () -> new TripWireBlock(hookBlock, properties));
    }

    public static final Supplier<TripWireBlock> create(ModRegister register, String name, TripWireHookBlock hookBlock, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return register.blockRegistry.register(name, () -> new TripWireBlock(hookBlock, properties), creativeTab);
    }

    private TripWires() {
        // Prevent instantiation
    }
}
