package com.samfisher39.sciencecraft.library;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ToolCore extends Item {

	public void DestroyAOEBlocks(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving, int breakRange, int breakDepth) 
	{
		BlockPos tmpPos = null;
        
        int offset1 = -1; 
        int offset2 = breakRange - 1;

		RayTraceResult ray = rayTrace(worldIn, Minecraft.getMinecraft().player, true);
        for (int i = offset1; i < offset2; i++) {
        	for (int j = offset1; j < offset2; j++) {
        		for (int k = 0; k < breakDepth; k++) {
            		switch (ray.sideHit) {
            		case DOWN:
						tmpPos = pos.add(i,k,j);
						break;
            		case UP:
						tmpPos = pos.add(i,-k,j);
						break;
            		case EAST:
						tmpPos = pos.add(-k,i,j);
						break;
            		case WEST:
						tmpPos = pos.add(k,i,j);
						break;
            		case NORTH:
						tmpPos = pos.add(i,j,k);
						break;
            		case SOUTH:
						tmpPos = pos.add(i,j,-k);
						break;
					default:
						break;
					}
            		if (tmpPos != null) {
            			IBlockState tmpState = worldIn.getBlockState(tmpPos);
                        Block block = tmpState.getBlock();
                        worldIn.destroyBlock(tmpPos, true);
                        worldIn.scheduleUpdate(tmpPos, block, 0);
					}						
				}
			}
		}
	}
	
	public void ItemsToInventory(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected, int range, boolean isActive) 
	{
		if (isActive) {
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)entityIn;
				double x = player.posX;
				double y = player.posY + 1.5;
				double z = player.posZ;
				
				List<EntityItem> items = entityIn.getEntityWorld().getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
				for(EntityItem e: items)
				{
					if (!player.isSneaking()) {
						player.inventory.addItemStackToInventory(e.getItem());
					}
				}
			}
		}
	}
}
