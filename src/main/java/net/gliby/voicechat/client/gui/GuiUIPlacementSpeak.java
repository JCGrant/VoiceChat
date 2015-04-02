package net.gliby.voicechat.client.gui;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.gliby.voicechat.client.textures.IndependentGUITexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EnumPlayerModelParts;

import org.lwjgl.opengl.GL11;

public class GuiUIPlacementSpeak extends GuiPlaceableInterface {

	public GuiUIPlacementSpeak(UIPosition position, int width, int height) {
		super(position, width, height);
		this.width = 56;
		this.height = 52;
	}

	@Override
	public void draw(Minecraft mc, GuiScreen gui, int x, int y, float tick) {
		glEnable(GL11.GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glColor4f(1.0F, 1.0F, 1.0F, 1.0f);
		glScalef(scale, scale, 1.0f);
		glTranslatef(1, 3, 0);
		IndependentGUITexture.TEXTURES.bindTexture(mc);
		gui.drawTexturedModalRect(0, 0, 0, 0, 54, 46);
		switch ((int) ((Minecraft.getSystemTime() % 1000L) / 350.0F)) {
		case 0:
			gui.drawTexturedModalRect(12, -3, 0, 47, 22, 49);
			break;
		case 1:
			gui.drawTexturedModalRect(23 + 8, -3, 23, 47, 14, 49);
			break;
		case 2:
			gui.drawTexturedModalRect(38 + 2, -3, 38, 47, 16, 49);
			break;
		}
		mc.getTextureManager().bindTexture(mc.thePlayer.getLocationSkin());
		glTranslatef(0, 14, 0);
		glScalef(2.40f, 2.40f,0);
		Gui.drawScaledCustomSizeModalRect(0, 0, 8.0F, 8.0F, 8, 8, 8, 8, 64.0F, 64.0F);
		if (mc.thePlayer != null && mc.thePlayer .func_175148_a(EnumPlayerModelParts.HAT))
		{
			Gui.drawScaledCustomSizeModalRect(0, 0, 40.0F, 8.0F, 8, 8, 8, 8, 64.0F, 64.0F);
		}
	}
}
