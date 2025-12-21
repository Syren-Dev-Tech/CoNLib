package com.github.syren_dev_tech.scylla.common.config;

import java.io.File;
import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

public class Config {

    private static final String TOML_EXTENSION = ".toml";
    private static final String CONFIG_DIR = "config";

    private final ConfigGroup root;
    private final File file;
    private final CommentedFileConfig fileConfig;

    private String name;
    private String path;

    public Config(String name) {
        this.name = name;
        this.root = new ConfigGroup(this);
        this.file = Path.of(CONFIG_DIR, this.name + TOML_EXTENSION).toFile();
        this.path = "";
        this.fileConfig = CommentedFileConfig.builder(this.file).sync().autosave().writingMode(WritingMode.REPLACE).build();
    }

    public Config(String path, String name) {
        this.name = name;
        this.root = new ConfigGroup(this);
        this.path = path;
        this.file = Path.of(CONFIG_DIR, this.path, this.name + TOML_EXTENSION).toFile();
        this.fileConfig = CommentedFileConfig.builder(this.file).sync().autosave().writingMode(WritingMode.REPLACE).build();
    }

    public ConfigGroup getRoot() {
        return this.root;
    }

    public void load() {
        if (!this.file.exists()) {
            this.write();
        }

        this.fileConfig.load();
    }

    private void write() {
        // If this file doesn't exist, create it and the parent directories
        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            try {
                boolean created = this.file.createNewFile();
                if (!created) {
                    ScyllaCommon.LOGGER.error("Failed to create new config file: {}", this.file.getAbsolutePath());
                }
            } catch (Exception e) {
                ScyllaCommon.LOGGER.error("Exception creating new config file: {}", this.file.getAbsolutePath(), e);
            }
        }

        this.root.write();
        this.fileConfig.save();
    }

    public void close() {
        this.fileConfig.close();
    }

    public CommentedFileConfig getFileConfig() {
        return this.fileConfig;
    }

    public <T> T get(String key) {
        // Retrieve the value by key path in the config
        return this.fileConfig.get(key);
    }
}