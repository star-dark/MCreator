
package net.mcreator.hello.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.hello.procedures.KingRightClickedOnEntityProcedure;

public class KingEntity extends PathfinderMob {
	public static final EntityDataAccessor<Integer> DATA_quest_state = SynchedEntityData.defineId(KingEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<String> DATA_king_quest1 = SynchedEntityData.defineId(KingEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_king_quest1_goal = SynchedEntityData.defineId(KingEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_reward_money = SynchedEntityData.defineId(KingEntity.class, EntityDataSerializers.INT);

	public KingEntity(EntityType<KingEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(true);
		setCustomName(Component.literal("king"));
		setCustomNameVisible(true);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_quest_state, 0);
		builder.define(DATA_king_quest1, "돼지 세마리를 죽여라");
		builder.define(DATA_king_quest1_goal, 3);
		builder.define(DATA_reward_money, 2000);
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Dataquest_state", this.entityData.get(DATA_quest_state));
		compound.putString("Dataking_quest1", this.entityData.get(DATA_king_quest1));
		compound.putInt("Dataking_quest1_goal", this.entityData.get(DATA_king_quest1_goal));
		compound.putInt("Datareward_money", this.entityData.get(DATA_reward_money));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Dataquest_state"))
			this.entityData.set(DATA_quest_state, compound.getInt("Dataquest_state"));
		if (compound.contains("Dataking_quest1"))
			this.entityData.set(DATA_king_quest1, compound.getString("Dataking_quest1"));
		if (compound.contains("Dataking_quest1_goal"))
			this.entityData.set(DATA_king_quest1_goal, compound.getInt("Dataking_quest1_goal"));
		if (compound.contains("Datareward_money"))
			this.entityData.set(DATA_reward_money, compound.getInt("Datareward_money"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		KingRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
		return retval;
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 1);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 1);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}
