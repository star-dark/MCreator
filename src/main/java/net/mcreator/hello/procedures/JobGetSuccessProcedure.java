package net.mcreator.hello.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.hello.network.HelloModVariables;

public class JobGetSuccessProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(HelloModVariables.PLAYER_VARIABLES).talk_with).equals("Farmer")) {
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.job_production = "Farmer";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB10C \uC774\uC81C \uB18D\uBD80\uB77C\uB124!"), true);
		} else if ((entity.getData(HelloModVariables.PLAYER_VARIABLES).talk_with).equals("Fisher")) {
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.job_production = "Fisher";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uB10C \uC774\uC81C \uB09A\uC2DC \uCE5C\uAD6C\uC57C!"), true);
		} else if ((entity.getData(HelloModVariables.PLAYER_VARIABLES).talk_with).equals("Miner")) {
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.job_production = "Miner";
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uD750\uD750\uD750 \uD638\uAD6C \uC7A1\uC558\uB2E4!"), true);
		}
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.talk_with = "";
			_vars.syncPlayerVariables(entity);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
