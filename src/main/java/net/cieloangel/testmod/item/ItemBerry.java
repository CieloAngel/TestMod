package net.cieloangel.testmod.item;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.cieloangel.testmod.util.ItemOreDict;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemBerry extends ItemFood implements ItemModelProvider, ItemOreDict {
	
	public ItemBerry() {
		super(3, 0.6f, false);
		setUnlocalizedName("item_berry");
		setRegistryName("item_berry");
		setCreativeTab(TestMod.creativeTab);
	}
	
	@Override
	public void registerItemModel(Item item) {
		TestMod.proxy.registerItemRenderer(this, 0, "item_berry");
	}
	
	@Override
	public void initOreDict() {
		OreDictionary.registerOre("itemBerry", this);
	}
	
	

}
