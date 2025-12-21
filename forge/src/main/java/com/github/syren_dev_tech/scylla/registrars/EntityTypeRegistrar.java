package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.common.mobs.CreatureRegistrar;
import com.github.syren_dev_tech.scylla.common.registry.IMobRegistrar;
import com.github.syren_dev_tech.scylla.common.registry.IRegistrar;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EntityTypeRegistrar<T extends EntityType<?>> implements IMobRegistrar<T> {

    private final DeferredRegister<EntityType<?>> entityTypesRegistry;

    public EntityTypeRegistrar(String modId) {
        this.entityTypesRegistry = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, modId);
    }

    @Override
    public <X extends T> Supplier<X> register(String modId, String name, Supplier<X> supplier) {
        return entityTypesRegistry.register(name, supplier);
    }

    public void finishBus(IEventBus bus) {
        entityTypesRegistry.register(bus);
    }

    @Override
    public <X extends T> void register(X entity, AttributeSupplier attributes) {

    }

    @Override
    public void register(CreatureRegistrar<?> registrar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public <X> void finish(X bus) {
        finishBus((IEventBus) bus);
    }
}
