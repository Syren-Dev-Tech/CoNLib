package com.github.syren_dev_tech.scylla.common;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.fml.loading.FMLPaths;

public class Files {
    private static final Logger LOGGER = LogUtils.getLogger();

    private Files() {
    }

    public static final void write(String path, String name, String data, String ext) {
        Path p = FMLPaths.GAMEDIR.get().resolve(path);
        final File dir = p.toFile();

        if (!dir.exists())
            dir.mkdirs();

        try {
            try (PrintWriter out = new PrintWriter(path + "/" + name + ext)) {
                out.write(data);
            }
        } catch (Exception err) {
            LOGGER.error("Failed to write to file: {}/{}/{}", path, name, ext);
            LOGGER.error(Arrays.toString(err.getStackTrace()));
        }
    }

    public static final void writeToSave(String path, String name, String data, String ext) {
        File[] saves = new File(FMLPaths.GAMEDIR.get().resolve("saves").toString()).listFiles(File::isDirectory);

        for (File file : saves) {
            Path p = FMLPaths.GAMEDIR.get().resolve(file.toString() + "/" + path);
            final File dir = p.toFile();

            if (!dir.exists())
                dir.mkdirs();

            try {
                try (PrintWriter out = new PrintWriter(p.toString() + "/" + name + ext)) {
                    out.write(data);
                }
            } catch (Exception err) {
                LOGGER.error("Failed to write to file: {}/{}/{}", p, name, ext);
                LOGGER.error(Arrays.toString(err.getStackTrace()));
            }
        }
    }
}
