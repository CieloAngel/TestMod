// Now we need the actual code that generates our landscape. This is a modified copy of ChunkProviderOverworld except that we separated the actual terrain generator in a separate class for clarity. The terrain we generate here is basically only doing terrain and caves. There are no structures, no ravines and so on. Feel free to check the vanilla code to see how to implement those. We also make our custom mob spawn here as the only creature. You can of course also change that:

package net.cieloangel.testmod.world;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import net.minecraftforge.event.terraingen.TerrainGen;

import net.cieloangel.testmod.entity.EntityWeirdZombie;

public class TestChunkGenerator implements IChunkGenerator {
	
	private final World worldObj;
	private Random random;
	private Biome[] biomes;
	
	private List<Biome.SpawnListEntry> mobs = Lists.newArrayList(new Biome.SpawnListEntry(EntityWeirdZombie.class,  100,  2,  2));
	
	private MapGenBase caveGen = new MapGenCaves();
	private NormalTerrainGenerator terrainGen = new NormalTerrainGenerator();
	
	public TestChunkGenerator(World worldObj) {
		this.worldObj = worldObj;
		long seed = worldObj.getSeed();
		this.random = new Random((seed + 516) * 314);
		terrainGen.setup(worldObj, random);
		caveGen = TerrainGen.getModdedMapGen(caveGen, CAVE);
	}
	
	@Override
	public Chunk provideChunk(int x, int z) {
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		// Setup biomes for terrainGen
		this.biomes = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomes, x * 4 - 2, z * 4 -2, 10, 10);
		terrainGen.setBiomesForGeneration(biomes);
		terrainGen.generate(x, z, chunkPrimer);
		
		// Setup biomes again for biome decoration
		this.biomes = this.worldObj.getBiomeProvider().getBiomes(this.biomes, x * 16, z * 16, 16, 16);
		
		// Replace stone with biome specific stone
		terrainGen.replaceBiomeBlocks(x, z, chunkPrimer, this, biomes);
		
		// Generate caves
		this.caveGen.generate(this.worldObj, z, x, chunkPrimer);
		
		Chunk chunk = new Chunk(this.worldObj, chunkPrimer, x, z);
		
		byte[] biomeArray = chunk.getBiomeArray();
		for (int i = 0; i < biomeArray.length; i++) {
			biomeArray[i] = (byte)Biome.getIdForBiome(this.biomes[i]);
		}
		
		chunk.generateSkylightMap();
		return chunk;
		
	}
	
	@Override
	public void populate(int x, int z) {
		int i = x * 16;
		int j = z * 16;
		BlockPos pos = new BlockPos(i, 0, j);
		Biome biome = this.worldObj.getBiome(pos.add(16, 0, 16));
		
		// Add biome decorations (like flowers, grass, tress, etc)
		biome.decorate(this.worldObj, this.random, pos);
		
		// Make sure animals appropriate to the biome spawn when the chunk is generated
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, i + 8,  j + 8, 16, 16, this.random);
		
	}
	
	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}
	
	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		// Uncomment the following 2 lines to allow spawning of normal creatures
		// Biome biome = this.worldObj.getBiome(pos);
		// return biome.getSpawnableList(creatureType);
		
		if (creatureType == EnumCreatureType.MONSTER) {
			return mobs;
		}
		
		return ImmutableList.of();
	}
	
	@Nullable
	@Override
	public BlockPos getStrongholdGen(World world, String structureName, BlockPos pos) {
		return null;
	}
	
	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		
	}

}
