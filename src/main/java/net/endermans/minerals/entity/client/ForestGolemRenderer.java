package net.endermans.minerals.entity.client;

import net.endermans.minerals.EndermansMinerals;
import net.endermans.minerals.entity.custom.ForestGolemEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ForestGolemRenderer extends GeoEntityRenderer<ForestGolemEntity> {
    public ForestGolemRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ForestGolemModel());
        this.shadowRadius = 0.5f;


    }

    @Override
    public Identifier getTextureResource(ForestGolemEntity entity) {
        return new Identifier(EndermansMinerals.MOD_ID, "textures/entity/forest_golem.png");
    }

    @Override
    public RenderLayer getRenderType(ForestGolemEntity animatable, float partialTicks, MatrixStack stack, @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {

        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);

    }
}
