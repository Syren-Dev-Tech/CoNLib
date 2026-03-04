package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.registry.IRegistrar;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class CreativeTabRegistrar implements IRegistrar<CreativeModeTab> {

    private final DeferredRegister<CreativeModeTab> creativeModeTabs;

    public CreativeTabRegistrar(String modId) {
        this.creativeModeTabs = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
    }

    @Override
    public <X extends CreativeModeTab> Supplier<X> register(String modId, String name, Supplier<X> supplier) {
        return creativeModeTabs.register(name, supplier);
    }

    public void finishBus(IEventBus bus) {
        creativeModeTabs.register(bus);
    }

    @Override
    public <X> void finish(X bus) {
        finishBus((IEventBus) bus);
    }
}
