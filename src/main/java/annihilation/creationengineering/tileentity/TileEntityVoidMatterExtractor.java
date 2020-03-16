package annihilation.creationengineering.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import annihilation.creationengineering.block.BlockVoidMatterExtractor;
import annihilation.creationengineering.item.ModItems;
import annihilation.creationengineering.item.handler.ItemStackHandlerVoidMatterExtractor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityVoidMatterExtractor extends TileEntity implements ITickable{
	
	
	public int burnTime= 0;
	public int fuel = 0;
	public int totalFuel=0;
	public ItemStackHandlerVoidMatterExtractor inventory   = new ItemStackHandlerVoidMatterExtractor(); 
	
	public IBlockState state;
	
    @Override
    public boolean hasCapability(Capability<?> cap, EnumFacing facing) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(cap, facing);
    }

    
    @Override
    public <T> T getCapability(Capability<T> cap, EnumFacing facing) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	return (T) inventory.setFacing(facing);
        } else {
            return super.getCapability(cap, facing);
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setTag("Iventory", this.inventory.serializeNBT());
        compound.setInteger("BurnTime", this.burnTime);
        compound.setInteger("Fuel", this.fuel);
        compound.setInteger("TotalFuel", this.totalFuel);
        return  super.writeToNBT(compound);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.inventory.deserializeNBT(compound.getCompoundTag("Iventory"));
        this.burnTime = compound.getInteger("BurnTime");
        this.fuel=compound.getInteger("Fuel");
        this.totalFuel=compound.getInteger("TotalFuel");
    }
    

	@Override
	public void update() {
		if(!world.isRemote) {
			state=this.world.getBlockState(pos);
			if ((!inventory.getStackInSlot(0).isEmpty())&&this.getRecipe(inventory.extractItem(0, 1, true))!=ItemStack.EMPTY) {
				if((!inventory.getStackInSlot(2).isEmpty())&&fuel==0){
					if(TileEntityFurnace.getItemBurnTime(inventory.extractItem(2,1, true))>0) {
						this.totalFuel=TileEntityFurnace.getItemBurnTime(inventory.extractItem(2,1, true));
						this.fuel=TileEntityFurnace.getItemBurnTime(inventory.extractItem(2,1, false));
					}
				}
			} else {
				this.burnTime=0;
			}
			if(fuel>0)
			{
				fuel--;
				burnTime++;
				this.world.setBlockState(pos, state.withProperty(BlockVoidMatterExtractor.BURNING, true));
			} else {
				burnTime=0;
				this.world.setBlockState(pos, state.withProperty(BlockVoidMatterExtractor.BURNING, false));
			}
			if(burnTime==400) {
				burnTime=0;
				if(this.getRecipe(inventory.extractItem(0, 1, true))!=ItemStack.EMPTY) {
					inventory.insertItemIn(1,this.getRecipe(inventory.extractItem(0, 1, false)) , false);
				}
			}
			this.markDirty();
		}	
	}
	
	public static ItemStack getRecipe(ItemStack  stack) {
		if(stack.getItem()==ModItems.voidMatterOre)
		{
			return new ItemStack(ModItems.voidMatter,1);
		}
		return ItemStack.EMPTY;
	}
	
    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return oldState.getBlock() != newState.getBlock();
    }

    public int getBurnTime()
    {
    	return this.burnTime;
    }
    
}

