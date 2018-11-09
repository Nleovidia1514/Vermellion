package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Apple extends Food implements Useable{

	public Apple(Character owner) {
		super(owner);
		this.Heal = 30;
		this.Mana = 0;
		this.name = "Apple";
		this.Description = "It's green?";
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		System.out.println("You ate the apple... it had an odd taste. You healed "+this.Heal+" HP.");
		this.Owner.setHP(this.Owner.getHP()+this.Heal);
		this.Owner.inventory.remove(this);
	}

}
