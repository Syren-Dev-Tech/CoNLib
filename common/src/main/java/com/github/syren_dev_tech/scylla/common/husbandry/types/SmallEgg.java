package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SmallEgg<T extends Animal> extends TurtleEggBlock {

    private final SmallEggData<T> eggData;

    public SmallEgg(Properties properties, SmallEggData<T> eggData) {
        super(properties);
        this.eggData = eggData;
    }

    private boolean shouldUpdateHatchLevelx(Level level) {
        float f = level.getTimeOfDay(1.0F);
        if (f < eggData.getMaxTimeOfDay() && f > eggData.getMinTimeOfDay())
            return true;

        return level.random.nextInt(eggData.getRandHatchChance()) == 0;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randSource) { // NOSONAR - Ignore deprecation warning
        if (this.shouldUpdateHatchLevelx(serverLevel) && onSand(serverLevel, blockPos)) {
            int i = blockState.getValue(HATCH);
            if (i < 2) {
                serverLevel.playSound((Player) null, blockPos, eggData.getCrackSound(), SoundSource.BLOCKS, 0.7F, 0.9F + randSource.nextFloat() * 0.2F);
                serverLevel.setBlock(blockPos, blockState.setValue(HATCH, Integer.valueOf(i + 1)), 2);
            } else {
                serverLevel.playSound((Player) null, blockPos, eggData.getHatchSound(), SoundSource.BLOCKS, 0.7F, 0.9F + randSource.nextFloat() * 0.2F);
                serverLevel.removeBlock(blockPos, false);

                for (int j = 0; j < blockState.getValue(EGGS); ++j) {
                    final int index = j; // Make j effectively final
                    serverLevel.levelEvent(2001, blockPos, Block.getId(blockState));

                    this.eggData.spawn(serverLevel, (T newCreature) -> newCreature.moveTo(blockPos.getX() + 0.3D + index * 0.2D, blockPos.getY(), blockPos.getZ() + 0.3D, 0.0F, 0.0F));
                }
            }
        }
    }
}
