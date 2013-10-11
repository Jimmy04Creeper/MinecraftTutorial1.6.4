package jimmy.dimension.core.config;

import java.io.File;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	// ALL CODE IN HERE CAN BET CHANGED IN THE CONFIGURATION BY THE PLAYER

	public static void load(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		InitConfigBlocks(config);
		InitConfigItems(config);
		InitConfigDimension(config);
		InitConfigBiomes(config);
		config.save();
	}

	//Block veriables for ids
	public static int tutStoneID, tutDirtID, tutGrassID, tutLogID, tutLeafID, tutPortalID, tutFireID;

	private static void InitConfigBlocks(Configuration config) {
		int id = 2000;//Basic int for ids
		int terrainID = 190;//The int terrainID is only used for the blocks used in the world generation or biome generation 
		tutStoneID = config.getTerrainBlock("WorldGen Blocks", "tutStoneID", ++terrainID, "").getInt();
		tutDirtID = config.getTerrainBlock("WorldGen Blocks", "tutDirtID", ++terrainID, "").getInt();
		tutGrassID = config.getTerrainBlock("WorldGen Blocks", "tutGrassID", ++terrainID, "").getInt();
		
		tutLogID = config.getBlock("Blocks", "tutLogID", ++id, "").getInt();
		tutLeafID = config.getBlock("Blocks", "tutLeafID", ++id, "").getInt();
		tutPortalID = config.getBlock("Blocks", "tutPortalID", ++id).getInt();
		tutFireID = config.getBlock("Blocks", "tutFireID", ++id).getInt();
	}

	//Item veriables
	public static int portalLighter;

  	private static void InitConfigItems(Configuration config) {
		int itemID = 4150;
		portalLighter = config.getItem("portalLighter", ++itemID).getInt();
	}
	
  	//Biome veriables
  	public static int tutBiomeID;
  	
	//Biome ids 
	private static void InitConfigBiomes(Configuration config) {
		int biomeID = 50;
		tutBiomeID = config.get("tutBiomeID", "Biomes", biomeID++).getInt();
	}
	
	//Dimension veriables
	public static int tutorialDimensionID;
	
	//Dimension ids
	private static void InitConfigDimension(Configuration config) {
		int dimensionID = 3;
		tutorialDimensionID = config.get("tutorialDimensionID", "Dimenions", dimensionID++).getInt();
	}
}

