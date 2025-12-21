package com.github.syren_dev_tech.scylla.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScyllaCommon {
    public static final Logger LOGGER = LoggerFactory.getLogger(ScyllaCommon.class);
    public static final String MOD_ID = "scylla";

    public ScyllaCommon() { // NOSONAR - Constructor must be public
        LOGGER.info("Time to do a little modding...");
    }
}