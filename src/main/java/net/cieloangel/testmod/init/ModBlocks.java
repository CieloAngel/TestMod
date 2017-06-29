package net.cieloangel.testmod.init;

import net.cieloangel.testmod.blocks.BlockCropBonsai;
import net.cieloangel.testmod.blocks.BlockModOre;
import net.cieloangel.testmod.blocks.BlockModStone;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.cieloangel.testmod.util.ItemOreDict;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static BlockModStone purpleStone;
	public static BlockModStone purpleCobblestone;
	public static BlockModStone greenStone;
	public static BlockModStone greenCobblestone;
	public static BlockCropBonsai cropBonsai;
	public static BlockModOre oreLeprunese;
	// public static BlockModFlower flower;
	// public static BlockModPortal portalBlock;

	public static void init() {

		purpleStone = register(new BlockModStone("block_purple_stone", "stone"));
		purpleCobblestone = register(new BlockModStone("block_purple_cobblestone", "cobblestone"));
		greenStone = register(new BlockModStone("block_green_stone", "stone"));
		greenCobblestone = register(new BlockModStone("block_green_cobblestone", "cobblestone"));
		oreLeprunese = register(new BlockModOre("block_ore_leprunese", "block_ore_leprunese"));
		cropBonsai = register(new BlockCropBonsai(), null);
		// flower = register(new BlockModFlower("block_flower"));
		// portalBlock = register(new BlockModPortal("block_portal_plain"),
		// null);

	}

	// ORIGINAL FROM SHADOWFACTS
	// Registers the item with the GameRegistry
	// Registers the item model if one is present
	// Changed when registerItemModel was moved out of base classes in to
	// IModelProvider
	// private static <T extends Block> T register(T block, ItemBlock itemBlock)
	// {
	// GameRegistry.register(block);
	// GameRegistry.register(itemBlock);
	// if (block instanceof BlockBase) {
	// ((BlockBase)block).registerItemModel(itemBlock);
	// }
	// return block;
	// }

	// Registers the item with the GameRegistry
	// Registers the item model if one is present
	private static <T extends Block> T register(T block, ItemBlock itemBlock) {

		GameRegistry.register(block);

		// If the block does not have an ItemBlock associated with it, skip
		// registering the ItemBlock
		if (itemBlock != null) {
			GameRegistry.register(itemBlock);

			if (block instanceof ItemModelProvider) {

				((ItemModelProvider) block).registerItemModel(itemBlock);
			}
			if (block instanceof ItemOreDict) {
				((ItemOreDict)block).initOreDict();
			}
			if (itemBlock instanceof ItemOreDict) {
				((ItemOreDict)itemBlock).initOreDict();
			}
		}

		return block;
	}

	// ORIGINAL FROM SHADOWFACTS
	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}

}
