package com.samfisher39.sciencecraft.util;

import com.samfisher39.sciencecraft.block.BlockBasic;
import com.samfisher39.sciencecraft.init.SciencecraftBlocks;
import com.samfisher39.sciencecraft.item.ItemBasic;
import com.samfisher39.sciencecraft.item.ItemSCPickaxe;
import com.samfisher39.sciencecraft.item.ItemSuperMagnet;
import com.samfisher39.sciencecraft.materials.SciencecraftMaterials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		
		final Block[] blocks = {
				new BlockBasic(Material.ROCK, "blockBasic", "basic_block")
		};
		
		event.getRegistry().registerAll(blocks);
		
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		
		final Item[] items = {
				new ItemBasic("itemNeutron", "neutron_item"),
				new ItemBasic("itemElectron", "electron_item"),
				new ItemBasic("itemProton", "proton_item"),
				new ItemSuperMagnet("itemSuperMagnet", "supermagnet_item"),
				new ItemSCPickaxe(SciencecraftMaterials.SC_NEUTRON_MATERIAL, "neutronPickaxe", "pickaxe_neutron", 1, 1),
				new ItemSCPickaxe(SciencecraftMaterials.SC_ELECTRON_MATERIAL, "electronPickaxe", "pickaxe_electron", 3, 3),
				new ItemSCPickaxe(SciencecraftMaterials.SC_PROTON_MATERIAL, "protonPickaxe", "pickaxe_proton", 5, 5)
		};
		
		final Item[] itemBlocks = {
				new ItemBlock(SciencecraftBlocks.BASIC_BLOCK).setRegistryName(SciencecraftBlocks.BASIC_BLOCK.getRegistryName())
		};
		
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
		
	}
	
}
