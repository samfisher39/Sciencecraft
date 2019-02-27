package com.samfisher39.sciencecraft;

import org.apache.logging.log4j.Logger;

import com.samfisher39.sciencecraft.proxy.IProxy;
import com.samfisher39.sciencecraft.tabs.SciencecraftTab;

import net.minecraft.creativetab.CreativeTabs;

//import com.samfisher39.sciencecraft.proxy.ServerProxy;
 
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
 
@Mod(modid = Sciencecraft.MODID, name = Sciencecraft.NAME, version = Sciencecraft.VERSION, acceptedMinecraftVersions = Sciencecraft.MC_VERSION)
public class Sciencecraft {
 
    public static final String MODID = "sciencecraft";
    public static final String NAME = "Sciencecraft";
    public static final String VERSION = "1.0";
    public static final String MC_VERSION = "[1.12.2]";

    public static final String CLIENT = "com.samfisher39.sciencecraft.proxy.ClientProxy";
    public static final String SERVER = "com.samfisher39.sciencecraft.proxy.ServerProxy";
    
    public static final CreativeTabs SCIENCECRAFT_TAB = new SciencecraftTab("tabScienceCraft");
    
    @SidedProxy(clientSide = Sciencecraft.CLIENT, serverSide = Sciencecraft.SERVER)
    public static IProxy proxy;
 
    public static Logger logger;
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }
 
    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info(Sciencecraft.NAME + "says hi!");
        proxy.init(event);
    }
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }
 
}