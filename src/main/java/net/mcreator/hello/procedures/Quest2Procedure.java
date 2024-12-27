package net.mcreator.hello.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;

public class Quest2Procedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(HelloModVariables.PLAYER_VARIABLES).QuestContents2 + " " + new java.text.DecimalFormat("##.##").format(entity.getData(HelloModVariables.PLAYER_VARIABLES).Questprogress2) + "/"
				+ new java.text.DecimalFormat("##.##").format(entity.getData(HelloModVariables.PLAYER_VARIABLES).Questgoal2);
	}
}
