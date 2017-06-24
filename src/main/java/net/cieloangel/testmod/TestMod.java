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


// @Mod marks this class as the main mod class so Forge knows to load from here.
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class TestMod {
	
	// @SidedProxy allows Forge to detect which side our mod is running on and injects the correct
	// proxy into the proxy field
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	// @Instance lets Forge inject the instance of our mod that is used into it.
	// Important especially when working with GUI's
	@Instance
	public static TestMod modInstance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MOD_NAME + " is loading...");
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
