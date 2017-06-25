package net.cieloangel.testmod.init;

import net.cieloangel.testmod.item.ItemBase;
import net.cieloangel.testmod.item.ItemBonsaiSeed;
import net.cieloangel.testmod.util.IModelProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemBase tempItem;
	public static ItemBonsaiSeed itemBonsaiSeed;
	
	/**
	 * Place calls to register items here
	 */
	public static void init() {
		tempItem = register(new ItemBase("item_temp_logo"));
		itemBonsaiSeed = register(new ItemBonsaiSeed());
	}
	
	/**
	 * Register the item with the GameRegistry and register an item model if
	 * one is present
	 * @param item  The item to be registered
	 * @return
	 */
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof IModelProvider) {
			((IModelProvider)item).registerItemModel(item);
		}
		
		return item;
	}

}
