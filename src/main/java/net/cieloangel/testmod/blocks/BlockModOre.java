package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.util.ItemModelProvider;
import net.cieloangel.testmod.util.ItemOreDict;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.oredict.OreDictionary;

public class BlockModOre extends BlockBase implements ItemModelProvider, ItemOreDict {
	
	private String oreDictName;
	
	// Constructor
	public BlockModOre(String name, String oreDictName) {
		
		super(Material.IRON, name);
		
		this.oreDictName = oreDictName;
		
		setHardness(3f);
		setResistance(5f);
	}
	
	@Override
	public void initOreDict() {
		OreDictionary.registerOre(oreDictName, this);
	}
	
	// Set the color this block displays as on a map
	public MapColor getMapColor(IBlockState state) {
		
		return MapColor.PURPLE;
	}

}
