package teamroots.goetia.common.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import teamroots.goetia.common.symbol.SymbolManager;

public class RenderSymbolImp extends RenderLiving<EntitySymbolImp> {

	public RenderSymbolImp(RenderManager renderManager, ModelBase modelBase, float shadowSize) {
		super(renderManager, modelBase, shadowSize);
	}
	
	@Override
	public boolean canRenderName(EntitySymbolImp entity){
		return false;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySymbolImp entity) {
		return SymbolManager.symbolTextures.get(entity.getSymbolName());
	}
}
