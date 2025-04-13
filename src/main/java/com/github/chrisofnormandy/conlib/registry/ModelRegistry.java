package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.client.event.EntityRenderersEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.mobs.creatures.CustomCreature;
import com.github.chrisofnormandy.conlib.mobs.creatures.CustomCreatureModel;
import com.github.chrisofnormandy.conlib.mobs.creatures.CustomCreatureRenderer;

public class ModelRegistry {
    private final ModRegister registry;
    private final Map<String, ModelLayerLocation> modelLayers = new HashMap<>();

    public ModelRegistry(ModRegister registry) {
        this.registry = registry;
    }

    public final <T extends CustomCreature> void finish(IEventBus bus) {
        CoNLib.LOGGER.info("Finishing model registration");

        bus.addListener(this::registerLayerDefinitions);
    }

    public final ModelLayerLocation registerModelLayer(String name) {
        if (modelLayers.containsKey(name)) {
            return modelLayers.get(name);
        }

        CoNLib.LOGGER.info("Registering model layer: " + name);
        ModelLayerLocation modelLayer = new ModelLayerLocation(new ResourceLocation(this.registry.modId, name), "main");
        modelLayers.put(name, modelLayer);

        return modelLayer;
    }

    public final <T extends CustomCreature> void registerRenderer(String name, Supplier<EntityType<T>> entityType) {
        CoNLib.LOGGER.info("Registering model: " + name);

        EntityRenderers.register(entityType.get(), (context) -> new CustomCreatureRenderer<>(this.registry, name, context, registerModelLayer(name), 0.5F));
    }

    private void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        CoNLib.LOGGER.info("Registering layer definitions");

        registry.mobRegistry.entities.forEach((name, entity) -> {
            CoNLib.LOGGER.info("Registering layer definition for: " + name);

            var modelLayer = registerModelLayer(name);
            var entityType = entity.get();

            if (modelLayer == null) {
                CoNLib.LOGGER.error("Model layer for " + name + " is null");
                return;
            }

            if (entityType == null) {
                CoNLib.LOGGER.error("Entity type for " + name + " is null");
                return;
            }

            EntityRenderers.register(entityType, (context) -> new CustomCreatureRenderer<>(this.registry, name, context, modelLayer, 0.5F));

            event.registerLayerDefinition(modelLayer, () -> CustomCreatureModel.createBodyLayer(this.registry, name));
        });
    }
}
