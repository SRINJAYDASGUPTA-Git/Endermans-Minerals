package net.endermans.minerals.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static RegistryEntry<PlacedFeature> FERRITE_ORE_PLACED =
            PlacedFeatures.register("ferrite_ore_placed",
            ModConfiguredFeature.FERRITE_ORE,
                    modifiersWithCount(
                            10,
                            HeightRangePlacementModifier.
                                    trapezoid(YOffset.fixed(-80),
                                            YOffset.fixed(80)
                                    )
                    ));
    public static RegistryEntry<PlacedFeature> INDIUM_ORE_PLACED =
            PlacedFeatures.register("indium_ore_placed",
            ModConfiguredFeature.INDIUM_ORE,
                    modifiersWithCount(
                            5,
                            HeightRangePlacementModifier.
                                    trapezoid(YOffset.fixed(-80),
                                            YOffset.fixed(80)
                                    )
                    ));

    public static RegistryEntry<PlacedFeature> LITHIUM_ORE_PLACED =
            PlacedFeatures.register("lithium_ore_placed",
            ModConfiguredFeature.LIHIUM_ORE,
                    modifiersWithCount(
                            10,
                            HeightRangePlacementModifier.
                                    trapezoid(YOffset.fixed(-80),
                                            YOffset.fixed(80)
                                    )
                    ));

    public static RegistryEntry<PlacedFeature> SANDALWOOD_PLACED = PlacedFeatures.register("sandalwood_placed",
            ModConfiguredFeature.SANDALWOOD_SPAWN,
            VegetationPlacedFeatures.modifiers(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2)));




    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}
