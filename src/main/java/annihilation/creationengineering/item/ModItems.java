package annihilation.creationengineering.item;

import annihilation.creationengineering.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ModItems 
{
		
	public static Item voidMatter = new Item().setCreativeTab(CreativesTabCreationEngineering.creationengineering)
			.setMaxStackSize(64).setRegistryName("void_matter").setUnlocalizedName("void_matter");
	public static Item extremeOrderCrystal = new Item().setRegistryName("extreme_order_crystal").setUnlocalizedName("extreme_order_crystal")
			.setMaxStackSize(64).setCreativeTab(CreativesTabCreationEngineering.creationengineering);
	public static Item voidMatterOre = new ItemBlock(ModBlocks.voidMatterOre).setCreativeTab(CreativesTabCreationEngineering.creationengineering)
			.setRegistryName("void_matter_ore").setMaxStackSize(64).setUnlocalizedName("void_matter_ore");
	public static Item voidMatterExtractor = new ItemBlock(ModBlocks.voidMatterExtractor).setCreativeTab(CreativesTabCreationEngineering.creationengineering)
			.setRegistryName("void_matter_extractor").setMaxStackSize(1).setUnlocalizedName("void_matter_extractor"); 
 
	
}
