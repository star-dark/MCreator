package net.mcreator.hello.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.hello.network.HelloModVariables;

public class ClickRejectButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\uB2E4\uC74C\uC5D0 \uC624\uAC8C.."), false);
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.reward_money = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.quest_Contents = "";
			_vars.syncPlayerVariables(entity);
		}
	}
}
