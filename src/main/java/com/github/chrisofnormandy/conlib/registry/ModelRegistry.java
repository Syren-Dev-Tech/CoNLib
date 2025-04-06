package com.github.chrisofnormandy.conlib.registry;

import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart.Cube;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.client.event.EntityRenderersEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.mobs.types.CustomCreature;
import com.github.chrisofnormandy.conlib.mobs.types.CustomCreatureModel;
import com.github.chrisofnormandy.conlib.mobs.types.CustomCreatureRenderer;

public class ModelRegistry {
    private final ModRegister registry;
    private final Map<String, ModelLayerLocation> modelLayers = new HashMap<>();

    public ModelRegistry(ModRegister registry) {
        this.registry = registry;
    }

    public final <T extends CustomCreature> void register(String name, Supplier<EntityType<T>> entityType) {
        CoNLib.LOGGER.info("Registering model: " + name);

        EntityRenderers.register(entityType.get(), CustomCreatureRenderer::new);
        ModelLayerLocation modelLayer = new ModelLayerLocation(new ResourceLocation(registry.modId, name), "main");
        modelLayers.put(name, modelLayer);
    }

    public final <T extends CustomCreature> void finish(IEventBus bus, HashMap<String, RegistryObject<? extends EntityType<T>>> entityTypes) {
        CoNLib.LOGGER.info("Finishing model registration");

        bus.addListener(this::registerLayerDefinitions);
    }

    private void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        CoNLib.LOGGER.info("Registering layer definitions");

        modelLayers.forEach((name, modelLayer) -> {
            CoNLib.LOGGER.info("Registering layer definition for: " + name);

            event.registerLayerDefinition(modelLayer, CustomCreatureModel::createBodyLayer);
        });
    }
}
