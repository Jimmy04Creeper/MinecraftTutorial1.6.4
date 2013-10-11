package jimmy.dimension.core;

import jimmy.dimension.world.WorldProviderAzanor;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;

public class TutDimensions {

	public static int tutDimensionID;
	public static int tutBiomeID;
	
	public static void initConfig(Configuration config) {
		tutDimensionID = config.get("Dimension", "tutDimension", 2).getInt();
		tutBiomeID = config.get("Biomes", "tutBiome", 25).getInt();
	}
	
	/** Add and register World Providers & Dimensions **/
	public static void dimensionInit() {
		DimensionManager.registerProviderType(tutDimensionID, WorldProviderAzanor.class, false);
		DimensionManager.registerDimension(tutDimensionID, tutDimensionID);
	}
}
