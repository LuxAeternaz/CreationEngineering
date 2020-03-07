package annihilation.creationengineering.gui;

import annihilation.creationengineering.CreationEngineering;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class VoidMatterExtractorGUIContainer extends GuiContainer{
	
	public ResourceLocation rsVCM = new ResourceLocation(CreationEngineering.MODID+":"+"textures/gui/VoidMatterExtractorGUI");

	public VoidMatterExtractorGUIContainer(Container inventorySlotsIn) {
		super(inventorySlotsIn);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
	}
	
}
