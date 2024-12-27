package net.mcreator.hello.procedures;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.mcreator.hello.network.HelloModVariables;
import net.mcreator.hello.init.HelloModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetitemstackProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.neoforged.neoforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		HelloModVariables.MapVariables.get(world).reward_man = new ItemStack(HelloModItems.MANWON.get()).copy();
		HelloModVariables.MapVariables.get(world).syncData(world);
		HelloModVariables.MapVariables.get(world).reward_ochun = new ItemStack(HelloModItems.OCHUNWON.get()).copy();
		HelloModVariables.MapVariables.get(world).syncData(world);
		HelloModVariables.MapVariables.get(world).reward_chun = new ItemStack(HelloModItems.CHUNWON.get()).copy();
		HelloModVariables.MapVariables.get(world).syncData(world);
	}
}
