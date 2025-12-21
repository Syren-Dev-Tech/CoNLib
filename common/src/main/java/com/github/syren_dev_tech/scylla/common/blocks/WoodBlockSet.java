package com.github.syren_dev_tech.scylla.common.blocks;

import com.github.syren_dev_tech.scylla.common.blocks.basic.FenceBlocks;
import com.github.syren_dev_tech.scylla.common.blocks.basic.FullBlocks;
import com.github.syren_dev_tech.scylla.common.blocks.basic.PillarBlocks;
import com.github.syren_dev_tech.scylla.common.blocks.basic.Slabs;
import com.github.syren_dev_tech.scylla.common.blocks.basic.Stairs;
import com.github.syren_dev_tech.scylla.common.blocks.decoration.signs.HangingSigns;
import com.github.syren_dev_tech.scylla.common.blocks.decoration.signs.Signs;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.Buttons;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.Doors;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.FenceGates;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.PressurePlates;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.TrapDoors;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodBlockSet {

    public static class LogSets {

        public static final void create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            PillarBlocks.create(register, name + "_log", creativeTab);
            PillarBlocks.create(register, "stripped_" + name + "_log", creativeTab);
            FullBlocks.create(register, name + "_wood", creativeTab);
            FullBlocks.create(register, "stripped_" + name + "_wood", creativeTab);
        }

        private LogSets() {
            // Prevent instantiation
        }
    }

    public static class PlankSets {

        public static final void create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            BlockSetType blockSetType = new BlockSetType(name);
            BlockSetType.register(blockSetType);
            WoodType woodType = new WoodType(name, blockSetType);
            WoodType.register(woodType);

            var plankProperties = Properties.copy(Blocks.OAK_PLANKS);
            var planks = FullBlocks.create(register, name + "_planks", plankProperties, creativeTab);

            Slabs.create(register, name + "_slab", plankProperties, creativeTab);
            Stairs.create(register, name + "_stairs", plankProperties, planks::get, creativeTab);
            FenceBlocks.create(register, name + "_fence", plankProperties, creativeTab);
            FenceGates.create(register, name + "_fence_gate", plankProperties, woodType, creativeTab);
            Doors.create(register, name + "_door", plankProperties, blockSetType, creativeTab);
            TrapDoors.create(register, name + "_trapdoor", plankProperties, blockSetType, creativeTab);

            PressurePlates.create(register, name + "_pressure_plate", plankProperties, Sensitivity.EVERYTHING, blockSetType, creativeTab);
            Buttons.create(register, name + "_button", plankProperties, creativeTab);

            Signs.create(register, name, plankProperties, creativeTab);
            HangingSigns.create(register, name, plankProperties, creativeTab);
        }

        private PlankSets() {
            // Prevent instantiation
        }
    }

    public static class MiscWoodenSets {

        public static final void create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
            register.itemRegistry.register(name + "_boat", () -> new BoatItem(false, Boat.Type.OAK, new Item.Properties().stacksTo(1)), creativeTab);
            register.itemRegistry.register(name + "_chest_boat", () -> new BoatItem(true, Boat.Type.OAK, new Item.Properties().stacksTo(1)), creativeTab);
        }

        private MiscWoodenSets() {
            // Prevent instantiation
        }
    }

    public static final void create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        LogSets.create(register, name, creativeTab);
        PlankSets.create(register, name, creativeTab);
        MiscWoodenSets.create(register, name, creativeTab);
    }

    private WoodBlockSet() {
        // Prevent instantiation
    }
}
