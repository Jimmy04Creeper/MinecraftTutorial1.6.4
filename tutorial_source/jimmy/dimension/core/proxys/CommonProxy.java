package jimmy.dimension.core.proxys;

import jimmy.dimension.core.TutBlocks;
import jimmy.dimension.core.TutNames;
import jimmy.dimension.core.TutRecpies;
import jimmy.dimension.core.TutTabs;
import jimmy.dimension.core.config.ConfigHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void loadIDs(FMLPreInitializationEvent event) {
		ConfigHandler.load(event);
	}

	public void loadItems(FMLInitializationEvent event) {
		TutBlocks.load(event);
	}

	public void loadBlocks(FMLInitializationEvent event) {
		TutBlocks blocks = new TutBlocks();
	}

	public void loadNames(FMLPostInitializationEvent event) {
		TutNames.load(event);
		TutRecpies.load(event);
		TutTabs.load(event);
	}
}
