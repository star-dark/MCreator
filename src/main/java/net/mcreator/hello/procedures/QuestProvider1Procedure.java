package net.mcreator.hello.procedures;

import net.neoforged.bus.api.Event;


public class QuestProvider1Procedure {
public static Entity execute(
LevelAccessor world ) {
return
world instanceof Level _level ? new KingEntity(HelloModEntities.KING.get(), _level) : null;
}
}
