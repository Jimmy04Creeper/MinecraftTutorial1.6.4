package jimmy.dimension.core;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class TutRecpies {

	static GameRegistry reg;

	public static void load(FMLPostInitializationEvent event) { 
		reg.addShapelessRecipe(new ItemStack(TutBlocks.tutStone, 1), new Object[]{
			Block.stone, Block.stone
		});
		reg.addShapelessRecipe(new ItemStack(TutBlocks.tutDirt, 1), new Object[]{
			Block.dirt, Block.dirt
		});
		reg.addShapelessRecipe(new ItemStack(TutBlocks.tutGrass, 1), new Object[]{
			Block.dirt, Block.grass
		});
		reg.addShapelessRecipe(new ItemStack(TutBlocks.tutLog, 1), new Object[]{
			Block.wood,  Block.wood
		});
	}
}
