package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class EarnMoneyProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.my_money = entity.getData(HelloModVariables.PLAYER_VARIABLES).my_money+1000;
_vars.syncPlayerVariables(entity);
}
}
}
