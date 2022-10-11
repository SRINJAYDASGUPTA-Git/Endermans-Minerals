package net.endermans.minerals.util;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.fluid.ModFluids;
import net.endermans.minerals.items.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {
    public static void registerModStuffs(){
        registerModFuels();
    }

    private static void registerModFuels(){
        EndermansMinerals.LOGGER.info("Registering Fuels for " + EndermansMinerals.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModFluids.ELEMENTX_BUCKET, 3200);
    }
}
