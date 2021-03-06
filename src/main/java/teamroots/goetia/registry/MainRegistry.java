package teamroots.goetia.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import teamroots.goetia.Goetia;
import teamroots.goetia.client.model.ModelManager;
import teamroots.goetia.common.blocks.BlockAltar;
import teamroots.goetia.common.blocks.BlockBase;
import teamroots.goetia.common.blocks.BlockCandle;
import teamroots.goetia.common.blocks.BlockCandleStand;
import teamroots.goetia.common.entity.EntityBloodProjectile;
import teamroots.goetia.common.entity.EntityDemon;
import teamroots.goetia.common.entity.EntityFiend;
import teamroots.goetia.common.entity.EntityImp;
import teamroots.goetia.common.entity.EntitySymbolDemon;
import teamroots.goetia.common.entity.EntitySymbolDevilsTrap;
import teamroots.goetia.common.entity.EntitySymbolFiend;
import teamroots.goetia.common.entity.EntitySymbolForge;
import teamroots.goetia.common.entity.EntitySymbolImp;
import teamroots.goetia.common.entity.EntitySymbolOpenSoul;
import teamroots.goetia.common.entity.RenderDemon;
import teamroots.goetia.common.entity.RenderFiend;
import teamroots.goetia.common.entity.RenderImp;
import teamroots.goetia.common.entity.RenderSymbolDemon;
import teamroots.goetia.common.entity.RenderSymbolDevilsTrap;
import teamroots.goetia.common.entity.RenderSymbolFiend;
import teamroots.goetia.common.entity.RenderSymbolForge;
import teamroots.goetia.common.entity.RenderSymbolImp;
import teamroots.goetia.common.entity.RenderSymbolOpenSoul;
import teamroots.goetia.common.items.ItemAbyssalBlade;
import teamroots.goetia.common.items.ItemBase;
import teamroots.goetia.common.items.ItemDemonHorn;
import teamroots.goetia.common.items.ItemDemonicChalk;
import teamroots.goetia.common.items.ItemDemonicSpear;
import teamroots.goetia.common.items.ItemNote;
import teamroots.goetia.common.items.ItemSoulFocus;
import teamroots.goetia.common.items.ItemSpellIcon;
import teamroots.goetia.common.items.ItemSwordBase;
import teamroots.goetia.common.items.ItemSymbolIcon;

/**
 * Created by TeamRoots on 4.8.2016.
 */
public class MainRegistry
{
    public static List<ItemBase>ITEMS = new ArrayList<ItemBase>();
    public static List<ItemSwordBase>ITEM_SWORD = new ArrayList<ItemSwordBase>();
    public static List<BlockBase>BLOCKS = new ArrayList<BlockBase>();

    public static BlockBase altar = new BlockAltar("altar",Material.ROCK);
    public static BlockBase demonCandle = new BlockCandle("demonCandle",Material.CLOTH);
    public static BlockBase demonCandleStand = new BlockCandleStand("demonCandleStand",Material.CLOTH);
    
    public static BlockBase angelCandle = new BlockCandle("angelCandle",Material.CLOTH);
    public static BlockBase angelCandleStand = new BlockCandleStand("angelCandleStand",Material.CLOTH);

    public static ItemBase demonHorn = new ItemDemonHorn("demonHorn");
    public static ItemBase impTallow = new ItemBase("impTallow");
    public static ItemBase demonHide = new ItemBase("demonHide");
    public static ItemSwordBase demonHornSpear = new ItemDemonicSpear();
    public static ItemSwordBase abyssalBlade = new ItemAbyssalBlade();
    public static ItemBase soulFocus = new ItemSoulFocus("soulFocus");
    public static ItemBase demonicChalk = new ItemDemonicChalk("demonicChalk");
    public static ItemBase lostNotes = new ItemNote("lostNotes");
    public static ItemBase symbolIcon = new ItemSymbolIcon("symbolIcon");
    public static ItemBase spellIcon = new ItemSpellIcon("spellIcon");
    
