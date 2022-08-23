package net.endermans.minerals.blocks.entity;


import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static BlockEntityType<MortarPestleBlockEntity> MORTAL_PESTLE;

    public static void registerBlockEntites(){
        MORTAL_PESTLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EndermansMinerals.MOD_ID, "mortar_pestle"),
                FabricBlockEntityTypeBuilder.create(MortarPestleBlockEntity::new,
                        ModBlocks.MORTAR_PESTLE).build(null));
    }
}
