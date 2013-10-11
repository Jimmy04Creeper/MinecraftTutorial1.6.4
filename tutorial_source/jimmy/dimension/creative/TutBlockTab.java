package jimmy.dimension.creative;

import jimmy.dimension.core.TutBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TutBlockTab extends CreativeTabs
{
	public TutBlockTab(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(TutBlocks.tutStone, 1);
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return "Tutorial Blocks";
	}
}