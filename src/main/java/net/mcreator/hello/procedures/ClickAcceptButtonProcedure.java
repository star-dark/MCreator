package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class ClickAcceptButtonProcedure {
public static void execute(
Entity entity ) {
if (
entity == null ) return ;
if (entity.getData(HelloModVariables.PLAYER_VARIABLES).MainQuestRequest==true) {if (entity.getData(HelloModVariables.PLAYER_VARIABLES).MainQuestExist==false) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8\uB97C \uC218\uB77D\uD588\uC2B5\uB2C8\uB2E4!"), false);if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(entity.getData(HelloModVariables.PLAYER_VARIABLES).quest_Contents), false);{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.QuestContents1 = entity.getData(HelloModVariables.PLAYER_VARIABLES).quest_Contents;
_vars.syncPlayerVariables(entity);
}
{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.MainQuestExist = true;
_vars.syncPlayerVariables(entity);
}{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.Questprogress1 = 0;
_vars.syncPlayerVariables(entity);
}
{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.reward_money1 = entity.getData(HelloModVariables.PLAYER_VARIABLES).reward_money;
_vars.syncPlayerVariables(entity);
}
if(entity instanceof Player _player) _player.closeContainer();}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8\uB97C \uB354\uC774\uC0C1 \uBC1B\uC744 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4."), false);}{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.MainQuestRequest = false;
_vars.syncPlayerVariables(entity);
}
}else if (entity.getData(HelloModVariables.PLAYER_VARIABLES).SubQuestRequest==true) {if (entity.getData(HelloModVariables.PLAYER_VARIABLES).SubQuestExist==false) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8\uB97C \uC218\uB77D\uD588\uC2B5\uB2C8\uB2E4!"), false);if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal(entity.getData(HelloModVariables.PLAYER_VARIABLES).quest_Contents), false);{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.Questprogress2 = 0;
_vars.syncPlayerVariables(entity);
}
{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.QuestContents2 = entity.getData(HelloModVariables.PLAYER_VARIABLES).quest_Contents;
_vars.syncPlayerVariables(entity);
}
{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.SubQuestExist = true;
_vars.syncPlayerVariables(entity);
}{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.reward_money2 = entity.getData(HelloModVariables.PLAYER_VARIABLES).reward_money;
_vars.syncPlayerVariables(entity);
}
if(entity instanceof Player _player) _player.closeContainer();}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\uD018\uC2A4\uD2B8\uB97C \uB354\uC774\uC0C1 \uBC1B\uC744 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4."), false);}{
HelloModVariables.PlayerVariables _vars = entity.getData(HelloModVariables.PLAYER_VARIABLES);
_vars.SubQuestRequest = false;
_vars.syncPlayerVariables(entity);
}
}
}
}
