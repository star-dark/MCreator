package net.mcreator.hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("hello") public class HelloMod {

	public static final Logger LOGGER = LogManager.getLogger(HelloMod.class);

	public static final String MODID = "hello";

	public HelloMod(IEventBus modEventBus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor

		NeoForge.EVENT_BUS.register(this);

		modEventBus.addListener(this::registerNetworking);

		
		
		
		HelloModItems.REGISTRY.register(modEventBus);
		HelloModEntities.REGISTRY.register(modEventBus);
		HelloModTabs.REGISTRY.register(modEventBus);
		HelloModVariables.ATTACHMENT_TYPES.register(modEventBus);
		
		
		
		
		HelloModMenus.REGISTRY.register(modEventBus);
		
		
		

		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods

	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"}) private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}

}
