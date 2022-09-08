package net.endermans.minerals.network;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.network.packets.EnergySyncS2CPacket;
import net.endermans.minerals.network.packets.FluidSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier ENERGY_SYNC = new Identifier(EndermansMinerals.MOD_ID, "energy_sync");
    public static final Identifier FLUID_SYNC = new Identifier(EndermansMinerals.MOD_ID, "fluid_sync");

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(FLUID_SYNC, FluidSyncS2CPacket::receive);

    }
}
