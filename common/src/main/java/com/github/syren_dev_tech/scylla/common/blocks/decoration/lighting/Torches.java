package com.github.syren_dev_tech.scylla.common.blocks.decoration.lighting;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Torches {

    public static class StandingTorches {

        public static final Supplier<TorchBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME);
        }

        public static final Supplier<TorchBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME, creativeTab);
        }

        public static final Supplier<TorchBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, ParticleTypes.FLAME);
        }

        public static final Supplier<TorchBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, ParticleTypes.FLAME, creativeTab);
        }

        public static final Supplier<TorchBlock> create(ModRegister register, String name, Properties properties, ParticleOptions particle) {
            return register.blockRegistry.register(name, () -> new TorchBlock(properties, particle));
        }

        public static final Supplier<TorchBlock> create(ModRegister register, String name, Properties properties, ParticleOptions particle, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new TorchBlock(properties, particle), creativeTab);
        }

        private StandingTorches() {
            // Prevent instantiation
        }
    }

    public static class WallTorches {

        public static final Supplier<WallTorchBlock> create(ModRegister register, String name) {
            return create(register, name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME);
        }

        public static final Supplier<WallTorchBlock> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, Properties.copy(Blocks.TORCH), ParticleTypes.FLAME, creativeTab);
        }

        public static final Supplier<WallTorchBlock> create(ModRegister register, String name, Properties properties) {
            return create(register, name, properties, ParticleTypes.FLAME);
        }

        public static final Supplier<WallTorchBlock> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
            return create(register, name, properties, ParticleTypes.FLAME, creativeTab);
        }

        public static final Supplier<WallTorchBlock> create(ModRegister register, String name, Properties properties, ParticleOptions particle) {
            return register.blockRegistry.register(name, () -> new WallTorchBlock(properties, particle));
        }

        public static final Supplier<WallTorchBlock> create(ModRegister register, String name, Properties properties, ParticleOptions particle, ResourceKey<CreativeModeTab> creativeTab) {
            return register.blockRegistry.register(name, () -> new WallTorchBlock(properties, particle), creativeTab);
        }

        private WallTorches() {
            // Prevent instantiation
        }
    }

    private static final String WALL_PREFIX = "wall_";

    public static final Tuple<Supplier<TorchBlock>, Supplier<WallTorchBlock>> create(ModRegister register, String name) {
        var standing = StandingTorches.create(register, name);
        var wall = WallTorches.create(register, WALL_PREFIX + name);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<Supplier<TorchBlock>, Supplier<WallTorchBlock>> create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingTorches.create(register, name, creativeTab);
        var wall = WallTorches.create(register, WALL_PREFIX + name);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<Supplier<TorchBlock>, Supplier<WallTorchBlock>> create(ModRegister register, String name, Properties properties) {
        var standing = StandingTorches.create(register, name, properties);
        var wall = WallTorches.create(register, WALL_PREFIX + name, properties);

        return new Tuple<>(standing, wall);
    }

    public static final Tuple<Supplier<TorchBlock>, Supplier<WallTorchBlock>> create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        var standing = StandingTorches.create(register, name, properties, creativeTab);
        var wall = WallTorches.create(register, WALL_PREFIX + name, properties);

        return new Tuple<>(standing, wall);
    }

    private Torches() {
        // Prevent instantiation
    }
}
