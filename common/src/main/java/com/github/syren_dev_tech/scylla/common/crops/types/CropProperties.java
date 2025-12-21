package com.github.syren_dev_tech.scylla.common.crops.types;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CropProperties {

    private final Properties blockProperties;
    private IntegerProperty age = BlockStateProperties.AGE_3;
    private int maxAge = 3;
    private VoxelShape[] shapeByAge = new VoxelShape[] { Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D) };

    public CropProperties() {
        this.blockProperties = Properties.copy(Blocks.WHEAT);
    }

    public CropProperties(Properties properties) {
        this.blockProperties = properties;
    }

    public Properties get() {
        return this.blockProperties;
    }

    public CropProperties setMaxAge(int maxAge) {
        this.maxAge = maxAge;

        return this;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public CropProperties setShapeByAge(int age, VoxelShape shapeByAge) {
        this.shapeByAge[age] = shapeByAge;

        return this;
    }

    public VoxelShape getShapeByAge(int age) {
        return this.shapeByAge[age];
    }

    public IntegerProperty getAgeProperty() {
        return this.age;
    }
}
