package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.Scylla;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;
import com.github.syren_dev_tech.scylla.common.registry.ModRegistrars;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ForgeModRegister extends ModRegister {

    public ForgeModRegister(String modId, ModRegistrars registrars) {
        super(modId, registrars);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Scylla.LOGGER.info("COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        Scylla.LOGGER.info("ASSIGNING CREATIVE TABS");

        this.creativeTabRegistry.creativeTabs.forEach((key, value) -> {
            if (event.getTabKey() == key)
                value.forEach(event::accept);
        });
    }

    public void initEvents(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        finishRegistries(modEventBus);
    }

    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        Scylla.LOGGER.info("REGISTERING ENTITY ATTRIBUTES");

        this.mobRegistry.registerEntityAttributes(event);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        Scylla.LOGGER.info("CLIENT SETUP");

        this.mobRegistry.entities.forEach((name, creatureRegistrar) -> {
            Scylla.LOGGER.info("SETTING UP RENDERER FOR: {}", name);

            creatureRegistrar.register();
        });
    }

    private void finishRegistries(IEventBus bus) {
        Scylla.LOGGER.info("FINISHING REGISTRIES");

        this.blockRegistry.finish(bus);
        this.itemRegistry.finish(bus);
        this.creativeTabRegistry.finish(bus);
        this.mobRegistry.finish(bus);
    }
}
