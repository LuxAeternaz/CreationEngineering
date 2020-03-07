package annihilation.creationengineering.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class VoidMatterExtractorContainer extends Container{

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
	public VoidMatterExtractorContainer() {
		super();
	}

}
