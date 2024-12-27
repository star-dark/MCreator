package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class GetMoneyProcedure {
public static String execute(
Entity entity ) {
if (
entity == null ) return "";
return
new java.text.DecimalFormat("##").format(entity.getData(HelloModVariables.PLAYER_VARIABLES).my_money);
}
}
