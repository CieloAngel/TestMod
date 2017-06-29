package net.cieloangel.testmod.proxy;

import net.cieloangel.testmod.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	
	public void init(){
		// intentionally left blank
	}
	
	/**
	 * Tells Minecraft which item model to use for the item
	 */
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MOD_ID + ":" + id, "inventory"));
	}

}
