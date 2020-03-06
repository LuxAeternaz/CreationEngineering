package annihilation.creationengineering.block;

import annihilation.creationengineering.item.CreativesTabCreationEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockVoidMaterOre extends Block {

	public BlockVoidMaterOre() {
		super(Material.ROCK);
		this.setRegistryName("void_matter_ore");
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 3);
		this.setHardness(3F);
		this.setCreativeTab(CreativesTabCreationEngineering.creationengineering);
		this.setUnlocalizedName("void_matter_ore");
	}

}