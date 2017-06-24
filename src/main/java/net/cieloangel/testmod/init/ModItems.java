package net.cieloangel.testmod.init;

import net.cieloangel.testmod.item.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	
	/**
	 * Place calls to register items here
	 */
	public static void init() {
		
	}
	
	/**
	 * Register the item with the GameRegistry and register an item model if
	 * one is present
	 * @param item  The item to be registered
	 * @return
	 */
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof ItemBase) {
			((ItemBase)item).registerItemModel();
		}
		
		return item;
	}

}
