package annihilation.creationengineering.block;

import annihilation.creationengineering.item.CreativesTabCreationEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item.ToolMaterial;

public class ModBlocks
{
	
	public static  Block voidMatterOre = new BlockVoidMaterOre();
	public static  Block extremeOrderCrystalOre = new BlockExtremeOrderCrystalOre(Material.ROCK).setRegistryName("extreme_order_crystal_ore").setCreativeTab(CreativesTabCreationEngineering.creationengineering)
			.setUnlocalizedName("extreme_order_crystal_ore");		
	public static  Block voidMatterExtractor =new BlockVoidMatterExtractor(false).setRegistryName("void_matter_extractor")
			.setCreativeTab(CreativesTabCreationEngineering.creationengineering);
}
