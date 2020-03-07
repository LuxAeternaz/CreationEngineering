package annihilation.creationengineering.gui;

import annihilation.creationengineering.CreationEngineering;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler{
	
	public static final int GUI_VMC=1;
	
	public GUIHandler() {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(CreationEngineering.ce, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_VMC:
			return new VoidMatterExtractorContainer();
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case GUI_VMC:
			return new VoidMatterExtractorGUIContainer(new VoidMatterExtractorContainer());
		default:
			return null;
		}
	}

}
