package com.github.chrisofnormandy.conlib;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;

import com.github.chrisofnormandy.conlib.registry.ModRegister;
import com.mojang.logging.LogUtils;

@Mod(CoNLib.MOD_ID)
public class CoNLib {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "conlib";

    public static final ModRegister MOD_REGISTER = new ModRegister(MOD_ID);

    public CoNLib() { // NOSONAR - Constructor must be public
        LOGGER.info("Time to do a little modding...");

        // Init ModRegister events using FML context
        MOD_REGISTER.initEvents(FMLJavaModLoadingContext.get());
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        private ClientModEvents() {
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            MOD_REGISTER.onClientSetup(event);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        // Private constructor to prevent instantiation
        private CommonModEvents() {
        }

        @SubscribeEvent
        public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
            LOGGER.info("HELLO FROM ENTITY ATTRIBUTE CREATION");

            MOD_REGISTER.onEntityAttributeCreation(event);
        }
    }
}