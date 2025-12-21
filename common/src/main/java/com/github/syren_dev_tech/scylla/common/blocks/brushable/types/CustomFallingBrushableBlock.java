package com.github.syren_dev_tech.scylla.common.blocks.brushable.types;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class CustomFallingBrushableBlock extends CustomBrushableBlock implements Fallable {
    public CustomFallingBrushableBlock(Block turnsInto, Properties properties, SoundEvent brushSound, SoundEvent brushCompletedStone) {
        super(turnsInto, properties, brushSound, brushCompletedStone);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) { // NOSONAR - Ignore deprecation warning
        super.tick(blockState, serverLevel, blockPos, randomSource);

        if (FallingBlock.isFree(serverLevel.getBlockState(blockPos.below())) && blockPos.getY() >= serverLevel.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(serverLevel, blockPos, blockState);
            fallingblockentity.disableDrop();
        }
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos blockPos, FallingBlockEntity fallingBlockEntity) {
        Vec3 vec3 = fallingBlockEntity.getBoundingBox().getCenter();
        level.levelEvent(2001, BlockPos.containing(vec3), Block.getId(fallingBlockEntity.getBlockState()));
        level.gameEvent(fallingBlockEntity, GameEvent.BLOCK_DESTROY, vec3);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(16) == 0) {
            BlockPos blockpos = blockPos.below();

            if (FallingBlock.isFree(level.getBlockState(blockpos))) {
                double d0 = blockPos.getX() + randomSource.nextDouble();
                double d1 = blockPos.getY() - 0.05D;
                double d2 = blockPos.getZ() + randomSource.nextDouble();
                level.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, blockState), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }

    }
}
