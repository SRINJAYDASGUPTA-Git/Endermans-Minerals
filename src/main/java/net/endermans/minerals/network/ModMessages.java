package net.endermans.minerals.network;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.network.packets.EnergySyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier ENERGY_SYNC = new Identifier(EndermansMinerals.MOD_ID, "energy_sync");

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
    }
}
