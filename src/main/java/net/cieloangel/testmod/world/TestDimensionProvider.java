package net.cieloangel.testmod.world;

import net.cieloangel.testmod.init.ModDimensions;
import net.cieloangel.testmod.util.ConfigHandler;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;

public class TestDimensionProvider extends WorldProvider {
	
	@Override
	public DimensionType getDimensionType() {
		return ModDimensions.testDimensionType;
	}
	
	@Override
	public String getSaveFolder() {
		return "TestModDims" + ConfigHandler.dimensionId;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new TestChunkGenerator(worldObj);
	}

}
