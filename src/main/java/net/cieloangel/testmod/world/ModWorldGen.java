package net.cieloangel.testmod.world;

import java.util.Random;

import net.cieloangel.testmod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {
	
	
	/**
	 * Called by Forge for every chunk that is generated and is the entry point into Minecraft's world
	 * generation
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {


		// Check if dimension is Overworld because we only want to generate in the overworld
		// If true, call generateOverworld to handle generation specific to this mod
		if (world.provider.getDimension() == 0) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		// Call the generateStone method with:
		// The default state of the stone block
		// The passed in world from generate()
		// the random number for generation
		// the x and z position (multiplied by 16 since chunks are 16x16)
		// the minimum and maximum Y position to generate the stone at (levels 3 to 256 in this case)
		// the size of the "vein" to generate (a random number from 4 to 7)
		// the number of times per chunk to generate (chance)
		generateStone(ModBlocks.purpleCobblestone.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 3, 256, 4 + random.nextInt(4), 6);
		
	}
	
	/**
	 * Helper method for generating stone
	 * @param stone  the stone to generate
	 * @param world  the dimension to generate the stone in
	 * @param random  a random number for stone generation
	 * @param x  the x coordinate to generate the stone at
	 * @param z  the z coordinate to generate the stone at
	 * @param minY  the minimum Y position to generate the stone at
	 * @param maxY  the max Y position to generate the stone at
	 * @param size  the size of each "vein"
	 * @param chance  the number of "veins" per chunk
	 */
	private void generateStone(IBlockState stone, World world, Random random, int x, int z, int minY, int maxY, int size, int chance) {
		int deltaY = maxY - minY;
		
		// Repeat the generation process in the loop chance number of times
		for (int i = 0; i < chance; i++) {
			
			// Create a BlockPos for the stone to be generated at
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z+ random.nextInt(16));
			
			// Create a new WorldGenMinable instance
			WorldGenMinable generator = new WorldGenMinable(stone, size);
			
			// Generate the stone in the world
			generator.generate(world, random, pos);
		}
	}

}
