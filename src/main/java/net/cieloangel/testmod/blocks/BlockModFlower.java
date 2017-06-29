package net.cieloangel.testmod.blocks;

import java.util.List;

import net.cieloangel.testmod.TestMod;
import net.cieloangel.testmod.blocks.metadata.FlowerType;
import net.cieloangel.testmod.util.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModFlower extends BlockPlantBase implements ItemModelProvider{
	
	private static final AxisAlignedBB FLOWER_AABB = new AxisAlignedBB(0.3, 0, 0.3, 0.8, 1, 0.8);
	public static final PropertyEnum<FlowerType> TYPE = PropertyEnum.<FlowerType>create("type", FlowerType.class);
	
	public BlockModFlower (String name) {
		super(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, FlowerType.HYDRANGEA));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, FlowerType.values()[meta]);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((FlowerType)state.getValue(TYPE)).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for(int i = 0; i < FlowerType.values().length; i++)
			list.add(new ItemStack(itemIn, 1, i));
	}

	
	public String getSpecialName(ItemStack stack) {
		return FlowerType.values()[stack.getItemDamage()].getName();
	}
	
    // The "outline" shown when you mouse over the plant
    @Override
	public AxisAlignedBB getBoundingBox (IBlockState state, IBlockAccess world, BlockPos pos) {
		return FLOWER_AABB;
	}
    
    @Override
	@SideOnly(Side.CLIENT)
	// How to position the flowers when placed. Randomly moves them around the block and up and down in height
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XYZ;
	}

	@Override
	public void registerItemModel(Item item) {
		for (int i = 0; i < FlowerType.values().length; i++) {
			TestMod.proxy.registerItemRenderer(item, i, "block_flower_" + FlowerType.values()[i].getName());
		}
	}

}
