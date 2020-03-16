package annihilation.creationengineering.gui;

import annihilation.creationengineering.CreationEngineering;
import annihilation.creationengineering.block.BlockVoidMatterExtractor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIVoidMatterExtractor extends GuiContainer{
	
	public ResourceLocation rsVCM = new ResourceLocation(CreationEngineering.MODID+":"+"textures/gui/void_matter_extractor_gui.png");
	public ContainerVoidMatterExtractor inventory;

	public GUIVoidMatterExtractor(ContainerVoidMatterExtractor inventorySlotsIn) {
		super(inventorySlotsIn);
		this.xSize=176;
		this.ySize=166;
		this.inventory= inventorySlotsIn;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(rsVCM);
		
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        float textureWidth= ((float)this.inventory.getBurnTime()/(float)400)*(float)24;
        this.drawTexturedModalRect(i + 79, j + 34, 176, 14, (int)textureWidth, 16);
        if(this.inventory.fuel>0) { 
            this.drawTexturedModalRect(i+56,j+36,176,0,14,14);
            float textureHeight = ((float)this.inventory.fuel/(float)this.inventory.totalFuel)*(float)14;
            this.drawTexturedModalRect(i+56,j+36,56,36,14,14-(int)textureHeight);
        }

        
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
	}
	
}
