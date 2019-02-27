package com.samfisher39.sciencecraft.tabs;

import com.samfisher39.sciencecraft.Sciencecraft;
import com.samfisher39.sciencecraft.init.SciencecraftItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SciencecraftTab extends CreativeTabs{

	public SciencecraftTab(String name) {
		super(Sciencecraft.MODID + "." + name);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SciencecraftItems.ELECTRON_ITEM);
	}
	
}
