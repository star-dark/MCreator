package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class GetChunwonFromUserProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(HelloModVariables.PLAYER_VARIABLES).my_money>1000) {if (entity instanceof Player _player) {
ItemStack _setstack = new ItemStack(HelloModItems.CHUNWON.get()).copy();
_setstack.setCount(1);
ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
}{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.my_money = entity.getData(HelloModVariables.PLAYER_VARIABLES).my_money-1000;
_vars.syncPlayerVariables(entity);
}
}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uB3C8\uC774 \uBD80\uC871\uD569\uB2C8\uB2E4..."), false);}
}
}
