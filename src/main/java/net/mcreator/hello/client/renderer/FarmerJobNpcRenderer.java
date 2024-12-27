
package net.mcreator.hello.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.hello.entity.FarmerJobNpcEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class FarmerJobNpcRenderer extends MobRenderer<FarmerJobNpcEntity, VillagerModel<FarmerJobNpcEntity>> {
	public FarmerJobNpcRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<FarmerJobNpcEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	protected void scale(FarmerJobNpcEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(FarmerJobNpcEntity entity) {
		return ResourceLocation.parse("hello:textures/entities/villagerpng.png");
	}
}
