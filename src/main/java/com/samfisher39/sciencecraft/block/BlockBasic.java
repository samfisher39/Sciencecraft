package com.samfisher39.sciencecraft.block;

import com.samfisher39.sciencecraft.Sciencecraft;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block{
	
	public BlockBasic(Material material, String unlocalizedName, String registryName) {
		this(material, SoundType.STONE, unlocalizedName, registryName);
	}
	
	public BlockBasic(Material material, SoundType soundtype, String unlocalizedName, String registryName) {
		super(material);
		setUnlocalizedName(Sciencecraft.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(Sciencecraft.SCIENCECRAFT_TAB);
		setSoundType(soundtype);
	}

}
