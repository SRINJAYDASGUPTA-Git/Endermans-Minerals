package net.endermans.minerals.blocks.entity;


import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {

    public static BlockEntityType<MortarPestleBlockEntity> MORTAL_PESTLE;
    public static BlockEntityType<SmelterBlockEntity> SMELTER;

    public static void registerBlockEntites(){
        MORTAL_PESTLE = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EndermansMinerals.MOD_ID, "mortar_pestle"),
                FabricBlockEntityTypeBuilder.create(MortarPestleBlockEntity::new,
                        ModBlocks.MORTAR_PESTLE).build(null));

        SMELTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EndermansMinerals.MOD_ID, "smelter"),
                FabricBlockEntityTypeBuilder.create(SmelterBlockEntity::new,
                        ModBlocks.SMELTER).build(null));

        EnergyStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.energyStorage, SMELTER);


    }
}
