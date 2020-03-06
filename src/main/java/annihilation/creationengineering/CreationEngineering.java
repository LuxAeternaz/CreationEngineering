package annihilation.creationengineering;

import annihilation.creationengineering.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "creationengineering" ,name = "Creation Engineering",version = "1.0.0")
public class CreationEngineering 
{
	
	@SidedProxy(serverSide = "annihilation.creationengineering.common.CommonProxy",
			clientSide = "annihilation.creationengineering.client.ClientProxy")
	public static CommonProxy common;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{

		common.preInit(event);
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		common.init(event);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		common.postInit(event);
	}
	
}
