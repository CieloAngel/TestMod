package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;

public class BlockPlantBase extends BlockBush implements ItemModelProvider {

	private String name;

	/**
	 * Constructor
	 * 
	 * @param name The plant's name, used for registering and localizing
	 */
	public BlockPlantBase(String name) {
		super();

		this.name = name;

		setSoundType(SoundType.PLANT);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(TestMod.creativeTab);
	}

	/**
	 * Register the plant's item model
	 */
	@Override
	public void registerItemModel(Item item) {
		TestMod.proxy.registerItemRenderer(item, 0, name);
	}

}
