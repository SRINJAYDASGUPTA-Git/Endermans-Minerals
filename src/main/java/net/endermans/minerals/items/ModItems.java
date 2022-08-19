package net.endermans.minerals.items;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.endermans.minerals.items.custom.ModMusicDiscItem;
import net.endermans.minerals.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
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
                            group(EndermansMinerals.ELEMENTS).maxCount(1),
                            233));

    public static final Item ONE_DANCE_MUSIC_DISC =
            registerItem(
                    "one_dance_music_disc",
                    new ModMusicDiscItem(7, ModSounds.ONE_DANCE,
                            new FabricItemSettings().
                            group(EndermansMinerals.ELEMENTS).maxCount(1),
                            175));

    public static final Item WATERMELON_SUGAR_MUSIC_DISC =
            registerItem(
                    "watermelon_sugar_music_disc",
                    new ModMusicDiscItem(7, ModSounds.WATERMELON_SUGAR,
                            new FabricItemSettings().
                            group(EndermansMinerals.ELEMENTS).maxCount(1),
                            174));









    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EndermansMinerals.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EndermansMinerals.LOGGER.debug("Registering mod items for "+EndermansMinerals.MOD_ID);

    }
}
