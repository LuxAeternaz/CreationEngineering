package annihilation.creationengineering.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativesTabCreationEngineering extends CreativeTabs {
	
	public static final CreativeTabs creationengineering = new CreativesTabCreationEngineering();
	
	private static String label = "creationengineering";

	public CreativesTabCreationEngineering() {
		super(label);
	}

	@Override
	public String getTranslatedTabLabel() {
		return label;
	}
	

	@Override
	public ItemStack getTabIconItem() {
		return  new ItemStack(ModItems.voidMatter);
	}

}
