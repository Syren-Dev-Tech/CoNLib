package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.mobs.types.CustomCreature;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobRegistry {
    private final ModRegister registry;
    private final ModelRegistry modelRegistry;
    private final DeferredRegister<EntityType<?>> ENTITY_TYPES;

    public final HashMap<RegistryObject<EntityType<CustomCreature>>, Supplier<AttributeSupplier.Builder>> entityAttributes = new HashMap<>();
    public final HashMap<String, RegistryObject<? extends EntityType<CustomCreature>>> entities = new HashMap<>();

    public final void finish(IEventBus bus) {
        CoNLib.LOGGER.info("Finishing entity registration");

        ENTITY_TYPES.register(bus);
        this.modelRegistry.finish(bus, entities);
    }

    public AttributeSupplier.Builder createAttributes() {
        CoNLib.LOGGER.info("Creating entity attributes");

        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public final Supplier<EntityType<CustomCreature>> register(String name, EntityFactory<CustomCreature> factory) {
        CoNLib.LOGGER.info("Registering entity: " + name);

        var entityTypeRegistry = this.ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE).sized(0.6F, 1.8F).build(name));

        this.entities.put(name, entityTypeRegistry);
        this.entityAttributes.put(entityTypeRegistry, () -> createAttributes());

        return entityTypeRegistry;
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        CoNLib.LOGGER.info("Registering entity attributes");

        entityAttributes.forEach((entityRegistryObject, attributesSupplier) -> {
            if (entityRegistryObject.isPresent()) {
                CoNLib.LOGGER.info("Registering attributes for entity: " + entityRegistryObject);

                var attributes = attributesSupplier.get().build();
                var entity = entityRegistryObject.get();

                event.put(entity, attributes);
            } else {
                CoNLib.LOGGER.error("Failed to register attributes for entity: " + entityRegistryObject);
            }
        });
    }

    public void registerEntityModels(FMLClientSetupEvent event) {
        CoNLib.LOGGER.info("Registering entity models");

        entities.forEach((name, entityRegistryObject) -> {
            if (entityRegistryObject.isPresent()) {
                CoNLib.LOGGER.info("Registering model for entity: " + name);

                var entity = entityRegistryObject.get();
                this.modelRegistry.register(name, () -> entity);
            } else {
                CoNLib.LOGGER.error("Failed to register model for entity: " + name);
            }
        });
    }

    public MobRegistry(ModRegister registry) {
        this.registry = registry;
        this.ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, registry.modId);
        this.modelRegistry = new ModelRegistry(registry);
    }
}
