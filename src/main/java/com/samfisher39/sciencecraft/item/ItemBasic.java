package com.samfisher39.sciencecraft.item;

import com.samfisher39.sciencecraft.Sciencecraft;

import net.minecraft.item.Item;

public class ItemBasic extends Item {
	
	public ItemBasic(String unloclizedName, String registryName) {
		
		setUnlocalizedName(Sciencecraft.MODID + "." + unloclizedName);
		setRegistryName(registryName);
		setCreativeTab(Sciencecraft.SCIENCECRAFT_TAB);
		
	}
	
}
