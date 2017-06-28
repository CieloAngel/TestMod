package net.cieloangel.testmod.blocks;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.util.IModelProvider;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;

public class BlockPlantBase extends BlockBush implements IModelProvider {

	private String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Tha plant's name, used for registering and localizing
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

	/**
	 * Register the plant in the creative tab
	 */
	// @Override
	// public BlockPlantBase setCreativeTab(CreativeTabs tab) {
	// super.setCreativeTab(tab);
	// return this;
	// }

	// // No collision bounding box means you can walk through the block
	// @Nullable
	// public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState,
	// World worldIn, BlockPos pos)
	// {
	// return NULL_AABB;
	// }

	// // Does not obstruct light
	// public boolean isOpaqueCube(IBlockState state)
	// {
	// return false;
	// }
	//
	// // Does not take up a full block space
	// public boolean isFullCube(IBlockState state)
	// {
	// return false;
	// }
	//
	// @SideOnly(Side.CLIENT)
	// public BlockRenderLayer getBlockLayer()
	// {
	// return BlockRenderLayer.CUTOUT;
	// }

}
