package com.github.syren_dev_tech.scylla.registry.features;

import java.util.HashMap;
import java.util.Map;

import com.github.syren_dev_tech.scylla.Scylla;
import com.github.syren_dev_tech.scylla.collections.Tuple;
import com.github.syren_dev_tech.scylla.registry.features.PlacedFeatureRegistry.PlacedOreFeatureRegistry;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeFeatureRegistry {

    private BiomeFeatureRegistry() {
    }

    public class BiomeOreFeatureRegistry {

        private BiomeOreFeatureRegistry() {
        }

        protected static final Map<String, Tuple<TagKey<Biome>, ResourceKey<PlacedFeature>>> modifiers = new HashMap<>();

        public static final void register(String name, TagKey<Biome> biome, ResourceKey<PlacedFeature> placedFeatureKey) {
            Tuple<TagKey<Biome>, ResourceKey<PlacedFeature>> value = new Tuple<>(biome, placedFeatureKey);
            modifiers.put(name, value);
        }
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        BiomeOreFeatureRegistry.modifiers.forEach((key, value) -> {
            var placedFeatureKey = PlacedOreFeatureRegistry.getKeys().get(key);

            var feature = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(value.x), HolderSet.direct(placedFeatures.getOrThrow(placedFeatureKey)), GenerationStep.Decoration.UNDERGROUND_ORES);

            context.register(registerKey(key), feature);
        });
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Scylla.MOD_ID, name));
    }
}
