package net.mcreator.hello.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;

public class BringQuestProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		Entity current_entity = null;
		return entity.getData(HelloModVariables.PLAYER_VARIABLES).quest_Contents;
	}
}
