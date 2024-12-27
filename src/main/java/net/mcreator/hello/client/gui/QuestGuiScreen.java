package net.mcreator.hello.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.hello.world.inventory.QuestGuiMenu;
import net.mcreator.hello.procedures.QuestProvider1Procedure;
import net.mcreator.hello.procedures.Quest2Procedure;
import net.mcreator.hello.procedures.Quest1Procedure;
import net.mcreator.hello.procedures.IsQuest2Procedure;
import net.mcreator.hello.procedures.IsQuest1Procedure;
import net.mcreator.hello.procedures.IsComplete2Procedure;
import net.mcreator.hello.procedures.IsComplete1Procedure;
import net.mcreator.hello.procedures.BringRewardProcedure;
import net.mcreator.hello.network.QuestGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class QuestGuiScreen extends AbstractContainerScreen<QuestGuiMenu> {
	private final static HashMap<String, Object> guistate = QuestGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_money_tap;
	ImageButton imagebutton_quest_tap;

	public QuestGuiScreen(QuestGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 143;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("hello:textures/screens/quest_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (QuestProvider1Procedure.execute(world) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 194, this.topPos + 61, 30, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.hello.quest_gui.label_kweseuteu"), 80, 16, -12829636, false);
		if (IsQuest2Procedure.execute(entity))
			guiGraphics.drawString(this.font,

					Quest2Procedure.execute(entity), 20, 91, -12829636, false);
		if (IsComplete1Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.hello.quest_gui.label_wanryo"), 142, 38, -16711936, false);
		if (IsComplete2Procedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.hello.quest_gui.label_wanryo1"), 142, 93, -16711936, false);
		if (IsQuest1Procedure.execute(entity))
			guiGraphics.drawString(this.font,

					Quest1Procedure.execute(entity), 20, 38, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.hello.quest_gui.label_bosang"), 31, 59, -12829636, false);
		guiGraphics.drawString(this.font,

				BringRewardProcedure.execute(entity), 65, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.hello.quest_gui.label_bosang1"), 30, 110, -12829636, false);
		guiGraphics.drawString(this.font,

				BringRewardProcedure.execute(entity), 65, 110, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_money_tap = new ImageButton(this.leftPos + 37, this.topPos + -24, 32, 32, new WidgetSprites(ResourceLocation.parse("hello:textures/screens/money_tap.png"), ResourceLocation.parse("hello:textures/screens/money_tapon.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new QuestGuiButtonMessage(0, x, y, z));
				QuestGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_money_tap", imagebutton_money_tap);
		this.addRenderableWidget(imagebutton_money_tap);
		imagebutton_quest_tap = new ImageButton(this.leftPos + 2, this.topPos + -24, 32, 32, new WidgetSprites(ResourceLocation.parse("hello:textures/screens/quest_tap_on.png"), ResourceLocation.parse("hello:textures/screens/quest_tap_on.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new QuestGuiButtonMessage(1, x, y, z));
						QuestGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_quest_tap", imagebutton_quest_tap);
		this.addRenderableWidget(imagebutton_quest_tap);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
