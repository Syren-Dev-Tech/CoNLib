package com.github.syren_dev_tech.scylla.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.CoNLib;
import com.github.syren_dev_tech.scylla.mobs.creatures.CreatureRegistrar;
import com.github.syren_dev_tech.scylla.mobs.creatures.CustomCreature;

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

public class MobRegistry {
    private final ModRegister registry;
    private final DeferredRegister<EntityType<?>> ENTITY_TYPES;

    public final HashMap<String, CreatureRegistrar<?, ?>> entities = new HashMap<>();

    public final void finish(IEventBus bus) {
        CoNLib.LOGGER.info("Finishing entity registration");

        ENTITY_TYPES.register(bus);
    }

    public AttributeSupplier.Builder createAttributes() {
        CoNLib.LOGGER.info("Creating entity attributes");

        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public final Supplier<EntityType<CustomCreature>> register(String name, EntityFactory<CustomCreature> factory) {
        CoNLib.LOGGER.info("Registering entity: " + name);

        var entityTypeRegistry = this.ENTITY_TYPES.register(name,
                () -> EntityType.Builder.of(factory, MobCategory.CREATURE).sized(0.6F, 1.8F).build(name));

        var registrar = new CreatureRegistrar<CustomCreature, EntityType<CustomCreature>>(registry, name,
                entityTypeRegistry, () -> createAttributes());
        this.entities.put(name, registrar);

        return entityTypeRegistry;
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        CoNLib.LOGGER.info("Registering entity attributes");

        entities.forEach((name, registrar) -> {
            CoNLib.LOGGER.info("Registering attributes for: " + name);

            registrar.registerAttributes(event);
        });
    }

    public void registerEntityModels(FMLClientSetupEvent event) {
        CoNLib.LOGGER.info("Registering entity models");

        entities.forEach((name, entityRegistryObject) -> {
            CoNLib.LOGGER.info("Registering entity model for: " + name);

            entityRegistryObject.register(event);
        });
    }

    public MobRegistry(ModRegister registry) {
        this.registry = registry;
        this.ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, registry.modId);
    }
}
