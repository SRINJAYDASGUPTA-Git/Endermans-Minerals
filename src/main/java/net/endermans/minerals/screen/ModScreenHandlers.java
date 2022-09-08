package net.endermans.minerals.screen;

import net.endermans.minerals.EndermansMinerals;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModScreenHandlers {

    public static ScreenHandlerType<MortarPestleScreenHandler> MORTAR_PESTLE_SCREEN_HANDLER;
    public static ScreenHandlerType<SmelterScreenHandler> SMELTER_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(SmelterScreenHandler::new);

    public static  void registerAllScreenHandlers(){
        MORTAR_PESTLE_SCREEN_HANDLER = new ScreenHandlerType<>(MortarPestleScreenHandler::new);
        Registry.register(Registry.SCREEN_HANDLER, new Identifier(EndermansMinerals.MOD_ID, "smelter"),
                SMELTER_SCREEN_HANDLER);
    }
}
