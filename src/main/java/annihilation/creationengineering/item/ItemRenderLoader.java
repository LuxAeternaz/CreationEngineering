package annihilation.creationengineering.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = "creationengineering")
public class ItemRenderLoader 
{
	
	@SubscribeEvent
	public static void RegisterItemRender(ModelRegistryEvent event)
	{
		ModelLoader.setCustomModelResourceLocation(ModItems.voidMatter, 0, 
				new ModelResourceLocation(ModItems.voidMatter.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.extremeOrderCrystal, 0,
				new ModelResourceLocation(ModItems.extremeOrderCrystal.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.voidMatterOre, 0,
				new ModelResourceLocation(ModItems.voidMatterOre.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.voidMatterExtractor, 0,
				new ModelResourceLocation(ModItems.voidMatterExtractor.getRegistryName(), "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.extremeOrderCrystalOre, 0, 
				new ModelResourceLocation(ModItems.extremeOrderCrystalOre.getRegistryName(),"inventory"));
		
		
	}
	
}
