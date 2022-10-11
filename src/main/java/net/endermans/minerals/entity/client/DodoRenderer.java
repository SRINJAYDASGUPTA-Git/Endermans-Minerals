package net.endermans.minerals.entity.client;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.entity.custom.DodoEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DodoRenderer extends GeoEntityRenderer<DodoEntity> {
    public DodoRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DodoModel());
    }

    @Override
    public Identifier getTextureResource(DodoEntity entity) {
        return new Identifier(EndermansMinerals.MOD_ID, "textures/entity/dodo.png");
    }
}
