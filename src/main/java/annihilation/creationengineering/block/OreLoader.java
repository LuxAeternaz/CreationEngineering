package annihilation.creationengineering.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class OreLoader implements IWorldGenerator{
	
	public static IWorldGenerator genOre = new OreLoader();
	public static final WorldGenerator genVoidMaaterOre =new WorldGenMinable(ModBlocks.voidMatterOre.getDefaultState(), 6);
	public static final WorldGenerator genExtremeOrderCrystalOre = new WorldGenMinable(ModBlocks.extremeOrderCrystalOre.getDefaultState() ,4);
	public static Random rand;
	public static BlockPos pos;

	public OreLoader() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		int cx = chunkX << 4;
		int cy = chunkZ << 4;
		
		for(int i=0; i<18; i++)
		{
			
			int x = cx+random.nextInt(16);
			int y = 5+random.nextInt(30);
			int z = cy+random.nextInt(16);
			pos=new BlockPos(x,y,z);
			genVoidMaaterOre.generate(world, random, pos);
		}
		
		for(int i =0;i<8;i++) {
			int x = cx+random.nextInt(16);
			int y = 0+random.nextInt(25);
			int z = cy+random.nextInt(16);
			pos=new BlockPos(x,y,z);
			genExtremeOrderCrystalOre.generate(world, random,pos);
		}
		
	}


}	
	
	

