package net.mcreator.hello.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;
import net.mcreator.hello.init.HelloModItems;

public class ChunwonRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.my_money = entity.getData(HelloModVariables.PLAYER_VARIABLES).Questgoal1 + 1000;
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(HelloModItems.CHUNWON.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}
