package com.github.syren_dev_tech.scylla.common.registry;

import java.util.HashMap;
import java.util.Map;

import com.github.syren_dev_tech.scylla.common.config.Config;

public class ModRegister {

    public final String modId;
    public final ModRegistrars registrars;

    public final Map<String, Object> events = new HashMap<>();
    public final BlockRegistry blockRegistry;
    public final ItemRegistry itemRegistry;
    public final CreativeTabRegistry creativeTabRegistry;
    public final MobRegistry mobRegistry;
    public final Map<String, Config> configs = new HashMap<>();

    public ModRegister(String modId, ModRegistrars registrars) {
        this.modId = modId;
        this.registrars = registrars;

        this.blockRegistry = new BlockRegistry(this, registrars.blockRegistrar);
        this.itemRegistry = new ItemRegistry(this, registrars.itemRegistrar);
        this.creativeTabRegistry = new CreativeTabRegistry(this, registrars.creativeTabRegistrar);
        this.mobRegistry = new MobRegistry(this, registrars.entityRegistrar);
    }

    public Config createConfig(String name) {
        Config config = new Config(name, this.modId);
        this.configs.put(name, config);

        return config;
    }

    public Config getConfig(String name) {
        return this.configs.get(name);
    }
}