package net.endermans.minerals.entity.client;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.entity.custom.ForestGolemEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ForestGolemModel extends AnimatedGeoModel<ForestGolemEntity> {
    @Override
    public Identifier getModelResource(ForestGolemEntity object) {
        return new Identifier(EndermansMinerals.MOD_ID, "geo/forest_golem.geo.json");
    }

    @Override
    public Identifier getTextureResource(ForestGolemEntity object) {
        return new Identifier(EndermansMinerals.MOD_ID, "textures/entity/forest_golem.png");
    }

    @Override
    public Identifier getAnimationResource(ForestGolemEntity animatable) {
        return new Identifier(EndermansMinerals.MOD_ID, "animations/forest_golem.animation.json");
    }
}
