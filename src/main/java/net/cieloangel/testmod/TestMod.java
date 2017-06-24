package net.cieloangel.testmod;

import net.cieloangel.testmod.init.ModBlocks;
import net.cieloangel.testmod.init.ModItems;
import net.cieloangel.testmod.proxy.CommonProxy;
import net.cieloangel.testmod.util.Reference;
import net.cieloangel.testmod.util.TestModTab;
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
	
	public static final TestModTab creativeTab = new TestModTab();
	
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
		ModItems.init();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
	


}
