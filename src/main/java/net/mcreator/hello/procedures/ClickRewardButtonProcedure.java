package net.mcreator.hello.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.hello.network.HelloModVariables;

public class ClickRewardButtonProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\uBCF4\uC0C1\uC744 \uD68D\uB4DD\uD558\uC600\uC2B5\uB2C8\uB2E4"), false);
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity.getData(HelloModVariables.PLAYER_VARIABLES).MainRewardRequest) {
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.MainRewardRequest = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.MainQuestExist = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.Questgoal1 = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.Questprogress1 = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.my_money = entity.getData(HelloModVariables.PLAYER_VARIABLES).my_money + entity.getData(HelloModVariables.PLAYER_VARIABLES).reward_money1;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.reward_money = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.QuestContents1 = "";
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(HelloModVariables.PLAYER_VARIABLES).SubRewardRequest) {
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.SubRewardRequest = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.SubQuestExist = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.my_money = entity.getData(HelloModVariables.PLAYER_VARIABLES).my_money + entity.getData(HelloModVariables.PLAYER_VARIABLES).reward_money1;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.Questgoal2 = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.reward_money = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.Questprogress2 = 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
				_vars.QuestContents2 = "";
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
