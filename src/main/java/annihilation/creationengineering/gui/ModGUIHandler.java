package annihilation.creationengineering.gui;

import annihilation.creationengineering.CreationEngineering;
import annihilation.creationengineering.tileentity.TileEntityVoidMatterExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ModGUIHandler implements IGuiHandler{
	
	public static final int GUI_VMC=1;
	public ContainerVoidMatterExtractor guiVMC;
	
	public ModGUIHandler() {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(CreationEngineering.ce, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);
		switch (ID) {
		case GUI_VMC:
			return this.guiVMC=new ContainerVoidMatterExtractor(player,(TileEntityVoidMatterExtractor)tile);
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);
		switch (ID) {
		case GUI_VMC:
			return new GUIVoidMatterExtractor(new ContainerVoidMatterExtractor(player,(TileEntityVoidMatterExtractor)tile));
		default:
			return null;
		}
	}

}
