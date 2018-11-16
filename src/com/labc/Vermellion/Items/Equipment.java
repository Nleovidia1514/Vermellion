package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Character;

public abstract class Equipment extends Item {
	public int HP, MAGIC, ILLUSION, SNEAK, BLOCK, STR, BAGREDAD, ACCURACY,RESISTANCE;
	protected int Category;
	public static int weapon = 0, helmet = 1, chestplate = 2, leggings = 3, footWear = 4; 
	
	public Equipment(Character owner) {
		super(owner);
	}
	
	protected int Damage;
	protected int Durability;
	
	public void equip() {
		if(this.getOwner().equipment[this.Category]==null)
		{
			this.name = this.name+"(EQUIPPED)";
			this.getOwner().setMaxHP(this.getOwner().getMaxHP()+this.HP);
			this.getOwner().setSTR(this.getOwner().getSTR()+this.STR);
			this.getOwner().setMaxMagic(this.getOwner().getMaxMagic()+this.MAGIC);
			this.getOwner().setIllusion(this.getOwner().getIllusion()+this.ILLUSION);
			this.getOwner().setBagredad(this.getOwner().getBagredad()+this.BAGREDAD);
			this.getOwner().setSneak(this.getOwner().getSneak()+this.SNEAK);
			this.getOwner().setBlock(this.getOwner().getBlock()+this.BLOCK);
			this.getOwner().setAccuracy(this.getOwner().getAccuracy()+this.ACCURACY);
			this.getOwner().setResistance(this.getOwner().getResistance()+this.RESISTANCE);
			this.getOwner().equipment[this.Category] = this.getClass().getSimpleName();
			Start.ta.setText("You equipped "+this.getClass().getSimpleName());
		}
		else
		{
			Start.ta.setText("You must unequip "+this.getOwner().equipment[this.Category]+" first to do that.");
		}
	}

	public void unEquip() {
		if(this.getOwner().equipment[this.Category]!=null) 
		{
			this.name = this.getClass().getSimpleName();
			this.getOwner().setMaxHP(this.getOwner().getMaxHP()-this.HP);
			this.getOwner().setSTR(this.getOwner().getSTR()-this.STR);
			this.getOwner().setResistance(this.getOwner().getResistance()-this.RESISTANCE);
			this.getOwner().setMaxMagic(this.getOwner().getMaxMagic()-this.MAGIC);
			this.getOwner().setIllusion(this.getOwner().getIllusion()-this.ILLUSION);
			this.getOwner().setBagredad(this.getOwner().getBagredad()-this.BAGREDAD);
			this.getOwner().setSneak(this.getOwner().getSneak()-this.SNEAK);
			this.getOwner().setBlock(this.getOwner().getBlock()-this.BLOCK);
			this.getOwner().setAccuracy(this.getOwner().getAccuracy()-this.ACCURACY);
			this.getOwner().equipment[this.Category] = null;
			this.getOwner().setHP(this.getOwner().getMaxHP());
			this.getOwner().setMagic(this.getOwner().getMaxMagic());
			Start.ta.setText("You unequipped "+this.getClass().getSimpleName());
		}
		else
		{
			Start.ta.setText("You don't have that equipped.");
		}
	}
	protected void broke() {
		Start.ta.append("\nYour "+this.getClass().getSimpleName()+" has broken.");
		this.getOwner().inventory.remove(this);
	}
	
	public int getCategory() {
		return this.Category;
	}
	
	public void reduceDurability() {
		this.Durability--;
	}
}
