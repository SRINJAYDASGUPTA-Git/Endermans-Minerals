package net.endermans.minerals.items;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup ELEMENTS =
            FabricItemGroupBuilder.
                    build(
            new Identifier(EndermansMinerals.MOD_ID, "elements"),
            ()-> new ItemStack(ModItems.PURE_FERRITE)
                    );
}
