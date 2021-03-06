package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.util.ItemOreDict;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.oredict.OreDictionary;

public class BlockModStone extends BlockBase implements ItemOreDict {
	
	private String oreDictName;
	
	// Constructor
	public BlockModStone(String name, String oreDictName) {
		
		super(Material.ROCK, name);
		
		this.oreDictName = oreDictName;
		
		setHardness(1.5f);
		setResistance(3f);
	}
	
	@Override
	public void initOreDict() {
		OreDictionary.registerOre(oreDictName, this);
	}
	
	// Set the color this block displays as on a map
	public MapColor getMapColor(IBlockState state) {
		
		return MapColor.PURPLE;
	}
	
//	@Override
//	public BlockModStone setCreativeTab(CreativeTabs tab) {
//		
//		super.setCreativeTab(tab);
//		return this;
//	}

}
