package net.endermans.minerals.items;

import net.endermans.minerals.EndermansMinerals;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item FERRITE_DUST = registerItem("ferrite_dust",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item FERRITE = registerItem("ferrite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
    public static final Item PURE_FERRITE = registerItem("pure_ferrite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));
public static final Item MAGNETISED_FERRITE = registerItem("magnetised_ferrite",
            new Item(new FabricItemSettings().group(ItemGroup.MISC)));






    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EndermansMinerals.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EndermansMinerals.LOGGER.debug("Registering mod items for "+EndermansMinerals.MOD_ID);

    }
}
