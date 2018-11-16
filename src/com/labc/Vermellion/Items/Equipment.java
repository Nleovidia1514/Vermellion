package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Character;

public abstract class Equipment extends Item {
	public int HP, MAGIC, ILLUSION, SNEAK, BLOCK, STR, BAGREDAD, ACCURACY,RESISTANCE;
	protected int Category;
	public boolean isEquipped;
	protected String regularName;
	public static int weapon = 0, helmet = 1, chestplate = 2, leggings = 3, footWear = 4; 
	
	public Equipment(Character owner) {
		super(owner);
	}
	
	protected int Damage;
	protected int Durability;
	
	public void equip() {
		if(this.getOwner().equipment[this.Category]==null)
		{
			this.isEquipped = true;
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
			this.getOwner().equipment[this.Category] = this.getRegularName();
			Start.ta.setText("You equipped "+this.regularName+".");
		}
		else
		{
			Start.ta.setText("You must unequip "+this.getOwner().equipment[this.Category]+" first to do that.");
		}
	}

	public void unEquip() {
		if(this.getOwner().equipment[this.Category]!=null && this.isEquipped == true) 
		{
			this.isEquipped = false;
			this.name = this.regularName;
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
			Start.ta.setText("You unequipped "+this.getName());
		}
		else
		{
			Start.ta.setText("You don't have that equipped.");
		}
	}
	protected void broke() {
		Start.ta.append("\nYour "+this.regularName+" has broken.");
		this.getOwner().inventory.remove(this);
		if(this.isEquipped)
			this.unEquip();
	}
	
	public int getCategory() {
		return this.Category;
	}
	
	public void reduceDurability() {
		this.Durability--;
	}
	
	@Override
	public void getStats() {
		Start.ta.setText(this.name);
		Start.ta.append("\n"+this.Description);
		Start.ta.append("\nHP: "+this.HP);
		Start.ta.append("\nMAGIC: "+this.MAGIC);
		Start.ta.append("\nSTR: "+this.STR);
		Start.ta.append("\nSNEAK: "+this.SNEAK);
		Start.ta.append("\nBLOCK: "+this.BLOCK);
		Start.ta.append("\nACCURACY: "+this.ACCURACY);
		Start.ta.append("\nILLUSION: "+this.ILLUSION);
		Start.ta.append("\nBAGREDAD: "+this.BAGREDAD);
		Start.ta.append("\nRESISTANCE: "+this.RESISTANCE);
		Start.ta.append("\nDamage: "+this.Damage);
		Start.ta.append("\nDurability: "+this.Durability);
	}
	
	public String getRegularName() {
		return this.regularName;
	}
}
