package annihilation.creationengineering.block;

import annihilation.creationengineering.tileentity.TileEntityVoidMatterExtractor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class BlockLoader 
{
	
	@SubscribeEvent
	public static void registerBlock(RegistryEvent.Register<Block> event)
	{
		
		event.getRegistry().register(ModBlocks.voidMatterOre);
		
		event.getRegistry().register(ModBlocks.voidMatterExtractor);

		
		GameRegistry.registerTileEntity(TileEntityVoidMatterExtractor.class, new ResourceLocation("creationengineering","void_matter_extractor"));
	}



}
