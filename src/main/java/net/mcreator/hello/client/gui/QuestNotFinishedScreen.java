package net.mcreator.hello.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.hello.world.inventory.QuestNotFinishedMenu;
import net.mcreator.hello.procedures.BringRewardProcedure;
import net.mcreator.hello.procedures.BringQuestProcedure;
import net.mcreator.hello.network.QuestNotFinishedButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuestNotFinishedScreen extends AbstractContainerScreen<QuestNotFinishedMenu> {
	private final static HashMap<String, Object> guistate = QuestNotFinishedMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_geojeol;

	public QuestNotFinishedScreen(QuestNotFinishedMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 122;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("hello:textures/screens/quest_not_finished.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("hello:textures/screens/bang.png"), this.leftPos + 16, this.topPos + 22, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				BringQuestProcedure.execute(entity), 52, 27, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.hello.quest_not_finished.label_bosang"), 43, 53, -12829636, false);
		guiGraphics.drawString(this.font,

				BringRewardProcedure.execute(entity), 70, 53, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_geojeol = Button.builder(Component.translatable("gui.hello.quest_not_finished.button_geojeol"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new QuestNotFinishedButtonMessage(0, x, y, z));
				QuestNotFinishedButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 37, this.topPos + 86, 100, 20).build();
		guistate.put("button:button_geojeol", button_geojeol);
		this.addRenderableWidget(button_geojeol);
	}
}
