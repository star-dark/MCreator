package net.mcreator.hello.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.hello.init.HelloModEntities;
import net.mcreator.hello.entity.KingEntity;

public class QuestProvider1Procedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? new KingEntity(HelloModEntities.KING.get(), _level) : null;
	}
}
