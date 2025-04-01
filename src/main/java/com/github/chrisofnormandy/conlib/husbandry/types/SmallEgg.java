package com.github.chrisofnormandy.conlib.husbandry.types;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.event.ForgeEventFactory;

public class SmallEgg<T extends Animal> extends TurtleEggBlock {

    private final EntityType<T> entityType;

    public SmallEgg(EntityType<T> entityType, Properties properties) {
        super(properties);
        this.entityType = entityType;
    }

    private boolean shouldUpdateHatchLevelx(Level p_57766_) {
        float f = p_57766_.getTimeOfDay(1.0F);
        if (f < 0.69D && f > 0.65D) {
            return true;
        } else {
            return p_57766_.random.nextInt(500) == 0;
        }
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randSource) {
        if (this.shouldUpdateHatchLevelx(serverLevel) && onSand(serverLevel, blockPos)) {
            int i = blockState.getValue(HATCH);
            if (i < 2) {
                serverLevel.playSound((Player) null, blockPos, SoundEvents.TURTLE_EGG_CRACK, SoundSource.BLOCKS, 0.7F, 0.9F + randSource.nextFloat() * 0.2F);
                serverLevel.setBlock(blockPos, blockState.setValue(HATCH, Integer.valueOf(i + 1)), 2);
            } else {
                serverLevel.playSound((Player) null, blockPos, SoundEvents.TURTLE_EGG_HATCH, SoundSource.BLOCKS, 0.7F, 0.9F + randSource.nextFloat() * 0.2F);
                serverLevel.removeBlock(blockPos, false);

                for (int j = 0; j < blockState.getValue(EGGS); ++j) {
                    serverLevel.levelEvent(2001, blockPos, Block.getId(blockState));
                    T creature = this.entityType.create(serverLevel);
                    if (creature != null) {
                        creature.setAge(-24000);
                        creature.moveTo(blockPos.getX() + 0.3D + j * 0.2D, blockPos.getY(), blockPos.getZ() + 0.3D, 0.0F, 0.0F);
                        serverLevel.addFreshEntity(creature);
                    }
                }
            }
        }
    }
}
