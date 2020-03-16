package annihilation.creationengineering.common;

import annihilation.creationengineering.block.BlockLoader;
import annihilation.creationengineering.block.ModBlocks;
import annihilation.creationengineering.block.OreLoader;
import annihilation.creationengineering.gui.ModGUIHandler;
import annihilation.creationengineering.item.ModItems;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public static OreGenEvent.Post event;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{	
		GameRegistry.registerWorldGenerator(OreLoader.genOre, 10);
		new ModGUIHandler();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}

}
