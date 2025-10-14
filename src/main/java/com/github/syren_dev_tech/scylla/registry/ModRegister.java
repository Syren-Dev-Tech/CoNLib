package com.github.syren_dev_tech.scylla.registry;

import java.util.HashMap;
import java.util.Map;

import com.github.syren_dev_tech.scylla.Scylla;
import com.github.syren_dev_tech.scylla.config.Config;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModRegister {

    public final String modId;

    public final Map<String, Object> events = new HashMap<>();
    public final BlockRegistry blockRegistry;
    public final ItemRegistry itemRegistry;
    public final CreativeTabRegistry creativeTabRegistry;
    public final MobRegistry mobRegistry;
    public final Map<String, Config> configs = new HashMap<>();

    private void commonSetup(final FMLCommonSetupEvent event) {
        Scylla.LOGGER.info("CONLIB COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        Scylla.LOGGER.info("ASSIGNING CREATIVE TABS");

        this.creativeTabRegistry.creativeTabs.forEach((key, value) -> {
            if (event.getTabKey() == key)
                value.forEach(event::accept);
        });
    }

    public ModRegister(String modId) {
        this.modId = modId;

        this.blockRegistry = new BlockRegistry(this);
        this.itemRegistry = new ItemRegistry(this);
        this.creativeTabRegistry = new CreativeTabRegistry(this);
        this.mobRegistry = new MobRegistry(this);
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
        Scylla.LOGGER.info("CONLIB CLIENT SETUP");

        this.mobRegistry.registerEntityModels(event);
    }

    private void finishRegistries(IEventBus bus) {
        Scylla.LOGGER.info("FINISHING REGISTRIES");

        this.blockRegistry.finish(bus);
        this.itemRegistry.finish(bus);
        this.creativeTabRegistry.finish(bus);
        this.mobRegistry.finish(bus);
    }

    public Config createConfig(String name) {
        Config config = new Config(name, this.modId);
        this.configs.put(name, config);

        return config;
    }

    public Config getConfig(String name) {
        return this.configs.get(name);
    }
}