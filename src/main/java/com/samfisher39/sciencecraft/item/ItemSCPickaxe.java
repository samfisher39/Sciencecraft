package com.samfisher39.sciencecraft.item;

import com.samfisher39.sciencecraft.Sciencecraft;
import com.samfisher39.sciencecraft.library.ToolCore;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSCPickaxe extends ItemPickaxe {
	
	private int breakRange;
	private int breakDepth;
	private ToolCore toolCoreLib = new ToolCore();

	public ItemSCPickaxe(ToolMaterial material, String unlocalizedName, String registryName, int range, int depth) {
		
		super(material);
		
		setUnlocalizedName(Sciencecraft.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(Sciencecraft.SCIENCECRAFT_TAB);
		this.attackSpeed = 0.1f;
		this.breakRange = range;
		this.breakDepth = depth;
	
	}
	
	/**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     * 
     */
	@Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving){
		
        if (!worldIn.isRemote && (double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(0, entityLiving);
        	toolCoreLib.DestroyAOEBlocks(stack, worldIn, state, pos, entityLiving, breakRange, breakDepth);
        }

        return true;
    }
}
