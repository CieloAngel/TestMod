package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBase extends Block implements ItemModelProvider {

	protected String name;

	/**
	 * Convenience constructor that sets both the localized and registry names
	 * 
	 * @param material
	 * @param name
	 */
	public BlockBase(Material material, String name) {
		super(material);

		this.name = name;

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TestMod.creativeTab);
	}

	// Register the block's item model
	@Override
	public void registerItemModel(Item item) {
		TestMod.proxy.registerItemRenderer(item, 0, name);
	}

	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
