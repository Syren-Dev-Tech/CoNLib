package com.github.syren_dev_tech.scylla.common.crops.types;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Crop extends CropBlock {

    private final CropProperties cropProperties;

    private Supplier<Item> plantableItem;

    public Crop(CropProperties properties, Supplier<Item> plantableItem) {
        super(properties.get());

        this.cropProperties = properties;
        this.plantableItem = plantableItem;
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return this.cropProperties.getAgeProperty();
    }

    @Override
    public int getMaxAge() {
        return this.cropProperties.getMaxAge();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.plantableItem.get();
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) { // NOSONAR - Ignore deprecation warning
        if (randomSource.nextInt(3) != 0)
            super.randomTick(blockState, serverLevel, blockPos, randomSource);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 3;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) { // NOSONAR - Ignore deprecation warning
        return cropProperties.getShapeByAge(this.getAge(blockState)); // Select the first shape as an example
    }
}