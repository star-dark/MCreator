

/*
 *	MCreator note: This file will be REGENERATED on each build.
 */

package net.mcreator.hello.init;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT}) public class HelloModKeyMappings {

	public static final KeyMapping OPEN_QUEST_GUI = new KeyMapping(
			"key.hello.open_quest_gui", GLFW.GLFW_KEY_R,
			"key.categories.misc")
				{
					private boolean isDownOld = false;

					@Override public void setDown(boolean isDown) {
						super.setDown(isDown);

						if (isDownOld != isDown && isDown) {
								PacketDistributor.sendToServer(new OpenQuestGUIMessage(0, 0));
								OpenQuestGUIMessage.pressAction(Minecraft.getInstance().player, 0, 0);

						}

						isDownOld = isDown;
					}
				}
			;


	@SubscribeEvent public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_QUEST_GUI);
	}

	@EventBusSubscriber({Dist.CLIENT}) public static class KeyEventListener {

		@SubscribeEvent public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
					OPEN_QUEST_GUI.consumeClick();
			}
		}

	}

}

