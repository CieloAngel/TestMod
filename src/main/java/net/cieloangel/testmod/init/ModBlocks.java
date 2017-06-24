package net.cieloangel.testmod.init;

import net.cieloangel.testmod.blocks.BlockBase;
import net.cieloangel.testmod.blocks.BlockStone;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
public static BlockStone purpleCobblestone;
	
	public static void init() {
		purpleCobblestone = register(new BlockStone("block_purple_cobblestone"));
		
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);
		
		if (block instanceof BlockBase) {
			((BlockBase)block).registerItemModel(itemBlock);
		}
		
		return block;
	}
	
	private static <T extends Block> T register(T block) {
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		return register(block, itemBlock);
	}

}
