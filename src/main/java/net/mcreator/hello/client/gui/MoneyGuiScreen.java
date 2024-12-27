package net.mcreator.hello.client.gui;


public class MoneyGuiScreen extends AbstractContainerScreen<MoneyGuiMenu> {

	private final static HashMap<String, Object> guistate = MoneyGuiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;



	Button button_10000;
	Button button_5000;
	Button button_1000;

	ImageButton imagebutton_money_tap;
	ImageButton imagebutton_quest_tap;

	public MoneyGuiScreen(MoneyGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 143;
	}


	private static final ResourceLocation texture = ResourceLocation.parse("hello:textures/screens/money_gui.png");

	@Override public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);



		this.renderTooltip(guiGraphics, mouseX, mouseY);

	}

	@Override protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

			guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);



		RenderSystem.disableBlend();
	}

	@Override public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}


		return super.keyPressed(key, b, c);
	}


	@Override protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
			guiGraphics.drawString(this.font,
				

    GetMoneyProcedure.execute(entity)
,
				90, 25, -12829636, false);
			guiGraphics.drawString(this.font,
				Component.translatable("gui.hello.money_gui.label_inculganeunggeumaeg"),
				26, 26, -12829636, false);
	}

	@Override public void init() {
		super.init();



				button_10000 = Button.builder(Component.translatable("gui.hello.money_gui.button_10000"), e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new MoneyGuiButtonMessage(0, x, y, z));
			MoneyGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
		}
}
)
					.bounds(this.leftPos + 14, this.topPos + 99,
					38, 20)
						.build();

			guistate.put("button:button_10000", button_10000);
			this.addRenderableWidget(button_10000);

				button_5000 = Button.builder(Component.translatable("gui.hello.money_gui.button_5000"), e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new MoneyGuiButtonMessage(1, x, y, z));
			MoneyGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
		}
}
)
					.bounds(this.leftPos + 70, this.topPos + 99,
					38, 20)
						.build();

			guistate.put("button:button_5000", button_5000);
			this.addRenderableWidget(button_5000);

				button_1000 = Button.builder(Component.translatable("gui.hello.money_gui.button_1000"), e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new MoneyGuiButtonMessage(2, x, y, z));
			MoneyGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
		}
}
)
					.bounds(this.leftPos + 125, this.topPos + 99,
					38, 20)
						.build();

			guistate.put("button:button_1000", button_1000);
			this.addRenderableWidget(button_1000);


			imagebutton_money_tap = new ImageButton(
				this.leftPos + 37, this.topPos + -24,
				32, 32,
				new WidgetSprites(ResourceLocation.parse("hello:textures/screens/money_tapon.png"), ResourceLocation.parse("hello:textures/screens/money_tapon.png")),
e -> {
}
			) {
				@Override public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
				}
			};

			guistate.put("button:imagebutton_money_tap", imagebutton_money_tap);
			this.addRenderableWidget(imagebutton_money_tap);

			imagebutton_quest_tap = new ImageButton(
				this.leftPos + 2, this.topPos + -24,
				32, 32,
				new WidgetSprites(ResourceLocation.parse("hello:textures/screens/quest_tap.png"), ResourceLocation.parse("hello:textures/screens/quest_tap_on.png")),
e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new MoneyGuiButtonMessage(4, x, y, z));
			MoneyGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
		}
}
			) {
				@Override public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
				}
			};

			guistate.put("button:imagebutton_quest_tap", imagebutton_quest_tap);
			this.addRenderableWidget(imagebutton_quest_tap);


	}


}

