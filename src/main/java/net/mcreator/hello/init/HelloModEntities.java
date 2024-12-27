
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hello.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.hello.entity.QueenEntity;
import net.mcreator.hello.entity.PigEntity;
import net.mcreator.hello.entity.MinerJobNpcEntity;
import net.mcreator.hello.entity.KingEntity;
import net.mcreator.hello.entity.FisherJobNpcEntity;
import net.mcreator.hello.entity.FarmerJobNpcEntity;
import net.mcreator.hello.HelloMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class HelloModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, HelloMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<KingEntity>> KING = register("king",
			EntityType.Builder.<KingEntity>of(KingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PigEntity>> PIG = register("pig", EntityType.Builder.<PigEntity>of(PigEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.9f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<QueenEntity>> QUEEN = register("queen",
			EntityType.Builder.<QueenEntity>of(QueenEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<FarmerJobNpcEntity>> FARMER_JOB_NPC = register("farmer_job_npc",
			EntityType.Builder.<FarmerJobNpcEntity>of(FarmerJobNpcEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<FisherJobNpcEntity>> FISHER_JOB_NPC = register("fisher_job_npc",
			EntityType.Builder.<FisherJobNpcEntity>of(FisherJobNpcEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<MinerJobNpcEntity>> MINER_JOB_NPC = register("miner_job_npc",
			EntityType.Builder.<MinerJobNpcEntity>of(MinerJobNpcEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.95f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		KingEntity.init(event);
		PigEntity.init(event);
		QueenEntity.init(event);
		FarmerJobNpcEntity.init(event);
		FisherJobNpcEntity.init(event);
		MinerJobNpcEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(KING.get(), KingEntity.createAttributes().build());
		event.put(PIG.get(), PigEntity.createAttributes().build());
		event.put(QUEEN.get(), QueenEntity.createAttributes().build());
		event.put(FARMER_JOB_NPC.get(), FarmerJobNpcEntity.createAttributes().build());
		event.put(FISHER_JOB_NPC.get(), FisherJobNpcEntity.createAttributes().build());
		event.put(MINER_JOB_NPC.get(), MinerJobNpcEntity.createAttributes().build());
	}
}
