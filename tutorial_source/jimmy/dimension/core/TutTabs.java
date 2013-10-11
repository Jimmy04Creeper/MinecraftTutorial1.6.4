package jimmy.dimension.core;

import jimmy.dimension.creative.TutBlockTab;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class TutTabs {
	
	public static CreativeTabs tutBlocks;

	public static void load(FMLPostInitializationEvent event) {
		tutBlocks = new TutBlockTab(CreativeTabs.getNextID(), "Tutorial");
		
		addBlocksToList();
	}
	
	private static void addBlocksToList(){
		TutBlocks.tutDirt.setCreativeTab(tutBlocks);
		TutBlocks.tutFire.setCreativeTab(tutBlocks);
		TutBlocks.tutGrass.setCreativeTab(tutBlocks);
		TutBlocks.tutLeaf.setCreativeTab(tutBlocks);
		TutBlocks.tutLog.setCreativeTab(tutBlocks);
		TutBlocks.tutPortal.setCreativeTab(tutBlocks);
		TutBlocks.tutStone.setCreativeTab(tutBlocks);
	}
}
