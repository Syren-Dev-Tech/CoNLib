package com.github.chrisofnormandy.conlib.blocks;

import com.github.chrisofnormandy.conlib.blocks.basic.FullBlocks;
import com.github.chrisofnormandy.conlib.blocks.basic.Slabs;
import com.github.chrisofnormandy.conlib.blocks.basic.Stairs;
import com.github.chrisofnormandy.conlib.blocks.basic.WallBlocks;
import com.github.chrisofnormandy.conlib.blocks.redstone.Buttons;
import com.github.chrisofnormandy.conlib.blocks.redstone.PressurePlates;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class StoneBlockSet {

    public static final void create(ModRegister register, String name, ResourceKey<CreativeModeTab> creativeTab) {
        BlockSetType blockSetType = new BlockSetType(name);
        BlockSetType.register(blockSetType);

        var stoneProperties = Properties.copy(Blocks.STONE);
        var stone = FullBlocks.create(register, name, stoneProperties, creativeTab);

        Slabs.create(register, name + "_slab", stoneProperties, creativeTab);
        Stairs.create(register, name + "_stairs", stoneProperties, stone::get, creativeTab);
        WallBlocks.create(register, name + "_wall", stoneProperties, creativeTab);

        PressurePlates.create(register, name + "_pressure_plate", stoneProperties, Sensitivity.EVERYTHING, blockSetType, creativeTab);
        Buttons.create(register, name + "_button", stoneProperties, creativeTab);
    }

    private StoneBlockSet() {
        // Prevent instantiation
    }
}
