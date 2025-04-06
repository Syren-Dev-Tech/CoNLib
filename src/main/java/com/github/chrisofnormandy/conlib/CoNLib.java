package com.github.chrisofnormandy.conlib;

import net.minecraftforge.fml.common.Mod;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(CoNLib.MOD_ID)
public class CoNLib {
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "conlib";

    public CoNLib() {
        LOGGER.info("Time to do a little modding...");
    }
}