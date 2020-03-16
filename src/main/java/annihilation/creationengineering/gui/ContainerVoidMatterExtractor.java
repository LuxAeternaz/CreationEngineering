package annihilation.creationengineering.gui;

import javax.annotation.Nonnull;

import annihilation.creationengineering.block.BlockVoidMatterExtractor;
import annihilation.creationengineering.tileentity.TileEntityVoidMatterExtractor;
import annihilation.creationengineering.item.*;
import annihilation.creationengineering.item.handler.ItemStackHandlerVoidMatterExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerVoidMatterExtractor extends Container{
	
	public TileEntityVoidMatterExtractor tile;
	public int burnTime;
	public int fuel,totalFuel;
	private final int totalBurnTime = 400;
	public ContainerVoidMatterExtractor(EntityPlayer ep,TileEntity te) {
		super();
		this.tile=(TileEntityVoidMatterExtractor)te;
		ItemStackHandlerVoidMatterExtractor inventory=this.tile.inventory;		
		this.addSlotToContainer(new SlotItemHandlerInput(inventory, 0, 56, 17) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return TileEntityVoidMatterExtractor.getRecipe(stack)!=ItemStack.EMPTY;
			}
		});
		
		this.addSlotToContainer(new SlotItemHandler(inventory, 1, 116, 35) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return false;
			}
		});
		
		this.addSlotToContainer(new SlotItemHandlerInput(inventory, 2, 56, 53) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				return TileEntityFurnace.getItemBurnTime(stack)>0;
			}
		});


        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(ep.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(ep.inventory, k, 8 + k * 18, 142));
        }
	}
	
    @Override
    public void detectAndSendChanges() {
    	super.detectAndSendChanges();
    	
    	this.burnTime=tile.getBurnTime();
    	this.fuel=tile.fuel;
    	this.totalFuel =tile.totalFuel;
        for (IContainerListener i : this.listeners)
        {
        	i.sendWindowProperty(this, 0, this.burnTime);			
        	i.sendWindowProperty(this, 1, this.fuel);
        	i.sendWindowProperty(this, 2, this.totalFuel);
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data) {
    	
    	super.updateProgressBar(id, data);
    	if(id==0) {
    		this.burnTime=data;
    	} else if (id==1) {
    		this.fuel=data;
    	} else if (id==2) {
    		this.totalFuel=data;
    	}
    	
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack())
        {
            return null;
        }

        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

        boolean isMerged = false;

        if (index == 0 || index == 1 ||index==2)
        {
            isMerged = mergeItemStack(newStack, 3, 39, true);
        }
        else if (index >= 3 && index < 30)
        {
            isMerged = mergeItemStack(newStack, 0, 3, false) || mergeItemStack(newStack, 30, 39, false);
        }
        else if (index >= 30 && index < 39)
        {
            isMerged = mergeItemStack(newStack, 0,3 , false)|| mergeItemStack(newStack, 3, 30, false);
        }

        if (!isMerged)
        {
            return null;
        }

        if (newStack.getMaxStackSize() == 0)
        {
            slot.putStack(null);
        }
        else
        {
            slot.onSlotChanged();
        }

        slot.onTake(playerIn, newStack);

        return oldStack;
    }
	

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
    public int getBurnTime()
    {
        return this.burnTime;
    }
	
}
