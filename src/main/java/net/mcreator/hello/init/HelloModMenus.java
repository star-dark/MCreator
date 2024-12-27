
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */

package net.mcreator.hello.init;

public class HelloModMenus {

	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, HelloMod.MODID);

	public static final DeferredHolder<MenuType<?>, MenuType<QuestGuiMenu>> QUEST_GUI
		= REGISTRY.register("quest_gui", () -> IMenuTypeExtension.create(QuestGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestProvideGUIMenu>> QUEST_PROVIDE_GUI
		= REGISTRY.register("quest_provide_gui", () -> IMenuTypeExtension.create(QuestProvideGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestNotFinishedMenu>> QUEST_NOT_FINISHED
		= REGISTRY.register("quest_not_finished", () -> IMenuTypeExtension.create(QuestNotFinishedMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestFinishedMenu>> QUEST_FINISHED
		= REGISTRY.register("quest_finished", () -> IMenuTypeExtension.create(QuestFinishedMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MoneyGuiMenu>> MONEY_GUI
		= REGISTRY.register("money_gui", () -> IMenuTypeExtension.create(MoneyGuiMenu::new));

}

