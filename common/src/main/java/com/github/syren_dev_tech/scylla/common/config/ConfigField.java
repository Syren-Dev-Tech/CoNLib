package com.github.syren_dev_tech.scylla.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

public class ConfigField<T> {

    public final String key;
    public final ConfigGroup group;
    public final String comment;
    private final T defaultValue;

    ConfigField(ConfigGroup group, String key, T defaultValue) {
        this.group = group;
        this.key = key;
        this.comment = "";
        this.defaultValue = defaultValue;
    }

    ConfigField(ConfigGroup group, String key, T defaultValue, String comment) {
        this.group = group;
        this.key = key;
        this.comment = comment;
        this.defaultValue = defaultValue;
    }

    public String getFullKey() {
        String parentKey = this.group.getFullKey();

        return parentKey.isEmpty() ? this.key : parentKey + "." + this.key;
    }

    public void write() {
        ScyllaCommon.LOGGER.debug("Writing config field: {} = {}", this.getFullKey(), this.defaultValue);

        CommentedFileConfig config = this.group.config.getFileConfig();
        String fullKey = this.getFullKey();
        // Only set the default value if the key does not exist
        if (!config.contains(fullKey)) {
            config.set(fullKey, this.defaultValue);
        }

        if (!this.comment.isEmpty()) {
            config.setComment(fullKey, this.comment);
        }
    }
}
