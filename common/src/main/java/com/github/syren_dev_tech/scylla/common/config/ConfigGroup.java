package com.github.syren_dev_tech.scylla.common.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigGroup {

    public final String name;
    public final Config config;
    public final ConfigGroup parent;
    public final Map<String, ConfigGroup> children = new HashMap<>();
    public final Map<String, ConfigField<?>> fields = new HashMap<>();

    public ConfigGroup(Config config) {
        this.config = config;
        this.name = "";
        this.parent = null;
    }

    public ConfigGroup(Config config, String name) {
        this.config = config;
        this.name = name;
        this.parent = null;
    }

    public ConfigGroup(Config config, ConfigGroup parent, String name) {
        this.config = config;
        this.name = name;
        this.parent = parent;
        parent.addSubgroup(this);
    }

    public void addSubgroup(ConfigGroup group) {
        this.children.put(group.name, group);
    }

    public ConfigGroup addSubgroup(String name) {
        ConfigGroup group = new ConfigGroup(this.config, this, name);
        this.children.put(name, group);

        return group;
    }

    public ConfigGroup getSubgroup(String name) {
        return this.children.get(name);
    }

    public <T> ConfigField<T> addField(String key, T defaultValue) {
        ConfigField<T> field = new ConfigField<>(this, key, defaultValue);
        this.fields.put(key, field);

        return field;
    }

    public <T> ConfigField<T> addField(String key, T defaultValue, String comment) {
        ConfigField<T> field = new ConfigField<>(this, key, defaultValue, comment);
        this.fields.put(key, field);

        return field;
    }

    public String getFullKey() {
        String parentKey = this.parent != null ? this.parent.getFullKey() : "";

        return parentKey.isEmpty() ? this.name : parentKey + "." + this.name;
    }

    public void write() {
        for (ConfigField<?> field : this.fields.values()) {
            field.write();
        }

        for (ConfigGroup child : this.children.values()) {
            child.write();
        }
    }
}
