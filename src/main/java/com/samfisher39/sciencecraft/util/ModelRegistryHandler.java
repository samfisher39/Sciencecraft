package com.samfisher39.sciencecraft.util;

import com.samfisher39.sciencecraft.init.SciencecraftBlocks;
import com.samfisher39.sciencecraft.init.SciencecraftItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(Side.CLIENT)
public class ModelRegistryHandler {
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {

		registerModel(SciencecraftItems.NEUTRON_ITEM);
		registerModel(SciencecraftItems.ELECTRON_ITEM);
		registerModel(SciencecraftItems.PROTON_ITEM);
		registerModel(SciencecraftItems.SUPERMAGNET_ITEM);
		registerModel(SciencecraftItems.PICKAXE_NEUTRON);
		registerModel(SciencecraftItems.PICKAXE_ELECTRON);
		registerModel(SciencecraftItems.PICKAXE_PROTON);
		
		registerModel(Item.getItemFromBlock(SciencecraftBlocks.BASIC_BLOCK));
		
	}
	
	public static void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
