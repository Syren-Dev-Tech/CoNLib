package com.github.syren_dev_tech.scylla.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.CoNLib;

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
    private final DeferredRegister<Block> BLOCKS;

    public final HashMap<String, RegistryObject<? extends Block>> blocks = new HashMap<>();
    public final HashMap<String, RegistryObject<? extends Block>> transparentBlocks = new HashMap<>();

    public final void finish(IEventBus bus) {
        BLOCKS.register(bus);
    }

    public final <T extends Block> Supplier<T> register(String name, Supplier<T> block) {
        var blockRegistry = this.BLOCKS.register(name, block);
        this.blocks.put(name, blockRegistry);

        CoNLib.LOGGER.info("Registered new block: " + registry.modId + ":" + name);

        return blockRegistry;
    }

    public final <T extends Block> Supplier<T> register(String name, Supplier<T> block,
            ResourceKey<CreativeModeTab> creativeTab) {
        var blockRegistry = register(name, block);

        this.registry.itemRegistry.register(name, () -> new BlockItem(blockRegistry.get(), new Item.Properties()),
                creativeTab);

        return blockRegistry;
    }

    public BlockRegistry(ModRegister registry) {
        this.registry = registry;
        this.BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, registry.modId);
    }
}
