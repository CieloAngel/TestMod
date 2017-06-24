package net.cieloangel.testmod;

import net.cieloangel.testmod.init.ModBlocks;
import net.cieloangel.testmod.proxy.CommonProxy;
import net.cieloangel.testmod.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class TestMod {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@Instance
	public static TestMod modInstance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.init();
		ModBlocks.register();
		
		//TutorialBiomeRegistry.MainRegistry();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.registerRenders();
		
		//GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 0);
		//GameRegistry.registerWorldGenerator(new TutorialStructureGenerator(), 0);
		//TutorialDimensionRegistry.MainRegistry();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//WorldType TUTORIAL = new WorldTypeTutorials("tutorial");
		//WorldType TUTORIALS = new WorldTypeTutorials("tutorials");
	}
	
//	@EventHandler
//	public void serverLoad(FMLServerStartingEvent event) {
//		event.registerServerCommand(new CommandDimensionTp());
//	}

}
