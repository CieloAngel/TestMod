package net.cieloangel.testmod.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static void init(File configFile) {
		
		// Create the Configuration object
		Configuration config = new Configuration(configFile);
		boolean configValue = false;
		
		// Load config file if one exists
		try
		{
			config.load();
			
			// Load properties from config file
			// Can change Configuration.CATEGORY_GENERAL to a String for your own custom category
			configValue = config.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value").getBoolean(true);
		}
		catch (Exception e)
		{
			
		}
		finally
		{
			// Save the config file
			config.save();
		}
		
		System.out.println(configValue);
		
	}

}
