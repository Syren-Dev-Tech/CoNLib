package com.github.syren_dev_tech.scylla.common.blocks.plants.sponges;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.plants.sponges.types.Sponge;
import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WetSpongeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Sponges {

    public static class WetSponges {

        public static final Supplier<WetSpongeBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.WET_SPONGE));
        }

        public static final Supplier<WetSpongeBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.WET_SPONGE), creativeTab);
        }

        public static final Supplier<WetSpongeBlock> create(ModRegister register, String name, Properties properties) {
            return register.blockRegistry.register(name, () -> new WetSpongeBlock(properties));
        }

        public static final Supplier<WetSpongeBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new WetSpongeBlock(properties), creativeTab);
        }

        private WetSponges() {
            // Prevent instantiation
        }
    }

    // Add sea foliage and liquid to dry sponge after this.
    public static final Tuple<Supplier<Sponge>, Supplier<WetSpongeBlock>> create(ModRegister register, String name, Properties dryProperties, Properties wetProperties) {
        var wet = WetSponges.create(register, "wet_" + name, wetProperties);
        var dry = register.blockRegistry.register(name, () -> new Sponge(dryProperties));
        dry.get().setWetSponge(wet.get());

        return new Tuple<>(dry, wet);
    }

    // Add sea foliage and liquid to dry sponge after this.
    public static final Tuple<Supplier<Sponge>, Supplier<WetSpongeBlock>> create(ModRegister register, String name, Properties dryProperties, Properties wetProperties, ResourceKey<CreativeModeTab> creativeTab) {
        var wet = WetSponges.create(register, "wet_" + name, wetProperties, creativeTab);
        var dry = register.blockRegistry.register(name, () -> new Sponge(dryProperties), creativeTab);
        dry.get().setWetSponge(wet.get());

        return new Tuple<>(dry, wet);
    }

    private Sponges() {
        // Prevent instantiation
    }
}
