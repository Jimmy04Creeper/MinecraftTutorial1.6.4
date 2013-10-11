package jimmy.dimension.core;

import jimmy.dimension.blocks.BlockModBasic;
import jimmy.dimension.blocks.BlockModGrass;
import jimmy.dimension.blocks.BlockModLeaf;
import jimmy.dimension.blocks.BlockModLog;
import jimmy.dimension.core.lib.BlockIDs;
import net.minecraft.block.Block;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class TutBlocks {

	public static Block tutGrass = new BlockModGrass(BlockIDs.tutGrass, "tutGrass").setUnlocalizedName("tutGrass");
	public static Block tutStone  = new BlockModBasic(BlockIDs.tutStone, "tutStone").setUnlocalizedName("tutStone").setTextureName("tutStone");
	public static Block tutDirt =  new BlockModBasic(BlockIDs.tutDirt, "tutDirt").setUnlocalizedName("tutDirt").setTextureName("tutDirt");
	public static Block tutLog =  new BlockModLog(BlockIDs.tutLog, "tutLog").setUnlocalizedName("tutLog").setTextureName("tutLog");
	public static Block tutLeaf =  new BlockModLeaf(BlockIDs.tutLeaf, "tutLeaf").setUnlocalizedName("tutLeaf").setTextureName("tutLeaf");

	private static GameRegistry reg;
	
	public static void load(FMLInitializationEvent event) {
 		reg.registerBlock(tutStone, "tutStone");
 		reg.registerBlock(tutDirt, "tutDirt");
 		reg.registerBlock(tutGrass, "tutGrass");
 		reg.registerBlock(tutLog, "tutLog");
 		reg.registerBlock(tutLeaf, "tutLeaf");
	}
}
