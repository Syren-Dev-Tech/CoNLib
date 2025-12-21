package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.common.registry.IRegistrar;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTabRegistrar<T extends CreativeModeTab> implements IRegistrar<T> {

    private final DeferredRegister<CreativeModeTab> creativeModeTabs;

    public CreativeTabRegistrar(String modId) {
        this.creativeModeTabs = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), modId);
    }

    @Override
    public <X extends T> Supplier<X> register(String modId, String name, Supplier<X> supplier) {
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
