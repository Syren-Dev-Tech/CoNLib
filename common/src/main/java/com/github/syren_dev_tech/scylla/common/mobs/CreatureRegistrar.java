package com.github.syren_dev_tech.scylla.common.mobs;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;
import com.github.syren_dev_tech.scylla.common.mobs.client.CustomCreatureRenderer;
import com.github.syren_dev_tech.scylla.common.mobs.creatures.CustomCreature;
import com.github.syren_dev_tech.scylla.common.registry.IMobRegistrar;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class CreatureRegistrar<T extends CustomCreature> {

    private final CreatureBuilder<T> builder;
    private final Supplier<EntityType<T>> entityType;
    private final Supplier<AttributeSupplier.Builder> attributes;

    public CreatureRegistrar(CreatureBuilder<T> builder, Supplier<EntityType<T>> entityType,
            Supplier<AttributeSupplier.Builder> attributes) {
        this.builder = builder;
        this.entityType = entityType;
        this.attributes = attributes;
    }

    public Supplier<EntityType<T>> getEntityType() {
        return entityType;
    }

    public void registerAttributes(IMobRegistrar<EntityType<? extends LivingEntity>> registrar) {
        ScyllaCommon.LOGGER.info("Registering attributes for entity: " + this.builder.name);

        if (entityType == null) {
            ScyllaCommon.LOGGER.error("Failed to register attributes for entity: " + this.builder.name);
            return;
        }

        var entity = entityType.get();
        var builtAttributes = attributes.get().build();

        registrar.register(entity, builtAttributes);
    }

    public void register() {
        ScyllaCommon.LOGGER.info("Registering entity model for entity: " + this.builder.name);

        if (entityType == null) {
            ScyllaCommon.LOGGER.error("Failed to register entity model for entity: " + this.builder.name);
            return;
        }

        EntityRenderers.register(entityType.get(), (context) -> new CustomCreatureRenderer<T>(this.builder, context));
    }
}
