package com.github.syren_dev_tech.scylla.common.blocks.decoration.crystals.types;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingCrystal<T extends Block> extends BuddingAmethystBlock {
    private static final Direction[] DIRECTIONS = Direction.values();

    @SuppressWarnings("unchecked")
    private Supplier<T> smallCrystal = () -> (T) Blocks.SMALL_AMETHYST_BUD;
    @SuppressWarnings("unchecked")
    private Supplier<T> mediumCrystal = () -> (T) Blocks.MEDIUM_AMETHYST_BUD;
    @SuppressWarnings("unchecked")
    private Supplier<T> largeCrystal = () -> (T) Blocks.LARGE_AMETHYST_BUD;
    @SuppressWarnings("unchecked")
    private Supplier<T> fullCrystal = () -> (T) Blocks.AMETHYST_CLUSTER;

    public BuddingCrystal(Properties properties) {
        super(properties);
    }

    public BuddingCrystal(Properties properties, BuddingCrystalProperties<T> budProperties) {
        super(properties);

        this.smallCrystal = budProperties.smallCrystal;
        this.mediumCrystal = budProperties.mediumCrystal;
        this.largeCrystal = budProperties.largeCrystal;
        this.fullCrystal = budProperties.fullCrystal;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) { // NOSONAR - Ignore deprecation warning
        if (randomSource.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[randomSource.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = blockPos.relative(direction);
            BlockState blockstate = serverLevel.getBlockState(blockpos);
            Block block = null;

            if (canClusterGrowAtState(blockstate)) {
                block = this.smallCrystal.get();
            } else if (blockstate.is(this.smallCrystal.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = this.mediumCrystal.get();
            } else if (blockstate.is(this.mediumCrystal.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = this.largeCrystal.get();
            } else if (blockstate.is(this.largeCrystal.get()) && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                block = this.fullCrystal.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                serverLevel.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }
}
