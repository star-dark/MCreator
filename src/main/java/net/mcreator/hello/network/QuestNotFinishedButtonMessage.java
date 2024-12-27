
package net.mcreator.hello.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD) public record QuestNotFinishedButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<QuestNotFinishedButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(HelloMod.MODID, "quest_not_finished_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, QuestNotFinishedButtonMessage> STREAM_CODEC = StreamCodec.of(
			(RegistryFriendlyByteBuf buffer, QuestNotFinishedButtonMessage message) -> {
				buffer.writeInt(message.buttonID);
				buffer.writeInt(message.x);
				buffer.writeInt(message.y);
				buffer.writeInt(message.z);
			},
			(RegistryFriendlyByteBuf buffer) -> new QuestNotFinishedButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt())
	);

	@Override public Type<QuestNotFinishedButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final QuestNotFinishedButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = QuestNotFinishedMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

					if (buttonID == 0) {
    

    ClickCancelButtonProcedure.execute(entity)
;
					}
	}

	@SubscribeEvent public static void registerMessage(FMLCommonSetupEvent event) {
		HelloMod.addNetworkMessage(QuestNotFinishedButtonMessage.TYPE, QuestNotFinishedButtonMessage.STREAM_CODEC, QuestNotFinishedButtonMessage::handleData);
	}

}
