package net.endermans.minerals.entity;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.entity.custom.DodoEntity;
import net.endermans.minerals.entity.custom.ForestGolemEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<ForestGolemEntity> FOREST_GOLEM = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EndermansMinerals.MOD_ID, "forest_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ForestGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(2.0f, 2.0f)).build());

    public static final EntityType<DodoEntity> DODO = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(EndermansMinerals.MOD_ID, "dodo"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, DodoEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2f, 0.3f)).build()
    );


}
