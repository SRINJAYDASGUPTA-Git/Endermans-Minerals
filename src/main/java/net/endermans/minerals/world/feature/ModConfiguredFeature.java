package net.endermans.minerals.world.feature;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

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
            ConfiguredFeatures.register("ferrite_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_INDIUM_ORES, 9));



    public static RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LIHIUM_ORE =
            ConfiguredFeatures.register("lithium_ore", Feature.ORE, new OreFeatureConfig(END_LITHIUM_ORES, 9));

    public static void registerConfiguredFeatures(){
        EndermansMinerals.LOGGER.debug("Registering Feature for "+EndermansMinerals.MOD_ID );
    }
}
