
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hello.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.hello.client.gui.QuestProvideGUIScreen;
import net.mcreator.hello.client.gui.QuestNotFinishedScreen;
import net.mcreator.hello.client.gui.QuestGuiScreen;
import net.mcreator.hello.client.gui.QuestFinishedScreen;
import net.mcreator.hello.client.gui.MoneyGuiScreen;
import net.mcreator.hello.client.gui.JobNpcGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HelloModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(HelloModMenus.QUEST_GUI.get(), QuestGuiScreen::new);
		event.register(HelloModMenus.QUEST_PROVIDE_GUI.get(), QuestProvideGUIScreen::new);
		event.register(HelloModMenus.QUEST_NOT_FINISHED.get(), QuestNotFinishedScreen::new);
		event.register(HelloModMenus.QUEST_FINISHED.get(), QuestFinishedScreen::new);
		event.register(HelloModMenus.MONEY_GUI.get(), MoneyGuiScreen::new);
		event.register(HelloModMenus.JOB_NPC_GUI.get(), JobNpcGUIScreen::new);
	}
}
