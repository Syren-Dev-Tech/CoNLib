package com.github.syren_dev_tech.scylla.common.registry.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.ScyllaCommon;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class FeatureRegistry {

    private static final RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

    public static RuleTest getStoneReplaceables() {
        return stoneReplaceables;
    }

    private static final RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static RuleTest getDeepslateReplaceables() {
        return deepslateReplaceables;
    }

    private static final RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);

    public static RuleTest getNetherrackReplaceables() {
        return netherrackReplaceables;
    }

    private static final RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

    public static RuleTest getEndstoneReplaceables() {
        return endstoneReplaceables;
    }

    public static class OreFeatureRegistry {

        protected static final Map<String, Tuple<ResourceKey<ConfiguredFeature<?, ?>>, List<OreConfiguration.TargetBlockState>>> ORES = new HashMap<>();

        private OreFeatureRegistry() {
        }

        public static final void register(String name, List<OreConfiguration.TargetBlockState> ore) {
            ORES.put(name, new Tuple<>(FeatureRegistry.registerKey(name), ore));
        }
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        OreFeatureRegistry.ORES.forEach((key, value) -> {
            register(context, value.x, Feature.ORE, new OreConfiguration(value.y, 9));
        });
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(ScyllaCommon.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
