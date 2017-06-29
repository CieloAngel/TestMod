package net.cieloangel.testmod.item;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class ItemToolHoe extends ItemHoe implements ItemModelProvider {
	
	private String name;
	
	public ItemToolHoe (ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		this.name = name;
	}

	@Override
	public void registerItemModel(Item item) {
		TestMod.proxy.registerItemRenderer(this, 0, name);
		
	}

}
