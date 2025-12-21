package com.github.syren_dev_tech.scylla.common.mobs.creatures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.ClientUtils;

public class CustomFlyingCreature extends CustomCreature {
    private boolean isFlying = false;

    public CustomFlyingCreature(EntityType<? extends CustomCreature> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                // Add our flying animation controller
                new AnimationController<>(this, 10, state -> state.setAndContinue(this.isFlying ? DefaultAnimations.FLY : DefaultAnimations.IDLE))
                        // Handle the custom instruction keyframe that is part of our animation json
                        .setCustomInstructionKeyframeHandler(state -> {
                            Player player = ClientUtils.getClientPlayer();

                            if (player != null)
                                player.displayClientMessage(Component.literal("KeyFraming"), true);
                        }),
                // Add our generic living animation controller
                DefaultAnimations.genericLivingController(this));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        super.registerGoals();
    }
}
