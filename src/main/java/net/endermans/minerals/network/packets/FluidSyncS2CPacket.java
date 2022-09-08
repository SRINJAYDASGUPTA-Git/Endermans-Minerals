package net.endermans.minerals.network.packets;

import net.endermans.minerals.blocks.entity.SmelterBlockEntity;
import net.endermans.minerals.screen.SmelterScreenHandler;
import net.endermans.minerals.util.FluidStack;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.math.BlockPos;

public class FluidSyncS2CPacket {

    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        FluidVariant fluidVariant = FluidVariant.fromPacket(buf);
        long fluidLevel = buf.readLong();
        BlockPos position = buf.readBlockPos();

        assert client.world != null;
        if(client.world.getBlockEntity(position) instanceof SmelterBlockEntity blockEntity) {
            blockEntity.setFluidLevel(fluidVariant, fluidLevel);

            if(client.player.currentScreenHandler instanceof SmelterScreenHandler screenHandler &&
                    screenHandler.blockEntity.getPos().equals(position)) {
                blockEntity.setFluidLevel(fluidVariant, fluidLevel);
                screenHandler.setFluid(new FluidStack(fluidVariant, fluidLevel));
            }
        }
    }
}
