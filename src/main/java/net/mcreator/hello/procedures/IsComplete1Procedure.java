package net.mcreator.hello.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;

public class IsComplete1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getData(HelloModVariables.PLAYER_VARIABLES).MainQuestExist && entity.getData(HelloModVariables.PLAYER_VARIABLES).Questgoal1 == entity.getData(HelloModVariables.PLAYER_VARIABLES).Questprogress1;
	}
}
