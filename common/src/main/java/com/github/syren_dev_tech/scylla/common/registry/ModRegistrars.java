package com.github.syren_dev_tech.scylla.common.registry;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModRegistrars {
    IRegistrar<Block> blockRegistrar;
    IRegistrar<Item> itemRegistrar;
    IRegistrar<CreativeModeTab> creativeTabRegistrar;
    IMobRegistrar<EntityType<? extends LivingEntity>> entityRegistrar;

    public ModRegistrars() {
        // NO-OP
    }

    public ModRegistrars setBlockRegistrar(IRegistrar<Block> blockRegistrar) {
        this.blockRegistrar = blockRegistrar;
        return this;
    }

    public ModRegistrars setItemRegistrar(IRegistrar<Item> itemRegistrar) {
        this.itemRegistrar = itemRegistrar;
        return this;
    }

    public ModRegistrars setCreativeTabRegistrar(IRegistrar<CreativeModeTab> creativeTabRegistrar) {
        this.creativeTabRegistrar = creativeTabRegistrar;
        return this;
    }

    public ModRegistrars setEntityRegistrar(IMobRegistrar<EntityType<? extends LivingEntity>> entityRegistrar) {
        this.entityRegistrar = entityRegistrar;
        return this;
    }
}