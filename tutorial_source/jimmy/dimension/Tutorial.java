package jimmy.dimension;

import jimmy.dimension.core.lib.Locations;
import jimmy.dimension.core.lib.Reference;
import jimmy.dimension.core.proxys.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid=Reference.MODID, name=Reference.MODID, version=Reference.MODID)
@NetworkMod(clientSideRequired=true, serverSideRequired=true)

public class Tutorial {
													/** THIS WILL BE THE MAIN MOD FILE, THIS IS WERE IT ALL STARTS **/

	//Mod instance, not used at the moment but good to have.
	@Instance(Reference.MODID)
	public static Tutorial instance;
	
	//Proxy locations
	@SidedProxy(clientSide=Locations.clientProxy, serverSide=Locations.commonProxy)
	public static CommonProxy proxy;

	//pre init method
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.loadIDs(event);
	}
	
	//init method
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.loadItems(event);
		proxy.loadBlocks(event);
	}
	
	//post init method
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.loadNames(event);
	}
}

