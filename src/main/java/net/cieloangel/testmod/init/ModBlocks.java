package net.cieloangel.testmod.init;

import net.cieloangel.testmod.blocks.BlockCropBonsai;
import net.cieloangel.testmod.blocks.BlockModStone;
import net.cieloangel.testmod.util.IModelProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static BlockModStone purpleStone;
	public static BlockModStone purpleCobblestone;
	public static BlockModStone greenStone;
	public static BlockModStone greenCobblestone;
	public static BlockCropBonsai cropBonsai;
	//public static BlockModPortal portalBlock;
	
	public static void init() {
		
		purpleStone = register(new BlockModStone("block_purple_stone"));
		purpleCobblestone = register(new BlockModStone("block_purple_cobblestone"));
		greenStone = register(new BlockModStone("block_green_stone"));
		greenCobblestone = register(new BlockModStone("block_green_cobblestone"));
		cropBonsai = register(new BlockCropBonsai(), null);
		//portalBlock = register(new BlockModPortal("block_portal_plain"), null);
		
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
		
		GameRegistry.register(block);
		
		if (itemBlock != null) {
			GameRegistry.register(itemBlock);
		
			if (block instanceof IModelProvider) {
				((IModelProvider)block).registerItemModel(itemBlock);
			}
		}
		
		return block;
	}
	
	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}

}
