package net.endermans.minerals.fluid;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.items.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static FlowableFluid STILL_ELEMENTX;
    public static FlowableFluid FLOWING_ELEMENTX;
    public static Block ELEMENTX_BLOCK;
    public static Item ELEMENTX_BUCKET;

    public static void register() {
        STILL_ELEMENTX = Registry.register(Registry.FLUID,
                new Identifier(EndermansMinerals.MOD_ID, "elementx"), new ElementXFluid.Still());
        FLOWING_ELEMENTX = Registry.register(Registry.FLUID,
                new Identifier(EndermansMinerals.MOD_ID, "flowing_elementx"), new ElementXFluid.Flowing());

        ELEMENTX_BLOCK = Registry.register(Registry.BLOCK, new Identifier(EndermansMinerals.MOD_ID, "elementx_block"),
                new FluidBlock(ModFluids.STILL_ELEMENTX, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        ELEMENTX_BUCKET = Registry.register(Registry.ITEM, new Identifier(EndermansMinerals.MOD_ID, "elementx_bucket"),
                new BucketItem(ModFluids.STILL_ELEMENTX, new FabricItemSettings().group(ModItemGroup.ELEMENTS).recipeRemainder(Items.BUCKET).maxCount(1)));
    }
}
