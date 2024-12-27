
package net.mcreator.hello.client.screens;


@EventBusSubscriber({Dist.CLIENT}) public class MoneyOverlay {

	@SubscribeEvent(priority = EventPriority.NORMAL)
        public static void eventHandler(RenderGuiEvent.Pre event) {
            int w = event.getGuiGraphics().guiWidth();
            int h = event.getGuiGraphics().guiHeight();

        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;

        Player entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }

            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderSystem.setShaderColor(1, 1, 1, 1);

        if (        true
) {

                    event.getGuiGraphics().blit(ResourceLocation.parse("hello:textures/screens/money2.png"), 		0, 0
, 0, 0,
                        32, 32,
                        32, 32);
                


                event.getGuiGraphics().drawString(Minecraft.getInstance().font,
                    

    GetMoneyProcedure.execute(entity)
,
                    		32, 10
, -13421773, false);

        }

            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            RenderSystem.disableBlend();
            RenderSystem.setShaderColor(1, 1, 1, 1);
	}


}

