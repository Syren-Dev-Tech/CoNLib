package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.common.registry.IRegistrar;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ItemRegistrar<T extends Item> implements IRegistrar<T> {

    private final DeferredRegister<Item> itemsRegistry;

    public ItemRegistrar(String modId) {
        this.itemsRegistry = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    }

    @Override
    public <X extends T> Supplier<X> register(String modId, String name, Supplier<X> supplier) {
        return itemsRegistry.register(name, supplier);
    }

    public void finishBus(IEventBus bus) {
        itemsRegistry.register(bus);
    }

    @Override
    public <X> void finish(X bus) {
        finishBus((IEventBus) bus);
    }
}
