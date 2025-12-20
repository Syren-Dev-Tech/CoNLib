package com.github.syren_dev_tech.scylla.registry;

import com.github.syren_dev_tech.scylla.Scylla;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModelRegistry {
    public void registerEntityModels(MobRegistry mobRegistry, FMLClientSetupEvent event) {
        Scylla.LOGGER.info("Registering entity models");

        mobRegistry.entities.forEach((name, entityRegistryObject) -> {
            if (Scylla.LOGGER.isInfoEnabled())
                Scylla.LOGGER.info("Registering entity model for: {}", name);

            entityRegistryObject.register(event);
        });
    }
}
