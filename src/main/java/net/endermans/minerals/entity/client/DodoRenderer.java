package net.endermans.minerals.entity.client;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.entity.custom.DodoEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
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

    @Override
    public RenderLayer getRenderType(DodoEntity animatable, float partialTicks, MatrixStack stack, @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        if(animatable.isBaby()){
            stack.scale(0.4f, 0.4f, 0.4f);
        }

        else{
            stack.scale(0.8f, 0.8f, 0.8f);
        }

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
