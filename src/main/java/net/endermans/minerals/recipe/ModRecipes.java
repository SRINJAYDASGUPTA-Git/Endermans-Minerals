package net.endermans.minerals.recipe;

import net.endermans.minerals.EndermansMinerals;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER,
                new Identifier(EndermansMinerals.MOD_ID,
                        MortarPestleRecipe.Serializer.ID),
                MortarPestleRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE,
                new Identifier(EndermansMinerals.MOD_ID, MortarPestleRecipe.Type.ID),
                MortarPestleRecipe.Type.INSTANCE);
    }
}
