
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
			tabData.accept(HelloModItems.FISH_ROD_LV_1.get());
			tabData.accept(HelloModItems.FISH_ROD_LV_15.get());
			tabData.accept(HelloModItems.FISH_ROD_LV_30.get());
			tabData.accept(HelloModItems.MINER_PICK_LV_1.get());
			tabData.accept(HelloModItems.MINER_PICK_LV_15.get());
			tabData.accept(HelloModItems.MINER_PICK_LV_30.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(HelloModItems.MANWON.get());
			tabData.accept(HelloModItems.OCHUNWON.get());
			tabData.accept(HelloModItems.CHUNWON.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(HelloModItems.FISH_ANGLER.get());
			tabData.accept(HelloModItems.FISH_ARAPAIMA.get());
			tabData.accept(HelloModItems.FISH_BASS.get());
			tabData.accept(HelloModItems.FISH_BLUE_GILL.get());
			tabData.accept(HelloModItems.FISH_CARP.get());
			tabData.accept(HelloModItems.FISH_CATFISH.get());
			tabData.accept(HelloModItems.FISH_ELECTRIC_EEL.get());
			tabData.accept(HelloModItems.FISH_HAILBUT.get());
			tabData.accept(HelloModItems.FISH_HERRING.get());
			tabData.accept(HelloModItems.FISH_MUSKELLUNGE.get());
			tabData.accept(HelloModItems.FISH_PERCH.get());
			tabData.accept(HelloModItems.FISH_POLLOCK.get());
			tabData.accept(HelloModItems.FISH_RAINBOW_TROUT.get());
			tabData.accept(HelloModItems.FISH_RED_BELLIED_PIRANHA.get());
			tabData.accept(HelloModItems.FISH_RED_GROUPER.get());
			tabData.accept(HelloModItems.FISH_SYNODONTIS.get());
			tabData.accept(HelloModItems.FISH_TAMBAQUI.get());
			tabData.accept(HelloModItems.FISH_TUNA.get());
		}
	}
}
