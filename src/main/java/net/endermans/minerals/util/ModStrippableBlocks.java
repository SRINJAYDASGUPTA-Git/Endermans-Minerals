package net.endermans.minerals.util;

import net.endermans.minerals.blocks.ModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlocks {
    public static void registerStrippableBlocks(){
        StrippableBlockRegistry.register(ModBlocks.SANDALWOOD_LOG, ModBlocks.STRIPPED_SANDALWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.SANDALWOOD_WOOD, ModBlocks.STRIPPED_SANDALWOOD_WOOD);
    }
}
