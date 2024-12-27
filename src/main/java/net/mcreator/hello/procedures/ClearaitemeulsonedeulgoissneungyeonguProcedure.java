package net.mcreator.hello.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;

public class ClearaitemeulsonedeulgoissneungyeonguProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.quest_Contents = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.QuestContents1 = "";
			_vars.syncPlayerVariables(entity);
		}
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.QuestContents2 = "";
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
			_vars.Questgoal2 = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.Questprogress2 = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}
