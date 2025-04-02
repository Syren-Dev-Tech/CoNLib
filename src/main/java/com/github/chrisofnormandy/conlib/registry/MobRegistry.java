package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.collections.Tuple;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class MobRegistry {
    private final ModRegister registry;
    private final DeferredRegister<EntityType<?>> ENTITY_TYPES;

    public final HashMap<RegistryObject<EntityType<CustomAnimal>>, Supplier<AttributeSupplier.Builder>> entityAttributes = new HashMap<>();
    public final HashMap<String, Tuple<String, RegistryObject<EntityType<CustomAnimal>>>> entityRendering = new HashMap<>();
    public final HashMap<String, RegistryObject<? extends EntityType<?>>> entities = new HashMap<>();

    public static final ModelLayerLocation CUSTOM_ANIMAL_LAYER = new ModelLayerLocation(new ResourceLocation("modid", "custom_animal"), "main");

    public void registerModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CUSTOM_ANIMAL_LAYER, this::createCustomAnimalLayer);
    }

    private LayerDefinition createCustomAnimalLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 4.0F), PartPose.ZERO);

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    public final void finish(IEventBus bus) {
        ENTITY_TYPES.register(bus);
        bus.addListener(this::registerModelLayers);
    }

    public void defineEntityAttributes(RegistryObject<EntityType<CustomAnimal>> entity, Supplier<AttributeSupplier.Builder> builder) {
        entityAttributes.put(entity, builder);
    }

    public final Supplier<EntityType<CustomAnimal>> register(String name, EntityFactory<CustomAnimal> factory) {
        var entityTypeRegistry = this.ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, MobCategory.CREATURE).sized(0.6F, 1.8F).build(name));
        this.entities.put(name, entityTypeRegistry);
        this.defineEntityAttributes(entityTypeRegistry, CustomAnimal::createAttributes);
        this.entityRendering.put(name, new Tuple<>(this.registry.modId, entityTypeRegistry));

        return entityTypeRegistry;
    }

    public MobRegistry(ModRegister registry) {
        this.registry = registry;
        this.ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, registry.modId);
    }
}
