package net.cieloangel.testmod.init;

import net.cieloangel.testmod.blocks.BlockModFlower;
import net.cieloangel.testmod.blocks.metadata.FlowerType;
import net.cieloangel.testmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocksv2 {
	
//	public static BlockModFlower flower;
//	
//	public static void init() {
//		flower = registerBlock(new BlockModFlower("block_flower"));
//	}
//	
//	public static <T extends Block> T registerBlock(Block block) {
//		ItemBlock itemBlock = new ItemBlock(block);
//		GameRegistry.register(block);
//		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
//	}
//	
//	public static void registerRenders() {
//		for (int i = 0; i < FlowerType.values().length; i++) {
//			registerRender(flower, i, "block_flower_" + FlowerType.values()[i].getName());
//		}
//	}
//	
//	// Register renders for blocks with metadata
//	public static void registerRender(Block block, int meta, String name) {
//		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, newModelResourceLocation(new ResourceLocation(Reference.MOD_ID, name), "inventory"));
//	}
//	
//	private static <T extends Block> T registerRender(T block) {
//		ItemBlock itemBlock = new ItemBlock(block);
//		itemBlock.setRegistryName(block.getRegistryName());
//		return registerRender(block);
//	}

}
