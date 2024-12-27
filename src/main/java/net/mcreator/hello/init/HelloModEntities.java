
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */

package net.mcreator.hello.init;


@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class HelloModEntities {

	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, HelloMod.MODID);

			public static final DeferredHolder<EntityType<?>, EntityType<KingEntity>> KING =
				register("king", EntityType.Builder.<KingEntity>
						of(KingEntity::new, MobCategory.MONSTER)
							.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
							
							.sized(0.6f, 1.8f)
						);
			public static final DeferredHolder<EntityType<?>, EntityType<PigEntity>> PIG =
				register("pig", EntityType.Builder.<PigEntity>
						of(PigEntity::new, MobCategory.MONSTER)
							.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
							
							.sized(0.9f, 0.9f)
						);
			public static final DeferredHolder<EntityType<?>, EntityType<QueenEntity>> QUEEN =
				register("queen", EntityType.Builder.<QueenEntity>
						of(QueenEntity::new, MobCategory.MONSTER)
							.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
							
							.sized(0.6f, 1.8f)
						);

	// Start of user code block custom entities
	// End of user code block custom entities

	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}


	@SubscribeEvent public static void init(RegisterSpawnPlacementsEvent event) {
				KingEntity.init(event);
				PigEntity.init(event);
				QueenEntity.init(event);
	}

	@SubscribeEvent public static void registerAttributes(EntityAttributeCreationEvent event) {
				event.put(KING.get(), KingEntity.createAttributes().build());
				event.put(PIG.get(), PigEntity.createAttributes().build());
				event.put(QUEEN.get(), QueenEntity.createAttributes().build());
	}

}
