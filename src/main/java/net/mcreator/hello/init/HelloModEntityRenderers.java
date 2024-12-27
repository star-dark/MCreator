
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */

package net.mcreator.hello.init;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT) public class HelloModEntityRenderers {

	@SubscribeEvent public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
				event.registerEntityRenderer(HelloModEntities.KING.get(), KingRenderer::new);
				event.registerEntityRenderer(HelloModEntities.PIG.get(), PigRenderer::new);
				event.registerEntityRenderer(HelloModEntities.QUEEN.get(), QueenRenderer::new);
	}
}
