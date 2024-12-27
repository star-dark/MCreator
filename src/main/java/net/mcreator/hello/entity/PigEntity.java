
package net.mcreator.hello.entity;

import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;




public class PigEntity extends Monster  {





	public PigEntity(EntityType<PigEntity> type, Level world) {
    	super(type, world);
		xpReward = 0;
		setNoAi(false);

        	setCustomName(Component.literal("돼지"));
        	setCustomNameVisible(true);




	}




	@Override protected void registerGoals() {
		super.registerGoals();


			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {

	@Override protected boolean canPerformAttack(LivingEntity entity) {
		return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth())
			&& this.mob.getSensing().hasLineOfSight(entity);
	}


});this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));this.targetSelector.addGoal(3, new HurtByTargetGoal(this)
		);this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));this.goalSelector.addGoal(5, new FloatGoal(this));

	}





	@Override public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pig.ambient"));
	}


	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}







	@Override public void die(DamageSource source) {
		super.die(source);
    KillpigProcedure.execute(source.getEntity());
	}





















	public static void init(RegisterSpawnPlacementsEvent event) {
			event.register(HelloModEntities.PIG.get(),
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