    public static void register()
    {
        /**
         * Register items
         */

        /**
         * Register blocks
         */
    	for (ItemBase itemBase : ITEMS){
    		GameRegistry.register(itemBase);
    	}
    	for (ItemSwordBase itemSwordBase : ITEM_SWORD)
        {
            GameRegistry.register(itemSwordBase);
        }
    	
        for (BlockBase blockBase : BLOCKS)
        {
            GameRegistry.register(blockBase);
            GameRegistry.register(new ItemBlock(blockBase).setRegistryName(blockBase.getRegistryName()));
        }

        recipesRegistry();

    }

    private static void recipesRegistry()
    {
    	GameRegistry.addSmelting(new ItemStack(MainRegistry.demonHide,1), new ItemStack(Items.LEATHER,1), 1.0f);
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(demonCandle,4),true,new Object[]{" S ", " T ", 'S', Items.STRING, 'T', MainRegistry.impTallow}));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(demonCandleStand,1),true,new Object[]{" S ", " T ", " T ", 'S', MainRegistry.demonCandle, 'T', "nuggetGold"}));
    	GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(demonicChalk,1),new Object[]{Items.GUNPOWDER,Items.REDSTONE,new ItemStack(Items.DYE,1,1),new ItemStack(Items.COAL,1,1)}));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(altar,1),true,new Object[]{"SCS", "SCS",  'S', "stone", 'C', "blockCoal"}));
    }
    
	public static void registerEntities(){
		EntityRegistry.registerModEntity(EntityImp.class, "imp", 0, Goetia.instance, 64, 3, true);
		EntityRegistry.registerEgg(EntityImp.class, 0x6A1024, 0xA06774);
		EntityRegistry.registerModEntity(EntityFiend.class, "fiend", 1, Goetia.instance, 64, 3, true);
		EntityRegistry.registerEgg(EntityFiend.class, 0x6A1024, 0xA06774);
		EntityRegistry.registerModEntity(EntityDemon.class, "demon", 2, Goetia.instance, 64, 3, true);
		EntityRegistry.registerEgg(EntityDemon.class, 0x6A1024, 0xA06774);
		EntityRegistry.registerModEntity(EntitySymbolImp.class, "symbolImp", 3, Goetia.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySymbolFiend.class, "symbolFiend", 4, Goetia.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySymbolDemon.class, "symbolDemon", 5, Goetia.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySymbolDevilsTrap.class, "symbolDevilsTrap", 6, Goetia.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySymbolForge.class, "symbolForge", 7, Goetia.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntitySymbolOpenSoul.class, "symbolOpenSoul", 8, Goetia.instance, 64, 3, true);
		EntityRegistry.registerModEntity(EntityBloodProjectile.class, "bloodProjectile", 9, Goetia.instance, 64, 3, true);
	}
    
	@SideOnly(Side.CLIENT)
	public static void registerEntityRenderers(){
		RenderingRegistry.registerEntityRenderingHandler(EntityImp.class, new RenderImp(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("imp"),0.3f));
		RenderingRegistry.registerEntityRenderingHandler(EntityFiend.class, new RenderFiend(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("fiend"),0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new RenderDemon(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("demon"),0.8f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySymbolImp.class, new RenderSymbolImp(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("symbol"),0f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySymbolFiend.class, new RenderSymbolFiend(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("symbol"),0f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySymbolDemon.class, new RenderSymbolDemon(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("symbol"),0f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySymbolDevilsTrap.class, new RenderSymbolDevilsTrap(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("symbol"),0f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySymbolForge.class, new RenderSymbolForge(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("symbol"),0f));
		RenderingRegistry.registerEntityRenderingHandler(EntitySymbolOpenSoul.class, new RenderSymbolOpenSoul(Minecraft.getMinecraft().getRenderManager(),ModelManager.entityModels.get("symbol"),0f));
	}

    @SideOnly(Side.CLIENT)
    public static void initTextures()
    {
        //Item textures
        ITEMS.forEach(ItemBase::initModelsAndVariants);
        ITEM_SWORD.forEach(ItemSwordBase::initModelsAndVariants);
        //Block textures
        BLOCKS.forEach(BlockBase::initModels);
    }
}
