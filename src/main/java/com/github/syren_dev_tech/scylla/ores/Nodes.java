package com.github.syren_dev_tech.scylla.ores;

import com.github.syren_dev_tech.scylla.ores.types.NodeBase;

import net.minecraft.world.level.block.Block;

public class Nodes {
    public static final NodeBase create(Block parent, NodeBase.Tier tier, Integer damage) {
        return new NodeBase(Block.Properties.copy(parent), tier, damage, parent.asItem());
    }
}
