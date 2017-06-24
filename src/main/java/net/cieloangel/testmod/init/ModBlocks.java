package net.cieloangel.testmod.init;

import net.cieloangel.testmod.blocks.BlockPurpleCobblestone;
import net.cieloangel.testmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
public static Block purpleCobblestone;
	
	public static void init() {
		purpleCobblestone = new BlockPurpleCobblestone("block_purple_cobblestone");
		
	}
	
	public static void register() {
		registerBlock(purpleCobblestone);
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	
	public static void registerRenders(){
		registerRender(purpleCobblestone);
	}
	
	// Register renders for blocks without meta data
	public static void registerRender(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, block.getUnlocalizedName().substring(5)), "inventory"));
		
	}

}
