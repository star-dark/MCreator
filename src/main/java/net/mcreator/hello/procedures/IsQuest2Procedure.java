package net.mcreator.hello.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;

public class IsQuest2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean isQuest = false;
		return entity.getData(HelloModVariables.PLAYER_VARIABLES).SubQuestExist;
	}
}
