package com.github.syren_dev_tech.scylla.blocks.brushable.types;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CustomBrushableBlock extends BaseEntityBlock {

    private static final IntegerProperty DUSTED = BlockStateProperties.DUSTED;
    public static final int TICK_DELAY = 2;
    private final Block turnsInto;
    private final SoundEvent brushSound;
    private final SoundEvent brushCompletedSound;

    public CustomBrushableBlock(Block turnsInto, Properties properties, SoundEvent brushSound, SoundEvent brushCompletedSound) {
        super(properties);
        this.turnsInto = turnsInto;
        this.brushSound = brushSound;
        this.brushCompletedSound = brushCompletedSound;
        this.registerDefaultState(this.stateDefinition.any().setValue(DUSTED, Integer.valueOf(0)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DUSTED);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) { // NOSONAR - Ignore deprecation warning
        return RenderShape.MODEL;
    }

    @Override
    public void onPlace(BlockState unused1, Level level, BlockPos blockPos, BlockState unused2, boolean unused3) { // NOSONAR - Ignore deprecation warning
        level.scheduleTick(blockPos, this, 2);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState nextBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos nextBlockPos) { // NOSONAR - Ignore deprecation warning
        levelAccessor.scheduleTick(blockPos, this, 2);

        return blockState;
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) { // NOSONAR - Ignore deprecation warning
        BlockEntity blockentity = serverLevel.getBlockEntity(blockPos);
        if (blockentity instanceof BrushableBlockEntity brushableblockentity) {
            brushableblockentity.checkReset();
        }
    }

    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BrushableBlockEntity(blockPos, blockState);
    }

    public Block getTurnsInto() {
        return this.turnsInto;
    }

    public SoundEvent getBrushSound() {
        return this.brushSound;
    }

    public SoundEvent getBrushCompletedSound() {
        return this.brushCompletedSound;
    }
}
