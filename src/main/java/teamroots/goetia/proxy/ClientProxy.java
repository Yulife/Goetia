package teamroots.goetia.proxy;

import teamroots.goetia.client.model.ModelManager;
import teamroots.goetia.registry.MainRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by TeamRoots on 4.8.2016.
 */
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModelManager.init();
        MainRegistry.initTextures();
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        MainRegistry.registerEntityRenderers();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}