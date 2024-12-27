
package net.mcreator.hello.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import net.mcreator.hello.entity.PigEntity;

public class PigRenderer extends MobRenderer<PigEntity, PigModel<PigEntity>> {
	public PigRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<PigEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PigEntity entity) {
		return ResourceLocation.parse("hello:textures/entities/pig.png");
	}
}
