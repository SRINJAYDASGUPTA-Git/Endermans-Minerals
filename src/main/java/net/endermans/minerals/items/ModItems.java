package net.endermans.minerals.items;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.endermans.minerals.entity.ModEntities;
import net.endermans.minerals.items.custom.ModHoeItem;
import net.endermans.minerals.items.custom.ModMusicDiscItem;
import net.endermans.minerals.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item FERRITE_DUST =
            registerItem(
                    "ferrite_dust",
                    new Item(
                            new FabricItemSettings().
                                    group(EndermansMinerals.ELEMENTS)));
    public static final Item FERRITE =
            registerItem(
                    "ferrite",
                    new Item(
                            new FabricItemSettings().
                                    group(EndermansMinerals.ELEMENTS)));
    public static final Item PURE_FERRITE =
            registerItem(
                    "pure_ferrite",
                    new Item(
                            new FabricItemSettings().
                                    group(EndermansMinerals.ELEMENTS)));
    public static final Item MAGNETISED_FERRITE =
        registerItem(
                "magnetised_ferrite",
                new Item(new FabricItemSettings().
                        group(EndermansMinerals.ELEMENTS)));


    public static final Item RAW_LITHIUM =
        registerItem(
                "raw_lithium",
                new Item(new FabricItemSettings().
                        group(EndermansMinerals.ELEMENTS)));

    public static final Item LITHIUM =
        registerItem(
                "lithium",
                new Item(new FabricItemSettings().
                        group(EndermansMinerals.ELEMENTS)));

    public static final Item EGGPLANT_SEEDS =
        registerItem(
                "eggplant_seeds",
                new AliasedBlockItem(ModBlocks.EGGPLANT_CROP,
                        new FabricItemSettings().
                        group(EndermansMinerals.ELEMENTS)));

    public static final Item EGGPLANT =
        registerItem(
                "eggplant",
                new Item(
                        new FabricItemSettings().
                        group(EndermansMinerals.ELEMENTS).
                        food(new FoodComponent.Builder().
                                hunger(2).
                                saturationModifier(2f).
                                build()
                        )
                )
        );

    public static final Item DANDELIONS_MUSIC_DISC =
            registerItem(
                    "dandelions_music_disc",
                    new ModMusicDiscItem(7, ModSounds.DANDELIONS,
                            new FabricItemSettings().
                            group(ModItemGroup.DISCS).maxCount(1),
                            233));

    public static final Item ONE_DANCE_MUSIC_DISC =
            registerItem(
                    "one_dance_music_disc",
                    new ModMusicDiscItem(7, ModSounds.ONE_DANCE,
                            new FabricItemSettings().
                            group(ModItemGroup.DISCS).maxCount(1),
                            175));

    public static final Item WATERMELON_SUGAR_MUSIC_DISC =
            registerItem(
                    "watermelon_sugar_music_disc",
                    new ModMusicDiscItem(7, ModSounds.WATERMELON_SUGAR,
                            new FabricItemSettings().
                            group(ModItemGroup.DISCS).maxCount(1),
                            174));

    public static final Item LITHIUM_DUST =
            registerItem(
                    "lithium_dust",
                    new Item(new FabricItemSettings().
                            group(EndermansMinerals.ELEMENTS)));

    public static final Item BLANK_DISC =
            registerItem(
                    "blank_disc",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.DISCS)));

    public static final Item BLANK_DISC_FRAGMENT =
            registerItem(
                    "blank_disc_fragment",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.DISCS)));

    public static final Item RAW_INDIUM =
            registerItem(
                    "raw_indium",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.ELEMENTS)));

    public static final Item INDIUM_INGOT =
            registerItem(
                    "indium_ingot",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.ELEMENTS)));

    public static final Item INDIUM_DUST =
            registerItem(
                    "indium_dust",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.ELEMENTS)));

    public static final Item IRON_DUST =
            registerItem(
                    "iron_dust",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.ELEMENTS)));

    public static final Item BISMUTH_DUST =
            registerItem(
                    "bismuth_dust",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.ELEMENTS)));


    public static final Item BISMUTH_CRYSTAL =
            registerItem(
                    "bismuth_crystal",
                    new Item(new FabricItemSettings().
                            group(ModItemGroup.ELEMENTS)));

    public static final Item FOREST_GOLEM_SPAWNEGG =
            registerItem(
                    "forest_golem_spawnegg",
                    new SpawnEggItem(ModEntities.FOREST_GOLEM,
                            0x8e8c8e,
                            0x6d3f01,
                            new FabricItemSettings().group(ModItemGroup.ELEMENTS)));


    public static final Item BISMUTH_SWORD =
            registerItem("bismuth_sword",
                    new SwordItem(ModToolMaterials.BISMUTH,
                            2,
                            2.5f,
                            new FabricItemSettings()
                                    .group(ModItemGroup.ELEMENTS)));

    public static final Item BISMUTH_AXE =
            registerItem("bismuth_axe",
                    new AxeItem(ModToolMaterials.BISMUTH,
                            3,
                            1.5f,
                            new FabricItemSettings()
                                    .group(ModItemGroup.ELEMENTS)));

    public static final Item BISMUTH_PICKAXE =
            registerItem("bismuth_pickaxe",
                    new PickaxeItem(ModToolMaterials.BISMUTH,
                            4,
                            2f,
                            new FabricItemSettings()
                                    .group(ModItemGroup.ELEMENTS)));

    public static final Item BISMUTH_SHOVEL =
            registerItem("bismuth_shovel",
                    new ShovelItem(ModToolMaterials.BISMUTH,
                            1,
                            1f,
                            new FabricItemSettings()
                                    .group(ModItemGroup.ELEMENTS)));

    public static final Item BISMUTH_HOE =
            registerItem("bismuth_hoe",
                    new ModHoeItem(ModToolMaterials.BISMUTH,
                            0,
                            0f,
                            new FabricItemSettings()
                                    .group(ModItemGroup.ELEMENTS)));
















    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EndermansMinerals.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EndermansMinerals.LOGGER.debug("Registering mod items for "+EndermansMinerals.MOD_ID);

    }
}
