package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class SpaghettiOs extends Food implements Useable {

	public SpaghettiOs(Character owner) {
		super(owner);
		this.Heal = 200;
		this.Mana = 100;
		this.name = "SpaghettiOs";
		this.Description = "Every american child's favorite breakfast.";
	}

	@Override
	public void beUsed() {
		System.out.println("You consumed the "+this.name+" and you feel like a child in El Imperio."
				+ " You healed "+this.Heal+" HP and restored "+this.Mana+" MAGIC.");
		this.Owner.setHP(this.Owner.getHP()+this.Heal);
		this.Owner.setMagic(this.Owner.getMagic()+this.Mana);
		this.Owner.inventory.remove(this);
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}
	
}
