package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class BluePot extends Food implements Useable {

	public BluePot(Character owner) {
		super(owner);
		this.Heal = 0;
		this.Mana = 80;
		this.name = "Blue potion";
		this.Description = "It has a label on it... 'Made in China'.";
	}

	@Override
	public void beUsed() {
		System.out.println("You drank the potion. It left you a bit dazzled\n"
				+ "You restored "+this.Mana+" MAGIC.");
		this.Owner.setMagic(this.Owner.getMagic()+this.Mana);
		this.Owner.inventory.remove(this);
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
