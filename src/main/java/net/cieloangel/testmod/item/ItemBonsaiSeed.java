package net.cieloangel.testmod.item;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.init.ModBlocks;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class ItemBonsaiSeed extends ItemSeeds implements ItemModelProvider {
	
	public ItemBonsaiSeed() {
		
		super(ModBlocks.cropBonsai, Blocks.FARMLAND);
		setUnlocalizedName("item_crop_bonsai_seed");
		setRegistryName("item_crop_bonsai_seed");
	}
	
	@Override
	public void registerItemModel(Item item) {
		
		TestMod.proxy.registerItemRenderer(item, 0, "item_crop_bonsai_seed");
	}

}
