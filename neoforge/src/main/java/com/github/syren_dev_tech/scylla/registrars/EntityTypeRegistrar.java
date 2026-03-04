package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.registry.IMobRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class EntityTypeRegistrar<T extends EntityType<? extends LivingEntity>> implements IMobRegistrar<T> {

    @Override
    public <X> void setAttributeCreationEvent(X event) {
        this.attributeCreationEvent = (EntityAttributeCreationEvent) event;
    }

    private final DeferredRegister<EntityType<?>> entityTypesRegistry;
    private EntityAttributeCreationEvent attributeCreationEvent;
    private FMLClientSetupEvent clientSetupEvent;

    public EntityTypeRegistrar(String modId) {
        this.entityTypesRegistry = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, modId);
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
        attributeCreationEvent.put(entity, attributes);
    }

    @Override
    public <X> void finish(X bus) {
        finishBus((IEventBus) bus);
    }
}
