package net.endermans.minerals.util;

import net.endermans.minerals.blocks.ModBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.SANDALWOOD_LOG, 5, 5);
        registry.add(ModBlocks.SANDALWOOD_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_SANDALWOOD_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_SANDALWOOD_WOOD, 5, 5);

        registry.add(ModBlocks.SANDALWOOD_LEAVES, 30, 60);
        registry.add(ModBlocks.SANDALWOOD_PLANKS, 5, 20);



    }
}
