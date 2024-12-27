
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hello.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.hello.world.inventory.QuestProvideGUIMenu;
import net.mcreator.hello.world.inventory.QuestNotFinishedMenu;
import net.mcreator.hello.world.inventory.QuestGuiMenu;
import net.mcreator.hello.world.inventory.QuestFinishedMenu;
import net.mcreator.hello.world.inventory.MoneyGuiMenu;
import net.mcreator.hello.world.inventory.JobNpcGUIMenu;
import net.mcreator.hello.HelloMod;

public class HelloModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, HelloMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<QuestGuiMenu>> QUEST_GUI = REGISTRY.register("quest_gui", () -> IMenuTypeExtension.create(QuestGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestProvideGUIMenu>> QUEST_PROVIDE_GUI = REGISTRY.register("quest_provide_gui", () -> IMenuTypeExtension.create(QuestProvideGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestNotFinishedMenu>> QUEST_NOT_FINISHED = REGISTRY.register("quest_not_finished", () -> IMenuTypeExtension.create(QuestNotFinishedMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuestFinishedMenu>> QUEST_FINISHED = REGISTRY.register("quest_finished", () -> IMenuTypeExtension.create(QuestFinishedMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MoneyGuiMenu>> MONEY_GUI = REGISTRY.register("money_gui", () -> IMenuTypeExtension.create(MoneyGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobNpcGUIMenu>> JOB_NPC_GUI = REGISTRY.register("job_npc_gui", () -> IMenuTypeExtension.create(JobNpcGUIMenu::new));
}
