package net.mcreator.hello.client.gui;


public class QuestFinishedScreen extends AbstractContainerScreen<QuestFinishedMenu> {

	private final static HashMap<String, Object> guistate = QuestFinishedMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;



	Button button_bosanghoegdeug;


	public QuestFinishedScreen(QuestFinishedMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 122;
	}


	private static final ResourceLocation texture = ResourceLocation.parse("hello:textures/screens/quest_finished.png");

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

			
				guiGraphics.blit(ResourceLocation.parse("hello:textures/screens/question.png"),
					this.leftPos + 22, this.topPos + 26, 0, 0,
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
				Component.translatable("gui.hello.quest_finished.label_bosang"),
				44, 55, -12829636, false);
			guiGraphics.drawString(this.font,
				

    BringRewardProcedure.execute(entity)
,
				70, 55, -12829636, false);
	}

	@Override public void init() {
		super.init();



				button_bosanghoegdeug = Button.builder(Component.translatable("gui.hello.quest_finished.button_bosanghoegdeug"), e -> {
		if (        true
) {
			PacketDistributor.sendToServer(new QuestFinishedButtonMessage(0, x, y, z));
			QuestFinishedButtonMessage.handleButtonAction(entity, 0, x, y, z);
		}
}
)
					.bounds(this.leftPos + 43, this.topPos + 82,
					86, 20)
						.build();

			guistate.put("button:button_bosanghoegdeug", button_bosanghoegdeug);
			this.addRenderableWidget(button_bosanghoegdeug);



	}


}

