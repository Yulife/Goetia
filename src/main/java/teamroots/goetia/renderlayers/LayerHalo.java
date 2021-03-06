package teamroots.goetia.renderlayers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import teamroots.goetia.capability.impurity.GoetiaProvider;
import teamroots.goetia.client.model.ModelHalo;
import teamroots.goetia.client.model.ModelHorns;
import teamroots.goetia.spellcasting.AlignmentType;

public class LayerHalo implements LayerRenderer{
	ModelHalo horns = new ModelHalo();

	@Override
	public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		EntityPlayer player = (EntityPlayer)entity;
		if(GoetiaProvider.get(player).getAlignment() == AlignmentType.ANGEL){
			GlStateManager.pushMatrix();
			GlStateManager.color(1, 1, 1, 1);
			Minecraft.getMinecraft().renderEngine.bindTexture(	new ResourceLocation("goetia:textures/blocks/wood.png"));
			
			
			GlStateManager.rotate(netHeadYaw, 0F, 1F, 0F);
			GlStateManager.rotate(headPitch, 1F, 0F, 0F);
			GlStateManager.translate(0F, -2F, 0F);
			
			horns.render(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, scale);
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

}
