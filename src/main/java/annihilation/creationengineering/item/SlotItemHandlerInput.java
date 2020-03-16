package annihilation.creationengineering.item;

import javax.annotation.Nonnull;

import annihilation.creationengineering.item.handler.ItemStackHandlerVoidMatterExtractor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotItemHandlerInput  extends SlotItemHandler {

	private int index;
	private ItemStackHandlerVoidMatterExtractor itemHandler;

	public SlotItemHandlerInput(ItemStackHandlerVoidMatterExtractor inventory, int index, int xPosition, int yPosition) {
		super(inventory, index, xPosition, yPosition);
        this.itemHandler = inventory;
        this.index = index;
	}
	
    @Override
    public boolean canTakeStack(EntityPlayer playerIn)
    {
        return !this.itemHandler.extractItemIn(this.index, 1, true).isEmpty();
    }
    
    @Override
    @Nonnull
    public ItemStack decrStackSize(int amount)
    {
        return this.itemHandler.extractItemIn(index, amount, false);
    }
}
