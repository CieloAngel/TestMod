package net.cieloangel.testmod.init;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.item.ItemBase;
import net.cieloangel.testmod.item.ItemBerry;
import net.cieloangel.testmod.item.ItemBonsaiSeed;
import net.cieloangel.testmod.item.ItemToolHoe;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static ItemBase tempItem;
	public static ItemBonsaiSeed itemBonsaiSeed;
	public static ItemBerry berry;
	public static ItemBase ingotLeprunese;
	public static ItemToolHoe lepruneseHoe;
	
	/**
	 * Place calls to register items here
	 */
	public static void init() {
		tempItem = register(new ItemBase("item_temp_logo"));
		itemBonsaiSeed = register(new ItemBonsaiSeed());
		berry = register(new ItemBerry());
		ingotLeprunese = register(new ItemBase("item_ingot_leprunese"));
		lepruneseHoe = register(new ItemToolHoe(TestMod.lepruneseToolMaterial, "item_tool_hoe_leprunese"));
	}
	
	/**
	 * Register the item with the GameRegistry and register an item model if
	 * one is present
	 * @param item  The item to be registered
	 * @return
	 */
	private static <T extends Item> T register(T item) {
		GameRegistry.register(item);
		
		if (item instanceof ItemModelProvider) {
			((ItemModelProvider)item).registerItemModel(item);
		}
		
		return item;
	}

}
