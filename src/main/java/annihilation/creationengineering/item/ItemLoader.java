package annihilation.creationengineering.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod.EventBusSubscriber(modid = "creationengineering")
public class ItemLoader {
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ModItems.voidMatter);
		event.getRegistry().register(ModItems.extremeOrderCrystal);
		event.getRegistry().register(ModItems.voidMatterOre);
		event.getRegistry().register(ModItems.extremeOrderCrystalOre);
		event.getRegistry().register(ModItems.voidMatterExtractor);
	}
	
}
