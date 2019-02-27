package com.samfisher39.sciencecraft.materials;

import com.samfisher39.sciencecraft.Sciencecraft;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class SciencecraftMaterials {

	public static final ToolMaterial SC_NEUTRON_MATERIAL = 
			EnumHelper.addToolMaterial(Sciencecraft.MODID + ":" + "neutron_material" , 4, 9999, 7.0f, 7.5f, 10);
	public static final ToolMaterial SC_ELECTRON_MATERIAL = 
			EnumHelper.addToolMaterial(Sciencecraft.MODID + ":" + "electron_material" , 3, 5, 20.0f, 4.5f, 10);
	public static final ToolMaterial SC_PROTON_MATERIAL = 
			EnumHelper.addToolMaterial(Sciencecraft.MODID + ":" + "proton_material" , 5, 3000, 13.0f, 5.5f, 10);
	
}
