package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class KillpigProcedure {
public static void execute(
Entity sourceentity ) {
if (
sourceentity == null ) return ;
if (sourceentity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uAFB8\uC6E8\uC5D1"), false);if ((sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).QuestContents1).equals("\uB3FC\uC9C0 \uC138\uB9C8\uB9AC\uB97C \uC8FD\uC5EC\uB77C")) {if (sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questprogress1<sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questgoal1) {{
HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.Questprogress1 = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES).Questprogress1+1;
_vars.syncPlayerVariables(sourceentity);
}
}else{if (sourceentity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8 \uC644\uB8CC"), false);}}
}
}
