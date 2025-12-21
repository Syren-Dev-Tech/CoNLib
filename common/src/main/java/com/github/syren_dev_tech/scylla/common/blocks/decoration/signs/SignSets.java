package com.github.syren_dev_tech.scylla.common.blocks.decoration.signs;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.blocks.decoration.signs.HangingSigns.CeilingHangingSigns;
import com.github.syren_dev_tech.scylla.common.blocks.decoration.signs.HangingSigns.WallHangingSigns;
import com.github.syren_dev_tech.scylla.common.blocks.decoration.signs.Signs.StandingSigns;
import com.github.syren_dev_tech.scylla.common.blocks.decoration.signs.Signs.WallSigns;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SignSets {

    public static final Supplier<?>[] create(ModRegister register, String name) {
        return new Supplier<?>[] { StandingSigns.create(register, name), WallSigns.create(register, "wall_" + name), CeilingHangingSigns.create(register, "hanging_" + name), WallHangingSigns.create(register, "wall_hanging_" + name) };
    }

    public static final Supplier<?>[] create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        return new Supplier<?>[] { StandingSigns.create(register, name, creativeTab), WallSigns.create(register, "wall_" + name), CeilingHangingSigns.create(register, "hanging_" + name, creativeTab), WallHangingSigns.create(register, "wall_hanging_" + name) };
    }

    public static final Supplier<?>[] create(ModRegister register, String name, Properties properties) {
        return new Supplier<?>[] { StandingSigns.create(register, name, properties), WallSigns.create(register, "wall_" + name, properties), CeilingHangingSigns.create(register, "hanging_" + name, properties), WallHangingSigns.create(register, "wall_hanging_" + name, properties) };
    }

    public static final Supplier<?>[] create(ModRegister register, String name, Properties properties, ResourceKey<CreativeModeTab> creativeTab) {
        return new Supplier<?>[] { StandingSigns.create(register, name, properties, creativeTab), WallSigns.create(register, "wall_" + name, properties), CeilingHangingSigns.create(register, "hanging_" + name, properties, creativeTab), WallHangingSigns.create(register, "wall_hanging_" + name, properties) };
    }

    private SignSets() {
        // Prevent instantiation
    }
}
