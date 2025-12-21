package com.github.syren_dev_tech.scylla.common.registry;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.mobs.CreatureRegistrar;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public interface IMobRegistrar<T extends EntityType<?>> {
    <X extends T> void register(X entity, AttributeSupplier attributes);

    void register(CreatureRegistrar<?> registrar);

    <X> void finish(X bus);

    <X extends T> Supplier<X> register(String modId, String name, Supplier<X> supplier);
}
