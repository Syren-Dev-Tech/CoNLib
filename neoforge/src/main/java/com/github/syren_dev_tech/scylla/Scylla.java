package com.github.syren_dev_tech.scylla;

import com.github.syren_dev_tech.scylla.registrars.NeoForgeModRegister;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Scylla.MOD_ID)
public final class Scylla extends ScyllaCommon {

    public static final String MOD_ID = "scylla";
    public static final NeoForgeModRegister MOD_REGISTER = new NeoForgeModRegister(MOD_ID);

    public Scylla(IEventBus modEventBus, ModContainer modContainer) { // NOSONAR - Constructor must be public
        super();

        NeoForge.EVENT_BUS.register(this);
        MOD_REGISTER.initEvents(modEventBus);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            MOD_REGISTER.onClientSetup(event);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {}

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {}

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {

        }
    }

    @EventBusSubscriber(modid = MOD_ID)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
            LOGGER.info("HELLO FROM ENTITY ATTRIBUTE CREATION");

            MOD_REGISTER.onEntityAttributeCreation(event);
        }
    }
}
