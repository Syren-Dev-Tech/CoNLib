package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.FrogspawnBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WaterEgg<T extends Animal> extends FrogspawnBlock {

    private final WaterEggData<T> eggData;

    public WaterEgg(Properties properties, WaterEggData<T> eggData) {
        super(properties);
        this.eggData = eggData;
    }

    private double getRandomPositionOffset(RandomSource randSource) {
        double d0 = (this.eggData.getHitboxWidth() / 2.0F);

        return Mth.clamp(randSource.nextDouble(), d0, 1.0D - d0);
    }

    private void spawnCreatures(ServerLevel serverLevel, BlockPos blockPos, RandomSource randSource) {
        int i = randSource.nextInt(this.eggData.getMinSpawn(), this.eggData.getMaxSpawn());

        for (int j = 1; j <= i; ++j) {
            this.eggData.spawn(serverLevel, (T newCreature) -> {
                double d0 = blockPos.getX() + this.getRandomPositionOffset(randSource);
                double d1 = blockPos.getZ() + this.getRandomPositionOffset(randSource);

                int k = randSource.nextInt(1, 361);

                newCreature.moveTo(d0, blockPos.getY() - 0.5D, d1, k, 0.0F);
                newCreature.setPersistenceRequired();
            });
        }
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randSource) { // NOSONAR - Ignore deprecation warning
        if (!this.canSurvive(blockState, serverLevel, blockPos)) {
            serverLevel.destroyBlock(blockPos, false);
        } else {
            serverLevel.destroyBlock(blockPos, false);
            serverLevel.playSound((Player) null, blockPos, eggData.getHatchSound(), SoundSource.BLOCKS, 1.0F, 1.0F);
            this.spawnCreatures(serverLevel, blockPos, randSource);
        }
    }
}
