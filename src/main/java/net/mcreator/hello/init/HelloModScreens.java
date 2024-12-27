
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */

package net.mcreator.hello.init;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT) public class HelloModScreens {

	@SubscribeEvent public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(HelloModMenus.QUEST_GUI.get(), QuestGuiScreen::new);
		event.register(HelloModMenus.QUEST_PROVIDE_GUI.get(), QuestProvideGUIScreen::new);
		event.register(HelloModMenus.QUEST_NOT_FINISHED.get(), QuestNotFinishedScreen::new);
		event.register(HelloModMenus.QUEST_FINISHED.get(), QuestFinishedScreen::new);
		event.register(HelloModMenus.MONEY_GUI.get(), MoneyGuiScreen::new);
	}

}

