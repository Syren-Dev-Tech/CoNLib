package com.github.syren_dev_tech.scylla.common.registry;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

import net.minecraft.world.entity.EntityType;

public class ModelRegistry {

    private final ModRegister registry;
    private final IMobRegistrar<EntityType<?>> registrar;

    public void registerEntityModels(MobRegistry mobRegistry) {
        ScyllaCommon.LOGGER.info("Registering entity models");

        mobRegistry.entities.forEach((name, entityRegistryObject) -> {
            if (ScyllaCommon.LOGGER.isInfoEnabled())
                ScyllaCommon.LOGGER.info("Registering entity model for: {}", name);

            registrar.register(entityRegistryObject);
        });
    }

    public ModelRegistry(ModRegister registry, IMobRegistrar<EntityType<?>> registrar) {
        this.registry = registry;
        this.registrar = registrar;
    }
}
