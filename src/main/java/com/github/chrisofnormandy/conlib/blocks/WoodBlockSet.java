package com.github.chrisofnormandy.conlib.blocks;

import com.github.chrisofnormandy.conlib.blocks.basic.FenceBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.PillarBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.Slabs;
import com.github.chrisofnormandy.conlib.blocks.basic.Stairs;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.HangingSigns;
import com.github.chrisofnormandy.conlib.blocks.decoration.signs.Signs;
import com.github.chrisofnormandy.conlib.blocks.redstone.Buttons;
import com.github.chrisofnormandy.conlib.blocks.redstone.Doors;
import com.github.chrisofnormandy.conlib.blocks.redstone.FenceGates;
import com.github.chrisofnormandy.conlib.blocks.redstone.PressurePlates;
import com.github.chrisofnormandy.conlib.blocks.redstone.TrapDoors;
import com.github.chrisofnormandy.conlib.registry.ItemRegistry;

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
        public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            PillarBlocks.create(name + "_log", creativeTab);
            PillarBlocks.create("stripped_" + name + "_log", creativeTab);
            FullBlocks.create(name + "_wood", creativeTab);
            FullBlocks.create("stripped_" + name + "_wood", creativeTab);
        }
    }

    public static class PlankSets {
        public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            BlockSetType blockSetType = new BlockSetType(name);
            BlockSetType.register(blockSetType);
            WoodType woodType = new WoodType(name, blockSetType);
            WoodType.register(woodType);

            var plankProperties = Properties.copy(Blocks.OAK_PLANKS);
            var planks = FullBlocks.create(name + "_planks", plankProperties, creativeTab);

            Slabs.create(name + "_slab", plankProperties, creativeTab);
            Stairs.create(name + "_stairs", plankProperties, () -> planks.get(), creativeTab);
            FenceBlocks.create(name + "_fence", plankProperties, creativeTab);
            FenceGates.create(name + "_fence_gate", plankProperties, woodType, creativeTab);
            Doors.create(name + "_door", plankProperties, blockSetType, creativeTab);
            TrapDoors.create(name + "_trapdoor", plankProperties, blockSetType, creativeTab);

            PressurePlates.create(name + "_pressure_plate",
                    plankProperties,
                    Sensitivity.EVERYTHING,
                    blockSetType,
                    creativeTab);
            Buttons.create(name + "_button", plankProperties, creativeTab);

            Signs.create(name, plankProperties, creativeTab);
            HangingSigns.create(name, plankProperties, creativeTab);
        }
    }

    public static class MiscWoodenSets {
        public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
            ItemRegistry.register(name + "_boat",
                    () -> new BoatItem(false, Boat.Type.OAK, new Item.Properties().stacksTo(1)),
                    creativeTab);
            ItemRegistry.register(name + "_chest_boat",
                    () -> new BoatItem(true, Boat.Type.OAK, new Item.Properties().stacksTo(1)),
                    creativeTab);
        }
    }

    public static final void create(String name, ResourceKey<CreativeModeTab> creativeTab) {
        LogSets.create(name, creativeTab);
        PlankSets.create(name, creativeTab);
        MiscWoodenSets.create(name, creativeTab);
    }
}
