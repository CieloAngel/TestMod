package net.cieloangel.testmod.init;

import net.cieloangel.testmod.util.ConfigHandler;
import net.cieloangel.testmod.util.Reference;
import net.cieloangel.testmod.world.TestDimensionProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

	public static DimensionType testDimensionType;

	public static void init() {
		registerDimensionTypes();
	    registerDimensions();
	}

	private static void registerDimensionTypes() {
		testDimensionType = DimensionType.register(Reference.MOD_ID, "_test", ConfigHandler.dimensionId, TestDimensionProvider.class, false);
	}

	    private static void registerDimensions() {
	        DimensionManager.registerDimension(ConfigHandler.dimensionId, testDimensionType);
	}

}
