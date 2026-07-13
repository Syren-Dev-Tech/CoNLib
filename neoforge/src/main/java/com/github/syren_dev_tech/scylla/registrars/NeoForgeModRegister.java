package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.ScyllaCommon;
import com.github.syren_dev_tech.scylla.registry.ModRegister;
import com.github.syren_dev_tech.scylla.registry.ModRegistrars;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

public class NeoForgeModRegister extends ModRegister {

    public NeoForgeModRegister(String modId) {
        super(modId, new ModRegistrars().setBlockRegistrar(new BlockRegistrar<>(modId)).setItemRegistrar(new ItemRegistrar<>(modId)).setCreativeTabRegistrar(new CreativeTabRegistrar(modId)).setEntityRegistrar(new EntityTypeRegistrar<>(modId)));
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ScyllaCommon.LOGGER.info("COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        ScyllaCommon.LOGGER.info("ASSIGNING CREATIVE TABS");

        this.creativeTabRegistry.tabs.forEach((name, definition) -> {
            if (event.getTabKey() == definition.key) {
                definition.getItems().forEach((item) -> {
                    try {
                        event.accept(item.registry.get());
                    } catch (Exception e) {
                        ScyllaCommon.LOGGER.error("Failed to add item to creative tab {}", e);
                    }
                });
            }
        });
    }

    public void initEvents(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        finishRegistries(modEventBus);
    }

    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        ScyllaCommon.LOGGER.info("REGISTERING ENTITY ATTRIBUTES");

        this.mobRegistry.registerEntityAttributes(event);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        ScyllaCommon.LOGGER.info("CLIENT SETUP");

        this.mobRegistry.entities.forEach((name, creatureRegistrar) -> {
            ScyllaCommon.LOGGER.info("SETTING UP RENDERER FOR: {}", name);

            creatureRegistrar.register();
        });
    }

    private void finishRegistries(IEventBus bus) {
        ScyllaCommon.LOGGER.info("FINISHING REGISTRIES");

        this.blockRegistry.finish(bus);
        this.itemRegistry.finish(bus);
        this.creativeTabRegistry.finish(bus);
        this.mobRegistry.finish(bus);
    }
}
