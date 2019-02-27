package com.samfisher39.sciencecraft.item;

import com.samfisher39.sciencecraft.Sciencecraft;
import com.samfisher39.sciencecraft.library.ToolCore;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSuperMagnet extends Item {

	ToolCore toolCoreLib = new ToolCore();
	boolean isActive = true;
	
	public ItemSuperMagnet(String unloclizedName, String registryName) {
		
		setUnlocalizedName(Sciencecraft.MODID + "." + unloclizedName);
		setRegistryName(registryName);
		setCreativeTab(Sciencecraft.SCIENCECRAFT_TAB);
	}
	

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	
		if (entityIn instanceof EntityPlayer) {	
			EntityPlayer player = (EntityPlayer)entityIn;
			if (!player.isSneaking() && this.isActive) {
				toolCoreLib.ItemsToInventory(stack, worldIn, entityIn, itemSlot, isSelected, 10, this.isActive);
			}
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		if (!worldIn.isRemote == true && playerIn.isSneaking()) {
			this.isActive = !this.isActive;
			if(this.isActive == false) {
				Minecraft.getMinecraft().player.sendChatMessage("Deactivated magnet!");
			}
			else {
				Minecraft.getMinecraft().player.sendChatMessage("Activated magnet!");
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
}
