package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class RedPot extends Food implements Useable {

	public RedPot(Character owner) {
		super(owner);
		this.Heal = 150;
		this.Mana = 0;
		this.name = "Red potion";
		this.Description = "It bubbles a little bit like a soda.";
	}

	@Override
	public void beUsed() {
		System.out.println("It had a funny taste but you feel spectacular."
				+ " You healed "+this.Heal+" HP.");
		this.Owner.setHP(this.Owner.getHP()+this.Heal);
		this.Owner.inventory.remove(this);
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
