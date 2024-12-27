package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class BringRewardProcedure {
public static String execute(
Entity entity ) {
if (
entity == null ) return "";
return
new java.text.DecimalFormat("##").format(entity.getData(HelloModVariables.PLAYER_VARIABLES).reward_money)+"\uC6D0";
}
}
