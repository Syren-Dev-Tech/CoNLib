package com.github.syren_dev_tech.scylla.mobs.creatures;

import net.minecraft.world.entity.ai.goal.Goal;

public class AIGoal {
    public final int priority;
    public final Goal goal;

    public AIGoal(int priority, Goal goal) {
        this.priority = priority;
        this.goal = goal;
    }
}
