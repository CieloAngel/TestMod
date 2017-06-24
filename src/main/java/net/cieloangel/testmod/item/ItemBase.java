package net.cieloangel.testmod.item;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.util.IModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IModelProvider {
	
	protected String name;
	
	/**
	 * 
	 * @param name
	 */
	public ItemBase(String name) {
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TestMod.creativeTab);
	}
	
	/**
	 * 
	 */
	@Override
	public void registerItemModel(Item item) {
		TestMod.proxy.registerItemRenderer(item, 0, name);
	}
	
	/**
	 * Override setCreativeTab to return ItemBase instead of Item
	 */
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		
		super.setCreativeTab(tab);
		return this;
	}

}
