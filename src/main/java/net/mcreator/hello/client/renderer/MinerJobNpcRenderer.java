
package net.mcreator.hello.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.hello.entity.MinerJobNpcEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class MinerJobNpcRenderer extends MobRenderer<MinerJobNpcEntity, VillagerModel<MinerJobNpcEntity>> {
	public MinerJobNpcRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<MinerJobNpcEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
	}

	@Override
	protected void scale(MinerJobNpcEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(MinerJobNpcEntity entity) {
		return ResourceLocation.parse("hello:textures/entities/skin-villager.png");
	}
}
