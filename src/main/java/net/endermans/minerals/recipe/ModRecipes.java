package net.endermans.minerals.recipe;

import net.endermans.minerals.EndermansMinerals;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void registerRecipes(){
        //MORTAR AND PESTLE
        Registry.register(Registry.RECIPE_SERIALIZER,
                new Identifier(EndermansMinerals.MOD_ID,
                        MortarPestleRecipe.Serializer.ID),
                MortarPestleRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE,
                new Identifier(EndermansMinerals.MOD_ID,
                        MortarPestleRecipe.Type.ID),
                MortarPestleRecipe.Type.INSTANCE);

        //SMELTER
        Registry.register(Registry.RECIPE_SERIALIZER,
                new Identifier(EndermansMinerals.MOD_ID,
                        SmelterRecipe.Serializer.ID),
                SmelterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE,
                new Identifier(EndermansMinerals.MOD_ID,
                        SmelterRecipe.Type.ID),
                SmelterRecipe.Type.INSTANCE);
    }
}
