
package net.mcreator.hello.entity;

import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;




public class QueenEntity extends Monster  {





	public QueenEntity(EntityType<QueenEntity> type, Level world) {
    	super(type, world);
		xpReward = 0;
		setNoAi(true);





	}






	@Override public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}





	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}




























	public static void init(RegisterSpawnPlacementsEvent event) {
			event.register(HelloModEntities.QUEEN.get(),
					SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
						(entityType, world, reason, pos, random) ->
								(world.getDifficulty() != Difficulty.PEACEFUL &&
								Monster.isDarkEnoughToSpawn(world, pos, random) &&
								Mob.checkMobSpawnRules(entityType, world, reason, pos, random))
					,
					RegisterSpawnPlacementsEvent.Operation.REPLACE
			);
	}


	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);






		return builder;
	}

}
