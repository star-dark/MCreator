package net.mcreator.hello.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.hello.network.HelloModVariables;
import net.mcreator.hello.entity.FisherJobNpcEntity;

public class FisherTalkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			HelloModVariables.PlayerVariables _vars = sourceentity.getData(HelloModVariables.PLAYER_VARIABLES);
			_vars.talk_with = entity instanceof FisherJobNpcEntity _datEntS ? _datEntS.getEntityData().get(FisherJobNpcEntity.DATA_Job) : "";
			_vars.syncPlayerVariables(sourceentity);
		}
		JobNpcClickProcedure.execute(world, x, y, z, sourceentity);
	}
}
