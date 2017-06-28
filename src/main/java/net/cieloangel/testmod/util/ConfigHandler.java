package net.cieloangel.testmod.util;

import net.cieloangel.testmod.TestMod;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	// Config file(s)
	private static Configuration config;
	
	// Config categories
	private static final String CATEGORY_GENERAL = "general";
	private static final String CATEGORY_DIMENSIONS = "dimensions";
	
	// Config values
	public static boolean exampleBoolean = true;
	public static String exampleString = "An example string";
	public static int dimensionId = 100;
	public static int tutorialIslandBiomeId;
	public static int tutorialBiomeId;
	
	public static void readConfig() {
		
		// Create the Configuration object
		config = TestMod.config;
		
		// Load config file if one exists
		try
		{
			config.load();
			initGeneralConfig(config);
			initDimensionConfig(config);	
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			// Save the config file
			saveConfig();
		}
	}
	
	private static void initGeneralConfig(Configuration config) {
		config.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
		
		exampleBoolean = config.getBoolean("exampleBool", CATEGORY_GENERAL, exampleBoolean, "Change this if you want");
		exampleString = config.getString("exampleString", CATEGORY_GENERAL, exampleString, "Change this string if you want");
	}
	
	private static void initDimensionConfig(Configuration config) {
		config.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension Configuration");
		
		dimensionId = config.getInt("dimensionId", CATEGORY_DIMENSIONS, dimensionId, -1000, 1000, "Change the dimension id if it interferes with other mods");
	}
	
	public static void saveConfig() {
		if (config.hasChanged()) {
			config.save();
		}
	}

}
