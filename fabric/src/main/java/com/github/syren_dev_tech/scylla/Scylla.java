package com.github.syren_dev_tech.scylla;

import com.github.syren_dev_tech.scylla.common.ScyllaCommon;
import com.github.syren_dev_tech.scylla.common.registry.ModRegistrars;
import com.github.syren_dev_tech.scylla.registrars.BlockRegistrar;
import com.github.syren_dev_tech.scylla.registrars.CreativeTabRegistrar;
import com.github.syren_dev_tech.scylla.registrars.EntityTypeRegistrar;
import com.github.syren_dev_tech.scylla.registrars.ForgeModRegister;
import com.github.syren_dev_tech.scylla.registrars.ItemRegistrar;

import net.minecraft.client.Minecraft;

public final class Scylla extends ScyllaCommon {

    public static final String MOD_ID = "scylla";

    public Scylla() { // NOSONAR - Constructor must be public
        super();
    }
}