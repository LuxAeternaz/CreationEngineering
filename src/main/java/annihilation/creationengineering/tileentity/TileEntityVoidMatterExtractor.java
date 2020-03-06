package annihilation.creationengineering.tileentity;

import javax.annotation.Nonnull;

import annihilation.creationengineering.block.BlockVoidMatterExtractor;
import annihilation.creationengineering.item.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityVoidMatterExtractor extends TileEntity implements ITickable {
	
	
	public int burnTime= 0;
	public int fuel = 0;
	public ItemStackHandler inventory = new ItemStackHandler(3);
	public IBlockState state;

	
    @Override
    public boolean hasCapability(Capability<?> cap, EnumFacing facing) {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(cap, facing);
    }

    
    @Override
    public <T> T getCapability(Capability<T> cap, EnumFacing facing) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(new ItemStackHandler (){
                @Override
                public int getSlots() {
                    return inventory.getSlots();
                }
                @Override
                public ItemStack getStackInSlot(int slot) {
                    return inventory.getStackInSlot(slot);
                }
                @Override
                public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                    if (facing==EnumFacing.UP&&stack.getItem()==ModItems.voidMatterOre) {
                        return inventory.insertItem(0, stack, simulate);
                    }
                    if(facing==EnumFacing.SOUTH||facing==EnumFacing.EAST||facing==EnumFacing.NORTH||facing==EnumFacing.WEST){
                    	return inventory.insertItem(2, stack, simulate);
                    }
                    return stack;
                }
                @Override
                public ItemStack extractItem(int slot, int amount, boolean simulate) {
                    // 仅当对 1 号槽位尝试提取物品时允许听过，否则拒绝提取
                    if (slot == 1) {
                        return inventory.extractItem(1, amount, simulate);
                    }
                    return ItemStack.EMPTY;
                }
                @Override
                public int getSlotLimit(int slot) {
                    return inventory.getSlotLimit(slot);
                }
                @Override
                public boolean isItemValid(int slot, ItemStack stack) {
                    // 我们只允许 0 号槽位输入物品。
                    // 1 号槽位中的物品不能通过自动化手段输入，必须由我们自己控制。
                    return slot == 0||slot == 2;
                }
            });
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
        return  super.writeToNBT(compound);
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.inventory.deserializeNBT(compound.getCompoundTag("Iventory"));
        this.burnTime = compound.getInteger("BurnTime");
        this.fuel=compound.getInteger("Fuel");
    }
    


	@Override
	public void update() {
		if(!world.isRemote) {
			state=this.world.getBlockState(pos);
			if (!inventory.getStackInSlot(0).isEmpty()) {
				if((!inventory.getStackInSlot(2).isEmpty())&&fuel==0){
					if(ForgeEventFactory.getItemBurnTime(inventory.extractItem(2,1, true))>0) {
						this.fuel=ForgeEventFactory.getItemBurnTime(inventory.extractItem(2,1, false));
					}
				}
			}
			if(fuel>0)
			{
				fuel--;
				burnTime++;
				this.world.setBlockState(pos, state.withProperty(BlockVoidMatterExtractor.BURNING, true));
			} else {
				this.world.setBlockState(pos, state.withProperty(BlockVoidMatterExtractor.BURNING, false));
			}
			this.markDirty();
		}
		
	}
    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
    {
        return oldState.getBlock() != newState.getBlock();
    }


}
