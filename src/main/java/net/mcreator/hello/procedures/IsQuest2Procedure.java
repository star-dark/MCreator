package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class IsQuest2Procedure {
public static boolean execute(
Entity entity ) {
if (
entity == null ) return false;
boolean isQuest = false;
return
entity.getData(HelloModVariables.PLAYER_VARIABLES).SubQuestExist;
}
}
