package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class GreenPot extends Food implements Useable {

	public GreenPot(Character owner) {
		super(owner);
		this.Heal = 100;
		this.Mana = 100;
		this.name = "Green potion";
		this.Description = "It's definitly green.";
	}

	@Override
	public void beUsed() {
		System.out.println("You almost vomit but you managed not too. You healed "
				+this.Heal+ " and restored "+this.Mana+" MAGIC.");
		this.Owner.setHP(this.Owner.getHP()+this.Heal);
		this.Owner.setMagic(this.Owner.getMagic()+this.Mana);
		this.Owner.inventory.remove(this);
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
