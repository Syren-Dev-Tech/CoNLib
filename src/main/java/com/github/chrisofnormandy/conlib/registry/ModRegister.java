package com.github.chrisofnormandy.conlib.registry;

import java.util.HashMap;

import com.github.chrisofnormandy.conlib.CoNLib;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimal;
import com.github.chrisofnormandy.conlib.mobs.types.CustomAnimalModel;
import com.github.chrisofnormandy.conlib.mobs.types.CustomMobRenderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModRegister {

    public String modId;

    public final HashMap<String, Object> events = new HashMap<>();
    public BlockRegistry blockRegistry;
    public ItemRegistry itemRegistry;
    public CreativeTabRegistry creativeTabRegistry;
    public MobRegistry mobRegistry;

    private void commonSetup(final FMLCommonSetupEvent event) {
        CoNLib.LOGGER.info("CONLIB COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        CoNLib.LOGGER.info("ASSIGNING CREATIVE TABS");

        this.creativeTabRegistry.creativeTabs.forEach((key, value) -> {
            if (event.getTabKey() == key)
                value.forEach(event::accept);
        });
    }

    public ModRegister(String modId) {
        this.modId = modId;

        createRegistries();

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        finishRegistries(modEventBus);
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        this.mobRegistry.entityRendering.forEach((key, value) -> {
            EntityRenderers.register(value.y.get(), context -> new CustomMobRenderer(context, new CustomAnimalModel<>(context.bakeLayer(new ModelLayerLocation(new ResourceLocation(value.x, key), "main"))), 0.5F) {
                @Override
                public ResourceLocation getTextureLocation(CustomAnimal entity) {
                    return new ResourceLocation(value.x, "textures/entity/" + key + ".png");
                }
            });
        });
    }

    public void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        this.mobRegistry.entityAttributes.forEach((key, value) -> event.put(key.get(), value.get().build()));
    }

    private void createRegistries() {
        this.blockRegistry = new BlockRegistry(this);
        this.itemRegistry = new ItemRegistry(this);
        this.creativeTabRegistry = new CreativeTabRegistry(this);
        this.mobRegistry = new MobRegistry(this);
    }

    private void finishRegistries(IEventBus bus) {
        this.blockRegistry.finish(bus);
        this.itemRegistry.finish(bus);
        this.creativeTabRegistry.finish(bus);
        this.mobRegistry.finish(bus);
    }
}