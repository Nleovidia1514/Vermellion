package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Chicha extends Food implements Useable{

	public Chicha(Character owner) {
		super(owner);
		this.Heal = 60;
		this.Mana = 30;
		this.name = "Chicha";
		this.Description = "Venezuelans love this beverage... or is it a smoothie?";
	}

	@Override
	public void beUsed() {
		System.out.println("Damn it tastes good. You healed "+this.Heal+" HP"
				+"and restored "+this.Mana+" MAGIC.");
		this.Owner.setHP(this.Owner.getHP()+this.Heal);
		this.Owner.setMagic(this.Owner.getMagic()+this.Mana);
		this.Owner.inventory.remove(this);
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
