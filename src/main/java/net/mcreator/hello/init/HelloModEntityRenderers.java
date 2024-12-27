
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hello.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.hello.client.renderer.QueenRenderer;
import net.mcreator.hello.client.renderer.PigRenderer;
import net.mcreator.hello.client.renderer.MinerJobNpcRenderer;
import net.mcreator.hello.client.renderer.KingRenderer;
import net.mcreator.hello.client.renderer.FisherJobNpcRenderer;
import net.mcreator.hello.client.renderer.FarmerJobNpcRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HelloModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(HelloModEntities.KING.get(), KingRenderer::new);
		event.registerEntityRenderer(HelloModEntities.PIG.get(), PigRenderer::new);
		event.registerEntityRenderer(HelloModEntities.QUEEN.get(), QueenRenderer::new);
		event.registerEntityRenderer(HelloModEntities.FARMER_JOB_NPC.get(), FarmerJobNpcRenderer::new);
		event.registerEntityRenderer(HelloModEntities.FISHER_JOB_NPC.get(), FisherJobNpcRenderer::new);
		event.registerEntityRenderer(HelloModEntities.MINER_JOB_NPC.get(), MinerJobNpcRenderer::new);
	}
}
