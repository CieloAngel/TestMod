package net.cieloangel.testmod.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStone extends BlockBase {
	
	// Constructor
	public BlockStone(String name) {
		
		super(Material.ROCK, name);
		
		setHardness(2f);
		setResistance(4f);
	}
	
	// Set the color this block displays as on a map
	public MapColor getMapColor(IBlockState state) {
		
		return MapColor.PURPLE;
	}
	
	@Override
	public BlockStone setCreativeTab(CreativeTabs tab) {
		
		super.setCreativeTab(tab);
		return this;
	}

}
