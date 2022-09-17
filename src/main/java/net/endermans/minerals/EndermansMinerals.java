package net.endermans.minerals;

import net.endermans.minerals.blocks.ModBlocks;
import net.endermans.minerals.blocks.entity.ModBlockEntities;
import net.endermans.minerals.entity.ModEntities;
import net.endermans.minerals.entity.custom.ForestGolemEntity;
import net.endermans.minerals.fluid.ModFluids;
import net.endermans.minerals.items.ModItemGroup;
import net.endermans.minerals.items.ModItems;
import net.endermans.minerals.items.custom.MagnetItem;
import net.endermans.minerals.recipe.ModRecipes;
import net.endermans.minerals.screen.ModScreenHandlers;
import net.endermans.minerals.util.ModLootTableModifiers;
import net.endermans.minerals.villager.ModVillagers;
import net.endermans.minerals.world.feature.ModConfiguredFeature;
import net.endermans.minerals.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndermansMinerals implements ModInitializer {
	public static final String MOD_ID = "minerals";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ItemGroup ELEMENTS = ModItemGroup.ELEMENTS;


	public static final MagnetItem MAGNET_ITEM_INSTANCE = new MagnetItem((short)16, 512, (short)5);
	public static final MagnetItem STRONG_MAGNET_ITEM_INSTANCE = new MagnetItem((short)32, 1024, (short)7);
	@Override
	public void onInitialize() {
		ModConfiguredFeature.registerConfiguredFeatures();
		ModOreGeneration.generateOres();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTraders();

		ModLootTableModifiers.modifyLootTables();

		ModFluids.register();

		ModBlockEntities.registerBlockEntites();

		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();


		FabricDefaultAttributeRegistry.register(ModEntities.FOREST_GOLEM, ForestGolemEntity.setAttributes());

		Registry.register(Registry.ITEM, new Identifier(MOD_ID,"magnet"), MAGNET_ITEM_INSTANCE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID,"strong_magnet"), STRONG_MAGNET_ITEM_INSTANCE);
	}
}
