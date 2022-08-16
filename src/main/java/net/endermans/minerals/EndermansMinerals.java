package net.endermans.minerals;

import net.endermans.minerals.blocks.ModBlocks;
import net.endermans.minerals.items.ModItemGroup;
import net.endermans.minerals.items.ModItems;
import net.endermans.minerals.items.custom.MagnetItem;
import net.endermans.minerals.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
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

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModVillagers.registerVillagers();
		ModVillagers.registerTraders();

		Registry.register(Registry.ITEM, new Identifier(MOD_ID,"magnet"), MAGNET_ITEM_INSTANCE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID,"strong_magnet"), STRONG_MAGNET_ITEM_INSTANCE);
	}
}
