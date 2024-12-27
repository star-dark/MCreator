package net.mcreator.hello.network;

import net.mcreator.hello.HelloMod;

import net.minecraft.nbt.Tag;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD) public class HelloModVariables {

	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, HelloMod.MODID);

	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());


	@SubscribeEvent public static void init(FMLCommonSetupEvent event) {
			HelloMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);

			HelloMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber public static class EventBusVariableHandlers {

		@SubscribeEvent public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
				clone.quest_Contents = original.quest_Contents;
				clone.QuestContents1 = original.QuestContents1;
				clone.QuestContents2 = original.QuestContents2;
				clone.Questgoal1 = original.Questgoal1;
				clone.Questprogress1 = original.Questprogress1;
				clone.Questgoal2 = original.Questgoal2;
				clone.Questprogress2 = original.Questprogress2;
				clone.MainQuestExist = original.MainQuestExist;
				clone.SubQuestExist = original.SubQuestExist;
				clone.my_money = original.my_money;
				clone.reward_money2 = original.reward_money2;
				clone.reward_money1 = original.reward_money1;
			if(!event.isWasDeath()) {
					clone.MainQuestRequest = original.MainQuestRequest;
					clone.SubQuestRequest = original.SubQuestRequest;
					clone.MainRewardRequest = original.MainRewardRequest;
					clone.SubRewardRequest = original.SubRewardRequest;
					clone.reward_money = original.reward_money;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}

		@SubscribeEvent public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if(mapdata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
				if(worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if(worlddata != null)
					PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {

		public static final String DATA_NAME = "hello_worldvars";


		public static WorldVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			WorldVariables data = new WorldVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		@Override public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();

			if (world instanceof ServerLevel level)
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(new SavedData.Factory<>(WorldVariables::new, WorldVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}

	}

	public static class MapVariables extends SavedData {

		public static final String DATA_NAME = "hello_mapvars";

public ItemStack reward_man = ItemStack.EMPTY;public ItemStack reward_ochun = ItemStack.EMPTY;public ItemStack reward_chun = ItemStack.EMPTY;
		public static MapVariables load(CompoundTag tag, HolderLookup.Provider lookupProvider) {
			MapVariables data = new MapVariables();
			data.read(tag, lookupProvider);
			return data;
		}

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
reward_man = ItemStack.parseOptional(lookupProvider, nbt.getCompound("reward_man"));reward_ochun = ItemStack.parseOptional(lookupProvider, nbt.getCompound("reward_ochun"));reward_chun = ItemStack.parseOptional(lookupProvider, nbt.getCompound("reward_chun"));		}

		@Override public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
nbt.put("reward_man", reward_man.saveOptional(lookupProvider));nbt.put("reward_ochun", reward_ochun.saveOptional(lookupProvider));nbt.put("reward_chun", reward_chun.saveOptional(lookupProvider));			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();

			if (world instanceof Level && !world.isClientSide())
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage()
						.computeIfAbsent(new SavedData.Factory<>(MapVariables::new, MapVariables::load), DATA_NAME);
			} else {
				return clientSide;
			}
		}

	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {

		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(HelloMod.MODID, "saved_data_sync"));

		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of(
			(RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
				buffer.writeInt(message.dataType);
				if (message.data != null)
					buffer.writeNbt(message.data.save(new CompoundTag(), buffer.registryAccess()));
			},
			(RegistryFriendlyByteBuf buffer) -> {
				int dataType = buffer.readInt();
				CompoundTag nbt = buffer.readNbt();
				SavedData data = null;
				if (nbt != null) {
					data = dataType == 0 ? new MapVariables() : new WorldVariables();
					if(data instanceof MapVariables mapVariables)
						mapVariables.read(nbt, buffer.registryAccess());
					else if(data instanceof WorldVariables worldVariables)
						worldVariables.read(nbt, buffer.registryAccess());
				}
				return new SavedDataSyncMessage(dataType, data);
			}
		);

		@Override public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(message.data.save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {

public String quest_Contents = "\"\"";public String QuestContents1 = "";public String QuestContents2 = "";public double Questgoal1 = 0;public double Questprogress1 = 0;public double Questgoal2 = 0;public double Questprogress2 = 0;public boolean MainQuestExist = false;public boolean SubQuestExist = false;public boolean MainQuestRequest = false;public boolean SubQuestRequest = false;public boolean MainRewardRequest = false;public boolean SubRewardRequest = false;public double my_money = 0.0;public double reward_money = 0;public double reward_money2 = 0;public double reward_money1 = 0;
		@Override public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
nbt.putString("quest_Contents", quest_Contents);nbt.putString("QuestContents1", QuestContents1);nbt.putString("QuestContents2", QuestContents2);nbt.putDouble("Questgoal1", Questgoal1);nbt.putDouble("Questprogress1", Questprogress1);nbt.putDouble("Questgoal2", Questgoal2);nbt.putDouble("Questprogress2", Questprogress2);nbt.putBoolean("MainQuestExist", MainQuestExist);nbt.putBoolean("SubQuestExist", SubQuestExist);nbt.putBoolean("MainQuestRequest", MainQuestRequest);nbt.putBoolean("SubQuestRequest", SubQuestRequest);nbt.putBoolean("MainRewardRequest", MainRewardRequest);nbt.putBoolean("SubRewardRequest", SubRewardRequest);nbt.putDouble("my_money", my_money);nbt.putDouble("reward_money", reward_money);nbt.putDouble("reward_money2", reward_money2);nbt.putDouble("reward_money1", reward_money1);			return nbt;
		}

		@Override public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
quest_Contents = nbt.getString("quest_Contents");QuestContents1 = nbt.getString("QuestContents1");QuestContents2 = nbt.getString("QuestContents2");Questgoal1 = nbt.getDouble("Questgoal1");Questprogress1 = nbt.getDouble("Questprogress1");Questgoal2 = nbt.getDouble("Questgoal2");Questprogress2 = nbt.getDouble("Questprogress2");MainQuestExist = nbt.getBoolean("MainQuestExist");SubQuestExist = nbt.getBoolean("SubQuestExist");MainQuestRequest = nbt.getBoolean("MainQuestRequest");SubQuestRequest = nbt.getBoolean("SubQuestRequest");MainRewardRequest = nbt.getBoolean("MainRewardRequest");SubRewardRequest = nbt.getBoolean("SubRewardRequest");my_money = nbt.getDouble("my_money");reward_money = nbt.getDouble("reward_money");reward_money2 = nbt.getDouble("reward_money2");reward_money1 = nbt.getDouble("reward_money1");		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}

	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {

		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(HelloMod.MODID, "player_variables_sync"));

		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of(
				(RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) ->
						buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())),
				(RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				}
		);

		@Override public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() ->
					context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))
				).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

	}

}
