package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.registry.IRegistrar;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ItemRegistrar<T extends Item> implements IRegistrar<T> {

    private final DeferredRegister<Item> itemsRegistry;

    public ItemRegistrar(String modId) {
        this.itemsRegistry = DeferredRegister.createItems(modId);
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
