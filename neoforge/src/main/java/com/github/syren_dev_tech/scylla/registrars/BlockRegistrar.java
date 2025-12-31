package com.github.syren_dev_tech.scylla.registrars;

import com.github.syren_dev_tech.scylla.common.registry.IRegistrar;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class BlockRegistrar<T extends Block> implements IRegistrar<T> {

    private final DeferredRegister<Block> blocksRegistry;

    public BlockRegistrar(String modId) {
        this.blocksRegistry = DeferredRegister.create(ForgeRegistries.BLOCKS, modId);
    }

    @Override
    public <X extends T> Supplier<X> register(String modId, String name, Supplier<X> supplier) {
        return blocksRegistry.register(name, supplier);
    }

    public void finishBus(IEventBus bus) {
        blocksRegistry.register(bus);
    }

    @Override
    public <X> void finish(X bus) {
        finishBus((IEventBus) bus);
    }
}
