package annihilation.creationengineering.block;

import annihilation.creationengineering.item.CreativesTabCreationEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item.ToolMaterial;

public class ModBlocks
{
	
	public static  Block voidMatterOre = new BlockVoidMaterOre();
	public static  Block voidMatterExtractor =new BlockVoidMatterExtractor(false).setRegistryName("void_matter_extractor")
			.setCreativeTab(CreativesTabCreationEngineering.creationengineering);
	
}
