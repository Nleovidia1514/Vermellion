package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;

public abstract class Food extends Item {
	protected int Heal;
	protected int Mana;
	protected int water;
	
	public Food(Character owner) {
		super(owner);
		this.isEatable = false;
		this.isDrinkable = false;
	}
	
	public abstract void giveToNPC();
	
	@Override
	public void beUsed(Entity mob) {
		int hphealed = 0, magicrestored = 0; int thirstrestored = 0;
		while(hphealed<this.Heal && this.getOwner().getHP()<this.getOwner().getMaxHP()) {
			this.getOwner().setHP(this.getOwner().getHP()+1);
			hphealed++;
		}
		
		while(magicrestored<this.Mana && this.getOwner().getMagic()<this.getOwner().getMaxMagic()) {
			this.getOwner().setMagic(this.getOwner().getMagic()+1);
			magicrestored++;
		}

		while(thirstrestored<this.water && this.getOwner().getThirst()<this.getOwner().getMaxThirst()) {
			this.getOwner().setThirst(this.getOwner().getThirst()+1);
			thirstrestored++;
		}
			
		this.getOwner().inventory.remove(this);
		Start.ta.append("\nYou restored "+hphealed+" HP, "+magicrestored+" MAGIC"
				+ " and "+thirstrestored+" thirst");
	}
}
