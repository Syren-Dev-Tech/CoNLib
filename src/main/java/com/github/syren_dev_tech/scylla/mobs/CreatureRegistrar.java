package com.github.syren_dev_tech.scylla.mobs;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.Scylla;
import com.github.syren_dev_tech.scylla.mobs.client.CustomCreatureRenderer;
import com.github.syren_dev_tech.scylla.mobs.creatures.CustomCreature;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

public class CreatureRegistrar<T extends CustomCreature, E extends EntityType<T>> {

    private final CreatureBuilder<T> builder;
    private final RegistryObject<E> entityType;
    private final Supplier<AttributeSupplier.Builder> attributes;

    public CreatureRegistrar(CreatureBuilder<T> builder, RegistryObject<E> entityType, Supplier<AttributeSupplier.Builder> attributes) {
        this.builder = builder;
        this.entityType = entityType;
        this.attributes = attributes;
    }

    public RegistryObject<E> getEntityType() {
        return entityType;
    }

    public void registerAttributes(EntityAttributeCreationEvent event) {
        Scylla.LOGGER.info("Registering attributes for entity: " + this.builder.name);

        if (!entityType.isPresent()) {
            Scylla.LOGGER.error("Failed to register attributes for entity: " + this.builder.name);
            return;
        }

        var entity = entityType.get();
        var builtAttributes = attributes.get().build();

        event.put(entity, builtAttributes);
    }

    public void register(FMLClientSetupEvent event) {
        Scylla.LOGGER.info("Registering entity model for entity: " + this.builder.name);

        if (!entityType.isPresent()) {
            Scylla.LOGGER.error("Failed to register entity model for entity: " + this.builder.name);
            return;
        }

        EntityRenderers.register(entityType.get(), (context) -> new CustomCreatureRenderer<T>(this.builder, context));
    }
}
