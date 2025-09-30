package com.github.chrisofnormandy.conlib.mobs.creatures;

import java.util.function.Supplier;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.registry.ModRegister;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

public class CreatureRegistrar<T extends CustomCreature, E extends EntityType<T>> {

    private final ModRegister registry;
    private final String name;

    private final RegistryObject<E> entityType;
    private final Supplier<AttributeSupplier.Builder> attributes;

    public CreatureRegistrar(ModRegister registry, String name, RegistryObject<E> entityType, Supplier<AttributeSupplier.Builder> attributes) {
        this.registry = registry;
        this.entityType = entityType;
        this.name = name;
        this.attributes = attributes;
    }

    public void registerAttributes(EntityAttributeCreationEvent event) {
        CoNLib.LOGGER.info("Registering attributes for entity: " + name);

        if (!entityType.isPresent()) {
            CoNLib.LOGGER.error("Failed to register attributes for entity: " + name);
            return;
        }

        var entity = entityType.get();
        var builtAttributes = attributes.get().build();

        event.put(entity, builtAttributes);
    }

    public void register(FMLClientSetupEvent event) {
        CoNLib.LOGGER.info("Registering entity model for entity: " + name);

        if (!entityType.isPresent()) {
            CoNLib.LOGGER.error("Failed to register entity model for entity: " + name);
            return;
        }

        EntityRenderers.register(entityType.get(), (context) -> new CustomCreatureRenderer<T>(registry, name, context));
    }
}
