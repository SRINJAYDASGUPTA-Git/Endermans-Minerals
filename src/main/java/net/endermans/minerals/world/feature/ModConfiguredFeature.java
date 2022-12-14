package net.endermans.minerals.world.feature;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeature {
    public static final List<OreFeatureConfig.Target> OVERWORLD_FERRITE_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.FERRITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_FERRITE_ORE.getDefaultState())
    );

    public static final List<OreFeatureConfig.Target> OVERWORLD_INDIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.INDIUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_INDIUM_ORE.getDefaultState())
    );


    public static final List<OreFeatureConfig.Target> END_LITHIUM_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.LITHIUM_ORE.getDefaultState())
    );

    public static RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> FERRITE_ORE =
            ConfiguredFeatures.register("ferrite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_FERRITE_ORES, 9));

    public static RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> INDIUM_ORE =
            ConfiguredFeatures.register("indium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_INDIUM_ORES, 9));


    public static RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LIHIUM_ORE =
            ConfiguredFeatures.register("lithium_ore", Feature.ORE, new OreFeatureConfig(END_LITHIUM_ORES, 9));


    public static RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> SANDALWOOD_TREE =
            ConfiguredFeatures.register("sandalwood_tree", Feature.TREE, new TreeFeatureConfig.Builder(
                    BlockStateProvider.of(ModBlocks.SANDALWOOD_LOG),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.of(ModBlocks.SANDALWOOD_LEAVES),
                    new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build()
            );


    public static RegistryEntry<PlacedFeature> SANDALWOOD_CHECKED =
            PlacedFeatures.register(
            "sandalwood_checked",
            ModConfiguredFeature.SANDALWOOD_TREE,
            List.of(PlacedFeatures.wouldSurvive(ModBlocks.SANDALWOOD_SAPLING)));

    public static RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>>
            SANDALWOOD_SPAWN =
            ConfiguredFeatures.register("sandalwood_spawn",
                    Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfig(List.of(
                            new RandomFeatureEntry(SANDALWOOD_CHECKED, 0.5f
                            )
                    ),
                            SANDALWOOD_CHECKED));
    public static void registerConfiguredFeatures() {
        EndermansMinerals.LOGGER.debug("Registering Feature for " + EndermansMinerals.MOD_ID);
    }
}
