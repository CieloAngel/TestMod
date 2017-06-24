package net.cieloangel.testmod.util;

import net.cieloangel.testmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TestModTab  extends CreativeTabs {
	
	public TestModTab() {
		super(Reference.MOD_ID);
	}
	
	@Override
	public Item getTabIconItem() {
		return ModItems.tempItem;
	}

}
