package net.endermans.minerals.blocks;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.custom.ColouredLampBlock;
import net.endermans.minerals.blocks.custom.EggPlantCropBlock;
import net.endermans.minerals.blocks.custom.MortarPestleBlock;
import net.endermans.minerals.blocks.custom.SmelterBlock;
import net.endermans.minerals.items.ModItemGroup;
import net.endermans.minerals.world.feature.tree.SandalwoodSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block FERRITE_ORE =
            registerBlock(
                    "ferrite_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(4f).
                            requiresTool(),
                            UniformIntProvider.create(3, 7)),
                    ModItemGroup.ELEMENTS
            );
    public static final Block DEEPSLATE_FERRITE_ORE =
            registerBlock(
                    "deepslate_ferrite_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(1.5f).
                            requiresTool().
                            sounds(BlockSoundGroup.DEEPSLATE),
                            UniformIntProvider.create(3, 7)
                    ),
                    ModItemGroup.ELEMENTS
            );

    public static final Block INDIUM_ORE =
            registerBlock(
                    "indium_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(4f).
                            requiresTool(),
                            UniformIntProvider.create(3, 7)),
                    ModItemGroup.ELEMENTS
            );
    public static final Block DEEPSLATE_INDIUM_ORE =
            registerBlock(
                    "deepslate_indium_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(1.5f).
                            requiresTool().
                            sounds(BlockSoundGroup.DEEPSLATE),
                            UniformIntProvider.create(3, 7)
                    ),
                    ModItemGroup.ELEMENTS
            );

    public static final Block BISMUTH_ORE =
            registerBlock(
                    "bismuth_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(4f).
                            requiresTool(),
                            UniformIntProvider.create(3, 7)),
                    ModItemGroup.ELEMENTS
            );
    public static final Block DEEPSLATE_BISMUTH_ORE =
            registerBlock(
                    "deepslate_bismuth_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(1.5f).
                            requiresTool().
                            sounds(BlockSoundGroup.DEEPSLATE),
                            UniformIntProvider.create(3, 7)
                    ),
                    ModItemGroup.ELEMENTS
            );


    public static final Block FERRITE_BLOCK =
            registerBlock(
                    "ferrite_block",
                    new Block(FabricBlockSettings.
                            of(Material.METAL).
                            strength(4f).
                            requiresTool().
                            sounds(BlockSoundGroup.COPPER)
                    ),
                    EndermansMinerals.ELEMENTS
            );
    public static final Block PURE_FERRITE_BLOCK =
            registerBlock(
                    "pure_ferrite_block",
                    new Block(FabricBlockSettings.
                            of(Material.METAL).
                            strength(4f).
                            requiresTool().
                            sounds(BlockSoundGroup.COPPER)
                    ),
                    ModItemGroup.ELEMENTS
            );
    public static final Block MAGNETISED_FERRITE_BLOCK =
            registerBlock(
                    "magnetised_ferrite_block",
                    new Block(FabricBlockSettings.
                            of(Material.METAL).
                            strength(4f).
                            requiresTool().
                            sounds(BlockSoundGroup.COPPER)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_BLACK =
            registerBlock(
                    "coloured_lamp_black",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_BLUE =
            registerBlock(
                    "coloured_lamp_blue",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_BROWN =
            registerBlock(
                    "coloured_lamp_brown",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_CYAN =
            registerBlock(
                    "coloured_lamp_cyan",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_GRAY =
            registerBlock(
                    "coloured_lamp_gray",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_GREEN =
            registerBlock(
                    "coloured_lamp_green",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_LIGHT_BLUE =
            registerBlock(
                    "coloured_lamp_light_blue",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_LIME =
            registerBlock(
                    "coloured_lamp_lime",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_MAGENTA =
            registerBlock(
                    "coloured_lamp_magenta",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_ORANGE =
            registerBlock(
                    "coloured_lamp_orange",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_PINK =
            registerBlock(
                    "coloured_lamp_pink",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_PURPLE =
            registerBlock(
                    "coloured_lamp_purple",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_RED =
            registerBlock(
                    "coloured_lamp_red",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_SILVER =
            registerBlock(
                    "coloured_lamp_silver",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_WHITE =
            registerBlock(
                    "coloured_lamp_white",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block COLOURED_LAMP_YELLOW =
            registerBlock(
                    "coloured_lamp_yellow",
                    new ColouredLampBlock(FabricBlockSettings.
                            of(Material.GLASS).
                            strength(1f).
                            sounds(BlockSoundGroup.GLASS).
                            luminance(state -> state.get(ColouredLampBlock.LIT)? 15:0)
                    ),
                    EndermansMinerals.ELEMENTS
            );

    public static final Block LITHIUM_ORE =
            registerBlock(
                    "lithium_ore",
                    new OreBlock(FabricBlockSettings.
                            of(Material.STONE).
                            strength(4f).
                            requiresTool(),
                            UniformIntProvider.create(3, 7)),
                    ModItemGroup.ELEMENTS
            );


    public static final Block EGGPLANT_CROP =
            registerBlockWithoutItem(
                    "eggplant_crop",
                    new EggPlantCropBlock(FabricBlockSettings.copy(Blocks.WHEAT)));

    public static final Block REDSTONE_TABLE =
            registerBlock(
                    "redstone_table",
                    new Block(FabricBlockSettings.
                            of(Material.METAL).
                            requiresTool().
                            sounds(BlockSoundGroup.COPPER).
                            strength(4f)
                    ),
                    ModItemGroup.ELEMENTS
            );

    public static final Block MORTAR_PESTLE =
            registerBlock(
                    "mortar_pestle",
                    new MortarPestleBlock(FabricBlockSettings.
                            of(Material.METAL).
                            requiresTool().
                            strength(4f).
                            nonOpaque()
                    ),
                    ModItemGroup.ELEMENTS
            );

    public static final Block SMELTER =
            registerBlock(
                    "smelter",
                    new SmelterBlock(FabricBlockSettings.
                            of(Material.METAL).
                            requiresTool().
                            strength(4f).
                            nonOpaque()
                    ),
                    ModItemGroup.ELEMENTS
            );

    public static final Block SANDALWOOD_LOG =
            registerBlock(
                    "sandalwood_log",
                    new PillarBlock(FabricBlockSettings.
                            copy(Blocks.DARK_OAK_LOG)
                    ),
                    ModItemGroup.ELEMENTS
            );

public static final Block SANDALWOOD_WOOD =
            registerBlock(
                    "sandalwood_wood",
                    new PillarBlock(FabricBlockSettings.
                            copy(Blocks.DARK_OAK_WOOD)
                    ),
                    ModItemGroup.ELEMENTS
            );

public static final Block STRIPPED_SANDALWOOD_LOG =
            registerBlock(
                    "stripped_sandalwood_log",
                    new PillarBlock(FabricBlockSettings.
                            copy(Blocks.STRIPPED_DARK_OAK_LOG)
                    ),
                    ModItemGroup.ELEMENTS
            );

public static final Block STRIPPED_SANDALWOOD_WOOD =
            registerBlock(
                    "stripped_sandalwood_wood",
                    new PillarBlock(FabricBlockSettings.
                            copy(Blocks.STRIPPED_DARK_OAK_WOOD)
                    ),
                    ModItemGroup.ELEMENTS
            );

public static final Block SANDALWOOD_PLANKS =
            registerBlock(
                    "sandalwood_planks",
                    new Block(FabricBlockSettings.
                            copy(Blocks.DARK_OAK_PLANKS)
                    ),
                    ModItemGroup.ELEMENTS
            );

public static final Block SANDALWOOD_LEAVES =
            registerBlock(
                    "sandalwood_leaves",
                    new LeavesBlock(FabricBlockSettings.
                            copy(Blocks.DARK_OAK_LEAVES)
                    ),
                    ModItemGroup.ELEMENTS
            );

public static final Block SANDALWOOD_SAPLING =
            registerBlock(
                    "sandalwood_sapling",
                    new SaplingBlock(new SandalwoodSaplingGenerator(),
                            FabricBlockSettings.
                            copy(Blocks.OAK_SAPLING)
                    ),
                    ModItemGroup.ELEMENTS
            );








    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(EndermansMinerals.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(EndermansMinerals.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(EndermansMinerals.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks(){
        EndermansMinerals.LOGGER.debug("Registering ModBlocks for "+ EndermansMinerals.MOD_ID);
    }
}
