package com.github.syren_dev_tech.scylla.common.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;
import com.github.syren_dev_tech.scylla.common.mobs.CreatureBuilder;
import com.github.syren_dev_tech.scylla.common.mobs.CreatureRegistrar;
import com.github.syren_dev_tech.scylla.common.mobs.creatures.CustomCreature;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

public class MobRegistry {

    private final ModRegister registry;
    private final IMobRegistrar<EntityType<?>> registrar;

    public final Map<String, CreatureRegistrar<?>> entities = new HashMap<>();

    public AttributeSupplier.Builder createAttributes() {
        ScyllaCommon.LOGGER.info("Creating entity attributes");

        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    public final <T extends CustomCreature> Supplier<EntityType<T>> register(CreatureBuilder<T> builder) {
        if (ScyllaCommon.LOGGER.isInfoEnabled())
            ScyllaCommon.LOGGER.info("Registering entity: {}", builder.name);

        return this.registrar.register(registry.modId, builder.name, () -> EntityType.Builder.of(builder.factory, MobCategory.CREATURE).sized(0.6F, 1.8F).build(builder.name));
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        if (ScyllaCommon.LOGGER.isInfoEnabled())
            ScyllaCommon.LOGGER.info("Registering entity attributes");

        entities.forEach((name, creatureRegistrar) -> {
            ScyllaCommon.LOGGER.info("Registering attributes for: {}", name);

            creatureRegistrar.registerAttributes(registrar);
        });
    }

    public <X> void finish(X bus) {
        this.registrar.finish(bus);
    }

    public MobRegistry(ModRegister registry, IMobRegistrar<EntityType<?>> registrar) {
        this.registry = registry;
        this.registrar = registrar;
    }
}
