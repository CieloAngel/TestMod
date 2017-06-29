package net.cieloangel.testmod;

import java.io.File;

import net.cieloangel.testmod.commands.TeleportCommand;
import net.cieloangel.testmod.init.ModBlocks;
import net.cieloangel.testmod.init.ModDimensions;
import net.cieloangel.testmod.init.ModEntities;
import net.cieloangel.testmod.init.ModItems;
import net.cieloangel.testmod.proxy.CommonProxy;
import net.cieloangel.testmod.util.ConfigHandler;
import net.cieloangel.testmod.util.Reference;
import net.cieloangel.testmod.util.TestModTab;
import net.cieloangel.testmod.world.ModOverworldGen;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


// @Mod marks this class as the main mod class so Forge knows to load from here.
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class TestMod {
	
	public static final Item.ToolMaterial lepruneseToolMaterial = EnumHelper.addToolMaterial("LEPRUNESE", 2, 500, 6, 2, 14);	
	public static final TestModTab creativeTab = new TestModTab();
	public static Configuration config;
	
	// @SidedProxy allows Forge to detect which side our mod is running on and injects the correct
	// proxy into the proxy field
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	// @Instance lets Forge inject the instance of our mod that is used into it.
	// Important especially when working with GUI's
	@Mod.Instance
	public static TestMod modInstance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		System.out.println(Reference.MOD_NAME + " is loading...");
		
		ModBlocks.init();
		ModItems.init();
		ModEntities.init();
		
		// The int is the weight of this mod's generator. If issues arise with other
		// mods interfering with world gen, make this higher
		GameRegistry.registerWorldGenerator(new ModOverworldGen(), 3);
		
		// Load configuration file
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "testmod.cfg"));
		ConfigHandler.readConfig();
		ModDimensions.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		event.registerServerCommand(new TeleportCommand());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ConfigHandler.saveConfig();
	}
}
