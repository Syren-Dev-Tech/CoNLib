package com.github.syren_dev_tech.scylla.common.mobs.creatures;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class CustomSwimmingCreature extends CustomCreature {

    public CustomSwimmingCreature(EntityType<? extends CustomCreature> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        // Add swimming related goals here
        super.registerGoals();
    }
}
