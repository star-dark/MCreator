package net.mcreator.hello.client.gui;


public class QuestProvideGUIScreen extends AbstractContainerScreen<QuestProvideGUIMenu> {

	private final static HashMap<String, Object> guistate = QuestProvideGUIMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;



	Button button_surag;
	Button button_geojeol;


	public QuestProvideGUIScreen(QuestProvideGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 122;
	}


	private static final ResourceLocation texture = ResourceLocation.parse("hello:textures/screens/quest_provide_gui.png");

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

			
				guiGraphics.blit(ResourceLocation.parse("hello:textures/screens/bang.png"),
					this.leftPos + 16, this.topPos + 22, 0, 0,
					16, 16,
					16, 16);
			


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
				

    BringQuestProcedure.execute(entity)
,
				52, 27, -12829636, false);
			guiGraphics.drawString(this.font,
				Component.translatable("gui.hello.quest_provide_gui.label_bosang"),
				41, 53, -12829636, false);
			guiGraphics.drawString(this.font,
				

    BringRewardProcedure.execute(entity)
,
				69, 52, -12829636, false);
	}

	@Override public void init() {
		super.init();



				button_surag = Button.builder(Component.translatable("gui.hello.quest_provide_gui.button_surag"), e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new QuestProvideGUIButtonMessage(0, x, y, z));
			QuestProvideGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
		}
}
)
					.bounds(this.leftPos + 23, this.topPos + 80,
					59, 20)
						.build();

			guistate.put("button:button_surag", button_surag);
			this.addRenderableWidget(button_surag);

				button_geojeol = Button.builder(Component.translatable("gui.hello.quest_provide_gui.button_geojeol"), e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new QuestProvideGUIButtonMessage(1, x, y, z));
			QuestProvideGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
		}
}
)
					.bounds(this.leftPos + 100, this.topPos + 80,
					57, 20)
						.build();

			guistate.put("button:button_geojeol", button_geojeol);
			this.addRenderableWidget(button_geojeol);



	}


}

