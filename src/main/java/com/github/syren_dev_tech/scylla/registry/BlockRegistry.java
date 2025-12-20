package com.github.syren_dev_tech.scylla.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.Scylla;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class BlockRegistry {
    private final ModRegister registry;
    private final DeferredRegister<Block> blocksRegistry;

    public final Map<String, RegistryObject<? extends Block>> blocks = new HashMap<>();
    public final Map<String, RegistryObject<? extends Block>> transparentBlocks = new HashMap<>();

    public final void finish(IEventBus bus) {
        blocksRegistry.register(bus);
    }

    public final <T extends Block> Supplier<T> register(String name, Supplier<T> block) {
        var blockRegistry = this.blocksRegistry.register(name, block);
        this.blocks.put(name, blockRegistry);

        if (Scylla.LOGGER.isInfoEnabled()) {
            Scylla.LOGGER.info(String.format("Registered new block: %s:%s", registry.modId, name));
        }

        return blockRegistry;
    }

    public final <T extends Block> Supplier<T> register(String name, Supplier<T> block, ResourceKey<CreativeModeTab> creativeTab) {
        var blockRegistry = register(name, block);

        this.registry.itemRegistry.register(name, () -> new BlockItem(blockRegistry.get(), new Item.Properties()), creativeTab);

        return blockRegistry;
    }

    public BlockRegistry(ModRegister registry) {
        this.registry = registry;
        this.blocksRegistry = DeferredRegister.create(ForgeRegistries.BLOCKS, registry.modId);
    }
}
