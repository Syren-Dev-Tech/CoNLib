package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SnifferEggBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class MediumEgg<T extends Animal> extends SnifferEggBlock {

    private final MediumEggData<T> eggData;

    public MediumEgg(Properties properties, MediumEggData<T> eggData) {
        super(properties);
        this.eggData = eggData;
    }

    private boolean readyToHatch(BlockState blockState) {
        return this.getHatchLevel(blockState) == 2;
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randSource) { // NOSONAR - Ignore deprecation warning
        if (!this.readyToHatch(blockState)) {
            serverLevel.playSound((Player) null, blockPos, SoundEvents.SNIFFER_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + randSource.nextFloat() * 0.2F);
            serverLevel.setBlock(blockPos, blockState.setValue(HATCH, Integer.valueOf(this.getHatchLevel(blockState) + 1)), 2);
        } else {
            serverLevel.playSound((Player) null, blockPos, SoundEvents.SNIFFER_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F + randSource.nextFloat() * 0.2F);
            serverLevel.destroyBlock(blockPos, false);

            this.eggData.spawn(serverLevel, (T newCreature) -> {
                Vec3 vec3 = blockPos.getCenter();
                newCreature.moveTo(vec3.x(), vec3.y(), vec3.z(), Mth.wrapDegrees(serverLevel.random.nextFloat() * 360.0F), 0.0F);
            });
        }
    }
}
