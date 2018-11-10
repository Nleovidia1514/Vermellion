package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Character;

public abstract class Food extends Item {
	protected int Heal;
	protected int Mana;
	
	public Food(Character owner) {
		super(owner);
	}
	
	public abstract void giveToNPC();
	
	@Override
	public void beUsed() {
		int hphealed = 0, magicrestored = 0;
		for(int i = 0; i<this.Heal;i++)
			while(this.Owner.getHP()<=this.Owner.getMaxHP()) {
				this.Owner.setHP(this.Owner.getHP()+1);
				hphealed++;
			}
		for(int i = 0; i<=this.Mana;i++)
			while(this.Owner.getMagic()<=this.Owner.getMaxMagic()) {
				this.Owner.setMagic(this.Owner.getMagic()+1);
				magicrestored++;
			}
		this.Owner.inventory.remove(this);
		System.out.println("You restored "+hphealed+" HP and "+magicrestored+" MAGIC.");
	}
}
