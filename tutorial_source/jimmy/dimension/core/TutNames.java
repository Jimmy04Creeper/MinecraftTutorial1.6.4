package jimmy.dimension.core;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class TutNames {
	
	private static LanguageRegistry reg;

	public static void load(FMLPostInitializationEvent event) {
		reg.addName(TutBlocks.tutStone, "Tutorial Stone");
		reg.addName(TutBlocks.tutDirt, "Tutorial Dirt");
		reg.addName(TutBlocks.tutGrass, "Tutorial Grass");
		reg.addName(TutBlocks.tutLog, "Tutorial Log");
		reg.addName(TutBlocks.tutLeaf, "Tutorial Leaf");
		reg.addName(TutBlocks.tutFire,"Tutorial Fire");
		reg.addName(TutBlocks.tutPortal, "Tutorial Portal");
	}
}
