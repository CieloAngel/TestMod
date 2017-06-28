package net.cieloangel.testmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModFlower extends BlockPlantBase {
	
	private static final AxisAlignedBB FLOWER_AABB = new AxisAlignedBB(0.3, 0, 0.3, 0.8, 1, 0.8);
	
	public BlockModFlower (String name) {
		super(name);
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

}
