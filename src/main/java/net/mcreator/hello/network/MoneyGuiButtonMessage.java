
package net.mcreator.hello.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.hello.world.inventory.MoneyGuiMenu;
import net.mcreator.hello.procedures.OpenQuestGUIPressedProcedure;
import net.mcreator.hello.procedures.OpenMoneyGUIPressedProcedure;
import net.mcreator.hello.procedures.GetOchunwonFromUserProcedure;
import net.mcreator.hello.procedures.GetManwonFromUserProcedure;
import net.mcreator.hello.procedures.GetChunwonFromUserProcedure;
import net.mcreator.hello.HelloMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record MoneyGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<MoneyGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(HelloMod.MODID, "money_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MoneyGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, MoneyGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new MoneyGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<MoneyGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final MoneyGuiButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = MoneyGuiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GetManwonFromUserProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GetOchunwonFromUserProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GetChunwonFromUserProcedure.execute(entity);
		}
		if (buttonID == 3) {

			OpenMoneyGUIPressedProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenQuestGUIPressedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		HelloMod.addNetworkMessage(MoneyGuiButtonMessage.TYPE, MoneyGuiButtonMessage.STREAM_CODEC, MoneyGuiButtonMessage::handleData);
	}
}
