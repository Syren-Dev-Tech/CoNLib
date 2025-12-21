package com.github.syren_dev_tech.scylla.common.dimensions.portals;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VerticalPortal extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final int AABB_OFFSET = 2;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    // This should be a set:
    private EntityType<?>[] spawnableEntities = new EntityType<?>[] {};
    private SoundEvent ambientSound = SoundEvents.PORTAL_AMBIENT;
    private ParticleOptions particles = ParticleTypes.PORTAL;

    public VerticalPortal(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) { // NOSONAR - Ignore deprecation warning
        if (blockState.getValue(AXIS) == Direction.Axis.Z)
            return Z_AXIS_AABB;

        return X_AXIS_AABB;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) { // NOSONAR - Ignore deprecation warning
        if (spawnableEntities.length == 0)
            return;

        boolean spawningAllowed = serverLevel.dimensionType().natural() && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING);
        boolean onRand = randomSource.nextInt(2000) < serverLevel.getDifficulty().getId();

        if (spawningAllowed && onRand) {
            while (serverLevel.getBlockState(blockPos).is(this))
                blockPos = blockPos.below();

            EntityType<?> entityToSpawn = this.spawnableEntities[randomSource.nextInt(spawnableEntities.length)];

            if (serverLevel.getBlockState(blockPos).isValidSpawn(serverLevel, blockPos, entityToSpawn)) {
                Entity entity = entityToSpawn.spawn(serverLevel, blockPos.above(), MobSpawnType.STRUCTURE);

                if (entity != null)
                    entity.setPortalCooldown();
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState sourceBlockState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPosY) { // NOSONAR - Ignore deprecation warning
        Direction.Axis directionAxis = direction.getAxis();
        Direction.Axis directionAxis1 = blockState.getValue(AXIS);

        boolean flag = directionAxis1 != directionAxis && directionAxis.isHorizontal();

        return !flag && !sourceBlockState.is(this) && !(new PortalShape(levelAccessor, blockPos, directionAxis1)).isComplete() ? Blocks.AIR.defaultBlockState() : blockState;
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) { // NOSONAR - Ignore deprecation warning
        if (entity.canChangeDimensions())
            entity.handleInsidePortal(blockPos);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(100) == 0) {
            level.playLocalSound(blockPos.getX() + 0.5D, blockPos.getY() + 0.5D, blockPos.getZ() + 0.5D, this.ambientSound, SoundSource.BLOCKS, 0.5F, randomSource.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double d0 = blockPos.getX() + randomSource.nextDouble();
            double d1 = blockPos.getY() + randomSource.nextDouble();
            double d2 = blockPos.getZ() + randomSource.nextDouble();
            double d3 = (randomSource.nextFloat() - 0.5D) * 0.5D;
            double d4 = (randomSource.nextFloat() - 0.5D) * 0.5D;
            double d5 = (randomSource.nextFloat() - 0.5D) * 0.5D;
            int j = randomSource.nextInt(2) * 2 - 1;
            if (!level.getBlockState(blockPos.west()).is(this) && !level.getBlockState(blockPos.east()).is(this)) {
                d0 = blockPos.getX() + 0.5D + 0.25D * j;
                d3 = (randomSource.nextFloat() * 2.0F * j);
            } else {
                d2 = blockPos.getZ() + 0.5D + 0.25D * j;
                d5 = (randomSource.nextFloat() * 2.0F * j);
            }

            level.addParticle(this.particles, d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) { // NOSONAR - Ignore deprecation warning
        return ItemStack.EMPTY;
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) { // NOSONAR - Ignore deprecation warning
        switch (rotation) {
        case COUNTERCLOCKWISE_90, CLOCKWISE_90:
            switch (blockState.getValue(AXIS)) {
            case Z:
                return blockState.setValue(AXIS, Direction.Axis.X);
            case X:
                return blockState.setValue(AXIS, Direction.Axis.Z);
            default:
                return blockState;
            }
        default:
            return blockState;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }
}
