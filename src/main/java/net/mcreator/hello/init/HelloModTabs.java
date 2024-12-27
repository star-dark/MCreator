
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hello.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.hello.HelloMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class HelloModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HelloMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(HelloModItems.KING_SPAWN_EGG.get());
			tabData.accept(HelloModItems.PIG_SPAWN_EGG.get());
			tabData.accept(HelloModItems.QUEEN_SPAWN_EGG.get());
			tabData.accept(HelloModItems.FARMER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(HelloModItems.FISHER_JOB_NPC_SPAWN_EGG.get());
			tabData.accept(HelloModItems.MINER_JOB_NPC_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(HelloModItems.MAGICWAND.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(HelloModItems.MANWON.get());
			tabData.accept(HelloModItems.OCHUNWON.get());
			tabData.accept(HelloModItems.CHUNWON.get());
		}
	}
}
