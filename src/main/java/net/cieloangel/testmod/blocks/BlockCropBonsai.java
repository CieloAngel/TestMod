package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.init.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropBonsai extends BlockCrops {
	
	public BlockCropBonsai() {
		setUnlocalizedName("block_crop_bonsai");
		setRegistryName("block_crop_bonsai");
		
		setCreativeTab(TestMod.creativeTab);
	}
	
	@Override
	protected Item getSeed() {
		
		return ModItems.itemBonsaiSeed;
	}
	
	@Override
	protected Item getCrop() {
		
		return ModItems.berry;
	}

}
