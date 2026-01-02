package com.github.syren_dev_tech.scylla;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;
import com.github.syren_dev_tech.scylla.common.registry.ModRegistrars;
import com.github.syren_dev_tech.scylla.registrars.BlockRegistrar;
import com.github.syren_dev_tech.scylla.registrars.CreativeTabRegistrar;
import com.github.syren_dev_tech.scylla.registrars.EntityTypeRegistrar;
import com.github.syren_dev_tech.scylla.registrars.ForgeModRegister;
import com.github.syren_dev_tech.scylla.registrars.ItemRegistrar;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Scylla.MOD_ID)
public final class Scylla extends ScyllaCommon {

    public static final String MOD_ID = "scylla";
    public static final ForgeModRegister MOD_REGISTER = new ForgeModRegister(MOD_ID);

    public Scylla() { // NOSONAR - Constructor must be public
        super();

        // Init ModRegister events using FML context
        MOD_REGISTER.initEvents(FMLJavaModLoadingContext.get());
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        private ClientModEvents() {}

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
        private CommonModEvents() {}

        @SubscribeEvent
        public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
            LOGGER.info("HELLO FROM ENTITY ATTRIBUTE CREATION");

            MOD_REGISTER.onEntityAttributeCreation(event);
        }
    }
}
