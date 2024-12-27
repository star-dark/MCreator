

package net.mcreator.hello.client.renderer;




public class QueenRenderer extends HumanoidMobRenderer<QueenEntity, HumanoidModel<QueenEntity>> {

	public QueenRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<QueenEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);

		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)),
				new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

		this.addLayer(new RenderLayer<QueenEntity, HumanoidModel<QueenEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("hello:textures/entities/queen.png");

@Override public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light,
QueenEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light,
LivingEntityRenderer.getOverlayCoords(entity, 0));
}		});
	}


	@Override public ResourceLocation getTextureLocation(QueenEntity entity) {
		return ResourceLocation.parse("hello:textures/entities/queen.png");
	}




}
