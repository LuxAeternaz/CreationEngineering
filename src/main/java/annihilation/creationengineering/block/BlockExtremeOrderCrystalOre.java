package annihilation.creationengineering.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockExtremeOrderCrystalOre extends Block{

	public BlockExtremeOrderCrystalOre(Material materialIn) {
		super(materialIn);
		this.setHardness(3F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 3);
	}
	
}
