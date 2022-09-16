package net.endermans.minerals;

import net.endermans.minerals.blocks.ModBlocks;
import net.endermans.minerals.fluid.ModFluids;
import net.endermans.minerals.screen.ModScreenHandlers;
import net.endermans.minerals.screen.MortarPestleScreen;
import net.endermans.minerals.screen.SmelterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;

public class EndermansMineralsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGGPLANT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMELTER, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ELEMENTX, ModFluids.FLOWING_ELEMENTX,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xA020024f
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_ELEMENTX, ModFluids.FLOWING_ELEMENTX);

        HandledScreens.register(ModScreenHandlers.MORTAR_PESTLE_SCREEN_HANDLER, MortarPestleScreen::new);
        HandledScreens.register(ModScreenHandlers.SMELTER_SCREEN_HANDLER, SmelterScreen::new);
        GeckoLib.initialize();
        
    }
}
