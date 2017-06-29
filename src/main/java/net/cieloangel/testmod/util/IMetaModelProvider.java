package net.cieloangel.testmod.util;

import net.minecraft.item.Item;

public interface IMetaModelProvider {
	
	void registerItemModel(Item item, int meta, String name);

}
