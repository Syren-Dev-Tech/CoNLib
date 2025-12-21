package com.github.syren_dev_tech.scylla.common.blocks;

import com.github.syren_dev_tech.scylla.common.blocks.basic.FullBlocks;
import com.github.syren_dev_tech.scylla.common.blocks.basic.Slabs;
import com.github.syren_dev_tech.scylla.common.blocks.basic.Stairs;
import com.github.syren_dev_tech.scylla.common.blocks.basic.WallBlocks;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.Buttons;
import com.github.syren_dev_tech.scylla.common.blocks.redstone.PressurePlates;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

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
