package com.github.syren_dev_tech.scylla.registry;

import java.util.HashMap;
import java.util.Map;

import com.github.syren_dev_tech.scylla.Scylla;
import com.github.syren_dev_tech.scylla.mobs.CreatureBuilder;
import com.github.syren_dev_tech.scylla.mobs.CreatureRegistrar;
import com.github.syren_dev_tech.scylla.mobs.creatures.CustomCreature;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MobRegistry {

    private final DeferredRegister<EntityType<?>> deferredEntityTypeRegistry;

    public final Map<String, CreatureRegistrar<?, ?>> entities = new HashMap<>();

    public final void finish(IEventBus bus) {
        Scylla.LOGGER.info("Finishing entity registration");

        deferredEntityTypeRegistry.register(bus);
    }

    public AttributeSupplier.Builder createAttributes() {
        Scylla.LOGGER.info("Creating entity attributes");

        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public final <T extends CustomCreature> RegistryObject<EntityType<T>> register(CreatureBuilder<T> builder) {
        if (Scylla.LOGGER.isInfoEnabled())
            Scylla.LOGGER.info("Registering entity: {}", builder.name);

        return this.deferredEntityTypeRegistry.register(builder.name, () -> EntityType.Builder.of(builder.factory, MobCategory.CREATURE).sized(0.6F, 1.8F).build(builder.name));
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        if (Scylla.LOGGER.isInfoEnabled())
            Scylla.LOGGER.info("Registering entity attributes");

        entities.forEach((name, registrar) -> {
            Scylla.LOGGER.info("Registering attributes for: {}", name);

            registrar.registerAttributes(event);
        });
    }

    public MobRegistry(ModRegister registry) {
        this.deferredEntityTypeRegistry = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, registry.modId);
    }
}
