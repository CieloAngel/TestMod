package net.cieloangel.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockPurpleCobblestone extends Block {
	
	public BlockPurpleCobblestone(String name) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
	public MapColor getMapColor(IBlockState state) {
		return MapColor.PURPLE;
	}

}
