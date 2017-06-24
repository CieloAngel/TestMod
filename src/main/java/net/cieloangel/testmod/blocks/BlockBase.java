package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block{
	
	protected String name;
	
	public BlockBase(Material material, String name)
	{
		super(material);
		
		this.name = name;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TestMod.creativeTab);
	}
	
	// Register the block's item model
	public void registerItemModel(ItemBlock itemBlock) {
		TestMod.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
