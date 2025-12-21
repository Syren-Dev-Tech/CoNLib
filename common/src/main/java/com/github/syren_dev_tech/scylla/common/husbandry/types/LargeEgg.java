package com.github.syren_dev_tech.scylla.common.husbandry.types;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DragonEggBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LargeEgg<T extends Animal> extends DragonEggBlock {

    private final LargeEggData<T> eggData;

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) { // NOSONAR - Ignore deprecation warning
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) { // NOSONAR - Ignore deprecation warning
        // No-op
    }

    public LargeEgg(Properties properties, LargeEggData<T> eggData) {
        super(properties);
        this.eggData = eggData;
    }

    public LargeEggData<T> getEggData() {
        return eggData;
    }
}
