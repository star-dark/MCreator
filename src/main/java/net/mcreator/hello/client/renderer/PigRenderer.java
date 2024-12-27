

package net.mcreator.hello.client.renderer;




public class PigRenderer extends MobRenderer<PigEntity, PigModel<PigEntity>> {

	public PigRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<PigEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);


	}


	@Override public ResourceLocation getTextureLocation(PigEntity entity) {
		return ResourceLocation.parse("hello:textures/entities/pig.png");
	}




}
