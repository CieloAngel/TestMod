package net.cieloangel.testmod.blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockModStone extends BlockBase {
	
	// Constructor
	public BlockModStone(String name) {
		
		super(Material.ROCK, name);
		
		setHardness(1.5f);
		setResistance(3f);
	}
	
	// Set the color this block displays as on a map
	public MapColor getMapColor(IBlockState state) {
		
		return MapColor.PURPLE;
	}
	
	@Override
	public BlockModStone setCreativeTab(CreativeTabs tab) {
		
		super.setCreativeTab(tab);
		return this;
	}

}
