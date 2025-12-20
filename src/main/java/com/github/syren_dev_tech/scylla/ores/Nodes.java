package com.github.syren_dev_tech.scylla.ores;

import com.github.syren_dev_tech.scylla.ores.types.NodeBase;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Nodes {

    private Nodes() {
    }

    public static final NodeBase create(Block parent, NodeBase.Tier tier, Integer damage) {
        return new NodeBase(Properties.copy(parent), tier, damage, parent.asItem());
    }
}
