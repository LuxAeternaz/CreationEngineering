package annihilation.creationengineering.item.handler;

import annihilation.creationengineering.tileentity.TileEntityVoidMatterExtractor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStackHandlerVoidMatterExtractor extends ItemStackHandler{
	
	public ItemStackHandlerVoidMatterExtractor(){
		
		super(3);
		
	}
	public EnumFacing facing0;
	public EnumFacing facing1;
	public EnumFacing facing2;
	
	@Override
	public boolean isItemValid(int slot,ItemStack stack) {
		return (slot==0&&!TileEntityVoidMatterExtractor.getRecipe(stack).isEmpty()) || (slot==2&&TileEntityFurnace.getItemBurnTime(stack)>0);
	}
	
	@Override
	public ItemStack insertItem(int slot,  ItemStack stack,boolean simulate) {
		if(facing1!=null&&slot==1) {
			this.facing1=null;
			return stack;
		}
		if(slot==0&&TileEntityVoidMatterExtractor.getRecipe(stack).isEmpty() || (slot==2&&!(TileEntityFurnace.getItemBurnTime(stack)>0))) {
			return stack;
		}
		return super.insertItem(slot, stack, simulate);
	}
	
	
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		
		if(facing0 != null&&slot==0) {
			this.facing0=null;
			return ItemStack.EMPTY;
		}
		if(facing2 != null&&slot==2) {
			this.facing2=null;
			return ItemStack.EMPTY;
		}

		return super.extractItem(slot, amount, simulate);
	}
	
	public ItemStack insertItemIn(int slot,  ItemStack stack,boolean simulate) {
		return super.insertItem(slot, stack, simulate);
	}
	
	public ItemStack extractItemIn(int slot, int amount, boolean simulate) {
		return super.extractItem(slot, amount, simulate);
	}
	
	
	public IItemHandler setFacing(EnumFacing facing) {
		
		this.facing0=facing;
		this.facing1=facing;
		this.facing2=facing;
		return this;
	}
	
}